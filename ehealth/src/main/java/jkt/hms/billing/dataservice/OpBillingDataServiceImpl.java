/** * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * OpBillingDataServiceImpl.java
 * Purpose of the class - This is for OP Billing.
 * @author  Ritu Sahu
 * Create Date: 12th Jan,2009
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.billing.dataservice;

import static jkt.hms.util.RequestConstants.ADVANCE_ADJUSTMENT;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.AMOUNT_RECEIVED;
import static jkt.hms.util.RequestConstants.AUTHORIZER_ID;
import static jkt.hms.util.RequestConstants.BANK_ID;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.BATCH_ID;
import static jkt.hms.util.RequestConstants.BATCH_ITEM_ID;
import static jkt.hms.util.RequestConstants.BILL_AMOUNT;
import static jkt.hms.util.RequestConstants.BILL_ID;
import static jkt.hms.util.RequestConstants.BILL_NO;
import static jkt.hms.util.RequestConstants.BILL_TYPE;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.COMPANY;
import static jkt.hms.util.RequestConstants.DISCOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_AMOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_ON_BILL;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ISSUE_QUANTITY;
import static jkt.hms.util.RequestConstants.NET_AMOUNT;
import static jkt.hms.util.RequestConstants.OUTSTANDING;
import static jkt.hms.util.RequestConstants.PAID_AMOUNT;
import static jkt.hms.util.RequestConstants.PAYABLE_AMOUNT;
import static jkt.hms.util.RequestConstants.PAYMENT_ADVICE_DISPENSING_ID;
import static jkt.hms.util.RequestConstants.PAYMENT_ADVICE_ID;
import static jkt.hms.util.RequestConstants.PAYMENT_ADVICE_NO;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.PERSON_COLLECTED_AMT;
import static jkt.hms.util.RequestConstants.PRESCRIPTION_NO;
import static jkt.hms.util.RequestConstants.PROPORTIONAL_DISCOUNT;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.RATE;
import static jkt.hms.util.RequestConstants.REFUND_AMOUNT;
import static jkt.hms.util.RequestConstants.REFUND_DATE;
import static jkt.hms.util.RequestConstants.REFUND_TIME;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.ROUND_OF_VALUE;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.VISIT_ID;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import jkt.hms.adt.dataservice.ADTDataService;
import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlCompanySettlementDetails;
import jkt.hms.masters.business.BlCompanySettlementHeader;
import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlPaymentAdviceDetails;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPymntAdviceDispDetails;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.BlRefundDetails;
import jkt.hms.masters.business.BlRefundHeader;
import jkt.hms.masters.business.BlTempBillDispensingDetails;
import jkt.hms.masters.business.BlTempOpBillDetails;
import jkt.hms.masters.business.BlTempOpBillHeader;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpWardConsumptionHeader;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasCharityType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasHospitalwiseChargecode;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientCategory;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OpdTemplateInvestigation;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAdvanceTransfer;
import jkt.hms.masters.business.PatientBalance;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.dataservice.BillingMasterDataService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
//commented for maven
/*import org.junit.experimental.categories.Categories;*/
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class OpBillingDataServiceImpl extends HibernateDaoSupport implements
		OpBillingDataService {
	ADTDataService adtDataService = null;
	BillingDataService billingDataService = null;
	BillingMasterDataService billingMasterDataService = null;

	public ADTDataService getAdtDataService() {
		return adtDataService;
	}

	public void setAdtDataService(ADTDataService adtDataService) {
		this.adtDataService = adtDataService;
	}

	public BillingDataService getBillingDataService() {
		return billingDataService;
	}

	public void setBillingDataService(BillingDataService billingDataService) {
		this.billingDataService = billingDataService;
	}

	public BillingMasterDataService getBillingMasterDataService() {
		return billingMasterDataService;
	}

	public void setBillingMasterDataService(
			BillingMasterDataService billingMasterDataService) {
		this.billingMasterDataService = billingMasterDataService;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.billing.dataservice.OpBillingDataService#searchOPBillServicing
	 * (java.util.Map)
	 */
	public Map<String, Object> searchOPBillServicing(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
		List<MasHospital> instituteList = new ArrayList<MasHospital>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		String patientName = "";
		String uhid = "";

		String mobile = "";
		int districtId = 0;
		int hospitalTypeId = 0;
		int hospitalId = 0;

		uhid = box.getString("uhid");
		patientName = box.getString("patientName");
		mobile = box.get("mobile");

		districtId = box.getInt("districtId");
		hospitalTypeId = box.getInt("instTypeId");
		hospitalId = box.getInt("hospitalId");
		int sessionHospitalId = box.getInt("sessionHospitalId");

		Criteria crit = null;
		crit = session.createCriteria(DgOrderhd.class).createAlias("Hin", "h")
				.createAlias("PrescribedBy", "pres")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("OrderStatus", "p").ignoreCase());
		if (hospitalId != 0) {
			crit = crit.add(Restrictions.eq("Hospital.Id", hospitalId));

		} else {
			crit = crit.add(Restrictions.eq("Hospital.Id", sessionHospitalId));
		}
		if (!uhid.equals("")) {
			crit = crit.add(Restrictions.eq("h.HinNo", uhid)).add(
					Restrictions.eq("OrderStatus", "p").ignoreCase());
		}
		if (!patientName.equals("")) {
			crit = crit.add(
					Restrictions.ilike("h.PFirstName", patientName + "%")).add(
					Restrictions.eq("OrderStatus", "p").ignoreCase());
		}

		if (!mobile.equals("")) {
			crit = crit.add(Restrictions.eq("h.MobileNumber", mobile)).add(
					Restrictions.eq("OrderStatus", "p").ignoreCase());

		}

		dgOrderhdList = crit.list();
		for (DgOrderhd dgo : dgOrderhdList) {
			Patient pat = dgo.getHin();
			patientList.add(pat);

		}
		map.put("patientList", patientList);

		return map;

	}

	/*
	 * public Map<String, Object> showOPBillServecing( Map<String, Object>
	 * parameterMap) {
	 * 
	 * Session session = (Session) getSession();
	 * 
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * List<MasHospital> hospitalNameList = new ArrayList<MasHospital>(); String
	 * patientName = ""; String hinNo = "";
	 * 
	 * String hospitalName = "";
	 * 
	 * 
	 * if(null !=parameterMap){ patientName=(String)
	 * parameterMap.get("patientName");
	 * 
	 * hospitalName=(String) parameterMap.get("hospitalName");
	 * 
	 * }
	 * 
	 * 
	 * hospitalNameList = session.createCriteria(MasHospital.class)
	 * .add(Restrictions.eq("Status", "y")
	 * .ignoreCase()).addOrder(Order.asc("HospitalName")).list();
	 * map.put("hospitalNameList", hospitalNameList);
	 * 
	 * return map;
	 * 
	 * }
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getReferedPatient(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * List<OpdPatientDetails> patientDetailList = new
		 * ArrayList<OpdPatientDetails>(); Session session = (Session)
		 * getSession(); try { patientDetailList =
		 * session.createCriteria(OpdPatientDetails.class)
		 * .add(Restrictions.eq("BillStatus", "n")).list(); } catch (Exception
		 * e) { e.printStackTrace(); }
		 * System.out.println("patientDetailList------>"
		 * +patientDetailList.size()); map.put("patientDetailList",
		 * patientDetailList);
		 */

		Session session = (Session) getSession();
		String uhid = box.getString(HIN_NO);
		String patientName = box.getString("pName");
		String mobile = box.getString("mobile");
		int hospitalId = box.getInt(HOSPITAL_ID);
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Criteria crit = null;
		Calendar calender=Calendar.getInstance();
		calender.add(Calendar.DAY_OF_MONTH, -2);
		
		String billService = "lab";
		if(!box.getString("billService").equals(""))
			billService = box.getString("billService");
		
		if(billService.equalsIgnoreCase("lab")){

			List<MasChargeCode>masChargeCodes=new ArrayList<MasChargeCode>();
			masChargeCodes=session.createCriteria(MasHospitalwiseChargecode.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.setProjection(Projections.property("ChargeCode"))
					.list();
			System.out.println("ppihf"+masChargeCodes.size());
			if(masChargeCodes.size()>0)
			{
				crit = session.createCriteria(DgOrderdt.class, "orderdt")
						.createAlias("orderdt.Orderhd", "orderhd")
						.createAlias("orderhd.Hospital", "hospital")
						.createAlias("orderhd.Visit", "visit") // added by amit das on 27-06-2016
						.createAlias("orderhd.Visit.OpdPatientDetails", "opdPatientDetails",CriteriaSpecification.LEFT_JOIN) // added by amit das on 27-06-2016
						.createAlias("orderhd.Hin", "h")
						.add(Restrictions.eq("orderhd.OrderStatus", "P"))
						.add(Restrictions.in("ChargeCode", masChargeCodes))
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.ge("orderhd.OrderDate", calender.getTime()))
						.add(Restrictions.isNotNull("orderhd.Visit"))
						.add(Restrictions.eq("orderdt.PaymentMade", "n").ignoreCase());
			}
			else
			{
				crit = session.createCriteria(DgOrderdt.class, "orderdt")
						.createAlias("orderdt.Orderhd", "orderhd")
						.createAlias("orderhd.Hospital", "hospital")
						.createAlias("orderhd.Visit", "visit") // added by amit das on 27-06-2016
						.createAlias("orderhd.Hin", "h")
						//.add(Restrictions.in("ChargeCode", masChargeCodes))
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.ge("orderhd.OrderDate", calender.getTime()))
						.add(Restrictions.isNotNull("orderhd.Visit"))
						.add(Restrictions.eq("orderhd.OrderStatus", "P"))
						.add(Restrictions.eq("orderdt.PaymentMade", "n").ignoreCase());}

			if (!uhid.equals("")) {
				crit = crit.add(Restrictions.eq("h.HinNo", uhid));
			}
			if (!patientName.equals("")) {
				crit = crit.add(Restrictions.like("h.PFirstName",
						"%" + patientName.toLowerCase() + "%").ignoreCase()); 
			}
			if (!mobile.equals("")) {
				crit = crit.add(Restrictions.eq("h.MobileNumber", mobile));
			}
			if(uhid.equals("") || patientName.equals("")||mobile.equals("") )
			{
				crit.setProjection(Projections.projectionList().add(
						Projections.groupProperty("orderdt.Orderhd")));}
			dgOrderhdList = crit.list();
			map.put("dgOrderhdList", dgOrderhdList);
		}else if(billService.equalsIgnoreCase("nursing")){
			Criteria procCrit = null;
			List<ProcedureHeader> procedureList = new ArrayList<ProcedureHeader>();
			procCrit = session.createCriteria(ProcedureDetails.class)
					.createAlias("ProcedureHeader", "ph").createAlias("ph.Hin", "p").createAlias("ph.Hospital", "h")
					.add(Restrictions.eq("BillStatus", "p").ignoreCase()).add(Restrictions.eq("h.Id", hospitalId));
			if (!uhid.equals("")) {
				procCrit = procCrit.add(Restrictions.eq("p.HinNo", uhid));
			}
			if (!patientName.equals("")) {
				procCrit = procCrit.add(Restrictions.like("p.PFirstName",
						"%" + patientName.toLowerCase() + "%").ignoreCase()); 
			}
			if (!mobile.equals("")) {
				procCrit = procCrit.add(Restrictions.eq("p.MobileNumber", mobile));
			}
			procCrit = procCrit.setProjection(Projections.projectionList().add(
					Projections.groupProperty("ProcedureHeader")));

			procedureList = procCrit.list();
			map.put("procedureList", procedureList);
		}else if(billService.equalsIgnoreCase("surgical")){

			Criteria surgeryCrit = null;
			List<OpdSurgeryHeader> surgeryList = new ArrayList<OpdSurgeryHeader>();
			surgeryCrit = session.createCriteria(OpdSurgeryHeader.class).add(Restrictions.eq("PatientStatus", "OP").ignoreCase())
					.createAlias("Hin", "p").createAlias("Hospital", "h")
					.add(Restrictions.eq("BillingStatus", "n").ignoreCase()).add(Restrictions.eq("h.Id", hospitalId));
			if (!uhid.equals("")) {
				surgeryCrit = surgeryCrit.add(Restrictions.eq("p.HinNo", uhid));
			}
			if (!patientName.equals("")) {
				surgeryCrit = surgeryCrit.add(Restrictions.like("p.PFirstName",
						"%" + patientName.toLowerCase() + "%").ignoreCase()); 
			}
			if (!mobile.equals("")) {
				surgeryCrit = surgeryCrit.add(Restrictions.eq("p.MobileNumber", mobile));
			}
		
			surgeryList = surgeryCrit.list();
			map.put("surgeryList", surgeryList);
		
		}
		return map;
	}

	/**
	 * Method to get patient details for Billing Servicing
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForOpBilling(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Object[]> masPTypeList = new ArrayList<Object[]>();
		List<Object[]> masPTypeLists = new ArrayList<Object[]>();
		List<Object[]> masPTypeListo = new ArrayList<Object[]>();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
		List<Object[]> mainChargeCodeList = new ArrayList<Object[]>();
		List<Object[]> subChargeCodeList = new ArrayList<Object[]>();
		List<Object[]> authorizerList = new ArrayList<Object[]>();
		List<Object[]> bankList = new ArrayList<Object[]>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<DgOrderdt> orderdtList = new ArrayList<DgOrderdt>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<Patient> inpatientList = new ArrayList<Patient>();
		List<Integer> maxVisitList = new ArrayList<Integer>();
		List<Visit> lastVisitDetails = new ArrayList<Visit>();
		List<Object[]> masCharityList = new ArrayList<Object[]>();
		List<PatientBalance> patientBalances = new ArrayList<PatientBalance>();
		List<BlOpBillHeader> opBillHeaders = new ArrayList<BlOpBillHeader>(); // Added by Amit Das on 03-02-2016
		List<ProcedureHeader> procHdList = new ArrayList<ProcedureHeader>();
		List<ProcedureDetails> procDtList = new ArrayList<ProcedureDetails>();
		List<OpdSurgeryHeader> surgeryHdList = new ArrayList<OpdSurgeryHeader>();
		List<OpdSurgeryDetail> surgeryDtList = new ArrayList<OpdSurgeryDetail>();

		
		
		Session session = getSession();
		int hospitalId=(Integer)parameterMap.get(HOSPITAL_ID);
		String maxBlNo = "";

		String orderNo = "";
		String hinNo = "";
		String tempBillNo = "";
		int orderId = 0;
		String billService = "";
		
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		if (parameterMap.get("orderNo") != null) {
			orderNo = (String) parameterMap.get("orderNo");
		}
		if (parameterMap.get("tempBillNo") != null) {
			tempBillNo = (String) parameterMap.get("tempBillNo");
		}
		if (parameterMap.get("orderId") != null) {
			orderId = (Integer) parameterMap.get("orderId");
		}
		if (parameterMap.get("billService") != null) {
			billService = (String) parameterMap.get("billService");
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (!hinNo.equals("")) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.eq("PatientStatus", "Out Patient"))
						.list();

				maxVisitList = session.createCriteria(Visit.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.HinNo", hinNo))
						.setProjection(Projections.max("Id")).list();
				

				if (maxVisitList.size() > 0) {
					lastVisitDetails = session.createCriteria(Visit.class)
							.add(Restrictions.idEq(maxVisitList.get(0))).list();
					
					if (lastVisitDetails.size() > 0) 
						map.put("lastVisitDetails", lastVisitDetails);
					
				}
			}
			
			if (orderId != 0) {
				if(billService.equalsIgnoreCase("lab")){
					orderHdList = session
							.createCriteria(DgOrderhd.class)
							.add(Restrictions.eq("Id", orderId))
							.createAlias("Hin", "p")
							.add(Restrictions.eq("p.PatientStatus", "Out Patient")
									.ignoreCase())
									.list();



					if (orderHdList.size() > 0) {

						DgOrderhd orderHd = new DgOrderhd();
						orderHd = orderHdList.get(0);
						//Hibernate.initialize(orderHd.getDgOrderdts());
						Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
						patientList.add(orderHd.getHin());
						orderDtSet = orderHd.getDgOrderdts();

						for (DgOrderdt orderDt : orderDtSet) {
							if (orderDt.getPaymentMade().equals("n")) {
								// if
								// (orderDt.getChargeCode().getChargeType().getChargeTypeCode().equals("DIAG")
								// && ) {
								int chargeCodeId=orderDt.getChargeCode().getId();
								List<MasHospitalwiseChargecode> list=session.createCriteria(MasHospitalwiseChargecode.class)
										.setProjection(Projections.projectionList().add(Projections.property("Id")))
										.add(Restrictions.eq("Hospital.Id", hospitalId))
										.add(Restrictions.eq("ChargeCode.Id",chargeCodeId))
										.list();

								if(list.size()>0 && !orderDt.getOrderStatus().equalsIgnoreCase("J")){ // order status condition added by amit das on 07-06-2016
									orderdtList.add(orderDt);	
								}

								map.put("orderHdList", orderHdList);
								map.put("orderdtList", orderdtList);
							}
						}
					}
				}else if(billService.equalsIgnoreCase("nursing")){
					procHdList = session.createCriteria(ProcedureHeader.class)
							.add(Restrictions.eq("Id", orderId)).createAlias("Hin", "p")
							.add(Restrictions.eq("p.PatientStatus", "Out Patient").ignoreCase()).list();

					if (procHdList.size() > 0) {

						ProcedureHeader procedureHd = new ProcedureHeader();
						procedureHd = procHdList.get(0);
						patientList.add(procedureHd.getHin());
						Set<ProcedureDetails> procedureDtSet = new HashSet<ProcedureDetails>();
						procedureDtSet = procedureHd.getProcedureDetails();

						for (ProcedureDetails procedureDt : procedureDtSet) {
							if (procedureDt.getBillStatus().equalsIgnoreCase("p")) {
								if(procedureDt.getProcedure().getChargeCode()!=null){
									int chargeCodeId=procedureDt.getProcedure().getChargeCode().getId();
									List<MasHospitalwiseChargecode> list=session.createCriteria(MasHospitalwiseChargecode.class)
											.setProjection(Projections.projectionList().add(Projections.property("Id")))
											.add(Restrictions.eq("Hospital.Id", hospitalId))
											.add(Restrictions.eq("ChargeCode.Id",chargeCodeId))
											.list();

									if(list.size()>0){ 
										procDtList.add(procedureDt);	
									}

									map.put("procDtList", procDtList);
									map.put("procHdList", procHdList);
								}
							}
						}
					}
				}else if(billService.equalsIgnoreCase("surgical")){
					surgeryHdList = session.createCriteria(OpdSurgeryHeader.class)
							.add(Restrictions.eq("Id", orderId))
							.add(Restrictions.eq("PatientStatus", "OP").ignoreCase()).list();

					if (surgeryHdList.size() > 0) {

						OpdSurgeryHeader surgeryHd = new OpdSurgeryHeader();
						surgeryHd = surgeryHdList.get(0);
						patientList.add(surgeryHd.getHin());
						Set<OpdSurgeryDetail> surgeryDtSet = new HashSet<OpdSurgeryDetail>();
						surgeryDtSet = surgeryHd.getOpdSurgeryDetails();

						for (OpdSurgeryDetail surgeryDt : surgeryDtSet) {
								if(surgeryDt.getChargeCode()!=null){
									int chargeCodeId=surgeryDt.getChargeCode().getId();
									List<MasHospitalwiseChargecode> list=session.createCriteria(MasHospitalwiseChargecode.class)
											.setProjection(Projections.projectionList().add(Projections.property("Id")))
											.add(Restrictions.eq("Hospital.Id", hospitalId))
											.add(Restrictions.eq("ChargeCode.Id",chargeCodeId))
											.list();

									if(list.size()>0){ 
										surgeryDtList.add(surgeryDt);	
									}

									map.put("surgeryHdList", surgeryHdList);
									map.put("surgeryDtList", surgeryDtList);
								}
							}
						}
					}
				
				
			}
			/*
			 * if (!tempBillNo.equals("")) { tempBillList =
			 * session.createCriteria(BlTempOpBillHeader.class)
			 * .add(Restrictions.eq("TempBillNo", tempBillNo))
			 * .createAlias("Hin", "p").add( Restrictions.eq("p.PatientStatus",
			 * "Out Patient")).list(); if (tempBillList.size() > 0) {
			 * BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
			 * tempOpBillHeader = tempBillList.get(0);
			 * patientList.add(tempOpBillHeader.getHin());
			 * map.put("tempBillList", tempBillList); }
			 * 
			 * }
			 */
			if (patientList.size() > 0) {
				map.put("patientList", patientList);
			} else {
				inpatientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.eq("PatientStatus", "In Patient"))
						.list();
				if (inpatientList.size() > 0) {
					map.put("inpatientList", inpatientList);
				}
			}
			
			// edited by amit das on 22-08-2016
			// Added by Amit Das on 02-03-2016
			if(orderHdList.size()!=0 ){
				List<Object> list =	session.createCriteria(BlOpBillHeader.class).setProjection(Projections.projectionList().add(Projections.property("Scheme")))
						.add(Restrictions.eq("Visit", orderHdList.get(0).getVisit())).list();
				if(list.size()!=0){
					map.put("patientOpBillHeader", list.get(0));
				}
			}else if(procHdList.size()!=0 ){
				List<Object> list =	session.createCriteria(BlOpBillHeader.class).setProjection(Projections.projectionList().add(Projections.property("Scheme")))
						.add(Restrictions.eq("Visit", procHdList.get(0).getVisit())).list();
				if(list.size()!=0){
					map.put("patientOpBillHeader", list.get(0));
				}
			}else if(surgeryHdList.size()!=0 ){
				List<Object> list =	session.createCriteria(BlOpBillHeader.class).setProjection(Projections.projectionList().add(Projections.property("Scheme")))
						.add(Restrictions.eq("Visit", surgeryHdList.get(0).getVisit())).list();
				if(list.size()!=0){
					map.put("patientOpBillHeader", list.get(0));
				}
			}
			
			
			
			
			
			masPTypeList = session.createCriteria(MasPatientType.class).setProjection(Projections.projectionList().add(Projections.property("PatientTypeName")).add(Projections.property("PatientTypeCode")))
					.add(Restrictions.eq("Type", "F").ignoreCase()).list();
			masPTypeLists = session.createCriteria(MasPatientType.class).setProjection(Projections.projectionList().add(Projections.property("PatientTypeName")).add(Projections.property("PatientTypeCode")))
					.add(Restrictions.eq("Type", "S").ignoreCase()).list();
			masPTypeListo = session.createCriteria(MasPatientType.class).setProjection(Projections.projectionList().add(Projections.property("PatientTypeName")).add(Projections.property("PatientTypeCode")))
					.add(Restrictions.eq("Type", "O").ignoreCase()).list();
			masCharityList = session.createCriteria(MasCharityType.class).setProjection(Projections.projectionList().add(Projections.property("CharityTypeName")).add(Projections.property("CharityTypeCode")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			
			
			// discountList = session.createCriteria(MasDiscount.class).add(Restrictions.eq("Status", "y")).list();
			
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).setProjection(Projections.projectionList().add(Projections.property("MainChargecode")).add(Projections.property("SubChargecodeName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			// chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			authorizerList = session.createCriteria(MasAuthorizer.class).setProjection(Projections.projectionList().add(Projections.property("AuthorizerName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list(); // chagned by Amit Das on 21-03-2016
			
			bankList = session.createCriteria(MasBankMaster.class).setProjection(Projections.projectionList().add(Projections.property("BankName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			employeeList = session.createCriteria(MasEmployee.class).setProjection(Projections.projectionList().add(Projections.property("EmpCategory")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName")).add(Projections.property("Id")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			// templateList = session.createCriteria(OpdTemplate.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("TemplateType", "I")).list();
			
			patientBalances=session.createCriteria(PatientBalance.class).list();

			String billType = "OS";
			maxBlNo = generateBillNo(billType, "display",hospitalId);

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("patientBalances", patientBalances);
		map.put("masCharityList", masCharityList);
		map.put("masPTypeListo", masPTypeListo);
		map.put("masPTypeLists", masPTypeLists);
		map.put("masPTypeList", masPTypeList);
		//map.put("discountList", discountList);
		map.put("mainChargeCodeList", mainChargeCodeList);
		map.put("subChargeCodeList", subChargeCodeList);
		//map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("bankList", bankList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		map.put("maxBlNo", maxBlNo);
		// map.put("templateList", templateList);
		return map;
	}

	/**
	 * Method to get Charge Code for Auto complete for Billing Servicing
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		String str = "";
		if (parameterMap.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) parameterMap.get("subChargeCodeId");
		}
		if (parameterMap.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) parameterMap.get("mainChargeCodeId");
		}
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();

			if (subChargeCodeId != 0) {
				chargeCodeList = session
						.createCriteria(MasHospitalwiseChargecode.class)
						.createAlias("ChargeCode", "chc")
						.createAlias("chc.SubChargecode", "scc")
						.setProjection(Projections.property("ChargeCode"))
						.add(Restrictions.like("chc.ChargeCodeName", str)
								.ignoreCase())
						.add(Restrictions.eq("chc.Status", "y").ignoreCase())
						.add(Restrictions.eq("scc.Id", subChargeCodeId)).list();

			} else if (mainChargeCodeId != 0) {
				try {
					chargeCodeList = session
							.createCriteria(MasHospitalwiseChargecode.class)
							.createAlias("ChargeCode", "chc")
							.createAlias("chc.MainChargecode", "mcc")
							.setProjection(Projections.property("ChargeCode"))
							.add(Restrictions.like("chc.ChargeCodeName", str)
									.ignoreCase())
							.add(Restrictions.eq("chc.Status", "y").ignoreCase())
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
				chargeCodeList = session
						.createCriteria(MasHospitalwiseChargecode.class)
						.createAlias("ChargeCode", "chc")
						.setProjection(Projections.property("ChargeCode"))
						.add(Restrictions.like("chc.ChargeCodeName", str)
								.ignoreCase())
						.add(Restrictions.eq("chc.Status", "y").ignoreCase())
						.list();
			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/**
	 * Method to get Charge Code details for Billing Servicing
	 * 
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeDetails(String chargeCode, int hinId,int schemeId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = new Box("box");
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();

		try {
			
			/*chargeCodeRates = session.createCriteria(MasChargeCodeRates.class)
					.createAlias("ChargeCode", "charge")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("charge.ChargeCodeCode", chargeCode))
				.list();
		     if(chargeCodeRates.size()>0)
		     {*/
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					//commented & added by govind 20-07-2017
					//.add(Restrictions.eq("ChargeCodeCode", chargeCode))
					.add(Restrictions.eq("ChargeCodeName", chargeCode))
					//commented & added by govind 20-07-2017 end
					.list();
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode = chargeCodeList.get(0);
			int chargeId = masChargeCode.getId();
			int mainChargeId = masChargeCode.getMainChargecode().getId();
			int subChargeId = masChargeCode.getSubChargecode().getId();

			if (hinId != 0) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
			}
			if (patientList.size() > 0) {
				Patient patient = (Patient) patientList.get(0);
				int patientTypeId = 0;
				int companyId = 0;
				String regType = "";
				if (patientList.get(0).getPatientType() != null) {
					patientTypeId = patient.getPatientType().getId();
					detailsMap.put("patientTypeId", patientTypeId);
				}
				if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					detailsMap.put("companyId", companyId);
				}
				if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					detailsMap.put("regType", regType);
				}

				if (patient.getPatientStatus().equals("Out Patient")) {
					detailsMap.put("patientCategory", "OP");
				}
				if (patient.getPatientStatus().equals("In Patient")) {
					detailsMap.put("patientCategory", "IP");
				}

				List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				inpatientList = session
						.createCriteria(Inpatient.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.or(Restrictions.eq("AdStatus", "R"),
								Restrictions.eq("AdStatus", "A"))).list();

				if (inpatientList.size() > 0) {
					Inpatient inpatient = inpatientList.get(0);
					// box.put(INPATIENT_ID, inpatient.getId());
					detailsMap.put(INPATIENT_ID, inpatient.getId());
					detailsMap.put("roomTypeId", inpatient.getBed().getRoom()
							.getRoomType().getId());
				}
			}
			detailsMap.put("chargeId", chargeId);
			detailsMap.put("mainChargeId", mainChargeId);
			detailsMap.put("subChargeId", subChargeId);
			detailsMap.put("billTypeId", 2);
			detailsMap.put("schemeId", schemeId); // added by amit das on 26-05-2016
			detailsMap.put(HIN_ID, hinId);
			// box.put(HIN_ID, hinId);
			detailsMap.put(RequestConstants.CHARGE_ID, chargeId);
			// box.put(RequestConstants.CHARGE_ID, RequestConstants.CHARGE_ID);

			// detailsMap.put("discountList",
			// billingMasterDataService.serviceDispensingAutoBilling(box));
			detailsMap.put("chargeCode", masChargeCode);
			detailsMap.put(HOSPITAL_ID, hospitalId);
			/*if(schemeId!=0)
			{
				detailsMap.put("schemeId", schemeId);
			}*/
			map = getChargeAmountAfterDiscount(detailsMap);
			map.put("chargeCodeList", chargeCodeList);
		    /* }*/
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

/*	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeAmountAfterDiscount(
			Map<String, Object> detailsMap) {

		Session session = getSession();
		int schemeId=0;
		Box box = new Box("box");
		if (detailsMap.get(INPATIENT_ID) != null) {
			box.put(INPATIENT_ID, (Integer) detailsMap.get(INPATIENT_ID));
		}
		//box.put(HOSPITAL_ID, (Integer) detailsMap.get(HOSPITAL_ID));
		box.put(HIN_ID, (Integer) detailsMap.get(HIN_ID));
		box.put(RequestConstants.CHARGE_ID,
				(Integer) detailsMap.get(RequestConstants.CHARGE_ID));
		System.out.println("schemeID"+detailsMap.get("schemeId") );
		if (detailsMap.get("schemeId") != null) {
			box.put("schemeId", (Integer) detailsMap.get("schemeId"));
			detailsMap.put("discountList",
					billingMasterDataService.serviceDispensingScheme(box));
		}
		else
		{
		detailsMap.put("discountList",
				billingMasterDataService.serviceDispensingDiscount(box));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		BigDecimal stdDeduction = new BigDecimal(0.00);
		BigDecimal chargeAfterSD = new BigDecimal(0.00);
		BigDecimal discPercnt = new BigDecimal(0);
		BigDecimal discAmt = new BigDecimal(0);
		String discTypeDB = "";
		BigDecimal chargeAmt = new BigDecimal(0.00);
		BigDecimal chargeAmt1 = new BigDecimal(0.00);
		
		BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);

		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		discountList = (List<MasDiscount>) detailsMap.get("discountList");
		MasChargeCode chargeCode = (MasChargeCode) detailsMap.get("chargeCode");
		if (chargeCode == null) {
			chargeCode = (MasChargeCode) session.get(MasChargeCode.class,
					(Integer) detailsMap.get(RequestConstants.CHARGE_ID));
		}
        List<MasChargeCodeRates> chargecodes=new ArrayList<MasChargeCodeRates>();
        chargecodes=session
				.createCriteria(MasChargeCodeRates.class).createAlias("ChargeCode", "cc")
				.add(Restrictions.eq("cc.Id",chargeCode.getId())).list();
        Set<MasChargeCodeRates> masChargeCodeRates=new HashSet<MasChargeCodeRates>();
              for(MasChargeCodeRates codeRates:masChargeCodeRates)
              {
            	  codeRates.get
              }
         
	         System.out.println(discountList.size()+"size of list"+chargecodes.size());
		if(chargecodes.size() > 0){
			for(MasChargeCodeRates chargeCodeRates :chargecodes){
				chargeAmt1 = chargeCodeRates.getRate();
				}
			}
		
		if (discountList.size() > 0) {
			MasDiscount masDiscount = discountList.get(0);
			if (masDiscount.getDiscountType().equalsIgnoreCase("d") && masDiscount.getStatus().equalsIgnoreCase("y")) {
				if (masDiscount.getDiscountPercentage() != null) {
					if(chargecodes.size() > 0){
					if(chargeAmt1!=null && chargeAmt1.compareTo(new BigDecimal(0))>=0)
					{
						chargeAfterSD = chargeAmt1;
						discPercnt = masDiscount.getDiscountPercentage();
						if(chargeAmt1!= null && chargeAmt1.compareTo(new BigDecimal(0))>=0){
							discAmt = chargeAfterSD.multiply(discPercnt).divide(
									new BigDecimal(100), 2, RoundingMode.HALF_UP);	
						}
						else
						{
							discAmt=new BigDecimal(0);
						}
						discTypeDB = masDiscount.getDiscountType();
						chargeAmountAfterDis = chargeAmt1.min(discAmt);
						System.out.println("amount"+chargeAmountAfterDis);
					}}
					else
					{
					chargeAmt = new BigDecimal(chargeCode.getCharge());
					chargeAfterSD = chargeAmt;
					discPercnt = masDiscount.getDiscountPercentage();
					if(chargeAmt!= null){
						discAmt = chargeAfterSD.multiply(discPercnt).divide(
								new BigDecimal(100), 2, RoundingMode.HALF_UP);	
					}
					else
					{
						discAmt=new BigDecimal(0);
					}
					discTypeDB = masDiscount.getDiscountType();
					chargeAmountAfterDis = chargeAmt.min(discAmt);
					System.out.println("amount"+chargeAmountAfterDis);
					}} else if (masDiscount.getDiscountValue() != null) {
						if(chargecodes.size() > 0){
						if(chargeAmt1!=null  && chargeAmt1.compareTo(new BigDecimal(0))>=0)
						{
							chargeAfterSD = chargeAmt1;
							discAmt = masDiscount.getDiscountValue();
							if (discAmt.compareTo(chargeAmt1) >= 0) {
								discAmt = chargeAmt1;
							}
							discPercnt = discAmt.multiply(new BigDecimal(100)).divide(
									chargeAmt, 2, RoundingMode.HALF_UP);
							discTypeDB = masDiscount.getDiscountType();
							chargeAmountAfterDis = chargeAmt1.min(discAmt);
							System.out.println("amount"+chargeAmountAfterDis);
						}}
						else{
					chargeAmt = new BigDecimal(chargeCode.getCharge());
					chargeAfterSD = chargeAmt;
					discAmt = masDiscount.getDiscountValue();
					if (discAmt.compareTo(chargeAmt) >= 0) {
						discAmt = chargeAmt;
					}
					discPercnt = discAmt.multiply(new BigDecimal(100)).divide(
							chargeAmt, 2, RoundingMode.HALF_UP);
					discTypeDB = masDiscount.getDiscountType();
					chargeAmountAfterDis = chargeAmt.min(discAmt);
					System.out.println("amount"+chargeAmountAfterDis);
						}}
			} else if (masDiscount.getDiscountType().equalsIgnoreCase("t") && masDiscount.getStatus().equalsIgnoreCase("y")) {

				if (masDiscount.getDiscountPercentage() != null) {
					if(chargecodes.size() > 0){
					if(chargeAmt1!=null  && chargeAmt1.compareTo(new BigDecimal(0))>=0)
					{
						chargeAfterSD = chargeAmt1;
						discPercnt = masDiscount.getDiscountPercentage().abs();
						discAmt = chargeAfterSD.multiply(discPercnt).divide(
								new BigDecimal(100), 2, RoundingMode.HALF_UP);
						
						discTypeDB = masDiscount.getDiscountType();
						chargeAmountAfterDis = chargeAmt1.add(discAmt);
						discAmt=discAmt.negate();
						discPercnt=discPercnt.negate();
					}}
					else{
					chargeAmt = new BigDecimal(chargeCode.getCharge());
					chargeAfterSD = chargeAmt;
					discPercnt = masDiscount.getDiscountPercentage().abs();
					discAmt = chargeAfterSD.multiply(discPercnt).divide(
							new BigDecimal(100), 2, RoundingMode.HALF_UP);
					
					discTypeDB = masDiscount.getDiscountType();
					chargeAmountAfterDis = chargeAmt.add(discAmt);
					discAmt=discAmt.negate();
					discPercnt=discPercnt.negate();
					}} else if (masDiscount.getDiscountValue() != null) {
						if(chargecodes.size() > 0){
                     if(chargeAmt1!=null  && chargeAmt1.compareTo(new BigDecimal(0))>=0)
                     {
     					chargeAfterSD = chargeAmt1;
     					discAmt = masDiscount.getDiscountValue();
     					
     					 * if(discAmt.compareTo(chargeAmt)>=0) { discAmt=chargeAmt;
     					 * }
     					 
     					discPercnt = discAmt.multiply(new BigDecimal(100)).divide(
     							chargeAmt1, 2, RoundingMode.HALF_UP);
     					discTypeDB = masDiscount.getDiscountType();
     					chargeAmountAfterDis = chargeAmt1.add(discAmt);
     					discAmt=discAmt.negate();
     					discPercnt=discPercnt.negate();
                     }}
                     else
                     {
					chargeAmt = new BigDecimal(chargeCode.getCharge());
					chargeAfterSD = chargeAmt;
					discAmt = masDiscount.getDiscountValue();
					
					 * if(discAmt.compareTo(chargeAmt)>=0) { discAmt=chargeAmt;
					 * }
					 
					discPercnt = discAmt.multiply(new BigDecimal(100)).divide(
							chargeAmt, 2, RoundingMode.HALF_UP);
					discTypeDB = masDiscount.getDiscountType();
					chargeAmountAfterDis = chargeAmt.add(discAmt);
					discAmt=discAmt.negate();
					discPercnt=discPercnt.negate();
                     }}

			} else if (masDiscount.getDiscountType().equalsIgnoreCase("f") && masDiscount.getStatus().equalsIgnoreCase("y")) {
				if(chargecodes.size() > 0){
                 if(chargeAmt1!=null  && chargeAmt1.compareTo(new BigDecimal(0))>=0)
                 {
                	 if (masDiscount.getFixedValue() != null
     						&& masDiscount.getFixedValue().compareTo(
     								BigDecimal.ZERO) >= 0) {
     					chargeAmt = masDiscount.getFixedValue();
     					chargeAfterSD = masDiscount.getFixedValue();
     					chargeAmountAfterDis=masDiscount.getFixedValue();
     				}
     				else
     				{
     					chargeAfterSD = chargeAmt1;
     					chargeAmountAfterDis=chargeAmt1;

     				}
                 }}
                 else{
				if (masDiscount.getFixedValue() != null
						&& masDiscount.getFixedValue().compareTo(
								BigDecimal.ZERO) >= 0) {
					chargeAmt = masDiscount.getFixedValue();
					chargeAfterSD = masDiscount.getFixedValue();
					chargeAmountAfterDis=masDiscount.getFixedValue();
				}
				else
				{
					chargeAmt = new BigDecimal(chargeCode.getCharge());
					chargeAfterSD = chargeAmt;
					chargeAmountAfterDis=chargeAmt;

				}
			}}
		} else {
			System.out.println("else chargeAmt1---"+chargeAmt1);
			if(chargecodes.size() > 0){
			if(chargeAmt1!=null && chargeAmt1.compareTo(new BigDecimal(0))>=0)
			{
				chargeAfterSD = chargeAmt1;
				discAmt = new BigDecimal(0.00);
				discPercnt = new BigDecimal(0.00);
				chargeAmountAfterDis = chargeAmt1;
			}}
			else
			{
			chargeAmt = new BigDecimal(chargeCode.getCharge());
			chargeAfterSD = chargeAmt;
			discAmt = new BigDecimal(0.00);
			discPercnt = new BigDecimal(0.00);
			chargeAmountAfterDis = chargeAmt;
		}}

		
		 * List<MasDiscount> criteriaDiscountList = new
		 * ArrayList<MasDiscount>(); Criteria crit = null; Session session =
		 * (Session) getSession(); BigDecimal chargeAmountAfterDis = new
		 * BigDecimal(0.00); int chargeId = 0; int patientTypeId = 0; int
		 * companyId = 0; int projectId = 0; int mainChargeId = 0; int
		 * subChargeId = 0; int billTypeId = 0; String patientCategory = ""; int
		 * roomTypeId = 0; String regType = "";
		 * 
		 * if (detailsMap.get("chargeId") != null) chargeId = (Integer)
		 * detailsMap.get("chargeId"); if (detailsMap.get("patientTypeId") !=
		 * null) patientTypeId = (Integer) detailsMap.get("patientTypeId");
		 * 
		 * if (detailsMap.get("companyId") != null) companyId = (Integer)
		 * detailsMap.get("companyId");
		 * 
		 * if (detailsMap.get("projectId") != null) companyId = (Integer)
		 * detailsMap.get("projectId");
		 * 
		 * if (detailsMap.get("mainChargeId") != null) mainChargeId = (Integer)
		 * detailsMap.get("mainChargeId");
		 * 
		 * if (detailsMap.get("subChargeId") != null) subChargeId = (Integer)
		 * detailsMap.get("subChargeId");
		 * 
		 * if (detailsMap.get("billTypeId") != null) billTypeId = (Integer)
		 * detailsMap.get("billTypeId");
		 * 
		 * if (detailsMap.get("roomTypeId") != null) roomTypeId = (Integer)
		 * detailsMap.get("roomTypeId");
		 * 
		 * if (detailsMap.get("patientCategory") != null) patientCategory =
		 * (String) detailsMap.get("patientCategory");
		 * 
		 * if (detailsMap.get("regType") != null) regType = (String)
		 * detailsMap.get("regType");
		 * 
		 * Date currentDate = new Date(); chargeCodeList =
		 * session.createCriteria(MasChargeCode.class)
		 * .add(Restrictions.idEq(chargeId)).list();
		 * 
		 * crit = session.createCriteria(MasDiscount.class)
		 * .add(Restrictions.le("EffectiveDateFrom", currentDate))
		 * .createAlias("PatientType", "pt") .add(Restrictions.eq("pt.Id",
		 * patientTypeId));
		 * 
		 * if (companyId != 0) { crit = crit.createAlias("Company", "com").add(
		 * Restrictions.eq("com.Id", companyId)); } criteriaDiscountList =
		 * crit.list();
		 * 
		 * 
		 * 
		 * Criteria criteria = null; if (criteriaDiscountList.size() > 0) {
		 * 
		 * for (MasDiscount masDiscount : criteriaDiscountList) { criteria =
		 * session.createCriteria(MasDiscount.class)
		 * .add(Restrictions.le("EffectiveDateFrom", currentDate))
		 * .createAlias("PatientType", "pt") .add(Restrictions.eq("pt.Id",
		 * patientTypeId)); if (masDiscount.getCompany() != null) { criteria =
		 * criteria.createAlias("Company", "comp").add(
		 * Restrictions.eq("comp.Id", companyId)); }
		 * 
		 * if (masDiscount.getBillType() != null) { criteria =
		 * criteria.createAlias("BillType", "bt").add( Restrictions.eq("bt.Id",
		 * billTypeId)); } if (masDiscount.getPatientCategory() != null) {
		 * criteria = criteria.add(Restrictions.eq("PatientCategory",
		 * patientCategory)); } if (masDiscount.getRoomType() != null) { if
		 * (roomTypeId > 0) { criteria = criteria.createAlias("RoomType",
		 * "rt").add( Restrictions.eq("rt.Id", roomTypeId)); } }
		 * 
		 * if (masDiscount.getChargeCode() != null &&
		 * masDiscount.getSubChargecode() != null &&
		 * masDiscount.getMainChargecode() != null) { if (subChargeId != 0 &&
		 * mainChargeId != 0) { if (chargeId ==
		 * masDiscount.getChargeCode().getId() && subChargeId == masDiscount
		 * .getSubChargecode().getId() && mainChargeId == masDiscount
		 * .getMainChargecode().getId()) { if (masDiscount.getRoomType() !=
		 * null) {
		 * 
		 * if (masDiscount.getRoomType().getId() .equals(roomTypeId)) {
		 * 
		 * criteria = criteria .createAlias("ChargeCode", "cc")
		 * .add(Restrictions.eq("cc.Id", chargeId))
		 * .createAlias("SubChargecode", "sc") .add(Restrictions.eq("sc.Id",
		 * subChargeId)) .createAlias("MainChargecode", "mc")
		 * .add(Restrictions.eq("mc.Id", mainChargeId)); break; } } criteria =
		 * criteria .createAlias("ChargeCode", "cc")
		 * .add(Restrictions.eq("cc.Id", chargeId))
		 * .createAlias("SubChargecode", "sc") .add(Restrictions.eq("sc.Id",
		 * subChargeId)) .createAlias("MainChargecode", "mc")
		 * .add(Restrictions.eq("mc.Id", mainChargeId)); } } } else if
		 * (masDiscount.getChargeCode() == null &&
		 * masDiscount.getSubChargecode() != null &&
		 * masDiscount.getMainChargecode() != null) { if (subChargeId != 0 &&
		 * mainChargeId != 0) { if (subChargeId ==
		 * masDiscount.getSubChargecode() .getId() && mainChargeId ==
		 * masDiscount .getMainChargecode().getId()) { criteria = criteria
		 * .createAlias("SubChargecode", "sc") .add(Restrictions.eq("sc.Id",
		 * subChargeId)) .createAlias("MainChargecode", "mc")
		 * .add(Restrictions.eq("mc.Id", mainChargeId)); } } } else if
		 * (masDiscount.getChargeCode() == null &&
		 * masDiscount.getSubChargecode() == null &&
		 * masDiscount.getMainChargecode() != null) { if (mainChargeId != 0) {
		 * if (mainChargeId == masDiscount.getMainChargecode() .getId()) {
		 * criteria = criteria.createAlias("MainChargecode", "mc").add(
		 * Restrictions.eq("mc.Id", mainChargeId)); } } } } discountList =
		 * criteria.list(); }
		 * 
		 * BigDecimal chargeAmt = new BigDecimal(0.00); MasChargeCode
		 * masChargeCode = new MasChargeCode(); if (chargeCodeList.size() > 0) {
		 * masChargeCode = chargeCodeList.get(0); // BigDecimal chargeAmt = new
		 * BigDecimal(masChargeCode.getCharge());
		 * 
		 * Set<MasChargeCodeRates> chargeSet = new
		 * HashSet<MasChargeCodeRates>(); if
		 * (masChargeCode.getMasChargeCodeRates() != null) { chargeSet =
		 * masChargeCode.getMasChargeCodeRates(); if (chargeSet.size() > 0) {
		 * for (MasChargeCodeRates chargeRate : chargeSet) { if
		 * (currentDate.compareTo(chargeRate .getEffectiveFromDate()) >= 0 &&
		 * (chargeRate.getEffectiveToDate() == null || currentDate
		 * .compareTo(chargeRate .getEffectiveToDate()) <= 0)) { chargeAmt =
		 * chargeRate.getRate(); break; } else {
		 * 
		 * chargeAmt = new BigDecimal( masChargeCode.getCharge()); }
		 * 
		 * }
		 * 
		 * } else { chargeAmt = new BigDecimal(masChargeCode.getCharge()); }
		 * 
		 * } else { chargeAmt = new BigDecimal(masChargeCode.getCharge()); }
		 * map.put("rate", chargeAmt); map.put("ChargeAmt", chargeAmt); }
		 *//**
		 * For Standard Deduction----------------------------
		 * 
		 *//*
		
		 * BigDecimal stdDeduction = new BigDecimal(0.00); if
		 * (regType.equalsIgnoreCase("G")) { if
		 * (masChargeCode.getStdDeductionGen() != null) { stdDeduction =
		 * masChargeCode.getStdDeductionGen(); } } else if
		 * (regType.equalsIgnoreCase("S")) { if
		 * (masChargeCode.getStdDeductionSpl() != null) { stdDeduction =
		 * masChargeCode.getStdDeductionSpl(); } } BigDecimal chargeAfterSD =
		 * new BigDecimal(0.00); chargeAfterSD =
		 * chargeAmt.subtract(stdDeduction); BigDecimal discPercnt = new
		 * BigDecimal(0); BigDecimal discAmt = new BigDecimal(0); String
		 * discTypeDB = ""; if (discountList.size() > 0) { BigDecimal
		 * fixedValueDB = new BigDecimal(0.00);
		 * 
		 * for (MasDiscount discount : discountList) { if
		 * (discount.getEffectiveDateTo() != null &&
		 * (discount.getEffectiveDateTo() .compareTo(currentDate) < 0)) {
		 * chargeAmountAfterDis = chargeAfterSD; } else { if
		 * (discount.getChargeCode() != null) { if (chargeId ==
		 * discount.getChargeCode().getId()) { if
		 * (discount.getDiscountPercentage() != null) { discPercnt =
		 * discount.getDiscountPercentage(); } if (discount.getDiscountValue()
		 * != null) { discAmt = discount.getDiscountValue(); } if
		 * (discount.getFixedValue() != null) { fixedValueDB =
		 * discount.getFixedValue(); } discTypeDB = discount.getDiscountType();
		 * 
		 * break; } } else if (discount.getChargeCode() == null &&
		 * discount.getSubChargecode() != null) { if (subChargeId ==
		 * discount.getSubChargecode().getId()) { if
		 * (discount.getDiscountPercentage() != null) { discPercnt =
		 * discount.getDiscountPercentage(); } if (discount.getDiscountValue()
		 * != null) { discAmt = discount.getDiscountValue(); } if
		 * (discount.getFixedValue() != null) { fixedValueDB =
		 * discount.getFixedValue(); } discTypeDB = discount.getDiscountType();
		 * break; } } else if (discount.getChargeCode() == null &&
		 * discount.getSubChargecode() == null && discount.getMainChargecode()
		 * != null) { if (mainChargeId == discount.getMainChargecode() .getId())
		 * { if (discount.getDiscountPercentage() != null) { discPercnt =
		 * discount.getDiscountPercentage(); } if (discount.getDiscountValue()
		 * != null) { discAmt = discount.getDiscountValue(); } if
		 * (discount.getFixedValue() != null) { fixedValueDB =
		 * discount.getFixedValue(); } discTypeDB = discount.getDiscountType();
		 * } } else if (discount.getChargeCode() == null &&
		 * discount.getSubChargecode() == null && discount.getMainChargecode()
		 * == null) { if (discount.getDiscountPercentage() != null) { discPercnt
		 * = discount.getDiscountPercentage(); } if (discount.getDiscountValue()
		 * != null) { discAmt = discount.getDiscountValue(); } if
		 * (discount.getFixedValue() != null) { fixedValueDB =
		 * discount.getFixedValue(); } discTypeDB = discount.getDiscountType();
		 * 
		 * } } } if (discPercnt.compareTo(new BigDecimal(0)) > 0) { discAmt =
		 * chargeAfterSD.multiply(discPercnt).divide( new BigDecimal(100), 2,
		 * RoundingMode.HALF_UP); if (discTypeDB.equalsIgnoreCase("d")) {
		 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); chargeAfterSD
		 * = chargeAmountAfterDis; // For Tariff case map.put("rate",
		 * chargeAfterSD); } else if (discTypeDB.equalsIgnoreCase("t")) {
		 * chargeAmountAfterDis = chargeAfterSD.add(discAmt); chargeAfterSD =
		 * chargeAmountAfterDis; // For Tariff case map.put("rate",
		 * chargeAmt.add(discAmt)); } } else if (discAmt.compareTo(new
		 * BigDecimal(0)) > 0) { if (discTypeDB.equalsIgnoreCase("d")) {
		 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); } else if
		 * (discTypeDB.equalsIgnoreCase("t")) { chargeAmountAfterDis =
		 * chargeAfterSD.add(discAmt); chargeAfterSD = chargeAmountAfterDis;
		 * map.put("rate", chargeAmt.add(discAmt)); } } else if
		 * (fixedValueDB.compareTo(new BigDecimal(0)) > 0) { if
		 * (discTypeDB.equalsIgnoreCase("f")) { chargeAmountAfterDis =
		 * fixedValueDB; chargeAfterSD = fixedValueDB; map.put("rate",
		 * chargeAfterSD); } } else { chargeAmountAfterDis = chargeAfterSD; }
		 * 
		 * MasDiscount discount = discountList.get(0); if
		 * (discount.getDiscountPercentage() != null) { discPercnt =
		 * discount.getDiscountPercentage(); discAmt =
		 * chargeAfterSD.multiply(discPercnt).divide(new
		 * BigDecimal(100),2,RoundingMode.HALF_UP); if
		 * (discount.getDiscountType().equalsIgnoreCase("d")) {
		 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); } else if
		 * (discount.getDiscountType().equalsIgnoreCase("t")) {
		 * chargeAmountAfterDis = chargeAfterSD.add(discAmt); } } else if
		 * (discount.getDiscountValue() != null) { discAmt =
		 * discount.getDiscountValue(); if
		 * (discount.getDiscountType().equalsIgnoreCase("d")) {
		 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); } else if
		 * (discount.getDiscountType().equalsIgnoreCase("t")) {
		 * chargeAmountAfterDis = chargeAfterSD.add(discAmt); } } else if
		 * (discount.getFixedValue() != null) { if
		 * (discount.getDiscountType().equalsIgnoreCase("f")) {
		 * chargeAmountAfterDis = discount.getFixedValue(); } }
		 * 
		 * 
		 * } else { chargeAmountAfterDis = chargeAfterSD; if
		 * (chargeCodeList.size() > 0) { if
		 * (chargeCodeList.get(0).getDiscountable().equals("y")) {
		 * 
		 * if (chargeCodeList.get(0).getDiscountPercentage() != null) {
		 * discPercnt = chargeCodeList.get(0) .getDiscountPercentage(); discAmt
		 * = chargeAfterSD.multiply(discPercnt).divide( new BigDecimal(100), 2,
		 * RoundingMode.HALF_UP); } } }
		 * 
		 * chargeAmountAfterDis = chargeAmountAfterDis.subtract(discAmt); } if
		 * (discTypeDB.equalsIgnoreCase("t")) { discAmt = new BigDecimal(0); }
		 * chargeCodeList = session.createCriteria(MasChargeCode.class)
		 * .add(Restrictions.eq("Id", 1038)).list(); for (MasChargeCode code :
		 * chargeCodeList) { chargeAmountAfterDis = new BigDecimal("" +
		 * code.getCharge()); }
		 
		if(chargeAmt1!=null && chargeAmt1.compareTo(new BigDecimal(0))>0)
		{
			map.put("rate", chargeAmt1);
		}
		else
		{
			map.put("rate", chargeAmt);
		}
		map.put("ChargeAmt", chargeAmt);
		map.put("chargeAfterSD", chargeAfterSD);
		map.put("chargeAmountAfterDis", chargeAmountAfterDis);
		map.put("discPercnt", discPercnt);
		map.put("discAmt", discAmt);
		map.put("stdDeduction", stdDeduction);
		map.put("discTypeDB", discTypeDB);

		return map;
	}*/
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeAmountAfterDiscount(
			Map<String, Object> detailsMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasDiscount> criteriaDiscountList = new ArrayList<MasDiscount>();
		List<MasDiscount> compDiscountList = new ArrayList<MasDiscount>();
		Criteria crit = null;
		Session session = (Session) getSession();
		BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
		BigDecimal netBalanceAmount = new BigDecimal(0.00);
		BigDecimal balaceId = new BigDecimal(0.00);

		BigDecimal actAmount = new BigDecimal(0.00);
		int chargeId = 0;
		int patientTypeId = 0;
		int companyId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;
		int billTypeId = 0;
		int roomTypeId = 0;
		int rateApplicable = 0;
		String patientCategory = "";
		String regType = "";
		String nabhHospital = "";
		String lalPathText = "";
		int schemeId = 0;
		
		int hospitalId= 0;
		if (detailsMap.get("hospitalId") != null)
			hospitalId = (Integer) detailsMap.get("hospitalId");
		
		if (detailsMap.get("chargeId") != null)
			chargeId = (Integer) detailsMap.get("chargeId");
		if (detailsMap.get("patientTypeId") != null)
			patientTypeId = (Integer) detailsMap.get("patientTypeId");
		patientTypeId=3;
		if (detailsMap.get("companyId") != null)
			companyId = (Integer) detailsMap.get("companyId");
		if (detailsMap.get("mainChargeId") != null)
			mainChargeId = (Integer) detailsMap.get("mainChargeId");

		if (detailsMap.get("subChargeId") != null)
			subChargeId = (Integer) detailsMap.get("subChargeId");

		if (detailsMap.get("billTypeId") != null)
			billTypeId = (Integer) detailsMap.get("billTypeId");

	/*	if (detailsMap.get("roomTypeId") != null)
			roomTypeId = (Integer) detailsMap.get("roomTypeId");
		System.out.println("roomTypeId--->"+roomTypeId);*/
		
		// commented by amit das on 07-06-2016
		// added by amit das on 07-06-2016
		if (detailsMap.get("roomtypeId") != null)
			roomTypeId = (Integer) detailsMap.get("roomtypeId");
		
		
		
		
		if (detailsMap.get("patientCategory") != null)
			patientCategory = (String) detailsMap.get("patientCategory");
		if (detailsMap.get("regType") != null)
			regType = (String) detailsMap.get("regType");
		// ---Added by dipali for cghs---
		if (detailsMap.get("nabhHospital") != null)
			nabhHospital = (String) detailsMap.get("nabhHospital");
		if (detailsMap.get("rateApplicable") != null)
			rateApplicable = (Integer) detailsMap.get("rateApplicable");
		if (detailsMap.get("netBalanceAmount") != null) {
			netBalanceAmount = (BigDecimal) detailsMap.get("netBalanceAmount");
		}
		if (detailsMap.get("balaceId") != null) {
			balaceId = (BigDecimal) detailsMap.get("balaceId");
		}
		if (detailsMap.get("lalPathText") != null) {
			lalPathText = (String) detailsMap.get("lalPathText");
		}
		
		if(detailsMap.get("schemeId")!=null){
			schemeId = (Integer) detailsMap.get("schemeId");
		}
		
		
		// --------------------
		Date currentDate = new Date();
		
		
		
		
		
		chargeCodeList = session.createCriteria(MasChargeCode.class).add(
				Restrictions.idEq(chargeId)).list();
		
		
		
		
		compDiscountList = session.createCriteria(MasDiscount.class).add(
				Restrictions.eq("Status", "y")).createAlias("Company", "pt")
				.add(Restrictions.eq("pt.Id", companyId)).list();
	
	/*	crit = session.createCriteria(MasDiscount.class).add(
				Restrictions.le("EffectiveDateFrom", currentDate)).createAlias(
				"PatientType", "pt").add(
				Restrictions.eq("pt.Id", patientTypeId)).createAlias(
				"BillType", "bt").add(Restrictions.eq("bt.Id", billTypeId))
				.add(Restrictions.eq("PatientCategory", patientCategory)).add(
						Restrictions.eq("Status", "y"));*/
		
		// commented by amit das on 17-06-2016
		// added by amit das on 17-06-2016
		
		crit = session.createCriteria(MasDiscount.class).add(
				Restrictions.le("EffectiveDateFrom", currentDate)).createAlias(
				"PatientType", "pt",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.or(Restrictions.isNull("PatientType"), Restrictions.eq("pt.Id", patientTypeId)))
				.createAlias(
				"BillType", "bt").add(Restrictions.eq("bt.Id", billTypeId))
				.add(Restrictions.or(Restrictions.eq("PatientCategory", patientCategory),Restrictions.isNull("PatientCategory"))).add(
						Restrictions.eq("Status", "y"));
						
		
		if(schemeId!=0){
			crit =	 crit.add(Restrictions.eq("Scheme.Id", schemeId));
		}
		
		
		/*// commented by amit das on 26-05-2016
		// added by amit das on 26-05-2016
		Criterion patientTypeRestriction = Restrictions.or(Restrictions.isNull("PatientType"), Restrictions.eq("pt.Id", patientTypeId));
		Criterion patientCategoryRestriction = Restrictions.or(Restrictions.eq("PatientCategory", patientCategory),Restrictions.isNull("PatientCategory"));
		crit = session.createCriteria(MasDiscount.class).createAlias("PatientType", "pt",CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.and(patientTypeRestriction,patientCategoryRestriction))
				.add(Restrictions.or(Restrictions.isNull("PatientType"), Restrictions.eq("pt.Id", patientTypeId)))
				.add(Restrictions.le("EffectiveDateFrom", currentDate))
				.createAlias("Scheme", "s")
				.add(Restrictions.eq("s.Id", schemeId))
				.createAlias(
				"BillType", "bt").add(Restrictions.eq("bt.Id", billTypeId)).add(
						Restrictions.eq("Status", "y").ignoreCase());*/
		
	
		if (companyId != 0) {
			crit = crit.createAlias("Company", "com").add(
					Restrictions.eq("com.Id", companyId));
		}
		
		
		/*
		 * if (roomTypeId != 0) { crit = crit.createAlias("RoomType", "rt").add(
		 * Restrictions.eq("rt.Id", roomTypeId)); }//***comment by anand
		 * beecuase all type is not working properly***
		 */
		
		criteriaDiscountList = crit.list();
		
		Criteria criteria = null;
		
		
		if (criteriaDiscountList.size() > 0) {
			for (MasDiscount masDiscount : criteriaDiscountList) {
				

				criteria = session.createCriteria(MasDiscount.class).add(
						Restrictions.le("EffectiveDateFrom", currentDate))
						.add(Restrictions.eq("Status", "y")).createAlias("Scheme", "sche").add(Restrictions.eq("sche.Id", schemeId));
			
				if (masDiscount.getCompany() != null) {

					if (lalPathText.equalsIgnoreCase("y")) {
						criteria = criteria.createAlias("Company", "comp").add(
								Restrictions.eq("comp.Id", 35));
					} else {
						criteria = criteria.createAlias("Company", "comp").add(
								Restrictions.eq("comp.Status", "y")).add(
								Restrictions.eq("comp.Id", companyId));
					}
				}
				
				if(masDiscount.getPatientType()!=null){
					criteria = 	criteria.createAlias("PatientType", "pt").add(
							Restrictions.eq("pt.Id", patientTypeId));
				}
				
				if (masDiscount.getBillType() != null) {
					criteria = criteria.createAlias("BillType", "bt").add(
							Restrictions.eq("bt.Id", billTypeId));
				}
				if (masDiscount.getPatientCategory() != null) {
					criteria = criteria.add(Restrictions.eq("PatientCategory",
							patientCategory));
				}
				if (masDiscount.getRoomType() != null)
				{
					if(roomTypeId>0){
						 criteria = criteria.createAlias("RoomType", "rt").add(Restrictions.eq("rt.Id", roomTypeId));
						}
				}
				
				
				
				if (masDiscount.getChargeCode() != null && masDiscount.getSubChargecode() != null
						&& masDiscount.getMainChargecode() != null) {
					
					if (subChargeId != 0 && mainChargeId != 0) {
						if (chargeId == masDiscount.getChargeCode().getId()	&& subChargeId == masDiscount
							.getSubChargecode().getId()	&& mainChargeId == masDiscount
										.getMainChargecode().getId()) {
							if(masDiscount.getRoomType() != null)
							{
								if(masDiscount.getRoomType().getId().equals(roomTypeId))
								{
									criteria = criteria.createAlias("ChargeCode", "cc")
									.add(Restrictions.eq("cc.Id", chargeId))
									.createAlias("SubChargecode", "sc")
									.add(Restrictions.eq("sc.Id",subChargeId))
									.createAlias("MainChargecode", "mc")
									.add(Restrictions.eq("mc.Id",mainChargeId));
									break;
								}
							}else{
								
							criteria = criteria.createAlias("ChargeCode", "cc")
							.add(Restrictions.eq("cc.Id", chargeId))
							.createAlias("SubChargecode", "sc")
							.add(Restrictions.eq("sc.Id",subChargeId))
							.createAlias("MainChargecode", "mc")
							.add(Restrictions.eq("mc.Id",mainChargeId));
							break;  // added by amit das on 21-06-2017
							}
						}
					}

				} else if (masDiscount.getChargeCode() == null
						&& masDiscount.getSubChargecode() != null
						&& masDiscount.getMainChargecode() != null) {
					if (subChargeId != 0 && mainChargeId != 0) {
						if (subChargeId == masDiscount.getSubChargecode()
								.getId()
								&& mainChargeId == masDiscount
										.getMainChargecode().getId()) {
							criteria = criteria.createAlias("SubChargecode",
									"sc").add(
									Restrictions.eq("sc.Id", subChargeId))
									.createAlias("MainChargecode", "mc").add(
											Restrictions.eq("mc.Id",
													mainChargeId));
						}
					}
				} else if (masDiscount.getChargeCode() == null
						&& masDiscount.getSubChargecode() == null
						&& masDiscount.getMainChargecode() != null) {
					if (mainChargeId != 0) {
						if (mainChargeId == masDiscount.getMainChargecode()
								.getId()) {
							criteria = criteria.createAlias("MainChargecode",
									"mc").add(
									Restrictions.eq("mc.Id", mainChargeId));
						}
					}
				}
			}
			discountList = criteria.list();
			
		}
		/*
		 * if(discountList1.size() >0) { for(MasDiscount masDiscount :
		 * discountList1) { if (masDiscount.getRoomType() != null) {
		 * if(masDiscount.getRoomType().getId() == roomTypeId){ criteria =
		 * criteria.createAlias("RoomType", "rt").add( Restrictions.eq("rt.Id",
		 * roomTypeId)); break; } }
		 * 
		 * } discountList=criteria.list(); }
		 */

		BigDecimal chargeAmt = new BigDecimal(0.00);
		MasChargeCode masChargeCode = new MasChargeCode();
		if (chargeCodeList.size() > 0) {
			
			masChargeCode = chargeCodeList.get(0);
			chargeAmt = new BigDecimal(masChargeCode.getCharge());

			Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
			// if (masChargeCode.getMasChargeCodeRates() != null &&
			// masChargeCode.getMasChargeCodeRates().size() >0) {
			chargeSet = masChargeCode.getMasChargeCodeRates();
			
			if (chargeSet.size() > 0) {
				for (MasChargeCodeRates chargeRate : chargeSet) {
					//System.out.println("chargeRate.getHospital()===="+chargeRate.getHospital().getId());
					
					if(chargeRate.getHospital()!=null && chargeRate.getHospital().getId() == hospitalId){
					/*if (currentDate
							.compareTo(chargeRate.getEffectiveFromDate()) >= 0
							&& (chargeRate.getEffectiveToDate() == null || currentDate
									.compareTo(chargeRate.getEffectiveToDate()) <= 0)) {*/
						if (currentDate
								.compareTo(chargeRate.getEffectiveFromDate()) >= 0) {
						// ---Added by dipali for nabh And cghs
						if (nabhHospital.equalsIgnoreCase("y")	&& patientTypeId == 1) {
							if (rateApplicable == 4) {/*
								chargeAmt = new BigDecimal(String
										.valueOf(chargeRate.getChargeCode()
												.getChargeNabh()));
							*/} else {
								chargeAmt = chargeRate.getRate();
							}
							
						} else if (nabhHospital.equalsIgnoreCase("n")
								&& patientTypeId == 1) {
							if (rateApplicable != 0 && rateApplicable == 4) {/*
								chargeAmt = new BigDecimal(String
										.valueOf(chargeRate.getChargeCode()
												.getChargeNonNabh()));
							*/} else {
								chargeAmt = chargeRate.getRate();
							}
							
						} else {

							chargeAmt = chargeRate.getRate();
						}
						// ----------------------------------------
						// chargeAmt = chargeRate.getRate();
						break;
					} else {
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}

				}
				}

			} else {
				if (nabhHospital.equalsIgnoreCase("y") && patientTypeId == 1) {/*
					if (rateApplicable == 4) {
						chargeAmt = new BigDecimal(String.valueOf(masChargeCode
								.getChargeNabh()));
					} else {
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}
				*/} else if (nabhHospital.equalsIgnoreCase("n") && patientTypeId == 1) {
					if (rateApplicable == 4) {/*
						chargeAmt = new BigDecimal(String.valueOf(masChargeCode
								.getChargeNonNabh()));
					*/} else {
						chargeAmt = new BigDecimal(masChargeCode.getCharge());
					}
				} else {
					chargeAmt = new BigDecimal(masChargeCode.getCharge());
				}
				
				// ------------------------------------ooo----
				// chargeAmt = chargeRate.getRate();
			}
			actAmount = chargeAmt.add(balaceId);
			map.put("rate", chargeAmt);

		}
		/**
		 * For Standard Deduction----------------------------
		 * 
		 */
		BigDecimal stdDeduction = new BigDecimal(0.00);
		if (regType.equalsIgnoreCase("G")) {
			if (masChargeCode.getStdDeductionGen() != null) {
				stdDeduction = masChargeCode.getStdDeductionGen();
			}
		} else if (regType.equalsIgnoreCase("S")) {
			if (masChargeCode.getStdDeductionSpl() != null) {
				stdDeduction = masChargeCode.getStdDeductionSpl();
			}
		}
		BigDecimal chargeAfterSD = new BigDecimal(0.00);
		chargeAfterSD = chargeAmt.subtract(stdDeduction);
		// =======for last cost price===================

		List<Integer> storeItemBatchStockList = new ArrayList<Integer>();
		List<StoreItemBatchStock> storeItemBatchStockForLastCostPrice = new ArrayList<StoreItemBatchStock>();
		//List<MasChargeConsumption> chargeConsumptionList = new ArrayList<MasChargeConsumption>();
		List<MasSetupParameterMaintaince> parameterMaintenanceList = new ArrayList<MasSetupParameterMaintaince>();
		int centralStoreDepartmentId = 0;
		BigDecimal totalCostPriceForConsumption = new BigDecimal(0.00);
		parameterMaintenanceList = session.createCriteria(
				MasSetupParameterMaintaince.class).list();

		// centralStoreDepartmentId =24;

		if (parameterMaintenanceList.size() > 0) {/*
			MasSetupParameterMaintaince setupParameterMaintaince = parameterMaintenanceList
					.get(0);
			centralStoreDepartmentId = setupParameterMaintaince
					.getCentralStore().getId();

		*/}

		/*chargeConsumptionList = session.createCriteria(
				MasChargeConsumption.class).createAlias("ChargeCode", "code")
				.add(Restrictions.eq("code.Id", chargeId)).list();
*/
		/*
			for (MasChargeConsumption chargeConsumption : chargeConsumptionList) {
				int itemId = chargeConsumption.getItem().getId();
				if (centralStoreDepartmentId != 0) {
					storeItemBatchStockList = session.createCriteria(
							StoreItemBatchStock.class).createAlias("Item",
							"item").add(Restrictions.eq("item.Id", itemId))
							.createAlias("Department", "dept").add(
									Restrictions.eq("dept.Id",
											centralStoreDepartmentId))
							.setProjection(Projections.max("Id")).list();
					;
				}
				 * else{ storeItemBatchStockList =
				 * session.createCriteria(StoreItemBatchStock
				 * .class).createAlias("Item",
				 * "item").add(Restrictions.eq("item.Id"
				 * ,itemId)).createAlias("Department",
				 * "dept").add(Restrictions.eq("dept.Id",
				 * chargeConsumption.getChargeCode
				 * ().getDepartment().getId())).setProjection
				 * (Projections.max("Id")).list(); }
				 
				if (storeItemBatchStockList.size() > 0
						&& storeItemBatchStockList.get(0) != null) {
					int storeItemBatchStockId = storeItemBatchStockList.get(0);
					storeItemBatchStockForLastCostPrice = session
							.createCriteria(StoreItemBatchStock.class).add(
									Restrictions.idEq(storeItemBatchStockId))
							.list();

					if (storeItemBatchStockForLastCostPrice.size() > 0) {
						for (StoreItemBatchStock storeItemBatchStock : storeItemBatchStockForLastCostPrice) {
							BigDecimal costPrice = storeItemBatchStock
									.getCostPrice();
							totalCostPriceForConsumption = totalCostPriceForConsumption
									.add(costPrice);
						}
					}
				}
			}
		*/

		BigDecimal discPercnt = new BigDecimal(0);
		BigDecimal discAmt = new BigDecimal(0);
		String discTypeDB = "";
		int discCompId = 0;
		if (discountList.size() > 0) {
			BigDecimal fixedValueDB = new BigDecimal(0.00);			
			for (MasDiscount discount : discountList) {
				
				if (discount.getEffectiveDateTo() != null && (discount.getEffectiveDateTo().compareTo(currentDate) < 0)) {
					chargeAmountAfterDis = chargeAfterSD;

				} else {
					if (discount.getChargeCode() != null) {
						
						if (chargeId == discount.getChargeCode().getId()) {
							if (discount.getDiscountPercentage() != null
									&& discount.getDiscountPercentage()
											.compareTo(new BigDecimal(0)) > 0) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null
									&& discount.getDiscountValue().compareTo(
											new BigDecimal(0)) > 0) {
								discAmt = discount.getDiscountValue();
							}

							if (discount.getFixedValue() != null && discount.getFixedValue().compareTo(new BigDecimal(0)) > 0) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
							if (discount.getCompany() != null) {
								discCompId = discount.getCompany().getId();
							}
						/*	if (discount.getLastCostPrice() != null) {
								if (discount.getLastCostPrice().equals("y")) {
									chargeAfterSD = totalCostPriceForConsumption;
									map.put("rate",totalCostPriceForConsumption);
								}
							}*/
							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() != null) {
						if (subChargeId == discount.getSubChargecode().getId()) {
							if (discount.getDiscountPercentage() != null
									&& discount.getDiscountPercentage()
											.compareTo(new BigDecimal(0)) > 0) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null
									&& discount.getDiscountValue().compareTo(
											new BigDecimal(0)) > 0) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null
									&& discount.getFixedValue().compareTo(
											new BigDecimal(0)) > 0) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
							if (discount.getCompany() != null) {
								discCompId = discount.getCompany().getId();
							}
							/*if (discount.getLastCostPrice() != null) {
								if (discount.getLastCostPrice().equals("y")) {
									chargeAfterSD = totalCostPriceForConsumption;
									map.put("rate",
											totalCostPriceForConsumption);
								}
							}*/
							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() != null) {
						if (mainChargeId == discount.getMainChargecode()
								.getId()) {
							if (discount.getDiscountPercentage() != null
									&& discount.getDiscountPercentage()
											.compareTo(new BigDecimal(0)) > 0) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null
									&& discount.getDiscountValue().compareTo(
											new BigDecimal(0)) > 0) {
								discAmt = discount.getDiscountValue();

							}
							if (discount.getFixedValue() != null
									&& discount.getFixedValue().compareTo(
											new BigDecimal(0)) > 0) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
							if (discount.getCompany() != null) {
								discCompId = discount.getCompany().getId();
							}
						/*	if (discount.getLastCostPrice() != null) {
								if (discount.getLastCostPrice().equals("y")) {
									chargeAfterSD = totalCostPriceForConsumption;
									map.put("rate",
											totalCostPriceForConsumption);
								}
							}*/
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() == null) {
						if (discount.getDiscountPercentage() != null
								&& discount.getDiscountPercentage().compareTo(
										new BigDecimal(0)) > 0) {
							discPercnt = discount.getDiscountPercentage();
						}
						if (discount.getDiscountValue() != null
								&& discount.getDiscountValue().compareTo(
										new BigDecimal(0)) > 0) {
							discAmt = discount.getDiscountValue();
						}
						if (discount.getFixedValue() != null
								&& discount.getFixedValue().compareTo(
										new BigDecimal(0)) > 0) {
							fixedValueDB = discount.getFixedValue();
						}
						discTypeDB = discount.getDiscountType();
						if (discount.getCompany() != null) {
							discCompId = discount.getCompany().getId();
						}
						/*if (discount.getLastCostPrice() != null) {
							if (discount.getLastCostPrice().equals("y")) {
								chargeAfterSD = totalCostPriceForConsumption;
								map.put("rate", totalCostPriceForConsumption);

							}
						}*/
					}
				}
			}
			if (discPercnt.compareTo(new BigDecimal(0)) > 0) {
				
				discAmt = chargeAfterSD.multiply(discPercnt).divide(
						new BigDecimal(100), 2, RoundingMode.HALF_UP);
				if (discTypeDB.equalsIgnoreCase("d")) {
					// chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
					if (companyId != 0) {
						if (discCompId == companyId) {
							if (nabhHospital.equalsIgnoreCase("n")
									&& patientTypeId == 1
									&& lalPathText.equalsIgnoreCase("")) {/*
								chargeAmountAfterDis = new BigDecimal(
										masChargeCode.getChargeNonNabh())
										.subtract(discAmt);
							*/} else if (patientTypeId == 3
									&& lalPathText.equalsIgnoreCase("y")) {
								chargeAmountAfterDis = new BigDecimal(masChargeCode.getCharge())
										.subtract(discAmt);
							}
						} else if (nabhHospital.equalsIgnoreCase("n")
								&& patientTypeId == 1
								&& lalPathText.equalsIgnoreCase("y")) {/*
							chargeAmountAfterDis = new BigDecimal(masChargeCode
									.getChargeNonNabh()).subtract(discAmt);
						*/}

						else {
							chargeAmountAfterDis = chargeAfterSD.add(discAmt);

						}
					} else {
						/*chargeAmountAfterDis = new BigDecimal(masChargeCode
								.getCharge()).subtract(discAmt);*/
						chargeAmountAfterDis =chargeAfterSD.subtract(discAmt);
					}
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					chargeAmountAfterDis = chargeAfterSD.add(discAmt);
					chargeAfterSD = chargeAmountAfterDis; // For Tariff case
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (discAmt.compareTo(new BigDecimal(0)) > 0) {
				
				if (discTypeDB.equalsIgnoreCase("d")) {
					chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					if (companyId != 0) {
						if (discCompId == companyId) {
							if (nabhHospital.equalsIgnoreCase("n")
									&& patientTypeId == 1
									&& !lalPathText.equalsIgnoreCase("y")) {/*
								chargeAmountAfterDis = new BigDecimal(
										masChargeCode.getChargeNonNabh())
										.add(discAmt);
							*/} else if (patientTypeId == 3
									&& lalPathText.equalsIgnoreCase("y")) {
								chargeAmountAfterDis = new BigDecimal(
										masChargeCode.getCharge()).add(discAmt);
							}
						} else if (nabhHospital.equalsIgnoreCase("n")
								&& patientTypeId == 1) {/*
							chargeAmountAfterDis = new BigDecimal(masChargeCode
									.getChargeNonNabh()).add(discAmt);
						*/} else {
							chargeAmountAfterDis = chargeAfterSD.add(discAmt);
						}
					} else {
						chargeAmountAfterDis = new BigDecimal(masChargeCode
								.getCharge()).add(discAmt);
					}
					chargeAfterSD = chargeAmountAfterDis;
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (fixedValueDB.compareTo(new BigDecimal(0)) > 0) {
				
				if (discTypeDB.equalsIgnoreCase("f")) {
					// map.put("rate", chargeAmt.add(discAmt));

					/** code by anand for fixed value ***/
					chargeAmountAfterDis = fixedValueDB;
					chargeAfterSD = chargeAmountAfterDis;
					map.put("rate", chargeAfterSD);

					/** end code by anand for fixed value ***/
				}
			} else {
				chargeAmountAfterDis = chargeAfterSD;
			}

			/*
			 * MasDiscount discount = discountList.get(0); if
			 * (discount.getDiscountPercentage() != null) { discPercnt =
			 * discount.getDiscountPercentage(); discAmt =
			 * chargeAfterSD.multiply(discPercnt).divide(new
			 * BigDecimal(100),2,RoundingMode.HALF_UP); if
			 * (discount.getDiscountType().equalsIgnoreCase("d")) {
			 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); } else if
			 * (discount.getDiscountType().equalsIgnoreCase("t")) {
			 * chargeAmountAfterDis = chargeAfterSD.add(discAmt); } } else if
			 * (discount.getDiscountValue() != null) { discAmt =
			 * discount.getDiscountValue(); if
			 * (discount.getDiscountType().equalsIgnoreCase("d")) {
			 * chargeAmountAfterDis = chargeAfterSD.subtract(discAmt); } else if
			 * (discount.getDiscountType().equalsIgnoreCase("t")) {
			 * chargeAmountAfterDis = chargeAfterSD.add(discAmt); } } else if
			 * (discount.getFixedValue() != null) { if
			 * (discount.getDiscountType().equalsIgnoreCase("f")) {
			 * chargeAmountAfterDis = discount.getFixedValue(); } }
			 */
			actAmount = chargeAmountAfterDis.add(netBalanceAmount);
		} else {
			
			chargeAmountAfterDis = chargeAfterSD;
			
			if (chargeCodeList.size() > 0) {
				
				if (chargeCodeList.get(0).getDiscountable().equals("y")) {
					if (chargeCodeList.get(0).getDiscountPercentage() != null) {
						discPercnt = chargeCodeList.get(0)
								.getDiscountPercentage();
						discAmt = chargeAfterSD.multiply(discPercnt).divide(
								new BigDecimal(100), 2, RoundingMode.HALF_UP);
						
					}
				}
			}
			
			chargeAmountAfterDis = chargeAmountAfterDis.subtract(discAmt);

		}
		if (discTypeDB.equalsIgnoreCase("t")) {
			discAmt = new BigDecimal(0);
		}

		map.put("discountList", discountList);
		map.put("actAmount", actAmount);
		map.put("chargeAfterSD", chargeAfterSD);
		map.put("chargeAmountAfterDis", chargeAmountAfterDis);
		map.put("discPercnt", discPercnt);
		map.put("discAmt", discAmt);
		map.put("stdDeduction", stdDeduction);
		map.put("discTypeDB", discTypeDB);
		map.put("ChargeAmt", chargeAmt); //added by amit das on 07-06-2016
		return map;
	}

	/**
	 * Method to save Details of Billing Servicing
	 * 
	 */

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitBillServicingDetails(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		BlOpBillHeader opBillHeader = new BlOpBillHeader();
		String userName = "";
		boolean saved = false;
		boolean flag = false;
		int userId = 0;

		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List rateList = new ArrayList();
		List standardDeductionList = new ArrayList();
		List amountList = new ArrayList();
		List discountList = new ArrayList();
		List disPercentList = new ArrayList();
		List proportionalDiscountList = new ArrayList();
		List netAmountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();
		List prcDtIdList = new ArrayList();
		
		List payModeList = new ArrayList();
		List amtReceivedList = new ArrayList();
		List chqNoList = new ArrayList();
		List chqDateList = new ArrayList();
		List bankNameList = new ArrayList();
		int visitIdNew = 0;
		int deptIdNew11 = 0;
		if (dataMap.get("visitIdNew") != null) {
			visitIdNew = (Integer) dataMap.get("visitIdNew");
		}
		if (dataMap.get("deptIdNew11") != null) {
			deptIdNew11 = (Integer) dataMap.get("deptIdNew11");
		}
		//
		//
		if (dataMap.get("opBillHeader") != null) {
			opBillHeader = (BlOpBillHeader) dataMap.get("opBillHeader");
		}
		if (dataMap.get("qtyList") != null) {
			qtyList = (List) dataMap.get("qtyList");
		}
		if (dataMap.get("rateList") != null) {
			rateList = (List) dataMap.get("rateList");
		}
		if (dataMap.get("standardDeductionList") != null) {
			standardDeductionList = (List) dataMap.get("standardDeductionList");
		}
		if (dataMap.get("amountList") != null) {
			amountList = (List) dataMap.get("amountList");
		}
		if (dataMap.get("disPercentList") != null) {
			disPercentList = (List) dataMap.get("disPercentList");
		}
		if (dataMap.get("discountList") != null) {
			discountList = (List) dataMap.get("discountList");
		}
		if (dataMap.get("netAmountList") != null) {
			netAmountList = (List) dataMap.get("netAmountList");
		}
		if (dataMap.get("mainChargeList") != null) {
			mainChargeList = (List) dataMap.get("mainChargeList");
		}
		if (dataMap.get("subChargeList") != null) {
			subChargeList = (List) dataMap.get("subChargeList");
		}
		if (dataMap.get("amtReceivedList") != null) {
			amtReceivedList = (List) dataMap.get("amtReceivedList");
		}
		if (dataMap.get("chqNoList") != null) {
			chqNoList = (List) dataMap.get("chqNoList");
		}
		if (dataMap.get("chqDateList") != null) {
			chqDateList = (List) dataMap.get("chqDateList");
		}
		if (dataMap.get("bankNameList") != null) {
			bankNameList = (List) dataMap.get("bankNameList");
		}

		if (dataMap.get("proportionalDiscountList") != null) {
			proportionalDiscountList = (List) dataMap
					.get("proportionalDiscountList");
		}
		if (dataMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) dataMap.get("orderDetailIdList");
		}

		if (dataMap.get("deptCodeList") != null) {
			deptCodeList = (List) dataMap.get("deptCodeList");
		}
		if (dataMap.get("deptIdList") != null) {
			deptIdList = (List) dataMap.get("deptIdList");
		}
		String patientUhid="";
		if (dataMap.get("patientuhid") != null) {
			patientUhid = (String) dataMap.get("patientuhid");
		}
		if (dataMap.get("prcDtIdList") != null) {
			prcDtIdList = (List) dataMap.get("prcDtIdList");
		}
		int surgeryHdId = 0;
		if (dataMap.get("surgeryHdId") != null) {
			surgeryHdId = (Integer) dataMap.get("surgeryHdId");
		}
		
		
		
		int hinId = 0;
		 int hospitalId = 0;
		
		BigDecimal advAdj = new BigDecimal(0);
		BigDecimal outstanding = new BigDecimal(0);
		BigDecimal avAdvAmtId = new BigDecimal(0);
		BigDecimal remainCId = new BigDecimal(0);
		
		
		if (dataMap.get("hinId") != null) {
			hinId = (Integer) dataMap.get("hinId");
		}
		if (dataMap.get("advAdj") != null) {
			advAdj = new BigDecimal((String) dataMap.get("advAdj"));
		}
		if (dataMap.get("outstanding") != null) {
			outstanding = new BigDecimal((String) dataMap.get("outstanding"));
		}
		
		if (dataMap.get("avAdvAmtId") != null) {
			avAdvAmtId = new BigDecimal((String) dataMap.get("avAdvAmtId"));
		}
		
		if (dataMap.get("remainCId") != null) {
			remainCId = new BigDecimal((String) dataMap.get("remainCId"));
		}
		if (dataMap.get("userName") != null) {
			userName = (String) dataMap.get("userName");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		final int orderhospitalId = hospitalId;
		if (dataMap.get("userId") != null) {
			userId = (Integer) dataMap.get("userId");
		}
		String registrationType = "";
		if (dataMap.get("registrationType") != null) {
			registrationType = (String) dataMap.get("registrationType");
		}
		Users user = new Users();
		user.setId(userId);

		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			// ------------------Saving Data into bl_op_bill_header
			// table-------------------------

			String billNo = "";
			String billType = "OS";
			billNo = generateBillNo(billType, "save",hospitalId);
			opBillHeader.setBillNo(billNo);
			
			hbt.save(opBillHeader);

			map.put("billNo", billNo);
			
			

			// ------------------Saving Data into bl_op_bill_detail
			// table-------------------------

			if (dataMap.get("chargeList") != null) {
				chargeList = (List) dataMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						BlOpBillDetails opBillDetail = new BlOpBillDetails();
						MasChargeCode masChargeCode = new MasChargeCode();
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							opBillDetail.setChargeCode(masChargeCode);

							if (rateList.get(i) != null
									&& !(rateList.get(i).toString()).equals("")) {
								BigDecimal rate = new BigDecimal(rateList
										.get(i).toString());
								opBillDetail.setRate(rate);
							}
							/*
							 * if (registrationType != null &&
							 * !registrationType.equals("")) { if
							 * (registrationType.equals("G")) { if
							 * (standardDeductionList.get(i) != null) {
							 * BigDecimal standardDeduction = new BigDecimal(
							 * standardDeductionList.get(i) .toString());
							 * opBillDetail
							 * .setStdDeductionGen(standardDeduction); } } else
							 * if (registrationType.equals("S")) { if
							 * (standardDeductionList.get(i) != null) {
							 * BigDecimal standardDeduction = new BigDecimal(
							 * standardDeductionList.get(i) .toString());
							 * opBillDetail
							 * .setStdDeductionSpl(standardDeduction); }
							 * 
							 * } }
							 */
							if (amountList.get(i) != null
									&& !(amountList.get(i).toString())
											.equals("")) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								opBillDetail.setAmount(amount);
							}
							if (disPercentList.size() > 0) {
								if (disPercentList.get(i) != null
										&& !(disPercentList.get(i).toString())
												.equals("")) {
									BigDecimal discountPercent = new BigDecimal(
											disPercentList.get(i).toString());
									opBillDetail
											.setDiscountPercent(discountPercent);
								}
							}
							if (discountList.size() > 0) {
								if (discountList.get(i) != null
										&& !(discountList.get(i).toString())
												.equals("")) {
									BigDecimal discount = new BigDecimal(
											discountList.get(i).toString());
									opBillDetail.setDiscountAmt(discount);
								}
							}
							if (proportionalDiscountList.size() > 0) {
								if (proportionalDiscountList.get(i) != null
										&& !(proportionalDiscountList.get(i)
												.toString()).equals("")) {
									BigDecimal proportionalDiscount = new BigDecimal(
											proportionalDiscountList.get(i)
													.toString());
									opBillDetail
											.setProportionalDiscountAmount(proportionalDiscount);
								}
							}
							if (netAmountList.get(i) != null
									&& !(netAmountList.get(i).toString())
											.equals("")) {
								BigDecimal netAmount = new BigDecimal(
										netAmountList.get(i).toString());
								opBillDetail.setNetAmt(netAmount);
							}
							if (qtyList.get(i) != null
									&& !(qtyList.get(i).toString()).equals("")) {
								int qty = Integer.parseInt(qtyList.get(i)
										.toString());
								opBillDetail.setQuantity(qty);
							}
							opBillDetail.setBillDate(changeDate);
							opBillDetail.setBillTime(time);
							opBillDetail.setChangedBy(user);
							opBillDetail.setOpBillHeader(opBillHeader);
							opBillDetail.setRefundableStatus("y");
							try {
								hbt.save(opBillDetail);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}
					}
				}
				// ------------------Saving Data into bl_receipt_header
				// table-------------------------
				System.out.println("Data >>>>>>>>flag >>>>>>>> "+dataMap.get("flag"));
				if(dataMap.get("flag").equals("P")){
				BlReceiptHeader receiptHeader = new BlReceiptHeader();

				if (dataMap.get("receiptHeader") != null) {
					receiptHeader = (BlReceiptHeader) dataMap
							.get("receiptHeader");
					String receiptNo = "";
					receiptNo = generateReceiptNo("save",hospitalId);
					receiptHeader.setReceiptNo(receiptNo);
					receiptHeader.setOpBillHeader(opBillHeader); 
					try {
						hbt.save(receiptHeader);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
					// ------------------Saving Data into bl_receipt_detail
					// table-------------------------

					if (dataMap.get("payModeList") != null) {
						payModeList = (List) dataMap.get("payModeList");
						if (payModeList.size() > 0) {
							for (int i = 0; i < payModeList.size(); i++) {
								BlReceiptDetails receiptDetails = new BlReceiptDetails();
								if (payModeList.get(i) != null) {
									receiptDetails.setPaymentMode(payModeList
											.get(i).toString());
									if (!(amtReceivedList.get(i).equals(""))) {
										BigDecimal amtReceived = new BigDecimal(
												amtReceivedList.get(i)
														.toString());
										receiptDetails.setAmount(amtReceived);
									}
									if (chqNoList.get(i) != null
											&& !(chqNoList.get(i).toString()
													.equals(""))) {
										receiptDetails.setChequeNo(chqNoList
												.get(i).toString());
									}
									if (chqDateList.size() > 0
											&& !(chqDateList.get(i).toString()
													.equals(""))) {
										receiptDetails
												.setChequeDate(HMSUtil
														.convertStringTypeDateToDateType(chqDateList
																.get(i)
																.toString()));
									}

									if (bankNameList.get(i) != null
											&& !(bankNameList.get(i).toString()
													.equals(""))) {
										MasBankMaster bankMaster = new MasBankMaster();
										bankMaster.setId(Integer
												.parseInt(bankNameList.get(i)
														.toString()));
										receiptDetails.setBank(bankMaster);
									}
									receiptDetails.setReceiptDate(changeDate);
									receiptDetails.setReceiptTime(time);
									receiptDetails.setChangedBy(user);
									receiptDetails
											.setReceiptHeader(receiptHeader);
									try {
										hbt.save(receiptDetails);
									} catch (DataAccessException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			
			flag = true;
			// ------------------Update past due in patient
			// table-------------------------

			if (flag) {
				BigDecimal pastDueBD = new BigDecimal(0);
				if (hinId != 0) {
					Patient patient = (Patient) hbt.load(Patient.class, hinId);
//					String pastDue = "";
//					if (patient.getPastDue() != null)
//						pastDue = patient.getPastDue();

//					String sign = "";
//					if (pastDue != null && !pastDue.equals("")
//							&& !pastDue.equals("0")) {
//						sign = pastDue.substring(0, 1);
//						pastDueBD = new BigDecimal(pastDue);
//						if (sign.equals("-")) {
//							if (!advAdj.equals(0)) {
//								pastDueBD = pastDueBD.add(advAdj);
//							}
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.subtract(outstanding);
//							}
//						} else {
//							if (!outstanding.equals(0)) {
//								pastDueBD = pastDueBD.add(outstanding);
//							}
//						}
//					} else {
//						if (!outstanding.equals(0)) {
//							pastDueBD = pastDueBD.add(outstanding);
//						}
//						if (!avAdvAmtId.equals(0)) {
//							pastDueBD = pastDueBD.add(avAdvAmtId);
//						}
//						if (!remainCId.equals(0)) {
//							pastDueBD = pastDueBD.add(remainCId);
//						}
//					}
						pastDueBD = pastDueBD.add(avAdvAmtId);					
						if (!remainCId.equals(0)) {
							pastDueBD = pastDueBD.add(remainCId);
						}					
					patient.setPastDue(pastDueBD.toString());
					hbt.update(patient);
				}}}
				// ------------------Saving Data into dg_orderhd
				// table-------------------------

				boolean diag = false;
				System.out.println("deptCodeid"+deptCodeList.size());
				for (int i = 0; i < deptCodeList.size(); i++) {
					if (deptCodeList.get(i).equals("RADIO")
							|| deptCodeList.get(i).equals("DIAG")
							|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {
						diag = true;
						break;
					}
				}
				DgOrderhd orderhd = new DgOrderhd();
				if (diag == true) {
					int orderId = 0;
					try {
						if (dataMap.get("orderNo") != null) {
							orderhd = (DgOrderhd) dataMap.get("orderNo");
							orderhd.setBillChargeSlpNo(billNo);
							hbt.update(orderhd);
						} else if (dataMap.get("orderId") != null) {
							orderId = (Integer) dataMap.get("orderId");
							DgOrderhd dgOrderHd = (DgOrderhd) hbt.load(
									DgOrderhd.class, orderId);
							dgOrderHd.setBillChargeSlpNo(billNo);
							hbt.update(dgOrderHd);
							orderhd.setId(orderId);
						}

					} catch (RuntimeException e1) {
						e1.printStackTrace();
					}

					// ------------------Save or Update Data into dg_orderdt
					// table-------------------------

					if (dataMap.get("chargeList") != null) {
						chargeList = (List) dataMap.get("chargeList");
					}

					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					if (chargeList.size() > 0) {
						for (int l = 0; l < chargeList.size(); l++) {
							if (!chargeList.get(l).equals("")
									&& orderDetailIdList.get(l).toString()
											.equals("")) {
								if (deptCodeList.get(l).toString()
										.equals("RADIO")) {
									if (hinId != 0) {
										Patient patient = new Patient();
										patient.setId(hinId);
										collHeader.setHin(patient);
									}
									MasDepartment department = new MasDepartment();
									department.setId(Integer
											.parseInt(deptIdList.get(l)
													.toString()));
									collHeader.setDepartment(department);
									collHeader.setHospital(hospital);
									collHeader.setOrder(orderhd);
									collHeader.setDiagnosisDate(changeDate);
									collHeader.setDiagnosisTime(time);
									collHeader.setOrderStatus("P");
									collHeader
											.setSampleValidationDate(changeDate);
									collHeader.setSampleValidationTime(time);
									Users user1 = new Users();
									user1.setId(userId);
									collHeader.setLastChgBy(user1);
									collHeader.setLastChgDate(changeDate);
									collHeader.setLastChgTime(time);

									hbt.save(collHeader);
									break;
								}
							}
						}
					}
					System.out.println("charge"+chargeList.size());
				
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {
							System.out.println("dept"+deptCodeList.get(i));
							if (deptCodeList.get(i).equals("RADIO")
									|| deptCodeList.get(i).equals("DIAG")
									|| deptCodeList.get(i).equals("PHYO") || deptCodeList.get(i).equals("LAB")) {

								if (!chargeList.get(i).equals("")
										&& orderDetailIdList.get(i).toString()
												.equals("")) {
									DgOrderdt orderdt = new DgOrderdt();
									orderdt.setOrderhd(orderhd);
									MasChargeCode masChargeCode = new MasChargeCode();
									if (chargeList.get(i) != null
											&& !(chargeList.get(i).toString())
													.equals("")) {
										int chargeId = Integer
												.parseInt(chargeList.get(i)
														.toString());
										masChargeCode.setId(chargeId);
										orderdt.setChargeCode(masChargeCode);

										if (qtyList.get(i) != null
												&& !(qtyList.get(i).toString())
														.equals("")) {
											int qty = Integer.parseInt(qtyList
													.get(i).toString());
											orderdt.setOrderQty(qty);
										}
										if (netAmountList.get(i) != null
												&& !(netAmountList.get(i)
														.toString()).equals("")) {
											BigDecimal netAmount = new BigDecimal(
													netAmountList.get(i)
															.toString());
											orderdt.setAmount(netAmount);
										}
										if (!mainChargeList.get(i).toString()
												.equals("")) {
											int mainChargeId = Integer
													.parseInt(mainChargeList
															.get(i).toString());
											MasMainChargecode mainChargecode = new MasMainChargecode();
											mainChargecode.setId(mainChargeId);
											orderdt.setMainChargecode(mainChargecode);
										}
										if (!subChargeList.get(i).toString()
												.equals("")) {
											int subChargeId = Integer
													.parseInt(subChargeList
															.get(i).toString());
											MasSubChargecode subChargecode = new MasSubChargecode();
											subChargecode.setId(subChargeId);
											orderdt.setSubChargeid(subChargecode);
										}
										orderdt.setPaymentMade("y");
										orderdt.setOrderStatus("P");
										orderdt.setLastChgDate(changeDate);
										orderdt.setLastChgTime(time);
										Users user2 = new Users();
										user2.setId(userId);
										orderdt.setLastChgBy(user2);
										orderdt.setBill(opBillHeader);
										try {
											hbt.saveOrUpdate(orderdt);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}

									}
									if (deptCodeList.get(i).toString()
											.equals("RADIO")) {
										DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
										collDetails
												.setSampleCollectionHeader(collHeader);
										collDetails
												.setChargeCode(masChargeCode);
										String diagNo = generateDiagNumber(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setDiagNo(diagNo);
										collDetails.setCollected("y");
										Users user3 = new Users();
										user3.setId(userId);
										collDetails.setLastChgBy(user3);
										collDetails.setLastChgDate(changeDate);
										collDetails.setLastChgTime(time);
										collDetails.setOrderStatus("P");
										collDetails
												.setSampleCollDatetime(changeDate);
										MasMainChargecode maincharge = new MasMainChargecode();
										maincharge.setId(Integer
												.parseInt(mainChargeList.get(i)
														.toString()));
										collDetails.setMaincharge(maincharge);
										MasSubChargecode subCharge = new MasSubChargecode();
										subCharge.setId(Integer
												.parseInt(subChargeList.get(i)
														.toString()));
										collDetails.setSubcharge(subCharge);
										DgMasInvestigation investigation = new DgMasInvestigation();
										investigation.setId(Integer
												.parseInt(chargeList.get(i)
														.toString()));
										collDetails
												.setInvestigation(investigation);
										collDetails
												.setSampleCollDatetime(new Date());
										hbt.save(collDetails);
									}
								} else if (!orderDetailIdList.get(i).toString()
										.equals("")) {
									DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(
											DgOrderdt.class,
											(Integer.parseInt(orderDetailIdList
													.get(i).toString())));
									dgOrderdt.setPaymentMade("y");
									dgOrderdt.setBill(opBillHeader);
									hbt.saveOrUpdate(dgOrderdt);

								}
							}
						}
					}
					/*if(null !=orderhd && null !=orderhd.getId()){
					try {
						billingMasterDataService.pacsMethodForPacsServer(hospitalId,orderhd.getId());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}*/
					final int patientId=0;
					final int orderHdId=orderhd.getId();
					final String puhid=patientUhid;
					//new Thread(){
						//public void run(){
							try {
								billingMasterDataService.pacsMethodForPacsServer(orderhospitalId,orderHdId,puhid); //Commented By OM Tripathi 28/08/2017 Taking unabailable db and taking times
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						//}
					//}.start();
				}else{
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {
					if (!prcDtIdList.get(i).toString()
							.equals("")) {
						ProcedureDetails proDt = (ProcedureDetails) hbt.load(ProcedureDetails.class,
								(Integer.parseInt(prcDtIdList
										.get(i).toString())));
						
						proDt.setBillStatus("c");
						hbt.update(proDt);
					}
						}

					}
					
				}
				
			 
				// ---------------------- Voucher Entry for
				// Accounts----------------------------

				try {
					/*
					 * FaVoucherHeader voucherHeader = new FaVoucherHeader(); if
					 * (dataMap.get("voucherHeader") != null) { voucherHeader =
					 * (FaVoucherHeader) dataMap .get("voucherHeader");
					 * voucherHeader.setBill(opBillHeader);
					 * hbt.save(voucherHeader); } if (chargeList.size() > 0) {
					 * for (int j = 0; j < chargeList.size(); j++) { if
					 * (!chargeList.get(j).equals("")) { FaVoucherDetails
					 * voucherDetails = new FaVoucherDetails(); BigDecimal
					 * amount = new BigDecimal(0);
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital);
					 * voucherDetails.setNaration("For Services"); if
					 * (!accountIdList.get(j).equals("")) { FaMasAccount
					 * masAccount = new FaMasAccount(); masAccount.setId(Integer
					 * .parseInt(accountIdList.get(j) .toString()));
					 * voucherDetails.setAcc(masAccount); } if
					 * (!subAccountIdList.get(j).equals("")) { FaMasSubLed
					 * masSubLed = new FaMasSubLed(); masSubLed.setId(Integer
					 * .parseInt(subAccountIdList.get(j) .toString()));
					 * voucherDetails.setSubLed(masSubLed); } if
					 * (!amountList.get(j).equals("")) { amount = new
					 * BigDecimal(amountList.get(j) .toString());
					 * voucherDetails.setCrBalance(amount); }
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(changeDate);
					 * voucherDetails.setLastChgTime(time);
					 * voucherDetails.setLastChgBy(userName);
					 * hbt.save(voucherDetails);
					 * 
					 * BigDecimal crBalanceForAc = new BigDecimal(0); BigDecimal
					 * crBalanceForSbldAc = new BigDecimal( 0); if
					 * (!accountIdList.get(j).equals("")) { FaMasAccount accObj
					 * = (FaMasAccount) hbt .load(FaMasAccount.class, Integer
					 * .parseInt(accountIdList .get(j).toString()));
					 * 
					 * if (accObj.getCrBalance() != null) crBalanceForAc =
					 * accObj.getCrBalance(); accObj.setCrBalance(crBalanceForAc
					 * .add(amount)); hbt.update(accObj); }
					 * 
					 * if (!subAccountIdList.get(j).equals("")) { FaMasSubLed
					 * subLed = (FaMasSubLed) hbt .load(FaMasSubLed.class,
					 * Integer .parseInt(subAccountIdList .get(j).toString()));
					 * if (subLed.getCrBalance() != null) crBalanceForSbldAc =
					 * subLed .getCrBalance();
					 * subLed.setCrBalance(crBalanceForSbldAc .add(amount));
					 * hbt.update(subLed); } } } } FaMasAccount accountObj = new
					 * FaMasAccount(); FaMasSubLed subLedObj = new
					 * FaMasSubLed(); if (payModeList.size() > 0) { for (int k =
					 * 0; k < payModeList.size(); k++) { if
					 * (!payModeList.get(k).equals("")) { FaVoucherDetails
					 * voucherDetails = new FaVoucherDetails(); BigDecimal
					 * amount = new BigDecimal(0);
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital); FaMasAccount acc =
					 * new FaMasAccount(); FaMasSubLed subLed = new
					 * FaMasSubLed();
					 * 
					 * if (payModeList.get(k).toString().equals("C")) {
					 * voucherDetails.setNaration("Cash Payment"); acc.setId(2);
					 * subLed.setId(4);
					 * 
					 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class,
					 * 2); subLedObj = (FaMasSubLed) hbt.load(
					 * FaMasSubLed.class, 4); } else if
					 * (payModeList.get(k).toString() .equals("Q") ||
					 * payModeList.get(k).toString() .equals("R")) {
					 * voucherDetails
					 * .setNaration("Credit Card/Cheque Payment"); acc.setId(6);
					 * subLed.setId(5);
					 * 
					 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class,
					 * 6); subLedObj = (FaMasSubLed) hbt.load(
					 * FaMasSubLed.class, 5); } voucherDetails.setAcc(acc);
					 * voucherDetails.setSubLed(subLed);
					 * 
					 * if (!amtReceivedList.get(k).equals("")) { amount = new
					 * BigDecimal(amtReceivedList .get(k).toString());
					 * voucherDetails.setDrBalance(amount); }
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(changeDate);
					 * voucherDetails.setLastChgTime(time);
					 * voucherDetails.setLastChgBy(userName);
					 * hbt.save(voucherDetails);
					 * 
					 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
					 * drBalanceForSbldAc = new BigDecimal( 0);
					 * 
					 * if (accountObj.getDrBalance() != null) drBalanceForAc =
					 * accountObj.getDrBalance();
					 * accountObj.setDrBalance(drBalanceForAc .add(amount));
					 * hbt.update(accountObj);
					 * 
					 * if (subLedObj.getDrBalance() != null) drBalanceForSbldAc
					 * = subLedObj .getDrBalance();
					 * subLedObj.setDrBalance(drBalanceForSbldAc .add(amount));
					 * hbt.update(subLedObj); } } } BigDecimal totalDiscount =
					 * new BigDecimal(0); if (dataMap.get("totalDiscount") !=
					 * null) { totalDiscount = (BigDecimal) dataMap
					 * .get("totalDiscount"); FaVoucherDetails voucherDetails =
					 * new FaVoucherDetails(); FaMasAccount acc = new
					 * FaMasAccount(); acc.setId(7); voucherDetails.setAcc(acc);
					 * 
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital);
					 * voucherDetails.setNaration("Discount On Bill");
					 * voucherDetails.setDrBalance(totalDiscount);
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(changeDate);
					 * voucherDetails.setLastChgTime(time);
					 * voucherDetails.setLastChgBy(userName);
					 * hbt.save(voucherDetails);
					 * 
					 * FaMasAccount acnt = (FaMasAccount) hbt.load(
					 * FaMasAccount.class, 7); BigDecimal drBalance = new
					 * BigDecimal(0); if (acnt.getDrBalance() != null) drBalance
					 * = acnt.getDrBalance();
					 * acnt.setDrBalance(drBalance.add(totalDiscount));
					 * hbt.update(acnt);
					 * 
					 * }
					 * 
					 * if (dataMap.get("advAdj") != null) { FaVoucherDetails
					 * voucherDetails = new FaVoucherDetails(); FaMasAccount acc
					 * = new FaMasAccount(); acc.setId(9);
					 * voucherDetails.setAcc(acc); FaMasSubLed subLed = new
					 * FaMasSubLed(); subLed.setId(7);
					 * voucherDetails.setSubLed(subLed);
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital);
					 * voucherDetails.setNaration("Advance Adjustment");
					 * voucherDetails.setDrBalance(advAdj);
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(changeDate);
					 * voucherDetails.setLastChgTime(time);
					 * voucherDetails.setLastChgBy(userName);
					 * hbt.save(voucherDetails);
					 * 
					 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
					 * drBalanceForSbldAc = new BigDecimal(0);
					 * 
					 * FaMasAccount acntObj = (FaMasAccount) hbt.load(
					 * FaMasAccount.class, 9); if (acntObj.getDrBalance() !=
					 * null) drBalanceForAc = acntObj.getDrBalance();
					 * acntObj.setDrBalance(drBalanceForAc.add(advAdj));
					 * hbt.update(acntObj);
					 * 
					 * FaMasSubLed sbLdObj = (FaMasSubLed) hbt.load(
					 * FaMasSubLed.class, 7); if (sbLdObj.getDrBalance() !=
					 * null) drBalanceForSbldAc = sbLdObj.getDrBalance();
					 * sbLdObj.setDrBalance(drBalanceForSbldAc.add(advAdj));
					 * hbt.update(sbLdObj); }
					 * 
					 * if (dataMap.get("outstanding") != null) {
					 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
					 * FaMasAccount acc = new FaMasAccount(); acc.setId(8);
					 * voucherDetails.setAcc(acc);
					 * 
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital);
					 * voucherDetails.setNaration("Outstanding");
					 * voucherDetails.setDrBalance(outstanding);
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(changeDate);
					 * voucherDetails.setLastChgTime(time);
					 * voucherDetails.setLastChgBy(userName);
					 * hbt.save(voucherDetails);
					 * 
					 * FaMasAccount faAcntObj = (FaMasAccount) hbt.load(
					 * FaMasAccount.class, 8); BigDecimal drBalance = new
					 * BigDecimal(0); if (faAcntObj.getDrBalance() != null)
					 * drBalance = faAcntObj.getDrBalance();
					 * faAcntObj.setDrBalance(drBalance.add(outstanding));
					 * hbt.update(faAcntObj); }
					 */

					// Update Temp Bill Table after bill generation (Only in
					// Case of Temporary Bill)---------------------------
					int tempBillHdId = 0;
					if (dataMap.get("tempBillHdId") != null) {
						tempBillHdId = (Integer) dataMap.get("tempBillHdId");
						BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
						tempOpBillHeader = (BlTempOpBillHeader) hbt.load(
								BlTempOpBillHeader.class, tempBillHdId);
						tempOpBillHeader.setBillStatus("n");
						hbt.update(tempOpBillHeader);
					}
					List<Visit> visitList = new ArrayList<Visit>();
					visitList = session.createCriteria(Visit.class)
							.add(Restrictions.eq("Id", visitIdNew)).list();
					for (Visit visit : visitList) {
						visit.setVisitStatus("w");
						visit.setStatus("y");
						hbt.update(visit);
					}

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			
			if(surgeryHdId!=0){
				OpdSurgeryHeader surgeryHeader = (OpdSurgeryHeader)hbt.load(OpdSurgeryHeader.class, surgeryHdId);
				surgeryHeader.setBillingStatus("y");
				surgeryHeader.setBillChargeSlpNo(billNo);
				hbt.update(surgeryHeader);
				
			}
			
			tx.commit();
			hbt.flush();
			hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		/*
		 * finally { if(session!=null){ session.close(); } }
		 */

		map.put("saved", saved);
		return map;
	}

	/**
	 * Method to generate (or Display) Bill No using bl_parameter Table
	 * 
	 */
	@SuppressWarnings("unchecked")
	public synchronized String generateBillNo(String billType, String flag,int hospitalId) {
		Integer billSeqNo = 0;
		List<BlParameter> billSeqNoList = new ArrayList<BlParameter>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();

		Session session = (Session) getSession();
		try {
			billSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "BS"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
			/*session
					.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Prefix", "BS"))
					.setProjection(
							Projections.projectionList()
									.add(Projections.property("BillSubType"))
									.add(Projections.property("Id"))
									.add(Projections.property("SeqNo"))
									.add(Projections.property("BillType")))
					.list();*/
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * String lastBlNo = ""; if (billType.equals("OS")) { opBlHeaderList =
		 * session.createCriteria(BlOpBillHeader.class) .list(); if
		 * (opBlHeaderList.size() > 0) { for (BlOpBillHeader opBlHeader :
		 * opBlHeaderList) { lastBlNo = opBlHeader.getBillNo(); } } } else {
		 * dispHeaderList = session.createCriteria(BlDispensingHeader.class)
		 * .list();
		 * 
		 * if (dispHeaderList.size() > 0) { for (BlDispensingHeader dispHeader :
		 * dispHeaderList) { lastBlNo = dispHeader.getBillNo(); } } }
		 */
		int id = 0;
		// String criteria = "";
		int seqNo = 0;
		if (billSeqNoList.size() > 0) {			
				for (BlParameter blParameter : billSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				billSeqNo = ++seqNo;
			}
			// billNo = commonSeqNo(billSeqNo, criteria, lastBlNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(billSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			billSeqNo = 1;
			blParameter.setSeqNo(billSeqNo);
			blParameter.setPrefix("BS");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		}
		hbt.flush();
		//hbt.clear();
		String blNo = billSeqNo.toString();
		return blNo;
	}

	@SuppressWarnings("unchecked")
	public synchronized String generateReceiptNo(String flag,int hospitalId) {
		Integer receiptSeqNo = 0;
		List<BlParameter> rcSeqNoList = new ArrayList<BlParameter>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		try {
			rcSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "RC"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * receiptHeaderList = session.createCriteria(BlReceiptHeader.class)
		 * .list(); String lastRcNo = ""; if (receiptHeaderList.size() > 0) {
		 * for (BlReceiptHeader receiptHeader : receiptHeaderList) { lastRcNo =
		 * receiptHeader.getReceiptNo(); } }
		 */
		int id = 0;
		int seqNo = 0;
		// String criteria = "";
		if (rcSeqNoList.size() > 0) {
			for (BlParameter blParameter : rcSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				receiptSeqNo = ++seqNo;
			}
			// receiptNo = commonSeqNo(receiptSeqNo, criteria, lastRcNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(receiptSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			receiptSeqNo = 1;
			blParameter.setSeqNo(receiptSeqNo);
			blParameter.setPrefix("RC");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		
		}
		String recNo = receiptSeqNo.toString();
		
		hbt.flush();
		return recNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrderNoTempBillNoForBilling(String hin) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> tempList = new ArrayList<DgOrderhd>();
		List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();

		try {
			Session session = getSession();

			orderNoList = session
					.createCriteria(DgOrderhd.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hin))
					.add(Restrictions.eq("p.PatientStatus", "Out Patient")
							.ignoreCase()).list();

			if (orderNoList.size() > 0) {
				for (DgOrderhd orderhd : orderNoList) {
					boolean flag = false;

					Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
					orderDtSet = orderhd.getDgOrderdts();
					for (DgOrderdt orderdt : orderDtSet) {
						if (orderdt.getPaymentMade().equalsIgnoreCase("y")) {
							if (orderdt.getChargeCode().getDepartment()
									.getDepartmentType()
									.getDepartmentTypeName()
									.equalsIgnoreCase("RADIO")) {
								flag = true;
								break;
							}
						}
					}
					if (flag) {
						tempList.add(orderhd);
					}
				}
				map.put("orderNoList", tempList);
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

			tempBillList = session.createCriteria(BlTempOpBillHeader.class)
					.add(Restrictions.eq("TempBillDate", date))
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hin))
					.add(Restrictions.eq("BillStatus", "y").ignoreCase())
					.add(Restrictions.eq("BillType", "servicing")).list();
			if (tempBillList.size() > 0) {
				map.put("tempBillList", tempBillList);

			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Method to generate diag no for sample
	 * collection-----------------------------
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String generateDiagNumber(int subChargeId) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
		List<Integer> maxIdDgDetailsList = new ArrayList<Integer>();
		List<DgSampleCollectionDetails> dgDetailsList = new ArrayList<DgSampleCollectionDetails>();
		Session session = (Session) getSession();
		try {
			diagSeqNoList = session.createCriteria(DiagParam.class)
					.createAlias("SubCharge", "sc")
					.add(Restrictions.eq("sc.Id", subChargeId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * dgDetailsList =
		 * session.createCriteria(DgSampleCollectionDetails.class) .list();
		 * String lastDiagNo = ""; if (dgDetailsList.size() > 0) { for
		 * (DgSampleCollectionDetails collDetails : dgDetailsList) { lastDiagNo
		 * = collDetails.getDiagNo(); } }
		 */

		maxIdDgDetailsList = session
				.createCriteria(DgSampleCollectionDetails.class)
				.setProjection(Projections.max("Id")).list();
		String lastDiagNo = "";
		if (maxIdDgDetailsList.size() > 0) {

			dgDetailsList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("Id", maxIdDgDetailsList.get(0)))
					.list();

			if (dgDetailsList.size() > 0) {
				lastDiagNo = dgDetailsList.get(0).getDiagNo();
				if (lastDiagNo == null) {
					lastDiagNo = "1";
				}
			} else {
				lastDiagNo = "1";
			}
		}
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		StringTokenizer str = new StringTokenizer(lastDiagNo, "/");

		int id = 0;
		String criteria = "";
		int seqNo = 0;
		String subcharge = "";
		if (diagSeqNoList.size() > 0) {
			for (DiagParam dgParam : diagSeqNoList) {
				id = dgParam.getId();
				seqNo = dgParam.getSeqNo();
				subcharge = dgParam.getSubCharge().getSubChargecodeCode();
				criteria = dgParam.getCriteria();
				dgSeqNo = ++seqNo;

			}
			if (criteria.equalsIgnoreCase("c")) {
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}

				diagSeqNo = dgSeqNo.toString().concat("/").concat(currentYear)
						.concat(subcharge).concat("/").concat(currentMonth)
						.concat("/").concat(currentYear);
			}
			DiagParam diagParam = (DiagParam) hbt.load(DiagParam.class, id);
			diagParam.setSeqNo(dgSeqNo);
			hbt.update(diagParam);

		}
		return diagSeqNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPrescriptionAndTempBillNo(String hin) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientPrescriptionHeader> prescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
		Session session = getSession();

		prescriptionList = session
				.createCriteria(PatientPrescriptionHeader.class)
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hin))
				.add(Restrictions.eq("p.PatientStatus", "Out Patient")).list();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		tempBillList = session.createCriteria(BlTempOpBillHeader.class)
				.add(Restrictions.eq("TempBillDate", date))
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hin))
				.add(Restrictions.eq("BillStatus", "y"))
				.add(Restrictions.eq("BillType", "dispensing")).list();
		if (tempBillList.size() > 0) {
			map.put("tempBillList", tempBillList);

		}

		map.put("prescriptionList", prescriptionList);
		return map;
	}

	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * getPatientDetailsForBillDispensing(Box box) { Map<String, Object> map =
	 * new HashMap<String, Object>(); List<Patient> patientList = new
	 * ArrayList<Patient>(); List<PatientPrescriptionHeader> presHdList = new
	 * ArrayList<PatientPrescriptionHeader>(); List<PatientPrescriptionDetails>
	 * presDetailList = new ArrayList<PatientPrescriptionDetails>();
	 * List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 * 
	 * List<BlTempOpBillHeader> tempBillList = new
	 * ArrayList<BlTempOpBillHeader>(); List<Object[]> itemWiseList = new
	 * ArrayList<Object[]>(); List<Patient> inpatientList = new
	 * ArrayList<Patient>();
	 * 
	 * Map<String, Object> utilMap = new HashMap<String, Object>(); utilMap =
	 * (Map<String, Object>) HMSUtil.getCurrentDateAndTime(); String currentDate
	 * = (String) utilMap.get("currentDate"); Date date =
	 * HMSUtil.convertStringTypeDateToDateType(currentDate); String uhid = "";
	 * int visitId =0; Criteria crit=null; String visit=""; int
	 * patientHinNumer=0; String patientName=""; String hinNo = ""; String
	 * prescriptionNo = ""; hinNo = box.getString(HIN_NO); prescriptionNo =
	 * box.getString(PRESCRIPTION_NO); String tempBillNo =
	 * box.getString("tempBillNo");
	 * 
	 * uhid = box.getString("uhid"); patientHinNumer=box.getInt("phinNumer");
	 * visitId = Integer.parseInt(box.getString("visitId"));
	 * 
	 * 
	 * Session session = getSession();
	 * 
	 * if (!uhid.equals("")) {
	 * 
	 * patientList = session.createCriteria(Patient.class)
	 * .add(Restrictions.eq("HinNo", uhid))
	 * .add(Restrictions.eq("PatientStatus", "Out Patient")) .list(); }
	 * 
	 * if(patientHinNumer>0 &&visitId>0 ){
	 * 
	 * presHdList=session.createCriteria(PatientPrescriptionHeader.class).
	 * createAlias("Visit", "v").createAlias("Hin", "h")
	 * .add(Restrictions.eq("h.Id", patientHinNumer))
	 * .add(Restrictions.eq("v.Id", visitId)) .list();
	 * 
	 * int prescriptionDetailId=0;
	 * 
	 * for(PatientPrescriptionHeader pres:presHdList){
	 * prescriptionDetailId=pres.getId();
	 * presDetailList=session.createCriteria(PatientPrescriptionDetails.class)
	 * .add(Restrictions.eq("Id", prescriptionDetailId)).list();
	 * 
	 * map.put("presDetailList", presDetailList); } } crit=
	 * session.createCriteria(MasEmployee.class); employeeList=crit.list();
	 * if(employeeList.size()>0){
	 * System.out.println("employeeList>>"+employeeList.size());
	 * 
	 * 
	 * } map.put("employeeList", employeeList); if (!prescriptionNo.equals(""))
	 * { presHdList = session .createCriteria(PatientPrescriptionHeader.class)
	 * .add(Restrictions.eq("PrescriptionNo", prescriptionNo))
	 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo", hinNo))
	 * .add(Restrictions.eq("hin.PatientStatus", "Out Patient")) .list(); if
	 * (presHdList.size() > 0) { PatientPrescriptionHeader preHeader = new
	 * PatientPrescriptionHeader(); patientList.add(preHeader.getHin());
	 * map.put("presHdList", presHdList); } }
	 * 
	 * if (!tempBillNo.equals("")) { tempBillList =
	 * session.createCriteria(BlTempOpBillHeader.class)
	 * .add(Restrictions.eq("TempBillNo", tempBillNo))
	 * .add(Restrictions.eq("TempBillDate", date)) .createAlias("Hin", "hin")
	 * .add(Restrictions.eq("hin.PatientStatus", "Out Patient")) .list(); if
	 * (tempBillList.size() > 0) {
	 * 
	 * BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
	 * tempOpBillHeader = tempBillList.get(0);
	 * patientList.add(tempOpBillHeader.getHin());
	 * 
	 * map.put("tempBillList", tempBillList);
	 * 
	 * itemWiseList = session .createCriteria(BlTempBillDispensingDetails.class)
	 * .createAlias("TempOpBillHeader", "tbh")
	 * .add(Restrictions.eq("tbh.TempBillNo", tempBillNo))
	 * .add(Restrictions.eq("TempBillDate", date)) .createAlias("Item", "i")
	 * .createAlias("i.AccountGroup", "ag", CriteriaSpecification.LEFT_JOIN)
	 * .createAlias("i.SubAccountGroup", "sag", CriteriaSpecification.LEFT_JOIN)
	 * .createAlias("i.SalesTaxType", "st", CriteriaSpecification.LEFT_JOIN)
	 * .setProjection( Projections .projectionList()
	 * .add(Projections.property("i.Id")) .add(Projections.property("i.PvmsNo"))
	 * .add(Projections .property("i.Nomenclature"))
	 * .add(Projections.sum("Qty")) .add(Projections.sum("Amount"))
	 * .add(Projections .property("DiscountPercent"))
	 * .add(Projections.sum("DiscountAmt")) .add(Projections
	 * .sum("ProportionalDisAmt")) .add(Projections.sum("NetAmt"))
	 * .add(Projections.property("ag.Id")) .add(Projections.property("sag.Id"))
	 * .add(Projections.property("st.SaleTax"))
	 * .add(Projections.groupProperty("i.Id"))) .list();
	 * 
	 * map.put("itemWiseList", itemWiseList); }
	 * 
	 * } if (patientList.size() > 0) map.put("patientList", patientList); else {
	 * inpatientList = session.createCriteria(Patient.class)
	 * .add(Restrictions.eq("HinNo", hinNo))
	 * .add(Restrictions.eq("PatientStatus", "In Patient")).list(); if
	 * (inpatientList.size() > 0) { map.put("inpatientList", inpatientList); } }
	 * if (patientList.size() > 0){ map.put("patientList", patientList); }
	 * String maxBlNo = ""; String billType = "OD"; maxBlNo =
	 * generateBillNo(billType, "display"); map.put("maxBlNo", maxBlNo);
	 * 
	 * return map; }
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemCodeForAutoComplete(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemGroupId = 0;
		int itemGenericId = 0;

		String nameField = "";
		String autoHint = "";
		nameField = box.getString("requiredField");
		autoHint = box.getString(nameField);
		itemTypeId = box.getInt("itemTypeId");
		itemCategoryId = box.getInt("itemCatgryId");
		itemGroupId = box.getInt("itemGrpId");
		itemGenericId = box.getInt("itemGenId");

		Session session = getSession();
		try {
			Criteria crit = session.createCriteria(MasStoreItem.class);
			crit = crit.add(Restrictions.like("Nomenclature", autoHint + "%"));
			if (itemTypeId != 0) {
				crit = crit.createAlias("ItemType", "it").add(
						Restrictions.eq("it.Id", itemTypeId));
			}
			if (itemCategoryId != 0) {
				crit = crit.createAlias("ItemCategory", "ic").add(
						Restrictions.eq("ic.Id", itemCategoryId));
			}
			if (itemGroupId != 0) {
				crit = crit.createAlias("Group", "ig").add(
						Restrictions.eq("ig.Id", itemGroupId));
			}
			if (itemGenericId != 0) {
				crit = crit.createAlias("ItemGeneric", "gen").add(
						Restrictions.eq("gen.Id", itemGenericId));
			}
			itemList = crit.list();
			if (itemList.size() > 0) {
				map.put("itemList", itemList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemBatchNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchStockList = new ArrayList<StoreItemBatchStock>();
		String itemCode = "";
		itemCode = box.getString("itemCode");
		System.out.println("itemCode " + itemCode);
		System.out.println("deptCode  " + box.getString("deptCode"));
		Session session = getSession();
		batchStockList = session
				.createCriteria(StoreItemBatchStock.class)
				.createAlias("Department", "dept")
				.createAlias("Item", "it")
				.add(Restrictions.like("dept.DepartmentCode",
						box.getString("deptCode")))
				.add(Restrictions.like("it.PvmsNo", itemCode))
				.add(Restrictions.ge("ClosingStock", new BigDecimal(0)))
				.addOrder(Order.asc("ExpiryDate")).list();
		System.out
				.println("batchStockList>>>>>>>>>>>." + batchStockList.size());
		map.put("batchStockList", batchStockList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForBillDispensing() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasItemCategory> itemCatgryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreItemGeneric> itemGenList = new ArrayList<MasStoreItemGeneric>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<MasPatientType> masPTypeList = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeLists = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
		List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();

		try {
			Session session = getSession();
			itemTypeList = session.createCriteria(MasItemType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			itemCatgryList = session.createCriteria(MasItemCategory.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			itemGroupList = session.createCriteria(MasStoreGroup.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			itemGenList = session.createCriteria(MasStoreItemGeneric.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			bankList = session.createCriteria(MasBankMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masPTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "F").ignoreCase()).list();
			masPTypeLists = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "S").ignoreCase()).list();
			masPTypeListo = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "O").ignoreCase()).list();
			masCharityList = session.createCriteria(MasCharityType.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			map.put("masPTypeList", masPTypeList);
			map.put("masPTypeLists", masPTypeLists);
			map.put("masPTypeListo", masPTypeListo);
			map.put("masCharityList", masCharityList);
			map.put("bankList", bankList);
			map.put("itemTypeList", itemTypeList);
			map.put("itemCatgryList", itemCatgryList);
			map.put("itemGroupList", itemGroupList);
			map.put("itemGenList", itemGenList);
			map.put("employeeList", employeeList);
			map.put("sexList", sexList);
			map.put("authorizerList", authorizerList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitBillDispensingDetails(Box box,
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int payListLength = 0;
		int batchWiseItemListLength = 0;
		int itemWiseListLength = 0;

		BigDecimal advAdj = new BigDecimal(0);
		BigDecimal outstanding = new BigDecimal(0);
		Users user = new Users();
		user.setId(box.getInt("userId"));

		Transaction tx = null;
		Session session = getSession();

		try {
			tx = session.beginTransaction();

			BlDispensingHeader dispensingHeader = new BlDispensingHeader();
			if (detailsMap.get("dispensingHeader") != null)
				dispensingHeader = (BlDispensingHeader) detailsMap
						.get("dispensingHeader");

			hbt.save(dispensingHeader);

			itemWiseListLength = box.getInt("hiddenValueItem");
			batchWiseItemListLength = box.getInt("batchNoCounter");
			payListLength = box.getInt("hiddenValuePayment");

			for (int i = 1; i <= batchWiseItemListLength; i++) {
				BlDispensingDetails dispensingDetails = new BlDispensingDetails();
				dispensingDetails.setDispensingHeader(dispensingHeader);
				if (box.getInt(BATCH_ITEM_ID + i) != 0) {
					MasStoreItem storeItem = new MasStoreItem();
					storeItem.setId(box.getInt(BATCH_ITEM_ID + i));
					dispensingDetails.setItem(storeItem);

					if (box.getInt(BATCH_ID + i) != 0) {
						StoreItemBatchStock itemBatchStock = new StoreItemBatchStock();
						itemBatchStock.setId(box.getInt(BATCH_ID + i));
						dispensingDetails.setBatch(itemBatchStock);
					}
					if (box.getString(ISSUE_QUANTITY + i) != null
							&& !box.getString(ISSUE_QUANTITY + i).equals("")) {
						dispensingDetails.setQty(new BigDecimal(box
								.getString(ISSUE_QUANTITY + i)));
					}
					if (box.getString("batchAmt" + i) != null
							&& !box.getString("batchAmt" + i).equals("")) {
						dispensingDetails.setAmount(new BigDecimal(box
								.getString("batchAmt" + i)));
					}
					if (box.getString("batchDisPer" + i) != null
							&& !box.getString("batchDisPer" + i).equals("")) {
						dispensingDetails.setDiscountPercent(new BigDecimal(box
								.getString("batchDisPer" + i)));
					}
					if (box.getString("batchDisAmt" + i) != null
							&& !box.getString("batchDisAmt" + i).equals("")) {
						dispensingDetails.setDiscountAmt(new BigDecimal(box
								.getString("batchDisAmt" + i)));
					}
					if (box.getString("batchPrptDisAmt" + i) != null
							&& !box.getString("batchPrptDisAmt" + i).equals("")) {
						dispensingDetails.setProportionalDisAmt(new BigDecimal(
								box.getString("batchPrptDisAmt" + i)));
					}
					if (!box.getString("batchSalesTaxAmt" + i).equals("")) {
						dispensingDetails.setSalesTaxAmt(new BigDecimal(box
								.getString("batchSalesTaxAmt" + i)));
					}
					if (box.getString("batchNetAmt" + i) != null
							&& !box.getString("batchNetAmt" + i).equals("")) {
						dispensingDetails.setNetAmt(new BigDecimal(box
								.getString("batchNetAmt" + i)));
					}
					dispensingDetails.setRefundableStatus("y");
					dispensingDetails.setIssued("n");
					hbt.save(dispensingDetails);
				}
			}

			BlReceiptHeader receiptHeader = new BlReceiptHeader();
			if (detailsMap.get("receiptHeader") != null) {
				receiptHeader = (BlReceiptHeader) detailsMap
						.get("receiptHeader");
				String receiptNo = "";
				receiptNo = generateReceiptNo("save",box.getInt(HOSPITAL_ID));
				receiptHeader.setReceiptNo(receiptNo);
				receiptHeader.setDispensingHeader(dispensingHeader);
				hbt.save(receiptHeader);

				for (int j = 1; j <= payListLength; j++) {
					BlReceiptDetails receiptDetails = new BlReceiptDetails();
					if (!box.getString(PAYMENT_MODE + j).equals("")) {
						receiptDetails.setPaymentMode(box
								.getString(PAYMENT_MODE + j));
					}
					if (!box.getString(AMOUNT_RECEIVED + j).equals("")) {
						receiptDetails.setAmount(new BigDecimal(box
								.getString(AMOUNT_RECEIVED + j)));
					}
					if (!box.getString(CHEQUE_NO + j).equals("")) {
						receiptDetails
								.setChequeNo(box.getString(CHEQUE_NO + j));
					}
					if (!box.getString(CHEQUE_DATE + j).equals("")) {
						receiptDetails.setChequeDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHEQUE_DATE + j)));
					}
					if (!box.getString(BANK_NAME + j).equals("")) {
						MasBankMaster bankMaster = new MasBankMaster();
						bankMaster.setId(box.getInt(BANK_NAME + j));
						receiptDetails.setBank(bankMaster);
					}
					receiptDetails.setReceiptDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					receiptDetails.setReceiptTime(box.getString(CHANGED_TIME));
					receiptDetails.setChangedBy(user);
					receiptDetails.setReceiptHeader(receiptHeader);
					hbt.save(receiptDetails);
				}
			}

			// ------------ Update blocked quantity in Store Item Batch Stock
			// table-----------

			for (int j = 1; j <= batchWiseItemListLength; j++) {
				if (box.getInt(BATCH_ID + j) != 0) {
					int batchId = box.getInt(BATCH_ID + j);
					StoreItemBatchStock batchStock = (StoreItemBatchStock) hbt
							.load(StoreItemBatchStock.class, batchId);
					BigDecimal blockedQty = new BigDecimal(0);
					BigDecimal totalBlockedQty = new BigDecimal(0);
					BigDecimal issueQty = new BigDecimal(0);

					if (batchStock.getBlockedQty() != null)
						blockedQty = batchStock.getBlockedQty();

					issueQty = new BigDecimal(box.getString(ISSUE_QUANTITY + j));
					totalBlockedQty = blockedQty.add(issueQty);
					// batchStock.setBlockedQty(totalBlockedQty);
					hbt.update(batchStock);
				}
			}

			int hinId = box.getInt(HIN_ID);
			if (detailsMap.get("advAdj") != null) {
				advAdj = new BigDecimal((String) detailsMap.get("advAdj"));
			}
			if (detailsMap.get("outstanding") != null) {
				outstanding = new BigDecimal(
						(String) detailsMap.get("outstanding"));
			}

			BigDecimal pastDueBD = new BigDecimal(0);
			if (hinId != 0) {
				Patient patient = (Patient) hbt.load(Patient.class, hinId);
				String pastDue = "";
				if (patient.getPastDue() != null)
					pastDue = patient.getPastDue();

				String sign = "";
				if (pastDue != null && !pastDue.equals("")
						&& !pastDue.equals("0")) {
					sign = pastDue.substring(0, 1);
					pastDueBD = new BigDecimal(pastDue);
					if (sign.equals("-")) {
						if (!advAdj.equals(0)) {
							pastDueBD = pastDueBD.add(advAdj);
						}
						if (!outstanding.equals(0)) {
							pastDueBD = pastDueBD.subtract(outstanding);
						}
					} else {
						if (!outstanding.equals(0)) {
							pastDueBD = pastDueBD.add(outstanding);
						}
					}
				} else {
					if (!outstanding.equals(0)) {
						pastDueBD = pastDueBD.add(outstanding);
					}
				}
				patient.setPastDue(pastDueBD.toString());
				hbt.update(patient);
			}

			// Accounts entry-----------

			/*
			 * MasHospital hospital = new MasHospital();
			 * hospital.setId(box.getInt("hospitalId"));
			 * 
			 * FaVoucherHeader voucherHeader = new FaVoucherHeader(); if
			 * (detailsMap.get("voucherHeader") != null) { voucherHeader =
			 * (FaVoucherHeader) detailsMap .get("voucherHeader");
			 * voucherHeader.setBillDispensing(dispensingHeader);
			 * hbt.save(voucherHeader); }
			 * 
			 * if (itemWiseListLength > 0) { for (int j = 1; j <=
			 * itemWiseListLength; j++) { FaVoucherDetails voucherDetails = new
			 * FaVoucherDetails(); BigDecimal amount = new BigDecimal(0);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("For Dispensing"); if
			 * (box.getInt(FA_ACCOUNT_ID + j) != 0) { FaMasAccount masAccount =
			 * new FaMasAccount(); masAccount.setId(box.getInt(FA_ACCOUNT_ID +
			 * j)); voucherDetails.setAcc(masAccount); } if
			 * (box.getInt(FA_SUB_LED_ID + j) != 0) { FaMasSubLed masSubLed =
			 * new FaMasSubLed(); masSubLed.setId(box.getInt(FA_SUB_LED_ID +
			 * j)); voucherDetails.setSubLed(masSubLed); } if
			 * (!box.getString(AMOUNT + j).equals("")) { amount = new
			 * BigDecimal(box.getString(AMOUNT + j));
			 * voucherDetails.setCrBalance(amount); }
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * BigDecimal crBalanceForAc = new BigDecimal(0); BigDecimal
			 * crBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * if (box.getInt(FA_ACCOUNT_ID + j) != 0) { FaMasAccount accObj =
			 * (FaMasAccount) hbt.load( FaMasAccount.class,
			 * box.getInt(FA_ACCOUNT_ID + j));
			 * 
			 * if (accObj.getCrBalance() != null) crBalanceForAc =
			 * accObj.getCrBalance();
			 * accObj.setCrBalance(crBalanceForAc.add(amount));
			 * hbt.update(accObj); }
			 * 
			 * if (box.getInt(FA_SUB_LED_ID + j) != 0) { FaMasSubLed subLed =
			 * (FaMasSubLed) hbt.load( FaMasSubLed.class, box
			 * .getInt(FA_SUB_LED_ID + j));
			 * 
			 * if (subLed.getCrBalance() != null) crBalanceForSbldAc =
			 * subLed.getCrBalance();
			 * subLed.setCrBalance(crBalanceForSbldAc.add(amount));
			 * hbt.update(subLed); } } } FaMasAccount accountObj = new
			 * FaMasAccount(); FaMasSubLed subLedObj = new FaMasSubLed(); if
			 * (payListLength > 0) { for (int k = 1; k <= payListLength; k++) {
			 * if (!box.getString(PAYMENT_MODE + k).equals("")) {
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * BigDecimal amount = new BigDecimal(0);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital); FaMasAccount acc = new
			 * FaMasAccount(); FaMasSubLed subLed = new FaMasSubLed();
			 * 
			 * if (box.getString(PAYMENT_MODE + k).equals("C")) {
			 * voucherDetails.setNaration("Cash Payment"); acc.setId(2);
			 * subLed.setId(4);
			 * 
			 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class, 2);
			 * subLedObj = (FaMasSubLed) hbt.load( FaMasSubLed.class, 4);
			 * 
			 * } else if (box.getString(PAYMENT_MODE + k).equals("Q") ||
			 * box.getString(PAYMENT_MODE + k).equals("R")) { voucherDetails
			 * .setNaration("Credit Card/Cheque Payment"); acc.setId(6);
			 * subLed.setId(5);
			 * 
			 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class, 6);
			 * subLedObj = (FaMasSubLed) hbt.load( FaMasSubLed.class, 5);
			 * 
			 * } voucherDetails.setAcc(acc); voucherDetails.setSubLed(subLed);
			 * 
			 * if (!box.getString(AMOUNT_RECEIVED + k).equals("")) { amount =
			 * new BigDecimal(box .getString(AMOUNT_RECEIVED + k));
			 * voucherDetails.setDrBalance(amount); }
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box .getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
			 * drBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * if (accountObj.getDrBalance() != null) drBalanceForAc =
			 * accountObj.getDrBalance();
			 * accountObj.setDrBalance(drBalanceForAc.add(amount));
			 * hbt.update(accountObj);
			 * 
			 * if (subLedObj.getDrBalance() != null) drBalanceForSbldAc =
			 * subLedObj.getDrBalance();
			 * subLedObj.setDrBalance(drBalanceForSbldAc.add(amount));
			 * hbt.update(subLedObj); } } } BigDecimal totalDiscount = new
			 * BigDecimal(0); if (detailsMap.get("totalDiscount") != null) {
			 * totalDiscount = (BigDecimal) detailsMap.get("totalDiscount");
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * 
			 * FaMasAccount acc = new FaMasAccount(); acc.setId(7);
			 * voucherDetails.setAcc(acc);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Discount On Bill");
			 * voucherDetails.setDrBalance(totalDiscount);
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * FaMasAccount acnt = (FaMasAccount) hbt.load(FaMasAccount.class,
			 * 7); BigDecimal drBalance = new BigDecimal(0); if
			 * (acnt.getDrBalance() != null) drBalance = acnt.getDrBalance();
			 * acnt.setDrBalance(drBalance.add(totalDiscount));
			 * hbt.update(acnt);
			 * 
			 * }
			 * 
			 * if (detailsMap.get("advAdj") != null) { FaVoucherDetails
			 * voucherDetails = new FaVoucherDetails(); FaMasAccount acc = new
			 * FaMasAccount(); acc.setId(9); voucherDetails.setAcc(acc);
			 * FaMasSubLed subLed = new FaMasSubLed(); subLed.setId(7);
			 * voucherDetails.setSubLed(subLed);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Advance Adjustment");
			 * voucherDetails.setDrBalance(advAdj);
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
			 * drBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * FaMasAccount acntObj = (FaMasAccount) hbt.load(
			 * FaMasAccount.class, 9); if (acntObj.getDrBalance() != null)
			 * drBalanceForAc = acntObj.getDrBalance();
			 * acntObj.setDrBalance(drBalanceForAc.add(advAdj));
			 * hbt.update(acntObj);
			 * 
			 * FaMasSubLed sbLdObj = (FaMasSubLed) hbt.load(FaMasSubLed.class,
			 * 7); if (sbLdObj.getDrBalance() != null) drBalanceForSbldAc =
			 * sbLdObj.getDrBalance();
			 * sbLdObj.setDrBalance(drBalanceForSbldAc.add(advAdj));
			 * hbt.update(sbLdObj); }
			 * 
			 * if (detailsMap.get("outstanding") != null) { FaVoucherDetails
			 * voucherDetails = new FaVoucherDetails(); FaMasAccount acc = new
			 * FaMasAccount(); acc.setId(8); voucherDetails.setAcc(acc);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Outstanding");
			 * voucherDetails.setDrBalance(outstanding);
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * FaMasAccount faAcntObj = (FaMasAccount) hbt.load(
			 * FaMasAccount.class, 8); BigDecimal drBalance = new BigDecimal(0);
			 * if (faAcntObj.getDrBalance() != null) drBalance =
			 * faAcntObj.getDrBalance();
			 * faAcntObj.setDrBalance(drBalance.add(outstanding));
			 * hbt.update(faAcntObj); }
			 */

			// Update Temp Bill Table after bill generation (Only in Case of
			// Temporary Bill)---------------------------
			int tempBillHdId = 0;
			if (box.getInt("tempBillHdId") != 0) {
				tempBillHdId = box.getInt("tempBillHdId");
				BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
				tempOpBillHeader = (BlTempOpBillHeader) hbt.load(
						BlTempOpBillHeader.class, tempBillHdId);
				tempOpBillHeader.setBillStatus("n");
				hbt.update(tempOpBillHeader);
			}
			//added by govind 15-09-2017
			Integer inpatientId=box.getInt("inpatientId");
			int chargeListLength = box.getInt("hiddenValueCharge");
			
						for(int j=1;j<chargeListLength;j++){
						Integer consumpId=box.getInt("consumpId"+j);
						List<IpWardConsumptionHeader> consumpHeaderList=new ArrayList<IpWardConsumptionHeader>();
						consumpHeaderList=session.createCriteria(IpWardConsumptionHeader.class)
								.add(Restrictions.eq("Id", consumpId))
								.add(Restrictions.eq("BillStatus", "y").ignoreCase())
								.list();
							if(consumpHeaderList.size()>0){
								IpWardConsumptionHeader consumpHeader=consumpHeaderList.get(0);
								consumpHeader.setBillStatus("n");
								hbt.update(consumpHeader);
								hbt.refresh(consumpHeader);
							}
						}
						//added by govind 15-09-2017 end
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */

		map.put("flag", flag);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBillNoForPaymentAdvice(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlOpBillHeader> billServicingNoList = new ArrayList<BlOpBillHeader>();
		List<BlOpBillHeader> billHeaderList = new ArrayList<BlOpBillHeader>();
		Set<BlOpBillDetails> billDetails = new HashSet<BlOpBillDetails>();
		List<BlDispensingHeader> billDispensingNoList = new ArrayList<BlDispensingHeader>();
		List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
		Set<BlDispensingDetails> dispensingDetails = new HashSet<BlDispensingDetails>();

		Session session = getSession();
		String billType = box.getString(BILL_TYPE);
		String hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);
		int hospitalId = 0;

		Criteria crit = null;

		if (box.get(HOSPITAL_ID) != null)
			hospitalId = Integer.parseInt("" + box.get(HOSPITAL_ID));

		if (billType.equals("servicing")) {

			billHeaderList = session.createCriteria(BlOpBillHeader.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hin))
					.createAlias("Hospital", "H")
					.add(Restrictions.eq("H.Id", hospitalId)).list();
			System.out.println("billHeaderList>>>>>>" + billHeaderList.size());
			if (billHeaderList.size() > 0) {
				for (BlOpBillHeader billHeader : billHeaderList) {
					boolean refunded = true;
					billDetails = billHeader.getBlOpBillDetails();
					for (BlOpBillDetails obj : billDetails) {
						if (obj.getRefundableStatus().equals("y")) {
							refunded = false;
							break;
						}
					}
					if (refunded == false) {
						billServicingNoList.add(billHeader);
						map.put("billServicingNoList", billServicingNoList);
					}
				}
			}
		} else if (billType.equals("dispensing")) {
			crit = session.createCriteria(BlDispensingHeader.class).add(
					Restrictions.eq("Status", "y").ignoreCase());
			if (!hin.equals("") && adNo.equals("")) {
				crit = crit.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hin))
						.add(Restrictions.isNull("Inpatient"));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();
			if (!adNo.equals("")) {
				finalBillList = session
						.createCriteria(BlFinalBillDetails.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.AdNo", adNo)).list();

			}
			if (finalBillList.size() == 0) {
				dispensingHeaderList = crit.list();
				if (dispensingHeaderList.size() > 0) {
					for (BlDispensingHeader dispensingHeader : dispensingHeaderList) {
						boolean dispensRefunded = true;
						dispensingDetails = dispensingHeader
								.getBlDispensingDetails();
						for (BlDispensingDetails obj : dispensingDetails) {
							if (obj.getRefundableStatus().equals("y")) {
								dispensRefunded = false;
								break;
							}
						}
						if (dispensRefunded == false) {
							billDispensingNoList.add(dispensingHeader);
							map.put("billDispensingNoList",
									billDispensingNoList);
						}
					}
				}
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForPaymentAdviceServicing(
			Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BlOpBillHeader> billHeaderList = new ArrayList<BlOpBillHeader>();
		List<BlOpBillHeader> billList = new ArrayList<BlOpBillHeader>();
		List<BlPaymentAdviceDetails> payAdvList = new ArrayList<BlPaymentAdviceDetails>();
		List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();
		Set<BlOpBillDetails> billDetails = new HashSet<BlOpBillDetails>();

		String billNo = "";
		String hin = "";
		billNo = box.getString(BILL_NO);
		hin = box.getString(HIN_NO);
		int hospitalId = box.getInt("hospitalId");
		Session session = getSession();
		Criteria crit = null;

		try {
			List<DgOrderhd> orderList = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("BillChargeSlpNo", billNo))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.ne("OrderStatus", "p").ignoreCase()).list();
			System.out.println(orderList.size());
			if(orderList.size()==0){
			crit = session.createCriteria(BlOpBillHeader.class).add(
					Restrictions.eq("BillNo", billNo));

			if (!hin.equals("")) {
				crit = crit.createAlias("Hin", "p").add(
						Restrictions.eq("p.HinNo", hin));
			}
			billHeaderList = crit.list();
			if (billHeaderList.size() > 0) {
				for (BlOpBillHeader billHeader : billHeaderList) {
					boolean refunded = true;
					billDetails = billHeader.getBlOpBillDetails();
					for (BlOpBillDetails obj : billDetails) {
						if (obj.getRefundableStatus().equals("y")) {
							refunded = false;
							break;
						}
					}
					if (refunded == false) {
						billList.add(billHeader);
						map.put("billList", billList);
					}
				}
			}

			payAdvList = session.createCriteria(BlPaymentAdviceDetails.class)
					.createAlias("PaymentAdviceHeader", "pah")
					.createAlias("pah.Bill", "bh")
					.add(Restrictions.eq("bh.BillNo", billNo)).list();

			if (payAdvList.size() > 0) {
				map.put("payAdvList", payAdvList);
			}
			refundList = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("TotalRefundAmt"))
					.createAlias("PymntAdvDisp", "pd")
					.createAlias("pd.BillDispensing", "bl")
					.add(Restrictions.eq("bl.BillNo", billNo)).list();
			if (refundList.size() > 0) {
				map.put("refundList", refundList);
			}
			}else{
				map.put("msg", "Sample already collected for Bill. Cannot create Payment Advice. ");
				map.put("orderList", orderList);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPaymentAdviceServicingDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		List chargeCodeIdList = new ArrayList();
		List qtyList = new ArrayList();
		List adviceAmtList = new ArrayList();
		List billDtIdList = new ArrayList();
		List adviceCharityAmtList = new ArrayList();
		List chargeSlipDtIdList = new ArrayList();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = getSession();

		int hinId = 0;
		int billId = 0;
		BigDecimal pastDuesAdj = new BigDecimal(0);
		// BigDecimal adviceAmt = new BigDecimal(0);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			if (dataMap.get("hinId") != null) {
				hinId = (Integer) dataMap.get("hinId");
			}
			if (dataMap.get("pastDues") != null) {
				pastDuesAdj = (BigDecimal) dataMap.get("pastDues");
			}
			/*
			 * if(dataMap.get("adviceAmt") != null){ adviceAmt =
			 * (BigDecimal)dataMap.get("adviceAmt"); }
			 */
			BlPaymentAdviceHeader adviceHeader = new BlPaymentAdviceHeader();
			if (dataMap.get("adviceHeader") != null) {
				adviceHeader = (BlPaymentAdviceHeader) dataMap
						.get("adviceHeader");
				String paymtAdviceNo = "";
				paymtAdviceNo = generatePaymentAdviceNo("save",adviceHeader.getHospital().getId());
				adviceHeader.setPaymentAdviceNo(paymtAdviceNo);
				adviceHeader.setRefunded("n");
				hbt.save(adviceHeader);
			}
			if (dataMap.get("chargeCodeIdList") != null) {
				chargeCodeIdList = (List) dataMap.get("chargeCodeIdList");
			}
			if (dataMap.get("qtyList") != null) {
				qtyList = (List) dataMap.get("qtyList");
			}
			if (dataMap.get("adviceAmtList") != null) {
				adviceAmtList = (List) dataMap.get("adviceAmtList");
			}
			if (dataMap.get("adviceCharityAmtList") != null) {
				adviceCharityAmtList = (List) dataMap
						.get("adviceCharityAmtList");
			}
			if (dataMap.get("billDtIdList") != null) {
				billDtIdList = (List) dataMap.get("billDtIdList");
			}
			if (dataMap.get("chargeSlipDtIdList") != null) {
				chargeSlipDtIdList = (List) dataMap.get("chargeSlipDtIdList");
			}

			for (int i = 0; i < chargeCodeIdList.size(); i++) {
				if (chargeCodeIdList.get(i) != null) {
					BlPaymentAdviceDetails adviceDetails = new BlPaymentAdviceDetails();
					if (adviceAmtList.get(i) != null) {
						adviceDetails.setAdviceAmt(new BigDecimal(adviceAmtList
								.get(i).toString()));
					}
					if (qtyList.get(i) != null) {
						adviceDetails.setAdviceQty(Integer.parseInt(qtyList
								.get(i).toString()));
					}
					if (!adviceCharityAmtList.get(i).equals("")) {
						adviceDetails.setAdviceCharityAmt(new BigDecimal(
								adviceCharityAmtList.get(i).toString()));
					}
					MasChargeCode chargeCode = new MasChargeCode();
					chargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)
							.toString()));
					adviceDetails.setCharge(chargeCode);
					adviceDetails.setRefunded("n");
					adviceDetails.setPaymentAdviceHeader(adviceHeader);
					hbt.save(adviceDetails);
				}
			}

			if (billDtIdList.size() > 0) {
				for (int i = 0; i < billDtIdList.size(); i++) {
					billId = (Integer) billDtIdList.get(i);
					// int refundedQty =
					// Integer.parseInt(qtyList.get(i).toString());
					BlOpBillDetails billDetails = (BlOpBillDetails) hbt.load(
							BlOpBillDetails.class, billId);

					BigDecimal refundedAmt = new BigDecimal(0.00);
					if (billDetails.getRefundedAmt() != null) {
						refundedAmt = billDetails.getRefundedAmt()
								.add(new BigDecimal(adviceAmtList.get(i)
										.toString()));

					} else {
						refundedAmt = new BigDecimal(adviceAmtList.get(i)
								.toString());
					}
					billDetails.setRefundedAmt(refundedAmt);

					if (refundedAmt.compareTo(billDetails.getNetAmt()) == 0) {
						billDetails.setRefundableStatus("n");
					}
					hbt.update(billDetails);
				}
			}
			if (chargeSlipDtIdList.size() > 0) {
				for (int i = 0; i < chargeSlipDtIdList.size(); i++) {
					billId = (Integer) chargeSlipDtIdList.get(i);
					// int refundedQty =
					// Integer.parseInt(qtyList.get(i).toString());
					BlChargeSlipDetail billDetails = (BlChargeSlipDetail) hbt
							.load(BlChargeSlipDetail.class, billId);

					BigDecimal refundedAmt = new BigDecimal(0.00);
					if (billDetails.getRefundedAmt() != null) {
						refundedAmt = billDetails.getRefundedAmt()
								.add(new BigDecimal(adviceAmtList.get(i)
										.toString()));

					} else {
						refundedAmt = new BigDecimal(adviceAmtList.get(i)
								.toString());
					}
					billDetails.setRefundedAmt(refundedAmt);

					if (refundedAmt.compareTo(billDetails.getNetAmt()) == 0) {
						billDetails.setRefundableStatus("n");
					}
					hbt.update(billDetails);
				}
			}
			Patient patient = (Patient) hbt.load(Patient.class, hinId);
			BigDecimal pastDue = new BigDecimal(0);
			if (patient.getPastDue() != null)
				pastDue = new BigDecimal(patient.getPastDue());

			pastDue = pastDue.subtract(pastDuesAdj);
			patient.setPastDue(pastDue.toString());
			hbt.update(patient);
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String generatePaymentAdviceNo(String flag,int hospitalId) {
		String payAdviceNo = "";
		Integer payAdviceSeqNo = 0;
		List<BlParameter> paSeqNoList = new ArrayList<BlParameter>();
		List<BlPaymentAdviceHeader> payAdviceHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		try {
			paSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "PA"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		payAdviceHeaderList = session.createCriteria(
				BlPaymentAdviceHeader.class).list();
		String lastPANo = "";
		if (payAdviceHeaderList.size() > 0) {
			for (BlPaymentAdviceHeader adviceHeader : payAdviceHeaderList) {
				lastPANo = adviceHeader.getPaymentAdviceNo();
			}
		}
		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (paSeqNoList.size() > 0) {
			for (BlParameter blParameter : paSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				payAdviceSeqNo = ++seqNo;
			}
			payAdviceNo = commonSeqNo(payAdviceSeqNo, criteria, lastPANo);
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(payAdviceSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			payAdviceSeqNo = 1;
			blParameter.setSeqNo(payAdviceSeqNo);
			blParameter.setPrefix("PA");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);		
		}
		
		hbt.flush();
		return payAdviceNo;
	}

	public synchronized String commonSeqNo(Integer seqNoInt, String criteria,
			String maxNo) {
		String seqNo = "";
		String lastMnt = "";
		String lastYr = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		StringTokenizer str = new StringTokenizer(maxNo, "/");
		if (criteria.equalsIgnoreCase("c")) {
			seqNo = seqNoInt.toString();

		} else if (criteria.equalsIgnoreCase("m")) {
			while (str.hasMoreTokens()) {
				str.nextToken();
				if (str.hasMoreTokens())
					lastMnt = str.nextToken();
				if (str.hasMoreTokens())
					lastYr = str.nextToken();
			}
			if (!lastMnt.equals(currentMonth) && !lastYr.equals(currentYear)) {
				seqNoInt = 1;
			}
			seqNo = seqNoInt.toString().concat("/").concat(currentMonth)
					.concat("/").concat(currentYear);
		} else if (criteria.equalsIgnoreCase("y")) {
			while (str.hasMoreTokens()) {
				str.nextToken();
				if (str.hasMoreTokens())
					lastYr = str.nextToken();
			}
			if (!lastYr.equals(currentYear)) {
				seqNoInt = 1;
			}
			seqNo = seqNoInt.toString().concat("/").concat(currentYear);
		}
		return seqNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForPaymentAdviceDispensing(
			Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BlDispensingHeader> dispensingHeaderList = new ArrayList<BlDispensingHeader>();
		List<BlDispensingHeader> dispensingList = new ArrayList<BlDispensingHeader>();
		List<BlPymntAdviceDispDetails> payAdvList = new ArrayList<BlPymntAdviceDispDetails>();
		List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();
		Set<BlDispensingDetails> dispensingDetails = new HashSet<BlDispensingDetails>();

		String billNo = "";
		String hin = "";
		String adNo = "";
		billNo = box.getString(BILL_NO);
		hin = box.getString(HIN_NO);
		adNo = box.getString(AD_NO);
		Session session = getSession();
		Criteria crit = null;
		Criteria criteria = null;
		try {
			crit = session.createCriteria(BlDispensingHeader.class).add(
					Restrictions.eq("BillNo", billNo));

			if (!hin.equals("")) {
				crit = crit.createAlias("Hin", "p").add(
						Restrictions.eq("p.HinNo", hin));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			dispensingList = crit.list();
			System.out.println("dispensingList>>>>>>>" + dispensingList.size());
			for (BlDispensingHeader dispensingHeader : dispensingList) {
				boolean dispensRefunded = true;
				dispensingDetails = dispensingHeader.getBlDispensingDetails();
				for (BlDispensingDetails obj : dispensingDetails) {
					if (obj.getRefundableStatus().equals("y")) {
						dispensRefunded = false;
						break;
					}
				}
				if (dispensRefunded == false) {
					dispensingHeaderList.add(dispensingHeader);
					map.put("dispensingHeaderList", dispensingHeaderList);
				}
			}

			criteria = session.createCriteria(BlPymntAdviceDispDetails.class)
					.createAlias("PymntAdviceDispHeader", "pah")
					.createAlias("pah.BillDispensing", "bd")
					.add(Restrictions.eq("bd.BillNo", billNo));
			if (!adNo.equals("")) {
				criteria = criteria.createAlias("pah.Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			payAdvList = criteria.list();

			if (payAdvList.size() > 0) {
				map.put("payAdvList", payAdvList);
			}
			refundList = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("TotalRefundAmt"))
					.createAlias("PymntAdvServ", "pas")
					.createAlias("pas.Bill", "bl")
					.add(Restrictions.eq("bl.BillNo", billNo)).list();
			if (refundList.size() > 0) {
				map.put("refundList", refundList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitPaymentAdviceDispensingDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;

		List itemIdList = new ArrayList();
		List batchIdList = new ArrayList();
		List qtyList = new ArrayList();
		List adviceAmtList = new ArrayList();
		List billDtIdList = new ArrayList();
		List adviceCharityAmtList = new ArrayList();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int hinId = 0;
		int billId = 0;
		BigDecimal pastDuesAdj = new BigDecimal(0);
		BigDecimal adviceAmt = new BigDecimal(0);
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();
			if (dataMap.get("hinId") != null) {
				hinId = (Integer) dataMap.get("hinId");
			}
			if (dataMap.get("pastDues") != null) {
				pastDuesAdj = (BigDecimal) dataMap.get("pastDues");
			}
			if (dataMap.get("adviceAmt") != null) {
				adviceAmt = (BigDecimal) dataMap.get("adviceAmt");
			}
			BlPymntAdviceDispHeader adviceDispHeader = new BlPymntAdviceDispHeader();
			if (dataMap.get("adviceDispHeader") != null) {
				adviceDispHeader = (BlPymntAdviceDispHeader) dataMap
						.get("adviceDispHeader");
				System.out.println("adviceDispHeader===" + adviceDispHeader);
				String paymtAdviceNo = "";
				paymtAdviceNo = generatePaymentAdviceNo("save",adviceDispHeader.getHospital().getId());
				System.out.println("paymtAdviceNo==" + paymtAdviceNo);
				adviceDispHeader.setPaymentAdviceNo(paymtAdviceNo);
				adviceDispHeader.setRefunded("n");
				hbt.save(adviceDispHeader);
			}
			if (dataMap.get("itemIdList") != null) {
				itemIdList = (List) dataMap.get("itemIdList");
			}
			if (dataMap.get("batchIdList") != null) {
				batchIdList = (List) dataMap.get("batchIdList");
			}
			if (dataMap.get("qtyList") != null) {
				qtyList = (List) dataMap.get("qtyList");
			}
			if (dataMap.get("adviceAmtList") != null) {
				adviceAmtList = (List) dataMap.get("adviceAmtList");
			}
			if (dataMap.get("adviceCharityAmtList") != null) {
				adviceCharityAmtList = (List) dataMap
						.get("adviceCharityAmtList");
			}
			if (dataMap.get("billDtIdList") != null) {
				billDtIdList = (List) dataMap.get("billDtIdList");
			}
			for (int i = 0; i < batchIdList.size(); i++) {
				if (batchIdList.get(i) != null) {
					BlPymntAdviceDispDetails adviceDispDetails = new BlPymntAdviceDispDetails();
					if (adviceAmtList.get(i) != null) {
						adviceDispDetails.setAdviceAmt(new BigDecimal(
								adviceAmtList.get(i).toString()));
					}
					if (qtyList.get(i) != null) {
						adviceDispDetails.setAdviceQty(new BigDecimal(qtyList
								.get(i).toString()));
					}
					if (adviceCharityAmtList.get(i) != null) {
						adviceDispDetails.setAdviceCharityAmt(new BigDecimal(
								adviceCharityAmtList.get(i).toString()));
					}
					StoreItemBatchStock batchStock = new StoreItemBatchStock();
					batchStock.setId(Integer.parseInt(batchIdList.get(i)
							.toString()));
					adviceDispDetails.setBatch(batchStock);

					MasStoreItem storeItem = new MasStoreItem();
					storeItem.setId(Integer.parseInt(itemIdList.get(i)
							.toString()));
					adviceDispDetails.setItem(storeItem);
					adviceDispDetails.setRefunded("n");
					adviceDispDetails
							.setPymntAdviceDispHeader(adviceDispHeader);
					hbt.save(adviceDispDetails);
				}
			}

			if (billDtIdList.size() > 0) {
				for (int i = 0; i < billDtIdList.size(); i++) {
					billId = (Integer) billDtIdList.get(i);
					// BigDecimal refundedQty = new
					// BigDecimal(qtyList.get(i).toString());
					BlDispensingDetails dispensDetails = (BlDispensingDetails) hbt
							.load(BlDispensingDetails.class, billId);
					BigDecimal refundedAmt = new BigDecimal(0.00);
					if (dispensDetails.getRefundedAmt() != null) {
						refundedAmt = dispensDetails.getRefundedAmt()
								.add(new BigDecimal(adviceAmtList.get(i)
										.toString()));

					} else {
						refundedAmt = new BigDecimal(adviceAmtList.get(i)
								.toString());
					}
					dispensDetails.setRefundedAmt(refundedAmt);
					if (refundedAmt.compareTo(dispensDetails.getNetAmt()) == 0) {
						dispensDetails.setRefundableStatus("n");
					}
					hbt.update(dispensDetails);
				}
			}

			for (int j = 0; j < batchIdList.size(); j++) {
				int batchId = Integer.parseInt(batchIdList.get(j).toString());
				String issued = "";
				for (int i = 0; i < billDtIdList.size(); i++) {
					billId = (Integer) billDtIdList.get(i);
					// BigDecimal refundedQty = new
					// BigDecimal(qtyList.get(i).toString());
					BlDispensingDetails dispensDetails = (BlDispensingDetails) hbt
							.load(BlDispensingDetails.class, billId);
					if (batchId == dispensDetails.getBatch().getId()) {
						issued = dispensDetails.getIssued();
						break;
					}
				}
				StoreItemBatchStock batchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, batchId);
				BigDecimal advicedQty = new BigDecimal(0);
				advicedQty = new BigDecimal(qtyList.get(j).toString());
				BigDecimal remainingQty = new BigDecimal(0);
				if (issued.equals("n")) {
					remainingQty = batchStock.getBlockedQty().subtract(
							advicedQty);
					// batchStock.setBlockedQty(remainingQty);
				} else {
					if (batchStock.getClosingStock() != null) {
						batchStock.setClosingStock(batchStock.getClosingStock()
								.add(advicedQty));
					}
				}
				if (batchStock.getReceivedQty() != null) {
					batchStock.setReceivedQty(batchStock.getReceivedQty().add(
							advicedQty));
				} else {
					batchStock.setReceivedQty(advicedQty);
				}
				hbt.update(batchStock);
			}
			Patient patient = (Patient) hbt.load(Patient.class, hinId);
			BigDecimal pastDue = new BigDecimal(0);
			BigDecimal newPastDue = new BigDecimal(0);
			if (patient.getPastDue() != null)
				pastDue = new BigDecimal(patient.getPastDue());
			newPastDue = pastDue.subtract(pastDuesAdj);
			patient.setPastDue(newPastDue.toString());
			hbt.update(patient);
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPaymentAdviceNoForCashRefund(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPaymentAdviceHeader> advHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> dispHeaderList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BlPaymentAdviceHeader> pymtAdvServNoList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> pymtAdvDispNoList = new ArrayList<BlPymntAdviceDispHeader>();
		Set<BlPaymentAdviceDetails> advDtSet = new HashSet<BlPaymentAdviceDetails>();
		Set<BlPymntAdviceDispDetails> advDispDtSet = new HashSet<BlPymntAdviceDispDetails>();

		String billType = "";
		String hin = "";
		String billNo = "";
		if (parameterMap.get("billType") != null) {
			billType = (String) parameterMap.get("billType");
		}
		if (parameterMap.get("hin") != null) {
			hin = (String) parameterMap.get("hin");
		}
		if (parameterMap.get("billNo") != null) {
			billNo = (String) parameterMap.get("billNo");
		}
		Session session = getSession();
		Criteria crit = null;
		try {
			if (billType.equals("servicing")) {
				crit = session.createCriteria(BlPaymentAdviceHeader.class)
						.add(Restrictions.isNotNull("CashAdviceAmt"))
						.add(Restrictions.eq("Refunded", "n"));
		
				if (!billNo.equals("")) {
					crit = crit.createAlias("Bill", "bl").add(
							Restrictions.eq("bl.BillNo", billNo));
				}
				if (!hin.equals("")) {
					crit = crit.createAlias("Hin", "h").add(
							Restrictions.eq("h.HinNo", hin));
				}
				advHeaderList = crit.list();
				if (advHeaderList.size() > 0) {
					boolean refunded = true;
					for (BlPaymentAdviceHeader advHeader : advHeaderList) {
						/*
						 * advDtSet = advHeader.getBlPaymentAdviceDetails(); for
						 * (BlPaymentAdviceDetails obj : advDtSet) {
						 * if(obj.getRefunded().equals("n")){ refunded = false;
						 * break; } }
						 */
						if (advHeader.getRefunded().equals("n")) {
							pymtAdvServNoList.add(advHeader);
						}
					}
					map.put("pymtAdvServNoList", pymtAdvServNoList);
				}
			} else if (billType.equals("dispensing")) {
				crit = session.createCriteria(BlPymntAdviceDispHeader.class)
						.add(Restrictions.isNotNull("CashAdviceAmt"))
						.add(Restrictions.eq("Refunded", "n"));
				if (!billNo.equals("")) {
					crit = crit.createAlias("BillDispensing", "bl").add(
							Restrictions.eq("bl.BillNo", billNo));
				}
				if (!hin.equals("")) {
					crit = crit.createAlias("Hin", "h").add(
							Restrictions.eq("h.HinNo", hin));
				}
				dispHeaderList = crit.list();
				if (dispHeaderList.size() > 0) {
					for (BlPymntAdviceDispHeader advDispHeader : dispHeaderList) {
						if (advDispHeader.getRefunded().equals("n")) {
							pymtAdvDispNoList.add(advDispHeader);
						}
						/*
						 * boolean refunded = true; advDispDtSet =
						 * advDispHeader.getBlPymntAdviceDispDetails(); for
						 * (BlPymntAdviceDispDetails obj : advDispDtSet) {
						 * if(obj.getRefunded().equals("n")){ refunded = false;
						 * break; } } if(refunded == false){
						 * pymtAdvDispNoList.add(advDispHeader);
						 * map.put("pymtAdvDispNoList", pymtAdvDispNoList); }
						 */
					}
					map.put("pymtAdvDispNoList", pymtAdvDispNoList);
				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPaymentAdviceNoForAdviceRep(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPaymentAdviceHeader> advHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> dispHeaderList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BlPaymentAdviceHeader> pymtAdvServNoList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> pymtAdvDispNoList = new ArrayList<BlPymntAdviceDispHeader>();
		Set<BlPaymentAdviceDetails> advDtSet = new HashSet<BlPaymentAdviceDetails>();
		Set<BlPymntAdviceDispDetails> advDispDtSet = new HashSet<BlPymntAdviceDispDetails>();

		String billType = "";
		String hin = "";
		String billNo = "";
		if (parameterMap.get("billType") != null) {
			billType = (String) parameterMap.get("billType");
		}
		if (parameterMap.get("hin") != null) {
			hin = (String) parameterMap.get("hin");
		}
		if (parameterMap.get("billNo") != null) {
			billNo = (String) parameterMap.get("billNo");
		}
		Session session = getSession();
		Criteria crit = null;
		try {
			if (billType.equals("servicing")) {
				crit = session.createCriteria(BlPaymentAdviceHeader.class).add(
						Restrictions.eq("Refunded", "n"));
				;
				if (!billNo.equals("")) {
					crit = crit.createAlias("Bill", "bl").add(
							Restrictions.eq("bl.BillNo", billNo));
				}
				if (!hin.equals("")) {
					crit = crit.createAlias("Hin", "h").add(
							Restrictions.eq("h.HinNo", hin));
				}
				advHeaderList = crit.list();
				if (advHeaderList.size() > 0) {
					boolean refunded = true;
					for (BlPaymentAdviceHeader advHeader : advHeaderList) {
						/*
						 * advDtSet = advHeader.getBlPaymentAdviceDetails(); for
						 * (BlPaymentAdviceDetails obj : advDtSet) {
						 * if(obj.getRefunded().equals("n")){ refunded = false;
						 * break; } }
						 */
						if (advHeader.getRefunded().equals("n")) {
							pymtAdvServNoList.add(advHeader);
						}
					}
					map.put("pymtAdvServNoList", pymtAdvServNoList);
				}
			} else if (billType.equals("dispensing")) {
				crit = session.createCriteria(BlPymntAdviceDispHeader.class)
						.add(Restrictions.eq("Refunded", "n"));
				if (!billNo.equals("")) {
					crit = crit.createAlias("BillDispensing", "bl").add(
							Restrictions.eq("bl.BillNo", billNo));
				}
				if (!hin.equals("")) {
					crit = crit.createAlias("Hin", "h").add(
							Restrictions.eq("h.HinNo", hin));
				}
				dispHeaderList = crit.list();
				if (dispHeaderList.size() > 0) {
					for (BlPymntAdviceDispHeader advDispHeader : dispHeaderList) {
						if (advDispHeader.getRefunded().equals("n")) {
							pymtAdvDispNoList.add(advDispHeader);
						}
						/*
						 * boolean refunded = true; advDispDtSet =
						 * advDispHeader.getBlPymntAdviceDispDetails(); for
						 * (BlPymntAdviceDispDetails obj : advDispDtSet) {
						 * if(obj.getRefunded().equals("n")){ refunded = false;
						 * break; } } if(refunded == false){
						 * pymtAdvDispNoList.add(advDispHeader);
						 * map.put("pymtAdvDispNoList", pymtAdvDispNoList); }
						 */
					}
					map.put("pymtAdvDispNoList", pymtAdvDispNoList);
				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
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
	public Map<String, Object> getDetailsForCashRefund(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<BlPaymentAdviceHeader> pmntAdvServList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> pmntAdvDispList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BigDecimal> refundList = new ArrayList<BigDecimal>();
		List<BigDecimal> refundList1 = new ArrayList<BigDecimal>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();
		String message = "";
		String hin = box.getString(HIN_NO);
		System.out.println("hinnnnnnnn" + hin);
		String billType = box.getString(BILL_TYPE);
		String billNo = box.getString(BILL_NO);
		String pymtAdviceNo = box.getString(PAYMENT_ADVICE_NO);

		Session session = getSession();
		Criteria crit = null;
		relationList = session.createCriteria(MasRelation.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		bankList = session.createCriteria(MasBankMaster.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (billType.equals("servicing")) {
			crit = session.createCriteria(BlPaymentAdviceHeader.class)
					.add(Restrictions.eq("PaymentAdviceNo", pymtAdviceNo))
					.add(Restrictions.isNotNull("CashAdviceAmt"))
					.add(Restrictions.eq("Refunded", "n").ignoreCase());
			if (!billNo.equals("")) {
				crit = crit.createAlias("Bill", "bl").add(
						Restrictions.eq("bl.BillNo", billNo));
			}
			/*
			 * if (!hin.equals("")) { crit = crit.createAlias("Hin", "hin").add(
			 * Restrictions.eq("hin.HinNo", hin)); }
			 */
			pmntAdvServList = crit.list();
			refundList1 = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("CharityAmt"))
					.createAlias("PymntAdvServ", "pas")
					.add(Restrictions.eq("pas.PaymentAdviceNo", pymtAdviceNo))
					.list();
			if (refundList1.size() > 0) {
				map.put("refundList1", refundList1);
			}
			System.out.println("size"+refundList1.size());
			refundList = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("TotalRefundAmt"))
					.createAlias("PymntAdvServ", "pas")
					.add(Restrictions.eq("pas.PaymentAdviceNo", pymtAdviceNo))
					.list();
			if (refundList.size() > 0) {
				map.put("refundList", refundList);
			}

			if (pmntAdvServList.size() > 0) {
				map.put("pmntAdvServList", pmntAdvServList);
			} else {
				message = "No Record Found!";
				map.put("message", message);
			}

		} else if (billType.equals("dispensing")) {
			crit = session.createCriteria(BlPymntAdviceDispHeader.class)
					.add(Restrictions.eq("PaymentAdviceNo", pymtAdviceNo))
					.add(Restrictions.isNotNull("CashAdviceAmt"))
					.add(Restrictions.eq("Refunded", "n"));
			if (!billNo.equals("")) {
				crit = crit.createAlias("BillDispensing", "bl").add(
						Restrictions.eq("bl.BillNo", billNo));
			}
			/*
			 * if (!hin.equals("")) { crit = crit.createAlias("Hin", "hin").add(
			 * Restrictions.eq("hin.HinNo", hin)); }
			 */
			pmntAdvDispList = crit.list();

			refundList = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("TotalRefundAmt"))
					.createAlias("PymntAdvDisp", "pas")
					.add(Restrictions.eq("pas.PaymentAdviceNo", pymtAdviceNo))
					.list();
			if (refundList.size() > 0) {
				map.put("refundList", refundList);
			}
			if (pmntAdvDispList.size() > 0) {
				map.put("pmntAdvDispList", pmntAdvDispList);
			} else {
				message = "No Record Found!";
				map.put("message", message);
			}
		}
		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hin)).list();
		System.out.println("patientList>>>>>>>>>>>>>>>>>" + patientList.size());
		masCharityList = session.createCriteria(MasCharityType.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		System.out.println("masCharityList" + masCharityList.size());
      map.put("masCharityList", masCharityList);
		map.put("patientList", patientList);
		map.put("bankList", bankList);
		map.put("relationList", relationList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitCashRefundDetails(Box box) {
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BlRefundHeader refundHeader = new BlRefundHeader();
		Transaction tx = null;
		Session session = getSession();
		BigDecimal pastDue = new BigDecimal(0);
		BigDecimal remainCId = new BigDecimal(0);
		if (box.getString("remainCId")!=null &&!box.getString("remainCId").equals("")) {
	     remainCId = new BigDecimal(box.getString("remainCId"));}
		try {
			tx = session.beginTransaction();
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			refundHeader.setHospital(hospital);
			//add remaing credit in pateint past due
			Patient patient =(Patient)hbt.get(Patient.class, box.getInt(HIN_ID));
			
			pastDue=new BigDecimal(patient.getPastDue());
			patient.setPastDue(pastDue.add(remainCId).toString());
			//Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			refundHeader.setHin(patient);
			Users user = new Users();
			user.setId(box.getInt("userId"));

			if (box.getInt(INPATIENT_ID) != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt(INPATIENT_ID));
				refundHeader.setInpatient(inpatient);
			}

			refundHeader.setRefundNo(box.getString("refundNo"));
			refundHeader
					.setRefundDate(HMSUtil.convertStringTypeDateToDateType(box
							.getString(REFUND_DATE)));
			refundHeader.setRefundTime(box.getString(REFUND_TIME));
			if (!box.getString("balToBeRId").equals("")) {
				refundHeader.setTotalRefundAmt(new BigDecimal(box
						.getString("balToBeRId")));
			}
			if (!box.getString("remainCId").equals("")) {
				refundHeader.setRemainingCredit(new BigDecimal(box
						.getString("remainCId")));
			}
			if (!box.getString("charityTransferId").equals("")) {
				refundHeader.setCharityAmt(new BigDecimal(box
						.getString("charityTransferId")));
			}
			refundHeader.setPersonCollectedAmt(box
					.getString(PERSON_COLLECTED_AMT));

			MasRelation relation = new MasRelation();
			relation.setId(box.getInt(RELATION_ID));
			refundHeader.setRelationToPatient(relation);
			refundHeader.setRemarks(box.getString(REMARKS));
			
			if (!box.getString(ROUND_OF_VALUE).equals("")) {
				refundHeader.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (box.getInt(PAYMENT_ADVICE_ID) != 0) {
				BlPaymentAdviceHeader payAdviceHeader = new BlPaymentAdviceHeader();
				payAdviceHeader.setId(box.getInt(PAYMENT_ADVICE_ID));
				refundHeader.setPymntAdvServ(payAdviceHeader);
			}
			if (box.getInt(PAYMENT_ADVICE_DISPENSING_ID) != 0) {
				BlPymntAdviceDispHeader payAdviceDisHeader = new BlPymntAdviceDispHeader();
				payAdviceDisHeader.setId(box
						.getInt(PAYMENT_ADVICE_DISPENSING_ID));
				refundHeader.setPymntAdvDisp(payAdviceDisHeader);
			}
			refundHeader.setLastChgBy(user);
			refundHeader.setRefundTime(box.getString(CHANGED_TIME));
			refundHeader.setRefundDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			refundHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			refundHeader.setLastChgTime(box.getString(CHANGED_TIME));
			refundHeader.setStatus("y");

			hbt.save(refundHeader);

			// Account entry in header----------------

			/*
			 * FaVoucherHeader voucherHeader = new FaVoucherHeader();
			 * voucherHeader.setVoucherNo(""); FaMasVoucherType voucherType =
			 * new FaMasVoucherType(); voucherType.setId(2);
			 * voucherHeader.setVoucherType(voucherType);
			 * voucherHeader.setLastChgBy(box.getString(CHANGED_BY));
			 * voucherHeader.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherHeader.setCrBalance(new BigDecimal(box
			 * .getString(TOTAL_AMOUNT))); voucherHeader.setDrBalance(new
			 * BigDecimal(box .getString(TOTAL_AMOUNT)));
			 * voucherHeader.setHospital(hospital);
			 * voucherHeader.setNaration("Being Refund.");
			 * voucherHeader.setStatus("y");
			 * voucherHeader.setLastChgBy(box.getString(CHANGED_BY));
			 * voucherHeader.setVoucherDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			 * hbt.save(voucherHeader);
			 */

			int rowCount = box.getInt("hiddenValuePayment");
			if (rowCount > 0) {
				for (int i = 1; i <= rowCount; i++) {
					BlRefundDetails refundDetails = new BlRefundDetails();
					refundDetails.setPaymentMode(box
							.getString(PAYMENT_MODE + i));
					if (!box.getString(PAYMENT_MODE + i).equals("")) {
						refundDetails.setPaymentMode(box.getString(PAYMENT_MODE
								+ i));
					}
					if (!box.getString(AMOUNT_RECEIVED + i).equals("")) {
						refundDetails.setRefundAmount(new BigDecimal(box
								.getString(AMOUNT_RECEIVED + i)));
					}
					if (!box.getString(CHEQUE_NO + i).equals("")) {
						refundDetails.setChequeNo(box.getString(CHEQUE_NO + i));
					}
					if (!box.getString(CHEQUE_DATE + i).equals("")) {
						refundDetails.setChequeDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHEQUE_DATE + i)));
					}
					if (!box.getString(BANK_NAME + i).equals("")) {
						MasBankMaster bankMaster = new MasBankMaster();
						bankMaster.setId(box.getInt(BANK_NAME + i));
						refundDetails.setBank(bankMaster);
					}

					refundDetails.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					refundDetails.setLastChgTime(box.getString(CHANGED_TIME));
					refundDetails.setLastChgBy(user);
					refundDetails.setRefundHeader(refundHeader);
					refundDetails.setStatus("y");
					hbt.save(refundDetails);

					// Accounts entry for payment------------------

					/*
					 * FaMasAccount accountObj = new FaMasAccount(); FaMasSubLed
					 * subLedObj = new FaMasSubLed(); if
					 * (!box.getString(PAYMENT_MODE + i).equals("")) {
					 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
					 * BigDecimal amount = new BigDecimal(0);
					 * 
					 * voucherDetails.setVoucherHeader(voucherHeader);
					 * voucherDetails.setHospital(hospital); FaMasAccount acc =
					 * new FaMasAccount(); FaMasSubLed subLed = new
					 * FaMasSubLed();
					 * 
					 * if (box.getString(PAYMENT_MODE + i).equals("C")) {
					 * voucherDetails.setNaration("Cash Payment"); acc.setId(2);
					 * subLed.setId(4);
					 * 
					 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class,
					 * 2); subLedObj = (FaMasSubLed) hbt.load(
					 * FaMasSubLed.class, 4); } else if
					 * (box.getString(PAYMENT_MODE + i).equals("Q") ||
					 * box.getString(PAYMENT_MODE + i).equals("R")) {
					 * voucherDetails
					 * .setNaration("Credit Card/Cheque Payment"); acc.setId(6);
					 * subLed.setId(5);
					 * 
					 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class,
					 * 6); subLedObj = (FaMasSubLed) hbt.load(
					 * FaMasSubLed.class, 5); } voucherDetails.setAcc(acc);
					 * voucherDetails.setSubLed(subLed);
					 * 
					 * if (box.getString(AMOUNT_RECEIVED + i).equals("")) {
					 * amount = new BigDecimal(box .getString(AMOUNT_RECEIVED +
					 * i)); voucherDetails.setCrBalance(amount); }
					 * voucherDetails.setStatus("y");
					 * voucherDetails.setLastChgDate(HMSUtil
					 * .convertStringTypeDateToDateType(box
					 * .getString(CHANGED_DATE)));
					 * voucherDetails.setLastChgTime(box
					 * .getString(CHANGED_TIME));
					 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
					 * hbt.save(voucherDetails);
					 * 
					 * BigDecimal crBalanceForAc = new BigDecimal(0); BigDecimal
					 * crBalanceForSbldAc = new BigDecimal(0);
					 * 
					 * if (accountObj.getCrBalance() != null) crBalanceForAc =
					 * accountObj.getCrBalance();
					 * accountObj.setCrBalance(crBalanceForAc.add(amount));
					 * hbt.update(accountObj);
					 * 
					 * if (subLedObj.getCrBalance() != null) crBalanceForSbldAc
					 * = subLedObj.getCrBalance();
					 * subLedObj.setCrBalance(crBalanceForSbldAc.add(amount));
					 * hbt.update(subLedObj); }
					 */
				}
			}
			BigDecimal refundedAmt = new BigDecimal(0);
			if (!box.getString(REFUND_AMOUNT).equals("")) {
				refundedAmt = new BigDecimal(box.getString(REFUND_AMOUNT));
			}
			
			BigDecimal totalAmt = new BigDecimal(0);
			BigDecimal charityAmt=new BigDecimal(0.0);
			BigDecimal remainingAmt=new BigDecimal(0.0);
			if (!box.getString("balToBeRId").equals("")) {
				totalAmt = new BigDecimal(box.getString("balToBeRId"));
			}
			
			if (!box.getString("remainCId").equals("")) {
				remainingAmt = new BigDecimal(box.getString("remainCId"));
			}
			if (!box.getString("charityTransferId").equals("")) {
				charityAmt = new BigDecimal(box.getString("charityTransferId"));
			}
			BigDecimal totAmt=totalAmt.add(charityAmt.add(remainingAmt));
			if (box.getInt(PAYMENT_ADVICE_ID) != 0) {
				BlPaymentAdviceHeader adviceHeader = (BlPaymentAdviceHeader) hbt
						.load(BlPaymentAdviceHeader.class,
								box.getInt(PAYMENT_ADVICE_ID));
				/*if (adviceHeader.getCashAdviceAmt().compareTo(
						refundedAmt.add(totAmt)) == 0) {*/
					adviceHeader.setRefunded("y");
					hbt.update(adviceHeader);

			/*	}*/
				/*
				 * advDtList =
				 * session.createCriteria(BlPaymentAdviceDetails.class
				 * ).createAlias("PaymentAdviceHeader", "pah")
				 * .add(Restrictions.eq("pah.Id",
				 * box.getInt(PAYMENT_ADVICE_ID))).list(); if (advDtList.size()
				 * > 0) { for(int i=0;i<advDtList.size();i++){ int id =
				 * advDtList.get(i).getId(); BlPaymentAdviceDetails advDetObj =
				 * (
				 * BlPaymentAdviceDetails)hbt.load(BlPaymentAdviceDetails.class,
				 * id); advDetObj.setRefunded("y"); hbt.update(advDetObj); } }
				 */
			}

			if (box.getInt(PAYMENT_ADVICE_DISPENSING_ID) != 0) {
				BlPymntAdviceDispHeader adviceDispHeader = (BlPymntAdviceDispHeader) hbt
						.load(BlPymntAdviceDispHeader.class,
								box.getInt(PAYMENT_ADVICE_DISPENSING_ID));

				if (new BigDecimal(Math.round(adviceDispHeader
						.getCashAdviceAmt().floatValue()))
						.compareTo(refundedAmt.add(totAmt)) == 0) {
					adviceDispHeader.setRefunded("y");
					hbt.update(adviceDispHeader);

				}

				/*
				 * List<BlPymntAdviceDispDetails> advDtList = new
				 * ArrayList<BlPymntAdviceDispDetails>(); advDtList =
				 * session.createCriteria(BlPymntAdviceDispDetails.class)
				 * .createAlias("PymntAdviceDispHeader",
				 * "pah").add(Restrictions.eq("pah.Id",
				 * box.getInt(PAYMENT_ADVICE_DISPENSING_ID))).list(); if
				 * (advDtList.size() > 0) { for(int i=0;i<advDtList.size();i++){
				 * int id = advDtList.get(i).getId(); BlPymntAdviceDispDetails
				 * advDetObj =
				 * (BlPymntAdviceDispDetails)hbt.load(BlPymntAdviceDispDetails
				 * .class, id); advDetObj.setRefunded("y");
				 * hbt.update(advDetObj); } }
				 */

			}

			// Accounts Entry in detail------------------------
			/*
			 * BigDecimal onAccAmt = new BigDecimal(0); if
			 * (box.getInt(PAYMENT_ADVICE_ID) != 0) {
			 * List<BlPaymentAdviceHeader> advHdList = new
			 * ArrayList<BlPaymentAdviceHeader>();
			 * 
			 * advHdList = session.createCriteria(BlPaymentAdviceHeader.class)
			 * .add(Restrictions.idEq(box.getInt(PAYMENT_ADVICE_ID))) .list();
			 * if (advHdList.get(0).getOnAccountAmt() != null) onAccAmt =
			 * advHdList.get(0).getOnAccountAmt(); Set servicesSet = new
			 * HashSet();
			 * 
			 * if (advHdList.get(0).getBill() != null) { servicesSet =
			 * advHdList.get(0).getBill() .getBlOpBillDetails(); } else if
			 * (advHdList.get(0).getChargeSlipMain() != null) { servicesSet =
			 * advHdList.get(0).getChargeSlipMain() .getBlChargeSlipDetails(); }
			 * 
			 * if (servicesSet.size() > 0) { for (Iterator iterator =
			 * servicesSet.iterator(); iterator .hasNext();) { int accountId =
			 * 0; int subAccountId = 0; if (advHdList.get(0).getBill() != null)
			 * { BlOpBillDetails opBillDetails = new BlOpBillDetails();
			 * opBillDetails = (BlOpBillDetails) iterator.next(); accountId =
			 * opBillDetails.getChargeCode() .getAccount().getId(); subAccountId
			 * = opBillDetails.getChargeCode() .getSubAccount().getId(); } else
			 * if (advHdList.get(0).getChargeSlipMain() != null) {
			 * BlChargeSlipDetail chargeSlipDetails = new BlChargeSlipDetail();
			 * chargeSlipDetails = (BlChargeSlipDetail) iterator .next();
			 * accountId = chargeSlipDetails.getChargeCode()
			 * .getAccount().getId(); subAccountId =
			 * chargeSlipDetails.getChargeCode() .getSubAccount().getId(); }
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * BigDecimal amount = new BigDecimal(0);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("For Services"); if (accountId != 0) {
			 * FaMasAccount masAccount = new FaMasAccount();
			 * masAccount.setId(accountId); voucherDetails.setAcc(masAccount); }
			 * if (subAccountId != 0) { FaMasSubLed masSubLed = new
			 * FaMasSubLed(); masSubLed.setId(subAccountId);
			 * voucherDetails.setSubLed(masSubLed); } if
			 * (!box.getString(TOTAL_AMOUNT).equals("")) { amount = new
			 * BigDecimal(box.getString(TOTAL_AMOUNT));
			 * voucherDetails.setDrBalance(amount); }
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box .getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
			 * drBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * if (accountId != 0) { FaMasAccount accObj = (FaMasAccount)
			 * hbt.load( FaMasAccount.class, accountId);
			 * 
			 * if (accObj.getDrBalance() != null) drBalanceForAc =
			 * accObj.getDrBalance();
			 * 
			 * accObj.setDrBalance(drBalanceForAc.add(amount));
			 * hbt.update(accObj); } if (subAccountId != 0) { FaMasSubLed subLed
			 * = (FaMasSubLed) hbt.load( FaMasSubLed.class, subAccountId); if
			 * (subLed.getDrBalance() != null) drBalanceForSbldAc =
			 * subLed.getDrBalance();
			 * subLed.setDrBalance(drBalanceForSbldAc.add(amount));
			 * hbt.update(subLed); } } } } else if
			 * (box.getInt(PAYMENT_ADVICE_DISPENSING_ID) != 0) {
			 * List<BlPymntAdviceDispHeader> advHdList = new
			 * ArrayList<BlPymntAdviceDispHeader>();
			 * 
			 * advHdList = session.createCriteria(
			 * BlPymntAdviceDispHeader.class).add( Restrictions.idEq(box
			 * .getInt(PAYMENT_ADVICE_DISPENSING_ID))).list(); if
			 * (advHdList.get(0).getOnAccountAmt() != null) onAccAmt =
			 * advHdList.get(0).getOnAccountAmt(); Set itemSet = new HashSet();
			 * 
			 * if (advHdList.get(0).getBillDispensing() != null) { itemSet =
			 * advHdList.get(0).getBillDispensing() .getBlDispensingDetails(); }
			 * if (itemSet.size() > 0) { for (Iterator iterator =
			 * itemSet.iterator(); iterator .hasNext();) { int accountId = 0;
			 * int subAccountId = 0;
			 * 
			 * BlDispensingDetails dispensingDetails = new
			 * BlDispensingDetails(); dispensingDetails = (BlDispensingDetails)
			 * iterator .next();
			 * 
			 * if (dispensingDetails.getItem().getAccountGroup() != null)
			 * accountId = dispensingDetails.getItem()
			 * .getAccountGroup().getId(); if
			 * (dispensingDetails.getItem().getSubAccountGroup() != null)
			 * subAccountId = dispensingDetails.getItem()
			 * .getSubAccountGroup().getId();
			 * 
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * BigDecimal amount = new BigDecimal(0);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("For Services"); if (accountId != 0) {
			 * FaMasAccount masAccount = new FaMasAccount();
			 * masAccount.setId(accountId); voucherDetails.setAcc(masAccount); }
			 * if (subAccountId != 0) { FaMasSubLed masSubLed = new
			 * FaMasSubLed(); masSubLed.setId(subAccountId);
			 * voucherDetails.setSubLed(masSubLed); } if
			 * (!box.getString(TOTAL_AMOUNT).equals("")) { amount = new
			 * BigDecimal(box.getString(TOTAL_AMOUNT));
			 * voucherDetails.setDrBalance(amount); }
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box .getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
			 * drBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * if (accountId != 0) { FaMasAccount accObj = (FaMasAccount)
			 * hbt.load( FaMasAccount.class, accountId); if
			 * (accObj.getDrBalance() != null) drBalanceForAc =
			 * accObj.getDrBalance();
			 * accObj.setDrBalance(drBalanceForAc.add(amount));
			 * hbt.update(accObj); } if (subAccountId != 0) { FaMasSubLed subLed
			 * = (FaMasSubLed) hbt.load( FaMasSubLed.class, subAccountId); if
			 * (subLed.getDrBalance() != null) drBalanceForSbldAc =
			 * subLed.getDrBalance();
			 * subLed.setDrBalance(drBalanceForSbldAc.add(amount));
			 * hbt.update(subLed); } } } }
			 */
			/*
			 * if (!box.getString(CHARITY_AMOUNT).equals("")) { FaVoucherDetails
			 * voucherDetails = new FaVoucherDetails(); FaMasAccount acc = new
			 * FaMasAccount(); acc.setId(7); voucherDetails.setAcc(acc);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Discount On Bill");
			 * voucherDetails.setCrBalance(new BigDecimal(box
			 * .getString(CHARITY_AMOUNT))); voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * FaMasAccount acnt = (FaMasAccount) hbt.load(FaMasAccount.class,
			 * 7); BigDecimal crBalance = new BigDecimal(0); if
			 * (acnt.getCrBalance() != null) crBalance = acnt.getCrBalance();
			 * acnt.setCrBalance(crBalance.add(new BigDecimal(box
			 * .getString(CHARITY_AMOUNT)))); hbt.update(acnt); }
			 * 
			 * if (onAccAmt.compareTo(new BigDecimal(0)) != 0) {
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * FaMasAccount acc = new FaMasAccount(); acc.setId(8);
			 * voucherDetails.setAcc(acc);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Outstanding");
			 * voucherDetails.setCrBalance(onAccAmt);
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(box .getString(CHANGED_DATE)));
			 * voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
			 * voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
			 * hbt.save(voucherDetails);
			 * 
			 * FaMasAccount faAcntObj = (FaMasAccount) hbt.load(
			 * FaMasAccount.class, 8); BigDecimal crBalance = new BigDecimal(0);
			 * if (faAcntObj.getDrBalance() != null) crBalance =
			 * faAcntObj.getCrBalance();
			 * faAcntObj.setCrBalance(crBalance.add(onAccAmt));
			 * hbt.update(faAcntObj); }
			 */
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		return flag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBillNoForRefund(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPaymentAdviceHeader> advHeaderList = new ArrayList<BlPaymentAdviceHeader>();
		List<BlPymntAdviceDispHeader> dispHeaderList = new ArrayList<BlPymntAdviceDispHeader>();
		List<BlOpBillHeader> billServicingNoList = new ArrayList<BlOpBillHeader>();
		List<BlDispensingHeader> billDispensingNoList = new ArrayList<BlDispensingHeader>();
		Set<BlPaymentAdviceDetails> detailsSet = new HashSet<BlPaymentAdviceDetails>();
		Set<BlPymntAdviceDispDetails> dispDetailsSet = new HashSet<BlPymntAdviceDispDetails>();

		Session session = getSession();
		String billType = box.getString(BILL_TYPE);
		String hin = box.getString(HIN_NO);

		if (billType.equals("servicing")) {
			advHeaderList = session.createCriteria(BlPaymentAdviceHeader.class)
					.createAlias("Bill", "bl")
					.add(Restrictions.eq("bl.HinNo", hin)).list();
			if (advHeaderList.size() > 0) {
				for (BlPaymentAdviceHeader advHeader : advHeaderList) {
					boolean refunded = true;
					detailsSet = advHeader.getBlPaymentAdviceDetails();
					for (BlPaymentAdviceDetails obj : detailsSet) {
						if (obj.getRefunded().equals("n")) {
							refunded = false;
							break;
						}
					}
					if (refunded == false) {
						billServicingNoList.add(advHeader.getBill());
						map.put("billServicingNoList", billServicingNoList);
					}
				}
			}
		} else if (billType.equals("dispensing")) {

			dispHeaderList = session
					.createCriteria(BlPymntAdviceDispHeader.class)
					.createAlias("BillDispensing", "bl")
					.add(Restrictions.eq("bl.HinNo", hin)).list();
			if (dispHeaderList.size() > 0) {
				for (BlPymntAdviceDispHeader advDisHeader : dispHeaderList) {
					boolean refunded = true;
					dispDetailsSet = advDisHeader.getBlPymntAdviceDispDetails();
					for (BlPymntAdviceDispDetails obj : dispDetailsSet) {
						if (obj.getRefunded().equals("n")) {
							refunded = false;
							break;
						}
					}
					if (refunded == false) {
						billDispensingNoList.add(advDisHeader
								.getBillDispensing());
						map.put("billDispensingNoList", billDispensingNoList);
					}
				}
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitNo(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		Session session = getSession();
		visitNoList = session.createCriteria(Visit.class)
				.createAlias("Hin", "p")
				.add(Restrictions.eq("p.HinNo", box.getString(HIN_NO))).list();
		map.put("visitNoList", visitNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForCashStatisticsReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		Session session = getSession();
		mainChargeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemCategoryList = session.createCriteria(MasItemCategory.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("mainChargeList", mainChargeList);
		map.put("itemCategoryList", itemCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkBatchNoForIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		int counter = box.getInt("counter");
		boolean flag = false;
		int batchId = 0;
		;
		Session session = getSession();
		String message = "";
		for (int i = 1; i <= counter; i++) {
			batchId = box.getInt("batchId" + i);
			if (batchId != 0) {
				batchList = session.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.idEq(batchId)).list();
				StoreItemBatchStock storeItemBatchStock = batchList.get(0);
				BigDecimal effectiveStockQty = new BigDecimal(0);
				if (storeItemBatchStock.getClosingStock() != null) {
					effectiveStockQty = storeItemBatchStock.getClosingStock();
				}
				/*
				 * if (storeItemBatchStock.getBlockedQty() != null) {
				 * effectiveStockQty = storeItemBatchStock.getClosingStock()
				 * .subtract(storeItemBatchStock.getBlockedQty()); } else {
				 * effectiveStockQty = storeItemBatchStock.getClosingStock(); }
				 */
				if (effectiveStockQty.compareTo(new BigDecimal(box
						.getString("qty" + i))) >= 0) {
					flag = true;
				} else {
					flag = false;
					message += "Stock not available for batch no "
							+ storeItemBatchStock.getBatchNo() + " of Item "
							+ storeItemBatchStock.getItem().getNomenclature()
							+ ".\n";

				}
			}
		}
		map.put("flag", flag);
		map.put("message", message);
		return map;
	}

	public synchronized Map<String, Object> issueItemBatchFromPharmacy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		int counter = box.getInt("counter");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			for (int i = 1; i <= counter; i++) {
				int dispensingDetailsId = box.getInt("dispensingDetailsId" + i);
				int batchId = box.getInt(BATCH_ID + i);
				BigDecimal qty = new BigDecimal(box.getString(QUANTITY + i));
				if (batchId != 0) {
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
							.load(StoreItemBatchStock.class, batchId);
					BigDecimal stockQty = new BigDecimal(0);
					BigDecimal blockedQty = new BigDecimal(0);
					BigDecimal closingStockQty = new BigDecimal(0);
					BigDecimal issueQty = new BigDecimal(0);

					if (storeItemBatchStock.getClosingStock() != null) {
						stockQty = storeItemBatchStock.getClosingStock();
					}
					if (storeItemBatchStock.getBlockedQty() != null) {
						blockedQty = storeItemBatchStock.getBlockedQty();
					}
					if (storeItemBatchStock.getIssueQty() != null) {
						issueQty = storeItemBatchStock.getIssueQty();
					}
					closingStockQty = stockQty.subtract(qty);
					storeItemBatchStock.setClosingStock(closingStockQty);
					// storeItemBatchStock.setBlockedQty(blockedQty.subtract(qty));
					storeItemBatchStock.setIssueQty(issueQty.add(qty));

					hbt.update(storeItemBatchStock);

					BlDispensingDetails blDispensingDetails = (BlDispensingDetails) hbt
							.load(BlDispensingDetails.class,
									dispensingDetailsId);
					blDispensingDetails.setIssued("y");
					hbt.update(blDispensingDetails);
					flag = true;
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	public Map<String, Object> submitTemporaryBillServicingDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String tempBillNo = "";

		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();

			BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
			tempBillNo = generateTempBillNo(box);
			tempOpBillHeader.setTempBillNo(tempBillNo);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			tempOpBillHeader.setHospital(hospital);

			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			tempOpBillHeader.setHin(patient);
			tempOpBillHeader.setBillAmt(new BigDecimal(box
					.getString(BILL_AMOUNT)));

			if (box.getInt(VISIT_ID) != 0) {
				Visit visit = new Visit();
				visit.setId(box.getInt(VISIT_ID));
				tempOpBillHeader.setVisit(visit);
			}
			if (box.getInt(EMPLOYEE_ID) != 0) {
				int empId = (box.getInt(EMPLOYEE_ID));
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				tempOpBillHeader.setConsultant(employee);
			}
			/*
			 * if (box.getInt(EMPLOYEE_ID)) != null &&
			 * !(box.getInt(EMPLOYEE_ID)equals("0"))) { int empId =
			 * Integer.parseInt(request.getParameter(EMPLOYEE_ID)); MasEmployee
			 * employee = new MasEmployee(); employee.setId(empId);
			 * tempOpBillHeader.setConsultant(employee); }
			 */
			/*
			 * MasEmployee employee = new MasEmployee();
			 * employee.setId(box.getInt(EMPLOYEE_ID));
			 * tempOpBillHeader.setConsultant(employee);
			 */
			if (!(box.getString(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				totalDiscount = new BigDecimal(box.getString(DISCOUNT_AMOUNT));
				tempOpBillHeader.setDiscountAmt(totalDiscount);
			}
			if (!(box.getString(ROUND_OF_VALUE).equals(""))) {
				tempOpBillHeader.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (!(box.getString(TOTAL_AMOUNT).equals(""))) {
				tempOpBillHeader.setNetAmt(new BigDecimal(box
						.getString(TOTAL_AMOUNT)));
			}
			if (!(box.getString(ADVANCE_ADJUSTMENT).equals(""))) {
				tempOpBillHeader.setAdvanceAdjustment(new BigDecimal(box
						.getString(ADVANCE_ADJUSTMENT)));
			}
			if (!(box.getString(OUTSTANDING).equals(""))) {
				tempOpBillHeader.setOutstanding(new BigDecimal(box
						.getString(OUTSTANDING)));
			}
			if (!(box.getString(DISCOUNT_ON_BILL).equals(""))) {
				tempOpBillHeader.setDiscountOnBill(new BigDecimal(box
						.getString(DISCOUNT_ON_BILL)));
			}
			if (!(box.getString(PAYABLE_AMOUNT).equals(""))) {
				tempOpBillHeader.setPayableAmt(new BigDecimal(box
						.getString(PAYABLE_AMOUNT)));
			}
			if (box.getInt(AUTHORIZER_ID) != 0) {
				MasAuthorizer authorizer = new MasAuthorizer();
				authorizer.setId(box.getInt(AUTHORIZER_ID));
				tempOpBillHeader.setAuthorizer(authorizer);
			}
			if (!box.getString("compDiscount").equals("")) {
				tempOpBillHeader.setDiscount(new BigDecimal(box
						.getString("compDiscount")));
			}
			if (!box.getString("charity").equals("")) {
				tempOpBillHeader.setCharity(new BigDecimal(box
						.getString("charity")));
			}
			tempOpBillHeader.setTempBillDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			tempOpBillHeader.setTempBillTime(box.getString(CHANGED_TIME));
			tempOpBillHeader.setBillType("servicing");
			Users userObj = new Users();
			userObj.setId(box.getInt("userId"));

			tempOpBillHeader.setChangedBy(userObj);
			tempOpBillHeader.setBillStatus("y");

			hbt.save(tempOpBillHeader);

			int chargeListLength = box.getInt("hiddenValueCharge");

			for (int i = 1; i <= chargeListLength; i++) {
				BlTempOpBillDetails tempOpBillDetails = new BlTempOpBillDetails();

				if (box.getInt(CHARGE_CODE_ID + i) != 0) {
					MasChargeCode chargeCode = new MasChargeCode();
					chargeCode.setId(box.getInt(CHARGE_CODE_ID + i));
					tempOpBillDetails.setChargeCode(chargeCode);

					tempOpBillDetails.setTempOpBillHeader(tempOpBillHeader);
					if (box.getInt(QUANTITY + i) != 0) {
						tempOpBillDetails.setQuantity(box.getInt(QUANTITY + i));
					}
					if (!box.getString(AMOUNT + i).equals("")) {
						tempOpBillDetails.setAmount(new BigDecimal(box
								.getString(AMOUNT + i)));
					}
					if (!box.getString(RATE + i).equals("")) {
						tempOpBillDetails.setRate(new BigDecimal(box
								.getString(RATE + i)));
					}
					if (!box.getString(DISCOUNT_PERCENTAGE + i).equals("")) {
						tempOpBillDetails.setDiscountPercent(new BigDecimal(box
								.getString(DISCOUNT_PERCENTAGE + i)));
					}
					if (!box.getString(DISCOUNT + i).equals("")) {
						tempOpBillDetails.setDiscountAmt(new BigDecimal(box
								.getString(DISCOUNT + i)));
					}
					if (!box.getString(PROPORTIONAL_DISCOUNT + i).equals("")) {
						tempOpBillDetails
								.setProportionalDiscountAmount(new BigDecimal(
										box.getString(PROPORTIONAL_DISCOUNT + i)));
					}
					if (!box.getString(NET_AMOUNT + i).equals("")) {
						tempOpBillDetails.setNetAmt(new BigDecimal(box
								.getString(NET_AMOUNT + i)));
					}
					tempOpBillDetails.setChangedBy(userObj);
					tempOpBillDetails.setTempBillDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					tempOpBillDetails.setTempBillTime(box
							.getString(CHANGED_TIME));

					hbt.save(tempOpBillDetails);
				}

			}
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		map.put("tempBillNo", tempBillNo);
		return map;
	}

	@SuppressWarnings("unchecked")
	private String generateTempBillNo(Box box) {
		Integer tempBillSeqNo = 0;
		String tempBillNo = "";
		List<BlParameter> tempBillSeqNoList = new ArrayList<BlParameter>();

		Session session = (Session) getSession();
		try {
			tempBillSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "TBL")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (tempBillSeqNoList.size() > 0) {

			int id = tempBillSeqNoList.get(0).getId();
			tempBillSeqNo = tempBillSeqNoList.get(0).getSeqNo() + 1;

			BlParameter parameterObj = (BlParameter) hbt.load(
					BlParameter.class, id);
			parameterObj.setSeqNo(tempBillSeqNo);
			hbt.update(parameterObj);
		} else {
			BlParameter blParameter = new BlParameter();
			tempBillSeqNo = 1;
			blParameter.setSeqNo(tempBillSeqNo);
			blParameter.setPrefix("TBL");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			blParameter.setLastChgTime(box.getString(CHANGED_TIME));
			hbt.save(blParameter);

		}

		tempBillNo = tempBillSeqNo.toString();
		return tempBillNo;
	}

	public Map<String, Object> submitTemporaryBillDispensingDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		Transaction tx = null;
		Session session = getSession();
		String tempBillNo = "";
		try {
			tx = session.beginTransaction();

			BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();

			tempBillNo = generateTempBillNo(box);
			tempOpBillHeader.setTempBillNo(tempBillNo);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			tempOpBillHeader.setHospital(hospital);

			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			tempOpBillHeader.setHin(patient);
			tempOpBillHeader.setBillAmt(new BigDecimal(box
					.getString(BILL_AMOUNT)));

			if (box.getInt(VISIT_ID) != 0) {
				Visit visit = new Visit();
				visit.setId(box.getInt(VISIT_ID));
				tempOpBillHeader.setVisit(visit);
			}
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(EMPLOYEE_ID));
			tempOpBillHeader.setConsultant(employee);
			if (!(box.getString(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				totalDiscount = new BigDecimal(box.getString(DISCOUNT_AMOUNT));
				tempOpBillHeader.setDiscountAmt(totalDiscount);
			}
			if (!(box.getString(ROUND_OF_VALUE).equals(""))) {
				tempOpBillHeader.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (!(box.getString(TOTAL_AMOUNT).equals(""))) {
				tempOpBillHeader.setNetAmt(new BigDecimal(box
						.getString(TOTAL_AMOUNT)));
			}
			if (!(box.getString(ADVANCE_ADJUSTMENT).equals(""))) {
				tempOpBillHeader.setAdvanceAdjustment(new BigDecimal(box
						.getString(ADVANCE_ADJUSTMENT)));
			}
			if (!(box.getString(OUTSTANDING).equals(""))) {
				tempOpBillHeader.setOutstanding(new BigDecimal(box
						.getString(OUTSTANDING)));
			}
			if (!(box.getString(DISCOUNT_ON_BILL).equals(""))) {
				tempOpBillHeader.setDiscountOnBill(new BigDecimal(box
						.getString(DISCOUNT_ON_BILL)));
			}
			if (!(box.getString(PAYABLE_AMOUNT).equals(""))) {
				tempOpBillHeader.setPayableAmt(new BigDecimal(box
						.getString(PAYABLE_AMOUNT)));
			}
			if (box.getInt(AUTHORIZER_ID) != 0) {
				MasAuthorizer authorizer = new MasAuthorizer();
				authorizer.setId(box.getInt(AUTHORIZER_ID));
				tempOpBillHeader.setAuthorizer(authorizer);
			}
			if (!box.getString("compDiscount").equals("")) {
				tempOpBillHeader.setDiscount(new BigDecimal(box
						.getString("compDiscount")));
			}
			if (!box.getString("charity").equals("")) {
				tempOpBillHeader.setCharity(new BigDecimal(box
						.getString("charity")));
			}
			tempOpBillHeader.setTempBillDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			tempOpBillHeader.setTempBillTime(box.getString(CHANGED_TIME));
			tempOpBillHeader.setBillType("dispensing");

			Users userObj = new Users();
			userObj.setId(box.getInt("userId"));

			tempOpBillHeader.setChangedBy(userObj);
			tempOpBillHeader.setBillStatus("y");

			hbt.save(tempOpBillHeader);

			int batchWiseItemListLength = box.getInt("batchNoCounter");
			for (int i = 1; i <= batchWiseItemListLength; i++) {
				BlTempBillDispensingDetails tempDispensingDetails = new BlTempBillDispensingDetails();
				tempDispensingDetails.setTempOpBillHeader(tempOpBillHeader);
				if (box.getInt(BATCH_ITEM_ID + i) != 0) {
					MasStoreItem storeItem = new MasStoreItem();
					storeItem.setId(box.getInt(BATCH_ITEM_ID + i));
					tempDispensingDetails.setItem(storeItem);

					if (box.getInt(BATCH_ID + i) != 0) {
						StoreItemBatchStock itemBatchStock = new StoreItemBatchStock();
						itemBatchStock.setId(box.getInt(BATCH_ID + i));
						tempDispensingDetails.setBatch(itemBatchStock);
					}
					if (box.getString(ISSUE_QUANTITY + i) != null
							&& !box.getString(ISSUE_QUANTITY + i).equals("")) {
						tempDispensingDetails.setQty(new BigDecimal(box
								.getString(ISSUE_QUANTITY + i)));
					}
					if (box.getString("batchAmt" + i) != null
							&& !box.getString("batchAmt" + i).equals("")) {
						tempDispensingDetails.setAmount(new BigDecimal(box
								.getString("batchAmt" + i)));
					}
					if (box.getString("batchDisPer" + i) != null
							&& !box.getString("batchDisPer" + i).equals("")) {
						tempDispensingDetails
								.setDiscountPercent(new BigDecimal(box
										.getString("batchDisPer" + i)));
					}
					if (box.getString("batchDisAmt" + i) != null
							&& !box.getString("batchDisAmt" + i).equals("")) {
						tempDispensingDetails.setDiscountAmt(new BigDecimal(box
								.getString("batchDisAmt" + i)));
					}
					if (box.getString("batchPrptDisAmt" + i) != null
							&& !box.getString("batchPrptDisAmt" + i).equals("")) {
						tempDispensingDetails
								.setProportionalDisAmt(new BigDecimal(box
										.getString("batchPrptDisAmt" + i)));
					}
					if (!box.getString("batchSalesTaxAmt" + i).equals("")) {
						tempDispensingDetails.setSalesTaxAmt(new BigDecimal(box
								.getString("batchSalesTaxAmt" + i)));
					}
					if (box.getString("batchNetAmt" + i) != null
							&& !box.getString("batchNetAmt" + i).equals("")) {
						tempDispensingDetails.setNetAmt(new BigDecimal(box
								.getString("batchNetAmt" + i)));
					}
					tempDispensingDetails.setChangedBy(userObj);
					tempDispensingDetails.setTempBillDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					tempDispensingDetails.setTempBillTime(box
							.getString(CHANGED_TIME));

					hbt.save(tempDispensingDetails);
				}
			}
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		map.put("tempBillNo", tempBillNo);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemDiscount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		int billTypeId = 0;
		int schemeId=box.getInt("schemeId");
		String patientCatgry = "";

		try {

			itemList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", box.getString("itemCode")))
					.list();
			MasStoreItem storeItem = new MasStoreItem();
			storeItem = itemList.get(0);
			int itemId = storeItem.getId();

			if (box.getInt("hinId") != 0) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", box.getInt("hinId"))).list();
			}
			box.put(RequestConstants.ITEM_ID, itemId);
			if(schemeId!=0)
			{
				discountList = billingMasterDataService
						.serviceDispensingScheme(box);
			}
			else
			{
			discountList = billingMasterDataService
					.serviceDispensingDiscount(box);
			}
			if (patientList.size() > 0) {
				/*
				 * System.out.println("patientList=======:"+patientList.size());
				 * Patient patient = (Patient) patientList.get(0); int
				 * patientTypeId = 0; int companyId = 0; if
				 * (patientList.get(0).getPatientType() != null) { patientTypeId
				 * = patient.getPatientType().getId(); } if
				 * (patientList.get(0).getCompany() != null) { companyId =
				 * patient.getCompany().getId(); }
				 * 
				 * billTypeId = 1; if
				 * (patient.getPatientStatus().equals("Out Patient"))
				 * patientCatgry = "OP"; else if
				 * (patient.getPatientStatus().equals("In Patient"))
				 * patientCatgry = "IP";
				 * 
				 * 
				 * List<MasDiscount> criteriaDiscountList = new
				 * ArrayList<MasDiscount>(); Criteria crit = null;
				 * 
				 * crit = session.createCriteria(MasDiscount.class)
				 * .add(Restrictions.le("EffectiveDateFrom", currentDate))
				 * .createAlias("PatientType", "pt")
				 * .add(Restrictions.eq("pt.Id", patientTypeId)); if (companyId
				 * != 0) { crit = crit.createAlias("Company", "com").add(
				 * Restrictions.eq("com.Id", companyId)); } criteriaDiscountList
				 * = crit.list(); Criteria criteria = null; if
				 * (criteriaDiscountList.size() > 0) { for (MasDiscount
				 * masDiscount : criteriaDiscountList) { criteria = session
				 * .createCriteria(MasDiscount.class)
				 * .add(Restrictions.le("EffectiveDateFrom", currentDate))
				 * .createAlias("PatientType", "pt")
				 * .add(Restrictions.eq("pt.Id", patientTypeId));
				 * 
				 * if (masDiscount.getCompany() != null) { crit =
				 * criteria.createAlias("Company", "com").add(
				 * Restrictions.eq("com.Id", companyId)); }
				 * 
				 * if (masDiscount.getBillType() != null) { criteria =
				 * criteria.createAlias("BillType", "bt")
				 * .add(Restrictions.eq("bt.Id", billTypeId)); } if
				 * (masDiscount.getPatientCategory() != null) { criteria =
				 * criteria.add(Restrictions.eq( "PatientCategory",
				 * patientCatgry)); }
				 * 
				 * if(masDiscount.getRoomType() != null){ criteria =
				 * criteria.createAlias("RoomType",
				 * "rt").add(Restrictions.eq("rt.Id",roomTypeId)); }
				 * 
				 * if(masDiscount.getItem()!=null) { if (itemId != 0) { if
				 * (itemId == masDiscount.getItem().getId()) { criteria =
				 * criteria .createAlias("Item", "i").add(
				 * Restrictions.eq("i.Id", itemId)); } } }
				 * 
				 * } discountList = criteria.list(); }
				 */
				BigDecimal discAmt = new BigDecimal(0);
				BigDecimal discPercnt = new BigDecimal(0);
				BigDecimal fixedAmount = new BigDecimal(0);
				if (discountList.size() > 0) {
					MasDiscount discount = discountList.get(0);
					if (discount.getDiscountPercentage() != null) {
						discPercnt = discount.getDiscountPercentage();

					} else if (discount.getDiscountValue() != null) {
						discAmt = discount.getDiscountValue();

					} else if (discount.getFixedValue() != null) {
						if (discount.getDiscountType().equalsIgnoreCase("f")) {
							fixedAmount = discount.getFixedValue();
						}
					}
					map.put("discountType", discount.getDiscountType());
				}
				map.put("fixedAmount", fixedAmount);
				map.put("discPercnt", discPercnt);
				map.put("discAmt", discAmt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCompanyPatientListForSettlement(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();

		List<BlOpBillHeader> tempOpServicingList = new ArrayList<BlOpBillHeader>();
		List<BlDispensingHeader> tempOpDispensingList = new ArrayList<BlDispensingHeader>();
		List<BlFinalBillDetails> tempIpBillList = new ArrayList<BlFinalBillDetails>();

		List<BlOpBillHeader> opServicingList = new ArrayList<BlOpBillHeader>();
		List<BlDispensingHeader> opDispensingList = new ArrayList<BlDispensingHeader>();
		List<BlFinalBillDetails> ipBillList = new ArrayList<BlFinalBillDetails>();
		List<BlCompanySettlementDetails> companySettlementList = new ArrayList<BlCompanySettlementDetails>();
		List<BlCompanySettlementDetails> listForSettledAmt = new ArrayList<BlCompanySettlementDetails>();

		int companyId = box.getInt(COMPANY);
		String patientType = box.getString("patientType");
		Session session = getSession();

		if (patientType.equals("op") || patientType.equals("both")) {
			tempOpServicingList = session.createCriteria(BlOpBillHeader.class)
					.createAlias("Company", "com")
					.add(Restrictions.eq("com.Id", companyId)).list();
			tempOpDispensingList = session
					.createCriteria(BlDispensingHeader.class)
					.createAlias("Company", "com")
					.add(Restrictions.eq("com.Id", companyId))
					.add(Restrictions.isNull("Inpatient.Id")).list();

			for (BlOpBillHeader billHeader : tempOpServicingList) {
				companySettlementList = session
						.createCriteria(BlCompanySettlementDetails.class)
						.createAlias("OpBillHeader", "obh")
						.add(Restrictions.eq("obh.Id", billHeader.getId()))
						.list();
				if (companySettlementList.size() > 0) {
					for (BlCompanySettlementDetails compDt : companySettlementList) {
						if (billHeader.getNetAmt().compareTo(
								compDt.getSettledAmount()) > 0) {
							opServicingList.add(billHeader);
							listForSettledAmt.add(compDt);
						}
					}
				} else {
					opServicingList.add(billHeader);
				}
			}

			for (BlDispensingHeader dispensingHeader : tempOpDispensingList) {
				companySettlementList = session
						.createCriteria(BlCompanySettlementDetails.class)
						.createAlias("DispensingHeader", "obh")
						.add(Restrictions.eq("obh.Id", dispensingHeader.getId()))
						.list();
				if (companySettlementList.size() > 0) {
					for (BlCompanySettlementDetails compDt : companySettlementList) {
						if (dispensingHeader.getNetAmt().compareTo(
								compDt.getSettledAmount()) > 0) {
							opDispensingList.add(dispensingHeader);
							listForSettledAmt.add(compDt);
						}
					}
				} else {
					opDispensingList.add(dispensingHeader);
				}
			}

			if (opServicingList.size() > 0)
				map.put("opServicingList", opServicingList);

			if (opDispensingList.size() > 0)
				map.put("opDispensingList", opDispensingList);
		}
		if (patientType.equals("ip") || patientType.equals("both")) {
			tempIpBillList = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Company", "com")
					.add(Restrictions.eq("com.Id", companyId)).list();

			for (BlFinalBillDetails finalBillDetails : tempIpBillList) {
				companySettlementList = session
						.createCriteria(BlCompanySettlementDetails.class)
						.createAlias("IpFinalBillDetails", "obh")
						.add(Restrictions.eq("obh.Id", finalBillDetails.getId()))
						.list();
				if (companySettlementList.size() > 0) {
					for (BlCompanySettlementDetails compDt : companySettlementList) {
						if (finalBillDetails.getNetAmt().compareTo(
								compDt.getSettledAmount()) > 0) {
							ipBillList.add(finalBillDetails);
							listForSettledAmt.add(compDt);
						}
					}
				} else {
					ipBillList.add(finalBillDetails);
				}
			}

			if (ipBillList.size() > 0)
				map.put("ipBillList", ipBillList);
		}
		bankList = session.createCriteria(MasBankMaster.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("bankList", bankList);
		if (companySettlementList.size() > 0) {
			map.put("companySettlementList", companySettlementList);
		}
		if (listForSettledAmt.size() > 0) {
			map.put("listForSettledAmt", listForSettledAmt);
		}

		return map;
	}

	public Map<String, Object> submitCompanySettlementDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Date settlementDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(CHANGED_DATE));
		boolean saved = false;
		Transaction tx = null;
		Session session = getSession();
		try {
			tx = session.beginTransaction();

			BlCompanySettlementHeader companySettlementHeader = new BlCompanySettlementHeader();
			MasCompany company = new MasCompany();
			company.setId(box.getInt(COMPANY));
			companySettlementHeader.setCompany(company);
			companySettlementHeader.setPatientCategory(box
					.getString("patientType"));
			companySettlementHeader.setSettlementAmount(new BigDecimal(box
					.getString(AMOUNT)));
			companySettlementHeader.setSettlementDate(settlementDate);
			companySettlementHeader.setSettlementTime(box
					.getString(CHANGED_TIME));
			Users users = new Users();
			users.setId(box.getInt("userId"));
			companySettlementHeader.setChangedBy(users);
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			companySettlementHeader.setHospital(hospital);
			hbt.save(companySettlementHeader);

			int count = box.getInt("billCount");
			if (count > 0) {
				for (int i = 1; i < count; i++) {
					if (box.getInt(BILL_ID + i) != 0) {
						BlCompanySettlementDetails companySettlementDetails = new BlCompanySettlementDetails();
						BlReceiptHeader receiptHeader = new BlReceiptHeader();

						companySettlementDetails
								.setCompanySettlementHeader(companySettlementHeader);
						companySettlementDetails
								.setSettledAmount(new BigDecimal(box
										.getString(PAID_AMOUNT + i)));
						BlOpBillHeader billHeader = new BlOpBillHeader();
						if (box.getString(BILL_TYPE + i).equals("opservicing")) {
							billHeader.setId(box.getInt(BILL_ID + i));
							companySettlementDetails
									.setOpBillHeader(billHeader);
							receiptHeader.setOpBillHeader(billHeader);
							receiptHeader.setReceiptType("opb");
						}
						BlDispensingHeader dispensingHeader = new BlDispensingHeader();
						if (box.getString(BILL_TYPE + i).equals("opdispensing")) {
							dispensingHeader.setId(box.getInt(BILL_ID + i));
							companySettlementDetails
									.setDispensingHeader(dispensingHeader);
							receiptHeader.setDispensingHeader(dispensingHeader);
							receiptHeader.setReceiptType("bld");
						}
						BlFinalBillDetails finalBillDetails = new BlFinalBillDetails();
						if (box.getString(BILL_TYPE + i).equals("ipbill")) {
							finalBillDetails.setId(box.getInt(BILL_ID + i));
							companySettlementDetails
									.setIpFinalBillDetails(finalBillDetails);
							receiptHeader.setIpFinalBill(finalBillDetails);
							receiptHeader.setReceiptType("fs");
						}

						hbt.save(companySettlementDetails);

						String receiptNo = "";
						receiptNo = generateReceiptNo("save",box.getInt("hospitalId"));
						receiptHeader.setReceiptNo(receiptNo);
						receiptHeader.setAmount(new BigDecimal(box
								.getString(PAID_AMOUNT + i)));
						Patient hin = new Patient();
						hin.setId(box.getInt(HIN_ID + i));
						receiptHeader.setHin(hin);
						receiptHeader.setHospital(hospital);
						receiptHeader.setReceiptDate(settlementDate);
						receiptHeader.setReceiptTime(box
								.getString(CHANGED_TIME));
						receiptHeader.setChangedBy(users);
						if (box.getInt(INPATIENT_ID) != 0) {
							Inpatient inpatient = new Inpatient();
							inpatient.setId(box.getInt(INPATIENT_ID));
							receiptHeader.setInpatient(inpatient);
						}

						try {
							hbt.save(receiptHeader);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}
						// ------------------Saving Data into bl_receipt_detail
						// table-------------------------

						BlReceiptDetails receiptDetails = new BlReceiptDetails();
						receiptDetails.setPaymentMode("Q");
						BigDecimal amtReceived = new BigDecimal(
								box.getString(PAID_AMOUNT + i));
						receiptDetails.setAmount(amtReceived);
						receiptDetails.setChequeNo(box.getString(CHEQUE_NO));
						receiptDetails.setChequeDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString(CHEQUE_DATE)));

						MasBankMaster bankMaster = new MasBankMaster();
						bankMaster.setId(box.getInt(BANK_ID));
						receiptDetails.setBank(bankMaster);
						receiptDetails.setReceiptDate(settlementDate);
						receiptDetails.setReceiptTime(box
								.getString(CHANGED_TIME));
						receiptDetails.setChangedBy(users);
						receiptDetails.setReceiptHeader(receiptHeader);
						try {
							hbt.save(receiptDetails);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}

						Patient patient = (Patient) hbt.load(Patient.class,
								box.getInt(HIN_ID + i));
						BigDecimal pastDue = new BigDecimal(0);
						if (patient.getPastDue() != null) {
							pastDue = new BigDecimal(patient.getPastDue());
						}
						BigDecimal newAmt = new BigDecimal(0);
						newAmt = pastDue.subtract(new BigDecimal(box
								.getString(PAID_AMOUNT + i)));
						patient.setPastDue(newAmt.toString());
						hbt.update(patient);
					}
				}

			}
			saved = true;
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTemplateDetailsForBilling(Box box) {
		Session session = (Session) getSession();
		List<OpdTemplateInvestigation> investigationTemplateList = new ArrayList<OpdTemplateInvestigation>();
		Map<String, Object> map = new HashMap<String, Object>();
		int templateId = box.getInt("template");
		try {
			// patientList=session.createQuery("select v from Visit as v where
			// v.VisitDate="+date ).list();
			if (templateId != 0) {
				investigationTemplateList = session
						.createCriteria(OpdTemplateInvestigation.class)
						.createAlias("Template", "template")
						.add(Restrictions.eq("template.Id", templateId)).list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("investigationTemplateList", investigationTemplateList);

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> scheduledBillDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = getSession();

		try {
			inpatientList = session.createCriteria(Inpatient.class).list();
			for (Inpatient inpatient : inpatientList) {
				int hinId = inpatient.getHin().getId();
				int deptId = inpatient.getDepartment().getId();

				StringBuilder query = new StringBuilder();
				query.append(" update bl_charge_slip_detail set department_id = '"
						+ deptId + "'");
				query.append(" from bl_charge_slip_detail as bd  ");
				query.append(" join bl_charge_slip_main main on main.charge_slip_main_id = bd.charge_slip_main_id ");
				query.append(" where main.hin_id = '" + hinId
						+ "' and main.room_processed = 'y' ");

				int row3 = session.createSQLQuery(query.toString())
						.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Daily Room Rent Charges Calculation for Inpatient
	 * 
	 * @author Mohit Uppal
	 * @Date 06 Nov 2010
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> scheduledDailyChargeEntry(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> chargeDtMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BlFinalBillDetails> blFinalList = new ArrayList<BlFinalBillDetails>();
		List<MasChargeCode> chargeSetupList = new ArrayList<MasChargeCode>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = null;
		Date lastProcessedDate = null;
		HospitalParameters hospitalParametersObj = new HospitalParameters();
		List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();
		List<BlChargeSlipMain> blchargeSetupList = new ArrayList<BlChargeSlipMain>();
		List<MasRoom> roomTransferInpatient = new ArrayList<MasRoom>();

		Transaction tx = null;
		Session session = getSession();
		Criteria Roomcrit = null;

		if (dataMap.get("processDate") != null) {
			changeDate = (Date) dataMap.get("processDate");
		}

		Criteria c = session.createCriteria(HospitalParameters.class).addOrder(
				Order.asc("Id"));
		c.setFirstResult(0);
		c.setMaxResults(1);
		hospitalParamList = c.list();
		long diffDays = 0;
		if (hospitalParamList != null && hospitalParamList.size() > 0) {
			hospitalParametersObj = hospitalParamList.get(0);
			if (hospitalParametersObj.getLastProcessedDate() != null) {
				lastProcessedDate = hospitalParametersObj
						.getLastProcessedDate();
				diffDays = LeaveManagementUtil.daysDifferenceBetweenTwoDates(
						lastProcessedDate, new Date());
			} else {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				lastProcessedDate = cal.getTime();
				diffDays = 1;
			}
		}

		try {
			tx = session.beginTransaction();
			*//**
			 * If diffDays==0 means Room Rent processed for current date If room
			 * rent has processed but some of patient is missing then else part
			 * is working Code By Mukesh Narayan Singh Date 15 July 2011
			 *//*
			if (diffDays > 0) {
				for (int j = 1; j <= diffDays; j++) {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(lastProcessedDate);
					int dateValue = calendar.get(Calendar.DATE);
					calendar.set(Calendar.DATE, dateValue + j);
					Date processDate = calendar.getTime();
					inpatientList = session.createCriteria(Inpatient.class)
							.add(Restrictions.eq("AdStatus", "A")).list();
					for (Inpatient inpatient : inpatientList) {
						Map<String, Object> detailsMap = new HashMap<String, Object>();
						Integer lastChargeSlipDeptId = 0;
						Integer roomTypeId = 0;

						BigDecimal totalChargeAmountNew = new BigDecimal(0);
						BigDecimal totalDiscAmtNew = new BigDecimal(0);
						BigDecimal totalNetAmountNew = new BigDecimal(0);
						BigDecimal chargeIdNew = new BigDecimal(0);
						BigDecimal discountPercentNew = new BigDecimal(0.00);
						BigDecimal stdDeductionNew = new BigDecimal(0.00);
						BigDecimal rateNew = new BigDecimal(0.00);

						BigDecimal totalChargeAmount = new BigDecimal(0);
						BigDecimal totalDiscAmt = new BigDecimal(0);
						BigDecimal totalNetAmount = new BigDecimal(0);
						BigDecimal chargeIdNewLower = new BigDecimal(0);
						BigDecimal stdDeductionLower = new BigDecimal(0.00);
						BigDecimal discountPercentLower = new BigDecimal(0.00);
						BigDecimal rateLower = new BigDecimal(0.00);

						int inpatientId = inpatient.getId();
						int hinId = inpatient.getHin().getId();
						int hospitalId = inpatient.getHospital().getId();
						Date inpatient_dateOfAddmission = inpatient
								.getDateOfAddmission();

						if (processDate.before(inpatient_dateOfAddmission)) {
						} else {
							blFinalList = session
									.createCriteria(BlFinalBillDetails.class)
									.add(Restrictions.eq("Inpatient.Id",
											inpatientId)).list();

							blchargeSetupList = session
									.createCriteria(BlChargeSlipMain.class)
									.createAlias("Hin", "hn")
									.createAlias("Inpatient", "Inp")
									.add(Restrictions.eq("hn.Id", hinId))
									.add(Restrictions.eq("Inp.Id", inpatientId))
									.add(Restrictions.eq("RoomProcessed", "y"))
									.add(Restrictions.eq("ChgSlpDate",
											new Date()))
									.addOrder(Order.desc("Id"))
									.setMaxResults(1).list();

							if (blFinalList.size() > 0) {
							} else {
								if (blchargeSetupList.size() > 0) {
									Integer chargeDetailId = 0;
									Integer Id = 0;

									Id = blchargeSetupList.get(0).getId();
									List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

									chargeSlipDetail = session
											.createCriteria(
													BlChargeSlipDetail.class)
											.add(Restrictions.eq(
													"ChargeSlipMain.Id", Id))
											.list();

									if (chargeSlipDetail.size() > 0) {
										chargeDetailId = chargeSlipDetail
												.get(0).getId();
										lastChargeSlipDeptId = chargeSlipDetail
												.get(0).getDepartment().getId();
									}

									if (inpatient.getHin().getCompany() != null) {
										detailsMap.put("companyId", inpatient
												.getHin().getCompany().getId());
									}

									detailsMap.put("patientTypeId", inpatient
											.getHin().getPatientType().getId());
									detailsMap.put("regType", inpatient
											.getHin().getRegistrationType());
									detailsMap.put("billTypeId", 2);
									detailsMap.put("patientCategory", "IP");
									detailsMap.put("roomTypeId", inpatient
											.getBed().getRoom().getRoomType()
											.getId());
									detailsMap.put("session", session);

									chargeDtMap = adtDataService
											.pateintRoomRentCharge(detailsMap);

									if (chargeDtMap.get("totalChargeAmount") != null) {
										totalChargeAmount = (BigDecimal) chargeDtMap
												.get("totalChargeAmount");
									}

									if (chargeDtMap.get("totalDiscAmt") != null) {
										totalDiscAmt = (BigDecimal) chargeDtMap
												.get("totalDiscAmt");
									}

									if (chargeDtMap.get("totalNetAmount") != null) {
										totalNetAmount = (BigDecimal) chargeDtMap
												.get("totalNetAmount");
									}

									if (chargeDtMap.get("chargeId") != null) {
										chargeIdNew = (BigDecimal) chargeDtMap
												.get("chargeId");
									}

									if (chargeDtMap.get("stdDeduction") != null) {
										stdDeductionNew = (BigDecimal) chargeDtMap
												.get("stdDeduction");
									}

									if (chargeDtMap.get("rate") != null) {
										rateNew = (BigDecimal) chargeDtMap
												.get("rate");
									}

									if (chargeDtMap.get("discountPercent") != null) {
										discountPercentNew = (BigDecimal) chargeDtMap
												.get("discountPercent");
									}

									detailsMap = new HashMap<String, Object>();
									chargeDtMap = new HashMap<String, Object>();

									Roomcrit = session
											.createCriteria(MasRoom.class)
											.createAlias("Department", "dept")
											.add(Restrictions.eq("dept.Id",
													lastChargeSlipDeptId));

									roomTransferInpatient = Roomcrit.list();

									if (roomTransferInpatient.size() > 0
											&& roomTransferInpatient != null) {
										roomTypeId = roomTransferInpatient
												.get(0).getRoomType().getId();
										detailsMap
												.put("roomTypeId", roomTypeId);
									}

									if (inpatient.getHin().getCompany() != null) {
										detailsMap.put("companyId", inpatient
												.getHin().getCompany().getId());
									}

									detailsMap.put("patientTypeId", inpatient
											.getHin().getPatientType().getId());
									detailsMap.put("regType", inpatient
											.getHin().getRegistrationType());
									detailsMap.put("billTypeId", 2);
									detailsMap.put("patientCategory", "IP");
									detailsMap.put("session", session);

									chargeDtMap = adtDataService
											.pateintRoomRentCharge(detailsMap);

									if (chargeDtMap.get("totalChargeAmount") != null) {
										totalChargeAmountNew = (BigDecimal) chargeDtMap
												.get("totalChargeAmount");
									}

									if (chargeDtMap.get("totalDiscAmt") != null) {
										totalDiscAmtNew = (BigDecimal) chargeDtMap
												.get("totalDiscAmt");
									}

									if (chargeDtMap.get("totalNetAmount") != null) {
										totalNetAmountNew = (BigDecimal) chargeDtMap
												.get("totalNetAmount");
									}

									if (chargeDtMap.get("chargeId") != null) {
										chargeIdNewLower = (BigDecimal) chargeDtMap
												.get("chargeId");
									}

									if (chargeDtMap.get("stdDeduction") != null) {
										stdDeductionLower = (BigDecimal) chargeDtMap
												.get("stdDeduction");
									}

									if (chargeDtMap.get("rate") != null) {
										rateLower = (BigDecimal) chargeDtMap
												.get("rate");
									}

									if (chargeDtMap.get("discountPercent") != null) {
										discountPercentLower = (BigDecimal) chargeDtMap
												.get("discountPercent");
									}

									if (totalNetAmount.intValue() > totalNetAmountNew
											.intValue()) {
										if (lastChargeSlipDeptId == 23) {
											Map<String, Object> RoomdataMap = new HashMap<String, Object>();
											RoomdataMap.put(
													"lastProcessedDate",
													lastProcessedDate);
											RoomdataMap.put("userId", 1);
											RoomdataMap.put("session", session);
											RoomdataMap
													.put("userName", "admin");

											billingDataService
													.singlePateintRoomRentCalculate(
															RoomdataMap, hinId);
										} else {
											BlChargeSlipMain mainMaster = (BlChargeSlipMain) getHibernateTemplate()
													.get(BlChargeSlipMain.class,
															Id);
											mainMaster
													.setChgSlpAmt(totalChargeAmount);
											mainMaster
													.setOsAmt(totalChargeAmount);
											mainMaster
													.setNetAmt(totalNetAmount);
											session.update(mainMaster);

											BlChargeSlipDetail Detailmaster = (BlChargeSlipDetail) getHibernateTemplate()
													.get(BlChargeSlipDetail.class,
															chargeDetailId);
											Detailmaster
													.setAmt(totalChargeAmount);
											Detailmaster
													.setNetAmt(totalNetAmount);
											Detailmaster
													.setRate(totalChargeAmount);
											MasDepartment department = new MasDepartment();
											department.setId(inpatient
													.getDepartment().getId());
											Detailmaster
													.setDepartment(department);
											session.update(Detailmaster);
										}
									} else if (totalNetAmountNew.intValue() > totalNetAmount
											.intValue()) {
									}
								} else {
									Integer chargeTypeId = getMasChargeTypeId();

									chargeSetupList = session
											.createCriteria(MasChargeCode.class)
											.add(Restrictions.eq(
													"ChargeType.Id",
													chargeTypeId)).list();

									if (inpatient.getHin().getCompany() != null) {
										detailsMap.put("companyId", inpatient
												.getHin().getCompany().getId());
									}

									detailsMap.put("patientTypeId", inpatient
											.getHin().getPatientType().getId());
									detailsMap.put("regType", inpatient
											.getHin().getRegistrationType());
									detailsMap.put("billTypeId", 2);
									detailsMap.put("patientCategory", "IP");
									detailsMap.put("roomTypeId", inpatient
											.getBed().getRoom().getRoomType()
											.getId());

									// --------------- For getting total
									// amount-----------------
									for (MasChargeCode chargeSetup : chargeSetupList) {
										int chargeCodeId = 0;
										chargeCodeId = chargeSetup.getId();

										detailsMap
												.put("chargeId", chargeCodeId);
										detailsMap.put("mainChargeId",
												chargeSetup.getMainChargecode()
														.getId());
										detailsMap.put("subChargeId",
												chargeSetup.getSubChargecode()
														.getId());

										chargeDtMap = getChargeAmountAfterDiscount(detailsMap);
										BigDecimal chargeAmountAfterDis = new BigDecimal(
												0);
										BigDecimal discAmt = new BigDecimal(0);
										BigDecimal chargeAfterSD = new BigDecimal(
												0);

										if (chargeDtMap
												.get("chargeAmountAfterDis") != null) {
											chargeAmountAfterDis = (BigDecimal) chargeDtMap
													.get("chargeAmountAfterDis");
										}
										if (chargeDtMap.get("discAmt") != null) {
											discAmt = (BigDecimal) chargeDtMap
													.get("discAmt");
										}
										if (chargeDtMap.get("chargeAfterSD") != null) {
											chargeAfterSD = (BigDecimal) chargeDtMap
													.get("chargeAfterSD");
										}
										totalChargeAmount = totalChargeAmount
												.add(chargeAfterSD
														.multiply(new BigDecimal(
																1)));
										totalDiscAmt = totalDiscAmt.add(discAmt
												.multiply(new BigDecimal(1)));
										totalNetAmount = totalNetAmount
												.add(chargeAmountAfterDis
														.multiply(new BigDecimal(
																1)));
									}

									// ----------Saving data into Charge Slip
									// Header & Details-----
									BlChargeSlipMain chargeSlipMain = new BlChargeSlipMain();
									Patient patient = new Patient();
									patient.setId(hinId);
									chargeSlipMain.setHin(patient);

									Inpatient inpatientObj = new Inpatient();
									inpatientObj.setId(inpatientId);
									chargeSlipMain.setInpatient(inpatientObj);

									MasHospital hospital = new MasHospital();
									hospital.setId(hospitalId);
									chargeSlipMain.setHospital(hospital);

									int chargeSlipNo = 0;
									chargeSlipNo = getChargeSlipNo("save");
									chargeSlipMain
											.setChargeSlipNo(chargeSlipNo);
									chargeSlipMain
											.setChgSlpAmt(totalChargeAmount);
									chargeSlipMain.setOsAmt(totalChargeAmount);

									if (totalDiscAmt
											.compareTo(new BigDecimal(0)) > 0) {
										chargeSlipMain
												.setDiscountAmt(totalDiscAmt);
									}
									chargeSlipMain.setNetAmt(totalNetAmount);

									MasPatientType patientType = new MasPatientType();
									patientType.setId(inpatient.getHin()
											.getPatientType().getId());
									chargeSlipMain.setPatientType(patientType);

									if (inpatient.getHin().getCompany() != null) {
										MasCompany company = new MasCompany();
										company.setId(inpatient.getHin()
												.getCompany().getId());
										chargeSlipMain.setCompany(company);
									}

									chargeSlipMain.setChgSlpDate(processDate);
									chargeSlipMain.setChgSlpTime(time);
									Users user = new Users();
									Integer userId = (Integer) dataMap
											.get("userId");
									user.setId(userId);
									chargeSlipMain.setLastChgBy(user);
									chargeSlipMain.setLastChgDate(processDate);
									chargeSlipMain.setLastChgTime(time);
									chargeSlipMain.setStatus("y");
									chargeSlipMain.setAutoProcessed("y");
									chargeSlipMain.setRoomProcessed("y");
									MasEmployee consultant = new MasEmployee();
									consultant.setId(inpatient.getDoctor()
											.getId());
									chargeSlipMain.setConsultant(consultant);

									hbt.save(chargeSlipMain);

									if (chargeSetupList.size() > 0) {
										for (MasChargeCode chargeSetup : chargeSetupList) {
											int chargeCodeId = chargeSetup
													.getId();
											if (chargeCodeId != 0) {
												BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
												blChargeSlipDetail
														.setHospital(hospital);
												MasChargeCode masChargeCode = new MasChargeCode();
												masChargeCode
														.setId(chargeCodeId);
												blChargeSlipDetail
														.setChargeCode(masChargeCode);

												detailsMap.put("chargeId",
														chargeCodeId);
												detailsMap
														.put("mainChargeId",
																chargeSetup
																		.getMainChargecode()
																		.getId());
												detailsMap
														.put("subChargeId",
																chargeSetup
																		.getSubChargecode()
																		.getId());

												chargeDtMap = getChargeAmountAfterDiscount(detailsMap);

												BigDecimal chargeAmountAfterDis = new BigDecimal(
														0.00);
												BigDecimal discAmt = new BigDecimal(
														0.00);
												BigDecimal stdDeduction = new BigDecimal(
														0.00);
												BigDecimal rate = new BigDecimal(
														0.00);
												BigDecimal chargeAfterSD = new BigDecimal(
														0.00);
												BigDecimal discountPercent = new BigDecimal(
														0.00);

												if (chargeDtMap
														.get("chargeAmountAfterDis") != null) {
													chargeAmountAfterDis = (BigDecimal) chargeDtMap
															.get("chargeAmountAfterDis");
												}
												if (chargeDtMap.get("discAmt") != null) {
													discAmt = (BigDecimal) chargeDtMap
															.get("discAmt");
												}
												if (chargeDtMap
														.get("stdDeduction") != null) {
													stdDeduction = (BigDecimal) chargeDtMap
															.get("stdDeduction");
												}
												if (chargeDtMap.get("rate") != null) {
													rate = (BigDecimal) chargeDtMap
															.get("rate");
												}
												if (chargeDtMap
														.get("chargeAfterSD") != null) {
													chargeAfterSD = (BigDecimal) chargeDtMap
															.get("chargeAfterSD");
												}
												if (map.get("discPercnt") != null) {
													discountPercent = (BigDecimal) map
															.get("discPercnt");
												}
												blChargeSlipDetail
														.setRate(chargeAfterSD);

												if (inpatient.getHin()
														.getRegType() != null
														&& !inpatient.getHin()
																.getRegType()
																.equals("")) {
													if (inpatient.getHin()
															.getRegType()
															.equals("G")) {
														if (stdDeduction
																.compareTo(new BigDecimal(
																		0)) > 0) {
															blChargeSlipDetail
																	.setStdDeductionGen(stdDeduction
																			.multiply(new BigDecimal(
																					1)));
														}
													} else if (inpatient
															.getHin()
															.getRegType()
															.equals("S")) {
														if (stdDeduction
																.compareTo(new BigDecimal(
																		0)) > 0) {
															blChargeSlipDetail
																	.setStdDeductionSpl(stdDeduction
																			.multiply(new BigDecimal(
																					1)));
														}
													}
												}
												blChargeSlipDetail
														.setAmt(chargeAfterSD
																.multiply(new BigDecimal(
																		1)));
												blChargeSlipDetail
														.setQuantity(1);

												if (discountPercent
														.compareTo(new BigDecimal(
																0)) > 0)
													blChargeSlipDetail
															.setDiscountPercent(discountPercent);

												if (discAmt
														.compareTo(new BigDecimal(
																0)) > 0)
													blChargeSlipDetail
															.setDiscountAmt(discAmt
																	.multiply(new BigDecimal(
																			1)));

												if (chargeAmountAfterDis
														.compareTo(new BigDecimal(
																0)) > 0)
													blChargeSlipDetail
															.setNetAmt(chargeAmountAfterDis
																	.multiply(new BigDecimal(
																			1)));

												Users user1 = new Users();
												Integer userId1 = (Integer) dataMap
														.get("userId");
												user1.setId(userId1);

												blChargeSlipDetail
														.setLastChgBy(user1);

												blChargeSlipDetail
														.setLastChgDate(HMSUtil
																.convertStringTypeDateToDateType(date));
												blChargeSlipDetail
														.setLastChgTime(time);
												blChargeSlipDetail
														.setStatus("y");
												blChargeSlipDetail
														.setChargeSlipMain(chargeSlipMain);
												blChargeSlipDetail
														.setRefundableStatus("y");
												MasDepartment department = new MasDepartment();
												department.setId(inpatient
														.getDepartment()
														.getId());
												blChargeSlipDetail
														.setDepartment(department);
												try {
													hbt.save(blChargeSlipDetail);
												} catch (RuntimeException e) {
													e.printStackTrace();
												}

												Patient patientObj = (Patient) session
														.load(Patient.class,
																hinId);
												BigDecimal pastDue = new BigDecimal(
														0);
												BigDecimal newAmt = new BigDecimal(
														0);
												if (patientObj.getPastDue() != null) {
													pastDue = new BigDecimal(
															patientObj
																	.getPastDue());
												}
												newAmt = pastDue
														.add(chargeAfterSD);

												// ""+patientObj.getPastDue()+"==newPastDue==>"+newAmt);
												patientObj.setPastDue(newAmt
														.toString());
												session.update(patientObj);
											}
										}
									}
								}
							}
						}
						// ----------- End of daily process
						// charge----------------------------
						// -----Added by dipali---For delete duplicate room rent
						// record as discussed with narayan sir---

						
						 * List<BlChargeSlipDetail> blChargeSlipDtList = new
						 * ArrayList<BlChargeSlipDetail>(); SimpleDateFormat sdf
						 * = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String
						 * lastProcessdate= sdf.format(lastProcessedDate);
						 * 
						 * String qry1 =
						 * "select v.charge_slip_main_id, v.charge_slip_detail_id ,v.chg_slp_date,v.charge_slip_no,v.hin_id,v.inpatient_id,v.quantity,v.department_id,v.amt,v.chg_slp_amt "
						 * +
						 * " from (select a.charge_slip_main_id, b.charge_slip_detail_id ,a.chg_slp_date,a.charge_slip_no,a.hin_id,a.inpatient_id,b.quantity,b.department_id,b.amt,a.chg_slp_amt "
						 * +
						 * " from bl_charge_slip_main a,bl_charge_slip_detail b"
						 * +
						 * " where a.charge_slip_main_id=b.charge_slip_main_id and lower(a.auto_processed) = 'y' and b.charge_code_id=1052 and b.amt>0 "
						 * + " and a.hin_id=" + hinId + " and a.inpatient_id=" +
						 * inpatientId + " and b.department_id=" +
						 * lastChargeSlipDeptId + " and a.chg_slp_date='" +
						 * (lastProcessdate)+"' " + " ) v " +
						 * " where v.charge_slip_main_id not in  (select top 1 a.charge_slip_main_id from bl_charge_slip_main a ,bl_charge_slip_detail b "
						 * +
						 * " where a.charge_slip_main_id=b.charge_slip_main_id and lower(a.auto_processed) = 'y' and b.charge_code_id=1052 "
						 * + " and a.hin_id= " + hinId + " and a.inpatient_id="
						 * + inpatientId + " and b.department_id=23" +
						 * " and a.chg_slp_date='" + (lastProcessdate)+"' " +
						 * ")"; List
						 * chargeSlipDtList=session.createSQLQuery(qry1).list();
						 * BigDecimal roomAmount=new BigDecimal(0); for(int
						 * jk=0;jk<chargeSlipDtList.size();jk++){ Object[]
						 * object = (Object[]) chargeSlipDtList.get(0);
						 * //chargeSlipMainId = (Integer) object[0];
						 * roomAmount=(BigDecimal)object[9]; Patient patientObj
						 * = (Patient) session.load(Patient.class,hinId);
						 * BigDecimal pastDueAmt = new BigDecimal(0); BigDecimal
						 * newRoomAmt = new BigDecimal(0); if
						 * (patientObj.getPastDue() != null) { pastDueAmt = new
						 * BigDecimal(patientObj.getPastDue()); } newRoomAmt =
						 * pastDueAmt.add(roomAmount);
						 * patientObj.setPastDue(newRoomAmt.toString());
						 * session.update(patientObj); } Connection con =
						 * session.connection(); try { CallableStatement cals =
						 * con.prepareCall("{call DeteteRoomRent(?,?,?,?)}");
						 * cals.setInt(1, hinId); cals.setInt(2, inpatientId);
						 * cals.setInt(3, lastChargeSlipDeptId);
						 * cals.setString(4, lastProcessdate);
						 * 
						 * cals.execute(); } catch (SQLException e) {
						 * e.printStackTrace(); } catch (RuntimeException e) {
						 * e.printStackTrace(); }
						 
					}
					// -------------------- Update last processed date in
					// Hospital parameter----------------------

					HospitalParameters hospitalParameters = new HospitalParameters();
					List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
					hospitalParametersList = (List<HospitalParameters>) hbt
							.loadAll(HospitalParameters.class);
					hospitalParameters = hospitalParametersList.get(0);
					hospitalParameters.setLastProcessedDate(changeDate);
					hbt.update(hospitalParameters);
				}
			} else {
				*//**
				 * If room rent has processed but some of patient is missing for
				 * processing room rent then else part is working Code By Mukesh
				 * Narayan Singh Date 15 July 2011
				 *//*
			}
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} catch (RuntimeException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		
		 * finally { session.close(); }
		 */
		return map;
	}

	@SuppressWarnings("unchecked")
	public Integer getMasChargeTypeId() {
		Integer chargeTypeID = 0;
		List<MasChargeType> searchChargeTypeList = new ArrayList<MasChargeType>();
		searchChargeTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeType as mcc where mcc.ChargeTypeName = 'Room Rent' ");
		chargeTypeID = searchChargeTypeList.get(0).getId();
		return chargeTypeID;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDailyChargeProcessJsp() {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		Date lastProcessedDate = null;
		HospitalParameters hospitalParametersObj = new HospitalParameters();
		List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();
		Criteria c = session.createCriteria(HospitalParameters.class).addOrder(
				Order.asc("Id"));

		c.setFirstResult(0);
		c.setMaxResults(1);
		hospitalParamList = c.list();

		if (hospitalParamList != null && hospitalParamList.size() > 0) {
			hospitalParametersObj = hospitalParamList.get(0);
			if (hospitalParametersObj.getLastProcessedDate() != null) {
				lastProcessedDate = hospitalParametersObj
						.getLastProcessedDate();
				map.put("lastProcessedDate", lastProcessedDate);
			}
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public int getChargeSlipNo(String flag) {
		List<BlParameter> csSeqNoList = new ArrayList<BlParameter>();
		List<BlParameter> BlList = new ArrayList<BlParameter>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();
		int chargeSlipSeqNo = 0;
		int id = 0;
		int seqNo = 0;

		try {
			csSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "CS")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (csSeqNoList.size() > 0) {
			for (BlParameter blParameter : csSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				chargeSlipSeqNo = ++seqNo;
			}

			if (flag.equals("save")) {
				BlList = session.createCriteria(BlParameter.class)
						.add(Restrictions.eq("Id", id)).list();
				if (BlList != null && BlList.size() > 0) {
					BlParameter blParameter = null;
					blParameter = BlList.get(0);
					blParameter.setSeqNo(chargeSlipSeqNo);
					session.merge(blParameter);
				}
			}
		}
		session.flush();
		return chargeSlipSeqNo;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParameterForDispensing() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		String dispensing = null;
		HospitalParameters hospitalParametersObj = new HospitalParameters();
		List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();
		Criteria c = session.createCriteria(HospitalParameters.class).addOrder(
				Order.asc("Id"));

		c.setFirstResult(0);
		c.setMaxResults(1);
		hospitalParamList = c.list();

		if (hospitalParamList != null && hospitalParamList.size() > 0) {
			hospitalParametersObj = hospitalParamList.get(0);
			if (hospitalParametersObj.getDispensingRequired() != null) {
				dispensing = hospitalParametersObj.getDispensingRequired();
				map.put("dispensingRequired", dispensing);
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeDetailsForOTPostAnethisia(
			String chargeCode, int hinId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<OtMasChargeDetails> otMasChargeDetailsList = new ArrayList<OtMasChargeDetails>();
		int otChargeDetailId = 0;
		Session session = (Session) getSession();
		try {
			otChargeDetailId = Integer.parseInt(chargeCode);

			if (otChargeDetailId > 0) {
				chargeCodeList = session.createCriteria(MasChargeCode.class)
						.add(Restrictions.eq("Id", otChargeDetailId)).list();
			}
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode = chargeCodeList.get(0);
			int chargeId = masChargeCode.getId();
			int mainChargeId = masChargeCode.getMainChargecode().getId();
			int subChargeId = masChargeCode.getSubChargecode().getId();

			if (hinId != 0) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", hinId)).list();
			}
			if (patientList.size() > 0) {
				Patient patient = (Patient) patientList.get(0);
				int patientTypeId = 0;
				int companyId = 0;
				String regType = "";
				if (patientList.get(0).getPatientType() != null) {
					patientTypeId = patient.getPatientType().getId();
					detailsMap.put("patientTypeId", patientTypeId);
				}
				if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					detailsMap.put("companyId", companyId);
				}
				if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					detailsMap.put("regType", regType);
				}

				if (patient.getPatientStatus().equals("Out Patient")) {
					detailsMap.put("patientCategory", "OP");
				}
				if (patient.getPatientStatus().equals("In Patient")) {
					detailsMap.put("patientCategory", "IP");
				}

				List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				inpatientList = session
						.createCriteria(Inpatient.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.or(Restrictions.eq("AdStatus", "R"),
								Restrictions.eq("AdStatus", "A"))).list();

				if (inpatientList.size() > 0) {
					Inpatient inpatient = inpatientList.get(0);
					detailsMap.put("roomTypeId", inpatient.getBed().getRoom()
							.getRoomType().getId());
				}
			}
			detailsMap.put("chargeId", chargeId);
			detailsMap.put("mainChargeId", mainChargeId);
			detailsMap.put("subChargeId", subChargeId);
			detailsMap.put("billTypeId", 2);

			map = getChargeAmountAfterDiscount(detailsMap);
			map.put("chargeCodeList", chargeCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public void testSchedule() {
	}

	@Override
	public synchronized int getTokenNoForDepartment(int departmentId) {
		//
		List<Integer> tokenNoList = new ArrayList<Integer>();
		int tokenNo = 0;
		Date date = new Date();

		Session session = (Session) getSession();
		// tokenNoList = getHibernateTemplate().find("select max(v.TokenNo) from
		// Visit v join v.Department as dept where dept.Id="+departmentId+" and
		// v.VisitDate="+date);
		tokenNoList = session
				.createCriteria(Visit.class, "v")
				.add(Restrictions.eq("v.VisitDate", date))
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", departmentId))
				.setProjection(
						Projections.projectionList().add(
								Projections.max("TokenNo"))).list();
		if (tokenNoList.get(0) != null) {
			tokenNo = tokenNoList.get(0);
		}
		//
		return tokenNo;
	}

	public int getVisitNo(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		Session session = getSession();
		int visitNo = 0;
		visitNoList = session.createCriteria(Visit.class)
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		map.put("visitNoList", visitNoList);
		for (Visit v : visitNoList) {
			/* visitNo = v.getVisitNo(); */
		}
		visitNo++;
		return visitNo;
	}

	@Override
	public String getage(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitNoList = new ArrayList<Visit>();
		Session session = getSession();
		String age = "";
		visitNoList = session.createCriteria(Visit.class)
				.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		map.put("visitNoList", visitNoList);
		for (Visit v : visitNoList) {
			age = v.getHin().getAge();
		}
		// visitNo++;
		return age;
	}

	@Override
	public Map<String, Object> submitvisit(Visit v) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(v);
		successfullyAdded = true;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	public Map<String, Object> searchPatientForBillDispensing(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();

		String patientName = "";
		String uhid = "";

		int hospitalTypeId = 0;
		int hospitalId = 0;

		uhid = box.getString("uhid");
		patientName = box.getString("patientName");

		hospitalTypeId = box.getInt("instTypeId");
		hospitalId = box.getInt("hospitalId");

		int sessionHospitalId = box.getInt("sessionHospitalId");
		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> VsitList = new ArrayList<Visit>();
		List<BlOpBillHeader> billList = new ArrayList<BlOpBillHeader>();

		Criteria crit = null;

		if (!uhid.equals("")) {
			crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", uhid));

		}
		if (!patientName.equals("")) {
			crit = crit
					.add(Restrictions.ilike("h.FullName", patientName + "%"));
		}

		patientList = crit.list();

		int hin_id = 0;
		String billNo = "";
		for (Patient patient : patientList) {
			hin_id = patient.getId();
			billNo = String.valueOf(patient.getBillNo());
			System.out.println(hin_id);
		}
		if (hin_id > 0 && billNo != null && !billNo.equals("")) {
			billList = session.createCriteria(BlOpBillHeader.class)
					.add(Restrictions.eq("Hin.Id", hin_id))
					.add(Restrictions.eq("BillNo", billNo)).list();
		}

		if (hin_id > 0) {
			crit = session.createCriteria(Visit.class).add(
					Restrictions.eq("Status", "p").ignoreCase());
			crit = crit.add(Restrictions.eq("Hin.Id", hin_id));
		}

		/*
		 * if(!uhid.equals("")){ crit = crit.add(Restrictions.eq("h", uhid)); }
		 */
		VsitList = crit.list();
		/*
		 * if(hospitalId!=0){ crit = crit.add(Restrictions.eq("Hospital.Id",
		 * hospitalId));
		 * 
		 * }else{ crit = crit.add(Restrictions.eq("Hospital.Id",
		 * sessionHospitalId)); } if(!uhid.equals("")){ crit =
		 * crit.add(Restrictions.eq("h.HinNo", uhid)); }
		 * 
		 * 
		 * crit =
		 * crit.setProjection(Projections.projectionList().add(Projections
		 * .property("Id")).add(Projections.property("h.HinNo"))
		 * .add(Projections
		 * .property("h.FullName")).add(Projections.property("pres.FirstName"
		 * )).add(Projections.property("pres.LastName"))
		 * .add(Projections.property("hosp.HospitalName"))) ; patientList =
		 * crit.list();
		 */
		map.put("billList", billList);
		map.put("VsitList", VsitList);
		return map;

	}

	// searchAdviceSerciving for PaymentServcing "Satish Prasad"
	public Map<String, Object> searchAdviceSerciving(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();

		BlOpBillHeader blOpBillHeader = new BlOpBillHeader();
		List<BlOpBillDetails> bioBillDetails = new ArrayList<BlOpBillDetails>();

		int billId = box.getInt("billId");

		int sessionHospitalId = box.getInt("sessionHospitalId");
		int opBillDetailId = 0;
		if (billId != 0) {
			blOpBillHeader = (BlOpBillHeader) session
					.createCriteria(BlOpBillHeader.class)
					.add(Restrictions.eq("Id", billId)).list().get(0);
			opBillDetailId = blOpBillHeader.getId();
			Criteria c = session.createCriteria(BlOpBillDetails.class);
			c.createAlias("OpBillHeader", "OpBillHeader").add(
					Restrictions.eq("OpBillHeader.Id", opBillDetailId));
			bioBillDetails = c.list();
		}

		/*
		 * int billHeaderId=0; for(BlOpBillHeader bld:blOpBillHeader){
		 * billHeaderId=bld.getId();
		 * 
		 * }
		 */
		// Criteria crit = null;

		/*
		 * if(billHeaderId>0 ){ System.out.println("=======   "+billHeaderId);
		 * crit = session.createCriteria(BlOpBillDetails.class);
		 * crit.createAlias("OpBillHeader",
		 * "OpBillHeader").add(Restrictions.eq("OpBillHeader.Id",
		 * billHeaderId)); blOpDetials = crit.list();
		 * System.out.println("size of the blOpDetials====="
		 * +blOpDetials.size());
		 * 
		 * }
		 * 
		 * if (!uhid.equals("")) { crit =
		 * session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",
		 * uhid)); patientList=crit.list();
		 * System.out.println("patientList"+patientList.size()); }
		 */
		map.put("blOpBillHeader", blOpBillHeader);

		map.put("bioBillDetails", bioBillDetails);
		return map;
	}

	public Map<String, Object> getBillNosByUhid(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Object[]> billList = new ArrayList<Object[]>();

		String uhid = "";

		uhid = box.getString("uhid");

		System.out.println("uhid" + uhid);
		int sessionHospitalId = box.getInt("sessionHospitalId");

		System.out.println("patientList" + patientList.size());

		Criteria crit = null;

		if (!uhid.equals("")) {
			crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", uhid));
			patientList = crit.list();

		}
		int hin_id = 0;
		String billNo = "";
		for (Patient patient : patientList) {
			hin_id = patient.getId();
		}
		if (hin_id > 0) {
			billList = session
					.createCriteria(BlOpBillHeader.class)
					.add(Restrictions.eq("Hin.Id", hin_id))
					.setProjection(
							Projections.projectionList()
									.add(Projections.property("Id"))
									.add(Projections.property("BillNo"))
					// .add(Projections.property("BillAmt"))
					// .add(Projections.property("BillDate"))
					).list();
			System.out.println("size of bill list is ...." + billList.size());
		}

		map.put("billList", billList);
		map.put("patientList", patientList);

		return map;
	}

	/*
	 * showBillDispensingJsp
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showBillDispensingJsp(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		String uhid = box.get("uhid");
		String patientName = box.get("patientName");
		String mobile = box.get("mobile");

		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> VisitList = new ArrayList<Visit>();
		Criteria crit = null;

		crit = session.createCriteria(Visit.class).createAlias("Hin", "h")
				.add(Restrictions.eq("Status", "p").ignoreCase());

		if (!uhid.equals("")) {
			crit = crit.add(Restrictions.eq("h.HinNo", uhid)).add(
					Restrictions.eq("Status", "p").ignoreCase());
		}
		if (!patientName.equals("")) {
			crit = crit.add(Restrictions.eq("h.PFirstName", patientName)).add(
					Restrictions.eq("Status", "p").ignoreCase());
		}
		if (!mobile.equals("")) {
			crit = crit.add(Restrictions.eq("h.MobileNumber", mobile)).add(
					Restrictions.eq("Status", "p").ignoreCase());
		}
		VisitList = crit.list();
		map.put("VisitList", VisitList);
		return map;

	}

	public Map<String, Object> searchAdviceDispensing(Box box) {

		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();

		BlDispensingHeader blDisHeader = new BlDispensingHeader();
		List<BlOpBillDetails> bioBillDetails = new ArrayList<BlOpBillDetails>();

		int billId = box.getInt("billId");
		int sessionHospitalId = box.getInt("sessionHospitalId");
		int billDispId = 0;
		if (billId != 0) {
			blDisHeader = (BlDispensingHeader) session
					.createCriteria(BlDispensingHeader.class)
					.add(Restrictions.eq("Id", billId)).list().get(0);
			billDispId = blDisHeader.getId();
			Criteria c = session.createCriteria(BlOpBillDetails.class);
			c.createAlias("BlDispensingHeader", "BlDispensingHeader").add(
					Restrictions.eq("BlDispensingHeader.Id", billDispId));
			blDisHeader = (BlDispensingHeader) c.list();
		}

		map.put("BlDispensingHeader", blDisHeader);

		map.put("bioBillDetails", bioBillDetails);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForBillDispensing(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<PatientPrescriptionHeader> presHdList = new ArrayList<PatientPrescriptionHeader>();
		List<BlTempOpBillHeader> tempBillList = new ArrayList<BlTempOpBillHeader>();
		List<Object[]> itemWiseList = new ArrayList<Object[]>();
		List<Patient> inpatientList = new ArrayList<Patient>();
		List<MasPatientType> masPTypeList = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeLists = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
		List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		String hinNo = box.getString("uhid");
		String prescriptionNo = "";
		/* hinNo = box.getString(HIN_NO); */
		System.out.println("uhid==============" + hinNo);
		prescriptionNo = box.getString(PRESCRIPTION_NO);
		String tempBillNo = box.getString("tempBillNo");
		Session session = getSession();

		if (!hinNo.equals("")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					.list();
		}

		if (!prescriptionNo.equals("")) {
			presHdList = session
					.createCriteria(PatientPrescriptionHeader.class)
					.add(Restrictions.eq("PrescriptionNo", prescriptionNo))
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo))
					.add(Restrictions.eq("hin.PatientStatus", "Out Patient"))
					.list();
			if (presHdList.size() > 0) {
				PatientPrescriptionHeader preHeader = new PatientPrescriptionHeader();
				patientList.add(preHeader.getHin());
				map.put("presHdList", presHdList);
			}
		}

		if (!tempBillNo.equals("")) {
			tempBillList = session.createCriteria(BlTempOpBillHeader.class)
					.add(Restrictions.eq("TempBillNo", tempBillNo))
					.add(Restrictions.eq("TempBillDate", date))
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.PatientStatus", "Out Patient"))
					.list();
			if (tempBillList.size() > 0) {

				BlTempOpBillHeader tempOpBillHeader = new BlTempOpBillHeader();
				tempOpBillHeader = tempBillList.get(0);
				patientList.add(tempOpBillHeader.getHin());

				map.put("tempBillList", tempBillList);

				itemWiseList = session
						.createCriteria(BlTempBillDispensingDetails.class)
						.createAlias("TempOpBillHeader", "tbh")
						.add(Restrictions.eq("tbh.TempBillNo", tempBillNo))
						.add(Restrictions.eq("TempBillDate", date))
						.createAlias("Item", "i")
						.createAlias("i.AccountGroup", "ag",
								CriteriaSpecification.LEFT_JOIN)
						.createAlias("i.SubAccountGroup", "sag",
								CriteriaSpecification.LEFT_JOIN)
						.createAlias("i.SalesTaxType", "st",
								CriteriaSpecification.LEFT_JOIN)
						.setProjection(
								Projections
										.projectionList()
										.add(Projections.property("i.Id"))
										.add(Projections.property("i.PvmsNo"))
										.add(Projections
												.property("i.Nomenclature"))
										.add(Projections.sum("Qty"))
										.add(Projections.sum("Amount"))
										.add(Projections
												.property("DiscountPercent"))
										.add(Projections.sum("DiscountAmt"))
										.add(Projections
												.sum("ProportionalDisAmt"))
										.add(Projections.sum("NetAmt"))
										.add(Projections.property("ag.Id"))
										.add(Projections.property("sag.Id"))
										.add(Projections.property("st.SaleTax"))
										.add(Projections.groupProperty("i.Id")))
						.list();

				map.put("itemWiseList", itemWiseList);
			}

		}
		if (patientList.size() > 0)
			map.put("patientList", patientList);
		else {
			inpatientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo))
					.add(Restrictions.eq("PatientStatus", "In Patient")).list();

			if (inpatientList.size() > 0) {
				map.put("inpatientList", inpatientList);

			}
		}
		masPTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "F").ignoreCase()).list();
		masPTypeLists = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "S").ignoreCase()).list();
		masPTypeListo = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "O").ignoreCase()).list();
		masCharityList = session.createCriteria(MasCharityType.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		String maxBlNo = "";
		String billType = "OD";
		maxBlNo = generateBillNo(billType, "display",box.getInt(HOSPITAL_ID));
		map.put("masCharityList", masCharityList);
		map.put("masPTypeList", masPTypeList);
		map.put("masPTypeLists", masPTypeLists);
		map.put("masPTypeListo", masPTypeListo);
		map.put("maxBlNo", maxBlNo);

		return map;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getInpatientBilDispensingDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<IpWardConsumptionDetails> ipWardConsumptionDetailList=new
		// ArrayList<IpWardConsumptionDetails>();
		List<Object[]> ipWardConsumptionDetailList = new ArrayList<Object[]>();
		Session session = getSession();

		String hql = "select item.Id,item.PvmsNo,item.Nomenclature,sum(pdetail.Dosage)"
				+ ",sum(pdetail.Dosage*stock.CostPrice),sum(pdetail.Dosage*stock.CostPrice),0.00,0.00,stock.Id,stock.CostPrice "
				+ " from jkt.hms.masters.business.IpWardConsumptionDetails ipconsumption "
				+ " inner join ipconsumption.Consumption consumption"
				+ " inner join consumption.Inpatient inpatient"
				+ " inner join consumption.InpatientPrescriptionDetails pdetail"
				+ " inner join pdetail.Item item"
				+ " inner join ipconsumption.Stock stock"
				+ " where inpatient.Id=:inpatient"
				+ " group by item.Id,stock.Id,stock.CostPrice ";
		Query query = session.createQuery(hql);
		query.setParameter("inpatient", box.getInt(INPATIENT_ID));
		ipWardConsumptionDetailList = query.list();
		System.out.println("ipWardConsumptionDetailList size is == "
				+ ipWardConsumptionDetailList.size());

		/*
		 * ipWardConsumptionDetailList=session.createCriteria(
		 * IpWardConsumptionDetails.class) .add(Restrictions.eq("Inpatient.Id",
		 * box.getInt(INPATIENT_ID))).list();
		 */
		map.put("ipWardConsumptionDetailList", ipWardConsumptionDetailList);

		return map;
	}

	@Override
	public Map<String, Object> searchPatientForAdvanceTransfer(Box box) {
		List<Patient> patients = new ArrayList<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		String hinNo = "";
		String patientName = "";
		String mobileNo = "";
		boolean isAllValueIsNull = false;
		int uhid = 0;
		Session session = getSession();
		if (box.get(HOSPITAL_ID) != null && !"".equals(box.get(HOSPITAL_ID))) {
			hospitalId = box.getInt(HOSPITAL_ID);
		}
		if (box.get("hinNo") != null && !"".equals(box.get("hinNo"))) {
			hinNo = box.get("hinNo");
		}
		if (box.get("patientName") != null
				&& !"".equals(box.get("patientName"))) {
			patientName = box.get("patientName");
		}
		if (box.get("mobileNo") != null && !"".equals(box.get("mobileNo"))) {
			mobileNo = box.get("mobileNo");
		}
		if (box.get("uhid") != null && !"".equals(box.get("uhid"))) {
			uhid = box.getInt("uhid");
		}
		Criteria criteria = session.createCriteria(Patient.class);

		if (!"".equals(hinNo)) {
			criteria = criteria.add(Restrictions.eq("HinNo", hinNo));
			isAllValueIsNull = true;
		}
		if (!"".equals(patientName)) {
			criteria = criteria.add(Restrictions.like("PFirstName",
					patientName + "%").ignoreCase());
			isAllValueIsNull = true;
		}
		if (!"".equals(mobileNo)) {
			criteria = criteria.add(Restrictions.eq("MobileNumber", mobileNo));
			isAllValueIsNull = true;
		}
		if (isAllValueIsNull) {
			patients = criteria.addOrder(Order.asc("HinNo")).list();
		}
		if (uhid != 0) {
			Patient patient = (Patient) session.get(Patient.class, uhid);
			Long familyId = 0l;
			if (patient.getFamily() != null) {
				familyId = Long.parseLong(patient.getFamily().getFamilyId());
				List<Patient> membersPatientListDetail = new ArrayList<Patient>();
				List<PhMemberSurvey> memberSurveys = session
						.createCriteria(PhMemberSurvey.class)
						.add(Restrictions.eq("FamilyId", familyId)).list();
				map.put("memberSurveys", memberSurveys);
				for (PhMemberSurvey memberSurvey : memberSurveys) {
					Patient memberPatient = (Patient) session
							.createCriteria(Patient.class)
							.add(Restrictions.eq("Member.Id",
									memberSurvey.getId())).uniqueResult();
					if (memberPatient != null) {
						membersPatientListDetail.add(memberPatient);
					}

				}
				map.put("membersPatientListDetail", membersPatientListDetail);
			}
			List<MasCharityType> masCharityTypes = session
					.createCriteria(MasCharityType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("masCharityTypes", masCharityTypes);
			map.put("patient", patient);
		}

		map.put("patientList", patients);
		return map;
	}

	@Override
	public Map<String, Object> searchPatientForAdvance(Box box) {
		List<Patient> patientList = new ArrayList<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		String hinNo = "";
		String patientName = "";
		String mobileNo = "";
		boolean isAllValueIsNull = false;
		Session session = getSession();
		if (box.get(HOSPITAL_ID) != null && !"".equals(box.get(HOSPITAL_ID))) {
			hospitalId = box.getInt(HOSPITAL_ID);
		}
		if (box.get("hinNo") != null && !"".equals(box.get("hinNo"))) {
			hinNo = box.get("hinNo");
		}
		if (box.get("patientName") != null
				&& !"".equals(box.get("patientName"))) {
			patientName = box.get("patientName");
		}
		if (box.get("mobileNo") != null && !"".equals(box.get("mobileNo"))) {
			mobileNo = box.get("mobileNo");
		}
		Criteria criteria = session.createCriteria(Patient.class);

		if (!"".equals(hinNo)) {
			criteria = criteria.add(Restrictions.eq("HinNo", hinNo));
			isAllValueIsNull = true;
		}
		if (!"".equals(patientName)) {
			criteria = criteria.add(Restrictions.like("PFirstName",
					patientName + "%").ignoreCase());
			isAllValueIsNull = true;
		}
		if (!"".equals(mobileNo)) {
			criteria = criteria.add(Restrictions.eq("MobileNumber", mobileNo));
			isAllValueIsNull = true;
		}
		if (isAllValueIsNull) {
			patientList = criteria.addOrder(Order.asc("HinNo")).list();
		}
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsForPatientAdvance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<PhMemberSurvey> memberSurveyDetailList = new ArrayList<PhMemberSurvey>();
		Session session = getSession();
		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", box.getString("uhid")))
				// .add(Restrictions.eq("Hospital.Id",box.getInt("hospitalId")))
				.list();
		long familyId = 0;
		if (patientList.size() > 0) {
			Patient patient = patientList.get(0);
			if (patient.getFamily() != null) {
				familyId = Long.parseLong(patient.getFamily().getFamilyId());
				System.out.println("familyId==" + familyId);
				memberSurveyDetailList = session
						.createCriteria(PhMemberSurvey.class)
						.add(Restrictions.eq("FamilyId", familyId)).list();
			}
		}

		map.put("memberSurveyDetailList", memberSurveyDetailList);
		map.put("patientList", patientList);
		return map;
	}

	@Override
	public Map<String, Object> getMemberDetailsForPatientAdvance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMemberSurvey> memberSurveyDetailList = new ArrayList<PhMemberSurvey>();
		Session session = getSession();
		memberSurveyDetailList = session.createCriteria(PhMemberSurvey.class)
				.add(Restrictions.idEq(box.getInt("surveyId"))).list();
		map.put("memberSurveyDetailList", memberSurveyDetailList);
		return map;
	}

	public boolean submitPatientAdvanceFamilyNCahrity(Box box) {
		Session session = getSession();
		Date date = HMSUtil.getCurrentDateAndTimeObject();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		String sdate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		int hospitalId = 0;
		int fromPatientId = 0;
		int toPatientId = 0;
		String transferTo = "";
		String transferAmount = "";
		MasHospital masHospital=new MasHospital();
		Users users = new Users();
		if (box.get(HOSPITAL_ID) != null) {
			hospitalId = box.getInt(HOSPITAL_ID);
			masHospital.setId(hospitalId);
		}
		if (box.get(RequestConstants.USER_ID) != null) {
			users.setId(box.getInt(RequestConstants.USER_ID));
		}
		if (box.get("transferFrom") != null) {
			fromPatientId = box.getInt("transferFrom");
		}
		if (box.get("transferAmount") != null) {
			transferAmount = box.get("transferAmount");
		}
		if (box.get("familyMemberId") != null) {
			String familyMemberId = box.get("familyMemberId");
			if (box.get("transferToMember" + familyMemberId) != null) {
				toPatientId = box.getInt("transferToMember" + familyMemberId);
			}
		}
		if (box.get("transferTo") != null) {
			transferTo = box.get("transferTo");
		}
		boolean flag = false;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			PatientAdvanceTransfer advanceTransfer = new PatientAdvanceTransfer();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Patient fromPatient = (Patient) hbt.get(Patient.class,
					fromPatientId);
			Double NewPastDue = Double.parseDouble(fromPatient.getPastDue())
					- Double.parseDouble(transferAmount);
			fromPatient.setPastDue(NewPastDue.toString());
			fromPatient.setAddEditBy(users);
			fromPatient.setAddEditDate(date);
			fromPatient.setAddEditTime(time);
			hbt.update(fromPatient);
			Patient toPatient = null;
			if ("familyMember".equalsIgnoreCase(transferTo)) {
				toPatient = (Patient) hbt.get(Patient.class, toPatientId);
				Double sumPastDue = 0.00;
				if (toPatient.getPastDue() == null) {
					sumPastDue = new Double("0")
							+ Double.parseDouble(transferAmount);
				} else {
					sumPastDue = Double.parseDouble(toPatient.getPastDue())
							+ Double.parseDouble(transferAmount);
				}

				toPatient.setPastDue(sumPastDue.toString());
				toPatient.setAddEditBy(users);
				toPatient.setAddEditDate(date);
				toPatient.setAddEditTime(time);
				hbt.update(toPatient);
			}

			PatientAdvanceTransfer pAdvanceTransfer = new PatientAdvanceTransfer();
			pAdvanceTransfer.setFromPatient(fromPatient);
			if (toPatient != null) {
				pAdvanceTransfer.setToPatient(toPatient);
			}
			pAdvanceTransfer.setTransferAmount(new BigDecimal(transferAmount));
			pAdvanceTransfer.setTransferTo(transferTo);
			pAdvanceTransfer.setStatus("y");
			pAdvanceTransfer.setLastChgBy(users);
			pAdvanceTransfer.setLastChgDate(date);
			pAdvanceTransfer.setLastChgTime(time);
			pAdvanceTransfer.setHospital(masHospital);
			hbt.save(pAdvanceTransfer);
			hbt.flush();
			hbt.clear();
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			flag = false;
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public Map<String, Object> getSchemeWiseStatisticsJsp() {
		Session session=(Session)getSession();
		List<MasPatientCategory>patientCategoryList=new ArrayList<MasPatientCategory>();
		List<MasScheme>schemeList=new ArrayList<MasScheme>();
		patientCategoryList=session.createCriteria(MasPatientCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		schemeList=session.createCriteria(MasScheme.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("patientCategoryList", patientCategoryList);
		map.put("schemeList", schemeList);
		
		return map;
	}

	@Override
	public int gewtHinId(String hinNo) {
		int hinId=0;
		Session session=(Session)getSession();
		List<Patient>patientList=new ArrayList<Patient>();
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo.trim())).list();
		for(Patient pt:patientList){
			hinId=pt.getId();
		}
		return hinId;
	}

	@Override
	public String generateReceiptNo(String flag) {
		Integer receiptSeqNo = 0;
		List<BlParameter> rcSeqNoList = new ArrayList<BlParameter>();
		Session session = (Session) getSession();
		try {
			rcSeqNoList = session.createCriteria(BlParameter.class).add(
					Restrictions.eq("Prefix", "RC")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		// hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * receiptHeaderList = session.createCriteria(BlReceiptHeader.class)
		 * .list(); String lastRcNo = ""; if (receiptHeaderList.size() > 0) {
		 * for (BlReceiptHeader receiptHeader : receiptHeaderList) { lastRcNo =
		 * receiptHeader.getReceiptNo(); } }
		 */
		int id = 0;
		int seqNo = 0;
		// String criteria = "";
		if (rcSeqNoList.size() > 0) {
			for (BlParameter blParameter : rcSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				receiptSeqNo = ++seqNo;
			}
			// receiptNo = commonSeqNo(receiptSeqNo, criteria, lastRcNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(receiptSeqNo);
				hbt.update(parameterObj);
			}
		}
		String recNo = receiptSeqNo.toString();
		return recNo;
	}

	@Override
	public Map<String, Object> displayOrderNoWithOutResultEntry(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<DgResultEntryHeader>resultEntryHeaderList = new ArrayList<DgResultEntryHeader>();
		List<DgOrderhd>dgOrderhdList = new ArrayList<DgOrderhd>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		/*String time = (String) utilMap.get("currentTime");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);*/
		Session session = (Session) getSession();
		System.out.println("hinId==="+box.getInt("hinId"));
		resultEntryHeaderList = session.createCriteria(DgResultEntryHeader.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo")))
										.add(Restrictions.eq("ResultDate", HMSUtil.convertStringTypeDateToDateType(date))).list();
		if(resultEntryHeaderList.size()==0){
			dgOrderhdList = session.createCriteria(DgOrderhd.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo")))
					.add(Restrictions.eq("OrderDate", HMSUtil.convertStringTypeDateToDateType(date))).list();
		}
		map.put("dgOrderhdList", dgOrderhdList);
		System.out.println("dgOrderhdList==="+dgOrderhdList.size());
		return map;
	}
	@Override
	public Map<String, Object> getPatientName(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<Patient> patientName=new ArrayList<Patient>();
		String hin="";
		if(box.getString("hinNo")!=null&&(!box.getString("hinNo").equals(""))){
		hin=box.getString("hinNo");	
		}
		
		/*String time = (String) utilMap.get("currentTime");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);*/
		Session session = (Session) getSession();
		patientName=session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo",hin)).list();
		
		map.put("patientName", patientName);
		
		return map;
	}
	
}