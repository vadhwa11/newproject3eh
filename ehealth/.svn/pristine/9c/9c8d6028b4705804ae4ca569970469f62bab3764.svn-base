package jkt.hms.billing.dataservice;

import static jkt.hms.util.RequestConstants.ADVANCE_ADJUSTMENT;
import static jkt.hms.util.RequestConstants.ADVANCE_AMOUNT_TYPE;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.AMOUNT_RECEIVED;
import static jkt.hms.util.RequestConstants.AUTHORIZER_ID;
import static jkt.hms.util.RequestConstants.BALANCE_AMOUNT;
import static jkt.hms.util.RequestConstants.BANK_ID;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.BATCH_ID;
import static jkt.hms.util.RequestConstants.BATCH_ITEM_ID;
import static jkt.hms.util.RequestConstants.BILL_AMOUNT;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHARGE_SLIP_NO;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_CODE;
import static jkt.hms.util.RequestConstants.DISCOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_AMOUNT;
import static jkt.hms.util.RequestConstants.DISCOUNT_ON_BILL;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ISSUE_QUANTITY;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.NET_AMOUNT;
import static jkt.hms.util.RequestConstants.OUTSTANDING;
import static jkt.hms.util.RequestConstants.PAID_AMOUNT;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE_ID;
import static jkt.hms.util.RequestConstants.PAYABLE_AMOUNT;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.PROPORTIONAL_DISCOUNT;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.RATE;
import static jkt.hms.util.RequestConstants.ROUND_OF_VALUE;
import static jkt.hms.util.RequestConstants.SERVICE_CHARGE_AMOUNT;
import static jkt.hms.util.RequestConstants.SERVICE_CHARGE_PERCENT;
import static jkt.hms.util.RequestConstants.SETTLEMENT_DATE;
import static jkt.hms.util.RequestConstants.SETTLEMENT_NO;
import static jkt.hms.util.RequestConstants.SETTLEMENT_TIME;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.STANDARD_DEDUCTION;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TOTAL_NET_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.kmscl.util.KmsclDrugData;
import jkt.hms.masters.business.AmbulanceRegister;
import jkt.hms.masters.business.BlAccountType;
import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.BlPackageBill;
import jkt.hms.masters.business.BlPackageHeader;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlPaymentAdviceDetails;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPaywardBooking;
import jkt.hms.masters.business.BlPriority;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.BlRefundDetails;
import jkt.hms.masters.business.BlRefundHeader;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientPrescriptionDetails;
import jkt.hms.masters.business.InpatientPrescriptionHeader;
import jkt.hms.masters.business.IpWardConsumptionDetails;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasCharityType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasRoomType;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MultiDepartmentMapping;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PatientStoreIndentDetails;
import jkt.hms.masters.business.PatientStoreIndentHeader;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.PrinterCofiguration;
import jkt.hms.masters.business.RsbyCardDetails;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIssueT;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.util.LeaveManagementUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BillingDataServiceImpl extends HibernateDaoSupport implements
		BillingDataService {

	OpBillingDataService opBillingDataService = null;

	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(
			OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	/**
	 * --------------------------- Method to get Admission no for billing search
	 * Before Discharge
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Inpatient> getAdNo(String hin, int hospitalId) {
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		try {
			
			adNoList = session.createCriteria(Inpatient.class)
					.add(Restrictions.not(Restrictions.eq("AdStatus", "D")))
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hin))
					.createAlias("Hospital", "H")
					.add(Restrictions.eq("H.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return adNoList;
	}

	@SuppressWarnings("unchecked")
	public List<Inpatient> getAdNoForReport(String hin) {
		List<Inpatient> adNoList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		try {

			adNoList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hin)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return adNoList;
	}

	/**
	 * --------------------------- Method to get patient details for Ip billing
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlFinalBillDetails> finalBlDtList = new ArrayList<BlFinalBillDetails>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();
		List<MasPatientType> masPTypeList = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeLists = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
		List<DgOrderdt> orderDtList = new ArrayList<DgOrderdt>();
		List<AmbulanceRegister>AmbulanceRegisterList=new ArrayList<AmbulanceRegister>();
		String flag1="";
		
		/*List<RsbyCardDetails> rsbyCardDetailList = new ArrayList<RsbyCardDetails>();*/

		String adNo = "";
		String hinNo = "";
		int inpatientId=0;
		adNo = box.getString("ipNO");
		hinNo = box.getString("uhid");
		inpatientId=box.getInt("ipNo");
		if(box.getString("flag1")!=null){
			flag1=(box.getString("flag1"));
		}
		Session session = (Session) getSession();
		Criteria crit = null;
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		
		try {
			finalBlDtList = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.AdNo", adNo)).list();

			if (finalBlDtList.size() == 0) {
				crit = session.createCriteria(Inpatient.class)
						.add(Restrictions.in("AdStatus", new String[]{"A","R"}));

				if (!adNo.equals("")) {
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if (!hinNo.equals("")) {
					crit = crit.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", hinNo));
				}
				patientDetailsList = crit.list();
				if (patientDetailsList.size() > 0) {
					map.put("patientDetailsList", patientDetailsList);
					
						orderHdList = session.createCriteria(DgOrderhd.class)
								.createAlias("Inpatient", "inpatient")
								.add(Restrictions.eq("inpatient.Id", patientDetailsList.get(0).getId())).list();

					if (orderHdList.size() > 0) {
						for (DgOrderhd dgOrderhd : orderHdList) {
							
						
						DgOrderhd orderHd = new DgOrderhd();
						orderHd = dgOrderhd;
						Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
						orderDtSet = orderHd.getDgOrderdts();

						for (DgOrderdt orderDt : orderDtSet) {
							if (orderDt.getPaymentMade().equalsIgnoreCase("n") && (orderDt.getInPkgFlag()==null ||  orderDt.getInPkgFlag().equalsIgnoreCase("n") )) { // edited by Amit Das on 08-03-2016
							
								orderDtList.add(orderDt);
								map.put("orderHdList", orderHdList);
								map.put("orderdtList", orderDtList);
							}
						}

					}
					}
					
					/*// Added By Amit Das
					if(patientDetailsList.get(0).getHin().getRsbyCardNo()!=null && !patientDetailsList.get(0).getHin().getRsbyCardNo().trim().equals("")){
						rsbyCardDetailList = session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("RsbyCardNo",patientDetailsList.get(0).getHin().getRsbyCardNo())).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
					}*/
					
				}
				if(flag1.equalsIgnoreCase("amb")){
					AmbulanceRegisterList=session.createCriteria(AmbulanceRegister.class)
							.createAlias("Inpatient", "Inpatient")
							.add(Restrictions.eq("Inpatient.Id",Integer.parseInt(""+inpatientId))).list();
					map.put("AmbulanceRegisterList", AmbulanceRegisterList);
					map.put("flag1", flag1);
				}
			} else {
				String message = "Final Bill for patient is prepared.";
				map.put("message", message);
			}
			
			
			bankList = session.createCriteria(MasBankMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			employeeList = session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "empcat").add(Restrictions.eq("empcat.EmpCategoryCode", empCategoryCodeForDoctor))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")).add(Projections.property("MiddleName")).add(Projections.property("LastName")))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			masCharityList = session.createCriteria(MasCharityType.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			masPTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "F").ignoreCase()).list();
			masPTypeLists = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "S").ignoreCase()).list();
			masPTypeListo = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Type", "O").ignoreCase()).list();

			map.put("masPTypeList", masPTypeList);
			map.put("masPTypeLists", masPTypeLists);
			map.put("masPTypeListo", masPTypeListo);
			map.put("masCharityList", masCharityList);
			map.put("bankList", bankList);
			map.put("employeeList", employeeList);
			map.put("authorizerList", authorizerList);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * --------------------------- Method to get charge code for auto complete
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
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
			Date currentDate = new Date();

			if (subChargeCodeId != 0) {
				chargeCodeList = session
						.createCriteria(MasChargeCode.class)
						.add(Restrictions.like("ChargeCodeName", str)
								.ignoreCase())
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.createAlias("SubChargecode", "scc")
						.add(Restrictions.eq("scc.Id", subChargeCodeId)).list();

			} else if (mainChargeCodeId != 0) {
				try {
					chargeCodeList = session
							.createCriteria(MasChargeCode.class)
							.add(Restrictions.like("ChargeCodeName", str)
									.ignoreCase())
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.createAlias("MainChargecode", "mcc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.list();

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
				chargeCodeList = session
						.createCriteria(MasChargeCode.class)
						.add(Restrictions.like("ChargeCodeName", str)
								.ignoreCase())
						.add(Restrictions.eq("Status", "y").ignoreCase())
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
	 * --------------------------- Method to get MainChargeCode & SubChargeCode
	 * List
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMainAndSubCharge() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

		Session session = (Session) getSession();
		try {
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
			}
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/**
	 * --------------------------- Method to fill details in grid for Charge
	 * code -----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		Session session = (Session) getSession();
		String chargeName = (String) dataMap.get("chargeName");
		try {
			chargeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeName", chargeName)).list();
			map.put("chargeCodeList", chargeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	/**
	 * --------------------------- Method to submit billing details of a
	 * patient-----------------------------------
	 * 
	 */

	@SuppressWarnings("unchecked")
	public boolean submitChargeSlipDetails(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		int chargeListLength = 0;
		int IdchargeCode = 0;
		boolean chargeFlag = false;
		boolean saved = false;
		int dgOrderhdId = 0; // added by amit das on 03-10-2016

		int hinId = box.getInt(HIN_ID);
		int inpatientDeptID = box.getInt("inpatientDeptID");
		int userId = box.getInt(USER_ID);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		Session session = (Session) getSession();
		Transaction tx = null;
		int ambulanceId=0;
		int schemeId=0;
		String flag1="";
		if(box.getString("flag1")!=null){
			flag1=(String)box.getString("flag1");
		}
		if(box.getInt("AmbulanceRegisterid")!=0){
			ambulanceId=box.getInt("AmbulanceRegisterid");
		}
		List<AmbulanceRegister>ambRegister=new ArrayList<AmbulanceRegister>();
		ambRegister=session.createCriteria(AmbulanceRegister.class).add(Restrictions.eq("Id", ambulanceId)).list();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			chargeListLength = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= chargeListLength; i++) {/*
				IdchargeCode = box.getInt(CHARGE_CODE_ID + i);
				if (IdchargeCode == 1052) {
					chargeFlag = true;
				}
			*/}
     
			// --------------Saving Data into BlChargeSlipMain Table--------
			BigDecimal osAmt = new BigDecimal(0);
			BigDecimal payableAmt = new BigDecimal(box.getInt("balToBePiadId"));

			BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
			Patient patient = new Patient();
			patient.setId(hinId);
			blChargeSlipMain.setHin(patient);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt(INPATIENT_ID));
			blChargeSlipMain.setInpatient(inpatient);
			MasHospital hospital = new MasHospital();

			hospital.setId(box.getInt("hospitalId"));
			blChargeSlipMain.setHospital(hospital);

			blChargeSlipMain.setChargeSlipNo(box.getInt("chargeSlipNo"));
			blChargeSlipMain.setChgSlpAmt(new BigDecimal(box
					.getInt(TOTAL_AMOUNT)));
			
			
			/*if (!box.getString(DISCOUNT_ON_BILL).equals(""))
				blChargeSlipMain.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_ON_BILL)));

			if (!box.getString(DISCOUNT_AMOUNT).equals(""))
				blChargeSlipMain.setDiscountAmt(new BigDecimal(box
						.getString(DISCOUNT_AMOUNT)));*/

			if (!box.getString(TOTAL_NET_AMOUNT).equals(""))
				blChargeSlipMain.setNetAmt(new BigDecimal(box
						.getString(TOTAL_NET_AMOUNT)));

			if (!box.getString(ROUND_OF_VALUE).equals("")) {
				blChargeSlipMain.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (box.getInt(AUTHORIZER_ID) != 0) {
				MasAuthorizer authorizer = new MasAuthorizer();
				authorizer.setId(box.getInt(AUTHORIZER_ID));
				blChargeSlipMain.setAuthorizer(authorizer);
			}
			if (!box.getString("compDiscount").equals("")) {
				blChargeSlipMain.setDiscount(new BigDecimal(box
						.getString("compDiscount")));
			}
			if(box.get("flag").equalsIgnoreCase("P")){
			if (!box.getString("charityTransferId").equals("")) {
				blChargeSlipMain.setCharityRcvd(new BigDecimal(box
						.getString("charityTransferId")));
			}
			if (box.getString("adjusetCreditId")!=null && !box.getString("adjusetCreditId").equals("")) {
				blChargeSlipMain.setAdjustedAmt(new BigDecimal(box
						.getString("adjusetCreditId")));
			}
			blChargeSlipMain.setReceiptAmt(payableAmt);
			osAmt = payableAmt.subtract(new BigDecimal(box.getInt("payableAmt")));
			if(osAmt.compareTo(BigDecimal.ZERO)>0)
			blChargeSlipMain.setOsAmt(osAmt);			
			
			   blChargeSlipMain.setPayStatus("P");
			}
			if(box.get("flag").equalsIgnoreCase("W"))
			{
				if (box.getString("waiveAmt")!=null && !box.getString("waiveAmt").equals("")) {
					blChargeSlipMain.setCharity(new BigDecimal(box
							.getString("waiveAmt")));
				}
				blChargeSlipMain.setPayStatus("W");
			}
			if(box.get("flag").equalsIgnoreCase("PL"))
			{
				if (box.getString("outstadAmt")!=null && !box.getString("outstadAmt").equals("")) {
					blChargeSlipMain.setOsAmt(new BigDecimal(box
							.getString("outstadAmt")));
				}
				blChargeSlipMain.setPayStatus("PL");
			}
			if (box.getInt(PATIENT_TYPE_ID) != 0) {
				MasPatientType patientType = new MasPatientType();
				patientType.setId(box.getInt(PATIENT_TYPE_ID));
				blChargeSlipMain.setPatientType(patientType);
			}
			if (box.getInt("companyId") != 0) {
				MasCompany company = new MasCompany();
				company.setId(box.getInt("companyId"));
				blChargeSlipMain.setCompany(company);
			}
			

			
			blChargeSlipMain.setChgSlpDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setChgSlpTime(time);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			blChargeSlipMain.setLastChgBy(user);
			blChargeSlipMain.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setLastChgTime(time);
			blChargeSlipMain.setStatus("y");
			if (chargeFlag == true) {
				blChargeSlipMain.setAutoProcessed("y");
				blChargeSlipMain.setRoomProcessed("y");
			}
			if (box.getInt(EMPLOYEE_ID) != 0) {
				MasEmployee consultant = new MasEmployee();
				consultant.setId(box.getInt(EMPLOYEE_ID));
				blChargeSlipMain.setConsultant(consultant);
			}
			//added by govind 01-08-2017
			if(box.getInt("schemeList")!=0){
				schemeId=box.getInt("schemeList");
			}
			if(schemeId>0){
				MasScheme scheme=new MasScheme();
				scheme.setId(schemeId);
				blChargeSlipMain.setScheme(scheme);
			}
			//added by govind 01-08-2017 end
			hbt.save(blChargeSlipMain);
			
			

			// -----------------Saving Data into BlChargeSlipDetail Table
			if(box.get("flag").equalsIgnoreCase("P") ||box.get("flag").equalsIgnoreCase("PL") ||box.get("flag").equalsIgnoreCase("W")){
			String registrationType = "";
			if (!box.getString("registrationType").equals(""))
				registrationType = (box.getString("registrationType"));

			for (int i = 1; i <= chargeListLength; i++) {
				int chargeCodeId = box.getInt(CHARGE_CODE_ID + i);
				if (chargeCodeId != 0) {
					BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
					blChargeSlipDetail.setHospital(hospital);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(chargeCodeId);
					blChargeSlipDetail.setChargeCode(masChargeCode);

					BigDecimal rate = new BigDecimal(box.getString(RATE + i));
					blChargeSlipDetail.setRate(rate);

					if (registrationType != null
							&& !registrationType.equals("")) {
						if (registrationType.equals("G")) {
							if (!box.getString(STANDARD_DEDUCTION + i).equals(
									"")) {
								blChargeSlipDetail
										.setStdDeductionGen(new BigDecimal(box
												.getString(STANDARD_DEDUCTION
														+ i)));
							}
						} else if (registrationType.equals("S")) {
							if (!box.getString(STANDARD_DEDUCTION + i).equals(
									"")) {
								blChargeSlipDetail
										.setStdDeductionSpl(new BigDecimal(box
												.getString(STANDARD_DEDUCTION
														+ i)));
							}

						}
					}

					BigDecimal amount = new BigDecimal(
							box.getString(AMOUNT + i));
					blChargeSlipDetail.setAmt(amount);

					blChargeSlipDetail.setQuantity(box.getInt(QUANTITY + i));

					if (!box.getString(DISCOUNT_PERCENTAGE + i).equals(""))
						blChargeSlipDetail.setDiscountPercent(new BigDecimal(
								box.getString(DISCOUNT_PERCENTAGE + i)));

					if (!box.getString(DISCOUNT + i).equals(""))
						blChargeSlipDetail.setDiscountAmt(new BigDecimal(box
								.getString(DISCOUNT + i)));

					if (!box.getString(PROPORTIONAL_DISCOUNT + i).equals(""))
						blChargeSlipDetail
								.setProportionalDiscountAmount(new BigDecimal(
										box.getString(PROPORTIONAL_DISCOUNT + i)));

					if (!box.getString(NET_AMOUNT + i).equals(""))
						blChargeSlipDetail.setNetAmt(new BigDecimal(box
								.getString(NET_AMOUNT + i)));
					Users user1 = new Users();
					user1.setId(box.getInt("userId"));
					blChargeSlipDetail.setLastChgBy(user1);
					blChargeSlipDetail.setLastChgDate(changeDate);
					blChargeSlipDetail.setLastChgTime(time);
					blChargeSlipDetail.setStatus("y");
					if (chargeCodeId == 1052) {/*
						MasDepartment dept = new MasDepartment();
						dept.setId(inpatientDeptID);
						blChargeSlipDetail.setDepartment(dept);
					*/}
					blChargeSlipDetail.setChargeSlipMain(blChargeSlipMain);
					blChargeSlipDetail.setRefundableStatus("y");

					try {
						hbt.save(blChargeSlipDetail);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}
			}
			
			String flag = box.getString("chargeSlip");
			if (!flag.equals("") && box.get("flag").equalsIgnoreCase("P")) {
				BlReceiptHeader receiptHeader = new BlReceiptHeader();
				if (payableAmt.compareTo(new BigDecimal(0)) != 0) {
					BigDecimal remainCId=new BigDecimal(0.00);
					if (!box.getString("remCreditId").equals("") && box.getFloat("remCreditId")>0) {
						remainCId = new BigDecimal(box.getString("remCreditId"));
					}
					patient.setId(box.getInt(HIN_ID));
					receiptHeader.setHin(patient);
					inpatient.setId(box.getInt(INPATIENT_ID));
					receiptHeader.setInpatient(inpatient);
					receiptHeader.setAmount(payableAmt);
					receiptHeader.setRemainingCredit(remainCId);
					receiptHeader.setTotalRcdAmt(payableAmt.add(remainCId));
					receiptHeader.setReceiptNo(box.getString("receiptNo"));
					receiptHeader.setReceiptType("chs");
					receiptHeader.setReceiptDate(changeDate);
					receiptHeader.setReceiptTime(box.getString(CHANGED_TIME));
					receiptHeader.setHospital(hospital);
					receiptHeader.setChangedBy(user);
					receiptHeader.setChargeSlipMain(blChargeSlipMain);
					try {
						hbt.save(receiptHeader);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}

					int payListLength = 0;

					payListLength = box.getInt("hiddenValuePayment");

					if (payListLength > 0) {
						for (int i = 1; i <= payListLength; i++) {
							BlReceiptDetails receiptDetails = new BlReceiptDetails();
							if (!box.getString(PAYMENT_MODE + i).equals("")) {
								receiptDetails.setPaymentMode(box
										.getString(PAYMENT_MODE + i));

								BigDecimal amtReceived = new BigDecimal(
										box.getInt(AMOUNT_RECEIVED + i));
								receiptDetails.setAmount(amtReceived);

								if (!box.getString(CHEQUE_NO + i).equals(""))
									receiptDetails.setChequeNo(box
											.getString(CHEQUE_NO + i));

								if (!box.getString(CHEQUE_DATE + i).equals(""))
									receiptDetails
											.setChequeDate(HMSUtil
													.convertStringTypeDateToDateType(box
															.getString(CHEQUE_DATE
																	+ i)));

								if (box.getInt(BANK_ID + i) != 0) {
									MasBankMaster bankMaster = new MasBankMaster();
									bankMaster.setId(box.getInt(BANK_ID + i));
									receiptDetails.setBank(bankMaster);
								}
								receiptDetails.setReceiptDate(changeDate);
								receiptDetails.setReceiptTime(time);
								receiptDetails.setChangedBy(user);
								receiptDetails.setReceiptHeader(receiptHeader);
								try {
									hbt.save(receiptDetails);
								} catch (DataAccessException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}}}
				
			
				
				

				boolean diag = false;
				for (int i = 1; i <= chargeListLength; i++) {
					if (box.getString(DEPARTMENT_TYPE_CODE + i).equals("RADIO")
							|| box.getString(DEPARTMENT_TYPE_CODE + i).equals(
									"DIAG")) {
						
						if(box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("") || box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("0"))
						{
						diag = true;
						break;
						}
					}
				}
				
				for (int i = 1; i <= chargeListLength; i++) {
					if (box.getString(DEPARTMENT_TYPE_CODE + i).equals("RADIO")
							|| box.getString(DEPARTMENT_TYPE_CODE + i).equals(
									"DIAG")) {
						
						if(box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("") || box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("0"))
						{
						
						}
						else
						{
							DgOrderdt dgOrderdt=(DgOrderdt) hbt.get(DgOrderdt.class, box.getInt(RequestConstants.DG_ORDER_DETAIL_ID + i));
							dgOrderdt.setPaymentMade("y");
							dgOrderdt.setChargeSlip(blChargeSlipMain); // added by amit das on 03-10-2016
							hbt.update(dgOrderdt);
							dgOrderhdId = 	dgOrderdt.getOrderhd().getId(); // added by amit das on 03-10-2016
						}
					}
				}

				DgOrderhd orderhd = new DgOrderhd();
				if (diag == true) {
					orderhd.setHospital(hospital);
					MasDepartment dept = new MasDepartment();
					dept.setId(box.getInt("departmentId"));
					orderhd.setDepartment(dept);
					orderhd.setTestType("Regular");
					orderhd.setOrderStatus("P");
					orderhd.setPatientType("IP");
					orderhd.setOrderDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					orderhd.setOrderTime(box.getString(CHANGED_TIME));
					Users users = new Users();
					users.setId(userId);
					orderhd.setLastChgBy(users);
					orderhd.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHANGED_DATE)));
					orderhd.setLastChgTime(box.getString(CHANGED_TIME));
					orderhd.setOrderNo(box.getString("orderNo"));
					orderhd.setHin(patient);
					orderhd.setInpatient(inpatient);
					orderhd.setBillChargeSlpNo((box.getString("chargeSlipNo")));
					if (box.getInt(EMPLOYEE_ID) != 0) {
						int empId = box.getInt(EMPLOYEE_ID);
						MasEmployee employee = new MasEmployee();
						employee.setId(empId);
						orderhd.setPrescribedBy(employee);
					}
					if (box.getInt(TOTAL_AMOUNT) != 0) {
						orderhd.setNetAmount(new BigDecimal(box
								.getInt(TOTAL_AMOUNT)));
					}
					hbt.save(orderhd);

					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					if (chargeListLength > 0) {
						for (int l = 1; l <= chargeListLength; l++) {
							if(box.getString(RequestConstants.DG_ORDER_DETAIL_ID + l).equals("") || box.getString(RequestConstants.DG_ORDER_DETAIL_ID + l).equals("0"))
							{
							if (box.getString(DEPARTMENT_TYPE_CODE + l).equals(
									"RADIO")) {
								collHeader.setHin(patient);
								MasDepartment department = new MasDepartment();
								department.setId(box.getInt(DEPARTMENT_ID));
								collHeader.setDepartment(department);
								collHeader.setHospital(hospital);
								collHeader.setOrder(orderhd);
								collHeader.setDiagnosisDate(changeDate);
								collHeader.setDiagnosisTime(time);
								collHeader.setOrderStatus("P");
								collHeader.setSampleValidationDate(changeDate);
								collHeader.setSampleValidationTime(time);
								collHeader.setLastChgBy(users);
								collHeader.setLastChgDate(changeDate);
								collHeader.setLastChgTime(time);

								hbt.save(collHeader);
								break;
							}
							}
						}
					}
					MasChargeCode masChargeCode = new MasChargeCode();
					for (int i = 1; i <= chargeListLength; i++) {
						if(box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("") || box.getString(RequestConstants.DG_ORDER_DETAIL_ID + i).equals("0"))
						{
						if (box.getString(DEPARTMENT_TYPE_CODE + i).equals(
								"RADIO")
								|| box.getString(DEPARTMENT_TYPE_CODE + i)
										.equals("DIAG")) {
							int chargeCodeId = box.getInt(CHARGE_CODE_ID + i);
							if (chargeCodeId != 0) {
								DgOrderdt orderdt = new DgOrderdt();

								masChargeCode.setId(chargeCodeId);
								orderdt.setChargeCode(masChargeCode);
								BigDecimal amount = new BigDecimal(
										box.getString(AMOUNT + i));
								orderdt.setAmount(amount);
								orderdt.setOrderQty(box.getInt(QUANTITY + i));
								orderdt.setLastChgBy(users);
								orderdt.setLastChgDate(changeDate);
								orderdt.setLastChgTime(time);
								orderdt.setChargeSlip(blChargeSlipMain);
								orderdt.setOrderhd(orderhd);
								orderdt.setOrderStatus("P");
								// if (payableAmt.compareTo(new BigDecimal(0))
								// != 0) {
								orderdt.setPaymentMade("y");
								// }else{
								// orderdt.setPaymentMade("n");
								// }
								orderdt.setChargeSlip(blChargeSlipMain); // added by amit das on 03-10-2016
								MasMainChargecode mainChargecode = new MasMainChargecode();
								mainChargecode.setId(box
										.getInt(MAIN_CHARGECODE_ID + i));
								orderdt.setMainChargecode(mainChargecode);

								MasSubChargecode subChargecode = new MasSubChargecode();
								subChargecode.setId(box
										.getInt(SUB_CHARGECODE_ID + i));
								orderdt.setSubChargeid(subChargecode);
								try {
									hbt.save(orderdt);
								} catch (RuntimeException e) {
									e.printStackTrace();
								}
							}
						}
						if (box.getString(DEPARTMENT_TYPE_CODE + i).equals(
								"RADIO")) {

							DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
							collDetails.setSampleCollectionHeader(collHeader);
							collDetails.setChargeCode(masChargeCode);
							String diagNo = generateDiagNumber(box
									.getInt(SUB_CHARGECODE_ID + i));
							collDetails.setDiagNo(diagNo);
							collDetails.setCollected("y");
							collDetails.setLastChgBy(users);
							collDetails.setLastChgDate(changeDate);
							collDetails.setLastChgTime(time);
							collDetails.setOrderStatus("P");
							collDetails.setSampleCollDatetime(changeDate);
							MasMainChargecode maincharge = new MasMainChargecode();
							maincharge
									.setId(box.getInt(MAIN_CHARGECODE_ID + i));
							collDetails.setMaincharge(maincharge);
							MasSubChargecode subCharge = new MasSubChargecode();
							subCharge.setId(box.getInt(SUB_CHARGECODE_ID + i));
							collDetails.setSubcharge(subCharge);
							DgMasInvestigation investigation = new DgMasInvestigation();
							investigation.setId(box.getInt(CHARGE_CODE_ID + i));
							collDetails.setInvestigation(investigation);
							collDetails.setSampleCollDatetime(new Date());
							hbt.save(collDetails);

					}
					}
				}
			} else { // else condition is added by amit das on 03-10-2016
				orderhd = (DgOrderhd) session.get(DgOrderhd.class, dgOrderhdId);
				orderhd.setBillChargeSlpNo((box.getString("chargeSlipNo")));
				session.update(orderhd);
			}
			
			BigDecimal pastDueBD = new BigDecimal(0);
			if (hinId != 0) {
				Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
				/*String pastDue = "";
				if (patientObj.getPastDue() != null)
					pastDue = patientObj.getPastDue();
					if (!osAmt.equals(0)) {
						pastDueBD = pastDueBD.add(outstanding);
					}
					if (!avAdvAmtId.equals(0)) {
						pastDueBD = pastDueBD.add(avAdvAmtId);
					}
					if (!remainCId.equals(0)) {
						pastDueBD = pastDueBD.add(remainCId);
					}*/
//				}
				BigDecimal remainCId=new BigDecimal(0.00);
				if (!box.getString("remCreditId").equals("") && box.getFloat("remCreditId")>0) {
					remainCId = new BigDecimal(box.getString("remCreditId"));
				}
				pastDueBD = pastDueBD.add(new BigDecimal(box.getInt("avAdvAmtId")));					
				if (!remainCId.equals(0)) {
					pastDueBD = pastDueBD.add(remainCId);
				}					
				patientObj.setPastDue(pastDueBD.toString());
			hbt.update(patientObj);
			}
			
			
			/*if (!osAmt.equals("0")) {
				Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
				BigDecimal pastDue = new BigDecimal(0);
				BigDecimal newAmt = new BigDecimal(0);
				if (patientObj.getPastDue() != null) {
					pastDue = new BigDecimal(patientObj.getPastDue());
				}
				newAmt = pastDue.add(osAmt);
				patientObj.setPastDue(newAmt.toString());
				hbt.update(patientObj);

			}*/
			for(AmbulanceRegister amb: ambRegister){
				amb.setBillStatus("y");
				hbt.update(amb);
			}
			
			saved = true;
			map.put("success", saved);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close();
		 * 
		 * }
		 * 
		 * }
		 */

		return saved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForAdvance(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<PhMemberSurvey> memberSurveyDetailList = new ArrayList<PhMemberSurvey>();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hinId = 0;
		Session session = null;
		session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientMName") != null) {
			patientMName = (String) mapForDs.get("patientMName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		System.out.println("hinId=="+hinId);
		System.out.println("patientFName=="+patientFName);
		try {
			crit = session.createCriteria(Patient.class);
			if (hinId == 0) {
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("HinNo", hinNo));
				}
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("PFirstName",
							patientFName + "%"));
				}
				if (!patientMName.equals("")) {
					crit = crit.add(Restrictions.like("PMiddleName",
							patientMName + "%"));
				}
				if (!patientLName.equals("")) {
					crit = crit.add(Restrictions.like("PLastName", patientLName
							+ "%"));
				}
			} else if (hinId != 0) {
				crit = crit.add(Restrictions.idEq(hinId));
			}

			patientList = crit.list();
			bankList = session.createCriteria(MasBankMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			//-------------------code by anamika---------------------
			long familyId = 0;
			if(patientList.size()>0){
				Patient patient = patientList.get(0);
				if(patient.getFamily() != null){
					familyId =Long.parseLong(patient.getFamily().getFamilyId());
					System.out.println("familyId=="+familyId);
					memberSurveyDetailList = session.createCriteria(PhMemberSurvey.class)
							.add(Restrictions.eq("FamilyId", familyId)).list();
				}
			}
			
			map.put("memberSurveyDetailList", memberSurveyDetailList);
		} catch (Exception e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 13 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		map.put("bankList", bankList);
		map.put("patientDetailsList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getChargeSlipNo(String flag,int hospitalId) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int chargeSlipSeqNo = 0;
		int id = 0;
		int seqNo = 0;
		List<BlParameter> csSeqNoList = new ArrayList<BlParameter>();
		Session session = (Session) getSession();
		try {
			csSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "CS"))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
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
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(chargeSlipSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
		BlParameter blParameter = new BlParameter();
		seqNo = 1;
		blParameter.setSeqNo(seqNo);
		blParameter.setPrefix("CS");
		blParameter.setCriteria("c");
		// blParameter.setLastChgBy(box.getString("userName"));
		blParameter.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType((String)HMSUtil.getCurrentDateAndTime().get("currentDate")));
		blParameter.setLastChgTime((String)HMSUtil.getCurrentDateAndTime().get("currentTime"));
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		blParameter.setHospital(hospital);
		hbt.save(blParameter);
		}
		hbt.flush();
		return chargeSlipSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateRefundNo(String flag,int hospitalId) {
		//String refundNo = "";
		Integer refundSeqNo = 0;
		List<BlParameter> refundSeqNoList = new ArrayList<BlParameter>();
		List<BlRefundHeader> refList = new ArrayList<BlRefundHeader>();
		List<Integer> maxIdRefundList = new ArrayList<Integer>();
		Map<String, Object> utilMap=new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		try {
			refundSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "RF"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * refList = session.createCriteria(BlRefundHeader.class).list(); String
		 * lastRefundNo = ""; if (refList.size() > 0) { for (BlRefundHeader
		 * refundHeader : refList) { lastRefundNo = refundHeader.getRefundNo();
		 * } }
		 */

		
		
		int id = 0;
		// String criteria = "";
		int seqNo = 0;
		if (refundSeqNoList.size() > 0) {			
				for (BlParameter blParameter : refundSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				refundSeqNo = ++seqNo;
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(refundSeqNo);
				hbt.update(parameterObj);
			}
		}
		else
		{
			BlParameter blParameter = new BlParameter();
			refundSeqNo = 1;
			blParameter.setSeqNo(refundSeqNo);
			blParameter.setPrefix("RF");
			blParameter.setCriteria("c");
			blParameter.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalId);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		}
		hbt.flush();
		String refundNo = refundSeqNo.toString();
		return refundNo;
	/*	maxIdRefundList = session.createCriteria(BlRefundHeader.class)
				.setProjection(Projections.max("Id")).list();
		String lastRefundNo = "";
		if (maxIdRefundList.size() > 0) {
			refList = session.createCriteria(BlRefundHeader.class)
					.add(Restrictions.idEq(maxIdRefundList.get(0))).list();
			if (refList.size() > 0) {
				lastRefundNo = refList.get(0).getRefundNo();
			} else {
				lastRefundNo = "1";
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
		StringTokenizer str = new StringTokenizer(lastRefundNo, "/");

		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (refundSeqNoList.size() > 0) {
			for (BlParameter blParameter : refundSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				refundSeqNo = ++seqNo;
			}

			if (criteria.equalsIgnoreCase("c")) {
				refundNo = refundSeqNo.toString();
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					refundSeqNo = 1;
				}
				refundNo = refundSeqNo.toString().concat("/")
						.concat(currentMonth).concat("/").concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					refundSeqNo = 1;
				}
				refundNo = refundSeqNo.toString().concat("/")
						.concat(currentYear);
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(refundSeqNo);
				hbt.update(parameterObj);
			}
		}
		return refundNo;*/
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitDepositDetails(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		int receiptHeaderId=0;
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");

		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		Session session = null;
		session = (Session) getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			int inpatientId = box.getInt(INPATIENT_ID);
			int hinId = box.getInt(HIN_ID);
			String receiptNo = box.getString("receiptNo");
			String receiptDate = box.getString(CHANGED_DATE);
			String receiptTime = box.getString(CHANGED_TIME);
			String totalAdvAmt = box.getString(TOTAL_AMOUNT);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------------- Receipt
			// Entry-------------------------------------

			BlReceiptHeader receiptHeader = new BlReceiptHeader();
			receiptHeader.setReceiptNo(receiptNo);
			Patient patient = new Patient();
			patient.setId(hinId);
			receiptHeader.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				receiptHeader.setInpatient(inpatient);
			}

			receiptHeader.setReceiptType("adv");
			receiptHeader.setAmount(new BigDecimal(totalAdvAmt));
			receiptHeader.setReceiptDate(HMSUtil
					.convertStringTypeDateToDateType(receiptDate));
			receiptHeader.setReceiptTime(receiptTime);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			receiptHeader.setHospital(hospital);

			Users user = new Users();
			user.setId(box.getInt("userId"));
			receiptHeader.setChangedBy(user);

			hbt.save(receiptHeader);
			receiptHeaderId=receiptHeader.getId();
			int payListLength = 0;

			payListLength = box.getInt("hiddenValuePayment");

			if (payListLength > 0) {
				for (int i = 1; i <= payListLength; i++) {
					BlReceiptDetails receiptDetails = new BlReceiptDetails();
					if (!box.getString(PAYMENT_MODE + i).equals("")) {
						receiptDetails.setPaymentMode(box
								.getString(PAYMENT_MODE + i));
						receiptDetails.setAdvanceAmountType(box
								.getString(ADVANCE_AMOUNT_TYPE + i));

						BigDecimal amtReceived = new BigDecimal(
								box.getInt(AMOUNT_RECEIVED + i));
						receiptDetails.setAmount(amtReceived);

						if (!box.getString(CHEQUE_NO + i).equals(""))
							receiptDetails.setChequeNo(box.getString(CHEQUE_NO
									+ i));

						if (!box.getString(CHEQUE_DATE + i).equals(""))
							receiptDetails.setChequeDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString(CHEQUE_DATE + i)));

						if (box.getInt(BANK_ID + i) != 0) {
							MasBankMaster bankMaster = new MasBankMaster();
							bankMaster.setId(box.getInt(BANK_ID + i));
							receiptDetails.setBank(bankMaster);
						}
						receiptDetails.setReceiptDate(HMSUtil
								.convertStringTypeDateToDateType(receiptDate));
						receiptDetails.setReceiptTime(receiptTime);
						receiptDetails.setChangedBy(user);
						receiptDetails.setReceiptHeader(receiptHeader);
						try {
							hbt.save(receiptDetails);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}

			BigDecimal pastDue = new BigDecimal(0);
			Patient hin = (Patient) hbt.load(Patient.class, hinId);
			if (hin.getPastDue() != null)
				pastDue = new BigDecimal(hin.getPastDue());

			BigDecimal newAmt = new BigDecimal(0);
			newAmt = pastDue.add(new BigDecimal(totalAdvAmt));
			hin.setPastDue(newAmt.toString());
			hbt.update(hin);

			// -------------Accounts Entry-----------------------
			/**
			 * Start This Code is commnetd By Mukesh Narayan SIngh After
			 * discussion with Dharmendra Date 03/03/2011
			 */
			/*
			 * FaVoucherHeader voucherHeader = new FaVoucherHeader();
			 * voucherHeader.setVoucherNo(""); FaMasVoucherType voucherType =
			 * new FaMasVoucherType(); voucherType.setId(2);
			 * voucherHeader.setVoucherType(voucherType);
			 * voucherHeader.setLastChgBy(userName);
			 * voucherHeader.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(receiptDate));
			 * voucherHeader.setLastChgTime(receiptTime);
			 * voucherHeader.setCrBalance(new BigDecimal(totalAdvAmt));
			 * voucherHeader.setDrBalance(new BigDecimal(totalAdvAmt));
			 * voucherHeader.setHospital(hospital);
			 * voucherHeader.setNaration("Being Advance Received.");
			 * voucherHeader.setStatus("y");
			 * voucherHeader.setLastChgBy(userName);
			 * voucherHeader.setVoucherDate(HMSUtil
			 * .convertStringTypeDateToDateType(receiptDate));
			 * voucherHeader.setVoucherTime(receiptTime);
			 * 
			 * hbt.save(voucherHeader);
			 * 
			 * FaMasAccount accountObj = new FaMasAccount(); FaMasSubLed msb =
			 * new FaMasSubLed(); if (payListLength > 0) { for (int k = 1; k <=
			 * payListLength; k++) { if (!box.getString(PAYMENT_MODE +
			 * k).equals("")) { FaVoucherDetails voucherDetails = new
			 * FaVoucherDetails(); BigDecimal amountRecvd = new BigDecimal(0);
			 * 
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital); FaMasAccount acc = new
			 * FaMasAccount(); FaMasSubLed subLed = new FaMasSubLed(); if
			 * (box.getString(PAYMENT_MODE + k).equals("C")) {
			 * voucherDetails.setNaration("Cash Payment"); acc.setId(2);
			 * subLed.setId(4);
			 * 
			 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class, 2); msb
			 * = (FaMasSubLed) hbt.load(FaMasSubLed.class, 4);
			 * 
			 * } else if (box.getString(PAYMENT_MODE + k).equals("Q") ||
			 * box.getString(PAYMENT_MODE + k).equals("R")) { voucherDetails
			 * .setNaration("Credit Card/Cheque Payment"); acc.setId(6);
			 * subLed.setId(5);
			 * 
			 * accountObj = (FaMasAccount) hbt.load( FaMasAccount.class, 6); msb
			 * = (FaMasSubLed) hbt.load(FaMasSubLed.class, 5); }
			 * voucherDetails.setAcc(acc); voucherDetails.setSubLed(subLed);
			 * 
			 * BigDecimal amtRcvd = new BigDecimal(box .getInt(AMOUNT_RECEIVED +
			 * k)); if (amtRcvd.compareTo(new BigDecimal(0)) != 0) {
			 * voucherDetails.setDrBalance(amtRcvd); }
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(receiptDate));
			 * voucherDetails.setLastChgTime(receiptTime);
			 * voucherDetails.setLastChgBy(userName); hbt.save(voucherDetails);
			 * 
			 * BigDecimal drBalanceForAc = new BigDecimal(0); BigDecimal
			 * drBalanceForSbldAc = new BigDecimal(0);
			 * 
			 * if (accountObj.getDrBalance() != null) drBalanceForAc =
			 * accountObj.getDrBalance(); accountObj
			 * .setDrBalance(drBalanceForAc.add(amountRecvd));
			 * hbt.update(accountObj);
			 * 
			 * if (msb.getDrBalance() != null) drBalanceForSbldAc =
			 * msb.getDrBalance();
			 * msb.setDrBalance(drBalanceForSbldAc.add(amountRecvd));
			 * hbt.update(msb); } } } FaVoucherDetails voucherDetails = new
			 * FaVoucherDetails(); FaMasAccount acc = new FaMasAccount();
			 * acc.setId(9); voucherDetails.setAcc(acc); FaMasSubLed subLed =
			 * new FaMasSubLed(); subLed.setId(7);
			 * voucherDetails.setSubLed(subLed);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration("Being Advance Received");
			 * voucherDetails.setCrBalance(new BigDecimal(totalAdvAmt));
			 * voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(receiptDate));
			 * voucherDetails.setLastChgTime(receiptTime);
			 * voucherDetails.setLastChgBy(userName); hbt.save(voucherDetails);
			 * 
			 * FaMasAccount acntObj = (FaMasAccount)
			 * hbt.load(FaMasAccount.class, 9); BigDecimal crBalance = new
			 * BigDecimal(0); if (acntObj.getCrBalance() != null) crBalance =
			 * acntObj.getCrBalance(); acntObj.setCrBalance(crBalance.add(new
			 * BigDecimal(totalAdvAmt))); hbt.update(acntObj);
			 * 
			 * FaMasSubLed sbldObj = (FaMasSubLed) hbt.load(FaMasSubLed.class,
			 * 7); BigDecimal crBalanceForSl = new BigDecimal(0); if
			 * (sbldObj.getCrBalance() != null) crBalanceForSl =
			 * sbldObj.getCrBalance(); sbldObj.setCrBalance(crBalanceForSl
			 * .add(new BigDecimal(totalAdvAmt))); hbt.update(sbldObj);
			 */
			/**
			 * End This Code is commnetd By Mukesh Narayan SIngh After
			 * discussion with Dharmendra Date 03/03/2011
			 */
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		map.put("receiptHeaderId", receiptHeaderId);
		return map;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = null;
		try {
			con = session.connection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("conn", con);
		return map;
	}

	/*public Map<String, Object> getPatientDetailsForFinalBill(String adNo,
			String hin, Integer hin_id) {
		//
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<Object[]> chargeSlipList = new ArrayList<Object[]>();
		List<Object[]> pkgServiceChargeList = new ArrayList<Object[]>(); // added by Amit Das on 09-03-2016 
		List<Object[]> pkgServiceDiscountList = new ArrayList<Object[]>(); // added by Amit Das on 14-03-2016
		List<Object[]> advanceSlipList = new ArrayList<Object[]>();
		List<Object[]> dispenseDetailsList = new ArrayList<Object[]>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<BlPackageBill> packageBillList = new ArrayList<BlPackageBill>();
		List<IpWardConsumptionDetails> ipWardConsumptionDetailList = new ArrayList<IpWardConsumptionDetails>();

		List<Object[]> paidAmtList = new ArrayList<Object[]>();
		List<BigDecimal> servAdvList = new ArrayList<BigDecimal>();
		List<BigDecimal> dispAdvList = new ArrayList<BigDecimal>();
		List<Object[]> adviceDtList = new ArrayList<Object[]>();
		List<Object[]> adviceDispDtList = new ArrayList<Object[]>();

		Session session = (Session) getSession();
		int inpatientId = 0;
		Criteria crit = null;
		BlChargeSlipMain blChargeSlipmain=null;
		try {
			crit = session.createCriteria(Inpatient.class).add(
					Restrictions.eq("AdNo", adNo));
			crit = crit.createAlias("Hin", "p").add(
					Restrictions.eq("p.Id", hin_id));
			patientDetailsList = crit.list();
			String adStatus = "";
			if (patientDetailsList.size() > 0) {
				inpatientId = patientDetailsList.get(0).getId();
				adStatus = patientDetailsList.get(0).getAdStatus();
				map.put("patientDetailsList", patientDetailsList);
			}

			if (inpatientId != 0) {
				chargeSlipList = getHibernateTemplate()
						.find("select mcc.Id,mcc.MainChargecodeName,sum(csd.Quantity), sum(csd.NetAmt),mcc.MainChargecodeCode,csd.ChargeSlipMain.Id from jkt.hms.masters.business.BlChargeSlipDetail as csd join csd.ChargeSlipMain as csm join csd.ChargeCode as cc join cc.MainChargecode as mcc where csm.Inpatient='"
								+ inpatientId
								+ "' and (csd.InPkgFlag='n' or csd.InPkgFlag is null) and csd.Status='y' and csm.PackageBill is null group by mcc.Id,mcc.MainChargecodeName,mcc.MainChargecodeCode,csd.ChargeSlipMain.Id");

				// Query Change by Amit Das on 09-03-2016
				
				String qury=" select msc.charge,msc.charge_code_name from dg_orderdt dt "+ 
" left outer join dg_orderhd hd on hd.orderhd_id =dt.orderhd_id "+
" left outer join mas_charge_code msc on msc.charge_code_id =dt.charge_code_id "+
" where inpatient_id="+inpatientId+" and payment_made='n'";
				
				List<Object[]>unbilledChargeList=new ArrayList<Object[]>();
				unbilledChargeList=session.createSQLQuery(qury).list();
				
				
				//added by Amit Das on 09-03-2016 
				pkgServiceChargeList = getHibernateTemplate()
						.find("select mcc.Id,mcc.MainChargecodeName,sum(csd.Quantity), sum(csd.NetAmt),mcc.MainChargecodeCode,csd.ChargeSlipMain.Id, csd.ChargeSlipMain.NetAmt "
								+ "from jkt.hms.masters.business.BlChargeSlipDetail as csd "
								+ "join csd.ChargeSlipMain as csm join csd.ChargeCode as cc join cc.MainChargecode as mcc"
								+ " where csm.Inpatient='"
								+ inpatientId
								+ "' and csd.InPkgFlag='y' and csd.Status='y' and csm.PackageBill is null group by mcc.Id,mcc.MainChargecodeName,mcc.MainChargecodeCode,csd.ChargeSlipMain.Id,csd.ChargeSlipMain.NetAmt");
				 
				pkgServiceChargeList = getHibernateTemplate()
						.find("select sum(csm.NetAmt)"
								+ "from jkt.hms.masters.business.BlChargeSlipMain as csm "
								+ " where csm.Inpatient='"
								+ inpatientId
								+ "' and csm.Package.id > 0 and csm.Status='y'");
				
				pkgServiceDiscountList = getHibernateTemplate()
						.find("select sum(csd.NetAmt) from jkt.hms.masters.business.BlChargeSlipDetail as csd join csd.ChargeSlipMain as csm join csd.ChargeCode as cc join cc.MainChargecode as mcc where csm.Inpatient='"
								+ inpatientId
								+ "' and csd.InPkgFlag='y' and csd.Status='y' and csm.PackageBill is null");

				
				
				if (chargeSlipList.size() > 0) {
					int blChargeSlipMainId=0;
				
					for(Object[] obj : chargeSlipList){
						 blChargeSlipMainId=(Integer) obj[5];
					}
					blChargeSlipmain=(BlChargeSlipMain) session.load(BlChargeSlipMain.class, blChargeSlipMainId);
					map.put("chargeSlipList", chargeSlipList);
				}
				
				if (pkgServiceChargeList.size() > 0) {
					
					map.put("pkgServiceChargeList", pkgServiceChargeList);
				}

				if (pkgServiceDiscountList.size() > 0) {
					
					map.put("pkgServiceDiscountList", pkgServiceDiscountList);
				}
				
				
				advanceSlipList = getHibernateTemplate()
						.find("select bd.ReceiptDate, bd.Amount, bd.PaymentMode from jkt.hms.masters.business.BlReceiptHeader as bh left join bh.BlReceiptDetails as bd where bh.ReceiptType = 'adv' and bh.Hin.Id = '"
								+ hin_id
								+ "' and bh.Inpatient.Id = '"
								+ inpatientId + "'");

				if (advanceSlipList.size() > 0) {
					map.put("advanceSlipList", advanceSlipList);
				}

				String qryForDispense = "SELECT msi.item_id,msi.nomenclature, sum(dd.qty) ,sum(dd.net_amt)"
						+ " FROM bl_dispensing_header dh left join bl_dispensing_details dd on dh.dispensing_header_id = dd.dispensing_header_id"
						+ " left join mas_store_item msi on dd.item_id = msi.item_id where dh.inpatient_id = "
						+ inpatientId
						+ " and dh.package_bill_id is null and dh.status = 'y' group by msi.item_id,msi.nomenclature";

				// dispenseDetailsList =
				// session.createSQLQuery(qryForDispense).list();
				dispenseDetailsList = getHibernateTemplate()
						.find("select msi.Id,msi.Nomenclature, sum(dd.Qty) ,sum(dd.NetAmt) "
								+ " from jkt.hms.masters.business.BlDispensingDetails as dd join dd.DispensingHeader as dh join dd.Item as msi "
								+ "where dh.Inpatient='"
								+ inpatientId
								+ "' and dh.PackageBill is null and dh.Status='y' "
								+ "group by msi.Id,msi.Nomenclature");
				System.out.println("dispenseDetailsList====222====="
						+ dispenseDetailsList.size());
				if (dispenseDetailsList.size() > 0) {
					map.put("dispenseDetailsList", dispenseDetailsList);
				}
				System.out.println("dispenseDetailsList====111====="
						+ dispenseDetailsList.size());
				packageBillList = session.createCriteria(BlPackageBill.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId)).list();

				String[] resType = { "chs", "bld", "pkb" };

				paidAmtList = session
						.createCriteria(BlReceiptHeader.class)
						.add(Restrictions.in("ReceiptType", resType))
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections.sum("TotalRcdAmt"))
										.add(Projections
												.property("ReceiptType"))
										.add(Projections
												.groupProperty("ReceiptType")))
						.list();

				servAdvList = session
						.createCriteria(BlPaymentAdviceHeader.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.setProjection(
								Projections.projectionList().add(
										Projections.sum("TotalAdviceAmt")))
						.list();

				dispAdvList = session
						.createCriteria(BlPymntAdviceDispHeader.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.setProjection(
								Projections.projectionList().add(
										Projections.sum("TotalAdviceAmt")))
						.list();

				authorizerList = session.createCriteria(MasAuthorizer.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();

				String qryForServAdv = "SELECT mcc.main_chargecode_id,mcc.main_chargecode_name,sum(pad.advice_qty) ,sum(pad.advice_amt),sum(pad.advice_charity_amt)"
						+ " FROM bl_payment_advice_details pad left join bl_payment_advice_header pah on pad.payment_advice_header_id = pah.payment_advice_header_id"
						+ " left join mas_charge_code cc on pad.charge_id=cc.charge_code_id "
						+ " left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id"
						+ " where pah.inpatient_id = '"
						+ inpatientId
						+ "' group by mcc.main_chargecode_code,mcc.main_chargecode_id,mcc.main_chargecode_name";

				adviceDtList = session.createSQLQuery(qryForServAdv).list();
				if (adviceDtList.size() > 0) {
					map.put("adviceDtList", adviceDtList);
				}

				String qryForDispAdv = "SELECT msi.item_id,msi.nomenclature, sum(pad.advice_qty) ,sum(pad.advice_amt),sum(pad.advice_charity_amt)"
						+ " FROM bl_pymnt_advice_disp_details pad left join bl_pymnt_advice_disp_header pah on pad.pymnt_advice_disp_header_id = pah.pymnt_advice_disp_header_id"
						+ " left join mas_store_item msi on pad.item_id = msi.item_id where pah.inpatient_id = '"
						+ inpatientId
						+ "' group by msi.item_id,msi.nomenclature";

				adviceDispDtList = session.createSQLQuery(qryForDispAdv).list();
				if (adviceDispDtList.size() > 0) {
					map.put("adviceDispDtList", adviceDispDtList);
				}

				if (packageBillList.size() > 0) {
					map.put("packageBillList", packageBillList);
				}
				if (paidAmtList.size() > 0) {
					map.put("paidAmtList", paidAmtList);
				}
				BigDecimal totalAdvAmt = new BigDecimal(0);
				BigDecimal servAdvAmt = new BigDecimal(0);
				BigDecimal dispAdvAmt = new BigDecimal(0);

				if (servAdvList.size() > 0) {
					if (servAdvList.get(0) != null)
						servAdvAmt = (BigDecimal) servAdvList.get(0);
				}
				if (dispAdvList.size() > 0) {
					if (dispAdvList.get(0) != null)
						dispAdvAmt = (BigDecimal) dispAdvList.get(0);

				}
				totalAdvAmt = servAdvAmt.add(dispAdvAmt);

				String queryForTotalRoomCharge = "select sum(amt) "
						+ " from bl_charge_slip_detail dtl "
						+ " left outer join  bl_charge_slip_main main   on main.charge_slip_main_id=dtl.charge_slip_main_id "
						+ "  where main.inpatient_id=" + inpatientId
						+ " and charge_code_id=1052";

				ipWardConsumptionDetailList=session.createCriteria(IpWardConsumptionDetails.class)
						.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
				//
				List<BigDecimal> aList = new ArrayList<BigDecimal>();
				aList = session.createSQLQuery(queryForTotalRoomCharge).list();
				BigDecimal b = new BigDecimal(0);
				for (BigDecimal a1 : aList) {
					b = a1;
				}

				map.put("roomRentTotal", b);
				//
				map.put("totalAdvAmt", totalAdvAmt);
				map.put("adStatus", adStatus);
				map.put("authorizerList", authorizerList);
				map.put("ipWardConsumptionDetailList", ipWardConsumptionDetailList);
				map.put("blChargeSlipmain", blChargeSlipmain);
				map.put("unbilledChargeList",unbilledChargeList);
				
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}// finally{
		*//**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 *//*
		
		 * if(session!=null){ session.close(); } }
		 
		return map;
	}
*/
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForFinalBill(String adNo,String hin, Integer hin_id, Integer hospitalId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlFinalBillDetails> finalBlDtList = new ArrayList<BlFinalBillDetails>();
		List<Inpatient> finalBillDischarge = new ArrayList<Inpatient>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<Object[]> chargeSlipList = new ArrayList<Object[]>();
		List<Object[]> receiptHeaderList = new ArrayList<Object[]>();
		List<Object[]> dispenseDetailsList = new ArrayList<Object[]>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<BlPackageBill> packageBillList = new ArrayList<BlPackageBill>();
		List<BlChargeSlipMain> blchargeSetupList = new ArrayList<BlChargeSlipMain>();
		List<BlChargeSlipDetail> blchargeslipDetailList = new ArrayList<BlChargeSlipDetail>();

		List<Object[]> paidAmtList = new ArrayList<Object[]>();
		List<BigDecimal> servAdvList = new ArrayList<BigDecimal>();
		List<BigDecimal> dispAdvList = new ArrayList<BigDecimal>();
		List<Object[]> adviceDtList = new ArrayList<Object[]>();
		List<Object[]> adviceDispDtList = new ArrayList<Object[]>();

		HospitalParameters hospitalParametersObj = new HospitalParameters();
		List<HospitalParameters> hospitalParamList = new ArrayList<HospitalParameters>();

		Session session = (Session) getSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		int inpatientId = 0;
		int inpatientDeptId = 0;
		Date disDate = null;
		String disTime = null;
		Date addmDate = null;
		String addmTime = null;
		Criteria crit = null;
		Criteria criteria = null;
		Criteria Billcrit = null;
		Date lastProcessedDate = null;
		try
		{
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			Billcrit = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo));
			if (!hin.equals("")){
				Billcrit = Billcrit.createAlias("Hin", "p").add(Restrictions.eq("p.Id", hin_id));
			}
			finalBillDischarge = Billcrit.list();
			if (finalBillDischarge.size() > 0)
			{
				disDate = finalBillDischarge.get(0).getDischargeDate();
				disTime = finalBillDischarge.get(0).getDischargeTime();
				inpatientDeptId = finalBillDischarge.get(0).getDepartment().getId();
				
				
				if(disDate != null && disTime != null)
				{
					Criteria c = session.createCriteria(HospitalParameters.class).addOrder(Order.asc("Id"));
					c.setFirstResult(0);
					c.setMaxResults(1);
					hospitalParamList = c.list();

					if (hospitalParamList != null && hospitalParamList.size() > 0)
					{
						hospitalParametersObj = hospitalParamList.get(0);
						if( hospitalParametersObj.getLastProcessedDate() != null)
						{
							lastProcessedDate = hospitalParametersObj.getLastProcessedDate();
						}
					}

					addmDate = finalBillDischarge.get(0).getDateOfAddmission();
					addmTime = finalBillDischarge.get(0).getTimeOfAddmission();
					Integer hinId = finalBillDischarge.get(0).getHin().getId();
					Integer inpatientID = finalBillDischarge.get(0).getId();

					Map<String, Object> dataMap = new HashMap<String, Object>();
					dataMap.put("lastProcessedDate", disDate);
					dataMap.put("userId", 1);
					dataMap.put("session",session);
					dataMap.put("userName", "admin");
					dataMap.put("hospitalId", hospitalId);  // added by amit das on 07-07-2017
					Integer lastChargeSlipDeptId = 0;
					System.out.println("addmDate==="+addmDate);
					System.out.println("disDate==="+disDate);
					System.out.println("addmTime==="+addmTime);
					System.out.println("disTime==="+disTime);
					if (addmDate.equals(disDate))
					{
						
						long diffMinutes = 0;
						Calendar cal1 = Calendar.getInstance();
				        Calendar cal2 = Calendar.getInstance();
				        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				        Date Adddate = null;
				        Date Disdate = null;
				        try
				        {
							Adddate = sdf.parse(addmDate+" "+addmTime+":"+00);
							Disdate = sdf.parse(disDate+" "+disTime+":"+00);

							cal1.setTime(Adddate);
						    cal2.setTime(Disdate);

						    long milis1 = cal1.getTimeInMillis();
					        long milis2 = cal2.getTimeInMillis();
					        long diff = milis2 - milis1;
					        diffMinutes = diff / (60 * 1000);
					        
						}
						catch (ParseException e)
						{
							e.printStackTrace();
						}

						if(diffMinutes <= 120)
						{
							blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
							.createAlias("Hin", "hn")
							.createAlias("Inpatient", "Inp")
							.add(Restrictions.eq("hn.Id",hinId))
							.add(Restrictions.eq("Inp.Id", inpatientID))
							.add(Restrictions.eq("RoomProcessed", "y"))
							.add(Restrictions.eq("ChgSlpDate", new Date()))
							.addOrder(Order.desc("Id"))
							.setMaxResults(1)
							.list();

							if (blchargeSetupList.size() > 0)
							{
								Integer Id = blchargeSetupList.get(0).getId();
								List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

								chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
								.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

								if (chargeSlipDetail.size() > 0)
								{
									lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
								}

								if(lastChargeSlipDeptId == inpatientDeptId)
								{
								}
								else
								{
									singlePateintRoomRentCalculate(dataMap,hinId);
								}
							}
							else
							{
								singlePateintRoomRentCalculate(dataMap,hinId);
							}
						}
						else if(diffMinutes >= 121)
						{
							
							
							// Patient admission date equal to discharge date and
							// has a longer stay for more than 2 hours but
							// he will be discharged on the same day before 12AM midnight so
							// we have process 1 day room rent.
							Date schedulerdate = null;
							Date AddmissionDateTym = null;
							Calendar old_addTime = Calendar.getInstance();
							Calendar now = Calendar.getInstance();
							try
							{
								AddmissionDateTym = sdf.parse(addmDate+" "+addmTime+":"+00);
								old_addTime.setTime(AddmissionDateTym);

								schedulerdate = sdf.parse(lastProcessedDate+" "+"12:01:00");
								now.setTime(schedulerdate);
							}
							catch (ParseException e){
								e.printStackTrace();
							}
							if(old_addTime.before(now))
							{
							}
							else
							{
								
								blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
								.createAlias("Hin", "hn")
								.createAlias("Inpatient", "Inp")
								.add(Restrictions.eq("hn.Id",hinId))
								.add(Restrictions.eq("Inp.Id", inpatientID))
								.add(Restrictions.eq("RoomProcessed", "y"))
								.add(Restrictions.eq("ChgSlpDate", new Date()))
								.addOrder(Order.desc("Id"))
								.setMaxResults(1)
								.list();
								
								if (blchargeSetupList.size() > 0)
								{
									Integer Id = blchargeSetupList.get(0).getId();
									List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

									chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
									.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

									if (chargeSlipDetail.size() > 0)
									{
										lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
									}
									
									if(lastChargeSlipDeptId == inpatientDeptId)
									{
									}
									else
									{
										singlePateintRoomRentCalculate(dataMap,hinId);
									}
								}
								else
								{
									singlePateintRoomRentCalculate(dataMap,hinId);
								}
							}
						}
					}
					else  // admission date not equal to discharge date.
					{
						if(lastProcessedDate.equals(disDate))
						{
							
							
							// take the time difference from 12pm to discharge date and time, if
							// difference is less than or equal 120mins then only 1 day room rent
							// should be charged. we need to undo the current day rent
							// charged because the scheduler has already processed 2nd day room rent
							// and we have allowed 2hrs grace period.

							long diffMinutesForDischarge = 0;
							Calendar cal3 = Calendar.getInstance();
					        Calendar cal4 = Calendar.getInstance();
					        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					        try
					        {
								Date lastProcessdate = sdf.parse(lastProcessedDate+" "+"12:01:00");
								Date Disdate = sdf.parse(disDate+" "+disTime);

								cal3.setTime(lastProcessdate);
							    cal4.setTime(Disdate);

							    long milis1 = cal3.getTimeInMillis();
						        long milis2 = cal4.getTimeInMillis();
						        long diff = milis2 - milis1;
						        diffMinutesForDischarge = diff / (60 * 1000);
							}
							catch (ParseException e)
							{
								e.printStackTrace();
							}

							if(diffMinutesForDischarge <= 120)
							{
								blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
								.createAlias("Hin", "hn")
								.createAlias("Inpatient", "Inp")
								.add(Restrictions.eq("hn.Id",hinId))
								.add(Restrictions.eq("Inp.Id", inpatientID))
								.add(Restrictions.eq("RoomProcessed", "y"))
								.add(Restrictions.eq("ChgSlpDate", new Date()))
								.addOrder(Order.desc("Id"))
								.setMaxResults(1)
								.list();

								if (blchargeSetupList.size() > 0)
								{
									Integer Id = blchargeSetupList.get(0).getId();
									List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

									chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
									.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

									if (chargeSlipDetail.size() > 0)
									{
										lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
									}

									if(lastChargeSlipDeptId == inpatientDeptId)
									{

										BigDecimal RoomNetAmount = blchargeSetupList.get(0).getChgSlpAmt();
										BigDecimal totalNetAmount = new BigDecimal(0);

										BlChargeSlipMain master = (BlChargeSlipMain) getHibernateTemplate().get(BlChargeSlipMain.class, Id);
										master.setChgSlpAmt(totalNetAmount);
										master.setOsAmt(totalNetAmount);
										master.setNetAmt(totalNetAmount);
										master.setDiscountAmt(null);
										master.setDiscountPercent(null);
										master.setDiscount(null);
										hbt.update(master);

										blchargeslipDetailList = session.createCriteria(BlChargeSlipDetail.class)
										.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

										if (blchargeslipDetailList.size() > 0)
										{
											Integer detailId = blchargeslipDetailList.get(0).getId();
											BlChargeSlipDetail Detailmaster = (BlChargeSlipDetail) getHibernateTemplate().get(BlChargeSlipDetail.class, detailId);
											Detailmaster.setAmt(totalNetAmount);
											Detailmaster.setNetAmt(totalNetAmount);
											Detailmaster.setRate(totalNetAmount);
											Detailmaster.setDiscountPercent(null);
											Detailmaster.setStdDeductionGen(null);
											Detailmaster.setStdDeductionSpl(null);
											Detailmaster.setDiscountAmt(null);
											hbt.update(Detailmaster);
										}

										Patient patientObj = (Patient) getHibernateTemplate().get(Patient.class, hinId);
										BigDecimal pastDue = new BigDecimal(0);
										BigDecimal newAmt = new BigDecimal(0);
										if (patientObj.getPastDue() != null) {
											pastDue = new BigDecimal(patientObj.getPastDue());
										}
										newAmt = pastDue.subtract(RoomNetAmount);
										patientObj.setPastDue(newAmt.toString());
										hbt.update(patientObj);
									}
									else
									{
										singlePateintRoomRentCalculate(dataMap,hinId);
									}
								}
								else
								{
									singlePateintRoomRentCalculate(dataMap,hinId);
								}
							}
							else if(diffMinutesForDischarge >= 121)
							{
								blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
								.createAlias("Hin", "hn")
								.createAlias("Inpatient", "Inp")
								.add(Restrictions.eq("hn.Id",hinId))
								.add(Restrictions.eq("Inp.Id", inpatientID))
								.add(Restrictions.eq("RoomProcessed", "y"))
								.add(Restrictions.eq("ChgSlpDate", new Date()))
								.addOrder(Order.desc("Id"))
								.setMaxResults(1)
								.list();

								if (blchargeSetupList.size() > 0)
								{
									Integer Id = blchargeSetupList.get(0).getId();
									List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

									chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
									.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

									if (chargeSlipDetail.size() > 0)
									{
										lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
									}

									if(lastChargeSlipDeptId == inpatientDeptId)
									{
									}
									else
									{
										singlePateintRoomRentCalculate(dataMap,hinId);
									}
								}
								else
								{
									singlePateintRoomRentCalculate(dataMap,hinId);
								}
							}
						}
						else if(lastProcessedDate.before(disDate))
						{
							
							
							blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
							.createAlias("Hin", "hn")
							.createAlias("Inpatient", "Inp")
							.add(Restrictions.eq("hn.Id",hinId))
							.add(Restrictions.eq("Inp.Id", inpatientID))
							.add(Restrictions.eq("RoomProcessed", "y"))
							.add(Restrictions.eq("ChgSlpDate", new Date()))
							.addOrder(Order.desc("Id"))
							.setMaxResults(1)
							.list();

							if (blchargeSetupList.size() > 0)
							{
								Integer Id = blchargeSetupList.get(0).getId();
								List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

								chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
								.add(Restrictions.eq("ChargeSlipMain.Id", Id)).list();

								if (chargeSlipDetail.size() > 0)
								{
									lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
								}

								if(lastChargeSlipDeptId == inpatientDeptId)
								{
								}
								else
								{
									// we have to process 1 day room rent.
									singlePateintRoomRentCalculate(dataMap,hinId);
								}
							}
							else
							{
								singlePateintRoomRentCalculate(dataMap,hinId);
							}
						}
					}

					criteria = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientID));
					if (!hin.equals(""))
					{
						criteria = criteria.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hin));
					}

					finalBlDtList = criteria.list();

					if (finalBlDtList.size() == 0) {
						crit = session.createCriteria(Inpatient.class).add(
								Restrictions.eq("AdNo", adNo));
						if (!hin.equals("")) {
							crit = crit.createAlias("Hin", "p").add(
									Restrictions.eq("p.HinNo", hin));
						}
						patientDetailsList = crit.list();

						if (patientDetailsList.size() > 0) {
							inpatientId = patientDetailsList.get(0).getId();
							map.put("patientDetailsList", patientDetailsList);
						}
						if (inpatientId != 0) {
							List<BlPaywardBooking> paywardBookingList = new ArrayList<BlPaywardBooking>();
							paywardBookingList = session.createCriteria(BlPaywardBooking.class).add(Restrictions.eq("Inpatient.Id", inpatientID)).list();
							int bookingId = 0;
						if(paywardBookingList.size()>0){
							for(BlPaywardBooking blPaywardBooking : paywardBookingList){
								bookingId = blPaywardBooking.getId(); 
							
						
							receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.eq("ReceiptType", "adv"))
							.createAlias("Inpatient", "ip",CriteriaSpecification.LEFT_JOIN)
							.add(Restrictions.or(Restrictions.eq("ip.Id", inpatientId), Restrictions.eq("Booking.Id", bookingId)))
							.setProjection(Projections.projectionList().add(Projections.sum("Amount"))
							.add(Projections.property("ReceiptType")).add(Projections.groupProperty("ReceiptType")))
							.list();
						
							map.put("receiptHeaderList", receiptHeaderList);
							map.put("bookingId", bookingId);
							}
							
						}
							
							
							/*
							 * This Code os commented by Mukesh Narayan SIngh
							 * Date 26 July 2010
							 */
							/*
							String qry = "SELECT mcc.main_chargecode_id,mcc.main_chargecode_name,sum(csd.quantity) ,sum(csd.net_amt)"
									+ " FROM bl_charge_slip_main csm left join bl_charge_slip_detail csd on csm.charge_slip_main_id = csd.charge_slip_main_id"
									+ " left join mas_charge_code cc on csd.charge_code_id=cc.charge_code_id "
									+
									// " left join bl_payment_advice_header pah on
									// csm.charge_slip_main_id =
									// pah.charge_slip_main_id"+
									" left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id"
									+ " where csm.inpatient_id = "
									+ inpatientId
									+ " and csm.package_bill_id is null and csm.status = 'y' group by mcc.main_chargecode_code,mcc.main_chargecode_id,mcc.main_chargecode_name";
							//chargeSlipList = session.createSQLQuery(qry).list();

							 */
						System.out.println("Before querrrrrrrrrrrrrrrrrrrinpatientIdrrrrrrrrrrrrr"+inpatientId);
							chargeSlipList=getHibernateTemplate().find("select mcc.Id,mcc.MainChargecodeName,sum(csd.Quantity), sum(csd.NetAmt),mcc.MainChargecodeCode "
									+ " from jkt.hms.masters.business.BlChargeSlipDetail as csd join csd.ChargeSlipMain as csm join csd.ChargeCode as cc join cc.MainChargecode "
									+ " as mcc where csm.Inpatient='"+inpatientId+"' and csd.Status='y' "
											/*+ " and mcc.Id!=38 "*/
											+ "and csm.PackageBill is null group by mcc.MainChargecodeCode,"
											+ "mcc.MainChargecodeName,mcc.Id");
							/*if(chargeSlipList.size()>0){
								for (Iterator iterator = chargeSlipList.iterator(); iterator
										.hasNext();) {
									Object[] objects = (Object[]) iterator.next();
									for(int i =0;i<4;i++){
									}
								}
							}*/
							if (chargeSlipList.size() > 0) {
								map.put("chargeSlipList", chargeSlipList);
							}
							System.out.println("chargeSlipList==="+chargeSlipList.size());

							String qryForDispense = "SELECT msi.item_id,msi.nomenclature, sum(dd.qty) ,sum(dd.net_amt)"
							+ " FROM bl_dispensing_header dh left join bl_dispensing_details dd on dh.dispensing_header_id = dd.dispensing_header_id"
							+
							// " left join bl_pymnt_advice_disp_header padh on
							// dh.dispensing_header_id =
							// padh.bill_dispensing_id"+
							" left join mas_store_item msi on dd.item_id = msi.item_id where dh.inpatient_id = "
							+ inpatientId
							+ " and dh.package_bill_id is null and dh.status = 'y' group by msi.item_id,msi.nomenclature";

							//dispenseDetailsList = session.createSQLQuery(qryForDispense).list();
							dispenseDetailsList =getHibernateTemplate().find("select msi.Id,msi.Nomenclature, sum(dd.Qty) ,sum(dd.NetAmt) " +
							" from jkt.hms.masters.business.BlDispensingDetails as dd join dd.DispensingHeader as dh join dd.Item as msi " +
							"where dh.Inpatient='"+inpatientId+"' and dh.PackageBill is null and dh.Status='y' " +
							"group by msi.Id,msi.Nomenclature");

							/*if(dispenseDetailsList.size()>0){
								for (Iterator iterator = dispenseDetailsList.iterator(); iterator
										.hasNext();) {
									Object[] objects = (Object[]) iterator.next();
									for(int i =0;i<4;i++){
									}
								}
							}*/

							if (dispenseDetailsList.size() > 0) {
								map.put("dispenseDetailsList", dispenseDetailsList);
							}

							packageBillList = session.createCriteria(BlPackageBill.class).createAlias("Inpatient", "ip")
							.add(Restrictions.eq("ip.Id", inpatientId)).list();

							String[] resType = { "chs", "bld", "pkb"};
							/*List<BlPaywardBooking> paywardBookingList = new ArrayList<BlPaywardBooking>();
							paywardBookingList = session.createCriteria(BlPaywardBooking.class).add(Restrictions.eq("Inpatient.Id", inpatientID)).list();
							int bookingId = 0;
						if(paywardBookingList.size()>0){
							for(BlPaywardBooking blPaywardBooking : paywardBookingList){
								bookingId = blPaywardBooking.getId(); 
							
						System.out.println("bookingId===="+bookingId);
							map.put("bookingId", bookingId);
							paidAmtList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.in("ReceiptType", resType))
							.createAlias("Inpatient", "ip",CriteriaSpecification.LEFT_JOIN)
							.add(Restrictions.or(Restrictions.eq("ip.Id", inpatientID), Restrictions.eq("Booking.Id", bookingId)))
							.setProjection(Projections.projectionList().add(Projections.sum("Amount"))
							.add(Projections.property("ReceiptType")).add(Projections.groupProperty("ReceiptType")))
							.list();
							System.out.println("inpatientID===="+inpatientID);
							}
						}*/
							paidAmtList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.in("ReceiptType", resType))
									.createAlias("Inpatient", "ip")
									.add(Restrictions.eq("ip.Id", inpatientID))
									.setProjection(Projections.projectionList().add(Projections.sum("Amount"))
									.add(Projections.property("ReceiptType")).add(Projections.groupProperty("ReceiptType")))
									.list();
							
							servAdvList = session.createCriteria(BlPaymentAdviceHeader.class)
							.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId))
							.setProjection(Projections.projectionList().add(Projections.sum("TotalAdviceAmt")))
							.list();

							dispAdvList = session.createCriteria(BlPymntAdviceDispHeader.class)
							.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId))
							.setProjection(Projections.projectionList().add(Projections.sum("TotalAdviceAmt"))).list();

							authorizerList = session.createCriteria(MasAuthorizer.class)
							.add(Restrictions.eq("Status", "y")).list();

							String qryForServAdv = "SELECT mcc.main_chargecode_id,mcc.main_chargecode_name,sum(pad.advice_qty) ,sum(pad.advice_amt),sum(pad.advice_charity_amt)"
							+ " FROM bl_payment_advice_details pad left join bl_payment_advice_header pah on pad.payment_advice_header_id = pah.payment_advice_header_id"
							+ " left join mas_charge_code cc on pad.charge_id=cc.charge_code_id "
							+ " left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id"
							+ " where pah.inpatient_id = '"
							+ inpatientId
							+ "' group by mcc.main_chargecode_code,mcc.main_chargecode_id,mcc.main_chargecode_name";

							adviceDtList = session.createSQLQuery(qryForServAdv).list();
							if (adviceDtList.size() > 0)
							{
								map.put("adviceDtList", adviceDtList);
							}

							String qryForDispAdv = "SELECT msi.item_id,msi.nomenclature, sum(pad.advice_qty) ,sum(pad.advice_amt),sum(pad.advice_charity_amt)"
							+ " FROM bl_pymnt_advice_disp_details pad left join bl_pymnt_advice_disp_header pah on pad.pymnt_advice_disp_header_id = pah.pymnt_advice_disp_header_id"
							+ " left join mas_store_item msi on pad.item_id = msi.item_id where pah.inpatient_id = '"
							+ inpatientId + "' group by msi.item_id,msi.nomenclature";

							adviceDispDtList = session.createSQLQuery(qryForDispAdv)
									.list();
							if (adviceDispDtList.size() > 0)
							{
								map.put("adviceDispDtList", adviceDispDtList);
							}

							if (packageBillList.size() > 0)
							{
								map.put("packageBillList", packageBillList);
							}
							if (paidAmtList.size() > 0)
							{
								map.put("paidAmtList", paidAmtList);
							}
							BigDecimal totalAdvAmt = new BigDecimal(0);
							BigDecimal servAdvAmt = new BigDecimal(0);
							BigDecimal dispAdvAmt = new BigDecimal(0);

							if (servAdvList.size() > 0)
							{
								if (servAdvList.get(0) != null)
									servAdvAmt = (BigDecimal) servAdvList.get(0);
							}
							if (dispAdvList.size() > 0)
							{
								if (dispAdvList.get(0) != null)
									dispAdvAmt = (BigDecimal) dispAdvList.get(0);

							}
							totalAdvAmt = servAdvAmt.add(dispAdvAmt);
							map.put("totalAdvAmt", totalAdvAmt);

							map.put("authorizerList", authorizerList);
						}
						String finalBillNo = generateFinalBillNo("display");
						map.put("finalBillNo", finalBillNo);

					}
					else
					{
						String message = "Final Bill for patient is already prepared.";
						map.put("message", message);
					}
				}
				else
				{
					String message = "Proceed to Patient Discharge First.";
					map.put("message", message);
				}
			}
			transaction.commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if (transaction != null)
			{
				transaction.rollback();
			}
		} /*catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*//*finally{
			if(session!=null){
				session.close();
			}
		}*/
		
		return map;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> singlePateintRoomRentCalculate(
			Map<String, Object> dataMap, Integer patientHinId) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> chargeDtMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BlFinalBillDetails> blFinalList = new ArrayList<BlFinalBillDetails>();
		List<MasChargeCode> chargeSetupList = new ArrayList<MasChargeCode>();
		List<BlChargeSlipMain> blChargeSlipList = new ArrayList<BlChargeSlipMain>();
		
		int hospitalId = 0; // added by amit das on 07-07-2017
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = null;
		Date lastProcessedDate = null;
		if (dataMap.get("session") != null) {
			session = (Session) dataMap.get("session");
		}

		long diffDays = 0;

		if (dataMap.get("lastProcessedDate") != null) {
			lastProcessedDate = (Date) dataMap.get("lastProcessedDate");
			diffDays = LeaveManagementUtil.daysDifferenceBetweenTwoDates(
					lastProcessedDate, new Date());
		}

		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		
		if (diffDays == 0) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			lastProcessedDate = cal.getTime();
			diffDays = 1;
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			for (int j = 1; j <= diffDays; j++) {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(lastProcessedDate);
				int dateValue = calendar.get(Calendar.DATE);
				calendar.set(Calendar.DATE, dateValue + j);
				Date processDate = calendar.getTime();

				inpatientList = session.createCriteria(Inpatient.class)
						.createAlias("Hin", "hn")
						.add(Restrictions.eq("hn.Id", patientHinId)).list();

				for (Inpatient inpatient : inpatientList) {
					Map<String, Object> detailsMap = new HashMap<String, Object>();
					BigDecimal totalChargeAmount = new BigDecimal(0);
					BigDecimal totalDiscAmt = new BigDecimal(0);
					BigDecimal totalNetAmount = new BigDecimal(0);
					int inpatientId = inpatient.getId();
					int hinId = inpatient.getHin().getId();
					hospitalId = inpatient.getHospital().getId();
					int wardId = inpatient.getDepartment().getId();
					
					Date inpatient_dateOfAddmission = inpatient
							.getDateOfAddmission();

					if (processDate.before(inpatient_dateOfAddmission)) {
						
					} else {
						blFinalList = session
								.createCriteria(BlFinalBillDetails.class)
								.add(Restrictions.eq("Inpatient.Id",
										inpatientId)).list();

						
						  blChargeSlipList =
						  session.createCriteria(BlChargeSlipMain.class).add(Restrictions.eq("Inpatient.Id",inpatientId))
					//	  .add(Restrictions.eq("Hin.Id", patientHinId))
						  .add(Restrictions.eq("ChgSlpDate", processDate))
						  .add(Restrictions.eq("RoomProcessed", "y")).list();
						System.out.println("blFinalList=="+blFinalList.size()); 
						System.out.println("blChargeSlipList=="+blChargeSlipList.size()); 

						if (blFinalList.size() > 0 || blChargeSlipList.size() >0) {
							System.out.println("11111111111111");
							// do nothing
						} else {
							
							Integer chargeTypeId = getMasChargeTypeId();
							System.out.println("chargeTypeId==========="+chargeTypeId);
							System.out.println("wardId==========="+wardId);
							chargeSetupList = session
									.createCriteria(MasChargeCode.class).add(Restrictions.eq("Department.Id", wardId))
									.add(Restrictions.eq("ChargeType.Id",
											chargeTypeId)).list();

							if (inpatient.getHin().getCompany() != null) {
								detailsMap.put("companyId", inpatient.getHin()
										.getCompany().getId());
							}

							detailsMap.put("patientTypeId", inpatient.getHin().getPatientType() != null?inpatient.getHin().getPatientType().getId():0);
							detailsMap.put("regType", inpatient.getHin().getRegistrationType() != null?inpatient.getHin().getRegistrationType():"");
							detailsMap.put("billTypeId", 2);
							detailsMap.put("patientCategory", "IP");
							detailsMap.put("hospitalId", hospitalId); // added by amit das on 07-07-2017
							
							detailsMap.put("roomTypeId", inpatient.getBed().getRoom().getRoomType().getId());
							System.out.println("2222222222222========roomTypeId==="+inpatient.getBed().getRoom().getRoomType().getId());
							System.out.println("chargeSetupList==="+chargeSetupList.size());
							// --------------- For getting total
							// amount-----------------
							for (MasChargeCode chargeSetup : chargeSetupList) {
								int chargeCodeId = 0;
								chargeCodeId = chargeSetup.getId();

								detailsMap.put("chargeId", chargeCodeId);
								detailsMap.put("mainChargeId", chargeSetup
										.getMainChargecode().getId());
								detailsMap.put("subChargeId", chargeSetup
										.getSubChargecode().getId());

								chargeDtMap = opBillingDataService.getChargeAmountAfterDiscount(detailsMap);
								BigDecimal chargeAmountAfterDis = new BigDecimal(0);
								BigDecimal discAmt = new BigDecimal(0);
								BigDecimal chargeAfterSD = new BigDecimal(0);

								if (chargeDtMap.get("chargeAmountAfterDis") != null) {
									chargeAmountAfterDis = (BigDecimal) chargeDtMap
											.get("chargeAmountAfterDis");
								}
								System.out.println("chargeAmountAfterDis==="+chargeAmountAfterDis);
								if (chargeDtMap.get("discAmt") != null) {
									discAmt = (BigDecimal) chargeDtMap
											.get("discAmt");
								}
								System.out.println("discAmt==="+discAmt);
								if (chargeDtMap.get("chargeAfterSD") != null) {
									chargeAfterSD = (BigDecimal) chargeDtMap
											.get("chargeAfterSD");
								}
								System.out.println("chargeAfterSD==="+chargeAfterSD);

								totalChargeAmount = totalChargeAmount
										.add(chargeAfterSD.multiply(new BigDecimal(1)));
								totalDiscAmt = totalDiscAmt.add(discAmt.multiply(new BigDecimal(1)));
								totalNetAmount = totalNetAmount.add(chargeAmountAfterDis.multiply(new BigDecimal(1)));
								
							
							}

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
							chargeSlipNo = getChargeSlipNo("save",hospitalId);
							chargeSlipMain.setChargeSlipNo(chargeSlipNo);
							chargeSlipMain.setChgSlpAmt(totalChargeAmount);
							chargeSlipMain.setOsAmt(totalChargeAmount);

							if (totalDiscAmt.compareTo(new BigDecimal(0)) > 0) {
								chargeSlipMain.setDiscountAmt(totalDiscAmt);
							}
							chargeSlipMain.setNetAmt(totalNetAmount);

							/*MasPatientType patientType = new MasPatientType();
							patientType.setId(inpatient.getHin().getPatientType() != null?inpatient.getHin().getPatientType().getId():0);
							chargeSlipMain.setPatientType(patientType);*/

							if (inpatient.getHin().getCompany() != null) {
								MasCompany company = new MasCompany();
								company.setId(inpatient.getHin().getCompany()
										.getId());
								chargeSlipMain.setCompany(company);
							}

							chargeSlipMain.setChgSlpDate(processDate);
							chargeSlipMain.setChgSlpTime(time);
							Users user = new Users();
							Integer userId = (Integer) dataMap.get("userId");
							user.setId(userId);
							chargeSlipMain.setLastChgBy(user);
							chargeSlipMain.setLastChgDate(processDate);
							chargeSlipMain.setLastChgTime(time);
							chargeSlipMain.setStatus("y");
							chargeSlipMain.setAutoProcessed("y");
							chargeSlipMain.setRoomProcessed("y");
							MasEmployee consultant = new MasEmployee();
							consultant.setId(inpatient.getDoctor().getId());
							chargeSlipMain.setConsultant(consultant);

							hbt.save(chargeSlipMain);

							if (chargeSetupList.size() > 0) {
								for (MasChargeCode chargeSetup : chargeSetupList) {
									int chargeCodeId = chargeSetup.getId();
									if (chargeCodeId != 0) {
										BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
										blChargeSlipDetail
												.setHospital(hospital);
										MasChargeCode masChargeCode = new MasChargeCode();
										masChargeCode.setId(chargeCodeId);
										blChargeSlipDetail
												.setChargeCode(masChargeCode);

										detailsMap
												.put("chargeId", chargeCodeId);
										detailsMap.put("mainChargeId",
												chargeSetup.getMainChargecode()
														.getId());
										detailsMap.put("subChargeId",
												chargeSetup.getSubChargecode()
														.getId());

										chargeDtMap = opBillingDataService
												.getChargeAmountAfterDiscount(detailsMap);

										BigDecimal chargeAmountAfterDis = new BigDecimal(
												0.00);
										BigDecimal discAmt = new BigDecimal(
												0.00);
										BigDecimal stdDeduction = new BigDecimal(
												0.00);
										BigDecimal rate = new BigDecimal(0.00);
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
										if (chargeDtMap.get("stdDeduction") != null) {
											stdDeduction = (BigDecimal) chargeDtMap
													.get("stdDeduction");
										}
										if (chargeDtMap.get("rate") != null) {
											rate = (BigDecimal) chargeDtMap
													.get("rate");
										}
										if (chargeDtMap.get("chargeAfterSD") != null) {
											chargeAfterSD = (BigDecimal) chargeDtMap
													.get("chargeAfterSD");
										}
										if (map.get("discPercnt") != null) {
											discountPercent = (BigDecimal) map
													.get("discPercnt");
										}
										blChargeSlipDetail
												.setRate(chargeAfterSD);

										if (inpatient.getHin().getRegType() != null
												&& !inpatient.getHin()
														.getRegType()
														.equals("")) {
											if (inpatient.getHin().getRegType()
													.equals("G")) {
												if (stdDeduction
														.compareTo(new BigDecimal(
																0)) > 0) {
													blChargeSlipDetail
															.setStdDeductionGen(stdDeduction
																	.multiply(new BigDecimal(
																			1)));
												}
											} else if (inpatient.getHin()
													.getRegType().equals("S")) {
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
										blChargeSlipDetail.setAmt(chargeAfterSD
												.multiply(new BigDecimal(1)));
										blChargeSlipDetail.setQuantity(1);

										if (discountPercent
												.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail
													.setDiscountPercent(discountPercent);

										if (discAmt
												.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail
													.setDiscountAmt(discAmt
															.multiply(new BigDecimal(
																	1)));

										if (chargeAmountAfterDis
												.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail
													.setNetAmt(chargeAmountAfterDis
															.multiply(new BigDecimal(
																	1)));

										Users user1 = new Users();
										Integer userId1 = (Integer) dataMap
												.get("userId");
										user1.setId(userId1);
										blChargeSlipDetail.setLastChgBy(user1);
										blChargeSlipDetail
												.setLastChgDate(HMSUtil
														.convertStringTypeDateToDateType(date));
										blChargeSlipDetail.setLastChgTime(time);
										blChargeSlipDetail.setStatus("y");
										blChargeSlipDetail
												.setChargeSlipMain(chargeSlipMain);
										blChargeSlipDetail
												.setRefundableStatus("y");
										MasDepartment department = new MasDepartment();
										department.setId(inpatient
												.getDepartment().getId());
										blChargeSlipDetail
												.setDepartment(department);
										try {
											hbt.save(blChargeSlipDetail);
										} catch (RuntimeException e) {
											e.printStackTrace();
										}

										Patient patientObj = (Patient) session
												.load(Patient.class, hinId);
										BigDecimal pastDue = new BigDecimal(0);
										BigDecimal newAmt = new BigDecimal(0);
										if (patientObj.getPastDue() != null) {
											pastDue = new BigDecimal(
													patientObj.getPastDue());
										}
										newAmt = pastDue.add(chargeAfterSD);
										patientObj
												.setPastDue(newAmt.toString());
										session.update(patientObj);
									}
								}
							}
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return map;
	}
	/*public Map<String, Object> singlePateintRoomRentCalculate(Map<String, Object> dataMap,Integer patientHinId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		

		
		Map<String, Object> chargeDtMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BlFinalBillDetails> blFinalList = new ArrayList<BlFinalBillDetails>();
		List<MasChargeCode> chargeSetupList = new ArrayList<MasChargeCode>();
		//List<BlChargeSlipMain> blChargeSlipList = new ArrayList<BlChargeSlipMain>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = null;
		Date lastProcessedDate = null;
		if(dataMap.get("session")!= null)
		{
			session =  (Session)dataMap.get("session");
		}

		long diffDays = 0;

		if(dataMap.get("lastProcessedDate")!= null)
		{
			lastProcessedDate =  (Date)dataMap.get("lastProcessedDate");
			diffDays = LeaveManagementUtil.daysDifferenceBetweenTwoDates(lastProcessedDate, new Date());
		}

		if(diffDays ==0)
		{
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			lastProcessedDate = cal.getTime();
			diffDays = 1;
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try
		{
			for(int j=1; j<=diffDays; j++)
			{

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(lastProcessedDate);
				int dateValue = calendar.get(Calendar.DATE);
				calendar.set(Calendar.DATE, dateValue + j);
				Date processDate = calendar.getTime();

				inpatientList = session.createCriteria(Inpatient.class)
				.createAlias("Hin", "hn")
				.add(Restrictions.eq("hn.Id",patientHinId))
				.list();

				for (Inpatient inpatient : inpatientList)
				{
					Map<String, Object> detailsMap = new HashMap<String, Object>();
					BigDecimal totalChargeAmount= new BigDecimal(0);
					BigDecimal totalDiscAmt = new BigDecimal(0);
					BigDecimal totalNetAmount= new BigDecimal(0);
					int inpatientId = inpatient.getId();
					int hinId = inpatient.getHin().getId();
					int hospitalId = inpatient.getHospital().getId();
					Date inpatient_dateOfAddmission = inpatient.getDateOfAddmission();

					if (processDate.before(inpatient_dateOfAddmission))
					{
					}
					else
					{
						blFinalList = session.createCriteria(BlFinalBillDetails.class)
						.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

						blChargeSlipList = session.createCriteria(BlChargeSlipMain.class)
						.add(Restrictions.eq("Hin.Id", patientHinId))
						.add(Restrictions.eq("ChgSlpDate", processDate))
						.add(Restrictions.eq("RoomProcessed", "y")).list();

						if(blFinalList.size() > 0 || blChargeSlipList.size() > 0)
						{
							// do nothing
						}
						else
						{
							Integer chargeTypeId = getMasChargeTypeId();

							chargeSetupList = session.createCriteria(MasChargeCode.class)
							.add(Restrictions.eq("ChargeType.Id", chargeTypeId)).list();

							if(inpatient.getHin().getCompany() != null){
							detailsMap.put("companyId", inpatient.getHin().getCompany().getId());}

							detailsMap.put("patientTypeId", inpatient.getHin().getPatientType().getId());
							detailsMap.put("regType", inpatient.getHin().getRegistrationType());
							detailsMap.put("billTypeId", 2);
							detailsMap.put("patientCategory", "IP");
							detailsMap.put("roomTypeId", inpatient.getBed().getRoom().getRoomType().getId());

							//	--------------- For getting total amount-----------------
							for(MasChargeCode chargeSetup : chargeSetupList)
							{
								int chargeCodeId = 0;
								chargeCodeId = chargeSetup.getId();

								detailsMap.put("chargeId", chargeCodeId);
								detailsMap.put("mainChargeId", chargeSetup.getMainChargecode().getId());
								detailsMap.put("subChargeId", chargeSetup.getSubChargecode().getId());

								chargeDtMap = opBillingDataService.getChargeAmountAfterDiscount(detailsMap);
								BigDecimal chargeAmountAfterDis = new BigDecimal(0);
								BigDecimal discAmt = new BigDecimal(0);
								BigDecimal chargeAfterSD = new BigDecimal(0);

								if(chargeDtMap.get("chargeAmountAfterDis") !=  null)
								{
									chargeAmountAfterDis = (BigDecimal)chargeDtMap.get("chargeAmountAfterDis");
								}
								if(chargeDtMap.get("discAmt") !=  null)
								{
									discAmt = (BigDecimal)chargeDtMap.get("discAmt");
								}
								if(chargeDtMap.get("chargeAfterSD") !=  null)
								{
									chargeAfterSD = (BigDecimal)chargeDtMap.get("chargeAfterSD");
								}

								totalChargeAmount = totalChargeAmount.add(chargeAfterSD.multiply(new BigDecimal(1)));
								totalDiscAmt = totalDiscAmt.add(discAmt.multiply(new BigDecimal(1)));
								totalNetAmount = totalNetAmount.add(chargeAmountAfterDis.multiply(new BigDecimal(1)));
							}

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
							chargeSlipMain.setChargeSlipNo(chargeSlipNo);
							chargeSlipMain.setChgSlpAmt(totalChargeAmount);
							chargeSlipMain.setOsAmt(totalChargeAmount);

							if (totalDiscAmt.compareTo(new BigDecimal(0)) > 0)
							{
								chargeSlipMain.setDiscountAmt(totalDiscAmt);
							}
							chargeSlipMain.setNetAmt(totalNetAmount);

							MasPatientType patientType = new MasPatientType();
							patientType.setId(inpatient.getHin().getPatientType().getId());
							chargeSlipMain.setPatientType(patientType);

							if (inpatient.getHin().getCompany() != null)
							{
								MasCompany company = new MasCompany();
								company.setId(inpatient.getHin().getCompany().getId());
								chargeSlipMain.setCompany(company);
							}

							chargeSlipMain.setChgSlpDate(processDate);
							chargeSlipMain.setChgSlpTime(time);
							Users user = new Users();
							Integer userId = (Integer)dataMap.get("userId");
							user.setId(userId);
							chargeSlipMain.setLastChgBy(user);
							chargeSlipMain.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
							chargeSlipMain.setLastChgTime(time);
							chargeSlipMain.setStatus("y");
							chargeSlipMain.setAutoProcessed("y");
							chargeSlipMain.setRoomProcessed("y");
							MasEmployee consultant = new MasEmployee();
							consultant.setId(inpatient.getDoctor().getId());
							chargeSlipMain.setConsultant(consultant);

							hbt.save(chargeSlipMain);

							if(chargeSetupList.size() > 0)
							{
								for(MasChargeCode chargeSetup : chargeSetupList)
								{
									int chargeCodeId = chargeSetup.getId();
									if (chargeCodeId != 0)
									{
										BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
										blChargeSlipDetail.setHospital(hospital);
										MasChargeCode masChargeCode = new MasChargeCode();
										masChargeCode.setId(chargeCodeId);
										blChargeSlipDetail.setChargeCode(masChargeCode);

										detailsMap.put("chargeId", chargeCodeId);
										detailsMap.put("mainChargeId", chargeSetup.getMainChargecode().getId());
										detailsMap.put("subChargeId", chargeSetup.getSubChargecode().getId());

										chargeDtMap = opBillingDataService.getChargeAmountAfterDiscount(detailsMap);

										BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
										BigDecimal discAmt = new BigDecimal(0.00);
										BigDecimal stdDeduction = new BigDecimal(0.00);
										BigDecimal rate = new BigDecimal(0.00);
										BigDecimal chargeAfterSD = new BigDecimal(0.00);
										BigDecimal discountPercent = new BigDecimal(0.00);

										if(chargeDtMap.get("chargeAmountAfterDis") !=  null)
										{
											chargeAmountAfterDis = (BigDecimal)chargeDtMap.get("chargeAmountAfterDis");
										}
										if(chargeDtMap.get("discAmt") !=  null)
										{
											discAmt = (BigDecimal)chargeDtMap.get("discAmt");
										}
										if(chargeDtMap.get("stdDeduction") !=  null)
										{
											stdDeduction = (BigDecimal)chargeDtMap.get("stdDeduction");
										}
										if(chargeDtMap.get("rate") !=  null)
										{
											rate = (BigDecimal)chargeDtMap.get("rate");
										}
										if(chargeDtMap.get("chargeAfterSD") !=  null)
										{
											chargeAfterSD = (BigDecimal)chargeDtMap.get("chargeAfterSD");
										}
										if (map.get("discPercnt") != null)
										{
											discountPercent = (BigDecimal)map.get("discPercnt");
										}
										blChargeSlipDetail.setRate(chargeAfterSD);

										if (inpatient.getHin().getRegType() != null
											&& !inpatient.getHin().getRegType().equals(""))
										{
											if (inpatient.getHin().getRegType().equals("G"))
											{
												if (stdDeduction.compareTo(new BigDecimal(0)) > 0)
												{
													blChargeSlipDetail.setStdDeductionGen(stdDeduction.multiply(new BigDecimal(1)));
												}
											}
											else if (inpatient.getHin().getRegType().equals("S"))
											{
												if (stdDeduction.compareTo(new BigDecimal(0)) > 0)
												{
													blChargeSlipDetail.setStdDeductionSpl(stdDeduction.multiply(new BigDecimal(1)));
												}
											}
										}
										blChargeSlipDetail.setAmt(chargeAfterSD.multiply(new BigDecimal(1)));
										blChargeSlipDetail.setQuantity(1);

										if (discountPercent.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail.setDiscountPercent(discountPercent);

										if (discAmt.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail.setDiscountAmt(discAmt.multiply(new BigDecimal(1)));

										if (chargeAmountAfterDis.compareTo(new BigDecimal(0)) > 0)
											blChargeSlipDetail.setNetAmt(chargeAmountAfterDis.multiply(new BigDecimal(1)));
										
										//blChargeSlipDetail.setLastChgBy(432);
										blChargeSlipDetail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
										blChargeSlipDetail.setLastChgTime(time);
										blChargeSlipDetail.setStatus("y");
										blChargeSlipDetail.setChargeSlipMain(chargeSlipMain);
										blChargeSlipDetail.setRefundableStatus("y");
										MasDepartment department = new MasDepartment();
										department.setId(inpatient.getDepartment().getId());
										blChargeSlipDetail.setDepartment(department);
										try
										{
											hbt.save(blChargeSlipDetail);
										}
										catch (RuntimeException e) {
											e.printStackTrace();
										}

										Patient patientObj = (Patient) session.load(Patient.class, hinId);
										BigDecimal pastDue = new BigDecimal(0);
										BigDecimal newAmt = new BigDecimal(0);
										if (patientObj.getPastDue() != null)
										{
											pastDue = new BigDecimal(patientObj.getPastDue());
										}
										newAmt = pastDue.add(chargeAfterSD);
										patientObj.setPastDue(newAmt.toString());
										session.update(patientObj);
									}
								}
							}
						}
					}
				}
			}
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (RuntimeException e)
		{
			e.printStackTrace();
		}

		Map<String, Object> map=new HashMap<String,Object>();
		return map;
	}*/
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
	public Map<String, Object> getChargeCodeForMainCharge(int mainChargeId,
			int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> chargeSlipList = new ArrayList<Object[]>();
		Session session = getSession();
		/* StringBuilder qry = new StringBuilder(); */
		try {
			/*
			 * if(mainChargeId != 38) { qry.append(
			 * " SELECT cc.charge_code_name,csd.quantity, csd.rate, csd.amt,csm.charge_slip_no,padd.advice_qty,padd.advice_amt,convert(varchar,csm.chg_slp_date,103) "
			 * ); qry.append(
			 * " FROM bl_charge_slip_detail csd left join mas_charge_code cc on csd.charge_code_id=cc.charge_code_id "
			 * ); qry.append(
			 * " left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id "
			 * ); qry.append(
			 * " left join bl_charge_slip_main csm on csd.charge_slip_main_id = csm.charge_slip_main_id "
			 * ); qry.append(
			 * " left join bl_payment_advice_header pah on csm.charge_slip_main_id = pah.charge_slip_main_id "
			 * ); qry.append(
			 * " left join bl_payment_advice_details padd on pah.payment_advice_header_id = padd.payment_advice_header_id "
			 * ); qry.append(
			 * " left join inpatient ip on csm.inpatient_id = ip.inpatient_id "
			 * ); qry.append(" where mcc.main_chargecode_id= "+mainChargeId);
			 * qry.append(
			 * " and csm.status = 'y' and (padd.advice_amt != csd.amt or padd.advice_amt is null) and csm.inpatient_id = "
			 * +inpatientId); } else { qry.append(
			 * " SELECT mdep.department_name ,csd.quantity, csd.rate, csd.amt,csm.charge_slip_no,padd.advice_qty,padd.advice_amt,convert(varchar,csm.chg_slp_date,103) "
			 * ); qry.append(
			 * " FROM bl_charge_slip_detail csd left join mas_charge_code cc on csd.charge_code_id=cc.charge_code_id "
			 * ); qry.append(
			 * " left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id "
			 * ); qry.append(
			 * " left join bl_charge_slip_main csm on csd.charge_slip_main_id = csm.charge_slip_main_id "
			 * ); qry.append(
			 * " left join bl_payment_advice_header pah on csm.charge_slip_main_id = pah.charge_slip_main_id "
			 * ); qry.append(
			 * " left join bl_payment_advice_details padd on pah.payment_advice_header_id = padd.payment_advice_header_id "
			 * ); qry.append(
			 * " left join inpatient ip on csm.inpatient_id = ip.inpatient_id "
			 * ); qry.append(
			 * " left join mas_department mdep on csd.department_id = mdep.department_id "
			 * ); qry.append(" where mcc.main_chargecode_id= "+mainChargeId);
			 * qry.append(
			 * " and csm.status = 'y' and (padd.advice_amt != csd.amt or padd.advice_amt is null) and csm.inpatient_id = "
			 * +inpatientId); }
			 */
			String qry = " SELECT cc.charge_code_name,csd.quantity, csd.rate, csd.amt,csm.charge_slip_no,padd.advice_qty,padd.advice_amt,"
					+ "csm.charge_slip_main_id,csd.charge_slip_detail_id,to_char((csm.chg_slp_date),'DD/MM/YYYY'),csd.discount_amt"
					+ " FROM bl_charge_slip_detail csd left join mas_charge_code cc on csd.charge_code_id=cc.charge_code_id"
					+ " left join mas_main_chargecode mcc on cc.main_chargecode_id=mcc.main_chargecode_id"
					+ " left join bl_charge_slip_main csm on csd.charge_slip_main_id = csm.charge_slip_main_id"
					+ " left join bl_payment_advice_header pah on csm.charge_slip_main_id = pah.charge_slip_main_id"
					+ " left join bl_payment_advice_details padd on pah.payment_advice_header_id = padd.payment_advice_header_id"
					+ " left join inpatient ip on csm.inpatient_id = ip.inpatient_id "
					+ " where mcc.main_chargecode_id="
					+ mainChargeId
					+ " and csm.status = 'y' and csd.status='y' and (padd.advice_amt != csd.amt or padd.advice_amt is null) and csm.inpatient_id="
					+ inpatientId + " order by csm.chg_slp_date asc";

			chargeSlipList = session.createSQLQuery(qry.toString()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		map.put("chargeSlipList", chargeSlipList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitFinalBillDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		BlFinalBillDetails finalBillDetails = new BlFinalBillDetails();
		boolean flag = false;
		int hospitalId = box.getInt("hospitalId");
		int hinId = 0;
		int inpatientId = 0;
		int userId=box.getInt(USER_ID);
		Session session=getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BigDecimal stlAmt = new BigDecimal(0);
		BigDecimal finalBillCharity = new BigDecimal(0);
		
		BigDecimal roundOff = new BigDecimal(0);
		BigDecimal discountPercent = new BigDecimal(0);
		BigDecimal serChrgPercent = new BigDecimal(0);
		BigDecimal discountAmt = new BigDecimal(0);
		BigDecimal serChrgAmt = new BigDecimal(0);
		String distype = "";
		Transaction transaction=null;
		try
		{
			transaction=session.beginTransaction();
		if(box.getInt("totalDispensing")>0)
		{
		
		BlDispensingHeader dispensingHeader = new BlDispensingHeader();

		String billNo = "";
		String billType = "OD";
		billNo = opBillingDataService.generateBillNo(billType, "save",hospitalId);
		dispensingHeader.setBillNo(billNo);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		dispensingHeader.setHospital(hospital);
		Patient patient = new Patient();
		patient=(Patient) hbt.get(Patient.class, box.getInt(HIN_ID));
		if (box.getInt(HIN_ID)!=0) {
			patient=(Patient) hbt.get(Patient.class, box.getInt(HIN_ID));
			dispensingHeader.setPatientStatus("r");
		}
		if (!box.getString(HIN_NO).equals("")) {
			dispensingHeader.setHinNo(patient.getHinNo());
		}

		Inpatient inpatient = new Inpatient();
		if (box.getInt(INPATIENT_ID)!=0) {
			inpatient=(Inpatient) hbt.get(Inpatient.class, box.getInt(INPATIENT_ID));
			dispensingHeader.setInpatient(inpatient);
		}
		if (!box.getString(AD_NO).equals("")) {
			dispensingHeader.setAdNo(box.getString(AD_NO));
		}
		if(patient!=null)
		{
			dispensingHeader.setPatientName(patient.getPFirstName());
			dispensingHeader.setAge(patient.getAge());
			dispensingHeader.setSex(patient.getSex());
		}		
		if(inpatient!=null)
		{
			dispensingHeader.setConsultant(inpatient.getDoctor());
			if(inpatient.getDoctor()!=null)
			{
				dispensingHeader.setConsultantName(inpatient.getDoctor().getFirstName());
			}
		}		
		dispensingHeader.setBillAmt(new BigDecimal(box.getFloat("totalAmmount")));
		dispensingHeader.setDiscountAmt(new BigDecimal(box.getFloat("totalDisAmmount")));
		dispensingHeader.setRoundOff(BigDecimal.ZERO);
		dispensingHeader.setAdvAdjustment(new BigDecimal(0.00));
		dispensingHeader.setOutstanding(new BigDecimal(box.getFloat("totalNetAmmount")));
		dispensingHeader.setDiscountOnBill(new BigDecimal(0.00));
		dispensingHeader.setPayableAmt(new BigDecimal(box.getFloat("totalNetAmmount")));
		dispensingHeader.setActualCollectedAmt(new BigDecimal(0.00));
		dispensingHeader.setDiscount(new BigDecimal(0.00));
		dispensingHeader.setCharity(new BigDecimal(0.00));
			
	
		/*if (request.getParameter(PATIENT_TYPE_ID) != null) {
			MasPatientType patientType = new MasPatientType();
			patientType.setId(Integer.parseInt(request
					.getParameter(PATIENT_TYPE_ID)));
			dispensingHeader.setPatientType(patientType);
		}
		if (request.getParameter("companyId") != null
				&& !(request.getParameter("companyId").equals("0"))) {
			MasCompany company = new MasCompany();
			company.setId(Integer.parseInt(request.getParameter("companyId")));
			dispensingHeader.setCompany(company);
		}*/
		dispensingHeader.setBillDate(HMSUtil
				.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		dispensingHeader.setBillTime((String)utilMap.get("currentTime"));
		Users userObj = new Users();
		userObj.setId(userId);
		dispensingHeader.setChangedBy(userObj);
		dispensingHeader.setStatus("y");
		hbt.save(dispensingHeader);
		for(int i=1;i<=box.getInt("totalDispensing");i++)
		{
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

						dispensingDetails.setProportionalDisAmt(BigDecimal.ZERO);
						dispensingDetails.setSalesTaxAmt(BigDecimal.ZERO);
						dispensingDetails.setNetAmt(new BigDecimal(box.getString("batchNetAmt"+i)));
					dispensingDetails.setRefundableStatus("y");
					dispensingDetails.setIssued("n");
					hbt.save(dispensingDetails);
				}
		}
		
		BigDecimal pastDueBD = new BigDecimal(0);
			String pastDue = "";
			if (patient.getPastDue() != null)
				pastDue = patient.getPastDue();

			String sign = "";
			if (pastDue != null && !pastDue.equals("")
					&& !pastDue.equals("0")) {
				sign = pastDue.substring(0, 1);
				pastDueBD = new BigDecimal(pastDue);
				if (sign.equals("-")) {
					if (box.getFloat("totalNetAmmount")>0) {
						pastDueBD = pastDueBD.subtract(new BigDecimal(box.getString("totalNetAmmount")));
					}
				} else {
					if (box.getFloat("totalNetAmmount")>0) {
						pastDueBD = pastDueBD.add(new BigDecimal(box.getString("totalNetAmmount")));
					}
				}
			} else {
				if (box.getFloat("totalNetAmmount")>0) {
					pastDueBD = pastDueBD.add(new BigDecimal(box.getString("totalNetAmmount")));
				}
			}
			patient.setPastDue(pastDueBD.toString());
			hbt.update(patient);
		}
		
		
		if (box.getString("distype") != null
				&& !box.getString("distype").equals("")) {
			distype = box.getString("distype");
		}
		
		if (box.getString(DISCOUNT_AMOUNT) !=null && !box.getString(DISCOUNT_AMOUNT).equals("") )
		{
			discountAmt = new BigDecimal(box.getString(DISCOUNT_AMOUNT));
			
		}
		
		if ( box.getString("totalPkgDisAmmount") !=null &&box.getString("totalPkgDisAmmount") != "" ) // Added by Amit Das on 14-03-2016
		{
			discountAmt =     discountAmt.add(new BigDecimal(box.getString("totalPkgDisAmmount")));
			
		}
		
		if ( box.getString(SERVICE_CHARGE_AMOUNT)!=null && !box.getString(SERVICE_CHARGE_AMOUNT).equals(""))
		{
			serChrgAmt = new BigDecimal(box.getString(SERVICE_CHARGE_AMOUNT));}
		
		if (box.getString(DISCOUNT_PERCENTAGE)!=null && !box.getString(DISCOUNT_PERCENTAGE).equals("")){
			discountPercent = new BigDecimal(box.getString(DISCOUNT_PERCENTAGE));}
		
		if ( box.getString(SERVICE_CHARGE_PERCENT)!=null && !box.getString(SERVICE_CHARGE_PERCENT).equals("")){
			serChrgPercent = new BigDecimal(
					box.getString(SERVICE_CHARGE_PERCENT));}
	

				List<BlFinalBillDetails> finalBillDetailsList = new ArrayList<BlFinalBillDetails>();
			finalBillDetailsList = session
					.createCriteria(BlFinalBillDetails.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
			if (finalBillDetailsList.size() == 0) {
				
				hinId = box.getInt(HIN_ID);
				inpatientId = box.getInt(INPATIENT_ID);
				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				finalBillDetails.setHospital(hospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				finalBillDetails.setHin(patient);

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				finalBillDetails.setInpatient(inpatient);
if(box.getInt(PATIENT_TYPE_ID)!=0)
{
				MasPatientType patientType = new MasPatientType();
				patientType.setId(box.getInt(PATIENT_TYPE_ID));
				finalBillDetails.setPatientType(patientType);
}
				if (box.getInt("companyId") != 0) {
					MasCompany company = new MasCompany();
					company.setId(box.getInt("companyId"));
					finalBillDetails.setCompany(company);
				}

				if (box.getInt(AUTHORIZER_ID) != 0) {
					MasAuthorizer authorizer = new MasAuthorizer();
					authorizer.setId(box.getInt(AUTHORIZER_ID));
					finalBillDetails.setAuthorizer(authorizer);
				}
				String finalBillNo = "";
				finalBillNo = generateFinalBillNo("save",hospitalId);
				finalBillDetails.setFinalBillNo(finalBillNo);
				finalBillDetails.setDiscountPercent(discountPercent);
				finalBillDetails.setDiscountAmt(discountAmt);
				finalBillDetails.setFinalBillCharity(discountAmt);
				finalBillDetails.setServiceChrgPercent(serChrgPercent);
				finalBillDetails.setServiceChrgAmt(serChrgAmt);
				finalBillDetails.setSettledAmt(stlAmt);
				finalBillDetails.setRoundOff(roundOff);
				finalBillDetails.setFinalSettlementCharity(finalBillCharity);
				if (distype.equals("j")) {
					finalBillDetails.setNetAmt(new BigDecimal(0));
				} else {
					finalBillDetails.setNetAmt(new BigDecimal(box
							.getString("pastDue")));
				}
				finalBillDetails.setGrossAmt(new BigDecimal(box
						.getString(TOTAL_AMOUNT)));
				finalBillDetails.setPaidAmt(new BigDecimal(box
						.getString(PAID_AMOUNT)));
				
				finalBillDetails.setAdvAmt(new BigDecimal(box
						.getString("advAmt")));
				
				
				/*
				 * if(!box.getString(ROUND_OF_VALUE).equals("")){
				 * finalBillDetails.setRoundOff(new
				 * BigDecimal(box.getString(ROUND_OF_VALUE))); }
				 */
				finalBillDetails.setStatus("u");
				Users user = new Users();
				user.setId(box.getInt("userId"));
				finalBillDetails.setLastChgBy(user);
				finalBillDetails.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				finalBillDetails.setLastChgTime(box.getString(CHANGED_TIME));
				finalBillDetails.setFinalBillDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				hbt.save(finalBillDetails);
				hbt.flush();
				hbt.clear();

				// Session session = getSession();

				List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();
				chargeSlipList = session.createCriteria(BlChargeSlipMain.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId)).list();

				if (chargeSlipList.size() > 0) {
					for (BlChargeSlipMain chargeSlipMain : chargeSlipList) {
						BlChargeSlipMain chargeSlipMainObj = (BlChargeSlipMain) hbt
								.load(BlChargeSlipMain.class,
										chargeSlipMain.getId());
						chargeSlipMainObj.setFinalBill(finalBillDetails);
						// BigDecimal servNetAmt = new BigDecimal(0);
						// BigDecimal servDiscAmt = new BigDecimal(0);

						// servNetAmt = chargeSlipMain.getNetAmt();

						// servDiscAmt =
						// (servNetAmt.multiply(discountPercent)).divide(new
						// BigDecimal(100));

						/*
						 * if(chargeSlipMain.getDiscountAmt() != null){
						 * chargeSlipMainObj.setD }
						 * chargeSlipMainObj.setPkgDiscType(discountType);
						 * chargeSlipMainObj.setPkgDiscTrfPercent(discPercent);
						 * chargeSlipMainObj.setPkgDiscTrfAmount(servDiscAmt);
						 * 
						 * if(discountType.equalsIgnoreCase("D")){
						 * chargeSlipMainObj
						 * .setNetChargeAmt(pkgServAmt.subtract(servDiscAmt));
						 * }else if(discountType.equalsIgnoreCase("T")){
						 * chargeSlipMainObj
						 * .setNetChargeAmt(pkgServAmt.add(servDiscAmt)); }
						 */

						hbt.update(chargeSlipMainObj);
					}
				}

				if (!discountAmt.equals("0")) {
					Patient patientObj = (Patient) hbt.load(Patient.class,
							hinId);
					BigDecimal pastDue = new BigDecimal(0);
					BigDecimal newAmt = new BigDecimal(0);
					if (patientObj.getPastDue() != null) {
						pastDue = new BigDecimal(patientObj.getPastDue());
					}
					newAmt = pastDue.subtract(discountAmt);
					patientObj.setPastDue(newAmt.toString());
					hbt.update(patientObj);

				}
				if (!serChrgAmt.equals("0")) {
					Patient patientObj = (Patient) hbt.load(Patient.class,
							hinId);
					BigDecimal pastDue = new BigDecimal(0);
					BigDecimal newAmt = new BigDecimal(0);
					if (patientObj.getPastDue() != null) {
						pastDue = new BigDecimal(patientObj.getPastDue());
					}
					newAmt = pastDue.add(serChrgAmt);
					patientObj.setPastDue(newAmt.toString());
					hbt.update(patientObj);
				}
				map.put("finalBillNo", finalBillNo);
			}
			transaction.commit();
			flag = true;
		} catch (DataAccessException e) {
			try
			{
				transaction.rollback();
			}
			catch(Exception exception)
			{
				
			}
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String generateFinalBillNo(String flag,int hospitalID) {
		String finalBillNo = "";
		Integer finalBillSeqNo = 0;
		List<BlParameter> finalBlSeqNoList = new ArrayList<BlParameter>();
		List<BlFinalBillDetails> finalBillDtList = new ArrayList<BlFinalBillDetails>();
		List<Integer> maxIdFinalBillList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		try {
			finalBlSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "FB"))
					.add(Restrictions.eq("Hospital.Id", hospitalID))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String lastFinalBillNo = "";
		/*maxIdFinalBillList = session.createCriteria(BlFinalBillDetails.class)
				.setProjection(Projections.max("Id")).list();
		if (maxIdFinalBillList.size() > 0) {
			finalBillDtList = session.createCriteria(BlFinalBillDetails.class)
					.add(Restrictions.idEq(maxIdFinalBillList.get(0))).list();
			if (finalBillDtList.size() > 0) {
				lastFinalBillNo = finalBillDtList.get(0).getFinalBillNo();
			} else {
				lastFinalBillNo = "1";
			}

		}
		
		 * finalBillDtList = session.createCriteria(BlFinalBillDetails.class)
		 * .list(); String lastFinalBillNo = ""; if (finalBillDtList.size() > 0)
		 * { for (BlFinalBillDetails billDt : finalBillDtList) {
		 * finalBillDtListlastFinalBillNo = billDt.getFinalBillNo(); } }
		 
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		StringTokenizer str = new StringTokenizer(lastFinalBillNo, "/");

		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (finalBlSeqNoList.size() > 0) {
			for (BlParameter blParameter : finalBlSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				finalBillSeqNo = ++seqNo;
			}

			if (criteria.equalsIgnoreCase("c")) {
				finalBillNo = finalBillSeqNo.toString();
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					finalBillSeqNo = 1;
				}
				finalBillNo = finalBillSeqNo.toString().concat("/")
						.concat(currentMonth).concat("/").concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					finalBillSeqNo = 1;
				}
				finalBillNo = finalBillSeqNo.toString().concat("/")
						.concat(currentYear);
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(finalBillSeqNo);
				hbt.update(parameterObj);
			}
		}*/
		
		int id = 0;
		// String criteria = "";
		int seqNo = 0;
		int billSeqNo=0;
		if (finalBlSeqNoList.size() > 0) {			
				for (BlParameter blParameter : finalBlSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				// criteria = blParameter.getCriteria();
				seqNo = ++seqNo;
			}
			// billNo = commonSeqNo(billSeqNo, criteria, lastBlNo);

			if (flag.equals("save")) {
				billSeqNo=seqNo;
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
			blParameter.setPrefix("FB");
			blParameter.setCriteria("c");
			// blParameter.setLastChgBy(box.getString("userName"));
//			blParameter.setLastChgDate(HMSUtil
//					.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
//			blParameter.setLastChgTime((String)utilMap.get("currentTime"));
			MasHospital hospital=new MasHospital();
			hospital.setId(hospitalID);
			blParameter.setHospital(hospital);
			hbt.save(blParameter);
		}
		hbt.flush();
		hbt.clear();
		return String.valueOf(billSeqNo);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFinalBillNo(String adNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();
		Session session = getSession();

		finalBillList = session
				.createCriteria(BlFinalBillDetails.class)
				.add(Restrictions.not(Restrictions.eq("Status", "s")
						.ignoreCase())).createAlias("Inpatient", "ip")
				.add(Restrictions.eq("ip.AdNo", adNo)).list();
		if (finalBillList.size() > 0) {
			map.put("finalBillList", finalBillList);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOpBillNo(String HinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<Object[]> billList = new ArrayList<Object[]>();
		List<Object[]> billList = new ArrayList<Object[]>();
		String query = "";
		Session session = getSession();
		try {
			/*query = "select b.bill_no,b.bill_date from bl_op_bill_header  b"
					+ " left outer join patient p on p.hin_id=b.hin_id"
					+ " where p.hin_no = '" + HinNo
					+ "' order by b.bill_no desc ";*/
			// commented by amit das on 30-07-2017
			
			query = "select b.bill_no,b.bill_date from bl_op_bill_header  b"
					+ " left outer join patient p on p.hin_id=b.hin_id"
					+ " where p.hin_no = '" + HinNo
					+ "' order by b.bill_no desc ";
			// added by amit das on 30-07-2017
			
			SQLQuery sqlQuery = session.createSQLQuery(query);   //changed by amit das on 30-07-2017
								//sqlQuery.setString(1, HinNo); // added by amit das on 30-07-2017
			billList    =			sqlQuery.list(); // added by amit das on 30-07-2017
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		/*
		 * billList=(List<BlOpBillHeader>)
		 * session.createCriteria(BlOpBillHeader.
		 * class).add(Restrictions.eq("hino", HinNo)); BillList =
		 * session.createCriteria(BlOpBillHeader.class).list();
		 * query="select b.bill_no from bl_op_bill_header  b"
		 * +" left outer join patient p on p.hin_id=b.hin_id"
		 * +" where p.hin_no ="+HinNo;
		 * billList=session.createSQLQuery(query).list();
		 */

		if (billList.size() > 0) {
			map.put("billList", billList);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getReceiptNo(String HinNo, String billType) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> billList = new ArrayList<Object[]>();
		// List<String> billList=new ArrayList<String>();
		String query = "";
		Session session = getSession();
		try {
			if (!HinNo.equals("")) {
				query = "select b.receipt_no,b.receipt_date from bl_receipt_header  b"
						+ " left outer join patient p on p.hin_id=b.hin_id"
						+ " where b.receipt_type= :billType  and p.hin_no = :HinNo ";
				billList = session.createSQLQuery(query).setParameter("billType", billType).setParameter("HinNo", HinNo).list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		/*
		 * billList=(List<BlOpBillHeader>)
		 * session.createCriteria(BlOpBillHeader.
		 * class).add(Restrictions.eq("hino", HinNo)); BillList =
		 * session.createCriteria(BlOpBillHeader.class).list();
		 * query="select b.bill_no from bl_op_bill_header  b"
		 * +" left outer join patient p on p.hin_id=b.hin_id"
		 * +" where p.hin_no ="+HinNo;
		 * billList=session.createSQLQuery(query).list();
		 */

		if (billList.size() > 0) {
			map.put("billList", billList);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDisBillNo(String HinNo, String tablename,
			String type, String dateField) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> billList = new ArrayList<Object[]>();
		// List<String> billList=new ArrayList<String>();
		String query = "";
		Session session = getSession();
		try {
			query = "select b."+type+",b."+dateField+" from "+tablename+" b"
					+ " left outer join patient p on p.hin_id=b.hin_id"
					+ " where p.hin_no = :HinNo ";
		/*	query = "select b.refund_no,b.refund_date from bl_refund_header b"
					+ " left outer join patient p on p.hin_id=b.hin_id"
					+ " where p.hin_no = :HinNo ";*/
			billList = session.createSQLQuery(query).setParameter("HinNo", HinNo).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		/*
		 * billList=(List<BlOpBillHeader>)
		 * session.createCriteria(BlOpBillHeader.
		 * class).add(Restrictions.eq("hino", HinNo)); BillList =
		 * session.createCriteria(BlOpBillHeader.class).list();
		 * query="select b.bill_no from bl_op_bill_header  b"
		 * +" left outer join patient p on p.hin_id=b.hin_id"
		 * +" where p.hin_no ="+HinNo;
		 * billList=session.createSQLQuery(query).list();
		 */

		if (billList.size() > 0) {
			map.put("billList", billList);
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBillingDetailsForSettlement(String finalBillno, String adNo) {
		System.out.println("in method of dataservice!!");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();
		List<BlReceiptHeader> receiptList = new ArrayList<BlReceiptHeader>();
		List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();

		BigDecimal netAmt = new BigDecimal(0);
		BigDecimal totalAdvAmt = new BigDecimal(0);
		BigDecimal totalRefundAmt = new BigDecimal(0);
		BigDecimal diffAmt = new BigDecimal(0);

		int inpatientId = 0;
		Session session = getSession();
		try {

			authorizerList = session.createCriteria(MasAuthorizer.class).add(
					Restrictions.eq("Status", "y")).list();

			bankList = session.createCriteria(MasBankMaster.class).add(
					Restrictions.eq("Status", "y")).list();
System.out.println("adNo ------ --->>"+adNo);
			finalBillList = session.createCriteria(BlFinalBillDetails.class)
					.add(Restrictions.eq("FinalBillNo", finalBillno)) 
					.createAlias("Inpatient","ip")
					.add(Restrictions.eq("ip.AdNo", adNo))
					.list();

			if (finalBillList.size() > 0) {
				for (BlFinalBillDetails finalBillDetails : finalBillList) {
					inpatientId = finalBillDetails.getInpatient().getId();
					netAmt = finalBillDetails.getNetAmt();
				}
				map.put("finalBillList", finalBillList);
			}
			System.out.println("finalBillList.size() ----------  >>"+finalBillList.size());
			
			
			// String[] rstype = {"adv","fs"};

			receiptList = session.createCriteria(BlReceiptHeader.class).add(
					Restrictions.eq("ReceiptType", "adv")).createAlias(
					"Inpatient", "ip").add(
					Restrictions.eq("ip.Id", inpatientId)).list();

			refundList = session.createCriteria(BlRefundHeader.class)
					.createAlias("Inpatient", "ip").add(
							Restrictions.eq("ip.Id", inpatientId)).list();

			if (receiptList.size() > 0) {
				for (BlReceiptHeader receiptHeader : receiptList) {
					totalAdvAmt = totalAdvAmt.add(receiptHeader.getAmount());
				}
			}
			if (refundList.size() > 0) {
				for (BlRefundHeader refundHeader : refundList) {
					totalRefundAmt = totalRefundAmt.add(refundHeader
							.getTotalRefundAmt());
				}
			}
			diffAmt = netAmt.subtract(totalAdvAmt);
			System.out.println(netAmt+"<<========>>"+totalAdvAmt);
			map.put("totalAdvAmt", totalAdvAmt);
			map.put("totalRefundAmt", totalRefundAmt);
			map.put("authorizerList", authorizerList);
			map.put("diffAmt", diffAmt);
			map.put("netAmt", netAmt);
			map.put("bankList", bankList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitBillingFinalSettlementDetails(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int hospitalId = 0;
		hospitalId = box.getInt("hospitalId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			int inpatientId = box.getInt(INPATIENT_ID);
			int hinId = box.getInt(HIN_ID);
			String transType = box.getString("transType");
			int patientTypeId = box.getInt("patientTypeId");
			BigDecimal settlement_charity = new BigDecimal(0);

			if (!box.getString(DISCOUNT_AMOUNT).equalsIgnoreCase(""))
				settlement_charity = new BigDecimal(
						box.getString(DISCOUNT_AMOUNT));
			BigDecimal totalAmount = new BigDecimal(0);
			System.out.println("totalAmt"+box.getString(TOTAL_AMOUNT));
			if (box.getString(TOTAL_AMOUNT)!=null && !box.getString(TOTAL_AMOUNT).equals("")) {
				totalAmount = new BigDecimal(box.getString(TOTAL_AMOUNT));
			}
			System.out.println("tota"+totalAmount);
			String receiptDate = box.getString(SETTLEMENT_DATE);
			String receiptTime = box.getString(SETTLEMENT_TIME);
			BigDecimal balanceAmt = new BigDecimal(
					box.getString(BALANCE_AMOUNT));
			int finalBillId = box.getInt("finalBillId");
			String billStatus = "";
		/*	if (patientTypeId == 1 || patientTypeId == 4) {
				billStatus = "s";
			} else {*/
				if (balanceAmt.compareTo(totalAmount) != 0) {
					billStatus = "u";
				} else if (balanceAmt.compareTo(totalAmount) == 0) {
					billStatus = "s";
				}
			/*}*/
			Vector paymentMode = box.getVector(PAYMENT_MODE);
			Vector amountVec = box.getVector(AMOUNT);
			Vector chequeNo = box.getVector(CHEQUE_NO);
			Vector chequeDate = box.getVector(CHEQUE_DATE);
			Vector bank = box.getVector(BANK_NAME);
			BigDecimal refund = new BigDecimal(0);
			BigDecimal amount = new BigDecimal(0);

			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

			Patient patient = new Patient();
			patient.setId(hinId);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);

			Users user = new Users();
			user.setId(box.getInt("userId"));

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------------------Saving Data into bl_receipt table
			if (totalAmount.compareTo(new BigDecimal(0)) >= 0) {
				if (transType.equals("Receipt")) {
					
					BlReceiptHeader receiptHeader = new BlReceiptHeader();
					receiptHeader.setReceiptNo(box.getString(SETTLEMENT_NO));
					receiptHeader.setHin(patient);
					receiptHeader.setInpatient(inpatient);
					BlFinalBillDetails finalBillDetails = new BlFinalBillDetails();
					finalBillDetails.setId(box.getInt("finalBillId"));
					receiptHeader.setIpFinalBill(finalBillDetails);

					receiptHeader.setReceiptType("fs");
					receiptHeader.setAmount(totalAmount);
					receiptHeader.setReceiptDate(HMSUtil
							.convertStringTypeDateToDateType(receiptDate));
					receiptHeader.setReceiptTime(receiptTime);
					receiptHeader.setHospital(hospital);
					receiptHeader.setChangedBy(user);
					hbt.save(receiptHeader);

					for (int i = 0; i < paymentMode.size(); i++) {
						BlReceiptDetails receiptDetails = new BlReceiptDetails();
						if (paymentMode.get(i) != null
								&& !paymentMode.get(i).equals("")) {
							receiptDetails.setReceiptHeader(receiptHeader);
							receiptDetails.setPaymentMode((String) paymentMode
									.get(i));
							if (amountVec.get(i) != null
									&& !amountVec.get(i).equals("")) {
								try {
									amount = new BigDecimal(
											(String) amountVec.get(i));
								} catch (Exception e) {
									amount = new BigDecimal(0);
								}
								receiptDetails.setAmount(amount);
							}
							if (chequeNo.get(i) != null
									&& !chequeNo.get(i).equals("")) {
								receiptDetails.setChequeNo((String) chequeNo
										.get(i));
							}
							if (chequeDate.get(i) != null
									&& !chequeDate.get(i).equals("")) {
								receiptDetails
										.setChequeDate(HMSUtil
												.convertStringTypeDateToDateType((String) chequeDate
														.get(i)));
							}
							if (bank.size() > 0) {
								if (bank.get(i) != null
										&& !bank.get(i).equals("0")) {
									MasBankMaster masBank = new MasBankMaster();
									masBank.setId(Integer.parseInt(bank.get(i)
											.toString()));
									receiptDetails.setBank(masBank);
								}
							}

							receiptDetails.setChangedBy(user);
							receiptDetails.setReceiptDate(date);
							receiptDetails.setReceiptTime(time);
							hbt.save(receiptDetails);
						}
					}
				} else if (transType.equals("Refund")) {
					
					BlRefundHeader blRefundHeader = new BlRefundHeader();
					blRefundHeader.setHin(patient);
					blRefundHeader.setInpatient(inpatient);
					blRefundHeader.setHospital(hospital);
					BlFinalBillDetails finalBillDetails = new BlFinalBillDetails();
					finalBillDetails.setId(box.getInt("finalBillId"));
					blRefundHeader.setFinalBill(finalBillDetails);
					//System.out.println("Refund No "+box.getString(SETTLEMENT_NO));
					blRefundHeader.setRefundNo(box.getString(SETTLEMENT_NO));
					blRefundHeader.setRefundDate(HMSUtil
							.convertStringTypeDateToDateType(receiptDate));
					blRefundHeader.setRefundTime(receiptTime);
					blRefundHeader.setTotalRefundAmt(totalAmount);
					blRefundHeader.setLastChgBy(user);
					blRefundHeader.setLastChgDate(date);
					blRefundHeader.setLastChgTime(time);
					blRefundHeader.setStatus("y");
					hbt.save(blRefundHeader);

					for (int i = 0; i < paymentMode.size(); i++) {
						BlRefundDetails blRefundDetails = new BlRefundDetails();
						if (paymentMode.get(i) != null
								&& !paymentMode.get(i).equals("")) {
							blRefundDetails.setRefundHeader(blRefundHeader);

							blRefundDetails.setPaymentMode((String) paymentMode
									.get(i));
							if (amountVec.get(i) != null
									&& !amountVec.get(i).equals("")) {
								refund = new BigDecimal(
										(String) amountVec.get(i));
								blRefundDetails.setRefundAmount(refund);
							}
							if (chequeNo.get(i) != null
									&& !chequeNo.get(i).equals("")) {
								blRefundDetails.setChequeNo((String) chequeNo
										.get(i));
							}
							if (chequeDate.get(i) != null
									&& !chequeDate.get(i).equals("")) {
								blRefundDetails
										.setChequeDate(HMSUtil
												.convertStringTypeDateToDateType((String) chequeDate
														.get(i)));
							}
							if (bank.size() > 0) {
								if (bank.get(i) != null
										&& !bank.get(i).equals("0")) {
									MasBankMaster masBank = new MasBankMaster();
									masBank.setId(Integer.parseInt(bank.get(i)
											.toString()));
									blRefundDetails.setBank(masBank);
								}
							}
							blRefundDetails.setLastChgBy(user);
							blRefundDetails.setLastChgDate(date);
							blRefundDetails.setLastChgTime(time);
							blRefundDetails.setStatus("y");
							hbt.save(blRefundDetails);
						}
					}
				}
			}
			try {
				BlFinalBillDetails finalBillDetails = (BlFinalBillDetails) hbt
						.load(BlFinalBillDetails.class, finalBillId);
				finalBillDetails.setStatus(billStatus);
				BigDecimal totalCharity = new BigDecimal(0);
				if (finalBillDetails.getSettledAmt() != null) {
					totalAmount = totalAmount.add(finalBillDetails
							.getSettledAmt());
				}
				if (settlement_charity != null
						&& settlement_charity.compareTo(new BigDecimal(0)) > 0) {
					/*finalBillDetails
							.setFinalSettlementCharity(settlement_charity);*/
					if (finalBillDetails.getDiscountAmt() != null) {
						totalCharity = finalBillDetails.getDiscountAmt().add(
								settlement_charity);
					} else {
						totalCharity = settlement_charity;
					}
					finalBillDetails.setDiscountAmt(totalCharity);

				}
				System.out.println("tota"+totalAmount);
				finalBillDetails.setSettledAmt(totalAmount);
				if (box.getInt(AUTHORIZER_ID) != 0) {
					MasAuthorizer authorizer = new MasAuthorizer();
					authorizer.setId(box.getInt(AUTHORIZER_ID));
					finalBillDetails.setAuthorizer(authorizer);
				}
				if (!box.getString(ROUND_OF_VALUE).equals("")) {
					finalBillDetails.setRoundOff(new BigDecimal(box
							.getString(ROUND_OF_VALUE)));
				}
				
				if (!box.getString("chrtTransfer").equals("")) {
					finalBillDetails.setFinalSettlementCharity(new BigDecimal(box
							.getString("chrtTransfer")));
					
					if (box.getInt("charityIdd")!=0) {
						MasCharityType type=new MasCharityType();
						type.setId(box.getInt("charityIdd"));
						finalBillDetails.setCharityType(type);
					}
					
				}
				
				if (!box.getString("advTransfer").equals("")) {
					finalBillDetails.setAdvanceTransfer(new BigDecimal(box
							.getString("advTransfer")));
				}
				
				
				
				
				hbt.update(finalBillDetails);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}

			BigDecimal pastDue = new BigDecimal(0);
			Patient hin = (Patient) hbt.load(Patient.class, hinId);
			if (hin.getPastDue() != null)
				pastDue = new BigDecimal(hin.getPastDue());

			BigDecimal newAmt = new BigDecimal(0);
			if (transType.equals("Receipt")) {
				newAmt = pastDue.subtract(totalAmount);
			}
			hin.setPastDue(newAmt.toString());
			hbt.update(hin);
			// -------------Accounts Entry-----------------------

			/*
			 * FaVoucherHeader voucherHeader = new FaVoucherHeader();
			 * voucherHeader.setVoucherNo(""); FaMasVoucherType voucherType =
			 * new FaMasVoucherType(); voucherType.setId(2);
			 * voucherHeader.setVoucherType(voucherType);
			 * voucherHeader.setLastChgBy(userName);
			 * voucherHeader.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(changedDate));
			 * voucherHeader.setLastChgTime(changedTime);
			 * voucherHeader.setCrBalance(totalAmount);
			 * voucherHeader.setDrBalance(totalAmount);
			 * voucherHeader.setHospital(hospital); if
			 * (transType.equals("Receipt")) {
			 * voucherHeader.setNaration("Final Settlement Receipt"); } if
			 * (transType.equals("Refund")) {
			 * voucherHeader.setNaration("Final Settlement Refund"); }
			 * voucherHeader.setStatus("y");
			 * voucherHeader.setLastChgBy(userName);
			 * voucherHeader.setVoucherDate(HMSUtil
			 * .convertStringTypeDateToDateType(receiptDate));
			 * voucherHeader.setVoucherTime(receiptTime);
			 * 
			 * hbt.save(voucherHeader);
			 *

			*
			 * if (paymentMode.size() > 0) { for (int k = 0; k <
			 * paymentMode.size(); k++) { if (!paymentMode.get(k).equals("")) {
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * BigDecimal amountRecvd = new BigDecimal(0);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital); FaMasAccount acc = new
			 * FaMasAccount(); FaMasSubLed subLed = new FaMasSubLed();
			 * 
			 * int accId = 0; int subAccId = 0;
			 * 
			 * if (transType.equals("Receipt")) { if
			 * (paymentMode.get(k).toString().equals("C")) {
			 * voucherDetails.setNaration("Cash Payment"); accId = 2; subAccId =
			 * 4; } else if (paymentMode.get(k).toString() .equals("Q") ||
			 * paymentMode.get(k).toString() .equals("R")) { voucherDetails
			 * .setNaration("Credit Card/Cheque Payment"); accId = 6; subAccId =
			 * 5; } acc.setId(accId); subLed.setId(subAccId);
			 * 
			 * if (!amountVec.get(k).equals("")) { amountRecvd = new
			 * BigDecimal(amountVec.get(k) .toString());
			 * voucherDetails.setDrBalance(amountRecvd); }
			 * 
			 * FaMasAccount accountObj = (FaMasAccount) hbt.load(
			 * FaMasAccount.class, accId); BigDecimal drBalance = new
			 * BigDecimal(0); if (accountObj.getDrBalance() != null) drBalance =
			 * accountObj.getDrBalance();
			 * accountObj.setDrBalance(drBalance.add(amountRecvd));
			 * hbt.update(accountObj);
			 * 
			 * FaMasSubLed masSubLed = (FaMasSubLed) hbt.load(
			 * FaMasSubLed.class, subAccId); BigDecimal subLedDrBalance = new
			 * BigDecimal(0); if (masSubLed.getDrBalance() != null)
			 * subLedDrBalance = masSubLed.getDrBalance();
			 * masSubLed.setDrBalance(subLedDrBalance .add(amountRecvd));
			 * hbt.update(masSubLed);
			 * 
			 * } else if (transType.equals("Refund")) { if
			 * (paymentMode.get(k).toString().equals("C")) {
			 * voucherDetails.setNaration("Cash Refund"); accId = 2; subAccId =
			 * 4;
			 * 
			 * } else if (paymentMode.get(k).toString() .equals("Q") ||
			 * paymentMode.get(k).toString() .equals("R")) {
			 * voucherDetails.setNaration("Cheque Refund"); accId = 6; subAccId
			 * = 5; } acc.setId(accId); subLed.setId(subAccId);
			 * 
			 * if (!amountVec.get(k).equals("")) { amountRecvd = new
			 * BigDecimal(amountVec.get(k) .toString());
			 * voucherDetails.setCrBalance(amountRecvd); }
			 * 
			 * FaMasAccount accountObj = (FaMasAccount) hbt.load(
			 * FaMasAccount.class, accId); BigDecimal crBalance = new
			 * BigDecimal(0); if (accountObj.getCrBalance() != null) crBalance =
			 * accountObj.getCrBalance();
			 * accountObj.setCrBalance(crBalance.add(amountRecvd));
			 * hbt.update(accountObj);
			 * 
			 * FaMasSubLed masSubLed = (FaMasSubLed) hbt.load(
			 * FaMasSubLed.class, subAccId); BigDecimal subLedCrBalance = new
			 * BigDecimal(0); if (masSubLed.getCrBalance() != null)
			 * subLedCrBalance = masSubLed.getCrBalance();
			 * masSubLed.setCrBalance(subLedCrBalance .add(amountRecvd));
		 * hbt.update(masSubLed); } voucherDetails.setAcc(acc);
			 * voucherDetails.setSubLed(subLed); voucherDetails.setStatus("y");
			 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(changedDate));
			 * voucherDetails.setLastChgTime(changedTime);
			 * voucherDetails.setLastChgBy(userName); hbt.save(voucherDetails);
			 * 
			 * } } }
			 *

			*
			 * FaVoucherDetails voucherDetails = new FaVoucherDetails();
			 * FaMasAccount acc = new FaMasAccount(); FaMasSubLed subLed = new
			 * FaMasSubLed(); int accountId = 0; int subAccId = 0; String
			 * naration = ""; if (transType.equals("Receipt")) { accountId = 10;
		 * subAccId = 9; naration = "Final Settlement Receipt";
			 * voucherDetails.setCrBalance(totalAmount); } else if
			 * (transType.equals("Refund")) { accountId = 11; subAccId = 8;
			 * naration = "Final Settlement Refund";
			 * voucherDetails.setDrBalance(totalAmount); } acc.setId(accountId);
			 * subLed.setId(subAccId); voucherDetails.setAcc(acc);
			 * voucherDetails.setSubLed(subLed);
			 * voucherDetails.setVoucherHeader(voucherHeader);
			 * voucherDetails.setHospital(hospital);
			 * voucherDetails.setNaration(naration);
			 * voucherDetails.setStatus("y");
		 * voucherDetails.setLastChgDate(HMSUtil
			 * .convertStringTypeDateToDateType(changedDate));
			 * voucherDetails.setLastChgTime(changedTime);
			 * voucherDetails.setLastChgBy(userName); hbt.save(voucherDetails);
			 * 
			 * FaMasAccount acntObj = (FaMasAccount)
			 * hbt.load(FaMasAccount.class, accountId); FaMasSubLed slObj =
			 * (FaMasSubLed) hbt.load(FaMasSubLed.class, subAccId); BigDecimal
			 * balance = new BigDecimal(0); BigDecimal slBalance = new
			 * BigDecimal(0);
			 * 
			 * if (transType.equals("Receipt")) { if (acntObj.getCrBalance() !=
			 * null) balance = acntObj.getCrBalance();
			 * acntObj.setCrBalance(balance.add(totalAmount));
			 * 
			 * if (slObj.getCrBalance() != null) slBalance =
			 * slObj.getCrBalance();
			 * slObj.setCrBalance(slBalance.add(totalAmount));
			 * 
			 * } else if (transType.equals("Refund")) { if
			 * (acntObj.getDrBalance() != null) balance =
			 * acntObj.getDrBalance();
			 * acntObj.setDrBalance(balance.add(totalAmount));
			 * 
			 * if (slObj.getDrBalance() != null) slBalance =
			 * slObj.getDrBalance();
			 * slObj.setDrBalance(slBalance.add(totalAmount));
			 * 
		 * } hbt.update(acntObj);
			 */
			
			// -------------Accounts Entry-----------------------
		tx.commit();
		session.flush();
			saved = true;
		} catch (DataAccessException e) {
			if (tx != null)
			tx.rollback();
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getReceiptDetailsForPatient(int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptList = new ArrayList<BlReceiptHeader>();
		Session session = getSession();
		String[] resType = { "chs", "bld", "pkb" };
		receiptList = session.createCriteria(BlReceiptHeader.class)
				.add(Restrictions.in("ReceiptType", resType))
				.createAlias("Inpatient", "ip")
				.add(Restrictions.eq("ip.Id", inpatientId)).list();
		map.put("receiptList", receiptList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForBillDispensing(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();
		List<BlFinalBillDetails> finalBlDtList = new ArrayList<BlFinalBillDetails>();
		List<MasPatientType> masPTypeList = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeLists = new ArrayList<MasPatientType>();
		List<MasPatientType> masPTypeListo = new ArrayList<MasPatientType>();
		List<MasCharityType> masCharityList = new ArrayList<MasCharityType>();

		String hinNo = "";
		String adNo = "";
		hinNo = box.getString("uhid");

		adNo = box.getString("ipNo");
		System.out.println("hinNo>>>>>>>>>>>>" + hinNo);
		System.out.println("adNo>>>>>>>>>>>>" + adNo);
		Session session = getSession();
		Criteria crit = null;

		try {
			finalBlDtList = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.AdNo", adNo)).list();

			if (finalBlDtList.size() == 0) {
				System.out.println("finalBlDtList check size>>>>>>>>>>>>"
						+ finalBlDtList.size());
				crit = session.createCriteria(Inpatient.class).add(
						Restrictions.in("AdStatus", new String[]{"A","R"}));
				if (!adNo.equals("")) {
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if (!hinNo.equals("")) {
					crit = crit.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", hinNo));
				}
				patientList = crit.list();
				System.out.println("patientList>>>>>>>" + patientList.size());
				for (Inpatient ip : patientList) {
					System.out.println("name" + ip.getHin().getPFirstName());
				}
				if (patientList.size() > 0)
					map.put("patientList", patientList);

			} else {
				String message = "Final Bill for patient is prepared.";
				map.put("message", message);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		masPTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "F").ignoreCase()).list();
		masPTypeLists = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "S").ignoreCase()).list();
		masPTypeListo = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Type", "O").ignoreCase()).list();
		masCharityList = session.createCriteria(MasCharityType.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		/*
		 * String maxBlNo = ""; String billType = "OS"; maxBlNo =
		 * generateBillNo(billType, "display"); map.put("maxBlNo", maxBlNo);
		 */
		//added by govind IP High level Medicine Billing 13-09-2017
		int hospitalId=box.getInt("hospitalId");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("employeeList", employeeList);
		//added by govind IP High level Medicine Billing end
		map.put("masCharityList", masCharityList);
		map.put("masPTypeList", masPTypeList);
		map.put("masPTypeLists", masPTypeLists);
		map.put("masPTypeListo", masPTypeListo);
		map.put("patientList", patientList);
		map.put("finalBlDtList", finalBlDtList);
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

             
			map.put("masCharityList", masCharityList);
			map.put("masPTypeList", masPTypeList);
			map.put("masPTypeLists", masPTypeLists);
			map.put("masPTypeListo", masPTypeListo);
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
	public Map<String, Object> getOrderNoForChargeSlip(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hin = "";
		String adNo = "";

		hin = box.getString(HIN_NO);
		adNo = box.getString(AD_NO);

		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		List<DgOrderhd> tempList = new ArrayList<DgOrderhd>();
		try {
			Session session = getSession();
			Criteria crit = null;

			crit = session.createCriteria(DgOrderhd.class).add(
					Restrictions.eq("PatientType", "IP"));
			if (!hin.equals("")) {
				crit = crit.createAlias("Hin", "p").add(
						Restrictions.eq("p.HinNo", hin));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			orderNoList = crit.list();

			if (orderNoList.size() > 0) {
				for (DgOrderhd orderhd : orderNoList) {
					boolean flag = false;
					Set<DgOrderdt> orderDtSet = new HashSet<DgOrderdt>();
					orderDtSet = orderhd.getDgOrderdts();
					for (DgOrderdt orderdt : orderDtSet) {
						if (orderdt.getPaymentMade().equals("n")) {
							flag = true;
							break;
						}
					}
					if (flag) {
						tempList.add(orderhd);
					}
				}
				map.put("orderNoList", tempList);
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
	public String generateDiagNumber(int subChargeId) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
		List<DgSampleCollectionDetails> dgDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<Integer> maxIdDgDetailsList = new ArrayList<Integer>();
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
					.add(Restrictions.idEq(maxIdDgDetailsList.get(0))).list();
			if (dgDetailsList.size() > 0) {
				lastDiagNo = dgDetailsList.get(0).getDiagNo();
				if (lastDiagNo == null) {
					lastDiagNo = "";
				}
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
	public Map<String, Object> searchChargeSlipForCancellation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();
		List<BlChargeSlipMain> chargeSlipDetailsList = new ArrayList<BlChargeSlipMain>();
		List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();

		String hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);
		int hospitalId = 0;

		if (box.getInt(HOSPITAL_ID) != 0)
			hospitalId = box.getInt(HOSPITAL_ID);

		Session session = getSession();

		try {
			Criteria criteria = null;
			criteria = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Hospital", "H");
			if (!hin.equals("")) {
				criteria = criteria.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hin))
						.add(Restrictions.eq("H.Id", hospitalId));
			}
			if (!adNo.equals("")) {
				criteria = criteria.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.AdNo", adNo))
						.add(Restrictions.eq("H.Id", hospitalId));
			}

			finalBillList = criteria.list();

			Criteria crit = null;

			if (finalBillList.size() == 0) {
				crit = session.createCriteria(BlChargeSlipMain.class).add(
						Restrictions.eq("Status", "y").ignoreCase());
				if (!hin.equals("")) {
					crit = crit.createAlias("Hin", "p").add(
							Restrictions.eq("p.HinNo", hin));
				}
				if (!adNo.equals("")) {
					crit = crit.createAlias("Inpatient", "ip").add(
							Restrictions.eq("ip.AdNo", adNo));
				}
				chargeSlipList = crit.list();

				for (BlChargeSlipMain blChargeSlipMain : chargeSlipList) {

					if (blChargeSlipMain.getBlReceiptHeaders() != null
							&& blChargeSlipMain.getBlReceiptHeaders().size() > 0) {
						if (blChargeSlipMain.getBlPaymentAdviceHeaders() != null
								&& blChargeSlipMain.getBlPaymentAdviceHeaders()
										.size() > 0) {
							List<BigDecimal> pymntAdvHdList = new ArrayList<BigDecimal>();
							pymntAdvHdList = session
									.createCriteria(BlPaymentAdviceHeader.class)
									.setProjection(
											Projections.sum("TotalAdviceAmt"))
									.createAlias("ChargeSlipMain", "csm")
									.add(Restrictions.eq("csm.Id",
											blChargeSlipMain.getId())).list();
							BigDecimal totalAdvAmt = pymntAdvHdList.get(0);
							if (totalAdvAmt.compareTo(blChargeSlipMain
									.getChgSlpAmt())<= 0) {
								chargeSlipDetailsList.add(blChargeSlipMain);
							}
						}
						else
						{
							chargeSlipDetailsList.add(blChargeSlipMain);
						}
					} else {
						chargeSlipDetailsList.add(blChargeSlipMain);
					}
				}
				map.put("chargeSlipList", chargeSlipDetailsList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean cancelChargeSlip(Box box) {
		boolean cancelFlag = false;
		Vector chargeSlipVec = box.getVector("chargeSlipDetailsId");
		String rsbyCardNo = "";
		int chargeCodeId = 0; // added by amit das on 03-10-2016
		int chargeSlipMainId = 0; // added by amit das on 03-10-2016
		Session session = null; // added by amit das on 03-10-2016
		List<DgOrderdt> dgOrderdtList = null; // added by amit das on 03-10-2016
		DgOrderdt dgOrderdt = null; // added by amit das on 03-10-2016
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		// added by amit das on 03-10-2016
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String cancellationTime = (String)utilMap.get("currentTime");
		String cancellationDate=(String)utilMap.get("currentDate");
		// ended by amit das on 03-10-2016
		
		try {
			session = (Session)getSession();  // added by amit das on 03-10-2016
		
			for (int i = 0; i < chargeSlipVec.size(); i++) {
				int chargeSlipId = Integer.parseInt(chargeSlipVec.get(i)
						.toString());
				BigDecimal osAmt = new BigDecimal(0.00);
				BigDecimal chargePercent = new BigDecimal(0.00);
				BigDecimal chargeAmt = new BigDecimal(0.00);
				double osAmtPerCharge = 0.00;
				BlChargeSlipDetail chargeSlipDetail = (BlChargeSlipDetail) hbt
						.load(BlChargeSlipDetail.class, chargeSlipId);
				chargeSlipDetail.setStatus("n");
				hbt.update(chargeSlipDetail);
				
				//Added by Amit Das on 03-10-2016
				chargeSlipMainId =  chargeSlipDetail.getChargeSlipMain().getId();
				chargeCodeId = chargeSlipDetail.getChargeCode().getId();
				dgOrderdtList =	session.createCriteria(DgOrderdt.class).add(Restrictions.eq("ChargeSlip.Id", chargeSlipMainId)).add(Restrictions.eq("ChargeCode.Id", chargeCodeId)).list();
				if(dgOrderdtList!=null && dgOrderdtList.size()>0){
					dgOrderdt =  dgOrderdtList.get(0);	
					dgOrderdt.setOrderStatus("X"); // for cancelling investigation
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(cancellationDate));
					dgOrderdt.setLastChgTime(cancellationTime);
					session.update(dgOrderdt);
				}
				//ended by Amit Das on 03-10-2016				
				
				
				
				// Added by Amit Das on 10-03-2016
				if(chargeSlipDetail.getInPkgFlag()!=null && chargeSlipDetail.getInPkgFlag().equalsIgnoreCase("y")){
					List<BlChargeSlipDetail> chargeSlipDetailsList =	getSession().createCriteria(BlChargeSlipDetail.class).add(Restrictions.eq("Id", chargeSlipDetail.getId())) 
									.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("InPkgFlag", "y").ignoreCase()).list();
					if(chargeSlipDetailsList==null || chargeSlipDetailsList.size()==0){
						BlChargeSlipMain  chargeSlipMain = hbt.load(BlChargeSlipMain.class, chargeSlipDetail.getChargeSlipMain().getId());
						if(chargeSlipMain!=null){
							chargeSlipMain.setStatus("n");
							hbt.update(chargeSlipMain);
							
							List<Patient> patientList   = getSession().createCriteria(Patient.class).add(Restrictions.eq("HinNo", box.getString("hinNo"))).list();
							BlPackageHeader blPackageHeader = hbt.load(BlPackageHeader.class, chargeSlipMain.getPackage().getId());	
							
							if(patientList!=null && patientList.size()!=0)
								rsbyCardNo = patientList.get(0).getRsbyCardNo();
							
							if(blPackageHeader!=null && blPackageHeader.getScheme()!=null) {
							List<RsbyCardDetails> rsbyCardDetails =	getSession().createCriteria(RsbyCardDetails.class).add(Restrictions.eq("RsbyCardNo", rsbyCardNo))
									.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("PkgScheme", blPackageHeader.getScheme())).list();
							if(rsbyCardDetails!=null && rsbyCardDetails.size()!=0){
								rsbyCardDetails.get(0).setBalanceUtilized(rsbyCardDetails.get(0).getBalanceUtilized().subtract(blPackageHeader.getTotalValueOfPackage()));
								hbt.update(rsbyCardDetails.get(0));
								
							}
							
							}
						}
					}
				}
                // end of code by Amit Das
				
				
				if (chargeSlipDetail.getChargeSlipMain().getOsAmt() != null) {
					osAmt = chargeSlipDetail.getChargeSlipMain().getOsAmt();
				}
				if (chargeSlipDetail.getNetAmt() != null) {
					chargeAmt = chargeSlipDetail.getNetAmt();
				}
				 System.out.println("osAmt------"+osAmt);
				chargePercent = (chargeSlipDetail.getNetAmt().multiply(
						new BigDecimal(100)).divide(chargeSlipDetail
						.getChargeSlipMain().getNetAmt(), 2,
						RoundingMode.HALF_UP));
				osAmtPerCharge = Math.round((osAmt.multiply(chargePercent))
						.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)
						.doubleValue());
                  System.out.println("osAmtPerCharge"+osAmtPerCharge);
				/*if (chargeSlipDetail.getChargeSlipMain()
						.getBlPaymentAdviceHeaders().size() == 0
						&& osAmt.compareTo(new BigDecimal(0.00)) > 0) {
					BigDecimal pastdue = new BigDecimal(0.00);
					Patient patient = (Patient) hbt.load(Patient.class,
							chargeSlipDetail.getChargeSlipMain().getHin()
									.getId());
					if (patient.getPastDue() != null) {
						pastdue = (new BigDecimal(patient.getPastDue()));
					}
					pastdue = pastdue.subtract(new BigDecimal(osAmtPerCharge));
					patient.setPastDue(pastdue.toString());
					hbt.update(patient);

				}*/
				/*if (chargeSlipDetail.getChargeSlipMain()
						.getBlPaymentAdviceHeaders().size() == 0
						&& osAmt.compareTo(new BigDecimal(0.00)) > 0) {*/
					BigDecimal pastdue = new BigDecimal(0.00);
					Patient patient = (Patient) hbt.load(Patient.class,
							chargeSlipDetail.getChargeSlipMain().getHin()
									.getId());
					if (patient.getPastDue() != null) {
						pastdue = (new BigDecimal(patient.getPastDue()));
					}
					pastdue = pastdue.add(chargeAmt);
					patient.setPastDue(pastdue.toString());
					hbt.update(patient);

			/*	}*/
				
				/*
				 * BlChargeSlipMain chargeSlipMain = (BlChargeSlipMain)
				 * hbt.load( BlChargeSlipMain.class, chargeSlipId);
				 * chargeSlipMain.setStatus("n"); hbt.update(chargeSlipMain);
				 * if(chargeSlipMain.getOsAmt() != null){ osAmt =
				 * chargeSlipMain.getOsAmt(); }
				 * if(chargeSlipMain.getBlPaymentAdviceHeaders().size() == 0 &&
				 * osAmt.compareTo(new BigDecimal(0.00)) > 0){ BigDecimal
				 * pastdue = new BigDecimal(0.00); Patient patient =
				 * (Patient)hbt.load(Patient.class,
				 * chargeSlipMain.getHin().getId()); if(patient.getPastDue() !=
				 * null){ pastdue = (new BigDecimal(patient.getPastDue())); }
				 * pastdue = pastdue.subtract(osAmt) ;
				 * patient.setPastDue(pastdue.toString()); hbt.update(patient);
				 * 
				 * }
				 */
			}

			cancelFlag = true;
			hbt.flush();
			hbt.clear();
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return cancelFlag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchChargeSlipNoForPymntAdv(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlChargeSlipMain> chargeSlipMainList = new ArrayList<BlChargeSlipMain>();
		List<BlChargeSlipMain> chargeSlipNoList = new ArrayList<BlChargeSlipMain>();
		Set<BlChargeSlipDetail> detailsSet = new HashSet<BlChargeSlipDetail>();
		List<BlReceiptHeader> receList = new ArrayList<BlReceiptHeader>();

		String hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);

		Session session = getSession();
		Criteria crit = null;
		crit = session.createCriteria(BlChargeSlipMain.class).add(
				Restrictions.eq("Status", "y").ignoreCase());

		if (!hin.equals("")) {
			crit = crit.createAlias("Hin", "p").add(
					Restrictions.eq("p.HinNo", hin));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		chargeSlipMainList = crit.list();

		List<BlFinalBillDetails> finalBillList = new ArrayList<BlFinalBillDetails>();
		if (!adNo.equals("")) {
			finalBillList = session.createCriteria(BlFinalBillDetails.class)
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.AdNo", adNo)).list();

		}
		if (finalBillList.size() == 0) {

			if (chargeSlipMainList.size() > 0) {
				for (BlChargeSlipMain chargeSlipMain : chargeSlipMainList) {
					receList = session
							.createCriteria(BlReceiptHeader.class)
							.createAlias("ChargeSlipMain", "csm")
							.add(Restrictions.eq("csm.Id",
									chargeSlipMain.getId())).list();
					if (receList.size() > 0) {

						boolean refunded = true;
						detailsSet = chargeSlipMain.getBlChargeSlipDetails();
						for (BlChargeSlipDetail obj : detailsSet) {
							if (obj.getRefundableStatus().equals("y")) {
								refunded = false;
								break;
							}
						}
						if (refunded == false) {
							chargeSlipNoList.add(chargeSlipMain);
							map.put("chargeSlipNoList", chargeSlipNoList);
						}
					}
				}
			}
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForPaymentAdviceChargeSlip(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();
		List<BlChargeSlipMain> chargeSlipMainList = new ArrayList<BlChargeSlipMain>();
		List<BlPaymentAdviceDetails> payAdvList = new ArrayList<BlPaymentAdviceDetails>();
		List<BlRefundHeader> refundList = new ArrayList<BlRefundHeader>();
		Set<BlChargeSlipDetail> detailsSet = new HashSet<BlChargeSlipDetail>();
		int chargeSlipNo = 0;
		String hin = "";
		chargeSlipNo = box.getInt(CHARGE_SLIP_NO);
		hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);

		Session session = getSession();
		Criteria crit = null;

		try {
			crit = session.createCriteria(BlChargeSlipMain.class).add(
					Restrictions.eq("ChargeSlipNo", chargeSlipNo));
			if (!hin.equals("")) {
				crit = crit.createAlias("Hin", "p").add(
						Restrictions.eq("p.HinNo", hin));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			chargeSlipMainList = crit.list();

			if (chargeSlipMainList.size() > 0) {
				for (BlChargeSlipMain chargeSlipMain : chargeSlipMainList) {
					boolean refunded = true;
					detailsSet = chargeSlipMain.getBlChargeSlipDetails();
					for (BlChargeSlipDetail obj : detailsSet) {
						if (obj.getRefundableStatus().equals("y")) {
							refunded = false;
							break;
						}
					}
					if (refunded == false) {
						chargeSlipList.add(chargeSlipMain);
						map.put("chargeSlipList", chargeSlipList);
					}
				}
			}

			payAdvList = session.createCriteria(BlPaymentAdviceDetails.class)
					.createAlias("PaymentAdviceHeader", "pah")
					.createAlias("pah.ChargeSlipMain", "cs")
					.add(Restrictions.eq("cs.ChargeSlipNo", chargeSlipNo))
					.list();

			if (payAdvList.size() > 0) {
				map.put("payAdvList", payAdvList);
			}
			refundList = session.createCriteria(BlRefundHeader.class)
					.setProjection(Projections.sum("TotalRefundAmt"))
					.createAlias("PymntAdvServ", "pah")
					.createAlias("pah.ChargeSlipMain", "cs")
					.add(Restrictions.eq("cs.ChargeSlipNo", chargeSlipNo))
					.list();
			if (refundList.size() > 0) {
				map.put("refundList", refundList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchBillForCancellation(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<BlDispensingHeader> dispensingList = new ArrayList<BlDispensingHeader>();
		List<BlDispensingHeader> dispensingBillDetailsList = new ArrayList<BlDispensingHeader>();

		String hin = box.getString(HIN_NO);
		String adNo = box.getString(AD_NO);

		Session session = getSession();

		try {
			Criteria crit = null;

			crit = session.createCriteria(BlDispensingHeader.class).add(
					Restrictions.eq("Status", "y").ignoreCase());
			if (!hin.equals("")) {
				crit = crit.createAlias("Hin", "p").add(
						Restrictions.eq("p.HinNo", hin));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			dispensingList = crit.list();

			for (BlDispensingHeader dispensingHeader : dispensingList) {

				try {
					if (dispensingHeader.getBlReceiptHeaders() != null
							&& dispensingHeader.getBlReceiptHeaders().size() > 0) {
						if (dispensingHeader.getBlPymntAdviceDispHeaders() != null
								&& dispensingHeader
										.getBlPymntAdviceDispHeaders().size() > 0) {
							List<BigDecimal> pymntAdvHdList = new ArrayList<BigDecimal>();
							pymntAdvHdList = session
									.createCriteria(
											BlPymntAdviceDispHeader.class)
									.setProjection(
											Projections.sum("TotalAdviceAmt"))
									.createAlias("BillDispensing", "bd")
									.add(Restrictions.eq("bd.Id",
											dispensingHeader.getId())).list();
							BigDecimal totalAdvAmt = pymntAdvHdList.get(0);
							if (totalAdvAmt.compareTo(dispensingHeader
									.getBillAmt()) == 0) {

								dispensingBillDetailsList.add(dispensingHeader);
							}
						}
					} else {

						dispensingBillDetailsList.add(dispensingHeader);
					}
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

			}

			map.put("dispensingBillDetailsList", dispensingBillDetailsList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;

	}

	@SuppressWarnings("unchecked")
	public boolean cancelBillDispensing(Box box) {
		boolean cancelFlag = false;
		Vector billIdVec = box.getVector("dispensingHeaderId");
		int billId = 0;
		int hinId = 0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		BigDecimal osAmt = new BigDecimal(0);
		BigDecimal pastDue = new BigDecimal(0);

		try {
			for (int i = 0; i < billIdVec.size(); i++) {
				billId = Integer.parseInt(billIdVec.get(i).toString());
				BlDispensingHeader dispensingHeader = (BlDispensingHeader) hbt
						.load(BlDispensingHeader.class, billId);

				if (dispensingHeader.getOutstanding() != null) {
					hinId = dispensingHeader.getHin().getId();
					osAmt = dispensingHeader.getOutstanding();
				}
				if (dispensingHeader.getAdvAdjustment() != null) {
					hinId = dispensingHeader.getHin().getId();
					osAmt = dispensingHeader.getAdvAdjustment();
				}
				dispensingHeader.setStatus("n");
				hbt.update(dispensingHeader);
			}
			if (osAmt.compareTo(new BigDecimal(0)) > 0) {
				Patient patient = (Patient) hbt.load(Patient.class, hinId);
				if (patient.getPastDue() != null) {
					pastDue = new BigDecimal(patient.getPastDue());
				}
				patient.setPastDue((pastDue.subtract(osAmt)).toString());
				hbt.update(patient);
			}

			cancelFlag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return cancelFlag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPharmacySalesDetails(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<OpdPatientDetails> opdPatientList = new ArrayList<OpdPatientDetails>();
		List<Object[]> visitList = new ArrayList<Object[]>();
		List<Object[]> tempVisitList = new ArrayList<Object[]>();
		List<Object[]> tempVisitList2 = new ArrayList<Object[]>();
		Set<String> uniquePatientSet=new HashSet<String>();
		Map<String, Object[]> uniqueVisit=new HashMap<String,Object[]>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		String message = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		MasHospital masHospital;
		String emp_code_doctor = null;
		if (!box.getString(RequestConstants.FROM_DATE).equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(RequestConstants.FROM_DATE));
		if (!box.getString(RequestConstants.TO_DATE).equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(RequestConstants.TO_DATE));

		int tokenNo = 0;
		String hinNo = "";
		String patName = "";
		String mobileNo = "";
		int doctorId = 0;
		int deptId = 0;
		int loggedDepartmentId = 0;
		int hospitalId = 0;
		int phramacyDeptId = 0;
		String multiPharmacyCheck;

		if (!box.getString(RequestConstants.DEPT_ID).equals("")) {
			phramacyDeptId = box.getInt(RequestConstants.DEPT_ID);
		}
		if (!box.getString(RequestConstants.FROM_WARD).equals("")) {
			deptId = box.getInt(RequestConstants.FROM_WARD);
		}

		if (!box.getString(RequestConstants.HOSPITAL_ID).equals("")) {
			hospitalId = box.getInt(RequestConstants.HOSPITAL_ID);
		}

		if (!box.getString(RequestConstants.TOKEN_NO).equals("")) {
			tokenNo = box.getInt(RequestConstants.TOKEN_NO);
		}

		if (!box.getString(RequestConstants.HIN_NO).equals("")) {
			hinNo = box.getString(RequestConstants.HIN_NO);
		}

		if (!box.getString(RequestConstants.P_FIRST_NAME).equals("")) {
			patName = box.getString(RequestConstants.P_FIRST_NAME);
		}

		if (!box.getString(RequestConstants.MOBILE_NO).equals("")) {
			mobileNo = box.getString(RequestConstants.MOBILE_NO);
		}

		if (!box.getString(RequestConstants.DOCTOR_NAME).equals("")) {
			doctorId = box.getInt(RequestConstants.DOCTOR_NAME);
		}
		
		loggedDepartmentId = box.getInt("deptId");
		
		

		try {

			Properties properties1 = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("table_constant.properties");
			try {
				properties1.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}

			emp_code_doctor = properties1
					.getProperty("mas_emp_category_doctor");
			
			
			masHospital	= (MasHospital)session.get(MasHospital.class, hospitalId);
			multiPharmacyCheck = masHospital.getMultiPharmacy();
			
			departmentList = session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.Id",1))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();

			employeeList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.createAlias("EmpCategory", "EC")
					.add(Restrictions.eq("EC.EmpCategoryCode", emp_code_doctor))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId)).list();

		
			Criteria criteria = session
						.createCriteria(PatientPrescriptionHeader.class, "pph").createAlias("pph.PatientPrescriptionDetails", "ppd",CriteriaSpecification.LEFT_JOIN).createAlias("ppd.Item", "i",CriteriaSpecification.LEFT_JOIN)
						.createAlias("PharmacyLabQueue", "pharmacyLabQueue")
						.createAlias("Visit", "v")
						.createAlias("v.Hin", "h")
						.add(Restrictions.eq("pph.Hospital.Id", hospitalId))
						.add(Restrictions.between("v.VisitDate", fromDate,
								toDate))
						.add(Restrictions.or(Restrictions.eq("h.PatientStatus", "Out Patient"), Restrictions.eq("DischargeMedicationStatus", "Y").ignoreCase()))
						//.add(Restrictions.eq("h.PatientStatus", "Out Patient"))
						.add(Restrictions.eq("v.CurPharVisitStatus", "y").ignoreCase())
						.add(Restrictions.ne("pharmacyLabQueue.Status", "C".toLowerCase()))
								.addOrder(Order.asc("pharmacyLabQueue.TokenNo"))
						.setProjection(
								Projections
										.projectionList().add(Projections.distinct(Projections.property("v.Id")))
										.add(Projections.property("pharmacyLabQueue.TokenNo"))
										.add(Projections.property("h.HinNo"))
										.add(Projections.property("h.Id"))
										.add(Projections
												.property("h.PFirstName"))
										.add(Projections
												.property("v.Department"))
										.add(Projections.property("v.Doctor"))
										.add(Projections
												.property("v.VisitDate"))
										.add(Projections.property("pph.Id"))
										.add(Projections.property("v.Id"))
										.add(Projections.property("v.TokenNo")));

				if (tokenNo != 0) {
					criteria = criteria.add(Restrictions.eq("v.TokenNo",
							tokenNo));
				}
				if (hinNo != null && !hinNo.equals("")) {
					criteria = criteria.add(Restrictions.eq("h.HinNo", hinNo));
				}
				if (patName != null && !patName.equals("")) {
					
                    criteria.add(Restrictions.or
							(Restrictions.or(Restrictions.like("h.PFirstName", "%"+patName+"%").ignoreCase(), Restrictions.like("h.PMiddleName", "%"+patName+"%").ignoreCase())
											,Restrictions.like("h.PLastName", "%"+patName+"%").ignoreCase()
							)
						);
                    
				}

				if (!"".equals(mobileNo)) {
					criteria = criteria.add(Restrictions.eq("h.MobileNumber",
							mobileNo));
				}
				if (doctorId != 0) {
					criteria = criteria.add(Restrictions.eq("v.Doctor.Id",
							doctorId));
				}
				if (deptId != 0) {
					criteria = criteria.add(Restrictions.eq("v.Department.Id",
							deptId));
				}
				
				if (multiPharmacyCheck != null && multiPharmacyCheck.equalsIgnoreCase("y")) {
					
						List<Integer> masInstituteDepartmentList = session.createCriteria(MultiDepartmentMapping.class)
								.createAlias("ServiceCenter","s")
								.createAlias("ParentServiceCenter","p")
								.createAlias("p.Department","pd")
								.add(Restrictions.eq("s.Institute.Id", hospitalId)).add(Restrictions.eq("s.Department.Id", loggedDepartmentId))
								.setProjection(Projections.groupProperty("pd.Id")) .list();
						
						if(masInstituteDepartmentList.size()==0)
							masInstituteDepartmentList.add(0);
							
							criteria = criteria.add(Restrictions.in("pph.Department.Id",
											masInstituteDepartmentList));
						
				}
					
				
				criteria.addOrder(Order.asc("v.TokenNo"));
				
				tempVisitList = criteria.list();
				
/*Added By Srikanth 2017-11-21 Start*/
				
				Criteria criteria2 = session
						.createCriteria(PatientPrescriptionHeader.class, "pph").createAlias("pph.PatientPrescriptionDetails", "ppd",CriteriaSpecification.LEFT_JOIN).createAlias("ppd.Item", "i",CriteriaSpecification.LEFT_JOIN)
						.createAlias("PharmacyLabQueue", "pharmacyLabQueue")
						.createAlias("Visit", "v")
						.createAlias("v.Hin", "h")
						.add(Restrictions.eq("pph.Hospital.Id", hospitalId))
						/*.add(Restrictions.between("v.VisitDate", fromDate,
								toDate))*/
						.add(Restrictions.eq("v.Department.Id", 1))		
						.add(Restrictions.eq("h.PatientStatus", "Out Patient"))
						.add(Restrictions.eq("v.CurPharVisitStatus", "y").ignoreCase())
						.add(Restrictions.ne("pharmacyLabQueue.Status", "C".toLowerCase()))
								.addOrder(Order.asc("pharmacyLabQueue.TokenNo"))
						.setProjection(
								Projections
										.projectionList().add(Projections.distinct(Projections.property("v.Id")))
										//.add(Projections.property("v.TokenNo"))
										.add(Projections.property("pharmacyLabQueue.TokenNo"))
										.add(Projections.property("h.HinNo"))
										.add(Projections.property("h.Id"))
										.add(Projections
												.property("h.PFirstName"))
										.add(Projections
												.property("v.Department"))
										.add(Projections.property("v.Doctor"))
										.add(Projections
												.property("v.VisitDate"))
										.add(Projections.property("pph.Id"))
										.add(Projections.property("v.Id"))//added by govind 25-08-2017
										.add(Projections.property("v.TokenNo"))

						);

				if (tokenNo != 0) {
					criteria2 = criteria2.add(Restrictions.eq("v.TokenNo",
							tokenNo));
				}
				if (hinNo != null && !hinNo.equals("")) {
					criteria2 = criteria2.add(Restrictions.eq("h.HinNo", hinNo));
				}
				if (patName != null && !patName.equals("")) {
					
					//criteria = criteria.add(Restrictions.like("h.PFirstName",
						//	patName).ignoreCase()); changed by govind 12-10-2016					

					criteria2.add(Restrictions.or
							(Restrictions.or(Restrictions.like("h.PFirstName", "%"+patName+"%").ignoreCase(), Restrictions.like("h.PMiddleName", "%"+patName+"%").ignoreCase())
											,Restrictions.like("h.PLastName", "%"+patName+"%").ignoreCase()
							)
						);
                    //changed by govind 12-10-2016 end
				}

				if (!"".equals(mobileNo)) {
					criteria2 = criteria2.add(Restrictions.eq("h.MobileNumber",
							mobileNo));
				}
				if (doctorId != 0) {
					criteria2 = criteria2.add(Restrictions.eq("v.Doctor.Id",
							doctorId));
				}
				if (deptId != 0) {
					criteria2 = criteria2.add(Restrictions.eq("v.Department.Id",
							deptId));
				}
				criteria2.addOrder(Order.asc("v.TokenNo"));
				
				tempVisitList2=criteria2.list();
				
				tempVisitList.addAll(tempVisitList2);
				/*Added By Srikanth 2017-11-21 End*/
			
			if (tempVisitList != null && tempVisitList.size()> 0) {  
				for(Object[] visitListObj : tempVisitList){	
            	 uniqueVisit.put(visitListObj[1].toString().trim(), visitListObj);
            	 uniquePatientSet.add(visitListObj[1].toString().trim());
            	 visitList.add(visitListObj);//added by arbind on 21-Jan-2017
				} 	
		}	
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		Map<Integer,Object> doctorMap=new HashMap<Integer,Object>();
		for(Object[] vis:visitList){
			Integer id=(Integer)vis[9];
			opdPatientList=session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id",id)).list();
			if(opdPatientList.size()>0){
				OpdPatientDetails opd=opdPatientList.get(0);
				doctorMap.put(id, opd);
			}
		}
		System.out.println("doctorMap "+doctorMap.size());
		map.put("doctorMap", doctorMap);
		map.put("visitList", visitList);
		map.put("message", message);
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
       map.put("deptId", deptId);
       map.put("hospitalId", hospitalId);
       map.put("tokenNo", tokenNo);
       map.put("hinNo", hinNo);
       map.put("patName", patName);
       map.put("mobileNo", mobileNo);
       map.put("doctorId", doctorId);
       map.put("phramacyDeptId", phramacyDeptId);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemWiseDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlDispensingDetails> dispensingBatchDetailsList = new ArrayList<BlDispensingDetails>();
		int dispensingId = box.getInt("dispensingId");

		Session session = getSession();
		dispensingBatchDetailsList = session
				.createCriteria(BlDispensingDetails.class)
				.createAlias("DispensingHeader", "dh")
				.add(Restrictions.eq("dh.Id", dispensingId)).list();

		map.put("dispensingBatchDetailsList", dispensingBatchDetailsList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemBatchDetails(int itemId, int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> itemBatchList = new ArrayList<Object[]>();
		Session session = getSession();

		String qry = " SELECT dh.bill_no,ibs.batch_no,dd.qty,dd.amount,sum(padd.advice_qty),sum(padd.advice_amt) FROM bl_dispensing_details dd"
				+ " left join store_item_batch_stock ibs on dd.batch_id=ibs.stock_id"
				+ " left join bl_dispensing_header dh on dh.dispensing_header_id = dd.dispensing_header_id"
				+ " left join bl_pymnt_advice_disp_header padh on dh.dispensing_header_id = padh.bill_dispensing_id"
				+ " left join bl_pymnt_advice_disp_details padd on padh.pymnt_advice_disp_header_id = padd.pymnt_advice_disp_header_id"
				+ " where dd.item_id="
				+ itemId
				+ " and dh.status = 'y' and (padd.advice_amt != dd.amount or padd.advice_amt is null)  and dh.inpatient_id= '"
				+ inpatientId
				+ "' "
				+ " and padd.batch_id = dd.batch_id group by dd.batch_id, dh.bill_no, ibs.batch_no, dd.qty, dd.amount ";

		itemBatchList = session.createSQLQuery(qry).list();
		map.put("itemBatchList", itemBatchList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getEmployeeList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();

		Session session = getSession();

		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("employeeList", employeeList);
		map.put("patientTypeList", patientTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getHospitalName(int hospitalId) {
		List<String> hospitalList = new ArrayList<String>();
		String hospitalName = "";

		Session session = getSession();

		hospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.property("HospitalName")).list();

		hospitalName = hospitalList.get(0);
		return hospitalName;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAccountRegister() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlAccountType> blAccountTypeList = new ArrayList<BlAccountType>();
		Session session = getSession();
		blAccountTypeList = session.createCriteria(BlAccountType.class).list();
		map.put("blAccountTypeList", blAccountTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDepartmentWiseCash() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = getSession();
		masDepartmentList = session.createCriteria(MasDepartment.class).list();
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	public Map<String, Object> showUserList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		Session session = getSession();
		userList = session.createCriteria(Users.class).list();
		map.put("userList", userList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getInpatientId(String adNo) {
		int inpatientId = 0;
		List<Inpatient> inpatientIdList = new ArrayList<Inpatient>();
		Session session = getSession();
		try {
			inpatientIdList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("AdNo", adNo)).list();
			// .setProjection( Projections.property("Id")).list();

			if (inpatientIdList.size() > 0) {
				inpatientId = (Integer) inpatientIdList.get(0).getId();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}// k{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		return inpatientId;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCompanyList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();
		Session session = getSession();
		companyList = session.createCriteria(MasCompany.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("PatientType", "pt")
				.add(Restrictions.eq("pt.PatientTypeCode", "COM")).list();
		if (companyList.size() > 0) {
			map.put("companyList", companyList);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAuthorizrList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		Session session = getSession();
		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (authorizerList.size() > 0) {
			map.put("authorizerList", authorizerList);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForOrderBooking(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		if (box.get("deptId") != null) {
			deptId = box.getInt("deptId");
		}
		int hospitalId = box.getInt(HOSPITAL_ID);
		try {
			crit = session.createCriteria(Inpatient.class)
					// .add(Restrictions.ne("AdStatus", "D"))
					.add(Restrictions.ne("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", box.getInt("parent")));
			patientDetailsList = crit.list();
			if (patientDetailsList.size() > 0) {
				map.put("patientDetailsList", patientDetailsList);
			}
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.add(Restrictions.ne("Hospital.Id", hospitalId)).list();
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.add(Restrictions.eq("Id", deptId)).list();

			map.put("employeeList", employeeList);
			map.put("departmentList", departmentList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> viewPrescriptionForOrderBooking(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<InpatientPrescriptionHeader> inPatientPrescriptionList = new ArrayList<InpatientPrescriptionHeader>();
		List<InpatientPrescriptionDetails> inPatientPrescriptionDetailsList = new ArrayList<InpatientPrescriptionDetails>();

		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		if (box.get("deptId") != null) {
			deptId = box.getInt("deptId");
		}
		try {
			crit = session.createCriteria(Inpatient.class)
					.add(Restrictions.ne("AdStatus", "D"))
					.add(Restrictions.eq("Id", box.getInt(INPATIENT_ID)));
			patientDetailsList = crit.list();
			if (patientDetailsList.size() > 0) {
				map.put("patientDetailsList", patientDetailsList);
			}

			inPatientPrescriptionList = session
					.createCriteria(InpatientPrescriptionHeader.class)
					.add(Restrictions.eq("Status", "p").ignoreCase())
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Inpatient.Id",
							box.getInt(INPATIENT_ID))).list();
			int ipheader = 0;
			for (InpatientPrescriptionHeader header : inPatientPrescriptionList) {
				ipheader = header.getId();
			}
			inPatientPrescriptionDetailsList = session
					.createCriteria(InpatientPrescriptionDetails.class)
					.add(Restrictions.eq("Prescription.Id", ipheader)).list();

			map.put("inPatientPrescriptionDetailsList",
					inPatientPrescriptionDetailsList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitOrderBookingDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		boolean saved = false;
		int hinId = box.getInt(HIN_ID);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		Session session = getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------Saving Data into BlChargeSlipMain Table--------

			BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
			Patient patient = new Patient();
			patient.setId(hinId);
			blChargeSlipMain.setHin(patient);

			Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt(INPATIENT_ID));
			blChargeSlipMain.setInpatient(inpatient);
			MasHospital hospital = new MasHospital();

			hospital.setId(box.getInt("hospitalId"));
			blChargeSlipMain.setHospital(hospital);

			blChargeSlipMain.setChargeSlipNo(box.getInt("chargeSlipNo"));
			blChargeSlipMain.setChgSlpAmt(new BigDecimal(box
					.getInt(TOTAL_AMOUNT)));
			BigDecimal payableAmt = new BigDecimal(box.getInt(PAYABLE_AMOUNT));
			blChargeSlipMain.setReceiptAmt(payableAmt);
			BigDecimal osAmt = new BigDecimal(0);
			osAmt = new BigDecimal(box.getInt(OUTSTANDING));
			blChargeSlipMain.setOsAmt(osAmt);
			if (!box.getString(DISCOUNT_ON_BILL).equals(""))
				blChargeSlipMain.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_ON_BILL)));

			if (!box.getString(DISCOUNT_AMOUNT).equals(""))
				blChargeSlipMain.setDiscountAmt(new BigDecimal(box
						.getString(DISCOUNT_AMOUNT)));

			if (!box.getString(TOTAL_NET_AMOUNT).equals(""))
				blChargeSlipMain.setNetAmt(new BigDecimal(box
						.getString(TOTAL_NET_AMOUNT)));

			if (!box.getString(ROUND_OF_VALUE).equals("")) {
				blChargeSlipMain.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (box.getInt(AUTHORIZER_ID) != 0) {
				MasAuthorizer authorizer = new MasAuthorizer();
				authorizer.setId(box.getInt(AUTHORIZER_ID));
				blChargeSlipMain.setAuthorizer(authorizer);
			}
			if (!box.getString("compDiscount").equals("")) {
				blChargeSlipMain.setDiscount(new BigDecimal(box
						.getString("compDiscount")));
			}
			if (!box.getString("charity").equals("")) {
				blChargeSlipMain.setCharity(new BigDecimal(box
						.getString("charity")));
			}
			if (box.getInt(PATIENT_TYPE_ID) != 0) {
				MasPatientType patientType = new MasPatientType();
				patientType.setId(box.getInt(PATIENT_TYPE_ID));
				blChargeSlipMain.setPatientType(patientType);
			}
			if (box.getInt("companyId") != 0) {
				MasCompany company = new MasCompany();
				company.setId(box.getInt("companyId"));
				blChargeSlipMain.setCompany(company);
			}
			blChargeSlipMain.setChgSlpDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setChgSlpTime(time);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			blChargeSlipMain.setLastChgBy(user);
			blChargeSlipMain.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			blChargeSlipMain.setLastChgTime(time);
			blChargeSlipMain.setStatus("y");
			if (box.getInt(EMPLOYEE_ID) != 0) {
				MasEmployee consultant = new MasEmployee();
				consultant.setId(box.getInt(EMPLOYEE_ID));
				blChargeSlipMain.setConsultant(consultant);
			}

			hbt.save(blChargeSlipMain);

			// -----------------Saving Data into BlChargeSlipDetail Table

			int chargeListLength = 0;
			chargeListLength = box.getInt("hiddenValueCharge");

			for (int i = 1; i <= chargeListLength; i++) {
				int chargeCodeId = box.getInt(CHARGE_CODE_ID + i);
				if (chargeCodeId != 0) {
					BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
					blChargeSlipDetail.setHospital(hospital);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(chargeCodeId);
					blChargeSlipDetail.setChargeCode(masChargeCode);

					BigDecimal rate = new BigDecimal(box.getString(RATE + i));
					blChargeSlipDetail.setRate(rate);

					BigDecimal amount = new BigDecimal(0);
					if (!box.getString(AMOUNT + i).equals("")) {
						amount = new BigDecimal(box.getString(AMOUNT + i));
						blChargeSlipDetail.setAmt(amount);
					}

					blChargeSlipDetail.setQuantity(box.getInt(QUANTITY + i));

					if (!box.getString(DISCOUNT_PERCENTAGE + i).equals(""))
						blChargeSlipDetail.setDiscountPercent(new BigDecimal(
								box.getString(DISCOUNT_PERCENTAGE + i)));

					if (!box.getString(DISCOUNT + i).equals(""))
						blChargeSlipDetail.setDiscountAmt(new BigDecimal(box
								.getString(DISCOUNT + i)));

					if (!box.getString(PROPORTIONAL_DISCOUNT + i).equals(""))
						blChargeSlipDetail
								.setProportionalDiscountAmount(new BigDecimal(
										box.getString(PROPORTIONAL_DISCOUNT + i)));

					if (!box.getString(NET_AMOUNT + i).equals(""))
						blChargeSlipDetail.setNetAmt(new BigDecimal(box
								.getString(NET_AMOUNT + i)));

					Users user1 = new Users();
					user1.setId(box.getInt("userId"));

					blChargeSlipDetail.setLastChgBy(user1);
					blChargeSlipDetail.setLastChgDate(changeDate);
					blChargeSlipDetail.setLastChgTime(time);
					blChargeSlipDetail.setStatus("y");
					blChargeSlipDetail.setChargeSlipMain(blChargeSlipMain);
					blChargeSlipDetail.setRefundableStatus("y");
					try {
						hbt.save(blChargeSlipDetail);
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
				}
			}
			boolean diag = false;
			for (int i = 1; i <= chargeListLength; i++) {
				if (box.getString(DEPARTMENT_TYPE_CODE + i).equals("RADIO")
						|| box.getString(DEPARTMENT_TYPE_CODE + i).equals(
								"DIAG")) {
					diag = true;
					break;
				}
			}
			DgOrderhd orderhd = new DgOrderhd();
			if (diag == true) {
				orderhd.setHospital(hospital);
				MasDepartment dept = new MasDepartment();
				dept.setId(box.getInt("departmentId"));
				orderhd.setDepartment(dept);
				orderhd.setTestType("Regular");
				orderhd.setOrderStatus("P");
				orderhd.setPatientType("IP");
				orderhd.setOrderDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				orderhd.setOrderTime(box.getString(CHANGED_TIME));
				Users user2 = new Users();
				user2.setId(box.getInt("userId"));
				orderhd.setLastChgBy(user2);
				orderhd.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				orderhd.setLastChgTime(box.getString(CHANGED_TIME));
				orderhd.setOrderNo(box.getString("orderNo"));
				orderhd.setHin(patient);
				orderhd.setInpatient(inpatient);
				orderhd.setBillChargeSlpNo(box.getString("chargeSlipNo"));
				if (box.getInt(EMPLOYEE_ID) != 0) {
					int empId = box.getInt(EMPLOYEE_ID);
					MasEmployee employee = new MasEmployee();
					employee.setId(empId);
					orderhd.setPrescribedBy(employee);
				}
				if (box.getInt(TOTAL_AMOUNT) != 0) {
					orderhd.setNetAmount(new BigDecimal(box
							.getInt(TOTAL_AMOUNT)));
				}
				hbt.save(orderhd);

				DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
				if (chargeListLength > 0) {
					for (int l = 1; l <= chargeListLength; l++) {
						if (box.getString(DEPARTMENT_TYPE_CODE + l).equals(
								"RADIO")) {
							collHeader.setHin(patient);
							MasDepartment department = new MasDepartment();
							department.setId(box.getInt(DEPARTMENT_ID));
							collHeader.setDepartment(department);
							collHeader.setHospital(hospital);
							collHeader.setOrder(orderhd);
							collHeader.setDiagnosisDate(changeDate);
							collHeader.setDiagnosisTime(time);
							collHeader.setOrderStatus("P");
							collHeader.setSampleValidationDate(changeDate);
							collHeader.setSampleValidationTime(time);
							Users user3 = new Users();
							user3.setId(box.getInt("userId"));
							collHeader.setLastChgBy(user3);
							collHeader.setLastChgDate(changeDate);
							collHeader.setLastChgTime(time);

							hbt.save(collHeader);
							break;
						}
					}
				}
				MasChargeCode masChargeCode = new MasChargeCode();
				for (int i = 1; i <= chargeListLength; i++) {
					if (box.getString(DEPARTMENT_TYPE_CODE + i).equals("RADIO")
							|| box.getString(DEPARTMENT_TYPE_CODE + i).equals(
									"DIAG")) {
						int chargeCodeId = box.getInt(CHARGE_CODE_ID + i);
						if (chargeCodeId != 0) {
							DgOrderdt orderdt = new DgOrderdt();

							masChargeCode.setId(chargeCodeId);
							orderdt.setChargeCode(masChargeCode);
							BigDecimal amount = new BigDecimal(
									box.getString(AMOUNT + i));
							orderdt.setAmount(amount);
							orderdt.setOrderQty(box.getInt(QUANTITY + i));
							Users user4 = new Users();
							user4.setId(box.getInt("userId"));
							orderdt.setLastChgBy(user4);
							orderdt.setLastChgDate(changeDate);
							orderdt.setLastChgTime(time);
							orderdt.setChargeSlip(blChargeSlipMain);
							orderdt.setOrderhd(orderhd);
							orderdt.setOrderStatus("P");
							// if (payableAmt.compareTo(new BigDecimal(0)) != 0)
							// {
							orderdt.setPaymentMade("y");
							// }else{
							// orderdt.setPaymentMade("n");
							// }
							MasMainChargecode mainChargecode = new MasMainChargecode();
							mainChargecode.setId(box.getInt(MAIN_CHARGECODE_ID
									+ i));
							orderdt.setMainChargecode(mainChargecode);

							MasSubChargecode subChargecode = new MasSubChargecode();
							subChargecode.setId(box.getInt(SUB_CHARGECODE_ID
									+ i));
							orderdt.setSubChargeid(subChargecode);
							try {
								hbt.save(orderdt);
							} catch (RuntimeException e) {
								e.printStackTrace();
							}
						}
					}
					if (box.getString(DEPARTMENT_TYPE_CODE + i).equals("RADIO")) {

						DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
						collDetails.setSampleCollectionHeader(collHeader);
						collDetails.setChargeCode(masChargeCode);
						String diagNo = generateDiagNumber(box
								.getInt(SUB_CHARGECODE_ID + i));
						collDetails.setDiagNo(diagNo);
						collDetails.setCollected("y");
						Users user5 = new Users();
						user5.setId(box.getInt("userId"));
						collDetails.setLastChgBy(user5);
						collDetails.setLastChgDate(changeDate);
						collDetails.setLastChgTime(time);
						collDetails.setOrderStatus("P");
						collDetails.setSampleCollDatetime(changeDate);
						MasMainChargecode maincharge = new MasMainChargecode();
						maincharge.setId(box.getInt(MAIN_CHARGECODE_ID + i));
						collDetails.setMaincharge(maincharge);
						MasSubChargecode subCharge = new MasSubChargecode();
						subCharge.setId(box.getInt(SUB_CHARGECODE_ID + i));
						collDetails.setSubcharge(subCharge);
						DgMasInvestigation investigation = new DgMasInvestigation();
						investigation.setId(box.getInt(CHARGE_CODE_ID + i));
						collDetails.setInvestigation(investigation);
						collDetails.setSampleCollDatetime(new Date());
						hbt.save(collDetails);

					}
				}
			}
			if (!osAmt.equals("0")) {
				Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
				BigDecimal pastDue = new BigDecimal(0);
				BigDecimal newAmt = new BigDecimal(0);
				if (patientObj.getPastDue() != null) {
					pastDue = new BigDecimal(patientObj.getPastDue());
				}
				newAmt = pastDue.add(osAmt);
				patientObj.setPastDue(newAmt.toString());
				hbt.update(patientObj);

			}

			/**
			 * --------Pharmacy Details entry---------------
			 */

			int counter = box.getInt("counter");
			if (counter > 0) {
				PatientStoreIndentHeader patientStoreIndentHeader = new PatientStoreIndentHeader();
				List<String> maxDemandNoList = new ArrayList<String>();

				maxDemandNoList = session
						.createCriteria(PatientStoreIndentHeader.class)
						.setProjection(Projections.property("DemandNo"))
						.addOrder(Order.desc("DemandNo")).setMaxResults(1)
						.list();

				Integer demandNo = 0;

				if (maxDemandNoList.size() > 0) {
					demandNo = Integer
							.parseInt((String) maxDemandNoList.get(0)) + 1;
				} else {
					demandNo = 1;
				}
				patientStoreIndentHeader.setDemandNo(demandNo.toString());

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("departmentId"));
				patientStoreIndentHeader.setDepartment(masDepartment);
				MasDepartment department = new MasDepartment();
				department.setId(box.getInt("toDeptId"));
				patientStoreIndentHeader.setToStore(department);

				patientStoreIndentHeader.setHin(patient);
				patientStoreIndentHeader.setHospital(hospital);
				Inpatient inpatientObj = new Inpatient();
				inpatientObj.setId(box.getInt(INPATIENT_ID));
				patientStoreIndentHeader.setInpatient(inpatientObj);

				patientStoreIndentHeader.setDemandDate(new Date());

				MasEmployee requestBy = new MasEmployee();
				requestBy.setId(box.getInt("requestById"));
				patientStoreIndentHeader.setRequestedBy(requestBy);

				patientStoreIndentHeader.setLastChgBy(user);
				patientStoreIndentHeader.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(CHANGED_DATE)));
				patientStoreIndentHeader.setStatus("p");

				hbt.save(patientStoreIndentHeader);

				for (int i = 1; i <= counter; i++) {
					PatientStoreIndentDetails patientStoreIndentDetails = new PatientStoreIndentDetails();
					patientStoreIndentDetails.setDepartment(masDepartment);
					MasStoreItem item = new MasStoreItem();
					if (box.getInt(ITEM_ID + i) != 0) {
						item.setId(box.getInt(ITEM_ID + i));
						patientStoreIndentDetails.setItem(item);

						patientStoreIndentDetails.setQtyRequest(box
								.getInt("qtyDisp" + i));
						patientStoreIndentDetails.setStatus("p");
						patientStoreIndentDetails
								.setPatientStoreIndentHeader(patientStoreIndentHeader);
						hbt.save(patientStoreIndentDetails);
					}
				}
				int inpId = box.getInt("inpId");
				InpatientPrescriptionHeader inpHeader = new InpatientPrescriptionHeader();
				inpHeader = (InpatientPrescriptionHeader) hbt.load(
						InpatientPrescriptionHeader.class, inpId);
				inpHeader.setStatus("n");
				hbt.update(inpHeader);
			}
			tx.commit();
			saved = true;
			map.put("success", saved);
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDrugIssueDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<PatientStoreIndentHeader> patientIndentHeaderList = new
		// ArrayList<PatientStoreIndentHeader>();
		List<PatientStoreIndentDetails> patientIndentDetailsList = new ArrayList<PatientStoreIndentDetails>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		Session session = getSession();
		/*
		 * patientIndentHeaderList = session.createCriteria(
		 * PatientStoreIndentHeader.class).add(
		 * Restrictions.idEq(box.getInt("patientIndentHdId"))).list();
		 */
		patientIndentDetailsList = session
				.createCriteria(PatientStoreIndentDetails.class)
				.add(Restrictions.eq("Status", "p"))
				.createAlias("PatientStoreIndentHeader", "psih")
				.add(Restrictions.eq("psih.Id", box.getInt("patientIndentHdId")))
				.list();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.list();
		// map.put("patientIndentHeaderList", patientIndentHeaderList);
		map.put("patientIndentDetailsList", patientIndentDetailsList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForDrugIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientStoreIndentHeader> patientStrInHdList = new ArrayList<PatientStoreIndentHeader>();
		Session session = getSession();

		Date fromDate = new Date();
		Date toDate = new Date();
		int deptId = box.getInt("deptId");
		if (!box.getString(FROM_DATE).equals(""))
			fromDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(FROM_DATE));
		if (!box.getString(TO_DATE).equals(""))
			toDate = HMSUtil.convertStringTypeDateToDateType(box
					.getString(TO_DATE));

		patientStrInHdList = session
				.createCriteria(PatientStoreIndentHeader.class)
				.add(Restrictions.eq("Status", "p"))
				.add(Restrictions.between("DemandDate", fromDate, toDate))
				.createAlias("ToStore", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.list();

		map.put("patientStrInHdList", patientStrInHdList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentDetails(int deptId) {
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = getSession();
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.idEq(deptId)).list();
		return departmentList;
	}

	public Map<String, Object> submitPatientDrugIssueAndBillingDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		Session session = getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// ---------------- Update status of Patient Drug Indent --------

			boolean notAllIssued = false;
			int itemListLength = box.getInt("hiddenValueItem");
			for (int j = 1; j < itemListLength; j++) {
				PatientStoreIndentDetails patientIndentDetails = new PatientStoreIndentDetails();
				patientIndentDetails = (PatientStoreIndentDetails) hbt.load(
						PatientStoreIndentDetails.class,
						box.getInt("patientIndentDetailsId" + j));
				if (box.getString("issued" + j).equals("y")) {
					patientIndentDetails.setStatus("i");
					hbt.update(patientIndentDetails);
				} else {
					notAllIssued = true;
				}
			}
			if (!notAllIssued) {
				PatientStoreIndentHeader patientIndentHeader = new PatientStoreIndentHeader();
				patientIndentHeader = (PatientStoreIndentHeader) hbt.load(
						PatientStoreIndentHeader.class,
						box.getInt("patientIndentHeaderId"));
				patientIndentHeader.setStatus("i");
				hbt.update(patientIndentHeader);
			}

			/**
			 * ---------------- Billing Entry and Issue drugs to patient and
			 * update stock quantity -------------------------------------
			 */
			BlDispensingHeader dispensingHeader = new BlDispensingHeader();

			dispensingHeader.setBillNo(box.getString("billNo"));
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			dispensingHeader.setHospital(hospital);

			Patient patient = new Patient();
			if (box.getInt(HIN_ID) != 0) {
				patient.setId(box.getInt(HIN_ID));
				dispensingHeader.setHin(patient);
				dispensingHeader.setPatientStatus("r");
			}
			dispensingHeader.setHinNo(box.getString(HIN_NO));
			Inpatient inpatient = new Inpatient();
			if (box.getInt(INPATIENT_ID) != 0) {
				inpatient.setId(box.getInt(INPATIENT_ID));
				dispensingHeader.setInpatient(inpatient);
			}
			if (box.getString(AD_NO) != null) {
				dispensingHeader.setAdNo(box.getString(AD_NO));
			}

			if (box.getString(PATIENT_NAME) != null) {
				dispensingHeader.setPatientName(box.getString(PATIENT_NAME));
			}
			if (box.getString(AGE) != null) {
				dispensingHeader.setAge(box.getString(AGE));
			}
			if (box.getInt(SEX_ID) != 0) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
				administrativeSex.setId(box.getInt(SEX_ID));
				dispensingHeader.setSex(administrativeSex);
			}
			dispensingHeader
					.setConsultantName(box.getString(CONSULTING_DOCTOR));
			if (!box.getString(BILL_AMOUNT).equals("")) {
				BigDecimal billamount = new BigDecimal("0");
				if (box.getString(BILL_AMOUNT).equals("NaN")) {
					dispensingHeader.setBillAmt(billamount);
				} else {
					billamount = new BigDecimal(box.getString(BILL_AMOUNT));
					dispensingHeader.setBillAmt(billamount);
				}
			}
			// StringUtils.isEmpty(DISCOUNT_AMOUNT)
			/*
			 * if(StringUtils.isNotEmpty(box.getString(DISCOUNT_AMOUNT))){
			 * 
			 * }
			 */
			if (!(box.getString(DISCOUNT_AMOUNT).equals(""))) {
				BigDecimal totalDiscount = new BigDecimal("0");
				if (box.getString(DISCOUNT_AMOUNT).equals("NaN")) {
					dispensingHeader.setDiscountAmt(totalDiscount);
				} else {
					totalDiscount = new BigDecimal(
							box.getString(DISCOUNT_AMOUNT));
					dispensingHeader.setDiscountAmt(totalDiscount);
				}
			}
			if (!(box.getString(ROUND_OF_VALUE).equals(""))) {
				dispensingHeader.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}
			if (!(box.getString(TOTAL_AMOUNT).equals(""))) {
				BigDecimal totalAmt = new BigDecimal("0");
				if ((box.getString(TOTAL_AMOUNT).equals("NaN"))) {
					dispensingHeader.setNetAmt(totalAmt);
				} else {
					dispensingHeader.setNetAmt(new BigDecimal(box
							.getString(TOTAL_AMOUNT)));
				}
			}
			if (!(box.getString(ADVANCE_ADJUSTMENT).equals(""))) {
				BigDecimal advanceAdj = new BigDecimal("0");
				if (box.getString(ADVANCE_ADJUSTMENT).equals("NaN")) {
					dispensingHeader.setAdvAdjustment(advanceAdj);
				} else {
					dispensingHeader.setAdvAdjustment(new BigDecimal(box
							.getString(ADVANCE_ADJUSTMENT)));
				}
			}
			if (!(box.getString(OUTSTANDING).equals(""))) {
				BigDecimal outstand = new BigDecimal("0");
				if ((box.getString(OUTSTANDING).equals("NaN"))) {
					dispensingHeader.setOutstanding(outstand);
				} else {
					dispensingHeader.setOutstanding(new BigDecimal(box
							.getString(OUTSTANDING)));
				}
			}
			if (!(box.getString(DISCOUNT_ON_BILL).equals(""))) {
				BigDecimal discountonbill = new BigDecimal("0");
				if (box.getString(DISCOUNT_ON_BILL).equals("NaN")) {
					dispensingHeader.setDiscountOnBill(discountonbill);
				} else {
					dispensingHeader.setDiscountOnBill(new BigDecimal(box
							.getString(DISCOUNT_ON_BILL)));
				}
			}

			if (!(box.getString(PAYABLE_AMOUNT).equals(""))) {
				BigDecimal payableAmount = new BigDecimal("0");
				if (box.getString(PAYABLE_AMOUNT).equals("NaN")) {
					dispensingHeader.setPayableAmt(payableAmount);
				} else {
					dispensingHeader.setPayableAmt(new BigDecimal(box
							.getString(PAYABLE_AMOUNT)));
				}
			}
			if (!(box.getString(EMPLOYEE_ID).equals("0"))) {
				int empId = box.getInt(EMPLOYEE_ID);
				MasEmployee employee = new MasEmployee();
				employee.setId(empId);
				dispensingHeader.setConsultant(employee);
			}
			if (!(box.getString("actualCollectedAmt").equals(""))) {
				BigDecimal actualCollectedAmt = new BigDecimal("0");
				if (box.getString("actualCollectedAmt").equals("NaN")) {
					dispensingHeader.setActualCollectedAmt(actualCollectedAmt);
				} else {
					dispensingHeader.setActualCollectedAmt(new BigDecimal(box
							.getString("actualCollectedAmt")));
				}
			}
			if (!box.getString("compDiscount").equals("")) {
				BigDecimal compDiscount = new BigDecimal("0");
				if (box.getString("compDiscount").equals("NaN")) {
					dispensingHeader.setDiscount(compDiscount);
				} else {
					dispensingHeader.setDiscount(new BigDecimal(box
							.getString("compDiscount")));
				}
			}
			if (!box.getString("charity").equals("")) {
				BigDecimal charity = new BigDecimal("0");
				if (box.getString("charity").equals("NaN")) {
					dispensingHeader.setCharity(charity);
				} else {
					dispensingHeader.setCharity(new BigDecimal(box
							.getString("charity")));
				}
			}
			if (box.getInt(PATIENT_TYPE_ID) != 0) {
				MasPatientType patientType = new MasPatientType();
				patientType.setId(box.getInt(PATIENT_TYPE_ID));
				dispensingHeader.setPatientType(patientType);
			}
			if (box.getInt("companyId") != 0) {
				MasCompany company = new MasCompany();
				company.setId(box.getInt("companyId"));
				dispensingHeader.setCompany(company);
			}
			dispensingHeader.setBillDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			dispensingHeader.setBillTime(box.getString(CHANGED_TIME));

			Users userObj = new Users();
			userObj.setId(box.getInt("userId"));
			dispensingHeader.setChangedBy(userObj);
			dispensingHeader.setStatus("y");

			hbt.save(dispensingHeader);
			int batchWiseItemListLength = box.getInt("batchNoCounter");

			for (int i = 1; i <= batchWiseItemListLength; i++) {
				BlDispensingDetails dispensingDetails = new BlDispensingDetails();
				if (!box.getString(ISSUE_QUANTITY + i).equals("")) {
					dispensingDetails.setDispensingHeader(dispensingHeader);
					if (box.getInt(BATCH_ITEM_ID + i) != 0) {
						MasStoreItem storeItem = new MasStoreItem();
						storeItem.setId(box.getInt(BATCH_ITEM_ID + i));
						dispensingDetails.setItem(storeItem);
					}
					if (box.getInt(BATCH_ID + i) != 0) {
						StoreItemBatchStock itemBatchStock = new StoreItemBatchStock();
						itemBatchStock.setId(box.getInt(BATCH_ID + i));
						dispensingDetails.setBatch(itemBatchStock);
					}

					dispensingDetails.setQty(new BigDecimal(box
							.getString(ISSUE_QUANTITY + i)));

					if (!box.getString("batchAmt" + i).equals("")
							&& box.getString("batchAmt" + i) != null) {
						BigDecimal batchAmt = new BigDecimal("0");
						if (box.getString("batchAmt" + i).equals("NaN")
								|| box.getString("batchAmt" + i) != "") {
							dispensingDetails.setAmount(batchAmt);
						} else {
							dispensingDetails.setAmount(new BigDecimal(box
									.getString("batchAmt" + i)));
						}
					}
					if (!box.getString("batchDisPer" + i).equals("")) {
						BigDecimal batchDisPer = new BigDecimal("0");
						if (box.getString("batchDisPer" + i).equals("NaN")) {
							dispensingDetails.setDiscountPercent(batchDisPer);
						} else {
							dispensingDetails
									.setDiscountPercent(new BigDecimal(box
											.getString("batchDisPer" + i)));
						}
					}
					if (!box.getString("batchDisAmt" + i).equals("")) {
						BigDecimal batchDisAmt = new BigDecimal("0");
						if (box.getString("batchDisAmt" + i).equals("NaN")) {
							dispensingDetails.setDiscountAmt(batchDisAmt);
						} else {
							dispensingDetails.setDiscountAmt(new BigDecimal(box
									.getString("batchDisAmt" + i)));
						}
					}
					if (!box.getString("batchPrptDisAmt" + i).equals("")) {
						BigDecimal batchPrptDisAmt = new BigDecimal("0");
						if (box.getString("batchPrptDisAmt" + i).equals("NaN")) {
							dispensingDetails
									.setProportionalDisAmt(batchPrptDisAmt);
						} else {
							dispensingDetails
									.setProportionalDisAmt(new BigDecimal(box
											.getString("batchPrptDisAmt" + i)));
						}
					}
					if (!box.getString("batchSalesTaxAmt" + i).equals("")) {
						BigDecimal batchSalesTaxAmt = new BigDecimal("0");
						if (box.getString("batchSalesTaxAmt" + i).equals("NaN")) {
							dispensingDetails.setSalesTaxAmt(batchSalesTaxAmt);
						} else {
							dispensingDetails.setSalesTaxAmt(new BigDecimal(box
									.getString("batchSalesTaxAmt" + i)));
						}
					}
					if (box.getString("batchNetAmt" + i) != null
							&& !box.getString("batchNetAmt" + i).equals("")) {
						BigDecimal batchNetAmt = new BigDecimal("0");
						if (box.getString("batchNetAmt" + i).equals("NaN")) {
							dispensingDetails.setNetAmt(batchNetAmt);
						} else {
							dispensingDetails.setNetAmt(new BigDecimal(box
									.getString("batchNetAmt" + i)));
						}
					}
					dispensingDetails.setRefundableStatus("y");
					dispensingDetails.setIssued("y");
					hbt.save(dispensingDetails);

					int batchId = box.getInt(BATCH_ID + i);
					BigDecimal qty = new BigDecimal(
							box.getString(ISSUE_QUANTITY + i));
					if (batchId != 0) {
						StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
								.load(StoreItemBatchStock.class, batchId);
						BigDecimal stockQty = new BigDecimal(0);
						// BigDecimal blockedQty = new BigDecimal(0);
						BigDecimal closingStockQty = new BigDecimal(0);
						BigDecimal issueQty = new BigDecimal(0);

						if (storeItemBatchStock.getClosingStock() != null) {
							stockQty = storeItemBatchStock.getClosingStock();
						}
						/*
						 * if (storeItemBatchStock.getBlockedQty() != null) {
						 * blockedQty = storeItemBatchStock.getBlockedQty(); }
						 */
						if (storeItemBatchStock.getIssueQty() != null) {
							issueQty = storeItemBatchStock.getIssueQty();
						}
						closingStockQty = stockQty.subtract(qty);
						storeItemBatchStock.setClosingStock(closingStockQty);
						// storeItemBatchStock.setBlockedQty(blockedQty.subtract(qty));
						storeItemBatchStock.setIssueQty(issueQty.add(qty));

						hbt.update(storeItemBatchStock);
					}
				}
			}
			tx.commit();
			flag = true;
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
		}
		map.put("flag", flag);
		return map;
	}

	public void executeProcedureForReport(Map<String, Object> parameters) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String fDate = "";
		String tDate = "";

		if (parameters.get("fromDate") != null) {
			fromDate = (Date) parameters.get("fromDate");
		}
		if (parameters.get("toDate") != null) {
			toDate = (Date) parameters.get("toDate");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate = sdf.format(fromDate);
		tDate = sdf.format(toDate);
		Session session = getSession();
		try {
			Connection con = session.connection();
			String qry = "call tempdate_table('" + fDate + "','" + tDate + "')";
			java.sql.CallableStatement cal = con.prepareCall(qry);
			cal.execute();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void executeProcedureForDailyCashReport(
			Map<String, Object> parameters) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String fDate = "";
		String tDate = "";
		String fromTime = "";

		String toTime = "";

		if (parameters.get("fromDate") != null) {
			fromDate = (Date) parameters.get("fromDate");
		}
		if (parameters.get("toDate") != null) {
			toDate = (Date) parameters.get("toDate");
		}

		if (parameters.get("fromTime") != null) {
			fromTime = (String) parameters.get("fromTime");
		}

		if (parameters.get("toTime") != null) {
			toTime = (String) parameters.get("toTime");
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		fDate = sdf.format(fromDate);
		tDate = sdf.format(toDate);
		Session session = getSession();
		try {
			Connection con = session.connection();
			String qry = "call dail_cash_reportwc('" + fDate + "','" + tDate
					+ "','" + fromTime + "','" + toTime + "')";
			java.sql.CallableStatement cal = con.prepareCall(qry);
			cal.execute();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void executeProcedureForRetrivePastDue(Map<String, Object> parameters) {

		String pastDue = "";

		if (parameters.get("pastDue") != null) {
			pastDue = (String) parameters.get("pastDue");
		}

		Session session = getSession();
		try {
			Connection con = session.connection();
			String qry = "call insert_mobile('" + pastDue + "')";
			java.sql.CallableStatement cal = con.prepareCall(qry);
			cal.execute();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSystemParamDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		HospitalParameters hospitalParameters = new HospitalParameters();
		Session session = null;
		session = getSession();
		List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
		try {
			Criteria c = session.createCriteria(HospitalParameters.class)
					.addOrder(Order.asc("Id"));

			c.setFirstResult(0);
			c.setMaxResults(1);
			hospitalParametersList = c.list();

			if (hospitalParametersList != null
					&& hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList.get(0);
				map.put("hospitalParameters", hospitalParameters);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 13 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<PrinterCofiguration> getPrinterConfigurationList(
			Map<String, Object> generalmap) {
		List<PrinterCofiguration> printerList = new ArrayList<PrinterCofiguration>();
		Session session = getSession();
		String reportType = "";
		String clientIP = "";
		if (generalmap.get("reportType") != null) {
			reportType = (String) generalmap.get("reportType");
		}
		if (generalmap.get("clientIP") != null) {
			clientIP = (String) generalmap.get("clientIP");
		}
		printerList = session.createCriteria(PrinterCofiguration.class)
				.add(Restrictions.eq("ReportType", reportType))
				.add(Restrictions.eq("SystemIp", clientIP)).list();

		return printerList;
	}

	public Map<String, Object> getChargeSlipDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int chargeSlipId = box.getInt("chargeSlipId");
		List<BlChargeSlipDetail> chargeSlipDtList = new ArrayList<BlChargeSlipDetail>();
		Session session = getSession();
		try {
			chargeSlipDtList = session.createCriteria(BlChargeSlipDetail.class)
					.createAlias("ChargeSlipMain", "csm")
					.add(Restrictions.eq("csm.Id", chargeSlipId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("chargeSlipDtList", chargeSlipDtList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// Added By Manjul for Particular Wise Discount

	public boolean updateFinalBill(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> getdataMap = new HashMap<String, Object>();
		int blChargeId = box.getInt("blChargeId");
		int inpatientId = box.getInt("inpatientId");
		boolean saved = false;
		Session session = getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			BlChargeSlipMain blChargeMain = (BlChargeSlipMain) hbt.load(
					BlChargeSlipMain.class, blChargeId);
			Inpatient inpatient = (Inpatient) hbt.load(Inpatient.class,
					inpatientId);

			Patient pat = (Patient) hbt.load(Patient.class, inpatient.getHin()
					.getId());
			BigDecimal pastDue = new BigDecimal(pat.getPastDue());
			if (pastDue.compareTo(new BigDecimal(0)) > 0) {
				pastDue = pastDue.subtract(new BigDecimal(box
						.getInt("totalDiscount")));
				pat.setPastDue(pastDue.toString());
			}
			BigDecimal discountM = new BigDecimal(0);
			if (blChargeMain.getDiscount() != null) {
				discountM = blChargeMain.getDiscount();
			}
			blChargeMain.setDiscount(discountM.add(new BigDecimal(box
					.getInt("totalDiscount"))));

			BigDecimal discountAmt = new BigDecimal(0);
			if (blChargeMain.getDiscountAmt() != null) {
				discountAmt = blChargeMain.getDiscountAmt();
			}
			blChargeMain.setDiscountAmt(discountAmt.add(new BigDecimal(box
					.getInt("totalDiscount"))));

			BigDecimal chgSlpAmt = new BigDecimal(0);
			if (blChargeMain.getChgSlpAmt() != null) {
				chgSlpAmt = blChargeMain.getChgSlpAmt();
			}
			blChargeMain.setChgSlpAmt(chgSlpAmt.subtract(new BigDecimal(box
					.getInt("totalDiscount"))));

			BigDecimal osAmt = new BigDecimal(0);
			if (blChargeMain.getOsAmt() != null) {
				osAmt = blChargeMain.getOsAmt();
			}
			blChargeMain.setOsAmt(osAmt.subtract(new BigDecimal(box
					.getInt("totalDiscount"))));

			BigDecimal netAmt = new BigDecimal(0);
			if (blChargeMain.getNetAmt() != null) {
				netAmt = blChargeMain.getNetAmt();
			}
			blChargeMain.setNetAmt(netAmt.subtract(new BigDecimal(box
					.getInt("totalDiscount"))));
			hbt.save(blChargeMain);

			Vector blChargeDtId = box.getVector("blChargeDtId");
			Vector amount = box.getVector("amount");
			Vector discount = box.getVector("discount");
			Vector rate = box.getVector("rate");

			for (int i = 0; i < blChargeDtId.size(); i++) {

				BlChargeSlipDetail blChargeDetail = new BlChargeSlipDetail();
				blChargeDetail = (BlChargeSlipDetail) session.load(
						BlChargeSlipDetail.class,
						(Integer.parseInt(blChargeDtId.get(i).toString())));
				blChargeDetail.setNetAmt(new BigDecimal(amount.get(i)
						.toString()));
				blChargeDetail.setAmt(new BigDecimal(amount.get(i).toString()));
				BigDecimal discAmt = new BigDecimal(0);
				if (blChargeDetail.getDiscountAmt() != null) {
					discAmt = blChargeDetail.getDiscountAmt();
				}
				if (discount.get(i) != null && discount.get(i) != "") {
					blChargeDetail.setDiscountAmt(discAmt.add(new BigDecimal(
							discount.get(i).toString())));
				}

				/*
				 * By Ujjwal For Updating Charge During final Bill
				 */
				if (rate.get(i) != null && !rate.get(i).equals("")) {
					blChargeDetail.setRate(new BigDecimal("" + rate.get(i)));
				}
				hbt.update(blChargeDetail);
			}
			// }

			saved = true;
			map.put("success", saved);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}

		}

		return saved;
	}

	@Override
	public boolean updateBills(int inpatientId) {
		boolean updated = false;
		List<BlChargeSlipDetail> dtlList = new ArrayList<BlChargeSlipDetail>();
		List<BlChargeSlipMain> mainList = new ArrayList<BlChargeSlipMain>();
		List<Inpatient> ipList = new ArrayList<Inpatient>();
		List<BlReceiptDetails> receiptDtlList = new ArrayList<BlReceiptDetails>();
		List<BlReceiptHeader> hdDtlList = new ArrayList<BlReceiptHeader>();
		Session session = (Session) getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// hbt.save(fitness);
		/*
		 * try{ tx = session.beginTransaction();
		 */
		ipList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();
		mainList = session.createCriteria(BlChargeSlipMain.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		hdDtlList = session.createCriteria(BlReceiptHeader.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		for (BlReceiptHeader hd : hdDtlList) {
			hd.setAmount(new BigDecimal(0));
			hbt.update(hd);
			int hdId = 0;
			hdId = hd.getId();
			receiptDtlList = session.createCriteria(BlReceiptDetails.class)
					.add(Restrictions.eq("ReceiptHeader.Id", hdId)).list();
			for (BlReceiptDetails dtl : receiptDtlList) {
				dtl.setAmount(new BigDecimal(0));
				hbt.update(dtl);
			}
		}
		int mainId = 0;
		//
		//
		for (BlChargeSlipMain main : mainList) {
			main.setChgSlpAmt(new BigDecimal(0));
			main.setOsAmt(new BigDecimal(0));
			main.setNetAmt(new BigDecimal(0));
			hbt.update(main);
			mainId = main.getId();
			dtlList = session.createCriteria(BlChargeSlipDetail.class)
					.add(Restrictions.eq("ChargeSlipMain.Id", mainId)).list();
			//
			for (BlChargeSlipDetail dtl : dtlList) {
				if (dtl.getChargeCode().getId() != 1039) {

					dtl.setAmt(new BigDecimal(0));
					dtl.setNetAmt(new BigDecimal(0));
					dtl.setRate(new BigDecimal(0));
					hbt.update(dtl);
				}
			}

		}
		updated = true;
		/*
		 * catch(Exception e){ e.printStackTrace(); tx.commit(); if (tx !=
		 * null){ tx.rollback(); } }
		 */
		return updated;
	}

	@Override
	public boolean updateBillsForMLC(int inpatientId) {
		boolean updated = false;
		List<BlChargeSlipDetail> dtlList = new ArrayList<BlChargeSlipDetail>();
		/* List<BlChargeSlipMain>mainList=new ArrayList<BlChargeSlipMain>(); */
		List<Object[]> mainList = new ArrayList<Object[]>();
		List<Inpatient> ipList = new ArrayList<Inpatient>();
		List<BlReceiptDetails> receiptDtlList = new ArrayList<BlReceiptDetails>();
		List<BlReceiptHeader> hdDtlList = new ArrayList<BlReceiptHeader>();
		Session session = (Session) getSession();
		Transaction tx = null;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// hbt.save(fitness);
		/*
		 * try{ tx = session.beginTransaction();
		 */
		ipList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();
		Date dateOfAdmission = null;
		String timeOfAdmission = "";
		int hinId = 0;
		for (Inpatient inpatient : ipList) {
			dateOfAdmission = inpatient.getDateOfAddmission();
			timeOfAdmission = inpatient.getTimeOfAddmission();
			hinId = inpatient.getHin().getId();
		}
		List<Patient> ptList = new ArrayList<Patient>();
		ptList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("Id", hinId)).list();

		String dateQuery = "select ip.date_of_addmission,dateadd(day,1,ip.date_of_addmission) as date2 from inpatient ip where ip.inpatient_id="
				+ inpatientId;
		List<Object[]> dateList = new ArrayList<Object[]>();
		dateList = session.createSQLQuery(dateQuery).list();
		//
		Date date1 = new Date();
		Date date2 = new Date();

		for (Object[] dt : dateList) {
			date1 = (Date) dt[0];
			date2 = (Date) dt[1];
		}
		//
		//
		String query = "";
		String date = HMSUtil.convertDateToStringTypeDate(date1);
		String date3 = HMSUtil.convertDateToStringTypeDate(date2);
		query = "select main.charge_slip_main_id,main.inpatient_id,main.chg_slp_time from bl_charge_slip_main main  where inpatient_id="
				+ inpatientId
				+ " and chg_slp_date between '"
				+ date.substring(6, 10).concat("-")
						.concat(date.substring(3, 5)).concat("-")
						.concat(date.substring(0, 2))
				+ "' and '"
				+ date3.substring(6, 10).concat("-")
						.concat(date3.substring(3, 5)).concat("-")
						.concat(date3.substring(0, 2)) + "'";// ' and
																// chg_slp_time
																// between
																// '"+timeOfAdmission+"'
																// and
																// '"+timeOfAdmission+"'";
		//

		mainList = session.createSQLQuery(query).list();
		hdDtlList = session.createCriteria(BlReceiptHeader.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		for (BlReceiptHeader hd : hdDtlList) {
			hd.setAmount(new BigDecimal(0));
			hbt.update(hd);
			int hdId = 0;
			hdId = hd.getId();
			receiptDtlList = session.createCriteria(BlReceiptDetails.class)
					.add(Restrictions.eq("ReceiptHeader.Id", hdId)).list();
			for (BlReceiptDetails dtl : receiptDtlList) {
				dtl.setAmount(new BigDecimal(0));
				hbt.update(dtl);
			}
		}

		int mainId = 0;
		String time2 = "";

		//
		//
		for (Object[] main : mainList) {
			mainId = (Integer) main[0];
			time2 = (String) main[2];
			String pattern = "HH:mm:ss";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			Date date21 = null;
			Date date11 = null;
			try {
				date11 = sdf.parse(timeOfAdmission);
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String currentDate = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");

				date21 = sdf.parse(time2);
				//
				//
				// Outputs -1 as date1 is before date2
				//

				// Outputs 1 as date1 is after date1
				//

				date2 = sdf.parse("19:28");
				// Outputs 0 as the dates are now equal
				//

			} catch (ParseException e) {
				// Exception handling goes here
			}
			if (date11.compareTo(date21) != 1) {
				List<BlChargeSlipMain> mainList1 = new ArrayList<BlChargeSlipMain>();
				mainList1 = session.createCriteria(BlChargeSlipMain.class)
						.add(Restrictions.eq("Id", mainId)).list();
				for (BlChargeSlipMain main1 : mainList1) {
					main1.setChgSlpAmt(new BigDecimal(0));
					main1.setOsAmt(new BigDecimal(0));
					main1.setNetAmt(new BigDecimal(0));
					hbt.update(main1);
					mainId = main1.getId();
					dtlList = session.createCriteria(BlChargeSlipDetail.class)
							.add(Restrictions.eq("ChargeSlipMain.Id", mainId))
							.list();
					//
					for (BlChargeSlipDetail dtl : dtlList) {
						dtl.setAmt(new BigDecimal(0));
						dtl.setNetAmt(new BigDecimal(0));
						dtl.setRate(new BigDecimal(0));
						hbt.update(dtl);
					}
				}
			}
			updated = true;

			/*
			 * catch(Exception e){ e.printStackTrace(); tx.commit(); if (tx !=
			 * null){ tx.rollback(); } }
			 */
		}
		return updated;
	}

	@Override
	public int getGenderId(Integer hinId) {
		Session session = (Session) getSession();
		int sexId = 0;
		List<Integer> hinList = new ArrayList<Integer>();
		hinList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("Id", hinId))
				.setProjection(Projections.property("Sex.Id")).list();
		for (Integer pt : hinList) {
			sexId = pt;
		}
		//
		return sexId;
	}

	@Override
	public int getPatientTypeId(Integer hinId) {
		Session session = (Session) getSession();
		int patientTypeId = 0;
		List<Integer> hinList = new ArrayList<Integer>();
		hinList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("Id", hinId))
				.setProjection(Projections.property("PatientType.Id")).list();
		for (Integer pt : hinList) {
			patientTypeId = pt;
		}
		//
		return patientTypeId;
	}

	@Override
	public Date getAdmDate(int inpatientId) {
		Session session = (Session) getSession();
		Date admDate = new Date();
		List<Date> hinList = new ArrayList<Date>();
		hinList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId))
				.setProjection(Projections.property("DateOfAddmission")).list();
		for (Date pt : hinList) {
			admDate = pt;
		}
		//
		return admDate;
	}

	@Override
	public Map<String, Object> updateDates(int inpatientId, String nextToAdmDate) {
		List<Object[]> objList = new ArrayList<Object[]>();
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		String query = "select chg_slp_date,main.charge_slip_main_id from bl_charge_slip_main main "
				+ " left outer join  bl_charge_slip_detail dtl on main.charge_slip_main_id=dtl.charge_slip_main_id "
				+ " where main.inpatient_id="
				+ inpatientId
				+ " and charge_code_id=1052 order by chg_slp_date";
		// ";

		objList = session.createSQLQuery(query).list();

		for (Object[] obj : objList) {
			int mainId = Integer.parseInt("" + obj[1]);

			String[] nextToAdmDate2 = nextToAdmDate.split("/");
			nextToAdmDate = HMSUtil.getNexAndPreciousDate(HMSUtil
					.convertStringTypeDateToDateType(nextToAdmDate));
			String nextToAdmDate1 = "" + nextToAdmDate2[0] + "/"
					+ nextToAdmDate2[1] + "/20" + nextToAdmDate2[2];

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<BlChargeSlipMain> mainList = new ArrayList<BlChargeSlipMain>();
			mainList = session.createCriteria(BlChargeSlipMain.class)
					.add(Restrictions.eq("Id", mainId)).list();
			for (BlChargeSlipMain main : mainList) {
				main.setChgSlpDate(HMSUtil
						.convertStringTypeDateToDateType(nextToAdmDate1));
				hbt.update(main);
			}
		}

		return map;
	}

	@Override
	public boolean printCashCollectionReport(Map<String, Object> parameters) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String fDate = "";
		String tDate = "";
		String flag = "";
		int hospitalId = 0;
		boolean status = false;

		if (parameters.get("fromDate") != null) {
			fromDate = (Date) parameters.get("fromDate");
		}
		if (parameters.get("toDate") != null) {
			toDate = (Date) parameters.get("toDate");
		}
		if (parameters.get("hospitalId") != null) {
			hospitalId = (Integer) parameters.get("hospitalId");
		}
		if (parameters.get("flag") != null) {
			flag = (String) parameters.get("flag");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		fDate = sdf.format(fromDate);
		tDate = sdf.format(toDate);
		Session session = getSession();
		try {
			/*
			 * SQLQuery q = session.createSQLQuery(
			 * "exec cash_collection_sub_charge_wise :param1, :param2");
			 * q.setString("param1", fDate); q.setString("param2", tDate); List
			 * l = q.list();
			 */
			Connection con = session.connection();
			String qry = "";
			if (flag.equals("subCharge")) {
				qry = "{call cash_collection_sub_carge_wise('" + fDate + "','"
						+ tDate + "','" + hospitalId + "')}";
			} else if (flag.equals("mainCharge")) {
				qry = "{call cash_collection_main_carge_wise('" + fDate + "','"
						+ tDate + "','" + hospitalId + "')}";
			} else if (flag.equals("charge")) {
				qry = "{call cash_collection_carge_wise('" + fDate + "','"
						+ tDate + "','" + hospitalId + "')}";
			} else if (flag.equals("ipCharge")) {
				qry = "{call cash_collection_ip_patient('" + fDate + "','"
						+ tDate + "','" + hospitalId + "')}";
			}
			if (!qry.equals("")) {
				java.sql.CallableStatement cal = con.prepareCall(qry);
				cal.execute();
			}
			status = true;
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Map<String, Object> getSubChargeCode(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		List<Object[]> subChargeList = new ArrayList<Object[]>();
		System.out.println("maincharge--" + box.getInt("mainChargeId"));
		subChargeList = session
				.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("MainChargecode.Id",
						box.getInt("mainChargeId")))
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("Id"))
								.add(Projections.property("SubChargecodeName")))
				.list();
		System.out.println(subChargeList.size());
		map.put("subChargeList", subChargeList);
		return map;
	}

	public String getMaxNoByDeptCode(Map<String, Object> dataMap) {
		String maxNo = "";
		/*
		 * String y1 = ""; String y2 = ""; String y3 = ""; int tempMonth = 0;
		 */
		String financialYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		financialYear = HMSUtil.getFinancialYearYY_YY(currentDate);
		String no = "";
		if (dataMap.get("no") != null) {
			no = (String) dataMap.get("no");
		}
		String deptType = "";
		String hospitalCode = "";

		if (dataMap.get("deptType") != null) {
			deptType = (String) dataMap.get("deptType");
		}

		try {
			if (!no.equals("") && !no.equals("0")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				String arr[] = no.split("/");
				int seqNo = 0;
				deptType = arr[0];
				seqNo = Integer.parseInt(arr[1]);
				++seqNo;
				maxNo = deptType + "/" + seqNo + "/" + financialYear;
			} else {
				maxNo = deptType + "/" + "01" + "/" + financialYear;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return maxNo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showDetailPendingDispensing(
			Map<String, Object> mapForDs)  {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Visit> patientList = new ArrayList<Visit>();
		List<PatientPrescriptionDetails> prescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();
		
		List<Object[]> nonInsulineprescriptionDetailsList = new ArrayList<Object[]>();

		List<StoreIssueT> alreadyissuedDrugList = new ArrayList<StoreIssueT>();
		Session session = (Session) getSession();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL;
		Date issueDate = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
			 issueDate = java.sql.Date.valueOf(date4MySQL);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int presId = 0;
		int hinId=0;
		int hospitalId = 0;
		int deptId=0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("presId") != null) {
			presId = (Integer) mapForDs.get("presId");
		}
		
		String deptType = "";
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

	
			List<PatientPrescriptionDetails> patientPrescriptionDetailsOut= new ArrayList<PatientPrescriptionDetails>();
			patientPrescriptionDetailsOut=session.createCriteria(PatientPrescriptionDetails.class)
				.createAlias("Prescription", "presc").createAlias("presc.Hin", "hin")
				.createAlias("presc.Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("hin.Id", hinId))
				.add(Restrictions.isNull("Item"))
				.list();
			
			Criteria criteria=null;
			criteria=session.createCriteria(PatientPrescriptionDetails.class)
					.createAlias("Item", "item")
					.createAlias("item.ItemClass", "itemClass")
					.createAlias("Prescription", "presc")
					.createAlias("presc.Hospital","hospital").add(Restrictions.eq("hospital.Id", hospitalId));
					
					criteria=criteria.add(Restrictions.eq("presc.PrescriptionDate", new Date())) 
					.add(Restrictions.eq("presc.Hin.Id", hinId)); 
			Criterion rest1=Restrictions.and(Restrictions.ne("itemClass.ItemClassCode", "CL3"), 
					Restrictions.or(Restrictions.isNull("item.InsulinInjection"), 
					Restrictions.eq("item.InsulinInjection","n").ignoreCase()));
			Criterion rest2= Restrictions.and(Restrictions.eq("itemClass.ItemClassCode","CL3"), 
					Restrictions.eq("item.InsulinInjection",'y').ignoreCase());
			criteria=	criteria.add(Restrictions.or(rest1, rest2));
			prescriptionDetailsList=	criteria.list();
				
					
					String sql11 = "SELECT a1.pvms_no,a1.nomenclature,a1.dosage,a1.frequency_id,a1.no_of_days,a1.total,a1.route_name,COALESCE(a2.Total_issued,0) as Total_issued,a1.visit_id,a1.hin_id from "
							+ "(select t3.visit_id,t3.item_id,t3.pvms_no,t3.nomenclature,t3.prescription_id,t3.dosage,t3.frequency_id,t3.no_of_days,t3.total,t4.route_name,t3.hin_id from "
							+ "(select t1.visit_id,t1.item_id,t2.pvms_no,t2.nomenclature,t1.prescription_id,t1.dosage,t1.frequency_id,t1.no_of_days,t1.total,t1.route_id,t1.injection_status,t1.hin_id from "
							+ "(select visit_id,ppd.prescription_id as prescription_id,injection_status,item_id,dosage,frequency_id,no_of_days,total,route_id,hin_id "
							+ "from patient_prescription_details ppd left outer join patient_prescription_header pph "
							+ "on ppd.prescription_id=pph.prescription_id where ppd.prescription_id='"+presId+"' group by hin_id,visit_id, "
							+ "ppd.prescription_id,injection_status,item_id,dosage,frequency_id,no_of_days,total,route_id ) t1 left outer join "
							+ "(select item_id,pvms_no,nomenclature,insulin_injection,item_class_id from mas_store_item ) t2 on t1.item_id=t2.item_id where t1.injection_status='p' and t2.insulin_injection !='y'or insulin_injection is NULL and t2.item_class_id=3 ) t3 left outer join "
							+ "(select route_id,route_name from route_of_administration ) t4 on t3.route_id=t4.route_id) a1 left outer join "
							+ "(select item_id,sum(issue_stock) as total_issued,visit_id from inj_appointment_details iad left outer join inj_appointment_header iah on "
							+ "iad.inj_appointment_header_id=iah.inj_appointment_header_id where prescription_id='"+presId+"' group by item_id,visit_id) a2 on a1.item_id=a2.item_id and a1.visit_id=a2.visit_id";
					
					
					
					
					nonInsulineprescriptionDetailsList = session.createSQLQuery(sql11).list();

					 List<Integer> itemList=null;
					
					 Map<Integer,ArrayList<String>> bachNoMapList=null;
					 bachNoMapList=new HashMap<Integer,ArrayList<String>>();
					 
					 Map<Integer,ArrayList<String>> ExpiryMapList=null;
					 ExpiryMapList=new HashMap<Integer,ArrayList<String>>();
					 
					 Map<Integer,ArrayList<String>> stockMapList=null;
					 stockMapList=new HashMap<Integer,ArrayList<String>>();
					 
					List<StoreItemBatchStock> masStoreBrandItemList = new ArrayList<StoreItemBatchStock>();
					String blockStatus [] = {"Temporary Block","Parmanent Block"};
					 
			if (prescriptionDetailsList != null && prescriptionDetailsList.size() > 0) {
				itemList=new ArrayList<Integer>();
				for(PatientPrescriptionDetails prescriptionDetails:prescriptionDetailsList){
					itemList.add(prescriptionDetails.getItem().getId());
				}
				ArrayList<String> batchNo=null;
				
				ArrayList<String> expiryList=null;
				ArrayList<String> stockList=null;
				
			
				
				for(Integer masStoreitemId:itemList){
					batchNo=new ArrayList<String>();
					expiryList=new ArrayList<String>();
					stockList=new ArrayList<String>();
					masStoreBrandItemList = session
						.createCriteria(StoreItemBatchStock.class)
						.createAlias("Item", "item")
						.createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("item.Id", masStoreitemId))
						.add(Restrictions.or(Restrictions.ge("ExpiryDate", issueDate), Restrictions.isNull("ExpiryDate")))
						.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
						.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
						.addOrder(Order.asc("ExpiryDate")).list();
				
				batchNo.clear();
				expiryList.clear();
				stockList.clear();
				for(StoreItemBatchStock storeItemBatchStock:masStoreBrandItemList){
					if(storeItemBatchStock.getBatchNo()!=null){//added by govind 19-12-2016
					batchNo.add(storeItemBatchStock.getBatchNo());
					}
					if(storeItemBatchStock.getExpiryDate()!=null){
						expiryList.add(HMSUtil.convertDateToStringWithoutTime(storeItemBatchStock.getExpiryDate()));
					}
					stockList.add(String.valueOf(storeItemBatchStock.getClosingStock()));
					
				}
				bachNoMapList.put(masStoreitemId,batchNo );
				ExpiryMapList.put(masStoreitemId, expiryList);
				stockMapList.put(masStoreitemId, stockList);
				
				}
				detailsMap.put("patientPrescriptionDetailsOut",patientPrescriptionDetailsOut);
				detailsMap.put("prescriptionDetailsList",prescriptionDetailsList); 
				detailsMap.put("bachNoMapList",bachNoMapList);
				detailsMap.put("ExpiryMapList",ExpiryMapList);
				detailsMap.put("stockMapList",stockMapList);
				
			}
			
			
			if (nonInsulineprescriptionDetailsList != null && nonInsulineprescriptionDetailsList.size() > 0) {
				detailsMap.put("nonInsulineprescriptionDetailsList",nonInsulineprescriptionDetailsList);
			}

			List<Integer> visitIds=new ArrayList<Integer>(); 
			List<Integer> itemIds=new ArrayList<Integer>();
			int hin_id = 0;
			if(prescriptionDetailsList.size()>0){
				for (PatientPrescriptionDetails prsdeDetails : prescriptionDetailsList) {
					itemIds.add(prsdeDetails.getItem().getId());
					visitIds.add(prsdeDetails.getPrescription().getVisit().getId());
					hin_id = prsdeDetails.getPrescription().getHin().getId();
				}
			}else if(nonInsulineprescriptionDetailsList.size()>0){
				for (Object[] prsdeDetails : nonInsulineprescriptionDetailsList) {
			
					visitIds.add(Integer.parseInt(prsdeDetails[8].toString()));
					hin_id = (Integer.parseInt(prsdeDetails[9].toString()));
				}
			}
		
			
			BigDecimal clos = new BigDecimal(0);
			List<StoreItemBatchStock> masStoreBrandList=new ArrayList<StoreItemBatchStock>();
			Map<Integer,String> mapForAvaliabilityStatus=new HashMap<Integer,String>();
			if(prescriptionDetailsList.size()>0){
			masStoreBrandList = session
					.createCriteria(StoreItemBatchStock.class)
					.createAlias("Item", "item")
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.in("item.Id", itemIds))
					.add(Restrictions.or(Restrictions.ge("ExpiryDate", issueDate), Restrictions.isNull("ExpiryDate")))
					.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
					.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
					.addOrder(Order.asc("ExpiryDate")).list();
			}
			else if(nonInsulineprescriptionDetailsList.size()>0){
				masStoreBrandList = session
					.createCriteria(StoreItemBatchStock.class)
					.createAlias("Item", "item")
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.or(Restrictions.ge("ExpiryDate", issueDate), Restrictions.isNull("ExpiryDate")))
					.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
					.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
					.addOrder(Order.asc("ExpiryDate")).list();
			}
			for (StoreItemBatchStock storeItemBatchStock : masStoreBrandList) {
				mapForAvaliabilityStatus.put(storeItemBatchStock.getItem().getId(), "available");
				clos = clos.add(storeItemBatchStock.getClosingStock());
			}
			if(null !=visitIds && visitIds.size()>0){
			patientList = (List<Visit>) session.createCriteria(Visit.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.in("Id", visitIds)).list();
			}
			else{
				patientList = (List<Visit>) session.createCriteria(Visit.class)
						.createAlias("Hospital", "hospital")
						.createAlias("Hin", "Hin")
						
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.eq("Hin.Id", hinId)).list();
			}
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientList", patientList);
			}

		
			List<Object[]> visitList = new ArrayList<Object[]>();
			String query = "select  a.id,v.visit_date from store_issue_m a, store_issue_t b,visit v where a.id=b.issue_m_id "
					+ "and b.visit_id=v.visit_id and b.issued='y' and v.hin_id="
					+ hin_id
					+ " and a.hospital_id= "
					+ hospitalId
					+ "group by a.id,v.visit_date order by a.id desc LIMIT 2";
			visitList = session.createSQLQuery(query).list();
			detailsMap.put("visitList", visitList);
			if (alreadyissuedDrugList != null
					|| alreadyissuedDrugList.size() > 0) {
				detailsMap.put("alreadyissuedDrugList", alreadyissuedDrugList);
			}
			List<String> issueNoList = new ArrayList<String>();
			
			String query1 = "select issue_no from store_issue_m order by id desc limit 1 ";
			issueNoList = session.createSQLQuery(query1).list();
			String no = "";
			if (issueNoList.size() > 0) {
				for (int i = 0; i < issueNoList.size(); i++) {
					no = ((String) issueNoList.get(i));
				}
			}
			Map<String, Object> maxMap = new HashMap<String, Object>();
			maxMap.put("no", no);
			maxMap.put("deptType", deptType);
			String patientIssueNo = "";

			patientIssueNo = getMaxNoByDeptCode(maxMap);
			detailsMap.put("patientIssueNo", patientIssueNo);
			detailsMap.put("mapForAvaliabilityStatus", mapForAvaliabilityStatus);
			detailsMap.put("prescriptionDetailsList", prescriptionDetailsList);
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return detailsMap;
	}

	// Satish

	public Map<String, Object> showIPBillingWaitingList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		String uhid = box.getString(HIN_NO);
		int ipNo = box.getInt(AD_NO);
		String order_no = box.getString("order_no");

		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Criteria crit = null;

		crit = session.createCriteria(DgOrderhd.class, "dgh").createAlias(
				"dgh.Inpatient", "dgh_inp");
		if (uhid == null && !uhid.equals(""))
			crit.add(Restrictions.eq("dgh_inp.HinNo", uhid));
		if (ipNo != 0)
			crit.add(Restrictions.eq("dgh_inp.Id", ipNo));
		if (order_no == null && !order_no.equals(""))
			crit.add(Restrictions.eq("dgh.OrderNo", order_no));
		dgOrderhdList = crit.list();

		map.put("dgOrderhdList", dgOrderhdList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showIPBillingSearchJsp(Box box) {

		int hinId = 0;
		int inpatientSequence = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientList1 = new ArrayList<Inpatient>();
		List<Patient> PatientList = new ArrayList<Patient>();
		List<AmbulanceRegister>AmbulanceRegisterList=new ArrayList<AmbulanceRegister>();
		
		Session session = (Session) getSession();

		String uhid = box.get("uhid");
		String ipNo = box.get("ipNo");
		String order_no = box.get("order_no");
		int hospitalId=box.getInt("sessionHospitalId");
		System.out.println("hospitalId"+hospitalId);
	
		Criteria crit = null;
		try {

			crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hospital.Id", hospitalId));
			crit.add(Restrictions.in("AdStatus", new String[]{"A","R"}));
			/* crit.add(Restrictions.ne("Id", inpatientSequence)); */

			if (!uhid.equals("")) {
				crit = session.createCriteria(Patient.class);
				crit.add(Restrictions.eq("HinNo", uhid));
				PatientList = crit.list();
				for (Patient pt : PatientList) {
					hinId = pt.getId();
				}

				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId));

				dgOrderhdList = crit.list();
				System.out.println("dgOrderhdList.size()-->"+dgOrderhdList.size());
				if(dgOrderhdList.size()>0){
				for (DgOrderhd dhd : dgOrderhdList) {
					if(dhd.getInpatient()!=null){
					inpatientSequence = dhd.getInpatient().getId();
					}
				}
				}
			}
			if (inpatientSequence > 0) {
				crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hospital.Id", hospitalId));
				crit.add(Restrictions.in("AdStatus", new String[]{"A","R"}));
				crit.add(Restrictions.eq("Id", inpatientSequence));
			}

			if (!ipNo.equals("")) {
				crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("Hospital.Id", hospitalId));
				crit.add(Restrictions.eq("AdNo", ipNo));
				crit.add(Restrictions.in("AdStatus", new String[]{"A","R"}));

			}

			/*
			 * inPatientList=crit.list();
			 */
			if (!order_no.equals("")) {
				crit = session.createCriteria(DgOrderhd.class);
				crit.add(Restrictions.eq("OrderNo", order_no))
				.add(Restrictions.eq("Hospital.Id", hospitalId));
				dgOrderhdList = crit.list();

				for (DgOrderhd dhd : dgOrderhdList) {
					inpatientSequence = dhd.getInpatient().getId();

				}
				if (inpatientSequence > 0) {
					crit = session.createCriteria(Inpatient.class);
					crit.add(Restrictions.eq("AdStatus", "D"));
					crit.add(Restrictions.eq("Id", inpatientSequence))
				    .add(Restrictions.eq("Hospital.Id", hospitalId));
				}
			}
			inPatientList = crit.list();
			//added by govind 31-07-2017
			for(Inpatient ip:inPatientList){
			List<DgOrderdt> dgOrderdtList = session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "hd")
					.createAlias("hd.Inpatient", "ip")
					.add(Restrictions.eq("ip.Id", ip.getId()))
					.add(Restrictions.eq("hd.Hospital.Id", hospitalId))
					.add(Restrictions.eq("PaymentMade","n"))
					.list();
				if(dgOrderdtList.size()>0){
					inPatientList1.add(ip);
				}
			}
			inPatientList=null;
			inPatientList=inPatientList1;
			//added by govind 31-07-2017 end
			AmbulanceRegisterList=session.createCriteria(AmbulanceRegister.class).add(Restrictions.eq("BillStatus", "n")).list();
			map.put("inPatientList", inPatientList);
			map.put("dgOrderhdList", dgOrderhdList);
			map.put("AmbulanceRegisterList", AmbulanceRegisterList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public Map<String, Object> showPaymentAdviceDispensingJsp(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getBillNosByUhid(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showIPBillDispensingJsp(Box box) {
		int inpatId = 0;
		int hinId = 0;
		int inpatientSequence = 0;
		int sessionHospitalId = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();

		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientList1 = new ArrayList<Inpatient>();
		List<Patient> PatientList = new ArrayList<Patient>();
		List<MasInstituteDepartment>deptList=new ArrayList<MasInstituteDepartment>();
		Session session = (Session) getSession();

		String uhid = box.get("uhid");
		String ipNo = box.get("ipNo");
		String patientName = box.get("patientName");
		sessionHospitalId=box.getInt("sessionHospitalId");
		int wardNo = box.getInt("wardNo");
		Criteria crit = null;
		try {
			deptList=session.createCriteria(MasInstituteDepartment.class)
					.createAlias("Department","Department")
					.add(Restrictions.eq("Department.DepartmentType.Id", 10))
					.add(Restrictions.eq("Institute.Id", sessionHospitalId))
					.addOrder(Order.asc("Department.DepartmentName"))
					.list();
			crit = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Hospital.Id", sessionHospitalId));
			crit.add(Restrictions.in("AdStatus", new String[]{"A","R"}));
			/* crit.add(Restrictions.ne("Id", inpatientSequence)); */

			if (!uhid.equals("")) {
				crit = session.createCriteria(Inpatient.class)
						.add(Restrictions.in("AdStatus", new String[]{"A","R"}))
						.createAlias("Hin","Hin")
						.add(Restrictions.eq("Hospital.Id", sessionHospitalId))
				.add(Restrictions.eq("Hin.HinNo", uhid));
				/*PatientList = crit.list();
				for (Patient pt : PatientList) {
					hinId = pt.getId();
					System.out.println(hinId);

				}

				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Hin.Id", hinId));

				dgOrderhdList = crit.list();

				for (DgOrderhd dhd : dgOrderhdList) {
					inpatientSequence = dhd.getInpatient().getId();

				}*/
			}
			
			
			if (!patientName.equals("")) {
				crit = session.createCriteria(Inpatient.class)
						.add(Restrictions.in("AdStatus", new String[]{"A","R"}))
						.createAlias("Hin","Hin")
						.add(Restrictions.eq("Hospital.Id", sessionHospitalId))
				.add(Restrictions.ilike("Hin.FullName","%"+ patientName+"%"));
				/*PatientList = crit.list();
				for (Patient pt : PatientList) {
					hinId = pt.getId();
					System.out.println(hinId);

				}

				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Hin.Id", hinId));

				dgOrderhdList = crit.list();

				for (DgOrderhd dhd : dgOrderhdList) {
					inpatientSequence = dhd.getInpatient().getId();

				}*/
			}
			/*if (inpatientSequence > 0) {
				crit = session.createCriteria(Inpatient.class);
				crit.add(Restrictions.eq("AdStatus", "D"));
				crit.add(Restrictions.eq("Id", inpatientSequence));
			}*/
			/*if (!patientName.equals("")) {

				crit = session.createCriteria(Patient.class);
				crit.add(Restrictions.eq("PFirstName", patientName));
				PatientList = crit.list();
				for (Patient pt : PatientList) {
					hinId = pt.getId();
					System.out.println(hinId);

				}

				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Hin.Id", hinId));

				dgOrderhdList = crit.list();

				for (DgOrderhd dhd : dgOrderhdList) {
					inpatientSequence = dhd.getInpatient().getId();

				}
			}
			if (inpatientSequence > 0) {
				crit = session.createCriteria(Inpatient.class);
				crit.add(Restrictions.eq("AdStatus", "D"));
				crit.add(Restrictions.eq("Id", inpatientSequence));
			}*/

			if (!ipNo.equals("")) {

				crit = session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("AdNo", ipNo))
						.add(Restrictions.eq("Hospital.Id", sessionHospitalId))
						.add(Restrictions.in("AdStatus", new String[]{"A","R"}));
				//crit.add(Restrictions.eq("AdStatus", "D"));

			}

			if (wardNo > 0) {System.out.println("wardNo "+wardNo);
				crit = session.createCriteria(Inpatient.class)
						//.add(Restrictions.eq("AdStatus", "D"))
						.add(Restrictions.eq("Hospital.Id", sessionHospitalId))
						.add(Restrictions.eq("Department.Id", wardNo));
				inPatientList1 = crit.list();

				for (Inpatient inpat : inPatientList) {
					inpatId = inpat.getId();
					System.out.println(inpatId);
				}

			}

			inPatientList1 = crit.list();
			for(Inpatient inpat:inPatientList1){
			List<IpWardConsumptionDetails> consumpList=new ArrayList<IpWardConsumptionDetails>();
			consumpList=session.createCriteria(IpWardConsumptionDetails.class)
					.createAlias("Consumption", "con")
					//.createAlias("Stock", "stock")
					.add(Restrictions.eq("con.Inpatient.Id", inpat.getId()))
					.add(Restrictions.eq("con.Hospital.Id", sessionHospitalId))
					.add(Restrictions.eq("con.BillStatus", "y").ignoreCase())
					.add(Restrictions.isNotNull("Stock"))
					.list();
				if(consumpList.size()>0){
					inPatientList.add(inpat);
				}
			}
			
			map.put("inPatientList", inPatientList);
			map.put("dgOrderhdList", dgOrderhdList);
			map.put("masDeptList",deptList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;

	}

	public Map<String, Object> waitingListBookingPaward(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId=box.getInt(HOSPITAL_ID);
		String uhid = box.getString("uhid");
		String ipNo = box.getString("ipNo");
		String patientName = box.getString("patientName");
		String mobile = box.getString("mobileNo");

		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<OpdPatientDetails> opdPatientDetailList = new ArrayList<OpdPatientDetails>();
		List<OpdPatientDetails> tempOpdPatientDetailList = new ArrayList<OpdPatientDetails>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Criteria crit = null;

		crit = session.createCriteria(Patient.class).createAlias("Hin", "h");

		crit = session.createCriteria(Transfer.class)
				.createAlias("ToWard", "toWard")
				.createAlias("Hin", "h")
				.add(Restrictions.eq("toWard.PaywardCheck", "y").ignoreCase())
				.add(Restrictions.eq("RequestStatus", "p").ignoreCase())
				.add(Restrictions.eq("RequestStatus", "p").ignoreCase())
				.add(Restrictions.or(Restrictions.isNull("PaywardBookingStatus"), Restrictions.eq("PaywardBookingStatus", "n").ignoreCase()))
//				
				.add(Restrictions.eq("AdStatus", "a").ignoreCase())
				.add(Restrictions.eq("Hospital.Id",
						hospitalId));
		
		// edited by Amit Das on 23-05-2016
		Criteria crit1=session
				.createCriteria(OpdPatientDetails.class, "opdpatientdetails")
				.createAlias("opdpatientdetails.Visit", "visit")
			//	.createAlias("AdmissionWard", "referedDepartment")
				.createAlias("visit.Hin", "h")
			//	.add(Restrictions.eq("referedDepartment.PaywardCheck", "y").ignoreCase())
				.add(Restrictions.eq("opdpatientdetails.PayWardCheckedStatus", "Y").ignoreCase())
			    .add(Restrictions.or(Restrictions.isNull("PaywardBookingStatus"), Restrictions.eq("PaywardBookingStatus", "n").ignoreCase()))
				/*.add(Restrictions.eq("opdpatientdetails.AdmissionAdvised",
						"y".toLowerCase()).ignoreCase())*/
				.add(Restrictions.eq("opdpatientdetails.Hospital.Id",
						hospitalId))
				/*.add(Restrictions.eq("opdpatientdetails.ReferredHospital.Id",
						hospitalId))*/
				.add(Restrictions.le("opdpatientdetails.AdmissionDate",
						HMSUtil.getDateWithoutTime(new Date())));
		
		Criteria crit2 = session.createCriteria(Inpatient.class).createAlias("Department", "ward").createAlias("Hin", "h")
									.add(Restrictions.eq("ward.PaywardCheck", "y").ignoreCase())
									.add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("AdStatus", "w").ignoreCase());
		
		
		
		
		if(!box.getString("uhid").equals(""))
		{
			crit.add(Restrictions.eq("h.HinNo", box.getString("uhid")));
			crit1.add(Restrictions.eq("h.HinNo", box.getString("uhid")));
			crit2.add(Restrictions.eq("h.HinNo", box.getString("uhid")));
		}
		
		if(!box.getString("patientName").equals(""))
		{
			crit.add(Restrictions.ilike("h.PFirstName", "%"+box.getString("patientName").toLowerCase()+"%"));
			crit1.add(Restrictions.ilike("h.PFirstName", "%"+box.getString("patientName").toLowerCase()+"%"));
			crit2.add(Restrictions.ilike("h.PFirstName", "%"+box.getString("patientName").toLowerCase()+"%"));
		}
		
		if(!box.getString("mobileNo").equals(""))
		{
			crit.add(Restrictions.eq("h.HinNo", box.getString("mobileNo")));
			crit1.add(Restrictions.eq("h.HinNo", box.getString("mobileNo")));
			crit2.add(Restrictions.eq("h.HinNo", box.getString("mobileNo")));
		}
		
		if(!box.getString("ipNo").equals(""))
		{
			crit.createAlias("Inpatient", "ip");
			crit.add(Restrictions.eq("ip.AdNo", box.getString("ipNo")));
			crit.add(Restrictions.eq("AdNo", box.getString("ipNo")));
			
		}

		/*
		 * if (!uhid.equals("")) { crit = crit.add(Restrictions.eq("h.HinNo",
		 * uhid)) .add(Restrictions.eq("AdStatus", "A").ignoreCase());
		 * 
		 * }
		 */
		/*
		 * if (!patientName.equals("")) { crit =
		 * crit.add(Restrictions.ilike("h.PFirstName", patientName + "%"))
		 * .add(Restrictions.eq("AdStatus", "D").ignoreCase()); } if
		 * (!mobile.equals("")) { crit =
		 * crit.add(Restrictions.eq("h.MobileNumber", mobile))
		 * .add(Restrictions.eq("AdStatus", "D").ignoreCase());
		 * 
		 * } if (!ipNo.equals("")) { crit = crit.add(Restrictions.eq("AdNo",
		 * ipNo)) .add(Restrictions.eq("AdStatus", "D").ignoreCase());
		 * 
		 * }
		 */
		transferList = crit.list();
		tempOpdPatientDetailList=crit1.list();
		
		if(tempOpdPatientDetailList.size()>0){
			for(OpdPatientDetails opdPatientDetails :tempOpdPatientDetailList){
				List<Object[]> list = session.createCriteria(Inpatient.class).createAlias("Hin", "h").add(Restrictions.eq("h.Id", opdPatientDetails.getVisit().getHin().getId()))
									.add(Restrictions.eq("AdStatus", "A")).list();
				if(list.size() == 0){
					opdPatientDetailList.add(opdPatientDetails);
				}
			}
		}
		
		inpatientList=crit2.list();
		System.out.println("inpatientList======="+inpatientList.size());
		map.put("transferList", transferList);
		map.put("patientList", patientList);
		map.put("opdPatientDetailList", opdPatientDetailList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String, Object> bookingPayward(Box box) {
		
		String paywardroomtypecode = "";
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("billing.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			paywardroomtypecode = prop.getProperty("paywardroomtypecode");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int hospitalId=0;
		if(box.getInt("hospitalId")!=0){
			hospitalId=box.getInt("hospitalId");
		}
		System.out.println("hospitalId>>>>> "+hospitalId);
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String uhid = box.getString("uhid");
		System.out.println("<<<<<<<<Uhid>>>>>>>>>>" + uhid);
		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<MasDepartment> departList = new ArrayList<MasDepartment>();
		List<MasRoom> roomList = new ArrayList<MasRoom>();
		List<MasRoomType> roomTypeList = new ArrayList<MasRoomType>();
		List<MasChargeCode> masCharCodeList = new ArrayList<MasChargeCode>();
		List<BlPriority> blPriorities=new ArrayList<BlPriority>();
		List<MasDepartment> wardDepartment = new ArrayList<MasDepartment>(); // added by amit das on 20-05-2016
		int currentwaitingList=1;

		String ipNo = box.getString("ipNo");
		int wardId=0;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		if(box.getInt("opdDetailsid")!=0)
		{
			OpdPatientDetails opdPatientDetails=(OpdPatientDetails) hbt.get(OpdPatientDetails.class, box.getInt("opdDetailsid"));			
			map.put("opdPatientDetails", opdPatientDetails);
			if(opdPatientDetails.getAdmissionWard()!=null)
			{
				wardId=opdPatientDetails.getAdmissionWard().getId();
				Number maxWaiting=(Number)session.createCriteria(BlPaywardBooking.class)
					.add(Restrictions.eq("BookingStatus","p").ignoreCase())
					.add(Restrictions.eq("Payward.Id",opdPatientDetails.getAdmissionWard().getId()))
					.setProjection(Projections.projectionList().add(Projections.max("CurrentWaitingList"))).uniqueResult();
				if(maxWaiting!=null)
				{
					currentwaitingList=maxWaiting.intValue()+1;
				}
			}
			
		}
		else if(box.getInt("transferId")!=0)
		{
				Transfer transfer=(Transfer) hbt.get(Transfer.class, box.getInt("transferId"));
				map.put("transfer", transfer);
				if(transfer.getToWard()!=null)
				{
				Number maxWaiting=(Number) session.createCriteria(BlPaywardBooking.class)
						.add(Restrictions.eq("BookingStatus","p").ignoreCase())
						.add(Restrictions.eq("Payward.Id",transfer.getToWard().getId()))
						.setProjection(Projections.projectionList().add(Projections.max("CurrentWaitingList"))).uniqueResult();
				if(maxWaiting!=null)
				{
					currentwaitingList=maxWaiting.intValue()+1;
				}
				}
		}else if(box.getInt("inpatientId")!=0)
		{
			Inpatient inpatient=(Inpatient) hbt.get(Inpatient.class, box.getInt("inpatientId"));
			map.put("inpatient", inpatient);
			if(inpatient.getDepartment()!=null)
			{
			Number maxWaiting=(Number) session.createCriteria(BlPaywardBooking.class)
					.add(Restrictions.eq("BookingStatus","p").ignoreCase())
					.add(Restrictions.eq("Payward.Id",inpatient.getDepartment().getId()))
					.setProjection(Projections.projectionList().add(Projections.max("CurrentWaitingList"))).uniqueResult();
			if(maxWaiting!=null)
			{
				currentwaitingList=maxWaiting.intValue()+1;
			}
			}
	}
//		Criteria crit = null;
//		crit = session.createCriteria(Patient.class).add(
//				Restrictions.eq("HinNo", uhid));
//
//		patientList = crit.list();
//		int patientId = 0;
//		for (Patient pat : patientList) {
//			patientId = pat.getId();
//		}
//
//		crit = session.createCriteria(Transfer.class).createAlias("Hin", "pat")
//				.add(Restrictions.eq("pat.Id", patientId));
//
//		transferList = crit.list();

		
		// added by amit das on 20-05-2016
		int depWard =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "warddepartmenttype".trim()));
		wardDepartment=session.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Institute.Id", hospitalId))
				.createAlias("Department","dep")
				.add(Restrictions.eq("dep.DepartmentType.Id",depWard)).add(Restrictions.eq("dep.PaywardCheck","y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.groupProperty("Department")))
				.list();
		
		
		Criteria crit = session.createCriteria(MasBankMaster.class)
				.add(
						Restrictions.eq("Status", "y").ignoreCase());
		bankList = crit.list();

		crit = session.createCriteria(MasDepartment.class)
				.add(
						Restrictions.eq("Status", "y").ignoreCase())
						.add(
				Restrictions.eq("PaywardCheck", "y").ignoreCase());
		departList = crit.list();

		crit = session.createCriteria(MasRoom.class)
				.createAlias("Department", "dep")
				.add(Restrictions.eq("dep.Id", 2));
		
		roomList = crit.list();		
		roomTypeList=session.createCriteria(MasRoomType.class)
				.add(Restrictions.in("RoomTypeCode", paywardroomtypecode.split(",")))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		crit = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chId")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("chId.ChargeTypeCode", "room").ignoreCase());
		masCharCodeList = crit.list();
		int totalBedPayward=0;
		int occupiedBedPayWard=0;
		int vacantBedPayWard=0;
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		totalBedPayward=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				
				.setProjection(Projections.count("Id")).list().get(0));
		}
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("BedStatus.Id", 5)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		occupiedBedPayWard=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("BedStatus.Id", 5))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.count("Id"))
				.list()
				.get(0));
		}
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("BedStatus.Id", 6)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		vacantBedPayWard=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("BedStatus.Id", 6))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.count("Id"))
				.list()
				.get(0));
		}
		blPriorities=session.createCriteria(BlPriority.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
        map.put("blPriorities",blPriorities);
		map.put("masCharCodeList", masCharCodeList);
		map.put("roomList", roomList);
		map.put("departList", departList);
		map.put("bankList", bankList);
/*		map.put("patientList", patientList);
		map.put("transferList", transferList);*/
		map.put("roomTypeList", roomTypeList);
		map.put("currentwaitingList", currentwaitingList);
		map.put("totalBedPayward",totalBedPayward);
		map.put("occupiedBedPayWard",occupiedBedPayWard);
		map.put("vacantBedPayWard",vacantBedPayWard);
		map.put("wardDepartment", wardDepartment);
		return map;
	}

	public Map<String, Object> waitingListAllotmentPayward(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		int hospitalId=box.getInt(HOSPITAL_ID);
		String uhid = box.getString("uhid");
		String ipNo = box.getString("ipNo");
		String patientName = box.getString("patientName");
		String mobile = box.getString("mobileNo");
		
		List<BlPaywardBooking> blPaywardBookingList=new ArrayList<BlPaywardBooking>();

		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<BlReceiptHeader> blhdrList = new ArrayList<BlReceiptHeader>();
		Criteria crit = null;
		Criteria criteria=null;
		/*criteria=session.createCriteria(BlPaywardBooking.class)
				            .createAlias("Hin", "h")
				            .createAlias("Priority", "p")
				            .add(Restrictions.eq("BookingStatus", "a").ignoreCase())
				            .add(Restrictions.eq("Hospital.Id", hospitalId))
				            .addOrder(Order.asc("p.Priority"));*/
		criteria = session.createCriteria(BlReceiptHeader.class)
				           .createAlias("Booking","book")
		                  .add(Restrictions.eq("Hospital.Id", hospitalId))
				          .add(Restrictions.eq("Status", "A").ignoreCase())
		                  .add(Restrictions.eq("book.BookingStatus", "a").ignoreCase());
	   if(!box.getString("uhid").equals(""))
		{
			criteria
			.createAlias("Hin", "h")
			.add(Restrictions.eq("h.HinNo", box.getString("uhid")));
		}
		
		if(!box.getString("patientName").equals(""))
		{
			criteria
			.createAlias("Hin", "hi")
			.add(Restrictions.ilike("hi.PFirstName", "%"+box.getString("patientName").toLowerCase()+"%"));
		}
		
		if(!box.getString("mobileNo").equals(""))
		{
			criteria
			.createAlias("Hin", "hin")
			.add(Restrictions.eq("hin.MobileNumber", box.getString("mobileNo")));
		}
		
		if(!box.getString("ipNo").equals(""))
		{
			criteria
			.createAlias("Inpatient", "ip")
			.add(Restrictions.eq("ip.AdNo", box.getString("ipNo")));
		}
		/*blPaywardBookingList=criteria.list();*/
		/*System.out.println("liist"+blPaywardBookingList.size());*/
		

		/*
		 * crit = session.createCriteria(Transfer.class).createAlias("FromWard",
		 * "fromWard") .add(Restrictions.eq("fromWard.Id", 10))
		 * .add(Restrictions.eq("RequestStatus", "p").ignoreCase())
		 * .add(Restrictions.eq("AdStatus", "A").ignoreCase());
		 * transferList=crit.list(); int transferId=0; for(Transfer
		 * tanrs:transferList){ transferId=tanrs.getId();
		 * System.out.println("transferId"+transferId); }
		 */
		crit = session.createCriteria(BlReceiptHeader.class)
				     /* .createAlias("Inpatient", "ip")
                      .createAlias("Hin", "h")
                      .createAlias("Hospital", "hos")
                      .add(Restrictions.eq("Hospital.Id", hospitalId))*/
				      .add(Restrictions.eq("Status", "a").ignoreCase());

		blhdrList = criteria.list();
		System.out.println("blhdrList>>>>>" + blhdrList.size());
		/*System.out.println("blPaywardBookingListblPaywa>>>>>>>>>"+blPaywardBookingList);*/
		/*
		 * Inpatient ipatien=new Inpatient(); int ipSequence=0; List<Inpatient>
		 * inpatient=new ArrayList<Inpatient>(); crit =
		 * session.createCriteria(Inpatient.class).createAlias("Hin",
		 * "hin").add(Restrictions.eq("Hin.Id", uhid)); inpatient=crit.list();
		 * for(Inpatient ip:inpatient){ ipSequence=ip.getIcdId(); }
		 * ipatien.setIcdId(ipSequence);
		 */

		map.put("blhdrList", blhdrList);
		map.put("transferList", transferList);
		map.put("patientList", patientList);
		map.put("blPaywardBookingList", blPaywardBookingList);
		return map;
	}

	public Map<String, Object> allotmentPayward(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String uhid = box.getString("uhid");
		int hospitalId=box.getInt(HOSPITAL_ID);
		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<Integer> inPatientList = new ArrayList<Integer>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<MasDepartment> departList = new ArrayList<MasDepartment>();
		List<MasRoom> roomList = new ArrayList<MasRoom>();
		List<MasChargeCode> masCharCodeList = new ArrayList<MasChargeCode>();
		List<BlReceiptHeader> blrecepitHdr = new ArrayList<BlReceiptHeader>();
		BlReceiptHeader blReceiptHeader=null;
		String ipNo = box.getString("ipNo");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Criteria crit = null;
		int wardId=0;
		BlPaywardBooking blPaywardBooking=null;
		crit=session.createCriteria(BlPaywardBooking.class)
				.add(Restrictions.eq("BookingStatus", "a").ignoreCase())
				.add(Restrictions.eq("Id", box.getInt("bookingId")))
	            .add(Restrictions.eq("Hospital.Id", hospitalId));
		
		blPaywardBooking=(BlPaywardBooking) crit.uniqueResult();
	
		if(blPaywardBooking.getOpdPatientDetails()!=null && blPaywardBooking.getOpdPatientDetails().getAdmissionWard()!=null){
			wardId=blPaywardBooking.getOpdPatientDetails().getAdmissionWard().getId();
		}
		if(blPaywardBooking.getTransfer()!=null)
		{
			wardId=blPaywardBooking.getTransfer().getInpatient().getDepartment().getId();
			blReceiptHeader=(BlReceiptHeader) session.createCriteria(BlReceiptHeader.class)
					        .add(Restrictions.eq("Transfer.Id", blPaywardBooking.getTransfer().getId()))
					        .addOrder(Order.desc("Id"))
					        .setFirstResult(0)
					        .setMaxResults(1)
					        .uniqueResult();
		}
		else if(blPaywardBooking.getOpdPatientDetails()!=null)
		{
			blReceiptHeader=(BlReceiptHeader) session.createCriteria(BlReceiptHeader.class)
			        .add(Restrictions.eq("OpdPatientDetail.Id", blPaywardBooking.getOpdPatientDetails().getId()))
			        .addOrder(Order.desc("Id"))
					        .setFirstResult(0)
					        .setMaxResults(1)
			        .uniqueResult();
		}else{
			
			wardId=blPaywardBooking.getInpatient().getDepartment().getId();
			blReceiptHeader=(BlReceiptHeader) session.createCriteria(BlReceiptHeader.class)
			        .add(Restrictions.eq("Inpatient.Id", blPaywardBooking.getInpatient().getId()))
			        .addOrder(Order.desc("Id"))
					        .setFirstResult(0)
					        .setMaxResults(1)
			        .uniqueResult();
			
		}
		crit = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", uhid));

		patientList = crit.list();
		int patientId = 0;
		for (Patient pat : patientList) {
			patientId = pat.getId();
			System.out.println("patientId" + patientId);
		}

		crit = session.createCriteria(Transfer.class).createAlias("Hin", "pat")
				.add(Restrictions.eq("pat.Id", patientId));

		transferList = crit.list();
		System.out.println("patientId==="+ box.getInt("hinId"));
		inPatientList = session.createCriteria(Inpatient.class).createAlias("Hin", "pt").add(Restrictions.eq("pt.Id", box.getInt("hinId")))
								.setProjection(Projections.max("Id")).list();
		if(inPatientList.size()>0){
			int inPatientId = 0;
			if(inPatientList.get(0) != null){
				 inPatientId = inPatientList.get(0);
				map.put("inPatientId", inPatientId);
				System.out.println("inPatientId==="+ inPatientId);
			}
		}
		
		crit = session.createCriteria(MasBankMaster.class);
		bankList = crit.list();

		crit = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("PaywardCheck", "y").ignoreCase());
		departList = crit.list();

		crit = session.createCriteria(MasRoom.class)
				.createAlias("Department", "dep")
				.add(Restrictions.eq("dep.Id", 2));
		roomList = crit.list();

		crit = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chId")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("chId.ChargeTypeCode", "room")
						.ignoreCase());
		
		masCharCodeList = crit.list();
		crit = session.createCriteria(BlReceiptHeader.class).add(
				Restrictions.eq("Status", "A").ignoreCase());
		
		blrecepitHdr = crit.list();
		System.out.println("blrecepitHdr" + blrecepitHdr.size());
		int totalBedPayward=0;
		int occupiedBedPayWard=0;
		int vacantBedPayWard=0;
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		totalBedPayward=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				
				.setProjection(Projections.count("Id")).list().get(0));
		}
		System.out.println("totalBedPayward==="+totalBedPayward);
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("BedStatus.Id", 5)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		occupiedBedPayWard=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("BedStatus.Id", 5))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.count("Id"))
				.list()
				.get(0));
		}
		System.out.println("occupiedBedPayWard==="+occupiedBedPayWard);
		if(session.createCriteria(MasBed.class).add(Restrictions.eq("Department.Id", wardId)).add(Restrictions.eq("BedStatus.Id", 6)).add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.count("Id")).list().size()>0){
		vacantBedPayWard=Integer.parseInt(""+session.createCriteria(MasBed.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", wardId))
				.add(Restrictions.eq("BedStatus.Id", 6))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.count("Id"))
				.list()
				.get(0));
		}
		System.out.println("vacantBedPayWard==="+vacantBedPayWard);
		map.put("blrecepitHdr", blrecepitHdr);
		map.put("masCharCodeList", masCharCodeList);
		map.put("roomList", roomList);
		map.put("departList", departList);
		map.put("bankList", bankList);
		map.put("patientList", patientList);
		map.put("transferList", transferList);
		map.put("blPaywardBooking", blPaywardBooking);
		map.put("blReceiptHeader", blReceiptHeader);
		map.put("totalBedPayward", totalBedPayward);
		map.put("occupiedBedPayWard", occupiedBedPayWard);
		map.put("vacantBedPayWard", vacantBedPayWard);
		map.put("inPatientList", inPatientList);
		return map;
	}

	public Map<String, Object> billWaitingListRenewalSearch(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		String uhid = box.getString("uhid");
		String ipNo = box.getString("ipNo");
		String patientName = box.getString("patientName");
		String mobile = box.getString("mobileNo");

		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<BlReceiptHeader> blhdrList = new ArrayList<BlReceiptHeader>();
		List<BlPaywardBooking> blPaywardBookingList=new ArrayList<BlPaywardBooking>();	
		blPaywardBookingList=session.createCriteria(BlPaywardBooking.class)
				.createAlias("Payward", "bookingdept")
				.createAlias("Inpatient", "ip")
				.createAlias("ip.Department", "dept")
				.createAlias("Hospital", "h")
	            .add(Restrictions.eq("BookingStatus", "c").ignoreCase())
	             .add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)))
	              .add(Restrictions.eqProperty("dept.Id", "bookingdept.Id"))
	            .list();
		Iterator<BlPaywardBooking> iterator=blPaywardBookingList.iterator();
		while (iterator.hasNext()) {
			BlPaywardBooking blPaywardBooking = (BlPaywardBooking) iterator
					.next();
			Calendar bedAllotmentDate=Calendar.getInstance();
			bedAllotmentDate.setTime(blPaywardBooking.getBedAllotmentDate());
			bedAllotmentDate.add(Calendar.DATE, blPaywardBooking.getNumberOfDays());
			bedAllotmentDate.set(Calendar.HOUR_OF_DAY, 0);
			bedAllotmentDate.set(Calendar.MINUTE, 0);
			bedAllotmentDate.set(Calendar.SECOND, 0);
			bedAllotmentDate.set(Calendar.MILLISECOND, 0);
			
			Calendar currentDate=Calendar.getInstance();
			currentDate.setTime(new Date());
			bedAllotmentDate.add(Calendar.DATE, -2);
			currentDate.set(Calendar.HOUR_OF_DAY, 0);
			currentDate.set(Calendar.MINUTE, 0);
			currentDate.set(Calendar.SECOND, 0);
			currentDate.set(Calendar.MILLISECOND, 0);
			if(bedAllotmentDate.compareTo(currentDate)>0)
			{
				iterator.remove();
			}
			
		}
		Criteria crit = null;

		//crit = session.createCriteria(Patient.class).createAlias("Hin", "h");

		crit = session.createCriteria(BlReceiptHeader.class).add(
				Restrictions.eq("Status", "R").ignoreCase());

		if (!uhid.equals("")) {
			crit = crit.createAlias("Hin", "h").add(Restrictions.eq("h.HinNo", uhid));
		}
		blhdrList = crit.list();

		map.put("blhdrList", blhdrList);
		map.put("transferList", transferList);
		map.put("patientList", patientList);
		map.put("blPaywardBookingList", blPaywardBookingList);
		return map;
	}

	public Map<String, Object> renewalPayward(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String uhid = box.getString("uhid");
		System.out.println("<<<<<<<<Uhid>>>>>>>>>>" + uhid);
		List<Patient> patientList = new ArrayList<Patient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
		List<MasDepartment> departList = new ArrayList<MasDepartment>();
		List<MasRoom> roomList = new ArrayList<MasRoom>();
		List<MasChargeCode> masCharCodeList = new ArrayList<MasChargeCode>();
		List<BlReceiptHeader> blreceptHdr = new ArrayList<BlReceiptHeader>();
		List<BlReceiptHeader> blAllotHdrList = new ArrayList<BlReceiptHeader>();
		String ipNo = box.getString("ipNo");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Criteria crit = null;
		BlPaywardBooking blPaywardBooking=null;
		crit=session.createCriteria(BlPaywardBooking.class)
				.add(Restrictions.eq("Id", box.getInt("bookingId")))
	            .add(Restrictions.eq("Hospital.Id", box.getInt(HOSPITAL_ID)));
		
		blPaywardBooking=(BlPaywardBooking) crit.uniqueResult();
		
		crit = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", uhid));

		patientList = crit.list();
		int patientId = 0;
		for (Patient pat : patientList) {
			patientId = pat.getId();

		}

		crit = session.createCriteria(Transfer.class).createAlias("Hin", "pat")
				.add(Restrictions.eq("pat.Id", patientId));

		transferList = crit.list();
		crit = session.createCriteria(MasBankMaster.class);
		bankList = crit.list();

		crit = session.createCriteria(MasDepartment.class).add(
				Restrictions.eq("PaywardCheck", "y").ignoreCase());
		departList = crit.list();

		crit = session.createCriteria(MasRoom.class)
				.createAlias("Department", "dep")
				.add(Restrictions.eq("dep.Id", 2));
		roomList = crit.list();

		crit = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chId")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("chId.ChargeTypeCode", "room").ignoreCase());
		masCharCodeList = crit.list();

		crit = session.createCriteria(BlReceiptHeader.class).add(
				Restrictions.eq("Status", "r").ignoreCase());
		blreceptHdr = crit.list();
		crit = session.createCriteria(BlReceiptHeader.class).add(
				Restrictions.eq("Status", "a").ignoreCase());
		blAllotHdrList = crit.list();
		System.out.println("blreceptHdr>>>>>>>" + blAllotHdrList.size());

		map.put("blAllotHdrList", blAllotHdrList);
		map.put("blreceptHdr", blreceptHdr);
		map.put("masCharCodeList", masCharCodeList);
		map.put("roomList", roomList);
		map.put("departList", departList);
		map.put("bankList", bankList);
		map.put("patientList", patientList);
		map.put("transferList", transferList);
		map.put("blPaywardBooking", blPaywardBooking);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.billing.dataservice.BillingDataService#submitPaywardDetails(jkt
	 * .hms.util.Box)
	 */

	public Map<String, Object> submitPaywardDetails(
			Map<String, Object> parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		int userId = 0;
		int hinId = 0;
		int inpatientId = 0;
		int transferId = 0;
		int opdPatientDetailsId = 0;
		int receiptHeaderId = 0;
		
		String userName = "";

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		hospitalId=box.getInt(HOSPITAL_ID);
		userId=box.getInt(USER_ID);
		hinId=box.getInt(HIN_ID);
		inpatientId=box.getInt(INPATIENT_ID);
		transferId=box.getInt("transferId");
		opdPatientDetailsId=box.getInt("opdpatientdetailId");
		
		Session session = null;
		session = (Session) getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			String receiptNo = box.getString("receiptNo");
			String receiptDate = (String)utilMap.get("currentDate");
			String receiptTime = (String)utilMap.get("currentTime");
			String totalAdvAmt = box.getString(TOTAL_AMOUNT);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
//-----------------------------------------------------------------------------------			
			BlPaywardBooking blPaywardBooking=new BlPaywardBooking();
			if(transferId!=0)
			{
			Transfer transfer = (Transfer) hbt.get(Transfer.class, transferId);
			blPaywardBooking.setTransfer(transfer);
			transfer.setPaywardBookingStatus("y");
			}
			else if(opdPatientDetailsId!=0)
			{
				OpdPatientDetails opdPatientDetails=(OpdPatientDetails) hbt.get(OpdPatientDetails.class, opdPatientDetailsId);
				blPaywardBooking.setOpdPatientDetails(opdPatientDetails);
				opdPatientDetails.setPaywardBookingStatus("y");
			}
			blPaywardBooking.setBookingStatus("p");
			blPaywardBooking.setAmount(new BigDecimal(box.getFloat("amtt")));
			blPaywardBooking.setAmountPaid(new BigDecimal(totalAdvAmt));
			blPaywardBooking.setAmountAdjusted((new BigDecimal(box.getFloat("adjusetCreditId"))));
			blPaywardBooking.setChargeRate(new BigDecimal(box.getFloat("roomChargeId")));
			MasChargeCode chargeCode=new MasChargeCode();
			chargeCode.setId(box.getInt(RequestConstants.CHARGE_ID));
			blPaywardBooking.setChargeCode(chargeCode);
			blPaywardBooking.setNumberOfDays(box.getInt("numOfDaysId"));
			MasDepartment payward=new MasDepartment();
			payward.setId(box.getInt("ward"));
			blPaywardBooking.setPayward(payward);
			MasRoomType roomType=new MasRoomType();
			roomType.setId(box.getInt("roomtypeId"));
			if(box.getInt("priority")!=0)
			{
		    BlPriority priority=new BlPriority();
			priority.setId(box.getInt("priority"));
			blPaywardBooking.setPriority(priority);
			}
			blPaywardBooking.setRoomType(roomType);
			blPaywardBooking.setCurrentWaitingList(box.getInt("currentWaiting"));
			Patient patient = new Patient();
			patient.setId(hinId);
			blPaywardBooking.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				blPaywardBooking.setInpatient(inpatient);
			}
			
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			blPaywardBooking.setHospital(hospital);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			blPaywardBooking.setLastChgBy(user);
			blPaywardBooking.setBookingDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blPaywardBooking.setBookingTime((String)utilMap.get("currentTime"));
			blPaywardBooking.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blPaywardBooking.setLastChgTime((String)utilMap.get("currentTime"));
			hbt.save(blPaywardBooking);

			// --------------------- Receipt
			// Entry-------------------------------------

			BlReceiptHeader receiptHeader = new BlReceiptHeader();

			if(transferId!=0)
			{
			Transfer transfer = new Transfer();
			transfer.setId(transferId);
			receiptHeader.setTransfer(transfer);
			}else if(opdPatientDetailsId!=0)
			{
				OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
				opdPatientDetails.setId(opdPatientDetailsId);
				receiptHeader.setOpdPatientDetail(opdPatientDetails);
			}
			receiptHeader.setReceiptNo(receiptNo);
			
			receiptHeader.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				receiptHeader.setInpatient(inpatient);
			}

			receiptHeader.setReceiptType("adv");
			receiptHeader.setAmount(new BigDecimal(totalAdvAmt));
			if (receiptDate != null && !receiptDate.equals("")) {
				receiptHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(receiptDate));
			}
			receiptHeader.setBooking(blPaywardBooking);

			receiptHeader.setReceiptTime(receiptTime);
			
			receiptHeader.setHospital(hospital);

			
			receiptHeader.setChangedBy(user);
			receiptHeader.setStatus("A");
			hbt.save(receiptHeader);
			receiptHeaderId = receiptHeader.getId();
			int payListLength = 0;
			payListLength = box.getInt("hiddenValuePayment");

			if (payListLength > 0) {
				for (int i = 1; i <= payListLength; i++) {
					BlReceiptDetails receiptDetails = new BlReceiptDetails();
					if (!box.getString(PAYMENT_MODE + i).equals("")) {
						receiptDetails.setPaymentMode(box
								.getString(PAYMENT_MODE + i));
						receiptDetails.setAdvanceAmountType(box
								.getString(ADVANCE_AMOUNT_TYPE + i));

						BigDecimal amtReceived = new BigDecimal(
								box.getInt(AMOUNT_RECEIVED + i));
						receiptDetails.setAmount(amtReceived);

						if (!box.getString(CHEQUE_NO + i).equals(""))
							receiptDetails.setChequeNo(box.getString(CHEQUE_NO
									+ i));

						if (!box.getString(CHEQUE_DATE + i).equals(""))
							receiptDetails.setChequeDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString(CHEQUE_DATE + i)));

						if (box.getInt(BANK_ID + i) != 0) {
							MasBankMaster bankMaster = new MasBankMaster();
							bankMaster.setId(box.getInt(BANK_ID + i));
							receiptDetails.setBank(bankMaster);
						}
						receiptDetails.setReceiptDate(HMSUtil
								.convertStringTypeDateToDateType(receiptDate));
						receiptDetails.setReceiptTime(receiptTime);
						receiptDetails.setChangedBy(user);
						receiptDetails.setReceiptHeader(receiptHeader);
						try {
							hbt.save(receiptDetails);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			
			
			BigDecimal pastDue = new BigDecimal(0);
			Patient hin = (Patient) hbt.load(Patient.class, hinId);
			if (hin.getPastDue() != null)
				pastDue = new BigDecimal(hin.getPastDue());
			
//				pastDue = pastDue.add(new BigDecimal(box.getFloat("avAdvAmtId")));
			
//			if (!remainCId.equals(0)) {
//				pastDueBD = pastDueBD.add(remainCId);
//			}
				System.out.println("pastDue=========="+pastDue);
			if (pastDue.compareTo(BigDecimal.ZERO)<=0) {
					if((new BigDecimal(box.getFloat("adjusetCreditId"))).compareTo(BigDecimal.ZERO)<=0)
							{
						pastDue = pastDue.subtract(new BigDecimal(box.getFloat("adjusetCreditId")));
							}
					else
					{
						pastDue = pastDue.subtract(new BigDecimal(box.getFloat("adjusetCreditId")));
					}
				}
				else
				{
					if((new BigDecimal(totalAdvAmt)).compareTo(BigDecimal.ZERO)<=0)
					{
				pastDue = pastDue.subtract(new BigDecimal(box.getFloat("adjusetCreditId")));
					}
			else
			{
				pastDue = pastDue.subtract(new BigDecimal(box.getFloat("adjusetCreditId")));
			}
			}
			
			

			BigDecimal newAmt = new BigDecimal(0);
//			if (pastDue.compareTo(BigDecimal.ZERO)<=0) {
//				
//			}
//			else
//			{
//				
//			}
//			newAmt = pastDue.add(new BigDecimal(totalAdvAmt));
			hin.setPastDue(pastDue.toString());
			hbt.update(hin);
            MasRoomType masRoomType=(MasRoomType) hbt.get(MasRoomType.class, box.getInt("roomtypeId"));
            map.put("roomType", masRoomType.getRoomTypeCode());
			System.out.println("saved " + saved);
			saved = true;
			tx.commit();
			hbt.flush();
			hbt.clear();
			 map.put("bookingId", blPaywardBooking.getId());
			 map.put("receiptHeaderId", receiptHeaderId);
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> submitAllotmentDetails(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		boolean saved = false;
		Box box = null;
		int receiptHeaderId=0;
		
		String userName = "";
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		int hospitalId = box.getInt(HOSPITAL_ID);
		int userId=box.getInt(USER_ID);
		int transferId=box.getInt("transferId");
		int opdPatientDetailsId=box.getInt("opdpatientdetailId");
		
		Session session = null;
		session = (Session) getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			int inpatientId = box.getInt(INPATIENT_ID);
			System.out.println("inpatientId" + inpatientId);
			
			String receiptNo = box.getString("receiptNo");
			String receiptDate = (String)utilMap.get("currentDate");
			String receiptTime = (String)utilMap.get("currentTime");
			String totalAdvAmt = box.getString(TOTAL_AMOUNT);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------------- Receipt
			// Entry-------------------------------------

			BlReceiptHeader receiptHeader = new BlReceiptHeader();

			if(transferId!=0)
			{
			Transfer transfer = new Transfer();
			transfer.setId(transferId);
			receiptHeader.setTransfer(transfer);
			}else if(opdPatientDetailsId!=0)
			{
				OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
				opdPatientDetails.setId(opdPatientDetailsId);
				receiptHeader.setOpdPatientDetail(opdPatientDetails);
			}

			receiptHeader.setReceiptNo(receiptNo);
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			receiptHeader.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				receiptHeader.setInpatient(inpatient);
			}

			receiptHeader.setReceiptType("adv");
			receiptHeader.setAmount(new BigDecimal(totalAdvAmt));
			if (receiptDate != null && !receiptDate.equals("")) {
				receiptHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(receiptDate));
			}
			if(box.getInt("bookingId") != 0){
				BlPaywardBooking blPaywardBooking = new BlPaywardBooking();
				blPaywardBooking.setId(box.getInt("bookingId"));
				receiptHeader.setBooking(blPaywardBooking);
			}

			receiptHeader.setReceiptTime(receiptTime);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			receiptHeader.setHospital(hospital);

			Users user = new Users();
			user.setId(box.getInt("userId"));
			receiptHeader.setChangedBy(user);
			receiptHeader.setStatus("R");
			hbt.save(receiptHeader);
			receiptHeaderId = receiptHeader.getId();
			int payListLength = 0;

			payListLength = box.getInt("hiddenValuePayment");

			if (payListLength > 0) {
				for (int i = 1; i <= payListLength; i++) {
					BlReceiptDetails receiptDetails = new BlReceiptDetails();
					if (!box.getString(PAYMENT_MODE + i).equals("")) {
						receiptDetails.setPaymentMode(box
								.getString(PAYMENT_MODE + i));
						receiptDetails.setAdvanceAmountType(box
								.getString(ADVANCE_AMOUNT_TYPE + i));

						BigDecimal amtReceived = new BigDecimal(
								box.getInt(AMOUNT_RECEIVED + i));
						receiptDetails.setAmount(amtReceived);

						if (!box.getString(CHEQUE_NO + i).equals(""))
							receiptDetails.setChequeNo(box.getString(CHEQUE_NO
									+ i));

						if (!box.getString(CHEQUE_DATE + i).equals(""))
							receiptDetails.setChequeDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString(CHEQUE_DATE + i)));

						if (box.getInt(BANK_ID + i) != 0) {
							MasBankMaster bankMaster = new MasBankMaster();
							bankMaster.setId(box.getInt(BANK_ID + i));
							receiptDetails.setBank(bankMaster);
						}
						receiptDetails.setReceiptDate(HMSUtil
								.convertStringTypeDateToDateType(receiptDate));
						receiptDetails.setReceiptTime(receiptTime);
						receiptDetails.setChangedBy(user);
						receiptDetails.setReceiptHeader(receiptHeader);
						try {
							hbt.save(receiptDetails);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			BlPaywardBooking blPaywardBooking=(BlPaywardBooking) hbt.get(BlPaywardBooking.class, box.getInt("bookingId"));
			if(box.getInt("extradays")!=0)
			{
				blPaywardBooking.setNumberOfDays(blPaywardBooking.getNumberOfDays()+box.getInt("extradays"));
				blPaywardBooking.setAmount(blPaywardBooking.getAmount().add(new BigDecimal(box.getFloat("newAmmount"))));
			}
			blPaywardBooking.setBookingStatus("w");
			blPaywardBooking.setLastChgBy(user);
			blPaywardBooking.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blPaywardBooking.setLastChgTime((String)utilMap.get("currentTime"));
			blPaywardBooking.setAllotmentDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blPaywardBooking.setAllotmentTime((String)utilMap.get("currentTime"));
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				blPaywardBooking.setInpatient(inpatient);
			}
			
			hbt.update(blPaywardBooking);
			List<BlReceiptHeader> receiptHeaderList = new ArrayList<BlReceiptHeader>();
			receiptHeaderList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.eq("Booking.Id", box.getInt("bookingId"))).list();
			if(receiptHeaderList.size()>0){
				int receiptId =receiptHeaderList.get(0).getId();
				System.out.println("receiptIdof booking ======================"+receiptId);
				BlReceiptHeader blReceiptHeader = (BlReceiptHeader)hbt.load(BlReceiptHeader.class, receiptId);
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					blReceiptHeader.setInpatient(inpatient);
				}
				hbt.update(blReceiptHeader);
			}
				

			/*BigDecimal pastDue = new BigDecimal(0);
			Patient hin = (Patient) hbt.load(Patient.class, box.getInt(HIN_ID));
			if (hin.getPastDue() != null)
				pastDue = new BigDecimal(hin.getPastDue());

			BigDecimal newAmt = new BigDecimal(0);
			newAmt = pastDue.subtract(new BigDecimal(totalAdvAmt));
			hin.setPastDue(newAmt.toString());
			hbt.update(hin);*/

			System.out.println("saved " + saved);
			map.put("receiptHeaderId", receiptHeaderId);
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> submitRenewaltDetails(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		boolean saved = false;
		Box box = null;
		
		String userName = "";
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		int hospitalId = box.getInt(HOSPITAL_ID);
		int userId=box.getInt(USER_ID);
		int transferId=box.getInt("transferId");
		int opdPatientDetailsId=box.getInt("opdpatientdetailId");
		
		Session session = null;
		session = (Session) getSession();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			int inpatientId = box.getInt(INPATIENT_ID);
			System.out.println("inpatientId" + inpatientId);
			
			String receiptNo = box.getString("receiptNo");
			String receiptDate = (String)utilMap.get("currentDate");
			String receiptTime = (String)utilMap.get("currentTime");
			String totalAdvAmt = box.getString(TOTAL_AMOUNT);

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// --------------------- Receipt
			// Entry-------------------------------------

			BlReceiptHeader receiptHeader = new BlReceiptHeader();

			if(transferId!=0)
			{
			Transfer transfer = new Transfer();
			transfer.setId(transferId);
			receiptHeader.setTransfer(transfer);
			}else if(opdPatientDetailsId!=0)
			{
				OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
				opdPatientDetails.setId(opdPatientDetailsId);
				receiptHeader.setOpdPatientDetail(opdPatientDetails);
			}

			receiptHeader.setReceiptNo(receiptNo);
			Patient patient = new Patient();
			patient.setId(box.getInt(HIN_ID));
			receiptHeader.setHin(patient);
			if (inpatientId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				receiptHeader.setInpatient(inpatient);
			}

			receiptHeader.setReceiptType("adv");
			receiptHeader.setAmount(new BigDecimal(totalAdvAmt));
			if (receiptDate != null && !receiptDate.equals("")) {
				receiptHeader.setReceiptDate(HMSUtil
						.convertStringTypeDateToDateType(receiptDate));
			}

			receiptHeader.setReceiptTime(receiptTime);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			receiptHeader.setHospital(hospital);

			Users user = new Users();
			user.setId(box.getInt("userId"));
			receiptHeader.setChangedBy(user);
			//receiptHeader.setStatus("R");
			hbt.save(receiptHeader);

			int payListLength = 0;

			payListLength = box.getInt("hiddenValuePayment");

			if (payListLength > 0) {
				for (int i = 1; i <= payListLength; i++) {
					BlReceiptDetails receiptDetails = new BlReceiptDetails();
					if (!box.getString(PAYMENT_MODE + i).equals("")) {
						receiptDetails.setPaymentMode(box
								.getString(PAYMENT_MODE + i));
						receiptDetails.setAdvanceAmountType(box
								.getString(ADVANCE_AMOUNT_TYPE + i));

						BigDecimal amtReceived = new BigDecimal(
								box.getInt(AMOUNT_RECEIVED + i));
						receiptDetails.setAmount(amtReceived);

						if (!box.getString(CHEQUE_NO + i).equals(""))
							receiptDetails.setChequeNo(box.getString(CHEQUE_NO
									+ i));

						if (!box.getString(CHEQUE_DATE + i).equals(""))
							receiptDetails.setChequeDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString(CHEQUE_DATE + i)));

						if (box.getInt(BANK_ID + i) != 0) {
							MasBankMaster bankMaster = new MasBankMaster();
							bankMaster.setId(box.getInt(BANK_ID + i));
							receiptDetails.setBank(bankMaster);
						}
						receiptDetails.setReceiptDate(HMSUtil
								.convertStringTypeDateToDateType(receiptDate));
						receiptDetails.setReceiptTime(receiptTime);
						receiptDetails.setChangedBy(user);
						receiptDetails.setReceiptHeader(receiptHeader);
						try {
							hbt.save(receiptDetails);
						} catch (DataAccessException e) {
							e.printStackTrace();
						}
					}
				}
			}
			BlPaywardBooking blPaywardBooking=(BlPaywardBooking) hbt.get(BlPaywardBooking.class, box.getInt("bookingId"));
			if(box.getInt("numOfDaysId")!=0)
			{
				blPaywardBooking.setNumberOfDays(blPaywardBooking.getNumberOfDays()+box.getInt("numOfDaysId"));
				blPaywardBooking.setAmount(blPaywardBooking.getAmount().add(new BigDecimal(box.getFloat("amtt"))));
			}
			//blPaywardBooking.setBookingStatus("w");
			blPaywardBooking.setLastChgBy(user);
			blPaywardBooking.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
			blPaywardBooking.setLastChgTime((String)utilMap.get("currentTime"));
			
			hbt.update(blPaywardBooking);

			BigDecimal pastDue = new BigDecimal(0);
			Patient hin = (Patient) hbt.load(Patient.class, box.getInt(HIN_ID));
			if (hin.getPastDue() != null)
				pastDue = new BigDecimal(hin.getPastDue());

			BigDecimal newAmt = new BigDecimal(0);
			newAmt = pastDue.subtract(new BigDecimal(totalAdvAmt));
			hin.setPastDue(newAmt.toString());
			hbt.update(hin);

			System.out.println("saved " + saved);
			saved = true;
			tx.commit();
		} catch (DataAccessException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}/*
		 * finally { if(session!=null){ session.close(); } }
		 */
		map.put("saved", saved);
		return map;
	}
//show postpaid status--------------------------------//
	@Override
	public Map<String, Object> showPostPaidStatus(Box box,
			Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>(); 
		Session session=(Session)getSession();
		List<Inpatient> inpatients=new ArrayList<Inpatient>();
		List<MasDepartment> departments=new ArrayList<MasDepartment>();
		List<MasWard> masWards=new ArrayList<MasWard>();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date fromDate=new Date();
		Date toDate=new Date();
		int hospitalId=0;
		String uhid="";
		int department=0;
		int ward=0;
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId=(Integer)dataMap.get("hospitalId");
		}
		
		if (dataMap.get("uhid") != null) {
			uhid =(String) dataMap.get("uhid");
		}
		if (dataMap.get("department") != null) {
			department =(Integer) dataMap.get("department");
		}
		if (dataMap.get("ward") != null) {
			ward =(Integer) dataMap.get("ward");
		}
		
		departments=session.createCriteria(MasDepartment.class).add(Restrictions.isNotNull("DepartmentName")).list();
		masWards=session.createCriteria(MasWard.class).add(Restrictions.isNotNull("WardName")).list();
		  System.out.println("departments"+departments.size());
		  System.out.println("masWards"+masWards.size());
		 map.put("departments",departments);
		 
		 map.put("masWards",masWards);
		
		return map;
	}

	@Override
	public Map<String, Object> getFinalBillDetails(
			Map<String, Object> parameters) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		BlFinalBillDetails blFinalBillDetails=null;
		BlChargeSlipMain blChargeSlipMain=null;
		BlChargeSlipDetail blChargeSlipDetail=null;
		Session session=(Session) getSession();
		Criteria crt=null;
		int finalBillId=0;
		int hospitalId=0;
		
		if(null !=parameters.get("finalBillId")){
			finalBillId=(Integer)parameters.get("finalBillId");
		}
		
		if(null !=parameters.get("hospitalId")){
			hospitalId=(Integer)parameters.get("hospitalId");
		}
		int blChargeSlipMainId=0;
		
		if(finalBillId>0){
		blFinalBillDetails=(BlFinalBillDetails) session.createCriteria(BlFinalBillDetails.class)
				.add(Restrictions.eq("Id", finalBillId)).createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId)).list().get(0);
		
		blChargeSlipMain=(BlChargeSlipMain) session.createCriteria(BlChargeSlipMain.class)
				.createAlias("FinalBill", "finalBill").createAlias("Hospital", "hosp")
				.add(Restrictions.eq("finalBill.Id", finalBillId))
				.add(Restrictions.eq("hosp.Id", hospitalId)).list().get(0);
		
		blChargeSlipMainId=blChargeSlipMain.getId();
		System.out.println("blChargeSlipMainId "+blChargeSlipMainId);
		System.out.println("hospitalId "+hospitalId);
		
		    crt= session.createCriteria(BlChargeSlipDetail.class)
				.createAlias("Hospital", "hosp")
				.createAlias("ChargeSlipMain", "chargeSlipMain")
				
				.add(Restrictions.eq("Status", "n").ignoreCase())
				.add(Restrictions.eq("chargeSlipMain.Id", blChargeSlipMainId))
				.add(Restrictions.eq("hosp.Id", hospitalId));
		    
		    if(null !=crt.list() && crt.list().size()>0)
		blChargeSlipDetail=(BlChargeSlipDetail) crt.list().get(0);
		    
		}
		map.put("blChargeSlipDetail", blChargeSlipDetail);
		map.put("blFinalBillDetails", blFinalBillDetails);
		return map;
	}

	@Override
	public Map<String, Object> showConsolidateReportForWaiveOffPayLaterJsp(int hospitalId) {
		Session session=(Session)getSession();
		List<MasAuthorizer>MasAuthorizerList =new ArrayList<MasAuthorizer>();
		Map<String, Object> map=new HashMap<String, Object>(); 
		MasAuthorizerList=session.createCriteria(MasAuthorizer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("MasAuthorizerList",MasAuthorizerList);
		return map;
	}
	public String generateFinalBillNo(String flag) {
		String finalBillNo = "";
		Integer finalBillSeqNo = 0;
		List<BlParameter> finalBlSeqNoList = new ArrayList<BlParameter>();
		List<BlFinalBillDetails> finalBillDtList = new ArrayList<BlFinalBillDetails>();
		List<Integer> maxIdFinalBillList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		try {
			finalBlSeqNoList = session.createCriteria(BlParameter.class).add(
					Restrictions.eq("Prefix", "FB")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String lastFinalBillNo = "";
		maxIdFinalBillList = session.createCriteria(BlFinalBillDetails.class)
				.setProjection(Projections.max("Id")).list();
		if (maxIdFinalBillList.size() > 0) {
			finalBillDtList = session.createCriteria(BlFinalBillDetails.class)
					.add(Restrictions.idEq(maxIdFinalBillList.get(0))).list();
			if (finalBillDtList.size() > 0) {
				lastFinalBillNo = finalBillDtList.get(0).getFinalBillNo();
			} else {
				lastFinalBillNo = "1";
			}

		}
		/*
		 * finalBillDtList = session.createCriteria(BlFinalBillDetails.class)
		 * .list(); String lastFinalBillNo = ""; if (finalBillDtList.size() > 0)
		 * { for (BlFinalBillDetails billDt : finalBillDtList) {
		 * finalBillDtListlastFinalBillNo = billDt.getFinalBillNo(); } }
		 */
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		StringTokenizer str = new StringTokenizer(lastFinalBillNo, "/");

		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (finalBlSeqNoList.size() > 0) {
			for (BlParameter blParameter : finalBlSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				finalBillSeqNo = ++seqNo;
			}

			if (criteria.equalsIgnoreCase("c")) {
				finalBillNo = finalBillSeqNo.toString();
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					finalBillSeqNo = 1;
				}
				finalBillNo = finalBillSeqNo.toString().concat("/").concat(
						currentMonth).concat("/").concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					finalBillSeqNo = 1;
				}
				finalBillNo = finalBillSeqNo.toString().concat("/").concat(
						currentYear);
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(finalBillSeqNo);
				hbt.update(parameterObj);
			}
		}
		return finalBillNo;
	}
	public int getChargeSlipNo(String flag) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int chargeSlipSeqNo = 0;
		int id = 0;
		int seqNo = 0;
		List<BlParameter> csSeqNoList = new ArrayList<BlParameter>();
		Session session = (Session) getSession();
		try
		{
			csSeqNoList = session.createCriteria(BlParameter.class)
			.add(Restrictions.eq("Prefix", "CS")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (csSeqNoList.size() > 0)
		{
			for (BlParameter blParameter : csSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				chargeSlipSeqNo = ++seqNo;
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(BlParameter.class, id);
				parameterObj.setSeqNo(chargeSlipSeqNo);
				hbt.update(parameterObj);
			}
		}
		return chargeSlipSeqNo;
	}

	@Override
	public Map<String, Object> getItemBatchDetailsFinal(Map<String, Object> mapForDs, Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> itemBatchList = new ArrayList<Object[]>();
		Session session = getSession();
		int itemId=0; int inpatientId=0;
		
		if(mapForDs.get("itemId") !=null){
			itemId=(Integer)mapForDs.get("itemId");
		}
		if(mapForDs.get("inpatientId") !=null){
			inpatientId=(Integer)mapForDs.get("inpatientId");
		}
		String qry = " SELECT dh.bill_no,ibs.batch_no,dd.qty,dd.amount,sum(padd.advice_qty),sum(padd.advice_amt),dd.dispensing_details_id,dh.dispensing_header_id FROM bl_dispensing_details dd"
			+ " left join store_item_batch_stock ibs on dd.batch_id=ibs.stock_id"
			+ " left join bl_dispensing_header dh on dh.dispensing_header_id = dd.dispensing_header_id"
			+ " left join bl_pymnt_advice_disp_header padh on dh.dispensing_header_id = padh.bill_dispensing_id"
			+ " left join bl_pymnt_advice_disp_details padd on padh.pymnt_advice_disp_header_id = padd.pymnt_advice_disp_header_id"
			+ " where dd.item_id="
			+ itemId
			+ " and dh.status = 'y' and dh.inpatient_id="
			+ inpatientId
		//	+ ""
			+ " group by dd.batch_id,dh.bill_no,ibs.batch_no,dd.qty,dd.amount,dh.dispensing_header_id,dd.dispensing_details_id";

		itemBatchList = session.createSQLQuery(qry).list();
		map.put("itemId", itemId);
		map.put("itemBatchList", itemBatchList);
		return map;
	}

	@Override
	public String generateRefundNo(String string) {
		String refundNo = "";
		Integer refundSeqNo = 0;
		List<BlParameter> refundSeqNoList = new ArrayList<BlParameter>();
		List<BlRefundHeader> refList = new ArrayList<BlRefundHeader>();
		List<Integer> maxIdRefundList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		try {
			refundSeqNoList = session.createCriteria(BlParameter.class).add(
					Restrictions.eq("Prefix", "RF")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * refList = session.createCriteria(BlRefundHeader.class).list(); String
		 * lastRefundNo = ""; if (refList.size() > 0) { for (BlRefundHeader
		 * refundHeader : refList) { lastRefundNo = refundHeader.getRefundNo();
		 * } }
		 */

		maxIdRefundList = session.createCriteria(BlRefundHeader.class)
				.setProjection(Projections.max("Id")).list();
		String lastRefundNo = "";
		if (maxIdRefundList.size() > 0) {
			refList = session.createCriteria(BlRefundHeader.class).add(
					Restrictions.idEq(maxIdRefundList.get(0))).list();
			if (refList.size() > 0) {
				lastRefundNo = refList.get(0).getRefundNo();
			} else {
				lastRefundNo = "1";
			}

		}
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1, date
				.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		StringTokenizer str = new StringTokenizer(lastRefundNo, "/");

		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (refundSeqNoList.size() > 0) {
			for (BlParameter blParameter : refundSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				refundSeqNo = ++seqNo;
			}

			if (criteria.equalsIgnoreCase("c")) {
				refundNo = refundSeqNo.toString();
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastMnt = str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					refundSeqNo = 1;
				}
				refundNo = refundSeqNo.toString().concat("/").concat(
						currentMonth).concat("/").concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens())
						lastYr = str.nextToken();
				}
				if (!lastYr.equals(currentYear)) {
					refundSeqNo = 1;
				}
				refundNo = refundSeqNo.toString().concat("/").concat(
						currentYear);
			}
			if (string.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(refundSeqNo);
				hbt.update(parameterObj);
			}
		}
		return refundNo;
	}

	

	@Override
	public Map<String, Object> populateExpiryDateByBatchNo(
			Map<String, Object> mapForDs) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> masStoreBrandItemList =null;
		masStoreBrandItemList=	new ArrayList<StoreItemBatchStock>();
		Session session = getSession();
		
		int itemId = 0;
		String batchNo ="";
		int inc = 0;
		int depId=0;
		
		int hospitalId = 0;
		String blockStatus [] = {"Temporary Block","Parmanent Block"};
		
		itemId=(Integer)mapForDs.get("itemId");
		batchNo=(String)mapForDs.get("batchNo");
		hospitalId=(Integer)mapForDs.get("hospitalId");
		depId=(Integer)mapForDs.get("depId");
		
		
		masStoreBrandItemList = session
				.createCriteria(StoreItemBatchStock.class)
				.createAlias("Item", "item")
				.createAlias("Department", "dept")				
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("dept.Id", depId))
				.add(Restrictions.eq("item.Id", itemId))
				.add(Restrictions.eq("BatchNo", batchNo))
				.add(Restrictions.or(Restrictions.gt("ExpiryDate", new Date()), Restrictions.isNull("ExpiryDate")))//added by govind 19-12-2016
				.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
				.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
				.addOrder(Order.asc("ExpiryDate"))		//added by govind 19-12-2016 end		
				.list();
		
		map.put("masStoreBrandItemList", masStoreBrandItemList);
		
		return map;
	}
/*Added By Srikanth*/
	@Override
	public List<MasScheme> getAllSchemeList() {
		// TODO Auto-generated method stub
		List<MasScheme> schemeList=null;
		try{
			System.out.println("Entered Into Schemes");
			Session session=(Session)getSession();
			schemeList=new ArrayList<MasScheme>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			Criteria criteria = session.createCriteria(MasScheme.class);
			schemeList=criteria.list();
			System.out.println("Scheme List :"+schemeList.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return schemeList;
	}

	@Override
	public Map<String, Object> getKmsclIntegrationXMLData(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Integer hospitalId=0;
		if(mapForDS.get("hospitalId")!=null){
			hospitalId=(Integer)mapForDS.get("hospitalId");
		}
		String kmsclInstcode=null,joinQuery=" ";
		
		if(mapForDS.get("kmsclInstcode")!=null && !mapForDS.get("kmsclInstcode").equals("")){
			kmsclInstcode =(String)mapForDS.get("kmsclInstcode");
			joinQuery=" where m.kmscl_institute_code='"+kmsclInstcode+"' ";
		}
		String str=null;
		/*List<MasStoreItem> mStorList=new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> storeBatchList=new ArrayList<StoreItemBatchStock>();*/
		List<Object[]> storeBatchList = new ArrayList<Object[]>();
		str=" select m.kmscl_institute_code,s.hospital_id as hospital_id,s.batch_no,s.item_id, "+
				" COALESCE((select sum(s2.closing_stock) from store_item_batch_stock s2 "+
				" where s2.closing_stock<>0 and s2.department_id=72 and s2.hospital_id=s.hospital_id and s2.batch_no=s.batch_no "+
				" ),0) as store_stock,COALESCE((select sum(s1.closing_stock) from store_item_batch_stock s1 "+
				" where s1.closing_stock<>0 and s1.department_id<>72 and s1.hospital_id=s.hospital_id and s1.batch_no=s.batch_no "+
				" ),0) as sub_stock from store_item_batch_stock s left join mas_hospital m on s.hospital_id=m.hospital_id "+joinQuery+
				" group by s.hospital_id,store_stock,sub_stock,s.batch_no,s.item_id,m.kmscl_institute_code ";
		SQLQuery query=session.createSQLQuery(str);
		storeBatchList=query.list();
		System.out.println("storeBatchList "+storeBatchList.size());		
		map.put("storeBatchList", storeBatchList);	
		return map;
	}

	//added by govind 30-8-2017 for KMSCL Integration
	@Override
	public Map<String, Object> addKmsclData(Map<String, Object> kmsclMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Transaction trx=session.beginTransaction();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		int storeId=0;
		try{
		List<KmsclDrugData> kmsclDrugList=new ArrayList<KmsclDrugData>();
		if(kmsclMap.get("kmsclDrugList")!=null){
			kmsclDrugList=(List<KmsclDrugData>)kmsclMap.get("kmsclDrugList");
		}
		if(kmsclMap.get("storeId")!=null){
			storeId=(Integer)kmsclMap.get("storeId");
		}
		int NewStock=0,OldStock=0,itemCount=0;
		for(KmsclDrugData km:kmsclDrugList){
			List<MasHospital> hospitalList=new ArrayList<MasHospital>();
			//Check Hospital Id exist or not
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("KmsclInstituteCode", km.getInstId())).list();
		
			if(hospitalList.size()>0){
				MasHospital hospital=(MasHospital)(hospitalList.get(0));
				List<StoreGrnM> storeGrnMList=new ArrayList<StoreGrnM>();
				List<StoreItemBatchStock> itemBatchList=new ArrayList<StoreItemBatchStock>();
				List<StoreItemBatchStock> itemBatchUniqueList=new ArrayList<StoreItemBatchStock>();
				List<MasStoreItem> itemList=new ArrayList<MasStoreItem>();
				MasDepartment department =new MasDepartment();
				department.setId(storeId);
				//System.out.println("storeId "+storeId);
				//check whether Item in  StoreItemBatchStock
				itemBatchList=session.createCriteria(StoreItemBatchStock.class)
						.createAlias("Hospital", "hosp")
						.createAlias("Item", "item")
						//.createAlias("item.Supplier", "supp")
						.add(Restrictions.eq("hosp.Id", hospital.getId()))
						.add(Restrictions.eq("BatchNo", km.getBatchNo()))
						.add(Restrictions.eq("item.KmsclItemCode", km.getDrugCode()))
						//.add(Restrictions.eq("supp.SupplierCode", km.getSupplierCode()))
						.list();
				//check whether Item in  StoreItemBatchStock is unique
				itemBatchUniqueList=session.createCriteria(StoreItemBatchStock.class)
						.createAlias("Hospital", "hosp")
						.createAlias("Item", "item")
						//.createAlias("item.Supplier", "supp")
						.add(Restrictions.eq("hosp.Id", hospital.getId()))
						.add(Restrictions.eq("BatchNo", km.getBatchNo()))
						.add(Restrictions.eq("item.KmsclItemCode", km.getDrugCode()))
						.add(Restrictions.eq("OutTwNo", Long.parseLong(km.getOUTWNO())))
						.list();
				//check whether Item in  StoreItemBatchStock
				storeGrnMList=session.createCriteria(StoreGrnM.class)
						.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id", hospital.getId()))
						.add(Restrictions.eq("InvoiceNo", km.getInvNo()))
						.add(Restrictions.eq("InvoiceDate", HMSUtil.convertStringTypeDateToDateType(km.getInvDate())))
						.list();
				//System.out.println("ITEMCODE "+km.getDrugCode());
				itemList=session.createCriteria(MasStoreItem.class)
						.add(Restrictions.eq("KmsclItemCode", km.getDrugCode()).ignoreCase())
						.list();
				//System.out.println("itemList "+itemList.size());
				if(itemList.size()>0){itemCount++;
				StoreGrnM storeM=null;
				if(storeGrnMList.size()==0){
					//Add Data to StoreGrnM Table
					storeM=new StoreGrnM();
					storeM.setHospital(hospital);
					storeM.setDepartment(department);
					storeM.setInvoiceNo(km.getInvNo());
					storeM.setInvoiceDate(HMSUtil.convertStringTypeDateToDateType(km.getInvDate()));
					storeM.setPurchaseOrderNo(km.getPONo());
					/*storeM.setPurchaseOrderDate(HMSUtil.convertStringToDate(km.getPODate()));*/
					storeM.setPurchaseOrderDate(HMSUtil.convertStringTypeDateToDateType(km.getPODate()));
					storeM.setLastChgDate(currentDate);
					storeM.setLastChgTime(currentTime);
					Users user=new Users();
					user.setId(1);
					storeM.setLastChgBy(user);
					storeM.setGrnNo("KMSCL");
					storeM.setReceiveType("Purchase From KMSCL");
					storeM.setGrnDate(currentDate);
					storeM.setStatus("o");
					storeM.setGrnStartNo("KMSCL");
					MasEmployee employee =new MasEmployee();
					employee.setId(1);
					storeM.setEmployee(employee);
					session.save(storeM);
					//System.out.println("Invoice No new StoreGrnM added");
				}else{
					storeM=storeGrnMList.get(0);
				}
				if(itemBatchList.size()==0){
					NewStock++;
				    //System.out.println("km.getQuantity() "+km.getQuantity());
				    //Add Data to StoreItemBatchStock Table
					StoreItemBatchStock itemBatch=new StoreItemBatchStock();
					StoreGrnT grnT=new StoreGrnT();
					MasStoreItem item=itemList.get(0);
					itemBatch.setHospital(hospital);
					itemBatch.setItem(item);
					itemBatch.setDepartment(department);
					Users user=new Users();
					user.setId(1);
					itemBatch.setLastChgBy(user);
					itemBatch.setBatchNo(km.getBatchNo());
					/*itemBatch.setManufactureDate(HMSUtil.convertStringToDate(km.getMfgDate()));
					itemBatch.setExpiryDate(HMSUtil.convertStringToDate(km.getExpDate()));*/
					itemBatch.setManufactureDate(HMSUtil.convertStringTypeDateToDateType(km.getMfgDate()));
					itemBatch.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(km.getExpDate()));
					if(km.getUnitRate()!=null){
						itemBatch.setCostPrice(new BigDecimal(km.getUnitRate()));
					}
					//itemBatch.setOpeningBalanceQty(new BigDecimal(km.getQuantity()));
					itemBatch.setClosingStock(new BigDecimal(km.getQuantity()));
					itemBatch.setReceivedQty(new BigDecimal(km.getQuantity()));
					itemBatch.setLastChgDate(currentDate);
					if(km.getOUTWNO() != null)
						itemBatch.setOutTwNo(new Long(km.getOUTWNO()));
					session.save(itemBatch);
					
					//Add Data to StoreGrnT Table
					grnT.setStock(itemBatch);
					grnT.setItem(item);
					grnT.setGrnMaster(storeM);
					/*grnT.setManufacturerDate(HMSUtil.convertStringToDate(km.getMfgDate()));
					grnT.setExpiryDate(HMSUtil.convertStringToDate(km.getExpDate()));*/
					grnT.setManufacturerDate(HMSUtil.convertStringTypeDateToDateType(km.getMfgDate()));
					grnT.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(km.getExpDate()));
					grnT.setReceivedQty(new BigDecimal(km.getQuantity()));
					grnT.setUnitRate(new BigDecimal(0));
					grnT.setDiscount(new BigDecimal(0));
					grnT.setAmountValue(new BigDecimal(0));
					grnT.setDispencingPrice(new BigDecimal(0));
					session.save(grnT);
					//System.out.println("Batchno StoreItemBatchStock added");
				} else if(itemBatchUniqueList.size() == 0) {
					//update data to StoreItemBatchStock Table
					OldStock++;
					//System.out.println("itemBatchList "+itemBatchList.size());
					StoreItemBatchStock itemBatch=itemBatchList.get(0);
				    BigDecimal closeBalanceQt=new BigDecimal(0);
				    if(itemBatch.getClosingStock()!=null){
				    closeBalanceQt=closeBalanceQt.add(itemBatch.getClosingStock());
				    }else{
				    	closeBalanceQt=closeBalanceQt.add(new BigDecimal(0));
				    }
				    if(km.getQuantity()!=null){
					closeBalanceQt=closeBalanceQt.add(new BigDecimal(km.getQuantity()));
				    }else{
				    	closeBalanceQt=closeBalanceQt.add(new BigDecimal(0));
				    }
					/*System.out.println("km.getQuantity() "+km.getQuantity());
					System.out.println("itemBatch.getOpeningBalanceQty() "+itemBatch.getOpeningBalanceQty()+" openBalanceQt "+openBalanceQt);
					itemBatch.setOpeningBalanceQty(openBalanceQt);*/
					itemBatch.setClosingStock(closeBalanceQt);
					itemBatch.setReceivedQty(closeBalanceQt);
					itemBatch.setLastChgDate(currentDate);
					if(km.getOUTWNO() != null)
						itemBatch.setOutTwNo(new Long(km.getOUTWNO()));
					session.update(itemBatch);
					//System.out.println("Batchno StoreItemBatchStock updated");
				}
				}
			}
		}
		trx.commit();
		session.close();
		System.out.println("KMSCL data successfully added to HMS OldStock "+OldStock+" NewStock "+NewStock+" itemCount "+itemCount);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("KMSCL data to HMS some exception");
		}
		return map;
	}//added by govind 30-8-2017 for KMSCL Integration end

	@Override
	public Map<String, Object> getHighLevelDrugsForIPBilling(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Transaction trx=session.beginTransaction();
		Integer inpatientId=box.getInt("inpatientId");
		Integer hospitalId=box.getInt("hospitalId");
		List<IpWardConsumptionDetails> consumpList=new ArrayList<IpWardConsumptionDetails>();
		List<Object[]> objectList=new ArrayList<Object[]>();
		consumpList=session.createCriteria(IpWardConsumptionDetails.class)
				.createAlias("Consumption", "con")
				//.createAlias("Stock", "stock")
				.add(Restrictions.eq("con.Inpatient.Id", inpatientId))				
				.add(Restrictions.eq("con.Hospital.Id", hospitalId))
				.add(Restrictions.eq("con.BillStatus", "y").ignoreCase())
				.add(Restrictions.isNotNull("Stock"))
				.list();
		for(IpWardConsumptionDetails cons:consumpList){
			List<StoreItemBatchStock> stocBatchList=new ArrayList<StoreItemBatchStock>();
			Integer quantity=cons.getConsumption().getInpatientPrescriptionDetails().getFrequency().getFrequencyCount();
			String medicineName=cons.getStock().getItem().getNomenclature();
			BigDecimal amount=cons.getStock().getCostPrice();
			BigDecimal netAmount=cons.getStock().getCostPrice().multiply(new BigDecimal(quantity));
			Object obj[]=new Object[6];
			obj[0]=medicineName;
			obj[1]=quantity;
			obj[2]=amount;			
			obj[3]=netAmount;
			obj[4]=cons.getStock().getId();
			obj[5]=cons.getConsumption().getId();
			objectList.add(obj);
		}
		map.put("objectList", objectList);
		return map;
	}
	
	@Override
	public Map<String, Object> getKmsclAddedXMLData(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session=(Session)getSession();
		Integer hospitalId=0;
		if(mapForDS.get("hospitalId")!=null){
			hospitalId=(Integer)mapForDS.get("hospitalId");
		}
		String kmsclInstcode=null,joinQuery=" ";
		
		if(mapForDS.get("kmsclInstcode")!=null && !mapForDS.get("kmsclInstcode").equals("")){
			kmsclInstcode =(String)mapForDS.get("kmsclInstcode");
			joinQuery=" where m.kmscl_institute_code='"+kmsclInstcode+"' and out_tw_no is not null and s.last_chg_date = current_date ";
		}
		String str=null;
		List<Object[]> storeBatchList = new ArrayList<Object[]>();
		str=" select m.kmscl_institute_code,s.hospital_id as hospital_id,s.batch_no,s.item_id, out_tw_no "+
				" from store_item_batch_stock s left join mas_hospital m on s.hospital_id=m.hospital_id "+joinQuery+
				" group by s.hospital_id,s.batch_no,s.item_id,m.kmscl_institute_code,out_tw_no ";
		SQLQuery query=session.createSQLQuery(str);
		storeBatchList=query.list();
		System.out.println("storeBatchList "+storeBatchList.size());		
		map.put("storeBatchList", storeBatchList);	
		return map;
	}

}
