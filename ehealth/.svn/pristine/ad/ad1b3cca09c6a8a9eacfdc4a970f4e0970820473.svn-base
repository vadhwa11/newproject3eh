package jkt.hms.lab.dataservice;

import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.COLLECTED_VALUE;
import static jkt.hms.util.RequestConstants.CONTAINER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_TYPE_CODE;
import static jkt.hms.util.RequestConstants.DG_ORDER_DETAIL_ID;
import static jkt.hms.util.RequestConstants.DG_SAMPLE_DETAIL_ID;
import static jkt.hms.util.RequestConstants.DIAGNOSIS_NO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.MAIN_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.ORDER_BOOKING_ID;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.REASON;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SAMPLE_COLLECTION_DETAIL_ID;
import static jkt.hms.util.RequestConstants.SAMPLE_ID;
import static jkt.hms.util.RequestConstants.SUB_CHARGECODE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VALIDATED;
import static jkt.hms.util.RequestConstants.VISIT_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.masters.business.AppInvestigationAppointments;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.CentralServerSampleData;
import jkt.hms.masters.business.DgBulkOrderRequisition;
import jkt.hms.masters.business.DgCollectionCenter;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgHistoSampleCollectionDetails;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasInvestigationReportTemplate;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgMasTestKit;
import jkt.hms.masters.business.DgNormalValue;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.IpDialysisDetails;
import jkt.hms.masters.business.IpDialysisReqHeader;
import jkt.hms.masters.business.IpPhysioReqDetails;
import jkt.hms.masters.business.IpPhysioReqHeader;
import jkt.hms.masters.business.LabMachineXt2000iDetails;
import jkt.hms.masters.business.LeanServerSampleData;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasHospitalwiseChargecode;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasLionc;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.NursingcareSetup;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientLabInfo;
import jkt.hms.masters.business.PatientMainLabInfo;
import jkt.hms.masters.business.PhInvestigationSampleDetail;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.PharmacyLabQueue;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.business.Xl300TableTemp;
import jkt.hms.masters.dataservice.BillingMasterDataService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.InvestigationTrackerUtil;
import jkt.hms.util.RequestConstants;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.examples.ExampleReceiverApplication;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v23.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class LabDataServiceImpl extends HibernateDaoSupport implements
		LabDataService {

	OpBillingDataService opBillingDataService = null;
	RegistrationDataService registrationDataService = null;
	private BillingMasterDataService billingMasterDataService = null; 
	static final Logger LOGGER = Logger.getLogger(LabDataServiceImpl.class);

	public BillingMasterDataService getBillingMasterDataService() {
		return billingMasterDataService;
	}

	public void setBillingMasterDataService(
			BillingMasterDataService billingMasterDataService) {
		this.billingMasterDataService = billingMasterDataService;
	}
	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(
			OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	// -------------------------method of Show Order Booking Screen For
	// IP----------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showOrderBookingJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		int deptId = (Integer) map.get("deptId");
		int inPatientId = (Integer) map.get("inPatientId");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List orderNo = new ArrayList();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatientId)).list();
			orderNo = session.createCriteria(DgOrderhd.class, "syd")
					.add(Restrictions.eq("syd.Department.Id", deptId)).list();

			// orderNo = session.createQuery(
			// "select syd from DgOrderhd as syd where syd.Department.Id="
			// + deptId).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "Y"))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			if (inPatientDetailList != null) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
			}
			if (map.get("buttonFlag") != null) {
				int orderSeqNo = (Integer) map.get("orderSeqNo");
				map.put("orderSeqNo", orderSeqNo);
			} else {
				if (orderNo.size() > 0) {
					DgOrderhd dgOrderhd = (DgOrderhd) orderNo.get(0);
					String orderSeqNo = dgOrderhd.getOrderNo();
					orderSeqNo = orderSeqNo + 1;
					map.put("orderSeqNo", orderSeqNo);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("orderNo", orderNo);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("employeeList", employeeList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showOrderBookingOP(Map<String, Object> map) {
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		String admissionNumber = null;
		List<Visit> visitList = new ArrayList<Visit>();
		@SuppressWarnings("unused")
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		int deptId = (Integer) map.get("deptId");
		int visitId = (Integer) map.get("visitId");
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List orderNo = new ArrayList();
		int doctorId = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			visitList = session.createCriteria(Visit.class)
					.add(Restrictions.eq("Id", visitId)).list();
			orderNo = session.createQuery(
					"select syd from DgOrderhd as syd where syd.Department.Id="
							+ deptId).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (visitList != null) {
				Visit visit = (Visit) visitList.get(0);
				visitId = visit.getId();
				doctorId = visit.getDoctor().getId();
			}
			if (map.get("buttonFlag") != null) {
				int orderSeqNo = (Integer) map.get("orderSeqNo");
				map.put("orderSeqNo", orderSeqNo);
			} else {
				if (orderNo.size() > 0) {
					DgOrderhd dgOrderhd = (DgOrderhd) orderNo.get(0);
					String orderSeqNo = dgOrderhd.getOrderNo();
					orderSeqNo = orderSeqNo + 1;
					map.put("orderSeqNo", orderSeqNo);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("doctorId", doctorId);
		map.put("orderNo", orderNo);
		map.put("visitList", visitList);
		map.put("employeeList", employeeList);
		return map;
	}

	// -----------------------Method For Get Main Charge
	// Code--------------------------

	public Map<String, Object> getMainChargeCode(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> mainChargeCodeList = new ArrayList<MasChargeCode>();
		String str = "";
		if (parameterMap.get("autoHint") != null) {
			str = parameterMap.get("autoHint") + "%";
		}
		try {
			Session session = (Session) getSession();
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class)
					.add(Restrictions.eq("MainChargecodeName", str)).list();
			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
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

	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * fillItemsForMainChargeCode(Map<String, Object> dataMap) { Map<String,
	 * Object> map = new HashMap<String, Object>();
	 * 
	 * List<MasMainChargecode> mainChargeList= new
	 * ArrayList<MasMainChargecode>(); Session session = (Session)getSession();
	 * String mainChargeName=(String)dataMap.get("mainChargeName"); try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); mainChargeList =
	 * session.createCriteria
	 * (MasMainChargecode.class).add(Restrictions.eq("MainChargecodeName",
	 * mainChargeName)).list(); map.put("mainChargeList", mainChargeList);
	 * }catch(Exception e) { e.printStackTrace(); } return map; }
	 */
	// --------------------------- Method to get MainChargeCode & SubChargeCode
	// List-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getMainAndSubCharge() {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasMainChargecode> mainChargeCodeList1 = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();

		Session session = (Session) getSession();
		try {
			List<String> lst = new ArrayList<String>();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("table_constant.properties");
			// URL myURL= get getResource("/WEB-INF/commonFile.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				lst.add(prop.getProperty("mas_main_chargecode_lab"));
				lst.add(prop.getProperty("mas_main_chargecode_nt"));
				lst.add(prop.getProperty("mas_main_chargecode_infe"));
				lst.add(prop.getProperty("mas_main_chargecode_hema"));
				lst.add(prop.getProperty("mas_main_chargecode_xray"));
				lst.add(prop.getProperty("mas_main_chargecode_ct"));
				lst.add(prop.getProperty("mas_main_chargecode_so"));
				lst.add(prop.getProperty("mas_main_chargecode_pro"));
				lst.add(prop.getProperty("mas_main_chargecode_physio"));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "dt")
					.add(Restrictions.in("MainChargecodeCode", lst))// .add(
					// .add(Restrictions.or(lhs, rhs)("dt.DepartmentTypeCode",
					// lst))
					// Restrictions.or(Restrictions.eq("Id", 19)))
					.list();
			// mainChargeCodeList1 = session
			// .createCriteria(MasMainChargecode.class)
			// .add(Restrictions.eq("Id", 19)).list();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			/*
			 * mainChargeCodeList=mainChargeCodeList.add(mainChargeCodeList1);
			 * for(MasMainChargecode mcc:mainChargeCodeList1){
			 * mainChargeCodeList
			 * =mainChargeCodeList.add(""+mainChargeCodeList1); }
			 */if (mainChargeCodeList.size() > 0) {
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMainAndSubChargeForLab(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		String deptType = (String) dataMap.get("deptType");
		Session session = (Session) getSession();
		Properties properties = new Properties();
		String billingScreen = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
		try {
			List lst = new ArrayList();
			int deptId=0;
			
			if(dataMap.get("billingScreen")!=null && dataMap.get("billingScreen")!="")
				billingScreen = (String)dataMap.get("billingScreen"); // added by amit das on 11-05-2017
		
			
			if(billingScreen!=null && billingScreen.equalsIgnoreCase("y")){ // added by amit das on 11-05-2017
				lst.add("DIAG");
				lst.add("RADIO");
			}else{
			
				if(dataMap.get("deptId")!=null){
					deptId=(Integer)dataMap.get("deptId");
				}
				
				if("DIAG".equalsIgnoreCase(deptType)){
					lst.add("DIAG");	
				}else if("RADIO".equalsIgnoreCase(deptType)){
					lst.add("RADIO");	
				}
			
			}
			/*mainChargeCodeList*/   Criteria ct = session
					.createCriteria(MasMainChargecode.class)
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "dt")
					.add(Restrictions.eq("Status", "y").ignoreCase());
			       if(lst!=null && lst.size()>0){
					ct.add(Restrictions.in("dt.DepartmentTypeCode", lst));
			        }
					ct.addOrder(Order.asc("MainChargecodeName"));
					mainChargeCodeList=	ct.list();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).createAlias("MainChargecode", "mainChargecode")
					.createAlias("mainChargecode.Department", "department")
					.add(Restrictions.eq("department.Id", labDepartmentId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("SubChargecodeName")).list();
			List<Integer>mainChargeList=new ArrayList<Integer>();
			mainChargeList.add(17);
			mainChargeList.add(22);
			mainChargeList.add(39);
			mainChargeList.add(23);
			mainChargeList.add(14);
			mainChargeList.add(42);
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.in("MainChargecode.Id", mainChargeList))
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

	// --------------------------- Method to get charge code for
	// autocomplete-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCode(Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();

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
		/**
		 * Modified By Rajesh Kumar On 29 nov 2008 Code is modified to get ajax
		 * list in order booking screen in Test code column of grid List get
		 * data from Investigation master
		 */
		try {
			Session session = (Session) getSession();
			if (subChargeCodeId != 0) {
				// chargeCodeList =
				// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
				// str)).list();
				// chargeCodeList =
				// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
				// str)).createAlias("SubChargecode",
				// "scc").add(Restrictions.eq("scc.Id",
				// subChargeCodeId)).createAlias("ChargeType",
				// "ct").add(Restrictions.eq("ct.ChargeTypeName",
				// "Diagnostic")).list();
				chargeCodeList = session
						.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.like("InvestigationName", str))
						.createAlias("SubChargecode", "scc")
						.add(Restrictions.eq("scc.Id", subChargeCodeId)).list();

			} else if (mainChargeCodeId != 0) {
				try {
					// chargeCodeList =
					// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
					// str)).list();
					// chargeCodeList =
					// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
					// str)).createAlias("MainChargecode",
					// "mcc").add(Restrictions.eq("mcc.Id",
					// mainChargeCodeId)).createAlias("ChargeType",
					// "ct").add(Restrictions.eq("ct.ChargeTypeName",
					// "Diagnostic")).list();
					chargeCodeList = session
							.createCriteria(DgMasInvestigation.class)
							.add(Restrictions.like("InvestigationName", str))
							.createAlias("MainChargecode", "mcc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.list();

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
				// chargeCodeList =
				// session.createCriteria(DgMasInvestigation.class).add(Restrictions.like("InvestigationName",
				// str)).list();
				// chargeCodeList =
				// session.createCriteria(MasChargeCode.class).add(Restrictions.like("ChargeCodeCode",
				// str)).createAlias("ChargeType",
				// "ct").add(Restrictions.eq("ct.ChargeTypeName",
				// "Diagnostic")).list();
				chargeCodeList = session
						.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.like("InvestigationName", str))
						.list();

			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeList", chargeCodeList);
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

	// --------------------------- Method to fill details in grid for Charge
	// code -----------------------------------
	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * fillItemsForChargeCode(Map<String, Object> dataMap) { Map<String, Object>
	 * map = new HashMap<String, Object>();
	 * 
	 * List chargeList = new ArrayList(); Session session = (Session)
	 * getSession(); String chargeCode = (String) dataMap.get("chargeCode");
	 * float rate = 0; try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); chargeList =
	 * session.createCriteria(DgMasInvestigation
	 * .class).add(Restrictions.eq("InvestigationName", chargeCode)).list();
	 * map.put("chargeList", chargeList); } catch (Exception e) {
	 * e.printStackTrace(); } return map; }
	 */

	// public Map<String, Object> fillItemsForChargeCode(Map<String, Object>
	// dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	//
	// List chargeList= new ArrayList();
	// Session session = (Session)getSession();
	// String chargeCode=(String)dataMap.get("chargeCode");
	// try {
	// org.springframework.orm.hibernate3.HibernateTemplate hbt =
	// getHibernateTemplate();
	// hbt.setFlushModeName("FLUSH_EAGER");
	// hbt.setCheckWriteOperations(false);
	// chargeList =
	// session.createCriteria(MasChargeCode.class).add(Restrictions.eq("ChargeCodeCode",
	// chargeCode)).list();
	// map.put("chargeList", chargeList);
	//
	// }catch(Exception e)
	// {
	// e.printStackTrace();
	// }
	// return map;
	// }
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeForAutoComplete(
			Map<String, Object> parameterMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeCode> chargeCodeList1 = new ArrayList<MasChargeCode>();
		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> existingSampleList = new ArrayList<DgMasInvestigation>();

		int subChargeCodeId = 0;
		int mainChargeCodeId = 0;
		int hospitalId=0;
		String rareCommon = "";
		String str = "";
		int orderHdId = 0;
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) parameterMap.get("subChargeCodeId");
		}
		if (parameterMap.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) parameterMap.get("mainChargeCodeId");
		}
		if (parameterMap.get("orderHdId") != null) {
			orderHdId = (Integer) parameterMap.get("orderHdId");
		}
		if (parameterMap.get("autoHint") != null) {
			str = "%" + parameterMap.get("autoHint") + "%";
		}
		if (parameterMap.get("rareCommon") != null) {
			rareCommon = (String) parameterMap.get("rareCommon");
		}

		try {
			Session session = (Session) getSession();
			
		if(orderHdId != 0){
			dgOrderdtList = session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", orderHdId)).list();
			List<Integer> chargeList = new ArrayList<Integer>();
			Set sampleIdSet = new HashSet();
			if(dgOrderdtList.size()>0){
				for(DgOrderdt dgOrderdt :dgOrderdtList){
					int chargeCodeId = dgOrderdt.getChargeCode().getId();
					chargeList.add(chargeCodeId);
					existingSampleList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.in("ChargeCode.Id", chargeList)).list();
					if(existingSampleList.size()>0){
						for(DgMasInvestigation inv : existingSampleList){
						int sampleId = inv.getSample().getId();
						sampleIdSet.add(sampleId);
					 }
					}
				}
			}
			if(sampleIdSet != null){
			if (subChargeCodeId >0) {
				chargeCodeList = session
						.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.like("InvestigationName", str)
								.ignoreCase())
						// .add(Restrictions.eq("RareCommon", rareCommon))
						.createAlias("SubChargecode", "scc")
						.createAlias("ChargeCode", "cc")
						.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
						.add(Restrictions.eq("scc.Id", subChargeCodeId))
						.add(Restrictions.eq("Status", "Y").ignoreCase())
						.add(Restrictions.in("Sample.Id", sampleIdSet))
						.list();
			} else if (mainChargeCodeId != 0) {
				try {
					chargeCodeList = session
							.createCriteria(DgMasInvestigation.class)
							.add(Restrictions.like("InvestigationName", str)
									.ignoreCase())
							// .add(Restrictions.eq("RareCommon", rareCommon))
							.createAlias("MainChargecode", "mcc")
							.createAlias("ChargeCode", "cc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
							.add(Restrictions.eq("Status", "Y").ignoreCase())
							.add(Restrictions.in("Sample.Id", sampleIdSet))
							.list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} 
		}
			
		}else{
			if (subChargeCodeId >0) {
				chargeCodeList = session
						.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.like("InvestigationName", str)
								.ignoreCase())
						// .add(Restrictions.eq("RareCommon", rareCommon))
						.createAlias("SubChargecode", "scc")
						.createAlias("ChargeCode", "cc")
						.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
						.add(Restrictions.eq("scc.Id", subChargeCodeId))
						.add(Restrictions.eq("Status", "Y").ignoreCase())
						.list();
			} else if (mainChargeCodeId != 0) {
				try {
					/*chargeCodeList = session
							.createCriteria(DgMasInvestigation.class)
							.add(Restrictions.like("InvestigationName", str)
									.ignoreCase())
							// .add(Restrictions.eq("RareCommon", rareCommon))
							.createAlias("MainChargecode", "mcc")
							.createAlias("ChargeCode", "cc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
							.add(Restrictions.eq("Status", "Y").ignoreCase())
							.list();*/
					Query qry=session.createQuery("from DgMasInvestigation where LOWER(InvestigationName) "
							+ "like LOWER( '"+str+"') and ChargeCode.Id in "
							+ "(select dhc.ChargeCode.Id  from MasHospitalwiseChargecode dhc where hospital_id="+hospitalId+"and ChargeCode.Id in"
							+ "(select mcc.Id from MasChargeCode mcc ))");
					chargeCodeList=qry.list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} 
			
		}	
			
			/*
			 * else if (subChargeCodeId == 0 && mainChargeCodeId == 0) {
			 * chargeCodeList = session
			 * .createCriteria(DgMasInvestigation.class)
			 * .add(Restrictions.like("InvestigationName", str))
			 * //.add(Restrictions.eq("RareCommon", rareCommon))
			 * .add(Restrictions.eq("Status", "y")).list(); }
			 */
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			} /*else {

				chargeCodeList1 = session
						.createCriteria(MasChargeCode.class)
						.add(Restrictions.like("ChargeCodeName", "%" + str)
								.ignoreCase())
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
						.add(Restrictions.eq("Status", "Y").ignoreCase())
						.list();

				detailsMap.put("chargeCodeList1", chargeCodeList1);
			}*/
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
	public Map<String, Object> getChargeCodeDetails(String chargeCodeName,
			int hinId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();
		List<Patient> patientList = new ArrayList<Patient>();
		Criteria crit = null;
		Session session = (Session) getSession();

		try {
			chargeCodeList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("InvestigationName", chargeCodeName))
					.list();
			DgMasInvestigation masChargeCode = new DgMasInvestigation();
			if(chargeCodeList.size() > 0){
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
						map.put("patientTypeId", patientTypeId);
					}
					if (patientList.get(0).getCompany() != null) {
						companyId = patient.getCompany().getId();
						map.put("companyId", companyId);
					}
					if (patient.getRegistrationType() != null) {
						regType = patient.getRegistrationType();
						map.put("regType", regType);
					}

				}

				map.put("chargeId", chargeId);
				map.put("mainChargeId", mainChargeId);
				map.put("subChargeId", subChargeId);
				map.put("billTypeId", 2);
				map.put("patientCategory", "IP");
				map.put("hospitalId", hospitalId);
				map = getChargeAmountAfterDiscount(map);
				if (patientList.size() > 0 && chargeCodeList.size() > 0) {
					map.put("chargeCodeList", chargeCodeList);
				} else {
					map.put("chargeCodeList", chargeCodeList);
				}
				map.put("chargeId", chargeId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// --------------------------- Method to submit Order Booking of
	// IP-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitOrderBooking(Map<String, Object> infoMap) {
		DgOrderhd dgOrderhd = new DgOrderhd();
		
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();

		int hinId = 0;
		int hospitalId = 0;
		int inpatientId = 0;
		int userId = (Integer) infoMap.get(USER_ID);

		if (infoMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd");
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("amountList") != null) {
			amountList = (List) infoMap.get("amountList");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}

		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) infoMap.get("orderDetailIdList");
		}
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

		try {

			try {
				hbt.save(dgOrderhd);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}

			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
			}
			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						DgOrderdt dgOrderdt = new DgOrderdt();
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {

							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							dgOrderdt.setChargeCode(masChargeCode);

							if (amountList.get(i) != null) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								dgOrderdt.setAmount(amount);
							}

							if (mainChargeList.get(i) != null
									&& !mainChargeList.get(i).equals("")) {
								int mainChargeId = Integer
										.parseInt(mainChargeList.get(i)
												.toString());
								masMainChargecode.setId(mainChargeId);
								dgOrderdt.setMainChargecode(masMainChargecode);
							}

							if (subChargeList.get(i) != null
									&& !subChargeList.get(i).equals("")) {
								int subChargeId = Integer
										.parseInt(subChargeList.get(i)
												.toString());
								masSubChargecode.setId(subChargeId);
								dgOrderdt.setSubChargeid(masSubChargecode);
							}
							if (qtyList.get(i) != null
									&& !qtyList.get(i).equals("")) {
								int qty = Integer.parseInt("" + qtyList.get(i));
								dgOrderdt.setOrderQty(qty);
							}
							dgOrderdt.setOrderStatus("P");
							dgOrderdt.setPaymentMade("n");
							dgOrderdt.setLastChgDate(changeDate);
							dgOrderdt.setLastChgTime(time);
							Users users = new Users();
							users.setId(userId);
							dgOrderdt.setLastChgBy(users);
							dgOrderdt.setOrderhd(dgOrderhd);
							try {
								hbt.save(dgOrderdt);
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else if (!orderDetailIdList.get(i).toString()
								.equals("")) {
							DgOrderdt orderdt = (DgOrderdt) hbt.load(
									DgOrderdt.class, (Integer
											.parseInt(orderDetailIdList.get(i)
													.toString())));
							hbt.update(orderdt);

						}
					}
				}
			}

			// ---------------------Save or Update Data into sampleHeader
			// table---------------------------

			try {
				DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
				List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
				for (int a = 0; a < chargeList.size(); a++) {
					int chargeCodeId = Integer.parseInt(chargeList.get(a)
							.toString());
					Session session = (Session) getSession();
					chargeCodeList = session
							.createCriteria(MasChargeCode.class)
							.add(Restrictions.eq("Id", chargeCodeId)).list();
					if (chargeCodeList.size() > 0) {
						MasChargeCode chargeCode = chargeCodeList.get(0);
						if (chargeCode.getDepartment()
								.getDepartmentType().getDepartmentTypeCode()
								.equals("RADIO")) {

							if (hinId != 0) {
								Patient patient = new Patient();
								patient.setId(hinId);
								collHeader.setHin(patient);
							}
							if (inpatientId != 0) {
								Inpatient inpatient = new Inpatient();
								inpatient.setId(inpatientId);
								collHeader.setInpatient(inpatient);
							}
							if (chargeCode.getDepartment() != null) {
								MasDepartment department = new MasDepartment();
								department.setId(chargeCode.getMainChargecode()
										.getDepartment().getId());
								collHeader.setDepartment(department);
							}
							collHeader.setHospital(hospital);
							collHeader.setOrder(dgOrderhd);
							collHeader.setDiagnosisDate(changeDate);
							collHeader.setDiagnosisTime(time);
							collHeader.setOrderStatus("P");
							// collHeader.setLastChgBy(userName);
							collHeader.setLastChgDate(changeDate);
							collHeader.setLastChgTime(time);

							hbt.save(collHeader);

							// -----------------------in sample
							// detail----------------------------
							for (int i = 0; i < chargeCodeList.size(); i++) {
								DgSampleCollectionDetails sampleDetails = new DgSampleCollectionDetails();
								sampleDetails
										.setSampleCollectionHeader(collHeader);
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(chargeCodeId);
								sampleDetails.setChargeCode(masChargeCode);

								sampleDetails.setCollected("y");
								// sampleDetails.setLastChgBy(userName);
								sampleDetails.setLastChgDate(changeDate);
								sampleDetails.setLastChgTime(time);
								sampleDetails.setOrderStatus("P");
								sampleDetails.setSampleCollDatetime(changeDate);

								MasMainChargecode maincharge = new MasMainChargecode();
								maincharge.setId(chargeCode.getMainChargecode()
										.getId());
								sampleDetails.setMaincharge(maincharge);

								MasSubChargecode subCharge = new MasSubChargecode();
								subCharge.setId(chargeCode.getSubChargecode()
										.getId());
								sampleDetails.setSubcharge(subCharge);

								int subChargeId = chargeCode.getSubChargecode()
										.getId();
								String diagNo = generateDiagNumber(subChargeId);
								sampleDetails.setDiagNo(diagNo);

								DgMasInvestigation investigation = new DgMasInvestigation();
								investigation.setId(chargeCodeId);
								sampleDetails.setInvestigation(investigation);
								sampleDetails.setSampleCollDatetime(new Date());

								hbt.save(sampleDetails);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return infoMap;
	}

	// ----------------------Method For Patient Name on the basis of Service
	// number------------
	@SuppressWarnings("unchecked")
	public List<Patient> getPatientName(String serviceNo) {
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	// ----------------------Method For Visit Number on the basis of Patient
	// Name-------------
	/*
	 * @SuppressWarnings("unchecked") public List<Visit> getVisitNo(int hinId) {
	 * Session session = (Session) getSession(); List<Visit> visitNoList = new
	 * ArrayList<Visit>(); @SuppressWarnings("unused") Visit visit = new
	 * Visit(); visitNoList =
	 * session.createCriteria(Visit.class).createAlias("Hin"
	 * ,"p").add(Restrictions.eq("p.Id", hinId)).list(); return visitNoList; }
	 */

	// -------------------------Method For Show Order booking For
	// OP-------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showOrderBookingForInvestigationJsp(int visitNo,int hospitalId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Integer> maxVisitIdList = new ArrayList<Integer>();
		List<Visit> visitIdList = new ArrayList<Visit>();
		List<Integer> orderNo = new ArrayList<Integer>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<DgOrderhd>hdList=new ArrayList<DgOrderhd>();
		//List<EmpScMapping> employeeList=new ArrayList<EmpScMapping>();
		
		int maxVisitId = 0;
		int doctorId = 0;
		int pharmacyLabQueueId=0;
		List<PharmacyLabQueue> pharmacyLabList=new ArrayList<PharmacyLabQueue>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			visitList = session.createCriteria(Visit.class)
					.add(Restrictions.eq("Id", visitNo)).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.Id", 4))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			//added by govind 03-06-2017
			pharmacyLabList=session.createCriteria(PharmacyLabQueue.class)
					.createAlias("Visit", "visit")
			.add(Restrictions.eq("visit.Id", visitNo))
			.list();
			
             if(pharmacyLabList.size()>0){
            	 PharmacyLabQueue ph=pharmacyLabList.get(0);
            	pharmacyLabQueueId=ph.getId();
             }
           //added by govind 03-06-2017 end
             
			/*Criteria crt=null;
			crt=session.createCriteria(EmpScMapping.class).createAlias("Employee", "employee")
					.createAlias("Hospital", "Hospital")
					.createAlias("Department", "Department")
					.createAlias("employee.MasCategory", "catergory")
					.add(Restrictions.eq("catergory.Id", 4))
			.add(Restrictions.eq("Hospital.Id", hospitalId));
			//.add(Restrictions.eq("Department.Id", departmentId));
			employeeList=crt.list();*/
			
			

			Visit visit = new Visit();
			if(visitList.size()>0)
			visit = visitList.get(0);

			int hinId = 0 ;
			if(visit!=null &&  visit.getHin()!=null) // added by amit das on 21-07-2016
				hinId = visit.getHin().getId();
			
			try {
				maxVisitIdList = hbt
						.find("select max(v.Id) from jkt.hms.masters.business."
								+ "Visit v join v.Hin as p where p.Id = "
								+ hinId);

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			if(maxVisitIdList!=null && maxVisitIdList.get(0)!=null)  // added by amit das on 21-07-2016
				maxVisitId = maxVisitIdList.get(0);
			
			try {
				visitIdList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", maxVisitId)).list();
				Visit lastVisit = new Visit();
				
				if(visitIdList!=null && visitIdList.size()>0) // added by amit das on 21-07-2016
				lastVisit = (Visit) visitIdList.get(0);
				
				
				if (lastVisit.getDoctor() != null) {
					doctorId = lastVisit.getDoctor().getId();
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "v")
					.add(Restrictions.eq("v.Id", maxVisitId)).list();
			if(visit.getHospital() != null) {
				hdList=session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id", hinId)) 
					.add(Restrictions.eq("OrderStatus","P").ignoreCase())
					.add(Restrictions.eq("Hospital.Id",visit.getHospital().getId()))
					.addOrder(Order.asc("Id")).list();
				
				int dgOrderhdId = 0;
				List<Integer> todaysPendingOrderId = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id", hinId)) 
						.add(Restrictions.eq("OrderStatus","P").ignoreCase()).add(Restrictions.eq("OrderDate", new Date()))
						.add(Restrictions.eq("Hospital.Id",visit.getHospital().getId()))
						.setProjection(Projections.property("Id")).list();
				if(todaysPendingOrderId.size()>0)
					dgOrderhdId = todaysPendingOrderId.get(0);
				map.put("dgOrderhdId", dgOrderhdId);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("doctorId", doctorId);
		map.put("icdList", icdList);
		map.put("orderNo", orderNo);
		map.put("visitList", visitList);
		map.put("employeeList", employeeList);
		map.put("hdList", hdList);
		map.put("pharmacyLabQueueId", pharmacyLabQueueId);
		return map;
	}

	// --------------------------- Method to submit Order Booking of
	// OP-----------------------------------

	@SuppressWarnings("unchecked")
	public Map<String,Object> submitOrderBookingForInvestigation(Box box,
			Map<String, Object> infoMap) {
		
		final Map<String, Object> dataForOrderBooking =  new HashMap<String, Object>(); // added by amit das on 11-09-2017
		Map<DgOrderhd, Set<DgOrderdt>> orderMap = new HashMap<DgOrderhd, Set<DgOrderdt>>();  // added by amit das on 11-09-2017
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleCollectionMap = new HashMap<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>();  // added by amit das on 11-09-2017
		Set<DgOrderdt> dgOrderdts = null; // added by amit das on 11-09-2017
		Set<DgSampleCollectionDetails> collectionDetailsSet = null; // added by amit das on 11-09-2017
		
		DgOrderhd dgOrderhd = new DgOrderhd();
		Map<String, Object> resultMap = new HashMap<String, Object>(); // added by amit das on 03-06-2017
		/* IpPhysioReqHeader ipph=new IpPhysioReqHeader(); */
		String userName = "";
		boolean saved = false;
		boolean flag = false;
		Session session = (Session) getSession();
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();

		int hinId = 0;
		int hospitalId = 0;
		int inpatientId = 0;
		Integer userId = 0;
		Users users = null;
		int visitId=0;
		int dgOrderHdId=0;
		int pharmacyLabQueueId=0;
		String adNo="";
		String uHid="";
		if(null !=infoMap.get("pharmacyLabQueueId")){
			pharmacyLabQueueId=(Integer)infoMap.get("pharmacyLabQueueId");
		}

		if (infoMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd"); 
		}
		if(box.get(RequestConstants.VISIT_ID)!=null){
			visitId=box.getInt(RequestConstants.VISIT_ID);
		}
		
		
		
		if (infoMap.get(RequestConstants.USERS) != null) {
			users = (Users) infoMap.get(RequestConstants.USERS);
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("amountList") != null) {
			amountList = (List) infoMap.get("amountList");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}

		if (infoMap.get("inpatientId") != null) {
			inpatientId = (Integer) infoMap.get("inpatientId");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get(USER_ID) != null) {
			userId = (Integer) infoMap.get(USER_ID);
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) infoMap.get("orderDetailIdList");
		}
		if (infoMap.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) infoMap.get("dgOrderHdId");
		}
		/*
		 * Users users = new Users(); users.setId(userId);
		 */
		MasHospital hospital = new MasHospital();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		hospital = 		hbt.get(MasHospital.class, hospitalId);
		
		

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
		int ipphId = 0;
		int hdId=0;
		if(box.getInt("pendingName")!=0){
			hdId=box.getInt("pendingName");
		}
		DgSampleCollectionHeader collHeader  = null;
	
		DgOrderhd hdOld=null;
		Set<DgOrderdt> dgOrderdtsOld=null;
		hdOld=(DgOrderhd)session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Id",hdId)).uniqueResult();
		if(hdOld!=null){
			hdOld.setOrderStatus("N");
			hbt.update(hdOld); 	
			dgOrderdtsOld=hdOld.getDgOrderdts();
		}
		
		try {

			try {
				if(dgOrderHdId==0){
					PharmacyLabQueue pharmacyLabQueue=null;//Added by govind 27-07-2017 for IP Lab OrderBooking
					if(pharmacyLabQueueId>0){
						 pharmacyLabQueue=(PharmacyLabQueue) session.createCriteria(PharmacyLabQueue.class)
						.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("Id", pharmacyLabQueueId)).list().get(0);
					}
					hbt.save(dgOrderhd);
					hbt.refresh(dgOrderhd);
					if(pharmacyLabQueueId>0){
					pharmacyLabQueue.setDgOrderhdId(dgOrderhd);
					pharmacyLabQueue.setStatus("P");
					hbt.update(pharmacyLabQueue);
					}
				}else{
					dgOrderhd.setId(dgOrderHdId);
				}
				
				
				/*
				 * hbt.save(ipph); ipphId=ipph.getId();
				 */
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			//added by govind 27-07-2017
			if(dgOrderhd!=null){
				if(dgOrderhd.getInpatient()!=null){
					uHid=dgOrderhd.getHin().getHinNo();
					adNo=dgOrderhd.getInpatient().getAdNo();
				}
			}
			//added by govind 27-07-2017 end
			if (infoMap.get("chargeList") != null) {
				chargeList = (List) infoMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {
						/*
						 * int mainChargeId1 = Integer
						 * .parseInt(mainChargeList.get(i) .toString());
						 */
						/*
						 * if(mainChargeId1==19){ IpPhysioReqDetails ippd=new
						 * IpPhysioReqDetails();
						 * 
						 * IpPhysioReqHeader ipph1=new IpPhysioReqHeader();
						 * ipph1.setId(ipphId); ippd.setIpReqHeader(ipph1);
						 * 
						 * MasChargeCode mcc=new MasChargeCode();
						 * mcc.setId(Integer.parseInt(chargeList.get(i)
						 * .toString())); ippd.setChargeCode(mcc);
						 * hbt.save(mcc); }
						 */
						DgOrderdt dgOrderdt = null;
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();
						int chargeId = 0;
						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							if(dgOrderdtsOld!=null && dgOrderdtsOld.size()>0){
								for(DgOrderdt orderdtNew:dgOrderdtsOld){
									if(orderdtNew.getChargeCode().getId()==chargeId){
										dgOrderdt=orderdtNew;
										break;
									}else{
										dgOrderdt=new DgOrderdt();
									}
								}
							}else{
								 dgOrderdt = new DgOrderdt();
							}
							

							
							masChargeCode.setId(chargeId);
							dgOrderdt.setChargeCode(masChargeCode);

							if (amountList.get(i) != null) {
								BigDecimal amount = new BigDecimal(amountList
										.get(i).toString());
								dgOrderdt.setAmount(amount);
							}
							int mainChargeId = 0;
							if (mainChargeList.get(i) != null
									&& !mainChargeList.get(i).equals("")) {
								mainChargeId = Integer.parseInt(mainChargeList
										.get(i).toString());
								masMainChargecode.setId(mainChargeId);
								dgOrderdt.setMainChargecode(masMainChargecode);
							}
							if (mainChargeId == 19) {
								IpPhysioReqHeader ipph = new IpPhysioReqHeader();

								//
								Patient pt = new Patient();
								pt.setId(Integer.parseInt(box.getString(HIN_ID)));
								ipph.setHin(pt);

								Inpatient ip = new Inpatient();
								ip.setId(Integer.parseInt(box
										.getString(INPATIENT_ID)));

								ipph.setInpatient(ip);
								ipph.setLastChgBy(users);
								ipph.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								ipph.setLastChgTime(time);

								ipph.setStatus("p");
								savePhysioIP(ipph);
								// infoMap.put("ipph", ipph);

								IpPhysioReqDetails ippd = new IpPhysioReqDetails();

								IpPhysioReqHeader iph = new IpPhysioReqHeader();
								iph.setId(ipph.getId());
								ippd.setIpReqHeader(iph);

								MasChargeCode mcc = new MasChargeCode();
								mcc.setId(chargeId);
								ippd.setChargeCode(mcc);

								hbt.save(ippd);
							} else if (chargeId == 1467) {

								IpDialysisReqHeader ipph = new IpDialysisReqHeader();

								//
								Patient pt = new Patient();
								pt.setId(Integer.parseInt(box.getString(HIN_ID)));
								ipph.setHin(pt);

								Inpatient ip = new Inpatient();
								ip.setId(Integer.parseInt(box
										.getString(INPATIENT_ID)));

								ipph.setInpatient(ip);
								ipph.setLastChgBy(users);
								ipph.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								ipph.setLastChgTime(time);

								ipph.setStatus("p");
								
								saveDialysisIP(ipph);
								// infoMap.put("ipph", ipph);

								IpDialysisDetails ippd = new IpDialysisDetails();

								IpPhysioReqHeader iph = new IpPhysioReqHeader();
								iph.setId(ipph.getId());
								ippd.setIpReqHeader(iph);

								MasChargeCode mcc = new MasChargeCode();
								mcc.setId(chargeId);
								ippd.setChargeCode(mcc);

								hbt.save(ippd);

							}

							if (subChargeList.get(i) != null
									&& !subChargeList.get(i).equals("")) {
								int subChargeId = Integer
										.parseInt(subChargeList.get(i)
												.toString());
								masSubChargecode.setId(subChargeId);
								dgOrderdt.setSubChargeid(masSubChargecode);
							}
							if (qtyList.get(i) != null
									&& !qtyList.get(i).equals("")) {
								Integer qty = Integer.parseInt(""
										+ qtyList.get(i));
								dgOrderdt.setOrderQty(qty);
							}
							dgOrderdt.setOrderStatus("P");
							dgOrderdt.setPaymentMade("n");
							dgOrderdt.setLastChgDate(changeDate);
							dgOrderdt.setLastChgTime(time);
							dgOrderdt.setLastChgBy(users);
							dgOrderdt.setOrderhd(dgOrderhd);
							/*
							 * Code By Mukesh Narayan SIngh Date 10-03-2011 for
							 * Pacs Inegration dgOrderdt.setMsgSent("n");
							 * dgOrderdt.setPacsStatus("n");
							 */
							dgOrderdt.setMsgSent("n");
							dgOrderdt.setPacsStatus("n");
							try {
								hbt.save(dgOrderdt);
							} catch (Exception e) {
								e.printStackTrace();
							}
						} else if (!orderDetailIdList.get(i).toString()
								.equals("")) {
							DgOrderdt orderdt = (DgOrderdt) hbt.load(
									DgOrderdt.class, (Integer
											.parseInt(orderDetailIdList.get(i)
													.toString())));
							hbt.update(orderdt);

						}
						
					}
				}
				hbt.refresh(dgOrderhd);
				dgOrderdts =	dgOrderhd.getDgOrderdts();  
				Hibernate.initialize(dgOrderdts); 
				Hibernate.initialize(dgOrderhd.getHin());
				Hibernate.initialize(dgOrderhd.getVisit());
				orderMap.put(dgOrderhd, dgOrderdts); 

			}

			// ---------------------Save or Update Data into sampleHeader
			// table---------------------------

			try {
				collHeader = new DgSampleCollectionHeader();
				List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
				for (int a = 0; a < chargeList.size(); a++) {
					int chargeCodeId = Integer.parseInt(chargeList.get(a)
							.toString());
					
					chargeCodeList = session
							.createCriteria(MasChargeCode.class)
							.add(Restrictions.eq("Id", chargeCodeId)).list();
					if (chargeCodeList.size() > 0) {
						MasChargeCode chargeCode = chargeCodeList.get(0);
					
						if (chargeCode.getDepartment()
								.getDepartmentType().getDepartmentTypeCode()
								.equals("RADIO")) {

							if (hinId != 0) {
								Patient patient = new Patient();
								patient.setId(hinId);
								collHeader.setHin(patient);
							}
							if (inpatientId != 0) {
								Inpatient inpatient = new Inpatient();
								inpatient.setId(inpatientId);
								collHeader.setInpatient(inpatient);
							}
							if (chargeCode.getDepartment() != null) {
								MasDepartment department = new MasDepartment();
								department.setId(chargeCode.getDepartment().getId());
								collHeader.setDepartment(department);
							}
							collHeader.setHospital(hospital);
							collHeader.setOrder(dgOrderhd);
							collHeader.setDiagnosisDate(changeDate);
							collHeader.setDiagnosisTime(time);
							collHeader.setOrderStatus("P");
							collHeader.setLastChgBy(users);
							collHeader.setLastChgDate(changeDate);
							collHeader.setLastChgTime(time);

							hbt.save(collHeader);

							// -----------------------in sample
							// detail----------------------------
							for (int i = 0; i < chargeCodeList.size(); i++) {
								DgSampleCollectionDetails sampleDetails = new DgSampleCollectionDetails();
								sampleDetails
										.setSampleCollectionHeader(collHeader);
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(chargeCodeId);
								sampleDetails.setChargeCode(masChargeCode);
								sampleDetails.setCollectedBy(users
										.getEmployee());
								// sampleDetails.setSample(sample);
								sampleDetails.setCollected("y");
								sampleDetails.setLastChgBy(users);
								sampleDetails.setLastChgDate(changeDate);
								sampleDetails.setLastChgTime(time);
								sampleDetails.setOrderStatus("P");
								sampleDetails.setSampleCollDatetime(changeDate);

								MasMainChargecode maincharge = new MasMainChargecode();
								int mainChargeId = Integer
										.parseInt(mainChargeList.get(i)
												.toString());
								maincharge.setId(chargeCode.getMainChargecode()
										.getId());
								sampleDetails.setMaincharge(maincharge);

								MasSubChargecode subCharge = new MasSubChargecode();
								subCharge.setId(chargeCode.getSubChargecode()
										.getId());
								sampleDetails.setSubcharge(subCharge);

								// String diagNo =
								// generateDiagNumber(subChargeId);
								// sampleDetails.setDiagNo(diagNo);

								DgMasInvestigation investigation = new DgMasInvestigation();
								investigation.setId(chargeCodeId);
								sampleDetails.setInvestigation(investigation);
								sampleDetails.setSampleCollDatetime(new Date());

								hbt.save(sampleDetails);
							}
						}
					}
				}
			
				List<Visit>visitList=new ArrayList<Visit>();
				visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
			for(Visit visit:visitList){
				visit.setVisitStatus("C");
				hbt.update(visit);
			} 
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			Map<String,Object> mapForBilling=new HashMap<String, Object>(); 
			mapForBilling.put(HIN_ID, hinId);
			if(dgOrderhd.getVisit()!=null){//Added by govind 27-07-2017 for IP Lab OrderBooking
			mapForBilling.put(VISIT_ID, dgOrderhd.getVisit().getId());
			}
			mapForBilling.put(HOSPITAL_ID, hospitalId);
			mapForBilling.put(USER_ID, userId);
			mapForBilling.put("orderId", dgOrderhd.getId()); 
			/*if(visitId!=0)
				billingMasterDataService.internalBillingForService(mapForBilling);*/
			 
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		tx.commit(); 
		
	
		
		if(collHeader!=null && collHeader.getId()!=null){
			hbt.refresh(collHeader); 
			collectionDetailsSet  =	collHeader.getDgSampleCollectionDetails(); 
			Hibernate.initialize(collectionDetailsSet); 
			Hibernate.initialize(collHeader.getHin()); 
			Hibernate.initialize(collHeader.getOrder().getVisit()); 
			sampleCollectionMap.put(collHeader, collectionDetailsSet); 
		}
		saved = true;
		//int dgOrderhdId = dgOrderhd.getId();
		resultMap.put("dgOrderHdId", dgOrderhd.getId());
		resultMap.put("saved", saved);
		resultMap.put("adNo", adNo);
		resultMap.put("uHid", uHid);
		// resultMap.put("dgOrderhd", dgOrderhd);
		}catch(Exception e){
		e.printStackTrace();
		if(tx!=null){
			tx.rollback();
			}
		}
		
		Hibernate.initialize(hospital);
		dataForOrderBooking.put("orderMap", orderMap);  // added by amit das on  12-09-2017
		dataForOrderBooking.put("sampleMap", sampleCollectionMap); // added by amit das on  12-09-2017
		dataForOrderBooking.put("hospital", hospital);// added by amit das on  12-09-2017
		
		final MasHospital masHospital = hospital;
		
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
						sampleManipulactionToCentralServer(dataForOrderBooking,"order");
				} 
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
						sampleManipulactionToLeanServer(dataForOrderBooking,"order");
						
				}
			}
			
		}.start();*/
		
		
		return resultMap;
	}


	// --------------------------- Method to get patient details for Ip
	// -----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(String hinNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.not(Restrictions.eq("AdStatus", "D")))
					.createAlias("Hin", "p")
					.add(Restrictions.eq("HinNo", hinNo)).list();
			if (inPatientDetailList.size() > 0) {
				detailsMap.put("inPatientDetailList", inPatientDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ----------------method For Get patient Details Regarding Visit
	// Number------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetail(int visitNo) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		try {
			visitList = session.createCriteria(Visit.class)
					.add(Restrictions.eq("Id", visitNo)).list();
			if (visitList.size() > 0) {
				detailsMap.put("visitList", visitList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------------Method For get search Crieteria For Pending
	// Sample Collection--------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		Session session = (Session) getSession();
		List<Integer>mainChargeList=new ArrayList<Integer>();
		int currentLabId = 0; 
		MasHospital masHospital = null;
		mainChargeList.add(17);
		mainChargeList.add(22);
		mainChargeList.add(39);
		mainChargeList.add(23);
		mainChargeList.add(14);
		mainChargeList.add(42);
		try {
			
			int hospitalId =0;
			if(mapForDs.get("hospitalId")!=null){
			hospitalId=(Integer)mapForDs.get("hospitalId");
			}
			masHospital = (MasHospital)session.get(MasHospital.class, hospitalId);
			
			if(mapForDs.get("userId")!=null){
				int userId = (Integer)mapForDs.get("userId");
				Users user = (Users)session.get(Users.class, userId);
					
				if(user.getCurrentLab()!=null)
					currentLabId = 	user.getCurrentLab().getId();
					
				}
			
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("MainChargecode", "mcc")
					//.createAlias("mcc.Department", "dept")
					.add(Restrictions.eq("mcc.Id", 17)).list();
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			/*chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.in("MainChargecode.Id", mainChargeList))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
			investigationList=session.createCriteria(DgMasInvestigation.class) 
					.add(Restrictions.eq("MainChargecode.Id", 17)).addOrder(Order.asc("InvestigationName")).list();
			if(investigationList.size()>0){
				detailsMap.put("investigationList", investigationList);
			}
			sampleList = session.createCriteria(MasSample.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("SampleDescription")).list();
			if (sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap.put("currentLabId", currentLabId); // added by amit das on 17-07-2017
		detailsMap.put("masHospital", masHospital); // added by amit das on 18-07-2017	

		return detailsMap;
	}

	//Commented by Arbind on 12-04-2017
	// ---------------------------Method For get SampleCollectionGrid For
	// Current Date--------------------------
/*	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		
		List<DgOrderhd> patientAppInvestigationList = new ArrayList<DgOrderhd>();
		List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
		
		List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();
		
		
		Date currentDate = new Date();
		Integer hospitalId = 0;
		Integer departmentId=0;
		String patientType = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile()))); 
		//	int department_type_id= pacProper.get("department_type_id");
			
			//List<Integer> orderDtList=new ArrayList<Integer>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					.createAlias("Orderhd", "orderHd")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
				.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase());
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
				}
			}
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			System.out.println("patientAppInvestigationList "+patientAppInvestigationList.size());
			System.out.println("patientDetailList "+patientDetailList.size());

			
			//List<Integer> dgOrderHdList=new ArrayList<Integer>();
			crit = session.createCriteria(PharmacyLabQueue.class)
					.createAlias("DgOrderhdId", "dgOrderhdId")
					.createAlias("Department", "department")
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("department.Id", departmentId))
					.add(Restrictions.eq("OpdDate", currentDate))
					.add(Restrictions.eq("dgOrderhdId.PatientType", patientType))
					.add(Restrictions.eq("Status", "P").ignoreCase())
					//.setProjection(Projections.projectionList().add(Projections.groupProperty("TokenNo")))
					
					.addOrder(Order.asc("OpdTime"));
			pharmacyLabQueueList=crit.list();
			System.out.println(" pharmacyLabQueueList  "+pharmacyLabQueueList.size());
			if(pharmacyLabQueueList.size()>0){
				for(PharmacyLabQueue labQueue:pharmacyLabQueueList){
				dgOrderHdList.add(labQueue.getDgOrderhdId().getId());
				}
			}
			if(dgOrderHdList.size()>0){
			crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.in("oh.Id", dgOrderHdList))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate));
					

			patientDetailList = crit.list();
			}
			
			crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate))
					.add( Restrictions.not( Restrictions.in("id",orderList)));

			directOrderHdList=crit.list();
			System.out.println("directOrderHdList  "+directOrderHdList.size());
			if(patientAppInvestigationList !=null && patientAppInvestigationList.size()>0){
				patientDetailList.addAll(patientAppInvestigationList);
			}
			
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<DgOrderhd> finalDgOrderdhList=new ArrayList<DgOrderhd>();
		for(DgOrderhd dgOrderhd:patientDetailList){
			if(dgOrderhd.getDgOrderdts().isEmpty()){
				finalDgOrderdhList.add(dgOrderhd);
			}
			
			Set<DgOrderdt> dgOrderdts=dgOrderhd.getDgOrderdts();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					finalDgOrderdhList.add(dgOrderhd);
					break;
				}
			}
			
		}
		
		
		map.put("pharmacyLabQueueList", pharmacyLabQueueList);
		//map.put("patientDetailList", finalDgOrderdhList);
		return map;
	}*/

	//Added by Arbind on 11-04-2017
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionGrid(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
		
		List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();
		int searchFlag=0;
		Session session = (Session) getSession();
		String hinNo = "";
		Date currentDate = new Date();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String patientType = "";
		String orderStatus = "";
		String adNo = "";
		int hinId = 0;
		int subGroupId = 0;
		List<Integer> chargeCodeList=new ArrayList<Integer>(); 
		int departmentId = 0;
		Integer hospitalId = 0;
		int sampleId=0;
		int invstigationId=0; 
		Criteria crit = null;
		int tokenNo = 0;
		String doctorName = null;
		if(mapForDs.get("searchFlag")!=null){
			searchFlag=(Integer)mapForDs.get("searchFlag");
		}
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		int subChargeId=0;
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		} 
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("tokenNo") != null) {
			tokenNo = (Integer) mapForDs.get("tokenNo");
		}
		if (mapForDs.get(RequestConstants.DOCTOR_NAME) != null) {
			doctorName = (String) mapForDs.get(RequestConstants.DOCTOR_NAME);
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		List<DgMasInvestigation> masInvest=session.createCriteria(DgMasInvestigation.class)
											.add(Restrictions.eq("Sample.Id", sampleId)).list();
		for(DgMasInvestigation investigation:masInvest){
			chargeCodeList.add(investigation.getId());
		}

		}
		if (mapForDs.get("invName") != null && !mapForDs.get("invName").equals("0")) {
			String[] val=(String[])mapForDs.get("invName"); 
			if(null !=val && val.length>0){
			 	for(int i=0;i<val.length;i++){
			 		if(null !=val[i] && !val[i].equals(""))
			 			chargeCodeList.add(Integer.parseInt(val[i]));
			 	}
			}
		}
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile()))); 
		//	int department_type_id= pacProper.get("department_type_id");
			
			//List<Integer> orderDtList=new ArrayList<Integer>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
				.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase());
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
				}
			}
			
			crit = session.createCriteria(PharmacyLabQueue.class)
					.createAlias("DgOrderhdId", "dgOrderhdId")
					.createAlias("Department", "department")
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("dgOrderhdId.OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("department.Id", departmentId))
					.add(Restrictions.between("OpdDate", fromDate, toDate))
					.add(Restrictions.eq("dgOrderhdId.PatientType", patientType))
					.add(Restrictions.eq("Status", "P").ignoreCase())
					//.setProjection(Projections.projectionList().add(Projections.groupProperty("TokenNo")))
					
					.addOrder(Order.asc("OpdTime"));

			if(searchFlag==1){
				logger.info("searchFlag==1");
				crit.createAlias("Visit", "visit")
				.createAlias("visit.Hin", "hin")
				.createAlias("dgOrderhdId.PrescribedBy", "docotor",CriteriaSpecification.LEFT_JOIN);
				if(hinNo!=null && !hinNo.equals("")) {
					crit.add(Restrictions.like("hin.HinNo", "%"+hinNo+"%"));
				}
				if(subGroupId!=0) {
					crit.createAlias("dgOrderhdId.DgOrderdts", "dgorderdt")
					.createAlias("dgorderdt.SubChargeid", "subChargeId")
					.add(Restrictions.eq("subChargeId.Id",subGroupId));
				}
				if(subChargeId!=0) {
					crit.createAlias("dgOrderhdId.DgOrderdts", "dgorderdt")
					.createAlias("dgorderdt.SubChargeid", "subChargeId")
					.add(Restrictions.eq("subChargeId.Id",subChargeId));
				}
				if(patientFName != null && !patientFName.equals("")) {
					crit.add(Restrictions.like("hin.PFirstName", "%"+patientFName+"%").ignoreCase());
				}
				if(tokenNo!=0){
					crit.add(Restrictions.eq("TokenNo", tokenNo));
				}
				if(doctorName != null && !doctorName.equals("")) {
					crit.add(Restrictions.like("docotor.EmployeeName", "%"+doctorName+"%").ignoreCase());
				}
			}
			
			pharmacyLabQueueList=crit.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("pharmacyLabQueueList", pharmacyLabQueueList);
		return map;
	}

	// ---------------------------Method For get Patient Details After//
	// search--------------------------
	public Map<String, Object> getPatientDetailsSampleColletion(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();
		Session session = (Session) getSession();
		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String patientType = "";
		String adNo = "";
		int hinId = 0;
		int subGroupId = 0;
		List<Integer> chargeCodeList=new ArrayList(); 
		int departmentId = 0;
		Integer hospitalId = 0;
		int sampleId=0;
		Criteria crit = null;
		String visitNumber = null;
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		} 
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get(RequestConstants.VISIT_NUMBER) != null) {
			visitNumber = (String) mapForDs.get(RequestConstants.VISIT_NUMBER);
		}
		
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		List<DgMasInvestigation> masInvest=session.createCriteria(DgMasInvestigation.class)
											.add(Restrictions.eq("Sample.Id", sampleId)).list();
		for(DgMasInvestigation investigation:masInvest){
			chargeCodeList.add(investigation.getId());
		}

		}
		if (mapForDs.get("invName") != null) {
			String[] val=(String[])mapForDs.get("invName"); 
			 	for(int i=0;i<val.length;i++){
			 		chargeCodeList.add(Integer.parseInt(val[i]));
			 		 
			 	}

		}
		 
		try {

			if (fromDate != null && toDate != null) {
				/*crit = session
						.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions
								.between("OrderDate", fromDate, toDate))
						.createAlias("Hin", "pt").createAlias("Hospital", "oh")
						.createAlias("DgOrderdts", "detail")
						.createAlias("detail.SubChargeid", "subcharge")
						.add(Restrictions.eq("oh.Id", hospitalId))
						.add(Restrictions.ne("subcharge.SubChargecodeCode", "HIS"));*/
				crit = session.createCriteria(PharmacyLabQueue.class)
						.createAlias("DgOrderhdId", "dgOrderhdId")
						.createAlias("dgOrderhdId.Hin", "hin")
						.createAlias("Department", "department")
						.createAlias("Hospital", "oh")
						.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
						.add(Restrictions.eq("oh.Id", hospitalId))
						.add(Restrictions.eq("department.Id", departmentId))
						.add(Restrictions.between("OpdDate", fromDate, toDate))
						//.add(Restrictions.eq("dgOrderhdId.PatientType", patientType))
						.add(Restrictions.eq("Status", "P").ignoreCase())
						
						.addOrder(Order.asc("OpdTime"));
						
			} else {
				crit = session.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions
								.between("OrderDate", new Date(), toDate))
						.createAlias("Hin", "pt").createAlias("Hospital", "oh")
						.add(Restrictions.eq("oh.Id", hospitalId));
			}
			if (patientType != "") {
				crit = crit.add(Restrictions.eq("dgOrderhdId.PatientType", patientType));
			}

			if (!adNo.equals("")) {
				crit = crit.createAlias("dgOrderhdId.Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName",
						patientFName + "%").ignoreCase());
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("dgOrderhdId.SubChargeid", "subCharge");
				crit = crit.add(Restrictions.eq("subCharge.Id", subGroupId));
			}
			if (chargeCodeList.size() >0) {
				crit = crit.createAlias("detail.ChargeCode", "ch").add(
						Restrictions.in("ch.Id", chargeCodeList));
			}
			if (departmentId != 0) {
				crit = crit.createAlias("dgOrderhdId.Department", "dept").add(
						Restrictions.eq("dept.Id", departmentId));
			}
			if (visitNumber != null) {
				crit = crit.add(Restrictions.eq("dgOrderhdId.OrderNo", visitNumber));
			}
			/*if (!"".equals(doctorName)) {
				crit = crit.createAlias("PrescribedBy", "emp").add(
						Restrictions.like("emp.FirstName", doctorName + "%"));
			}*/
			/*if (mapForDs.get("priorityId") != null) { 
				crit = crit.add(Restrictions.eq("RoutineUrgentStatus",(String) mapForDs.get("priorityId")));
			}*/
			List<DgOrderhd> dgOrderhds=new ArrayList<DgOrderhd>();
			if(null !=crit && null !=crit.list())
			pharmacyLabQueueList=crit.list();
			if(null != pharmacyLabQueueList && pharmacyLabQueueList.size()>0){
				for(PharmacyLabQueue pharmacy:pharmacyLabQueueList){
					dgOrderhds.add(pharmacy.getDgOrderhdId());
				}
			}
			 //dgOrderhds= crit.list();
			Map<String,DgOrderhd> mapForList=new HashMap<String,DgOrderhd>();
			Set<String> set=new HashSet<String>();
			for(DgOrderhd dgOrderhd:dgOrderhds){
				mapForList.put(dgOrderhd.getId()+"", dgOrderhd);
				set.add(dgOrderhd.getId()+"");
			}
			
			for(String string:set){
				patientDetailList.add(mapForList.get(string));
				
			} 
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("patientDetailList", patientDetailList);
		return map;
	}

	// --------------------------- Method to submit Sample
	// Collection-----------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSampleCollection(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		final Map<String, Object> dataForSampleCollection =  new HashMap<String, Object>(); // added by amit das on 11-09-2017
		Map<DgOrderhd, Set<DgOrderdt>> orderMap = new HashMap<DgOrderhd, Set<DgOrderdt>>();  // added by amit das on 11-09-2017
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleCollectionMap = new HashMap<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>();  // added by amit das on 11-09-2017
		Set<DgOrderdt> dgOrderdts = null; // added by amit das on 11-09-2017
		Set<DgSampleCollectionDetails> collectionDetailsSet = null; // added by amit das on 11-09-2017
		
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		String diagSeqNo = "";
		String diag_no="";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTimeDBFormat();
		String currentDate1 = (String) utilMap.get("currentDate");
		// String diagSeqNo="";
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get("diagSeqNo") != null) {
			diagSeqNo = (String) parameterMap.get("diagSeqNo");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}
		MasHospital hospital = new MasHospital();
		int hinId = box.getInt(HIN_ID);
		Patient patient = new Patient();
		
		int departmentId = box.getInt(DEPARTMENT_ID);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		int orderId=0;
		String diagnosisNo = box.getString(DIAGNOSIS_NO);
		String  orderTempId =  box.get(ORDER_BOOKING_ID);
		String sss[]=orderTempId.split(",");
				
	
		List<Integer> orderListId=new ArrayList<Integer>();
		for(String s:sss){
			
			
				if(null !=s && !s.equals(""))
				orderListId.add(Integer.parseInt(s));
			
		}
		
		int collectedBy = box.getInt(EMPLOYEE_ID);
		int totalRow = box.getInt("totalRow");
  
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			DgOrderhd dgOrderhdObj=null;
			String patientType="";//added by govind 27-07-2017
			List<DgOrderhd> dgOrderhdObjList =null;
				dgOrderhdObjList=session.createCriteria(DgOrderhd.class)
						.add(Restrictions.in("Id", orderListId))
						.list();
				/*dgOrderhdObj=  hbt.load(DgOrderhd.class,
							orderId);*/
				patient = hbt.get(Patient.class, hinId);
				hospital = (MasHospital) session.get(MasHospital.class, hospitalId);// added  by amit das on 11-09-2017
				DgSampleCollectionHeader dgSampleCollectionHeaderPending=null;				
				
		for(DgOrderhd orderHd:dgOrderhdObjList){
					dgOrderhdObj=orderHd;
					orderId=orderHd.getId();
			//Added By Dhananjay 09-jan-17
			PharmacyLabQueue pharmacyLabQueue = null;
			Criteria crt=null;
				 crt= session.createCriteria(PharmacyLabQueue.class)
					.createAlias("DgOrderhdId", "dgOrderhdId")
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dgOrderhdId.Id", dgOrderhdObj.getId()))
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("Status", "P").ignoreCase());
				if(null != crt &&  null !=crt.list() && (crt.list().size())>0){
					pharmacyLabQueue=(PharmacyLabQueue) crt.list().get(0);
				}
				patientType=orderHd.getPatientType();
			// End 
				if(pharmacyLabQueue!=null || patientType.equalsIgnoreCase("IP")){
			DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Order.Id", orderId))
					.add(Restrictions.eq("Department.Id", departmentId))
					.uniqueResult();
			boolean isNotCollected = false;
			int counterForAllRejectedByEmpanelled = 0;
			List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
			Map<Integer,Boolean> sampleColId=new HashMap<Integer,Boolean>();
			String sampleBarCode="";
			//sampleBarCode=generateSampleBarcodeForLab(hospitalId);
			
			int sampleId=0;
			int colCount=0;
			Map<String,DiagParam> diagParamMap=new HashMap<String,DiagParam>();
			if(totalRow==1){
				totalRow=2;
			}
			//added by govind 24-10-2017
			HashSet<Integer> chargeSet=new HashSet<Integer>();
			//added by govind 24-10-2017 end
			String samplColIdVal="";int sampCount=0;
			for (int i = 1; i < totalRow; i++) {
				DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(DgOrderdt.class,
						box.getInt("orderDtId" + i));
				if ("Y".equalsIgnoreCase(box.get(COLLECTED_VALUE + i))) {
					colCount++;
					dgOrderdt.setOrderStatus("C");
				/*	if (dgSampleCollectionHeader == null) {

						dgSampleCollectionHeader = new DgSampleCollectionHeader();
					}*/
					if(dgSampleCollectionHeader!=null){	
						sampleBarCode=dgSampleCollectionHeader.getSampleBarCode();
						dgSampleCollectionHeaderPending=dgSampleCollectionHeader;
					}else{
						dgSampleCollectionHeader = new DgSampleCollectionHeader();
						sampleBarCode=generateSampleBarcodeForLab(hospitalId);
						dgSampleCollectionHeader.setSampleBarCode(sampleBarCode);
					if (box.getString(INPATIENT_ID) != null
							&& !box.getString(INPATIENT_ID).equals("")) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						dgSampleCollectionHeader.setInpatient(inpatient);
					}
					//dgSampleCollectionHeader.setSampleBarCode(sampleBarCode);
					dgSampleCollectionHeader.setHin(patient);
					dgSampleCollectionHeader.setHospital(hospital);
					dgSampleCollectionHeader.setOrder(dgOrderhdObj);
					dgSampleCollectionHeader.setDepartment(masDepartment);
					dgSampleCollectionHeader.setOrderStatus("P");
					dgSampleCollectionHeader.setLastChgBy(users);
					dgSampleCollectionHeader.setLastChgDate(date);
					dgSampleCollectionHeader.setLastChgTime(time);
					dgSampleCollectionHeader.setDiagnosisDate(date);
					dgSampleCollectionHeader.setDiagnosisTime(time);
					int referhospitalId=0;
					if(box.getInt("hospitalName")!=0){
						referhospitalId=box.getInt("hospitalName");
						MasHospital mh=new MasHospital();
						mh.setId(referhospitalId);
						dgSampleCollectionHeader.setReferHospital(mh);
					}
					hbt.saveOrUpdate(dgSampleCollectionHeader);
					dgSampleCollectionHeaderPending=dgSampleCollectionHeader;
					}
					int dgSampleHeaderId = dgSampleCollectionHeader.getId();
					DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) session
							.createCriteria(DgSampleCollectionDetails.class)
							.add(Restrictions.eq("SampleCollectionHeader.Id",
									dgSampleHeaderId))
							.add(Restrictions.eq("ChargeCode.Id", dgOrderdt
									.getChargeCode().getId())).uniqueResult();
					if (dgSampleCollectionDetails == null) {
						dgSampleCollectionDetails = new DgSampleCollectionDetails();
					}
					// Start Added by dhananjay kumar 05-10-2016 if sample was rejected at the time of sample validation 
					
					/*if (dgSampleCollectionDetails.getRejected() != null && dgSampleCollectionDetails.getRejected().equals("r")) {
						dgSampleCollectionDetails = new DgSampleCollectionDetails();
						
					}*/
					// commented by amit das on 03-06-2017 
					
					
					// End
					
					chargeSet.add(dgOrderdt.getSubChargeid().getId());//added by govind 24
					dgSampleCollectionDetails
							.setSampleCollectionHeader(dgSampleCollectionHeader);
					dgSampleCollectionDetails.setCollected(box
							.get(COLLECTED_VALUE + i));
					dgSampleCollectionDetails.setChargeCode(dgOrderdt
							.getChargeCode());

					dgSampleCollectionDetails.setMaincharge(dgOrderdt
							.getMainChargecode());
					dgSampleCollectionDetails.setSubcharge(dgOrderdt
							.getSubChargeid());
					if (box.get(SAMPLE_ID + i).trim() != ""
							&& box.get(SAMPLE_ID + i) != null) {
						sampleId=box.getInt(SAMPLE_ID + i);
						MasSample masSample = new MasSample();
						masSample.setId(box.getInt(SAMPLE_ID + i));
						dgSampleCollectionDetails.setSample(masSample);
					}

					if (box.get(INVESTIGATION_ID + i).trim() != ""
							&& box.get(INVESTIGATION_ID + i) != null) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(box.getInt(INVESTIGATION_ID
								+ i));
						dgSampleCollectionDetails
								.setInvestigation(dgMasInvestigation);
					}
					int containerId=0;
					if (box.get(CONTAINER + i).trim() != ""
							&& box.get(CONTAINER + i) != null) {
						DgMasCollection dgMasCollection = new DgMasCollection();
						containerId=box.getInt(CONTAINER + i);
						dgMasCollection.setId(box.getInt(CONTAINER + i));
						dgSampleCollectionDetails.setContainer(dgMasCollection);
					}
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(collectedBy);
					dgSampleCollectionDetails.setCollectedBy(masEmployee);
					if (box.get(REMARKS + i).trim() != ""
							&& box.get(REMARKS + i) != null) {
						dgSampleCollectionDetails.setRemarks(box.get(REMARKS
								+ i));
					}
					
					if(box.getInt("hospitalName")!=0){
						dgSampleCollectionDetails.setReferStatus("y");
					}else{
						dgSampleCollectionDetails.setReferStatus("n");
					} 	
					if(dgSampleCollectionDetails.getRejected()!=null){//added by govind 19-06-2017
					dgSampleCollectionDetails.setRejected(null);
					}else{
					DiagParam dgParam = null;
					List<DiagParam> listDiagParam=new ArrayList<DiagParam>();
				synchronized (this) {
					if(sampleId != 0){
					/*dgParam =(DiagParam) session
							.createCriteria(DiagParam.class).createAlias("Sample", "sample")
							.add(Restrictions.eq("SubCharge.Id", dgOrderdt
									.getSubChargeid().getId())) 
							.add(Restrictions.eq("sample.Id",sampleId))
							.add(Restrictions.eq("SeqUpdateDate",new Date()))//added by govind 19-06-2017 for reset seqno by datewise
							.add(Restrictions.eq("Hospital.Id", hospital.getId())).uniqueResult(); */
						listDiagParam =session
								.createCriteria(DiagParam.class).createAlias("Sample", "sample")
								.add(Restrictions.eq("SubCharge.Id", dgOrderdt
										.getSubChargeid().getId())) 
								.add(Restrictions.eq("sample.Id",sampleId))
								.add(Restrictions.eq("SeqUpdateDate",new Date()))//added by govind 19-06-2017 for reset seqno by datewise
								.add(Restrictions.eq("Hospital.Id", hospital.getId()))
								.addOrder(Order.desc("SeqNo"))
								.list();
						
						if(listDiagParam.size()>0){
							dgParam=(DiagParam)listDiagParam.get(0);
						}
					}/*else{
						List<DiagParam> diagList=new ArrayList<DiagParam>();
						 diagList= session
								.createCriteria(DiagParam.class)
								.add(Restrictions.eq("SubCharge.Id", dgOrderdt
										.getSubChargeid().getId())) 
								.add(Restrictions.eq("Hospital.Id", hospital.getId())).list(); 
						 
						 if(diagList!=null && diagList.size()>0){
							 dgParam=diagList.get(0); 
						 }
					}*/
				//}	 //commented by govind 10-07-2017
					
					if(dgParam==null){ 
						dgParam= new DiagParam();
						MasMainChargecode maincharge1 = new MasMainChargecode();
						maincharge1
								.setId(dgOrderdt.getMainChargecode().getId());
						dgParam.setMainCharge(maincharge1);
						MasSubChargecode subCharge1 = new MasSubChargecode();
						subCharge1.setId(dgOrderdt.getSubChargeid().getId());
						dgParam.setSubCharge(subCharge1);
						MasChargeCode msc = new MasChargeCode();
						msc.setId(dgOrderdt.getChargeCode().getId());
						dgParam.setChargeCode(msc);
						if (box.get(CONTAINER + i).trim() != ""
								&& box.get(CONTAINER + i) != null) {
							DgMasCollection dgMasCollection = new DgMasCollection();
							dgMasCollection.setId(box.getInt(CONTAINER + i));
							dgParam.setContainer(dgMasCollection);
						}
						if (box.get(SAMPLE_ID + i).trim() != ""
								&& box.get(SAMPLE_ID + i) != null) {
							sampleId=box.getInt(SAMPLE_ID + i);
							MasSample masSample = new MasSample();
							masSample.setId(box.getInt(SAMPLE_ID + i));
							dgParam.setSample(masSample);
						}
						
						dgParam.setSeqNo(1);
						dgParam.setPrefix(dgOrderdt.getSubChargeid()
								.getSubChargecodeCode().substring(0, 2));
						dgParam.setCriteria("C");
						dgParam.setLastChgDate(date);
						dgParam.setLastChgTime(time);
						dgParam.setLastChgBy(users);
						dgParam.setHospital(hospital);
						dgParam.setSeqUpdateDate(new Date());//added by govind 19-06-2017 for reset seqno by datewise
						hbt.save(dgParam); 
						dgSampleCollectionDetails.setDiagNo(""
								+ dgParam.getSeqNo()); 
						diag_no=String.valueOf(dgParam.getSeqNo());
						System.out.println(" diag_no diag_no diag_no diag_no "+diag_no);
					}else{ 
						//added by govind 10-07-2017
						List<DgSampleCollectionDetails> dgColList =session
								.createCriteria(DgSampleCollectionDetails.class)
								.add(Restrictions.eq("SampleCollectionHeader.Id",
										dgSampleHeaderId))
								.add(Restrictions.eq("Subcharge.Id",dgOrderdt.getSubChargeid().getId())).list();
						if(dgColList.size()>0){
							String diagNo=dgColList.get(0).getDiagNo();
							System.out.println("update seqNo  "+diagNo+" subchargeId "+dgOrderdt.getSubChargeid().getId()); 
							dgSampleCollectionDetails.setDiagNo(diagNo); 
							diag_no=String.valueOf(dgParam.getSeqNo());
						}else{
							System.out.println("add seqNo  "+(dgParam.getSeqNo()+1)+" subchargeId "+dgOrderdt.getSubChargeid().getId()); 
							dgParam.setSeqNo(dgParam.getSeqNo()+1);
							hbt.update(dgParam);
							diagParamMap.put(dgOrderdt.getSubChargeid().getId()+""+sampleId, dgParam);
							dgSampleCollectionDetails.setDiagNo(""+dgParam.getSeqNo()); 
							diag_no=String.valueOf(dgParam.getSeqNo());
						}
						
					/*	if(diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+sampleId)==null){
							System.out.println("seqNo ++");
							dgParam.setSeqNo(dgParam.getSeqNo()+1);
							hbt.update(dgParam);
							diagParamMap.put(dgOrderdt.getSubChargeid().getId()+""+sampleId, dgParam);
							dgSampleCollectionDetails.setDiagNo(""+dgParam.getSeqNo()); 
							diag_no=String.valueOf(dgParam.getSeqNo());
						}else{
							System.out.println("seqNo update");
							DiagParam diagParam =diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+sampleId); 
							dgSampleCollectionDetails.setDiagNo(""+diagParam.getSeqNo()); 
							diag_no=String.valueOf(dgParam.getSeqNo());
						}*/
						//added by govind 10-07-2017 end
					}
					}
					}
					dgSampleCollectionDetails.setSampleCollDatetime(date);
					dgSampleCollectionDetails.setLastChgBy(users);
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);
					dgSampleCollectionDetails.setOrderStatus("P");
					hbt.saveOrUpdate(dgSampleCollectionDetails);
					hbt.refresh(dgSampleCollectionDetails);
					
					sampleColId.put(dgSampleCollectionDetails.getId(),true);//added by govind 13-07-2017
					if(sampCount==0){
					samplColIdVal=samplColIdVal+dgSampleCollectionDetails.getId();
					}else{
						samplColIdVal=samplColIdVal+","+dgSampleCollectionDetails.getId();	
					}
					sampCount++;
				} else if ("Y".equalsIgnoreCase(box
						.get(RequestConstants.REJECTED + i))) {
					dgOrderdt.setNotApplicable("Y");
					isNotCollected = true;
				} else if ("Y".equalsIgnoreCase(box
						.get(RequestConstants.REJECTED_FROM_EMPANELLED_SCREEN
								+ i))) {
					dgOrderdt.setNotApplicable("Y");
					dgOrderdt.setOrderStatus("X");
					counterForAllRejectedByEmpanelled++;
					isNotCollected = true;
				} else {
					isNotCollected = true;
				}
				if(dgSampleCollectionHeader!=null){
					hbt.refresh(dgSampleCollectionHeader); // added by amit das on 12-08-2017
					collectionDetailsSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
					Hibernate.initialize(collectionDetailsSet);
					Hibernate.initialize(dgSampleCollectionHeader.getHin());
					Hibernate.initialize(dgSampleCollectionHeader.getOrder().getVisit());
					sampleCollectionMap.put(dgSampleCollectionHeader, collectionDetailsSet); // added by amit das on 12-08-2017
				}
			}
			
			
			
			
			if (isNotCollected) {
				if (counterForAllRejectedByEmpanelled == totalRow - 1) {
					dgOrderhdObj.setOrderStatus("X");
				} else {
					dgOrderhdObj.setOrderStatus("P");
				}

			} else {
				dgOrderhdObj.setOrderStatus("C");
			}
			
			String sampleColcond="";
			if(!samplColIdVal.equals("")){
				sampleColcond=" and scd.sample_collection_details_id in ("+samplColIdVal+")";
			}
			String query = "";
			query = "select scd.diag_no,msch.sub_chargecode_name,"
					+" case when msamp.sample_description='' then '-'" 
					+" when msamp.sample_description is null then '-'"
					+" else msamp.sample_description end as sample_description,"
					+" case when dmsc.collection_name='' then '-'"
					+" when dmsc.collection_name is null then '-'"
					+" else dmsc.collection_name end as collection_name,msch.sub_chargecode_code,me.first_name,scd.sample_coll_datetime,scd.last_chg_time,case when msamp.sample_code='' then '-' when msamp.sample_code is null then '-' else msamp.sample_code end as sample_code,hd.visit_id,hd.inpatient_id,hd.routine_urgent_status,hd.order_no, "
					+" case when dmsc.collection_code='' then '-' when dmsc.collection_code is null then '-' else dmsc.collection_code end as collection_code,"
					+" scd.sample_collection_details_id,msch.sub_chargecode_id "
					+ "	from dg_sample_collection_details scd"
					+ " left outer join  dg_sample_collection_header sch on scd.sample_collection_header_id=sch.sample_collection_header_id"
					+" left outer join  dg_orderhd hd on sch.order_id=hd.orderhd_id"
					+ " left outer join dg_mas_investigation inv on scd.investigation_id=inv.investigation_id "
					+ " left outer join mas_sub_chargecode msch on scd.subcharge=msch.sub_chargecode_id "
					+ " left outer join mas_sample msamp on inv.sample_id=msamp.sample_id "
					+ " left outer join dg_mas_collection dmsc on dmsc.collection_id=inv.collection_id "
					+ "	left outer join mas_employee me on me.employee_id=scd.collected_by"
					+ " left outer join patient pt on pt.hin_id=sch.hin_id"
					+ " left outer join mas_administrative_sex mas  on mas.administrative_sex_id=pt.sex_id"
					+ " where sch.order_id= '" + orderId + "' and scd.rejected IS NULL"+sampleColcond; 
			sampleDetails = session.createSQLQuery(query).list();
			dgOrderdts= dgOrderhdObj.getDgOrderdts();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					dgOrderhdObj.setOrderStatus("P");
					break;
				}
			}
			hbt.saveOrUpdate(dgOrderhdObj); 
			
			
			totalRow=totalRow-1;//added by govind 13-07-2017	
			System.out.println("colCount "+colCount+" tot "+totalRow);
			if(colCount==totalRow){
			// 
			if(null != pharmacyLabQueue){
			pharmacyLabQueue.setStatus("C");
			hbt.update(pharmacyLabQueue);
			}
			//
			}//added by govind 13-07-2017 end
			map.put("diag_no", diag_no);
			map.put("sampleDetails", sampleDetails);
			map.put("orderId",orderId);
			map.put("hinId", hinId); 
			map.put("sampleBarCode",sampleBarCode);

			//added by govind 12-07-2017
					int nextHinId=0,nextVisitId=0;String nextOrderNo= null;
					List<DgOrderhd> nextOrderList=session.createCriteria(DgOrderhd.class)
							.add(Restrictions.eq("OrderDate",new Date()))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
							.add(Restrictions.ne("OrderNo", dgOrderhdObj.getOrderNo()))
							.addOrder(Order.asc("Id"))
							.list();
					System.out.println("impl nextOrderList "+nextOrderList.size());
					if(nextOrderList.size()>0){
						for(DgOrderhd orderHead:nextOrderList){
							PharmacyLabQueue LabQueue = null;
							Criteria crt1=null;
								 crt1= session.createCriteria(PharmacyLabQueue.class)
									.createAlias("DgOrderhdId", "dgOrderhdId")
									.createAlias("Hospital", "hosp")
									.add(Restrictions.eq("hosp.Id", hospitalId))
									.add(Restrictions.eq("dgOrderhdId.Id", orderHead.getId()))
									.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
									.add(Restrictions.eq("Status", "P").ignoreCase());
								if(null != crt1 &&  null !=crt1.list() && (crt1.list().size())>0){
									LabQueue=(PharmacyLabQueue) crt1.list().get(0);
								}
							if(LabQueue!=null){
							nextHinId=orderHead.getHin().getId();
							nextVisitId=orderHead.getVisit().getId();
							nextOrderNo = orderHead.getOrderNo();
							break;
							}
						}					
					}
					map.put("nextHinId",nextHinId);
					map.put("nextVisitId",nextVisitId);
					map.put("nextOrderNo",nextOrderNo);
					System.out.println("impl nextVisitId "+nextVisitId+" nextHinId "+nextHinId);
					//added by govind 12-07-2017 end
					map.put("sampleColId",sampleColId);
					
					  Map<Integer,String> investIdMap=new HashMap<Integer,String>();
						
						for(Integer chargeId:chargeSet){
							String investStr="";
							String quer="select investigation_id from dg_sample_collection_details d "+
									"left outer join dg_sample_collection_header h on h.order_id="+orderId+" "+
									"where  d.last_chg_time='"+time+"' and  d.last_chg_date='"+currentDate1+"' and d.subcharge in ("+chargeId+")";
							System.out.println("invest query --"+quer);
							List<Integer> investArList=session.createSQLQuery(quer).list();
							int cou=0;
							for(Integer inv:investArList){
								if(cou==0){
								investStr=investStr+inv;
								}else{
									investStr=investStr+","+inv;
								}
								cou++;
							}
							investIdMap.put(chargeId, investStr);
						}
						System.out.println("impl investIdMap "+investIdMap.size());
						map.put("investIdMap",investIdMap);
				}
				
				Hibernate.initialize(dgOrderdts);
				Hibernate.initialize(dgOrderhdObj.getHin());
				Hibernate.initialize(dgOrderhdObj.getVisit());
				orderMap.put(dgOrderhdObj, dgOrderdts);   // added by amit das on  12-09-2017
		}
		

		//for FPS and PPBS issues start added by govind 11-01-2018
		if(dgSampleCollectionHeaderPending!=null && dgSampleCollectionHeaderPending.getSampleBarCodePending()!=null){
			if(dgSampleCollectionHeaderPending.getSampleBarCodePending().equalsIgnoreCase("P")){
			    dgSampleCollectionHeaderPending.setSampleBarCodePending("A");
				hbt.update(dgSampleCollectionHeaderPending);
			}else{
				String barPending=dgSampleCollectionHeaderPending.getSampleBarCodePending();
				char ascii=barPending.charAt(0);
				int asciToInt=(int)ascii;
				System.out.println("Current ascii "+ascii);
				asciToInt++;
			    ascii=(char)asciToInt;
				System.out.println("New ascii "+ascii);
				dgSampleCollectionHeaderPending.setSampleBarCodePending(""+ascii);
				hbt.update(dgSampleCollectionHeaderPending);
			}
		}else{
			if (dgSampleCollectionHeaderPending != null) {
				dgSampleCollectionHeaderPending.setSampleBarCodePending("P");
				hbt.update(dgSampleCollectionHeaderPending);
			}
		}
		//for FPS and PPBS issues end
	
		tx.commit();
		saved = true; 
		
		Hibernate.initialize(hospital);
		dataForSampleCollection.put("orderMap", orderMap);
		dataForSampleCollection.put("sampleMap", sampleCollectionMap);
		dataForSampleCollection.put("hospital", hospital);
		
		final MasHospital masHospital = hospital;
		
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
						sampleManipulactionToCentralServer(dataForSampleCollection,"collection");
				} 
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
						sampleManipulactionToLeanServer(dataForSampleCollection,"collection");
						
				}
			}
			
		}.start();*/
		
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			saved = false;
		}
		
		// --------------------------dgSampleCollectionDetails-------------------------------------------

		map.put("saved", saved);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSampleCollectionEmpanelled(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		MasEmpaneled masEmpaneled = null;
		// String diagSeqNo="";
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) parameterMap.get(RequestConstants.USERS);
		}
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		int hinId = box.getInt(HIN_ID);
		Patient patient = new Patient();
		patient.setId(hinId);
		int departmentId = box.getInt(DEPARTMENT_ID);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		int orderId = (Integer) box.getInt("orderId");
		int collectedBy = box.getInt(EMPLOYEE_ID);
		int totalRow = box.getInt("totalRow");

		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgOrderhd dgOrderhdObj = (DgOrderhd) hbt.load(DgOrderhd.class, orderId);
			DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) session
					.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Order.Id", orderId))
					.add(Restrictions.eq("Department.Id", departmentId)).uniqueResult();
			boolean isNotCollected = false;
			int counterForAllRejectedByEmpanelled = 0;
			List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
			Map<String, DiagParam> diagParamMap = new HashMap<String, DiagParam>();
			for (int i = 1; i < totalRow; i++) {
				DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(DgOrderdt.class, box.getInt("orderDtId" + i));
				if ("Y".equalsIgnoreCase(box.get(COLLECTED_VALUE + i))) {
					dgOrderdt.setOrderStatus("C");
					if (dgSampleCollectionHeader == null) {

						dgSampleCollectionHeader = new DgSampleCollectionHeader();
					}

					if (box.getString(INPATIENT_ID) != null && !box.getString(INPATIENT_ID).equals("")) {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						dgSampleCollectionHeader.setInpatient(inpatient);
					}

					dgSampleCollectionHeader.setHin(patient);
					dgSampleCollectionHeader.setHospital(hospital);
					dgSampleCollectionHeader.setOrder(dgOrderhdObj);
					dgSampleCollectionHeader.setDepartment(masDepartment);
					dgSampleCollectionHeader.setOrderStatus("P");
					// dgSampleCollectionHeader.setLastChgBy(users);
					dgSampleCollectionHeader.setLastChgDate(date);
					dgSampleCollectionHeader.setLastChgTime(time);
					dgSampleCollectionHeader.setDiagnosisDate(date);
					dgSampleCollectionHeader.setDiagnosisTime(time);
					int referhospitalId = 0;
					if (box.getInt("hospitalName") != 0) {
						referhospitalId = box.getInt("hospitalName");
						MasHospital mh = new MasHospital();
						mh.setId(referhospitalId);
						dgSampleCollectionHeader.setReferHospital(mh);
					}
					hbt.saveOrUpdate(dgSampleCollectionHeader);
					int dgSampleHeaderId = dgSampleCollectionHeader.getId();
					DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) session
							.createCriteria(DgSampleCollectionDetails.class)
							.add(Restrictions.eq("SampleCollectionHeader.Id", dgSampleHeaderId))
							.add(Restrictions.eq("ChargeCode.Id", dgOrderdt.getChargeCode().getId())).uniqueResult();
					if (dgSampleCollectionDetails == null) {
						dgSampleCollectionDetails = new DgSampleCollectionDetails();
					}
					dgSampleCollectionDetails.setSampleCollectionHeader(dgSampleCollectionHeader);
					dgSampleCollectionDetails.setCollected(box.get(COLLECTED_VALUE + i));
					dgSampleCollectionDetails.setChargeCode(dgOrderdt.getChargeCode());

					dgSampleCollectionDetails.setMaincharge(dgOrderdt.getMainChargecode());
					dgSampleCollectionDetails.setSubcharge(dgOrderdt.getSubChargeid());
					if (box.get(SAMPLE_ID + i).trim() != "" && box.get(SAMPLE_ID + i) != null) {
						MasSample masSample = new MasSample();
						masSample.setId(box.getInt(SAMPLE_ID + i));
						dgSampleCollectionDetails.setSample(masSample);
					}

					if (box.get(INVESTIGATION_ID + i).trim() != "" && box.get(INVESTIGATION_ID + i) != null) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(box.getInt(INVESTIGATION_ID + i));
						dgSampleCollectionDetails.setInvestigation(dgMasInvestigation);
					}
					int containerId = 0;
					if (box.get(CONTAINER + i).trim() != "" && box.get(CONTAINER + i) != null) {
						DgMasCollection dgMasCollection = new DgMasCollection();
						containerId = box.getInt(CONTAINER + i);
						dgMasCollection.setId(box.getInt(CONTAINER + i));
						dgSampleCollectionDetails.setContainer(dgMasCollection);
					}
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(collectedBy);
					// dgSampleCollectionDetails.setCollectedBy(masEmployee);
					if (box.get(REMARKS + i).trim() != "" && box.get(REMARKS + i) != null) {
						dgSampleCollectionDetails.setRemarks(box.get(REMARKS + i));
					}
					LOGGER.debug("refer status by ujjwal ------  ---- >>" + box.get("referStatus" + i));
					if (box.getInt("hospitalName") != 0) {
						dgSampleCollectionDetails.setReferStatus("y");
					} else {
						dgSampleCollectionDetails.setReferStatus("n");
					}
					DiagParam dgParam = null;
					synchronized (this) {
						LOGGER.debug("subchargeId===" + dgOrderdt.getSubChargeid().getId());
						LOGGER.debug("containerId===" + containerId);
						if (containerId != 0) {
							dgParam = (DiagParam) session.createCriteria(DiagParam.class)
									.add(Restrictions.eq("SubCharge.Id", dgOrderdt.getSubChargeid().getId()))
									.add(Restrictions.eq("Container.Id", containerId))
									.add(Restrictions.eq("Hospital.Id", hospital.getId())).uniqueResult();
						} else {
							List<DiagParam> diagList = new ArrayList<DiagParam>();
							diagList = session.createCriteria(DiagParam.class)
									.add(Restrictions.eq("SubCharge.Id", dgOrderdt.getSubChargeid().getId()))
									.add(Restrictions.eq("Hospital.Id", hospital.getId())).list();

							if (diagList != null && diagList.size() > 0) {
								dgParam = diagList.get(0);
							}
						}
					}
					if (dgParam == null) {

						dgParam = new DiagParam();
						MasMainChargecode maincharge1 = new MasMainChargecode();
						maincharge1.setId(dgOrderdt.getMainChargecode().getId());
						dgParam.setMainCharge(maincharge1);
						MasSubChargecode subCharge1 = new MasSubChargecode();
						subCharge1.setId(dgOrderdt.getSubChargeid().getId());
						dgParam.setSubCharge(subCharge1);
						MasChargeCode msc = new MasChargeCode();
						msc.setId(dgOrderdt.getChargeCode().getId());
						dgParam.setChargeCode(msc);
						if (box.get(CONTAINER + i).trim() != "" && box.get(CONTAINER + i) != null) {
							DgMasCollection dgMasCollection = new DgMasCollection();
							dgMasCollection.setId(box.getInt(CONTAINER + i));
							dgParam.setContainer(dgMasCollection);
						}

						dgParam.setSeqNo(1);
						dgParam.setPrefix(dgOrderdt.getSubChargeid().getSubChargecodeCode().substring(0, 2));
						dgParam.setCriteria("C");
						dgParam.setLastChgDate(date);
						dgParam.setLastChgTime(time);
						// dgParam.setLastChgBy(users);
						dgParam.setHospital(hospital);
						hbt.save(dgParam);
						dgSampleCollectionDetails.setDiagNo("" + dgParam.getSeqNo());
					} else {
						if (diagParamMap.get(dgOrderdt.getSubChargeid().getId() + "" + containerId) == null) {
							dgParam.setSeqNo(dgParam.getSeqNo() + 1);
							hbt.update(dgParam);
							diagParamMap.put(dgOrderdt.getSubChargeid().getId() + "" + containerId, dgParam);
							dgSampleCollectionDetails.setDiagNo("" + dgParam.getSeqNo());
						} else {

							DiagParam diagParam = diagParamMap.get(dgOrderdt.getSubChargeid().getId() + ""
									+ containerId);
							dgSampleCollectionDetails.setDiagNo("" + diagParam.getSeqNo());
						}
					}

					dgSampleCollectionDetails.setSampleCollDatetime(date);
					dgSampleCollectionDetails.setEmpaneled(masEmpaneled);
					dgSampleCollectionDetails.setEmpanelledStatus("Y");
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);
					dgSampleCollectionDetails.setOrderStatus("P");
					hbt.saveOrUpdate(dgSampleCollectionDetails);

				} else if ("Y".equalsIgnoreCase(box.get(RequestConstants.REJECTED + i))) {
					dgOrderdt.setNotApplicable("Y");
					isNotCollected = true;
				} else if ("Y".equalsIgnoreCase(box.get(RequestConstants.REJECTED_FROM_EMPANELLED_SCREEN + i))) {
					dgOrderdt.setNotApplicable("Y");
					dgOrderdt.setOrderStatus("X");
					counterForAllRejectedByEmpanelled++;
					isNotCollected = true;
				} else {
					isNotCollected = true;
				}

			}
			if (isNotCollected) {
				if (counterForAllRejectedByEmpanelled == totalRow - 1) {
					dgOrderhdObj.setOrderStatus("X");
				} else {
					dgOrderhdObj.setOrderStatus("P");
				}

			} else {
				dgOrderhdObj.setOrderStatus("C");
			}

			String query = "";

			query = "select scd.diag_no,msch.sub_chargecode_name,"
					+ " case when msamp.sample_description='' then '-'"
					+ " when msamp.sample_description is null then '-'"
					+ " else msamp.sample_description end as sample_description,"
					+ " case when dmsc.collection_name='' then '-'"
					+ " when dmsc.collection_name is null then '-'"
					+ " else dmsc.collection_name end as collection_name,msch.sub_chargecode_code,me.first_name,scd.sample_coll_datetime,scd.last_chg_time,case when msamp.sample_code='' then '-' when msamp.sample_code is null then '-' else msamp.sample_code end as sample_code,hd.visit_id,hd.inpatient_id,hd.routine_urgent_status,hd.order_no, "
					+ " case when dmsc.collection_code='' then '-' when dmsc.collection_code is null then '-' else dmsc.collection_code end as collection_code,"
					+ " scd.sample_collection_details_id "
					+ "	from dg_sample_collection_details scd"
					+ " left outer join  dg_sample_collection_header sch on scd.sample_collection_header_id=sch.sample_collection_header_id"
					+ " left outer join  dg_orderhd hd on sch.order_id=hd.orderhd_id"
					+ " left outer join dg_mas_investigation inv on scd.investigation_id=inv.investigation_id "
					+ " left outer join mas_sub_chargecode msch on scd.subcharge=msch.sub_chargecode_id "
					+ " left outer join mas_sample msamp on inv.sample_id=msamp.sample_id "
					+ " left outer join dg_mas_collection dmsc on dmsc.collection_id=inv.collection_id "
					+ "	left outer join mas_employee me on me.employee_id=scd.collected_by"
					+ " left outer join patient pt on pt.hin_id=sch.hin_id"
					+ " left outer join mas_administrative_sex mas  on mas.administrative_sex_id=pt.sex_id"
					+ " where sch.order_id= '" + orderId + "'";
			LOGGER.debug("query--->>" + query);
			sampleDetails = session.createSQLQuery(query).list();
			Set<DgOrderdt> dgOrderdts = dgOrderhdObj.getDgOrderdts();
			for (DgOrderdt dgOrderdt : dgOrderdts) {
				if ("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())) {
					dgOrderhdObj.setOrderStatus("P");
					break;
				}
			}
			hbt.saveOrUpdate(dgOrderhdObj);
			map.put("sampleDetails", sampleDetails);
			map.put("orderId", orderId);
			map.put("hinId", hinId);
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			saved = false;
		}

		// --------------------------dgSampleCollectionDetails-------------------------------------------

		map.put("saved", saved);
		return map;
	}

	// -----------------------Method For get Details on Sample Collection
	// -------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetails(Map<String, Object> orderMap) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		List<DgMasCollection> conatinerList = new ArrayList<DgMasCollection>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		int patienthinId = 0;
		int hinId = 0;
		String diagSeqNo = "";
		String orderNo="";
		Integer hospitalId = 0;
		int subchargeId = 0;
		Session session = (Session) getSession();

		// *** Added by dhananjay to get the state Id of kerala from
		// adt.properties file (26-082016) ***
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		int stateId = Integer.parseInt(properties.getProperty("stateId"));
		// end

		int deptId = 0;
		if (orderMap.get("deptId") != null) {
			deptId = (Integer) orderMap.get("deptId");
		}
		if (orderMap.get("subchargeId") != null) {
			subchargeId = (Integer) orderMap.get("subchargeId");
		}
		if (orderMap.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) orderMap.get(HOSPITAL_ID);
		}
		if (orderMap.get("orderNo") != null) {
			orderNo = (String)orderMap.get("orderNo");
		}
		try {
			collectionCenterList = session.createCriteria(DgCollectionCenter.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
			conatinerList = session.createCriteria(DgMasCollection.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (conatinerList.size() > 0) {
				detailsMap.put("conatinerList", conatinerList);
			}
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
			hospitalTypeList = session.createCriteria(MasHospitalType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("HospitalTypeName")).list();

			districtList = session.createCriteria(MasDistrict.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("State.Id", stateId)).addOrder(Order.asc("DistrictName")).list();
			hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("HospitalName")).list();
			if (orderMap != null && orderMap.size() > 0) {
				Criteria crit = session.createCriteria(DgOrderdt.class).createAlias("Orderhd", "Orderhd")
						.createAlias("Orderhd.Hin", "hin").createAlias("Orderhd.Hospital", "hospital")
						.add(Restrictions.eq("Orderhd.OrderStatus", "P"))
						.add(Restrictions.eq("hospital.Id", hospitalId))
						.add(Restrictions.eq("Orderhd.OrderNo", orderNo))
						.add(Restrictions.eq("hin.Id", (Integer) orderMap.get("orderId")));
				if (subchargeId != 0) {
					crit.createAlias("SubChargeid", "subchargeId").add(Restrictions.eq("subchargeId.Id", subchargeId));
				}
				dgOrderdtList = crit.list();
				for (DgOrderdt dt : dgOrderdtList) {
					diagSeqNo = dt.getOrderhd().getOrderNo();
					patienthinId = dt.getOrderhd().getHin().getId();
				}

			}
			if (dgOrderdtList != null && dgOrderdtList.size() > 0) {
				detailsMap.put("dgOrderdtList", dgOrderdtList);

				patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
				if (patientList != null || patientList.size() > 0) {
					detailsMap.put("patientDetailList", patientList);
				}
			}
			if (dgOrderdtList != null && dgOrderdtList.size() > 0) {
				List<Integer> chargeCode = new ArrayList<Integer>();
				for (DgOrderdt forchargeCode : dgOrderdtList) {
					chargeCode.add(forchargeCode.getChargeCode().getId());
				}
				Map<Integer, String> blockedChargeCodeMap = new HashMap<Integer, String>();
				List<MasHospitalwiseChargecode> list = new ArrayList<MasHospitalwiseChargecode>();
				if (chargeCode.size() > 0) {
					list = session
							.createCriteria(MasHospitalwiseChargecode.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.or(Restrictions.not(Restrictions.in("ChargeCode.Id", chargeCode)),
									Restrictions.eq("Blocked", "y").ignoreCase())).list();
				}
				for (MasHospitalwiseChargecode blockedChargecode : list) {
					blockedChargeCodeMap.put(blockedChargecode.getChargeCode().getId(), "Y");
				}
				detailsMap.put("blockedChargeCodeMap", blockedChargeCodeMap);
			}

			List<PatientAddress> patientAddress = new ArrayList<PatientAddress>();
			Criteria crit = session.createCriteria(PatientAddress.class).createAlias("Hin", "patient")
					.add(Restrictions.eq("patient.Id", patienthinId)).add(Restrictions.eq("AddressType.Id", 1));
			patientAddress = crit.list();
			detailsMap.put("patientAddress", patientAddress);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		detailsMap.put("diagSeqNo", diagSeqNo);
		detailsMap.put("hospitalTypeList", hospitalTypeList);
		detailsMap.put("districtList", districtList);
		detailsMap.put("hospitalList", hospitalList);
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationSearch(Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();

		int currentLabId = 0; // added by amit das on 17-07-2017

		try {

			// added by amit das on 17-07-2017
			int hospitalId = (Integer) mapForDs.get("hospitalId");
			MasHospital masHospital = (MasHospital) session.get(MasHospital.class, hospitalId);

			if (mapForDs.get("userId") != null) {
				int userId = (Integer) mapForDs.get("userId");
				Users user = (Users) session.get(Users.class, userId);

				if (user.getCurrentLab() != null)
					currentLabId = user.getCurrentLab().getId();

			}

			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("MainChargecode", "mcc")
					// .createAlias("mcc.Department", "dept")
					.add(Restrictions.eq("mcc.Id", 17)).list();
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}
			sampleList = session.createCriteria(MasSample.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			if (sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);
			}
			investigationList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("MainChargecode.Id", 17)).addOrder(Order.asc("InvestigationName")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			detailsMap.put("currentLabId", currentLabId); // added by amit das
															// on 17-07-2017
			detailsMap.put("masHospital", masHospital); // added by amit das on
														// 18-07-2017
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getPatientDetailsForValidation(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		String patientFName = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String pType = "";
		String diagNo = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		int deptId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("diagNo") != null) {
			diagNo = (String) mapForDs.get("diagNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = Integer.parseInt(mapForDs.get("subGroupId").toString());
			mapForDs.put("subGroupId", subGroupId);

		}
		String barcodetext = "";
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String) mapForDs.get("barcodetext");
			mapForDs.put("barcodetext", barcodetext);

		}

		String sampleIdSearch = null;
		if (mapForDs.get("sampleIdSearch") != null && !(mapForDs.get("sampleIdSearch").equals(""))) {
			sampleIdSearch = (String) mapForDs.get("sampleIdSearch");
		}

		int sampleId = 0;
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		List<Integer> chargeCodeList = new ArrayList<Integer>();
		if (mapForDs.get("invName") != null) {
			String[] val = (String[]) mapForDs.get("invName");
			for (int i = 0; i < val.length; i++) {
				chargeCodeList.add(Integer.parseInt(val[i]));
			}
		}
		int orderId = 0;
		if (mapForDs.get("orderId") != null) {
			orderId = (Integer) mapForDs.get("orderId");
		}
		try {
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Hin", "pt")
					.createAlias("sampleHead.Order", "o")
					.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"),
							Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
					.add(Restrictions.between("sampleHead.DiagnosisDate", fromDate, toDate))
					.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
					.add(Restrictions.isNull("Rejected"))
					// added by govind 06-07-2017
					.addOrder(Order.asc("DiagNo")).addOrder(Order.asc("sampleHead.DiagnosisDate"));
			// added by govind 06-07-2017 end

			if (!barcodetext.equals("")) {
				crit = crit.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
			}

			if (sampleIdSearch != null) {
				LOGGER.debug("sampleIdSearch " + sampleIdSearch);
				crit = crit.add(Restrictions.eq("DiagNo", sampleIdSearch));
			}

			if (!pType.equals("")) {
				crit = crit.add(Restrictions.eq("o.PatientType", pType));
			}

			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", "%" + patientFName + "%").ignoreCase());
			}
			if (deptId != 0) {
				crit = crit.createAlias("ChargeCode", "mcc").createAlias("mcc.Department", "dep")
						.add(Restrictions.eq("dep.Id", deptId));
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("Subcharge", "sc").add(Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeList.size() > 0) {
				crit = crit.createAlias("ChargeCode", "ch").add(Restrictions.in("ch.Id", chargeCodeList));
			}
			if (sampleId != 0) {
				crit = crit.createAlias("Sample", "sm").add(Restrictions.eq("sm.Id", sampleId));
			}
			if (!adNo.equals("") || !wardName.equals("")) {
				crit = crit.createAlias("sampleHead.Inpatient", "ip");
			}

			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
			}
			if (!wardName.equals("")) {
				crit = crit.createAlias("ip.Department", "dpt");
				crit = crit.add(Restrictions.eq("dpt.DepartmentName", wardName));
			}

			if (mapForDs.get("priorityId") != null) {
				crit = crit.add(Restrictions.eq("o.RoutineUrgentStatus", (String) mapForDs.get("priorityId")));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}
			crit = crit.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("SampleCollectionHeader"))
					.add(Projections.groupProperty("Subcharge"))
					// added by govind 06-07-2017
					.add(Projections.groupProperty("DiagNo")).add(Projections.groupProperty("sampleHead.Hin"))
					.add(Projections.groupProperty("sampleHead.DiagnosisDate")));
			// added by govind 06-07-2017 end

			if (barCode != 0) {
				List<Object[]> patientDeatilListByBarCode = new ArrayList<Object[]>();
				patientDeatilListByBarCode = crit.list();
				for (int i = 0; i < patientDeatilListByBarCode.size(); i++) {
					boolean flag = false;
					Set<DgSampleCollectionDetails> collectionDetails = ((DgSampleCollectionHeader) patientDeatilListByBarCode
							.get(i)[0]).getDgSampleCollectionDetails();
					for (DgSampleCollectionDetails details : collectionDetails) {
						if (barCode.toString().equals(details.getDiagNo())
								&& "P".equalsIgnoreCase(details.getOrderStatus())) {
							patientDeatilList.add(patientDeatilListByBarCode.get(i));
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
			} else {
				Set<Object[]> unique = new HashSet<Object[]>(crit.list());
				patientDeatilList.addAll(unique);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForValidationForEmpanelled(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		String patientFName = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String pType = "";
		int hinId = 0;
		int subGroupId = 0;
		int deptId = 0;
		int empanelledId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}

		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = Integer.parseInt(mapForDs.get("subGroupId").toString());
			mapForDs.put("subGroupId", subGroupId);

		}
		int sampleId = 0;
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		List<Integer> chargeCodeList = new ArrayList<Integer>();
		if (mapForDs.get("invName") != null) {
			String[] val = (String[]) mapForDs.get("invName");
			for (int i = 0; i < val.length; i++) {
				chargeCodeList.add(Integer.parseInt(val[i]));
			}
		}

		if (mapForDs.get("uid") != null) {
			empanelledId = (Integer) mapForDs.get("uid");
		}
		try {
			crit = session.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "sampleHead").createAlias("sampleHead.Hin", "pt")
					.createAlias("sampleHead.Order", "o").add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					.add(Restrictions.eq("Empaneled.Id", empanelledId)).add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.between("sampleHead.DiagnosisDate", fromDate, toDate))
					.add(Restrictions.eq("ReferStatus", "n").ignoreCase());

			if (!pType.equals("")) {
				crit = crit.add(Restrictions.eq("o.PatientType", pType));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("sampleHead.Inpatient", "ip").add(Restrictions.eq("ip.AdNo", adNo));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", "%" + patientFName + "%").ignoreCase());
			}
			if (deptId != 0) {
				crit = crit.createAlias("sampleHead.Department", "dep").add(Restrictions.eq("dep.Id", deptId));
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("Subcharge", "sc").add(Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeList.size() > 0) {
				crit = crit.createAlias("ChargeCode", "ch").add(Restrictions.in("ch.Id", chargeCodeList));
			}
			if (sampleId != 0) {
				crit = crit.createAlias("Sample", "sm").add(Restrictions.eq("sm.Id", sampleId));
			}
			if (!wardName.equals("")) {
				crit = crit.createAlias("sampleHead.Inpatient.Department", "depName").add(
						Restrictions.eq("depName.DepartmentName", wardName));
			}
			if (mapForDs.get("priorityId") != null) {
				crit = crit.add(Restrictions.eq("o.RoutineUrgentStatus", (String) mapForDs.get("priorityId")));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}
			crit = crit.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("SampleCollectionHeader"))
					.add(Projections.groupProperty("Subcharge")));

			if (barCode != 0) {
				List<Object[]> patientDeatilListByBarCode = new ArrayList<Object[]>();
				patientDeatilListByBarCode = crit.list();
				for (int i = 0; i < patientDeatilListByBarCode.size(); i++) {
					boolean flag = false;
					Set<DgSampleCollectionDetails> collectionDetails = ((DgSampleCollectionHeader) patientDeatilListByBarCode
							.get(i)[0]).getDgSampleCollectionDetails();
					for (DgSampleCollectionDetails details : collectionDetails) {
						if (barCode.toString().equals(details.getDiagNo())
								&& "P".equalsIgnoreCase(details.getOrderStatus())) {
							patientDeatilList.add(patientDeatilListByBarCode.get(i));
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
			} else {
				Set<Object[]> unique = new HashSet<Object[]>(crit.list());
				patientDeatilList.addAll(unique);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	// -----------------------Method For get Details on Sample Validation
	// -------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationDetails(Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionDetails> sampleDtList = new ArrayList<DgSampleCollectionDetails>();
		List<DgSampleCollectionHeader> sampleHeaderList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		int hinId = 0;
		int departmentId = 0;
		int hospitalId = 0;

		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");

		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");

		}
		try {
			usersList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", Integer.parseInt(mapForDs.get("uid").toString()))).list();
			if (usersList.size() > 0) {
				Users user = usersList.get(0);
				int empid = user.getEmployee().getId();
				detailsMap.put("empid", empid);
			}

			employeeCodeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			LOGGER.debug(Integer.parseInt(mapForDs.get("orderId").toString()));
			LOGGER.debug(Integer.parseInt(mapForDs.get("subChargeId").toString()));
			LOGGER.debug(hospitalId);
			LOGGER.debug(departmentId);

			if (Integer.parseInt(mapForDs.get("subChargeId").toString()) > 0) {

				sampleDtList = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.eq("SampleCollectionHeader.Id",
								Integer.parseInt(mapForDs.get("orderId").toString())))
						.add(Restrictions.eq("Subcharge.Id", Integer.parseInt(mapForDs.get("subChargeId").toString())))
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
						.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"),
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
						.createAlias("Investigation", "inv").addOrder(Order.asc("inv.InvestigationName")).list();
			}
			if (Integer.parseInt(mapForDs.get("subChargeId").toString()) == 0) {

				sampleHeaderList = session.createCriteria(DgSampleCollectionHeader.class)
						.createAlias("Department", "Dept").createAlias("Hospital", "Hosp")
						.add(Restrictions.eq("Id", Integer.parseInt(mapForDs.get("orderId").toString())))
						.add(Restrictions.eq("Hosp.Id", hospitalId)).add(Restrictions.eq("Dept.Id", departmentId))
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())

						.list();
			}

			if (sampleHeaderList != null && sampleHeaderList.size() > 0) {
				detailsMap.put("sampleHeaderList", sampleHeaderList);
			}

			patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null && patientList.size() > 0) {
				detailsMap.put("patientDeatilList", patientList);
			}
			if (sampleDtList != null && sampleDtList.size() > 0) {
				detailsMap.put("sampleDtList", sampleDtList);
			}

			Set<Integer> chargeCode = new HashSet<Integer>();
			for (DgSampleCollectionDetails forchargeCode : sampleDtList) {
				chargeCode.add(forchargeCode.getChargeCode().getId());
			}
			Map<Integer, String> blockedChargeCodeMap = new HashMap<Integer, String>();
			List<MasHospitalwiseChargecode> list = new ArrayList<MasHospitalwiseChargecode>();
			if (chargeCode.size() > 0) {
				list = session
						.createCriteria(MasHospitalwiseChargecode.class)
						.add(Restrictions.eq("Hospital.Id", Integer.parseInt(mapForDs.get(HOSPITAL_ID).toString())))
						.add(Restrictions.or(Restrictions.not(Restrictions.in("ChargeCode.Id", chargeCode)),
								Restrictions.eq("Blocked", "y").ignoreCase())).list();
			}
			for (MasHospitalwiseChargecode blockedChargecode : list) {
				blockedChargeCodeMap.put(blockedChargecode.getChargeCode().getId(), "Y");
			}
			detailsMap.put("blockedChargeCodeMap", blockedChargeCodeMap);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationDetailsForEmpanelled(Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionDetails> sampleDtList = new ArrayList<DgSampleCollectionDetails>();
		Session session = (Session) getSession();
		int hinId = 0;
		try {
			usersList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", Integer.parseInt(mapForDs.get("uid").toString()))).list();
			if (usersList.size() > 0) {
				Users user = usersList.get(0);
				int empid = user.getEmployee().getId();
				detailsMap.put("empid", empid);
			}

			employeeCodeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			/*samplehdList = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Id", orderId)).list();*/
			
			sampleDtList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",
							Integer.parseInt(mapForDs.get("orderId").toString()))) 
					.add(Restrictions.eq("Subcharge.Id", 
							Integer.parseInt(mapForDs.get("subChargeId").toString()))) 
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					//.add(Restrictions.eq("Empaneled.Id", empanelledId))
					.createAlias("Investigation", "inv")
					.addOrder(Order.asc("inv.InvestigationName")) 
					.list();
			
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null && patientList.size() > 0) {
				detailsMap.put("patientDeatilList", patientList);
			}
			if (sampleDtList != null && sampleDtList.size() > 0) {
				detailsMap.put("sampleDtList", sampleDtList);

			}
			
			//Set<DgSampleCollectionDetails> collectionDetails=samplehdList.get(0).getDgSampleCollectionDetails();
			Set<Integer> chargeCode=new HashSet<Integer>();
			for(DgSampleCollectionDetails forchargeCode:sampleDtList){
				chargeCode.add(forchargeCode.getChargeCode().getId());
			}
			Map<Integer,String> blockedChargeCodeMap=new HashMap<Integer,String>();
			List<MasHospitalwiseChargecode>list=new ArrayList<MasHospitalwiseChargecode>();
			list=session.createCriteria(MasHospitalwiseChargecode.class)
						.add(Restrictions.eq("Hospital.Id", Integer.parseInt(mapForDs.get(HOSPITAL_ID).toString())))
						.add(Restrictions.or(Restrictions.not(Restrictions.in("ChargeCode.Id", chargeCode)), Restrictions.eq("Blocked", "y").ignoreCase())) 
						.list();
			for(MasHospitalwiseChargecode blockedChargecode:list){
				blockedChargeCodeMap.put(blockedChargecode.getChargeCode().getId(), "Y");
			}
			detailsMap.put("blockedChargeCodeMap", blockedChargeCodeMap);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleValidationDetailsHisto(int orderId, int uid,
			int deptId,int hospitalId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		int hinId = 0;
		try {
			usersList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", uid)).list();
			if (usersList.size() > 0) {
				Users user = usersList.get(0);
				int empid = user.getEmployee().getId();
				detailsMap.put("empid", empid);
			}

			employeeCodeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			samplehdList = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Id", orderId)).list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientDeatilList", patientList);
			}
			if (samplehdList != null || samplehdList.size() > 0) {
				detailsMap.put("samplehdList", samplehdList);

			}
			
			Set<DgSampleCollectionDetails> collectionDetails=samplehdList.get(0).getDgSampleCollectionDetails();
			Set<Integer> chargeCode=new HashSet<Integer>();
			for(DgSampleCollectionDetails forchargeCode:collectionDetails){
				chargeCode.add(forchargeCode.getChargeCode().getId());
			}
			Map<Integer,String> blockedChargeCodeMap=new HashMap<Integer,String>();
			List<MasHospitalwiseChargecode>list=new ArrayList<MasHospitalwiseChargecode>();
			list=session.createCriteria(MasHospitalwiseChargecode.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.or(Restrictions.not(Restrictions.in("ChargeCode.Id", chargeCode)), Restrictions.eq("Blocked", "y").ignoreCase())) 
						.list();
			for(MasHospitalwiseChargecode blockedChargecode:list){
				blockedChargeCodeMap.put(blockedChargecode.getChargeCode().getId(), "Y");
			}
			detailsMap.put("blockedChargeCodeMap", blockedChargeCodeMap);
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------------Method For get SampleValidationGrid For
	// Current Date--------------------------
	public Map<String, Object> getSampleValidationGrid(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<Object[]> temppatientDeatilList = new ArrayList<Object[]>();
		
		List<DgSampleCollectionHeader> radioQueuelList = new ArrayList<DgSampleCollectionHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		int subChargeCodeId = 0; // added by amit das on 27-07-2017
		Integer hospitalId = 0;
		String patientFName = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		int hinId = 0;
		String wardName = "";
		String mobileNo = "";
		int sampleId = 0;
		
		String barcodetext="";
		
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		System.out.println("deptId "+deptId);
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		// added by amit das on 27-07-2017
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		
		
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
	
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String)mapForDs.get("barcodetext");
		} 
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		try {
			if(hospitalId>0){
				MasHospital hosp=(MasHospital)session.get(MasHospital.class, hospitalId);
				if(hosp!=null && !barcodetext.equals("")){
					barcodetext=hosp.getHospitalCode()+barcodetext;	
				}
			}
			
			List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase())
			.add(Restrictions.eq("dep.Id", deptId));
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
					
				}
			}
			
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				
				crit = session
						.createCriteria(DgSampleCollectionDetails.class) 
						.createAlias("SampleCollectionHeader", "sampleHead")
						.createAlias("sampleHead.Order", "order")
						.createAlias("ChargeCode", "mcc")
						.createAlias("mcc.Department", "dep")
						// 	.add(Restrictions.isNull("Rejected")) //commented by amit das on 03-06-2017
					 	.add(Restrictions.isNull("Rejected")) //added by govind on 19-06-2017
						.add(Restrictions.eq("sampleHead.OrderStatus", "C").ignoreCase())
						.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
						.add(Restrictions.in("order.Id", orderhdtList)) 
						.add(Restrictions.eq("dep.Id", deptId));
						
						// added by amit das on 27-07-2017 
						if(subChargeCodeId!=0)
						crit =	crit.createAlias("mcc.SubChargecode", "scc")	
						.add(Restrictions.eq("scc.Id", subChargeCodeId));
							
						
						crit = crit.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
								Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SampleCollectionHeader"))
										.add(Projections.groupProperty("Subcharge")));
				temppatientDeatilList = crit.list();
				/*crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId),Restrictions.eq("ReferHospital.Id", hospitalId)))
						.add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Order", "order")
						.add(Restrictions.in("order.Id", orderhdtList))
						.createAlias("Department", "dep")
						.add(Restrictions.eq("dep.Id", deptId));
				temppatientDeatilList=crit.list();*/
			}
			/*crit = session.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId),Restrictions.eq("ReferHospital.Id", hospitalId)))
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("DiagnosisDate", currentDate))
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.Id", deptId));
			patientDeatilList = crit.list();
			
			*/
			
			crit = session
					.createCriteria(DgSampleCollectionDetails.class) 
					.createAlias("SampleCollectionHeader", "sampleHead")
					//.createAlias("sampleHead.PharmacyLabQueueId", "pharmacyLabQueueId")
					
					.createAlias("ChargeCode", "mcc")
					.createAlias("mcc.Department", "dep")
					.createAlias("sampleHead.Hin", "pt")
					
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					// .add(Restrictions.isNull("Rejected"))   // commented by amit das on 03-06-2017
					.add(Restrictions.isNull("Rejected"))//added by govind on 19-06-2017
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
					.add(Restrictions.eq("dep.Id", deptId))
					.add(Restrictions.eq("sampleHead.DiagnosisDate", currentDate)); 
					
					
			// added by amit das on 27-07-2017 
			if(subChargeCodeId!=0)
			crit =	crit.createAlias("mcc.SubChargecode", "scc")	
					.add(Restrictions.eq("scc.Id", subChargeCodeId));
					
					
					
					crit =  crit.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
							/*.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))*/
				//	.add(Restrictions.eq("pharmacyLabQueueId.OpdDate", currentDate))
					//.add(Restrictions.eq("pharmacyLabQueueId.Status", "C"))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			
			
					if (!barcodetext.equals("")) {
						crit = crit.add(
								Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
					}
					
					
					if (!pType.equals("")) {

						crit =	crit.createAlias("sampleHead.Order", "o");
						crit = crit.add(
								Restrictions.eq("o.PatientType", pType));
					}
					
					/*
					 * if (!diagNo.equals("")) { crit =
					 * crit.add(Restrictions.eq("DiagnosisNo", diagNo)); }
					 */
					if (!adNo.equals("") || !wardName.equals("")) {
						crit = crit.createAlias("sampleHead.Inpatient", "ip");
					}
					if (!adNo.equals("")) {
						crit = crit.add(
								Restrictions.eq("ip.AdNo", adNo));
					}
					if (!wardName.equals("")) {
						crit = crit.createAlias("ip.Department", "depName").add(
								Restrictions.eq("depName.DepartmentName", wardName));
					}
					if (hinId != 0) {
						crit = crit.add(Restrictions.eq("pt.Id", hinId));
					}
					if (!hinNo.equals("")) {
						crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
					}
					if (!patientFName.equals("")) {
						crit = crit.add(Restrictions.like("pt.PFirstName","%"+patientFName+ "%").ignoreCase());
					}
					
					if (sampleId!=0) {
						crit = crit.createAlias("Sample", "sm").add(
								Restrictions.eq("sm.Id", sampleId));
					}
					
					if (mapForDs.get("priorityId") != null) { 
						crit = crit.add(Restrictions.eq("o.RoutineUrgentStatus",(String) mapForDs.get("priorityId")));
					}
					if (!mobileNo.equals("")) {
						crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
					}		
					
			
			
			patientDeatilList = crit.list();
			System.out.println("FGTR   "+patientDeatilList.size());
			List<Integer>  radioQueueIdList=new ArrayList<Integer>();
			if (patientDeatilList != null && patientDeatilList.size() > 0) { 
				
					for(int ilop=0;ilop<patientDeatilList.size();ilop++) {
					DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
					if(null !=dgSampleCollectionHeader.getPharmacyLabQueueId())
					radioQueueIdList.add(dgSampleCollectionHeader.getPharmacyLabQueueId().getId());
					}}
			if(radioQueueIdList.size()>0){
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						//.createAlias("PharmacyLabQueueId", "pharmacyLabQueueId")
						//.createCriteria(PharmacyLabQueue.class) 
						
						.createAlias("Hospital", "hosp")
						.createAlias("Department", "department")
						.add(Restrictions.not(Restrictions.in("Id", radioQueueIdList)))
						.add(Restrictions.eq("department.Id", deptId))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						//.add(Restrictions.eq("dgSampleCollectionHd.OrderStatus", "P").ignoreCase())
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
						/*.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))*/
						.add(Restrictions.eq("DiagnosisDate", currentDate))
						//.add(Restrictions.eq("pharmacyLabQueueId.Status", "C").ignoreCase())
						//.addOrder(Order.asc("pharmacyLabQueueId.OpdTime"))
						;
				radioQueuelList=crit.list();
			
				System.out.println("radioQueuelList  "+radioQueuelList.size());
			}
			/*else{
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.createAlias("Hospital", "hosp")
						.createAlias("Department", "department")
						//.createAlias("PharmacyLabQueueId", "pharmacyLabQueueId")
						//.createCriteria(PharmacyLabQueue.class) 
						
						//.createAlias("pharmacyLabQueueId.Hospital", "hosp")
						//.createAlias("pharmacyLabQueueId.Department", "department")
						.add(Restrictions.eq("department.Id", deptId))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						//.add(Restrictions.eq("dgSampleCollectionHd.OrderStatus", "P").ignoreCase())
						.add(Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))
						.add(Restrictions.eq("DiagnosisDate", currentDate))
						//.add(Restrictions.eq("pharmacyLabQueueId.Status", "c").ignoreCase())
						//.addOrder(Order.asc("pharmacyLabQueueId.OpdTime"))
						;
				radioQueuelList=crit.list();
				System.out.println("radioQueuelList Else  "+radioQueuelList.size());
			}
			*/
			System.out.println("radioQueuelList  "+radioQueuelList.size());
			System.out.println("patientDeatilList  "+patientDeatilList.size());
			
			
			if(null !=temppatientDeatilList && temppatientDeatilList.size()>0){
				patientDeatilList.addAll(temppatientDeatilList);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		map.put("radioQueuelList", radioQueuelList);
		return map;
	}
	
	public Map<String, Object> getSampleValidationGridForEmpanelled(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<Object[]> temppatientDeatilList = new ArrayList<Object[]>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		Integer hospitalId = 0;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		try {
			List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase())
			.add(Restrictions.eq("dep.Id", deptId));
			appList=crit.list();
			System.out.println("appList "+appList.size());
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
					System.out.println("@@@@@ "+appInves.getDgOrder().getOrderhd().getId());
				}
			}
			System.out.println("orderhdtList "+orderhdtList.size());
			/*if(null !=orderhdtList && orderhdtList.size()){
				
			}*/
			if(null !=orderhdtList && orderhdtList.size()>0){
				
				crit = session
						.createCriteria(DgSampleCollectionDetails.class) 
						.createAlias("SampleCollectionHeader", "sampleHead")
						.createAlias("sampleHead.Order", "order")
						.createAlias("sampleHead.Department", "dep")
						.add(Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions.in("order.Id", orderhdtList)) 
						.add(Restrictions.eq("dep.Id", deptId))
						.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
						.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
								Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SampleCollectionHeader"))
										.add(Projections.groupProperty("Subcharge")));
				temppatientDeatilList = crit.list();
				/*crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId),Restrictions.eq("ReferHospital.Id", hospitalId)))
						.add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Order", "order")
						.add(Restrictions.in("order.Id", orderhdtList))
						.createAlias("Department", "dep")
						.add(Restrictions.eq("dep.Id", deptId));
				temppatientDeatilList=crit.list();*/
			}
			/*crit = session.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.or(Restrictions.eq("Hospital.Id", hospitalId),Restrictions.eq("ReferHospital.Id", hospitalId)))
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("DiagnosisDate", currentDate))
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.Id", deptId));
			patientDeatilList = crit.list();
			*/
			crit = session
					.createCriteria(DgSampleCollectionDetails.class) 
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Department", "dep")
					.add(Restrictions.eq("OrderStatus", "P")) 
					.add(Restrictions.eq("dep.Id", deptId))
					.add(Restrictions.eq("sampleHead.DiagnosisDate", currentDate)) 
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			patientDeatilList = crit.list();
			if(null !=temppatientDeatilList && temppatientDeatilList.size()>0){
				patientDeatilList.addAll(temppatientDeatilList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	// --------------------------- Method to submit Sample
	// Acceptance-----------------------------------

	@SuppressWarnings("unchecked")
	public boolean submitSampleAcceptance(Map<String, Object> parameterMap) {
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String time = (String) utilMap.get("currentTime");
		List<DgSampleCollectionDetails> collectionDetailsList = null; // added by amit das on 03-06-2017
		List<PharmacyLabQueue> pharmacyLabQueues = null; // added by amit das on 03-06-2017
		
		final Map<String, Object> dataForSampleValidation =  new HashMap<String, Object>(); // added by amit das on 13-09-2017
		Map<DgOrderhd, Set<DgOrderdt>> orderMap = new HashMap<DgOrderhd, Set<DgOrderdt>>(); // added by amit das on 13-09-2017
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleValidationMap = new HashMap<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>(); // added by amit das on 13-09-2017
		Set<DgOrderdt> dgOrderdts = null; // added by amit das on 13-09-2017
		MasHospital hospital = null;
		
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		Box box = null;
		Users users = null;
		int hospitalId = 0;
		
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		
		// added by amit das on 13-09-2017
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (int) parameterMap.get("hospitalId");
		}
		
		int counter = box.getInt("counter");
		
		String queueStatus="C";
		
		int sampleCollectionHeaderId = (Integer) box
				.getInt("sampleCollectionHeaderId");
		// --------------------------dgSampleCollectionDetails-------------------------------------------
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			

			DgSampleCollectionHeader dgSampleCollectionHeaderObj = (DgSampleCollectionHeader) hbt
					.load(DgSampleCollectionHeader.class,
							sampleCollectionHeaderId);
			

			hospital = (MasHospital) hbt
					.load(MasHospital.class,
							hospitalId);
			
			PharmacyLabQueue pharmacyLabQueue=null;
			pharmacyLabQueue=dgSampleCollectionHeaderObj.getPharmacyLabQueueId();
			
			System.out.println("sampleCollectionHeaderId="+sampleCollectionHeaderId+" counter "+counter);
			DgOrderhd dgOrderhd = dgSampleCollectionHeaderObj.getOrder();
			boolean isAllSampleNotAccepted = false;
			int counterForAllSampleValidation = 0;
			int counterForAllSampleRejected = 0;
			for (Integer i = 1, tokenChar = 65; i < counter; i++, tokenChar++) {
				int subChargeId = Integer.parseInt(box
						.getArrayList(RequestConstants.SUB_CHARGECODE_ID).get(i-1)
						.toString());
				MasSubChargecode masSubChargeCode = (MasSubChargecode) hbt.load(
						MasSubChargecode.class, subChargeId);
				DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) hbt
						.load(DgSampleCollectionDetails.class,
								box.getInt(DG_SAMPLE_DETAIL_ID + i));
				int chargecodeId=0;
				if(box.get("chargeCodeId" + i)!=null){
					chargecodeId=box.getInt("chargeCodeId" + i);
				}
				System.out.println("sampleColId="+box.getInt(DG_SAMPLE_DETAIL_ID + i)+" chargeCodeId "+chargecodeId);
				System.out.println("orderhdId "+dgOrderhd.getId()+" chargeCodeId "+dgSampleCollectionDetails.getChargeCode().getId());
               /* DgOrderdt dgOrderdt = (DgOrderdt) session//commented by govind 06-07-2017
						.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
						/*.add(Restrictions.eq("ChargeCode.Id",
								dgSampleCollectionDetails.getChargeCode()
										.getId())).uniqueResult();*/
               // .add(Restrictions.eq("ChargeCode.Id",chargecodeId)).uniqueResult();
				
				//added by govind 20-06-2017
				List<DgOrderdt> detList=session
						.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
						.add(Restrictions.eq("ChargeCode.Id",chargecodeId)).list();
				DgOrderdt dgOrderdt=null;
				if(detList.size()>0){
					dgOrderdt=detList.get(0);
				}
				//added by govind 20-06-2017 end
				if ("Y".equalsIgnoreCase(box.get("check" + i))) {
					counterForAllSampleValidation++;
					if(dgOrderdt!=null){
					dgOrderdt.setOrderStatus("A");
					}
					dgSampleCollectionDetails.setValidated("y");
					System.out.println(masSubChargeCode
							.getSubChargecodeCode());
					if ("HIS".equalsIgnoreCase(masSubChargeCode
							.getSubChargecodeCode())) {
						DgHistoSampleCollectionDetails histoTestDetails = methodForHistopatologyTestType(
								date, time, users, tokenChar,
								dgSampleCollectionDetails);
						histoTestDetails.setOrderStatus("S");
						dgSampleCollectionDetails.setOrderStatus("S");
						hbt.save(histoTestDetails);

					} else if ("CYT".equalsIgnoreCase(masSubChargeCode
							.getSubChargecodeCode())) {
						DgHistoSampleCollectionDetails histoTestDetails = methodForHistopatologyTestType(
								date, time, users, tokenChar,
								dgSampleCollectionDetails);
						histoTestDetails.setOrderStatus("L");
						dgSampleCollectionDetails.setOrderStatus("S");
						hbt.save(histoTestDetails);

					} else {
						
						dgSampleCollectionDetails.setOrderStatus("A");
					}

				} else if ("Y".equalsIgnoreCase(box.get("check1" + i))) {
					counterForAllSampleRejected++;
					if(dgOrderdt!=null){
					dgOrderdt.setOrderStatus("P");
					}
					dgSampleCollectionDetails.setOrderStatus("P");
					dgSampleCollectionDetails.setRejected("r");
					// request for PACS order cancellation when order cancel at EHealth
					if("RADIO".equalsIgnoreCase(parameterMap.get("deptType").toString())){
						if(dgOrderdt!=null){
						final int dtId=dgOrderdt.getId();
						
						//#13- Tech Debt: Comment out the code those are related to Lean server
						/*new Thread(){
							public void run(){
								try {
									pacsOrderCancelation(dtId);
								} catch (IOException e) { 
									e.printStackTrace();
								}
							}
						}.start();*/
						}						
						
					}
					isAllSampleNotAccepted = true;
				} else {
					isAllSampleNotAccepted = true;
				}
				if (box.get(REASON + i) != null
						&& !box.get(REASON + i).equals("")) {
					dgSampleCollectionDetails.setReason(box.get(REASON + i));
				}
				if (box.get(REMARKS + i) != null
						&& !box.get(REMARKS + i).equals("")) {
					dgSampleCollectionDetails.setRemarks(box.get(REMARKS + i));
				}
				dgSampleCollectionDetails.setSampleCollDatetime(date);
				dgSampleCollectionDetails.setLabStatus("n");
				dgSampleCollectionDetails.setLastChgBy(users);
				dgSampleCollectionDetails.setLastChgDate(date);
				dgSampleCollectionDetails.setLastChgTime(time);
				try {
					hbt.update(dgSampleCollectionDetails);
					System.out.println("after update");
					hbt.refresh(dgSampleCollectionDetails);
					hbt.update(dgOrderdt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			// added by amit das on 03-06-2017
			collectionDetailsList = session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.and(Restrictions.eq("SampleCollectionHeader.Id", sampleCollectionHeaderId),Restrictions.isNotNull("Rejected"))).list();
			if(collectionDetailsList!=null && collectionDetailsList.size()>0){
				pharmacyLabQueues =	session.createCriteria(PharmacyLabQueue.class).createAlias("DgOrderhdId", "doi").add(Restrictions.eq("doi.Id",collectionDetailsList.get(0).getSampleCollectionHeader().getOrder().getId())).list();
				if(pharmacyLabQueues!=null && pharmacyLabQueues.size()>0){
					PharmacyLabQueue queue  =  pharmacyLabQueues.get(0);
					queue.setStatus("P");
					session.update(queue);
				}
				
			}
			// ended by amit das on 03-06-2017
			
			
			int employeeId = box.getInt(EMPLOYEE_ID);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				dgSampleCollectionHeaderObj.setValidatedBy(masEmployee);
			}

			dgSampleCollectionHeaderObj.setSampleValidationDate(date);
			dgSampleCollectionHeaderObj.setSampleValidationTime(time);
			dgSampleCollectionHeaderObj.setLastChgBy(users);
			dgSampleCollectionHeaderObj.setLastChgDate(date);
			dgSampleCollectionHeaderObj.setLastChgTime(time);
			String headerOrderStaus = "";
			if (isAllSampleNotAccepted) {
				dgSampleCollectionHeaderObj.setOrderStatus("P");
				
				

			} else { 
					headerOrderStaus = "A"; 
			}
			dgSampleCollectionHeaderObj.setOrderStatus(headerOrderStaus);
			if (counterForAllSampleValidation == counter - 1) {
				dgOrderhd.setOrderStatus("A");
			} else if (counterForAllSampleRejected > 0) {
				dgOrderhd.setOrderStatus("P");
			}
			/*billingForSampleCollectionDiag(dgOrderhd.getHospital().getId(),
					dgOrderhd.getHin().getId(), dgOrderhd.getHin().getHinNo(),
					users.getId(), dgOrderhd.getVisit().getId(),
					dgOrderhd.getId());*/
			Set<DgSampleCollectionDetails> dgSampleCollectionDetails=dgSampleCollectionHeaderObj.getDgSampleCollectionDetails();
			for(DgSampleCollectionDetails sampleCollectionDetails:dgSampleCollectionDetails){
				if("P".equalsIgnoreCase(sampleCollectionDetails.getOrderStatus())){
					dgSampleCollectionHeaderObj.setOrderStatus("P");
					queueStatus="P";
					break;
				}	
			}
			hbt.update(dgSampleCollectionHeaderObj);
			if(null !=pharmacyLabQueue){
			pharmacyLabQueue.setStatus(queueStatus);
			hbt.update(pharmacyLabQueue);
			}
			
			dgOrderdts = dgOrderhd.getDgOrderdts();
			Map<String,String> actualStatus=new HashMap<String,String>();
			for(DgOrderdt dgOrderdt:dgOrderdts){ 
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					actualStatus.put("P", "P");
				}
				if("C".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					actualStatus.put("C", "C");
				}
			}
			if(actualStatus.get("P")!=null){
				dgOrderhd.setOrderStatus(actualStatus.get("P"));
			}else if(actualStatus.get("C")!=null){
				dgOrderhd.setOrderStatus(actualStatus.get("C"));
			}
			hbt.update(dgOrderhd);
			
			// added by amit das on 13-09-2017
			dgOrderdts = dgOrderhd.getDgOrderdts();
			dgSampleCollectionDetails = dgSampleCollectionHeaderObj.getDgSampleCollectionDetails();
			Hibernate.initialize(dgOrderdts);
			Hibernate.initialize(dgOrderhd.getVisit());
			Hibernate.initialize(dgOrderhd.getHin());
			orderMap.put(dgOrderhd, dgOrderdts);
			
			Hibernate.initialize(dgSampleCollectionDetails);
			Hibernate.initialize(dgSampleCollectionHeaderObj.getHin());
			Hibernate.initialize(dgSampleCollectionHeaderObj.getOrder().getVisit());
			sampleValidationMap.put(dgSampleCollectionHeaderObj, dgSampleCollectionDetails);
			// ended by amit das on 13-09-2017
			
			//tx.rollback();
			tx.commit();
			updatedSuccessfully = true;
			
			Hibernate.initialize(hospital);
			dataForSampleValidation.put("orderMap", orderMap);  // added by amit das on  12-09-2017
			dataForSampleValidation.put("sampleMap", sampleValidationMap); // added by amit das on  12-09-2017
			dataForSampleValidation.put("hospital", hospital);// added by amit das on  12-09-2017
			
			final MasHospital masHospital = hospital;
			
			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*new Thread(){
				public void run(){
					if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
						
						sampleManipulactionToCentralServer(dataForSampleValidation,"validation");
					} 
					if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
						
						sampleManipulactionToLeanServer(dataForSampleValidation,"validation");
							
					}
				}
				
			}.start();*/
		
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				}
			}
			updatedSuccessfully = false;
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}
	
	@SuppressWarnings("unchecked")
	public boolean submitSampleAcceptanceForEmpanelled(Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String dateTime = (String) utilMap.get("dateTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Map<String, Object> date1 = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		boolean updatedSuccessfully = false;
		Box box = null;
		String userName = "";
		Users users = null;
		MasEmpaneled empaneled=null;
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			empaneled = (MasEmpaneled) parameterMap.get(RequestConstants.USERS);
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		int counter = box.getInt("counter");
		System.out.println(counter+"=======counter");
		
		int sampleCollectionHeaderId = (Integer) box
				.getInt("sampleCollectionHeaderId");
		Vector dgSampleCollectionDetailsId = box.getVector(DG_SAMPLE_DETAIL_ID);
		Vector reason = box.getVector(REASON);
		Vector validated = box.getVector(VALIDATED);
		Vector remarks = box.getVector(REMARKS);
		// --------------------------dgSampleCollectionDetails-------------------------------------------
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			

			DgSampleCollectionHeader dgSampleCollectionHeaderObj = (DgSampleCollectionHeader) hbt
					.load(DgSampleCollectionHeader.class,
							sampleCollectionHeaderId);

			DgOrderhd dgOrderhd = dgSampleCollectionHeaderObj.getOrder();
			boolean isAllSampleNotAccepted = false;
			int counterForAllSampleValidation = 0;
			int counterForAllSampleRejected = 0;
			for (Integer i = 1, tokenChar = 65; i < counter; i++, tokenChar++) {
				int subChargeId = Integer.parseInt(box
						.getArrayList(RequestConstants.SUB_CHARGECODE_ID).get(i-1)
						.toString());
				MasSubChargecode masSubChargeCode = (MasSubChargecode) hbt.load(
						MasSubChargecode.class, subChargeId);
				DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) hbt
						.load(DgSampleCollectionDetails.class,
								box.getInt(DG_SAMPLE_DETAIL_ID + i));
				DgOrderdt dgOrderdt = (DgOrderdt) session
						.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", dgOrderhd.getId()))
						.add(Restrictions.eq("ChargeCode.Id",
								dgSampleCollectionDetails.getChargeCode()
										.getId())).uniqueResult();
				System.out.println(box.get("check" + i));
				if ("Y".equalsIgnoreCase(box.get("check" + i))) {
					counterForAllSampleValidation++;
					dgOrderdt.setOrderStatus("A");
					dgSampleCollectionDetails.setValidated("y");
					System.out.println(masSubChargeCode
							.getSubChargecodeCode());
					if ("HIS".equalsIgnoreCase(masSubChargeCode
							.getSubChargecodeCode())) {
						DgHistoSampleCollectionDetails histoTestDetails = methodForHistopatologyTestType(
								date, time, users, tokenChar,
								dgSampleCollectionDetails);
						histoTestDetails.setOrderStatus("S");
						dgSampleCollectionDetails.setOrderStatus("S");
						hbt.save(histoTestDetails);

					} else if ("CYT".equalsIgnoreCase(masSubChargeCode
							.getSubChargecodeCode())) {
						DgHistoSampleCollectionDetails histoTestDetails = methodForHistopatologyTestType(
								date, time, users, tokenChar,
								dgSampleCollectionDetails);
						histoTestDetails.setOrderStatus("L");
						dgSampleCollectionDetails.setOrderStatus("S");
						hbt.save(histoTestDetails);

					} else {
						System.out.println("in else");
						dgSampleCollectionDetails.setOrderStatus("A");
					}

				} else if ("N".equalsIgnoreCase(box.get("check1" + i))) {
					counterForAllSampleRejected++;
					dgOrderdt.setOrderStatus("P");
					dgSampleCollectionDetails.setOrderStatus("P");
					dgSampleCollectionDetails.setRejected("r");
					// request for PACS order cancellation when order cancel at EHealth
					if("RADIO".equalsIgnoreCase(parameterMap.get("deptType").toString())){
						final int dtId=dgOrderdt.getId();
						
						//#13- Tech Debt: Comment out the code those are related to Lean server
						/*new Thread(){
							public void run(){
								try {
									pacsOrderCancelation(dtId);
								} catch (IOException e) { 
									e.printStackTrace();
								}
							}
						}.start();*/
						
						
					}
					isAllSampleNotAccepted = true;
				} else {
					isAllSampleNotAccepted = true;
				}
				if (box.get(REASON + i) != null
						&& !box.get(REASON + i).equals("")) {
					dgSampleCollectionDetails.setReason(box.get(REASON + i));
				}
				if (box.get(REMARKS + i) != null
						&& !box.get(REMARKS + i).equals("")) {
					dgSampleCollectionDetails.setRemarks(box.get(REMARKS + i));
				}
				dgSampleCollectionDetails.setSampleCollDatetime(date);
				dgSampleCollectionDetails.setLabStatus("n");
				//dgSampleCollectionDetails.setLastChgBy(users);
				dgSampleCollectionDetails.setLastChgDate(date);
				dgSampleCollectionDetails.setLastChgTime(time);
				try {
					hbt.update(dgSampleCollectionDetails);
					System.out.println("after update");
					hbt.refresh(dgSampleCollectionDetails);
					hbt.update(dgOrderdt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int employeeId = box.getInt(EMPLOYEE_ID);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				//dgSampleCollectionHeaderObj.setValidatedBy(masEmployee);
			}

			dgSampleCollectionHeaderObj.setSampleValidationDate(date);
			dgSampleCollectionHeaderObj.setSampleValidationTime(time);
			//dgSampleCollectionHeaderObj.setLastChgBy(users);
			dgSampleCollectionHeaderObj.setLastChgDate(date);
			dgSampleCollectionHeaderObj.setLastChgTime(time);
			String headerOrderStaus = "";
			if (isAllSampleNotAccepted) {
				dgSampleCollectionHeaderObj.setOrderStatus("P");

			} else { 
					headerOrderStaus = "A"; 
			}
			dgSampleCollectionHeaderObj.setOrderStatus(headerOrderStaus);
			if (counterForAllSampleValidation == counter - 1) {
				dgOrderhd.setOrderStatus("A");
			} else if (counterForAllSampleRejected > 0) {
				dgOrderhd.setOrderStatus("P");
			}
			/*billingForSampleCollectionDiag(dgOrderhd.getHospital().getId(),
					dgOrderhd.getHin().getId(), dgOrderhd.getHin().getHinNo(),
					users.getId(), dgOrderhd.getVisit().getId(),
					dgOrderhd.getId());*/
			Set<DgSampleCollectionDetails> dgSampleCollectionDetails=dgSampleCollectionHeaderObj.getDgSampleCollectionDetails();
			for(DgSampleCollectionDetails sampleCollectionDetails:dgSampleCollectionDetails){
				if("P".equalsIgnoreCase(sampleCollectionDetails.getOrderStatus())){
					dgSampleCollectionHeaderObj.setOrderStatus("P");
					break;
				}
			}
			hbt.update(dgSampleCollectionHeaderObj);
			Set<DgOrderdt> dgOrderdts=dgOrderhd.getDgOrderdts();
			Map<String,String> actualStatus=new HashMap<String,String>();
			for(DgOrderdt dgOrderdt:dgOrderdts){ 
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					actualStatus.put("P", "P");
				}
				if("C".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					actualStatus.put("C", "C");
				}
			}
			if(actualStatus.get("P")!=null){
				dgOrderhd.setOrderStatus(actualStatus.get("P"));
			}else if(actualStatus.get("C")!=null){
				dgOrderhd.setOrderStatus(actualStatus.get("C"));
			}
			hbt.update(dgOrderhd);
			//tx.rollback();
			tx.commit();
			updatedSuccessfully = true;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				}
			}
			updatedSuccessfully = false;
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}

	private DgHistoSampleCollectionDetails methodForHistopatologyTestType(
			Date date, String time, Users users, Integer tokenChar,
			DgSampleCollectionDetails dgSampleCollectionDetails) {
		DgHistoSampleCollectionDetails dgHisto = new DgHistoSampleCollectionDetails();
		dgHisto.setSampleCollectionHeader(dgSampleCollectionDetails
				.getSampleCollectionHeader());
		dgHisto.setChargeCode(dgSampleCollectionDetails.getChargeCode());
		dgHisto.setSample(dgSampleCollectionDetails.getSample());
		dgHisto.setCollected(dgSampleCollectionDetails.getCollected());
		dgHisto.setCollectedBy(dgSampleCollectionDetails.getCollectedBy());
		dgHisto.setRemarks(dgSampleCollectionDetails.getRemarks());
		if(users!=null){
			dgHisto.setLastChgBy(users);
		} 
		dgHisto.setLastChgTime(time);
		dgHisto.setLastChgDate(date);
		dgHisto.setInvestigation(dgSampleCollectionDetails.getInvestigation());
		dgHisto.setMaincharge(dgSampleCollectionDetails.getMaincharge());
		dgHisto.setSubcharge(dgSampleCollectionDetails.getSubcharge());
		dgHisto.setValidated(dgSampleCollectionDetails.getValidated());
		dgHisto.setReason(dgSampleCollectionDetails.getReason());
		dgHisto.setDiagNo(dgSampleCollectionDetails.getDiagNo());
		dgHisto.setSampleCollDatetime(dgSampleCollectionDetails
				.getSampleCollDatetime());
		dgHisto.setContainer(dgSampleCollectionDetails.getContainer());
		if(dgSampleCollectionDetails.getEmpaneled()!=null){
			dgHisto.setEmpaneled(dgSampleCollectionDetails.getEmpaneled());
			dgHisto.setEmpanelledStatus(dgSampleCollectionDetails.getEmpanelledStatus());
		}
		String orderNumber = dgSampleCollectionDetails
				.getSampleCollectionHeader().getOrder().getOrderNo();
		dgHisto.setLabStatus("N");
		dgHisto.setIdentificationNo(orderNumber + "/"
				+ Character.toChars(tokenChar)[0]);
		return dgHisto;
	}

	// ------------------------Mehod For display to Order
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String getOrderSeqForDisplay(String string) {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<DgOrderhd> seqNoList = new ArrayList<DgOrderhd>();
		String orderSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {

			seqNoList = session
					.createQuery(
							"select hd from DgOrderhd hd where hd.Id =(select max(Id) from DgOrderhd)")
					.list();
			if (seqNoList.size() > 0) {
				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd = (DgOrderhd) seqNoList.get(0);
				lastSeqNo = dgOrderhd.getOrderNo();
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			orderSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "ON"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (orderSeqNoList.size() > 0) {
				for (Integer maxOrderNo : orderSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						orderSeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						orderSeqNo = String.valueOf(1);
					}
				}
			} else {
				orderSeqNo = String.valueOf(1);
			}
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orderSeqNo;
	}

	// ------------------------Mehod For Generate to Order
	// Number-----------------
	/*
	 * @SuppressWarnings("unchecked") public String generateOrderNumber() {
	 * Map<String, Object> map = new HashMap<String, Object>(); String
	 * orderSeqNo = ""; List<TransactionSequence> orderSeqNoList = new
	 * ArrayList<TransactionSequence>(); List<DgOrderhd> seqNoList = new
	 * ArrayList<DgOrderhd>(); String lastSeqNo = ""; String lastSeqYear = "";
	 * Map<String, Object> utilMap = new HashMap<String, Object>(); utilMap =
	 * (Map) HMSUtil.getCurrentDateAndTime(); String date = (String)
	 * utilMap.get("currentDate"); String currentYear =
	 * date.substring(date.lastIndexOf("/") + 1); Session session = (Session)
	 * getSession(); seqNoList = session.createQuery(
	 * "select hd from DgOrderhd hd where hd.Id =(select max(Id) from DgOrderhd)"
	 * ).list(); if(seqNoList.size()>0){ DgOrderhd dgOrderhd = new DgOrderhd();
	 * dgOrderhd =(DgOrderhd)seqNoList.get(0); lastSeqNo =
	 * dgOrderhd.getOrderNo(); StringTokenizer str = new
	 * StringTokenizer(lastSeqNo, "/"); while (str.hasMoreTokens()) {
	 * lastSeqYear = str.nextToken();
	 * 
	 * } } else if (lastSeqYear.equals("")) { lastSeqYear = currentYear; }
	 * orderSeqNoList = session.createCriteria(TransactionSequence.class)
	 * .add(Restrictions.eq("TransactionPrefix", "ON")).list();
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * if (orderSeqNoList.size() > 0) { for (TransactionSequence
	 * transactionSequence : orderSeqNoList) { TransactionSequence obj =
	 * (TransactionSequence) orderSeqNoList .get(0); int id = obj.getId();
	 * Integer seqNo = 0;
	 * 
	 * if (currentYear.equals(lastSeqYear)) { seqNo =
	 * obj.getTransactionSequenceNumber(); } else { seqNo = 0; }
	 * TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
	 * .load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1); ++seqNo;
	 * hbt.update(transactionSequenceObj); hbt.refresh(transactionSequenceObj);
	 * orderSeqNo = seqNo.toString().concat("/")
	 * .concat(String.valueOf(lastSeqYear)); } } else if (orderSeqNoList.size()
	 * == 0) { TransactionSequence tsObj = new TransactionSequence();
	 * tsObj.setStatus("y"); tsObj.setTablename("DgOrderhd");
	 * tsObj.setTransactionPrefix("ON");
	 * tsObj.setTransactionSequenceName("Order No");
	 * tsObj.setTransactionSequenceNumber(0); tsObj.setCreatedby("admin");
	 * tsObj.setStatus("y"); hbt.save(tsObj); orderSeqNo =
	 * orderSeqNo.concat("/").concat( String.valueOf(lastSeqYear)); }
	 * 
	 * return orderSeqNo; }
	 */
	public synchronized String generateOrderNumber() {/*
													 * Map<String, Object> map =
													 * new HashMap<String,
													 * Object>();
													 * List<TransactionSequence>
													 * orderSeqNoList = new
													 * ArrayList
													 * <TransactionSequence>();
													 * Map<String, Object>
													 * utilMap = new
													 * HashMap<String,
													 * Object>(); utilMap =
													 * (Map<String, Object>)
													 * HMSUtil
													 * .getCurrentDateAndTime();
													 * String date = "";
													 * 
													 * Session session =
													 * (Session) getSession();
													 * String orderSeqNo = "";
													 * date = (String)
													 * utilMap.get
													 * ("currentDate"); String
													 * currentyear = ""; String
													 * currentYear =
													 * date.substring
													 * (date.lastIndexOf("/") +
													 * 1); String lastOrderNo =
													 * ""; String lastOrderYear
													 * = ""; int seqNo = 1;
													 * List<DgOrderhd>
													 * orderNoList = new
													 * ArrayList<DgOrderhd>();
													 * 
													 * orderNoList =
													 * session.createCriteria
													 * (DgOrderhd.class).list();
													 * for (DgOrderhd dgOrderhd
													 * : orderNoList) {
													 * lastOrderNo =
													 * dgOrderhd.getOrderNo(); }
													 * StringTokenizer str = new
													 * StringTokenizer
													 * (lastOrderNo, "/"); while
													 * (str.hasMoreTokens()) {
													 * 
													 * lastOrderYear =
													 * str.nextToken();
													 * 
													 * }
													 * 
													 * try { orderSeqNoList =
													 * session.createCriteria(
													 * TransactionSequence
													 * .class)
													 * .add(Restrictions.
													 * eq("TransactionPrefix",
													 * "ON")).list(); } catch
													 * (HibernateException e) {
													 * e.printStackTrace(); }
													 * 
													 * HibernateTemplate hbt =
													 * getHibernateTemplate();
													 * hbt.setFlushModeName(
													 * "FLUSH_EAGER");
													 * hbt.setCheckWriteOperations
													 * (false);
													 * 
													 * if (orderSeqNoList.size()
													 * > 0) { for
													 * (TransactionSequence
													 * transactionSequence :
													 * orderSeqNoList) {
													 * TransactionSequence obj =
													 * (TransactionSequence)
													 * orderSeqNoList .get(0);
													 * int id = obj.getId();
													 * String seqNoStr=obj.
													 * getTransactionSequenceNumber
													 * ().toString();
													 * lastOrderYear
													 * =obj.getMonth
													 * ().toString(); if
													 * (currentYear
													 * .equals(lastOrderYear)) {
													 * 
													 * seqNo =
													 * Integer.parseInt(seqNoStr
													 * ); } else { seqNo = 0;
													 * lastOrderYear
													 * =currentYear; }
													 * seqNo=seqNo+1;
													 * TransactionSequence
													 * transactionSequenceObj =
													 * (TransactionSequence) hbt
													 * .
													 * load(TransactionSequence.
													 * class, id);
													 * 
													 * orderSeqNo =
													 * orderSeqNo.concat
													 * (String.valueOf(seqNo));
													 * //orderSeqNo =
													 * orderSeqNo.
													 * concat("/").concat
													 * (String.
													 * valueOf(lastOrderYear));
													 * transactionSequenceObj
													 * .setTransactionSequenceNumber
													 * (
													 * Integer.parseInt(orderSeqNo
													 * ));
													 * transactionSequenceObj
													 * .setMonth
													 * (Integer.parseInt
													 * (lastOrderYear));
													 * hbt.update
													 * (transactionSequenceObj);
													 * hbt.refresh(
													 * transactionSequenceObj);
													 * 
													 * } } else if
													 * (orderSeqNoList.size() ==
													 * 0) { TransactionSequence
													 * tsObj = new
													 * TransactionSequence();
													 * tsObj.setStatus("y");
													 * tsObj
													 * .setTablename("DgOrderhd"
													 * );
													 * tsObj.setTransactionPrefix
													 * ("ON"); tsObj.
													 * setTransactionSequenceName
													 * ("Order No"); orderSeqNo
													 * =
													 * orderSeqNo.concat(String
													 * .valueOf(seqNo));
													 * //orderSeqNo =
													 * orderSeqNo.
													 * concat("/").concat
													 * (String.
													 * valueOf(currentYear));
													 * lastOrderYear
													 * =currentYear; tsObj.
													 * setTransactionSequenceNumber
													 * (
													 * Integer.parseInt(orderSeqNo
													 * ));
													 * tsObj.setMonth(Integer
													 * .parseInt(currentYear));
													 * hbt.save(tsObj); }
													 * orderSeqNo =
													 * orderSeqNo.concat
													 * ("/").concat
													 * (String.valueOf
													 * (lastOrderYear)); return
													 * orderSeqNo;
													 */

		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";

		Session session = (Session) getSession();
		String orderSeqNo = "";
		date = (String) utilMap.get("currentDate");
		String currentyear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		String lastOrderNo = "";
		String lastOrderYear = "";
		int seqNo = 1;
		List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		/*
		 * orderNoList = session.createCriteria(DgOrderhd.class).list(); for
		 * (DgOrderhd dgOrderhd : orderNoList) { lastOrderNo =
		 * dgOrderhd.getOrderNo(); } StringTokenizer str = new
		 * StringTokenizer(lastOrderNo, "/"); while (str.hasMoreTokens()) {
		 * 
		 * lastOrderYear = str.nextToken();
		 * 
		 * }
		 */
		try {
			orderSeqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "ON")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				String seqNoStr = obj.getTransactionSequenceNumber().toString();

				lastOrderYear = obj.getMonth().toString();
				if (currentYear.equals(lastOrderYear)) {

					seqNo = Integer.parseInt(seqNoStr);
				} else {
					seqNo = 0;
					lastOrderYear = currentYear;
				}

				seqNo = seqNo + 1;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);

				// orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
				// orderSeqNo =
				// orderSeqNo.concat("/").concat(String.valueOf(lastOrderYear));
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				transactionSequenceObj
						.setMonth(Integer.parseInt(lastOrderYear));
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);

			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgOrderhd");
			tsObj.setTransactionPrefix("ON");
			tsObj.setTransactionSequenceName("Order No");
			orderSeqNo = orderSeqNo.concat(String.valueOf(seqNo));
			// orderSeqNo =
			// orderSeqNo.concat("/").concat(String.valueOf(currentYear));
			lastOrderYear = currentYear;
			tsObj.setTransactionSequenceNumber(Integer.parseInt(orderSeqNo));
			tsObj.setMonth(Integer.parseInt(currentYear));
			hbt.save(tsObj);
		}
		orderSeqNo = "" + seqNo;
		orderSeqNo = orderSeqNo.concat("/").concat(
				String.valueOf(lastOrderYear));
		return orderSeqNo;
	}

	// ------------------------Mehod For display to Diagnosis
	// Number-----------------
	public String getDiagSeqForDisplay(String string, int hinId) {

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<Integer> diagSeqNoList = new ArrayList<Integer>();
		List<DiagParam> diagParamList = new ArrayList<DiagParam>();
		List<DgOrderhd> sampleList = new ArrayList<DgOrderhd>();
		DiagParam diagParam = new DiagParam();
		Session session = (Session) getSession();
		int maxDiagNo = 0;
		int subChargeId = 0;
		String diagSeqNo = "";
		String date = "";
		String seqNo = "";
		String criteria = "";
		String subChargeCode = "";
		String month = "";
		String year = "";
		date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		List diagNoList = null;

		List<DgSampleCollectionHeader> sampleCollList = new ArrayList<DgSampleCollectionHeader>();
		sampleCollList = session.createCriteria(DgSampleCollectionHeader.class)
				.createAlias("Hin", "P").add(Restrictions.eq("P.Id", hinId))
				.add(Restrictions.eq("OrderStatus", "P")).list();

		Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = sampleCollList
				.get(0).getDgSampleCollectionDetails();

		int subChargeCodeId = 0;
		for (Iterator iterator = dgSampleCollectionDetailsSet.iterator(); iterator
				.hasNext();) {
			DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) iterator
					.next();
			subChargeCodeId = dgSampleCollectionDetails.getChargeCode()
					.getSubChargecode().getId();
			try {

				// diagSeqNoList =
				// session.createCriteria(TransactionSequence.class)
				// .add(Restrictions.eq("TransactionPrefix", "DN"))
				// .setProjection(
				// Projections.projectionList().add(
				// Projections
				// .max("TransactionSequenceNumber")))
				// .list();
				try {
					// parameterList =
					// session.createCriteria(MasParameter.class).add(
					// Restrictions.eq("Status", "y")).list();
					diagParamList = session.createCriteria(DiagParam.class)
							.createAlias("SubCharge", "charge")
							.add(Restrictions.eq("charge.Id", subChargeCodeId))
							.add(Restrictions.eq("Status", "y")).list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}

				if (diagParamList != null) {
					diagParam = diagParamList.get(0);
					subChargeCode = diagParam.getSubCharge()
							.getSubChargecodeCode();
					criteria = diagParam.getCriteria();

					if (criteria.equalsIgnoreCase("c")) {

						maxDiagNo = diagParam.getSeqNo();
						seqNo = String.valueOf(maxDiagNo + 1);
						diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo));
						subChargeId = diagParam.getSubCharge().getId();
						if (subChargeId != 0) {
							diagSeqNo = diagSeqNo.concat("/").concat(
									subChargeCode);
						}
						diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
						diagSeqNo = diagSeqNo.concat("/").concat(currentYear);
					}
					if (criteria.equalsIgnoreCase("m")) {
						// diagSeqNo =
						// diagSeqNo.concat("/").concat(currentMonth);
					}
					if (criteria.equalsIgnoreCase("y")) {
						// diagSeqNo =
						// diagSeqNo.concat("/").concat(currentYear);
					}

					// else {
					// diagSeqNo = String.valueOf(1);
					// }
					// subChargeId = diagParam.getSubCharge().getId();
					// if (subChargeId != 0) {
					// diagSeqNo = diagSeqNo.concat("/").concat(subChargeCode);
					// }
					// //serviceStatusId = diagParam.getServiceStatus().getId();
					// if (serviceStatusId != 0) {
					// diagSeqNo =
					// diagSeqNo.concat("/").concat(serviceStatusCode);
					// }
					// diagSeqNo = diagSeqNo.concat("/").concat(currentMonth);
					// diagSeqNo = diagSeqNo.concat("/").concat(currentYear);

				} else {
					diagSeqNo = String.valueOf(1);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
		return diagSeqNo;
	}

	@SuppressWarnings("unchecked")
	public String generateDiagNumber(int subChargeId) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
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

		dgDetailsList = session.createCriteria(DgSampleCollectionDetails.class)
				.list();
		String lastDiagNo = "";
		if (dgDetailsList.size() > 0) {
			for (DgSampleCollectionDetails collDetails : dgDetailsList) {
				lastDiagNo = collDetails.getDiagNo();
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
					if (str.hasMoreTokens()) {
						lastMnt = str.nextToken();
					}
					if (str.hasMoreTokens()) {
						lastYr = str.nextToken();
					}
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
					if (str.hasMoreTokens()) {
						lastYr = str.nextToken();
					}
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

	// ------------------------Mehod For display to Sample
	// Number-----------------
	@SuppressWarnings("unchecked")
	public String getSampleSeqForDisplay(String string) {
		List<Integer> sampleSeqNoList = new ArrayList<Integer>();
		List<DgSampleCollectionDetails> seqNoList = new ArrayList<DgSampleCollectionDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String sampleSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(DgSampleCollectionDetails.class)
					.list();
			if (seqNoList.size() > 0) {

				/*
				 * for (DgSampleCollectionDetails dgSampleCollectionDetails :
				 * seqNoList) { lastSeqNo =
				 * dgSampleCollectionDetails.getSampleNo(); }
				 */
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			sampleSeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", string))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (sampleSeqNoList.size() > 0) {
				for (Integer maxSampleNo : sampleSeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						sampleSeqNo = String.valueOf(maxSampleNo + 1);
					} else {
						sampleSeqNo = String.valueOf(1);
					}
				}
			} else {
				sampleSeqNo = String.valueOf(1);
			}
			sampleSeqNo = sampleSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return sampleSeqNo;
	}

	// ------------------------Mehod For generate to Sample
	// Number-----------------
	public String generateSampleNumber() {
		String sampleSeqNo = "";
		List<TransactionSequence> sampleList = new ArrayList<TransactionSequence>();
		List<DgSampleCollectionDetails> seqNoList = new ArrayList<DgSampleCollectionDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		String lastSeqNo = "";
		String lastSeqYear = "";
		seqNoList = session.createCriteria(DgSampleCollectionDetails.class)
				.list();
		if (seqNoList.size() > 0) {
			/*
			 * for (DgSampleCollectionDetails dgSampleCollectionDetails :
			 * seqNoList) { lastSeqNo = dgSampleCollectionDetails.getSampleNo();
			 * }
			 */
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();
			}
		}
		try {
			sampleList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "SN")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (sampleList.size() > 0) {
			for (TransactionSequence transactionSequence : sampleList) {
				TransactionSequence obj = (TransactionSequence) sampleList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				sampleSeqNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (sampleList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgSampleCollectionDetails");
			tsObj.setTransactionPrefix("SN");
			tsObj.setTransactionSequenceName("Sample No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			sampleSeqNo = sampleSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}
		return sampleSeqNo;
	}

	// ------------------------Mehod For Generate to Diagnosis
	// Number-----------------
	/*
	 * @SuppressWarnings("unchecked") public String generateDiagNumber(int
	 * subChargeId) {
	 * 
	 * Map<String, Object> utilMap = new HashMap<String, Object>(); utilMap =
	 * (Map<String, Object>) HMSUtil.getCurrentDateAndTime(); List<DiagParam>
	 * diagParamList = new ArrayList<DiagParam>(); Session session = (Session)
	 * getSession(); String diagSeqNo = ""; String date = ""; String
	 * subChargeCode = ""; date = (String) utilMap.get("currentDate"); String
	 * criteria = ""; String currentMonth = date.substring(date.indexOf("/") +
	 * 1, date.lastIndexOf("/")); String currentYear =
	 * date.substring(date.lastIndexOf("/") + 1); List<DgSampleCollectionHeader>
	 * sampleCollList=new ArrayList<DgSampleCollectionHeader>(); try {
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * diagParamList =
	 * session.createCriteria(DiagParam.class).createAlias("SubCharge",
	 * "charge") .add(Restrictions.eq("charge.Id",
	 * subChargeId)).add(Restrictions.eq("Status", "y")).list(); if
	 * (diagParamList.size() > 0) { DiagParam
	 * diagParam=(DiagParam)diagParamList.get(0); criteria =
	 * diagParam.getCriteria(); if(criteria.equals("c")) { int seqNo =
	 * diagParam.getSeqNo(); DiagParam diagParamobj
	 * =(DiagParam)hbt.load(DiagParam.class, diagParam.getId());
	 * diagParamobj.setSeqNo((seqNo+1)); hbt.update(diagParamobj); subChargeCode
	 * = diagParam.getSubCharge().getSubChargecodeCode();
	 * 
	 * diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo+1)); diagSeqNo =
	 * diagSeqNo.concat("/").concat(subChargeCode); //diagSeqNo =
	 * diagSeqNo.concat("/").concat(serviceStatusCode); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentMonth); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentYear); } if(criteria.equals("m")) {
	 * int seqNo = diagParam.getSeqNo(); Date now = new Date(); Calendar today =
	 * Calendar.getInstance(); //today.setTime(now);
	 * 
	 * boolean mnthchnged=false; if((mnthchnged==false) &&
	 * (today.get(Calendar.DATE)==1 ) && seqNo!=1){ seqNo=0; mnthchnged=true; }
	 * else{ seqNo = diagParam.getSeqNo(); } if((mnthchnged==true) &&
	 * (today.get(Calendar.DATE)!=1)) { mnthchnged=false; } DiagParam
	 * diagParamobj =(DiagParam)hbt.load(DiagParam.class, diagParam.getId());
	 * diagParamobj.setSeqNo((seqNo+1)); hbt.update(diagParamobj); subChargeCode
	 * = diagParam.getSubCharge().getSubChargecodeCode(); diagSeqNo =
	 * diagSeqNo.concat(String.valueOf(seqNo+1)); diagSeqNo =
	 * diagSeqNo.concat("/").concat(subChargeCode); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentMonth); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentYear); } if(criteria.equals("y")) {
	 * int seqNo = diagParam.getSeqNo(); Calendar today =
	 * Calendar.getInstance(); boolean yrChangd=false; if((yrChangd==false) &&
	 * (today.MONTH==Calendar.JANUARY) && (today.DAY_OF_MONTH==1)&& seqNo!=1) {
	 * seqNo=0; yrChangd=true; } else{ seqNo = diagParam.getSeqNo(); }
	 * if((yrChangd==false) && (today.DAY_OF_MONTH!=1)) { yrChangd=false; }
	 * 
	 * DiagParam diagParamobj =(DiagParam)hbt.load(DiagParam.class,
	 * diagParam.getId()); diagParamobj.setSeqNo((seqNo+1));
	 * hbt.update(diagParamobj); subChargeCode =
	 * diagParam.getSubCharge().getSubChargecodeCode(); diagSeqNo =
	 * diagSeqNo.concat(String.valueOf(seqNo+1)); diagSeqNo =
	 * diagSeqNo.concat("/").concat(subChargeCode); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentMonth); diagSeqNo =
	 * diagSeqNo.concat("/").concat(currentYear); } } else if
	 * (diagParamList.size() == 0) { }
	 * 
	 * }catch (RuntimeException e) { e.printStackTrace(); } return diagSeqNo; }
	 */

	// ------------------------------------------Report's
	// Screen------------------------------------
	// ------------------------------DiagnosticRegister---------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosticRegisterJsp(Map<String, Object> map) { 
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = null;
		List<MasAdministrativeSex> sexList = null;
		List<MasMaritalStatus> maritalStatusList = null;
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		int hospitalId = 0;
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties
				.getProperty("empCategoryCodeForDoctor");

		try {
			/*
			 * subChargeCodeList =
			 * session.createCriteria(MasSubChargecode.class)
			 * .add(Restrictions.eq("Status", "y")).createAlias(
			 * "MainChargecode", "mcc").createAlias( "mcc.Department",
			 * "dep").add( Restrictions.eq("dep.Id", deptId)).list();
			 * departmentList = session.createCriteria(MasDepartment.class).add(
			 * Restrictions.eq("Status", "y")).list();
			 */

			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			departmentList = session
					.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeCode", "DIAG")
							.ignoreCase()).list();
			chargeCodeList = session
					.createCriteria(DgMasInvestigation.class)
					.createAlias("SubChargecode", "sc")
					.createAlias("MainChargecode", "mcc")
					.createAlias("mcc.Department", "d")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(
							Projections
									.projectionList()
									.add(Projections.property("Id"))
									.add(Projections
											.property("InvestigationName"))
									.add(Projections.property("d.Id"))
									.add(Projections.property("sc.Id")))
					.addOrder(Order.asc("InvestigationName")).list();

			maritalStatusList = session.createCriteria(MasMaritalStatus.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("MaritalStatusName")).list();
			employeeList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("EmpCategory", "ec")
					.add(Restrictions.eq("ec.EmpCategoryCode",
							empCategoryCodeForDoctor))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("FirstName")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("AdministrativeSexName")).list();
			map.put("maritalStatusList", maritalStatusList);
			map.put("employeeList", employeeList);
			map.put("sexList", sexList);
			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			if (departmentList.size() > 0) {
				map.put("departmentList", departmentList);
			}
			map.put("chargeCodeList", chargeCodeList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// -----------------------------DiagnosticRegisterDoctorWise--------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showDiagnosticRegisterDoctorWise(
			Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		Integer hospitalId = (Integer) map.get(HOSPITAL_ID);
		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("MainChargecode", "mcc")
					.createAlias("mcc.Department", "dep")
					.add(Restrictions.eq("dep.Id", deptId)).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			if (employeeList.size() > 0) {
				map.put("employeeList", employeeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// ---------------------------DiagnosticRegisterTestWise----------------------------
	public Map<String, Object> showDiagnosticRegisterDiagnosisWise(
			Map<String, Object> map) {
		Session session = (Session) getSession();

		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("MainChargecode", "mcc")
					.createAlias("mcc.Department", "dep")
					.add(Restrictions.eq("dep.Id", deptId)).list();
			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}
			chargeCodeList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (chargeCodeList.size() > 0) {
				map.put("chargeCodeList", chargeCodeList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// ------------------------------------------Packing list
	// --------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPackingListJsp() {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		try {
			List lst = new ArrayList();
			lst.add("DIAG");
			lst.add("RADIO");

			mainChargeCodeList = session
					.createCriteria(MasMainChargecode.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("Department", "dept")
					.createAlias("dept.DepartmentType", "dt")
					.add(Restrictions.in("dt.DepartmentTypeCode", lst)).list();

			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y")).list();
			collectionCenterList = session
					.createCriteria(DgCollectionCenter.class)
					.add(Restrictions.eq("Status", "y")).list();

			if (mainChargeCodeList.size() > 0) {
				detailsMap.put("mainChargeCodeList", mainChargeCodeList);
			}
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ----------------------------Department Wise
	// Summary-----------------------------------
	public Map<String, Object> showDepartmentWiseSummary() {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		try {

			collectionCenterList = session
					.createCriteria(DgCollectionCenter.class)
					.add(Restrictions.eq("Status", "y")).list();

			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// -----------------------------Patient Details For Sample
	// Collection---------------------------------

	public Map<String, Object> getPatientDetailsForSampleCollection(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		crit = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("ResultStatus", "P"))
				.add(Restrictions.between("ResultDate", fromDate, toDate))
				.createAlias("Patient", "pt");

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName+ "%").ignoreCase());
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		map.put("patientList", patientList);
		return map;
	}

	// --------NextPatient--------- For Sample Collection
	public Map<String, Object> getSampleCollectionDetailsForNext(int newOrderId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int orderDetailId = 0;
		int orderHeaderId = 0;
		Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y")).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			collectionCenterList = session
					.createCriteria(DgCollectionCenter.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					// .add(Restrictions.isNotNull("Collection"))
					.add(Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			dgOrderhdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("Id", newOrderId))
					.addOrder(Order.asc("Id")).list();

			if (dgOrderhdList != null || dgOrderhdList.size() > 0) {

				detailsMap.put("dgOrderhdList", dgOrderhdList);
			}
			/*
			 * if (dgOrderhdList.size() > 0) { for (DgOrderhd dgOrderhd :
			 * dgOrderhdList) { dgOrderdtSet = dgOrderhd.getDgOrderdts();
			 * orderHeaderId = dgOrderhd.getId();
			 * 
			 * } }
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// ---------------------NextPatient For Sample Validation-------------------
	public Map<String, Object> getSampleValidationDetailsForNext(int newSampleId,int OrderId) {//changed by govind 3-11-2016
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int sampleDetailId = 0;
		int sampleHeaderId = 0;
		Set<DgSampleCollectionDetails> dgsampleValidationSet = new HashSet<DgSampleCollectionDetails>();
		List<DgSampleCollectionDetails> sampleDtList = new ArrayList<DgSampleCollectionDetails>();

		try {
			employeeCodeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y")).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					// .add(Restrictions.isNotNull("Collection"))
					.add(Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			samplehdList = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Id", newSampleId))
					.addOrder(Order.asc("Id")).list();
			System.out.println("samplehdList "+samplehdList.size());
			if (samplehdList != null || samplehdList.size() > 0) {

				detailsMap.put("samplehdList", samplehdList);
			}
			if (samplehdList.size() > 0) {
				for (DgSampleCollectionHeader dgSampleHeader : samplehdList) {
					dgsampleValidationSet = dgSampleHeader
							.getDgSampleCollectionDetails();
					DgSampleCollectionDetails smp=dgsampleValidationSet.iterator().next();		
					sampleHeaderId = dgSampleHeader.getId();

				}
			}
			System.out.println("old sampleDtList "+sampleDtList.size());
			//added by govind 3-11-2016
			sampleDtList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",newSampleId))
					.add(Restrictions.eq("Subcharge.Id",OrderId))
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
					.createAlias("Investigation", "inv")
					.add(Restrictions.eq("LastChgDate", new Date()))
					.addOrder(Order.asc("inv.InvestigationName")) 
					.list();
			//added by govind 3-11-2016 end 
			System.out.println("sampleDtList "+sampleDtList.size());
			 //added by govind 2-11-2016
			if(sampleDtList.size()>0){
			detailsMap.put("sampleDtList", sampleDtList);
			} //added by govind 2-11-2016 end
			else{
				System.out.println("sampleDtList else part OrderId "+OrderId);
				sampleDtList = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.eq("Subcharge.Id",OrderId))
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase()) 
						.add(Restrictions.eq("LastChgDate", new Date()))
						.list();
				System.out.println("else part 1 sampleDtList size "+sampleDtList.size());
				if(sampleDtList.size()>0){
					DgSampleCollectionDetails col=sampleDtList.get(0);
					newSampleId=col.getSampleCollectionHeader().getId();
					OrderId=col.getSubcharge().getId();
					sampleDtList = session
							.createCriteria(DgSampleCollectionDetails.class)
							.add(Restrictions.eq("SampleCollectionHeader.Id",newSampleId))
							.add(Restrictions.eq("Subcharge.Id",OrderId))
							.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
							.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
										Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
							.createAlias("Investigation", "inv")
							.add(Restrictions.eq("LastChgDate", new Date()))
							.addOrder(Order.asc("inv.InvestigationName")) 
							.list();
					System.out.println("else part 2 sampleDtList size "+sampleDtList.size());
					detailsMap.put("sampleDtList", sampleDtList);
					detailsMap.put("copySampleId", newSampleId);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// --------------------Method For Connction of
	// Reports-------------------------
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	/*
	 * public String getOrderSeqForDisplay(String string) { // TODO
	 * Auto-generated method stub return null; }
	 */

	/*
	 * public Map<String, Object> getDetailsForSample() { Map<String , Object>
	 * map = new HashMap<String, Object>(); List<MasSubChargecode>
	 * subChargeCodeList = new ArrayList<MasSubChargecode>();
	 * List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	 * 
	 * Session session = (Session)getSession();
	 * 
	 * try { subChargeCodeList =
	 * session.createCriteria(MasSubChargecode.class).add
	 * (Restrictions.eq("Status", "y")).list(); chargeCodeList =
	 * session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Status",
	 * "y")).list(); map.put("subChargeCodeList", subChargeCodeList);
	 * map.put("chargeCodeList", chargeCodeList); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return map; }
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<Patient> getHinNo(String
	 * serviceNo) { List<Patient> hinNoList = new ArrayList<Patient>(); Session
	 * session = (Session)getSession(); try { hinNoList =
	 * session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo",
	 * serviceNo)).list(); } catch (HibernateException e) { e.printStackTrace();
	 * } return hinNoList; }
	 */

	/*
	 * public String generateDiagNumber() { Map<String, Object>map = new
	 * HashMap<String, Object>(); List<TransactionSequence> diagSeqNoList = new
	 * ArrayList<TransactionSequence>(); Map<String, Object>utilMap = new
	 * HashMap<String, Object>(); utilMap = (Map<String,
	 * Object>)HMSUtil.getCurrentDateAndTime();
	 * 
	 * Session session = (Session) getSession(); String date = ""; date =
	 * (String)utilMap.get("currentDate"); String diagSeqNo = "";
	 * 
	 * try{ diagSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add
	 * (Restrictions.eq("TransactionPrefix", "DN")).list();
	 * 
	 * }catch(HibernateException e){ e.printStackTrace(); }
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * if(diagSeqNoList.size() > 0 ){ for (TransactionSequence
	 * transactionSequence : diagSeqNoList) { TransactionSequence obj =
	 * (TransactionSequence)diagSeqNoList.get(0); int id = obj.getId(); int
	 * seqNo = obj.getTransactionSequenceNumber();
	 * 
	 * TransactionSequence transactionSequenceObj =
	 * (TransactionSequence)hbt.load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
	 * hbt.update(transactionSequenceObj);
	 * 
	 * diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo)).concat("/"); date =
	 * date.substring(3, date.length()); diagSeqNo = diagSeqNo.concat(date); }
	 * }else if(diagSeqNoList.size() == 0){ TransactionSequence tsObj = new
	 * TransactionSequence(); tsObj.setStatus("y");
	 * tsObj.setTablename("DgSampleCollectionDetails");
	 * tsObj.setTransactionPrefix("DN"); tsObj.setTransactionSequenceName("Diag
	 * No"); tsObj.setTransactionSequenceNumber(0);
	 * 
	 * hbt.save(tsObj); } return diagSeqNo; }
	 */
	/*
	 * private String generateDiagNumber(String string) { Map<String, Object>map
	 * = new HashMap<String, Object>(); List<TransactionSequence> diagSeqNoList
	 * = new ArrayList<TransactionSequence>(); Map<String, Object>utilMap = new
	 * HashMap<String, Object>(); utilMap = (Map<String,
	 * Object>)HMSUtil.getCurrentDateAndTime();
	 * 
	 * Session session = (Session) getSession(); String date = ""; date =
	 * (String)utilMap.get("currentDate"); String diagSeqNo = "";
	 * 
	 * try{ diagSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add
	 * (Restrictions.eq("TransactionPrefix", "DN")).list();
	 * }catch(HibernateException e){ e.printStackTrace(); }
	 * 
	 * HibernateTemplate hbt = getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * 
	 * if(diagSeqNoList.size() > 0 ){ for (TransactionSequence
	 * transactionSequence : diagSeqNoList) { TransactionSequence obj =
	 * (TransactionSequence)diagSeqNoList.get(0); int id = obj.getId(); int
	 * seqNo = obj.getTransactionSequenceNumber();
	 * 
	 * TransactionSequence transactionSequenceObj =
	 * (TransactionSequence)hbt.load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
	 * hbt.update(transactionSequenceObj);
	 * 
	 * diagSeqNo = diagSeqNo.concat(String.valueOf(seqNo)).concat("/"); date =
	 * date.substring(3, date.length()); diagSeqNo = diagSeqNo.concat(date);
	 * if(diagSeqNoList.size() == 0){ TransactionSequence tsObj = new
	 * TransactionSequence(); tsObj.setStatus("y");
	 * tsObj.setTablename("DgSampleCollectionDetails");
	 * tsObj.setTransactionPrefix("DN"); tsObj.setTransactionSequenceName("Diag
	 * No"); tsObj.setTransactionSequenceNumber(0);
	 * 
	 * hbt.save(tsObj); } return diagSeqNo; }
	 */

	/*
	 * List<Integer> sampleSeqNoList = new ArrayList<Integer>();
	 * List<DgSampleCollectionDetails> seqNoList = new
	 * ArrayList<DgSampleCollectionDetails>(); String sampleSeqNo = ""; String
	 * lastSeqNo = ""; String lastSeqYear = ""; Map<String,Object> utilMap = new
	 * HashMap<String,Object>(); utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 * String date = (String)utilMap.get("currentDate");
	 * 
	 * String currentYear = date.substring(date.lastIndexOf("/")+1); Session
	 * session = (Session) getSession(); try{ seqNoList =
	 * session.createCriteria(DgSampleCollectionDetails.class).list();
	 * if(seqNoList.size() > 0){
	 * 
	 * for (DgSampleCollectionDetails dgSampleCollectionDetails : seqNoList) {
	 * lastSeqNo = dgSampleCollectionDetails.getSampleNo(); } StringTokenizer
	 * str = new StringTokenizer(lastSeqNo,"/"); while(str.hasMoreTokens()){
	 * lastSeqYear = str.nextToken(); } }else{ lastSeqYear = currentYear; }
	 * sampleSeqNoList =
	 * session.createCriteria(TransactionSequence.class).add(Restrictions
	 * .eq("TransactionPrefix", "SN")).setProjection(
	 * Projections.projectionList() .add(
	 * Projections.max("TransactionSequenceNumber") ) ).list();
	 * if(sampleSeqNoList.size() > 0){ for(Integer maxSampleNo :
	 * sampleSeqNoList){ if(currentYear.equals(lastSeqYear)){ sampleSeqNo =
	 * String.valueOf(maxSampleNo+1); }else{ sampleSeqNo = String.valueOf(1); }
	 * } }else{ sampleSeqNo = String.valueOf(1); } sampleSeqNo =
	 * sampleSeqNo.concat("/").concat(String.valueOf(lastSeqYear));
	 * }catch(HibernateException e){ e.printStackTrace(); } return sampleSeqNo;
	 */
	/*
	 * public Map<String, Object> getPatientDetail(String visitNo) {
	 * (Session)getSession(); Map<String, Object> detailsMap = new
	 * HashMap<String, Object>(); List<Visit> visitList = new
	 * ArrayList<Visit>(); try { visitList =
	 * session.createCriteria(Visit.class).add(Restrictions.eq("Id",
	 * service------"+visitList); if(visitList.size() > 0){
	 * detailsMap.put("visitList", visitList); } } catch (HibernateException e)
	 * { e.printStackTrace(); } return detailsMap; }
	 */

	/*
	 * public List<Visit> getVisitNo(int hinId) { Session session =
	 * (Session)getSession(); List<Visit> visitNoList = new ArrayList<Visit>();
	 * 
	 * //visitNoList = session.createCriteria(Visit.class).createAlias("Hin",
	 * "p").add(Restrictions.eq("p.PFirstName", patientName)).list();
	 * visitNoList = session.createCriteria(Visit.class).setProjection(
	 * Projections
	 * .projectionList().add(Projections.max("VisitNo"))).createAlias("Hin",
	 * "p").add(Restrictions.eq("p.Id", hinId)).list();
	 * 
	 * return visitNoList; }
	 */

	public List<Visit> getVisitNo(Map<String, Object> dataMap) {
		List<Visit> visitNoList = new ArrayList<Visit>();
		String hinNo=dataMap.get(HIN_NO).toString();
		int hospitalId=Integer.parseInt(dataMap.get(HOSPITAL_ID).toString());
		int deptId=Integer.parseInt(dataMap.get(RequestConstants.DEPT_ID).toString());
		Session session = (Session) getSession();
		try {
			Visit visit = new Visit();
			visitNoList = session.createCriteria(Visit.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("VisitDate", HMSUtil.getCurrentDateAndTimeObject()))
					.add(Restrictions.eq("p.PatientStatus", "Out Patient"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return visitNoList;
	}
	
	public List<Visit> getVisitNoForQC(Map<String, Object> dataMap) {
		List<Visit> visitNoList = new ArrayList<Visit>();
		String hinNo=dataMap.get(HIN_NO).toString();
		int hospitalId=Integer.parseInt(dataMap.get(HOSPITAL_ID).toString());
		int deptId=Integer.parseInt(dataMap.get(RequestConstants.DEPT_ID).toString());
		int userId=Integer.parseInt(dataMap.get(USER_ID).toString());
		Users userObj=new Users(userId);
		MasDepartment department=new MasDepartment(deptId);
		MasHospital masHospital=new MasHospital(hospitalId);
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		org.hibernate.Transaction tx=null;
		try {
			tx=session.beginTransaction();
			//Visit visit = new Visit(); 
			visitNoList = session.createCriteria(Visit.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo))
					.add(Restrictions.eq("Hospital.Id", hospitalId)) 
					.add(Restrictions.eq("p.PatientStatus", "Out Patient"))
					.list();
			if(visitNoList==null || visitNoList.size()<=0){ 
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Patient patient=(Patient) session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo.trim())).uniqueResult();
				Visit visit = new Visit();
				QueueManagment queue=new QueueManagment();
				visit.setDepartment(department);
				visit.setPriorityNumber(0);
				visit.setHin(patient);
				visit.setTotalHospitalVisit(0);
				visit.setAppointmentType("D");
				visit.setAppointmentType("D");
				visit.setHospital(masHospital);
				int visitSessionId=0;
				
				// Commented by dhananjay on 22-Mar-2017
				//int maxTokenNo = registrationDataService.getTokenNoForDepartment(deptId, hospitalId,visitSessionId); 
				//int tokenNo = maxTokenNo + 1;
				int tokenNo =0;
				visit.setAppointmentType("D");
				visit.setTokenNo(tokenNo);
				visit.setAddEditBy(userObj);
				
				if(patient!=null && patient.getAge()!=null) // added by amit das on 21-07-2016
				visit.setAge(patient.getAge());
				
				visit.setVisitTime(time);
				visit.setVisitNo(1);
				visit.setStatus("y");
				visit.setEdStatus("n");
				visit.setVisitStatus("w");
				visit.setAddEditDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				visit.setAddEditTime(time);
				visit.setCurPharVisitStatus("Y");
				hbt.save(visit);
				queue.setPriorityNumber(1);
				queue.setHin(patient);
				queue.setTotalHospitalVisit(0);
				queue.setHospital(masHospital);
				queue.setTokenNo(tokenNo);
				queue.setLsCngDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				queue.setTokenStatus("w");
				queue.setVisit(visit);
				hbt.save(queue);
				hbt.clear();
				hbt.flush();
				tx.commit();
				visitNoList.add(visit);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
			}
		} 
		return visitNoList;
	}

	public Map<String, Object> getDetailsForValidationSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> showSampleNo() {
		return null;
	}

	public List<Object> getHinNoList(String serviceNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object> getResultList(Map<String, Object> detailsMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generateDiagNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDiagSeqForDisplay(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	// //-------------------------------Start Methods developed by Vivek
	// --------------------------------------
	//
	// @SuppressWarnings("unchecked")
	// public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
	// List objectList=new ArrayList();
	// String orGroupId ="";
	// try{
	// if(dataMap.get("orGroupId")!= null){
	// orGroupId = (""+dataMap.get("orGroupId"));
	// }
	// StringTokenizer s1 = new StringTokenizer(orGroupId,".");
	// while (s1.hasMoreTokens())
	// {
	// objectList.add(Integer.parseInt(""+s1.nextToken()));
	// }
	// Session session = (Session)getSession();
	// dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
	// .add(Restrictions.in("OrganismGroup.Id", objectList))
	// .addOrder( Order.asc("OrganismGroup.Id")).list();
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// map.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
	// return map;
	// }
	//
	// public Map<String, Object> getSensitivityList(Map<String, Object>
	// dataMap) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// String orIds ="";
	// List objectList=new ArrayList();
	// List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
	// try{
	// if(dataMap.get("orIds") !=null){
	// orIds =""+dataMap.get("orIds") ;
	// }
	// StringTokenizer s1 = new StringTokenizer(orIds,".");
	//
	// while (s1.hasMoreTokens())
	// {
	// try{
	// objectList.add(Integer.parseInt(""+s1.nextToken()));
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// Session session = (Session)getSession();
	// dgOrgDtlList=
	// session.createCriteria(DgOrgDtl.class).add(Restrictions.in("Organism.Id",
	// objectList)).list();
	// }catch (Exception e) {
	// e.printStackTrace();
	// }
	// map.put("dgOrgDtlList", dgOrgDtlList);
	// return map;
	// }
	//
	// public Map<String, Object> saveSensitivity(Map<String, Object> dataMap) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// //-------------------------------End Methods developed by
	// Vivek------------------------------------------
	/*
	 * public String getOrderSeqForDisplay(String string) { // TODO
	 * Auto-generated method stub return null; }
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrderDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		List<Visit> visitList = new ArrayList<Visit>();

		Session session = (Session) getSession();
		Criteria crit = null;

		try {
			DgOrderhd dgOrderhd = (DgOrderhd) session.load(DgOrderhd.class,
					(Integer) mapForDs.get("orderId"));
			if (dgOrderhd != null) {

				visitList = session
						.createCriteria(Visit.class)
						.add(Restrictions
								.eq("Id", dgOrderhd.getVisit().getId())).list();
				map.put("visitNo", visitList.get(0).getVisitNo());
				map.put("visitList", visitList);

			}
			map.put("dgOrderhd", dgOrderhd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> updateOrderDetails(
			Map<String, Object> creationDetailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		DgOrderhd dgOrderhd = new DgOrderhd();
		List chargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List mainChargeList = new ArrayList();
		List qtyList = new ArrayList();
		boolean success = false;
		Box box = null;
		int chargeMainIdFromRequest = 0;
		int dgOrderhdId = 0;
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		String orderSeqNo = "";
		String createdBy = "";
		String userName = "";
		int mainChargeId = 0;
		Session session = (Session) getSession();
		if (creationDetailsMap.get("departmentId") != null) {
			departmentId = (Integer) creationDetailsMap.get("departmentId");
		}
		if (creationDetailsMap.get("userName") != null) {
			userName = (String) creationDetailsMap.get("userName");
		}
		if (creationDetailsMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) creationDetailsMap.get("dgOrderhd");
		}
		if (creationDetailsMap.get("qtyList") != null) {
			qtyList = (List) creationDetailsMap.get("qtyList");
		}
		if (creationDetailsMap.get("mainChargeList") != null) {
			mainChargeList = (List) creationDetailsMap.get("mainChargeList");
		}
		if (creationDetailsMap.get("subChargeList") != null) {
			subChargeList = (List) creationDetailsMap.get("subChargeList");
		}
		if (creationDetailsMap.get("userId") != null) {
			userId = (Integer) creationDetailsMap.get("userId");
		}
		if (creationDetailsMap.get("chargeMainIdFromRequest") != null) {
			chargeMainIdFromRequest = (Integer) creationDetailsMap
					.get("chargeMainIdFromRequest");
		}

		if (creationDetailsMap.get("createdBy") != null) {
			createdBy = (String) creationDetailsMap.get("createdBy");
		}

		if (creationDetailsMap.get("box") != null) {
			box = (Box) creationDetailsMap.get("box");
		}
		Transaction tx = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		try {
			tx = (Transaction) session.beginTransaction();
			List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>(
					((DgOrderhd) creationDetailsMap.get("originalDgOrderhd"))
							.getDgOrderdts());
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (creationDetailsMap.get("newDgOrderhd") != null) {
				dgOrderhd = (DgOrderhd) creationDetailsMap.get("newDgOrderhd");
				hbt.update(dgOrderhd);
				dgOrderhdId = dgOrderhd.getId();
				map.put("dgOrderhdId", dgOrderhdId);
			}

			hbt.deleteAll(dgOrderdtList);
			if (creationDetailsMap.get("chargeList") != null) {
				chargeList = (List) creationDetailsMap.get("chargeList");
				if (chargeList.size() > 0) {
					for (int i = 0; i < chargeList.size(); i++) {

						DgOrderdt dgOrderdt = new DgOrderdt();
						MasChargeCode masChargeCode = new MasChargeCode();
						MasSubChargecode masSubChargecode = new MasSubChargecode();
						MasMainChargecode masMainChargecode = new MasMainChargecode();

						if (chargeList.get(i) != null
								&& !chargeList.get(i).equals("")) {
							int chargeId = Integer.parseInt(chargeList.get(i)
									.toString());
							masChargeCode.setId(chargeId);
							dgOrderdt.setChargeCode(masChargeCode);

							if (mainChargeList.get(i) != null
									&& !mainChargeList.get(i).equals("")) {
								mainChargeId = Integer.parseInt(mainChargeList
										.get(i).toString());
								masMainChargecode.setId(mainChargeId);
								dgOrderdt.setMainChargecode(masMainChargecode);
							}

							if (subChargeList.get(i) != null
									&& !subChargeList.get(i).equals("")) {
								int subChargeId = Integer
										.parseInt(subChargeList.get(i)
												.toString());
								masSubChargecode.setId(subChargeId);
								dgOrderdt.setSubChargeid(masSubChargecode);
							}
							if (qtyList.get(i) != null
									&& !qtyList.get(i).equals("")) {
								Integer qty = Integer.parseInt(""
										+ qtyList.get(i));
								dgOrderdt.setOrderQty(qty);
								Users users = new Users();
								users.setId(userId);
								dgOrderdt.setLastChgBy(users);
								dgOrderdt.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								dgOrderdt.setLastChgTime(time);
								dgOrderdt.setOrderStatus("P");
								if (creationDetailsMap.get("newDgOrderhd") != null) {
									dgOrderdt.setOrderhd(dgOrderhd);

								}

								hbt.save(dgOrderdt);
								success = true;
							}
						}
					}
				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				try {
					tx.rollback();
				} catch (IllegalStateException e1) {
					e1.printStackTrace();
				} catch (SystemException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}

		map.put("success", success);
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	public Map<String, Object> fillItemsForChargeCode(
			Map<String, Object> dataMap) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getMainChargeList() {
		Session session = (Session) getSession();
		List<MasMainChargecode> masMainChargecodeList = new ArrayList<MasMainChargecode>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			masMainChargecodeList = session
					.createCriteria(MasMainChargecode.class)
					.addOrder(Order.asc("MainChargecodeName")).list();
			map.put("masMainChargecodeList", masMainChargecodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getSubChargeCodeList(int mainCharge) {
		Session session = (Session) getSession();
		List<MasSubChargecode> masSubChargecodeList = new ArrayList<MasSubChargecode>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			masSubChargecodeList = session
					.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("MainChargecode.Id", mainCharge))
					.addOrder(Order.asc("SubChargecodeName")).list();

			map.put("masSubChargecodeList", masSubChargecodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getChargeCodeList(int subCharge) {
		Session session = (Session) getSession();
		List<MasChargeCode> masChargecodeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			masChargecodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("SubChargecode.Id", subCharge))
					.addOrder(Order.asc("ChargeCodeName")).list();

			map.put("masChargecodeList", masChargecodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		try {
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospitalId)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalList.get(0).getHospitalName();

	}

	public String getHospitalAddress(int hospitalId) {
		Session session = (Session) getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		try {
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospitalId)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalList.get(0).getAddress();

	}

	public Map<String, Object> getTotalCountDepartmentWise(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> pendingForSampleValidationList = new ArrayList<DgSampleCollectionDetails>();
		List<DgSampleCollectionDetails> pendingForResultEntryList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryHeader> pendingForResultValidationList = new ArrayList<DgResultEntryHeader>();

		int mainChargeCodeId = 0;
		int subChargeId = 0;
		Date currentDate = new Date();
		Integer hospitalId = 0;
		if (mapForDs.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) mapForDs.get("mainChargeCodeId");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "P"))
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("Maincharge", "mainChargeCode")
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				.add(Restrictions.eq("mainChargeCode.Id", mainChargeCodeId))
				.add(Restrictions.le("sampleHead.DiagnosisDate", currentDate));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("Subcharge.Id", subChargeId));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id"))
				.add(Restrictions.eq("Rejected", "n"))
				.addOrder(Order.asc("Subcharge.Id"));
		crit = crit.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("SampleCollectionHeader"))
				.add(Projections.groupProperty("Subcharge")));

		pendingForSampleValidationList = crit.list();

		crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "P"))
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("sampleHead.Department", "dept")
				.createAlias("Maincharge", "mainChargeCode")
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				.add(Restrictions.eq("mainChargeCode.Id", mainChargeCodeId));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("Subcharge.Id", subChargeId));
		}
		crit = crit
				.add(Restrictions.le("sampleHead.SampleValidationDate",
						currentDate))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections
										.groupProperty("SampleCollectionHeader"))
								.add(Projections.groupProperty("Subcharge")));
		pendingForResultEntryList = crit.list();

		crit = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("ResultStatus", "P"))
				.createAlias("Department", "dept")
				.add(Restrictions.eq("MainChargecode.Id", mainChargeCodeId));
		if (subChargeId != 0) {
			crit = crit.add(Restrictions.eq("SubChargecode.Id", subChargeId));
		}
		crit = crit// .add(Restrictions.le("ResultDate", currentDate))
				.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
						Order.asc("SubChargecode.Id"));
		pendingForResultValidationList = crit.list();

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		if (pendingForResultValidationList.size() > 0) {
			patientListSubDepartWise.add(pendingForResultValidationList.get(0));
			stringOfIds = stringOfIds
					+ pendingForResultValidationList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ pendingForResultValidationList.get(0).getSubChargecode()
							.getId();

			// stringOfIdsList.add(stringOfIds);
			// stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < pendingForResultValidationList.size() - 1; ilop++) {
				if (!pendingForResultValidationList
						.get(ilop)
						.getSampleCollectionHeader()
						.getId()
						.equals(pendingForResultValidationList.get(ilop + 1)
								.getSampleCollectionHeader().getId())) {
					patientListSubDepartWise.add(pendingForResultValidationList
							.get(ilop + 1));
				} else {
					if (!pendingForResultValidationList
							.get(ilop)
							.getSubChargecode()
							.getId()
							.equals(pendingForResultValidationList
									.get(ilop + 1).getSubChargecode().getId())) {
						patientListSubDepartWise
								.add(pendingForResultValidationList
										.get(ilop + 1));
					}
				}
			}
		}
		pendingForResultValidationList = patientListSubDepartWise;

		detailsMap.put("pendingForSampleValidationListTotal",
				pendingForSampleValidationList.size());
		detailsMap.put("pendingForResultEntryListTotal",
				pendingForResultEntryList.size());
		detailsMap.put("pendingForResultValidationListTotal",
				pendingForResultValidationList.size());

		return detailsMap;
	}

	public List<DgOrderhd> getOrderNoList(Map<String, Object> mapForDs) {
		List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		String hinNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String pType = "";
		String orderStatus = "";
		String adNo = "";
		int subGroupId = 0;
		int chargeCodeId = 0;
		int dgOrderHdId = 0;
		int inPatientId = 0;
		Criteria crit = null;

		// if(mapForDs.get("hinId") != null){
		// hinId = (Integer)(mapForDs.get("hinId"));
		// }
		// /////////////////////////////////////////////////////////////
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) mapForDs.get("dgOrderHdId");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("inPatientId") != null) {
			inPatientId = (Integer) mapForDs.get("inPatientId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		// if (mapForDs.get("departmentId") != null) {
		// departmentId = (Integer) mapForDs.get("departmentId");
		// }
		// if (mapForDs.get("orderStatus") != null) {
		// orderStatus = (String) mapForDs.get("orderStatus");
		// }
		try {
			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Id", dgOrderHdId));
			} else if (inPatientId != 0) {
				crit = session.createCriteria(DgOrderhd.class).add(
						Restrictions.eq("Inpatient.Id", inPatientId));
			} else {
				crit = session
						.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("PatientType", pType))
						.add(Restrictions.eq("OrderStatus", "P"))
						.add(Restrictions
								.between("OrderDate", fromDate, toDate))
						.createAlias("Hin", "pt");
				if (!adNo.equals("")) {
					crit = crit.createAlias("Inpatient", "ip").add(
							Restrictions.eq("ip.AdNo", adNo));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
				}
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("pt.PFirstName","%"+patientFName+ "%").ignoreCase());
				}
				if (subGroupId != 0) {
					crit = crit.createAlias("SubChargeid", "sc").add(
							Restrictions.eq("sc.Id", subGroupId));
				}
				if (chargeCodeId != 0) {
					crit = crit.createAlias("ChargeCode", "ch").add(
							Restrictions.eq("ch.Id", chargeCodeId));
				}
			}
			dgOrderhdList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// ///////////////////////////////////////////////

		// Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();

		// try{
		// dgOrderhdList =
		// session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id",
		// hinId))
		// .add(Restrictions.eq("OrderStatus", "P"))
		// .addOrder( Order.asc("Id")).list();
		// } catch (HibernateException e) {
		// e.printStackTrace();
		// }
		return dgOrderhdList;
	}

	public Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs) {
		// TODO Auto-generated method stub
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<String> scdRadioInvestigationList = new ArrayList<String>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();

		List<Integer> dgSampleCollectionDtTemplateIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailTemplateIdList = new ArrayList<Integer>();
		List<DgResultEntryHeader> dgResultEntryHeaderTemplateList = new ArrayList<DgResultEntryHeader>();

		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		int dgOrderHdId = 0;
		int hinId = 0;
		Criteria crit = null;

		if (mapForDs.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) mapForDs.get("dgOrderHdId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}

		try {
			// /////////////////////////////////// Get Order Status Dettails For
			// Radiology ///////////////////////////////
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.idEq(hinId)).list();
			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderHdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						// .createAlias("Department", "dep").add(
						// Restrictions.eq("dep.Id", 49))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.ne("OrderStatus", "e").ignoreCase())
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Radio".toLowerCase()).ignoreCase());
				dgSampleCollectionDetailsList = crit.list();

			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E".toLowerCase())
								.ignoreCase())
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Radio".toLowerCase()).ignoreCase())
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsIds = crit.list();
			}
			if (dgSampleCollectionDetailsIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Radio".toLowerCase()).ignoreCase());
				dgResultEntryDetailList = crit.list();
			}
			// /////////////////////////////////// End Order Status Details For
			// Radiology ///////////////////////////////

			/********************************** Get Order Status Details For Lab ***************************************/
			List<String> orderStatus = new ArrayList<String>();
			orderStatus.add("P");
			orderStatus.add("X");
			if (dgOrderHdId != 0) {
				crit = session
						.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", dgOrderHdId))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.add(Restrictions.in("OrderStatus", orderStatus))
						.addOrder(Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id"));

				dgMasInvestigationList = crit.list();
			}

			if (dgOrderHdId != 0) {
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", dgOrderHdId))
						// .add(Restrictions.eq("OrderStatus", "P"))
						// .createAlias("Department", "dep").add(
						// Restrictions.eq("dep.Id", 48))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase());
				dgSampleCollectionDetailsLabList = crit.list();

			}
			// //////////// get only thos record which are not multiple type
			// ///////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E".toLowerCase())
								.ignoreCase())
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.createAlias("Investigation", "inv")
						.add(Restrictions.ne("inv.InvestigationType", "m"))
						.add(Restrictions.ne("inv.InvestigationType", "v"))
						// .add(Restrictions.ne("inv.InvestigationType", "t"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsLabIds = crit.list();
			}
			if (dgSampleCollectionDetailsLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase());
				dgResultEntryDetailLabList = crit.list();
			}
			// ///////////////// get only multiple type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "m"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
			 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderOnlyMultipleLabIds))
			 * .createAlias("MainChargecode", "mcc")
			 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
			 * dgResultEntryHeaderLabList = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E".toLowerCase())
								.ignoreCase())
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType",
								"m".toLowerCase()).ignoreCase())
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailOnlyMultipleLabIds = crit.list();
			}
			if (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailOnlyMultipleLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailIdList = crit.list();
			}
			if (dgResultEntryDetailIdList.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("Id", dgResultEntryDetailIdList))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase());
				dgResultEntryHeaderLabList = crit.list();
			}

			/**
			 * Added By Ritu For Templates Date 10 Feb
			 * 
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E".toLowerCase())
								.ignoreCase())
						.add(Restrictions.eq("mc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType",
								"t".toLowerCase()).ignoreCase())
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDtTemplateIds = crit.list();
			}
			if (dgSampleCollectionDtTemplateIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDtTemplateIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase())
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailTemplateIdList = crit.list();
			}
			if (dgResultEntryDetailTemplateIdList.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("Id",
								dgResultEntryDetailTemplateIdList))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase());
				dgResultEntryHeaderTemplateList = crit.list();
			}
			/**
			 * End Of Code By Ritu
			 */
			// ///////////////// get only Sensitive type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "v"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType",
								"v".toLowerCase()).ignoreCase())
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode",
								"Lab".toLowerCase()).ignoreCase());
				dgResultEntryHeaderSensitiveLabList = crit.list();
			}

			/********************************** End Order Status Details For Lab ***************************************/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList) {
			scdRadioInvestigationList.add(dgSampleCollectionDetails
					.getInvestigation().getInvestigationName());
		}
		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("scdRadioInvestigationList", scdRadioInvestigationList);

		detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap
				.put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
		detailsMap
				.put("dgResultEntryHeaderLabList", dgResultEntryHeaderLabList);
		detailsMap.put("dgResultEntryHeaderSensitiveLabList",
				dgResultEntryHeaderSensitiveLabList);
		detailsMap.put("dgResultEntryHeaderTemplateList",
				dgResultEntryHeaderTemplateList);
		detailsMap.put("patientList", patientList);
		return detailsMap;
	}

	/*
	 * public Map<String, Object> getOrderDtMap(Map<String, Object> mapForDs) {
	 * // TODO Auto-generated method stub Map<String, Object> detailsMap = new
	 * HashMap<String, Object>();
	 * 
	 * List<Integer> chargeCodeIds = new ArrayList<Integer>(); List<Integer>
	 * dgSampleCollectionDetailsIds = new ArrayList<Integer>(); List<Integer>
	 * dgSampleCollectionHeaderIds = new ArrayList<Integer>(); List<Integer>
	 * dgSampleCollectionHeaderLabIds = new ArrayList<Integer>(); List<Integer>
	 * dgSampleCollectionDetailsLabIds = new ArrayList<Integer>(); List<Integer>
	 * dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
	 * List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new
	 * ArrayList<Integer>(); List<Integer> dgResultEntryDetailIdList = new
	 * ArrayList<Integer>();
	 * 
	 * List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new
	 * ArrayList<DgSampleCollectionDetails>(); List<DgResultEntryDetail>
	 * dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
	 * List<String> scdRadioInvestigationList = new ArrayList<String>();
	 * 
	 * List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
	 * List<DgMasInvestigation> dgMasInvestigationList = new
	 * ArrayList<DgMasInvestigation>(); List<DgSampleCollectionDetails>
	 * dgSampleCollectionDetailsLabList = new
	 * ArrayList<DgSampleCollectionDetails>(); List<DgResultEntryDetail>
	 * dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
	 * List<DgResultEntryHeader> dgResultEntryHeaderLabList = new
	 * ArrayList<DgResultEntryHeader>(); List<DgResultEntryHeader>
	 * dgResultEntryHeaderSensitiveLabList = new
	 * ArrayList<DgResultEntryHeader>();
	 * 
	 * Session session = (Session) getSession(); //
	 * session.setFlushMode(FlushMode.NEVER); URL resourcePath =
	 * Thread.currentThread().getContextClassLoader()
	 * .getResource("table_constant.properties"); String departmentTypeLab =
	 * null; String departmentTypeRadio = null; String masMainChargeCodeRadio =
	 * null; String masMainChargeCodeLab = null; try { Properties prop = new
	 * Properties(); prop.load(new FileInputStream(new
	 * File(resourcePath.getFile()))); departmentTypeLab =
	 * prop.getProperty("mas_department_type_lab"); departmentTypeRadio =
	 * prop.getProperty("mas_department_type_radio"); masMainChargeCodeRadio =
	 * prop .getProperty("mas_main_chargecode_radio"); masMainChargeCodeLab =
	 * masMainChargeCodeRadio = prop .getProperty("mas_main_chargecode_lab");
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } int dgOrderHdId = 0;
	 * 
	 * Criteria crit = null;
	 * 
	 * if (mapForDs.get("dgOrderHdId") != null) { dgOrderHdId = (Integer)
	 * mapForDs.get("dgOrderHdId"); } int hospitalId = 0; if
	 * (mapForDs.get(HOSPITAL_ID) != null) { hospitalId = (Integer)
	 * mapForDs.get(HOSPITAL_ID); } try { // ///////////////////////////////////
	 * Get Order Status Dettails For // Radiology
	 * /////////////////////////////// if (dgOrderHdId != 0) {
	 * 
	 * crit = session .createCriteria(DgSampleCollectionHeader.class)
	 * .add(Restrictions.eq("Order.Id", dgOrderHdId)) //
	 * .add(Restrictions.eq("OrderStatus", "P")) .createAlias("Department",
	 * "dep") .createAlias("dep.DepartmentType", "type")
	 * .add(Restrictions.eq("type.DepartmentTypeCode", departmentTypeRadio))
	 * .add(Restrictions.eq("type.Status", "Y"))
	 * .add(Restrictions.eq("Hospital.Id", hospitalId))
	 * .setProjection(Projections.property("Id")); dgSampleCollectionHeaderIds =
	 * crit.list(); }
	 * 
	 * if (dgSampleCollectionHeaderIds.size() > 0) { crit = session
	 * .createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderIds)) .createAlias("Maincharge", "mc") //
	 * .add(Restrictions.ne("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode", masMainChargeCodeRadio));
	 * dgSampleCollectionDetailsList = crit.list(); crit = session
	 * .createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderIds)) .createAlias("Maincharge", "mc") //
	 * .add(Restrictions.eq("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode", masMainChargeCodeRadio))
	 * .setProjection(Projections.property("Id")); dgSampleCollectionDetailsIds
	 * = crit.list(); }
	 * 
	 * if (dgSampleCollectionDetailsIds.size() > 0) { crit = session
	 * .createCriteria(DgResultEntryDetail.class)
	 * .add(Restrictions.in("SampleCollectionDetails.Id",
	 * dgSampleCollectionDetailsIds)) .createAlias("ChargeCode", "cc")
	 * .createAlias("cc.MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", masMainChargeCodeRadio));
	 * dgResultEntryDetailList = crit.list(); } //
	 * /////////////////////////////////// End Order Status Details For //
	 * Radiology ///////////////////////////////
	 *//**
	 * ******************************** Get Order Status Details For Lab
	 * **************************************
	 */
	/*
	 * List<String> orderStatus = new ArrayList<String>(); orderStatus.add("P");
	 * orderStatus.add("C"); orderStatus.add("A"); orderStatus.add("X"); if
	 * (dgOrderHdId != 0) { // crit = session .createCriteria(DgOrderdt.class)
	 * .createAlias("Orderhd", "ordhd") .add(Restrictions.eq("ordhd.Id",
	 * dgOrderHdId)) // .createAlias("MainChargecode", "mcc") //
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", // "Lab"))
	 * .add(Restrictions.eq("ordhd.Hospital.Id", hospitalId))
	 * .add(Restrictions.in("OrderStatus", orderStatus))
	 * .addOrder(Order.asc("ChargeCode.Id")); dgOrderdtList = crit.list(); } if
	 * (dgOrderdtList.size() > 0) { // for (DgOrderdt dgOrderdt : dgOrderdtList)
	 * { chargeCodeIds.add(dgOrderdt.getChargeCode().getId()); } crit =
	 * session.createCriteria(DgMasInvestigation.class)
	 * .add(Restrictions.in("ChargeCode.Id", chargeCodeIds))
	 * .addOrder(Order.asc("ChargeCode.Id"));
	 * 
	 * dgMasInvestigationList = crit.list(); }
	 * 
	 * if (dgOrderHdId != 0) { //
	 * 
	 * crit = session .createCriteria(DgSampleCollectionHeader.class)
	 * .add(Restrictions.eq("Order.Id", dgOrderHdId)) //
	 * .add(Restrictions.eq("OrderStatus", "P")) .createAlias("Department",
	 * "dep") .add(Restrictions.eq("Hospital.Id", hospitalId))
	 * .add(Restrictions.eq("dep.DepartmentCode", departmentTypeLab))
	 * .setProjection(Projections.property("Id"));
	 * dgSampleCollectionHeaderLabIds = crit.list(); } if
	 * (dgSampleCollectionHeaderLabIds.size() > 0) { //
	 * 
	 * crit = session .createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
	 * .add(Restrictions.ne("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode", masMainChargeCodeLab));
	 * dgSampleCollectionDetailsLabList = crit.list(); } // //////////// get
	 * only thos record which are not multiple type // /////////// if
	 * (dgSampleCollectionHeaderLabIds.size() > 0) { // crit = session
	 * .createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
	 * .add(Restrictions.eq("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode", masMainChargeCodeLab))
	 * .createAlias("Investigation", "inv")
	 * .add(Restrictions.ne("inv.InvestigationType", "m"))
	 * .add(Restrictions.ne("inv.InvestigationType", "v"))
	 * .setProjection(Projections.property("Id"));
	 * dgSampleCollectionDetailsLabIds = crit.list(); } if
	 * (dgSampleCollectionDetailsLabIds.size() > 0) { // crit = session
	 * .createCriteria(DgResultEntryDetail.class)
	 * .add(Restrictions.in("SampleCollectionDetails.Id",
	 * dgSampleCollectionDetailsLabIds)) .createAlias("ChargeCode", "cc")
	 * .createAlias("cc.MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", masMainChargeCodeLab));
	 * dgResultEntryDetailLabList = crit.list(); } // ///////////////// get only
	 * multiple type here //////////////////
	 * 
	 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
	 * session.createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
	 * .add(Restrictions.eq("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
	 * .createAlias("Investigation", "inv")
	 * .add(Restrictions.eq("inv.InvestigationType", "m")) .setProjection
	 * (Projections.property("SampleCollectionHeader.Id"));
	 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
	 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
	 * session.createCriteria(DgResultEntryHeader.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderOnlyMultipleLabIds))
	 * .createAlias("MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
	 * dgResultEntryHeaderLabList = crit.list(); }
	 * 
	 * if (dgSampleCollectionHeaderLabIds.size() > 0) { crit = session
	 * .createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
	 * .add(Restrictions.eq("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode", masMainChargeCodeLab))
	 * .createAlias("Investigation", "inv")
	 * .add(Restrictions.eq("inv.InvestigationType", "m"))
	 * .setProjection(Projections.property("Id"));
	 * dgSampleCollectionDetailOnlyMultipleLabIds = crit.list(); } if
	 * (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) { crit = session
	 * .createCriteria(DgResultEntryDetail.class)
	 * .add(Restrictions.in("SampleCollectionDetails.Id",
	 * dgSampleCollectionDetailOnlyMultipleLabIds)) .createAlias("ChargeCode",
	 * "cc") .createAlias("cc.MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", masMainChargeCodeLab))
	 * .setProjection( Projections .groupProperty("SampleCollectionDetails.Id"))
	 * .setProjection(Projections.property("ResultEntry.Id"));
	 * dgResultEntryDetailIdList = crit.list(); } if
	 * (dgResultEntryDetailIdList.size() > 0) { crit = session
	 * .createCriteria(DgResultEntryHeader.class) .add(Restrictions.in("Id",
	 * dgResultEntryDetailIdList)) .createAlias("MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", masMainChargeCodeLab));
	 * dgResultEntryHeaderLabList = crit.list(); }
	 * 
	 * // ///////////////// get only Sensitive type here //////////////////
	 * 
	 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
	 * session.createCriteria(DgSampleCollectionDetails.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
	 * .add(Restrictions.eq("OrderStatus", "E"))
	 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
	 * .createAlias("Investigation", "inv")
	 * .add(Restrictions.eq("inv.InvestigationType", "v")) .setProjection
	 * (Projections.property("SampleCollectionHeader.Id"));
	 * dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list(); }
	 * 
	 * if (dgSampleCollectionHeaderLabIds.size() > 0) { crit = session
	 * .createCriteria(DgResultEntryHeader.class)
	 * .add(Restrictions.in("SampleCollectionHeader.Id",
	 * dgSampleCollectionHeaderLabIds)) .createAlias("Investigation", "inv")
	 * .add(Restrictions.eq("inv.InvestigationType", "v"))
	 * .createAlias("MainChargecode", "mcc")
	 * .add(Restrictions.eq("mcc.MainChargecodeCode", masMainChargeCodeLab));
	 * dgResultEntryHeaderSensitiveLabList = crit.list(); }
	 *//**
	 * ******************************** End Order Status Details For Lab
	 * **************************************
	 */
	/*
	 * } catch (HibernateException e) { e.printStackTrace(); } for
	 * (DgSampleCollectionDetails dgSampleCollectionDetails :
	 * dgSampleCollectionDetailsList) {
	 * scdRadioInvestigationList.add(dgSampleCollectionDetails
	 * .getInvestigation().getInvestigationName()); }
	 * detailsMap.put("dgSampleCollectionDetailsList",
	 * dgSampleCollectionDetailsList);
	 * detailsMap.put("scdRadioInvestigationList", scdRadioInvestigationList);
	 * 
	 * detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);
	 * detailsMap.put("dgOrderdtList", dgOrderdtList);
	 * detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
	 * detailsMap.put("dgSampleCollectionDetailsLabList",
	 * dgSampleCollectionDetailsLabList); detailsMap
	 * .put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
	 * detailsMap .put("dgResultEntryHeaderLabList",
	 * dgResultEntryHeaderLabList);
	 * detailsMap.put("dgResultEntryHeaderSensitiveLabList",
	 * dgResultEntryHeaderSensitiveLabList);
	 * 
	 * return detailsMap; }
	 */

	public Map<String, Object> getResultEntryDetailsForLabOrderStatus(
			int resultId, Integer deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}

				if (resultHeaderId > 0) {

					dgResultdetailList = session
							.createCriteria(DgResultEntryDetail.class)
							.add(Restrictions.eq("ResultEntry.Id",
									resultHeaderId))
							/*
							 * .add(Restrictions.or(
							 * Restrictions.eq("ResultDetailStatus", "W"),
							 * Restrictions.eq("ResultDetailStatus", "P")))
							 */
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();

				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session
							.createCriteria(DgResultEntryDetailSen.class)
							.createAlias("ResultEntry", "rs")
							.add(Restrictions.eq("rs.Id", resultHeaderId))
							.list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getResultForRadiologyTest(
			Map<String, Object> mapForDs) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		int dgResultEntryDetailId = 0;
		if (mapForDs.get("dgResultEntryDetailId") != null) {
			dgResultEntryDetailId = (Integer) mapForDs
					.get("dgResultEntryDetailId");
		}

		Session session = (Session) getSession();
		try {
			dgResultEntryDetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("Id", dgResultEntryDetailId)).list();
			if (dgResultEntryDetailList.size() > 0) {
				detailsMap.put("dgResultEntryDetailList",
						dgResultEntryDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;

	}

	public Map<String, Object> printOrderStatusReport(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<Integer> chargeCodeIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailsLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionDetailOnlyMultipleLabIds = new ArrayList<Integer>();
		List<Integer> dgSampleCollectionHeaderOnlySensitiveLabIds = new ArrayList<Integer>();
		List<Integer> dgResultEntryDetailIdList = new ArrayList<Integer>();

		List<String> subChargeCodeGroup = new ArrayList<String>();
		List<DgOrderdt> dgOrderdtForReport = new ArrayList<DgOrderdt>();

		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		List<String> scdRadioInvestigationList = new ArrayList<String>();

		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		List<DgMasInvestigation> dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsLabList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryDetail> dgResultEntryDetailLabList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgResultEntryHeaderLabList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultEntryHeaderSensitiveLabList = new ArrayList<DgResultEntryHeader>();

		Session session = (Session) getSession();
		// session.setFlushMode(FlushMode.NEVER);
		int orderIdForReport = 0;

		Criteria crit = null;

		if (mapForDs.get("orderIdForReport") != null) {
			orderIdForReport = (Integer) mapForDs.get("orderIdForReport");
		}

		try {
			// /////////////////////////////////// Get Order Status Dettails For
			// Radiology ///////////////////////////////
			if (orderIdForReport != 0) {
				crit = session
						.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", orderIdForReport))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep")
						.add(Restrictions.eq("dep.Id", 49))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionHeaderIds = crit.list();
			}

			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Radio"));
				dgSampleCollectionDetailsList = crit.list();

			}
			if (dgSampleCollectionHeaderIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "Radio"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsIds = crit.list();
			}
			if (dgSampleCollectionDetailsIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "Radio"));
				dgResultEntryDetailList = crit.list();
			}
			// /////////////////////////////////// End Order Status Details For
			// Radiology ///////////////////////////////

			/********************************** Get Order Status Details For Lab ***************************************/
			List<String> orderStatus = new ArrayList<String>();
			orderStatus.add("P");
			orderStatus.add("X");
			orderStatus.add("A");
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", orderIdForReport))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						.add(Restrictions.in("OrderStatus", orderStatus))
						.addOrder(Order.asc("ChargeCode.Id"));
				dgOrderdtList = crit.list();
			}
			if (dgOrderdtList.size() > 0) {
				for (DgOrderdt dgOrderdt : dgOrderdtList) {
					chargeCodeIds.add(dgOrderdt.getChargeCode().getId());
				}
				crit = session.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.in("ChargeCode.Id", chargeCodeIds))
						.addOrder(Order.asc("ChargeCode.Id"));

				dgMasInvestigationList = crit.list();
			}

			if (orderIdForReport != 0) {
				crit = session
						.createCriteria(DgSampleCollectionHeader.class)
						.add(Restrictions.eq("Order.Id", orderIdForReport))
						// .add(Restrictions.eq("OrderStatus", "P"))
						.createAlias("Department", "dep")
						.add(Restrictions.eq("dep.Id", 45))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionHeaderLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.ne("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "LAB"));
				dgSampleCollectionDetailsLabList = crit.list();

			}
			// //////////// get only thos record which are not multiple type
			// ///////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "LAB"))
						.createAlias("Investigation", "inv")
						.add(Restrictions.ne("inv.InvestigationType", "m"))
						.add(Restrictions.ne("inv.InvestigationType", "v"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailsLabIds = crit.list();
			}
			if (dgSampleCollectionDetailsLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailsLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"));
				dgResultEntryDetailLabList = crit.list();
			}
			// ///////////////// get only multiple type here //////////////////
			/*
			 * if(dgSampleCollectionHeaderLabIds.size()>0){ crit =
			 * session.createCriteria(DgSampleCollectionDetails.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderLabIds)) .createAlias("Maincharge", "mc")
			 * .add(Restrictions.eq("OrderStatus", "E"))
			 * .add(Restrictions.eq("mc.MainChargecodeCode","Lab" ))
			 * .createAlias("Investigation", "inv")
			 * .add(Restrictions.eq("inv.InvestigationType", "m"))
			 * .setProjection
			 * (Projections.property("SampleCollectionHeader.Id"));
			 * dgSampleCollectionHeaderOnlyMultipleLabIds = crit.list(); }
			 * if(dgSampleCollectionHeaderOnlyMultipleLabIds.size()>0){ crit =
			 * session.createCriteria(DgResultEntryHeader.class)
			 * .add(Restrictions.in("SampleCollectionHeader.Id",
			 * dgSampleCollectionHeaderOnlyMultipleLabIds))
			 * .createAlias("MainChargecode", "mcc")
			 * .add(Restrictions.eq("mcc.MainChargecodeCode","Lab" ));
			 * dgResultEntryHeaderLabList = crit.list(); }
			 */
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "LAB"))
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType", "m"))
						.setProjection(Projections.property("Id"));
				dgSampleCollectionDetailOnlyMultipleLabIds = crit.list();
			}
			if (dgSampleCollectionDetailOnlyMultipleLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.in("SampleCollectionDetails.Id",
								dgSampleCollectionDetailOnlyMultipleLabIds))
						.createAlias("ChargeCode", "cc")
						.createAlias("cc.MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						/*
						 * .setProjection(Projections.distinct(Projections
						 * .projectionList
						 * ().add(Projections.property("MenuType"))))
						 */
						.setProjection(
								Projections
										.groupProperty("SampleCollectionDetails.Id"))
						.setProjection(Projections.property("ResultEntry.Id"));
				dgResultEntryDetailIdList = crit.list();
			}
			if (dgResultEntryDetailIdList.size() > 0) {
				crit = session.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("Id", dgResultEntryDetailIdList))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"));
				dgResultEntryHeaderLabList = crit.list();
			}

			// ///////////////// get only Sensitive type here //////////////////
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("Maincharge", "mc")
						.add(Restrictions.eq("OrderStatus", "E"))
						.add(Restrictions.eq("mc.MainChargecodeCode", "LAB"))
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType", "v"))
						.setProjection(
								Projections
										.property("SampleCollectionHeader.Id"));
				dgSampleCollectionHeaderOnlySensitiveLabIds = crit.list();
			}
			if (dgSampleCollectionHeaderLabIds.size() > 0) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("SampleCollectionHeader.Id",
								dgSampleCollectionHeaderLabIds))
						.createAlias("DgMasInvestigation", "inv")
						.add(Restrictions.eq("inv.InvestigationType", "v"))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"));
				dgResultEntryHeaderSensitiveLabList = crit.list();
			}

			/********************************** End Order Status Details For Lab ***************************************/

			/********************************** Get All Sub Charge Group Wise ***************************************/
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", orderIdForReport))
						.createAlias("SubChargeid", "scc")
						// .setProjection(Projections.groupProperty("scc.SubChargecodeName"))
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
												.property("scc.SubChargecodeName"))));
				// .setProjection(Projections.property("scc.SubChargecodeName"));
				subChargeCodeGroup = crit.list();
			}
			if (orderIdForReport != 0) {
				crit = session.createCriteria(DgOrderdt.class).add(
						Restrictions.eq("Orderhd.Id", orderIdForReport));
				dgOrderdtForReport = crit.list();
				detailsMap.put("hinNo", dgOrderdtForReport.get(0).getOrderhd()
						.getHin().getHinNo());

				detailsMap.put("serviceNo", dgOrderdtForReport.get(0)
						.getOrderhd().getHin().getServiceNo());

				detailsMap.put("orderByDepartment", dgOrderdtForReport.get(0)
						.getOrderhd().getDepartment().getDepartmentName());
				Patient p = dgOrderdtForReport.get(0).getOrderhd().getHin();
				String pFullName = p.getPFirstName();
				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}
				detailsMap.put("patientName", pFullName);

				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				if (sFullName != null) {
					detailsMap.put("servicePersonName", sFullName);
				}
				if (dgOrderdtForReport.get(0).getOrderhd().getOrderNo() != null) {
					detailsMap.put("orderNo", dgOrderdtForReport.get(0)
							.getOrderhd().getOrderNo());
				}
				if (dgOrderdtForReport.get(0).getOrderhd().getOrderDate() != null) {
					detailsMap.put("orderDate", dgOrderdtForReport.get(0)
							.getOrderhd().getOrderDate());
				}
				if (p.getRelation() != null) {
					detailsMap.put("relationName", p.getRelation()
							.getRelationName());
				}
				if (p.getAge() != null) {
					detailsMap.put("patientAge", p.getAge());
				}
				if (p.getSex() != null) {
					detailsMap
							.put("sex", p.getSex().getAdministrativeSexName());
				}
				// detailsMap.put("resultDate",
				// dgOrderdtForReport.get(0).getResultEntry().getResultDate());
				if (p.getRank() != null) {
					detailsMap.put("rankName", p.getRank().getRankName());
				}
				if (dgOrderdtForReport.get(0).getSubChargeid()
						.getSubChargecodeName() != null) {
					detailsMap.put("subChargeCodeName",
							dgOrderdtForReport.get(0).getSubChargeid()
									.getSubChargecodeName());
				}
				if (dgOrderdtForReport.get(0).getMainChargecode()
						.getMainChargecodeName() != null) {
					detailsMap
							.put("mainChargeCodeName", dgOrderdtForReport
									.get(0).getMainChargecode()
									.getMainChargecodeName());
				}
				if (dgOrderdtForReport.get(0).getOrderhd().getClinicalNote() != null) {
					detailsMap.put("clinicalNotes", dgOrderdtForReport.get(0)
							.getOrderhd().getClinicalNote());
				}
				if (p.getUnit() != null) {
					String unitNameAndAddress = p.getUnit().getUnitName() + ","
							+ p.getUnit().getUnitAddress();
					detailsMap.put("unitNameAndAddress", unitNameAndAddress);
				}
				if (p.getRecordOfficeAddress() != null) {
					String recordOfficeAddress = p.getRecordOfficeAddress()
							.getAddress();
					detailsMap.put("recordOfficeAddress", recordOfficeAddress);
				}

				// detailsMap.put("charge",
				// dgOrderdtForReport.get(0).getInvestigation().getInvestigationName());
				String patientType = dgOrderdtForReport.get(0).getOrderhd()
						.getPatientType();
				if (patientType.equalsIgnoreCase("IP")) {
					detailsMap.put("patientType", "In Patient");
				} else {
					detailsMap.put("patientType", "Out Patient");
				}

			}
			/********************************** Get All Sub Charge Group Wise ***************************************/
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsList) {
			scdRadioInvestigationList.add(dgSampleCollectionDetails
					.getInvestigation().getInvestigationName());
		}
		detailsMap.put("dgSampleCollectionDetailsList",
				dgSampleCollectionDetailsList);
		detailsMap.put("scdRadioInvestigationList", scdRadioInvestigationList);

		detailsMap.put("dgResultEntryDetailList", dgResultEntryDetailList);
		detailsMap.put("dgOrderdtList", dgOrderdtList);
		detailsMap.put("dgMasInvestigationList", dgMasInvestigationList);
		detailsMap.put("dgSampleCollectionDetailsLabList",
				dgSampleCollectionDetailsLabList);
		detailsMap
				.put("dgResultEntryDetailLabList", dgResultEntryDetailLabList);
		detailsMap
				.put("dgResultEntryHeaderLabList", dgResultEntryHeaderLabList);
		detailsMap.put("dgResultEntryHeaderSensitiveLabList",
				dgResultEntryHeaderSensitiveLabList);
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
		return detailsMap;
	}

	// ----------------------Method Written For show Department Wise Monthly
	// Summary Report---------------//
	// ------Method Written By Tirath ----------//

	public Map<String, Object> showDepartmentWiseMonthlySummary(
			Map<String, Object> map) {
		Session session = (Session) getSession();

		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();

		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		try {
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("MainChargecode", "mcc")
					.createAlias("mcc.Department", "dep")
					.add(Restrictions.eq("dep.Id", deptId)).list();
			if (subChargeCodeList.size() > 0) {
				map.put("subChargeCodeList", subChargeCodeList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	// ----------------------ethod Written For show Daily Blood Collection
	// Report---------------//
	// ------Method Written By Tirath ----------//

	public Map<String, Object> showDailyBloodCollectionReport(
			Map<String, Object> map) {
		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
		int deptId = 0;
		try {
			deptId = (Integer) map.get("deptId");
			collectionCenterList = session
					.createCriteria(DgCollectionCenter.class)
					.add(Restrictions.eq("Status", "y")).list();

			if (collectionCenterList.size() > 0) {
				detailsMap.put("collectionCenterList", collectionCenterList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientTestResultPrint(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList1 = new ArrayList<DgResultEntryHeader>();
		String hinNo = "";
		String adNo = "";
		int deptId = 0;
		String pType = "";
		Session session = (Session) getSession();
		Criteria crit = null;

		int hinId = 0;

		String orderNo = "";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}

		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		Integer hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		crit = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("ResultStatus", "A"));
		/*
		 * .createAlias("Hin", "pt") .add(Restrictions.eq("pt.HinNo", hinNo));
		 */

		if (!hinNo.equals("")) {
			crit = crit.createAlias("Hin", "pt").add(
					Restrictions.eq("pt.HinNo", hinNo));
		}

		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}

		if (!pType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", pType));
		}

		patientList1 = crit.list();

		map.put("patientDetailsList", patientList1);

		return map;
	}

	public Map<String, Object> showInvestigationReportTemplateJsp(Box box) {
		String deptType = "";
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgMasInvestigationReportTemplate> investigationReportTemplateList = new ArrayList<DgMasInvestigationReportTemplate>();
		if (box.get("deptType") != null) {
			deptType = ("" + box.get("deptType"));
		}
		String str = "";
		if (map.get("autoHint") != null) {
			str = map.get("autoHint") + "%";
		}

		if (box.getInt("deptId") != 0) {
			deptId = box.getInt("deptId");
		}
		Session session = (Session) getSession();

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		investigationReportTemplateList = session.createCriteria(
				DgMasInvestigationReportTemplate.class).list();
		map.put("investigationList", investigationList);
		map.put("investigationReportTemplateList",
				investigationReportTemplateList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addInvestigationReportTemplate(
			DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate) {
		boolean dataSaved = false;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgMasInvestigationReportTemplate);
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public boolean editInvestigationReportTemplate(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		MasLionc masLionc = new MasLionc();
		String changedBy = "";
		Date currentDate = new Date();
		int investigationId = 0;
		int seqNo = 0;
		int classId = 0;
		int groupSeqNo = 0;
		String reportName = "";
		String groupName = "";
		int hospitalId = 0;
		int deptId = 0;
		String status = "";
		boolean dataUpdated = false;
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();

		investigationId = (Integer) generalMap.get("investigationId");
		seqNo = (Integer) generalMap.get("seqNo");
		classId = (Integer) generalMap.get("classId");
		groupSeqNo = (Integer) generalMap.get("groupSeqNo");
		reportName = (String) generalMap.get("reportName");
		groupName = (String) generalMap.get("groupName");
		// dataUpdated = (boolean) generalMap.get("flag");
		DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate = (DgMasInvestigationReportTemplate) getHibernateTemplate()
				.get(DgMasInvestigationReportTemplate.class, classId);
		if (classId != 0) {

			dgMasInvestigation.setId(investigationId);
			dgMasInvestigationReportTemplate
					.setInvestigationId(dgMasInvestigation);
			dgMasInvestigationReportTemplate.setReportName(reportName);
			dgMasInvestigationReportTemplate.setSeq(seqNo);
			dgMasInvestigationReportTemplate.setGroupName(groupName);
			dgMasInvestigationReportTemplate.setGroupSeq(groupSeqNo);

			dgMasInvestigationReportTemplate.setStatus("y");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasInvestigationReportTemplate);
		dataUpdated = true;
		return dataUpdated;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteInvestigationReportTemplate(int investigationId,
			Map<String, Object> generalMap) {
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasInvestigationReportTemplate dgMasInvestigationReportTemplate = new DgMasInvestigationReportTemplate();
		dgMasInvestigationReportTemplate = (DgMasInvestigationReportTemplate) getHibernateTemplate()
				.get(DgMasInvestigationReportTemplate.class, investigationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				dgMasInvestigationReportTemplate.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				dgMasInvestigationReportTemplate.setStatus("y");
				dataDeleted = false;
			}
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasInvestigationReportTemplate);
		return dataDeleted;
	}

	public Map<String, Object> searchInvestigationReportTemplate(
			String searchField) {
		Session session = (Session) getSession();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgMasInvestigationReportTemplate> investigationReportTemplateList = new ArrayList<DgMasInvestigationReportTemplate>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		Map<String, Object> map = new HashMap<String, Object>();
		List lst = new ArrayList();
		investigationReportTemplateList = session
				.createCriteria(DgMasInvestigationReportTemplate.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.like("ReportName", searchField + "%")).list();

		investigationList = session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("investigationReportTemplateList",
				investigationReportTemplateList);
		map.put("investigationList", investigationList);

		return map;

	}

	public Map<String, Object> getChargeAmountAfterDiscount(
			Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasDiscount> criteriaDiscountList = new ArrayList<MasDiscount>();
		Criteria crit = null;
		Session session = (Session) getSession();
		BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
		int chargeId = 0;
		int patientTypeId = 0;
		int companyId = 0;
		int projectId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;
		int billTypeId = 0;
		String patientCategory = "";
		int roomTypeId = 0;
		String regType = "";

		int hospitalId= 0;
		if (detailsMap.get("hospitalId") != null)
			hospitalId = (Integer) detailsMap.get("hospitalId");
		
		if (detailsMap.get("chargeId") != null)
			chargeId = (Integer) detailsMap.get("chargeId");

		if (detailsMap.get("patientTypeId") != null)
			patientTypeId = (Integer) detailsMap.get("patientTypeId");

		if (detailsMap.get("companyId") != null)
			companyId = (Integer) detailsMap.get("companyId");

		if (detailsMap.get("projectId") != null)
			companyId = (Integer) detailsMap.get("projectId");

		if (detailsMap.get("mainChargeId") != null)
			mainChargeId = (Integer) detailsMap.get("mainChargeId");

		if (detailsMap.get("subChargeId") != null)
			subChargeId = (Integer) detailsMap.get("subChargeId");

		if (detailsMap.get("billTypeId") != null)
			billTypeId = (Integer) detailsMap.get("billTypeId");

		if (detailsMap.get("roomTypeId") != null)
			roomTypeId = (Integer) detailsMap.get("roomTypeId");

		if (detailsMap.get("patientCategory") != null)
			patientCategory = (String) detailsMap.get("patientCategory");

		if (detailsMap.get("regType") != null)
			regType = (String) detailsMap.get("regType");

		Date currentDate = new Date();
		DgMasInvestigation masInvestigation=(DgMasInvestigation) session.get(DgMasInvestigation.class, chargeId);
		if(masInvestigation!=null){
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.idEq(masInvestigation.getChargeCode().getId())).list();
		}
		

		crit = session.createCriteria(MasDiscount.class)
				.add(Restrictions.le("EffectiveDateFrom", currentDate))
				.createAlias("PatientType", "pt")
				.add(Restrictions.eq("pt.Id", patientTypeId));

		if (companyId != 0) {
			crit = crit.createAlias("Company", "com").add(
					Restrictions.eq("com.Id", companyId));
		}

		criteriaDiscountList = crit.list();
		Criteria criteria = null;
		if (criteriaDiscountList.size() > 0) {

			for (MasDiscount masDiscount : criteriaDiscountList) {
				/*
				 * if(masDiscount.getMainChargecode()!=null){ }
				 */
				criteria = session.createCriteria(MasDiscount.class)
						.add(Restrictions.le("EffectiveDateFrom", currentDate))
						.createAlias("PatientType", "pt")
						.add(Restrictions.eq("pt.Id", patientTypeId));

				if (masDiscount.getCompany() != null) {
					criteria = criteria.createAlias("Company", "comp").add(
							Restrictions.eq("comp.Id", companyId));
				}

				if (masDiscount.getBillType() != null) {
					criteria = criteria.createAlias("BillType", "bt").add(
							Restrictions.eq("bt.Id", billTypeId));
				}
				if (masDiscount.getPatientCategory() != null) {
					criteria = criteria.add(Restrictions.eq("PatientCategory",
							patientCategory));
				}
				if (masDiscount.getRoomType() != null) {
					if (roomTypeId > 0) {
						criteria = criteria.createAlias("RoomType", "rt").add(
								Restrictions.eq("rt.Id", roomTypeId));
					}
				}

				if (masDiscount.getChargeCode() != null
						&& masDiscount.getSubChargecode() != null
						&& masDiscount.getMainChargecode() != null) {
					if (subChargeId != 0 && mainChargeId != 0) {
						if (chargeId == masDiscount.getChargeCode().getId()
								&& subChargeId == masDiscount
										.getSubChargecode().getId()
								&& mainChargeId == masDiscount
										.getMainChargecode().getId()) {
							criteria = criteria
									.createAlias("ChargeCode", "cc")
									.add(Restrictions.eq("cc.Id", chargeId))
									.createAlias("SubChargecode", "sc")
									.add(Restrictions.eq("sc.Id", subChargeId))
									.createAlias("MainChargecode", "mc")
									.add(Restrictions.eq("mc.Id", mainChargeId));
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
							criteria = criteria
									.createAlias("SubChargecode", "sc")
									.add(Restrictions.eq("sc.Id", subChargeId))
									.createAlias("MainChargecode", "mc")
									.add(Restrictions.eq("mc.Id", mainChargeId));
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

		BigDecimal chargeAmt = new BigDecimal(0.00);
		MasChargeCode masChargeCode = new MasChargeCode();
		if (chargeCodeList.size() > 0) {
			masChargeCode = chargeCodeList.get(0);
			// BigDecimal chargeAmt = new BigDecimal(masChargeCode.getCharge());

			Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
			if (masChargeCode.getMasChargeCodeRates() != null) {
				chargeSet = masChargeCode.getMasChargeCodeRates();
				if (chargeSet.size() > 0) {
					for (MasChargeCodeRates chargeRate : chargeSet) {
						if(chargeRate.getHospital()!=null && chargeRate.getHospital().getId() == hospitalId){
							if (currentDate.compareTo(chargeRate
									.getEffectiveFromDate()) >= 0) {
								chargeAmt = chargeRate.getRate();
								break;
							} else {
								chargeAmt = new BigDecimal(
										masChargeCode.getCharge());
							}
						}else {
							chargeAmt = new BigDecimal(
									masChargeCode.getCharge());
						}
					}

				} else {
					chargeAmt = new BigDecimal(masChargeCode.getCharge());
				}

			} else {
				chargeAmt = new BigDecimal(masChargeCode.getCharge());
			}
			map.put("rate", chargeAmt);
			logger.info("chargeAmt : "+chargeAmt);
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

		BigDecimal discPercnt = new BigDecimal(0);
		BigDecimal discAmt = new BigDecimal(0);
		String discTypeDB = "";
		if (discountList.size() > 0) {
			BigDecimal fixedValueDB = new BigDecimal(0.00);

			for (MasDiscount discount : discountList) {
				if (discount.getEffectiveDateTo() != null
						&& (discount.getEffectiveDateTo()
								.compareTo(currentDate) < 0)) {
					chargeAmountAfterDis = chargeAfterSD;

				} else {
					if (discount.getChargeCode() != null) {
						if (chargeId == discount.getChargeCode().getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();

							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() != null) {
						if (subChargeId == discount.getSubChargecode().getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() != null) {
						if (mainChargeId == discount.getMainChargecode()
								.getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() == null) {
						if (discount.getDiscountPercentage() != null) {
							discPercnt = discount.getDiscountPercentage();
						}
						if (discount.getDiscountValue() != null) {
							discAmt = discount.getDiscountValue();
						}
						if (discount.getFixedValue() != null) {
							fixedValueDB = discount.getFixedValue();
						}
						discTypeDB = discount.getDiscountType();

					}
				}
			}
			if (discPercnt.compareTo(new BigDecimal(0)) > 0) {
				discAmt = chargeAfterSD.multiply(discPercnt).divide(
						new BigDecimal(100), 2, RoundingMode.HALF_UP);
				if (discTypeDB.equalsIgnoreCase("d")) {
					chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					chargeAmountAfterDis = chargeAfterSD.add(discAmt);
					chargeAfterSD = chargeAmountAfterDis; // For Tariff case
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (discAmt.compareTo(new BigDecimal(0)) > 0) {
				if (discTypeDB.equalsIgnoreCase("d")) {
					chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					chargeAmountAfterDis = chargeAfterSD.add(discAmt);
					chargeAfterSD = chargeAmountAfterDis;
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (fixedValueDB.compareTo(new BigDecimal(0)) > 0) {
				if (discTypeDB.equalsIgnoreCase("f")) {
					chargeAmountAfterDis = fixedValueDB;
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
		
		
		map.put("chargeAfterSD", chargeAfterSD);
		map.put("chargeAmountAfterDis", chargeAmountAfterDis);
		map.put("discPercnt", discPercnt);
		map.put("discAmt", discAmt);
		map.put("stdDeduction", stdDeduction);
		map.put("discTypeDB", discTypeDB);
		return map;

	}

	// Lab Integration Code With Machine Start 08 Feb 2011 by Ramdular Prajapati
	// +++++

	public Map<String, Object> fillInvestigationName(Map map) {
		Session session = (Session) getSession();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();

		@SuppressWarnings("unused")
		int investigationId = 0;
		int subInvestigationId=0;
		String machineName=null;
		String parameterName = null;
		try {
			if(map.get("investigationId")!=null){
			investigationId = (Integer) map.get("investigationId");
			}
			if(map.get("subInvestigationId")!=null){
			subInvestigationId = (Integer) map.get("subInvestigationId");
			}
			if(map.get("machineName")!=null){
				machineName = (String) map.get("machineName");
			}
			if(map.get("parameterName")!=null){
				parameterName = (String) map.get("parameterName");
			}
			Criteria c = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Id", investigationId))
					.add(Restrictions.eq("Status", "y"));
			investigationList = c.list();
			map.put("investigationList", investigationList);
			//added by govind 31-07-2017
			if(subInvestigationId>0){
			List<LabMachineXt2000iDetails> nameList = new ArrayList<LabMachineXt2000iDetails>();
			boolean status = false;
			nameList = session.createCriteria(LabMachineXt2000iDetails.class)
					.add(Restrictions.eq("SubInvestigationId", subInvestigationId))
					.add(Restrictions.eq("InvestigationId", investigationId))
					.add(Restrictions.eq("MachineCode", machineName))
					.add(Restrictions.eq("ParameterName", parameterName))
					.list();
			if (nameList.size() > 0) {
				status = true;
			} else {
				status = false;
			}
			map.put("status", status);
			}//added by govind 31-07-2017 end
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<DgMasInvestigation> findInvestigationName() {
		List<DgMasInvestigation> nameList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		String[] invType  = {"s","m"};
		nameList = session
				.createCriteria(DgMasInvestigation.class).add(Restrictions.in("InvestigationType", invType))
			/*	.add(Restrictions.or(Restrictions.eq("InvestigationType", "s"),
						Restrictions.eq("InvestigationType", "m")))*/
				.add(Restrictions.eq("Status", "y").ignoreCase())
				//.add(Restrictions.eq("MachineName", "kx-21"))
				.list();

		return nameList;
	}

	@SuppressWarnings("unchecked")
	public boolean findLabMachineDetails(int investigationId) {
		List<LabMachineXt2000iDetails> nameList = new ArrayList<LabMachineXt2000iDetails>();
		boolean status = false;
		Session session = (Session) getSession();
		nameList = session.createCriteria(LabMachineXt2000iDetails.class)
				.add(Restrictions.eq("InvestigationId", investigationId))
				.list();
		if (nameList.size() > 0) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public boolean findSubInvestigationDetails(Map<String, Object> dataMap) {
		List<LabMachineXt2000iDetails> nameList = new ArrayList<LabMachineXt2000iDetails>();
		List<DgSubMasInvestigation> dgSubMasList = new ArrayList<DgSubMasInvestigation>();
		boolean status = false;
		Session session = (Session) getSession();
		int investigationId = 0;
		int subInvestigationId=0;
		String machineName=null;
		String parameterName = null;
		if(dataMap.get("investigationId")!=null){
		investigationId = (Integer) dataMap.get("investigationId");
		}
		if(dataMap.get("subInvestigationId")!=null){
		subInvestigationId = (Integer) dataMap.get("subInvestigationId");
		}
		if(dataMap.get("machineName")!=null){
			machineName = (String) dataMap.get("machineName");
		}
		if(dataMap.get("parameterName")!=null){
			parameterName = (String) dataMap.get("parameterName");
		}
		
		nameList = session.createCriteria(LabMachineXt2000iDetails.class)
				    .add(Restrictions.eq("SubInvestigationId", subInvestigationId))
					.add(Restrictions.eq("InvestigationId", investigationId))
					.add(Restrictions.eq("MachineCode", machineName))
					.add(Restrictions.eq("ParameterName", parameterName))
				.list();
		if (nameList.size() > 0) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	@Override
	public List<DgSubMasInvestigation> getSubinvestigationName(
			int investigationId, String investigationType) {

		Session session = (Session) getSession();
		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		subInvestigationlist = session
				.createCriteria(DgSubMasInvestigation.class)
				.createAlias("Investigation", "inv")
				.add(Restrictions.eq("inv.Id", investigationId))
				.add(Restrictions
						.eq("inv.InvestigationType", investigationType)).list();
		return subInvestigationlist;
	}

	public boolean addTestParameter(Box box) {
		boolean dataAdded = false;
		String machine_code = "";
		String machineParamId="";
		Vector machineCode = box.getVector(RequestConstants.MACHINE_NAME);
		Vector parameterName = box.getVector(RequestConstants.PARAMETER_NAME);
		Vector investigationName = box
				.getVector(RequestConstants.INVESTIGATION_NAME);
		Vector subInvestigationName = box
				.getVector(RequestConstants.SUB_INVESTIGATION_NAME);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		if (machineCode.firstElement().toString() != null) {
			machine_code = machineCode.firstElement().toString();

		}
		//added by govind 28-07-2017 
		String types="";
		String flag="";
		if(box.get("machineName")!=null){
			types=box.getString("machineName");
		}
		if(box.get("machineParamId")!=null){
			machineParamId=box.getString("machineParamId");
			
		}
		if(box.get("flag")!=null){
			flag=box.getString("flag");
			
		}
		if(flag.equals("deActivate")) {
			
			int machineParamIdValue=Integer.parseInt((String)box.get("machineParamId"));
			LabMachineXt2000iDetails labMachineXt2000iDetailsStatus=(LabMachineXt2000iDetails)hbt.load(LabMachineXt2000iDetails.class, machineParamIdValue);
			if(labMachineXt2000iDetailsStatus.getStatus().equals("InActive")) {
			labMachineXt2000iDetailsStatus.setStatus("Active");
			}else {
				labMachineXt2000iDetailsStatus.setStatus("InActive");
			}
			hbt.saveOrUpdate(labMachineXt2000iDetailsStatus);
			hbt.refresh(labMachineXt2000iDetailsStatus);
			dataAdded = true;

			
		}else {
		if(!types.equals("") && box.get("machineParamId")!=null){
			
			
			LabMachineXt2000iDetails labMachineXt2000iDetails = new LabMachineXt2000iDetails();
			if (parameterName.get(0).toString() != null
					&& !parameterName.get(0).toString().equals("")) {				
				//added by govind 02-06-2017
				List<LabMachineXt2000iDetails> labMachine360List = new ArrayList<LabMachineXt2000iDetails>();		
				labMachine360List = session.createCriteria(LabMachineXt2000iDetails.class)
						.add(Restrictions.eq("MachineCode", types).ignoreCase())//changed for EM360 machine
						.add(Restrictions.eq("ParameterName", parameterName.get(0)).ignoreCase())
						.add(Restrictions.eq("InvestigationId",Integer.parseInt(investigationName.get(0).toString())))
						.add(Restrictions.eq("SubInvestigationId", Integer.parseInt(subInvestigationName.get(0).toString())))
						.list();				
				//added by govind 02-06-2017
				if( box.get("machineParamId")!=null && (!machineParamId.equals("")) && labMachine360List.size()==0){
					
					int machineParamIdValue=Integer.parseInt((String)box.get("machineParamId"));
					LabMachineXt2000iDetails labMachineXt2000iDetailsUpdate=(LabMachineXt2000iDetails)hbt.load(LabMachineXt2000iDetails.class, machineParamIdValue);
					labMachineXt2000iDetailsUpdate.setInvestigationId(Integer.parseInt(investigationName.get(0).toString()));
					labMachineXt2000iDetailsUpdate.setParameterName(parameterName.get(0).toString());
					labMachineXt2000iDetailsUpdate.setStatus("Active");
					labMachineXt2000iDetailsUpdate.setSubInvestigationId(Integer.parseInt(subInvestigationName.get(0).toString()));
					hbt.saveOrUpdate(labMachineXt2000iDetailsUpdate);
					hbt.refresh(labMachineXt2000iDetailsUpdate);
					dataAdded = true;
					
				}
				if(labMachine360List.size()>0){
					//added by govind 31-76-2017
					 labMachineXt2000iDetails=labMachine360List.get(0);					
					labMachineXt2000iDetails
					.setParameterName((String) parameterName.get(0));

			if (investigationName.get(0).toString() != null
					&& !investigationName.get(0).toString().equals("")) {
				labMachineXt2000iDetails.setInvestigationId(Integer
						.parseInt(investigationName.get(0).toString()));

			}
			if (subInvestigationName.get(0).toString() != null
					&& !subInvestigationName.get(0).toString().equals("")) {

				labMachineXt2000iDetails.setSubInvestigationId(Integer
						.parseInt(subInvestigationName.get(0).toString()));
			}
			if (machine_code != null) {

				labMachineXt2000iDetails.setMachineCode(machine_code);
			}
			hbt.update(labMachineXt2000iDetails);
			hbt.refresh(labMachineXt2000iDetails);
			dataAdded = true;
			System.out.println("labMachine360List is already exist");
			//added by govind 31-76-2017
				}else{
					if(dataAdded!=true) {	
				labMachineXt2000iDetails
						.setParameterName((String) parameterName.get(0));

				if (investigationName.get(0).toString() != null
						&& !investigationName.get(0).toString().equals("")) {
					labMachineXt2000iDetails.setInvestigationId(Integer
							.parseInt(investigationName.get(0).toString()));

				}
				if (subInvestigationName.get(0).toString() != null
						&& !subInvestigationName.get(0).toString().equals("")) {

					labMachineXt2000iDetails.setSubInvestigationId(Integer
							.parseInt(subInvestigationName.get(0).toString()));
				}
				if (machine_code != null) {

					labMachineXt2000iDetails.setMachineCode(machine_code);
				}
				labMachineXt2000iDetails.setStatus("Active");
				hbt.saveOrUpdate(labMachineXt2000iDetails);
				hbt.refresh(labMachineXt2000iDetails);
				dataAdded = true;
				}
			  }
			}
		}else{//added by govind 28-07-2017 end
		for (int i = 0; i < 21; i++) {
			LabMachineXt2000iDetails labMachineXt2000iDetails = new LabMachineXt2000iDetails();
			if (parameterName.get(i).toString() != null
					&& !parameterName.get(i).toString().equals("")) {
				
				//added by govind 02-06-2017
				List<LabMachineXt2000iDetails> labMachine360List = new ArrayList<LabMachineXt2000iDetails>();		
				labMachine360List = session.createCriteria(LabMachineXt2000iDetails.class)
						.add(Restrictions.eq("MachineCode", "EM360").ignoreCase())//changed for EM360 machine
						.add(Restrictions.eq("ParameterName", parameterName.get(i)).ignoreCase())
						//.add(Restrictions.eq("InvestigationId", investigationName.get(i).toString()))
						.list();				
				//added by govind 02-06-2017				
				if(labMachine360List.size()>0){
					System.out.println("labMachine360List is already exist");
				}else{
				labMachineXt2000iDetails
						.setParameterName((String) parameterName.get(i));

				if (investigationName.get(i).toString() != null
						&& !investigationName.get(i).toString().equals("")) {
					labMachineXt2000iDetails.setInvestigationId(Integer
							.parseInt(investigationName.get(i).toString()));

				}
				if (subInvestigationName.get(i).toString() != null
						&& !subInvestigationName.get(i).toString().equals("")) {

					labMachineXt2000iDetails.setSubInvestigationId(Integer
							.parseInt(subInvestigationName.get(i).toString()));
				}
				if (machine_code != null) {

					labMachineXt2000iDetails.setMachineCode(machine_code);
				}
				labMachineXt2000iDetails.setStatus("Active");
				hbt.saveOrUpdate(labMachineXt2000iDetails);
				dataAdded = true;
				
			  }
			}
		}
		}
	}
		return dataAdded;

	}

	public List<PatientMainLabInfo> findPatientInfoDetails(String machineName,
			String date) {
		List<PatientMainLabInfo> nameList = new ArrayList<PatientMainLabInfo>();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ldate = sdf.format(HMSUtil.convertStringTypeDateToDateType(date));
		nameList = session.createCriteria(PatientMainLabInfo.class)
				.add(Restrictions.eq("Status", "n").ignoreCase())
				.add(Restrictions.eq("MachineCode", machineName))
				.add(Restrictions.eq("TDate", ldate)).addOrder(Order.asc("Id"))
				.list();
		return nameList;
	}

	public List<DgSampleCollectionDetails> findDgSampleCollectionDetails() {
		List<DgSampleCollectionDetails> nameList = new ArrayList<DgSampleCollectionDetails>();
		Session session = (Session) getSession();
		Criteria criteria = session
				.createCriteria(DgSampleCollectionDetails.class);
		nameList = criteria
				.setProjection(
						Projections.distinct(Projections.property("DiagNo")))
				.add(Restrictions.eq("OrderStatus", "A")).list();
		;
		return nameList;

	}

    public boolean addParameterDiagNo(Box box)
    {
         boolean updatedSuccessfully=false;
         Vector sampleNo = box.getVector(RequestConstants.SAMPLE_NO);
         Vector diagnosisNo = box.getVector(RequestConstants.DIAGNOSIS_NO);
         Vector totalRow = box.getVector(RequestConstants.TOTAL_ROW_VAL);
         Vector serviceNo = box.getVector(RequestConstants.SERVICE_NO);
         Vector sample_date = box.getVector("sample_date");
         Vector change_by = box.getVector(RequestConstants.CHANGED_BY);
         Vector change_date = box.getVector(RequestConstants.CHANGED_DATE);
         Vector change_time = box.getVector(RequestConstants.CHANGED_TIME);
         Vector machine_name = box.getVector("machineName");
	         
         
         String sample_val_date="";
         String changeBy="",changeDate="",changeTime="",machineName="";
         
         int rowCount=0;
         int len=totalRow.lastElement().toString().length();
         if ((change_by.lastElement().toString()!=null))
         {
        	 changeBy=change_by.lastElement().toString();

          }
         if ((change_date.lastElement().toString()!=null))
         {
        	 changeDate=change_date.lastElement().toString();

          }
        // System.out.println("changeDate ========>"+changeDate);
         if ((change_time.lastElement().toString()!=null))
         {
        	 changeTime=change_time.lastElement().toString();

          }
         if ((machine_name.lastElement().toString()!=null))
         {
        	 machineName=machine_name.lastElement().toString();

          }
         if ((totalRow.lastElement().toString()!=null))
         {
          	  rowCount=Integer.parseInt(totalRow.lastElement().toString());

          }
         if ((sample_date.lastElement().toString()!=null))
         {
        	 sample_val_date=sample_date.lastElement().toString();

          }
         String diagNo="";
         HibernateTemplate hbt = getHibernateTemplate();
         hbt.setFlushModeName("FLUSH_EAGER");
         hbt.setCheckWriteOperations(false);
         Session session = (Session) getSession();
        for(int i=0;i<rowCount;i++)
        {
            String sampleno="";
            String service_No="";
            if (sampleNo.get(i).toString() != null
                    && !sampleNo.get(i).toString().equals(""))
            {
                sampleno=sampleNo.get(i).toString();
            }
            if (diagnosisNo.get(i).toString() != null
                    && !diagnosisNo.get(i).toString().equals(""))
            {
                diagNo=diagnosisNo.get(i).toString();
            }
            if (serviceNo.get(i).toString() != null
                    && !serviceNo.get(i).toString().equals(""))
            {

            List<PatientMainLabInfo> patientList = new ArrayList<PatientMainLabInfo>();
            patientList = session.createCriteria(PatientMainLabInfo.class)
                    .add(Restrictions.eq("SampleNo", sampleno))
                    .add(Restrictions.eq("TDate", sample_val_date))
                    .add(Restrictions.eq("MachineCode", machineName))
                    .list();

            for (PatientMainLabInfo patientMainList : patientList)
            {
                if((patientMainList!=null)&&(diagNo!=null))
                {
                    patientMainList.setDiagNo(diagNo);
                    patientMainList.setStatus("y");
                    hbt.update(patientMainList);
                    hbt.refresh(patientMainList);
                    updatedSuccessfully = true;
                }
            }
            }
        }
        if(diagNo!=null&&(!diagNo.equals("")))
        {
        	List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
           	patientList= session.createCriteria(DgSampleCollectionDetails.class).add(
              Restrictions.eq("DiagNo", diagNo)).add(
    	              Restrictions.eq("LabStatus", "n"))
              .list();
            for(DgSampleCollectionDetails dgSampleCollectionDetails:patientList)
            {
            	dgSampleCollectionDetails.setOrderStatus("E");
            	hbt.update(dgSampleCollectionDetails);
                hbt.refresh(dgSampleCollectionDetails);
            }

        }
        //===================================================================================================================================
        try
        {
        	 List<PatientMainLabInfo> patientMainLabList = new ArrayList<PatientMainLabInfo>();
        	 List<PatientLabInfo> patientInfoList = new ArrayList<PatientLabInfo>();
        	 List<LabMachineXt2000iDetails>  labMachineXt2000iDetailsList= new ArrayList<LabMachineXt2000iDetails>();
        	 patientMainLabList = session.createCriteria(PatientMainLabInfo.class)
	                    .add(Restrictions.eq("Status","y"))
	                    .add(Restrictions.eq("TDate", sample_val_date))
	                    .add(Restrictions.eq("MachineCode", machineName)).list();
        	 String result_date=sample_val_date.substring(3,5)+"/"+sample_val_date.substring(0,2)+"/"+sample_val_date.substring(6);
	      	  for(PatientMainLabInfo patientMainInfo:patientMainLabList)
        	  {
	      		boolean dataAdded = false;
        		 String sample_No=patientMainInfo.getSampleNo();
        		 patientInfoList=session.createCriteria(PatientLabInfo.class)
                    .add(Restrictions.eq("SampleNo",sample_No))
                    .add(Restrictions.eq("TDate", sample_val_date))
                    .add(Restrictions.eq("MachineCode", machineName))
                    .list();
        		  for(PatientLabInfo patientLabInfoList:patientInfoList)
        		  {
        			  labMachineXt2000iDetailsList=session.createCriteria(LabMachineXt2000iDetails.class)
	                    	                    .add(Restrictions.eq("MachineCode", machineName)).list();
        			  for(LabMachineXt2000iDetails labMachineXt2000iDetails:labMachineXt2000iDetailsList)
        			  {
        				  
        				  
        				  //------------------------------------------------------------------------------------------
        				  if(patientLabInfoList.getParameterName().equals(labMachineXt2000iDetails.getParameterName()))
        				  {	  
        					  
        				     try
        				     {
        					 
        				     int i = 0;
        				     List<DgSampleCollectionDetails> dgSampleCollectondetail=new ArrayList<DgSampleCollectionDetails>();
        				    				        
        				        dgSampleCollectondetail=session.createCriteria(DgSampleCollectionDetails.class)
        				         .add(Restrictions.eq("DiagNo",patientMainInfo.getDiagNo()))
        				         .add(Restrictions.eq("LabStatus","n"))
        				         .list();
        				        for(DgSampleCollectionDetails dgSample:dgSampleCollectondetail)
        				        {
        				           int investigation_id=0;
        				           investigation_id=dgSample.getInvestigation().getId();
        				          
        				          if(labMachineXt2000iDetails.getInvestigationId()==investigation_id)
        				          {
        				           Set<DgSubMasInvestigation> dgSubMasInvestigation=dgSample.getInvestigation().getDgSubMasInvestigations();
        				           int  uom_id=0;
        				           int  inpatient_id=0;
        				           int  sample_collection_detailid=dgSample.getId();
        				           int  sample_collection_header_id=dgSample.getSampleCollectionHeader().getId();
        				           int  charge_code_id=dgSample.getChargeCode().getId();
        				           int  hin_id=dgSample.getSampleCollectionHeader().getHin().getId();
        				           if(dgSample.getSampleCollectionHeader().getInpatient()!=null)
        				           inpatient_id=dgSample.getSampleCollectionHeader().getInpatient().getId();
        				           int  department_id=dgSample.getSampleCollectionHeader().getDepartment().getId();
        				           int  hospital_id=dgSample.getSampleCollectionHeader().getHospital().getId();
        				           int  validated_By=dgSample.getSampleCollectionHeader().getValidatedBy().getId();
        				           int  sub_charge_code_id=dgSample.getSubcharge().getId();
        				           int  main_charge_code_id=dgSample.getMaincharge().getId();
        				           String  investigation_type=dgSample.getInvestigation().getInvestigationType();
        				           if(dgSample.getInvestigation().getUom()!=null)
        				           uom_id=dgSample.getInvestigation().getUom().getId();
        				           int  test_order_no=dgSample.getInvestigation().getTestOrderNo();

        				          DgResultEntryHeader dgresultheader=new DgResultEntryHeader();
        				          dgresultheader.setMainChargecode(dgSample.getMaincharge());
        				          dgresultheader.setSubChargecode(dgSample.getSubcharge());

        				          dgresultheader.setResultDate(new Date(result_date));
        				          dgresultheader.setResultTime(patientMainInfo.getTime());
        				          dgresultheader.setEmployee(dgSample.getSampleCollectionHeader().getValidatedBy());
        				          dgresultheader.setResultStatus("P");
        				       //   dgresultheader.setLastChgdBy(changeBy);
        				          dgresultheader.setLastChgdDate(new Date(changeDate));
        				          dgresultheader.setLastChgdTime(changeTime);
        				          dgresultheader.setSampleCollectionHeader(dgSample.getSampleCollectionHeader());
        				          dgresultheader.setHin(dgSample.getSampleCollectionHeader().getHin());
        				          dgresultheader.setInpatient(dgSample.getSampleCollectionHeader().getInpatient());
        				          dgresultheader.setDepartment(dgSample.getSampleCollectionHeader().getDepartment());
        				          dgresultheader.setHospital(dgSample.getSampleCollectionHeader().getHospital());
        				          dgresultheader.setTestOrderNo(dgSample.getInvestigation().getTestOrderNo());
        				          dgresultheader.setInvestigation(dgSample.getInvestigation());
        				          String resultSeqNo = "";
        				          Map<String, Object> diagMap = new HashMap<String, Object>();
        							resultSeqNo = generateResultNumber(diagMap);
        						//	System.out.println("resultSeqNo---"+resultSeqNo);
        							if (resultSeqNo != "") {
        								dgresultheader.setResultNo(resultSeqNo);
        							}
        				          hbt.save(dgresultheader);
        				          //System.out.println("header saved");
        				          List<DgResultEntryHeader> dg_result_header=new ArrayList<DgResultEntryHeader>();
        				          dg_result_header=session.createQuery("select max(dh.id) from DgResultEntryHeader dh").list();
        				          //System.out.println("dg_result_header"+dg_result_header);
        				          Iterator itr=dg_result_header.iterator();
        				          int headerId=0;
        				          while(itr.hasNext())
        				          {
        				         	 headerId=(Integer)itr.next();
        				           //   System.out.println(" header id"+(Integer)itr.next());
        				          }
        				          DgResultEntryHeader header=(DgResultEntryHeader)hbt.load(DgResultEntryHeader.class, headerId);


        				           DgResultEntryDetail dgResultEntryDetails=new DgResultEntryDetail();
        				           dgResultEntryDetails.setResultEntry(header);
        				           dgResultEntryDetails.setChargeCode(dgSample.getChargeCode());
        				           dgResultEntryDetails.setResultType(investigation_type);
        				           dgResultEntryDetails.setResult(patientLabInfoList.getMeasurementValue());
        				           dgResultEntryDetails.setUom(dgSample.getInvestigation().getUom());
        				           dgResultEntryDetails.setInvestigation(dgSample.getInvestigation());
        				           int sub_invest_id=0;
        				           if(labMachineXt2000iDetails.getSubInvestigationId()!=null)
        				           {
        				        	   sub_invest_id=labMachineXt2000iDetails.getSubInvestigationId();
        				           }
        				           DgSubMasInvestigation  subInvestigation=(DgSubMasInvestigation)hbt.load(DgSubMasInvestigation.class, sub_invest_id);
        				           dgResultEntryDetails.setResultDetailStatus("P");
        				           dgResultEntryDetails.setSampleCollectionDetails(dgSample);

        				           List<DgNormalValue> dgnormalValue=new ArrayList<DgNormalValue>();
        				           if(investigation_type.equalsIgnoreCase("m"))
        				           {
        				         	  dgResultEntryDetails.setSubInvestigation(subInvestigation);
        				              dgnormalValue=session.createCriteria(DgNormalValue.class)
        				               .add(Restrictions.eq("SubInvestigation",subInvestigation ))
        				               .add(Restrictions.eq("Sex",dgSample.getSampleCollectionHeader().getHin().getSex().getAdministrativeSexCode())).list();
        				               for(DgNormalValue dgNormal:dgnormalValue)
        				               {
        				                  dgResultEntryDetails.setNormal(dgNormal);
        				               }

        				           }

        				         hbt.save(dgResultEntryDetails);
        				         dataAdded=true;
        				         updatedSuccessfully=true;
        					      
        				          }
        				        
        				       }

        				     }catch (HibernateException he)
        				     { 
        				    	 he.printStackTrace();
							  }
        				     }
        			  }
        		  }
        		  if(dataAdded==true)
				     {
				    	 try
					       {
				    		List<DgSampleCollectionDetails> dgSampleCollectondetail=session.createCriteria(DgSampleCollectionDetails.class)
					         .add(Restrictions.eq("DiagNo",patientMainInfo.getDiagNo()))
					         .add(Restrictions.eq("LabStatus","n"))
					         .list();
				    		 for(DgSampleCollectionDetails dgSample:dgSampleCollectondetail)
				 	        {
					          dgSample.setLabStatus("y");
					          hbt.update(dgSample);
					          } 
					      
				    	
				           List<PatientMainLabInfo> patientmain=new ArrayList<PatientMainLabInfo>();
				           patientmain=session.createCriteria(PatientMainLabInfo.class)
				           .add(Restrictions.eq("DiagNo",diagNo ))
				           .add(Restrictions.eq("Status","y"))
				           .add(Restrictions.eq("MachineCode",machineName))
				           .add(Restrictions.eq("TDate",sample_val_date))
				           .list();
				          for(PatientMainLabInfo maininfolist:patientmain)
				          {
				         	 maininfolist.setStatus("V");
				         	 hbt.update(maininfolist);
				          }
					      }catch (HibernateException e) 
					      {
				            e.printStackTrace();
				     }
				        
				     }
				    
        		  
        	  }
        } catch(HibernateException e)
          {
        	e.printStackTrace();
          }
        				  
        			
                 return	updatedSuccessfully ;
    }

/*
	public boolean addParameterDiagNo(Box box) {
		boolean updatedSuccessfully = false;
		Vector patientLabId = box.getVector("patientLabId");
		Vector sampleNo = box.getVector(RequestConstants.SAMPLE_NO);
		Vector diagnosisNo = box.getVector(RequestConstants.DIAGNOSIS_NO);
		Vector totalRow = box.getVector(RequestConstants.TOTAL_ROW_VAL);
		Vector serviceNo = box.getVector(RequestConstants.SERVICE_NO);
		Vector sample_date = box.getVector("sample_date");
		Vector change_by = box.getVector(RequestConstants.CHANGED_BY);
		Vector change_date = box.getVector(RequestConstants.CHANGED_DATE);
		Vector change_time = box.getVector(RequestConstants.CHANGED_TIME);
		Vector machine_name = box.getVector("machineName");
		String changeBy = "", changeDate = "", changeTime = "", machineName = "", sampleno = "", sample_val_date = "";
		int value = 0, rowCount = 0;
		int len = totalRow.lastElement().toString().length();
		if ((change_by.lastElement().toString() != null)) {
			changeBy = change_by.lastElement().toString();
		}
		if ((change_date.lastElement().toString() != null)) {
			changeDate = change_date.lastElement().toString();
		}
		if ((change_time.lastElement().toString() != null)) {
			changeTime = change_time.lastElement().toString();
		}
		if ((machine_name.lastElement().toString() != null)) {
			machineName = machine_name.lastElement().toString();
		}
		if ((totalRow.lastElement().toString() != null)) {
			rowCount = Integer.parseInt(totalRow.lastElement().toString());
		}
		if ((sample_date.lastElement().toString() != null)) {
			sample_val_date = sample_date.lastElement().toString();
		}
		String diagNo = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		for (int i = 0; i < rowCount; i++) {
			String service_No = "";
			if (patientLabId.get(i).toString() != null) {
				value = Integer.parseInt(patientLabId.get(i).toString());
			}
			if (diagnosisNo.get(i).toString() != null
					&& !diagnosisNo.get(i).toString().equals("")) {
				diagNo = diagnosisNo.get(i).toString();
				if (sampleNo.get(i).toString() != null
						&& !sampleNo.get(i).toString().equals("")) {
					sampleno = sampleNo.get(i).toString();
				}
			}
			if (serviceNo.get(i).toString() != null
					&& !serviceNo.get(i).toString().equals("")) {
				List<PatientMainLabInfo> patientList = new ArrayList<PatientMainLabInfo>();
				patientList = session.createCriteria(PatientMainLabInfo.class)
						.add(Restrictions.eq("SampleNo", sampleno))
						.add(Restrictions.eq("TDate", sample_val_date)).list();
				for (PatientMainLabInfo patientMainList : patientList) {
					if ((patientMainList != null) && (diagNo != null)) {
						patientMainList.setDiagNo(diagNo);
						patientMainList.setStatus("y");
						hbt.update(patientMainList);
						hbt.refresh(patientMainList);
						updatedSuccessfully = true;
					}
				}
			}
		}

		if (diagNo != null && (!diagNo.equals(""))) {
			List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
			patientList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("DiagNo", diagNo))
					.add(Restrictions.eq("LabStatus", "n")).list();
			for (DgSampleCollectionDetails dgSampleCollectionDetails : patientList) {
				dgSampleCollectionDetails.setOrderStatus("E");
				hbt.update(dgSampleCollectionDetails);
				hbt.refresh(dgSampleCollectionDetails);
			}
		}
		try {
			List<PatientMainLabInfo> patientMainLabList = new ArrayList<PatientMainLabInfo>();
			
			 * List<PatientLabInfo> patientInfoList = new
			 * ArrayList<PatientLabInfo>();
			 
			List<Object[]> patientInfoList = new ArrayList<Object[]>();
			List<LabMachineXt2000iDetails> labMachineXt2000iDetailsList = new ArrayList<LabMachineXt2000iDetails>();
			//
			patientMainLabList = session
					.createCriteria(PatientMainLabInfo.class)
					.add(Restrictions.eq("MachineCode", machineName))
					.add(Restrictions.eq("Id", value)).list();
			boolean dataAdded = false;
			String result_date = sample_val_date.substring(3, 5) + "/"
					+ sample_val_date.substring(0, 2) + "/"
					+ sample_val_date.substring(6);
			int i2 = 1;
			for (PatientMainLabInfo patientMainInfo : patientMainLabList) {
				//
				List<DgSampleCollectionDetails> dgSampleCollectondetail22 = new ArrayList<DgSampleCollectionDetails>();
				dgSampleCollectondetail22 = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.eq("DiagNo", diagNo))
						.add(Restrictions.eq("LabStatus", "n")).list();

				int header1 = 0;
				for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail22) {
					header1 = dgSample.getSampleCollectionHeader().getId();

					DgResultEntryHeader dgresultheader = new DgResultEntryHeader();
					dgresultheader.setMainChargecode(dgSample.getMaincharge());
					dgresultheader.setSubChargecode(dgSample.getSubcharge());
					dgresultheader.setResultDate(new Date(result_date));
					dgresultheader.setResultTime(patientMainInfo.getTime());
					dgresultheader.setEmployee(dgSample
							.getSampleCollectionHeader().getValidatedBy());
					dgresultheader.setResultStatus("P");
					// dgresultheader.setLastChgdBy(changeBy);
					dgresultheader.setLastChgdDate(new Date(changeDate));
					dgresultheader.setLastChgdTime(changeTime);
					dgresultheader.setSampleCollectionHeader(dgSample
							.getSampleCollectionHeader());
					dgresultheader.setHin(dgSample.getSampleCollectionHeader()
							.getHin());
					dgresultheader.setInpatient(dgSample
							.getSampleCollectionHeader().getInpatient());
					dgresultheader.setDepartment(dgSample
							.getSampleCollectionHeader().getDepartment());
					dgresultheader.setHospital(dgSample
							.getSampleCollectionHeader().getHospital());
					dgresultheader.setTestOrderNo(dgSample.getInvestigation()
							.getTestOrderNo());
					dgresultheader
							.setInvestigation(dgSample.getInvestigation());
					dgresultheader.setResultType(dgSample.getInvestigation()
							.getInvestigationType());

					String resultSeqNo = "";
					Map<String, Object> diagMap = new HashMap<String, Object>();
					resultSeqNo = generateResultNumber(diagMap);
					if (resultSeqNo != "") {
						dgresultheader.setResultNo(resultSeqNo);
					}
					hbt.save(dgresultheader);
				}

				//

				if (i2 == 1) {
					String sample_No = patientMainInfo.getSampleNo();
					
					 * patientInfoList
					 * =session.createCriteria(PatientLabInfo.class
					 * ).add(Restrictions
					 * .eq("SampleNo",sample_No)).add(Restrictions.eq("TDate",
					 * sample_val_date)).add(Restrictions.eqProperty("SampleNo",
					 * "PatientMainLabInfo.SampleNo"
					 * )).addOrder(Order.desc("Id")).setMaxResults(18).list();
					 
					String query = "select * from patient_lab_info mli "
							+ " left outer join patient_main_lab_info pmli on pmli.sample_no=mli.sample_no "
							+ " where mli.sample_no='" + sampleno
							+ "' and mli.t_date='" + sample_val_date
							+ "' and  pmli.sample_no='" + sampleno
							+ "' and pmli.t_date='" + sample_val_date + "'";
					//

					patientInfoList = session.createSQLQuery(query).list();
					for (Object[] patientLabInfoList : patientInfoList) {
						labMachineXt2000iDetailsList = session
								.createCriteria(LabMachineXt2000iDetails.class)
								.add(Restrictions
										.eq("MachineCode", machineName)).list();
						int param = 1;
						for (LabMachineXt2000iDetails labMachineXt2000iDetails : labMachineXt2000iDetailsList) {
							if (param == 1
									&& labMachineXt2000iDetails
											.getParameterName().equals("WBC")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										//
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(107);
													dgResultEntryDetails
															.setNormal(nv);
													dgnormalValue = session
															.createCriteria(
																	DgNormalValue.class)
															.add(Restrictions
																	.eq("SubInvestigation",
																			subInvestigation))
															.add(Restrictions
																	.eq("Sex",
																			dgSample.getSampleCollectionHeader()
																					.getHin()
																					.getSex()
																					.getAdministrativeSexCode()))
															.list();
													for (DgNormalValue dgNormal : dgnormalValue) {
														dgResultEntryDetails
																.setNormal(dgNormal);
													}
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 2
									&& labMachineXt2000iDetails
											.getParameterName().equals("RBC")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(109);
													dgResultEntryDetails
															.setNormal(nv);

													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); } }
													 }
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 3
									&& labMachineXt2000iDetails
											.getParameterName().equals("HGB")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(106);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 4
									&& labMachineXt2000iDetails
											.getParameterName().equals("HCT")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(110);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 5
									&& labMachineXt2000iDetails
											.getParameterName().equals("MCV")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);
												if (resultSeqNo != "") {

												}

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(111);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 6
									&& labMachineXt2000iDetails
											.getParameterName().equals("MCH")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(112);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 7
									&& labMachineXt2000iDetails
											.getParameterName().equals("MCHC")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(113);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 8
									&& labMachineXt2000iDetails
											.getParameterName().equals("PLT")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(114);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 9
									&& labMachineXt2000iDetails
											.getParameterName().equals("LYM%")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(115);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 10
									&& labMachineXt2000iDetails
											.getParameterName().equals("BASO%")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(116);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 11
									&& labMachineXt2000iDetails
											.getParameterName().equals("EO%")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(117);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 12
									&& labMachineXt2000iDetails
											.getParameterName().equals("EO%")) {
								// ------------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(118);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 13
									&& labMachineXt2000iDetails
											.getParameterName().equals("MXD%")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(119);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 14
									&& labMachineXt2000iDetails
											.getParameterName().equals("NEUT%")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(120);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 15
									&& labMachineXt2000iDetails
											.getParameterName().equals("RDW")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(162);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 16
									&& labMachineXt2000iDetails
											.getParameterName().equals("PDW")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(163);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal);}
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 17
									&& labMachineXt2000iDetails
											.getParameterName().equals("MPV")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();

												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(164);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							} else if (param == 18
									&& labMachineXt2000iDetails
											.getParameterName().equals("P-LCR")) {
								// -----------------------------------------------------------------------------------------
								if (patientLabInfoList[2]
										.equals(labMachineXt2000iDetails
												.getParameterName())) {
									try {
										int i = 0;
										List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
										dgSampleCollectondetail = session
												.createCriteria(
														DgSampleCollectionDetails.class)
												.add(Restrictions.eq("DiagNo",
														diagNo))
												.add(Restrictions.eq(
														"LabStatus", "n"))
												.list();
										for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
											int investigation_id = 0;
											if (dgSample.getInvestigation() != null
													&& dgSample
															.getInvestigation()
															.getId() != null) {
												investigation_id = dgSample
														.getInvestigation()
														.getId();
											}
											if (labMachineXt2000iDetails
													.getInvestigationId() == investigation_id) {
												Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
														.getInvestigation()
														.getDgSubMasInvestigations();
												int uom_id = 0;
												int inpatient_id = 0;
												int sample_collection_detailid = dgSample
														.getId();
												int sample_collection_header_id = dgSample
														.getSampleCollectionHeader()
														.getId();
												int charge_code_id = dgSample
														.getChargeCode()
														.getId();
												int hin_id = dgSample
														.getSampleCollectionHeader()
														.getHin().getId();
												if (dgSample
														.getSampleCollectionHeader()
														.getInpatient() != null)
													inpatient_id = dgSample
															.getSampleCollectionHeader()
															.getInpatient()
															.getId();
												int department_id = dgSample
														.getSampleCollectionHeader()
														.getDepartment()
														.getId();
												int hospital_id = dgSample
														.getSampleCollectionHeader()
														.getHospital().getId();
												int sub_charge_code_id = dgSample
														.getSubcharge().getId();
												int main_charge_code_id = dgSample
														.getMaincharge()
														.getId();
												String investigation_type = dgSample
														.getInvestigation()
														.getInvestigationType();
												if (dgSample.getInvestigation()
														.getUom() != null)
													uom_id = dgSample
															.getInvestigation()
															.getUom().getId();
												String resultSeqNo = "";
												Map<String, Object> diagMap = new HashMap<String, Object>();
												resultSeqNo = generateResultNumber(diagMap);

												List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
												dg_result_header = session
														.createQuery(
																"select max(dh.id) from DgResultEntryHeader dh")
														.list();
												Iterator itr = dg_result_header
														.iterator();
												int headerId = 0;
												while (itr.hasNext()) {
													headerId = (Integer) itr
															.next();
												}
												DgResultEntryHeader header = (DgResultEntryHeader) hbt
														.load(DgResultEntryHeader.class,
																headerId);
												DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
												dgResultEntryDetails
														.setResultEntry(header);
												dgResultEntryDetails
														.setChargeCode(dgSample
																.getChargeCode());
												dgResultEntryDetails
														.setResultType(investigation_type);
												BigDecimal result = new BigDecimal(
														0);
												if (labMachineXt2000iDetails
														.getParameterName()
														.equals("WBC")
														|| labMachineXt2000iDetails
																.getParameterName()
																.equals("PLT")) {
													result = (new BigDecimal(
															""
																	+ patientLabInfoList[3]));
													String result1 = ""
															+ result;
													result = result
															.multiply(new BigDecimal(
																	1000));
													int result12 = result
															.intValue();
													dgResultEntryDetails
															.setResult(""
																	+ result12);
												} else {
													dgResultEntryDetails
															.setResult(""
																	+ patientLabInfoList[3]);
												}
												dgResultEntryDetails
														.setUom(dgSample
																.getInvestigation()
																.getUom());
												dgResultEntryDetails
														.setInvestigation(dgSample
																.getInvestigation());
												int sub_invest_id = 0;
												if (labMachineXt2000iDetails
														.getSubInvestigationId() != null) {
													sub_invest_id = labMachineXt2000iDetails
															.getSubInvestigationId();
												}
												DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
														.load(DgSubMasInvestigation.class,
																sub_invest_id);
												dgResultEntryDetails
														.setResultDetailStatus("P");
												dgResultEntryDetails
														.setSampleCollectionDetails(dgSample);
												List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
												if (investigation_type
														.equalsIgnoreCase("m")) {
													dgResultEntryDetails
															.setSubInvestigation(subInvestigation);
													DgNormalValue nv = new DgNormalValue();
													nv.setId(165);
													dgResultEntryDetails
															.setNormal(nv);
													
													 * dgnormalValue=session.
													 * createCriteria
													 * (DgNormalValue
													 * .class).add(
													 * Restrictions.eq
													 * ("SubInvestigation"
													 * ,subInvestigation
													 * )).add(Restrictions
													 * .eq("Sex",dgSample.
													 * getSampleCollectionHeader
													 * ().getHin().getSex().
													 * getAdministrativeSexCode
													 * ())).list();
													 * for(DgNormalValue
													 * dgNormal:dgnormalValue) {
													 * dgResultEntryDetails
													 * .setNormal(dgNormal); }
													 
												}
												hbt.save(dgResultEntryDetails);
												dataAdded = true;
												updatedSuccessfully = true;
											}
										}
									} catch (HibernateException he) {
										he.printStackTrace();
									}
								}
							}
							param++;
						}
					}
					if (dataAdded == true) {
						try {
							List<DgSampleCollectionDetails> dgSampleCollectondetail = session
									.createCriteria(
											DgSampleCollectionDetails.class)
									.add(Restrictions.eq("DiagNo",
											patientMainInfo.getDiagNo()))
									.add(Restrictions.eq("LabStatus", "n"))
									.list();
							for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
								dgSample.setLabStatus("y");
								hbt.update(dgSample);
							}
							List<PatientMainLabInfo> patientmain = new ArrayList<PatientMainLabInfo>();
							patientmain = session
									.createCriteria(PatientMainLabInfo.class)
									.add(Restrictions.eq("DiagNo",
											patientMainInfo.getDiagNo()))
									.add(Restrictions.eq("Status", "y"))
									.add(Restrictions.eq("MachineCode",
											machineName.toUpperCase()))
									.add(Restrictions.eq("TDate",
											sample_val_date)).list();
							for (PatientMainLabInfo maininfolist : patientmain) {
								maininfolist.setStatus("V");
								hbt.update(maininfolist);
							}
						} catch (HibernateException e) {
							e.printStackTrace();
						}
					}
				}
				i2++;
			}//
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return updatedSuccessfully;
	}*/

	public boolean checkDiagnosisNoDetails(String diagnosisNo) {

		List<PatientMainLabInfo> nameList = new ArrayList<PatientMainLabInfo>();
		boolean status = false;
		Session session = (Session) getSession();
		nameList = session.createCriteria(PatientMainLabInfo.class)
				.add(Restrictions.eq("DiagNo", diagnosisNo)).list();
		if (nameList.size() > 0) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	public Map<String, Object> fillPatientLabDetail(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		@SuppressWarnings("unused")
		String diagnosisNo = "";
		try {
			diagnosisNo = (String) map.get("diagnosisNo");
			Criteria c = session
					.createCriteria(DgSampleCollectionDetails.class).add(
							Restrictions.eq("DiagNo", diagnosisNo));
			patientList = c.list();
			map.put("patientList", patientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	public List<PatientMainLabInfo> findSampleNo() {

		List<PatientMainLabInfo> nameList = new ArrayList<PatientMainLabInfo>();
		Session session = (Session) getSession();
		nameList = session.createCriteria(PatientMainLabInfo.class)
				.add(Restrictions.eq("Status", "y")).list();

		return nameList;
	}

	public Map<String, Object> LabResultValidateDetails(String sampleNo,
			String fromdate, String machineName) {

		Session session = (Session) getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<PatientMainLabInfo> patientMainlabInfo = new ArrayList<PatientMainLabInfo>();
		List<PatientLabInfo> patientlabInfo = new ArrayList<PatientLabInfo>();
		List<LabMachineXt2000iDetails> labMachinextList = new ArrayList<LabMachineXt2000iDetails>();
		List<DgMasInvestigation> dgMasInvestigation = new ArrayList<DgMasInvestigation>();
		List<DgSubMasInvestigation> dgMasSubInvestigation = new ArrayList<DgSubMasInvestigation>();
		List<DgSampleCollectionDetails> dgMasSamplecollection = new ArrayList<DgSampleCollectionDetails>();

		try {
			patientlabInfo = session.createCriteria(PatientLabInfo.class)
					.add(Restrictions.eq("SampleNo", sampleNo))
					.add(Restrictions.eq("TDate", fromdate))
					.add(Restrictions.eq("MachineCode", machineName)).list();

			patientMainlabInfo = session
					.createCriteria(PatientMainLabInfo.class)
					.add(Restrictions.eq("SampleNo", sampleNo)).list();

			labMachinextList = session.createCriteria(
					LabMachineXt2000iDetails.class).list();

			dgMasInvestigation = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.or(
							Restrictions.eq("InvestigationType", "s"),
							Restrictions.eq("InvestigationType", "m")))
					.add(Restrictions.eq("Status", "y")).list();

			dgMasSubInvestigation = session.createCriteria(
					DgSubMasInvestigation.class).list();
			String DiagnoNo = "";
			for (PatientMainLabInfo mainlabinfo : patientMainlabInfo) {
				DiagnoNo = mainlabinfo.getDiagNo();
			}
			dgMasSamplecollection = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("DiagNo", DiagnoNo)).list();
			detailsMap.put("dgMasSamplecollection", dgMasSamplecollection);
			detailsMap.put("patientMainlabInfo", patientMainlabInfo);
			detailsMap.put("patientlabInfo", patientlabInfo);
			detailsMap.put("labMachinextList", labMachinextList);
			detailsMap.put("dgMasInvestigation", dgMasInvestigation);
			detailsMap.put("dgMasSubInvestigation", dgMasSubInvestigation);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public List<PatientMainLabInfo> checkSampleNo(String fromDate,
			String machineName) {
		List<PatientMainLabInfo> nameList = new ArrayList<PatientMainLabInfo>();
		Session session = (Session) getSession();
		nameList = session.createCriteria(PatientMainLabInfo.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("MachineCode", machineName))
				.add(Restrictions.eq("TDate", fromDate)).list();

		return nameList;
	}

	public boolean addAnalyserResult(Box box) {
		boolean dataAdded = false;
		int i = 0;
		Vector diagnosticNo = box.getVector(RequestConstants.DIAGNOSIS_NO);
		Vector investigationid = box
				.getVector(RequestConstants.INVESTIGATION_ID);
		Vector subInvestigationid = box
				.getVector(RequestConstants.SUB_INVESTIGATION_ID);
		Vector measurementvalue = box
				.getVector(RequestConstants.MEASUREMENT_VALUE);
		Vector createdBy = box.getVector(RequestConstants.CHANGED_BY);
		Vector createdDate = box.getVector(RequestConstants.CHANGED_DATE);
		Vector createdTime = box.getVector(RequestConstants.CHANGED_TIME);
		Vector res_date = box.getVector(RequestConstants.FROM_DATE);
		Vector result_time = box.getVector(RequestConstants.TIME);
		String result_date = res_date.lastElement().toString().substring(3, 5)
				+ "/" + res_date.lastElement().toString().substring(0, 2) + "/"
				+ res_date.lastElement().toString().substring(6);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int length = diagnosticNo.size();
		for (i = 0; i < length; i++) {
			String diagNo = "";
			int investId = 0;
			int sub_invest_id = 0;
			String measurement_value = "";
			if (diagnosticNo.get(i).toString() != null
					&& !diagnosticNo.get(i).toString().equals("")) {
				diagNo = (String) diagnosticNo.get(i);

				if (investigationid.get(i).toString() != null
						&& !investigationid.get(i).toString().equals("")) {
					investId = Integer.parseInt(investigationid.get(i)
							.toString());
				}
				if (subInvestigationid.get(i).toString() != null
						&& !subInvestigationid.get(i).toString().equals("")) {
					sub_invest_id = Integer.parseInt(subInvestigationid.get(i)
							.toString());
				}
				if (measurementvalue.get(i).toString() != null
						&& !measurementvalue.get(i).toString().equals("")) {
					measurement_value = measurementvalue.get(i).toString();
				}
				Session session = (Session) getSession();
				List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();
				dgSampleCollectondetail = session
						.createCriteria(DgSampleCollectionDetails.class)
						.add(Restrictions.eq("DiagNo", diagNo)).list();
				for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
					int investigation_id = 0;
					investigation_id = dgSample.getInvestigation().getId();
					if (investId == investigation_id) {
						Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample
								.getInvestigation().getDgSubMasInvestigations();
						int uom_id = 0;
						int inpatient_id = 0;
						int sample_collection_detailid = dgSample.getId();
						int sample_collection_header_id = dgSample
								.getSampleCollectionHeader().getId();
						int charge_code_id = dgSample.getChargeCode().getId();
						int hin_id = dgSample.getSampleCollectionHeader()
								.getHin().getId();
						if (dgSample.getSampleCollectionHeader().getInpatient() != null)
							inpatient_id = dgSample.getSampleCollectionHeader()
									.getInpatient().getId();
						int department_id = dgSample
								.getSampleCollectionHeader().getDepartment()
								.getId();
						int hospital_id = dgSample.getSampleCollectionHeader()
								.getHospital().getId();
						int validated_By = dgSample.getSampleCollectionHeader()
								.getValidatedBy().getId();
						int sub_charge_code_id = dgSample.getSubcharge()
								.getId();
						int main_charge_code_id = dgSample.getMaincharge()
								.getId();
						String investigation_type = dgSample.getInvestigation()
								.getInvestigationType();
						if (dgSample.getInvestigation().getUom() != null)
							uom_id = dgSample.getInvestigation().getUom()
									.getId();
						int test_order_no = dgSample.getInvestigation()
								.getTestOrderNo();

						DgResultEntryHeader dgresultheader = new DgResultEntryHeader();
						dgresultheader.setMainChargecode(dgSample
								.getMaincharge());
						dgresultheader
								.setSubChargecode(dgSample.getSubcharge());

						dgresultheader.setResultDate(new Date(result_date));
						dgresultheader.setResultTime(result_time.lastElement()
								.toString());
						dgresultheader.setEmployee(dgSample
								.getSampleCollectionHeader().getValidatedBy());
						dgresultheader.setResultStatus("P");
						// dgresultheader.setLastChgdBy(createdBy.lastElement().toString());
						dgresultheader.setLastChgdDate(new Date(createdDate
								.lastElement().toString()));
						dgresultheader.setLastChgdTime(createdTime
								.lastElement().toString());
						dgresultheader.setSampleCollectionHeader(dgSample
								.getSampleCollectionHeader());
						dgresultheader.setHin(dgSample
								.getSampleCollectionHeader().getHin());
						dgresultheader.setInpatient(dgSample
								.getSampleCollectionHeader().getInpatient());
						dgresultheader.setDepartment(dgSample
								.getSampleCollectionHeader().getDepartment());
						dgresultheader.setHospital(dgSample
								.getSampleCollectionHeader().getHospital());
						dgresultheader.setTestOrderNo(dgSample
								.getInvestigation().getTestOrderNo());
						dgresultheader.setInvestigation(dgSample
								.getInvestigation());
						String resultSeqNo = "";
						Map<String, Object> diagMap = new HashMap<String, Object>();
						resultSeqNo = generateResultNumber(diagMap);
						if (resultSeqNo != "") {
							dgresultheader.setResultNo(resultSeqNo);
						}
						hbt.save(dgresultheader);
						List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
						dg_result_header = session
								.createQuery(
										"select max(dh.id) from DgResultEntryHeader dh")
								.list();
						Iterator itr = dg_result_header.iterator();
						int headerId = 0;
						while (itr.hasNext()) {
							headerId = (Integer) itr.next();
						}
						DgResultEntryHeader header = (DgResultEntryHeader) hbt
								.load(DgResultEntryHeader.class, headerId);

						DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
						dgResultEntryDetails.setResultEntry(header);
						dgResultEntryDetails.setChargeCode(dgSample
								.getChargeCode());
						dgResultEntryDetails.setResultType(investigation_type);
						dgResultEntryDetails.setResult(measurement_value);
						dgResultEntryDetails.setUom(dgSample.getInvestigation()
								.getUom());
						dgResultEntryDetails.setInvestigation(dgSample
								.getInvestigation());
						DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
								.load(DgSubMasInvestigation.class,
										sub_invest_id);
						dgResultEntryDetails.setResultDetailStatus("P");
						dgResultEntryDetails
								.setSampleCollectionDetails(dgSample);

						List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
						if (investigation_type.equalsIgnoreCase("m")) {
							dgResultEntryDetails
									.setSubInvestigation(subInvestigation);
							dgnormalValue = session
									.createCriteria(DgNormalValue.class)
									.add(Restrictions.eq("SubInvestigation",
											subInvestigation))
									.add(Restrictions.eq("Sex", dgSample
											.getSampleCollectionHeader()
											.getHin().getSex()
											.getAdministrativeSexCode()))
									.list();
							for (DgNormalValue dgNormal : dgnormalValue) {

								dgResultEntryDetails.setNormal(dgNormal);
							}

						}

						hbt.save(dgResultEntryDetails);
						List<PatientMainLabInfo> patientmain = new ArrayList<PatientMainLabInfo>();
						patientmain = session
								.createCriteria(PatientMainLabInfo.class)
								.add(Restrictions.eq("DiagNo", diagNo)).list();
						for (PatientMainLabInfo maininfolist : patientmain) {
							maininfolist.setStatus("V");
							hbt.update(maininfolist);
						}
					}
					dataAdded = true;
				}

			}
		}
		return dataAdded;

	}

	public String generateResultNumber(Map<String, Object> diagMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> resultSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String resultSeqNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
		String month = "";
		String year = "";
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		resultSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RES")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (resultSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : resultSeqNoList) {
				TransactionSequence obj = (TransactionSequence) resultSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				resultSeqNo = resultSeqNo.concat(String.valueOf(seqNo));
				resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
				resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
			}
		} else if (resultSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgResultEntryHeader");
			tsObj.setTransactionPrefix("RES");
			tsObj.setTransactionSequenceName("Result No");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
			hbt.refresh(tsObj);
		}
		return resultSeqNo;
	}

	@Override
	public boolean invalidateAnalyserResult(String diagNo) {
		boolean status = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		List<PatientMainLabInfo> patientmain = new ArrayList<PatientMainLabInfo>();
		patientmain = session.createCriteria(PatientMainLabInfo.class)
				.add(Restrictions.eq("DiagNo", diagNo)).list();
		for (PatientMainLabInfo maininfolist : patientmain) {
			maininfolist.setStatus("R");
			hbt.update(maininfolist);
			status = true;
		}
		return status;
	}

	public boolean mergeDataXl300(String date, String date1) {
		boolean mergedata = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		// String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Session session = (Session) getSession();
		String query = "select distinct pat_id from xl_300_table_temp "
				+ " where Result_Date='" + date1 + "' " + " order by Pat_Id";

		List<String> xldataList = new ArrayList<String>();
		xldataList = session.createSQLQuery(query).list();
		int pat1 = 0;
		String patientId = "";

		for (String pat : xldataList) {
			patientId = pat;

			List<Xl300TableTemp> objectList = new ArrayList<Xl300TableTemp>();
			objectList = session
					.createCriteria(Xl300TableTemp.class)
					.add(Restrictions.eq("ResultDate",
							HMSUtil.convertStringTypeDateToDateType(date)))
					.add(Restrictions.eq("PatId", pat)).setMaxResults(1).list();

			/*
			 * String
			 * queryForTopPat="select  * from xl_300_table_temp where Result_Date='"
			 * +date+"' and Pat_Id='"+pat+"'";
			 * objectList=session.createSQLQuery(
			 * queryForTopPat).setMaxResults(1).list();
			 */PatientMainLabInfo mainLab = new PatientMainLabInfo();
			for (Xl300TableTemp obj : objectList) {
				mainLab.setSampleNo(obj.getRoundNo());
				mainLab.setStatus("n");
				mainLab.setMachineCode("XL-300");
				mainLab.setTDate(date);
				mainLab.setTime(time);
				hbt.save(mainLab);
			}
			String queryFOrSaveDatainMain = "select * from xl_300_table_temp where Result_Date='"
					+ date + "' and Pat_Id='" + pat + "'";
			List<Xl300TableTemp> objectList2 = new ArrayList<Xl300TableTemp>();
			// objectList2=session.createSQLQuery(queryFOrSaveDatainMain).list();
			objectList2 = session
					.createCriteria(Xl300TableTemp.class)
					.add(Restrictions.eq("ResultDate",
							HMSUtil.convertStringTypeDateToDateType(date)))
					.add(Restrictions.eq("PatId", pat)).list();

			for (Xl300TableTemp obj2 : objectList2) {
				PatientLabInfo labInfo = new PatientLabInfo();
				labInfo.setSampleNo(obj2.getRoundNo());
				labInfo.setParameterName(obj2.getChemName());
				labInfo.setMeasurementValue(obj2.getResult());
				labInfo.setUnit(obj2.getUnit());
				labInfo.setTDate(date);

				labInfo.setMachineCode("XL-300");
				hbt.save(labInfo);
			}
		}
		return mergedata;
	}

	@Override
	public Map<String, Object> showinvestigationForLabIntegeration(
			String machineName) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DgMasInvestigation> invList = new ArrayList<DgMasInvestigation>();
		List<DgSubMasInvestigation> subInvestList = new ArrayList<DgSubMasInvestigation>();
		invList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("Status", "y").ignoreCase())
				//.add(Restrictions.eq("MachineName", machineName).ignoreCase())//changed for EM360 machine
				.addOrder(Order.asc("InvestigationName"))
				.list();
		subInvestList = session.createCriteria(DgSubMasInvestigation.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("SubInvestigationName"))
				.list();
		
		//added by govind 02-06-2017
		List<LabMachineXt2000iDetails> labMachine360List = new ArrayList<LabMachineXt2000iDetails>();		
		labMachine360List = session.createCriteria(LabMachineXt2000iDetails.class)
				.add(Restrictions.eq("MachineCode", machineName).ignoreCase())//changed for EM360 machine
				.list();
		
		System.out.println("labMachine360List impl "+labMachine360List.size());
		map.put("labMachine360List", labMachine360List);
		//added by govind 02-06-2017 end
		map.put("invList", invList);
		map.put("subInvestList", subInvestList);
		//
		return map;
	}

	@Override
	public Map<String, Object> getResultEntryDetailsForLabOrderStatusNew(
			int dgResultEntryHeaderLabId, Integer deptId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList1 = new ArrayList<DgResultEntryDetail>();
		Session session = (Session) getSession();
		int sampleId = 0;
		List<DgResultEntryHeader> dgResultHeaderList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultHeaderList2 = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> dgResultHeaderListLoop = new ArrayList<DgResultEntryHeader>();
		dgResultHeaderList = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Id", dgResultEntryHeaderLabId)).list();
		dgResultHeaderList2 = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Id", dgResultEntryHeaderLabId))
				.setMaxResults(1).list();
		for (DgResultEntryHeader sr : dgResultHeaderList) {
			dgResultdetailList1 = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", sr.getId())).list();
			for (DgResultEntryDetail dd : dgResultdetailList1) {
				sampleId = dd.getSampleCollectionDetails()
						.getSampleCollectionHeader().getId();
			}
		}
		//
		dgResultHeaderListLoop = session
				.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("SampleCollectionHeader.Id", sampleId))
				.list();
		for (DgResultEntryHeader sdr : dgResultHeaderListLoop) {
			dgResultdetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", sdr.getId())).list();
			dgResultdetailList1 = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", sdr.getId()))
					.setMaxResults(1).list();
		}
		List<Integer> IdList = new ArrayList<Integer>();
		String Id = "";
		String s = "";
		List<Integer> ia = new ArrayList<Integer>();
		for (DgResultEntryHeader der : dgResultHeaderListLoop) {
			//
			s = s.concat("" + der.getId()).concat(",");
			IdList.add(der.getId());
			ia.add(der.getId());
		}
		//
		//
		s = s.substring(0, s.length() - 1);
		//

		List<DgResultEntryDetail> detailList1 = new ArrayList<DgResultEntryDetail>();
		detailList1 = session.createCriteria(DgResultEntryDetail.class)
				.add(Restrictions.in("ResultEntry.Id", ia))
				.add(Restrictions.eq("ResultDetailStatus", "A"))
				.add(Restrictions.eq("Investigation.Id", 1081)).list();
		//
		/*
		 * String query=
		 * "select result from dg_result_entry_detail where result_entry_id in("
		 * +s+")";
		 * 
		 * List<Object[]>resultList=new ArrayList<Object[]>();
		 * //resultList=session.createSQLQuery(query).list();
		 * List<DgResultEntryDetail>detailList=new
		 * ArrayList<DgResultEntryDetail>(); for(int i=0;i<=IdList.size();i++){
		 * 
		 * detailList=session.createCriteria(DgResultEntryDetail.class).add(
		 * Restrictions.eq("ResultEntry.Id", IdList.get(i))).list(); }
		 */
		map.put("dgResultdetailList", detailList1);

		map.put("resultList", dgResultHeaderList2);
		return map;
	}

	@Override
	public Map<String, Object> getChargeCodeDetails1(String chargeCodeName,
			int hinId) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		Criteria crit = null;
		Session session = (Session) getSession();

		try {
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeName", chargeCodeName))
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
					map.put("patientTypeId", patientTypeId);
				}
				if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					map.put("companyId", companyId);
				}
				if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					map.put("regType", regType);
				}

			}
			map.put("chargeId", chargeId);
			map.put("mainChargeId", mainChargeId);
			map.put("subChargeId", subChargeId);
			map.put("billTypeId", 2);
			map.put("patientCategory", "IP");
			map = getChargeAmountAfterDiscount(map);
			if (patientList.size() > 0 && chargeCodeList.size() > 0) {
				map.put("chargeCodeList1", chargeCodeList);
			}
			map.put("chargeId", chargeId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public boolean savePhysioIP(IpPhysioReqHeader ipph) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(ipph);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public boolean saveDialysisIP(IpDialysisReqHeader ipph) {

		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(ipph);
		successfullyAdded = true;
		return successfullyAdded;
	}

	public List<MasHospital> getAllHospital() {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		hospitalList = (List<MasHospital>) session
				.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		return hospitalList;
	}

	@Override
	public Map<String, Object> getSampleForHistopatologyTestState(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		String patientFName = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String pType = "";
		String diagNo = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		int deptId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		String orderStatus = "";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		} else {
			fromDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		} else {
			toDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("diagNo") != null) {
			diagNo = (String) mapForDs.get("diagNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get("orderStatus") != null) {
			orderStatus = mapForDs.get("orderStatus").toString();
		}
		int orderId = 0;
		if (mapForDs.get("orderId") != null) {
			orderId = (Integer) mapForDs.get("orderId");
		}
		try {
			System.out.println("orderStatus controller  ------>>"+orderStatus);
			String arr[]={"A","P","a","p"};
			crit = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.in("OrderStatus", arr))
					.add(Restrictions
							.between("DiagnosisDate", fromDate, toDate))
					.createAlias("Hin", "pt"); 
			if (!pType.equals("")) {
				crit = crit.createAlias("Order", "o").add(
						Restrictions.eq("o.PatientType", pType));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName+ "%").ignoreCase());
			}
			if (deptId != 0) {
				crit = crit.createAlias("Department", "dep").add(
						Restrictions.eq("dep.Id", deptId));
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("SubChargeid", "sc").add(
						Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeId != 0) {
				crit = crit.createAlias("ChargeCode", "ch").add(
						Restrictions.eq("ch.Id", chargeCodeId));
			}
			if (!wardName.equals("")) {
				crit = crit.createAlias("Inpatient.Department", "depName").add(
						Restrictions.eq("depName.DepartmentName", wardName));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}

			if (barCode != 0) {
				List<DgSampleCollectionHeader> patientDeatilListByBarCode = new ArrayList<DgSampleCollectionHeader>();
				patientDeatilListByBarCode = crit.list();
				for (DgSampleCollectionHeader collectionHeader : patientDeatilListByBarCode) {
					boolean flag = false;
					Set<DgSampleCollectionDetails> collectionDetails = collectionHeader
							.getDgSampleCollectionDetails();
					for (DgSampleCollectionDetails details : collectionDetails) {
						if (barCode.toString().equals(details.getDiagNo())
								&& "P".equalsIgnoreCase(details
										.getOrderStatus())) {
							patientDeatilList.add(collectionHeader);
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
			} else {
				patientDeatilList = crit.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		List<DgSampleCollectionHeader> mainCollectionHeadersList=new ArrayList<DgSampleCollectionHeader>();
		for(DgSampleCollectionHeader collectionHeader:patientDeatilList){
			Set<DgHistoSampleCollectionDetails> histocollectionDetails=collectionHeader.getDgHistoSampleCollectionDetails();
			for(DgHistoSampleCollectionDetails collectionDetails:histocollectionDetails){
				if(orderStatus.equalsIgnoreCase(collectionDetails.getOrderStatus()) && "N".equalsIgnoreCase(collectionDetails.getLabStatus())){
					mainCollectionHeadersList.add(collectionHeader);
					break;
				}
			} 	
		}
		map.put("patientDeatilList", mainCollectionHeadersList);
		return map;
	}

	@Override
	public Map<String, Object> getPatientDetailsForGrossingInHisto(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader> patientDeatilList = new ArrayList<DgSampleCollectionHeader>();
		String patientFName = "";
		String hinNo = "";
		String adNo = "";
		Date fromDate = new Date();
		Date toDate = new Date();
		String pType = "";
		String diagNo = "";
		int hinId = 0;
		int subGroupId = 0;
		int chargeCodeId = 0;
		int deptId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		Integer barCode = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("pType") != null) {
			pType = (String) mapForDs.get("pType");
		}
		if (mapForDs.get("diagNo") != null) {
			diagNo = (String) mapForDs.get("diagNo");
		}
		if (mapForDs.get("subGroupId") != null) {
			subGroupId = (Integer) mapForDs.get("subGroupId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("departmentId") != null) {
			deptId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		int orderId = 0;
		if (mapForDs.get("orderId") != null) {
			orderId = (Integer) mapForDs.get("orderId");
		}
		try {
			crit = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("OrderStatus", "G"))
					.add(Restrictions
							.between("DiagnosisDate", fromDate, toDate))
					.createAlias("Hin", "pt");

			if (!pType.equals("")) {
				crit = crit.createAlias("Order", "o").add(
						Restrictions.eq("o.PatientType", pType));
			}
			/*
			 * if (!diagNo.equals("")) { crit =
			 * crit.add(Restrictions.eq("DiagnosisNo", diagNo)); }
			 */
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName+ "%").ignoreCase());
			}
			if (deptId != 0) {
				crit = crit.createAlias("Department", "dep").add(
						Restrictions.eq("dep.Id", deptId));
			}
			if (subGroupId != 0) {
				crit = crit.createAlias("SubChargeid", "sc").add(
						Restrictions.eq("sc.Id", subGroupId));
			}
			if (chargeCodeId != 0) {
				crit = crit.createAlias("ChargeCode", "ch").add(
						Restrictions.eq("ch.Id", chargeCodeId));
			}
			if (!wardName.equals("")) {
				crit = crit.createAlias("Inpatient.Department", "depName").add(
						Restrictions.eq("depName.DepartmentName", wardName));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}

			if (barCode != 0) {
				List<DgSampleCollectionHeader> patientDeatilListByBarCode = new ArrayList<DgSampleCollectionHeader>();
				patientDeatilListByBarCode = crit.list();
				for (DgSampleCollectionHeader collectionHeader : patientDeatilListByBarCode) {
					boolean flag = false;
					Set<DgSampleCollectionDetails> collectionDetails = collectionHeader
							.getDgSampleCollectionDetails();
					for (DgSampleCollectionDetails details : collectionDetails) {
						if (barCode.toString().equals(details.getDiagNo())
								&& "G".equalsIgnoreCase(details
										.getOrderStatus())) {
							patientDeatilList.add(collectionHeader);
							flag = true;
							break;
						}
					}
					if (flag)
						break;
				}
			} else {
				patientDeatilList = crit.list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		return map;
	}

	@Override
	public Map<String, Object> getSampleDetailsForHisto(int orderId, int uid,
			int deptId) {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
		List<Users> usersList = new ArrayList<Users>();
		List<DgSampleCollectionHeader> samplehdList = new ArrayList<DgSampleCollectionHeader>();
		Session session = (Session) getSession();
		int hinId = 0;
		try {
			usersList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Id", uid)).list();
			Users user = usersList.get(0);
			int empid = user.getEmployee().getId();
			detailsMap.put("empid", empid);
			employeeCodeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", 45))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (employeeCodeList.size() > 0) {
				detailsMap.put("employeeCodeList", employeeCodeList);
			}

			samplehdList = session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Id", orderId)).list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientDeatilList", patientList);
			}
			if (samplehdList != null || samplehdList.size() > 0) {
				detailsMap.put("samplehdList", samplehdList);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;

	}

	@Override
	public DgHistoSampleCollectionDetails getSampleDetailsOfHistoById(
			int orderId) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();

		return (DgHistoSampleCollectionDetails) hbt.get(
				DgHistoSampleCollectionDetails.class, orderId);

	}

	@Override
	public boolean saveDetailsOfHisto(
			Set<String> priviousHistoId,
			Map<Integer, DgHistoSampleCollectionDetails> oldHistoMapOfPriviousStep,
			Map<Integer, List<DgHistoSampleCollectionDetails>> dgHistoMap) {
		Session session = (Session) getSession();
		boolean flag = false;
		org.hibernate.Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (String key : priviousHistoId) {
				List<DgHistoSampleCollectionDetails> dgHistoList = dgHistoMap
						.get(Integer.parseInt(key));
				DgHistoSampleCollectionDetails priviousObj = oldHistoMapOfPriviousStep
						.get(Integer.parseInt(key));
				if (priviousObj != null) {
					hbt.update(priviousObj);
					hbt.refresh(priviousObj);
				}
				if (dgHistoList != null && dgHistoList.size() > 0) {
					for (DgHistoSampleCollectionDetails dgHistoObject : dgHistoList) {
						if (dgHistoObject != null) {
							hbt.save(dgHistoObject);
							hbt.refresh(dgHistoObject);
						}

					}
				}
			}
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	@Override
	public boolean saveOrUpdateAnyObject(Object object) {
		Session session = (Session) getSession();
		boolean flag = false;
		org.hibernate.Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.saveOrUpdate(object);
			transaction.commit();
			flag = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	@Override
	public List<NursingcareSetup> getNursingcareSetupList(Box box) {
		Session session = (Session) getSession();
		List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();

		nursingCareSetupList = session.createCriteria(NursingcareSetup.class)
				.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
				.add(Restrictions.eq("Hospital.Id", box.getInt(HOSPITAL_ID)))
				.list();
		return nursingCareSetupList;
	}

	@Override
	public synchronized Map<String, Object> saveBulkOrderBooking(Box box,
			Map<String, Object> utilMap) {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		int chargeListLength = 0;
		int patientListLength = 0;
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List sampleDetailIdList = new ArrayList();
		List orderDetailIdList = new ArrayList();
		List deptCodeList = new ArrayList();
		List deptIdList = new ArrayList();
		BigDecimal totalCost = new BigDecimal(0);
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String clinicalNote = "";
		String orderSeqNo = "";
		String orderStatus = "";
		String urgentDetails = "";
		String message = "";
		String mobileNo="";
		String address="";
		String idNO="";
		int hospitalId = Integer.parseInt(utilMap.get(
				RequestConstants.HOSPITAL_ID).toString());
		int departmentId = Integer.parseInt(utilMap.get(
				RequestConstants.DEPT_ID).toString());
		Users user = (Users) utilMap.get(RequestConstants.USERS);
		int userId = Integer.parseInt(utilMap.get(RequestConstants.USER_ID)
				.toString());
		String userName = utilMap.get(RequestConstants.USER_NAME).toString();
		MasHospital masHospital = new MasHospital();
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		masHospital.setId(hospitalId);
		DgBulkOrderRequisition bulkOrderRequisition = new DgBulkOrderRequisition();
		MasHospital institute = new MasHospital();
		institute.setId(Integer.parseInt(box.get(RequestConstants.INSTITUTION)
				.toString()));
		bulkOrderRequisition.setInstitute(institute);
		bulkOrderRequisition.setRemark(box.get(RequestConstants.REMARKS));
		bulkOrderRequisition.setOrderBy(user);
		bulkOrderRequisition
				.setOrderDate(HMSUtil.getCurrentDateAndTimeObject());
		bulkOrderRequisition.setOrderTime(time);
		bulkOrderRequisition.setOrderType("BULK");
		if (box.get("hiddenPatientdetails") != null) {
			patientListLength = Integer.parseInt(box
					.get("hiddenPatientdetails"));
		}
		boolean saved = false;
		Session session = (Session) getSession();
		session.save(bulkOrderRequisition);
		List<MasPatientType> patientTypeList = session
				.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		MasPatientType masPatientType = null;
		for (MasPatientType obj : patientTypeList) {
			if ("PUDN".equalsIgnoreCase(obj.getPatientTypeCode())) {
				masPatientType = (MasPatientType) obj;
				break;
			}
		}
		// org.hibernate.Transaction tx = null;
		try {
			// tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int patientNo = 1; patientNo <= patientListLength; patientNo++) {
				ArrayList visitNoSequenceList = new ArrayList();
				ArrayList visitIdSequenceList = new ArrayList();
				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setHospital(masHospital);
				Patient patient = new Patient();
				patient.setPatientType(masPatientType);
				patient.setPatientStatus("Out Patient");
				patient.setAddEditBy(user);
				patient.setAddEditTime(time);
				patient.setAddEditDate(HMSUtil.getCurrentDateAndTimeObject());
				patient.setRegDate(HMSUtil.getCurrentDateAndTimeObject());
				patient.setRegTime(time);
				Visit visit = null;
				String hinNo = null;
				String age = "0";
				patient.setPFirstName(box.get("patientName" + patientNo));
				patient.setFullName(box.get("patientName" + patientNo));
				if (box.get("patientAge" + patientNo) != null
						&& box.get("patientAge" + patientNo).trim() != "") {
					age = box.get("patientAge" + patientNo);
				}
				patient.setAge(age + " " + "Years");
				int year=Integer.parseInt(age);
				Date todayDate = new Date();
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String strDate = sdf.format(todayDate);
				Date parsedDate = sdf.parse(date);
				Calendar now = Calendar.getInstance();
				now.setTime(parsedDate);
				now.add(Calendar.YEAR, -year);
				now.getTime();
				patient.setDateOfBirth(now.getTime());;
				MasAdministrativeSex masSex = new MasAdministrativeSex();
				masSex.setId(box.getInt("patientGender" + patientNo));
				patient.setSex(masSex);
				patient.setHospital(masHospital);
				patient.setMobileNumber(box.get("mobileNo"+patientNo));
				String idType=box.get("idType"+patientNo);
				if("ADHAR".equals(idType)){
					patient.setAadhaarNo(box.getLong(("idNo"+patientNo)));
					infoMap.put("addressStatus", true);
					infoMap.put("aadhaarNo", box.get(("idNo"+patientNo)));
				}else if(!"0".equals(idType)){
					List<MasIdCard> masIdCard=session.createCriteria(MasIdCard.class)
							.add(Restrictions.eq("IdCardCode", idType)).list();
					if(masIdCard.size()>0){
						patient.setIdCard(masIdCard.get(0));
					}
					patient.setIdNo(box.get(("idNo"+patientNo)));
				}
				if (box.get(HIN_NO + patientNo) != null
						&& box.get(HIN_NO + patientNo).trim() != "") {
					hinNo = box.get(HIN_NO + patientNo);
				} else {
					PatientAddress pAadhaarAddr = new PatientAddress();
					PatientAddress pPermAddr = new PatientAddress();
					PatientAddress pTempAddr = new PatientAddress();
					pPermAddr.setAddress(box.get("address"+patientNo)); 
					infoMap.put("patient", patient);
					infoMap.put("pAadhaarAddr", pAadhaarAddr);
					infoMap.put("pPermAddr", pPermAddr);
					infoMap.put("pTempAddr", pTempAddr); 
					map = registrationDataService
							.submitPatientInformation(infoMap);
					hinNo = (String) map.get("hinNo");
				}
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put(HIN_NO, hinNo);
				dataMap.put(HOSPITAL_ID, hospitalId);
				dataMap.put(RequestConstants.DEPT_ID, departmentId);
				List<Visit> visitNoList = getVisitNo(dataMap);
				if (visitNoList.size() > 0) {
					for (Visit vi : visitNoList) {
						int previousVisitNo = vi.getVisitNo();
						visitNoSequenceList.add(previousVisitNo);
						visitIdSequenceList.add(vi.getId());
						patient.setId(vi.getHin().getId());
					}
					int visitId = 0;
					if (visitNoSequenceList.size() > 0) {
						visitId = (Integer) Collections
								.max(visitIdSequenceList);
					}

					visit.setId(visitId);

				} else {
					visit = new Visit();
					visit.setHin(patient);
					visit.setDoctor(user.getEmployee());
					visit.setVisitDate(HMSUtil.getCurrentDateAndTimeObject());
					visit.setVisitTime(time);
					visit.setDepartment(masDepartment);
					visit.setHospital(masHospital);
					Map<String, Object> billingDetailsMap = new HashMap<String, Object>();
					BlOpBillHeader blOpBillHeader = new BlOpBillHeader();
					BlOpBillDetails blOpBillDetails = new BlOpBillDetails();
					List<Integer> tokenNoList = new ArrayList<Integer>();
					int visitSessionId=0;
					/*int tokenNo = registrationDataService
							.getTokenNoForDepartment(departmentId, hospitalId,visitSessionId);
*/                        
					int tokenNo=0;
					visit.setTokenNo(tokenNo + 1);
					visit.setVisitNo(1);
					visit.setAddEditBy(user);
					visit.setAddEditDate(HMSUtil.getCurrentDateAndTimeObject());
					visit.setAddEditTime(time);
					visit.setStatus("y");
					visit.setEdStatus("n");
					visit.setVisitStatus("C");
					visit.setAppointmentType("D");

					blOpBillHeader.setChangedBy(user);
					blOpBillHeader.setBillDate(HMSUtil
							.getCurrentDateAndTimeObject());
					blOpBillHeader.setBillTime(time);
					blOpBillHeader.setConsultant(user.getEmployee());
					blOpBillHeader.setHospital(masHospital);
					blOpBillHeader.setPatientStatus("r");

					blOpBillDetails.setChangedBy(user);
					blOpBillDetails.setBillDate(HMSUtil
							.getCurrentDateAndTimeObject());
					blOpBillDetails.setBillTime(time);

					billingDetailsMap.put("userObj", user);
					billingDetailsMap.put("billDate",
							HMSUtil.getCurrentDateAndTimeObject());
					billingDetailsMap.put("billTime", time);
					billingDetailsMap.put("masHospital", masHospital);

					String receiptNo = opBillingDataService
							.generateReceiptNo("save",hospitalId);
					billingDetailsMap.put("receiptNo", receiptNo);

					infoMap.put("visit", visit);
					infoMap.put("patient", patient);
					infoMap.put("blOpBillHeader", blOpBillHeader);
					infoMap.put("blOpBillDetails", blOpBillDetails);
					infoMap.put("billingDetailsMap", billingDetailsMap);
					infoMap.put("hinId", patient.getId());
					infoMap.put("departmentId", departmentId);
					infoMap.put("currentVisitNo", 1);

					registrationDataService.saveVisitInformation(infoMap);

				}
				masDepartment.setId(departmentId);
				String temp = generateOrderNumber();
				dgOrderhd.setPrescribedBy(user.getEmployee());
				dgOrderhd.setDepartment(masDepartment);
				clinicalNote = box.get(RequestConstants.CLINICAL_NOTE
						+ patientNo);
				orderSeqNo = getOrderSeqForDisplay("ON");
				dgOrderhd.setHin(patient);
				dgOrderhd.setVisit(visit);
				dgOrderhd.setOrderNo(orderSeqNo);
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setNetAmount(totalCost);
				dgOrderhd.setClinicalNote(clinicalNote);
				dgOrderhd.setOrderDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				dgOrderhd.setOrderTime(time);
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLastChgBy(user);
				dgOrderhd.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				dgOrderhd.setLastChgTime(time);
				dgOrderhd.setRoutineUrgentStatus("r");
				dgOrderhd.setUrgentRemarks(urgentDetails);
				dgOrderhd.setBulkOrder(bulkOrderRequisition);
				if (box.get("hiddenValueCharge") != null) {
					chargeListLength = Integer.parseInt(box
							.get("hiddenValueCharge"));
				}
				for (int a = 1; a <= chargeListLength; a++) {
					if (box.get(CHARGE_CODE_ID + a) != null
							&& !box.get(CHARGE_CODE_ID + a).equals("")) {
						chargeList.add(box.get(CHARGE_CODE_ID + a));

					}
					if (box.get(QUANTITY + a) != null
							&& !box.get(QUANTITY + a).equals("")) {
						qtyList.add(box.get(QUANTITY + a));
					} else {
						qtyList.add("1");
					}
					if (box.get(AMOUNT + a) != null
							&& !box.get(AMOUNT + a).equals("")) {
						amountList.add(box.get(AMOUNT + a));
					} else {
						amountList.add("");
					}

					if (box.get(MAIN_CHARGECODE_ID + a) != null) {
						mainChargeList.add(box.get(MAIN_CHARGECODE_ID + a));
					} else {
						mainChargeList.add("");
					}
					if (box.get(SUB_CHARGECODE_ID + a) != null) {
						subChargeList.add(box.get(SUB_CHARGECODE_ID + a));
					} else {
						subChargeList.add("");
					}
					if (box.get(SAMPLE_COLLECTION_DETAIL_ID + a) != null) {
						sampleDetailIdList.add(box
								.get(SAMPLE_COLLECTION_DETAIL_ID + a));
					} else {
						sampleDetailIdList.add("");
					}
					if (box.get(DG_ORDER_DETAIL_ID + a) != null) {
						orderDetailIdList.add(box.get(DG_ORDER_DETAIL_ID + a));
					} else {
						orderDetailIdList.add("");
					}
					if (box.get(DEPARTMENT_TYPE_CODE + a) != null
							&& !box.get(DEPARTMENT_TYPE_CODE + a).equals("")) {
						deptCodeList.add(box.get(DEPARTMENT_TYPE_CODE + a));
					} else {
						deptCodeList.add("");
					}
					if (box.get(DEPARTMENT_ID + a) != null
							&& !box.get(DEPARTMENT_ID + a).equals("0")) {
						deptIdList.add(box.get(DEPARTMENT_ID + a));
					} else {
						deptIdList.add("");
					}
				}
				infoMap.put("dgOrderhd", dgOrderhd);
				infoMap.put("hospitalId", hospitalId);
				infoMap.put("hinId", patient.getId());
				infoMap.put("orderSeqNo", orderSeqNo);
				infoMap.put("sampleDetailIdList", sampleDetailIdList);
				infoMap.put("userName", userName);
				infoMap.put("userId", userId);
				infoMap.put("chargeList", chargeList);
				infoMap.put("mainChargeList", mainChargeList);
				infoMap.put("subChargeList", subChargeList);
				infoMap.put("qtyList", qtyList);
				infoMap.put("amountList", amountList);
				infoMap.put("orderDetailIdList", orderDetailIdList);
				infoMap.put("deptCodeList", deptCodeList);
				infoMap.put("deptIdList", deptIdList);
				infoMap.put(RequestConstants.USERS, user);
				resultMap = submitOrderBookingForInvestigation(box, infoMap);
				infoMap.clear();
				chargeList.clear();
				mainChargeList.clear();
				subChargeList.clear();
				orderDetailIdList.clear();
				deptCodeList.clear();
				deptIdList.clear();
				sampleDetailIdList.clear();

			}
			// tx.commit();
			saved = true;
		} catch (Exception e) {
			// if (tx != null)
			// tx.rollback();
			e.printStackTrace();
			saved = false;
		}
		map.put("saved", saved);
		map.put("orderSeqNo", orderSeqNo);
		return map;
	}

	// Lab Integration Code With Machine End 08 Feb 2011 by Ramdular
	// Prajapati
	// ------

	/*
	 * private Patient patientsRegistrationOnBulkOrderBooking(Session session,
	 * HibernateTemplate hbt, int patientNo, Patient patient) { String hinNo;
	 * List<Object> existingHinNoList = new ArrayList<Object>(); int tsn = 0;
	 * int id = 0; List<Object[]> adList = session
	 * .createCriteria(TransactionSequence.class)
	 * .add(Restrictions.eq("TransactionPrefix", "HIN")) .setProjection(
	 * Projections .projectionList() .add(Projections
	 * .property("TransactionSequenceNumber"))
	 * .add(Projections.property("Id"))).list();
	 * 
	 * if (adList.size() > 0) { Object[] transactionSequence = adList.get(0);
	 * tsn = Integer.parseInt("" + transactionSequence[0]); id = (Integer)
	 * transactionSequence[1]; }
	 * 
	 * TransactionSequence transactionSequenceObj = (TransactionSequence)
	 * session .load(TransactionSequence.class, id);
	 * transactionSequenceObj.setTransactionSequenceNumber(tsn + 1); hinNo = ""
	 * + (tsn + 1);
	 * 
	 * existingHinNoList = session .createSQLQuery(
	 * "select hin_no from patient where hin_no = :hinNo")
	 * .setParameter("hinNo", hinNo).list(); if (existingHinNoList != null &&
	 * existingHinNoList.size() > 0) { List<Object> objectList = (List<Object>)
	 * session.createSQLQuery( "select max(hin_no+1) from patient").list(); if
	 * (objectList != null && objectList.size() > 0) { hinNo =
	 * Integer.toString((new BigDecimal(objectList.get(0)
	 * .toString())).intValue());
	 * transactionSequenceObj.setTransactionSequenceNumber(Integer
	 * .parseInt(hinNo)); } } if (patient != null) { patient.setHinNo(hinNo);
	 * int patientId = (Integer) hbt.save(patient);
	 * System.out.println("Check Id   " + patientNo);
	 * 
	 * PatientAddress pAadhaarAddr = new PatientAddress();
	 * pAadhaarAddr.setHin(patient); hbt.save(pAadhaarAddr);
	 * 
	 * PatientAddress pPermAddr = new PatientAddress();
	 * pPermAddr.setHin(patient); hbt.save(pPermAddr);
	 * 
	 * PatientAddress pTempAddr = new PatientAddress();
	 * pTempAddr.setHin(patient); hbt.save(pTempAddr);
	 * hbt.update(transactionSequenceObj);
	 * System.out.println("patient UHID NO.............. " + hinNo);
	 * System.out.println("patient hinId NO.............. " + patientId);
	 * session.clear(); } return patient; }
	 */

	@Override
	public Map<String, Object> getInvestigationDetailsForDischargeSummary(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DgResultEntryHeader> invResultList = new ArrayList<DgResultEntryHeader>();
		List<PatientInvestigationDetails> patientInvestigationList = new ArrayList<PatientInvestigationDetails>();
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		int inpatientId = (Integer) detailsMap.get("inPatientId");
		Session session = (Session) getSession();

		patientInvestigationList = (List<PatientInvestigationDetails>) session
				.createCriteria(PatientInvestigationDetails.class)
				.createAlias("InvestigationHeader", "ih")
				.add(Restrictions.eq("ih.Inpatient.Id", inpatientId))
				.addOrder(Order.desc("Id")).list();
		/*
		 * if (patientInvestigationHeaderList != null &&
		 * patientInvestigationHeaderList.size() > 0) {
		 * patientInvestigationHeader = patientInvestigationHeaderList.get(0);
		 * map.put("patientInvestigationHeader",patientInvestigationHeader);
		 * 
		 * }
		 */

		invResultList = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		dgResultEntryDetailList = session
				.createCriteria(DgResultEntryDetail.class, "dgred")
				.createAlias("dgred.ResultEntry", "dgreh")
				.add(Restrictions.eq("dgred.Validated", "v").ignoreCase())
				.add(Restrictions.eq("dgred.ResultDetailStatus", "a")
						.ignoreCase()).createAlias("dgreh.Inpatient", "ip")
				.add(Restrictions.eq("ip.Id", inpatientId)).list();
		map.put("patientInvestigationList", patientInvestigationList);
		map.put("dgResultEntryDetailList", dgResultEntryDetailList);
		map.put("invResultList", invResultList);
		return map;
	}

	@Override
	public Set<DgMasTestKit> getAllTestsKitLab(Map<String, Object> detailsMap) {

		Session session = (Session) getSession();
		List<DgMasTestKit> kitList = session.createCriteria(DgMasTestKit.class)
				.list();
		Set<DgMasTestKit> setOfTestKit = new HashSet<DgMasTestKit>(kitList);

		return setOfTestKit;
	}

	@Override
	public boolean addTestKitInLab(Box box) {
		int kitId = 0;
		int investigationId = 0;
		if (box.get("chargeCode") != null
				&& !"".equalsIgnoreCase(box.get("chargeCode"))) {
			String testName = box.get("chargeCode");
			int index1 = testName.indexOf("[");
			int index2 = testName.indexOf("]");
			investigationId = Integer.parseInt(testName.substring(index1 + 1,
					index2));
		}
		if (box.get("testKitId") != null
				&& !"".equalsIgnoreCase(box.get("testKitId"))) {
			kitId = box.getInt("testKitId");
		}
		Session session = (Session) getSession();
		DgMasTestKit dgMasTestKit = (DgMasTestKit) session.get(
				DgMasTestKit.class, kitId);
		if (dgMasTestKit.getInvestigation() != null
				&& dgMasTestKit.getInvestigation().getId() == investigationId) {
			return false;

		} else {
			DgMasTestKit kit = new DgMasTestKit();
			kit.setKitName(dgMasTestKit.getKitName());
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt(RequestConstants.HOSPITAL_ID));
			kit.setHospital(hospital);
			Users users = new Users();
			users.setId(box.getInt(RequestConstants.USER_ID));
			kit.setLastChgBy(users);
			kit.setLastChgDate(HMSUtil.getCurrentDateAndTimeObject());
			Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
					.getCurrentDateAndTime();
			kit.setLastChgTime((String) utilMap.get("currentTime"));
			DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
			dgMasInvestigation.setId(investigationId);
			kit.setInvestigation(dgMasInvestigation);
			session.save(kit);
			return true;
		}

	}

	private void billingForSampleCollectionDiag(int hospitalId, int hinId,
			String hinNo, int userId, int visitId, int orderId) {
		Session session = (Session) getSession();

		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			Patient patient = (Patient) hbt.get(Patient.class, hinId);
			Visit visit = (Visit) hbt.get(Visit.class, visitId);

			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			opBillHeader.setHospital(hospital);

			opBillHeader.setHin(patient);
			opBillHeader.setPatientStatus("r");
			opBillHeader.setHinNo(hinNo);
			opBillHeader.setVisit(visit);

			opBillHeader.setConsultant(visit.getDoctor());
			opBillHeader.setPatientType(patient.getPatientType());
			opBillHeader.setPatientName(patient.getPFirstName());

			opBillHeader.setSex(patient.getSex());
			if (visit.getDoctor() != null) {
				opBillHeader.setConsultantName(visit.getDoctor()
						.getEmployeeName());
			}
			opBillHeader.setBillAmt(new BigDecimal(0));
			opBillHeader.setDiscountAmt(new BigDecimal(0));
			opBillHeader.setRoundOff(new BigDecimal(0));
			opBillHeader.setNetAmt(new BigDecimal(0));
			opBillHeader.setAdvanceAdjustment(new BigDecimal(0));
			opBillHeader.setOutstanding(new BigDecimal(0));
			opBillHeader.setDiscountOnBill(new BigDecimal(0));
			opBillHeader.setPayableAmt(new BigDecimal(0));
			opBillHeader.setActualCollectedAmt(new BigDecimal(0));
			opBillHeader.setBillDate(HMSUtil
					.convertStringTypeDateToDateType((String) utilMap
							.get("currentDate")));
			opBillHeader.setBillTime((String) utilMap.get("currentTime"));
			Users users = new Users();
			users.setId(userId);
			opBillHeader.setChangedBy(users);
			opBillHeader.setStatus("y");
			// hbt.save(opBillHeader);

			String billNo = "";
			String billType = "OS";
			billNo = opBillingDataService.generateBillNo(billType, "save",hospitalId);
			opBillHeader.setBillNo(billNo);

			DgOrderhd dgOrderhd = (DgOrderhd) hbt.get(DgOrderhd.class, orderId);
			dgOrderhd.setBillChargeSlpNo(billNo);
			Set<DgOrderdt> dgOrderdts = new HashSet<DgOrderdt>();
			dgOrderdts = dgOrderhd.getDgOrderdts();

			Iterator<DgOrderdt> iterator = dgOrderdts.iterator();

			while (iterator.hasNext()) {
				DgOrderdt dgOrderdt = (DgOrderdt) iterator.next();
				if (dgOrderdt.getBill() == null) {
					BlOpBillDetails opBillDetail = new BlOpBillDetails();
					MasChargeCode masChargeCode = new MasChargeCode();

					opBillDetail.setChargeCode(dgOrderdt.getChargeCode());
					BigDecimal rate = new BigDecimal(0);
					opBillDetail.setRate(rate);

					BigDecimal amount = new BigDecimal(0);
					opBillDetail.setAmount(amount);

					BigDecimal discountPercent = new BigDecimal(0);
					opBillDetail.setDiscountPercent(discountPercent);

					BigDecimal discount = new BigDecimal(0);
					opBillDetail.setDiscountAmt(discount);

					BigDecimal proportionalDiscount = new BigDecimal(0);
					opBillDetail
							.setProportionalDiscountAmount(proportionalDiscount);

					BigDecimal netAmount = new BigDecimal(0);
					opBillDetail.setNetAmt(netAmount);

					opBillDetail.setQuantity(1);

					opBillDetail.setBillDate(HMSUtil
							.convertStringTypeDateToDateType((String) utilMap
									.get("currentDate")));
					opBillDetail.setBillTime((String) utilMap
							.get("currentTime"));
					opBillDetail.setChangedBy(users);
					opBillDetail.setOpBillHeader(opBillHeader);

					try {
						hbt.save(opBillHeader);
						hbt.save(opBillDetail);
						opBillDetail.setRefundableStatus("y");
						dgOrderdt.setPaymentMade("y");
						dgOrderdt.setBill(opBillHeader);
						hbt.saveOrUpdate(dgOrderdt);
						hbt.update(dgOrderhd);
					} catch (DataAccessException e) {
						e.printStackTrace();
					}
				}
			}
			hbt.flush();
			hbt.clear();

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> showDiagnosticRegisterSummaryJsp(
			Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Object[]> chargeCodeList = new ArrayList<Object[]>();

		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}

		/*
		 * subChargeCodeList = session.createCriteria(MasSubChargecode.class)
		 * .add(Restrictions.eq("Status", "y")).createAlias( "MainChargecode",
		 * "mcc").createAlias( "mcc.Department", "dep").add(
		 * Restrictions.eq("dep.Id", deptId)).list();
		 */
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("SubChargecodeName")).list();
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeCode", "DIAG").ignoreCase())
				.addOrder(Order.asc("DepartmentName")).list();
		chargeCodeList = session
				.createCriteria(DgMasInvestigation.class)
				.createAlias("SubChargecode", "sc")
				.createAlias("MainChargecode", "mcc")
				.createAlias("mcc.Department", "d")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("Id"))
								.add(Projections.property("InvestigationName"))
								.add(Projections.property("d.Id"))
								.add(Projections.property("sc.Id")))
				.addOrder(Order.asc("InvestigationName")).list();
		if (subChargeCodeList.size() > 0) {
			map.put("subChargeCodeList", subChargeCodeList);
		}
		if (departmentList.size() > 0) {
			map.put("departmentList", departmentList);
		}
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}
	@Override
	public Map<String, Object> getDiagnosticSummary(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> diagnosticRegisterList = new ArrayList<Object[]>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate =sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(RequestConstants.FROM_DATE)));
		String toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(box.getString(RequestConstants.TO_DATE)));
	/*	Date fromDate =HMSUtil.convertStringTypeDateToDateType(box.getString(FROM_DATE));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString(TO_DATE));*/
		String subQry = "";
		if(box.getInt(DEPARTMENT_ID)!=0) {
			subQry += " and mcc.department_id="+box.getInt(DEPARTMENT_ID);
		}
		if(box.getInt(SUB_CHARGECODE_ID)!=0) {
			subQry += " and inv.sub_chargecode_id="+box.getInt(SUB_CHARGECODE_ID);
		}
		if(box.getInt(INVESTIGATION_ID)!=0) {
			subQry += " and inv.investigation_id="+box.getInt(INVESTIGATION_ID);
		}
		System.out.println(" subQry "+ subQry);
		String qry ="select distinct (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where inpatient_id is null and dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
				" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) op ," +
				" (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where inpatient_id is not null and dghe.investigation_id=dgh.investigation_id " +
				" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' and " +
				" dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) ip ," +
				" (select count(*) from  dg_result_entry_detail red " +
				" inner join dg_result_entry_header dghe on red.RESULT_ENTRY_ID=dghe.RESULT_ENTRY_ID " +
				" where  dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
				" between '"+fromDate+"' and '"+toDate+"' and dghe.hospital_id ="+box.getInt("hospitalId")+
				" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) total," +
				" investigation_name,scc.sub_chargecode_name,mcc.main_chargecode_name" +
				" from dg_result_entry_detail dgd inner join dg_result_entry_header dgh on dgd.RESULT_ENTRY_ID=dgh.RESULT_ENTRY_ID" +
				" left join dg_mas_investigation inv on dgh.INVESTIGATION_ID=inv.INVESTIGATION_ID" +
				" left join mas_main_chargecode mcc on inv.MAIN_CHARGECODE_ID = mcc.MAIN_CHARGECODE_ID" +
				" left join mas_sub_chargecode scc on inv.SUB_CHARGECODE_ID = scc.SUB_CHARGECODE_ID" +
				" where dgh.result_date between '"+fromDate+"' and '"+toDate+"' and dgh.hospital_id ="+box.getInt("hospitalId")+
				" "+subQry+
				" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";
		
		/*String qry ="select distinct (select count(*) from  dg_result_entry_header dghe" +
		" where inpatient_id is null and dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
		" between '"+fromDate+"' and '"+toDate+"'" +
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) op ," +
		" (select count(*)from  dg_result_entry_header dghe"+
		" where inpatient_id is not null and dghe.investigation_id=dgh.investigation_id " +
		" and dghe.result_date between '"+fromDate+"' and '"+toDate+"' "+
	//	" dghe.hospital_id ="+box.getInt("hospitalId")+
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) ip ," +
		" (select count(*) from  dg_result_entry_header dghe " +
		" where  dghe.investigation_id=dgh.investigation_id and dghe.result_date " +
		" between '"+fromDate+"' and '"+toDate+"'"+ //and dghe.hospital_id ="+box.getInt("hospitalId")+
		" group by dghe.investigation_id,dghe.sub_chargecode_id,dghe.main_chargecode_id) total," +
		" investigation_name,scc.sub_chargecode_name,mcc.main_chargecode_name" +
		" from dg_result_entry_detail dgd inner join dg_result_entry_header dgh on dgd.RESULT_ENTRY_ID=dgh.RESULT_ENTRY_ID" +
		" left join dg_mas_investigation inv on dgh.INVESTIGATION_ID=inv.INVESTIGATION_ID" +
		" left join mas_main_chargecode mcc on inv.MAIN_CHARGECODE_ID = mcc.MAIN_CHARGECODE_ID" +
		" left join mas_sub_chargecode scc on inv.SUB_CHARGECODE_ID = scc.SUB_CHARGECODE_ID" +
		" where dgh.result_date between '"+fromDate+"' and '"+toDate+"' "+ //and dgh.hospital_id ="+box.getInt("hospitalId")+
		" "+subQry+
		" order by mcc.main_chargecode_name,scc.sub_chargecode_name,investigation_name";*/

		diagnosticRegisterList = session.createSQLQuery(qry).list();	
		
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.idEq(box.getInt("hospitalId"))).list();
		map.put("hospitalList", hospitalList);
		map.put("diagnosticRegisterList", diagnosticRegisterList);
	  return map;
	}
	@Override
	public Map<String, Object> getHospName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		
		hospitalNameList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",hospitalId)).list();
		map.put("hospitalNameList", hospitalNameList);
		return map;
	}
	@Override
	public Map<String, Object> getDiagnosticRegisterForMultipleTestType(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		List<String> subChargeList = new ArrayList<String>();
		List<String> testNameList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> confidentialList = new ArrayList<String>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("depart") != null) {
			depart = (Integer) mapForDs.get("depart");
		}
		if (mapForDs.get("patient") != null) {
			patient = (String) mapForDs.get("patient");
		}
		if (mapForDs.get("resultType") != null) {
			resultType = (String) mapForDs.get("resultType");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryHeader> dgMultipleResultdetailList = new ArrayList<DgResultEntryHeader>();

		Session session = (Session) getSession();
		Criteria crit = null;
		/*crit = session.createCriteria(DgResultEntryHeader.class).createAlias(
				"SampleCollectionHeader", "sch").createAlias("sch.Order",
				"orderN").add(Restrictions.eq("ResultStatus", "A"))
				.createAlias("MainChargecode", "mcc").createAlias(
						"DgMasInvestigation", "inv").add(
						Restrictions.eq("inv.InvestigationType", "m")).add(
						Restrictions.eq("mcc.MainChargecodeCode", "Lab")).add(
						Restrictions.between("ResultDate", fromDate, toDate));

		if (subChargeId != 0) {
			crit = crit.createAlias("SubChargecode", "subChg");
			crit = crit.add(Restrictions.eq("subChg.Id", subChargeId));
		}
		if (depart != 0) {
			crit = crit.createAlias("orderN.Department", "dep");
			crit = crit.add(Restrictions.eq("dep.Id", depart));
		}
		if (!patient.equals("")) {
			crit = crit.add(Restrictions.eq("orderN.PatientType", patient));
		}
		
		 * if(!resultType.equals("")){ crit =
		 * crit.add(Restrictions.eq("ResultType", resultType)); }
		 
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "departmentId");
			crit = crit.add(Restrictions.eq("departmentId.Id", departmentId));
		}

		dgMultipleResultdetailList = crit.list();*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Box box = (Box)mapForDs.get("box");
		String qry ="select distinct dgh from DgResultEntryHeader dgh "+
				" left join dgh.DgResultEntryDetails dgd "+
				" left join dgh.SampleCollectionHeader sch"+
				" left join dgh.Hin p" +
				" left join sch.Order dgorder"+
				" left join dgorder.Visit v"+
				" left join dgorder.PrescribedBy pb" +
				" left join dgh.Employee emp"+
				" left join dgh.ResultVerifiedBy rvb"+
				" left join dgh.Investigation inv"+
				" left join inv.MainChargecode mcc"+
				" left join dgorder.Department dep"+
				" left join p.Sex x"+
				" left join dgh.SubChargecode scc"+
				" left join dgorder.Hospital hsp"+
				" left join dgd.SampleCollectionDetails scd"+
				" left join p.Unit ut"+
				" left join inv.Uom um"+ 
				" where dgh.ResultDate between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
				" and dgh.ResultStatus in ('A','R') and dgd.ResultType = '"+resultType+"' and dgh.Hospital.Id="+hospitalId;
		
		/*String qry ="select distinct dgh from DgResultEntryHeader dgh"+
					" left join dgh.DgResultEntryDetails dgd"+
					" left join dgh.SampleCollectionHeader sch"+
					" left join dgh.Hin p" +
					" left join sch.Order dgorder"+
					" left join dgh.MainChargecode mcc"+
					" left join dgh.Investigation inv"+
					" where dgh.ResultDate between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
					" and dgh.ResultStatus in('A','R') and mcc.MainChargecodeCode='Lab' and inv.InvestigationType='m'";*/
	
		if (subChargeId != 0) {
				qry += " and dgh.SubChargecode.Id = "+subChargeId;
		}
		if (depart != 0) {
			qry += " and dgorder.Department.Id = "+depart;
		}
		if(box.getInt(RequestConstants.MARITAL_STATUS_ID)!=0){
//			crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
			qry += " and p.MaritalStatus.Id = "+box.getInt(RequestConstants.MARITAL_STATUS_ID);
		}
		if(box.getInt(RequestConstants.SEX_ID)!=0 ){
//			crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
			qry += " and p.Sex.Id = "+box.getInt(RequestConstants.SEX_ID);
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			float fromAge =Float.parseFloat(box.getString("fromAge"));
			float toAge = Float.parseFloat(box.getString("toAge"));
			String fromUnit=box.getString("fromAgeUnit");
			String toUnit=box.getString("toAgeUnit");
			if(box.getString("fromAgeUnit").equalsIgnoreCase("Months")){
				fromAge=fromAge/12;
			}else if(box.getString("fromAgeUnit").equalsIgnoreCase("Days")){
				fromAge=fromAge/365;
			}
			if(box.getString("toAgeUnit").equalsIgnoreCase("Months")){
				toAge=toAge/12;
			}else if(box.getString("toAgeUnit").equalsIgnoreCase("Days")){
				toAge=toAge/365;
			}
			 /*qry += " and substr(p.Age,0,INSTR(p.Age,' ')) >="+fromAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("fromAgeUnit")+"'" +
					" and substr(p.Age,0,INSTR(p.Age,' ')) <="+toAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("toAgeUnit")+"'";*/
			qry += " and (substr(v.Age,0,STRPOS(v.Age,' '))<>'') and (case when v.Age like '%Years%' then cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float) "
					+ "when  v.Age like '%Months%' then ((cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float))/(12)) "
					+ "when  v.Age like '%Days%' then ((cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float))/(365)) end) >="+fromAge+" " +
					" and  (case when v.Age like '%Years%' then cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float) "
					+ "when  v.Age like '%Months%' then ((cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float))/(12)) "
					+ "when  v.Age like '%Days%' then ((cast(substr(v.Age,0,STRPOS(v.Age,' ')) as float))/(365)) end)<="+toAge;
		
		}
		/*if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			 qry +="  p.ServiceYears >="+fromServ+" " +
					" and  TotalServicePeriod='"+box.getString("fromServUnit")+"'" +
					" and p.ServiceYears <="+toServ+" " +
					" and  TotalServicePeriod='"+box.getString("toServUnit")+"'";
		}*/
		if(box.getInt(RequestConstants.CONSULTING_DOCTOR)!=0 ){
		//	qry += " and visit.doctor_id = "+box.getInt(CONSULTING_DOCTOR)+"";
		}
		dgMultipleResultdetailList = session.createQuery(qry).list();
		
		DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
		if (dgMultipleResultdetailList != null
				&& dgMultipleResultdetailList.size() > 0) {

			dgResultEntryDetailForData = dgMultipleResultdetailList.get(0)
					.getDgResultEntryDetails().iterator().next();
		}

		if (dgMultipleResultdetailList != null
				&& dgMultipleResultdetailList.size() > 0) {
			detailsMap.put("dgMultipleResultdetailList",
					dgMultipleResultdetailList);
			detailsMap.put("hinNo", dgResultEntryDetailForData.getResultEntry()
					.getHin().getHinNo());
            if(dgResultEntryDetailForData.getResultEntry().getSampleCollectionHeader().getOrder().getDepartment()!=null)
            {
			detailsMap.put("orderByDepartment", dgResultEntryDetailForData
					.getResultEntry().getSampleCollectionHeader()
					.getOrder().getDepartment().getDepartmentName());
            }
			Patient p = dgResultEntryDetailForData.getResultEntry()
					.getHin();

			String pFullName = "";
			pFullName = p.getPFirstName();

			if (p.getPMiddleName() != null) {
				pFullName = pFullName + " " + p.getPMiddleName();
			}
			if (p.getPLastName() != null) {
				pFullName = pFullName + " " + p.getPLastName();
			}

			detailsMap.put("patientName", pFullName);


			detailsMap.put("orderNo", dgResultEntryDetailForData
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderNo());

			detailsMap.put("orderDate", dgResultEntryDetailForData
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderDate());


			detailsMap.put("patientAge", p.getAge());

			detailsMap.put("sex", p.getSex().getAdministrativeSexName());

			detailsMap.put("resultDate", dgResultEntryDetailForData
					.getResultEntry().getResultDate());


			detailsMap
					.put("subChargeCodeName", dgResultEntryDetailForData
							.getResultEntry().getSubChargecode()
							.getSubChargecodeName());

			detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
					.getResultEntry().getMainChargecode()
					.getMainChargecodeName());

			detailsMap.put("remarks", dgResultEntryDetailForData.getRemarks());

			detailsMap.put("charge", dgResultEntryDetailForData
					.getInvestigation().getInvestigationName());
			String patientType = dgResultEntryDetailForData
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getPatientType();
			if (patientType.equalsIgnoreCase("IP")) {
				detailsMap.put("patientType", "In Patient");
			} else {
				detailsMap.put("patientType", "Out Patient");
			}
			
			// DgResultEntryDetail dgResultEntryDetail =
			// dgResultdetailList.get(0);

			String confidential = dgResultEntryDetailForData.getInvestigation()
					.getConfidential();
			if (confidential != null && !confidential.equals("")
					&& !confidential.equalsIgnoreCase("n")) {
				detailsMap.put("confidential", "y");
			} else {
				detailsMap.put("confidential", "n");
			}

			MasEmployee e = dgResultEntryDetailForData.getResultEntry()
					.getSampleCollectionHeader().getOrder().getPrescribedBy();
			if (e != null) {

				if (e.getFirstName() != null) {
					dFirst = e.getFirstName();
				}
				if (e.getMiddleName() != null) {
					dMiddleName = e.getMiddleName();
				}
				if (e.getLastName() != null) {
					dLastName = e.getLastName();
				}
				detailsMap.put("doctorName", dFirst + " " + dMiddleName + " "
						+ dLastName);
			}

			MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
					.getEmployee();
			if (e1 != null) {

				if (e1.getFirstName() != null) {
					eFirst = e1.getFirstName();
				}
				if (e1.getMiddleName() != null) {
					eMiddleName = e1.getMiddleName();
				}
				if (e1.getLastName() != null) {
					eLastName = e1.getLastName();
				}
				detailsMap.put("entryPersonName", eFirst + " " + eMiddleName
						+ " " + eLastName);
			}
			MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
					.getResultVerifiedBy();
			if (e2 != null) {
				if (e2.getFirstName() != null) {
					vFirst = e2.getFirstName();
				}
				if (e2.getMiddleName() != null) {
					vMiddleName = e2.getMiddleName();
				}
				if (e2.getLastName() != null) {
					vLastName = e2.getLastName();
				}
				detailsMap.put("verifiedPersonName", vFirst + " " + vMiddleName
						+ " " + vLastName);
			}
		}
		/*
		 * for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){
		 * subChargeList
		 * .add(dgResultEntryDetail.getResultEntry().getSubChargecode
		 * ().getSubChargecodeName());
		 * testNameList.add(dgResultEntryDetail.getInvestigation
		 * ().getInvestigationName());
		 * remarksList.add(dgResultEntryDetail.getRemarks()); String
		 * confidential =
		 * dgResultEntryDetail.getInvestigation().getConfidential();
		 * if(confidential != null && !confidential.equals("") &&
		 * !confidential.equalsIgnoreCase("n") ){ confidentialList.add("y");
		 * }else{ confidentialList.add("n"); } detailsMap.put("subChargeList",
		 * subChargeList); detailsMap.put("testNameList", testNameList);
		 * detailsMap.put("remarksList", remarksList);
		 * detailsMap.put("confidentialList", confidentialList); }
		 */
		List lst = new ArrayList();
		lst.add("A");
		lst.add("R");
		crit = session
				.createCriteria(DgResultEntryDetail.class)
				.createAlias("ResultEntry", "re")
				.createAlias("re.SampleCollectionHeader", "sch")
				.createAlias("sch.Order", "orderN")
			//	.add(Restrictions.eq("re.ResultStatus", "A")) commented by dipali
				.add(Restrictions.in("re.ResultStatus", lst))
				.add(Restrictions.between("re.ResultDate", fromDate, toDate))
				.createAlias("Investigation", "inv")
				.createAlias("inv.SubChargecode", "subCharg")
				.setProjection(
						Projections
								.distinct(Projections
										.projectionList()
										.add(
												Projections
														.property("subCharg.SubChargecodeName"))));
		subChargeCodeGroup = crit.list();
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
		MasHospital masHospital = (MasHospital) getHibernateTemplate().load(MasHospital.class, hospitalId);
		detailsMap.put("hospitalName",masHospital.getHospitalName());
		detailsMap.put("hospitalAddress",masHospital.getAddress());
		return detailsMap;
	}
	
	
	@Override
	public Map<String, Object> getResultEntryDetailsForMultipleResultType(
			Integer resultId, int deptId) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultHeaderId = 0;
		int fixedId = 0;
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		try {
			employeeList = session.createCriteria(MasEmployee.class).add(
					Restrictions.eq("Status", "y")).createAlias("Department",
					"dept").add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class).add(
							Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class).add(
					Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session.createCriteria(
							DgResultEntryDetail.class).add(
							Restrictions.eq("ResultEntry.Id", resultHeaderId))
							// .add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session.createCriteria(
							DgResultEntryDetailSen.class).createAlias(
							"ResultEntry", "rs").add(
							Restrictions.eq("rs.Id", resultHeaderId)).list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						
						// Code hide by amit on 15/08/2012 for Sql Injection
						/*fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");*/
						// Code updated by amit on 15/08/2012 due to Sql Injection occur
						fixedValList = session.createCriteria(DgFixedValue.class)
						.add(Restrictions.eq("SubInvestigation.Id", fixedId))
						.add(Restrictions.isNotNull("FixedValue")).list();															
						
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
	@Override
	public Map<String, Object> getDiagnosticRegister(
			Map<String, Object> mapForDs) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		Integer subChargeId = 0;
		Integer depart = 0;
		String patient = "";
		String resultType = "";
		Integer departmentId = 0;
		int hospitalId = 0;
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		List<String> subChargeList = new ArrayList<String>();
		List<String> testNameList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List<String> confidentialList = new ArrayList<String>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("depart") != null) {
			depart = (Integer) mapForDs.get("depart");
		}
		if (mapForDs.get("patient") != null) {
			patient = (String) mapForDs.get("patient");
		}
		if (mapForDs.get("resultType") != null) {
			resultType = (String) mapForDs.get("resultType");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
			
		}
		
		Box box = null;
		if (mapForDs.get("box") != null) {
			box = (Box) mapForDs.get("box");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Session session = (Session) getSession();
		Criteria crit = null;
		Criteria crit2 = null;
		String resultStatus[]=new String[]{"A","R"};
		
		crit = session.createCriteria(DgResultEntryDetail.class)
				.createAlias("ResultEntry", "resultEntryHeader")
				.createAlias("resultEntryHeader.Hospital", "hosp")
				.createAlias("resultEntryHeader.Hin", "p")
				.createAlias("resultEntryHeader.SampleCollectionHeader","sch")
				.createAlias("sch.Order", "orderN")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.in("resultEntryHeader.ResultStatus", resultStatus))
				.add(Restrictions.between("resultEntryHeader.ResultDate", fromDate, toDate));
		
		/*crit2=crit.createCriteria("orderN.Visit","v")
				//.createAlias("orderN.Visit", "v")
				;*/
		if (subChargeId != 0) {
			crit = crit.createAlias("resultEntryHeader.SubChargecode", "subChg");
			crit = crit.add(Restrictions.eq("subChg.Id", subChargeId));
		}
		if (depart != 0) {
			crit = crit.createAlias("orderN.Department", "dep");
			crit = crit.add(Restrictions.eq("dep.Id", depart));
		}
		if (!patient.equals("")) {
			crit = crit.add(Restrictions.eq("orderN.PatientType", patient));
		}
		System.out.println("subChargeId "+subChargeId);
		System.out.println("depart "+depart);
		System.out.println("resultType "+resultType);
		if (!resultType.equals("")) {
			crit = crit.add(Restrictions.eq("ResultType", resultType));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("resultEntryHeader.Department", "departmentId");
			crit = crit.add(Restrictions.eq("departmentId.Id", departmentId));
		} 
		System.out.println("departmentId "+resultType);
		if(box.getInt(RequestConstants.SEX_ID)!=0 ){
		crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(RequestConstants.SEX_ID)));
			//qry += " and p.Sex.Id = "+box.getInt(RequestConstants.SEX_ID);
		}
		
		if( box.getInt(RequestConstants.MARITAL_STATUS_ID)!=0){
		crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(RequestConstants.MARITAL_STATUS_ID)));
			
		}
		if(box.getInt(INVESTIGATION_ID)!=0 ){
			crit=crit.add(Restrictions.eq("Investigation.Id", box.getInt(INVESTIGATION_ID)));
			
		}
		crit2=crit.createCriteria("orderN.Visit","v");
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			float fromAge = (float)box.getInt("fromAge");
			float toAge = (float)box.getInt("toAge");
			String fromAgeUnit=box.getString("fromAgeUnit");
			String toAgeUnit=box.getString("toAgeUnit");
			
			if(box.getString("fromAgeUnit").equalsIgnoreCase("Months")){
				fromAge=fromAge/12;
			}else if(box.getString("fromAgeUnit").equalsIgnoreCase("Days")){
				fromAge=fromAge/365;
			}
			if(box.getString("toAgeUnit").equalsIgnoreCase("Months")){
				toAge=toAge/12;
			}else if(box.getString("toAgeUnit").equalsIgnoreCase("Days")){
				toAge=toAge/365;
			}
			
			//crit=crit.add(Restrictions.between("p.PatientAge", fromAge, toAge));
			crit2=crit2.add(Restrictions.sqlRestriction("(substr({alias}.age,0,STRPOS({alias}.age,' '))<>'') and (case when {alias}.age like '%Years%' then cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real) when  {alias}.age like '%Months%' then (cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real))/12 when  {alias}.age like '%Days%' then (cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real))/365 end) >="+fromAge+" " +"and  (case when {alias}.age like '%Years%' then cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real) when  {alias}.age like '%Months%' then (cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real))/12 when  {alias}.age like '%Days%' then (cast(substr({alias}.age,0,STRPOS({alias}.age,' ')) as real))/365 end)<="+toAge));
		
		}
		/*String qry ="select dgd from DgResultEntryDetail dgd "+
					" left join dgd.ResultEntry dgh "+
					" left join dgh.SampleCollectionHeader sch"+
					" left join dgh.Hin p" +
					" left join sch.Order dgorder"+
					" left join dgorder.PrescribedBy pb" +
					" left join dgh.Employee emp"+
					" left join dgh.ResultVerifiedBy rvb"+
					" left join dgh.Investigation inv"+
					" left join inv.MainChargecode mcc"+
					" left join dgorder.Department dep"+
					" left join p.Sex x"+
					" left join dgh.SubChargecode scc"+
					" left join dgorder.Hospital hsp"+
					" left join dgd.SampleCollectionDetails scd"+
					" left join p.Unit ut"+
					" left join inv.Uom um"+ 
					" where dgh.ResultDate between '"+sdf.format(fromDate)+"' and '"+sdf.format(toDate)+"' " +
					" and dgh.ResultStatus in ('A','R') and dgd.ResultType = '"+resultType+"' and dgh.Hospital.Id="+hospitalId;
	System.out.println("Hosp "+hospitalId);
	System.out.println("resultType "+resultType);

		if (subChargeId != 0) {
				qry += " and dgh.SubChargecode.Id = "+subChargeId;
		}
		if (depart != 0) {
			qry += " and mcc.Department.Id = "+depart;
		}
		if( box.getInt(RequestConstants.MARITAL_STATUS_ID)!=0){
//			crit = crit.createAlias("p.MaritalStatus", "ms").add(Restrictions.eq("ms.Id", box.getInt(MARITAL_STATUS_ID)));
			qry += " and p.MaritalStatus.Id = "+box.getInt(RequestConstants.MARITAL_STATUS_ID);
		}
		if(box.getInt(RequestConstants.SEX_ID)!=0 ){
//			crit = crit.createAlias("p.Sex", "sex").add(Restrictions.eq("sex.Id", box.getInt(SEX_ID)));
			qry += " and p.Sex.Id = "+box.getInt(RequestConstants.SEX_ID);
		}
		if (!(box.getString("fromAge").equals("")) && !(box.getString("fromAgeUnit").equals(""))
				&& !(box.getString("toAge").equals("")) && !(box.getString("toAgeUnit").equals(""))) {
			String fromAge = box.getString("fromAge");
			String toAge = box.getString("toAge");
			 qry += " and substr(p.Age,0,INSTR(p.Age,' ')) >="+fromAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("fromAgeUnit")+"'" +
					" and substr(p.Age,0,INSTR(p.Age,' ')) <="+toAge+" " +
					" and  substr(p.Age,INSTR(p.Age,' ')+1,length(p.Age))='"+box.getString("toAgeUnit")+"'";
		
		}
		if (!(box.getString("fromServ").equals("")) && !(box.getString("fromServUnit").equals(""))
				&& !(box.getString("toServ").equals("")) && !(box.getString("toServUnit").equals(""))) {
			String fromServ = box.getString("fromServ");
			String toServ = box.getString("toServ");
			 qry +="  p.ServiceYears >="+fromServ+" " +
					" and  TotalServicePeriod='"+box.getString("fromServUnit")+"'" +
					" and p.ServiceYears <="+toServ+" " +
					" and  TotalServicePeriod='"+box.getString("toServUnit")+"'";
			
		}
		if(box.getInt(RequestConstants.CONSULTING_DOCTOR)!=0 ){
		    qry += " and pb.Id = "+box.getInt(RequestConstants.CONSULTING_DOCTOR)+"";
		}
		if(box.getInt(INVESTIGATION_ID)!=0 ){
			qry += " and dgh.Investigation.Id = "+box.getInt(INVESTIGATION_ID);
		}
		*/
		/*if ( !(box.getString("icd").equals(""))) {
			String icd = box.getString("icd");
			 int index1=icd.lastIndexOf("[");
			  int index2=icd.lastIndexOf("]");
			   index1++;
			   String icdCode =""+icd.substring(index1, index2);
			qry += " and icd.IcdCode='"+icdCode+"'";
		
		}
		if (!(box.getString("icdNo").equals(""))) {
			qry += " and icd.IcdCode='"+box.getString("icdNo")+"'";
		}*/
		
	//	System.out.println("qry "+qry);

		dgResultdetailList = crit2.list();
		if (dgResultdetailList.size() > 0) {
			detailsMap.put("dgResultdetailList", dgResultdetailList);
			detailsMap.put("hinNo", dgResultdetailList.get(0).getResultEntry()
					.getHin().getHinNo());

			/*detailsMap.put("serviceNo", dgResultdetailList.get(0)
					.getResultEntry().getHin().getServiceNo());*/

			detailsMap.put("orderByDepartment", dgResultdetailList.get(0)
					.getResultEntry().getSampleCollectionHeader().getOrder()
					.getDepartment().getDepartmentName());
			Patient p = dgResultdetailList.get(0).getResultEntry().getHin();

			String pFullName = "";
			pFullName = p.getPFirstName();

			if (p.getPMiddleName() != null) {
				pFullName = pFullName + " " + p.getPMiddleName();
			}
			if (p.getPLastName() != null) {
				pFullName = pFullName + " " + p.getPLastName();
			}

			detailsMap.put("patientName", pFullName);


			detailsMap.put("orderNo", dgResultdetailList.get(0)
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderNo());

			detailsMap.put("orderDate", dgResultdetailList.get(0)
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getOrderDate());

		//	detailsMap.put("relationName", p.getRelation().getRelationName());

			detailsMap.put("patientAge", p.getAge());

			detailsMap.put("sex", p.getSex().getAdministrativeSexName());

			detailsMap.put("resultDate", dgResultdetailList.get(0)
					.getResultEntry().getResultDate());


			detailsMap
					.put("subChargeCodeName", dgResultdetailList.get(0)
							.getResultEntry().getSubChargecode()
							.getSubChargecodeName());

			detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
					.getResultEntry().getMainChargecode()
					.getMainChargecodeName());

			detailsMap.put("remarks", dgResultdetailList.get(0).getRemarks());

			detailsMap.put("charge", dgResultdetailList.get(0)
					.getInvestigation().getInvestigationName());
			String patientType = dgResultdetailList.get(0)
					.getSampleCollectionDetails().getSampleCollectionHeader()
					.getOrder().getPatientType();
			if (patientType.equalsIgnoreCase("IP")) {
				detailsMap.put("patientType", "In Patient");
			} else {
				detailsMap.put("patientType", "Out Patient");
			}
			DgResultEntryDetail dgResultEntryDetail = dgResultdetailList.get(0);

			String confidential = dgResultEntryDetail.getInvestigation()
					.getConfidential();
			if (confidential != null && !confidential.equals("")
					&& !confidential.equalsIgnoreCase("n")) {
				detailsMap.put("confidential", "y");
			} else {
				detailsMap.put("confidential", "n");
			}

			MasEmployee e = dgResultdetailList.get(0).getResultEntry()
					.getSampleCollectionHeader().getOrder().getPrescribedBy();
			if (e != null) {

				if (e.getFirstName() != null) {
					dFirst = e.getFirstName();
				}
				if (e.getMiddleName() != null) {
					dMiddleName = e.getMiddleName();
				}
				if (e.getLastName() != null) {
					dLastName = e.getLastName();
				}
				detailsMap.put("doctorName", dFirst + " " + dMiddleName + " "
						+ dLastName);
			}

			MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
					.getEmployee();
			if (e1 != null) {

				if (e1.getFirstName() != null) {
					eFirst = e1.getFirstName();
				}
				if (e1.getMiddleName() != null) {
					eMiddleName = e1.getMiddleName();
				}
				if (e1.getLastName() != null) {
					eLastName = e1.getLastName();
				}
				detailsMap.put("entryPersonName", eFirst + " " + eMiddleName
						+ " " + eLastName);
			}
			MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
					.getResultVerifiedBy();
			if (e2 != null) {
				if (e2.getFirstName() != null) {
					vFirst = e2.getFirstName();
				}
				if (e2.getMiddleName() != null) {
					vMiddleName = e2.getMiddleName();
				}
				if (e2.getLastName() != null) {
					vLastName = e2.getLastName();
				}
				detailsMap.put("verifiedPersonName", vFirst + " " + vMiddleName
						+ " " + vLastName);
			}
		}
		/*
		 * for(DgResultEntryDetail dgResultEntryDetail : dgResultdetailList){
		 * subChargeList
		 * .add(dgResultEntryDetail.getResultEntry().getSubChargecode
		 * ().getSubChargecodeName());
		 * testNameList.add(dgResultEntryDetail.getInvestigation
		 * ().getInvestigationName());
		 * remarksList.add(dgResultEntryDetail.getRemarks()); String
		 * confidential =
		 * dgResultEntryDetail.getInvestigation().getConfidential();
		 * if(confidential != null && !confidential.equals("") &&
		 * !confidential.equalsIgnoreCase("n") ){ confidentialList.add("y");
		 * }else{ confidentialList.add("n"); } detailsMap.put("subChargeList",
		 * subChargeList); detailsMap.put("testNameList", testNameList);
		 * detailsMap.put("remarksList", remarksList);
		 * detailsMap.put("confidentialList", confidentialList); }
		 */

		crit = session
				.createCriteria(DgResultEntryDetail.class)
				.createAlias("ResultEntry", "re")
				.createAlias("re.SampleCollectionHeader", "sch")
				.createAlias("sch.Order", "orderN")
				.add(Restrictions.eq("re.ResultStatus", "A"))
				.add(Restrictions.between("re.ResultDate", fromDate, toDate))
				.createAlias("Investigation", "inv")
				.createAlias("inv.SubChargecode", "subCharg")
				.setProjection(
						Projections
								.distinct(Projections
										.projectionList()
										.add(
												Projections
														.property("subCharg.SubChargecodeName"))));
		subChargeCodeGroup = crit.list();
		detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
		MasHospital masHospital = (MasHospital) getHibernateTemplate().load(MasHospital.class, hospitalId);
		detailsMap.put("hospitalName",masHospital.getHospitalName());
		detailsMap.put("hospitalAddress",masHospital.getAddress());
		return detailsMap;
	}

	@Override
	public Map<String, Object> viewPacsImage(Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		Date fromDate=null;
		Date toDate=null;
		String UHID=null;
		Patient patient=null;
		int hospitalId=0;
		if(box.get(FROM_DATE)!=null&&!"".equals(box.get(FROM_DATE))){
			fromDate = HMSUtil.dateFormatterDDMMYYYY(box
					.get(FROM_DATE));
		}
		if(box.get(TO_DATE)!=null&&!"".equals(box.get(TO_DATE))){
			 toDate = HMSUtil.dateFormatterDDMMYYYY(box
						.get(TO_DATE)); 	
		} 
		if(box.get("hin")!=null&&!"".equals(box.get("hin"))){
			UHID = box.get("hin"); 
		}
		if(box.get(RequestConstants.HOSPITAL_ID)!=null&&!"".equals(box.get(RequestConstants.HOSPITAL_ID))){
			hospitalId=box.getInt(RequestConstants.HOSPITAL_ID);
		}
		Criteria patientCriteria=session.createCriteria(Patient.class)
								 .add(Restrictions.eq("HinNo", UHID));
		patient=(Patient)patientCriteria.uniqueResult();
		Criteria crit=session.createCriteria(DgOrderdt.class)
						  .createAlias("Orderhd", "hd")
						  .add(Restrictions.eq("hd.Hospital.Id", hospitalId))
						  .add(Restrictions.eq("MsgSent", "y").ignoreCase());
						  //.add(Restrictions.eq("PacsStatus", "n").ignoreCase());
		if(patient!=null){
			crit=crit.add(Restrictions.eq("hd.Hin.Id", patient.getId()));
		}
		if(fromDate!=null && toDate!=null){
			crit=crit.add(Restrictions.between("hd.OrderDate", fromDate, toDate));
		}else{
			crit=crit.add(Restrictions.eq("hd.OrderDate", new Date()));
		}
		List<DgOrderdt> dgOrderdts=crit.list();
		//List<DgOrderdt>	dgOrderDtPacsList=null;
		/*try {
		 	dgOrderDtPacsList=getAckFromPackServer(dgOrderdts);
		} catch (FileNotFoundException e) {
			System.out.println("Size for new scan list>>>>>>>>>. file");
			e.printStackTrace();
		} catch (HL7Exception e) {
			System.out.println("Size for new scan list>>>>>>>>>. HL7");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Size for new scan list>>>>>>>>>. IO");
			e.printStackTrace();
		} catch (LLPException e) {
			System.out.println("Size for new scan list>>>>>>>>>. LLP");
			e.printStackTrace();
		} if(dgOrderDtPacsList!=null && dgOrderDtPacsList.size()>0){
			System.out.println("Size for new scan list>>>>>>>>>."+dgOrderDtPacsList.size());
			map.put("dtList", dgOrderDtPacsList);
		}*/if(dgOrderdts!=null && dgOrderdts.size()>0){
			System.out.println("Size for new scan list>>>>>>>>>."+dgOrderdts.size());
			map.put("dtList", dgOrderdts);
		} else{
			System.out.println("list is not available");
		}
		return map;
	}

	@Override
	public Map<String, Object> getOrderListForPatient(int hospitalId,String hinNo) {
		Map<String, Object>map=new HashMap<String, Object>();
		int hinId=0;
		Session session=(Session)getSession();
		List<Patient>patientList=new ArrayList<Patient>();
		
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",hinNo)).list();
		for(Patient patient:patientList){
			hinId=patient.getId();
		}
		List<DgOrderhd>dgSampleCollectionDetailsList=new ArrayList<DgOrderhd>();
		
		dgSampleCollectionDetailsList=session.createCriteria(DgOrderhd.class)//.createAlias("SampleCollectionHeader", "hd")
				.add(Restrictions.eq("Hin.Id",hinId))
				.add(Restrictions.eq("Hospital.Id",hospitalId))
				.list();
		map.put("dgSampleCollectionDetailsList",dgSampleCollectionDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> getsampleListForOrder(int hospitalId, int orderId) {
		Session session =(Session)getSession();
		List<DgSampleCollectionHeader>dgSampleCollectionHeaderList=new ArrayList<DgSampleCollectionHeader>();
		Map<String, Object>map=new HashMap<String, Object>();
		dgSampleCollectionHeaderList=session.createCriteria(DgSampleCollectionHeader.class)
				//.add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("Order.Id",orderId)).list();
		int sampleId=0;
		for(DgSampleCollectionHeader dg:dgSampleCollectionHeaderList)
		{
			sampleId=dg.getId();
		}
		System.out.println(""+orderId+"<<=======>>"+dgSampleCollectionHeaderList.size());
		List<DgSampleCollectionDetails>dgSampleCollectionDetailsList=new ArrayList<DgSampleCollectionDetails>();
		dgSampleCollectionDetailsList=session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.eq("SampleCollectionHeader.Id",sampleId)).list();
		System.out.println(""+orderId+"<<===dgSampleCollectionDetailsListsize====>>"+dgSampleCollectionHeaderList.size());

		map.put("dgSampleCollectionDetailsList",dgSampleCollectionDetailsList);
		return map;
	}

	@Override
	public Map<String,Object> getHinNo(Map<String,Object> map) {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		String hinNo="";
		Integer order_id=(Integer)map.get("order_id");
		List<DgOrderhd>hdList=new ArrayList<DgOrderhd>();
		Session session=(Session)getSession();
		hdList=session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Id",order_id)).list();
		for(DgOrderhd hd:hdList){
			hinNo=hd.getHin().getHinNo();
		}
		if(map.get("inpatientId")!=null){
			int inpId=(Integer)map.get("inpatientId");
			Inpatient inpatient=(Inpatient)session.get(Inpatient.class, inpId);
			if(inpatient!=null){
				dataMap.put("inpatient", inpatient);
			}
		}//added by govind 27-09-2017 for shortName 

		String modalityName="";
		if(map.get("modalityName")!=null){
			modalityName=(String)map.get("modalityName");
		}
		String investIdList="";
		if(map.get("investIdList")!=null){
			investIdList=(String)map.get("investIdList");
		}
		String[] strArray = investIdList.split(",");
		int investId=0;
		Integer[] investArr = new Integer[strArray.length];
		if(strArray.length>1){
			System.out.println("strArray "+strArray);
		    for (int i=0; i < strArray.length; i++) {
		    	if(!strArray[i].equals("")){
		    		investArr[i] = Integer.parseInt(strArray[i]);
		    	}
		    }
		}else{
			investId= Integer.parseInt(investIdList);
		}
		
		List<DgSampleCollectionDetails> sampleCollList=new ArrayList<DgSampleCollectionDetails>();
		//sampleCollList
		Criteria crit=session.createCriteria(DgSampleCollectionDetails.class)
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("Subcharge", "subcharge")
				.add(Restrictions.eq("sampleHead.Order.Id",order_id))
				.add(Restrictions.eq("subcharge.SubChargecodeName",modalityName).ignoreCase());
		        if(investArr.length>1){
		        	crit.add(Restrictions.in("Investigation.Id",investArr));
		        }
                if(investId>0){
		        	crit.add(Restrictions.eq("Investigation.Id",investId));
		        }
				sampleCollList=crit.list();
				System.out.println("investId "+investId+" order_id "+order_id);
				System.out.println("investArr "+investArr.length);
		System.out.println("sampleCollList "+sampleCollList.size()+" modalityName "+modalityName);
		String shortName="";
		String sampleCollectionAndContainer="";
		int count=0;
		 for(DgSampleCollectionDetails sample:sampleCollList){
			 if(sample.getSample().getSampleDescription()!=null){
				 sampleCollectionAndContainer=sample.getSample().getSampleDescription();
				 if(sample.getInvestigation()!=null && sample.getInvestigation().getCollection()!=null && sample.getInvestigation().getCollection().getCollectionName()!=null){
					 sampleCollectionAndContainer=sampleCollectionAndContainer+"/"+sample.getInvestigation().getCollection().getCollectionName();
				 }
			 }
			 
			 if(count==0){
				 if(sample.getInvestigation().getInvestigationShortCode()!=null){
				 shortName= sample.getInvestigation().getInvestigationShortCode();
				 }
			 }else{
			 if(shortName!=null && !shortName.equals("")){
			 shortName= shortName+(sample.getInvestigation().getInvestigationShortCode()!=null?","+sample.getInvestigation().getInvestigationShortCode():"");
			 }else{
				 shortName=(sample.getInvestigation().getInvestigationShortCode()!=null?sample.getInvestigation().getInvestigationShortCode():"");
			 }
			 }count++;
		 }
		 System.out.println("shortName "+shortName);
		 dataMap.put("shortName", shortName);//added by govind 27-09-2017 end
		 dataMap.put("sampleCollectionAndContainer", sampleCollectionAndContainer);//added by govind 27-09-2017 end
		dataMap.put("hinNo", hinNo);
		return dataMap;
	}
	/*@Override
	public List<DgOrderdt> getAckFromPackServer(
			List<DgOrderdt> dgOrderdts)
			throws FileNotFoundException, IOException, HL7Exception, LLPException {
		
		
		List<DgOrderdt> dgOrderdtListForPacs=new ArrayList<DgOrderdt>();
		URL	resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jktPacs.properties");
	
		Properties pacProper = new Properties();
		pacProper.load(new FileInputStream(new File(resourcePath.getFile()))); 
		System.out.println("PACS_URL>>>"+pacProper.getProperty("PACS_URL"));
		System.out.println("PACS_PORT>>"+pacProper.getProperty("PACS_PORT"));
		
		int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));
		
		LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
		PipeParser parser = new PipeParser(); // The message parser
		SimpleServer server = new SimpleServer(port, llp, parser);
			
		
		* The server may have any number of "application" objects registered to handle messages. We
		* are going to create an application to listen to ADT^A01 messages.
		
			 
		Application handler = new ExampleReceiverApplication();
		server.registerApplication("ADT", "A01", handler);
			   
		
		* We are going to register the same application to handle ADT^A02 messages. Of course, we
		* could just as easily have specified a different handler.
		
		
		server.registerApplication("ADT", "A02", handler);
		server.registerApplication("ORM", "O01", handler);
		
		
		for(DgOrderdt dgOrderdt:dgOrderdts){
			
			  ORM_O01 orm_O01=new ORM_O01();
			  ORU_R01 message1 = new ORU_R01();  	
		  	  message1.getMSH().getEncodingCharacters().setValue("^~\\&");
		  	  message1.getMSH().getFieldSeparator().setValue("|");
			  MSH mshSegment =orm_O01.getMSH();
			  mshSegment.getMsh1_FieldSeparator().setValue("|");
		  	  mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
		  	  //mshSegment.getMsh3_SendingApplication().setValue("HIS");...........
		  	  mshSegment.getMsh3_SendingApplication().setValue("INSTAPACS");
		  	  mshSegment.getMsh4_SendingFacility().setValue("");
		  	  mshSegment.getMsh5_ReceivingApplication().setValue("HMS");
		  	  //mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
		  	  mshSegment.getMsh6_ReceivingFacility().setValue(""); 
		  	  mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
		  	  mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
		  	  mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
		  	  //mshSegment.getMsh10_MessageControlID().setValue("1001");
		  	  mshSegment.getMsh10_MessageControlID().setValue(""+dgOrderdt.getId());
		  	  mshSegment.getMsh11_ProcessingID().setValue("P");
		  	  mshSegment.getMsh12_VersionID().setValue("2.2"); 
		  	  
		  	  PID pid=orm_O01.getPATIENT().getPID();
		  	  pid.getPid2_PatientIDExternalID().getCk1_IDNumber().setValue(dgOrderdt.getId()+"");
		  	  //pid.getPid2_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(); 
		  	  //PV1 pv1=orm_O01.getPATIENT().getPV1();
		  	  //OBR obr=orm_O01.getORDER().getORDER_DETAIL().getOBR();
		  	  //RXO rxo=orm_O01.getORDER().getORDER_DETAIL().getRXO(); 
		  	  //BLG blg=orm_O01.getORDER().getBLG();
		  	  //RQD rqd=orm_O01.getORDER().getORDER_DETAIL().getRQD();
			
			
			
			
			  
		  	  //ORU_R01 message1 = new ORU_R01(); 
		  	  //message1.getMSH().getEncodingCharacters().setValue("^~\\&");
		  	  //message1.getMSH().getFieldSeparator().setValue("|");
		  	  //ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
		  	  // Populate the ORC
		  	  //ORC orc = orderObservation.getORC(); 
		  	  // Now, let's encode the message and look at the output
		  	  Parser p1 = new PipeParser(); 
		  	  String encodedMessage = p1.encode(orm_O01); 
		  	  String encMsg = p1.encode(message1);
		  	  String newString = encMsg.substring(8);
			  System.out.println("rajat "+message1);
		  	  System.out.println("Start String"); 
			  System.out.println(encMsg+"<---rajat---->"+newString);
			  System.out.println("End String"); 
		  	 
			  Parser p = new GenericParser();
		  	  
		  	  
			  	 System.out.println("encodedMessage+newString>>>>>>>>>>>>."+encodedMessage+newString);
			  	 System.out.println("�nd");
			 
			  	  Message adt = p.parse(encodedMessage+newString);
			  	 //System.out.println("javed khan  1  ");
			  	  
				  // The connection hub connects to listening servers
				  ConnectionHub connectionHub = ConnectionHub.getInstance();
				 // System.out.println("javed khan 2");
				  
				  // A connection object represents a socket attached to an HL7 server
				 // String pacsServer="192.168.203.195";
				  String pacsServer= pacProper.getProperty("PACS_URL");
				  
				  System.out.println(pacProper.getProperty("PACS_URL"));
				  
				  //connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
				 ca.uhn.hl7v2.app.Connection connection = connectionHub.attach(pacsServer, port, new PipeParser(), MinLowerLayerProtocol.class);
				 // connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
				 
				  // The initiator is used to transmit unsolicited messages
				  Initiator initiator = connection.getInitiator();
				  System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",
						  Integer.toString(6000000));
				 // System.out.println(initiator+"-**-"+connection+"   "+adt.getName());
				  Message response = initiator.sendAndReceive(adt);
					
				  String responseString = parser.encode(response);
				 
				  System.out.println("Received response:\n" + responseString);
				
				  	 
				  Parser response_parser = new GenericParser();
			      Message hapiMsg;
			      try
			      {
			    	  // The parse method performs the actual parsing
			       	  hapiMsg = response_parser.parse(responseString);
			        	
			       	  if (hapiMsg instanceof ACK)
			          {
			       		  ACK ack = (ACK) hapiMsg;
			                
			              System.out.println("inside ach msh"+ack.getMSH().getMsh3_SendingApplication());
			              System.out.println("inside ach msh"+ack.getMSH().getMsh5_ReceivingApplication());
			              System.out.println("inside ach msh"+ack.getMSH().getMsh4_SendingFacility());
			              System.out.println("inside ach msh"+ack.getMSH().getMsh6_ReceivingFacility());
			              
			       		  
			       		System.out.println("Recieve acknowledge");
			                
			              System.out.println("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
			              System.out.println("inside ach msh "+ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
			              System.out.println("inside ach msh "+ack.getMSH().getMsh10_MessageControlID());
			              System.out.println("inside ach msh "+ack.getMSH().getMsh11_ProcessingID());
			              System.out.println("inside ach msh "+ack.getMSH().getMsh12_VersionID());
			              System.out.println("**********************************************************");	                
			              System.out.println("inside ach msa  "+ack.getMSA().getMsa1_AcknowledgementCode().getValue());
			              System.out.println("inside ach msa  "+ack.getMSA().getMsa2_MessageControlID());
			              System.out.println("inside ach msa  "+ack.getMSA().getMsa3_TextMessage().getValue());
			              System.out.println("**********************************************************");	                
			              System.out.println("inside ach err1  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
			              System.out.println("inside ach err2  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
			              System.out.println("inside ach err3  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());
			                
			              if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
			                   && ack.getMSA().getMsa3_TextMessage().getValue() == null 
			                   && ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
			              {  
			            	  System.out.println("add dgorderdt list>>>>>>>>>>");
			                	//String sql = "UPDATE dg_orderdt SET  msg_sent='y' WHERE  orderhd_id = "+res.getInt("orderhd_id")+" and orderdt_id = "+res.getInt("orderdt_id");
			                	//int updateCount = st4.executeUpdate(sql); 
			                	//System.out.println("update2 ");
			                	// updateCount contains the number of updated rows 
			                
			                	//System.exit(0);
			            	  
			            	  dgOrderdtListForPacs.add(dgOrderdt);
			              }	
			              
			          }else{
			        	  System.out.println("exit");
			          }
			      }
			      catch (EncodingNotSupportedException e)
			      {
			    	  e.printStackTrace();
			    	
			      }
			      catch (HL7Exception e)
			      {
			    	  e.printStackTrace();
			    	 
			      }
			      
			     String adtym = "";
		} 
		
		
		return dgOrderdtListForPacs;
	}*/
	
	private String pacsOrderCancelation(int orderId) throws FileNotFoundException, IOException{
		
		
		
		System.out.println("in main");

		//String path=" cmd /c start    C:\\Users\\javed.khan\\Desktop\\PACSBat\\pac.bat";
		//Runtime rn=Runtime.getRuntime();
		//Process pr1=rn.exec(path);

		System.out.println("----");
		//Runtime.getRuntime().exec("cmd.exe", "/c", "./com/projct/util/server.bat");
		//"cmd /c start D:\\temp\\a.bat"
		
		
		java.sql.Connection con = null;
		// String url = "jdbc:sqlserver://192.168.203.136:1433;database=VBCHLIVE";
		/*String url = "jdbc:sqlserver://192.168.203.196:1433;database=SILVASSHMS";
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	    
	    String userName = "sa";
	    String password = "Hms@2013";*/
		URL	resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jktPacs.properties");
	
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile())));
			 
		
		//Properties pacProper = new Properties();
		//InputStream input = new FileInputStream("D:\\PACSBat\\jktPacs.properties");
		//pacProper.load(input);
		System.out.println("Database_URl>>"+pacProper.getProperty("Database_URl"));
		System.out.println("PACS_URL>>>"+pacProper.getProperty("PACS_URL"));
		System.out.println("PACS_PORT>>"+pacProper.getProperty("PACS_PORT"));
		System.out.println("driverName>>>"+pacProper.getProperty("driverName"));
		System.out.println("user>:>"+pacProper.getProperty("user"));
		System.out.println("user>:>"+pacProper.getProperty("password"));
		//System.exit(0);
		//String url="jdbc:mysql://192.168.203.196:3306/4b";
		String url = pacProper.getProperty("Database_URl");
		//String driverName = "com.mysql.jdbc.Driver";
		String driverName =pacProper.getProperty("driverName");
		// String userName = "root";
		String userName = pacProper.getProperty("user");
		//  String password = "root";
		String password = pacProper.getProperty("password");
	    // int port = 5555;
		int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));
	
		LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
		PipeParser parser = new PipeParser(); // The message parser
		SimpleServer server = new SimpleServer(port, llp, parser);
			
		/*
		* The server may have any number of "application" objects registered to handle messages. We
		* are going to create an application to listen to ADT^A01 messages.
		*/
			 
		Application handler = new ExampleReceiverApplication();
		server.registerApplication("ADT", "A01", handler);
			   
		/*
		* We are going to register the same application to handle ADT^A02 messages. Of course, we
		* could just as easily have specified a different handler.
		*/
		
		server.registerApplication("ADT", "A02", handler);
		server.registerApplication("ORM", "O01", handler);
			 
		/*
		* Another option would be to specify a single application to handle all messages, like
		* this:
		* 
		* server.registerApplication("*", "*", handler);
		*/
			   
		// Start the server listening for messages
		//server.start();
		System.out.println("server main "+server);
			   
		/*
		* Now, create a connection to that server, and send a message
		*/
			 
		try
		{
			 Class.forName(driverName).newInstance();
		     con = DriverManager.getConnection(url, userName, password);
		     ca.uhn.hl7v2.app.Connection connection = null;
		     try
		     {
		          Statement st = con.createStatement();
		          Statement st2 = con.createStatement(
                          ResultSet.TYPE_SCROLL_INSENSITIVE,
                          ResultSet.CONCUR_READ_ONLY);
		          Statement st3 = con.createStatement();
		          Statement st4 = con.createStatement();

		          String query = "SELECT  * FROM dg_orderhd dg left outer join dg_orderdt dt on dt.orderhd_id = dg.orderhd_id "+
		          " left outer join  patient p on  p.hin_id = dg.hin_id  "+
		          " left outer join mas_administrative_sex sexid on sexid.administrative_sex_id  = p.sex_id "+
		          " left outer join  mas_employee emp on dg.prescribed_by = emp.employee_id "+ 
		          " left outer join inpatient inp on dg.inpatient_id = inp.inpatient_id "+
		          " left outer join mas_charge_code mcc on dt.charge_code_id = mcc.charge_code_id "+ 
		          " left outer join mas_sub_chargecode mscc on dt.sub_chargeid = mscc.sub_chargecode_id "+
		          " WHERE dt.msg_sent = 'y' and dt.orderdt_id="+orderId+" order by dg.orderhd_id  ";
		          
		          ResultSet res = st.executeQuery(query);
		          System.out.println("query main ->>>>--"+query);
			      Date DOB = null;
			      Date DOA = null;
			      String TOA = null;
			      String adtym = "";
			      String doa_val = null;
			      
			      while (res.next())
			      {
			    	  int mainChargeCodeId = res.getInt("main_chargecode_id");
			    	  System.out.println("mainChargeCodeId main>>> "+mainChargeCodeId);
			    	  
			    	  String mainQuery = "select main_chargecode_name from mas_main_chargecode where main_chargecode_id = "+mainChargeCodeId;
			    	  System.out.println("mainQuery main "+mainQuery);
			    	  ResultSet res_mainChargeCode = st2.executeQuery(mainQuery);
			    	  String a1 = "";
			    	
			    	  a1 = res.getString("orderhd_id");
			    	  String mainQuery1 = "select d.orderdt_id from dg_orderdt d where d.orderhd_id = '"+a1+"'";

			    	  System.out.println("javed>>"+mainQuery1);
			    	  ResultSet res_orderdt_id = st3.executeQuery(mainQuery1);
			    	  String a = "";
			    	  while(res_orderdt_id.next())
			    	  {
				    	//System.out.println(res_orderdt_id.getInt(1));
				    	a=""+(res_orderdt_id.getInt(1));
			    	  }
			    	  System.out.println("res_mainChargeCode");
			    	  while(res_mainChargeCode.next())
			    	  {
			    	  System.out.println("orderdt_id>>"+a);
			    	  
			    		  String mainCName = res_mainChargeCode.getString("main_chargecode_name");
			    		  System.out.println("mainCName main "+mainCName);
			    		  if(mainCName.equalsIgnoreCase("XRAY") || mainCName.equalsIgnoreCase("ULTRASOUND") || mainCName.equalsIgnoreCase("SONOGRAPHY")
			    			 || mainCName.equalsIgnoreCase("CT SCAN") || mainCName.equalsIgnoreCase("MRI"))
			    		 //if(mainCName.equalsIgnoreCase("Radiology Services"))
			    		  {
			    			  //Start creating message
						  	  ADT_A01 adt1 = new ADT_A01();
						  	  ORU_R01 message1 = new ORU_R01();
						  		
						  	  message1.getMSH().getEncodingCharacters().setValue("^~\\&");
						  	  message1.getMSH().getFieldSeparator().setValue("|");
						  	  ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();
						  	  
						  	  // Populate the MSH Segment
						  	  MSH mshSegment = adt1.getMSH();
						  	  mshSegment.getMsh1_FieldSeparator().setValue("|");
						  	  mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
						  	  //mshSegment.getMsh3_SendingApplication().setValue("HIS");...........
						  	  mshSegment.getMsh3_SendingApplication().setValue("INSTAPACS");
						  	  mshSegment.getMsh4_SendingFacility().setValue("RIH");
						  	  mshSegment.getMsh5_ReceivingApplication().setValue("HMS");
						  	  //mshSegment.getMsh5_ReceivingApplication().setValue("EKG");
						  	  mshSegment.getMsh6_ReceivingFacility().setValue("EKG"); 
						  	  mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
						  	  mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
						  	  //mshSegment.getMsh10_MessageControlID().setValue("1001");
						  	  mshSegment.getMsh10_MessageControlID().setValue(""+a);
						  	  mshSegment.getMsh11_ProcessingID().setValue("P");
						  	  mshSegment.getMsh12_VersionID().setValue("2.2");
						  	  DOB = res.getDate("date_of_birth");
						  	  String abc = HMSUtil.convertDatetoString(DOB);
						  	  
						  	  
						  	  
						
						  	      				  	  
						  	  // Populate the PID Segment
						  	  PID pid = adt1.getPID();
						  	  pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(res.getString("hin_id"));
						  	  pid.getPid4_AlternatePatientID().setValue(res.getString("hin_id"));
						  	  pid.getPid5_PatientName().getFamilyName().setValue(res.getString("p_last_name"));
						  	  pid.getPid5_PatientName().getGivenName().setValue(res.getString("p_first_name"));
						  	  pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
						  	  pid.getPid8_Sex().setValue(res.getString("administrative_sex_code"));
							        
						  	  PV1 pv1 = adt1.getPV1();
						  	  pv1.getPv12_PatientClass().setValue(res.getString("patient_type"));
						  	  pv1.getPv18_ReferringDoctor().getIDNumber().setValue(res.getString("pe_no"));
						  	  //pv1.getPv18_ReferringDoctor().getGivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
						  	     
						  	  String visitId = HMSUtil.convertSimple(res.getInt("visit_id"));
						  	  pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(visitId);
						  	  if(res.getString("patient_type").equalsIgnoreCase("IP")){
						  	  if(res.getDate("date_of_addmission") != null || res.getString("time_of_addmission") != null)
						  	  {
						  		  DOA = res.getDate("date_of_addmission");
						  		  TOA = res.getString("time_of_addmission");
							  	      
							  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
							  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
								  	     
								  doa_val = HMSUtil.convertDatetoString(DOA);

								  adtym = adtym.concat(doa_val).concat(TOA);
								  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						  	  }
						  	  }else{ // for OP 
						  		  
						  		DOA = res.getDate("order_date");
						  		  TOA = res.getString("order_time");
							  	      
							  	  TOA  = TOA.substring(0, 2).concat(TOA.substring(3));
							  	 // TOA =  TOA.substring(0, 4).concat(TOA.substring(5));
								  	     
								  doa_val = HMSUtil.convertDatetoString(DOA);

								  adtym = adtym.concat(doa_val).concat(TOA);
								  pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
						  		  
						  		  
						  	  }
						  	
						  	  // Populate the ORC
						  	  ORC orc = orderObservation.getORC();
						  	  orc.getOrc1_OrderControl().setValue("CA");            // Order Canclation
						  	  // orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
						  	  orc.getOrc2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+a);
						  	  orc.getOrc5_OrderStatus().setValue("SC");             // ( = In Progress Scheduled)
						  	  orc.getDateTimeOfTransaction().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
								      
						  	  orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(res.getString("hin_no")); //Order Entry Person (ID)
						  	  orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue(res.getString("full_name")); //Order Entry Person (Name)
						  	  //orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(""+res.getInt("employee_id")); //Order Entry Person (ID)
						  	  //orc.getOrc10_EnteredBy().getCn2_FamilyName().setValue("Abhi Gupta"); //Order Entry Person (Name)
								    
							  // Populate the OBR
						  	  OBR obr = orderObservation.getOBR();
						  	  //obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue("1001");
						  	  obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(""+a);
						  	  //obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(res.getString("charge_code_code"));
						  	  obr.getObr4_UniversalServiceID().getCe1_Identifier().setValue(""+res.getInt("charge_code_id"));
						  	  //obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
						  	  obr.getObr4_UniversalServiceID().getCe2_Text().setValue(res.getString("charge_code_name"));
						  	  obr.getObr7_ObservationDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  obr.getObr13_RelevantClinicalInformation().setValue(res.getString("clinical_note"));
						  	
						  	  obr.getObr16_OrderingProvider().getCn1_IDNumber().setValue(res.getString("pe_no"));
						  	  //obr.getObr16_OrderingProvider().getCn3_GivenName().setValue(res.getString("first_name").concat(res.getString("last_name")));
						  	  //  obr.getObr24_DiagnosticServiceSectionID().setValue(res.getString("charge_code_code"));
						  	  obr.getObr24_DiagnosticServiceSectionID().setValue(""+res.getInt("charge_code_id"));
								      
						  	  obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd")+HMSUtil.now("Hmmss"));
						  	  //Order Scheduling Details (will not be present if HIS does not have scheduling engine
						  	  
						  	
						  	
						  	  // Now, let's encode the message and look at the output
						  	  Parser p1 = new PipeParser(); 
						  	  String encodedMessage = p1.encode(adt1); 
						  	  String encMsg = p1.encode(message1);
						  	  String newString = encMsg.substring(8);
							  System.out.println("adt1 Message"); 
							  System.out.println(adt1); 
							  System.out.println("message1");
							  System.out.println(message1);
							  System.out.println("encMsg"); 
							  System.out.println(encMsg);
							  System.out.println("encodedMessage"); 
							  System.out.println(encodedMessage); 
							  System.out.println("newString");
							  System.out.println(newString);
						  	 
						  	  Parser p = new GenericParser();
						  	  
						  	  
						  	 /*System.out.println("javed khan"+encodedMessage+newString);
						  	 System.out.println("�nd");*/
						 
						  	  Message adt = p.parse(encodedMessage+newString);
						  	 
						  	 System.out.println("adt");
						  	 System.out.println(adt);
						  	  
							  // The connection hub connects to listening servers
							  ConnectionHub connectionHub = ConnectionHub.getInstance();
							 // System.out.println("javed khan 2");
							  
							  // A connection object represents a socket attached to an HL7 server
							 // String pacsServer="192.168.203.195";
							  String pacsServer= pacProper.getProperty("PACS_URL");
							  
							  System.out.println(pacProper.getProperty("PACS_URL"));
							  
							  //connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
							  connection = connectionHub.attach(pacsServer, port, new PipeParser(), MinLowerLayerProtocol.class);
							 // connection = connectionHub.attach("localhost", port, new PipeParser(), MinLowerLayerProtocol.class);
							 
							  // The initiator is used to transmit unsolicited messages
							  Initiator initiator = connection.getInitiator();
							  System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",
									  Integer.toString(6000000));
							 // System.out.println(initiator+"-**-"+connection+"   "+adt.getName());
							  Message response = initiator.sendAndReceive(adt);
								
							  String responseString = parser.encode(response);
							 
							  System.out.println("Received response:\n" + responseString);
							
							  	 
							  Parser response_parser = new GenericParser();
						      Message hapiMsg;
						      try
						      {
						    	  // The parse method performs the actual parsing
						       	  hapiMsg = response_parser.parse(responseString);
						        	
						       	  if (hapiMsg instanceof ACK)
						          {
						       		  ACK ack = (ACK) hapiMsg;
						                
						              /*System.out.println("inside ach msh"+ack.getMSH().getMsh3_SendingApplication());
						              System.out.println("inside ach msh"+ack.getMSH().getMsh5_ReceivingApplication());
						              System.out.println("inside ach msh"+ack.getMSH().getMsh4_SendingFacility());
						              System.out.println("inside ach msh"+ack.getMSH().getMsh6_ReceivingFacility());
						              */
						       		  
						       		  System.out.println("Recieve acknowledge");
						                
						              System.out.println("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
						              System.out.println("inside ach msh "+ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
						              System.out.println("inside ach msh "+ack.getMSH().getMsh10_MessageControlID());
						              System.out.println("inside ach msh "+ack.getMSH().getMsh11_ProcessingID());
						              System.out.println("inside ach msh "+ack.getMSH().getMsh12_VersionID());
						              System.out.println("**********************************************************");	                
						              System.out.println("inside ach msa  "+ack.getMSA().getMsa1_AcknowledgementCode().getValue());
						              System.out.println("inside ach msa  "+ack.getMSA().getMsa2_MessageControlID());
						              System.out.println("inside ach msa  "+ack.getMSA().getMsa3_TextMessage().getValue());
						              System.out.println("**********************************************************");	                
						              System.out.println("inside ach err1  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
						              System.out.println("inside ach err2  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
						              System.out.println("inside ach err3  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());
						                
						              if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA") 
						                   && ack.getMSA().getMsa3_TextMessage().getValue() == null 
						                   && ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
						              {  	
						            	  System.out.println("update ");
						                	String sql = "UPDATE dg_orderdt SET  msg_sent='y' WHERE  orderhd_id = "+res.getInt("orderhd_id")+" and orderdt_id = "+res.getInt("orderdt_id");
						                	int updateCount = st4.executeUpdate(sql); 
						                	System.out.println("update2 ");
						                	// updateCount contains the number of updated rows 
						                
						                	//System.exit(0);
						                	return "true";
						              }	
						              
						          }else{
						        	  System.out.println("exit");
						        	  return "false";
						          }
						      }
						      catch (EncodingNotSupportedException e)
						      {
						    	  e.printStackTrace();
						    	  return "false";
						      }
						      catch (HL7Exception e)
						      {
						    	  e.printStackTrace();
						    	  return "false";
						      }
						      
						      adtym = "";
			    		  }
			    		  else
			    		  {
			    			  System.out.println("Different Charge Code......");
			    		  }
			    	  }
			      }
		     }
			 catch(SQLException s)
			 {
				 s.printStackTrace();
			     System.out.println("SQL query does not execute."+s);
			 }
			 finally
			 {
				 con.close();
				 //Close the connection and server
			     //connection.close();
			     server.stop();
			 }
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	return "false";
}

	@Override
	public Map<String, Object> getWaitingPatientList(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		Session	 session=(Session)getSession();
		org.hibernate.Transaction tx=null;
		tx = (org.hibernate.Transaction) session.beginTransaction();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<Visit> patientList = new ArrayList<Visit>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		
		List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
		int deptId = 0;
		int hospitalId=0;
		
		String flag="";
		int searchFlag=0;
		int tokenNo=0;
		String patientName="";
		String uhid="";
		int opd_DepartmentId=0;
		if(mapForDS.get("searchFlag")!=null){
			searchFlag=(Integer)mapForDS.get("searchFlag");
		}
		if((Boolean)mapForDS.get("forOPClinnic")==null){
			if(mapForDS.get("opd_Department")!=null){
				opd_DepartmentId =(Integer) mapForDS.get("opd_Department");
			}
		}
		
		if(mapForDS.get("tokenNo")!=null){
			tokenNo =(Integer) mapForDS.get("tokenNo");
		}
		if(mapForDS.get("patientName")!=null){
			patientName =(String) mapForDS.get("patientName");
		}
		if(mapForDS.get("uhid")!=null){
			uhid =(String) mapForDS.get("uhid");
		}
		if(mapForDS.get("flag")!=null){
			flag =(String) mapForDS.get("flag");
		}
		
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		int hinId = 0;
		int visitId = 0;
		String hinNo = "";
		int visitNo = 0;
		String deptName = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date date = new Date();
		String category = "Doctor";
		
			MasEmployee employee=null;
			String empCatName="";
			
			if(mapForDS.get("userId")!=null){
				Integer userId=(Integer)mapForDS.get("userId");
				
				Users users=(Users) hbt.load(Users.class, userId);
				employee=users.getEmployee();
				empCatName=employee.getEmpCategory().getEmpCategoryName();
			}
			
			List<Object> objectList = new ArrayList<Object>();
			List<Object> visitList = new ArrayList<Object>();
			if (mapForDS.get("hinId") != null && (Integer) mapForDS.get("hinId") > 0) {
				hinId = (Integer) mapForDS.get("hinId");
				if (hinId != 0) {
					objectList = session.createCriteria(Patient.class)
							.setProjection(Projections.projectionList()
							.add(Projections.property("HinNo"),"HinNo"))
							.add(Restrictions.eq("Id",hinId)).list();
				}
			}
			if (objectList != null && objectList.size() > 0) {
				hinNo = (String) objectList.get(0);
			}
			if (mapForDS.get("visitId") != null	&& (Integer) mapForDS.get("visitId") > 0) {
				visitId = (Integer) mapForDS.get("visitId");
				visitList =session.createCriteria(Visit.class)
						   .setProjection(Projections.projectionList()
						   .add(Projections.property("VisitNo"),"VisitNo"))
						   .add(Restrictions.eq("Id",visitId))
						   .add(Restrictions.eq("Hospital.Id",hospitalId)).list();
				
				//shifting patient in case of next patient or not show :start
					Visit visit=(Visit)hbt.load(Visit.class,visitId);
					int opcount = 0;
					String acutalVisitTime = visit.getOpVisitTime();
					if(visit.getOpCallCount()!=null){
						opcount = visit.getOpCallCount();
						opcount = opcount+1;
					}
					visit.setOpCallCount(opcount);
					
					Criteria shiftCriteria= session.createCriteria(Visit.class).add(Restrictions.eq("VisitDate", new Date())).add(Restrictions.eq("Department.Id", deptId));
					shiftCriteria.add(Restrictions.ne("VisitStatus", "c").ignoreCase());
					shiftCriteria.add(Restrictions.ne("VisitStatus", "a").ignoreCase());
					shiftCriteria.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.gt("OpVisitTime", acutalVisitTime)).setMaxResults(3)
					.addOrder(Order.asc("OpVisitTime"))
					.addOrder(Order.asc("TokenNo"));
					
					
					List<Visit>vlist=shiftCriteria.list();
					if(shiftCriteria.list().size()>0){
						List<Visit> visitLists=shiftCriteria.list();
						Visit vst=visitLists.get(visitLists.size()-1);
						String opVisitTime=vst.getOpVisitTime();
						String newTime=HMSUtil.addNewTimeToTime(opVisitTime,0,0,1);
						visit.setOpVisitTime(newTime);
						hbt.saveOrUpdate(visit);
						try{
						tx.commit();
						}catch(Exception e){
							if (tx != null) {
								try {
									tx.rollback();
								} catch (Exception e1) {
									e1.printStackTrace();
								} 
							}
							e.printStackTrace();
						}
					}
				//shifting patient in case of next patient or not show :end
			}
			
			
			if (visitList != null && visitList.size() > 0) {
				visitNo = (Integer) visitList.get(0);
			}
			hospitalId = (Integer) mapForDS.get("hospitalId");
			/*if (employee != null && empCatName.equalsIgnoreCase("doctor")) {
				patientList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("VisitDate", date))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.ne("VisitStatus", "c").ignoreCase())
						.add(Restrictions.eq("Doctor.Id", employee.getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalId)) 	
						.addOrder(Order.asc("OpVisitTime"))
						.addOrder(Order.asc("PriorityNumber"))
						.addOrder(Order.asc("TotalHospitalVisit")).list();
				
				map.put("empId", employee.getId());
			} else {*/
				Criteria criteria= session.createCriteria(Visit.class)
						.add(Restrictions.eq("VisitDate", date));
						if(flag.equalsIgnoreCase("p")){
							criteria.add(Restrictions.eq("VisitStatus", "p").ignoreCase());
						}else{
							criteria.add(Restrictions.ne("VisitStatus", "c").ignoreCase());
							criteria.add(Restrictions.ne("VisitStatus", "a").ignoreCase());
						}
						criteria.add(Restrictions.eq("Hospital.Id", hospitalId));
						if(employee!=null){
							criteria.add(Restrictions.or(Restrictions.isNull("Doctor"), Restrictions.eq("Doctor.Id", employee.getId())));
						}
						criteria.addOrder(Order.asc("OpVisitTime"))
						.addOrder(Order.asc("PriorityNumber"))
						//.addOrder(Order.asc("VisitTime"))
						.addOrder(Order.asc("TotalHospitalVisit"));
						
						
				if((Boolean)mapForDS.get("opClinicalWaitinList")!=null && (Boolean)mapForDS.get("opClinicalWaitinList"))
				{	
					if(mapForDS.get("skip")!=null){
						criteria.add(Restrictions.ne("Id", visitId));
					}
					criteria.add(Restrictions.eq("Department.Id", deptId));
				}
				
				
				if(searchFlag==1){
					criteria.createAlias("Hin", "hin");
					if((Boolean)mapForDS.get("forOPClinnic")==null){
						if(opd_DepartmentId!=0){
							criteria.add(Restrictions.eq("Department.Id", opd_DepartmentId));
						}
					}
					
					if(tokenNo!=0){
						criteria.add(Restrictions.eq("TokenNo", tokenNo));
					}
					if(patientName!=null  && !patientName.equals("")){
						criteria.add(Restrictions.or
										(Restrictions.or(Restrictions.like("hin.PFirstName", "%"+patientName+"%").ignoreCase(), Restrictions.like("hin.PMiddleName", "%"+patientName+"%").ignoreCase())
														,Restrictions.like("hin.PLastName", "%"+patientName+"%").ignoreCase()
										)
									);
					}
					if(uhid!=null && !uhid.equals(""))
					{
						criteria.add(Restrictions.like("hin.HinNo", "%"+uhid+"%"));
					}
					
				}
			
				patientList=criteria.list();
		//	}
			doctorList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.createAlias("Department", "dept")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.EmpCategoryName",	category)).add(Restrictions.eq("dept.Id", deptId))
					.list();
			
			deptName = getDepartmentNameFromId(deptId);
			departmentList=	session.createCriteria(MasDepartment.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("DepartmentType.Id", 1))
						.addOrder(Order.asc("DepartmentName")).list();
			
			/*List<OpdPatientHistory>preOpdpastIllhistory=new ArrayList<OpdPatientHistory>();
			  preOpdpastIllhistory=session.createCriteria(OpdPatientHistory.class).add(Restrictions.eq("Hin.Id",hinId)).addOrder(Order.asc("LastChgDate")).list();
					if(preOpdpastIllhistory.size()>0){
						map.put("preOpdPatientHistoryList", preOpdpastIllhistory);
						OpdPatientHistory opdh=preOpdpastIllhistory.get(0);
			}	*/
			
			map.put("departmentList", departmentList);
			map.put("patientList", patientList);
			map.put("deptName", deptName);
			map.put("hinNo", hinNo);
			map.put("visitNo", visitNo);
			map.put("visitId", visitId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
		return map;
	}
	
	public String getDepartmentNameFromId(int deptId) {
		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		String deptName = null;

		try {

			Criteria crit = session.createCriteria(MasDepartment.class).add(
					Restrictions.eq("Id", deptId));
			deptList = crit.list();
			if (deptList.size() > 0) {
				MasDepartment masDepartment = deptList.get(0);
				deptName = masDepartment.getDepartmentName();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return deptName;
	}

	@Override
	public int getVisitNo(int visitId) {
		Session session=(Session)getSession();
		int visitNo=0;
		List<Visit>visitList=new ArrayList<Visit>();
		visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
		for(Visit visit:visitList){
			
			visitNo=visit.getVisitNo();
		}
		
		
		return visitNo;
	}

	@Override
	public Map<String, Object> getInvestigationDetailsForNewRequest(int val) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		List<DgOrderdt>dtList=new ArrayList<DgOrderdt>();
		dtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id",val)).list();
		map.put("dtList",dtList);
		return map;
	}

	public Map<String, Object> getPatientDetailGrid(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		//List<Visit> visits = new ArrayList<Visit>();
		
		List<PharmacyLabQueue> pharmacyLabQueue = new ArrayList<PharmacyLabQueue>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		int hospitalId=0;
		String uhid=null;
		String billingScreen = null; // added by amit das on 11-05-2017
		String[] deptArray = {"LAB","RADIO","Lab","Radio","lab","radio"}; // added by amit das on 11-05-2017
		String patientType="OP";
		String ipNumber=null;
		
		if(dataMap.get("hospitalId")!=null && dataMap.get("hospitalId")!=""){
			hospitalId = (Integer)dataMap.get("hospitalId");
		}
		
		if(dataMap.get("billingScreen")!=null && dataMap.get("billingScreen")!=""){
			billingScreen = (String)dataMap.get("billingScreen");
		}
		if(dataMap.get("patientType")!=null){
			patientType=(String) dataMap.get("patientType");
		}
		if(dataMap.get("ipNumber")!=null){
			ipNumber=(String) dataMap.get("ipNumber");
		}
		System.out.println("patientType impl "+patientType);
		/*Criteria cr = session
				.createCriteria(Visit.class)
				.createAlias("Hospital", "hospital")
				.createAlias("Department", "dept")
				.createAlias("Hin", "hin")
				.add(Restrictions.ne("VisitStatus", "c").ignoreCase())
					.add(Restrictions.ne("VisitStatus", "a").ignoreCase())  // commented by Amit Das on 15-03-2016
				.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("VisitStatus", "w").ignoreCase()) // added by Amit Das on 15-03-2016
				.add(Restrictions.eq("dept.DepartmentCode", "LAB").ignoreCase())
				.add(Restrictions.eq("VisitDate",date));
		if(dataMap.get("uhid")!=null && dataMap.get("uhid")!=""){
			uhid=(String) dataMap.get("uhid");
			cr=cr.add(Restrictions.eq("hin.HinNo", uhid));
		}
		 visits=cr.list();*/
		List<Inpatient> inpatientList=new ArrayList<Inpatient>();
		if(patientType.equals("IP")){
			if(dataMap.get("uhid")!=null){
				uhid=(String) dataMap.get("uhid");
			}
			Criteria ipCr =session.createCriteria(Inpatient.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("AdStatus", "A").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId));			
			if(ipNumber!=null && !ipNumber.equals("")){
				ipCr=ipCr.add(Restrictions.eq("AdNo", ipNumber));
			}
			if(uhid!=null && !uhid.equals("")){
				ipCr=ipCr.add(Restrictions.eq("hin.HinNo", uhid));
			}
			inpatientList=ipCr.list();
			map.put("inpatientList", inpatientList);
			map.put("patientType", patientType);
		}
		if(patientType.equals("OP")){	
		Criteria cr = session
				.createCriteria(PharmacyLabQueue.class)
				.createAlias("Hospital", "hospital")
				.createAlias("Visit", "visit")
				.createAlias("visit.Hin", "hin");
				
		if(billingScreen!=null && billingScreen.equalsIgnoreCase("y")){    // added by amit das on 11-05-2017 
			cr =	cr.createAlias("visit.Department", "dept").add(Restrictions.in("dept.DepartmentCode", deptArray)).add(Restrictions.ne("visit.VisitStatus", "c").ignoreCase())
					.add(Restrictions.ne("visit.VisitStatus", "a").ignoreCase());
		}else{		
			cr =	cr.createAlias("Department", "dept")
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("Status", "D").ignoreCase())
					.add(Restrictions.eq("dept.DepartmentCode", "LAB").ignoreCase());
		}	
		
		cr =	cr.add(Restrictions.eq("hospital.Id", hospitalId))
				.add(Restrictions.eq("OpdDate",date));
		if(dataMap.get("uhid")!=null){
			uhid=(String) dataMap.get("uhid");
		}
		if(uhid!=null && !uhid.equals("")){
			cr=cr.add(Restrictions.eq("hin.HinNo", uhid));
		}
		pharmacyLabQueue=cr.list();
		
		//map.put("visits", visits);
		map.put("pharmacyLabQueue", pharmacyLabQueue);
	   }
		return map;
	}

	@Override
	public Map<String, Object> getHospitalForDistrict(int districtId,int hospitalTypeId) {
		
		Map<String,Object>map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		List<MasHospital>hospitalList=new ArrayList<MasHospital>();
		if(districtId!=0 && hospitalTypeId!=0){
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("District.Id",districtId)).add(Restrictions.eq("HospitalType.Id",hospitalTypeId)).list();	
		}else if(districtId!=0 && hospitalTypeId==0){
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("District.Id",districtId)).list();
		}else if(hospitalTypeId!=0 && districtId==0){
			hospitalList=session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalType.Id",hospitalTypeId)).list();
		}else{
			hospitalList=session.createCriteria(MasHospital.class).list();
		}
		
		map.put("hospitalList",hospitalList);
		return map;
	}

	@Override
	public String getHinNo(int order_id) {
			String hinNo="";
		
		return hinNo;
	}

	@Override
	public Map<String, Object> showPendingForSmearResultPH(
			Map<String, Object> map) {
		Session session=(Session)getSession();
		int hospitalId=0;
		if(map.get("hospitalId")!=null){
			hospitalId=(Integer)map.get("hospitalId");
		}
		List<PhInvestigationSampleDetail>PhInvestigationSampleDetail=new ArrayList<PhInvestigationSampleDetail>();
		PhInvestigationSampleDetail=session.createCriteria(PhInvestigationSampleDetail.class).add(Restrictions.eq("Status", "n").ignoreCase())
				.createAlias("ReferHospital", "ReferHospital")
				.add(Restrictions.eq("ReferHospital.Id",hospitalId))
				.list();
		map.put("PhInvestigationSampleDetail",PhInvestigationSampleDetail);
		return map;
	}

	@Override
	public Map<String, Object> sendForSampleValidatePh(Box box) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		List<PhMemberSurvey>surveyList=new ArrayList<PhMemberSurvey>();
		List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
		List<MasSession>sessionList = new ArrayList<MasSession>();
		Map<String, Object> reservedTokenMap = new HashMap<String, Object>();
		Map<Integer, Object> patientWithTokenMap = new HashMap<Integer, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		Map<String,DiagParam> diagParamMap=new HashMap<String,DiagParam>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		int survey_id=0;
		int hinId=0;
		int visitId=0;
		String name="";
		Date dob=new Date();
		int labDepartmentId = 0;
		int genderId = 0;
		int tsn = 0;
		int id = 0;
		String hinNo = "";
		String hin_name = "";
		int visitNo = 0;
		int yob = 0;
		Date lastChangedate=null;
		Integer totalHospitalVisitNo=0;
		int tokenNo=0;
		String onlineRegStatus="";
		QueueManagment queue=null;
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int count = 0;
		if(box.getInt("hdb") != 0){
			count =box.getInt("hdb");
		}
		//System.out.println("count=="+count);
		org.hibernate.Transaction tx=null;
	try {
		tx = (org.hibernate.Transaction) session.beginTransaction();
	for (int i =0; i < count; i++) {
		//System.out.println("member Status====in ds=="+box.getString("memBerStatus"+i));
		if(box.getString("memBerStatus"+i).equals("y")){
			//System.out.println("memberId====in ds=="+box.getInt("memberId"+i));
			surveyList=session.createCriteria(PhMemberSurvey.class).add(Restrictions.eq("MemberId", Long.parseLong(box.getString("memberId"+i)))).list();
			
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
				 labDepartmentId =Integer.parseInt(properties.getProperty("labDepartmentId"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			for(PhMemberSurvey survey:surveyList){
				survey_id=survey.getId();
				if(survey.getName()!=null){
				name=survey.getName();
				}
				if(survey.getDateOfBirth()!=null){
					dob=survey.getDateOfBirth();
					 yob = dob.getYear();
				}
				if(survey.getGender().getId()!=null){
					genderId=survey.getGender().getId();
				}
			}
			List<Patient>patientList=new ArrayList<Patient>();
			if(survey_id!=0){
				patientList=session.createCriteria(Patient.class).add(Restrictions.eq("Member.Id",survey_id)).list();
			}
			
		
	if(patientList.size()==0){
		//------------save data in patient----------------------
				Patient patient=new Patient();
				patient.setPFirstName(name);
				patient.setFullName(name);
				patient.setDateOfBirth(dob);
				patient.setRegDate(new Date());
				patient.setRegTime(time);
				patient.setAddEditDate(new Date());
				patient.setAddEditTime(time);
				Users user2=new Users();
				user2.setId(box.getInt("userId"));
				patient.setAddEditBy(user2);
				patient.setStatus("y");
				patient.setPatientStatus("Out Patient");
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(genderId);
				patient.setSex(masAdministrativeSex);
				patient.setAge(HMSUtil.calculateAge(dob));
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("referHospital"+i));
				patient.setHospital(hospital);
				patient.setYearOfBirth(""+yob);
				
				PhMemberSurvey memberSurvey = new PhMemberSurvey();
				memberSurvey.setId(survey_id);
				patient.setMember(memberSurvey);
				//---------------------------for generate hin no -----------------------------	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date=new Date();
				String curDate=sdf.format(date);
				Date currentDate1 = null;
				try {
					currentDate1 = sdf.parse(curDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<Object[]> adList = session
						.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
						.add(Restrictions.eq("TransactionPrefix", "HIN"))
						.add(Restrictions.eq("hosp.Id", box.getInt("referHospital"+i)))
						.setProjection(Projections.projectionList()
								.add(Projections.property("TransactionSequenceNumber"))
								.add(Projections.property("LastChgDate"))
								.add(Projections.property("Id")))
						.list();

				if (adList.size() > 0) {
					Object[] transactionSequence = adList.get(0);
					tsn = Integer.parseInt("" + transactionSequence[0]);
					id = (Integer) transactionSequence[2];
					lastChangedate=(Date) transactionSequence[1];
					
				}
				else{
					TransactionSequence transactionSequenceObj1 = new TransactionSequence();
				
					transactionSequenceObj1.setTransactionSequenceNumber(1);
					transactionSequenceObj1.setLastChgDate(new Date());
					transactionSequenceObj1.setTransactionSequenceName("Hin No");
					transactionSequenceObj1.setTransactionPrefix("HIN");
					transactionSequenceObj1.setTablename("Patient");
					transactionSequenceObj1.setCreatedby("admin");
					transactionSequenceObj1.setStatus("Y");
					MasHospital hosp=new MasHospital();
					hosp.setId(box.getInt("referHospital"+i));
					transactionSequenceObj1.setHospital(hosp);
					transactionSequenceObj1.setLastChgTime(time);
					hbt.save(transactionSequenceObj1);
				}

			
			if(null != lastChangedate && currentDate1 .compareTo(lastChangedate)>0){
				tsn=0;
			TransactionSequence transactionSequenceObj = (TransactionSequence) session
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(1);
			transactionSequenceObj.setLastChgDate(new Date());
			hbt.update(transactionSequenceObj);
			
			
			}
			else{
				if(id>0){
				TransactionSequence transactionSequenceObj = (TransactionSequence) session
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
				transactionSequenceObj.setLastChgDate(currentDate1);
				hbt.update(transactionSequenceObj);
				}
			}
			
			if(tsn>0 && (int)(Math.log10(tsn)+1)==2)
			{
			hinNo = "00" + (tsn + 1);
			
			}
			else if(tsn>0 && (int)(Math.log10(tsn)+1)==3)
			{
			hinNo = "0" + (tsn + 1);
			
			}
			else if(tsn>0 && (int)(Math.log10(tsn)+1)==4)
			{
			hinNo = "" + (tsn + 1);
			
			}
			else{
				hinNo = "000" + (tsn + 1);
			}
			hinNo = generateTemporaryRegNum(hinNo, box.getInt("referHospital"+i));
			patient.setHinNo(hinNo);
			hbt.save(patient);
				
				hinId=patient.getId();
	//------------------------save data in visit------------------------------------------//
				int opsessionId = 0;
				sessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).list();
				if(sessionList.size()>0){
					opsessionId = sessionList.get(0).getId();
				}
				visitList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("Hin.Id", hinId)).list();
				// .setProjection(Projections.property("VisitNo"))
				System.out.println("visitList==111==="+visitList.size());
				if (visitList.size() >= 0) {
					for (Visit vist : visitList) {
						System.out.println("visitNo111=="+vist.getVisitNo());
						visitNo = vist.getVisitNo();
						System.out.println("visitNo222==="+visitNo + 1);
					}
					visitNo = visitNo + 1;

				}
				
				queue=new QueueManagment();
				 boolean ispreviouesToken=false;
					Visit visit=new Visit();	
					// Method for getting Today's Resevered Queue number of online Appointment of patient based on Hospital and Department
					map=getTotalVistByHospital(box.getInt("referHospital"+i), labDepartmentId, new Date(), hinId,opsessionId);
					if(null !=map.get("ispreviouesToken")){
						ispreviouesToken=(Boolean)map.get("ispreviouesToken");
					}
					if(null !=map.get("TotaltokenNo")){
						totalHospitalVisitNo=(Integer)map.get("TotaltokenNo");
					}
					if(!ispreviouesToken){
					totalHospitalVisitNo=totalHospitalVisitNo+1;
					}
					/*else{
						totalHospitalVisitNo=totalHospitalVisitNo;
					}*/
					
					visit.setTotalHospitalVisit( (int)totalHospitalVisitNo);
					queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
					visit.setAge(HMSUtil.calculateAge(dob));
					visit.setStatus("y");
					visit.setEdStatus("n");
					visit.setCurPharVisitStatus("y");
					visit.setOpenby(user2);
					visit.setOpenat(time);
					visit.setOpVisitTime(time);
					visit.setPriorityNumber(3);
					MasSession masSession = new MasSession();
					masSession.setId(opsessionId);
					visit.setVisitSession(masSession);
					reservedTokenMap=getReseveredTokenNo(labDepartmentId,box.getInt("referHospital"+i));
					
					int maxTokenNo = 0;
					if(onlineRegStatus.equals("")){
					
					maxTokenNo =getTokenNoForDepartment(labDepartmentId, box.getInt("referHospital"+i),opsessionId);
					
					tokenNo = maxTokenNo + 1;
					if(reservedTokenMap.containsKey(String.valueOf(tokenNo))){
						tokenNo = tokenNo + 1; 
					}
					visit.setAppointmentType("D");
					}
					else{
							if(null !=reservedTokenMap.get("patientWithTokenMap")){
								patientWithTokenMap=(Map<Integer,Object>)reservedTokenMap.get("patientWithTokenMap");
								if(null !=patientWithTokenMap.get(hinId))
									tokenNo=(Integer)patientWithTokenMap.get(hinId);
								visit.setAppointmentType("A");
								}
							else {
								maxTokenNo = getTokenNoForDepartment(labDepartmentId, box.getInt("referHospital"+i),opsessionId);
						
								tokenNo = maxTokenNo + 1;
								visit.setAppointmentType("D");
							}
					}
				
				visit.setTokenNo(tokenNo);
				visit.setVisitNo(visitNo);
				visit.setVisitDate(new Date());
				visit.setVisitTime(time);
				MasDepartment md=new MasDepartment();
				md.setId(labDepartmentId);
				visit.setDepartment(md);
				
				visit.setAddEditDate(new Date());
				visit.setAddEditTime(time);
				visit.setVisitStatus("c");
				
				Users user=new Users();
				user.setId(box.getInt("userId"));
				visit.setAddEditBy(user);
				
				
				Patient pt=new Patient();
				pt.setId(hinId);
				visit.setHin(pt);
				visit.setHospital(hospital);
				hbt.save(visit);
				queue.setDepartment(md);
				queue.setPriorityNumber(1);
				queue.setHin(patient);
				queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
				queue.setHospital(hospital);
				queue.setTokenNo(tokenNo);
				queue.setLsCngDate(new Date());
				queue.setTokenStatus("w");
				queue.setOpVisitTime(time);
				queue.setVisit(visit);
				queue.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				queue.setLastChgTime(time);
				hbt.save(queue);
				visitId=visit.getId();
		//------------------------save data in dgOrderHd-------------------------------	
				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setOrderTime(time);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("referHospital"+i));
				dgOrderhd.setHospital(masHospital);
				
				dgOrderhd.setHin(patient);
				dgOrderhd.setDepartment(md);
				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setVisit(visit);
				String orderSeqNo = generateOrderNumber();
				dgOrderhd.setOrderNo(orderSeqNo);
				dgOrderhd.setOrderStatus("C");
				dgOrderhd.setLastChgBy(user);
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgOrderhd.setLastChgTime(time);
				if(box.getString("smearNo"+i) != null){
					dgOrderhd.setSmearNo(box.getString("smearNo")+i);
				}
				//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				hbt.save(dgOrderhd);
		//-----------------------------------------------save data dgorder dt-----------------------------------//
			DgOrderdt dgOrderdt = new DgOrderdt();
			dgOrderdt.setOrderhd(dgOrderhd);
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(box.getInt("chargeCodeId"+i));
			dgOrderdt.setChargeCode(masChargeCode);
			dgOrderdt.setOrderQty(1);
			dgOrderdt.setOrderStatus("C");
			dgOrderdt.setLastChgBy(user);
			dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgOrderdt.setLastChgTime(time);
			MasMainChargecode mainChargecode = new MasMainChargecode();
			
			mainChargecode.setId(box.getInt("mainChargeCodeId"+i));
			dgOrderdt.setMainChargecode(mainChargecode);
			
			MasSubChargecode masSubChargecode = new MasSubChargecode();
			
			masSubChargecode.setId(box.getInt("subChargeCodeId"+i));
			dgOrderdt.setSubChargeid(masSubChargecode);
			dgOrderdt.setPaymentMade("n");
			dgOrderdt.setMsgSent("n");
			dgOrderdt.setPacsStatus("n");
			hbt.save(dgOrderdt);
			
			//-----------------------------------------------save data dg sample Collection----------------------------------//		
			DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
			dgSampleCollectionHeader.setHin(patient);
			dgSampleCollectionHeader.setOrder(dgOrderhd);
			dgSampleCollectionHeader.setLastChgBy(user);
			dgSampleCollectionHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgSampleCollectionHeader.setLastChgTime(time);
			dgSampleCollectionHeader.setDepartment(md);
			dgSampleCollectionHeader.setHospital(masHospital);
			dgSampleCollectionHeader.setOrderStatus("C");
			dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgSampleCollectionHeader.setDiagnosisTime(time);
			MasHospital refHospital = new MasHospital();
			refHospital.setId(box.getInt("referHospital"+i));
			dgSampleCollectionHeader.setReferHospital(refHospital);
			hbt.save(dgSampleCollectionHeader);
			//-----------------------------------------------save data dg sample Collection----------------------------------//		
			DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
			dgSampleCollectionDetails.setSampleCollectionHeader(dgSampleCollectionHeader);
			dgSampleCollectionDetails.setChargeCode(masChargeCode);
			dgSampleCollectionDetails.setCollected("y");
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("employeeId"));
			dgSampleCollectionDetails.setCollectedBy(masEmployee);
			dgSampleCollectionDetails.setOrderStatus("P");
			dgSampleCollectionDetails.setLastChgBy(user);
			dgSampleCollectionDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgSampleCollectionDetails.setLastChgTime(time);
			DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
			dgMasInvestigation.setId(box.getInt("investigationId"+i));
			dgSampleCollectionDetails.setInvestigation(dgMasInvestigation);
			
			dgSampleCollectionDetails.setMaincharge(mainChargecode);
			dgSampleCollectionDetails.setSubcharge(masSubChargecode);
			if(box.getInt("containerId"+i) != 0){
				DgMasCollection dgMasCollection = new DgMasCollection();
				dgMasCollection.setId(box.getInt("containerId"+i));
				dgSampleCollectionDetails.setContainer(dgMasCollection);
			}
			if(box.getInt("sampleId"+i) != 0){
				MasSample masSample = new MasSample();
				masSample.setId(box.getInt("sampleId"+i));
				dgSampleCollectionDetails.setSample(masSample);
			}
			dgSampleCollectionDetails.setReferStatus("y");
	//------------------------------------generate diag no-------------------------------------------------//		
			DiagParam dgParam = null;
			synchronized (this) {
				if(box.getInt("containerId"+i) != 0){
				dgParam =(DiagParam) session
						.createCriteria(DiagParam.class)
						.add(Restrictions.eq("SubCharge.Id", dgOrderdt
								.getSubChargeid().getId())) 
						.add(Restrictions.eq("Container.Id",box.getInt("containerId"+i)))
						.add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).uniqueResult(); 
				}else{
					List<DiagParam> diagList=new ArrayList<DiagParam>();
					 diagList= session
							.createCriteria(DiagParam.class)
							.add(Restrictions.eq("SubCharge.Id", dgOrderdt
									.getSubChargeid().getId())) 
							.add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).list(); 
					 
					 if(diagList!=null && diagList.size()>0){
						 dgParam=diagList.get(0); 
					 }
				}
			}	 
			List<MasSubChargecode> subChargeCodeList  = new ArrayList<MasSubChargecode>();
			subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.idEq(dgOrderdt.getSubChargeid().getId())).list();
			String subChargeCode = "";
			if(subChargeCodeList.size()>0){
				subChargeCode = subChargeCodeList.get(0).getSubChargecodeCode();
			}
			if(dgParam==null){ 
					
					dgParam= new DiagParam();
					
					dgParam.setMainCharge(mainChargecode);
					dgParam.setSubCharge(masSubChargecode);
					dgParam.setChargeCode(masChargeCode);
					if (box.getInt("containerId"+i) != 0) {
						DgMasCollection dgMasCollection2 = new DgMasCollection();
						dgMasCollection2.setId(box.getInt("containerId"+i));
						dgParam.setContainer(dgMasCollection2);
					}
					
					dgParam.setSeqNo(1);
					dgParam.setPrefix(subChargeCode.substring(0, 2));
					dgParam.setCriteria("C");
					dgParam.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					dgParam.setLastChgTime(time);
					dgParam.setLastChgBy(user);
					dgParam.setHospital(masHospital);
					hbt.save(dgParam); 
					dgSampleCollectionDetails.setDiagNo(""
							+ dgParam.getSeqNo()); 
				}else{ 
					if(diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i))==null){
						dgParam.setSeqNo(dgParam.getSeqNo()+1);
						hbt.update(dgParam);
						diagParamMap.put(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i), dgParam);
						dgSampleCollectionDetails.setDiagNo(""+dgParam.getSeqNo()); 
					}else{
						
						DiagParam diagParam =diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i) != null?box.getInt("containerId"+i):""); 
						dgSampleCollectionDetails.setDiagNo(""+diagParam.getSeqNo());
						
					}
				}
				hbt.save(dgSampleCollectionDetails);
				if(box.getInt("phInvestigationId"+i) !=0){
					PhInvestigationSampleDetail phInvestigationSampleDetail = (PhInvestigationSampleDetail)hbt.load(PhInvestigationSampleDetail.class, box.getInt("phInvestigationId"+i));
						phInvestigationSampleDetail.setStatus("y");
						hbt.update(phInvestigationSampleDetail);
					}
			
	}else if(patientList.size()>0){
			for(Patient patient:patientList){
				hinId=patient.getId();
			}
//------------------------save data in visit------------------------------------------//
			int opsessionId = 0;
			sessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).list();
			if(sessionList.size()>0){
				opsessionId = sessionList.get(0).getId();
			}
			visitList = session.createCriteria(Visit.class)
					.add(Restrictions.eq("Hin.Id", hinId)).list();
			// .setProjection(Projections.property("VisitNo"))
			if (visitList.size() >= 0) {
				for (Visit vist : visitList) {
					visitNo = vist.getVisitNo();
					visitNo = visitNo + 1;
				}

			}
			
			queue=new QueueManagment();
			 boolean ispreviouesToken=false;
				Visit visit=new Visit();	
				// Method for getting Today's Resevered Queue number of online Appointment of patient based on Hospital and Department
				map=getTotalVistByHospital(box.getInt("referHospital"+i), labDepartmentId, new Date(), hinId,opsessionId);
				if(null !=map.get("ispreviouesToken")){
					ispreviouesToken=(Boolean)map.get("ispreviouesToken");
				}
				if(null !=map.get("TotaltokenNo")){
					totalHospitalVisitNo=(Integer)map.get("TotaltokenNo");
				}
				if(!ispreviouesToken){
				totalHospitalVisitNo=totalHospitalVisitNo+1;
				}
				/*else{
					totalHospitalVisitNo=totalHospitalVisitNo;
				}*/
				
				visit.setTotalHospitalVisit( (int)totalHospitalVisitNo);
				queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
				visit.setAge(HMSUtil.calculateAge(dob));
				visit.setStatus("y");
				visit.setEdStatus("n");
				visit.setCurPharVisitStatus("y");
				Users user=new Users();
				user.setId(box.getInt("userId"));
				visit.setOpenby(user);
				visit.setOpenat(time);
				visit.setOpVisitTime(time);
				visit.setPriorityNumber(3);
				MasSession masSession = new MasSession();
				masSession.setId(opsessionId);
				visit.setVisitSession(masSession);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("referHospital"+i));
				visit.setHospital(hospital);
				
				reservedTokenMap=getReseveredTokenNo(labDepartmentId,box.getInt("referHospital"+i));
				
				int maxTokenNo = 0;
				if(onlineRegStatus.equals("")){
				
				maxTokenNo =getTokenNoForDepartment(labDepartmentId, box.getInt("referHospital"+i),opsessionId);
				
				tokenNo = maxTokenNo + 1;
				if(reservedTokenMap.containsKey(String.valueOf(tokenNo))){
					tokenNo = tokenNo + 1; 
				}
				visit.setAppointmentType("D");
				}
				else{
						if(null !=reservedTokenMap.get("patientWithTokenMap")){
							patientWithTokenMap=(Map<Integer,Object>)reservedTokenMap.get("patientWithTokenMap");
							if(null !=patientWithTokenMap.get(hinId))
								tokenNo=(Integer)patientWithTokenMap.get(hinId);
							visit.setAppointmentType("A");
							}
						else {
							maxTokenNo = getTokenNoForDepartment(labDepartmentId, box.getInt("referHospital"+i),opsessionId);
					
							tokenNo = maxTokenNo + 1;
							visit.setAppointmentType("D");
						}
				}
			
			visit.setTokenNo(tokenNo);
			visit.setVisitNo(visitNo);
			visit.setVisitDate(new Date());
			visit.setVisitTime(time);
			MasDepartment md=new MasDepartment();
			md.setId(labDepartmentId);
			visit.setDepartment(md);
			visit.setVisitStatus("c");
			
			visit.setAddEditDate(new Date());
			visit.setAddEditTime(time);
			
			
			visit.setAddEditBy(user);
			
			Patient pt=new Patient();
			pt.setId(hinId);
			visit.setHin(pt);
			
			hbt.save(visit);
			queue.setDepartment(md);
			queue.setPriorityNumber(1);
			Patient patient = new Patient();
			patient.setId(hinId);
			queue.setHin(patient);
			queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("referHospital"+i));
			queue.setHospital(masHospital);
			queue.setTokenNo(tokenNo);
			queue.setLsCngDate(new Date());
			queue.setTokenStatus("w");
			queue.setOpVisitTime(time);
			queue.setVisit(visit);
			queue.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			queue.setLastChgTime(time);
			hbt.save(queue);
			visitId=visit.getId();
	//------------------------save data in dgOrderHd-------------------------------	
			DgOrderhd dgOrderhd = new DgOrderhd();
			dgOrderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgOrderhd.setOrderTime(time);
			
			dgOrderhd.setHospital(masHospital);
			
			dgOrderhd.setHin(patient);
			dgOrderhd.setDepartment(md);
			dgOrderhd.setPatientType("OP");
			dgOrderhd.setTestType("Regular");
			dgOrderhd.setVisit(visit);
			String orderSeqNo = generateOrderNumber();
			dgOrderhd.setOrderNo(orderSeqNo);
			dgOrderhd.setOrderStatus("C");
			dgOrderhd.setLastChgBy(user);
			dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			dgOrderhd.setLastChgTime(time);
			//dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			if(box.getString("smearNo"+i) != null){
				dgOrderhd.setSmearNo(box.getString("smearNo"+i));
			}
			hbt.save(dgOrderhd);
	//-----------------------------------------------save data dgorder dt-----------------------------------//
		DgOrderdt dgOrderdt = new DgOrderdt();
		dgOrderdt.setOrderhd(dgOrderhd);
		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(box.getInt("chargeCodeId"+i));
		dgOrderdt.setChargeCode(masChargeCode);
		dgOrderdt.setOrderQty(1);
		dgOrderdt.setOrderStatus("C");
		dgOrderdt.setLastChgBy(user);
		dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		dgOrderdt.setLastChgTime(time);
		MasMainChargecode mainChargecode = new MasMainChargecode();
		mainChargecode.setId(box.getInt("mainChargeCodeId"+i));
		dgOrderdt.setMainChargecode(mainChargecode);
		
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(box.getInt("subChargeCodeId"+i));
		dgOrderdt.setSubChargeid(masSubChargecode);
		dgOrderdt.setPaymentMade("n");
		dgOrderdt.setMsgSent("n");
		dgOrderdt.setPacsStatus("n");
		hbt.save(dgOrderdt);
		List<MasSubChargecode>subChargeCodeList = new ArrayList<MasSubChargecode>();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class).add(Restrictions.idEq(dgOrderdt.getSubChargeid().getId())).list();
		String subChargeCode = "";
		if(subChargeCodeList.size()>0){
			subChargeCode = subChargeCodeList.get(0).getSubChargecodeCode();
		}
		//-----------------------------------------------save data dg sample Collection----------------------------------//		
		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setHin(patient);
		dgSampleCollectionHeader.setOrder(dgOrderhd);
		dgSampleCollectionHeader.setLastChgBy(user);
		dgSampleCollectionHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		dgSampleCollectionHeader.setLastChgTime(time);
		dgSampleCollectionHeader.setDepartment(md);
		dgSampleCollectionHeader.setHospital(masHospital);
		dgSampleCollectionHeader.setOrderStatus("C");
		dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		dgSampleCollectionHeader.setDiagnosisTime(time);
		MasHospital refHospital = new MasHospital();
		refHospital.setId(box.getInt("referHospital"+i));
		dgSampleCollectionHeader.setReferHospital(refHospital);
		hbt.save(dgSampleCollectionHeader);
		//-----------------------------------------------save data dg sample Collection----------------------------------//		
		DgSampleCollectionDetails dgSampleCollectionDetails = new DgSampleCollectionDetails();
		dgSampleCollectionDetails.setSampleCollectionHeader(dgSampleCollectionHeader);
		dgSampleCollectionDetails.setChargeCode(masChargeCode);
		dgSampleCollectionDetails.setCollected("y");
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(box.getInt("employeeId"));
		dgSampleCollectionDetails.setCollectedBy(masEmployee);
		dgSampleCollectionDetails.setOrderStatus("P");
		dgSampleCollectionDetails.setLastChgBy(user);
		dgSampleCollectionDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		dgSampleCollectionDetails.setLastChgTime(time);
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		dgMasInvestigation.setId(box.getInt("investigationId"+i));
		dgSampleCollectionDetails.setInvestigation(dgMasInvestigation);
		
		dgSampleCollectionDetails.setMaincharge(mainChargecode);
		dgSampleCollectionDetails.setSubcharge(masSubChargecode);
		DgMasCollection dgMasCollection = new DgMasCollection();
		if (box.getInt("containerId"+i) != 0) {
		dgMasCollection.setId(box.getInt("containerId"+i));
		dgSampleCollectionDetails.setContainer(dgMasCollection);
		}
		if (box.getInt("sampleId"+i) != 0) {
			MasSample masSample = new MasSample();
			masSample.setId(box.getInt("sampleId"+i));
			dgSampleCollectionDetails.setSample(masSample);
		}
		dgSampleCollectionDetails.setReferStatus("y");
//------------------------------------generate diag no-------------------------------------------------//		
		DiagParam dgParam = null;
		synchronized (this) {
			if(box.getInt("containerId"+i) != 0){
			dgParam =(DiagParam) session
					.createCriteria(DiagParam.class)
					.add(Restrictions.eq("SubCharge.Id", dgOrderdt
							.getSubChargeid().getId())) 
					.add(Restrictions.eq("Container.Id",box.getInt("containerId"+i)))
					.add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).uniqueResult(); 
			}else{
				List<DiagParam> diagList=new ArrayList<DiagParam>();
				 diagList= session
						.createCriteria(DiagParam.class)
						.add(Restrictions.eq("SubCharge.Id", dgOrderdt
								.getSubChargeid().getId())) 
						.add(Restrictions.eq("Hospital.Id", box.getInt("referHospital"+i))).list(); 
				 
				 if(diagList!=null && diagList.size()>0){
					 dgParam=diagList.get(0); 
				 }
			}
		}	 
			if(dgParam==null){ 
				
				dgParam= new DiagParam();
				
				dgParam.setMainCharge(mainChargecode);
				dgParam.setSubCharge(masSubChargecode);
				dgParam.setChargeCode(masChargeCode);
				if (box.getInt("containerId"+i) != 0) {
					DgMasCollection dgMasCollection2 = new DgMasCollection();
					dgMasCollection2.setId(box.getInt("containerId"+i));
					dgParam.setContainer(dgMasCollection2);
				}
				
				dgParam.setSeqNo(1);
				dgParam.setPrefix(subChargeCode.substring(0, 2));
				dgParam.setCriteria("C");
				dgParam.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				dgParam.setLastChgTime(time);
				dgParam.setLastChgBy(user);
				dgParam.setHospital(masHospital);
				hbt.save(dgParam); 
				dgSampleCollectionDetails.setDiagNo(""
						+ dgParam.getSeqNo()); 
			}else{ 
				if(diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i))==null){
					dgParam.setSeqNo(dgParam.getSeqNo()+1);
					hbt.update(dgParam);
					diagParamMap.put(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i), dgParam);
					dgSampleCollectionDetails.setDiagNo(""+dgParam.getSeqNo()); 
				}else{
					
					DiagParam diagParam =diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+box.getInt("containerId"+i) != null?box.getInt("containerId"+i):""); 
					dgSampleCollectionDetails.setDiagNo(""+diagParam.getSeqNo()); 
				}
			}
			hbt.save(dgSampleCollectionDetails);
			if(box.getInt("phInvestigationId"+i) !=0){
				PhInvestigationSampleDetail phInvestigationSampleDetail = (PhInvestigationSampleDetail)hbt.load(PhInvestigationSampleDetail.class, box.getInt("phInvestigationId"+i));
					phInvestigationSampleDetail.setStatus("y");
					hbt.update(phInvestigationSampleDetail);
				}
			}
	
		}
	}
		//tx.rollback();
		tx.commit(); 
		saved = true;
		}catch(Exception e){
		e.printStackTrace();
		if(tx!=null){
			tx.rollback();
			}
		}
		
	
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> htmlWorksheet(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> labWorksheetList = new ArrayList<Object[]>();
		
		String hin_no = "";
		
		Date fromDate = new Date();
		Date toDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int hospitalId = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (dataMap.get("hin_no")!=null) {
			hin_no = (String) dataMap.get("hin_no");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		if ( dataMap.get("fromDate")!= null) {
			fromDate = (Date) dataMap.get("fromDate");
			
			
		}
		if (dataMap.get("toDate") != null) {
			toDate = (Date) dataMap.get("toDate");
		}	
		String query = "";
		if(hin_no.equals("")){
		
		query = "select pt.hin_id,pt.full_name,pt.age,msex.administrative_sex_name,pt.hin_no,"
				+ "(presby.first_name||'  '||coalesce(presby.middle_name,' ')||'  '||coalesce(presby.last_name,' ')) as prescribe_by ,dmi.investigation_name ,"
				+ " case when ms.sample_description='' then '-'"
				+ " when ms.sample_description is null then '-'"
				+ " else ms.sample_description end as sample_desc,"
				+ " case when  doh.routine_urgent_status='' then '-'"
				+ " when doh.routine_urgent_status is null  then '-' "
				+ " when doh.routine_urgent_status='r'  then 'Routine' "
				+ " when doh.routine_urgent_status='u'  then 'Urgent'"
				+ " else doh.routine_urgent_status end as routine_urgent_status,"
				+ " dot.order_status as dt_order_status,"
				+ " case when dot.order_status='P' then 'Pending For Collection'"
				+ " when dot.order_status='C' then 'Pending For Sample Validation'"
				+ " when dscd.order_status='A' then 'Pending For Result Entry'"
				+ " when dred.result_detail_status='P' then 'Pending For Result Validation'"
				+ " when (dred.validated='V') AND (dred.result_detail_status='A') then 'Result Validated'"
				+ " end status,dscd.order_status,dred.validated,dred.result_detail_status,dot.orderdt_id from dg_orderdt as dot left outer join dg_orderhd doh on doh.orderhd_id=dot.orderhd_id left outer join patient pt on pt.hin_id=doh.hin_id"
				+ " left outer join mas_administrative_sex msex on msex.administrative_sex_id=pt.sex_id"
				+ " left outer join mas_employee presby on presby.employee_id=doh.prescribed_by"
				+ " left outer join mas_charge_code mcc on mcc.charge_code_id=dot.charge_code_id"
				+ " left outer join dg_mas_investigation dmi on dmi.charge_code_id=mcc.charge_code_id"
				+ " left outer join mas_sample ms on ms.sample_id=dmi.sample_id"
				+ " left outer join dg_sample_collection_header dsch on dsch.order_id=doh.orderhd_id"
				+ " left outer join dg_sample_collection_details dscd on dscd.sample_collection_header_id=dsch.sample_collection_header_id"
				+ " left outer join dg_result_entry_header dreh on dreh.sample_collection_header_id=dsch.sample_collection_header_id"
				+ " left outer join dg_result_entry_detail dred on dred.result_entry_id=dreh.result_entry_id"
				+ " where doh.hospital_id = " + hospitalId + " and doh.order_date between '"+sdf.format(fromDate) +"' and '"+ sdf.format(toDate) + "'"
				+ " group by pt.hin_id,pt.full_name,pt.age,msex.administrative_sex_name,pt.hin_no,presby.first_name,presby.middle_name,presby.last_name,"
				+ " dmi.investigation_name , ms.sample_description,doh.routine_urgent_status,dot.order_status,"
				+ " dscd.order_status,dred.result_detail_status,dred.validated,doh.order_date,dot.orderdt_id "; 
		}else{
			query = "select pt.hin_id,pt.full_name,pt.age,msex.administrative_sex_name,pt.hin_no,"
					+ "(presby.first_name||'  '||coalesce(presby.middle_name,' ')||'  '||coalesce(presby.last_name,' ')) as prescribe_by ,dmi.investigation_name"
					+ ","
					+ " case when ms.sample_description='' then '-'"
					+ " when ms.sample_description is null then '-'"
					+ " else ms.sample_description end as sample_desc,"
					+ " case when  doh.routine_urgent_status='' then '-'"
					+ " when doh.routine_urgent_status is null  then '-' "
					+ " when doh.routine_urgent_status='r'  then 'Routine' "
					+ " when doh.routine_urgent_status='u'  then 'Urgent'"
					+ " else doh.routine_urgent_status end as routine_urgent_status,"
					+ " dot.order_status as dt_order_status,"
					+ " case when dot.order_status='P' then 'Pending For Collection'"
					+ " when dot.order_status='C' then 'Pending For Sample Validation'"
					+ " when dscd.order_status='A' then 'Pending For Result Entry'"
					+ " when dred.result_detail_status='P' then 'Pending For Result Validation'"
					+ " when (dred.validated='V') AND (dred.result_detail_status='A') then 'Result Validated'"
					+ " end status,dscd.order_status,dred.validated,dred.result_detail_status,dot.orderdt_id from dg_orderdt as dot left outer join dg_orderhd doh on doh.orderhd_id=dot.orderhd_id left outer join patient pt on pt.hin_id=doh.hin_id"
					+ " left outer join mas_administrative_sex msex on msex.administrative_sex_id=pt.sex_id"
					+ " left outer join mas_employee presby on presby.employee_id=doh.prescribed_by"
					+ " left outer join mas_charge_code mcc on mcc.charge_code_id=dot.charge_code_id"
					+ " left outer join dg_mas_investigation dmi on dmi.charge_code_id=mcc.charge_code_id"
					+ " left outer join mas_sample ms on ms.sample_id=dmi.sample_id"
					+ " left outer join dg_sample_collection_header dsch on dsch.order_id=doh.orderhd_id"
					+ " left outer join dg_sample_collection_details dscd on dscd.sample_collection_header_id=dsch.sample_collection_header_id"
					+ " left outer join dg_result_entry_header dreh on dreh.sample_collection_header_id=dsch.sample_collection_header_id"
					+ " left outer join dg_result_entry_detail dred on dred.result_entry_id=dreh.result_entry_id"
					+ " where pt.hin_no = '" + hin_no + "' and doh.hospital_id = " + hospitalId + " and doh.order_date between '"+sdf.format(fromDate) +"' and '"+ sdf.format(toDate) + "'"
					+ " group by pt.hin_id,pt.full_name,pt.age,msex.administrative_sex_name,pt.hin_no,presby.first_name,presby.middle_name,presby.last_name,"
					+ " dmi.investigation_name , ms.sample_description,doh.routine_urgent_status,dot.order_status,"
					+ " dscd.order_status,dred.result_detail_status,dred.validated,doh.order_date,dot.orderdt_id "; 
		}
		labWorksheetList = session.createSQLQuery(query).list();
		map.put("labWorksheetList", labWorksheetList);
		return map;
	}
	
	public synchronized String generateTemporaryRegNum(String HinNo,
			int hospitalId) {
		String temUHid = "";
		String temHosp="";

		Calendar currentDate = Calendar.getInstance(); // Get the current date
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy"); 
		String dateNow = formatter.format(currentDate.getTime());
		
		
		int length = (int)(Math.log10(hospitalId)+1);
		if(length==1.)
		{
			temHosp="0000"+String.valueOf(hospitalId);
			
		}
		else if(length==2){
			temHosp="000"+String.valueOf(hospitalId);
		}
		else if(length==3){
			temHosp="00"+String.valueOf(hospitalId);
		}
		else if(length==4){
			temHosp="0"+String.valueOf(hospitalId);
		}
		else{
			temHosp=String.valueOf(hospitalId);
		}


		temUHid = "T" + temHosp + dateNow + HinNo;
		logger.info("temUHid " + temUHid);
		return temUHid;

	}
	
	public Map<String, Object> getReseveredTokenNo(int departmentId,
			int hospitalId) {
		
		Session session = (Session) getSession();
		List<AppPatientAppointments> patientAppointList = new ArrayList<AppPatientAppointments>();
		Map<String, Object> reservedTokenMap = new HashMap<String, Object>();
		Map<Integer, Object> patientWithTokenMap = new HashMap<Integer, Object>();
		Date currentDate = new Date();
		
		Criteria crt=null;
		
		crt=session.createCriteria(AppPatientAppointments.class);
		crt.createAlias("Hospital","hosp");
		crt.createAlias("Department", "dept");
		crt.add(Restrictions.eq("AppointmentDate", currentDate));
		/*.add(Restrictions.eq("RegisterVisit", "P"))*/
		crt.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase());
		crt.add(Restrictions.eq("RegisteredStatus", "y").ignoreCase());
		crt.add(Restrictions.eq("hosp.Id", hospitalId));
		crt.add(Restrictions.eq("dept.Id", departmentId));
		
		patientAppointList=crt.list();
		
		if(null !=patientAppointList && patientAppointList.size()>0){
			for(AppPatientAppointments patientAppointment:patientAppointList){
				reservedTokenMap.put(String.valueOf(patientAppointment.getQueuePriority()), patientAppointment.getQueuePriority());
				patientWithTokenMap.put(patientAppointment.getHin().getId(), patientAppointment.getQueuePriority());
			}
			reservedTokenMap.put("patientWithTokenMap", patientWithTokenMap);
		}
		
		return reservedTokenMap;
	}
	
	public synchronized int getTokenNoForDepartment(int departmentId,
			int hospitalId,int visitSessionId) {
		//

		List<Integer> tokenNoList = new ArrayList<Integer>();
		List<Integer> visit = new ArrayList<Integer>();
		int tokenNo = 0;
		Date date = new Date();
		Session session = (Session) getSession();

		String qury = "select max(v.TokenNo) from Visit v where v.VisitDate=:date and v.Department.Id=:dept and v.Hospital.Id=:h and v.AppointmentType=:appointmentType and v.VisitSession.Id=:visitSessionId";

		Query query = session.createQuery(qury);
		query.setParameter("date", new java.sql.Date(date.getTime()));
		query.setParameter("dept", departmentId);
		query.setParameter("h", hospitalId);
		query.setParameter("appointmentType", "D");
		query.setParameter("visitSessionId", visitSessionId);
		
		visit = query.list();
		if (visit.get(0) != null) {
			tokenNo = visit.get(0);
		}
		

		return tokenNo;
	}
	public synchronized Map<String,Object> getTotalVistByHospital(int hospitalId, int departmentId, Date vdate,
			int pHinId,int opsessionId) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		boolean ispreviouesToken=false;
		int TotaltokenNo = 0;
		List<Integer> token = null;
		Session session = (Session) getSession();
		
		String query = "select v.TotalHospitalVisit from Visit  v where  v.Hospital.Id=:hId and v.VisitDate=:date and v.Hin.Id=:hin and v.VisitSession.Id=:opsessionId";
		//String query = "select max(v.TotalHospitalVisit) from Visit  v where  v.Hospital.Id=:hId and v.VisitDate=:date ";

		Query qur = session.createQuery(query);
		qur.setParameter("hin", pHinId);
		qur.setParameter("hId", hospitalId);
		qur.setParameter("date", vdate);
		qur.setParameter("opsessionId", opsessionId);
		token = qur.list();
		if (null !=token && token.size()>0 && null !=token.get(0)) {
			TotaltokenNo = token.get(0);
			ispreviouesToken=true;
		}
		else{
			
		String qury = "select max(v.TotalHospitalVisit) from Visit  v where  v.Hospital.Id=:hId and v.VisitDate=:date and v.VisitSession.Id=:opsessionId";
		Query q = session.createQuery(qury);

		q.setParameter("hId", hospitalId);
		q.setParameter("date", vdate);
		q.setParameter("opsessionId", opsessionId);

		token = q.list();
		if (null != token.get(0)) {
			TotaltokenNo = token.get(0);

		}
		}
		map.put("TotaltokenNo", TotaltokenNo);
		map.put("ispreviouesToken", ispreviouesToken);
		return map;
	}

	@Override
	public Map<String, Object> showInvestigationBySubChargeId(
			Map<String, Object> dataMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeCode> chargeCodeList1 = new ArrayList<MasChargeCode>();
		List<MasSubChargecode> subchargeCodeList = new ArrayList<MasSubChargecode>();
		
		int subChargeId=0;
		int mainChargeCodeId=0;
		int hospitalId=0;
		
	
		if (dataMap.get("subChargeId") != null) {
			subChargeId = (Integer) dataMap.get("subChargeId");
		}
		if (dataMap.get("mainChargeCodeId") != null) {
			mainChargeCodeId = (Integer) dataMap.get("mainChargeCodeId");
		}
		

		try {
			Session session = (Session) getSession();
			if (subChargeId >0) {
				chargeCodeList = session
						.createCriteria(DgMasInvestigation.class)
						
						// .add(Restrictions.eq("RareCommon", rareCommon))
						.createAlias("SubChargecode", "scc")
						.createAlias("ChargeCode", "cc")
						.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
						.add(Restrictions.eq("scc.Id", subChargeId))
						.add(Restrictions.eq("Status", "Y").ignoreCase())
						.addOrder(Order.asc("InvestigationName"))
						.list();
			} else if (mainChargeCodeId != 0) {
				try {
					chargeCodeList = session
							.createCriteria(DgMasInvestigation.class)
							
							// .add(Restrictions.eq("RareCommon", rareCommon))
							.createAlias("MainChargecode", "mcc")
							.createAlias("ChargeCode", "cc")
							.add(Restrictions.eq("mcc.Id", mainChargeCodeId))
							.add(Restrictions.eq("cc.Status", "Y").ignoreCase())
							.add(Restrictions.eq("Status", "Y").ignoreCase())
							.addOrder(Order.asc("InvestigationName"))
							.list();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			} 
			if (chargeCodeList.size() > 0) {
				map.put("chargeCodeList", chargeCodeList);
			} 
			subchargeCodeList = session
					.createCriteria(MasSubChargecode.class)
					
					// .add(Restrictions.eq("RareCommon", rareCommon))
					.createAlias("MainChargecode", "maincharge")
					
					.add(Restrictions.eq("maincharge.Id", mainChargeCodeId))
					
					.list();
			map.put("subchargeCodeList", subchargeCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return map;
	}
	public Map<String, Object> getChargeCodeDetailsForInvestigation(ArrayList<String> investigation,String chargeCodeName,
			int hinId) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		
		ArrayList<Integer> chargeIdList=new ArrayList<Integer>();
		ArrayList<Integer> mainChargeIdList=new ArrayList<Integer>();
		ArrayList<Integer> subChargeIdList=new ArrayList<Integer>();
		
		Criteria crit = null;
		Session session = (Session) getSession();
		int chargeId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;

		try {
			for(String s:investigation){
				chargeCodeName=s;
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeName", chargeCodeName))
					.list();
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode = chargeCodeList.get(0);
			chargeId = masChargeCode.getId();
			 mainChargeId = masChargeCode.getMainChargecode().getId();
			 subChargeId = masChargeCode.getSubChargecode().getId();
			 
			chargeIdList.add(chargeId);
			mainChargeIdList.add(mainChargeId);
			subChargeIdList.add(subChargeId);
			}
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
					map.put("patientTypeId", patientTypeId);
				}
				if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					map.put("companyId", companyId);
				}
				if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					map.put("regType", regType);
				}

			}
			map.put("chargeIdList", chargeIdList);
			map.put("mainChargeIdList", mainChargeIdList);
			map.put("subChargeIdList", subChargeIdList);
			//map.put("chargeId", chargeId);
			//map.put("mainChargeId", mainChargeId);
			//map.put("subChargeId", subChargeId);
			map.put("billTypeId", 2);
			map.put("patientCategory", "IP");
			map = getChargeAmountForInvestigation(map);
			if (patientList.size() > 0 && chargeCodeList.size() > 0) {
				map.put("chargeCodeList1", chargeCodeList);
			}
			map.put("chargeId", chargeId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	public Map<String, Object> getChargeAmountForInvestigation(
			Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasDiscount> discountList = new ArrayList<MasDiscount>();
		List<MasDiscount> criteriaDiscountList = new ArrayList<MasDiscount>();
		
		ArrayList<Integer> chargeIdList=new ArrayList<Integer>();
		ArrayList<Integer> mainChargeIdList=new ArrayList<Integer>();
		ArrayList<Integer> subChargeIdList=new ArrayList<Integer>();
		
		Criteria crit = null;
		Session session = (Session) getSession();
		BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
		int chargeId = 0;
		int patientTypeId = 0;
		int companyId = 0;
		int projectId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;
		int billTypeId = 0;
		String patientCategory = "";
		int roomTypeId = 0;
		String regType = "";

		if (detailsMap.get("chargeIdList") != null)
			chargeIdList = (ArrayList<Integer>) detailsMap.get("chargeIdList");

		if (detailsMap.get("mainChargeIdList") != null)
			mainChargeIdList = (ArrayList<Integer>) detailsMap.get("mainChargeIdList");

		if (detailsMap.get("subChargeIdList") != null)
			subChargeIdList = (ArrayList<Integer>) detailsMap.get("subChargeIdList");

		if (detailsMap.get("projectId") != null)
			companyId = (Integer) detailsMap.get("projectId");

		if (detailsMap.get("mainChargeId") != null)
			mainChargeId = (Integer) detailsMap.get("mainChargeId");

		if (detailsMap.get("subChargeId") != null)
			subChargeId = (Integer) detailsMap.get("subChargeId");

		if (detailsMap.get("billTypeId") != null)
			billTypeId = (Integer) detailsMap.get("billTypeId");

		if (detailsMap.get("roomTypeId") != null)
			roomTypeId = (Integer) detailsMap.get("roomTypeId");

		if (detailsMap.get("patientCategory") != null)
			patientCategory = (String) detailsMap.get("patientCategory");

		if (detailsMap.get("regType") != null)
			regType = (String) detailsMap.get("regType");

		Date currentDate = new Date();
		DgMasInvestigation masInvestigation=(DgMasInvestigation) session.get(DgMasInvestigation.class, chargeId);
		if(masInvestigation!=null){
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.idEq(masInvestigation.getChargeCode().getId())).list();
		}
		

		crit = session.createCriteria(MasDiscount.class)
				.add(Restrictions.le("EffectiveDateFrom", currentDate))
				.createAlias("PatientType", "pt")
				.add(Restrictions.eq("pt.Id", patientTypeId));

		if (companyId != 0) {
			crit = crit.createAlias("Company", "com").add(
					Restrictions.eq("com.Id", companyId));
		}

		criteriaDiscountList = crit.list();
		Criteria criteria = null;
		if (criteriaDiscountList.size() > 0) {

			for (MasDiscount masDiscount : criteriaDiscountList) {
				/*
				 * if(masDiscount.getMainChargecode()!=null){ }
				 */
				criteria = session.createCriteria(MasDiscount.class)
						.add(Restrictions.le("EffectiveDateFrom", currentDate))
						.createAlias("PatientType", "pt")
						.add(Restrictions.eq("pt.Id", patientTypeId));

				if (masDiscount.getCompany() != null) {
					criteria = criteria.createAlias("Company", "comp").add(
							Restrictions.eq("comp.Id", companyId));
				}

				if (masDiscount.getBillType() != null) {
					criteria = criteria.createAlias("BillType", "bt").add(
							Restrictions.eq("bt.Id", billTypeId));
				}
				if (masDiscount.getPatientCategory() != null) {
					criteria = criteria.add(Restrictions.eq("PatientCategory",
							patientCategory));
				}
				if (masDiscount.getRoomType() != null) {
					if (roomTypeId > 0) {
						criteria = criteria.createAlias("RoomType", "rt").add(
								Restrictions.eq("rt.Id", roomTypeId));
					}
				}

				if (masDiscount.getChargeCode() != null
						&& masDiscount.getSubChargecode() != null
						&& masDiscount.getMainChargecode() != null) {
					if (subChargeId != 0 && mainChargeId != 0) {
						if (chargeId == masDiscount.getChargeCode().getId()
								&& subChargeId == masDiscount
										.getSubChargecode().getId()
								&& mainChargeId == masDiscount
										.getMainChargecode().getId()) {
							criteria = criteria
									.createAlias("ChargeCode", "cc")
									.add(Restrictions.eq("cc.Id", chargeId))
									.createAlias("SubChargecode", "sc")
									.add(Restrictions.eq("sc.Id", subChargeId))
									.createAlias("MainChargecode", "mc")
									.add(Restrictions.eq("mc.Id", mainChargeId));
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
							criteria = criteria
									.createAlias("SubChargecode", "sc")
									.add(Restrictions.eq("sc.Id", subChargeId))
									.createAlias("MainChargecode", "mc")
									.add(Restrictions.eq("mc.Id", mainChargeId));
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

		BigDecimal chargeAmt = new BigDecimal(0.00);
		MasChargeCode masChargeCode = new MasChargeCode();
		if (chargeCodeList.size() > 0) {
			masChargeCode = chargeCodeList.get(0);
			// BigDecimal chargeAmt = new BigDecimal(masChargeCode.getCharge());

			Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
			if (masChargeCode.getMasChargeCodeRates() != null) {
				chargeSet = masChargeCode.getMasChargeCodeRates();
				if (chargeSet.size() > 0) {
					for (MasChargeCodeRates chargeRate : chargeSet) {
						if (currentDate.compareTo(chargeRate
								.getEffectiveFromDate()) >= 0
								&& (chargeRate.getEffectiveToDate() == null || currentDate
										.compareTo(chargeRate
												.getEffectiveToDate()) <= 0)) {
							chargeAmt = chargeRate.getRate();
							break;
						} else {
							chargeAmt = new BigDecimal(
									masChargeCode.getCharge());
						}

					}

				} else {
					chargeAmt = new BigDecimal(masChargeCode.getCharge());
				}

			} else {
				chargeAmt = new BigDecimal(masChargeCode.getCharge());
			}
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

		BigDecimal discPercnt = new BigDecimal(0);
		BigDecimal discAmt = new BigDecimal(0);
		String discTypeDB = "";
		if (discountList.size() > 0) {
			BigDecimal fixedValueDB = new BigDecimal(0.00);

			for (MasDiscount discount : discountList) {
				if (discount.getEffectiveDateTo() != null
						&& (discount.getEffectiveDateTo()
								.compareTo(currentDate) < 0)) {
					chargeAmountAfterDis = chargeAfterSD;

				} else {
					if (discount.getChargeCode() != null) {
						if (chargeId == discount.getChargeCode().getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();

							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() != null) {
						if (subChargeId == discount.getSubChargecode().getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
							break;
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() != null) {
						if (mainChargeId == discount.getMainChargecode()
								.getId()) {
							if (discount.getDiscountPercentage() != null) {
								discPercnt = discount.getDiscountPercentage();
							}
							if (discount.getDiscountValue() != null) {
								discAmt = discount.getDiscountValue();
							}
							if (discount.getFixedValue() != null) {
								fixedValueDB = discount.getFixedValue();
							}
							discTypeDB = discount.getDiscountType();
						}
					} else if (discount.getChargeCode() == null
							&& discount.getSubChargecode() == null
							&& discount.getMainChargecode() == null) {
						if (discount.getDiscountPercentage() != null) {
							discPercnt = discount.getDiscountPercentage();
						}
						if (discount.getDiscountValue() != null) {
							discAmt = discount.getDiscountValue();
						}
						if (discount.getFixedValue() != null) {
							fixedValueDB = discount.getFixedValue();
						}
						discTypeDB = discount.getDiscountType();

					}
				}
			}
			if (discPercnt.compareTo(new BigDecimal(0)) > 0) {
				discAmt = chargeAfterSD.multiply(discPercnt).divide(
						new BigDecimal(100), 2, RoundingMode.HALF_UP);
				if (discTypeDB.equalsIgnoreCase("d")) {
					chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					chargeAmountAfterDis = chargeAfterSD.add(discAmt);
					chargeAfterSD = chargeAmountAfterDis; // For Tariff case
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (discAmt.compareTo(new BigDecimal(0)) > 0) {
				if (discTypeDB.equalsIgnoreCase("d")) {
					chargeAmountAfterDis = chargeAfterSD.subtract(discAmt);
				} else if (discTypeDB.equalsIgnoreCase("t")) {
					chargeAmountAfterDis = chargeAfterSD.add(discAmt);
					chargeAfterSD = chargeAmountAfterDis;
					map.put("rate", chargeAmt.add(discAmt));
				}
			} else if (fixedValueDB.compareTo(new BigDecimal(0)) > 0) {
				if (discTypeDB.equalsIgnoreCase("f")) {
					chargeAmountAfterDis = fixedValueDB;
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
		map.put("chargeAfterSD", chargeAfterSD);
		map.put("chargeAmountAfterDis", chargeAmountAfterDis);
		map.put("discPercnt", discPercnt);
		map.put("discAmt", discAmt);
		map.put("stdDeduction", stdDeduction);
		map.put("discTypeDB", discTypeDB);
		return map;

	}
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeRate(String sdValues,
			int hinId) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<DgMasInvestigation> chargeCodeList = new ArrayList<DgMasInvestigation>();
		List<Patient> patientList = new ArrayList<Patient>();
		Criteria crit = null;
		Session session = (Session) getSession();
		Map<String,Object> rateMap=new HashMap<String,Object>();
		Map<String,Object> chargeDetailsMap=new HashMap<String,Object>();
		//String chargeCodeName="";
		String chargeCodeWithId="";
		String chargeCodeName ="";
		String tempchargeCodeName ="";
		int chargeId=0;
		String totalCharge[]=sdValues.split(",");
		try {
			int inc=1;
		for(String charge:totalCharge){
			if(null !=charge && !charge.equals("")){
				tempchargeCodeName=charge;
		int index1 = charge.lastIndexOf("[");
		 chargeCodeName = charge.substring(0, index1);
		int mainCharge = 0;
		

		
			chargeCodeList = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("InvestigationName", chargeCodeName))
					.list();
			DgMasInvestigation masChargeCode = new DgMasInvestigation();
			masChargeCode = chargeCodeList.get(0);
			chargeId = masChargeCode.getId();
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
					map.put("patientTypeId", patientTypeId);
				}
				if (patientList.get(0).getCompany() != null) {
					companyId = patient.getCompany().getId();
					map.put("companyId", companyId);
				}
				if (patient.getRegistrationType() != null) {
					regType = patient.getRegistrationType();
					map.put("regType", regType);
				}

			}
			map.put("chargeId", chargeId);
			map.put("mainChargeId", mainChargeId);
			map.put("subChargeId", subChargeId);
			map.put("billTypeId", 2);
			map.put("patientCategory", "IP");
			map = getChargeAmountAfterDiscount(map);
			chargeDetailsMap.put("chargeId"+inc, chargeId);
			chargeDetailsMap.put("mainChargeId"+inc, mainChargeId);
			chargeDetailsMap.put("subChargeId"+inc, subChargeId);
			inc++;
			rateMap.put(tempchargeCodeName, map.get("chargeAfterSD"));
		}
			if (patientList.size() > 0 && chargeCodeList.size() > 0) {
				map.put("chargeCodeList", chargeCodeList);
			} else {
				map.put("chargeCodeList", chargeCodeList);
			}
			map.put("chargeDetailsMap", chargeDetailsMap);
			map.put("chargeId", chargeId);
			map.put("rateMap", rateMap);
		}} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getLabQueue(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();
		
		
		Date currentDate = new Date();
		Integer hospitalId = 0;
		Integer departmentId=0;
		String patientType = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties property = new Properties();
			property.load(new FileInputStream(new File(resourcePath.getFile()))); 
			int labDepartmentId= Integer.parseInt(property.get("labDepartmentId").toString());
			
			//List<Integer> orderDtList=new ArrayList<Integer>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			/*crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					.createAlias("Orderhd", "orderHd")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
				.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase());
			appList=crit.list();*/
			
			/*if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
				}
			}*/
			
			/*if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			System.out.println("patientAppInvestigationList "+patientAppInvestigationList.size());
			System.out.println("patientDetailList "+patientDetailList.size());
*/
			
			List<Integer> dgOrderHdList=new ArrayList<Integer>();
			crit = session.createCriteria(PharmacyLabQueue.class)
					
					.createAlias("Department", "department")
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("department.Id", labDepartmentId))
					.add(Restrictions.eq("OpdDate", currentDate))
					
					.add(Restrictions.eq("Status", "P").ignoreCase())
					
					.addOrder(Order.asc("OpdTime"));
			pharmacyLabQueueList=crit.list();
			
			/*if(pharmacyLabQueueList.size()>0){
				for(PharmacyLabQueue labQueue:pharmacyLabQueueList){
				dgOrderHdList.add(labQueue.getDgOrderhdId().getId());
				}
			}*/
			/*if(dgOrderHdList.size()>0){
			crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.in("oh.Id", dgOrderHdList))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate));
					

			patientDetailList = crit.list();
			}*/
			
			/*crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate))
					.add( Restrictions.not( Restrictions.in("id",orderList)));

			directOrderHdList=crit.list();
			System.out.println("directOrderHdList  "+directOrderHdList.size());*/
			/*if(patientAppInvestigationList !=null && patientAppInvestigationList.size()>0){
				patientDetailList.addAll(patientAppInvestigationList);
			}*/
			
			
			/*if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*List<DgOrderhd> finalDgOrderdhList=new ArrayList<DgOrderhd>();
		for(DgOrderhd dgOrderhd:patientDetailList){
			if(dgOrderhd.getDgOrderdts().isEmpty()){
				finalDgOrderdhList.add(dgOrderhd);
			}
			
			Set<DgOrderdt> dgOrderdts=dgOrderhd.getDgOrderdts();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					finalDgOrderdhList.add(dgOrderhd);
					break;
				}
			}
			
		}*/
		
		
		map.put("pharmacyLabQueueList", pharmacyLabQueueList);
		//map.put("patientDetailList", finalDgOrderdhList);
		return map;
	}

	public Map<String, Object> getRadioQueue(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		List<PharmacyLabQueue> pharmacyLabQueueList=new ArrayList<PharmacyLabQueue>();
		
		
		Date currentDate = new Date();
		Integer hospitalId = 0;
		Integer departmentId=0;
		String patientType = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties property = new Properties();
			property.load(new FileInputStream(new File(resourcePath.getFile()))); 
			int labDepartmentId= Integer.parseInt(property.get("radiologyDepartmentId").toString());
			
			//List<Integer> orderDtList=new ArrayList<Integer>();
			//List<Integer> orderhdtList=new ArrayList<Integer>();
			/*crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					.createAlias("Orderhd", "orderHd")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
				.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase());
			appList=crit.list();*/
			
			/*if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
				}
			}*/
			
			/*if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			System.out.println("patientAppInvestigationList "+patientAppInvestigationList.size());
			System.out.println("patientDetailList "+patientDetailList.size());
*/
			
			
			crit = session.createCriteria(PharmacyLabQueue.class)
					
					.createAlias("Department", "department")
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("PharmacyLabStatus", "R").ignoreCase())
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("department.Id", labDepartmentId))
					.add(Restrictions.eq("OpdDate", currentDate))
					
					.add(Restrictions.eq("Status", "P").ignoreCase())
					
					.addOrder(Order.asc("OpdTime"));
			pharmacyLabQueueList=crit.list();
			
			/*if(pharmacyLabQueueList.size()>0){
				for(PharmacyLabQueue labQueue:pharmacyLabQueueList){
				dgOrderHdList.add(labQueue.getDgOrderhdId().getId());
				}
			}*/
			/*if(dgOrderHdList.size()>0){
			crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.in("oh.Id", dgOrderHdList))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate));
					

			patientDetailList = crit.list();
			}*/
			
			/*crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate))
					.add( Restrictions.not( Restrictions.in("id",orderList)));

			directOrderHdList=crit.list();
			System.out.println("directOrderHdList  "+directOrderHdList.size());*/
			/*if(patientAppInvestigationList !=null && patientAppInvestigationList.size()>0){
				patientDetailList.addAll(patientAppInvestigationList);
			}*/
			
			
			/*if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*List<DgOrderhd> finalDgOrderdhList=new ArrayList<DgOrderhd>();
		for(DgOrderhd dgOrderhd:patientDetailList){
			if(dgOrderhd.getDgOrderdts().isEmpty()){
				finalDgOrderdhList.add(dgOrderhd);
			}
			
			Set<DgOrderdt> dgOrderdts=dgOrderhd.getDgOrderdts();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					finalDgOrderdhList.add(dgOrderhd);
					break;
				}
			}
			
		}*/
		
		
		map.put("pharmacyLabQueueList", pharmacyLabQueueList);
		//map.put("patientDetailList", finalDgOrderdhList);
		return map;
	}
	
private String generateSampleBarcodeForLab(int hospitalId) {
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Session session = (Session) getSession();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		//String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		Date lastChangedate=null;
		Date date=new Date();
		int tsn = 0;
		int id = 0;
		Calendar lowCal = Calendar.getInstance();
		lowCal.set(Calendar.DAY_OF_YEAR, lowCal.getActualMinimum(Calendar.DAY_OF_YEAR));
		Date lowDate = lowCal.getTime();

		Calendar highCal = Calendar.getInstance();
		lowCal.set(Calendar.DAY_OF_YEAR, lowCal.getActualMaximum(Calendar.DAY_OF_YEAR));
		Date highDate = highCal.getTime();
		
		String year = HMSUtil.getDateFormat(new Date(),"YYYY");	
		List<Object[]> adList = session
				.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
				.add(Restrictions.eq("TransactionPrefix", "SNO"))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				//.add(Restrictions.eq("yeard(LastChgDate)", year))
				.add(Restrictions.between("LastChgDate", lowDate, highDate))
				.setProjection(Projections.projectionList()
						.add(Projections.property("TransactionSequenceNumber"))
						.add(Projections.property("LastChgDate"))
						.add(Projections.property("Id")))
				.list();

		if (adList.size() > 0) {
			Object[] transactionSequence = adList.get(0);
			tsn = Integer.parseInt("" + transactionSequence[0]);
			id = (Integer) transactionSequence[2];
			lastChangedate=(Date) transactionSequence[1];
			
		}
		else{
			TransactionSequence transactionSequenceObj1 = new TransactionSequence();
			//tsn = Integer.parseInt("1"); 
			transactionSequenceObj1.setTransactionSequenceNumber(1);
			transactionSequenceObj1.setLastChgDate(date);
			transactionSequenceObj1.setTransactionSequenceName("SerialNo");
			transactionSequenceObj1.setTransactionPrefix("SNO");
			transactionSequenceObj1.setTablename("Patient");
			transactionSequenceObj1.setCreatedby("admin");
			transactionSequenceObj1.setStatus("Y");
			MasHospital hosp=new MasHospital();
			hosp.setId(hospitalId);
			transactionSequenceObj1.setHospital(hosp);
			transactionSequenceObj1.setLastChgTime(time);
			hbt.save(transactionSequenceObj1);
		}
		
		if(tsn>0){
			TransactionSequence transactionSequenceObj = (TransactionSequence) session
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(tsn+1); 
			transactionSequenceObj.setLastChgDate(date);
			hbt.update(transactionSequenceObj);
			
		}
		String serialNo="";
		String hospitalSerialNo="";
		String years="";
		String sampleBarCode="";
		//added by govind 18-09-2017
		Integer hospitalCode=0;
		MasHospital hospital=hbt.load(MasHospital.class, hospitalId);
		if(hospital!=null){
			hospitalCode=Integer.parseInt(hospital.getHospitalCode());
		}
		 hospitalSerialNo=HMSUtil.getFiveDigitsId(hospitalCode);		
		//added by govind 18-09-2017 end
				
		 serialNo=getSerialNo(tsn+1);
		// hospitalSerialNo=HMSUtil.getFiveDigitsId(hospitalId);//commented by govind 18-09-2017
		 years=HMSUtil.getYear(date);
		 sampleBarCode=hospitalSerialNo+years+serialNo;
		 return sampleBarCode;
		
		}
	
 	
	
	private String getSerialNo(int tsn){
		String serialNo="";
		if(tsn>0 && (int)(Math.log10(tsn)+1)==1)
		{
			serialNo = "000000" + (tsn);
		
		}
		else if(tsn>0 && (int)(Math.log10(tsn)+1)==2)
		{
			serialNo = "00000" + (tsn);
		
		}
		else if(tsn>0 && (int)(Math.log10(tsn)+1)==3)
		{
			serialNo = "0000" + (tsn);
		
		}
		else if(tsn>0 && (int)(Math.log10(tsn)+1)==4)
		{
			serialNo = "000" + (tsn);
		
		}
		else if(tsn>0 && (int)(Math.log10(tsn)+1)==5)
		{
			serialNo = "00" + (tsn );
		
		}
		else if(tsn>0 && (int)(Math.log10(tsn)+1)==6)
		{
			serialNo = "0" + (tsn);
		
		}
		else{
			serialNo = "" + (tsn + 1);
		}
		logger.info(serialNo);
		return  serialNo;
	}
		
	
	public Map<String, Object> getSampleValidationGridRadiology(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<Object[]> temppatientDeatilList = new ArrayList<Object[]>();
		
		List<DgSampleCollectionHeader> radioQueuelList = new ArrayList<DgSampleCollectionHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		Integer hospitalId = 0;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		try {
			List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase())
			.add(Restrictions.eq("dep.Id", deptId));
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
					
				}
			}
			
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				
				crit = session
						.createCriteria(DgSampleCollectionDetails.class) 
						.createAlias("SampleCollectionHeader", "sampleHead")
						.createAlias("sampleHead.Order", "order")
						.createAlias("ChargeCode", "mcc")
						.createAlias("mcc.Department", "dep")
						.add(Restrictions.isNull("Rejected"))
						// .add(Restrictions.eq("sampleHead.OrderStatus", "C").ignoreCase())
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
						.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
						.add(Restrictions.in("order.Id", orderhdtList)) 
						.add(Restrictions.eq("dep.Id", deptId))
						.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
								Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SampleCollectionHeader"))
										.add(Projections.groupProperty("Subcharge")));
				temppatientDeatilList = crit.list();
				
			}
			
		/*crit = session
					.createCriteria(DgSampleCollectionDetails.class) 
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.PharmacyLabQueueId", "pharmacyLabQueueId")
					
					.createAlias("ChargeCode", "mcc")
					.createAlias("mcc.Department", "dep")
					
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					.add(Restrictions.isNull("Rejected"))
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
					.add(Restrictions.eq("dep.Id", deptId))
					.add(Restrictions.eq("sampleHead.DiagnosisDate", currentDate)) 
					.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
							.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))
					.add(Restrictions.eq("pharmacyLabQueueId.OpdDate", currentDate))
					.add(Restrictions.eq("pharmacyLabQueueId.Status", "P"))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge"))
									.add(Projections.groupProperty("pharmacyLabQueueId.TokenNo")));
			crit.addOrder(Order.asc("pharmacyLabQueueId.TokenNo"));
			patientDeatilList = crit.list();*/
			
		/*	List<Integer>  radioQueueIdList=new ArrayList<Integer>();
			if (patientDeatilList != null && patientDeatilList.size() > 0) { 
				
					for(int ilop=0;ilop<patientDeatilList.size();ilop++) {
					DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
					if(null !=dgSampleCollectionHeader.getId())
					radioQueueIdList.add(dgSampleCollectionHeader.getId());
					}}
			if(radioQueueIdList.size()>0){
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.createAlias("PharmacyLabQueueId", "pharmacyLabQueueId")
						//.createCriteria(PharmacyLabQueue.class) 
						
						.createAlias("Hospital", "hosp")
						.createAlias("Department", "department")
						.add(Restrictions.not(Restrictions.in("Id", radioQueueIdList)))
						.add(Restrictions.eq("department.Id", deptId))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
						.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))
						.add(Restrictions.eq("DiagnosisDate", currentDate))
						.add(Restrictions.eq("pharmacyLabQueueId.Status", "P").ignoreCase())
						.addOrder(Order.asc("pharmacyLabQueueId.TokenNo"))
						;
				radioQueuelList=crit.list();
			
				System.out.println("radioQueuelList  "+radioQueuelList.size());
			}
			
			System.out.println("radioQueuelList  "+radioQueuelList.size());
			System.out.println("patientDeatilList  "+patientDeatilList.size());
			*/
			
			if(null !=temppatientDeatilList && temppatientDeatilList.size()>0){
				patientDeatilList.addAll(temppatientDeatilList);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("patientDeatilList", patientDeatilList);
		//map.put("radioQueuelList", radioQueuelList);
		return map;
	}

	@Override
	public Map<String, Object> getSampleCollectionGridIPd(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientDetailList = new ArrayList<DgOrderhd>();
		
		List<DgOrderhd> patientAppInvestigationList = new ArrayList<DgOrderhd>();
		List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
		
		
		
		Date currentDate = new Date();
		Integer hospitalId = 0;
		Integer departmentId=0;
		String patientType = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			patientType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile()))); 
		//	int department_type_id= pacProper.get("department_type_id");
			
			//List<Integer> orderDtList=new ArrayList<Integer>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
				.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase());
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
				}
			}
			
			/*if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			System.out.println("patientAppInvestigationList "+patientAppInvestigationList.size());
			System.out.println("patientDetailList "+patientDetailList.size());
*/
			
			
			/*if(pharmacyLabQueueList.size()>0){
				for(PharmacyLabQueue labQueue:pharmacyLabQueueList){
				dgOrderHdList.add(labQueue.getDgOrderhdId().getId());
				}
			}*/
			
			crit = session.createCriteria(DgOrderhd.class)
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("OrderStatus", "P"))
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("PatientType", patientType))
					.add(Restrictions.eq("OrderDate", currentDate));
					

			patientDetailList = crit.list();
			
			
			
			/*if(patientAppInvestigationList !=null && patientAppInvestigationList.size()>0){
				patientDetailList.addAll(patientAppInvestigationList);
			}*/
			
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				crit = session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderhdtList));
				patientAppInvestigationList=crit.list();
				patientDetailList.addAll(patientAppInvestigationList);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<DgOrderhd> finalDgOrderdhList=new ArrayList<DgOrderhd>();
		for(DgOrderhd dgOrderhd:patientDetailList){
			
			Set<DgOrderdt> dgOrderdts=dgOrderhd.getDgOrderdts();
			for(DgOrderdt dgOrderdt:dgOrderdts){
				
				if("P".equalsIgnoreCase(dgOrderdt.getOrderStatus())){
					finalDgOrderdhList.add(dgOrderhd);
					break;
				}
			}
			
		}
		
		
		//map.put("pharmacyLabQueueList", pharmacyLabQueueList);
		map.put("patientDetailList", finalDgOrderdhList);
		return map;
	}

	
	

	public Map<String, Object> getSampleValidationGridRadiologyIPD(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<Object[]> temppatientDeatilList = new ArrayList<Object[]>();
		
		List<DgSampleCollectionHeader> radioQueuelList = new ArrayList<DgSampleCollectionHeader>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		int deptId = 0;
		Integer hospitalId = 0;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		logger.info("deptId "+deptId);
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		try {
			List<AppInvestigationAppointments> appList = new ArrayList<AppInvestigationAppointments>();
			List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationDate", currentDate))
					.createAlias("Department", "dep")
					.createAlias("Hospital", "hospital")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("CurrentVisitStatus", "y").ignoreCase())
			.add(Restrictions.eq("dep.Id", deptId));
			appList=crit.list();
			
			if(null !=appList && appList.size()>0){
				for(AppInvestigationAppointments appInves:appList){
					orderhdtList.add(appInves.getDgOrder().getOrderhd().getId());
					
				}
			}
			
			
			if(null !=orderhdtList && orderhdtList.size()>0){
				
				crit = session
						.createCriteria(DgSampleCollectionDetails.class) 
						.createAlias("SampleCollectionHeader", "sampleHead")
						.createAlias("sampleHead.Order", "order")
						.createAlias("ChargeCode", "mcc")
						.createAlias("mcc.Department", "dep")
						.add(Restrictions.isNull("Rejected"))
						.add(Restrictions.eq("sampleHead.OrderStatus", "C").ignoreCase())
						.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
						.add(Restrictions.in("order.Id", orderhdtList)) 
						.add(Restrictions.eq("dep.Id", deptId))
						.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
								Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SampleCollectionHeader"))
										.add(Projections.groupProperty("Subcharge")));
				temppatientDeatilList = crit.list();
				
			}
			
			
			crit = session
					.createCriteria(DgSampleCollectionDetails.class) 
					.createAlias("SampleCollectionHeader", "sampleHead")
					
					
					.createAlias("ChargeCode", "mcc")
					.createAlias("mcc.Department", "dep")
					.add(Restrictions.isNull("sampleHead.Inpatient"))
					.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
					.add(Restrictions.isNull("Rejected"))
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase()))
					.add(Restrictions.eq("dep.Id", deptId))
					.add(Restrictions.eq("sampleHead.DiagnosisDate", currentDate)) 
					.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
							
					
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			patientDeatilList = crit.list();
			
		//	List<Integer>  radioQueueIdList=new ArrayList<Integer>();
			if (patientDeatilList != null && patientDeatilList.size() > 0) { 
				
					for(int ilop=0;ilop<patientDeatilList.size();ilop++) {
					DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
				//	if(null !=dgSampleCollectionHeader.getId())
				//	radioQueueIdList.add(dgSampleCollectionHeader.getId());
					}}
			/*if(radioQueueIdList.size()>0){
				crit = session.createCriteria(DgSampleCollectionHeader.class)
						.createAlias("PharmacyLabQueueId", "pharmacyLabQueueId")
						//.createCriteria(PharmacyLabQueue.class) 
						
						.createAlias("Hospital", "hosp")
						.createAlias("Department", "department")
						.add(Restrictions.not(Restrictions.in("Id", radioQueueIdList)))
						.add(Restrictions.eq("department.Id", deptId))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						
						.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
						.add(Restrictions.eq("pharmacyLabQueueId.PharmacyLabStatus", "R"))
						.add(Restrictions.eq("DiagnosisDate", currentDate))
						.add(Restrictions.eq("pharmacyLabQueueId.Status", "P").ignoreCase())
						.addOrder(Order.asc("pharmacyLabQueueId.OpdTime"))
						;
				radioQueuelList=crit.list();
			
				System.out.println("radioQueuelList  "+radioQueuelList.size());
			}*/
			
		
			
			if(null !=temppatientDeatilList && temppatientDeatilList.size()>0){
				patientDeatilList.addAll(temppatientDeatilList);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDeatilList", patientDeatilList);
		map.put("radioQueuelList", radioQueuelList);
		return map;
	}

	@Override
	public Map<String, Object> addLabInterfaceDataToSDC(Map<String, Object> detMap) {

		List<PatientMainLabInfo> patientMainLabList = new ArrayList<PatientMainLabInfo>();
		List<PatientLabInfo> patientInfoList = new ArrayList<PatientLabInfo>();
		List<LabMachineXt2000iDetails> labMachineXt2000iDetailsList = new ArrayList<LabMachineXt2000iDetails>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		org.hibernate.Transaction trx = session.beginTransaction();
		String sampleNo = "";
		String paramName = "";
		String measurementValue = "";
		String unit = "";
		String tdate = "";
		String machineName = "";
		String timeStr = "";
		Integer hospitalId = 0;
		if (detMap.get("sampleNo") != null) {
			sampleNo = (String) detMap.get("sampleNo");
		}
		if (detMap.get("parameter") != null) {
			paramName = (String) detMap.get("parameter");
		}
		if (detMap.get("measurementValue") != null) {
			measurementValue = (String) detMap.get("measurementValue");
		}
		if (detMap.get("unit") != null) {
			unit = (String) detMap.get("unit");
		}
		if (detMap.get("tdate") != null) {
			tdate = (String) detMap.get("tdate");
		}
		if (detMap.get("machineCode") != null) {
			machineName = (String) detMap.get("machineCode");
		}
		if (detMap.get("timeStr") != null) {
			timeStr = (String) detMap.get("timeStr");
		}
		if (detMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt(detMap.get("hospitalId").toString());
		}
		// added by govind 01-12-2017 for Get Hospital Code and concate barcode
		if (hospitalId > 0) {
			MasHospital mashospital = (MasHospital) session.get(MasHospital.class, hospitalId);
			if (mashospital != null) {
				sampleNo = mashospital.getHospitalCode() + sampleNo;
			}
		}
		// added by govind 01-12-2017 end
		Map<String, Object> map = new HashMap<String, Object>();
		patientInfoList = session.createCriteria(PatientLabInfo.class).add(Restrictions.eq("SampleNo", sampleNo))
				.add(Restrictions.eq("ParameterName", paramName)).add(Restrictions.eq("Unit", unit))
				.add(Restrictions.eq("TDate", tdate)).add(Restrictions.eq("MachineCode", machineName))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		if (patientInfoList.size() > 0) {
			HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			labMachineXt2000iDetailsList = session.createCriteria(LabMachineXt2000iDetails.class)
					.add(Restrictions.eq("MachineCode", machineName)).add(Restrictions.eq("ParameterName", paramName))
					.list();
			// ResultEntry Data update started added by govind 18-09-2017
			if (labMachineXt2000iDetailsList.size() > 0) {
				logger.info("Result Entry Data Update Process Started");
				LabMachineXt2000iDetails machineDetail = labMachineXt2000iDetailsList.get(0);
				Integer investId = 0, OldInvestId = 0;
				Integer subInvestId = 0;
				String subInvestStatus="";
				subInvestStatus=machineDetail.getStatus();
				investId = machineDetail.getInvestigationId();
				subInvestId = machineDetail.getSubInvestigationId();
				DgResultEntryDetail resultEntry = null;
				List<DgResultEntryDetail> resultEntryList = new ArrayList<DgResultEntryDetail>();
				List<DgSampleCollectionDetails> collectionList = new ArrayList<DgSampleCollectionDetails>();
				collectionList = session.createCriteria(DgSampleCollectionDetails.class)
						.createAlias("SampleCollectionHeader", "sHead")
						.add(Restrictions.eq("sHead.SampleBarCode", sampleNo)).list();
				Criteria crit = session.createCriteria(DgResultEntryDetail.class)
						.createAlias("SampleCollectionDetasils", "sample")
						.createAlias("sample.SampleCollectionHeader", "sHead").createAlias("Investigation", "invest")
						.createAlias("ResultEntry", "head").createAlias("SubInvestigation", "subInvest")
						.add(Restrictions.eq("sHead.SampleBarCode", sampleNo));

				resultEntryList = crit.list();
				if (resultEntryList.size() > 0) {// Multiple Parameter Data update started
					DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
							.load(DgSubMasInvestigation.class, subInvestId);
					if (subInvestigation != null) {
						investId = subInvestigation.getInvestigation().getId();
					}
					for (DgResultEntryDetail res : resultEntryList) {
						if (res.getInvestigation().getId().equals(investId)
								&& res.getSubInvestigation().getId().equals(subInvestId)) {
							resultEntry = res;
							break;
						}
					}
					if (resultEntry != null) {
						resultEntry.setResult(measurementValue);
						hbt1.update(resultEntry);
						hbt1.refresh(resultEntry);
					} // Multiple Parameter Data update started end
				} else {// Single Parameter Data update started
					for (DgSampleCollectionDetails res : collectionList) {
						resultEntryList = session.createCriteria(DgResultEntryDetail.class)
								.add(Restrictions.eq("SampleCollectionDetails.Id", res.getId()))
								.add(Restrictions.eq("Investigation.Id", investId)).list();
						if (resultEntryList.size() > 0) {
							resultEntry = resultEntryList.get(0);
							break;
						}

					}
					if (resultEntry != null) {
						resultEntry.setResult(measurementValue);
						hbt1.update(resultEntry);
						hbt1.refresh(resultEntry);
					}
				} // Single Parameter Data update started end

			}
			logger.info("Result Entry Data Update Process End");
			// ResultEntry Data update started end added by govind 18-09-2017

		} else {
			/*
			 * System.out.println("hospitalId impl 2 "+hospitalId); //commented by govind
			 * 23-08-2017 PatientLabInfo patLab=new PatientLabInfo();
			 * patLab.setSampleNo(sampleNo); patLab.setMeasurementValue(measurementValue);
			 * patLab.setParameterName(paramName); patLab.setMachineCode(machineName);
			 * patLab.setUnit(unit); patLab.setTDate(tdate); MasHospital hosp=new
			 * MasHospital(); hosp.setId(hospitalId); patLab.setHospital(hosp);
			 * hbt.save(patLab);
			 * 
			 * PatientMainLabInfo patMainLab=new PatientMainLabInfo();
			 * patMainLab.setMachineCode(machineName); patMainLab.setSampleNo(sampleNo);
			 * patMainLab.setStatus("n"); patMainLab.setTDate(tdate);
			 * patMainLab.setTime(timeStr); patMainLab.setHospital(hosp); hbt.save(patLab);
			 */

			labMachineXt2000iDetailsList = session.createCriteria(LabMachineXt2000iDetails.class)
					.add(Restrictions.eq("MachineCode", machineName)).list();
			for (LabMachineXt2000iDetails labMachineXt2000iDetails : labMachineXt2000iDetailsList) {

				// ------------------------------------------------------------------------------------------
				if (paramName.equals(labMachineXt2000iDetails.getParameterName())) {

					try {

						int i = 0;
						List<DgSampleCollectionDetails> dgSampleCollectondetail = new ArrayList<DgSampleCollectionDetails>();

						dgSampleCollectondetail = session.createCriteria(DgSampleCollectionDetails.class)
								.createAlias("SampleCollectionHeader", "header")
								.add(Restrictions.eq("header.SampleBarCode", sampleNo)).list();
						for (DgSampleCollectionDetails dgSample : dgSampleCollectondetail) {
							int investigation_id = 0;
							investigation_id = dgSample.getInvestigation().getId();
							int subInvestId = 0;
							int subInvesCount = 0, labCount = 0;

							// added by govind 25-07-2017
							if (labMachineXt2000iDetails.getInvestigationId() == investigation_id) {
								labCount++;
							} else {
								subInvestId = labMachineXt2000iDetails.getSubInvestigationId();
								DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
										.get(DgSubMasInvestigation.class, subInvestId);
								if (subInvestigation != null) {
									subInvestId = subInvestigation.getId();
									if (dgSample.getInvestigation().getId() == subInvestigation.getInvestigation()
											.getId()) {
										investigation_id = subInvestigation.getInvestigation().getId();
										labCount++;
									}
								}
							}
							// added by govind 25-07-2017 end
							/*
							 * if(labMachineXt2000iDetails.getInvestigationId()==investigation_id) {
							 */
							if (labCount > 0) {
								labCount++;
							} else {
								subInvestId = labMachineXt2000iDetails.getSubInvestigationId();
								DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
										.get(DgSubMasInvestigation.class, subInvestId);
								if (subInvestigation != null) {
									subInvestId = subInvestigation.getId();
									if (dgSample.getInvestigation().getId() == subInvestigation.getInvestigation()
											.getId()) {
										investigation_id = subInvestigation.getInvestigation().getId();
										labCount++;
									}
								}
							}
							logger.info("New investigationId " + investigation_id + " subInvestId " + subInvestId);
							// added by govind 25-07-2017 end
							/*
							 * if(labMachineXt2000iDetails.getInvestigationId()==investigation_id) {
							 */
							if (labCount > 0) {
								// added by govind 23-08-2017
								PatientLabInfo patLab = new PatientLabInfo();
								patLab.setSampleNo(sampleNo);
								patLab.setMeasurementValue(measurementValue);
								patLab.setParameterName(paramName);
								patLab.setMachineCode(machineName);
								patLab.setUnit(unit);
								patLab.setTDate(tdate);
								MasHospital hosp = new MasHospital();
								hosp.setId(hospitalId);
								patLab.setHospital(hosp);
								hbt.save(patLab);

								PatientMainLabInfo patMainLab = new PatientMainLabInfo();
								patMainLab.setMachineCode(machineName);
								patMainLab.setSampleNo(sampleNo);
								patMainLab.setStatus("n");
								patMainLab.setTDate(tdate);
								patMainLab.setTime(timeStr);
								patMainLab.setHospital(hosp);
								hbt.save(patLab);
								// added by govind 23-08-2017 end
								Set<DgSubMasInvestigation> dgSubMasInvestigation = dgSample.getInvestigation()
										.getDgSubMasInvestigations();
								int uom_id = 0;
								int inpatient_id = 0;
								int sample_collection_detailid = dgSample.getId();
								int sample_collection_header_id = dgSample.getSampleCollectionHeader().getId();
								int charge_code_id = dgSample.getChargeCode().getId();
								int hin_id = dgSample.getSampleCollectionHeader().getHin().getId();
								if (dgSample.getSampleCollectionHeader().getInpatient() != null)
									inpatient_id = dgSample.getSampleCollectionHeader().getInpatient().getId();
								int department_id = dgSample.getSampleCollectionHeader().getDepartment().getId();
								int hospital_id = dgSample.getSampleCollectionHeader().getHospital().getId();
								int validated_By = dgSample.getSampleCollectionHeader().getValidatedBy().getId();
								int sub_charge_code_id = dgSample.getSubcharge().getId();
								int main_charge_code_id = dgSample.getMaincharge().getId();
								String investigation_type = dgSample.getInvestigation().getInvestigationType();
								if (dgSample.getInvestigation().getUom() != null)
									uom_id = dgSample.getInvestigation().getUom().getId();
								// int test_order_no=dgSample.getInvestigation().getTestOrderNo();

								// added by govind 25-07-2017
								int headerCount = 0;
								DgResultEntryHeader header = null;
								List<DgResultEntryHeader> headerList = session.createCriteria(DgResultEntryHeader.class)
										.add(Restrictions.eq("SampleCollectionHeader.Id",
												dgSample.getSampleCollectionHeader().getId()))
										.add(Restrictions.eq("Hin.Id",
												dgSample.getSampleCollectionHeader().getHin().getId()))
										.add(Restrictions.eq("Investigation.Id", dgSample.getInvestigation().getId()))
										.list();
								if (headerList.size() > 0) {
									headerCount++;
									header = (DgResultEntryHeader) headerList.get(0);
								}
								// added by govind 25-07-2017 end
								if (headerCount == 0) {
									DgResultEntryHeader dgresultheader = new DgResultEntryHeader();
									dgresultheader.setMainChargecode(dgSample.getMaincharge());
									dgresultheader.setSubChargecode(dgSample.getSubcharge());

									dgresultheader.setResultDate(new Date());
									dgresultheader.setResultTime(timeStr);
									dgresultheader.setEmployee(dgSample.getSampleCollectionHeader().getValidatedBy());
									dgresultheader.setResultStatus("P");
									// dgresultheader.setLastChgdBy(changeBy);
									dgresultheader.setLastChgdDate(new Date());
									dgresultheader.setLastChgdTime(timeStr);
									dgresultheader.setSampleCollectionHeader(dgSample.getSampleCollectionHeader());
									dgresultheader.setHin(dgSample.getSampleCollectionHeader().getHin());
									dgresultheader.setInpatient(dgSample.getSampleCollectionHeader().getInpatient());
									dgresultheader.setDepartment(dgSample.getSampleCollectionHeader().getDepartment());
									dgresultheader.setHospital(dgSample.getSampleCollectionHeader().getHospital());
									dgresultheader.setTestOrderNo(dgSample.getInvestigation().getTestOrderNo());
									dgresultheader.setInvestigation(dgSample.getInvestigation());
									String resultSeqNo = "";
									Map<String, Object> diagMap = new HashMap<String, Object>();
									resultSeqNo = generateResultNumber(diagMap);
									// System.out.println("resultSeqNo---"+resultSeqNo);
									if (resultSeqNo != "") {
										dgresultheader.setResultNo(resultSeqNo);
									}
									hbt.save(dgresultheader);

									// System.out.println("header saved");
									List<DgResultEntryHeader> dg_result_header = new ArrayList<DgResultEntryHeader>();
									dg_result_header = session
											.createQuery("select max(dh.id) from DgResultEntryHeader dh").list();
									// System.out.println("dg_result_header"+dg_result_header);
									Iterator itr = dg_result_header.iterator();
									int headerId = 0;
									while (itr.hasNext()) {
										headerId = (Integer) itr.next();
										// System.out.println(" header id"+(Integer)itr.next());
									}
									header = (DgResultEntryHeader) hbt.load(DgResultEntryHeader.class, headerId);
								}

								DgResultEntryDetail dgResultEntryDetails = new DgResultEntryDetail();
								dgResultEntryDetails.setResultEntry(header);
								dgResultEntryDetails.setChargeCode(dgSample.getChargeCode());
								dgResultEntryDetails.setResultType(investigation_type);
								dgResultEntryDetails.setResult(measurementValue);
								// dgResultEntryDetails.setUom(dgSample.getInvestigation().getUom());
								dgResultEntryDetails.setInvestigation(dgSample.getInvestigation());
								int sub_invest_id = 0;
								if (labMachineXt2000iDetails.getSubInvestigationId() != null) {
									sub_invest_id = labMachineXt2000iDetails.getSubInvestigationId();
								}
								DgSubMasInvestigation subInvestigation = (DgSubMasInvestigation) hbt
										.get(DgSubMasInvestigation.class, sub_invest_id);
								dgResultEntryDetails.setResultDetailStatus("P");
								dgResultEntryDetails.setSampleCollectionDetails(dgSample);

								// added by govind 25-07-2017
								Set<DgNormalValue> normalSet = new HashSet<DgNormalValue>();

								if (subInvestigation != null) {
									dgResultEntryDetails.setSample(subInvestigation.getInvestigation().getSample());
									dgResultEntryDetails.setUom(subInvestigation.getUom());
									normalSet = subInvestigation.getDgNormalValues();
								}
								String age1 = "";
								String checked="false";
								String age = dgSample.getSampleCollectionHeader().getHin().getAge();
								int index = age.indexOf(" ");
								age1 = age.substring(0, index);
								if (normalSet.size() > 0) {
									for (DgNormalValue nv : normalSet) {
										if (nv.getFromAge() != null && nv.getToAge() != null
												&& !nv.getToAge().equals("") && !nv.getFromAge().equals("")) {
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("m")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) > nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) < nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("m")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) < nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) > nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("f")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) < nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) > nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("f")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) > nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) < nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("n")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) < nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) > nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("n")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) > nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) < nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("c")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) < nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) > nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											if (nv != null
													&& (nv.getSex().equalsIgnoreCase("c")
															/*|| nv.getSex().equalsIgnoreCase("n")*/)
													&& Integer.parseInt(age1) > nv.getFromAge() && checked.equals("false")
													&& Integer.parseInt(age1) < nv.getToAge()) {
												checked="true";
												dgResultEntryDetails.setNormal(nv);
											}
											/*if (nv != null
													&& (nv.getSex().equalsIgnoreCase("f")
															|| nv.getSex().equalsIgnoreCase("n"))
													&& Integer.parseInt(age1) > nv.getFromAge()
													&& Integer.parseInt(age1) < nv.getToAge()) {
												dgResultEntryDetails.setNormal(nv);
											}*/
											/*if ((nv.getSex().equalsIgnoreCase("f") || nv.getSex().equalsIgnoreCase("n"))
													&& nv.getFromAge() == null
													|| (nv.getSex().equalsIgnoreCase("f")
															|| nv.getSex().equalsIgnoreCase("n"))
															&& nv.getSex().equalsIgnoreCase("")) {
												dgResultEntryDetails.setNormal(nv);
											}*/
											/*if (nv.getSex().equalsIgnoreCase("n") && nv.getFromAge() == null
													|| nv.getSex().equalsIgnoreCase("n")
															&& nv.getSex().equalsIgnoreCase("")) {
												dgResultEntryDetails.setNormal(nv);
											}*/
										}
										/*if ((nv.getSex().equalsIgnoreCase("m") || nv.getSex().equalsIgnoreCase("n"))
												&& nv.getFromAge() == null
												|| (nv.getSex().equalsIgnoreCase("m")
														|| nv.getSex().equalsIgnoreCase("n"))
														&& nv.getSex().equalsIgnoreCase("")) {
											dgResultEntryDetails.setNormal(nv);
										}*/
										/*if (nv.getFromAge() != null && nv.getToAge() != null
												&& !nv.getToAge().equals("") && !nv.getFromAge().equals("")) {
											if (nv != null && nv.getSex().equalsIgnoreCase("n")
													&& Integer.parseInt(age1) > nv.getFromAge()
													&& Integer.parseInt(age1) < nv.getToAge()) {
												dgResultEntryDetails.setNormal(nv);
											}
										}*/
									}
								}
								// added by govind 25-07-2017 end

								List<DgNormalValue> dgnormalValue = new ArrayList<DgNormalValue>();
								if (investigation_type.equalsIgnoreCase("m")) {
									dgResultEntryDetails.setSubInvestigation(subInvestigation);
									dgnormalValue = session.createCriteria(DgNormalValue.class)
											.add(Restrictions.eq("SubInvestigation", subInvestigation))
											.add(Restrictions.eq("Sex", dgSample.getSampleCollectionHeader().getHin()
													.getSex().getAdministrativeSexCode()))
											.list();
									for (DgNormalValue dgNormal : dgnormalValue) {
										dgResultEntryDetails.setNormal(dgNormal);
									}

								}

								hbt.save(dgResultEntryDetails);
								dgSample.setOrderStatus("E");
								hbt.update(dgSample);
								logger.info("ResultEntryDetails inserted successfully");
							}

						}

					} catch (HibernateException he) {
						he.printStackTrace();
					}
				}
			}
		}
		trx.commit();
		return map;
	}

	@Override
	public Map<String, Object> getPendingValidation(Map<String, Object> pendMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> sampleDtList=new ArrayList<DgSampleCollectionDetails>();
		  HibernateTemplate hbt = getHibernateTemplate();
	      hbt.setFlushModeName("FLUSH_EAGER");
	      hbt.setCheckWriteOperations(false);
	      Session session = (Session) getSession();
	      int sampleId=0,Orderid=0,pendOrderid=0,pendSampleId=0,sampleCollectionHeaderId=0;
	      int hospitalId=0;
			 if(pendMap.get("sampleId")!=null){
				 sampleId=(Integer)pendMap.get("sampleId");
			 }
			 if(pendMap.get("orderId")!=null){
				 Orderid=(Integer)pendMap.get("orderId");
			 }
			 if(pendMap.get("sampleCollectionHeaderId")!=null){
				 sampleCollectionHeaderId=(Integer)pendMap.get("sampleCollectionHeaderId");
			 }
			 if(pendMap.get("hospitalId")!=null){
				 hospitalId=(Integer)pendMap.get("hospitalId");
			 }
		/*	 System.out.println("sampleId impl "+sampleId);
	      sampleDtList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.createAlias("SampleCollectionHeader", "header")
					.add(Restrictions.eq("header.Id",sampleId)) 
					.add(Restrictions.isNull("Validated"))
					.createAlias("Investigation", "inv")
					.addOrder(Order.asc("inv.InvestigationName")).list();
	      
	      System.out.println("sampleDtList impl "+sampleDtList.size());
	      
	      if(sampleDtList.size()>0){
	    	  for(DgSampleCollectionDetails col:sampleDtList){
	    		  if(Orderid!=col.getSubcharge().getId()){
	    		  pendOrderid=col.getSubcharge().getId();
	    		  pendSampleId=col.getSampleCollectionHeader().getId();
	    		  break;
	    		  }
	    	  }
	      }
	      */
	  	//added by govind 12-07-2017
			Integer pendHeaderId=0,pendSubChargeId=0;
			List<DgSampleCollectionDetails> pendSubchargeList=session.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",sampleCollectionHeaderId))
					.add(Restrictions.ne("OrderStatus","A").ignoreCase())
					.addOrder(Order.asc("Id"))
					.list();
			pendHeaderId=sampleCollectionHeaderId;
			if(pendSubchargeList.size()>0){
				for(DgSampleCollectionDetails col:pendSubchargeList){
					pendSubChargeId=col.getSubcharge().getId();
					break;
				}
			}
			 map.put("pendHeaderId", pendHeaderId);
			 map.put("pendSubChargeId", pendSubChargeId);
			 
			 Integer nextHeaderId=0,nextSubChargeId=0;
				List<DgSampleCollectionDetails> nextSubchargeList=session.createCriteria(DgSampleCollectionDetails.class)
						.createAlias("SampleCollectionHeader", "head")
						.createAlias("Subcharge", "sub")
						.add(Restrictions.eq("head.Hospital.Id",hospitalId))
						.add(Restrictions.eq("sub.Id",Orderid))
						.add(Restrictions.ne("OrderStatus","A").ignoreCase())
						.add(Restrictions.ne("head.OrderStatus","A").ignoreCase())
						.add(Restrictions.eq("LastChgDate",new Date()))
						.addOrder(Order.asc("Id"))
						.list();
				if(nextSubchargeList.size()>0){
					for(DgSampleCollectionDetails col:nextSubchargeList){
						if(sampleCollectionHeaderId!=col.getSampleCollectionHeader().getId()){
							
						nextSubChargeId=col.getSubcharge().getId();
						nextHeaderId=col.getSampleCollectionHeader().getId();
						break;
						}
					}
				}
				 map.put("nextHeaderId", nextHeaderId);
				 map.put("nextSubChargeId", nextSubChargeId);
			//added by govind 12-07-2017 end
			
	      
	     // System.out.println("pendSampleId impl "+pendSampleId+" pendOrderid "+pendOrderid+" old Orderid "+Orderid);
	      
	     /* map.put("pendOrderid", pendOrderid);
	      map.put("pendSampleId", pendSampleId);*/
		return map;
	}

	public boolean LabParameterNameCheck(Map<String, Object> dataMap) {
		List<LabMachineXt2000iDetails> nameList = new ArrayList<LabMachineXt2000iDetails>();
		boolean status = false;
		Session session = (Session) getSession();
		String parameterName = null;
		String machineName =null;
		if(dataMap.get("parameterName")!=null){
			parameterName = (String) dataMap.get("parameterName");
		}
		if(dataMap.get("machineName")!=null){
			machineName = (String) dataMap.get("machineName");
		}
		nameList = session.createCriteria(LabMachineXt2000iDetails.class)
				.add(Restrictions.eq("ParameterName", parameterName))
				.add(Restrictions.eq("MachineCode", machineName))
				.list();
		if (nameList.size() > 0) {
			status = true;
		} else {
			status = false;
		}
		return status;
	}

	@Override
	public Map<String, Object> getInpatientList(Map<String, Object> dataMap) {
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Integer inpatientId=0;
		if(dataMap.get("inpatientId")!=null){
			inpatientId=(Integer)dataMap.get("inpatientId");
		}
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId))
				.list();
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public String getResultType(int investigationId) {
		String resultType="";
		try{
			Session session = (Session) getSession();
			List<DgMasInvestigation> resultTypeList=new ArrayList<DgMasInvestigation>();
			resultTypeList=session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Id",investigationId)).list();
			resultType=resultTypeList.get(0).getInvestigationType();
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultType;
	}
	
	@Override
	public Map<String, Object> bookLabForDoctor(Box box) {
		Session session= (Session) getSession();
		int userId = box.getInt("userId");
		int subChargeCodeId = box.getInt("subChargeCodeId");
		MasSubChargecode masSubChargecode = null;
		List<MasSubChargecode> userBookedLabList = null;
		Users user = null;
		org.hibernate.Transaction tx = session.beginTransaction();
		
		try {
		
		user =	(Users) session.get(Users.class, userId);
		
		masSubChargecode =	(MasSubChargecode) session.get(MasSubChargecode.class, subChargeCodeId);
		
		user.setCurrentLab(masSubChargecode);		
		session.update(user);
		session.flush();
		tx.commit();
		
	    } catch (Exception e){
	    	if(tx!=null)
	    		tx.rollback();
	    	e.printStackTrace();
	    }
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitSampleCollectionForOutSideLab(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		String diagSeqNo = "";
		String diag_no="";
		Session session = (Session) getSession();
		List<DgMasInvestigation> investigations = null;
		DgMasInvestigation investigation  = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		
		final Map<String, Object> dataForSampleCollection =  new HashMap<String, Object>(); // added by amit das on 11-09-2017
		Map<DgOrderhd, Set<DgOrderdt>> orderMap = new HashMap<DgOrderhd, Set<DgOrderdt>>();  // added by amit das on 11-09-2017
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleCollectionMap = new HashMap<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>();  // added by amit das on 11-09-2017
		Set<DgOrderdt> dgOrderdts = null; // added by amit das on 11-09-2017
		Set<DgSampleCollectionDetails> collectionDetailsSet = null; // added by amit das on 11-09-2017
		
		
		// String diagSeqNo="";
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		int hinId = box.getInt(HIN_ID);
		Patient patient = new Patient();
		int departmentId = box.getInt(DEPARTMENT_ID);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		int orderId=0;
		String diagnosisNo = box.getString(DIAGNOSIS_NO);
		String  orderTempId =  box.get(ORDER_BOOKING_ID);
		
		Vector charge_code_Id = box.getVector(CHARGE_CODE_ID);
		Vector mainCharge = box.getVector("mainCharge");
		Vector sub_Charge = box.getVector("subCharge");
		int collectedBy = box.getInt(EMPLOYEE_ID);
		int totalRow = box.getInt("totalRow");
  
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			DgOrderhd dgOrderhdObj=null;
			String patientType="";//added by govind 27-07-2017
			List<DgOrderhd> dgOrderhdObjList =null;
			
			patient = hbt.get(Patient.class, hinId);
			
			dgOrderhdObjList=session.createCriteria(DgOrderhd.class)
						.add(Restrictions.eq("Id", Integer.parseInt(orderTempId)))
						.list();
				/*dgOrderhdObj=  hbt.load(DgOrderhd.class,
							orderId);*/
				for(DgOrderhd orderHd:dgOrderhdObjList){
					dgOrderhdObj=orderHd;
					orderId=orderHd.getId();
			//Added By Dhananjay 09-jan-17
			PharmacyLabQueue pharmacyLabQueue = null;
			Criteria crt=null;
				 crt= session.createCriteria(PharmacyLabQueue.class)
					.createAlias("DgOrderhdId", "dgOrderhdId")
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dgOrderhdId.Id", dgOrderhdObj.getId()))
					.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase())
					.add(Restrictions.eq("Status", "P").ignoreCase());
				if(null != crt &&  null !=crt.list() && (crt.list().size())>0){
					pharmacyLabQueue=(PharmacyLabQueue) crt.list().get(0);
				}
				patientType=orderHd.getPatientType();
			// End 
				if(pharmacyLabQueue!=null || patientType.equalsIgnoreCase("IP")){
			DgSampleCollectionHeader dgSampleCollectionHeader = (DgSampleCollectionHeader) session
					.createCriteria(DgSampleCollectionHeader.class)
					.add(Restrictions.eq("Order.Id", orderId))
					.add(Restrictions.eq("Department.Id", departmentId))
					.uniqueResult();
			boolean isNotCollected = false;
			int counterForAllRejectedByEmpanelled = 0;
			List<DgSampleCollectionDetails> sampleDetails = new ArrayList<DgSampleCollectionDetails>();
			Map<Integer,Boolean> sampleColId=new HashMap<Integer,Boolean>();
			String sampleBarCode="";
			sampleBarCode=generateSampleBarcodeForLab(hospitalId);
			
			int sampleId=0;
			int colCount=0;
			
			Map<String,DiagParam> diagParamMap=new HashMap<String,DiagParam>();
			
				
			DgOrderdt dgOrderdt = (DgOrderdt) hbt.load(DgOrderdt.class,
						box.getInt("orderDtId"));
				
			investigations =  session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("ChargeCode", dgOrderdt.getChargeCode())).list();
			if(investigations!=null && investigations.size()>0)
				investigation = investigations.get(0);
			
			if(investigation!=null) {
					
			if (dgSampleCollectionHeader == null)
						dgSampleCollectionHeader = new DgSampleCollectionHeader();
					
					
					dgSampleCollectionHeader.setSampleBarCode(sampleBarCode);
					dgSampleCollectionHeader.setHin(patient);
					dgSampleCollectionHeader.setHospital(hospital);
					dgSampleCollectionHeader.setOrder(dgOrderhdObj);
					dgSampleCollectionHeader.setDepartment(masDepartment);
					dgSampleCollectionHeader.setSampleValidationDate(date);
					dgSampleCollectionHeader.setDepartment(masDepartment);
					dgSampleCollectionHeader.setOrderStatus("P");
					dgSampleCollectionHeader.setLastChgBy(users);
					dgSampleCollectionHeader.setLastChgDate(date);
					dgSampleCollectionHeader.setLastChgTime(time);
					dgSampleCollectionHeader.setDiagnosisDate(date);
					dgSampleCollectionHeader.setDiagnosisTime(time);
					hbt.saveOrUpdate(dgSampleCollectionHeader);
					
					int dgSampleHeaderId = dgSampleCollectionHeader.getId();
					
					DgSampleCollectionDetails dgSampleCollectionDetails = (DgSampleCollectionDetails) session
							.createCriteria(DgSampleCollectionDetails.class)
							.add(Restrictions.eq("SampleCollectionHeader.Id",
									dgSampleHeaderId))
							.add(Restrictions.eq("ChargeCode.Id", dgOrderdt
									.getChargeCode().getId())).uniqueResult();
					
					
					if (dgSampleCollectionDetails == null) 
						dgSampleCollectionDetails = new DgSampleCollectionDetails();
					
					dgSampleCollectionDetails
							.setSampleCollectionHeader(dgSampleCollectionHeader);
					dgSampleCollectionDetails.setCollected(box
							.get("y"));
					dgSampleCollectionDetails.setChargeCode(dgOrderdt
							.getChargeCode());
					dgSampleCollectionDetails.setMaincharge(dgOrderdt
							.getMainChargecode());
					dgSampleCollectionDetails.setSubcharge(dgOrderdt
							.getSubChargeid());
					dgSampleCollectionDetails.setSample(investigation.getSample());
					dgSampleCollectionDetails.setInvestigation(investigation);
					dgSampleCollectionDetails.setContainer(investigation.getCollection());
					dgSampleCollectionDetails.setOrderStatus("A");
					dgSampleCollectionDetails.setValidated("y");
					DiagParam dgParam = null;
					synchronized (this) {
						dgParam= new DiagParam();
						MasMainChargecode maincharge1 = new MasMainChargecode();
						maincharge1
								.setId(dgOrderdt.getMainChargecode().getId());
						dgParam.setMainCharge(maincharge1);
						MasSubChargecode subCharge1 = new MasSubChargecode();
						subCharge1.setId(dgOrderdt.getSubChargeid().getId());
						dgParam.setSubCharge(subCharge1);
						MasChargeCode msc = new MasChargeCode();
						msc.setId(dgOrderdt.getChargeCode().getId());
						dgParam.setChargeCode(msc);
						dgParam.setContainer(investigation.getCollection());
						dgParam.setSample(investigation.getSample());
						dgParam.setSeqNo(1);
						dgParam.setPrefix(dgOrderdt.getSubChargeid()
								.getSubChargecodeCode().substring(0, 2));
						dgParam.setCriteria("C");
						dgParam.setLastChgDate(date);
						dgParam.setLastChgTime(time);
						dgParam.setLastChgBy(users);
						dgParam.setHospital(hospital);
						dgParam.setSeqUpdateDate(new Date());//added by govind 19-06-2017 for reset seqno by datewise
						hbt.save(dgParam); 
						dgSampleCollectionDetails.setDiagNo(""
								+ dgParam.getSeqNo()); 
						diag_no=String.valueOf(dgParam.getSeqNo());
					}
					
					dgSampleCollectionDetails.setSampleCollDatetime(date);
					dgSampleCollectionDetails.setLastChgBy(users);
					dgSampleCollectionDetails.setLastChgDate(date);
					dgSampleCollectionDetails.setLastChgTime(time);
					hbt.saveOrUpdate(dgSampleCollectionDetails);
					hbt.refresh(dgSampleCollectionDetails);
					sampleColId.put(dgSampleCollectionDetails.getId(),true);//added by govind 13-07-2017	
				
					dgOrderdt.setOrderStatus("C");
					hbt.update(dgOrderdt);
					
			
			List<DgOrderdt>	dgOrderdtList = session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd", dgOrderhdObj)).add(Restrictions.ne("OrderStatus", "C")).list();
			
			if(dgOrderdtList!=null && dgOrderdtList.size()>0){
				dgOrderhdObj.setOrderStatus("P");
			}else{
				dgOrderhdObj.setOrderStatus("C");
				pharmacyLabQueue.setStatus("C");
			}
			
			hbt.saveOrUpdate(dgOrderhdObj); 
			
			dgOrderdts = dgOrderhdObj.getDgOrderdts();
			Hibernate.initialize(dgOrderdts);
			Hibernate.initialize(dgOrderhdObj.getVisit());
			Hibernate.initialize(dgOrderhdObj.getHin());
			orderMap.put(dgOrderhdObj, dgOrderdts);
			hbt.refresh(dgSampleCollectionHeader); 
			collectionDetailsSet = dgSampleCollectionHeader.getDgSampleCollectionDetails();
			Hibernate.initialize(collectionDetailsSet);
			Hibernate.initialize(dgSampleCollectionHeader.getOrder().getVisit());
			Hibernate.initialize(dgSampleCollectionHeader.getHin());
			sampleCollectionMap.put(dgSampleCollectionHeader, collectionDetailsSet);
		
			
			if(null != pharmacyLabQueue)
					hbt.update(pharmacyLabQueue);
			
			
			map.put("diag_no", diag_no);
			map.put("dgSampleCollectionDetailsId", dgSampleCollectionDetails.getId());
			map.put("orderId",orderId);
			map.put("hinId", hinId); 
			map.put("hinNo", patient.getHinNo());
			map.put("patientType", patientType);
			map.put("sampleBarCode",sampleBarCode);

			
			map.put("sampleColId",sampleColId);
			}
		  }
		}tx.commit();
		saved = true; 
		
		Hibernate.initialize(hospital);
		dataForSampleCollection.put("orderMap", orderMap);  // added by amit das on  12-09-2017
		dataForSampleCollection.put("sampleMap", sampleCollectionMap); // added by amit das on  12-09-2017
		dataForSampleCollection.put("hospital", hospital);// added by amit das on  12-09-2017
		
		final MasHospital masHospital = hospital;
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
					sampleManipulactionToCentralServer(dataForSampleCollection,"collection");
				} 
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
					sampleManipulactionToLeanServer(dataForSampleCollection,"collection");
						
				}
			}
			
		}.start();*/
		
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			saved = false;
		}
		
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> showExistingOpOrderBookingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderdt> dgOrderDtList = new ArrayList<DgOrderdt>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Integer> maxVisitIdList = new ArrayList<Integer>();
		List<Visit> visitIdList = new ArrayList<Visit>();
		//List<DgOrderhd> orderNoList = new ArrayList<DgOrderhd>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<DgOrderhd>hdList=new ArrayList<DgOrderhd>();
		List<PharmacyLabQueue> pharmacyLabList=new ArrayList<PharmacyLabQueue>();
		Session session = (Session) getSession();
		int maxVisitId = 0;
		int doctorId = 0;
		int pharmacyLabQueueId=0;
		String orderNo="";
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			dgOrderDtList = session.createCriteria(DgOrderdt.class)
					.add(Restrictions.eq("Orderhd.Id", box.getInt("orderId"))).list();
			 orderNo = dgOrderDtList.get(0).getOrderhd().getOrderNo();
			
			pharmacyLabList=session.createCriteria(PharmacyLabQueue.class).createAlias("Visit", "visit")
					.add(Restrictions.eq("DgOrderhdId.Id", box.getInt("orderId")))
					.list();
		int visitId = 0;			
	             if(pharmacyLabList.size()>0){
	            	 PharmacyLabQueue ph=pharmacyLabList.get(0);
	            	pharmacyLabQueueId=ph.getId();
	            	visitId = ph.getVisit().getId();
	             }
			visitList = session.createCriteria(Visit.class).
					add(Restrictions.eq("Id", visitId)).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
					.add(Restrictions.eq("empCategory.Id", 4))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
			Visit visit = new Visit();
			if(visitList.size()>0)
			visit = visitList.get(0);

			int hinId = 0 ;
			if(visit!=null &&  visit.getHin()!=null) // added by amit das on 21-07-2016
				hinId = visit.getHin().getId();
			
			try {
				maxVisitIdList = hbt
						.find("select max(v.Id) from jkt.hms.masters.business."
								+ "Visit v join v.Hin as p where p.Id = "
								+ hinId);

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			
			if(maxVisitIdList!=null && maxVisitIdList.get(0)!=null)  // added by amit das on 21-07-2016
				maxVisitId = maxVisitIdList.get(0);
			
			try {
				visitIdList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("Id", maxVisitId)).list();
				Visit lastVisit = new Visit();
				
				if(visitIdList!=null && visitIdList.size()>0) // added by amit das on 21-07-2016
				lastVisit = (Visit) visitIdList.get(0);
				
				
				if (lastVisit.getDoctor() != null) {
					doctorId = lastVisit.getDoctor().getId();
				}

			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			icdList = session.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "v")
					.add(Restrictions.eq("v.Id", maxVisitId)).list();
			/*if(visit.getHospital() != null) {
				hdList=session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id", hinId)) 
					.add(Restrictions.eq("OrderStatus","P").ignoreCase())
					.add(Restrictions.eq("Hospital.Id",visit.getHospital().getId()))
					.addOrder(Order.asc("Id")).list();*/
				
				/*int dgOrderhdId = 0;
				List<Integer> todaysPendingOrderId = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Hin.Id", hinId)) 
						.add(Restrictions.eq("OrderStatus","P").ignoreCase()).add(Restrictions.eq("OrderDate", new Date()))
						.add(Restrictions.eq("Hospital.Id",visit.getHospital().getId()))
						.setProjection(Projections.property("Id")).list();
				if(todaysPendingOrderId.size()>0)
					dgOrderhdId = todaysPendingOrderId.get(0);
				map.put("dgOrderhdId", dgOrderhdId);
			}*/

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		map.put("dgOrderDtList", dgOrderDtList);
		map.put("doctorId", doctorId);
		map.put("icdList", icdList);
		map.put("orderNo", orderNo);
		map.put("visitList", visitList);
		map.put("employeeList", employeeList);
		map.put("hdList", hdList);
		map.put("pharmacyLabQueueId", pharmacyLabQueueId);
		map.put("orderId", box.getInt("orderId"));
		return map;
	}

	@Override
	public Map<String, Object> checkDuplicateInvestigation(Box box) {
		Map<String, Object>map = new HashMap<String, Object>();
		List<DgOrderdt>existingDgOrderDtList = new ArrayList<DgOrderdt>();
		Session session = (Session)getSession();
		existingDgOrderDtList = session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", box.getInt("orderId")))
								.add(Restrictions.eq("ChargeCode.Id", box.getInt("chargeCodeId"))).list();
		map.put("existingDgOrderDtList", existingDgOrderDtList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,Object> submitOrderBookingForExistingInvestigation(Box box,
			Map<String, Object> infoMap) {
		DgOrderhd dgOrderhd = new DgOrderhd();
		Map<String, Object> resultMap = new HashMap<String, Object>(); // added by amit das on 03-06-2017
		
		final Map<String, Object> dataForOrderBooking =  new HashMap<String, Object>(); // added by amit das on 11-09-2017
		Map<DgOrderhd, Set<DgOrderdt>> orderMap = new HashMap<DgOrderhd, Set<DgOrderdt>>();  // added by amit das on 11-09-2017
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleCollectionMap = new HashMap<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>();  // added by amit das on 11-09-2017
		Set<DgOrderdt> dgOrderdts = null; // added by amit das on 11-09-2017
		Set<DgSampleCollectionDetails> collectionDetailsSet = null; // added by amit das on 11-09-2017
		
		/* IpPhysioReqHeader ipph=new IpPhysioReqHeader(); */
		String userName = "";
		boolean saved = false;
		boolean flag = false;
		Session session = (Session) getSession();
		List chargeList = new ArrayList();
		List qtyList = new ArrayList();
		List amountList = new ArrayList();
		List mainChargeList = new ArrayList();
		List subChargeList = new ArrayList();
		List orderDetailIdList = new ArrayList();

		int hinId = 0;
		int hospitalId = 0;
		int inpatientId = 0;
		Integer userId = 0;
		Users users = null;
		int visitId=0;
		int dgOrderHdId=0;
		int pharmacyLabQueueId=0;
		String adNo="";
		String uHid="";
		if(null !=infoMap.get("pharmacyLabQueueId")){
			pharmacyLabQueueId=(Integer)infoMap.get("pharmacyLabQueueId");
		}

		if (infoMap.get("dgOrderhd") != null) {
			dgOrderhd = (DgOrderhd) infoMap.get("dgOrderhd"); 
		}
		if(box.get(RequestConstants.VISIT_ID)!=null){
			visitId=box.getInt(RequestConstants.VISIT_ID);
		}
		
		
		
		if (infoMap.get(RequestConstants.USERS) != null) {
			users = (Users) infoMap.get(RequestConstants.USERS);
		}
		if (infoMap.get("qtyList") != null) {
			qtyList = (List) infoMap.get("qtyList");
		}
		if (infoMap.get("amountList") != null) {
			amountList = (List) infoMap.get("amountList");
		}
		if (infoMap.get("mainChargeList") != null) {
			mainChargeList = (List) infoMap.get("mainChargeList");
		}
		if (infoMap.get("subChargeList") != null) {
			subChargeList = (List) infoMap.get("subChargeList");
		}

		if (infoMap.get("inpatientId") != null) {
			inpatientId = (Integer) infoMap.get("inpatientId");
		}
		if (infoMap.get("hinId") != null) {
			hinId = (Integer) infoMap.get("hinId");
		}
		if (infoMap.get("userName") != null) {
			userName = (String) infoMap.get("userName");
		}
		if (infoMap.get(USER_ID) != null) {
			userId = (Integer) infoMap.get(USER_ID);
		}
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap.get("hospitalId");
		}
		if (infoMap.get("orderDetailIdList") != null) {
			orderDetailIdList = (List) infoMap.get("orderDetailIdList");
		}
		if (infoMap.get("dgOrderHdId") != null) {
			dgOrderHdId = (Integer) infoMap.get("dgOrderHdId");
		}
		String diag_no="";
		/*
		 * Users users = new Users(); users.setId(userId);
		 */
		MasHospital hospital = new MasHospital();
		org.hibernate.Transaction tx = null;
		try {
			tx = session.beginTransaction();

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hospital = 		hbt.get(MasHospital.class, hospitalId);
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date changeDate = HMSUtil.convertStringTypeDateToDateType(date);
			int ipphId = 0;
			int hdId=0;
			if(box.getInt("pendingName")!=0){
				hdId=box.getInt("pendingName");
			}else{
				hdId= box.getInt("orderId");
			}
			DgOrderhd hdOld=null;
			Set<DgOrderdt> dgOrderdtsOld=null;
			hdOld=(DgOrderhd)session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Id",hdId)).uniqueResult();
			/*if(hdOld!=null){
				hdOld.setOrderStatus("N");
				hbt.update(hdOld); 	
				dgOrderdtsOld=hdOld.getDgOrderdts();
				System.out.println("dgOrderdtsOld========="+dgOrderdtsOld);
			}*/

			try {

				try {

					dgOrderhd.setId(dgOrderHdId);

				} catch (DataAccessException e) {
					e.printStackTrace();
				}

				if (infoMap.get("chargeList") != null) {
					chargeList = (List) infoMap.get("chargeList");
					if (chargeList.size() > 0) {
						for (int i = 0; i < chargeList.size(); i++) {

							DgOrderdt dgOrderdt = new DgOrderdt();
							MasChargeCode masChargeCode = new MasChargeCode();
							MasSubChargecode masSubChargecode = new MasSubChargecode();
							MasMainChargecode masMainChargecode = new MasMainChargecode();
							int chargeId = 0;
							if (orderDetailIdList.get(i).equals("")) {
								chargeId = Integer.parseInt(chargeList.get(i).toString());

								masChargeCode.setId(chargeId);
								dgOrderdt.setChargeCode(masChargeCode);

								if (amountList.get(i) != null) {
									BigDecimal amount = new BigDecimal(amountList
											.get(i).toString());
									dgOrderdt.setAmount(amount);
								}
								int mainChargeId = 0;
								if (mainChargeList.get(i) != null
										&& !mainChargeList.get(i).equals("")) {
									mainChargeId = Integer.parseInt(mainChargeList
											.get(i).toString());
									masMainChargecode.setId(mainChargeId);
									dgOrderdt.setMainChargecode(masMainChargecode);
								}							if (subChargeList.get(i) != null
										&& !subChargeList.get(i).equals("")) {
									int subChargeId = Integer
											.parseInt(subChargeList.get(i)
													.toString());
									masSubChargecode.setId(subChargeId);
									dgOrderdt.setSubChargeid(masSubChargecode);
								}
								if (qtyList.get(i) != null
										&& !qtyList.get(i).equals("")) {
									Integer qty = Integer.parseInt(""
											+ qtyList.get(i));
									dgOrderdt.setOrderQty(qty);
								}
								dgOrderdt.setOrderStatus("P");
								dgOrderdt.setPaymentMade("n");
								dgOrderdt.setLastChgDate(changeDate);
								dgOrderdt.setLastChgTime(time);
								dgOrderdt.setLastChgBy(users);
								dgOrderdt.setOrderhd(dgOrderhd);

								dgOrderdt.setMsgSent("n");
								dgOrderdt.setPacsStatus("n");
								try {
									hbt.save(dgOrderdt);
								} catch (Exception e) {
									e.printStackTrace();
								}
							} else if (!orderDetailIdList.get(i).toString()
									.equals("")) {
								DgOrderdt orderdt = (DgOrderdt) hbt.load(
										DgOrderdt.class, (Integer
												.parseInt(orderDetailIdList.get(i)
														.toString())));
								hbt.update(orderdt);

							}

						}
					}
					
		}
				//-------------------------Save or Update Data into sampleHeader Detail from Lab in case of Existing Order-----------------------
				String sampleBarCode="";
				sampleBarCode=generateSampleBarcodeForLab(hospitalId);

				try {
					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
					List<DgSampleCollectionHeader> sampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();
					sampleCollectionHeaderList = session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Order.Id", dgOrderHdId)).list();

					for (int a = 0; a < chargeList.size(); a++) {
						int chargeCodeId = Integer.parseInt(chargeList.get(a).toString());

						chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.eq("Id", chargeCodeId)).list();
						if (chargeCodeList.size() > 0) {
							MasChargeCode chargeCode = chargeCodeList.get(0);
							if (chargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("DIAG")) {
								if(sampleCollectionHeaderList!=null &&  sampleCollectionHeaderList.size()>0){	


									List<DgMasInvestigation>dgMasInvestigationList = new ArrayList<DgMasInvestigation>();
									DgSampleCollectionDetails sampleDetails = new DgSampleCollectionDetails();
									if (orderDetailIdList.get(a).equals("")) {
										//System.out.println("collHeader======77777777777===="+collHeader);
										collHeader.setId(sampleCollectionHeaderList.get(0).getId());
										sampleDetails.setSampleCollectionHeader(collHeader);
										MasChargeCode masChargeCode = new MasChargeCode();
										masChargeCode.setId(chargeCodeId);
										sampleDetails.setChargeCode(masChargeCode);
										sampleDetails.setCollectedBy(users
												.getEmployee());
										// sampleDetails.setSample(sample);
										sampleDetails.setCollected("y");
										sampleDetails.setLastChgBy(users);
										sampleDetails.setLastChgDate(changeDate);
										sampleDetails.setLastChgTime(time);
										if(sampleCollectionHeaderList.get(0).getOrderStatus().equalsIgnoreCase("A")){
											sampleDetails.setOrderStatus("A");
											sampleDetails.setValidated("y");
										}else{
											sampleDetails.setOrderStatus("P");
										}
										
										sampleDetails.setSampleCollDatetime(changeDate);
										dgMasInvestigationList = session.createCriteria(DgMasInvestigation.class).add(Restrictions.eq("ChargeCode.Id",chargeCodeId)).list();
										int sampleId = 0;
										if(dgMasInvestigationList.size()>0){
											sampleId = dgMasInvestigationList.get(0).getSample().getId();
										}
										if(sampleId != 0){
											MasSample masSample = new MasSample();
											masSample.setId(sampleId);
											sampleDetails.setSample(masSample);
										}





										MasMainChargecode maincharge = new MasMainChargecode();
										int mainChargeId = Integer
												.parseInt(mainChargeList.get(a)
														.toString());
										maincharge.setId(chargeCode.getMainChargecode()
												.getId());
										sampleDetails.setMaincharge(maincharge);

										MasSubChargecode subCharge = new MasSubChargecode();
										subCharge.setId(chargeCode.getSubChargecode()
												.getId());
										sampleDetails.setSubcharge(subCharge);

										int subChargeId = chargeCode.getSubChargecode()
												.getId();
										// String diagNo =
										// generateDiagNumber(subChargeId);
										// sampleDetails.setDiagNo(diagNo);

										DgMasInvestigation investigation = new DgMasInvestigation();
										investigation.setId(chargeCodeId);
										sampleDetails.setInvestigation(investigation);
										sampleDetails.setSampleCollDatetime(new Date());

										if(sampleDetails.getRejected()!=null){//added by govind 19-06-2017
											sampleDetails.setRejected(null);
										}else{
											DiagParam dgParam = null;
											synchronized (this) {

												if(sampleId != 0){
													dgParam =(DiagParam) session
															.createCriteria(DiagParam.class).createAlias("Sample", "sample")
															.add(Restrictions.eq("SubCharge.Id", chargeCode
																	.getSubChargecode().getId())) 
																	.add(Restrictions.eq("sample.Id",sampleId))
																	.add(Restrictions.eq("SeqUpdateDate",new Date()))//added by govind 19-06-2017 for reset seqno by datewise
																	.add(Restrictions.eq("Hospital.Id", hospitalId)).uniqueResult(); 
												}/*else{
										List<DiagParam> diagList=new ArrayList<DiagParam>();
										 diagList= session
												.createCriteria(DiagParam.class)
												.add(Restrictions.eq("SubCharge.Id", dgOrderdt
														.getSubChargeid().getId())) 
												.add(Restrictions.eq("Hospital.Id", hospital.getId())).list(); 

										 if(diagList!=null && diagList.size()>0){
											 dgParam=diagList.get(0); 
										 }
									}*/
												//}	 //commented by govind 10-07-2017

												if(dgParam==null){ 
													dgParam= new DiagParam();
													MasMainChargecode maincharge1 = new MasMainChargecode();
													maincharge1
													.setId(chargeCode.getMainChargecode().getId());
													dgParam.setMainCharge(maincharge1);
													MasSubChargecode subCharge1 = new MasSubChargecode();
													subCharge1.setId(chargeCode.getSubChargecode().getId());
													dgParam.setSubCharge(subCharge1);
													MasChargeCode msc = new MasChargeCode();
													msc.setId(chargeCodeId);
													dgParam.setChargeCode(msc);
													/*if (box.get(CONTAINER + i).trim() != ""
												&& box.get(CONTAINER + i) != null) {
											DgMasCollection dgMasCollection = new DgMasCollection();
											dgMasCollection.setId(box.getInt(CONTAINER + i));
											dgParam.setContainer(dgMasCollection);
										}*/
													if(sampleId != 0){
														MasSample masSample = new MasSample();
														masSample.setId(sampleId);
														dgParam.setSample(masSample);
													}

													dgParam.setSeqNo(1);
													dgParam.setPrefix(chargeCode.getSubChargecode()
															.getSubChargecodeCode().substring(0, 2));
													dgParam.setCriteria("C");
													dgParam.setLastChgDate(changeDate);
													dgParam.setLastChgTime(time);
													dgParam.setLastChgBy(users);
													dgParam.setHospital(hospital);
													dgParam.setSeqUpdateDate(new Date());//added by govind 19-06-2017 for reset seqno by datewise
													hbt.save(dgParam); 
													sampleDetails.setDiagNo(""
															+ dgParam.getSeqNo()); 
													diag_no=String.valueOf(dgParam.getSeqNo());
												}else{ 
													//added by govind 10-07-2017
													List<DgSampleCollectionDetails> dgColList =session
															.createCriteria(DgSampleCollectionDetails.class)
															.add(Restrictions.eq("SampleCollectionHeader.Id",
																	collHeader.getId()))
																	.add(Restrictions.eq("Subcharge.Id",chargeCode.getSubChargecode().getId())).list();
													if(dgColList.size()>0){
														String diagNo=dgColList.get(0).getDiagNo();
														sampleDetails.setDiagNo(diagNo); 
														diag_no=String.valueOf(dgParam.getSeqNo());
													}else{
														dgParam.setSeqNo(dgParam.getSeqNo()+1);
														hbt.update(dgParam);
														//diagParamMap.put(chargeCode.getSubChargecode().getId()+""+sampleId, dgParam);
														sampleDetails.setDiagNo(""+dgParam.getSeqNo()); 
														diag_no=String.valueOf(dgParam.getSeqNo());
													}

													/*	if(diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+sampleId)==null){
											System.out.println("seqNo ++");
											dgParam.setSeqNo(dgParam.getSeqNo()+1);
											hbt.update(dgParam);
											diagParamMap.put(dgOrderdt.getSubChargeid().getId()+""+sampleId, dgParam);
											dgSampleCollectionDetails.setDiagNo(""+dgParam.getSeqNo()); 
											diag_no=String.valueOf(dgParam.getSeqNo());
										}else{
											System.out.println("seqNo update");
											DiagParam diagParam =diagParamMap.get(dgOrderdt.getSubChargeid().getId()+""+sampleId); 
											dgSampleCollectionDetails.setDiagNo(""+diagParam.getSeqNo()); 
											diag_no=String.valueOf(dgParam.getSeqNo());
										}*/
													//added by govind 10-07-2017 end
												}
											}
										}


										hbt.save(sampleDetails);
									}
								}
							}
						}
					}

					/*List<Visit>visitList=new ArrayList<Visit>();
				visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
			for(Visit visit:visitList){
				visit.setVisitStatus("C");
				hbt.update(visit);
			} */

					
					if(collHeader!=null && collHeader.getId()!=null){
						hbt.refresh(collHeader); 
						collectionDetailsSet  =	collHeader.getDgSampleCollectionDetails(); 
						Hibernate.initialize(collectionDetailsSet); 
						Hibernate.initialize(collHeader.getHin()); 
						Hibernate.initialize(collHeader.getOrder().getVisit()); 
						sampleCollectionMap.put(collHeader, collectionDetailsSet); 
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}






				// ---------------------Save or Update Data into sampleHeader
				// table---------------------------

				try {
					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();
					List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
					for (int a = 0; a < chargeList.size(); a++) {
						int chargeCodeId = Integer.parseInt(chargeList.get(a)
								.toString());

						chargeCodeList = session
								.createCriteria(MasChargeCode.class)
								.add(Restrictions.eq("Id", chargeCodeId)).list();
						if (chargeCodeList.size() > 0) {
							MasChargeCode chargeCode = chargeCodeList.get(0);
							if (chargeCode.getDepartment()
									.getDepartmentType().getDepartmentTypeCode()
									.equals("RADIO")) {

								if (hinId != 0) {
									Patient patient = new Patient();
									patient.setId(hinId);
									collHeader.setHin(patient);
								}
								if (inpatientId != 0) {
									Inpatient inpatient = new Inpatient();
									inpatient.setId(inpatientId);
									collHeader.setInpatient(inpatient);
								}
								if (chargeCode.getDepartment() != null) {
									MasDepartment department = new MasDepartment();
									department.setId(chargeCode.getDepartment().getId());
									collHeader.setDepartment(department);
								}
								collHeader.setHospital(hospital);
								collHeader.setOrder(dgOrderhd);
								collHeader.setDiagnosisDate(changeDate);
								collHeader.setDiagnosisTime(time);
								collHeader.setOrderStatus("P");
								collHeader.setLastChgBy(users);
								collHeader.setLastChgDate(changeDate);
								collHeader.setLastChgTime(time);

								hbt.save(collHeader);

								// -----------------------in sample
								// detail----------------------------

								for (int i = 0; i < chargeCodeList.size(); i++) {

									DgSampleCollectionDetails sampleDetails = new DgSampleCollectionDetails();
									sampleDetails
									.setSampleCollectionHeader(collHeader);
									MasChargeCode masChargeCode = new MasChargeCode();
									masChargeCode.setId(chargeCodeId);
									sampleDetails.setChargeCode(masChargeCode);
									sampleDetails.setCollectedBy(users
											.getEmployee());
									// sampleDetails.setSample(sample);
									sampleDetails.setCollected("y");
									sampleDetails.setLastChgBy(users);
									sampleDetails.setLastChgDate(changeDate);
									sampleDetails.setLastChgTime(time);
									sampleDetails.setOrderStatus("P");
									sampleDetails.setSampleCollDatetime(changeDate);


									MasMainChargecode maincharge = new MasMainChargecode();
									int mainChargeId = Integer
											.parseInt(mainChargeList.get(i)
													.toString());
									maincharge.setId(chargeCode.getMainChargecode()
											.getId());
									sampleDetails.setMaincharge(maincharge);

									MasSubChargecode subCharge = new MasSubChargecode();
									subCharge.setId(chargeCode.getSubChargecode()
											.getId());
									sampleDetails.setSubcharge(subCharge);

									int subChargeId = chargeCode.getSubChargecode()
											.getId();
									// String diagNo =
									// generateDiagNumber(subChargeId);
									// sampleDetails.setDiagNo(diagNo);

									DgMasInvestigation investigation = new DgMasInvestigation();
									investigation.setId(chargeCodeId);
									sampleDetails.setInvestigation(investigation);
									sampleDetails.setSampleCollDatetime(new Date());

									hbt.save(sampleDetails);
								}
							}
						}
					}

					List<Visit>visitList=new ArrayList<Visit>();
					visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Id",visitId)).list();
					for(Visit visit:visitList){
						visit.setVisitStatus("C");
						hbt.update(visit);
					} 

					
					if(collHeader!=null && collHeader.getId()!=null){
						hbt.refresh(collHeader); 
						collectionDetailsSet  =	collHeader.getDgSampleCollectionDetails(); 
						Hibernate.initialize(collectionDetailsSet); 
						Hibernate.initialize(collHeader.getHin()); 
						Hibernate.initialize(collHeader.getOrder().getVisit()); 
						sampleCollectionMap.put(collHeader, collectionDetailsSet); 
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				Map<String,Object> mapForBilling=new HashMap<String, Object>(); 
				mapForBilling.put(HIN_ID, hinId);
				if(dgOrderhd.getVisit()!=null){//Added by govind 27-07-2017 for IP Lab OrderBooking
					mapForBilling.put(VISIT_ID, dgOrderhd.getVisit().getId());
				}
				mapForBilling.put(HOSPITAL_ID, hospitalId);
				mapForBilling.put(USER_ID, userId);
				mapForBilling.put("orderId", dgOrderhd.getId()); 
				//billingMasterDataService.internalBillingForService(mapForBilling);
				
				
			} catch (DataAccessException e) {

			}
			//tx.rollback();
			tx.commit(); 
			saved = true;
			//int dgOrderhdId = dgOrderhd.getId();
			resultMap.put("dgOrderHdId", dgOrderhd.getId());
			resultMap.put("saved", saved);
			resultMap.put("adNo", adNo);
			resultMap.put("uHid", uHid);
			// resultMap.put("dgOrderhd", dgOrderhd);
			
			hbt.refresh(hdOld); 
			dgOrderdts =	hdOld.getDgOrderdts();  
			Hibernate.initialize(dgOrderdts);
			Hibernate.initialize(hdOld.getVisit()); 
			Hibernate.initialize(hdOld.getHin()); 
			orderMap.put(hdOld, dgOrderdts);

		}catch(Exception e){
		e.printStackTrace();
		if(tx!=null){
			tx.rollback();
			}
		}
		
		
		
		Hibernate.initialize(hospital);
		dataForOrderBooking.put("orderMap", orderMap);  // added by amit das on  12-09-2017
		dataForOrderBooking.put("sampleMap", sampleCollectionMap); // added by amit das on  12-09-2017
		dataForOrderBooking.put("hospital", hospital);// added by amit das on  12-09-2017
		
		final MasHospital masHospital = hospital;
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
						sampleManipulactionToCentralServer(dataForOrderBooking,"order");
				} 
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
						sampleManipulactionToLeanServer(dataForOrderBooking,"order");
						
				}
			}
			
		}.start();*/
		
		
		return resultMap;
	}

	// added by amit das on 11-09-2017
	public String sampleManipulactionToCentralServer(Map<String,Object>  dataForSample, String type){

		String result = "failure";
		MasHospital hospital=(MasHospital)dataForSample.get("hospital");
		String status=null;
		String sampleData =null;
		if(type!=null && type.equalsIgnoreCase("validation")){
			status = "V";
		}else if(type!=null && type.equalsIgnoreCase("collection")){
			status = "N";
		}else if(type!=null && type.equalsIgnoreCase("order")){
			status = "O";
		}

				
		try{
					sampleData = generateStringForSample(dataForSample,type);
			  	  	
			  	    if(!sampleData.trim().equals("")){
				  	  	HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
				  	  	
						CentralServerSampleData centralServerSampleData = new CentralServerSampleData();
						centralServerSampleData.setSampleData(sampleData);
						centralServerSampleData.setStatus(status);
						centralServerSampleData.setHospitalId(Long.parseLong(hospital.getId()+""));
				  	  	hbt.save(centralServerSampleData);
				  	  	hbt.flush();
				  	  	hbt.clear();
				  	  	result = "success";
				  	}
        	}catch(Exception e){
                e.printStackTrace();
        	}
		return result;
	}
		
		public String sampleManipulactionToLeanServer(Map<String,Object> dataForSample, String type){
			String result = "failure";
			MasHospital hospital=(MasHospital)dataForSample.get("hospital");
			String status=null;
			String sampleData =null;
			if(type!=null && type.equalsIgnoreCase("validation")){
				status = "V";
			}else if(type!=null && type.equalsIgnoreCase("collection")){
				status = "N";
			}else if(type!=null && type.equalsIgnoreCase("order")){
				status = "O";
			}

			try{
						sampleData = generateStringForSample(dataForSample,type);
				  	  	
				  	    if(!sampleData.trim().equals("")){
					  	  	HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
					  	  	LeanServerSampleData leanSampleData = new LeanServerSampleData();
					  	  	leanSampleData.setSampleData(sampleData);
					  	  	leanSampleData.setStatus(status);
					  	  	leanSampleData.setHospitalId(Long.parseLong(hospital.getId()+""));
					  	  	hbt.save(leanSampleData);
					  	  	hbt.flush();
					  	  	hbt.clear(); 
					  		result = "success";
					  	}
	        	}catch(Exception e){
	                e.printStackTrace();
	        	}
			return result;
		}
	
	// added by amit das on 11-09-2017
	private String generateStringForSample(
			Map<String, Object> dataForSample, String type) {
		StringBuilder builder=new StringBuilder(); 
		
		Map<DgOrderhd, Set<DgOrderdt>> orderMap =  (Map<DgOrderhd, Set<DgOrderdt>>)dataForSample.get("orderMap"); 
		Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>> sampleMap =  (Map<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>)dataForSample.get("sampleMap");
		
		DgOrderhd dgOrderhd = null;
		Set<DgOrderdt> dgOrderdts = null;
		PharmacyLabQueue pharmacyLabQueue = null;
		List<PharmacyLabQueue> pharmacyLabQueueList = null;
		DgSampleCollectionHeader sampleCollectionHeader = null;
		Set<DgSampleCollectionDetails> sampleCollectionDetails = null;
		Patient patient = null;
		Visit visit = null;
		
    	
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy"); // added by amit das on 27-06-2016
		
    	try{
    	if(orderMap!=null && orderMap.size()>0){
    		
    		for(Entry<DgOrderhd, Set<DgOrderdt>>  entry : orderMap.entrySet()){
    			dgOrderhd  = 	entry.getKey();
    			dgOrderdts =	entry.getValue();
    			
    			patient = dgOrderhd.getHin();
    			visit = dgOrderhd.getVisit();
    			
    			builder.append(type).append(" |");
    			builder.append(patient.getHinNo()).append(" |"); 
				builder.append(visit.getVisitNo()).append(" |");
				builder.append(visit.getDepartment().getId()).append(" |"); 
				builder.append(visit.getHospital().getId()).append(" |"); 
				builder.append(dgOrderhd.getOrderStatus()).append(" |"); 
				builder.append(formatter.format(visit.getVisitDate())).append(" |"); 
				if(dgOrderhd.getBillChargeSlpNo()!=null)
					builder.append(dgOrderhd.getBillChargeSlpNo()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getClinicalNote()!=null)
					builder.append(dgOrderhd.getClinicalNote()).append(" |");
				else
					builder.append(" |");
				builder.append(dgOrderhd.getLastChgTime()).append(" |");
				
				if(dgOrderhd.getOrderNo()!=null)
					builder.append(dgOrderhd.getOrderNo()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getOrderTime()!=null)
					builder.append(dgOrderhd.getOrderTime()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getPatientType()!=null)
					builder.append(dgOrderhd.getPatientType()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getPrescribedByNurse()!=null)
					builder.append(dgOrderhd.getPrescribedByNurse()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getProvisionalDiag()!=null)
					builder.append(dgOrderhd.getProvisionalDiag()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getRoutineUrgentStatus()!=null)
					builder.append(dgOrderhd.getRoutineUrgentStatus()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getSmearNo()!=null)
					builder.append(dgOrderhd.getSmearNo()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getTestType()!=null)
					builder.append(dgOrderhd.getTestType()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getUrgentRemarks()!=null)
					builder.append(dgOrderhd.getUrgentRemarks()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getDepartment()!=null)
					builder.append(dgOrderhd.getDepartment().getId()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getHospital()!=null)
					builder.append(dgOrderhd.getHospital().getId()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getInvestigationRequestionNo()!=null)
					builder.append(dgOrderhd.getInvestigationRequestionNo().getId()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getLastChgBy()!=null)
					builder.append(dgOrderhd.getLastChgBy().getId()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getLastChgDate()!=null)
					builder.append(formatter.format(dgOrderhd.getLastChgDate())).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getNetAmount()!=null)
					builder.append(dgOrderhd.getNetAmount()).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getOrderDate()!=null)
					builder.append(formatter.format(dgOrderhd.getOrderDate())).append(" |");
				else
					builder.append(" |");
				
				if(dgOrderhd.getPrescribedBy()!=null)
					builder.append(dgOrderhd.getPrescribedBy().getId()).append(" |");
				else
					builder.append(" |");
				
				builder.append("~"); 
				
    			for(DgOrderdt dgOrderdt : dgOrderdts){

					builder.append(dgOrderdt.getChargeCode().getId()).append(" |");
					builder.append(dgOrderdt.getOrderStatus()).append(" |"); 
					
					if(dgOrderdt.getOrderCancelStatus()!=null)
						builder.append(dgOrderdt.getOrderCancelStatus()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getAmount()!=null)
						builder.append(dgOrderdt.getAmount()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getInPkgFlag()!=null)
						builder.append(dgOrderdt.getInPkgFlag()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getLastChgBy()!=null)
						builder.append(dgOrderdt.getLastChgBy().getId()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getLastChgDate()!=null)
						builder.append(formatter.format(dgOrderdt.getLastChgDate())).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getLastChgTime()!=null)
						builder.append(dgOrderdt.getLastChgTime()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getMainChargecode()!=null)
						builder.append(dgOrderdt.getMainChargecode().getId()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getMsgSent()!=null)
						builder.append(dgOrderdt.getMsgSent()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getNotApplicable()!=null)
						builder.append(dgOrderdt.getNotApplicable()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getOrderQty()!=null)
						builder.append(dgOrderdt.getOrderQty()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getOutsideLab()!=null)
						builder.append(dgOrderdt.getOutsideLab()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getOutsideLabName()!=null)
						builder.append(dgOrderdt.getOutsideLabName()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getPacsErrorCode()!=null)
						builder.append(dgOrderdt.getPacsErrorCode()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getPacsErrorMessage()!=null)
						builder.append(dgOrderdt.getPacsErrorMessage()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getPacsMessage()!=null)
						builder.append(dgOrderdt.getPacsMessage()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getPacsStatus()!=null)
						builder.append(dgOrderdt.getPacsStatus()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getPaymentMade()!=null)
						builder.append(dgOrderdt.getPaymentMade()).append(" |");
					else
						builder.append(" |");
					
					if(dgOrderdt.getSubChargeid()!=null)
						builder.append(dgOrderdt.getSubChargeid().getId()).append(" |");
					else
						builder.append(" |");
					
					builder.append("$"); 
				}
    			builder.append("~");
    			builder.append("C");
    			builder.append(" #");
    			
    		}

        	builder.append("^");
    	}
    	
		
    	if(sampleMap!=null && sampleMap.size()>0){
    		for(Entry<DgSampleCollectionHeader, Set<DgSampleCollectionDetails>>  entry : sampleMap.entrySet()){
    			sampleCollectionHeader  = 	entry.getKey();
    			sampleCollectionDetails =	entry.getValue();
    			
    				patient = sampleCollectionHeader.getHin();
    				dgOrderhd = sampleCollectionHeader.getOrder();
    				visit = dgOrderhd.getVisit();
    				
    				builder.append(type).append(" |");
					builder.append(patient.getHinNo()).append(" |"); 
					builder.append(visit.getVisitNo()).append(" |");
					builder.append(visit.getDepartment().getId()).append(" |"); 
					builder.append(visit.getHospital().getId()).append(" |"); 
					builder.append(formatter.format(visit.getVisitDate())).append(" |"); 
					if(sampleCollectionHeader.getBloodSampleCollectionTime()!=null){
						builder.append(sampleCollectionHeader.getBloodSampleCollectionTime()).append(" |");
					}else{
						builder.append(" |");
					}
					if(sampleCollectionHeader.getDiagnosisDate()!=null){
						builder.append(formatter.format(sampleCollectionHeader.getDiagnosisDate())).append(" |");
					}else{
						builder.append(" |");
					}
					builder.append(sampleCollectionHeader.getOrderStatus()).append(" |"); 
					builder.append(sampleCollectionHeader.getSampleBarCode()).append(" |"); 
					builder.append(formatter.format(sampleCollectionHeader.getLastChgDate())).append(" |"); 
					if(sampleCollectionHeader.getCollectionCenter()!=null){
						builder.append(sampleCollectionHeader.getCollectionCenter().getId()).append(" |");
					}else{
						builder.append(" |");
					}  
					if(sampleCollectionHeader.getDepartment()!=null){
						builder.append(sampleCollectionHeader.getDepartment().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(sampleCollectionHeader.getLastChgBy()!=null){
						builder.append(sampleCollectionHeader.getLastChgBy().getId()).append(" |");
					}else{
						builder.append(" |");
					} 
					
					builder.append(sampleCollectionHeader.getLastChgTime()).append(" |"); 
					builder.append(sampleCollectionHeader.getHospital().getId()).append(" |");
					
					if(sampleCollectionHeader.getOrderByDepartment()!=null){
						builder.append(sampleCollectionHeader.getOrderByDepartment().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(sampleCollectionHeader.getReferHospital()!=null){
						builder.append(sampleCollectionHeader.getReferHospital().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					 
					if(sampleCollectionHeader.getSampleValidationTime()!=null){
						builder.append(sampleCollectionHeader.getSampleValidationTime()).append(" |");
					}else{
						builder.append(" |");
					}
					
					if(sampleCollectionHeader.getSampleValidationDate()!=null){
						builder.append(formatter.format(sampleCollectionHeader.getSampleValidationDate())).append(" |");
					}else{
						builder.append(" |");
					}
					
					if(sampleCollectionHeader.getValidatedBy()!=null){
						builder.append(sampleCollectionHeader.getValidatedBy().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					
				 builder.append("~"); 
				
    			for(DgSampleCollectionDetails samplCollectionDetail : sampleCollectionDetails){
    				builder.append(samplCollectionDetail.getChargeCode().getId()).append(" |");
					builder.append(samplCollectionDetail.getMaincharge().getId()).append(" |");
					builder.append(samplCollectionDetail.getSubcharge().getId()).append(" |");
					if(samplCollectionDetail.getOrderStatus()!=null){
						builder.append(samplCollectionDetail.getOrderStatus()).append(" |");
					}else{
						builder.append(" |");
					}
					builder.append(samplCollectionDetail.getCollected()).append(" |");
					if(samplCollectionDetail.getSample()!=null){
						builder.append(samplCollectionDetail.getSample().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getDiagNo()!=null){
						builder.append(samplCollectionDetail.getDiagNo()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getEmpanelledStatus()!=null){
						builder.append(samplCollectionDetail.getEmpanelledStatus()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getContainer()!=null){
						builder.append(samplCollectionDetail.getContainer().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getLabStatus()!=null){
						builder.append(samplCollectionDetail.getLabStatus()).append(" |");
					}else{
						builder.append(" |");
					}
					builder.append(samplCollectionDetail.getLastChgTime()).append(" |");
					if(samplCollectionDetail.getReason()!=null){
						builder.append(samplCollectionDetail.getReason()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getReferStatus()!=null){
						builder.append(samplCollectionDetail.getReferStatus()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getRejected()!=null){
						builder.append(samplCollectionDetail.getRejected()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getRemarks()!=null){
						builder.append(samplCollectionDetail.getRemarks()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getSampleNo()!=null){
						builder.append(samplCollectionDetail.getSampleNo()).append(" |");
					}else{
						builder.append(" |");
					}
					
					builder.append(formatter.format(samplCollectionDetail.getSampleCollDatetime())).append(" |"); 
					if(samplCollectionDetail.getInvestigation()!=null){
						builder.append(samplCollectionDetail.getInvestigation().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getCollectedBy()!=null){
						builder.append(samplCollectionDetail.getCollectedBy().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getLastChgBy()!=null){
						builder.append(samplCollectionDetail.getLastChgBy().getId()).append(" |");
					}else{
						builder.append(" |");
					}
					if(samplCollectionDetail.getValidated()!=null){
						builder.append(samplCollectionDetail.getValidated()).append(" |");
					}else{
						builder.append(" |");
					}
					builder.append("$"); 
				}
				builder.append(" #");
    			
    		}
    	}
    	
       }catch(Exception e){
    	   e.printStackTrace();
       }
    	
		String sampleData = builder.toString();
		return sampleData;
	}
	
	//  added by amit das on 11-09-2017
    public String saveSampleCollectionToLeanCentralServer(Box box){
		String result = "success";
		String message = box.get("message");
		
		logger.info("Receievd Message - ");
		logger.info(message);
		
		String[] orderAndSampleCollectionStrArray =	message.trim().split("\\^");
		
		String[] orderFullStrArray = null;
		String[] orderStrArray = null;
		String[] dgOrderDtsStrArray = null;
		String[] dgOrderHdStrArray = null;
		String[] dgOrderDtStrArray = null;
		
		String[] sampleCollectionFullStrArray = null;
		String[] sampleCollectionStrArray = null;
		String[] sampleCollectionDetailsStrArray = null;
		String[] sampleCollectionHeaderStrArray = null;
		String[] sampleCollectionDetailStrArray = null;
		
		
		String dgOrderHdStr = null;
		String dgOrderDtsStr = null;
		String sampleCollectionHeaderStr = null;
		String sampleCollectionDetailStr = null;
		
		int visitNo = 0;
		int visitId = 0;
		int chargeCodeId = 0;
		int dgOrderhdId = 0;
		String hinNo = null;
		DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy"); 
		Date visitDate = null;
		int departmentId = 0;
		int sampleCollectionHeaderId = 0;
		int hospitalId = 0;
		String orderStatus = null;
		String orderCancelStatus = null;
		String type = null;
		String pharmacyLabQueueStatus = null;
		String chargeCodeStr = null;
		
		List<Patient> patientList 							= null;
		List<Visit> visitList 								= null;
		List<DgOrderhd> dgOrderhdList 						= null;
		List<DgOrderdt> dgOrderdtList 						= null;
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList 		= null;
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList 		= null;
		List<PharmacyLabQueue> pharmacyLabQueueList 		= null;
		
		
		DgOrderhd dgOrderhd = null;
		DgOrderdt dgOrderdt = null;
		DgSampleCollectionHeader dgSampleCollectionHeader = null;
		DgSampleCollectionDetails dgSampleCollectionDetail = null;
		PharmacyLabQueue pharmacyLabQueue = null;
		Patient patient = null;
		Visit visit = null;
		
		Session session=(Session)getSession();
		Criteria criteria = null;
		org.hibernate.Transaction transaction = null;
		
		int i = 0;
		try{
		if(orderAndSampleCollectionStrArray!=null && orderAndSampleCollectionStrArray.length>0){
			if(orderAndSampleCollectionStrArray[0].indexOf("#")>0)
			orderStrArray 				= 	orderAndSampleCollectionStrArray[0].split("#");
			
			if(orderAndSampleCollectionStrArray.length==2 && orderAndSampleCollectionStrArray[1].indexOf("#")>0)
			sampleCollectionStrArray 	=	orderAndSampleCollectionStrArray[1].split("#");
			
			transaction = session.beginTransaction();
			if(orderStrArray!=null && orderStrArray.length>0){
				for(String orderFullString : orderStrArray){
					orderFullStrArray 	= 	orderFullString.split("~");
					
					dgOrderHdStrArray 		= 	orderFullStrArray[0].split("\\|");
					dgOrderDtsStrArray 		= 	orderFullStrArray[1].split("\\$");
					pharmacyLabQueueStatus 	= 	orderFullStrArray[2];
					
					type				=   dgOrderHdStrArray[i++].trim();
					hinNo 				= 	dgOrderHdStrArray[i++].trim();
					visitNo 			= 	Integer.parseInt(dgOrderHdStrArray[i++].trim());
					departmentId 		= 	Integer.parseInt(dgOrderHdStrArray[i++].trim());
					hospitalId 			= 	Integer.parseInt(dgOrderHdStrArray[i++].trim());
					orderStatus 		= 	dgOrderHdStrArray[i++].trim();
					visitDate			=   formatter.parse(dgOrderHdStrArray[i++].trim());
					
					i=0;
					criteria = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
					patientList = criteria.list();
					if(patientList!=null && patientList.size()==1){
						patient = patientList.get(0);
						criteria = session.createCriteria(Visit.class).add(Restrictions.eq("VisitNo", visitNo)).add(Restrictions.eq("Department.Id", departmentId))
								.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Hin.Id", patient.getId())) .add(Restrictions.eq("VisitDate", visitDate));
						visitList = criteria.list();
						
						if(visitList!=null && visitList.size()==1){
							visit   =  visitList.get(0);
							visitId =  visitList.get(0).getId();
							criteria = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Visit.Id", visitId));
							dgOrderhdList = criteria.list();
						   
							if(dgOrderhdList!=null && dgOrderhdList.size()==1 && !type.equalsIgnoreCase("order")){
								dgOrderhd = dgOrderhdList.get(0);
								dgOrderhd.setOrderStatus(orderStatus);
								dgOrderhdId =	dgOrderhd.getId();
								session.update(dgOrderhd);
						
						
							 for(String dgOrderDtStr : dgOrderDtsStrArray){
								dgOrderDtStrArray =	dgOrderDtStr.split("\\|");
								chargeCodeId =  Integer.parseInt(dgOrderDtStrArray[i++].trim());
								orderStatus = dgOrderDtStrArray[i++].trim();
								orderCancelStatus = dgOrderDtStrArray[i++].trim();
								criteria = session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhdId)).add(Restrictions.eq("ChargeCode.Id", chargeCodeId));
								dgOrderdtList = criteria.list();
								if(dgOrderdtList!=null && dgOrderdtList.size()>0){
									dgOrderdt = dgOrderdtList.get(0);
								
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setAmount(new BigDecimal(dgOrderDtStrArray[i].trim()));
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setInPkgFlag(dgOrderHdStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals("")){
										Users users = new Users(Integer.parseInt(dgOrderDtStrArray[i].trim())); 
										dgOrderdt.setLastChgBy(users);
									}
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setLastChgDate(formatter.parse(dgOrderDtStrArray[i].trim()));
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setLastChgTime(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals("")){
										MasMainChargecode mainChargecode = new MasMainChargecode(Integer.parseInt(dgOrderDtStrArray[i].trim())); 
										dgOrderdt.setMainChargecode(mainChargecode);
									}
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setMsgSent(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setNotApplicable(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setOrderQty(Integer.parseInt(dgOrderDtStrArray[i].trim()));
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setOutsideLab(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setOutsideLabName(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setPacsErrorCode(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setPacsErrorMessage(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setPacsMessage(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setPacsStatus(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals(""))
										dgOrderdt.setPaymentMade(dgOrderDtStrArray[i].trim());
									i++;
									
									if(!dgOrderDtStrArray[i].trim().equals("")){
										MasSubChargecode subChargecode = new MasSubChargecode(Integer.parseInt(dgOrderDtStrArray[i].trim()));
										dgOrderdt.setSubChargeid(subChargecode);
									}
									i++;
									
									dgOrderdt.setOrderStatus(orderStatus);
									dgOrderdt.setOrderCancelStatus(orderCancelStatus);
									session.saveOrUpdate(dgOrderdt);
									i=0;
								}else{
									result = "failure";
									break;
								}
								
							 }
							 
							 pharmacyLabQueueList =	 session.createCriteria(PharmacyLabQueue.class).add(Restrictions.eq("DgOrderhdId.Id", dgOrderhdId)).list();
							 if(pharmacyLabQueueList!=null && pharmacyLabQueueList.size()>0){	
								 	pharmacyLabQueue =	pharmacyLabQueueList.get(0);
								 	if(!pharmacyLabQueueStatus.trim().equals("")){
								 		pharmacyLabQueue.setStatus(pharmacyLabQueueStatus);
								 		session.update(pharmacyLabQueue);
								 	}
							 }
							 
						  }else if(type!=null && type.equalsIgnoreCase("order")){
							  	criteria = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Visit.Id", visitId));
								dgOrderhdList = criteria.list();
								if(dgOrderhdList!=null && dgOrderhdList.size()>0)
									dgOrderhd = dgOrderhdList.get(0);
								else
									dgOrderhd = new DgOrderhd();
								
								dgOrderhd.setOrderStatus(orderStatus);
								dgOrderhd.setVisit(visitList.get(0));
								dgOrderhd.setHin(patient);
								
								i=7;
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setBillChargeSlpNo(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setClinicalNote(dgOrderHdStrArray[i].trim());
								i++;
								
								dgOrderhd.setLastChgTime(dgOrderHdStrArray[i++].trim());
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setOrderNo(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setOrderTime(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setPatientType(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setPrescribedByNurse(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setProvisionalDiag(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setRoutineUrgentStatus(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setSmearNo(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setTestType(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setUrgentRemarks(dgOrderHdStrArray[i].trim());
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals("")){
									MasDepartment department = new MasDepartment(Integer.parseInt(dgOrderHdStrArray[i].trim())); 
									dgOrderhd.setDepartment(department);
								}
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals("")){
									MasHospital hospital = new MasHospital(Integer.parseInt(dgOrderHdStrArray[i].trim())); 
									dgOrderhd.setHospital(hospital);
								}
								i++;
								i++ ; // patient investigation Header
								if(!dgOrderHdStrArray[i].trim().equals("")){
									Users users = new Users(Integer.parseInt(dgOrderHdStrArray[i].trim())); 
									dgOrderhd.setLastChgBy(users);
								}
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setLastChgDate(formatter.parse(dgOrderHdStrArray[i].trim()));
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setNetAmount(new BigDecimal(dgOrderHdStrArray[i].trim()));
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals(""))
									dgOrderhd.setOrderDate(formatter.parse(dgOrderHdStrArray[i].trim()));
								i++;
								
								if(!dgOrderHdStrArray[i].trim().equals("")){
									MasEmployee employee = new MasEmployee(Integer.parseInt(dgOrderHdStrArray[i].trim())); 
									dgOrderhd.setPrescribedBy(employee);
								}
								session.saveOrUpdate(dgOrderhd);
								dgOrderhdId =	dgOrderhd.getId();
								
								
								i =0;
								 for(String dgOrderDtStr : dgOrderDtsStrArray){
										dgOrderDtStrArray =	dgOrderDtStr.split("\\|");
										chargeCodeStr = dgOrderDtStrArray[i++].trim();
										if(!chargeCodeStr.equals("")){
										chargeCodeId =  Integer.parseInt(chargeCodeStr);
										orderStatus = dgOrderDtStrArray[i++].trim();
										orderCancelStatus = dgOrderDtStrArray[i++].trim();
										
										criteria = session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Orderhd.Id", dgOrderhdId)).add(Restrictions.eq("ChargeCode.Id", chargeCodeId));
										dgOrderdtList = criteria.list();
										if(dgOrderdtList!=null && dgOrderdtList.size()>0)
											dgOrderdt = dgOrderdtList.get(0);
										else
											dgOrderdt = new DgOrderdt();
										
										dgOrderdt.setChargeCode(new MasChargeCode(chargeCodeId));
										dgOrderdt.setOrderStatus(orderStatus);
										dgOrderdt.setOrderCancelStatus(orderCancelStatus);
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setAmount(new BigDecimal(dgOrderDtStrArray[i].trim()));
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setInPkgFlag(dgOrderHdStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals("")){
											Users users = new Users(Integer.parseInt(dgOrderDtStrArray[i].trim())); 
											dgOrderdt.setLastChgBy(users);
										}
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setLastChgDate(formatter.parse(dgOrderDtStrArray[i].trim()));
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setLastChgTime(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals("")){
											MasMainChargecode mainChargecode = new MasMainChargecode(Integer.parseInt(dgOrderDtStrArray[i].trim())); 
											dgOrderdt.setMainChargecode(mainChargecode);
										}
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setMsgSent(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setNotApplicable(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setOrderQty(Integer.parseInt(dgOrderDtStrArray[i].trim()));
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setOutsideLab(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setOutsideLabName(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setPacsErrorCode(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setPacsErrorMessage(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setPacsMessage(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setPacsStatus(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals(""))
											dgOrderdt.setPaymentMade(dgOrderDtStrArray[i].trim());
										i++;
										
										if(!dgOrderDtStrArray[i].trim().equals("")){
											MasSubChargecode subChargecode = new MasSubChargecode(Integer.parseInt(dgOrderDtStrArray[i].trim()));
											dgOrderdt.setSubChargeid(subChargecode);
										}
										dgOrderdt.setOrderhd(dgOrderhd);
										
										session.saveOrUpdate(dgOrderdt);
										
										}
										i=0;
									 }
								 
								 pharmacyLabQueueList =	 session.createCriteria(PharmacyLabQueue.class).add(Restrictions.eq("Visit.Id", visitId)).list();
								 if(pharmacyLabQueueList!=null && pharmacyLabQueueList.size()>0){	
									 	pharmacyLabQueue =	pharmacyLabQueueList.get(0);
									 	if(!pharmacyLabQueueStatus.trim().equals("")){
									 		pharmacyLabQueue.setDgOrderhdId(dgOrderhd);
									 		pharmacyLabQueue.setStatus(pharmacyLabQueueStatus);
									 		session.update(pharmacyLabQueue);
									 	}
								 }
								visit.setVisitStatus("C");
								session.update(visit);
						  } else{
							   result = "failure";
							   break;
						   }
					   }else{
						   result = "failure";
						   break;
					   }
						
					}else{
						result = "failure";
						break;
					}
					
				}
			}else{
				result = "failure";
			}
			
			if(type!=null && !type.equalsIgnoreCase("order") ){
			if(!result.equalsIgnoreCase("failure") && sampleCollectionStrArray!=null && sampleCollectionStrArray.length>0){
				for(String sampleCollectionFullString : sampleCollectionStrArray){
					sampleCollectionFullStrArray 		= 	sampleCollectionFullString.split("~");
					
					sampleCollectionHeaderStrArray 		= 	sampleCollectionFullStrArray[0].split("\\|");
					sampleCollectionDetailsStrArray 	= 	sampleCollectionFullStrArray[1].split("\\$");
		        
					type 				= 	sampleCollectionHeaderStrArray[i++].trim();		        
					hinNo 				= 	sampleCollectionHeaderStrArray[i++].trim();
					visitNo 			= 	Integer.parseInt(sampleCollectionHeaderStrArray[i++].trim());
					departmentId 		= 	Integer.parseInt(sampleCollectionHeaderStrArray[i++].trim());
					hospitalId 			= 	Integer.parseInt(sampleCollectionHeaderStrArray[i++].trim());
					visitDate			=   formatter.parse(sampleCollectionHeaderStrArray[i++].trim());
					
					criteria = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
					patientList = criteria.list();
					if(patientList!=null && patientList.size()==1){
						patient =	patientList.get(0);
						criteria = session.createCriteria(Visit.class).add(Restrictions.eq("VisitNo", visitNo)).add(Restrictions.eq("Department.Id", departmentId))
								.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Hin.Id", patient.getId())).add(Restrictions.eq("VisitDate", visitDate));
						visitList = criteria.list();
						
						if(visitList!=null && visitList.size()==1){
							visitId =  visitList.get(0).getId();
							criteria = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Visit.Id", visitId));
							dgOrderhdList = criteria.list();
						   
							if(dgOrderhdList!=null && dgOrderhdList.size()==1){
								dgOrderhd = dgOrderhdList.get(0);
								dgOrderhd.setOrderStatus(orderStatus);
								dgOrderhdId =	dgOrderhd.getId();
								
								criteria = session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Order.Id", dgOrderhdId));
								dgSampleCollectionHeaderList	= criteria.list();
						
							if(type!=null && type.equalsIgnoreCase("validation")){
								if(dgSampleCollectionHeaderList!=null && dgSampleCollectionHeaderList.size()==1){
									dgSampleCollectionHeader =	dgSampleCollectionHeaderList.get(0);
								}else{
									result = "failure";
									break;
								}
							}else if(dgSampleCollectionHeaderList!=null && dgSampleCollectionHeaderList.size()==1){
								dgSampleCollectionHeader =	dgSampleCollectionHeaderList.get(0);
							}else{
								dgSampleCollectionHeader  = new DgSampleCollectionHeader();
							}
							
							dgSampleCollectionHeader.setHin(patient);
							dgSampleCollectionHeader.setOrder(dgOrderhd);
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								dgSampleCollectionHeader.setBloodSampleCollectionTime(sampleCollectionHeaderStrArray[i].trim());
							}
							i++;
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								dgSampleCollectionHeader.setDiagnosisDate(formatter.parse(sampleCollectionHeaderStrArray[i].trim()));
							}
							i++;
							dgSampleCollectionHeader.setOrderStatus(sampleCollectionHeaderStrArray[i++].trim());
							dgSampleCollectionHeader.setSampleBarCode(sampleCollectionHeaderStrArray[i++].trim());
							dgSampleCollectionHeader.setLastChgDate(formatter.parse(sampleCollectionHeaderStrArray[i++].trim()));
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								DgCollectionCenter collectionCenter = new DgCollectionCenter(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setCollectionCenter(collectionCenter);
							}
							i++;
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								MasDepartment department = new MasDepartment(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setDepartment(department);
							}
							i++;
							
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								Users users = new Users(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setLastChgBy(users);
							}
							i++;
							dgSampleCollectionHeader.setLastChgTime(sampleCollectionHeaderStrArray[i++].trim());
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								MasHospital hospital = new MasHospital(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setHospital(hospital);
							}
							i++;
							
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								MasDepartment orderByDepartment = new MasDepartment(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setOrderByDepartment(orderByDepartment);
							}
							i++;
							
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								MasHospital referHospital = new MasHospital(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setReferHospital(referHospital);
							}
							i++;
							
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								dgSampleCollectionHeader.setSampleValidationTime(sampleCollectionHeaderStrArray[i].trim());
							}
							i++;
							
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								dgSampleCollectionHeader.setSampleValidationDate(formatter.parse(sampleCollectionHeaderStrArray[i].trim()));
							}
							i++;
							if(!sampleCollectionHeaderStrArray[i].trim().equals("")){
								MasEmployee employee = new MasEmployee(Integer.parseInt(sampleCollectionHeaderStrArray[i].trim()));
								dgSampleCollectionHeader.setValidatedBy(employee);
							}
							i++;
							
							session.saveOrUpdate(dgSampleCollectionHeader);
							
							sampleCollectionHeaderId = dgSampleCollectionHeader.getId();
									
							
								i=0;
							if(sampleCollectionHeaderId!=0){
								for(String sampleCollectionDetailsStr : sampleCollectionDetailsStrArray){
									if(!sampleCollectionDetailsStr.trim().equals("")){
									sampleCollectionDetailStrArray =	sampleCollectionDetailsStr.split("\\|");
									
									chargeCodeId =  Integer.parseInt(sampleCollectionDetailStrArray[i++].trim());
									criteria = session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.eq("SampleCollectionHeader.Id", sampleCollectionHeaderId)).add(Restrictions.eq("ChargeCode.Id", chargeCodeId));
									dgSampleCollectionDetailsList = criteria.list();
									if(dgSampleCollectionDetailsList!=null && dgSampleCollectionDetailsList.size()==1){
										dgSampleCollectionDetail = dgSampleCollectionDetailsList.get(0);
									}else{
										dgSampleCollectionDetail = new DgSampleCollectionDetails();
									}
									
									MasChargeCode chargeCode = new MasChargeCode(chargeCodeId);
									dgSampleCollectionDetail.setChargeCode(chargeCode);
									
									MasMainChargecode mainchargeCode = new MasMainChargecode(Integer.parseInt(sampleCollectionDetailStrArray[i++].trim()));
									dgSampleCollectionDetail.setMaincharge(mainchargeCode);

									MasSubChargecode subchargeCode = new MasSubChargecode(Integer.parseInt(sampleCollectionDetailStrArray[i++].trim()));
									dgSampleCollectionDetail.setSubcharge(subchargeCode);
									
									dgSampleCollectionDetail.setSampleCollectionHeader(dgSampleCollectionHeader);
									
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setOrderStatus(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setCollected(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										MasSample sample = new MasSample(Integer.parseInt(sampleCollectionDetailStrArray[i].trim()));
										dgSampleCollectionDetail.setSample(sample);
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setDiagNo(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setEmpanelledStatus(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										DgMasCollection collection = new DgMasCollection(Integer.parseInt(sampleCollectionDetailStrArray[i].trim()));
										dgSampleCollectionDetail.setContainer(collection);
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setLabStatus(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									dgSampleCollectionDetail.setLastChgTime(sampleCollectionDetailStrArray[i++].trim());
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setReason(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setReferStatus(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setRejected(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setRemarks(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setSampleNo(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									dgSampleCollectionDetail.setSampleCollDatetime(formatter.parse(sampleCollectionDetailStrArray[i++].trim()));
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										DgMasInvestigation investigation = new DgMasInvestigation(Integer.parseInt(sampleCollectionDetailStrArray[i].trim()));
										dgSampleCollectionDetail.setInvestigation(investigation);
									}
									i++;
									
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										MasEmployee employee = new MasEmployee(Integer.parseInt(sampleCollectionDetailStrArray[i].trim()));
										dgSampleCollectionDetail.setCollectedBy(employee);
									}
									i++;
									
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										Users users = new Users(Integer.parseInt(sampleCollectionDetailStrArray[i].trim()));
										dgSampleCollectionDetail.setLastChgBy(users);
									}
									i++;
									
									if(!sampleCollectionDetailStrArray[i].trim().equals("")){
										dgSampleCollectionDetail.setValidated(sampleCollectionDetailStrArray[i].trim());
									}
									i++;
									
									
									
									session.saveOrUpdate(dgSampleCollectionDetail);
									i=0;
								}
							 }
							}else{
								   result = "failure";
								   break;
							 }
							
						  }else{
							   result = "failure";
							  break;
						   }
					   }else{
						   result = "failure";
						   break;
					   }
						
					}else{
						   result = "failure";
						   break;
				}
					
				}
									
		}else{
			result = "failure";
		}
		
		}
		
		}else{
			result = "failure";
		}
		session.flush();
		if(transaction!=null)
			transaction.commit();
		
		session.close();
		
		}catch(Exception e){
			result = "failure";
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}
		
		return result;
	}
	
	// added by amit das on 11-09-2017
	@Override
	public Map<String, Object> getPatientSampleCollectionDataForCentralServer() {
		 
			Map<String,Object> dataMap=new HashMap<String,Object>();
			Session session=(Session)getSession();
			try{
			Criteria criteria=session.createCriteria(CentralServerSampleData.class)
					.add(Restrictions.eq("Status", "N").ignoreCase())
					.addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<CentralServerSampleData> centralServerSampleDatas  =criteria.list();
			
			if(centralServerSampleDatas!=null && centralServerSampleDatas.size()>0){
				dataMap.put("centralServerSampleDatas", centralServerSampleDatas);
			}
			} catch (Exception e){
				e.printStackTrace();
			}
			finally{
				if(session!=null){
					session.close();
				}
			}
			return dataMap;
		}

	// added by amit das on 11-09-2017
	@Override
	public Map<String, Object> getPatientSampleCollectionDataForLeanServer() {
		 
		Map<String,Object> dataMap=new HashMap<String,Object>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerSampleData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerSampleData> leanServerSampleDatas  =criteria.list();
		
		if(leanServerSampleDatas!=null && leanServerSampleDatas.size()>0){
			dataMap.put("leanServerSampleDatas", leanServerSampleDatas);
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		finally{
			if(session!=null){
				session.close();
			}
		}
		return dataMap;
	}

	//added by amit das on 11-09-2017
	@Override
	public String updateCentralServerPatientSampleData(
			CentralServerSampleData centralServerSampleData) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false); 
		  	String patientSampleDataSavedToServer="Y";
		  	centralServerSampleData.setStatus(patientSampleDataSavedToServer);
		  	hbt.update(centralServerSampleData);
		  	hbt.flush();
		  	hbt.clear();
		return "success";
	}

	//added by amit das on 11-09-2017
	@Override
	public String updateLeanServerPatientSampleData(
			LeanServerSampleData leanServerSampleData) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false); 
		  	String patientSampleDataSavedToLeanServer="Y";
		  	leanServerSampleData.setStatus(patientSampleDataSavedToLeanServer);
		  	hbt.update(leanServerSampleData);
		  	hbt.flush();
		  	hbt.clear();
		return "success";
	}
	
	// added by amit das on 11-09-2016
		public Map<String, Object> getHospitalData(Map<String, Object> objectMap) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasHospital hospital  = null;
			long hospitalId = 0;
			Session session = (Session)getSession();
			if(objectMap.get("hospitalId")!=null){
				hospitalId = (Long)objectMap.get("hospitalId");
				if(hospitalId!=0){
					hospital = (MasHospital)session.get(MasHospital.class, (int)hospitalId);
				}
			}

			map.put("hospital", hospital);
			if(session!=null){
				session.close();
			}
			return map;
		}
		
	// added by amit das on 11-09-2017
	@Override
	public Map<String, Object> getPatientSampleValidationDataForCentralServer() {
			 
				Map<String,Object> dataMap=new HashMap<String,Object>();
				Session session=(Session)getSession();
				try{
				Criteria criteria=session.createCriteria(CentralServerSampleData.class)
						.add(Restrictions.eq("Status", "V").ignoreCase())
						.addOrder(Order.asc("Id"))
						.setMaxResults(10);
				List<CentralServerSampleData> centralServerSampleDatas  =criteria.list();
				
				if(centralServerSampleDatas!=null && centralServerSampleDatas.size()>0){
					dataMap.put("centralServerSampleDatas", centralServerSampleDatas);
				}
				} catch (Exception e){
					e.printStackTrace();
				}
				finally{
					if(session!=null){
						session.close();
					}
				}
				return dataMap;
	}

	// added by amit das on 11-09-2017
	@Override
	public Map<String, Object> getPatientSampleValidationDataForLeanServer() {
			 
			Map<String,Object> dataMap=new HashMap<String,Object>();
			Session session=(Session)getSession();
			try{
			Criteria criteria=session.createCriteria(LeanServerSampleData.class)
					.add(Restrictions.eq("Status", "V").ignoreCase())
					.addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<LeanServerSampleData> leanServerSampleDatas  =criteria.list();
			
			if(leanServerSampleDatas!=null && leanServerSampleDatas.size()>0){
				dataMap.put("leanServerSampleDatas", leanServerSampleDatas);
			}
			} catch (Exception e){
				e.printStackTrace();
			}
			finally{
				if(session!=null){
					session.close();
				}
			}
			return dataMap;
	}	
	
	// added by amit das on 16-09-2017
		@Override
		public Map<String, Object> getPatientOrderBookingDataForCentralServer() {
				 
					Map<String,Object> dataMap=new HashMap<String,Object>();
					Session session=(Session)getSession();
					try{
					Criteria criteria=session.createCriteria(CentralServerSampleData.class)
							.add(Restrictions.eq("Status", "O").ignoreCase())
							.addOrder(Order.asc("Id"))
							.setMaxResults(10);
					List<CentralServerSampleData> centralServerSampleDatas  =criteria.list();
					
					if(centralServerSampleDatas!=null && centralServerSampleDatas.size()>0){
						dataMap.put("centralServerOrderDatas", centralServerSampleDatas);
					}
					} catch (Exception e){
						e.printStackTrace();
					}
					finally{
						if(session!=null){
							session.close();
						}
					}
					return dataMap;
		}

		// added by amit das on 16-09-2017
		@Override
		public Map<String, Object> getPatientOrderBookingDataForLeanServer() {
				 
				Map<String,Object> dataMap=new HashMap<String,Object>();
				Session session=(Session)getSession();
				try{
				Criteria criteria=session.createCriteria(LeanServerSampleData.class)
						.add(Restrictions.eq("Status", "O").ignoreCase())
						.addOrder(Order.asc("Id"))
						.setMaxResults(10);
				List<LeanServerSampleData> leanServerSampleDatas  =criteria.list();
				
				if(leanServerSampleDatas!=null && leanServerSampleDatas.size()>0){
					dataMap.put("leanServerOrderDatas", leanServerSampleDatas);
				}
				} catch (Exception e){
					e.printStackTrace();
				}
				finally{
					if(session!=null){
						session.close();
					}
				}
				return dataMap;
		}

		@Override
		public Map<String, Object> getLabInvestigationTracker(Box box) {
			Map<String,Object> map=new HashMap<String,Object>();
			Session session=(Session)getSession();
			List<InvestigationTrackerUtil> trackerList=new ArrayList<InvestigationTrackerUtil>();
			List<DgOrderhd> orderList = new ArrayList<DgOrderhd>();
			List<DgOrderdt> orderDetailList = new ArrayList<DgOrderdt>();
			List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
			int deptId = 0;
			int hospitalId = 0;
			int subChargeCodeId=0;
			String barcodetext="";
			Date fromDate = new Date();
			Date toDate = new Date();
			String fromDateStr="",toDateStr="";
			String patientFName="";
			String hinNo = "";
			String patientType="";
			String otherCond=" ";
			MasHospital masHospital= null;
			if (box.get("deptId") != null) {
				deptId = box.getInt("deptId");
			}
			if (box.get("hospitalId") != null) {
				hospitalId = box.getInt("hospitalId");
			}
			if (box.get("subChargeCodeId") != null) {
				subChargeCodeId = box.getInt("subChargeCodeId");
			}
			if (box.get("patientType") != null) {
				patientType = box.getString("patientType");
			}
			
			if (box.get("fromDate") != null && !box.getString("toDate").equals("")) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(box.getString("fromDate"));
			}
			if (box.get("toDate") != null && !box.getString("toDate").equals("")) {
				toDate =HMSUtil.dateFormatterDDMMYYYY(box.getString("toDate"));
			}
			fromDateStr=HMSUtil.getDateFormat(fromDate,"dd/MM/yyyy");
			toDateStr=HMSUtil.getDateFormat(toDate,"dd/MM/yyyy");
			if (box.get("pFirstName") != null) {
				patientFName = box.getString("pFirstName");
			}
			
			if (box.get("hinNo") != null) {
			hinNo = (String) box.getString("hinNo");
			}
			
			if (box.get("barcodetext") != null
					&& !(box.get("barcodetext")
							.equals(""))) {
				barcodetext =box.getString("barcodetext").trim();
			}

			if(hospitalId>0){
				MasHospital hosp=(MasHospital)session.get(MasHospital.class, hospitalId);
				if(hosp!=null && !barcodetext.equals("")){
					barcodetext=hosp.getHospitalCode()+barcodetext;	
					otherCond=otherCond+" and sh.sample_bar_code='"+barcodetext+"' ";
				}
			}
			
			String dateCond=" where oh.order_status!='n' and oh.order_date between '"+HMSUtil.getDateFormat(fromDate,"yyyy-MM-dd")+"' and '"+HMSUtil.getDateFormat(toDate,"yyyy-MM-dd")+"'";
			
			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.createAlias("MainChargecode", "mc")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("mc.Id", 17))
					.addOrder(Order.asc("SubChargecodeName"))
					.list();
			
			/*Criteria crit=session.createCriteria(DgOrderdt.class)
					        .createAlias("Orderhd", "order")
					        .createAlias("order.Hin", "hin");
					        .createAlias("order.SampleCollectionHeader", "sampleHead");
					if (!barcodetext.equals("")) {
						crit = crit.add(
								Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
					}
					if(fromDate!=null && toDate!=null){        
						crit.add(Restrictions.between("order.OrderDate",fromDate,toDate));
					}   */  
					if (!patientFName.equals("")) {
						//crit = crit.add(Restrictions.like("hin.PFirstName","%"+patientFName+ "%").ignoreCase());
						otherCond=otherCond+" and UPPER(pt.p_first_name) like '%"+patientFName.toUpperCase()+"%' ";
					}

					if (!hinNo.equals("")) {
						//crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
						otherCond=otherCond+" and  pt.hin_no='"+hinNo+"' ";
					}
							if (subChargeCodeId>0) {
								//crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
								otherCond=otherCond+" and od.sub_chargeid ="+subChargeCodeId;
							}
							
							if (!patientType.equals("")) {
								//crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
								otherCond=otherCond+" and  oh.patient_type='"+patientType+"' ";
							}
					dateCond=dateCond+otherCond;
			//orderDetailList=crit.addOrder(Order.asc("Id")).list();
			
			/*for(DgOrderdt det:orderDetailList){
				InvestigationTrackerUtil track=new InvestigationTrackerUtil();
				if(det.getOrderhd()!=null && det.getOrderhd().getId()!=null){
					track.setOrderId(det.getOrderhd().getId());
				}
				if(det.getOrderhd()!=null && det.getOrderhd().getHin()!=null){
					track.setHinId(det.getOrderhd().getHin().getId());
					track.setPatientName(det.getOrderhd().getHin().getPFirstName());
					track.setHinNo(det.getOrderhd().getHin().getHinNo());
				}
				if(det.getChargeCode()!=null && det.getChargeCode().getChargeCodeName()!=null){
					track.setInvestigationName(det.getChargeCode().getChargeCodeName());
				}
				if(det.getOrderStatus().equalsIgnoreCase("C") || det.getOrderStatus().equalsIgnoreCase("A")){
					track.setCollectionStatus("Done");
				}else if(det.getOrderStatus().equalsIgnoreCase("P")){
					track.setCollectionStatus("Pending");
					track.setValidationStatus("Pending");
					track.setResultEntryStatus("Pending");
					track.setResultValidationStatus("Pending");
				}
				if(det.getOrderStatus().equalsIgnoreCase("C")){
					track.setValidationStatus("Pending");
					track.setResultEntryStatus("Pending");
					track.setResultValidationStatus("Pending");
				}else if(det.getOrderStatus().equalsIgnoreCase("A")){
					track.setValidationStatus("Done");
					track.setResultEntryStatus("Pending");
					track.setResultValidationStatus("Pending");
				}
				List<DgSampleCollectionDetails> sampColList=session.createCriteria(DgSampleCollectionDetails.class)
		        .createAlias("ChargeCode", "charge")
		        .createAlias("SampleCollectionHeader", "samplHead")
		        .add(Restrictions.eq("charge.Id",det.getChargeCode().getId()))
		        .add(Restrictions.eq("samplHead.Order.Id",det.getOrderhd().getId())).list();
				System.out.println("sampColList "+sampColList.size());
				if(sampColList.size()>0){
					DgSampleCollectionDetails coll=sampColList.get(0);
					if(coll.getOrderStatus().equalsIgnoreCase("E")){
						track.setResultEntryStatus("Done");
						track.setResultValidationStatus("Pending");
					}
					Integer investId=0,sampleHeadId=0;
					if(coll.getInvestigation()!=null && coll.getInvestigation().getId()!=null){
						investId=coll.getInvestigation().getId();
					}
					if(coll.getSampleCollectionHeader()!=null && coll.getSampleCollectionHeader().getId()!=null){
						sampleHeadId=coll.getSampleCollectionHeader().getId();
					}
					System.out.println("investId "+investId+" sampleHeadId "+sampleHeadId);
					List<DgResultEntryHeader> resultEntryList=session.createCriteria(DgResultEntryHeader.class)
					        .createAlias("Investigation", "invest")
					        .createAlias("SampleCollectionHeader", "samplHead")
					        .add(Restrictions.eq("invest.Id",investId))
					        .add(Restrictions.eq("samplHead.Id",sampleHeadId)).list();
							System.out.println("resultEntryList "+resultEntryList.size());
					if(resultEntryList.size()>0){
						DgResultEntryHeader head=resultEntryList.get(0);
						if(head.getVerified().equalsIgnoreCase("V")){
							track.setResultValidationStatus("Done");
						}
					}
				}
				trackerList.add(track);
			}*/
			
			List<Object[]> objList=new ArrayList<Object[]>();
			String query="select pt.hin_id,pt.hin_no,pt.p_first_name,inv.investigation_name,od.order_status order_status,sd.order_status sample_status,rh.verified,oh.orderhd_id,sd.rejected,rh.result_status,oh.order_status from  dg_orderhd oh "+
							" left join dg_orderdt od on od.orderhd_id=oh.orderhd_id "+
							" left join patient pt on pt.hin_id=oh.hin_id "+
							" left join dg_mas_investigation inv on  inv.charge_code_id=od.charge_code_id "+
							" left join dg_sample_collection_header sh on sh.order_id=od.orderhd_id and sh.hin_id=oh.hin_id "+
							" left join dg_sample_collection_details sd on sd.sample_collection_header_id=sh.sample_collection_header_id and sd.investigation_id =inv.investigation_id "+
							" left join dg_result_entry_header rh on rh.sample_collection_header_id=sh.sample_collection_header_id and rh.investigation_id =inv.investigation_id "+
							dateCond+" and oh.hospital_id="+hospitalId+" order by od.orderdt_id";
							/*" group by inv.investigation_name,pt.hin_id,pt.hin_no,pt.p_first_name,od.order_status,sd.order_status,rh.verified,od.orderdt_id,oh.orderhd_id "+
							" order by od.orderdt_id";*/
			
			objList=session.createSQLQuery(query).list();
			for(Object[] det:objList){
					InvestigationTrackerUtil track=new InvestigationTrackerUtil();
					if(det[0]!=null){
						track.setHinId(Integer.parseInt(det[0].toString()));
					}
					if(det[1]!=null){
						track.setHinNo(det[1].toString());
					}
					if(det[2]!=null){
						track.setPatientName(det[2].toString());
					}
					if(det[3]!=null){
						track.setInvestigationName(det[3].toString());
					}
					
					if(det[4]!=null){
					if(det[4].toString().equalsIgnoreCase("C") || det[4].toString().equalsIgnoreCase("A")){
						track.setCollectionStatus("Done");
					}else if(det[4].toString().equalsIgnoreCase("P")){	
                     if(det[8]!=null){
                    	 track.setCollectionStatus("Pending");
 						 track.setValidationStatus("Rejected");
 						 track.setResultEntryStatus("Pending");
 						 track.setResultValidationStatus("Pending");
						}else{
						track.setCollectionStatus("Pending");
						track.setValidationStatus("Pending");
						track.setResultEntryStatus("Pending");
						track.setResultValidationStatus("Pending");
						}
					}
					if(det[4].toString().equalsIgnoreCase("C")){
						track.setValidationStatus("Pending");
						track.setResultEntryStatus("Pending");
						track.setResultValidationStatus("Pending");
					}else if(det[4].toString().equalsIgnoreCase("A")){
						track.setValidationStatus("Done");
						track.setResultEntryStatus("Pending");
						track.setResultValidationStatus("Pending");
					}
					
				 }
					if(det[5]!=null){
					if(det[5].toString().equalsIgnoreCase("E")){
						track.setResultEntryStatus("Done");
						track.setResultValidationStatus("Pending");
					}
					}
					
					if(det[6]!=null){
						if(det[5]!=null && det[5].toString().equalsIgnoreCase("E") && det[6].toString().equalsIgnoreCase("V")){
								track.setResultValidationStatus("Done");
						}else if(det[5]!=null && det[5].toString().equalsIgnoreCase("E") && det[6].toString().equalsIgnoreCase("Y")){
							if(det[9]!=null && det[9].toString().equalsIgnoreCase("R"))
							track.setResultValidationStatus("ReCollect");	
							else
								track.setResultValidationStatus("Pending");
						}else{
							track.setResultValidationStatus("Retest");
						}
					}
					if(det[7]!=null){
						track.setOrderId(Integer.parseInt(det[7].toString()));
					}
					trackerList.add(track);
			}
			
			map.put("subChargeCodeList", subChargeCodeList);
			map.put("trackerList", trackerList);
			map.put("fromDate", fromDateStr);
			map.put("toDate", toDateStr);
			map.put("hinNo", hinNo);
			map.put("pFirstName", patientFName);
			if(barcodetext.length()>9){
				barcodetext=barcodetext.substring(5, 14);
			}
			map.put("barcodetext", barcodetext);
			map.put("subGroupId", subChargeCodeId);
			return map;
		}	

	
	
	
	
}
