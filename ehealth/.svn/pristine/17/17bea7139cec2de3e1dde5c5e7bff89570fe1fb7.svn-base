package jkt.hms.adt.dataservice;

import static jkt.hms.util.RequestConstants.ADDRESS;
import static jkt.hms.util.RequestConstants.BED_ID;
import static jkt.hms.util.RequestConstants.BODY_PART_ID;
import static jkt.hms.util.RequestConstants.BROUGHT_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CONDITION;
import static jkt.hms.util.RequestConstants.CONSQUENCE_OF;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.C_DEATH_CAUSE_ID;
import static jkt.hms.util.RequestConstants.DATE_OF_EXPIRY;
import static jkt.hms.util.RequestConstants.DEATH_CERTIFICATE_TAKEN_BY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.DIET_ID;
import static jkt.hms.util.RequestConstants.DIET_TYPE;
import static jkt.hms.util.RequestConstants.D_DEATH_CAUSE_ID;
import static jkt.hms.util.RequestConstants.FIR_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ID_MARK1;
import static jkt.hms.util.RequestConstants.ID_MARK2;
import static jkt.hms.util.RequestConstants.INCIDENCE_DATE;
import static jkt.hms.util.RequestConstants.INCIDENCE_PLACE;
import static jkt.hms.util.RequestConstants.INCIDENCE_TIME;
import static jkt.hms.util.RequestConstants.INJURY_DETAILS;
import static jkt.hms.util.RequestConstants.INJURY_DIMENSION;
import static jkt.hms.util.RequestConstants.INJURY_NATURE_ID;
import static jkt.hms.util.RequestConstants.INJURY_TYPE;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.MLC_DATE;
import static jkt.hms.util.RequestConstants.MLC_NO;
import static jkt.hms.util.RequestConstants.MLC_TIME;
import static jkt.hms.util.RequestConstants.MOBILE;
import static jkt.hms.util.RequestConstants.NAME_AND_ADDR_OF_DRIVER;
import static jkt.hms.util.RequestConstants.NATURE_OF_MLC;
import static jkt.hms.util.RequestConstants.POLICE_OFFICER;
import static jkt.hms.util.RequestConstants.POLICE_STATION;
import static jkt.hms.util.RequestConstants.RELATION_ID;
import static jkt.hms.util.RequestConstants.RELATIVE_NAME;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SEVERITY_OF_INJURY;
import static jkt.hms.util.RequestConstants.STATEMENT;
import static jkt.hms.util.RequestConstants.S_DEATH_CAUSE_ID;
import static jkt.hms.util.RequestConstants.TIME_OF_EXPIRY;
import static jkt.hms.util.RequestConstants.TO_WARD;
import static jkt.hms.util.RequestConstants.TRANSFER_DATE;
import static jkt.hms.util.RequestConstants.TRANSFER_TIME;
import static jkt.hms.util.RequestConstants.TYPE_AND_NO_OF_VEHICLE;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.WEAPON_USED;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import jkt.hms.billing.dataservice.OpBillingDataService;
import jkt.hms.masters.business.AmbulanceRegister;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.AttachInpatient;
import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlPaywardBooking;
import jkt.hms.masters.business.DialysisSchudeling;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.DischargeSummary;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientDocument;
import jkt.hms.masters.business.IpAdmissionForLean;
import jkt.hms.masters.business.IpAdmissionForServer;
import jkt.hms.masters.business.LeanServerFinalDischargeData;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAdmissionType;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBedStatus;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasBodyPart;
import jkt.hms.masters.business.MasCareType;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeType;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDeathCause;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDischargeStatus;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasInjuryNature;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientCategory;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasRoom;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MedicoLegalDetails;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.MobileRegistration;
import jkt.hms.masters.business.MortuaryRegisterDetails;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.SilDilStatus;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.SMSHTTPSPostClient;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.support.TransactionTemplate;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ORM_O01;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class ADTDataServiceImpl extends HibernateDaoSupport implements ADTDataService {
	OpBillingDataService opBillingDataService = null;
	TransactionTemplate transactionTemplate;
	//Session session;

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(final TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public OpBillingDataService getOpBillingDataService() {
		return opBillingDataService;
	}

	public void setOpBillingDataService(final OpBillingDataService opBillingDataService) {
		this.opBillingDataService = opBillingDataService;
	}

	static final Logger LOGGER = Logger.getLogger(ADTDataServiceImpl.class);

	/*
	 * or we can simple use TransactionCallbackWithoutResult() and also we need
	 * to implement doInTransactionWithoutResult (). this approach is used only
	 * if we don't want to return anything to the calling method.
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getPatientDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String hinNo = "";
		String patientFName = "";
		Session session = getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}

		Criteria crit = session.createCriteria(Patient.class);
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("PFirstName", patientFName + "%"));
		}

		patientList = crit.list();
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdmissionDetails(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getAdmissionDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		int hospitalId = 0;
		int hinId = 0;
		if (dataMap.get("hinNo") != null) {
			hinNo = ("" + dataMap.get("hinNo"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		String hinIdMother = "";
		if (dataMap.get("hinIdMother") != null) {
			hinIdMother = (String) dataMap.get("hinIdMother");
		}
		if (dataMap.get("hinId") != null) {
			hinId = (Integer) dataMap.get("hinId");
		}

		Session session = getSession();
		String lastIpNo = "";
		if (!hinNo.equals("")) {
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("HinNo", hinNo)).list();
			for (Inpatient ip : inpatientList) {
				lastIpNo = "" + ip.getAdNo();
			}
		}

		String empCodeDoctor = null;
		String masChargeTypeIPADM = null;
		String masDepartmentTypeWard = null;
		String depTypeCodeDialysis = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("table_constant.properties");
		URL resourcePath1 = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			empCodeDoctor = prop.getProperty("mas_emp_category_doctor");
			masChargeTypeIPADM = prop.getProperty("mas_charge_type_IPADM");
			masDepartmentTypeWard = prop.getProperty("mas_department_type_ward");

			Properties propDia = new Properties();
			propDia.load(new FileInputStream(new File(resourcePath1.getFile())));
			depTypeCodeDialysis = propDia.getProperty("depTypeCodeDialysis");

		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}

		List<MasAuthorizer> authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		List<MasChargeCode> chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).createAlias("ChargeType", "chg")
				.add(Restrictions.eq("chg.ChargeTypeCode", masChargeTypeIPADM))

				.list();

		List<MasMaritalStatus> maritalStatusList = session.createCriteria(MasMaritalStatus.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();

		List<HospitalDoctorUnitM> hospitalUnitList = session.createCriteria(HospitalDoctorUnitM.class)
				.createAlias("EmpDept", "EmpDept").createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class, "msd")
				.createAlias("msd.Department", "md").createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh").add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", masDepartmentTypeWard.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();

		List<MasDepartment> departmentListForDialysis = session.createCriteria(MasInstituteDepartment.class, "msd")
				.createAlias("msd.Department", "md").createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh").add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", depTypeCodeDialysis.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();

		if (hinIdMother != null && !hinIdMother.equals("")) {
			List<Patient> patientMotherList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinIdMother)).list();
			map.put("patientMotherList", patientMotherList);
		}

		List<Object[]> employeeList = session
				.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase())
				.createAlias("EmpCategory", "EC")
				.add(Restrictions.eq("EC.Id", Integer.parseInt(empCodeDoctor.trim())))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.setProjection(
						Projections.projectionList().add(Projections.property("Id"))
								.add(Projections.property("FirstName")).add(Projections.property("MiddleName"))
								.add(Projections.property("LastName"))).addOrder(Order.asc("FirstName")).list();

		List<MasBloodGroup> bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		List<MasAdmissionType> admissionTypeList = session.createCriteria(MasAdmissionType.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		List<MasRelation> relationList = session.createCriteria(MasRelation.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		List<MasAdministrativeSex> sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		List<MasPatientCategory> patientCategoryList = session.createCriteria(MasPatientCategory.class, "patientType")
				.add(Restrictions.eq("patientType.Status", 'y').ignoreCase()).list();

		// added by amit das on 01-06-2016
		if (dataMap.get("patientList") != null) {
			List<OpdPatientDetails> opdPatientDetails = (List<OpdPatientDetails>) dataMap.get("patientList");
			int opdPatientDetailsId = opdPatientDetails.get(0).getId();
			Criteria criteriaForPayward = session.createCriteria(BlPaywardBooking.class)
					.createAlias("OpdPatientDetails", "opd").add(Restrictions.eq("opd.Id", opdPatientDetailsId));
			List<BlPaywardBooking> blPaywardBookings = criteriaForPayward.list();
			if (blPaywardBookings != null && blPaywardBookings.size() != 0) {
				for (int i = 0; i < departmentList.size(); i++) {
					if (departmentList.get(i).getPaywardCheck() != null
							&& departmentList.get(i).getPaywardCheck().equalsIgnoreCase("y")) {
						departmentList.remove(i);
					}
				}
			}

		}

		// adde by govind 29-8-2016
		List<MasDistrict> districtList = session.createCriteria(MasDistrict.class).addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", 32)).add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<PatientAddress> permenentAddList = session.createCriteria(PatientAddress.class)
				.add(Restrictions.eq("AddressType.Id", 1)).add(Restrictions.eq("Hin.Id", hinId)).list();

		int districtId = 0, lsgId = 0, wardId = 0;
		for (PatientAddress p : permenentAddList) {
			if (p.getDistrict() != null) {
				districtId = p.getDistrict().getId();
			}
			if (p.getLsgName() != null) {
				lsgId = p.getLsgName().getId();
			}
			if (p.getWardName() != null) {
				wardId = Integer.parseInt(p.getWardName());
			}
		}
		List<MasTaluk> talukList = session.createCriteria(MasTaluk.class).addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).add(Restrictions.eq("District.Id", districtId))
				.list();

		List<MasLsg> lsgNameList = session.createCriteria(MasLsg.class).addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).add(Restrictions.eq("District.Id", districtId))
				.list();

		List<MasPostCode> postCodeList = session.createCriteria(MasPostCode.class).addOrder(Order.asc("PostCodeName"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("DistrictId.Id", districtId))
				.list();

		List<MasWard> wardList = new ArrayList<MasWard>();
		if (lsgId != 0) {
			wardList = session.createCriteria(MasWard.class).createAlias("Lsg", "lsg").addOrder(Order.asc("WardName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).add(Restrictions.eq("lsg.Id", lsgId)).list();
		}

		List<PhMasLocality> localityList = new ArrayList<PhMasLocality>();
		if (wardId != 0) {
			localityList = session.createCriteria(PhMasLocality.class).addOrder(Order.asc("LocalityName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).add(Restrictions.eq("Ward.Id", wardId)).list();
		}

		// adde by govind 29-8-2016 end

		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);

		map.put("maritalStatusList", maritalStatusList);
		map.put("departmentList", departmentList);
		map.put("departmentListForDialysis", departmentListForDialysis);
		map.put("employeeList", employeeList);
		map.put("diagnosisList", new ArrayList<MasIcd>());
		map.put("admissionTypeList", admissionTypeList);
		map.put("relationList", relationList);
		map.put("sexList", sexList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("lastIpNo", lastIpNo);
		map.put("patientCategoryList", patientCategoryList);
		map.put("hospitalUnitList", hospitalUnitList);

		// added by govind 29-9-2016
		LOGGER.debug(" districtList " + districtList.size());
		LOGGER.debug(" talukList " + talukList.size());
		LOGGER.debug(" lsgNameList " + lsgNameList.size());
		LOGGER.debug(" wardList " + wardList.size());
		LOGGER.debug(" localityList " + localityList.size());
		LOGGER.debug(" postCodeList " + postCodeList.size());
		LOGGER.debug(" permenentAddList " + permenentAddList.size());
		map.put("districtList", districtList);
		map.put("talukList", talukList);
		map.put("lsgNameList", lsgNameList);
		map.put("wardList", wardList);
		map.put("localityList", localityList);
		map.put("postCodeList", postCodeList);
		map.put("permenentAddList", permenentAddList);
		// added by govind 29-9-2016 end

		return map;
	}

	@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
	public Map<String, Object> submitAdmissionInformation(final Map<String, Object> admissionMap) {

		LOGGER.info("Inside submitAdmissionInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForCentralServer = new HashMap<String, Object>();
		String admissionFlag = "false";
		Patient patient = null;
		Inpatient inpatient = null;
		String relativeName = "";
		String relativeAddress = "";
		String relativeMobile = "";
		int relativerelation = 0;
		String patientStatus = "";
		int bloodGroupId = 0;
		int hinId = 0;
		String ab64 = "";
		String adNo = "";
		int opdpatientdetailId = 0;
		int patientCategoryId = 0;
		int dialysisSchudelingId = 0;
		String toa = "";
		java.sql.Date doa = null;
		String oldAdmission = "no";
		int userId = 0;
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}

		List<MasUnit> unitList = new ArrayList<MasUnit>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		Transaction tx = null;
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException parseException) {
			LOGGER.error("Error while formatting the date " + parseException.getStackTrace().toString());
		}
		java.sql.Date currentDate = java.sql.Date.valueOf(date4MySQL);
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		try {
			tx = session.beginTransaction();
			String inpatientStatus = properties.getProperty("inpatientStatus");

			if (admissionMap.get("userId") != null) {
				userId = Integer.parseInt("" + admissionMap.get("userId"));
			}
			// Only for BAck date Admission
			if (admissionMap.get("doa") != null) {
				doa = java.sql.Date.valueOf("" + admissionMap.get("doa"));
			}
			if (admissionMap.get("toa") != null) {
				toa = (String) admissionMap.get("toa");
			}
			if (admissionMap.get("patient") != null) {
				patient = (Patient) admissionMap.get("patient");
			}
			if (admissionMap.get("inpatient") != null) {
				inpatient = (Inpatient) admissionMap.get("inpatient");
			}
			if (admissionMap.get("patientMap") != null) {
				patientMap = (Map) admissionMap.get("patientMap");
			}
			if (admissionMap.get("hinId") != null) {
				hinId = (Integer) admissionMap.get("hinId");
			}
			if (admissionMap.get("dialysisSchudelingId") != null) {
				dialysisSchudelingId = (Integer) admissionMap.get("dialysisSchudelingId");
			}

			if (admissionMap.get("admittingDoctorId") != null) {
				int admittingDoctorId = (Integer) admissionMap.get("admittingDoctorId");
				if (admittingDoctorId > 0) {
					MasEmployee employee = new MasEmployee();
					employee.setId(admittingDoctorId);
					inpatient.setAdmittingDoctor(employee);
				}
			}
			if (admissionMap.get("admittingDeptId") != null) {
				int admittingDeptId = (Integer) admissionMap.get("admittingDeptId");
				if (admittingDeptId > 0) {
					MasDepartment department = new MasDepartment();
					department.setId(admittingDeptId);
					inpatient.setAdmittingDepartmet(department);
				}

			}
			String patient_income = "";
			if (admissionMap.get("patient_income") != null) {
				patient_income = (String) admissionMap.get("patient_income");
			}

			if (patientMap.get(RELATIVE_NAME) != null) {
				relativeName = (String) patientMap.get(RELATIVE_NAME);
			}
			if (patientMap.get(ADDRESS) != null) {
				relativeAddress = (String) patientMap.get(ADDRESS);
			}
			if (patientMap.get(MOBILE) != null) {
				relativeMobile = (String) patientMap.get(MOBILE);
			}
			if (patientMap.get("patientStatus") != null) {
				patientStatus = (String) patientMap.get("patientStatus");
			}
			if (patientMap.get("ab64") != null) {
				ab64 = (String) patientMap.get("ab64");
			}
			if (patientMap.get("opdpatientdetailId") != null) {
				opdpatientdetailId = (Integer) patientMap.get("opdpatientdetailId");
				if (opdpatientdetailId != 0) {
					OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
					opdPatientDetails.setId(opdpatientdetailId);
					inpatient.setOpdPatientDetails(opdPatientDetails);

					// added by govind 22-12-2016
					OpdPatientDetails opdPat = hbt.load(OpdPatientDetails.class, opdpatientdetailId);
					LOGGER.info("AdmissionAdvised " + opdPat.getAdmissionAdvised());
					opdPat.setAdmissionAdvised("n");
					hbt.update(opdPat);
					// added by govind 22-12-2016 end
				}
			}
			if (patientMap.get("patientCategoryId") != null) {
				patientCategoryId = (Integer) patientMap.get("patientCategoryId");
				MasPatientCategory patientCategory = new MasPatientCategory();
				patientCategory.setId(patientCategoryId);
				inpatient.setPatientCategory(patientCategory);
			}
			if (!relativeName.equals("")) {
				inpatient.setDependentName(relativeName);
			}
			if (!relativeAddress.equals("")) {
				inpatient.setAddress(relativeAddress);
			}
			if (!relativeMobile.equals("")) {
				inpatient.setContactNo(relativeMobile);
			}
			if (patientMap.get(RELATION_ID) != null) {
				relativerelation = (Integer) patientMap.get(RELATION_ID);
				MasRelation masRelation = new MasRelation();
				masRelation.setId(relativerelation);
				inpatient.setRelation(masRelation);
			}
			if (admissionMap.get("adNo") != null) {
				adNo = (String) admissionMap.get("adNo");
			}
			if (admissionMap.get("oldAdmission") != null) {
				oldAdmission = "" + admissionMap.get("oldAdmission");
			}

			if (oldAdmission.equals("yes")) {
				inpatient.setDateOfAddmission(doa);
				inpatient.setTimeOfAddmission(toa);
				inpatient.setListDate(doa);
				inpatient.setAddEditTime(toa);
				inpatient.setAddEditDate(doa);
				inpatient.setListTime(toa);
			} else {
				inpatient.setDateOfAddmission(currentDate);
				inpatient.setTimeOfAddmission(currentTime);
				inpatient.setListDate(currentDate);
				inpatient.setAddEditTime(currentTime);
				inpatient.setAddEditDate(currentDate);
				inpatient.setListTime(currentTime);
			}
			hbt.save(inpatient);

			hbt.refresh(inpatient);
			mapForCentralServer.put("inpatient", inpatient);
			if (dialysisSchudelingId != 0) {
				DialysisSchudeling dialysisSchudeling = hbt.load(DialysisSchudeling.class, dialysisSchudelingId);
				dialysisSchudeling.setRegisteredStatus("A");
				hbt.update(dialysisSchudeling);
			}

			// added by govind by 29-8-2016
			int perAddId = 0;
			if (admissionMap.get("permenentAddress") != null) {

				if (admissionMap.get("perAddId") != null) {
					perAddId = (Integer) admissionMap.get("perAddId");
					LOGGER.info(" perAddId impl" + perAddId);
				}
				org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
				hbt1.setFlushModeName("FLUSH_EAGER");

				PatientAddress patientAddress = (PatientAddress) admissionMap.get("permenentAddress");
				PatientAddress op = hbt1.load(PatientAddress.class, perAddId);
				if (op != null && null != patientAddress) {
					if (null != patientAddress.getDistrict()) {
						op.setDistrict(patientAddress.getDistrict());
					}

					if (null != patientAddress.getTaluk()) {
						op.setTaluk(patientAddress.getTaluk());
					}

					if (null != patientAddress.getLsgName()) {
						op.setLsgName(patientAddress.getLsgName());
					}

					if (null != patientAddress.getWardNo()) {
						op.setWardNo(patientAddress.getWardNo());
					}

					if (null != patientAddress.getLocality()) {
						op.setLocality(patientAddress.getLocality());
					}

					if (null != patientAddress.getLsgHouseNo()) {
						op.setLsgHouseNo(patientAddress.getLsgHouseNo());
					}

					if (null != patientAddress.getPostOffice()) {
						op.setPostOffice(patientAddress.getPostOffice());
					}

					if (null != patientAddress.getPinCode()) {
						op.setPinCode(patientAddress.getPinCode());
					}

					if (null != patientAddress.getHealthHouseId()) {
						op.setHealthHouseId(patientAddress.getHealthHouseId());
					}
					hbt1.update(op);
				}
			}

			// added by govind by 29-8-2016 end

			// --------------------Start Storing multiple Diagnosis-------------
			String query = "";
			List objectList = new ArrayList();
			int icdId = 0;

			// -----------------------------------End Storing multiple Diagnosis
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();

			Patient patientObj = hbt.load(Patient.class, hinId);

			if (!patientStatus.equals("")) {
				patientObj.setPatientStatus(patientStatus);
			} else {
				patientObj.setPatientStatus(inpatientStatus);
			}
			String bplStatus = "";
			int patientTypeId = 0;
			String[] otherCategoryId = null;
			if (patientMap.get("bplStatus") != null) {
				bplStatus = (String) patientMap.get("bplStatus");
			}

			if (patientMap.get("patientTypeId") != null) {
				patientTypeId = (Integer) patientMap.get("patientTypeId");
			}

			if (patientMap.get("otherCategoryId") != null) {
				otherCategoryId = (String[]) patientMap.get("otherCategoryId");
			}

			if (bplStatus.equalsIgnoreCase("bpl")) {
				patientObj.setBplStatus("y");
			} else {
				patientObj.setBplStatus("n");
			}

			if (patientTypeId != 0) {
				MasPatientType masPatientType = new MasPatientType();
				masPatientType.setId(patientTypeId);
				patientObj.setPatientType(masPatientType);
			}

			if (patient_income != null && !patient_income.equals("")) {
				patientObj.setMonthlyIncome(new BigDecimal(patient_income));
			}

			patientObj.setAb64Available(ab64);

			int unitId = 0;
			hbt.update(patientObj);
			Patient ptntObj = hbt.load(Patient.class, hinId);
			BigDecimal pastDue = new BigDecimal(0);
			if (ptntObj.getPastDue() != null && !ptntObj.getPastDue().equals("")) {
				pastDue = new BigDecimal(ptntObj.getPastDue());
			}

			ptntObj.setPastDue(pastDue.toString());
			hbt.update(ptntObj);
			mapForCentralServer.put("patient", ptntObj);
			admissionFlag = "true";
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.debug("Exception Occurred : " + e.getStackTrace().toString());
		}
		MasHospital hospital = null;
		if (admissionMap.get("hospitalId") != null) {
			hospital = (MasHospital) session.get(MasHospital.class,
					Integer.parseInt(admissionMap.get("hospitalId").toString()));
		}
		if (hospital != null) {
			mapForCentralServer.put("hospital", hospital);
			hl7MessageForIpAdmission(mapForCentralServer);
		}
		map.put("admissionFlag", admissionFlag);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public String getMotherName(final String motherAdNo) {

		LOGGER.debug("Inside getMotherName ");
		Session session = getSession();
		boolean flag = false;
		String name = "";
		List<Inpatient> motherAdList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", motherAdNo))
				.list();
		for (Inpatient inpatient : motherAdList) {
			Patient patient = inpatient.getHin();
			String middleName = "";
			String lastName = "";
			if (patient.getPMiddleName() != null) {
				middleName = patient.getPMiddleName();
			}
			if (patient.getPLastName() != null) {
				lastName = patient.getPLastName();
			}
			name = patient.getPFirstName() + " " + middleName + " " + lastName;
		}
		return name;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeAndRelation(final Map<String, Object> parameterMap) {

		LOGGER.debug("Inside getServiceTypeAndRelation ");
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		Map<String, Object> map = new HashMap<String, Object>();

		int relationId = 0;
		int serviceTypeId = 0;
		int serviceStatusId = 0;

		if (parameterMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) parameterMap.get("serviceTypeId");
		}
		if (parameterMap.get("serviceStatusId") != null) {
			serviceStatusId = (Integer) parameterMap.get("serviceStatusId");
		}
		if (parameterMap.get("relationId") != null) {
			relationId = (Integer) parameterMap.get("relationId");
		}

		Session session = getSession();

		List<MasServiceType> list = session.createCriteria(MasServiceType.class).add(Restrictions.idEq(serviceTypeId))
				.list();
		serviceTypeList = list;
		String serviceTypeCode = "";
		for (MasServiceType masServiceType : serviceTypeList) {
			serviceTypeCode = masServiceType.getServiceTypeCode();
			map.put("serviceTypeCode", serviceTypeCode);
		}
		List<MasRelation> relationList = session.createCriteria(MasRelation.class).add(Restrictions.idEq(relationId))
				.list();
		String relationCode = "";
		for (MasRelation masRelation : relationList) {
			relationCode = masRelation.getRelationCode();
			map.put("relationCode", relationCode);
		}
		List<MasServiceStatus> serviceStatusList = session.createCriteria(MasServiceStatus.class)
				.add(Restrictions.idEq(serviceStatusId)).list();
		String serviceStatusCode = "";
		for (MasServiceStatus masServiceStatus : serviceStatusList) {
			serviceStatusCode = masServiceStatus.getServiceStatusCode();
			map.put("serviceStatusCode", serviceStatusCode);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getHinId(final String serviceNo, final int serviceTypeId) {

		LOGGER.debug("Inside getHinId ");
		Session session = getSession();
		String previousHinNo = "";
		String maxSequenceNo = "";
		List<Patient> previousHinNoList = new ArrayList<Patient>();
		if (!serviceNo.equals("0") && serviceNo != null) {
			previousHinNoList = session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo))
					.list();
		} else {
			previousHinNoList = session.createCriteria(Patient.class).list();
		}
		if (previousHinNoList.size() > 0) {

			ArrayList<String> hinNoSequenceList = new ArrayList<String>();
			for (Patient patient : previousHinNoList) {
				if (patient.getServiceType().getId() == serviceTypeId) {
					previousHinNo = patient.getHinNo();
					int length = previousHinNo.length() - 2;
					String sequenceNo = previousHinNo.substring(length, previousHinNo.length());
					// int i = Integer.parseInt(sequenceNo);
					hinNoSequenceList.add(sequenceNo);
				}
			}

			if (hinNoSequenceList.size() > 0) {
				maxSequenceNo = Collections.max(hinNoSequenceList).toString();
			}
		}
		return maxSequenceNo;
	}

	public String getHinNo(final int serviceTypeId, final int relationId, final int serviceStatusId,
			final String serviceNo) {

		LOGGER.debug("Inside getHinNo ");
		Map<String, Object> map = new HashMap<String, Object>();

		String hinNo = "";
		Map<String, Object> serviceAndRelationMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);
		serviceAndRelationMap = getServiceTypeAndRelation(parameterMap);
		String relationCode = (String) serviceAndRelationMap.get("relationCode");
		String serviceTypeCode = (String) serviceAndRelationMap.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap.get("serviceStatusCode");
		String maxSequenceNo = getHinId(serviceNo, serviceTypeId);
		Integer i;
		if (!maxSequenceNo.equals("")) {
			i = Integer.parseInt(maxSequenceNo) + 1;
		} else {
			i = 01;
		}
		String seqNo = "";
		if (i <= 9) {
			seqNo = "0" + i.toString();
		} else {
			seqNo = i.toString();
		}
		if (!serviceNo.equals("0")) {
			hinNo = serviceTypeCode.concat(serviceStatusCode).concat(serviceNo).concat(relationCode)
					.concat(seqNo.toString());
		} else {
			hinNo = serviceTypeCode.concat(seqNo.toString());
		}

		String message = hinNo;
		map.put("message", message);
		return hinNo;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> saveAttachedAdmission(final Map<String, Object> attachMap) {

		LOGGER.debug("Inside saveAttachedAdmission ");
		Map<String, Object> adMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String attachFlag = "false";
		int dietId = 0;
		int sexId = 0;
		int wardId = 0;
		int hinId = 0;
		int bedId = 0;
		String age = "";
		String attachName = "";
		int hospitalId = 0;
		int deptId = 0;
		String andNo = "";
		String atOrDt = "";
		int serviceTypeId = 0;
		int relationId = Integer.parseInt("" + attachMap.get("relationId"));
		int opdpatientdetailId = (Integer) attachMap.get("opdpatientdetailId");
		Box box = (Box) attachMap.get("box");
		String parentAdNo = "" + box.get("parentAdNo");
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}
		Session session = getSession();
		List<Inpatient> inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("AdNo", parentAdNo)).list();
		Inpatient inpatient2 = inpatientList.get(0);
		int bedStatusOccupiedId = Integer.parseInt(properties.getProperty("bedStatusOccupiedId"));
		String inpatientStatus = (properties.getProperty("inpatientStatus"));
		if (attachMap.get("attachName") != null) {
			attachName = (String) attachMap.get("attachName");
		}
		if (attachMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + attachMap.get("deptId"));
		}
		if (attachMap.get("sexId") != null) {
			sexId = Integer.parseInt("" + attachMap.get("sexId"));
		}
		if (attachMap.get("age") != null) {
			age = ("" + attachMap.get("age"));
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = "";
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException parseException) {
			LOGGER.error("Error while formatting date" + parseException.getStackTrace().toString());
		}

		try {
			Date lastChgDate = java.sql.Date.valueOf(date4MySQL);
			if (attachMap.get("dietId") != null) {
				dietId = (Integer) attachMap.get("dietId");
				MasDiet masDiet = new MasDiet();
				masDiet.setId(dietId);
			}
			if (attachMap.get("sexId") != null) {
				sexId = (Integer) attachMap.get("sexId");
				MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
				masAdministrativeSex.setId(sexId);
			}

			if (attachMap.get("hinId") != null) {
				hinId = (Integer) attachMap.get("hinId");
				Patient patient3 = new Patient();
				patient3.setId(hinId);
			}
			//
			Patient patient = hbt.load(Patient.class, hinId);
			adMap.put("date", date);
			andNo = generateAdNumber(adMap);
			if (attachMap.get("bedId") != null) {

				bedId = (Integer) attachMap.get("bedId");
				MasBed masBed = hbt.load(MasBed.class, bedId);
				MasBedStatus bedStatus = new MasBedStatus();
				bedStatus.setId(bedStatusOccupiedId);
				masBed.setBedStatus(bedStatus);
				hbt.update(masBed);
			}
			Patient patient2 = new Patient();
			String newHinNo = "";

			MasHospital hospital = new MasHospital();
			hospitalId = Integer.parseInt("" + patient.getHospital().getId());
			hospital.setId(patient.getHospital().getId());
			patient2.setHospital(hospital);

			if (patient.getTitle() != null) {
				MasTitle title = new MasTitle();
				title.setId(patient.getTitle().getId());
				patient2.setTitle(title);
			}
			patient2.setPFirstName(attachName.toUpperCase(Locale.ENGLISH));
			patient2.setPMiddleName("");
			patient2.setPLastName("");

			MasAdministrativeSex sex = new MasAdministrativeSex();
			sex.setId(sexId);
			patient2.setSex(sex);
			String dob = "";
			String ageForDependent = age;
			String[] ageArr = age.split(" ");
			if (ageArr[1] != null) {
				int ageTemp = 0;
				if (ageArr[0] != null) {
					ageTemp = Integer.parseInt(ageArr[0]);
				} else {
					ageTemp = 1;
				}
				if (ageArr[1].equalsIgnoreCase("Years")) {
					dob = HMSUtil.getPrevDate(ageTemp * 365);
				} else if (ageArr[1].equalsIgnoreCase("Months")) {
					dob = HMSUtil.getPrevDate(ageTemp * 30);
				} else if (ageArr[1].equalsIgnoreCase("Days")) {
					dob = HMSUtil.getPrevDate(ageTemp);
				}
			}

			patient2.setCardValidDate(patient.getCardValidDate());
			patient2.setRegistrationType(patient.getRegistrationType());

			if (patient.getReligion() != null) {
				patient2.setReligion(patient.getReligion());
			}
			if (patient.getReligion() != null) {
				patient2.setReligion(patient.getReligion());
			}
			if (dob != "") {
				patient2.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(dob));
			}
			patient2.setBillNo(0);
			patient2.setPastDue("0");
			patient2.setBplStatus(patient.getBplStatus());
			patient2.setMaritalStatus(null);

			int tsn = 0;
			int id = 0;
			

			List<TransactionSequence> adList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "HIN")).list();
			for (TransactionSequence transactionSequence : adList) {
				tsn = Integer.parseInt("" + transactionSequence.getTransactionSequenceNumber());
				id = transactionSequence.getId();
			}
			TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
			newHinNo = "" + (tsn + 1);
			hbt.saveOrUpdate(transactionSequenceObj);

			// End

			patient2.setHinNo(newHinNo);
			/*
			 * Code for patient type
			 */

			MasPatientType masPatientType = new MasPatientType();
			masPatientType.setId(patient.getPatientType().getId());
			patient2.setPatientType(masPatientType);

			MasReligion religion = new MasReligion();
			religion.setId(patient.getReligion().getId());
			patient2.setReligion(religion);

			MasDistrict district = new MasDistrict();
			district.setId(patient.getDistrict().getId());
			patient2.setDistrict(district);

			MasState state = new MasState();
			state.setId(patient.getState().getId());
			patient2.setState(state);

			MasCountry country = new MasCountry();
			country.setId(patient.getCountry().getId());
			patient2.setCountry(country);

			if (patient.getReference() != null) {
				MasReference reference = new MasReference();
				reference.setId(patient.getReference().getId());
				patient2.setReference(reference);
			}

			patient2.setCurrentVisitNo(patient.getCurrentVisitNo());
			patient2.setInpatientNo(patient.getInpatientNo());
			patient2.setEmailId(patient.getEmailId());

			if (patient.getOccupation() != null) {
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(patient.getOccupation().getId());
				patient2.setOccupation(masOccupation);
			}

			patient2.setPhoneNumber(patient.getPhoneNumber());
			patient2.setMobileNumber(patient.getMobileNumber());
			patient2.setNextOfKinName(patient.getNextOfKinName());
			patient2.setNextOfKinAddress(patient.getNextOfKinAddress());
			patient2.setNextOfKinPhoneNumber(patient.getNextOfKinPhoneNumber());
			patient2.setNextOfKinMobileNumber(patient.getNextOfKinMobileNumber());

			if (patient.getNextOfKinRelation() != null) {
				MasRelation relation2 = new MasRelation();
				relation2.setId(patient.getNextOfKinRelation().getId());
				patient2.setNextOfKinRelation(relation2);
			}
			patient2.setRemarks(patient.getRemarks());
			if (patient.getAddEditBy() != null) {
				Users users = new Users();
				users.setId(patient.getAddEditBy().getId());
				patient2.setAddEditBy(users);
			}

			patient2.setAddEditDate(patient.getAddEditDate());
			patient2.setAddEditTime(patient.getAddEditTime());
			patient2.setPatientStatus(inpatientStatus);
			patient2.setStatus(patient.getStatus());
			patient2.setMotherHinNo(patient.getMotherHinNo());
			// commented for maven
			patient2.setRegDate(patient.getRegDate());
			patient2.setRegTime(patient.getRegTime());
			patient2.setOldHinNo("");
			patient2.setAge(ageForDependent);
			hbt.save(patient2);
			hbt.refresh(patient2);

			Inpatient inpatient = new Inpatient();
			inpatient.setHin(patient2);

			MasHospital hospital2 = new MasHospital();
			hospital2.setId(hospitalId);
			inpatient.setHospital(hospital2);
			inpatient.setAdNo(andNo);
			MasDepartment department = new MasDepartment();
			department.setId(box.getInt(DEPARTMENT_ID));
			inpatient.setDepartment(department);
			MasDepartment department2 = new MasDepartment();
			department2.setId(box.getInt(DEPARTMENT_ID));
			inpatient.setAdWard(department2);
			inpatient.setAge(age);

			//
			// --This block is for checking vacency of bed
			// --If bed is not available,then record will not be saved
			MasBed bed = new MasBed();
			bed.setId(bedId);
			inpatient.setBed(bed);

			inpatient.setDateOfAddmission(lastChgDate);
			inpatient.setTimeOfAddmission(time);
			inpatient.setDietType(box.get(DIET_TYPE));
			MasDiet diet = new MasDiet();
			diet.setId(box.getInt(DIET_ID));
			inpatient.setDiet(diet);
			inpatient.setMlc("n");
			inpatient.setAdStatus("A");
			inpatient.setStatus("y");
			inpatient.setPatientCondition("Normal");
			inpatient.setConditionStatus("Normal");
			inpatient.setHinNo(newHinNo);
			inpatient.setParentAdNo(parentAdNo);
			inpatient.setAttachedPatient("y");
			inpatient.setInitDiagnosis("" + attachMap.get("atOrDt"));
			if (inpatient2.getDoctor() != null) {
				MasEmployee doctor = new MasEmployee();
				doctor.setId(inpatient2.getDoctor().getId());
				inpatient.setDoctor(doctor);
				inpatient.setAtOrDt("" + attachMap.get("atOrDt"));
			}
			if (attachMap.get("hsrReceiptNo") != null) {
				inpatient.setHsrReceiptNo("" + attachMap.get("hsrReceiptNo"));
			}
			inpatient.setAdNoType("a");
			hbt.save(inpatient);
			hbt.refresh(inpatient);
			attachFlag = "true";
		} catch (Exception e) {
			LOGGER.error("Exception Occurred " + e.getStackTrace().toString());
		}
		//
		map.put("adNo", andNo);
		map.put("attachFlag", attachFlag);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForMLC(final int hospitalId) {

		LOGGER.debug("Inside getDetailsForMLC ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();

		List<MasEmployee> employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		List<MasDiet> bodyPartList = session.createCriteria(MasBodyPart.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasInjuryNature> injuryNatureList = session.createCriteria(MasInjuryNature.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasDiagnosisConclusion> diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		List<MasDepartment> departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		map.put("employeeList", employeeList);
		map.put("bodyPartList", bodyPartList);
		map.put("injuryNatureList", injuryNatureList);
		map.put("diagnosisList", diagnosisList);
		map.put("departmentList", departmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitMLCDetails(final Map<String, Object> mlcDetailsMap) {

		LOGGER.debug("Inside submitMLCDetails ");
		MlcCase mlcCaseObj = null;
		boolean mlcFlag = false;
		int hinId = 0;
		int injuryNatureId = 0;
		int doctorId = 0;
		int bodyPartId = 0;
		String adNo = "";

		if (mlcDetailsMap.get("mlcCase") != null) {
			mlcCaseObj = (MlcCase) mlcDetailsMap.get("mlcCase");
		}

		if (mlcDetailsMap.get("adNo") != null) {
			adNo = (String) mlcDetailsMap.get("adNo");
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (mlcDetailsMap.get("hinId") != null) {
			hinId = (Integer) mlcDetailsMap.get("hinId");
			Patient patient = new Patient();
			patient.setId(hinId);
			mlcCaseObj.setHin(patient);
		}
		if (mlcDetailsMap.get("injuryNatureId") != null) {
			injuryNatureId = (Integer) mlcDetailsMap.get("injuryNatureId");
			MasInjuryNature masInjuryNature = new MasInjuryNature();
			masInjuryNature.setId(injuryNatureId);
			mlcCaseObj.setInjuryNature(masInjuryNature);
		}
		if (mlcDetailsMap.get("doctorId") != null) {
			doctorId = (Integer) mlcDetailsMap.get("doctorId");
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(doctorId);
			mlcCaseObj.setDoctor(masEmployee);
		}
		if (mlcDetailsMap.get("bodyPartId") != null) {
			bodyPartId = (Integer) mlcDetailsMap.get("bodyPartId");
			MasBodyPart masBodyPart = new MasBodyPart();
			masBodyPart.setId(bodyPartId);
			mlcCaseObj.setBodyPart(masBodyPart);
		}
		hbt.save(mlcCaseObj);
		mlcFlag = true;
		if (mlcFlag == true) {
			Session session = getSession();
			List<Inpatient> adNoList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo))
					.list();
			if (adNoList.size() > 0) {
				Inpatient inpatientObj = adNoList.get(0);
				inpatientObj.setMlc("y");
				hbt.update(inpatientObj);
			}
		}
		return mlcFlag;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public String generateAdNumber(final Map<String, Object> adMap) {

		LOGGER.debug("Inside generateAdNumber ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int hospitalId = (Integer) adMap.get("hospitalId");
		List<TransactionSequence> adListd = new ArrayList<TransactionSequence>();
		int tsn = 0;
		int id = 0;
		String adNo = "";
		Date lastChangedate = null;
		Date currentDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String curDate = sdf.format(date);
		try {
			currentDate = sdf.parse(curDate);
		} catch (ParseException parseException) {
			LOGGER.error("Error while parsing date " + parseException.getStackTrace().toString());
		}
		Session session = getSession();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = HMSUtil.getCurrentDateAndTime();
		String time = (String) utilMap.get("currentTime");
		List<Object[]> adList = session
				.createCriteria(TransactionSequence.class)
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("TransactionPrefix", "AD".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.setProjection(
						Projections.projectionList().add(Projections.property("TransactionSequenceNumber"))
								.add(Projections.property("LastChgDate")).add(Projections.property("Id"))).list();
		if (adList.size() > 0) {
			Object[] transactionSequence = adList.get(0);
			tsn = Integer.parseInt("" + transactionSequence[0]);
			id = (Integer) transactionSequence[2];
			lastChangedate = (Date) transactionSequence[1];

		} else {
			TransactionSequence transactionSequenceObj1 = new TransactionSequence();
			tsn = 0;
			transactionSequenceObj1.setTransactionSequenceNumber(tsn + 1);
			transactionSequenceObj1.setLastChgDate(date);
			transactionSequenceObj1.setTransactionSequenceName("Admission No");
			transactionSequenceObj1.setTransactionPrefix("AD");
			transactionSequenceObj1.setTablename("Patient");
			transactionSequenceObj1.setCreatedby("admin");
			transactionSequenceObj1.setStatus("Y");
			MasHospital hosp = new MasHospital();
			hosp.setId(hospitalId);
			transactionSequenceObj1.setHospital(hosp);
			transactionSequenceObj1.setLastChgTime(time);
			hbt.save(transactionSequenceObj1);
		}
		int yearlast = lastChangedate.getYear();
		int currentlast = currentDate.getYear();

		if (yearlast != currentlast) {

			tsn = 0;
			TransactionSequence transactionSequenceObj = (TransactionSequence) session.load(TransactionSequence.class,
					id);
			transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
			transactionSequenceObj.setLastChgDate(date);
			hbt.update(transactionSequenceObj);

		} else {
			if (id > 0) {
				TransactionSequence transactionSequenceObj = (TransactionSequence) session.load(
						TransactionSequence.class, id);
				tsn = transactionSequenceObj.getTransactionSequenceNumber();
				transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
				transactionSequenceObj.setLastChgDate(currentDate);
				hbt.update(transactionSequenceObj);
			}
		}
		adNo = "" + (tsn + 1);
		return adNo;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public String generateMLCNo(final Map<String, Object> adMap) {

		LOGGER.debug("Inside generateMLCNo ");
		String date = (String) adMap.get("date");
		Session session = getSession();
		String mlcNo = "";

		List<TransactionSequence> mlcList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MLC")).list();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (mlcList.size() > 0) {
			for (TransactionSequence transactionSequence : mlcList) {
				TransactionSequence obj = mlcList.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				mlcNo = mlcNo.concat(String.valueOf(seqNo)).concat("/");
				date = date.substring(3, date.length());
				mlcNo = mlcNo.concat(date);
			}
		} else if (mlcList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("MlcCase");
			tsObj.setTransactionPrefix("MLC");
			tsObj.setTransactionSequenceName("MLC No");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return mlcNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTransferDetails(final int hospitalId, final int deptId, final int inpatientId) {

		LOGGER.debug("Inside getTransferDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasBed> bedList = new ArrayList<MasBed>();

		String mas_department_type_ward = null;
		int emp_type_id = 0;
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mas_department_type_ward = prop.getProperty("mas_department_type_ward");
			emp_type_id = Integer.parseInt(prop.getProperty("emp_type_id"));
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}

		Session session = getSession();
		List<Transfer> transferListForDuplicate = session.createCriteria(Transfer.class, "transfer")
				.createAlias("Hospital", "h").createAlias("Inpatient", "ip").add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.eq("ip.Id", inpatientId)).add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.in("RequestStatus", new String[] { "p" })).list();

		List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class, "msd")
				.createAlias("msd.Department", "md").createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh").add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "Y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();

		List<Transfer> transferNoList = session.createCriteria(Transfer.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.desc("Id")).setMaxResults(1).list();

		// Added by Dhananjay 08-march-2017
		List<MasEmployee> employeeList = session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital")
				.createAlias("EmpCategory", "EmpCategory").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("EmployeeType.Id", emp_type_id)).list();

		// End
		List<MasAuthorizer> authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();

		map.put("departmentList", departmentList);
		map.put("bedList", bedList);
		map.put("transferNoList", transferNoList);
		map.put("employeeList", employeeList);
		map.put("authorizerList", authorizerList);
		map.put("transferListForDuplicate", transferListForDuplicate);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForTransfer(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getPatientDetailsForTransfer ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		int wardId = 0;
		int inpatientId = 0;
		int hospitalId = 0;
		if (mapForDs.get(DEPT_ID) != null) {
			wardId = (Integer) mapForDs.get(DEPT_ID);
		}
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}

		List<String> objectList = new ArrayList<String>();
		objectList.add("A");
		Criteria crit = session.createCriteria(Inpatient.class).createAlias("Hospital", "h")
				.createAlias("Department", "d").add(Restrictions.eq("Id", inpatientId))
				.add(Restrictions.in("AdStatus", objectList)).add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.eq("d.Id", wardId));

		List<Transfer> transferList = session.createCriteria(Transfer.class, "transfer")
				.createAlias("transfer.FromWard", "d").createAlias("Hospital", "h")
				.createAlias("Inpatient", "inPatient")
				.add(Restrictions.eq("d.Id", wardId)).add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.in("RequestStatus", new String[] { "p", "r" }))
				.add(Restrictions.eq("inPatient.AdStatus", "A"))
				.list();

		List<Inpatient> inPatientList = crit.list();
		map.put("inpatientList", inPatientList);
		map.put("transferList", transferList);

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean patientTransferCalucation(final Map<String, Object> transferCalucationMap) {

		LOGGER.debug("Inside patientTransferCalucation ");
		BigDecimal totalChargeAmount = new BigDecimal(0);
		BigDecimal totalDiscAmt = new BigDecimal(0);
		BigDecimal totalNetAmount = new BigDecimal(0);
		BigDecimal totalNetAmountNew = new BigDecimal(0);
		BigDecimal chargeIdNew = new BigDecimal(0);
		BigDecimal discountPercent = new BigDecimal(0.00);
		BigDecimal stdDeduction = new BigDecimal(0.00);
		BigDecimal rate = new BigDecimal(0.00);
		Boolean transferedCalucationSuccess = false;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> chargeDtMap = new HashMap<String, Object>();
		Criteria crit = null;
		Criteria roomcrit = null;
		Session session = getSession();
		Transaction transaction = null;

		Integer roomTypeId = 0;
		Integer lastChargeSlipDeptId = 0;
		int inpatientDeptId = 0;
		String adNo = (String) transferCalucationMap.get("adNo");
		Integer hinId = (Integer) transferCalucationMap.get("hinId");
		Integer toWardId = (Integer) transferCalucationMap.get("toWardId");
		Integer inpatientID = (Integer) transferCalucationMap.get("inpatientID");
		try {
			transaction = session.beginTransaction();

			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("lastProcessedDate", new Date());
			dataMap.put("userId", 1);
			dataMap.put("session", session);
			dataMap.put("userName", "admin");
			dataMap.put("hinId", hinId);

			crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo));
			if (!hinId.equals("")) {
				crit = crit.createAlias("Hin", "p").add(Restrictions.eq("p.Id", hinId));
			}
			List<Inpatient> finalBillInpatient = crit.list();

			if (finalBillInpatient.size() > 0 && finalBillInpatient != null) {
				inpatientDeptId = finalBillInpatient.get(0).getDepartment().getId();

				List<BlChargeSlipMain> blchargeSetupList = session.createCriteria(BlChargeSlipMain.class)
						.createAlias("Hin", "hn").createAlias("Inpatient", "Inp").add(Restrictions.eq("hn.Id", hinId))
						.add(Restrictions.eq("Inp.Id", inpatientID)).add(Restrictions.eq("RoomProcessed", "y"))
						.add(Restrictions.eq("ChgSlpDate", new Date())).addOrder(Order.desc("Id")).setMaxResults(1)
						.list();

				if (blchargeSetupList.size() > 0) {
					Integer id = blchargeSetupList.get(0).getId();
					List<BlChargeSlipDetail> chargeSlipDetail = new ArrayList<BlChargeSlipDetail>();

					chargeSlipDetail = session.createCriteria(BlChargeSlipDetail.class)
							.add(Restrictions.eq("ChargeSlipMain.Id", id)).list();

					if (chargeSlipDetail.size() > 0) {
						lastChargeSlipDeptId = chargeSlipDetail.get(0).getDepartment().getId();
					}

					if (lastChargeSlipDeptId != inpatientDeptId) {
						if (finalBillInpatient.get(0).getHin().getCompany() != null) {
							detailsMap.put("companyId", finalBillInpatient.get(0).getHin().getCompany().getId());
						}

						detailsMap.put("patientTypeId", finalBillInpatient.get(0).getHin().getPatientType().getId());
						detailsMap.put("regType", finalBillInpatient.get(0).getHin().getRegistrationType());
						detailsMap.put("billTypeId", 2);
						detailsMap.put("patientCategory", "IP");
						detailsMap
								.put("roomTypeId", finalBillInpatient.get(0).getBed().getRoom().getRoomType().getId());
						detailsMap.put("session", session);

						chargeDtMap = pateintRoomRentCharge(detailsMap);

						if (chargeDtMap.get("totalChargeAmount") != null) {
							totalChargeAmount = (BigDecimal) chargeDtMap.get("totalChargeAmount");
						}

						if (chargeDtMap.get("totalDiscAmt") != null) {
							totalDiscAmt = (BigDecimal) chargeDtMap.get("totalDiscAmt");
						}

						if (chargeDtMap.get("totalNetAmount") != null) {
							totalNetAmount = (BigDecimal) chargeDtMap.get("totalNetAmount");
						}

						if (chargeDtMap.get("chargeId") != null) {
							chargeIdNew = (BigDecimal) chargeDtMap.get("chargeId");
						}

						if (chargeDtMap.get("stdDeduction") != null) {
							stdDeduction = (BigDecimal) chargeDtMap.get("stdDeduction");
						}

						if (chargeDtMap.get("rate") != null) {
							rate = (BigDecimal) chargeDtMap.get("rate");
						}

						if (chargeDtMap.get("discountPercent") != null) {
							discountPercent = (BigDecimal) chargeDtMap.get("discountPercent");
						}

						detailsMap = new HashMap<String, Object>();
						chargeDtMap = new HashMap<String, Object>();

						roomcrit = session.createCriteria(MasRoom.class).createAlias("Department", "dept")
								.add(Restrictions.eq("dept.Id", toWardId));

						List<MasRoom> roomTransferInpatient = roomcrit.list();

						if (roomTransferInpatient.size() > 0 && roomTransferInpatient != null) {
							roomTypeId = roomTransferInpatient.get(0).getRoomType().getId();
							detailsMap.put("roomTypeId", roomTypeId);
						}

						if (finalBillInpatient.get(0).getHin().getCompany() != null) {
							detailsMap.put("companyId", finalBillInpatient.get(0).getHin().getCompany().getId());
						}

						detailsMap.put("patientTypeId", finalBillInpatient.get(0).getHin().getPatientType().getId());
						detailsMap.put("regType", finalBillInpatient.get(0).getHin().getRegistrationType());
						detailsMap.put("billTypeId", 2);
						detailsMap.put("patientCategory", "IP");
						detailsMap.put("session", session);

						chargeDtMap = pateintRoomRentCharge(detailsMap);

						if (chargeDtMap.get("totalNetAmount") != null) {
							totalNetAmountNew = (BigDecimal) chargeDtMap.get("totalNetAmount");
						}

						if (totalNetAmount.intValue() > totalNetAmountNew.intValue()) {
							dataMap.put("totalChargeAmountNew", totalChargeAmount);
							dataMap.put("totalDiscAmtNew", totalDiscAmt);
							dataMap.put("totalNetAmountNew", totalNetAmount);
							dataMap.put("chargeIdNew", chargeIdNew);
							dataMap.put("stdDeduction", stdDeduction);
							dataMap.put("rate", rate);
							dataMap.put("discountPercent", discountPercent);
							pateintTransferRoomRentCalculate(dataMap);
						} else if (totalNetAmountNew.intValue() > totalNetAmount.intValue()) {
							dataMap.put("totalChargeAmountNew", totalChargeAmount);
							dataMap.put("totalDiscAmtNew", totalDiscAmt);
							dataMap.put("totalNetAmountNew", totalNetAmount);
							dataMap.put("chargeIdNew", chargeIdNew);
							dataMap.put("stdDeduction", stdDeduction);
							dataMap.put("rate", rate);
							dataMap.put("discountPercent", discountPercent);

							pateintTransferRoomRentCalculate(dataMap);
						}
					}
				} else {
					if (finalBillInpatient.get(0).getHin().getCompany() != null) {
						detailsMap.put("companyId", finalBillInpatient.get(0).getHin().getCompany().getId());
					}

					detailsMap.put("patientTypeId", finalBillInpatient.get(0).getHin().getPatientType().getId());
					detailsMap.put("regType", finalBillInpatient.get(0).getHin().getRegistrationType());
					detailsMap.put("billTypeId", 2);
					detailsMap.put("patientCategory", "IP");
					detailsMap.put("roomTypeId", finalBillInpatient.get(0).getBed().getRoom().getRoomType().getId());
					detailsMap.put("session", session);

					chargeDtMap = pateintRoomRentCharge(detailsMap);

					if (chargeDtMap.get("totalChargeAmount") != null) {
						totalChargeAmount = (BigDecimal) chargeDtMap.get("totalChargeAmount");
					}

					if (chargeDtMap.get("totalDiscAmt") != null) {
						totalDiscAmt = (BigDecimal) chargeDtMap.get("totalDiscAmt");
					}

					if (chargeDtMap.get("totalNetAmount") != null) {
						totalNetAmount = (BigDecimal) chargeDtMap.get("totalNetAmount");
					}

					if (chargeDtMap.get("chargeId") != null) {
						chargeIdNew = (BigDecimal) chargeDtMap.get("chargeId");
					}

					if (chargeDtMap.get("stdDeduction") != null) {
						stdDeduction = (BigDecimal) chargeDtMap.get("stdDeduction");
					}

					if (chargeDtMap.get("rate") != null) {
						rate = (BigDecimal) chargeDtMap.get("rate");
					}

					if (chargeDtMap.get("discountPercent") != null) {
						discountPercent = (BigDecimal) chargeDtMap.get("discountPercent");
					}

					detailsMap = new HashMap<String, Object>();
					chargeDtMap = new HashMap<String, Object>();

					roomcrit = session.createCriteria(MasRoom.class).createAlias("Department", "dept")
							.add(Restrictions.eq("dept.Id", toWardId));

					List<MasRoom> roomTransferInpatient = roomcrit.list();

					if (roomTransferInpatient.size() > 0 && roomTransferInpatient != null) {
						roomTypeId = roomTransferInpatient.get(0).getRoomType().getId();
						detailsMap.put("roomTypeId", roomTypeId);
					}

					if (finalBillInpatient.get(0).getHin().getCompany() != null) {
						detailsMap.put("companyId", finalBillInpatient.get(0).getHin().getCompany().getId());
					}

					detailsMap.put("patientTypeId", finalBillInpatient.get(0).getHin().getPatientType().getId());
					detailsMap.put("regType", finalBillInpatient.get(0).getHin().getRegistrationType());
					detailsMap.put("billTypeId", 2);
					detailsMap.put("patientCategory", "IP");
					detailsMap.put("session", session);

					chargeDtMap = pateintRoomRentCharge(detailsMap);

					if (chargeDtMap.get("totalNetAmount") != null) {
						totalNetAmountNew = (BigDecimal) chargeDtMap.get("totalNetAmount");
					}

					if (totalNetAmount.intValue() > totalNetAmountNew.intValue()) {
						dataMap.put("totalChargeAmountNew", totalChargeAmount);
						dataMap.put("totalDiscAmtNew", totalDiscAmt);
						dataMap.put("totalNetAmountNew", totalNetAmount);
						dataMap.put("chargeIdNew", chargeIdNew);
						dataMap.put("stdDeduction", stdDeduction);
						dataMap.put("rate", rate);
						dataMap.put("discountPercent", discountPercent);
						pateintTransferRoomRentCalculate(dataMap);
					} else if (totalNetAmountNew.intValue() > totalNetAmount.intValue()) {
						dataMap.put("totalChargeAmountNew", totalChargeAmount);
						dataMap.put("totalDiscAmtNew", totalDiscAmt);
						dataMap.put("totalNetAmountNew", totalNetAmount);
						dataMap.put("chargeIdNew", chargeIdNew);
						dataMap.put("stdDeduction", stdDeduction);
						dataMap.put("rate", rate);
						dataMap.put("discountPercent", discountPercent);

						pateintTransferRoomRentCalculate(dataMap);
					}
				}
			}
			transferedCalucationSuccess = true;
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error("Exceprion cocured " + e.getStackTrace().toString());
			transferedCalucationSuccess = false;
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return transferedCalucationSuccess;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> pateintRoomRentCharge(final Map<String, Object> detailsMap) {

		LOGGER.debug("Inside pateintRoomRentCharge ");
		Map<String, Object> map = new HashMap<String, Object>();
		BigDecimal totalChargeAmount = new BigDecimal(0);
		BigDecimal totalDiscAmt = new BigDecimal(0);
		BigDecimal totalNetAmount = new BigDecimal(0);
		Session session = null;

		if (detailsMap.get("session") != null) {
			session = (Session) detailsMap.get("session");
		}

		Integer chargeTypeId = getMasChargeTypeId();
		List<MasChargeCode> chargeSetupList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("ChargeType.Id", chargeTypeId)).list();

		// --------------- For getting total amount-----------------
		for (MasChargeCode chargeSetup : chargeSetupList) {
			int chargeCodeId = 0;
			chargeCodeId = chargeSetup.getId();

			detailsMap.put("chargeId", chargeCodeId);
			detailsMap.put("mainChargeId", chargeSetup.getMainChargecode().getId());
			detailsMap.put("subChargeId", chargeSetup.getSubChargecode().getId());

			Map<String, Object> chargeDtMap = opBillingDataService.getChargeAmountAfterDiscount(detailsMap);
			BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
			BigDecimal discAmt = new BigDecimal(0.00);
			BigDecimal chargeAfterSD = new BigDecimal(0.00);
			BigDecimal discountPercent = new BigDecimal(0.00);
			BigDecimal stdDeduction = new BigDecimal(0.00);
			BigDecimal rate = new BigDecimal(0.00);
			BigDecimal chargeId = new BigDecimal(chargeCodeId);

			if (chargeDtMap.get("chargeAmountAfterDis") != null) {
				chargeAmountAfterDis = (BigDecimal) chargeDtMap.get("chargeAmountAfterDis");
			}

			if (chargeDtMap.get("discAmt") != null) {
				discAmt = (BigDecimal) chargeDtMap.get("discAmt");
			}

			if (chargeDtMap.get("chargeAfterSD") != null) {
				chargeAfterSD = (BigDecimal) chargeDtMap.get("chargeAfterSD");
			}

			if (chargeDtMap.get("stdDeduction") != null) {
				stdDeduction = (BigDecimal) chargeDtMap.get("stdDeduction");
			}
			if (chargeDtMap.get("rate") != null) {
				rate = (BigDecimal) chargeDtMap.get("rate");
			}

			if (chargeDtMap.get("discPercnt") != null) {
				discountPercent = (BigDecimal) map.get("discPercnt");
			}

			totalChargeAmount = totalChargeAmount.add(chargeAfterSD.multiply(new BigDecimal(1)));
			totalDiscAmt = totalDiscAmt.add(discAmt.multiply(new BigDecimal(1)));
			totalNetAmount = totalNetAmount.add(chargeAmountAfterDis.multiply(new BigDecimal(1)));

			map.put("totalChargeAmount", totalChargeAmount);
			map.put("totalDiscAmt", totalDiscAmt);
			map.put("totalNetAmount", totalNetAmount);
			map.put("chargeId", chargeId);
			map.put("stdDeduction", stdDeduction);
			map.put("rate", rate);
			map.put("discountPercent", discountPercent);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> pateintTransferRoomRentCalculate(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside pateintTransferRoomRentCalculate ");
		Map<String, Object> map = new HashMap<String, Object>();

		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = null;
		Date lastProcessedDate = null;
		Integer patientHinId = 0;
		BigDecimal totalNetAmountNew = new BigDecimal(0);
		BigDecimal totalChargeAmountNew = new BigDecimal(0);
		BigDecimal totalDiscAmtNew = new BigDecimal(0);
		BigDecimal chargeIdNew = new BigDecimal(0);
		BigDecimal discountPercent = new BigDecimal(0.00);
		BigDecimal stdDeduction = new BigDecimal(0.00);

		if (dataMap.get("hinId") != null) {
			patientHinId = (Integer) dataMap.get("hinId");
		}

		if (dataMap.get("lastProcessedDate") != null) {
			lastProcessedDate = (Date) dataMap.get("lastProcessedDate");
		}

		if (dataMap.get("session") != null) {
			session = (Session) dataMap.get("session");
		}

		if (dataMap.get("totalNetAmountNew") != null) {
			totalNetAmountNew = (BigDecimal) dataMap.get("totalNetAmountNew");
		}

		if (dataMap.get("totalChargeAmountNew") != null) {
			totalChargeAmountNew = (BigDecimal) dataMap.get("totalChargeAmountNew");
		}

		if (dataMap.get("totalDiscAmtNew") != null) {
			totalDiscAmtNew = (BigDecimal) dataMap.get("totalDiscAmtNew");
		}

		if (dataMap.get("chargeIdNew") != null) {
			chargeIdNew = (BigDecimal) dataMap.get("chargeIdNew");
		}

		if (dataMap.get("stdDeduction") != null) {
			stdDeduction = (BigDecimal) dataMap.get("stdDeduction");
		}

		if (dataMap.get("discountPercent") != null) {
			discountPercent = (BigDecimal) dataMap.get("discountPercent");
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(lastProcessedDate);
			int dateValue = calendar.get(Calendar.DATE);
			calendar.set(Calendar.DATE, dateValue);
			Date processDate = calendar.getTime();

			List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).createAlias("Hin", "hn")
					.add(Restrictions.eq("hn.Id", patientHinId)).list();

			for (Inpatient inpatient : inpatientList) {
				int inpatientId = inpatient.getId();
				int hinId = inpatient.getHin().getId();
				int hospitalId = inpatient.getHospital().getId();

				List<BlFinalBillDetails> blFinalList = session.createCriteria(BlFinalBillDetails.class)
						.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

				if (blFinalList.size() > 0) {
					// do nothing
				} else {
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
					chargeSlipMain.setChgSlpAmt(totalChargeAmountNew);
					chargeSlipMain.setOsAmt(totalChargeAmountNew);

					if (totalDiscAmtNew.compareTo(new BigDecimal(0)) > 0) {
						chargeSlipMain.setDiscountAmt(totalDiscAmtNew);
					}
					chargeSlipMain.setNetAmt(totalNetAmountNew);

					MasPatientType patientType = new MasPatientType();
					patientType.setId(inpatient.getHin().getPatientType().getId());
					chargeSlipMain.setPatientType(patientType);

					if (inpatient.getHin().getCompany() != null) {
						MasCompany company = new MasCompany();
						company.setId(inpatient.getHin().getCompany().getId());
						chargeSlipMain.setCompany(company);
					}

					chargeSlipMain.setChgSlpDate(processDate);
					chargeSlipMain.setChgSlpTime(time);
					Users user = new Users();
					Integer userId = (Integer) dataMap.get("userId");
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

					if (chargeIdNew.intValue() != 0) {
						BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
						blChargeSlipDetail.setHospital(hospital);
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(chargeIdNew.intValue());
						blChargeSlipDetail.setChargeCode(masChargeCode);
						blChargeSlipDetail.setRate(totalChargeAmountNew);

						MasChargeCode regType = inpatient.getHin().getRegType();
						if (regType != null && !regType.equals("")) {
							if (regType.equals("G")) {
								if (stdDeduction.compareTo(new BigDecimal(0)) > 0) {
									blChargeSlipDetail.setStdDeductionGen(stdDeduction.multiply(new BigDecimal(1)));
								}
							} else if (regType.equals("S")) {
								if (stdDeduction.compareTo(new BigDecimal(0)) > 0) {
									blChargeSlipDetail.setStdDeductionSpl(stdDeduction.multiply(new BigDecimal(1)));
								}
							}
						}

						blChargeSlipDetail.setAmt(totalChargeAmountNew.multiply(new BigDecimal(1)));
						blChargeSlipDetail.setQuantity(1);

						if (discountPercent.compareTo(new BigDecimal(0)) > 0) {
							blChargeSlipDetail.setDiscountPercent(discountPercent);
						}
						if (totalDiscAmtNew.compareTo(new BigDecimal(0)) > 0) {
							blChargeSlipDetail.setDiscountAmt(totalDiscAmtNew.multiply(new BigDecimal(1)));
						}

						if (totalNetAmountNew.compareTo(new BigDecimal(0)) > 0) {
							blChargeSlipDetail.setNetAmt(totalNetAmountNew.multiply(new BigDecimal(1)));
						}
						blChargeSlipDetail.setLastChgBy(user);
						blChargeSlipDetail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						blChargeSlipDetail.setLastChgTime(time);
						blChargeSlipDetail.setStatus("y");
						blChargeSlipDetail.setChargeSlipMain(chargeSlipMain);
						blChargeSlipDetail.setRefundableStatus("y");
						MasDepartment department = new MasDepartment();
						department.setId(inpatient.getDepartment().getId());
						blChargeSlipDetail.setDepartment(department);

						hbt.save(blChargeSlipDetail);

						Patient patientObj = (Patient) session.load(Patient.class, hinId);
						BigDecimal pastDue = new BigDecimal(0);
						BigDecimal newAmt = new BigDecimal(0);
						if (patientObj.getPastDue() != null) {
							pastDue = new BigDecimal(patientObj.getPastDue());
						}
						newAmt = pastDue.add(totalChargeAmountNew);
						patientObj.setPastDue(newAmt.toString());
						hbt.update(patientObj);
					}
				}
			}
		} catch (RuntimeException runtimeException) {
			LOGGER.error("Runtime Exception Occurred " + runtimeException.getStackTrace().toString());
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Integer getMasChargeTypeId() {

		LOGGER.debug("Inside getMasChargeTypeId ");
		Integer chargeTypeID = 0;
		List<MasChargeType> searchChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType as mcc where mcc.ChargeTypeName = 'Room Rent' ");
		chargeTypeID = searchChargeTypeList.get(0).getId();
		return chargeTypeID;
	}

	@SuppressWarnings("unchecked")
	public int getChargeSlipNo(final String flag) {

		LOGGER.debug("Inside getChargeSlipNo ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int chargeSlipSeqNo = 0;
		int id = 0;
		int seqNo = 0;
		Session session = getSession();
		List<BlParameter> csSeqNoList = session.createCriteria(BlParameter.class).add(Restrictions.eq("Prefix", "CS"))
				.list();

		if (csSeqNoList.size() > 0) {
			for (BlParameter blParameter : csSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				chargeSlipSeqNo = ++seqNo;
			}
			if (flag.equals("save")) {
				BlParameter parameterObj = hbt.load(BlParameter.class, id);
				parameterObj.setSeqNo(chargeSlipSeqNo);
				hbt.update(parameterObj);
			}
		}
		return chargeSlipSeqNo;
	}

	@SuppressWarnings("unchecked")
	public boolean submitTransferInformation(final Map<String, Object> transferMap) {

		LOGGER.debug("Inside submitTransferInformation ");
		boolean transferedSuccessfully = false;
		Session session = getSession();

		List<Transfer> transferNoList = new ArrayList<Transfer>();
		Transaction tx = null;

		try {
			String transferType = (String) transferMap.get("transferType");
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (transferType.equalsIgnoreCase("bed")) {
				Inpatient inpatient = hbt.load(Inpatient.class, (Integer) transferMap.get(INPATIENT_ID));
				Transfer transfer = new Transfer();

				transfer.setInpatient(inpatient);
				transfer.setHin(inpatient.getHin());
				transfer.setAdNo(inpatient.getAdNo());
				MasHospital hospital = new MasHospital();
				hospital.setId((Integer) transferMap.get(HOSPITAL_ID));
				transfer.setHospital(hospital);
				transfer.setFromWard(inpatient.getDepartment());
				transfer.setFromBed(inpatient.getBed());
				transfer.setRequestStatus("p");
				transfer.setTransferType(transferType);
				transfer.setTransferReason((String) transferMap.get("reason"));
				transferNoList = session.createCriteria(Transfer.class).addOrder(Order.desc("Id")).setMaxResults(1)
						.list();
				if (transferNoList != null && transferNoList.size() > 0) {
					transfer.setTransferNo(transferNoList.get(0).getTransferNo());
				} else {
					transfer.setTransferNo(1);
				}

				transfer.setToWard(inpatient.getDepartment());
				MasBed toBed = new MasBed();
				toBed.setId((Integer) transferMap.get(BED_ID));
				transfer.setToBed(toBed);
				transfer.setDateOfTransfer((Date) transferMap.get(TRANSFER_DATE));
				transfer.setTimeOfTransfer((String) transferMap.get(TRANSFER_TIME));
				transfer.setAdStatus(inpatient.getAdStatus());
				transfer.setStatus("y");
				Users users = new Users();
				users.setId((Integer) transferMap.get(USER_ID));
				transfer.setAddEditBy(users);
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = HMSUtil.getCurrentDateAndTime();
				String date2 = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				transfer.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(date2));
				transfer.setAddEditTime(time);
				hbt.save(transfer);
				if (this.checkBedStatus(transfer.getToBed().getId())) {
					inpatient.setDepartment(transfer.getToWard());
					MasBed masBed = hbt.load(MasBed.class, inpatient.getBed().getId());
					if (masBed.getBedType().equalsIgnoreCase("v")) {
						// masBed.setStatus("n");
					}
					hbt.update(masBed);

					MasBed bed = hbt.load(MasBed.class, transfer.getToBed().getId());
					hbt.update(bed);
					hbt.update(inpatient);
					transferedSuccessfully = true;
				} else {
					transferedSuccessfully = false;
				}

			} else {
				Inpatient inpatient = hbt.load(Inpatient.class, (Integer) transferMap.get(INPATIENT_ID));

				Transfer transfer = new Transfer();
				transfer.setInpatient(inpatient);
				transfer.setHin(inpatient.getHin());
				transfer.setAdNo(inpatient.getAdNo());
				MasHospital hospital = new MasHospital();
				hospital.setId((Integer) transferMap.get(HOSPITAL_ID));
				transfer.setHospital(hospital);
				transfer.setFromWard(inpatient.getDepartment());
				transfer.setFromBed(inpatient.getBed());
				transfer.setRequestStatus("p");
				transfer.setTransferType(transferType);
				transfer.setTransferReason((String) transferMap.get("reason"));
				transferNoList = session.createCriteria(Transfer.class).addOrder(Order.desc("Id")).setMaxResults(1)
						.list();
				if (transferNoList != null && transferNoList.size() > 0) {
					transfer.setTransferNo(transferNoList.get(0).getTransferNo());
				} else {
					transfer.setTransferNo(1);
				}
				if (transferType.equalsIgnoreCase("bed")) {
					transfer.setToWard(inpatient.getDepartment());
					MasBed toBed = new MasBed();
					toBed.setId((Integer) transferMap.get(BED_ID));
					transfer.setToBed(toBed);
				} else {
					MasDepartment toDepartment = new MasDepartment();
					toDepartment.setId((Integer) transferMap.get(TO_WARD));
					transfer.setToWard(toDepartment);
				}

				transfer.setDateOfTransfer((Date) transferMap.get(TRANSFER_DATE));
				transfer.setTimeOfTransfer((String) transferMap.get(TRANSFER_TIME));
				transfer.setAdStatus(inpatient.getAdStatus());
				transfer.setStatus("y");
				Users users = new Users();
				users.setId((Integer) transferMap.get(USER_ID));
				transfer.setAddEditBy(users);
				Map<String, Object> utilMap = new HashMap<String, Object>();
				utilMap = HMSUtil.getCurrentDateAndTime();
				String date2 = (String) utilMap.get("currentDate");
				String time = (String) utilMap.get("currentTime");
				transfer.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(date2));
				transfer.setAddEditTime(time);

				hbt.save(transfer);
				transferedSuccessfully = true;
			}
			tx.commit();
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occurred : " + e.getStackTrace().toString());
			tx.rollback();
		}
		return transferedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeDetails(final int hospitalId, final int inpatientId) {

		LOGGER.debug("Inside getDischargeDetails ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		String empCategoryCodeForDoctor = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			empCategoryCodeForDoctor = prop.getProperty("empCategoryCodeForDoctor");
		} catch (IOException ioException) {
			LOGGER.error("Error occurred while loading adt.properties file " + ioException.getStackTrace().toString());
		}

		List<MasEmployee> employeeList = session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "empCat")
				.add(Restrictions.eq("empCat.EmpCategoryCode", empCategoryCodeForDoctor))
				.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		List<MasDiagnosisConclusion> diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasDisposedTo> disposedToList = session.createCriteria(MasDisposedTo.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasDisposal> disposalList = session.createCriteria(MasDisposal.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasCareType> careTypeList = session.createCriteria(MasCareType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<Discharge> dischargeNoList = session.createCriteria(Discharge.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		List<MasDischargeStatus> dischargeStatusList = session.createCriteria(MasDischargeStatus.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<ExpiryDetails> expiryDetailsList = session.createCriteria(ExpiryDetails.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();
		LOGGER.debug("employeeList.size()======>>>" + employeeList.size());
		map.put("employeeList", employeeList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposedToList", disposedToList);
		map.put("disposalList", disposalList);
		map.put("careTypeList", careTypeList);
		map.put("dischargeNoList", dischargeNoList);
		map.put("expiryDetailsList", expiryDetailsList);
		map.put("dischargeStatusList", dischargeStatusList);

		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean submitDischargeInformation(final Map<String, Object> dischargeMap) {

		LOGGER.debug("Inside submitDischargeInformation ");
		boolean saved = false;
		int inpatientId = (Integer) dischargeMap.get("inpatientId");
		Discharge discharge = (Discharge) dischargeMap.get("discharge");
		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
		Map<String, Object> dischargeIpdData = new HashMap<String, Object>();
		MasHospital masHospital = null;
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
		} catch (IOException ioException) {
			LOGGER.error("Error occurred while loading adt.properties file " + ioException.getStackTrace().toString());
		}

		int hinId = 0;
		if (dischargeMap.get("hinId") != null) {
			hinId = (Integer) dischargeMap.get("hinId");
		}

		List<String> dishargeCodeList = new ArrayList<String>();
		if (dischargeMap.get("dishargeCodeList") != null) {
			dishargeCodeList = (List<String>) dischargeMap.get("dishargeCodeList");
		}
		if (dischargeMap.get("icdCodeList") != null) {
			icdCodeList = (List<DischargeIcdCode>) dischargeMap.get("icdCodeList");
		}
		Session session = null;
		// Transaction initialization
		Transaction transaction = null;
		try {
			// Transaction Begin
			session = getSession();
			transaction = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			discharge.setMortuaryRegStatus("N");
			hbt.save(discharge);
			hbt.refresh(discharge);
			dischargeIpdData.put("discharge", discharge);
			List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();
			if (icdCodeList.size() > 0) {
				for (int i = 0; i < icdCodeList.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode = icdCodeList.get(i);
					MasIcd masIcd = new MasIcd();
					String query = "select icd_id from mas_icd where icd_code='" + ((String) dishargeCodeList.get(i))
							+ "'";
					List objectList = session.createSQLQuery(query).list();
					masIcd.setId(Integer.parseInt("" + objectList.get(0)));
					dischargeIcdCode.setIcd(masIcd);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);
					dischargeIcdList.add(dischargeIcdCode);
				}
				dischargeIpdData.put("dischargeIcdList", dischargeIcdList);
			}// End of icd Code if
			Inpatient inpatient = hbt.load(Inpatient.class, inpatientId);
			inpatient.setAdStatus("D");
			masHospital = inpatient.getHospital();

			Patient patient = hbt.load(Patient.class, hinId);
			patient.setPatientStatus("Out Patient");
			patient.setInpatientNo(0);
			hbt.update(patient);
			dischargeIpdData.put("patient", patient);
			MasBed masBed = inpatient.getBed();
			MasBedStatus bedStatus1 = (MasBedStatus) session.createCriteria(MasBedStatus.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("BedStatusCode", bedStatusUnOccupiedName)).uniqueResult();
			masBed.setBedStatus(bedStatus1);

			if (dischargeMap.get("addEditTime") != null) {
				inpatient.setDischargeTime("" + dischargeMap.get("addEditTime"));
			}
			Date dischargeDate = null;
			if (dischargeMap.get("addEditDate") != null) {
				dischargeDate = (Date) dischargeMap.get("addEditDate");
				inpatient.setDischargeDate(dischargeDate);
			}
			hbt.update(inpatient);
			hbt.refresh(inpatient);
			hbt.update(masBed);
			dischargeIpdData.put("inpatient", inpatient);
			saved = true;

			// Transaction End
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error("Exception occurred " + e.getStackTrace().toString());
		}
		if (masHospital != null && masHospital.getClientIp() != null && masHospital.getClientPort() != null) {
			Map<String, Object> dataMap = dischargePatientFromServer(dischargeIpdData, masHospital);
			String ipDischargeData = (String) dataMap.get("dischargeMessage");
			String message = (String) dataMap.get("message");
			Inpatient inpatient = (Inpatient) dischargeIpdData.get("inpatient");
			HibernateTemplate hbt = getHibernateTemplate();
			LeanServerFinalDischargeData dischargeData = new LeanServerFinalDischargeData();
			dischargeData.setFinalDischargeData(ipDischargeData);
			dischargeData.setHospitalId(masHospital.getId());
			dischargeData.setCentralIpId(Long.parseLong(inpatient.getId() + ""));
			String isIpPatientDischarge = "Y";
			if (!"1".equalsIgnoreCase(message)) {
				isIpPatientDischarge = "N";
			}
			dischargeData.setStatus(isIpPatientDischarge);
			hbt.save(dischargeData);
		}
		return saved;
	}

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getDepartmentList() {

		LOGGER.debug("Inside getDepartmentList ");
		Session session = getSession();
		List<MasDepartment> departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("DepartmentType.Id", 10)).list();

		return departmentList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargePatientList(final Map<String, Object> dischargeMap) {

		LOGGER.debug("Inside getDischargePatientList ");
		String hinNo = "";
		String adNo = "";
		int departmentId = 0;
		int hospitalId = 0;

		if (dischargeMap.get("hin") != null) {
			hinNo = (String) dischargeMap.get("hin");
		}
		if (dischargeMap.get("adNo") != null) {
			adNo = (String) dischargeMap.get("adNo");
		}
		if (dischargeMap.get("departmentId") != null) {
			departmentId = (Integer) dischargeMap.get("departmentId");
		}
		if (dischargeMap.get("hospitalId") != null) {
			hospitalId = (Integer) dischargeMap.get("hospitalId");
		}

		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		Criteria crit = session.createCriteria(Discharge.class).add(
				Restrictions.eq("DischargeAdviced", "y").ignoreCase());

		if (!hinNo.equals("")) {
			crit = crit.createAlias("Hin", "hin");
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		if (!adNo.equals("")) {
			crit = crit.add(Restrictions.eq("AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("Ward", "dept").add(Restrictions.eq("dept.Id", departmentId));
		}
		if (hospitalId != 0) {
			crit = crit.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		}

		List<Discharge> dischargeList = crit.list();

		if (dischargeList.size() > 0) {
			map.put("dischargeList", dischargeList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAttachPatientDetails(final Map<String, Object> attachPatientMap) {

		LOGGER.debug("Inside getDischargePatientList ");
		Map<String, Object> attachDetailsMap = new HashMap<String, Object>();
		Session session = getSession();
		int hinId = Integer.parseInt("" + attachPatientMap.get("hinId"));
		String parentAdNo = "" + attachPatientMap.get("parentAdNo");
		List<Patient> hinList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		List<Inpatient> existenceAttachedList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("ParentAdNo", parentAdNo)).add(Restrictions.eq("AttachedPatient", "y")).list();
		attachDetailsMap.put("hinList", hinList);
		attachDetailsMap.put("existenceAttachedList", existenceAttachedList);
		return attachDetailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> dischargePatient(final Map<String, Object> detailsMap) {

		LOGGER.debug("Inside dischargePatient ");
		Map<String, Object> map = new HashMap<String, Object>();
		String dischargeSuccessfully = "false";
		int dischargeId = (Integer) detailsMap.get("dischargeId");
		int inpatientId = 0;
		Session session = getSession();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}

		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Discharge discharge = hbt.load(Discharge.class, dischargeId);
		discharge.setDischargeAdviced("n");
		hbt.update(discharge);

		List<Discharge> dischargeList = session.createCriteria(Discharge.class).add(Restrictions.idEq(dischargeId))
				.list();

		int hinId = 0;
		String adNo = "";
		for (Discharge dischargeObj : dischargeList) {
			hinId = dischargeObj.getHin().getId();
			adNo = dischargeObj.getAdNo();
		}
		Patient patient = hbt.load(Patient.class, hinId);
		patient.setPatientStatus("Out Patient");
		patient.setInpatientNo(0);
		hbt.update(patient);

		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
		if (inpatientList.size() > 0) {
			for (Inpatient inpatient : inpatientList) {
				inpatientId = inpatient.getId();
				Inpatient inpatientObj = hbt.load(Inpatient.class, inpatientId);
				inpatientObj.setAdStatus("D");
				inpatientObj.setStatus("n");
				hbt.update(inpatientObj);

				int bedId = inpatient.getBed().getId();
				MasBed masBed = hbt.load(MasBed.class, bedId);
				MasBedStatus masBedStatus = new MasBedStatus();
				masBedStatus.setId(bedStatusUnOccupiedId);
				masBed.setBedStatus(masBedStatus);
				hbt.update(masBed);
			}
		}

		List<AttachInpatient> attachPatientList = session.createCriteria(AttachInpatient.class)
				.add(Restrictions.eq("AdNo", adNo)).add(Restrictions.eq("Status", "y")).list();
		if (attachPatientList.size() > 0) {
			for (AttachInpatient attachInpatient : attachPatientList) {
				int attachedId = attachInpatient.getId();
				AttachInpatient attInpatient = hbt.load(AttachInpatient.class, attachedId);
				attInpatient.setStatus("n");
				hbt.update(attInpatient);

				if (attachInpatient.getBed() != null) {
					int attBedId = attachInpatient.getBed().getId();
					MasBed masBedObj = hbt.load(MasBed.class, attBedId);
					MasBedStatus masBedStatusObj = new MasBedStatus();
					masBedStatusObj.setId(bedStatusUnOccupiedId);
					masBedObj.setBedStatus(masBedStatusObj);
					hbt.update(masBedObj);
				}
			}
		}

		dischargeSuccessfully = "true";

		map.put("dischargeSuccessfully", dischargeSuccessfully);
		map.put("inpatientId", inpatientId);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showExpiryDetails(final Map<String, Object> patientDetailsMap) {

		LOGGER.debug("Inside showExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		MasDepartment department = null;
		String adNo = "" + patientDetailsMap.get("adNo");

		int hospitalId = 0;
		if (patientDetailsMap.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) patientDetailsMap.get(HOSPITAL_ID);
		}

		String flagJsp = "";
		if (patientDetailsMap.get("flagJsp") != null) {
			flagJsp = (String) patientDetailsMap.get("flagJsp");
		}

		String masdeptTypeMortury = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			masdeptTypeMortury = prop.getProperty("masdeptTypeMortury");
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}
		Session session = getSession();
		int inpatientId = (Integer) patientDetailsMap.get("inpatientId");
		List<ExpiryDetails> expiryDetailsList = session.createCriteria(ExpiryDetails.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();

		LOGGER.debug("masdeptTypeMortury===" + masdeptTypeMortury);
		LOGGER.debug("hospitalId===" + hospitalId);
		department = (MasDepartment) session.createCriteria(MasInstituteDepartment.class, "msd")
				.createAlias("msd.Department", "md").createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh").add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", masdeptTypeMortury))
				.add(Restrictions.eq("md.Status", "Y".toLowerCase())).add(Restrictions.eq("mh.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).uniqueResult();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Transfer transfer = (Transfer) patientDetailsMap.get("transfer");
		if (department != null) {
			Inpatient inpatient = hbt.get(Inpatient.class, inpatientId);
			transfer.setFromWard(inpatient.getDepartment());
			transfer.setFromBed(inpatient.getBed());
			transfer.setAdStatus(inpatient.getAdStatus());
			List<Transfer> transferNoList = new ArrayList<Transfer>();
			transferNoList = session.createCriteria(Transfer.class).addOrder(Order.desc("Id")).setMaxResults(1).list();
			if (transferNoList != null && transferNoList.size() > 0) {
				transfer.setTransferNo(transferNoList.get(0).getTransferNo());
			} else {
				transfer.setTransferNo(1);
			}
			transfer.setToWard(department);

			hbt.save(transfer);
		}

		HospitalParameters hospitalParameters = new HospitalParameters();
		List<HospitalParameters> hospitalParametersList = new ArrayList<HospitalParameters>();
		hospitalParametersList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.HospitalParameters as hp where hp.Hospital.Id='" + hospitalId + "'");
		if (hospitalParametersList != null && hospitalParametersList.size() > 0) {
			hospitalParameters = hospitalParametersList.get(0);
		}
		map.put("hospitalParameters", hospitalParameters);

		List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		List<Discharge> dischargeList = session.createCriteria(Discharge.class).add(Restrictions.eq("AdNo", adNo))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		int hinId = 0;
		if (inpatientList.size() > 0) {
			for (Inpatient inpatient : inpatientList) {
				hinId = Integer.parseInt("" + inpatient.getHin().getId());
			}
		}

		List<Patient> patientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
		List<MasDeathCause> deathCauseList = session.createCriteria(MasDeathCause.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		List<TransactionSequence> deathCertificateNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "DEA")).add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();

		int id = 0;
		int tsn = 0;
		String deathCertificateNo = "";
		if (deathCertificateNoList.size() > 0) {
			for (TransactionSequence transactionSequence : deathCertificateNoList) {
				tsn = Integer.parseInt("" + transactionSequence.getTransactionSequenceNumber());
				id = transactionSequence.getId();
			}
			TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(tsn + 1);
			deathCertificateNo = "" + (tsn + 1);
		} else {
			TransactionSequence transactionSequenceObj = new TransactionSequence();
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			transactionSequenceObj.setHospital(hospital);
			transactionSequenceObj.setTransactionPrefix("DEA");
			transactionSequenceObj.setStatus("y");
			transactionSequenceObj.setTransactionSequenceName("DiaryEntryNo");
			transactionSequenceObj.setTransactionSequenceNumber(1);
			transactionSequenceObj.setCreatedby("admin");
			hbt.save(transactionSequenceObj);
			deathCertificateNo = String.valueOf(1);
		}

		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasBlock> blockList = new ArrayList<MasBlock>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();

		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		map.put("deathCauseList", deathCauseList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("relationList", relationList);
		map.put("dischargeList", dischargeList);
		map.put("transactionId", id);
		map.put("deathCertificateNo", deathCertificateNo);
		map.put("expiryDetailsList", expiryDetailsList);
		map.put("flagJsp", flagJsp);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitExpiryDetails(final Map<String, Object> expiryDetilsMap, final Box box) {

		LOGGER.debug("Inside submitExpiryDetails ");
		boolean saved = false;
		ExpiryDetails expiryDetails = (ExpiryDetails) expiryDetilsMap.get("expiryDetails");
		int transactionId = (Integer) expiryDetilsMap.get("transactionId");
		int deathCertificateNo = (Integer) expiryDetilsMap.get("deathCertificateNo");
		int hinId = (Integer) expiryDetilsMap.get("hinId");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (box.getString("flag").equalsIgnoreCase("save")) {
			hbt.save(expiryDetails);
			Patient patient = hbt.load(Patient.class, hinId);
			patient.setPatientStatus("Expired");
			hbt.update(patient);

			TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, transactionId);
			transactionSequenceObj.setTransactionSequenceNumber(deathCertificateNo + 1);
			hbt.update(transactionSequenceObj);
			Session session = getSession();
			List<Patient> patietList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
			for (Patient pt : patietList) {
				pt.setStatus("n");
				hbt.update(pt);
			}
			saved = true;
		} else {
			LOGGER.debug("121212122   ::  " + box.getInt("expiryDetailId"));
			ExpiryDetails expiryDt = hbt.load(ExpiryDetails.class, box.getInt("expiryDetailId"));
			if (!box.getString(D_DEATH_CAUSE_ID).equals("")) {
				expiryDt.setDDeathCauseText(box.getString(D_DEATH_CAUSE_ID));
			}

			if (!box.getString(S_DEATH_CAUSE_ID).equals("")) {
				expiryDt.setSDeathCauseText(box.getString(S_DEATH_CAUSE_ID));
			}
			if (!box.getString(C_DEATH_CAUSE_ID).equals("")) {
				expiryDt.setCDeathCauseText(box.getString(C_DEATH_CAUSE_ID));
			}
			if (!box.getString("issueDate").equals("")) {
				expiryDt.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString("issueDate")));
			}
			if (!box.getString("issueTime").equals("")) {
				expiryDt.setIssueTime(box.getString("issueTime"));
			}
			if (!box.getString(DEATH_CERTIFICATE_TAKEN_BY).equals("")) {
				expiryDt.setDeathCertificateTakenBy(box.getString(DEATH_CERTIFICATE_TAKEN_BY));
			}
			if (!box.getString(DATE_OF_EXPIRY).equals("")) {
				expiryDt.setExpiryDate(HMSUtil.convertStringTypeDateToDateType(box.getString(DATE_OF_EXPIRY)));
			}
			if (!box.getString(TIME_OF_EXPIRY).equals("")) {
				expiryDt.setExpiryTime(box.getString(TIME_OF_EXPIRY));
			}
			if (!box.getString(CONSQUENCE_OF).equals("")) {
				expiryDt.setConsequenceOf(box.getString(CONSQUENCE_OF));
			}
			if (!box.getString(ID_MARK1).equals("")) {
				expiryDt.setIdMarks1(box.getString(ID_MARK1));
			}
			if (!box.getString(ID_MARK2).equals("")) {
				expiryDt.setIdMarks2(box.getString(ID_MARK2));
			}
			if (!box.getString(REMARKS).equals("")) {
				expiryDt.setRemarks(box.getString(REMARKS));
			}
			hbt.update(expiryDt);
			saved = true;
		}
		return saved;
	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> getConnectionForReport() {

		LOGGER.debug("Inside getConnectionForReport ");
		Session session = getSession();
		Connection con = session.connection();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAdmissionNoList(final Map<String, Object> detailsMap) {

		LOGGER.debug("Inside getAdmissionNoList ");
		String serviceNo = "";
		String hinNo = "";
		int hospitalId = 0;
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("hospitalId") != null) {
			hospitalId = (Integer) detailsMap.get("hospitalId");
		}
		List<Object> inpatientList = new ArrayList<Object>();

		if (!serviceNo.equals("")) {
			inpatientList = getHibernateTemplate().find(
					"from Inpatient ip join ip.Hin as p join ip.Hospital as h where p.ServiceNo = '" + serviceNo
							+ "' and h.Id='" + hospitalId + "'");
		}
		if (!hinNo.equals("")) {
			inpatientList = getHibernateTemplate().find(
					"from Inpatient ip join ip.Hin as p join ip.Hospital as h where p.HinNo = '" + hinNo
							+ "' and h.Id='" + hospitalId + "'");
		}

		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(final String serviceNo) {

		LOGGER.debug("Inside getHinNoList ");
		Session session = getSession();
		return session.createCriteria(Patient.class).add(Restrictions.eq("ServiceNo", serviceNo)).list();
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeDepartmentCategory() {

		LOGGER.debug("Inside getServiceTypeDepartmentCategory ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<MasDepartment> departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();
		map.put("departmentList", departmentList);

		List<MasCaseType> caseTypeList = session.createCriteria(MasCaseType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("caseTypeList", caseTypeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitDates(final String hinNo, final int hospitalId) {

		LOGGER.debug("Inside getVisitDates ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<Visit> visitDateList = session.createCriteria(Visit.class, "v").createAlias("v.Hin", "patient")
				.add(Restrictions.eq("patient.HinNo", hinNo)).createAlias("v.Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("visitDateList", visitDateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDiagnosis(final Map<String, Object> parameterMap) throws ParseException {

		LOGGER.debug("Inside getDiagnosis ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		Session session = getSession();
		String toDate = "";
		String fromDate = "";
		String hinNo = "";
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		if (parameterMap.get("fromDate") != null) {
			fromDate = (String) parameterMap.get("fromDate");
		}
		if (parameterMap.get("toDate") != null) {
			toDate = (String) parameterMap.get("toDate");
		}
		LOGGER.debug("fromDate : " + fromDate);
		LOGGER.debug("toDate : " + toDate);

		Criteria criteria = session.createCriteria(DischargeIcdCode.class).createAlias("Hin", "hin")
				.createAlias("Visit", "visit");
		if (!hinNo.equals("") && hinNo != null) {
			criteria = criteria.add(Restrictions.eq("hin.HinNo", hinNo));
		}

		if (!fromDate.equals("") && !toDate.equals("") && hinNo != null && fromDate != null && toDate != null) {
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL1 = formatterOut.format(formatterIn.parse(fromDate));
			String date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
			java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
			java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);

			criteria = criteria.add(Restrictions.between("visit.VisitDate", startDate, endDate));

		}
		if (criteria != null) {
			dischargeIcdCodeList = criteria.list();
		}
		LOGGER.debug(dischargeIcdCodeList.size() + "dischargeIcdCodeList");
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientAdmissionDetailsForUpdate(final String adNo) {

		LOGGER.debug("Inside getPatientAdmissionDetailsForUpdate ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		List<Inpatient> admissionDetailsList = new ArrayList<Inpatient>();
		List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
		if (!adNo.equals("")) {
			admissionDetailsList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			inpatientDocumentList = session.createCriteria(InpatientDocument.class).list();
		}
		map.put("admissionDetailsList", admissionDetailsList);
		map.put("inpatientDocumentList", inpatientDocumentList);
		return map;
	}

	public boolean updateAdmissionInformation(final Map<String, Object> parameterMap) {

		LOGGER.debug("Inside updateAdmissionInformation ");
		int inpatientId = 0;
		int hinId = 0;
		boolean updatedSuccessfully = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (parameterMap.get("inpatientId") != null) {
			inpatientId = (Integer) parameterMap.get("inpatientId");
		}
		if (parameterMap.get("hinId") != null) {
			hinId = (Integer) parameterMap.get("hinId");
		}

		Inpatient inpatient = hbt.load(Inpatient.class, inpatientId);
		Patient patient = hbt.load(Patient.class, hinId);

		/*
		 * Code For update Condition & Condt. Status Date 26 Oct 2010 Code By
		 * Mukesh
		 */
		String condition = "";
		String conditionStatus = "";
		Properties properties1 = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties1.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}
		String conditionNormal = properties1.getProperty("conditionNormal");
		String conditionDead = properties1.getProperty("conditionDead");
		String conditionCritical = properties1.getProperty("conditionCritical");
		if (parameterMap.get("condition") != null) {
			condition = (String) parameterMap.get("condition");
			if (condition.equals(conditionNormal)) {
				inpatient.setConditionStatus(condition);
			} else if (condition.equals(conditionDead)) {
				inpatient.setConditionStatus(condition);
			} else if (condition.equals(conditionCritical)) {
				if (parameterMap.get("conditionStatus") != null) {
					conditionStatus = (String) parameterMap.get("conditionStatus");
					inpatient.setConditionStatus(conditionStatus);
				}
			}

			inpatient.setPatientCondition(condition);

			String patientStatus = "";
			if (parameterMap.get("patientStatus") != null) {
				patientStatus = (String) parameterMap.get("patientStatus");
			}
			String inpatientStatus = properties1.getProperty("inpatientStatus");
			if (!patientStatus.equals("")) {
				patient.setPatientStatus(patientStatus);
			} else {
				patient.setPatientStatus(inpatientStatus);
			}

		}
		/*
		 * End Of Code for Condition Date 26 Oct 2010 Code By Mukesh Narayan
		 * Singh
		 */

		if (parameterMap.get("icd") != null) {
			inpatient.setInitDiagnosis((String) parameterMap.get("icd"));
		}
		if (parameterMap.get("ageAsDob") != null) {
			inpatient.setAge((String) parameterMap.get("ageAsDob"));
		}
		if (parameterMap.get("consultingDoctorId") != null) {
			int consultingDoctorId = (Integer) parameterMap.get("consultingDoctorId");
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(consultingDoctorId);
			inpatient.setDoctor(masEmployee);
		}

		if (parameterMap.get("caseTypeId") != null) {
			int caseTypeId = (Integer) parameterMap.get("caseTypeId");
			MasCaseType caseType = new MasCaseType();
			caseType.setId(caseTypeId);
			inpatient.setCaseType(caseType);
		}
		if (parameterMap.get("admissionTypeId") != null) {
			int admissionTypeId = (Integer) parameterMap.get("admissionTypeId");
			MasAdmissionType admissionType = new MasAdmissionType();
			admissionType.setId(admissionTypeId);
			inpatient.setAdmissionType(admissionType);
		}
		if (parameterMap.get("diagnosisId") != null) {
			int diagnosisId = (Integer) parameterMap.get("diagnosisId");
			MasIcd masIcd = new MasIcd();
			masIcd.setId(diagnosisId);
			inpatient.setDiagnosis(masIcd);
		}
		if (parameterMap.get("dietId") != null) {
			int dietId = (Integer) parameterMap.get("dietId");
			MasDiet diet = new MasDiet();
			diet.setId(dietId);
			inpatient.setDiet(diet);
		}
		if (parameterMap.get("dietType") != null) {
			String dietType = (String) parameterMap.get("dietType");
			inpatient.setDietType(dietType);
		}

		if (parameterMap.get("userId") != null) {
			int userId = (Integer) parameterMap.get("userId");
			Users users = new Users();
			users.setId(userId);
			inpatient.setAddEditBy(users);
		}
		Date addEditDate = null;
		if (parameterMap.get("addEditDate") != null) {
			addEditDate = (Date) parameterMap.get("addEditDate");
			inpatient.setAddEditDate(addEditDate);
		}
		String addEditTime = "";
		if (parameterMap.get("addEditTime") != null) {
			addEditTime = (String) parameterMap.get("addEditTime");
			inpatient.setAddEditTime(addEditTime);
		}
		hbt.update(inpatient);
		hbt.update(patient);
		updatedSuccessfully = true;
		return updatedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMlcNo(final Map<String, Object> details) {

		LOGGER.debug("Inside getMlcNo ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		String hinNo = "";
		String adNo = "";
		int hospitalId = 0;
		if (details.get("hinNo") != null) {
			hinNo = (String) details.get("hinNo");
		}
		if (details.get("adNo") != null) {
			adNo = (String) details.get("adNo");
		}
		if (details.get("hospitalId") != null) {
			hospitalId = (Integer) details.get("hospitalId");
		}
		Criteria crit = session.createCriteria(MlcCase.class);
		if (!hinNo.equals("")) {
			crit = crit.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo));
		}
		if (!adNo.equals("")) {
			crit = crit.add(Restrictions.eq("AdNo", adNo));
		}
		if (hospitalId != 0) {
			crit = crit.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		}
		List<MlcCase> mlcNoList = crit.list();
		map.put("mlcNoList", mlcNoList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch() {

		LOGGER.debug("Inside getDetailsForSearch ");

		Session session = getSession();

		List<MasRank> rankList = session.createCriteria(MasRank.class, "rank")
				.add(Restrictions.eq("rank.Status", "y").ignoreCase()).addOrder(Order.asc("rank.RankName")).list();
		List<MasServiceType> serviceTypeList = session.createCriteria(MasServiceType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		List<MasUnit> unitList = session.createCriteria(MasUnit.class).add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		List<MasDepartment> wardList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.DepartmentTypeName", "Ward").ignoreCase()).list();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rankList", rankList);
		map.put("serviceTypeList", serviceTypeList);
		map.put("unitList", unitList);
		map.put("wardList", wardList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForDischarge(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getPatientDetailsForDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientTempList = new ArrayList<Inpatient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		Session session = getSession();
		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		int hospitalId = 0;
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get("wardId") != null) {
			wardId = (Integer) mapForDs.get("wardId");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}

		List<String> objectList = new ArrayList<String>();
		objectList.add("R");
		try {
			Criteria crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", objectList))
					.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
			crit = crit.createAlias("Hin", "hinP");
			if (inpatientId == 0) {
				if (!adNo.equals("")) {
					crit = crit.add(Restrictions.eq("AdNo", adNo));
				}
				if (adNo.equals("")) {
					crit = crit.add(Restrictions.eq("hinP.PatientStatus", "In Patient"));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("hinP.HinNo", hinNo));
				}
				if (wardId != 0) {
					crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
				}
			} else if (inpatientId != 0) {
				crit = crit.add(Restrictions.idEq(inpatientId));
			}

			inPatientList = crit.list();
			LOGGER.debug("inPatientList==" + inPatientList.size());

			// This part is commented because of new requirement That is patient
			// will discharged without discharge Summary

			for (Inpatient inpatient : inPatientTempList) {
				String admNo = inpatient.getAdNo();
				dischargeSummaryList = session.createCriteria(DischargeSummary.class)
						.add(Restrictions.eq("AdNo", admNo)).list();
			}

		} catch (HibernateException e) {
			LOGGER.error("HibernateException occured : " + e.getStackTrace().toString());
			session.close();
		}

		map.put("dischargeSummaryList", dischargeSummaryList);
		map.put("inpatientList", inPatientList);
		return map;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeDetails() {

		LOGGER.debug("Inside getDischargeDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();
		List<MasDisposedTo> disposedToList = new ArrayList<MasDisposedTo>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List<MasCareType> careTypeList = new ArrayList<MasCareType>();
		List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();

		Session session = getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			disposedToList = session.createCriteria(MasDisposedTo.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			disposalList = session.createCriteria(MasDisposal.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			careTypeList = session.createCriteria(MasCareType.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			dischargeStatusList = session.createCriteria(MasDischargeStatus.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured : " + e.getStackTrace().toString());
			session.close();
		}
		map.put("employeeList", employeeList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposedToList", disposedToList);
		map.put("disposalList", disposalList);
		map.put("careTypeList", careTypeList);
		map.put("dischargeStatusList", dischargeStatusList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getHospitalStaffSLNo() {

		LOGGER.debug("Inside getHospitalStaffSLNo ");
		int hospStaffSeqNo = 0;
		try {
			List<TransactionSequence> hospStaffSeqNoList = new ArrayList<TransactionSequence>();

			Session session = getSession();
			try {
				hospStaffSeqNoList = session.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "HS")).list();
			} catch (HibernateException e) {
				LOGGER.error("HibernateException occured : " + e.getStackTrace().toString());
			}
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			if (hospStaffSeqNoList.size() > 0) {
				for (TransactionSequence transactionSequence : hospStaffSeqNoList) {
					int id = transactionSequence.getId();
					int seqNo = transactionSequence.getTransactionSequenceNumber();
					TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, id);
					hospStaffSeqNo = ++seqNo;
					transactionSequenceObj.setTransactionSequenceNumber(hospStaffSeqNo);
					hbt.update(transactionSequenceObj);
				}
			} else if (hospStaffSeqNoList.size() == 0) {
				hospStaffSeqNo = 1;
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("Inpatient");
				tsObj.setTransactionPrefix("HS");
				tsObj.setTransactionSequenceName("Hospital Staff SL. No");
				tsObj.setTransactionSequenceNumber(hospStaffSeqNo);
				tsObj.setStatus("y");

				hbt.save(tsObj);

			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return hospStaffSeqNo;
	}

	public boolean saveAdditionalInfoForDischarge(final Map<String, Object> parameterMap) {

		LOGGER.debug("Inside saveAdditionalInfoForDischarge ");
		String movementCode = "";
		String warrantNo = "";
		String shr = "";
		String remarks = "";
		int dischargeId = 0;
		boolean flag = false;

		if (parameterMap.get("movementCode") != null) {
			movementCode = (String) parameterMap.get("movementCode");
		}
		if (parameterMap.get("warrantNo") != null) {
			warrantNo = (String) parameterMap.get("warrantNo");
		}
		if (parameterMap.get("shr") != null) {
			shr = (String) parameterMap.get("shr");
		}
		if (parameterMap.get("remarks") != null) {
			remarks = (String) parameterMap.get("remarks");
		}
		if (parameterMap.get("dischargeId") != null) {
			dischargeId = (Integer) parameterMap.get("dischargeId");
		}

		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Discharge discharge = hbt.load(Discharge.class, dischargeId);
			discharge.setMovementCode(movementCode);
			discharge.setWarrantNo(warrantNo);
			discharge.setShr(shr);
			discharge.setRemarks(remarks);
			hbt.update(discharge);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException Occurred" + e.getStackTrace().toString());
		}

		return flag;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDiagnosis(final String adNo, final int inpatientId) {

		LOGGER.debug("Inside getPatientDiagnosis ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdList = new ArrayList<DischargeIcdCode>();

		Session session = getSession();

		try {
			if (inpatientId == 0) {
				if (!adNo.equals("")) {
					dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip")
							.add(Restrictions.eq("ip.AdNo", adNo)).list();
				}
			} else if (inpatientId != 0) {
				dischargeIcdList = session.createCriteria(DischargeIcdCode.class).createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientId)).list();
			}

			if (dischargeIcdList.size() > 0) {
				map.put("dischargeIcdList", dischargeIcdList);
			}
		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred" + e.getStackTrace().toString());
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean cancelAdmissionInformation(final Map<String, Object> parameterMap) {

		LOGGER.debug("Inside cancelAdmissionInformation ");
		boolean admissionFlag = false;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			LOGGER.error("Exception occurred while loading adt.properties : " + e.getStackTrace().toString());
		}
		Transaction tx = null;
		try {
		Session session = getSession();
		
		int inpatientId = 0;
		if (parameterMap.get("inpatientId") != null) {
			inpatientId = (Integer) parameterMap.get("inpatientId");
		}
		int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId))
				.list();
		int patientId = 0;
		for (Inpatient inpatient : inpatientList) {
			patientId = inpatient.getHin().getId();
		}
		
			tx = session.beginTransaction();
			// -----Parent admission cancilation----------------
			Inpatient inpatient = hbt.load(Inpatient.class, inpatientId);
			inpatient.setStatus("n");
			inpatient.setAdStatus("C");
			hbt.update(inpatient);
			if (parameterMap.get("bedId") != null) {
				int bedId = (Integer) parameterMap.get("bedId");
				MasBed masBed = hbt.load(MasBed.class, bedId);
				MasBedStatus bedStatus = new MasBedStatus();
				bedStatus.setId(bedStatusUnOccupiedId);
				masBed.setBedStatus(bedStatus);
				hbt.update(masBed);
			}
			if (patientId != 0) {
				Patient patient = hbt.load(Patient.class, patientId);
				patient.setPatientStatus("Out Patient");
				hbt.update(patient);
			}
			admissionFlag = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return admissionFlag;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> getSiDiData(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getSiDiData ");
		Map<String, Object> map = new HashMap<String, Object>();
		String adNo = "";
		String initDiagnosis = "";
		if (dataMap.get("adNo") != null) {
			adNo = "" + dataMap.get("adNo");
		}
		Session session = getSession();
		Connection connection = session.connection();
		Connection con = connection;
		map.put("conn", con);

		List<SilDilStatus> siDiList = new ArrayList<SilDilStatus>();
		List<Inpatient> list = new ArrayList<Inpatient>();
		int inpatientId = 0;

		try {
			list = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			String time = "";
			Date date = new Date();
			for (Inpatient inpatient : list) {
				inpatientId = inpatient.getId();
				initDiagnosis = inpatient.getInitDiagnosis();
				time = inpatient.getListTime();
				date = inpatient.getListDate();
			}
			if (date != null || time != null) {
				siDiList = session.createCriteria(SilDilStatus.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
						.add(Restrictions.eq("LastChgDate", date)).add(Restrictions.eq("LastChgTime", time)).list();
			} else {
				siDiList = session.createCriteria(SilDilStatus.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
						.list();
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		String placedBy = "";
		String placedOn = "";
		String sidi = "";
		String sidiDate = "";
		String sidiTime = "";
		String diagnosis = "";
		String nokStatus = "";
		String sidiPrevious = "";
		//
		if (siDiList.size() > 0) {
			for (SilDilStatus dilStatus : siDiList) {

				placedBy = "" + dilStatus.getPlacedBy().getFirstName() + dilStatus.getPlacedBy().getLastName();
				if (dilStatus.getConditionStatus().equalsIgnoreCase("sil")
						|| dilStatus.getConditionStatus().equalsIgnoreCase("dil")) {
					placedOn = "Placed on :";
				} else {
					placedOn = "Taken of:";
				}
				sidi = "" + dilStatus.getConditionStatus();
				if (sidi.equals("Normal")) {
					sidi = sidiPrevious;
				}
				sidiPrevious = "" + dilStatus.getConditionStatus();
				sidiDate = "" + dilStatus.getLastChgDate();
				sidiTime = "" + dilStatus.getLastChgTime();
				if (dilStatus.getIcd() != null) {
					diagnosis = diagnosis + "" + " : " + dilStatus.getIcd().getIcdSubCategory().getIcdSubCategoryName()
							+ dilStatus.getIcd().getIcdName() + ",";
				}
				nokStatus = "" + dilStatus.getNok();

			}

		}

		if (diagnosis.equals("")) {
			diagnosis = initDiagnosis;
		}
		map.put("placed_by", placedBy);
		map.put("Placed_on", placedOn);
		map.put("si_di", sidi);
		map.put("si_di_date", sidiDate);
		map.put("si_di_time", sidiTime);
		map.put("diagnosis", diagnosis);
		map.put("nok_status", nokStatus);

		return map;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> getDiagnosisAndDocInit(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getDiagnosisAndDocInit ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> adList = new ArrayList<Inpatient>();
		List<DischargeIcdCode> diagList = new ArrayList<DischargeIcdCode>();
		List<InpatientDocument> docList = new ArrayList<InpatientDocument>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		int inpatientId = 0;
		Session session = getSession();
		String adNo = "";
		String docString = "";
		String diagnosisString = "";
		int hinId = 0;

		String department = "";
		if (dataMap.get("adNo") != null) {
			adNo = "" + dataMap.get("adNo");
		}

		String hinNo = "";
		if (dataMap.get("hinNo") != null) {
			hinNo = "" + dataMap.get("hinNo");
		}		
		
		if (dataMap.get("hinId") != null) {
			hinId = (Integer) dataMap.get("hinId");
		}
		LOGGER.debug("hinId " + hinId);
		try {
			if(!hinNo.equals(""))
				adList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).add(Restrictions.eq("HinNo", hinNo)).list();
			else
				adList = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			for (Inpatient inpatient : adList) {
				inpatientId = inpatient.getId();
				if (inpatient.getOpdPatientDetails() != null) {
					if (inpatient.getOpdPatientDetails().getVisit() != null) {
						if (inpatient.getOpdPatientDetails().getVisit().getDepartment() != null) {
							department = inpatient.getOpdPatientDetails().getVisit().getDepartment()
									.getDepartmentName();
						}

					}
				} else {
					department = inpatient.getAdmittingDepartmet().getDepartmentName();
				}
			}
			inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
			diagList = session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
					.list();
			docList = session.createCriteria(InpatientDocument.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
					.list();
			for (DischargeIcdCode dischargeIcdCode : diagList) {
				diagnosisString = "" + diagnosisString
						+ dischargeIcdCode.getIcd().getIcdSubCategory().getIcdSubCategoryName() + " : "
						+ dischargeIcdCode.getIcd().getIcdName() + ",";
			}
			for (InpatientDocument inpatientDocument : docList) {
				docString = "" + docString + inpatientDocument.getDocument().getDocumentName() + ",";
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		Connection connection = session.connection();
		map.put("conn", connection);
		map.put("docString", docString);
		map.put("diagnosisString", diagnosisString);
		map.put("inpatientList", inpatientList);
		map.put("department", department);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> chechBed(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside chechBed ");
		Map<String, Object> map = new HashMap<String, Object>();
		int wardId = 0;
		int hospitalId = 0;
		if (dataMap.get("wardId") != null) {
			wardId = Integer.parseInt("" + dataMap.get("wardId"));
		}
		if (dataMap.get(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + dataMap.get(HOSPITAL_ID));
		}
		Session session = getSession();
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			LOGGER.error("IOException Occurred while loading adt.properties" + e.getStackTrace().toString());
		}

		List<MasBed> bedList = new ArrayList<MasBed>();
		bedList = session.createCriteria(MasBed.class).createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", wardId)).createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("BedNo")).createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode", bedStatusUnOccupiedName))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase()).add(Restrictions.isNull("VBed"))
				.list();
		if (bedList.size() == 0) {
			bedList = session.createCriteria(MasBed.class).createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", wardId)).createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("BedNo"))
					.createAlias("BedStatus", "bs").add(Restrictions.eq("bs.BedStatusCode", bedStatusUnOccupiedName))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
					.add(Restrictions.isNotNull("VBed")).list();
		}
		map.put("bedList", bedList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkAdNoDuplication(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside checkAdNoDuplication ");
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			int hinId = 0;
			Session session = getSession();
			if (dataMap.get("hinId") != null) {
				hinId = Integer.parseInt("" + dataMap.get("hinId"));
			}
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			inpatientList = session.createCriteria(Inpatient.class).add((Restrictions.eq("Hin.Id", hinId)))
					.add(Restrictions.in("AdStatus", new String[] { "W", "A", "R" })).list();
			map.put("inpatientList", inpatientList);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Object> checkForDuplicateOfAdnoInAttach(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside checkForDuplicateOfAdnoInAttach ");
		Map<String, Object> map = new HashMap<String, Object>();

		String serviceNo = "";
		int serviceTypeId = 0;
		Session session = getSession();
		List objectList = new ArrayList();
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("serviceTypeId") != null) {
			serviceTypeId = Integer.parseInt("" + dataMap.get("serviceTypeId"));
		}
		String qry = "select p.relation_id,concat(p.p_first_name,' ',p.p_middle_name,' ',p.p_last_name),concat(p.s_first_name,' ',p.s_middle_name,' ',p.s_last_name),rank.rank_name,relation.relation_name from inpatient as ip,patient as p,mas_rank as rank,mas_relation as relation where p.hin_id = ip.hin_id and  p.rank_id = rank.rank_id and p.service_no ='"
				+ serviceNo
				+ "' and p.service_type_id = '"
				+ serviceTypeId
				+ "' and  ip.ad_status in ('A','W') and relation.relation_id=p.relation_id ;";
		objectList = session.createSQLQuery(qry).list();
		map.put("objectList", objectList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIcdWithIcdCode(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getIcdWithIcdCode ");
		Map<String, Object> map = new HashMap<String, Object>();

		String icdCode = "";
		Session session = getSession();
		if (dataMap.get("icdCode") != null) {
			icdCode = dataMap.get("icdCode").toString().trim();
		}
		List<MasIcd> masIcdList = session.createCriteria(MasIcd.class).add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("IcdCode", icdCode)).list();
		map.put("masIcdList", masIcdList);
		return map;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Object> getDischargeDetails(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getDischargeDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		int hospitalId = 0;
		Session session = getSession();
		if (dataMap.get("hinNo") != null) {
			hinNo = "" + dataMap.get("hinNo");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		List objectList = new ArrayList();
		String qry = "select inpatient_id,ad_no from inpatient ip,patient p, mas_hospital h where p.hin_id = ip.hin_id and ip.ad_status in ('D','R') and  p.hin_no ='"
				+ hinNo + "' and h.hospital_id='" + hospitalId + "';";
		objectList = session.createSQLQuery(qry).list();
		map.put("objectList", objectList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsOfDischarge(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getDetailsOfDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		String admissionNo = "";
		Session session = getSession();
		if (dataMap.get("inpatientId") != null) {
			inpatientId = Integer.parseInt("" + dataMap.get("inpatientId"));
		}
		if (dataMap.get("admissionNo") != null) {
			admissionNo = ("" + dataMap.get("admissionNo"));
		}
		List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId))
				.list();
		List<Discharge> dischargeList = session.createCriteria(Discharge.class)
				.add(Restrictions.eq("AdNo", admissionNo)).list();
		List<DischargeIcdCode> dischargeIcdCodeList = session.createCriteria(DischargeIcdCode.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		map.put("inpatientList", inpatientList);
		map.put("dischargeList", dischargeList);
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		return map;
	}

	@SuppressWarnings("rawtypes")
	public Map<String, Object> updateDischarge(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside updateDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String[] diagnosidIdArray = null;
		String saved = "n";
		String dischargeDate = "";
		String dischargeTime = "";
		int dischargeId = 0;
		int inpatientId = 0;
		int hinId = 0;
		int userId = 0;
		int dId = 0;
		int dischargeNo = 0;
		List objectList2 = new ArrayList();
		String qry = "SELECT max(discharge_no) FROM discharge d";
		objectList2 = session.createSQLQuery(qry).list();
		if (objectList2.get(0) != null) {
			dischargeNo = 1 + Integer.parseInt("" + objectList2.get(0));
		}
		if (dataMap.get("userId") != null) {
			userId = Integer.parseInt("" + dataMap.get("userId"));
		}

		if (dataMap.get("dId") != null) {
			dId = Integer.parseInt("" + dataMap.get("dId"));
		}
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		if (dataMap.get("diagnosidIdArray") != null) {
			diagnosidIdArray = (String[]) dataMap.get("diagnosidIdArray");
		}
		if (dataMap.get("dischargeDate") != null) {
			dischargeDate = (String) dataMap.get("dischargeDate");
		}
		if (dataMap.get("dischargeTime") != null) {
			dischargeTime = (String) dataMap.get("dischargeTime");
		}
		if (dataMap.get("dischargeId") != null) {
			dischargeId = Integer.parseInt("" + dataMap.get("dischargeId"));
		}
		if (dataMap.get("inpatientId") != null) {
			inpatientId = Integer.parseInt("" + dataMap.get("inpatientId"));
		}
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String currentTime = (String) utilMap.get("currentTime");
		String date = (String) utilMap.get("currentDate");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = null;
		try {
			date4MySQL2 = formatterOut.format(formatterIn.parse(dischargeDate));
		} catch (ParseException e1) {
			LOGGER.error("ParseException Occurred while parsing dischargeDate : " + e1.getStackTrace().toString());
		}

		String curDate = null;
		try {
			curDate = formatterOut.format(formatterIn.parse(date));
		} catch (ParseException e) {
			LOGGER.error("ParseException Occurred while parsing date" + e.getStackTrace().toString());
		}
		String icdCode = "";
		try {

			if (dId == 0) {
				Discharge discharge = new Discharge();
				if (dataMap.get("discharge") != null) {
					discharge = (Discharge) dataMap.get("discharge");
				}
				discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL2));
				discharge.setTimeOfDischarge(dischargeTime);
				discharge.setAddEditDate(java.sql.Date.valueOf(curDate));
				discharge.setAddEditTime(currentTime);
				Users userObject2 = new Users();
				userObject2.setId(userId);
				discharge.setAddEditBy(userObject2);
				discharge.setDischargeNo(dischargeNo);
				hbt.save(discharge);
			} else {
				// Update Discharge, dischargeDate and dischargeTime
				Discharge discharge = hbt.load(Discharge.class, dischargeId);
				discharge.setDateOfDischarge(java.sql.Date.valueOf(date4MySQL2));
				discharge.setTimeOfDischarge(dischargeTime);
				discharge.setAddEditDate(java.sql.Date.valueOf(curDate));
				discharge.setAddEditTime(currentTime);
				Users userObject2 = new Users();
				userObject2.setId(userId);
				discharge.setAddEditBy(userObject2);
				hbt.update(discharge);
			}
			// Update Inpatient ListDate and listTime
			Inpatient inpatient = hbt.load(Inpatient.class, inpatientId);
			inpatient.setListDate(java.sql.Date.valueOf(date4MySQL2));
			inpatient.setListTime(dischargeTime);
			inpatient.setDischargeDate(java.sql.Date.valueOf(date4MySQL2));
			inpatient.setDischargeTime(dischargeTime);
			inpatient.setAddEditDate(java.sql.Date.valueOf(curDate));
			inpatient.setAddEditTime(currentTime);
			Users userObject3 = new Users();
			userObject3.setId(userId);
			inpatient.setAddEditBy(userObject3);
			hbt.update(inpatient);

			// Storing diagnosis in DichargeIcdCode
			if (diagnosidIdArray != null) {
				for (int i = 0; i < diagnosidIdArray.length; i++) {

					if (diagnosidIdArray[i].equals("") || diagnosidIdArray[i].equalsIgnoreCase("null")) {
						continue;
					}
					int index1 = diagnosidIdArray[i].lastIndexOf("[");
					int index2 = diagnosidIdArray[i].lastIndexOf("]");
					index1++;
					icdCode = "" + diagnosidIdArray[i].substring(index1, index2);
					String query = "select icd_id from mas_icd where icd_code='" + icdCode + "'";
					List objectList = session.createSQLQuery(query).list();
					int multiIcdId = (Integer.parseInt("" + objectList.get(0)));
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					if (hinId != 0) {
						Patient patient = new Patient();
						patient.setId(hinId);
						dischargeIcdCode.setHin(patient);
					}
					Inpatient inpatient2 = new Inpatient();
					inpatient2.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient2);
					dischargeIcdCode.setDiagnosisStatus("f");
					if (userId != 0) {
						Users userObject = new Users();
						userObject.setId(userId);
						dischargeIcdCode.setAddEditBy(userObject);
					}
					dischargeIcdCode.setAddEditDate(java.sql.Date.valueOf(curDate));
					dischargeIcdCode.setAddEditTime(currentTime);
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setIcd(new MasIcd(multiIcdId));
					dischargeIcdCode.setZ03("n");
					if (diagnosidIdArray[i].contains("{OLD}")) {
						dischargeIcdCode.setZ09("y");
					} else {
						dischargeIcdCode.setZ09("n");
					}
					hbt.save(dischargeIcdCode);
				}
			}
			saved = "y";
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getICDDetails(final Box box) {

		LOGGER.debug("Inside getICDDetails ");
		List<Object[]> masIcdList = new ArrayList<Object[]>();
		Map<String, Object> map = new HashMap<String, Object>();
		int searchopt = 0;
		try {
			String str = box.get("icd_name");
			if (!box.get("searchopt").equals("") && box.get("searchopt") != null) {
				searchopt = Integer.parseInt(box.get("searchopt"));
				if (searchopt == 1) {
					if (str != null && str.length() > 0) {
						str = "%" + str.replace(" ", "%") + "%";
					}
				}
			}

			Session session = getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (searchopt == 1) {
				String query = "select t1.icd_code,t1.icd_name,t1.snomed_concept_id,t2.term from mas_icd t1 left outer join sct2_description t2 on t1.snomed_concept_id = t2.conceptId where t1.icd_name like '"
						+ str + "'";
				masIcdList = session.createSQLQuery(query).list();
			}

			if (searchopt == 2) {
				String query = "select t1.icd_code,t1.icd_name,t1.snomed_concept_id,t2.term from mas_icd t1 left outer join sct2_description t2 on t1.snomed_concept_id = t2.conceptId where t1.icd_code='"
						+ str + "'";
				masIcdList = session.createSQLQuery(query).list();
			}

			LOGGER.debug("masIcdList=" + masIcdList.size());
			map.put("masIcdList", masIcdList);
		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBedStatus(final Box box, final int hospitalId) {

		LOGGER.debug("Inside getICDDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int deptId = box.getInt("wardId");
			Session session = getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String bedStatusUnOccupiedName = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
			} catch (IOException e) {
				LOGGER.error("IOException Occurred while loading adt.properties : " + e.getStackTrace().toString());
			}

			List<MasBed> masBedList = session.createCriteria(MasBed.class).createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("BedNo"))
					.createAlias("BedStatus", "bs").add(Restrictions.eq("bs.BedStatusCode", bedStatusUnOccupiedName))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase()).add(Restrictions.isNull("VBed"))
					.list();

			if (masBedList.size() == 0) {
				masBedList = session.createCriteria(MasBed.class).createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId)).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).addOrder(Order.asc("BedNo"))
						.createAlias("BedStatus", "bs")
						.add(Restrictions.eq("bs.BedStatusCode", bedStatusUnOccupiedName))
						.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
						.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
						.add(Restrictions.isNotNull("VBed")).list();
			}
			map.put("masBedList", masBedList);
		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> searchExpiryDetails(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside searchExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		String hinNo = "";
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";

		if (dataMap.get("serviceNo") != null) {
			serviceNo = (String) dataMap.get("serviceNo");
		}
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		if (dataMap.get("wardId") != null) {
			wardId = (Integer) dataMap.get("wardId");
		}
		if (dataMap.get("adNo") != null) {
			adNo = (String) dataMap.get("adNo");
		}
		List objectList = new ArrayList();
		String qry = "SELECT hin_id FROM expiry_details";
		objectList = session.createSQLQuery(qry).list();
		//
		Criteria crit = null;
		if (objectList.size() > 0) {
			crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeStatus.Id", 3))
					.add(Restrictions.not(Restrictions.in("Hin.Id", objectList)));
		} else {
			crit = session.createCriteria(Discharge.class).add(Restrictions.eq("DischargeStatus.Id", 3));
		}
		if (!adNo.equals("")) {
			crit = crit.add(Restrictions.eq("AdNo", adNo));
		}
		if (!serviceNo.equals("")) {
			crit = crit.createAlias("Hin", "hin");
			crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		if (wardId != 0) {
			crit = crit.createAlias("Ward", "dept").add(Restrictions.eq("dept.Id", wardId));
		}

		List<Discharge> dischargeList = crit.list();
		//
		map.put("dischargeList", dischargeList);
		return map;

	}

	@SuppressWarnings("deprecation")
	public Map<String, Object> printExpiryDetails(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside printExpiryDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();

		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientDischarge(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside searchPatientDischarge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonFName = "";
		String serPersonMName = "";
		String serPersonLName = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;

		if (dataMap.get("serviceNo") != null) {
			serviceNo = (String) dataMap.get("serviceNo");
		}
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		if (dataMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) dataMap.get("serviceTypeId");
		}
		if (dataMap.get("rankId") != null) {
			rankId = (Integer) dataMap.get("rankId");
		}
		if (dataMap.get("unitId") != null) {
			unitId = (Integer) dataMap.get("unitId");
		}
		if (dataMap.get("serPersonFName") != null) {
			serPersonFName = (String) dataMap.get("serPersonFName");
		}
		if (dataMap.get("serPersonMName") != null) {
			serPersonMName = (String) dataMap.get("serPersonMName");
		}
		if (dataMap.get("serPersonLName") != null) {
			serPersonLName = (String) dataMap.get("serPersonLName");
		}
		if (dataMap.get("patientFName") != null) {
			patientFName = (String) dataMap.get("patientFName");
		}
		if (dataMap.get("patientMName") != null) {
			patientMName = (String) dataMap.get("patientMName");
		}
		if (dataMap.get("patientLName") != null) {
			patientLName = (String) dataMap.get("patientLName");
		}
		if (dataMap.get("inpatientId") != null) {
			inpatientId = (Integer) dataMap.get("inpatientId");
		}
		if (dataMap.get("wardId") != null) {
			wardId = (Integer) dataMap.get("wardId");
		}
		if (dataMap.get("adNo") != null) {
			adNo = (String) dataMap.get("adNo");
		}
		List<String> objectList = new ArrayList<String>();
		objectList.add("D");
		objectList.add("R");
		Criteria crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", objectList));
		if (inpatientId == 0) {
			if (!adNo.equals("")) {
				crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			if (adNo.equals("")) {
				crit = crit.createAlias("Hin", "hin");
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PFirstName", patientFName + "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PMiddleName", patientMName + "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.PLastName", patientLName + "%"));
			}
			if (!serPersonFName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SFirstName", serPersonFName + "%"));
			}
			if (!serPersonMName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SMiddleName", serPersonMName + "%"));
			}
			if (!serPersonLName.equals("")) {
				crit = crit.add(Restrictions.like("hin.SLastName", serPersonLName + "%"));
			}
			if (serviceTypeId != 0) {
				crit = crit.createAlias("hin.ServiceType", "st").add(Restrictions.eq("st.Id", serviceTypeId));
			}
			if (rankId != 0) {
				crit = crit.createAlias("hin.Rank", "rank").add(Restrictions.eq("rank.Id", rankId));
			}
			if (unitId != 0) {
				crit = crit.createAlias("hin.Unit", "unit").add(Restrictions.eq("unit.Id", unitId));
			}
			if (wardId != 0) {
				crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
			}
		} else if (inpatientId != 0) {
			crit = crit.add(Restrictions.idEq(inpatientId));
		}

		List<Object> inPatientList = crit.list();
		map.put("inpatientList", inPatientList);
		return map;

	}

	@SuppressWarnings({ "unused", "rawtypes" })
	public Map<String, Object> checkCancelAdmissionState(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside checkCancelAdmissionState ");
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		String cancelState = "no";
		if (dataMap.get("inpatientId") != null) {
			inpatientId = Integer.parseInt("" + dataMap.get("inpatientId"));
		}
		Session session = getSession();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		String qry = "select date_of_addmission,DATE_ADD(inpatient.`date_of_addmission`,INTERVAL '1'DAY) from inpatient where inpatient_id ='"
				+ inpatientId + "';";
		List objectList = session.createSQLQuery(qry).list();

		// Current Date and Time
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4Cancel = "";
		try {
			date4Cancel = formatterOut.format(formatterIn.parse(currentDate));
		} catch (ParseException e) {
			LOGGER.error("ParseException Occurred while formatting date " + e.getStackTrace().toString());
		}
		int mm = 0;
		int hh = 0;
		int ss = 0;
		StringTokenizer str = new StringTokenizer(currentTime, ":");
		while (str.hasMoreTokens()) {
			hh = Integer.parseInt("" + str.nextToken());
			mm = Integer.parseInt("" + str.nextToken());
			ss = Integer.parseInt("" + str.nextToken());
		}
		String currAdDate = "";
		String nextAdDate = "";
		if (objectList.size() > 0) {
			for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				currAdDate = "" + object[0];
				nextAdDate = "" + object[1];
			}
		}
		if (date4Cancel.equals(currAdDate)) {
			cancelState = "yes";
		} else if (date4Cancel.equals(nextAdDate)) {
			if (hh < 2) {
				cancelState = "yes";
			}

		}
		map.put("cancelState", cancelState);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> checkOffLineAdNoDuplicationFor(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside checkOffLineAdNoDuplicationFor ");
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			String adNo = "";
			Session session = getSession();
			if (dataMap.get("adNo") != null) {
				adNo = "" + dataMap.get("adNo");
			}
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			inpatientList = session.createCriteria(Inpatient.class).add((Restrictions.eq("AdNo", adNo))).list();
			map.put("inpatientList", inpatientList);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeDetails(final int chargeTypeId) {

		LOGGER.debug("Inside getChargeCodeDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		try {
			List<MasChargeCode> chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeType.Id", chargeTypeId)).list();
			map.put("chargeCodeList", chargeCodeList);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParameterDetails(final int hospitalId) {

		LOGGER.debug("Inside getHospitalParameterDetails ");
		Session session = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<MasHospital> hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospitalId)).list();
			map.put("hospitalList", hospitalList);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMlcDetailsForUpdate(final Box box) {

		LOGGER.debug("Inside getMlcDetailsForUpdate ");
		Map<String, Object> map = new HashMap<String, Object>();
		String mlcNo = box.getString(MLC_NO);
		Session session = getSession();
		Criteria crit = session.createCriteria(MlcCase.class);
		if (!mlcNo.equals("")) {
			crit = crit.add(Restrictions.eq("MlcNo", mlcNo));
		}
		List<MlcCase> mlcCaseList = crit.list();
		map.put("mlcCaseList", mlcCaseList);

		return map;
	}

	public boolean updateMLCDetails(final Box box) {

		LOGGER.debug("Inside updateMLCDetails ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int mlcId = box.getInt("mlcId");
		MlcCase mlcCase = hbt.load(MlcCase.class, mlcId);

		if (box.getString(MLC_DATE).equals("")) {
			mlcCase.setMlcDate(HMSUtil.convertStringTypeDateToDateType(box.getString(MLC_DATE)));
		}
		mlcCase.setMlcTime(box.getString(MLC_TIME));
		mlcCase.setNatureOfMlc(box.getString(NATURE_OF_MLC));
		mlcCase.setInjuryType(box.getString(INJURY_TYPE));
		mlcCase.setSeverityOfInjury(box.getString(SEVERITY_OF_INJURY));
		mlcCase.setInjuryDimension(box.getString(INJURY_DIMENSION));
		if (box.getInt(INJURY_NATURE_ID) != 0) {
			MasInjuryNature injuryNature = new MasInjuryNature();
			injuryNature.setId(box.getInt(INJURY_NATURE_ID));
			mlcCase.setInjuryNature(injuryNature);
		}
		mlcCase.setInjuryDetails(box.getString(INJURY_DETAILS));
		mlcCase.setFirNo(box.getString(FIR_NO));
		mlcCase.setPoliceOfficer(box.getString(POLICE_OFFICER));
		mlcCase.setPoliceStation(box.getString(POLICE_STATION));
		mlcCase.setStatement(box.getString(STATEMENT));
		mlcCase.setBroughtBy(box.getString(BROUGHT_BY));
		mlcCase.setPatientCondition(box.getString(CONDITION));
		mlcCase.setWeaponUsed(box.getString(WEAPON_USED));
		mlcCase.setIncidentDate(HMSUtil.convertStringTypeDateToDateType(box.getString(INCIDENCE_DATE)));
		mlcCase.setIncidentTime(box.getString(INCIDENCE_TIME));
		mlcCase.setIncidentPlace(box.getString(INCIDENCE_PLACE));
		mlcCase.setTypeAndNoOfVehicle(box.getString(TYPE_AND_NO_OF_VEHICLE));
		mlcCase.setNameAndAddressOfDriver(box.getString(NAME_AND_ADDR_OF_DRIVER));
		mlcCase.setRemarks(box.getString(REMARKS));

		if (box.getInt(CONSULTING_DOCTOR) != 0) {
			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(CONSULTING_DOCTOR));
			mlcCase.setDoctor(employee);
		}
		if (box.getInt(BODY_PART_ID) != 0) {
			MasBodyPart bodyPart = new MasBodyPart();
			bodyPart.setId(box.getInt(BODY_PART_ID));
			mlcCase.setBodyPart(bodyPart);
		}

		mlcCase.setPatientRelation(box.getString("patientRelation"));
		Users user = new Users();
		int userId = box.getInt("userId");
		user.setId(userId);
		mlcCase.setAddEditBy(user);

		Date addEditDate = HMSUtil.convertStringTypeDateToDateType(box.getString(CHANGED_DATE));
		mlcCase.setAddEditDate(addEditDate);
		mlcCase.setAddEditTime(box.getString(CHANGED_TIME));

		boolean flag = false;
		try {
			hbt.update(mlcCase);
			flag = true;
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException Occurred" + e.getStackTrace().toString());
		}

		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showVillageWiseStaticsReportJsp(final Map<String, Object> mapDetails) {

		LOGGER.debug("Inside showVillageWiseStaticsReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		if (mapDetails.get("hospitalId") != null) {
			hospitalId = (Integer) mapDetails.get("hospitalId");
		}
		try {
			HospitalParameters hospitalParameters = new HospitalParameters();
			List<HospitalParameters> hospitalParametersList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.HospitalParameters as hp where hp.Hospital.Id='" + hospitalId + "'");

			if (hospitalParametersList != null && hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList.get(0);
			}
			map.put("hospitalParameters", hospitalParameters);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAppointmentPatientJsp() {

		LOGGER.debug("Inside showAppointmentPatientJsp ");
		Session session = getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
					.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 1)).list();

		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred : " + e.getStackTrace().toString());
		}
		map.put("departmentList", departmentList);

		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getListForDisease(final Map<String, Object> dataMap) {

		LOGGER.debug("Inside getListForDisease ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> itemList = new ArrayList<MasIcd>();
		
		try {
			Session session = getSession();
			String str = (String) dataMap.get("autoHint") + "%";
			Criteria c = session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName", str))
					.add(Restrictions.eq("Status", "y"));

			c.setFirstResult(0);
			c.setMaxResults(10);
			itemList = c.list();

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		map.put("itemList", itemList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDiseaseId(final String diseaseWise) {

		LOGGER.debug("Inside getDiseaseId ");
		Map<String, Object> map = new HashMap<String, Object>();
		int icdId2 = 0;
		try {
			Session session = getSession();
			List<MasIcd> itemList = session.createCriteria(MasIcd.class).add(Restrictions.like("IcdName", diseaseWise))
					.list();

			if (itemList.size() > 0) {
				MasIcd masIcd = new MasIcd();
				masIcd = itemList.get(0);
				icdId2 = masIcd.getId();
				map.put("icd_id2", icdId2);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAdmissionNoListIpId(final int inpatientId) {

		LOGGER.debug("Inside getAdmissionNoListIpId ");
		String adNo = "";
		try {
			Session session = getSession();
			List<Inpatient> inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
			if (inpatientList.size() > 0) {
				for (Inpatient ip : inpatientList) {
					adNo = ip.getAdNo();
				}
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return adNo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientDetailsForDischargeForWard(final int inpatientId) {

		LOGGER.debug("Inside getPatientDetailsForDischargeForWard ");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Session session = getSession();
			List<Object[]> inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
			if (inpatientList.size() > 0) {
				map.put("inpatientList", inpatientList);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updatePatient(final int inpatientId) {

		LOGGER.debug("Inside updatePatient ");
		boolean updatePatient = false;
		try {
			Session session = getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.like("Id", inpatientId)).list();
			if (inpatientList.size() > 0) {
				int hinId = 0;
				for (Inpatient ip : inpatientList) {
					hinId = ip.getHin().getId();
				}
				List<Patient> patietList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
				for (Patient pt : patietList) {
					pt.setStatus("n");
					hbt.update(pt);
				}

			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return updatePatient;
	}

	// Done By Awadhesh
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAdmissionPatientDetail(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getAdmissionPatientDetail ");
		String hinNo = "";
		String patientFName = "";
		String mobileNo = "";
		String ipNumber = "";
		int doctorId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int departmentId = 0;
		int admDepartmentId = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}

		if (mapForDs.get("mobileNo") != null) {
			mobileNo = (String) mapForDs.get("mobileNo");
		}
		if (mapForDs.get("doctorId") != null) {
			doctorId = (Integer) mapForDs.get("doctorId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("ipNumber") != null) {
			ipNumber = (String) mapForDs.get("ipNumber");
		}

		if (mapForDs.get("admDepartmentId") != null) {
			admDepartmentId = (Integer) mapForDs.get("admDepartmentId");
		}

		Criteria crit = session.createCriteria(Inpatient.class, "inpatient")

		.createAlias("inpatient.Hin", "patient").add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("AdStatus", "A".toUpperCase()).ignoreCase())
				.add(Restrictions.eq("inpatient.Hospital.Id", hospitalId));

		if (hinNo != null && !hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("inpatient.HinNo", hinNo));
		}
		if (ipNumber != null && !ipNumber.equals("")) {
			crit = crit.add(Restrictions.eq("inpatient.AdNo", ipNumber));
			LOGGER.debug(".....TTTTTTTTTT" + ipNumber + ",." + crit.list().size());
		}
		if (patientFName != null && !patientFName.equals("")) {
			patientFName = patientFName.replaceAll("  ", "");
			patientFName.trim();
			patientFName = patientFName.replaceAll(" ", "%").toLowerCase();
			crit = crit.add(Restrictions.like("patient.FullName", "%" + patientFName + "%").ignoreCase());

		}
		if (mobileNo != null && !mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("patient.MobileNumber", mobileNo));
		}
		if (doctorId != 0) {
			crit = crit.add(Restrictions.eq("patient.Employee.Id", doctorId));
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("patient.Id", hinId));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("patient.AdWard.DepartmentCode", departmentId));
		}

		if (admDepartmentId != 0) {
			crit = crit.createAlias("visit.Department", "visitDept").add(
					Restrictions.eq("visitDept.Id", admDepartmentId));
		}

		List<Inpatient> inpatientList = crit.list();
		map.put("patientList", inpatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailIpPatientView(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getDetailIpPatientView ");
		int hospitalId = 0;
		int inpId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRelation> relationList = new ArrayList<>();
		Session session = getSession();

		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("InpId") != null) {
			inpId = (Integer) mapForDs.get("InpId");
		}
		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationCode"))
				.add(Restrictions.eq("Status", "Y")
						.ignoreCase()).list();

		Criteria crit = session.createCriteria(Inpatient.class, "inpatient").createAlias("Hin", "patient")
				.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Id", inpId));

		List<Inpatient> inpatientList = crit.list();
		map.put("relationList", relationList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	// created by mritunjay Kumar Singh on 13/03/2015

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getDetailsForPatientAdission(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside getDetailsForPatientAdission ");
		String hinNo = "";
		String patientFName = "";
		String mobileNo = "";
		int doctorId = 0;
		int hospitalId = 0;
		int hinId = 0;
		int departmentId = 0;
		int admDepartmentId = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		List<Patient> patientBabyAdmissionWaitingList = new ArrayList<Patient>();
		List<DialysisSchudeling> dialysisSchedulingList = new ArrayList<DialysisSchudeling>();
		List<OpdPatientDetails> patientList = new ArrayList<OpdPatientDetails>();

		int departmentTpeId = 0;

		Session session = getSession();
		Criteria crit = null;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}

		if (mapForDs.get("mobileNo") != null) {
			mobileNo = (String) mapForDs.get("mobileNo");
		}
		if (mapForDs.get("doctorId") != null) {
			doctorId = (Integer) mapForDs.get("doctorId");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("admDepartmentId") != null) {
			admDepartmentId = (Integer) mapForDs.get("admDepartmentId");
		}
		String flag = "";
		if (mapForDs.get("flag") != null) {
			flag = (String) mapForDs.get("flag");
		}
		String babyHin = "";
		if (mapForDs.get("babyHin") != null) {
			babyHin = (String) mapForDs.get("babyHin");
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String empCategoryCodeForDoctor = "";
		String depTypeCodeDialysis = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			depTypeCodeDialysis = prop.getProperty("depTypeCodeDialysis");
			departmentTpeId = Integer.parseInt(prop.getProperty("departmentTpeId"));
			empCategoryCodeForDoctor = prop.getProperty("empCategoryCodeForDoctor");
		} catch (IOException e) {
			LOGGER.error("IOException Occurred while loading adt.properties" + e.getStackTrace().toString());
		}

		Calendar now = Calendar.getInstance();
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		String dayName = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];

		List<Inpatient> inpatientListForDialysis = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("DateOfAddmission", new Date())).createAlias("Department", "dept")
				.createAlias("dept.DepartmentType", "deptType")
				.add(Restrictions.eq("deptType.DepartmentTypeCode", depTypeCodeDialysis)).list();
		List hinIdList = new ArrayList();
		if (inpatientListForDialysis.size() > 0) {
			int hinIdForDia = 0;
			for (Inpatient inpatient : inpatientListForDialysis) {
				hinIdForDia = inpatient.getHin().getId();
				hinIdList.add(hinIdForDia);

			}
		}
		Criteria crt = null;

		if (hinIdList.size() > 0) {
			crt = session.createCriteria(DialysisSchudeling.class).createAlias("Hin", "hin")
					.add(Restrictions.not(Restrictions.in("hin.Id", hinIdList)))
					.add(Restrictions.eq("AppointmentDays", dayName)).add(Restrictions.eq("Hospital.Id", hospitalId));
			if (hinId != 0) {
				crt = crt.add(Restrictions.eq("hin.Id", hinId));
			}
			dialysisSchedulingList = crt.list();
		} else {
			crt = session.createCriteria(DialysisSchudeling.class).add(Restrictions.eq("AppointmentDays", dayName))
					.add(Restrictions.eq("Hospital.Id", hospitalId));
			if (hinId != 0) {
				crt = crt.createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId));
			}
			dialysisSchedulingList = crt.list();
		}

		List<Patient> patientBabyList = new ArrayList<Patient>();
		if (hinId != 0) {
			patientBabyList = session.createCriteria(Patient.class).add(Restrictions.idEq(hinId)).list();
		}

		List<Patient> directPatientBabyList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("RegDate", HMSUtil.getDateWithoutTime(new Date())))
				.add(Restrictions.isNotNull("MotherHinNo")).add(Restrictions.ne("MotherHinNo", ""))
				.add(Restrictions.eq("PatientStatus", "Out Patient")).list();

		LOGGER.debug("directPatientBabyList---" + directPatientBabyList.size());

		List<String> hinNoList = new ArrayList<String>();

		StringTokenizer str = new StringTokenizer(babyHin, ",");
		while (str.hasMoreTokens()) {
			hinNoList.add(str.nextToken().trim());

		}
		if (flag.equals("b") && hinNoList.size() > 0) {
			patientBabyAdmissionWaitingList = session.createCriteria(Patient.class)
					.add(Restrictions.in("HinNo", hinNoList)).list();
		} else {
			List<OpdPatientDetails> opdPatientDetilsList = session
					.createCriteria(OpdPatientDetails.class, "opdpatientdetails")
					.createAlias("opdpatientdetails.Visit", "visit").createAlias("visit.Hin", "hin")
					.add(Restrictions.eq("opdpatientdetails.AdmissionAdvised", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("opdpatientdetails.Hospital.Id", hospitalId))
					.add(Restrictions.eq("opdpatientdetails.AdmissionDate", HMSUtil.getDateWithoutTime(new Date())))
					.list();
			Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");

			if (opdPatientDetilsList.size() > 0) {
				for (OpdPatientDetails opdPatientDetails : opdPatientDetilsList) {
					String time = currentTime;
					if (opdPatientDetails.getOpdTime() != null) {
						LOGGER.debug(opdPatientDetails.getVisit().getHin().getHinNo());
						time = opdPatientDetails.getOpdTime();
					}
					String opdDate = HMSUtil.convertDateToStringWithoutTime(opdPatientDetails.getOpdDate()) + " "
							+ time;
					String curDate = currentDate + " " + currentTime;
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
					Date d1 = null;
					Date d2 = null;
					try {
						d1 = format.parse(opdDate);
						d2 = format.parse(curDate);
					} catch (ParseException e) {
						LOGGER.error("ParseException Occurred while parsing the date " + e.getStackTrace().toString());
					}
					long diff = d2.getTime() - d1.getTime();
					long diffHours = diff / (60 * 60 * 1000);
					if (diffHours > 24) {
						OpdPatientDetails patientDetails = hbt.load(OpdPatientDetails.class, opdPatientDetails.getId());
						patientDetails.setAdmissionAdvised("No Show");
						hbt.update(patientDetails);

					} else {

						crit = session
								.createCriteria(OpdPatientDetails.class, "opdpatientdetails")
								.createAlias("opdpatientdetails.Visit", "visit")
								.createAlias("visit.Hin", "hin")
								.add(Restrictions.eq("opdpatientdetails.AdmissionAdvised", "y".toLowerCase())
										.ignoreCase())
								.add(Restrictions.eq("opdpatientdetails.Hospital.Id", hospitalId))
								.add(Restrictions.eq("opdpatientdetails.AdmissionDate",
										HMSUtil.getDateWithoutTime(new Date())));

						if (hinNo != null && !hinNo.equals("")) {
							crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
						}
						if (patientFName != null && !patientFName.equals("")) {
							patientFName = patientFName.replaceAll("  ", "");
							patientFName.trim();
							patientFName = patientFName.replaceAll(" ", "%").toLowerCase();
							Criterion rest1 = Restrictions.or(
									Restrictions.like("hin.PFirstName", "%" + patientFName + "%").ignoreCase(),
									Restrictions.like("hin.PMiddleName", "%" + patientFName + "%").ignoreCase());
							rest1 = Restrictions.or(rest1, Restrictions.like("hin.PLastName", "%" + patientFName + "%")
									.ignoreCase());
							crit = crit.add(rest1);
						}
						if (mobileNo != null && !mobileNo.equals("")) {
							crit = crit.add(Restrictions.eq("hin.MobileNumber", mobileNo));
						}
						if (doctorId != 0) {
							crit = crit.add(Restrictions.eq("opdpatientdetails.Employee.Id", doctorId));
						}

						if (hinId != 0) {
							crit = crit.add(Restrictions.eq("hin.Id", hinId));
						}
						if (departmentId != 0) {
							crit = crit.add(Restrictions.eq("AdmissionWard.Id", departmentId));
						}

						if (admDepartmentId != 0) {
							crit = crit.createAlias("visit.Department", "visitDept").add(
									Restrictions.eq("visitDept.Id", admDepartmentId));
						}
						patientList = crit.list();
						
						if(patientList.size() > 0) {
							for(OpdPatientDetails opd : patientList) {
								hinIdList.add(opd.getVisit().getHin().getId());
							}
						}
						
					}
				}
			}
		}

		List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department")).add(Restrictions.eq("Institute.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id", departmentTpeId))
				.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName")).list();

		List<Object[]> doctorList = session
				.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("EmpCategory", "ec")
				.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("FirstName"))
				.setProjection(
						Projections.projectionList().add(Projections.property("Id"))
								.add(Projections.property("FirstName")).add(Projections.property("MiddleName"))
								.add(Projections.property("LastName"))).addOrder(Order.asc("FirstName")).list();

		List<MasPatientType> patientTypeForSocialCategory = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Type", "s").ignoreCase()).list();

		List<MasPatientType> patientTypeForOtherCategory = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Type", "o").ignoreCase()).list();

		List<MasDepartment> masDepartments = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("DepartmentType", "Type")
				.add(Restrictions.eq("Type.DepartmentTypeCode", "WARD").ignoreCase()).list();

		List<MasDepartment> referringDepartment = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("DepartmentType", "Type")
				.add(Restrictions.eq("Type.Id", 1)).list();
		// added by dhananjay 27-09-2016
		List<Patient> ipPatientList = new ArrayList<Patient>();
		boolean status = false;
		if (departmentId == 0 && admDepartmentId == 0 && doctorId == 0) {
			Criteria searchCriteia = session.createCriteria(Patient.class).add(
					Restrictions.eq("PatientStatus", "Out Patient").ignoreCase());
			if(hinIdList.size()>0) {
				searchCriteia.add(Restrictions.not(Restrictions.in("Id", hinIdList)));
			}
			if (hinNo != null && !hinNo.equals("")) {
				searchCriteia = searchCriteia.add(Restrictions.eq("HinNo", hinNo));
				status = true;
			}
			if (patientFName != null && !patientFName.equals("")) {

				searchCriteia = searchCriteia.add(Restrictions.like("PFirstName", "%" + patientFName + "%").ignoreCase());
				status = true;
			}
			if (mobileNo != null && !mobileNo.equals("")) {
				searchCriteia = searchCriteia.add(Restrictions.eq("MobileNumber", mobileNo));
				status = true;
			}
			if (hinId != 0) {
				searchCriteia = searchCriteia.add(Restrictions.eq("Id", hinId));
				status = true;
			}
			if (status) {
				ipPatientList = searchCriteia.list();
			}
		}
		// end
		map.put("patientList", patientList);
		map.put("patientBabyAdmissionWaitingList", patientBabyAdmissionWaitingList);
		map.put("doctorList", doctorList);
		map.put("patientTypeForSocialCategory", patientTypeForSocialCategory);
		map.put("patientTypeForOtherCategory", patientTypeForOtherCategory);
		map.put("masDepartments", masDepartments);
		map.put("referringDepartment", referringDepartment);
		map.put("dialysisSchedulingList", dialysisSchedulingList);
		map.put("patientBabyList", patientBabyList);
		map.put("ipPatientList", ipPatientList);
		map.put("directPatientBabyList", directPatientBabyList);
		map.put("departmentList", departmentList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMLCNoList(final Map<String, Object> detailsMap) {

		LOGGER.debug("Inside getMLCNoList ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
		Session session = getSession();

		session = getSession();
		String hinNo = "";

		try {
			if (detailsMap.get("hinNo") != null) {
				hinNo = (String) detailsMap.get("hinNo");
			}

			if (hinNo != "") {
				mlcCaseList = session.createCriteria(MedicoLegalDetails.class).createAlias("Hin", "h")
						.add(Restrictions.eq("h.HinNo", hinNo)).list();
				LOGGER.debug("mlcCaseList==" + mlcCaseList.size());
			}

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}

		map.put("mlcCaseList", mlcCaseList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMedicoLegalCaseDetailsNew(final Map<String, Object> mapForDs) {

		LOGGER.debug("Inside showMedicoLegalCaseDetailsNew ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		int inpId = 0;
		if (mapForDs.get("inpId") != null) {
			inpId = (Integer) mapForDs.get("inpId");
		}

		int visitId = 0;
		if (mapForDs.get("visitId") != null) {
			visitId = (Integer) mapForDs.get("visitId");
		}
		if (inpId != 0) {
			List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpId))
					.list();
			map.put("inpatientList", inpatientList);
		}
		if (visitId != 0) {
			List<Visit> visitList = session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
			map.put("visitList", visitList);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> displayUnitHeadName(final Box box) {

		LOGGER.debug("Inside displayUnitHeadName ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<HospitalDoctorUnitT> hospitalUnitTList = session.createCriteria(HospitalDoctorUnitT.class)
				.createAlias("UnitM", "unitM").add(Restrictions.eq("unitM.Id", box.getInt("hospitalUnitId")))
				.add(Restrictions.eq("HeadFleg", "y").ignoreCase()).list();
		map.put("hospitalUnitTList", hospitalUnitTList);
		return map;
	}

	@Override
	public boolean checkBedStatus(final int bedId) {

		LOGGER.debug("Inside checkBedStatus ");
		boolean succesfullyAdded = false;
		try {
			Session session = getSession();
			String bedStatusUnOccupiedName = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
			} catch (IOException e) {
				LOGGER.error("IOException Occurred while loading adt.properties" + e.getStackTrace().toString());
			}

			MasBed masbed = (MasBed) session.createCriteria(MasBed.class, "mbed")
					.createAlias("mbed.BedStatus", "bstatus").add(Restrictions.eq("Id", bedId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("bstatus.BedStatusCode", bedStatusUnOccupiedName).ignoreCase()).uniqueResult();
			if (masbed != null) {
				succesfullyAdded = true;
			}

		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred " + e.getStackTrace().toString());
		}

		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIpNo(final Map<String, Object> details) {

		LOGGER.debug("Inside getIpNo ");
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = getSession();
		String hinNo = "";
		if (details.get("hinNo") != null) {
			hinNo = (String) details.get("hinNo");
		}

		try {
			Criteria crit = session.createCriteria(MedicoLegalDetails.class);
			if (!hinNo.equals("")) {
				crit = crit.createAlias("Hin", "p").add(Restrictions.eq("p.HinNo", hinNo));
			}

			List<MedicoLegalDetails> mlcNoList = crit.list();
			map.put("mlcNoList", mlcNoList);
		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred " + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> checkMotherDetail(final Box box) {

		LOGGER.debug("Inside checkMotherDetail ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		List<Patient> patientList = session.createCriteria(Patient.class).createAlias("Sex", "sex")
				.add(Restrictions.eq("sex.Id", 2)).add(Restrictions.eq("HinNo", box.getString("hinNo"))).list();
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> updateWoundCertificateStatus(final Box box) {

		LOGGER.debug("Inside updateWoundCertificateStatus ");
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		List<MedicoLegalDetails> medicoLegalList = session.createCriteria(MedicoLegalDetails.class)
				.createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo", box.getString("hinNo"))).list();
		int medicoId = 0;
		if (medicoLegalList.size() > 0) {
			medicoId = medicoLegalList.get(0).getId();

			LOGGER.debug("medicoId : " + medicoId);
			MedicoLegalDetails medicoLegalDetails = hbt.load(MedicoLegalDetails.class, medicoId);
			medicoLegalDetails.setIssueToPatient("y");
			hbt.update(medicoLegalDetails);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveObject(final Map<String, Object> dataMap, final Box box) {

		LOGGER.debug("Inside saveObject ");
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		Session session = getSession();
		String data = "";
		String bedMessage = "";
		Message hl7Message = null;
		try {
			if (box.get("message") != null) {
				data = box.get("message");
				data = data.replace("$", "&");
				data = data.replaceAll("#", "\r");
				Parser parser = new PipeParser();
				hl7Message = parser.parse(data);

			}
			if (box.get("bed") != null) {
				bedMessage = box.get("bed");
			}
			Inpatient inpatientObj = new Inpatient();
			String hinNo = null;
			if (hl7Message != null) {

				ORM_O01 ormO01 = (ORM_O01) hl7Message;
				PID pid = ormO01.getPATIENT().getPID();
				PV1 pv1 = ormO01.getPATIENT().getPV1();
				OBR obr = ormO01.getORDER().getORDER_DETAIL().getOBR();
				ORC orc = ormO01.getORDER().getORC();
				if (pv1.getPv138_DietType().getValue() != null) {
					MasDepartment department = new MasDepartment(Integer.parseInt(pv1.getPv138_DietType().getValue()));
					inpatientObj.setDepartment(department);
				}

				if (pv1.getPv115_AmbulatoryStatus(0).getValue() != null) {
					inpatientObj.setRemarks(pv1.getPv115_AmbulatoryStatus(0).getValue());
				}

				if (obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue() != null) {
					inpatientObj.setStatus(obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue());
				}

				if (pid.getPid22_EthnicGroup().getValue() != null) {
					inpatientObj.setAdStatus(pid.getPid22_EthnicGroup().getValue());
				}

				if (pv1.getPv128_InterestCode().getValue() != null) {
					inpatientObj.setAdNoType(pv1.getPv128_InterestCode().getValue());
				}
				if (pv1.getPv131_BadDebtAgencyCode().getValue() != null) {
					inpatientObj.setAttachedPatient(pv1.getPv131_BadDebtAgencyCode().getValue());
				}

				if (pv1.getPv150_AlternateVisitID().getCm_pat_id_01921_IDNumber().getValue() != null) {
					inpatientObj.setContactNo(pv1.getPv150_AlternateVisitID().getCm_pat_id_01921_IDNumber().getValue());
				}

				if (pv1.getPv111_TemporaryLocation().getCm_internal_location3_Bed().getValue() != null) {
					inpatientObj.setAddress(pv1.getPv111_TemporaryLocation().getCm_internal_location3_Bed().getValue());
				}

				if (pv1.getPv129_TransferToBadDebtCode().getValue() != null) {
					inpatientObj.setCriticalCondition(pv1.getPv129_TransferToBadDebtCode().getValue());
				}

				if (pv1.getPv117_AdmittingDoctor().getCn1_IDNumber().getValue() != null) {
					inpatientObj.setMlc(pv1.getPv117_AdmittingDoctor().getCn1_IDNumber().getValue());
				}

				if (pv1.getPv15_PreadmitNumber().getValue() != null) {
					inpatientObj.setDependentName(pv1.getPv15_PreadmitNumber().getValue());
				}
				if (obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId().getValue() != null) {
					Users users = new Users(Integer.parseInt(obr.getObr3_FillerOrderNumber()
							.getCm_filler1_UniqueFillerId().getValue()));
					inpatientObj.setAddEditBy(users);
				}
				if (pv1.getPv143_PriorTemporaryLocation().getCm_internal_location3_Bed().getValue() != null) {
					MasPatientCategory category = new MasPatientCategory(Integer.parseInt(pv1
							.getPv143_PriorTemporaryLocation().getCm_internal_location3_Bed().getValue()));
					inpatientObj.setPatientCategory(category);
				}
				if (pv1.getPv124_ContractCode(0).getValue() != null) {
					MasRelation masRelation = new MasRelation(Integer.parseInt(pv1.getPv124_ContractCode(0).getValue()));
					inpatientObj.setRelation(masRelation);
				}
				if (pv1.getPv134_DeleteAccountIndicator().getValue() != null) {
					MasDepartment dep = new MasDepartment(Integer.parseInt(pv1.getPv134_DeleteAccountIndicator()
							.getValue()));
					inpatientObj.setAdWard(dep);
				}
				// commented by amit das on 02-05-2017
				if (pv1.getPv121_ChargePriceIndicator().getValue() != null) { // added
																				// by
																				// amit
																				// das
																				// on
																				// 02-05-2017
					HospitalDoctorUnitM doctorUnitM = new HospitalDoctorUnitM(Integer.parseInt(pv1
							.getPv121_ChargePriceIndicator().getValue()));
					inpatientObj.setUnitM(doctorUnitM);
				}
				if (pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue() != null) {
					inpatientObj.setDateOfAddmission(HMSUtil.convertStringyyyyMMddTypeToDateType(pv1
							.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue()));
				}
				inpatientObj.setTimeOfAddmission(pid.getPid19_SocialSecurityNumberPatient().getValue());
				if (orc.getOrc10_EnteredBy().getCn1_IDNumber().getValue() != null) {
					inpatientObj.setListDate(HMSUtil.convertStringyyyyMMddTypeToDateType(orc.getOrc10_EnteredBy()
							.getCn1_IDNumber().getValue()));
				}
				if (obr.getObr23_ChargeToPractice().getCm_moc1_DollarAmount().getValue() != null) {
					MasAdmissionType admissionType = new MasAdmissionType(Integer.parseInt(obr
							.getObr23_ChargeToPractice().getCm_moc1_DollarAmount().getValue()));
					inpatientObj.setAdmissionType(admissionType);

				}
				if (pv1.getPv148_TotalAdjustments().getValue() != null) {
					inpatientObj.setAdNo(pv1.getPv148_TotalAdjustments().getValue());
				}
				if (obr.getObr1_SetIDObservationRequest().getValue() != null) {
					MasEmployee employee = new MasEmployee(Integer.parseInt(obr.getObr1_SetIDObservationRequest()
							.getValue()));
					inpatientObj.setDoctor(employee);
				}

				MasBed bed = null;
				String[] bedDetail = bedMessage.split("\\|");
				if (bedDetail.length > 4) {
					bed = (MasBed) session.get(MasBed.class, Integer.parseInt(bedDetail[0]));

					MasBed bedforIp = new MasBed(Integer.parseInt(bedDetail[0]));
					inpatientObj.setBed(bedforIp);
					inpatientObj.setAdStatus("A");
					DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
					try {
						Date dateForAdmission = formatter.parse(bedDetail[2]);
						inpatientObj.setBedAllocationDate(dateForAdmission);
					} catch (ParseException e) {
						LOGGER.error("Exception Occurred while parsing date" + e.getStackTrace().toString());
					}
					inpatientObj.setBedAllocationTime(bedDetail[3]);
					MasBedStatus bedStatus = (MasBedStatus) session.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("BedStatusCode", bedDetail[4])).uniqueResult();
					if (bed != null && bedStatus != null) {
						bed.setBedStatus(bedStatus);
					}
				}

				inpatientObj.setAddEditTime(pv1.getPv18_ReferringDoctor().getCn4_MiddleInitialOrName().getValue());
				inpatientObj.setListTime(pv1.getPv140_BedStatus().getValue());
				MasHospital hospital = new MasHospital(hospitalId);
				inpatientObj.setHospital(hospital);

				// *********patient***********
				hinNo = pid.getPid2_PatientIDExternalID().getCk1_IDNumber().getValue();

				LOGGER.debug("**************************************" + hinNo
						+ "**************************************************");

				Patient patientObj = (Patient) session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).uniqueResult();
				if (pv1.getPv119_VisitNumber() != null && pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber() != null
						&& pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue() != null) {
					patientObj.setPatientStatus(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue());
				}
				if (pid.getPid20_DriverSLicenseNumberPatient().getLicenseNumber().getValue() != null) {
					patientObj.setAb64Available(pid.getPid20_DriverSLicenseNumberPatient().getLicenseNumber()
							.getValue());
				}

				if (pid.getPid18_PatientAccountNumber().getCheckDigit().getValue() != null) {
					MasPatientType patientType = new MasPatientType(Integer.parseInt(pid
							.getPid18_PatientAccountNumber().getCheckDigit().getValue()));
					patientObj.setPatientType(patientType);
				}
				if (pid.getPid8_Sex().getValue() != null) {
					patientObj.setPastDue(pid.getPid8_Sex().getValue());
				}

				if (pid.getPid25_BirthOrder().getValue() != null
						&& pid.getPid25_BirthOrder().getValue().equalsIgnoreCase("1")) {
					patientObj.setBplStatus("y");
				} else {
					patientObj.setBplStatus("n");
				}

				patientObj.setHinNo(pid.getPid2_PatientIDExternalID().getCk1_IDNumber().getValue());

				Criteria crit = session.createCriteria(OpdPatientDetails.class, "opdpatientdetails")
						.createAlias("opdpatientdetails.Visit", "visit").createAlias("visit.Hin", "hin")
						.add(Restrictions.eq("opdpatientdetails.AdmissionAdvised", "y".toLowerCase()).ignoreCase())
						.add(Restrictions.eq("opdpatientdetails.Hospital.Id", hospitalId))
						.add(Restrictions.eq("opdpatientdetails.AdmissionDate", inpatientObj.getDateOfAddmission()))
						.add(Restrictions.eq("hin.HinNo", hinNo));

				List<OpdPatientDetails> details = crit.list();
				if (details != null && details.size() > 0) {
					inpatientObj.setOpdPatientDetails(details.get(0));
				}
				inpatientObj.setHin(patientObj);
				inpatientObj.setHinNo(hinNo);
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				int id = 0;
				int tsn = 0;
				List<TransactionSequence> adList =  session.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "AD".toLowerCase()).ignoreCase()).list();
				for (TransactionSequence transactionSequence : adList) {
					tsn = Integer.parseInt("" + transactionSequence.getTransactionSequenceNumber());
					id = Integer.parseInt("" + transactionSequence.getId());
				}
				int actualTsnNumber = 0;
				if (tsn > Integer.parseInt(inpatientObj.getAdNo())) {
					actualTsnNumber = tsn;
				} else {
					actualTsnNumber = Integer.parseInt(inpatientObj.getAdNo()) + 1;
				}
				TransactionSequence transactionSequenceObj = hbt.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(actualTsnNumber);
				hbt.update(transactionSequenceObj);
				hbt.saveOrUpdate(inpatientObj);
				hbt.saveOrUpdate(patientObj);
				if (bed != null) {
					hbt.saveOrUpdate(bed);
				}
				hbt.flush();
				hbt.clear();
				map.put("success", "success");

			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}

		return map;
	}

	private Map<String, Object> hl7MessageForIpAdmission(final Map<String, Object> map) {

		LOGGER.debug("Inside hl7MessageForIpAdmission ");
		Map<String, Object> dataMap = new HashMap<String, Object>();

		try {
			Inpatient inpatient = (Inpatient) map.get("inpatient");
			Patient patient = (Patient) map.get("patient");
			MasHospital hospital = (MasHospital) map.get("hospital");
			ORM_O01 ormO01 = new ORM_O01();
			ORU_R01 message = new ORU_R01();
			message.getMSH().getEncodingCharacters().setValue("^~\\&");
			message.getMSH().getFieldSeparator().setValue("|");
			MSH mshSegment = ormO01.getMSH();
			mshSegment.getMsh1_FieldSeparator().setValue("|");
			mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
			mshSegment.getMsh3_SendingApplication().setValue("INSTAPACS");
			mshSegment.getMsh4_SendingFacility().setValue("");
			mshSegment.getMsh5_ReceivingApplication().setValue("HMS");
			mshSegment.getMsh6_ReceivingFacility().setValue("");
			// // commented by amit das on 04-08-2016
			mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent()
					.setValue(HMSUtil.now("yyyyMMdd") + HMSUtil.now("HHmmss")); // added
																				// by
																				// amit
																				// das
																				// on
																				// 04-08-2016
			mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ORM");
			mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("O01");
			mshSegment.getMsh11_ProcessingID().setValue("P");
			mshSegment.getMsh12_VersionID().setValue("2.2");

			// patient detail
			PID pid = ormO01.getPATIENT().getPID();
			// visit detail
			PV1 pv1 = ormO01.getPATIENT().getPV1();
			// observation
			OBR obr = ormO01.getORDER().getORDER_DETAIL().getOBR();
			// phramacy request
			ORC orc = ormO01.getORDER().getORC();
			// billing
			if (inpatient != null & patient != null) {
				// ************Inpatient************//
				pv1.getPv138_DietType().setValue(inpatient.getDepartment().getId() + "");
				pv1.getPv115_AmbulatoryStatus(0).setValue(inpatient.getRemarks());
				obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().setValue(inpatient.getStatus());
				pid.getPid22_EthnicGroup().setValue(inpatient.getAdStatus());
				pv1.getPv128_InterestCode().setValue(inpatient.getAdNoType());
				pv1.getPv131_BadDebtAgencyCode().setValue(inpatient.getAttachedPatient());
				pv1.getPv150_AlternateVisitID().getCm_pat_id_01921_IDNumber().setValue(inpatient.getContactNo());
				pv1.getPv111_TemporaryLocation().getCm_internal_location3_Bed().setValue(inpatient.getAddress());
				pv1.getPv129_TransferToBadDebtCode().setValue(inpatient.getCriticalCondition());
				pv1.getPv117_AdmittingDoctor().getCn1_IDNumber().setValue(inpatient.getMlc());
				pv1.getPv15_PreadmitNumber().setValue(inpatient.getDependentName());
				obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId()
						.setValue(inpatient.getAddEditBy().getId() + "");
				if (inpatient.getOpdPatientDetails() != null) {
					pv1.getPv139_ServicingFacility().setValue(inpatient.getOpdPatientDetails().getId() + "");
				}
				if (inpatient.getPatientCategory() != null) {
					pv1.getPv143_PriorTemporaryLocation().getCm_internal_location3_Bed()
							.setValue(inpatient.getPatientCategory().getId() + "");
				}
				if (inpatient.getRelation() != null) {
					pv1.getPv124_ContractCode(0).setValue(inpatient.getRelation().getId() + "");
				}
				if (inpatient.getAdWard() != null) {
					pv1.getPv134_DeleteAccountIndicator().setValue(inpatient.getAdWard().getId() + "");
				}
				if (inpatient.getUnitM() != null) {
					pv1.getPv121_ChargePriceIndicator().setValue(inpatient.getUnitM().getId() + ""); // changed
																										// by
																										// amit
																										// das
																										// on
																										// 02-05-2017
				}
				if (inpatient.getAdmissionType() != null) {
					obr.getObr23_ChargeToPractice().getCm_moc1_DollarAmount()
							.setValue(inpatient.getAdmissionType().getId() + "");
				}
				if (inpatient.getAdNo() != null) {
					pv1.getPv148_TotalAdjustments().setValue(inpatient.getAdNo() + "");
				}
				if (inpatient.getDoctor() != null) {
					obr.getObr1_SetIDObservationRequest().setValue(inpatient.getDoctor().getId() + "");
				}

				pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().setValue(inpatient.getDateOfAddmission() + "");
				pid.getPid19_SocialSecurityNumberPatient().setValue(inpatient.getTimeOfAddmission());
				orc.getOrc10_EnteredBy().getCn1_IDNumber().setValue(inpatient.getListDate() + "");
				pv1.getPv18_ReferringDoctor().getCn4_MiddleInitialOrName().setValue(inpatient.getAddEditTime());
				pv1.getPv140_BedStatus().setValue(inpatient.getListTime());
				pid.getPid26_Citizenship(0).setValue(inpatient.getAddEditDate() + "");

				// *********patient***********
				pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(patient.getPatientStatus());
				pid.getPid20_DriverSLicenseNumberPatient().getLicenseNumber().setValue(patient.getAb64Available());
				if (patient.getPatientType() != null) {
					pid.getPid18_PatientAccountNumber().getCheckDigit().setValue(patient.getPatientType().getId() + "");
				}
				pid.getPid8_Sex().setValue(patient.getPastDue());
				if ("y".equalsIgnoreCase(patient.getBplStatus())) {
					pid.getPid25_BirthOrder().setValue(1 + "");
				}

				pid.getPid2_PatientIDExternalID().getCk1_IDNumber().setValue(patient.getHinNo());

			}

			Parser p1 = new PipeParser();
			String encodedMessage = p1.encode(ormO01);
			String encMsg = p1.encode(message);
			String newString = encMsg.substring(8);
			LOGGER.debug("encodedMessage " + encodedMessage);
			LOGGER.debug("Start String");
			LOGGER.debug("encMsg : " + encMsg + " --> newString : " + newString);
			LOGGER.debug("End String");
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			IpAdmissionForServer ipAdimissionForServer = new IpAdmissionForServer();
			ipAdimissionForServer.setIpAdmission(encodedMessage + newString);
			if (null != inpatient && inpatient.getId() > 0) {
				ipAdimissionForServer.setInpatientId(inpatient.getId());
			}
			// status represunt that patient still not admited
			String notSaveToServer = "P";
			ipAdimissionForServer.setStatus(notSaveToServer);
			ipAdimissionForServer.setHospitalId(hospital.getId());
			hbt.save(ipAdimissionForServer);
			hbt.flush();
			hbt.clear();
			LOGGER.debug("Done");
			return dataMap;
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
			return dataMap;
		}

		// return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDataForServer() {

		LOGGER.debug("Inside getDataForServer ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = getSession();
		try {
			Criteria criteria = session.createCriteria(IpAdmissionForServer.class)
					.add(Restrictions.eq("Status", "N").ignoreCase()).addOrder(Order.asc("Id")).setMaxResults(10);
			List<IpAdmissionForServer> ipAdmissionForServer = criteria.list();

			MasHospital masHospital = null;
			if (ipAdmissionForServer != null && ipAdmissionForServer.size() > 0) {
				masHospital = (MasHospital) session.get(MasHospital.class,
						Integer.parseInt(ipAdmissionForServer.get(0).getHospitalId().toString()));
				dataMap.put("ipAdmissionForServer", ipAdmissionForServer);
			}
			if (masHospital != null) {
				dataMap.put("masHospital", masHospital);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDataForDischargePatientFromLeanServer() {

		LOGGER.debug("Inside getDataForDischargePatientFromLeanServer ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = getSession();

		try {
			Criteria criteria = session.createCriteria(LeanServerFinalDischargeData.class)
					.add(Restrictions.eq("Status", "N").ignoreCase()).addOrder(Order.asc("Id")).setMaxResults(10);
			List<LeanServerFinalDischargeData> leanServerFinalDischargeData = criteria.list();

			if (leanServerFinalDischargeData != null && leanServerFinalDischargeData.size() > 0) {
				dataMap.put("leanServerFinalDischargeData", leanServerFinalDischargeData);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDataForLeanServer() {

		LOGGER.debug("Inside getDataForLeanServer ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = getSession();
		try {
			Criteria criteria = session.createCriteria(IpAdmissionForLean.class)
					.add(Restrictions.eq("Status", "N").ignoreCase()).addOrder(Order.asc("Id")).setMaxResults(10);
			List<IpAdmissionForLean> ipAdmissionForLeanServer = criteria.list();

			MasHospital masHospital = null;
			if (ipAdmissionForLeanServer != null && ipAdmissionForLeanServer.size() > 0) {
				masHospital = (MasHospital) session.get(MasHospital.class,
						Integer.parseInt(ipAdmissionForLeanServer.get(0).getHospitalId().toString()));
				dataMap.put("ipAdmissionForLeanServer", ipAdmissionForLeanServer);
			}
			if (masHospital != null) {
				dataMap.put("masHospital", masHospital);
			}
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return dataMap;
	}

	public String updateCentralServerIpAdmissionData(final IpAdmissionForServer ipAdmissionForServer) {

		LOGGER.debug("Inside updateCentralServerIpAdmissionData ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String savedSaveToServer = "Y";
		ipAdmissionForServer.setStatus(savedSaveToServer);
		hbt.update(ipAdmissionForServer);
		hbt.flush();
		hbt.clear();
		return "success";
	}

	public String updateLeanServerIpDischargeData(final LeanServerFinalDischargeData leanServerFinalDischargeData) {

		LOGGER.debug("Inside updateLeanServerIpDischargeData ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String savedSaveToServer = "Y";
		leanServerFinalDischargeData.setStatus(savedSaveToServer);
		hbt.update(leanServerFinalDischargeData);
		hbt.flush();
		hbt.clear();
		return "success";
	}

	public String updateLeanServerIpAdmissionData(final IpAdmissionForLean ipAdmissionForLeanServer) {

		LOGGER.debug("Inside updateLeanServerIpAdmissionData ");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String savedSaveToLeanServer = "Y";
		ipAdmissionForLeanServer.setStatus(savedSaveToLeanServer);
		hbt.update(ipAdmissionForLeanServer);
		hbt.flush();
		hbt.clear();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> dischargePatientFromServer(final Map<String, Object> dataMap, final MasHospital hospital) {

		LOGGER.debug("Inside dischargePatientFromServer ");
		StringBuilder sb = new StringBuilder();
		InputStreamReader in = null;
		String message = "2";
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {

			Inpatient inpatient = (Inpatient) dataMap.get("inpatient");
			Patient patient = (Patient) dataMap.get("patient");
			Discharge discharge = (Discharge) dataMap.get("discharge");
			List<DischargeIcdCode> dischargeIcdList = (List<DischargeIcdCode>) dataMap.get("dischargeIcdList");

			StringBuilder builder = new StringBuilder();
			if (patient != null) {
				builder.append(patient.getHinNo()).append(" |");
				builder.append(patient.getPatientStatus()).append(" |");
				builder.append(patient.getInpatientNo()).append(" |");
			}
			builder.append(" #");
			if (inpatient != null) {
				builder.append(inpatient.getAdStatus()).append(" |");
				builder.append(inpatient.getDischargeTime()).append(" |");
				builder.append(inpatient.getDischargeDate()).append(" |");
				if (inpatient.getBed() != null) {
					builder.append(inpatient.getBed().getId());
				}
				builder.append(" |");
				if (inpatient.getDepartment() != null) {
					builder.append(inpatient.getDepartment().getId());
				}
				builder.append(" |");
			}
			builder.append(" #");

			if (discharge != null) {
				builder.append(discharge.getDischargeNo()).append(" |");
				builder.append(discharge.getAdNo()).append(" |");
				if (discharge.getDisposal() != null) {
					builder.append(discharge.getDisposal().getId());
				}
				builder.append(" |");
				if (discharge.getDisposedTo() != null) {
					builder.append(discharge.getDisposedTo().getId());
				}
				builder.append(" |");
				if (discharge.getCareType() != null) {
					builder.append(discharge.getCareType());
				}
				builder.append(" |");
				if (discharge.getDoctor() != null) {
					builder.append(discharge.getDoctor().getId());
				}
				builder.append(" |");
				if (discharge.getDischargeStatus() != null) {
					builder.append(discharge.getDischargeStatus().getId());
				}
				builder.append(" |");
				if (discharge.getWard() != null) {
					builder.append(discharge.getWard().getId());
				}
				builder.append(" |");
				builder.append(discharge.getAdStatus()).append(" |");
				builder.append(discharge.getDischargeInMedicalCategory()).append(" |");
				builder.append(discharge.getInjuryReportInitiatedOn()).append(" |");
				builder.append(discharge.getBoardHeldOn()).append(" |");
				builder.append(discharge.getCareSummary()).append(" |");
				builder.append(discharge.getInstructionsToPatient()).append(" |");
				builder.append(discharge.getFollowUpDate()).append(" |");
				builder.append(discharge.getOtherHospital()).append(" |");
				builder.append(discharge.getInjuryReportInitAt()).append(" |");
				builder.append(discharge.getDocumentInitiated()).append(" |");
				if (discharge.getAddEditBy() != null) {
					builder.append(discharge.getAddEditBy().getId());
				}
				builder.append(" |");
				if (discharge.getHospital() != null) {
					builder.append(discharge.getHospital().getId());
				}
				builder.append(" |");
				builder.append(discharge.getAddEditDate()).append(" |");
				builder.append(discharge.getDateOfDischarge()).append(" |");
				builder.append(discharge.getAddEditTime()).append(" |");
				builder.append(discharge.getTimeOfDischarge()).append(" |");
				builder.append(discharge.getStatus()).append(" |");
				builder.append(discharge.getDischargeAdviced()).append(" |");
			}
			builder.append(" #");

			if (dischargeIcdList != null && dischargeIcdList.size() > 0) {
				for (DischargeIcdCode dischargeIcdCode : dischargeIcdList) {

					builder.append(dischargeIcdCode.getZ03()).append(" |");
					builder.append(dischargeIcdCode.getDiagnosisStatus()).append(" |");
					if (dischargeIcdCode.getAddEditBy() != null) {
						builder.append(dischargeIcdCode.getAddEditBy().getId());
					}
					builder.append(" |");
					builder.append(dischargeIcdCode.getAddEditDate()).append(" |");
					builder.append(dischargeIcdCode.getAddEditTime()).append(" |");
					builder.append(dischargeIcdCode.getStatus()).append(" |");
					if (dischargeIcdCode.getIcd() != null) {
						builder.append(dischargeIcdCode.getIcd().getId());
					}
					builder.append(" |");
					builder.append(" $");
				}
			}
			builder.append(" #");
			String msg = builder.toString();
			returnMap.put("dischargeMessage", msg);
			LOGGER.debug("Data For discharge Patient ");
			LOGGER.debug(msg);
			msg = msg.replace("&", "$");
			msg = msg.replaceAll("[\r\n]", "*");
			String encode = URLEncoder.encode(msg, "UTF-8");
			String header = "http://" + hospital.getClientIp() + ":" + hospital.getClientPort();
			String uri = header + "/hms/hms/adt?method=dischargePatientFromLean&message=" + encode + "&hospitalId="
					+ hospital.getId();
			LOGGER.debug("Url>>>>  " + uri);
			URL url = new URL(uri);
			URLConnection connection = url.openConnection();
			if (connection != null && connection.getInputStream() != null) {
				in = new InputStreamReader(connection.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
				in.close();
			}
			String responseMsg = sb.toString();
			if (responseMsg.contains("success")) {
				message = "1";
			} else if (responseMsg.contains("fail")) {
				message = "2";
			} else if (responseMsg.contains("500")) {
				message = "3";
			}
			LOGGER.debug("Input Stream: " + sb.toString());
			if ("1".equals(message)) {
				LOGGER.debug("patient discharge successfuly save to lean server");
			} else {
				LOGGER.debug("Some Error occur in lean server while patient discharge saved ");
			}
			returnMap.put("message", message);
		} catch (MalformedURLException e) {
			LOGGER.error("MalformedURLException occur in lean server while patient discharge saved "
					+ e.getStackTrace().toString());
		} catch (IOException e) {
			LOGGER.error("IOException occur in lean server while patient discharge saved "
					+ e.getStackTrace().toString());
			LOGGER.debug("Some Error occur in lean server while patient discharge saved ");
		} catch (Exception e) {
			LOGGER.error("Exception occur in lean server while patient discharge saved " + e.getStackTrace().toString());
		}
		return returnMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> dischargePatientFromLean(final Map<String, Object> map, final Box box) {

		LOGGER.debug("Inside dischargePatientFromLean ");
		Session session = getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String data = box.get("message");

		int hospitalId = box.getInt("hospitalId");
		data = data.replace("null", " ");
		String[] array = data.split("#");
		for (int i = 0; i < array.length; i++) {
			LOGGER.debug(array[i]);
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int index = 0;
			String patientData = array[index++];// 0
			String inpatientData = array[index++];// 1
			String dischargeData = array[index++];// 2
			String dischargeIcdCodeData = array[index++];// 3

			String[] patientDataArray = patientData.trim().split("\\|");
			String[] inpatientDataArray = inpatientData.trim().split("\\|");
			String[] dischargeDataArray = dischargeData.trim().split("\\|");
			String[] dischargeIcdCodeListObjectDataArray = dischargeIcdCodeData.trim().split("\\$");
			String bedStatusUnOccupiedName = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
			Patient patient = null;
			if (patientDataArray.length > 1) {
				patient = updatePatientForDischarge(patientDataArray);
			}
			Patient patientForSave = (Patient) session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", patient.getHinNo())).uniqueResult();
			if (patientForSave != null) {
				patientForSave.setPatientStatus(patient.getPatientStatus());
				patientForSave.setInpatientNo(patient.getInpatientNo());

				Inpatient inpatient = null;
				if (inpatientDataArray.length > 1) {
					inpatient = updateInpatientDischarge(inpatientDataArray);
				}

				List<Inpatient> inPatientList = session.createCriteria(Inpatient.class, "ip")
						.add(Restrictions.in("ip.AdStatus", new String[] { "A", "R" }))
						.add(Restrictions.eq("ip.Department.Id", inpatient.getDepartment().getId()))
						.add(Restrictions.eq("ip.HinNo", patientForSave.getHinNo()))
						.add(Restrictions.eq("ip.Hospital.Id", hospitalId)).list();
				Inpatient inpatientForSave = null;
				MasBed masBed = null;
				if (inPatientList != null && inPatientList.size() > 0) {
					inpatientForSave = inPatientList.get(0);
					inpatientForSave.setAdStatus(inpatient.getAdStatus());
					inpatientForSave.setDischargeTime(inpatient.getDischargeTime());
					inpatientForSave.setDischargeDate(inpatient.getDischargeDate());
					masBed = inpatientForSave.getBed();
					MasBedStatus bedStatus1 = (MasBedStatus) session.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions.eq("BedStatusCode", bedStatusUnOccupiedName)).uniqueResult();
					masBed.setBedStatus(bedStatus1);
				}
				Discharge discharge = null;
				if (dischargeDataArray.length > 1) {
					discharge = saveDischargeDetails(dischargeDataArray, patientForSave);
				}

				List<DischargeIcdCode> dList = saveDischargeIPDList(index, dischargeIcdCodeListObjectDataArray,
						patientForSave, inpatientForSave);

				hbt.saveOrUpdate(patientForSave);
				LOGGER.debug("patient updated = " + patientForSave.getPatientStatus());

				if (inpatientForSave != null) {
					hbt.saveOrUpdate(inpatientForSave);
					LOGGER.debug("inpatient updated = " + inpatientForSave.getAdStatus());
				}
				if (masBed != null) {
					hbt.saveOrUpdate(masBed);
					LOGGER.debug("masBed updated = " + masBed.getBedStatus().getBedStatusName());
				}
				if (discharge != null) {
					hbt.save(discharge);
					LOGGER.debug("discharge updated = " + discharge.getDateOfDischarge());
				}

				if (dList != null && dList.size() > 0) {
					for (DischargeIcdCode dIcdCodeForSave : dList) {
						hbt.save(dIcdCodeForSave);
						LOGGER.debug("dIcdCodeForSave saved");
					}
				}
				hbt.flush();
				hbt.clear();
			}
			tx.commit();
			dataMap.put("success", "success");
		} catch (Exception e) {
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
			if (tx != null) {
				tx.rollback();
			}
			dataMap.put("failure", "failure");
		}
		return dataMap;
	}

	private List<DischargeIcdCode> saveDischargeIPDList(int index, final String[] dischargeIcdCodeListObjectDataArray,
			final Patient patient, final Inpatient inpatient) {

		LOGGER.debug("Inside saveDischargeIPDList ");
		List<DischargeIcdCode> dList = new ArrayList<DischargeIcdCode>();
		for (int i = 0; i < dischargeIcdCodeListObjectDataArray.length; i++) {
			index = 0; // added by amit das on 06-01-2017
			String[] dischargeIcdCodeDataArray = dischargeIcdCodeListObjectDataArray[i].trim().split("\\|"); // added
																												// by
																												// amit
																												// das
																												// on
																												// 06-01-2017

			if (dischargeIcdCodeDataArray.length > 1) {
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
				dischargeIcdCode.setHin(patient);
				dischargeIcdCode.setInpatient(inpatient);

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					dischargeIcdCode.setZ03(dischargeIcdCodeDataArray[index].trim());
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					dischargeIcdCode.setDiagnosisStatus(dischargeIcdCodeDataArray[index].trim());
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					Users userObject = new Users(Integer.parseInt(dischargeIcdCodeDataArray[index].trim()));
					dischargeIcdCode.setAddEditBy(userObject);
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {

					dischargeIcdCode.setAddEditDate(HMSUtil
							.convertStringyyyyMMddTypeToDateType(dischargeIcdCodeDataArray[index].trim()));
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					dischargeIcdCode.setAddEditTime(dischargeIcdCodeDataArray[index].trim());
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					dischargeIcdCode.setStatus(dischargeIcdCodeDataArray[index].trim());
					index++; // added by amit das on 06-01-2017
				}

				if (dischargeIcdCodeDataArray[index] != null && !"".equals(dischargeIcdCodeDataArray[index].trim())) {
					MasIcd masIcd = new MasIcd(Integer.parseInt(dischargeIcdCodeDataArray[index].trim()));
					dischargeIcdCode.setIcd(masIcd);
					index++; // added by amit das on 06-01-2017
				}
				dList.add(dischargeIcdCode);
			}

		}
		return dList;
	}

	private Discharge saveDischargeDetails(final String[] dischargeDataArray, final Patient patient) {

		LOGGER.debug("Inside saveDischargeDetails ");
		int index;
		Discharge discharge = new Discharge();
		discharge.setHin(patient);
		index = 0;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setDischargeNo(Integer.parseInt(dischargeDataArray[index].trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setAdNo(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasDisposal masDisposal = new MasDisposal(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setDisposal(masDisposal);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasDisposedTo masDisposedTo = new MasDisposedTo(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setDisposedTo(masDisposedTo);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasCareType masCareType = new MasCareType(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setCareType(masCareType);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasEmployee masEmployee = new MasEmployee(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setDoctor(masEmployee);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasDischargeStatus masDischargeStatus = new MasDischargeStatus(Integer.parseInt(dischargeDataArray[index]
					.trim()));
			discharge.setDischargeStatus(masDischargeStatus);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasDepartment masDepartment = new MasDepartment(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setWard(masDepartment);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setAdStatus(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setDischargeInMedicalCategory(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setInjuryReportInitiatedOn(HMSUtil.convertStringyyyyMMddTypeToDateType(dischargeDataArray[index]
					.trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setBoardHeldOn(HMSUtil.convertStringyyyyMMddTypeToDateType(dischargeDataArray[index].trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setCareSummary(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setInstructionsToPatient(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setFollowUpDate(HMSUtil.convertStringyyyyMMddTypeToDateType(dischargeDataArray[index].trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setOtherHospital(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setInjuryReportInitAt(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setDocumentInitiated(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			Users userObj = new Users(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setAddEditBy(userObj);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			MasHospital masHospital = new MasHospital(Integer.parseInt(dischargeDataArray[index].trim()));
			discharge.setHospital(masHospital);
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setAddEditDate(HMSUtil.convertStringyyyyMMddTypeToDateType(dischargeDataArray[index].trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setDateOfDischarge(HMSUtil.convertStringyyyyMMddTypeToDateType(dischargeDataArray[index].trim()));
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setAddEditTime(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setTimeOfDischarge(dischargeDataArray[index].trim());
		}
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setStatus(dischargeDataArray[index].trim());
		}
		discharge.setMortuaryRegStatus("N");
		index++;
		if (dischargeDataArray[index] != null && !"".equals(dischargeDataArray[index].trim())) {
			discharge.setDischargeAdviced(dischargeDataArray[index].trim());
		}

		return discharge;
	}

	private Inpatient updateInpatientDischarge(final String[] inpatientDataArray) {
		int index;
		Inpatient inpatient = new Inpatient();
		index = 0;
		if (inpatientDataArray[index] != null && !"".equals(inpatientDataArray[index].trim())) {
			inpatient.setAdStatus(inpatientDataArray[0].trim());
		}
		index++;
		if (inpatientDataArray[index] != null && !"".equals(inpatientDataArray[index].trim())) {
			inpatient.setDischargeTime(inpatientDataArray[index]);
		}
		index++;
		if (inpatientDataArray[index] != null && !"".equals(inpatientDataArray[index].trim())) {
			inpatient.setDischargeDate(HMSUtil.convertStringyyyyMMddTypeToDateType(inpatientDataArray[index].trim()));
		}
		index++;
		if (inpatientDataArray[index] != null && !"".equals(inpatientDataArray[index].trim())) {
			MasBed bed = new MasBed(Integer.parseInt(inpatientDataArray[index].trim()));
			inpatient.setBed(bed);
		}
		index++;
		if (inpatientDataArray[index] != null && !"".equals(inpatientDataArray[index].trim())) {
			MasDepartment department = new MasDepartment(Integer.parseInt(inpatientDataArray[index].trim()));
			inpatient.setDepartment(department);
		}
		return inpatient;
	}

	private Patient updatePatientForDischarge(final String[] patientDataArray) {

		Patient patient = new Patient();
		int index = 0;
		if (patientDataArray[index] != null && !"".equals(patientDataArray[index].trim())) {
			patient.setHinNo(patientDataArray[0].trim());
		}
		index++;
		if (patientDataArray[index] != null && !"".equals(patientDataArray[index].trim())) {
			patient.setPatientStatus(patientDataArray[index].trim());
			;
		}
		index++;
		if (patientDataArray[index] != null && !"".equals(patientDataArray[index].trim())) {
			patient.setInpatientNo(Integer.parseInt(patientDataArray[index].trim()));
		}
		return patient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> pendingMortuaryList(final Box box) {

		LOGGER.debug("Inside pendingMortuaryList ");
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		String uhid = "";
		if (box.getString("uhin") != null && !box.getString("uhin").equals("")) {
			uhid = box.getString("uhin");
		}
		Session session = getSession();
		Patient patient = (Patient) session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", uhid))
				.uniqueResult();

		Criteria crit = session.createCriteria(ExpiryDetails.class).createAlias("Hin", "hin")
				.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("hin.PatientStatus", "Expired"));
		if (patient != null) {
			crit = crit.add(Restrictions.eq("hin.Id", patient.getId()));
		}
		List<ExpiryDetails> discharges = crit.list();

		Criteria criteriaForOpd = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit")
				.createAlias("visit.Hin", "hin").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("SiftedForMortuary", "Y").ignoreCase());

		if (patient != null) {
			criteriaForOpd = criteriaForOpd.add(Restrictions.eq("hin.Id", patient.getId()));
		}

		List<OpdPatientDetails> opdPatientDetails = criteriaForOpd.list();
		map.put("discharge", discharges);
		map.put("opdPatientDetails", opdPatientDetails);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showRegistrationMourtaryListWithoutMLC(final Box box) {

		LOGGER.debug("Inside showRegistrationMourtaryListWithoutMLC ");
		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeId = 0;
		String pType = "";
		int orderNo = 0;
		int opdPatientDetailId = 0;
		String transactionSequenceName = "MortuaryRegister";
		LOGGER.debug("discha======" + box.getString("dischargeId"));
		if (box.getString("dischargeId") != null && !box.getString("dischargeId").equals("")) {
			dischargeId = box.getInt("dischargeId");
		}

		if (box.getString("opdPatientDetailId") != null && !box.getString("opdPatientDetailId").equals("")) {
			opdPatientDetailId = box.getInt("opdPatientDetailId");
		}
		if (box.getString("pType") != null && !box.getString("pType").equals("")) {
			pType = box.getString("pType");
		}

		Session session = getSession();
		if ("IP".equalsIgnoreCase(pType)) {
			Criteria criteria = session.createCriteria(Discharge.class).add(Restrictions.eq("Id", dischargeId));
			List<Discharge> discharges = criteria.list();
			map.put("discharge", discharges);
		} else if ("OP".equalsIgnoreCase(pType)) {
			Criteria criteria = session.createCriteria(OpdPatientDetails.class).add(
					Restrictions.eq("Id", opdPatientDetailId));
			List<OpdPatientDetails> opdPatientDetails = criteria.list();
			map.put("opdPatientDetails", opdPatientDetails);
			LOGGER.debug("opdPatientDetails==" + opdPatientDetails.size());
		}
		String stringOrderNo = "";
		List<TransactionSequence> sequenceNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionSequenceName", transactionSequenceName))
				.createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Id", box.getInt("hospitalId"))).list();
		if (sequenceNoList.size() > 0) {
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			orderNo = sequenceNo + 1;
			stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/" + orderNo;
		} else {
			stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/" + 1;
		}
		List<MortuaryRegisterDetails> mortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class)
				.add(Restrictions.eq("Hin.Id", box.getInt("hin_Id"))).list();
		map.put("mortuaryRegisterList", mortuaryRegisterList);
		map.put("stringOrderNo", stringOrderNo);
		LOGGER.debug("pType======" + pType);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitMortuaryRegister(final Box box) {

		LOGGER.debug("Inside submitMortuaryRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MortuaryRegisterDetails> existingMortuaryRegisterList = new ArrayList<MortuaryRegisterDetails>();
		List<MortuaryRegisterDetails> mortuaryRegisterList = new ArrayList<MortuaryRegisterDetails>();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = true;
		String msg = "";
		String stringOrderNo = "";
		String transactionSequenceName = "MortuaryRegister";
		Session session = getSession();
		int mortuaryPtId = 0;

		try {
			if (box.getString("flagStatus").equalsIgnoreCase("save")) {
				existingMortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class)
						.add(Restrictions.eq("Hin.Id", box.getInt("hin_Id"))).list();
				if (existingMortuaryRegisterList.size() > 0) {
					int mortuaryId = existingMortuaryRegisterList.get(0).getId();
					MortuaryRegisterDetails mortuaryDt = hbt.load(MortuaryRegisterDetails.class, mortuaryId);
					if (!box.getString("slNo").equals("")) {
						mortuaryDt.setSerialNo(box.getString("slNo"));
					}

					if (!box.getString("time").equals("")) {
						mortuaryDt.setMortuaryRegTime(box.getString("time"));
					}
					if (!box.getString("date").equals("")) {
						mortuaryDt.setMortuaryRegDate(HMSUtil.convertStringTypeDateToDateType(box.getString("date")));
					}
					if (!box.getString("causeOfDeath").equals("")) {
						mortuaryDt.setCauseOfDeath(box.getString("causeOfDeath"));
					}
					if (!box.getString("deceasedBroughtFrom").equals("")) {
						mortuaryDt.setDeceasedBroughtFrom(box.getString("deceasedBroughtFrom"));
					}
					if (!box.getString("deceasedBroughtBy").equals("")) {
						mortuaryDt.setDeceasedBroughtBy(box.getString("deceasedBroughtBy"));
					}
					if (!box.getString("bodyKeptInMortuaryDate").equals("")) {
						mortuaryDt.setDeadBodyKeptDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyKeptInMortuaryDate")));
					}
					if (!box.getString("bodyKeptInMortuaryTime").equals("")) {
						mortuaryDt.setDeadBodyKeptTime(box.getString("bodyKeptInMortuaryTime"));
					}
					if (!box.getString("intimationGivenTo").equals("")) {
						mortuaryDt.setInitimationGiven(box.getString("intimationGivenTo"));
					}
					if (!box.getString("articlesOnBody").equals("")) {
						mortuaryDt.setArticlesOnBody(box.getString("articlesOnBody"));
					}
					if (!box.getString("otherRemarks").equals("")) {
						mortuaryDt.setMortuaryRegRemarks(box.getString("otherRemarks"));
					}
					if (!box.getString("bodyHandedOverTo").equals("")) {
						mortuaryDt.setBodyHandedOver(box.getString("bodyHandedOverTo"));
					}
					if (!box.getString("bodyHandedOverTime").equals("")) {
						mortuaryDt.setHandOverTime(box.getString("bodyHandedOverTime"));
					}
					if (!box.getString("bodyHandedOverDate").equals("")) {
						mortuaryDt.setHandOverDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyHandedOverDate")));
					}
					if (!box.getString("cremation").equals("")) {
						mortuaryDt.setCremation(box.getString("cremation"));
					}
					if (!box.getString("receivedDeadBodyTime").equals("")) {
						mortuaryDt.setBodyReceivedTime(box.getString("receivedDeadBodyTime"));
					}
					if (!box.getString("receivedDeadBodyDate").equals("")) {
						mortuaryDt.setBodyReceivedDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("receivedDeadBodyDate")));
					}
					if (box.getInt("receivingById") != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("receivingById"));
						mortuaryDt.setDeadBodyReceivedBy(masEmployee);
					}

					mortuaryDt.setPostmortemStatus("Mortuary Register");
					mortuaryDt.setStatus("s");
					hbt.save(mortuaryDt);
					flag = true;

				} else {
					MortuaryRegisterDetails mortuaryRegisterDetails = new MortuaryRegisterDetails();
					if (!box.getString("slNo").equals("")) {
						mortuaryRegisterDetails.setSerialNo(box.getString("slNo"));
					}

					if (!box.getString("time").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegTime(box.getString("time"));
					}
					if (!box.getString("date").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("date")));
					}
					if (!box.getString("causeOfDeath").equals("")) {
						mortuaryRegisterDetails.setCauseOfDeath(box.getString("causeOfDeath"));
					}
					if (!box.getString("deceasedBroughtFrom").equals("")) {
						mortuaryRegisterDetails.setDeceasedBroughtFrom(box.getString("deceasedBroughtFrom"));
					}
					if (!box.getString("deceasedBroughtBy").equals("")) {
						mortuaryRegisterDetails.setDeceasedBroughtBy(box.getString("deceasedBroughtBy"));
					}
					if (!box.getString("bodyKeptInMortuaryDate").equals("")) {
						mortuaryRegisterDetails.setDeadBodyKeptDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyKeptInMortuaryDate")));
					}
					if (!box.getString("bodyKeptInMortuaryTime").equals("")) {
						mortuaryRegisterDetails.setDeadBodyKeptTime(box.getString("bodyKeptInMortuaryTime"));
					}
					if (!box.getString("intimationGivenTo").equals("")) {
						mortuaryRegisterDetails.setInitimationGiven(box.getString("intimationGivenTo"));
					}
					if (!box.getString("articlesOnBody").equals("")) {
						mortuaryRegisterDetails.setArticlesOnBody(box.getString("articlesOnBody"));
					}
					if (!box.getString("otherRemarks").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegRemarks(box.getString("otherRemarks"));
					}
					if (!box.getString("bodyHandedOverTo").equals("")) {
						mortuaryRegisterDetails.setBodyHandedOver(box.getString("bodyHandedOverTo"));
					}
					if (!box.getString("bodyHandedOverTime").equals("")) {
						mortuaryRegisterDetails.setHandOverTime(box.getString("bodyHandedOverTime"));
					}
					if (!box.getString("bodyHandedOverDate").equals("")) {
						mortuaryRegisterDetails.setHandOverDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyHandedOverDate")));
					}
					if (!box.getString("cremation").equals("")) {
						mortuaryRegisterDetails.setCremation(box.getString("cremation"));
					}
					if (!box.getString("receivedDeadBodyTime").equals("")) {
						mortuaryRegisterDetails.setBodyReceivedTime(box.getString("receivedDeadBodyTime"));
					}
					if (!box.getString("receivedDeadBodyDate").equals("")) {
						mortuaryRegisterDetails.setBodyReceivedDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("receivedDeadBodyDate")));
					}
					if (box.getInt("receivingById") != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("receivingById"));
						mortuaryRegisterDetails.setDeadBodyReceivedBy(masEmployee);
					}
					if (box.getInt("hin_Id") != 0) {
						Patient patient = new Patient(box.getInt("hin_Id"));
						mortuaryRegisterDetails.setHin(patient);
					}
					mortuaryRegisterDetails.setPostmortemStatus("Mortuary Register");
					mortuaryRegisterDetails.setStatus("s");
					sequenceNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionSequenceName", transactionSequenceName))
							.createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
							.list();
					if (sequenceNoList.size() > 0) {
						TransactionSequence transactionSequence = sequenceNoList.get(0);
						int orderNo = transactionSequence.getTransactionSequenceNumber();
						orderNo = orderNo + 1;
						stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/"
								+ orderNo;
						int id = transactionSequence.getId();

						TransactionSequence transactionSequence2 = hbt.load(TransactionSequence.class, id);
						transactionSequence2.setTransactionSequenceNumber(orderNo);
						hbt.update(transactionSequence2);
					} else if (sequenceNoList.size() == 0) {
						TransactionSequence tsObj = new TransactionSequence();
						tsObj.setStatus("y");
						tsObj.setTransactionPrefix("MR");
						tsObj.setTransactionSequenceName(transactionSequenceName);
						tsObj.setTransactionSequenceNumber(1);
						tsObj.setCreatedby("admin");
						tsObj.setStatus("y");
						MasHospital hospital = new MasHospital();
						hospital.setId(box.getInt("hospitalId"));
						tsObj.setHospital(hospital);

						hbt.save(tsObj);
						stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/"
								+ 1;
					}
					hbt.save(mortuaryRegisterDetails);
					flag = true;
				}
			} else if (box.getString("flagStatus").equalsIgnoreCase("submit")) {
				existingMortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class)
						.add(Restrictions.eq("Hin.Id", box.getInt("hin_Id"))).list();
				if (existingMortuaryRegisterList.size() > 0) {
					int mortuaryId = existingMortuaryRegisterList.get(0).getId();
					MortuaryRegisterDetails mortuaryDetails = hbt.load(MortuaryRegisterDetails.class, mortuaryId);
					if (!box.getString("slNo").equals("")) {
						mortuaryDetails.setSerialNo(box.getString("slNo"));
					}

					if (!box.getString("time").equals("")) {
						mortuaryDetails.setMortuaryRegTime(box.getString("time"));
					}
					if (!box.getString("date").equals("")) {
						mortuaryDetails.setMortuaryRegDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("date")));
					}
					if (!box.getString("causeOfDeath").equals("")) {
						mortuaryDetails.setCauseOfDeath(box.getString("causeOfDeath"));
					}
					if (!box.getString("deceasedBroughtFrom").equals("")) {
						mortuaryDetails.setDeceasedBroughtFrom(box.getString("deceasedBroughtFrom"));
					}
					if (!box.getString("deceasedBroughtBy").equals("")) {
						mortuaryDetails.setDeceasedBroughtBy(box.getString("deceasedBroughtBy"));
					}
					if (!box.getString("bodyKeptInMortuaryDate").equals("")) {
						mortuaryDetails.setDeadBodyKeptDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyKeptInMortuaryDate")));
					}
					if (!box.getString("bodyKeptInMortuaryTime").equals("")) {
						mortuaryDetails.setDeadBodyKeptTime(box.getString("bodyKeptInMortuaryTime"));
					}
					if (!box.getString("intimationGivenTo").equals("")) {
						mortuaryDetails.setInitimationGiven(box.getString("intimationGivenTo"));
					}
					if (!box.getString("articlesOnBody").equals("")) {
						mortuaryDetails.setArticlesOnBody(box.getString("articlesOnBody"));
					}
					if (!box.getString("otherRemarks").equals("")) {
						mortuaryDetails.setMortuaryRegRemarks(box.getString("otherRemarks"));
					}
					if (!box.getString("bodyHandedOverTo").equals("")) {
						mortuaryDetails.setBodyHandedOver(box.getString("bodyHandedOverTo"));
					}
					if (!box.getString("bodyHandedOverTime").equals("")) {
						mortuaryDetails.setHandOverTime(box.getString("bodyHandedOverTime"));
					}
					if (!box.getString("bodyHandedOverDate").equals("")) {
						mortuaryDetails.setHandOverDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyHandedOverDate")));
					}
					if (!box.getString("cremation").equals("")) {
						mortuaryDetails.setCremation(box.getString("cremation"));
					}
					if (!box.getString("receivedDeadBodyTime").equals("")) {
						mortuaryDetails.setBodyReceivedTime(box.getString("receivedDeadBodyTime"));
					}
					if (!box.getString("receivedDeadBodyDate").equals("")) {
						mortuaryDetails.setBodyReceivedDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("receivedDeadBodyDate")));
					}
					if (box.getInt("receivingById") != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("receivingById"));
						mortuaryDetails.setDeadBodyReceivedBy(masEmployee);
					}
					mortuaryDetails.setStatus("m");
					if (box.getString("dischargeId") != null && !box.getString("dischargeId").equalsIgnoreCase("")) {
						Discharge discharge = (Discharge) session.get(Discharge.class, box.getInt("dischargeId"));
						discharge.setMortuaryRegStatus("Y");
						hbt.saveOrUpdate(discharge);
					}
					if (box.getString("opdPatientDetailId") != null
							&& !box.getString("opdPatientDetailId").equalsIgnoreCase("")) {
						OpdPatientDetails opDetails = (OpdPatientDetails) session.get(OpdPatientDetails.class,
								box.getInt("opdPatientDetailId"));
						opDetails.setSiftedForMortuary("S");
						hbt.saveOrUpdate(opDetails);
					}
					hbt.update(mortuaryDetails);
					mortuaryPtId = mortuaryDetails.getId();
					flag = true;

				} else {
					MortuaryRegisterDetails mortuaryRegisterDetails = new MortuaryRegisterDetails();
					if (!box.getString("slNo").equals("")) {
						mortuaryRegisterDetails.setSerialNo(box.getString("slNo"));
					}

					if (!box.getString("time").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegTime(box.getString("time"));
					}
					if (!box.getString("date").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("date")));
					}
					if (!box.getString("causeOfDeath").equals("")) {
						mortuaryRegisterDetails.setCauseOfDeath(box.getString("causeOfDeath"));
					}
					if (!box.getString("deceasedBroughtFrom").equals("")) {
						mortuaryRegisterDetails.setDeceasedBroughtFrom(box.getString("deceasedBroughtFrom"));
					}
					if (!box.getString("deceasedBroughtBy").equals("")) {
						mortuaryRegisterDetails.setDeceasedBroughtBy(box.getString("deceasedBroughtBy"));
					}
					if (!box.getString("bodyKeptInMortuaryDate").equals("")) {
						mortuaryRegisterDetails.setDeadBodyKeptDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyKeptInMortuaryDate")));
					}
					if (!box.getString("bodyKeptInMortuaryTime").equals("")) {
						mortuaryRegisterDetails.setDeadBodyKeptTime(box.getString("bodyKeptInMortuaryTime"));
					}
					if (!box.getString("intimationGivenTo").equals("")) {
						mortuaryRegisterDetails.setInitimationGiven(box.getString("intimationGivenTo"));
					}
					if (!box.getString("articlesOnBody").equals("")) {
						mortuaryRegisterDetails.setArticlesOnBody(box.getString("articlesOnBody"));
					}
					if (!box.getString("otherRemarks").equals("")) {
						mortuaryRegisterDetails.setMortuaryRegRemarks(box.getString("otherRemarks"));
					}
					if (!box.getString("bodyHandedOverTo").equals("")) {
						mortuaryRegisterDetails.setBodyHandedOver(box.getString("bodyHandedOverTo"));
					}
					if (!box.getString("bodyHandedOverTime").equals("")) {
						mortuaryRegisterDetails.setHandOverTime(box.getString("bodyHandedOverTime"));
					}
					if (!box.getString("bodyHandedOverDate").equals("")) {
						mortuaryRegisterDetails.setHandOverDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("bodyHandedOverDate")));
					}
					if (!box.getString("cremation").equals("")) {
						mortuaryRegisterDetails.setCremation(box.getString("cremation"));
					}
					if (!box.getString("receivedDeadBodyTime").equals("")) {
						mortuaryRegisterDetails.setBodyReceivedTime(box.getString("receivedDeadBodyTime"));
					}
					if (!box.getString("receivedDeadBodyDate").equals("")) {
						mortuaryRegisterDetails.setBodyReceivedDate(HMSUtil.convertStringTypeDateToDateType(box
								.getString("receivedDeadBodyDate")));
					}
					if (box.getInt("receivingById") != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("receivingById"));
						mortuaryRegisterDetails.setDeadBodyReceivedBy(masEmployee);
					}
					if (box.getInt("hin_Id") != 0) {
						Patient patient = new Patient(box.getInt("hin_Id"));
						mortuaryRegisterDetails.setHin(patient);
					}
					mortuaryRegisterDetails.setPostmortemStatus("Mortuary Register");
					mortuaryRegisterDetails.setStatus("m");
					if (box.getString("dischargeId") != null && !box.getString("dischargeId").equalsIgnoreCase("")) {
						Discharge discharge = (Discharge) session.get(Discharge.class, box.getInt("dischargeId"));
						discharge.setMortuaryRegStatus("Y");
						hbt.saveOrUpdate(discharge);
					}
					if (box.getString("opdPatientDetailId") != null
							&& !box.getString("opdPatientDetailId").equalsIgnoreCase("")) {
						OpdPatientDetails opDetails = (OpdPatientDetails) session.get(OpdPatientDetails.class,
								box.getInt("opdPatientDetailId"));
						opDetails.setSiftedForMortuary("S");
						hbt.saveOrUpdate(opDetails);
					}
					sequenceNoList = session.createCriteria(TransactionSequence.class)
							.add(Restrictions.eq("TransactionSequenceName", transactionSequenceName))
							.createAlias("Hospital", "hosp").add(Restrictions.eq("hosp.Id", box.getInt("hospitalId")))
							.list();
					if (sequenceNoList.size() > 0) {
						TransactionSequence transactionSequence = sequenceNoList.get(0);
						int orderNo = transactionSequence.getTransactionSequenceNumber();
						orderNo = orderNo + 1;
						stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/"
								+ 1;
						int id = transactionSequence.getId();

						TransactionSequence transactionSequence2 = hbt.load(TransactionSequence.class, id);
						transactionSequence2.setTransactionSequenceNumber(orderNo);
						hbt.update(transactionSequence2);
					} else if (sequenceNoList.size() == 0) {
						TransactionSequence tsObj = new TransactionSequence();
						tsObj.setStatus("y");
						tsObj.setTransactionPrefix("MR");
						tsObj.setTransactionSequenceName(transactionSequenceName);
						tsObj.setTransactionSequenceNumber(1);
						tsObj.setCreatedby("admin");
						tsObj.setStatus("y");
						MasHospital hospital = new MasHospital();
						hospital.setId(box.getInt("hospitalId"));
						tsObj.setHospital(hospital);

						hbt.save(tsObj);
						stringOrderNo = box.getString("hospitalCode") + "/" + box.getString("financialYearDesc") + "/"
								+ 1;
					}
					hbt.save(mortuaryRegisterDetails);
					mortuaryPtId = mortuaryRegisterDetails.getId();
					flag = true;

				}

			}
		} catch (Exception e) {
			LOGGER.error("IOException Occurred while loading adt.properties" + e.getStackTrace().toString());
		}
		mortuaryRegisterList = session.createCriteria(MortuaryRegisterDetails.class)
				.add(Restrictions.eq("Hin.Id", box.getInt("hin_Id"))).list();

		map.put("flag", flag);
		map.put("msg", msg);
		map.put("mortuaryRegdDetailId", mortuaryPtId);
		map.put("mortuaryRegisterList", mortuaryRegisterList);
		map.put("stringOrderNo", stringOrderNo);
		return map;
	}

	// added by amit das on 24-05-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateOPNominalRegister(final int hospitalId) {

		LOGGER.debug("Inside populateOPNominalRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDepartment> departmentList = null;
		List<MasDepartment> instDepartmentList = new ArrayList<MasDepartment>();
		Session session = getSession();
		try {
			//Changed by Arbind on 16-12-2017 departmentList
			/*List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department")).add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "DepartmentType").add(Restrictions.eq("DepartmentType.Id", 1))
					.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();*/
			List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
			hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class)
					.createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment"))
					.add(Projections.property("Id"))).list();
			
			List<Integer> hidList = new ArrayList<Integer>();

			if(hrInstWiseEmpDeptStringList.size() > 0){
				
				Object[] obj = hrInstWiseEmpDeptStringList.get(0);
				String hIds = (String)obj[0];
				String[] houseId = hIds.split(",");
				for (int i = 0; i < houseId.length; i++) {
					hidList.add(Integer.parseInt(houseId[i].trim()));
				}
				departmentList = session.createCriteria(MasEmployeeDepartment.class)
						.add(Restrictions.in("Id", hidList))
						.addOrder(Order.asc("EmpDeptName")).list();
			}
			instDepartmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();

			List<MasScheme> schemeList = session.createCriteria(MasScheme.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("SchemeName")).list();

			List<MasAdministrativeSex> sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasPatientType> patientTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("departmentList", departmentList);
			map.put("instDepartmentList", instDepartmentList);
			map.put("schemeList", schemeList);
			map.put("sexList", sexList);
			map.put("patientTypeList", patientTypeList);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	// added by amit das on 25-05-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateOPClinicalRegister(final int hospitalId) {

		LOGGER.debug("Inside populateOPClinicalRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDepartment> departmentList = new ArrayList<MasEmployeeDepartment>();
		List<MasDepartment> instDepartmentList = new ArrayList<MasDepartment>();
		Session session = getSession();
		try {
			//Changed by Arbind on 31-01-2018 departmentList
			/*List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department")).add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "DepartmentType").add(Restrictions.eq("DepartmentType.Id", 1))
					.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();*/
			List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
			hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class)
					.createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment"))
					.add(Projections.property("Id"))).list();
			
			List<Integer> hidList = new ArrayList<Integer>();

			if(hrInstWiseEmpDeptStringList.size() > 0){
				
				Object[] obj = hrInstWiseEmpDeptStringList.get(0);
				String hIds = (String)obj[0];
				String[] houseId = hIds.split(",");
				for (int i = 0; i < houseId.length; i++) {
					hidList.add(Integer.parseInt(houseId[i].trim()));
				}
				departmentList = session.createCriteria(MasEmployeeDepartment.class)
						.add(Restrictions.in("Id", hidList))
						.addOrder(Order.asc("EmpDeptName")).list();
			}
			instDepartmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();

			List<MasScheme> schemeList = session.createCriteria(MasScheme.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasAdministrativeSex> sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasPatientType> patientTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			map.put("departmentList", departmentList);
			map.put("instDepartmentList", instDepartmentList);
			map.put("schemeList", schemeList);
			map.put("sexList", sexList);
			map.put("patientTypeList", patientTypeList);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	// added by amit das on 31-05-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateOPDStatistics(final int hospitalId) {

		LOGGER.debug("Inside populateOPDStatistics ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		try {
			List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department")).add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "DepartmentType").add(Restrictions.eq("DepartmentType.Id", 1))
					.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();

			List<MasScheme> schemeList = session.createCriteria(MasScheme.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasPatientType> patientTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			map.put("departmentList", departmentList);
			map.put("schemeList", schemeList);
			map.put("patientTypeList", patientTypeList);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	// added by Arbind on 27-09-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateIPAdmissionRegister(final int hospitalId) {

		LOGGER.debug("Inside populateIPAdmissionRegister ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		try {
			List<MasDepartment> wardList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasCaseType> caseTypeList = session.createCriteria(MasCaseType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasScheme> schemeList = session.createCriteria(MasScheme.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasAdministrativeSex> sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasPatientType> patientTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			List<MasDepartment> departmentList = session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department")).add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "DepartmentType").add(Restrictions.eq("DepartmentType.Id", 1))
					.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();

			map.put("wardList", wardList);
			map.put("departmentList", departmentList);
			map.put("caseTypeList", caseTypeList);
			map.put("schemeList", schemeList);
			map.put("sexList", sexList);
			map.put("patientTypeList", patientTypeList);

		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getHeaderDetails(final Map<String, Object> detailsMap) {

		LOGGER.debug("Inside getHeaderDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		int sexId = 0;
		int schemeId = 0;
		int deptId = 0;
		int patientTypeId = 0;
		int serviceCentreId = 0;
		String deptName = null, genName = null, schemName = null, socialName = null, serviceCentreName = null;
		if (detailsMap.get("sexId") != null) {
			sexId = (Integer) detailsMap.get("sexId");
		}

		if (detailsMap.get("schemeId") != null) {
			schemeId = (Integer) detailsMap.get("schemeId");
		}

		if (detailsMap.get("deptId") != null) {
			deptId = (Integer) detailsMap.get("deptId");
		}

		if (detailsMap.get("patientTypeId") != null) {
			patientTypeId = (Integer) detailsMap.get("patientTypeId");
		}
		if (detailsMap.get("serviceCentreId") != null) {
			serviceCentreId = (Integer) detailsMap.get("serviceCentreId");
		}
		LOGGER.debug("govin Impl sexId " + sexId + " schemeId " + schemeId + " deptId " + deptId + " patientTypeId "
				+ patientTypeId);

		/*commented by swarup on 01-02-2018
		 * List<MasEmployeeDepartment> departmentList = session.createCriteria(MasEmployeeDepartment.class)
				.add(Restrictions.eq("Id", deptId)).list();
		if (departmentList.size() > 0) {
			MasEmployeeDepartment masD = departmentList.get(0);
			if (masD.getEmpDeptName() != null) {
				deptName = masD.getEmpDeptName();
				map.put("deptName", deptName);
			}
		}*/
		
		
		/*List<MasDepartment> departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Id", deptId)).list();
		if (departmentList.size() > 0) {
			MasDepartment masD = departmentList.get(0);
			if (masD.getDepartmentName() != null) {
				deptName = masD.getDepartmentName();
				map.put("deptName", deptName);
			}
		}*/
		List<MasEmployeeDepartment> departmentList=session.createCriteria(MasEmployeeDepartment.class)
				.add(Restrictions.eq("Id", deptId)).list();
		if (departmentList.size() > 0) {
			MasEmployeeDepartment masD = departmentList.get(0);
			if (masD.getEmpDeptName() != null) {
				deptName = masD.getEmpDeptName();
				map.put("deptName", deptName);
			}
		}
		
		List<MasDepartment> serviceCentreList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Id", serviceCentreId)).list();
		if (serviceCentreList.size() > 0) {
			MasDepartment masD = serviceCentreList.get(0);
			if (masD.getDepartmentName() != null) {
				serviceCentreName = masD.getDepartmentName();
				map.put("serviceCentreName", serviceCentreName);
			}
		}

		List<MasScheme> schemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("Id", schemeId))
				.list();
		if (schemeList.size() > 0) {
			MasScheme masS = schemeList.get(0);
			if (masS.getSchemeName() != null) {
				schemName = masS.getSchemeName();
				map.put("schemName", schemName);
			}
		}

		List<MasAdministrativeSex> sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Id", sexId)).list();
		if (sexList.size() > 0) {
			MasAdministrativeSex sex = sexList.get(0);
			if (sex.getAdministrativeSexName() != null) {
				genName = sex.getAdministrativeSexName();
				map.put("genName", genName);
			}
		}

		List<MasPatientType> patientTypeList = session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Id", patientTypeId)).list();
		if (patientTypeList.size() > 0) {
			MasPatientType pat = patientTypeList.get(0);
			if (pat.getPatientTypeName() != null) {
				socialName = pat.getPatientTypeName();
				map.put("socialName", socialName);
			}
		}

		return map;
	}

	// added by amit das on 10-12-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitMobileNumberForOTP(final Box box) {

		LOGGER.debug("Inside submitMobileNumberForOTP ");
		Session session = getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String, Object> map = HMSUtil.getCurrentDateAndTime();
		String msg = null;
		try {
			String src = box.get("src");
			if (src != null) {
				
				String mobileNumber = box.get("mobileNo");
				String aadhaarNo = box.get("aadhaarNo");
				if (src.equalsIgnoreCase("web") && aadhaarNo != null && !aadhaarNo.trim().equals("")) {
					List<Patient> patientList = session.createCriteria(Patient.class)
							.add(Restrictions.eq("AadhaarNo", Long.parseLong(aadhaarNo))).list();
					if (patientList != null && patientList.size() > 0) {
						mobileNumber = patientList.get(0).getMobileNumber();
					} else {
						msg = "1";
					}
				}

				if (mobileNumber != null && !mobileNumber.trim().equals("")) {
					Date otpDate = new Date();
					String otpTime = (String) map.get("currentTime");
					Integer otp = HMSUtil.generateMobileVerificationOTP();
					String message = "One Time Password(OTP) for online verification for registration in eHealth is " + otp
							+ ". Use this OTP to complete the process";
					String responseCode = SMSHTTPSPostClient.sendOtpSMS(mobileNumber, message);
					LOGGER.debug("responseCode = " + responseCode);
					if (responseCode.equals("402")) {
						String verifiedStatus = "n";
						MobileRegistration mobileRegistration = new MobileRegistration();
						mobileRegistration.setMobileNo(mobileNumber);
						mobileRegistration.setOtp(otp);
						mobileRegistration.setOtpDate(otpDate);
						mobileRegistration.setOtpTime(otpTime);
						mobileRegistration.setVerifiedStatus(verifiedStatus);
						hbt.save(mobileRegistration);
						msg = "0";
					}
				}
			}
		} catch (Exception e) {
			msg = "1";
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		map.put("msg", msg);
		return map;
	}

	// added by amit das on 10-12-2016
	public Map<String, Object> sendSMSForAppointmentDetails(final Box box) {

		LOGGER.debug("Inside sendSMSForAppointmentDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		String mobileNumber = box.get("mobileNo");
		String deptName = box.get("deptName");
		String appointmentNo = box.get("appointmentNo");
		String hospName = box.get("hospName");
		String message = null;
		try {
			if ((mobileNumber != null && !mobileNumber.trim().equals(""))
					&& (deptName != null && !deptName.trim().equals(""))
					&& (appointmentNo != null && !appointmentNo.trim().equals(""))
					&& (hospName != null && !hospName.trim().equals(""))) {

				String appointmentDate = box.get("appointmentDate");
				message = "Your appointment for " + deptName + " at " + hospName + " on " + appointmentDate
						+ " has been created successfully. Your Token No. is " + appointmentNo;
				String responseCode = SMSHTTPSPostClient.sendSingleSMS(mobileNumber, message);
				LOGGER.debug("responseCode = " + responseCode);
				if (responseCode.equals("402")) {
					message = "0";
				}

			}
		} catch (Exception e) {
			message = "1";
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		map.put("msg", message);
		return map;
	}

	// added by amit das on 14-12-2016
	@SuppressWarnings("unchecked")
	public String updateMobileRegistration() {

		LOGGER.debug("Inside updateMobileRegistration ");
		String result = "fail";
		String message = null;
		Map<String, Object> map = HMSUtil.getCurrentDateAndTime();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(MobileRegistration.class)
					.add(Restrictions.eq("VerifiedStatus", "W").ignoreCase()).addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<MobileRegistration> mobileRegistrationList = criteria.list();

			if (mobileRegistrationList != null && mobileRegistrationList.size() > 0) {

				for (MobileRegistration mobileRegistration : mobileRegistrationList) {

					String verifiedStatus = "n";
					String mobileNumber = mobileRegistration.getMobileNo();
					int otp = HMSUtil.generateMobileVerificationOTP();
					String otpTime = (String) map.get("currentTime");
					Date otpDate = new Date();
					message = "One Time Password(OTP) for online verification for registration in eHealth is " + otp
							+ ". Use this OTP to complete the process";
					mobileRegistration.setOtp(otp);
					mobileRegistration.setOtpDate(otpDate);
					mobileRegistration.setOtpTime(otpTime);
					mobileRegistration.setVerifiedStatus(verifiedStatus);
					String responseCode = SMSHTTPSPostClient.sendOtpSMS(mobileNumber, message);
					LOGGER.debug("responseCode = " + responseCode);
					if (responseCode.equals("402")) {
						session.update(mobileRegistration);
						LOGGER.debug("mobileRegistration updated = " + mobileRegistration.getMobileNo()
								+ " with this otp = " + mobileRegistration.getOtp());
						result = "success";
					}
				}
				transaction.commit();
			}

		} catch (Exception e) {
			result = "fail";
			if (transaction != null) {
				transaction.rollback();
			}
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}

	// added by amit das on 14-12-2016
	@SuppressWarnings("unchecked")
	public String updatePatientAppointment() {

		LOGGER.debug("Inside updatePatientAppointment ");
		String result = "fail";
		String message = null;

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AppPatientAppointments.class)
					.add(Restrictions.eq("RegisteredStatus", "W").ignoreCase()).addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<AppPatientAppointments> appPatientAppointmentList = criteria.list();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			if (appPatientAppointmentList != null && appPatientAppointmentList.size() > 0) {
				for (AppPatientAppointments appPatientAppointment : appPatientAppointmentList) {
					if (appPatientAppointment != null && appPatientAppointment.getHin() != null
							&& appPatientAppointment.getDepartment() != null
							&& appPatientAppointment.getHospital() != null) {
						Patient patient = (Patient) session.get(Patient.class, appPatientAppointment.getHin().getId());
						MasDepartment department = (MasDepartment) session.get(MasDepartment.class,
								appPatientAppointment.getDepartment().getId());
						MasHospital hospital = (MasHospital) session.get(MasHospital.class, appPatientAppointment
								.getHospital().getId());
						String mobileNumber = patient.getMobileNumber();
						String deptName = department.getDepartmentName();
						String hospitalName = hospital.getHospitalName();
						int tokenNo = appPatientAppointment.getQueuePriority();
						Date appointmentDate = appPatientAppointment.getAppointmentDate();

						if ((mobileNumber != null && !mobileNumber.trim().equals(""))
								&& (deptName != null && !deptName.trim().equals("")) && (tokenNo != 0)
								&& (hospitalName != null && !hospitalName.trim().equals(""))) {
							message = "Your appointment for " + deptName + " at " + hospitalName + " on "
									+ dateFormat.format(appointmentDate)
									+ " has been created successfully. Your Token No. is " + tokenNo;

							String responseCode = SMSHTTPSPostClient.sendSingleSMS(mobileNumber, message);
							LOGGER.debug("responseCode for appointment sms = " + responseCode);
							if (responseCode.equals("402")) {
								appPatientAppointment.setRegisteredStatus("y");
								session.update(appPatientAppointment);
								System.out
										.println("Appointment Msg sent for " + appPatientAppointment.getPatientName());
								result = "success";
							} else {
								LOGGER.debug("Problem in sending sms for appointment");
							}
						}
					}
				}
				transaction.commit();
			}
		} catch (Exception e) {
			result = "fail";
			transaction.rollback();
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}

	// added by amit das on 20-12-2016
	public Map<String, Object> getHospitalData(final Map<String, Object> objectMap) {

		LOGGER.debug("Inside getHospitalData ");
		Map<String, Object> map = new HashMap<String, Object>();
		MasHospital hospital = null;
		int hospitalId = 0;
		Session session = getSession();
		if (objectMap != null && objectMap.get("hospitalId") != null) {
			hospitalId = (Integer) objectMap.get("hospitalId");
			if (hospitalId != 0) {
				hospital = (MasHospital) session.get(MasHospital.class, hospitalId);
			}
		}

		map.put("hospital", hospital);
		if (session != null) {
			session.close();
		}
		return map;
	}

	// added by amit das on 28-12-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> sendRegistrationConfirmMessage(final Box box) {

		LOGGER.debug("Inside sendRegistrationConfirmMessage ");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		String aadhaarNo = box.get("aadhaarNo");
		String message = null;
		try {
			if (aadhaarNo != null && !aadhaarNo.trim().equals("")) {
				List<Patient> patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("AadhaarNo", Long.parseLong(aadhaarNo))).list();
				if (patientList != null && patientList.size() == 1) {
					Patient patient = patientList.get(0);
					message = "Dear " + patient.getFullName()
							+ ", eHealth registration successful. Username and password is " + patient.getHinNo()
							+ ". You can change password after first log in. Thank You!";
					String responseCode = SMSHTTPSPostClient.sendSingleSMS(patient.getMobileNumber(), message);
					LOGGER.debug("responseCode = " + responseCode);
					if (responseCode.equals("402")) {
						message = "0";
					}
				}
			}

		} catch (Exception e) {
			message = "1";
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		}
		map.put("msg", message);
		return map;
	}

	// added by amit das on 12-08-2017
	public Map<String, Object> sendAppointmentCancellationMessage(final Box box) {

		LOGGER.debug("Inside sendAppointmentCancellationMessage ");
		Map<String, Object> map = new HashMap<String, Object>();
		String appointmentNo = box.get("appointmentNo");
		String mobileNo = box.get("mobileNo");
		String message = null;
		try {
			if (appointmentNo != null && !appointmentNo.trim().equals("") && mobileNo != null
					&& !mobileNo.trim().equals("")) {

				message = "Your Appointment No - " + appointmentNo + " has been successfully cancelled.";
				String responseCode = SMSHTTPSPostClient.sendSingleSMS(mobileNo, message);
				LOGGER.debug("responseCode = " + responseCode);
				if (responseCode.equals("402")) {
					message = "0";
				}

			}

		} catch (Exception e) {
			message = "1";
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		map.put("msg", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getAmbulanceStatus(int inpatientId) {
		LOGGER.debug("Inside sendAppointmentCancellationMessage ");
		String ambulanceStatus = "";
		Session session = (Session) getSession();

		try {
			if (inpatientId != 0) {
				List<AmbulanceRegister> ambulanceStList = session.createCriteria(AmbulanceRegister.class)
						.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
				for (AmbulanceRegister ar : ambulanceStList) {
					ambulanceStatus = ar.getStatus();
				}
			}

		} catch (HibernateException e) {
			LOGGER.error("HibernateException Occurred" + e.getStackTrace().toString());
		}

		return ambulanceStatus;
	}
	
	// Added by Arbind 11-12-2017
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateDailyVisitReport(final int hospitalId) {

		LOGGER.debug("Inside populateDailyVisitReport ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployeeDepartment> employeeDepartmentList = null;
		Session session = getSession();
		try {
			List<Object[]> hrInstWiseEmpDeptStringList = new ArrayList<Object[]>();
			hrInstWiseEmpDeptStringList = session.createCriteria(HrInstEmpDept.class)
					.createAlias("Institute", "i").add(Restrictions.eq("i.Id",hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("EmployeeDepartment"))
					.add(Projections.property("Id"))).list();
			
			List<Integer> hidList = new ArrayList<Integer>();

			if(hrInstWiseEmpDeptStringList.size() > 0){
				
				Object[] obj = hrInstWiseEmpDeptStringList.get(0);
				String hIds = (String)obj[0];
				String[] houseId = hIds.split(",");
				for (int i = 0; i < houseId.length; i++) {
					hidList.add(Integer.parseInt(houseId[i].trim()));
				}
				employeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class)
						.add(Restrictions.in("Id", hidList))
						.addOrder(Order.asc("EmpDeptName")).list();
			}
			map.put("employeeDepartmentList", employeeDepartmentList);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceCentreDoctors(Box box) {
		
		LOGGER.debug("Inside getServiceCentreDoctors ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int hospitalId=0;
		int departmentId = 0;
		try {
			hospitalId = (Integer)box.getInt("hospitalId");
			departmentId = (Integer)box.getInt("departmentId");
		
			empList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmployeeDepartment.Id", departmentId))
					.addOrder(Order.asc("EmployeeName")).list();
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id", hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.EmpDept.Id", departmentId))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName")).list();
			map.put("empList", empList);
			map.put("departmentList", departmentList);
		} catch(Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public String sendInvestigationResultSMS() {

		LOGGER.debug("Inside sendInvestigationResultSMS ");
		String result = "fail";
		String message = null;
		String mobileNumber = null;
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String currentTime = (String) utilMap.get("currentTime");
		Transaction transaction = null;
		Session session = null;
		try {
			session = getSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(OneToOne.class)
					.add(Restrictions.eq("Status", "U").ignoreCase()).addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<OneToOne> receiverList = criteria.list();

			if (receiverList != null && receiverList.size() > 0) {
				for (OneToOne receiver : receiverList) {
					mobileNumber = receiver.getMobileNo();
					message = receiver.getMessage();
					if (StringUtils.isNotBlank(mobileNumber) && StringUtils.isNotBlank(mobileNumber)) {						
							String responseCode = SMSHTTPSPostClient.sendSingleSMS(mobileNumber.trim(), message);
							LOGGER.debug("responseCode for InvestigationResultSMS = " + responseCode);
							if (responseCode.equals("402")) {
								receiver.setStatus("Y");
								receiver.setSentDate(new Date());
								receiver.setSentTime(currentTime);
								session.update(receiver);
								System.out.println("InvestigationResult Msg sent for " + mobileNumber);
								result = "success";
							} else {
								LOGGER.debug("Problem in sending sms for InvestigationResult");
							}
						
					}
				}
			}
			transaction.commit();
		} catch (Exception e) {
			result = "fail";
			transaction.rollback();
			LOGGER.error("Exception Occurred : " + e.getStackTrace().toString());
		} finally {
			if (session != null) {
				releaseSession(session);
			}
		}

		return result;
	}

	@Override
	public Map<String, Object> getDoctors(Box box) {
		

		
		LOGGER.debug("Inside getServiceCentreDoctors ");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Session session = (Session)getSession();
		int hospitalId=0;
		int serviceCentreId = 0;
		try {
			hospitalId = (Integer)box.getInt("hospitalId");
			serviceCentreId = (Integer)box.getInt("serviceCentreId");
		
			
			
			List<Object[]> empScMappingList = new ArrayList<Object[]>();
			empScMappingList = session.createCriteria(EmpScMapping.class)
					.add(Restrictions.eq("Department.Id",serviceCentreId))
					.createAlias("Hospital", "i").add(Restrictions.eq("i.Id",hospitalId))
					.createAlias("Employee", "e")
					.setProjection(Projections.projectionList().add(Projections.property("e.Id"))
					.add(Projections.property("e.EmployeeName"))).list();
			
			
			
			map.put("empScMappingList", empScMappingList);
		} catch(Exception e) {
			LOGGER.error("Exception Occurred" + e.getStackTrace().toString());
		}
		return map;
	
		
		
	}
	
}
