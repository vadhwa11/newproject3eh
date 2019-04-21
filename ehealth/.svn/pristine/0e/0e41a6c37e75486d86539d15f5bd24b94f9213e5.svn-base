package jkt.hms.ot.dataservice;

import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.GENDER;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VISIT_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Connection;
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
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.AacAcceptance;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.ExternalLabReportCommon;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientPrescriptionDetails;
import jkt.hms.masters.business.InpatientPrescriptionHeader;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAllergyProduct;
import jkt.hms.masters.business.MasAnesthesia;
import jkt.hms.masters.business.MasBed;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasChargeCodeRates;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasInstructionMaster;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasOt;
import jkt.hms.masters.business.MasOtDistribution;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.OpdInstructionTreatment;
import jkt.hms.masters.business.OpdPatientAllergyM;
import jkt.hms.masters.business.OpdPatientAllergyT;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OtBookSurgeon;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtConsent;
import jkt.hms.masters.business.OtHumanBodyDisposal;
import jkt.hms.masters.business.OtIntraOperativeTimeOut;
import jkt.hms.masters.business.OtMasChargeDetails;
import jkt.hms.masters.business.OtMasUnitDay;
import jkt.hms.masters.business.OtPostAnaesthesiaProcedure;
import jkt.hms.masters.business.OtPostAnaesthisiaPainManagement;
import jkt.hms.masters.business.OtPreAnaesthesiaProNotesSub;
import jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain;
import jkt.hms.masters.business.OtPreAnesthesiaDetails;
import jkt.hms.masters.business.OtPreOperativeCheckList;
import jkt.hms.masters.business.OtProcedureNotesEntryDetail;
import jkt.hms.masters.business.OtProcedureNotesEntryHeader;
import jkt.hms.masters.business.OtSignOut;
import jkt.hms.masters.business.OtSignOutItemConsume;
import jkt.hms.masters.business.OtSpecimenDispatchEntry;
import jkt.hms.masters.business.OtSurgeyPaAnesthesiologistDetail;
import jkt.hms.masters.business.OtSurgeyPaEmployeeDetail;
import jkt.hms.masters.business.OtSurgeyPaIvFluidsDetail;
import jkt.hms.masters.business.OtSurgeyPaPremedicationDetail;
import jkt.hms.masters.business.OtSurgeyPaProcedureDetail;
import jkt.hms.masters.business.OtSurgeyPaSurgeyDetail;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientInvestigationDetails;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PharmacyLabQueue;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.RouteOfAdministration;
import jkt.hms.masters.business.TaperedMedicineOp;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.business.WardRemarks;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.TaperedMedicineUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public class OTDataServiceImpl extends HibernateDaoSupport implements
		OTDataService {
	@Autowired
	RegistrationDataService registrationDataService;
	// -----------------------methods changed by vikas----------------------

	public Map<String, Object> getPacClearanceList(Map mapForDS) {

		Session session = (Session) getSession();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<Object[]> objList = new ArrayList<Object[]>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		Map<String, Object> map = new HashMap<String, Object>();
		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String patientStatus = "Pending";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		try {
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			/*
			 * Criteria criteria= session.createCriteria(OpdSurgeryHeader.class)
			 * .createAlias("Hin", "h") .createAlias("OpdSurgeryDetails",
			 * "details") .createAlias("details.ChargeCode", "charge")
			 * .add(Restrictions.ne("charge.ChargeType.Id", typeId))//Added by
			 * Arbind on 15-07-2017 // .createAlias("Inpatient", "ip") //
			 * .add(Restrictions.in("ip.AdStatus", aList))
			 * .add(Restrictions.eq("Hospital.Id", hospitalId))
			 * .add(Restrictions.eq("PacStatus", patientStatus).ignoreCase())
			 * .add(Restrictions.eq("BookingStatus", "cleared").ignoreCase());
			 */

			if(mapForDS.get("fromScreen")!=null&&mapForDS.get("fromScreen")!=""){
String fromScreen=(String)mapForDS.get("fromScreen");
				
				/*Criteria criteria = session
						.createCriteria(OpdSurgeryHeader.class, "opd")
						.createAlias("Hospital", "h")
						.createAlias("Hin", "patient")
						.createAlias("OpdSurgeryDetails", "details")
						.createAlias("details.ChargeCode", "charge")
						.add(Restrictions.ne("charge.ChargeType.Id", typeId))
						.add(Restrictions.eq("h.Id", hospitalId))
						.add(Restrictions.eq("PacStatus", patientStatus)
								.ignoreCase())
						.add(Restrictions.eq("BookingStatus", "pending")
								.ignoreCase())
						.add(Restrictions.eq("details.PacRequest", "y"))*/	
						
						
					Criteria criteria = session
					.createCriteria(OpdSurgeryDetail.class, "details")
					.createAlias("OpdSurgery", "header")
					.createAlias("header.Hin", "patient")
					.createAlias("header.PrescribedDepartment", "dept")
					//.createAlias("header.Visit", "visit")
					.createAlias("header.Hospital", "h")
					.createAlias("ChargeCode", "charge")
					.add(Restrictions.ne("charge.ChargeType.Id", typeId))
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("header.PacStatus", patientStatus)
								.ignoreCase())
					.add(Restrictions.eq("header.BookingStatus", "pending")
								.ignoreCase())
					.add(Restrictions.eq("details.PacRequest", "y"))
					.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("OpdSurgery"))
										.add(Projections
												.groupProperty("header.Hin"))
										.add(Projections
												.groupProperty("header.PrescribedDepartment"))
										.add(Projections
												.groupProperty("header.Visit")) 
										.add(Projections
												.groupProperty("header.Inpatient"))
												);
				
								;
				if (!uhid.equals("")) {
					criteria.add(Restrictions.eq("patient.HinNo", uhid));
				}
				
				if (!pName.equals("")) {
					criteria.add(Restrictions.like("patient.PFirstName",pName.toLowerCase() + "%").ignoreCase());
				}
				
				if (!ipNo.equals("")) {
					criteria.createAlias("header.Inpatient", "ip").add(
							Restrictions.eq("ip.AdNo", ipNo.toLowerCase()).ignoreCase());

				}
				
				if (gender != 0) {
					criteria.createAlias("patient.Sex", "s");
					criteria.add(Restrictions.eq("s.Id", gender));
				}
				/*criteria.addOrder(Order.desc("header.RequisitionTime"))
				.addOrder(Order.desc("header.RequisitionDate"))*/
				
				;
				
				//pacList=criteria.list();
				map.put("fromScreen", fromScreen);
				objList = criteria.list();
				if (objList.size() > 0) {
					for (int i = 0; i < objList.size(); i++) {
						OpdSurgeryHeader header = ((OpdSurgeryHeader) objList
								.get(i)[0]);
						pacList.add(header);
					}
				}
			}else{
				
				Criteria criteria = session
						.createCriteria(OpdSurgeryDetail.class, "details")
						.createAlias("OpdSurgery", "header")
						.createAlias("header.Hin", "hin")
						.createAlias("header.PrescribedDepartment", "dept")
						.createAlias("header.Visit", "visit",CriteriaSpecification.LEFT_JOIN)
						.createAlias("header.Hospital", "h")
						.createAlias("ChargeCode", "charge")
						.add(Restrictions.ne("charge.ChargeType.Id", typeId))
						// Added by Arbind on 15-07-2017
						/*
						 * .createAlias("header.Inpatient", "ip")
						 * .add(Restrictions.in("ip.AdStatus", aList))
						 */
						.add(Restrictions.eq("h.Id", hospitalId))
						.add(Restrictions.eq("header.PacStatus", patientStatus)
								.ignoreCase())
						.add(Restrictions.eq("header.BookingStatus", "cleared")
								.ignoreCase())
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("OpdSurgery"))
										.add(Projections
												.groupProperty("header.Hin"))
										.add(Projections
												.groupProperty("header.PrescribedDepartment"))
										.add(Projections
												.groupProperty("header.Visit"))
										.add(Projections
												.groupProperty("header.Inpatient")));
				if (!uhid.equals("")) {
					criteria.add(Restrictions.eq("hin.HinNo", uhid.toLowerCase())
							.ignoreCase());
				}
				if (!pName.equals("")) {
					criteria.add(Restrictions.like("hin.PFirstName",
							pName.toLowerCase() + "%").ignoreCase());
				}

				if (!ipNo.equals("")) {
					// criteria.createAlias("Inpatient", "ip");
					criteria.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
							.ignoreCase())

					;
				}
				if (gender != 0) {
					criteria.createAlias("hin.Sex", "s");
					criteria.add(Restrictions.eq("s.Id", gender));
				}

				objList = criteria.list();
				if (objList.size() > 0) {
					for (int i = 0; i < objList.size(); i++) {
						OpdSurgeryHeader header = ((OpdSurgeryHeader) objList
								.get(i)[0]);
						pacList.add(header);
					}
				}
				
			}

			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pacList", pacList);
		map.put("sexList", sexList);
		return map;
	}

	public Map<String, Object> searchpatient(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();

		String serviceNo = "";
		String hinNo = "";
		String employeeName = "";
		String patientType = "";

		int deptId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("patientType") != null) {
			patientType = (String) mapForDS.get("patientType");
		}
		String pacStatus = "Pending";
		Criteria crit = session.createCriteria(OpdSurgeryHeader.class)
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("PacStatus", pacStatus));
		if (hinNo.equals("")) {
			if (!patientType.equals("")) {
				crit = crit.add(Restrictions.eq("PatientStatus", patientType));
			}
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		pacList = crit.list();
		map.put("pacList", pacList);

		return map;
	}

	public Map<String, Object> showPreAnesthesiaForm(Map mapForDS) {
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OpdPatientDetails> patientDetailsList = new ArrayList<OpdPatientDetails>();
		List<OtPreAnesthesiaDetails> OtPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<PatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		List<BloodMasComponent> BloodMasComponentList = new ArrayList<BloodMasComponent>();
		List<Integer> opdPatientList = new ArrayList<Integer>();
		List<Integer> maxVisitFromPatientPresList = new ArrayList<Integer>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
		List<MasInstructionMaster> masInstructionMasterList = new ArrayList<MasInstructionMaster>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		Map<String, Object> map = new HashMap<String, Object>();
		String anesthesia = "";

		int opdSurgeryId = (Integer) mapForDS.get("opdSurgeryId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int visitId = 0;
		opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", opdSurgeryId)).list();
		OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList
				.get(0);
		int hinId = opdSurgeryHeader.getHin().getId();
		String icd = "";
		icdList = session.createCriteria(DischargeIcdCode.class)
				.add(Restrictions.eq("Hin.Id", hinId)).list();
		for (DischargeIcdCode icd2 : icdList) {
			if (icd2.getIcd() != null) {
				icd = icd + "\n" + icd2.getIcd().getIcdName();
			}
		}

		List<Visit> visitList = new ArrayList<Visit>();
		visitList = session.createCriteria(Visit.class)
				.add(Restrictions.eq("Hin.Id", hinId))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
		for (Visit visit : visitList) {
			visitId = visit.getId();
		}
		patientPrescriptionDetailList = session
				.createCriteria(PatientPrescriptionDetails.class)
				.createAlias("Prescription", "Prescription")
				.createAlias("Prescription.Visit", "visit")
				.add(Restrictions.eq("visit.Id", visitId)).list();
		instituteDepartmentList = session
				.createCriteria(MasInstituteDepartment.class)
				.createAlias("Institute", "Institute")
				.createAlias("Department", "Department")
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.add(Restrictions.eq("Department.DepartmentType.Id", 10))
				.list();
		try {

			if (opdSurgeryHeader.getPatientStatus().equalsIgnoreCase(
					"OutPatient")
					|| opdSurgeryHeader.getPatientStatus().equalsIgnoreCase(
							"OP")) {
				visitId = opdSurgeryHeader.getVisit().getId();
				opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VisitInpatientId", visitId))
						.list();

				patientDetailsList = session
						.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "v").createAlias("v.Hin", "hin")
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();
			} else if (opdSurgeryHeader.getInpatient() != null) {

				int inpatientId = opdSurgeryHeader.getInpatient().getId();
				Criteria crit = session.createCriteria(OpdPatientHistory.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId));
				opdPatientHistoryList = crit.list();

				Criteria criteria = session
						.createCriteria(PatientPrescriptionHeader.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.createAlias("Visit", "visit")
						.createAlias("Inpatient", "inpatient");
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.max("visit.Id"));
				criteria.setProjection(projectionList);
				maxVisitFromPatientPresList = criteria.list();
				if (maxVisitFromPatientPresList.get(0) != null
						&& maxVisitFromPatientPresList.size() > 0) {
					visitId = (Integer) maxVisitFromPatientPresList.get(0);
					patientPrescriptionHeaderList = session
							.createCriteria(PatientPrescriptionHeader.class)
							.createAlias("Visit", "visit")
							.add(Restrictions.eq("visit.Id", visitId)).list();

				}

				patientDetailsList = session
						.createCriteria(OpdPatientDetails.class)
						.createAlias("Inpatient", "v")
						.createAlias("v.Hin", "hin")
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.desc("id")).setMaxResults(1).list();

			}
			anesthesiaList = session.createCriteria(MasAnesthesia.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			BloodMasComponentList = session
					.createCriteria(BloodMasComponent.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			doctorList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmpCategory.Id", 1)).list();
			if (patientPrescriptionHeaderList != null
					&& patientPrescriptionHeaderList.size() > 0) {
				PatientPrescriptionHeader patientPrescriptionHeader = (PatientPrescriptionHeader) patientPrescriptionHeaderList
						.get(0);
				int prescriptionId = patientPrescriptionHeader.getId();
				patientPrescriptionDetailList = session
						.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "prescriptionId")
						.add(Restrictions.eq("prescriptionId.Id",
								prescriptionId)).list();
			}
			OtPreAnesthesiaDetailsList = session
					.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("Hin.Id", opdSurgeryHeader.getHin()
							.getId())).list();
			for (OtPreAnesthesiaDetails OtPreAnesthesiaDetails : OtPreAnesthesiaDetailsList) {
				anesthesia = anesthesia + ","
						+ OtPreAnesthesiaDetails.getAnashteicDetails();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		routeOfAdministrationList = session
				.createCriteria(RouteOfAdministration.class)
				.add(Restrictions.eq("Status", "y".toLowerCase())
						.ignoreCase()).addOrder(Order.asc("OrderNo")).list();
		masInstructionMasterList = session
				.createCriteria(OpdInstructionTreatment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("frequencyList", frequencyList);
		map.put("routeOfAdministrationList", routeOfAdministrationList);
		map.put("masInstructionMasterList", masInstructionMasterList);
		map.put("anesthesiaList", anesthesiaList);
		map.put("opdSurgeryList", opdSurgeryList);
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("patientPrescriptionDetailList", patientPrescriptionDetailList);
		map.put("BloodMasComponentList", BloodMasComponentList);
		map.put("doctorList", doctorList);
		map.put("patientDetailsList", patientDetailsList);
		map.put("anesthesia", anesthesia);
		map.put("instituteDepartmentList", instituteDepartmentList);
		map.put("icd", icd);
		return map;
	}

	public Map<String, Object> getInvestigationDetails(Map mapForDS) {
		Session session = (Session) getSession();
		List<DgOrderhd> dgOrderHList = new ArrayList<DgOrderhd>();
		List<DgSampleCollectionHeader> dgSampleCollectionList = new ArrayList<DgSampleCollectionHeader>();
		List<DgResultEntryHeader> dgResultEntryList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
		String patientStatus = (String) mapForDS.get("patientStatus");
		int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

		List resultEntryDetailList = new ArrayList();
		try {
			if (patientStatus.equals("OutPatient")) {
				int visitId = (Integer) mapForDS.get("visitId");
				dgResultEntryDetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "resultEntry")
						.createAlias("resultEntry.SampleCollectionHeader",
								"sampleCollectionHeader")
						.createAlias("sampleCollectionHeader.Order", "order")
						.createAlias("order.Hin", "hin")
						.createAlias("order.Visit", "visit")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("order.Hospital.Id", hospitalId))
						.add(Restrictions.eq("visit.Id", visitId)).list();
				resultEntryDetailList.addAll(dgResultEntryDetailList);
				dgOrderHList = session.createCriteria(DgOrderhd.class)
						.createAlias("Hin", "hin")
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("visit.Id", visitId)).list();
			} else {
				int inpatientId = (Integer) mapForDS.get("inpatientId");

				dgResultEntryDetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "resultEntry")
						.createAlias("resultEntry.SampleCollectionHeader",
								"sampleCollectionHeader")
						.createAlias("sampleCollectionHeader.Order", "order")
						.createAlias("order.Hin", "hin")
						.createAlias("order.Inpatient", "inpatient")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("order.Hospital.Id", hospitalId))
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.list();
				resultEntryDetailList.addAll(dgResultEntryDetailList);

				dgOrderHList = session.createCriteria(DgOrderhd.class)
						.createAlias("Hin", "hin")
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.list();
			}
			// if (dgOrderHList != null && dgOrderHList.size() > 0) {
			// for (DgOrderhd dgOrderhd : dgOrderHList) {
			// // DgOrderhd dgOrderhd = (DgOrderhd) dgOrderHList.get(0);
			// int dgOrderhdId = dgOrderhd.getId();
			// dgSampleCollectionList = session
			// .createCriteria(DgSampleCollectionHeader.class)
			// .createAlias("Order", "order")
			// .add(Restrictions.eq("Hospital.Id", hospitalId))
			// .add(Restrictions.eq("order.Id", dgOrderhdId))
			// .list();
			// if (dgSampleCollectionList != null
			// && dgSampleCollectionList.size() > 0) {
			// for (DgSampleCollectionHeader dgSampleCollectionHeader :
			// dgSampleCollectionList) {
			// // DgSampleCollectionHeader dgSampleCollectionHeader =
			// (DgSampleCollectionHeader) dgSampleCollectionList
			// // .get(0);
			// int dgSampleColectionHeaderId = dgSampleCollectionHeader
			// .getId();
			//
			// dgResultEntryList = session
			// .createCriteria(DgResultEntryHeader.class)
			// .createAlias("SampleCollectionHeader",
			// "sampleCollectionHeader")
			// .add(Restrictions.eq(
			// "sampleCollectionHeader.Id",
			// dgSampleColectionHeaderId)).list();
			// Iterator itr = dgResultEntryList.iterator();
			// while (itr.hasNext()) {
			// DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader)
			// itr
			// .next();
			// int dgResultEntryHeaderId = dgResultEntryHeader
			// .getId();
			//
			// dgResultEntryDetailList = session
			// .createCriteria(DgResultEntryDetail.class)
			// .createAlias("ResultEntry", "resultEntry")
			// .add(Restrictions.eq("resultEntry.Id",
			// dgResultEntryHeaderId)).list();
			// resultEntryDetailList.add(dgResultEntryDetailList);
			// }
			// }
			// }
			// }
			// }
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("resultEntryDetailList", resultEntryDetailList);
		map.put("dgOrderHList", dgOrderHList);
		map.put("patientStatus", patientStatus);

		return map;
	}

	@SuppressWarnings("unused")
	public boolean submitPreAnesthesiaDetails(Map mapForDS) {

		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OpdSurgeryHeader> opdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int deptId = box.getInt("deptId");
			int hinId = box.getInt("hinId");
			int hospitalId = (Integer) mapForDS.get("hospitalId");
			int visitId = box.getInt("visitId");
			int inpatientId = box.getInt("inPatientId");
			int userId = (Integer) mapForDS.get(USER_ID);
			String patientStatus = box.getString("patientStatus");
			String summary = "";
			int pendingDocId = 0;
			String Remarks = "";
			String arrangeBed1 = "";
			int wardName = 0;
			String vent = "";
			String remarksForBedArrangement = "";
			String patientPosition = "";
			String[] CareOf = null;
			if (mapForDS.get("careOf") != null) {
				CareOf = (String[]) mapForDS.get("careOf");
			}
			String careOf = "";
			if (CareOf != null && CareOf.length > 0) {
				for (String str : CareOf) {
					if (str != null && !str.equals("")) {
						careOf += "" + str;
					}
				}
			}
			int unitForBloodComponent = 0;
			if (box.getInt("unitForBloodComponent") != 0) {
				unitForBloodComponent = box.getInt("unitForBloodComponent");
			}
			if (box.get("patientPosition") != null) {
				patientPosition = box.get("patientPosition");
			}

			if (box.get("arrangeBed1") != null) {
				arrangeBed1 = box.get("arrangeBed1");
			}
			if (box.get("vent") != null) {
				vent = box.get("vent");
			}
			if (box.get("remarksForBedArrangement") != null) {
				remarksForBedArrangement = box.get("remarksForBedArrangement");
			}
			if (box.get("wardName") != null && !box.get("wardName").equals("0")) {
				wardName = box.getInt("wardName");
			}
			summary = box.getString("summary");
			if (box.getInt("doctorName") != 0) {
				pendingDocId = box.getInt("doctorName");
			}
			if (box.getString("remarks") != null) {
				Remarks = box.getString("remarks");
			}

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			OtPreAnesthesiaDetails otPreAnesthesiaDetails = new OtPreAnesthesiaDetails();
			otPreAnesthesiaDetails.setBedArrangement(arrangeBed1);
			otPreAnesthesiaDetails.setBedFlag(vent);
			otPreAnesthesiaDetails
					.setRemarksBedArrangement(remarksForBedArrangement);
			otPreAnesthesiaDetails.setCareOf(careOf);
			otPreAnesthesiaDetails.setPatientPosition(patientPosition);
			if (wardName != 0) {
				MasDepartment dept = new MasDepartment();
				dept.setId(wardName);

				otPreAnesthesiaDetails.setWard(dept);
			}
			otPreAnesthesiaDetails.setSummary(summary);
			otPreAnesthesiaDetails.setRemarks(Remarks);
			if (pendingDocId != 0) {
				MasEmployee me1 = new MasEmployee();
				me1.setId(pendingDocId);

				otPreAnesthesiaDetails.setPendingDoc(me1);
			}
			OpdSurgeryHeader opdSurgeryHeaderObj = new OpdSurgeryHeader();
			if (patientStatus.equalsIgnoreCase("OutPatient")
					|| patientStatus.equalsIgnoreCase("OP")) {
				/* opdPatientHistory.setVisitInpatientId(box.getInt("visitId")); */
				Visit visit = new Visit();
				visit.setId(visitId);
				otPreAnesthesiaDetails.setVisit(visit);
				// opdSurgeryList =
				// session.createCriteria(OpdSurgeryHeader.class)
				// .createAlias("Visit", "visit")
				// .add(Restrictions.eq("visit.Id", visitId))
				// .add(Restrictions.eq("Hospital.Id", hospitalId))
				// .add(Restrictions.eq("PacStatus", "pending")).list();

				// changed for order id
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
						.add(Restrictions.eq("PacStatus", "pending")
								.ignoreCase()).list();
				OpdSurgeryHeader opdSurgeryHeader = opdSurgeryList.get(0);
				int id = opdSurgeryHeader.getId();
				opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, id);
				opdSurgeryHeaderObj.setPacStatus("Cleared");
				hbt.update(opdSurgeryHeaderObj);
			} else {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				otPreAnesthesiaDetails.setInpatient(inpatient);
				;
				opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId))
						.list();
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", box.getInt("orderNo")))
						.add(Restrictions.eq("PacStatus", "pending")
								.ignoreCase()).list();

				OpdSurgeryHeader opdObj = (OpdSurgeryHeader) opdSurgeryList
						.get(0);
				int opdId = opdObj.getId();

				opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, opdId);
				opdSurgeryHeaderObj.setPacStatus("Cleared");
				hbt.update(opdSurgeryHeaderObj);
			}

			if (opdPatientHistoryList != null
					&& opdPatientHistoryList.size() > 0) {

				OpdPatientHistory opdPatientHistoryObj = opdPatientHistoryList
						.get(0);
				int opdPatientHistoryId = opdPatientHistoryObj.getId();
				OpdPatientHistory opdPatientHistory2 = (OpdPatientHistory) hbt
						.load(OpdPatientHistory.class, opdPatientHistoryId);
				opdPatientHistory2.setPersonalPresentHistory(box
						.getString("presentHistory"));
				opdPatientHistory2.setPersonalPastHistory(box
						.getString("pastHistory"));
				hbt.update(opdPatientHistory2);

			} else {

				if (patientStatus.equalsIgnoreCase("OutPatient")
						|| patientStatus.equalsIgnoreCase("OP")) {
					opdPatientHistory
							.setVisitInpatientId(box.getInt("visitId"));
				} else {
					opdPatientHistory.setVisitInpatientId(box
							.getInt("inPatientId"));
				}
				Patient patient = new Patient();
				patient.setId(hinId);
				opdPatientHistory.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				opdPatientHistory.setDepartment(masDepartment);
				opdPatientHistory.setPersonalPresentHistory(box
						.getString("pastHistory"));
				opdPatientHistory.setPersonalPastHistory(box
						.getString("presentHistory"));
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				opdPatientHistory.setHospital(masHospital);
				Users users = new Users();
				users.setId(userId);
				opdPatientHistory.setLastChgBy(users);
				opdPatientHistory.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changedDate")));
				opdPatientHistory.setLastChgTime(box.getString("changedTime"));
				opdPatientHistory.setStatus("y");
				opdPatientHistory.setIpOpPacStatus("PAC");
				hbt.save(opdPatientHistory);
			}

			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			MasDepartment masDepartmentObj = new MasDepartment();
			masDepartmentObj.setId(deptId);
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			int anesId = box.getInt("anaestheticName");
			if (anesId != 0) {
				MasEmployee me = new MasEmployee();
				me.setId(anesId);
				otPreAnesthesiaDetails.setAnesthetic(me);
			}
			otPreAnesthesiaDetails.setSmokingAlcohol(box.getString("smoking"));
			otPreAnesthesiaDetails.setPulse(box.getString("pulse"));
			otPreAnesthesiaDetails.setPallor(box.getString("pallor"));
			otPreAnesthesiaDetails.setCyanosis(box.getString("cyanosis"));
			otPreAnesthesiaDetails.setClubbing(box.getString("clubbing"));
			otPreAnesthesiaDetails.setIcetrus(box.getString("icetrus"));
			otPreAnesthesiaDetails.setOedema(box.getString("oedema"));
			otPreAnesthesiaDetails.setSpine(box.getString("spine"));
			otPreAnesthesiaDetails.setThyroid(box.getString("thyroid"));
			otPreAnesthesiaDetails.setNourishment(box.getString("nourishment"));
			otPreAnesthesiaDetails.setBp(box.getString("bp"));
			otPreAnesthesiaDetails.setAirway(box.getString("airway"));
			otPreAnesthesiaDetails.setVenousAccess(box.getString("venous"));
			otPreAnesthesiaDetails.setBreathSound(box.getString("breath"));
			otPreAnesthesiaDetails.setAdvSound(box.getString("advance"));
			otPreAnesthesiaDetails.setAbdomen(box.getString("abdomen"));
			otPreAnesthesiaDetails.setLiver(box.getString("liver"));
			otPreAnesthesiaDetails.setSpleen(box.getString("spleen"));
			otPreAnesthesiaDetails.setAsaGrade(box.getString("asa"));
			otPreAnesthesiaDetails.setBlood(box.getString("blood"));
			otPreAnesthesiaDetails.setUnit(unitForBloodComponent);
			/*
			 * otPreAnesthesiaDetails.setHairPin(box.getString("hairPin"));
			 * otPreAnesthesiaDetails
			 * .setJewelStatus(box.getString("jewelName"));
			 */
			otPreAnesthesiaDetails.setInstructions(box
					.getString("instructions"));

			otPreAnesthesiaDetails.setS1(box.getString("s1"));
			otPreAnesthesiaDetails.setS2(box.getString("s2"));
			otPreAnesthesiaDetails.setS3(box.getString("s3"));
			otPreAnesthesiaDetails.setS4(box.getString("s4"));
			otPreAnesthesiaDetails.setCardioVascularSystem(box.getString("cardioVascularRemark"));
			otPreAnesthesiaDetails.setOrderNo(box.getInt("orderNo"));
			otPreAnesthesiaDetails.setHin(patientObj);

			otPreAnesthesiaDetails.setDepartment(masDepartmentObj);
			otPreAnesthesiaDetails.setHospital(masHospitalObj);
			otPreAnesthesiaDetails.setPacDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			Users users = new Users();
			users.setId(userId);
			otPreAnesthesiaDetails.setChangedBy(users);
			otPreAnesthesiaDetails.setChangedDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			otPreAnesthesiaDetails.setChangedTime(box.getString("changedTime"));
			otPreAnesthesiaDetails.setPatientType(box.get("patientType"));
			/*
			 * MasAnesthesia masAnesthesia=new MasAnesthesia();
			 * masAnesthesia.setId(box.getInt("grade"));
			 * otPreAnesthesiaDetails.setAnesthticTechnique(masAnesthesia);
			 */
			String anaestheticPlanned = box.getString("anaesthicPlanned");
			String anaestheticPlannedTemp = "";
			otPreAnesthesiaDetails.setConsentStatus("n");
			anaestheticPlannedTemp = anaestheticPlanned.substring(
					anaestheticPlanned.length() - 1,
					anaestheticPlanned.length());
			if (anaestheticPlannedTemp.equals(",")) {
				anaestheticPlanned = anaestheticPlanned.substring(0,
						anaestheticPlanned.length() - 1);
			}

			otPreAnesthesiaDetails.setAnashteicDetails(anaestheticPlanned);
			otPreAnesthesiaDetails.setFitForSurgery(box
					.getString("fitForSurgery"));
			otPreAnesthesiaDetails.setDrugTreatment(box
					.getString("drugTherapy"));
			hbt.save(otPreAnesthesiaDetails);

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}
		return succesfullyAdded;
	}

	public Map<String, Object> showPACClearedListForOTBooking(Map mapForDS) {
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		String patientStatus = "Cleared";
		String otBookingStatus = "Pending";
		try {
			pacList = session
					.createCriteria(OpdSurgeryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.or(
							Restrictions.isNull("BookingStatus"),
							Restrictions.eq("BookingStatus",
									otBookingStatus.toLowerCase()).ignoreCase()))
					.list();
			otList = session
					.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions
							.eq("OtBookingStatus",
									otBookingStatus.toLowerCase()).ignoreCase()
							.ignoreCase()).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("pacList", pacList);
		map.put("otList", otList);
		return map;
	}

	public Map<String, Object> showOTBookingJsp(Map mapForDS) {
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		List<OpdSurgeryDetail> opdSurgeryDetailList = new ArrayList<OpdSurgeryDetail>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtMasChargeDetails> otList = new ArrayList<OtMasChargeDetails>();
		List<MasOt> otl = new ArrayList<MasOt>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList1 = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<OtPreAnesthesiaDetails> preAnesthesiaList = new ArrayList<OtPreAnesthesiaDetails>();
		List<HospitalDoctorUnitM> doctorUnit = new ArrayList<HospitalDoctorUnitM>();
		List<OpdPatientDetails> opRefferedDoc = new ArrayList<OpdPatientDetails>();

		List<OtMasUnitDay> otMasUnitDays = new ArrayList<OtMasUnitDay>();
		int id = (Integer) mapForDS.get("surgeryHdId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int deptId = (Integer) mapForDS.get(DEPT_ID);
		int empId = (Integer) mapForDS.get("empId");
		int bookingId = 0;
		int unitId = 0;
		int chargeCodeId = 0;
		String empCategory = "Doctor";
		try {
			// SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			// DateFormat f = new SimpleDateFormat("EEEE");
			// Date bookingDate=dateFormat.parse("22/09/2015");
			Calendar now = Calendar.getInstance();
			String[] strDays = new String[] { "Sunday", "Monday", "Tuesday",
					"Wednesday", "Thursday", "Friday", "Saturday" };
			String dayName = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];

			System.out.println("empId is : " + empId);

			doctorUnit = session
					.createCriteria(HospitalDoctorUnitM.class, "um")
					// .createAlias("UnitM", "um")
					.add(Restrictions.eq("um.Hospital.Id", hospitalId))
					// .add(Restrictions.eq("Employee.Id", empId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			// .setFirstResult(0)
			// .setMaxResults(1).uniqueResult();

			otMasUnitDays = session.createCriteria(OtMasUnitDay.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId))
					// .add(Restrictions.eq("UnitM.Id",
					// doctorUnit!=null?doctorUnit.getUnitM().getId():0))
					.add(Restrictions.eq("DayName", dayName)).list();

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", bookingId)).list();

			otBookingList1 = session
					.createCriteria(OtBooking.class)
					.createAlias("Ot", "ot")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("OtPostAnethesiaStatus", "n")
							.ignoreCase()).list();
			/*
			 * .setProjection( Projections.property("ot.Id")).addOrder(
			 * Order.asc(("ot.Id"))).list();
			 */

			opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", id)).list();

			opdSurgeryDetailList = session
					.createCriteria(OpdSurgeryDetail.class)
					.createAlias("OpdSurgery", "opdSurgery")
					.add(Restrictions.eq("opdSurgery.Hospital.Id", hospitalId))
					.add(Restrictions.eq("opdSurgery.Id", id)).list();
			if (opdSurgeryDetailList.size() > 0) {
				chargeCodeId = opdSurgeryDetailList.get(0).getChargeCode()
						.getId();
			}
			otList = session.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("chargeCode.Id", chargeCodeId)).list();

			otl = session.createCriteria(MasOt.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			empList = session
					.createCriteria(MasEmployee.class)
					// .createAlias("Department", "dept")
					// .createAlias("EmpCategory", "empCategory")
					// .add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("EmpCategory.Id", 1))
					.addOrder(Order.asc("FirstName")).list();
			OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList
					.get(0);
			if (opdSurgeryHeader.getPatientStatus().equals("InPatient")) {
				int inpatientId = opdSurgeryHeader.getInpatient().getId();
				// preAnesthesiaList = session
				// .createQuery(
				// "select ot from OtPreAnesthesiaDetails as ot  where ot.Inpatient.Id='"
				// + inpatientId
				// +
				// "' and ot.ChangedDate=(select max(ot.ChangedDate) from OtPreAnesthesiaDetails as ot where ot.Inpatient.Id='"
				// + inpatientId + "')").list();
				//
				preAnesthesiaList = session
						.createCriteria(OtPreAnesthesiaDetails.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", id))
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.list();

				// preAnesthesiaList=session.createCriteria(OtPreAnesthesiaDetails.class).createAlias("Inpatient","inpatient").add(Restrictions.eq("Inpatient.Id",
				// inpatientId)).list();
			} else {
				int visitId = opdSurgeryHeader.getVisit().getId();

				// preAnesthesiaList = session
				// .createCriteria(OtPreAnesthesiaDetails.class)
				// .add(Restrictions.eq("Hospital.Id", hospitalId))
				// .createAlias("Visit", "visit")
				// .add(Restrictions.eq("visit.Id", visitId)).list();

				preAnesthesiaList = session
						.createCriteria(OtPreAnesthesiaDetails.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", id))
						.add(Restrictions.eq("visit.Id", visitId)).list();

				opRefferedDoc = session.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId)).list();
				if (opRefferedDoc != null && opRefferedDoc.size() > 0) {
					map.put("opRefferedDoc", opRefferedDoc.get(0));
				}
			}

			map.put("doctorUnit", doctorUnit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("opdSurgeryDetailList", opdSurgeryDetailList);
		map.put("opdSurgeryList", opdSurgeryList);
		map.put("otList", otList);
		map.put("empList", empList);
		map.put("preAnesthesiaList", preAnesthesiaList);
		map.put("otBookingList", otBookingList);
		map.put("otBookingList1", otBookingList1);
		map.put("otl", otl);
		map.put("surgeryId", chargeCodeId);

		map.put("otMasUnitDays", otMasUnitDays);

		return map;
	}

	public Map<String, Object> getSurgeonListForAutoComplete(Map mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";
			int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

			String empCategoryName = "Doctor";
			Criteria crit = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("empCategory.EmpCategoryName",
							empCategoryName).ignoreCase())
					.add(Restrictions.like("FirstName", str).ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> submitOTBookingDetails(Map mapForDS) {
		Session session = (Session) getSession();
		String succesfullyAdded = "";
		String value = "";
		String patientStatus = "";
		String chargeName = "";
		String startTime = "";
		String endTime = "";
		String surgeryDate = "";
		String toTimeStr = "0";
		int loopCount = 1;
		String abscondPatient = null;
		String abscondRemark = null;
		String cancelPatient = null;
		String cancelRemark = null;

		OtMasChargeDetails otMasChargeDetails = new OtMasChargeDetails();
		int surgeryId = 0;
		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		int deptId = (Integer) mapForDS.get("deptId");
		OpdSurgeryHeader opdSurgeryHeader = null;
		int opdSurgeryHeaderId = box.getInt("opdSurgeryHeaderId");
		int Id = box.getInt("opdSurgeryHeaderId");
		int ChargeDetailSurgeryId = 0;
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtMasChargeDetails> otMasChargeDetailsList = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			startTime = box.getString("surgeryTime");
			int toTime = 0;
			String flag = "True";
			if (mapForDS.get("abscondPatient") != null
					|| mapForDS.get("abscondPatient") != "") {
				abscondPatient = (String) mapForDS.get("abscondPatient");
			}
			if (mapForDS.get("cancelPatient") != null
					|| mapForDS.get("cancelPatient") != "") {
				cancelPatient = (String) mapForDS.get("cancelPatient");
			}
			if (abscondPatient != null || cancelPatient != null) {
				
					opdSurgeryHeader = (OpdSurgeryHeader) hbt.get(
							OpdSurgeryHeader.class, opdSurgeryHeaderId);
					if(abscondPatient != null){
					if (abscondPatient.equalsIgnoreCase(flag)) {
						abscondRemark = (String) mapForDS.get("abscondRemark");
						opdSurgeryHeader.setPacStatus("abscond");
						opdSurgeryHeader.setAbscondRemark(abscondRemark);
						opdSurgeryHeader.setBookingStatus("abscond");
						opdSurgeryHeader.setStatus("a");
						succesfullyAdded = "abscond";
						value = "The Patient is absconded from the list...";
					}} else {
						cancelRemark = (String) mapForDS.get("cancelRemark");
						opdSurgeryHeader.setPacStatus("cancel");
						opdSurgeryHeader.setBookingStatus("cancel");
						opdSurgeryHeader.setCancelRemark(cancelRemark);
						opdSurgeryHeader.setStatus("c");
						succesfullyAdded = "cancel";
						value = "The Patient is Canceled From Minor OT List.";
					}
					hbt.saveOrUpdate(opdSurgeryHeader);
					map.put("value", value);
					map.put("succesfullyAdded", succesfullyAdded);
				
			} else {
				if (box.getString("endTime") != null
						&& !box.getString("endTime").equals("")) {
					endTime = box.getString("endTime");

					toTime = Integer.parseInt(endTime.substring(0, 2));
				}
				int date = 0;
				int month = 0;

				if (toTime >= 24) {
					endTime = "23:59";
					loopCount = 2;
					toTime = toTime - 24;
					if (toTime < 10) {
						toTimeStr = "0" + toTime + ":"
								+ endTime.substring(3, 5);
					} else {
						toTimeStr = ((Integer) (toTime)).toString() + ":"
								+ endTime.substring(3, 5);
					}
					surgeryDate = box.getString("tentativeDate");

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(surgeryDate));
					c.add(Calendar.DATE, 1); // number of days to add
					surgeryDate = sdf.format(c.getTime());
				}
				int hinId = box.getInt(HIN_ID);
				/*
				 * chargeName = box.getString("chargeName"); if (chargeName !=
				 * null) { int index1 = chargeName.lastIndexOf("["); int index2
				 * = chargeName.lastIndexOf("]"); index1++; surgeryId =
				 * Integer.parseInt(chargeName.substring(index1, index2));
				 * 
				 * }
				 */

				surgeryId = box.getInt("surgeryId");
				System.out.println("surgeryId==in ds===" + surgeryId);
				int orderNo = box.getInt("orderNo");
				// hinId----"+hinId+"--value ofsurgery--"+surgeryId+" value of
				// order
				// no--"+orderNo);
				otBookingList = session
						.createCriteria(OtBooking.class)
						.createAlias("Hin", "hinId")
						.createAlias("ChargeCode", "chargeCode")
						.add(Restrictions.eq("hinId.Id", hinId))
						.add(Restrictions.eq("chargeCode.Id", surgeryId))
						// .add(Restrictions.eq("OrderNo", orderNo))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OpdSurseryHeader.Id",
								opdSurgeryHeaderId)).list();

				otMasChargeDetailsList = session
						.createCriteria(OtMasChargeDetails.class)
						.createAlias("ChargeCode", "chargeCode")
						.add(Restrictions.eq("chargeCode.Id", surgeryId))
						// .add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();

				if (otMasChargeDetailsList.size() > 0) {
					ChargeDetailSurgeryId = otMasChargeDetailsList.get(0)
							.getId();
				}
				System.out.println("ChargeDetailSurgeryId===44=="
						+ ChargeDetailSurgeryId);
				/* for (int i = 1; i <= loopCount; i++) { */

				/*
				 * private jkt.hms.masters.business.Inpatient inpatient; private
				 * jkt.hms.masters.business.OtMasChargeDetails surgery; private
				 * jkt.hms.masters.business.MasDepartment department; private
				 * jkt.hms.masters.business.Patient hin; private
				 * jkt.hms.masters.business.HospitalDoctorUnitM unit; private
				 * jkt.hms.masters.business.MasOt ot; private
				 * jkt.hms.masters.business.MasChargeCode chargeCode; private
				 * jkt.hms.masters.business.OpdSurgeryHeader opdSurseryHeader;
				 * private jkt.hms.masters.business.MasBed bed; private
				 * jkt.hms.masters.business.MasHospital hospital; private
				 * jkt.hms.masters.business.Visit visit; private
				 * jkt.hms.masters.business.MasEmployee unitHead; private
				 * jkt.hms.masters.business.Users lastChgdBy; private
				 * jkt.hms.masters.business.MasEmployee bookedBy;
				 */
				if (otBookingList.size() == 0 || otBookingList == null) {
					OtBooking otBooking = new OtBooking();
					otBooking.setSurgeryDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("tentativeDate")));
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(surgeryId);
					otBooking.setChargeCode(masChargeCode);

					chargeName = box.getString("chargeName");
					/* if (surgeryId != 0) { */
					if (ChargeDetailSurgeryId != 0) {
						otMasChargeDetails.setId(ChargeDetailSurgeryId);
						otBooking.setSurgery(otMasChargeDetails);
					}
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("bookedById"));
					otBooking.setBookedBy(masEmployee);

					HospitalDoctorUnitM doctorUnitM = (HospitalDoctorUnitM) hbt
							.get(HospitalDoctorUnitM.class,
									box.getInt("unitId"));
					otBooking.setUnit(doctorUnitM);

					Set<HospitalDoctorUnitT> doctorUnitT = doctorUnitM
							.getHospitalDoctorUnitTs();
					if (doctorUnitT != null) {
						for (HospitalDoctorUnitT hospitalDoctorUnitT : doctorUnitT) {
							if (hospitalDoctorUnitT.getHeadFleg() != null
									&& hospitalDoctorUnitT.getHeadFleg()
											.equalsIgnoreCase("y")) {
								otBooking.setUnitHead(hospitalDoctorUnitT
										.getEmployee());
								break;
							}

						}
					}

					MasDepartment department = new MasDepartment();
					department.setId(box.getInt("ot"));
					otBooking.setDepartment(department);

					MasBed masbed = new MasBed();
					masbed.setId(box.getInt("tableId"));
					otBooking.setBed(masbed);

					/*
					 * MasOt masOt = new MasOt(); masOt.setId(box.getInt("ot"));
					 * otBooking.setOt(masOt);
					 */

					Patient patient = new Patient();
					patient.setId(box.getInt(HIN_ID));
					otBooking.setHin(patient);

					patientStatus = box.getString("patientStatus");
					if (box.getInt(VISIT_ID) != 0) {
						Visit visit = new Visit();
						visit.setId(box.getInt(VISIT_ID));
						otBooking.setVisit(visit);
					} else {
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt(INPATIENT_ID));
						otBooking.setInpatient(inpatient);
					}
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					otBooking.setHospital(masHospital);
					Users users = new Users();
					users.setId(userId);
					otBooking.setLastChgdBy(users);

					if (box.getString("changedDate") != null
							&& !box.getString("changedDate").equals("")) {
						otBooking.setLastChgdDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("changedDate")));
					}
					if (box.getString("bloodReq") != null
							&& box.getString("bloodReq").equalsIgnoreCase("on")) {
						otBooking.setBloodRequire("y");
					}

					otBooking.setLastChgdTime(box.getString("changedTime"));
					otBooking.setOrderNo(box.getInt("orderNo"));
					otBooking.setOtBookingStatus("y");
					otBooking.setOtPostAnethesiaStatus("n");
					otBooking.setSurgeryStatus("n");
					otBooking.setBookingType(box.getString("bookingType"));
					OpdSurgeryHeader opdSurgeryHeader1 = new OpdSurgeryHeader();
					System.out.println("opdSurgeryHeaderId=in ds==="
							+ opdSurgeryHeaderId);
					opdSurgeryHeader1.setId(opdSurgeryHeaderId);
					otBooking.setOpdSurseryHeader(opdSurgeryHeader1);
					otBooking.setOrderNo(orderNo);
					hbt.save(otBooking);

					// List opdSurgeryList = new ArrayList();
					// int id = 0;
					// patientStatus = box.getString("patientStatus");
					// if (patientStatus.equalsIgnoreCase("OutPatient")) {
					//
					// int visitId = box.getInt("visitId");
					// // opdSurgeryList = session
					// // .createCriteria(OpdSurgeryHeader.class)
					// // .createAlias("Visit", "visit")
					// // .add(Restrictions.eq("visit.Id", visitId))
					// // .list();
					// OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader)
					// opdSurgeryList
					// .get(0);
					// id = opdSurgeryHeader.getId();
					// } else {
					//
					// int inpatientId = box.getInt("inPatientId");
					// List opdSurgeryHList = session
					// .createQuery(
					// "select ot from OpdSurgeryHeader as ot  where ot.Inpatient.Id='"
					// + inpatientId
					// +
					// "' and ot.RequisitionDate=(select max(ot.RequisitionDate) from OpdSurgeryHeader as ot where ot.Inpatient.Id='"
					// + inpatientId + "')").list();
					// OpdSurgeryHeader opdObj = (OpdSurgeryHeader)
					// opdSurgeryHList
					// .get(0);
					// id = opdObj.getId();
					// }
					OpdSurgeryHeader opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt
							.load(OpdSurgeryHeader.class, opdSurgeryHeaderId);
					opdSurgeryHeaderObj.setBookingStatus("Cleared");
					hbt.update(opdSurgeryHeaderObj);

					if (mapForDS.get("empIdList") != null) {
						List empIdList = (List) mapForDS.get("empIdList");
						List<String> roleList = (List) mapForDS.get("roleList");
						// Iterator itr = empIdList.iterator();
						// while (itr.hasNext()) {

						for (int i = 0; i < empIdList.size(); i++) {

							int empId = Integer.parseInt(empIdList.get(i)
									.toString());
							OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
							otBookSurgeon.setBooking(otBooking);
							MasEmployee masEmployee2 = new MasEmployee();
							masEmployee2.setId(empId);
							otBookSurgeon.setEmployee(masEmployee2);
							otBookSurgeon.setOrderno(box.getInt("orderNo"));
							if (roleList.size() > 0) {
								if (!roleList.get(i).equals("")
										&& !roleList.get(i).equals("0")) {
									String role = roleList.get(i).toString();
									otBookSurgeon.setRole(role);
								}
							}
							hbt.save(otBookSurgeon);
						}
					}

					value = "OT Booked For the Patient";
					succesfullyAdded = "true";
					map.put("succesfullyAdded", succesfullyAdded);
					map.put("value", value);

				} else {

					succesfullyAdded = "false";
					value = "OT is Already Booked For this Patient.";
					map.put("value", value);
					map.put("succesfullyAdded", succesfullyAdded);

				}

			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}

		return map;
	}

	public Map<String, Object> searchPatientDetailsForDisposal(Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();

		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

		Session session = (Session) getSession();

		/*
		 * String serviceNo = ""; if (mapForDS.get("serviceNo") != null) {
		 * 
		 * serviceNo = (String) mapForDS.get("serviceNo"); }
		 */
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		String patientStatus = "A";
		// Criteria crit =
		// session.createCriteria(Patient.class).add(Restrictions.not(Expression.eq("PatientStatus",
		// patientStatus)));
		Criteria crit = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				.createAlias("Hin", "p");

		/*
		 * if (!serviceNo.equals("")) { crit =
		 * crit.add(Restrictions.eq("p.ServiceNo", serviceNo)); }
		 */

		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("p.PFirstName", patientFName
					+ "%"));
		}
		if (!patientMName.equals("")) {
			crit = crit.add(Restrictions.like("p.PMiddleName", patientMName
					+ "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions
					.like("p.PLastName", patientLName + "%"));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		}
		crit.add(Restrictions.eq("Hospital.Id", hospitalId));
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showHumanBodyPartsDisposalJsp(Map mapForDS) {
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String tableNameForTransactionSequence = "OtHumanBodyDisposal";
		int entryNo = 0;
		try {
			// String hinNo = (String) mapForDS.get("hinNo");
			// int hinId = (Integer) mapForDS.get("hinId");
			int bookingId = (Integer) mapForDS.get("bookingId");
			int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
			/*
			 * patientDetailList = session.createCriteria(OtBooking.class)
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.HinNo",
			 * hinNo)).list();
			 */
			patientDetailList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("Id", bookingId)).list();
			empList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			entryNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("Tablename",
							tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empList", empList);
		map.put("deptList", deptList);
		map.put("entryNo", entryNo);

		return map;
	}

	public boolean submitHumanBodyPartsDisposal(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		List<TransactionSequence> entryNoList = new ArrayList<TransactionSequence>();
		String tableNameForTransactionSequence = "OtHumanBodyDisposal";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtHumanBodyDisposal otHumanBodyDisposal = new OtHumanBodyDisposal();
			otHumanBodyDisposal.setTissueOrgan(box.get("tissueOrgan"));
			Patient patient = new Patient();
			patient.setId(box.getInt("hinId"));
			otHumanBodyDisposal.setHin(patient);
			otHumanBodyDisposal.setEntryNo(box.getInt("entryNo"));
			otHumanBodyDisposal
					.setClinicalNotes(box.getString("clinicalNotes"));
			otHumanBodyDisposal.setTimeOfDispatch(box
					.getString("timeOfDispatch"));

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			otHumanBodyDisposal.setSpecimenDispatchedBy(masDepartment);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("empId"));
			otHumanBodyDisposal.setSpecimenRecievedBy(masEmployee);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			otHumanBodyDisposal.setHospital(masHospital);
			Users users = new Users();
			users.setId(userId);
			otHumanBodyDisposal.setLasChgBy(users);
			otHumanBodyDisposal.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("changedDate")));
			otHumanBodyDisposal.setLastChgTime(box.getString("changedTime"));
			otHumanBodyDisposal.setDispatchDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString("dateOfDispatch")));

			hbt.save(otHumanBodyDisposal);
			entryNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("Tablename",
							tableNameForTransactionSequence)).list();
			TransactionSequence transactionSequence = (TransactionSequence) entryNoList
					.get(0);
			int id = transactionSequence.getId();
			int entryNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = entryNo + 1;
			TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(entryNo);
			hbt.update(transactionSequenceObj);

			succesfullyAdded = true;

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return succesfullyAdded;
	}

	public Map<String, Object> searchHumanBodyPartsDisposal(Map mapForDS) {
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<OtHumanBodyDisposal> otHumanBodyPartsList = new ArrayList<OtHumanBodyDisposal>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		try {
			String hinNo = (String) mapForDS.get("hinNo");
			int entryNo = (Integer) mapForDS.get("entryNo");
			patientDetailList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo)).list();
			empList = session.createCriteria(MasEmployee.class).list();
			deptList = session.createCriteria(MasDepartment.class).list();
			otHumanBodyPartsList = session
					.createCriteria(OtHumanBodyDisposal.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo))
					.add(Restrictions.eq("EntryNo", entryNo)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empList", empList);
		map.put("deptList", deptList);
		map.put("otHumanBodyPartsList", otHumanBodyPartsList);
		return map;
	}

	public Map<String, Object> getEntryNoListForHumanBodyPartsDisposal(
			Map mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtHumanBodyDisposal> otHumanBodyDisposalList = new ArrayList<OtHumanBodyDisposal>();
		String hinNo = (String) mapForDS.get("hinNo");
		try {
			otHumanBodyDisposalList = session
					.createCriteria(OtHumanBodyDisposal.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otHumanBodyDisposalList", otHumanBodyDisposalList);
		return map;
	}

	public Map<String, Object> searchPatientDetailsForEmergencyOTBooking(
			Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientList = new ArrayList<Inpatient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {

			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		Criteria crit = session.createCriteria(Patient.class);
		// Criteria crit =
		// session.createCriteria(Inpatient.class).add(Restrictions.eq("AdStatus",
		// patientStatus))
		// .createAlias("Hin", "p");
		if (hinNo != null && !hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		} else {
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLName
						+ "%"));
			}
		}
		patientList = crit.list();
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> showEmergencyOTBookingJsp(Map mapForDS) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasOt> otList = new ArrayList<MasOt>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		List<TransactionSequence> tranList = new ArrayList<TransactionSequence>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		int hinId = (Integer) mapForDS.get("hinId");
		int deptId = (Integer) mapForDS.get("deptId");
		String empCategory = "Doctor";
		String tableNameForOrderNo = "DgOrderhd";
		int orderNo = 0;
		String deptName = null;
		try {
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			otList = session.createCriteria(MasOt.class).list();
			empList = session
					.createCriteria(MasEmployee.class)
					.createAlias("Department", "dept")
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("empCategory.EmpCategoryName",
							empCategory)).list();
			tranList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("Tablename", tableNameForOrderNo))
					.list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			TransactionSequence transactionSequence = (TransactionSequence) tranList
					.get(0);
			orderNo = transactionSequence.getTransactionSequenceNumber();
			MasDepartment masDepartment = deptList.get(0);
			deptName = masDepartment.getDepartmentName();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("orderNo", orderNo);
		map.put("patientList", patientList);
		map.put("otList", otList);
		map.put("empList", empList);
		map.put("deptName", deptName);

		return map;
	}

	public boolean submitEmergencyOTBookingDetails(Map mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		Transaction tx = null;
		Box box = (Box) mapForDS.get("box");
		int deptId = (Integer) mapForDS.get("deptId");
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			int hinId = box.getInt("hinId");
			int surgeryId = box.getInt("chargeCode");
			int orderNo = box.getInt("orderNo");
			otBookingList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("hin.Id", hinId))
					.add(Restrictions.eq("chargeCode.Id", surgeryId))
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			if (otBookingList.size() == 0 || otBookingList == null) {

				OtBooking otBooking = new OtBooking();
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(box.getInt("chargeCode"));
				otBooking.setChargeCode(masChargeCode);
				otBooking.setSurgeryDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("surgeryDate")));
				otBooking.setSurgeryTime(box.getString("surgeryTime"));
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(box.getInt("empId"));
				otBooking.setBookedBy(masEmployee);
				MasOt masOt = new MasOt();
				masOt.setId(box.getInt("otId"));
				otBooking.setOt(masOt);
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				otBooking.setHin(patient);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				otBooking.setHospital(masHospital);
				// otBooking.setLastChgdBy(box.getString("changedBy"));
				otBooking.setLastChgdDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("changedDate")));
				otBooking.setLastChgdTime(box.getString("changedTime"));
				otBooking.setOrderNo(box.getInt("orderNo"));
				otBooking.setOtBookingStatus("y");
				otBooking.setBookingType("E");
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				otBooking.setDepartment(masDepartment);
				hbt.save(otBooking);

				if (mapForDS.get("empIdList") != null) {
					List empIdList = (List) mapForDS.get("empIdList");
					Iterator itr = empIdList.iterator();
					while (itr.hasNext()) {
						int empId = (Integer) itr.next();
						OtBookSurgeon otBookSurgeon = new OtBookSurgeon();
						otBookSurgeon.setBooking(otBooking);
						MasEmployee masEmployee2 = new MasEmployee();
						masEmployee2.setId(empId);
						otBookSurgeon.setEmployee(masEmployee2);
						otBookSurgeon.setOrderno(box.getInt("orderNo"));
						hbt.save(otBookSurgeon);
					}
				}
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	// -----------------------methods changed by vikas----------------------

	/**
	 * ------------------------------ Priyanka Garg
	 * --------------------------------
	 */
	public Map<String, Object> showOTListChangeJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		String empCategory = "Doctor";
		try {
			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("OtBookingStatus", "y"))
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", deptId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otBookingList", otBookingList);
		return map;
	}

	public Map<String, Object> getOTSchedule(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> otList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		Date otBookingDate = null;

		if (mapForDS.get("bookingDate") != null) {
			otBookingDate = HMSUtil
					.convertStringTypeDateToDateType((String) mapForDS
							.get("bookingDate"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) mapForDS.get("deptId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			/*
			 * otList=session.createCriteria(OtBooking.class).createAlias("Ot",
			 * "mot")
			 * .setProjection(Projections.distinct(Projections.projectionList()
			 * .add(Projections.property("mot.Id")))).add(Restrictions.eq(
			 * "OtBookingStatus","y")).list();
			 */

			otList = session
					.createCriteria(OtBooking.class)
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", deptId))
					.createAlias("Ot", "mot")
					.setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("mot.Id"))))
					.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			/*
			 * otBookingList=session.createCriteria(OtBooking.class).add(
			 * Restrictions .eq("OtBookingStatus",
			 * "y")).add(Restrictions.eq("SurgeryDate",otBookingDate )).list();
			 * masOtList
			 * =session.createCriteria(MasOt.class).add(Restrictions.eq(
			 * "Status","y")).createAlias("Department","md")
			 * .add(Restrictions.eq("md.Id", deptId)).list();
			 */

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", deptId))
					.add(Restrictions.eq("SurgeryDate", otBookingDate))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			masOtList = session.createCriteria(MasOt.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			/**
			 * ---- Assigning SlNo to each OT ------
			 */
			Iterator iteOtList = otList.iterator();
			while (iteOtList.hasNext()) {
				int ot = (Integer) iteOtList.next();
				int srNo = getMaxSlNo(otBookingList, ot);
				Iterator iteOtBookingList = otBookingList.iterator();
				while (iteOtBookingList.hasNext()) {
					OtBooking otBookingObj2 = (OtBooking) iteOtBookingList
							.next();
					if (otBookingObj2.getOt().getId() == ot) {
						if (otBookingObj2.getSlNo() == null) {
							srNo++;
							OtBooking otBookingObj3 = (OtBooking) hbt.load(
									OtBooking.class, otBookingObj2.getId());
							otBookingObj3.setSlNo(srNo);
							hbt.saveOrUpdate(otBookingObj3);
						}
					}

				}

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otBookingList", otBookingList);
		map.put("masOtList", masOtList);
		return map;
	}

	public int getMaxSlNo(List<OtBooking> otBookingList, int ot) {
		int maxSlNo = 0;
		int temp = 0;
		Iterator iteOtBookingList = otBookingList.iterator();
		while (iteOtBookingList.hasNext()) {
			OtBooking otBookingObj = (OtBooking) iteOtBookingList.next();
			if (otBookingObj.getOt().getId() == ot
					&& otBookingObj.getSlNo() != null
					&& otBookingObj.getSlNo() != 0) {

				temp = otBookingObj.getSlNo();

			}
			if (temp > maxSlNo) {
				maxSlNo = temp;
			}
		}
		return maxSlNo;

	}

	public Map<String, Object> changeOTSchedule(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		int bookingId = (Integer) map.get("bookingId");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		Date otBookingDate = HMSUtil
				.convertStringTypeDateToDateType((String) map
						.get("bookingDate"));

		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", bookingId)).list();
			otBookingList2 = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("SurgeryDate", otBookingDate))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
					.list();
			masOtList = session.createCriteria(MasOtDistribution.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("otBookingList", otBookingList);
		map.put("otBookingList2", otBookingList2);
		map.put("masOtList", masOtList);
		return map;
	}

	public Map<String, Object> updateOTSchedule(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList3 = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		String changeCriteria = box.getString("changeCriteria");
		int bookingId = box.getInt("selectedId");
		int otId = box.getInt("selectedOtId");
		int hospitalId = box.getInt(HOSPITAL_ID);
		Date bookingDate = new Date();
		int slNo = 0;

		int swapSlno = 0;
		int currentSlno = box.getInt("selectedSlNo");
		int currentOt;
		Date currentBookingDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("SelectedBookingDate"));
		int swapBookingId = 0;

		boolean dataSaved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {

			if (changeCriteria.equals("bookingDate")) {
				bookingDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString("newBookingDate"));
				if (bookingDate != null || !bookingDate.equals("")) {
					otBookingList3 = session
							.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y")
									.ignoreCase())
							.createAlias("Ot", "masOt")
							.add(Restrictions.eq("masOt.Id", otId))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("SurgeryDate",
									currentBookingDate)).list();

					currentBookingDate = otBookingList3.get(0).getSurgeryDate();
					for (OtBooking otBooking : otBookingList3) {
						if (otBooking.getSlNo() > currentSlno) {
							OtBooking otBookingObj = (OtBooking) hbt.load(
									OtBooking.class, otBooking.getId());
							otBookingObj.setSlNo(otBooking.getSlNo() - 1);
							hbt.saveOrUpdate(otBookingObj);
						}
					}

					otBookingList2 = session
							.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y")
									.ignoreCase()).createAlias("Ot", "masOt")
							.add(Restrictions.eq("masOt.Id", otId))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("SurgeryDate", bookingDate))
							.list();
					int maxSlno = getMaxSlNo(otBookingList2, otId);
					OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
							bookingId);
					otBooking.setSlNo(maxSlno + 1);
					otBooking.setSurgeryDate(bookingDate);
					hbt.saveOrUpdate(otBooking);
				}

			} else if (changeCriteria.equals("otName")) {
				otBookingList3 = session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OtBookingStatus", "y")
								.ignoreCase())
						.createAlias("Ot", "masOt")
						.add(Restrictions.eq("masOt.Id", otId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("SurgeryDate", currentBookingDate))
						.list();
				currentBookingDate = otBookingList3.get(0).getSurgeryDate();
				for (OtBooking otBooking : otBookingList3) {
					if (otBooking.getSlNo() > currentSlno) {
						OtBooking otBookingObj = (OtBooking) hbt.load(
								OtBooking.class, otBooking.getId());
						otBookingObj.setSlNo(otBooking.getSlNo() - 1);
						hbt.saveOrUpdate(otBookingObj);
					}
				}
				otId = box.getInt("newOt");

				otBookingList2 = session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OtBookingStatus", "y")
								.ignoreCase())
						.createAlias("Ot", "masOt")
						.add(Restrictions.eq("masOt.Id", otId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("SurgeryDate", currentBookingDate))
						.list();
				int maxSlno = getMaxSlNo(otBookingList2, otId);
				OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
						bookingId);
				otBooking.setSlNo(maxSlno + 1);
				MasOt masOt = new MasOt();
				masOt.setId(otId);
				otBooking.setOt(masOt);
				hbt.saveOrUpdate(otBooking);

			} else if (changeCriteria.equals("slNo")) {
				otBookingList = session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("Id", bookingId))
						.add(Restrictions.eq("OtBookingStatus", "y")
								.ignoreCase())
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				currentSlno = otBookingList.get(0).getSlNo();
				currentOt = otBookingList.get(0).getOt().getId();
				currentBookingDate = otBookingList.get(0).getSurgeryDate();
				slNo = box.getInt("newSlNo");
				OtBooking otBooking = new OtBooking();
				if (slNo != 0) {
					otBookingList2 = session
							.createCriteria(OtBooking.class)
							.add(Restrictions.eq("OtBookingStatus", "y")
									.ignoreCase())
							.add(Restrictions.eq("SlNo", slNo))
							.createAlias("Ot", "masOt")
							.add(Restrictions.eq("masOt.Id", otId))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.list();
					swapBookingId = otBookingList2.get(0).getId();
					otBooking = (OtBooking) hbt.load(OtBooking.class,
							swapBookingId);
					otBooking.setSlNo(currentSlno);
					hbt.saveOrUpdate(otBooking);
					otBooking = (OtBooking) hbt
							.load(OtBooking.class, bookingId);
					otBooking.setSlNo(slNo);
					hbt.saveOrUpdate(otBooking);
				} else if (slNo == 0) {
					otBooking = (OtBooking) hbt
							.load(OtBooking.class, bookingId);
					otBooking.setSlNo(slNo);
					hbt.saveOrUpdate(otBooking);
				}

			}

			dataSaved = true;

		} catch (HibernateException e) {
			dataSaved = false;
			e.printStackTrace();
		}
		map.put("dataSaved", dataSaved);
		map.put("otBookingList", otBookingList);
		map.put("otBookingList2", otBookingList2);
		map.put("masOtList", masOtList);
		return map;
	}

	public Map<String, Object> cancelOTSchedule(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList2 = new ArrayList<OtBooking>();
		List<OtBooking> otBookingList3 = new ArrayList<OtBooking>();
		List<MasOt> masOtList = new ArrayList<MasOt>();
		int bookingId = box.getInt("bookingId");
		int hospitalId = box.getInt(HOSPITAL_ID);
		int slNo = 0;

		int currentSlno = 0;
		int currentOt;
		Date currentBookingDate = new Date();
		int swapBookingId = 0;

		boolean dataSaved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			// bookingDate=HMSUtil.convertStringTypeDateToDateType(box.getString("newBookingDate"));

			otBookingList3 = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Id", bookingId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("OtBookingStatus", "y")).list();
			currentSlno = otBookingList3.get(0).getSlNo();
			currentOt = otBookingList3.get(0).getOt().getId();
			currentBookingDate = otBookingList3.get(0).getSurgeryDate();
			currentBookingDate = otBookingList3.get(0).getSurgeryDate();

			OtBooking otBookingObj1 = (OtBooking) hbt.load(OtBooking.class,
					bookingId);
			otBookingObj1.setOtBookingStatus("c");
			hbt.saveOrUpdate(otBookingObj1);

			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.gt("SlNo", currentSlno))
					.createAlias("Ot", "masOt")
					.add(Restrictions.eq("masOt.Id", currentOt))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("SurgeryDate", currentBookingDate))
					.list();
			for (OtBooking otBooking : otBookingList) {
				OtBooking otBookingObj = (OtBooking) hbt.load(OtBooking.class,
						otBooking.getId());
				otBookingObj.setSlNo(otBooking.getSlNo() - 1);
				hbt.saveOrUpdate(otBookingObj);

			}
			dataSaved = true;
		} catch (HibernateException e) {
			dataSaved = false;
			e.printStackTrace();
		}

		map.put("dataSaved", dataSaved);
		return map;
	}

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */
	public Map<String, Object> searchOtPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdSurgeryHeader> patientList = new ArrayList<OpdSurgeryHeader>();
		Box box = (Box) mapForDS.get("box");
		int hospitalId = 0;

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";

		// String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		/*
		 * if (mapForDS.get("serviceNo") != null) { serviceNo = (String)
		 * mapForDS.get("serviceNo"); }
		 */
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get("otProcedure") != null) {
			otProcedure = (String) mapForDS.get("otProcedure");
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		String patientStatus = "Cleared";
		String bookingStatus = "Cleared";

		if (otProcedure != null
				&& !otProcedure.equals("")
				&& (otProcedure.equalsIgnoreCase("yes") || otProcedure
						.equalsIgnoreCase("no"))) {
			Criteria crit = null;
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			crit = session
					.createCriteria(OtBooking.class)
					.createAlias("Hospital", "h")
					.createAlias("Hin", "hin")
					.createAlias("Inpatient", "ip",
							CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.or(Restrictions.isNotNull("Visit"),
							Restrictions.in("ip.AdStatus", aList)))
					// .add(Restrictions.in("ip.AdStatus", aList))
					.createAlias("OpdSurseryHeader", "osh")
					.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
					.add(Restrictions.eq("osh.PacStatus", "cleared")
							.ignoreCase()).createAlias("ChargeCode", "charge")
					.add(Restrictions.ne("charge.ChargeType.Id", typeId));// Added
																			// by
																			// Arbind
																			// on
																			// 17-07-2017

			if (otProcedure.equalsIgnoreCase("yes")) {
				crit.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase());
				crit.add(Restrictions.eq("OtPostAnethesiaStatus", "y")
						.ignoreCase());
				crit.add(Restrictions.or(Restrictions
						.isNull("OtNoteProcedureStatus"),
						Restrictions.eq("OtNoteProcedureStatus", "n")
								.ignoreCase()));

			} else if (otProcedure.equalsIgnoreCase("no")) {
				crit.add(Restrictions.or(Restrictions.isNull("SurgeryStatus"),
						Restrictions.eq("SurgeryStatus", "n").ignoreCase()));

			}
			crit.setProjection(Projections.projectionList().add(
					Projections.property("OpdSurseryHeader")));

			if (!uhid.equals("")) {
				crit.add(Restrictions.eq("hin.HinNo", uhid.toLowerCase())
						.ignoreCase());
			}
			if (!pName.equals("")) {
				crit.add(Restrictions.like("hin.PFirstName",
						pName.toLowerCase() + "%").ignoreCase());
			}
			if (!ipNo.equals("")) {
				crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
						.ignoreCase());
			}
			if (gender != 0) {
				crit.createAlias("hin.Sex", "s");
				crit.add(Restrictions.eq("s.Id", gender));
			}

			patientList = crit.list();
		}

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);
		map.put("patientList", patientList);

		return map;
	}

	public Map<String, Object> showPreAneaesthesiaProcNotesEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> patientDetailList = new ArrayList<OpdSurgeryHeader>();
		List<OtPreAnaesthesiaProcNotesMain> patientList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> preAnesthesiaList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProcNotesMain> otList = new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProNotesSub> otDetailList = new ArrayList<OtPreAnaesthesiaProNotesSub>();
		List maxId = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		// String hinNo = "";
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		int hospitalId = 0;
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}
		String yearlyNo = "";
		if (mapForDS.get("yearlySerialNo") != null) {
			yearlyNo = (String) mapForDS.get("yearlySerialNo");
			// hinNo = "";

		}

		int orderNo = 0;
		String yearlySerialNo = "";
		String monthSerialNo = "";
		String yearSeq = "";
		String monthSeq = "";
		String pastYear = "";
		String pastMonth = "";
		try {
			if (bookingId != 0) {

				Criteria crit = session.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("Id", bookingId));
				patientDetailList = crit.list();

				OtBooking booking = (OtBooking) session
						.createCriteria(OtBooking.class)
						.add(Restrictions.eq("OpdSurseryHeader.Id", bookingId))
						.add(Restrictions.eq("OtBookingStatus", "y")
								.ignoreCase()).setFirstResult(0)
						.setMaxResults(1).uniqueResult();

				map.put("booking", booking);

				try {
					maxId = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.setProjection(
									Projections.projectionList().add(
											Projections.max("Id"))).list();

					preAnesthesiaList = session
							.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
							.add(Restrictions.eq("Id", maxId.get(0))).list();
					// preAnesthesiaList=getHibernateTemplate().find("select
					// max(Id), YearlySerialNo,MonthlySerialNo from
					// OtPreAnaesthesiaProcNotesMain pac group by pac.Id");
				} catch (DataAccessException e) {
					e.printStackTrace();
				}

				Calendar calendar = Calendar.getInstance();

				if (preAnesthesiaList != null && preAnesthesiaList.size() > 0) {
					yearlySerialNo = preAnesthesiaList.get(0)
							.getYearlySerialNo();
					monthSerialNo = preAnesthesiaList.get(0)
							.getMonthlySerialNo();
					StringTokenizer st1 = new StringTokenizer(yearlySerialNo,
							"/");
					StringTokenizer st2 = new StringTokenizer(monthSerialNo,
							"/");
					while (st1.hasMoreTokens()) {
						yearSeq = st1.nextToken();
						pastYear = st1.nextToken();

						if (Integer.parseInt(pastYear) != calendar
								.get(Calendar.YEAR)) {

							yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
						} else {

							yearlySerialNo = Integer.parseInt(yearSeq) + 1
									+ "/" + pastYear;
						}
					}
					while (st2.hasMoreTokens()) {
						monthSeq = st2.nextToken();
						pastMonth = st2.nextToken();
						if (Integer.parseInt(pastMonth) != calendar
								.get(Calendar.MONTH) + 1) {
							monthSerialNo = "1/" + calendar.get(Calendar.MONTH)
									+ 1;
						} else {
							if (Integer.parseInt(pastYear) != calendar
									.get(Calendar.YEAR)) {
								monthSerialNo = "1/"
										+ (calendar.get(Calendar.MONTH) + 1);
							} else {
								monthSerialNo = Integer.parseInt(monthSeq) + 1
										+ "/" + pastMonth;
							}
						}
					}
				} else {
					yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
					monthSerialNo = "1/" + (calendar.get(Calendar.MONTH) + 1);
				}
			}
			if (!yearlyNo.equals("")) {
				otList = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("YearlySerialNo", yearlyNo))
						.list();
				otDetailList = session
						.createCriteria(OtPreAnaesthesiaProNotesSub.class)
						.createAlias("PreAnaesthesiaMain", "header")
						.add(Restrictions
								.eq("header.Id", otList.get(0).getId())).list();
				map.put("otList", otList);
				map.put("otDetailList", otDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("patientList", patientList);
		map.put("yearlySerialNo", yearlySerialNo);
		map.put("monthSerialNo", monthSerialNo);
		return map;
	}

	public Map<String, Object> getStoreItemForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";

			// String chargeType= "DIAG";
			Criteria crit = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str).ignoreCase());

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			storeItemList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeItemList", storeItemList);
		return map;
	}

	public Map<String, Object> getNomenclature(String storeItem) {
		List<MasChargeCode> nomenclatureList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			nomenclatureList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("Nomenclature", storeItem)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("nomenclatureList", nomenclatureList);
		return map;
	}

	public Map<String, Object> submitPreAneaesthesiaProcNotesEntryJsp(Box box,
			List<Integer> pvmsNoList) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		// ------- variables declaration-------
		boolean dataSaved = false;
		Vector dose = box.getVector("dose");
		Vector route = box.getVector("route");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = "";
		if (mapForDS.get("userName") != null) {
			userName = (String) mapForDS.get("userName");
		}
		int otPreAnaesthesiaProcNotesMainId = 0;
		int hinId = box.getInt("hinId");
		int orderNo = box.getInt("orderNo");
		int visitId = box.getInt("visitId");
		int bookingId = box.getInt("bookingId");
		int hospitalId = box.getInt(HOSPITAL_ID);
		int userId = box.getInt(USER_ID);
		String preOperativeAdvice = box.getString("preOperativeAdvice");
		String remarks = box.getString("remarks");
		String yearlySrNo = box.getString("yearlySqNo");
		String monthlySrNo = box.getString("monthlySqNo");
		String patientAdvice = "";
		String dostorsNote = "";
		String multipleDrug = "";
		if (box.get("patientAdvise") != null) {
			patientAdvice = (String) box.get("patientAdvise");
		}
		if (box.get("referralNote") != null) {
			dostorsNote = (String) box.get("referralNote");
		}
		if (box.get("multipleDrug") != null) {
			multipleDrug = box.get("multipleDrug");
		}
		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			OtPreAnaesthesiaProcNotesMain otPreAnaesthesiaProcNotesMain = new OtPreAnaesthesiaProcNotesMain();

			Patient patient = new Patient();
			patient.setId(hinId);
			otPreAnaesthesiaProcNotesMain.setHin(patient);
			otPreAnaesthesiaProcNotesMain
					.setPreOperativeAdvice(preOperativeAdvice);
			otPreAnaesthesiaProcNotesMain.setRemarks(remarks);
			otPreAnaesthesiaProcNotesMain.setYearlySerialNo(yearlySrNo);
			otPreAnaesthesiaProcNotesMain.setMonthlySerialNo(monthlySrNo);
			otPreAnaesthesiaProcNotesMain.setOrderNo(orderNo);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			otPreAnaesthesiaProcNotesMain.setHospital(masHospital);
			OtBooking otBooking1 = new OtBooking();
			otBooking1.setId(bookingId);
			otPreAnaesthesiaProcNotesMain.setBooking(otBooking1);
			if (visitId != 0) {
				Visit otvisit = new Visit();
				otvisit.setId(visitId);
				otPreAnaesthesiaProcNotesMain.setVisit(otvisit);
			}

			Users users = new Users();
			users.setId(userId);
			otPreAnaesthesiaProcNotesMain.setLastChgBy(users);
			otPreAnaesthesiaProcNotesMain.setLastChgDate(date);
			otPreAnaesthesiaProcNotesMain.setLastChgTime(time);
			otPreAnaesthesiaProcNotesMain.setPatientAdvice(patientAdvice);
			otPreAnaesthesiaProcNotesMain.setDoctorNotes(dostorsNote);
			otPreAnaesthesiaProcNotesMain.setMultipleDrug(multipleDrug);
			hbt.save(otPreAnaesthesiaProcNotesMain);

			for (int i = 0; i < pvmsNoList.size(); i++) {
				OtPreAnaesthesiaProNotesSub otPreAnaesthesiaProNotesSub = new OtPreAnaesthesiaProNotesSub();

				otPreAnaesthesiaProNotesSub
						.setPreAnaesthesiaMain(otPreAnaesthesiaProcNotesMain);

				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(pvmsNoList.get(i));
				otPreAnaesthesiaProNotesSub.setStoreItem(masStoreItem);

				otPreAnaesthesiaProNotesSub.setRoute((String) route.get(i));
				otPreAnaesthesiaProNotesSub.setDose((String) dose.get(i));
				hbt.save(otPreAnaesthesiaProNotesSub);
			}

			OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
					bookingId);
			otBooking.setSurgeryStatus("y");
			hbt.update(otBooking);
			dataSaved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map.put("dataSaved", dataSaved);

		return map;
	}

	/**
	 * ------------------------- OT PROCEDURE NOTES ENTRY
	 * ------------------------------
	 */
	public Map<String, Object> showOtProcedureNotesEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<OtProcedureNotesEntryHeader> otList = new ArrayList<OtProcedureNotesEntryHeader>();
		List<OtProcedureNotesEntryDetail> otDetailList = new ArrayList<OtProcedureNotesEntryDetail>();
		List<OtProcedureNotesEntryHeader> otProcedureNotesList = new ArrayList<OtProcedureNotesEntryHeader>();
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<OtBookSurgeon> otBookSurgeaonList = new ArrayList<OtBookSurgeon>();
		List<OpdSurgeryHeader> surgeryList = new ArrayList<OpdSurgeryHeader>();
		// List<OtPreAnesthesiaDetails>otPreAnesthesiaDetailsList=new
		// ArrayList<OtPreAnesthesiaDetails>();
		List<MasAnesthesia> anaesthesiaList = new ArrayList<MasAnesthesia>();
		List maxId = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();

		String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		int surgeryHdId = 0;
		if (mapForDS.get("surgeryHdId") != null) {
			surgeryHdId = (Integer) mapForDS.get("surgeryHdId");
		}
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		String yearlyNo = "";
		if (mapForDS.get("yearlySerialNo") != null) {
			yearlyNo = (String) mapForDS.get("yearlySerialNo");
			hinNo = "";

		}
		int orderNo = 0;
		String yearlySerialNo = "";
		String monthSerialNo = "";
		String yearSeq = "";
		String monthSeq = "";
		String pastYear = "";
		String pastMonth = "";
		int visitId = 0;
		int hinId = 0;
		anaesthesiaList = session.createCriteria(MasAnesthesia.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (surgeryHdId != 0) {
			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("OpdSurseryHeader.Id", surgeryHdId));
			patientDetailList = crit.list();
			otBookSurgeaonList = session
					.createCriteria(OtBookSurgeon.class)
					.createAlias("Booking", "ot")
					.add(Restrictions.eq("ot.Id", patientDetailList.get(0)
							.getId())).list();

			/*
			 * otPreAnesthesiaDetailsList=session.createCriteria(
			 * OtPreAnesthesiaDetails .class).createAlias("Hin","p")
			 * .add(Restrictions.eq("p.HinNo",hinNo)).list();
			 */
			try {
				maxId = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.setProjection(
								Projections.projectionList().add(
										Projections.max("Id"))).list();

				otProcedureNotesList = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.add(Restrictions.eq("Id", maxId.get(0))).list();
				// preAnesthesiaList=getHibernateTemplate().find("select
				// max(Id), YearlySerialNo,MonthlySerialNo from
				// OtPreAnaesthesiaProcNotesMain pac group by pac.Id");

				Calendar calendar = Calendar.getInstance();

				if (otProcedureNotesList != null
						&& otProcedureNotesList.size() > 0) {
					yearlySerialNo = otProcedureNotesList.get(0)
							.getYearlySerialNo();
					monthSerialNo = otProcedureNotesList.get(0)
							.getMonthlySerialNo();
					StringTokenizer st1 = new StringTokenizer(yearlySerialNo,
							"/");
					StringTokenizer st2 = new StringTokenizer(monthSerialNo,
							"/");
					while (st1.hasMoreTokens()) {
						yearSeq = st1.nextToken();
						pastYear = st1.nextToken();

						if (Integer.parseInt(pastYear) != calendar
								.get(Calendar.YEAR)) {

							yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
						} else {

							yearlySerialNo = Integer.parseInt(yearSeq) + 1
									+ "/" + pastYear;
						}
					}
					while (st2.hasMoreTokens()) {
						monthSeq = st2.nextToken();
						pastMonth = st2.nextToken();
						if (Integer.parseInt(pastMonth) != calendar
								.get(Calendar.MONTH) + 1) {
							monthSerialNo = "1/" + calendar.get(Calendar.MONTH)
									+ 1;
						} else {
							if (Integer.parseInt(pastYear) != calendar
									.get(Calendar.YEAR)) {
								monthSerialNo = "1/"
										+ (calendar.get(Calendar.MONTH) + 1);
							} else {
								monthSerialNo = Integer.parseInt(monthSeq) + 1
										+ "/" + pastMonth;
							}
						}
					}
				} else {
					yearlySerialNo = "1/" + calendar.get(Calendar.YEAR);
					monthSerialNo = "1/" + (calendar.get(Calendar.MONTH) + 1);
				}

			} catch (HibernateException e) {
				e.printStackTrace();
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			map.put("patientDetailList", patientDetailList);
			map.put("surgeryHdId", surgeryHdId);
			map.put("otBookSurgeaonList", otBookSurgeaonList);
			map.put("yearlySerialNo", yearlySerialNo);
			map.put("monthSerialNo", monthSerialNo);
			// map.put("otPreAnesthesiaDetailsList",
			// otPreAnesthesiaDetailsList);
		} else {
			otList = session.createCriteria(OtProcedureNotesEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("YearlySerialNo", yearlyNo)).list();
			otDetailList = session
					.createCriteria(OtProcedureNotesEntryDetail.class)
					.createAlias("OtProcedureHeader", "header")
					.add(Restrictions.eq("header.Id", otList.get(0).getId()))
					.list();
			map.put("otList", otList);
			map.put("otDetailList", otDetailList);
		}
		// By Awadhesh
		surgeryList = session.createCriteria(OpdSurgeryHeader.class)
				.add(Restrictions.eq("Id", surgeryHdId)).list();
		for (OpdSurgeryHeader surgery : surgeryList) {
			hinId = surgery.getHin().getId();
			visitId = surgery.getVisit()!=null?surgery.getVisit().getId():0;
		}
		List<PatientPrescriptionDetails> patientPrescriptionDetails = new ArrayList<PatientPrescriptionDetails>();
		PatientPrescriptionDetails prescriptionDetails = null;
		PatientPrescriptionHeader prescriptionHeader = null;
		MasStoreItem masStoreItem = null;
		MasFrequency frequency = null;
		MasManufacturer manufacturer = null;
		RouteOfAdministration routeOfAdministration = null;
		OpdInstructionTreatment opdInstructionTreatment = null;
		SQLQuery sqlQuery = session
				.createSQLQuery("select * from patient_prescription_details ppd join  patient_prescription_header pph on ppd.prescription_id = pph.prescription_id "
						+ "join  patient p on p.hin_id = pph.hin_id join  visit v on v.visit_id = pph.visit_id left join inj_appointment_details iad on iad.prescription_details_id = ppd.id "
						+ "where p.hin_id=:hinId and v.visit_id = :visitId and LOWER(v.cur_phar_visit_status) = 'y'  and (immunization_inj = 'n' or immunization_inj is null)");

		sqlQuery.setParameter("hinId", hinId);
		sqlQuery.setParameter("visitId", visitId);

		List<Object[]> results = sqlQuery.list();

		if (results != null && results.size() > 0) {
			for (Object[] objects : results) {
				prescriptionDetails = new PatientPrescriptionDetails();
				prescriptionDetails.setId((Integer) objects[0]);

				prescriptionHeader = (PatientPrescriptionHeader) session.get(
						PatientPrescriptionHeader.class, (Integer) objects[1]);
				prescriptionDetails.setPrescription(prescriptionHeader);

				masStoreItem = (MasStoreItem) session.get(MasStoreItem.class,
						(Integer) objects[2]);
				prescriptionDetails.setItem(masStoreItem);

				prescriptionDetails.setDosage(((BigDecimal) objects[3])
						.floatValue());

				frequency = (MasFrequency) session.get(MasFrequency.class,
						(Integer) objects[4]);
				prescriptionDetails.setFrequency(frequency);

				prescriptionDetails.setNoOfDays((Integer) objects[5]);
				prescriptionDetails.setTotal(((BigDecimal) objects[6])
						.floatValue());
				prescriptionDetails.setType((String) objects[7]);

				if (objects[8] != null)
					prescriptionDetails
							.setDispensingPrice(((BigDecimal) objects[8])
									.floatValue());

				prescriptionDetails.setBrandId((Integer) objects[9]);

				if (objects[10] != null) {
					manufacturer = (MasManufacturer) session.get(
							MasManufacturer.class, (Integer) objects[10]);
					prescriptionDetails.setManufacturer(manufacturer);
				}

				if (objects[11] != null)
					prescriptionDetails
							.setTotalStoreIssuedQty(((BigDecimal) objects[11])
									.floatValue());

				prescriptionDetails.setIssuedStatus((String) objects[12]);

				if (objects[13] != null) {
					routeOfAdministration = (RouteOfAdministration) session
							.get(RouteOfAdministration.class,
									(Integer) objects[13]);
					prescriptionDetails.setRoute(routeOfAdministration);
				}

				if (objects[14] != null) {
					opdInstructionTreatment = (OpdInstructionTreatment) session
							.get(OpdInstructionTreatment.class,
									(Integer) objects[14]);
					prescriptionDetails.setInsrtuction(opdInstructionTreatment);
				}

				prescriptionDetails.setSplInstruction((String) objects[15]);

				if (objects[16] != null)
					prescriptionDetails
							.setCurStoreIssuedQty(((BigDecimal) objects[16])
									.floatValue());

				prescriptionDetails.setReferToEmpanelled((String) objects[17]);
				prescriptionDetails.setNotAvailable((String) objects[18]);

				if (objects[19] != null)
					prescriptionDetails
							.setEmpRequestQty(((BigDecimal) objects[19])
									.floatValue());

				if (objects[20] != null)
					prescriptionDetails
							.setEmpIssuedQty(((BigDecimal) objects[20])
									.floatValue());

				if (objects[21] != null)
					prescriptionDetails
							.setTotalEmpIssuedQty(((BigDecimal) objects[21])
									.floatValue());

				prescriptionDetails.setStartDate((Date) objects[22]);
				prescriptionDetails.setEndDate((Date) objects[23]);
				prescriptionDetails.setNursingStatus((String) objects[25]);
				prescriptionDetails.setNursingTime((String) objects[26]);
				prescriptionDetails.setNursingDate((Date) objects[27]);
				prescriptionDetails.setInjectionStatus((String) objects[28]);
				prescriptionDetails.setInjGivenQty((Long) objects[29]);
				prescriptionDetails.setCt((String) objects[30]);
				patientPrescriptionDetails.add(prescriptionDetails);
			}
		}

		List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
		List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();

		routeOfAdministrationList = session
				.createCriteria(RouteOfAdministration.class)
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.addOrder(Order.asc("OrderNo")).list();
		masInstructionMasterList = session
				.createCriteria(OpdInstructionTreatment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		frequencyList = session.createCriteria(MasFrequency.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("routeOfAdministrationList", routeOfAdministrationList);
		map.put("masInstructionMasterList", masInstructionMasterList);
		map.put("frequencyList", frequencyList);
		map.put("patientPrescriptionDetails", patientPrescriptionDetails);
		map.put("hinId", hinId);
		map.put("visitId", visitId);
		// .............By Awadhesh...............
		map.put("anaesthesiaList", anaesthesiaList);
		return map;
	}

	public Map<String, Object> getEmpNameForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + mapForDS.get("autoHint") + "%";

			// String chargeType= "DIAG";
			Criteria crit = session.createCriteria(MasEmployee.class).add(
					Restrictions.like("FirstName", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId, Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		// ------- variables declaration-------
		boolean dataSaved = false;
		OpdPatientDetails opdPatientDetails = null;
		final Map<String, Object> opdPatientData = new HashMap<String, Object>();
		int otPreAnaesthesiaProcNotesMainId = 0;
		int hinId = box.getInt("hinId");
		int pharmacyDepartmentId = 0;
		int surgeryId = (Integer) mapForDS.get("surgeryId");
		int orderNo = box.getInt("orderNo");
		int bookingId = box.getInt("bookingId");
		int hospitalId = box.getInt(HOSPITAL_ID);
		Date date = HMSUtil.convertStringTypeDateToDateType(box.get("date"));
		String surgeryFromTime = box.getString("surgeryFromTime");
		String surgeryToTime = box.getString("surgeryToTime");
		int anaesthesiaId = box.getInt("anaesthesiaId");
		String preOpOrders = box.getString("preOpOrders");
		String findings = box.getString("findings");
		String postOpOrders = box.getString("postOpOrders");
		String yearlySrNo = box.getString("yearlySerialNo");
		String monthlySrNo = box.getString("monthlySerialNo");
		String lastChgBy = box.getString("changedBy");
		String lastChgTime = box.getString("changedTime");
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("changedDate"));
		int userId = box.getInt(USER_ID);
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ------ business logic-------
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		OpdSurgeryHeader SurgeryObject = (OpdSurgeryHeader) hbt.get(
				OpdSurgeryHeader.class, surgeryId);
		int visitId = SurgeryObject.getVisit().getId();
		Visit visitObjToUpdate = (Visit) hbt.get(Visit.class, visitId);
		int departmentId = visitObjToUpdate.getDepartment().getId();
		Patient patient = (Patient) hbt.get(Patient.class, hinId);
		List<OpdPatientDetails> listlist = session
				.createCriteria(OpdPatientDetails.class)
				.createAlias("Visit", "vis")
				.add(Restrictions.eq("vis.Id", visitId)).list();
		if (listlist.size() > 0) {
			opdPatientDetails = listlist.get(0);

		}
		try {
			OtProcedureNotesEntryHeader otProcedureNotesEntryHeader = new OtProcedureNotesEntryHeader();

			patient.setId(hinId);
			otProcedureNotesEntryHeader.setHin(patient);
			otProcedureNotesEntryHeader.setSurgeryFromTime(surgeryFromTime);
			otProcedureNotesEntryHeader.setSurgeryToTime(surgeryToTime);
			otProcedureNotesEntryHeader.setDate(date);

			if (anaesthesiaId != 0) {
				MasAnesthesia masAnesthesia = new MasAnesthesia();
				masAnesthesia.setId(anaesthesiaId);
				otProcedureNotesEntryHeader.setAnaesthesia(masAnesthesia);
			}

			otProcedureNotesEntryHeader.setPreOpOrders(preOpOrders);
			otProcedureNotesEntryHeader.setFindingsNProcedures(findings);
			otProcedureNotesEntryHeader.setPostOpOrders(postOpOrders);
			otProcedureNotesEntryHeader.setYearlySerialNo(yearlySrNo);
			otProcedureNotesEntryHeader.setMonthlySerialNo(monthlySrNo);
			Users users = new Users();
			users.setId(userId);
			otProcedureNotesEntryHeader.setLastChgBy(users);
			otProcedureNotesEntryHeader.setLastChgDate(lastChgDate);
			otProcedureNotesEntryHeader.setLastChgTime(lastChgTime);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			otProcedureNotesEntryHeader.setHospital(masHospital);
			OtBooking booking = (OtBooking) hbt.get(OtBooking.class, bookingId);
			otProcedureNotesEntryHeader.setBooking(booking);
			booking.setOtNoteProcedureStatus("y");
			hbt.save(otProcedureNotesEntryHeader);

			for (int i = 0; i < employeeId.size(); i++) {
				OtProcedureNotesEntryDetail otProcedureNotesEntryDetail = new OtProcedureNotesEntryDetail();

				otProcedureNotesEntryDetail
						.setOtProcedureHeader(otProcedureNotesEntryHeader);

				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId.get(i));
				otProcedureNotesEntryDetail.setEmployee(masEmployee);

				hbt.save(otProcedureNotesEntryDetail);

			}

			dataSaved = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// done by Awadhesh for medication

		Integer opdpatientDetailId = (Integer) mapForDS
				.get("opdpatientDetailId");
		List<String> pvmsNoList = (List<String>) mapForDS.get("pvmsNoList");
		List<Integer> frequencyList = (List) mapForDS.get("frequencyList");
		List<Float> dosageList = (List) mapForDS.get("dosageList");
		List<Float> totalList = (List<Float>) mapForDS.get("totalList");
		List<Float> actualTotalAfterMixList = (List<Float>) mapForDS
				.get("actualTotalAfterMixList"); // added by amit das on
													// 19-11-2016
		List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
		List<Integer> routes = (List) mapForDS.get("routes");
		List<Integer> instrunctions = (List) mapForDS.get("instrunctionsList");
		List<String> spLinstrunctionList = (List) mapForDS
				.get("spLinstrunctionList");
		String prescriptionNo = (String) mapForDS.get("prescriptionNo");
		List<Date> startDates = (List) mapForDS.get("startDatesList");
		List<Date> endDates = (List) mapForDS.get("endDatesList");
		List<Integer> itemIdList = new ArrayList<Integer>();
		StringBuffer prescribedMedicin = new StringBuffer();
		List<Integer> parkPrescriptionIds = (List<Integer>) mapForDS
				.get("parkPrescriptionIds");
		Integer pHeaderId = (Integer) mapForDS.get("pHeaderId");
		List<String> prescription_availableStatusList = (List) mapForDS
				.get("prescription_availableStatusList");
		String consultationTime = (String) mapForDS.get("consultationTime");
		String consultationDate = (String) mapForDS.get("consultationDate");
		Date consultationDateToInsert = HMSUtil
				.convertStringTypeDateToDateType(consultationDate);
		pharmacyDepartmentId = Integer.parseInt(properties
				.getProperty("pharmacyDepartmentId"));
		// List<String> dpStatus = (List<String>) mapForDS.get("dpStatusList");		
		//added by govind 30-10-2017
		List<TaperedMedicineUtil> taperUtilList=new ArrayList<TaperedMedicineUtil>();
		if(mapForDS.get("taperUtilList") != null){
			taperUtilList=(List<TaperedMedicineUtil>)  mapForDS.get("taperUtilList");
		}

		//added by govind 30-10-2017 end
		if (pvmsNoList.size() > 0) {
			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			if (pHeaderId != null && pHeaderId != 0) {
				patientPrescriptionHeader = hbt.load(
						PatientPrescriptionHeader.class, pHeaderId);
			} else {
				patientPrescriptionHeader = new PatientPrescriptionHeader();
			}

			MasDepartment masDepartment = new MasDepartment();
			MasHospital masHospital = new MasHospital();
			patientPrescriptionHeader.setHin(patient);
			masDepartment.setId(departmentId);
			patientPrescriptionHeader.setDepartment(masDepartment);
			patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
			patientPrescriptionHeader.setVisit(visitObjToUpdate);
			masHospital.setId(hospitalId);
			patientPrescriptionHeader.setHospital(masHospital);
			patientPrescriptionHeader.setStatus("p");
			patientPrescriptionHeader
					.setPrescriptionDate(consultationDateToInsert);
			patientPrescriptionHeader.setPrescriptionTime(consultationTime);
			patientPrescriptionHeader.setDispencingDate(date);
			patientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);

			// Start.. Added by Dhananjay 02-Jan-2017

			String pharmacyLabStatus = "P";
			PharmacyLabQueue pharmacyLabQueue = saveQueueNoForPharmacy(
					pharmacyDepartmentId, hospitalId, visitObjToUpdate,
					pharmacyLabStatus);
			if (null != pharmacyLabQueue)
				patientPrescriptionHeader.setPharmacyLabQueue(pharmacyLabQueue);
			// End

			if (pHeaderId != null && pHeaderId != 0) {
				hbt.update(patientPrescriptionHeader);
			} else {
				hbt.save(patientPrescriptionHeader);
			}

			opdPatientData.put("PatientPrescriptionHeader",
					patientPrescriptionHeader);
			for (int i = 0; i < pvmsNoList.size(); i++) {
				String pvmsNo = (String) pvmsNoList.get(i);
				List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
				itemIdListNew = getItemIdFromPVMSMedicine(pvmsNo);
				for (int k = 0; k < itemIdListNew.size(); k++) {
					itemIdList.add(itemIdListNew.get(k).getId());
				}
			}
			int item_class_id = 0;
			MasFrequency masFrequency = null;
			MasStoreItem masStoreItem = null;
			RouteOfAdministration routeOfAdministration = null;
			OpdInstructionTreatment opdInstructionTreatment = null;
			List<Object> opdPatientListObject = new ArrayList<Object>();

			String[] durationStr1 = null;
			String[] durationStr2 = null;
			List<String> durationPrescriptionList = new ArrayList<String>();
			if (mapForDS.get("durationPrescriptionList") != null) {
				durationPrescriptionList = (List<String>) mapForDS
						.get("durationPrescriptionList");
			}

			InjAppointmentDetails injAppointmentDetails = null;

			for (int i = 0; i < itemIdList.size(); i++) {
				String[] dayCount = null;
				String mainStr = "";
				if (durationPrescriptionList != null
						&& durationPrescriptionList.size() > i) {
					mainStr = (String) durationPrescriptionList.get(i);
					dayCount = mainStr.split(",");
				}

				PatientPrescriptionDetails patientPrescriptionDetails = null;

				if (parkPrescriptionIds != null
						&& !parkPrescriptionIds.get(i).equals(0)) {
					patientPrescriptionDetails = hbt.load(
							PatientPrescriptionDetails.class,
							parkPrescriptionIds.get(i));
					// added by govind 28-03-2017 for duplicate came in recall
					// patient
					Criteria cr = session.createCriteria(
							InjAppointmentDetails.class).add(
							Restrictions.eq("PrescriptionDetails.Id",
									parkPrescriptionIds.get(i)));
					if (cr.list().size() > 0) {
						injAppointmentDetails = (InjAppointmentDetails) cr
								.list().get(0);
					}
					// added by govind 28-03-2017 end
				} else {
					patientPrescriptionDetails = new PatientPrescriptionDetails();
					injAppointmentDetails = new InjAppointmentDetails();// added
																		// by
																		// govind
																		// 28-03-2017
				}
				if (itemIdList != null && itemIdList.size() > 0
						&& itemIdList.get(i) != 0)
					masStoreItem = (MasStoreItem) session.load(
							MasStoreItem.class, itemIdList.get(i));// new
																	// MasStoreItem(itemIdList.get(i));

				if (frequencyList != null && frequencyList.size() > 0
						&& frequencyList.get(i) != 0)
					masFrequency = new MasFrequency(frequencyList.get(i));

				if (routes != null && routes.size() > 0 && routes.get(i) != 0)
					routeOfAdministration = new RouteOfAdministration(
							routes.get(i));

				if (instrunctions != null && instrunctions.size() > 0
						&& instrunctions.get(i) != 0) {
					opdInstructionTreatment = new OpdInstructionTreatment(
							instrunctions.get(i));
				}
				if (noOfDaysList.size() > 0 && noOfDaysList.get(i) != 0
						&& noOfDaysList.get(i) != 0) {
					patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
				}
				if (spLinstrunctionList != null
						&& spLinstrunctionList.size() > 0) {
					patientPrescriptionDetails
							.setSplInstruction(spLinstrunctionList.get(i));
				}

				prescribedMedicin.append(masStoreItem.getNomenclature() + ",");
				patientPrescriptionDetails
						.setNotAvailable(prescription_availableStatusList
								.get(i));
				patientPrescriptionDetails.setItem(masStoreItem);
				patientPrescriptionDetails.setFrequency(masFrequency);
				patientPrescriptionDetails.setDosage(dosageList.get(i));
				patientPrescriptionDetails
						.setInsrtuction(opdInstructionTreatment);
				patientPrescriptionDetails.setRoute(routeOfAdministration);
				patientPrescriptionDetails.setType("OP");
				patientPrescriptionDetails.setTotal(totalList.get(i));
				patientPrescriptionDetails
						.setActualTotal(actualTotalAfterMixList.get(i)); // added
																			// by
																			// amit
																			// das
																			// on
																			// 19-11-2016
				patientPrescriptionDetails.setStartDate(startDates.get(i));
				patientPrescriptionDetails.setEndDate(endDates.get(i));
				patientPrescriptionDetails.setNursingStatus("n");
				patientPrescriptionDetails
						.setPrescription(patientPrescriptionHeader);

				List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
				/*
				 * Properties properties = new Properties(); URL resourcePath =
				 * Thread.currentThread().getContextClassLoader().getResource(
				 * "adt.properties");
				 */
				try {
					properties.load(resourcePath.openStream());
					String item_class_code = properties
							.getProperty("item_class_id");
					item_class_id = Integer.parseInt(item_class_code);
				} catch (Exception e) {
					e.printStackTrace();
				}
				storeItemList = hbt
						.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="
								+ itemIdList.get(i)
								+ " and ic.Id="
								+ item_class_id);
				if (storeItemList.size() > 0) {
					patientPrescriptionDetails.setInjectionStatus("p");
				} else {
					patientPrescriptionDetails.setInjectionStatus("n");
				}

				if (visitObjToUpdate != null
						&& visitObjToUpdate.getVisitStatus().equalsIgnoreCase(
								"p") && parkPrescriptionIds != null
						&& !parkPrescriptionIds.get(i).equals(0)) {
					hbt.update(patientPrescriptionDetails);
				} else {
					hbt.save(patientPrescriptionDetails);
				}

				opdPatientListObject.add(patientPrescriptionDetails);
				
				for(TaperedMedicineUtil tapUtil:taperUtilList){
					if(tapUtil.getItemId().equals(masStoreItem.getId())){
					TaperedMedicineOp tapered=new TaperedMedicineOp();
					tapered.setPrescription(patientPrescriptionDetails);
					MasFrequency frequency=new MasFrequency();
					frequency.setId(tapUtil.getFrequency());
					MasStoreItem item=new MasStoreItem();
					item.setId(tapUtil.getItemId());
					tapered.setFrequency(frequency);
					tapered.setItem(item);
					tapered.setDosageDetail(tapUtil.getDosage());
					tapered.setDosage(tapUtil.getDosageCount());
					tapered.setNoOfDays(tapUtil.getDuration());
					tapered.setTotal(tapUtil.getTotal());
					hbt.save(tapered);
					}
				}
				// prevent insulin for nursing station and available in pharmacy
				// only in readonly mod

			}

		}
		map.put("dataSaved", dataSaved);
		map.put("YearlySrNo", yearlySrNo);

		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreItem> getItemIdFromPVMSMedicine(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			itemIdList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemIdList;
	}

	public String generatePrecriptionNo(int hinId) {
		org.hibernate.Session session = getSession();
		List<PatientPrescriptionDetails> patientPrescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();
		List<Object> objectList = new ArrayList<Object>();
		String prescriptionNo = "1";
		String qry = "";
		try {
			objectList = (List<Object>) session
					.createSQLQuery(
							"select max(prescription_id)+1  from patient_prescription_header h,patient p where p.hin_id=h.hin_id and p.hin_id="
									+ hinId + " ").list();

			if (objectList.size() > 0) {
				for (Object object : objectList) {

					if (object != null) {

						/*
						 * prescriptionNo = Integer.toString((((Double) object)
						 * .intValue()));
						 */
						prescriptionNo = Integer.toString((((Integer) object)
								.intValue()));

					}

				}
			}

			// "+prescriptionNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("prescriptionNo " + prescriptionNo);
		return prescriptionNo;
	}

	@SuppressWarnings("unchecked")
	public List<String> getOtProcHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<String> hinList = new ArrayList<String>();

		try {

			hinList = session
					.createCriteria(OtProcedureNotesEntryHeader.class)
					.createAlias("Hin", "p")
					.setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("p.HinNo"))))
					.add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hinList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getYearlySerialNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}

		List<Object> yearlySerialNoList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				yearlySerialNoList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				yearlySerialNoList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return yearlySerialNoList;

	}

	public List<Object> getOtProcPatientDetailList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		String yearlySerialNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("yearlySerialNo") != null) {
			yearlySerialNo = (String) detailsMap.get("yearlySerialNo");
		}
		List<Object> patientDetailList = new ArrayList<Object>();
		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtProcedureNotesEntryHeader.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}
			if (!yearlySerialNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtProcedureNotesEntryHeader.class).add(
						Restrictions.eq("YearlySerialNo", yearlySerialNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientDetailList;

	}

	public List<String> getPreAnaesthesiaHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<String> hinList = new ArrayList<String>();

		try {

			hinList = session
					.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
					.createAlias("Hin", "p")
					.setProjection(
							Projections.distinct(Projections.projectionList()
									.add(Projections.property("p.HinNo"))))
					.add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return hinList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getPreAnaesthesiaYearlySerialNoList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}

		List<Object> yearlySerialNoList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				yearlySerialNoList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				yearlySerialNoList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return yearlySerialNoList;

	}

	public List<Object> getPreAnaesthseiaPatientDetailList(
			Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		String yearlySerialNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("yearlySerialNo") != null) {
			yearlySerialNo = (String) detailsMap.get("yearlySerialNo");
		}
		List<Object> patientDetailList = new ArrayList<Object>();
		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPreAnaesthesiaProcNotesMain.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}
			if (!yearlySerialNo.equals("")) {
				Criteria crit = session.createCriteria(
						OtPreAnaesthesiaProcNotesMain.class).add(
						Restrictions.eq("YearlySerialNo", yearlySerialNo));
				patientDetailList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientDetailList;

	}

	// ------------------ BY MANSI ----------------
	public Map<String, Object> searchSpecimenPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		String patientStatus = "Out Patient";
		Criteria crit = session.createCriteria(Patient.class)
				.add(Restrictions.not(Expression.eq("PatientStatus",
						patientStatus)));
		if (hinNo != null) {
			if (!serviceNo.equals("")) {
				crit = crit.add(Restrictions.eq("ServiceNo", serviceNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientFName
						+ "%"));
			}
			if (!patientMName.equals("")) {
				crit = crit.add(Restrictions.like("PMiddleName", patientMName
						+ "%"));
			}
			if (!patientLName.equals("")) {
				crit = crit.add(Restrictions.like("PLastName", patientLName
						+ "%"));
			}
		} else {
			crit = crit.add(Restrictions.eq("HinNo", hinNo));
		}
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showSpecimenJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();

		Map<String, Object> map = new HashMap<String, Object>();
		String transactionSequenceName = "Surgery Requisition No";
		String departmentType = "Surgical";
		String hinNo = (String) mapForDS.get("hinNo");
		int entryNo = 0;
		try {

			Criteria crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("HinNo", hinNo));
			patientDetailList = crit.list();
			departmentList = session
					.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "deptType")
					.add(Restrictions.eq("deptType.DepartmentTypeName",
							departmentType)).list();
			sequenceNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionSequenceName",
							transactionSequenceName)).list();
			TransactionSequence transactionSequence = sequenceNoList.get(0);
			int sequenceNo = transactionSequence.getTransactionSequenceNumber();
			entryNo = sequenceNo + 1;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("departmentList", departmentList);
		map.put("entryNo", entryNo);

		return map;

	}

	/**
	 * ------------------------- OT Post Anaesthesia Patient Details By
	 * Mansi------------------------------
	 */

	public Map<String, Object> searchPostAnaesthesiaPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;

		// String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		boolean flag = false;

		Session session = (Session) getSession();

		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}
		List<String> aList = new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		Integer typeId = 11;
		Criteria crit = session
				.createCriteria(OtBooking.class)
				.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
				.add(Restrictions.eq("OtPostAnethesiaStatus", "n").ignoreCase())
				.createAlias("Hin", "hin")
				.createAlias("Inpatient", "ip", CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.or(Restrictions.isNotNull("Visit"),
						Restrictions.in("ip.AdStatus", aList)))
				/*
				 * createAlias("sheader.Inpatient",
				 * "ip").add(Restrictions.in("ip.AdStatus",aList))
				 */
				.createAlias("ChargeCode", "charge")
				.add(Restrictions.ne("charge.ChargeType.Id", typeId));// Added
																		// by
																		// Arbind
																		// on
																		// 17-07-2017

		if (!uhid.equals("")) {
			crit.add(Restrictions.eq("hin.HinNo", uhid.toLowerCase())
					.ignoreCase());
		}
		if (!pName.equals("")) {
			crit.add(Restrictions.like("hin.PFirstName",
					pName.toLowerCase() + "%").ignoreCase());
		}
		if (!ipNo.equals("")) {

			crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
					.ignoreCase());
		}
		if (gender != 0) {
			crit.createAlias("hin.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}

		/*
		 * if (!serviceNo.equals("")) { crit =
		 * crit.add(Restrictions.eq("hin.ServiceNo", serviceNo)); flag=true; }
		 */
		/*
		 * if (!patientFName.equals("")) { crit =
		 * crit.add(Restrictions.like("hin.PFirstName", patientFName)
		 * .ignoreCase()); flag = true; } if (!patientMName.equals("")) { crit =
		 * crit.add(Restrictions.like("hin.PMiddleName", patientMName)
		 * .ignoreCase()); flag = true; } if (!patientLName.equals("")) { crit =
		 * crit.add(Restrictions.like("hin.PLastName", patientLName)
		 * .ignoreCase()); flag = true; } if (!hinNo.equals("")) { crit =
		 * crit.add(Restrictions.eq("hin.HinNo", hinNo)); flag = true; } crit =
		 * crit.add(Restrictions.eq("Hospital.Id", hospitalId));
		 * 
		 * if (flag == true) {
		 * 
		 * }
		 */
		patientList = crit.addOrder(Order.asc("Id")).list();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);

		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showPostAnaesthesiaJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
		/*
		 * List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		 * List<TransactionSequence> sequenceNoList = new
		 * ArrayList<TransactionSequence>();
		 */
		Map<String, Object> map = new HashMap<String, Object>();
		/* String transactionSequenceName="Surgery Requisition No"; */
		/* String departmentType="Surgical"; */
		// String hinNo = (String) mapForDS.get("hinNo");
		/* int yearlySrNo=0; */
		int otBookId = (Integer) mapForDS.get("otBookId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Id", otBookId));
			patientDetailList = crit.list();
			anesthesiaList = session.createCriteria(MasAnesthesia.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			crit = session.createCriteria(OtPostAnaesthesiaProcedure.class)
			/*
			 * .createAlias("Hin", "hin") .add(Restrictions.eq("hin.Id",
			 * hinId));
			 */
			.createAlias("Booking", "ob")
					.add(Restrictions.eq("ob.Id", otBookId))
					.add(Restrictions.eq("Hospital.Id", hospitalId));
			otPostAnaesthesiaProcedureList = crit.list();
			/*
			 * sequenceNoList=session.createCriteria(TransactionSequence.class).add
			 * (Restrictions.eq("TransactionSequenceName",
			 * transactionSequenceName)).list(); TransactionSequence
			 * transactionSequence=sequenceNoList.get(0); int
			 * sequenceNo=transactionSequence.getTransactionSequenceNumber();
			 * yearlySrNo=sequenceNo+1;
			 */
			if (otPostAnaesthesiaProcedureList.size() > 0) {
				map.put("otPostAnaesthesiaProcedureList",
						otPostAnaesthesiaProcedureList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("anesthesiaList", anesthesiaList);
		/* map.put("yearlySrNo", yearlySrNo); */

		return map;

	}

	public String getYearlySeqForDisplay() {
		Map<String, Object> map = new HashMap<String, Object>();
		String yearlySrNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<OtPostAnaesthesiaProcedure> seqNoList = new ArrayList<OtPostAnaesthesiaProcedure>();
		String lastSeqNo = "";
		String stNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(OtPostAnaesthesiaProcedure.class)
				.list();
		if (seqNoList.size() > 0) {
			for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : seqNoList) {
				lastSeqNo = otPostAnaesthesiaProcedure.getYearlyslno();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				stNo = str.nextToken();
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "YNO")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
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
				yearlySrNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("OtPostAnaesthesiaProcedure");
			tsObj.setTransactionPrefix("YNO");
			tsObj.setTransactionSequenceName("Year No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			yearlySrNo = yearlySrNo.concat("/").concat(
					String.valueOf(lastSeqYear));

		}

		return yearlySrNo;
	}

	public String getMonthlySeqForDisplay() {

		Map<String, Object> map = new HashMap<String, Object>();
		String monthlySrNo = "";
		List<TransactionSequence> orderSeqNoList = new ArrayList<TransactionSequence>();
		List<OtPostAnaesthesiaProcedure> seqNoList = new ArrayList<OtPostAnaesthesiaProcedure>();
		String lastSeqNo = "";
		String stNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(OtPostAnaesthesiaProcedure.class)
				.list();
		if (seqNoList.size() > 0) {
			for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : seqNoList) {
				lastSeqNo = otPostAnaesthesiaProcedure.getMonthlyslno();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				stNo = str.nextToken();
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentMonth;
		}
		orderSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "MNO")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (orderSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : orderSeqNoList) {
				TransactionSequence obj = (TransactionSequence) orderSeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentMonth.equals(lastSeqYear)) {
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
				monthlySrNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));

			}
		} else if (orderSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("OtPostAnaesthesiaProcedure");
			tsObj.setTransactionPrefix("MNO");
			tsObj.setTransactionSequenceName("Month No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");
			hbt.save(tsObj);
			monthlySrNo = monthlySrNo.concat("/").concat(
					String.valueOf(lastSeqYear));

		}

		return monthlySrNo;

	}

	public Map<String, Object> showPACDetailJsp(int orderNo, int hinId,
			int visitId) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaDetails> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			otPreAnesthesiaDetailsList = session
					.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			opdPatientHistoryList = session
					.createCriteria(OpdPatientHistory.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId))
					.add(Restrictions.eq("VisitInpatientId", visitId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		return map;
	}

	public Map<String, Object> getChargeCodeValue(String chargeCodeName) {
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			String chargeType = "oper";
			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeName", chargeCodeName))
					.createAlias("ChargeType", "charge")
					.add(Restrictions.eq("charge.ChargeTypeCode", chargeType))
					.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}

	public Map<String, Object> getSurgeyForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			String chargeType = "oper";
			Criteria crit = session.createCriteria(MasChargeCode.class)
					.createAlias("ChargeType", "charge")
					.add(Restrictions.eq("charge.ChargeTypeCode", chargeType))
					.add(Restrictions.like("ChargeCodeName", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			chargeList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList", chargeList);
		return map;
	}

	/*
	 * public Map<String, Object> getEmpValue(String empName) {
	 * List<MasEmployee> empList = new ArrayList<MasEmployee>(); Map<String,
	 * Object> map = new HashMap<String, Object>(); Session session = (Session)
	 * getSession(); try {
	 * 
	 * empList = session.createCriteria(MasEmployee.class)
	 * .add(Restrictions.like("FirstName", empName + "%")).list();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } map.put("empList",
	 * empList); return map; }
	 */

	public Map<String, Object> getSurgeonForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			String empCategory = "01";
			Criteria crit = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "ec")
					.add(Restrictions.eq("ec.EmpCategoryCode", empCategory))
					.add(Restrictions.like("FirstName", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			empList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	public Map<String, Object> getItemForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {

			String str = "%" + mapForDS.get("autoHint") + "%";

			Criteria crit = session.createCriteria(MasStoreItem.class).add(
					Restrictions.like("Nomenclature", str));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			itemList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	public Map<String, Object> getItemValue(String nomenclature) {
		List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			storeItemList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("Nomenclature", nomenclature)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeItemList", storeItemList);
		return map;
	}

	public boolean submitOtPostAnesthesiaProcedure(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List pvmsNoPrList = (List) mapForDS.get("pvmsNoPrList");
		List pvmsNoProList = (List) mapForDS.get("pvmsNoProList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> empNameList = (List) mapForDS.get("empNameList");
		List<String> empNameSList = (List) mapForDS.get("empNameSList");
		List<String> agePrList = (List) mapForDS.get("agePrList");
		List<String> catheterList = (List) mapForDS.get("catheterList");
		List<String> anesthesiaList = (List) mapForDS.get("anesthesiaList");
		List<String> levelList = (List) mapForDS.get("levelList");
		List<Integer> volumeList = (List) mapForDS.get("volumeList");
		List<String> chargeCodeList = (List) mapForDS.get("chargeCodeList");
		List<String> typeList = (List) mapForDS.get("typeList");
		List<String> routeList = (List) mapForDS.get("routeList");
		List<String> fluidNameList = (List) mapForDS.get("fluidNameList");
		List<String> premedicateTimeList = new ArrayList<String>();
		premedicateTimeList = (List) mapForDS.get("premedicateTimeList");
		int otBookingId = 0;
		if (mapForDS.get("otBookingId") != null) {
			otBookingId = (Integer) mapForDS.get("otBookingId");
		}
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		// int visitId=(Integer)mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		int anesthesia_id = (Integer) mapForDS.get("anesthesia_id");

		String dateOfP = (String) mapForDS.get("dateOfPost");
		Date dateOfPost = HMSUtil.convertStringTypeDateToDateType(dateOfP);
		String patientStatus = (String) mapForDS.get("patientStatus");
		String ett_lma = (String) mapForDS.get("ett_lma");
		int ett_lma_text = (Integer) mapForDS.get("ett_lma_text");
		String ecg = (String) mapForDS.get("ecg");
		String nibp = (String) mapForDS.get("nibp");
		String cvp = (String) mapForDS.get("cvp");
		String temp = (String) mapForDS.get("temp");
		String sp02 = (String) mapForDS.get("sp02");
		String labp = (String) mapForDS.get("labp");
		String anaesthesia_from_time = (String) mapForDS
				.get("anaesthesia_from_time");
		String anaesthesia_to_time = (String) mapForDS
				.get("anaesthesia_to_time");
		String yearlySlNo = (String) mapForDS.get("yearlySlNo");
		String monthlySlNo = (String) mapForDS.get("monthlySlNo");
		String surgey_from_time = (String) mapForDS.get("surgey_from_time");
		String surgey_to_time = (String) mapForDS.get("surgey_to_time");
		String uo = (String) mapForDS.get("uo");
		int neostigmine = (Integer) mapForDS.get("neostigmine");
		Integer glycophyrrolate = (Integer) mapForDS.get("glycophyrrolate");
		Integer others = (Integer) mapForDS.get("others");
		String recovery = (String) mapForDS.get("recovery");
		String risk_grade = (String) mapForDS.get("risk_grade");
		String e_others = (String) mapForDS.get("e_others");
		String levelOfAnesthesia = (String) mapForDS.get("levelOfAnesthesia");
		int height = 0;
		int weight = 0;
		String bmi = "";
		String bmiStatus = "";
		String pulse = "";
		String bp = "";
		String resp = "";
		String reamarksForDisschargeVitals = "";
		if (mapForDS.get("reamarksForDisschargeVitals") != null) {
			reamarksForDisschargeVitals = (String) mapForDS
					.get("reamarksForDisschargeVitals");
		}

		if (mapForDS.get("height") != null) {
			height = (Integer) mapForDS.get("height");
		}
		if (mapForDS.get("weight") != null) {
			weight = (Integer) mapForDS.get("weight");
		}
		if (mapForDS.get("bmi") != null) {
			bmi = (String) mapForDS.get("bmi");
		}
		if (mapForDS.get("bmiStatus") != null) {
			bmiStatus = (String) mapForDS.get("bmiStatus");
		}
		if (mapForDS.get("pulse") != null) {
			pulse = (String) mapForDS.get("pulse");
		}
		if (mapForDS.get("bp") != null) {
			bp = (String) mapForDS.get("bp");
		}
		if (mapForDS.get("resp") != null) {
			resp = (String) mapForDS.get("resp");
		}
		String remarks = (String) mapForDS.get("remarks");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> itemId2List = new ArrayList<Integer>();
		List<Integer> itemId3List = new ArrayList<Integer>();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtPostAnaesthesiaProcedure opdPatientDetails = new OtPostAnaesthesiaProcedure();
			/*
			 * Visit visitObj= new Visit(); visitObj.setId(visitId);
			 * opdPatientDetails.setVisit(visitObj);
			 */

			/*
			 * if(visitId!=0) { Visit otvisit=new Visit();
			 * otvisit.setId(visitId); opdPatientDetails.setVisit(otvisit); }
			 */

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdPatientDetails.setDepartment(masDepartment);

			Patient patient = new Patient();
			patient.setId(hinId);
			opdPatientDetails.setHin(patient);

			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			opdPatientDetails.setHospital(masHospitalObj);

			opdPatientDetails.setAnaesthesiaFromTime(anaesthesia_from_time);
			opdPatientDetails.setAnaesthesiaToTime(anaesthesia_to_time);
			opdPatientDetails.setCvp(cvp);
			opdPatientDetails.setEcg(ecg);
			opdPatientDetails.setEOthers(e_others);
			opdPatientDetails.setLevelOfAnesthesia(levelOfAnesthesia);
			opdPatientDetails.setHeight(height);
			opdPatientDetails.setWeight(weight);
			opdPatientDetails.setBmi(bmi);
			opdPatientDetails.setBp(bp);
			opdPatientDetails.setPulse(pulse);
			opdPatientDetails.setRespiratory(resp);
			opdPatientDetails.setBmiStatus(bmiStatus);
			System.out.println("" + height + "-----" + weight + "========="
					+ bmi + "-------->" + bmiStatus);
			opdPatientDetails.setEttLma(ett_lma);
			Users users = new Users();
			users.setId(userId);
			opdPatientDetails.setLastChgBy(users);
			opdPatientDetails.setLastChgDate(date);
			opdPatientDetails.setLastChgTime(time);

			opdPatientDetails.setEttLmaText(ett_lma_text);

			opdPatientDetails.setDateOfPost(dateOfPost);

			opdPatientDetails.setGlycophyrrolate(glycophyrrolate);
			opdPatientDetails.setIabp(labp);
			opdPatientDetails.setMonthlyslno(monthlySlNo);
			opdPatientDetails.setNeostigmine(neostigmine);
			opdPatientDetails.setNibp(nibp);
			opdPatientDetails.setOthers(others);
			opdPatientDetails.setRecovery(recovery);
			opdPatientDetails.setRemarks(remarks);
			opdPatientDetails.setRiskGrade(risk_grade);
			opdPatientDetails.setSp02(sp02);
			opdPatientDetails.setSurgeyFromTime(surgey_from_time);
			opdPatientDetails.setSurgeyToTime(surgey_to_time);
			opdPatientDetails.setTemp(temp);
			opdPatientDetails.setUo(uo);
			opdPatientDetails.setYearlyslno(yearlySlNo);
			opdPatientDetails
					.setReamrksForDischargevital(reamarksForDisschargeVitals);

			if (patientStatus.equalsIgnoreCase("In Patient")) {
				int inpatientId = (Integer) mapForDS.get("inpatientId");
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				opdPatientDetails.setInPatient(inpatient);
			}

			if (patientStatus.equalsIgnoreCase("Out Patient")
					|| patientStatus.equalsIgnoreCase("OP")) {
				int visitId = 0;

				if (mapForDS.get("VisitId") != null) {
					visitId = (Integer) mapForDS.get("VisitId");
				}
				Visit visit = new Visit();
				visit.setId(visitId);
				opdPatientDetails.setVisit(visit);
			}

			if (anesthesia_id != 0) {
				MasAnesthesia masAnesthesia = new MasAnesthesia();
				masAnesthesia.setId(anesthesia_id);
				opdPatientDetails.setAnesthesia(masAnesthesia);
			}
			if (anesthesia_id != 0) {
				MasAnesthesia masAnesthesia = new MasAnesthesia();
				masAnesthesia.setId(anesthesia_id);
				opdPatientDetails.setAnesthesia(masAnesthesia);
			}

			hbt.save(opdPatientDetails);
			hbt.refresh(opdPatientDetails);

			// -----------------------------------------------------------------------------------

			// --------------values to be IvFluids----------------------

			if (pvmsNoList.size() > 0) {

				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					itemIdList.add(itemId);
				}
				for (int i = 0; i < itemIdList.size(); i++) {
					OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail = new OtSurgeyPaIvFluidsDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemIdList.get(i));
					surgeyPaIvFluidsDetail.setItem(masStoreItem);

					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailVolume(volumeList.get(i));
					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailFluidsName(fluidNameList
									.get(i));

					surgeyPaIvFluidsDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaIvFluidsDetail);
				}
			}

			// ----------value for Premedication------
			if (pvmsNoPrList.size() > 0) {

				for (int i = 0; i < pvmsNoPrList.size(); i++) {
					String pvmsNoPr = (String) pvmsNoPrList.get(i);
					int item2Id = getItemIdFromPVMS2(pvmsNoPr);
					itemId2List.add(item2Id);
				}
				for (int i = 0; i < itemId2List.size(); i++) {
					OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail = new OtSurgeyPaPremedicationDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId2List.get(i));
					surgeyPaPremedicationDetail.setItem(masStoreItem);
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailDosa(agePrList
									.get(i));
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailRoute(routeList
									.get(i));

					try {
						surgeyPaPremedicationDetail
								.setSurgeyPaPremedicationDetailType(typeList
										.get(i));
					} catch (Exception e) {
						e.printStackTrace();
					}

					surgeyPaPremedicationDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					if (premedicateTimeList.get(i) != null
							&& !premedicateTimeList.get(i).equals(""))
						surgeyPaPremedicationDetail
								.setPreMedicationTime(premedicateTimeList
										.get(i));
					hbt.save(surgeyPaPremedicationDetail);
				}
			}
			// ----------data for Procedure------
			/*
			 * if (pvmsNoProList.size() > 0) {
			 * 
			 * for (int i = 0; i < pvmsNoProList.size(); i++) { String pvmsNoPro
			 * = (String) pvmsNoProList.get(i); int item3Id =
			 * getItemIdFromPVMS3(pvmsNoPro); itemId3List.add(item3Id); } for
			 * (int i = 0; i < itemId3List.size(); i++) {
			 * OtSurgeyPaProcedureDetail surgeyPaProcedureDetail = new
			 * OtSurgeyPaProcedureDetail(); MasStoreItem masStoreItem = new
			 * MasStoreItem(); masStoreItem.setId(itemId3List.get(i));
			 * surgeyPaProcedureDetail.setItem(masStoreItem);
			 * 
			 * surgeyPaProcedureDetail
			 * .setSurgeyPaProcedureDetailAnesthesia(anesthesiaList .get(i));
			 * surgeyPaProcedureDetail
			 * .setSurgeyPaProcedureDetailCatheter(catheterList .get(i));
			 * surgeyPaProcedureDetail
			 * .setSurgeyPaProcedureDetailLevel(levelList.get(i));
			 * surgeyPaProcedureDetail
			 * .setSurgeyPaProcedureDetailDosa(dosageList.get(i));
			 * 
			 * surgeyPaProcedureDetail
			 * .setOtPostAnaesthesiaProcedure(opdPatientDetails);
			 * 
			 * hbt.save(surgeyPaProcedureDetail); } }
			 */

			// ----------data for Anesthesiologist------

			if (empNameList.size() > 0) {
				for (int i = 0; i < empNameList.size(); i++) {
					OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail = new OtSurgeyPaAnesthesiologistDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameList.get(i)));
					surgeyPaAnesthesiologistDetail.setEmployee(masEmployee);

					surgeyPaAnesthesiologistDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaAnesthesiologistDetail);
				}
			}

			// ----------data for Sergon------

			if (empNameSList.size() > 0) {
				for (int i = 0; i < empNameSList.size(); i++) {
					OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail = new OtSurgeyPaEmployeeDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameSList.get(i)));
					surgeyPaEmployeeDetail.setEmployee(masEmployee);

					surgeyPaEmployeeDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaEmployeeDetail);
				}

			}
			// ----------data for chargeCodeIdList------

			if (chargeCodeList.size() > 0) {
				for (int i = 0; i < chargeCodeList.size(); i++) {
					OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail = new OtSurgeyPaSurgeyDetail();
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode
							.setId(Integer.parseInt(chargeCodeList.get(i)));
					surgeyPaSurgeyDetail.setChargeCode(masChargeCode);
					surgeyPaSurgeyDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaSurgeyDetail);
				}

			}

			if (otBookingId != 0) {
				OtBooking otBooking = (OtBooking) hbt.load(OtBooking.class,
						otBookingId);
				otBooking.setOtPostAnethesiaStatus("y");
				hbt.update(otBooking);
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForAutoComplete(
			Map<String, Object> mapForDS) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			String str = "%" + mapForDS.get("autoHint") + "%";
			String query = "from MasStoreItem as mst where mst.Nomenclature like '"
					+ str + "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			String str = map.get("autoHint") + "%";
			String query = "";

			query = "SELECT DISTINCT(sib.Nomenclature),sib.PvmsNo from MasStoreItem as sib where sib.Nomenclature like '"
					+ str + "'";

			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				Object[] pair = (Object[]) itr.next();
				@SuppressWarnings("unused")
				String nomenclature = (String) pair[0];

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public int getItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int itemId = 0;
		try {
			itemIdList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo)).list();
			MasStoreItem masStoreItem = itemIdList.get(0);
			itemId = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return itemId;
	}
	
	public List<MasStoreItem> getIpItemIdFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			itemIdList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemIdList;
	}

	public int getItemIdFromPVMS2(String pvmsNo2) {
		List<MasStoreItem> itemId2List = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int item2Id = 0;
		try {
			itemId2List = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo2)).list();
			MasStoreItem masStoreItem = itemId2List.get(0);
			item2Id = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item2Id;
	}

	public int getItemIdFromPVMS3(String pvmsNo3) {
		List<MasStoreItem> itemId3List = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		int item3Id = 0;
		try {
			itemId3List = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo3)).list();

			MasStoreItem masStoreItem = itemId3List.get(0);
			item3Id = masStoreItem.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item3Id;
	}

	public Map<String, Object> showOtPostAnesthesiaProcedure(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
		List<OtSurgeyPaEmployeeDetail> surgeyPaEmployeeDetailList = new ArrayList<OtSurgeyPaEmployeeDetail>();
		List<OtSurgeyPaSurgeyDetail> surgeyPaSurgeyDetailList = new ArrayList<OtSurgeyPaSurgeyDetail>();
		List<OtSurgeyPaAnesthesiologistDetail> surgeyPaAnesthesiologistDetailList = new ArrayList<OtSurgeyPaAnesthesiologistDetail>();
		List<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailList = new ArrayList<OtSurgeyPaIvFluidsDetail>();
		List<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailList = new ArrayList<OtSurgeyPaPremedicationDetail>();
		List<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailList = new ArrayList<OtSurgeyPaProcedureDetail>();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();

		String serviceNo = "";
		String hinNo = "";
		String visitNo = "";
		int otPostId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("visitNo") != null) {
			visitNo = (String) mapForDS.get("visitNo");

		}
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo));
			patientDetailList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);

		Criteria crit = session
				.createCriteria(OtPostAnaesthesiaProcedure.class).createAlias(
						"Hin", "hin");
		if (!hinNo.equals("")) {
			if (visitNo != "") {

				crit = crit.add(Restrictions.eq("YearlySlNo", visitNo));

			}
			if (!serviceNo.equals("")) {

				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		otPostAnaesthesiaProcedureList = crit.list();

		for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
				.hasNext();) {
			OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
					.next();

			otPostId = otPostAnaesthesiaProcedure.getId();
		}

		if (otPostId != 0) {
			surgeyPaEmployeeDetailList = session
					.createCriteria(OtSurgeyPaEmployeeDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaSurgeyDetailList = session
					.createCriteria(OtSurgeyPaSurgeyDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaAnesthesiologistDetailList = session
					.createCriteria(OtSurgeyPaAnesthesiologistDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaIvFluidsDetailList = session
					.createCriteria(OtSurgeyPaIvFluidsDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaPremedicationDetailList = session
					.createCriteria(OtSurgeyPaPremedicationDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			surgeyPaProcedureDetailList = session
					.createCriteria(OtSurgeyPaProcedureDetail.class)
					.createAlias("OtPostAnaesthesiaProcedure", "otPost")
					.add(Restrictions.eq("otPost.Id", otPostId)).list();
			anesthesiaList = session.createCriteria(MasAnesthesia.class)
					.add(Restrictions.eq("Status", "y")).list();

			map.put("surgeyPaEmployeeDetailList", surgeyPaEmployeeDetailList);
			map.put("surgeyPaSurgeyDetailList", surgeyPaSurgeyDetailList);
			map.put("surgeyPaAnesthesiologistDetailList",
					surgeyPaAnesthesiologistDetailList);
			map.put("surgeyPaIvFluidsDetailList", surgeyPaIvFluidsDetailList);
			map.put("surgeyPaPremedicationDetailList",
					surgeyPaPremedicationDetailList);
			map.put("surgeyPaProcedureDetailList", surgeyPaProcedureDetailList);
			map.put("anesthesiaList", anesthesiaList);

		}
		map.put("otPostAnaesthesiaProcedureList",
				otPostAnaesthesiaProcedureList);

		return map;

	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {

			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getVisitNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		int hospitalId = (Integer) detailsMap.get(HOSPITAL_ID);
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> vistList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPostAnaesthesiaProcedure.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				vistList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtPostAnaesthesiaProcedure.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("p.HinNo", hinNo));
				vistList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vistList;

	}

	public String getEntryNoForDisplay() {
		String entryNo = "";
		int entrySeqNo = 0;
		List<TransactionSequence> seqNoList = new ArrayList<TransactionSequence>();
		String tableName = "";
		String prefix = "";
		String seqNoName = "";

		tableName = "OtSpecimenDispatchEntry";
		prefix = "SENO";
		seqNoName = "Specimen Entry No";

		Session session = (Session) getSession();
		try {
			seqNoList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", prefix)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (seqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : seqNoList) {
				int id = transactionSequence.getId();
				int seqNo = transactionSequence.getTransactionSequenceNumber();
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				entrySeqNo = ++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(entrySeqNo);
				hbt.update(transactionSequenceObj);
			}
		} else if (seqNoList.size() == 0) {
			entrySeqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename(tableName);
			tsObj.setTransactionPrefix(prefix);
			tsObj.setTransactionSequenceName(seqNoName);
			tsObj.setTransactionSequenceNumber(entrySeqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);
		}

		entryNo = String.valueOf(entrySeqNo);
		return entryNo;
	}

	public Map<String, Object> searchSpecimenDispatchEntryPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		String serviceNo = "";
		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

		Session session = (Session) getSession();

		/*
		 * if (mapForDS.get("serviceNo") != null) { serviceNo = (String)
		 * mapForDS.get("serviceNo"); }
		 */
		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		Criteria crit = session.createCriteria(OtBooking.class).createAlias(
				"Hin", "hin");
		crit.add(Restrictions.eq("Hospital.Id", hospitalId));
		if (hinNo != null) {
			/*
			 * if (!serviceNo.equals("")) { crit =
			 * crit.add(Restrictions.eq("hin.ServiceNo", serviceNo)); }
			 */
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("hin.PFirstName", patientFName
					+ "%"));
		}
		if (!patientMName.equals("")) {
			crit = crit.add(Restrictions.like("hin.PMiddleName", patientMName
					+ "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions.like("hin.PLastName", patientLName
					+ "%"));
		}
		/*
		 * else { crit = crit.add(Restrictions.eq("hin.HinNo", hinNo)); }
		 */
		patientList = crit.list();
		map.put("patientList", patientList);
		return map;

	}

	public Map<String, Object> showSpecimenDispatchEntryJspForHin(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empByList = new ArrayList<MasEmployee>();
		List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
		List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
		// List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Map<String, Object> map = new HashMap<String, Object>();
		// String hinNo = (String) mapForDS.get("hinNo");
		// int hinId = (Integer) mapForDS.get("hinId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int bookingId = (Integer) mapForDS.get("bookingId");

		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("Id", bookingId));
			patientDetailList = crit.list();
			empByList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			empRevList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			crit = session.createCriteria(OtSpecimenDispatchEntry.class).add(
					Restrictions.eq("Hin.Id", patientDetailList.get(0).getHin()
							.getId()));
			otSpecimenDispatchEntryList = crit.list();
			if (otSpecimenDispatchEntryList.size() > 0) {
				map.put("otSpecimenDispatchEntryList",
						otSpecimenDispatchEntryList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("empByList", empByList);
		map.put("empRevList", empRevList);

		return map;

	}

	public boolean submitOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int userId = (Integer) mapForDS.get(USER_ID);
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int empBy = (Integer) mapForDS.get("empBy");
		int empRev = (Integer) mapForDS.get("empRev");

		String tissueOrgan = (String) mapForDS.get("tissueOrgan");
		String clinicalNotes = (String) mapForDS.get("clinicalNotes");
		String examinationRequired = (String) mapForDS
				.get("examinationRequired");
		String timeOfDispatch = (String) mapForDS.get("timeOfDispatch");
		String entryNo = (String) mapForDS.get("entryNo");

		String dateOfD = (String) mapForDS.get("dateOfDispatch");
		Date dateOfDispatch = null;
		if (dateOfD != null && !dateOfD.equals("")) {
			dateOfDispatch = HMSUtil.convertStringTypeDateToDateType(dateOfD);
		} else {
			dateOfDispatch = new Date();
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtSpecimenDispatchEntry otSpecimenDispatchEntry = new OtSpecimenDispatchEntry();
			if (visitId != 0) {
				Visit visitObj = new Visit();
				visitObj.setId(visitId);
				otSpecimenDispatchEntry.setVisit(visitObj);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				otSpecimenDispatchEntry.setDepartment(masDepartment);
			}
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				otSpecimenDispatchEntry.setHin(patient);
			}
			if (hospitalId != 0) {
				MasHospital masHospitalObj = new MasHospital();
				masHospitalObj.setId(hospitalId);
				otSpecimenDispatchEntry.setHospital(masHospitalObj);
			}

			otSpecimenDispatchEntry.setClinicalNotes(clinicalNotes);
			otSpecimenDispatchEntry.setExaminationRequired(examinationRequired);
			otSpecimenDispatchEntry.setTimeOfDispatch(timeOfDispatch);
			otSpecimenDispatchEntry.setTissueOrgan(tissueOrgan);
			Users users = new Users();
			users.setId(userId);
			otSpecimenDispatchEntry.setLastChgBy(users);
			otSpecimenDispatchEntry.setLastChgDate(date);
			otSpecimenDispatchEntry.setLastChgTime(time);
			otSpecimenDispatchEntry.setStatus("y");
			otSpecimenDispatchEntry.setEntryNo(entryNo);
			otSpecimenDispatchEntry
					.setOtSpecimenDispatchEntryDate(dateOfDispatch);

			if (empBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empBy);
				otSpecimenDispatchEntry.setSpecimenDispatchedBy(masEmployee);
			}

			if (empRev != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empRev);
				otSpecimenDispatchEntry.setSpecimenReceivedBy(masEmployee);
			}

			hbt.save(otSpecimenDispatchEntry);
			hbt.refresh(otSpecimenDispatchEntry);

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEntryHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {

			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getEntryNoList(Map<String, Object> detailsMap) {
		@SuppressWarnings("unchecked")
		Session session = (Session) getSession();
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> vistList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtSpecimenDispatchEntry.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.ServiceNo", serviceNo));
				vistList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.ServiceNo = '"+serviceNo+"'");
			}
			if (!hinNo.equals("")) {
				Criteria crit = session
						.createCriteria(OtSpecimenDispatchEntry.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", hinNo));
				vistList = crit.list();
				// vistList = getHibernateTemplate().find("from Visit v join
				// v.Hin as p where p.HinNo = '"+hinNo+"'");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return vistList;

	}

	public Map<String, Object> showOtSpecimenDispatchEntry(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasEmployee> empByList = new ArrayList<MasEmployee>();
		List<MasEmployee> empRevList = new ArrayList<MasEmployee>();

		String serviceNo = "";
		String hinNo = "";
		String visitNo = "";
		int otPostId = 0;
		Session session = (Session) getSession();

		if (mapForDS.get("serviceNo") != null) {
			serviceNo = (String) mapForDS.get("serviceNo");
		}
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get("visitNo") != null) {
			visitNo = (String) mapForDS.get("visitNo");

		}
		try {

			Criteria crit = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.HinNo", hinNo));
			patientDetailList = crit.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);

		Criteria crit = session.createCriteria(OtSpecimenDispatchEntry.class)
				.createAlias("Hin", "hin");
		if (!hinNo.equals("")) {
			if (visitNo != "") {

				crit = crit.add(Restrictions.eq("EntryNo", visitNo));

			}
			if (!serviceNo.equals("")) {

				crit = crit.add(Restrictions.eq("hin.ServiceNo", serviceNo));
			}

		} else {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		otSpecimenDispatchEntryList = crit.list();
		empByList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		empRevList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();

		map.put("otSpecimenDispatchEntryList", otSpecimenDispatchEntryList);
		map.put("empByList", empByList);
		map.put("empRevList", empRevList);
		return map;

	}

	public boolean updateOtSpecimenDispatchEntry(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;

		int userId = (Integer) mapForDS.get(USER_ID);
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		int visitId = (Integer) mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int empBy = (Integer) mapForDS.get("empBy");
		int empRev = (Integer) mapForDS.get("empRev");
		int specimenId = (Integer) mapForDS.get("specimenId");
		String tissueOrgan = (String) mapForDS.get("tissueOrgan");
		String clinicalNotes = (String) mapForDS.get("clinicalNotes");
		String examinationRequired = (String) mapForDS
				.get("examinationRequired");
		String timeOfDispatch = (String) mapForDS.get("timeOfDispatch");
		String entryNo = (String) mapForDS.get("entryNo");

		String dateOfD = (String) mapForDS.get("dateOfDispatch");
		Date dateOfDispatch = HMSUtil.convertStringTypeDateToDateType(dateOfD);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			OtSpecimenDispatchEntry otSpecimenDispatchEntry = (OtSpecimenDispatchEntry) getHibernateTemplate()
					.get(OtSpecimenDispatchEntry.class, specimenId);

			otSpecimenDispatchEntry.setId(specimenId);

			Visit visitObj = new Visit();
			visitObj.setId(visitId);
			otSpecimenDispatchEntry.setVisit(visitObj);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			otSpecimenDispatchEntry.setDepartment(masDepartment);

			Patient patient = new Patient();
			patient.setId(hinId);
			otSpecimenDispatchEntry.setHin(patient);

			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			otSpecimenDispatchEntry.setHospital(masHospitalObj);

			otSpecimenDispatchEntry.setClinicalNotes(clinicalNotes);
			otSpecimenDispatchEntry.setExaminationRequired(examinationRequired);
			otSpecimenDispatchEntry.setTimeOfDispatch(timeOfDispatch);
			otSpecimenDispatchEntry.setTissueOrgan(tissueOrgan);
			Users users = new Users();
			users.setId(userId);
			otSpecimenDispatchEntry.setLastChgBy(users);
			otSpecimenDispatchEntry.setLastChgDate(date);
			otSpecimenDispatchEntry.setLastChgTime(time);
			otSpecimenDispatchEntry.setStatus("y");
			otSpecimenDispatchEntry.setEntryNo(entryNo);
			otSpecimenDispatchEntry
					.setOtSpecimenDispatchEntryDate(dateOfDispatch);

			if (empBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empBy);
				otSpecimenDispatchEntry.setSpecimenDispatchedBy(masEmployee);
			}

			if (empRev != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(empRev);
				otSpecimenDispatchEntry.setSpecimenReceivedBy(masEmployee);
			}
			hbt.saveOrUpdate(otSpecimenDispatchEntry);
			hbt.refresh(otSpecimenDispatchEntry);

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	/**
	 * --------------------- Connection for DB ----------------------
	 */
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	public Map<String, Object> showPACDetailInJsp(int orderNo, int hinId,
			int inpatientId) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaDetails> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			otPreAnesthesiaDetailsList = session
					.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			opdPatientHistoryList = session
					.createCriteria(OpdPatientHistory.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		return map;
	}

	public boolean updateOtPostAnesthesiaProcedure(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		List pvmsNoList = (List) mapForDS.get("pvmsNoList");
		List pvmsNoPrList = (List) mapForDS.get("pvmsNoPrList");
		List pvmsNoProList = (List) mapForDS.get("pvmsNoProList");
		List<String> dosageList = (List) mapForDS.get("dosageList");
		List<String> empNameList = (List) mapForDS.get("empNameList");
		List<String> empNameSList = (List) mapForDS.get("empNameSList");
		List<String> agePrList = (List) mapForDS.get("agePrList");
		List<String> catheterList = (List) mapForDS.get("catheterList");
		List<String> anesthesiaList = (List) mapForDS.get("anesthesiaList");
		List<String> levelList = (List) mapForDS.get("levelList");
		List<Integer> volumeList = (List) mapForDS.get("volumeList");
		List<String> chargeCodeList = (List) mapForDS.get("chargeCodeList");
		List<String> typeList = (List) mapForDS.get("typeList");
		List<String> routeList = (List) mapForDS.get("routeList");
		List<String> fluidNameList = (List) mapForDS.get("fluidNameList");
		int hinId = (Integer) mapForDS.get("hinId");
		int departmentId = (Integer) mapForDS.get("departmentId");
		// int visitId=(Integer)mapForDS.get("visitId");
		int hospitalId = (Integer) mapForDS.get("hospitalId");
		int anesthesia_id = (Integer) mapForDS.get("anesthesia_id");
		int postId = (Integer) mapForDS.get("postId");
		String ett_lma = (String) mapForDS.get("ett_lma");
		int ett_lma_text = (Integer) mapForDS.get("ett_lma_text");
		String ecg = (String) mapForDS.get("ecg");
		String nibp = (String) mapForDS.get("nibp");
		String cvp = (String) mapForDS.get("cvp");
		String temp = (String) mapForDS.get("temp");
		String sp02 = (String) mapForDS.get("sp02");
		String labp = (String) mapForDS.get("labp");
		String anaesthesia_from_time = (String) mapForDS
				.get("anaesthesia_from_time");
		String anaesthesia_to_time = (String) mapForDS
				.get("anaesthesia_to_time");
		String yearlySlNo = (String) mapForDS.get("yearlySlNo");
		String monthlySlNo = (String) mapForDS.get("monthlySlNo");
		String surgey_from_time = (String) mapForDS.get("surgey_from_time");
		String surgey_to_time = (String) mapForDS.get("surgey_to_time");
		String uo = (String) mapForDS.get("uo");
		int neostigmine = (Integer) mapForDS.get("neostigmine");
		Integer glycophyrrolate = (Integer) mapForDS.get("glycophyrrolate");
		Integer others = (Integer) mapForDS.get("others");
		String recovery = (String) mapForDS.get("recovery");
		String risk_grade = (String) mapForDS.get("risk_grade");
		String e_others = (String) mapForDS.get("e_others");
		String remarks = (String) mapForDS.get("remarks");
		String dateOfP = (String) mapForDS.get("dateOfPost");
		Date dateOfPost = HMSUtil.convertStringTypeDateToDateType(dateOfP);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String userName = (String) mapForDS.get("userName");
		int userId = (Integer) mapForDS.get(USER_ID);
		List<Integer> itemIdList = new ArrayList<Integer>();
		List<Integer> itemId2List = new ArrayList<Integer>();
		List<Integer> itemId3List = new ArrayList<Integer>();

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			OtPostAnaesthesiaProcedure opdPatientDetails = (OtPostAnaesthesiaProcedure) getHibernateTemplate()
					.get(OtPostAnaesthesiaProcedure.class, postId);

			opdPatientDetails.setId(postId);

			/*
			 * Visit visitObj= new Visit(); visitObj.setId(visitId);
			 * opdPatientDetails.setVisit(visitObj);
			 */

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			opdPatientDetails.setDepartment(masDepartment);

			Patient patient = new Patient();
			patient.setId(hinId);
			opdPatientDetails.setHin(patient);

			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(hospitalId);
			opdPatientDetails.setHospital(masHospitalObj);

			opdPatientDetails.setAnaesthesiaFromTime(anaesthesia_from_time);
			opdPatientDetails.setAnaesthesiaToTime(anaesthesia_to_time);
			opdPatientDetails.setCvp(cvp);
			opdPatientDetails.setEcg(ecg);
			opdPatientDetails.setEOthers(e_others);
			opdPatientDetails.setEttLma(ett_lma);
			Users users = new Users();
			users.setId(userId);
			opdPatientDetails.setLastChgBy(users);
			opdPatientDetails.setLastChgDate(date);
			opdPatientDetails.setLastChgTime(time);

			opdPatientDetails.setEttLmaText(ett_lma_text);

			opdPatientDetails.setDateOfPost(dateOfPost);

			opdPatientDetails.setGlycophyrrolate(glycophyrrolate);
			opdPatientDetails.setIabp(labp);
			opdPatientDetails.setMonthlyslno(monthlySlNo);
			opdPatientDetails.setNeostigmine(neostigmine);
			opdPatientDetails.setNibp(nibp);
			opdPatientDetails.setOthers(others);
			opdPatientDetails.setRecovery(recovery);
			opdPatientDetails.setRemarks(remarks);
			opdPatientDetails.setRiskGrade(risk_grade);
			opdPatientDetails.setSp02(sp02);
			opdPatientDetails.setSurgeyFromTime(surgey_from_time);
			opdPatientDetails.setSurgeyToTime(surgey_to_time);
			opdPatientDetails.setTemp(temp);
			opdPatientDetails.setUo(uo);
			opdPatientDetails.setYearlyslno(yearlySlNo);

			if (anesthesia_id != 0) {
				MasAnesthesia masAnesthesia = new MasAnesthesia();
				masAnesthesia.setId(anesthesia_id);
				opdPatientDetails.setAnesthesia(masAnesthesia);
			}

			hbt.saveOrUpdate(opdPatientDetails);
			hbt.refresh(opdPatientDetails);

			// -----------------------------------------------------------------------------------

			// --------------values to be IvFluids----------------------

			if (pvmsNoList.size() > 0) {

				for (int i = 0; i < pvmsNoList.size(); i++) {
					String pvmsNo = (String) pvmsNoList.get(i);
					int itemId = getItemIdFromPVMS(pvmsNo);
					itemIdList.add(itemId);
				}
				for (int i = 0; i < itemIdList.size(); i++) {
					OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail = new OtSurgeyPaIvFluidsDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemIdList.get(i));
					surgeyPaIvFluidsDetail.setItem(masStoreItem);

					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailVolume(volumeList.get(i));
					surgeyPaIvFluidsDetail
							.setSurgeyPaIvFluidsDetailFluidsName(fluidNameList
									.get(i));

					surgeyPaIvFluidsDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaIvFluidsDetail);
				}
			}

			// ----------value for Premedication------
			if (pvmsNoPrList.size() > 0) {

				for (int i = 0; i < pvmsNoPrList.size(); i++) {
					String pvmsNoPr = (String) pvmsNoPrList.get(i);
					int item2Id = getItemIdFromPVMS2(pvmsNoPr);
					itemId2List.add(item2Id);
				}
				for (int i = 0; i < itemId2List.size(); i++) {
					OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail = new OtSurgeyPaPremedicationDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId2List.get(i));
					surgeyPaPremedicationDetail.setItem(masStoreItem);
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailDosa(agePrList
									.get(i));
					surgeyPaPremedicationDetail
							.setSurgeyPaPremedicationDetailRoute(routeList
									.get(i));
					try {
						surgeyPaPremedicationDetail
								.setSurgeyPaPremedicationDetailType(typeList
										.get(i));
					} catch (Exception e) {
						e.printStackTrace();
					}

					surgeyPaPremedicationDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);

					hbt.save(surgeyPaPremedicationDetail);
				}
			}
			// ----------data for Procedure------
			if (pvmsNoProList.size() > 0) {

				for (int i = 0; i < pvmsNoProList.size(); i++) {
					String pvmsNoPro = (String) pvmsNoProList.get(i);
					int item3Id = getItemIdFromPVMS3(pvmsNoPro);
					itemId3List.add(item3Id);
				}
				for (int i = 0; i < itemId3List.size(); i++) {
					OtSurgeyPaProcedureDetail surgeyPaProcedureDetail = new OtSurgeyPaProcedureDetail();
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId(itemId3List.get(i));
					surgeyPaProcedureDetail.setItem(masStoreItem);

					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailAnesthesia(anesthesiaList
									.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailCatheter(catheterList
									.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailLevel(levelList.get(i));
					surgeyPaProcedureDetail
							.setSurgeyPaProcedureDetailDosa(dosageList.get(i));

					surgeyPaProcedureDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);

					hbt.save(surgeyPaProcedureDetail);
				}
			}

			// ----------data for Anesthesiologist------

			if (empNameList.size() > 0) {
				for (int i = 0; i < empNameList.size(); i++) {
					OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail = new OtSurgeyPaAnesthesiologistDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameList.get(i)));
					surgeyPaAnesthesiologistDetail.setEmployee(masEmployee);

					surgeyPaAnesthesiologistDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaAnesthesiologistDetail);
				}
			}

			// ----------data for Sergon------

			if (empNameSList.size() > 0) {
				for (int i = 0; i < empNameSList.size(); i++) {
					OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail = new OtSurgeyPaEmployeeDetail();
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(Integer.parseInt(empNameSList.get(i)));
					surgeyPaEmployeeDetail.setEmployee(masEmployee);

					surgeyPaEmployeeDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaEmployeeDetail);
				}

			}
			// ----------data for chargeCodeIdList------

			if (chargeCodeList.size() > 0) {
				for (int i = 0; i < chargeCodeList.size(); i++) {
					OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail = new OtSurgeyPaSurgeyDetail();
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode
							.setId(Integer.parseInt(chargeCodeList.get(i)));
					surgeyPaSurgeyDetail.setChargeCode(masChargeCode);
					surgeyPaSurgeyDetail
							.setOtPostAnaesthesiaProcedure(opdPatientDetails);
					hbt.save(surgeyPaSurgeyDetail);
				}

			}

			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			// --------Session Closing----------
			session.close();
		}

		return succesfullyAdded;
	}

	public Map<String, Object> printPAC(int hinId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		try {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("AdStatus", "A"))
					.add(Restrictions.eq("p.Id", hinId)).list();

			if (inpatientList.size() > 0) {
				returnMap.put("PatientStatus", "inpatient");

			} else {
				returnMap.put("PatientStatus", "outpatient");
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}

	@Override
	public Map<String, Object> getInvestigationListForRequestionForIP(
			Map<String, Object> mapForDS) {
		List<OtMasChargeDetails> chargeList = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			Criteria crit;
			String str = mapForDS.get("autoHint") + "%";
			crit = session
					.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.like("chargeCode.ChargeCodeName",
							str.toLowerCase()).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase());
			crit.setFirstResult(0);
			crit.setMaxResults(10);
			chargeList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList", chargeList);
		return map;
	}

	@Override
	public Map<String, Object> showPACDetailHnJsp(int orderNo, int hinId) {
		Session session = (Session) getSession();
		List<OtPreAnesthesiaDetails> otPreAnesthesiaDetailsList = new ArrayList<OtPreAnesthesiaDetails>();
		List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			otPreAnesthesiaDetailsList = session
					.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			opdPatientHistoryList = session
					.createCriteria(OpdPatientHistory.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("opdPatientHistoryList", opdPatientHistoryList);
		map.put("otPreAnesthesiaDetailsList", otPreAnesthesiaDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> getEmpValue(Map<String, Object> mapForDS) {

		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		int empId = 0;
		if (mapForDS.get("empId") != null) {
			empId = (Integer) mapForDS.get("empId");
		}
		try {

			empList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Id", empId)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("empList", empList);
		return map;
	}

	@Override
	public Map<String, Object> searchPreOperativeCheckList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		Session session = (Session) getSession();

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		if (mapForDS.get("otProcedure") != null) {
			otProcedure = (String) mapForDS.get("otProcedure");
		}

		if (otProcedure != null
				&& !otProcedure.equals("")
				&& (otProcedure.equalsIgnoreCase("yes") || otProcedure
						.equalsIgnoreCase("no"))) {
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			Criteria crit = session
					.createCriteria(OtBooking.class)
					.createAlias("Hin", "h")
					.add(Restrictions.eq("Hospital.Id",
							(Integer) mapForDS.get(HOSPITAL_ID)))
					.createAlias("Inpatient", "ip",
							CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.or(Restrictions.isNotNull("Visit"),
							Restrictions.in("ip.AdStatus", aList)))
					/* .add(Restrictions.ne("SurgeryStatus", "c").ignoreCase()) */
					.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
					/*
					 * createAlias("Inpatient", "ip") //commented by amit das on
					 * 21-09-2016 .add(Restrictions.in("ip.AdStatus", aList))
					 */
					.createAlias("OpdSurseryHeader", "osh")
					.add(Restrictions.eq("osh.PacStatus", "cleared")
							.ignoreCase()).createAlias("ChargeCode", "charge")
					.add(Restrictions.ne("charge.ChargeType.Id", typeId));// Added
																			// by
																			// Arbind
																			// on
																			// 18-07-2017
			if (otProcedure.equalsIgnoreCase("yes")) {
				crit.add(Restrictions.eq("PreOperativeStatus", "y")
						.ignoreCase());
				crit.add(Restrictions.or(Restrictions
						.isNull("IntraOperativeStatus"),
						Restrictions.eq("IntraOperativeStatus", "n")
								.ignoreCase()));
			} else if (otProcedure.equalsIgnoreCase("no")) {
				crit.add(Restrictions.or(Restrictions
						.isNull("PreOperativeStatus"),
						Restrictions.eq("PreOperativeStatus", "n").ignoreCase()));
			}

			if (!uhid.equals("")) {
				crit.add(Restrictions.eq("h.HinNo", uhid.toLowerCase())
						.ignoreCase());
			}
			if (!pName.equals("")) {
				crit.add(Restrictions.like("h.PFirstName",
						pName.toLowerCase() + "%").ignoreCase());
			}
			if (!ipNo.equals("")) {

				crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
						.ignoreCase());
			}
			if (gender != 0) {
				crit.createAlias("h.Sex", "s");
				crit.add(Restrictions.eq("s.Id", gender));
			}
			patientList = crit.list();
		}

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);

		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> searchOtPatientConsentDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		String hinNo = "";

		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		Criteria crit = session.createCriteria(OtPreAnesthesiaDetails.class)
				.add(Restrictions.eq("ConsentStatus", "n").ignoreCase())
				// .add(Restrictions.eq("SurgeryStatus", "n"))
				.createAlias("Hin", "p");

		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("p.PFirstName", patientFName
					+ "%"));
		}
		if (!patientMName.equals("")) {
			crit = crit.add(Restrictions.like("p.PMiddleName", patientMName
					+ "%"));
		}
		if (!patientLName.equals("")) {
			crit = crit.add(Restrictions
					.like("p.PLastName", patientLName + "%"));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		}
		crit = crit.add(Restrictions.eq("Hospital.Id",
				(Integer) mapForDS.get(HOSPITAL_ID)));
		patientList = crit.addOrder(Order.asc("Id")).list();
		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> showConsentEntryJsp(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		patientDetailList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo.trim())).list();
		try {
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		return map;

	}

	@Override
	public Map<String, Object> submitConsentForOt(OtConsent otConsent, Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(otConsent);
		successfullyAdded = true;
		String save = "save";
		if (successfullyAdded) {
			map.put("save", save);
		}
		List<OtPreAnesthesiaDetails> otDetails = new ArrayList<OtPreAnesthesiaDetails>();
		otDetails = session.createCriteria(OtPreAnesthesiaDetails.class)
				.add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
				.add(Restrictions.eq("ConsentStatus", "n")).list();
		for (OtPreAnesthesiaDetails otd : otDetails) {
			otd.setConsentStatus("y");
			otd.setPreOperativeStatus("n");
			hbt.update(otd);
		}
		return map;
	}

	@Override
	public Map<String, Object> getHospitalName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		String hospitalName = "";
		String address = "";
		hospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Id", hospitalId)).list();

		for (MasHospital masStoreItem : hospitalList) {
			hospitalName = masStoreItem.getHospitalName();
			address = masStoreItem.getAddress();
		}
		map.put("hospitalName", hospitalName);
		map.put("address", address);
		return map;
	}

	@Override
	public Map<String, Object> showPreOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * String hinNo = ""; if (mapForDS.get("hinNo") != null) { hinNo =
		 * (String) mapForDS.get("hinNo"); }
		 */

		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		patientDetailList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", bookingId)).list();
		bloodGroupList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		try {
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		map.put("bloodGroupList", bloodGroupList);
		return map;

	}

	@Override
	public Map<String, Object> submitPreOTCheckList(
			OtPreOperativeCheckList otConsent, Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(otConsent);
		successfullyAdded = true;
		String save = "save";
		if (successfullyAdded) {
			map.put("save", save);
		}
		int bookingId = box.getInt("bookingId");

		OtBooking booking = (OtBooking) hbt.get(OtBooking.class, bookingId);
		booking.setPreOperativeStatus("y");
		booking.setIntraOperativeStatus("n");
		hbt.update(booking);

		/*
		 * List<OtPreAnesthesiaDetails> otDetails = new
		 * ArrayList<OtPreAnesthesiaDetails>(); otDetails =
		 * session.createCriteria(OtPreAnesthesiaDetails.class)
		 * .add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
		 * .add(Restrictions.eq("PreOperativeStatus", "n").ignoreCase())
		 * .list(); for (OtPreAnesthesiaDetails otd : otDetails) {
		 * otd.setConsentStatus("y"); otd.setPreOperativeStatus("y");
		 * hbt.update(otd); }
		 */
		hbt.flush();
		return map;
	}

	@Override
	public int getItemId(String itemName) {
		int itemId = 0;
		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		// String item1[] = itemName.split("[");
		// String item11[] = item1[1].split("]");
		// String item111 = item11[0];

		int index1 = itemName.lastIndexOf("[");
		int index2 = itemName.lastIndexOf("]");
		index1++;
		String item111 = itemName.substring(index1, index2);
		itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("Id", Integer.parseInt(item111))).list();

		for (MasStoreItem masStoreItem : itemList) {
			itemId = masStoreItem.getId();
		}
		return itemId;
	}

	public Map<String, Object> searchOtSignoutList(Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		Session session = (Session) getSession();

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";
		Integer typeId = 11;
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		Criteria crit = session
				.createCriteria(OtBooking.class)
				// .add(Restrictions.eq("SurgeryStatus", "n"))
				.createAlias("Hin", "h")
				.createAlias("OpdSurseryHeader", "sheader")
				.add(Restrictions.eq("Hospital.Id",
						(Integer) mapForDS.get(HOSPITAL_ID)));

		crit.add(Restrictions.eq("PreOperativeStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("IntraOperativeStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("SurgicalSafetyStatus", "y").ignoreCase());
		// crit.add(Restrictions.eq("OtNoteProcedureStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase());
		crit.createAlias("ChargeCode", "charge").add(
				Restrictions.ne("charge.ChargeType.Id", typeId));// Added by
																	// Arbind on
																	// 18-07-2017

		if (!uhid.equals("")) {
			crit.add(Restrictions.eq("h.HinNo", uhid.toLowerCase())
					.ignoreCase());
		}
		if (!pName.equals("")) {
			crit.add(Restrictions.like("h.PFirstName",
					pName.toLowerCase() + "%").ignoreCase());
		}
		if (!ipNo.equals("")) {
			// crit.createAlias("sheader.Inpatient", "ip");
			crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
					.ignoreCase());
		}
		if (gender != 0) {
			crit.createAlias("h.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}
		patientList = crit.list();

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);

		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> showOtSignoutListEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int userId = (Integer) mapForDS.get(USER_ID);
		// String hinNo = "";
		int bookingId = 0;
		String RefferedDoctor = "";
		/*
		 * List<MasEmployee>surgeonList=new ArrayList<MasEmployee>();
		 * List<MasEmployee>anestheticList=new ArrayList<MasEmployee>();
		 * List<MasEmployee>nurseList=new ArrayList<MasEmployee>();
		 * List<MasEmployee>assisstantList=new ArrayList<MasEmployee>();
		 */
		/*
		 * if (mapForDS.get("hinNo") != null) { hinNo = (String)
		 * mapForDS.get("hinNo"); }
		 */
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		/*
		 * try{
		 * surgeonList=session.createCriteria(MasEmployee.class).add(Restrictions
		 * .eq("EmpCategory.Id", 1)).list();
		 * anestheticList=session.createCriteria
		 * (MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",
		 * 30)).list();
		 * nurseList=session.createCriteria(MasEmployee.class).add(Restrictions
		 * .eq("EmpCategory.Id", 2)).list();
		 * assisstantList=session.createCriteria
		 * (MasEmployee.class).add(Restrictions.eq("EmpCategory.Id", 4)).list();
		 * }catch(Exception e){ e.printStackTrace(); }
		 */
		patientDetailList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", bookingId)).list();

		if (patientDetailList.size() > 0) {
			if (patientDetailList.get(0).getVisit() != null) {
				int visitId = patientDetailList.get(0).getVisit().getId();
				List<OpdPatientDetails> patientData = session
						.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId)).list();
				RefferedDoctor = patientData.get(0).getEmployee()
						.getEmployeeName();
			}
		}

		try {
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		map.put("RefferedDoctor", RefferedDoctor);
		/*
		 * map.put("surgeonList", surgeonList); map.put("nurseList", nurseList);
		 * map.put("assisstantList", assisstantList); map.put("anestheticList",
		 * anestheticList);
		 */
		return map;

	}

	@Override
	public Map<String, Object> submitOtSignOutEntryJsp(OtSignOut otSignOut,
			int hinId) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(otSignOut);
		successfullyAdded = true;
		OtBooking booking = (OtBooking) hbt.get(OtBooking.class, hinId);
		booking.setOtBookingStatus("c");
		booking.setSurgeryStatus("c");
		hbt.update(booking);
		hbt.flush();
		/*
		 * List<OtIntraOperativeTimeOut> preOperativeCheckList = new
		 * ArrayList<OtIntraOperativeTimeOut>(); preOperativeCheckList = session
		 * .createCriteria(OtIntraOperativeTimeOut.class)
		 * .add(Restrictions.eq("Hin.Id", hinId))
		 * .add(Restrictions.eq("SignOutStatus", "n").ignoreCase()).list(); for
		 * (OtIntraOperativeTimeOut pre : preOperativeCheckList) {
		 * pre.setSignOutStatus("y"); hbt.update(pre); }
		 */

		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> submitOtSignOutEntryJsp(
			OtSignOutItemConsume otSignOut) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(otSignOut);
		successfullyAdded = true;
		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@Override
	public Map<String, Object> searchIntraOperativeCheckList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		Session session = (Session) getSession();

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		if (mapForDS.get("otProcedure") != null) {
			otProcedure = (String) mapForDS.get("otProcedure");
		}

		if (otProcedure != null
				&& !otProcedure.equals("")
				&& (otProcedure.equalsIgnoreCase("yes") || otProcedure
						.equalsIgnoreCase("no"))) {
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			Criteria crit = session
					.createCriteria(OtBooking.class)
					.add(Restrictions.ne("SurgeryStatus", "c"))
					.createAlias("Hin", "h")
					/*
					 * .createAlias("Inpatient",
					 * "ip",CriteriaSpecification.LEFT_JOIN)
					 * .add(Restrictions.or(Restrictions.isNotNull("Visit"),
					 * Restrictions.in("ip.AdStatus", aList)))
					 */
					// .createAlias("sheader.Inpatient", "ip")
					// .createAlias("OpdSurseryHeader", "sheader")
					.add(Restrictions.eq("Hospital.Id",
							(Integer) mapForDS.get(HOSPITAL_ID)))
					// .add(Restrictions.in("ip.AdStatus",aList))
					.createAlias("ChargeCode", "charge")
					.add(Restrictions.ne("charge.ChargeType.Id", typeId));// Added
																			// by
																			// Arbind
																			// on
																			// 18-07-2017

			if (otProcedure.equalsIgnoreCase("yes")) {
				crit.add(Restrictions.or(Restrictions
						.isNull("PreOperativeStatus"),
						Restrictions.eq("PreOperativeStatus", "y").ignoreCase()));
				crit.add(Restrictions.or(Restrictions
						.isNull("IntraOperativeStatus"),
						Restrictions.eq("IntraOperativeStatus", "n")
								.ignoreCase()));
			} else if (otProcedure.equalsIgnoreCase("no")) {
				crit.add(Restrictions.or(Restrictions
						.isNull("PreOperativeStatus"),
						Restrictions.eq("PreOperativeStatus", "n").ignoreCase()));
			}

			if (!uhid.equals("")) {
				crit.add(Restrictions.eq("h.HinNo", uhid.toLowerCase())
						.ignoreCase());
			}
			if (!pName.equals("")) {
				crit.add(Restrictions.like("h.PFirstName",
						pName.toLowerCase() + "%").ignoreCase());
			}
			if (!ipNo.equals("")) {

				crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
						.ignoreCase());
			}
			if (gender != 0) {
				crit.createAlias("h.Sex", "s");
				crit.add(Restrictions.eq("s.Id", gender));
			}
			patientList = crit.list();
		}
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);

		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> showIntraOperativeCheckListEntryJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		List<MasEmployee> surgeonList = new ArrayList<MasEmployee>();
		List<MasEmployee> anestheticList = new ArrayList<MasEmployee>();
		List<MasEmployee> nurseList = new ArrayList<MasEmployee>();
		List<MasEmployee> assisstantList = new ArrayList<MasEmployee>();
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		List<OtBookSurgeon> surgeons = new ArrayList<OtBookSurgeon>();
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		try {
			surgeonList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.EmpCategoryCode", "01")
							.ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			anestheticList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.EmpCategoryCode", "Ane")
							.ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			nurseList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.EmpCategoryCode", "02")
							.ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			assisstantList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("empCategory.EmpCategoryCode", "04")
							.ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientDetailList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", bookingId)).list();
		surgeons=session.createCriteria(OtBookSurgeon.class).add(Restrictions.eq("Booking.Id", bookingId)).list();
		try {
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		map.put("surgeonList", surgeonList);
		map.put("nurseList", nurseList);
		map.put("assisstantList", assisstantList);
		map.put("anestheticList", anestheticList);
		map.put("surgeons", surgeons);
		return map;

	}

	
	public Map<String, Object> submitIntrOperatioveForOt(
			OtIntraOperativeTimeOut otIntraOperativeTimeOut, int hinId,Map<String,Object> dataMap) {
		
		List<Integer> proposedSurgeonsIdList=new ArrayList<Integer>(); //Added By Srikanth
		List<String> roleList=new ArrayList<String>();
		
		if(dataMap.get("surgeonsList")!=null){
			proposedSurgeonsIdList=(List<Integer>) dataMap.get("surgeonsList");
		}

		if(dataMap.get("roleList")!=null){
			roleList=(List<String>) dataMap.get("roleList");
		}
		
		Map<Integer,String> proposedMap=new HashMap<Integer,String>();
		
		for(int i=0;i<proposedSurgeonsIdList.size();i++){
			proposedMap.put(proposedSurgeonsIdList.get(i), roleList.get(i));
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		OtBooking otBooking = (OtBooking) hbt.get(OtBooking.class, hinId);

		List<Integer> existedSurgeonsList=new ArrayList<Integer>();
		List<Integer> commonSurgeonsList=new ArrayList<Integer>();
		List<Integer> newSurgeonsList=new ArrayList<Integer>();
		
		
			for(Iterator<OtBookSurgeon> sur=otBooking.getOtBookSurgeons().iterator();sur.hasNext();){
				
				existedSurgeonsList.add(sur.next().getEmployee().getId());
			}
			newSurgeonsList.addAll(proposedSurgeonsIdList);
			newSurgeonsList.removeAll(existedSurgeonsList);
			
			Set<OtBookSurgeon> surgeonSet=new HashSet<OtBookSurgeon>();
			
			for(OtBookSurgeon surg:otBooking.getOtBookSurgeons()){
				if(proposedSurgeonsIdList.contains(surg.getEmployee().getId())){
					surg.setRole(proposedMap.get(surg.getEmployee().getId()));
					surg.setStatus("y");
					surg.setOtIntraOperativeTimeOut(otIntraOperativeTimeOut);
					
				}else{
					surg.setStatus("n");
					surg.setOtIntraOperativeTimeOut(otIntraOperativeTimeOut);
				}
			}
			
			
			hbt.save(otIntraOperativeTimeOut);
			otBooking.setIntraOperativeStatus("y");
			hbt.update(otBooking);
			
			
			for(Integer newSurgeon:newSurgeonsList){
				OtBookSurgeon bookSurgeon=new OtBookSurgeon();
				bookSurgeon.setBooking(otBooking);
				bookSurgeon.setOrderno(otBooking.getOrderNo());
				MasEmployee employee=new MasEmployee();
				employee.setId(newSurgeon);
				bookSurgeon.setEmployee(employee);
				bookSurgeon.setRole(proposedMap.get(newSurgeon));
				bookSurgeon.setStatus("y");
				bookSurgeon.setOtIntraOperativeTimeOut(otIntraOperativeTimeOut);
				hbt.save(bookSurgeon);
				hbt.flush();
				
			}
			
		
		successfullyAdded = true;
		
		hbt.flush();
		/*
		 * List<OtPreOperativeCheckList> preOperativeCheckList = new
		 * ArrayList<OtPreOperativeCheckList>(); preOperativeCheckList = session
		 * .createCriteria(OtPreOperativeCheckList.class)
		 * .add(Restrictions.eq("Hin.Id", hinId))
		 * .add(Restrictions.eq("IntraOperativeSurgeryStatus",
		 * "n").ignoreCase()) .list(); for (OtPreOperativeCheckList pre :
		 * preOperativeCheckList) { pre.setIntraOperativeSurgeryStatus("y");
		 * hbt.update(pre); }
		 */

		map.put("successfullyAdded", successfullyAdded);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOtTime(Map<String, Object> mapForDS) {
		List<OtMasChargeDetails> chargeList1 = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int chargeId = 0;
		String chargeName = "";
		try {
			Criteria crit;
			chargeName = (String) mapForDS.get("chargeName");
			// int deptId=(Integer)mapForDS.get("deptId");
			int index1 = chargeName.lastIndexOf("[");
			int index2 = chargeName.lastIndexOf("]");
			index1++;
			chargeId = Integer.parseInt(chargeName.substring(index1, index2));
			// chargeId=(Integer)mapForDS.get("chargeId");

			// String chargeType = "SURG";
			crit = session.createCriteria(OtMasChargeDetails.class)
					.createAlias("ChargeCode", "chargeCode")
					.add(Restrictions.eq("chargeCode.Id", chargeId));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			chargeList1 = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList1", chargeList1);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<OtBooking> getOtDateList(Map mapForDS) {
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();

		Map<String, Object> map = new HashMap<String, Object>();
		Date surgeryDate = null;
		Session session = (Session) getSession();
		int chargeId = 0;
		int otIdBooked = 0;
		int deptId = 0;
		int deptIdLogin = 0;
		String chargeName = "";
		try {
			if (mapForDS.get("surgeryDate") != null
					&& !mapForDS.get("surgeryDate").equals("")) {
				surgeryDate = HMSUtil
						.convertStringTypeDateToDateType((String) (mapForDS
								.get("surgeryDate")));
			}
			if (mapForDS.get("deptIdLogin") != null) {
				deptIdLogin = (Integer) mapForDS.get("deptIdLogin");
			}
			if (mapForDS.get("otIdBooked") != null) {
				otIdBooked = (Integer) mapForDS.get("otIdBooked");
			}
			// String chargeType = "SURG";
			Criteria crit = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("SurgeryDate", surgeryDate))
					.add(Restrictions.eq("OtBookingStatus", "y"));
			/*
			 * if(deptId>0){ crit=crit.createAlias("Department", "dept")
			 * .add(Restrictions.eq("dept.Id", deptIdLogin)); }
			 */
			if (otIdBooked > 0) {
				crit = crit.createAlias("Ot", "ot").add(
						Restrictions.eq("ot.Id", otIdBooked));
			}

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			otBookingList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return otBookingList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getInvestigationListForAutoComplete(
			Map<String, Object> mapForDS) {
		List<OtMasChargeDetails> chargeList = new ArrayList<OtMasChargeDetails>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int otId = 0;
		try {
			Criteria crit;
			// int deptId=(Integer)mapForDS.get("deptId");
			otId = (Integer) mapForDS.get("otId");
			String str = "%" + mapForDS.get("autoHint") + "%";

			// String chargeType = "SURG";
			crit = session.createCriteria(OtMasChargeDetails.class)

			.createAlias("Ot", "ot").add(Restrictions.eq("ot.Id", otId));

			crit.setFirstResult(0);
			crit.setMaxResults(10);
			chargeList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chargeList", chargeList);
		return map;
	}

	@Override
	public Map<String, Object> getStoreConsumableItemForAutoComplete(
			Map<String, Object> map) {
		List<MasStoreItem> storeItemList = new ArrayList<MasStoreItem>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId = (Integer) map.get("hospitalId");
		try {
			// int deptId=(Integer)mapForDS.get("deptId");

			String str = "%" + map.get("autoHint") + "%";
			// String chargeType= "DIAG";
			System.out.println(hospitalId + "" + map.get("autoHint"));
			Criteria crit = session
					.createCriteria(MasStoreItem.class)
					.createAlias("Group", "group")
					.add(Restrictions.eq("group.GroupCode", "G2").ignoreCase())
					.add(Restrictions.like("Nomenclature", str.toLowerCase())
							.ignoreCase());
			// .add(Restrictions.eq("Hospital.Id", hospitalId));
			crit.setFirstResult(0);
			crit.setMaxResults(10);
			storeItemList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("storeItemList", storeItemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeCodeDetailsForOT(String chargeCode,
			int hinId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		try {

			chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("ChargeCodeCode", chargeCode)).list();
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

	@SuppressWarnings("unchecked")
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
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.idEq(chargeId)).list();

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
							if (masDiscount.getRoomType() != null) {
								if (masDiscount.getRoomType().getId()
										.equals(roomTypeId)) {
									criteria = criteria
											.createAlias("ChargeCode", "cc")
											.add(Restrictions.eq("cc.Id",
													chargeId))
											.createAlias("SubChargecode", "sc")
											.add(Restrictions.eq("sc.Id",
													subChargeId))
											.createAlias("MainChargecode", "mc")
											.add(Restrictions.eq("mc.Id",
													mainChargeId));
									break;
								}
							}
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
					chargeAfterSD = chargeAmountAfterDis; // For Tariff case
					map.put("rate", chargeAfterSD);
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
					chargeAfterSD = fixedValueDB;
					map.put("rate", chargeAfterSD);

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

	// Written by Vishnu
	public Map<String, Object> showWaitingListForSurgery(Map mapForDS) {

		Session session = (Session) getSession();
		List<OpdSurgeryHeader> waitList = new ArrayList<OpdSurgeryHeader>();
		List<Object[]> objList = new ArrayList<Object[]>();
		List<MasDepartment> department = new ArrayList<MasDepartment>();
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int departmentId = 0;
		Date appointmentDate = null;
		String hinNo = "";
		String pname = "";
		String IPNo = "";
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		int page = (Integer) mapForDS.get("page");
		Criteria criteria = null;

		try {
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			/*
			 * criteria = session.createCriteria(OpdSurgeryHeader.class,"opd")
			 * .createAlias("Hospital", "h") .createAlias("OpdSurgeryDetails",
			 * "details") .createAlias("details.ChargeCode", "charge")
			 * .add(Restrictions.ne("charge.ChargeType.Id", typeId))//Added by
			 * Arbind on 15-07-2017 .createAlias("Inpatient", "ip")
			 * .add(Restrictions.in("ip.AdStatus", aList))
			 * .add(Restrictions.eq("h.Id", hospitalId))
			 * .add(Restrictions.eq("BookingStatus", "pending").ignoreCase())
			 * //.add(Restrictions.eq("opd.PacStatus",
			 * "pending".toLowerCase()).ignoreCase())
			 * .add(Restrictions.eq("Status", "P".toLowerCase()).ignoreCase());
			 */

			criteria = session
					.createCriteria(OpdSurgeryDetail.class, "details")
					.createAlias("OpdSurgery", "header")
					.createAlias("header.Hin", "hin")
					.createAlias("header.PrescribedDepartment", "dept")
					.createAlias("header.Visit", "visit",CriteriaSpecification.LEFT_JOIN)
					.createAlias("header.Hospital", "h")
					.createAlias("ChargeCode", "charge")
					.add(Restrictions.ne("charge.ChargeType.Id", typeId))
					// Added by Arbind on 15-07-2017
					/*
					 * .createAlias("header.Inpatient", "ip")
					 * .add(Restrictions.in("ip.AdStatus", aList))
					 */
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("header.BookingStatus", "pending")
							.ignoreCase())
					// .add(Restrictions.eq("opd.PacStatus",
					// "pending".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("header.Status", "P".toLowerCase())
							.ignoreCase())
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("OpdSurgery"))
									.add(Projections
											.groupProperty("header.Hin"))
									.add(Projections
											.groupProperty("header.PrescribedDepartment"))
									.add(Projections
											.groupProperty("header.Visit"))
									.add(Projections
											.groupProperty("header.Inpatient"))
									.add(Projections
											.groupProperty("TentativeDate")))
					.addOrder(Order.asc("TentativeDate"));

			if (mapForDS.get("appointmentDate") != null) {
				appointmentDate = (Date) mapForDS.get("appointmentDate");
				criteria.add(Restrictions.eq("TentativeDate", appointmentDate));
			}

			if (mapForDS.get("depart") != null) {
				departmentId = (Integer) mapForDS.get("depart");
				criteria.add(Restrictions.eq("dept.Id", departmentId));
			}

			if (mapForDS.get("hinNo") != null) {
				hinNo = (String) mapForDS.get("hinNo");
				criteria.add(Restrictions.eq("hin.HinNo", hinNo));
			}

			if (mapForDS.get("IPNo") != null) {
				IPNo = (String) mapForDS.get("IPNo");
				criteria.createAlias("header.Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", IPNo));
			}

			if (mapForDS.get("pname1") != null) {
				pname = (String) mapForDS.get("pname1");
				criteria.add(Restrictions.like("hin.PFirstName", pname + "%")
						.ignoreCase());
			}
			department = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("DepartmentName")).list();
			// System.out.println(department.size()+"=============="+waitList.size());

			noOfRecords = criteria.list().size();
			criteria.setFirstResult((page - 1) * recordsPerPage);
			criteria.setMaxResults(recordsPerPage);
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			objList = criteria.list();
			if (objList.size() > 0) {
				for (int i = 0; i < objList.size(); i++) {
					OpdSurgeryHeader header = ((OpdSurgeryHeader) objList
							.get(i)[0]);
					waitList.add(header);
				}
			}
			System.out.println("noOfPages " + noOfPages + " currentPage "
					+ page);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("department", department);
		map.put("waitList", waitList);
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		return map;
	}

	@Override
	public Map<String, Object> fillMemberForName(Map dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> eList = new ArrayList<MasEmployee>();
		String nameMember = null;
		nameMember = "" + dataMap.get("nameMember");
		int hospitalId = (Integer) dataMap.get(HOSPITAL_ID);
		String empCategoryName = "Doctor";

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			if (!nameMember.equals("")) {
				int index1 = nameMember.indexOf("[");
				nameMember = nameMember.substring(0, index1);
			}
			eList = session
					.createCriteria(MasEmployee.class)
					.createAlias("Hospital", "hos")
					.add(Restrictions.like("EmployeeName",
							"%" + nameMember + "%").ignoreCase())
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("empCategory.EmpCategoryName",
							empCategoryName).ignoreCase())
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("hos.Id", hospitalId)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("eList", eList);
		return map;
	}

	@Override
	public Map<String, Object> showCalenderForOt(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> bookList = new ArrayList<OtBooking>();
		List<OtMasUnitDay> otMasUnitDayList = new ArrayList<OtMasUnitDay>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int deptId = (Integer) mapForDS.get(DEPT_ID);
		int empId = (Integer) mapForDS.get("empId");
		int month = (Integer) mapForDS.get("month");
		int year = (Integer) mapForDS.get("year");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		/*
		 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 * DateFormat f = new SimpleDateFormat("EEEE"); Date
		 * bookingDate=dateFormat.parse("22/09/2015");
		 */

		HospitalDoctorUnitT doctorUnit = (HospitalDoctorUnitT) session
				.createCriteria(HospitalDoctorUnitT.class)
				.createAlias("UnitM", "um")
				.add(Restrictions.eq("um.Hospital.Id", hospitalId))
				.add(Restrictions.eq("Employee.Id", empId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setFirstResult(0).setMaxResults(1).uniqueResult();

		otMasUnitDayList = session.createCriteria(OtMasUnitDay.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				// .add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("UnitM.Id",
						doctorUnit != null ? doctorUnit.getUnitM().getId() : 0))
				// .add(Restrictions.eq("DayName", f.format(bookingDate)))
				.list();

		Set<String> workingDays = new HashSet<String>();
		for (OtMasUnitDay day : otMasUnitDayList) {
			workingDays.add(day.getDayName());
		}
		Date fromDate = calendar.getTime();
		Date toDate = null;
		while (month == calendar.get(Calendar.MONTH)) {
			toDate = calendar.getTime();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		bookList = session
				.createCriteria(OtBooking.class)
				.add(Restrictions.in("OtBookingStatus",
						new String[] { "y", "c" }))
				.add(Restrictions.between("SurgeryDate", fromDate, toDate))
				.list();

		map.put("bookList", bookList);
		map.put("otMasUnitDayList", otMasUnitDayList);
		map.put("workingDays", workingDays);
		return map;
	}

	@Override
	public Map<String, Object> displayOtTableForUnit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtMasUnitDay> otMasUnitDayList = new ArrayList<OtMasUnitDay>();
		Session session = (Session) getSession();
		Calendar now = Calendar.getInstance();
		String[] strDays = new String[] { "Sunday", "Monday", "Tuesday",
				"Wednesday", "Thursday", "Friday", "Saturday" };
		String dayName = strDays[now.get(Calendar.DAY_OF_WEEK) - 1];
		// System.out.println("dayName is : " +dayName);

		otMasUnitDayList = session.createCriteria(OtMasUnitDay.class)
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				// .add(Restrictions.eq("UnitM.Id", box.getInt("unitId")))
				.add(Restrictions.eq("DayName", dayName)).list();
		// System.out.println("otMasUnitDayList=="+otMasUnitDayList.size());
		map.put("otMasUnitDayList", otMasUnitDayList);
		return map;
	}

	@Override
	public Map<String, Object> showAllergy(Box box, Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdPatientAllergyM> allergyMs = new ArrayList<OpdPatientAllergyM>();
		List<OpdPatientAllergyT> allergyTs = new ArrayList<OpdPatientAllergyT>();
		int requestId = 0;
		if (box.get("requestId") != null) {
			requestId = Integer.parseInt("" + box.get("requestId"));
		}
		System.out.println("requestId" + requestId);
		allergyTs = session
				.createCriteria(OpdPatientAllergyT.class, "allergyT")
				.createAlias("allergyT.OpdPatientAllergy", "allergyM")
				// .createAlias("allergyM.Inpatient", "ip")
				.createAlias("allergyM.Hin", "hin")
				.add(Restrictions.eq("hin.Id", requestId)).list();
		map.put("allergyTs", allergyTs);
		System.out.println("map" + allergyTs.size());
		return map;
	}

	@Override
	public Map<String, Object> getSurgeryInfoForPatient(int inaptientId) {
		Session session = (Session) getSession();
		List<OtBooking> bookingList = new ArrayList<OtBooking>();
		bookingList = session
				.createCriteria(OtBooking.class)
				.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
				// .add(Restrictions.eq("SurgeryStatus", "y").ignoreCase())
				.add(Restrictions.eq("OtPostAnethesiaStatus", "n").ignoreCase())
				.createAlias("Hin", "hin")

				.createAlias("OpdSurseryHeader", "sheader")
				.createAlias("sheader.Inpatient", "ip")
				.add(Restrictions.eq("ip.Id", inaptientId)).list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookingList", bookingList);
		return map;
	}

	@Override
	public Map<String, Object> showOpSurgeryPlanningJsp(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		int hinId = 0;
		if (mapForDS.get("hinId") != null) {
			hinId = (Integer) mapForDS.get("hinId");
		}
		List<Patient> hinList = new ArrayList<Patient>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();

		Session session = (Session) getSession();
		List<HospitalDoctorUnitM> unitMList = new ArrayList<HospitalDoctorUnitM>();
		unitMList = session.createCriteria(HospitalDoctorUnitM.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		hinList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("Id", hinId)).list();
		deptList = session
				.createCriteria(MasInstituteDepartment.class)
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.createAlias("Department", "dep")
				.add(Restrictions.eq("dep.DepartmentType.Id", 10))
				.setProjection(
						Projections.projectionList().add(
								Projections.groupProperty("Department")))
				.list();
		map.put("unitMList", unitMList);
		map.put("hinList", hinList);
		map.put("deptList", deptList);
		return map;
	}

	@Override
	public Map<String, Object> getUnitDays(int unitId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> unitDayList = new ArrayList<String>();
		String query = "SELECT distinct day_name  FROM  ot_mas_unit_day where unit_m_id="
				+ unitId;

		unitDayList = session.createSQLQuery(query).list();
		map.put("unitDayList", unitDayList);
		return map;
	}

	@Override
	public Map<String, Object> getBookingDetails(int hospitalId, int unitId,
			String dayName, Date bookingDate) {
		Session session = (Session) getSession();
		List<OtBooking> bookingList = new ArrayList<OtBooking>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		bookingList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("SurgeryDate", bookingDate)).list();
		System.out.println(bookingList.size() + "<<size------bookingDate->>"
				+ bookingDate);
		deptList = session
				.createCriteria(MasInstituteDepartment.class)
				.add(Restrictions.eq("Institute.Id", hospitalId))
				.createAlias("Department", "dep")
				.add(Restrictions.eq("dep.DepartmentType.Id", 10))
				.setProjection(
						Projections.projectionList().add(
								Projections.groupProperty("Department")))
				.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookingList", bookingList);
		map.put("deptList", deptList);
		return map;
	}

	@Override
	public boolean cancelServiceInv(int dtId, Date surgeryDate2) {
		Session session = (Session) getSession();
		List<OtBooking> bookingList = new ArrayList<OtBooking>();
		boolean updated = false;
		bookingList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", dtId)).list();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (OtBooking OtBooking : bookingList) {
			OtBooking.setSurgeryDate(surgeryDate2);
			hbt.update(OtBooking);
		}
		updated = true;
		return updated;
	}

	@Override
	public List<Inpatient> getHinId(int inpatientId) {
		int hinId = 0;
		List<Inpatient> ipList = new ArrayList<Inpatient>();
		System.out.println("inpatientId ------ >>" + inpatientId);
		Session session = (Session) getSession();
		ipList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();

		return ipList;
	}

	// added by amit das on 22-09-2016
	@Override
	public Map<String, Object> searchSurgerySafetyCheckList(
			Map<String, Object> mapForDS) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<String> aList = new ArrayList<String>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		Session session = (Session) getSession();
		Criteria crit = null;

		String uhid = null;
		String pName = null;
		String ipNo = null;
		int gender = 0;
		String otProcedure = null;

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);

		if (mapForDS.get(HIN_NO) != null)
			uhid = (String) mapForDS.get(HIN_NO);

		if (mapForDS.get(AD_NO) != null)
			ipNo = (String) mapForDS.get(AD_NO);

		if (mapForDS.get(PATIENT_NAME) != null)
			pName = (String) mapForDS.get(PATIENT_NAME);

		if (mapForDS.get(GENDER) != null)
			gender = (Integer) mapForDS.get(GENDER);

		if (mapForDS.get("otProcedure") != null)
			otProcedure = (String) mapForDS.get("otProcedure");

		// if(otProcedure!=null && !otProcedure.equals("") &&
		// (otProcedure.equalsIgnoreCase("yes") ||
		// otProcedure.equalsIgnoreCase("no"))){
		aList.add("A");
		aList.add("R");
		Integer typeId = 11;
		crit = session
				.createCriteria(OtBooking.class)
				/*
				 * .createAlias("Inpatient",
				 * "ip").add(Restrictions.in("ip.AdStatus", aList))
				 */
				.createAlias("Hin", "h")
				.add(Restrictions.eq("Hospital.Id",
						(Integer) mapForDS.get(HOSPITAL_ID)))
				/*
				 * .createAlias("Inpatient",
				 * "ip",CriteriaSpecification.LEFT_JOIN)
				 * .add(Restrictions.or(Restrictions.isNotNull("Visit"),
				 * Restrictions.in("ip.AdStatus", aList)))
				 */
				.createAlias("OpdSurseryHeader", "osh")
				.add(Restrictions.eq("osh.PacStatus", "cleared").ignoreCase())
				.add(Restrictions.ne("SurgeryStatus", "c").ignoreCase())
				.add(Restrictions.or(Restrictions
						.isNull("SurgicalSafetyStatus"),
						Restrictions.ne("SurgicalSafetyStatus", "y")
								.ignoreCase()))
				.createAlias("ChargeCode", "charge")
				.add(Restrictions.ne("charge.ChargeType.Id", typeId));// Added
																		// by
																		// Arbind
																		// on
																		// 18-07-2017

		/*
		 * if(otProcedure.equalsIgnoreCase("yes")){
		 * crit.add(Restrictions.eq("PreOperativeStatus", "y").ignoreCase());
		 * crit.add(Restrictions.or(Restrictions.isNull("IntraOperativeStatus"),
		 * Restrictions.eq("IntraOperativeStatus", "n").ignoreCase())); } else
		 * if(otProcedure.equalsIgnoreCase("no")){
		 * crit.add(Restrictions.or(Restrictions.isNull("PreOperativeStatus"),
		 * Restrictions.eq("PreOperativeStatus", "n").ignoreCase()) ); }
		 */

		if (uhid != null && !uhid.equals(""))
			crit.add(Restrictions.eq("h.HinNo", uhid.toLowerCase())
					.ignoreCase());

		if (pName != null && !pName.equals(""))
			crit.add(Restrictions.like("h.PFirstName",
					pName.toLowerCase() + "%").ignoreCase());

		if (ipNo != null && !ipNo.equals(""))
			crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
					.ignoreCase());

		if (gender != 0) {
			crit.createAlias("h.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}

		patientList = crit.list();

		// }

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		map.put("sexList", sexList);
		map.put("patientList", patientList);
		return map;

	}

	// added by amit das on 22-09-2016
	@Override
	public Map<String, Object> showSurgerySafetyCheckListJsp(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		Map<String, Object> map = new HashMap<String, Object>();

		int bookingId = 0;
		if (mapForDS.get("bookingId") != null) {
			bookingId = (Integer) mapForDS.get("bookingId");
		}
		patientDetailList = session.createCriteria(OtBooking.class)
				.add(Restrictions.eq("Id", bookingId)).list();

		map.put("patientDetailList", patientDetailList);
		return map;

	}

	// added by amit das on 23-09-2016
	@Override
	public Map<String, Object> submitSurgerySafetyCheckList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtPreOperativeCheckList> otPreOperativeCheckLists = null;
		List<OtIntraOperativeTimeOut> otIntraOperativeTimeOuts = null;
		List<OtSignOut> otSignOuts = null;
		List<OtBooking> otBookings = null;
		List<OtPreAnesthesiaDetails> otDetails = null;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		String pcfc = null;
		String issm = null;
		String anaesthesiaMachineCheck = null;
		String oximeterCheck = null;
		String allergyCheck = null;
		String aspirationCheck = null;
		String risk = null;

		String confirmAll = null;
		String patientInfoCheck = null;
		String antibioticProphylaxis = null;
		String criticalStepsCheck = null;
		String caseDurationCheck = null;
		String bloodLossCheck = null;
		String additionalConcern = null;
		String sterlizationIndicator = null;
		String equipConcern = null;
		String ralavantImage = null;

		String nameOfOperativeProc = null;
		String spongeNeddleCheck = null;
		String specIdentifiedAndLabeled = null;
		String anyEquipProbAddress = null;
		String keyConcernForRecovery = null;

		OtPreOperativeCheckList otPre = null;
		OtIntraOperativeTimeOut otIntra = null;
		OtSignOut otSignOut = null;

		Patient patient = new Patient();
		MasHospital hospital = new MasHospital();
		OtBooking otBooking = new OtBooking();

		String intra_operative_surgery_status = "y";
		int hinId = box.getInt("hinId");
		int hospitalId = box.getInt("hospitalId");
		int bookingId = box.getInt("bookingId");
		int inpatientId = box.getInt("inpatientId");
		boolean successfullyAdded = true;

		if (box.get("pcfc") != null)
			pcfc = box.get("pcfc");

		if (box.get("issm") != null)
			issm = box.get("issm");

		if (box.get("anaesthesiaMachineCheck") != null)
			anaesthesiaMachineCheck = box.get("anaesthesiaMachineCheck");

		if (box.get("oximeterCheck") != null)
			oximeterCheck = box.get("oximeterCheck");

		if (box.get("allergyCheck") != null)
			allergyCheck = box.get("allergyCheck");

		if (box.get("aspirationCheck") != null)
			aspirationCheck = box.get("aspirationCheck");

		if (box.get("risk") != null)
			risk = box.get("risk");

		if (box.get("confirmAll") != null)
			confirmAll = box.get("confirmAll");

		if (box.get("patientInfoCheck") != null)
			patientInfoCheck = box.get("patientInfoCheck");

		if (box.get("antibioticProphylaxis") != null)
			antibioticProphylaxis = box.get("antibioticProphylaxis");

		if (box.get("criticalStepsCheck") != null)
			criticalStepsCheck = box.get("criticalStepsCheck");

		if (box.get("caseDurationCheck") != null)
			caseDurationCheck = box.get("caseDurationCheck");

		if (box.get("bloodLossCheck") != null)
			bloodLossCheck = box.get("bloodLossCheck");

		if (box.get("additionalConcern") != null)
			additionalConcern = box.get("additionalConcern");

		if (box.get("sterlizationIndicator") != null)
			sterlizationIndicator = box.get("sterlizationIndicator");

		if (box.get("equipConcern") != null)
			equipConcern = box.get("equipConcern");

		if (box.get("ralavantImage") != null)
			ralavantImage = box.get("ralavantImage");

		if (box.get("nameOfOperativeProc") != null)
			nameOfOperativeProc = box.get("nameOfOperativeProc");

		if (box.get("spongeNeddleCheck") != null)
			spongeNeddleCheck = box.get("spongeNeddleCheck");

		if (box.get("specIdentifiedAndLabeled") != null)
			specIdentifiedAndLabeled = box.get("specIdentifiedAndLabeled");

		if (box.get("anyEquipProbAddress") != null)
			anyEquipProbAddress = box.get("anyEquipProbAddress");

		if (box.get("keyConcernForRecovery") != null)
			keyConcernForRecovery = box.get("keyConcernForRecovery");

		try {

			otPreOperativeCheckLists = session
					.createCriteria(OtPreOperativeCheckList.class)
					.add(Restrictions.eq("Hin.Id", hinId))
					.add(Restrictions.eq("OtBooking.Id", bookingId)).list();
			otIntraOperativeTimeOuts = session
					.createCriteria(OtIntraOperativeTimeOut.class)
					.add(Restrictions.eq("Hin.Id", hinId))
					.add(Restrictions.eq("OtBooking.Id", bookingId)).list();
			otSignOuts = session.createCriteria(OtSignOut.class)
					.add(Restrictions.eq("Hin.Id", hinId))
					.add(Restrictions.eq("OtBooking.Id", bookingId)).list();

			otBookings = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Hin.Id", hinId))
					.add(Restrictions.eq("Id", bookingId)).list();

			otDetails = session.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("Hin.Id", hinId))
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("ConsentStatus", "n")).list();

			if (otPreOperativeCheckLists != null
					&& otPreOperativeCheckLists.size() > 0)
				otPre = otPreOperativeCheckLists.get(0);
			else
				otPre = new OtPreOperativeCheckList();

			if (otIntraOperativeTimeOuts != null
					&& otIntraOperativeTimeOuts.size() > 0)
				otIntra = otIntraOperativeTimeOuts.get(0);
			else
				otIntra = new OtIntraOperativeTimeOut();

			if (otSignOuts != null && otSignOuts.size() > 0)
				otSignOut = otSignOuts.get(0);
			else
				otSignOut = new OtSignOut();

			patient.setId(hinId);
			hospital.setId(hospitalId);
			otBooking.setId(bookingId);

			otPre.setProcConsentFormStatus(pcfc);
			otPre.setIssMarkedBySurgeon(issm);
			otPre.setAnaesthesiaMachineChecked(anaesthesiaMachineCheck);
			otPre.setOximeterWorking(oximeterCheck);
			otPre.setKnownAllergy(allergyCheck);
			otPre.setAspirationRisk(aspirationCheck);
			otPre.setRisk(risk);
			otPre.setHin(patient);
			otPre.setHospital(hospital);
			otPre.setOtBooking(otBooking);

			otIntra.setConfirmAll(confirmAll);
			if (patientInfoCheck != null) {
				otIntra.setIdentityConfirm("Y");
				otIntra.setProcedureConfirm("Y");
				otIntra.setProcSiteConfrm("Y");
				otIntra.setConsentConfrm("Y");
			}
			otIntra.setAntibioticProphylaxis("Y");
			otIntra.setCriticalSteps(criticalStepsCheck);
			otIntra.setCaseDuration(caseDurationCheck);
			otIntra.setBloodLoss(bloodLossCheck);
			otIntra.setAdditionalConcern(additionalConcern);
			otIntra.setSterlizationIndicator(sterlizationIndicator);
			otIntra.setEquipConcern(equipConcern);
			otIntra.setRalavantImage(ralavantImage);
			otIntra.setHin(patient);
			otIntra.setHospital(hospital);
			otIntra.setOtBooking(otBooking);

			otSignOut.setNameOfOperativeProcedure(nameOfOperativeProc);
			otSignOut.setSpecimenIdentified(specIdentifiedAndLabeled);
			otSignOut.setSpongeNeedleChecked(spongeNeddleCheck);
			otSignOut.setAnyEquipProblem(anyEquipProbAddress);
			otSignOut.setKeyConcernForRecovery(keyConcernForRecovery);
			otSignOut.setHin(patient);
			otSignOut.setHospital(hospital);
			otSignOut.setOtBooking(otBooking);

			if (otPreOperativeCheckLists != null
					&& otPreOperativeCheckLists.size() > 0)
				hbt.update(otPre);
			else
				hbt.save(otPre);

			if (otIntraOperativeTimeOuts != null
					&& otIntraOperativeTimeOuts.size() > 0)
				hbt.update(otIntra);
			else
				hbt.save(otIntra);

			if (otSignOuts != null && otSignOuts.size() > 0)
				hbt.update(otSignOut);
			else
				hbt.save(otSignOut);

			for (OtPreAnesthesiaDetails otd : otDetails) {
				otd.setConsentStatus("y");
				otd.setPreOperativeStatus("n");
				hbt.update(otd);
			}

			for (OtBooking booking : otBookings) {
				booking.setIntraOperativeStatus("y");
				booking.setPreOperativeStatus("y");
				booking.setSurgicalSafetyStatus("y");
				hbt.update(booking);
			}

			map.put("message", "Patient Surgery Check List saved");
		} catch (Exception e) {
			map.put("message", "Patient Surgery Check List not saved");
			e.printStackTrace();
		}

		return map;
	}

	// Added by Arbind on 14-07-2017
	public Map<String, Object> showMinorOtWaitingList(Map mapForDS) {

		Session session = (Session) getSession();
		List<OpdSurgeryHeader> waitList = new ArrayList<OpdSurgeryHeader>();
		List<MasDepartment> department = new ArrayList<MasDepartment>();
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		int departmentId = 0;
		Date appointmentDate = null;
		String hinNo = "";
		String pname = "";
		String IPNo = "";
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		int page = (Integer) mapForDS.get("page");
		Criteria criteria = null;

		try {
			/*
			 * List<String>aList=new ArrayList<String>(); aList.add("A");
			 * aList.add("R");
			 */
			Integer typeId = 11;
			criteria = session
					.createCriteria(OpdSurgeryHeader.class, "opd")
					.createAlias("Hospital", "h")
					.createAlias("OpdSurgeryDetails", "details")
					.createAlias("details.ChargeCode", "charge")
					.add(Restrictions.eq("charge.ChargeType.Id", typeId))
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("BookingStatus", "pending")
							.ignoreCase())
					.add(Restrictions.eq("Status", "P".toLowerCase())
							.ignoreCase());

			if (mapForDS.get("appointmentDate") != null) {
				appointmentDate = (Date) mapForDS.get("appointmentDate");
				criteria.createAlias("OpdSurgeryDetails", "details").add(
						Restrictions.eq("details.TentativeDate",
								appointmentDate));
			}

			if (mapForDS.get("depart") != null) {
				departmentId = (Integer) mapForDS.get("depart");
				criteria.createAlias("PrescribedDepartment", "dept").add(
						Restrictions.eq("dept.Id", departmentId));
			}

			if (mapForDS.get("hinNo") != null) {
				hinNo = (String) mapForDS.get("hinNo");
				criteria.createAlias("Hin", "hin").add(
						Restrictions.eq("hin.HinNo", hinNo));
			}

			if (mapForDS.get("IPNo") != null) {
				IPNo = (String) mapForDS.get("IPNo");
				criteria.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", IPNo));
			}

			if (mapForDS.get("pname1") != null) {
				pname = (String) mapForDS.get("pname1");
				criteria.createAlias("Hin", "hin").add(
						Restrictions.like("hin.PFirstName", pname + "%")
								.ignoreCase());
			}

			department = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("DepartmentName")).list();
			// System.out.println(department.size()+"=============="+waitList.size());

			noOfRecords = criteria.list().size();
			criteria.setFirstResult((page - 1) * recordsPerPage);
			criteria.setMaxResults(recordsPerPage);
			noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

			waitList = criteria.list();

			System.out.println("noOfPages " + noOfPages + " currentPage "
					+ page);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("department", department);
		map.put("waitList", waitList);
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		return map;
	}

	// Added by Arbind on 18-07-2017
	public Map<String, Object> searchMinorOtPatientDetails(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdSurgeryHeader> patientList = new ArrayList<OpdSurgeryHeader>();
		Box box = (Box) mapForDS.get("box");
		int hospitalId = 0;

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";

		// String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		Session session = (Session) getSession();

		/*
		 * if (mapForDS.get("serviceNo") != null) { serviceNo = (String)
		 * mapForDS.get("serviceNo"); }
		 */
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}

		if (mapForDS.get("patientFName") != null) {
			patientFName = (String) mapForDS.get("patientFName");
		}
		if (mapForDS.get("patientMName") != null) {
			patientMName = (String) mapForDS.get("patientMName");
		}
		if (mapForDS.get("patientLName") != null) {
			patientLName = (String) mapForDS.get("patientLName");
		}

		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get("otProcedure") != null) {
			otProcedure = (String) mapForDS.get("otProcedure");
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		String patientStatus = "Cleared";
		String bookingStatus = "Cleared";

		if (otProcedure != null
				&& !otProcedure.equals("")
				&& (otProcedure.equalsIgnoreCase("yes") || otProcedure
						.equalsIgnoreCase("no"))) {
			Criteria crit = null;
			List<String> aList = new ArrayList<String>();
			aList.add("A");
			aList.add("R");
			Integer typeId = 11;
			crit = session
					.createCriteria(OtBooking.class)
					.createAlias("Hospital", "h")
					.createAlias("Hin", "hin")
					.createAlias("Inpatient", "ip",
							CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.or(Restrictions.isNotNull("Visit"),
							Restrictions.in("ip.AdStatus", aList)))
					// .add(Restrictions.in("ip.AdStatus", aList))
					.createAlias("OpdSurseryHeader", "osh")
					.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase())
					// .add(Restrictions.eq("osh.PacStatus",
					// "cleared").ignoreCase())
					.createAlias("ChargeCode", "charge")
					.add(Restrictions.eq("charge.ChargeType.Id", typeId));

			if (otProcedure.equalsIgnoreCase("yes")) {
				// crit.add( Restrictions.eq("SurgeryStatus",
				// "y").ignoreCase());
				// crit.add(Restrictions.eq("OtPostAnethesiaStatus",
				// "y").ignoreCase());
				crit.add(Restrictions.or(Restrictions
						.isNull("OtNoteProcedureStatus"),
						Restrictions.eq("OtNoteProcedureStatus", "n")
								.ignoreCase()));

			}
			/*
			 * else if(otProcedure.equalsIgnoreCase("no")) {
			 * crit.add(Restrictions.or(Restrictions.isNull("SurgeryStatus"),
			 * Restrictions.eq("SurgeryStatus", "n").ignoreCase()));
			 * 
			 * }
			 */
			crit.setProjection(Projections.projectionList().add(
					Projections.property("OpdSurseryHeader")));

			if (!uhid.equals("")) {
				crit.add(Restrictions.eq("hin.HinNo", uhid.toLowerCase())
						.ignoreCase());
			}
			if (!pName.equals("")) {
				crit.add(Restrictions.like("hin.PFirstName",
						pName.toLowerCase() + "%").ignoreCase());
			}
			if (!ipNo.equals("")) {
				crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
						.ignoreCase());
			}
			if (gender != 0) {
				crit.createAlias("hin.Sex", "s");
				crit.add(Restrictions.eq("s.Id", gender));
			}

			patientList = crit.list();
		}

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);
		map.put("patientList", patientList);

		return map;
	}

	// Added by Arbind on 22-07-2017
	public Map<String, Object> searchMinorOtSignoutList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();

		Session session = (Session) getSession();

		String uhid = "";
		String pName = "";
		String ipNo = "";
		int gender = 0;
		String otProcedure = "";
		Integer typeId = 11;
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		if (mapForDS.get(HIN_NO) != null) {
			uhid = (String) mapForDS.get(HIN_NO);
		}

		if (mapForDS.get(AD_NO) != null) {
			ipNo = (String) mapForDS.get(AD_NO);
		}

		if (mapForDS.get(PATIENT_NAME) != null) {
			pName = (String) mapForDS.get(PATIENT_NAME);
		}

		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		Criteria crit = session
				.createCriteria(OtBooking.class)
				// .add(Restrictions.eq("SurgeryStatus", "n"))
				.createAlias("Hin", "h")
				.createAlias("OpdSurseryHeader", "sheader")
				.add(Restrictions.eq("Hospital.Id",
						(Integer) mapForDS.get(HOSPITAL_ID)));

		// crit.add(Restrictions.eq("PreOperativeStatus", "y").ignoreCase());
		// crit.add(Restrictions.eq("IntraOperativeStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("OtNoteProcedureStatus", "y").ignoreCase());
		// crit.add(Restrictions.eq("SurgeryStatus", "y").ignoreCase());
		crit.add(Restrictions.eq("OtBookingStatus", "y").ignoreCase());
		crit.createAlias("ChargeCode", "charge").add(
				Restrictions.eq("charge.ChargeType.Id", typeId));

		if (!uhid.equals("")) {
			crit.add(Restrictions.eq("h.HinNo", uhid.toLowerCase())
					.ignoreCase());
		}
		if (!pName.equals("")) {
			crit.add(Restrictions.like("h.PFirstName",
					pName.toLowerCase() + "%").ignoreCase());
		}
		if (!ipNo.equals("")) {
			// crit.createAlias("sheader.Inpatient", "ip");
			crit.add(Restrictions.eq("ip.AdNo", ipNo.toLowerCase())
					.ignoreCase());
		}
		if (gender != 0) {
			crit.createAlias("h.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}
		patientList = crit.list();

		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);

		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> searchOtPatientConsentLetter(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtBooking> patientList = new ArrayList<OtBooking>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		String hinNo = "";
		String patientName = "";
		int gender = 0;

		Session session = (Session) getSession();

		if (mapForDS.get("hinNo") != null) {

			hinNo = (String) mapForDS.get("hinNo");
		}

		if (mapForDS.get("patientName") != null) {
			patientName = (String) mapForDS.get("patientName");
		}
		if (mapForDS.get(GENDER) != null) {
			gender = (Integer) mapForDS.get(GENDER);
		}

		Criteria crit = session.createCriteria(OtPreAnesthesiaDetails.class)
				.add(Restrictions.eq("ConsentStatus", "y").ignoreCase())
				.createAlias("Hin", "p");

		if (!patientName.equals("")) {
			crit = crit.add(Restrictions
					.like("p.PFirstName", patientName + "%"));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("p.HinNo", hinNo));
		}
		if (gender != 0) {
			crit.createAlias("p.Sex", "s");
			crit.add(Restrictions.eq("s.Id", gender));
		}
		crit = crit.add(Restrictions.eq("Hospital.Id",
				(Integer) mapForDS.get(HOSPITAL_ID)));
		patientList = crit.addOrder(Order.asc("Id")).list();
		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("sexList", sexList);
		map.put("patientList", patientList);
		return map;

	}

	@Override
	public Map<String, Object> uploadOtConsentLetter(
			Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		List<Patient> patientDetailList = new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		patientDetailList = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", hinNo.trim())).list();
		try {
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientDetailList", patientDetailList);
		map.put("relationList", relationList);
		return map;

	}

	@Override
	public Map<String, Object> uploadAndViewDocuments(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		Session session = (Session) getSession();
		int hinId = 0;
		int visitId = 0;
		int inpatientId = 0;
		String flag = "n";
		String message = "";
		String uploadFrom = "NA";
		boolean fileuploaded = false;

		if (generalMap.get("hinId") != null) {
			hinId = (Integer) generalMap.get("hinId");
		}
		if (generalMap.get("visitId") != null) {
			visitId = (Integer) generalMap.get("visitId");
		}
		if (generalMap.get("inpatientId") != null) {
			inpatientId = (Integer) generalMap.get("inpatientId");
		}
		if (generalMap.get("flag") != null) {
			flag = (String) generalMap.get("flag");
		}
		if (generalMap.get("uploadFrom") != null) {
			uploadFrom = (String) generalMap.get("uploadFrom");
		}

		String filename = "";
		if (generalMap.get("filename") != null) {
			filename = (String) generalMap.get("filename");
		}
		String uploadURL = "";
		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
		String comments = "";
		if (generalMap.get("comments") != null) {
			comments = (String) generalMap.get("comments");
		}

		if (flag.equalsIgnoreCase("y")) {

			String fileExtension = null;
			File file = null;
			try {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				System.out.println(uploadURL + " -- " + filename);
				file = new File(uploadURL + "/" + filename);
				System.out.println("path>>" + file.getPath());

				FileInputStream is = new FileInputStream(file);
				long length = file.length();
				ByteBuffer byteBuff = null;
				// int modLength=length/
				if (length > Integer.MAX_VALUE) {
					// File is too large
				}
				// Create the byte array to hold the data
				byte[] bytes = new byte[(int) length];
				int offset = 0;
				int numRead = 0;
				while (offset < bytes.length
						&& (numRead = is.read(bytes, offset, bytes.length
								- offset)) >= 0) {
					offset += numRead;

				}

				if (offset < bytes.length) {
					throw new IOException("Could not completely read file "
							+ file.getName());

				}
				is.close();

				UploadDocuments document = new UploadDocuments();
				document.setPatientDocument(bytes);
				int indexNo = filename.lastIndexOf(".");
				String actualfileName = filename.substring(0, indexNo);
				fileExtension = filename.substring(indexNo + 1);
				document.setFileName(actualfileName);
				document.setFileExtension(fileExtension);
				Date d = new Date();
				document.setUploadDate(d);

				if (visitId != 0) {
					Visit visit = new Visit();
					visit.setId(visitId);
					document.setVisit(visit);
				}
				if (inpatientId != 0) {
					Inpatient ip = new Inpatient();
					ip.setId(inpatientId);
					document.setInpatient(ip);
				}

				Patient hinNo = new Patient();
				hinNo.setId(hinId);
				document.setHin(hinNo);

				document.setDescription(comments);
				document.setConsentLetter("y");
				hbt.save(document);
				hbt.flush();
				hbt.refresh(document);
				message = "File uploaded Sucessfully";
				fileuploaded = true;

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error: " + e.getMessage());
				message = "File is not uploaded Sucessfully, some error is occurred";
				e.printStackTrace();
			}

		}

		uploadDocuments = session.createCriteria(UploadDocuments.class)
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("hin.Id", hinId))
				.add(Restrictions.eq("ConsentLetter", "y").ignoreCase()).list();
		map.put("visitId", visitId);
		map.put("inpatientId", inpatientId);
		map.put("uploadDocuments", uploadDocuments);
		map.put("message", message);
		map.put("fileuploaded", fileuploaded);
		return map;
	}

	@Override
	public Map<String, Object> referBackPatientToOpd(int opdSurgeryId,
			String submitForm, int userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		OpdSurgeryHeader opdSurgery = null;
		Visit visit = null;
		Patient patient = null;
		Users user = null;
		MasHospital hospital = null;
		MasEmployee employee = null;
		QueueManagment queue = null;
		int hinId = 0;
		int flag = 0;
		int visitId = 0;
		String hospitalCode = null;
		String referralCase = "Yes";
		String referType = "Internal";
		String admissionAdvised = "n";
		boolean episodeCloseCheck = false;
		int referral = 0;
		int refereddoctor = 0;
		String submitFrom = "5";
		int departmentId = 0;
		int empId = 0;
		String doctorName = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTimeDBFormat();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("modifiedDate");
		Boolean sameDayVisit = false;
		try {
			opdSurgery = (OpdSurgeryHeader) hbt.load(OpdSurgeryHeader.class,
					opdSurgeryId);
			visitId = opdSurgery.getVisit().getId();
			visit = (Visit) hbt.load(Visit.class, visitId);
			String dbdate = visit.getVisitDate().toString();
			if (dbdate.equals(currentDate)) {
				Query query = session
						.createQuery("select Id from QueueManagment where Visit.Id = :visitId");
				query.setParameter("visitId", visitId);
				int Id = (Integer) query.uniqueResult();
				queue = (QueueManagment) hbt.load(QueueManagment.class, Id);
				queue.setTokenStatus("w");
				visit.setVisitStatus("w");
				opdSurgery.setPacStatus("refer");
				opdSurgery.setBookingStatus("refer");
				opdSurgery.setStatus("r");
				hbt.saveOrUpdate(opdSurgery);
				hbt.saveOrUpdate(visit);
				hbt.saveOrUpdate(queue);
				sameDayVisit = true;
				map.put("sameDayVisit", sameDayVisit);
			} else {

				user = (Users) hbt.load(Users.class, userId);
				empId = user.getEmployee().getId();
				employee = (MasEmployee) hbt.load(MasEmployee.class, empId);
				doctorName = employee.getFirstName();
				doctorName = doctorName.trim();
				departmentId = user.getDepartment().getId();
				empId = user.getEmployee().getId();
				hinId = visit.getHin().getId();
				patient = (Patient) hbt.load(Patient.class, hinId);
				String cashRecieved = "n";
				int CurrentVisitNo = visit.getVisitNo();
				int hospitalId = visit.getHospital().getId();
				hospital = (MasHospital) hbt
						.load(MasHospital.class, hospitalId);
				hospitalCode = hospital.getHospitalCode();
				int deptCode = visit.getDepartment().getId();
				int age = patient.getPatientAge();
				String patientName = patient.getPFirstName();
				String hinNo = patient.getHinNo();
				String mobileNo = patient.getMobileNumber();
				opdSurgery.setPacStatus("refer");
				opdSurgery.setBookingStatus("refer");
				opdSurgery.setStatus("r");
				hbt.saveOrUpdate(opdSurgery);
				flag = 1;

				map.put("sameDayVisit", sameDayVisit);
				map.put("hinId", hinId);
				map.put("userId", userId);
				map.put("empId", empId);
				map.put("doctorName", doctorName);
				map.put("hinId", hinId);
				map.put("departmentId", departmentId);
				map.put("visitId", visitId);
				map.put("CurrentVisitNo", CurrentVisitNo);
				map.put("hospitalCode", hospitalCode);
				map.put("departmentId", deptCode);
				map.put("patientName", patientName);
				map.put("age", age);
				map.put("hinNo", hinNo);
				map.put("hospitalId", hospitalId);
				map.put("flag", flag);
				map.put("referralStatus", "y");
				map.put("submitForm", submitForm);
				map.put("cashRecieved", cashRecieved);
				map.put("onlineAppId", "");
				map.put("mobileNo", mobileNo);
				map.put("referType", referType);
				map.put("referralCase", referralCase);
				map.put("referdTo", null);
				map.put("admissionAdvised", admissionAdvised);
				map.put("episodeCloseCheck", episodeCloseCheck);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("flag", flag);
		}

		return map;
	}

	@Override
	public int getRefferedSession(int departmentId, int hospitalId) {

		Session session = (Session) getSession();
		List<MasSession> sessionList = new ArrayList<MasSession>();
		List<String> masSessionList = new ArrayList<String>();
		sessionList = session
				.createCriteria(MasSession.class)
				.createAlias("Hospital", "hospId")
				.createAlias("Department", "dept",
						CriteriaSpecification.LEFT_JOIN)
				.add(Restrictions.eq("hospId.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("dept.Id", departmentId)).list();

		if (sessionList.size() == 0) { // If department wise session is not
										// available then hospital wise session
										// will be used
			sessionList = session.createCriteria(MasSession.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.isNull("Department"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		}
		int sessionId = 0;
		for (MasSession ma : sessionList) {
			sessionId = ma.getId();
		}
		return sessionId;
	}

	private PharmacyLabQueue saveQueueNoForPharmacy(int departmentId,
			int hospitalId, Visit visit, String pharmacyLabStatus) {
		Criteria crt = null;
		boolean status = false;
		PharmacyLabQueue pharmacyLabQueue = null;
		Session session = (Session) getSession();

		crt = session.createCriteria(PharmacyLabQueue.class)
				.createAlias("Visit", "visit").createAlias("Visit.Hin", "hin")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("OpdDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("hin.Id", visit.getHin().getId()))
				.add(Restrictions.eq("PharmacyLabStatus", "P").ignoreCase());

		if (null != crt && null != crt.list() && crt.list().size() > 0) {
			status = true;
		}
		if (!status) {
			int maxQueueNoDepartWise = 0;
			maxQueueNoDepartWise = getqueueNoForDepartment(departmentId,
					hospitalId, visit.getVisitSession().getId()); // changed by
																	// amit das
																	// on
																	// 07-06-2017
			pharmacyLabQueue = new PharmacyLabQueue();
			pharmacyLabQueue.setTokenNo(maxQueueNoDepartWise + 1);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			pharmacyLabQueue.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			pharmacyLabQueue.setHospital(masHospital);

			pharmacyLabQueue.setTotalHospitalVisit(visit
					.getTotalHospitalVisit());

			pharmacyLabQueue.setVisit(visit);

			pharmacyLabQueue.setStatus("P");

			pharmacyLabQueue.setPharmacyLabStatus(pharmacyLabStatus);

			SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

			Date now = new Date();

			String opdTime = sdfTime.format(now);

			pharmacyLabQueue.setOpdDate(now);
			pharmacyLabQueue.setOpdTime(opdTime);

			session.save(pharmacyLabQueue);

		}
		return pharmacyLabQueue;
	}

	/**
	 * Method to generate the queue for Pharmacy and laboratory
	 * 
	 * @param departmentId
	 * @param hospitalid
	 */
	private int getqueueNoForDepartment(int departmentId, int hospitalId,
			int visitSessionId) {

		List<Integer> pharmacyLabQueue = new ArrayList<Integer>();
		long tokenNo = 0;
		MasHospital masHospital = null;
		Date date = new Date();
		String hospitalCode = null;
		Session session = (Session) getSession();
		System.out.println("departmentId " + departmentId);
		System.out.println("hospitalId " + hospitalId);

		// added by amit das on 07-06-2017
		List<Integer> tokenSequenceValue = new ArrayList<Integer>();
		String schName = "public"; // added by amit das on 08-05-2017

		masHospital = (MasHospital) session.get(MasHospital.class, hospitalId);

		if (masHospital != null)
			hospitalCode = masHospital.getHospitalCode();

		String tokenSequenceName = "token_" + departmentId + "_" + hospitalCode
				+ "_" + visitSessionId + "_seq";

		// added by amit das on 08-05-2017
		String qury = "SELECT COUNT(*) FROM information_schema.sequences WHERE sequence_schema='"
				+ schName + "' AND sequence_name='" + tokenSequenceName + "'";

		Query q = session.createSQLQuery(qury);

		BigInteger i = (BigInteger) q.list().get(0);

		if (i.intValue() == 1) {
			qury = "SELECT nextval('" + tokenSequenceName + "')";
			q = session.createSQLQuery(qury);
			System.out.println("qury " + qury);
			Iterator<BigInteger> iter;
			iter = Collections.<BigInteger> emptyList().iterator();
			iter = (Iterator<BigInteger>) q.list().iterator();
			tokenNo = iter.next().longValue();

			tokenNo = tokenNo - 1;
			System.out.println("tokenSequenceName tokenNo " + tokenNo);

		} else {

			qury = "select max(v.TokenNo) from PharmacyLabQueue v where v.OpdDate=:date and v.Department.Id=:dept and v.Hospital.Id=:h ";

			Query query = session.createQuery(qury);
			query.setParameter("date", new java.sql.Date(date.getTime()));
			query.setParameter("dept", departmentId);
			query.setParameter("h", hospitalId);
			// query.setParameter("appointmentType", "D");
			// query.setParameter("visitSessionId", visitSessionId);

			/* Visit v = (Visit) query.uniqueResult(); */
			pharmacyLabQueue = query.list();
			if (pharmacyLabQueue.get(0) != null) {
				tokenNo = pharmacyLabQueue.get(0);
			}
		}
		return (int) tokenNo;
	}

	@Override
	public Map<String, Object> submitOtProcedureNotesEntryJsp(Box box,
			List<Integer> employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSurgeryDoctors(int otSignOutId) {
		Session session = (Session) getSession();
		String sqlQry = "select mas_employee.emp_name,ot_sign_out_item_consume.qty_used, ot_sign_out.ot_sign_out_id as no,ot_sign_out.name_of_operative_procedure,ot_sign_out.specimen_identified,ot_sign_out.any_equip_problem,ot_sign_out.key_concern_for_recovery,(coalesce(patient.p_first_name,' ')||' '||coalesce(patient.p_middle_name,' ')||' '||coalesce(patient.p_last_name,' ')) as patient,mas_store_item.nomenclature,patient.age,patient.hin_no,mas.administrative_sex_name from ot_sign_out_item_consume left outer join ot_sign_out on ot_sign_out.ot_sign_out_id=ot_sign_out_item_consume.ot_sign_out_id left outer join ot_booking on ot_booking.booking_id=ot_sign_out.ot_booking_id left outer join ot_book_surgeon on ot_book_surgeon.booking_id=ot_booking.booking_id left outer join mas_employee on mas_employee.employee_id=ot_book_surgeon.employee_id left outer join patient on patient.hin_id=ot_sign_out.hin_id left outer join mas_store_item on mas_store_item.item_id=ot_sign_out_item_consume.item_id left outer join mas_administrative_sex mas on mas.administrative_sex_id=patient.sex_id where ot_sign_out.ot_sign_out_id="
				+ otSignOutId;
		SQLQuery query = session.createSQLQuery(sqlQry);
		List result = query.list();
		String Doctors = "";
		if (result != null && result.size() > 0) {

			for (Object doc : result) {
				Object[] docObj = (Object[]) doc;
				Doctors += docObj[0] + ",";
			}
		}

		return Doctors.substring(0, Doctors.length() - 1);
	}
	public Map<String, Object>saveOtPostAnaesthesiaFinalReadingJsp(
			Map<String, Object> mapForDS){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		String msg="fail";
		int otBooking=0;
		int hospitalId=0;
		int painId=0;
		String bodyPart=null;
		OtPostAnaesthisiaPainManagement opapm=null;
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		if (mapForDS.get("otBookingId") != null) {
			otBooking = (Integer) mapForDS.get("otBookingId");
		}
		if (mapForDS.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		}
		String flag="";
		if (mapForDS.get("flag") != null) {
			flag = (String) mapForDS.get("flag");
		}
		/*for(int i=0;i<painGridSize;i++){
			opapm=null;
			if (mapForDS.get("painId"+i) != null) {
				painId = (Integer) mapForDS.get("painId"+i);	
			  }
			if (mapForDS.get("bodyPart"+i) != null) {
				bodyPart = (String) mapForDS.get("bodyPart"+i);	
			  }
				opapm = (OtPostAnaesthisiaPainManagement) hbt.load(
						OtPostAnaesthisiaPainManagement.class, painId);
			    opapm.setPartName(bodyPart); 
			    opapm.setTimeOfUpdate("f");
		}*/
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            Criteria crit = session.createCriteria(OtPostAnaesthisiaPainManagement.class)
	            		.createAlias("OtPostAnaesthisiaProcedure", "opap")
	    				.createAlias("Hospital", "hosp")
	    				.add(Restrictions.eq("opap.Id",otBooking))
	    				.add(Restrictions.eq("hosp.Id", hospitalId));
	            // Here is updated code
	            ScrollableResults items = crit.scroll();
	            int count=0;
	            while ( items.next() ) {
	            	OtPostAnaesthisiaPainManagement anaesthisiaPainManagement = (OtPostAnaesthisiaPainManagement)items.get(0);
	            	anaesthisiaPainManagement.setStatusOfReading("f");
	                hbt.saveOrUpdate(anaesthisiaPainManagement);
	                if ( ++count % 100 == 0 ) {
	                	session.flush();
	                	session.clear();
	                }
	            }
	            msg="success";
	            tx.commit();
	        } catch (HibernateException asd) {
	            if (tx != null) {
	                tx.rollback();
	            }
	           
	        } finally {
	        	session.close();
	        }
	        map.put("msg", msg);
	        return map;
	}
	public Map<String, Object> saveOtPostAnaesthesiaReadingJsp(
			Map<String, Object> mapForDS){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTimeDBFormat();
		String currentDate = (String) utilMap.get("currentDate");
		String time =null;
		Date date1 = new Date();
		Date date=HMSUtil.convertStringyyyyMMddTypeToDateType(currentDate);
		time=HMSUtil.convertDateToStringOnlyTime(date1);
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String bodyPart = "";
		String msg="";
		if (mapForDS.get("bodyPart") != null) {
			bodyPart = (String) mapForDS.get("bodyPart");
		}
		int periscopeValue=0;
		if (mapForDS.get("periscopeValue") != null) {
			periscopeValue = (Integer) mapForDS.get("periscopeValue");
		}
		String periscopeName=null;
		if (mapForDS.get("periscopeName") != null) {
			periscopeName = (String) mapForDS.get("periscopeName");
		}
		int otBookingId=0; 
		if (mapForDS.get("otBookingId") != null) {
			otBookingId = (Integer) mapForDS.get("otBookingId");
		}
		int hospitalId=0; 
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		int userId=0; 
		if (mapForDS.get("userId") != null) {
			userId = (Integer) mapForDS.get("userId");
		}
		OtPostAnaesthisiaPainManagement opapm= new OtPostAnaesthisiaPainManagement();
		MasHospital mh=new MasHospital();
		MasEmployee user=new MasEmployee();
		OtBooking opap=new OtBooking();
		mh.setId(hospitalId);
		opap.setId(otBookingId);
		user.setId(userId);
		opapm.setAddEditBy(user);
		opapm.setOtPostAnaesthisiaProcedure(opap);
		opapm.setHospital(mh);
		opapm.setPartName(bodyPart);
		opapm.setPatientAdmitStatus("a");
		opapm.setPeriscopeName(periscopeName);
		opapm.setStatusOfReading("i");
		opapm.setPeriscopeValue(periscopeValue);
		opapm.setDateOfUpdate(date);
		opapm.setTimeOfUpdate(time);
		int inerval=getCurrentInterval(otBookingId,hospitalId);
		List<OtPostAnaesthisiaPainManagement> painGridList=new ArrayList<OtPostAnaesthisiaPainManagement>();
		opapm.setPeriod(inerval);
		try{
		hbt.saveOrUpdate(opapm);
		painGridList=getPainGridList(otBookingId,hospitalId);
		map.put("painGridList", painGridList);
		msg="true";
		map.put("msg", msg);
		return map;
		}catch(Exception e){
			msg="false";
			map.put("msg", msg);
			return map;
		}
		
	}
	public List getPainGridList(int otBookingId,int hospitalId){
		Criteria crt = null;
		int size=0;
		List<OtPostAnaesthisiaPainManagement> opapmList = new ArrayList<OtPostAnaesthisiaPainManagement>();
		Session session = (Session) getSession();
		crt = session.createCriteria(OtPostAnaesthisiaPainManagement.class)
				.createAlias("OtPostAnaesthisiaProcedure", "opap")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("opap.Id",otBookingId))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("StatusOfReading", "i").ignoreCase());
				
		    try{
			opapmList=crt.list();
			
		}catch(Exception e){
			
				
		}
		    return opapmList;	
		
	}
	public Integer getCurrentInterval(int otBookingId,int hospitalId){
		Criteria crt = null;
		int size=0;
		List<OtPostAnaesthisiaPainManagement> opapmList = new ArrayList<OtPostAnaesthisiaPainManagement>();
		Session session = (Session) getSession();
		crt = session.createCriteria(OtPostAnaesthisiaPainManagement.class)
				.createAlias("OtPostAnaesthisiaProcedure", "opap")
				.createAlias("Hospital", "hosp")
				.addOrder(Order.desc("Period"))
				.add(Restrictions.eq("opap.Id",otBookingId))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("StatusOfReading", "f").ignoreCase())
				.setMaxResults(1);
		    try{
			opapmList=crt.list();
			for(OtPostAnaesthisiaPainManagement opapm:opapmList)
			{
			size=opapm.getPeriod();
			size=size+1;
			}
			return size;
		}catch(Exception e){
			
			return 1;	
		}
		
		
	}
	public Map<String, Object>showPatientAllPeriscopeReading(
			Map<String, Object> mapForDS){
		Map<String, Object> map = new HashMap<String, Object>();
		int otBookingId=0; 
		if (mapForDS.get("otBookingId") != null) {
			otBookingId = (Integer) mapForDS.get("otBookingId");
		}
		int hospitalId=0; 
		if (mapForDS.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDS.get("hospitalId");
		}
		String hinNo="";
		if (mapForDS.get("hinNo") != null) {
			hinNo = (String) mapForDS.get("hinNo");
		}
		Criteria crt = null;
		int size=0;
		List<Patient> patientList = new ArrayList<Patient>();
		List<OtPostAnaesthisiaPainManagement> opapmList = new ArrayList<OtPostAnaesthisiaPainManagement>();
		Session session = (Session) getSession();
		crt = session.createCriteria(OtPostAnaesthisiaPainManagement.class)
				.createAlias("OtPostAnaesthisiaProcedure", "opap")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("opap.Id",otBookingId))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("StatusOfReading", "f").ignoreCase());
				/*.setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("Period")));*/
		
		    try{
			opapmList=crt.list();
			patientList = (List<Patient>) session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
			
		}catch(Exception e){
		
		}
		    map.put("painGridList", opapmList);	
			map.put("patientList", patientList)	;
			return map;
	}
	
	@Override
	public Map<String, Object> getPacHistory(int orderId) {
		Session session = (Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		String sqlQry="SELECT ot_pre_anesthesia_details.smoking_alcohol AS smoking_alcohol,ot_pre_anesthesia_details.prev_treatment_surgery AS treatment_surgery,ot_pre_anesthesia_details.pulse AS pulse,ot_pre_anesthesia_details.pallor AS pallor,ot_pre_anesthesia_details.cyanosis AS cyanosis,ot_pre_anesthesia_details.clubbing AS clubbing,ot_pre_anesthesia_details.icetrus AS icetrus,ot_pre_anesthesia_details.oedema AS oedema,ot_pre_anesthesia_details.spine AS spine,ot_pre_anesthesia_details.thyroid AS Thyroid,ot_pre_anesthesia_details.breath_sound AS breath_sound,ot_pre_anesthesia_details.adv_sound AS adv_sound,ot_pre_anesthesia_details.abdomen AS abdomen,ot_pre_anesthesia_details.liver AS liver,ot_pre_anesthesia_details.spleen AS spleen,ot_pre_anesthesia_details.asa_grade AS asa_grade,ot_pre_anesthesia_details.blood AS blood,ot_pre_anesthesia_details.s1 AS s1,ot_pre_anesthesia_details.s2 AS s2,ot_pre_anesthesia_details.s3 AS s3,ot_pre_anesthesia_details.s4 AS s4,ot_pre_anesthesia_details.order_no AS order_no,ot_pre_anesthesia_details.pac_date AS pac_date,ot_pre_anesthesia_details.patient_type AS patient_type,ot_pre_anesthesia_details.Anesthtic_technique AS Anesthtic_technique,patient.service_no AS service_no,(coalesce(patient.p_first_name,' ')||'  '||coalesce(patient.p_middle_name,' ')||'  '||coalesce(patient.p_last_name,' ')) as patient,(coalesce(patient.s_first_name,' ')||'  '||coalesce(patient.s_middle_name,' ')||'  '||coalesce(patient.s_last_name,' ')) as s_patient,patient.age AS age,patient.hin_no AS AShin_no,mas_rank.rank_name AS rank_name,mas_relation.relation_name AS relation,mas_administrative_sex.administrative_sex_name AS sex,mas_unit.unit_name AS unit_name,visit.weight AS weight,mas_hospital.hospital_name AS mas_hospital_hospital_name,ot_pre_anesthesia_details.airway AS airway,ot_pre_anesthesia_details.bp AS bp,ot_pre_anesthesia_details.nourishment AS nourishment,ot_pre_anesthesia_details.venous_access AS venous_access,ot_pre_anesthesia_details.instructions AS ot_pre_anesthesia_details_instructions,ot_pre_anesthesia_details.anashteic_details as anasthetic_details,CASE  ot_pre_anesthesia_details.fit_for_surgery WHEN 'y' THEN 'Yes' WHEN 'n' THEN 'Pending' else '' END as fitforsurgery,ot_pre_anesthesia_details.cardio_vascular_system as cardio_vascular_remarks FROM patient patient RIGHT OUTER JOIN ot_pre_anesthesia_details ot_pre_anesthesia_details ON patient.hin_id = ot_pre_anesthesia_details.hin_id LEFT OUTER JOIN mas_rank mas_rank ON patient.rank_id = mas_rank.rank_id LEFT OUTER JOIN mas_relation mas_relation ON patient.relation_id = mas_relation.relation_id LEFT OUTER JOIN mas_administrative_sex mas_administrative_sex ON patient.sex_id = mas_administrative_sex.administrative_sex_id LEFT OUTER JOIN mas_unit mas_unit ON patient.unit_id = mas_unit.unit_id LEFT OUTER JOIN visit visit ON ot_pre_anesthesia_details.visit_id = visit.visit_id LEFT OUTER JOIN mas_hospital mas_hospital ON ot_pre_anesthesia_details.hospital_id = mas_hospital.hospital_id WHERE ot_pre_anesthesia_details.order_no ="+orderId;
		SQLQuery query = session.createSQLQuery(sqlQry);
		List result = query.list();
		Object[] pacHistoryObj=null;
		if (result != null && result.size() > 0) {
			for (Object pacHistory : result) {
				pacHistoryObj = (Object[]) pacHistory;
			}
			map.put("Smoking",pacHistoryObj[0]);
			map.put("Previous Treatment",pacHistoryObj[1]);
			map.put("Pulse",pacHistoryObj[2]);
			map.put("Icetrus",pacHistoryObj[6]);
			map.put("Nourishment",pacHistoryObj[38]);
			map.put("Pallor",pacHistoryObj[3]);
			map.put("Oedema",pacHistoryObj[7]);
			map.put("BP",pacHistoryObj[37]);
			map.put("Cyanosis",pacHistoryObj[4]);
			map.put("Spine",pacHistoryObj[8]);
			map.put("Airway",pacHistoryObj[36]);
			map.put("Clubbing",pacHistoryObj[5]);
			map.put("Thyroid",pacHistoryObj[9]);
			map.put("Venus Access",pacHistoryObj[39]);
			map.put("Breath Sound",pacHistoryObj[10]);
			map.put("Adv Sound",pacHistoryObj[11]);
			map.put("S1",pacHistoryObj[17]);
			map.put("S2",pacHistoryObj[18]);
			map.put("S3",pacHistoryObj[19]);
			map.put("S4",pacHistoryObj[20]);
			map.put("Remarks",pacHistoryObj[43]);
			map.put("Abdomen",pacHistoryObj[12]);
			map.put("Liver",pacHistoryObj[13]);
			map.put("Spleen",pacHistoryObj[14]);
			map.put("Anaesthetic Technique",pacHistoryObj[24]);
			map.put("Patient Type",pacHistoryObj[23]);
			map.put("ASA Gade",pacHistoryObj[15]);
			map.put("Fit for Surgery",pacHistoryObj[42]);
			map.put("Blood Component",pacHistoryObj[16]);
			map.put("Any Special",pacHistoryObj[40]);
			
		}
		map.put("pacHistoryObj",pacHistoryObj);
		
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> getPreAnesthesiaHistory(int bookingId) {
		Session session = (Session) getSession();
		
		Map<String,Object> map=new HashMap<String,Object>();
		List<OtPreAnaesthesiaProcNotesMain> preAnesthesiaList=new ArrayList<OtPreAnaesthesiaProcNotesMain>();
		List<OtPreAnaesthesiaProNotesSub> preAnesthesiaNotesSubList=new ArrayList<OtPreAnaesthesiaProNotesSub>();
		
		preAnesthesiaList=session.createCriteria(OtPreAnaesthesiaProcNotesMain.class).add(Restrictions.eq("Booking.Id", bookingId)).list();
		
		if(preAnesthesiaList.size()>0){
			preAnesthesiaNotesSubList=(List<OtPreAnaesthesiaProNotesSub>) session.createCriteria(OtPreAnaesthesiaProNotesSub.class).add(Restrictions.eq("PreAnaesthesiaMain.Id", preAnesthesiaList.get(0).getId())).list();
			map.put("preAnesthesiaData",preAnesthesiaList.get(0));
		}
		if(preAnesthesiaNotesSubList.size()>0){
			map.put("preAnesthesiaNotesSubList", preAnesthesiaNotesSubList);
		}
		
		return map;
	}
	
	@Override
	public Map<String, Object> getYearlySerialNo(int otBookingId) {
		Session session = (Session) getSession();
		String yearlySerialNo="";
		List<OtProcedureNotesEntryHeader> otProcNotesHeader=new ArrayList<OtProcedureNotesEntryHeader>();
		Map<String,Object> map=new HashMap<String,Object>();
		
		otProcNotesHeader=session.createCriteria(OtProcedureNotesEntryHeader.class).add(Restrictions.eq("Booking.Id", otBookingId)).list();
		
		if(otProcNotesHeader.size()>0){
			yearlySerialNo=otProcNotesHeader.get(0).getYearlySerialNo();
			map.put("yearlySerialNo", yearlySerialNo);
		}
		
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> showOpPreAnesthesiaForm(
			Map<String, Object> mapForDS) {
		
		Session session = (Session) getSession();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		Map<String,Object> map=new HashMap<String,Object>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<OpdInstructionTreatment>instrunction=new ArrayList<OpdInstructionTreatment>();
		List<RouteOfAdministration>route=new ArrayList<RouteOfAdministration>();
		
		Map<String,String> labResultMap=new HashMap<String,String>();

		int opdSurgeryId = (Integer) mapForDS.get("opdSurgeryId");
				int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
				int visitId = 0;
				opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Id", opdSurgeryId)).list();
				OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList
						.get(0);
			map.put("opdSurgeryHeader", opdSurgeryHeader);
			int hinId=0;
			if(opdSurgeryHeader.getVisit()!=null){
				hinId=opdSurgeryHeader.getVisit().getHin().getId();
			}else if(opdSurgeryHeader.getInpatient()!=null){
				hinId=opdSurgeryHeader.getInpatient().getHin().getId();
			}
			
			List<OpdPatientAllergyM> allergyMList=new ArrayList<OpdPatientAllergyM>();
			allergyMList=session.createCriteria(OpdPatientAllergyM.class)
					.add(Restrictions.eq("Hin.Id", hinId)).list();
			if(allergyMList.size()>0){
				int allergyId=0;
				List<OpdPatientAllergyT> allergyTList=new ArrayList<OpdPatientAllergyT>();
				allergyTList=session.createCriteria(OpdPatientAllergyT.class)
						.add(Restrictions.eq("OpdPatientAllergy.Id", allergyId))
						.add(Restrictions.eq("Status", 'y').ignoreCase()).list();
				String allergy="";
				for(OpdPatientAllergyT allergyDetails:allergyTList){
					allergy=allergy+","+allergyDetails.getAllergen();
				}
				if(allergy.length()>0 && allergy.charAt(0)==','){
					if(allergy.charAt(allergy.length()-1)==','){
						allergy=allergy.substring(1, allergy.length()-1);
					}else{
						allergy=allergy.substring(1);
					}
				}else if(allergy.length()>0 && allergy.charAt(allergy.length()-1)==','){
					allergy=allergy.substring(0, allergy.length()-1);
				}
				map.put("AllergyData", allergy);
			}
			
			List<PatientPrescriptionDetails> patientPrescriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
			
				List<Visit> visitList = new ArrayList<Visit>();
				visitList = session.createCriteria(Visit.class)
						.add(Restrictions.eq("Hin.Id", hinId))
						.addOrder(Order.desc("Id")).setMaxResults(1).list();
				for (Visit visit : visitList) {
					visitId = visit.getId();
				}	
			
			
			patientPrescriptionDetailList = session
					.createCriteria(PatientPrescriptionDetails.class)
					.createAlias("Prescription", "Prescription")
					.createAlias("Prescription.Visit", "visit")
					.add(Restrictions.eq("visit.Id", visitId)).list();
			map.put("patientPrescriptionDetailList", patientPrescriptionDetailList);
			
			frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("frequencyList", frequencyList);
			
			instrunction = session.createCriteria(OpdInstructionTreatment.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
			map.put("masInstructionMasterList", instrunction);
			route=session.createCriteria(RouteOfAdministration.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
			map.put("routeOfAdministrationList", route);
			
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
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
			
			map.put("serviceCenters", departmentList);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-10);
			Date myDate = cal.getTime();
			

			Map<String,Integer> chargeCodeMap=new HashMap<String,Integer>();
			chargeCodeMap.put("HIV", 136748);
			chargeCodeMap.put("HBSAG", 136886);
			chargeCodeMap.put("HB", 136395);
			chargeCodeMap.put("PCV", 136606);
			chargeCodeMap.put("PT", 136900);
			//chargeCodeMap.put("INR", 136900);
			//chargeCodeMap.put("APTT", 136900);
			chargeCodeMap.put("RBS", 136866);
			chargeCodeMap.put("HCV", 136932);
			chargeCodeMap.put("TC", 136864);
			chargeCodeMap.put("BT", 136880);
			//chargeCodeMap.put("CT", 136880); BT and CT are Same Column in DB
			/*chargeCodeMap.put("DCP", 136880);
			chargeCodeMap.put("DCL", 136880);
			chargeCodeMap.put("DCE", 136880);*/
			chargeCodeMap.put("BloodGroup", 136881);
			chargeCodeMap.put("Platelet Count", 136402);
			chargeCodeMap.put("Blood Urea", 136869);
			chargeCodeMap.put("Sr.Creatinine", 136062);
			//chargeCodeMap.put("Cr.Clearance", 136062); need to calculate (Not Possible)
			chargeCodeMap.put("S.Bilirubin", 136870);
			chargeCodeMap.put("Total Protein", 137015);
			chargeCodeMap.put("Albumin", 136072);
			chargeCodeMap.put("Globulin", 136085);
			chargeCodeMap.put("Electrolytes", 136913);	
			chargeCodeMap.put("Na", 136908);
			chargeCodeMap.put("Potassium", 136909);
			chargeCodeMap.put("Ca", 136069);
			chargeCodeMap.put("Magnesium", 136090);
			chargeCodeMap.put("SGOT", 136871);
			chargeCodeMap.put("SGPT", 136872);
			chargeCodeMap.put("TFT", 137013);
			chargeCodeMap.put("Urine Albumin", 136874);
			chargeCodeMap.put("Urine Sugar", 136875);
			chargeCodeMap.put("Urine Deposits", 136876);
			/*chargeCodeMap.put("PFT", 136876);
			chargeCodeMap.put("MRI", 136876);
			chargeCodeMap.put("CT", 136876);
			chargeCodeMap.put("USG", 136876);
			chargeCodeMap.put("X-ray Chest", 136876);
			chargeCodeMap.put("X-ray Neck", 136876);
			chargeCodeMap.put("ECG", 136876);
			chargeCodeMap.put("Echo", 136876);
			chargeCodeMap.put("TMT", 136876);*/
			
			for(Map.Entry<String, Integer> chargeCodes:chargeCodeMap.entrySet()){
				int chargeCodeId=chargeCodes.getValue();
				
				List<DgResultEntryDetail> labResultDetails=session.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "resultHeader")
						.createAlias("ChargeCode", "ChargeCode")
						.createAlias("resultHeader.Hin", "patient")
						.add(Restrictions.eq("Validated", 'v').ignoreCase())
						.add(Restrictions.eq("ChargeCode.Id", chargeCodeId))
						.add(Restrictions.eq("patient.Id", hinId))
						.add(Restrictions.ge("resultHeader.ResultDate", myDate))
						.list();
				if(labResultDetails.size()>0){
					labResultMap.put(chargeCodes.getKey(), labResultDetails.get(0).getResult());
				}
				
			}
			
		map.put("labResultMap", labResultMap);
		
		Patient patient=(Patient)session.load(Patient.class, hinId);
		if(patient.getMember()!=null){
			int memberId=patient.getMember().getId();
			String qry="select disease_id from ph_disease_registration where member_id ="+memberId;
			SQLQuery sqlQuery =session.createSQLQuery(qry);
			List<Object[]> results = sqlQuery.list();
			if(results.size()>0){
				int diseaseId=Integer.parseInt(String.valueOf(results.get(0)));
				if(diseaseId>0){
					String query="select value1 from ph_disease_registration_details where  value1 ILIKE '%Diabetes%' and details_id ="+diseaseId;
					SQLQuery sqlQuery2 =session.createSQLQuery(query);
					List<Object[]> results2 = sqlQuery2.list();
					if(results2.size()>0){
						map.put("Diabetes", String.valueOf(results2.get(0)));
					}
				}
			}
		}
		
		return map;
	}
	
	public List<MasStoreItem> getItemIdListFromPVMS(String pvmsNo) {
		List<MasStoreItem> itemIdList = new ArrayList<MasStoreItem>();
		Session session = (Session) getSession();
		try {
			itemIdList = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", pvmsNo)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemIdList;
	}
	
	boolean checkForInsulinInjection(int itemId){
		
		boolean insulinStatus=false;
		Session session = null;
		session = (Session) getSession();
		MasStoreItem masStoreItem=null;
		masStoreItem=(MasStoreItem) session.load(MasStoreItem.class,itemId);
		if(null !=masStoreItem ){
			if(null !=masStoreItem.getInsulinInjection() && masStoreItem.getInsulinInjection().equalsIgnoreCase("y")){
				insulinStatus=true;
			}
		}
		
		return insulinStatus;
	}
	
	public synchronized String generateOrderNumber() {
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
	
	private PharmacyLabQueue saveQueueNoForPharmacyAndLab(int departmentId,int hospitalId,Visit visit,String pharmacyLabStatus,DgOrderhd dgOrderHd){
		boolean status=false;
		
		Session session = (Session) getSession();
		PharmacyLabQueue pharmacyLabQueue=null;
		Criteria crt=null;
		int tokenNo=0;
		
		 crt=session.createCriteria(PharmacyLabQueue.class)
				.createAlias("Visit", "visit")
				.createAlias("Visit.Hin", "hin")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("OpdDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("hin.Id", visit.getHin().getId()))
				.add(Restrictions.eq("Status", "P").ignoreCase())
				.add(Restrictions.eq("PharmacyLabStatus", "L").ignoreCase());
		 
		 if(null !=crt && null !=crt.list() && crt.list().size()>0){
			 status=true;
			 PharmacyLabQueue pharmacyLabQueueList=(PharmacyLabQueue) crt.list().get(0);
			 tokenNo=pharmacyLabQueueList.getTokenNo();
		 }
		 pharmacyLabQueue=new PharmacyLabQueue();
		int maxQueueNoDepartWise=0;
		if(status){
			pharmacyLabQueue.setTokenNo(tokenNo);
		}
		else{
		maxQueueNoDepartWise=getqueueNoForDepartment(departmentId,hospitalId,visit.getVisitSession().getId()); //changed by amit das on 07-06-2017
		pharmacyLabQueue.setTokenNo(maxQueueNoDepartWise+1);
		}
		
		MasDepartment masDepartment=new MasDepartment();
		masDepartment.setId(departmentId);
		pharmacyLabQueue.setDepartment(masDepartment);
		
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		pharmacyLabQueue.setHospital(masHospital);
		
		
		pharmacyLabQueue.setTotalHospitalVisit(visit.getTotalHospitalVisit());
		
		pharmacyLabQueue.setVisit(visit);
		
		pharmacyLabQueue.setStatus("P");
		
		pharmacyLabQueue.setPharmacyLabStatus(pharmacyLabStatus);
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

	    Date now = new Date();

	    String opdTime = sdfTime.format(now);
	    
		pharmacyLabQueue.setOpdDate(now);
		pharmacyLabQueue.setOpdTime(opdTime);
		
		if(null != dgOrderHd){
			pharmacyLabQueue.setDgOrderhdId(dgOrderHd);
		}
		
		session.save(pharmacyLabQueue);
		
	 return pharmacyLabQueue;
	
	}
	
	private PharmacyLabQueue saveQueueNoForRadio(int departmentId,int hospitalId,Visit visit,String pharmacyLabStatus){
		
		
		Session session = (Session) getSession();
		
		boolean status=false;
		PharmacyLabQueue pharmacyLabQueue=null;
		Criteria crt=null;
		
		 crt=session.createCriteria(PharmacyLabQueue.class)
				.createAlias("Visit", "visit")
				.createAlias("Visit.Hin", "hin")
				.createAlias("Hospital", "hosp")
				.add(Restrictions.eq("OpdDate", new Date()))
				.add(Restrictions.eq("hosp.Id", hospitalId))
				.add(Restrictions.eq("hin.Id", visit.getHin().getId()))
				.add(Restrictions.eq("Status", "P").ignoreCase())
				.add(Restrictions.eq("PharmacyLabStatus", "R").ignoreCase());
		
		 if(null !=crt && null !=crt.list() && crt.list().size()>0){
			 status=true;
		 }
		if(!status){
		int maxQueueNoDepartWise=0;
		maxQueueNoDepartWise=getqueueNoForDepartment(departmentId,hospitalId,visit.getVisitSession().getId());
		
		 pharmacyLabQueue=new PharmacyLabQueue();
		pharmacyLabQueue.setTokenNo(maxQueueNoDepartWise+1);
		
		MasDepartment masDepartment=new MasDepartment();
		masDepartment.setId(departmentId);
		pharmacyLabQueue.setDepartment(masDepartment);
		
		MasHospital masHospital=new MasHospital();
		masHospital.setId(hospitalId);
		pharmacyLabQueue.setHospital(masHospital);
		
		
		pharmacyLabQueue.setTotalHospitalVisit(visit.getTotalHospitalVisit());
		
		pharmacyLabQueue.setVisit(visit);
		
		pharmacyLabQueue.setStatus("P");
		
		pharmacyLabQueue.setPharmacyLabStatus(pharmacyLabStatus);
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

	    Date now = new Date();

	    String opdTime = sdfTime.format(now);
	    
		pharmacyLabQueue.setOpdDate(now);
		pharmacyLabQueue.setOpdTime(opdTime);
		
		/*if(null != dgSampleCollectionHeader){
			pharmacyLabQueue.setDgSampleCollectionHd(dgSampleCollectionHeader);
		}
		*/
		session.save(pharmacyLabQueue);
		
	} return pharmacyLabQueue;
}
	
	public Map<String, Object> getMasChargeCodeFromChargeId(int chargeId) {
		Session session = (Session) getSession();
		List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			Criteria crit = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Id", chargeId));
			masChargeList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		MasChargeCode masChargeCode = masChargeList.get(0);

		map.put("masChargeCode", masChargeCode);

		return map;
	}
	
	public String generateDiagNumber(int subChargeId, int hospitalId,DgOrderdt dgOrderdt,String subChargeCode,Users users) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
		List<DgSampleCollectionDetails> dgDetailsList = new ArrayList<DgSampleCollectionDetails>();

		Session session = (Session) getSession();

		try {
			diagSeqNoList = session.createCriteria(DiagParam.class)
					.createAlias("SubCharge", "sc").createAlias("Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("sc.Id", subChargeId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		// dgDetailsList =
		// session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.).list();

		dgDetailsList = getHibernateTemplate()
				.find("select dg from DgSampleCollectionDetails dg where Id = (select max(Id) from DgSampleCollectionDetails)  ");
		String lastDiagNo = "";
		if (dgDetailsList.size() > 0) {
			for (DgSampleCollectionDetails collDetails : dgDetailsList) {
				lastDiagNo = collDetails.getDiagNo();
			}
			if (lastDiagNo == null) {
				lastDiagNo = "";
			}
		}
		String lastMnt = "";
		String lastYr = "";

		
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
				if(null !=subcharge && !subcharge.endsWith("")){
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
				}
				System.out.println("diagSeqNo "+diagSeqNo);
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

		}else{
			DiagParam dgParam= new DiagParam();
			int subChargecodeId = 0;
			subChargecodeId = dgOrderdt.getSubChargeid().getId();
			
			MasMainChargecode maincharge1 = new MasMainChargecode();
			maincharge1.setId(dgOrderdt.getMainChargecode().getId());
			dgParam.setMainCharge(maincharge1);
			MasSubChargecode subCharge1 = new MasSubChargecode();
			subCharge1.setId(dgOrderdt.getSubChargeid().getId());
			dgParam.setSubCharge(subCharge1);
			
			dgParam.setSeqNo(1);
			dgParam.setPrefix(subChargeCode.substring(0, 2));
			dgParam.setCriteria("C");
			dgParam.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
			dgParam.setLastChgTime(time);
			dgParam.setLastChgBy(users);
			if(hospitalId>0){
				MasHospital hospital=new MasHospital();
				hospital.setId(hospitalId);
				dgParam.setHospital(hospital);
			}
			
			hbt.save(dgParam); 
			
			dgSeqNo = 1;
			
			//if (criteria.equalsIgnoreCase("c")) {
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
		
		}
		System.out.println(" diagSeqNo "+diagSeqNo);
		return diagSeqNo;
	}
	
	public int getTransactionSequenceNoForPrescriptionNo(Map mapForDS) {
		
		Session session = (Session) getSession();

	int userId = (Integer) mapForDS.get("userId");
	int hospitalId = (Integer) mapForDS.get("hospitalId");
	String userName = (String) mapForDS.get("userName");
	List<TransactionSequence> orderNoList = new ArrayList<TransactionSequence>();
	String tableName = "PATIENT_PRESCRIPTION_HEADER";
	int currentYearInt=-1;
	int orderNo=0;
	int oldYear=-1;
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");

	String currentYear = date.substring(date.lastIndexOf("/") + 1);
	currentYearInt=Integer.parseInt(currentYear);
	String currentMonth = date.substring(date.indexOf("/") + 1, date
			.lastIndexOf("/"));
	TransactionSequence tranSeq=new TransactionSequence();
	tranSeq.setTransactionSequenceName("PrescriptionNo");
	tranSeq.setTransactionPrefix("PRNO");
	tranSeq.setTablename(tableName);
	tranSeq.setCreatedby(userName);
	tranSeq.setStatus("y");
	//MasServiceType masserType=new MasServiceType();
	tranSeq.setServiceType(null);
	tranSeq.setMonth(currentYearInt);
	//Transaction tx = null;

	try {
		//	tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {

			Criteria crit = session.createCriteria(TransactionSequence.class)
			.add(Restrictions.eq("Tablename", tableName))
			.add(Restrictions.eq("Hospital.Id", hospitalId));
			orderNoList = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if(orderNoList!=null && orderNoList.size()>0)
		{
			TransactionSequence transactionSequence = (TransactionSequence)hbt.load(TransactionSequence.class, orderNoList.get(0).getId());
			orderNo = transactionSequence.getTransactionSequenceNumber();
			oldYear=transactionSequence.getMonth(); 
			if(currentYearInt>oldYear)
			{
				orderNo=1;
				transactionSequence.setMonth(currentYearInt);
				transactionSequence.setCreatedby(userName);
				transactionSequence.setTransactionSequenceNumber(orderNo);
				hbt.update(transactionSequence);
			}else
			{      
				orderNo=orderNo+1;
				transactionSequence.setCreatedby(userName);
				transactionSequence.setTransactionSequenceNumber(orderNo);
				hbt.update(transactionSequence);
			}
		}else
		{
			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			tranSeq.setHospital(hospital);
			tranSeq.setTransactionSequenceNumber(orderNo);
			hbt.save(tranSeq);
		}
		//	tx.commit();
	} catch (Exception e) {
		//if (tx != null)
		//	tx.rollback();
		e.printStackTrace();

	} finally {
		// --------Session Closing----------

	}
	return orderNo;
}
	
	public void blockMedicine(Map<String, Object> mapForDS){
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		Session session = (Session) getSession();
		
		List<String> blockMedicineList=(List)mapForDS.get("blockMedicineList");
		List<Integer> blockDaysList=(List)mapForDS.get("blockDaysList");
		
		
		OpdPatientAllergyM opdPatientAllergyM = new OpdPatientAllergyM();
		opdPatientAllergyM.setHin(new Patient((Integer)mapForDS.get("hinId")));
		opdPatientAllergyM.setEmployee(new MasEmployee((Integer)mapForDS.get("empId")));
		opdPatientAllergyM.setDepartment(new MasDepartment((Integer)mapForDS.get("deptId")));
		opdPatientAllergyM.setHospital(new MasHospital((Integer)mapForDS.get("hospitalId")));
		if((Inpatient)mapForDS.get("inPatient")!=null){
			opdPatientAllergyM.setInpatient((Inpatient)mapForDS.get("inPatient"));
		}else{
			opdPatientAllergyM.setVisit((Visit)mapForDS.get("visitObj"));
		}
		
		opdPatientAllergyM.setStatus("Y");
		opdPatientAllergyM.setLastChgBy((Users)mapForDS.get("users"));
		opdPatientAllergyM.setLastChgTime((String)HMSUtil.getCurrentTimeHHMM().get("currentTime"));
		opdPatientAllergyM.setLastChgDate(new Date());
		
		hbt.save(opdPatientAllergyM);
		
		if(blockMedicineList!=null && blockMedicineList.size()>0){
			for (int i = 0; i <blockMedicineList.size(); i++) {
				
				if(blockMedicineList.get(i)!=null && blockMedicineList.get(i)!=""){
					
					OpdPatientAllergyT opdPatientAllergyT = new OpdPatientAllergyT();
					opdPatientAllergyT.setAllergen(blockMedicineList.get(i));
					opdPatientAllergyT.setAllergy(new MasAllergyProduct(3));
					//opdPatientAllergyT.setSeverity(new MasSeverityCode(3));
					opdPatientAllergyT.setOpdPatientAllergy(opdPatientAllergyM);
					opdPatientAllergyT.setBlockDays(blockDaysList.get(i));
					
					/*opdPatientAllergyT.setFromMonth(allergymonth.get(i));
					opdPatientAllergyT.setFromYear(allergyyear.get(i));*/
					
					opdPatientAllergyT.setBlockedStatus("y");
					hbt.save(opdPatientAllergyT);
					
				}
				
			}
		}
		
	}
	
	public Set<ExternalLabReportCommon> setLabResult(OpdSurgeryHeader opdSurgeryHdr,Patient patient2,MasHospital masHospital2,Box box){
		Set<ExternalLabReportCommon> labReportList=new HashSet<ExternalLabReportCommon>();
		Map<String,String> labResultMap=new HashMap<String,String>();
		labResultMap.put("HIV", box.getString("txtHIV"));
		labResultMap.put("HbsAg", box.getString("txtHbSAg"));
		labResultMap.put("Hemoglobin", box.getString("txtHb"));
		labResultMap.put("PCV", box.getString("txtPCV"));
		labResultMap.put("Prothrombine Time Test", box.getString("txtPT"));
		labResultMap.put("INR", box.getString("txtINR"));
		labResultMap.put("APTT", box.getString("txtAPTT"));
		labResultMap.put("Random Blood Sugar", box.getString("txtRBS"));
		labResultMap.put("Hepatitis C Virus quantitation (HCV) PCR", box.getString("txtHCV"));
		labResultMap.put("Total WBC Count", box.getString("txtTC"));
		labResultMap.put("Bleeding Time Clotting Time", box.getString("txtBT"));
		labResultMap.put("Clotting Time", box.getString("txtCT"));
		labResultMap.put("DCP", box.getString("txtDcP"));
		labResultMap.put("DCL", box.getString("txtDcL"));
		labResultMap.put("DCE", box.getString("txtDcE"));
		labResultMap.put("Blood Group", box.getString("txtBloodGroup"));
		labResultMap.put("Platelet Count", box.getString("txtPlateletCount"));
		labResultMap.put("Blood Urea", box.getString("txtBU"));
		labResultMap.put("Creatinine", box.getString("txtSerCreatinine"));
		labResultMap.put("Clearance", box.getString("txtCrClearance"));
		labResultMap.put("Bilirubin Total", box.getString("txtSBilirubin"));
		labResultMap.put("Total Protein", box.getString("txtTotalProtein"));
		labResultMap.put("Albumin", box.getString("txtAlbumin"));
		labResultMap.put("Globulin", box.getString("txtGlob"));
		labResultMap.put("Electrolytes", box.getString("txtElectrolytes"));
		labResultMap.put("Blood Sodium", box.getString("txtNa"));
		labResultMap.put("Blood Potassium", box.getString("txtPotassium"));
		labResultMap.put("Calcium", box.getString("txtCa"));
		labResultMap.put("Magnesium", box.getString("txtMagnesium"));
		labResultMap.put("SGOT", box.getString("txtSGOT"));
		labResultMap.put("SGPT", box.getString("txtSGPT"));
		labResultMap.put("Thyroid Function Test", box.getString("txtTFT"));
		labResultMap.put("Urine Albumin", box.getString("txtUrineAlbumin"));
		labResultMap.put("Urine Sugar", box.getString("txtUrineSugar"));
		labResultMap.put("Urine Deposits", box.getString("txtUrineDeposits"));
		labResultMap.put("PFT", box.getString("txtAreaPFT"));
		labResultMap.put("MRI", box.getString("txtAreaMRI"));
		labResultMap.put("USG", box.getString("txtAreaUSG"));
		labResultMap.put("X-Ray Neck", box.getString("txtXrayNeck"));
		labResultMap.put("X-Ray Chest", box.getString("txtXrayChest"));
		labResultMap.put("ECG", box.getString("txtAreaECG"));
		labResultMap.put("Echo", box.getString("txtAreaEcho"));
		labResultMap.put("TMT", box.getString("txtAreaTMT"));
		labResultMap.put("Others", box.getString("txtAreainvstResultsOthers"));
		
		for(Map.Entry<String,String> resultMap:labResultMap.entrySet()){

			if(resultMap.getValue()!=null && !resultMap.getValue().trim().isEmpty()){
				ExternalLabReportCommon labReport=new ExternalLabReportCommon();
				labReport.setTestName(resultMap.getKey());
				labReport.setTestResult(resultMap.getValue());
				labReport.setHin(patient2);
				labReport.setHospital(masHospital2);
				if(opdSurgeryHdr.getVisit()!=null){
					labReport.setVisit(opdSurgeryHdr.getVisit());
				}else if(opdSurgeryHdr.getInpatient()!=null){
					labReport.setInPatient(opdSurgeryHdr.getInpatient());
				}
				labReportList.add(labReport);
			}
			
		}
           
		return labReportList;
	}

	
	@Override
	public Map<String, Object> submitAac(Map<String, Object> mapForDS) {
		Transaction tx=null;
		try{
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			Session session = (Session) getSession();
			tx = session.beginTransaction();
			int visitId = (Integer) mapForDS.get("visitId");
			int hospitalId = (Integer) mapForDS.get("hospitalId");
			int hinId = (Integer) mapForDS.get("hinId");
			
			Box box = (Box) mapForDS.get("box");
			
			Integer userId=0;
			if (mapForDS.get("userId") != null) {
				userId=(Integer)mapForDS.get("userId");
			}
			int inpatientId=0;
			if (mapForDS.get("inpatientId") != null) {
				inpatientId=(Integer)mapForDS.get("inpatientId");
			}
			
			int opdSurgeryId=0;
			if (mapForDS.get("opdSurgeryId") != null) {
				opdSurgeryId=(Integer)mapForDS.get("opdSurgeryId");
			}
			
			int deptId=0;
			if (mapForDS.get("deptId") != null) {
				deptId=(Integer)mapForDS.get("deptId");
			}
			
			OpdSurgeryHeader opdSurgeryHdr=new OpdSurgeryHeader();
			opdSurgeryHdr=hbt.load(OpdSurgeryHeader.class, opdSurgeryId);
			
			List<Integer> serviceCentersList=new ArrayList<Integer>();
			List<Integer> opSessionList=new ArrayList<Integer>();
			
			if (mapForDS.get("serviceCentersList") != null) {
				serviceCentersList=(List<Integer>)mapForDS.get("serviceCentersList");
			}
			
			if (mapForDS.get("opSessionList") != null) {
				opSessionList=(List<Integer>)mapForDS.get("opSessionList");
			}
			
			/*Form Data Start*/
			
			List<OpdPatientHistory> opdPatientHistoryList = new ArrayList<OpdPatientHistory>();
			List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
			List<OpdSurgeryHeader> opdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
			
			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			OtPreAnesthesiaDetails otPreAnesthesiaDetails = new OtPreAnesthesiaDetails();
			
			otPreAnesthesiaDetails.setAllergy(box.getString("txtAllergy"));
			otPreAnesthesiaDetails.setDiabetes(box.getString("txtDiabetes"));
			otPreAnesthesiaDetails.setPsychiatricIllness(box.getString("txtPsychiatric"));
			otPreAnesthesiaDetails.setMenstruation(box.getString("txtMenstruation"));
			otPreAnesthesiaDetails.setAsthma(box.getString("txtAsthma"));
			otPreAnesthesiaDetails.setEpilepsy(box.getString("txtEpilepsy"));
			otPreAnesthesiaDetails.setTuberculosis(box.getString("txtTuberculosis"));
			otPreAnesthesiaDetails.setChildBirth(box.getString("txtChildBirth"));
			otPreAnesthesiaDetails.setChestPain(box.getString("txtChestPain"));
			
			otPreAnesthesiaDetails.setExerciseIntolerance(box.getString("txtExercise"));
			otPreAnesthesiaDetails.setPreviousSurgeries(box.getString("txtPreviousSurgeries"));
			otPreAnesthesiaDetails.setSmoking(box.getString("txtSmoking"));
			otPreAnesthesiaDetails.setCough(box.getString("txtCough"));
			otPreAnesthesiaDetails.setHypertension(box.getString("txtHypertension"));
			otPreAnesthesiaDetails.setPreviousAnesthetic(box.getString("txtAnestheticExposures"));
			otPreAnesthesiaDetails.setAlcoholism(box.getString("txtAlcoholism"));
			otPreAnesthesiaDetails.setDyspnoea(box.getString("txtDyspnoea"));
			otPreAnesthesiaDetails.setHeartDisease(box.getString("txtHeartDisease"));
			
			otPreAnesthesiaDetails.setExerciseIntolerance(box.getString("txtExercise"));
			otPreAnesthesiaDetails.setGeneralAnesthesia(box.getString("txtGeneralAnesthesia"));
			otPreAnesthesiaDetails.setDentures(box.getString("txtDentures"));
			otPreAnesthesiaDetails.setDysphagia(box.getString("txtDysphagia"));
			otPreAnesthesiaDetails.setHoarseness(box.getString("txtHoarseness"));
			otPreAnesthesiaDetails.setSpinalAnesthesia(box.getString("txtSpinalAnesthesia"));
			otPreAnesthesiaDetails.setContactLens(box.getString("txtContactLens"));
			otPreAnesthesiaDetails.setDyspepsia(box.getString("txtDyspepsia"));
			otPreAnesthesiaDetails.setIhd(box.getString("txtIHD"));
			
			otPreAnesthesiaDetails.setComplications(box.getString("txtComplications"));
			otPreAnesthesiaDetails.setHearingAids(box.getString("txtHearingAids"));
			otPreAnesthesiaDetails.setAcidPepticDisorders(box.getString("txtAcidPepticDisorders"));
			otPreAnesthesiaDetails.setJaundice(box.getString("txtJaundice"));
			otPreAnesthesiaDetails.setPonv(box.getString("txtPONV"));
			otPreAnesthesiaDetails.setHistoryRemarks(box.getString("txtAreaHistoryRemarks"));
			
			otPreAnesthesiaDetails.setAntiallegeric(box.getString("txtAntiallegeric"));
			otPreAnesthesiaDetails.setCebs(box.getString("txtCEBs"));
			otPreAnesthesiaDetails.setAntiplatelets(box.getString("txtAntiplatelets"));
			
			otPreAnesthesiaDetails.setAntihypertensives(box.getString("txtAntihypertensives"));
			otPreAnesthesiaDetails.setAntianginals(box.getString("txtAntianginals"));
			otPreAnesthesiaDetails.setAntituberculous(box.getString("txtAntituberculous"));
			otPreAnesthesiaDetails.setAntiasthmatics(box.getString("txtAntiasthmatics"));
			otPreAnesthesiaDetails.setAntidiabetics(box.getString("txtAntidiabetics"));
			otPreAnesthesiaDetails.setAntimalignancy(box.getString("txtAntimalignancy"));
			otPreAnesthesiaDetails.setDiuretics(box.getString("txtDiuretics"));
			otPreAnesthesiaDetails.setAntiepileptics(box.getString("txtAntiepileptics"));
			otPreAnesthesiaDetails.setAntithyroid(box.getString("txtAntithyroid"));
			
			otPreAnesthesiaDetails.setDigoxin(box.getString("txtDigoxin"));
			otPreAnesthesiaDetails.setAntipsychotics(box.getString("txtAntipsychotics"));
			otPreAnesthesiaDetails.setAntacid(box.getString("txtAntacid"));
			otPreAnesthesiaDetails.setBetaBlockers(box.getString("txtBetaBlockers"));
			otPreAnesthesiaDetails.setSteroids(box.getString("txtSteroids"));
			otPreAnesthesiaDetails.setH2Blockers(box.getString("txtH2Blockers"));
			otPreAnesthesiaDetails.setDrugHistoryOthers(box.getString("txtAreaDrugHistoryOthers"));
			otPreAnesthesiaDetails.setDrugHistoryRemarks(box.getString("txtAreaDrugHistoryRemarks"));
			
			otPreAnesthesiaDetails.setAirway(box.getString("txtAirway"));
			otPreAnesthesiaDetails.setMouthOpening(box.getString("txtMouthOpening"));
			otPreAnesthesiaDetails.setTmj(box.getString("txtTMJ"));
			otPreAnesthesiaDetails.setNeckMovements(box.getString("txtNeckMovements"));
			otPreAnesthesiaDetails.setTooth(box.getString("txtTooth"));
			otPreAnesthesiaDetails.setMallampattiClass(box.getString("txtMallampattiClass"));
			otPreAnesthesiaDetails.setAllensTest(box.getString("txtAllensTest"));
			otPreAnesthesiaDetails.setRespiratorySystem(box.getString("txtRespiratorySystem"));
			otPreAnesthesiaDetails.setTrachea(box.getString("txtTrachea"));
			otPreAnesthesiaDetails.setLungs(box.getString("txtLungs"));
			otPreAnesthesiaDetails.setCardioVascularSystem(box.getString("txtCardioVascularSystem"));
			
			otPreAnesthesiaDetails.setCentralNervousSystem(box.getString("txtCentralNervousSystem"));
			otPreAnesthesiaDetails.setGastrointestinalSystem(box.getString("txtGastrointestinalSystem"));
			otPreAnesthesiaDetails.setPhysicalExamination(box.getString("txtAreaPhysicalExamRemarks"));
			otPreAnesthesiaDetails.setPulse(box.getString("txtPulse"));
			otPreAnesthesiaDetails.setBp(box.getString("txtBp"));
			otPreAnesthesiaDetails.setPallor(box.getString("txtPallor"));
			otPreAnesthesiaDetails.setIcetrus(box.getString("txtIcterus"));
			otPreAnesthesiaDetails.setVenousAccess(box.getString("txtVenousAccess"));
			otPreAnesthesiaDetails.setChangedDate(new Date());
			otPreAnesthesiaDetails.setChangedTime((String) HMSUtil.getCurrentTimeHHMM().get("currentTime"));
			
			OpdSurgeryHeader opdSurgeryHeaderObj = new OpdSurgeryHeader();
			
			Visit visitObj=null;
			Inpatient inpatient = new Inpatient();
			
			if(opdSurgeryHdr.getVisit()!=null){
				Visit visit = new Visit();
				visit.setId(visitId);
				visitObj=opdSurgeryHdr.getVisit();
				otPreAnesthesiaDetails.setVisit(visit);
				
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", opdSurgeryHdr.getOrderNo()))
						.add(Restrictions.eq("PacStatus", "pending").ignoreCase()).list();
				
				OpdSurgeryHeader opdSurgeryHeader = opdSurgeryList.get(0);
				int id = opdSurgeryHeader.getId();
				opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, id);
				if(box.getString("acceptanceStatus").equalsIgnoreCase("y")){
					otPreAnesthesiaDetails.setFitForSurgery("y");
					opdSurgeryHeaderObj.setPacStatus("Cleared");
				}else{
					otPreAnesthesiaDetails.setFitForSurgery("n");
					opdSurgeryHeaderObj.setPacStatus("Not Cleared");
				}
				hbt.update(opdSurgeryHeaderObj);
				
				
			}else if(opdSurgeryHdr.getInpatient()!=null){
				
				inpatient.setId(inpatientId);
				otPreAnesthesiaDetails.setInpatient(inpatient);
				
				opdPatientHistoryList = session
						.createCriteria(OpdPatientHistory.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", hinId))
						.add(Restrictions.eq("VisitInpatientId", inpatientId)).list();
				
				opdSurgeryList = session
						.createCriteria(OpdSurgeryHeader.class)
						.createAlias("Inpatient", "inpatient")
						.add(Restrictions.eq("inpatient.Id", inpatientId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("OrderNo", opdSurgeryHdr.getOrderNo()))
						.add(Restrictions.eq("PacStatus", "pending").ignoreCase()).list();
				OpdSurgeryHeader opdObj = (OpdSurgeryHeader) opdSurgeryList.get(0);
				int opdId = opdObj.getId();
				
				opdSurgeryHeaderObj = (OpdSurgeryHeader) hbt.load(
						OpdSurgeryHeader.class, opdId);
				if(box.getString("acceptanceStatus").equalsIgnoreCase("y")){
					otPreAnesthesiaDetails.setFitForSurgery("y");
					opdSurgeryHeaderObj.setPacStatus("Cleared");
				}else{
					otPreAnesthesiaDetails.setFitForSurgery("n");
					opdSurgeryHeaderObj.setPacStatus("Not Cleared");
				}
				
				hbt.update(opdSurgeryHeaderObj);
				
			}
			
			/*if (opdPatientHistoryList != null && opdPatientHistoryList.size() > 0) {

				OpdPatientHistory opdPatientHistoryObj = opdPatientHistoryList
						.get(0);
				int opdPatientHistoryId = opdPatientHistoryObj.getId();
				OpdPatientHistory opdPatientHistory2 = (OpdPatientHistory) hbt
						.load(OpdPatientHistory.class, opdPatientHistoryId);
				opdPatientHistory2.setPersonalPresentHistory(box
						.getString("presentHistory"));
				opdPatientHistory2.setPersonalPastHistory(box
						.getString("pastHistory"));
				hbt.update(opdPatientHistory2);

			}*/
			
			if(opdSurgeryHdr.getVisit()!=null){
				opdPatientHistory.setVisitInpatientId(visitId);
			}else if(opdSurgeryHdr.getInpatient()!=null){
				opdPatientHistory.setVisitInpatientId(inpatientId);
			}
			
			Patient patient2 = new Patient();
			patient2.setId(hinId);
			opdPatientHistory.setHin(patient2);
			MasDepartment masDepartment2 = new MasDepartment();
			masDepartment2.setId(deptId);
			opdPatientHistory.setDepartment(masDepartment2);
			MasHospital masHospital2 = new MasHospital();
			masHospital2.setId(hospitalId);
			opdPatientHistory.setHospital(masHospital2);
			Users users2 = new Users();
			users2.setId(userId);
			opdPatientHistory.setLastChgBy(users2);
			opdPatientHistory.setLastChgDate(new Date());
			opdPatientHistory.setLastChgTime((String)HMSUtil.getCurrentTimeHHMM().get("currentTime"));
			opdPatientHistory.setStatus("y");
			opdPatientHistory.setIpOpPacStatus("PAC");
			hbt.save(opdPatientHistory);
			
			Users user2=(Users)hbt.load(Users.class,userId);
			int employId=user2.getEmployee().getId();
			
			MasEmployee me=new MasEmployee();
			me.setId(employId);
			
			otPreAnesthesiaDetails.setAnesthetic(me);
			otPreAnesthesiaDetails.setChangedBy(user2);
			otPreAnesthesiaDetails.setHin(patient2);
			/*Acceptance Start*/
			
			AacAcceptance aacAcceptance=new AacAcceptance();
			
			if(box.getString("acceptanceStatus").equalsIgnoreCase("y")){
				
				aacAcceptance.setGradingAsaps(box.getString("txtGradingASAPS"));
				aacAcceptance.setGradingGoldman(box.getString("txtGradingGoldman"));
				aacAcceptance.setGradingPugh(box.getString("txtGradingPugh"));
				aacAcceptance.setGradingChild(box.getString("txtGradingChild"));
				aacAcceptance.setGradingDetsky(box.getString("txtGradingDetsky"));
				aacAcceptance.setNilPerOral(box.getString("txtInstructionsNilOral"));
				aacAcceptance.setInformedConsent(box.getString("txtInstructionsinformedConsent"));
				aacAcceptance.setPreviousDayMedicine(box.getString("txtPreviousDayMedicines"));
				aacAcceptance.setNightSedation(box.getString("txtNightSadation"));
				aacAcceptance.setMedicineAt6am(box.getString("txt6amMedicines"));
				aacAcceptance.setCardiacDrugs(box.getString("txtContinueCardiacDrugs"));
				aacAcceptance.setAdviceBeforeSurgery(box.getString("txtFurtherAdvices"));
				aacAcceptance.setSurgeryDayInvestigations(box.getString("txtInvestigationB4Surgery"));
				aacAcceptance.setInfectiveEndocarditis(box.getString("txtInfectiveEndocarditis"));
				aacAcceptance.setRemoveArtificial(box.getString("txtRemoveArtificialDentures"));
				aacAcceptance.setPreMedications(box.getString("txtPremedications"));
				aacAcceptance.setOthers(box.getString("txtAcceptedOthers"));
				aacAcceptance.setAcceptanceStatus(box.getString("acceptanceStatus"));
				
			}else{
				aacAcceptance.setRemarks(box.getString("txtNotAcceptedRemarks"));
				aacAcceptance.setConsultations(box.getString("txtConsultations"));
				aacAcceptance.setFurtherInvestigationsNeeded(box.getString("txtFurtherInvestigations"));
				aacAcceptance.setAcceptanceStatus(box.getString("acceptanceStatus"));
			}
			
			/*Acceptance End*/
			
			/*Lab Result Start*/
			Set<ExternalLabReportCommon> labReportList=setLabResult(opdSurgeryHdr, patient2, masHospital2,box);
			
			otPreAnesthesiaDetails.setAacAcceptance(aacAcceptance);
			hbt.save(otPreAnesthesiaDetails);
			aacAcceptance.setOtPreAnesthesiaDetails(otPreAnesthesiaDetails);
			hbt.save(aacAcceptance);
			
			if(labReportList!=null && labReportList.size()>0){
				for(ExternalLabReportCommon externalLabReportCommon:labReportList){
					externalLabReportCommon.setOtPreAnesthesiaDetails(otPreAnesthesiaDetails);
					hbt.save(externalLabReportCommon);
				}
			}
			/*Lab Result End*/
			
			/*Form Data End*/
			
			/*Prescription Grid Start */
			List<String> nomenclatureList= (List) mapForDS.get("nomenclatureList");
			List<String> pvmsNoList = (List<String>) mapForDS.get("pvmsNoList");
			List<Integer> frequencyList = (List) mapForDS.get("frequenciesList");
			List<Float> dosageList = (List) mapForDS.get("dosageList");
			List<Float> totalList = (List<Float>) mapForDS.get("totalList");
			List<Float> actualTotalAfterMixList = (List<Float>) mapForDS.get("actualTotalAfterMixList");
			List<Integer> noOfDaysList = (List) mapForDS.get("noOfDaysList");
			List<Integer> routes = (List) mapForDS.get("routes");
			List<Integer> instrunctions = (List) mapForDS.get("instrunctionsList");
			List<String> spLinstrunctionList = (List) mapForDS.get("spLinstrunctionList");
			
			String prescriptionNo =  (String) mapForDS.get("prescriptionNo");
			List<String> prescription_availableStatusList = (List) mapForDS.get("prescription_availableStatusList");
			
			List<String> blockMedicineList=new ArrayList<String>();
			
			
			if(mapForDS.get("blockMedicineList")!=null){
				blockMedicineList=(List)mapForDS.get("blockMedicineList");
			}
			
			Integer departmentId=0;
			Visit visitObjToUpdate=null;
			Patient patient=null;
			if(visitId!=0){
				visitObjToUpdate=(Visit) hbt.get(Visit.class, visitId);
				departmentId=visitObjToUpdate.getDepartment().getId();
				patient = visitObjToUpdate.getHin();
			}else if(inpatientId!=0){
				departmentId=opdSurgeryHdr.getInpatient().getDepartment().getId();
				patient=opdSurgeryHdr.getHin();
			}
			 
			 
			Map<String, Object> timeMap=HMSUtil.getCurrentTimeHHMM();
			String currentTime=(String) timeMap.get("currentTime");
			List<Integer> itemIdList = new ArrayList<Integer>();
			List<Integer> parkPrescriptionIds=null;
			
			Properties properties = new Properties();
		    URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		    
		    try {
				properties.load(resourcePath.openStream());
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			int pharmacyDepartmentId=0;
			int labDepartmentId=0;
			int radiologyDepartmentId=0;
			pharmacyDepartmentId = Integer.parseInt(properties.getProperty("pharmacyDepartmentId"));
			labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
			radiologyDepartmentId = Integer.parseInt(properties.getProperty("radiologyDepartmentId"));
			
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			opdPatientDetails.setConsultationDate(new Date());
			opdPatientDetails.setConsultationTime((String)HMSUtil.getCurrentTimeHHMM().get("currentTime"));
			
			Inpatient inPatient=null;
			if(inpatientId!=0){
				inPatient=(Inpatient) session.load(Inpatient.class, inpatientId);
				opdPatientDetails.setInpatient(inPatient);
				mapForDS.put("inPatient",inPatient); 
			}
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			
			Users users=(Users)mapForDS.get("user");
			
			MasEmployee masEmployee=new MasEmployee();
			masEmployee.setId(users.getEmployee().getId());
			
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String consultationTime = (String)utilMap.get("currentTime");
			String consultationDate = (String)utilMap.get("currentDate");
			
			
			opdPatientDetails.setEmployee(masEmployee);
			opdPatientDetails.setHospital(masHospital);
			
			mapForDS.put("empId", users.getEmployee().getId());
			mapForDS.put("users", users);
			mapForDS.put("visitObj",visitObjToUpdate);
			
			
			
			if(inpatientId==0){
				
				if(blockMedicineList.size()>0){  // To Block Medicine
					blockMedicine(mapForDS);
				}
				
				if (pvmsNoList.size() > 0) {
					PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			
					MasDepartment masDepartment = new MasDepartment();
					MasHospital mashospital = new MasHospital();
					patientPrescriptionHeader.setHin(patient);
					masDepartment.setId(departmentId);
					patientPrescriptionHeader.setDepartment(masDepartment);
					patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
					patientPrescriptionHeader.setVisit(visitObjToUpdate);
					mashospital.setId(hospitalId);
					patientPrescriptionHeader.setHospital(mashospital);
					patientPrescriptionHeader.setStatus("p");
					patientPrescriptionHeader.setPrescriptionDate(new Date());
					patientPrescriptionHeader.setPrescriptionTime(currentTime);
					patientPrescriptionHeader.setDispencingDate(new Date());
					patientPrescriptionHeader.setOpdPatientDetail(null);
					
					//Start..    Added by Dhananjay 02-Jan-2017
					
					String pharmacyLabStatus="P";
				PharmacyLabQueue pharmacyLabQueue=saveQueueNoForPharmacy(pharmacyDepartmentId,hospitalId,visitObjToUpdate,pharmacyLabStatus);
				if(null !=pharmacyLabQueue)
				patientPrescriptionHeader.setPharmacyLabQueue(pharmacyLabQueue);
					//End
					
						hbt.save(patientPrescriptionHeader);
					
					
					
					for (int i = 0; i < pvmsNoList.size(); i++) {
						String pvmsNo = (String) pvmsNoList.get(i);
						List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
						itemIdListNew = getItemIdListFromPVMS(pvmsNo);
						for (int k = 0; k < itemIdListNew.size(); k++) {
							itemIdList.add(itemIdListNew.get(k).getId());
						}
					}
					int item_class_id=0;
					MasFrequency masFrequency = null;
					MasStoreItem masStoreItem = null;
					RouteOfAdministration routeOfAdministration = null;
					OpdInstructionTreatment opdInstructionTreatment = null;
					List<Object> opdPatientListObject = new ArrayList<Object>();
					
					String[] durationStr1=null;
					String[] durationStr2=null;
					List<String>durationPrescriptionList=new ArrayList<String>();
					if (mapForDS.get("durationPrescriptionList") != null) {
						durationPrescriptionList =(List<String>) mapForDS.get("durationPrescriptionList");
					}
					
					InjAppointmentDetails injAppointmentDetails=null;
					
					for (int i = 0; i < itemIdList.size(); i++) {
						String[]dayCount=null;
						String mainStr="";
						if(durationPrescriptionList!=null && durationPrescriptionList.size()>i){
							mainStr=(String)durationPrescriptionList.get(i);
							dayCount=mainStr.split(",");
						}
						
						PatientPrescriptionDetails patientPrescriptionDetails=null;
						
						if(parkPrescriptionIds!=null && !parkPrescriptionIds.get(i).equals(0)){
							patientPrescriptionDetails	= hbt.load(PatientPrescriptionDetails.class, parkPrescriptionIds.get(i));
							//added by govind 28-03-2017 for duplicate came in recall patient
							Criteria cr=session.createCriteria(InjAppointmentDetails.class)
									.add(Restrictions.eq("PrescriptionDetails.Id", parkPrescriptionIds.get(i)));
							if(cr.list().size()>0){
							injAppointmentDetails=(InjAppointmentDetails)cr.list().get(0);
							}
							//added by govind 28-03-2017 end
						}else{
							patientPrescriptionDetails	= new PatientPrescriptionDetails();
							injAppointmentDetails = new InjAppointmentDetails();//added by govind 28-03-2017 
						}
						if (itemIdList != null && itemIdList.size() > 0	&& itemIdList.get(i) != 0)
							masStoreItem = (MasStoreItem)session.load(MasStoreItem.class, itemIdList.get(i));//new MasStoreItem(itemIdList.get(i));
						
						if (frequencyList != null && frequencyList.size() > 0 && frequencyList.get(i) != 0)
							masFrequency = new MasFrequency(frequencyList.get(i));

						if (routes != null && routes.size() > 0	&& routes.get(i) != 0)
							routeOfAdministration = new RouteOfAdministration(routes.get(i));

						if (instrunctions != null && instrunctions.size() > 0	&& instrunctions.get(i) != 0){
							opdInstructionTreatment = new OpdInstructionTreatment(instrunctions.get(i));
						}
						if (noOfDaysList.size() > 0 && noOfDaysList.get(i) != 0	&& noOfDaysList.get(i) != 0){
							patientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
						}	
						if(spLinstrunctionList!=null && spLinstrunctionList.size()>0){
							patientPrescriptionDetails.setSplInstruction(spLinstrunctionList.get(i));
						}
						
						//prescribedMedicin.append(masStoreItem.getNomenclature()+",");
						patientPrescriptionDetails.setNotAvailable(prescription_availableStatusList.get(i));
						patientPrescriptionDetails.setItem(masStoreItem);
						patientPrescriptionDetails.setFrequency(masFrequency);
						patientPrescriptionDetails.setDosage(dosageList.get(i));
						patientPrescriptionDetails.setInsrtuction(opdInstructionTreatment);
						patientPrescriptionDetails.setRoute(routeOfAdministration);
						patientPrescriptionDetails.setType("OP");
						patientPrescriptionDetails.setTotal(totalList.get(i));
						patientPrescriptionDetails.setActualTotal(actualTotalAfterMixList.get(i)); // added by amit das on 19-11-2016
						/*patientPrescriptionDetails.setStartDate(startDates.get(i));
						patientPrescriptionDetails.setEndDate(endDates.get(i));*/
						patientPrescriptionDetails.setNursingStatus("n");
						patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
						
						List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
							
							String item_class_code = properties.getProperty("item_class_id");
							item_class_id=Integer.parseInt(item_class_code);
						
						storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemIdList.get(i)+" and ic.Id="+item_class_id);
						if(storeItemList.size() > 0){
							patientPrescriptionDetails.setInjectionStatus("p");
						}else{
							patientPrescriptionDetails.setInjectionStatus("n");
						}
						
						if(visitObjToUpdate!=null && visitObjToUpdate.getVisitStatus().equalsIgnoreCase("p") && parkPrescriptionIds!=null && !parkPrescriptionIds.get(i).equals(0)){
							hbt.update(patientPrescriptionDetails);
						}else{
							hbt.save(patientPrescriptionDetails);
						}
						
						if(storeItemList.size()>0){
							List<InjAppointmentHeader> injectionRegisterList=new ArrayList<InjAppointmentHeader>();
							injectionRegisterList=hbt.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="+visitId);
							
							InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
							
							 
							if(injectionRegisterList.size()>0){
								for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
									injectionAppointment.setId(injectionRegisterTemp.getId());
								}
							}else{
								Patient patientInj = new Patient();
								patientInj.setId(hinId);
								injectionAppointment.setHin(patientInj);
								Visit visitInj = new Visit();
								visitInj.setId(visitId);
								injectionAppointment.setVisit(visitInj);
								MasHospital masHospitalInj = new MasHospital();
								masHospitalInj.setId(hospitalId);
								injectionAppointment.setHospital(masHospitalInj);
								
								injectionAppointment.setStatus("p");
								injectionAppointment.setLastChgTime(currentTime);
								Users user = new Users();
								user.setId(userId);
								injectionAppointment.setLastChgBy(user);
								injectionAppointment.setLastChgDate(new Date());
								injectionAppointment.setPrescription(patientPrescriptionHeader);
								hbt.save(injectionAppointment);
							}
									if(mainStr.equals("")){
										//injAppointmentDetails.setAppointmentTime(time);
										injAppointmentDetails.setInjAppointmentDate(new Date());
										injAppointmentDetails.setDose(String.valueOf(dosageList.get(i)));
										
										MasFrequency frequency = new MasFrequency();
										frequency.setId(frequencyList.get(i));
										injAppointmentDetails.setFrequency(frequency);
										
										if(routeOfAdministration!=null)
										injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
										
										 
										MasStoreItem item = new MasStoreItem();
										item.setId(itemIdList.get(i));
										
										//Check for insullin method checkForInsulinInjection(itemIdList.get(i)) added by Dhananjay 21/07/2016
										
										if(!checkForInsulinInjection(itemIdList.get(i))){
											
										
										injAppointmentDetails.setItem(item);
										if(routeOfAdministration!=null){
											injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
										}
										injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
										injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
										injAppointmentDetails.setPrescriptionDetails(patientPrescriptionDetails);
										injAppointmentDetails.setStatus("p");
										injAppointmentDetails.setFinalStatus("n");
										hbt.save(injAppointmentDetails);
										}
									}else{
										for(String str:dayCount){
											injAppointmentDetails = new InjAppointmentDetails();
											
											SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
											Calendar cal=Calendar.getInstance();
											Integer nextDate=Integer.parseInt(str.trim());
											Date appointmentDate=null;
											
											if(nextDate==1){
												appointmentDate=new Date();
												injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
												injAppointmentDetails.setInjAppointmentDate(appointmentDate);
												if(mainStr!=null && !mainStr.equals("")){
													injAppointmentDetails.setExceptionalPrescription("y");
												}
											}else{
												if(nextDate>1){
													cal.add(Calendar.DATE, nextDate-1);
												}else{
													cal.add(Calendar.DATE, nextDate);
												}
												
												appointmentDate=HMSUtil.convertStringyyyyMMddTypeToDateType(format.format(cal.getTime()));
												injAppointmentDetails.setNoOfDays(1);
												injAppointmentDetails.setInjAppointmentDate(appointmentDate);
												injAppointmentDetails.setExceptionalPrescription("y");
											}
											
											
											injAppointmentDetails.setDose(String.valueOf(dosageList.get(i)));
											
											MasFrequency frequency = new MasFrequency();
											frequency.setId(frequencyList.get(i));
											injAppointmentDetails.setFrequency(frequency);
											
											if(routeOfAdministration!=null)
											injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
											
											MasStoreItem item = new MasStoreItem();
											item.setId(itemIdList.get(i));
											injAppointmentDetails.setItem(item);
											if(routeOfAdministration!=null){
												injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
											}
											injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
										
											injAppointmentDetails.setPrescriptionDetails(patientPrescriptionDetails);
											injAppointmentDetails.setStatus("p");
											injAppointmentDetails.setFinalStatus("n");
											hbt.save(injAppointmentDetails);
										}
									}
								
						}
						
					}
				}
			}else{
				
				if(blockMedicineList.size()>0){   // To Block Medicine
					blockMedicine(mapForDS);
				}
				if(pvmsNoList.size()>0){
				
					InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
					inpatientPrescriptionHeader.setHin(patient);
					
					MasDepartment md = new MasDepartment();
					md.setId(inPatient.getDepartment().getId());
					
					inpatientPrescriptionHeader.setDepartment(md);
					inpatientPrescriptionHeader.setInpatient(inPatient);
					inpatientPrescriptionHeader.setHospital(masHospital);
					inpatientPrescriptionHeader.setStatus("p");
					
					inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					inpatientPrescriptionHeader.setPrescriptionTime(consultationTime);
					inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
					inpatientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
					inpatientPrescriptionHeader.setPrescriptionDate(new Date());
					inpatientPrescriptionHeader.setPrescriptionTime(currentTime);
					
					
					int ipPrescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
					inpatientPrescriptionHeader.setPrescriptionNo(String.valueOf(ipPrescriptionNo));
					hbt.save(opdPatientDetails);
					hbt.save(inpatientPrescriptionHeader);
					List<Object> inpatientPrescriptionDetailsListObject = new ArrayList<Object>();
					int item_class_id=0;//added by govind 22-09-2016
					int itemId= 0;
					
					Date date = new Date();
					for (int i = 0; i <pvmsNoList.size() ; i++) {
						

							String pvmsNo =pvmsNoList.get(i);
							MasStoreItem item=null;
							try
							{
								item=(MasStoreItem) session.createCriteria(MasStoreItem.class)
							.add(Restrictions.eq("PvmsNo", pvmsNo))
							.setFirstResult(0)
							.setMaxResults(1)
							.uniqueResult();
							}
							catch(Exception exception){
								
							}
							if(item!=null)
							{
								InpatientPrescriptionDetails inpatientPrescriptionDetails=new InpatientPrescriptionDetails();
							
							inpatientPrescriptionDetails.setItem(item);
							MasFrequency masFrequency = new MasFrequency();
							
							masFrequency.setId(frequencyList.get(i));
							inpatientPrescriptionDetails.setFrequency(masFrequency);
							
							
							inpatientPrescriptionDetails.setDosage(dosageList.get(i));
							
							
							inpatientPrescriptionDetails.setSplInstruction(spLinstrunctionList.get(i));
							
							
							inpatientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
							
							inpatientPrescriptionDetails.setType("IP");
							
							
							OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment();
							instructionTreatment.setId(instrunctions.get(i));
							inpatientPrescriptionDetails.setInsrtuction(instructionTreatment);
							

							RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
							
							routeOfAdministration.setId(routes.get(i));
							inpatientPrescriptionDetails.setRoute(routeOfAdministration);
							
							
							inpatientPrescriptionDetails.setTotal(totalList.get(i));
							inpatientPrescriptionDetails.setStopMedicine("n");
							
							if(actualTotalAfterMixList.get(i)!=null){
								inpatientPrescriptionDetails.setActualTotal(actualTotalAfterMixList.get(i));
							}
							
							inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader);
							inpatientPrescriptionDetails.setIssuedStatus("p");
							
							//added by govind 22-9-2016
							
							List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
							itemIdListNew = getIpItemIdFromPVMS(pvmsNo);
								itemId=itemIdListNew.get(0).getId();
								System.out.println("itemId "+itemId);
							List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
							/*Properties properties = new Properties();
							URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");*/
							try {
								//properties.load(resourcePath.openStream());
								String item_class_code = properties.getProperty("item_class_id");
								item_class_id=Integer.parseInt(item_class_code);
							} catch (Exception e) {
								e.printStackTrace();
							}
							storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemClass as ic where item.Id="+itemId+" and ic.Id="+item_class_id);
							if(storeItemList.size() > 0){
								System.out.println("storeItemList.size() > 0)");
								inpatientPrescriptionDetails.setNotAvailable("y");
								inpatientPrescriptionDetails.setInjectionStatus("y");
							}else{
								System.out.println("storeItemList.size() > 0) else");
								inpatientPrescriptionDetails.setNotAvailable("n");
								inpatientPrescriptionDetails.setInjectionStatus("n");
							}
							//added by govind 22-9-2016
							hbt.save(inpatientPrescriptionDetails);
							inpatientPrescriptionDetailsListObject.add(inpatientPrescriptionDetails);
							/*//added by govind 26-10-2017
							for(TaperedMedicineUtil tapUtil:taperUtilList){
								if(tapUtil.getItemId().equals(item.getId())){
								System.out.println("itemId-->"+tapUtil.getItemId()+" Frequency-->"+tapUtil.getFrequency());
								TaperedMedicineIp tapered=new TaperedMedicineIp();
								tapered.setPrescription(inpatientPrescriptionDetails);
								MasFrequency frequency=new MasFrequency();
								frequency.setId(tapUtil.getFrequency());
								MasStoreItem item1=new MasStoreItem();
								item1.setId(tapUtil.getItemId());
								tapered.setFrequency(frequency);
								tapered.setItem(item1);
								tapered.setDosageDetail(tapUtil.getDosage());
								tapered.setDosage(tapUtil.getDosageCount());
								tapered.setNoOfDays(tapUtil.getDuration());
								tapered.setTotal(tapUtil.getTotal());
								hbt.save(tapered);
								}
							}//added by govind 26-10-2017 end
		*/					
							//added by govind 22-9-2016 start
							if(storeItemList.size() > 0){
								System.out.println("start injection table");
								InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
								
								injectionAppointment.setHin(patient);
								
								injectionAppointment.setHospital(masHospital);							
								injectionAppointment.setStatus("p");
								injectionAppointment.setLastChgTime(currentTime);
								injectionAppointment.setLastChgBy(users);
								injectionAppointment.setLastChgDate(date);
								injectionAppointment.setInpatientPrescriptionHeader(inpatientPrescriptionHeader);
								injectionAppointment.setInpatient(inPatient);
								hbt.save(injectionAppointment);
								
								
								//start adding injAppointmentDetails data
								InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
								//injAppointmentDetails.setAppointmentTime(time);
								injAppointmentDetails.setInjAppointmentDate(new Date());
								injAppointmentDetails.setDose(""+dosageList.get(i));
														
								injAppointmentDetails.setFrequency(masFrequency);
								injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
								
								 
								MasStoreItem item1 = new MasStoreItem();
								item1.setId(itemId);
								if(!checkForInsulinInjection(itemId)){								
								
								injAppointmentDetails.setItem(item1);
								injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
								injAppointmentDetails.setInpatientPrescriptionDetails(inpatientPrescriptionDetails);
								injAppointmentDetails.setNoOfDays(noOfDaysList.get(i));
								injAppointmentDetails.setStatus("p");
								injAppointmentDetails.setFinalStatus("n");
								hbt.save(injAppointmentDetails);
							}
							}
							//added by govind 22-9-2016 end
							}
						
						
					}

					
				}
			}
			
			
			/*Prescription Grid End */
			
			
			
			/*Investigation Grid Start*/ 
			List<String> isPackageList = (List) mapForDS.get("isPackageList");
			List<String> chargeCodeIdList = (List) mapForDS.get("chargeCodeIdList");
			List<String> clinicalList = (List) mapForDS.get("clinicalList");
			List<String> availableStatusList = (List) mapForDS.get("availableStatusList");
			StringBuffer parkInvestigations = (StringBuffer) mapForDS.get("parkInvestigations");
			List<String> parkInvestigationIds = (List<String>)  mapForDS.get("parkInvestigationIds");
			
			Date consultationDateToInsert = HMSUtil.convertStringTypeDateToDateType(consultationDate);
			
			if (chargeCodeIdList.size() > 0 && inpatientId==0) {
				MasDepartment masDepartment = new MasDepartment();
				//MasHospital masHospital = new MasHospital();
				MasEmployee masEmployee2 = new MasEmployee();
				PatientInvestigationHeader patientInvestigationHeader=null;
				String[] idArr=null;
				Integer pInvHdId=0;
				Integer pdgHdid=0;
				Integer pdgSamHdId=0;
				String dhHeaderIds="";
				
				if(dhHeaderIds!=null && !dhHeaderIds.equals("")){
					idArr=dhHeaderIds.split("-");
					pdgHdid=Integer.parseInt(idArr[0]);
					pInvHdId=Integer.parseInt(idArr[1]);
					pdgSamHdId=Integer.parseInt(idArr[2]);
				}
				if(pInvHdId!=null && !pInvHdId.equals(0) ){
					patientInvestigationHeader = hbt.load(PatientInvestigationHeader.class, pInvHdId);
				}else{
					patientInvestigationHeader = new PatientInvestigationHeader();
				}
				
				
				patient.setId(hinId);
				patientInvestigationHeader.setHin(patient);

				masDepartment.setId(departmentId);
				patientInvestigationHeader.setDepartment(masDepartment);
				patientInvestigationHeader.setVisit(visitObjToUpdate);
				masHospital.setId(hospitalId);
				patientInvestigationHeader.setHospital(masHospital);
				patientInvestigationHeader.setStatus("p");
				
				//patientInvestigationHeader.setOtherInvestigation(otherInvestigation);
				//patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);
				patientInvestigationHeader.setInvestigationDate(consultationDateToInsert);
				patientInvestigationHeader.setInvestigationTime(consultationTime);
				
				if(pInvHdId!=null && !pInvHdId.equals(0)){
					hbt.update(patientInvestigationHeader);
				}else{
					hbt.save(patientInvestigationHeader);
				}
				
				//opdPatientData.put("PatientInvestigationHeader", patientInvestigationHeader);
				DgOrderhd dgOrderhd=null;
				if(pdgHdid!=null && !pdgHdid.equals(0) ){
					dgOrderhd =(DgOrderhd) hbt.load(DgOrderhd.class, pdgHdid);
				}else{
					dgOrderhd = new DgOrderhd();
				}
			
				dgOrderhd.setOrderDate(consultationDateToInsert);
				dgOrderhd.setOrderTime(consultationTime);
				masHospital.setId(hospitalId);
				dgOrderhd.setHospital(masHospital);
				patient.setId(hinId);
				dgOrderhd.setHin(patient);
				masDepartment.setId(departmentId);
				dgOrderhd.setDepartment(masDepartment);
				if (masEmployee.getId() > 0) {
					masEmployee2.setId(masEmployee.getId());
					dgOrderhd.setPrescribedBy(masEmployee2);
				}

				dgOrderhd.setPatientType("OP");
				dgOrderhd.setTestType("Regular");
				dgOrderhd.setVisit(visitObjToUpdate);
				
				// dgOrderhd.setCreatedby(userName);
				// dgOrderhd.setCreatedon(consultationDateToInsert);

				String orderSeqNo = generateOrderNumber();
				dgOrderhd.setOrderNo(orderSeqNo);
				dgOrderhd.setOrderStatus("P");
				dgOrderhd.setLastChgBy(users);
				dgOrderhd.setLastChgDate(consultationDateToInsert);
				dgOrderhd.setLastChgTime(consultationTime);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				
				if(pdgHdid!=null && !pdgHdid.equals(0) ){
					hbt.update(dgOrderhd); 
				}else{
					hbt.save(dgOrderhd);
				}
				
				
				boolean labStatus=false;
				int count = 1;
				BigDecimal totalAmount = new BigDecimal(0);
				BigDecimal charge = new BigDecimal(0.00);

				List<Object> patientInvestigatinDetailsListObject = new ArrayList<Object>();
				List<Object> dgOrderDetailsListObject = new ArrayList<Object>();
				List<Object> dgSampleCollectionDeatilsListObject=new ArrayList<Object>();
				MasChargeCode persistedChargeCode=null;
				for (int i = 0; i < chargeCodeIdList.size(); i++) {
					String idStr=parkInvestigationIds.get(i);
					Integer pInvDtId=0;
					Integer pDtId=0;
					Integer pdgSamDtId=0;
					System.out.println("idStr "+idStr);
					if(idStr!=null && !idStr.equals("")){
						String[] idArrInv=idStr.split("-");
						pDtId=Integer.parseInt(idArrInv[0]);
						pInvDtId=Integer.parseInt(idArrInv[1]);
						pdgSamDtId=Integer.parseInt(idArrInv[2]);
					}
					
					PatientInvestigationDetails patientInvestigationDetails = null;
					if(pInvDtId!=null && !pInvDtId.equals(0)){
						patientInvestigationDetails	= hbt.load(PatientInvestigationDetails.class, pInvDtId);
					}else{
						patientInvestigationDetails = new PatientInvestigationDetails();
						
					}
					
					
					
					 persistedChargeCode = (MasChargeCode) session.get(MasChargeCode.class,Integer.parseInt(chargeCodeIdList.get(i)));
					String billingStatus = persistedChargeCode.getBillingStatus();
					patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setClinicalNotes(clinicalList.get(i));
					patientInvestigationDetails.setAvailableStatus(availableStatusList.get(i));
					
					if(visitObjToUpdate!=null && visitObjToUpdate.getVisitStatus().equalsIgnoreCase("p")
							&& pInvDtId!=null && !pInvDtId.equals(0)){
						hbt.update(patientInvestigationDetails);
					}else{
						hbt.save(patientInvestigationDetails);
					}
					
					DgOrderdt dgOrderdt=null;
					if(pDtId!=null && !pDtId.equals(0)){
						dgOrderdt	=(DgOrderdt) hbt.load(DgOrderdt.class, pDtId);
						
					}else{
						dgOrderdt = new DgOrderdt();
					}
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					dgOrderdt.setChargeCode(masChargeCode);

					dgOrderdt.setOrderQty(1);
				
					dgOrderdt.setOrderStatus("P");
					if (persistedChargeCode.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equals("DIAG")) {
						dgOrderdt.setPaymentMade("n");
					} else {
						dgOrderdt.setPaymentMade("n");
					}

					totalAmount.add(charge);

					dgOrderdt.setAmount(charge);

					dgOrderdt.setLastChgBy(users);
					dgOrderdt.setLastChgDate(consultationDateToInsert);
					dgOrderdt.setLastChgTime(consultationTime);
					dgOrderdt.setMsgSent("n");
					dgOrderdt.setPacsStatus("n");
					// method written for taking out the values of mascharge
					// code and subcharge
					Map masChargeMap = getMasChargeCodeFromChargeId(Integer.parseInt(chargeCodeIdList.get(i)));
					MasChargeCode masChargeCodeObj = (MasChargeCode) masChargeMap.get("masChargeCode");
					int mainChargeId = masChargeCodeObj.getMainChargecode().getId();
					int subChargeId = masChargeCodeObj.getSubChargecode().getId();
					MasMainChargecode masMainChargecode = new MasMainChargecode();
					masMainChargecode.setId(mainChargeId);
					dgOrderdt.setMainChargecode(masMainChargecode);
					MasSubChargecode masSubChargecode = new MasSubChargecode();
					masSubChargecode.setId(subChargeId);
					dgOrderdt.setSubChargeid(masSubChargecode);
					
					if(visitObjToUpdate!=null && visitObjToUpdate.getVisitStatus().equalsIgnoreCase("p")
							&& pDtId!=null && !pDtId.equals(0)){
						hbt.update(dgOrderdt);
					}else{
						hbt.save(dgOrderdt);
					}
					
					DgSampleCollectionHeader collHeader=null;
					if(pdgSamHdId!=null && pdgSamHdId!=0 ){
						collHeader =(DgSampleCollectionHeader) hbt.load(DgSampleCollectionHeader.class, pdgSamHdId);
					}else{
						collHeader = new DgSampleCollectionHeader();
					}
					
					
					if(persistedChargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO") && count == 1) {
						if (hinId != 0) {
							Patient patient1 = new Patient();
							patient1.setId(hinId);
							collHeader.setHin(patient1);
						}
						MasDepartment department = new MasDepartment();
						department.setId(persistedChargeCode.getMainChargecode().getDepartment().getId());
						collHeader.setDepartment(department);
						collHeader.setHospital(new MasHospital(hospitalId));
						collHeader.setOrder(dgOrderhd);
						collHeader.setDiagnosisDate(consultationDateToInsert);
						collHeader.setDiagnosisTime(consultationTime);
						collHeader.setOrderStatus("P");
						collHeader.setSampleValidationDate(consultationDateToInsert);
						collHeader.setSampleValidationTime(consultationTime);
						collHeader.setLastChgBy(users);
						collHeader.setLastChgDate(consultationDateToInsert);
						collHeader.setLastChgTime(consultationTime);
						PharmacyLabQueue radioQueue=null;
			//  Added by dhananjay 03-01-2016
					
			if(persistedChargeCode.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO") && count == 1){
			String raiodlabcheck="R";
					radioQueue=saveQueueNoForRadio(radiologyDepartmentId,hospitalId,visitObjToUpdate,raiodlabcheck);
							
				}
			//End
						collHeader.setPharmacyLabQueueId(radioQueue);
						if(pdgSamHdId!=null && pdgSamHdId!=0){
							hbt.update(collHeader);
						}else{
							hbt.save(collHeader);
						}
					
						
						count++;
					}
					if (persistedChargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO")) {
						DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
						if(pdgSamDtId!=null && !pdgSamDtId.equals(0)){
							collDetails	=(DgSampleCollectionDetails) hbt.load(DgSampleCollectionDetails.class, pdgSamDtId);
						}else{
							 collDetails = new DgSampleCollectionDetails();
						}
						
						Criteria c = session.createCriteria(DgSampleCollectionHeader.class).addOrder(Order.desc("Id"));
						c.setFirstResult(0);
						c.setMaxResults(1);
						collDetails.setSampleCollectionHeader(((DgSampleCollectionHeader) c.list().get(0)));
						collDetails.setChargeCode(masChargeCode);
						int subChargecodeId = 0;
						subChargecodeId = dgOrderdt.getSubChargeid().getId();
						MasSubChargecode subChargecode=(MasSubChargecode) hbt.load(MasSubChargecode.class, subChargecodeId);
						String diagNo = generateDiagNumber(persistedChargeCode.getSubChargecode().getId(),hospitalId,dgOrderdt,
								subChargecode.getSubChargecodeCode(),users);
						collDetails.setDiagNo(diagNo);
						collDetails.setCollected("y");
						collDetails.setLastChgBy(users);
						collDetails.setLastChgDate(consultationDateToInsert);
						collDetails.setLastChgTime(currentTime);
						collDetails.setOrderStatus("P");
						collDetails.setSampleCollDatetime(consultationDateToInsert);
						MasMainChargecode maincharge = new MasMainChargecode();
						maincharge.setId(persistedChargeCode.getMainChargecode().getId());
						collDetails.setMaincharge(maincharge);
						MasSubChargecode subCharge = new MasSubChargecode();
						subCharge.setId(persistedChargeCode.getSubChargecode().getId());
						collDetails.setSubcharge(subCharge);
						DgMasInvestigation investigation = new DgMasInvestigation();
						investigation.setId(persistedChargeCode.getId());
						collDetails.setInvestigation(investigation);
						collDetails.setSampleCollDatetime(new Date());
						
						if(visitObjToUpdate!=null && visitObjToUpdate.getVisitStatus().equalsIgnoreCase("p")
								&& pdgSamDtId!=null && !pdgSamDtId.equals(0)){
							hbt.update(collDetails);
						}else{
							hbt.save(collDetails);
						}
						dgSampleCollectionDeatilsListObject.add(collDetails);
					}
					// Dhananjay 19-jan-2017
					if(persistedChargeCode.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equals("DIAG")){
						labStatus=true;		
						}
					
				}
			//  Added by dhananjay 03-01-2017
				if(labStatus){
					String Labcheck="L";
					saveQueueNoForPharmacyAndLab(labDepartmentId,hospitalId,visitObjToUpdate,Labcheck,dgOrderhd);					
					}
					//End
				
				dgOrderhd.setNetAmount(totalAmount);
				hbt.update(dgOrderhd);
				
	}else if(chargeCodeIdList.size()>0 && inpatientId>0){
		
		 List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
		  wardreamarksList=session.createCriteria(WardRemarks.class).createAlias("Hospital", "hospital")
				  .add(Restrictions.eq("hospital.Id",hospitalId ))
				  .add(Restrictions.eq("Inpatient.Id", inpatientId)).add(Restrictions.eq("Status", "P").ignoreCase())
				  //.add(Restrictions.eq("Doctor.Id", employeeId))
				  .list();
		
		PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
		patientInvestigationHeader.setHin(patient);
		
		if(wardreamarksList.size()>0){
			MasDepartment md = new MasDepartment();
			md.setId(inPatient.getDepartment().getId());
			patientInvestigationHeader.setDepartment(md);
		}else{
			MasDepartment md = new MasDepartment();
			md.setId(departmentId);
			patientInvestigationHeader.setDepartment(md);
		}
		
		patientInvestigationHeader.setInpatient(inPatient);
		patientInvestigationHeader.setHospital(masHospital);
		patientInvestigationHeader.setStatus("p");
		patientInvestigationHeader.setInvestigationDate(new Date());
		patientInvestigationHeader.setInvestigationTime(currentTime);
		//patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);
		patientInvestigationHeader.setInvestigationBy(masEmployee);
		hbt.save(patientInvestigationHeader);
		
		DgOrderhd dgOrderhd = new DgOrderhd();
		dgOrderhd.setOrderDate(new Date());
		dgOrderhd.setOrderTime(currentTime);
		dgOrderhd.setHospital(masHospital);
		dgOrderhd.setInpatient(inPatient);
		dgOrderhd.setHin(patient);
		
		if(wardreamarksList.size()>0){
			MasDepartment md = new MasDepartment();
			md.setId(inPatient.getDepartment().getId());
			dgOrderhd.setDepartment(md);
		}else{
			MasDepartment md = new MasDepartment();
			md.setId(departmentId);
			dgOrderhd.setDepartment(md);
		}
		
		dgOrderhd.setPrescribedBy(masEmployee);
		dgOrderhd.setPatientType("IP");
		dgOrderhd.setTestType("Regular");
		
		
		
		String orderSeqNo = generateOrderNumber();
		
		dgOrderhd.setOrderNo(orderSeqNo);
		
		dgOrderhd.setOrderStatus("P");
		dgOrderhd.setLastChgBy(users);
		dgOrderhd.setLastChgDate(new Date());
		dgOrderhd.setLastChgTime(consultationTime);
		dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
		DgSampleCollectionHeader collHeader = null;
		hbt.save(dgOrderhd);
		
		List<Object> patientInvestigatinDetailsListObject = new ArrayList<Object>();
		List<Object> dgOrderDetailsListObject = new ArrayList<Object>();
		List<Object> dgSampleCollectionDeatilsListObject=new ArrayList<Object>();
		
		/*float totalPkgAmount = 0.00f;
		float totalPkgServiceAmount = 0.00f;
		
		for (int i = 1; i <= chargeCodeIdList.size(); i++) {					
			if((isPackageList.get(i)!=null && isPackageList.get(i).trim().equalsIgnoreCase("y")) &&
					(chargeCodeIdList.get(i)!=null && !chargeCodeIdList.get(i).equals(""))){
				
				MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeIdList.get(i)));
				totalPkgServiceAmount = totalPkgServiceAmount+ chargeCode.getCharge();
				
				
			}
			
		}*/
		
		for (int i = 0; i < chargeCodeIdList.size(); i++) {
			
			MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeIdList.get(i)));
			PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
			patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
			
			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
			patientInvestigationDetails.setChargeCode(masChargeCode);
			patientInvestigationDetails.setQuantity(1);   // default quantity is 1
			patientInvestigationDetails.setClinicalNotes(clinicalList.get(i));
			hbt.save(patientInvestigationDetails);
			
			DgOrderdt dgOrderdt = new DgOrderdt();
			dgOrderdt.setOrderhd(dgOrderhd);
			masChargeCode.setId(Integer.parseInt(chargeCodeIdList.get(i)));
			dgOrderdt.setChargeCode(masChargeCode);
			dgOrderdt.setOrderQty(1);
			
			dgOrderdt.setLastChgBy(users);
			dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
			dgOrderdt.setLastChgTime(consultationTime);
			
			List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
			masChargeList = session.createCriteria(MasChargeCode.class).add(
					Restrictions.eq("Id", Integer.parseInt(chargeCodeIdList.get(i)))).list();
			
			MasChargeCode masChargeCodeObj = masChargeList.get(0);
			int mainChargeId = masChargeCodeObj.getMainChargecode().getId();
			int subChargeId = masChargeCodeObj.getSubChargecode().getId();
			if (masChargeCodeObj.getMainChargecode()
					.getMainChargecodeCode().equalsIgnoreCase("Lab")) {
				dgOrderdt.setOrderStatus("P");
			} else {
				dgOrderdt.setOrderStatus("P");
			}
			
			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargeId);
			dgOrderdt.setMainChargecode(masMainChargecode);
			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subChargeId);
			dgOrderdt.setSubChargeid(masSubChargecode);
			dgOrderdt.setPaymentMade("n");
			dgOrderdt.setMsgSent("n");
			dgOrderdt.setPacsStatus("n");
			dgOrderdt.setPaymentMade("n");
			hbt.save(dgOrderdt);
			
			if (chargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO")) {
				
				
				
				if(collHeader==null)
				{
				collHeader=new DgSampleCollectionHeader();
				collHeader.setHin(patient);
				collHeader.setInpatient(inPatient);

				if (chargeCode!= null) {
					collHeader.setDepartment(chargeCode.getDepartment());
				}
				collHeader.setHospital(masHospital);
				collHeader.setOrder(dgOrderhd);
				collHeader.setDiagnosisDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
				collHeader.setDiagnosisTime(consultationTime);
				collHeader.setOrderStatus("P");
				collHeader.setLastChgBy(users);
				collHeader.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
				collHeader.setLastChgTime(consultationTime);
				hbt.save(collHeader);
				//ipdPatientData.put("DgSampleCollectionHeader", collHeader);

				}
				// -----------------------in sample
				// detail----------------------------
					DgSampleCollectionDetails sampleDetails = new DgSampleCollectionDetails();
					sampleDetails
							.setSampleCollectionHeader(collHeader);
					sampleDetails.setChargeCode(masChargeCode);
					sampleDetails.setCollectedBy(masEmployee);
					// sampleDetails.setSample(sample);
					sampleDetails.setCollected("y");
					sampleDetails.setLastChgBy(users);
					sampleDetails.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
					sampleDetails.setLastChgTime(consultationTime);
					sampleDetails.setOrderStatus("P");
					sampleDetails.setSampleCollDatetime(HMSUtil.dateFormatterDDMMYYYY(consultationDate));

					MasMainChargecode maincharge = new MasMainChargecode();
					sampleDetails.setMaincharge(chargeCode.getMainChargecode());

					MasSubChargecode subCharge = new MasSubChargecode();
					subCharge.setId(chargeCode.getSubChargecode()
							.getId());
					sampleDetails.setSubcharge(subCharge);
					DgMasInvestigation investigation = new DgMasInvestigation();
					investigation.setId(Integer.parseInt(chargeCodeIdList.get(i)));
					sampleDetails.setInvestigation(investigation);
					sampleDetails.setSampleCollDatetime(new Date());
					hbt.save(sampleDetails);
					dgSampleCollectionDeatilsListObject.add(sampleDetails);
				
			}
			
		}
		
	}
			
			/*Investigation Grid End */
			
			/*MultiReferral Start*/
			List<Visit> visitList=new ArrayList<Visit>();
			int visitNo=0;
			int opHospitalSerialNo=0;
			
			
			if(serviceCentersList.size()>0){
				for(int i=0;i<serviceCentersList.size();i++){
					mapForDS.put("currentPriority", 3);
					List<String> deptsList=new ArrayList<String>();
					deptsList.add(String.valueOf(serviceCentersList.get(i)));
					mapForDS.put("departmentIdlist", deptsList);
					
					
					visitList = session.createCriteria(Visit.class).createAlias("Hospital", "hospitalId")
							.add(Restrictions.eq("hospitalId.Id", hospitalId))
							.add(Restrictions.eq("Hin.Id", hinId)).list();
					
				if (visitList.size() > 0) {
					for (Visit vist : visitList) {
						visitNo = vist.getVisitNo();
						opHospitalSerialNo=vist.getTotalHospitalVisit();
					}
					
				}
				
				mapForDS.put("opHospitalSerialNo", opHospitalSerialNo);
				mapForDS.put("currentVisitNo", visitNo);
				mapForDS.put("age",visitObjToUpdate.getAge());
				mapForDS.put("referalStatus","y");
				mapForDS.put("visitDate",new Date());
				mapForDS.put("visitTime",currentTime);
				mapForDS.put("userObj", users);
				mapForDS.put("opsessionId", opSessionList.get(i));
				mapForDS.put("opdreferal", "y");
				
				
				Map<String,Object> map=registrationDataService.saveVisitInformation(mapForDS);
				
			}
			/*MultiReferral End*/
			
		}
		tx.commit();
		mapForDS.put("status",true);
	}catch(Exception e){
		if(tx != null){
			tx.rollback();
		}
		mapForDS.put("status",false);
		return mapForDS;
	}
		return mapForDS;
	}

	@Override
	public Map<String, Object> showOpPacHistory(Map<String, Object> mapForDS) {
		Session session = (Session) getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<OpdSurgeryHeader> opdSurgeryList = new ArrayList<OpdSurgeryHeader>();
		Map<String,String> labResultMap=new HashMap<String,String>();
		int lastVisit=0;
		if(mapForDS.get("lastVisit")!=null){
			lastVisit=Integer.parseInt(String.valueOf(mapForDS.get("lastVisit")));
		}
		int otPreAnesthesiaDtlId=0;
		if(mapForDS.get("otPreAnesthesiaDtlId")!=null){
			otPreAnesthesiaDtlId=Integer.parseInt(String.valueOf(mapForDS.get("otPreAnesthesiaDtlId")));
		}
		int opdSurgeryId = (Integer) mapForDS.get("opdSurgeryId");
		int hospitalId = (Integer) mapForDS.get(HOSPITAL_ID);
		opdSurgeryList = session.createCriteria(OpdSurgeryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Id", opdSurgeryId)).list();
		OpdSurgeryHeader opdSurgeryHeader = (OpdSurgeryHeader) opdSurgeryList.get(0);
		map.put("opdSurgeryHeader", opdSurgeryHeader);
		
		int hinId=0;
		if(opdSurgeryHeader.getVisit()!=null){
			hinId=opdSurgeryHeader.getVisit().getHin().getId();
		}
		
		List<PatientPrescriptionDetails> patientPrescriptionDetailList = new ArrayList<PatientPrescriptionDetails>();
		
		patientPrescriptionDetailList = session
				.createCriteria(PatientPrescriptionDetails.class)
				.createAlias("Prescription", "Prescription")
				.createAlias("Prescription.Visit", "visit")
				.add(Restrictions.eq("visit.Id", lastVisit)).list();
		map.put("patientPrescriptionDetailList", patientPrescriptionDetailList);
		
		List<OpdPatientAllergyT> BlockedMedicineList=new ArrayList<OpdPatientAllergyT>();
		BlockedMedicineList=session.createCriteria(OpdPatientAllergyT.class)
		.createAlias("OpdPatientAllergy", "opdPatientAllergy")
		.createAlias("opdPatientAllergy.Visit", "visit")
		.add(Restrictions.eq("visit.Id",lastVisit))
		.add(Restrictions.eq("BlockedStatus", "y").ignoreCase()).list();
		
		if(BlockedMedicineList.size()>0){
			map.put("BlockedMedicineList", BlockedMedicineList);
		}
		
	
	if(otPreAnesthesiaDtlId>0){
		OtPreAnesthesiaDetails otPreAnesthesiaDetails=(OtPreAnesthesiaDetails)session.load(OtPreAnesthesiaDetails.class, otPreAnesthesiaDtlId);
		map.put("otPreAnesthesiaDetails", otPreAnesthesiaDetails);
		List<AacAcceptance> aacAcceptList=new ArrayList<AacAcceptance>();
		AacAcceptance aacAcceptance=new AacAcceptance();
		
		aacAcceptList=session.createCriteria(AacAcceptance.class)
				.add(Restrictions.eq("OtPreAnesthesiaDetails.Id", otPreAnesthesiaDtlId))
				.setMaxResults(1).list();
		if(aacAcceptList.size()>0){
			aacAcceptance=aacAcceptList.get(0);
			map.put("aacAcceptance", aacAcceptance);
		}
		
        List<ExternalLabReportCommon> labReportList=new ArrayList<ExternalLabReportCommon>();
		labReportList=session.createCriteria(ExternalLabReportCommon.class)
				.createAlias("OtPreAnesthesiaDetails", "otDetails")
				.add(Restrictions.eq("otDetails.Id", otPreAnesthesiaDtlId)).list();
		
		if(labReportList.size()>0){
			
			for(ExternalLabReportCommon labResult:labReportList){
				labResultMap.put(labResult.getTestName(), labResult.getTestResult());
			}
			
		}
		
	    map.put("labResultMap", labResultMap);
	    
	    List<PatientInvestigationHeader> investigationHdrList=new ArrayList<PatientInvestigationHeader>();
	    investigationHdrList=session.createCriteria(PatientInvestigationHeader.class)
	    		.add(Restrictions.eq("Visit.Id", lastVisit)).list();
	    if(investigationHdrList.size()>0){
	    	int investigationHdrId=0;
	    	investigationHdrId=investigationHdrList.get(0).getId();
	    	if(investigationHdrId>0){
	    		List<PatientInvestigationDetails> investigationDtlList=new ArrayList<PatientInvestigationDetails>();
	    		investigationDtlList=session.createCriteria(PatientInvestigationDetails.class)
	    				.add(Restrictions.eq("InvestigationHeader.Id", investigationHdrId)).list();
	    		if(investigationDtlList.size()>0){
	    			map.put("investigationDetails", investigationDtlList);
	    		}
	    	}
	    	
	    }
		
	}
	
	return map;	
	}

	@Override
	public int getEmployeeIdFromUser(int userId) {
		Session session = (Session) getSession();
		Users user=(Users)session.load(Users.class, userId);
		
		return user.getEmployee().getId();
	}

	@Override
	public Map<String, Object> showTableWiseOtList(Map<String, Object> mapForDS) {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		Session session = (Session) getSession();
		List<OtBooking> otBookingList=new ArrayList<OtBooking>();
		Date fromDate=null;
		Date toDate=null;
		int hospitalId=0;
		String query="select * from ot_booking booking inner join mas_bed bed on booking.bed_id=bed.bed_id ";
		
		 if(mapForDS.get("doctorId")!=null){
	        	query=query+"inner join ot_book_surgeon surgeon on surgeon.booking_id=booking.booking_id where surgeon.employee_id="+(Integer)mapForDS.get("doctorId")+" and ";
			}else{
				query=query+" where ";
			}
		
		if(mapForDS.get("fromDate")!=null){
			fromDate=(Date)mapForDS.get("fromDate");
			String fromDateStr=HMSUtil.getDateFormat(fromDate, "yyyy-MM-dd");
			query=query+"booking.surgery_date between '"+fromDateStr+"'";
		}
		if(mapForDS.get("toDate")!=null){
			toDate=(Date)mapForDS.get("toDate");
			String toDateStr=HMSUtil.getDateFormat(toDate, "yyyy-MM-dd");
			query=query+" and '"+toDateStr+"'";
		}
		
		if(mapForDS.get("hospitalId")!=null){
			hospitalId=(int) mapForDS.get("hospitalId");
			query=query+" and booking.hospital_id="+hospitalId;
		}
		
		if(mapForDS.get("theaterId")!=null){
			query=query+" and booking.department_id="+(Integer)mapForDS.get("theaterId");
		}
        if(mapForDS.get("unitId")!=null){
        	query=query+" and booking.unit_id="+(Integer)mapForDS.get("unitId");
		}
        if(mapForDS.get("tableId")!=null){
        	query=query+" and booking.bed_id="+(Integer)mapForDS.get("tableId");
        	
        	MasBed table=(MasBed) session.load(MasBed.class, (Integer)mapForDS.get("tableId"));
        	mapForDS.put("table", table);
		}
        
        if(mapForDS.get("toDate")!=null){
        	query=query+" order by bed.bed_id asc";
        	SQLQuery qry=session.createSQLQuery(query);
            otBookingList=qry.addEntity(OtBooking.class).list();
        }
        
		mapForDS.put("otBookingList", otBookingList);
		
		List<MasDepartment> theaterList=new ArrayList<MasDepartment>();
		
		theaterList=session.createCriteria(MasDepartment.class)
				    .createAlias("DepartmentType", "depType")
				    .createAlias("Hospital", "hospital")
				    .add(Restrictions.eq("Status", "y").ignoreCase())
				    .add(Restrictions.eq("depType.DepartmentTypeCode", "OPR").ignoreCase())
				    .add(Restrictions.eq("hospital.Id", hospitalId))
				    .list();
		
		mapForDS.put("theaterList", theaterList);
		
		List<HospitalDoctorUnitM> doctorUnit = new ArrayList<HospitalDoctorUnitM>();
		doctorUnit = session.createCriteria(HospitalDoctorUnitM.class, "um")
				.add(Restrictions.eq("um.Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		mapForDS.put("doctorUnit", doctorUnit);
		
		List<MasEmployee> doctorsList=new ArrayList<MasEmployee>();
		
		doctorsList=session.createCriteria(MasEmployee.class)
				.createAlias("EmpCategory", "empCategory")
				.add(Restrictions.eq("empCategory.Id", 4))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		
		mapForDS.put("doctorsList", doctorsList);
				
		return mapForDS;
	}
	
	
}
