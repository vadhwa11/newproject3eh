/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * RegistrationDataServiceImpl.java �
 * Purpose of the class - This is for Registration, Visit Module.
 * It contains Registration and Visit of the patient.
 * @author  Ritu Sahu
 * Create Date: 3rd Jan,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.adt.dataservice;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
//import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;

import jkt.hms.masters.business.AppInvestigationAppointments;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.AppSetup;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.CentralServerPatientAppointmentData;
import jkt.hms.masters.business.CentralServerPatientRegData;
import jkt.hms.masters.business.CentralServerVisitData;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.HrDutyScheduleT;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.LeanServerPatientAppointmentData;
import jkt.hms.masters.business.LeanServerPatientRegData;
import jkt.hms.masters.business.LeanServerVisitData;
import jkt.hms.masters.business.MasAddressType;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBlock;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasCaseType;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasCompany;
import jkt.hms.masters.business.MasComplaint;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiagnosisConclusion;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasLsgType;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReference;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasServiceStatus;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasVisaType;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MobileRegistration;
import jkt.hms.masters.business.OnlinePatientAddress;
import jkt.hms.masters.business.OnlinePatientPortal;
import jkt.hms.masters.business.OnlinePatientVisit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientCategoryDetails;
import jkt.hms.masters.business.PatientLogUpdate;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhAlert;
import jkt.hms.masters.business.PhAncSurvey;
import jkt.hms.masters.business.PhFamilySurvey;
import jkt.hms.masters.business.PhHouseSurvey;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasLocalityType;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.PharmacyLabQueue;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.RsbyCardDetails;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.QueueManagement;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.SMSHTTPSPostClient;
import jkt.hrms.masters.business.MasQualification;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.examples.ExampleReceiverApplication;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v22.message.ACK;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ADT_A08;
import ca.uhn.hl7v2.model.v22.message.ORU_R01;
import ca.uhn.hl7v2.model.v22.segment.EVN;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.OBX;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.model.v22.segment.PV2;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;


public class RegistrationDataServiceImpl extends HibernateDaoSupport implements
		RegistrationDataService {

	private static final String SPACE = " ";
	private static final Logger logger = org.apache.log4j.Logger.getLogger(RegistrationDataServiceImpl.class);

	@SuppressWarnings("unchecked")
	public Map<String, Object> visitCreation(String hinNo) {

		logger.debug("Inside Method: visitCreation");

		Session session = (Session) getSession();
		Map<String, Object> dataMap = new HashMap<>();
		List<Patient> patientDetailsList = new ArrayList<>();
		List<Visit> visitList = new ArrayList<>();
		int visitNo = 0;
		//String hinNO = hinNo;
		int hinId = 0;
		if (hinNo != null && !hinNo.equals("")) {
			try {
				patientDetailsList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).list();

				dataMap.put("patientDetailsList", patientDetailsList);

				if (patientDetailsList.size() != 0) {
					for (Patient patient : patientDetailsList) {
						hinId = patient.getId();

					}
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
				dataMap.put("visitList", visitList);
				dataMap.put("visitNo", visitNo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMsgForReg(int deptId) {

		logger.debug("Inside Method: showMsgForReg");
		Map<String, Object> map = new HashMap<>();

		Session session = (Session) getSession();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		try {
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("ChargeType", "mct")
					.add(Restrictions.eq("mct.Id", 6))
					.addOrder(Order.asc("ChargeCodeName")).list();

			if (chargeCodeList.size() > 0) {
				map.put("chargeCodeList", chargeCodeList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "y"))
					.addOrder(Order.asc("AuthorizerName")).list();
			if (authorizerList.size() > 0) {
				map.put("authorizerList", authorizerList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getLastVisitDetails(Map<String, Object> map) {
		logger.debug("Inside Method: getLastVisitDetails");
		Map<String, Object> getDataMap = new HashMap<>();
		List<Patient> searchDataList = new ArrayList<>();
		List<Visit> visitList = new ArrayList<>();
		String hinNo = "";
		int deptId = 0;
		int hinId = 0;
		Session session = (Session) getSession();
		if (map.get("deptId") != null) {
			String abcd = (String) map.get("deptId");
			deptId = Integer.parseInt(abcd);
		}
		if (map.get("hinNo") != null) {
			hinNo = (String) map.get("hinNo");
			try {
				searchDataList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).list();
				if (searchDataList.size() != 0) {
					for (Patient patient : searchDataList) {
						hinId = patient.getId();
					}
				}
				getDataMap.put("searchDataList", searchDataList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				visitList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("Hin.Id", hinId))
						.add(Restrictions.eq("Department.Id", deptId)).list();

				getDataMap.put("visitList", visitList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return getDataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePatientDetailsToVisit(Map<String, Object> map) {
		logger.debug("Inside Method: populatePatientDetailsToVisit");
		Map<String, Object> getDataMap = new HashMap<>();
		List<Patient> searchDataList = new ArrayList<>();
		List<Visit> visitList = new ArrayList<>();
		List<MasChargeCode> chargeList = new ArrayList<>();
		//long abc = 0;
		int hinId = 0;
		String newRegis = "NEWREGN";
		String hinNo = null;
		Session session = (Session) getSession();
		if (map.get("uhid") != null) {

			hinNo = (String) map.get("uhid");
		}
		try {
			searchDataList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();

			if (searchDataList.size() != 0) {
				for (Patient patient : searchDataList) {
					hinId = patient.getId();
				}
			}
			getDataMap.put("searchDataList", searchDataList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			visitList = session.createCriteria(Visit.class)
					.add(Restrictions.eq("Hin.Id", hinId)).list();

			getDataMap.put("visitList", visitList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			chargeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeCode", newRegis)).list();
			getDataMap.put("chargeList12", chargeList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return getDataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePatientDetailsToRegistration(Map<String, Object> map) {
		logger.debug("Inside Method: populatePatientDetailsToRegistration");
		Map<String, Object> getDataMap = new HashMap<>();
		List<Patient> searchDataList = new ArrayList<>();

		long abc = 0;
		String adno = null;
		Session session = (Session) getSession();
		if (map.get("uhid") != null) {

			adno = (String) map.get("uhid");
			logger.debug(adno + "uhid");
			abc = Long.parseLong(adno);
			logger.debug(abc + "abc");

		}
		searchDataList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("AadhaarNo", abc)).list();
		getDataMap.put("searchDataList", searchDataList);
		return getDataMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see jkt.hms.adt.dataservice.RegistrationDataService#
	 * showSearchPatientRecordsForUpdateJsp(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showSearchPatientRecordsForUpdateJsp(Map<String, Object> getDataMap) {

		logger.debug("Inside Method: showSearchPatientRecordsForUpdateJsp");

		Map<String, Object> map = new HashMap<>();

		List<Patient> searchDataList = new ArrayList<>();
		List<MasDistrict> districtList = new ArrayList<>();
		List<MasLsg> lsgNameList = new ArrayList<MasLsg>();
		List<MasLsgType> lsgTypeList = new ArrayList<MasLsgType>();

		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<Object[]> patientTypeList = new ArrayList<>();

		List<Object[]> otherCategoryList = new ArrayList<>();

		List<Object[]> titleList = new ArrayList<>();
		List<Object[]> casteList = new ArrayList<>();

		List<MasCountry> countryList = new ArrayList<>();
		List<MasVisaType> visaTypeList = new ArrayList<>();
		List<MasState> stateList = new ArrayList<>();

		List<PhMasLocalityType> localityList = new ArrayList<>();

		List<MasOccupation> occupationList = new ArrayList<>();

		List<MasAdministrativeSex> sexList = new ArrayList<>();

		//HospitalParameters hospitalParameters = new HospitalParameters();
		List<Object[]> postCodeList = new ArrayList<>();
		List<Object[]> villageList = new ArrayList<>();
		List<MasQualification> educationList = new ArrayList<>();

		List<MasTaluk> talukList = new ArrayList<>();
		List<MasIdCard> idCardList = new ArrayList<>();
		List<MasHospital> subCenterList = new ArrayList<>();

		List<MasBloodGroup> bloodGroupList = new ArrayList<>();

		Session session = (Session) getSession();

		boolean searchStatus = false;
		Criteria crt = null;

		String fullName = "";
		String uhinNo = "";
		String dob = "";
		String mobno = "";

		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
		int stateId=Integer.parseInt(prop.getProperty("stateId"));
		districtList = session.createCriteria(MasDistrict.class)
				.addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		lsgNameList = session.createCriteria(MasLsg.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		lsgTypeList = session.createCriteria(MasLsgType.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		String queryForCaste = "select caste_id,caste_name from mas_caste where status='Y' ";
		casteList = /*
					 * session.createCriteria(MasCaste.class)
					 * .add(Restrictions.eq("Status",
					 * "y")).addOrder(Order.asc("CasteName")).list();
					 */
		session.createSQLQuery(queryForCaste).list();

		subCenterList = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "hospitaltype")
				.addOrder(Order.asc("HospitalName"))
				.add(Restrictions.eq("hospitaltype.Id", 6))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		visaTypeList = session.createCriteria(MasVisaType.class)
				.addOrder(Order.asc("VisaTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		localityList = session.createCriteria(PhMasLocalityType.class)
				.addOrder(Order.asc("LocalityDescription"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		districtList = session.createCriteria(MasDistrict.class)
				.addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		countryList = session.createCriteria(MasCountry.class)
				.addOrder(Order.asc("CountryName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		stateList = session.createCriteria(MasState.class)
				.addOrder(Order.asc("StateName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		/*villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();*/
		villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("VillageName"))).list();
		postCodeList = session.createCriteria(MasPostCode.class)
				.addOrder(Order.asc("PostCodeName"))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("PostCodeName"))).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		occupationList = session.createCriteria(MasOccupation.class)
				.addOrder(Order.asc("OccupationName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		educationList = session.createCriteria(MasQualification.class)
				.addOrder(Order.asc("QualificationName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		lsgNameList = session.createCriteria(MasLsg.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		lsgTypeList = session.createCriteria(MasLsgType.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		talukList = session.createCriteria(MasTaluk.class)
				.addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		idCardList = session.createCriteria(MasIdCard.class)
				.addOrder(Order.asc("IdCardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		String queryForPatientType = "select patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where status='Y' and Type='s'";
		patientTypeList = session.createSQLQuery(queryForPatientType).list();

		String queryPatientType = "select patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where status='Y' and Type='o'";
		otherCategoryList = session.createSQLQuery(queryPatientType).list();

		String queryTitle = "select title_id,title_name,title_code from mas_title where status='Y'";
		titleList = session.createSQLQuery(queryTitle).list();

		Criteria c = session.createCriteria(HospitalParameters.class);
		/*crt = session.createCriteria(Patient.class)
				     .createAlias("Member", "member")
				     .createAlias("member.House", "house");
		if (getDataMap.get("fullName") != null) {
			fullName = (String) getDataMap.get("fullName");
			crt.add(Restrictions.like("PFirstName", fullName + "%")
					.ignoreCase());
			searchStatus = true;
		}
		if (getDataMap.get("uhinNo") != null) {
			uhinNo = (String) getDataMap.get("uhinNo");
			crt.add(Restrictions.eq("HinNo", uhinNo));
			searchStatus = true;
		}

		if (getDataMap.get("dob") != null) {
			dob = (String) getDataMap.get("dob");
			crt.add(Restrictions.eq("DateOfBirth",
					HMSUtil.convertStringTypeDateToDateType(dob)));
			searchStatus = true;
		}

		if (getDataMap.get("mobno") != null) {
			mobno = (String) getDataMap.get("mobno");
			crt.add(Restrictions.eq("MobileNumber", mobno));
			searchStatus = true;
		}*/
/*		int districtId=0;
		if (getDataMap.get("districtId") != null) {
            districtId=(Integer)getDataMap.get("districtId");
			crt.createAlias("member.AadhaarDistrict", "dis")
		       .add(Restrictions.eq("dis.Id", districtId));
			searchStatus = true;
		}
		int locality=0;
		if (getDataMap.get("locality") != null) {
            locality=(Integer)getDataMap.get("locality");
			crt.createAlias("house.Panchayat","panchayat")
		       .add(Restrictions.eq("panchayat.Id", locality));
			searchStatus = true;
		}
		int wardId=0;
		if (getDataMap.get("ward") != null) {
             wardId=(Integer)getDataMap.get("ward");
			 crt.createAlias("house.Ward","ward")
			   .add(Restrictions.eq("ward.Id", wardId));
			searchStatus = true;
		}*/
       
		/*if (searchStatus){
			searchDataList = crt.list();
		}*/
		int flag=0;
		String qry=null;
		qry="select * from patient patient left outer join  "
				+ "ph_member_survey pms on patient.member_id= pms.survey_id "
				+ "left outer join  ph_house_survey phs on pms.house_id=phs.house_hold_id "
				+ "left outer join  mas_ward mw on mw.ward_id=phs.ward_id "
				+ "left outer join  mas_lsg mls on mls.lsg_id=phs.panchayat_id where ";
		
		if (getDataMap.get("fullName") != null) {
			fullName = (String) getDataMap.get("fullName");
			qry = qry+ " patient.full_name like '%"+fullName+"%'";
			searchStatus = true;
			flag=1;
		}
		
		if (getDataMap.get("uhinNo") != null) {
			if(flag==1){
			qry = qry+ " and patient.hin_no = :hinNo";
			}else{
				qry = qry+ " patient.hin_no = :hinNo";
				flag=1;
			}
			searchStatus = true;
		}
		if (getDataMap.get("dob") != null) {
			if(flag==1){
			qry = qry+ " and patient.date_of_birth = :dateOfBirth";
			}else{
				qry = qry+ " patient.date_of_birth = :dateOfBirth";
				flag=1;
			}
			searchStatus = true;
		}

		if (getDataMap.get("mobno") != null) {
			if(flag==1){
			qry = qry+ " and patient.mobile_number = :mobileNo";
			}else{
				qry = qry+ " patient.mobile_number = :mobileNo";
				flag=1;
			}
			searchStatus = true;
		}
		int districtId=0;
		if (getDataMap.get("districtId") != null) {
			if(flag==1){
			qry = qry+ " and mls.district_id = :districtId";
			}else{
				qry = qry+ " mls.district_id = :districtId";
				flag=1;
			}
			searchStatus = true;
		}
		int locality=0;
		if (getDataMap.get("locality") != null) {
			qry = qry+ " and mls.lsg_id = :locality";
			searchStatus = true;
		}
		int wardId=0;
		if (getDataMap.get("ward") != null) {
			qry = qry+ " and mw.ward_id = :wardId";
			searchStatus = true;
		}
		
		Query query = session.createSQLQuery(qry).addEntity(Patient.class);
               
	if(getDataMap.get("uhinNo")!=null && !getDataMap.get("uhinNo").equals("")){
		uhinNo = (String) getDataMap.get("uhinNo");
		query.setParameter("hinNo", uhinNo);
		searchStatus = true;
	}
	if(getDataMap.get("dob")!=null && !getDataMap.get("dob").equals("")){
		dob = (String) getDataMap.get("dob");
		query.setParameter("dateOfBirth", HMSUtil.convertStringTypeDateToDateType(dob));
		searchStatus = true;
	}
		
	if(getDataMap.get("mobno")!=null && !getDataMap.get("mobno").equals("")){
		mobno = (String) getDataMap.get("mobno");
		query.setParameter("mobileNo", mobno);
		searchStatus = true;
	}
	if(getDataMap.get("districtId")!=null && !getDataMap.get("districtId").equals("")){
		districtId = (Integer) getDataMap.get("districtId");
		query.setParameter("districtId", districtId);
		searchStatus = true;
	}
	if(getDataMap.get("locality")!=null && !getDataMap.get("locality").equals("")){
		locality = (Integer) getDataMap.get("locality");
		query.setParameter("locality", locality);
		searchStatus = true;
	}
	if(getDataMap.get("ward")!=null && !getDataMap.get("ward").equals("")){
		wardId = (Integer) getDataMap.get("ward");
		query.setParameter("wardId", wardId);
		searchStatus = true;
	}
		
		if (searchStatus){

					searchDataList =(List<Patient>)query.list();
			
		}
		
		int patientHinId=0;
		List<PatientAddress> addressList= new ArrayList<>();
		Map<String,Object> addressMap= new HashMap<>();
		String aadharAddress="";
		String aadharDistrict="";
		String houseNo="";
		String streetName="";
		String taluk="";
		String ward="";

		if(null !=searchDataList && searchDataList.size()>0){
			for(Patient P:searchDataList){
				patientHinId=P.getId();
			}
			crt=session.createCriteria(PatientAddress.class).createAlias("Hin", "Hin").createAlias("AddressType", "AddressType")
					.add(Restrictions.eq("Hin.Id", patientHinId)).add(Restrictions.eq("AddressType.Id", 2));
			addressList=crt.list();
			if(null !=addressList && addressList.size()>0){
			for(PatientAddress address:addressList){
				if(null !=address.getAddressType() && address.getAddressType().getId()==2){
					if(null !=address.getDistrict()){
						aadharDistrict=address.getDistrict().getDistrictName();
					}
					if(null !=address.getHouseNo())
						houseNo=address.getHouseNo();
					
					if(null !=address.getStreetRoad())
						streetName=address.getStreetRoad();
					
					aadharAddress="" + houseNo +SPACE+streetName+SPACE+aadharDistrict;
					logger.debug("update Address "+aadharAddress);
					logger.debug("update patientHinId "+patientHinId);
					addressMap.put(String.valueOf(patientHinId), aadharAddress);
					
					 
				}
				
				else if(null !=address.getAddressType() && address.getAddressType().getId()==1){
					if(null !=address.getDistrict()){
						aadharDistrict=address.getDistrict().getDistrictName();
					}
					if(null !=address.getTaluk())
						taluk=address.getTaluk().getTalukName();
					
					if(null !=address.getWardNo())
						ward=address.getWardNo().getWardName();
					
					aadharAddress="" + taluk +SPACE+ward+SPACE+aadharDistrict;
					addressMap.put(String.valueOf(patientHinId), aadharAddress);
					
					 
				}
				
			}
		}
		}
		
		map.put("addressMap", addressMap);
		map.put("searchDataList", searchDataList);
		map.put("districtList", districtList);
		map.put("lsgNameList", lsgNameList);
		map.put("lsgTypeList", lsgTypeList);

		map.put("patientTypeList", patientTypeList);

		map.put("otherCategoryList", otherCategoryList);

		map.put("localityList", localityList);
		map.put("countryList", countryList);
		map.put("villageList", villageList);
		map.put("postCodeList", postCodeList);
		map.put("occupationList", occupationList);
		map.put("educationList", educationList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("talukList", talukList);
		map.put("sexList", sexList);
		map.put("titleList", titleList);
		map.put("districtList", districtList);
		map.put("relationList", relationList);
		map.put("visaTypeList", visaTypeList);
		map.put("idCardList", idCardList);

		map.put("stateList", stateList);

		map.put("casteList", casteList);

		map.put("subCenterList", subCenterList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSearchPatientRecordsForVisitJsp(Map<String, Object> map) {

		logger.debug("Inside Method: showSearchPatientRecordsForVisitJsp");
		Map<String, Object> getDataMap = new HashMap<>();
		List<Patient> searchDataList = new ArrayList<>();
		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<MasEmployee> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		Map<Integer, Object> addressmap = new HashMap<>();
		List<MasScheme> schemeList= new ArrayList<>();

		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
		
		List<MasSession> masSessionList = new ArrayList<>();
		boolean stauts = false;

		String hinNo = "";
		String fullName = "";
		String mobNo = "";

		
		Date dateOfBirth = null;
		
		int hospitalId = 0;
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;

		String FromAge = "";
		String toAge = "";
		
		String patientDeadStatus="";

		int page = (Integer) map.get("page");

		Criteria crt = null;
		Session session = (Session) getSession();

		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		if (map.get("uhid") != null) {
			hinNo = (String) map.get("uhid");
		}
		if (map.get("fullName") != null) {
			fullName = (String) map.get("fullName");
		}
		if (map.get("mobno") != null) {
			mobNo = (String) map.get("mobno");
		}
		if (map.get("dateOfBirth") != null) {
			dateOfBirth = (Date) map.get("dateOfBirth");
		}
		if (map.get("FromAge") != null) {
			FromAge = (String) map.get("FromAge");
		}
		if (map.get("toAge") != null) {
			toAge = (String) map.get("toAge");
		}
		long aadhar = 0;
		if(map.get("aadhar") != null){
			aadhar = (Long)map.get("aadhar");
		}
		try {
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.addOrder(Order.asc("AuthorizerName")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			crt = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"))
					;

			Criteria crty = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"));
			crty.setProjection(Projections.rowCount());
			
			Criteria	patientDeadCrty = session.createCriteria(Patient.class).add(Restrictions.like("PatientStatus", "Expire"+"%").ignoreCase());

			if (hinNo != null && !hinNo.equals("") && !hinNo.equals("null")) {
				crt.add(Restrictions.eq("HinNo", hinNo));
				crty.add(Restrictions.eq("HinNo", hinNo));
				patientDeadCrty.add(Restrictions.eq("HinNo", hinNo));
				
				stauts = true;
				getDataMap.put("shinNo", hinNo);
			}

			if (fullName != null && !fullName.equals("")
					&& !fullName.equals("null")) {
				
				crt.add(Restrictions.like("PFirstName", fullName + "%")
						.ignoreCase());
				crty.add(Restrictions.like("PFirstName", fullName + "%")
						.ignoreCase());
				
				patientDeadCrty.add(Restrictions.eq("PFirstName", fullName)
						.ignoreCase());
				stauts = true;
				getDataMap.put("sfullName", fullName);
			}
			if (mobNo != null && !mobNo.equals("") && !mobNo.equals("null")) {
				crt.add(Restrictions.like("MobileNumber", mobNo + "%"));
				crty.add(Restrictions.like("MobileNumber", mobNo + "%"));
				
				patientDeadCrty.add(Restrictions.like("MobileNumber", mobNo));
				stauts = true;
				getDataMap.put("smobNo", mobNo);
			}
			
			  if(FromAge!=null && !FromAge.equals("") && Integer.parseInt(FromAge) >0){
			  
			  crt.add(Restrictions.ge("PatientAge", Integer.parseInt(FromAge)));
			  crty.add(Restrictions.ge("PatientAge", Integer.parseInt(FromAge)));
			  stauts=true;
			  getDataMap.put("FromAge", FromAge); 
			  }
			  
			  if(toAge !=null && !toAge.equals("") && Integer.parseInt(toAge) >0 ){
				  
				  crt.add(Restrictions.le("PatientAge", Integer.parseInt(toAge)));
				  crty.add(Restrictions.le("PatientAge", Integer.parseInt(toAge)));
				  stauts=true;
				  getDataMap.put("toAge", toAge); 
				 }
			 
			if (dateOfBirth != null && !dateOfBirth.equals("")
					&& !dateOfBirth.equals("null")) {
				crt.add(Restrictions.eq("DateOfBirth", dateOfBirth));
				crty.add(Restrictions.eq("DateOfBirth", dateOfBirth));
				
				patientDeadCrty.add(Restrictions.eq("DateOfBirth", dateOfBirth));
				
				stauts = true;
				getDataMap.put("sdateOfBirth", dateOfBirth);
			}
			if(aadhar!=0){
				crt.add(Restrictions.eq("AadhaarNo", aadhar));
				crty.add(Restrictions.eq("AadhaarNo", aadhar));
				stauts = true;
				getDataMap.put("aadhar", aadhar);
				
			}
			if(patientDeadCrty.list().size() > 0){
				patientDeadStatus="Patient Dead";
			}
			crt.addOrder(Order.asc("PFirstName"));
			noOfRecords = crt.list().size();//added by govind 11-10-2016
			crt.setFirstResult((page - 1)*recordsPerPage);
			crt.setMaxResults(recordsPerPage);
			
			if (stauts && crt.list().size() > 0) {
				searchDataList = crt.list();
				
				/*
				 * List<PatientAddress> addressList = new
				 * ArrayList<PatientAddress>();
				 */
				for (Patient patient : searchDataList) {
					int hinId = patient.getId();
					crt = session.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hinId")
							.createAlias("AddressType", "AddressId");
					crt.add(Restrictions.eq("AddressId.Id", 1));
					crt.add(Restrictions.eq("hinId.Id", hinId));
					
					addressmap.put(hinId, crt.list());
					
					if(crt.list().size() > 0){
						PatientAddress ptadd = (PatientAddress)crt.list().get(0);
						if(ptadd.getLocality()!=null){
							getDataMap.put("locality", ptadd.getLocality().getLocalityName());
						}
					}
				}
			}

			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			complaintList = session.createCriteria(MasComplaint.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.Id",1))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			
			
			nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.ne("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();

			caseTypeList = session.createCriteria(MasCaseType.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			List<Integer>chargeType= new ArrayList<>();
			chargeType.add(5);
			chargeType.add(6);
			chargeType.add(9);
			chargeType.add(34);
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.in("ChargeType.Id",chargeType))
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.addOrder(Order.asc("ChargeCodeName")).list();
			
			masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
					.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			schemeList = session.createCriteria(MasScheme.class)
					.addOrder(Order.asc("SchemeName"))
					.add(Restrictions.eq("Status", "Y")).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		getDataMap.put("schemeList", schemeList);
		getDataMap.put("complaintList", complaintList);
		getDataMap.put("departmentList", departmentList);
		getDataMap.put("doctorList", doctorList);
		getDataMap.put("caseTypeList", caseTypeList);
		getDataMap.put("diagnosisList", diagnosisList);
		getDataMap.put("searchDataList", searchDataList);
		getDataMap.put("chargeCodeList", chargeCodeList);
		getDataMap.put("authorizerList", authorizerList);

		getDataMap.put("noOfPages", noOfPages);
		getDataMap.put("currentPage", page);
		getDataMap.put("addressmap", addressmap);
		getDataMap.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		getDataMap.put("masSessionList", masSessionList);
		getDataMap.put("patientDeadStatus", patientDeadStatus);
		
		return getDataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientFromCitizen(Map<String, Object> map) {

		logger.debug("Inside Method: searchPatientFromCitizen");

		Map<String, Object> getDataMap = new HashMap<>();
		List<PhMemberSurvey> searchDataList = new ArrayList<>();

		//String hinNo = "";
		String fullName = "";
		String dob = "";
		Date dateOfBirth = null;
		int districtId = 0;
		String mobileNumber = "";
		boolean searchStatus = false;
		int recordsPerPage = 5;
		String citzenAadhaar="";

		int page = (Integer) map.get("page");

		Session session = (Session) getSession();

		if (map.get("districtId") != null) {

			districtId = (Integer) map.get("districtId");
		}
		if (map.get("fullName") != null) {
			fullName = (String) map.get("fullName");
			
		}
		
		if (map.get("citzenAadhaar") != null) {
			citzenAadhaar = (String) map.get("citzenAadhaar");
		}
		
		
		if (map.get("mobileNumber") != null) {
			mobileNumber = (String) map.get("mobileNumber");
		}
		if (map.get("dob") != null) {
			dob = (String) map.get("dob");
			dateOfBirth = HMSUtil.convertStringTypeDateToDateType(dob);
		}
		Criteria crt =null;
	 crt = session.createCriteria(PhMemberSurvey.class).add(Restrictions.isNull("UhidNo"));
		crt.setFirstResult((page - 1)*recordsPerPage);
		crt.setMaxResults(recordsPerPage);

		Criteria crty = session.createCriteria(PhMemberSurvey.class).add(Restrictions.isNull("UhidNo"));
		crty.setProjection(Projections.rowCount());

		logger.debug("fullName"+fullName);


		if (null != fullName && !fullName.equals("")) {

			crt.add(Restrictions.like("Name", fullName.trim() +"%").ignoreCase());
			crty.add(Restrictions.like("Name", fullName +"%").ignoreCase());

			searchStatus = true;
		}

		if (null != citzenAadhaar && !citzenAadhaar.equals("")) {
			logger.debug("citzenAadhaar"+citzenAadhaar);
			crt.add(Restrictions.eq("AadhaarNo",Long.parseLong(citzenAadhaar) ));
			crty.add(Restrictions.eq("AadhaarNo",Long.parseLong(citzenAadhaar) ));

			searchStatus = true;
		}
		if (null != dateOfBirth) {

			crt.add(Restrictions.eq("DateOfBirth", new java.sql.Date(
					dateOfBirth.getTime())));
			crty.add(Restrictions.eq("DateOfBirth", new java.sql.Date(
					dateOfBirth.getTime())));

			searchStatus = true;
		}
		if (districtId > 0) {
			crt.createAlias("AadhaarDistrict", "dist");
			crt.add(Restrictions.eq("dist.Id", districtId));

			crty.createAlias("AadhaarDistrict", "dist");
			crty.add(Restrictions.eq("dist.Id", districtId));

			searchStatus = true;
		}
		if (null != mobileNumber && !mobileNumber.equals("")) {

			crt.add(Restrictions.eq("ContactNo", mobileNumber));
			crty.add(Restrictions.eq("ContactNo", mobileNumber));
			searchStatus = true;
		}
		/*
		 * if (null != HouseNo && !HouseNo.equals("")) {
		 * crt.add(Restrictions.eq("MobileNumber", HouseNo)); }
		 */
		boolean citizenStatus=false;
		if (searchStatus) {
			if(null !=crt && crt.list() !=null){
			searchDataList = crt.list();
			citizenStatus=true;
			}
		}

		int noOfRecords = (Integer) crty.uniqueResult();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		

		getDataMap.put("noOfPages", noOfPages);
		getDataMap.put("currentPage", page);
		getDataMap.put("fullName", fullName);
		getDataMap.put("dob", dob);
		getDataMap.put("mob", mobileNumber);
		getDataMap.put("searchDataList", searchDataList);
		getDataMap.put("citizenStatus", citizenStatus);
		return getDataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSearchPatientRecords(Map<String, Object> map) {

		logger.debug("Inside Method: showSearchPatientRecords");

		Map<String, Object> getDataMap = new HashMap<>();
		List<Patient> searchDataList = new ArrayList<>();
		List<PatientAddress> addressList = new ArrayList<>();
		Map<Integer, String> searchAddress = new HashMap<>();
		List<Visit> visitDetails = new ArrayList<>();
		String ppaddress = "";

		String hinNo = "";
		String fullName = "";
		String dob = "";
		Date dateOfBirth = null;
		int districtId = 0;
		String mobileNumber = "";
		int patientHinNo = 0;
		boolean searchStatus = false;
		int recordsPerPage = 5;

		int page = (Integer) map.get("page");

		Session session = (Session) getSession();

		if (map.get("uhid") != null) {

			hinNo = (String) map.get("uhid");
		}
		if (map.get("districtId") != null) {

			districtId = (Integer) map.get("districtId");
		}
		if (map.get("fullName") != null) {
			fullName = (String) map.get("fullName");
			logger.debug(" fullName " + fullName);

		}
		if (map.get("mobileNumber") != null) {
			mobileNumber = (String) map.get("mobileNumber");
		}
		if (map.get("dob") != null) {
			dob = (String) map.get("dob");
			dateOfBirth = HMSUtil.convertStringTypeDateToDateType(dob);
		}

		Criteria crt = session.createCriteria(Patient.class);
		crt.setFirstResult(page - 1);
		crt.setMaxResults(recordsPerPage);

		Criteria crty = session.createCriteria(Patient.class);
		crty.setProjection(Projections.rowCount());

		String hql = "from PatientAddress p where p.Hin= :patienNo";

		if (!hinNo.equals("")) {

			crt.add(Restrictions.eq("HinNo", hinNo));
			crty.add(Restrictions.eq("HinNo", hinNo));
			searchStatus = true;
		}

		if (null != fullName && !fullName.equals("")) {

			crt.add(Restrictions.like("FullName", fullName + "%").ignoreCase());
			crty.add(Restrictions.like("FullName", fullName + "%").ignoreCase());

			searchStatus = true;
		}
		if (null != dateOfBirth) {

			crt.add(Restrictions.eq("DateOfBirth", new java.sql.Date(
					dateOfBirth.getTime())));
			crty.add(Restrictions.eq("DateOfBirth", new java.sql.Date(
					dateOfBirth.getTime())));

			searchStatus = true;
		}
		if (districtId > 0) {
			crt.createAlias("District", "dist");
			crt.add(Restrictions.eq("dist.Id", districtId));

			crty.createAlias("District", "dist");
			crty.add(Restrictions.eq("dist.Id", districtId));

			searchStatus = true;
		}
		if (null != mobileNumber && !mobileNumber.equals("")) {

			crt.add(Restrictions.eq("MobileNumber", mobileNumber));
			crty.add(Restrictions.eq("MobileNumber", mobileNumber));

			searchStatus = true;
		}
		if (searchStatus) {

			searchDataList = crt.list();
		}

		if (searchDataList.size() > 0)
		{
			for (Patient p : searchDataList)
			{
				patientHinNo = p.getId();
				Query query = session.createQuery(hql);
				query.setInteger("patienNo", patientHinNo);

				addressList = query.list();
				PatientAddress padd = addressList.get(0);

				if (padd.getDistrict() != null) {
					ppaddress = "Permanent Address " + " Dist"
							+ padd.getDistrict().getDistrictName()
							+ " House No " + padd.getHouseNo() + SPACE;

				} else {
					ppaddress = "";
				}
				searchAddress.put(patientHinNo, ppaddress);
				logger.debug(ppaddress);

			}

			crt = session.createCriteria(Visit.class).createAlias("Hin",
					"hinId");
			crt.add(Restrictions.eq("hinId.Id", patientHinNo));
			visitDetails = crt.list();

		}
		int noOfRecords = (Integer) crty.uniqueResult();

	
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	
		getDataMap.put("hinNo", hinNo);
		getDataMap.put("mobileNumber", mobileNumber);
		getDataMap.put("districtId", districtId);
		getDataMap.put("fullName", fullName);
		getDataMap.put("dateOfBirth", dateOfBirth);
		getDataMap.put("visitDetails", visitDetails);

		getDataMap.put("noOfPages", noOfPages);
		getDataMap.put("currentPage", page);
		getDataMap.put("searchAddress", searchAddress);
		getDataMap.put("searchDataList", searchDataList);
		return getDataMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showRegistrationJsp(int deptId, int hospId) {

		logger.debug("Inside Method: showRegistrationJsp");

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<MasRelation> relationList = new ArrayList<>();
		List<Object[]> patientTypeList = new ArrayList<>();

		List<Object[]> otherCategoryList = new ArrayList<>();

		List<Object[]> titleList = new ArrayList<>();
		List<Object[]> casteList = new ArrayList<>();

		List<MasCountry> countryList = new ArrayList<>();
		List<MasVisaType> visaTypeList = new ArrayList<>();
		List<MasState> stateList = new ArrayList<>();
		List<MasDistrict> districtList = new ArrayList<>();
		List<Object[]> localityList = new ArrayList<>();
		List<MasOccupation> occupationList = new ArrayList<>();

		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<>();


		HospitalParameters hospitalParameters = new HospitalParameters();
		List<Object[]> postCodeList = new ArrayList<>();
		List<Object[]> villageList = new ArrayList<>();
		List<MasQualification> educationList = new ArrayList<>();
		List<MasLsg> lsgNameList = new ArrayList<>();
		List<MasLsgType> lsgTypeList = new ArrayList<>();
		List<MasTaluk> talukList = new ArrayList<>();
		List<MasIdCard> idCardList = new ArrayList<>();
		List<Object[]> subCenterList = new ArrayList<>();
    	List<Object[]> wardList = new ArrayList<>();

		MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
		
		List <MasScheme> packageSchemeList = null;
		
		int hospitalTypeId = 0;
		
        URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        hospitalTypeId =Integer.parseInt(prop.getProperty("hospitalTypeId"));
        int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));
        
        int stateId=Integer.parseInt(prop.getProperty("stateId"));
       
		
		
		int tokenNo = 0;
		int defaultRelationId = 0;
		try {
			String queryForCaste = "select caste_id,caste_name from mas_caste where status='Y' ";
			casteList = session.createSQLQuery(queryForCaste).list();

			subCenterList = session.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "hospitaltype")
					
					.addOrder(Order.asc("HospitalName"))
					.add(Restrictions.eq("hospitaltype.Id",hospitalTypeId))
					
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")))
					.list();
			
			visaTypeList = session.createCriteria(MasVisaType.class)
					.addOrder(Order.asc("VisaTypeName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			districtList = session.createCriteria(MasDistrict.class)
					.addOrder(Order.asc("DistrictName"))
					.add(Restrictions.eq("State.Id", stateId))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			countryList = session.createCriteria(MasCountry.class)
					.addOrder(Order.asc("CountryName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			stateList = session.createCriteria(MasState.class)
					.addOrder(Order.asc("StateName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			villageList = session.createCriteria(MasVillage.class)
					.addOrder(Order.asc("VillageName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("VillageName"))).list();

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.addOrder(Order.asc("AdministrativeSexName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			
			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			
			relationList = session.createCriteria(MasRelation.class)
					.addOrder(Order.asc("RelationCode"))
					.add(Restrictions.eq("Status", "Y")
							.ignoreCase()).list();

			for (MasRelation masRelation : relationList) {
				if (masRelation.getRelationName().equalsIgnoreCase("Father")) {
					defaultRelationId = masRelation.getId();
					break;
				}
			}

			occupationList = session.createCriteria(MasOccupation.class)
					.addOrder(Order.asc("OccupationName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			educationList = session.createCriteria(MasQualification.class)
					.addOrder(Order.asc("QualificationName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
	
			lsgTypeList = session.createCriteria(MasLsgType.class)
					.addOrder(Order.asc("LsgTypeName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			idCardList = session.createCriteria(MasIdCard.class)
					.addOrder(Order.asc("IdCardName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			
			packageSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("PackageFlag", "Y").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			  

			String queryForPatientType = "select  patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where lower(status)='y' and Type='s' ORDER BY patient_type_name ASC";
			patientTypeList = session.createSQLQuery(queryForPatientType)
					.list();

			String queryPatientType = "select patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where lower(status)='y' and Type='o' ORDER BY patient_type_name ASC";
			otherCategoryList = session.createSQLQuery(queryPatientType).list();

			
			String queryTitle = "select title_id,title_name,title_code from mas_title where status='Y'";
			titleList = session.createSQLQuery(queryTitle).list();

			List<HospitalParameters> hospitalParametersList = new ArrayList<>();
			Criteria c = session.createCriteria(HospitalParameters.class);
			hospitalParametersList = c.list();

			if (hospitalParametersList != null
					&& hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList.get(0);
			}

			Criteria crit = session.createCriteria(
					MasSetupParameterMaintaince.class)
					.addOrder(Order.asc("Id"));

			crit.setFirstResult(0);
			crit.setMaxResults(1);

			int chargeId = 0;
			int mainChargeId = 0;
			int subChargeId = 0;

			map.put("chargeId", chargeId);
			map.put("mainChargeId", mainChargeId);
			map.put("subChargeId", subChargeId);

			Map<String, Object> utilMap = new HashMap<>();
			utilMap = HMSUtil.getCurrentDateAndTime();
			String currentDateYYYYMMDD = (String) utilMap
					.get("currentDateYYYYMMDD");
			List<Object[]> totalDoctorVisits = new ArrayList<>();
			String sqlStr = "select emp.employee_id,count(v.visit_id) from visit v join  mas_employee emp  on v.doctor_id=emp.employee_id where v.visit_date= '"
					+ currentDateYYYYMMDD + "' group by emp.employee_id";
			totalDoctorVisits = session.createSQLQuery(sqlStr).list();
			map.put("totalDoctorVisits", totalDoctorVisits);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("systemParam", systemParam);
		map.put("hospitalParameters", hospitalParameters);
		map.put("patientTypeList", patientTypeList);

		map.put("otherCategoryList", otherCategoryList);


		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();

			complaintList = session.createCriteria(MasComplaint.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			map.put("complaintList", complaintList);
			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.Id",departmentTpeId))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			map.put("departmentList", departmentList);
			
		map.put("wardList", wardList);
		map.put("localityList", localityList);
		map.put("countryList", countryList);
		map.put("villageList", villageList);
		map.put("postCodeList", postCodeList);
		map.put("occupationList", occupationList);
		map.put("educationList", educationList);
		map.put("lsgNameList", lsgNameList);
		map.put("lsgTypeList", lsgTypeList);
		map.put("talukList", talukList);
		map.put("sexList", sexList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("titleList", titleList);
		map.put("districtList", districtList);
		map.put("relationList", relationList);
		map.put("visaTypeList", visaTypeList);
		map.put("idCardList", idCardList);
		map.put("defaultRelationId", defaultRelationId);
		map.put("packageSchemeList", packageSchemeList);
		map.put("stateList", stateList);

		map.put("casteList", casteList);
		map.put("tokenNo", tokenNo);
		map.put("subCenterList", subCenterList);

		sexList = null;
		titleList = null;
		countryList = null;
		stateList = null;
		districtList = null;
		villageList = null;
		postCodeList = null;
		educationList = null;
		lsgNameList = null;
		lsgTypeList = null;
		talukList = null;
		localityList = null;

		relationList = null;
		occupationList = null;
		visaTypeList = null;
		idCardList = null;

		casteList = null;

		return map;
	}

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientInformation(Map<String, Object> objectMap) {
		logger.debug("Inside Method: submitPatientInformation");
		Map<String, Object> map = new HashMap<>();
		final Map<String,Object> patientMap= new HashMap<>();
		Map<String, Object> billingDetailsMap = new HashMap<String, Object>();
		MasHospital hospital = new MasHospital();
		MasState masstate = new MasState();

		List<MasState> statelist = new ArrayList<>();
		Session session = (Session) getSession();
		
		
		
		Map<String,Object> utilMap = new HashMap<>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		

		String aadhaarNo = "";
		boolean aadharNoStatus = false;
		boolean succesfullyAdded = false;
		
		int hospitalId=0;
		if(null !=objectMap.get("hospitalId")){
			hospitalId=(Integer) objectMap.get("hospitalId");
		}

		Criteria crt = session.createCriteria(MasState.class).add(
				Restrictions.like("StateName", "kerala" + "%").ignoreCase());
		statelist = crt.list();
		int stateId = 0;
		for (MasState state : statelist) {
			stateId = state.getId();
			masstate.setId(stateId);
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<Object> existingHinNoList = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String curDate=sdf.format(date);
		Date currentDate = null;
		
		int patientHinId=0;
		int tsn = 0;
		int id = 0;
		String hinNo = "";
		String hin_name = "";
		int hinId = 0;
		boolean addressStatus = false;
		Date lastChangedate=null;
		int phMemberSurveyId=0;
		
		Transaction tx = null;

		Properties prop = new Properties();
		try{
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("registration.properties"); 
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		try {
			currentDate = sdf.parse(curDate);
			tx = session.beginTransaction();
			
			List<Object[]> adList = session
						.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
						.add(Restrictions.eq("TransactionPrefix", "HIN"))
						.add(Restrictions.eq("hosp.Id", hospitalId))
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
					tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 16-08-2016
					transactionSequenceObj1.setTransactionSequenceNumber(tsn+1);
					transactionSequenceObj1.setLastChgDate(date);
					transactionSequenceObj1.setTransactionSequenceName("Hin No");
					transactionSequenceObj1.setTransactionPrefix("HIN");
					transactionSequenceObj1.setTablename("Patient");
					transactionSequenceObj1.setCreatedby("admin");
					transactionSequenceObj1.setStatus("Y");
					MasHospital hosp=new MasHospital();
					hosp.setId(hospitalId);
					transactionSequenceObj1.setHospital(hosp);
					transactionSequenceObj1.setLastChgTime(time);
					hbt.save(transactionSequenceObj1);
				}
			
			if(null != lastChangedate && currentDate.compareTo(lastChangedate)>0){
				// tsn=0; // commented by amit das on  03-08-2016 for duplicate hin_no problem in lean-server connectivity
				tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 03-08-2016 for duplicate hin_no problem in lean-server connectivity
			TransactionSequence transactionSequenceObj = (TransactionSequence) session
					.load(TransactionSequence.class, id);
			// transactionSequenceObj.setTransactionSequenceNumber(1); // commented by amit das on  03-08-2016 for duplicate hin_no problem in lean-server connectivity
			transactionSequenceObj.setTransactionSequenceNumber(tsn+1); // added by amit das on 03-08-2016 for duplicate hin_no problem in lean-server connectivity
			transactionSequenceObj.setLastChgDate(date);
			hbt.update(transactionSequenceObj);
			
			
			}
			else{
				if(id>0){
				TransactionSequence transactionSequenceObj = (TransactionSequence) session
						.load(TransactionSequence.class, id);
				// tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 16-08-2016
				// commented by amit das on 17-08-2016
				
				tsn = transactionSequenceObj.getTransactionSequenceNumber(); // added by amit das on 17-08-2016
				transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
				transactionSequenceObj.setLastChgDate(currentDate);
				hbt.update(transactionSequenceObj);
				}
			}
			
			if(tsn>0 && (int)(Math.log10(tsn+1)+1)==2)
			{
			hinNo = "00" + (tsn + 1);
			
			}
			else if(tsn>0 && (int)(Math.log10(tsn+1)+1)==3)
			{
			hinNo = "0" + (tsn + 1);
		
			}
			else if(tsn>0 && (int)(Math.log10(tsn+1)+1)==4)
			{
			hinNo = "" + (tsn + 1);
			
			}
			else{
				hinNo = "000" + (tsn + 1);
			}		
			
			String gender = "";
			if (objectMap.get("patient") != null) {

				HospitalParameters hospitalParameters = new HospitalParameters();
				List<HospitalParameters> hospitalParametersList = new ArrayList<>();
				Criteria c = session.createCriteria(HospitalParameters.class)
						.addOrder(Order.asc("Id"));
				c.setFirstResult(0);
				c.setMaxResults(1);
				hospitalParametersList = c.list();

				if (hospitalParametersList != null
						&& hospitalParametersList.size() > 0) {
					hospitalParameters = hospitalParametersList.get(0);
				}

				Patient patient = (Patient) objectMap.get("patient");

				if (objectMap.get("addressStatus") != null) {
					addressStatus = (Boolean) objectMap.get("addressStatus");
				}
				if (hospitalId>0) {
					//hospitalId = (Integer) objectMap.get("hospitalId");
					hospital.setId(hospitalId);
					patient.setHospital(hospital);
					
					hospital = 	(MasHospital)session.get(MasHospital.class, hospitalId); // added by amit das on 09-08-2017
					objectMap.put("hospitalCode", hospital.getHospitalCode()); // added by amit das on 09-08-2017
					
				}
				if (!addressStatus) {
					 hinNo = generateTemporaryRegNum(hinNo, hospital.getHospitalCode()); 
					 patient.setHinNo(hinNo);

				} else {

					if (objectMap.get("aadhaarNo") != null) {
						hinNo = (String) objectMap.get("aadhaarNo");

					}
					if (objectMap.get("aadharNoStatus") != null) {
						aadharNoStatus = (Boolean) objectMap
								.get("aadharNoStatus");
					}
					if (aadharNoStatus) {
						patient.setHinNo(hinNo);
					}
					logger.debug("hinNo " + hinNo);

					patient.setAadhaarNo(Long.parseLong(hinNo));
					objectMap.put("tsn", tsn + 1);
					hinNo = generateUHID(objectMap);
					
					
					patient.setHinNo(hinNo);

				}
				if(null !=patient.getMember())
				phMemberSurveyId=patient.getMember().getId();
				
				
				int i = (Integer) hbt.save(patient);
				 patientHinId=patient.getId();
				patientMap.put("patientObj", patient);

				

				patientMap.put("tsn", tsn);

				if (objectMap.get("othercategoryList") != null) {

					String[] oth = (String[]) objectMap
							.get("othercategoryList");
					if (oth != null && oth.length > 0) {
						for (String ot : oth) {
							PatientCategoryDetails pcD = new PatientCategoryDetails();
							
							MasPatientType mpt = new MasPatientType();
							
							if (null != ot && !ot.equals("0"))
								mpt.setId(Integer.parseInt(ot));
							pcD.setOtherCategory(mpt);
							pcD.setHin(patient);
							pcD.setStatus("Y");
							hbt.save(pcD);

						}

					}

				}
				 if(patient.getPatientType()!=null && patient.getPatientType().getId()!=null)
				{
					MasPatientType mpt = new MasPatientType();
					PatientCategoryDetails pcD = new PatientCategoryDetails();
						mpt.setId(patient.getPatientType().getId());
					pcD.setOtherCategory(mpt);
					pcD.setHin(patient);
					pcD.setStatus("Y");
					hbt.save(pcD);
				}
				
				String patientAddress="";

				if (objectMap.get("pAadhaarAddr") != null) {
					PatientAddress pAadhaarAddr = (PatientAddress) objectMap
							.get("pAadhaarAddr");
					
					pAadhaarAddr.setHin(patient);
					pAadhaarAddr.setState(masstate);
					hbt.save(pAadhaarAddr);
					
					
					if(pAadhaarAddr.getHouseNo()!=null){
						patientAddress=pAadhaarAddr.getHouseNo();
						}
					
					if(pAadhaarAddr.getStreetRoad()!=null){
						patientAddress=patientAddress+","+pAadhaarAddr.getStreetRoad();
					}
					if(pAadhaarAddr.getDistrict()!=null){
						MasDistrict district=(MasDistrict)hbt.load(MasDistrict.class, pAadhaarAddr.getDistrict().getId());
						patientAddress=patientAddress+","+district.getDistrictName();
						}
					if(pAadhaarAddr.getPinCode()!=null){
						patientAddress=patientAddress+"-"+pAadhaarAddr.getPinCode();
						}
					
				}
				
				if (objectMap.get("pPermAddr") != null) {
					PatientAddress pPermAddr = (PatientAddress) objectMap
							.get("pPermAddr");
					
				
					pPermAddr.setHin(patient);
					pPermAddr.setState(masstate);
					hbt.save(pPermAddr);
					
					if(pPermAddr.getLsgHouseNo()!=null){
						patientAddress=pPermAddr.getLsgHouseNo();
					}
					if(pPermAddr.getHouseNo()!=null){
						patientAddress=patientAddress+","+pPermAddr.getHouseNo();
					}					
				
					if(pPermAddr.getLocality()!=null){
						PhMasLocality locality=(PhMasLocality)hbt.load(PhMasLocality.class, pPermAddr.getLocality().getId());
						if(!patientAddress.equals(""))
							patientAddress=patientAddress+"\n";
						patientAddress=patientAddress+locality.getLocalityName();
					}
					
					int localityId=0;
					if (objectMap.get("localityName") != null && objectMap.get("localityName") != "") {
						List<PhMasLocality>phMasLocality = session.createCriteria(PhMasLocality.class).add(Restrictions.eq("LocalityName", objectMap.get("localityName"))).list();
						if(phMasLocality.size()>0){
							String address = (String)objectMap.get("localityName");
							patientAddress+=address;
							localityId = phMasLocality.get(0).getId();
							PhMasLocality phLocality = new PhMasLocality();
							phLocality.setId(localityId);
							pPermAddr.setLocality(phLocality);
						}
					}

					if(pPermAddr.getDistrict()!=null){
						MasDistrict district=(MasDistrict)hbt.load(MasDistrict.class, pPermAddr.getDistrict().getId());
						patientAddress=patientAddress+","+district.getDistrictName();
					}
					if(pPermAddr.getPinCode()!=null){
						patientAddress=patientAddress+"-"+pPermAddr.getPinCode();
					}
				}
				
				
				if (objectMap.get("pTempAddr") != null) {
					PatientAddress pTempAddr = (PatientAddress) objectMap
							.get("pTempAddr");
					pTempAddr.setHin(patient);
					pTempAddr.setState(masstate);
					hbt.save(pTempAddr);
					
					if(pTempAddr.getHouseNo()!=null){
						patientAddress=pTempAddr.getHouseNo();
						}
					
					if(pTempAddr.getLsgHouseNo()!=null){
						patientAddress=patientAddress+","+pTempAddr.getLsgHouseNo();
					}
					if(pTempAddr.getLocality()!=null){
						PhMasLocality locality=(PhMasLocality)hbt.load(PhMasLocality.class, pTempAddr.getLocality().getId());
						patientAddress=patientAddress+"\n"+locality.getLocalityName();
						}

					if(pTempAddr.getDistrict()!=null){
						MasDistrict district=(MasDistrict)hbt.load(MasDistrict.class, pTempAddr.getDistrict().getId());
						patientAddress=patientAddress+","+district.getDistrictName();
						}
					if(pTempAddr.getPinCode()!=null){
						patientAddress=patientAddress+"-"+pTempAddr.getPinCode();
						}

				}

				if(!patientAddress.equals("") && patientAddress.charAt(0) == ',') {
					patientAddress = patientAddress.substring(1);
				}
				logger.debug("input final address " + patientAddress);

				Patient p2=(Patient)hbt.load(Patient.class, patient.getId());
				p2.setPatientAddress(patientAddress);
				hbt.update(p2);
				logger.debug("patient Address updated");

				succesfullyAdded = true;

				if (patient.getSex() != null) {
					gender = patient.getSex().getAdministrativeSexName();
				}
				
				if(patient.getRsbyCardNo()!=null && objectMap.get("rsbyCardPkgScheme")!=null &&  (Integer)objectMap.get("rsbyCardPkgScheme")!=0){
					Criteria criteria = session.createCriteria(RsbyCardDetails.class);
					criteria.add(Restrictions.eq("RsbyCardNo", patient.getRsbyCardNo()));
					if(criteria.list().size()==0){
						RsbyCardDetails rsbyCardDetails = new RsbyCardDetails();
						MasScheme pkgScheme = new MasScheme((Integer)objectMap.get("rsbyCardPkgScheme"));
						rsbyCardDetails.setRsbyCardNo(patient.getRsbyCardNo());
						rsbyCardDetails.setBalanceUtilized(new BigDecimal("0"));
						rsbyCardDetails.setPkgScheme(pkgScheme);
						rsbyCardDetails.setStatus("Y");
						hbt.save(rsbyCardDetails);
					}
				}
				String motherHinNo = "";
				if(objectMap.get("motherHinNo") != null){
					motherHinNo = (String)objectMap.get("motherHinNo");
				}
				
				List<Patient>motherUhidList = new ArrayList<>();
				motherUhidList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", motherHinNo)).list();
				int memberId = 0;
				int moHospitalId=0;
				if(motherUhidList.size()>0){
					for(Patient motherPt : motherUhidList){
						//motherHinId = motherPt.getId();
						if(motherPt.getMember()!=null){
						memberId = motherPt.getMember().getId();
						
						}
					}
					PhAlert phAlert =  new PhAlert();
					Patient pt = new Patient();
					pt.setId(patient.getId());
					phAlert.setHin(pt);
					phAlert.setAlertType("birth");
					List<PhMemberSurvey>PhMemberSurveyList1= new ArrayList<>();
					PhMemberSurveyList1=session.createCriteria(PhMemberSurvey.class).add(Restrictions.eq("Id", memberId)).list();
					int memHospitalId=0;
					for(PhMemberSurvey PhMemberSurvey:PhMemberSurveyList1){
						memHospitalId=PhMemberSurvey.getHospital().getId();
					}
					if(memberId!=0){
					PhMemberSurvey phMemberSurvey = new PhMemberSurvey();
					phMemberSurvey.setId(memberId);
					phAlert.setMember(phMemberSurvey);
					}
					if(memHospitalId!=0){
						MasHospital mh=new MasHospital();
						mh.setId(memHospitalId);
						phAlert.setHospital(mh);
					}
					
					hbt.save(phAlert);
					
				}
				if(phMemberSurveyId>0){
				PhMemberSurvey phMemberSurvey=(PhMemberSurvey) session.load(PhMemberSurvey.class, phMemberSurveyId);
				phMemberSurvey.setUhidNo(hinNo);
				hbt.saveOrUpdate(phMemberSurvey);
				
				}
				
			}
		
			tx.commit();

			map.put("gender", gender);
			map.put("hinId", hinId);
			map.put("succesfullyAdded", succesfullyAdded);
			map.put("hinNo", hinNo);
			map.put("patientHinId",patientHinId);
			
			final MasHospital  masHospital=(MasHospital)session.get(MasHospital.class, hospitalId);

			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*
			if(masHospital!=null){
				patientMap.put("hospital", masHospital);
				
				new Thread(){
					public void run(){
						if(masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
							savePatientDataForRegistrationToCentralServer(patientMap);
						} 
						if(masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
							savePatientDataForRegistrationToLeanServer(patientMap);
						}
					}
					
				}.start();
				}*/
			  
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
		
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getHinId(String serviceNo, int serviceTypeId) {
		logger.debug("Inside Method: getHinId");
		Session session = (Session) getSession();
		String previousHinNo = "";
		String maxSequenceNo = "";
		List<Patient> previousHinNoList = new ArrayList<>();
		try {
			if (!serviceNo.equals("0") && serviceNo != null) {
				previousHinNoList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("ServiceNo", serviceNo)).list();
			} else {
				previousHinNoList = session.createCriteria(Patient.class)
						.list();
			}
			if (previousHinNoList.size() > 0) {

				ArrayList hinNoSequenceList = new ArrayList();
				for (Patient patient : previousHinNoList) {
					if (patient.getServiceType().getId() == serviceTypeId) {
						previousHinNo = patient.getHinNo();
						int length = previousHinNo.length() - 2;
						String sequenceNo = previousHinNo.substring(length,
								previousHinNo.length());
						int i = Integer.parseInt(sequenceNo);
						hinNoSequenceList.add(i);
					}
				}

				if (hinNoSequenceList.size() > 0) {
					maxSequenceNo = Collections.max(hinNoSequenceList)
							.toString();
				}
			}

		} catch (HibernateException | NumberFormatException e) {
			e.printStackTrace();
		}
		//
		return maxSequenceNo;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		logger.info("Inside Method: getPatientDetails");
		Map<String, Object> map = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hinId = 0;
		Session session = (Session) getSession();

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
		
		
		try {


			Criteria crit = session.createCriteria(Patient.class);
			if (hinNo != null && !hinNo.trim().equals("")) {
				crit = crit.add(Restrictions.eq("HinNo", hinNo)).add(
						Restrictions.ne("Status", "n"));

			} else if (hinId != 0) {
				crit = crit.add(Restrictions.eq("Id", hinId)).add(
						Restrictions.ne("Status", "n"));
			} else {
				if (!patientFName.equals("")) {
					crit = crit.add(
							Restrictions.ilike("PFirstName", "%" + patientFName
									+ "%")).add(Restrictions.ne("Status", "n"));
				}
				if (!patientMName.equals("")) {
					crit = crit.add(
							Restrictions.ilike("PMiddleName", "%"
									+ patientMName + "%")).add(
							Restrictions.ne("Status", "n"));
				}
				if (!patientLName.equals("")) {
					crit = crit.add(
							Restrictions.ilike("PLastName", "%" + patientLName
									+ "%")).add(Restrictions.ne("Status", "n"));
				}
			}

			patientList = crit.addOrder(Order.asc("PFirstName")).list();
			
			if(patientList!=null && patientList.size()>0)
				map.put("hinNo", patientList.get(0).getHinNo());
			
			if(patientList!=null && patientList.size()>0)
				map.put("patientHinId", patientList.get(0).getId());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getVisitDetails(int hospitalId) {
		logger.debug("Inside Method: getVisitDetails");
		Map<String, Object> map = new HashMap<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<MasEmployee> employeeList = new ArrayList<>();
		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasDisposal> disposalList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasCompany> companyList = new ArrayList<>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<>();
		Date currentDate = new Date();
		List<Visit> newVisits = new ArrayList<>();
		Session session = (Session) getSession();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();

		MasSetupParameterMaintaince systemParam;
		List<Object[]> totalDoctorVisits;
		int visitTotal = 0;
		try {
			systemParam = new MasSetupParameterMaintaince();

			companyList = session.createCriteria(MasCompany.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("CompanyName")).list();
			employeeDependentList = session
					.createCriteria(MasEmployeeDependent.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("EmployeeDependentName")).list();
			patientTypeList = session.createCriteria(MasPatientType.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("PatientTypeName")).list();

			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("AuthorizerName")).list();
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "Y"))
					.add(Restrictions.eq("DepartmentType.Id", 1))
					.addOrder(Order.asc("DepartmentName")).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("EmpCategory.Id", 1))
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("FirstName"))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId)).list();
			complaintList = session.createCriteria(MasComplaint.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("ComplaintName")).list();
			caseTypeList = session.createCriteria(MasCaseType.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("CaseTypeName")).list();
			diagnosisList = session
					.createCriteria(MasDiagnosisConclusion.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("DiagnosisConclusionName")).list();
			disposalList = session.createCriteria(MasDisposal.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("DisposalName")).list();
			newVisits = session.createCriteria(Visit.class)
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("VisitDate", currentDate))
					.setProjection(Projections.count("Id")).list();

			if (newVisits.get(0) != null) {
				visitTotal = Integer.parseInt("" + newVisits.get(0));
			}
			Map<String, Object> utilMap = new HashMap<>();
			utilMap = HMSUtil.getCurrentDateAndTime();
			String currentDateYYYYMMDD = (String) utilMap
					.get("currentDateYYYYMMDD");
			totalDoctorVisits = new ArrayList<>();
			String sqlStr = "";
			sqlStr = "select emp.employee_id,count(v.visit_id) from visit v join  mas_employee emp  on v.doctor_id=emp.employee_id where v.visit_date= '"
					+ currentDateYYYYMMDD
					+ "' and v.hospital_id='"
					+ hospitalId + "' group by emp.employee_id";
			totalDoctorVisits = session.createSQLQuery(sqlStr).list();
			List<MasSetupParameterMaintaince> systemParametersList = new ArrayList<>();
			Criteria crit = session.createCriteria(
					MasSetupParameterMaintaince.class)
					.addOrder(Order.asc("Id"));
			systemParametersList = crit.list();


			int regChargeId = 0;

			if (systemParametersList != null && systemParametersList.size() > 0) {
				systemParam = systemParametersList.get(0);
				if (systemParam.getRegChargeCode() != null) {
					regChargeId = systemParam.getRegChargeCode().getId();
				}
			}

			int chargeId = 0;
			int mainChargeId = 0;
			int subChargeId = 0;
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Id", regChargeId))
					.add(Restrictions.eq("Status", "Y"))
					.createAlias("ChargeType", "mct")
					.add(Restrictions.eq("mct.Id", 9))
					.addOrder(Order.asc("ChargeCodeName")).list();
			for (MasChargeCode chargeCode : chargeCodeList) {
				chargeId = chargeCode.getId();
				mainChargeId = chargeCode.getMainChargecode().getId();
				subChargeId = chargeCode.getSubChargecode().getId();
			}
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "Y"))
					.createAlias("ChargeType", "mct")
					.add(Restrictions.eq("mct.Id", 9))
					.addOrder(Order.asc("ChargeCodeName")).list();
			map.put("chargeId", chargeId);
			map.put("mainChargeId", mainChargeId);
			map.put("subChargeId", subChargeId);
			map.put("regChargeId", regChargeId);

			map.put("totalDoctorVisits", totalDoctorVisits);
			map.put("systemParam", systemParam);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		map.put("complaintList", complaintList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposalList", disposalList);
		map.put("newVisits", visitTotal);
		map.put("authorizerList", authorizerList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("patientTypeList", patientTypeList);
		map.put("companyList", companyList);
		map.put("employeeDependentList", employeeDependentList);
		//
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getIpAdmissionDetailsForBilling(Map<String, Object> dataMap) {
		logger.debug("Inside Method: getIpAdmissionDetailsForBilling");
		Map<String, Object> map = new HashMap<>();
		String hinNo = "";
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}

		List<Patient> patientList = new ArrayList<>();

		Session session = (Session) getSession();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (IOException e) {
			e.printStackTrace();
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Id", 1039)).list();

		BigDecimal amt = new BigDecimal(0.00);

		for (MasChargeCode charge : chargeCodeList) {
			amt = new BigDecimal("" + charge.getCharge());
		}
		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo)).list();
		map.put("patientList", patientList);
		map.put("amt", amt);
		map.put("chargeCodeList", chargeCodeList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public  Map<String,Object>  saveVisitInformation(
			Map<String, Object> mapForDs) {
		logger.debug("Inside Method saveVisitInformation() ");

		
		Map<String,Object> map=null;
		Map<String, Object> reservedTokenMap =null;
		Map<Integer, Object> patientWithTokenMap=null;
		Map<String, Object> requestMap = new HashMap<String,Object>();
		BlOpBillDetails opBillDetails=null;
		BlOpBillHeader opBillHeader=null;
		String opdreferal="";
		String hospitalCode="";
		String department_name="";
		String requestedIP = null;
		String specialCategory = null;
		synchronized(this){
		map= new HashMap<>();
		reservedTokenMap= new HashMap<>();
	    patientWithTokenMap = new HashMap<Integer, Object>();

		 opBillDetails=new BlOpBillDetails();
		 opBillHeader=new BlOpBillHeader();

		int hospitalId=0;
		int chargeId=0;
		
		if(null !=mapForDs.get("requestedIP")){
			requestedIP=(String)mapForDs.get("requestedIP");
		}

		if(null !=mapForDs.get("hospitalCode")){
			hospitalCode=(String)mapForDs.get("hospitalCode");
		}
		int currentPriority=0;
		if(null !=mapForDs.get("currentPriority")){
			currentPriority=(Integer)mapForDs.get("currentPriority");

		}

		if(null !=mapForDs.get("opdreferal")){
			opdreferal=(String)mapForDs.get("opdreferal");
		}
		if(null !=mapForDs.get("chargeId")){
			chargeId=(Integer)mapForDs.get("chargeId");
		}

		if(null !=mapForDs.get("hospitalId")){
			hospitalId=(Integer)mapForDs.get("hospitalId");
		}

		if(null !=mapForDs.get("opBillHeader")){
			opBillHeader=(BlOpBillHeader)mapForDs.get("opBillHeader");
		}
		if(null !=mapForDs.get("opBillDetails")){
			opBillDetails=(BlOpBillDetails)mapForDs.get("opBillDetails");
		}

		int previousVisit=0;
		if(null !=mapForDs.get("previousVisit")){
			previousVisit=(Integer)mapForDs.get("previousVisit");
		}
		int lastVisitId = 0;
		if(null !=mapForDs.get("lastVisitId")){
			lastVisitId=(Integer)mapForDs.get("lastVisitId");
		}
		boolean opNursingAppointmentStatus=false;
		if(null !=mapForDs.get("opNursingAppointmentStatus")){
			opNursingAppointmentStatus=(Boolean)mapForDs.get("opNursingAppointmentStatus");
		}


		ArrayList<String> serviceCentreList= new ArrayList<>();

		if(null !=mapForDs.get("departmentIdlist")){
			serviceCentreList =(ArrayList<String>) mapForDs.get("departmentIdlist");
		}


		int visitId=0;
		int patientTypeId = 0;

		String pType = null;
		if (mapForDs.get("patientType") != null) {
			pType = (String) mapForDs.get("patientType");

			if (pType != null && !pType.equals("")) {
				patientTypeId = Integer.parseInt(pType);
			}

		}
		
		int currentVisitNo = 0;
		if(mapForDs.get("currentVisitNo")!=null)
			currentVisitNo = (Integer) mapForDs.get("currentVisitNo");
		
		List<Visit> visitlist= new ArrayList<>();
		List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<>();
		List<QueueManagment> managements= new ArrayList<>();
		Visit visit = null;
		QueueManagment queue=null;
		MasDepartment department=null;
		MasEmployee employee=null;
		HospitalDoctorUnitM hospUnitM=null;
		MasHospital masHospital = null;
		Patient patient = null;
		MasDiagnosisConclusion masDiagnosisConclusion=null;
		MasEmployee masEmployee=null;
		MasComplaint masComplaint = null;
		MasCaseType masCaseType =null;
		
		int hinId=(Integer)mapForDs.get("hinId");
		Users userObj=(Users)mapForDs.get("userObj");
		String age=(String)mapForDs.get("age");

		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		
		
		Integer totalHospitalVisitNo=0;
		int departmentId=0;
		int tokenNo=0;
		Date currentDate=new Date();
		Date addEditDate=(Date)mapForDs.get("addEditDate");
		String addEditTime=(String)mapForDs.get("addEditTime");
		
		Date visitDate=(Date)mapForDs.get("visitDate");
		
		String onlineRegStatus="";
		if(null !=mapForDs.get("onlineRegStatus"))
		onlineRegStatus=(String) mapForDs.get("onlineRegStatus");
		
		if(mapForDs.get("currentPriority")!=null)
			currentPriority=(Integer) mapForDs.get("currentPriority");
		
		int dutyDoctorId=0;
		if(null !=mapForDs.get("dutyDoctorId"))
			dutyDoctorId=(Integer)mapForDs.get("dutyDoctorId");
	
		int diagnosisId =0;
		if(null !=mapForDs.get("diagnosisId")){
			diagnosisId=(Integer)mapForDs.get("diagnosisId");
		}
		
		String appInvestigationStatus="";
		if(null !=mapForDs.get("appInvestigationStatus")){
			appInvestigationStatus=(String)mapForDs.get("appInvestigationStatus");
		}
		int appDepartmentId=0;
		if(null !=mapForDs.get("appDepartmentId")){
			appDepartmentId=(Integer)mapForDs.get("appDepartmentId");
		}
		int consultingDoctorId =0;
		if(null !=mapForDs.get("consultingDoctorId")){
			consultingDoctorId=(Integer) mapForDs.get("consultingDoctorId");
		}
		int complaintId=0;
		if(null !=mapForDs.get("complaintId")){
			complaintId=(Integer) mapForDs.get("complaintId");
		}
		
		String visitTime=null;
		if(null !=mapForDs.get("visitTime"))
		 visitTime=(String)mapForDs.get("visitTime");
		
		int unitId=0;
		if(null !=mapForDs.get("unitId"))
		 unitId=(Integer)mapForDs.get("unitId");
		
		int caseTypeId =0;
		if(null !=mapForDs.get("caseTypeId"))
			caseTypeId=(Integer)mapForDs.get("caseTypeId");
		
		int opsessionId=0;
		if(mapForDs.get("opsessionId")!=null){
			opsessionId = (Integer) mapForDs.get("opsessionId");
		}
		String cashReceived="";
		if(null !=mapForDs.get("cashReceived"))
			cashReceived=(String)mapForDs.get("cashReceived");

		String cashNotReceivedReason="";
		if(null !=mapForDs.get("cashNotReceivedReason"))
			cashNotReceivedReason=(String)mapForDs.get("cashNotReceivedReason");
		
		String referalStatus="";
		if(null !=mapForDs.get("referalStatus"))
			referalStatus=(String)mapForDs.get("referalStatus");
		
		String refferalType="";
		if(null !=mapForDs.get("refferalType")){
			refferalType=(String)mapForDs.get("refferalType");
		}
		
		int opHospitalSerialNo=0;
		if(null !=mapForDs.get("opHospitalSerialNo"))
			opHospitalSerialNo=(Integer)mapForDs.get("opHospitalSerialNo");

		boolean successfullyAdded = false;
		boolean duplicateVisitSatatus=false;
		
		PharmacyLabQueue pharmacyLabQueue=null;
		int pharmacyDepartmentId=0;
		int labDepartmentId=0;
		int radiologyDepartmentId=0;
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        if(prop.getProperty("pharmacyDepartmentId")!=null){
        	pharmacyDepartmentId =Integer.parseInt(prop.getProperty("pharmacyDepartmentId"));
        }
        
        labDepartmentId=Integer.parseInt(prop.getProperty("labDepartmentId"));
        radiologyDepartmentId=Integer.parseInt(prop.getProperty("radiologyDepartmentId"));
        
		Transaction tnx=null;
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			masHospital = hbt.get(MasHospital.class, hospitalId);
			
			if(!opdreferal.equals("y")){
			tnx=session.beginTransaction();
			}
			String doctorName="";
			String opdStartTime = "";
			int avgNoOfPatients = 0;
			String reportingTime = "";
			if(dutyDoctorId>0)
			doctorName=getDoctorNameById(dutyDoctorId,hospitalId);
			if(null !=serviceCentreList){
				for(String depId:serviceCentreList){
					departmentId=Integer.parseInt(depId);
					
						if(departmentId>0){
							// Method which will check for duplicate visit creation for same department in same hospital for current date
							duplicateVisitSatatus=checkDuplicateVisit(hospitalId,departmentId,hinId);
							if(!duplicateVisitSatatus){
							department=new MasDepartment();
							visit=new Visit();
							queue=new QueueManagment();
							department.setId(departmentId);
							visit.setDepartment(department);
							queue.setDepartment(department);
							
							
							visit.setPriorityNumber(currentPriority);
							queue.setPriorityNumber(currentPriority);
							
							if(dutyDoctorId>0){
								employee=new MasEmployee();
								employee.setId(dutyDoctorId);
								visit.setDoctor(employee);
								visit.setDoctorName(doctorName);
								queue.setDocotor(employee);
								queue.setInitialDr(employee);
								specialCategory = "D";
							}
							if(unitId>0){
							 hospUnitM=new HospitalDoctorUnitM();
							 hospUnitM.setId(unitId);
							visit.setUnit(hospUnitM);
							}
							patient=new Patient();
							patient.setId(hinId);
							visit.setHin(patient);
							queue.setHin(patient);
							visit.setCashReceivedStatus(cashReceived);
							visit.setCashNotReceivedReason(cashNotReceivedReason);
							
							 boolean ispreviouesToken=false;
								
								// Method for getting Today's Resevered Queue number of online Appointment of patient based on Hospital and Department
								if(!referalStatus.equalsIgnoreCase("y")){
									map=getTotalVistByHospital(hospitalId, departmentId, currentDate, hinId,opsessionId,hospitalCode);
								}else if(refferalType!="" && refferalType.equalsIgnoreCase("External")){
									map=getTotalVistByHospital(hospitalId, departmentId, currentDate, hinId,opsessionId,hospitalCode);
								}
								else{
									totalHospitalVisitNo=opHospitalSerialNo;
								}
								if(null !=map.get("ispreviouesToken")){
									ispreviouesToken=(Boolean)map.get("ispreviouesToken");
								}
								if(null !=map.get("TotaltokenNo")){
									totalHospitalVisitNo=(Integer)map.get("TotaltokenNo");
								}
								if(!ispreviouesToken){
								totalHospitalVisitNo=totalHospitalVisitNo;
								}
								/*else{
									totalHospitalVisitNo=totalHospitalVisitNo;
								}*/
								
								visit.setTotalHospitalVisit( (int)totalHospitalVisitNo);
								queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
								
								reservedTokenMap=getReseveredTokenNo(departmentId,hospitalId);
								int maxTokenNo = 0;
								String departmentType="";
								boolean status=false;
								
								requestMap.put("reservedTokenMap", reservedTokenMap);
								requestMap.put("hospital", masHospital);
								requestMap.put("visitSessionId", opsessionId);
								requestMap.put("deptId", departmentId);
								requestMap.put("vDate", currentDate);
								requestMap.put("requestedIP", requestedIP);
								
								if(onlineRegStatus.equals("")){
									
									
									if(pharmacyDepartmentId==departmentId  ||  labDepartmentId ==departmentId || radiologyDepartmentId==departmentId){
										if(pharmacyDepartmentId==departmentId){
											departmentId=pharmacyDepartmentId;
											departmentType="P";
											status=true;
										}
										else if(labDepartmentId ==departmentId){
											departmentId=labDepartmentId;
											departmentType="L";
											status=true;
										}
										else{
											departmentId=radiologyDepartmentId;
											departmentType="R";
											status=true;
										}
										//maxTokenNo =getqueueNoForDepartment(departmentId, hospitalId,opsessionId);
										maxTokenNo =(int)getTokenNoForDepartment(requestMap);

										
									}
									else{
								maxTokenNo =(int)getTokenNoForDepartment(requestMap);
									}
									
								tokenNo = maxTokenNo;

							while(reservedTokenMap.containsKey(String.valueOf(tokenNo))){
								maxTokenNo =(int)getTokenNoForDepartment(requestMap);
								logger.debug("if else of maxTokenNo "+maxTokenNo);
								tokenNo = maxTokenNo ; 
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
								}
								masHospital=new MasHospital();
								masHospital.setId(hospitalId);
								visit.setHospital(masHospital);
								queue.setHospital(masHospital);
						if(diagnosisId>0){
							masDiagnosisConclusion = new MasDiagnosisConclusion();
							masDiagnosisConclusion.setId(diagnosisId);
							visit.setDiagnosis(masDiagnosisConclusion);
						}
						if(consultingDoctorId>0){
							masEmployee = new MasEmployee();
							masEmployee.setId(consultingDoctorId);
							visit.setDoctor(masEmployee);
							queue.setDocotor(masEmployee);
							queue.setInitialDr(employee);
						}
						if(complaintId>0){
							 masComplaint = new MasComplaint();
								masComplaint.setId(complaintId);
								visit.setComplaint(masComplaint);
						}
						if(caseTypeId>0){
							 masCaseType = new MasCaseType();
								masCaseType.setId(caseTypeId);
								visit.setCaseType(masCaseType);
						}
						if(opsessionId>0){
							MasSession masSession=new MasSession();
							masSession.setId(opsessionId);
							visit.setVisitSession(masSession);
						}
								
							visit.setTokenNo(tokenNo);
							queue.setTokenNo(tokenNo);
							visit.setAddEditBy(userObj);
							visit.setAge(age);
							SimpleDateFormat sdTime = new SimpleDateFormat("HH:mm");
				    	    Date current = new Date();
				    	    String times = sdTime.format(current);
							visit.setVisitTime(times);

							
							SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

				    	    Date now = new Date();

				    	    String time = sdfTime.format(now);


							visit.setOpVisitTime(time);
							visit.setVisitDate(visitDate);
							queue.setLsCngDate(visitDate);
							visit.setVisitNo(currentVisitNo);
							visit.setStatus("y");
							queue.setTokenStatus("w");
							queue.setOpVisitTime(time);
							visit.setEdStatus("n");
							visit.setVisitStatus("w");
							visit.setAddEditDate(addEditDate);
							visit.setAddEditTime(addEditTime);
							visit.setCurPharVisitStatus("Y");
							visit.setReferralStatus(referalStatus);
							queue.setVisit(visit);
						
							String onlineAppointmentStauts="";
							
							if (mapForDs.get("onlineAppointmentStauts") != null) {
								onlineAppointmentStauts = (String) mapForDs.get("onlineAppointmentStauts");
								
							}
							String onlineAppId="";
							
							if (mapForDs.get("onlineAppId") != null) {
								onlineAppId = (String) mapForDs.get("onlineAppId");
								
							}
							
							
							instituteDepartmentList =	session.createCriteria(MasInstituteDepartment.class).add(Restrictions.eq("Institute.Id", hospitalId)).add(Restrictions.eq("Department.Id", departmentId)).list();
							opdStartTime =	instituteDepartmentList.get(0).getOpeningTime();
							
								if (instituteDepartmentList.get(0)
										.getAvgNoOfPatients() != null && opdStartTime!=null) {
									avgNoOfPatients = instituteDepartmentList
											.get(0).getAvgNoOfPatients();
									Date date = timeFormat.parse(opdStartTime);
									Calendar cal = new GregorianCalendar();
									cal.setTime(date);

									cal.add(Calendar.HOUR_OF_DAY,
											visit.getTokenNo()
													/ avgNoOfPatients);
									reportingTime = timeFormat.format(cal
											.getTime());
									visit.setReportingTime(reportingTime);
								}
							
							visit.setDisplayAfterNo(visit.getTokenNo()-1); // added by amit das on 21-07-2017
							visit.setLastDisplayAfterNo(visit.getTokenNo()-1);
							
							masHospital =(MasHospital)session.get(MasHospital.class, hospitalId);
							if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
								visit.setCreationSource("C");
							}else if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
								visit.setCreationSource("L");
							}
							
							hbt.save(visit);
							
							if(status){
								PharmacyLabQueue phlabRadioQueue=saveQueueNoForPharmacy(departmentId,hospitalId, visit,departmentType,tokenNo);
								hbt.save(phlabRadioQueue);
							}
							visitId=visit.getId();
							department_name=getDepartmentname(departmentId);
							currentVisitNo++;
							if(null !=onlineAppointmentStauts && !onlineAppointmentStauts.equals("")){
								if(null !=onlineAppId && !onlineAppId.equals("")){
									AppPatientAppointments appPatientApp=(AppPatientAppointments) session.createCriteria(AppPatientAppointments.class)
											.createAlias("Hospital", "hospital")
											.add(Restrictions.eq("hospital.Id",hospitalId))
											.add(Restrictions.eq("Id",Integer.parseInt(onlineAppId))).list().get(0);
									appPatientApp.setAppointmentStatus("C");
									session.update(appPatientApp);
								}
							}
							
							String currentDate1 = null;
							String currentTime1 = null;
							Map<String, Object> utilMap = null;
							utilMap = HMSUtil.getCurrentTime();
							if(utilMap!=null && utilMap.get("currentDate")!=null && utilMap.get("currentTime")!=null){
								currentDate1 = (String) utilMap.get("currentDate");
								currentTime1 = (String) utilMap.get("currentTime");

							queue.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate1));
							queue.setLastChgTime(currentTime1);
							}
							int patientAge = 0;
							if(patient.getPatientAge()!=null)
								patientAge = patient.getPatientAge();
							
							List<PatientCategoryDetails> patientCategoryDetailList = session.createCriteria(PatientCategoryDetails.class).createAlias("OtherCategory", "oc").add(Restrictions.eq("Hin.Id",patient.getId())).add(Restrictions.eq("oc.PatientTypeCode", "HAN")).list();
							if(patientAge>=60)
								specialCategory = "S";
							else if(patientCategoryDetailList.size()>0)
								specialCategory = "P";
							else if(patientAge<=10) 
								specialCategory = "C";
							else
								specialCategory = "G";
							
							queue.setPatientSpecialCategory(specialCategory);
							hbt.save(queue);
							visitlist.add(visit);
							managements.add(queue);
							

							if(opNursingAppointmentStatus){
								
								List<ProcedureDetails> procedureDetailList = new ArrayList<>();
								
								procedureDetailList =  session.createCriteria(ProcedureDetails.class)
										
										.createAlias("ProcedureHeader", "ph")
										.createAlias("ph.Hin", "hin")
										.createAlias("ph.Visit", "visit")
										.createAlias("ph.Hospital", "hosp")
										.add(Restrictions.eq("Status", "n").ignoreCase())
										.add(Restrictions.eq("NextAppointmentDate", currentDate))
										.add(Restrictions.eq("hin.Id", hinId))
										.add(Restrictions.eq("hosp.Id", hospitalId))
										.add(Restrictions.eq("visit.Id", previousVisit)).list();
								if(procedureDetailList !=null && procedureDetailList.size()>0){
									ProcedureHeader procedureHeader=null;
									for(ProcedureDetails pd:procedureDetailList){
										procedureHeader=pd.getProcedureHeader();
									}
									ProcedureDetails procedureDetail=procedureDetailList.get(0);
									procedureDetail.setAppointmentDate(currentDate);
									hbt.update(procedureDetail);
									procedureHeader.setNewVisit(visit);
									hbt.update(procedureHeader);
									
									
								}
								
								
								List<InjAppointmentDetails> InjectionList = new ArrayList<>();
								InjectionList = session.createCriteria(InjAppointmentDetails.class)
										.createAlias("InjAppointmentHeader", "inAppHd")
										.createAlias("inAppHd.Hospital", "hosp")
										.createAlias("inAppHd.Visit", "visit")
										.createAlias("inAppHd.Hin", "hin")
										.add(Restrictions.eq("Status", "p").ignoreCase())
										.add(Restrictions.eq("inAppHd.Status", "p").ignoreCase())
										.add(Restrictions.eq("visit.Id", previousVisit))
										.add(Restrictions.eq("hosp.Id", hospitalId))
										.add(Restrictions.eq("inAppHd.NextAppointmentDate", currentDate))
										.add(Restrictions.isNull("inAppHd.NewVisit"))
										.add(Restrictions.eq("hin.Id", hinId)).list();
								
								if(InjectionList !=null && InjectionList.size()>0){
									InjAppointmentDetails InjectionD=InjectionList.get(0);
									InjAppointmentHeader InjectionH=null;
									for(InjAppointmentDetails injection:InjectionList){
										InjectionH=injection.getInjAppointmentHeader();
									}
									
									
									InjectionH.setNewVisit(visit);
									InjectionH.setAppointmentDate(currentDate);
									hbt.update(InjectionH);
									InjectionD.setStatus("p");
									hbt.update(InjectionD);
									
								}
								
							}
							successfullyAdded = true;
							
							
							map.put("successfullyAdded", successfullyAdded);
							map.put("duplicateVisitSatatus", duplicateVisitSatatus);
							}
							else{
								map.put("successfullyAdded", successfullyAdded);
								map.put("duplicateVisitSatatus", duplicateVisitSatatus);
								break;
								
							}
							
							}
					}
			}
			
			if(successfullyAdded){
			if(chargeId>0){
			String billNo = "";
			billNo = generateBillNo("save",hospitalId);
			opBillHeader.setBillNo(billNo);
			opBillHeader.setHin(patient);
			opBillHeader.setVisit(visit); // Added By Amit Das on 02-03-2016
			
			hbt.save(opBillHeader);//**
			
			opBillDetails.setOpBillHeader(opBillHeader);
			
			hbt.save(opBillDetails);//**
			}
			double totalPastDue=0.0;
			if(null !=mapForDs.get("totalPastDue")){
			totalPastDue=(Double)mapForDs.get("totalPastDue");
			}
			if (hinId != 0) {

				patient = (Patient) hbt.load(Patient.class, hinId);
				patient.setCurrentVisitNo(currentVisitNo);
				patient.setPastDue(String.valueOf(totalPastDue));
				hbt.update(patient);//**

			}
			}
			
	//========================update refered status in opd Patient details in referel case============================
			List<OpdPatientDetails> opdPatientListForReferedStatus = new ArrayList<>();
			
			opdPatientListForReferedStatus =  session.createCriteria(OpdPatientDetails.class)
					.createAlias("Visit", "visit")
					.add(Restrictions.eq("visit.Id", lastVisitId)).add(Restrictions.eq("ReferedStatus", "y").ignoreCase()).list();
			logger.debug("opdPatientListForReferedStatus=="+opdPatientListForReferedStatus.size());
			if(opdPatientListForReferedStatus !=null && opdPatientListForReferedStatus.size()>0){
				
				if(opdPatientListForReferedStatus.get(0).getId() != 0){
				OpdPatientDetails opdPatientDetails =(OpdPatientDetails)hbt.load(OpdPatientDetails.class, opdPatientListForReferedStatus.get(0).getId());
				opdPatientDetails.setReferedStatus("C");
				hbt.update(opdPatientDetails);
				}
			}
//---------------------------------------------------------------------------------------------------
			List<AppInvestigationAppointments> appInvestList= new ArrayList<>();
			AppInvestigationAppointments appInvestigationAppointment=null;
			
			if(appInvestigationStatus.equalsIgnoreCase("y") && appDepartmentId>0 ){
				Criteria crt=null;
				crt=session.createCriteria(AppInvestigationAppointments.class).createAlias("Department", "dept")
						.createAlias("Hin", "hin").add(Restrictions.eq("hin.Id",hinId))
						.add(Restrictions.eq("dept.Id",appDepartmentId)).add(Restrictions.eq("InvestigationDate",new Date()));
				appInvestList= crt.list();
				for(AppInvestigationAppointments app: appInvestList){
					appInvestigationAppointment=app;
				appInvestigationAppointment.setCurrentVisitStatus("y");
				hbt.update(appInvestigationAppointment);
				}
			}
			
			if(successfullyAdded){
				if(!opdreferal.equals("y")){
					tnx.commit();
					logger.debug("agabb");
					}
				
				session.flush();
			}
			else{
				if(tnx!=null)
				tnx.rollback();
			}
			
			
			final MasHospital hospital=(MasHospital)session.get(MasHospital.class, hospitalId); 
			final List<Visit> finalVisitlist=visitlist;
			final List<QueueManagment> finalManagements=managements; 
			final BlOpBillHeader finalOpBillHeader=opBillHeader;
			final BlOpBillDetails finalOpBillDetails=opBillDetails;
			final Patient finalPatient = patient;
			final Visit finalVisit = visit;
			
			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*new Thread(){
				public void run(){
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					if(hospital!=null && hospital.getClientIp()!=null && !hospital.getClientIp().trim().equals("") && !hospital.getClientIp().trim().equals("null") && hospital.getClientPort()!=null && !hospital.getClientPort().trim().equals("") && !hospital.getClientPort().trim().equals("null")){
						Map<String,Object> data=saveVisitInformationInLeanServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
						String message=(String)data.get("message");
						Parser p1 = new PipeParser(); 
				  	  	String encodedVisitDataMessage;
						try {

							// encodedVisitDataMessage = p1.encode((ADT_A01)data.get("ADTMessage")); //commented by amit das on 19-12-2016
							Map<ADT_A01,String> adt_A01List  = (Map<ADT_A01,String>)data.get("ADTMessage"); // added by amit das on 19-12-2016
							if(adt_A01List!=null && adt_A01List.size()>0){ // added by amit das on 19-12-2016
							for(Entry<ADT_A01, String> entry : adt_A01List.entrySet()) {
								encodedVisitDataMessage = p1.encode(entry.getKey());	
							LeanServerVisitData leanServerVisitData=new LeanServerVisitData();
							leanServerVisitData.setCentralVisitId(Long.parseLong(finalVisit.getId()+""));
							leanServerVisitData.setVisitData(encodedVisitDataMessage);
							leanServerVisitData.setHospitalId(Long.parseLong(hospital.getId()+""));
							if(!"success".equalsIgnoreCase(message)){
								String visitNotSavedToLeanServer="N";
								leanServerVisitData.setStatus(visitNotSavedToLeanServer); 
							}else{
								String visitSavedToLeanServer="Y";
								leanServerVisitData.setStatus(visitSavedToLeanServer); 
							}
							hbt.save(leanServerVisitData);
							}
						  }
						} catch (HL7Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
						
						
					}
					if(hospital!=null && hospital.getServerIp()!=null && !hospital.getServerIp().trim().equals("") && !hospital.getServerIp().trim().equals("null") && hospital.getServerPort()!=null && !hospital.getServerPort().trim().equals("") && !hospital.getServerPort().trim().equals("null")){


						Map<String,Object> data=saveVisitInformationInCentralServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
						Parser p1 = new PipeParser();
				  	  	String encodedVisitDataMessage;
						try {
							List<ADT_A01> adt_A01List  = (List<ADT_A01>)data.get("ADTMessage"); // added by amit das on 19-12-2016
							
							if(adt_A01List!=null && adt_A01List.size()>0){ // added by amit das on 19-12-2016
								for (ADT_A01 anAdt_A01List : adt_A01List) {
									encodedVisitDataMessage = p1.encode(anAdt_A01List);

									CentralServerVisitData centralServerVisitData = new CentralServerVisitData();
									centralServerVisitData.setCentralVisitId(Long.parseLong(finalVisit.getId() + ""));
									centralServerVisitData.setVisitData(encodedVisitDataMessage);
									centralServerVisitData.setHospitalId(Long.parseLong(hospital.getId() + ""));
									String visitSavedToLeanServer = "N";
									centralServerVisitData.setStatus(visitSavedToLeanServer);
									hbt.save(centralServerVisitData);
								}
						   }
						} catch (HL7Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				  	  	
						
					}
				}
				}.start();*/
			
			map.put("visitId", visitId);
			
			// Added by dhananjay 26-Apr-17 TO show the token number and referred department
			map.put("ref_token_No", tokenNo);
			map.put("ref_department_name", department_name);
			logger.debug("department_name department_name "+department_name);
			logger.debug("tokenNo tokenNo "+tokenNo);

		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}
	}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getUpdateRegistrationDetails() {
		logger.debug("Inside Method: getUpdateRegistrationDetails");
		Map<String, Object> map = new HashMap<>();
		List<MasReligion> religionList = new ArrayList<>();
		List<MasTitle> titleList = new ArrayList<>();
		List<MasOccupation> occupationList = new ArrayList<>();
		List<MasMaritalStatus> maritalStatusList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasReference> referenceList = new ArrayList<>();
		List<MasCountry> countryList = new ArrayList<>();
		List<MasState> stateList = new ArrayList<>();
		List<MasDistrict> districtList = new ArrayList<>();
		List<MasBlock> blockList = new ArrayList<>();
		List<MasPostCode> postCodeList = new ArrayList<>();
		List<MasCaste> casteList = new ArrayList<>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasDisposal> disposalList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasVillage> villageList = new ArrayList<>();
		List<MasCompany> companyList = new ArrayList<>();
		List<MasEmployeeDependent> employeeDependentList = new ArrayList<>();
		List<MasState> nativePlaceList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
		try {
			employeeDependentList = session
					.createCriteria(MasEmployeeDependent.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("EmployeeDependentName")).list();

			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "Y"))
					.createAlias("ChargeType", "mct")
					.add(Restrictions.eq("mct.Id", 6))
					.addOrder(Order.asc("ChargeCodeName")).list();

			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("AuthorizerName")).list();

			titleList = session.createCriteria(MasTitle.class)
					.addOrder(Order.asc("TitleName"))
					.add(Restrictions.eq("Status", "Y")).list();
			maritalStatusList = session.createCriteria(MasMaritalStatus.class)
					.addOrder(Order.asc("MaritalStatusName"))
					.add(Restrictions.eq("Status", "Y")).list();
			countryList = session.createCriteria(MasCountry.class)
					.addOrder(Order.asc("CountryName"))
					.add(Restrictions.eq("Status", "Y")).list();
			stateList = session.createCriteria(MasState.class)
					.addOrder(Order.asc("StateName"))
					.add(Restrictions.eq("Status", "Y")).list();
			districtList = session.createCriteria(MasDistrict.class)
					.addOrder(Order.asc("DistrictName"))
					.add(Restrictions.eq("Status", "Y")).list();
			blockList = session.createCriteria(MasBlock.class)
					.addOrder(Order.asc("BlockName"))
					.add(Restrictions.eq("Status", "Y")).list();
			religionList = session.createCriteria(MasReligion.class)
					.addOrder(Order.asc("ReligionName"))
					.add(Restrictions.eq("Status", "Y")).list();
			relationList = session.createCriteria(MasRelation.class)
					.addOrder(Order.asc("RelationName"))
					.add(Restrictions.eq("Status", "Y")).list();
			occupationList = session.createCriteria(MasOccupation.class)
					.addOrder(Order.asc("OccupationName"))
					.add(Restrictions.eq("Status", "Y")).list();
			referenceList = session.createCriteria(MasReference.class)
					.addOrder(Order.asc("ReferenceName"))
					.add(Restrictions.eq("Status", "y")).list();

			bloodGroupList = session.createCriteria(MasBloodGroup.class)
					.addOrder(Order.asc("BloodGroupName"))
					.add(Restrictions.eq("Status", "y")).list();
			diagnosisList = session
					.createCriteria(MasDiagnosisConclusion.class)
					.addOrder(Order.asc("DiagnosisConclusionName"))
					.add(Restrictions.eq("Status", "Y")).list();
			disposalList = session.createCriteria(MasDisposal.class)
					.addOrder(Order.asc("DisposalName"))
					.add(Restrictions.eq("Status", "Y")).list();
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.addOrder(Order.asc("AdministrativeSexName"))
					.add(Restrictions.eq("Status", "Y")).list();
			departmentList = session.createCriteria(MasDepartment.class)
					.addOrder(Order.asc("DepartmentName"))
					.add(Restrictions.eq("Status", "Y")).list();
			employeeList = session.createCriteria(MasEmployee.class)
					.addOrder(Order.asc("FirstName"))
					.add(Restrictions.eq("Status", "Y")).list();
			caseTypeList = session.createCriteria(MasCaseType.class)
					.addOrder(Order.asc("CaseTypeName"))
					.add(Restrictions.eq("Status", "Y")).list();
			patientTypeList = session.createCriteria(MasPatientType.class)
					.addOrder(Order.asc("PatientTypeName"))
					.add(Restrictions.eq("Status", "Y")).list();
			postCodeList = session.createCriteria(MasPostCode.class)
					.addOrder(Order.asc("PostCodeName"))
					.add(Restrictions.eq("Status", "y")).list();
			casteList = session.createCriteria(MasCaste.class)
					.addOrder(Order.asc("CasteName"))
					.add(Restrictions.eq("Status", "Y")).list();
			villageList = session.createCriteria(MasVillage.class)
					.addOrder(Order.asc("VillageName"))
					.add(Restrictions.eq("Status", "y")).list();
			companyList = session.createCriteria(MasCompany.class)
					.addOrder(Order.asc("CompanyName"))
					.add(Restrictions.eq("Status", "Y")).list();

			nativePlaceList = session.createCriteria(MasState.class).list();
			List<MasSetupParameterMaintaince> systemParametersList = new ArrayList<>();
			Criteria crit = session.createCriteria(
					MasSetupParameterMaintaince.class)
					.addOrder(Order.asc("Id"));

			crit.setFirstResult(0);
			crit.setMaxResults(1);
			systemParametersList = crit.list();

			int regChargeId = 0;

			if (systemParametersList != null && systemParametersList.size() > 0) {
				systemParam = systemParametersList.get(0);
				if (systemParam.getRegChargeCode() != null) {
					regChargeId = systemParam.getRegChargeCode().getId();
				}
			}

			map.put("regChargeId", regChargeId);

			map.put("systemParam", systemParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("employeeDependentList", employeeDependentList);
		map.put("maritalStatusList", maritalStatusList);
		map.put("bloodGroupList", bloodGroupList);
		map.put("diagnosisList", diagnosisList);
		map.put("disposalList", disposalList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("titleList", titleList);
		map.put("countryList", countryList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("blockList", blockList);
		map.put("religionList", religionList);
		map.put("relationList", relationList);
		map.put("occupationList", occupationList);
		map.put("referenceList", referenceList);
		map.put("caseTypeList", caseTypeList);
		map.put("patientTypeList", patientTypeList);
		map.put("postCodeList", postCodeList);
		map.put("casteList", casteList);
		map.put("villageList", villageList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("companyList", companyList);
		map.put("nativePlaceList", nativePlaceList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean updateRegistrationInformation(Map<String, Object> valuesMap) {
		logger.debug("Inside Method: updateRegistrationInformation");
		boolean updatedSuccessfully = false;

		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<>();
		utilMap = HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Patient patient = null;
        boolean flag=false;
		PatientAddress pPermAddr = null;
		PatientAddress pTempAddr = null;

		Integer hinId = 0;
		if (valuesMap.get("hinId") != null
				&& !valuesMap.get("hinId").equals("")
				&& !valuesMap.get("hinId").equals(0)) {
			hinId = (Integer) valuesMap.get("hinId");
		}

		if (valuesMap.get("patient") != null
				&& !valuesMap.get("patient").equals("")
				&& !valuesMap.get("patient").equals(0)) {
			patient = (Patient) valuesMap.get("patient");
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			PatientLogUpdate patientLogUpdate=new PatientLogUpdate();
			Patient patientObj = (Patient) hbt.load(Patient.class, hinId);

			if(null != patient)
             {
				patientLogUpdate.setHin(patientObj);
            	 if(!(patientObj.getPFirstName().equals(patient.getPFirstName())))
            	 {
            		 patientLogUpdate.setPatientOldName(patientObj.getPFirstName());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientOldName("");
            	 }
            	
            	 String updateDateCheck="";
            	 String updateDateCheck1="";
            	 String dbDate="";
            	 if(!(patient.getDateOfBirth().equals(null))){
            		 
            		 updateDateCheck1=HMSUtil.convertDateToStringTypeDateOnly(patient.getDateOfBirth());
            		 updateDateCheck1=updateDateCheck1.trim();
            		 updateDateCheck=HMSUtil.getConvertDateYYYYMMDD(updateDateCheck1);
            		 dbDate=patientObj.getDateOfBirth().toString();
            		 
            	 }
            	 if(!(dbDate.equals(updateDateCheck)))
            	 {
            		 patientLogUpdate.setPatientOldDateOfBirth(patientObj.getDateOfBirth()); 
            		 patientLogUpdate.setPatientOldAge(patientObj.getPatientAge().toString());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientOldAge("");
            	 }
            	 if(patient.getIncomeUpdateRemarks()!=null &&  patientObj.getIncomeUpdateRemarks()!=patient.getIncomeUpdateRemarks())
            	 {
            		 patientLogUpdate.setPatientOldIncomeRemarks(patientObj.getIncomeUpdateRemarks());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientOldIncomeRemarks("");
            	 }
            	 if(patient.getRelation()!=null && patientObj.getRelation().getRelationName()!=patient.getRelation().getRelationName())
            	 {
            		 
            		 patientLogUpdate.setPatientOldRelation(patientObj.getRelation().getRelationName());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientOldRelation("");
            	 }
            	 
            	 if(patientObj.getFatherMotherName()!=patient.getFatherMotherName())
            	 {
            		 
            		 patientLogUpdate.setPatientNameOfRelative(patientObj.getFatherMotherName());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientNameOfRelative("");
            	 }
            	 
            	 if(null!=(patientObj.getMonthlyIncome()) && !(patientObj.getMonthlyIncome().equals(patient.getMonthlyIncome())))
            	 {
            		 patientLogUpdate.setPatientOldMonthlyIncome(patientObj.getMonthlyIncome().toString());
            		 flag=true;
            	 }
            	 else{
            		 patientLogUpdate.setPatientOldMonthlyIncome("");
            	 }
            	 
            	 }
			
			String patientAddress = "";
			if (valuesMap.get("pPermAddr") != null) {
				pPermAddr = (PatientAddress) valuesMap.get("pPermAddr");
				
			
				pPermAddr.setHin(patient);
				
				if(pPermAddr.getLsgHouseNo()!=null){
					patientAddress=pPermAddr.getLsgHouseNo();
				}
				if(pPermAddr.getHouseNo()!=null){
					patientAddress=patientAddress+","+pPermAddr.getHouseNo();
				}					
			
				if(pPermAddr.getLocality()!=null){
					PhMasLocality locality=(PhMasLocality)hbt.load(PhMasLocality.class, pPermAddr.getLocality().getId());
					patientAddress=patientAddress+"\n"+locality.getLocalityName();
					if(pPermAddr.getLocality().getLocalityName()!=locality.getLocalityName()){
						patientLogUpdate.setPermanentAddressArea(locality.getLocalityName());
					}
				}
				if(pPermAddr.getDistrict()!=null){
					MasDistrict district=(MasDistrict)hbt.load(MasDistrict.class, pPermAddr.getDistrict().getId());
					patientAddress=patientAddress+","+district.getDistrictName();
				}
				if(pPermAddr.getPinCode()!=null){
					patientAddress=patientAddress+"-"+pPermAddr.getPinCode();
				}
				flag=true;
			}
			
			
			if (valuesMap.get("pTempAddr") != null) {
				pTempAddr = (PatientAddress) valuesMap.get("pTempAddr");
				pTempAddr.setHin(patient);
				
				if(pTempAddr.getHouseNo()!=null){
					patientAddress=pTempAddr.getHouseNo();
					}
				
				if(pTempAddr.getLsgHouseNo()!=null){
					patientAddress=patientAddress+","+pTempAddr.getLsgHouseNo();
				}
				if(pTempAddr.getLocality()!=null){
					PhMasLocality locality=(PhMasLocality)hbt.load(PhMasLocality.class, pTempAddr.getLocality().getId());
					patientAddress=patientAddress+"\n"+locality.getLocalityName();
				}
				if(pTempAddr.getDistrict()!=null){
					MasDistrict district=(MasDistrict)hbt.load(MasDistrict.class, pTempAddr.getDistrict().getId());
					patientAddress=patientAddress+","+district.getDistrictName();
				}
				if(pTempAddr.getPinCode()!=null){
					patientAddress=patientAddress+"-"+pTempAddr.getPinCode();
				}
				flag=true;

			}
            	
			String sqlQry = "update patient set p_first_name =:PFirstName,"
					+ "sex_id =:Sex,"
					+ "date_of_birth =:DOB,"
					+ "age =:Age";
			
			if(patient.getMobileNumber()!=null)
				sqlQry = sqlQry+  ",mobile_number =:MobileNumber";
			
			if(patient.getIdCard()!=null)
				sqlQry = sqlQry+ ",id_card =:IdCard";
			
			if(patient.getIdNo()!=null)
				sqlQry = sqlQry+ ",id_no =:IdNo";
			
			if(patient.getDobOtherCard()!=null)
				sqlQry = sqlQry+ ",dob_other_card_id =:DobOtherCard";
			
			if(patient.getDobOtherCardNumber()!=null)
				sqlQry = sqlQry+ ",dob_other_card_number =:DobOtherCardNumber";

			if(patient.getTemAddressIdProof()!=null)
				sqlQry = sqlQry+ ",tem_address_id_proof =:TemAddressIdProof";

			if(patient.getTempAddressIdProofNum()!=null)
				sqlQry = sqlQry+ ",temp_address_id_proof_num =:TempAddressIdProofNum";

			if(patient.getIncomeUpdateRemarks()!=null)
				sqlQry = sqlQry+ ",income_update_remark =:IncomeUpdateRemarks";

			if(patient.getPatientOldName()!=null)
				sqlQry = sqlQry+  ",patient_old_name =:PatientOldName";

			if(patient.getFullName()!=null)
				sqlQry = sqlQry+  ",full_name =:FullName";
			
			
			if(patient.getFatherMotherName()!=null)
				sqlQry = sqlQry+  ",father_mother_name =:RelativeName";

			if(patient.getMonthlyIncome()!=null)
				sqlQry = sqlQry+  ",monthly_income =:MonthlyIncome";

			if(!patientAddress.equals(""))
				sqlQry = sqlQry+",patient_address =:PatientAddress";

			if(patient.getAddEditDate()!=null)
				sqlQry = sqlQry+",add_edit_date =:AddEditDate";

			if(patient.getAddEditTime()!=null)
				sqlQry = sqlQry+ ",add_edit_time =:AddEditTime";

			if(valuesMap.get("userId")!=null)
				sqlQry = sqlQry+ ",add_edit_by_id =:AddEditBy";

				sqlQry = sqlQry+" where hin_id =:HinId";
	
			SQLQuery updatePatientQry = session.createSQLQuery(sqlQry);
			
             
			if (null != patient) {

				updatePatientQry.setParameter("HinId",hinId);
				updatePatientQry.setParameter("PFirstName",patient.getPFirstName());  
				updatePatientQry.setParameter("Sex",patient.getSex().getId());  
				updatePatientQry.setParameter("DOB",patient.getDateOfBirth());  
				updatePatientQry.setParameter("Age",patient.getAge());   
				
				if(patient.getFatherMotherName()!=null)
					updatePatientQry.setParameter("RelativeName",patient.getFatherMotherName());  
				
				if(patient.getMobileNumber()!=null)
					updatePatientQry.setParameter("MobileNumber",patient.getMobileNumber());  
				
				if(patient.getIdCard()!=null)
					updatePatientQry.setParameter("IdCard",patient.getIdCard().getId());  
				
				if(patient.getIdNo()!=null)
					updatePatientQry.setParameter("IdNo",patient.getIdNo());  
				
				if(patient.getDobOtherCard()!=null)
					updatePatientQry.setParameter("DobOtherCard",patient.getDobOtherCard());  
				
				if(patient.getDobOtherCardNumber()!=null)
					updatePatientQry.setParameter("DobOtherCardNumber",patient.getDobOtherCardNumber());  
				if(null != patient.getTemAddressIdProof()){
					updatePatientQry.setParameter("TemAddressIdProof",patient.getTemAddressIdProof().getId());  
					updatePatientQry.setParameter("TempAddressIdProofNum",patient.getTempAddressIdProofNum());  
					flag=true;
					
				}
				if(patient.getIncomeUpdateRemarks()!=null)
					updatePatientQry.setParameter("IncomeUpdateRemarks",patient.getIncomeUpdateRemarks());  
				
				if(patient.getPatientOldName()!=null)
					updatePatientQry.setParameter("PatientOldName",patient.getPatientOldName());
				if(patient.getFullName()!=null)
					updatePatientQry.setParameter("FullName",patient.getFullName());
				if(patient.getMonthlyIncome()!=null)
					updatePatientQry.setParameter("MonthlyIncome",patient.getMonthlyIncome());  
				

			}
				
			//Changed by Arbind on 11-01-2018
			//if(patient.getPatientAddress()!=null)
			if(!patientAddress.equals("")) {
				if(patientAddress.charAt(0) == ',')
					patientAddress = patientAddress.substring(1);
				updatePatientQry.setParameter("PatientAddress",patientAddress);
			}

			Date addEditDate = null;
			addEditDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
			if(patient.getAddEditDate()!=null)
				updatePatientQry.setParameter("AddEditDate",addEditDate);  
			
			patientLogUpdate.setDateOfUpdate(addEditDate);

			if(patient.getAddEditTime()!=null)	
				updatePatientQry.setParameter("AddEditTime",time);  
				patientLogUpdate.setTimeOfUpdate(time);

			int userId = 0;
			int user=0;
			if (valuesMap.get("userId") != null) {
				userId = (Integer) valuesMap.get("userId");
				user=(Integer)valuesMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				updatePatientQry.setParameter("AddEditBy",userId);
				patientLogUpdate.setEmployeeId(user);
				
			}
			if (valuesMap.get("deptId") != null) {
				String deptId=(String)valuesMap.get("deptId");
				patientLogUpdate.setEmployeeDeptNo(deptId);
				
			}
			updatePatientQry.executeUpdate();
			
			PatientAddress permanentAddress = null;
			PatientAddress tempAddress = null;


			Criteria crt = null;
			crt = session.createCriteria(PatientAddress.class).createAlias("Hin", "hinId")
			.createAlias("AddressType", "at");
			crt.add(Restrictions.eq("hinId.Id", hinId));
			List add = crt.list();
			if (add.size() > 0) {

				crt.add(Restrictions.eq("at.Id", 1));
				List address = crt.list();
				permanentAddress = (PatientAddress) address.get(0);

				Criteria crtTemp = null;
				crtTemp = session.createCriteria(PatientAddress.class).createAlias("Hin", "hinId")
				.createAlias("AddressType", "at")
				.add(Restrictions.eq("hinId.Id", hinId))
				.add(Restrictions.eq("at.Id", 4));
				List addressTemp = crtTemp.list();
				tempAddress = (PatientAddress) addressTemp.get(0);

				if (valuesMap.get("pPermAddr") != null
						&& !valuesMap.get("pPermAddr").equals("")
						&& !valuesMap.get("pPermAddr").equals(0)) {
					pPermAddr = (PatientAddress) valuesMap.get("pPermAddr");

					permanentAddress.setHin(patientObj);
					permanentAddress.setHouseNo(pPermAddr.getHouseNo());
				}
				if (valuesMap.get("pTempAddr") != null
						&& !valuesMap.get("pTempAddr").equals("")
						&& !valuesMap.get("pTempAddr").equals(0)) {
					pTempAddr = (PatientAddress) valuesMap.get("pTempAddr");

                if(tempAddress.getLocality().getLocalityName()!=pTempAddr.getLocality().getLocalityName() && pTempAddr.getLocality().getLocalityName()!="" )
                {
                	patientLogUpdate.setPatientOldArea(pTempAddr.getLocality().getLocalityName());
                }
                if(tempAddress.getDistrict().getDistrictName()!=pTempAddr.getDistrict().getDistrictName() && pTempAddr.getDistrict().getDistrictName()!="" )
                {
                	patientLogUpdate.setPatientOldDistrict(pTempAddr.getDistrict().getDistrictName());
                }
                if(tempAddress.getTaluk().getTalukName()!=pTempAddr.getTaluk().getTalukName() && pTempAddr.getTaluk().getTalukName()!="" )
                {
                	patientLogUpdate.setPatientTemporaryTaluk(pTempAddr.getTaluk().getTalukName());
                }
                if(tempAddress.getLsgName().getLsgTypeName()!=pTempAddr.getLsgName().getLsgTypeName() && pTempAddr.getLsgName().getLsgTypeName()!="" )
                {
                	patientLogUpdate.setPatientTemporaryLsgName(pTempAddr.getLsgName().getLsgTypeName());
                }
                if(tempAddress.getLsgHouseNo()!=pTempAddr.getLsgHouseNo() && pTempAddr.getLsgHouseNo()!="" )
                {
                	patientLogUpdate.setPatientLsgHouseNumber(pTempAddr.getLsgHouseNo());
                }
                if(tempAddress.getPostOffice().getPostCodeName()!=pTempAddr.getPostOffice().getPostCodeName() && pTempAddr.getPostOffice().getPostCodeName()!="" )
                {
                	patientLogUpdate.setPostofficeName(pTempAddr.getPostOffice().getPostCodeName());
                }
                if(tempAddress.getPinCode()!=pTempAddr.getPinCode() )
                {
                	patientLogUpdate.setPatientPostoffice(pTempAddr.getPinCode());
                }
                if(tempAddress.getWardName()!=pTempAddr.getWardName())
                {
                	patientLogUpdate.setPatientTemporaryWard(pTempAddr.getWardName());
                }
                if(tempAddress.getHouseNo()!=pTempAddr.getHouseNo())
                {
                	patientLogUpdate.setPatientColonyHouseNo(pTempAddr.getHouseNo());
                }
                if(tempAddress.getHealthHouseId()!=pTempAddr.getHealthHouseId())
                {
                	patientLogUpdate.setPatientHealthHouseId(pTempAddr.getHealthHouseId());
                }
                
					tempAddress.setHin(patientObj);
					tempAddress.setDistrict(pTempAddr.getDistrict());
					tempAddress.setTaluk(pTempAddr.getTaluk());
					tempAddress.setLsgName(pTempAddr.getLsgName());
					tempAddress.setPostOffice(pTempAddr.getPostOffice());
					tempAddress.setPinCode(pTempAddr.getPinCode());
					tempAddress.setHealthHouseId(pTempAddr.getHealthHouseId());
					tempAddress.setLocality(pTempAddr.getLocality());

				}
				
				hbt.update(permanentAddress);
				hbt.saveOrUpdate(tempAddress);
				flag=true;
			}
			if(!flag){
			hbt.save(patientLogUpdate);
			}
		
			final int hinIdFinal=hinId; 
			
			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*new Thread(){ 
				public void run(){
					try { 
						patientDemographicalChangeInPacs(hinIdFinal);
					} catch (IOException e) { 
						e.printStackTrace();
					}
				}
			}.start(); */
			updatedSuccessfully = true;
		} catch (Exception e) {
			updatedSuccessfully = false;
			e.printStackTrace();
		}

		return updatedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServiceTypeAndRelation(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: getServiceTypeAndRelation");
		List<MasServiceType> serviceTypeList = new ArrayList<>();
		List<MasServiceStatus> serviceStatusList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();

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

		Session session = (Session) getSession();

		serviceTypeList = session.createCriteria(MasServiceType.class)
				.add(Restrictions.idEq(serviceTypeId)).list();
		String serviceTypeCode = "";
		for (MasServiceType masServiceType : serviceTypeList) {
			serviceTypeCode = masServiceType.getServiceTypeCode();
			map.put("serviceTypeCode", serviceTypeCode);
		}
		relationList = session.createCriteria(MasRelation.class)
				.add(Restrictions.idEq(relationId)).list();
		String relationCode = "";
		for (MasRelation masRelation : relationList) {
			relationCode = masRelation.getRelationCode();
			map.put("relationCode", relationCode);
		}
		serviceStatusList = session.createCriteria(MasServiceStatus.class)
				.add(Restrictions.idEq(serviceStatusId)).list();
		String serviceStatusCode = "";
		for (MasServiceStatus masServiceStatus : serviceStatusList) {
			serviceStatusCode = masServiceStatus.getServiceStatusCode();
			map.put("serviceStatusCode", serviceStatusCode);
		}
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMothersName(String motherHinNo) {
		logger.debug("Inside Method: getMothersName");
		Map<String, Object> map = new HashMap<>();
		List<Patient> list = new ArrayList<>();
		String motherName = "";
		String pastDue="";
		int hinId=0;
		Session session = (Session) getSession();
		try {

			list = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", motherHinNo)).list();
			if (list.size() > 0) {
				Patient patient = list.get(0);
				pastDue=patient.getPastDue();
				hinId=patient.getId();
				logger.debug("ffdjkjkdf hinId"+hinId);
				motherName = patient.getPFirstName();
				if (patient.getPLastName() != null) {
					motherName += SPACE + patient.getPLastName();
				}
			}
			map.put("patientName", motherName);
			map.put("pastDue", pastDue);
			map.put("hinId", hinId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getConnectionForReport() {
		logger.debug("Inside Method: getConnectionForReport");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		Connection con = session.connection();

		map.put("conn", con);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public synchronized long getTokenNoForDepartment(Map<String, Object> dataMap) {
		logger.debug("Inside Method: getTokenNoForDepartment");

		MasHospital hospital = null;
		String hospitalCode = null;
		int deptId= 0;
		int visitSessionId=0;
		int hospitalId = 0;
		long tokenNo = 0L;
		Date vDate = null;
		Map<String, Object> reservedTokenMap = null;
		
		if(dataMap.get("hospital")!=null){
			hospital 	=  (MasHospital)dataMap.get("hospital");
			hospitalCode =	hospital.getHospitalCode();
			hospitalId = hospital.getId();
			
		  if(dataMap.get("deptId")!=null)
			deptId = (Integer)dataMap.get("deptId");
		
		  if(dataMap.get("visitSessionId")!=null)
			  visitSessionId = (Integer)dataMap.get("visitSessionId");
		  
		  if(dataMap.get("vDate")!=null)
			  vDate = (Date)dataMap.get("vDate");
		  
		  if(dataMap.get("reservedTokenMap")!=null)
			  reservedTokenMap = (Map<String, Object>)dataMap.get("reservedTokenMap");
		
		String tokenSequenceName = "token_" + deptId + "_" + hospitalCode + "_" + visitSessionId + "_seq";
		logger.debug("hospitalCode---" + hospitalCode);
		logger.debug("tokenSequenceName " + tokenSequenceName);
		List<Integer> tokenSequenceValue = new ArrayList<Integer>();
		String schName = "public";
		Session session = (Session) getSession();
		boolean sequenceExist = false;

		String query = "SELECT COUNT(*) FROM information_schema.sequences WHERE sequence_schema='" + schName + "' AND sequence_name='" + tokenSequenceName + "'";
				
				Query q = session.createSQLQuery(query);

		        BigInteger i = (BigInteger) q.list().get(0);
		        
		        if(i.intValue()==1){
		        	sequenceExist = true;
		        }else if(hospital.getServerIp()==null) {
		        	HMSUtil.generateSequence(tokenSequenceName);
		        	sequenceExist = true;
		        } 
		       
		        if(sequenceExist){
		        	query = "SELECT nextval('"+tokenSequenceName+"')";
		        	q = session.createSQLQuery(query);
		        	logger.debug("qury "+query);
		        	Iterator<BigInteger> iter;
					iter = Collections.<BigInteger>emptyList().iterator();
					iter = (Iterator<BigInteger>) q.list().iterator();
					tokenNo = iter.next().longValue();
					logger.debug("tokenSequenceName tokenNo "+tokenNo);
				}else {
		    		query = "select max(v.TokenNo) from Visit v where v.Hospital.Id=:hospitalId and v.Department.Id=:departmentId and v.VisitDate=:date and v.AppointmentType!='A'";
		    		q = session.createQuery(query);
		    		q.setParameter("hospitalId", hospitalId);
		    		q.setParameter("departmentId", deptId);
		    		q.setParameter("date", vDate);
		    		tokenSequenceValue = q.list();
		    		if (null !=tokenSequenceValue && tokenSequenceValue.size()>0 && null !=tokenSequenceValue.get(0)) {
		    			tokenNo = tokenSequenceValue.get(0);
		    		}
		    		tokenNo = tokenNo+1;
		    		
		    		while (reservedTokenMap.containsKey(String.valueOf(tokenNo))) {
						tokenNo = tokenNo+1;
					}
		    	}	
		        }
				return tokenNo;
	}

	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListForName(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: getPatientListForName");
		Map<String, Object> detailMap = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();
		List<Patient> patientListForInfo = new ArrayList<>();

		String patientName = "";
		Session session = (Session) getSession();

		if (parameterMap.get("patientName") != null) {
			patientName = (String) parameterMap.get("patientName");
		}
		try {
			if (!(patientName.equals(""))) {
				patientList = (List<Patient>) getHibernateTemplate().find(
						"from Patient p ");

			}
			patientListForInfo = session.createCriteria(Patient.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		detailMap.put("patientList", patientList);
		detailMap.put("patientListForInfo", patientListForInfo);
		//
		return detailMap;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		logger.debug("Inside Method: getHinNoList");
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<>();

		try {
			// if(!serviceNo.equals("")){
			patientList = session
					.createCriteria(Patient.class)
					.add(Restrictions.not(Restrictions.eq("PatientStatus",
							"Expired").ignoreCase())).list();
			// }
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForUpdate(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: getPatientDetailsForUpdate");
		Map<String, Object> map = new HashMap<>();
		String hinNo = "";
		int hospitalId = 0;
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		Session session = (Session) getSession();
		// List<Object> patientList = new ArrayList<Object>();
		List<Patient> patientList = new ArrayList<>();
		List<Object> visitList = new ArrayList<>();
		HospitalParameters hospitalParameters = new HospitalParameters();
		List<HospitalParameters> hospitalParametersList = new ArrayList<>();
		try {
			if (parameterMap.get("hinNo") != null) {
				hinNo = (String) parameterMap.get("hinNo");
				patientList = session
						.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo))
						.add(Restrictions.not(Restrictions.eq("PatientStatus",
								"Expired"))).list();
			}

			int patientType = 0;
			int companyId = 0;
			String regType = "";
			String patientCategory = "";

			int hin_id = 0;
			if (patientList.size() > 0) {
				for (Patient patient : patientList) {
					hin_id = patient.getId();
					if (patient.getPatientType() != null) {
						patientType = patient.getPatientType().getId();
					}
					if (patient.getCompany() != null) {
						companyId = patient.getCompany().getId();
					}
					regType = patient.getRegistrationType();
					patientCategory = patient.getPatientStatus();
				}
			}
			map.put("patientType", patientType);
			map.put("companyId", companyId);
			map.put("regType", regType);
			map.put("patientCategory", patientCategory);

			if (hin_id > 0) {
				List<UploadDocuments> uploadDocumentsList = new ArrayList<>();
				uploadDocumentsList = session.createQuery(
						"from jkt.hms.masters.business.UploadDocuments as ud where ud.Hin.Id='"
								+ hin_id + "' order by ud.Id desc").list();
				map.put("uploadDocumentsList", uploadDocumentsList);
			}
			hospitalParametersList = session
					.createCriteria(HospitalParameters.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if (hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList
						.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("hospitalParameters", hospitalParameters);
		map.put("patientList", patientList);
		map.put("visitList", visitList);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Visit> getVisitNo(Map<String, Object> details) {
		logger.debug("Inside Method: getVisitNo");
		String hinNo = "";
		int hospitalId = 0;
		Session session = (Session) getSession();
		List<Visit> visitList = new ArrayList<>();
		Criteria cr = null;

		if (details.get("hinNo") != null) {
			hinNo = (String) details.get("hinNo");
		}
		if (details.get("hospitalId") != null) {
			hospitalId = (Integer) details.get("hospitalId");
		}
		if (!hinNo.equals("")) {
			cr = session.createCriteria(Visit.class);
			cr = cr.createAlias("Hin", "p").add(
					Restrictions.eq("p.HinNo", hinNo));
		}
		if (hospitalId != 0) {
			cr = cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", hospitalId));
		}
		visitList = cr.list();
		return visitList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientVisitDetailsForUpdate(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: getPatientVisitDetailsForUpdate");
		Map<String, Object> map = new HashMap<>();
		int visitNo = 0;
		int hospitalId = 0;
		String hinNo = "";
		if (parameterMap.get("hinNo") != null) {
			hinNo = (String) parameterMap.get("hinNo");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		Session session = (Session) getSession();

		try {
			List<Object> visitList = new ArrayList<>();
			Criteria cr = session.createCriteria(Visit.class);
			if (parameterMap.get("visitNo") != null) {
				visitNo = (Integer) parameterMap.get("visitNo");
				cr = cr.add(Restrictions.eq("VisitNo", visitNo))
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
			}
			if (hospitalId != 0) {
				cr = cr.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId));
			}
			visitList = cr.list();
			map.put("visitList", visitList);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	
	public boolean updateIpPatientInformation(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: updateIpPatientInformation");
		logger.debug(".................." + parameterMap.get("inpatientid"));
		logger.debug(".................." + parameterMap.get("address"));
		Inpatient inPatient = new Inpatient();
		PatientLogUpdate  patientLogUpdate = new PatientLogUpdate();
		MasRelation relationObj=new  MasRelation();
		MasRelation relationLog=new  MasRelation();
		boolean updatedSuccessfully = false;
		Transaction txn= null;
		int inPatientId=0;
		if(parameterMap.get("inpatientid")!=null){
			inPatientId=(Integer)parameterMap.get("inpatientid");
		}
		Session session = (Session) getSession();
		try{
			txn=session.beginTransaction();
			inPatient=(Inpatient)session.get(Inpatient.class, inPatientId);
			String address=null;
			boolean patientUpdated=false;
			if(parameterMap.get("address")!=null){
				if(!(parameterMap.get("address").toString().trim().equalsIgnoreCase(inPatient.getAddress()!=null?inPatient.getAddress().trim():""))){	
				logger.debug("(String)parameterMap.get"+(String)parameterMap.get("address"));
				address=(String)parameterMap.get("address");
				logger.debug("address"+address);
				if(inPatient.getAddress()!=null && !inPatient.getAddress().trim().equals(""))
					patientLogUpdate.setBystanderAddress(inPatient.getAddress());
					else
				patientLogUpdate.setBystanderAddress("Not Defined");
				inPatient.setAddress(address);
				patientUpdated=true;
				}
			}
			String contectNo=null;
			if(parameterMap.get("contectNo")!=null){
				if(!(parameterMap.get("contectNo").toString().trim().equalsIgnoreCase(inPatient.getContactNo()!=null?inPatient.getContactNo().trim():""))){
				logger.debug("(String)parameterMap.get"+(String)parameterMap.get("contectNo"));
				contectNo=(String)parameterMap.get("contectNo");
				logger.debug("contectNo"+contectNo);
				if(inPatient.getContactNo()!=null && !inPatient.getContactNo().trim().equals(""))
					patientLogUpdate.setBystanderMobileNo(inPatient.getContactNo());
					else
				patientLogUpdate.setBystanderMobileNo("Not Defined");
				inPatient.setContactNo(contectNo);
				patientUpdated=true;
				}
			}
			String relation=null;
			if(parameterMap.get("relation")!=null && !parameterMap.get("relation").equals("")){
				relation=(String)parameterMap.get("relation");
				String relId="0";
				if(inPatient.getRelation()!=null) {
					relId=	inPatient.getRelation().getId().toString();
				}
				if(!(Integer.parseInt(relation)==Integer.parseInt(relId))){
				logger.debug("(String)parameterMap.get"+(String)parameterMap.get("relation"));
				relation=(String)parameterMap.get("relation");
				if(!relation.equals("")){
					if(!relId.equals("0")){
					relationLog.setId(inPatient.getRelation().getId());
					patientLogUpdate.setBystanderRelation(relationLog);
					}
					relationObj.setId(Integer.parseInt(relation));
				inPatient.setRelation(relationObj);
				patientUpdated=true;
				}
				
				logger.debug("relation"+relation);
				}
			}
			String bysterName=null;
			if(parameterMap.get("bysterName")!=null){
				if(!(parameterMap.get("bysterName").toString().trim().equalsIgnoreCase(inPatient.getDependentName()!=null?inPatient.getDependentName().trim():""))){
				logger.debug("(String)parameterMap.get"+(String)parameterMap.get("bysterName"));
				bysterName=(String)parameterMap.get("bysterName");
				if(inPatient.getDependentName()!=null && !inPatient.getDependentName().trim().equals(""))
				patientLogUpdate.setPatientNameOfRelative(inPatient.getDependentName());
				else
				patientLogUpdate.setPatientNameOfRelative("Not Defined");	
				inPatient.setDependentName(bysterName);
				patientUpdated=true;
				logger.debug("bysterName"+bysterName);
				}
			}
			if(patientUpdated) {
			Map<String, Object> utilMap = new HashMap<>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
			patientLogUpdate.setDateOfUpdate(date);
			patientLogUpdate.setTimeOfUpdate(time);
			int userId = 0;
			int user=0;
			if (parameterMap.get("userId") != null ) {
				userId = (Integer) parameterMap.get("userId");
				user=(Integer)parameterMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				patientLogUpdate.setEmployeeId(user);
			}
			Patient patient=null;
			if (inPatient.getHin()!=null) {
				patient= new Patient();
				patient.setId(inPatient.getHin().getId());
				patientLogUpdate.setHin(patient);
				}
			} 
			session.saveOrUpdate(inPatient);
			if(patientUpdated) {	
			session.save(patientLogUpdate);
			session.flush();
			txn.commit();
			}
			updatedSuccessfully=true;
		}
		catch(Exception e){
			e.printStackTrace();
			txn.rollback();
		}
		return updatedSuccessfully;
		
	}

	public boolean updateVisitInformation(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: updateVisitInformation");
		boolean updatedSuccessfully = false;

		int visitId = (Integer) parameterMap.get("visitId");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			Visit visit = (Visit) hbt.load(Visit.class, visitId);

			if (parameterMap.get("complaintId") != null) {
				int complaintId = (Integer) parameterMap.get("complaintId");
				MasComplaint masComplaint = new MasComplaint();
				masComplaint.setId(complaintId);
				visit.setComplaint(masComplaint);
			}
			if (parameterMap.get("caseTypeId") != null) {
				int caseTypeId = (Integer) parameterMap.get("caseTypeId");
				MasCaseType masCaseType = new MasCaseType();
				masCaseType.setId(caseTypeId);
				visit.setCaseType(masCaseType);
			}
			if (parameterMap.get("diagnosisId") != null) {
				int diagnosisId = (Integer) parameterMap.get("diagnosisId");
				MasDiagnosisConclusion masDiagnosisConclusion = new MasDiagnosisConclusion();
				masDiagnosisConclusion.setId(diagnosisId);
				visit.setDiagnosis(masDiagnosisConclusion);
			}

			if (parameterMap.get("userId") != null) {
				int userId = (Integer) parameterMap.get("userId");
				Users users = new Users();
				users.setId(userId);
				visit.setAddEditBy(users);
			}
			Date addEditDate = null;
			if (parameterMap.get("addEditDate") != null) {
				addEditDate = (Date) parameterMap.get("addEditDate");
				visit.setAddEditDate(addEditDate);
			}
			String addEditTime = "";
			if (parameterMap.get("addEditTime") != null) {
				addEditTime = (String) parameterMap.get("addEditTime");
				visit.setAddEditTime(addEditTime);
			}
			hbt.update(visit);
			updatedSuccessfully = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return updatedSuccessfully;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForVisit() {
		logger.debug("Inside Method: getDetailsForVisit");
		Map<String, Object> map = new HashMap<>();
		List<MasRank> rankList = new ArrayList<>();
		List<MasServiceType> serviceTypeList = new ArrayList<>();
		List<MasUnit> unitList = new ArrayList<>();

		Session session = (Session) getSession();

		try {
			rankList = session
					.createQuery(
							"select rank from MasRank as rank where rank.Status='y'  order by rank.RankName ")
					.list();
			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createQuery(
					"select dist from MasUnit as dist order by dist.UnitName ")
					.list();

			map.put("rankList", rankList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("unitList", unitList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getServicePersonName(String serviceNo, int serviceTypeId) {
		logger.debug("Inside Method: getServicePersonName");
		Map<String, Object> map = new HashMap<>();
		List<Patient> list = new ArrayList<>();
		List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<>();
		List<MasRank> rankList = new ArrayList<>();
		List<MasUnit> unitList = new ArrayList<>();
		List<MasTrade> tradeList = new ArrayList<>();
		Session session = (Session) getSession();

		try {
			rankList = session
					.createQuery(
							"select rank from MasRank as rank where rank.Status='y'  order by rank.RankName ")
					.list();
			unitList = session.createQuery(
					"select dist from MasUnit as dist order by dist.UnitName ")
					.list();
			tradeList = session.createCriteria(MasTrade.class)
					.add(Restrictions.eq("Status", "y")).list();
			recordOfficeAddressList = session
					.createCriteria(MasRecordOfficeAddress.class)
					.add(Restrictions.eq("Status", "y")).list();

			list = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo))
					.createAlias("ServiceType", "st")
					.add(Restrictions.eq("st.Id", serviceTypeId)).list();
			if (list.size() > 0) {
				map.put("list", list);
			}

			map.put("rankList", rankList);
			map.put("unitList", unitList);
			map.put("tradeList", tradeList);
			map.put("recordOfficeAddressList", recordOfficeAddressList);
			map.put("serviceTypeId", serviceTypeId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	public Map<String, Object> getVisitData(Map<String, Object> dataMap) {
		logger.debug("Inside Method: getVisitData");
		Map<String, Object> map = new HashMap<>();
		List<Visit> vistList = new ArrayList<>();
		List<Patient> list = new ArrayList<>();
		Session session = (Session) getSession();
		String hinNo = "";
		String visitDate = "";
		String visitDiagnosis = "";
		int hinIn = 0;
		hinNo = "" + dataMap.get("hinNo");
		list = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo)).list();
		for (Patient patient : list) {
			hinIn = Integer.parseInt("" + patient.getId());
		}
		vistList = session.createCriteria(Visit.class)
				.add(Restrictions.eq("Hin.Id", hinIn)).list();
		for (Visit visit : vistList) {
			if (visit.getVisitDate() != null) {
				visitDate = HMSUtil.convertDateToStringTypeDateOnly(visit
						.getVisitDate());
			}
			if (visit.getDiagnosis() != null) {
				visitDiagnosis = visit.getDiagnosis()
						.getDiagnosisConclusionName();
			}
		}
		map.put("visitDate", visitDate);
		map.put("visitDiagnosis", visitDiagnosis);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getTokenNo(Map<String, Object> dataMap) {
		logger.debug("Inside Method: getTokenNo");
		Map<String, Object> map = new HashMap<>();
		List<Visit> vistList = new ArrayList<>();
		List<Patient> patientList = new ArrayList<>();
		Session session = (Session) getSession();
		String hinNo = "";
		String tokenNo = "";
		int hinIn = 0;
		hinNo = "" + dataMap.get("hinNo");
		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo)).list();
		for (Patient patient : patientList) {
			hinIn = Integer.parseInt("" + patient.getId());
		}
		vistList = session.createCriteria(Visit.class)
				.add(Restrictions.eq("Hin.Id", hinIn)).list();
		for (Visit visit : vistList) {
			tokenNo = "" + visit.getTokenNo();
		}
		map.put("tokenNo", tokenNo);
		map.put("patientList", patientList);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePatientDetails(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populatePatientDetails");
		Map<String, Object> map = new HashMap<>();

		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<>();
		patientList = session.createCriteria(Patient.class).list();
		map.put("patientList", patientList);
		//
		return map;
	}

	public Map<String, Object> getAdmissionNoList(Map<String, Object> dataMap) {
		//
		Map<String, Object> map = new HashMap<>();
		// String serviceNo = "";
		String hinNo = "";

		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		List<Object> inpatientList = new ArrayList<>();

		try {

			if (!hinNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.HinNo = '"
								+ hinNo + "'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("inpatientList", inpatientList);
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populatePostOff(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populatePostOff");
		Map<String, Object> map = new HashMap<>();
		try {
			int blockId = 0;
			blockId = Integer.parseInt("" + dataMap.get("blockId"));
			List<MasPostCode> masPostCodeList = new ArrayList<>();
			Session session = (Session) getSession();
			masPostCodeList = (List<MasPostCode>) session
					.createCriteria(MasPostCode.class)
					.add(Restrictions.eq("Block.Id", blockId)).list();
			map.put("masPostCodeList", masPostCodeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populateVillage(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateVillage");
		Map<String, Object> map = new HashMap<>();
		int pincodeNumber = 0;
		try {

			Session session = (Session) getSession();
			int postOffId = (Integer) dataMap.get("postOffId");
			logger.debug("postOffId postOffId  " + postOffId);
			List<MasPostCode> pincode = new ArrayList<>();

			pincode = session.createCriteria(MasPostCode.class)
					.add(Restrictions.eq("Id", postOffId)).list();

			for (MasPostCode pin : pincode) {
				pincodeNumber = pin.getPinCode();

			}

			map.put("pincodeNumber", pincodeNumber);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> ajaxForEmployeeDetails(Map<String, Object> dataMap) {
		logger.debug("Inside Method: ajaxForEmployeeDetails");
		Map<String, Object> map = new HashMap<>();
		try {

			int employeeId = 0;
			employeeId = Integer.parseInt("" + dataMap.get("employeeId"));
			List<MasEmployee> masEmployeeList = new ArrayList<>();
			Session session = (Session) getSession();
			masEmployeeList = (List<MasEmployee>) session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Id", employeeId)).list();
			map.put("masEmployeeList", masEmployeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> populateDepandentList(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateDepandentList");
		Map<String, Object> map = new HashMap<>();
		try {
			int employeeId = 0;
			employeeId = Integer.parseInt("" + dataMap.get("employeeId"));
			List<MasEmployeeDependent> employeeDependentList = new ArrayList<>();
			Session session = (Session) getSession();
			employeeDependentList = (List<MasEmployeeDependent>) session
					.createCriteria(MasEmployeeDependent.class)
					.add(Restrictions.eq("Employee.Id", employeeId))
					.add(Restrictions.eq("Status", "y")).list();
			map.put("employeeDependentList", employeeDependentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	public Map<String, Object> getDepandentDetails(Map<String, Object> dataMap) {
		logger.debug("Inside Method: getDepandentDetails");
		Map<String, Object> map = new HashMap<>();
		try {

			int employeeDependentId = 0;
			employeeDependentId = Integer.parseInt(""
					+ dataMap.get("employeeDependentId"));
			List<MasEmployeeDependent> employeeDependentList = new ArrayList<>();
			Session session = (Session) getSession();
			employeeDependentList = (List<MasEmployeeDependent>) session
					.createCriteria(MasEmployeeDependent.class)
					.add(Restrictions.eq("Id", employeeDependentId)).list();
			map.put("employeeDependentList", employeeDependentList);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * Return Validity Days from MasPatient Table
	 * 
	 * @author Mukesh.narayan
	 * @param PatientTypeId
	 * @return no of days
	 */
	@SuppressWarnings("unchecked")
	public int getPatientTypeValidityDays(int patientTypeId) {
		logger.debug("Inside Method: getPatientTypeValidityDays");
		int cardDays = 0;
		try {

			List<MasPatientType> patientTypeList = new ArrayList<>();
			Session session = (Session) getSession();
			try {
				patientTypeList = session.createCriteria(MasPatientType.class)
						.add(Restrictions.idEq(patientTypeId)).list();
				if (patientTypeList.size() > 0) {
					for (MasPatientType masPatientType : patientTypeList) {
						// cardDays = masPatientType.getValidity();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return cardDays;
	}

	/**
	 * papulate village on change of district
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateVillageFromDist(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateVillageFromDist");
		Map<String, Object> map = new HashMap<>();
		try {
			int districtId = 0;
			districtId = Integer.parseInt("" + dataMap.get("districtId"));
			List<MasVillage> masVillageList = new ArrayList<>();
			Session session = (Session) getSession();
			masVillageList = (List<MasVillage>) session
					.createCriteria(MasVillage.class)
					.createAlias("PostCode", "pc")
					.createAlias("pc.Block", "block")
					.createAlias("block.District", "dst")
					.add(Restrictions.eq("dst.Id", districtId))
					.addOrder(Order.asc("VillageName")).list();
			map.put("masVillageList", masVillageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	/**
	 * populate village on change of block
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 * @date 13 july 2010
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateVillageOfBlock(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateVillageOfBlock");
		Map<String, Object> map = new HashMap<>();
		try {
			int blockId = 0;
			blockId = Integer.parseInt("" + dataMap.get("blockId"));
			List<MasVillage> masVillageList = new ArrayList<>();
			Session session = (Session) getSession();
			masVillageList = (List<MasVillage>) session
					.createCriteria(MasVillage.class)
					.createAlias("PostCode", "pc")
					.createAlias("pc.Block", "block")
					.add(Restrictions.eq("block.Id", blockId))
					.addOrder(Order.asc("VillageName")).list();
			map.put("masVillageList", masVillageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	/**
	 * papulate village on change of block
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 * @date 13 july 2010
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> populateVillageOftaluk(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateVillageOftaluk");
		Map<String, Object> map = new HashMap<>();
		try {
			int talukId = 0;
			talukId = (Integer) dataMap.get("talukId");
			List<MasVillage> masVillageList = new ArrayList<>();
			Session session = (Session) getSession();
			masVillageList = (List<MasVillage>) session
					.createCriteria(MasVillage.class)
					.createAlias("Taluk", "taluk")

					.add(Restrictions.eq("taluk.Id", talukId))
					.addOrder(Order.asc("VillageName")).list();
			map.put("masVillageList", masVillageList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;
	}

	/**
	 * get Patient detail for autocomplete
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 * @date 13 july 2010
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailForAutoComplete(Map<String, Object> parameterMap) {
		logger.debug("Inside Method: getPatientDetailForAutoComplete");
		Map<String, Object> map = new HashMap<>();

		String flagPop = "";
		String pFirstNameId = "";
		String pMiddleNameId = "";
		String pLastNameId = "";

		if (parameterMap.get("flagPop") != null) {
			flagPop = (String) parameterMap.get("flagPop");
		}
		List<Patient> patientList = new ArrayList<>();
		if (parameterMap.get("pFirstNameId") != null) {
			pFirstNameId = (String) parameterMap.get("pFirstNameId");
		}
		Session session = (Session) getSession();
		FullTextSession fullTextSession = Search.createFullTextSession(session);
		Transaction tx = fullTextSession.beginTransaction();
		try {
			if (flagPop.equalsIgnoreCase("1")) {

				if (parameterMap.get("pMiddleNameId") != null) {
					pMiddleNameId = (String) parameterMap.get("pMiddleNameId");
				}

				if (parameterMap.get("pLastNameId") != null) {
					pLastNameId = (String) parameterMap.get("pLastNameId");
				}

				if (pFirstNameId != "" && pMiddleNameId != ""
						&& pLastNameId != "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"+pFirstNameId+"%' and pt.PMiddleName like '"+pMiddleNameId+"%' and pt.PLastName like '"+pLastNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"
									+ pFirstNameId
									+ "%' and pt.PMiddleName like '"
									+ pMiddleNameId
									+ "%' and pt.PLastName like '"
									+ pLastNameId + "%'").list();
				} else if (pFirstNameId == "" && pMiddleNameId != ""
						&& pLastNameId != "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PMiddleName like '"+pMiddleNameId+"%' and pt.PLastName like '"+pLastNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PMiddleName like '"
									+ pMiddleNameId
									+ "%' and pt.PLastName like '"
									+ pLastNameId + "%'").list();
				} else if (pFirstNameId == "" && pMiddleNameId == ""
						&& pLastNameId != "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PLastName like '"+pLastNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PLastName like '"
									+ pLastNameId + "%'").list();
				} else if (pFirstNameId != "" && pMiddleNameId == ""
						&& pLastNameId != "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"+pFirstNameId+"%' and pt.PLastName like '"+pLastNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"
									+ pFirstNameId
									+ "%' and pt.PLastName like '"
									+ pLastNameId + "%'").list();
				} else if (pFirstNameId != "" && pMiddleNameId == ""
						&& pLastNameId == "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"+pFirstNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"
									+ pFirstNameId + "%'").list();
				} else if (pFirstNameId != "" && pMiddleNameId != ""
						&& pLastNameId == "") {
					// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"+pFirstNameId+"%' and pt.PMiddleName like '"+pMiddleNameId+"%'");
					patientList = session.createQuery(
							"from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"
									+ pFirstNameId
									+ "%' and pt.PMiddleName like '"
									+ pMiddleNameId + "%'").list();
				}
			} else {
				// patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"+pFirstNameId+"%'");
				patientList = session.createQuery(
						"from jkt.hms.masters.business.Patient as pt where pt.PFirstName like '"
								+ pFirstNameId + "%'").list();
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> displayRegisPhoto(String hinNo) {
		logger.debug("Inside Method: displayRegisPhoto");
		Map<String, Object> map = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();
		Session session = (Session) getSession();
		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		}
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> addPhotoFile(Map<String, Object> generalMap) {
		logger.debug("Inside Method: addPhotoFile");
		Map<String, Object> map = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();
		Criteria crt = null;
		int hinId = 0;
		Session session = (Session) getSession();

		String filename = "";
		if (generalMap.get("filename") != null) {
			filename = (String) generalMap.get("filename");
			logger.debug("filename " + filename);
		}
		String uploadURL = "";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
			logger.debug("uploadURL " + uploadURL);
		}
		String hinNo = "";
		if (generalMap.get("hinNo") != null) {
			hinNo = (String) generalMap.get("hinNo");
		}
		crt = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
		patientList = crt.list();

		for (Patient p : patientList) {
			hinId = p.getId();
			logger.debug("hinId  " + hinId);
		}

		String gender = "";
		if (generalMap.get("gender") != null) {
			gender = (String) generalMap.get("gender");
		}
		String age = "";
		if (generalMap.get("age") != null) {
			age = (String) generalMap.get("age");
		}
		String address = "";
		if (generalMap.get("address") != null) {
			address = (String) generalMap.get("address");
		}

		Map<String, Object> utilMap = new HashMap<>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		int hospitalId = (Integer) generalMap.get("hospitalId");
		String fileExtension = null;
		File file = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();

			hbt.setCheckWriteOperations(false);
			file = new File(uploadURL + "/" + generalMap.get("filename"));

			FileInputStream is = new FileInputStream(file);
			long length = file.length();
			logger.debug("lengthlength " + length);

			if (length > Integer.MAX_VALUE) {
				// File is too large
			}

			byte[] bytes = new byte[(int) length];
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			if (offset < bytes.length) {
				throw new IOException("Could not completely read file "
						+ file.getName());

			}
			is.close();
			StringTokenizer strToken = new StringTokenizer(filename, ".");

			filename = strToken.nextToken();
			if (null != fileExtension && !fileExtension.equals(""))
				fileExtension = strToken.nextToken();
			UploadDocuments uploadDocuments = new UploadDocuments();

			List<UploadDocuments> uploadDocumentsList = new ArrayList<>();

			uploadDocumentsList = session.createQuery(
					"from jkt.hms.masters.business.UploadDocuments as ud where ud.Hin.Id='"
							+ hinId + "' order by ud.Id desc").list();
			UploadDocuments uploadDocuments1 = new UploadDocuments();
			// map.put("uploadDocumentsList", uploadDocumentsList);
			if (uploadDocumentsList.size() > 0) {
				hbt.setFlushModeName("FLUSH_EAGER");
				uploadDocuments1 = (UploadDocuments) uploadDocumentsList.get(0);
				int uploadDocumentId = uploadDocuments1.getId();
				//
				uploadDocuments = (UploadDocuments) hbt.load(
						UploadDocuments.class, uploadDocumentId);
				uploadDocuments.setPatientDocument(bytes);
				uploadDocuments.setDescription("Update Registration Done");
				uploadDocuments.setFileExtension(fileExtension);
				uploadDocuments.setFileName(filename);
				uploadDocuments.setUploadDate(date);
				uploadDocuments.setLastChgDate(date);
				uploadDocuments.setLastChgTime(time);
				// uploadDocuments.setLastChgBy(userName);
				hbt.update(uploadDocuments);
			} else {
				uploadDocuments.setPatientDocument(bytes);

				uploadDocuments.setAddress(address);
				uploadDocuments.setSex(gender);
				uploadDocuments.setAge(age);
				if (hinId != 0) {
					Patient patient = new Patient();
					patient.setId(hinId);
					uploadDocuments.setPatientName(patient.getPFirstName());
					uploadDocuments.setHin(patient);
				}
				uploadDocuments.setDescription("Registration Done");
				uploadDocuments.setFileExtension(fileExtension);
				uploadDocuments.setFileName(filename);
				uploadDocuments.setUploadDate(date);
				uploadDocuments.setLastChgDate(date);
				uploadDocuments.setLastChgTime(time);
				// uploadDocuments.setLastChgBy(userName);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				// uploadDocuments.setHospital(masHospital);
				hbt.save(uploadDocuments);
			}

		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> updatePatientImage(Map<String, Object> generalMap) {
		logger.debug("Inside Method: updatePatientImage");
		Map<String, Object> map = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();
		// Session session = (Session)getSession();
		String uploadURL = "";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
		String hinNo = "";
		if (generalMap.get("hinNo") != null) {
			hinNo = (String) generalMap.get("hinNo");
		}

		File file = null;
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setCheckWriteOperations(false);
			hbt.setFlushModeName("FLUSH_EAGER");
			patientList = hbt
					.find("from  jkt.hms.masters.business.Patient as patient where patient.HinNo='"
							+ hinNo + "'");
			if (patientList.size() > 0) {
				int hinId = 0;
				for (Patient patient : patientList) {
					hinId = patient.getId();
				}
				if (hinId > 0) {

					String filename = "";
					filename = hinNo + ".jpg";
					String fileSeparator = System.getProperty("file.separator");
					file = new File(uploadURL + fileSeparator + hinNo + ".jpg");

					File f = new File(uploadURL);
					try {
						if (f.exists()) {
							f.delete();
							f.mkdir();
							FileInputStream is = new FileInputStream(file);
							long length = file.length();

							if (length > Integer.MAX_VALUE) {
								// File is too large
							}
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}
							Patient patient = new Patient();
							patient = (Patient) hbt.load(Patient.class, hinId);
							patient.setPatientImage(bytes);
							hbt.update(patient);
							is.close();
						} else {
							f.mkdir();
							FileInputStream is = new FileInputStream(file);
							long length = file.length();

							if (length > Integer.MAX_VALUE) {
							}
							byte[] bytes = new byte[(int) length];
							int offset = 0;
							int numRead = 0;
							while (offset < bytes.length
									&& (numRead = is.read(bytes, offset,
											bytes.length - offset)) >= 0) {
								offset += numRead;
							}

							if (offset < bytes.length) {
								throw new IOException(
										"Could not completely read file "
												+ file.getName());
							}
							is.close();

							Patient patient = new Patient();
							patient = (Patient) hbt.load(Patient.class, hinId);
							patient.setPatientImage(bytes);
							hbt.update(patient);
						}
						StringTokenizer strToken = new StringTokenizer(
								filename, ".");
						filename = strToken.nextToken();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getUserList(Map<String, Object> mapDetails) {
		logger.debug("Inside Method: getUserList");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		int hospitalId = (Integer) mapDetails.get("hospitalId");
		List<MasEmployee> employeeList = new ArrayList<>();
		List<MasState> stateList = new ArrayList<>();
		int deptId = (Integer) mapDetails.get("deptId");
		logger.debug(deptId);
		try {

			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId)).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			map.put("employeeList", employeeList);
			map.put("stateList", stateList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> getUserName(int empId) {
		logger.debug("Inside Method: getUserName");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		try {
			List<Users> userList = new ArrayList<>();
			userList = session.createCriteria(Users.class)
					.add(Restrictions.eq("Employee.Id", empId)).list();
			map.put("userList", userList);
		} catch (HibernateException | DataAccessException e) {
			e.printStackTrace();
		}
		return map;

	}

	@Override
	public String getHinNo(int hinId) {
		logger.debug("Inside Method: getHinNo");
		Session session = (Session) getSession();
		String hinNo = "";
		List<Patient> patientList = new ArrayList<>();
		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
		} catch (HibernateException | DataAccessException e) {
			e.printStackTrace();
		}
		for (Patient patient : patientList) {
			hinNo = patient.getHinNo();
		}

		return hinNo;

	}

	@Override
	public String getDepartmentname(int departmentId) {
		logger.debug("Inside Method: getDepartmentname");
		Session session = (Session) getSession();
		String departmentName = "";
		List<MasDepartment> deptList = new ArrayList<>();
		try {
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", departmentId)).list();
		} catch (HibernateException | DataAccessException e) {
			e.printStackTrace();
		}
		for (MasDepartment dept : deptList) {
			departmentName = dept.getDepartmentName();
		}
		return departmentName;

	}

	@Override
	public boolean opdPatientDetailsPhysio(OpdPatientDetails opdPatientDetails) {
		logger.debug("Inside Method: opdPatientDetailsPhysio");
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		hbt.save(opdPatientDetails);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public Map<String, Object> getDocForVisit(int deptId) {
		logger.debug("Inside Method: getDocForVisit");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		List<Object[]> doclist = new ArrayList<>();
		String queryForDoctor = "select employee_id,first_name,last_name from mas_employee where emp_category_id=1 and status='y' and department_id="
				+ deptId;
		doclist = session.createSQLQuery(queryForDoctor).list();
		//
		map.put("doclist", doclist);
		return map;
	}

	@Override
	public Map<String, Object> populateRegistrationContact(int deptId) {
		logger.debug("Inside Method: populateRegistrationContact");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<Object[]> relationList = new ArrayList<>();
		List<Object[]> maritalStatusList = new ArrayList<>();
		List<Object[]> countryList = new ArrayList<>();
		List<Object[]> stateList = new ArrayList<>();
		List<Object[]> districtList = new ArrayList<>();
		List<MasBlock> blockList = new ArrayList<>();
		List<MasOccupation> occupationList = new ArrayList<>();
		List<MasReference> referenceList = new ArrayList<>();
		List<MasPostCode> postCodeList = new ArrayList<>();
		List<MasVillage> villageList = new ArrayList<>();
		List<MasState> nativePlaceList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();
		int stateId = 0;
		String blockStatus = "";
		String postOfficeStatus = "";
		int cityId = 0;
		int blockId = 0;

		try {
			String queryForRelation = "select relation_id,relation_name from mas_relation where status='Y'";
			relationList = session.createSQLQuery(queryForRelation).list();

			String queryForMaritalStatus = "select marital_status_id,marital_status_name from mas_marital_status where status='Y'";
			maritalStatusList = session.createSQLQuery(queryForMaritalStatus)
					.list();

			String queryForCountry = "select country_id,country_code,country_name from mas_country where status='Y'";
			countryList = session.createSQLQuery(queryForCountry).list();

			String queryForState = "select state_id,state_name from mas_state where  status='Y'";
			stateList = session.createSQLQuery(queryForState).list();

			String queryForDistrict = "select district_id,district_code,district_name from mas_district where status='Y'";
			districtList = session.createSQLQuery(queryForDistrict).list();

			blockList = session.createCriteria(MasBlock.class)
					.add(Restrictions.eq("Status", "Y")).list();

			occupationList = session.createQuery(
					"select dist from MasOccupation as dist order by dist.Id ")
					.list();

			referenceList = session.createCriteria(MasReference.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "y")).list();
			authorizerList = session.createCriteria(MasAuthorizer.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "y")).list();
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "y")).list();

			List<HospitalParameters> hospitalParametersList = session
					.createCriteria(HospitalParameters.class).list();
			HospitalParameters hospitalParameters = new HospitalParameters();

			if (hospitalParametersList != null
					&& hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList.get(0);
				if (hospitalParameters.getState() != null) {
					stateId = hospitalParameters.getState().getId();
				}

				if (hospitalParameters.getPostOffice() != null) {
					postOfficeStatus = hospitalParameters.getPostOffice()
							.trim();
				}

				if (hospitalParameters.getCity() != null) {
					cityId = hospitalParameters.getCity().getId();
				}
			}

			List<MasSetupParameterMaintaince> systemParametersList = session
					.createCriteria(MasSetupParameterMaintaince.class)
					.addOrder(Order.asc("Id")).setFirstResult(0)
					.setMaxResults(1).list();

			if (systemParametersList != null && systemParametersList.size() > 0) {
				systemParam = systemParametersList.get(0);
				if (systemParam.getBlock() != null) {
					blockId = systemParam.getBlock().getId();
				}
			}

			postCodeList = session.createQuery(
					"select dist from MasPostCode as dist  ").list();

			villageList = session.createCriteria(MasVillage.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			nativePlaceList = session.createCriteria(MasState.class).list();

			map.put("relationList", relationList);
			map.put("maritalStatusList", maritalStatusList);
			map.put("countryList", countryList);
			map.put("stateList", stateList);
			map.put("districtList", districtList);
			map.put("blockList", blockList);
			map.put("occupationList", occupationList);
			map.put("referenceList", referenceList);
			map.put("authorizerList", authorizerList);
			map.put("chargeCodeList", chargeCodeList);
			map.put("stateId", stateId);
			map.put("postOfficeStatus", postOfficeStatus);
			map.put("cityId", cityId);
			map.put("blockId", blockId);
			map.put("postCodeList", postCodeList);
			map.put("villageList", villageList);
			map.put("nativePlaceList", nativePlaceList);
			map.put("blockStatus", blockStatus);

			queryForRelation = null;
			queryForMaritalStatus = null;
			queryForCountry = null;
			queryForState = null;
			queryForDistrict = null;
			hospitalParametersList.clear();
			hospitalParametersList = null;
			authorizerList = null;
			chargeCodeList = null;
			systemParametersList.clear();
			systemParametersList = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> populatePatientForUpdate(String hinNo) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<Object[]> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();

		List<PatientAddress> aadharAddress = new ArrayList<>();
		List<PatientAddress> tempAddress = new ArrayList<>();
		List<PatientAddress> permanentAddress = new ArrayList<>();

		try {

			patientTypeList = session.createCriteria(MasPatientType.class)
					.addOrder(Order.asc("PatientTypeName"))
					.add(Restrictions.eq("Status", "Y")).list();

			complaintList = session.createCriteria(MasComplaint.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("Hospital", "hospitalId")

					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("DepartmentName")).list();

			caseTypeList = session.createCriteria(MasCaseType.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y")).list();

			relationList = session.createCriteria(MasRelation.class)
					.addOrder(Order.asc("RelationName"))
					.add(Restrictions.eq("Status", "Y")).list();

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.addOrder(Order.asc("AdministrativeSexName"))
					.add(Restrictions.eq("Status", "Y")).list();

			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("AuthorizerName")).list();

			logger.debug("authorizerList " + authorizerList.size());

			List<Patient> patientDetailsList = new ArrayList<>();

			int hinId = 0;
			if (hinNo != null && !hinNo.equals("")) {

				patientDetailsList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).list();

				map.put("patientDetailsList", patientDetailsList);

				if (patientDetailsList.size() != 0) {
					for (Patient patient : patientDetailsList) {
						hinId = patient.getId();

					}
					aadharAddress = session
							.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hin")
							.createAlias("AddressType", "addressType")
							.add(Restrictions.eq("addressType.Id", 2))
							.add(Restrictions.eq("hin.Id", hinId)).list();

					tempAddress = session.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hin")
							.createAlias("AddressType", "addressType")
							.add(Restrictions.eq("addressType.Id", 4))
							.add(Restrictions.eq("hin.Id", hinId)).list();

					permanentAddress = session
							.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hin")
							.createAlias("AddressType", "addressType")
							.add(Restrictions.eq("addressType.Id", 1))
							.add(Restrictions.eq("hin.Id", hinId)).list();

				}

			}

			map.put("aadharAddress", aadharAddress);
			map.put("tempAddress", tempAddress);
			map.put("permanentAddress", permanentAddress);

			map.put("complaintList", complaintList);
			map.put("departmentList", departmentList);
			map.put("doctorList", doctorList);
			map.put("caseTypeList", caseTypeList);
			map.put("diagnosisList", diagnosisList);
			map.put("relationList", relationList);
			map.put("patientTypeList", patientTypeList);
			map.put("sexList", sexList);
			map.put("chargeCodeList", chargeCodeList);
			map.put("authorizerList", authorizerList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> populateRegistrationVisit(int deptId, int hospitalId, String hinNo, int page,
			String visitSearch) {
		logger.debug("Inside Method: populateRegistrationVisit");

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		
		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
		List<Object[]> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		List<Patient> searchDataList = new ArrayList<>();
		List<MasSession> masSessionList = new ArrayList<>();
		List<OpdPatientDetails> opdPatientDetailsList= new ArrayList<>();
		
		int recordsPerPage = 5;
		
		try {

			Date currentRegisterDate=new Date();
			
			Criteria crt = null;
			crt = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.isNull("CurrentVisitNo"));

			if(visitSearch.equalsIgnoreCase("")){
				
				crt.add(Restrictions.eq("RegDate",currentRegisterDate));
			}
			else{
				crt.add(Restrictions.eq("hospital.Id",hospitalId));
			}
			
			crt.setFirstResult((page - 1)*recordsPerPage);
			crt.setMaxResults(recordsPerPage);

			Criteria crty = session.createCriteria(Patient.class).createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					//.add(Restrictions.eq("RegDate", currentRegisterDate))
					.add(Restrictions.isNull("CurrentVisitNo"));
			crty.setProjection(Projections.rowCount());
			
			if(visitSearch.equalsIgnoreCase("")){
				
				crty.add(Restrictions.eq("RegDate",currentRegisterDate));
			}else{
				crty.add(Restrictions.eq("hospital.Id",hospitalId));
				
			}
			
			searchDataList = crt.list();
			
			if(null !=searchDataList && searchDataList.size()>0)
			map.put("currentRegistrationList", searchDataList);
			int noOfRecords = (Integer) crty.uniqueResult();
			
			int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
			
			patientTypeList = session.createCriteria(MasPatientType.class)

			.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			complaintList = session.createCriteria(MasComplaint.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType","DepartmentType")
					.add(Restrictions.eq("DepartmentType.Id",1))
					.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			
			
			nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.ne("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
			

			caseTypeList = session.createCriteria(MasCaseType.class)
					.addOrder(Order.asc("Id"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		
			relationList = session.createCriteria(MasRelation.class)
					.addOrder(Order.asc("RelationName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.addOrder(Order.asc("AdministrativeSexName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.createAlias("ChargeType", "chargeType")
					.addOrder(Order.asc("ChargeCodeName"))
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.add(Restrictions.eq("chargeType.Id", 9)).list();
			
			List<MasScheme> schemeList= new ArrayList<>();
			
			schemeList = session.createCriteria(MasScheme.class)
					.addOrder(Order.asc("SchemeName"))
					.add(Restrictions.eq("Status", "Y")).list();
			
			masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
					.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			
			BigDecimal mas_charge_code_rate = null;
			List<MasChargeCodeRates> rateList= new ArrayList<>();
			rateList=session.createCriteria(MasChargeCodeRates.class).
					createAlias("ChargeCode","chargecode")
					.add(Restrictions.eq("chargecode.Id", 1038)).list();
			for(MasChargeCodeRates rate:rateList){
				mas_charge_code_rate=rate.getRate();
				
			}
			

			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("AuthorizerName")).list();

			List<Patient> patientDetailsList = new ArrayList<>();
			List<Visit> visitList = new ArrayList<>();
			List<UploadDocuments> image= new ArrayList<>();
			
			int visitNo = 0;
			int hinId = 0;
			long memberId = 0;
			String pragnent = "no";

			if (hinNo != null && !hinNo.equals("")) {

				patientDetailsList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).list();

				
				
				if (patientDetailsList.size() != 0) {
					for (Patient patient : patientDetailsList) {
						hinId = patient.getId();
						
						if(patient.getMember()!=null)
						memberId = patient.getMember().getId(); // added by amit das on 08-06-2016 for JSSK scheme default selected for pragnentwoman
					}
					image=session.createCriteria(UploadDocuments.class).createAlias("Hin", "Hin")
							.add(Restrictions.eq("Hin.Id", hinId)).list();
					
					 List<PhAncSurvey> phAncSurveyList  =session.createCriteria(PhAncSurvey.class)
							.add(Restrictions.eq("MemberId",Long.parseLong(memberId+""))).list();
					 if(phAncSurveyList!=null && phAncSurveyList.size()>0)
						 pragnent = "yes";

					for(UploadDocuments patientimage:image){
						
					}
				}
				visitList = session.createCriteria(Visit.class)
						.createAlias("Hin", "hin")
						.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("Hin.Id", hinId)).list();

				if (visitList.size() > 0) {
					for (Visit vist : visitList) {
						visitNo = vist.getVisitNo();

					}

				}
								
				visitNo = visitNo + 1;
				
				
				
				opdPatientDetailsList = session.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "visit")
						.createAlias("visit.Hin", "hin")
						.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("ReviewDate", new Date()))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("hin.Id", hinId)).list();
				
				logger.debug("opdPatientDetailsList "+opdPatientDetailsList.size());
			}
			map.put("patientDetailsList", patientDetailsList);
			map.put("opdPatientDetailsList", opdPatientDetailsList);
			map.put("mas_charge_code_rate", mas_charge_code_rate);
			map.put("visitList", visitList);
			map.put("patientvisitNum", visitNo);
			map.put("complaintList", complaintList);
			map.put("departmentList", departmentList);
			map.put("doctorList", doctorList);
			map.put("caseTypeList", caseTypeList);
			map.put("diagnosisList", diagnosisList);
			map.put("relationList", relationList);
			map.put("patientTypeList", patientTypeList);
			map.put("sexList", sexList);
			map.put("chargeCodeList", chargeCodeList);
			map.put("authorizerList", authorizerList);
			map.put("schemeList", schemeList);
			map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
			map.put("noOfPages", noOfPages);
			map.put("currentPage", page);
			map.put("masSessionList", masSessionList);
			map.put("pragnent", pragnent);
			map.put("opdPatientDetailsList", opdPatientDetailsList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@Override
	public Map<String, Object> showRegistrationCardReportJsp(int hospitalId) {
		logger.debug("Inside Method: showRegistrationCardReportJsp");
		Map<String,Object> map= new HashMap<>();
		Session session=(Session)getSession();
		List<MasAuthorizer> authorizerList = new ArrayList<>();

		authorizerList = session.createCriteria(MasAuthorizer.class).createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Status", "Y"))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("AuthorizerName")).list();
		map.put("authorizerList", authorizerList);
		
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chargeType")
				.addOrder(Order.asc("ChargeCodeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("chargeType.Id", 9)).list();
		
		map.put("chargeCodeList", chargeCodeList);

		return map;
	}

	@Override
	public Map<String, Object> populatePatientCitizenData(int citizen) {
		logger.debug("Inside Method: populatePatientCitizenData");

		long familyId=0;
		int familySequenceId=0;
		int houseId=0;
		String query=null;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<PhMemberSurvey> memberList = new ArrayList<>();
		List<PhHouseSurvey> houseList = new ArrayList<>();
		List<PhHouseSurvey> houseLocalityList = new ArrayList<>();
		List<PhMasLocality> localityList = new ArrayList<>();

		try {
			logger.debug("citizen "+citizen);
			memberList = session.createCriteria(PhMemberSurvey.class)

			.add(Restrictions.eq("Id", citizen)).list();
			
			for(PhMemberSurvey phMember:memberList){
				
				if(phMember.getFamilyId()!=null)
					familyId=phMember.getFamilyId();
				
				if(null !=phMember.getHouse())
					houseId=phMember.getHouse().getId();
				
			}
			
			if(houseId >0){
				query="from PhHouseSurvey as ph where ph.HouseHoldId = :fId";
				Query qry=session.createQuery(query);
				qry.setParameter("fId", String.valueOf(houseId));
				houseList=qry.list();
				map.put("houseList", houseList);
			}
			
			if(familyId>0){
				query="Select Id from PhFamilySurvey where FamilyId = :fId";
				Query qry=session.createQuery(query);
				qry.setParameter("fId", String.valueOf(familyId));
				
				List faimlyList=qry.list();
				//changed for maven
				if(faimlyList.size()>0)
					familySequenceId= (Integer) faimlyList.get(0);
				
				map.put("familySequenceId", familySequenceId);
			}
			
			map.put("memberList", memberList);
			logger.debug("memberList====================="+memberList.size());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> populateOnlinePage(int deptId, int hospitalId) {
		logger.debug("Inside Method: populateOnlinePage");

		List<MasDepartment> departmentList = null;
		List<HospitalDoctorUnitM> unitExisted= null;
		//List<Object[]> employeeByCategoryList = new ArrayList<>();//added by govind 09-01-2017
		//List<MasSession> masSessionList= new ArrayList<>();

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();
		
		try {

			departmentList=session.createCriteria(MasInstituteDepartment.class)					
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "depType")
					.add(Restrictions.eq("depType.DepartmentTypeName","OP Clinic").ignoreCase())//modified by govind 09-01-2017
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			//Commented by Arbind on 14-12-2017
			/*masSessionList=session.createCriteria(MasSession.class)
					.add(Restrictions.eq("Hospital.Id",hospitalId))//modified by govind 09-01-2017
					   .add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
			employeeByCategoryList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "EmpCategory")
					.add(Restrictions.eq("EmpCategory.EmpCategoryName","Doctor").ignoreCase())
					.add(Restrictions.eq("Status","y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id",hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("EmployeeName")))
					.addOrder(Order.asc("EmployeeName"))
					.list();*/
			
			unitExisted = session.createCriteria(HospitalDoctorUnitM.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			
			//map.put("employeeByCategoryList", employeeByCategoryList);
			map.put("departmentList", departmentList);
			//map.put("masSessionList", masSessionList);
			map.put("unitExisted", unitExisted);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	@Override
	public Map<String, Object> populatePersonalReviewAppointmentData(int departmentId,
			int hospitalId, int reviewInterval,Date appointmentDate,String preference,int empId) {
		
		Session session = null;
		int sessionId = 0;
		Map<String, Object> personalReviewAppointmentDataMap = new LinkedHashMap<>();
		List<String> sessionForDepartment = getSessionForDepartment(departmentId, hospitalId);
		List<String> appSetupDaysList = null;
		
		//Date appointmentDate = null;
		
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
			session = (Session) getSession();
			if (sessionForDepartment != null && sessionForDepartment.size() > 0) {
				sessionId = Integer.parseInt(sessionForDepartment.get(0).substring(0,sessionForDepartment.get(0).indexOf(":")));
				personalReviewAppointmentDataMap.put("opSession", sessionId);
			}
			
			if(preference==null){
				reviewInterval = Integer.parseInt(HMSUtil.getPropertyValue("adt.properties", "personalReviewInterval"));
			}
				
			if(preference==null || preference.equalsIgnoreCase("reviewInterval")){
				appointmentDate = HMSUtil.addDaysToDate(new Date(), reviewInterval);
				String dow = dateFormat.format(appointmentDate);
				Criteria crt = session.createCriteria(AppSetup.class)
						.createAlias("Hospital", "hosp")
						.createAlias("Dept", "dept")
						.setProjection(Projections.property("Days"))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("dept.Id", departmentId))
						.add(Restrictions.eq("Session.Id", sessionId))
						.add(Restrictions.isNotNull("TotalInterval"))
						.add(Restrictions.isNotNull("StartToken"))
						.add(Restrictions.isNotNull("TotalToken"));
				appSetupDaysList = crt.list();
				
				if (appSetupDaysList.size() > 0) {
					for (int i = 0; i < 7; i++) {
						if (!appSetupDaysList.contains(dow) ) {
							appointmentDate = HMSUtil.addDaysToDate(appointmentDate, 1);
							dow = dateFormat.format(appointmentDate);
						}else{
							List<HospitalDoctorUnitM> doctorUnits =	getDoctorUnit(departmentId,hospitalId,HMSUtil.getDateFormat(appointmentDate, "dd/MM/yyyy"));
							if(doctorUnits.size()>0){
								break;
							}else{
								appointmentDate = HMSUtil.addDaysToDate(appointmentDate, 1);
							}
						}
					}
				}
			}
			
			if(appointmentDate!=null){
				String dayOfAppointment = dateFormat.format(appointmentDate);
				Criteria crt = session.createCriteria(AppSetup.class)
						.createAlias("Hospital", "hosp")
						.createAlias("Dept", "dept")
						.setProjection(Projections.projectionList().add(Projections.property("MinNoOfDays"))
						.add(Projections.property("MaxNoOfDays")))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("dept.Id", departmentId))
						.add(Restrictions.eq("Session.Id", sessionId))
						.add(Restrictions.eq("Days", dayOfAppointment));
						
				List<Object[]> appSetupList = crt.list();
				if(appSetupList.size()>0){
					int minday = (Integer)appSetupList.get(0)[0];
					int maxday = (Integer)appSetupList.get(0)[1];
					personalReviewAppointmentDataMap.put("minday", minday);
					personalReviewAppointmentDataMap.put("maxday", maxday);
				}
				
				personalReviewAppointmentDataMap.put("appointmentDate",
						appointmentDate);
				personalReviewAppointmentDataMap.put("reviewInterval",
						reviewInterval);

				Map<String, Map<String, Object>> tokenCounterTimeSlotMap = createCounterTimingSlotData(
						departmentId, hospitalId, appointmentDate);
				List<String> unitDays = getDoctorUnitDays(
						departmentId, hospitalId, empId);
				personalReviewAppointmentDataMap.put("tokenCounterTimeSlotMap",
						tokenCounterTimeSlotMap);
				personalReviewAppointmentDataMap.put("unitDays",
						unitDays);
				personalReviewAppointmentDataMap.put("appSetupDaysList",
						appSetupDaysList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personalReviewAppointmentDataMap;
	}

	private Map<String, Map<String, Object>> createCounterTimingSlotData(
			int departmentId, int hospitalId, Date appointmentDate) {
		Map<String,Object> map = getCounterTimingForDepartment(
				departmentId, hospitalId);
		Map<String,Map<String, Object>> timingSlotMap = new LinkedHashMap<String,Map<String, Object>>();
		if(map.get("openTime")!=null && !"".equals(map.get("openTime")) && map.get("closeTime")!=null && !"".equals(map.get("closeTime"))){
			String openTime = (String)map.get("openTime");
			String closeTime = (String)map.get("closeTime");
			String[] open= openTime.split(":"); 
			String[] close = closeTime.split(":");
			int startHour = Integer.parseInt(open[0]);
			String startMinutes = open[1];
			for(int i=0;i<(Integer.parseInt(close[0])-Integer.parseInt(open[0]));i++){
				
				String timeSlot = HMSUtil.convertTimeSlotRangeTo12HourFormat((startHour+i)+":"+startMinutes);
				String visitTime =	(startHour+i)+":"+startMinutes;
				Map<String, Object> priorityQueueByDepartId = getPriorityQueueByDepartId(departmentId, hospitalId, appointmentDate, visitTime, visitTime);
				timingSlotMap.put(timeSlot, priorityQueueByDepartId);
			}
		}
		
		return timingSlotMap;
	}

	public List<String> getDoctorUnitDays(int departmentId, int hospitalId, int empId ){
		List<String> unitAvailbleDays = new ArrayList<String>();
		
		try {
		Session session = (Session) getSession();
		List<MasDepartment> masDepartmentList  = session.createCriteria(MasInstituteDepartment.class)
		.setProjection(Projections.property("Department"))
		.add(Restrictions.eq("Institute.Id",hospitalId))
		.add(Restrictions.eq("Status","y").ignoreCase())
		.createAlias("Department", "dep")
		.add(Restrictions.eq("dep.Id",departmentId)).list();
		
		ArrayList<Integer> empDepartmentId=new ArrayList<Integer>();
		for(MasDepartment department:masDepartmentList){
			if(null !=department && null !=department.getEmpDept())
				if(null !=department.getEmpDept())
			empDepartmentId.add(department.getEmpDept().getId());
			
		}
		
		if(empDepartmentId.size()>0){
			List<HospitalDoctorUnitM> unitList=session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM","unitM")
			 .createAlias("unitM.Hospital", "Hospital").createAlias("unitM.EmpDept", "EmpDept")
			 .createAlias("Employee", "employee")
			 .add(Restrictions.eq("unitM.Hospital.Id", hospitalId))
			 .add(Restrictions.in("EmpDept.Id", empDepartmentId))
			 .add(Restrictions.eq("employee.Id", empId))
			 .add(Restrictions.eq("Status", "y").ignoreCase())
			 .add(Restrictions.eq("unitM.Status", "y").ignoreCase())
			 .setProjection(Projections.projectionList()
			 .add(Projections.property("UnitM"))).list();
			
			if(unitList.size()>0) {
				HospitalDoctorUnitM unitM=unitList.get(0);
				if(unitM.getMonday()!=null && unitM.getMonday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Monday");
				}
				if(unitM.getTuesday()!=null && unitM.getTuesday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Tuesday");
				}
				if(unitM.getWednesday()!=null && unitM.getWednesday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Wednesday");
				}
				if(unitM.getThursday()!=null && unitM.getThursday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Thursday");
				}
				if(unitM.getFriday()!=null && unitM.getFriday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Friday");
				}
				if(unitM.getSaturday()!=null && unitM.getSaturday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Saturday");
				}
				if(unitM.getSunday()!=null && unitM.getSunday().equalsIgnoreCase("y")) {
					unitAvailbleDays.add("Sunday");
				}
			}
		}
		
		}catch (Exception e) {
			logger.error(e);
		}
		
		return unitAvailbleDays;
	}
	
	public Map<String, Object> getCounterTimingForDepartment(int department,
			int hospital) {
		List<HospitalDoctorUnitM> unitList = new ArrayList<HospitalDoctorUnitM>();
		List<MasInstituteDepartment> masDepartmentList = new ArrayList<MasInstituteDepartment>();
		Map<String, Object> map = new HashMap();
		Session session = (Session) getSession();

		String openTime = null;
		String closeTime = null;
		try {
			masDepartmentList = session
					.createCriteria(MasInstituteDepartment.class)
					.add(Restrictions.eq("Institute.Id", hospital))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.Id", department)).list();
			if (masDepartmentList.size() > 0) {
				openTime = masDepartmentList.get(0).getOpeningTime();
				closeTime = masDepartmentList.get(0).getClosingTime();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("closeTime", closeTime);
		map.put("openTime", openTime);
		return map;
	}
	
	public Map<String, Object> getPriorityQueueByDepartId(int departmentId,
			int hospitalId, Date appointmentDate, String appointmentTime,
			String visitTime) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Integer> tokenList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		Criteria criteria = null;
		String queueNo = null;
		
		if (appointmentDate!=null && StringUtils.isNotBlank(visitTime)) {
			int visitHour = Integer.parseInt(visitTime.split(":")[0]);
		
			criteria = session.createCriteria(AppPatientAppointments.class)
					.createAlias("Hospital", "hosp")
					.createAlias("Department", "dept")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dept.Id", departmentId))
					.setProjection(Projections.property("QueuePriority"))
					.add(Restrictions.eq("AppointmentDate", appointmentDate));
			List<Integer> queueList = criteria.list();

			SimpleDateFormat formatter = new SimpleDateFormat("EEEE");
			String dayName = formatter.format(appointmentDate);

			criteria = session.createCriteria(AppSetup.class)
					.createAlias("Hospital", "hosp")
					.createAlias("Dept", "dept")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dept.Id", departmentId))
					.add(Restrictions.isNotNull("TotalInterval"))
					.add(Restrictions.isNotNull("StartToken"))
					.add(Restrictions.isNotNull("TotalToken"))
					.add(Restrictions.eq("Days", dayName));

			List<AppSetup> aapSetupList = criteria.list();

			int lastTokenNo = 0;
			int tokenFrequency = 0;
			int startTokenNo = 0;
			int avgNoOfPatientsPerHour = 0;

			if (aapSetupList.size() > 0) {
				AppSetup appSetup = aapSetupList.get(0);
				lastTokenNo = appSetup.getTotalToken();
				tokenFrequency = appSetup.getTotalInterval();
				startTokenNo = appSetup.getStartToken();

				criteria = session.createCriteria(MasInstituteDepartment.class)
						.createAlias("Institute", "hosp")
						.createAlias("Department", "dept");
				criteria.add(Restrictions.eq("hosp.Id", hospitalId));
				criteria.add(Restrictions.eq("dept.Id", departmentId));
				criteria.add(Restrictions.eq("Status", "y").ignoreCase())
						.uniqueResult();

				List<MasInstituteDepartment> instituteList = criteria.list();
				if (instituteList.size() > 0) {
					MasInstituteDepartment masInstituteDepartment = instituteList
							.get(0);
					if (StringUtils.isNotBlank(masInstituteDepartment
							.getOpeningTime())) {
						int openTimeHour = Integer
								.parseInt(masInstituteDepartment
										.getOpeningTime().split(":")[0]);

						if (masInstituteDepartment.getAvgNoOfPatients() != null
								&& masInstituteDepartment.getAvgNoOfPatients() != 0) {
							avgNoOfPatientsPerHour = masInstituteDepartment
									.getAvgNoOfPatients();
							
							List<Integer> allValidTokens = new ArrayList<Integer>();
							
							for(int i=startTokenNo;i<=lastTokenNo;i=i+tokenFrequency){
								allValidTokens.add(i);
							}
							
 							int timeSlotNo = visitHour - openTimeHour;
							int tokenStartNoForSelectedTimeSlot = (avgNoOfPatientsPerHour * timeSlotNo) + 1;

							for(int i=tokenStartNoForSelectedTimeSlot;i<tokenStartNoForSelectedTimeSlot
									+ avgNoOfPatientsPerHour;i++){
								if(allValidTokens.contains(i) && !queueList.contains(i)){
									tokenList.add(i);
								}
							}
							
						}
					}
				}
			}
		}
		resultMap.put("tokenList", tokenList);
		return resultMap;

	}
	
	@Override
	public Map<String, Object> populateRegistrationBill(int deptId) {
		logger.debug("Inside Method: populateRegistrationBill");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		int regChargeId = 0;
		int chargeId = 0;
		int mainChargeId = 0;
		int subChargeId = 0;

		try {
			List<MasSetupParameterMaintaince> systemParametersList = session
					.createCriteria(MasSetupParameterMaintaince.class)
					.addOrder(Order.asc("Id")).setFirstResult(0)
					.setMaxResults(1).list();
			if (systemParametersList != null && systemParametersList.size() > 0) {
				if (systemParametersList.get(0).getRegChargeCode() != null) {
					regChargeId = systemParametersList.get(0)
							.getRegChargeCode().getId();
				}
			}

			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Id", regChargeId))
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.createAlias("ChargeType", "mct")
					.add(Restrictions.eq("mct.Id", 6))
					.addOrder(Order.asc("Id")).list();

			for (MasChargeCode chargeCode : chargeCodeList) {
				chargeId = chargeCode.getId();
				mainChargeId = chargeCode.getMainChargecode().getId();
				subChargeId = chargeCode.getSubChargecode().getId();
			}

			authorizerList = session.createCriteria(MasAuthorizer.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.addOrder(Order.asc("AuthorizerName")).list();

			map.put("chargeId", chargeId);
			map.put("mainChargeId", mainChargeId);
			map.put("subChargeId", subChargeId);
			map.put("regChargeId", regChargeId);
			map.put("chargeCodeList", chargeCodeList);
			map.put("authorizerList", authorizerList);

			systemParametersList.clear();
			systemParametersList = null;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> populateRegistrationCount() {
		logger.debug("Inside Method: populateRegistrationCount");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();

		try {
			List<Patient> newRegistartion = new ArrayList<>();
			newRegistartion = session.createCriteria(Patient.class)
					.setProjection(Projections.count("Id"))
					.add(Restrictions.eq("RegDate", new Date())).list();
			map.put("newRegistartion", newRegistartion);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getItemId(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> populsubDistrictByDistrictId(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populsubDistrictByDistrictId");
		Map<String, Object> map = new HashMap<>();
		try {

			int districtId = (Integer) dataMap.get("districtId");
			
			List<Object[]> talukList = new ArrayList<>();
			Session session = (Session) getSession();
			talukList =  session.createCriteria(MasTaluk.class)
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id", districtId)).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TalukName")))
					.addOrder(Order.asc("TalukName")).list();
			
			map.put("talukList", talukList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> populateDistByState(Map<String, Object> dataMap) {
		logger.debug("Inside Method: populateDistByState");
		Map<String, Object> map = new HashMap<>();
		try {

			int stateId = (Integer) dataMap.get("stateId");

			List<MasDistrict> districtList = new ArrayList<>();
			Session session = (Session) getSession();
			districtList = (List<MasDistrict>) session
					.createCriteria(MasDistrict.class)
					.createAlias("State", "state")
					.add(Restrictions.eq("state.Id", stateId))
					.addOrder(Order.asc("DistrictName")).list();

			logger.debug("districtList " + districtList.size());
			map.put("districtList", districtList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> populateChargeableAmount(Map<String, Object> map) {
		logger.debug("Inside Method: populateChargeableAmount");
		int chargeId = (Integer) map.get("chargeId");

		Session session = (Session) getSession();
		List<MasChargeCode> masChargeCode = new ArrayList<>();
		masChargeCode = (List<MasChargeCode>) session
				.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Id", chargeId)).list();

		map.put("masChargeCode", masChargeCode);

		return map;

	}


	private synchronized String generateTemporaryRegNum(String HinNo, String hospitalCode) {
		logger.debug("Inside Method: generateTemporaryRegNum");
		String temUHid = "";

		Calendar currentDate = Calendar.getInstance(); // Get the current date
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy"); 
		String dateNow = formatter.format(currentDate.getTime());
		
		temUHid = "T" + hospitalCode + dateNow + HinNo;
		
		logger.debug("temUHid " + temUHid);
		return temUHid;

	}

	@Override
	public Map<String, Object> uhidConversion(Box box) {
		logger.debug("Inside Method: uhidConversion");
		boolean saveStatus = false;
		Map<String, Object> map = new HashMap<>();
		Patient patient = new Patient();
		String aadharNo = "";
		String temUhid = "";

		aadharNo = box.get("aadharNumber");
		temUhid = box.get("tempUhid");
		Session session = (Session) getSession();
		Transaction tnx = null;
		Criteria crt = null;
		try {
			tnx = session.beginTransaction();
			crt = session.createCriteria(Patient.class).add(Restrictions.like("HinNo", temUhid + "%", MatchMode.EXACT));
			patient = (Patient) crt.list().get(0);
			if (null != patient) {
				patient.setHinNo(aadharNo);
				patient.setAadhaarNo(Long.parseLong(aadharNo));
				session.saveOrUpdate(patient);
			}
			session.flush();
			tnx.commit();
			saveStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			tnx.rollback();
		}
		map.put("saveStatus", saveStatus);

		return map;
	}

	@Override
	public Map<String, Object> saveOnlineAppointment(Box box) {
		logger.debug("Inside Method: saveOnlineAppointment");
		Map<String, Object> map = new HashMap<>();
		Visit visit = new Visit();
		Patient patient = new Patient();
		List<Patient> patientList = new ArrayList<>();
		Session session = (Session) getSession();

		String Uhid = "";
		String appointmentdate = "";
		int departmentId = 0;
		int dutyDocId = 0;
		int hospitalId = 0;
		int tokenNo = 0;
		int hinId = 0;

		Uhid = box.get("uhid");
		appointmentdate = box.get("appointmentDate");
		departmentId = box.getInt("department");
		tokenNo = box.getInt("tokenNo");
		hospitalId = box.getInt("hospitalId");
		dutyDocId = box.getInt("loddrs");

		patientList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", Uhid)).list();
		for (Patient pat : patientList) {

			hinId = pat.getId();
			patient.setId(hinId);
			visit.setHin(patient);
		}
		if (departmentId > 0) {
			MasDepartment department = new MasDepartment();
			department.setId(departmentId);
			visit.setDepartment(department);
		}

		if (dutyDocId > 0) {

			MasEmployee employee = new MasEmployee();
			employee.setId(dutyDocId);
			visit.setDoctor(employee);
		}
		if (appointmentdate != null && !appointmentdate.equals("")) {
			Date appointmentDate = HMSUtil
					.convertStringTypeDateToDateType(appointmentdate);
			visit.setVisitDate(appointmentDate);

		}
		if (hospitalId > 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			visit.setHospital(masHospital);
		}
		visit.setTokenNo(tokenNo);
		visit.setVisitStatus("W");

		if (box.get("currentDate") != null
				&& !box.get("currentDate").equals("")) {
			Date addEditDate = HMSUtil.convertStringTypeDateToDateType(box
					.get("currentDate"));
			visit.setAddEditDate(addEditDate);
		}
		if (box.get("currentTime") != null
				&& !box.get("currentTime").equals("")) {
			String addEditTime = box.get("currentTime");
			logger.debug("addEditTime " + addEditTime);
			visit.setAddEditTime(addEditTime);
			visit.setVisitTime(addEditTime);
		}
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(visit);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return map;
	}

	/**
	 * @param hospitalId
	 * @param deptId
	 */
	public boolean getDepartmentByHospitalId(int hospitalId, int deptId) {
		logger.debug("Inside Method: getDepartmentByHospitalId");
		MasDepartment department = new MasDepartment();

		Session session = (Session) getSession();
		Criteria crt=null;
		boolean Status=false;
		try {
			crt =  session
					.createCriteria(MasDepartment.class)
					.createAlias("Hospital", "hospitalId")
					.add(Restrictions.eq("hospitalId.Id", hospitalId))
					.add(Restrictions.eq("Id", deptId))
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("DepartmentName"));
            if(null !=crt.list() && crt.list().size()>0 ){
            	department=(MasDepartment) crt.list().get(0);
            	QueueManagement.getDepartmentByHospital(department, hospitalId);
            	Status=true;
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Status;

	}

	@Override
	public Map<String, Object> searchPatientForUpdateRegistration(String uhidNo) {
		logger.debug("Inside Method: searchPatientForUpdateRegistration");

		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		Criteria crt = null;
		int hinId = 0;

		Patient patientDetail = new Patient();
		PatientAddress aadharAddress = new PatientAddress();
		PatientAddress permanentAddress = new PatientAddress();
		PatientAddress TemporaryAddress = new PatientAddress();

		crt = session.createCriteria(Patient.class).add(
				Restrictions.eq("HinNo", uhidNo));

		patientDetail = (Patient) crt.list().get(0);

		hinId = patientDetail.getId();
		if (hinId > 0) {

			crt = session.createCriteria(PatientAddress.class)
					.createAlias("Hin", "hin")
					.createAlias("AddressType", "ADID")
					.add(Restrictions.eq("hin.Id", hinId))
					.add(Restrictions.eq("ADID.Id", 2));
			if (null != crt.list() && crt.list().size() > 0)
				aadharAddress = (PatientAddress) crt.list().get(0);
		}
		if (hinId > 0) {

			crt = session.createCriteria(PatientAddress.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.Id", hinId))
					.createAlias("AddressType", "ADID")
					.add(Restrictions.eq("ADID.Id", 1));
			if (null != crt.list() && crt.list().size() > 0) {
				permanentAddress = (PatientAddress) crt.list().get(0);
			}
		}
		if (hinId > 0) {

			crt = session.createCriteria(PatientAddress.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.Id", hinId))
					.createAlias("AddressType", "ADID")
					.add(Restrictions.eq("ADID.Id", 4));
			if (null != crt.list() && crt.list().size() > 0) {
				TemporaryAddress = (PatientAddress) crt.list().get(0);
			}
		}
		map.put("patientDetail", patientDetail);
		map.put("aadharAddress", aadharAddress);
		map.put("permanentAddress", permanentAddress);
		map.put("TemporaryAddress", TemporaryAddress);
		return map;

	}

	@Override
	public Map<String, Object> populatePostOfficeByVillage(Map<String, Object> map) {
		logger.debug("Inside Method: populatePostOfficeByVillage");

		int villageId = 0;

		List<MasPostCode> postofficeList = new ArrayList<>();

		Session session = (Session) getSession();
		if (null != map.get("villageId") && !map.get("villageId").equals("")) {
			villageId = (Integer) map.get("villageId");
		}
		Criteria crt = null;

		crt = session.createCriteria(MasPostCode.class)
				.createAlias("Village", "vId")
				.add(Restrictions.eq("vId.Id", villageId));
		postofficeList = crt.list();
		map.put("postofficeList", postofficeList);

		return map;
	}

	@Override
	public Map<String, Object> populateVillageTown(Map<String, Object> map) {

		logger.debug("Inside Method: populateVillageTown");

		int districtId = 0;

		List<MasVillage> villageList = new ArrayList<>();

		Session session = (Session) getSession();
		if (null != map.get("districtId") && !map.get("districtId").equals("")) {
			districtId = (Integer) map.get("districtId");
		}
		Criteria crt = null;


		crt = session.createCriteria(MasVillage.class)
				.createAlias("District", "dId")
				.add(Restrictions.eq("dId.Id", districtId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("VillageName"));
				
		villageList = crt.list();

		map.put("villageList", villageList);

		return map;
	}
	
	@Override
	public Map<String, Object> getPatientList(String hinNo) {
		logger.debug("Inside Method: getPatientList");

		Map<String, Object> map = new HashMap<>();
		List<UploadDocuments> uploadDocumentList = new ArrayList<>();
		List<Patient> patientList = new ArrayList<>();
		List<PatientAddress> patientAddressList = new ArrayList<>();

		Session session = (Session) getSession();
		Criteria crt = null;
		int patientHindId = 0;
		boolean Status=true;

		crt = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
		
		patientList = crt.list();

		if (null != patientList) {
			for (Patient patient : patientList) {
				patientHindId = patient.getId();

			}
			if (patientHindId > 0) {
				crt = session.createCriteria(UploadDocuments.class)
						.createAlias("Hin", "hin");
				crt.add(Restrictions.eq("hin.Id", patientHindId));
				uploadDocumentList = crt.list();

				crt = session.createCriteria(PatientAddress.class)
						.createAlias("Hin", "hin")
						.createAlias("AddressType", "type");
				crt.add(Restrictions.eq("type.Id", 1));
				crt.add(Restrictions.eq("hin.Id", patientHindId));
				
				patientAddressList = crt.list();
				if(null != patientAddressList && patientAddressList.size()>0){
					for(PatientAddress address:patientAddressList){
						if(null != address.getDistrict() && null !=address.getTaluk()){
							Status=false;
							break;
						}
					}
				}
				if(Status){
					crt = session.createCriteria(UploadDocuments.class)
							.createAlias("Hin", "hin");
					crt.add(Restrictions.eq("hin.Id", patientHindId));
					uploadDocumentList = crt.list();

					crt = session.createCriteria(PatientAddress.class)
							.createAlias("Hin", "hin")
							.createAlias("AddressType", "type");
					crt.add(Restrictions.eq("type.Id", 2));
					crt.add(Restrictions.eq("hin.Id", patientHindId));
					
					patientAddressList = crt.list();
				}

			}
		}
		map.put("patientAddressList", patientAddressList);
		map.put("uploadDocumentList", uploadDocumentList);

		return map;
	}

	@Override
	public synchronized int getTokenNumber(int hospitalId, int departmentId, Date vdate, int pHinId) {
		logger.debug("Inside Method: getTokenNumber");
		int tokenNo = 0;
		List<Integer> token = new ArrayList<>();
		Session session = (Session) getSession();
		String query = "select v.TokenNo from Visit v where v.Hin.Id=:hinId and v.Department.Id=:dId "
				+ "and v.Hospital.Id=:hId and v.VisitDate=:date ORDER BY v.TokenNo DESC limit 1";
		Query q = session.createQuery(query);

		q.setParameter("hinId", pHinId);
		q.setParameter("dId", departmentId);
		q.setParameter("hId", hospitalId);
		q.setParameter("date", vdate);

		token = q.list();
		if (null != token.get(0)) {
			tokenNo = token.get(0);

		}

		return tokenNo;
	}

	@Override
	public synchronized Map<String,Object> getTotalVistByHospital(int hospitalId, int departmentId, Date vdate,
			int pHinId,int opsessionId,String hospitalCode) {

		logger.debug("Inside Method: getTotalVistByHospital");
		String opSerialNo="hospital_code_"+hospitalCode+"_seq";
		logger.debug("opSerialNo"+ opSerialNo);
		Map<String,Object> map= new HashMap<>();
		
		boolean ispreviouesToken=false;
		long TotaltokenNo = 0L;
		List<Integer> token = null;
		String schName = "public"; // added by amit das on 08-05-2017
		Session session = (Session) getSession();
		
		
		String query = "select v.TotalHospitalVisit from Visit  v where  v.Hospital.Id=:hospitalId and v.VisitDate=:date and v.Hin.Id=:hin  ";

		Query qur = session.createQuery(query);
		qur.setParameter("hin", pHinId);
		qur.setParameter("hospitalId", hospitalId);
		qur.setParameter("date", vdate);
		//qur.setParameter("opsessionId", opsessionId);
		token = qur.list();
		if (null !=token && token.size()>0 && null !=token.get(0)) {
			TotaltokenNo = token.get(0);
			ispreviouesToken=true;
		}
		else{
		
		
		query = "SELECT COUNT(*) FROM information_schema.sequences WHERE sequence_schema='" + schName + "' AND sequence_name='" + opSerialNo + "'";
		
		Query q = session.createSQLQuery(query);

        BigInteger i = (BigInteger) q.list().get(0);
        
        if(i.intValue() == 1){
			 Iterator<BigInteger> iter;
			iter = Collections.<BigInteger>emptyList().iterator();
			String qury = "SELECT nextval('"+opSerialNo+"')" ;

		q = session.createSQLQuery(qury);

		iter = (Iterator<BigInteger>) q.list().iterator();
		TotaltokenNo = iter.next().longValue();
		
		logger.debug("opserialNo TotaltokenNo TotaltokenNo "+ TotaltokenNo);
		} else {
		query = "select max(v.TotalHospitalVisit) from Visit v where  v.Hospital.Id = :hospitalId and v.VisitDate = :date  ";
		//String query = "select v.TotalHospitalVisit from Visit  v where  v.Hospital.Id=:hId and v.VisitDate=:date and v.Hin.Id=:hin and v.VisitSession.Id=:opsessionId";
		//String query = "select max(v.TotalHospitalVisit) from Visit  v where  v.Hospital.Id=:hId and v.VisitDate=:date ";
		q = session.createQuery(query);
		q.setParameter("hospitalId", hospitalId);
		q.setParameter("date", vdate);
		token = q.list();
		if (null !=token && token.size()>0 && null !=token.get(0))
			TotaltokenNo = token.get(0);
		
		
			 TotaltokenNo = TotaltokenNo+1;
		 }
          ispreviouesToken=false;
		}
		
		map.put("TotaltokenNo", (int)TotaltokenNo);
		map.put("ispreviouesToken", ispreviouesToken);
		return map;
	}

	@Override
	public Map<String, Object> searchUnservicedPatient(Box box) {

		logger.debug("Inside Method: searchUnservicedPatient");

		Map<String, Object> map = new HashMap<>();
		List<Visit> visitList = new ArrayList<>();
		int hospitalId = 0;
		//int patientHinId = 0;
		String uHidNo = "";
		hospitalId = box.getInt(RequestConstants.HOSPITAL_ID);
		if (box.get("uhid") != null) {
			uHidNo = box.get("uhid").trim();
		}

		Session session = (Session) getSession();
		Criteria crt = null;

		crt = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", uHidNo));

		if (uHidNo!=null) {
			crt = session
					.createCriteria(Visit.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.or(
							Restrictions.eq("CurPharVisitStatus", "y")
									.ignoreCase(),
							Restrictions.eq("CurPharVisitStatus", "n")
									.ignoreCase()))
					.add(Restrictions.ne("VisitStatus", "w").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.ne("VisitDate",
							HMSUtil.getCurrentDateAndTimeObject()))
					.add(Restrictions.eq("hin.HinNo", uHidNo))
					.addOrder(Order.desc("Id"));
			visitList = crt.list();
		} 
		List<Visit> finalList = new ArrayList<>();
		for(Visit visit:visitList){
			if(visit.getPatientPrescriptionHeaders().size()>0){
				int maxQuantitiToBeIssued = 0;
				List<PatientPrescriptionHeader> prescriptionHeaders=
						new ArrayList<>(visit.getPatientPrescriptionHeaders());
				for(PatientPrescriptionHeader pHeader:prescriptionHeaders){
					if(pHeader.getPatientPrescriptionDetails().size()>0){ 
						List<PatientPrescriptionDetails> prescriptionDetails
							= new ArrayList<>(pHeader.getPatientPrescriptionDetails());
						for(PatientPrescriptionDetails pDetails:prescriptionDetails){

							Date dispensingDate = new Date();
							int noOfDays = 0;
							String frequency = "0";
							float totalQty=0f;
							float totalIssueQty=0f;

							if (pDetails.getPrescription().getDispencingDate() != null) {
								dispensingDate = pDetails.getPrescription()
										.getDispencingDate(); 
							}
							if (pDetails.getNoOfDays() != null) {
								noOfDays = pDetails.getNoOfDays();
							}
							if (pDetails.getFrequency() != null) {
								frequency = pDetails.getFrequency()
										.getFrequencyCode(); 
							}
							if(pDetails.getTotal()!=null){
								totalQty=pDetails.getTotal();
							}
							if(pDetails.getTotalStoreIssuedQty()!=null){
								totalIssueQty=pDetails.getTotalStoreIssuedQty();
							}
							if(pDetails.getTotalStoreIssuedQty() !=null){
							}

							if(totalQty>totalIssueQty){
								Calendar with = Calendar.getInstance();
								with.setTime(HMSUtil.getCurrentDateAndTimeObject());

								with.set(Calendar.YEAR, with.get(Calendar.YEAR));

								Calendar to = Calendar.getInstance();
								to.setTime(dispensingDate);
								to.set(Calendar.YEAR, with.get(Calendar.YEAR));

								int withDAY = with.get(Calendar.DAY_OF_YEAR);
								int toDAY = to.get(Calendar.DAY_OF_YEAR);

								int diffDay =withDAY -  toDAY ;  
								int priviousQt=(int)totalIssueQty-(diffDay * Integer.parseInt(frequency));
								if(priviousQt<0){
									priviousQt=0;
								}
								logger.debug("noOfDays--" + noOfDays + "diffDay--"
										+ diffDay + "frequency--" + frequency);
								maxQuantitiToBeIssued =(noOfDays- diffDay)
										* (Integer.parseInt(frequency));
							}
							
							if (maxQuantitiToBeIssued > 0) {
								break;
							} 
						}
						if(maxQuantitiToBeIssued>0){
							break;
						}
						
					}
				}
				if(maxQuantitiToBeIssued>0){
					finalList.add(visit);
				} 
			}
		}
		map.put("visitList", finalList);
		return map;
	}

	@Override
	public Map<String, Object> submitUnservicedPatient(Box box) {
		logger.debug("Inside Method: submitUnservicedPatient");
		Map<String, Object> map = new HashMap<>();
		List<PatientPrescriptionHeader> presciptionHeaderList = new ArrayList<>();
		Date currentDate = new Date();
		int visitId = 0;

		visitId = box.getInt("lastVisitId");

		Session session = (Session) getSession();
		Criteria crt = null;
		Visit visit = (Visit) session.load(Visit.class, visitId);
		if (visit != null) {
			visitId = visit.getId();
			visit.setUnservicesedPharVisitStatus("y");
			crt = session.createCriteria(PatientPrescriptionHeader.class)
					.createAlias("Visit", "v");
			crt.add(Restrictions.eq("v.Id", visitId));
			presciptionHeaderList = crt.list();
			PatientPrescriptionHeader prescriptionHeader = null;
			if (presciptionHeaderList.size() > 0) {
				prescriptionHeader = presciptionHeaderList.get(0);
				prescriptionHeader.setDispencingDate(currentDate);

				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					hbt.update(visit);
					hbt.update(prescriptionHeader);
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}

		return map;
	}

	@Override
	public Map<String, Object> populateUhidConversionPage(int hinId) {

		logger.debug("Inside Method: populateUhidConversionPage");

		Map<String, Object> map = new HashMap<>();
		List<Patient> patientList = new ArrayList<>();
		List<Visit> visitList = new ArrayList<>();

		Session session = (Session) getSession();
		Criteria crt = null;

		crt = session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId));
		patientList = crt.list();

		crt = session.createCriteria(Visit.class).createAlias("Hin", "hin");
		crt.add(Restrictions.eq("hin.Id", hinId));
		visitList = crt.list();

		map.put("patientList", patientList);
		map.put("visitList", visitList);

		return map;
	}

	@Override
	public Map<String, Object> populatePatientOnAadharNo(String aadharNo) {

		logger.debug("Inside Method: populatePatientOnAadharNo");
		Map<String, Object> map = new HashMap<>();

		Session session = (Session) getSession();
		Criteria crt = null;

		List<PhMemberSurvey> memberServeyList = new ArrayList<>();

		crt = session.createCriteria(PhMemberSurvey.class);
		crt.add(Restrictions.eq("AadhaarNo", aadharNo));

		if (crt.list() != null)
			memberServeyList = crt.list();

		map.put("memberServeyList", memberServeyList);

		return map;
	}

	@Override
	public int getDistrictIdByHospital(int hospitalId) {

		logger.debug("Inside Method: getDistrictIdByHospital");

		List<MasHospital> hospitalList = new ArrayList<>();
		Session session = (Session) getSession();
		Criteria crt = null;
		int districtId = 0;
		crt = session.createCriteria(MasHospital.class).add(
				Restrictions.eq("Id", hospitalId));
		hospitalList = crt.list();
		for (MasHospital hosp : hospitalList) {
			districtId = hosp.getDistrict().getId();
		}
		return districtId;
	}

	@Override
	public Map<String, Object> getOneTimePassword(String mobileNumber, String opt) {

		logger.debug("Inside Method: getOneTimePassword");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean status=false;
		List<MobileRegistration> mobileRegistrationlist = null;
		logger.debug("opt  %%%%%%%%%%%%%%%@##$$$$$$$"+opt);
		logger.debug("mobileNumber  %%%%%%%%%%%%%%%@##$$$$$$$"+mobileNumber);
		if(opt !=null && !opt.equalsIgnoreCase("")){
		mobileRegistrationlist=session.createCriteria(MobileRegistration.class)
				.add(Restrictions.eq("VerifiedStatus", "n"))
				.add(Restrictions.eq("MobileNo", mobileNumber))
				.add(Restrictions.eq("Otp", Integer.parseInt(opt))).list();
		if(null !=mobileRegistrationlist && mobileRegistrationlist.size()>0){
			status=true;
			MobileRegistration mobileRegistration=mobileRegistrationlist.get(0);
			mobileRegistration.setVerifiedStatus("y");
			session.update(mobileRegistration);
			session.flush();
			
		}
		}
		logger.debug("opt  %%%%%%%%%%%%%%%@##$$$$$$$"+status);

		map.put("status", status);
		return map;
	}

	/**
	 * Method for generating one time password
	 * 
	 * @return
	 */
	

	@Override
	public boolean checkDuplicateRegistraiton(Map<String, Object> regDataMap) {

		logger.debug("Inside Method: checkDuplicateRegistraiton");

		Session session = (Session) getSession();
		List<Patient> patient = new ArrayList<>();

		long aadharNumber = 0;
		int otherId = 0;
		String otherIdNumber = "";

		if (null != regDataMap.get("otherId")) {
			otherId = (Integer) regDataMap.get("otherId");
		}

		if (null != regDataMap.get("otherIdNum")) {
			otherIdNumber = (String) regDataMap.get("otherIdNum");
		}

		boolean status = false;
		Criteria crt = null;
		crt = session.createCriteria(Patient.class);

		if (null != otherIdNumber && otherId > 0 && !otherIdNumber.equals("")) {
			crt.createAlias("IdCard", "OtId");
			crt.add(Restrictions.eq("OtId.Id", otherId));
			crt.add(Restrictions.eq("IdNo", otherIdNumber));
			status = true;
		}

		if (null != regDataMap.get("aadhaarNo")) {

			aadharNumber = (Long) regDataMap.get("aadhaarNo");

			if (aadharNumber > 0) {

				crt.add(Restrictions.eq("AadhaarNo", aadharNumber));
			}
			status = true;
		}
		if (status)
			patient = crt.list();

		boolean registerStatus = false;

		if (!patient.isEmpty() && patient.size() > 0) {

			registerStatus = true;

		}

		return registerStatus;
	}

	@Override
	public Map<String, Object> showAppRegistrationList(int hospitalId, int visitSessionId) {
		logger.debug("Inside Method: showAppRegistrationList");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<>();
		Date currentDate = new Date();
		List<AppPatientAppointments> patientAppointList = new ArrayList<>();
		patientAppointList = session
				.createCriteria(AppPatientAppointments.class)
				.createAlias("Hospital", "hosp")
				.createAlias("AppSession", "appSession")
				.add(Restrictions.eq("AppointmentDate", currentDate))
				/* .add(Restrictions.eq("RegisterVisit", "P")) */
				.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase())
				.add(Restrictions.eq("RegisteredStatus", "y").ignoreCase())
				.add(Restrictions.eq("hosp.Id", hospitalId))/*.add(Restrictions.eq("appSession.Id", visitSessionId))*/.list();
		
		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
		nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.ne("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
.list();

		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<Object[]> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();

		List<MasSession> masSessionList = new ArrayList<>();
		

		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
				.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		

		patientTypeList = session.createCriteria(MasPatientType.class)

		.add(Restrictions.eq("Status", "Y")).list();

		complaintList = session.createCriteria(MasComplaint.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		

		doctorList=session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital").
				createAlias("EmployeeType", "EmployeeType").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("EmployeeType.Id", 1)).list();


		caseTypeList = session.createCriteria(MasCaseType.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
				.addOrder(Order.asc("DiagnosisConclusionName"))
				.add(Restrictions.eq("Status", "Y")).list();

		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationName"))
				.add(Restrictions.eq("Status", "Y")).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y")).list();
		
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chargeType")
				.addOrder(Order.asc("ChargeCodeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("chargeType.Id", 9)).list();

		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "Y"))
				.addOrder(Order.asc("AuthorizerName")).list();

		map.put("complaintList", complaintList);
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("relationList", relationList);
		map.put("patientTypeList", patientTypeList);
		map.put("sexList", sexList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("masSessionList", masSessionList);
		map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		
		map.put("patientAppointList", patientAppointList);
		return map;
	}
	@Override
	public Map<String, Object> showSessionList(int hospital) {
		logger.debug("Inside Method: showSessionList");

		Map<String, Object> map = new HashMap<>();

		Session session = (Session) getSession();

		List<MasSession> masSessionList = new ArrayList<>();
		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospital))
				.list();
		map.put("masSessionList", masSessionList);
		return map;
	}

	@Override
	public Map<String, Object> showPatientReferalList(int hospitalId, int deptId) {

		logger.debug("Inside Method: showPatientReferalList");

		Map<String, Object> map = new HashMap<>();
		try{
		Session session = (Session) getSession();
		Date currentDate = new Date(); 
		
		Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 14);
        Date twoWeekLaterDate = cal.getTime();
		
		List<OpdPatientDetails> patientReferalList = new ArrayList<>();
		List<OpdPatientDetails> patientReferalListForInternal = new ArrayList<>();
		List<Object>hospitalReferes= new ArrayList<>();
		
		List<Object[]> phDiseaseRegistrationFollowList = new ArrayList<>();


		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
		nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.ne("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();

		Criteria crtRefer= session.createCriteria(OpdPatientDetails.class)
				.createAlias("ReferredHospital", "hosp")
				.add(Restrictions.le("ReferedDate", twoWeekLaterDate ))
				.add(Restrictions.ge("ReferTillDate", currentDate ))
				.add(Restrictions.eq("ReferedStatus", "y").ignoreCase())
				.add(Restrictions.eq("ReferredType", "External").ignoreCase())
				.add(Restrictions.eq("hosp.Id", hospitalId));
		patientReferalList=crtRefer.list();
		
		patientReferalListForInternal = session.createCriteria(OpdPatientDetails.class)
				.createAlias("ReferredHospital", "hosp")//.createAlias("ReferedDepartment", "reffDept")
				.add(Restrictions.eq("ReferedDate", currentDate ))
				.add(Restrictions.eq("ReferedStatus", "y").ignoreCase())
				.add(Restrictions.eq("ReferredType", "Internal").ignoreCase())//.add(Restrictions.eq("reffDept.Id", deptId))
				.add(Restrictions.eq("hosp.Id", hospitalId)).list();
		
		
		//ph refer case: by rajendra kumar
		String hrfQuery="select phm.uhid_no,phm.name,sex.administrative_sex_name,phm.date_of_birth,hrf.ref_date, "
				+"hos.hospital_name,hrf.ref_reason from hospital_refer as hrf left join ph_member_survey  phm on phm.member_id=hrf.member_id "
				+"left join mas_administrative_sex as  sex on sex.administrative_sex_id=phm.gender left join mas_hospital as  hos on hos.hospital_id=hrf.ref_hospital "
				+"where hrf.ref_reason='cop' and hrf.status='N' and hrf.ref_hospital="+hospitalId;
		hospitalReferes=session.createSQLQuery(hrfQuery).list();
		
		String quryy="select m.name,s.administrative_sex_name,hos.hospital_name,m.uhid_no,prf.follow_date,prf.syndromic_surveillance from ph_disease_registration_follow as prf "
				+ "left join  ph_member_survey as m on m.member_id=cast(prf.member_id as bigint) "
				+ "left join mas_administrative_sex as s on s.administrative_sex_id= m.gender "
				+ "left join mas_hospital as hos on hos.hospital_id =cast(prf.institution_name as int) where cast(prf.institution_name as int)=:hospitalId";

		Query query = session.createSQLQuery(quryy);
		query.setParameter("hospitalId", hospitalId);
		phDiseaseRegistrationFollowList = query.list();
		logger.debug("phDiseaseRegistrationFollowList "+phDiseaseRegistrationFollowList.size());
	
		
		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<Object[]> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();

		List<MasSession> masSessionList = new ArrayList<>();

		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
				.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		

		patientTypeList = session.createCriteria(MasPatientType.class)

		.add(Restrictions.eq("Status", "Y")).list();

		complaintList = session.createCriteria(MasComplaint.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		doctorList=session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital").
				createAlias("EmployeeType", "EmployeeType").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("EmployeeType.Id", 1)).list();

		
		caseTypeList = session.createCriteria(MasCaseType.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
				.addOrder(Order.asc("DiagnosisConclusionName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y")).list();
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chargeType")
				.addOrder(Order.asc("ChargeCodeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("chargeType.Id", 9)).list();

		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "Y"))
				.addOrder(Order.asc("AuthorizerName")).list();
		
		map.put("phDiseaseRegistrationFollowList", phDiseaseRegistrationFollowList);

		map.put("complaintList", complaintList);
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("relationList", relationList);
		map.put("patientTypeList", patientTypeList);
		map.put("sexList", sexList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("masSessionList", masSessionList);
		map.put("patientReferalList", patientReferalList);
		map.put("patientReferalListForInternal", patientReferalListForInternal);
		map.put("hospitalReferes", hospitalReferes);
		map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	
	@Override
	public Map<String, Object> getReseveredTokenNo(int departmentId, int hospitalId) {

		logger.debug("Inside Method: getReseveredTokenNo");

		Session session = (Session) getSession();
		List<AppPatientAppointments> patientAppointList = new ArrayList<>();
		Map<String, Object> reservedTokenMap = new HashMap<>();
		Map<Integer, Object> patientWithTokenMap = new HashMap<>();
		Date currentDate = new Date();
		
		Criteria crt=null;
		
		crt=session.createCriteria(AppPatientAppointments.class);
		crt.createAlias("Hospital","hosp");
		crt.createAlias("Department", "dept");
		crt.add(Restrictions.eq("AppointmentDate", currentDate));
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

	@Override
	public Map<String, Object> updatePatientPrintStatus(String hinNo, int hinNoRandom) {

		logger.debug("Inside Method: updatePatientPrintStatus");
		Map<String, Object> map = new HashMap<>();
		Patient patient=null;
		List<Patient> patientList = new ArrayList<>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session = (Session) getSession();
		Criteria crt = null;

		crt = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
		patientList = crt.list();

		if (null != patientList && patientList.size()>0 ) {
			patient=patientList.get(0);
			 patient.setOtpNumber(hinNoRandom);
			 patient.setStatus("y");
			 
			 Transaction tx = null;

				try {
					tx = session.beginTransaction();
					hbt.save(patient);
					
					tx.commit();
					
				}
				catch(Exception e){
					e.printStackTrace();
					tx.rollback();
				}
		}
		return map;
	}

	@Override
	public Map<String, Object> populatePincodeByDistrict(Map<String, Object> map) {
		logger.debug("Inside Method: populatePincodeByDistrict");
		Session session = (Session) getSession();
		int districtId = 0;
		Criteria crt=null;
		
		if(null != map.get("districtId")){
			districtId=(Integer)map.get("districtId");
		}
		List<Object[]> masPostCodeList = new ArrayList<>();
		
		crt = session.createCriteria(MasPostCode.class).createAlias("DistrictId", "dist")
				.add(Restrictions.eq("dist.Id", districtId)).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("PostCodeName")));
		masPostCodeList=crt.list();
		
		
		map.put("masPostCodeList", masPostCodeList);
		return map;
	}

	@Override
	public Map<String, Object> lsgByDistrict(int districtId) {
		logger.debug("Inside Method: lsgByDistrict");
		Session session = (Session) getSession();
		Map<String, Object> map= new HashMap<>();
		Criteria crt=null;
		
		List<Object[]> MasLsgList = new ArrayList<>();
		
		crt = session.createCriteria(MasLsg.class).createAlias("District", "dist")
				.add(Restrictions.eq("dist.Id", districtId)).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("LsgTypeName")))
		                .addOrder(Order.asc("LsgTypeName"));//added by govind 19-01-2017
		MasLsgList=crt.list();
		
		map.put("MasLsgList", MasLsgList);
		return map;
		
	}

	@Override
	public synchronized boolean checkDuplicateVisit(int hospitalId, int departmentId,int uhid) {
		logger.debug("Inside Method: checkDuplicateVisit");
		Session session =(Session) getSession();

		Date date=new Date();

		Criteria crt=null;
		boolean status=false;
		logger.debug("uhid "+uhid);

		if(uhid>0){
			 crt=session.createCriteria(Visit.class).createAlias("Department", "deptId")
						.createAlias("Hospital", "hospId")
						.createAlias("Hin", "hind")
						.add(Restrictions.eq("deptId.Id", departmentId))
						.add(Restrictions.eq("hospId.Id", hospitalId))
						.add(Restrictions.eq("hind.Id", uhid))
						.add(Restrictions.eq("VisitDate", date)).add(Restrictions.eq("VisitStatus", "w"));
			 if(crt.list().size()>0){
				 status=true;
			 }
		 }


		return status;
	}


	@Override
	public Map<String, Object> displayImage(String uhidNo) {
		logger.debug("Inside Method: displayImage");
		Map<String,Object> map= new HashMap<>();
		int hinId=0;
		Session session =(Session) getSession();
		List<Patient> patientlist= new ArrayList<>();

		Criteria crt=null;
		Query query=null;

		crt=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", uhidNo));
		patientlist=crt.list();
		for(Patient p:patientlist){
			hinId=p.getId();
		}
		if(hinId>0){

			query = session.createQuery("from UploadDocuments where Hin.Id= :id");
			query.setLong("id", hinId);
			UploadDocuments imageObj = (UploadDocuments) query.uniqueResult();
			map.put("imageObj",imageObj);
		}


		return map;
	}
	

	@Override
	public boolean savePatientQueue(int hospitalId, int departId, int priority, int tokenNumber, int uhinNo,
			long totalHospitalVisitNo, int visitId) {
		logger.debug("Inside Method: savePatientQueue");

		QueueManagment queuemanagment = new QueueManagment();
		String date = null;
		String time = null;
		Map<String, Object> utilMap = null;
		boolean status=false;
		Transaction tnx=null;
		
		
		
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		
		queuemanagment.setHospital(hospital);
		
		MasDepartment department=new MasDepartment();
		department.setId(departId);
		
		queuemanagment.setDepartment(department);
		queuemanagment.setPriorityNumber(priority);
		queuemanagment.setTokenNo(tokenNumber);
		
		Patient patient=new Patient();
		patient.setId(uhinNo);
		
		queuemanagment.setHin(patient);
		queuemanagment.setTotalHospitalVisit((int)totalHospitalVisitNo);
		
		Visit visit=new Visit();
		visit.setId(visitId);
		queuemanagment.setVisit(visit);
		
		utilMap = HMSUtil.getCurrentTime();
		if(utilMap!=null && utilMap.get("currentDate")!=null && utilMap.get("currentTime")!=null){
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		queuemanagment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		queuemanagment.setLastChgTime(time);
		}
		
		Session session =(Session) getSession();
		try{
			tnx=session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(queuemanagment);
		
		status=true;
		tnx.commit();
		session.flush();
	
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		
		return status;
	}

	@Override
	public Map<String, Object> populateUnitForDepartment(Map<String, Object> dmap) {

		logger.debug("Inside Method: populateUnitForDepartment");

		Map<String,Object> map= new HashMap<>();
		Session session=(Session) getSession();
		List<HospitalDoctorUnitM> unitList= new ArrayList<>();
		List<MasDepartment> masDepartmentList= new ArrayList<>();
	
		List<Object[]> empSCMappingStringList = new ArrayList<>();
		int hospitalId=(Integer)dmap.get("hospitalId");
		
		ArrayList< Integer> serviceCentList= new ArrayList<>();
		String[] departmentIdList=null;
		
		String departmentValues=(String)dmap.get("departmentValues");
		
		if(null !=departmentValues && !departmentValues.isEmpty()){
		 departmentIdList = departmentValues.split(",");
		
		for(String s:departmentIdList ){
			
			serviceCentList.add(Integer.parseInt(s));
		}
		
		}
		int empcategoryId=4;

		Criteria crt=null;
		
	
		
		if(null !=serviceCentList && serviceCentList.size()>0){

			crt=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.in("dep.Id",serviceCentList));

			masDepartmentList=crt.list();

			ArrayList<Integer> empDepartmentId= new ArrayList<>();
			for(MasDepartment department:masDepartmentList){

				if(null !=department && null !=department.getEmpDept())
					if(null !=department.getEmpDept())
						empDepartmentId.add(department.getEmpDept().getId());

			}
			String unitDay=HMSUtil.getDayOfWeek().toLowerCase();
			if(empDepartmentId.size()>0){
				crt=session.createCriteria(HospitalDoctorUnitM.class)
						.createAlias("EmpDept", "EmpDept")
						.createAlias("Hospital", "Hospital")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
						.add(Restrictions.in("EmpDept.Id", empDepartmentId));

				unitList=crt.list();
			}

			if(unitList.size()>0){


				empSCMappingStringList = session.createCriteria(EmpScMapping.class).createAlias("Employee", "i").createAlias("Hospital", "hospital")
						.createAlias("Department", "dept").add(Restrictions.in("dept.Id",serviceCentList)).add(Restrictions.eq("i.EmpCategory.Id",empcategoryId))
						.addOrder(Order.asc("i.EmployeeName")).add(Restrictions.eq("hospital.Id", hospitalId))
						.setProjection(Projections.projectionList().add(Projections.property("i.Id")).add(Projections.property("Id"))
								.add(Projections.property("i.EmployeeName"))).list();

				logger.debug("@@@@#### "+empSCMappingStringList.size());
			}
			
			if(dmap.get("hinId")!=null){
				int hinId = (Integer)dmap.get("hinId");
				
				List<Object[]> lastVisitDetailsList = session.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "visit")
						.createAlias("visit.Hin", "hin")
						.createAlias("Hospital", "hosp")
						.add(Restrictions.eq("visit.Department.Id",serviceCentList.get(0)))
						.add(Restrictions.eq("hosp.Id", hospitalId))
						.add(Restrictions.eq("hin.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1)
						.setProjection(Projections.projectionList().add(Projections.property("Employee.Id")).add(Projections.property("visit.Unit.Id"))).list();
				
				map.put("lastVisitDetailsList", lastVisitDetailsList);
			}
			
			
		}
		map.put("empSCMappingStringList", empSCMappingStringList);
		 //map.put("masEmployeeList", masEmployeeList);
		 map.put("unitList", unitList);
		
		return map;
	}

	@Override
	public Map<String, Object> populateDoctorForUnit(int unitId,int departmentId) {
		logger.debug("Inside Method: populateDoctorForUnit");

		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		List<HospitalDoctorUnitT> doctorList = new ArrayList<>();
		List<HospitalDoctorUnitT> headdoctorList = new ArrayList<>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time  = (String)utilMap.get("currentTime");
		
		Criteria crt = null;
		
		crt = session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM")
				.createAlias("Employee", "e")
				.createAlias("e.Users", "u")
				.createAlias("u.Department", "dd")//.createAlias("u.CurrentCounter", "cc",CriteriaSpecification.LEFT_JOIN).createAlias("cc.Department", "d")
				.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase())//.add(Restrictions.eq("d.Id", departmentId))
				.add(Restrictions.eq("UnitM.Id", unitId)).add(Restrictions.eq("Status", "y").ignoreCase());
		crt = crt.add(Restrictions.or(Restrictions.isNull("e.VisitTimeUpto"), Restrictions.lt("e.VisitTimeUpto",new Date())));
		crt= crt.add(Restrictions.eq("dd.Id", departmentId));
		doctorList=crt.list();
		
		
		crt=session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM")
				.createAlias("Employee", "e")
				.createAlias("e.Users", "u")
				.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase())
				.add(Restrictions.eq("UnitM.Id", unitId)).add(Restrictions.eq("HeadFleg", "y").ignoreCase()); //.add(Restrictions.eq("Status", "y").ignoreCase())
		crt = crt.add(Restrictions.or(Restrictions.isNull("e.VisitTimeUpto"), Restrictions.lt("e.VisitTimeUpto", new Date())));
		
		headdoctorList=crt.list();
		
		map.put("doctorList",doctorList);
		map.put("headdoctorList",headdoctorList);
		return map;
	}

	@Override
	public Map<String, Object> populateDoctorForDepartment(String departmentId, int hospitalId) {

		logger.debug("Inside Method: populateDoctorForDepartment");

		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();

		logger.debug(" departmentId " + departmentId);
		String[] departmentIdList = null;

		ArrayList<Integer> serviceCentList = new ArrayList<>();
		if (null != departmentId && !departmentId.isEmpty()) {
			departmentIdList = departmentId.split(",");

			for (String s : departmentIdList) {

				serviceCentList.add(Integer.parseInt(s));
			}

		}

		List<Object[]> empList = new ArrayList<>();
		if (null != serviceCentList && serviceCentList.size() > 0) {


			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			    Date currentDate = new Date();

			    String time = sdfTime.format(currentDate);

			   
			Calendar now = Calendar.getInstance();
            int currentDays = now.get(Calendar.DATE);
            int currentMonth = now.get(Calendar.MONTH)+1;
            int currentYear = now.get(Calendar.YEAR);
          
          
           Criteria criteria = session.createCriteria(HrDutyScheduleT.class)
            		.createAlias("ScheduleM", "sm")
            		.createAlias("ShiftCode", "sc")
            		//.createAlias("Shift", "sh")
            		.createAlias("ScheduleDepartment", "dept") 
            		.createAlias("sm.Employee", "emp")
            		.createAlias("emp.Users", "u")
            		.createAlias("sc.HrMasShifts", "sh")
            		.createAlias("sm.Hospital", "hospital")
            		.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase())
            		.add(Restrictions.le("sh.ShiftStartTime", time))
            		.add(Restrictions.ge("sh.ShiftEndTime", time))
                    .add(Restrictions.eq("hospital.Id", hospitalId))
                    .add(Restrictions.eq("Day",String.valueOf( currentDays)))
                    .add(Restrictions.eq("sm.Month",String.valueOf(currentMonth) ))
                     .add(Restrictions.in("dept.Id", serviceCentList))
                    .add(Restrictions.eq("sm.Year", currentYear)).setProjection(Projections.projectionList()
                    		.add(Projections.distinct(Projections.property("emp.Id")))
                    		.add(Projections.property("emp.EmployeeName"))).addOrder(Order.asc("emp.EmployeeName"));
             
           criteria = criteria.add(Restrictions.or(Restrictions.isNull("emp.VisitTimeUpto"), Restrictions.lt("emp.VisitTimeUpto",new Date())));
           empList = criteria.list();
		   logger.debug("empList  "+empList.size());

		}

		map.put("masEmployeeList", empList);
		
		return map;
	}

	@Override
	public Map<String, Object> populateUnitForDoctor(int doctorId, int hospId) {
		logger.debug("Inside Method: populateUnitForDoctor");

		Map<String, Object> map = new HashMap<>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		Session session = (Session) getSession();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		
		List<HospitalDoctorUnitT> unitList = new ArrayList<>();

		Criteria crt = null;
		
		crt = session.createCriteria(HospitalDoctorUnitT.class)
				.createAlias("Employee", "e")
				.createAlias("UnitM", "UnitM").add(Restrictions.eq("Employee.Id", doctorId))
				.add(Restrictions.eq("UnitM.Hospital.Id", hospId))
				.add(Restrictions.or(Restrictions.isNull("e.VisitTimeUpto"), Restrictions.lt("e.VisitTimeUpto",new Date())));
		unitList=crt.list();
		
		
		map.put("unitList", unitList);
		
		
		return map;
	}
	
	/**
	 * Method to generate (or Display) Bill No using bl_parameter Table
	 * 
	 */
	@SuppressWarnings("unchecked")
	private synchronized String generateBillNo(String flag, int hospitalId) {

		logger.debug("Inside Method: generateBillNo");
		Integer billSeqNo = 0;
		List<BlParameter> billSeqNoList = new ArrayList<>();
		Map<String, Object> utilMap= new HashMap<>();
		utilMap=HMSUtil.getCurrentDateAndTime();

		Session session = (Session) getSession();
		try {
			billSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "BS"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

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
		return  billSeqNo.toString();

	}

	@Override
	public Map<String,Object> visitscheme(int hospitalId, int schemeId,int chargeId,String pHinId) {

		logger.debug("Inside Method: visitscheme");

		Map<String,Object> map= new HashMap<>();
		Session session=(Session) getSession();
		logger.debug("scheme patientId "+pHinId);
		Criteria crt=  session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", pHinId));
		Patient patient=(Patient) crt.list().get(0);
		
		List<MasDiscount> localDiscountList= new ArrayList<>();
		
		
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		Map<String, Object> utilMap= new HashMap<>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		
		if(patient.getDateOfBirth()!=null)
		cal.setTime(patient.getDateOfBirth());
		int calculatedYear;
		int currentYear = now.get(Calendar.YEAR);
		int birthYear = cal.get(Calendar.YEAR);
		calculatedYear = currentYear - birthYear;
		
		String hql = "select masdiscount from jkt.hms.masters.business.MasDiscount as masdiscount "
				+ " left outer join masdiscount.PatientType as patientType"
				
				
				
				+ " left outer join masdiscount.OtherCategory as otherCategory"
				+ " left outer join masdiscount.Department as department"
				+ " where masdiscount.Scheme is not null and "
				+ " (masdiscount.BplStatus is null or (masdiscount.BplStatus=:bplStatus))"
				+ " and ( patientType is null or patientType.Id=:socialCategoryid )"
				+ " and ( otherCategory is null or otherCategory.Id in "
				+ "(select otherCat.Id FROM  jkt.hms.masters.business.PatientCategoryDetails oCategory "
				+ " inner join oCategory.OtherCategory otherCat "
				+ " inner join oCategory.Hin hin where hin.Id=:patientId ) )"
				
				
				+ " and (masdiscount.FromAge is null or (masdiscount.FromAge<=:age))"
				+ " and (masdiscount.ToAge is null or (masdiscount.ToAge>=:age))"

				+ " and (masdiscount.EffectiveDateFrom is null or (masdiscount.EffectiveDateFrom<=:currentDate))"
				+ " and (masdiscount.EffectiveDateTo is null or (masdiscount.EffectiveDateTo>=:currentDate))"

				+ "";


		Query query=session.createQuery(hql);
		query.setParameter("bplStatus", patient.getBplStatus());
		query.setParameter("socialCategoryid", patient.getPatientType()!=null?patient.getPatientType().getId():0);
		
		
		
		query.setParameter("age",new BigDecimal(calculatedYear));
		query.setParameter("currentDate",HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
		query.setParameter("patientId",patient.getId());
		localDiscountList=query.list();
		map.put("localDiscountList", localDiscountList);
		
		return map;
	}

	@Override
	public Map<String, Object> saveRegistrationCardPrintAmount(
			Map<String, Object> map) {
		
		Map<String,Object> dmap= new HashMap<>();
		Session session=(Session)getSession();
		Transaction tnx=null;
		boolean status=false;
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int hospitalId=0;
		
		hospitalId=(Integer)map.get("hospitalId");
		
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		
		BlOpBillHeader opBillHeader=null;
		BlOpBillDetails opBillDetails=null;
		
		opBillHeader=(BlOpBillHeader)map.get("opBillHeader");
		opBillDetails=(BlOpBillDetails)map.get("opBillDetails");
		
		String billNo = "";
		billNo = generateBillNo("save",hospitalId);
		opBillHeader.setBillNo(billNo);
		opBillHeader.setHospital(hospital);
		opBillHeader.setBillDate(new Date());
		opBillHeader.setBillTime("12:00");
		
		int patientId=0;
		patientId=(Integer)map.get("patientHinId");
		logger.debug("patientId &&***###@@@   "+patientId);
		try{
		tnx=session.beginTransaction();	
		Patient patient=(Patient) session.load(Patient.class, patientId);
		patient.setStatus("y");
		
		hbt.update(patient);
		
		hbt.save(opBillHeader);
		
		opBillDetails.setOpBillHeader(opBillHeader);
		
		hbt.save(opBillDetails);
		tnx.commit();session.flush();
		status=true;
		}
		catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		
		dmap.put("status", status);
		
		return dmap;
	}

	@Override
	public Map<String, Object> populateSubCenterByHospital(int districtId) {
		
		Map<String,Object> map= new HashMap<>();
		
		List<MasHospital> subCenterList = new ArrayList<>();
		
			int hospitalTypeId = 0;
		
        URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
        hospitalTypeId =Integer.parseInt(prop.getProperty("hospitalTypeId"));
        
		
		Session session = (Session) getSession();
		subCenterList = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "hospitaltype")
				.createAlias("District", "District")
				
				.addOrder(Order.asc("HospitalName"))
				.add(Restrictions.eq("hospitaltype.Id",hospitalTypeId))
				.add(Restrictions.eq("District.Id",districtId))
				
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		map.put("subCenterList", subCenterList);
		
		return map;
	}
	public Map<String,Object> saveVisitInformationInLeanServer(List<Visit> visitList,
			List<QueueManagment> managements,BlOpBillHeader opBillHeader,
			BlOpBillDetails opBillDetails,Patient patient,MasHospital hospital) {

		logger.debug("Inside Method: saveVisitInformationInLeanServer");

		Map<String,Object> returnMap= new HashMap<>();
		String returnMessage="failure";
		logger.debug("Start HL7 method.................");  
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		Properties pacProper = new Properties();
		Session session = (Session) getSession();
		Map<ADT_A01, String> adt_A01List = new HashMap<>(); // added by amit das on 19-12-2016
		InputStream input;
		try {
			input = new FileInputStream(new File(resourcePath.getFile()));
			pacProper.load(input);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.debug("Local_URL>>>" + pacProper.getProperty("SERVER_URI"));
		String uri = pacProper.getProperty("SERVER_URI");
		Parser parser = PipeParser.getInstanceWithNoValidation();
		HohClientSimple client=null;
		ADT_A01 adt1 = null;
		
		for(int i=0;i<visitList.size();i++){
			Visit visit=visitList.get(i);
			QueueManagment queue=managements.get(i);
			PharmacyLabQueue pharmacyLabQueue = null;
			
			List<PharmacyLabQueue> pharmacyLabQueueList = session.createCriteria(PharmacyLabQueue.class).add(Restrictions.eq("Visit.Id", visit.getId())).list();
			if(pharmacyLabQueueList!=null && pharmacyLabQueueList.size()>0){
					pharmacyLabQueue = pharmacyLabQueueList.get(0);
					logger.debug("********pharmacyLab visit*********");
			}
			
		try { 
			try {
				Date DOB = null;

				adt1 = new ADT_A01();
				ORU_R01 message1 = new ORU_R01();
				ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();

				MSH mshSegment = adt1.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				mshSegment.getMsh3_SendingApplication().setValue("VISIT");
				mshSegment.getMsh4_SendingFacility().setValue("RIH");
				mshSegment.getMsh5_ReceivingApplication().setValue("HMS");
				mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(now("yyyyMMdd")+now("HHmmss"));
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ADT");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A01");
				mshSegment.getMsh10_MessageControlID().setValue(""+123);
				mshSegment.getMsh11_ProcessingID().setValue("P");
				mshSegment.getMsh12_VersionID().setValue("2.2");

				DOB =patient.getDateOfBirth();
				String date=null;
				if(DOB!=null){
                   date = convertDatetoString(DOB);
                }
                else{
                   date = convertDatetoString(new Date());
                }

				// pharmacy lab queue request
				OBX obx = adt1.getOBX();  // added by amit das on 19-09-2017
				if(pharmacyLabQueue!=null){
                    obx.getResponsibleObserver().getCn2_FamilyName().setValue(pharmacyLabQueue.getTokenNo()+"");
                     obx.getObx7_ReferencesRange().setValue(pharmacyLabQueue.getDepartment().getId()+"");
                     obx.getObservationIdentifier().getCe1_Identifier().setValue(pharmacyLabQueue.getPharmacyLabStatus());
                     obx.getObservationSubID().setValue(pharmacyLabQueue.getStatus());
                     obx.getObx10_NatureOfAbnormalTest().setValue(pharmacyLabQueue.getTotalHospitalVisit()+"");
                 }


				// Populate the PID Segment
				PID pid = adt1.getPID();
				if(patient.getAadhaarNo()!=null){
                 pid.getPid2_PatientIDExternalID().getCk1_IDNumber().setValue(patient.getAadhaarNo()+"");
                }

				pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(patient.getId()+"");
				pid.getPid4_AlternatePatientID().setValue(patient.getHinNo());
				pid.getPid5_PatientName().getFamilyName().setValue(patient.getFullName());
				pid.getPid5_PatientName().getGivenName().setValue(patient.getPFirstName());
				pid.getPid6_MotherSMaidenName().setValue(patient.getFatherMotherName());
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(date);
				pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().setValue(patient.getAge());
				if(pid.getPid8_Sex()!=null){
                  pid.getPid8_Sex().setValue(patient.getSex().getId()+"");
                }
				if(patient.getPatientType()!=null){
                pid.getPid9_PatientAlias(0).getFamilyName().setValue(patient.getPatientType().getId()+"");
                }
				pid.getPid10_Race().setValue(patient.getBplStatus());

				pid.getPid12_CountyCode().setValue(patient.getNativityType());
				// pid.getPid13_PhoneNumberHome(0).setValue(patient.getMobileNumber()); //commented by amit das on 01-08-2016
				pid.getPid13_PhoneNumberHome(0).setValue(HMSUtil.convertPhoneNumberToHL7(patient.getMobileNumber())); //added by amit das on 01-08-2016


				if(patient.getBloodGroup()!=null){
                pid.getPid14_PhoneNumberBusiness(0).setValue(patient.getBloodGroup().getId()+"");
                }
				pid.getPid15_LanguagePatient().setValue(patient.getIdNo());
				if(patient.getMaritalStatus()!=null){
                pid.getPid16_MaritalStatus().setValue(patient.getMaritalStatus().getId()+"");
                }
				if(patient.getReligion()!=null){
                pid.getPid17_Religion().setValue(patient.getReligion().getId()+"");
                }
				if(patient.getOtpNumber()!=null){
                    pid.getPid18_PatientAccountNumber().getCk1_IDNumber().setValue(patient.getOtpNumber()+"");
                }

				if(patient.getCurrentVisitNo()!=null){
                pid.getPid19_SocialSecurityNumberPatient().setValue(patient.getCurrentVisitNo()+"");
            }
				if(patient.getIdCard()!=null){
                    pid.getPid20_DriverSLicenseNumberPatient().getCm_license_no1_LicenseNumber().setValue(patient.getIdCard().getId()+"");
                }
				if(patient.getRelation()!=null){
                    pid.getPid21_MotherSIdentifier().getCk1_IDNumber().setValue(patient.getRelation().getId()+"");
                }
				pid.getPid22_EthnicGroup().setValue(patient.getRegTime());
				pid.getPid23_BirthPlace().setValue(patient.getNotionalDobStatus());
				if(patient.getRegDate()!=null){
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    //formatter1.format(formatter.format(patient.getRegDate()));
                    pid.getPid24_MultipleBirthIndicator().setValue(formatter.format(patient.getRegDate()));
                }

				pid.getPid25_BirthOrder().setValue(patient.getYearOfBirth());
				if(patient.getHospital()!=null){
                  pid.getPid26_Citizenship(0).setValue(patient.getHospital().getId()+"");
              }


				PV1 pv1 = adt1.getPV1();
				pv1.getPv15_PreadmitNumber().setValue(visit.getPriorityNumber()+"");
				if(visit.getUnit()!=null){
                    pv1.getPv16_PriorPatientLocation().getCm_internal_location1_NurseUnitStation().setValue(visit.getUnit().getId()+"");
                }
				pv1.getPv17_AttendingDoctor().getCn1_IDNumber().setValue(visit.getAddEditBy().getId()+"");
				if(visit.getDoctor()!=null){
                    pv1.getPv18_ReferringDoctor().getIDNumber().setValue(visit.getDoctor().getId()+"");
                }
				if(visit.getHospital()!=null){
                    pv1.getPv110_HospitalService().setValue(visit.getHospital().getId()+"");
                }
				pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().setValue(visit.getTotalHospitalVisit()+"");
				if(visit.getDiagnosis()!=null){
                     pv1.getPv112_PreadmitTestIndicator().setValue(visit.getDiagnosis().getId()+"");
                }
				if(visit.getComplaint()!=null){
                    pv1.getPv113_ReadmissionIndicator().setValue(visit.getComplaint().getId()+"");
                }
				pv1.getPv114_AdmitSource().setValue(visit.getEdStatus()+"");
				pv1.getPv115_AmbulatoryStatus(0).setValue(visit.getVisitStatus()+"");
				pv1.getPv116_VIPIndicator().setValue(visit.getTokenNo()+"");
				if(visit.getHin()!=null){
                    pv1.getPv118_PatientType().setValue(visit.getHin().getId()+"");
                }

				pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(visit.getVisitNo()+"");
				pv1.getPv122_CourtesyCode().setValue(visit.getCurPharVisitStatus()+"");
				pv1.getPv123_CreditRating().setValue(visit.getStatus()+"");
				pv1.getPv124_ContractCode(0).setValue(visit.getAppointmentType()+"");
				if(visit.getAddEditDate()!=null){
                    pv1.getPv125_ContractEffectiveDate(0).setValue(convertDatetoString(visit.getAddEditDate()));
                }
				if(visit.getAddEditTime()!=null){
                    pv1.getPv142_PendingLocation().getCm_internal_location3_Bed().setValue(visit.getVisitTime());
                }


				if(visit.getCaseType()!=null){
                    pv1.getPv139_ServicingFacility().setValue(visit.getCaseType().getId()+"");
                }
				if(visit.getDepartment()!=null){
                    pv1.getPv140_BedStatus().setValue(visit.getDepartment().getId()+"");
                }
				if(visit.getVisitDate()!=null){
                    //pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(now("yyyyMMdd")+now("Hmmss"));
                    pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(convertDatetoString(visit.getVisitDate())+"");
                }if(visit.getVisitTime()!=null){
                    pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().setValue(visit.getVisitTime()+"");
                }

				if(opBillHeader!=null){//added by govind 26-05-2017
                pv1.getPv14_AdmissionType().setValue(opBillHeader.getStatus()+"");
                if(opBillHeader.getDiscountAmt()!=null){
                    pv1.getPv146_CurrentPatientBalance().setValue(opBillHeader.getDiscountAmt()+"");
                }
                if(opBillHeader.getBillAmt()!=null){
                    pv1.getPv147_TotalCharges().setValue(opBillHeader.getBillAmt()+"");
                }

                if(opBillHeader.getAdvanceAdjustment()!=null){
                    pv1.getPv148_TotalAdjustments().setValue(opBillHeader.getAdvanceAdjustment()+"");
                }
                if(opBillHeader.getActualCollectedAmt()!=null){
                    pv1.getPv149_TotalPayments().setValue(opBillHeader.getActualCollectedAmt()+"");
                }
                if(opBillHeader.getBillNo()!=null){
                    pv1.getPv150_AlternateVisitID().getIDNumber().setValue(opBillHeader.getBillNo());
                }
                }

				if(visit.getVisitSession()!=null)
                        pv1.getPv117_AdmittingDoctor().getCn8_SourceTableId().setValue(visit.getVisitSession().getId()+"");

				pv1.getPv117_AdmittingDoctor().getCn3_GivenName().setValue(visit.getDisplayAfterNo()+"");

				if(visit.getCreationSource()!=null)
                    pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().setValue(visit.getCreationSource());

				PV2 pv2=adt1.getPV2();
				pv2.getPv27_VisitUserCode().setValue(queue.getTokenStatus());
				if(opBillDetails!=null){//added by govind 26-05-2017
                pv2.getPv25_PatientValuables(0).setValue(opBillDetails.getRate()+"");
                pv2.getPv26_PatientValuablesLocation().setValue(opBillDetails.getAmount()+"");
                pv2.getPv22_AccommodationCode().getCe1_Identifier().setValue(opBillDetails.getRefundableStatus()+"");
                if(opBillDetails.getDiscountPercent()!=null){
                    pv2.getPv23_AdmitReason().getCe2_Text().setValue(opBillDetails.getDiscountPercent()+"");
                }if(opBillDetails.getDiscountAmt()!=null){
                    pv2.getPv24_TransferReason().getCe2_Text().setValue(opBillDetails.getDiscountAmt()+"");
                }
                if(opBillDetails.getChargeCode()!=null){
                    pv2.getPv21_PriorPendingLocation().getBedStatus().setValue(opBillDetails.getChargeCode().getId()+"");
                }
                }

				ORC orc = orderObservation.getORC();
				orc.getOrc1_OrderControl().setValue("NW"); // New
				orc.getDateTimeOfTransaction()
                        .getTs1_TimeOfAnEvent()
                        .setValue(now("yyyyMMdd") + now("Hmmss"));
				OBR obr = orderObservation.getOBR();
				obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(now("yyyyMMdd") + now("HHmmss"));

				logger.debug(adt1);

				ISendable sendable = new MessageSendable(adt1);

				if(hospital.getClientIp()!=null && hospital.getClientPort()!=null){
                try {
                     client = new HohClientSimple(hospital.getClientIp(),Integer.parseInt(hospital.getClientPort()), uri, parser);
                     client.setResponseTimeout(6000000);
                     IReceivable<Message> receivable =client.sendAndReceiveMessage(sendable);
                     Message hapiMsg = receivable.getMessage();
                     logger.debug("Response was:\n" + hapiMsg.encode());
                     String remoteHostIp = (String) receivable.getMetadata().get(MessageMetadataKeys.REMOTE_HOST_ADDRESS);
                        logger.debug("From:\n" + remoteHostIp);

                   if (hapiMsg instanceof ACK) {
                             ACK ack = (ACK) hapiMsg;

                          logger.debug("Recieve acknowledge");
		                  logger.debug("inside ach msh "+ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
                          logger.debug("inside ach msh "+ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
                          logger.debug("inside ach msh "+ack.getMSH().getMsh10_MessageControlID());
                          logger.debug("inside ach msh "+ack.getMSH().getMsh11_ProcessingID());
                          logger.debug("inside ach msh "+ack.getMSH().getMsh12_VersionID());
                          logger.debug("**********************************************************");
                          logger.debug("inside ach msa  "+ack.getMSA().getMsa1_AcknowledgementCode().getValue());
                          logger.debug("inside ach msa  "+ack.getMSA().getMsa2_MessageControlID());
                          logger.debug("inside ach msa  "+ack.getMSA().getMsa3_TextMessage().getValue());
                          logger.debug("**********************************************************");
                          logger.debug("inside ach err1  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
                          logger.debug("inside ach err2  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
                          logger.debug("inside ach err3  "+ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());

                          if(ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA")
                               && ack.getMSA().getMsa3_TextMessage().getValue() == null
                               && ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null)
                          {  logger.debug("update ");

                                logger.debug("update2 ");
                                  returnMessage="success";
                                  returnMap.put("message", returnMessage);
                          }

                      } else {
                        logger.debug("exit");
                    }
                } catch (EncodingNotSupportedException e) {

                    returnMessage="EncodingNotSupportedException";
                    returnMap.put("message", returnMessage);
                   logger.error("Error in saveVisitInformationInLeanServer");
                } catch (HL7Exception e) {

                    returnMessage="HL7Exception";
                    returnMap.put("message", returnMessage);
                    logger.error("Error in saveVisitInformationInLeanServer");
                }


            }
			} catch (Exception s) {
				s.printStackTrace();
				returnMessage="Exception";
				logger.debug("SQL query does not execute." + s);
			} finally { 
				session.close();
				if(client!=null){
					client.close();
				}
				
			}
			 adt_A01List.put(adt1,returnMessage); // added by amit das on 19-12-2016
			 logger.debug(" adt_A01List = "+adt_A01List.size());
		} catch (Exception e) {
			returnMessage="fail";
			e.printStackTrace();
		}
	}
		
		returnMap.put("ADTMessage", adt_A01List); // added by amit das on 19-12-2016
		returnMap.put("message", returnMessage);
		return returnMap;
	}
	
	public Map<String,Object> saveVisitInformationInCentralServer(List<Visit> visitList,
			List<QueueManagment> managements,BlOpBillHeader opBillHeader,
			BlOpBillDetails opBillDetails,Patient patient,MasHospital hospital) {

		logger.debug("Inside Method: saveVisitInformationInCentralServer");

		Map<String,Object> returnMap= new HashMap<>();
		List<ADT_A01> adt_A01List = new ArrayList<>();
		ADT_A01 adt1  = null;
		String returnMessage="failure";
		logger.debug("Start HL7 method.................");  
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		Properties pacProper = new Properties();
		InputStream input;
		try {
			input = new FileInputStream(new File(resourcePath.getFile()));
			pacProper.load(input);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.debug("Local_URL>>>" + pacProper.getProperty("SERVER_URI"));

		for(int i=0;i<visitList.size();i++){
			Visit visit=visitList.get(i);
			QueueManagment queue=managements.get(i);
		try { 
			try {
				Date DOB = null;
				adt1 = new ADT_A01();
				ORU_R01 message1 = new ORU_R01();
				ORU_R01_ORDER_OBSERVATION orderObservation = message1.getPATIENT_RESULT().getORDER_OBSERVATION();

				// Populate the MSH Segment
				MSH mshSegment = adt1.getMSH();
				mshSegment.getMsh1_FieldSeparator().setValue("|");
				mshSegment.getMsh2_EncodingCharacters().setValue("^~\\&");
				mshSegment.getMsh3_SendingApplication().setValue("VISIT");
				mshSegment.getMsh4_SendingFacility().setValue("RIH");
				mshSegment.getMsh5_ReceivingApplication().setValue("HMS");
				mshSegment.getMsh6_ReceivingFacility().setValue("EKG");
				mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(now("yyyyMMdd")+now("HHmmss"));
				mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ADT");
				mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A01");
				mshSegment.getMsh10_MessageControlID().setValue(""+123);
				mshSegment.getMsh11_ProcessingID().setValue("P");
				mshSegment.getMsh12_VersionID().setValue("2.2");

				DOB =patient.getDateOfBirth();
				String date;

				if(DOB!=null){
                   date = convertDatetoString(DOB);
                }
                else{
                   date = convertDatetoString(new Date());
                }


				PID pid = adt1.getPID();
				if(patient.getAadhaarNo()!=null){
                 pid.getPid2_PatientIDExternalID().getCk1_IDNumber().setValue(patient.getAadhaarNo()+"");
                }

				pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue(patient.getId()+"");
				pid.getPid4_AlternatePatientID().setValue(patient.getHinNo());
				pid.getPid5_PatientName().getFamilyName().setValue(patient.getFullName());
				pid.getPid5_PatientName().getGivenName().setValue(patient.getPFirstName());
				pid.getPid6_MotherSMaidenName().setValue(patient.getFatherMotherName());
				pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(date);
				pid.getPid7_DateOfBirth().getTs2_DegreeOfPrecision().setValue(patient.getAge());
				if(pid.getPid8_Sex()!=null){
                  pid.getPid8_Sex().setValue(patient.getSex().getId()+"");
                }
				if(patient.getPatientType()!=null){
                pid.getPid9_PatientAlias(0).getFamilyName().setValue(patient.getPatientType().getId()+"");
                }
				pid.getPid10_Race().setValue(patient.getBplStatus());
				pid.getPid12_CountyCode().setValue(patient.getNativityType());

				pid.getPid13_PhoneNumberHome(0).setValue(HMSUtil.convertPhoneNumberToHL7(patient.getMobileNumber())); //added by amit das on 01-08-2016

				if(patient.getBloodGroup()!=null){
                pid.getPid14_PhoneNumberBusiness(0).setValue(patient.getBloodGroup().getId()+"");
                }
				pid.getPid15_LanguagePatient().setValue(patient.getIdNo());
				if(patient.getMaritalStatus()!=null){
                pid.getPid16_MaritalStatus().setValue(patient.getMaritalStatus().getId()+"");
                }
				if(patient.getReligion()!=null){
                pid.getPid17_Religion().setValue(patient.getReligion().getId()+"");
                }
				if(patient.getOtpNumber()!=null){
                    pid.getPid18_PatientAccountNumber().getCk1_IDNumber().setValue(patient.getOtpNumber()+"");
                }

				if(patient.getCurrentVisitNo()!=null){
                pid.getPid19_SocialSecurityNumberPatient().setValue(patient.getCurrentVisitNo()+"");
            }
				if(patient.getIdCard()!=null){
                    pid.getPid20_DriverSLicenseNumberPatient().getCm_license_no1_LicenseNumber().setValue(patient.getIdCard().getId()+"");
                }
				if(patient.getRelation()!=null){
                    pid.getPid21_MotherSIdentifier().getCk1_IDNumber().setValue(patient.getRelation().getId()+"");
                }
				pid.getPid22_EthnicGroup().setValue(patient.getRegTime());
				pid.getPid23_BirthPlace().setValue(patient.getNotionalDobStatus());

				if(patient.getRegDate()!=null){
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    pid.getPid24_MultipleBirthIndicator().setValue(formatter.format(patient.getRegDate()));
                }

				pid.getPid25_BirthOrder().setValue(patient.getYearOfBirth());
				if(patient.getHospital()!=null){
                  pid.getPid26_Citizenship(0).setValue(patient.getHospital().getId()+"");
              }


				PV1 pv1 = adt1.getPV1();

				pv1.getPv15_PreadmitNumber().setValue(visit.getPriorityNumber()+"");
				if(visit.getUnit()!=null){
                    pv1.getPv16_PriorPatientLocation().getCm_internal_location1_NurseUnitStation().setValue(visit.getUnit().getId()+"");
                }
				pv1.getPv17_AttendingDoctor().getCn1_IDNumber().setValue(visit.getAddEditBy().getId()+"");
				if(visit.getDoctor()!=null){
                    pv1.getPv18_ReferringDoctor().getIDNumber().setValue(visit.getDoctor().getId()+"");
                }
				if(visit.getHospital()!=null){
                    pv1.getPv110_HospitalService().setValue(visit.getHospital().getId()+"");
                }
				pv1.getPv111_TemporaryLocation().getCm_internal_location1_NurseUnitStation().setValue(visit.getTotalHospitalVisit()+"");
				if(visit.getDiagnosis()!=null){
                     pv1.getPv112_PreadmitTestIndicator().setValue(visit.getDiagnosis().getId()+"");
                }
				if(visit.getComplaint()!=null){
                    pv1.getPv113_ReadmissionIndicator().setValue(visit.getComplaint().getId()+"");
                }
				pv1.getPv114_AdmitSource().setValue(visit.getEdStatus()+"");
				pv1.getPv115_AmbulatoryStatus(0).setValue(visit.getVisitStatus()+"");
				pv1.getPv116_VIPIndicator().setValue(visit.getTokenNo()+"");
				if(visit.getHin()!=null){
                    pv1.getPv118_PatientType().setValue(visit.getHin().getId()+"");
                }

				pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue(visit.getVisitNo()+"");
				pv1.getPv122_CourtesyCode().setValue(visit.getCurPharVisitStatus()+"");
				pv1.getPv123_CreditRating().setValue(visit.getStatus()+"");
				pv1.getPv124_ContractCode(0).setValue(visit.getAppointmentType()+"");
				if(visit.getAddEditDate()!=null){
                    pv1.getPv125_ContractEffectiveDate(0).setValue(visit.getAddEditDate()+"");
                }
				if(visit.getAddEditTime()!=null){
                    pv1.getPv127_ContractPeriod(0).setValue(visit.getAddEditTime()+"");
                }


				if(visit.getCaseType()!=null){
                    pv1.getPv139_ServicingFacility().setValue(visit.getCaseType().getId()+"");
                }
				if(visit.getDepartment()!=null){
                    pv1.getPv140_BedStatus().setValue(visit.getDepartment().getId()+"");
                }
				if(visit.getVisitDate()!=null){
                    pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(convertDatetoString(visit.getVisitDate())+"");
                }

				if(visit.getVisitTime()!=null){
                    pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().setValue(visit.getVisitTime()+"");
                }

				pv1.getPv117_AdmittingDoctor().getCn3_GivenName().setValue(visit.getDisplayAfterNo()+"");
				pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().setValue(visit.getCreationSource());

				if(opBillHeader!=null){
                pv1.getPv14_AdmissionType().setValue(opBillHeader.getStatus()+"");
                if(opBillHeader.getDiscountAmt()!=null){
                    pv1.getPv146_CurrentPatientBalance().setValue(opBillHeader.getDiscountAmt()+"");
                }
                if(opBillHeader.getBillAmt()!=null){
                    pv1.getPv147_TotalCharges().setValue(opBillHeader.getBillAmt()+"");
                }

                if(opBillHeader.getAdvanceAdjustment()!=null){
                    pv1.getPv148_TotalAdjustments().setValue(opBillHeader.getAdvanceAdjustment()+"");
                }
                if(opBillHeader.getActualCollectedAmt()!=null){
                    pv1.getPv149_TotalPayments().setValue(opBillHeader.getActualCollectedAmt()+"");
                }
                if(opBillHeader.getBillNo()!=null){
                    pv1.getPv150_AlternateVisitID().getIDNumber().setValue(opBillHeader.getBillNo());
                }
                }
				// added by amit das on 16-03-2017
				if(visit.getVisitSession()!=null)
                        pv1.getPv117_AdmittingDoctor().getCn8_SourceTableId().setValue(visit.getVisitSession().getId()+"");

				// added by amit das on 25-07-2017
				pv1.getPv117_AdmittingDoctor().getCn3_GivenName().setValue(visit.getDisplayAfterNo()+"");

				// added by amit das on 29-08-2017
				if(visit.getCreationSource()!=null)
                    pv1.getPv117_AdmittingDoctor().getCn2_FamilyName().setValue(visit.getCreationSource());

				PV2 pv2=adt1.getPV2();
				pv2.getPv27_VisitUserCode().setValue(queue.getTokenStatus());

				if(opBillDetails!=null){

                pv2.getPv25_PatientValuables(0).setValue(opBillDetails.getRate()+"");
                pv2.getPv26_PatientValuablesLocation().setValue(opBillDetails.getAmount()+"");
                pv2.getPv22_AccommodationCode().getCe1_Identifier().setValue(opBillDetails.getRefundableStatus()+"");
                if(opBillDetails.getDiscountPercent()!=null){
                    pv2.getPv23_AdmitReason().getCe2_Text().setValue(opBillDetails.getDiscountPercent()+"");
                }if(opBillDetails.getDiscountAmt()!=null){
                    pv2.getPv24_TransferReason().getCe2_Text().setValue(opBillDetails.getDiscountAmt()+"");
                }
                if(opBillDetails.getChargeCode()!=null){
                    pv2.getPv21_PriorPendingLocation().getBedStatus().setValue(opBillDetails.getChargeCode().getId()+"");
                }

                }
				// Populate the ORC
				ORC orc = orderObservation.getORC();
				orc.getOrc1_OrderControl().setValue("NW"); // New
				orc.getDateTimeOfTransaction()
                        .getTs1_TimeOfAnEvent()
                        .setValue(now("yyyyMMdd") + now("Hmmss"));
				OBR obr = orderObservation.getOBR();
				obr.getObr36_ScheduledDateTime().getTs1_TimeOfAnEvent().setValue(now("yyyyMMdd") + now("HHmmss"));

				logger.debug(adt1);

				adt_A01List.add(adt1); // added by amit das on 19-12-2016
				returnMessage="success";

			} catch (Exception s) {
				s.printStackTrace();
				returnMessage="fail";
				logger.debug("SQL query does not execute." + s);
			}  
		} catch (Exception e) {
			returnMessage="fail";
			e.printStackTrace();
		}
	}
		
		returnMap.put("ADTMessage", adt_A01List); // added by amit das on 19-12-2016

		returnMap.put("message", returnMessage);
		return returnMap;
	}

	private String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

	private String convertDatetoString(Date DOB) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(DOB);
	}


	@Override
	public Map<String, Object> updatePincodeByDistrict(Map<String, Object> map) {
		logger.debug("Inside Method: updatePincodeByDistrict");
		Session session = (Session) getSession();
		int districtId = 0;
		Criteria crt=null;
		
		if(null != map.get("districtId")){
			districtId=(Integer)map.get("districtId");
		}
		List<MasPostCode> masPostCodeList = new ArrayList<>();
		
		crt = session.createCriteria(MasPostCode.class).createAlias("DistrictId", "dist")
				.add(Restrictions.eq("dist.Id", districtId));
		masPostCodeList=crt.list();
		for(MasPostCode m:masPostCodeList){
			logger.debug("$$$$$ "+m.getPostCodeName());
		}
		
		map.put("masPostCodeList", masPostCodeList);
		return map;
	}

	@Override
	public Map<String, Object> showPatientInvestigationApp(int hospitalId) {

		logger.debug("Inside Method: showPatientInvestigationApp");

		Map<String, Object> map = new HashMap<>();

		Session session = (Session) getSession();

		List<Object[]> appInvestList= new ArrayList<>();

		Criteria crt=null;
		Date currentInvestigationDate=new Date();
		
		crt=session.createCriteria(AppInvestigationAppointments.class).createAlias("Equipment", "equ").createAlias("Department", "dep")
				.add(Restrictions.eq("InvestigationStatus", "y").ignoreCase()).createAlias("Hin", "hin").createAlias("hin.Sex", "sex")
				.add(Restrictions.eq("InvestigationDate", currentInvestigationDate)).createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Hospital.Id", hospitalId));
		ProjectionList projectionl=Projections.projectionList();
		projectionl.add(Projections.property("hin.Id"));
		projectionl.add(Projections.property("hin.FullName"));
		projectionl.add(Projections.property("hin.HinNo"));
		projectionl.add(Projections.property("sex.AdministrativeSexName"));
		
		projectionl.add(Projections.property("InvestigationDate"));
		projectionl.add(Projections.property("equ.Nomenclature"));
		projectionl.add(Projections.property("hin.Age"));
		projectionl.add(Projections.property("dep.Id"));
		projectionl.add(Projections.property("dep.DepartmentName"));
		
		projectionl.add(Projections.groupProperty("dep.Id"));
		projectionl.add(Projections.groupProperty("hin.Id"));
		projectionl.add(Projections.groupProperty("sex.AdministrativeSexName"));
		projectionl.add(Projections.groupProperty("equ.Nomenclature"));
		projectionl.add(Projections.groupProperty("InvestigationDate"));
		crt.setProjection(projectionl);
		
		appInvestList=crt.list();
		
		map.put("appInvest", appInvestList);
		
		
		List<MasComplaint> complaintList = new ArrayList<>();
		List<MasDepartment> departmentList = new ArrayList<>();
		List<Object[]> doctorList = new ArrayList<>();
		List<MasCaseType> caseTypeList = new ArrayList<>();
		List<MasRelation> relationList = new ArrayList<>();
		List<MasAdministrativeSex> sexList = new ArrayList<>();
		List<MasPatientType> patientTypeList = new ArrayList<>();
		List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
		List<MasChargeCode> chargeCodeList = new ArrayList<>();
		List<MasAuthorizer> authorizerList = new ArrayList<>();
		List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
		List<MasSession> masSessionList = new ArrayList<>();

		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
				.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		

		patientTypeList = session.createCriteria(MasPatientType.class)

		.add(Restrictions.eq("Status", "Y")).list();

		complaintList = session.createCriteria(MasComplaint.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		



nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
.setProjection(Projections.property("Department"))
.add(Restrictions.eq("Institute.Id",hospitalId))
.add(Restrictions.eq("Status","y").ignoreCase())
.createAlias("Department", "dep")
.createAlias("dep.DepartmentType","DepartmentType")
.add(Restrictions.ne("DepartmentType.Id",1))
.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
.addOrder(Order.asc("dep.DepartmentName"))
.list();

		
		doctorList=session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital").
				createAlias("EmployeeType", "EmployeeType").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("EmployeeType.Id", 1)).list();


		caseTypeList = session.createCriteria(MasCaseType.class)
				.addOrder(Order.asc("Id")).add(Restrictions.eq("Status", "Y"))
				.list();

		diagnosisList = session.createCriteria(MasDiagnosisConclusion.class)
				.addOrder(Order.asc("DiagnosisConclusionName"))
				.add(Restrictions.eq("Status", "Y")).list();

		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationName"))
				.add(Restrictions.eq("Status", "Y")).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y")).list();
		
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chargeType")
				.addOrder(Order.asc("ChargeCodeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("chargeType.Id", 9)).list();

		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "Y"))
				.addOrder(Order.asc("AuthorizerName")).list();

		map.put("complaintList", complaintList);
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("relationList", relationList);
		map.put("patientTypeList", patientTypeList);
		map.put("sexList", sexList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("masSessionList", masSessionList);
		map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		
		return map;
	}

	@Override
	public String getDepartmentNameList(String substring) {
		logger.debug("Inside Method: getDepartmentNameList");
		StringBuilder department= new StringBuilder();
		Session session=(Session)getSession();
		if(substring!=null && substring.length()>=2){ // added by amit das on 2-7-2016
		// logger.debug("substring.substring(1,substring.length()-1) "+substring.substring(1,substring.length()-1));
		String query="select department_name from mas_department where department_id in ("+substring.substring(1,substring.length())+")";
		List<String>aList= new ArrayList<>();
		aList=session.createSQLQuery(query).list();
		for(String depart:aList){
			department = new StringBuilder("'" + department + "'," + depart);
		}
		}
		return department.toString();
	}

	private void patientDemographicalChangeInPacs(int hinId) throws IOException {
		logger.debug("Inside Method: patientDemographicalChangeInPacs");

		Session session = (Session) getSession();
		logger.debug("in patientDemographicalChangeInPacs method");

		logger.debug("----");

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jktPacs.properties");

		Properties pacProper = new Properties();
		pacProper.load(new FileInputStream(new File(resourcePath.getFile())));

		if (pacProper.getProperty("PACS_URL") != null && pacProper.getProperty("PACS_PORT") != null) {
			int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));

			LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
			PipeParser parser = new PipeParser(); // The message parser
			SimpleServer server = new SimpleServer(port, llp, parser);
		
			Application handler = new ExampleReceiverApplication();
			server.registerApplication("ADT", "A08", handler);
		   
			server.registerApplication("ADT", "A02", handler);
			server.registerApplication("ORM", "O01", handler);
		 

			logger.debug("server main " + server);

			try {
				ca.uhn.hl7v2.app.Connection connection = null;
				try {
					Patient patient = null;


					patient = (Patient) session.get(Patient.class, hinId);

					Date DOB = null;
					Date DOA = null;
					String TOA = null;
					String adtym = "";
					String doa_val = null;

					if (patient != null) {

						logger.debug("Hin Id>>" + hinId);

						ADT_A08 adt1 = new ADT_A08();
						ORU_R01 message1 = new ORU_R01();

						message1.getMSH().getEncodingCharacters().setValue("^~\\&");
						message1.getMSH().getFieldSeparator().setValue("|");

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
						mshSegment.getMsh7_DateTimeOfMessage().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd") + HMSUtil.now("Hmmss"));
						mshSegment.getMsh9_MessageType().getCm_msg1_MessageType().setValue("ADT");
						mshSegment.getMsh9_MessageType().getCm_msg2_TriggerEvent().setValue("A08");
						//mshSegment.getMsh10_MessageControlID().setValue("1001");
						mshSegment.getMsh10_MessageControlID().setValue("" + hinId);
						mshSegment.getMsh11_ProcessingID().setValue("P");
						mshSegment.getMsh12_VersionID().setValue("2.2");
						DOB = patient.getDateOfBirth();//res.getDate("date_of_birth");
						String abc = HMSUtil.convertDatetoString(DOB);


						// Populate the PID Segment
						PID pid = adt1.getPID();
						pid.getPid3_PatientIDInternalID(0).getCm_pat_id1_IDNumber().setValue("" + hinId);
						pid.getPid4_AlternatePatientID().setValue("" + hinId);
						pid.getPid5_PatientName().getFamilyName().setValue("" + patient.getPLastName());
						pid.getPid5_PatientName().getGivenName().setValue("" + patient.getPFirstName());
						pid.getPid7_DateOfBirth().getTs1_TimeOfAnEvent().setValue(abc);
						String sexCode = "";
						if (patient.getSex() != null && patient.getSex().getAdministrativeSexCode() != null) {
							sexCode = patient.getSex().getAdministrativeSexCode();
						}
						pid.getPid8_Sex().setValue(sexCode);

						PV1 pv1 = adt1.getPV1();
						String pTypeCode = "";
						if (patient.getPatientType() != null && patient.getPatientType().getPatientTypeCode() != null) {
							pTypeCode = patient.getPatientType().getPatientTypeCode();
						}
						pv1.getPv12_PatientClass().setValue(pTypeCode);
						String emPenNo = "";
						if (patient.getEmp() != null && patient.getEmp().getPEN() != null) {
							emPenNo = patient.getEmp().getPEN();
						}
						pv1.getPv18_ReferringDoctor().getIDNumber().setValue(emPenNo);

						pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().setValue("");
						if (patient.getPatientType() != null && patient.getPatientType().getPatientTypeCode().equalsIgnoreCase("IP")) {
							Inpatient inpatient = (Inpatient) session.get(Inpatient.class, hinId);
							if (inpatient.getDateOfAddmission() != null || inpatient.getTimeOfAddmission() != null) {
								DOA = inpatient.getDateOfAddmission();
								TOA = inpatient.getTimeOfAddmission();

								TOA = TOA.substring(0, 2).concat(TOA.substring(3));
								doa_val = HMSUtil.convertDatetoString(DOA);

								adtym = adtym.concat(doa_val).concat(TOA);
								pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);
							}
						} else { // for OP

							DOA = patient.getAddEditDate();
							TOA = patient.getAddEditTime();

							TOA = TOA.substring(0, 2).concat(TOA.substring(3));

							doa_val = HMSUtil.convertDatetoString(DOA);

							adtym = adtym.concat(doa_val).concat(TOA);
							pv1.getPv144_AdmitDateTime().getTimeOfAnEvent().setValue(adtym);


						}

						EVN evn = adt1.getEVN();
						evn.getEvn1_EventTypeCode().setValue("A08");
						evn.getEvn2_DateTimeOfEvent().getTimeOfAnEvent().setValue(HMSUtil.now("yyyyMMdd") + HMSUtil.now("Hmmss"));
						Parser p1 = new PipeParser();
						String encodedMessage = p1.encode(adt1);
						String encMsg = p1.encode(message1);
						String newString = encMsg.substring(8);
						logger.debug("adt1 Message");
						logger.debug(adt1);
						logger.debug("message1");
						logger.debug(message1);
						logger.debug("encMsg");
						logger.debug(encMsg);
						logger.debug("encodedMessage");
						logger.debug(encodedMessage);
						logger.debug("newString");
						logger.debug(newString);

						Parser p = new GenericParser();

						Message adt = p.parse(encodedMessage + newString);

						logger.debug("adt");
						logger.debug(adt);

						// The connection hub connects to listening servers
						ConnectionHub connectionHub = ConnectionHub.getInstance();
						String pacsServer = pacProper.getProperty("PACS_URL");

						logger.debug(pacProper.getProperty("PACS_URL"));

						connection = connectionHub.attach(pacsServer, port, new PipeParser(), MinLowerLayerProtocol.class);

						Initiator initiator = connection.getInitiator();
						System.setProperty("ca.uhn.hl7v2.app.initiator.timeout",
								Integer.toString(6000000));

						Message response = initiator.sendAndReceive(adt);

						String responseString = parser.encode(response);

						logger.debug("Received response:\n" + responseString);


						Parser response_parser = new GenericParser();
						Message hapiMsg;
						try {
							hapiMsg = response_parser.parse(responseString);

							if (hapiMsg instanceof ACK) {
								ACK ack = (ACK) hapiMsg;

								logger.debug("Recieve acknowledge");

								logger.debug("inside ach msh " + ack.getMSH().getMsh7_DateTimeOfMessage().getTs1_TimeOfAnEvent());
								logger.debug("inside ach msh " + ack.getMSH().getMsh9_MessageType().getCm_msg1_MessageType());
								logger.debug("inside ach msh " + ack.getMSH().getMsh10_MessageControlID());
								logger.debug("inside ach msh " + ack.getMSH().getMsh11_ProcessingID());
								logger.debug("inside ach msh " + ack.getMSH().getMsh12_VersionID());
								logger.debug("**********************************************************");
								logger.debug("inside ach msa  " + ack.getMSA().getMsa1_AcknowledgementCode().getValue());
								logger.debug("inside ach msa  " + ack.getMSA().getMsa2_MessageControlID());
								logger.debug("inside ach msa  " + ack.getMSA().getMsa3_TextMessage().getValue());
								logger.debug("**********************************************************");
								logger.debug("inside ach err1  " + ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue());
								logger.debug("inside ach err2  " + ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe1_Identifier());
								logger.debug("inside ach err3  " + ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe3_NameOfCodingSystem());

								if (ack.getMSA().getMsa1_AcknowledgementCode().getValue().equalsIgnoreCase("AA")
										&& ack.getMSA().getMsa3_TextMessage().getValue() == null
										&& ack.getERR().getErr1_ErrorCodeAndLocation(0).getCm_eld4_CodeIdentifyingError().getCe2_Text().getValue() == null) {
									logger.debug("updated patient demographical at pacs system");

									logger.debug("update2 ");
								}

							} else {
								logger.debug("exit");
							}
						}

						catch (HL7Exception e) {
							e.printStackTrace();
						}
					}
				} finally {

					server.stop();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

@Override
public Map<String, Object> showPaitentDetail(String uhid) {
	logger.debug("Inside Method: showPaitentDetail");
	Map<String, Object> objectMap= new HashMap<>();
	PatientAddress patientAddress=null;
	UploadDocuments uploadDocuments=null;
	Patient patient=null;
	Session session=(Session) getSession();
	patientAddress=(PatientAddress)session.createCriteria(PatientAddress.class)
			.createAlias("Hin", "p")
			.createAlias("AddressType", "AT")
			.add(Restrictions.eq("p.HinNo", uhid))
			.add(Restrictions.eq("AT.AddressTypeCode", "p").ignoreCase())
			.uniqueResult();
	patient=(Patient)session.createCriteria(Patient.class)
			.add(Restrictions.eq("HinNo", uhid))
			.uniqueResult();
	if( patient!=null){
		uploadDocuments=(UploadDocuments)session.createCriteria(UploadDocuments.class)
				.add(Restrictions.eq("Hin.Id", patient.getId()))
				.uniqueResult();
	}
	objectMap.put("paitentAddress", patientAddress);
	objectMap.put("paitent", patient);
	objectMap.put("uploadDocument", uploadDocuments);
	return objectMap;
}

	@Override
	public Map<String, Object> getHospital(int hospitalId) {
		logger.debug("Inside Method: getHospital");
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		MasHospital hospital=null;
		hospital=(MasHospital)session.get(MasHospital.class, hospitalId);
		if(hospital!=null){
			dataMap.put("hospital", hospital);
		}
		return dataMap;
	}

private void savePatientDataForRegistrationToCentralServer(Map<String, Object> map){
	logger.debug("Inside Method: savePatientDataForRegistrationToCentralServer");
	String message="failure";
	Patient patient=(Patient)map.get("patientObj");
	MasHospital hospital=(MasHospital)map.get("hospital");
	int tsn=(Integer)map.get("tsn");
	StringBuilder insertPatientFilds = new StringBuilder();
	insertPatientFilds.append(patient.getPatientStatus()).append(" |");
	insertPatientFilds.append(patient.getAddEditDate()).append(" |");
	insertPatientFilds.append(patient.getAddEditTime()).append(" |"); 
	insertPatientFilds.append(patient.getAadhaarNo()).append(" |");
	insertPatientFilds.append(patient.getHinNo()).append(" |");
	insertPatientFilds.append(patient.getFullName()).append(" |");
	insertPatientFilds.append(patient.getPFirstName()).append(" |");
	insertPatientFilds.append(patient.getFatherMotherName()).append(" |");
	insertPatientFilds.append(patient.getDateOfBirth()).append(" |");
	insertPatientFilds.append(patient.getAge()).append(" |"); 
	if(patient.getPatientType()!=null){
		insertPatientFilds.append(patient.getPatientType().getId());
	}
	insertPatientFilds.append(" |"); 
	if(patient.getSex()!=null){
		insertPatientFilds.append(patient.getSex().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getBplStatus()).append(" |");
	insertPatientFilds.append(patient.getNativityType()).append(" |");
	insertPatientFilds.append(patient.getMobileNumber()).append(" |");
	if(patient.getBloodGroup()!=null){
		insertPatientFilds.append(patient.getBloodGroup().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getIdNo()).append(" |");
	if(patient.getMaritalStatus()!=null){
		insertPatientFilds.append(patient.getMaritalStatus().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getReligion()!=null){
		insertPatientFilds.append(patient.getReligion().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getOtpNumber()).append(" |");
	insertPatientFilds.append(patient.getCurrentVisitNo()).append(" |");
	if(patient.getIdCard()!=null){
		insertPatientFilds.append(patient.getIdCard().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getRelation()!=null){
		insertPatientFilds.append(patient.getRelation().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getRegTime()).append(" |");
	insertPatientFilds.append(patient.getNotionalDobStatus()).append(" |");
	insertPatientFilds.append(patient.getRegDate()).append(" |");
	insertPatientFilds.append(patient.getYearOfBirth()).append(" |");
	if(patient.getHospital()!=null){
		insertPatientFilds.append(patient.getHospital().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getAddEditBy()!=null){
		insertPatientFilds.append(patient.getAddEditBy().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(tsn).append(" |");
	String dataOfPatient=insertPatientFilds.toString();
	logger.debug("patient reg data from server>>>>>>>> ");
	logger.debug(dataOfPatient);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	CentralServerPatientRegData centralServerPatientRegData=new CentralServerPatientRegData();
	centralServerPatientRegData.setPaitentRegData(dataOfPatient);
	centralServerPatientRegData.setLeanRegId(Long.parseLong(patient.getId().toString()));
	String patientNotUploadToServer="N";
	centralServerPatientRegData.setStatus(patientNotUploadToServer);
	centralServerPatientRegData.setHospitalId(Long.parseLong(hospital.getId().toString()));
	hbt.save(centralServerPatientRegData);
	hbt.flush();
	hbt.clear();
	logger.debug("patient reg data save successfuly at central server patient reg data table");
}

private void savePatientDataForRegistrationToLeanServer(Map<String, Object> map){
	String message="failure";
	String patientNotUploadToLeanServer = "N";
	StringBuilder sb = new StringBuilder();
	URLConnection connection = null;
	InputStreamReader in = null; 
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	Patient patient=(Patient)map.get("patientObj");
	MasHospital hospital=(MasHospital)map.get("hospital");
	int tsn=(Integer)map.get("tsn");
	StringBuilder insertPatientFilds = new StringBuilder();
	insertPatientFilds.append(patient.getPatientStatus()).append(" |");
	insertPatientFilds.append(patient.getAddEditDate()).append(" |");
	insertPatientFilds.append(patient.getAddEditTime()).append(" |"); 
	insertPatientFilds.append(patient.getAadhaarNo()).append(" |");
	insertPatientFilds.append(patient.getHinNo()).append(" |");
	insertPatientFilds.append(patient.getFullName()).append(" |");
	insertPatientFilds.append(patient.getPFirstName()).append(" |");
	insertPatientFilds.append(patient.getFatherMotherName()).append(" |");
	insertPatientFilds.append(patient.getDateOfBirth()).append(" |");
	insertPatientFilds.append(patient.getAge()).append(" |"); 
	if(patient.getPatientType()!=null){
		insertPatientFilds.append(patient.getPatientType().getId());
	}
	insertPatientFilds.append(" |"); 
	if(patient.getSex()!=null){
		insertPatientFilds.append(patient.getSex().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getBplStatus()).append(" |");
	insertPatientFilds.append(patient.getNativityType()).append(" |");
	insertPatientFilds.append(patient.getMobileNumber()).append(" |");
	if(patient.getBloodGroup()!=null){
		insertPatientFilds.append(patient.getBloodGroup().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getIdNo()).append(" |");
	if(patient.getMaritalStatus()!=null){
		insertPatientFilds.append(patient.getMaritalStatus().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getReligion()!=null){
		insertPatientFilds.append(patient.getReligion().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getOtpNumber()).append(" |");
	insertPatientFilds.append(patient.getCurrentVisitNo()).append(" |");
	if(patient.getIdCard()!=null){
		insertPatientFilds.append(patient.getIdCard().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getRelation()!=null){
		insertPatientFilds.append(patient.getRelation().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(patient.getRegTime()).append(" |");
	insertPatientFilds.append(patient.getNotionalDobStatus()).append(" |");
	insertPatientFilds.append(patient.getRegDate()).append(" |");
	insertPatientFilds.append(patient.getYearOfBirth()).append(" |");
	if(patient.getHospital()!=null){
		insertPatientFilds.append(patient.getHospital().getId());
	}
	insertPatientFilds.append(" |");
	if(patient.getAddEditBy()!=null){
		insertPatientFilds.append(patient.getAddEditBy().getId());
	}
	insertPatientFilds.append(" |");
	insertPatientFilds.append(tsn).append(" |");
	String msg=insertPatientFilds.toString();
	try{
		msg=msg.replace("&", "$");
		msg=msg.replaceAll("[\r\n]", "*");
		String encode=URLEncoder.encode(msg,"UTF-8");
		String header="http://"+hospital.getClientIp()+":"+hospital.getClientPort(); 
		 
		String uri=header+"/hms/hms/registration?method=saveClientRegisterPatientToServer&message="
					+encode+"&hospitalId="+hospital.getId();
		logger.debug("Url>>>>"+uri);
		 URL url=new URL(uri);
		 connection=url.openConnection();
		 if (connection != null && connection.getInputStream() != null) {
				in = new InputStreamReader(connection.getInputStream(),
						Charset.defaultCharset());
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
			if (responseMsg
					.contains("success")) {
				 logger.debug("patient reg data save successfuly at lean server patient reg data table");
				 patientNotUploadToLeanServer = "Y";
			}
			
			logger.debug("Input Stream: " + sb.toString());
		}catch (MalformedURLException e) {
			logger.debug("MalformedURLException in Patient Registration Data To Lean Server");
		} catch (ConnectException e) {
			logger.debug("Connection refused in Patient Registration Data To Lean Server");
		}
		catch (IOException e) {
			logger.debug("IOException in Patient Registration Data To Lean Server");
		}
	
	 	LeanServerPatientRegData leanServerPatientRegData=new LeanServerPatientRegData();
		leanServerPatientRegData.setPaitentRegData(msg);
		leanServerPatientRegData.setLeanRegId(Long.parseLong(patient.getId().toString()));
		leanServerPatientRegData.setStatus(patientNotUploadToLeanServer);
		leanServerPatientRegData.setHospitalId(Long.parseLong(hospital.getId().toString()));
		hbt.save(leanServerPatientRegData);
	
}

@Override
public Map<String, Object> saveClientRegisterPatientToServer(Box box) {
	Session session=(Session)getSession();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	//String data = "Out Patient |Mon Feb 29 00:00:00 IST 2016 |16:35 |123456213456 |123456213456 |Central1 |Central1 |null |Mon Jan 01 00:00:00 IST 1990 |26 Years |3 |3 |y |null |null | |null | | |null |null | |2 |16:38 |y |Mon Feb 29 16:38:08 IST 2016 |1990 |1 |432 |";
	String data=box.get("message");
	data = data.replace("null", SPACE);
	String hinNo = null;
	List<Patient> existPatientList = null;
	String array[] = data.split("\\|");
	for (String anArray : array) {
		logger.debug(anArray);
	}
	Transaction tx=null;
	try{
		tx=session.beginTransaction();

	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Patient patient = new Patient();
	int index = 0;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setPatientStatus(array[index].trim());
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setAddEditDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(array[index].trim()));
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setAddEditTime(array[index].trim());
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setAadhaarNo(Long.parseLong(array[index].trim()));
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		hinNo =	array[index].trim();
		existPatientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo)).list();
		patient.setHinNo(hinNo);
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setFullName(array[index]);
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setPFirstName(array[index].trim());
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setFatherMotherName(array[index].trim());
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setDateOfBirth(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(array[index]));
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		patient.setAge(array[index].trim());
	}
	index++;
	if (array[index] != null && !"".equals(array[index].trim())) {
		MasPatientType patientType = new MasPatientType(Integer.parseInt(array[index].trim()));
		patient.setPatientType(patientType);
	}
	index++;

			if (array[index] != null && !"".equals(array[index].trim())) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex(
						Integer.parseInt(array[index].trim()));
				patient.setSex(administrativeSex);
			}
			index++;

			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setBplStatus(array[index].trim());
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setNativityType(array[index].trim());
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setMobileNumber(array[index].trim());
			}
			index++;

			if (array[index] != null && !"".equals(array[index].trim())) {
				MasBloodGroup bloodGroup = new MasBloodGroup(
						Integer.parseInt(array[index].trim()));
				patient.setBloodGroup(bloodGroup);
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setIdNo(array[index].trim());
			}

			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				MasMaritalStatus maritalStatus = new MasMaritalStatus(
						Integer.parseInt(array[index].trim()));
				patient.setMaritalStatus(maritalStatus);
			}

			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				MasReligion masReligion = new MasReligion(
						Integer.parseInt(array[index].trim()));
				patient.setReligion(masReligion);
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setOtpNumber(Integer.parseInt(array[index].trim()));
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setCurrentVisitNo(Integer.parseInt(array[index].trim()));
			}

			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				MasIdCard idCard = new MasIdCard(Integer.parseInt(array[index]
						.trim()));
				patient.setIdCard(idCard);
			}
			index++;

			if (array[index] != null && !"".equals(array[index].trim())) {
				MasRelation masRelation = new MasRelation(
						Integer.parseInt(array[index].trim()));
				patient.setRelation(masRelation);
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setRegTime(array[index].trim());
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setNotionalDobStatus(array[index].trim());
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setRegDate(HMSUtil
						.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(array[index].trim()));
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				patient.setYearOfBirth(array[index].trim());
			}

			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				MasHospital masHospital = new MasHospital(
						Integer.parseInt(array[index].trim()));
				patient.setHospital(masHospital);
			}
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				Users users = new Users(Integer.parseInt(array[index].trim()));
				patient.setAddEditBy(users);
			}
			int tsn = 0;
			index++;
			if (array[index] != null && !"".equals(array[index].trim())) {
				tsn = Integer.parseInt(array[index].trim());
			}
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");

			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			Criteria crt = session.createCriteria(MasState.class).add(
					Restrictions.like("StateName", "kerala" + "%").ignoreCase());
			List<MasState> statelist = crt.list();
			MasState masState = null;
			if (statelist != null && statelist.size() > 0) {
				masState = statelist.get(0);
			}
			int aadhaarAddressTypeId = Integer.parseInt(properties.getProperty("aadhaarAddressTypeId"));
			int permanentAddressTypeId = Integer.parseInt(properties.getProperty("permanentAddressTypeId"));
			int temporaryAddressTypeId = Integer.parseInt(properties.getProperty("temporaryAddressTypeId"));

			PatientAddress aadharAddress = new PatientAddress();
			aadharAddress.setHin(patient);
			aadharAddress.setState(masState);
			MasAddressType addressType = new MasAddressType(aadhaarAddressTypeId);
			aadharAddress.setAddressType(addressType);

			PatientAddress permanentAddress = new PatientAddress();
			permanentAddress.setHin(patient);
			permanentAddress.setState(masState);
			MasAddressType addressType1 = new MasAddressType(permanentAddressTypeId);
			permanentAddress.setAddressType(addressType1);

			PatientAddress temporaryAddress = new PatientAddress();
			temporaryAddress.setHin(patient);
			temporaryAddress.setState(masState);
			MasAddressType addressType2 = new MasAddressType(temporaryAddressTypeId);
			temporaryAddress.setAddressType(addressType2);

			List<TransactionSequence> adList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "HIN")).list();
			TransactionSequence transactionSequence = null;
			if (adList != null && adList.size() > 0) {
				transactionSequence = adList.get(0);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String curDate = sdf.format(date);
				Date currentDate = null;
				try {
					currentDate = sdf.parse(curDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (currentDate.compareTo(transactionSequence.getLastChgDate()) > 0) {
					transactionSequence.setTransactionSequenceNumber(1);
					transactionSequence.setLastChgDate(date);
				} else if (tsn != 0 && tsn > transactionSequence.getTransactionSequenceNumber()) {
					transactionSequence.setTransactionSequenceNumber(tsn + 1);
				} else {
					transactionSequence.setTransactionSequenceNumber(transactionSequence.getTransactionSequenceNumber() + 1);
				}

				transactionSequence.setLastChgDate(new Date());

			}

			if (existPatientList == null || existPatientList.size() == 0) {
				hbt.save(patient);
				hbt.save(aadharAddress);
				hbt.save(permanentAddress);
				hbt.save(temporaryAddress);
				if (transactionSequence != null) {
					hbt.save(transactionSequence);
				}
			}
			hbt.flush();
			hbt.clear();
			tx.commit();
			dataMap.put("success", "success");
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
			dataMap.put("failure", "failure");
		} finally {
			session.close();
		}


		return dataMap;
	}


@Override
public Map<String, Object> getPatientRegistrationDataForServer() {
	    logger.debug("Inside Method: getPatientRegistrationDataForServer");
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(CentralServerPatientRegData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<CentralServerPatientRegData> centralServerPatientRegData=criteria.list();
		
		MasHospital masHospital=null;
		if(centralServerPatientRegData!=null && centralServerPatientRegData.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(centralServerPatientRegData.get(0).getHospitalId().toString())); 
			dataMap.put("centralServerPatientRegData", centralServerPatientRegData);
		}
		if(masHospital!=null){
			dataMap.put("masHospital", masHospital);
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
public Map<String, Object> getPatientRegistrationDataForLeanServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerPatientRegData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerPatientRegData> leanServerPatientRegData=criteria.list();
		
		if(leanServerPatientRegData!=null && leanServerPatientRegData.size()>0){
			dataMap.put("leanServerPatientRegData", leanServerPatientRegData);
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
public Map<String, Object> getPatientVisitDataForLeanServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		
		try{
		Criteria criteria=session.createCriteria(LeanServerVisitData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerVisitData> leanServerVisitData=criteria.list();
		
		if(leanServerVisitData!=null && leanServerVisitData.size()>0){

			dataMap.put("leanServerVisitData", leanServerVisitData);
		}

		} catch (Exception e){
			e.printStackTrace();
		} finally {
		if(session!=null){
			session.close();
		}
		}
		return dataMap;
	}

@Override
public Map<String, Object> getPatientVisitDataForCentralServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(CentralServerVisitData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<CentralServerVisitData> centralServerVisitData=criteria.list();
		
		MasHospital masHospital=null;
		if(centralServerVisitData!=null && centralServerVisitData.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(centralServerVisitData.get(0).getHospitalId().toString())); 
			dataMap.put("centralServerVisitData", centralServerVisitData);
		}
		if(masHospital!=null){
			dataMap.put("masHospital", masHospital);
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
public Map<String, Object> getPatientVisitUpdateForLeanServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerVisitData.class)
				.add(Restrictions.eq("Status", "U").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerVisitData> leanServerVisitData=criteria.list();

		if(leanServerVisitData!=null && leanServerVisitData.size()>0){

			dataMap.put("leanServerVisitData", leanServerVisitData);
		}

		} catch(Exception e){
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
public Map<String, Object> getPatientVisitUpdateForCentralServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(CentralServerVisitData.class)
				.add(Restrictions.eq("Status", "U").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<CentralServerVisitData> centralServerVisitData=criteria.list();
		
		MasHospital masHospital=null;
		if(centralServerVisitData!=null && centralServerVisitData.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(centralServerVisitData.get(0).getHospitalId().toString()));
			dataMap.put("centralServerVisitData", centralServerVisitData);
		}
		if(masHospital!=null){
			dataMap.put("masHospital", masHospital);
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
public String updateCentralServerPatientRegData(
		CentralServerPatientRegData centralServerPatientRegData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientRegDataSavedToServer="Y";
	  	centralServerPatientRegData.setStatus(patientRegDataSavedToServer);
	  	hbt.update(centralServerPatientRegData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}

@Override
public String updateLeanServerPatientRegData(
		LeanServerPatientRegData leanServerPatientRegData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientRegDataSavedToLeanServer="Y";
	  	leanServerPatientRegData.setStatus(patientRegDataSavedToLeanServer);
	  	hbt.update(leanServerPatientRegData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}

@Override
public String updateLeanServerPatientVisitData(
		LeanServerVisitData leanServerVisitData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientVisitDataSavedToLeanServer="Y";
	  	leanServerVisitData.setStatus(patientVisitDataSavedToLeanServer);
	  	hbt.update(leanServerVisitData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}

@Override
public String updateCentralServerPatientVisitData(
		CentralServerVisitData centralServerVisitData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientVisitDataSavedToCentralServer="Y";
	  	centralServerVisitData.setStatus(patientVisitDataSavedToCentralServer);
	  	hbt.update(centralServerVisitData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}

@Override
public Map<String, Object> showNursingAppointmentList(Box box) {
	
	Map<String,Object> map= new HashMap<>();
	int hospitalId=0;
	hospitalId=box.getInt("hospitalId");

	Session session=(Session)getSession();
	List<MasSession> masSessionList = new ArrayList<>();
	masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
			.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
	
	List<MasDepartment> departmentList = new ArrayList<>();
	departmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
	
	List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
	nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.ne("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
	
	
	List<InjAppointmentHeader> InjectionList = new ArrayList<>();
	Criteria critApp = null;
	
	List<ProcedureDetails> procedureDetails = new ArrayList<>();
	procedureDetails = session.createCriteria(ProcedureDetails.class)
			.createAlias("ProcedureHeader", "procedureHeader")
			
			.add(Restrictions.isNull("procedureHeader.NewVisit.Id"))
			
			.add(Restrictions.eq("NextAppointmentDate", new Date()))
			.add(Restrictions.eq("Status", 'n').ignoreCase()).list();
	
	
	
	List<Integer> visitList = new ArrayList<Integer>(new HashSet());
	for(ProcedureDetails listA: procedureDetails)
	{
		logger.debug(listA.getProcedureHeader().getVisit().getId());
		visitList.add(listA.getProcedureHeader().getVisit().getId());
	}
	procedureDetails.clear();
			
logger.debug("visitList $%$% "+visitList.size());
	critApp = session.createCriteria(InjAppointmentDetails.class)
			.createAlias("InjAppointmentHeader", "injAph")
			.createAlias("injAph.Hospital", "h")
			.add(Restrictions.isNull("injAph.NewVisit.Id"))
			.add(Restrictions.eq("Status", "p").ignoreCase())
			.add(Restrictions.eq("h.Id", hospitalId))
			/*.add(Restrictions.or(Restrictions.in("injAph.Visit.Id", visitList), Restrictions.eq("injAph.AppointmentDate",new Date())))*/
			.add(Restrictions.eq("injAph.NextAppointmentDate",new Date()))
			.setProjection(Projections.groupProperty("InjAppointmentHeader"));
	
	InjectionList = critApp.list();		
	for(InjAppointmentHeader listB: InjectionList)
	{
		visitList.add(listB.getVisit().getId());
	}
	logger.debug("visitList @@@@@ "+visitList.size());
	List<Visit>pendingNursingList = new ArrayList<>();
	if(null !=visitList && visitList.size()>0)
	pendingNursingList = session.createCriteria(Visit.class).add(Restrictions.in("Id", visitList)).list();
	logger.debug("visitList @@@@@ "+pendingNursingList.size());
	procedureDetails.clear();
	InjectionList.clear();
	map.put("pendingNursingList", pendingNursingList);
	
	map.put("departmentList", departmentList);
	map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
	map.put("masSessionList", masSessionList);
	return map;
}

@Override
public Map<String, Object> uploadAndViewDocuments(Map<String, Object> generalMap) {
	Map<String, Object> map = new HashMap<>();
	
	
	List<UploadDocuments> uploadDocuments = new ArrayList<>();
	Session session = (Session)getSession();
	int hinId = 0;

	String flag="n";
	String message="";
	boolean fileuploaded=false;
	
	if(generalMap.get("hinId")!= null){
		hinId =(Integer) generalMap.get("hinId");
	}

	if(generalMap.get("flag")!= null){
		flag =(String) generalMap.get("flag");
	}

	String filename = "";
	if(generalMap.get("filename")!= null){
		filename =(String) generalMap.get("filename");
	}
	String uploadURL = "";
	if(generalMap.get("uploadURL")!= null){
		uploadURL =(String) generalMap.get("uploadURL");
	}
	String comments = "";
	if(generalMap.get("comments")!= null){
		comments =(String) generalMap.get("comments");
	}
	
	
	if(flag.equalsIgnoreCase("y"))
	{
		
		String fileExtension=null;
		 File file=null;
		 try { 
				HibernateTemplate hbt=getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				logger.debug(uploadURL+" -- "+filename);
				 file=new File(uploadURL + "/" + filename);
	    		 logger.debug("path>>"+file.getPath());
	    		
	    	     FileInputStream is = new FileInputStream(file);
	    	     long length = file.length();

	    	     byte[] bytes = new byte[(int)length];
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	    	
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	    	 throw new IOException("Could not completely read file "+file.getName());
	    	         
	    	     }
	    	     is.close();     
	    	
	    	     
	    	     UploadDocuments document = new UploadDocuments();
	    	     document.setPatientDocument(bytes);
	    	     int indexNo = filename.lastIndexOf("."); 
	    	     String actualfileName = filename.substring(0, indexNo);
	    	     fileExtension = filename.substring(indexNo+1);
	    	     document.setFileName(actualfileName);
	    	     document.setFileExtension(fileExtension);
	    	     Date d= new Date();
	    	     document.setUploadDate(d);
	    	     
	    	     Patient hinNo= new Patient();
	    	     hinNo.setId(hinId);
	    	     document.setHin(hinNo);
	    	    
	    	     document.setDescription(comments);
	    	     hbt.save(document);
	    	     hbt.flush();
	    	     hbt.refresh(document);	
	    	     message="File uploaded Sucessfully";
	    	     fileuploaded=true;
	    
	    }
		catch (Exception e) {
	    	e.printStackTrace();
	      System.err.println("Error: " + e.getMessage());
	      message="File is not uploaded Sucessfully, some error is occurred";
	      e.printStackTrace();
	    }
		
	}		
	
	
	uploadDocuments = session.createCriteria(UploadDocuments.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
			.add(Restrictions.or(Restrictions.isNull("ConsentLetter"), Restrictions.ne("ConsentLetter", "y").ignoreCase())).list();
	
	map.put("uploadDocuments", uploadDocuments);
	map.put("message", message);
	map.put("fileuploaded", fileuploaded);
	return map;
}

@Override
public Map<String, Object> populatePPWardByDistrict(Map<String, Object> map) {
	Session session = (Session) getSession();
	int districtId = 0;
	Criteria crt=null;
	
	if(null != map.get("districtId")){
		districtId=(Integer)map.get("districtId");
	}

	List<Object[]> wardList = new ArrayList<>();
	
	crt = session.createCriteria(MasWard.class).createAlias("District", "dist")
			.add(Restrictions.eq("dist.Id", districtId))
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("WardName"))).addOrder(Order.asc("WardName"));
	wardList=crt.list();
	
	
	map.put("wardList", wardList);
	return map;
}
@Override
public Map<String, Object> getNameAndMobile(Map<String, Object> map) {
	Session session = (Session) getSession();

	String mobNo="";
	String name="";
	int recordsPerPage = 5;

	int page = (Integer) map.get("page");

	
	Criteria crt=null;
	
	if(null != map.get("mobNo")){
		mobNo=(String)map.get("mobNo");
	}
	
	if(null != map.get("name")){
		name=(String) map.get("name");
	}
	List<Patient> patientList = new ArrayList<>();
	List<Patient> patientwithMobList = new ArrayList<>();

	crt = session.createCriteria(Patient.class)
			.add(Restrictions.eq("MobileNumber", mobNo))
			.add(Restrictions.eq("PFirstName", name));
	crt.setFirstResult((page - 1)*recordsPerPage);
	crt.setMaxResults(recordsPerPage);
	patientList=crt.list();
	
	crt = session.createCriteria(Patient.class)
			.add(Restrictions.eq("MobileNumber", mobNo))
			/*.add(Restrictions.eq("FullName", name))*/;
	crt.setFirstResult((page - 1)*recordsPerPage);
	crt.setMaxResults(recordsPerPage);
	patientwithMobList=crt.list();
	
	Criteria crty = session.createCriteria(Patient.class);
	if(!name.equals("")){
		crty.add(Restrictions.eq("PFirstName", name));
	}
	if(!mobNo.equals("")){
		crty.add(Restrictions.eq("MobileNumber", mobNo));
	}
	crty.setProjection(Projections.rowCount());

	int noOfRecords = (Integer) crty.uniqueResult();
	int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	
	map.put("patientList", patientList);
	map.put("patientwithMobList", patientwithMobList);
	map.put("noOfPages", noOfPages);
	map.put("currentPage", page);
	return map;
}


@Override
public Map<String, Object> paginationForPatientVisitJsp(int deptId,
		int hospitalId, String hinNo,int page,String visitSearch) {
	
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<>();

	List<MasComplaint> complaintList = new ArrayList<>();
	List<MasDepartment> departmentList = new ArrayList<>();
	
	List<MasDepartment> nonClinicaldepartmentList = new ArrayList<>();
	List<Object[]> doctorList = new ArrayList<>();
	List<MasCaseType> caseTypeList = new ArrayList<>();
	List<MasRelation> relationList = new ArrayList<>();
	List<MasAdministrativeSex> sexList = new ArrayList<>();
	List<MasPatientType> patientTypeList = new ArrayList<>();
	List<MasDiagnosisConclusion> diagnosisList = new ArrayList<>();
	List<MasChargeCode> chargeCodeList = new ArrayList<>();
	List<MasAuthorizer> authorizerList = new ArrayList<>();
	List<Patient> searchDataList = new ArrayList<>();
	List<MasSession> masSessionList = new ArrayList<>();

	
	int recordsPerPage = 5;
	
	try {

		Date currentRegisterDate=new Date();
		
		Criteria crt = null;
		crt = session.createCriteria(Patient.class).add(Restrictions.eq("PatientStatus", "Out Patient"))
				.add(Restrictions.eq("Hospital.Id", hospitalId))//added by govind 3-11-2016
				.add(Restrictions.isNull("CurrentVisitNo"));
		crt.add(Restrictions.eq("RegDate",currentRegisterDate));
		int noOfRecords = (Integer) crt.list().size();//added by govind 3-11-2016
		crt.setFirstResult((page - 1)*recordsPerPage);
		crt.setMaxResults(recordsPerPage);
		searchDataList = crt.list();
		
		Criteria crty = session.createCriteria(Patient.class)
				.add(Restrictions.eq("PatientStatus", "Out Patient"))
				.add(Restrictions.eq("RegDate", currentRegisterDate))
				.add(Restrictions.isNull("CurrentVisitNo"));
		crty.setProjection(Projections.rowCount());
		
		
		if(null !=searchDataList && searchDataList.size()>0)
		map.put("currentRegistrationList", searchDataList);
		
		//int noOfRecords = (Integer) crty.uniqueResult();//changed by govind 3-11-2016
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		patientTypeList = session.createCriteria(MasPatientType.class)

		.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		complaintList = session.createCriteria(MasComplaint.class)
				.addOrder(Order.asc("Id"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		
		
		nonClinicaldepartmentList=session.createCriteria(MasInstituteDepartment.class)
		.setProjection(Projections.property("Department"))
		.add(Restrictions.eq("Institute.Id",hospitalId))
		.add(Restrictions.eq("Status","y").ignoreCase())
		.createAlias("Department", "dep")
		.createAlias("dep.DepartmentType","DepartmentType")
		.add(Restrictions.ne("DepartmentType.Id",1))
		.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
		.addOrder(Order.asc("dep.DepartmentName"))
		.list();
		

		doctorList=session.createCriteria(MasEmployee.class).createAlias("Hospital", "Hospital").
				createAlias("EmployeeType", "EmployeeType").add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("EmployeeType.Id", 1)).list();
		caseTypeList = session.createCriteria(MasCaseType.class)
				.addOrder(Order.asc("Id"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		diagnosisList = session
				.createCriteria(MasDiagnosisConclusion.class)
				.addOrder(Order.asc("DiagnosisConclusionName"))
				.add(Restrictions.eq("Status", "Y")).list();

		relationList = session.createCriteria(MasRelation.class)
				.addOrder(Order.asc("RelationName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.createAlias("ChargeType", "chargeType")
				.addOrder(Order.asc("ChargeCodeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase())
				.add(Restrictions.eq("chargeType.Id", 9)).list();
		
		List<MasScheme> schemeList= new ArrayList<>();
		
		schemeList = session.createCriteria(MasScheme.class)
				.addOrder(Order.asc("SchemeName"))
				.add(Restrictions.eq("Status", "Y")).list();
		
		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
				.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
		BigDecimal mas_charge_code_rate = null;
		List<MasChargeCodeRates> rateList= new ArrayList<>();
		rateList=session.createCriteria(MasChargeCodeRates.class).
				createAlias("ChargeCode","chargecode")
				.add(Restrictions.eq("chargecode.Id", 1038)).list();
		for(MasChargeCodeRates rate:rateList){
			mas_charge_code_rate=rate.getRate();
			
		}
		

		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "Y"))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("AuthorizerName")).list();

		int visitNo = 0;
		String pragnent = "no";

		map.put("mas_charge_code_rate", mas_charge_code_rate);
		map.put("patientvisitNum", visitNo);
		map.put("complaintList", complaintList);
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("caseTypeList", caseTypeList);
		map.put("diagnosisList", diagnosisList);
		map.put("relationList", relationList);
		map.put("patientTypeList", patientTypeList);
		map.put("sexList", sexList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("authorizerList", authorizerList);
		map.put("schemeList", schemeList);
		map.put("nonClinicaldepartmentList", nonClinicaldepartmentList);
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		map.put("masSessionList", masSessionList);
		map.put("pragnent", pragnent);
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return map;
}


@Override
public Map<String, Object> getVisitDetailsForDirectPrinting(
		Map<String, Object> objectMap) {
	
	Map<String, Object> map = new HashMap<>();
	List<Visit> visitList= new ArrayList<>();
	Session session = (Session) getSession();

	int pHinId=0;
	int hospitalId = 0;
	
	List<Integer> depIdList= new ArrayList<>();
	List<String> depIdL= new ArrayList<>();
	if(null !=objectMap.get("depIdList")){
		
		depIdL=(List<String>)objectMap.get("depIdList");
		logger.debug("depIdL  +"+depIdL);
	}
	if(depIdL.size()>0){
		for(String s:depIdL){
			
			if(s !=null && !s.equals(""))
			depIdList.add(Integer.parseInt(s));
		}
	}
	
	if(null !=objectMap.get("pHinId")){
		pHinId=(Integer)objectMap.get("pHinId");
	}
	if(null !=objectMap.get("hospitalId")){
		hospitalId=(Integer)objectMap.get("hospitalId");
	}
	
	Criteria crt=null;
	crt=session.createCriteria(Visit.class)
			.createAlias("Hin", "hin")
			.createAlias("Department", "department")
			.createAlias("Hospital", "hospital")
			.add(Restrictions.in("department.Id", depIdList))
			.add(Restrictions.eq("hospital.Id", hospitalId))
			.add(Restrictions.eq("hin.Id", pHinId));
	
	visitList=crt.list();
	map.put("visitList", visitList);
	return map;
}

@SuppressWarnings("unchecked")
public Map<String, Object> getPatientRegistrationDataFromOtherSrc(Box box) {
	Map<String, Object> map = new HashMap<>();
	List<OnlinePatientPortal> portalPatientList = new ArrayList<>();
	List<Patient> webPatientList = new ArrayList<>();
	List<OnlinePatientVisit> portalVisitList = new ArrayList<>();
	Date  currentDate=new Date();
	Date tommorrowDate = null;

	Calendar c = Calendar.getInstance();
	c.setTime(currentDate);
	c.add(Calendar.DATE, 1);  
	tommorrowDate = c.getTime(); 
	Date[] dates = {currentDate,tommorrowDate};
	int hospitalId = 0;
	int appointmentId = 0;
	boolean isVisit = false;
	
	
	Session session = (Session) getSession();
	
	
	if (box.get("hospitalId") != null && !box.get("hospitalId").trim().equals("")) {
		hospitalId = Integer.parseInt(box.get("hospitalId"));
	}
	
	appointmentId = box.getInt("appointmentId");
	
	portalVisitList = session.createCriteria(OnlinePatientVisit.class).add(Restrictions.eq("HospitalId", hospitalId)).add(Restrictions.in("VisitDate", dates))
			.add(Restrictions.eq("Id", appointmentId)).list();


	if(portalVisitList!=null && portalVisitList.size()>0){
		
		if(portalVisitList.get(0).getHin()!=null){
			webPatientList = session.createCriteria(Patient.class).add(Restrictions.eq("AadhaarNo", portalVisitList.get(0).getHin().getAadhaarNo())).list();
			if(webPatientList==null || webPatientList.size()==0)
				portalPatientList = session.createCriteria(OnlinePatientPortal.class).add(Restrictions.eq("HospitalId", hospitalId))
				.add(Restrictions.eq("Id", portalVisitList.get(0).getHin().getId())).list();
		} else if(portalVisitList.get(0).getPatientHinId()!=null){
			webPatientList = session.createCriteria(Patient.class).add(Restrictions.eq("Id", portalVisitList.get(0).getPatientHinId())).list();
		}
		
		
		
		isVisit = true;
		
	}
	
	map.put("portalPatientList", portalPatientList);
	map.put("webPatientList", webPatientList);
	map.put("isVisit", isVisit);
	
	return map;
}


@SuppressWarnings("unchecked")
public Map<String, Object> submitPatientInformationFromOtherSrc(Box box) {
	Map<String, Object> patientInfoMap = new HashMap<>();
	final Map<String,Object> patientMap= new HashMap<>();
	Map<String, Object> billingDetailsMap = new HashMap<>();
	MasHospital hospital = new MasHospital();
	OnlinePatientPortal onlinePatientPortal = null;
	OnlinePatientAddress onlinePatientAddress = null;
	PatientAddress patientAddress = null;
	MasState masstate = new MasState();
	Users userObj = null;
	Patient patient = null;
	boolean duplicateRegisterStatus = false;
	
	List<MasState> statelist = new ArrayList<>();
	List<OnlinePatientVisit> onlinePatientVisitList = null;
	List<OnlinePatientAddress> onlinePatientAddressList = null;
	Session session = (Session) getSession();
	
	Date currentDate = new Date();
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	Date tommorrowDate = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	c.setTime(currentDate);
	c.add(Calendar.DATE, 1);  
	tommorrowDate = c.getTime(); 
	Date[] dates = {currentDate,tommorrowDate};

	
	Map<String,Object> utilMap = new HashMap<>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTime");
	

	String aadhaarNo = "";
	boolean aadharNoStatus = false;
	boolean succesfullyAdded = false;
	
	int hospitalId=0;
	int appointmentId = 0;
	int userId = 0;
 			
	if(null !=box.get("hospitalId")){
		hospitalId=Integer.parseInt(box.get("hospitalId"));
	}
	
	
	if(null !=box.get("userId")){
		userId=Integer.parseInt(box.get("userId"));
	}	
	
	if(null !=box.get("appointmentId")){
		appointmentId = Integer.parseInt(box.get("appointmentId"));
	}	
	
	onlinePatientVisitList = session.createCriteria(OnlinePatientVisit.class).add(Restrictions.eq("Id", appointmentId)).add(Restrictions.in("VisitDate", dates)).list();
	
	
	if(onlinePatientVisitList!=null && onlinePatientVisitList.size()>0){
		onlinePatientPortal = 		onlinePatientVisitList.get(0).getHin();
		onlinePatientAddressList =  session.createCriteria(OnlinePatientAddress.class).add(Restrictions.eq("Hin.Id", onlinePatientPortal.getId())).list();
		
		patientInfoMap.put("aadhaarNo", onlinePatientPortal.getAadhaarNo());
	
		duplicateRegisterStatus= checkDuplicateRegistraiton(patientInfoMap);
		
		if(!duplicateRegisterStatus){
		patient = new Patient();
		patientAddress = new PatientAddress();
		userObj = new Users(userId);
		
		patient.setAddEditBy(userObj);
		
		if (onlinePatientPortal.getAadhaarNo()!=null) {
			patient.setAadhaarNo(onlinePatientPortal.getAadhaarNo());
		}
		
		if (onlinePatientPortal.getAddEditDate()!=null) {
			patient.setAddEditDate(onlinePatientPortal.getAddEditDate());
		}
		
		if (onlinePatientPortal.getAddEditTime()!=null) {
			patient.setAddEditTime(onlinePatientPortal.getAddEditTime());
		}
		
		if (onlinePatientPortal.getNationalDobStatus()!=null) {
			patient.setNotionalDobStatus(onlinePatientPortal.getNationalDobStatus());
		}
		
		if (onlinePatientPortal.getCardValidDate()!=null) {
			patient.setCardValidDate(onlinePatientPortal.getCardValidDate());
		}
		
		if (onlinePatientPortal.getPatientStatus()!=null) {
			patient.setPatientStatus(onlinePatientPortal.getPatientStatus());
		}
		
		if (onlinePatientPortal.getSourcetypeStatus()!=null) {
			patient.setRegSourceType(onlinePatientPortal.getSourcetypeStatus());
		}
		
		if (onlinePatientPortal.getMemberId()!=null && onlinePatientPortal.getMemberId()!=0) {
			PhMemberSurvey phmember=new PhMemberSurvey();
			phmember.setId(onlinePatientPortal.getMemberId());
			patient.setMember(phmember);
		}
		
		if (onlinePatientPortal.getFamilyId()!=null && onlinePatientPortal.getFamilyId()!=0) {
			PhFamilySurvey phfamily=new PhFamilySurvey();
			phfamily.setId(onlinePatientPortal.getFamilyId());
			patient.setFamily(phfamily);
		}
		
		if (onlinePatientPortal.getFullName()!=null) {
			patient.setFullName(onlinePatientPortal.getFullName());
			patient.setPFirstName(onlinePatientPortal.getFullName());
		}
		
		if (onlinePatientPortal.getPFirstName()!=null) {
			patient.setPFirstName(onlinePatientPortal.getPFirstName());
		}
		
		if (onlinePatientPortal.getPMiddleName()!=null) {
			patient.setPMiddleName(onlinePatientPortal.getPMiddleName());
		}
		
		if (onlinePatientPortal.getPLastName()!=null) {
			patient.setPLastName(onlinePatientPortal.getPLastName());
		}
		
		if (onlinePatientPortal.getRelationId()!=null && onlinePatientPortal.getRelationId()!=0) {
			MasRelation relation= new MasRelation();
			relation.setId(onlinePatientPortal.getRelationId());
			patient.setRelation(relation);
		}
		
		if (onlinePatientPortal.getFatherMotherName()!=null) {
			patient.setFatherMotherName(onlinePatientPortal.getFatherMotherName());
		}
		
		if (onlinePatientPortal.getSexId()!=null && onlinePatientPortal.getSexId()!=0) {
			MasAdministrativeSex sex=new MasAdministrativeSex();
			sex.setId(onlinePatientPortal.getSexId());
			patient.setSex(sex);
		}
		
		if (onlinePatientPortal.getDateOfBirth()!=null) {
			patient.setDateOfBirth(onlinePatientPortal.getDateOfBirth());
		}
		
		if (onlinePatientPortal.getYearOfBirth()!=null) {
			patient.setYearOfBirth(onlinePatientPortal.getYearOfBirth());
		}
		
		if (onlinePatientPortal.getAge()!=null) {
			patient.setAge(onlinePatientPortal.getAge());
		}
		
		if (onlinePatientPortal.getPatientAge()!=null) {
			patient.setPatientAge(onlinePatientPortal.getPatientAge());
		}

		if (onlinePatientPortal.getBplStatus()!=null) {
			patient.setBplStatus(onlinePatientPortal.getBplStatus());
		}
		
		if (onlinePatientPortal.getBplNumber()!=null) {
			patient.setBplnumber(onlinePatientPortal.getBplNumber());
		}

		
		if (onlinePatientPortal.getMotherHinNo()!=null) {
			patient.setMotherHinNo(onlinePatientPortal.getMotherHinNo());
		}
		
		if (onlinePatientPortal.getPatientTypeId()!=null && onlinePatientPortal.getPatientTypeId()!=0) {
			MasPatientType masPatientType = new MasPatientType();
			masPatientType.setId(onlinePatientPortal.getPatientTypeId());
			patient.setPatientType(masPatientType);
		}
		
		if (onlinePatientPortal.getHospitalId()!=null && onlinePatientPortal.getHospitalId()!=0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(onlinePatientPortal.getHospitalId());
			patient.setHospital(masHospital);
		}
		
		if(onlinePatientAddressList!=null && onlinePatientAddressList.size()>0){
			 onlinePatientAddress = onlinePatientAddressList.get(0);
			
			if(onlinePatientAddress.getAddressTypeId()!=null && onlinePatientAddress.getAddressTypeId()!=0){
				MasAddressType addressType = new MasAddressType(onlinePatientAddress.getAddressTypeId());
				patientAddress.setAddressType(addressType);	
			}
			
			if (onlinePatientAddress.getHouseNo()!=null) {
				patientAddress.setHouseNo(onlinePatientAddress.getHouseNo());
			}
			
			if (onlinePatientAddress.getStreetRoad()!=null) {
				patientAddress.setStreetRoad(onlinePatientAddress.getStreetRoad());
			}
		
			if(onlinePatientAddress.getVillage()!=null && onlinePatientAddress.getVillage()!=0){
				MasVillage masVillage=new MasVillage();
				masVillage.setId(onlinePatientAddress.getVillage());
				patientAddress.setVillage(masVillage);
			}
			
			if(onlinePatientAddress.getDistrict()!=null && onlinePatientAddress.getDistrict()!=0){
				MasDistrict masDist=new MasDistrict();
				masDist.setId(onlinePatientAddress.getDistrict());
				patientAddress.setDistrict(masDist);
			}
			
			if(onlinePatientAddress.getTalukId()!=null && onlinePatientAddress.getTalukId()!=0){
				MasTaluk masSubDistrict=new MasTaluk();
				masSubDistrict.setId(onlinePatientAddress.getTalukId());
				patientAddress.setTaluk(masSubDistrict);
			}
			
			if(onlinePatientAddress.getPostOffice()!=null && onlinePatientAddress.getPostOffice()!=0){
				MasPostCode masPostCode=new MasPostCode();
				masPostCode.setId(onlinePatientAddress.getPostOffice());
				patientAddress.setPostOffice(masPostCode);
			}
			
			if (onlinePatientAddress.getPinCode()!=null) {
				patientAddress.setPinCode(Long.parseLong(String.valueOf(onlinePatientAddress.getPinCode())));
			}
		
			
			if(onlinePatientAddress.getLsgName()!=null && onlinePatientAddress.getLsgName()!=0){
				MasLsg masLsgName=new MasLsg();
				masLsgName.setId(Integer.parseInt(String.valueOf(onlinePatientAddress.getLsgName())));
				patientAddress.setLsgName(masLsgName);
			}
			
			if (onlinePatientAddress.getWardName()!=null) {
				patientAddress.setWardName(onlinePatientAddress.getWardName());
			}
			
			if(onlinePatientAddress.getLocality()!=null && onlinePatientAddress.getLocality()!=0){
				PhMasLocality masLocality=new PhMasLocality();
				masLocality.setId(onlinePatientAddress.getLocality());
				patientAddress.setLocality(masLocality);
			}
			
			if (onlinePatientAddress.getLsgHouseNo()!=null) {
				patientAddress.setLsgHouseNo(onlinePatientAddress.getLsgHouseNo());
			}
			
			if (onlinePatientAddress.getHealthHouseId()!=null) {
				patientAddress.setHealthHouseId(onlinePatientAddress.getHealthHouseId());
			}
			
		}
		

		if(onlinePatientPortal.getStateId()!=null && onlinePatientPortal.getStateId()!=0){
			MasState mState=new MasState();
			mState.setId(onlinePatientPortal.getStateId());
			patient.setState(mState);
		}
		
		
		if(onlinePatientPortal.getCountryId()!=null && onlinePatientPortal.getCountryId()!=0){
			MasCountry nationality=new MasCountry();
			nationality.setId(onlinePatientPortal.getCountryId());
			patient.setCountry(nationality);
		}
		
		if(onlinePatientPortal.getOccupationId()!=null && onlinePatientPortal.getOccupationId()!=0){
			MasOccupation masOccupation = new MasOccupation();
			masOccupation.setId(onlinePatientPortal.getOccupationId());
			patient.setOccupation(masOccupation);
		}
		
		if (onlinePatientPortal.getPassportNo()!=null) {
			patient.setPassportNo(onlinePatientPortal.getPassportNo());
		}
		
		if(onlinePatientPortal.getVisaType()!=null && onlinePatientPortal.getVisaType()!=0){
			MasVisaType visaType= new MasVisaType();
			visaType.setId(onlinePatientPortal.getVisaType());
			patient.setVisaType(visaType);
		}
		
		if (onlinePatientPortal.getVisaFrom()!=null) {
			patient.setVisaFrom(onlinePatientPortal.getVisaFrom());
		}
		
		if (onlinePatientPortal.getVisaTo()!=null) {
			patient.setVisaTo(onlinePatientPortal.getVisaTo());
		}
		
		if (onlinePatientPortal.getMobileNumber()!=null) {
			patient.setMobileNumber(onlinePatientPortal.getMobileNumber());
		}
		
		if (onlinePatientPortal.getEmailId()!=null) {
			patient.setEmailId(onlinePatientPortal.getEmailId());
		}
		
		if(onlinePatientPortal.getEducation()!=null && onlinePatientPortal.getEducation()!=0){
			MasQualification education=new MasQualification();
			education.setId(onlinePatientPortal.getEducation());
			patient.setEducation(education);
		}
		
		patient.setRegDate(new Date());
		patient.setRegTime(time);
		
		if (onlinePatientPortal.getMonthlyIncome()!=null) {
			patient.setMonthlyIncome(onlinePatientPortal.getMonthlyIncome());
		}
		
	
	}
	
		
		
	}
	
	

	Criteria crt = session.createCriteria(MasState.class).add(
			Restrictions.like("StateName", "kerala" + "%").ignoreCase());
	statelist = crt.list();
	int stateId = 0;
	for (MasState state : statelist) {
		stateId = state.getId();
		masstate.setId(stateId);
	}

	
	List<Object> existingHinNoList = new ArrayList<>();
	
	sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date date=new Date();
	String curDate=sdf.format(date);
	
	int patientHinId=0;
	int tsn = 0;
	int id = 0;
	String hinNo = "";
	String hin_name = "";
	int hinId = 0;
	boolean addressStatus = false;
	Date lastChangedate=null;
	int phMemberSurveyId=0;
	
	Transaction tx = null;

	Properties prop = new Properties();
	try{
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("registration.properties"); 
		prop.load(new FileInputStream(new File(resourcePath.getFile())));
		
	} catch (Exception e){
		e.printStackTrace();
	}
	
	
	try {
		
		if(!duplicateRegisterStatus) {
		currentDate = sdf.parse(curDate);
		tx = session.beginTransaction();
		
			List<Object[]> adList = session
					.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("TransactionPrefix", "HIN"))
					.add(Restrictions.eq("hosp.Id", hospitalId))
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
				tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 16-08-2016
				transactionSequenceObj1.setTransactionSequenceNumber(tsn);
				transactionSequenceObj1.setLastChgDate(date);
				transactionSequenceObj1.setTransactionSequenceName("Hin No");
				transactionSequenceObj1.setTransactionPrefix("HIN");
				transactionSequenceObj1.setTablename("Patient");
				transactionSequenceObj1.setCreatedby("admin");
				transactionSequenceObj1.setStatus("Y");
				MasHospital hosp=new MasHospital();
				hosp.setId(hospitalId);
				transactionSequenceObj1.setHospital(hosp);
				transactionSequenceObj1.setLastChgTime(time);
				hbt.save(transactionSequenceObj1);
			}

		
		if(null != lastChangedate && currentDate.compareTo(lastChangedate)>0){
			// tsn=0; // commented by amit das on  03-08-2016 for duplicate hin_no problem in lean-server connectivity
			tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 03-08-2016 for duplicate hin_no problem in lean-server connectivity
		TransactionSequence transactionSequenceObj = (TransactionSequence) session
				.load(TransactionSequence.class, id);
		// transactionSequenceObj.setTransactionSequenceNumber(1); // commented by amit das on  03-08-2016 for duplicate hin_no problem in lean-server connectivity
		transactionSequenceObj.setTransactionSequenceNumber(tsn+1); // added by amit das on 03-08-2016 for duplicate hin_no problem in lean-server connectivity
		transactionSequenceObj.setLastChgDate(date);
		hbt.update(transactionSequenceObj);
		
		
		}
		else{
			if(id>0){
			TransactionSequence transactionSequenceObj = (TransactionSequence) session
					.load(TransactionSequence.class, id);

			tsn = transactionSequenceObj.getTransactionSequenceNumber(); // added by amit das on 17-08-2016
			transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
			transactionSequenceObj.setLastChgDate(currentDate);
			hbt.update(transactionSequenceObj);
			}
		}
		
		
		String gender = "";
		if (patient != null) {

			HospitalParameters hospitalParameters = new HospitalParameters();
			List<HospitalParameters> hospitalParametersList = new ArrayList<>();
			Criteria ctt = session.createCriteria(HospitalParameters.class)
					.addOrder(Order.asc("Id"));
			ctt.setFirstResult(0);
			ctt.setMaxResults(1);
			hospitalParametersList = ctt.list();

			if (hospitalParametersList != null
					&& hospitalParametersList.size() > 0) {
				hospitalParameters = hospitalParametersList.get(0);
			}
			
			patient.setHinNo(String.valueOf(patient.getAadhaarNo()));
			
			if(null !=patient.getMember())
			phMemberSurveyId=patient.getMember().getId();
			
			
			int i = (Integer) hbt.save(patient);
			 patientHinId=patient.getId();
			patientMap.put("patientObj", patient);

			

			patientMap.put("tsn", tsn);

			hbt.save(patient);
			patientAddress.setHin(patient);
			hbt.save(patientAddress);
			succesfullyAdded = true;
			hinNo = String.valueOf(patient.getAadhaarNo());
			if (patient.getSex() != null) {
				gender = patient.getSex().getAdministrativeSexName();
			}
			
			
			if(phMemberSurveyId>0){
			PhMemberSurvey phMemberSurvey=(PhMemberSurvey) session.load(PhMemberSurvey.class, phMemberSurveyId);
			phMemberSurvey.setUhidNo(hinNo);
			hbt.saveOrUpdate(phMemberSurvey);
			
			}
			
		}
	
		
		
		tx.commit();
		
		patientInfoMap.put("gender", gender);
		patientInfoMap.put("hinId", hinId);
		patientInfoMap.put("succesfullyAdded", succesfullyAdded);
		patientInfoMap.put("hinNo", hinNo);
		patientInfoMap.put("onlinePatientVisitList", onlinePatientVisitList);
		patientInfoMap.put("patientHinId",patientHinId);
		patientInfoMap.put("duplicateRegisterStatus",duplicateRegisterStatus);

		final MasHospital  masHospital=(MasHospital)session.get(MasHospital.class, hospitalId);
		
			
			
		
		if(masHospital!=null){
		patientMap.put("hospital", masHospital);
		
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					savePatientDataForRegistrationToCentralServer(patientMap);
				}
				if(masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					savePatientDataForRegistrationToLeanServer(patientMap);
				}
			}
			
		}.start();*/
		}
	   }
	  
	} catch (Exception e) {
		if (tx != null)
			tx.rollback();
		e.printStackTrace();
	}
	return patientInfoMap;
}


public Map<String, Object> getPatientDetailsForVisitFromOthrSrc(Box box) {
	//
	Map<String, Object> map = new HashMap<>();
	List<Patient> patientList = new ArrayList<>();
	List<OnlinePatientVisit> onlinePatientVisitList = new ArrayList<>();
	Date currentDate = new Date();
	Date tommorrowDate = null;
	Calendar c = Calendar.getInstance();
	c.setTime(currentDate);
	c.add(Calendar.DATE, 1);  
	tommorrowDate = c.getTime(); 
	Date[] dates = {currentDate,tommorrowDate};
	
	String hinNo = null;
	int hinId = 0;
	int visitId = 0;
	Session session = (Session) getSession();
	
	if (box.get("hinNo") != null) {
		hinNo = box.get("hinNo");
	}
	
	if (box.getInt("hinId") != 0) {
		hinId = box.getInt("hinId");
	}
	
	if (box.getInt("appointmentId") != 0) {
		visitId = box.getInt("appointmentId");
	}
	
	try {
		Criteria crit = session.createCriteria(Patient.class);
		if (hinNo != null && !hinNo.trim().equals("")) {
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		} else if (hinId != 0) {
			crit = crit.add(Restrictions.eq("Id", hinId));
		}

		patientList = crit.addOrder(Order.asc("PFirstName")).list();
		
		if(patientList!=null && patientList.size()>0)
			map.put("hinNo", patientList.get(0).getHinNo());
		
		if(patientList!=null && patientList.size()>0)
			map.put("patientHinId", patientList.get(0).getId());
		
		crit =  session.createCriteria(OnlinePatientVisit.class).add(Restrictions.eq("Id", visitId)).add(Restrictions.in("VisitDate", dates));
		onlinePatientVisitList = 	crit.list();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	map.put("patientList", patientList);
	map.put("onlinePatientVisitList", onlinePatientVisitList);
	//
	return map;
}

@Override
public String getuserName(int empId) {
	String userName="",fname="",mname="",lname="";
	List<MasEmployee> employeeList = new ArrayList<>();
	Session session = (Session) getSession();
	employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Id", empId)).list();
	if(employeeList.size()>0){
		MasEmployee emp=employeeList.get(0);
		if(emp.getFirstName()!=null){
			fname=emp.getFirstName();
		}
		if(emp.getMiddleName()!=null){
			mname=emp.getMiddleName();
		}
		if(emp.getLastName()!=null){
			lname=emp.getLastName();
		}
		userName=fname+SPACE+mname+SPACE+lname;
	}
	return userName;
}

@Override
public Map<String, Object> getOnlineAppointmentDetails(Box box) {
	Map<String, Object> map = new HashMap<>();
	List<AppPatientAppointments> appPatientAppointmentList = new ArrayList<>();
	
	Date  currentDate=new Date();

	Calendar c = Calendar.getInstance();
	c.setTime(currentDate);
	c.add(Calendar.DATE, 1);  

	int hospitalId = 0;
	Session session = (Session) getSession();
	
	if (box.get("hospitalId") != null && !box.get("hospitalId").trim().equals("")) {
		hospitalId = Integer.parseInt(box.get("hospitalId"));
	}
	appPatientAppointmentList = session.createCriteria(AppPatientAppointments.class).add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("AppointmentDate", new Date())).add(Restrictions.eq("AppointmentNo", box.getString("appointmentNo"))).list();

	
	map.put("appPatientAppointmentList", appPatientAppointmentList);
	return map;
}

@Override
public Map<String, Object> submitOnlineAppointmentVisitDetails(Box box) {
	Map<String, Object> map = new HashMap<>();
	Map<String, Object> reservedTokenMap = new HashMap<>();
	Map<Integer, Object> patientWithTokenMap = new HashMap<>();
	Map<String, Object> requestMap = new HashMap<>();
	boolean successfullyAdded = false;
	boolean duplicateVisitSatatus=false;
	Visit visit = null;
	QueueManagment queue=null;
	Transaction tnx=null;
	Session session = (Session) getSession();
	Date currentDate=new Date();
	Integer totalHospitalVisitNo=0;
	int tokenNo=0;
	int visitId = 0;
	String onlineRegStatus="";
	Map<String,Object> utilMap = new HashMap<>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTime");
	List<Visit> visitList = new ArrayList<>();
	int visitNo=0;
	String hospitalCode="";
	hospitalCode=box.get("hospitalCode");
	MasHospital masHospital = null;
	int hospitalId = box.getInt("hospitalId");
	String requestedIP = box.get("requestedIP");
	int opsessionId = box.getInt("opsessionId");
	try {
		visitList=session.createCriteria(Visit.class)
				.createAlias("Hin", "hin")
	    		.add(Restrictions.eq("hin.Id",box.getInt("hinId")))
	    		.addOrder(Order.desc("Id"))
	    		.list();
		visitNo=visitList.get(0).getVisitNo()+1;
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		
		masHospital = hbt.get(MasHospital.class, hospitalId);
		

					if(box.getInt("departmentId") != 0){
					int departmentId = box.getInt("departmentId");
						MasDepartment department=new MasDepartment();
						visit=new Visit();
						queue=new QueueManagment();
						
						department.setId(box.getInt("departmentId"));
						visit.setDepartment(department);
						queue.setDepartment(department);
						
						visit.setPriorityNumber(1);
						queue.setPriorityNumber(1);
						
						Patient patient=new Patient();
						patient.setId(box.getInt("hinId"));
						visit.setHin(patient);
						queue.setHin(patient);
							map=getTotalVistByHospital(box.getInt("hospitalId"), departmentId, currentDate, box.getInt("hinId"),box.getInt("opSessionId"),hospitalCode);

							if(null !=map.get("TotaltokenNo")){
								totalHospitalVisitNo=(Integer)map.get("TotaltokenNo");
							}

							visit.setTotalHospitalVisit( (int)totalHospitalVisitNo);
							queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
							
							reservedTokenMap=getReseveredTokenNo(departmentId,box.getInt("hospitalId"));
							
							requestMap.put("reservedTokenMap", reservedTokenMap);
							requestMap.put("hospital", masHospital);
							requestMap.put("visitSessionId", opsessionId);
							requestMap.put("deptId", departmentId);
							requestMap.put("vDate", currentDate);
							requestMap.put("requestedIP", requestedIP);
							
							int maxTokenNo = 0;
							
							if(onlineRegStatus.equals("")){
							
							maxTokenNo =(int)getTokenNoForDepartment(requestMap);
							
							logger.debug("before"+maxTokenNo);
							if(reservedTokenMap.containsKey(String.valueOf(maxTokenNo))){
								logger.debug(reservedTokenMap.containsKey(String.valueOf(maxTokenNo)));
								maxTokenNo =(int)getTokenNoForDepartment(requestMap);
								logger.debug("after"+maxTokenNo);
							}
							tokenNo = maxTokenNo ;
							visit.setAppointmentType("D");
							logger.debug("after"+tokenNo);
							}
							else{
									if(null !=reservedTokenMap.get("patientWithTokenMap")){
										patientWithTokenMap=(Map<Integer,Object>)reservedTokenMap.get("patientWithTokenMap");
										if(null !=patientWithTokenMap.get(box.getInt("hinId")))
											tokenNo=(Integer)patientWithTokenMap.get(box.getInt("hinId"));
										visit.setAppointmentType("A");
										}
									/*else {
										maxTokenNo = (int)getTokenNoForDepartment(hospitalCode, departmentId,box.getInt("opSessionId"));
								
										tokenNo = maxTokenNo ;
										visit.setAppointmentType("D");
									}*/
							}
							
							
							visit.setHospital(masHospital);
							queue.setHospital(masHospital);

					if(box.getInt("opSessionId") !=0){
						MasSession masSession=new MasSession();
						masSession.setId(box.getInt("opSessionId"));
						visit.setVisitSession(masSession);
					}
							
						visit.setTokenNo(tokenNo);
						queue.setTokenNo(tokenNo);
						Users user = new Users();
						user.setId(box.getInt("userId"));
						visit.setAddEditBy(user);
						visit.setAge(box.getString("age"));
						if(null !=time && !time.equals(""))
						visit.setVisitTime(time);

						visit.setOpVisitTime(time);
						visit.setVisitDate(new Date());
						queue.setLsCngDate(new Date());
						visit.setVisitNo(visitNo);
						visit.setStatus("y");
						queue.setTokenStatus("w");
						queue.setOpVisitTime(time);
						visit.setEdStatus("n");
						visit.setVisitStatus("w");
						visit.setAddEditDate(new Date());
						visit.setAddEditTime(time);
						visit.setCurPharVisitStatus("Y");
						queue.setVisit(visit);
						
						duplicateVisitSatatus=checkDuplicateVisit(box.getInt("hospitalId"),departmentId,box.getInt("hinId"));
						
						String onlineAppointmentStauts="";
						
						if (box.getString("onlineAppointmentStauts") != null) {
							onlineAppointmentStauts = (String)box.getString("onlineAppointmentStauts");
							
						}
						int onlineAppId=0;
						
						if (box.getInt("onlineAppId") != 0) {
							onlineAppId = (Integer)box.getInt("onlineAppId");
							
						}
						
						if(!duplicateVisitSatatus){
						
						hbt.save(visit);
						visitId=visit.getId();
					
						if(null !=onlineAppointmentStauts && !onlineAppointmentStauts.equals("")){
							if(0 !=onlineAppId){
								AppPatientAppointments appPatientApp=(AppPatientAppointments) session.createCriteria(AppPatientAppointments.class)
										.createAlias("Hospital", "hospital")
										.add(Restrictions.eq("hospital.Id",box.getInt("hospitalId")))
										.add(Restrictions.eq("Id",onlineAppId)).list().get(0);
								appPatientApp.setAppointmentStatus("C");
								session.update(appPatientApp);
							}
						}
						
						queue.setLastChgDate(new Date());
						queue.setLastChgTime(time);
						//}
						
						hbt.save(queue);

						successfullyAdded = true;
						
						
						map.put("successfullyAdded", successfullyAdded);
						map.put("duplicateVisitSatatus", duplicateVisitSatatus);
						}
						else{
							map.put("successfullyAdded", successfullyAdded);
							map.put("duplicateVisitSatatus", duplicateVisitSatatus);
							//break;
							
						}
						
						}

		if(successfullyAdded){
			tnx.commit();
			session.flush();
		}
		else{
			tnx.rollback();
		}
		
		map.put("visitId", visitId);
		
	} catch (Exception e) {
		e.printStackTrace();
		tnx.rollback();
	}
	
	return map;
}
public Map<String, Object> submitMobileNumberForOTP(Box box) {
	Map<String, Object> map = new HashMap<>();

	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	String mobNo=box.get("mobNo");
	
	MobileRegistration mobileRegistration = null;
	map = (Map) HMSUtil.getCurrentDateAndTime();
	String otpTime = (String) map.get("currentTime");
	Date otpDate = new Date();
	String message = null;
	int otp = 0; 
	String responseCode = "";
	String verifiedStatus = "n";
	String msg = null;
	try {

			if(mobNo!=null && !mobNo.trim().equals("")){
				otp = HMSUtil.generateMobileVerificationOTP();
				logger.debug("otp  "+otp);

				message = "One Time Password(OTP) for Mobile Number verification for registration in eHealth is "+otp+". Use this OTP to verify mobile number";
				responseCode = SMSHTTPSPostClient.sendOtpSMS(mobNo, message);
				logger.debug("responseCode = "+responseCode);
				if (responseCode.equals("402")) {
					mobileRegistration = new MobileRegistration();
					mobileRegistration.setMobileNo(mobNo);
					mobileRegistration.setOtp(otp);
					mobileRegistration.setOtpDate(otpDate);
					mobileRegistration.setOtpTime(otpTime);
					mobileRegistration.setVerifiedStatus(verifiedStatus);
					hbt.save(mobileRegistration);
					msg = "Mobile Number is registered successfully.";
				}
			 }
	   
	} catch (Exception e) {
		msg = "Mobile Number is not registered.";
		e.printStackTrace();
	}
	map.put("msg", msg);
	return map;
}

// added by amit das on 20-12-2016
public Map<String, Object> getHospitalData(Map<String, Object> objectMap) {
	Map<String, Object> map = new HashMap<>();
	MasHospital hospital  = null;
	long hospitalId = 0;
	Session session = (Session)getSession();
	if(objectMap!=null && objectMap.get("hospitalId")!=null){
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
private String getDoctorNameById(int doctorId,int hospitalId){
	Session session = (Session)getSession();
	String doctorName="";
	List<MasEmployee> employeeList=(List<MasEmployee>) session.createCriteria(MasEmployee.class)
			.createAlias("Hospital", "Hosp")
			
			.add(Restrictions.eq("Hosp.Id", hospitalId))
			.add(Restrictions.eq("Id", doctorId)).list();
	if(employeeList.size()>0){
	doctorName=employeeList.get(0).getFirstName();
	}
	return doctorName;
	
}

public PharmacyLabQueue saveQueueNoForPharmacy(int departmentId,int hospitalId,Visit visit,String pharmacyLabStatus,int maxQueueNoDepartWise){
	
	PharmacyLabQueue pharmacyLabQueue=new PharmacyLabQueue();
	pharmacyLabQueue.setTokenNo(maxQueueNoDepartWise);
	
	MasDepartment masDepartment=new MasDepartment();
	masDepartment.setId(departmentId);
	pharmacyLabQueue.setDepartment(masDepartment);
	
	MasHospital masHospital=new MasHospital();
	masHospital.setId(hospitalId);
	pharmacyLabQueue.setHospital(masHospital);
	
	
	pharmacyLabQueue.setTotalHospitalVisit(visit.getTotalHospitalVisit());
	
	pharmacyLabQueue.setVisit(visit);
	
	pharmacyLabQueue.setStatus("D");
	logger.debug("pharmacyLabStatus   "+pharmacyLabStatus);
	pharmacyLabQueue.setPharmacyLabStatus(pharmacyLabStatus);
	
	SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");


    Date now = new Date();

    String opdTime = sdfTime.format(now);
    
	pharmacyLabQueue.setOpdDate(now);
	pharmacyLabQueue.setOpdTime(opdTime);
	
	return pharmacyLabQueue;
	
}
@Override
public String getHospitalName(int hospitalId) {
	Session session = (Session) getSession();
	String hospitalName = "";
	List<MasHospital> list = session.createCriteria(MasHospital.class)
			.add(Restrictions.eq("Status", "y").ignoreCase())
			.add(Restrictions.eq("Id", hospitalId)).list();

	if (list.size() > 0) {
		MasHospital obj = (MasHospital) list.get(0);
		hospitalName = obj.getHospitalName();
	}
	return hospitalName;

}



@Override
public Map<String, Object> populatePatientCitizenDataAadhaar(String aadhaar) {
	

	long familyId=0;
	int familySequenceId=0;
	int houseId=0;
	String query=null;
	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<>();

	List<PhMemberSurvey> memberList = new ArrayList<>();
	List<PhHouseSurvey> houseList = new ArrayList<>();
	

	try {
		int memberId=0;
		memberList = session.createCriteria(PhMemberSurvey.class)

		.add(Restrictions.eq("AadhaarNo",Long.parseLong(aadhaar) )).list();
		
		for(PhMemberSurvey phMember:memberList){
			familyId=phMember.getFamilyId();
			
			if(null !=phMember.getHouse())
			houseId=phMember.getHouse().getId();
			
		}
		if(houseId >0){
			query="from PhHouseSurvey as ph where ph.Id = :fId";
			Query qry=session.createQuery(query);
			qry.setParameter("fId", houseId);
			houseList=qry.list();
			map.put("houseList", houseList);
		}
		if(familyId>0){
			query="Select Id from PhFamilySurvey where FamilyId = :fId";
			Query qry=session.createQuery(query);
			qry.setParameter("fId", String.valueOf(familyId));
			
			List faimlyList=qry.list();
			//changed for maven
			if(faimlyList.size()>0)
				familySequenceId= (Integer) faimlyList.get(0);
			
			map.put("familySequenceId", familySequenceId);
		}
		
		map.put("memberList", memberList);
	}
	

	catch (Exception e) {
		e.printStackTrace();
	}

	return map;
}

@Override
public boolean checkTokenExist(String uhid, int tokenNo) {

	Session session = (Session) getSession();
	List<PharmacyLabQueue> pharmacyLabQueue = null;
	pharmacyLabQueue = new ArrayList<>();


	Criteria crt = null;

	crt = session.createCriteria(PharmacyLabQueue.class)
	.createAlias("Visit","visit")
	.createAlias("visit.Hin","hin");

	if (uhid != null && uhid != "") {
		crt.add(Restrictions.eq("hin.HinNo", uhid));
	}
	if (tokenNo != 0) {
		crt.add(Restrictions.eq("TotalHospitalVisit", tokenNo));
	}
	crt.add(Restrictions.eq("OpdDate", new Date()));
	crt.add(Restrictions.eq("Status", "P"));
	pharmacyLabQueue = crt.list();

	Boolean registerStatus = false;

	if (!pharmacyLabQueue.isEmpty() && pharmacyLabQueue.size() > 0) {
		registerStatus = true;
	}

	return registerStatus;
}

@Override
public Map<String, Object> populatePPLocalityByWardLsg(
		Map<String, Object> dataMap) {
	Session session = (Session) getSession();
	Criteria crt=null;
	
	int wardId = 0,lsgId=0;
	if (dataMap.get("wardId") != null
			&& !dataMap.get("wardId").equals("")) {
		wardId = Integer.parseInt(dataMap.get("wardId").toString());  
		
	}
	
	if (dataMap.get("lsgId") != null
			&& !dataMap.get("lsgId").equals("")) {
		lsgId = Integer.parseInt(dataMap.get("lsgId").toString());  
		
	}
	List<PhMasLocality> localityList= new ArrayList<>();
	
	crt = session.createCriteria(PhMasLocality.class)
			.createAlias("Ward", "ward")
			.createAlias("Lsg", "lsg")
			.add(Restrictions.eq("ward.Id", wardId))
	      .add(Restrictions.eq("lsg.Id", lsgId))
	      .addOrder(Order.asc("LocalityName"));
	localityList=crt.list();
	
	
	dataMap.put("localityList", localityList);
	return dataMap;
}

public Map<String, Object> populateOPDRegister(int hospitalId) {
	Map<String, Object> map = new HashMap<>();
	List<MasEmployeeDepartment> departmentList = null;
	List<MasDepartment> instDepartmentList = new ArrayList<MasDepartment>();
	List<MasAdministrativeSex> sexList = null;
	Session session = (Session) getSession();
	try {
		//Changed by Arbind on 16-12-2017 departmentList
		/*departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();*/
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

		sexList=session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.list();

		map.put("departmentList", departmentList);
		map.put("instDepartmentList", instDepartmentList);
		map.put("sexList", sexList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

@Override
public Map<String, Object> showRePrintOpTicketJsp(Box box) {
	
	Map<String, Object> map = null;
	map= new HashMap<>();
	Session session = (Session) getSession();
	List<MasDepartment> departmentList = null;
	departmentList= new ArrayList<>();
	
	int noOfPages = 0;
	int noOfRecords = 0;
	int recordsPerPage = 10;
	
	int page = 1;
	if(box.getInt("page")!=0){
		page = box.getInt("page");
	}
	
	List<Visit> visitList = null;
	int hospitalId=0;
	hospitalId=box.getInt("hospitalId");
	String uhid=box.get("uhid");
	String FromTime=box.get("FromTime");
	String ToTime=box.get("ToTime");
	int patientDepartment=0;
	patientDepartment=box.getInt("patientDepartment");
	String name="";
	name=box.get("Name");
	String mobileNo="";
	
	Criteria crt=null;
	mobileNo=box.get("MobileNo");
	logger.debug("FromTime"+FromTime);
	logger.debug("ToTime"+ToTime);
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
     Properties prop = new Properties();
     
     try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
     
     int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));

	try {
		
		
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",departmentTpeId))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		 crt= session.createCriteria(Visit.class).createAlias("Hospital", "hospitalId").createAlias("Hin", "hin")
				.add(Restrictions.eq("VisitDate", new Date()))	
		.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
		.add(Restrictions.eq("hospitalId.Id", hospitalId))
		.addOrder(Order.asc("VisitTime"))
		.addOrder(Order.asc("TotalHospitalVisit"))
		.addOrder(Order.asc("TokenNo"));

		 if(patientDepartment>0){
			 crt=crt.createAlias("Department", "department");
				crt.add(Restrictions.eq("department.Id", patientDepartment));
				map.put("patientDepartment", patientDepartment);
		 }
		 if(null !=FromTime && !FromTime.equals("") && null !=ToTime && !ToTime.equals("")){
				
				crt.add(Restrictions.between("VisitTime", FromTime, ToTime));
				map.put("FromTime", FromTime);
				map.put("ToTime", ToTime);
			}
		 if(null !=name && !name.equals("")){
				//crt=crt.createAlias("Hin", "hin");
				crt.add(Restrictions.ilike("hin.FullName",  name + "%"));
				map.put("Name", name);
			}
		if(null !=mobileNo && !mobileNo.equals("")){
			//crt=crt.createAlias("Hin", "hin");
			crt.add(Restrictions.eq("hin.MobileNumber",  mobileNo ));
			map.put("MobileNo", mobileNo);
		}
		 if(!uhid.equals("")){
			//	crt=crt.createAlias("Hin", "hin");
				crt.add(Restrictions.eq("hin.HinNo",  uhid ));
				map.put("uhid", uhid);
			}
		
		noOfRecords = crt.list().size();
		crt.setFirstResult((page - 1)*recordsPerPage);
		crt.setMaxResults(recordsPerPage);
		
		visitList=crt.list();
		
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		
		map.put("visitList", visitList);
		map.put("departmentList", departmentList);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;

}
@Override
public Map<String, Object> showReferralPrintOpTicketJsp(Box box) {
	
	Map<String, Object> map = null;
	map= new HashMap<>();
	Session session = (Session) getSession();
	List<MasDepartment> departmentList = null;
	departmentList= new ArrayList<>();
	
	List<Visit> visitList = null;
	int hospitalId=0;
	hospitalId=box.getInt("hospitalId");
	int patientDepartment=0;
	patientDepartment=box.getInt("patientDepartment");
	String uhid="";
	uhid=box.get("uhid");
	
	Criteria crt=null;
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
     Properties prop = new Properties();
     
     try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
     
     int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));

	try {
		
		
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",departmentTpeId))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		 crt= session.createCriteria(Visit.class).createAlias("Hospital", "hospitalId")
				.add(Restrictions.eq("VisitDate", new Date()))	
		.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
		.add(Restrictions.eq("hospitalId.Id", hospitalId))
		.add(Restrictions.eq("ReferralStatus", "y").ignoreCase())
		.addOrder(Order.asc("VisitTime"))
		.addOrder(Order.asc("TotalHospitalVisit"))
		.addOrder(Order.asc("TokenNo")).setMaxResults(10);
		
		 if(patientDepartment>0){
			 crt=crt.createAlias("Department", "department");
				crt.add(Restrictions.eq("department.Id", patientDepartment));
		 }
		if(null !=uhid && !uhid.equals("")){
			crt=crt.createAlias("Hin", "hin");
			crt.add(Restrictions.eq("hin.HinNo",  uhid ));
		}
		
		visitList=crt.list();
		
		map.put("visitList", visitList);
		map.put("departmentList", departmentList);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;

}
@Override
public Map<String, Object> populatePPWardByLsg(Map<String, Object> map) {
	Session session = (Session) getSession();
	int lsgId = 0;
	Criteria crt=null;
	
	if(null != map.get("lsgId")){
		lsgId=(Integer)map.get("lsgId");
	}
	List<MasWard> wardList = new ArrayList<>();
	
	crt = session.createCriteria(MasWard.class).createAlias("Lsg", "lsg")
			.add(Restrictions.eq("lsg.Id", lsgId))
			.addOrder(Order.asc("WardName"));
	wardList=crt.list();
	
	
	map.put("wardList", wardList);
	return map;
}


@Override
public Map<String, Object> getTokenAndSerialNo() {
	Session session = (Session) getSession();
	HashMap<String, Object> map = new HashMap<>();
	int hospitalId = 0;
	List<Object[]> tokenList = null;
	Criteria criteria = null;
	Date currentDate = new Date();
	String msgData = null;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	try{
		criteria = session.createCriteria(Visit.class).add(Restrictions.ne("AppointmentType", "A").ignoreCase())
				  .setProjection(Projections.projectionList().add(Projections.max("TokenNo")).add(Projections.max("TotalHospitalVisit"))
				  .add(Projections.property("Hospital.Id")).add(Projections.property("Department.Id")).add(Projections.property("VisitSession.Id"))
				  .add(Projections.groupProperty("Hospital.Id")).add(Projections.groupProperty("Department.Id")).add(Projections.groupProperty("VisitSession.Id")))
				  .add(Restrictions.eq("VisitDate", currentDate));
		
		tokenList = criteria.list();
		
		if(tokenList!=null && tokenList.size()>0){
			for(Object[] objects : tokenList){
				hospitalId = (Integer)objects[2];
			msgData = String.valueOf(objects[0]) + "|" + objects[1] + "|" + objects[2] + "|" + objects[3] + "|" + objects[4];
			if(hospitalId!=0){
				MasHospital hospital =	(MasHospital)session.get(MasHospital.class, hospitalId);
				// map.put(msgData,hospital); // commented by amit das on 11-07-2017
				map.put(msgData+":"+simpleDateFormat.format(currentDate),hospital);  // added by amit das on 11-07-2017
			}
		   }
		}
		
		
	} catch(Exception e){
		e.printStackTrace();
	} finally{
		session.close();
	}
	
	return map;
}

@Override
public Map<String, Object> updateTokenNumber(String msgData,int hospitalId) {
	Session session = (Session) getSession();
	HashMap<String, Object> map = new HashMap<>();
	String[] msgDataArray = null;
	String[] msgArray = null;
	int deptId = 0;
	long tokenNo = 0;
	long centralTokenNo = 0;
	int visitSessionId = 0;
	MasHospital hospital = null;
	MasDepartment department = null;
	String query = null;
	long serialNo = 0;
	String schName = "public"; 
	long centralSerialNo = 0;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Iterator<BigInteger> iter =  Collections.<BigInteger>emptyList().iterator();
	
	logger.debug("msgData =========== "+msgData);
	msgDataArray = msgData.split(":");
	Date dateFromData =	null;
	Date currentDate = new Date();

	Calendar calRecievedDate = Calendar.getInstance();
	Calendar calCurrentDate = Calendar.getInstance();
	
	try {	
		
		dateFromData = 	simpleDateFormat.parse(msgDataArray[1]);
		
		calRecievedDate.setTime(dateFromData);
		calCurrentDate.setTime(currentDate);

		boolean sameDay = calRecievedDate.get(Calendar.YEAR) == calCurrentDate.get(Calendar.YEAR) &&
                  calRecievedDate.get(Calendar.DAY_OF_YEAR) == calCurrentDate.get(Calendar.DAY_OF_YEAR);

        if(sameDay){

		if(msgDataArray[0]!=null && msgDataArray[0].length()>0){
			Query q = null; 
			BigInteger i = null;
			hospital = (MasHospital)session.get(MasHospital.class, hospitalId);
			
					msgArray = msgDataArray[0].split("\\|");
					tokenNo = Integer.parseInt(msgArray[0]);
					serialNo = Integer.parseInt(msgArray[1]);		
					deptId = Integer.parseInt(msgArray[3]);
					visitSessionId = Integer.parseInt(msgArray[4]);
							
					department = (MasDepartment)session.get(MasDepartment.class, deptId);
					String opSerialNo = "hospital_code_"+hospital.getHospitalCode()+"_seq";
					String tokenSequenceName="token_"+department.getId()+"_"+hospital.getHospitalCode()+"_"+visitSessionId+"_seq";
					
					query = "SELECT COUNT(*) FROM information_schema.sequences WHERE sequence_schema='" + schName + "' AND sequence_name='" + opSerialNo + "'";
					
					q = session.createSQLQuery(query);

			        i = (BigInteger) q.list().get(0);
			        
			        if(i.intValue()==1){
			        query = "select last_value from "+opSerialNo;
					q = session.createSQLQuery(query);
					iter = (Iterator<BigInteger>) q.list().iterator();
					centralSerialNo = iter.next().longValue();
					
					if(centralSerialNo<serialNo){
						query = "SELECT setval('"+opSerialNo+"', "+serialNo+", true)";
						q = session.createSQLQuery(query);
						q.list();
					}
					}		
					
			        query = "SELECT COUNT(*) FROM information_schema.sequences WHERE sequence_schema='" + schName + "' AND sequence_name='" + tokenSequenceName + "'";
					
					q = session.createSQLQuery(query);

			        i = (BigInteger) q.list().get(0);
			        
			        if(i.intValue()==1){
			        
					query = "select last_value from "+tokenSequenceName;
					q = session.createSQLQuery(query);
					iter = (Iterator<BigInteger>) q.list().iterator();
					centralTokenNo = iter.next().longValue();
					
					if(centralTokenNo<tokenNo){
						query = "SELECT setval('"+tokenSequenceName+"', "+tokenNo+", true)";
						q = session.createSQLQuery(query);
						q.list();
					}
			        }
			        
					map.put("success", "success");
				
		}
	  }	
	} catch (Exception e){
		e.printStackTrace();
	} finally{
		session.close();
	}
	
	return map;
}


@Override
public Map<String, Object> populateOnlinePageOtherHospital(int deptId, int hospitalId) {

	List<MasDepartment> departmentList = new ArrayList<>();
	List<Object[]> doctorList = new ArrayList<>();
	List<MasEmployee> employeeByCategoryList = new ArrayList<>();//added by govind 09-01-2017
	List<MasSession> masSessionList= new ArrayList<>();
	List<MasHospitalType> masHospitalTypeList= new ArrayList<>();
	List<MasDistrict> districtList = new ArrayList<>();
	int stateId=0; // added by amit das on 08-05-2017
	String stateIdProp = null; // added by amit das on 08-05-2017
	boolean unitExistance=false;

	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<>();
	
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
        Properties prop = new Properties();
        
        try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			stateIdProp =	prop.getProperty("stateId");  // added by amit das on 08-05-2017
		} catch (Exception e1) { 
			
			e1.printStackTrace();
		} 
        
        if(stateIdProp!=null) // added by amit das on 08-05-2017
        	stateId = Integer.parseInt(stateIdProp); // changed by amit das on 08-05-2017
       
		
	try {

		departmentList=session.createCriteria(MasInstituteDepartment.class)					
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "depType")
				.add(Restrictions.eq("depType.DepartmentTypeName","OP Clinic").ignoreCase())//modified by govind 09-01-2017
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		masSessionList=session.createCriteria(MasSession.class)
				.add(Restrictions.eq("Hospital.Id",hospitalId))//modified by govind 09-01-2017
				   .add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		districtList = (List<MasDistrict>) session
				.createCriteria(MasDistrict.class)
				.createAlias("State", "state")
				.add(Restrictions.eq("state.Id", stateId))
				.addOrder(Order.asc("DistrictName")).list();
		
		masHospitalTypeList=session.createCriteria(MasHospitalType.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.addOrder(Order.asc("HospitalTypeName"))
				.list();

		String QueryForEmp = "select * from mas_employee where emp_category_id=1 and status='Y' and hospital_id='"
				+ hospitalId + "' and grade_id is not null";
		doctorList = session.createSQLQuery(QueryForEmp).list();
		//added by govind 09-01-2017
		employeeByCategoryList = session.createCriteria(MasEmployee.class)
				.createAlias("EmpCategory", "EmpCategory")
				.add(Restrictions.eq("EmpCategory.EmpCategoryName","Doctor").ignoreCase())
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id",hospitalId)).addOrder(Order.asc("EmployeeName"))
				.list();
		
				String ExistQry="select * from hospital_doctor_unit_m where hospital_id="+hospitalId+"";
				SQLQuery uniExistQuery = session.createSQLQuery(ExistQry);
				List unitList = uniExistQuery.list();
				
				if(unitList!=null&&unitList.size()>0){
					unitExistance=true;
				}
		

		map.put("employeeByCategoryList", employeeByCategoryList);
		//added by govind 09-01-2017 end
		map.put("departmentList", departmentList);
		map.put("doctorList", doctorList);
		map.put("masSessionList", masSessionList);
		map.put("masHospitalTypeList", masHospitalTypeList);
		map.put("districtList", districtList);
		map.put("unitExistance",unitExistance);

		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return map;

}

@Override
public Map<String, Object> populHospitalByDistrictIdHospitalTypeId(
		Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<>();
	try {

		int districtId = (Integer) dataMap.get("districtId");
		int hospitalTypeId = (Integer) dataMap.get("hospitalTypeId");

		List<MasHospital> masHospitalList = new ArrayList<>();
		Session session = (Session) getSession();
		masHospitalList =  session.createCriteria(MasHospital.class).createAlias("HospitalType", "hsopitalType")
				.createAlias("District", "dist")
				.add(Restrictions.eq("dist.Id", districtId))
				.add(Restrictions.eq("hsopitalType.Id", hospitalTypeId))
				.addOrder(Order.asc("HospitalName")).list();
		
		map.put("masHospitalList", masHospitalList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

@Override
public Map<String, Object> getServiceCenterByHospital(
		Map<String, Object> detailsMap) {
	Map<String, Object> map = new HashMap<>();
	try {

		int hospitalId = (Integer) detailsMap.get("hospitalId");

		List<MasDepartment> departmentList = new ArrayList<>();
		Session session = (Session) getSession();
		departmentList=session.createCriteria(MasInstituteDepartment.class)					
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "depType")
				.add(Restrictions.eq("depType.DepartmentTypeName","OP Clinic").ignoreCase())//modified by govind 09-01-2017
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		logger.debug("departmentList "+departmentList.size());
		map.put("departmentList", departmentList);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

@Override
public Map<String, Object> getSessionByHospital(Map<String, Object> detailsMap) {
	Map<String, Object> map = new HashMap<>();
	try {

		int hospitalId = (Integer) detailsMap.get("hospitalId");

		List<MasSession> masSessionList = new ArrayList<>();
		Session session = (Session) getSession();
		masSessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
				.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		logger.debug("departmentList "+masSessionList.size());
		map.put("masSessionList", masSessionList);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

@Override
public Map<String, Object> getDoctorUnit(Map<String, Object> map){
	List<HospitalDoctorUnitM> unitList= new ArrayList<>();
	List<MasDepartment> masDepartmentList= new ArrayList<>();
	int departmentId=(Integer)map.get("departmentId");
	int hospitalId = (Integer)map.get("hospitalId");
	String appointmentDate=(String) map.get("appointmentDate");
	unitList = getDoctorUnit(departmentId, hospitalId,
			appointmentDate);
	
	
	map.put("unitList", unitList);
	return map;
}

private List<HospitalDoctorUnitM> getDoctorUnit(int departmentId, int hospitalId,
		String appointmentDate) {
	List<HospitalDoctorUnitM> unitList= new ArrayList<>();
	List<MasDepartment> masDepartmentList;
	Session session = (Session) getSession();
	
	
	masDepartmentList=session.createCriteria(MasInstituteDepartment.class)
	.setProjection(Projections.property("Department"))
	.add(Restrictions.eq("Institute.Id",hospitalId))
	.add(Restrictions.eq("Status","y").ignoreCase())
	.createAlias("Department", "dep")
	.add(Restrictions.eq("dep.Id",departmentId)).list();
	
	ArrayList<Integer> empDepartmentId= new ArrayList<>();
	for(MasDepartment department:masDepartmentList){
		
		if(null !=department && null !=department.getEmpDept())
			if(null !=department.getEmpDept())
		empDepartmentId.add(department.getEmpDept().getId());
		
	}

	String unitDay = "";
	try {
		unitDay = HMSUtil.getDayStringFromDate(appointmentDate).toLowerCase();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(empDepartmentId.size()>0){
		unitList=session.createCriteria(HospitalDoctorUnitM.class)
				 .createAlias("EmpDept", "EmpDept")
				 .createAlias("Hospital", "Hospital")
				 .add(Restrictions.eq("Hospital.Id", hospitalId))
				 .add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
				  .add(Restrictions.in("EmpDept.Id", empDepartmentId)).list();
		 
	}
	return unitList;
}

@Override
public List<HospitalDoctorUnitT> getUnitDoctors(String unitId, String hospitalId) {
	
	int unit_Id=Integer.parseInt(unitId);
	int hospital_Id=Integer.parseInt(hospitalId);
	
	Session session=(Session) getSession();
	List<HospitalDoctorUnitT> doctorList= new ArrayList<>();
	
	Criteria crt=null;
	crt=session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM")
			.add(Restrictions.eq("UnitM.Id", unit_Id)).add(Restrictions.eq("UnitM.Hospital.Id", hospital_Id)).add(Restrictions.eq("Status", 'y').ignoreCase());
	doctorList=crt.list();
	return doctorList;
}

@Override
public Map<String, Object> rePrintAdvanceOpTicket(Box box) {
	Map<String, Object> map = null;
	map= new HashMap<>();
	Session session = (Session) getSession();
	List<MasDepartment> departmentList = null;
	departmentList= new ArrayList<>();
	
	int noOfPages = 0;
	int noOfRecords = 0;
	int recordsPerPage = 10;
	int page = 1;
	if(box.getInt("page")!=0){
		page = box.getInt("page");
	}
	
	List<Visit> visitList = null;
	int hospitalId=0;
	hospitalId=box.getInt("hospitalId");
	String uhid=box.get("uhid");
	String ToDate=box.get("ToDate");
	String FromDate=box.get("FromDate");
	int patientDepartment=0;
	patientDepartment=box.getInt("patientDepartment");
	String name="";
	name=box.get("Name");
	String mobileNo="";
	
	Criteria crt=null;
	mobileNo=box.get("MobileNo");
	 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
     Properties prop = new Properties();
     
     try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {
			
			e1.printStackTrace();
		} 
     
     int departmentTypeId=Integer.parseInt(prop.getProperty("departmentTpeId"));
     
     try {
 		departmentList=session.createCriteria(MasInstituteDepartment.class)
 				.setProjection(Projections.property("Department"))
 				.add(Restrictions.eq("Institute.Id",hospitalId))
 				.add(Restrictions.eq("Status","y").ignoreCase())
 				.createAlias("Department", "dep")
 				.createAlias("dep.DepartmentType","DepartmentType")
 				.add(Restrictions.eq("DepartmentType.Id",departmentTypeId))
 				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
 				.addOrder(Order.asc("dep.DepartmentName"))
 				.list();
 		logger.debug("departmentType List size"+departmentList.size());
 		crt= session.createCriteria(Visit.class).createAlias("Hospital", "hospitalId").createAlias("Hin", "hin")
 		.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
 		.add(Restrictions.eq("hospitalId.Id", hospitalId))
 		.add(Restrictions.eq("AppointmentType", "A").ignoreCase())
 		.addOrder(Order.asc("TokenNo"));
 		if(null !=FromDate && !FromDate.equals("") && null !=ToDate && !ToDate.equals("")){
 			DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
 			Date fromDate= simpleDateFormat.parse(FromDate);
 			Date toDate= simpleDateFormat.parse(ToDate);
 			crt.add(Restrictions.between("VisitDate", fromDate, toDate));
 			map.put("fromDate", fromDate);
 			map.put("toDate", toDate);
 		}else{
 			crt.add(Restrictions.eq("VisitDate", new Date()));
 			map.put("fromDate", new Date());
 			map.put("toDate", new Date());
 		}

 		 if(patientDepartment>0){
 			 crt=crt.createAlias("Department", "department");
 				crt.add(Restrictions.eq("department.Id", patientDepartment));
 				map.put("patientDepartment", patientDepartment);
 		 }
 		 if(null !=name && !name.equals("")){
 				crt.add(Restrictions.ilike("hin.FullName",  name + "%"));
 				map.put("Name", name);
 			}
 		if(null !=mobileNo && !mobileNo.equals("")){
 			crt.add(Restrictions.eq("hin.MobileNumber",  mobileNo ));
 			map.put("MobileNo", mobileNo);
 		}
 		 if(!uhid.equals("")){
 				crt.add(Restrictions.eq("hin.HinNo",  uhid ));
 				map.put("uhid", uhid);
 			}
 		
 		noOfRecords = crt.list().size();
 		crt.setFirstResult((page - 1)*recordsPerPage);
 		crt.setMaxResults(recordsPerPage);
 		
 		visitList=crt.list();
 		
 		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
 		map.put("noOfPages", noOfPages);
 		map.put("currentPage", page);
 		
 		map.put("visitList", visitList);
 		map.put("departmentList", departmentList);
 		
 	} catch (Exception e) {
 		e.printStackTrace();
 	}
 	return map;

 }

 	@Override
 	public Map<String, Object> getAppointmentDetails(Map<String, Object> map) {
 		Session session = (Session) getSession();
 		List<AppPatientAppointments> appointments=null;
 		Integer hospitalId=0;
 		Integer hinId=0;
 		hinId=(Integer) map.get("hinId");
 		hospitalId=(Integer) map.get("hospitalId");
 		 URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
 	     Properties prop = new Properties();
 	     try {
 				prop.load(new FileInputStream(new File(resourcePath.getFile())));
 			} catch (Exception e1) {
 				e1.printStackTrace();
 			} 

 		try{
 			appointments = session.createCriteria(AppPatientAppointments.class)
 						.add(Restrictions.eq("Hin.Id",hinId))
 						.add(Restrictions.eq("Hospital.Id",hospitalId))
 						.addOrder(Order.desc("Id"))
 						.setMaxResults(1)
 						.list();
 				if(appointments.size()>0)
 				{
					map.put("appointmentNo",appointments.get(0).getAppointmentNo() );
					logger.debug("appointments list size"+appointments.size());
				}
 			}catch(Exception e){
 			e.printStackTrace();
 		}
 		return map;
 	}
 	

 @Override
 public List<String> getSessionForDepartment(int deptId, int hospitalId) {
 	Session session=(Session) getSession();
 	List<MasSession> sessionList= new ArrayList<>();
 	List<String> masSessionList= new ArrayList<>();
 	sessionList=session.createCriteria(MasSession.class).createAlias("Hospital", "hospId")
 			.createAlias("Department", "dept",CriteriaSpecification.LEFT_JOIN)
 	.add(Restrictions.eq("hospId.Id", hospitalId)).add(Restrictions.eq("Status", "y").ignoreCase())
 	.add(Restrictions.eq("dept.Id", deptId))
 	.list();
 	
 	if(sessionList.size() ==0){ // If department wise session is not available then hospital wise session will be used
 		sessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.isNull("Department"))
 				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
 	}
 	
 	Date currentSessionTime=new Date();
 	SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
 	String ct=parser.format(currentSessionTime);
 	try{
 		Date cur = parser.parse(ct);
 		
 		if(null !=sessionList && sessionList.size()>0) {
 			for(MasSession masSession:sessionList){ 
 					Date fromTime = parser.parse(masSession.getFromTime());
 					Date toTime = parser.parse(masSession.getToTime());
 					if(cur.after(fromTime) && cur.before(toTime)){
 						masSessionList.add(masSession.getId()+":"+masSession.getSessionName());
 					}
 			}
 		}
 		
 	}catch(Exception e){
 		e.printStackTrace();
 	}
 	
 	return masSessionList;
 }

 @Override
 public List<String> getServiceCentersList(int hospitalId,
 		String serviceCenterType) {
 	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
     Properties prop = new Properties();
     
     try {
 		prop.load(new FileInputStream(new File(resourcePath.getFile())));
 	} catch (Exception e1) {
 		
 		e1.printStackTrace();
 	} 
     Session session = (Session) getSession();
     int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));
     List<String> deptList= new ArrayList<>();
     List<MasDepartment> serviceCenters= new ArrayList<>();
     
     if(serviceCenterType.equalsIgnoreCase("op clinic")){
     	serviceCenters=session.createCriteria(MasInstituteDepartment.class)
 				.setProjection(Projections.property("Department"))
 				.add(Restrictions.eq("Institute.Id",hospitalId))
 				.add(Restrictions.eq("Status","y").ignoreCase())
 				.createAlias("Department", "dep")
 				.createAlias("dep.DepartmentType","DepartmentType")
 				.add(Restrictions.eq("DepartmentType.Id",departmentTpeId))
 				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
 				.addOrder(Order.asc("dep.DepartmentName"))
 				.list();
     	for(MasDepartment department:serviceCenters){
     		deptList.add(department.getId()+":"+department.getDepartmentName());
     	}
     }else if(serviceCenterType.equalsIgnoreCase("other")){
     	serviceCenters=session.createCriteria(MasInstituteDepartment.class)
     			.setProjection(Projections.property("Department"))
     			.add(Restrictions.eq("Institute.Id",hospitalId))
     			.add(Restrictions.eq("Status","y").ignoreCase())
     			.createAlias("Department", "dep")
     			.createAlias("dep.DepartmentType","DepartmentType")
     			.add(Restrictions.ne("DepartmentType.Id",departmentTpeId))
     			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
     			.addOrder(Order.asc("dep.DepartmentName"))
     			.list();
     	for(MasDepartment department:serviceCenters){
     		deptList.add(department.getId()+":"+department.getDepartmentName());
     	}
     }
 	
 	return deptList;
 }

 @SuppressWarnings("unchecked")
 public synchronized String generateUHIDForOtherPlatform(
 		Map<String, Object> objectMap) {
 	
 	
 	Session session = (Session) getSession();
 	
 	Map<String,Object> utilMap = new HashMap<>();
 	utilMap = HMSUtil.getCurrentDateAndTime();
 	String time = (String)utilMap.get("currentTime");
 	
 	
 	String hospitalCode = null; 
 	
 	if(null !=objectMap.get("hospitalCode"))
 		hospitalCode = (String) objectMap.get("hospitalCode");
 	

 	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
 	hbt.setFlushModeName("FLUSH_EAGER");
 	hbt.setCheckWriteOperations(false);
 	
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 	Date date=new Date();
 	String curDate=sdf.format(date);
 	Date currentDate = null;

 	int tsn = 0;
 	int id = 0;
 	String hinNo = "";
 	Date lastChangedate=null;
 	
 	Properties prop = new Properties();
 	try{
 		URL resourcePath = Thread.currentThread().getContextClassLoader()
 				.getResource("registration.properties"); 
 		prop.load(new FileInputStream(new File(resourcePath.getFile())));
 		
 	} catch (Exception e){
 		e.printStackTrace();
 	}
 	
 	
 	try {
 		currentDate = sdf.parse(curDate);
 		
 		
 		List<MasHospital> hospitalList =	session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalCode", hospitalCode)).list();
 		
 		
 			List<Object[]> adList = session
 					.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
 					.add(Restrictions.eq("TransactionPrefix", "HIN"))
 					// .add(Restrictions.eq("hosp.Id", hospitalId))
 					.add(Restrictions.eq("hosp.HospitalCode", hospitalCode))
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
 			else if(hospitalList.size()!=0) {
 				TransactionSequence transactionSequenceObj1 = new TransactionSequence();
 				tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 16-08-2016
 				transactionSequenceObj1.setTransactionSequenceNumber(tsn);
 				transactionSequenceObj1.setLastChgDate(date);
 				transactionSequenceObj1.setTransactionSequenceName("Hin No");
 				transactionSequenceObj1.setTransactionPrefix("HIN");
 				transactionSequenceObj1.setTablename("Patient");
 				transactionSequenceObj1.setCreatedby("admin");
 				transactionSequenceObj1.setStatus("Y");
 				transactionSequenceObj1.setHospital(hospitalList.get(0));
 				transactionSequenceObj1.setLastChgTime(time);
 				hbt.save(transactionSequenceObj1);
 			}

 		
 		if(null != lastChangedate && currentDate.compareTo(lastChangedate)>0){
 			tsn = Integer.parseInt(prop.getProperty("transaction_sequence_number")); // added by amit das on 03-08-2016 for duplicate hin_no problem in lean-server connectivity
 		TransactionSequence transactionSequenceObj = (TransactionSequence) session
 				.load(TransactionSequence.class, id);

 		transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
 		transactionSequenceObj.setLastChgDate(date);
 		hbt.update(transactionSequenceObj);
 		
 		
 		}
 		else{
 			if(id>0){
 			TransactionSequence transactionSequenceObj = (TransactionSequence) session
 					.load(TransactionSequence.class, id);

 			tsn = transactionSequenceObj.getTransactionSequenceNumber(); // added by amit das on 17-08-2016
 			transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
 			transactionSequenceObj.setLastChgDate(currentDate);
 			hbt.update(transactionSequenceObj);
 			}
 		}
 		objectMap.put("tsn", tsn+1);
 		hinNo = generateUHID(objectMap);
 		
 	}catch(Exception e){
 		e.printStackTrace();
 	}
 	return hinNo;
 }
@SuppressWarnings("unchecked")
public synchronized String generateUHID(
		Map<String, Object> objectMap) {
	
	String hospitalCode = null;
	
	if(null !=objectMap.get("hospitalCode"))
		hospitalCode = (String) objectMap.get("hospitalCode");
	

	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);

	int tsn = 0;
	String hinNo = "";
	if(null !=objectMap.get("tsn"))
		tsn = (Integer) objectMap.get("tsn");
	
	
	
	try {	
			// added by amit das on 09-08-2017 for adding extra 0 in sequence number
			if(tsn>0 && (int)(Math.log10(tsn)+1)==2)
			{
			hinNo = "000" + (tsn);
			
			}
			else if(tsn>0 && (int)(Math.log10(tsn)+1)==3)
			{
			hinNo = "00" + (tsn);
		
			}
			else if(tsn>0 && (int)(Math.log10(tsn)+1)==4)
			{
			hinNo = "0" + (tsn);
			
			}else if(tsn>0 && (int)(Math.log10(tsn)+1)==5)
			{
			hinNo = "" + (tsn);
			
			}
			else{
				hinNo = "0000" + (tsn);
			}
		
		
		if (hospitalCode != null)
			hinNo = generateTemporaryRegNumForAadhar(hinNo, hospitalCode);
		
	   } catch(Exception e){
		   e.printStackTrace();
	   }
		return hinNo;
    }


// added by amit das on 10-08-2017
@Override
public Map<String, Object> getPatientAppointmentDataForCentralServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(CentralServerPatientAppointmentData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<CentralServerPatientAppointmentData> centralServerPatientAppointmentData  =criteria.list();
		
		MasHospital masHospital=null;
		if(centralServerPatientAppointmentData!=null && centralServerPatientAppointmentData.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(centralServerPatientAppointmentData.get(0).getHospitalId().toString())); 
			dataMap.put("centralServerPatientAppointmentData", centralServerPatientAppointmentData);
		}
		if(masHospital!=null){
			dataMap.put("masHospital", masHospital);
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

// added by amit das on 10-08-2017
@Override
public Map<String, Object> getPatientAppointmentDataForLeanServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerPatientAppointmentData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerPatientAppointmentData> leanServerPatientAppointmentData = criteria.list();
		
		if(leanServerPatientAppointmentData!=null && leanServerPatientAppointmentData.size()>0){
			dataMap.put("leanServerPatientAppointmentData", leanServerPatientAppointmentData);
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
public String updateCentralServerPatientAppointmentData(
		CentralServerPatientAppointmentData centralServerPatientAppointmentData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientAppointmentDataSavedToServer="Y";
	  	centralServerPatientAppointmentData.setStatus(patientAppointmentDataSavedToServer);
	  	hbt.update(centralServerPatientAppointmentData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}

@Override
public String updateLeanServerPatientAppointmentData(
		LeanServerPatientAppointmentData leanServerPatientAppointmentData) {
	HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false); 
	  	String patientAppointmentDataSavedToLeanServer="Y";
	  	leanServerPatientAppointmentData.setStatus(patientAppointmentDataSavedToLeanServer);
	  	hbt.update(leanServerPatientAppointmentData);
	  	hbt.flush();
	  	hbt.clear();
	return "success";
}


private synchronized String generateTemporaryRegNumForAadhar(String HinNo,
															 String hospitalCode) {
	String temUHid = "";
	Calendar currentDate = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy"); 
	String dateNow = formatter.format(currentDate.getTime());
	
	if(hospitalCode!=null){
		temUHid = hospitalCode + dateNow + HinNo; 
	}

	logger.debug("temUHid " + temUHid);
	return temUHid;

}

@Override
public Map<String, Object> getPatientAppointmentUpdateDataForLeanServer() {
	 
		Map<String,Object> dataMap= new HashMap<>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerPatientAppointmentData.class)
				.add(Restrictions.eq("Status", "U").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerPatientAppointmentData> leanServerPatientAppointmentData = criteria.list();
		
		if(leanServerPatientAppointmentData!=null && leanServerPatientAppointmentData.size()>0){
			dataMap.put("leanServerPatientAppointmentData", leanServerPatientAppointmentData);
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
public Map<String, Object> showHeightWeight(String uhId) {
	Session session = (Session) getSession();
	HashMap<String, Object> map = new HashMap<>();
	Double height  = 0.0;
	Double weight  = 0.0;
	List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<>();
	List<Integer> maxIdList = new ArrayList<>();
	try{
				maxIdList = session.createCriteria(Visit.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", uhId))
						 .setProjection(Projections.max("Id")).list();
			
				
				if(maxIdList.size()>0 && maxIdList.get(0)!= null){
					opdPatientDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id", maxIdList.get(0))).list();
					if(opdPatientDetailsList.size()>0){
						height = opdPatientDetailsList.get(0).getHeight();
						weight= opdPatientDetailsList.get(0).getWeight();
					}
				}

	}
	 catch (Exception e){
			e.printStackTrace();
		}

	map.put("height", height);
	map.put("weight", weight);
	
	return map;
	}

@Override
public String isUnitExist(int hospitalId) {
	Session session = (Session) getSession();
	List<HospitalDoctorUnitM> unitExisted= new ArrayList<>();
	String unitExistQry="select * from hospital_doctor_unit_m where hospital_id ="+hospitalId+"";
	Query unitQuery=session.createSQLQuery(unitExistQry);
	unitExisted=unitQuery.list();
	if(unitExisted.size()>0){
		return "yes";
	}else {
		return "no";
	}
}


@SuppressWarnings("unchecked")
public Map<String, Object> getPatientDetailsForOPCard(Map<String, Object> mapForDs) {
	Map<String, Object> map = new HashMap<>();
	List<Visit> patientList = new ArrayList<>();
	String hospitalName="";
	String hospitalAddress="";
	int hinId = 0;
	List<String> depIdList = null;
	List<Integer> departmentIdList  = new ArrayList<>();
	List<MasHospital> hospitalList  = new ArrayList<MasHospital>();
	int hospitalId = 0;
	Session session = (Session) getSession();
	 Date currentDate=new Date();

	if (mapForDs.get("pHinId") != null) {
		hinId = (Integer) mapForDs.get("pHinId");
	}
	

	if (mapForDs.get("depIdList") != null) {
		depIdList = (List<String>) mapForDs.get("depIdList");
		
		if(depIdList!=null && depIdList.size()>0){
			for(String deptId : depIdList){
				if(!deptId.trim().equals(""))
				departmentIdList.add(Integer.parseInt(deptId));
			}
		}
	}
	

	if (mapForDs.get("hospitalId") != null) {
		hospitalId = (Integer) mapForDs.get("hospitalId");
		Criteria crit = session.createCriteria(MasHospital.class).add(Restrictions.eq("Id", hospitalId));
		hospitalList=crit.list();
		for(MasHospital hs: hospitalList){
			hospitalName=hs.getHospitalName();
			hospitalAddress=hs.getAddress();
			map.put("hospitalName", hospitalName);
			map.put("hospitalAddress", hospitalAddress);
		}
	}
	
	//Added by Arbind for Online Appointment
	if (mapForDs.get("appointmentDateOp") != null) {
		currentDate = (Date) mapForDs.get("appointmentDateOp");
	}
	
	try {


		Criteria crit = session.createCriteria(Visit.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("VisitStatus", "W").ignoreCase())
						.add(Restrictions.eq("VisitDate", currentDate));
		
		if (depIdList != null) {
			crit = crit.add(Restrictions.in("Department.Id", departmentIdList));
		}
		
		patientList = crit.list();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	map.put("patientList", patientList);
	//
	return map;
}

@Override
public Map<String, Object> showQuickRegistrationJsp(int deptId, int hospitalId) {

	logger.debug("Inside Method showQuickRegistrationJsp");

	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<>();

	List<Object[]> patientTypeList = new ArrayList<>();
	List<Object[]> otherCategoryList = new ArrayList<>();
	List<MasDistrict> districtList = new ArrayList<>();
	List<MasAdministrativeSex> sexList = new ArrayList<>();
	HospitalParameters hospitalParameters = new HospitalParameters();
	List<Object[]> postCodeList = new ArrayList<>();
	List<MasLsgType> lsgTypeList = new ArrayList<>();
	List<MasScheme> schemeList= new ArrayList<>();

	MasSetupParameterMaintaince systemParam = new MasSetupParameterMaintaince();


	int hospitalTypeId = 0;

	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	Properties prop = new Properties();

	try {
		prop.load(new FileInputStream(new File(resourcePath.getFile())));
	} catch (Exception e1) {

		e1.printStackTrace();
	} 
	hospitalTypeId =Integer.parseInt(prop.getProperty("hospitalTypeId"));
	int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));

	int stateId=Integer.parseInt(prop.getProperty("stateId"));



	try {
		String queryForCaste = "select caste_id,caste_name from mas_caste where status='Y' ";


		districtList = session.createCriteria(MasDistrict.class)
				.addOrder(Order.asc("DistrictName"))
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();


		sexList = session.createCriteria(MasAdministrativeSex.class)
				.addOrder(Order.asc("AdministrativeSexName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();




		lsgTypeList = session.createCriteria(MasLsgType.class)
				.addOrder(Order.asc("LsgTypeName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();



		schemeList = session.createCriteria(MasScheme.class)
				.addOrder(Order.asc("SchemeName"))
				.add(Restrictions.eq("Status", "Y")).list();
		
		
		String queryForPatientType = "select  patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where status=upper('y') or status=lower('Y')  and Type='s' ORDER BY patient_type_name ASC";
		patientTypeList = session.createSQLQuery(queryForPatientType)
				.list();

		String queryPatientType = "select patient_type_id,patient_type_code,patient_type_name,validity from mas_patient_type where status=upper('y') or status=lower('Y') and Type='o' ORDER BY patient_type_name ASC";
		otherCategoryList = session.createSQLQuery(queryPatientType).list();


		List<HospitalParameters> hospitalParametersList = new ArrayList<>();
		Criteria c = session.createCriteria(HospitalParameters.class);

		hospitalParametersList = c.list();

		if (hospitalParametersList != null
				&& hospitalParametersList.size() > 0) {
			hospitalParameters = hospitalParametersList.get(0);
		}


		Criteria crit = session.createCriteria(
				MasSetupParameterMaintaince.class)
				.addOrder(Order.asc("Id"));

		crit.setFirstResult(0);
		crit.setMaxResults(1);



	} catch (HibernateException e) {
		e.printStackTrace();
	}
	map.put("systemParam", systemParam);
	map.put("hospitalParameters", hospitalParameters);
	map.put("patientTypeList", patientTypeList);

	map.put("otherCategoryList", otherCategoryList);

	List<MasDepartment> departmentList = new ArrayList<>();

	/*departmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.eq("DepartmentType.Id",departmentTpeId))  commented by Srikanth 15-01-2018
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();*/
	
	
	Query query = session.createSQLQuery("select  dep1_.department_name_image,dep1_.department_id,dep1_.department_code,dep1_.department_name,dep1_.department_type_id,dep1_.cost_center_id,dep1_.status,dep1_.last_chg_by,dep1_.last_chg_date,dep1_.last_chg_time,dep1_.bed_strength,dep1_.modality_name,dep1_.store_type,dep1_.hospital_id,dep1_.dept_description,dep1_.payward_check,dep1_.service_center,dep1_.web_portal_display,dep1_.emp_dept_id,dep1_.visit_applicable from mas_institute_department this_ inner join mas_department dep1_ on this_.department_id=dep1_.department_id inner join mas_department_type department2_ on dep1_.department_type_id=department2_.department_type_id where this_.institute_id="+hospitalId+" and lower(this_.status)='y'  and lower(dep1_.visit_applicable)='y' GROUP BY dep1_.department_id order by dep1_.department_name asc").addEntity(MasDepartment.class);
	departmentList=query.list();
	
	map.put("departmentList", departmentList);

	map.put("lsgTypeList", lsgTypeList);
	map.put("sexList", sexList);
	map.put("districtList", districtList);
	map.put("schemeList", schemeList);

	return map;
}

@Override
public Map<String, Object> getLocalityAutocomplete(String locality) {
	logger.debug("Inside Method getLocalityAutocomplete");

	Session session = (Session) getSession();
	List<Object[]> localityList = new ArrayList<>();
	Map<String, Object> map = new HashMap<>();
	
	localityList = session.createCriteria(PhMasLocality.class).add(Restrictions.ilike("LocalityName", "%"+locality+"%"))
			.addOrder(Order.asc("LocalityName"))
			.add(Restrictions.eq("Status", "Y").ignoreCase())
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("LocalityName")))
			.list();
	map.put("localityList", localityList);
	return map;
}

@Override
public Map<String, Object> getPatientDetailsForShortScreen(
		Map<String, Object> dataMap) {
	logger.debug("Inside Method: getPatientDetailsForShortScreen");

	Session session = (Session) getSession();
	Map<String, Object> map = new HashMap<>();

	List<Patient> patientDetailsList = new ArrayList<>();
	List<PatientAddress> addressList = new ArrayList<>();
	List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<>();
	List<Visit> visitList = new ArrayList<>();
	
	int visitNo = 0;
	int recordsPerPage = 5;
	int hospitalId=(Integer)dataMap.get("hospitalId");
	int hinId = (Integer)dataMap.get("hinId");
	try {

		patientDetailsList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("Id", hinId)).list();
		
		addressList = session.createCriteria(PatientAddress.class).createAlias("AddressType", "addType").add(Restrictions.eq("addType.AddressTypeCode", "P").ignoreCase())
				.add(Restrictions.eq("Hin.Id", hinId)).list();
		
			
		visitList = session.createCriteria(Visit.class)
				.createAlias("Hin", "hin")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("Hin.Id", hinId)).list();

		if (visitList.size() > 0) {
			for (Visit vist : visitList) {
				visitNo = vist.getVisitNo();

			}

		}
						
		visitNo = visitNo + 1;
		

		opdPatientDetailsList = session.createCriteria(OpdPatientDetails.class)
				.createAlias("Visit", "visit")
				.createAlias("visit.Hin", "hin")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("ReviewDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("hin.Id", hinId)).list();
		
		map.put("patientDetailsList", patientDetailsList);
		map.put("opdPatientDetailsList", opdPatientDetailsList);
		map.put("addressList", addressList);
		map.put("visitNo", visitNo);
		
	} catch (Exception e) {
		e.printStackTrace();
	}

	return map;
}

@Override
public Map<String, Object> showEditVisitDetails(Map<String, Object> dataMap) {
	Session session=(Session)getSession();
	List<Object[]> deptList = new ArrayList<Object[]>();
	Map<Integer,String> deptMap=new HashMap<Integer,String>();
	Map<String, Object> map=new HashMap<String,Object>();
	List<MasDepartment> departmentList = new ArrayList<>();
	int hospitalId=0;
	if(dataMap.get("hospitalId")!=null){
		hospitalId=Integer.parseInt(String.valueOf(dataMap.get("hospitalId")));
	}
	
	/*String sqlDeptQry="select distinct a.department_id, b.department_name from visit a  , mas_department b where a.department_id = b.department_id and a.visit_date = :currentDate and a.hospital_id = :hospitalId and visit_status <> 'P'  order by b.department_name";
	Query query = session.createSQLQuery(sqlDeptQry);
	query.setParameter("currentDate", new Date());
	query.setParameter("hospitalId", hospitalId);
	deptList=query.list();
	
	for(Object[] dept:deptList){
		deptMap.put(Integer.parseInt(String.valueOf(dept[0])), String.valueOf(dept[1]));
	}*/
	departmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.eq("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
	if(departmentList.size()>0){
		
		for(MasDepartment dept:departmentList){
			deptMap.put(dept.getId(), dept.getDepartmentName());
		}
		
	}
	map.put("departmentList",deptMap);
	int deptId=0;
	if(dataMap.get("deptId")!=null){
		deptId=Integer.parseInt(String.valueOf(dataMap.get("deptId")));
	}
	int docId=0;
	if(dataMap.get("docId")!=null){
		docId=Integer.parseInt(String.valueOf(dataMap.get("docId")));
	}
	
	List<Visit> patientList=new ArrayList<Visit>();
	if(docId==0){
		Criteria criteria= session.createCriteria(Visit.class).createAlias("Doctor", "docotor",CriteriaSpecification.LEFT_JOIN)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("VisitDate", new Date()))
				.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.isNull("docotor.Id"))
				.add(Restrictions.eq("dept.Id", deptId))
				//.addOrder(Order.desc("DisplayAfterNo"))
				.addOrder(Order.asc("TokenNo"));
				
		patientList=criteria.list();
		
		
	}else{
		/*Criteria criteria= session.createCriteria(Visit.class).createAlias("Doctor", "docotor",CriteriaSpecification.LEFT_JOIN)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("VisitDate", new Date()))
				.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("docotor.Id", docId))
				.add(Restrictions.eq("dept.Id", deptId))
				.addOrder(Order.desc("DisplayAfterNo"))
				.addOrder(Order.desc("TokenNo"));
				
		patientList=criteria.list();
		*/
		List<Visit> patientList2=new ArrayList<Visit>();
		Criteria criteria2=session.createCriteria(QueueManagment.class)
		.setProjection(Projections.property("Visit"))
		.createAlias("Visit", "visit")
		.createAlias("Department", "dept")
		//.createAlias("Docotor", "docotor")
		
		.add(Restrictions.eq("LsCngDate", new Date()))
		.add(Restrictions.ne("TokenStatus", "c").ignoreCase())
		.add(Restrictions.eq("Hospital.Id", hospitalId))
		.add(Restrictions.or(Restrictions.eq("InitialDr.Id",docId),Restrictions.eq("AssignedDoctorId",docId)))
		//.add(Restrictions.eq("AssignedDoctorId", docId))
		.add(Restrictions.eq("dept.Id", deptId))
		//.addOrder(Order.asc("visit.DisplayAfterNo"))
		.addOrder(Order.asc("visit.TokenNo"));
		
		patientList=criteria2.list();
	}
	
	
	map.put("patients", patientList);
	
	map.put("hospitalId", hospitalId);
	map.put("depatmentId", deptId);
	Map<String,Object> docMap=new HashMap<String,Object>();
	
	List<MasEmployee> doctorsLisst=new ArrayList<MasEmployee>();
	map.put("forGrid", "yes");
	docMap=getDoctorsForDept(map);
	if(docMap.get("DoctorsObjects")!=null){
		doctorsLisst=(List<MasEmployee>)docMap.get("DoctorsObjects");
	}
	Map<Integer,MasEmployee> doctorsMap=new HashMap<Integer,MasEmployee>();
	if(doctorsLisst.size()>0){
		for(MasEmployee doc:doctorsLisst){
			doctorsMap.put(doc.getId(), doc);
		}
	}
	doctorsLisst.clear();
	for(Map.Entry<Integer, MasEmployee> doctMap:doctorsMap.entrySet()){
		doctorsLisst.add(doctMap.getValue());
	}
	//doctorsLisst=(List<MasEmployee>) doctorsMap.values();
	map.put("DoctorsObjects", doctorsLisst);
	Map<Integer,String> doctorNameMap=new HashMap<Integer,String>();
	if(doctorsLisst.size()>0){
		for(MasEmployee emps:doctorsLisst){
			doctorNameMap.put(emps.getId(), emps.getEmployeeName());
		}
	}
	map.put("doctorNameMap", doctorNameMap);
	
	/*if(docId!=0 && deptId!=0){
		MasEmployee docEmp=(MasEmployee) session.load(MasEmployee.class, docId);
		MasDepartment masDept=(MasDepartment) session.load(MasDepartment.class, deptId);
		Map<Integer,String> doctorNameMap=new HashMap<Integer,String>();
		if(docEmp!=null){
			doctorNameMap.put(docEmp.getId(),docEmp.getEmployeeName());
		}
		map.put("doctorNameMap", doctorNameMap);
	}*/
	
	
	map.put("doctorId", docId);
	/*map.put("doctorObj",docEmp);
	map.put("deptObj",masDept);*/
	List<MasEmployee> doctorsLisst2=new ArrayList<MasEmployee>();
	if(map.get("forGrid")!=null){
		map.remove("forGrid");
		docMap=getDoctorsForDept(map);
		if(docMap.get("DoctorsObjects")!=null){
			doctorsLisst2=(List<MasEmployee>)docMap.get("DoctorsObjects");
			map.put("DoctorsObjects2", doctorsLisst2);
		}
	}
	return map;
}

@Override
public Map<String, Object> getDoctorsForDept(Map<String, Object> dataMap) {
	Session session = (Session) getSession();
	List<HospitalDoctorUnitM> unitList= new ArrayList<HospitalDoctorUnitM>();
	List<MasEmployee> DoctorsList= new ArrayList<MasEmployee>();
	int hospitalId=0;
	if(dataMap.get("hospitalId")!=null){
		hospitalId=Integer.parseInt(String.valueOf(dataMap.get("hospitalId")));
	}
	int deptId=0;
	
	if(dataMap.get("depatmentId")!=null){
		deptId=Integer.parseInt(String.valueOf(dataMap.get("depatmentId")));
	}
	
	List<MasDepartment> serviceCenterList=new ArrayList<MasDepartment>();
	serviceCenterList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.add(Restrictions.eq("dep.Id",deptId)).list();
	
	int serviceCenterId=0;
	if(serviceCenterList.size()>0){
		serviceCenterId=serviceCenterList.get(0).getEmpDept().getId();
	}
	
	String unitDay=HMSUtil.getDayOfWeek().toLowerCase();
	if(serviceCenterId>0){
		unitList=session.createCriteria(HospitalDoctorUnitM.class)
			 .createAlias("EmpDept", "EmpDept")
			 .createAlias("Hospital", "Hospital")
			 .add(Restrictions.eq("Hospital.Id", hospitalId))
			 .add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
			  .add(Restrictions.eq("EmpDept.Id", serviceCenterId)).list();
	}
	
	List<HospitalDoctorUnitT> docLst=new ArrayList<HospitalDoctorUnitT>();
	if(unitList.size()>0){
		int unitId=unitList.get(0).getId();
		//dataMap=populateDoctorForUnit(unitId,deptId);
		if(dataMap.get("forGrid")!=null){
			dataMap=doctorsAvailableForUnit(unitId,deptId);
		}else{
			dataMap=doctorsForUnit(unitId,deptId);
		}
		
		if(dataMap.get("doctorList")!=null){
			docLst.addAll((List<HospitalDoctorUnitT>)dataMap.get("doctorList"));
		}
		if(dataMap.get("headdoctorList")!=null){
			docLst.addAll((List<HospitalDoctorUnitT>)dataMap.get("headdoctorList"));
		}
		if(docLst.size()>0){
			for(HospitalDoctorUnitT doct:docLst){
				DoctorsList.add(doct.getEmployee());
			}
		}
	}
	
	Map<Integer,MasEmployee> doctorsMap=new HashMap<Integer,MasEmployee>();
	if(DoctorsList.size()>0){
		for(MasEmployee doc:DoctorsList){
			doctorsMap.put(doc.getId(), doc);
		}
	}
	DoctorsList.clear();
	for(Map.Entry<Integer, MasEmployee> doctMap:doctorsMap.entrySet()){
		DoctorsList.add(doctMap.getValue());
	}
	
	List<String> doctors=new ArrayList<String>();
	if(DoctorsList.size()>0){
		for(MasEmployee emp:DoctorsList){
			doctors.add(emp.getId()+":"+emp.getEmployeeName());
		}
	}
	
	dataMap.put("DoctorsObjects", DoctorsList);
	dataMap.put("DoctorsList", doctors);
	return dataMap;
}

@Override
public Map<String, Object> submitEditVisitDetails(Box box) {
	Session session = (Session) getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	int maxDisplayAfterNo = 0;
	int patientCount =0;
	int empDepartmentId = 0;
	int transferToCommonCount = 0;
	int transferToOtherDoctorCount = 0;
	int departmentId = box.getInt("departmentId");
	int employeeId = box.getInt("userId");
	if(box.getString("patientCount")!=null){
		patientCount=Integer.parseInt(box.getString("patientCount"));
	}
	int hospitalId=box.getInt("hospitalId");
	
	boolean success=false;
	Criteria criteria = null;
	List<Integer> visitIds=new ArrayList<Integer>();
	List<Integer> docotrList=new ArrayList<Integer>();
	Map<Integer,String> deptMap=new HashMap<Integer,String>();
	List<MasDepartment> departmentList = new ArrayList<>();
	List<HospitalDoctorUnitM> unitList = null;
	List<QueueManagment> nextQueueList = null;
	List<Integer> maxDisplayAfterNoList  = null;
	List<Integer> drList = null;
	String commonPool="";
	Date currentDate =  new Date();
	String unitDay=HMSUtil.getDayOfWeek().toLowerCase();
	if(box.getString("commonPool")!=null){
		commonPool=box.getString("commonPool");
	}
	
	
	for(int i=1;i<=patientCount;i++){
		int visitId=0;
		int docId=0;
		if(box.getInt("visitId"+i)!=0){
			visitId=box.getInt("visitId"+i);
			visitIds.add(visitId);
			
			if(box.getInt("doctors"+i)!=0){
				docId=box.getInt("doctors"+i);
				docotrList.add(docId);
			}
		}
		
	}
	
	try{
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		if(departmentList.size()>0){
			
			for(MasDepartment dept:departmentList){
				deptMap.put(dept.getId(), dept.getDepartmentName());
			}
			
		}
		map.put("departmentList",deptMap);
		List<QueueManagment> queuemgtList=new ArrayList<QueueManagment>();
		if(!commonPool.equalsIgnoreCase("") && commonPool.equalsIgnoreCase("commonPool")){
			
			
			 criteria = session.createCriteria(MasInstituteDepartment.class)
						.setProjection(Projections.property("Department"))
						.add(Restrictions.eq("Institute.Id",hospitalId))
						.add(Restrictions.eq("Status","y").ignoreCase())
						.add(Restrictions.eq("Department.Id",departmentId));

			 departmentList=criteria.list();
				if(departmentList!=null && departmentList.size()>0){
					empDepartmentId = departmentList.get(0).getEmpDept().getId();
				}
				
							
				criteria = session.createCriteria(HospitalDoctorUnitM.class)
						.createAlias("EmpDept", "EmpDept")
						.createAlias("Hospital", "Hospital")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
						.add(Restrictions.eq("EmpDept.Id", empDepartmentId));
				unitList = criteria.list();

				if(unitList!=null && unitList.size() > 0){
					criteria = session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM").add(Restrictions.eq("UnitM.Id", unitList.get(0).getId())).add(Restrictions.eq("UnitM.Status", "y").ignoreCase())
							.createAlias("Employee", "emp",CriteriaSpecification.LEFT_JOIN).createAlias("emp.Users", "u").createAlias("u.CurrentCounter", "cc").createAlias("u.Department", "d")
							.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase()).addOrder(Order.asc("cc.CounterNo")).add(Restrictions.eq("d.Id", departmentId)).add(Restrictions.isNotNull("cc.CounterNo"))
							.add(Restrictions.eq("u.LoginStatus", "y").ignoreCase()).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("u.Status", "y").ignoreCase())
							.setProjection(Projections.projectionList().add(Projections.property("emp.Id")));
					drList = criteria.list();
				}
				
				if(drList!=null && drList.size()>0){
					
						 criteria = session.createCriteria(QueueManagment.class)
								 .createAlias("Visit", "v")
								.add(Restrictions.eq("LsCngDate", currentDate))
								.add(Restrictions.eq("TokenStatus", "w").ignoreCase())
								.add(Restrictions.eq("Hospital.Id", hospitalId))
								.add(Restrictions.eq("Department.Id", departmentId))
								.add(Restrictions.in("AssignedDoctorId", drList))
								.setProjection(Projections.projectionList().add(Projections.max("v.DisplayAfterNo")));
							
						 maxDisplayAfterNoList = criteria.list();
					if(maxDisplayAfterNoList!=null && maxDisplayAfterNoList.size()>0){
						 maxDisplayAfterNo =	maxDisplayAfterNoList.get(0);
					}
					
				}	
				
			/* if(maxDisplayAfterNo>0){
				 criteria = session.createCriteria(QueueManagment.class)
						 .createAlias("Visit", "v")
						.add(Restrictions.eq("LsCngDate", currentDate))
						.add(Restrictions.eq("TokenStatus", "w").ignoreCase())
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Department.Id", departmentId))
						.add(Restrictions.gt("v.DisplayAfterNo", maxDisplayAfterNo)).addOrder(Order.asc("v.DisplayAfterNo"));
				 nextQueueList = criteria.list();
				 
			} */
			
			for(int i=1;i<=patientCount;i++){
				int visitId=box.getInt("commonPoolPatient"+i);
				Visit visit=(Visit)session.load(Visit.class, visitId);
				visit.setDoctor(null);
				visit.setDoctorName(null);
				visit.setOpenat("");
				queuemgtList=session.createCriteria(QueueManagment.class)
						.add(Restrictions.eq("Visit.Id", visitId)).list();
				
				if(queuemgtList.size()>0){
					QueueManagment que=queuemgtList.get(0);
					que.setAssignedDoctorId(null);
					que.setInitialDr(null);
					
					if(que.getTransferToCommonPoolCount()!=null)
						transferToCommonCount =	que.getTransferToCommonPoolCount();
					
					que.setTransferToCommonPoolCount(transferToCommonCount+1);
					session.update(que);
						if(maxDisplayAfterNo>0){
							maxDisplayAfterNo++;
							visit.setDisplayAfterNo(maxDisplayAfterNo);
							visit.setLastDisplayAfterNo(maxDisplayAfterNo);
						}
						session.update(visit);
					
				}
				
				session.flush();
				success=true;
			}
			
		/* if(nextQueueList!=null && nextQueueList.size()>0){
				for(QueueManagment queueManagment : nextQueueList){
					Visit visit =	queueManagment.getVisit();
					if(maxDisplayAfterNo>0){
						maxDisplayAfterNo++;
						visit.setDisplayAfterNo(maxDisplayAfterNo);
						visit.setLastDisplayAfterNo(maxDisplayAfterNo);
					}
					session.update(visit);
			}
			} */
			session.flush();
			
			
		}else{
			for(int i=0;i<visitIds.size();i++){
				transferToOtherDoctorCount = 0;
				Visit visit=(Visit)session.load(Visit.class, visitIds.get(i));
				MasEmployee doctor=(MasEmployee)session.load(MasEmployee.class, docotrList.get(i));
				//doctor.setId(docotrList.get(i));
				visit.setDoctor(doctor);
				visit.setDoctorName(doctor.getEmployeeName());
				//List<QueueManagment> queuemgtList=new ArrayList<QueueManagment>();
				queuemgtList=session.createCriteria(QueueManagment.class)
						.add(Restrictions.eq("Visit.Id", visitIds.get(i))).list();
				
				if(queuemgtList.size()>0){
					QueueManagment que=queuemgtList.get(0);
				
					if(que.getTransferToOtherDoctorCount()!=null)
						transferToOtherDoctorCount = que.getTransferToOtherDoctorCount();
					
					if(que.getAssignedDoctorId()!=docotrList.get(i))
						transferToOtherDoctorCount = transferToOtherDoctorCount+1;
						
					que.setTransferToOtherDoctorCount(transferToOtherDoctorCount);
					que.setAssignedDoctorId(docotrList.get(i));
					que.setInitialDr(doctor);
					session.update(que);
				}
				
				session.update(visit);
				session.flush();
				success=true;
			}
		}
		
		
	}catch(Exception e){
		success=false;
	}
	map.put("success", success);
	return map;
}

@Override
public List<Object[]> getLocalityId(String localityName) {
	List<Object[]> localityList = new ArrayList<>();
	Session session = (Session) getSession();
	localityList = session.createCriteria(PhMasLocality.class).createAlias("Ward", "w").add(Restrictions.eq("LocalityName", localityName).ignoreCase())
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("w.Id")).add(Projections.property("w.District.Id"))).list();
	
	return localityList;
}

@Override
public void updateDrWiseTokenDisplay() {
	Session session = (Session) getSession();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	Properties prop = new Properties();
	try {
		prop.load(new FileInputStream(new File(resourcePath.getFile())));
	} catch (Exception e1) {

		e1.printStackTrace();
	} 
	int departmentTpeId=Integer.parseInt(prop.getProperty("departmentTpeId"));
	try {
		List<Object[]> departmentList = session.createCriteria(MasInstituteDepartment.class).createAlias("Department", "d").createAlias("Institute", "ins")
				.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("ins.ActiveHospital", "y").ignoreCase()).add(Restrictions.eq("ins.Status", "y").ignoreCase())
				.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("d.Id"))
						.add(Projections.property("d.DepartmentName")).add(Projections.property("d.EmpDept.Id")).add(Projections.property("ins.Id"))))
						.createAlias("d.DepartmentType","DepartmentType").add(Restrictions.eq("DepartmentType.Id",departmentTpeId))
						.list();
		//logger.info("  departmentList size : "+departmentList.size());
		int departmentId = 0;
		int hospitalId = 0;
		for(Object[] department:departmentList){
			hospitalId =(Integer)department[3];
			departmentId = (Integer)department[0];
			List<Object[]> deptWisecounterList=session.createQuery("select mscc.Id, mscc.CounterNo from MasServiceCentreCounter as mscc where mscc.Hospital.Id = '"
					+ hospitalId + "' and mscc.Department.Id ="+departmentId
					+ "order by (case when (CounterNo between '1' and '99999') then cast(CounterNo as integer) end), CounterNo").list(); 

			//logger.info("  hospitalId : "+hospitalId+" ---- departmentId : "+departmentId);
		
			String unitDay=HMSUtil.getDayOfWeek().toLowerCase();
			List<HospitalDoctorUnitM> unitList= session.createCriteria(HospitalDoctorUnitM.class)
					.createAlias("EmpDept", "EmpDept")
					.createAlias("Hospital", "Hospital")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
					.add(Restrictions.eq("EmpDept.Id", (Integer)department[2])).list();


			List<Object[]> drList = new ArrayList<>();
			if(unitList.size() > 0){
				drList = session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM").add(Restrictions.eq("UnitM.Id", unitList.get(0).getId())).add(Restrictions.eq("UnitM.Status", "y").ignoreCase())
						.createAlias("Employee", "emp",CriteriaSpecification.LEFT_JOIN).createAlias("emp.Users", "u").createAlias("u.CurrentCounter", "cc").createAlias("u.Department", "d")
						.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase()).addOrder(Order.asc("cc.CounterNo")).add(Restrictions.eq("d.Id", departmentId)).add(Restrictions.isNotNull("cc.CounterNo"))
						.add(Restrictions.eq("u.LoginStatus", "y").ignoreCase()).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("u.Status", "y").ignoreCase())
						.setProjection(Projections.projectionList().add(Projections.property("u.CurrentCounter.Id")).add(Projections.property("emp.Id"))
								.add(Projections.property("emp.FirstName")).add(Projections.property("emp.EmployeeImage"))).list();

				int rowWiseTokenCount =0;
				if(drList.size() > 0){
					rowWiseTokenCount = drList.size();

					List<Object[]> currentQueueList = new ArrayList<Object[]>();

					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					String[][] tokens = new String[3][drList.size()];
					String[] tokenStatusArray = {"C","c","P","p","A","a"};

					Criteria criteria = null;
					Date currentDate = new Date();

					currentQueueList = session.createCriteria(QueueManagment.class).createAlias("Hospital", "h").createAlias("Department", "d")
							.createAlias("Visit", "v").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.not(Restrictions.in("TokenStatus", tokenStatusArray)))
							.add(Restrictions.eq("d.Id", departmentId)).add(Restrictions.eq("LsCngDate", currentDate))
							.addOrder(Order.asc("v.DisplayAfterNo")).addOrder(Order.asc("v.TokenNo"))
							.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("TokenNo"))
									.add(Projections.property("InitialDr.Id")).add(Projections.property("AssignedDoctorId"))
									.add(Projections.property("Docotor.Id")).add(Projections.property("PatientSpecialCategory"))).list();


					if(currentQueueList.size() > 0){
						String token = "";
						List addedToken =new ArrayList();
						int queueDrId =0;
						int assignedDrId =0;
						int counter = 0;
						int ktr = 0;
						int newKtr = 0;

						for (int i = 0; i < 3; i++) {
							int endCounter = drList.size()*(i+1);

							ktr=0;
							
							while(ktr<drList.size()){
								for(int j = 0; j < drList.size(); j++){
									Object[] drobj = drList.get(j); 
									int drId = (Integer)drobj[1];
									
									counter = 0;
									for(int k=0;k<endCounter;k++){
										if(k<currentQueueList.size()){
											newKtr =0;
											Object[] queueMgt = currentQueueList.get(k);
											token = queueMgt[1].toString();
											queueDrId = queueMgt[2]!=null?(Integer)queueMgt[2]:0;
											assignedDrId=queueMgt[3]!=null?(Integer)queueMgt[3]:0;
											String splCategory = queueMgt[5]!=null?(String)queueMgt[5]:"";
											
											if(addedToken!=null && !addedToken.contains(token) && tokens[i][j]==null){
												if(queueDrId !=0 && drId == queueDrId  && assignedDrId==0){
													tokens[i][j] = token;
													
													QueueManagment qM = (QueueManagment)hbt.get(QueueManagment.class, Integer.parseInt(queueMgt[0].toString()));
													qM.setAssignedDoctorId(drId);
													MasEmployee employee = new MasEmployee();
													employee.setId((Integer)drobj[1]);
													qM.setInitialDr(employee);
													hbt.update(qM);
													addedToken.add(token.trim());
													newKtr++;
													ktr++;
													break;


												}else{
													if(assignedDrId == drId){
														tokens[i][j] = token;
													
														QueueManagment qM = (QueueManagment)hbt.get(QueueManagment.class, Integer.parseInt(queueMgt[0].toString()));
														qM.setAssignedDoctorId(drId);
														MasEmployee employee = new MasEmployee();
														employee.setId((Integer)drobj[1]);
														qM.setInitialDr(employee);
														hbt.update(qM);
														addedToken.add(token.trim());
														newKtr++;
														ktr++;

														break;
													}
												}
											}
										}
										counter++;
									}
									if(tokens[i][j]==null){
										counter=0;
										for (int k=0;k<endCounter;k++) {
											if(k<currentQueueList.size()){
												Object[] queueMgt = currentQueueList.get(k);
												token = queueMgt[1].toString();
												queueDrId = queueMgt[2]!=null?(Integer)queueMgt[2]:0;
												assignedDrId=queueMgt[3]!=null?(Integer)queueMgt[3]:0;
												String splCategory = queueMgt[5]!=null?(String)queueMgt[5]:"";
												
												if(addedToken!=null && !addedToken.contains(token) && tokens[i][j] ==null){
													if(queueDrId==0 && assignedDrId==0){
														tokens[i][j] = token;
														
														addedToken.add(token.trim());
														QueueManagment qM = (QueueManagment)hbt.get(QueueManagment.class, Integer.parseInt(queueMgt[0].toString()));
														qM.setAssignedDoctorId(drId);
														MasEmployee employee = new MasEmployee();
														employee.setId((Integer)drobj[1]);
														qM.setInitialDr(employee);
														hbt.update(qM);

														ktr++;
														break;

													}else {
														if(assignedDrId == drId){
															tokens[i][j] = token;
														
															QueueManagment qM = (QueueManagment)hbt.get(QueueManagment.class, Integer.parseInt(queueMgt[0].toString()));
															qM.setAssignedDoctorId(drId);
															MasEmployee employee = new MasEmployee();
															employee.setId((Integer)drobj[1]);
															qM.setInitialDr(employee);
															hbt.update(qM);
															addedToken.add(token.trim());

															ktr++;
															break;
														}
													}
												}
											}
											counter++;
										}
									}
								}

								int remainingToken = 0;
								remainingToken = drList.size()-ktr;
								endCounter = endCounter+remainingToken;

								if(counter >= currentQueueList.size()){
									break;
								}
							}

						}
					}
				}

			}
		}
	} catch (DataAccessException e) {
		logger.error("DataAccessException : "+e.getStackTrace().toString());
	} catch (NumberFormatException e) {
		logger.error("NumberFormatException : "+e.getStackTrace().toString());
	} catch (HibernateException e) {
		logger.error("HibernateException : "+e.getStackTrace().toString());
	}finally { 
		if(session!=null)
			session.close();
		
	}

}

@Override
public Map<String, Object> patientVisitDetails(Map<String, Object> dataMap) {
	Session session=(Session)getSession();
	List<Object[]> deptList = new ArrayList<Object[]>();
	Map<Integer,String> deptMap=new HashMap<Integer,String>();
	Map<String, Object> map=new HashMap<String,Object>();
	List<MasDepartment> departmentList = new ArrayList<>();
	int hospitalId=0;
	if(dataMap.get("hospitalId")!=null){
		hospitalId=Integer.parseInt(String.valueOf(dataMap.get("hospitalId")));
	}
	int tokenNumber=0;
	if(dataMap.get("tokenNumber")!=null && Integer.parseInt(String.valueOf(dataMap.get("tokenNumber")))!=0){
		tokenNumber=Integer.parseInt(String.valueOf(dataMap.get("tokenNumber")));
	}
	
	departmentList=session.createCriteria(MasInstituteDepartment.class)
			.setProjection(Projections.property("Department"))
			.add(Restrictions.eq("Institute.Id",hospitalId))
			.add(Restrictions.eq("Status","y").ignoreCase())
			.createAlias("Department", "dep")
			.createAlias("dep.DepartmentType","DepartmentType")
			.add(Restrictions.eq("DepartmentType.Id",1))
			.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
			.addOrder(Order.asc("dep.DepartmentName"))
			.list();
	if(departmentList.size()>0){
		
		for(MasDepartment dept:departmentList){
			deptMap.put(dept.getId(), dept.getDepartmentName());
		}
		
	}
	map.put("departmentList",deptMap);
	int deptId=0;
	if(dataMap.get("deptId")!=null){
		deptId=Integer.parseInt(String.valueOf(dataMap.get("deptId")));
	}
	int docId=0;
	if(dataMap.get("docId")!=null){
		docId=Integer.parseInt(String.valueOf(dataMap.get("docId")));
	}
	List<QueueManagment> patients=new ArrayList<QueueManagment>();
			Criteria criteria2=session.createCriteria(QueueManagment.class)
			.createAlias("Visit", "visit")
			.createAlias("Department", "dept")
			.add(Restrictions.eq("LsCngDate", new Date()))
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.add(Restrictions.eq("dept.Id", deptId))
			.addOrder(Order.asc("visit.TokenNo"));
			if(tokenNumber>0){
				criteria2.add(Restrictions.eq("TokenNo", tokenNumber));
				}
			patients=criteria2.list();
	
	map.put("patients2", patients);
	map.put("hospitalId", hospitalId);
	map.put("depatmentId", deptId);
	map.put("doctorId", docId);
	
	return map;
}

@Override
public Map<String, Object> submitPatientVisitDetails(Box box) {
	Session session = (Session) getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	int patientCount =0;
	int empDepartmentId = 0;
	int maxDisplayAfterNo = 0;
	String unrelease = "";
	int departmentId = box.getInt("deptId");
	int employeeId = box.getInt("userId");
	if(box.getString("patientCount")!=null){
		patientCount=Integer.parseInt(box.getString("patientCount"));
	}
	if(box.getString("unrelease")!=null){
		unrelease=box.getString("unrelease");
	}
	int hospitalId=box.getInt("hospitalId");
	
	boolean success=false;
	Criteria criteria = null;
	List<String> displayAfters=new ArrayList<String>();
	List<Integer> visitIds=new ArrayList<Integer>();
	List<Integer> docotrList=new ArrayList<Integer>();
	Map<Integer,String> deptMap=new HashMap<Integer,String>();
	List<MasDepartment> departmentList = new ArrayList<>();
	String displayAfter=null;
	int userId=0;
	Map<String,Object> utilMap = new HashMap<>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String time = (String)utilMap.get("currentTime");
	List<String> lst=new ArrayList<String>();
	if(box.get("displayAfter")!=null){
		lst=(List<String>)box.getArrayList("displayAfter");
	}
	if(box.get("userId")!=null){
		userId=(int)box.getInt("userId");
	}
	
	for(int i=1;i<=patientCount;i++){
		int visitId=0;
		int docId=0;
		if(box.getInt("visitId"+i)!=0){
			visitId=box.getInt("visitId"+i);
			visitIds.add(visitId);
			
			if(lst.get(i-1)!=null){
				displayAfter = lst.get(i-1);
				displayAfters.add(displayAfter);
			}
			
			if(box.getInt("doctors"+i)!=0){
				docId=box.getInt("doctors"+i);
				docotrList.add(docId);
			}
		}
	}
	
	try{
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType","DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id",1))
				.add(Restrictions.eq("dep.VisitApplicable","y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		if(departmentList.size()>0){
			for(MasDepartment dept:departmentList){
				deptMap.put(dept.getId(), dept.getDepartmentName());
			}
		}
		map.put("departmentList",deptMap);
		List<Object[]> visitList = session.createCriteria(Visit.class).add(Restrictions.eq("Department.Id",departmentId)).add(Restrictions.eq("Hospital.Id",hospitalId))
				.add(Restrictions.eq("VisitDate", new Date())).setProjection(Projections.projectionList().add(Projections.max("DisplayAfterNo"))).list();

		int displayNo=0;
		if(visitList.size()>0){
			displayNo = Integer.parseInt(visitList.get(0)+"");
		}
			for(int i=0;i<visitIds.size();i++){
				Visit visit=(Visit)session.get(Visit.class, visitIds.get(i));
				visit.setDisplayAfterNo(Integer.parseInt(displayAfters.get(i)));
				/*if(displayNo >= visit.getLastDisplayAfterNo()){
					visit.setDisplayAfterNo(displayNo+(i+1));
				}*/
				
				if(unrelease!=null && !"".equals(unrelease)&& "y".equalsIgnoreCase(unrelease)){
					List<QueueManagment> queueList = session.createCriteria(QueueManagment.class).add(Restrictions.eq("Visit.Id", visitIds.get(i))).list();
					QueueManagment queueManagement=new QueueManagment();
					if(queueList.size()>0){
						queueManagement = queueList.get(0);
						queueManagement.setTokenStatus("w");
					}
					session.update(queueManagement);
					session.flush();
				}				
				visit.setLastDisplayStatus("Manual");
				visit.setAddEditDate(new Date());
				visit.setAddEditTime(time);
				visit.setVisitStatus("w");
				visit.setTokenStatus("w");
				session.update(visit);
				session.flush();
				success=true;
			}
		
	}catch(Exception e){
		success=false;
	}
	map.put("success", success);
	return map;
}

public Map<String, Object> doctorsForUnit(int unitId,int deptId){
	Session session = (Session) getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	List<HospitalDoctorUnitT> doctorList = new ArrayList<HospitalDoctorUnitT>();
	
	doctorList=session.createCriteria(HospitalDoctorUnitT.class)
			.createAlias("UnitM", "unitM")
			.add(Restrictions.eq("unitM.Id", unitId))
			.add(Restrictions.eq("Status", "y").ignoreCase())
			.list();
	map.put("doctorList",doctorList);
	return map;
}

	public Map<String, Object> checkForDoctorWaitingPatients(Box box) {
		Map<String, Object> resultMap = new HashMap<>();
		Date currentDate = new Date();
		int noOfPatients = 0;
		int departmentId = box.getInt("departmentId");
		int hospitalId = box.getInt("hospitalId");
		int employeeId = box.getInt("employeeId");

		try {
			Session session = (Session) getSession();
			Criteria criteria = session.createCriteria(QueueManagment.class)
					.createAlias("Visit", "v")
					.add(Restrictions.or(Restrictions.eq("Docotor.Id", employeeId),Restrictions.eq("AssignedDoctorId", employeeId)))
					.add(Restrictions.eq("LsCngDate", currentDate))
					.add(Restrictions.ne("v.VisitStatus", "C").ignoreCase())
					.add(Restrictions.ne("TokenStatus", "c").ignoreCase())
					.add(Restrictions.ne("v.VisitStatus", "a").ignoreCase())
					.add(Restrictions.ne("TokenStatus", "a").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", departmentId))
					.setProjection(Projections.rowCount());
			noOfPatients = (Integer) criteria.list().get(0);
		} catch (Exception e) {
			logger.error(e);
		}

		resultMap.put("noOfPatients", noOfPatients);
		return resultMap;
	}

public Map<String, Object> doctorsAvailableForUnit(int unitId,int deptId){
	Session session = (Session) getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	List<HospitalDoctorUnitT> doctorList = new ArrayList<HospitalDoctorUnitT>();
	
	doctorList=session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM", "UnitM").add(Restrictions.eq("UnitM.Id", unitId)).add(Restrictions.eq("UnitM.Status", "y").ignoreCase())
	.createAlias("Employee", "emp",CriteriaSpecification.LEFT_JOIN).createAlias("emp.Users", "u").createAlias("u.CurrentCounter", "cc").createAlias("cc.Department", "d")
	.add(Restrictions.eq("u.AvailableToday", "y").ignoreCase()).addOrder(Order.asc("cc.CounterNo")).add(Restrictions.eq("d.Id", deptId)).add(Restrictions.isNotNull("cc.CounterNo"))
	.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("u.Status", "y").ignoreCase())
	/*.setProjection(Projections.projectionList().add(Projections.property("u.CurrentCounter.Id")).add(Projections.property("emp.Id"))
			.add(Projections.property("emp.FirstName")).add(Projections.property("emp.EmployeeImage")).add(Projections.property("cc.CounterNo")))*/
			.list();
	
	map.put("doctorList",doctorList);
	return map;
}

@Override
public Map<String, Object> getEmployeeDepartment(Map<String, Object> dataMap) {
	Map<String, Object> map = new HashMap<>();
	List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
	int deptId = 0;
	try {

		Session session = (Session) getSession();
		if(dataMap.get("deptId") != null){
		  deptId = (Integer) dataMap.get("deptId");
		}
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Id", deptId)).list();
		String empDeptCode = "";
		for (MasDepartment masDepartment : departmentList) {
			if(masDepartment.getEmpDept() != null){
				empDeptCode = (String)masDepartment.getEmpDept().getEmpDeptCode();
				map.put("empDeptCode", empDeptCode);
			}

		}


	} catch (Exception e) {
		e.printStackTrace();
	}
	return map;
}

@Override
public Map<String, Object> showTransferPatientListJsp(Map<String, Object> dataMap) {
	Session session=(Session)getSession();
	List<Visit> patientList=new ArrayList<Visit>();
	Map<String, Object> map=new HashMap<String,Object>();
	Map<String, Object> map2=new HashMap<String,Object>();
	int hospitalId=0;
	if(dataMap.get("hospitalId")!=null){
		hospitalId=Integer.parseInt(String.valueOf(dataMap.get("hospitalId")));
		map2.put("hospitalId", hospitalId);
	}
	int deptId=0;
	if(dataMap.get("deptId")!=null){
		deptId=Integer.parseInt(String.valueOf(dataMap.get("deptId")));
		map2.put("depatmentId", deptId);
	}
	int docId=0;
	if(dataMap.get("docId")!=null){
		docId=Integer.parseInt(String.valueOf(dataMap.get("docId")));
	}
	
	Criteria criteria=session.createCriteria(QueueManagment.class)
			.setProjection(Projections.property("Visit"))
			.createAlias("Visit", "visit")
			.createAlias("Department", "dept")
			//.createAlias("Docotor", "emp")
			//.createAlias("Docotor", "docotor")
			
			.add(Restrictions.eq("LsCngDate", new Date()))
			.add(Restrictions.ne("TokenStatus", "c").ignoreCase())
			.add(Restrictions.eq("Hospital.Id", hospitalId))
			.add(Restrictions.or(Restrictions.eq("InitialDr.Id",docId),Restrictions.eq("AssignedDoctorId",docId)))
			//.add(Restrictions.eq("AssignedDoctorId", docId))
			.add(Restrictions.eq("dept.Id", deptId))
			//.addOrder(Order.asc("visit.DisplayAfterNo"))
			.addOrder(Order.asc("visit.TokenNo"));
			
			patientList=criteria.list();
			
			map.put("patients", patientList);
			
			Map<String,Object> docMap=new HashMap<String,Object>();
			List<MasEmployee> doctorsLisst=new ArrayList<MasEmployee>();
			List<MasEmployee> doctorsList=new ArrayList<MasEmployee>();
			map2.put("forGrid", "yes");
			docMap=getDoctorsForDept(map2);
			if(docMap.get("DoctorsObjects")!=null){
				doctorsLisst=(List<MasEmployee>)docMap.get("DoctorsObjects");
				if(doctorsLisst.size()>0){
					for(MasEmployee emp:doctorsLisst){
						if(!emp.getId().equals(docId)){
							doctorsList.add(emp);
						}
					}
				}
			}
			map.put("DoctorsObjects", doctorsList);
			
	        return map;
}

@Override
public Map<String, Object> submitTransferPatients(Box box) {

	Session session = (Session) getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	int maxDisplayAfterNo = 0;
	int patientCount =0;
	int transferToOtherDoctorCount = 0;
	List<Integer> visitIds=new ArrayList<Integer>();
	List<Integer> docotrList=new ArrayList<Integer>();
	List<QueueManagment> queuemgtList=new ArrayList<QueueManagment>();
	
	int departmentId = box.getInt("departmentId");
	int employeeId = box.getInt("userId");
	
	if(box.getString("patientCount")!=null){
		patientCount=Integer.parseInt(box.getString("patientCount"));
	}
	int hospitalId=box.getInt("hospitalId");
	boolean success=false;
	
	try{
		for(int i=1;i<=patientCount;i++){
			int visitId=0;
			int docId=0;
			if(box.getInt("visitId"+i)!=0){
				visitId=box.getInt("visitId"+i);
				visitIds.add(visitId);
				
				if(box.getInt("doctors"+i)!=0){
					docId=box.getInt("doctors"+i);
					docotrList.add(docId);
				}
			}
		}
		
		if(visitIds.size()>0 && docotrList.size()>0){
			
			for(int i=0;i<visitIds.size();i++){
				if(docotrList.get(i)!=null && !docotrList.get(i).equals(0)){
					
					transferToOtherDoctorCount = 0;
					Visit visit=(Visit)session.load(Visit.class, visitIds.get(i));
					MasEmployee doctor=(MasEmployee)session.load(MasEmployee.class, docotrList.get(i));
					
					visit.setDoctor(doctor);
					visit.setDoctorName(doctor.getEmployeeName());
					visit.setOpenat("");
					queuemgtList=session.createCriteria(QueueManagment.class)
							.add(Restrictions.eq("Visit.Id", visitIds.get(i))).list();
					
					if(queuemgtList.size()>0){
						QueueManagment que=queuemgtList.get(0);
					
						if(que.getTransferToOtherDoctorCount()!=null)
							transferToOtherDoctorCount = que.getTransferToOtherDoctorCount();
						
						if(que.getAssignedDoctorId()!=docotrList.get(i))
							transferToOtherDoctorCount = transferToOtherDoctorCount+1;
							
						que.setTransferToOtherDoctorCount(transferToOtherDoctorCount);
						que.setAssignedDoctorId(docotrList.get(i));
						que.setInitialDr(doctor);
						session.update(que);
					}
					
					session.update(visit);
					session.flush();
					success=true;
				}
				
	}
			
		}
	}catch(Exception e){
		success=false;
	}
	
	map.put("success", success);
	return map;
}

	/* 
	 * Method releasedPatientDetails() provides the details of 
	 * released patients.
	 */
	@Override
	public Map<String, Object> releasedPatientDetails(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		List<Object[]> deptList = new ArrayList<Object[]>();
		Map<Integer, String> deptMap = new HashMap<Integer, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<>();
		int hospitalId = 0;
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt(String.valueOf(dataMap
					.get("hospitalId")));
		}
		int tokenNumber = 0;
		if (dataMap.get("tokenNumber") != null
				&& Integer.parseInt(String.valueOf(dataMap.get("tokenNumber"))) != 0) {
			tokenNumber = Integer.parseInt(String.valueOf(dataMap
					.get("tokenNumber")));
		}

		departmentList = session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "DepartmentType")
				.add(Restrictions.eq("DepartmentType.Id", 1))
				.add(Restrictions.eq("dep.VisitApplicable", "y").ignoreCase())
				.addOrder(Order.asc("dep.DepartmentName")).list();
		if (departmentList.size() > 0) {

			for (MasDepartment dept : departmentList) {
				deptMap.put(dept.getId(), dept.getDepartmentName());
			}

		}
		map.put("departmentList", deptMap);
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt(String.valueOf(dataMap.get("deptId")));
		}
		int docId = 0;
		if (dataMap.get("docId") != null) {
			docId = Integer.parseInt(String.valueOf(dataMap.get("docId")));
		}
		List<QueueManagment> patients = new ArrayList<QueueManagment>();
		Criteria criteria2 = session
				.createCriteria(QueueManagment.class)
				.createAlias("Visit", "visit")
				.createAlias("Department", "dept")
				.add(Restrictions.eq("LsCngDate", new Date()))
				.add(Restrictions.eq("visit.VisitStatus", "a").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("dept.Id", deptId))
				.addOrder(Order.asc("visit.TokenNo"));
		if (tokenNumber > 0) {
			criteria2.add(Restrictions.eq("TokenNo", tokenNumber));
		}
		patients = criteria2.list();

		map.put("patients2", patients);
		map.put("hospitalId", hospitalId);
		map.put("depatmentId", deptId);
		map.put("doctorId", docId);

		return map;
	}

	@Override
	public Map<String, Object> getMinMaxDaysForAppointment(int deptId,
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			Session session = (Session) getSession();	
			List<Object[]> appSetupList = session.createCriteria(AppSetup.class)
					.createAlias("Hospital", "hosp")
					.createAlias("Dept", "dept")
					.setProjection(Projections.projectionList().add(Projections.property("MinNoOfDays"))
						.add(Projections.property("MaxNoOfDays")))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.isNotNull("TotalInterval"))
					.add(Restrictions.isNotNull("StartToken"))
					.add(Restrictions.isNotNull("TotalToken")).list();

			if(appSetupList.size()>0){
				int minday = (Integer)appSetupList.get(0)[0];
				int maxday = (Integer)appSetupList.get(0)[1];
				map.put("minday", minday);
				map.put("maxday", maxday);
			}
		}catch(Exception e){
			logger.error(e);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> getAssignedPatientForDoctorSpecific(int docId) {
		logger.debug("Inside Method: getAssignedPatientForDoctorSpecific");
		Map<String, Object> map = new HashMap<>();
		Session session = (Session) getSession();
		Date currentDate = new Date();
		if (map.get("docId") != null) {
			docId = Integer.parseInt(String.valueOf(map.get("docId")));
		} 
		int patientsCountForDr = (int) session
				.createCriteria(QueueManagment.class)
				.createAlias("Docotor", "dr")
				.add(Restrictions.eq("dr.Id",docId))
        	    .add(Restrictions.eq("LastChgDate",currentDate))
        	    .setProjection(Projections.rowCount()).uniqueResult();
		map.put("patientsCountForDr", new Integer(patientsCountForDr));
		return map;
	}
}

		
