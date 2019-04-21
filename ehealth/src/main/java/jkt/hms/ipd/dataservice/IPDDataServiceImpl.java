package jkt.hms.ipd.dataservice;

import static jkt.hms.util.RequestConstants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.CallableStatement;
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

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.lab.dataservice.LabDataService;
import jkt.hms.masters.business.*;
import jkt.hms.opd.dataservice.OPDDataServiceImpl;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.PatientCaseSheetDetails;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.TaperedMedicineUtil;













import org.apache.log4j.Logger;
//commented for maven
/*import org.apache.commons.cli.GnuParser;*/
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.message.ORM_O01;
import ca.uhn.hl7v2.model.v22.segment.OBR;
import ca.uhn.hl7v2.model.v22.segment.ORC;
import ca.uhn.hl7v2.model.v22.segment.PID;
import ca.uhn.hl7v2.model.v22.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

//import jkt.hms.masters.business.Smsout;

public class IPDDataServiceImpl extends HibernateDaoSupport implements
		IPDDataService {
	/*
	 * Code for read from property file from src package
	 */
	private static final Logger logger = Logger.getLogger(IPDDataServiceImpl.class);
	private LabDataService labDataService;
	
	@Autowired
	private OPDDataServiceImpl opdDataServiceImpl;
	
	public LabDataService getLabDataService() {
		return labDataService;
	}

	public void setLabDataService(LabDataService labDataService) {
		this.labDataService = labDataService;
	}
	private RegistrationDataService registrationDataService= null;
	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	Properties properties = new Properties();
	{
		try {
			ClassLoader loader = getClass().getClassLoader();
			InputStream inStream = loader.getResourceAsStream("adt.properties");
			properties.load(inStream);
		} catch (IOException e) {
			//
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientList(int deptId, int hospitalId,int userId) {
		/*Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		String takeSetFromSessionInJsp = "";
		String deptName = "";
		List objectList = new ArrayList();

		int waitingCount = 0;

		String qry = "select count(*) from inpatient where department_id='"
				+ deptId + "'  and ad_status='W';";

		try {

			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();

			inPatientSet = session
					.createCriteria(Inpatient.class, "ip")
					.add(Restrictions.in("ip.AdStatus",
							new String[] { "A", "R" }))
					.add(Restrictions.eq("ip.Department.Id", deptId))
					.add(Restrictions.eq("ip.Hospital.id", hospitalId))
					.addOrder(Order.desc("DateOfAddmission")).list();

			inPatientSet = session

					.createQuery(

							"select ip from Inpatient as ip where ip.AdStatus in ('A','R') and  ip.Department.Id="

									+ deptId

									+ "order by (DateOfAddmission)desc").list();

			objectList = (List) session.createSQLQuery(qry).list();

			if (objectList.get(0) != null) {
				waitingCount = Integer.parseInt("" + objectList.get(0));
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
			takeSetFromSessionInJsp = "false";
		}

		Iterator itr = inPatientSet.iterator();
		while (itr.hasNext()) {
			Inpatient inPatient = (Inpatient) itr.next();
			String dateOfAdmissionInString = HMSUtil
					.changeDateToddMMyyyy(inPatient.getDateOfAddmission());
		}

		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("inpatientSet", inPatientSet);

		map.put("deptName", deptName);

		map.put("waitingCount", waitingCount);

		return map;*/
																			 

		Session session = (Session) getSession();
		List<Users>userList=new ArrayList<Users>();
		userList=session.createCriteria(Users.class).add(Restrictions.eq("Id", userId)).list();
		int empId=0;
		for(Users users:userList){
			empId=users.getEmployee().getId();
		}
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		List<MasBed> bedNoList = new ArrayList<MasBed>();
		List<OpdPatientDetails> opdDetailsList = new ArrayList<OpdPatientDetails>();
		List<HospitalParameters> hospitalParameterList = new ArrayList<HospitalParameters>();
		List<WardRemarks>wardList=new ArrayList<WardRemarks>();
		List<OtPreAnesthesiaDetails>otDetailsList=new ArrayList<OtPreAnesthesiaDetails>();
		List<BloodIssueDetail> bldIssudeDetailList = new ArrayList<BloodIssueDetail>();
		wardList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Doctor.Id", empId)).add(Restrictions.eq("Status", "P").ignoreCase()).list();
		Map<String, Object> map = new HashMap<String, Object>();
		String mesageForNurse="";
		String bedStatusUnOccupiedName = "";
		String bedStatusOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
			bedStatusOccupiedName=prop
			.getProperty("bedStatusOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String deptName = "";
		List objectList = new ArrayList();
		int waitingCount = 0;
		try {
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			hospitalParameterList = session.createCriteria(HospitalParameters.class).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			inPatientSet = session
					.createCriteria(Inpatient.class, "ip")
					.add(Restrictions.in("ip.AdStatus",
							new String[] { "A", "R" }))
					.add(Restrictions.eq("ip.Department.Id", deptId))
					.add(Restrictions.eq("ip.Hospital.id", hospitalId))
					.addOrder(Order.desc("DateOfAddmission")).list();
			otDetailsList=session.createCriteria(OtPreAnesthesiaDetails.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.createAlias("Inpatient","ip")
					.add(Restrictions.in("ip.AdStatus",
							new String[] { "A", "R" }))
					.add(Restrictions.or(Restrictions.eq("ip.Department.Id", deptId),Restrictions.eq("Ward.Id", deptId)))
					.add(Restrictions.eq("BedArrangement", "y").ignoreCase())
					.list();
			if(otDetailsList.size()>0){
				mesageForNurse="Please arraange bed For";  
			for(OtPreAnesthesiaDetails OtPreAnesthesiaDetails :otDetailsList){
				
				if(OtPreAnesthesiaDetails.getInpatient()!=null && OtPreAnesthesiaDetails.getWard()!=null && OtPreAnesthesiaDetails.getRemarksBedArrangement()!=null){
				mesageForNurse+=" "+OtPreAnesthesiaDetails.getInpatient().getHin().getFullName()+" with UHID"+OtPreAnesthesiaDetails.getInpatient().getHinNo()+" from "+OtPreAnesthesiaDetails.getInpatient().getDepartment().getDepartmentName()+" to "+OtPreAnesthesiaDetails.getWard().getDepartmentName()+" ["+OtPreAnesthesiaDetails.getRemarksBedArrangement()+"] !!";
				}
			}
			}
			//	
			//
			// inPatientSet = session.createQuery("select ip from Inpatient as ip where ip.AdStatus in ('W','A','R')"
			// + " and  ip.Department.Id="
			// + deptId+" and ip.Hospital.Id="+hospitalId
			// + "order by (DateOfAddmission)desc").list();

			String qry = "select count(*) from inpatient where department_id='"
					+ deptId + "'  and ad_status='W' and hospital_id="
					+ hospitalId;
			objectList = (List) session.createSQLQuery(qry).list();
			if (objectList.get(0) != null) {
				waitingCount = Integer.parseInt("" + objectList.get(0));
			}
			
			//Added by Arbind on 04-11-2017
			bldIssudeDetailList =session.createCriteria(BloodIssueDetail.class)
					
					.createAlias("IssueHeader", "issueHeader")
					.createAlias("issueHeader.BldRequestHospitalId", "bldRequestHospitalId")
					.add(Restrictions.eq("BldAckPending", "A").ignoreCase())
					.add(Restrictions.eq("issueHeader.BldTransfussionStatus","P").ignoreCase())
					.add(Restrictions.eq("issueHeader.IssueDate", new Date())).list();
					//.add(Restrictions.eq("bldRequestHospitalId.Id", hospitalId)).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
		}

		bedNoList = session.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("BedType","p").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.asc("BedNo"))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.list();
		
		
/*List<MasBed> beds=new ArrayList<MasBed>();

		beds = session
				.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.asc("BedNo"))
				.createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode",
						bedStatusUnOccupiedName.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
				.add(Restrictions.isNull("VBed"))
				.list();*/
//		if(beds.size()==0)
//		{
			
			bedNoList.addAll(session.createCriteria(MasBed.class)
					.createAlias("BedStatus", "bs")
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("BedType","v").ignoreCase())
					.add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.asc("BedNo"))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusOccupiedName.toLowerCase()).ignoreCase())
					.list());
			List<MasDepartment> departmentListForDialysis = new ArrayList<MasDepartment>();			
			departmentListForDialysis = session
					.createCriteria(MasInstituteDepartment.class,"msd")
					.createAlias("msd.Department", "md")
					.createAlias("md.DepartmentType", "mdt")
					.createAlias("msd.Institute", "mh")
					.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("md.Id",deptId))
					.add(Restrictions.eq("md.Status", "Y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("mh.Id", hospitalId))
					.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
//		}

		/**
		 * For getting opd details Added By Ritu 20 March 2012
		 */
		List<PatientCaseSheetDetails> caseSheetDetails = new ArrayList<PatientCaseSheetDetails>();
		if (inPatientSet.size() > 0) {
			for (Inpatient inpatient : inPatientSet) {
				// Set<InpatientPrescriptionHeader> presHdSet = new  HashSet<InpatientPrescriptionHeader>();
				Set<InpatientPrescriptionDetails> presDt = new HashSet<InpatientPrescriptionDetails>();
				/*
				 * Set<ProcedureHeader> procedureHeaderSet = new
				 * HashSet<ProcedureHeader>(); Set<ProcedureDetails>
				 * procedureDetailsSet = new HashSet<ProcedureDetails>();
				 */
				List<NursingcareSetup> procedureList = new ArrayList<NursingcareSetup>();

				/*
				 * Set<PhysioRequisitionHeader> physioHeaderSet = new
				 * HashSet<PhysioRequisitionHeader>();
				 * Set<PhysioRequisitionDetail> physioDetailsSet = new
				 * HashSet<PhysioRequisitionDetail>();
				 */

				String treatment = "";
				String procedure = "";
				String physioTherapy = "";
				String nursingCare = "";
				String diagnosis = "";
				int inpatientId = inpatient.getId();
				int visitId = 0;
				int hinId = inpatient.getHin().getId();
				//List<OpdPatientDetails> patientOpdDtList = new ArrayList<OpdPatientDetails>();
				/**
				 * For Treatment
				 */
				List<InpatientPrescriptionHeader> presHd = new ArrayList<InpatientPrescriptionHeader>();
				presHd = session
						.createCriteria(InpatientPrescriptionHeader.class)
						.add(Restrictions.eq("Inpatient.Id", inpatientId))
						.addOrder(Order.desc("Id")).setMaxResults(1).list();
				if (presHd.size() == 0) {
					presHd = session
							.createCriteria(InpatientPrescriptionHeader.class)
							.add(Restrictions.eq("Hin.Id", inpatient.getHin()
									.getId())).addOrder(Order.desc("Id"))
							.setMaxResults(1).list();
				}

				if (presHd.size() != 0) {
					InpatientPrescriptionHeader presHeader = presHd.get(0);
					if (presHeader.getPrescription() != null) {
						presDt = presHeader.getPrescription();
						if (presHeader.getVisit() != null)
							visitId = presHeader.getVisit().getId();

						for (InpatientPrescriptionDetails presDetails : presDt) {
							if (!treatment.equals("")) {
								treatment += ",<div class='clear'></div>";
							}
							treatment += presDetails.getItem()
									.getNomenclature()
									+ " ";
							if(presDetails.getFrequency()!=null){
								treatment +=presDetails.getFrequency()
											.getFrequencyName();
							}

						}
					}
				}

				procedureList = session
						.createCriteria(NursingcareSetup.class)
						.add(Restrictions.eq("Inpatient.Id", inpatient.getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.list();
				if (procedureList.size() > 0) {
					for (NursingcareSetup nursingcareSetup : procedureList) {
						if (!procedure.equals("")) {
							procedure += ",<div class='clear'></div>";
						}
						procedure += nursingcareSetup.getNursing()
								.getNursingName();

					}
				}

				/*
				 * if(inpatient.getPhysioRequisitionHeaders()!=null &&
				 * inpatient.getPhysioRequisitionHeaders().size() >0){
				 * physioHeaderSet = inpatient.getPhysioRequisitionHeaders();
				 * 
				 * }else{ if(patientOpdDtList.size() > 0){ physioHeaderSet =
				 * patientOpdDtList.get(0).getPhysioRequisitionHeaders(); } }
				 * if(physioHeaderSet.size() > 0){ for(PhysioRequisitionHeader
				 * physioHeader : physioHeaderSet){
				 * if(physioHeader.getPhysioRequisitionDetails()!=null){
				 * physioDetailsSet =
				 * physioHeader.getPhysioRequisitionDetails(); } }
				 * if(physioDetailsSet.size() > 0){ for(PhysioRequisitionDetail
				 * physioDetails : physioDetailsSet){
				 * if(!physioTherapy.equals("")){ physioTherapy
				 * +=",<div class='clear'></div>"; } physioTherapy +=
				 * physioDetails.getTharaphy().getTherapyTypeName();
				 * 
				 * } } }
				 */

				if (inpatient.getNursingcareSetups() != null
						&& inpatient.getNursingcareSetups().size() > 0) {
					for (NursingcareSetup nursingcareSetup : inpatient
							.getNursingcareSetups()) {
						if (!nursingCare.equals("")) {
							nursingCare += ",";
						}
						if (nursingcareSetup.getNursing() != null)
							nursingCare += nursingcareSetup.getNursing()
									.getNursingName();

					}
				} else {
					List<OpdPatientHistory> patientOpdHistoryList = new ArrayList<OpdPatientHistory>();
					patientOpdHistoryList = session
							.createCriteria(OpdPatientHistory.class)
							.createAlias("OpdPatientDetails", "opd")
							.createAlias("opd.Visit", "v")
							.createAlias("v.Hin", "hin")
							.add(Restrictions.eq("hin.Id", inpatient.getHin()
									.getId())).addOrder(Order.desc("Id"))
							.setMaxResults(1).list();
					/*
					 * if(patientOpdHistoryList.size() > 0){ nursingCare +=
					 * patientOpdHistoryList.get(0).getPresentAdvice(); }
					 */
				}

				Map<String, Object> dtMap = new HashMap<String, Object>();
			    dtMap = getPatientLatestDiagnosisAndDisability(inpatientId);
				List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
				if (dtMap.get("diagnosisList") != null) {
					diagnosisList = (List<DischargeIcdCode>) dtMap
							.get("diagnosisList");
					if (diagnosisList.size() > 0)
						diagnosis = diagnosisList.get(0).getIcd() != null ? diagnosisList
								.get(0).getIcd().getIcdName()
								: "";

					/**
					 * End
					 */
					PatientCaseSheetDetails patientCaseSheetDetails = new PatientCaseSheetDetails();
					patientCaseSheetDetails.setInpatientId(inpatientId);
					patientCaseSheetDetails.setVisitId(visitId);
					patientCaseSheetDetails.setTreatmentDetails(treatment);
					patientCaseSheetDetails.setProcedureDetails(procedure);
					patientCaseSheetDetails
							.setPhysiotherapyDetails(physioTherapy);
					patientCaseSheetDetails.setNursingCareDetails(nursingCare);
					patientCaseSheetDetails.setDiagnosisDetails(diagnosis);
					patientCaseSheetDetails.setHinId(hinId);
					caseSheetDetails.add(patientCaseSheetDetails);

				}
			}
		}
		List<PatientWiseMlc> list=session.createCriteria(PatientWiseMlc.class)
									.add(Restrictions.eq("Hospital.Id", hospitalId))
									.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		Map<Integer,Object> mlcMap=new HashMap<Integer,Object>();
		for(PatientWiseMlc wiseMlc:list){
			if(wiseMlc.getInpatient()!=null){
				mlcMap.put(wiseMlc.getInpatient().getId(), wiseMlc);
			}
			
		}
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		otBookingList = session.createCriteria(OtBooking.class).add(Restrictions.eq("SurgeryStatus", "y").ignoreCase()).list();

		/**
		 * End
		 */
		map.put("otBookingList", otBookingList);
		map.put("caseSheetDetails", caseSheetDetails);
		map.put("inpatientSet", inPatientSet);
		map.put("deptName", deptName);
		map.put("waitingCount", waitingCount);
		map.put("bedNoList", bedNoList);
		map.put("opdDetailsList", opdDetailsList);
		map.put("hospitalParameterList", hospitalParameterList);
		map.put("wardList",wardList);
		//Changed by Arbind on 25-11-2017
		//map.put("deptList",deptList);
		map.put("deptListWard",deptList);
		map.put("referCount",wardList.size());
		map.put("departmentListForDialysis", departmentListForDialysis);
		map.put("mesageForNurse", mesageForNurse);
		map.put("mlcMap", mlcMap);
		map.put("bldIssudeDetailList", bldIssudeDetailList);
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

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> searchPatient(Map map) {
		Session session = (Session) getSession();
		List patientList = new ArrayList();

		int id = 0;
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		String serviceNumber = "";
		String hinNumber = "";
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		try {
			if (map.get("adNo") != null) {
				id = (Integer) map.get("adNo");
				// patientList=getHibernateTemplate().find(" from
				// jkt.hms.masters.business.Inpatient as inPatient where
				// inPatient.Id = "+id +" ");
				patientList = session.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Id", id))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				Inpatient inpatient = (Inpatient) patientList.get(0);
				inPatientSet.add(inpatient);
			} else if (map.get("hinNumber") != null) {
				hinNumber = (String) map.get("hinNumber");
				patientList = session.createCriteria(Inpatient.class, "ip")
						.createAlias("ip.Hin", "hin")
						.add(Restrictions.eq("ip.Department.Id", deptId))
						.add(Restrictions.eq("hin.HinNo", hinNumber))
						.add(Restrictions.eq("ip.Hospital.Id", hospitalId))
						.list();
				// patientList = session.createQuery(
				// "select ip from Inpatient as ip where  ip.Department.Id="
				// + deptId + " and ip.Hin.HinNo='" + hinNumber
				// + "'").list();
				if (patientList.size() > 0) {
					Inpatient inpatient = (Inpatient) patientList.get(0);
					inPatientSet.add(inpatient);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		// Map<String ,Object> map= new HashMap<String, Object>();

		map.put("inPatientSet", inPatientSet);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> nursingCareSetup(Box box) {

		//String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<IpdVitalSetup> ipdVitalSetupList = new ArrayList<IpdVitalSetup>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			inPatientDetailList = session
					.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", box.getInt("parent")))
					.add(Restrictions.in("AdStatus", new String[] { "A", "R" }))
					.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
					.list();
			nursingCareList = session.createCriteria(MasNursingCare.class)
					.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
			
			frequencyList = session.createCriteria(MasFrequency.class)
					.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();

//			if (inPatientDetailList != null) {
//				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
//				admissionNumber = inpatient.getAdNo();
//			}
			nursingCareSetupList = session
					.createCriteria(NursingcareSetup.class)
					.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
					.list();
			
			ipdVitalSetupList = session
					.createCriteria(IpdVitalSetup.class)
					.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("frequencyList", frequencyList);
		map.put("nursingCareSetupList", nursingCareSetupList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("nursingCareList", nursingCareList);
		map.put("ipdVitalSetupList", ipdVitalSetupList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addNursingCare(Box box) {
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		
		
		String time = (String) utilMap.get("currentTime");
		int inpatientId=box.getInt("inpatientId");
		int hinId = (Integer) box.getInt("hinId");
		int hospitalId = (Integer) box.getInt(HOSPITAL_ID);
		int userId = (Integer) box.getInt(USER_ID);
		//int deptId = (Integer) box.getInt(DEPT_ID);
		
//		String admissionNumber = (String) map.get("admissionNumber");
//		String userName = (String) map.get("userName");
		// Users users = (Users) map.get("users");
//		List nursingIdList = (List) map.get("list");
//		List frequencyList = (List) map.get("frequencyList");
//		int hinId = (Integer) map.get("hinId");
//		int inpatientId = (Integer) map.get("inpatientId");
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			// String hql="delete from jkt.hms.masters.business.NursingcareSetup
			// as ncs where ncs.AdNo = '"+admissionNumber+"'";
			// Query query = session.createQuery(hql);
			// int row = query.executeUpdate();
			/*String hql = "delete from jkt.hms.masters.business.NursingcareSetup as ncs where ncs.Inpatient.Id =:inpatientId and ncs.Hospital.Id =:hospitalId";
			Query query = session.createQuery(hql).setParameter("inpatientId",
					inpatientId).setParameter("hospitalId",
							hospitalId);
			@SuppressWarnings("unused")
			int row = query.executeUpdate();*/
			int i = 0;
			int count=box.getInt("nursingcarecount");
			Users users = new Users();
			users.setId(userId);
			for (int j = 1; j <= count; j++) {
				if(box.getString("careTypeId"+j)!=null && !box.getString("careTypeId"+j).equals("") && box.getInt("careTypeId"+j)!=0)
				{
					NursingcareSetup nursingcareSetup = null;
					
					List<NursingcareSetup> nursingcareSetups=new ArrayList<NursingcareSetup>();
				
					nursingcareSetups = session.createCriteria(NursingcareSetup.class)
							.add(Restrictions.eq("Nursing.Id", box.getInt("careTypeId"+j)))
							.add(Restrictions.eq("Inpatient.Id", inpatientId))
							.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
					
					if(nursingcareSetups.size()==0)
					{
					 nursingcareSetup = new NursingcareSetup();
					MasNursingCare masNursingCare = new MasNursingCare();
					masNursingCare.setId(box.getInt("careTypeId"+j));
					nursingcareSetup.setNursing(masNursingCare);

//					nursingcareSetup.setAdNo(admissionNumber);
				
					nursingcareSetup.setLastChgBy(users);
					nursingcareSetup.setLastChgTime(time);
					nursingcareSetup.setLastChgDate(dateToInsert);
					Patient patient = new Patient();
					patient.setId(hinId);
					nursingcareSetup.setHin(patient);
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("frequency"+j));
					nursingcareSetup.setFrequency(masFrequency);
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					nursingcareSetup.setInpatient(inpatient);
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					nursingcareSetup.setHospital(hospital);
					nursingcareSetup.setRemarks(box.getString("careremarks"+j));
					
					NursingcareSetupHistory history=new NursingcareSetupHistory();
					history.setStartDate(dateToInsert);
					history.setStartTime(time);
					history.setNursingcareSetup(nursingcareSetup);
					if(!box.getString("carestop"+j).equals(""))
					{
						nursingcareSetup.setStopCare("y");
						history.setEndDate(dateToInsert);
						history.setEndTime(time);
					}
					else
					{
						nursingcareSetup.setStopCare("n");
					}
					hbt.save(nursingcareSetup);
					hbt.save(history);
					}
					else
					{
						nursingcareSetup=nursingcareSetups.get(0);
						MasNursingCare masNursingCare = new MasNursingCare();
						masNursingCare.setId(box.getInt("careTypeId"+j));
						nursingcareSetup.setNursing(masNursingCare);

//						nursingcareSetup.setAdNo(admissionNumber);
					
						nursingcareSetup.setLastChgBy(users);
						nursingcareSetup.setLastChgTime(time);
						nursingcareSetup.setLastChgDate(dateToInsert);
						Patient patient = new Patient();
						patient.setId(hinId);
						nursingcareSetup.setHin(patient);
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("frequency"+j));
						nursingcareSetup.setFrequency(masFrequency);
						Inpatient inpatient = new Inpatient();
						inpatient.setId(inpatientId);
						nursingcareSetup.setInpatient(inpatient);
						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						nursingcareSetup.setHospital(hospital);
						nursingcareSetup.setRemarks(box.getString("careremarks"+j));
						
						NursingcareSetupHistory history=null;
						
						if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("y"))
						{
							if(!box.getString("vitalstop"+j).equals(""))
							{
								
							}
							else
							{
								history=new NursingcareSetupHistory();
								nursingcareSetup.setStopCare("n");
								history.setNursingcareSetup(nursingcareSetup);
								history.setStartDate(dateToInsert);
								history.setStartTime(time);
							}
						}
						if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("n"))
						{
							 
							 if(!box.getString("vitalstop"+j).equals(""))
								{
								 
								 List<NursingcareSetupHistory> nursingcareSetupHistories=new ArrayList<NursingcareSetupHistory>();						
									nursingcareSetupHistories = session.createCriteria(NursingcareSetupHistory.class,"ncsh")
											.createAlias("NursingcareSetup", "ncs")
											.createAlias("ncs.Inpatient", "ncsi")
											.createAlias("ncs.Hospital", "ncsho")
											.add(Restrictions.eq("ncs.Id", nursingcareSetup.getId()))
											.add(Restrictions.eq("ncsi.Id", inpatientId))
											.add(Restrictions.eq("ncsho.Id", hospitalId))
											.add(Restrictions.isNotNull("ncsh.StartDate"))
											.addOrder(Order.desc("Id")).list();									
									if(nursingcareSetupHistories.size()>0)
									{
									history=nursingcareSetupHistories.get(0);
									nursingcareSetup.setStopCare("y");
									history.setNursingcareSetup(nursingcareSetup);
									history.setEndDate(dateToInsert);
									history.setEndTime(time);
									}
								}
						}
						hbt.save(nursingcareSetup);
						if(history!=null)
						{
						hbt.save(history);
						}						
					}
				}
			}
			/*Iterator itr = nursingIdList.iterator();
			while (itr.hasNext()) {
				NursingcareSetup nursingcareSetup = new NursingcareSetup();
				Integer nursId = (Integer) itr.next();

				MasNursingCare masNursingCare = new MasNursingCare();
				masNursingCare.setId(nursId);
				nursingcareSetup.setNursing(masNursingCare);

				nursingcareSetup.setAdNo(admissionNumber);
				Users users = new Users();
				users.setId(userId);
				nursingcareSetup.setLastChgBy(users);
				nursingcareSetup.setLastChgTime(time);
				nursingcareSetup.setLastChgDate(dateToInsert);
				Patient patient = new Patient();
				patient.setId(hinId);
				nursingcareSetup.setHin(patient);

				MasFrequency masFrequency = new MasFrequency();
				masFrequency.setId((Integer) frequencyList.get(i));
				nursingcareSetup.setFrequency(masFrequency);

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				nursingcareSetup.setInpatient(inpatient);

				MasHospital hospital = new MasHospital();
				hospital.setId(hospitalId);
				nursingcareSetup.setHospital(hospital);

				hbt.save(nursingcareSetup);
				// hbt.refresh(nursingcareSetup);

				// Caresummary caresummary= new Caresummary();
				// caresummary.setAdNo(admissionNumber);
				// caresummary.setDateOfCare(dateToInsert);
				// caresummary.setNoOfTimes(0);
				// caresummary.setNursing(masNursingCare);
				// hbt.save(caresummary);
				// getHibernateTemplate().save(patient);
				i++;
			}*/
			
			
			
			
			
			
			
			
			
			
			//for vital care setup
			//int j = 0;
			int vitalCount=box.getInt("vitalcarecount");
			
			for (int j = 1; j <= vitalCount; j++) {
				if(box.getString("vitalName"+j)!=null && !box.getString("vitalName"+j).equals("") && !box.getString("vitalName"+j).equals("0"))
				{
					IpdVitalSetup ipdVitalSetup= null;
					
					List<IpdVitalSetup> ipdVitalSetups=new ArrayList<IpdVitalSetup>();
				
					ipdVitalSetups = session.createCriteria(IpdVitalSetup.class)
							.add(Restrictions.eq("VitalName", box.getString("vitalName"+j).toLowerCase()).ignoreCase())
							.add(Restrictions.eq("Inpatient.Id", inpatientId))
							.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
					
					if(ipdVitalSetups.size()==0)
					{
						
					 ipdVitalSetup=new IpdVitalSetup();
					ipdVitalSetup.setVitalName(box.getString("vitalName"+j));
				
					ipdVitalSetup.setLastChgBy(users);
					ipdVitalSetup.setLastChgTime(time);
					ipdVitalSetup.setLastChgDate(dateToInsert);
					Patient patient = new Patient();
					patient.setId(hinId);
					ipdVitalSetup.setHin(patient);
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("vitalFrequency"+j));
					ipdVitalSetup.setFrequency(masFrequency);
					
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					ipdVitalSetup.setInpatient(inpatient);
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					ipdVitalSetup.setHospital(hospital);
					ipdVitalSetup.setRemarks(box.getString("vitalRemarks"+j));
					
					IpdVitalcareSetupHistory  history=new IpdVitalcareSetupHistory();
					history.setStartDate(dateToInsert);
					history.setStartTime(time);
					history.setVitalSetup(ipdVitalSetup);
					if(!box.getString("carestop"+j).equals(""))
					{
						ipdVitalSetup.setStopVital("y");
						history.setEndDate(dateToInsert);
						history.setEndTime(time);
					}
					else
					{
						ipdVitalSetup.setStopVital("n");
						
					}
					hbt.save(ipdVitalSetup);
					hbt.save(history);
					}
					else
					{
						ipdVitalSetup=ipdVitalSetups.get(0);
						ipdVitalSetup.setLastChgBy(users);
						ipdVitalSetup.setLastChgTime(time);
						ipdVitalSetup.setLastChgDate(dateToInsert);
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("vitalFrequency"+j));
						ipdVitalSetup.setFrequency(masFrequency);
						ipdVitalSetup.setRemarks(box.getString("vitalRemarks"+j));
						IpdVitalcareSetupHistory history=null;
						
						if(ipdVitalSetup.getStopVital()!=null && ipdVitalSetup.getStopVital().equalsIgnoreCase("y"))
						{
							if(!box.getString("vitalstop"+j).equals(""))
							{
								
							}
							else
							{
								history=new IpdVitalcareSetupHistory();
								ipdVitalSetup.setStopVital("n");
								history.setVitalSetup(ipdVitalSetup);
								history.setStartDate(dateToInsert);
								history.setStartTime(time);
							}
						}
						if(ipdVitalSetup.getStopVital()!=null && ipdVitalSetup.getStopVital().equalsIgnoreCase("n"))
						{
							 
							 if(!box.getString("vitalstop"+j).equals(""))
								{
								 List<IpdVitalcareSetupHistory> ipdVitalcareSetupHistories=new ArrayList<IpdVitalcareSetupHistory>();						
									ipdVitalcareSetupHistories = session.createCriteria(IpdVitalcareSetupHistory.class,"vcsh")
											.createAlias("VitalSetup", "vcs")
											.createAlias("vcs.Inpatient", "ncsi")
											.createAlias("vcs.Hospital", "ncsho")
											.add(Restrictions.eq("vcs.Id", ipdVitalSetup.getId()))
											.add(Restrictions.eq("ncsi.Id", inpatientId))
											.add(Restrictions.eq("ncsho.Id", hospitalId))
											.add(Restrictions.isNotNull("vcsh.StartDate"))
											.addOrder(Order.desc("Id")).list();
									if(ipdVitalcareSetupHistories.size()>0)
									{
									history=ipdVitalcareSetupHistories.get(0);
								 	ipdVitalSetup.setStopVital("y");
								 	history.setVitalSetup(ipdVitalSetup);
									history.setEndDate(dateToInsert);
									history.setEndTime(time);
									}
								}
						}
						hbt.save(ipdVitalSetup);
						if(history!=null)
						{
						hbt.save(history);
						}
						
					}
				}
			}
			hbt.flush();
			hbt.clear();
			tx.commit();
			succesfullyAdded = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return succesfullyAdded;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map<String, Object> showFoodTesting(int deptId) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		List<NursingfoodTest> foodDetailList = new ArrayList<NursingfoodTest>();
		List<MasEmployee> empList = new ArrayList<MasEmployee>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			foodDetailList = session.createCriteria(NursingfoodTest.class)
					.add(Restrictions.eq("Fooddate", date)).list();
			empList = session
					.createQuery(
							"select emp from MasEmployee as emp where emp.EmpCategory.Id=" + 2)
					.list();
			map.put("foodDetailList", foodDetailList);
			map.put("empList", empList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean insertFoodTestingDetails(Map map) {

		boolean dataInserted = false;
		@SuppressWarnings("unused")
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);

		int deptId = (Integer) map.get("deptId");
		String userName = (String) map.get("userName");
		@SuppressWarnings("unused")
		List<NursingfoodTest> foodDetailList = new ArrayList<NursingfoodTest>();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);

			if (map.get("breakFastStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String breakFastTime = (String) map.get("breakFastTime");
				String breakFastStatus = (String) map.get("breakFastStatus");
				String breakFastRemarks = (String) map.get("breakFastRemarks");
				String breakFastCheckedByEmp = (String) map
						.get("breakFastCheckedByEmp");
				nursingfoodTest.setFoodname("BreakFast");
				nursingfoodTest.setFoodstatus(breakFastStatus);

				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(breakFastTime);
				nursingfoodTest.setRemarks(breakFastRemarks);
				nursingfoodTest.setTestedby(breakFastCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);
			}
			if (map.get("lunchStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String lunchTime = (String) map.get("lunchTime");
				String lunchStatus = (String) map.get("lunchStatus");
				String lunchRemarks = (String) map.get("lunchRemarks");
				String lunchCheckedByEmp = (String) map
						.get("lunchCheckedByEmp");
				nursingfoodTest.setFoodname("Lunch");
				nursingfoodTest.setFoodstatus(lunchStatus);
				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(lunchTime);
				nursingfoodTest.setRemarks(lunchRemarks);
				nursingfoodTest.setTestedby(lunchCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);
			}
			if (map.get("dinnerStatus") != null) {
				NursingfoodTest nursingfoodTest = new NursingfoodTest();
				String dinnerTime = (String) map.get("dinnerTime");
				String dinnerStatus = (String) map.get("dinnerStatus");
				String dinnerRemarks = (String) map.get("dinnerRemarks");
				String dinnerCheckedByEmp = (String) map
						.get("dinnerCheckedByEmp");
				nursingfoodTest.setFoodname("Dinner");
				nursingfoodTest.setFoodstatus(dinnerStatus);
				nursingfoodTest.setDepartment(masDepartment);
				nursingfoodTest.setFooddate(dateToInsert);
				nursingfoodTest.setFoodtime(dinnerTime);
				nursingfoodTest.setRemarks(dinnerRemarks);
				nursingfoodTest.setTestedby(dinnerCheckedByEmp);
				nursingfoodTest.setLastChgBy(userName);
				nursingfoodTest.setLastChgDate(dateToInsert);
				nursingfoodTest.setLastChgTime(time);
				hbt.save(nursingfoodTest);

			}
			dataInserted = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return dataInserted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showCaresList(Box box) {
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			nursingCareList = session.createCriteria(MasNursingCare.class)
					.add(Restrictions.eq("Status", "Y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("nursingCareList", nursingCareList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientListOnBasisOfCare(
			Map<String, Object> dataMap) {

		List showList = new ArrayList();
		List admissionNumberList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int careId = (Integer) dataMap.get("careId");
			int deptId = (Integer) dataMap.get("deptId");
			int hospitalId = (Integer) dataMap.get(HOSPITAL_ID);

			// Criteria nursinCareSetupCriteria =
			// session.createCriteria(NursingcareSetup.class)

			// .createCriteria(NursingcareSetup.PROP_NURSING)
			// .add(Expression.eq(MasNursingCare.PROP_ID, careId));

			// showList = nursinCareSetupCriteria.list();

			showList = session.createCriteria(NursingcareSetup.class, "ncs")
					.createAlias("ncs.Inpatient", "inp")
					.add(Restrictions.eq("ncs.Nursing.Id", careId))
					.add(Restrictions.eq("inp.Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			// showList = session.createQuery(
			// "select ncs from  NursingcareSetup as ncs where ncs.Nursing.Id="
			// + careId + "and ncs.Inpatient.Department.Id="
			// + deptId).list();

			admissionNumberList.addAll(showList);

//			for (Object object3 : showList) {
//				NursingcareSetup nursingcareSetup = (NursingcareSetup) object3;
//				@SuppressWarnings("unused")
//				Set<Ipdcaredetail> ipdcaredetails = nursingcareSetup.
//						.getIpdcaredetails();
//			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("showList", showList);
		map.put("admissionNumberList", admissionNumberList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchPatientOnBasisOfCare(Box box) {

		List showList = new ArrayList();
		List<IpdCareDetails> ipdCareDetails = new ArrayList<IpdCareDetails>();
		List<IpdVitalSetup> ipdVitalSetups = new ArrayList<IpdVitalSetup>();
		List<IpdVitalcareDetails> ipdVitalcareDetails = new ArrayList<IpdVitalcareDetails>();
		//int nursingCareSetupId = 0;
		
		//int nursingId = 0;
		Integer maxNursingFrequency=0;
		Integer maxVitalFrequency=0;

		Session session = (Session) getSession();
		// careId=(Integer)map.get("careId");
//		nursingCareSetupId = (Integer) map.get("nursingCareSetupId");
		 Map<String ,Object> map= new HashMap<String, Object>();
		 Inpatient inpatient=null;
		    int inpatientId=box.getInt("parent");
			//int hinId = (Integer) box.getInt("hinId");
			int hospitalId = (Integer) box.getInt(HOSPITAL_ID);
			//int userId = (Integer) box.getInt(USER_ID);
			//int deptId = (Integer) box.getInt(DEPT_ID);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			inpatient=(Inpatient) hbt.get(Inpatient.class, inpatientId);

			Criteria nursinCareSetupCriteria = session.createCriteria(
					NursingcareSetup.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId));
					//.add(Restrictions.eq("StopCare", "n").ignoreCase());

			showList = nursinCareSetupCriteria.list();
			
			maxNursingFrequency=(Integer) session.createCriteria(NursingcareSetup.class,"ncs")
					.createAlias("ncs.Inpatient", "ip")
					.createAlias("ncs.Hospital", "h")
					.createAlias("ncs.Frequency", "frq")
					.add(Restrictions.eq("ip.Id", inpatientId))
					.add(Restrictions.eq("h.Id", hospitalId))
					//.add(Restrictions.eq("ncs.StopCare", "n").ignoreCase())
					.setProjection(Projections.max("frq.FrequencyCount")).uniqueResult();
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");
			
			ipdCareDetails=session.createCriteria(IpdCareDetails.class,"icd")
					.createAlias("icd.CareHeader", "ich")
					.createAlias("ich.Inpatient", "ip")
					.createAlias("ich.Hospital", "h")
					.add(Restrictions.eq("ip.Id", inpatientId))
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("ich.DateOfCare",HMSUtil.convertStringTypeDateToDateType(date)))
					.list();
			
			
			
			 ipdVitalSetups = session.createCriteria(
					IpdVitalSetup.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					//.add(Restrictions.eq("StopVital", "n").ignoreCase())
					.list();

			
			 maxVitalFrequency=(Integer) session.createCriteria(IpdVitalSetup.class,"ncs")
					.createAlias("ncs.Inpatient", "ip")
					.createAlias("ncs.Hospital", "h")
					.createAlias("ncs.Frequency", "frq")
					.add(Restrictions.eq("ip.Id", inpatientId))
					.add(Restrictions.eq("h.Id", hospitalId))
					//.add(Restrictions.eq("ncs.StopVital", "n").ignoreCase())
					.setProjection(Projections.max("frq.FrequencyCount")).uniqueResult();
			
			
			ipdVitalcareDetails=session.createCriteria(IpdVitalcareDetails.class,"icd")
					.createAlias("icd.VitalHeader", "ich")
					.createAlias("ich.Inpatient", "ip")
					.createAlias("ich.Hospital", "h")
					.add(Restrictions.eq("ip.Id", inpatientId))
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.eq("ich.DateOfCare",HMSUtil.convertStringTypeDateToDateType(date)))
					.list();
			/*NursingcareSetup nursingcareSetup = (NursingcareSetup) showList
					.get(0);
			nursingId = nursingcareSetup.getNursing().getId();*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("showList", showList);
		map.put("inpatient", inpatient);
		if(maxNursingFrequency!=null){
		map.put("maxNursingFrequency", maxNursingFrequency.intValue());
		}else{
			map.put("maxNursingFrequency", 1);
			
		}
		map.put("ipdCareDetails", ipdCareDetails);
		map.put("ipdVitalSetups", ipdVitalSetups);
		if(maxVitalFrequency!=null)
			map.put("maxVitalFrequency", maxVitalFrequency.intValue());
		map.put("ipdVitalcareDetails", ipdVitalcareDetails);
		return map;
	}

	public boolean submitNursingCareEntryDetails(Box box) {

		boolean succesfullyAdded = false;
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int userId=box.getInt(USER_ID);
		String careStringDate=box.getString("caredate");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Date careDate = HMSUtil.convertStringTypeDateToDateType(careStringDate);
		int inpatientId=box.getInt("inpatientId");
		int hinId=box.getInt("hinId");
		String adNo=box.getString("adNo");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int counter =box.getInt("counter");
			for (int i=1;i<=counter;i++) {
				String care=box.getString("care"+i);
				if (care!=null && !care.equals("")&&care.equals("1")) {
					IpdCareHeader careHeader=new IpdCareHeader();
					
					careHeader.setAdNo(adNo);
					
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					careHeader.setDepartment(masDepartment);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					careHeader.setHospital(masHospital);
					
					Patient patient = new Patient();
					patient.setId(hinId);
					careHeader.setHin(patient);
					
					Inpatient inpatient=new Inpatient();
					inpatient.setId(inpatientId);
					careHeader.setInpatient(inpatient);
					
					NursingcareSetup nursingcareSetup = new NursingcareSetup();
					nursingcareSetup.setId(box.getInt("careTypeId"+i));
					careHeader.setNursingcareSetup(nursingcareSetup);
					Users users = new Users();
					users.setId(userId);
					careHeader.setLastChgBy(users);
					careHeader.setLastChgDate(dateToInsert);
					careHeader.setLastChgTime(time);
					careHeader.setDateOfCare(careDate);
					if (!box.getString("careremarks"+i).equals("")) {
						careHeader.setRemarks(box.getString("careremarks"+i));
					} else {
						careHeader.setRemarks("");
					}
					
					
					IpdCareDetails careDetails=new IpdCareDetails();
					careDetails.setCareDate(careDate);
					careDetails.setCareHeader(careHeader);
					careDetails.setCareTime(box.getString("caretime"+i));
					careDetails.setCareFrequencyCount(box.getInt("care"+i));
					hbt.save(careHeader);
					hbt.save(careDetails);
					
					succesfullyAdded = true;
				} else {
					if (care!=null && !care.equals("")&&!care.equals("0")) {
					int careId = box.getInt("ipdcaredetailId"+i);
					if(careId!=0)
					{
						IpdCareHeader careHeader=(IpdCareHeader) hbt.get(IpdCareHeader.class, careId);
						IpdCareDetails careDetails=new IpdCareDetails();
						careDetails.setCareDate(careDate);
						careDetails.setCareHeader(careHeader);
						careDetails.setCareTime(box.getString("caretime"+i));
						careDetails.setCareFrequencyCount(box.getInt("care"+i));
						hbt.save(careDetails);
						/*
					Ipdcaredetail ipdcaredetailObj = (Ipdcaredetail) hbt.load(
							Ipdcaredetail.class, ipdId);
					if (care!=null && !care.equals("")&&care.equals("two")) {
						ipdcaredetailObj.setCare2("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("three")) {
						ipdcaredetailObj.setCare3("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("four")) {
						ipdcaredetailObj.setCare4("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("five")) {
						ipdcaredetailObj.setCare5("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("six")) {
						ipdcaredetailObj.setCare6("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("seven")) {
						ipdcaredetailObj.setCare7("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("eight")) {
						ipdcaredetailObj.setCare8("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("nine")) {
						ipdcaredetailObj.setCare9("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("ten")) {
						ipdcaredetailObj.setCare10("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("eleven")) {
						ipdcaredetailObj.setCare11("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("twelve")) {
						ipdcaredetailObj.setCare12("Y");
						ipdcaredetailObj.setCare2Time(box.getString("caretime"+i));
					}
					if (!box.getString("careremarks"+i).equals("")) {
						ipdcaredetailObj.setRemarks(box.getString("careremarks"+i));
					} else {
						ipdcaredetailObj.setRemarks("");
					}*/
					
					if (!box.getString("careremarks"+i).equals("")) {
						careHeader.setRemarks(box.getString("careremarks"+i));
					} else {
						careHeader.setRemarks("");
					}
					
					
					
					hbt.save(careDetails);
					hbt.update(careHeader);
				}
				}
				}
			}

			
			
			
			
			
			int vitalcounter =box.getInt("vitalcounter");
			for (int i=1;i<=vitalcounter;i++) {
				String care=box.getString("vitalName"+i);
				String bp1=box.getString("bp1"+i);
				String bp2=box.getString("bp2"+i);
				String vitalcount=box.getString("vitalNameCount"+i);
				if (((care!=null && !care.equals("")) ||(!bp1.equals("") && !bp2.equals("")))&&vitalcount.equals("1")) {
					IpdVitalcareHeader careHeader=new IpdVitalcareHeader();
										
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					careHeader.setDepartment(masDepartment);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					careHeader.setHospital(masHospital);
					
					Patient patient = new Patient();
					patient.setId(hinId);
					careHeader.setHin(patient);
					
					Inpatient inpatient=new Inpatient();
					inpatient.setId(inpatientId);
					careHeader.setInpatient(inpatient);
					
					IpdVitalSetup vitalSetup=new IpdVitalSetup();
					vitalSetup.setId(box.getInt("vitalSetupId"+i));
					careHeader.setVitalSetup(vitalSetup);
					
					Users users = new Users();
					users.setId(userId);
					careHeader.setLastChgBy(users);
					careHeader.setLastChgDate(dateToInsert);
					careHeader.setLastChgTime(time);
					careHeader.setDateOfCare(careDate);
					if (!box.getString("vitalmarks"+i).equals("")) {
						careHeader.setRemarks(box.getString("vitalmarks"+i));
					} else {
						careHeader.setRemarks("");
					}
					
					
					IpdVitalcareDetails careDetails=new IpdVitalcareDetails();
					if (care!=null && !care.equals("")) {
						careDetails.setVitalValue(care);
					}
					else if(!bp1.equals("") && !bp2.equals("")) {
						careDetails.setVitalValue(bp1+"/"+bp2);
					}

					careDetails.setCareDate(careDate);
					careDetails.setVitalHeader(careHeader);
					careDetails.setCareTime(box.getString("vitaltime"+i));
					careDetails.setCareFrequencyCount(box.getInt("vitalNameCount"+i));
					hbt.save(careHeader);
					hbt.save(careDetails);
					succesfullyAdded = true;
					
				} else {
					int careId = box.getInt("ipdvitaldetailId"+i);
					if(careId!=0)
					{
						if (((care!=null && !care.equals("")) ||(!bp1.equals("") && !bp2.equals("")))&&!vitalcount.equals("0")) {
						IpdVitalcareHeader careHeader=(IpdVitalcareHeader) hbt.get(IpdVitalcareHeader.class, careId);
						IpdVitalcareDetails careDetails=new IpdVitalcareDetails();
						if (care!=null && !care.equals("")) {
							careDetails.setVitalValue(care);
						}
						else if(!bp1.equals("") && !bp2.equals("")) {
							careDetails.setVitalValue(bp1+"/"+bp2);
						}

						careDetails.setCareDate(careDate);
						careDetails.setVitalHeader(careHeader);
						careDetails.setCareTime(box.getString("vitaltime"+i));
						careDetails.setCareFrequencyCount(box.getInt("vitalNameCount"+i));
						hbt.save(careHeader);
						succesfullyAdded = true;
					
						if (!box.getString("vitalmarks"+i).equals("")) {
							careHeader.setRemarks(box.getString("vitalmarks"+i));
						} else {
							careHeader.setRemarks("");
						}					
					hbt.save(careDetails);
					hbt.update(careHeader);
				}
					}
				}
			}

			
			succesfullyAdded = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		/*List<String> careList = (List) map.get("careList");
		List<String> adNoList = (List) map.get("adNoList");
		List nursingCareSetupIdList = (List) map.get("nursingCareSetupIdList");
		List hinIdList = (List) map.get("hinIdList");
		
		
		List ipdcaredetailIdList = (List) map.get("ipdcaredetailIdList");
		List timeOfCareList = (List) map.get("timeOfCareList");
		List careRemarksList = (List) map.get("careRemarksList");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Iterator itr = careList.iterator();
			int i = 0;
			while (itr.hasNext()) {
				String care = (String) itr.next();
				if (care.equals("one")) {
					String userName = (String) map.get("userName");
					int hospitalId = (Integer) map.get("hospitalId");
					int deptId = (Integer) map.get("deptId");
					int userId = (Integer) map.get(USER_ID);

					Ipdcaredetail ipdcaredetail = new Ipdcaredetail();
					ipdcaredetail.setAdNo(adNoList.get(i));
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					ipdcaredetail.setDepartment(masDepartment);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					ipdcaredetail.setHospital(masHospital);
					Patient patient = new Patient();
					patient.setId((Integer) hinIdList.get(i));
					ipdcaredetail.setHin(patient);
					NursingcareSetup nursingcareSetup = new NursingcareSetup();
					nursingcareSetup.setId((Integer) nursingCareSetupIdList
							.get(i));
					ipdcaredetail.setNursingcareSetup(nursingcareSetup);
					ipdcaredetail.setCare1("Y");
					ipdcaredetail.setDateOfCare(dateToInsert);
					ipdcaredetail.setCare1Time((String) timeOfCareList.get(i));
					Users users = new Users();
					users.setId(userId);
					ipdcaredetail.setLastChgBy(users);
					ipdcaredetail.setLastChgDate(dateToInsert);
					ipdcaredetail.setLastChgTime(time);
					if (careRemarksList.get(i) != "") {
						ipdcaredetail.setRemarks((String) careRemarksList
								.get(i));
					} else {
						ipdcaredetail.setRemarks("");
					}
					hbt.save(ipdcaredetail);
					succesfullyAdded = true;
				} else {
					String ipdcaredetailId = (String) ipdcaredetailIdList
							.get(i);
					int ipdId = Integer.parseInt(ipdcaredetailId);
					Ipdcaredetail ipdcaredetailObj = (Ipdcaredetail) hbt.load(
							Ipdcaredetail.class, ipdId);
					if (care.equals("two")) {
						ipdcaredetailObj.setCare2("Y");
						ipdcaredetailObj.setCare2Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("three")) {
						ipdcaredetailObj.setCare3("Y");
						ipdcaredetailObj.setCare3Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("four")) {
						ipdcaredetailObj.setCare4("Y");
						ipdcaredetailObj.setCare4Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("five")) {
						ipdcaredetailObj.setCare5("Y");
						ipdcaredetailObj.setCare5Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("six")) {
						ipdcaredetailObj.setCare6("Y");
						ipdcaredetailObj.setCare6Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("seven")) {
						ipdcaredetailObj.setCare7("Y");
						ipdcaredetailObj.setCare7Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("eight")) {
						ipdcaredetailObj.setCare8("Y");
						ipdcaredetailObj.setCare8Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("nine")) {
						ipdcaredetailObj.setCare9("Y");
						ipdcaredetailObj.setCare9Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("ten")) {
						ipdcaredetailObj.setCare10("Y");
						ipdcaredetailObj.setCare10Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("eleven")) {
						ipdcaredetailObj.setCare11("Y");
						ipdcaredetailObj.setCare11Time((String) timeOfCareList
								.get(i));
					}
					if (care.equals("twelve")) {
						ipdcaredetailObj.setCare12("Y");
						ipdcaredetailObj.setCare12Time((String) timeOfCareList
								.get(i));
					}
					if (careRemarksList.get(i) != "") {
						ipdcaredetailObj.setRemarks((String) careRemarksList
								.get(i));
					} else {
						ipdcaredetailObj.setRemarks("");
					}
					hbt.update(ipdcaredetailObj);
					succesfullyAdded = true;
				}
				i++;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}*/

		return succesfullyAdded;
	}

	/*
	 * List of ward/department from master table
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardList(int deptId, int hospitalId) {

		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<StoreIpIssueM> issueMList = new ArrayList<StoreIpIssueM>();
		List<StoreFyDocumentNo> ipIssueNoList = new ArrayList<StoreFyDocumentNo>();

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			issueMList = session.createCriteria(StoreIpIssueM.class)
					.addOrder(Order.desc("Id"))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId)).list();
			
			ipIssueNoList = session.createCriteria(StoreFyDocumentNo.class).add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id",hospitalId)).list();
			
			if (ipIssueNoList != null && ipIssueNoList.size() > 0  ) {
				for (StoreFyDocumentNo storeFyDocumentNo : ipIssueNoList) {
					if(storeFyDocumentNo.getIssueWardNo() != null && storeFyDocumentNo.getIssueWardNo() != 0){
					int issueNoOfWard = storeFyDocumentNo.getIssueWardNo();
					issueNoOfWard = issueNoOfWard + 1;
					map.put("issueNoOfWard", issueNoOfWard);
					}else{
						int issueNoOfWard = 1;
					map.put("issueNoOfWard", issueNoOfWard);
					}
					
				}

				}else{
					int issueNoOfWard = 1;
					map.put("issueNoOfWard", issueNoOfWard);
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		map.put("deptList", deptList);
		//
		map.put("issueMList", issueMList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardConsumptionJsp(Map map) {

		//List listOfItemsInStock = new ArrayList();
		List ipIssueNo = new ArrayList();
		List issueNoList = new ArrayList();
		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		try {
			// org.springframework.orm.hibernate3.HibernateTemplate hbt =
			// getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			// hbt.setCheckWriteOperations(false);

			// listOfItemsInStock = session.createQuery("select sib,
			// sum(sib.ClosingStock) from StoreItemBatchStock as sib where
			// sib.Department.Id="+deptId+ "group by
			// sib.BatchNo,sib.CostPrice,sib.Brand.Id ").list();
			ipIssueNo = session.createQuery(
					"select syd from StoreFyDocumentNo as syd where syd.Department.Id="
							+ deptId).list();
			// brandList = session.createQuery("select
			// Distinct(sib.Brand.Id),sib.Brand.BrandName from
			// StoreItemBatchStock as sib where
			// sib.Department.Id="+deptId).list();
			issueNoList = session.createQuery(
					"select sim from  StoreIpIssueM as sim where sim.Department.Id="
							+ deptId + "and sim.IssueType='w'").list();
			if (map.get("buttonFlag") != null) {
				String issueNoOfWardFromJsp = (String) map.get("issueNoOfWard");
				int issueNoOfWard = Integer.parseInt(issueNoOfWardFromJsp);
				map.put("issueNoOfWard", issueNoOfWard);
			} else {

				if (ipIssueNo.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
							.get(0);
					int issueNoOfWard = storeFyDocumentNo.getIssueWardNo();
					issueNoOfWard = issueNoOfWard + 1;
					map.put("issueNoOfWard", issueNoOfWard);

				}
			}
			if (ipIssueNo.size() == 0) {

				StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeFyDocumentNo.setDepartment(masDepartment);
				storeFyDocumentNo.setIssueWardNo(0);
				session.save(storeFyDocumentNo);
			}
			if (ipIssueNo.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
						.get(0);
				int issueNoOfWard = storeFyDocumentNo.getIssueWardNo();
				issueNoOfWard = issueNoOfWard + 1;
				map.put("issueNoOfWard", issueNoOfWard);

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		map.put("ipIssueNo", ipIssueNo);
		map.put("issueNoList", issueNoList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStockDetailsJsp(Map map) {
		List listOfItemsInStock = new ArrayList();
		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		int itemId = (Integer) map.get("itemId");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			@SuppressWarnings("unused")
			Criteria c = session.createCriteria(StoreFyDocumentNo.class).add(
					Restrictions.eq("Department.Id", deptId));
			listOfItemsInStock = session
					.createQuery(
							"select sib,sib.ClosingStock from StoreItemBatchStock as sib where sib.Department.Id="
									+ deptId
									+ " and sib.Item.Id="
									+ itemId
									+ " group by sib.Id,sib.BatchNo,sib.CostPrice,sib.Item.Id,sib.Brand.Id,sib.Department.Id,sib.BlockedQty,sib.LotNo,sib.LoanOutQty,sib.LoanInQty,sib.DonatedItem,sib.FreeItem,sib.SalesTax,sib.DispencingPrice,sib.BarcodeNo,sib.Mrp ,sib.ClosingStock,sib.IssueReturn,sib.ReceiptReturnNonreturnable,sib.ReceiptReturnReturnable,sib.AdjustQty,sib.IssueQty,sib.ReceivedQty,sib.OpeningBalanceAmount,sib.OpeningBalanceQty,sib.OpeningBalanceDate,sib.ExpiryDate")
					// +"group by sib.BatchNo,sib.CostPrice")
					.list();

			/*
			 * listOfItemsInStock=session.createCriteria(StoreItemBatchStock.class
			 * ).add(Restrictions.eq("Department.Id", deptId))
			 * .createAlias("Item", "itm").add(Restrictions.eq("itm.Id",
			 * itemId)) //.
			 * setProjection(Projections.groupProperty("CostPrice"))
			 * //.setProjection(Projections.groupProperty("BatchNo")) .list();
			 */
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("listOfItemsInStock", listOfItemsInStock);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitWardConsumptionDetails(Map map) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Date fromDateToInsert = null;
		// String issueType="w";
		List<String> pvmsList = (List) map.get("pvmsList");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List<MasStoreBrand> brandNameList = new ArrayList<MasStoreBrand>();
		List<String> expiryDateList = (List<String>) map.get("expiryDateList");
		List<String> reasonList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		// List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		if(map.get("reasonList") != null){
			reasonList = (List)map.get("reasonList");
		}
		if(map.get("remarksList") != null){
			remarksList = (List)map.get("remarksList");
		}
		List amountList = (List) map.get("amountList");
		List<StoreItemBatchStock> storeItemBatchStockIdList = new ArrayList<StoreItemBatchStock>();
		String date = (String) map.get("date");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		int userId = (Integer) map.get("userId");
		String time = (String) map.get("time");
		//String userName = (String) map.get("userName");
		int dept1 = 0;
		if (map.get("dept1") != null) {
			dept1 = (Integer) map.get("dept1");
		}
		String consumptionNo = "";
		if(map.get("consumptionNo") != null){
			consumptionNo = (String)map.get("consumptionNo");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		/*
		 * Synchronization code by  to generate the correct
		 * reservationNo on 04082014 at silvassa
		 */
		synchronized (this) {

			List<StoreFyDocumentNo> consumptionNoList = new ArrayList<StoreFyDocumentNo>();
			consumptionNoList = session
					.createCriteria(StoreFyDocumentNo.class)
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();
			if (consumptionNoList.size() > 0) {
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) consumptionNoList.get(0);
				storeFyDocumentNo.setIssueWardNo(Integer.parseInt(consumptionNo));

				hbt.update(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
				// session.saveOrUpdate(storeFyDocumentNo);
				// session.refresh(storeFyDocumentNo);
			} else {
				StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
				storeFyDocumentNo.setAdjustmentNo("0");
				storeFyDocumentNo.setAdjustmentStartNo("0");
				storeFyDocumentNo.setBalanceNo("0");
				storeFyDocumentNo.setBalanceStartNo("0");
				storeFyDocumentNo.setDefectEntryNo("0");
				storeFyDocumentNo.setDefectEntryStartNo("0");
				storeFyDocumentNo.setDemandNo("0");
				storeFyDocumentNo.setDemandStartNo("0");
				storeFyDocumentNo.setDepartment(new MasDepartment(deptId));
				storeFyDocumentNo.setGrnNo("0");
				storeFyDocumentNo.setGrnStartNo("0");
				storeFyDocumentNo.setIssueDeptNo("0");
				storeFyDocumentNo.setIssueDeptReturnNo("0");
				storeFyDocumentNo.setIssueDeptReturnStartNo("0");
				storeFyDocumentNo.setIssueDeptStartNo("0");
				storeFyDocumentNo.setVendorReturnNo("0");
				storeFyDocumentNo.setVendorReturnStartNo("0");
				storeFyDocumentNo.setReservationNo(consumptionNo);
				storeFyDocumentNo.setIssueWardNo(1);
				String issueDeptNo = "";
				//issueDeptNo = getMaxNo("0");
				String issueDeptStartNo = issueDeptNo;
				storeFyDocumentNo.setIssueDeptNo(issueDeptNo);
				storeFyDocumentNo.setIssueDeptStartNo(issueDeptStartNo);
				MasHospital hospital=new MasHospital();
				hospital.setId(hospitalId);
				storeFyDocumentNo.setHospital(hospital);
				hbt.save(storeFyDocumentNo);
				hbt.refresh(storeFyDocumentNo);
				// session.save(storeFyDocumentNo);
				// session.refresh(storeFyDocumentNo);

			}
		}
	

	/*
	 * End By  for synchronization
	 */
	//
		
		Date toDateInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			/*
			 * StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo)
			 * hbt.load( StoreFyDocumentNo.class, storeFyDocumentNoId); int
			 * wardIssueNoFromDB = storeFyDocumentNo.getIssueWardNo(); if
			 * (wardIssueNoFromDB != wardIssueNo) {
			 * storeFyDocumentNo.setIssueWardNo(wardIssueNo);
			 * hbt.update(storeFyDocumentNo);
			 */
			//StoreIpIssueM storeIpIssueM = null;
			StoreIpIssueM storeIpIssueM = new StoreIpIssueM();
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeIpIssueM.setDepartment(masDepartment);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storeIpIssueM.setHospital(masHospital);
			storeIpIssueM.setIpIssueDate(dateToInsert);
			storeIpIssueM.setIssueType("w");
			 storeIpIssueM.setIpIssueNo(consumptionNo);
			storeIpIssueM.setFromdate(fromDateToInsert);
			storeIpIssueM.setTodate(toDateInsert);
			Users users = new Users();
			users.setId(userId);
			storeIpIssueM.setLastChgBy(users);
			storeIpIssueM.setLastChgDate(dateToInsert);
			storeIpIssueM.setLastChgTime(time);
			hbt.save(storeIpIssueM);
			/*
			 * } else { List storeIpIssueMList = session.createQuery(
			 * "select sim from StoreIpIssueM as sim where sim.IpIssueNo=" +
			 * wardIssueNo + " and sim.IssueType='w'") .list(); storeIpIssueM =
			 * (StoreIpIssueM) storeIpIssueMList.get(0); }
			 */
			// hbt.save(storeIpIssueM);
			// Iterator itr= issQtyList.iterator();
			map.put("IpIssueMId", storeIpIssueM.getId());
			for (int i = 0; i < batchNumberList.size(); i++) {

				BigDecimal totalQtyIssued;
				StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
				storeIpIssueT.setIpIssue(storeIpIssueM);
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem
						.setId(Integer.parseInt(pvmsList.get(i).toString()));
				storeIpIssueT.setItem(masStoreItem);
				storeIpIssueT.setBatchNo(batchNumberList.get(i));
				if(reasonList.get(i) != null && !reasonList.get(i).equals("")){
					storeIpIssueT.setReason(reasonList.get(i) );
				}
				if(remarksList.get(i) != null && !remarksList.get(i).equals("")){
					storeIpIssueT.setRemarks(remarksList.get(i) );
				}
				
				brandNameList = session.createCriteria(MasStoreBrand.class)
						.add(Restrictions.eq("Item.Id", masStoreItem.getId()))
						.add(Restrictions.eq("Status", "Y")).list();
				int brandId = 0;
				MasStoreBrand masStoreBrand = new MasStoreBrand();
				for (MasStoreBrand brand : brandNameList) {
					brandId = brand.getId();
				}
				masStoreBrand.setId(brandId);
				storeIpIssueT.setBrand(masStoreBrand);
//				String expiryDate = "";
				if (expiryDateList.get(i) != null) {
					/*expiryDate = (String) expiryDateList.get(i);
					expiryDate = expiryDate.substring(8, 10) + "/"
							+ expiryDate.substring(5, 7) + "/"
							+ expiryDate.substring(0, 4);*/
				
				Date expiryDateToInsert = HMSUtil.convertStringTypeDateToDateType(expiryDateList.get(i));
				storeIpIssueT.setExpiryDate(expiryDateToInsert);
				}
				// BigDecimal issuedQtyFromJsp = new BigDecimal(""+
				// issQtyList.get(i));
				// storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeIpIssueT.setRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal(amountList.get(i)
						.toString());
				storeIpIssueT.setAmount(bigDecimal3);
				// hbt.save(storeIpIssueT);

				storeItemBatchStockIdList = session
						.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Item.Id", masStoreItem.getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("BatchNo", batchNumberList.get(i)
								.toString())).list();
				int stockId = 0;
				for (StoreItemBatchStock stock : storeItemBatchStockIdList) {
					stockId = stock.getId();
				}
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, stockId);
				BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
						.getIssueQty();

				// BigDecimal issQty=(BigDecimal)issQtyList.get(i);

				if (qtyIssued != null) {
					totalQtyIssued = qtyIssued.add(new BigDecimal(amountList
							.get(i).toString()));
				} else {
					totalQtyIssued = new BigDecimal(amountList.get(i)
							.toString());
				}
				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
						.getClosingStock();
				closingStock = closingStock.subtract(new BigDecimal(amountList
						.get(i).toString()));
				storeItemBatchStock.setIssueQty(totalQtyIssued);
				storeItemBatchStock.setClosingStock(closingStock);
				hbt.save(storeIpIssueM);
				hbt.save(storeIpIssueT);
				hbt.update(storeItemBatchStock);
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> modifyWardConsumptionjsp(Map map) {

		Session session = (Session) getSession();

		int ipIssueNo = (Integer) map.get("ipIssueNo");

		List storeIpIssueMList = session.createQuery(
				"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
						+ ipIssueNo).list();
		if (storeIpIssueMList.size() > 0) {
			StoreIpIssueM storeIpIssueM = (StoreIpIssueM) storeIpIssueMList
					.get(0);
			int storeIpIssueMId = storeIpIssueM.getId();
			List storeIpIssueTList = session.createQuery(
					"select sit from StoreIpIssueT as sit where sit.IpIssue.Id="
							+ storeIpIssueMId).list();
			map.put("storeIpIssueTList", storeIpIssueTList);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean deleteStockDetails(Map map) {

		BigDecimal totalQtyIssued;
		boolean sucessfullyDeleted = false;
		Session session = (Session) getSession();
		// int brandId=(Integer)map.get("brandId");
		int ipIssueTId = (Integer) map.get("ipIssueTId");

		// String batchNo=(String)map.get("batchNo");
		// BigDecimal costPrice= new BigDecimal(""+map.get("costPrice"));
		// BigDecimal qtyIssued= new BigDecimal(""+map.get("qtyIssued"));
		// int qtyIssued=(Integer)map.get("qtyIssued");

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreIpIssueT storeIpIssueT = (StoreIpIssueT) hbt.load(
					StoreIpIssueT.class, ipIssueTId);
			int brandId = storeIpIssueT.getBrand().getId();
			String batchNo = storeIpIssueT.getBatchNo();
			BigDecimal costPrice = storeIpIssueT.getRate();
			BigDecimal qtyIssued = storeIpIssueT.getQtyIssued();

			String hql = "delete from StoreIpIssueT as sit where sit.Id like :ipIssueTId";
			Query query = session.createQuery(hql).setParameter("ipIssueTId",
					ipIssueTId);
			@SuppressWarnings("unused")
			int row = query.executeUpdate();

			List storeItemBatchStockList = session.createQuery(
					"select sib  from StoreItemBatchStock as sib where sib.BatchNo="
							+ batchNo + "and sib.Brand.Id=" + brandId
							+ "and sib.CostPrice=" + costPrice).list();
			StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) storeItemBatchStockList
					.get(0);
			BigDecimal qtyIssuedFromDB = (BigDecimal) storeItemBatchStock
					.getIssueQty();
			if (qtyIssued != null) {
				totalQtyIssued = qtyIssuedFromDB.subtract(qtyIssued);
			} else {
				totalQtyIssued = qtyIssuedFromDB;
			}
			BigDecimal closingStock = (BigDecimal) storeItemBatchStock
					.getClosingStock();
			closingStock = closingStock.add(qtyIssued);

			storeItemBatchStock.setIssueQty(totalQtyIssued);
			storeItemBatchStock.setClosingStock(closingStock);
			hbt.update(storeItemBatchStock);

			sucessfullyDeleted = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return sucessfullyDeleted;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientIssueJsp(Map map) {
		List listOfItemsInStock = new ArrayList();
		List ipIssueNo = new ArrayList();
		// List brandList=new ArrayList();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<BlDispensingDetails> blDispensingDetailsList = new ArrayList<BlDispensingDetails>();

		Session session = (Session) getSession();
		int deptId = (Integer) map.get("deptId");
		int inPatientId = (Integer) map.get("inPatientId");
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		int hinId = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatientId)).list();
			/*
			 * listOfItemsInStock = session .createQuery( //
			 * "select sib,  sum(sib.OpeningBalanceQty) from StoreItemBatchStock as sib where sib.Department.Id="
			 * + deptId + "group by sib.BatchNo,sib.CostPrice ").list();
			 */
			listOfItemsInStock = session
					.createCriteria(StoreItemBatchStock.class)
					.createAlias("Department", "dept")
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.setProjection(Projections.sum("OpeningBalanceQty"))
					.setProjection(Projections.groupProperty("CostPrice"))
					.setProjection(Projections.groupProperty("BatchNo")).list();
			ipIssueNo = session.createCriteria(StoreFyDocumentNo.class, "syd")
					.add(Restrictions.eq("syd.Department.Id", deptId))
					.add(Restrictions.eq("syd.Hospital.Id", hospitalId)).list();
			// ipIssueNo = session.createQuery(
			// "select syd from StoreFyDocumentNo as syd where syd.Department.Id="
			// + deptId).list();

			if (inPatientDetailList.size() > 0) {
				hinId = inPatientDetailList.get(0).getHin().getId();
			}

			// blDispensingDetailsList =
			// getHibernateTemplate().find("from BlDispensingDetails as bldetails join bldetails.DispensingHeader as blheader where blheader.Hin="+hinId+" and blheader.Inpatient="+inPatientId);

			blDispensingDetailsList = session
					.createCriteria(BlDispensingDetails.class)
					.createAlias("DispensingHeader", "header")
					.add(Restrictions.eq("header.Hin.Id", hinId))
					.add(Restrictions.eq("header.Inpatient.Id", inPatientId))
					.add(Restrictions.eq("header.Hospital.Id", hospitalId))
					.addOrder(Order.desc("Id")).list();

			// brandList = session.createQuery("select
			// Distinct(sib.Brand.Id),sib.Brand.BrandName from
			// StoreItemBatchStock as sib where
			// sib.Department.Id="+deptId).list();
			/*
			 * Iterator iterator=listOfItemsInStock.iterator();
			 * while(iterator.hasNext()) { Object[] pair = (Object[])
			 * iterator.next(); StoreItemBatchStock storeItemBatchStock =
			 * (StoreItemBatchStock) pair[0]; BigDecimal qtyInHand =
			 * (BigDecimal) pair[1]; String
			 * pvmsNo=storeItemBatchStock.getItem().getPvmsNo();
			 * item====="+storeItemBatchStock.getBatchNo()+" Quantity for the
			 * purticular item====="+qtyInHand); }
			 */
			if (map.get("buttonFlag") != null) {

				int issueNoOfPatient = (Integer) map.get("issueNoOfPatient");
				map.put("issueNoOfPatient", issueNoOfPatient);
			} else {
				if (ipIssueNo.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
							.get(0);
					if (storeFyDocumentNo.getIssueInPatientNo() != null) {
						int issueNoOfPatient = storeFyDocumentNo
								.getIssueInPatientNo();
						issueNoOfPatient = issueNoOfPatient + 1;
						map.put("issueNoOfPatient", issueNoOfPatient);
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("listOfItemsInStock", listOfItemsInStock);
		map.put("ipIssueNo", ipIssueNo);
		// map.put("brandList", brandList);
		map.put("blDispensingDetailsList", blDispensingDetailsList);
		map.put("inPatientDetailList", inPatientDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemList(Map map) {

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		// List<StoreItemBatchStock> itemList1 = new
		// ArrayList<StoreItemBatchStock>();
		Session session = (Session) getSession();

		int deptId = 0;

		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			/*
			 * String qry= "SELECT DISTINCT BRAND_NAME,brand_id FROM
			 * mas_store_brand m, store_item_batch_stock s"+ "where m.brand_id =
			 * s.brand_id and m.brand_name like 'b%'and s.department_id =1 and
			 * s.closing_stock > 0";
			 */

			String query = "SELECT DISTINCT (sib.Item.Nomenclature),sib.Item.PvmsNo from  StoreItemBatchStock as sib where sib.Department.Id="
					+ deptId
					+ "  and  sib.Item.Nomenclature like '"
					+ str
					+ "'";
			// String query= "SELECT DISTINCT (sib.Brand.BrandName),sib.Brand.Id
			// from StoreItemBatchStock as sib where
			// sib.Department.Id="+deptId+" and sib.Brand.BrandName like
			// '"+str+"'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			// Criteria c = session.createCriteria(
			// StoreItemBatchStock.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			// .createAlias("Brand", "brand")
			// .add(Restrictions.like("brand.BrandName",str));
			// .createAlias("Department", "dept")
			// .add(Restrictions.eq("dept.Id", deptId));
			//
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> fillItemsInGrid(Map map) {

		// List<MasStoreBrand> itemList= new ArrayList<MasStoreBrand>();
		Session session = (Session) getSession();
		String pvmsNo = (String) map.get("fillItemsInGrid");
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List objectList = new ArrayList();
		int deptId = 0;
		try {
			if (map.get("deptId") != null) {
				deptId = Integer.parseInt("" + map.get("deptId"));
			}
			String str = "" + map.get("pvmsNo");
			Criteria c = session.createCriteria(MasStoreItem.class).add(
					Restrictions.eq("PvmsNo", str));
			itemList = c.list();
			map.put("itemList", itemList);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitPatientIssueDetails(Map map) {
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		// String fromDateToDate= null;
		// List<String> pvmsList=(List)map.get("pvmsList");
		int itemId = (Integer) map.get("itemId");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List brandNameList = (List) map.get("brandNameList");
		List expiryDateList = (List) map.get("expiryDateList");
		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List storeItemBatchStockIdList = (List) map
				.get("storeItemBatchStockIdList");
		String date = (String) map.get("date");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		String time = (String) map.get("time");
		//String userName = (String) map.get("userName");
		int storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
		int patientIssueNo = (Integer) map.get("patientIssueNo");
		int hinId = (Integer) map.get("hinId");
		String admissionNumber = (String) map.get("admissionNumber");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// if(storeFyDocumentNoId!=0)
			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(
					StoreFyDocumentNo.class, storeFyDocumentNoId);
			StoreIpIssueM storeIpIssueM = null;
			int patientIssueNoFromDB = 0;
			if (storeFyDocumentNo.getIssueInPatientNo() != null) {
				patientIssueNoFromDB = storeFyDocumentNo.getIssueInPatientNo();
			}
			if (patientIssueNoFromDB != patientIssueNo) {
				storeFyDocumentNo.setIssueInPatientNo(patientIssueNo);
				hbt.update(storeFyDocumentNo);

				storeIpIssueM = new StoreIpIssueM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIpIssueM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIpIssueM.setHospital(masHospital);
				storeIpIssueM.setIpIssueDate(dateToInsert);
				storeIpIssueM.setIssueType("p");
				storeIpIssueM.setIpIssueNo("" + patientIssueNo);
				storeIpIssueM.setAdNo(admissionNumber);
				Patient patient = new Patient();
				patient.setId(hinId);
				storeIpIssueM.setHin(patient);

				//storeIpIssueM.setLastChgBy(userName);
				storeIpIssueM.setLastChgDate(dateToInsert);
				storeIpIssueM.setLastChgTime(time);
				hbt.save(storeIpIssueM);
			} else {
				List storeIpIssueMList = session.createQuery(
						"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
								+ patientIssueNo + " and sim.IssueType='p'")
						.list();
				storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
			}
			int i = 0;
			for (int j = 0; i < issQtyList.size(); j++) {
				BigDecimal totalQtyIssued;
				StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
				storeIpIssueT.setIpIssue(storeIpIssueM);
				MasStoreItem masStoreItem = new MasStoreItem();
				// masStoreItem.setId(Integer.parseInt(pvmsList.get(i)));
				masStoreItem.setId(itemId);
				storeIpIssueT.setItem(masStoreItem);
				storeIpIssueT.setBatchNo(batchNumberList.get(i));
				MasStoreBrand masStoreBrand = new MasStoreBrand();
				masStoreBrand
						.setId(Integer.parseInt("" + brandNameList.get(i)));
				storeIpIssueT.setBrand(masStoreBrand);
				String expiryDate = (String) expiryDateList.get(i);

				Date expiryDateToInsert = HMSUtil
						.convertStringTypeDateToDateType(expiryDate);
				storeIpIssueT.setExpiryDate(expiryDateToInsert);
				BigDecimal issuedQtyFromJsp = new BigDecimal(""
						+ issQtyList.get(i));
				storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeIpIssueT.setRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal("" + amountList.get(i));
				storeIpIssueT.setAmount(bigDecimal3);
				// hbt.save(storeIpIssueT);

				int storeItemBatchStockId = Integer.parseInt(""
						+ storeItemBatchStockIdList.get(i));
				StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, storeItemBatchStockId);
				BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
						.getIssueQty();
				// BigDecimal issQty=(BigDecimal)issQtyList.get(i);
				if (qtyIssued != null) {
					totalQtyIssued = qtyIssued.add(issuedQtyFromJsp);
				} else {
					totalQtyIssued = issuedQtyFromJsp;
				}

				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
						.getClosingStock();
				closingStock = closingStock.subtract(issuedQtyFromJsp);
				storeItemBatchStock.setIssueQty(totalQtyIssued);
				storeItemBatchStock.setClosingStock(closingStock);
				// hbt.save(storeIpIssueM);
				hbt.save(storeIpIssueT);
				hbt.update(storeItemBatchStock);
				i++;
			}
			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();

			e.printStackTrace();

		} // finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		return succesfullyAdded;
	}
	@Override
	public boolean submitWardConsumptionIssueDetails(Map map) {

		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		// String fromDateToDate= null;
		try {
			// List<String> pvmsList=(List)map.get("pvmsList");
			int itemId = (Integer) map.get("itemId");
			List<String> batchNumberList = (List) map.get("batchNumberList");
			//List brandNameList = (List) map.get("brandNameList");
			List expiryDateList = (List) map.get("expiryDateList");
			List issQtyList = (List) map.get("issQtyList");
			List costPriceList = (List) map.get("costPriceList");
			List amountList = (List) map.get("amountList");
			List storeItemBatchStockIdList = (List) map
					.get("storeItemBatchStockIdList");
			String date = (String) map.get("date");
			int deptId = (Integer) map.get("deptId");
			int hospitalId = (Integer) map.get("hospitalId");
			String time = (String) map.get("time");
			String userName = (String) map.get("userName");
			int storeFyDocumentNoId = 1;
			if ((map.get("storeFyDocumentNoId") != null)
					&& (!map.get("storeFyDocumentNoId").equals(""))) {
				storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
			}
			int patientIssueNo = 0;
			patientIssueNo = (Integer) map.get("patientIssueNo");
			// patientIssueNo=(Integer) map.get("patientIssueNo");
			int hinId = (Integer) map.get("hinId");
			String admissionNumber = (String) map.get("admissionNumber");
			Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);

			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				// if(storeFyDocumentNoId!=0)
				StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt
						.load(StoreFyDocumentNo.class, storeFyDocumentNoId);
				StoreIpIssueM storeIpIssueM = null;
				storeFyDocumentNo.setIssueInPatientNo(patientIssueNo);
				hbt.update(storeFyDocumentNo);
				int patientIssueNoFromDB = storeFyDocumentNo.getIssueWardNo();
				if (patientIssueNoFromDB != patientIssueNo) {

					storeIpIssueM = new StoreIpIssueM();
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					storeIpIssueM.setDepartment(masDepartment);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					storeIpIssueM.setHospital(masHospital);
					storeIpIssueM.setIpIssueDate(dateToInsert);
					storeIpIssueM.setIssueType("w");
					storeIpIssueM.setIpIssueNo("" + patientIssueNo);
					storeIpIssueM.setAdNo(admissionNumber);

					//storeIpIssueM.setLastChgBy(userName);
					storeIpIssueM.setLastChgDate(dateToInsert);
					storeIpIssueM.setLastChgTime(time);
					hbt.save(storeIpIssueM);
				} else {
					List storeIpIssueMList = session
							.createQuery(
									"select sim from StoreIpIssueM as sim where sim.IpIssueNo="
											+ patientIssueNo
											+ " and sim.IssueType='w'").list();
					storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
				}

				// Iterator itr= issQtyList.iterator();
				int i = 0;
				for (int j = 0; i < issQtyList.size(); j++)

				{

					BigDecimal totalQtyIssued;
					StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
					storeIpIssueT.setIpIssue(storeIpIssueM);
					MasStoreItem masStoreItem = new MasStoreItem();
					// masStoreItem.setId(Integer.parseInt(pvmsList.get(i)));
					masStoreItem.setId(itemId);
					storeIpIssueT.setItem(masStoreItem);
					storeIpIssueT.setBatchNo(batchNumberList.get(i));
					// MasStoreBrand masStoreBrand= new MasStoreBrand();
					// masStoreBrand.setId(Integer.parseInt(""+brandNameList.get(i)));
					// storeIpIssueT.setBrand(masStoreBrand);
					String expiryDate = (String) expiryDateList.get(i);

					Date expiryDateToInsert = HMSUtil
							.convertStringTypeDateToDateType(expiryDate);
					storeIpIssueT.setExpiryDate(expiryDateToInsert);
					BigDecimal issuedQtyFromJsp = new BigDecimal(""
							+ issQtyList.get(i));
					storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
					BigDecimal bigDecimal2 = new BigDecimal(""
							+ costPriceList.get(i));
					storeIpIssueT.setRate(bigDecimal2);
					BigDecimal bigDecimal3 = new BigDecimal(""
							+ amountList.get(i));
					storeIpIssueT.setAmount(bigDecimal3);
					// hbt.save(storeIpIssueT);

					int storeItemBatchStockId = Integer.parseInt(""
							+ storeItemBatchStockIdList.get(i));
					StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
							.load(StoreItemBatchStock.class,
									storeItemBatchStockId);
					BigDecimal qtyIssued = (BigDecimal) storeItemBatchStock
							.getIssueQty();
					// BigDecimal issQty=(BigDecimal)issQtyList.get(i);
					if (qtyIssued != null) {
						totalQtyIssued = qtyIssued.add(issuedQtyFromJsp);
					} else {
						totalQtyIssued = issuedQtyFromJsp;
					}

					BigDecimal closingStock = (BigDecimal) storeItemBatchStock
							.getClosingStock();

					closingStock = closingStock.subtract(issuedQtyFromJsp);
					storeItemBatchStock.setIssueQty(totalQtyIssued);
					storeItemBatchStock.setClosingStock(closingStock);

					// hbt.save(storeIpIssueM);
					hbt.save(storeIpIssueT);
					hbt.update(storeItemBatchStock);

					i++;
				}

				succesfullyAdded = true;
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();

			}// finally{
			/**
			 * session.close() is done By Ramdular Prajapati Date 12 May 2010
			 */
			/*
			 * if(session!=null){ session.close(); } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return succesfullyAdded;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> viewPatientIssueDetails(Map map) {
		Session session = (Session) getSession();
		String admissionNumber = (String) map.get("admissionNumber");
		List<StoreIpIssueT> storeIpIssueTList = new ArrayList<StoreIpIssueT>();
		// List storeIpIssueMList = session.createQuery("select sim from
		// StoreIpIssueM as sim where sim.AdNo="+admissionNumber).list();
		List storeIpIssueMList = session.createCriteria(StoreIpIssueM.class)
				.add(Restrictions.eq("AdNo", admissionNumber)).list();
		Iterator itr = storeIpIssueMList.iterator();
		while (itr.hasNext())
		// if(storeIpIssueMList.size() > 0)
		{
			StoreIpIssueM storeIpIssueM = (StoreIpIssueM) itr.next();
			int storeIpIssueMId = storeIpIssueM.getId();
			List listOfValues = session.createQuery(
					"select sit from StoreIpIssueT as sit where sit.IpIssue.Id="
							+ storeIpIssueMId
							+ " order by sit.ExpiryDate desc  ").list();
			if (listOfValues.size() > 0) {
				Iterator listOfValuesItr = listOfValues.iterator();
				while (listOfValuesItr.hasNext()) {
					StoreIpIssueT storeIpIssueT = (StoreIpIssueT) listOfValuesItr
							.next();
					storeIpIssueTList.add(storeIpIssueT);
				}
			}
		}
		map.put("storeIpIssueTList", storeIpIssueTList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientDiagnosisJsp(Map map) {

		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<DischargeIcdCode> disList = new ArrayList<DischargeIcdCode>();
		List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		List<OpdPatientHistory> historyList = new ArrayList<OpdPatientHistory>();

		Session session = (Session) getSession();
		int inPatientId = (Integer) map.get("inPatientId");
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatientId)).list();
			// icdNoList=session.createCriteria(MasIcd.class).list();
			disList = session.createCriteria(DischargeIcdCode.class, "dis")
					.add(Restrictions.eq("dis.Inpatient.Id", inPatientId))
					.add(Restrictions.eq("dis.Hospital.Id", hospitalId))
					.addOrder(Order.desc("dis.Id")).list();

			// disList = session.createQuery(
			// "select dis from DischargeIcdCode as dis where dis.Inpatient.Id='"
			// + inPatientId + "' order by dis.Id desc ").list();

			historyList = session
					.createCriteria(OpdPatientHistory.class)
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.Id", inPatientDetailList.get(0)
							.getHin().getId()))
					.add(Restrictions.eq("hin.Hospital.Id", hospitalId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("icdNoList", icdNoList);
		map.put("disList", disList);
		map.put("historyList", historyList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getICDList(Map map) {

		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		@SuppressWarnings("unused")
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			try {
				Criteria c = session
						.createCriteria(MasIcd.class)
						.add(Restrictions.eq("Status", "y"))
						.createAlias("IcdSubCategory", "sub")
						.add(Restrictions.or(Restrictions.like("IcdName", str),
								Restrictions
										.like("sub.IcdSubCategoryName", str)));
				c.setFirstResult(0);
				c.setMaxResults(40);
				itemList = c.list();
				if (itemList.size() == 0) {
					String query = "select icd from MasIcd as icd where icd.IcdName like '"
							+ str + "' and status = 'y'";
					Query q = session.createQuery(query);
					q.setFirstResult(0);
					q.setMaxResults(40);
					itemList = q.list();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addPatientDiagnosisInformation(Map map) {
		boolean saved = false;
		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();
		if (map.get("icdCodeList") != null) {
			icdCodeList = (List<DischargeIcdCode>) map.get("icdCodeList");
		}

		String[] icdIdArr = null;
		if (map.get("icdIdArr") != null) {
			icdIdArr = (String[]) map.get("icdIdArr");
		}
		@SuppressWarnings("unused")
		Session session = (Session) getSession();
		try {

			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			String query = "";
			List objectList = new ArrayList();
			if (icdCodeList.size() > 0) {
				for (int i = 0; i < icdCodeList.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode = (DischargeIcdCode) icdCodeList.get(i);
					MasIcd masIcd = new MasIcd();
					query = "select icd_id from mas_icd where icd_code='"
							+ icdIdArr[i] + "'";
					objectList = (List) session.createSQLQuery(query).list();
					masIcd.setId(Integer.parseInt("" + objectList.get(0)));
					dischargeIcdCode.setIcd(masIcd);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);
					saved = true;
				}

			}

			// ---------- Adding Patient History Details--------------------
			String pastHistory = "";
			String personalHistory = "";
			String familyHistory = "";
			int deptId = 0;
			int hospitalId = 0;
			int inpatientId = 0;
			int hinId = 0;
			String userName = "";
			Date addEditDate = new Date();
			String addEditTime = "";

			if (map.get("pastHistory") != null) {
				pastHistory = (String) map.get("pastHistory");
			}
			if (map.get("personalHistory") != null) {
				personalHistory = (String) map.get("personalHistory");
			}
			if (map.get("familyHistory") != null) {
				familyHistory = (String) map.get("familyHistory");
			}
			if (map.get("deptId") != null) {
				deptId = (Integer) map.get("deptId");
			}
			if (map.get("hospitalId") != null) {
				hospitalId = (Integer) map.get("hospitalId");
			}
			if (map.get("inpatientId") != null) {
				inpatientId = (Integer) map.get("inpatientId");
			}
			if (map.get("hinId") != null) {
				hinId = (Integer) map.get("hinId");
			}
			if (map.get("userName") != null) {
				userName = (String) map.get("userName");
			}
			if (map.get("addEditDate") != null) {
				addEditDate = (Date) map.get("addEditDate");
			}
			if (map.get("addEditTime") != null) {
				addEditTime = (String) map.get("addEditTime");
			}
			if (!pastHistory.equals("") || !personalHistory.equals("")
					|| !familyHistory.equals("")) {
				OpdPatientHistory patientHistory = new OpdPatientHistory();

				MasDepartment department = new MasDepartment();
				department.setId(deptId);
				patientHistory.setDepartment(department);

				MasHospital mh = new MasHospital();
				mh.setId(hospitalId);
				patientHistory.setHospital(mh);

				Patient p = new Patient();
				p.setId(hinId);
				patientHistory.setHin(p);

				patientHistory.setVisitInpatientId(inpatientId);

				patientHistory.setLastChgTime(addEditTime);

				//patientHistory.setLastChgBy(userName);

				patientHistory.setStatus("y");
				patientHistory.setLastChgDate(addEditDate);

				patientHistory.setPersonalPastHistory(pastHistory);
				patientHistory.setPersonalPresentHistory(personalHistory);

				patientHistory.setFamilyPresentHistory(familyHistory);
				patientHistory.setIpOpPacStatus("I");

				hbt.save(patientHistory);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return saved;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showSilDilJsp(Map map) {

		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<SilDilStatus> siList = new ArrayList<SilDilStatus>();
		List<MasIcd> icdNoList = new ArrayList<MasIcd>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		int inPatientId = (Integer) map.get("inPatientId");
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatientId)).list();
			// icdNoList=session.createCriteria(MasIcd.class).list();
			siList = session.createQuery(
					"select sil from SilDilStatus as sil where sil.Inpatient.Id='"
							+ inPatientId + "' order by sil.Id desc").list();

			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("icdNoList", icdNoList);
		map.put("employeeList", employeeList);
		map.put("siList", siList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitSilDilStatus(Map map) {
		boolean successfullyUpdated = false;
		int inpatientId = (Integer) map.get("inpatientId");
		String icdCode = "" + map.get("icdCode");
		String patientCondition = (String) map.get("patientCondition");
		String conditionStatus = (String) map.get("conditionStatus");
		String date = (String) map.get("date");
		String silDilTime = (String) map.get("silDilTime");
		String nokType = (String) map.get("nokType");
		int deptId = (Integer) map.get("deptId");
		int hinId = (Integer) map.get("hinId");
		String[] diagnosidIdArray = null;
		int placedBy = (Integer) map.get("placedBy");
		String remarks = "";
		int multiIcdId = 0;
		String str = "";
		if (!map.get("remarks").equals("select")) {
			remarks = (String) map.get("remarks");
		}
		String treatment = "";
		if (map.get("treatment") != null) {
			treatment = (String) map.get("treatment");
		}
		if (map.get("diagnosidIdArray") != null) {
			diagnosidIdArray = (String[]) map.get("diagnosidIdArray");
		}
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		Date listDate = HMSUtil.convertStringTypeDateToDateType(date);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();

		String currentTime = (String) utilMap.get("currentTime");
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
			Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
			inpatient.setPatientCondition(patientCondition);
			inpatient.setConditionStatus(conditionStatus);
			inpatient.setListDate(listDate);
			inpatient.setListTime(silDilTime);
			hbt.update(inpatient);
			hbt.refresh(inpatient);
			String query = "";
			List objectList = new ArrayList();
			if (diagnosidIdArray != null) {
				for (int i = 0; i < diagnosidIdArray.length; i++) {
					if (diagnosidIdArray[i].equals("0")) {
						continue;
					}
					query = "select icd_id from mas_icd where icd_code='"
							+ diagnosidIdArray[i] + "'";
					objectList = (List) session.createSQLQuery(query).list();
					multiIcdId = (Integer.parseInt("" + objectList.get(0)));
					// ------Storing Multiple Diagnosis------------

					SilDilStatus silDilStatus = new SilDilStatus();
					Inpatient inpatientObj = new Inpatient();
					inpatientObj.setId(inpatientId);
					silDilStatus.setInpatient(inpatientObj);
					if (multiIcdId != 0) {
						MasIcd masIcd = new MasIcd();
						masIcd.setId(multiIcdId);
						silDilStatus.setIcd(masIcd);
					}
					silDilStatus.setConditionStatus(conditionStatus);

					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					silDilStatus.setDepartment(masDepartment);
					silDilStatus.setTreatment(treatment);
					silDilStatus.setRemarks(remarks);
					silDilStatus.setLastChgBy(userName);
					silDilStatus.setLastChgDate(listDate);
					silDilStatus.setLastChgTime(silDilTime);
					silDilStatus.setNok(nokType);
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(placedBy);
					silDilStatus.setPlacedBy(masEmployee);
					hbt.save(silDilStatus);
					hbt.refresh(silDilStatus);
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();

					Inpatient inpatient2 = new Inpatient();
					inpatient2.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient);

					Patient patient = new Patient();
					patient.setId(hinId);
					dischargeIcdCode.setHin(patient);
					if (multiIcdId != 0) {
						MasIcd masIcd2 = new MasIcd();
						masIcd2.setId(multiIcdId);
						dischargeIcdCode.setIcd(masIcd2);
					}
					try {
						Users users = new Users();
						users.setId(placedBy);
						dischargeIcdCode.setAddEditBy(users);
					} catch (Exception e) {
						e.printStackTrace();
					}
					dischargeIcdCode.setZ03("n");
					dischargeIcdCode.setZ09("n");
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setDiagnosisStatus("p");
					dischargeIcdCode.setAddEditTime(time);
					dischargeIcdCode.setAddEditDate(listDate);
					hbt.save(dischargeIcdCode);
					hbt.refresh(dischargeIcdCode);

				}
			} else {

				SilDilStatus silDilStatus = new SilDilStatus();
				Inpatient inpatientObj = new Inpatient();
				inpatientObj.setId(inpatientId);
				silDilStatus.setInpatient(inpatientObj);
				try {
					if (!icdCode.equals("")) {
						query = "select icd_id from mas_icd where icd_code='"
								+ icdCode + "'";
						objectList = (List) session.createSQLQuery(query)
								.list();
						MasIcd masIcd = new MasIcd();
						masIcd.setId(Integer.parseInt("" + objectList.get(0)));
						silDilStatus.setIcd(masIcd);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				silDilStatus.setConditionStatus(conditionStatus);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				silDilStatus.setDepartment(masDepartment);
				silDilStatus.setTreatment(treatment);
				silDilStatus.setRemarks(remarks);
				silDilStatus.setLastChgBy(userName);
				silDilStatus.setLastChgDate(listDate);
				silDilStatus.setLastChgTime(silDilTime);
				silDilStatus.setNok(nokType);
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(placedBy);
				silDilStatus.setPlacedBy(masEmployee);
				hbt.save(silDilStatus);
				hbt.refresh(silDilStatus);
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();

				Inpatient inpatient2 = new Inpatient();
				inpatient2.setId(inpatientId);
				dischargeIcdCode.setInpatient(inpatient);

				Patient patient = new Patient();
				patient.setId(hinId);
				dischargeIcdCode.setHin(patient);
				try {
					if (!icdCode.equals("")) {
						query = "select icd_id from mas_icd where icd_code='"
								+ icdCode + "'";
						objectList = (List) session.createSQLQuery(query)
								.list();
						MasIcd masIcd2 = new MasIcd();
						masIcd2.setId(Integer.parseInt("" + objectList.get(0)));
						dischargeIcdCode.setIcd(masIcd2);
						Users users = new Users();
						users.setId(placedBy);
						dischargeIcdCode.setAddEditBy(users);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				dischargeIcdCode.setZ03("n");
				dischargeIcdCode.setZ09("n");
				dischargeIcdCode.setStatus("y");
				dischargeIcdCode.setDiagnosisStatus("p");
				dischargeIcdCode.setAddEditTime(time);
				dischargeIcdCode.setAddEditDate(listDate);
				hbt.save(dischargeIcdCode);
				hbt.refresh(dischargeIcdCode);
			}
			successfullyUpdated = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return successfullyUpdated;
	}

	// -------------------------------Nursing Clinical
	// Chart-------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showNursingClinicalChartJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Session session = (Session) getSession();
		List<IpdClinicalChart> searchIpdClinicalChartList = new ArrayList<IpdClinicalChart>();
		List<Inpatient> adList = new ArrayList<Inpatient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class, "ip")
				.add(Restrictions.eq("ip.AdStatus", "A"))
				.add(Restrictions.eq("ip.Id", box.getInt("parent")))
				.add(Restrictions.eq("ip.Department.Id", box.getInt(DEPT_ID)))
				.add(Restrictions.eq("ip.Hospital.Id", box.getInt(HOSPITAL_ID)))
				.addOrder(Order.desc("DateOfAddmission")).list();
		// adList = getHibernateTemplate()
		// .find("from jkt.hms.masters.business.Inpatient as ip where ip.AdStatus = 'A' ");
		// for (Inpatient inpatient : adList) {
		// if (inpatient.getDepartment().getId() == departmentId) {
		// inpatientList.add(inpatient);
		// }
		// }
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean addNursingClinicalChart(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTime");
		//String currentDate = (String) utilMap.get("currentDate");
		//String time = (String) utilMap.get("currentTime");
		/*String intakeOutputTime = (String) utilMap.get("currenTime");
		String intakeOutputDate = (String) utilMap.get("currenDate");*/
		@SuppressWarnings("unused")
		Date temperatureDate = new Date();
		Date intakeDate = new Date();
		Date outputDate = new Date();
		int hinId = box.getInt(HIN_ID);
		String adNo = box.getString(AD_NO);
		String treatment = null;
		@SuppressWarnings("unused")
		String currentTime;
//		List ipdTemperatureObjList = new ArrayList();
//		List ipdIntakeObjList = new ArrayList();
//		List ipdOutputObjList = new ArrayList();
		
		int userId =box.getInt(USER_ID);
		Map<String, Object> map = new HashMap<String, Object>();
//		List list = new ArrayList();
		int departmentId =box.getInt(DEPT_ID);
		int hospitalId =box.getInt(HOSPITAL_ID);
		
		
		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdIntakeOutputChart.setDepartment(masDepartment);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		ipdIntakeOutputChart.setHospital(masHospital);
		int inpatientId = box.getInt("inpatientId");
		Patient patientObj = new Patient();
		patientObj.setId(hinId);
		ipdIntakeOutputChart.setHin(patientObj);
			Inpatient inpatientObj = new Inpatient();
			inpatientObj.setId(inpatientId);
			inpatientObj.setAdNo(adNo);
			ipdIntakeOutputChart.setAdNo(adNo);
		//
		if (box.getString(TREATMENT)!=null && !box.getString(TREATMENT).equals("") ) {
			treatment = box.getString(TREATMENT);
		}
		Users users = new Users();
		users.setId(userId);
		ipdIntakeOutputChart.setLastChgBy(users);
		ipdIntakeOutputChart.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setLastChgTime(lastChgTime);
		ipdIntakeOutputChart.setDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setTime(lastChgTime);
		
		ipdIntakeOutputChart.setTreatment(treatment);
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();
		ipdIntakeOutputChartList = hbt
				.find("from jkt.hms.masters.business.IpdIntakeOutputChart as inp where inp.AdNo = '"
						+ adNo + "'");
		IpdIntakeOutputChart ipdChart = null;
		if (ipdIntakeOutputChartList.size() > 0) {
			ipdChart = (IpdIntakeOutputChart) hbt.load(
					IpdIntakeOutputChart.class, ipdIntakeOutputChartList
							.get(0).getId());
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			ipdChart.setTreatment(ipdIntakeOutputChart.getTreatment());
			ipdChart.setDate(ipdIntakeOutputChart.getDate());
			ipdChart.setTime(ipdIntakeOutputChart.getTime());
			hbt.update(ipdChart);

		} else {
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			hbt.save(ipdIntakeOutputChart);
			ipdChart=ipdIntakeOutputChart;
		}
		
		
		
		try {
			int commonIntakeOutputLength=box.getInt("intakeOutputIdcount");
			for (int i = 1; i <= commonIntakeOutputLength; i++) {
			if (box.getFloat(TEMPERATURE+i) != 0 
					|| box.getInt(PULSE+i) != 0 
					|| box.getInt(RESPIRATION+i) != 0 
					|| (!box.getString(BP+"pre"+i).equals("")&& !box.getString(BP+"post"+i).equals(""))) {
					IpdTemperature ipdTemperature = new IpdTemperature();
					
					
					ipdTemperature.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString(TEMPERATURE_DATE+i)));
					ipdTemperature.setTime(box.getString(TEMPERATURE_TIME+i));
					if (box.getFloat(TEMPERATURE+i) != 0) {
						ipdTemperature.setTemperature(box.getFloat(TEMPERATURE+i));
					}
					if (box.getInt(PULSE+i) != 0) {
						ipdTemperature.setPulse(box.getInt(PULSE+i));
					}
					if (box.getInt(RESPIRATION+i) != 0) {
						ipdTemperature.setRespiration(box.getInt(RESPIRATION+i));
					}
					String bp="";
					if(!box.getString(BP+"pre"+i).equals("")&& !box.getString(BP+"post"+i).equals(""))
					{
						bp=box.getString(BP+"pre"+i)+"/"+box.getString(BP+"post"+i);
					}
					ipdTemperature.setBp(bp);
					ipdTemperature.setRemarks(box.getString(TEMPERATURE_REMARKS+i));
					ipdTemperature.setLastChgBy(users);
					//ipdTemperature.setFhr(box.getString(FHR+i));
					ipdTemperature.setPain(box.getString(PAIN+i));
					ipdTemperature.setBowel(box.getString(BOWEL+i));
					
					ipdTemperature.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdTemperature.setLastChgTime(lastChgTime);
					ipdTemperature.setIntakeoutput(ipdChart);
					hbt.save(ipdTemperature);
					
//					ipdTemperatureObjList.add(ipdTemperature);
				}
			}
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
				successfullyAdded = false;
			}
			return successfullyAdded;
		
		/*@SuppressWarnings("unused")
		List<Object> intakeList = new ArrayList<Object>();
		@SuppressWarnings("unused")
		List tempList = new ArrayList();
		if (dataMap.get("intakeList") != null) {
			intakeList = (List) dataMap.get("intakeList");
		}
		if (dataMap.get("tempList") != null) {
			tempList = (List) dataMap.get("tempList");
		}
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			if (intakeList.size() > 0) {
				for (int i = 0; i < intakeList.size(); i++) {
					IpdIntakeOutputChart ipdIntakeOutputChart = (IpdIntakeOutputChart) intakeList
							.get(i);
					IpdTemperature ipdTemperature = (IpdTemperature) tempList
							.get(i);
					// String qry =
					// "SELECT intakeoutput_id FROM ipd_intake_output_chart where ad_no='"
					// + ipdIntakeOutputChart.getAdNo() + "'";
					List objectList = new ArrayList();
					objectList = session
							.createCriteria(IpdIntakeOutputChart.class)
							.add(Restrictions.eq("AdNo",
									ipdIntakeOutputChart.getAdNo()))
							.add(Restrictions.eq("Hospital.Id",
									ipdIntakeOutputChart.getHospital().getId()))
							.list();
					// objectList = (List) session.createSQLQuery(qry).list();
					if (objectList.size() > 0) {
						ipdTemperature
								.setIntakeoutput(new IpdIntakeOutputChart(
										Integer.parseInt("" + objectList.get(0))));
						hbt.save(ipdTemperature);
					} else {
						hbt.save(ipdIntakeOutputChart);
						ipdTemperature.setIntakeoutput(ipdIntakeOutputChart);
						hbt.save(ipdTemperature);
					}
				}

			}
			transaction.commit();
			hbt.flush();
			hbt.clear();
			successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
		@SuppressWarnings("unused")
		String[] statusArr = (String[]) dataMap.get("statusArr");
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		return successfullyAdded;*/
	}

	@SuppressWarnings("unchecked")
	public Map getViewClinicalChart(Map<String, Object> dataMap) {
		String radio_str = "";
		int deptId = 0;
		String deptName = "";
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();

		if (dataMap.get("radio_str") != null) {
			radio_str = "" + dataMap.get("radio_str");
		}
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		deptList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Id", deptId)).list();
		for (MasDepartment department : deptList) {
			deptName = "" + department.getDepartmentName();
		}
		Map map = new HashMap();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdTemperature> ipdTemperatureList = new ArrayList<IpdTemperature>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();

		inpatientList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Inpatient as ip where ip.AdNo = '"
						+ radio_str + "'");
		ipdIntakeOutputChartList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.IpdIntakeOutputChart as md where md.AdNo = '"
						+ radio_str + "'  ");

		int intakeId = 0;
		for (IpdIntakeOutputChart ipdIntakeOutputChart : ipdIntakeOutputChartList) {
			intakeId = Integer.parseInt("" + ipdIntakeOutputChart.getId());
		}
		ipdTemperatureList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.IpdTemperature as md where md.Intakeoutput.Id = '"
						+ intakeId + "' order by md.Id desc ");
		map.put("inpatientList", inpatientList);
		map.put("ipdTemperatureList", ipdTemperatureList);
		map.put("ipdIntakeOutputChartList", ipdIntakeOutputChartList);
		map.put("deptName", deptName);
		return map;
	}

	// ---------------------------------Intake/Output
	// Chart----------------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showIntakeOutputJsp(int inPatient) {

		String admissionNumber = null;
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<IpdIntakeOutput> intakeOutputList = new ArrayList<IpdIntakeOutput>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hinNo = "";
		try {
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatient)).list();

			if (inPatientDetailList != null) {
				Inpatient inpatient = (Inpatient) inPatientDetailList.get(0);
				admissionNumber = inpatient.getAdNo();
				hinNo = ("" + inpatient.getHinNo());
			}
			intakeOutputList = session.createCriteria(IpdIntakeOutput.class)
					.add(Restrictions.eq("AdNo", admissionNumber)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("intakeOutputList", intakeOutputList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("hinNo", hinNo);
		return map;
	}

	@Override
	public Map<String, Object>  addIntakeOutput(Box box) {
		boolean successfullyAdded = false;
		Session session = (Session) getSession();
		
		
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTime");
		//String currentDate = (String) utilMap.get("currentDate");
		//String time = (String) utilMap.get("currentTime");
		/*String intakeOutputTime = (String) utilMap.get("currenTime");
		String intakeOutputDate = (String) utilMap.get("currenDate");*/
		@SuppressWarnings("unused")
		Date temperatureDate = new Date();
		Date intakeDate = new Date();
		Date outputDate = new Date();
		int hinId = box.getInt(HIN_ID);
		String adNo = box.getString(AD_NO);
		String treatment = null;
		@SuppressWarnings("unused")
		String currentTime;
//		List ipdTemperatureObjList = new ArrayList();
//		List ipdIntakeObjList = new ArrayList();
//		List ipdOutputObjList = new ArrayList();
		
		Map<String, Object> objMap = new HashMap<String, Object>();
		int userId =box.getInt(USER_ID);
		Map<String, Object> map = new HashMap<String, Object>();
//		List list = new ArrayList();
		int departmentId =box.getInt(DEPT_ID);
		int hospitalId =box.getInt(HOSPITAL_ID);
		
		
		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdIntakeOutputChart.setDepartment(masDepartment);
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		ipdIntakeOutputChart.setHospital(masHospital);
		int inpatientId = box.getInt("inpatientId");
		Patient patientObj = new Patient();
		patientObj.setId(hinId);
		ipdIntakeOutputChart.setHin(patientObj);
			Inpatient inpatientObj = new Inpatient();
			inpatientObj.setId(inpatientId);
			inpatientObj.setAdNo(adNo);
			ipdIntakeOutputChart.setAdNo(adNo);
		//
		if (box.getString(TREATMENT)!=null && !box.getString(TREATMENT).equals("") ) {
			treatment = box.getString(TREATMENT);
		}
		Users users = new Users();
		users.setId(userId);
		ipdIntakeOutputChart.setLastChgBy(users);
		ipdIntakeOutputChart.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setLastChgTime(lastChgTime);
		ipdIntakeOutputChart.setDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setTime(lastChgTime);
		
		ipdIntakeOutputChart.setTreatment(treatment);
		
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();
		ipdIntakeOutputChartList = hbt
				.find("from jkt.hms.masters.business.IpdIntakeOutputChart as inp where inp.AdNo = '"
						+ adNo + "'");
		IpdIntakeOutputChart ipdChart = null;
		if (ipdIntakeOutputChartList.size() > 0) {
			ipdChart = (IpdIntakeOutputChart) hbt.load(
					IpdIntakeOutputChart.class, ipdIntakeOutputChartList
							.get(0).getId());
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			ipdChart.setTreatment(ipdIntakeOutputChart.getTreatment());
			ipdChart.setDate(ipdIntakeOutputChart.getDate());
			ipdChart.setTime(ipdIntakeOutputChart.getTime());
			hbt.update(ipdChart);

		} else {
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(ipdIntakeOutputChart);
			ipdChart=ipdIntakeOutputChart;

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		ipdIntakeOutputChart.setDate(HMSUtil
//				.convertStringTypeDateToDateType(currentDate));
//		ipdIntakeOutputChart.setTime(time);
		//int deptId = (Integer) session.getAttribute("deptId");
//		Date[] temperatureDateArray = new Date[100];
//		Date[] intakeDateArray = new Date[100];
//		Date[] outputDateArray = new Date[100];
		// ----------------------------------Temperature
		// Grid------------------------------------------
		try {
			
			/*float[] temperatureArr = JKTRequestUtils
					.getRequiredFloatParameters(request, TEMPERATURE);
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					TEMPERATURE_DATE);
			int zzLegnt = zz.length;
			for (int i = 0; i < zzLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(zz[i]));
				temperatureDate = java.sql.Date.valueOf(date4MySQL);
				temperatureDateArray[i] = temperatureDate;
			}
			String[] temperatureTimeArr = JKTRequestUtils.getStringParameters(
					request, TEMPERATURE_TIME);
			int pulseArr[] = JKTRequestUtils.getIntParameters(request, PULSE);
			int respirationArr[] = JKTRequestUtils.getIntParameters(request,
					RESPIRATION);
			String[] bpArr = JKTRequestUtils.getStringParameters(request, BP);
			String[] temperatureRemarksArr = JKTRequestUtils
					.getStringParameters(request, TEMPERATURE_REMARKS);
			String[] bowelArr = JKTRequestUtils.getStringParameters(request,
					BOWEL);
			String[] painArr = JKTRequestUtils.getStringParameters(request,
					PAIN);
			String[] fhrArr = JKTRequestUtils.getStringParameters(request, FHR);

			int templength = temperatureArr.length;
			int pulselength = pulseArr.length;
			int resplength = respirationArr.length;
			int bplength = bpArr.length;*/
			
			//commented due to vital care removal
			/*int commonIntakeOutputLength=box.getInt("intakeOutputIdcount");
			for (int i = 1; i <= commonIntakeOutputLength; i++) {
				
			if (box.getFloat(TEMPERATURE+i) != 0 
					|| box.getInt(PULSE+i) != 0 
					|| box.getInt(RESPIRATION+i) != 0 
					|| (!box.getString(BP+"pre"+i).equals("")&& !box.getString(BP+"post"+i).equals(""))) {
					IpdTemperature ipdTemperature = new IpdTemperature();
					
					
					ipdTemperature.setDate(HMSUtil.convertStringTypeDateToDateType(box.getString(TEMPERATURE_DATE+i)));
					ipdTemperature.setTime(box.getString(TEMPERATURE_TIME+i));
					if (box.getFloat(TEMPERATURE+i) != 0) {
						ipdTemperature.setTemperature(box.getFloat(TEMPERATURE+i));
					}
					if (box.getInt(PULSE+i) != 0) {
						ipdTemperature.setPulse(box.getInt(PULSE+i));
					}
					if (box.getInt(RESPIRATION+i) != 0) {
						ipdTemperature.setRespiration(box.getInt(RESPIRATION+i));
					}
					String bp="";
					if(!box.getString(BP+"pre"+i).equals("")&& !box.getString(BP+"post"+i).equals(""))
					{
						bp=box.getString(BP+"pre"+i)+"/"+box.getString(BP+"post"+i);
					}
					ipdTemperature.setBp(bp);
					ipdTemperature.setRemarks(box.getString(TEMPERATURE_REMARKS+i));
					ipdTemperature.setLastChgBy(users);
					//ipdTemperature.setFhr(box.getString(FHR+i));
					ipdTemperature.setPain(box.getString(PAIN+i));
					ipdTemperature.setBowel(box.getString(BOWEL+i));
					
					ipdTemperature.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdTemperature.setLastChgTime(lastChgTime);
					ipdTemperature.setIntakeoutput(ipdChart);
					hbt.save(ipdTemperature);
					
//					ipdTemperatureObjList.add(ipdTemperature);
				}
			}*/
			// ----------------------------------------Intake
			// Grid--------------------------------------
			
			
			
			/*String intakeArr[] = JKTRequestUtils.getStringParameters(request,
					INTAKE);
			String aa[] = JKTRequestUtils.getRequiredStringParameters(request,
					INTAKE_DATE);
			int aaLegnt = aa.length;
			for (int i = 0; i < aaLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(aa[i]));
				intakeDate = java.sql.Date.valueOf(date4MySQL);

				intakeDateArray[i] = intakeDate;
			}
			String intakeTimeArr[] = JKTRequestUtils.getStringParameters(
					request, INTAKE_TIME);
			String[] oralArr = JKTRequestUtils.getStringParameters(request,
					ORAL);

			String[] ptrArr = JKTRequestUtils.getStringParameters(request, PTR);
			String[] ivArr = JKTRequestUtils.getStringParameters(request, IV);
			String[] ivCountArr = JKTRequestUtils.getStringParameters(request,
					IV_COMBO);
			String[] intakeRemarksArr = JKTRequestUtils.getStringParameters(
					request, INTAKE_REMARKS);
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}

			int intakelength = intakeArr.length;
			int orallength = oralArr.length;
			int ptrlength = ptrArr.length;
			int ivlength = ivArr.length;
			int ivcountlength = ivCountArr.length;*/
			
			
			int intakeLength=box.getInt("intakeOutputId1count");
			for (int i = 1; i <= intakeLength; i++) {
				
//				ptrlength != 0 || intakelength != 0 || orallength != 0 	|| ivlength != 0 || ivcountlength != 0

			if (box.getFloat(IV+i) != 0 || box.getFloat(ORAL+i) != 0 || box.getFloat("ryles"+i) != 0  || box.getFloat("total"+i) != 0) {

					IpdIntake ipdIntake = new IpdIntake();
					
					ipdIntake.setDate(HMSUtil
							.convertStringTypeDateToDateType(box.getString(INTAKE_DATE+i)));
					ipdIntake.setTime(box.getString(INTAKE_TIME+i));
					ipdIntake.setOral( box.getString(ORAL+i));
					ipdIntake.setIv(box.getString(IV+i));
					ipdIntake.setRemarks(box.getString(INTAKE_REMARKS+i));
					ipdIntake.setRyleTube(box.getString("ryles"+i));
					
					ipdIntake.setTotalIntake(box.getString("total"+i));
					/*try {
						ipdIntake.setIntake(intakeArr[i]);
					} catch (Exception e) {
						ipdIntake.setIntake("");
					}

					try {
						ipdIntake.setPtr(ptrArr[i]);
					} catch (Exception e) {
						ipdIntake.setOral("");
					}
					try {

						ipdIntake.setIvCount(ivCountArr[i]);
					} catch (Exception e) {
						ipdIntake.setIvCount("");
					}
					*/
					ipdIntake.setLastChgBy(users);
					ipdIntake.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdIntake.setLastChgTime(lastChgTime);
					
					ipdIntake.setIntakeoutput(ipdChart);
					hbt.save(ipdIntake);
					//ipdIntakeObjList.add(ipdIntake);
				}
			}
		
		// -----------------------------------------Output
		// Grid-------------------------------------------
		
		/*String outputArr[] = JKTRequestUtils.getStringParameters(request,
				OUTPUT_DATE);
		String bb[] = null;
		try {
			bb = JKTRequestUtils.getRequiredStringParameters(request,
					OUTPUT_DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int bbLegnt = bb.length;
		//
		
		  for (int i = 0; i < bbLegnt; i++) {
		  
		  SimpleDateFormat formatterIn = new SimpleDateFormat( "dd/MM/yyyy");
		  SimpleDateFormat formatterOut = new SimpleDateFormat( "yyyy-MM-dd");
		  
		  String date4MySQL = formatterOut.format(formatterIn.parse(bb[i]));
		  outputDate = java.sql.Date.valueOf(date4MySQL); outputDateArray[i] =
		  outputDate; }
		 String outputTimeArr[] = JKTRequestUtils.getStringParameters(
				request, OUTPUT_TIME);
		String[] urineArr = JKTRequestUtils.getStringParameters(request, URINE);
		String[] stoolArr = JKTRequestUtils.getStringParameters(request, STOOL);
		//
		String[] vomArr = JKTRequestUtils.getStringParameters(request, VOM);
		String[] aspArr = JKTRequestUtils.getStringParameters(request, ASP);
		String outputRemarksArr[] = JKTRequestUtils.getStringParameters(
				request, OUTPUT_REMARKS);
		String drainTimeArr[] = JKTRequestUtils.getStringParameters(request,
				DRAIN_TIME);
		String[] drainArr = JKTRequestUtils.getStringParameters(request, DRAIN);
		String girthTimeArr[] = JKTRequestUtils.getStringParameters(request,
				GIRTH_TIME);
		String[] girthArr = JKTRequestUtils.getStringParameters(request, GIRTH);
		String insulinTimeArr[] = JKTRequestUtils.getStringParameters(request,
				INSULIN_TIME);
		String[] insulinArr = JKTRequestUtils.getStringParameters(request,
				INSULIN);
		String bloodsugarTimeArr[] = JKTRequestUtils.getStringParameters(
				request, BLOOD_SUGAR_TIME);
		String[] bloodSugarArr = JKTRequestUtils.getStringParameters(request,
				BLOOD_SUGAR);
		String drainRemarksArr[] = JKTRequestUtils.getStringParameters(request,
				DRAIN_REMARKS);
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		int outputlength = outputArr.length;
		int urinelength = urineArr.length;
		int stoollength = stoolArr.length;
		int vomlength = vomArr.length;
		int asplength = aspArr.length;
		int drainlength = drainArr.length;
		int girthlength = girthArr.length;
		int insulinlength = insulinArr.length;
		int bloodsugarlength = bloodSugarArr.length;*/
		
		int outputCount=box.getInt("intakeOutput2Count");
		for (int i = 1; i <= outputCount; i++) {
			
			
		if (!box.getString("bleedingpvo"+i).equals("") ||!box.getString("urine"+i).equals("") || !box.getString("outputtotal"+i).equals("")
				||!box.getString("vom"+i).equals("") ||!box.getString("asp"+i).equals("") ||!box.getString(DRAIN+i).equals("") ) {

			

				IpdOutput ipdOutput = new IpdOutput();
				ipdOutput.setDate(HMSUtil
						.convertStringTypeDateToDateType(box.getString(OUTPUT_DATE+i)));
				ipdOutput.setTime(box.getString(OUTPUT_TIME+i));
				
				ipdOutput.setUrine(box.getString("urine"+i));
				//ipdOutput.setStool(box.getString("stool"+i));
				ipdOutput.setVom(box.getString("vom"+i));
				ipdOutput.setAsp(box.getString("asp"+i));
				ipdOutput.setDrainTime(box.getString(OUTPUT_TIME+i));
				ipdOutput.setDrain(box.getString(DRAIN+i));
				ipdOutput.setRemarks(box.getString(OUTPUT_REMARKS+i));
				ipdOutput.setBleedingPvo(box.getString("bleedingpvo"+i));
				ipdOutput.setTotalOutput(box.getString("outputtotal"+i));
				/*if (outputArr[i] != null) {
					try {
						ipdOutput.setOutput(outputArr[i]);
					} catch (Exception e) {
						ipdOutput.setOutput("");
					}
				}
				 

				try {
					ipdOutput.setDrainRemarks(drainRemarksArr[i]);
				} catch (Exception e) {
					ipdOutput.setDrainRemarks("");
				}*/

				
				ipdOutput.setLastChgBy(users);
				ipdOutput.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));
				ipdOutput.setLastChgTime(lastChgTime);
				
				ipdOutput.setIntakeoutput(ipdChart);
				hbt.save(ipdOutput);
//				ipdOutputObjList.add(ipdOutput);

			}
		}
		
		/*int intakeOutput3Count=box.getInt("intakeOutput3Count");
		for (int i = 1; i <= intakeOutput3Count; i++) {
			
			
		if (!box.getString(GIRTH+i).equals("")
				||!box.getString(BLOOD_SUGAR+i).equals("")
				||!box.getString(INSULIN+i).equals("")) {
			
			IpdOutput ipdOutput = new IpdOutput();
			ipdOutput.setDate(HMSUtil
					.convertStringTypeDateToDateType(box.getString("common2date"+i)));
			ipdOutput.setTime(box.getString(GIRTH_TIME+i));
			
			
			ipdOutput.setGirthTime(box.getString(GIRTH_TIME+i));
			ipdOutput.setGirth(box.getString(GIRTH+i));
			
			ipdOutput.setInsulinTime(box.getString(GIRTH_TIME+i));
			ipdOutput.setInsulin(box.getString(INSULIN+i));
			
			ipdOutput.setBloodSugarTime(box.getString(GIRTH_TIME+i));
			ipdOutput.setBloodSugar(box.getString(BLOOD_SUGAR+i));
			
			ipdOutput.setLastChgBy(users);
			ipdOutput.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(lastChgDate));
			ipdOutput.setLastChgTime(lastChgTime);
			
			ipdOutput.setIntakeoutput(ipdChart);
			hbt.save(ipdOutput);
			
		}
		}*/

		objMap.put("admissionNumber", adNo);
		objMap.put("ipdIntakeOutputChart", ipdChart);
		objMap.put("intakeoutput_id", ipdChart.getId());
		
//		if (ipdTemperatureObjList.size() > 0) {
//			objMap.put("ipdTemperatureObjList", ipdTemperatureObjList);
//		}
//		if (ipdIntakeObjList.size() > 0) {
//			objMap.put("ipdIntakeObjList", ipdIntakeObjList);
//		}
//		if (ipdOutputObjList.size() > 0) {
//			objMap.put("ipdOutputObjList", ipdOutputObjList);
//		}
		
		
		List ipdTemperatureObjList = new ArrayList();
		List ipdIntakeObjList = new ArrayList();
		List ipdOutputObjList = new ArrayList();
//		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();
//		String admissionNumber = (String) map.get("admissionNumber");
//
//		if (map.get("ipdTemperatureObjList") != null) {
//			ipdTemperatureObjList = (List) map.get("ipdTemperatureObjList");
//		}
//
//		if (map.get("ipdIntakeObjList") != null) {
//			ipdIntakeObjList = (List) map.get("ipdIntakeObjList");
//		}
//
//		if (map.get("ipdOutputObjList") != null) {
//			ipdOutputObjList = (List) map.get("ipdOutputObjList");
//		}
//
//		if (map.get("ipdIntakeOutputChart") != null) {
//			ipdIntakeOutputChart = (IpdIntakeOutputChart) map
//					.get("ipdIntakeOutputChart");
//		}

		/*int id = 0;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			List<IpdIntakeOutputChart> ipdIntakeOutputChartList = new ArrayList<IpdIntakeOutputChart>();
			ipdIntakeOutputChartList = hbt
					.find("from jkt.hms.masters.business.IpdIntakeOutputChart as inp where inp.AdNo = '"
							+ admissionNumber + "'");
			IpdIntakeOutputChart ipdChart = null;
			if (ipdIntakeOutputChartList.size() > 0) {
				ipdChart = (IpdIntakeOutputChart) hbt.load(
						IpdIntakeOutputChart.class, ipdIntakeOutputChartList
								.get(0).getId());
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				id = ipdChart.getId();
				ipdChart.setTreatment(ipdIntakeOutputChart.getTreatment());
				ipdChart.setDate(ipdIntakeOutputChart.getDate());
				ipdChart.setTime(ipdIntakeOutputChart.getTime());
				hbt.update(ipdChart);

			} else {
				hbt.setFlushModeName("FLUSH_AUTO");
				hbt.setCheckWriteOperations(false);
				hbt.save(ipdIntakeOutputChart);
				id = ipdIntakeOutputChart.getId();
			}

			if (ipdTemperatureObjList.size() > 0) {
				for (int i = 0; i < ipdTemperatureObjList.size(); i++) {
					IpdTemperature ipdTemperature = new IpdTemperature();
					ipdTemperature = (IpdTemperature) ipdTemperatureObjList
							.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart1 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart1.setId(id);
					ipdTemperature.setIntakeoutput(ipdIntakeOutputChart1);
					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdTemperature);
				}
			}

			if (ipdIntakeObjList.size() > 0) {
				for (int i = 0; i < ipdIntakeObjList.size(); i++) {
					IpdIntake ipdIntake = new IpdIntake();
					ipdIntake = (IpdIntake) ipdIntakeObjList.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart2 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart2.setId(id);
					ipdIntake.setIntakeoutput(ipdIntakeOutputChart2);
					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdIntake);
				}
			}
			if (ipdOutputObjList.size() > 0) {
				for (int i = 0; i < ipdOutputObjList.size(); i++) {
					IpdOutput ipdOutput = new IpdOutput();
					ipdOutput = (IpdOutput) ipdOutputObjList.get(i);
					IpdIntakeOutputChart ipdIntakeOutputChart3 = new IpdIntakeOutputChart();
					ipdIntakeOutputChart3.setId(id);
					ipdOutput.setIntakeoutput(ipdIntakeOutputChart3);
					hbt.setFlushModeName("FLUSH_AUTO");
					hbt.setCheckWriteOperations(false);
					hbt.save(ipdOutput);
				}
			}
			hbt.flush();
			hbt.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		hbt.flush();
		hbt.clear();
		successfullyAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			successfullyAdded = false;
		}
		objMap.put("successfullyAdded", successfullyAdded);
		return objMap;
	}

	// ---------------------------------IntakeOutputChartReport---------------------------------

	public Map<String, Object> showIntakeOutputChartReport(
			Map<String, Object> requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			hospitalList = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("Id", hospital_id)).list();
			Set<Patient> patientSet = (Set) hospitalList.get(0).getPatients();
			for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
				Patient patient = (Patient) iter.next();
				if (requestParameters.get(HIN_NO).toString()
						.equalsIgnoreCase(patient.getHinNo())) {
					Set<IpdIntakeOutput> intakeOutputSet = (Set) patient
							.getIpdIntakeOutputs();
					map.put("patientName",
							patient.getTitle() + " " + patient.getPFirstName()
									+ " " + patient.getPMiddleName() + " "
									+ patient.getPLastName());
					map.put("serviceNo", patient.getServiceNo());

					try {
						map.put("rank", patient.getRank().getRankName());
					} catch (Exception e) {
						map.put("rank", "-");
					}
					map.put("servicePersonName",
							patient.getTitle() + " " + patient.getSFirstName()
									+ " " + patient.getSMiddleName() + " "
									+ patient.getSLastName());
					try {
						map.put("unit", patient.getUnit().getUnitName());
					} catch (Exception e) {
						map.put("unit", "-");
					}

					Set<Inpatient> inpatientSet = (Set) patient.getInpatients();
					for (Iterator iterator = inpatientSet.iterator(); iterator
							.hasNext();) {
						Inpatient inpatient = (Inpatient) iterator.next();
						if (requestParameters.get(ADMISSION_NUMBER).toString()
								.equalsIgnoreCase(inpatient.getAdNo())) {
							if (inpatient.getDischargeDate() != null) {
								map.put("doa", inpatient.getDateOfAddmission()
										.toString());
							} else {
								map.put("doa", " ");
							}

							map.put("age", inpatient.getAge());
						}
					}
				} // end of if block (hinNo checking)
			} // end of patientSet iterator loop
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	// ------------------------------Method For Admission
	// Number---------------------------
	public Map<String, Object> getAdmissionNumberList(
			Map<String, Object> detailmap) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hinNo = "";
		if (detailmap.get("hinNo") != null) {
			hinNo = (String) detailmap.get("hinNo").toString().trim();
		}
		String department = null;
		boolean hinNoFound = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			Set<Inpatient> inpatientSet = null;
			List<Patient> patientList = null;
			hbt.setCheckWriteOperations(false);
			// int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			// hospitalList =
			// session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",
			// hospital_id)).list();
			// code added by shailesh
			// if (hospitalList != null && hospitalList.size() > 0)
			// patientSet = (Set)hospitalList.get(0).getPatients();
			// for (Iterator iter = patientSet.iterator(); iter.hasNext();)
			// {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
			if (patientList != null && patientList.size() > 0) {
				inpatientSet = patientList.get(0).getInpatients();
			}
			if (inpatientSet != null && inpatientSet.size() > 0) {

				hinNoFound = true;

				// Get the department/ward
				if (inpatientSet != null && inpatientSet.size() > 0) {
					for (Iterator iterator = inpatientSet.iterator(); iterator
							.hasNext();) {
						Inpatient inpatient = (Inpatient) iterator.next();
						try {
							department = inpatient.getDepartment()
									.getDepartmentName();
							break;
						} catch (Exception e) {
							department = "";
						}
					}
				}
				map.put("department", department);
				map.put("inpatientSet", inpatientSet);
			}
			// }

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinNoFound", hinNoFound);
		return map;
	}

	// ----------Food tasting Report------------------------------------------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showFoodTastingReportJsp(int hospitalId) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("DepartmentType.Id",10))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		
		map.put("con", con);
		return map;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> showNursingCareReportJsp(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int patientId = 0;
		String deptType = "";
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		if (dataMap.get("deptType") != null) {
			deptType = ("" + dataMap.get("deptType"));
		}
		if (dataMap.get("patientId") != null) {
			patientId = Integer.parseInt("" + dataMap.get("patientId"));
		}
		try {

			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "Y"))
					.createAlias("DepartmentType", "dpType")
					.add(Restrictions.eq("dpType.DepartmentTypeCode", "WARD"))
					.list();
			nursingCareList = session.createCriteria(MasNursingCare.class)
					.add(Restrictions.eq("Status", "Y")).list();
			if (patientId > 0) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("Id", patientId)).list();
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		java.sql.Connection con = session.connection();
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);
		map.put("nursingCareList", nursingCareList);
		map.put("con", con);
		return map;
	}

	// -------------------------Discharge
	// Slip-------------------------------------
	@SuppressWarnings("unchecked")
	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		String serviceNo = "";
		String hinNo = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		List<Object> inpatientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
								+ serviceNo + "'");
			}
			if (!hinNo.equals("")) {
				inpatientList = getHibernateTemplate().find(
						"from Inpatient ip join ip.Hin as p where p.HinNo = '"
								+ hinNo + "'");
			}
			// inpatientList =
			// session.createCriteria(Inpatient.class).createAlias("Hin",
			// "p").add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return inpatientList;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getHinNoList(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();
			// inpatientList =
			// session.createCriteria(Inpatient.class).createAlias("Hin",
			// "p").add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSearchPatientComboDetails(
			Map<String, Object> requestParameters) {
		List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masRankList = session.createCriteria(MasRank.class).list();
			masUnitList = session.createCriteria(MasUnit.class).list();
			masServiceTypeList = session.createCriteria(MasServiceType.class)
					.list();
			String queryString = null;
			queryString = "select inp from jkt.hms.masters.business.Patient as inp,jkt.hms.masters.business.Inpatient as inpatient where 1 = 1 ";

			if (requestParameters.get("deptId") != null
					&& requestParameters.get("deptId").toString().length() > 0) {
				queryString = queryString
						+ "and inp.Id = inpatient.Hin.Id and inpatient.Department.Id  = '"
						+ requestParameters.get("deptId") + "'";
			}
			if (requestParameters.get("adNo") != null
					&& requestParameters.get("adNo").toString().length() > 0) {
				queryString = queryString + "  and inpatient.AdNo = '"
						+ requestParameters.get("adNo") + "'";
			}
			if (requestParameters.get("serviceNo") != null
					&& requestParameters.get("serviceNo").toString().length() > 0) {
				queryString = queryString + " and inp.ServiceNo = '"
						+ requestParameters.get("serviceNo") + "'";
			}

			if (requestParameters.get("serviceType") != null
					&& requestParameters.get("serviceType").toString().length() > 0) {
				queryString = queryString
						+ " and inp.ServiceType.ServiceTypeCode = '"
						+ requestParameters.get("serviceType") + "'";
			}

			if (requestParameters.get("rank") != null
					&& requestParameters.get("rank").toString().length() > 0) {
				queryString = queryString + " and inp.Rank.RankCode= '"
						+ requestParameters.get("rank") + "'";
			}

			if (requestParameters.get("unit") != null
					&& requestParameters.get("unit").toString().length() > 0) {
				queryString = queryString + " and inp.Unit.Id = '"
						+ requestParameters.get("unit") + "'";
			}

			if (requestParameters.get("patientName") != null
					&& requestParameters.get("patientName").toString().length() > 0) {
				queryString = queryString + " and (inp.PFirstName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PMiddleName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PLastName like '%"
						+ requestParameters.get("patientName") + "%')";
			}

			if (requestParameters.get("servicePersonnelName") != null
					&& requestParameters.get("servicePersonnelName").toString()
							.length() > 0) {
				queryString = queryString + " and (inp.SFirstName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SMiddleName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SLastName like '%"
						+ requestParameters.get("servicePersonnelName") + "%')";
			}

			if (requestParameters.get("SearchFlag") != null
					&& requestParameters.get("SearchFlag").toString()
							.equals("true")) {
				patientList = hbt.find(queryString);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("masUnitList", masUnitList);
		map.put("masRankList", masRankList);
		map.put("patientList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String getMothersName(String motherHinNo) {
		List<Patient> list = new ArrayList<Patient>();
		String motherName = "";
		Session session = (Session) getSession();
		list = session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", motherHinNo)).list();
		if (list.size() > 0) {
			Patient patient = list.get(0);
			motherName = patient.getPFirstName() + " " + patient.getPLastName();
		}
		return motherName;
	}

	public List<Object> getHinNo(String serviceNo) {
		Session session = (Session) getSession();
		List<Object> patientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				patientList = session
						.createCriteria(Patient.class)
						.add(Restrictions.eq("ServiceNo", serviceNo))
						.add(Restrictions.not(Restrictions.eq("PatientStatus",
								"Expired"))).list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public Map getViewIntakeOutput(String radio_str) {
		Map map = new HashMap();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdIntakeOutputChart> ipdIntakeOutputList = new ArrayList<IpdIntakeOutputChart>();
		List<IpdTemperature> ipdTemperatures = new ArrayList<IpdTemperature>();
		Session session = (Session) getSession();
		inpatientList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Inpatient as ip where ip.AdNo = '"
						+ radio_str + "' order by ip.Id desc");
		ipdIntakeOutputList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.IpdIntakeOutputChart as md where md.AdNo = '"
						+ radio_str + "' order by md.Date desc");
		int intakeOutputid = 0;
		String query = "";
		query = "select intakeoutput_id from ipd_intake_output_chart where ad_no='"
				+ radio_str + "'";
		List intakeOutputList = new ArrayList();

		intakeOutputList = session.createSQLQuery(query).list();
		if (intakeOutputList != null && intakeOutputList.size() > 0) {
			intakeOutputid = (Integer) intakeOutputList.get(0);
			ipdTemperatures = session.createCriteria(IpdTemperature.class)
					.add(Restrictions.eq("Intakeoutput.Id", intakeOutputid))
					.list();
		}
		map.put("inPatientDetailList", inpatientList);
		map.put("ipdIntakeOutputList", ipdIntakeOutputList);
		map.put("ipdTemperatures", ipdTemperatures);
		return map;
	}

	// public Map<String, Object> getDBConnection() {
	// Map<String, Object> map = new HashMap<String, Object>();
	// Session session = (Session) getSession();
	// Connection conn = session.connection();
	// map.put("conn", conn);
	// return map;
	// }
	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemListForWardConsume(Map<String, Object> map) {
		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();

		Session session = (Session) getSession();
		int deptId = 0;
		int hospitalId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		hospitalId = Integer.parseInt("" + map.get("hospitalId"));
		try {
			String str ="%"+ map.get("autoHint") + "%";
			/*
			 * String qry= "SELECT DISTINCT BRAND_NAME,brand_id FROM
			 * mas_store_brand m, store_item_batch_stock s"+ "where m.brand_id =
			 * s.brand_id and m.brand_name like 'b%'and s.department_id =1 and
			 * s.closing_stock > 0";
			 */

			String query = "SELECT DISTINCT (sib.Item.Nomenclature) ,sib.Item.Id  from  StoreItemBatchStock as sib where sib.ClosingStock>0 and sib.Department.Id="
					+ deptId
					/*
					 * + "and sib.Hospital.Id=" + hospitalId
					 */
					+ " and sib.Hospital.Id = "
					+ hospitalId
					+ " and  sib.Item.Nomenclature like "
					+ "UPPER('"
					+ str
					+ "')";

			// and sib.Item.DangerousDrug is null and sib.Item.ControlledDrug is
			// null
			// String query= "SELECT DISTINCT (sib.Brand.BrandName),sib.Brand.Id
			// from StoreItemBatchStock as sib where
			// sib.Department.Id="+deptId+" and sib.Brand.BrandName like
			// '"+str+"'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			// Criteria c = session.createCriteria(
			// StoreItemBatchStock.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
			// .createAlias("Brand", "brand")
			// .add(Restrictions.like("brand.BrandName",str));
			// .createAlias("Department", "dept")
			// .add(Restrictions.eq("dept.Id", deptId));
			//
			// c.setFirstResult(0);
			// c.setMaxResults(10);
			// itemList = c.list();

			/*
			 * Iterator itr = itemList.iterator(); while (itr.hasNext()) {
			 * Object[] pair = (Object[]) itr.next(); String brandName =
			 * (String) pair[0]; String itemId = (String) pair[1];
			 */
			/*
			 * StoreItemBatchStock stockbatch = (StoreItemBatchStock)
			 * itr.next(); String
			 * brandName=(String)stockbatch.getItem().getNomenclature();
			 */
			// }

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public Map<String, Object> showDutyNursingReportJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		String deptType = "";
		if (map.get("deptType") != null) {
			deptType = ("" + map.get("deptType"));
		}
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dpType")
					.add(Restrictions.eq("dpType.DepartmentTypeCode", "WARD"))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		map.put("con", con);
		return map;
	}

	public Map<String, Object> getDBConnection() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public Map<String, Object> getDiagnosisAndDocumentInit(
			Map<String, Object> dataMap) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
		int inpatientId = Integer.parseInt("" + dataMap.get("inpatientId"));
		int hospitalId = 0;
		if (dataMap.get(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + dataMap.get(HOSPITAL_ID));
		}
		Session session = (Session) getSession();
		Connection conn = session.connection();
		dischargeIcdCodeList = (List<DischargeIcdCode>) session
				.createCriteria(DischargeIcdCode.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("DiagnosisStatus", "f")).list();

		inpatientDocumentList = (List<InpatientDocument>) session
				.createCriteria(InpatientDocument.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

		detailsMap.put("inpatientDocumentList", inpatientDocumentList);
		detailsMap.put("dischargeIcdCodeList", dischargeIcdCodeList);
		detailsMap.put("conn", conn);
		return detailsMap;
	}

	public Map<String, Object> getICDCodeList(Map<String, Object> map) {
		List<MasIcd> itemList = new ArrayList<MasIcd>();
		Session session = (Session) getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + map.get("deptId"));
		try {
			String str = "%" + map.get("autoHint") + "%";
			String query = "from MasIcd as icd where icd.IcdCode like '" + str
					+ "'";
			Query q = session.createQuery(query);
			q.setFirstResult(0);
			q.setMaxResults(10);
			itemList = q.list();
			Iterator itr = itemList.iterator();
			while (itr.hasNext()) {
				MasIcd MasIcd = (MasIcd) itr.next();
				String icdName = (String) MasIcd.getIcdName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);
		return map;

	}

	public Map<String, Object> showWaitingList(Map<String, Object> dataMap) {

		Session session = (Session) getSession();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		String takeSetFromSessionInJsp = "";
		String deptName = "";
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		try {
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			inPatientSet = session.createQuery(
					"select ip from Inpatient as ip where ip.AdStatus='W' and ip.Department.Id="
							+ deptId + "order by (DateOfAddmission)desc")
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		if (deptList.size() > 0) {
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			deptName = masDepartment.getDepartmentName();
			takeSetFromSessionInJsp = "false";
		}
		Iterator itr = inPatientSet.iterator();
		while (itr.hasNext()) {
			Inpatient inPatient = (Inpatient) itr.next();
			String dateOfAdmissionInString = HMSUtil
					.changeDateToddMMyyyy(inPatient.getDateOfAddmission());
		}

		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("inpatientSet", inPatientSet);
		map.put("deptName", deptName);

		return map;

	}

	public Map<String, Object> submitWaitingList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Box box = (Box) dataMap.get("box");
		Vector waitingId = box.getVector("parent");
		Transaction transaction = null;
		String saved = "no";
		try {
			transaction = session.beginTransaction();
			for (int i = 0; i < waitingId.size(); i++) {
				String qry = "update inpatient as ip set ip.ad_status='A' where inpatient_id='"
						+ Integer.parseInt(waitingId.get(i).toString()) + "' ";
				Query query2 = session.createSQLQuery(qry);
				int row2 = query2.executeUpdate();
			}
			transaction.commit();
			saved = "yes";
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			;
		}
		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> getWardRemarksDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<WardRemarks> wardRemarksList = new ArrayList<WardRemarks>();
		String remarksDate = "";
		int deptId = 0;

		try {
			if (dataMap.get("remarksDate") != null) {
				remarksDate = "" + dataMap.get("remarksDate");
			}
			if (dataMap.get("deptId") != null) {
				deptId = (Integer) dataMap.get("deptId");
			}
			int inpatientId = 0;
			if (dataMap.get("inpatientId") != null) {
				inpatientId = (Integer) dataMap.get("inpatientId");
			}

			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2
					.parse(remarksDate));
			org.hibernate.Session session = getSession();
			if (inpatientId != 0) {
				wardRemarksList = (List<WardRemarks>) session
						.createCriteria(WardRemarks.class)
						.add(Restrictions.eq("RemarksDate",
								java.sql.Date.valueOf("" + date4MySQL2)))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Inpatient.Id", inpatientId))
						.list();
			} else {
				wardRemarksList = (List<WardRemarks>) session
						.createCriteria(WardRemarks.class)
						.add(Restrictions.eq("RemarksDate",
								java.sql.Date.valueOf("" + date4MySQL2)))
						.add(Restrictions.eq("Department.Id", deptId))
						// .add(Restrictions.eq("Inpatient.Id", inpatientId))
						.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		// map.put("inpatientList", inpatientList);
		map.put("wardRemarksList", wardRemarksList);
		return map;
	}

	public Map<String, Object> saveWardRemarks(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		int departmentId = 0;
		int hospitalId = 0;
		int userId = 0;
		String date = "";
		String lastChgBy = "";
		String currentTime = "";
		String saved = "no";
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		currentTime = (String) utilMap.get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int inpatientId = 0;
		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (box.get("deptId") != null) {
			departmentId = Integer.parseInt("" + box.get("deptId"));
		}
		if (box.get(USER_ID) != null) {
			userId = Integer.parseInt("" + box.get(USER_ID));
		}
		if (box.get(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + box.get(HOSPITAL_ID));
		}
		if (box.get("inpatientId") != null
				&& !box.get("inpatientId").equals("0")) {
			inpatientId = Integer.parseInt(box.get("inpatientId"));
		}
		try {
			WardRemarks wardRemarks = new WardRemarks();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(""
					+ box.get(DATE)));
			wardRemarks.setRemarksDate(java.sql.Date.valueOf(date4MySQL));
			wardRemarks.setRemarksTime("" + box.get(TIME));
			wardRemarks.setRemarks("" + box.get(REMARKS));

			Inpatient inp = new Inpatient();
			inp.setId(inpatientId);
			wardRemarks.setInpatient(inp);
			if (departmentId != 0) {
				wardRemarks.setDepartment(new MasDepartment(departmentId));
			}
			Users users = new Users();
			users.setId(userId);
			wardRemarks.setLastChgBy(users);

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalId);
			wardRemarks.setHospital(hospital);

			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2.parse(date));
			wardRemarks.setLastChgDate(java.sql.Date.valueOf(date4MySQL2));
			wardRemarks.setLastChgTime(currentTime);
			hbt.save(wardRemarks);
			saved = "yes";
		} catch (Exception e) {
			e.printStackTrace();
		}
		org.hibernate.Session session = getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class).list();
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		map.put("masDepartmentList", departmentList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String, Object> getIpIdFormDischargeId(
			Map<String, Object> tempMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dischargeId = 0;
		int hospitalId = 0;
		if (tempMap.get("dischargeId") != null) {
			dischargeId = Integer.parseInt("" + tempMap.get("dischargeId"));
		}
		if (tempMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + tempMap.get("hospitalId"));
		}
		int inpatientId = 0;
		org.hibernate.Session session = getSession();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		try {
			dischargeList = session.createCriteria(Discharge.class)
					.add(Restrictions.eq("Id", dischargeId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			String adNo = "";
			for (Discharge discharge : dischargeList) {
				adNo = discharge.getAdNo();
			}

			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("AdNo", adNo))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			for (Inpatient inpatient : inpatientList) {
				inpatientId = Integer.parseInt("" + inpatient.getId());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		map.put("inpatientId", inpatientId);

		return map;
	}

	public int getInpatientId(String adNo, String hinNo) {
		List<Integer> inpatientIdList = new ArrayList<Integer>();
		int inpatientId = 0;
		Session session = (Session) getSession();
		try {
			inpatientIdList = session.createCriteria(Inpatient.class)
					//Added by Arbind on 03-03-2018
					.createAlias("Hin", "p")
					.add(Restrictions.eq("AdNo", adNo))
					.add(Restrictions.eq("p.HinNo", hinNo))
					.setProjection(Projections.property("Id")).list();
			if (inpatientIdList.size() > 0) {
				inpatientId = inpatientIdList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		return inpatientId;
	}

	public Map<String, Object> showDischargeStatusWiseReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasDischargeStatus> dischargeStatusList = new ArrayList<MasDischargeStatus>();
		Session session = (Session) getSession();
		String deptType = "";
		if (map.get("deptType") != null) {
			deptType = ("" + map.get("deptType"));
		}
		try {
			dischargeStatusList = session
					.createCriteria(MasDischargeStatus.class)
					.add(Restrictions.eq("Status", "y")).list();
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "Y"))
					.createAlias("DepartmentType", "dpType")
					.add(Restrictions.eq("dpType.DepartmentTypeCode", "WARD"))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("dischargeStatusList", dischargeStatusList);
		return map;
	}

	public Map<String, Object> getDoctorList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		doctorList = session.createCriteria(MasEmployee.class)
				.createAlias("EmpCategory", "ec")
				.add(Restrictions.eq("ec.EmpCategoryName", "Doctor")).list();
		map.put("doctorList", doctorList);
		return map;
	}

	public boolean saveMessageForDoctors(Box box) {
		boolean flag = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		/*
		 * try { Smsout smsout = new Smsout();
		 * smsout.setMessage(box.getString("message"));
		 * smsout.setMobileNo(box.getString("mobileNo"));
		 * if(box.getString("msgType").equals("ip")){ smsout.setRemarks("IPD");
		 * }else if(box.getString("msgType").equals("op")){
		 * smsout.setRemarks("OPD"); } smsout.setStatus("U"); hbt.save(smsout);
		 * flag = true; } catch (Exception e) { e.printStackTrace(); }
		 */
		return flag;
	}

	@Override
	public Map<String, Object> showHandTakeJsp(Map<String, Object> map) {
		Session session = (Session) getSession();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> employeeListDoctor = new ArrayList<MasEmployee>();
		List<EmpScMapping> empScMappingList = new ArrayList<EmpScMapping>();
//		List<MasEmployee> employeeLoginList = new ArrayList<MasEmployee>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
		List<Object[]> doctorList = new ArrayList<Object[]>();
		int deptId = 0;
		int userId = 0;
		int inpatientId=0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		if (map.get("userId") != null) {
			userId = (Integer) map.get("userId");
		}
		if (map.get(INPATIENT_ID) != null) {
			inpatientId = (Integer) map.get(INPATIENT_ID);
		}
		
		
		String emp_code_doctor = null;
		String mas_department_type_ward=null;
		String mmMasRequestStatusPending=null;
		String	mmMasRequestStatusApproved=null;
		String	mmMasRequestStatusReject=null;
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			emp_code_doctor = prop.getProperty("mas_emp_category_doctor");
			mas_department_type_ward=prop.getProperty("mas_department_type_ward");
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			mmMasRequestStatusPending=prop1.getProperty("mmMasRequestStatusPending");
			mmMasRequestStatusApproved=prop1.getProperty("mmMasRequestStatusApproved");
			mmMasRequestStatusReject=prop1.getProperty("mmMasRequestStatusReject");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Inpatient inpatient=(Inpatient) session.load(Inpatient.class, inpatientId);
		
		int hospitalid = (Integer) map.get(HOSPITAL_ID);
		/*employeeLoginList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "Y"))
				.add(Restrictions.eq("Hospital.Id", hospitalid))
				.add(Restrictions.eq("EmpCategory.Id", 2))
				.addOrder(Order.asc("FirstName")).list();*/
		
		departmentList = session
				.createCriteria(MasInstituteDepartment.class,"msd")
				.createAlias("msd.Department", "md")
				.createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh")
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", hospitalid))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
		
		 
		empScMappingList = session.createCriteria(EmpScMapping.class)
				.createAlias("Employee", "employee")
				.createAlias("employee.Hospital", "h")
				.createAlias("employee.EmpCategory", "ecat")
				//.createAlias("Department", "d")
				.add(Restrictions.eq("employee.Status", "y").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.eq("ecat.EmpCategoryCode", emp_code_doctor.trim()))
				/*.add(Restrictions.or(Restrictions.like("ServiceCentreId", "%,"+deptId+",%"), 
						Restrictions.or(Restrictions.like("ServiceCentreId", "%"+deptId+",%"),
								Restrictions.like("ServiceCentreId", "%,"+deptId+"%"))) )*/
//				.setProjection(Projections.projectionList().add(Projections.groupProperty("Employee")))
				/*.addOrder(Order.asc("employee.EmployeeName"))*/
				.list();
		for (EmpScMapping empScMapping : empScMappingList) {
			Object[] array=new Object[3];
			array[0]=empScMapping.getEmployee().getId();
			array[1]=empScMapping.getEmployee().getEmployeeName();
			array[2]=empScMapping.getDepartment().getId();
			doctorList.add(array);
		}
		logger.info(emp_code_doctor+"emp_code_doctor====hospitalid==="+hospitalid);
		employeeList=session.createCriteria(EmpScMapping.class)
		.createAlias("Employee", "employee")
		.createAlias("employee.Hospital", "h")
		.createAlias("employee.EmpCategory", "ecat")
		//.createAlias("Department", "d")
		.add(Restrictions.eq("employee.Status", "y").ignoreCase())
		.add(Restrictions.eq("h.Id", hospitalid))
		.add(Restrictions.eq("ecat.EmpCategoryCode", emp_code_doctor.trim()))
		//.add(Restrictions.or(Restrictions.like("ServiceCentreId", "%,"+deptId+",%"), 
				//Restrictions.or(Restrictions.like("ServiceCentreId", "%"+deptId+",%"),
						//Restrictions.like("ServiceCentreId", "%,"+deptId+"%"))) )
		.setProjection(Projections.projectionList().add(Projections.groupProperty("Employee")))
		//.addOrder(Order.asc("employee.EmployeeName"))*/
		.list();

		/*employeeList = session.createCriteria(MasEmployee.class)
				.createAlias("Hospital", "h")
				.createAlias("Department", "d")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.eq("d.Id", deptId))
				.addOrder(Order.asc("FirstName")).list();*/
		
		ipdHandTakeOverList = session.createCriteria(IpdHandTakeOver.class)
				.createAlias("Hospital", "h")
				.createAlias("RequestStatus", "rs")
				.createAlias("FromDepartment", "d")
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.in("rs.StatusCode", new String[]{mmMasRequestStatusPending,mmMasRequestStatusReject}))
				.add(Restrictions.eq("d.Id", deptId))
				.list();

		map.put("employeeList", employeeList);
		map.put("departmentList", departmentList);
		map.put("inpatient", inpatient);
		map.put("employeeListDoctor", employeeListDoctor);
		map.put("ipdHandTakeOverList", ipdHandTakeOverList);
		map.put("doctorList", doctorList);
		return map;
	}

	@Override
	public String getEntrySeqForDisplay(String string) {
		List<Integer> entrySeqNoList = new ArrayList<Integer>();
		List<IpdHandTakeOver> seqNoList = new ArrayList<IpdHandTakeOver>();
		String entrySeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			seqNoList = session.createCriteria(IpdHandTakeOver.class).list();
			if (seqNoList.size() > 0) {
				for (IpdHandTakeOver ipdHandTakeOver : seqNoList) {
					lastSeqNo = ipdHandTakeOver.getEntryNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}

			entrySeqNoList = session
					.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "HEN"))
					.setProjection(
							Projections.projectionList().add(
									Projections
											.max("TransactionSequenceNumber")))
					.list();
			if (entrySeqNoList.get(0) == null || entrySeqNoList.size() == 0) {
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("IpdHandTakeOver");
				tsObj.setTransactionPrefix("HEN");
				tsObj.setTransactionSequenceName("Entry No");
				tsObj.setTransactionSequenceNumber(0);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				hbt.save(tsObj);
				entrySeqNo = String.valueOf(1);
			} else if (entrySeqNoList.size() > 0) {
				for (Integer maxOrderNo : entrySeqNoList) {
					if (currentYear.equals(lastSeqYear)) {
						entrySeqNo = String.valueOf(maxOrderNo + 1);
					} else {
						entrySeqNo = String.valueOf(1);
						lastSeqYear = currentYear;
					}
				}
			}
			entrySeqNo = entrySeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return entrySeqNo;
	}

	@Override
	public String generateEntryNumber() {
		Map<String, Object> map = new HashMap<String, Object>();
		String orderSeqNo = "";
		List<TransactionSequence> entrySeqNoList = new ArrayList<TransactionSequence>();
		List<IpdHandTakeOver> seqNoList = new ArrayList<IpdHandTakeOver>();
		String lastSeqNo = "";
		String lastSeqYear = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();
		seqNoList = session.createCriteria(IpdHandTakeOver.class).list();
		if (seqNoList.size() > 0) {
			for (IpdHandTakeOver ipdHandTakeOver : seqNoList) {
				lastSeqNo = ipdHandTakeOver.getEntryNo();
			}
			StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
			while (str.hasMoreTokens()) {
				lastSeqYear = str.nextToken();

			}
		} else if (lastSeqYear.equals("")) {
			lastSeqYear = currentYear;
		}
		entrySeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "HEN")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (entrySeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : entrySeqNoList) {
				TransactionSequence obj = (TransactionSequence) entrySeqNoList
						.get(0);
				int id = obj.getId();
				Integer seqNo = 0;

				if (currentYear.equals(lastSeqYear)) {
					seqNo = obj.getTransactionSequenceNumber();
				} else {
					seqNo = 0;
					lastSeqYear = currentYear;
				}
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(seqNo + 1);
				++seqNo;
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				orderSeqNo = seqNo.toString().concat("/")
						.concat(String.valueOf(lastSeqYear));
			}
		} else if (entrySeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("IpdHandTakeOver");
			tsObj.setTransactionPrefix("HEN");
			tsObj.setTransactionSequenceName("Entry No");
			tsObj.setTransactionSequenceNumber(0);
			tsObj.setCreatedby("admin");
			hbt.save(tsObj);
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		}

		return orderSeqNo;
	}

	@Override
	public boolean submitHandTakeOver(Box box) {
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		Session session=(Session)getSession();
		
		
		String mmMasRequestStatusPending=null;
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mmMasRequestStatusPending=prop.getProperty("mmMasRequestStatusPending");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		
		String entrySeqNo = "";
		int hospitalId = 0;
		String date = "";
		date = (String) utilMap.get("currentDate");
		Date currentDate = new Date();
		
		IpdHandTakeOver ipdHandTakeOver = new IpdHandTakeOver();

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt(HOSPITAL_ID));
			ipdHandTakeOver.setHospital(masHospital);
		
			logger.info("taken by id == "+box.getInt(INPATIENT_ID));
		Inpatient inpatient=new Inpatient();
		inpatient.setId(box.getInt(INPATIENT_ID));
		ipdHandTakeOver.setInpatient(inpatient);
		
		Patient patient=new Patient();
		patient.setId(box.getInt(HIN_ID));
		ipdHandTakeOver.setHin(patient);
		
		ipdHandTakeOver.setWardBedTransferRequired("n");
		
		
		ipdHandTakeOver.setEntryDate(HMSUtil.dateFormatterDDMMYYYY(box.getString(TRANSFER_DATE)));
		ipdHandTakeOver.setEntryTime(box.getString(TRANSFER_TIME));
		int fromDepartmentId=box.getInt(FROM_WARD);
		MasDepartment fromDepartment = new MasDepartment();
		fromDepartment.setId(fromDepartmentId);
		ipdHandTakeOver.setFromDepartment(fromDepartment);
		
		int handById= box.getInt("fromDoctor");
		MasEmployee handBy=new MasEmployee();
		handBy.setId(handById);
		ipdHandTakeOver.setHandBy(handBy);
		
		int toDepartmentId=box.getInt(TO_WARD);
		MasDepartment toDepartment = new MasDepartment();
		toDepartment.setId(toDepartmentId);
		ipdHandTakeOver.setDepartment(toDepartment);
		
		int takeById= box.getInt("doctorId");
		MasEmployee takeBy=new MasEmployee();
		takeBy.setId(takeById);
		ipdHandTakeOver.setTakeBy(takeBy);
		
		
		int departmentId = box.getInt(TO_WARD);
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdHandTakeOver.setDepartment(masDepartment);
		
		
		int authorisedById= box.getInt(AUTHORIZER_ID);
		MasEmployee authorisedBy=new MasEmployee();
		authorisedBy.setId(authorisedById);
		ipdHandTakeOver.setAuthorisedBy(authorisedBy);

		entrySeqNo = generateEntryNumber();
		ipdHandTakeOver.setEntryNo(entrySeqNo);
		
		ipdHandTakeOver.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		ipdHandTakeOver.setLastChgTime((String)utilMap.get("currentTime"));
		Users users=new Users();
		users.setId(box.getInt(USER_ID));
		ipdHandTakeOver.setLastChgBy(users);
		
		MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("StatusCode", mmMasRequestStatusPending).ignoreCase()).uniqueResult();
		
		ipdHandTakeOver.setRequestStatus(masRequestStatus);
		
		
		hbt.save(ipdHandTakeOver);
		hbt.flush();
		hbt.clear();
		saved = true;
		return saved;
	}

	@Override
	public Map<String, Object> showHandTakeOverReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("DepartmentType", "dpType")
					.add(Restrictions.eq("dpType.DepartmentTypeCode", "Ward"))
					.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		return map;
	}

	public Map<String, Object> viewHandTakeOver(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdHandTakeOver> ipdHandTakeList = new ArrayList<IpdHandTakeOver>();
		int hospitalId = (Integer) infoMap.get(HOSPITAL_ID);
		int deptId = (Integer) infoMap.get(DEPT_ID);
		Date dateTo = (Date) infoMap.get("toDate");
		Session session = (Session) getSession();
		ipdHandTakeList = session.createCriteria(IpdHandTakeOver.class, "ipd")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("EntryDate", dateTo)).list();
		map.put("ipdHandTakeList", ipdHandTakeList);
		return map;
	}

	public Map<String, Object> showPrescriptionJsp(Map<String, Object> map) {

		Session session = (Session) getSession();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasStoreBrand> storeBrandList = new ArrayList<MasStoreBrand>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		/*
		 * Added By Ujjwal For Not to prescribe same medicine twice a day on
		 * date 28-09-2012
		 */
		// List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		int hinId = 0;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		int deptId = Integer.parseInt(map.get("deptId").toString());
		int inPatient = Integer.parseInt(map.get("inPatient").toString());
		inPatientDetailList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inPatient)).list();
		for (Inpatient inp : inPatientDetailList) {
			hinId = inp.getHin().getId();
		}
		List<InpatientPrescriptionDetails> inPatientPrescriptionDetailList = new ArrayList<InpatientPrescriptionDetails>();
		inPatientPrescriptionDetailList = session
				.createCriteria(InpatientPrescriptionDetails.class)
				.createAlias("Prescription", "pres")
				.add(Restrictions.eq("pres.PrescriptionDate",
						HMSUtil.convertStringTypeDateToDateType(date)))
				.add(Restrictions.eq("pres.Hin.Id", hinId)).list();
		frequencyList = session.createCriteria(MasFrequency.class)
				.add(Restrictions.eq("Status", "Y")).list();
		storeBrandList = session.createCriteria(MasStoreBrand.class)
				.add(Restrictions.eq("Status", "Y")).list();
		map.put("frequencyList", frequencyList);
		map.put("storeBrandList", storeBrandList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("inPatientPrescriptionDetailList",
				inPatientPrescriptionDetailList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<MasStoreItem> getItemIdFromPVMS(String pvmsNo) {
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

	public Map<String, Object> submitPrescriptionDetails(Map<String, Object> map) {
		Session session = (Session) getSession();
		List pvmsNoList = (List) map.get("pvmsNoList");
		List<String> manufacturerList = (List) map.get("manufacturerList");
		List<String> manufacturerIdList = (List) map.get("manufacturerIdList");
		List<String> brandIdList = (List) map.get("brandIdList");

		List<Integer> frequencyList = (List) map.get("frequencyList");
		List<String> dosageList = (List) map.get("dosageList");
		List<Integer> totalList = (List) map.get("totalList");
		List<Integer> noOfDaysList = (List) map.get("noOfDaysList");
		@SuppressWarnings("unused")
		List manufacturer = (List) map.get("manufacturer");
		String prescriptionNo = "";
		List<BigDecimal> rateList = new ArrayList<BigDecimal>();
		if (map.get("rateList") != null) {
			rateList = (List) map.get("rateList");
		}
		int deptId = 0;
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		int hospitalId = 0;
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		int hinId = 0;
		if (map.get("hinId") != null) {
			hinId = (Integer) map.get("hinId");
		}
		int inpatientId = 0;
		if (map.get("inpatientId") != null) {
			inpatientId = (Integer) map.get("inpatientId");
		}
		String hinNo = "";
		if (map.get("hinNo") != null) {
			hinNo = (String) (map.get("hinNo"));
		}
		String lastChgDate = "";
		if (map.get("lastChgDate") != null) {
			lastChgDate = (String) map.get("lastChgDate");
		}
		String lastChgTime = "";
		if (map.get("lastChgTime") != null) {
			lastChgTime = (String) map.get("lastChgTime");
		}

		String lastChgBy = "";
		if (map.get("lastChgBy") != null) {
			lastChgBy = (String) map.get("lastChgBy");
		}
		List<Integer> itemIdList = new ArrayList<Integer>();
		prescriptionNo = (String) map.get("prescriptionNo");
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			InpatientPrescriptionHeader inPatientPrescriptionHeader = new InpatientPrescriptionHeader();
			if (pvmsNoList.size() > 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				inPatientPrescriptionHeader.setHin(patient);
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				inPatientPrescriptionHeader.setDepartment(masDepartment);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				inPatientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
				inPatientPrescriptionHeader.setInpatient(inpatient);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				inPatientPrescriptionHeader.setHospital(masHospital);
				inPatientPrescriptionHeader.setStatus("p");
				inPatientPrescriptionHeader.setPrescriptionDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));
				inPatientPrescriptionHeader.setPrescriptionTime(lastChgTime);
				hbt.save(inPatientPrescriptionHeader);
			}

			for (int i = 0; i < pvmsNoList.size(); i++) {
				String pvmsNo = (String) pvmsNoList.get(i);
				List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();

				itemIdListNew = getItemIdFromPVMS(pvmsNo);
				for (int k = 0; k < itemIdListNew.size(); k++) {
					itemIdList.add(itemIdListNew.get(k).getId());
				}
			}
			
			
			for (int i = 0; i < itemIdList.size(); i++) {
				InpatientPrescriptionDetails inPatientPrescriptionDetails = new InpatientPrescriptionDetails();
				MasStoreItem masStoreItem = new MasStoreItem();
				MasStoreBrand brand = new MasStoreBrand();
				MasManufacturer manufacturer2 = new MasManufacturer();

				MasFrequency masFrequency = new MasFrequency();
				masStoreItem.setId(itemIdList.get(i));
				inPatientPrescriptionDetails.setItem(masStoreItem);

				masFrequency.setId(frequencyList.get(i));
				inPatientPrescriptionDetails.setFrequency(masFrequency);
				//inPatientPrescriptionDetails.setDosage(dosageList.get(i));
				inPatientPrescriptionDetails.setNoOfDays(noOfDaysList.get(i));
				inPatientPrescriptionDetails
						.setPrescription(inPatientPrescriptionHeader);

				if (manufacturerIdList.get(i) == null
						|| manufacturerIdList.get(i).equals("")) {
					manufacturer2.setId(1);
				} else {
					manufacturer2.setId(Integer.parseInt(manufacturerIdList
							.get(i)));
				}
				inPatientPrescriptionDetails.setManufacturer(manufacturer2);
				if (brandIdList.get(i) == "") {
					brand.setId(1);
				} else {
					brand.setId(Integer.parseInt(brandIdList.get(i)));
				}
				//inPatientPrescriptionDetails.setBrand(brand);
				inPatientPrescriptionDetails.setType("IP");
				//inPatientPrescriptionDetails.setTotal(totalList.get(i));
				
				hbt.save(inPatientPrescriptionDetails);
			}
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} 
		// finally{
		/**
		 * session.close() is done By Ramdular Prajapati Date 12 May 2010
		 */
		/*
		 * if(session!=null){ session.close(); } }
		 */
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showInPatientPreviousPrescription(Map mapForDS) {

		Session session = (Session) getSession();
		List<Inpatient> patientInpatientList = new ArrayList<Inpatient>();
		List<InpatientPrescriptionHeader> patientPrescriptionHeaderList = new ArrayList<InpatientPrescriptionHeader>();
		List<InpatientPrescriptionDetails> patientPrescriptionList = new ArrayList<InpatientPrescriptionDetails>();
		List<BigDecimal> storeItemBatch = new ArrayList<BigDecimal>();
		List<BigDecimal> storeItemBatch1 = new ArrayList<BigDecimal>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		@SuppressWarnings("unused")
		int ipdNo = (Integer) mapForDS.get("ipdNo");
		int hinId = (Integer) mapForDS.get("hinId");
		int inpatientId = (Integer) mapForDS.get("inpatientId");
		int deptId = (Integer) mapForDS.get("deptId");
		int storeType = 0;

		try {
			patientPrescriptionHeaderList = session
					.createCriteria(InpatientPrescriptionHeader.class)
					.createAlias("Inpatient", "inpatient")
					.createAlias("Department", "dept")
					// .add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hin.Id", hinId))
					.addOrder(Order.desc("PrescriptionDate"))
					.addOrder(Order.desc("PrescriptionTime")).list();
			if (patientPrescriptionHeaderList.size() > 0) {
				List<Integer> presIdList = new ArrayList<Integer>();
				List<Integer> itemIdList = new ArrayList<Integer>();
				for (InpatientPrescriptionHeader patientPrescriptionHeader : patientPrescriptionHeaderList) {
					presIdList.add(patientPrescriptionHeader.getId());
				}
				patientPrescriptionList = session
						.createCriteria(InpatientPrescriptionDetails.class)
						.createAlias("Prescription", "prescription")
						.add(Restrictions.in("prescription.Id", presIdList))
						.addOrder(Order.desc("prescription.PrescriptionDate"))
						.addOrder(Order.desc("prescription.PrescriptionTime"))
						.list();

				departmentList = session
						.createCriteria(MasDepartment.class, "md")
						.add(Restrictions.eq("md.Status", "Y"))
						.add(Restrictions.eq("md.Id", deptId)).list();

				// departmentList = getHibernateTemplate()
				// .find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'y' and md.Id="
				// + deptId);
				for (MasDepartment masDepartment123 : departmentList) {
					storeType = masDepartment123.getStoreType().getId();
				}

				if (patientPrescriptionList.size() > 0) {
					for (int i = 0; i < patientPrescriptionList.size(); i++) {
						InpatientPrescriptionDetails patientPrescriptionDetail = (InpatientPrescriptionDetails) patientPrescriptionList
								.get(i);
						int itemId = (Integer) patientPrescriptionDetail
								.getItem().getId();
						Criteria critt = session
								.createCriteria(StoreItemBatchStock.class)
								.createAlias("Item", "item")
								.add(Restrictions.eq("item.Id", itemId))
								.createAlias("Department", "department")
								.add(Restrictions
										.eq("department.Id", storeType));
						critt.setProjection(Projections.sum("ClosingStock"));
						storeItemBatch1 = critt.list();
						storeItemBatch.addAll(storeItemBatch1);
					}
				}

				/*
				 * for(InpatientPrescriptionDetails patientPrescriptionDetails:
				 * patientPrescriptionList){
				 * itemIdList.add(patientPrescriptionDetails.getItem().getId());
				 * } Criteria crit=null; crit =
				 * session.createCriteria(StoreItemBatchStock.class)
				 * .createAlias("Item", "item") .add(Restrictions.in("item.Id",
				 * itemIdList)) .createAlias("Department", "dept")
				 * .add(Restrictions.eq("dept.Id", 24)); ProjectionList
				 * projectionList = Projections.projectionList();
				 * projectionList.add(Projections.property("ClosingStock"));
				 * projectionList.add(Projections.property("item.Id"));
				 * projectionList.add(Projections.groupProperty("item.Id"));
				 * projectionList
				 * .add(Projections.groupProperty("ClosingStock"));
				 * crit.setProjection(projectionList); itemList= crit.list();
				 */

				frequencyList = session.createCriteria(MasFrequency.class)
						.list();

			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("storeItemBatch", storeItemBatch);
		map.put("patientPrescriptionList", patientPrescriptionList);
		map.put("frequencyList", frequencyList);

		return map;
	}

	public Map<String, Object> getItemStock(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> stockItemList = new ArrayList<String>();
		// String pvmsNo = "";
		int ItemId = 0;
		String query = "";
		Session session = (Session) getSession();
		int deptId = 0;
		int hospitalId=0;
		if (dataMap.get("deptId") != null) {
			deptId = (Integer) dataMap.get("deptId");
		}
		
		if (dataMap.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) dataMap.get(HOSPITAL_ID);
		}
		
		if (dataMap.get("ItemId") != null) {
			ItemId = (Integer) dataMap.get("ItemId");
		}
		try {
			query = "select sib.BatchNo from StoreItemBatchStock as sib join sib.Item as item where sib.ClosingStock>0 and sib.Department.Id ="
					+ deptId + " and item.Id =" + ItemId + " and sib.Hospital.Id="+hospitalId;
			Query q = session.createQuery(query);
			stockItemList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("stockItemList", stockItemList);
		return map;
	}

	public Map<String, Object> getItemClosingStock(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> closingItemList = new ArrayList<Object[]>();
		// String pvmsNo = "";
		int ItemId = 0;
		String query = "";
		String batchNo = "";
		int hospitalId = 0;
		Session session = (Session) getSession();
		int deptId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = (Integer) dataMap.get("deptId");
		}
		if (dataMap.get("ItemId") != null) {
			ItemId = (Integer) dataMap.get("ItemId");
		}
		if (dataMap.get("batchNo") != null) {
			batchNo = (String) dataMap.get("batchNo");
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = (Integer) dataMap.get("hospitalId");
		}
		try {
			query = "select sib.ExpiryDate,sib.ClosingStock from StoreItemBatchStock as sib join sib.Item as item where sib.Department.Id ="
					+ deptId
					+ " and item.Id ="
					+ ItemId
					+ " and sib.BatchNo ='" + batchNo + "' and sib.Hospital.Id = "+hospitalId+" ";
			Query q = session.createQuery(query);
			closingItemList = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("closingItemList", closingItemList);
		return map;
	}

	public Map<String, Object> showSendSmsJsp(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();

		Session session = (Session) getSession();
		try {
			String empCategoryCodeForDoctor = properties
					.getProperty("empCategoryCodeForDoctor");
			employeeList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "Y"))
					.add(Restrictions.eq("Hospital.Id",
							(Integer) mapDetail.get(HOSPITAL_ID)))
					.addOrder(Order.asc("FirstName")).list();

			empCategoryList = session.createCriteria(MasEmpCategory.class)
					.add(Restrictions.eq("Status", "Y")).list();
			map.put("employeeList", employeeList);
			map.put("empCategoryList", empCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> submitSendSms(Map<String, Object> mapDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		String message = "";
		try {
			OneToOne smsout = new OneToOne();
			if (mapDetail.get("smsout") != null) {
				smsout = (OneToOne) mapDetail.get("smsout");
			}
			// CommunicationService c=null;
			session.save(smsout);
			String empCategoryCodeForDoctor = properties
					.getProperty("empCategoryCodeForDoctor");
			employeeList = session
					.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCat")
					.add(Restrictions.eq("empCat.EmpCategoryCode",
							empCategoryCodeForDoctor))
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("FirstName")).list();
			map.put("employeeList", employeeList);
			message = "Message Sent Successfully!!..";
			map.put("message", message);
			session.flush();
			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> showWardWiseDetails(int deptId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = null;
		session = (Session) getSession();
		try {

			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			List<String> listStr = new ArrayList<String>();
			listStr.add("A");
			listStr.add("R");
			inPatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.in("AdStatus", listStr))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.addOrder(Order.asc("Department.Id")).list();

			map.put("inPatientList", inPatientList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// ///---Added By Manjul on 10/10/2011-------////
	public Map<String, Object> getItemListForAutoCompleteIpd(
			Map<String, Object> map) {
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int hospitalId = (Integer) map.get(HOSPITAL_ID);
		int deptId = (Integer) map.get("deptId");
		int storeType = 0;
		Session session = (Session) getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class, "md")
					.add(Restrictions.eq("md.Status", "Y"))
					.add(Restrictions.eq("md.Id", deptId)).list();
			// departmentList=getHibernateTemplate()
			// .find("from jkt.hms.masters.business.MasDepartment as md where md.Status = 'Y' and md.Id="+deptId);
			for (MasDepartment masDepartment123 : departmentList) {
				storeType = masDepartment123.getStoreType().getId();
			}
			String str = "%" + map.get("autoHint") + "%";
			// Criteria criteria = session
			// .createCriteria(StoreItemBatchStock.class, "stock")
			// .createAlias("stock.Item", "mst")
			// .createAlias("stock.Hospital", "hosp")
			// .setProjection(
			// Projections
			// .projectionList()
			// .add(Projections.groupProperty("mst.Id"))
			// .add(Projections
			// .groupProperty("mst.PvmsNo"))
			// .add(Projections
			// .groupProperty("mst.Nomenclature")))
			// .add(Restrictions.eq("hosp.Id", hospitalId))
			// .add(Restrictions.eq("stock.Department.Id", storeType))
			// .add(Restrictions.eq("mst.Status", "Y"))
			// .add(Restrictions.gt("stock.ClosingStock", 0))
			// .add(Restrictions.like("mst.Nomenclature", str))
			// .setFirstResult(0).setMaxResults(10);
			// itemList = criteria.list();
			String query = "select mst.Id,mst.PvmsNo,mst.Nomenclature from MasStoreItem as mst,StoreItemBatchStock stock "
					+ " where mst.Id= stock.Item and stock.Department.Id="
					+ storeType
					+ " and stock.Hospital="
					+ hospitalId
					+ " and mst.Status='Y' and stock.ClosingStock>0 and  mst.Nomenclature like '"
					+ str + "' group by mst.Id,mst.PvmsNo,mst.Nomenclature";
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

	@Override
	public Map<String, Object> showPatinetissueReport(Date fromDate,
			Date toDate, String regNo,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlDispensingDetails> itemList = new ArrayList<BlDispensingDetails>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int storeType = 0;
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		try {
			crit = session.createCriteria(BlDispensingDetails.class)
					.createAlias("DispensingHeader", "dh")
					.createAlias("dh.Hospital", "h")
					.add(Restrictions.between("dh.BillDate", fromDate, toDate))
					.add(Restrictions.eq("h.Id", hospitalId));
					
					
			
			if (regNo != null && !regNo.equals("")) {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", regNo)).list();
				for (Patient patient : patientList) {
					hinId = patient.getId();
				}
				crit = crit.add(Restrictions.eq("dh.Hin.Id", hinId));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		itemList = crit.list();
		map.put("itemList", itemList);

		return map;
	}

	@Override
	public List<TempCheckInOutFinal> getNumberOfUser(String year, String month) {
		Map<String, Object> map = new HashMap<String, Object>();
		int noOfUsers = 0;
		String query = "";
		Session session = (Session) getSession();
		// List<TempCheckInOut>tcList=
		List<TempCheckInOutFinal> tcilist = new ArrayList<TempCheckInOutFinal>();
		try {
			tcilist = session.createCriteria(TempCheckInOutFinal.class)
					.add(Restrictions.eq("Years", year))
					.add(Restrictions.eq("Months", "" + month)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// itemList=crit.list();
		// map.put("itemList", itemList);

		return tcilist;
	}

	@Override
	public Map<String, Object> getQuery(String year, String month, String days) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		int noOfUsers = 0;
		Session session = (Session) getSession();
		boolean flag = false;
		String sql = "";
		String query = "";
		int year1 = 0;
		int month1 = 0;
		int days1 = 0;
		year1 = Integer.parseInt(year);
		month1 = Integer.parseInt(month);
		days1 = Integer.parseInt(days);
		List<Object[]> objectList = new ArrayList<Object[]>();
		List<TempProcCheckInOut> procList = new ArrayList<TempProcCheckInOut>();
		List<TempCheckInOutFinal> finalList = new ArrayList<TempCheckInOutFinal>();
		int noOfEmployee = 0;
		int empId = 0;
		String checkType = "";
		java.sql.Connection con = session.connection();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {

			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String currentDate = "";
			String currentMonth = "";
			String currentYear = "";
			currentDate = date.substring(0, 2);
			currentMonth = date.substring(3, 5);
			currentYear = date.substring(6, 10);
			Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
			String time = (String) utilMap.get("currentTime");
			// if(currentYear.equals(year) ){

			sql = "{call hrReport(" + year1 + ",'" + month1 + "'" + ")}";

			if (sql != "sql") {
				try {
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			query = "select distinct userid,defaultdeptid from temp_proc_check_in_out";

			objectList = session.createSQLQuery(query).list();
			noOfEmployee = objectList.size();

			for (Object[] obj : objectList) {

				TempCheckInOutFinal tciofinal = new TempCheckInOutFinal();
				finalList = session.createCriteria(TempCheckInOutFinal.class)
						.add(Restrictions.eq("UserId", (Integer) obj[0]))
						.list();
				tciofinal.setDates(date);
				tciofinal.setYears("" + year1);
				tciofinal.setMonths("" + month1);

				tciofinal.setUserId((Integer) obj[0]);
				tciofinal.setDepartment("" + obj[1]);
				hbt.save(tciofinal);

				int numberOfDays = 0;
				numberOfDays = Integer.parseInt(HMSUtil.countNoOfDays(""
						+ year1, "" + month1));

				for (int i = 1; i <= numberOfDays; i++) {
					if (i == 1) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0])).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();

						for (TempCheckInOutFinal tempCheckInOutFinal1 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal1.setD1("A");
							} else {
								tempCheckInOutFinal1.setD1("P");
							}
							hbt.update(tempCheckInOutFinal1);

						}

					} else if (i == 2) {
						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();

						for (TempCheckInOutFinal tempCheckInOutFinal2 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal2.setD2("A");
							} else {
								tempCheckInOutFinal2.setD2("P");
							}
							hbt.update(tempCheckInOutFinal2);

						}

					} else if (i == 3) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal3 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal3.setD3("A");
							} else {
								tempCheckInOutFinal3.setD3("P");
							}
							hbt.update(tempCheckInOutFinal3);

						}

					} else if (i == 4) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal4 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal4.setD4("A");
							} else {
								tempCheckInOutFinal4.setD4("P");
							}
							hbt.update(tempCheckInOutFinal4);

						}
					} else if (i == 5) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal5 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal5.setD5("A");
							} else {
								tempCheckInOutFinal5.setD5("P");
							}
							hbt.update(tempCheckInOutFinal5);

						}
					} else if (i == 6) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal6 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal6.setD6("A");
							} else {

								tempCheckInOutFinal6.setD6("P");
							}

							hbt.update(tempCheckInOutFinal6);
						}
					} else if (i == 7) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();

						for (TempCheckInOutFinal tempCheckInOutFinal7 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal7.setD7("A");
							} else if (procList.size() > 0) {
								tempCheckInOutFinal7.setD7("P");
							}
							hbt.update(tempCheckInOutFinal7);

						}
					} else if (i == 8) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal8 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal8.setD8("A");
							} else {

								tempCheckInOutFinal8.setD8("P");
							}

							hbt.update(tempCheckInOutFinal8);

						}
					} else if (i == 9) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal9 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal9.setD9("A");
							} else {

								tempCheckInOutFinal9.setD9("P");

							}
							hbt.update(tempCheckInOutFinal9);

						}
					} else if (i == 10) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal10 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal10.setD10("A");
							} else {
								tempCheckInOutFinal10.setD10("P");
							}
							hbt.update(tempCheckInOutFinal10);

						}
					} else if (i == 11) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal11 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal11.setD11("A");
							} else {
								tempCheckInOutFinal11.setD11("P");
							}
							hbt.update(tempCheckInOutFinal11);

						}
					} else if (i == 12) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();

						for (TempCheckInOutFinal tempCheckInOutFinal12 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal12.setD12("A");
							} else {
								tempCheckInOutFinal12.setD12("P");
							}
							hbt.update(tempCheckInOutFinal12);
						}
					} else if (i == 13) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal13 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal13.setD13("A");
							} else {
								tempCheckInOutFinal13.setD13("P");
							}
							hbt.update(tempCheckInOutFinal13);
						}
					} else if (i == 14) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal14 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal14.setD14("A");
							} else {
								tempCheckInOutFinal14.setD14("P");
							}
							hbt.update(tempCheckInOutFinal14);
						}
					} else if (i == 15) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal15 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal15.setD15("A");
							} else {
								tempCheckInOutFinal15.setD15("P");
							}
							hbt.update(tempCheckInOutFinal15);
						}
					} else if (i == 16) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal16 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal16.setD16("A");
							} else {
								tempCheckInOutFinal16.setD16("P");
							}
							hbt.update(tempCheckInOutFinal16);
						}
					} else if (i == 17) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal17 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal17.setD17("A");
							} else {
								tempCheckInOutFinal17.setD17("P");
							}
							hbt.update(tempCheckInOutFinal17);
						}
					} else if (i == 18) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal18 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal18.setD18("A");
							} else {
								tempCheckInOutFinal18.setD18("P");
							}
							hbt.update(tempCheckInOutFinal18);
						}
					} else if (i == 19) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal19 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal19.setD19("A");
							} else {
								tempCheckInOutFinal19.setD19("P");
							}
							hbt.update(tempCheckInOutFinal19);
						}
					} else if (i == 20) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal20 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal20.setD20("A");
							} else {
								tempCheckInOutFinal20.setD20("P");
							}
							hbt.update(tempCheckInOutFinal20);
						}
					} else if (i == 21) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal21 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal21.setD21("A");
							} else {
								tempCheckInOutFinal21.setD21("P");
							}
							hbt.update(tempCheckInOutFinal21);
						}
					} else if (i == 22) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal22 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal22.setD22("A");
							} else {
								tempCheckInOutFinal22.setD22("P");
							}
							hbt.update(tempCheckInOutFinal22);
						}
					} else if (i == 23) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal23 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal23.setD23("A");
							} else {
								tempCheckInOutFinal23.setD23("P");
							}
							hbt.update(tempCheckInOutFinal23);
						}
					} else if (i == 24) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal24 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal24.setD24("A");
							} else {
								tempCheckInOutFinal24.setD24("P");
							}
							hbt.update(tempCheckInOutFinal24);
						}
					} else if (i == 25) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal25 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal25.setD25("A");
							} else {
								tempCheckInOutFinal25.setD25("P");
							}
							hbt.update(tempCheckInOutFinal25);
						}
					} else if (i == 26) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal26 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal26.setD26("A");
							} else {
								tempCheckInOutFinal26.setD26("P");
							}
							hbt.update(tempCheckInOutFinal26);
						}
					} else if (i == 27) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal27 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal27.setD27("A");
							} else {
								tempCheckInOutFinal27.setD27("P");
							}
							hbt.update(tempCheckInOutFinal27);
						}
					} else if (i == 28) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal28 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal28.setD28("A");
							} else {
								tempCheckInOutFinal28.setD28("P");
							}
							hbt.update(tempCheckInOutFinal28);
						}
					} else if (i == 29) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal29 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal29.setD29("A");
							} else {
								tempCheckInOutFinal29.setD29("P");
							}
							hbt.update(tempCheckInOutFinal29);
						}
					} else if (i == 30) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal30 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal30.setD30("A");
							} else {
								tempCheckInOutFinal30.setD30("P");
							}
							hbt.update(tempCheckInOutFinal30);
						}
					} else if (i == 31) {

						finalList = session
								.createCriteria(TempCheckInOutFinal.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", year))
								.add(Restrictions.eq("Months", month)).list();
						procList = session
								.createCriteria(TempProcCheckInOut.class)
								.add(Restrictions
										.eq("UserId", (Integer) obj[0]))
								.add(Restrictions.eq("Years", "" + year1))
								.add(Restrictions.eq("Months", "" + month1))
								.add(Restrictions.eq("Dates", "" + i))

								.setMaxResults(1).list();
						for (TempCheckInOutFinal tempCheckInOutFinal31 : finalList) {
							if (procList.size() == 0) {
								tempCheckInOutFinal31.setD31("A");
							} else {
								tempCheckInOutFinal31.setD31("P");
							}
							hbt.update(tempCheckInOutFinal31);
						}
					}
				}

			}
			// }

			/*
			 * else{ sql = "{call hrReport(" + year1 +",'"+month1+"'"+")}"; try
			 * { if(sql!=""){ CallableStatement cals = con.prepareCall(sql);
			 * cals.execute();} } catch (SQLException e) { e.printStackTrace();
			 * }
			 * 
			 * for(int i=1;i<=days1;i++) {
			 * 
			 * 
			 * query="select distinct userid from temp_proc_check_in_out";
			 * objectList=session.createSQLQuery(query).list();
			 * noOfEmployee=objectList.size(); for(int
			 * j=0;j<objectList.size();j++){ TempCheckInOutFinal tciofinal=new
			 * TempCheckInOutFinal(); if(i==1){
			 * procList=session.createCriteria(TempProcCheckInOut
			 * .class).add(Restrictions.eq("UserId", (Integer)obj[0]))
			 * .setMaxResults(1).list(); for(TempProcCheckInOut
			 * tempProc:procList){ checkType=tempProc.getChecktype();
			 * 
			 * if(tempProc.getDepartment()!=null &&
			 * tempProc.getDepartment()!=0){
			 * tciofinal.setDepartment(tempProc.getDepartment()); }else{
			 * tciofinal.setDepartment(0); } if(objectList.get(j)!=null){
			 * tciofinal.setUserId((Integer)objectList.get(j)); }
			 * if(tempProc.getDates
			 * ()!=null){tciofinal.setDates(tempProc.getDates()); }
			 * if(tempProc.getMonths()!=null){
			 * tciofinal.setMonths(tempProc.getMonths()); }
			 * if(tempProc.getYears()!=null){
			 * tciofinal.setYears(tempProc.getYears()); }
			 * if(tempProc.getDays()!=null){
			 * tciofinal.setDays(tempProc.getDays()); } if(checkType!=null &&
			 * !checkType.equals("") && checkType.equals("I")){
			 * tciofinal.setChecktype(tempProc.getChecktype());
			 * tciofinal.setD1("P"); }else{ tciofinal.setD1("A"); }
			 * 
			 * }hbt.save(tciofinal); }else if(i==2){
			 * finalList=session.createCriteria
			 * (TempCheckInOutFinal.class).add(Restrictions.eq("UserId",
			 * objectList.get(j))) .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal2:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal2.setD2("P"); }else{
			 * tempCheckInOutFinal2.setD2("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal2); }
			 * 
			 * 
			 * } else if(i==3){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal3:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal3.setD3("P"); }else{
			 * tempCheckInOutFinal3.setD3("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal3); }
			 * 
			 * }else if(i==4){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal4:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal4.setD4("P"); }else{
			 * tempCheckInOutFinal4.setD4("A"); } }
			 * hbt.update(tempCheckInOutFinal4);
			 * 
			 * } }else if(i==5){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal5:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal5.setD5("P"); }else{
			 * tempCheckInOutFinal5.setD5("A"); } }
			 * hbt.update(tempCheckInOutFinal5);
			 * 
			 * } }else if(i==6){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal6:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal6.setD6("P"); }else{
			 * tempCheckInOutFinal6.setD6("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal6); } }else if(i==7){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal7:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal7.setD7("P"); }else{
			 * tempCheckInOutFinal7.setD7("A"); } }
			 * hbt.update(tempCheckInOutFinal7);
			 * 
			 * } }else if(i==8){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal8:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal8.setD8("P"); }else{
			 * tempCheckInOutFinal8.setD8("A"); } }
			 * hbt.update(tempCheckInOutFinal8);
			 * 
			 * } }else if(i==9){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal9:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal9.setD9("P"); }else{
			 * tempCheckInOutFinal9.setD9("A"); } }
			 * hbt.update(tempCheckInOutFinal9);
			 * 
			 * } }else if(i==10){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal10:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal10.setD10("P"); }else{
			 * tempCheckInOutFinal10.setD10("A"); } }
			 * hbt.update(tempCheckInOutFinal10);
			 * 
			 * } }else if(i==11){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal11:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal11.setD11("P"); }else{
			 * tempCheckInOutFinal11.setD11("A"); } }
			 * hbt.update(tempCheckInOutFinal11);
			 * 
			 * } }else if(i==12){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal12:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal12.setD12("P"); }else{
			 * tempCheckInOutFinal12.setD12("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal12); } }else if(i==13){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal13:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal13.setD13("P"); }else{
			 * tempCheckInOutFinal13.setD13("A"); } }
			 * hbt.update(tempCheckInOutFinal13);
			 * 
			 * } }else if(i==14){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal14:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal14.setD14("P"); }else{
			 * tempCheckInOutFinal14.setD14("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal14); } }else if(i==15){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal15:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal15.setD15("P"); }else{
			 * tempCheckInOutFinal15.setD15("A"); } }
			 * hbt.update(tempCheckInOutFinal15);
			 * 
			 * } }else if(i==16){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal16:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal16.setD16("P"); }else{
			 * tempCheckInOutFinal16.setD16("A"); } }
			 * hbt.update(tempCheckInOutFinal16);
			 * 
			 * } }else if(i==17){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal17:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal17.setD17("P"); }else{
			 * tempCheckInOutFinal17.setD17("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal17); } }else if(i==18){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal18:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal18.setD18("P"); }else{
			 * tempCheckInOutFinal18.setD18("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal18); } }else if(i==19){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal19:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal19.setD19("P"); }else{
			 * tempCheckInOutFinal19.setD19("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal19); } }else if(i==20){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal20:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal20.setD20("P"); }else{
			 * tempCheckInOutFinal20.setD20("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal20); } }else if(i==21){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal21:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal21.setD21("P"); }else{
			 * tempCheckInOutFinal21.setD21("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal21); } }else if(i==22){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal22:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal22.setD22("P"); }else{
			 * tempCheckInOutFinal22.setD22("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal22); } }else if(i==23){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal23:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal23.setD23("P"); }else{
			 * tempCheckInOutFinal23.setD23("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal23); } }else if(i==24){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal24:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal24.setD24("P"); }else{
			 * tempCheckInOutFinal24.setD24("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal24); } }else if(i==25){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal25:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal25.setD25("P"); }else{
			 * tempCheckInOutFinal25.setD25("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal25); } }else if(i==26){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal26:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal26.setD26("P"); }else{
			 * tempCheckInOutFinal26.setD26("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal26); } }else if(i==27){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal27:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal27.setD27("P"); }else{
			 * tempCheckInOutFinal27.setD27("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal27); } }else if(i==28){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal28:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal28.setD28("P"); }else{
			 * tempCheckInOutFinal28.setD28("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal28); } }else if(i==29){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal29:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal29.setD29("P"); }else{
			 * tempCheckInOutFinal29.setD29("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal29); } }else if(i==30){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal30:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal30.setD30("P"); }else{
			 * tempCheckInOutFinal30.setD30("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal30); } }else if(i==31){
			 * 
			 * finalList=session.createCriteria(TempCheckInOutFinal.class).add(
			 * Restrictions.eq("UserId", objectList.get(j)))
			 * .add(Restrictions.eq("Years",
			 * year)).add(Restrictions.eq("Months", month)).list();
			 * procList=session
			 * .createCriteria(TempProcCheckInOut.class).add(Restrictions
			 * .eq("UserId", objectList.get(j))).setMaxResults(1).list();
			 * for(TempCheckInOutFinal tempCheckInOutFinal31:finalList) {
			 * for(TempProcCheckInOut tpcio2:procList){
			 * if(tpcio2.getChecktype()!=null &&
			 * tpcio2.getChecktype().equalsIgnoreCase("I")) {
			 * tempCheckInOutFinal31.setD31("P"); }else{
			 * tempCheckInOutFinal31.setD31("A"); } }
			 * 
			 * hbt.update(tempCheckInOutFinal31); } } }
			 * 
			 * 
			 * } }
			 */

			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		// itemList=crit.list();
		// map.put("itemList", itemList);

		return map;
	}

	@Override
	public Map<String, Object> showEmployee(int empCategoryId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();

		Session session = (Session) getSession();
		try {
			// String empCategoryCodeForDoctor =
			// properties.getProperty("empCategoryCodeForDoctor");
			employeeList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCategory")
					.add(Restrictions.eq("empCategory.Id", empCategoryId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "Y"))
					.addOrder(Order.asc("FirstName")).list();

			// empCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status",
			// "y")).list();
			map.put("employeeList", employeeList);
			// map.put("empCategoryList", empCategoryList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<MasEmployee> getEmplist(int empCategoryId, int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int noOfUsers = 0;
		String query = "";
		Session session = (Session) getSession();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		try {
			masEmployeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("EmpCategory.Id", empCategoryId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "Y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masEmployeeList;
	}

	@Override
	public String getMobileNo(int employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int noOfUsers = 0;
		String mobileNo = "";
		Session session = (Session) getSession();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		try {
			masEmployeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Id", employeeId)).list();
			for (MasEmployee emp : masEmployeeList) {
				mobileNo = emp.getTelNoOffice();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mobileNo;
	}

	@Override
	public Map<String, Object> showWardRemarksJsp(int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// int noOfUsers=0;
		// String mobileNo="";
		int deptId = 0;

		Session session = (Session) getSession();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		try {
			masDepartmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("DepartmentType.Id", 10)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();
		map.put("masDepartmentList", masDepartmentList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public Map<String, Object> showProgressNoteJsp(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		// int noOfUsers=0;
		// String mobileNo="";
		int inpatientId = 0;
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		try {
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String, Object> saveProgressNotes(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		int departmentId = 0;
		String date = "";
		// String lastChgBy = "";
		// String currentTime = "";
		String saved = "no";
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		// currentTime = (String) utilMap.get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (dataMap.get("box") != null) {
			box = (Box) dataMap.get("box");
		}
		if (box.get("deptId") != null) {
			departmentId = Integer.parseInt("" + box.get("deptId"));
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		int inpatientId = 0;
		if (dataMap.get("inpatientId") != null) {
			inpatientId = (Integer) dataMap.get("inpatientId");
		}
		try {
			IpProgressNote wardRemarks = new IpProgressNote();
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(""
					+ box.get(DATE)));
			wardRemarks.setProgressDate(java.sql.Date.valueOf(date4MySQL));
			wardRemarks.setProgressTime("" + box.get(TIME));
			wardRemarks.setProgressNote("" + box.get(REMARKS));
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			wardRemarks.setInpatient(inpatient);
			hbt.save(wardRemarks);
			saved = "yes";
		} catch (Exception e) {
			e.printStackTrace();
		}
		org.hibernate.Session session = getSession();
		try {
			departmentList = session.createCriteria(MasDepartment.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		map.put("masDepartmentList", departmentList);
		map.put("inpatientList", inpatientList);
		return map;
	}

	@Override
	public Map<String, Object> getProgressNoteDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpProgressNote> wardRemarksList = new ArrayList<IpProgressNote>();
		String remarksDate = "";
		int inpatientId = 0;
		try {
			if (dataMap.get("remarksDate") != null) {
				remarksDate = "" + dataMap.get("remarksDate");
			}
			if (dataMap.get("inpatientId") != null) {
				inpatientId = (Integer) dataMap.get("inpatientId");
			}

			SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL2 = formatterOut2.format(formatterIn2
					.parse(remarksDate));
			org.hibernate.Session session = getSession();
			//
			wardRemarksList = (List<IpProgressNote>) session
					.createCriteria(IpProgressNote.class)
					.add(Restrictions.eq("ProgressDate",
							java.sql.Date.valueOf("" + date4MySQL2)))
					.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		map.put("wardRemarksList", wardRemarksList);
		return map;
	}

	@Override
	public Map<String, Object> updateMLCData() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		Date oneDayBefore = cal.getTime();
		String prevTime = HMSUtil.convertDateToStringOnlyTime(oneDayBefore);
		String prevDate = HMSUtil.convertDateToStringTypeDateOnly(oneDayBefore);
		String today = HMSUtil.convertDateToStringTypeDateOnly(now);
		String curr_time = HMSUtil.convertDateToStringOnlyTime(now);
		/*
	    
	    
	    */
		prevTime = "01:00:00";
		List<Inpatient> ptList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		ptList = session
				.createCriteria(Inpatient.class)
				.add(Restrictions.between("DateOfAddmission",
						HMSUtil.convertStringTypeDateToDateType(prevDate),
						HMSUtil.convertStringTypeDateToDateType(today)))
				// .add(Restrictions.between("TimeOfAddmission",prevTime,
				// curr_time))
				.createAlias("Hin", "pt")
				.createAlias("pt.PatientType", "ptType")
				.add(Restrictions.eq("ptType.Id", 14)).list();
		for (Inpatient ip : ptList) {
			String timeofAdmission = ip.getTimeOfAddmission();
			Date dateOfAd = ip.getDateOfAddmission();
			String admDate = HMSUtil.convertDateToStringTypeDate(dateOfAd);
			SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
			try {
				utilMap = (Map) HMSUtil.getCurrentDateAndTime();
				String currentDate = (String) utilMap.get("currentDate");
				String currentTime = (String) utilMap.get("currentTime");

				Date twelve = parser.parse(timeofAdmission);
				/*
	*/
				Date cur = parser.parse(currentTime);
				/*
	
*/String admissionDate = HMSUtil
						.convertDateToStringTypeDateOnly(dateOfAd);
				admissionDate = admissionDate.substring(6, 10).concat("-")
						.concat(admissionDate.substring(3, 5)).concat("-")
						.concat(admissionDate.substring(0, 2));
				/**/

				// if(new Date().after(dateOfAd)){
				if (!HMSUtil.getConvertDateYYYYMMDD(currentDate).equals(
						admissionDate)) {
					/**/
					if (cur.before(twelve)) {
						/**/
					} else {
						int hinId = 0;
						hinId = ip.getHin().getId();
						List<Patient> patientList = new ArrayList<Patient>();

						patientList = session.createCriteria(Patient.class)
								.add(Restrictions.eq("Id", hinId)).list();
						for (Patient pt : patientList) {
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							MasPatientType mpt = new MasPatientType();
							mpt.setId(13);
							pt.setPatientType(mpt);
							hbt.update(pt);
						}
					}
				} else {/**/
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		/**/
		/*
		 * String query=
		 * "select * from inpatient where date_of_addmission between '2014-03-07' and '2014-06-01'"
		 * ;
		 */

		return map;
	}

	@Override
	public Map<String, Object> getPhysiotherapistPatientList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String query = "SELECT iprh.inpatient_id,p.p_first_name+' ' +p.p_last_name as name, "
				+ "		p.hin_no,ip.ad_no,iprh.last_chg_date,iprh.last_chg_time  "
				+ "		 FROM IP_PHYSIO_REQ_header iprh "
				+ "		left outer join patient p on  iprh.hin_id=p.hin_id "
				+ "		left outer join inpatient ip on  iprh.inpatient_id=ip.inpatient_id "
				+ "		where iprh.status='p'  "
				+ "		group by iprh.inpatient_id,p.p_first_name,p.p_last_name, "
				+ "		p.hin_no,ip.ad_no,iprh.last_chg_date,iprh.last_chg_time";
		//
		List<Object[]> patientList = new ArrayList<Object[]>();
		patientList = session.createSQLQuery(query).list();
		map.put("patientList", patientList);
		//

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

	public Map<String, Object> getPhysiotherapistList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> phytherapyList = new ArrayList<MasEmployee>();
		List<MasModularity> modularityList = new ArrayList<MasModularity>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		List<Inpatient> patientDataList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		int deptId = 0;
		int inpatientId = 0;
		int token = 0;
		if (dataMap.get("deptId") != null) {
			deptId = (Integer) dataMap.get("deptId");
		}
		if (dataMap.get("inpatientId") != null) {
			inpatientId = (Integer) dataMap.get("inpatientId");
		}
		/*
		 * if (dataMap.get("token") != null) { token = (Integer)
		 * dataMap.get("token"); }
		 */HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// Inpatient visitObject = new Inpatient();
		// visitObject = (Inpatient)
		// getHibernateTemplate().load(Inpatient.class, inpatientId);
		// visitObject.setDisplayToken(token);
		// visitObject.setTokenStatus("y");
		// hbt.update(visitObject);
		phytherapyList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Department.Id", deptId)).list();
		// modularityList = session.createCriteria(MasModularity.class).list();
		modularityList = getHibernateTemplate().find(
				"from  MasModularity where Status ='y' ");
		patientDataList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();

		/*
		 * Date currentDate = new Date(); visitTokenList =
		 * session.createCriteria
		 * (Visit.class).add(Restrictions.eq("TokenStatus", "y"))
		 * .add(Restrictions.eq("Department.Id", deptId))
		 * .add(Restrictions.eq("VisitDate", currentDate))
		 * .add(Restrictions.isNotNull("DisplayToken")).list();
		 */
		map.put("phytherapyList", phytherapyList);
		map.put("modularityList", modularityList);
		map.put("patientDataList", patientDataList);

		// map.put("visitTokenList", visitTokenList);
		return map;

	}

	@Override
	public Map<String, Object> getDialysisPatientList(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String query = "SELECT iprh.inpatient_id,p.p_first_name+' ' +p.p_last_name as name, "
				+ "		p.hin_no,ip.ad_no,iprh.last_chg_date,iprh.last_chg_time  "
				+ "		 FROM ip_dialysis_req_header iprh "
				+ "		left outer join patient p on  iprh.hin_id=p.hin_id "
				+ "		left outer join inpatient ip on  iprh.inpatient_id=ip.inpatient_id "
				+ "		where iprh.status='p'  "
				+ "		group by iprh.inpatient_id,p.p_first_name,p.p_last_name, "
				+ "		p.hin_no,ip.ad_no,iprh.last_chg_date,iprh.last_chg_time";

		List<Object[]> patientList = new ArrayList<Object[]>();
		patientList = session.createSQLQuery(query).list();
		map.put("patientList", patientList);

		return map;
	}

	@Override
	public Map<String, Object> getDialysisPatientList1(
			Map<String, Object> mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> phytherapyList = new ArrayList<MasEmployee>();
		List<MasModularity> modularityList = new ArrayList<MasModularity>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		List<Inpatient> patientDataList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		int deptId = 0;
		int inpatientId = 0;
		int token = 0;
		if (mapForDS.get("deptId") != null) {
			deptId = (Integer) mapForDS.get("deptId");
		}
		if (mapForDS.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDS.get("inpatientId");
		}
		/*
		 * if (dataMap.get("token") != null) { token = (Integer)
		 * dataMap.get("token"); }
		 */HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		// Inpatient visitObject = new Inpatient();
		// visitObject = (Inpatient)
		// getHibernateTemplate().load(Inpatient.class, inpatientId);
		// visitObject.setDisplayToken(token);
		// visitObject.setTokenStatus("y");
		// hbt.update(visitObject);
		phytherapyList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y"))
				.add(Restrictions.eq("Department.Id", deptId)).list();
		// modularityList = session.createCriteria(MasModularity.class).list();
		modularityList = getHibernateTemplate().find(
				"from  MasModularity where Status ='y' ");
		patientDataList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();

		/*
		 * Date currentDate = new Date(); visitTokenList =
		 * session.createCriteria
		 * (Visit.class).add(Restrictions.eq("TokenStatus", "y"))
		 * .add(Restrictions.eq("Department.Id", deptId))
		 * .add(Restrictions.eq("VisitDate", currentDate))
		 * .add(Restrictions.isNotNull("DisplayToken")).list();
		 */
		map.put("phytherapyList", phytherapyList);
		map.put("modularityList", modularityList);
		map.put("patientDataList", patientDataList);

		// map.put("visitTokenList", visitTokenList);
		return map;

	}

	@Override
	public String generateReceiptNo(String string) {
		Integer receiptSeqNo = 0;
		List<BlParameter> rcSeqNoList = new ArrayList<BlParameter>();
		Session session = (Session) getSession();
		try {
			rcSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "RC")).list();
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

			if (string.equals("save")) {
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
	public Map<String, Object> getPatientDetailsForAdvance(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();

		String hinNo = "";
		/*String patientFName = "";
		String patientMName = "";
		String patientLName = "";*/
		String patientName = "";
		String mobileNo = "";
		int hinId = 0;
		Session session = null;
		session = (Session) getSession();
		Criteria crit = null;

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("patientName") != null) {
			patientName = (String) mapForDs.get("patientName");
		}
		if (mapForDs.get("mobileNo") != null) {
			mobileNo = (String) mapForDs.get("mobileNo");
		}
		/*if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("patientMName") != null) {
			patientMName = (String) mapForDs.get("patientMName");
		}
		if (mapForDs.get("patientLName") != null) {
			patientLName = (String) mapForDs.get("patientLName");
		}*/
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		try {
			crit = session.createCriteria(Patient.class);
			if (hinId == 0) {
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("HinNo", hinNo));
				}
				if (!patientName.equals("")) {
					crit = crit.add(Restrictions.ilike("PFirstName",patientName + "%"));
				}
				if (!mobileNo.equals("")) {
					crit = crit.add(Restrictions.like("MobileNumber",mobileNo ));
				}
				/*if (!patientFName.equals("")) {
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
				}*/
			} else if (hinId != 0) {
				crit = crit.add(Restrictions.idEq(hinId));
			}
			

			patientList = crit.list();
			bankList = session.createCriteria(MasBankMaster.class)
					.add(Restrictions.eq("Status", "y")).list();
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

	@Override
	public Map<String, Object> getSystemParamDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		HospitalParameters hospitalParameters = new HospitalParameters();
		Session session = null;
		session = (Session) getSession();
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

	@Override
	public Map<String, Object> getPatientDetailsForKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId=box.getInt(HOSPITAL_ID);
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<IpdKitIssueMasterTemplateM> templateList = new ArrayList<IpdKitIssueMasterTemplateM>();
		List<IpdKitIssueHeader> ipdKitIssueList = new ArrayList<IpdKitIssueHeader>();
		List<IpdKitIssueDetails> ipdKitIssueDetailList = new ArrayList<IpdKitIssueDetails>();
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.idEq(box.getInt("parent")))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		templateList = session.createCriteria(IpdKitIssueMasterTemplateM.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		ipdKitIssueList = session.createCriteria(IpdKitIssueHeader.class)
				.createAlias("Inpatient", "ip")
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("ip.Id", box.getInt("parent")))
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		
		ipdKitIssueDetailList = session.createCriteria(IpdKitIssueDetails.class)
				.createAlias("Header", "hdr")
				.createAlias("hdr.Inpatient", "ip")
				.createAlias("hdr.Hospital", "h")
				.add(Restrictions.eq("ip.Id", box.getInt("parent")))
				.add(Restrictions.eq("h.Id", hospitalId)).list();
		map.put("inpatientList", inpatientList);
		map.put("templateList", templateList);
		map.put("ipdKitIssueList", ipdKitIssueList);
		map.put("ipdKitIssueDetailList", ipdKitIssueDetailList);
		return map;
	}

	@Override
	public Map<String, Object> getPatientLatestDiagnosisAndDisability(
			int inpatientId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
//		List<MasMedicalExaminationDetail> disabilityList = new ArrayList<MasMedicalExaminationDetail>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.idEq(inpatientId)).list();
		int hinId = 0;
		hinId = inpatientList.get(0).getHin().getId();
		diagnosisList = session.createCriteria(DischargeIcdCode.class)
				.createAlias("Hin", "h").add(Restrictions.eq("h.Id", hinId))
				.addOrder(Order.desc("Id")).setMaxResults(1).list();
//		disabilityList = session
//				.createCriteria(MasMedicalExaminationDetail.class)
//				.createAlias("MasMedicalReport", "mer")
//				.add(Restrictions.eq("mer.Hin.Id", hinId))
//				.add(Restrictions.isNotNull("MasIcd"))
//				.addOrder(Order.desc("Serviceid")).setMaxResults(1).list();
		map.put("diagnosisList", diagnosisList);
//		map.put("disabilityList", disabilityList);
		return map;
	}

	@Override
	public Map<String, Object> showNewCaseSheetJsp(Box box) {
		  Map<String, Object> map = new HashMap<String, Object>();
		  String allergyStr="";
		  List<Object[]>employeeList=new ArrayList<Object[]>();
		  List<PatientPrescriptionDetails>patientPrescriptionDetailsList=new ArrayList<PatientPrescriptionDetails>();
		  List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
		  List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		  List<Inpatient> inpatientMotherList = new ArrayList<Inpatient>();
		  List<OpdPatientDetails> opdDetailsList = new  ArrayList<OpdPatientDetails>(); 
		  List<OpdPatientDetails>  ipdDetailsList = new ArrayList<OpdPatientDetails>();
		  List<PatientPrescriptionHeader> opdPrescriptionList = new  ArrayList<PatientPrescriptionHeader>();
		  List<DgOrderdt> opdInvestigationList = new  ArrayList<DgOrderdt>(); // added by amit das on 08-11-2016
		   List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>(); 
		
		  List<OpdPatientHistory>  opdHistoryDetailsListForFollowUp = new  ArrayList<OpdPatientHistory>(); 
		  List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		  List<MasDiet> dietTypeList = new ArrayList<MasDiet>(); 
		  List<OpdPatientDetails> caseSheetList = new   ArrayList<OpdPatientDetails>();
		  List<OpdTemplate> templateList = new   ArrayList<OpdTemplate>();
		  
		  List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
		  List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
		  
		  List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
		 List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
			
		 List<OpdPatientDetails>  ipdPatientDetailList = new ArrayList<OpdPatientDetails>();
		 List<OpdPatientHistory>  ipdPatientHistoryList = new ArrayList<OpdPatientHistory>();
		 List<DischargeIcdCode>  ipdDischargeList = new ArrayList<DischargeIcdCode>();
		 
		 List<InpatientPrescriptionHeader>  ipdPatientPrescriptionHeaderList = new ArrayList<InpatientPrescriptionHeader>();
		 List<DgOrderhd> ipdPatientInvestigationHeaderList = new ArrayList<DgOrderhd>();
		
		 List<OpdSurgeryHeader>  ipdOpdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
		 List<OpdPatientAllergyM>  ipdOpdPatientAllergyMList = new ArrayList<OpdPatientAllergyM>();
		 
		List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
		
		List<AmbulanceRegister> ambulanceRegistersList=new ArrayList<AmbulanceRegister>();
		
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<RsbyCardDetails> rsbyCardDetailsList = new ArrayList<RsbyCardDetails>(); // added by Amit Das
		List<MasScheme> packageSchemeList = new ArrayList<MasScheme>(); // added by Amit Das
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>(); // added by Amit Das
		List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>(); // added by Amit Das
		List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		
		String departmentTypeCodeForCanteen=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			departmentTypeCodeForCanteen=prop.getProperty("departmentTypeCodeForCanteen");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int motherInpatientId=0;
		  int deptId=box.getInt(DEPT_ID);
		  int hospitalId=box.getInt(HOSPITAL_ID);
		  int inpatientId=box.getInt("parent");
		  int userId=0;
		  if(box.getInt("userId")!=0){
			  userId=box.getInt("userId");
		  }
		  Session session = (Session)getSession();
		
		  relationList = session
					.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "Y".toLowerCase())
							.ignoreCase()).list();
		  
		  List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
		  wardreamarksList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
				  //.add(Restrictions.eq("Doctor.Id", employeeId))
				  .list();
				  
		  
		  inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list(); 
		  int hinId=  inpatientList.get (0).getHin().getId();
		  String motherHinNo=""; 
		  motherHinNo = inpatientList.get (0).getHin().getMotherHinNo()!=null?inpatientList.get (0).getHin().getMotherHinNo():"";
		  if(motherHinNo!=""){
			  inpatientMotherList =  session.createCriteria(Inpatient.class)
					  .createAlias("Hin", "hin")
					  .add(Restrictions.eq("hin.HinNo", motherHinNo)) 
					  .list();
			  for (Inpatient inp : inpatientMotherList) {
				  	motherInpatientId=  inp.getId();
			  	}
			  
		  }
		  
		  opdDetailsList = session.createCriteria(OpdPatientDetails.class)
				  .createAlias("Visit","v")
				  .createAlias("v.Hin", "hin")
				  .createAlias("Hospital","h")
				  .add(Restrictions.eq("hin.Id", hinId)) 
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				  .addOrder(Order.desc("id"))
				  .setMaxResults(1).list();
		  
		  ipdPatientDetailList =  session.createCriteria(OpdPatientDetails.class)
				  .createAlias("Inpatient", "ip")
				  .add(Restrictions.eq("ip.Id", inpatientId))
				  .createAlias("Hospital","h")
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				  .addOrder(Order.desc("id"))
				  .setMaxResults(5)
				  .list();
		 
		  
		  if(ipdPatientDetailList.size()>0)
		  {
			  for (OpdPatientDetails details : ipdPatientDetailList) {
				  ipdPatientHistoryList.addAll(session.createCriteria(OpdPatientHistory.class)
						  .createAlias("OpdPatientDetails", "opdetails")
						  .add(Restrictions.eq("opdetails.Id", details.getId()))
						  .createAlias("Hospital","h")
						  .add(Restrictions.eq("h.Id", hospitalId)) 
						  .addOrder(Order.desc("opdetails.Id"))
						  .setMaxResults(5)
						  .list());
				  
				
			}
			  ipdDischargeList.addAll(session.createCriteria(DischargeIcdCode.class)
					  .createAlias("OpdPatientDetails", "opdetails")
					  .add(Restrictions.eq("opdetails.Id", ipdPatientDetailList.get(0).getId()))
					  .createAlias("Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					  .addOrder(Order.desc("opdetails.Id"))
					  .setMaxResults(5)
					  .list());
		  }
		 
		  ipdPatientPrescriptionHeaderList=session.createCriteria(InpatientPrescriptionHeader.class,"pph")
				  .createAlias("pph.Inpatient", "ip")
				  .add(Restrictions.eq("ip.Id", inpatientId))
				  .createAlias("pph.Hospital","h")
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				  .add(Restrictions.isNotNull("pph.PrescriptionNo"))
				   .addOrder(Order.desc("id"))
				   .setMaxResults(5)
				  .list();
		  
		  
		  //added by govind 20-10-2016
		  List<InjAppointmentDetails> injAppointmentDetailsList=new ArrayList<InjAppointmentDetails>();
		  Criteria inj=null;
		  if(ipdPatientPrescriptionHeaderList.size()>0){
				  for(InpatientPrescriptionHeader head:ipdPatientPrescriptionHeaderList){
					  for(InpatientPrescriptionDetails details:head.getPrescription()){
						 if(details.getInjectionStatus()!=null){
						  if(details.getInjectionStatus().equalsIgnoreCase("y")){
							 inj= session.createCriteria(InjAppointmentDetails.class)
									 .add(Restrictions.eq("InpatientPrescriptionDetails.Id",details.getId()));
							 if(inj.list().size()>0){
							 InjAppointmentDetails injApp=(InjAppointmentDetails)inj.list().get(0);
							 injAppointmentDetailsList.add(injApp);
							 }
						  }
					  }
					  }
				  }
					
		  }
		  String injStatus="N";
		  if(injAppointmentDetailsList.size()>0){
			  injStatus="Y";
			  map.put("injAppointmentDetailsList",injAppointmentDetailsList); 
			  map.put("injStatus",injStatus); 			  
		  }
		  //added by govind 20-10-2016
		  
	
		  
		  ipdPatientInvestigationHeaderList=session.createCriteria(DgOrderhd.class,"hd")
				  .createAlias("hd.Inpatient", "ip")
				  .add(Restrictions.eq("ip.Id", inpatientId))
				  .createAlias("hd.Hospital","h")
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				   .addOrder(Order.desc("id"))
				   .setMaxResults(5)
				  .list(); //added by amit das on 08-11-2016
		  
		  ipdOpdSurgeryHeaderList=session.createCriteria(OpdSurgeryHeader.class,"osh")
				  .createAlias("osh.Inpatient", "ip")
				  .add(Restrictions.eq("ip.Id", inpatientId))
				  .createAlias("osh.Hospital","h")
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				   .addOrder(Order.desc("id"))
				   .setMaxResults(5)
				   .list();
		 
		  ipdOpdPatientAllergyMList=session.createCriteria(OpdPatientAllergyM.class,"opam")
				  .createAlias("opam.Hin", "hin")
				  .add(Restrictions.eq("hin.Id", box.getInt("hinId")))
				   .addOrder(Order.desc("id"))
				   .list();
		  
		  
		  
		  ipdDetailsList =  session.createCriteria(OpdPatientDetails.class)
				  .createAlias("Inpatient", "ip")
				  .add(Restrictions.eq("ip.Id", box.getInt("parent")))
				  .createAlias("Hospital","h")
				  .add(Restrictions.eq("h.Id", hospitalId)) 
				  .addOrder(Order.desc("id")).list();
		  
		  if(opdDetailsList.size() > 0) { 
			  int visitId = 0; 
			  visitId = opdDetailsList.get(0).getVisit().getId(); 
			  if(ipdDetailsList.size() == 0) { 
				  opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class)
						  .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list(); 
				
				  
				  opdInvestigationList = session.createCriteria(DgOrderdt.class)
						  .createAlias("Orderhd", "hd")
						  .createAlias("hd.Visit", "v")
						  .add(Restrictions.eq("v.Id",visitId)).list(); // added by amit das on 08-11-2016
				  
				  icdList =session.createCriteria(DischargeIcdCode.class)
						  .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
				 
				  opdHistoryDetailsListForFollowUp = session.createCriteria (OpdPatientHistory.class)
						  .createAlias("OpdPatientDetails", "details")
						  .createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list(); } }
		  
		  List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>(); 
		
		  List<DgOrderdt> ipdInvestigationList = null; //added by amit das on 08-11-2016
		  List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>(); 
		 
		  List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
		  
		  if(ipdDetailsList.size() > 0) {
		  caseSheetList.addAll(ipdDetailsList);
		  // to display all previous case ist 
		  // opdDetailsList.add(ipdDetailsList.get(0));
		  // to display latest case sheet details in todays case sheet 
		  int opdPatientDetailsId = 0; 
		  opdPatientDetailsId = ipdDetailsList.get(0).getId(); 
		  ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class)
				  .createAlias("OpdPatientDetail", "ip")
				  .add(Restrictions.eq("ip.id",opdPatientDetailsId))
				  .addOrder(Order.desc("Id")).setMaxResults(1).list();
		
		  ipdInvestigationList = session.createCriteria(DgOrderdt.class)
				  .createAlias("Orderhd", "hd")
				  .createAlias("hd.Inpatient", "i")
				  .add(Restrictions.eq("i.Id",inpatientId)).list();  //added by amit das on 08-11-2016
		  
		  ipdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class)
				  .createAlias("OpdPatientDetails", "ip")
				  .add(Restrictions.eq("ip.id", opdPatientDetailsId)).list();
		  

		  }
		  ipdPrescriptionList.addAll(opdPrescriptionList);
		  // if condition Added by Dhananjay 10-11-16 for checking null
		  if(null !=opdInvestigationList && null !=ipdInvestigationList && opdInvestigationList.size()>0)
		  ipdInvestigationList.addAll(opdInvestigationList);
		  ipIcdList.addAll(icdList);
		
		  ipdHistoryDetailsListForFollowUp.addAll(opdHistoryDetailsListForFollowUp);
		  ipIcdList = session.createCriteria(DischargeIcdCode.class)
				  .createAlias("Inpatient","ip")
				  .add(Restrictions.eq("ip.id", box.getInt("parent")))
				  .addOrder(Order.desc("Id")).list(); 
		  caseSheetList.addAll(opdDetailsList); 
		  //to display opd case sheet
		  frequencyList =   session.createCriteria(MasFrequency.class)
				  .add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();

		  
		
		  dietTypeList = session.createCriteria(MasDiet.class)
				  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list(); 
		  templateList =session.createCriteria(OpdTemplate.class)
				  .createAlias("Department","dept")
				  .add( Restrictions.eq("dept.Id", box.getInt("deptId")))
				  .add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
		  
		  routeOfAdministrationList=session.createCriteria(RouteOfAdministration.class)
				  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
		  
		  			masInstructionMasterList=session.createCriteria(OpdInstructionTreatment.class)
				  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
		  
		  			allergyProductsList = session.createCriteria(MasAllergyProduct.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
		  			saverityCodesList = session.createCriteria(MasSeverityCode.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			
					nursingCareList = session.createCriteria(MasNursingCare.class)
					.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
			
					nursingCareSetupList = session
					.createCriteria(NursingcareSetup.class)
					.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
					.list();
				
				
				
				ambulanceRegistersList=session.createCriteria(AmbulanceRegister.class)
                         .add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
                          .add(Restrictions.eq("Hospital.Id", box.getInt(HOSPITAL_ID)))
                           .add(Restrictions.eq("RequestStatus","p").ignoreCase())					                            
                         .list();
				 
				departmentList = session
							.createCriteria(MasInstituteDepartment.class,"msd")
							.createAlias("msd.Department", "md")
							.createAlias("md.DepartmentType", "mdt")
							.createAlias("msd.Institute", "mh")
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions.eq("mdt.DepartmentTypeCode", departmentTypeCodeForCanteen).ignoreCase())
							.add(Restrictions.eq("md.Status", "y").ignoreCase())
							.add(Restrictions.eq("mh.Id", box.getInt(HOSPITAL_ID)))
							.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
					
				masMenuTypeList=session.createCriteria(MasMenuType.class)
							.add(Restrictions.eq("Status","y").ignoreCase())
							.list();
					List<IpdVitalSetup>ipdVitalSetupList=new ArrayList<IpdVitalSetup>();
				ipdVitalSetupList = session
						.createCriteria(IpdVitalSetup.class)
						.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
						.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
						.list();
				
				employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("EmpCategory.Id",4))
						.add(Restrictions.eq("Hospital.Id",hospitalId)).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")))
						.addOrder(Order.asc("FirstName"))
						.list();
				int visitId=0;
				List<Visit>visitList=new ArrayList<Visit>();
				visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
				for(Visit visit:visitList){
					visitId=visit.getId();
				}
				patientPrescriptionDetailsList=session.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "Prescription")
						.createAlias("Prescription.Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.list();
				
				
				DgOrderdtList=session.createCriteria(DgOrderdt.class)
						.createAlias("Orderhd", "Orderhd")
						.createAlias("Orderhd.Visit", "visit")
						.add(Restrictions.eq("visit.Id", visitId))
						.list();
		
		  // Added by Amit Das For Rsby & CHIS PLus schemes
			if(inpatientList!=null && inpatientList.size()!=0){
				HibernateTemplate hbt = getHibernateTemplate();
				Patient patient =	hbt.load(Patient.class, inpatientList.get(0).getHin().getId());
				if(patient!=null && patient.getRsbyCardNo()!=null){
					rsbyCardDetailsList =	session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("RsbyCardNo", patient.getRsbyCardNo())).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				}
			}
			
		  // Added by Amit Das For Rsby & CHIS PLus schemes
		  packageList = session.createCriteria(BlPackageHeader.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		  
		  // Added by Amit Das For Rsby & CHIS PLus schemes
		  packageSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("PackageFlag", "Y").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		  
		  // Added by Amit Das For Rsby & CHIS PLus schemes
		  packageServicesList = session.createCriteria(BlPackageServicesDetails.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		  
		 
		//patient allergy status :start
		  for(OpdPatientAllergyM allergyM:ipdOpdPatientAllergyMList)
			{		
			for(OpdPatientAllergyT allergyT:allergyM.getOpdPatientAllergyTs())
			{
			allergyStr=allergyStr+"\n"+allergyT.getAllergen();
			}
			}
			
			
			//patient comorbidity status :start
			List<DischargeIcdCode> comorbidityList = new ArrayList<DischargeIcdCode>();
			
			comorbidityList= session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", hinId))
											.add(Restrictions.or( Restrictions.isNotNull("ComorbidityStatus"),  Restrictions.eq("ComorbidityStatus", "y").ignoreCase()) )
											.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			String comorbidityStr="";
			for(DischargeIcdCode dic:comorbidityList){
				if(comorbidityStr.equals("")){
					if(dic.getSinceMonth() != null){
					comorbidityStr=dic.getIcd().getIcdName()+" :Since Month "+dic.getSinceMonth();
					}else if(dic.getSinceYear() != null){
						comorbidityStr=dic.getIcd().getIcdName()+" :Since Year "+dic.getSinceYear();
					}else{
						comorbidityStr=dic.getIcd().getIcdName();
					}
					
				}else{
					if(dic.getSinceMonth() != null){
					comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName()+"Since Month  "+dic.getSinceMonth();
					}else if(dic.getSinceYear() != null){
						comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName()+"Since Year  "+dic.getSinceYear();
					}else{
						comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName();
					}
					
				}
			}
			expiryDetailsList = session.createCriteria(ExpiryDetails.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			map.put("comorbidityStr", comorbidityStr);
			
		  
			// added by amit das on 06-09-2016
			if(inpatientList!=null && inpatientList.size()>0) {
			List<PatientEpisode> patientEpisodeList =	getPatientEpisodeList(inpatientList.get(0).getHinNo());
			map.put("patientEpisodeList", patientEpisodeList);
			}
		
			 //added govind 6-10-2016
			
			//added govind 21-10-2016 
			 String OtherDiagnos=null,diagnos=null,icCode=null,icName=null,icdVal=null;
			int icdCode=0;
			List<DischargeIcdCode> diagnosisList = new ArrayList<DischargeIcdCode>();
			List<MasIcd> masIcdList1 = new ArrayList<MasIcd>();
			
			diagnosisList = session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(diagnosisList.size()>0){				
				DischargeIcdCode diag=diagnosisList.get(0);
				icdCode=diag.getIcd().getId();
				
				masIcdList1=session.createCriteria(MasIcd.class).add(Restrictions.eq("Id", icdCode)).list();
				if(masIcdList1.size()>0){
				MasIcd masid=masIcdList1.get(0);
				  icCode=masid.getIcdCode();
				  icName=masid.getIcdName();
				  icdVal=masid.getIcdCode()+"@@@"+masid.getSnomedConceptId();
				  diagnos=masid.getIcdName();
				
				  map.put("icCode", icCode);
				  map.put("icdVal", icdVal);
				  map.put("icName", icName);
				  map.put("diagnose", diagnos);
				}
				
			}else{
			//added govind 21-10-2016  end
			  List<Object[]> diagList = new ArrayList<Object[]>();
			  Visit vi=null;
			  if(null !=opdDetailsList  && opdDetailsList.size()>0 )
				  vi =opdDetailsList.get(0).getVisit();
			 
			  List<PatientEpisode> patientEpisodeList=new ArrayList<PatientEpisode>();
			  if(null !=vi){
			  patientEpisodeList=session.createCriteria (PatientEpisode.class)
					  .add(Restrictions.eq("HinNo",vi.getHin().getHinNo() )).list();
			  }
			 
			  if(null !=opdDetailsList  && opdDetailsList.size()>0 )
			  OtherDiagnos=opdDetailsList.get(0).getInitialDiagnosis();
			  
			  if(patientEpisodeList.size()>0){
				  PatientEpisode patientEpisode=patientEpisodeList.get(0);
				  diagnos=patientEpisode.getEpisodeDesc();
				  
			  }
			  if(diagnos!=null){
				  String query="select t1.icd_code,t1.icd_name,t1.snomed_concept_id,t2.term from mas_icd t1 left outer join sct2_description t2 on t1.snomed_concept_id = t2.conceptId where t2.term like '%"+diagnos+"%'";
				  diagList=session.createSQLQuery(query).list();
				  if(diagList.size()>0){
				  Object[] obj=diagList.get(0);
				  icCode=obj[0].toString();
				  icName=obj[1].toString();
				  icdVal=obj[0].toString()+"@@@"+obj[2].toString();
				 
				  map.put("icCode", icCode);
				  map.put("icdVal", icdVal);
				  map.put("icName", icName);
				  }
				  map.put("diagnose", diagnos);
			  }else{
				  if(null !=opdDetailsList  && opdDetailsList.size()>0 )
				  OtherDiagnos=opdDetailsList.get(0).getInitialDiagnosis();
				  map.put("icName", OtherDiagnos);
				  map.put("diagnose", OtherDiagnos);
			  }
			 
	         }
			 
		   //added govind 6-10-2016 end 
			
		  map.put("motherInpatientId",motherInpatientId); 
		  map.put("relationList",relationList); 
		  map.put("caseSheetList",caseSheetList); 
		  map.put("inpatientList", inpatientList);
		  map.put("opdDetailsList", opdDetailsList);
		  map.put("ipdPrescriptionList", ipdPrescriptionList);
		  map.put("ipdInvestigationList", ipdInvestigationList);
		  map.put("ipIcdList", ipIcdList); 

		  map.put("ipdHistoryDetailsListForFollowUp",ipdHistoryDetailsListForFollowUp);

		  map.put("frequencyList", frequencyList);

		  map.put("dietTypeList", dietTypeList);
		  
		  map.put("routeOfAdministrationList", routeOfAdministrationList);
		  map.put("masInstructionMasterList", masInstructionMasterList);
		  map.put("allergyProductsList", allergyProductsList);
		  map.put("saverityCodesList", saverityCodesList);
		  
		  
		  //new value added for history
		  map.put("ipdPatientDetailList", ipdPatientDetailList);
		  map.put("ipdPatientHistoryList", ipdPatientHistoryList);
		  map.put("ipdDischargeList", ipdDischargeList);
		  map.put("ipdPatientPrescriptionHeaderList",ipdPatientPrescriptionHeaderList);
		  map.put("ipdPatientInvestigationHeaderList",ipdPatientInvestigationHeaderList);
		  map.put("ipdOpdSurgeryHeaderList",ipdOpdSurgeryHeaderList);
		  map.put("ipdOpdPatientAllergyMList", ipdOpdPatientAllergyMList);
		  
		  	map.put("nursingCareSetupList", nursingCareSetupList);
			map.put("nursingCareList", nursingCareList);
			map.put("ambulanceRegistersList", ambulanceRegistersList);			
			map.put("masDietList", masDietList);
			map.put("masMenuTypeList", masMenuTypeList);
			map.put("departmentList", departmentList);
			
			map.put("templateList", templateList);
		 map.put("ipdVitalSetupList",ipdVitalSetupList);
	
		 map.put("employeeList",employeeList);
		 map.put("wardreamarksList",wardreamarksList);
		 map.put("patientPrescriptionDetailsList",patientPrescriptionDetailsList);
		 map.put("DgOrderdtList",DgOrderdtList);
		 
		 // added by Amit Das
		 map.put("rsbyCardDetailsList",rsbyCardDetailsList);
		 map.put("packageList",packageList);
		 map.put("packageSchemeList",packageSchemeList);
		 map.put("packageServicesList",packageServicesList);
		 map.put("allergyStr",allergyStr);
		 map.put("expiryDetailsList",expiryDetailsList);
		 map.put("inpatientId", inpatientId);
		return map;
	}

	@Override
	public Map<String, Object> showMedicineIssueDetailJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		/*
		 * List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		 * List<PatientPrescriptionDetails> patientPresriptionDetailList = new
		 * ArrayList<PatientPrescriptionDetails>();
		 * List<PatientPrescriptionDetails> opdPatientPresriptionList = new
		 * ArrayList<PatientPrescriptionDetails>(); List<StoreItemBatchStock>
		 * itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		 * List<StoreIpIssueT> ipIssueDetailList = new
		 * ArrayList<StoreIpIssueT>(); List<OpdPatientDetails> opdDetailsList =
		 * new ArrayList<OpdPatientDetails>(); List ipIssueNo = new ArrayList();
		 * Session session = (Session)getSession();
		 * 
		 * ipIssueNo = session.createQuery(
		 * "select syd from StoreFyDocumentNo as syd where syd.Department.Id="+
		 * box.getInt("deptId")).list(); if (ipIssueNo.size() > 0) {
		 * StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNo
		 * .get(0); int issueNoOfPatient = storeFyDocumentNo
		 * .getIssueInPatientNo(); issueNoOfPatient = issueNoOfPatient + 1;
		 * map.put("issueNoOfPatient", issueNoOfPatient); }
		 */
		inPatientDetailList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", box.getInt("inPatientId"))).list();
		/*
		 * int hinId = inPatientDetailList.get(0).getHin().getId();
		 * frequencyList =
		 * session.createCriteria(MasFrequency.class).add(Restrictions
		 * .eq("Status", "y")).list(); patientPresriptionDetailList =
		 * session.createCriteria(PatientPrescriptionDetails.class)
		 * .createAlias("Prescription",
		 * "header").createAlias("header.Inpatient", "ip")
		 * .add(Restrictions.eq("ip.Id", box.getInt("inPatientId")))
		 * .add(Restrictions.neProperty("Total","GivenQty")) .list();
		 * 
		 * // Integer[] itemId = null; List<Integer> itemId = new
		 * ArrayList<Integer>(); if(patientPresriptionDetailList.size()>0){
		 * //itemId = new Integer[patientPresriptionDetailList.size()]; int i=0;
		 * for(PatientPrescriptionDetails patientPrescriptionDetails
		 * :patientPresriptionDetailList){
		 * if(patientPrescriptionDetails.getItem() != null){
		 * if(patientPrescriptionDetails.getItem().getId() != 0){
		 * itemId.add(patientPrescriptionDetails.getItem().getId()); } } i++; }
		 * 
		 * 
		 * } //else{ // fetching details from OPD in case of patient coming from
		 * OPD opdDetailsList =
		 * session.createCriteria(OpdPatientDetails.class).createAlias("Visit",
		 * "v").createAlias("v.Hin", "hin").add(Restrictions.eq("hin.Id",
		 * hinId)) .addOrder(Order.desc("id")).setMaxResults(1).list();
		 * if(opdDetailsList.size()>0){ int opddetailsId =
		 * opdDetailsList.get(0).getId() ; opdPatientPresriptionList
		 * =session.createCriteria(PatientPrescriptionDetails.class)
		 * .createAlias("Prescription",
		 * "header").createAlias("header.OpdPatientDetails", "opd")
		 * .add(Restrictions.eq("opd.id",
		 * opddetailsId)).add(Restrictions.neProperty("Total","GivenQty"))
		 * .list();
		 * 
		 * if(opdPatientPresriptionList.size() > 0){ //itemId = new
		 * Integer[opdPatientPresriptionList.size()]; int i=0;
		 * for(PatientPrescriptionDetails patientPrescriptionDetails
		 * :opdPatientPresriptionList){ if(patientPrescriptionDetails.getItem()
		 * != null){ if(patientPrescriptionDetails.getItem().getId() != 0){
		 * itemId.add(patientPrescriptionDetails.getItem().getId()); //
		 * itemId[i] = patientPrescriptionDetails.getItem().getId(); } } i++; }
		 * patientPresriptionDetailList.addAll(opdPatientPresriptionList);
		 * 
		 * } } // } if(itemId!=null && itemId.size() > 0){ itemBatchStockList =
		 * session.createCriteria(StoreItemBatchStock.class).createAlias("Item",
		 * "item").add(Restrictions.in("item.Id", itemId))
		 * .add(Restrictions.eq("Department.Id",
		 * box.getInt("deptId"))).add(Restrictions.ne("ClosingStock", new
		 * BigDecimal(0))).list(); } ipIssueDetailList =
		 * session.createCriteria(StoreIpIssueT.class).createAlias("IpIssue",
		 * "header") .createAlias("header.Inpatient",
		 * "inpatient").add(Restrictions.eq("inpatient.Id",
		 * box.getInt("inPatientId"))).list();
		 */
		map.put("inPatientDetailList", inPatientDetailList);
		/*
		 * map.put("ipIssueDetailList", ipIssueDetailList);
		 * map.put("frequencyList", frequencyList);
		 * 
		 * map.put("patientPresriptionDetailList",
		 * patientPresriptionDetailList); map.put("itemBatchStockList",
		 * itemBatchStockList); map.put("ipIssueNo", ipIssueNo);
		 */
		return map;
	}

	@Override
	public Map<String, Object> getDetailOfWaitingInPatient(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inPatientSet = new ArrayList<Inpatient>();  
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasBed> beds = new ArrayList<MasBed>();
		int deptId = 0;
		int hospitalId = 0;
		if (mapForDs.get(DEPT_ID) != null) {
			deptId = (Integer) mapForDs.get(DEPT_ID);
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}

		inPatientSet = session
				.createCriteria(Inpatient.class, "ip")
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("ip.AdStatus", "W".toLowerCase())
						.ignoreCase())
				.add(Restrictions.eq("ip.Department.Id", deptId))
				.add(Restrictions.eq("ip.Hospital.id", hospitalId))
				.addOrder(Order.desc("DateOfAddmission")).list();

		beds = session
				.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.asc("BedNo"))
				.createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode",
						bedStatusUnOccupiedName))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
				.add(Restrictions.isNull("VBed"))
				.list();
		if(beds.size()==0)
		{
			beds = session
					.createCriteria(MasBed.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.asc("BedNo"))
					.createAlias("BedStatus", "bs")
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusUnOccupiedName))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
					.add(Restrictions.isNotNull("VBed"))
					.list();
		}
		//added by govind 2-02-2017
		relationList = session
				.createCriteria(MasRelation.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase())
						.ignoreCase()).list();
		map.put("relationList", relationList);
		//added by govind 2-02-2017 end
		map.put("inPatientSet", inPatientSet);
		map.put("beds", beds);
		return map;
	}

	@Override
	public Map<String, Object> patientAdmissionAccept(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionHeader>sampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();
		int deptId = 0;
		int hospitalId = 0;
		String ipdNo = "";
		int bedId = 0;
		int inpatientId=0;
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String bedAllocationTime="";
		Date bedAllocationDate= new Date();
		String bedStatusOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		int empId=0;
		int userId=0;
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		//patientInvestigationHeader.setInvestigationTime(time);
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusOccupiedName = prop.getProperty("bedStatusOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (mapForDs.get(DEPT_ID) != null) {
			deptId = (Integer) mapForDs.get(DEPT_ID);
		}
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get(HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		}
		if (mapForDs.get("ipdNo") != null) {
			ipdNo = (String) mapForDs.get("ipdNo");
		}
		if (mapForDs.get("bedId") != null) {
			bedId = (Integer) mapForDs.get("bedId");
		}
		if (mapForDs.get("bedAllocationTime") != null) {
			bedAllocationTime = (String) mapForDs.get("bedAllocationTime");
		}
		if (mapForDs.get("bedAllocationDate") != null) {
			bedAllocationDate = (Date) mapForDs.get("bedAllocationDate");
		}
		if(mapForDs.get("empId")!=null){
			empId=(Integer)mapForDs.get("empId");
		}
		if(mapForDs.get("userId")!=null){
			userId=(Integer)mapForDs.get("userId");
		}
		
		
		/*boolean paywardProcessingRequired=false;
		if(transfer.getToWard().getPaywardCheck().equalsIgnoreCase("y"))
		{
			BlPaywardBooking blPaywardBooking=(BlPaywardBooking) session.createCriteria(BlPaywardBooking.class)
					                         .add(Restrictions.eq("Transfer.Id", transfer.getId()))
					                          .add(Restrictions.eq("BookingStatus", "w").ignoreCase())
					                         .setFirstResult(0)
					                         .setMaxResults(1)
					                         .uniqueResult();
			if(blPaywardBooking==null)
			{
				paywardProcessingRequired=true;
			}
			
		}
		if(paywardProcessingRequired)
		{
			status=false;
			 message="Payward allotment is not completed. Please complete Payward Allotment Process To accect.";
		}*/
		List<PatientPrescriptionDetails>patientPrescriptionDetailsList=new ArrayList<PatientPrescriptionDetails>();
		List<PatientInvestigationHeader>investigationHeaderList=new ArrayList<PatientInvestigationHeader>();
		List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
		int hinId=0;
		List<Inpatient> ipList = new ArrayList<Inpatient>();
		logger.info("inpatient id in impl"+inpatientId);
		
		ipList =  session
				.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		Inpatient inpatient = new Inpatient();
		if(ipList.size() > 0){
			inpatient = ipList.get(0);
			hinId=inpatient.getHin().getId();
		}
		if (bedId != 0) {
			
			int visitId=0;
			List<Visit>visitList=new ArrayList<Visit>();
			visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
			for(Visit visit:visitList){
				visitId=visit.getId();
			}
			patientPrescriptionDetailsList=session.createCriteria(PatientPrescriptionDetails.class)
					.createAlias("Prescription", "Prescription")
					.createAlias("Prescription.Visit", "visit")
					.add(Restrictions.eq("visit.Id", visitId))
					//.add(Restrictions.eq("h.Id", hospitalId)) 
					.list();
			

				/*DgOrderdtList=session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "Orderhd")
					.createAlias("Orderhd.Visit", "visit")
					.add(Restrictions.eq("visit.Id", visitId))
					//.add(Restrictions.eq("h.Id", hospitalId)) 
					.list();*/
			// commented by amit das on 25-08-2016
			// added by amit das on 25-08-2016
			DgOrderdtList=session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "Orderhd")
					.createAlias("Orderhd.Visit", "visit")
					.add(Restrictions.eq("visit.Id", visitId))
					.add(Restrictions.isNull("Orderhd.BillChargeSlpNo")) 
					.list();
			
			
		investigationHeaderList = session.createCriteria(PatientInvestigationHeader.class).add(Restrictions.eq("Visit.Id", visitId)).list();
		int orderHdId = 0;
		int ptInvestigationHdId = 0;
		int patientInvestigationHeaderId = 0;
		if(investigationHeaderList.size()>0){
			ptInvestigationHdId = investigationHeaderList.get(0).getId();
		}	
		if(DgOrderdtList.size()>0){
			 orderHdId = DgOrderdtList.get(0).getOrderhd().getId();
			sampleCollectionHeaderList = session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Order.Id", orderHdId)).list();
		}
		logger.info("orderHdId111=="+orderHdId +"sampleCollectionHeaderList=="+sampleCollectionHeaderList.size());
		
		//--------------------Inactive DgOrderHd op Data------------------------------------------
		 // if(sampleCollectionHeaderList.size()==0){ // commented by amit das on 25-08-2016
			if(sampleCollectionHeaderList.size()==0 && DgOrderdtList.size()>0){	// added by amit das on 25-08-2016
			if(orderHdId != 0){
			DgOrderhd orderhd = (DgOrderhd)hbt.load(DgOrderhd.class, orderHdId);
			orderhd.setOrderStatus("n");
			orderhd.setRefVisitId(visitId);
			hbt.update(orderhd);
			
			if(ptInvestigationHdId>0){
			PatientInvestigationHeader investigationHeader = (PatientInvestigationHeader)hbt.load(PatientInvestigationHeader.class, ptInvestigationHdId);
			investigationHeader.setStatus("n");
			investigationHeader.setRefVisitId(visitId);
			hbt.update(investigationHeader);
			}
			PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
			Patient p=new Patient();
			p.setId(hinId);
			patientInvestigationHeader.setHin(p);
			MasDepartment md=new MasDepartment();
			md.setId(deptId);
			patientInvestigationHeader.setDepartment(md);
			patientInvestigationHeader.setInpatient(inpatient);
			MasHospital masHospitalObj =new MasHospital();
			masHospitalObj.setId(hospitalId);
			patientInvestigationHeader.setHospital(masHospitalObj);
			patientInvestigationHeader.setStatus("p");
			patientInvestigationHeader.setInvestigationDate(new Date());
			
//			patientInvestigationHeader.setClinicalNote(box.getString("clinicalNotes1"));
			//patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);
			MasEmployee masEmployee=new MasEmployee();
			if(empId!=0){
			masEmployee.setId(empId);
			patientInvestigationHeader.setInvestigationBy(masEmployee);
			}
			hbt.save(patientInvestigationHeader);
			//ipdPatientData.put("patientInvestigationHeader", patientInvestigationHeader);
			DgOrderhd dgOrderhd = new DgOrderhd();
			dgOrderhd.setOrderDate(HMSUtil.dateFormatterDDMMYYYY(currentDate));
			dgOrderhd.setOrderTime(time);
			dgOrderhd.setHospital(masHospitalObj);
			dgOrderhd.setInpatient(inpatient);
			dgOrderhd.setHin(p);
			dgOrderhd.setDepartment(md);
			dgOrderhd.setPrescribedBy(masEmployee);
			dgOrderhd.setPatientType("IP");
			dgOrderhd.setTestType("Regular");
	
            //need discussion
			
//			String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
			String orderSeqNo = labDataService.generateOrderNumber();
			
			dgOrderhd.setOrderNo(orderSeqNo);

//			dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
			dgOrderhd.setOrderStatus("P");
			//dgOrderhd.setLabOrderStatus("P");
			Users user =new Users();
			if(userId!=0){
				user.setId(userId);
				dgOrderhd.setLastChgBy(user);
			}
			
			dgOrderhd.setLastChgDate(new Date());
			dgOrderhd.setLastChgTime(time);
			dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
			
			DgSampleCollectionHeader collHeader = null;
			hbt.save(dgOrderhd);
			//ipdPatientData.put("dgOrderhd", dgOrderhd);
			List<Object> patientInvestigatinDetailsListObject = new ArrayList<Object>();
			List<Object> dgOrderDetailsListObject = new ArrayList<Object>();
			List<Object> dgSampleCollectionDeatilsListObject=new ArrayList<Object>();
			for (DgOrderdt dt :DgOrderdtList){					
				
					int  chargeCodeId = dt.getChargeCode().getId();						
					MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(""+chargeCodeId));
					
				PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
				patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(Integer.parseInt(""+chargeCodeId));
				patientInvestigationDetails.setChargeCode(masChargeCode);
				patientInvestigationDetails.setQuantity(1);   // default quantity is 1
				patientInvestigationDetails.setClinicalNotes("Admitting Remarks");
				//patientInvestigationDetails.setReferToMh(box.getString("referToMh"+i));

				hbt.save(patientInvestigationDetails);
				patientInvestigatinDetailsListObject.add(patientInvestigationDetails);
				DgOrderdt dgOrderdt = new DgOrderdt();
				dgOrderdt.setOrderhd(dgOrderhd);
				masChargeCode.setId(Integer.parseInt(""+chargeCodeId));
				dgOrderdt.setChargeCode(masChargeCode);
				dgOrderdt.setOrderQty(1);

				dgOrderdt.setLastChgBy(user);
				dgOrderdt.setLastChgDate(new Date());
				dgOrderdt.setLastChgTime(time);
				// method written for taking out the values of mascharge
				// code and subcharge
				List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
				masChargeList = session.createCriteria(MasChargeCode.class).add(
						Restrictions.eq("Id", Integer.parseInt(""+chargeCodeId))).list();

				MasChargeCode masChargeCodeObj = masChargeList.get(0);
				int mainChargeId = masChargeCodeObj.getMainChargecode()
				.getId();
				int subChargeId = masChargeCodeObj.getSubChargecode()
				.getId();
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
				
//				dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeId)));
				//dgOrderdt.setInvestigationToMH("n");
				//dgOrderdt.setReferToMh(box.getString("referToMh"+i));
				hbt.save(dgOrderdt);
				dgOrderDetailsListObject.add(dgOrderdt);
				if (chargeCode.getDepartment()
						.getDepartmentType().getDepartmentTypeCode()
						.equals("RADIO")) {
					
					if(collHeader==null)
					{
						collHeader=new DgSampleCollectionHeader();
					collHeader.setHin(p);
					collHeader.setInpatient(inpatient);

					if (chargeCode!= null) {
						collHeader.setDepartment(chargeCode.getDepartment());
					}
					collHeader.setHospital(masHospitalObj);
					collHeader.setOrder(dgOrderhd);
					collHeader.setDiagnosisDate(HMSUtil.dateFormatterDDMMYYYY(currentDate));
					collHeader.setDiagnosisTime(time);
					collHeader.setOrderStatus("P");
					collHeader.setLastChgBy(user);
					collHeader.setLastChgDate(new Date());
					collHeader.setLastChgTime(time);
					hbt.save(collHeader);
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
						sampleDetails.setLastChgBy(user);
						sampleDetails.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(currentDate));
						sampleDetails.setLastChgTime(time);
						sampleDetails.setOrderStatus("P");
						sampleDetails.setSampleCollDatetime(HMSUtil.dateFormatterDDMMYYYY(currentDate));

						MasMainChargecode maincharge = new MasMainChargecode();
						sampleDetails.setMaincharge(chargeCode.getMainChargecode());

						MasSubChargecode subCharge = new MasSubChargecode();
						subCharge.setId(chargeCode.getSubChargecode()
								.getId());
						sampleDetails.setSubcharge(subCharge);
						DgMasInvestigation investigation = new DgMasInvestigation();
						investigation.setId(Integer.parseInt(""+chargeCodeId));
						sampleDetails.setInvestigation(investigation);
						sampleDetails.setSampleCollDatetime(new Date());
						hbt.save(sampleDetails);
						dgSampleCollectionDeatilsListObject.add(sampleDetails);
					
				}
				
			}
		  }
		}
	
			
			InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
			//PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			Patient pt = new Patient();
			pt.setId(hinId);
			inpatientPrescriptionHeader.setHin(pt);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			inpatientPrescriptionHeader.setDepartment(masDepartment);
			inpatientPrescriptionHeader.setInpatient(inpatient);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			inpatientPrescriptionHeader.setHospital(masHospital);
			inpatientPrescriptionHeader.setStatus("p");
			inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			inpatientPrescriptionHeader.setPrescriptionTime(time);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(empId);
			inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
			inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.dateFormatterDDMMYYYY(currentDate));
			inpatientPrescriptionHeader.setPrescriptionTime(time);
			
			
//			need to be update after discussion
//			inpatientPrescriptionHeader.setPrescriptionNo(String.valueOf(prescriptionNo));
//			String sqlItemId="";
//			List<Integer> itemIdList = new ArrayList<Integer>();
			hbt.save(inpatientPrescriptionHeader);
			List<Object> inpatientPrescriptionDetailsListObject = new ArrayList<Object>();
			for (PatientPrescriptionDetails ppd :patientPrescriptionDetailsList) {
					
					
					InpatientPrescriptionDetails inpatientPrescriptionDetails=new InpatientPrescriptionDetails();
					//PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
					/*MasStoreItem masStoreItem = new MasStoreItem();
					
					
					masStoreItem.setId(itemId);*/
//					masStoreItem.setId(itemIdList.get(i-1));
					MasStoreItem item=new MasStoreItem();
					item.setId(ppd.getItem().getId());
					inpatientPrescriptionDetails.setItem(item);
					if(ppd.getFrequency()!=null){
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(ppd.getFrequency().getId());
					inpatientPrescriptionDetails.setFrequency(masFrequency);
					}
					inpatientPrescriptionDetails.setDosage(ppd.getDosage());
					inpatientPrescriptionDetails.setSplInstruction(ppd.getSplInstruction());
					inpatientPrescriptionDetails.setNoOfDays(ppd.getNoOfDays());
					inpatientPrescriptionDetails.setType("IP");
					RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
					if(ppd.getRoute()!=null){
					routeOfAdministration.setId(ppd.getRoute().getId());
					inpatientPrescriptionDetails.setRoute(routeOfAdministration);
					}
					
					
					
					inpatientPrescriptionDetails.setTotal(ppd.getTotal());
					inpatientPrescriptionDetails.setStopMedicine("n");
					
//					patientPrescriptionDetails.setGivenQty(0);
					inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader);
					inpatientPrescriptionDetails.setIssuedStatus("p");
//					patientPrescriptionDetails.setDetailStatus("a");
					
					/*List<MasStoreItem> storeItemList=new ArrayList<MasStoreItem>();
					storeItemList=hbt.find("select item from jkt.hms.masters.business.MasStoreItem as item join item.ItemCategory as ic where item.Id="+itemIdList.get(i-1)+" and ic.Id="+item_category_id);
					if(storeItemList.size() > 0){
						patientPrescriptionDetails.setInjectionStatus("p");
					}else{
						patientPrescriptionDetails.setInjectionStatus("n");
					}*/

					hbt.save(inpatientPrescriptionDetails);
					
					}
				
			
			boolean paywardProcessingRequired=false;
			/*if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getAdmissionWard()!=null 
			  && inpatient.getOpdPatientDetails().getAdmissionWard().getPaywardCheck()!=null && 
			   inpatient.getOpdPatientDetails().getAdmissionWard().getPaywardCheck().equalsIgnoreCase("y"))*/
			if(inpatient.getDepartment() != null && inpatient.getDepartment().getPaywardCheck() != null &&  inpatient.getDepartment().getPaywardCheck().equalsIgnoreCase("y")){
				BlPaywardBooking blPaywardBooking=(BlPaywardBooking) session.createCriteria(BlPaywardBooking.class)
						                        // .add(Restrictions.eq("OpdPatientDetails.Id", inpatient.getOpdPatientDetails().getId()))
													.add(Restrictions.eq("Inpatient.Id", inpatient.getId()))
						                          .add(Restrictions.eq("BookingStatus", "w").ignoreCase())
						                         .setFirstResult(0)
						                         .setMaxResults(1)
						                         .uniqueResult();
				if(blPaywardBooking==null)
				{
					paywardProcessingRequired=true;
				}
				
			}
			
			if(paywardProcessingRequired)
			{
				map.put("message", "Payward allotment is not completed. Please complete Payward Allotment Process To accect.");
			}
			else
			{
			MasBed bed = (MasBed) session.get(MasBed.class, bedId);
			inpatient.setBed(bed);
			inpatient.setAdStatus("A");
			inpatient.setBedAllocationDate(bedAllocationDate);
			inpatient.setBedAllocationTime(bedAllocationTime);
			hbt.update(inpatient);
			map.put("successStstus", "yes");
			MasBedStatus bedStatus = (MasBedStatus) session
					.createCriteria(MasBedStatus.class)
					.add(Restrictions
							.eq("BedStatusCode", bedStatusOccupiedName))
					.uniqueResult();
			bed.setBedStatus(bedStatus);
			
			hbt.update(bedStatus);
			
			
			final MasHospital hospital=(MasHospital)session.get(MasHospital.class, hospitalId);
			final Map<String,Object>  mapForCentralServer=new HashMap<String,Object>();
			final Inpatient finalInpatient=inpatient;
			final String finalBedStatusOccupiedName = bedStatusOccupiedName;
			
			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*new Thread(){
				public void run(){
					if(hospital!=null && hospital.getServerIp()!=null && !hospital.getServerIp().trim().equals("") && !hospital.getServerIp().trim().equals("null") && hospital.getServerPort()!=null && !hospital.getServerPort().trim().equals("") && !hospital.getServerPort().trim().equals("null")){

						mapForCentralServer.put("hospital", hospital);
						mapForCentralServer.put("inpatient", finalInpatient); 
						mapForCentralServer.put("bedStatusOccupiedName", finalBedStatusOccupiedName); 
						hl7MessageForIpAdmission(mapForCentralServer);
					}
					if(hospital!=null && hospital.getClientIp()!=null && !hospital.getClientIp().trim().equals("") && !hospital.getClientIp().trim().equals("null") && hospital.getClientPort()!=null && !hospital.getClientPort().trim().equals("") && !hospital.getClientPort().trim().equals("null")){


						mapForCentralServer.put("hospital", hospital);
						mapForCentralServer.put("inpatient", finalInpatient); 
						mapForCentralServer.put("bedStatusOccupiedName", finalBedStatusOccupiedName); 
						Map<String,Object> returnData=hl7MessageForIpAdmissionToClient(mapForCentralServer);
						String message=(String)returnData.get("message");
						String ipAddimissionMessage=(String)returnData.get("ipAddimissionMessage");
						String bedMessage=(String)returnData.get("bedMessage");
						IpAdmissionForLean admissionForLean=new IpAdmissionForLean();
						admissionForLean.setHospitalId(hospital.getId());
						admissionForLean.setInpatientId(finalInpatient.getId());
						admissionForLean.setIpAdmission(ipAddimissionMessage);
						admissionForLean.setIpBedAllow(bedMessage);
						String isIpAddimissionSaved="Y";
						if(!"1".equalsIgnoreCase(message)){
							isIpAddimissionSaved="N";
						}
						
						
						List<? extends Number> list = new ArrayList<Integer>();
						list = new ArrayList<Long>();
						
						admissionForLean.setStatus(isIpAddimissionSaved); 
						HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						hbt.save(admissionForLean);
					}
				}
				}.start();*/
			
			map.put("message", "Bed Allocated Successfully.");
			
			}
		} else {
			map.put("successStstus", "no");
			map.put("message", "Unable to Allocate Bed. Please try after some time.");
		}
		//added by govind 02-02-2017
		HibernateTemplate hbt1 = getHibernateTemplate();
		String dependentName=null;
		int relation =0;
		
		if (mapForDs.get("dependentName") != null) {
			dependentName = (String) mapForDs.get("dependentName");
			inpatient.setDependentName(dependentName);
		}
		if (mapForDs.get("relation") != null) {
			relation = (Integer) mapForDs.get("relation");
			if(relation>0){
			MasRelation masR=new MasRelation();
			masR.setId(relation);
			inpatient.setRelation(masR);
			}
		}
		logger.info("dependentName "+dependentName+" relation impl "+relation);
		if(inpatient!=null){
			hbt1.update(inpatient);
		}
		//added by govind 02-02-2017 end
		return map;
	}

				
	@Override
	public Map<String, Object> getTemplateDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdKitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<IpdKitIssueMasterTemplateT>();
		Session session = (Session) getSession();
		kitIssueDetailsList = session
				.createCriteria(IpdKitIssueMasterTemplateT.class)
				.createAlias("Template", "t")
				.add(Restrictions.eq("t.Id", box.getInt("kitIssueMasterId")))
				.list();
		map.put("kitIssueDetailsList", kitIssueDetailsList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitPatientKitIssue(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		int inpatientId = box.getInt("inpatientId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = (Session)getSession();
		Transaction tx= null;
		IpdKitIssueHeader ipdKitIssueHeader = new IpdKitIssueHeader();
		try {
			tx = session.beginTransaction();
			if(box.getInt("ipdKitIssueHeaderId")==0){
				Patient hin = new Patient();
				hin.setId(box.getInt(RequestConstants.HIN_ID));
				ipdKitIssueHeader.setHin(hin);
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				ipdKitIssueHeader.setInpatient(inpatient);
				MasHospital hospital = new MasHospital();
				hospital.setId(box.getInt("hospitalId"));
				ipdKitIssueHeader.setHospital(hospital);
				IpdKitIssueMasterTemplateM template = new IpdKitIssueMasterTemplateM();
				template.setId(box.getInt("kitIssueMasterId"));
			//	ipdKitIssueHeader.setTemplate(template);
				Users user = new Users();
				user.setId(box.getInt("userId"));
				ipdKitIssueHeader.setLastChgBy(user);
				 Map<String, Object>  dateTimeMap=HMSUtil.getCurrentDateAndTime();
				ipdKitIssueHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)dateTimeMap.get("currentDate")));
				ipdKitIssueHeader.setLastChgTime((String)dateTimeMap.get("currentTime"));
				hbt.save(ipdKitIssueHeader);
			}else{
				ipdKitIssueHeader.setId(box.getInt("ipdKitIssueHeaderId"));

			}

			
			int counter = box.getInt("hdb");
			if(counter >0 ) {
				for (int i = 1; i <= counter; i++) {
					if(!box.getString("nomenclature"+i).equals("") && box.getInt("kitIssueDetailsId"+i)==0){
						IpdKitIssueDetails kitIssueDetails = new IpdKitIssueDetails();
						kitIssueDetails.setItemName(box.getString("nomenclature"+i));
						kitIssueDetails.setQuantity(box.getInt("issueQuantity"+i));
						kitIssueDetails.setHeader(ipdKitIssueHeader);
						hbt.save(kitIssueDetails);
					}
				}

			}
			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}
	
	@Override
	public synchronized Map<String, Object> submitIpdCaseSheetDetails(Box box,Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		final Map<String,Object> ipdPatientData=new HashMap<String,Object>();
		final Map<String,List<Object>> ipdPatientDataList=new HashMap<String,List<Object>>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		
		int labDepartmentId=0;
		int radiologyDepartmentId=0;
		Properties properties = new Properties();
	       URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	      
	       try
	       {
	               properties.load(resourcePath.openStream());
	       }
	       catch (Exception e)
	       {
	               e.printStackTrace();
	       }
	      
			 labDepartmentId = Integer.parseInt(properties.getProperty("labDepartmentId"));
			 radiologyDepartmentId = Integer.parseInt(properties.getProperty("radiologyDepartmentId"));
			
		
		Session session = (Session)getSession();
		Transaction trans= null;
		try {
			trans = session.beginTransaction();
			List mlcNameList = new ArrayList();
			if(generalMap.get("mlcNameList") != null){
				mlcNameList = (List)generalMap.get("mlcNameList");
			}
			String time = "";
			if(box.get("time")!=null){
				time=box.get("time");
			}
			  int referredDept = 0;
				if(box.getInt("referredDept") != 0){
					referredDept = (Integer)box.getInt("referredDept");
				}
			Map<String,Object> utilMap = new HashMap<String,Object>();
			Map<String,Object> mapForDS= new HashMap<String,Object>();
			mapForDS.put("userId", box.getInt("userId"));
			mapForDS.put("userName", box.getString("userName"));
			mapForDS.put("hospitalId", box.getInt("hospitalId"));
			String hospitalCode = box.getString("hospitalCode");
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String consultationTime = (String)utilMap.get("currentTime");
			String consultationDate = (String)utilMap.get("currentDate");

			int procedureHeaderId = 0;
			procedureHeaderId = box.getInt("procedureHeaderId");
			  List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
			  wardreamarksList=session.createCriteria(WardRemarks.class).createAlias("Hospital", "hospital")
					  .add(Restrictions.eq("hospital.Id",box.getInt("hospitalId") ))
					  .add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId"))).add(Restrictions.eq("Status", "P").ignoreCase())
					  .list();
			  
			  logger.info("wardreamarksList=="+wardreamarksList.size());

			
			OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
			Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt("inpatientId"));
			opdPatientDetails.setInpatient(inpatient);
			MasEmployee masEmployee = new MasEmployee();
			if (box.getInt("empId") != 0) {
				masEmployee.setId(box.getInt("empId"));
				opdPatientDetails.setEmployee(masEmployee);
			}
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(box.getInt("hospitalId"));
			opdPatientDetails.setHospital(masHospitalObj);
			opdPatientDetails.setHeight(box.getDouble("height"));
			opdPatientDetails.setPulse(box.getInt("pulse"));
			opdPatientDetails.setWeight(box.getDouble("weight"));
			opdPatientDetails.setPulse(box.getInt("pulse"));
			if(box.getString("systolic")!=null && !box.getString("systolic").equals("") && box.getString("diastolic")!=null && !box.getString("diastolic").equals(""))
			{
			opdPatientDetails.setBp(box.getString("systolic")+"/"+box.getString("diastolic"));
			}
			if (box.getString("temperature")!=null) {
				opdPatientDetails.setTemperature(box.getFloat("temperature"));
			}
			if(box.getString("policeIntimation")!= null){
				opdPatientDetails.setPoliceIntimation("y");
			}else{
				opdPatientDetails.setPoliceIntimation("n");
			}
			//persisting snomed list:rajendra kumar
			StringBuffer sb=new StringBuffer();
			ArrayList<String> snomedListArray = null;
			if (box.getArrayList("snomedList") != null) {
				snomedListArray = (ArrayList<String>) box.getArrayList("snomedList");
			}
			if(snomedListArray!=null && snomedListArray.size()>0){
				for(String str:snomedListArray)
				{
					sb.append(str+",");
				}
				if(sb.length()>0){
					String snomedStr = sb.toString().substring(0, sb.toString().length()-1);
					opdPatientDetails.setSnomedNames(snomedStr);
				}
			}
			
			opdPatientDetails.setConsultationTime(box.getString("diagnosistime"));
			opdPatientDetails.setConsultationDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("diagnosisdate")));
			opdPatientDetails.setOpdDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("diagnosisdate")));
			opdPatientDetails.setOpdTime(box.getString("diagnosistime"));
			
			
			opdPatientDetails.setBmi(box.getFloat("bmi"));
			opdPatientDetails.setClinicalNote(box.getString("clinicalNotes"));
			int systemDiagnosisId = 0;
			if(!box.getString("systemDiagnosis").equals("")){
				String sysDiagnosis =box.getString("systemDiagnosis");
				int index1 = sysDiagnosis.lastIndexOf("[");
				int index2 = sysDiagnosis.lastIndexOf("]");
				index1++;
				systemDiagnosisId =Integer.parseInt(sysDiagnosis.substring(index1, index2));
				MasSystemDiagnosis systemDiagnosis = new MasSystemDiagnosis();
				systemDiagnosis.setId(systemDiagnosisId);
				opdPatientDetails.setSystemDiagnosis(systemDiagnosis);
			}
			opdPatientDetails.setGeneralExamination(box.getString("generalExaminationOPC"));
			opdPatientDetails.setLocalExamination(box.getString("localExamination"));
			opdPatientDetails.setSystemicExamination(box.getString("systemicExamination"));
			opdPatientDetails.setOutsideInvestigation(box.getString("outinvestigation"));
			opdPatientDetails.setOutsideInvestigationImage(box.getString("outinvestigationImage"));
			
			//	Added by dhananjay 15-Nov-2016		
			int period=0;
			String remarks="";
			String praganancy="";
			String lactation="";
			
			if(null !=generalMap.get("lactation")){
				lactation=(String)generalMap.get("lactation");
				opdPatientDetails.setLactation(lactation);
			}
			if(null !=generalMap.get("period")){
				period=(Integer)generalMap.get("period");
				opdPatientDetails.setPragnancyPeriod(period);
			}
			if(null !=generalMap.get("remarks")){
				remarks=(String)generalMap.get("remarks");
				opdPatientDetails.setPhysiologicalStatusRemarks(remarks);
			}
			if(null !=generalMap.get("praganancy")){
				praganancy=(String)generalMap.get("praganancy");
				opdPatientDetails.setPregnancy(praganancy);
			}
			// End 
			
			
			// added by amit das on 09-09-2016
						int episodeId = 0;
						long episodeNo = 0;
						String snomed = null;
						PatientEpisode patientEpisode = null;
						String episodeName = null;
						boolean episodeCloseCheck =	box.getBoolean("episodeCloseCheck");
						inpatient = (Inpatient) session.get(Inpatient.class, box.getInt("inpatientId"));
						if(box.getInt("episodeId")!=0) {
							episodeId = box.getInt("episodeId");
							patientEpisode = (PatientEpisode)session.get(PatientEpisode.class, episodeId);
							if(patientEpisode!=null){
								opdPatientDetails.setPatientEpisode(patientEpisode);
								inpatient.setPatientEpisode(patientEpisode);
							}
							
							if(episodeCloseCheck){
								patientEpisode.setEndDate(new Date());
								session.update(patientEpisode);
							}
						}else{
							patientEpisode = new PatientEpisode();
							snomed = box.get("snomed");
							
							List<PatientEpisode> patientEpisodes = session.createCriteria(PatientEpisode.class).add(Restrictions.eq("HinNo", inpatient.getHinNo()))
									.addOrder(Order.desc("EpisodeNumber")).setMaxResults(1)
									.list();
							MasDepartment department = 	(MasDepartment)session.get(MasDepartment.class, box.getInt("departmentId"));
							
							if(patientEpisodes!=null && patientEpisodes.size()>0)
								episodeNo =	patientEpisodes.get(0).getEpisodeNumber();
							
							episodeNo = episodeNo+1;
							patientEpisode.setHinNo(inpatient.getHinNo());
							patientEpisode.setEpisodeNumber(episodeNo);
							patientEpisode.setDepartment(department);
							patientEpisode.setStartDate(new Date());
							patientEpisode.setEpisodeDesc(snomed);
							
							if(mapForDS.get("episodeName")!=null){
								episodeName = box.get("episodeName");
								patientEpisode.setEpisodeName(episodeName);
							}
							
							
							if(episodeCloseCheck)
								patientEpisode.setEndDate(new Date());
							
							session.save(patientEpisode);
							
							opdPatientDetails.setPatientEpisode(patientEpisode);
							inpatient.setPatientEpisode(patientEpisode);
						}
			
			
			map.put("hinId",  inpatient.getHin().getId());
			map.put("OpdPatientDetails", opdPatientDetails);
			hbt.save(opdPatientDetails);
			hbt.update(inpatient); // added by amit das on 09-09-2016
			
			
//			Added by dhananjay 15-Nov-2016		
			OpdPatientDetails patientDetails=inpatient.getOpdPatientDetails();
			if(null !=patientDetails ){
					if( null !=generalMap.get("period")){
						period=(Integer)generalMap.get("period");
						patientDetails.setPragnancyPeriod(period);
					}
					if(null !=generalMap.get("remarks")){
						remarks=(String)generalMap.get("remarks");
						patientDetails.setPhysiologicalStatusRemarks(remarks);
					}
					if(null !=generalMap.get("praganancy")){
						praganancy=(String)generalMap.get("praganancy");
						patientDetails.setPregnancy(praganancy);
					}
					if(null !=generalMap.get("lactation")){
						lactation=(String)generalMap.get("lactation");
						patientDetails.setLactation(lactation);
					}
					hbt.update(patientDetails);
			}
					// End 
			
			ipdPatientData.put("OpdPatientDetails", opdPatientDetails);
			//--------------For Mlc data-------------------------------
			if(mlcNameList.size()>0){
				for(int k=0;k<mlcNameList.size();k++){
					PatientWiseMlc patientWiseMlc = new PatientWiseMlc();
					patientWiseMlc.setMlcType(mlcNameList.get(k).toString());
					patientWiseMlc.setInpatient(inpatient);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					patientWiseMlc.setHospital(masHospital);
					patientWiseMlc.setOpdPatientDetail(opdPatientDetails);
					patientWiseMlc.setStatus("y");
					hbt.save(patientWiseMlc);
					
				 }
			}
			
			// --------------- values to be Opd Patient
			// History--------------------

			OpdPatientHistory opdPatientHistory = new OpdPatientHistory();
			
			if(wardreamarksList.size()>0){
				MasDepartment md = new MasDepartment();
				md.setId(referredDept);
				opdPatientHistory.setDepartment(md);
			}else{
				MasDepartment md = new MasDepartment();
				md.setId(box.getInt("deptId"));
				opdPatientHistory.setDepartment(md);
			}

			MasHospital mh = new MasHospital();
			mh.setId(box.getInt("hospitalId"));
			opdPatientHistory.setHospital(mh);

			Patient p = new Patient();
			p.setId(box.getInt("hinId"));
			opdPatientHistory.setHin(p);
			
			opdPatientHistory.setInpatient(inpatient);


			opdPatientHistory.setLastChgTime(consultationTime);
			Users user = new Users();
			user.setId(box.getInt("userId"));
			opdPatientHistory.setLastChgBy(user);

			opdPatientHistory.setStatus("y");
			opdPatientHistory.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
			
			if(box.getString("presentComplain")!=null)
			{
			opdPatientHistory.setPresentComplaintHistory(box.getString("presentComplain"));
			}
			if(box.getString("presentIllness")!=null)
			{
			opdPatientHistory.setPastIllnessHistory(box.getString("pastIllness"));
			}
			if(box.getString("personalHistory")!=null)
			{
			opdPatientHistory.setPersonalPresentHistory(box.getString("personalHistory"));
			}
			if(box.getString("familyHistory")!=null)
			{
			opdPatientHistory.setFamilyPastHistory(box.getString("familyHistory"));
			}
			if(box.get("medicationhistory")!=null)
			{
			opdPatientHistory.setMadicationHistory(box.getString("medicationhistory"));
			}


			opdPatientHistory.setIpOpPacStatus("IP");
			opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
			opdPatientHistory.setInpatient(inpatient);
			hbt.save(opdPatientHistory);
			ipdPatientData.put("OpdPatientHistory", opdPatientHistory);

			
			String query = "";
			List objectList = new ArrayList();
			Vector diagnosisIdAray = box.getVector("diagnosisId");
			if (diagnosisIdAray != null) {
				for (int i = 0; i < diagnosisIdAray.size(); i++) {
					DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
					dischargeIcdCode.setHin(p);
					MasIcd masIcd = new MasIcd();

					if (diagnosisIdAray.get(i) != null) {
						if (!diagnosisIdAray.get(i).equals("0")) {
							int icdid=0;
							try
							{
							
							String[] digId=((String)diagnosisIdAray.get(i)).split("@@@");	
							query = "select icd_id from mas_icd where icd_code='"
								+ digId[0] + "'";
							objectList = (List) session.createSQLQuery(query)
							.list();
							if(objectList.size()>0)
							{
								icdid=(Integer)objectList.get(0);
							}
							else
							{
								icdid=0;
							}
							
							}catch(Exception exception)
							{
								icdid=0;
								exception.printStackTrace();
							}
							if(icdid!=0)
							{
								List<DischargeIcdCode> dischargeIcdCodeList=new ArrayList<DischargeIcdCode>();
								dischargeIcdCodeList=session.createCriteria(DischargeIcdCode.class)
										.add(Restrictions.eq("Icd.Id", icdid))
										.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId"))).list();
								if(dischargeIcdCodeList.size()==0)
								{
								masIcd.setId(icdid);
								dischargeIcdCode.setIcd(masIcd);
								dischargeIcdCode
								.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
								dischargeIcdCode.setAddEditTime(consultationTime);
								dischargeIcdCode.setStatus("y");
								dischargeIcdCode.setDiagnosisStatus("p");
								dischargeIcdCode.setInpatient(inpatient);
								dischargeIcdCode.setHospital(masHospitalObj);
								dischargeIcdCode.setOpdPatientDetails(opdPatientDetails);
								hbt.save(dischargeIcdCode);
								ipdPatientData.put("DischargeIcdCode", dischargeIcdCode);
								}
							}
						}
					}
				}
			}

			int hdb = box.getInt("hdb");
			//added by govind 26-10-2017
			int taperHdb =0;
			if(box.get("taperedMedicineHdb")!=null){
				taperHdb=box.getInt("taperedMedicineHdb");
		    }
			List<TaperedMedicineUtil> taperUtilList=new ArrayList<TaperedMedicineUtil>();
			for (int i = 0; i <=hdb; i++)  {
			Integer itemId =0;
			if (box.get("nomenclaturetreatment" + i)!=null && !box.getString("nomenclaturetreatment" + i).equals("")) {

				 String nomencls = box.getString("nomenclaturetreatment" + i);
				 logger.info("nomenclaturetreatment "+nomencls);
				 
				 int index1 = nomencls.lastIndexOf("(");
					int index2 = nomencls.lastIndexOf(")");
					if(index1>=0 ){
						index1++;
						itemId = Integer.parseInt(nomencls.substring(index1,index2));
					}
						for(int t=1;t<=taperHdb;t++){
								if(box.get("taperedItemId"+i+"_"+t)!=null){
									Integer itemId2=box.getInt("taperedItemId"+i+"_"+t);
								if(itemId.equals(itemId2)){
									TaperedMedicineUtil tap=new TaperedMedicineUtil();
									tap.setItemId(box.getInt("taperedItemId"+i+"_"+t));
								if(box.get("taperedFrequency"+i+"_"+t)!=null){
									tap.setFrequency(box.getInt("taperedFrequency"+i+"_"+t));
								}
								if(box.get("taperedDosage"+i+"_"+t)!=null){
									tap.setDosage(box.getString("taperedDosage"+i+"_"+t));
								}
								if(box.get("taperedDosageCount"+i+"_"+t)!=null){
									tap.setDosageCount(new BigDecimal(box.getString("taperedDosageCount"+i+"_"+t)));
								}
								if(box.get("taperedDuration"+i+"_"+t)!=null){
									tap.setDuration(box.getInt("taperedDuration"+i+"_"+t));
								}
								if(box.get("total"+i+"_"+t)!=null){
									tap.setTotal(new BigDecimal(box.getString("total"+i+"_"+t)));
								}
								taperUtilList.add(tap);
							  }
							}
						}
					}
			}logger.info("taperUtilList "+taperUtilList.size());
     		//added by govind 26-10-2017 end
			String pvms = "";
			for (int l = 1; l <= hdb; l++) {
				if(box.getString("pvmsNotreatment"+l)!=null && !box.getString("pvmsNotreatment"+l).equals(""))
				{
				pvms = box.getString("pvmsNotreatment"+l);
				break;
				}
			}
			if (!pvms.equals("")) {
				
				InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
				//PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				inpatientPrescriptionHeader.setHin(p);
				if(wardreamarksList.size()>0){
					MasDepartment md = new MasDepartment();
					md.setId(referredDept);
					opdPatientHistory.setDepartment(md);
				}
				
				// else{
					MasDepartment md = new MasDepartment();
					md.setId(box.getInt("deptId"));
					inpatientPrescriptionHeader.setDepartment(md);
				// }
				inpatientPrescriptionHeader.setInpatient(inpatient);
				inpatientPrescriptionHeader.setHospital(masHospitalObj);
				inpatientPrescriptionHeader.setStatus("p");
				inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				inpatientPrescriptionHeader.setPrescriptionTime(consultationTime);
				inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
				inpatientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
				inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("treatmentdate")));
				inpatientPrescriptionHeader.setPrescriptionTime(box.getString("treatmenttime"));
				
				
//				need to be update after discussion
				int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
				inpatientPrescriptionHeader.setPrescriptionNo(String.valueOf(prescriptionNo));
				hbt.save(inpatientPrescriptionHeader);
				ipdPatientData.put("inpatientPrescriptionHeader", inpatientPrescriptionHeader);
				List<Object> inpatientPrescriptionDetailsListObject = new ArrayList<Object>();
				
				int item_class_id=0;//added by govind 22-09-2016
				int itemId= 0;
				String currentDate = (String)box.get("currentDate");
				Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
				//added by govind 22-09-2016 end 
				
				for (int i = 1; i <= hdb; i++) {
				
					
					if(box.getString("nomenclaturetreatment"+i)!=null && !box.getString("nomenclaturetreatment"+i).equals("")){
						
						int index1 = box.getString("nomenclaturetreatment"+i).lastIndexOf("[");
						 int index2 = box.getString("nomenclaturetreatment"+i).lastIndexOf("]");
						
						 index1++;
						String pvmsNo =box.getString("nomenclaturetreatment"+i).substring(index1, index2);
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
						if(box.getString("frequencytreatment"+i)!=null && !box.getString("frequencytreatment"+i).equals("") && box.getInt("frequencytreatment"+i)!=0)
						{
						masFrequency.setId(box.getInt("frequencytreatment"+i));
						inpatientPrescriptionDetails.setFrequency(masFrequency);
						}
						if(box.getString("dosagetreatment"+i)!=null && !box.getString("dosagetreatment"+i).equals(""))
						{
						inpatientPrescriptionDetails.setDosage(box.getFloat("dosagetreatment"+i));
						}
						if(box.getString("spslinstructiontreatment"+i)!=null && !box.getString("spslinstructiontreatment"+i).equals("") )
						{
						inpatientPrescriptionDetails.setSplInstruction(box.getString("spslinstructiontreatment"+i));
						}
						if(box.getString("noOfDaystreatment"+i)!=null && !box.getString("noOfDaystreatment"+i).equals(""))
						{
						inpatientPrescriptionDetails.setNoOfDays(box.getInt("noOfDaystreatment"+i));
						}
						inpatientPrescriptionDetails.setType("IP");
						
						if(box.getString("instructiontreatment"+i)!=null && !box.getString("instructiontreatment"+i).equals("") && box.getInt("instructiontreatment"+i)!=0)
						{
						OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment();
						instructionTreatment.setId(box.getInt("instructiontreatment"+i));
						inpatientPrescriptionDetails.setInsrtuction(instructionTreatment);
						}

						RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
						if(box.getString("routetreatment"+i)!=null && !box.getString("routetreatment"+i).equals("")  && box.getInt("routetreatment"+i)!=0)
						{
						routeOfAdministration.setId(box.getInt("routetreatment"+i));
						inpatientPrescriptionDetails.setRoute(routeOfAdministration);
						}
						
						inpatientPrescriptionDetails.setTotal(box.getFloat("totaltreatment"+i));
						inpatientPrescriptionDetails.setStopMedicine("n");
						
						
						inpatientPrescriptionDetails.setActualTotal(box.getFloat("actualTotalAfterMix"+i)); // added by amit das on 19-11-2016
						
						inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader);
						inpatientPrescriptionDetails.setIssuedStatus("p");
						
						//added by govind 22-9-2016
						
						List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
						itemIdListNew = getItemIdFromPVMS(pvmsNo);
							itemId=itemIdListNew.get(0).getId();
							
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
							
							inpatientPrescriptionDetails.setNotAvailable("y");
							inpatientPrescriptionDetails.setInjectionStatus("y");
						}else{
							
							inpatientPrescriptionDetails.setNotAvailable("n");
							inpatientPrescriptionDetails.setInjectionStatus("n");
						}
						//added by govind 22-9-2016
						hbt.save(inpatientPrescriptionDetails);
						inpatientPrescriptionDetailsListObject.add(inpatientPrescriptionDetails);
						//added by govind 26-10-2017
						for(TaperedMedicineUtil tapUtil:taperUtilList){
							if(tapUtil.getItemId().equals(item.getId())){
							
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
						
						//added by govind 22-9-2016 start
						if(storeItemList.size() > 0){
							
							InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
							
							injectionAppointment.setHin(p);
						
							injectionAppointment.setHospital(mh);							
							injectionAppointment.setStatus("p");
							injectionAppointment.setLastChgTime(time);
							injectionAppointment.setLastChgBy(user);
							injectionAppointment.setLastChgDate(date);
							injectionAppointment.setInpatientPrescriptionHeader(inpatientPrescriptionHeader);
							injectionAppointment.setInpatient(inpatient);
							hbt.save(injectionAppointment);
							
							
							//start adding injAppointmentDetails data
							InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
							//injAppointmentDetails.setAppointmentTime(time);
							injAppointmentDetails.setInjAppointmentDate(new Date());
							injAppointmentDetails.setDose(""+box.getFloat("dosagetreatment"+i));
													
							injAppointmentDetails.setFrequency(masFrequency);
							injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
							
							 
							MasStoreItem item1 = new MasStoreItem();
							item1.setId(itemId);
							if(!checkForInsulinInjection(itemId)){								
							
							injAppointmentDetails.setItem(item1);
							injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
							injAppointmentDetails.setInpatientPrescriptionDetails(inpatientPrescriptionDetails);
							injAppointmentDetails.setNoOfDays(box.getInt("noOfDaystreatment"+i));
							injAppointmentDetails.setStatus("p");
							injAppointmentDetails.setFinalStatus("n");
							hbt.save(injAppointmentDetails);
						}
						}
						//added by govind 22-9-2016 end
						}
					}
				
				}
				ipdPatientDataList.put("inpatientPrescriptionDetailsListObject", inpatientPrescriptionDetailsListObject);
			
				
			}
			
			//added by govind 21-03-2017 for get IP medicine in Discharge Medication
			if(!box.getString("readyToDischarge").equals("")){
				int DMhdb = box.getInt("DMhdb");
				String DMpvms = "";
				consultationTime=(String)utilMap.get("currentTime");
				int visitId=0;
				 PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
				if(DMhdb>0) {
					Map<String,Object> visitMap=new HashMap<String,Object>();
					Map<String,Object> mapForVisit=new HashMap<String,Object>();
					List<String> serviceCentreList=new ArrayList<String>();
					int pharmacyDepartmentId = 0;
			        if(properties.getProperty("pharmacyDepartmentId")!=null){
			        	pharmacyDepartmentId =Integer.parseInt(properties.getProperty("pharmacyDepartmentId"));
			        }
					serviceCentreList.add(String.valueOf(pharmacyDepartmentId));
					
					String currentDate = (String)utilMap.get("currentDate");
					
					int hospitalId = box.getInt("hospitalId");
					int hinId = box.getInt("hinId");
					mapForVisit.put("departmentIdlist",serviceCentreList);
					mapForVisit.put("hinId", hinId);
					mapForVisit.put("hospitalId",hospitalId);
					mapForVisit.put("visitDate",new Date());
					mapForVisit.put("age",inpatient.getAge()!=null?inpatient.getAge():"");
					List<String> masSessionList= registrationDataService.getSessionForDepartment(pharmacyDepartmentId,box.getInt("hospitalId"));
					String[] sessionData=masSessionList.get(0).split(":");
					int opsessionId = Integer.parseInt(sessionData[0]);
					int visitNo =0;
					List<Visit> visitList=session.createCriteria(Visit.class)
								.createAlias("Hin", "hin")
					    		.add(Restrictions.eq("hin.Id",hinId))
					    		.addOrder(Order.desc("Id"))
					    		.list();
						if(visitList.size()>0)
							visitNo=visitList.get(0).getVisitNo()+1;
						else
							visitNo=1;
					
					MasDepartment department=new MasDepartment();
					Visit visit=new Visit();
					department.setId(pharmacyDepartmentId);
					visit.setDepartment(department);
					visit.setPriorityNumber(3);
					
					Patient patient=new Patient();
					patient.setId(hinId);
					visit.setHin(patient);
					
					 boolean ispreviouesToken=false;
					int totalHospitalVisitNo = 0;
					 	map=registrationDataService.getTotalVistByHospital(hospitalId, pharmacyDepartmentId, HMSUtil.convertStringTypeDateToDateType(currentDate), hinId,opsessionId,box.getString("hospitalCode"));
						//}
						if(null !=map.get("ispreviouesToken")){
							ispreviouesToken=(Boolean)map.get("ispreviouesToken");
						}
						if(null !=map.get("TotaltokenNo")){
							totalHospitalVisitNo=(Integer)map.get("TotaltokenNo");
						}
						if(!ispreviouesToken){
						totalHospitalVisitNo=totalHospitalVisitNo;
						}
						
						visit.setTotalHospitalVisit( (int)totalHospitalVisitNo);
						
						long maxTokenNo = 0;
						String departmentType="";
						boolean status=false;
						Map<String, Object> requestMap = new HashMap<String,Object>();
						requestMap.put("hospital", masHospitalObj);
						requestMap.put("visitSessionId", opsessionId);
						requestMap.put("deptId", pharmacyDepartmentId);
						requestMap.put("vDate", HMSUtil.convertStringTypeDateToDateType(currentDate));
					
						
						departmentType="P";
							
								
						visit.setAppointmentType("D");
						visit.setHospital(masHospitalObj);
						maxTokenNo =registrationDataService.getTokenNoForDepartment(requestMap);

						int tokenNo = (int)maxTokenNo;

				
				if(opsessionId>0){
					MasSession masSession=new MasSession();
					masSession.setId(opsessionId);
					visit.setVisitSession(masSession);
				}
						
					visit.setTokenNo(tokenNo);
					Users users = new Users();
					users.setId(box.getInt("userId"));
					visit.setAddEditBy(users);
					visit.setAge(inpatient.getAge()!=null?inpatient.getAge():"");
					SimpleDateFormat sdTime = new SimpleDateFormat("HH:mm");
		    	    Date current = new Date();
		    	    String times = sdTime.format(current);
					visit.setVisitTime(times);

					
					SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

		    	    Date now = new Date();

		    	    String currentTime = sdfTime.format(now);


					visit.setOpVisitTime(currentTime);
					visit.setVisitDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					visit.setVisitNo(visitNo);
					visit.setStatus("y");
					visit.setEdStatus("n");
					visit.setVisitStatus("w");
					visit.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					visit.setAddEditTime(time);
					visit.setCurPharVisitStatus("Y");
				
					
					visit.setDisplayAfterNo(visit.getTokenNo()-1); // added by amit das on 21-07-2017
					visit.setLastDisplayAfterNo(visit.getTokenNo()-1);
					
					if(masHospitalObj!=null && masHospitalObj.getClientIp()!=null && !masHospitalObj.getClientIp().trim().equals("") && !masHospitalObj.getClientIp().trim().equals("null") && masHospitalObj.getClientPort()!=null && !masHospitalObj.getClientPort().trim().equals("") && !masHospitalObj.getClientPort().trim().equals("null")){
						visit.setCreationSource("C");
					}else if(masHospitalObj!=null && masHospitalObj.getServerIp()!=null && !masHospitalObj.getServerIp().trim().equals("") && !masHospitalObj.getServerIp().trim().equals("null") && masHospitalObj.getServerPort()!=null && !masHospitalObj.getServerPort().trim().equals("") && !masHospitalObj.getServerPort().trim().equals("null")){
						visit.setCreationSource("L");
					}
					
					hbt.save(visit);
					PharmacyLabQueue phlabRadioQueue=registrationDataService.saveQueueNoForPharmacy(pharmacyDepartmentId,hospitalId, visit,departmentType,tokenNo);
					hbt.save(phlabRadioQueue);
						
						patientPrescriptionHeader.setHin(p);
						if(wardreamarksList.size()>0){
							MasDepartment md = new MasDepartment();
							md.setId(referredDept);
							opdPatientHistory.setDepartment(md);
						}

						MasDepartment md = new MasDepartment();
						md.setId(pharmacyDepartmentId);
						patientPrescriptionHeader.setDepartment(md);
						
						patientPrescriptionHeader.setVisit(visit);
						patientPrescriptionHeader.setHospital(masHospitalObj);
						patientPrescriptionHeader.setStatus("p");
						patientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						patientPrescriptionHeader.setPrescriptionTime(consultationTime);
						patientPrescriptionHeader.setPrescriptionBy(masEmployee);
						patientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
						patientPrescriptionHeader.setDischargeMedicationStatus("Y");;
						patientPrescriptionHeader.setInpatient(inpatient);
						int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
						patientPrescriptionHeader.setPrescriptionNo(String.valueOf(prescriptionNo));
						patientPrescriptionHeader.setPharmacyLabQueue(phlabRadioQueue);
						hbt.save(patientPrescriptionHeader);
						ipdPatientData.put("patientPrescriptionHeader", patientPrescriptionHeader);
					 
				}
				for (int i = 1; i <= DMhdb; i++) {
					if(box.getString("DMpvmsNotreatment"+i)!=null && !box.getString("DMpvmsNotreatment"+i).equals(""))
					{
						DMpvms = box.getString("DMpvmsNotreatment"+i);
					}

					if (!DMpvms.equals("")) {		

						//for (int i = 1; i <= DMhdb; i++) {
						if(box.getString("DMnomenclaturetreatment"+i)!=null && !box.getString("DMnomenclaturetreatment"+i).equals("")){						
							String gtime=consultationTime;
							String ab[]=gtime.split(":");
							int join=Integer.parseInt(ab[1])+1;
							gtime=ab[0]+":"+join;
							consultationTime = gtime;
							//InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
							
							List<Object> inpatientPrescriptionDetailsListObject = new ArrayList<Object>();

							int item_class_id=0;//added by govind 22-09-2016
							int itemId= 0;
							String currentDate = (String)box.get("currentDate");
							Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
							//added by govind 22-09-2016 end 



							int index1 = box.getString("DMnomenclaturetreatment"+i).lastIndexOf("[");
							int index2 = box.getString("DMnomenclaturetreatment"+i).lastIndexOf("]");

							index1++;
							String pvmsNo =box.getString("DMnomenclaturetreatment"+i).substring(index1, index2);
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
								//	InpatientPrescriptionDetails inpatientPrescriptionDetails=new InpatientPrescriptionDetails();
								PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();
								
								patientPrescriptionDetails.setItem(item);
								MasFrequency masFrequency = new MasFrequency();
								masFrequency.setId(box.getInt("DMfrequencytreatment"+i));
								patientPrescriptionDetails.setFrequency(masFrequency);
								patientPrescriptionDetails.setDosage(box.getFloat("DMdosagetreatment"+i));
								patientPrescriptionDetails.setSplInstruction(box.getString("DMspslinstructiontreatment"+i));
								patientPrescriptionDetails.setNoOfDays(box.getInt("DMnoOfDaystreatment"+i));
								patientPrescriptionDetails.setType("IP");

								if(box.getString("DMinstructiontreatment"+i)!=null && !box.getString("DMinstructiontreatment"+i).equals("") && box.getInt("DMinstructiontreatment"+i)!=0)
								{
									OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment();
									instructionTreatment.setId(box.getInt("DMinstructiontreatment"+i));
									patientPrescriptionDetails.setInsrtuction(instructionTreatment);
								}

								RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
								if(box.getString("DMroutetreatment"+i)!=null && !box.getString("DMroutetreatment"+i).equals("")  && box.getInt("DMroutetreatment"+i)!=0)
								{
									routeOfAdministration.setId(box.getInt("DMroutetreatment"+i));
									patientPrescriptionDetails.setRoute(routeOfAdministration);
								}

								patientPrescriptionDetails.setTotal(box.getFloat("DMtotaltreatment"+i));


								patientPrescriptionDetails.setActualTotal(box.getFloat("actualTotalAfterMix"+i)); // added by amit das on 19-11-2016

								//						patientPrescriptionDetails.setGivenQty(0);
								patientPrescriptionDetails.setPrescription(patientPrescriptionHeader);
								patientPrescriptionDetails.setIssuedStatus("p");

								//added by govind 22-9-2016

								List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
								itemIdListNew = getItemIdFromPVMS(pvmsNo);
								itemId=itemIdListNew.get(0).getId();

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

									patientPrescriptionDetails.setNotAvailable("y");
									patientPrescriptionDetails.setInjectionStatus("y");
								}else{

									patientPrescriptionDetails.setNotAvailable("n");
									patientPrescriptionDetails.setInjectionStatus("n");
								}
								//added by govind 22-9-2016
								hbt.save(patientPrescriptionDetails);
								inpatientPrescriptionDetailsListObject.add(patientPrescriptionDetails);

								//added by govind 22-9-2016 start
								if(storeItemList.size() > 0){

									InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();

									injectionAppointment.setHin(p);
									injectionAppointment.setHospital(mh);							
									injectionAppointment.setStatus("p");
									injectionAppointment.setLastChgTime(time);
									injectionAppointment.setLastChgBy(user);
									injectionAppointment.setLastChgDate(date);
									injectionAppointment.setPrescription(patientPrescriptionHeader);
									injectionAppointment.setInpatient(inpatient);
									hbt.save(injectionAppointment);


									//start adding injAppointmentDetails data
									InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
									//injAppointmentDetails.setAppointmentTime(time);
									injAppointmentDetails.setInjAppointmentDate(new Date());
									injAppointmentDetails.setDose(""+box.getFloat("DMdosagetreatment"+i));

									injAppointmentDetails.setFrequency(masFrequency);
									injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());


									MasStoreItem item1 = new MasStoreItem();
									item1.setId(itemId);
									if(!checkForInsulinInjection(itemId)){								

										injAppointmentDetails.setItem(item1);
										injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
										injAppointmentDetails.setPrescriptionDetails(patientPrescriptionDetails);
										injAppointmentDetails.setNoOfDays(box.getInt("DMnoOfDaystreatment"+i));
										injAppointmentDetails.setStatus("p");
										injAppointmentDetails.setFinalStatus("n");
										hbt.save(injAppointmentDetails);
									}
								}
								//added by govind 22-9-2016 end
							}

						}

						//}

					}
				}
			}
			//added by govind 21-03-2017 end
			
			int hiddenValue = box.getInt("hiddenValue");
			String chargeCodeName = "";
			for (int l = 1; l <= hiddenValue; l++) {
				
				
				if(box.getString("chargeCodeName"+l)!=null && !box.getString("chargeCodeName"+l).equals("")){
					chargeCodeName = box.getString("chargeCodeName"+l);
					break;
				}
			}
			if (!chargeCodeName.equals("")) {

				PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
				patientInvestigationHeader.setHin(p);
				if(wardreamarksList.size()>0){
					MasDepartment md = new MasDepartment();
					md.setId(referredDept);
					patientInvestigationHeader.setDepartment(md);
				}else{
					MasDepartment md = new MasDepartment();
					md.setId(box.getInt("deptId"));
					patientInvestigationHeader.setDepartment(md);
				}
				patientInvestigationHeader.setInpatient(inpatient);
				patientInvestigationHeader.setHospital(masHospitalObj);
				patientInvestigationHeader.setStatus("p");
				patientInvestigationHeader.setInvestigationDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("investigationdate")));
				patientInvestigationHeader.setInvestigationTime(box.getString("investigationtime"));
//				patientInvestigationHeader.setClinicalNote(box.getString("clinicalNotes1"));
				patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);
				patientInvestigationHeader.setInvestigationBy(masEmployee);
				hbt.save(patientInvestigationHeader);
				ipdPatientData.put("patientInvestigationHeader", patientInvestigationHeader);
				DgOrderhd dgOrderhd = new DgOrderhd();
				dgOrderhd.setOrderDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("investigationdate")));
				dgOrderhd.setOrderTime(box.getString("investigationtime"));
				dgOrderhd.setHospital(masHospitalObj);
				dgOrderhd.setInpatient(inpatient);
				dgOrderhd.setHin(p);
				if(wardreamarksList.size()>0){
					MasDepartment md = new MasDepartment();
					md.setId(referredDept);
					dgOrderhd.setDepartment(md);
				}else{
					MasDepartment md = new MasDepartment();
					md.setId(box.getInt("deptId"));
					dgOrderhd.setDepartment(md);
				}
				dgOrderhd.setPrescribedBy(masEmployee);
				dgOrderhd.setPatientType("IP");
				dgOrderhd.setTestType("Regular");
				
                //need discussion
				
//				String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
				String orderSeqNo = labDataService.generateOrderNumber();
				
				dgOrderhd.setOrderNo(orderSeqNo);

//				dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
				dgOrderhd.setOrderStatus("P");
				//dgOrderhd.setLabOrderStatus("P");
				dgOrderhd.setLastChgBy(user);
				dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				dgOrderhd.setLastChgTime(consultationTime);
				dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
				
				DgSampleCollectionHeader collHeader = null;
				hbt.save(dgOrderhd);
				ipdPatientData.put("dgOrderhd", dgOrderhd);
				List<Object> patientInvestigatinDetailsListObject = new ArrayList<Object>();
				List<Object> dgOrderDetailsListObject = new ArrayList<Object>();
				List<Object> dgSampleCollectionDeatilsListObject=new ArrayList<Object>();
				
				float totalPkgAmount = 0.00f; // Added by Amit Das
				float totalPkgServiceAmount = 0.00f; // Added by Amit Das
				
				// added by AMit Das on 09-03-2016
				for (int i = 1; i <= hiddenValue; i++) {					
					if((box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")) &&
							(box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals(""))){
						
						String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
						int index1 = chargeCodeNameWithId.lastIndexOf("[");
						int index2 = chargeCodeNameWithId.lastIndexOf("]");
						index1++;
						String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
						MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
						totalPkgServiceAmount = totalPkgServiceAmount+ chargeCode.getCharge();
					}
					
				}
				
				// added by AMit Das on 10-03-2016
				if(box.getFloat("pkgCharge")!=0)
					totalPkgAmount = box.getFloat("pkgCharge");
				
				// added by Amit Das on 08-03-2016 for adding pkg service in bl_charge_slip_main and bl_charge_slip_details

				BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
				if(totalPkgAmount>0.00f) {
				Patient patient = new Patient();
				patient.setId(p.getId());
				blChargeSlipMain.setHin(patient);
				blChargeSlipMain.setInpatient(inpatient);
				MasHospital hospital = new MasHospital();

				hospital.setId(box.getInt("hospitalId"));
				blChargeSlipMain.setHospital(hospital);

				blChargeSlipMain.setChargeSlipNo(box.getInt("chargeSlipNo"));
				blChargeSlipMain.setChgSlpAmt(new BigDecimal(totalPkgAmount));
				blChargeSlipMain.setNetAmt(new BigDecimal(totalPkgAmount));
				blChargeSlipMain.setDiscount(new BigDecimal(totalPkgAmount));
				blChargeSlipMain.setDiscountAmt(new BigDecimal(totalPkgServiceAmount)); 
				blChargeSlipMain.setReceiptAmt(new BigDecimal(totalPkgAmount));
				blChargeSlipMain.setPayStatus("P");
				Users user1 = new Users();
				user1.setId(box.getInt("userId"));
				blChargeSlipMain.setLastChgBy(user1);
				blChargeSlipMain.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(consultationDate));
				blChargeSlipMain.setLastChgTime(consultationTime);
				blChargeSlipMain.setChgSlpDate(HMSUtil
						.convertStringTypeDateToDateType(consultationDate));
				blChargeSlipMain.setChgSlpTime(consultationTime);
				blChargeSlipMain.setStatus("y");
				if(box.getInt("pkgId")!=0){
					BlPackageHeader blPackageHeader = new BlPackageHeader();
					blPackageHeader.setId(box.getInt("pkgId"));
					blChargeSlipMain.setPackage(blPackageHeader);
				}
				
				hbt.save(blChargeSlipMain);
				
				
				// Added By Amit Das on 08-03-2016
				// ---------------Updating data into RsbyCardDetails Table 
				int pkgSchemeId = box.getInt("pkgScheme");
				String rsbyCardNo = box.getString("rsbyCardNo");
				if(pkgSchemeId!=0 && rsbyCardNo!=null){
					MasScheme pkgScheme = new MasScheme();
					pkgScheme.setId(pkgSchemeId);
				List<RsbyCardDetails> rsbyCardDetailsList =	session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("PkgScheme", pkgScheme)).add(Restrictions.eq("RsbyCardNo", rsbyCardNo)).list();
				if(rsbyCardDetailsList!=null && rsbyCardDetailsList.size()!=0){
						RsbyCardDetails cardDetails = rsbyCardDetailsList.get(0);
						cardDetails.setBalanceUtilized(cardDetails.getBalanceUtilized().add(new BigDecimal(totalPkgAmount)));
						hbt.update(cardDetails);
				 } else{
					    RsbyCardDetails cardDetails = new RsbyCardDetails();
						cardDetails.setBalanceUtilized(new BigDecimal(totalPkgAmount));
						cardDetails.setRsbyCardNo(rsbyCardNo);
						cardDetails.setStatus("Y");
						hbt.save(cardDetails);
				 }
				}
				
				
				
				for (int i = 1; i <= hiddenValue; i++) {					
						if((box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals("")) &&
								(box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")) ){	
							BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
							blChargeSlipDetail.setHospital(hospital);
							String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
							int index1 = chargeCodeNameWithId.lastIndexOf("[");
							int index2 = chargeCodeNameWithId.lastIndexOf("]");
							index1++;
							String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
							
							MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
							
							blChargeSlipDetail.setChargeCode(chargeCode);

							BigDecimal rate = new BigDecimal(chargeCode.getCharge());
							blChargeSlipDetail.setRate(rate);
							blChargeSlipDetail.setAmt(rate);

							blChargeSlipDetail.setQuantity(1);

							blChargeSlipDetail.setDiscountPercent(new BigDecimal(
										100));

							blChargeSlipDetail.setDiscountAmt(rate);
							blChargeSlipDetail.setNetAmt(rate);

							//blChargeSlipDetail.setNetAmt(new BigDecimal(box.getString(NET_AMOUNT + i)));
							
							Users user2 = new Users();
							user2.setId(box.getInt("userId"));
							blChargeSlipDetail.setLastChgBy(user2);
							blChargeSlipDetail.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(consultationDate));
							blChargeSlipDetail.setLastChgTime(consultationTime);
							blChargeSlipDetail.setStatus("y");
							
							blChargeSlipDetail.setChargeSlipMain(blChargeSlipMain);
							blChargeSlipDetail.setRefundableStatus("y");
							blChargeSlipDetail.setInPkgFlag("y");
							try {
								hbt.save(blChargeSlipDetail);
							} catch (RuntimeException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
				/*end of code by Amit Das*/
				
				
				for (int i = 1; i <= hiddenValue; i++) {					
					if(box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals("")){
						
						
						String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
						int index1 = chargeCodeNameWithId.lastIndexOf("[");
						int index2 = chargeCodeNameWithId.lastIndexOf("]");
						index1++;
						String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
						MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
						
					PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
					patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(Integer.parseInt(chargeCodeId));
					patientInvestigationDetails.setChargeCode(masChargeCode);
					patientInvestigationDetails.setQuantity(1);   // default quantity is 1
					patientInvestigationDetails.setClinicalNotes(box.getString("chargecodeclinicalnote" + i));
					//patientInvestigationDetails.setReferToMh(box.getString("referToMh"+i));

					hbt.save(patientInvestigationDetails);
					patientInvestigatinDetailsListObject.add(patientInvestigationDetails);
					DgOrderdt dgOrderdt = new DgOrderdt();
					dgOrderdt.setOrderhd(dgOrderhd);
					masChargeCode.setId(Integer.parseInt(chargeCodeId));
					dgOrderdt.setChargeCode(masChargeCode);
					dgOrderdt.setOrderQty(1);

					dgOrderdt.setLastChgBy(user);
					dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					dgOrderdt.setLastChgTime(consultationTime);
					// method written for taking out the values of mascharge
					// code and subcharge
					List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
					masChargeList = session.createCriteria(MasChargeCode.class).add(
							Restrictions.eq("Id", Integer.parseInt(chargeCodeId))).list();

					MasChargeCode masChargeCodeObj = masChargeList.get(0);
					int mainChargeId = masChargeCodeObj.getMainChargecode()
					.getId();
					int subChargeId = masChargeCodeObj.getSubChargecode()
					.getId();
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
					
					// added by Amit Das For pkg services
					if(box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")){
						dgOrderdt.setInPkgFlag("y");
						dgOrderdt.setPaymentMade("y");
						dgOrderdt.setAmount(new BigDecimal(masChargeCodeObj.getCharge()));
						if(blChargeSlipMain.getId()!=null)
							dgOrderdt.setChargeSlip(blChargeSlipMain);
					} else {
						dgOrderdt.setPaymentMade("n");
					}
					
//					dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeId)));
					//dgOrderdt.setInvestigationToMH("n");
					//dgOrderdt.setReferToMh(box.getString("referToMh"+i));
					hbt.save(dgOrderdt);
					dgOrderDetailsListObject.add(dgOrderdt);
					if (chargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO")) {
					
						
						
						if(collHeader==null)
						{
						collHeader=new DgSampleCollectionHeader();
						collHeader.setHin(p);
						collHeader.setInpatient(inpatient);

						if (chargeCode!= null) {
							collHeader.setDepartment(chargeCode.getDepartment());
						}
						collHeader.setHospital(masHospitalObj);
						collHeader.setOrder(dgOrderhd);
						collHeader.setDiagnosisDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("investigationdate")));
						collHeader.setDiagnosisTime(box.getString("investigationtime"));
						collHeader.setOrderStatus("P");
						collHeader.setLastChgBy(user);
						collHeader.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
						collHeader.setLastChgTime(consultationTime);
						hbt.save(collHeader);
						ipdPatientData.put("DgSampleCollectionHeader", collHeader);

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
							sampleDetails.setLastChgBy(user);
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
							investigation.setId(Integer.parseInt(chargeCodeId));
							sampleDetails.setInvestigation(investigation);
							sampleDetails.setSampleCollDatetime(new Date());
							hbt.save(sampleDetails);
							dgSampleCollectionDeatilsListObject.add(sampleDetails);
						
					}
						
					
				  }
				}
				
				
				
				
				
				ipdPatientDataList.put("patientInvestigatinDetailsListObject", patientInvestigatinDetailsListObject);
				ipdPatientDataList.put("dgOrderDetailsListObject", dgOrderDetailsListObject);
				ipdPatientDataList.put("dgSampleCollectionDeatilsListObject", dgSampleCollectionDeatilsListObject);
				
			}

			/**
			 * For Procedures
			 */
			
			
			
			
			
			
			
			/*int proscedurehiddenValue = box.getInt("procCount");
			String proscedureName = "";
			for (int l = 1; l <= proscedurehiddenValue; l++) {
				if( box.getString("procedure"+l)!=null &&  !box.getString("procedure"+l).equals(""))
				{
					proscedureName = box.getString("procedure"+l);
				break;
				}
			}
			if (!proscedureName.equals("")) {
				List<TransactionSequence> sequenceNoList = new ArrayList<TransactionSequence>();
				OpdSurgeryHeader opdSurgeryHeader=new OpdSurgeryHeader();
				opdSurgeryHeader.setHin(p);
				opdSurgeryHeader.setInpatient(inpatient);
				opdSurgeryHeader.setEmployee(masEmployee);
				opdSurgeryHeader.setPrescribedDepartment(md);
				opdSurgeryHeader.setHospital(masHospitalObj);
				opdSurgeryHeader.setRequisitionDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("proceduredate")));
				opdSurgeryHeader.setRequisitionTime(box.getString("proceduretime"));
				opdSurgeryHeader.setPatientStatus("InPatient");
				opdSurgeryHeader.setPacStatus("Pending");
				opdSurgeryHeader.setBillingStatus("Pending");
				opdSurgeryHeader.setBillingStatus("n");
				 String transactionSequenceName = "Surgery Requisition No";
				 sequenceNoList = session
	                        .createCriteria(TransactionSequence.class)
	                        .add(Restrictions.eq("TransactionSequenceName",
	                                transactionSequenceName)).list();
	                TransactionSequence transactionSequence = (TransactionSequence) sequenceNoList
	                        .get(0);
				  int orderNo = transactionSequence
	                        .getTransactionSequenceNumber();
	                orderNo = orderNo + 1;
	                int id = transactionSequence.getId();
	                TransactionSequence transactionSequence2 = (TransactionSequence) hbt
	                        .load(TransactionSequence.class, id);
	                transactionSequence2.setTransactionSequenceNumber(orderNo);
	                hbt.update(transactionSequence2);
	                opdSurgeryHeader.setOrderNo(orderNo);
	                hbt.save(opdSurgeryHeader);
				for (int i = 1; i <= proscedurehiddenValue; i++) {
					if(box.getString("procedure" + i)!=null && !box.getString("procedure" + i).equals("")){
						OpdSurgeryDetail opdSurgeryDetail=new OpdSurgeryDetail();
						MasChargeCode masChargeCode=new MasChargeCode();
						masChargeCode.setId(box.getInt("procedureId"+i));
						opdSurgeryDetail.setChargeCode(masChargeCode);
						opdSurgeryDetail.setOpdSurgery(opdSurgeryHeader);
						opdSurgeryDetail.setTentativeDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("procedureTentativedate"+i)));
						opdSurgeryDetail.setRemarks(box.getString("procRemarks"+i));
					hbt.save(opdSurgeryDetail);
					}
				}
			}*/
			
			
			
			
			int i = 0;
			int count=box.getInt("nursingcarecount");
			List<Object> nursingcareSetupListObject = new ArrayList<Object>();
			List<Object> nursingcareHistoryListObject = new ArrayList<Object>();
			for (int j = 1; j <= count; j++) {
				if(box.getString("careTypeId"+j)!=null && !box.getString("careTypeId"+j).equals("") && box.getInt("careTypeId"+j)!=0)
				{
					NursingcareSetup nursingcareSetup = null;
					
					List<NursingcareSetup> nursingcareSetups=new ArrayList<NursingcareSetup>();
				
					nursingcareSetups = session.createCriteria(NursingcareSetup.class)
							.add(Restrictions.eq("Nursing.Id", box.getInt("careTypeId"+j)))
							.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
							.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
					
					if(nursingcareSetups.size()==0)
					{
					nursingcareSetup = new NursingcareSetup();
					MasNursingCare masNursingCare = new MasNursingCare();
					masNursingCare.setId(box.getInt("careTypeId"+j));
					nursingcareSetup.setNursing(masNursingCare);

//					nursingcareSetup.setAdNo(admissionNumber);
				
					nursingcareSetup.setLastChgBy(user);
					nursingcareSetup.setLastChgTime(consultationTime);
					nursingcareSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					nursingcareSetup.setHin(p);
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("frequency"+j));
					nursingcareSetup.setFrequency(masFrequency);
					nursingcareSetup.setInpatient(inpatient);
					nursingcareSetup.setHospital(masHospitalObj);
					nursingcareSetup.setRemarks(box.getString("careremarks"+j));
					
					NursingcareSetupHistory history=new NursingcareSetupHistory();
					history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					history.setStartTime(consultationTime);
					history.setNursingcareSetup(nursingcareSetup);
					if(!box.getString("carestop"+j).equals(""))
					{
						nursingcareSetup.setStopCare("y");
						history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						history.setEndTime(consultationTime);
					}
					else
					{
						nursingcareSetup.setStopCare("n");
					}
					hbt.save(nursingcareSetup); 
					hbt.save(history);
					nursingcareSetupListObject.add(nursingcareSetup);
					nursingcareHistoryListObject.add(history);
					}
					else
					{
						
						//added by govind 2-12-2016
						if(nursingcareSetups.size()>0)
						{
						int careStopId=0;
						careStopId=Integer.parseInt(box.getString("carestop_id"+j));
						NursingcareSetup nurCare = (NursingcareSetup) hbt.load(NursingcareSetup.class, careStopId);	
												
						if(box.getString("carestop"+j).equals("1")){	
							nurCare.setStopCare("y");
							hbt.update(nurCare);
						}
												
						}						
						//added by govind 2-12-2016 end
						
						nursingcareSetup=nursingcareSetups.get(0);
						MasNursingCare masNursingCare = new MasNursingCare();
						masNursingCare.setId(box.getInt("careTypeId"+j));
						nursingcareSetup.setNursing(masNursingCare);					
						nursingcareSetup.setLastChgBy(user);
						nursingcareSetup.setLastChgTime(consultationTime);
						nursingcareSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("frequency"+j));
						nursingcareSetup.setFrequency(masFrequency);
						nursingcareSetup.setRemarks(box.getString("careremarks"+j));
						
						NursingcareSetupHistory history=null;
						
						if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("y"))
						{
							if(!box.getString("vitalstop"+j).equals(""))
							{
								
							}
							else
							{
								history=new NursingcareSetupHistory();
								//nursingcareSetup.setStopCare("n");
								history.setNursingcareSetup(nursingcareSetup);
								history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
								history.setStartTime(consultationTime);
							}
						}
						if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("n"))
						{
							 
							 if(!box.getString("vitalstop"+j).equals(""))
								{
								 
								 List<NursingcareSetupHistory> nursingcareSetupHistories=new ArrayList<NursingcareSetupHistory>();						
									nursingcareSetupHistories = session.createCriteria(NursingcareSetupHistory.class,"ncsh")
											.createAlias("NursingcareSetup", "ncs")
											.createAlias("ncs.Inpatient", "ncsi")
											.createAlias("ncs.Hospital", "ncsho")
											.add(Restrictions.eq("ncs.Id", nursingcareSetup.getId()))
											.add(Restrictions.eq("ncsi.Id", box.getInt("inpatientId")))
											.add(Restrictions.eq("ncsho.Id", box.getInt("hospitalId")))
											.add(Restrictions.isNotNull("ncsh.StartDate"))
											.addOrder(Order.desc("Id")).list();									
									if(nursingcareSetupHistories.size()>0)
									{
									history=nursingcareSetupHistories.get(0);
									//nursingcareSetup.setStopCare("y");
									history.setNursingcareSetup(nursingcareSetup);
									history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
									history.setEndTime(consultationTime);
									}
								}
						}
						hbt.save(nursingcareSetup); 
						if(history!=null)
						{
						hbt.save(history);
						}	
						nursingcareSetupListObject.add(nursingcareSetup);
						nursingcareHistoryListObject.add(history);
					}
				}
			}
			ipdPatientDataList.put("nursingcareSetupListObject", nursingcareSetupListObject);
			ipdPatientDataList.put("nursingcareHistoryListObject", nursingcareHistoryListObject);
			
			
		/*
		 * By Ujjwal to Save Vitals
		 * on 07012016
		 * at 12:19 pm
		 */
			
			int vitalCount=box.getInt("vitalcarecount");
			List<Object> ipdVitalSetupListObject = new ArrayList<Object>();
			List<Object> ipdVitalSetupHistoryListObject = new ArrayList<Object>();
			for (int j = 1; j <= vitalCount; j++) {
				if(box.getString("vitalName"+j)!=null && !box.getString("vitalName"+j).equals("") && !box.getString("vitalName"+j).equals("0"))
				{
					IpdVitalSetup ipdVitalSetup= null;
					
					List<IpdVitalSetup> ipdVitalSetups=new ArrayList<IpdVitalSetup>();
				
					ipdVitalSetups = session.createCriteria(IpdVitalSetup.class)
							.add(Restrictions.eq("VitalName", box.getString("vitalName"+j).toLowerCase()).ignoreCase())
							.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
							.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
					
					if(ipdVitalSetups.size()==0)
					{
						
					 ipdVitalSetup=new IpdVitalSetup();
					ipdVitalSetup.setVitalName(box.getString("vitalName"+j));
				
					ipdVitalSetup.setLastChgBy(user);
					ipdVitalSetup.setLastChgTime(consultationTime);
					ipdVitalSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					ipdVitalSetup.setHin(patient);
					if(box.getInt("vitalFrequency"+j) != 0){
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("vitalFrequency"+j));
					ipdVitalSetup.setFrequency(masFrequency);
					}
					
					Inpatient inpatient2 = new Inpatient();
					inpatient2.setId(box.getInt("inpatientId"));
					ipdVitalSetup.setInpatient(inpatient2);
					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					ipdVitalSetup.setHospital(hospital);
					ipdVitalSetup.setRemarks(box.getString("vitalRemarks"+j));
					
					IpdVitalcareSetupHistory  history=new IpdVitalcareSetupHistory();
					history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
					history.setStartTime(consultationTime);
					history.setVitalSetup(ipdVitalSetup);
					if(!box.getString("carestop"+j).equals(""))
					{
						ipdVitalSetup.setStopVital("y");
						history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						history.setEndTime(consultationTime);
					}
					else
					{
						ipdVitalSetup.setStopVital("n");
						
					}
					hbt.save(ipdVitalSetup);
					hbt.save(history);
					ipdVitalSetupListObject.add(ipdVitalSetup);
					ipdVitalSetupHistoryListObject.add(history);
					
					}
					else
					{
						//added by govind 2-12-2016
						if(ipdVitalSetups.size()>0)
						{
						int vitalStopId=0;
						vitalStopId=Integer.parseInt(box.getString("vitalstop_id"+j));
						IpdVitalSetup vitalStop = (IpdVitalSetup) hbt.load(IpdVitalSetup.class, vitalStopId);	
						
						if(box.getString("vitalstop"+j).equals("1")){
							vitalStop.setStopVital("y");
							hbt.update(vitalStop);
						}
												
						}						
						//added by govind 2-12-2016 end
						
						ipdVitalSetup=ipdVitalSetups.get(0);
						ipdVitalSetup.setLastChgBy(user);
						ipdVitalSetup.setLastChgTime(consultationTime);
						ipdVitalSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						if(box.getInt("vitalFrequency"+j) != 0){
							MasFrequency masFrequency = new MasFrequency();
							masFrequency.setId(box.getInt("vitalFrequency"+j));
							ipdVitalSetup.setFrequency(masFrequency);
						}
						ipdVitalSetup.setRemarks(box.getString("vitalRemarks"+j));
						IpdVitalcareSetupHistory history=null;
						
						if(ipdVitalSetup.getStopVital()!=null && ipdVitalSetup.getStopVital().equalsIgnoreCase("y"))
						{
							if(!box.getString("vitalstop"+j).equals(""))
							{
								
							}
							else
							{
								history=new IpdVitalcareSetupHistory();
								//ipdVitalSetup.setStopVital("n");
								history.setVitalSetup(ipdVitalSetup);
								history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
								history.setStartTime(consultationTime);
							}
						}
						if(ipdVitalSetup.getStopVital()!=null && ipdVitalSetup.getStopVital().equalsIgnoreCase("n"))
						{
							 
							 if(!box.getString("vitalstop"+j).equals(""))
								{
								 List<IpdVitalcareSetupHistory> ipdVitalcareSetupHistories=new ArrayList<IpdVitalcareSetupHistory>();						
									ipdVitalcareSetupHistories = session.createCriteria(IpdVitalcareSetupHistory.class,"vcsh")
											.createAlias("VitalSetup", "vcs")
											.createAlias("vcs.Inpatient", "ncsi")
											.createAlias("vcs.Hospital", "ncsho")
											.add(Restrictions.eq("vcs.Id", ipdVitalSetup.getId()))
											.add(Restrictions.eq("ncsi.Id", box.getInt("inpatientId")))
											.add(Restrictions.eq("ncsho.Id", box.getInt("hospitalId")))
											.add(Restrictions.isNotNull("vcsh.StartDate"))
											.addOrder(Order.desc("Id")).list();
									if(ipdVitalcareSetupHistories.size()>0)
									{
									history=ipdVitalcareSetupHistories.get(0);
								 	//ipdVitalSetup.setStopVital("y");
								 	history.setVitalSetup(ipdVitalSetup);
									history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
									history.setEndTime(consultationTime);
									}
								}
						}
						hbt.save(ipdVitalSetup);
						if(history!=null)
						{
						hbt.save(history);
						}
						ipdVitalSetupListObject.add(ipdVitalSetup);
						ipdVitalSetupHistoryListObject.add(history);
						
					}
				}
			}
			ipdPatientDataList.put("ipdVitalSetupListObject", ipdVitalSetupListObject);
			ipdPatientDataList.put("ipdVitalSetupHistoryListObject", ipdVitalSetupHistoryListObject);
			//End By Ujjwal
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if(box.getInt("dietTypeId")!=0){
				IpdPatientDiet patientDiet = new IpdPatientDiet();
				MasDiet diet = new MasDiet();
				diet.setId(box.getInt("dietTypeId"));
				patientDiet.setDiet(diet);
				patientDiet.setSplInstructions(box.getString("splInstructions"));
				
				patientDiet.setDietDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("dietdate")));
				patientDiet.setDietTime(box.getString("diettime"));
				patientDiet.setSuggestedBy(masEmployee);
				
				patientDiet.setInpatient(inpatient);
				patientDiet.setHospital(masHospitalObj);
				patientDiet.setStatus("Y");
				
				
				patientDiet.setLastChgBy(user);
				patientDiet.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				patientDiet.setLastChgTime(consultationTime);
				patientDiet.setOpdPatientDetails(opdPatientDetails);
				hbt.save(patientDiet);
			}
			
			if(box.getInt("dietCount"+box.getInt(INPATIENT_ID))!=0)
			{
				IpdDietRequisitionHeader dietRequisitionHeader=new IpdDietRequisitionHeader();
				dietRequisitionHeader.setHin(p);
				dietRequisitionHeader.setInpatient(inpatient);
				MasHospital hospital=new MasHospital();
				hospital.setId(box.getInt(HOSPITAL_ID));
				dietRequisitionHeader.setHospital(hospital);
				dietRequisitionHeader.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dietdate")));
				dietRequisitionHeader.setRequisitionForDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dietForDate")));
				if(wardreamarksList.size()>0){
					MasDepartment md = new MasDepartment();
					md.setId(referredDept);
					dietRequisitionHeader.setRequisitionTo(md);
				}else{
					if(box.getInt("requisitionTo")!=0)
					{
						MasDepartment department=new MasDepartment();
						department.setId(box.getInt("requisitionTo"));
						dietRequisitionHeader.setRequisitionTo(department);
					}
				}
				
				
				dietRequisitionHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				dietRequisitionHeader.setLastChgTime((String)utilMap.get("currentTime"));
				Users users=new Users();
				users.setId(box.getInt(USER_ID));
				dietRequisitionHeader.setLastChgBy(users);
				hbt.save(dietRequisitionHeader);
				
				for(int j=1;j<=box.getInt("dietCount"+box.getInt(INPATIENT_ID));j++)
				{
					IpdDietRequisitionDetails dietRequisitionDetails=new IpdDietRequisitionDetails();
					dietRequisitionDetails.setDietRequisitionHeader(dietRequisitionHeader);
					MasDietCombination dietCombination=new MasDietCombination();
					dietCombination.setId(box.getInt("dietcombinationId"+box.getInt(INPATIENT_ID)+j));
					dietRequisitionDetails.setDietCombination(dietCombination);
					dietRequisitionDetails.setIssueStatus("n");
					hbt.save(dietRequisitionDetails);
				}
				
				for(int j=1;j<=box.getInt("extracount"+box.getInt(INPATIENT_ID));j++)
				{
					IpdDietRequisitionDetails dietRequisitionDetails=new IpdDietRequisitionDetails();
					dietRequisitionDetails.setDietRequisitionHeader(dietRequisitionHeader);
					MasDietItems dietItems =new MasDietItems();
					dietItems.setId(box.getInt("extraDietId"+box.getInt(INPATIENT_ID)+j));
					dietRequisitionDetails.setDietItems(dietItems);
					dietRequisitionDetails.setQuantity(box.getFloat("extraDietquantity"+box.getInt(INPATIENT_ID)+j));
					dietRequisitionDetails.setRemarks(box.getString("extraDietRemarks"+box.getInt(INPATIENT_ID)+j));
					dietRequisitionDetails.setIssueStatus("n");
					hbt.save(dietRequisitionDetails);
				}
				
			}
			
			int allergyCount=box.getInt("allergyCount");
			String allergen="";
			for(i=1;i<=allergyCount;i++)
			{
				if(box.getString("allergyName"+i)!=null && !box.getString("allergyName"+i).equals(""))
				{
					allergen=box.getString("allergyName"+i);
					break;
				}
			}
			if(!allergen.equals(""))
			{
			OpdPatientAllergyM opdPatientAllergyM=new OpdPatientAllergyM();
			opdPatientAllergyM.setHin(p);
			opdPatientAllergyM.setEmployee(masEmployee);
			if(wardreamarksList.size()>0){
				MasDepartment md = new MasDepartment();
				md.setId(referredDept);
				opdPatientAllergyM.setDepartment(md);
			}else{
				MasDepartment md = new MasDepartment();
				md.setId(box.getInt("deptId"));
				opdPatientAllergyM.setDepartment(md);
			}
			opdPatientAllergyM.setHospital(masHospitalObj);
			//opdPatientAllergyM.setVisit(new Visit(visitId));
			opdPatientAllergyM.setInpatient(inpatient);
			opdPatientAllergyM.setStatus("Y");
			opdPatientAllergyM.setLastChgBy(user);
			opdPatientAllergyM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
			opdPatientAllergyM.setLastChgTime(consultationTime);
			hbt.save(opdPatientAllergyM);
			for(i=1;i<=allergyCount;i++){
				OpdPatientAllergyT opdPatientAllergyT=new OpdPatientAllergyT();
				opdPatientAllergyT.setAllergen(box.getString("allergyName"+i));
				if(box.getString("allergyType"+i)!=null && !box.getString("allergyType"+i).equals("") && box.getInt("allergyType"+i)!=0)
				{
				opdPatientAllergyT.setAllergy(new MasAllergyProduct(box.getInt("allergyType"+i)));
				}
				
				if(box.getString("allergyseverity"+i)!=null && !box.getString("allergyseverity"+i).equals("") && box.getInt("allergyseverity"+i)!=0)
				{
					opdPatientAllergyT.setSeverity(new MasSeverityCode(box.getInt("allergyseverity"+i)));
				}
				opdPatientAllergyT.setOpdPatientAllergy(opdPatientAllergyM);
				opdPatientAllergyT.setFromMonth(box.getString("allergymonth"+i));
				opdPatientAllergyT.setFromYear(box.getString("allergyyear"+i));
				opdPatientAllergyT.setStatus(box.getString("allergystatus"+i));
				hbt.save(opdPatientAllergyT);
			}
			}
			
			Inpatient ip = (Inpatient)hbt.load(Inpatient.class, box.getInt("inpatientId"));
			
			if(!box.getString("readyToDischarge").equals("")){
				ip.setAdStatus("R");
				ip.setDischargeDate(new Date());
				ip.setDischargeTime(time);
				
			}/*else{
				ip.setAdStatus("A");
			}*/
			if(box.getInt("dietType")!=0){
				MasDiet diet = new MasDiet();
				diet.setId(box.getInt("dietType"));
				ip.setDiet(diet);
			}
			ip.setRemarks(box.getString("splInstructions"));
			
			if(!box.getString("ambulanceregister").equals("")){
			List<AmbulanceRegister> ambulanceRegistersList=new ArrayList<AmbulanceRegister>();
			
			 ambulanceRegistersList=session.createCriteria(AmbulanceRegister.class)
					                            .add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
					                             .add(Restrictions.eq("Hospital.Id", box.getInt(HOSPITAL_ID)))
					                              .add(Restrictions.eq("RequestStatus","p").ignoreCase())					                            
					                            .list();
			 
			 if(ambulanceRegistersList.size()==0)
			 {
				 AmbulanceRegister ambulanceRegister=new AmbulanceRegister();
				 ambulanceRegister.setInpatient(inpatient);
				 ambulanceRegister.setHin(p);
				 ambulanceRegister.setHospital(masHospitalObj);
				 if(wardreamarksList.size()>0){
						MasDepartment md = new MasDepartment();
						md.setId(referredDept);
						ambulanceRegister.setDepartment(md);
					}else{
						MasDepartment md = new MasDepartment();
						md.setId(box.getInt("deptId"));
						ambulanceRegister.setDepartment(md);
					}
				 ambulanceRegister.setDoctor(masEmployee);
				 ambulanceRegister.setRequestStatus("p");
				 ambulanceRegister.setBillStatus("n");
				 
				 ambulanceRegister.setLastChgBy(user);
				 ambulanceRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				 ambulanceRegister.setLastChgTime(consultationTime);
				 ambulanceRegister.setStatus("P");
				 hbt.save(ambulanceRegister);
			 }
			}
			
			
			hbt.update(ip);
			
			ipdPatientData.put("ip",ip);
			if(box.getString("referToName1").equals("y")){
				WardRemarks wardReamrks=new WardRemarks();	
				wardReamrks.setHospital(masHospitalObj);
				
				wardReamrks.setInpatient(inpatient);
				wardReamrks.setLastChgBy(user);
				wardReamrks.setLastChgBy(user);
				wardReamrks.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				wardReamrks.setLastChgTime(consultationTime);
				wardReamrks.setRemarksDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
				wardReamrks.setRemarksTime(consultationTime);
				//wardReamrks.set
				
				int doctorId=0;
				if(box.getInt("docName")!=0)
				{
					doctorId=box.getInt("docName");
				}
				if(box.getString("remarksBYDoc")!=null){
				wardReamrks.setRemarks(box.getString("remarksBYDoc"));
				
				}
				MasEmployee me=new MasEmployee();
				me.setId(doctorId);
				wardReamrks.setDoctor(me);
				wardReamrks.setStatus("P");
				hbt.save(wardReamrks);
			}
			
			for(WardRemarks WardRemarks:wardreamarksList){
				WardRemarks.setStatus("C");
				WardRemarks.setRemarks(WardRemarks.getRemarks().concat(box.getString("newRemarks")));
				hbt.update(WardRemarks);
			}

			
			//added by govind 2-12-2016 for medicine stop by doctor
			int medStopCount=0,medStopId=0;
			if(!box.getString("mediStopCount").equals("")){
				medStopCount=box.getInt("mediStopCount");
			}
			for(int mi=1;mi<=medStopCount;mi++){
				
				medStopId=box.getInt("mediStopId"+mi);
				InpatientPrescriptionDetails medStopDetail = (InpatientPrescriptionDetails) hbt.load(InpatientPrescriptionDetails.class, medStopId);	
				if(box.getString("medicinStop"+mi).equals("1")){
					medStopDetail.setStopMedicine("y");
					hbt.update(medStopDetail);
				}
			}
			
			//added by govind 2-12-2016
			
			//added by govind 8-12-2016
			String deadPatient="";
			int hinId=0;
			if (box.getString("hinId")!=null) {
				hinId=box.getInt("hinId");
				
			}
			if (box.getString("deadPatient")!=null) {//for patient death update start
				deadPatient=box.getString("deadPatient");
				if(deadPatient.equalsIgnoreCase("y")){
					Patient patDeath = (Patient) hbt.load(Patient.class, hinId);
					patDeath.setPatientStatus("Expired");
					hbt.update(patDeath);
				}
			}		
			//added by govind 8-12-2016 end
			
			flag = true;
			trans.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			if(trans!=null)
				trans.rollback();
		}
		
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*final MasHospital masHospital=(MasHospital)session.get(MasHospital.class, box.getInt("hospitalId")); 
		new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){

					makeFileIpdDetailFromLeanToServer(ipdPatientData,ipdPatientDataList);
				}
				
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){


					Map<String,Object> returnData=sendIpdDetailFromLeanToServer(ipdPatientData,ipdPatientDataList,masHospital);
					String message=(String)returnData.get("message");
					String iPDCasheetMessage=(String)returnData.get("IPDCasheetMessage");
					Inpatient inpatient=(Inpatient)ipdPatientData.get("ip");
					HibernateTemplate hbt2 = getHibernateTemplate();
					LeanServerIpdData leanServerIpdData=new LeanServerIpdData();
					leanServerIpdData.setCentralIpdId(Long.parseLong(inpatient.getId()+""));
					leanServerIpdData.setHospitalId(Long.parseLong(masHospital.getId()+""));
					leanServerIpdData.setIpdData(iPDCasheetMessage);
					String isIpdDataSaveToLean="Y";
					if(!"1".equalsIgnoreCase(message)){
						isIpdDataSaveToLean="N";
					}
					leanServerIpdData.setStatus(isIpdDataSaveToLean);
					hbt2.save(leanServerIpdData);
				}
			}
			}.start();*/
		
		 
		map.put("adNo",  box.getString("adNo"));
		map.put("inpatientId",  box.getInt("inpatientId"));
		map.put("hinNo",  box.getString("hinNo"));
		map.put("flag", flag);
		map.put("visitId", box.getInt("visitId"));
		return map;
	}
	
	@Override
	public Map<String, Object> searchNextOfKinPatient(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String uhid=(String)box.get(NEXT_OF_KIN_UHID);
		Session session=(Session) getSession();
		List<Patient> patientList=new ArrayList<Patient>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		patientList=session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", uhid.trim())).list();
		map.put("patientList", patientList);
		relationList = session
				.createCriteria(MasRelation.class)
				.add(Restrictions.eq("Status", "Y".toLowerCase())
						.ignoreCase()).list();
		map.put("relationList", relationList);
		
		return map;
	}
	
	@Override
	public Map<String, Object> showCreateVirtualBed(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Session session=(Session) getSession();
		List<MasBed> bedList=new ArrayList<MasBed>();
		bedList=session.createCriteria(MasBed.class,"mb")
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("BedType","p").ignoreCase())
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.list();
		
		List<MasBed> availableedList=new ArrayList<MasBed>();
		availableedList=session.createCriteria(MasBed.class,"mb")
				.createAlias("mb.BedStatus", "bedStatus")
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("BedType","p").ignoreCase())
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("bedStatus.BedStatusCode", bedStatusUnOccupiedName.toLowerCase()).ignoreCase())
				.list();
		
		MasDepartment department=(MasDepartment) session.get(MasDepartment.class, deptId);
		
		map.put("bedList", bedList);
		map.put(HOSPITAL_ID, hospitalId);
		map.put(DEPT_ID, deptId);
		map.put("department", department);
		map.put("availableedList", availableedList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitCreateVirtualBed(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int bedId=box.getInt(BED_ID);
		int userId=box.getInt(USER_ID);
		Session session=(Session) getSession();
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MasBed parentBed=(MasBed) hbt.get(MasBed.class, bedId);
			MasBedStatus bedStatus=(MasBedStatus) session.createCriteria(MasBedStatus.class)
					               .add(Restrictions.eq("Status", 'y').ignoreCase())
					               .add(Restrictions.eq("BedStatusCode", bedStatusUnOccupiedName).ignoreCase())
					               .uniqueResult();
			List<Object> vBedList=session.createCriteria(MasBed.class)
						.add(Restrictions.eq("Status", 'n').ignoreCase())
						.add(Restrictions.eq("BedType","v").ignoreCase())
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VBed.Id", parentBed.getId()))
						.addOrder(Order.asc("BedNo")).list();
			if(vBedList!=null && vBedList.size()>0)
			{
				MasBed bed=(MasBed) vBedList.get(0);
				bed.setStatus("n");
				Users users=new Users();
				users.setId(userId);
				bed.setLastChgBy(users);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap= (Map)HMSUtil.getCurrentDateAndTime();
//				String currentDate = (String)utilMap.get("currentDate");
				String currentTime = (String)utilMap.get("currentTime");
				bed.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
				bed.setLastChgTime(currentTime);
				hbt.update(bed);
				tx.commit();
				hbt.flush();
				hbt.clear();
			}
			else
			{
				String bedNo="";
				List<Object> vBedList1=session.createCriteria(MasBed.class)
						.add(Restrictions.eq("Status", 'y').ignoreCase())
						.add(Restrictions.eq("BedType","v").ignoreCase())
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("VBed.Id", parentBed.getId()))
						.addOrder(Order.desc("BedNo")).list();
				if(vBedList1!=null && vBedList1.size()>0)
				{
					char c=(char) (65+vBedList1.size());
					bedNo=parentBed.getBedNo()+"-"+c;
				}
				else
				{
					bedNo=parentBed.getBedNo()+"-A";
				}
				MasBed bed=new MasBed();
				bed.setBedNo(bedNo);
				bed.setDepartment(parentBed.getDepartment());
				bed.setStatus("y");
				bed.setBedStatus(bedStatus);
				Users users=new Users();
				users.setId(userId);
				bed.setLastChgBy(users);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap= (Map)HMSUtil.getCurrentDateAndTime();
//				String currentDate = (String)utilMap.get("currentDate");
				String currentTime = (String)utilMap.get("currentTime");
				bed.setLastChgDate(HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
				bed.setLastChgTime(currentTime);
				bed.setRoom(parentBed.getRoom());
				bed.setAdNo(parentBed.getAdNo());
				bed.setDietType(parentBed.getDietType());
				bed.setAttached(parentBed.getAttached());
				bed.setVBed(parentBed);
				bed.setBedType("V");
				MasHospital hospital=new MasHospital();
				hospital.setId(hospitalId);
				bed.setHospital(hospital);
				hbt.save(bed);
				tx.commit();
				hbt.flush();
				hbt.clear();
			}
			
			
		}
	  catch(Exception exception)
	  {
		  exception.printStackTrace();
	  }
		map.put(HOSPITAL_ID, hospitalId);
		map.put(DEPT_ID, deptId);
		return map;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemUnit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String pvmsNo=  box.getString("pvmsNo");
		Session session = (Session)getSession();
		itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", pvmsNo))
		  				.list();
		map.put("itemList", itemList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 09-09-2016
		
		String hinNo = "";
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		Session session = (Session)getSession();
		try {
			patientList = (List<Patient>) session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
			inPatientList = (List<Inpatient>) session
					.createCriteria(Inpatient.class).createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.HinNo", hinNo)).list();
			visitList = (List<Visit>) session.createCriteria(Visit.class)
					.createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.HinNo", hinNo)).list();
			
			// added by amit das on 09-09-2016
			patientEpisodeList  =session.createCriteria(PatientEpisode.class)
								 .add(Restrictions.eq("HinNo", hinNo)).list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("patientList", patientList);
		map.put("inPatientList", inPatientList);
		map.put("visitList", visitList);
		map.put("patientEpisodeList",patientEpisodeList); // added by amit das on 09-09-2016
		return map;
	}
	
	@Override
	public Map<String, Object> getPatientAllergy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		 List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
		 List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
		 List<OpdPatientAllergyM>  ipdOpdPatientAllergyMList = new ArrayList<OpdPatientAllergyM>();
		 Inpatient inpatient=null;		 
		   Session session = (Session)getSession();
		   allergyProductsList = session.createCriteria(MasAllergyProduct.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			saverityCodesList = session.createCriteria(MasSeverityCode.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			 inpatient=(Inpatient) session.get(Inpatient.class,box.getInt("parent")); 
		   ipdOpdPatientAllergyMList=session.createCriteria(OpdPatientAllergyM.class,"opam")
						  .createAlias("opam.Hin", "hin")
						  .add(Restrictions.eq("hin.Id", box.getInt("hinId")))
						   .list();
		   
		   map.put("allergyProductsList", allergyProductsList);
			  map.put("saverityCodesList", saverityCodesList);
		map.put("ipdOpdPatientAllergyMList", ipdOpdPatientAllergyMList);
		map.put("inpatient", inpatient);
		
		
		return map;
	}
	
	@Override
	public Map<String, Object> submitPatientAllergy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String consultationTime = (String)utilMap.get("currentTime");
		String consultationDate=(String)utilMap.get("currentDate");
		
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");
		Transaction tx= null;
		try
		{
		Patient p=new Patient();
		p.setId(box.getInt("hinId"));
		 Inpatient inpatient = new Inpatient();
			inpatient.setId(box.getInt("inpatientId"));
			MasEmployee masEmployee = new MasEmployee();
			if (box.getInt("empId") != 0) {
				masEmployee.setId(box.getInt("empId"));
			}
			MasHospital masHospitalObj = new MasHospital();
			masHospitalObj.setId(box.getInt("hospitalId"));
			MasDepartment md=new MasDepartment();
			md.setId(box.getInt(DEPT_ID));
			Users user=new Users();
			user.setId(box.getInt(USER_ID));
			
		int allergyCount=box.getInt("allergyCount");
		String allergen="";
		for(int i=1;i<=allergyCount;i++)
		{
			if(box.getString("allergyName"+i)!=null && !box.getString("allergyName"+i).equals(""))
			{
				allergen=box.getString("allergyName"+i);
				break;
			}
		}
		tx = session.beginTransaction();
		if(!allergen.equals(""))
		{
		OpdPatientAllergyM opdPatientAllergyM=new OpdPatientAllergyM();
		opdPatientAllergyM.setHin(p);
		opdPatientAllergyM.setEmployee(masEmployee);
		opdPatientAllergyM.setDepartment(md);
		opdPatientAllergyM.setHospital(masHospitalObj);
		//opdPatientAllergyM.setVisit(new Visit(visitId));
		opdPatientAllergyM.setInpatient(inpatient);
		opdPatientAllergyM.setStatus("Y");
		opdPatientAllergyM.setLastChgBy(user);
		opdPatientAllergyM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
		opdPatientAllergyM.setLastChgTime(consultationTime);
		hbt.save(opdPatientAllergyM);
		for(int i=1;i<=allergyCount;i++){
			OpdPatientAllergyT opdPatientAllergyT=new OpdPatientAllergyT();
			opdPatientAllergyT.setAllergen(box.getString("allergyName"+i));
			if(box.getString("allergyType"+i)!=null && !box.getString("allergyType"+i).equals("") && box.getInt("allergyType"+i)!=0)
			{
			opdPatientAllergyT.setAllergy(new MasAllergyProduct(box.getInt("allergyType"+i)));
			}
			
			if(box.getString("allergyseverity"+i)!=null && !box.getString("allergyseverity"+i).equals("") && box.getInt("allergyseverity"+i)!=0)
			{
				opdPatientAllergyT.setSeverity(new MasSeverityCode(box.getInt("allergyseverity"+i)));
			}
			opdPatientAllergyT.setOpdPatientAllergy(opdPatientAllergyM);
			opdPatientAllergyT.setFromMonth(box.getString("allergymonth"+i));
			opdPatientAllergyT.setFromYear(box.getString("allergyyear"+i));
			opdPatientAllergyT.setStatus(box.getString("allergystatus"+i));
			hbt.save(opdPatientAllergyT);
		}
		}
		tx.commit();
		flag=true;
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			if(tx!=null)
				tx.rollback();
		}
		map.put("flag", flag);
		return map;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPrescriptionListForPatient(Box box) {

		List<InpatientPrescriptionHeader> showHeaderList = new ArrayList<InpatientPrescriptionHeader>();
		List<InpatientPrescriptionDetails> showDetailsList = new ArrayList<InpatientPrescriptionDetails>();
		
		List<IpWardConsumption> ipWardConsumptionList = new ArrayList<IpWardConsumption>();
		List<StoreItemBatchStock> sotckBatchList = new ArrayList<StoreItemBatchStock>();
		
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<IpWardConsumptionDetails> consumptionDetails=new ArrayList<IpWardConsumptionDetails>();
		
		//List admissionNumberList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int maxFrequncy=0;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			showHeaderList=session.createCriteria(InpatientPrescriptionHeader.class)
							.add(Restrictions.eq("Inpatient.Id",box.getInt("parent"))).list();
			
			showDetailsList = session.createCriteria(InpatientPrescriptionDetails.class)
					.createAlias("Prescription", "pres")
					.add(Restrictions.eq("pres.Inpatient.Id",box.getInt("parent")))
					//.add(Restrictions.eq("StopMedicine","n").ignoreCase())//commented by govind on 3-12-2016
					// .add(Restrictions.ne("InjectionStatus","y").ignoreCase())  // commented by amit das on 17-10-2016
					.list();
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap=HMSUtil.getCurrentDateAndTime();
			Date date=HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate"));
			String blockStatus [] = {"Temporary Block","Parmanent Block"};
			Iterator<InpatientPrescriptionDetails> iterator=showDetailsList.iterator();
			while (iterator.hasNext()) {
				InpatientPrescriptionDetails inpatientPrescriptionDetails = (InpatientPrescriptionDetails) iterator
						.next();
				long diffDays = (date.getTime()-inpatientPrescriptionDetails.getPrescription().getPrescriptionDate().getTime()) / (24 * 60 * 60 * 1000);
				if(inpatientPrescriptionDetails.getNoOfDays()!=null && diffDays<=inpatientPrescriptionDetails.getNoOfDays())
				{
					if(maxFrequncy<inpatientPrescriptionDetails.getFrequency().getFrequencyCount())
					maxFrequncy=inpatientPrescriptionDetails.getFrequency().getFrequencyCount();
				sotckBatchList.addAll(session.createCriteria(StoreItemBatchStock.class)
						.createAlias("Item", "item")
						.add(Restrictions.eq("item.Id", inpatientPrescriptionDetails.getItem().getId()))
						.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.ge("ClosingStock", new BigDecimal(0)))
						.add(Restrictions.ge("ExpiryDate", date))
						.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus"))).list());
				}
				else
				{//added by govind on 27-10-2017 for tapered medicine
						sotckBatchList.addAll(session.createCriteria(StoreItemBatchStock.class)
								.createAlias("Item", "item")
								.add(Restrictions.eq("item.Id", inpatientPrescriptionDetails.getItem().getId()))
								.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
								.add(Restrictions.ge("ClosingStock", new BigDecimal(0)))
								.add(Restrictions.ge("ExpiryDate", date))
								.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus"))).list());
				
					//iterator.remove();//commented by govind on 27-10-2017 for tapered medicine
				}
			}
			
			/*int itemId=0;
			for(InpatientPrescriptionDetails prescriptionDetails:showDetailsList){
				itemId=prescriptionDetails.getItem().getId();
				sotckBatchList.addAll(session.createCriteria(StoreItemBatchStock.class)
						.createAlias("Item", "item").add(Restrictions.eq("item.Id", itemId))
						.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
						.add(Restrictions.ne("ClosingStock", new BigDecimal(0))).list());
			}
			*/
			/*ipWardConsumptionList=session.createCriteria(IpWardConsumption.class)
					.add(Restrictions.eq("Hin.Id",box.getInt(HIN_ID)))
					.add(Restrictions.eq("Consumption1","y").ignoreCase()).list();*/
			
			consumptionDetails=session.createCriteria(IpWardConsumptionDetails.class,"icd")
					.createAlias("icd.Consumption", "ich")
					.createAlias("ich.Inpatient", "ip")
					.createAlias("ich.Hospital", "h")
					.add(Restrictions.eq("ip.Id", box.getInt("parent")))
					.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)))
					.add(Restrictions.eq("ich.ConsumptionDate",date))
					.list();
			
			
			inPatientDetailList=session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id",box.getInt("parent"))).list();
			
			//added by govind 20-9-2016
			List<InjAppointmentDetails>injappList=session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "injHeader")
					   .add(Restrictions.eq("injHeader.Inpatient.Id", box.getInt("parent")))
					   .addOrder(Order.asc("Id"))
					   /*.add(Restrictions.eq("Status","p").ignoreCase())*/
					   /*.add(Restrictions.eq("InjAppointmentDate", date))*/
					   .list();			map.put("ipInjectionList",injappList);
					   
					   logger.info("List "+injappList.size());
					   
		    map.put("aList",injappList);
			//added by govind 20-9-2016 end 
			
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			
			map.put("showHeaderList",showHeaderList);
			map.put("showDetailsList", showDetailsList);
			map.put("inPatientDetailList", inPatientDetailList);
			if(ipWardConsumptionList.size() >0){
			map.put("ipWardConsumptionList", ipWardConsumptionList);
			}
			map.put("sotckBatchList", sotckBatchList);
			
			map.put("maxFrequncy", maxFrequncy);
			map.put("consumptionDetails", consumptionDetails);
			map.put("patId",box.getInt(HIN_ID));
			map.put("deptId",box.getInt(DEPT_ID));
		return map;
	}
	
	@Override
	public boolean  submitWardConsumption(Box box) {

		boolean succesfullyAdded = false;

		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int userId=box.getInt(USER_ID);
		int inpatientId=box.getInt(INPATIENT_ID);
		int hinId=box.getInt(HIN_ID);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		String dateToInsert=(String)utilMap.get("currentDate");
		
		// added by amit das on 21-11-2016
		BigDecimal temp = null;
		Float actualQtyNeeded = null;
		String mixable = null;
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
	
			/*int counter =box.getInt("counter");
			for (int i=1;i<=counter;i++) {
				String care=box.getString("care"+i);
				if (care!=null && !care.equals("")&&care.equals("one")) {
					
					IpWardConsumption ipWardConsumption=new IpWardConsumption();
					
					//Ipdcaredetail ipdcaredetail = new Ipdcaredetail();
					Inpatient inpatient=new Inpatient();
					inpatient.setId(inpatientId);
					ipWardConsumption.setInpatient(inpatient);
					
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					ipWardConsumption.setDepartment(masDepartment);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					ipWardConsumption.setHospital(masHospital);
					
					Patient patient = new Patient();
					patient.setId(hinId);
					ipWardConsumption.setHin(patient);
					
					InpatientPrescriptionDetails inpatientprescriptionDetails = new InpatientPrescriptionDetails();
					inpatientprescriptionDetails.setId(box.getInt("prescriptionDetailsId"+i));
					ipWardConsumption.setInpatientprescriptionDetails(inpatientprescriptionDetails);

					ipWardConsumption.setConsumption1("y");
					ipWardConsumption.setDateofconsumption(HMSUtil.dateFormatterDDMMYYYY(box.getString("caredate")));
					ipWardConsumption.setConsumption1time(box.getString("caretime"+i));
					Users users=new Users();
					users.setId(userId);
					ipWardConsumption.setLastChgBy(users);
					ipWardConsumption.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(dateToInsert));
					ipWardConsumption.setLastChgTime(time);
					if(box.getString("medstop"+i)!=null && !box.getString("medstop"+i).equals(""))
					{
						InpatientPrescriptionDetails inpatientprescriptionDetails1 = (InpatientPrescriptionDetails) hbt.get(
								IpWardConsumption.class, box.getInt("prescriptionDetailsId"+i));
						inpatientprescriptionDetails1.setStopMedicine("n");
						hbt.save(inpatientprescriptionDetails1);
					}
					
					hbt.save(ipWardConsumption);
					succesfullyAdded = true;
				} else {
					int ipdId = box.getInt("ipwardconsumptionId"+i);
					if(ipdId!=0)
					{
					IpWardConsumption ipWardConsumption = (IpWardConsumption) hbt.load(
							IpWardConsumption.class, ipdId);
					
					if (care!=null && !care.equals("")&&care.equals("two")) {
						ipWardConsumption.setConsumption2("Y");
						ipWardConsumption.setConsumption2time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("three")) {
						ipWardConsumption.setConsumption3("Y");
						ipWardConsumption.setConsumption3time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("four")) {
						ipWardConsumption.setConsumption4("Y");
						ipWardConsumption.setConsumption4time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("five")) {
						ipWardConsumption.setConsumption5("Y");
						ipWardConsumption.setConsumption5time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("six")) {
						ipWardConsumption.setConsumption6("Y");
						ipWardConsumption.setConsumption6time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("seven")) {
						ipWardConsumption.setConsumption7("Y");
						ipWardConsumption.setConsumption7time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("eight")) {
						ipWardConsumption.setConsumption8("Y");
						ipWardConsumption.setConsumption8time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("nine")) {
						ipWardConsumption.setConsumption9("Y");
						ipWardConsumption.setConsumption9time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("ten")) {
						ipWardConsumption.setConsumption10("Y");
						ipWardConsumption.setConsumption10time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("eleven")) {
						ipWardConsumption.setConsumption11("Y");
						ipWardConsumption.setConsumption11time(box.getString("caretime"+i));
					}
					if (care!=null && !care.equals("")&&care.equals("twelve")) {
						ipWardConsumption.setConsumption12("Y");
						ipWardConsumption.setConsumption12time(box.getString("caretime"+i));
					}
					
					if(box.getString("medstop"+i)!=null && !box.getString("medstop"+i).equals(""))
					{
						InpatientPrescriptionDetails inpatientprescriptionDetails1 = (InpatientPrescriptionDetails) hbt.get(
								IpWardConsumption.class, box.getInt("prescriptionDetailsId"+i));
						inpatientprescriptionDetails1.setStopMedicine("n");
						hbt.save(inpatientprescriptionDetails1);
					}
					
					hbt.update(ipWardConsumption);
					succesfullyAdded = true;
				}
				}
			}*/
			
			
			int counter =box.getInt("counter");
			for (int i=1;i<=counter;i++) {
				InpatientPrescriptionDetails inpatientprescriptionDetails = (InpatientPrescriptionDetails) hbt.get(InpatientPrescriptionDetails.class,box.getInt("prescriptionDetailsId"+i));
				if(box.getString("medstop"+i)!=null && !box.getString("medstop"+i).equals(""))
				{
					inpatientprescriptionDetails.setStopMedicine("y");
					hbt.update(inpatientprescriptionDetails);
				}
				String care=box.getString("care"+i);
				String billStatus=box.getString("billStatus"+i);
				// added by amit das on 21-11-2016
				actualQtyNeeded = box.getFloat("actualQtyNeeded");
				mixable = box.get("mixable"+i);
				temp = new BigDecimal(inpatientprescriptionDetails.getDosage().toString()).multiply(new BigDecimal(actualQtyNeeded.toString()));
				temp = temp.divide(new BigDecimal(inpatientprescriptionDetails.getTotal().toString()));
				// ended by amit das on 21-11-2016
				
				if (care!=null && !care.equals("")&&care.equals("1")) {
					IpWardConsumptionHeader wardConsumptionHeader=new IpWardConsumptionHeader();					
					
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(deptId);
					wardConsumptionHeader.setDepartment(masDepartment);
					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					wardConsumptionHeader.setHospital(masHospital);
					
					Patient patient = new Patient();
					patient.setId(hinId);
					wardConsumptionHeader.setHin(patient);
					
					Inpatient inpatient=new Inpatient();
					inpatient.setId(inpatientId);
					wardConsumptionHeader.setInpatient(inpatient);
					
					wardConsumptionHeader.setInpatientPrescriptionDetails(inpatientprescriptionDetails);

					//ipWardConsumption.setConsumption1("y");
					wardConsumptionHeader.setConsumptionDate(HMSUtil.dateFormatterDDMMYYYY(box.getString("caredate")));
					//ipWardConsumption.setConsumption1time(box.getString("caretime"+i));
					Users users=new Users();
					users.setId(userId);
					wardConsumptionHeader.setLastChgBy(users);
					wardConsumptionHeader.setLastChgDate(HMSUtil.dateFormatterDDMMYYYY(dateToInsert));
					wardConsumptionHeader.setLastChgTime(time);
					wardConsumptionHeader.setBillStatus(billStatus);
					if(box.getString("medstop"+i)!=null && !box.getString("medstop"+i).equals(""))
					{
						inpatientprescriptionDetails.setStopMedicine("y");
						hbt.update(inpatientprescriptionDetails);
					}
					
					IpWardConsumptionDetails consumptionDetails=new IpWardConsumptionDetails();
					
					consumptionDetails.setConsumption(wardConsumptionHeader);
					consumptionDetails.setConsumptionStatus("y");
					consumptionDetails.setConsumptionTime(box.getString("caretime"+i));
					consumptionDetails.setFrequencyCount(box.getInt("care"+i));
					StoreItemBatchStock stock=null;
					MasStoreItem storeItem=null;
					int itemId=0;
					if(box.getInt("stockId"+i)!=0){
						stock=(StoreItemBatchStock) hbt.get(StoreItemBatchStock.class, box.getInt("stockId"+i));
						consumptionDetails.setStock(stock);
						
						
						if(stock.getIssueQty()!=null)
						{
							// condition added by amit das on 21-11-2016
							if(mixable.equalsIgnoreCase("Y")){
								stock.setIssueQty(stock.getIssueQty().add(temp));
							}else {

								itemId=stock.getItem().getId();
								storeItem=(MasStoreItem) hbt.get(MasStoreItem.class, itemId);
								if(storeItem.getItemClass().getId()==2 ||storeItem.getItemClass().getId()==1){
								   stock.setIssueQty(stock.getIssueQty().add(new BigDecimal(wardConsumptionHeader.getInpatientPrescriptionDetails().getDosage())));
								}else{
									stock.setIssueQty(stock.getIssueQty().add(new BigDecimal(1)));
								}
								}
						}
						else
						{ 	
							// condition added by amit das on 21-11-2016
							if(mixable.equalsIgnoreCase("Y")){
								stock.setIssueQty(temp);
							} else {
								stock.setIssueQty(new BigDecimal(inpatientprescriptionDetails.getDosage()));
							}
						}
						
						// condition added by amit das on 21-11-2016
						if(mixable.equalsIgnoreCase("Y")){
							stock.setClosingStock(stock.getClosingStock().min(temp));
						} else {
							stock.setClosingStock(stock.getClosingStock().min(new BigDecimal(inpatientprescriptionDetails.getDosage())));
						}
							stock.setId(box.getInt("stockId"+i));
						hbt.update(stock);
					}else if(box.getString("stockId"+i)!=null){
						consumptionDetails.setOutsidePrescription("y");
					}
					
					hbt.save(wardConsumptionHeader);
					hbt.save(consumptionDetails);
					succesfullyAdded = true;
				} else if (care!=null && !care.equals("")) {
					int careId = box.getInt("ipwardconsumptionId"+i);
					if(careId!=0)
					{
						IpWardConsumptionHeader wardConsumptionHeader=(IpWardConsumptionHeader)hbt.get(IpWardConsumptionHeader.class, careId);
						
						if(box.getString("medstop"+i)!=null && !box.getString("medstop"+i).equals(""))
						{
							inpatientprescriptionDetails.setStopMedicine("y");
							hbt.update(inpatientprescriptionDetails);
						}
						
						IpWardConsumptionDetails consumptionDetails=new IpWardConsumptionDetails();
						consumptionDetails.setConsumption(wardConsumptionHeader);
						consumptionDetails.setConsumptionStatus("y");
						consumptionDetails.setConsumptionTime(box.getString("caretime"+i));
						consumptionDetails.setFrequencyCount(box.getInt("care"+i));
						StoreItemBatchStock stock=null;
						MasStoreItem storeItem=null;
						int itemId=0;
						if(box.getInt("stockId"+i)!=0){
							stock=(StoreItemBatchStock) hbt.get(StoreItemBatchStock.class, box.getInt("stockId"+i));
							if(stock.getIssueQty()!=null)
							{
								// condition added by amit das on 21-11-2016
								if(mixable.equalsIgnoreCase("Y")){
									stock.setIssueQty(stock.getIssueQty().add(temp));
								}else {
									itemId=stock.getItem().getId();
									storeItem=(MasStoreItem) hbt.get(MasStoreItem.class, itemId);
									if(storeItem.getItemClass().getId()==2 ||storeItem.getItemClass().getId()==1){
									   stock.setIssueQty(stock.getIssueQty().add(new BigDecimal(wardConsumptionHeader.getInpatientPrescriptionDetails().getDosage())));
									}else{
										stock.setIssueQty(stock.getIssueQty().add(new BigDecimal(0)));
									}
									}
							}
							else
							{
								// condition added by amit das on 21-11-2016
								if(mixable.equalsIgnoreCase("Y")){
									stock.setIssueQty(temp);
								} else {
									stock.setIssueQty(new BigDecimal(wardConsumptionHeader.getInpatientPrescriptionDetails().getDosage()));
								}

							}
							
							// condition added by amit das on 21-11-2016
							if(mixable.equalsIgnoreCase("Y")){
								stock.setClosingStock(stock.getClosingStock().min(temp));
							} else {
								stock.setClosingStock(stock.getClosingStock().min(new BigDecimal(wardConsumptionHeader.getInpatientPrescriptionDetails().getDosage())));
							}
							stock.setId(box.getInt("stockId"+i));
							hbt.update(stock);
						}else if(box.getString("stockId"+i)!=null){
							consumptionDetails.setOutsidePrescription("y");
						}
						
						hbt.save(consumptionDetails);
						succesfullyAdded = true;
					
				}
				}
				
			}
			hbt.flush();
			hbt.clear();
			succesfullyAdded = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullyAdded;
	}
	
	
	@Override
	public boolean  checkBedStatus(int bedId) {

		boolean succesfullyAdded = false;
		
		MasBed masbed=null;
		try {
			Session session=(Session) getSession();
			String bedStatusUnOccupiedName = "";
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				bedStatusUnOccupiedName = prop.getProperty("bedStatusUnOccupiedName");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			masbed=(MasBed) session.createCriteria(MasBed.class,"mbed")
					.createAlias("mbed.BedStatus", "bstatus")
					.add(Restrictions.eq("Id", bedId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.add(Restrictions.eq("bstatus.BedStatusCode",bedStatusUnOccupiedName ).ignoreCase())
					.uniqueResult();
			if(masbed!=null)
			{
				succesfullyAdded=true;
			}
			

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return succesfullyAdded;
	}
	
	@Override
	public Map<String, Object> getDetailsForBedTransferAcceptance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MasBed> beds = new ArrayList<MasBed>();
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		transferList=session.createCriteria(Transfer.class)
				.createAlias("ToWard", "d")
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("d.Id",  box.getInt(DEPT_ID)))
				.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)))
				.add(Restrictions.eq("RequestStatus","p").ignoreCase())
				.list();
		
		beds = session
				.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", box.getInt(DEPT_ID)))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)))
				.addOrder(Order.asc("BedNo"))
				.createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode",
						bedStatusUnOccupiedName))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
				.add(Restrictions.isNull("VBed"))
				.list();
		
		if(beds.size()==0)
		{
			beds = session
					.createCriteria(MasBed.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id",  box.getInt(DEPT_ID)))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)))
					.addOrder(Order.asc("BedNo"))
					.createAlias("BedStatus", "bs")
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusUnOccupiedName))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
					.add(Restrictions.isNotNull("VBed"))
					.list();
		}
		
		map.put("transferList", transferList);
		map.put("beds", beds);
		
		return map;
	}
	
	@Override
	public Map<String, Object> submitWardTransferAcceeptance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean status=false;
		String message="";
		
		String bedStatusOccupiedName = "";
		String bedStatusUnOccupiedName="";
		String masdeptTypeMortury="";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusOccupiedName = prop.getProperty("bedStatusOccupiedName");
			bedStatusUnOccupiedName=prop.getProperty("bedStatusUnOccupiedName");
			masdeptTypeMortury = prop.getProperty("masdeptTypeMortury");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			Transfer transfer=(Transfer) hbt.get(Transfer.class, box.getInt("transferId"));
			if(!box.getString("Accept").equals("") && box.getString("Accept").equals("1"))
			{
				//need to write code for transfer billing				
				Inpatient inpatient=transfer.getInpatient();
				if(transfer.getTransferType().equalsIgnoreCase("bed"))
				{
					if(this.checkBedStatus(transfer.getToBed().getId()))
					{
					transfer.setRequestStatus("a");
					transfer.setTransferReason(box.getString("remarks"));
					inpatient.setDepartment(transfer.getToWard());
					MasBed masBed=inpatient.getBed();
					MasBedStatus bedStatus1 = (MasBedStatus) session
							.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions
									.eq("BedStatusCode", bedStatusUnOccupiedName))
							.uniqueResult();
					masBed.setBedStatus(bedStatus1);
					if(masBed.getBedType().equalsIgnoreCase("v"))
					{
						masBed.setStatus("n");
					}					
					inpatient.setBed(transfer.getToBed());
					
					
					MasBed bed = transfer.getToBed();
					MasBedStatus bedStatus = (MasBedStatus) session
							.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions
									.eq("BedStatusCode", bedStatusOccupiedName))
							.uniqueResult();
					hbt.update(masBed);
					bed.setBedStatus(bedStatus);
					hbt.update(bed);
					hbt.update(inpatient);
					hbt.update(transfer);
					status=true;
					 message="Bed Transfer successfull";
					}
					else
					{
						status=false;
						 message="Selected bed is not available";
					}
				}
				
				else
				{
					if(transfer.getToWard().getDepartmentType().getDepartmentTypeCode().equals(masdeptTypeMortury))
					{
						MasBed bed = (MasBed) session.get(MasBed.class, box.getInt("bedId"));
						transfer.setRequestStatus("a");
						//transfer.setRequestStatus(box.getString("remarks"));
						inpatient.setDepartment(transfer.getToWard());
						MasBed masBed=inpatient.getBed();
						MasBedStatus bedStatus1 = (MasBedStatus) session
								.createCriteria(MasBedStatus.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.add(Restrictions
										.eq("BedStatusCode", bedStatusUnOccupiedName))
								.uniqueResult();
						masBed.setBedStatus(bedStatus1);
						if(masBed.getBedType().equalsIgnoreCase("v"))
						{
							masBed.setStatus("n");
						}
						
						
						inpatient.setBed(bed);
						MasBedStatus bedStatus = (MasBedStatus) session
								.createCriteria(MasBedStatus.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.add(Restrictions
										.eq("BedStatusCode", bedStatusOccupiedName))
								.uniqueResult();
						
						hbt.update(masBed);
						bed.setBedStatus(bedStatus);
						hbt.update(bed);
						hbt.update(inpatient);
						hbt.update(transfer);
						status=true;
						 message="Ward Transfer successfull";
					}
					else
					{
						boolean paywardProcessingRequired=false;
					if(transfer.getToWard().getPaywardCheck()!=null && transfer.getToWard().getPaywardCheck().equalsIgnoreCase("y"))
					{
						BlPaywardBooking blPaywardBooking=(BlPaywardBooking) session.createCriteria(BlPaywardBooking.class)
								                         .add(Restrictions.eq("Transfer.Id", transfer.getId()))
								                          .add(Restrictions.eq("BookingStatus", "w").ignoreCase())
								                         .setFirstResult(0)
								                         .setMaxResults(1)
								                         .uniqueResult();
						if(blPaywardBooking==null)
						{
							paywardProcessingRequired=true;
						}
						
					}
					if(paywardProcessingRequired)
					{
						status=false;
						 message="Payward allotment is not completed. Please complete Payward Allotment Process To accect.";
					}
					else
					{
					if(this.checkBedStatus(box.getInt("bedId")))
					{
					MasBed bed = (MasBed) session.get(MasBed.class, box.getInt("bedId"));
					transfer.setRequestStatus("a");
					//transfer.setRequestStatus(box.getString("remarks"));
					inpatient.setDepartment(transfer.getToWard());
					MasBed masBed=inpatient.getBed();
					MasBedStatus bedStatus1 = (MasBedStatus) session
							.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions
									.eq("BedStatusCode", bedStatusUnOccupiedName))
							.uniqueResult();
					masBed.setBedStatus(bedStatus1);
					if(masBed.getBedType().equalsIgnoreCase("v"))
					{
						masBed.setStatus("n");
					}
					
					inpatient.setBed(bed);
					MasBedStatus bedStatus = (MasBedStatus) session
							.createCriteria(MasBedStatus.class)
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions
									.eq("BedStatusCode", bedStatusOccupiedName))
							.uniqueResult();
					
					hbt.update(masBed);
					bed.setBedStatus(bedStatus);
					hbt.update(bed);
					hbt.update(inpatient);
					hbt.update(transfer);
					status=true;
					 message="Ward Transfer successfull";
					}
					else
					{
						status=false;
						 message="Selected bed is not available";
					}
					}
					
				}
				}
			}
				
			//}
			else if(!box.getString("Accept").equals("") && box.getString("Accept").equals("2"))
			{
				transfer.setRequestStatus("r");
				//transfer.setRequestStatus(box.getString("remarks"));
			}
			tx.commit();
			hbt.flush();
			hbt.clear();			
		}
		catch(Exception exception)
		{
			status=false;
			 message="Error occured. Please try afer some time!!!";
			 tx.rollback();
		}
		logger.info("message is == "+message);
		map.put("message", message);
		map.put("status", status);
		return map;
	}
	
	@Override
	public Map<String, Object> getCareTransferAccepJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		Session session = (Session) getSession();
		List<IpdHandTakeOver> ipdHandTakeOverList = new ArrayList<IpdHandTakeOver>();
		int deptId = box.getInt(DEPT_ID);
		
		String mmMasRequestStatusPending=null;
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			mmMasRequestStatusPending=prop1.getProperty("mmMasRequestStatusPending");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int hospitalid = box.getInt(HOSPITAL_ID);
		ipdHandTakeOverList = session.createCriteria(IpdHandTakeOver.class)
				.createAlias("Hospital", "h")
				.createAlias("RequestStatus", "rs")
				.createAlias("Department", "d")
				.add(Restrictions.eq("h.Id", hospitalid))
				.add(Restrictions.in("rs.StatusCode", new String[]{mmMasRequestStatusPending}))
				.add(Restrictions.eq("d.Id", deptId))
				.list();

		map.put("ipdHandTakeOverList", ipdHandTakeOverList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitcareTransferAcceeptance(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean status=false;
		String message="";
		
		String mmMasRequestStatusApproved=null;
		String mmMasRequestStatusReject=null;
		URL resourcePath1 = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		List<Transfer> transferNoList = new ArrayList<Transfer>();
		try {
			
			Properties prop1 = new Properties();
			prop1.load(new FileInputStream(new File(resourcePath1.getFile())));
			mmMasRequestStatusApproved=prop1.getProperty("mmMasRequestStatusApproved");
			mmMasRequestStatusReject=prop1.getProperty("mmMasRequestStatusReject");
		} catch (IOException e) {
			e.printStackTrace();
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			
			IpdHandTakeOver ipdHandTakeOver=(IpdHandTakeOver) hbt.load(IpdHandTakeOver.class, box.getInt("handoverId"));
			if(!box.getString("Accept").equals("") && box.getString("Accept").equals("1"))
			{
				Inpatient inpatient=ipdHandTakeOver.getInpatient();
				MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("StatusCode", mmMasRequestStatusApproved).ignoreCase()).uniqueResult();
				ipdHandTakeOver.setRequestStatus(masRequestStatus);
				ipdHandTakeOver.setRemarksPendingWork(box.getString(REMARKS));
				inpatient.setDoctor(ipdHandTakeOver.getTakeBy());
				
				if(!box.getString("transferRequired").equals("") && box.getString("transferRequired").equals("1"))
				{
					ipdHandTakeOver.setWardBedTransferRequired("y");
					String transferType="ward";
					Transfer transfer = new Transfer();
					transfer.setInpatient(inpatient);
					transfer.setHin(inpatient.getHin());
					transfer.setAdNo(inpatient.getAdNo());
					MasHospital hospital=new MasHospital();
					hospital.setId(box.getInt(HOSPITAL_ID));
					transfer.setHospital(hospital);
					transfer.setFromWard(inpatient.getDepartment());
					transfer.setFromBed(inpatient.getBed());
					transfer.setRequestStatus("p");
					transfer.setTransferType(transferType);
					transfer.setTransferReason("Doctor Request");
					transferNoList = session.createCriteria(Transfer.class)
							.addOrder(Order.desc("Id")).setMaxResults(1).list();
					if(transferNoList!=null && transferNoList.size()>0)
					{
						transfer.setTransferNo(transferNoList.get(0).getTransferNo());
					}
					else
					{
						transfer.setTransferNo(1);
					}
						MasDepartment toDepartment=new MasDepartment();
						toDepartment.setId((Integer)box.getInt(DEPT_ID));
						transfer.setToWard(toDepartment);
					
					/*MasEmployee authorizer=new MasEmployee();
					authorizer.setId(box.getInt(AUTHORIZER_ID));
					transfer.setAuthorizedBy(authorizer);*/
					
					
					transfer.setDateOfTransfer(ipdHandTakeOver.getEntryDate());
					transfer.setTimeOfTransfer(ipdHandTakeOver.getEntryTime());
					transfer.setAdStatus(inpatient.getAdStatus());
					transfer.setStatus("y");
					Users users=new Users();
					users.setId(box.getInt(USER_ID));
					transfer.setAddEditBy(users);
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String date2 = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					transfer.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(date2));
					transfer.setAddEditTime(time);
					hbt.save(transfer);
				}
				hbt.update(inpatient);
				hbt.update(ipdHandTakeOver);
				status=true;
				 message="Accepted Successfully.";
			}
			else if(!box.getString("Accept").equals("") && box.getString("Accept").equals("2"))
			{
				MmMasRequestStatus masRequestStatus=(MmMasRequestStatus) session.createCriteria(MmMasRequestStatus.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.eq("StatusCode", mmMasRequestStatusReject).ignoreCase()).uniqueResult();
				ipdHandTakeOver.setRequestStatus(masRequestStatus);
				ipdHandTakeOver.setRemarksPendingWork(box.getString(REMARKS));
				if(!box.getString("transferRequired").equals("") && box.getString("transferRequired").equals("1"))
				{
					ipdHandTakeOver.setWardBedTransferRequired("y");
				}
				hbt.update(ipdHandTakeOver);
				status=true;
				message="Rejected Successfully.";
			}

			tx.commit();
			hbt.flush();
			hbt.clear();
		}
		catch(Exception exception)
		{
			 status=false;
			 message="Error occured. Please try afer some time!!!";
			 tx.rollback();
			 exception.printStackTrace();
		}
		logger.info("message is == "+message);
		map.put("message", message);
		map.put("status", status);
		return map;
	}
	
	
	@Override
	public Map<String, Object> showWardConsList(int deptId,int hospitalId) {

		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		List<StoreFyDocumentNo> ipIssueNoList = new ArrayList<StoreFyDocumentNo>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			deptList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Id", deptId)).list();
			ipIssueNoList = session.createQuery("select syd from StoreFyDocumentNo as syd where syd.Department.Id="	+ deptId +" and syd.Hospital.Id="+ hospitalId).list();
			logger.info("ipIssueNoList-----DS--->"+ipIssueNoList.size());
			int issueNoOfWard =0;
			int storeFyDocumentNoId=0;
			
				if (ipIssueNoList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) ipIssueNoList.get(0);
					logger.info("issueNoOfWard-----DS->"+storeFyDocumentNo.getIssueWardNo());
					
					if (storeFyDocumentNo.getIssueWardNo()!=null) 
					{
					issueNoOfWard = storeFyDocumentNo.getIssueWardNo();
					logger.info("issueNoOfWard-----DS->"+issueNoOfWard);
					
					}
					
					if (storeFyDocumentNo.getId()!=null) 
					{
					storeFyDocumentNoId = storeFyDocumentNo.getId();
					logger.info("storeFyDocumentNoId-----DS->"+storeFyDocumentNoId);

					}
					issueNoOfWard = issueNoOfWard + 1;
					storeFyDocumentNo.setIssueWardNo(issueNoOfWard);

		                hbt.update(storeFyDocumentNo);
		                hbt.refresh(storeFyDocumentNo);
					

				}
				else
				{
					
							issueNoOfWard = issueNoOfWard + 1;
				            StoreFyDocumentNo storeFyDocumentNo = new StoreFyDocumentNo();
							storeFyDocumentNo.setIssueWardNo(issueNoOfWard);
				            storeFyDocumentNo.setAdjustmentNo("0");
				            storeFyDocumentNo.setAdjustmentStartNo("0");
				            storeFyDocumentNo.setBalanceNo("0");
				            storeFyDocumentNo.setBalanceStartNo("0");
				            storeFyDocumentNo.setDefectEntryNo("0");
				            storeFyDocumentNo.setDefectEntryStartNo("0");
				            storeFyDocumentNo.setDemandNo("0");
				            storeFyDocumentNo.setDemandStartNo("0");
				            storeFyDocumentNo.setDepartment(new MasDepartment(deptId));
				            storeFyDocumentNo.setGrnNo("");
				            storeFyDocumentNo.setGrnStartNo("0");
				            storeFyDocumentNo.setIssueDeptNo("0");
				            storeFyDocumentNo.setIssueDeptReturnNo("0");
				            storeFyDocumentNo.setIssueDeptReturnStartNo("0");
				            storeFyDocumentNo.setIssueDeptStartNo("0");
				            storeFyDocumentNo.setVendorReturnNo("0");
				            storeFyDocumentNo.setVendorReturnStartNo("0");
				            String issueDeptNo = "";
				            String issueDeptStartNo = issueDeptNo;
				            storeFyDocumentNo.setIssueDeptNo(issueDeptNo);
				            storeFyDocumentNo.setIssueDeptStartNo(issueDeptStartNo);
				            MasHospital hospital = new MasHospital();
				            hospital.setId(hospitalId);
				            storeFyDocumentNo.setHospital(hospital);
				            storeFyDocumentNoId=(Integer)hbt.save(storeFyDocumentNo);
				            hbt.refresh(storeFyDocumentNo);
				}
				hbt.flush();
				map.put("issueNoOfWard", issueNoOfWard);
				map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 12 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/
 		map.put("deptList", deptList);
		return map;

	
	}
	
	@Override
	public boolean submitWardConsDetails(Map<String, Object> map) 
	{
		Session session = (Session) getSession();
		boolean succesfullyAdded = false;
		Date fromDateToInsert = null;
		// String issueType="w";
		List<String> pvmsList = (List) map.get("pvmsList");
		List<String> batchNumberList = (List) map.get("batchNumberList");
		List<MasStoreBrand> brandNameList = new ArrayList<MasStoreBrand>();
		List<String> expiryDateList = (List<String>) map.get("expiryDateList");
//		List issQtyList = (List) map.get("issQtyList");
		List costPriceList = (List) map.get("costPriceList");
		List amountList = (List) map.get("amountList");
		List<StoreItemBatchStock> storeItemBatchStockIdList = new ArrayList<StoreItemBatchStock>();
		String date = (String) map.get("date");
		int deptId = (Integer) map.get("deptId");
		int hospitalId = (Integer) map.get("hospitalId");
		int userId = (Integer) map.get("userId");
		String time = (String) map.get("time");
		String userName = (String) map.get("userName");
		int storeFyDocumentNoId = (Integer) map.get("storeFyDocumentNoId");
		int wardIssueNo = (Integer) map.get("wardIssueNo");
		logger.info("wardIssueNo------DS--- "+wardIssueNo);
		StoreIpIssueM storeIpIssueM = null;
		if (map.get("fromDate") != "") {
			String fromDate = (String) map.get("fromDate");
			fromDateToInsert = HMSUtil.convertStringTypeDateToDateType(fromDate);
		}
		
 		Date toDateInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Transaction tx = null;
		
		try {
			 tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) hbt.load(StoreFyDocumentNo.class, storeFyDocumentNoId);
			
			int wardIssueNoFromDB=0;
			if(storeFyDocumentNo.getIssueWardNo()!=null)
			{
			 wardIssueNoFromDB = storeFyDocumentNo.getIssueWardNo();
			 }
			/*if (wardIssueNoFromDB != wardIssueNo) {
				storeFyDocumentNo.setIssueWardNo(wardIssueNo);
				hbt.update(storeFyDocumentNo);*/
				
				
				storeIpIssueM = new StoreIpIssueM();
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				storeIpIssueM.setDepartment(masDepartment);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storeIpIssueM.setHospital(masHospital);
				storeIpIssueM.setIpIssueDate(dateToInsert);
				storeIpIssueM.setIssueType("w");
				storeIpIssueM.setIpIssueNo(""+wardIssueNo);
				storeIpIssueM.setFromdate(fromDateToInsert);
				storeIpIssueM.setTodate(toDateInsert);
				Users users=new Users();
				users.setId(userId);
				storeIpIssueM.setLastChgBy(users);
				storeIpIssueM.setLastChgDate(dateToInsert);
				storeIpIssueM.setLastChgTime(time);
				hbt.save(storeIpIssueM);
			/*} else {
				List storeIpIssueMList = session.createQuery("select sim from StoreIpIssueM as sim where sim.IpIssueNo='"+ wardIssueNo + "' and lower(sim.IssueType)='w'").list();
				System.out.println("storeIpIssueMList--Ds-->"+storeIpIssueMList.size());

				storeIpIssueM = (StoreIpIssueM) storeIpIssueMList.get(0);
			
			}*/

			// hbt.save(storeIpIssueM);
			// Iterator itr= issQtyList.iterator();
			map.put("IpIssueMId",storeIpIssueM.getId());
 			for (int i = 0; i < batchNumberList.size(); i++)
 			{

				BigDecimal totalQtyIssued;
				StoreIpIssueT storeIpIssueT = new StoreIpIssueT();
				storeIpIssueT.setIpIssue(storeIpIssueM);
				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem
						.setId(Integer.parseInt(pvmsList.get(i).toString()));
				storeIpIssueT.setItem(masStoreItem);
				storeIpIssueT.setBatchNo(batchNumberList.get(i));
							
				brandNameList = session.createCriteria(MasStoreBrand.class).add(Restrictions.eq("Item.Id", masStoreItem.getId())).add(Restrictions.eq("Status", "y")).list();

				int brandId=0;
				MasStoreBrand masStoreBrand = new MasStoreBrand();
				if(brandNameList!=null && brandNameList.size() >0){

				for(MasStoreBrand brand : brandNameList)
				{
					brandId = brand.getId();
				}
					masStoreBrand.setId(brandId);
					storeIpIssueT.setBrand(masStoreBrand);
				}
				/*else
				{
					System.out.println("In ELSE section of Mas Store Brand List");
					masStoreBrand.setId(0);
				}*/
				
				String expiryDate ="";
				if(expiryDateList.get(i)!=null)
				{
					expiryDate = (String)expiryDateList.get(i);
					expiryDate = expiryDate.substring(8,10)+"/"+expiryDate.substring(5,7)+"/"+expiryDate.substring(0,4);
				}
 				Date expiryDateToInsert = HMSUtil
						.convertStringTypeDateToDateType(expiryDate);
				storeIpIssueT.setExpiryDate(expiryDateToInsert);
		//		BigDecimal issuedQtyFromJsp = new BigDecimal(""+ issQtyList.get(i));
		//		storeIpIssueT.setQtyIssued(issuedQtyFromJsp);
				BigDecimal bigDecimal2 = new BigDecimal(""
						+ costPriceList.get(i));
				storeIpIssueT.setRate(bigDecimal2);
				BigDecimal bigDecimal3 = new BigDecimal(amountList.get(i).toString());
				storeIpIssueT.setAmount(bigDecimal3);
			//	hbt.save(storeIpIssueT);

//--commentd by kiran (here pass batch no in stock id )---
		//	storeItemBatchStockIdList = session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Item.Id", masStoreItem.getId())).add(Restrictions.eq("BatchNo", batchNumberList.get(i).toString())).list();

				storeItemBatchStockIdList = session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("Department.Id", deptId)).add(Restrictions.eq("Item.Id", masStoreItem.getId())).add(Restrictions.eq("BatchNo", batchNumberList.get(i))).list();
			 int stockId =0;
			  for(StoreItemBatchStock stock : storeItemBatchStockIdList)
			  {
				  stockId = stock.getId();
			  }
			 		StoreItemBatchStock storeItemBatchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, stockId);
				BigDecimal qtyIssued = new BigDecimal(0);
				if( storeItemBatchStock.getIssueQty() !=null ){
				qtyIssued = (BigDecimal) storeItemBatchStock.getIssueQty();
				}
				//	 BigDecimal issQty=(BigDecimal)issQtyList.get(i);

				if (qtyIssued != null) {
					totalQtyIssued = qtyIssued.add(new BigDecimal(amountList.get(i).toString()));
				} else {
					totalQtyIssued =new BigDecimal(amountList.get(i).toString());
					//System.out.println("totalQtyIssued-->"+totalQtyIssued);
		 				}
 				BigDecimal closingStock = (BigDecimal) storeItemBatchStock
						.getClosingStock();
				closingStock = closingStock.subtract(new BigDecimal(amountList.get(i).toString()));
				storeItemBatchStock.setIssueQty(totalQtyIssued);
				storeItemBatchStock.setClosingStock(closingStock);
 			    hbt.save(storeIpIssueM);
				hbt.save(storeIpIssueT);
				hbt.update(storeItemBatchStock);
			}
 			succesfullyAdded = true;
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}

		return succesfullyAdded;
	}

		
	@Override
	public Map<String, Object> getNursingCareSttus(Box box) {

		List<IpdCareDetails> ipdCareDetailList=new ArrayList<IpdCareDetails>();
		NursingcareSetup nursingcareSetup=null;
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");
			
			nursingcareSetup=(NursingcareSetup) session.get(NursingcareSetup.class, box.getInt("setupId"));
			
			ipdCareDetailList=session.createCriteria(IpdCareDetails.class,"icd")
					.createAlias("icd.CareHeader", "ich")
					.createAlias("ich.NursingcareSetup", "ncs")
					.createAlias("ich.Inpatient", "ip")
					.createAlias("ich.Hospital", "h")
					.add(Restrictions.eq("ncs.Id", box.getInt("setupId")))
					.add(Restrictions.eq("ip.Id", box.getInt("inpatientId")))
					.add(Restrictions.eq("h.Id",  box.getInt(HOSPITAL_ID)))
					.add(Restrictions.eq("ich.DateOfCare",HMSUtil.convertStringTypeDateToDateType(date)))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
 		map.put("ipdCareDetailList", ipdCareDetailList);
 		map.put("nursingcareSetup", nursingcareSetup);
		return map;

	
	}
	
	@Override
	public Map<String, Object>  showAmbulanceRunRegister(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<AmbulanceRegister> ambulanceRegisterList=new ArrayList<AmbulanceRegister>();
		List<MasChargeCode> chargeCodeList=new ArrayList<MasChargeCode>();
		List<MasAmbulance> ambulanceList=new ArrayList<MasAmbulance>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTimeDBFormat();
		String date=(String)utilMap.get("modifiedDate");
		Date dbDate=HMSUtil.convertStringyyyyMMddTypeToDateType(date);
		
		Session session = (Session) getSession();
		
		ambulanceRegisterList=session.createCriteria(AmbulanceRegister.class,"ambregs")
				//.add(Restrictions.eq("ambregs.RequestStatus", "p").ignoreCase())
				.add(Restrictions.eq("ambregs.Department.Id",box.getInt(DEPT_ID)))
				.add(Restrictions.eq("ambregs.Hospital.Id",box.getInt(HOSPITAL_ID)))
				.add(Restrictions.eq("ambregs.AmbulanceRunDate",new Date()))
				.list();
		chargeCodeList = session.createCriteria(MasChargeCode.class).createAlias("MainChargecode", "mc")
				.add(Restrictions.eq("mc.MainChargecodeName", "AMBULANCE"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		ambulanceList = session.createCriteria(MasAmbulance.class).add(Restrictions.eq("Available", "Yes").ignoreCase()).add(Restrictions.eq("Status", "y")).list();
		map.put("ambulanceRegisterList", ambulanceRegisterList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("ambulanceList", ambulanceList);
		return map;
		
	}
	
	@Override
	public Map<String, Object> saveAmbulanceRunRegisterDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		

		try {
			
			AmbulanceRegister ambulanceRegister = (AmbulanceRegister) hbt.get(AmbulanceRegister.class, box.getInt("ambulanceId"));
			ambulanceRegister.setAmbulanceRunDate(HMSUtil.convertStringTypeDateToDateType(box.getString(AMBULANCE_RUN_DATE)));
			ambulanceRegister.setAmbulanceRunTime(box.getString(AMBULANCE_RUN_TIME));
			ambulanceRegister.setFromSmc(box.getString(FROM_SMC));
			ambulanceRegister.setToDestination(box.getString(DESTINATION));
			
			ambulanceRegister.setPatientName(box.getString(PATIENT_NAME));
			ambulanceRegister.setRemarks(box.getString(REMARKS));
			if(box.getString("attendants")!=null && !box.getString("attendants").equals(""))
			{
			ambulanceRegister.setAttendents(box.getString("attendants"));
			}
			
			// Added by Amit Das on 22-03-2016
			if(box.getInt("ambulanceCharge") != 0){
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(box.getInt("ambulanceCharge"));
				ambulanceRegister.setChargeCode(masChargeCode);
			}
			
			if(!box.getString("charge").equals(""))
				ambulanceRegister.setCharge(new BigDecimal(box.getString("charge")));
			
			
			
			if(box.getInt("ambulanceno")!=0)
			{
				MasAmbulance masAmbulance = new MasAmbulance();
				masAmbulance.setId(box.getInt("ambulanceno"));
				ambulanceRegister.setAmbulance(masAmbulance);
			}
			
			if(box.getString("drivername")!=null && !box.getString("drivername").equals(""))
			{
			ambulanceRegister.setDriverName(box.getString("drivername"));
			}
			
			if(box.getString("drivercontact")!=null && !box.getString("drivercontact").equals(""))
			{
			ambulanceRegister.setDriverContact(box.getString("drivercontact"));
			}
			
			if(!box.getString("distance").equals(""))
			{
				ambulanceRegister.setDistance(new BigDecimal(box.getString("distance")));
			}
			
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap=HMSUtil.getCurrentDateAndTime();
			String currentDate=(String)utilMap.get("currentDate");
			String currentTime=(String)utilMap.get("currentTime");
			ambulanceRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			ambulanceRegister.setLastChgTime(currentTime);
			
			Users user = new Users();
			user.setId(box.getInt("userId"));
			ambulanceRegister.setLastChgBy(user);
			ambulanceRegister.setRequestStatus("c");
			ambulanceRegister.setBillStatus("n");
		/*
		 * Added by Ujjwal on 01/01/2016 from mainting status for ambulance run
		 */
			String status="";
			
			if(box.getString("ambStatus")!=null && !box.getString("ambStatus").equals("")){
				status=box.getString("ambStatus");
				ambulanceRegister.setStatus(status);
			}
			
			hbt.update(ambulanceRegister);
			
			//============================= Ambulance charge Entry=====================
			if(box.getInt("ambulanceCharge") != 0 && box.getString("ambStatus").equalsIgnoreCase("A")){ // added condition by Amit Das on 22-03-2016
				BlChargeSlipMain blChargeSlipMain = new  BlChargeSlipMain(); 
				
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				blChargeSlipMain.setHin(patient);
				
				Inpatient inpatient = new Inpatient();
				inpatient.setId(box.getInt("inPatientId"));
				blChargeSlipMain.setInpatient(inpatient);
				blChargeSlipMain.setChargeSlipNo(box.getInt("chargeSlipNo"));
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				blChargeSlipMain.setHospital(masHospital);  // added by Amit Das on 22-03-2016
				blChargeSlipMain.setChgSlpAmt(new BigDecimal(box.getInt("amount")));
				blChargeSlipMain.setReceiptAmt(new BigDecimal(box.getInt("amount")));
				blChargeSlipMain.setNetAmt(new BigDecimal(box.getInt("amount")));
				blChargeSlipMain.setChgSlpDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				blChargeSlipMain.setChgSlpTime(currentTime);
				Users users = new Users();
				users.setId(box.getInt("userId"));
				blChargeSlipMain.setLastChgBy(users);
				blChargeSlipMain.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				blChargeSlipMain.setLastChgTime(currentTime);
				blChargeSlipMain.setStatus("y");
				hbt.save(blChargeSlipMain);
			    
				BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
				MasChargeCode masChargeCode = new MasChargeCode();
				masChargeCode.setId(box.getInt("ambulanceCharge"));
				blChargeSlipDetail.setChargeCode(masChargeCode);
				blChargeSlipDetail.setQuantity(box.getInt("distance"));
				blChargeSlipDetail.setRate(new BigDecimal(box.getInt("charge")));
				blChargeSlipDetail.setAmt(new BigDecimal(box.getInt("amount")));
				blChargeSlipDetail.setNetAmt(new BigDecimal(box.getInt("amount")));
				blChargeSlipDetail.setLastChgBy(users);
				blChargeSlipDetail.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				blChargeSlipDetail.setLastChgTime(currentTime);
				blChargeSlipDetail.setStatus("y");
				blChargeSlipDetail.setHospital(masHospital);  // added by Amit Das on 22-03-2016
				blChargeSlipDetail.setChargeSlipMain(blChargeSlipMain);
				hbt.save(blChargeSlipDetail);
			}
			
			
			
			
			
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		map = showAmbulanceRunRegister(box);
		map.put("flag", flag);
		return map;
	}
	
	
	@Override
	public Map<String, Object> getProcedureForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> procedureList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		int hospitalId = (Integer)detailsMap.get(HOSPITAL_ID);
		Session session = (Session)getSession();
		procedureList = session.createCriteria(NursingcareSetup.class)
				.createAlias("Nursing", "n")
				    .add(Restrictions.eq("Inpatient.id", inpatientId))
			.setProjection(Projections.distinct(Projections.property("n.NursingName"))).list();
		
		StringBuffer anesthesiaName = new StringBuffer();
		StringBuffer operationNames = new StringBuffer();
		List<OtPostAnaesthesiaProcedure> postAnestDetailsList = new ArrayList<OtPostAnaesthesiaProcedure>();
		postAnestDetailsList = session
				.createCriteria(OtPostAnaesthesiaProcedure.class)
				.createAlias("Booking", "ob")
				.createAlias("ob.Inpatient", "ip")
				.add(Restrictions.eq("ip.Id", inpatientId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		/*if (postAnestDetailsList.size() > 0) {
			for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : postAnestDetailsList) {
				if (otPostAnaesthesiaProcedure.getAnesthesia() != null) {
					if (anesthesiaName.length() > 0) {
						anesthesiaName = anesthesiaName.append(" , ");
					}
					anesthesiaName = anesthesiaName
							.append(otPostAnaesthesiaProcedure
									.getAnesthesia()
									.getAnesthesiaName());
				}
				Set<OtSurgeyPaSurgeyDetail> surgerySet = new HashSet<OtSurgeyPaSurgeyDetail>();
				if (otPostAnaesthesiaProcedure
						.getOtSurgeyPaSurgeyDetails() != null) {
					surgerySet = otPostAnaesthesiaProcedure
							.getOtSurgeyPaSurgeyDetails();
					if (surgerySet.size() > 0) {
						for (OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail : surgerySet) {
							if (otSurgeyPaSurgeyDetail.getChargeCode() != null) {
								if (operationNames.length() > 0) {
									operationNames = operationNames
											.append(" , ");
								}
								operationNames = operationNames
										.append(otSurgeyPaSurgeyDetail
												.getChargeCode()
												.getChargeCodeName());
							}
						}
					}
				}

			}
			map.put("ANES", anesthesiaName.toString());
			map.put("OPER", operationNames.toString());

		}*/
		map.put("procedureList", procedureList);
		map.put("postAnestDetailsList", postAnestDetailsList);
		return map;
	}
	
	@Override
	public Map<String, Object> getTreatmentDetailsForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> prescriptionList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		prescriptionList = session.createCriteria(InpatientPrescriptionDetails.class)
				.createAlias("Prescription", "p").createAlias("Item", "i").add(Restrictions.eq("p.Inpatient.id", inpatientId))
				.setProjection(Projections.distinct(Projections.property("i.Nomenclature"))).list();
		map.put("prescriptionList", prescriptionList);
		return map;
	}
	
	@Override
	public Map<String, Object> getDetailForDietSchedule(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Inpatient> inpatientList=new ArrayList<Inpatient>();
		List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
		List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
		
		Session session = (Session)getSession();
		
		
		String departmentTypeCodeForCanteen=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			departmentTypeCodeForCanteen=prop.getProperty("departmentTypeCodeForCanteen");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String requisitionDate=box.getString("dietForDate");
		int diet_menu_typeId=box.getInt(DIET_MENU_ITEM_ID);
		
		List<Integer> patientId=new ArrayList<Integer>();
		if((requisitionDate!=null && !requisitionDate.equals("")) ||diet_menu_typeId!=0 )
		{
		Criteria criteria= session.createCriteria(IpdDietRequisitionDetails.class)
				.createAlias("DietRequisitionHeader", "hdr")
				.createAlias("DietCombination", "comb")
				.createAlias("comb.Menu", "mn")
				.createAlias("hdr.Inpatient", "ip")
				.createAlias("hdr.Hospital", "h")
				.setProjection(Projections.projectionList().add(Projections.property("ip.Id")));
		
		criteria.add(Restrictions.eq("h.Id", box.getInt(HOSPITAL_ID)));
		if(requisitionDate!=null && !requisitionDate.equals(""))
		{
			criteria.add(Restrictions.eq("hdr.RequisitionForDate", HMSUtil.convertStringTypeDateToDateType(requisitionDate)));
		}
		if(diet_menu_typeId!=0)
		{
			criteria.add(Restrictions.eq("mn.Id", diet_menu_typeId));
		}
		patientId=criteria.list();
		}
		
		masDietList=session.createCriteria(MasDiet.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		masMenuTypeList=session.createCriteria(MasMenuType.class)
				.add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		
		Criteria criteria=session.createCriteria(Inpatient.class)
				.createAlias("Department", "d")
				.createAlias("Hospital", "h")
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.eq("AdStatus","a").ignoreCase())
				.add(Restrictions.eq("d.Id",box.getInt(DEPT_ID)))
				.add(Restrictions.eq("h.Id",box.getInt(HOSPITAL_ID)));
				if(patientId.size()>0)
				{
					criteria.add(Restrictions.not(Restrictions.in("Id", patientId)));
				}
		
		if(box.getString("bplStatus")!=null && !box.getString("bplStatus").equals("") && box.getString("bplStatus").equals("bpl"))
		{
			criteria.add(Restrictions.eq("hin.BplStatus","y").ignoreCase());
		}
		if(box.getString("bplStatus")!=null && !box.getString("bplStatus").equals("") && box.getString("bplStatus").equals("apl"))
		{
			criteria.add(Restrictions.eq("hin.BplStatus","n").ignoreCase());
		}
		
		if(box.getInt("patientTypeId")!=0)
		{
			criteria.createAlias("hin.PatientType", "ptype");
			criteria.add(Restrictions.eq("ptype.Id",box.getInt("patientTypeId")));
		}
		
		inpatientList=criteria.list();
		
		departmentList = session
				.createCriteria(MasInstituteDepartment.class,"msd")
				.createAlias("msd.Department", "md")
				.createAlias("md.DepartmentType", "mdt")
				.createAlias("msd.Institute", "mh")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("mdt.DepartmentTypeCode", departmentTypeCodeForCanteen.toLowerCase()).ignoreCase())
				.add(Restrictions.eq("md.Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("mh.Id", box.getInt(HOSPITAL_ID)))
				.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
		
		patientTypeForSocialCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "s").ignoreCase()).list();
		
		patientTypeForOtherCategory=session.createCriteria(MasPatientType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Type", "o").ignoreCase()).list();
		map.put("masDietList", masDietList);
		map.put("masMenuTypeList", masMenuTypeList);
		map.put("departmentList", departmentList);
		map.put("inpatientList", inpatientList);
		map.put("patientTypeForSocialCategory", patientTypeForSocialCategory);
		map.put("patientTypeForOtherCategory", patientTypeForOtherCategory);
				
		return map;
	}
	
	@Override
	public Map<String, Object> submitDetailForDietSchedule(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		String dateToInsert=(String)utilMap.get("currentDate");
		Session session = (Session)getSession();
		Transaction tx = null;
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
		
		
		for(int i=1;i<=box.getInt("patientCount");i++)
		{
			if(box.getInt(INPATIENT_ID+i)!=0)
			{
				if(box.getInt("dietCount"+box.getInt(INPATIENT_ID+i))!=0)
				{
					Inpatient inpatient=(Inpatient) hbt.get(Inpatient.class, box.getInt(INPATIENT_ID+i));
					IpdDietRequisitionHeader dietRequisitionHeader=new IpdDietRequisitionHeader();
					dietRequisitionHeader.setHin(inpatient.getHin());
					dietRequisitionHeader.setInpatient(inpatient);
					MasHospital hospital=new MasHospital();
					hospital.setId(box.getInt(HOSPITAL_ID));
					dietRequisitionHeader.setHospital(hospital);
					dietRequisitionHeader.setRequisitionDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REQUEST_DATE)));
					dietRequisitionHeader.setRequisitionForDate(HMSUtil.convertStringTypeDateToDateType(box.getString("dietForDate")));
					MasDepartment department=new MasDepartment();
					department.setId(box.getInt("requisitionTo"));
					dietRequisitionHeader.setRequisitionTo(department);
					dietRequisitionHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(dateToInsert));
					dietRequisitionHeader.setLastChgTime((String)utilMap.get("currentTime"));
					Users users=new Users();
					users.setId(box.getInt(USER_ID));
					dietRequisitionHeader.setLastChgBy(users);
					hbt.save(dietRequisitionHeader);
					
					for(int j=1;j<=box.getInt("dietCount"+box.getInt(INPATIENT_ID+i));j++)
					{
						IpdDietRequisitionDetails dietRequisitionDetails=new IpdDietRequisitionDetails();
						dietRequisitionDetails.setDietRequisitionHeader(dietRequisitionHeader);
						MasDietCombination dietCombination=new MasDietCombination();
						dietCombination.setId(box.getInt("dietcombinationId"+box.getInt(INPATIENT_ID+i)+j));
						dietRequisitionDetails.setDietCombination(dietCombination);
						dietRequisitionDetails.setIssueStatus("n");
						hbt.save(dietRequisitionDetails);
					}
					
					for(int j=1;j<=box.getInt("extracount"+box.getInt(INPATIENT_ID+i));j++)
					{
						IpdDietRequisitionDetails dietRequisitionDetails=new IpdDietRequisitionDetails();
						dietRequisitionDetails.setDietRequisitionHeader(dietRequisitionHeader);
						MasDietItems dietItems =new MasDietItems();
						dietItems.setId(box.getInt("extraDietId"+box.getInt(INPATIENT_ID+i)+j));
						dietRequisitionDetails.setDietItems(dietItems);
						dietRequisitionDetails.setQuantity(box.getFloat("extraDietquantity"+box.getInt(INPATIENT_ID+i)+j));
						dietRequisitionDetails.setRemarks(box.getString("extraDietRemarks"+box.getInt(INPATIENT_ID+i)+j));
						dietRequisitionDetails.setIssueStatus("n");
						hbt.save(dietRequisitionDetails);
					}
					
				}
				
				
			}
			
		}
		tx.commit();
		hbt.flush();
		hbt.clear();
		
		return map;
	}
	
	@Override
	public Map<String, Object> getDietItemForAutoComplete(Map<String, Object> detailsMap)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDietItems> masDietItems=new ArrayList<MasDietItems>();
		Session session = (Session)getSession();
		
		masDietItems=session.createCriteria(MasDietItems.class).add(Restrictions.eq("Status","y").ignoreCase())
				.add(Restrictions.like("DietItemsName", (String)detailsMap.get("searchQuery")+"%").ignoreCase()).list();
		map.put("masDietItems", masDietItems);
		return map;
		
	}
	
	@Override
	public Map<String, Object> getDietCombinationItems(Map<String, Object> detailsMap)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) detailsMap.get(DEPT_ID);
		int hospitalId = (Integer) detailsMap.get(HOSPITAL_ID);
		int mas_diet_id = (Integer)detailsMap.get(DIET_TYPE_ID);
		int diet_menu_type_id = (Integer)detailsMap.get(DIET_MENU_ITEM_ID);
		List<MasDietCombination> dietCombinationList=new ArrayList<MasDietCombination>();
		String requitiondate = (String)detailsMap.get("requitiondate");
		List<Integer> patientId=new ArrayList<Integer>();
		Session session = (Session)getSession();
		
		dietCombinationList=session.createCriteria(MasDietCombination.class)
				.createAlias("Hospital", "h")
				.createAlias("Menu", "me")
				.createAlias("Diet", "diet")
				.add(Restrictions.eq("me.Id", diet_menu_type_id))
				.add(Restrictions.eq("diet.Id", mas_diet_id))
				.add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		
	
		Criteria criteria= session.createCriteria(IpdDietRequisitionDetails.class)
				.createAlias("DietRequisitionHeader", "hdr")
				.createAlias("DietCombination", "comb")
				.createAlias("comb.Menu", "mn")
				.createAlias("hdr.Inpatient", "ip")
				.createAlias("hdr.Hospital", "h")
				.setProjection(Projections.projectionList().add(Projections.property("ip.Id")));
		
		criteria.add(Restrictions.eq("h.Id", hospitalId));
			criteria.add(Restrictions.eq("hdr.RequisitionForDate", HMSUtil.convertStringTypeDateToDateType(requitiondate)));
			criteria.add(Restrictions.eq("mn.Id", diet_menu_type_id));
			
		patientId=criteria.list();
		map.put("patientId", patientId);		
		map.put("dietCombinationList", dietCombinationList);
		return map;
	} 
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDietForIndoorPatientList(Box box)
	{
		List<IpdDietRequisitionHeader> dietRequisitionHeaders = new ArrayList<IpdDietRequisitionHeader>();
		List<MasDiet> masDietList = new ArrayList<MasDiet>();
		List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		Session session = (Session)getSession();
		
		String requisitionDate=null;
		int diet_menu_typeId=box.getInt(DIET_MENU_ITEM_ID);
		int diet_type_id=box.getInt(DIET_TYPE_ID);
		if(box.getString("dietForDate").equals(""))
		{
			requisitionDate=(String)utilMap.get("currentDate");
		}
		else
		{
			requisitionDate=box.getString("dietForDate");
		}
		
		if(requisitionDate!=null && !requisitionDate.equals("") && diet_menu_typeId!=0 && diet_type_id!=0 )
		{
			Criteria criteria= session.createCriteria(IpdDietRequisitionDetails.class)
					.createAlias("DietRequisitionHeader", "hdr")
					.createAlias("DietCombination", "comb")
					.createAlias("comb.Menu", "mn")
					.createAlias("comb.Diet", "diet")
					.createAlias("hdr.Inpatient", "ip")
					.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("DietRequisitionHeader"))));
		
				criteria.add(Restrictions.eq("hdr.RequisitionForDate", HMSUtil.convertStringTypeDateToDateType(requisitionDate)));
				criteria.add(Restrictions.eq("IssueStatus", "n").ignoreCase());
				
				criteria.add(Restrictions.eq("mn.Id", diet_menu_typeId));
				
				criteria.add(Restrictions.eq("diet.Id", diet_type_id));	
				
				dietRequisitionHeaders=criteria.list();
				
				map.put("dietRequisitionHeaders", dietRequisitionHeaders);
		}
		masDietList=session.createCriteria(MasDiet.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		masMenuTypeList=session.createCriteria(MasMenuType.class)
				//.add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		
		map.put("masDietList", masDietList);
		map.put("masMenuTypeList", masMenuTypeList);
		return map;

	}
	
	@Override
	public Map<String, Object> submitDietForIndoorPatient(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		String dateToInsert=(String)utilMap.get("currentDate");
		Session session = (Session)getSession();
		Transaction tx = null;
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
		
		
		for(int i=1;i<=box.getInt("patientCount");i++)
		{
			if(box.getInt("dietRequisitionId"+i)!=0)
			{
				IpdDietRequisitionHeader dietRequisitionHeader=(IpdDietRequisitionHeader) hbt.get(IpdDietRequisitionHeader.class, box.getInt("dietRequisitionId"+i));
				
				 Set<IpdDietRequisitionDetails> dietRequisitionDetails=new HashSet<IpdDietRequisitionDetails>();
				 dietRequisitionDetails=dietRequisitionHeader.getIpdDietRequisitionDetails();
				 Iterator<IpdDietRequisitionDetails> iterator=dietRequisitionDetails.iterator();
				 while (iterator.hasNext()) {
					IpdDietRequisitionDetails ipdDietRequisitionDetails = (IpdDietRequisitionDetails) iterator
							.next();
					ipdDietRequisitionDetails.setIssueDate(HMSUtil.convertStringTypeDateToDateType(box.getString(REQUEST_DATE))); 
					ipdDietRequisitionDetails.setIssueStatus("y");
					ipdDietRequisitionDetails.setIssueRemarks(box.getString(REMARKS));
					hbt.update(ipdDietRequisitionDetails);
					
				}
				 	dietRequisitionHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(dateToInsert));
					dietRequisitionHeader.setLastChgTime((String)utilMap.get("currentTime"));
					Users users=new Users();
					users.setId(box.getInt(USER_ID));
					dietRequisitionHeader.setLastChgBy(users);
					hbt.update(dietRequisitionHeader);
				
				
			}
			
		}
		tx.commit();
		hbt.flush();
		hbt.clear();
		
		return map;
	}
	
	@Override
	public Map<String, Object>  getDetailForPassPrinting(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPassType> masPassTypeList=new ArrayList<MasPassType>();
		List<MasPassPrintReason> masPassPrintReasonList=new ArrayList<MasPassPrintReason>();
		Session session = (Session)getSession();
		int inpatientId=box.getInt("parent");
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int userId=box.getInt(USER_ID);
		
		Inpatient inpatient=(Inpatient) session.createCriteria(Inpatient.class)
				            .add(Restrictions.eq("Id", inpatientId))
				            .add(Restrictions.eq("Department.Id", deptId))
				            .add(Restrictions.eq("Hospital.Id", hospitalId)).uniqueResult();
		
		masPassTypeList=session.createCriteria(MasPassType.class)
	            .add(Restrictions.eq("Status", "y").ignoreCase())
	            .list();
		
		masPassPrintReasonList=session.createCriteria(MasPassPrintReason.class)
	            .add(Restrictions.eq("Status", "y").ignoreCase())
	            .list();
		
		
		map.put("inpatient", inpatient);
		map.put("masPassTypeList", masPassTypeList);
		map.put("masPassPrintReasonList", masPassPrintReasonList);
		
		return map;
	}
	
	@Override
	public Map<String, Object>  submitGeneratepass(Box box)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<IpdGatepassDetails> ipdGatepassDetailList=new ArrayList<IpdGatepassDetails>();
		List<IpdGatepassDetails> ipdGateplList=new ArrayList<IpdGatepassDetails>();
		List<IpdGatepassDetails> ipdGatPassList=new ArrayList<IpdGatepassDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap=HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		Session session = (Session)getSession();
		int inpatientId=box.getInt(INPATIENT_ID);
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int userId=box.getInt(USER_ID);
	
		Boolean saveMess=false;
		Date vlidTo=HMSUtil.convertStringTypeDateToDateType(box.getString("validtill"));
		Date vlidFrom=HMSUtil.convertStringTypeDateToDateType(box.getString("validfrom"));
		
		String attendentPass=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			attendentPass = prop
					.getProperty("maspasstypeattendent");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Transaction tx = null;
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		MasPassType masPassType=(MasPassType) hbt.get(MasPassType.class,  box.getInt("passtype"));
		
		ipdGatepassDetailList=session.createCriteria(IpdGatepassDetails.class)
				.add(Restrictions.eq("PassType.Id", box.getInt("passtype")))
				.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
		      	.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("ActiveStatus", "y").ignoreCase())
				.list();
	
	      if(box.getInt("passtype")==1 && box.getInt("printReason")==1){
	    	  ipdGateplList =session.createCriteria(IpdGatepassDetails.class)
			         .add(Restrictions.eq("PassType.Id", 1))
		   	        .add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
		      	   .add(Restrictions.eq("PrintReason.Id",1 )).list();
	    	
	    	
		     }
	      else if(box.getInt("printReason")==2){
	    	  ipdGateplList =session.createCriteria(IpdGatepassDetails.class)
			 .add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
			 .add(Restrictions.between("ValidTo",vlidFrom,vlidTo)).list();  
	    	  saveMess=true;
	      }
		
		ipdGateplList=session.createCriteria(IpdGatepassDetails.class)
				.add(Restrictions.eq("PassType.Id", 1))
				.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
		        .add(Restrictions.eq("PrintReason.Id",1 ))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("ActiveStatus", "y").ignoreCase())
				.list();
		
		
		if(masPassType!=null && masPassType.getPassTypeCode().equalsIgnoreCase(attendentPass))
		{
			if(ipdGatepassDetailList.size()>1)
			{
				ipdGatepassDetailList=ipdGatepassDetailList.subList(ipdGatepassDetailList.size()-2, ipdGatepassDetailList.size()-1);
				Iterator<IpdGatepassDetails> iterator=ipdGatepassDetailList.iterator();
				while (iterator.hasNext()) {
					IpdGatepassDetails  ipdGatepassDetails = (IpdGatepassDetails) iterator
							.next();
					ipdGatepassDetails.setActiveStatus("n");
					hbt.update(ipdGatepassDetails);
				}
			}
		}
		else
		{
			if(ipdGatepassDetailList.size()>0)
			{
				Iterator<IpdGatepassDetails> iterator=ipdGatepassDetailList.iterator();
				while (iterator.hasNext()) {
					IpdGatepassDetails  ipdGatepassDetails = (IpdGatepassDetails) iterator
							.next();
					ipdGatepassDetails.setActiveStatus("n");
					hbt.update(ipdGatepassDetails);
				}
			}
		}
		
		String sql = "select max(sl_no) from ipd_gatepass_details  where hospital_id ="+hospitalId;
		SQLQuery query = session.createSQLQuery(sql);
		String maxSlNo=(String) query.uniqueResult();
		
		
	if	(ipdGateplList.size()==0){
		
		IpdGatepassDetails ipdGatepassDetails=new IpdGatepassDetails();
		Patient hin=new Patient();
		hin.setId(box.getInt(HIN_ID));
		ipdGatepassDetails.setHin(hin);
		ipdGatepassDetails.setActiveStatus("y");
		MasHospital hospital=new MasHospital();
		hospital.setId(box.getInt(HOSPITAL_ID));
		ipdGatepassDetails.setHospital(hospital);
		Inpatient inpatient=new Inpatient();
		inpatient.setId(box.getInt(INPATIENT_ID));
		ipdGatepassDetails.setInpatient(inpatient);
		ipdGatepassDetails.setPassType(masPassType);
		MasPassPrintReason printReason=new MasPassPrintReason();
		printReason.setId(box.getInt("printReason"));
		ipdGatepassDetails.setPrintReason(printReason);
		ipdGatepassDetails.setValidFrom(HMSUtil.convertStringTypeDateToDateType(box.getString("validfrom")));
		ipdGatepassDetails.setValidTo(HMSUtil.convertStringTypeDateToDateType(box.getString("validtill")));
		ipdGatepassDetails.setPrintedDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		ipdGatepassDetails.setPrintedTime(currentTime);
		if(maxSlNo==null)
		{
			ipdGatepassDetails.setSlNo("1");
		}
		else
		{
			int slNo=Integer.parseInt(maxSlNo)+1;
			ipdGatepassDetails.setSlNo(String.valueOf(slNo));
		}
		Users users=new Users();
		users.setId(box.getInt(USER_ID));
		ipdGatepassDetails.setLastChgBy(users);
		ipdGatepassDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		ipdGatepassDetails.setLastChgTime(currentTime);
		ipdGatepassDetails.setRenewResion(box.getString("resion"));
		
		//------------------------------Start Billing ---------------------------
		/*
		if(box.get("amt")!="" && box.getInt("printReason")==2){
		
		
		 BlOpBillHeader blOpBillHeader=new BlOpBillHeader(); 
		 BlOpBillDetails  blOpBillDetails=new BlOpBillDetails();
		 Patient hinid=new Patient();
		 hinid.setId(box.getInt(HIN_ID));
		   blOpBillHeader.setHin(hinid);
		   MasHospital hosp=new MasHospital();
		   hosp.setId(box.getInt(HOSPITAL_ID));
		  blOpBillHeader.setHospital(hosp);
		  
		  BigDecimal amount= new BigDecimal(0);
		  blOpBillHeader.setBillAmt(new BigDecimal(box.get("amt")));
		  blOpBillDetails.setAmount(new  BigDecimal(box.get("amt")));
		  
		  
		  Users userObj=new Users();
		  userObj.setId(box.getInt(USER_ID));

		  blOpBillHeader.setChangedBy(userObj);
		  blOpBillDetails.setChangedBy(userObj);
		  
		  blOpBillDetails.setBillDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		  blOpBillHeader.setBillDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
		  blOpBillDetails.setBillTime(currentTime);
		  blOpBillHeader.setBillTime(currentTime);
		  blOpBillHeader.setStatus("y");
		  hbt.save(blOpBillHeader);
		  blOpBillDetails.setOpBillHeader(blOpBillHeader);
		  
		  hbt.save(blOpBillDetails);
		 
		}*/
		
		hbt.save(ipdGatepassDetails);
		tx.commit();
		hbt.flush();
		hbt.clear();
		saveMess=true;
		map.put("ipdGatepassDetails", ipdGatepassDetails);
		map.put("ipdGateplList", ipdGateplList);
	
	}

	map.put("saveMess", saveMess);

		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getItemId(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String pvmsNo=  box.getString("pvmsNo");
		Session session = (Session)getSession();
		itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", pvmsNo))
		  				.list();
		map.put("itemList", itemList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public synchronized String generateBillNo(String billType, String flag) {
		Integer billSeqNo = 0;
		List<Object[]> billSeqNoList = new ArrayList<Object[]>();

		Session session = (Session) getSession();
		try {
			billSeqNoList = session
					.createCriteria(BlParameter.class)
					.setProjection(
							Projections.projectionList()
									.add(Projections.property("BillSubType"))
									.add(Projections.property("Id"))
									.add(Projections.property("SeqNo"))
									.add(Projections.property("BillType")))
					.list();
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
			for (Object[] blParameter : billSeqNoList) {
				if (blParameter[0] != null
						&& !((String) blParameter[0]).equals("")) {
					if (billType.equals((String) blParameter[0])) {
						id = (Integer) blParameter[1];
						seqNo = (Integer) blParameter[2];
						// criteria = blParameter.getCriteria();
						billSeqNo = ++seqNo;
					}
				} else if (blParameter[3] != null && blParameter[0] == null) {
					if (billType.equals((String) blParameter[3])) {
						id = (Integer) blParameter[1];
						seqNo = (Integer) blParameter[2];
						// criteria = blParameter.getCriteria();
						billSeqNo = ++seqNo;
					}
				}
			}
			// billNo = commonSeqNo(billSeqNo, criteria, lastBlNo);

			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(billSeqNo);
				hbt.update(parameterObj);
			}
		}

		String blNo = billSeqNo.toString();
		return blNo;
	}
	
	private Map<String, Object> opBillingService(Map<String, Object> detailsMap)
	{
		int hospitalId = (Integer)detailsMap.get(DEPT_ID);
		int departmentId = (Integer)detailsMap.get(HOSPITAL_ID);
		int hinId = (Integer)detailsMap.get(HIN_ID);
		String hinNo = (String)detailsMap.get(HIN_NO);
		int empId = (Integer)detailsMap.get("empId");
		int userId=(Integer)detailsMap.get(USER_ID);
		int visitId=(Integer)detailsMap.get(VISIT_ID);		
		String orderNo = (String)detailsMap.get(ORDER_NO);
		int	orderId = (Integer)detailsMap.get(ORDER_BOOKING_ID);
		String billAmmount=(String)detailsMap.get(BILL_AMOUNT);
		Session session = (Session)getSession();
		
		
		Map<String, Object> utilMap=HMSUtil.getCurrentDateAndTime();
		
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
		MasHospital hospital = new MasHospital();
		hospital.setId(hospitalId);
		Patient patient = (Patient)hbt.get(Patient.class, hinId);
		Visit visit = (Visit) hbt.get(Visit.class, visitId);

			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			opBillHeader.setHospital(hospital);

			opBillHeader.setHin(patient);
			opBillHeader.setPatientStatus("r");
			opBillHeader.setHinNo(hinNo);
			opBillHeader.setVisit(visit);
			//opBillHeader.setTokenNo(Integer.parseInt(request.getParameter(TOKEN_NO)));
				opBillHeader.setConsultant(visit.getDoctor());
				opBillHeader.setPatientType(patient.getPatientType());
				opBillHeader.setPatientName(patient.getPFirstName());
				//opBillHeader.setAge(request.getParameter(AGE));
				opBillHeader.setSex(patient.getSex());
				if (visit.getDoctor() != null) {
					opBillHeader.setConsultantName(visit.getDoctor().getEmployeeName());
				}
				
//				if(billAmmount!=null){
//				opBillHeader.setBillAmt(new BigDecimal(billAmmount));
//				}else{
					opBillHeader.setBillAmt(new BigDecimal(0));
//				}
//				if (request.getParameter(DISCOUNT_AMOUNT) != null
//						&& !(request.getParameter(DISCOUNT_AMOUNT).equals(""))) {
//					BigDecimal totalDiscount = new BigDecimal("0");
//					totalDiscount = new BigDecimal(request
//							.getParameter(DISCOUNT_AMOUNT));
					opBillHeader.setDiscountAmt(new BigDecimal(0));
//					dataMap.put("totalDiscount", totalDiscount);
//				}
//				if (request.getParameter(ROUND_OF_VALUE) != null
//						&& !(request.getParameter(ROUND_OF_VALUE).equals(""))) {
					opBillHeader.setRoundOff(new BigDecimal(0));
//				}
//				if (request.getParameter(TOTAL_AMOUNT) != null
//						&& !(request.getParameter(TOTAL_AMOUNT).equals(""))) {
					opBillHeader.setNetAmt(new BigDecimal(0));
//				}
//				if (request.getParameter(ADVANCE_ADJUSTMENT) != null
//						&& !(request.getParameter(ADVANCE_ADJUSTMENT).equals(""))) {
					opBillHeader.setAdvanceAdjustment(new BigDecimal(0));
//					dataMap.put("advAdj", request.getParameter(ADVANCE_ADJUSTMENT));
//				}
//				if (request.getParameter(OUTSTANDING) != null
//						&& !(request.getParameter(OUTSTANDING).equals(""))) {
					opBillHeader.setOutstanding(new BigDecimal(0));
//					dataMap.put("outstanding", request.getParameter(OUTSTANDING));
//				}
//				if (request.getParameter(DISCOUNT_ON_BILL) != null
//						&& !(request.getParameter(DISCOUNT_ON_BILL).equals(""))) {
					opBillHeader.setDiscountOnBill(new BigDecimal(0));
//				}
//				if (request.getParameter(PAYABLE_AMOUNT) != null
//						&& !(request.getParameter(PAYABLE_AMOUNT).equals(""))) {
					opBillHeader.setPayableAmt(new BigDecimal(0));
//					dataMap.put("payAmt", request.getParameter(PAYABLE_AMOUNT));
//				}
//				if (request.getParameter(AUTHORIZER_ID) != null
//						&& !(request.getParameter(AUTHORIZER_ID).equals("0"))) {
//					MasAuthorizer authorizer = new MasAuthorizer();
//					authorizer.setId(Integer.parseInt(request
//							.getParameter(AUTHORIZER_ID)));
//					opBillHeader.setAuthorizer(authorizer);
//				}
//				if (request.getParameter("actualCollectedAmt") != null
//						&& !(request.getParameter("actualCollectedAmt").equals(""))) {
					opBillHeader.setActualCollectedAmt(new BigDecimal(0));
//				}
				opBillHeader.setBillDate(HMSUtil
						.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
				opBillHeader.setBillTime((String)utilMap.get("currentTime"));
				Users users=new Users();
				users.setId(userId);
				opBillHeader.setChangedBy(users);
				opBillHeader.setStatus("y");
				hbt.save(opBillHeader);
				
	
				
				String billNo = "";
				String billType = "OS";
				billNo = generateBillNo(billType, "save");
				opBillHeader.setBillNo(billNo);
					
					DgOrderhd dgOrderhd=(DgOrderhd)hbt.get(DgOrderhd.class, orderId);
					DgOrderhd dgOrderHd = (DgOrderhd) hbt.load(
							DgOrderhd.class, orderId);
					dgOrderHd.setBillChargeSlpNo(billNo);
					hbt.update(dgOrderHd);	
					Set<DgOrderdt>  dgOrderdts=new HashSet<DgOrderdt>();
					dgOrderdts=dgOrderhd.getDgOrderdts();
					
				Iterator<DgOrderdt> iterator=dgOrderdts.iterator();

					while (iterator.hasNext()) {
						DgOrderdt dgOrderdt = (DgOrderdt) iterator.next();
						if(!dgOrderdt.getPaymentMade().equalsIgnoreCase("y"))
						{
						BlOpBillDetails opBillDetail = new BlOpBillDetails();
						MasChargeCode masChargeCode = new MasChargeCode();

							opBillDetail.setChargeCode(dgOrderdt.getChargeCode());

//							if (rateList.get(i) != null
//									&& !(rateList.get(i).toString()).equals("")) {
								BigDecimal rate = new BigDecimal(0);
								opBillDetail.setRate(rate);
//							}
							
//								already commented
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
								
								//end of already commented
								
//							if (amountList.get(i) != null
//									&& !(amountList.get(i).toString())
//											.equals("")) {
								BigDecimal amount = new BigDecimal(0);
								opBillDetail.setAmount(amount);
//							}
//							if (disPercentList.size() > 0) {
//								if (disPercentList.get(i) != null
//										&& !(disPercentList.get(i).toString())
//												.equals("")) {
									BigDecimal discountPercent = new BigDecimal(0);
									opBillDetail
											.setDiscountPercent(discountPercent);
//								}
//							}
//							if (discountList.size() > 0) {
//								if (discountList.get(i) != null
//										&& !(discountList.get(i).toString())
//												.equals("")) {
									BigDecimal discount = new BigDecimal(0);
									opBillDetail.setDiscountAmt(discount);
//								}
//							}
//							if (proportionalDiscountList.size() > 0) {
//								if (proportionalDiscountList.get(i) != null
//										&& !(proportionalDiscountList.get(i)
//												.toString()).equals("")) {
									BigDecimal proportionalDiscount = new BigDecimal(0);
									opBillDetail
											.setProportionalDiscountAmount(proportionalDiscount);
//								}
//							}
//							if (netAmountList.get(i) != null
//									&& !(netAmountList.get(i).toString())
//											.equals("")) {
								BigDecimal netAmount = new BigDecimal(0);
								opBillDetail.setNetAmt(netAmount);
//							}
//							if (qtyList.get(i) != null
//									&& !(qtyList.get(i).toString()).equals("")) {
//								int qty = Integer.parseInt(qtyList.get(i)
//										.toString());
								opBillDetail.setQuantity(1);
//							}
							opBillDetail.setBillDate(HMSUtil
									.convertStringTypeDateToDateType((String)utilMap.get("currentDate")));
							opBillDetail.setBillTime((String)utilMap.get("currentTime"));
							opBillDetail.setChangedBy(users);
							opBillDetail.setOpBillHeader(opBillHeader);
							
							
							try {
								hbt.save(opBillDetail);
								opBillDetail.setRefundableStatus("y");
								dgOrderdt.setPaymentMade("y");
								dgOrderdt.setBill(opBillHeader);
								hbt.saveOrUpdate(dgOrderdt);
							} catch (DataAccessException e) {
								e.printStackTrace();
							}			
					}
					}
					
					
				tx.commit();
				hbt.flush();
				hbt.clear();
				
		}
		catch(Exception exception)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			
		}
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPaywardWaitingList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPaywardBooking> itemList = new ArrayList<BlPaywardBooking>();
		Session session = (Session)getSession();
		int totalAvailablebed=0;
		Integer deptId=box.getInt("deptId");
		int hospitalId=box.getInt(HOSPITAL_ID);
		
		Criteria cr = session.createCriteria(BlPaywardBooking.class)
				.createAlias("Payward", "payward")
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("payward.Id",deptId))
				.add(Restrictions.eq("BookingStatus", "p").ignoreCase())
				.addOrder(Order.desc("CurrentWaitingList"));
		if(box.getString("tokenNo")!=null && !box.getString("tokenNo").equals(""))
		{
			cr=cr.add(Restrictions.eq("payward.DepartmentName",box.getString("tokenNo") ));
		}
		/*if(box.getString("patientName")!=null && !box.getString("patientName").equals(""))
		{
			cr=cr.add(Restrictions.eq(, value))
		}*/
		if(box.getString("uhid")!=null && !box.getString("uhid").equals(""))
		{
			cr=cr.add(Restrictions.eq("hin.HinNo", box.getString("uhid")));
		}
		/*if(box.getString("wardNo")!=null && !box.getString("wardNo").equals(""))
		{
			cr=cr.add(Restrictions.eq(, value))
		}*/
		itemList=cr.list();
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<MasBed> beds=new ArrayList<MasBed>();

		beds = session
				.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.asc("BedNo"))
				.createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode",
						bedStatusUnOccupiedName))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
				.add(Restrictions.isNull("VBed")).list();
		
		map.put("availablebed",beds.size());
		map.put("itemList", itemList);
		return map;
	}
	
	@Override
	public Map<String, Object> submitPayward(Box box){
	Map<String, Object> map = new HashMap<String, Object>();
		List<BlPaywardBooking> itemList = new ArrayList<BlPaywardBooking>();
		Session session = (Session)getSession();
		List<MasBed> beds=new ArrayList<MasBed>();
		Integer deptId=box.getInt("deptId");
		int hospitalId=box.getInt(HOSPITAL_ID);
		
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		
		beds = session
				.createCriteria(MasBed.class)
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.addOrder(Order.asc("BedNo"))
				.createAlias("BedStatus", "bs")
				.add(Restrictions.eq("bs.BedStatusCode",
						bedStatusUnOccupiedName))
				.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
				.add(Restrictions.isNull("VBed")).list();
		
		List<String> bookingId=new ArrayList<String>();
		bookingId=box.getArrayList("bookingId");
		if(bookingId.size()<=beds.size()){
			for(String str:bookingId){
				BlPaywardBooking booking=(BlPaywardBooking)hbt.get(BlPaywardBooking.class, Integer.parseInt(str));
				booking.setBookingStatus("a");
				booking.setApproveDate(new Date());
				hbt.update(booking);
				hbt.flush();
				hbt.clear();
			}
			map.put("message", "Approve Successfully");
		}else{
			map.put("message", "Bed not available");
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getPrescriptionTemplate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
		Session session =(Session) getSession();
		Integer tempId=Integer.parseInt(box.get("templateId"));
		List<OpdTemplateTreatment>templateTreatments=new ArrayList<OpdTemplateTreatment>();
		List<RouteOfAdministration>route=new ArrayList<RouteOfAdministration>();
		List<OpdInstructionTreatment>instrunction=new ArrayList<OpdInstructionTreatment>();
		List<MasFrequency>frequencyList=new ArrayList<MasFrequency>();
		
		frequencyList = session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
		instrunction = session.createCriteria(OpdInstructionTreatment.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
		route=session.createCriteria(RouteOfAdministration.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
		templateTreatments = session.createCriteria(OpdTemplateTreatment.class).createAlias("Template", "temp")
					.add(Restrictions.eq("temp.Id", tempId))
					.list();
		logger.info("templateTreatmentstemplateTreatments  "+templateTreatments.size());
		
		map.put("template", templateTreatments);
		map.put("route", route);
		map.put("instrunction", instrunction);
		map.put("frequencyList", frequencyList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> getLabInvestigationTemplate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		try{
		Session session =(Session) getSession();
		Integer tempId=Integer.parseInt(box.get("templateId"));
		List<OpdTemplateInvestigation>tempInvestigation=new ArrayList<OpdTemplateInvestigation>();
		tempInvestigation = session.createCriteria(OpdTemplateInvestigation.class).createAlias("Template", "temp")
					.add(Restrictions.eq("temp.Id", tempId))
					.list();
		map.put("template", tempInvestigation);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> houseKeepingSetup(Box box) {

		List<MasHouseKeeping> masHouseKeepingList = new ArrayList<MasHouseKeeping>();
		List<HouseKeepingSetup> houseKeepingSetupList = new ArrayList<HouseKeepingSetup>();
		List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		List<MasHouseKeepingFrequency> houseKeepingFrequenciyList = new ArrayList<MasHouseKeepingFrequency>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		
		List<IpdVitalSetup> ipdVitalSetupList = new ArrayList<IpdVitalSetup>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String mas_department_type_ward=null;
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("table_constant.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			mas_department_type_ward=prop.getProperty("mas_department_type_ward");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Session session = (Session) getSession();
//		box.getInt(HOSPITAL_ID)
		try {
			
			masHouseKeepingList = session.createCriteria(MasHouseKeeping.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			houseKeepingFrequenciyList = session.createCriteria(MasHouseKeepingFrequency.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			frequencyList = session.createCriteria(MasFrequency.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			houseKeepingSetupList = session
					.createCriteria(HouseKeepingSetup.class)
					.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
					.list();	
			
			wardList = session
					.createCriteria(MasInstituteDepartment.class,"msd")
					.createAlias("msd.Department", "md")
					.createAlias("md.DepartmentType", "mdt")
					.createAlias("msd.Institute", "mh")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("mdt.DepartmentTypeCode", mas_department_type_ward.toLowerCase()).ignoreCase())
					.add(Restrictions.eq("md.Status", "y").ignoreCase())
					.add(Restrictions.eq("mh.Id", box.getInt(HOSPITAL_ID)))
					.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masHouseKeepingList", masHouseKeepingList);
		map.put("houseKeepingFrequenciyList", houseKeepingFrequenciyList);
		map.put("frequencyList", frequencyList);
		map.put("houseKeepingSetupList", houseKeepingSetupList);
		map.put("wardList", wardList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addHouseKeeping(Box box) {
		boolean succesfullyAdded = false;
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		
		
		String time = (String) utilMap.get("currentTime");
		int hospitalId = (Integer) box.getInt(HOSPITAL_ID);
		int userId = (Integer) box.getInt(USER_ID);
		int deptId = (Integer) box.getInt(DEPT_ID);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			int i = 0;
			int count=box.getInt("nursingcarecount");
			Users users = new Users();
			users.setId(userId);
			for (int j = 1; j <= count; j++) {
				if(box.getString("activity"+j)!=null && !box.getString("activity"+j).equals("") && box.getInt("activity"+j)!=0)
				{
					HouseKeepingSetup houseKeepingSetup = null;
					
					List<HouseKeepingSetup> houseKeepingSetupList=new ArrayList<HouseKeepingSetup>();
				
					houseKeepingSetupList = session.createCriteria(HouseKeepingSetup.class)
							.add(Restrictions.eq("HouseKeeping.Id", box.getInt("activity"+j)))
							.add(Restrictions.eq("Department.Id", box.getInt("ward"+j)))
							.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
					
					if(houseKeepingSetupList.size()==0)
					{
						houseKeepingSetup = new HouseKeepingSetup();
					MasHouseKeeping houseKeeping = new MasHouseKeeping();
					houseKeeping.setId(box.getInt("activity"+j));
					houseKeepingSetup.setHouseKeeping(houseKeeping);
					
					MasDepartment department = new MasDepartment();
					department.setId(box.getInt("ward"+j));
					houseKeepingSetup.setDepartment(department);
					
					MasHouseKeepingFrequency houseKeepingFrequency=new MasHouseKeepingFrequency();
					houseKeepingFrequency.setId(box.getInt("dayFrequency"+j));
					houseKeepingSetup.setHouseKeepingFrequency(houseKeepingFrequency);
				
					houseKeepingSetup.setLastChgBy(users);
					houseKeepingSetup.setLastChgTime(time);
					houseKeepingSetup.setLastChgDate(dateToInsert);
					
					MasFrequency masFrequency = new MasFrequency();
					masFrequency.setId(box.getInt("frequency"+j));
					houseKeepingSetup.setFrequency(masFrequency);
					
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					houseKeepingSetup.setHospital(hospital);
					houseKeepingSetup.setRemarks(box.getString("careremarks"+j));
					hbt.save(houseKeepingSetup);
					}
					else
					{
						houseKeepingSetup=houseKeepingSetupList.get(0);
					
						houseKeepingSetup.setLastChgBy(users);
						houseKeepingSetup.setLastChgTime(time);
						houseKeepingSetup.setLastChgDate(dateToInsert);
						
						MasHouseKeepingFrequency houseKeepingFrequency=new MasHouseKeepingFrequency();
						houseKeepingFrequency.setId(box.getInt("dayFrequency"+j));
						houseKeepingSetup.setHouseKeepingFrequency(houseKeepingFrequency);
						
						MasFrequency masFrequency = new MasFrequency();
						masFrequency.setId(box.getInt("frequency"+j));
						houseKeepingSetup.setFrequency(masFrequency);
						houseKeepingSetup.setRemarks(box.getString("careremarks"+j));						
						hbt.update(houseKeepingSetup);
												
					}
				}
			}
			hbt.flush();
			hbt.clear();
			tx.commit();
			succesfullyAdded = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return succesfullyAdded;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchHouseKeeping(Box box) {

		List showList = new ArrayList();
		List<HouseKeepingService> ipdCareDetails = new ArrayList<HouseKeepingService>();
		List<HouseKeepingSetup> houseKeepingSetupList = new ArrayList<HouseKeepingSetup>();
		int nursingCareSetupId = 0;
		
		int nursingId = 0;
		int maxHousekeepingFrequency=0;

		Session session = (Session) getSession();
		// careId=(Integer)map.get("careId");
//		nursingCareSetupId = (Integer) map.get("nursingCareSetupId");
		 Map<String ,Object> map= new HashMap<String, Object>();
			int hospitalId = (Integer) box.getInt(HOSPITAL_ID);
			int userId = (Integer) box.getInt(USER_ID);
			int deptId = (Integer) box.getInt(DEPT_ID);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Criteria housekeepingSetupCriteria = session.createCriteria(
					HouseKeepingSetup.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					//.add(Restrictions.eq("Status", "y").ignoreCase())
					;

			houseKeepingSetupList = housekeepingSetupCriteria.list();
			BigDecimal maxHousekeepingFrequency1=new BigDecimal(0);
			maxHousekeepingFrequency1=(BigDecimal) session.createCriteria(HouseKeepingSetup.class,"ncs")
					.createAlias("ncs.Hospital", "h")
					.createAlias("ncs.Frequency", "frq")
					.add(Restrictions.eq("h.Id", hospitalId))
					//.add(Restrictions.eq("ncs.Status", "y").ignoreCase())
					.setProjection(Projections.max("frq.FrequencyCount")).uniqueResult();
			maxHousekeepingFrequency=maxHousekeepingFrequency1.intValue();
			Integer maxDays=((Number) session.createCriteria(HouseKeepingSetup.class,"ncs")
					.createAlias("ncs.Hospital", "h")
					.createAlias("ncs.HouseKeepingFrequency", "frq")
					.add(Restrictions.eq("h.Id", hospitalId))
					//.add(Restrictions.eq("ncs.Status", "y").ignoreCase())
					.setProjection(Projections.max("frq.FrequencyCount")).uniqueResult()).intValue();
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(HMSUtil.convertStringTypeDateToDateType(date));
			calendar.add(Calendar.DAY_OF_MONTH, (-1)*maxDays);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
		     calendar.set(Calendar.SECOND, 0);
			
			ipdCareDetails=session.createCriteria(HouseKeepingService.class,"icd")
					.createAlias("icd.Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.add(Restrictions.ge("icd.ServiceDate",calendar.getTime()))
					.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("houseKeepingSetupList", houseKeepingSetupList);
		map.put("maxHousekeepingFrequency", maxHousekeepingFrequency);
		map.put("ipdCareDetails", ipdCareDetails);
//		
//		map.put("ipdVitalSetups", ipdVitalSetups);
//		map.put("maxVitalFrequency", maxVitalFrequency);
//		map.put("ipdVitalcareDetails", ipdVitalcareDetails);
		return map;
	}
	
	@Override
	public boolean submitHouseKeepingDetails(Box box) {

		boolean succesfullyAdded = false;
		int hospitalId=box.getInt(HOSPITAL_ID);
		int deptId=box.getInt(DEPT_ID);
		int userId=box.getInt(USER_ID);
		String careStringDate=box.getString("caredate");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
		Date careDate = HMSUtil.convertStringTypeDateToDateType(careStringDate);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			int counter =box.getInt("counter");
			for (int i=1;i<=counter;i++) {
				String care=box.getString("care"+i);
				if (care!=null && !care.equals("")) {
					int activityId=box.getInt("activity"+i);
					HouseKeepingSetup houseKeepingSetup=(HouseKeepingSetup) hbt.get(HouseKeepingSetup.class, activityId);
					HouseKeepingService houseKeepingService=new HouseKeepingService();
					houseKeepingService.setHouseKeepingSetup(houseKeepingSetup);
					houseKeepingService.setHouseKeeping(houseKeepingSetup.getHouseKeeping());
					houseKeepingService.setDepartment(houseKeepingSetup.getDepartment());					
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					houseKeepingService.setHospital(masHospital);
					houseKeepingService.setStatus("y");
					
					Users users = new Users();
					users.setId(userId);
					houseKeepingService.setLastChgBy(users);
					houseKeepingService.setLastChgDate(dateToInsert);
					houseKeepingService.setLastChgTime(time);
					houseKeepingService.setServiceDate(careDate);
					houseKeepingService.setServiceTime(box.getString("caretime"+i));
					if (!box.getString("careremarks"+i).equals("")) {
						houseKeepingService.setRemarks(box.getString("careremarks"+i));
					} else {
						houseKeepingService.setRemarks("");
					}
					
					hbt.save(houseKeepingService);					
					succesfullyAdded = true;
					hbt.flush();
				} 
			}
					} catch (HibernateException e) {
			e.printStackTrace();
		}
		return succesfullyAdded;
	}

	

	@Override
	public int getHinId(String adNo) {
			Session session=(Session)getSession();
			List<Inpatient>ipList=new ArrayList<Inpatient>();
			int hinId=0;
			ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", adNo)).list();
			for(Inpatient ip:ipList){
				hinId=ip.getHin().getId();
			}
			return hinId;
	}


	@Override
	public Map<String, Object> showBloodRequestEntryJsp(int hinId,int hospitalId) {
		
		String ipNumber="";
		int inPatientId=0;
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatient=new ArrayList<Inpatient>(); 
		List<MasBloodGroup> componentList = new ArrayList<MasBloodGroup>();
		List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
		
		Session session = (Session) getSession();
		
		try {
			bloodBankList=session.createCriteria(MasHospital.class)
					//Changed by Arbind on 06-11-2017
					//.add(Restrictions.eq("Id", hospitalId))
					.add(Restrictions.eq("BbAvailable", "Y").ignoreCase()).list();
			
			componentList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (componentList.size() > 0) {
				detailsMap.put("componentList", componentList);
			}
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
			if (patientList != null || patientList.size() > 0) {
				detailsMap.put("patientList", patientList);
			}
			if(hinId>0){
				//System.out.println("hinId hinId @@@@ ### "+hinId);
				    
			inpatient=(List<Inpatient>) session.createCriteria(Inpatient.class).
					createAlias("Hin", "hin").add(Restrictions.eq("hin.Id", hinId)).list();
						
						
			for(Inpatient ipatient: inpatient){
				ipNumber=ipatient.getAdNo();
				inPatientId=ipatient.getId();
				
			//	System.out.println("inPatientId inPatientId @@@@ ### "+inPatientId);
			}
			detailsMap.put("ipNumber", ipNumber);
			detailsMap.put("inPatientId", inPatientId);
			detailsMap.put("bloodBankList", bloodBankList);
			}
			List<BloodTransfussionReactionHd> bloodTransfussionReactionHd=new ArrayList<BloodTransfussionReactionHd>();
			
		Criteria crt=	session.createCriteria(BloodTransfussionReactionHd.class)
			
			.createAlias("Hin", "hin")
			.add(Restrictions.eq("hin.Id", hinId));
		bloodTransfussionReactionHd=crt.list();
		//System.out.println("issueDetailsList "+bloodTransfussionReactionHd.size());
		int totalTransfussionCount=0;
		String transfussionTime="";
		String transfussionDate=null;
		if(null !=bloodTransfussionReactionHd && bloodTransfussionReactionHd.size()>0){
		for(BloodTransfussionReactionHd transfussionHeader:bloodTransfussionReactionHd){
			transfussionDate=HMSUtil.convertDateToStringTypeDateOnly(transfussionHeader.getTestDate()) ;
			transfussionTime=transfussionHeader.getLastChgTime();
			
			//System.out.println("transfussionDate "+transfussionDate);
		}
		}
		detailsMap.put("totalTransfussionCount",bloodTransfussionReactionHd.size() );
		detailsMap.put("transfussionDate",transfussionDate );
		detailsMap.put("transfussionTime",transfussionTime );
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@Override
	public String getOrderSeqForDisplay(String string,int hospitalId) {
		List<Integer> orderSeqNoList = new ArrayList<Integer>();
		List<BloodRequestEntryHeader> seqNoList = new ArrayList<BloodRequestEntryHeader>();
		String orderSeqNo = "";
		String lastSeqNo = "";
		String lastSeqYear = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentYear = date.substring(date.lastIndexOf("/") + 1);
		Session session = (Session) getSession();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int tsn = 0;
		int id = 0;
		try {
			seqNoList = session.createCriteria(BloodRequestEntryHeader.class)
					.list();
			if (seqNoList.size() > 0) {
				for (BloodRequestEntryHeader requestEntryHeader : seqNoList) {
					lastSeqNo = requestEntryHeader.getOrderNo();
				}
				StringTokenizer str = new StringTokenizer(lastSeqNo, "/");
				while (str.hasMoreTokens()) {
					lastSeqYear = str.nextToken();
				}
			} else {
				lastSeqYear = currentYear;
			}
			//
			
			List<Object[]> adList = session
					.createCriteria(TransactionSequence.class).createAlias("Hospital", "hosp")
					.add(Restrictions.eq("TransactionPrefix", "RON"))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.setProjection(Projections.projectionList()
							.add(Projections.property("TransactionSequenceNumber"))
							.add(Projections.property("LastChgDate"))
							.add(Projections.property("Id")))
					.list();
			logger.info("size "+adList.size());

			if (adList.size() > 0) {
				Object[] transactionSequence = adList.get(0);
				tsn = Integer.parseInt("" + transactionSequence[0]);
				id = (Integer) transactionSequence[2];	
				
			}
			else{
				TransactionSequence tsObj = new TransactionSequence();
				tsObj.setStatus("y");
				tsObj.setTablename("BldRequestHeader");
				tsObj.setTransactionPrefix("RON");
				tsObj.setTransactionSequenceName("Order No");
				tsObj.setTransactionSequenceNumber(1);
				tsObj.setCreatedby("admin");
				tsObj.setStatus("y");
				MasHospital hosp=new MasHospital();
				hosp.setId(hospitalId);
				tsObj.setHospital(hosp);
				hbt.save(tsObj);
				orderSeqNo = String.valueOf(1);
				hbt.save(tsObj);
			}
			int ron=0;
			 if (adList.size() > 0) {
				
					if (currentYear.equals(lastSeqYear)) {
						orderSeqNo = String.valueOf(tsn + 1);
						ron=tsn + 1;
					} else {
						orderSeqNo = String.valueOf(1);
						ron=1;
					}
			
				TransactionSequence transactionSequenceObj = (TransactionSequence) session
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(ron);
				
				hbt.update(transactionSequenceObj);
			}
			orderSeqNo = orderSeqNo.concat("/").concat(
					String.valueOf(lastSeqYear));
		
		
		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return orderSeqNo;
	}
	
	@Override
	public Map<String, Object> searchPatientForPostPaid(Box box) {
		 Map<String ,Object> map= new HashMap<String, Object>();
			Session session = (Session) getSession();

		 List<Inpatient> inpatientList=new ArrayList<Inpatient>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		 String departmentTypeCodeForWard=null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				departmentTypeCodeForWard=prop.getProperty("departmentTypeCodeForWard");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		 int wardId=box.getInt(WARD);
		 if(wardId!=0)
		 {
			 inpatientList=session.createCriteria(Inpatient.class)
					 .createAlias("Department", "department")
					  .createAlias("Hospital", "hospital")
					 .add(Restrictions.eq("department.Id", wardId))
					  .add(Restrictions.eq("AdStatus","a").ignoreCase())
					  .add(Restrictions.isNotNull("Bed"))
					   .add(Restrictions.eq("department.Id", wardId))
					    .add(Restrictions.eq("hospital.Id", box.getInt(HOSPITAL_ID)))
					 .list();
		 }
		 departmentList = session
					.createCriteria(MasInstituteDepartment.class,"msd")
					.createAlias("msd.Department", "md")
					.createAlias("md.DepartmentType", "mdt")
					.createAlias("msd.Institute", "mh")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("mdt.DepartmentTypeCode", departmentTypeCodeForWard.toLowerCase()).ignoreCase())
					.add(Restrictions.eq("md.Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("mh.Id", box.getInt(HOSPITAL_ID)))
					.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
		 
		 map.put("inpatientList", inpatientList);
		 map.put("departmentList", departmentList);
		 return map;
		
	}
	
	@Override
	public Map<String, Object> submitForPostPaid(Box box) {
		 boolean successfull=false;
		 Map<String ,Object> map= new HashMap<String, Object>();
			Session session = (Session) getSession();
			Transaction tx=null;
			try{
				tx=session.beginTransaction();
				MasEmployee employee=new MasEmployee();
				employee.setId(box.getInt("empId"));
				List<String> inpatients=box.getArrayList("inpatientId");
				for(String id:inpatients)
				{
					if(!id.equals(""))
					{
						int inpatientId=Integer.parseInt(id);
						Inpatient inpatient=(Inpatient) session.get(Inpatient.class, inpatientId);
						inpatient.setPostpaidStatus("y");
						inpatient.setPostpaidBy(employee);
						session.update(inpatient);
					}
				}
				tx.commit();
				session.flush();
				successfull=true;
			}
			catch(Exception exception)
			{
				if(tx!=null)
					tx.rollback();
				
			}
			map.put("status", successfull);
			return map;
	}


	@Override
	public Map<String, Object> showAmbulanceRunRequest(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<AmbulanceRegister> ambulanceRegisterList=new ArrayList<AmbulanceRegister>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		
		Session session = (Session) getSession();
		
		ambulanceRegisterList=session.createCriteria(AmbulanceRegister.class,"ambregs")
				.add(Restrictions.eq("ambregs.RequestStatus", "p").ignoreCase())
				.add(Restrictions.eq("ambregs.Department.Id",box.getInt(DEPT_ID)))
				.add(Restrictions.eq("ambregs.Hospital.Id",box.getInt(HOSPITAL_ID)))
				//.add(Restrictions.eq("ambregs.AmbulanceRunDate",new Date()))
				.list();
		
		map.put("ambulanceRegisterList", ambulanceRegisterList);
		return map;
		
	}

	

	@Override
	public Map<String, Object> saveAmbulanceRunRequestDetails(Box box) {
		Map<String,Object> map = new HashMap<String, Object>();
		boolean flag = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session =(Session)getSession();
		try {
			
/*			AmbulanceRegister ambulanceRegister = (AmbulanceRegister) hbt.get(AmbulanceRegister.class, box.getInt("ambulanceId"));
*/			
			List<AmbulanceRegister>AmbulanceRegisterList=new ArrayList<AmbulanceRegister>();
			AmbulanceRegisterList=session.createCriteria(AmbulanceRegister.class).add(Restrictions.eq("Id",box.getInt("ambulanceId"))).list();
			for(AmbulanceRegister ambulanceRegister2:AmbulanceRegisterList){
				
				ambulanceRegister2.setAmbulanceRunDate(HMSUtil.convertStringTypeDateToDateType(box.getString(AMBULANCE_RUN_DATE)));
				ambulanceRegister2.setAmbulanceRunTime(box.getString(AMBULANCE_RUN_TIME));
				ambulanceRegister2.setFromSmc(box.getString(FROM_SMC));
				ambulanceRegister2.setToDestination(box.getString(DESTINATION));
			
				ambulanceRegister2.setPatientName(box.getString(PATIENT_NAME));
				ambulanceRegister2.setRemarks(box.getString(REMARKS));
				
				
			if(box.getString("attendants")!=null && !box.getString("attendants").equals(""))
			{
				ambulanceRegister2.setAttendents(box.getString("attendants"));
			}
			
			//ambulanceRegister2.setRequestStatus("f");
	
			ambulanceRegister2.setStatus("F");
			ambulanceRegister2.setBillStatus("n");
			
			hbt.update(ambulanceRegister2);
			
			flag = true;
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		/*map = showAmbulanceRunRegister(box);*/
		map.put("flag", flag);
		return map;
	}

	

	@Override
	public Map<String, Object> showWaitingForBlodTransfusionJsp(Box box) {

		Session session=(Session)getSession();
		List<BloodRequestEntryHeader>requestEntryList=new ArrayList<BloodRequestEntryHeader>();
		Map<String,Object>map=new HashMap<String,Object>();
		requestEntryList=session.createCriteria(BloodRequestEntryHeader.class).add(Restrictions.eq("Hospital.Id",box.getInt("hospitalId"))).add(Restrictions.eq("ReferTo","O").ignoreCase()).list();
		map.put("requestEntryList",requestEntryList);
		
		return map;
	}

	@Override
	public Map<String, Object> showWardWasteHandoverjsp(Box box) {
		Session session=(Session)getSession();
		List<MasWasteCategory>wasteCategoryList=new ArrayList<MasWasteCategory>();
		List<MasWasteContainer>wasteContainerList=new ArrayList<MasWasteContainer>();
		Map<String,Object>map=new HashMap<String,Object>();
		wasteCategoryList=session.createCriteria(MasWasteCategory.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		wasteContainerList=session.createCriteria(MasWasteContainer.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("wasteCategoryList",wasteCategoryList);
		map.put("wasteContainerList",wasteContainerList);
		return map;
	}

	@Override
	public Map<String, Object> addWasteHandOver(Box box) {
		Transaction tx = null;
		Map<String,Object>map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		int hospitalId=0;
		int departmentId=0;
		String colour="";
		BigDecimal qty=new BigDecimal(0);
		int containerId=0;
		int categoryId=0;		
		int userId=0;	
		boolean saved=false;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			if(box.get("hospitalId")!=null){
				hospitalId=(Integer.parseInt(box.get("hospitalId")));
			}
			if(box.get(DEPT_ID)!=null){
				departmentId=(Integer.parseInt(box.get(DEPT_ID)));
			}
			if(box.get("wasteCategory")!=null){
				categoryId=Integer.parseInt(box.get("wasteCategory"));
			}
			
			if(box.get("container")!=null){
				containerId=Integer.parseInt(box.get("container"));
			}
			if(box.get("colour")!=null)
			{
				colour=box.get("colour");
			}
			if(box.get("container")!=null){
				containerId=Integer.parseInt(box.get("container"));
			}
			if(box.get("userId")!=null){
				userId=Integer.parseInt(box.get("userId"));
			}
			if(box.get("qty")!=null){
				qty=new BigDecimal(box.get("qty"));
			}
			BioWasteHandOver bioWasteHandOver =new BioWasteHandOver();

			MasWasteCategory category=new MasWasteCategory();
			category.setId(categoryId);
			bioWasteHandOver.setCategory(category);
			
			MasWasteContainer container=new MasWasteContainer();
			container.setId(containerId);
			bioWasteHandOver.setContainer(container);
		
			MasHospital hospital1= new MasHospital();
			hospital1.setId(hospitalId);
			bioWasteHandOver.setHospitalId(hospital1);
			
			
			MasDepartment md=new MasDepartment();
			md.setId(departmentId);
			bioWasteHandOver.setDepartmentId(md);
			
			Users user=new Users();
			user.setId(userId);
			bioWasteHandOver.setLastChgBy(user);
			
			bioWasteHandOver.setStatus("P");
			bioWasteHandOver.setQty(qty);
			bioWasteHandOver.setColour(colour);
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			String time = (String)utilMap.get("currentTime");
			
			bioWasteHandOver.setLasChgDate(new Date());
			bioWasteHandOver.setLastChgTime(time);
			
			hbt.save(bioWasteHandOver);
			hbt.flush();
			tx.commit();
			
		}catch(Exception e){
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		saved=true;
		
		map.put("saved",saved);
		return map;
	}

	@Override
	public Map<String, Object> showWardWasteDisposaljsp(Box box) {
		Session session=(Session)getSession();
		List<BioWasteHandOver>BioWasteHandOverList=new ArrayList<BioWasteHandOver>();
		BioWasteHandOverList=session.createCriteria(BioWasteHandOver.class).add(Restrictions.eq("Status","P").ignoreCase()).list();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("BioWasteHandOverList",BioWasteHandOverList);
		return map;
	}



	@Override
	public Map<String, Object> getDetailsForwasteDisposal(int headerId,
			int hospitalId) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		List<BioWasteHandOver>BioWasteHandOverList=new ArrayList<BioWasteHandOver>();
		List<MasWasteDisposal>disposalList=new ArrayList<MasWasteDisposal>();
		BioWasteHandOverList=session.createCriteria(BioWasteHandOver.class).add(Restrictions.eq("Id",headerId)).add(Restrictions.eq("HospitalId.Id",hospitalId)).list();
		disposalList=session.createCriteria(MasWasteDisposal.class).add(Restrictions.eq("Status","y").ignoreCase()).list();
		map.put("BioWasteHandOverList",BioWasteHandOverList);
		map.put("disposalList",disposalList);
		return map;
	}


	@Override
	public boolean saveDispDetails(BioWasteDisposal bioWasteDisposal,int headerId) {

		boolean successfullyAdded = false;
		Transaction tnx=null;
		Session session=(Session) getSession();
		List<BioWasteHandOver>handOverList=new ArrayList<BioWasteHandOver>();
		try{
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		tnx=session.beginTransaction();
		hbt.save(bioWasteDisposal);
        hbt.flush();
        session.flush();
		
		handOverList=session.createCriteria(BioWasteHandOver.class).add(Restrictions.eq("Id",headerId)).list();
		for(BioWasteHandOver BioWasteHandOver:handOverList){
			
			BioWasteHandOver.setStatus("C");
			hbt.update(BioWasteHandOver);
			hbt.flush();
			
		}
		tnx.commit();
		successfullyAdded = true;
		}catch(Exception e){
			tnx.rollback();
			e.printStackTrace();
			
		}
		return successfullyAdded;
	}

	
	@Override
	public Map<String, Object> getServiceGrid(String service, String hinNo) {
		Session session=(Session)getSession();
		logger.info("service--->"+service +"hinNo----->"+hinNo);
		Map<String,Object>map=new HashMap<String,Object>();
		List<Object[]>serviceList=new ArrayList<Object[]>();
		List<Patient>patientList=new ArrayList<Patient>();
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",hinNo.trim())).list();
		int hinId=0;
		for(Patient pt:patientList){
			hinId=pt.getId();
		}
		List<Inpatient>ipList=new ArrayList<Inpatient>();
		List<String>aList=new ArrayList<String>();
		aList.add("A");
		aList.add("R");
		ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id",hinId)).add(Restrictions.in("AdStatus",aList)).list();
		int inpatientId=0;
		String query="";
		for(Inpatient inpatient:ipList){
			inpatientId=inpatient.getId();
		}
		if(service.equalsIgnoreCase("presc")){
			query="select dt.id,item.nomenclature,hd.prescription_date,prescription_time from inpatient_prescription_details dt "+
" left outer join inpatient_prescription_header hd on hd.prescription_id=dt.prescription_id "+
" left outer join mas_store_item item on item.item_id=dt.item_id "+
" where hd.inpatient_id="+inpatientId+" and dt.issued_status='p'";
			
			serviceList=session.createSQLQuery(query).list();
		}else if(service.equalsIgnoreCase("inv")){
			query="select dt.orderdt_id,mcc.charge_code_name,dt.last_chg_date,dt.last_chg_time from dg_orderdt dt "+
" 	left outer join dg_orderhd hd on hd.orderhd_id=dt.orderhd_id "+
" 	left outer join mas_charge_code mcc on mcc.charge_code_id=dt.charge_code_id "+
" 	where hd.inpatient_id in("+inpatientId+") and dt.order_status='P'";
		serviceList=session.createSQLQuery(query).list();
		
		}else 		if(service.equalsIgnoreCase("diet")){
			query="select dt.id,mdi.diet_name from ipd_patient_diet  dt "+
//" left outer join ipd_diet_requisition_header hd on hd.diet_requisition_header_id=dt.diet_requisition_header_id "+
" left outer join mas_diet mdi on mdi.diet_id=dt.diet_id "+
" where dt.inpatient_id="+inpatientId+" and dt.status='Y'";
			serviceList=session.createSQLQuery(query).list();	
			
		}else 		if(service.equalsIgnoreCase("procId")){
			query="select d.id,c.charge_code_name  from opd_surgery_detail  d "+
" left outer join opd_surgery_header h on h.opd_surgery_id=d.opd_surgery_id "+
" left outer join mas_charge_code c on c.charge_code_id=d.charge_code_id "+
" where d.status='P'  and h.inpatient_id="+inpatientId;
			
			serviceList=session.createSQLQuery(query).list();	
		}else 		if(service.equalsIgnoreCase("trans")){
			query="select trans.transfer_id,md.department_name from transfer trans  "+
" left outer join inpatient ip on ip.inpatient_id=trans.inpatient_id  "+
" left outer join mas_department md on md.department_id=trans.to_ward_id  "+ 
" where trans.inpatient_id in("+inpatientId+") and trans.status='y'";
			serviceList=session.createSQLQuery(query).list();	
		} else if(service.equalsIgnoreCase("dis")){
			query="select ip.inpatient_id,md.department_name,pt.p_first_name,pt.hin_no   "+ 
					" from inpatient ip   "+
					" left outer join mas_department md on md.department_id=ip.department_id  "+
					" left outer join patient pt on pt.hin_id=ip.hin_id  "+
					" where ip.inpatient_id="+inpatientId+" and ip.ad_status='R'";
			
			serviceList=session.createSQLQuery(query).list();	
		}
		map.put("serviceList",serviceList);
		return map;
	}


	@Override
	public boolean cancelServiceInv(int dtId, String service) {
		Session session=(Session)getSession();
		Transaction tx = null;
		boolean cancelled=false;
		try{
			tx=session.beginTransaction();
		
		if(service.equals("inv")){
		List<DgOrderdt>dtList=new ArrayList<DgOrderdt>();
		dtList=session.createCriteria(DgOrderdt.class).add(Restrictions.eq("Id",dtId)).list();
		for(DgOrderdt dt:dtList){
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);	dt.setOrderStatus("J");
			hbt.saveOrUpdate(dt);
			hbt.flush();
			cancelled=true;
			}
		}else if(service.equals("presc")) {
			
			org.springframework.orm.hibernate3.HibernateTemplate hbt2 = getHibernateTemplate();
			hbt2.setFlushModeName("FLUSH_EAGER");
			hbt2.setCheckWriteOperations(false);	
			logger.info("in pres>>"+dtId);
			
			List<InpatientPrescriptionDetails>dtList4=new ArrayList<InpatientPrescriptionDetails>();
			dtList4=session.createCriteria(InpatientPrescriptionDetails.class).add(Restrictions.idEq(dtId)).list();
			
			for(InpatientPrescriptionDetails InpatientPrescriptionDetails:dtList4){
				InpatientPrescriptionDetails.setIssuedStatus("J");
				hbt2.saveOrUpdate(InpatientPrescriptionDetails);
				hbt2.flush();
				hbt2.clear();
				cancelled=true;
				}
			}else if(service.equalsIgnoreCase("diet")){
				org.springframework.orm.hibernate3.HibernateTemplate hbt3 = getHibernateTemplate();
				hbt3.setFlushModeName("FLUSH_EAGER");
				hbt3.setCheckWriteOperations(false);	
				
				List<IpdPatientDiet>dtList3=new ArrayList<IpdPatientDiet>();
				dtList3=session.createCriteria(IpdPatientDiet.class).add(Restrictions.eq("Id",dtId)).list();
				
				for(IpdPatientDiet dt2:dtList3){
					dt2.setStatus("N");
					hbt3.saveOrUpdate(dt2);
					hbt3.flush();
					cancelled=true;
					}
				}else if(service.equalsIgnoreCase("procId")){
				org.springframework.orm.hibernate3.HibernateTemplate hbt4 = getHibernateTemplate();
				hbt4.setFlushModeName("FLUSH_EAGER");
				hbt4.setCheckWriteOperations(false);	
				List<OpdSurgeryDetail>osdList=new ArrayList<OpdSurgeryDetail>();
				osdList=session.createCriteria(OpdSurgeryDetail.class).add(Restrictions.idEq(dtId)).list();
				int opdHeaderId=0;
				for(OpdSurgeryDetail  OpdSurgeryDetail:osdList){
					
					opdHeaderId=OpdSurgeryDetail.getOpdSurgery().getId();
					OpdSurgeryDetail.setStatus("C");
					hbt4.saveOrUpdate(OpdSurgeryDetail);
					hbt4.flush();
					cancelled=true;	
					}
				
				List<OpdSurgeryHeader>OpdSurgeryHeaderList=new ArrayList<OpdSurgeryHeader>();
				OpdSurgeryHeaderList=session.createCriteria(OpdSurgeryHeader.class).add(Restrictions.idEq(opdHeaderId)).list();
				for(OpdSurgeryHeader  OpdSurgeryHeader:OpdSurgeryHeaderList){
									
					OpdSurgeryHeader.setStatus("C");//OpdSurgery().getId();
					hbt4.update(OpdSurgeryHeader);	
					hbt4.flush();
					cancelled=true;
									}
				
				
				
				}
				else if(service.equalsIgnoreCase("trans")){
					org.springframework.orm.hibernate3.HibernateTemplate hbt5 = getHibernateTemplate();
					hbt5.setFlushModeName("FLUSH_EAGER");
					hbt5.setCheckWriteOperations(false);	
					
					
					List<Transfer>dtList2=new ArrayList<Transfer>();
					dtList2=session.createCriteria(Transfer.class).add(Restrictions.eq("Id",dtId)).list();
					for(Transfer dt3:dtList2){
						int fromWard=dt3.getFromWard().getId();
						int toWard=dt3.getToWard().getId();
						
						MasDepartment dept=new MasDepartment();
						dept.setId(toWard);
						dt3.setFromWard(dept);
						
						MasDepartment dept2=new MasDepartment();
						dept2.setId(fromWard);
						dt3.setToWard(dept2);
						
						
						dt3.setStatus("C");
						dt3.setRequestStatus("n");
						hbt5.saveOrUpdate(dt3);
						hbt5.flush();
						cancelled=true;
						}
					
					
				}else if(service.equalsIgnoreCase("dis")){
					org.springframework.orm.hibernate3.HibernateTemplate hbt6 = getHibernateTemplate();
					hbt6.setFlushModeName("FLUSH_EAGER");
					hbt6.setCheckWriteOperations(false);	
					List<Inpatient>dtList1=new ArrayList<Inpatient>();
					dtList1=session.createCriteria(Inpatient.class).add(Restrictions.eq("Id",dtId)).list();
					for(Inpatient dt4:dtList1){
						dt4.setAdStatus("A");
						dt4.setDischargeSummaryStatus("n");
						hbt6.saveOrUpdate(dt4);
						hbt6.flush();
						cancelled=true;
						}
				}
				tx.commit();
				session.flush();
				
			}
			catch(Exception exception)
			{
				if(tx!=null)
					tx.rollback();
				
			}
						
		return cancelled;
	}


	@Override
	public Map<String, Object> getIpNoForReport(String hinNo) {
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean hinNoFound = false;
		
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (hinNo != null) {
				hinNo = (String)hinNo.toString()
						.trim();
			}
			
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo)).list();
			map.put("inpatientList", inpatientList);
			if (inpatientList != null && inpatientList.size() > 0) {
				hinNoFound = true;
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("inpatientSet", inpatientList);
		map.put("hinNoFound", hinNoFound);
		return map;
	}

	@Override
	public Map<String, Object> getItemForAllergy(String val, int hinId) {
		Session session=(Session)getSession();
		int itemId=0;
		//String val="";
		itemId=getItemId1(val);
		String itemName="";
		itemName=getItemName(itemId);
		
		List<OpdPatientAllergyT>allergyTList=new ArrayList<OpdPatientAllergyT>();
		allergyTList=session.createCriteria(OpdPatientAllergyT.class).createAlias("OpdPatientAllergy","OpdPatientAllergy").add(Restrictions.eq("OpdPatientAllergy.Hin.Id", hinId))
				//.add(Restrictions.eq("OpdPatientAllergy.Hin.Id", hinId))
				.add(Restrictions.eq("Status", 'y').ignoreCase())
				.list();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("allergyTList", allergyTList);
		boolean matched=false;
		for(OpdPatientAllergyT OpdPatientAllergyT:allergyTList){
			if(itemName.toLowerCase().contains(OpdPatientAllergyT.getAllergen().toLowerCase())){
				matched=true;
				break;
			}
			
		}
		map.put("matched",matched);
		return map;
	}
	public int getItemId1(String itemName) {
		int itemId = 0;
		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		String item1[] = itemName.split("\\[");
		String item11[] = item1[1].split("]");
		String item111 = item11[0];
		itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("PvmsNo", item111)).list();

		for (MasStoreItem masStoreItem : itemList) {
			itemId = masStoreItem.getId();
		}

		return itemId;
	}
	

	public String getItemName(int itemCode) {
		
		String itemName ="";
		Session session = (Session) getSession();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		
		itemList = session.createCriteria(MasStoreItem.class)
				.add(Restrictions.eq("Id", itemCode)).list();

		for (MasStoreItem masStoreItem : itemList) {
			itemName = masStoreItem.getNomenclature();
		}

		return itemName;
	}
	public Map<String, Object> viewMotherCashSheet(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		inPatientList =session.createCriteria(Inpatient.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo",  box.getString("hinNo"))).list();
		String adNo = "";
		int inPatientId = 0;
		if(inPatientList.size()>0){
			 inPatientId = inPatientList.get(0).getId();
			 adNo = inPatientList.get(0).getAdNo();
			 map.put("inPatientId", inPatientId);
			 map.put("adNo", adNo);
		}
		logger.info("inPatientList=="+inPatientList.size());
		
		return map;
	}


	@Override
	public Map<String, Object> ggetDetailsForPendingServices(int inpatientId) {
		Session session=(Session)getSession();
		List<InpatientPrescriptionDetails>ippDetailsList=new ArrayList<InpatientPrescriptionDetails>();
		ippDetailsList=session.createCriteria(InpatientPrescriptionDetails.class)
				.createAlias("Prescription","Prescription")
				.add(Restrictions.eq("Prescription.Inpatient.Id", inpatientId))
		.add(Restrictions.eq("IssuedStatus", "p").ignoreCase()).list();
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("ippDetailsList",ippDetailsList);
		List<DgOrderdt>dtList=new ArrayList<DgOrderdt>();
		dtList=session.createCriteria(DgOrderdt.class)
				.createAlias("Orderhd", "Orderhd")
				.add(Restrictions.eq("Orderhd.Inpatient.Id", inpatientId))
				.add(Restrictions.eq("OrderStatus", "P").ignoreCase())
				.list();
		map.put("ippDetailsList", ippDetailsList);
		map.put("dtList",dtList);
		return map;
	}

	

	@Override
	public Map<String, Object> getDetailsForFinalBill(int inpatientId) {
		Session session=(Session)getSession();
		List<BlFinalBillDetails>finalBillDetailsList=new ArrayList<BlFinalBillDetails>();
		finalBillDetailsList=session.createCriteria(BlFinalBillDetails.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("finalBillDetailsList", finalBillDetailsList);
		return map;
	}

	@Override
	public Map<String, Object> populateChargeAmoutForAmbulance(Map<String, Object> dataMap) {
		Map<String, Object> map=new HashMap<String, Object>();
		int chargeId = 0;
		if(dataMap.get("chargeId") != null){
			chargeId = (Integer) dataMap.get("chargeId");
		}
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int chargeAbleAmount = 0;
		Session session = (Session) getSession();
		List<MasChargeCode> masChargeCode = new ArrayList<MasChargeCode>();
		List<MasHospitalwiseChargecode> hospitalWiseChargeCodeList = new ArrayList<MasHospitalwiseChargecode>();
		
		hospitalWiseChargeCodeList = session.createCriteria(MasHospitalwiseChargecode.class).add(Restrictions.eq("Hospital.Id", hospitalId))
										.add(Restrictions.eq("ChargeCode.Id", chargeId)).list();
		if(hospitalWiseChargeCodeList.size()>0){
			MasHospitalwiseChargecode masHospitalwiseChargecode = hospitalWiseChargeCodeList.get(0);
			chargeAbleAmount = masHospitalwiseChargecode.getChargeCode().getCharge().intValue();
			map.put("chargeAbleAmount", chargeAbleAmount);

		}else{
			masChargeCode = (List<MasChargeCode>) session
					.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Id", chargeId)).list();
			if(masChargeCode.size()>0){
				MasChargeCode chargeCode =masChargeCode.get(0);
				chargeAbleAmount = chargeCode.getCharge().intValue();
				map.put("chargeAbleAmount", chargeAbleAmount);
				
			}
			
		}
		return map;
	}

	@Override
	public int getChargeSlipNo(String flag, int hospitalId) {
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

	
	@Override
	public Map<String, Object> getReferalList(int hospitalId, int userId) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		List<WardRemarks>wardReamrks=new ArrayList<WardRemarks>();
		List<Users>userList=new ArrayList<Users>();
		userList=session.createCriteria(Users.class).add(Restrictions.eq("Id", userId)).list();
		int empId=0;
		for(Users users:userList){
			empId=users.getEmployee().getId();
		}		
		List<WardRemarks>wardList=new ArrayList<WardRemarks>();
		wardList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Doctor.Id", empId)).add(Restrictions.eq("Status", "P").ignoreCase()).list();
		map.put("wardList",wardList);
		return map;
	}

	
	@Override
	public Map<String, Object> getReferalDetailsList(int remarksId) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
			
		List<WardRemarks>wardList=new ArrayList<WardRemarks>();
		wardList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Id", remarksId)).list();
		map.put("wardList",wardList);
		return map;
	}

	
	@Override
	public boolean updateReferal(String remarks, int remarksId) {
		Session session=(Session)getSession();
		Map<String,Object>map=new HashMap<String,Object>();
		boolean upated=false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		List<WardRemarks>wardList=new ArrayList<WardRemarks>();
		wardList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Id", remarksId)).list();
		for(WardRemarks WardRemarks:wardList){
			WardRemarks.setStatus("C");
			WardRemarks.setRemarks(WardRemarks.getRemarks().concat(remarks));
			hbt.update(WardRemarks);
		}
		upated=true;
		return upated;
	}

	public Map<String, Object> displayUnitWiseBed(Map<String, Object> detailsMap) {
		List<Inpatient> inPatientSetss = new ArrayList<Inpatient>();
		String unitCode = "";
		int deptId=0;
		int hospitalId=0;
		Map<String, Object> map=new HashMap<String, Object>();
		List<OtMasUnitDay> otMasUnitDay=new ArrayList<OtMasUnitDay>();
		Session session=(Session)getSession();
		if (detailsMap.get("unitCode") != null) {
			unitCode = (String) detailsMap.get("unitCode");
		}
		if (detailsMap.get("deptId") != null) {
			deptId = (Integer) detailsMap.get("deptId");
		}
		if (detailsMap.get("hospitalId") != null) {
			hospitalId = (Integer) detailsMap.get("hospitalId");
		}
		int inpatientId=0;
		if (detailsMap.get("inpatientId") != null) {
			inpatientId = (Integer) detailsMap.get("inpatientId");
		}
		List<MasBed> masBed=new ArrayList<MasBed>();
		
		String bedStatusUnOccupiedName = "";
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
			bedStatusUnOccupiedName = prop
					.getProperty("bedStatusUnOccupiedName");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		inPatientSetss = session
				.createCriteria(Inpatient.class)
				.createAlias("Hin", "hin")
				.add(Restrictions.eq("Id", inpatientId))
				.add(Restrictions.eq("AdStatus", "W".toLowerCase()).ignoreCase())
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Hospital.id", hospitalId))
				.addOrder(Order.desc("DateOfAddmission"))
				.list();
		
		logger.info(unitCode+"unitCodeunitCode");
		
		if(!unitCode.equals("") && !unitCode.equals("-")){	
			otMasUnitDay= session
					.createCriteria(OtMasUnitDay.class)
					.createAlias("MasBed", "b")
					.createAlias("b.Department", "dept")
					.add(Restrictions.eq("dept.Id",deptId))
					.createAlias("b.Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.createAlias("UnitM", "u")
					.add(Restrictions.eq("u.UnitCode",unitCode.trim()))
					.addOrder(Order.asc("b.BedNo"))
					.createAlias("b.BedStatus", "bs")
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusUnOccupiedName))
							.add(Restrictions.eq("b.Status", "y".toLowerCase()).ignoreCase())
							.add(Restrictions.eq("b.BedType", "P".toLowerCase()).ignoreCase())
							.add(Restrictions.isNull("b.VBed"))
							.list();
			if(otMasUnitDay.size()==0)
			{
				/*otMasUnitDay= session
					.createCriteria(OtMasUnitDay.class)
					.createAlias("MasBed", "b")
					.createAlias("b.Department", "dept")
					.add(Restrictions.eq("dept.Id",deptId))
					.createAlias("b.Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.createAlias("UnitM", "u")
					.add(Restrictions.eq("u.UnitCode",unitCode.trim()))
					.addOrder(Order.asc("b.BedNo"))
					.createAlias("b.BedStatus", "bs")
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusUnOccupiedName))
					.add(Restrictions.eq("b.Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("b.BedType", "v".toLowerCase()).ignoreCase())
					.add(Restrictions.isNotNull("b.VBed"))
					.list();
				 */
				masBed = session
						.createCriteria(MasBed.class).createAlias("VBed", "vbed").createAlias("vbed.OtMasUnitDays", "otunitdays",CriteriaSpecification.LEFT_JOIN)
						.createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId))
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.asc("BedNo"))
						.createAlias("BedStatus", "bs")
						.add(Restrictions.eq("bs.BedStatusCode",
								bedStatusUnOccupiedName))
								.createAlias("otunitdays.UnitM", "u")
								.add(Restrictions.eq("u.UnitCode",unitCode.trim()))
								.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
								.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
								.add(Restrictions.isNotNull("VBed"))
								.list();
			}
		}else{
			masBed = session
					.createCriteria(MasBed.class)
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", hospitalId))
					.addOrder(Order.asc("BedNo"))
					.createAlias("BedStatus", "bs")
					.add(Restrictions.eq("bs.BedStatusCode",
							bedStatusUnOccupiedName))
					.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
					.add(Restrictions.eq("BedType", "P".toLowerCase()).ignoreCase())
					.add(Restrictions.isNull("VBed"))
					.list();
			if(masBed.size()==0)
			{
				masBed = session
						.createCriteria(MasBed.class)
						.createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId))
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId))
						.addOrder(Order.asc("BedNo"))
						.createAlias("BedStatus", "bs")
						.add(Restrictions.eq("bs.BedStatusCode",
								bedStatusUnOccupiedName))
						.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase())
						.add(Restrictions.eq("BedType", "v".toLowerCase()).ignoreCase())
						.add(Restrictions.isNotNull("VBed"))
						.list();
			}
		}
		
		logger.info(otMasUnitDay.size()+"otMasUnitDayssssss");
		
		map.put("otMasUnitDay", otMasUnitDay);
		map.put("inPatientSetss", inPatientSetss);
		map.put("masBed", masBed);
		logger.info(masBed.size()+"--- masBed");
		
		return map;
	}
	
	private Map<String,Object> hl7MessageForIpAdmission(Map<String,Object> map){
		Map<String,Object> dataMap=new HashMap<String,Object>(); 
		MasHospital hospital=(MasHospital)map.get("hospital");
		Inpatient inpatient=(Inpatient)map.get("inpatient"); 
		String bedName=(String)map.get("bedStatusOccupiedName"); 
		Session session=(Session)getSession();
		try{  
				StringBuilder builder=new StringBuilder();
				builder.append(inpatient.getBed().getId());
				builder.append("|A"); 
				builder.append("|"+inpatient.getBedAllocationDate()); 
				builder.append("|"+inpatient.getBedAllocationTime());
				builder.append("|"+bedName);
				Criteria criteria=session.createCriteria(IpAdmissionForServer.class)
						.add(Restrictions.eq("InpatientId", inpatient.getId()));
			  	  	 
			  	IpAdmissionForServer admissionForServer=(IpAdmissionForServer)criteria.uniqueResult();  	 
			  	HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false); 
				admissionForServer.setIpBedAllow(builder.toString());
			  	String notSaveToServer="N";
			  	admissionForServer.setStatus(notSaveToServer);   	 
			  	hbt.save(admissionForServer);
			  	hbt.flush();
			  	hbt.clear(); 
				
				return dataMap;
        }catch(Exception e){
                e.printStackTrace();
                return dataMap;
        } 
	}
	
	private Map<String,Object> hl7MessageForIpAdmissionToClient(Map<String,Object> map){
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader in = null; 
		String message = "2";
		Map<String,Object> dataMap=new HashMap<String,Object>(); 
		MasHospital hospital=(MasHospital)map.get("hospital");
		Inpatient inpatient=(Inpatient)map.get("inpatient"); 
		String bedName=(String)map.get("bedStatusOccupiedName"); 
		Session session=(Session)getSession();
		try{  
				StringBuilder builder=new StringBuilder();
				builder.append(inpatient.getBed().getId());
				builder.append("|A"); 
				builder.append("|"+inpatient.getBedAllocationDate()); 
				builder.append("|"+inpatient.getBedAllocationTime());
				builder.append("|"+bedName);
				
				
				
				
				Criteria criteria=session.createCriteria(IpAdmissionForServer.class).add(Restrictions.eq("HospitalId", hospital.getId()))
						.add(Restrictions.eq("Status", "P").ignoreCase())
						.add(Restrictions.eq("InpatientId", inpatient.getId()));
			  	  	 
			  	IpAdmissionForServer admissionForServer=(IpAdmissionForServer)criteria.uniqueResult();  
			  	
			  	String  msg=admissionForServer.getIpAdmission();
			  	String bedMessage=builder.toString();
			  	dataMap.put("ipAddimissionMessage", msg);
			  	dataMap.put("bedMessage", bedMessage);  
				msg=msg.replace("&", "$");
				msg=msg.replaceAll("\r", "#");
				String encode=URLEncoder.encode(msg,"UTF-8");
				String encode2=URLEncoder.encode(bedMessage,"UTF-8");
				String header="http://"+hospital.getClientIp()+":"+hospital.getClientPort();  
				String uri=header+"/hms/hms/adt?method=submitAdmissionInformationFromLean&message="
							+encode+"&hospitalId="+hospital.getId()+"&bed="+encode2;
				logger.info("Url>>>>"+uri);
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
						message = "1";
						
					}else if(responseMsg
							.contains("fail")){
						message = "2";
					}else if(responseMsg
							.contains("500")){
						message = "3";
					}
					logger.info("Input Stream: " + sb.toString());
					
					
			  	//HibernateTemplate hbt = getHibernateTemplate();
				//hbt.setFlushModeName("FLUSH_EAGER");
				//hbt.setCheckWriteOperations(false); 
				//admissionForServer.setIpBedAllow(builder.toString());
			  	//String notSaveToServer="N";
			  	//admissionForServer.setStatus(notSaveToServer);   	 
			  	//hbt.save(admissionForServer);
			  	//hbt.flush();
			  	//hbt.clear(); 
				
				dataMap.put("message", message);
				return dataMap;
        }catch(Exception e){
                e.printStackTrace();
                return dataMap;
        } 
	}

	@Override
	public Map<String, Object> getAllIcdForDischargeSummary(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> DiagnosisList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		String query=" select t1.icd_code,t1.icd_name,t1.snomed_concept_id,t2.term from "+
" discharge_icd_code dic left outer join  mas_icd t1 on t1.icd_id=dic.icd_id  "+
"   left outer join sct2_description t2 on t1.snomed_concept_id = t2.conceptId  "+
"   where dic.inpatient_id="+inpatientId;

		List<Object[]>aList=new ArrayList<Object[]>();
		aList=session.createSQLQuery(query).list();
		for(Object[] obj:aList){
			DiagnosisList.add("Icd :  "+obj[1]+"("+obj[0]+")  -- Snomed :"+obj[3]);
		}
		
		
		
		map.put("DiagnosisList", DiagnosisList);
		return map;
	}

	
	@Override
	public Map<String, Object> getAllWardRemarks(Map<String, Object> detailsMap) {

Map<String, Object> map = new HashMap<String, Object>();
		
		List<String> RemarksList = new ArrayList<String>();
		int inpatientId = (Integer)detailsMap.get("inPatientId");
		Session session = (Session)getSession();
		
		String query="select wr.remarks_date,me.first_name,wr.remarks from ward_remarks wr "+
	"	left outer join mas_employee me on me.employee_id=wr.doctor_id "+
	"	where inpatient_id="+inpatientId;
		
	List<Object[]>aList=new ArrayList<Object[]>();
	aList=session.createSQLQuery(query).list();
	for(Object[] obj:aList){
		RemarksList.add("Remarks Date :  "+obj[0]+"(Doctor:)"+obj[1]+")  -- Remarks :"+obj[2]);
	}
	
	
	
	map.put("RemarksList", RemarksList);
	return map;
		
	}

	public Map<String, Object> saveObject(Map<String, Object> dataMap, Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=box.getInt("hospitalId");  
		Session session = (Session)getSession(); 
		String data="";
		String bedMessage="";
		Message hl7Message=null; 
		try{
		if(box.get("message")!=null){
			data=box.get("message");
			data=data.replace("$", "&");
			data=data.replaceAll("#", "\r");
			Parser parser=new PipeParser();
			hl7Message=parser.parse(data);
			
		}if(box.get("bed")!=null){
			bedMessage=box.get("bed");
		}
		Inpatient inpatientObj=new Inpatient(); 
		String hinNo=null;
		if(hl7Message!=null){  
				
				ORM_O01 orm_O01=(ORM_O01)hl7Message;
				PID pid=orm_O01.getPATIENT().getPID();
				PV1 pv1=orm_O01.getPATIENT().getPV1();
				OBR obr=orm_O01.getORDER().getORDER_DETAIL().getOBR();
				ORC orc=orm_O01.getORDER().getORC();
				if(pv1.getPv138_DietType().getValue()!=null){
					MasDepartment department=new MasDepartment(Integer.parseInt(pv1.getPv138_DietType().getValue()));
					inpatientObj.setDepartment(department);
				}
				
				if(pv1.getPv115_AmbulatoryStatus(0).getValue()!=null){
					inpatientObj.setRemarks( pv1.getPv115_AmbulatoryStatus(0).getValue());
				}	
				
				if(obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue()!=null){
					inpatientObj.setStatus(obr.getObr2_PlacerOrderNumber().getCm_placer1_UniquePlacerId().getValue()); 
				}
				
				if(pid.getPid22_EthnicGroup().getValue()!=null){
					inpatientObj.setAdStatus(pid.getPid22_EthnicGroup().getValue());  
				}
				
				if( pv1.getPv128_InterestCode().getValue()!=null){
					inpatientObj.setAdNoType( pv1.getPv128_InterestCode().getValue());
				} 
				if(pv1.getPv131_BadDebtAgencyCode().getValue()!=null){
					inpatientObj.setAttachedPatient(pv1.getPv131_BadDebtAgencyCode().getValue());
				}
				
				if(pv1.getPv150_AlternateVisitID().getCm_pat_id_01921_IDNumber().getValue()!=null){
					inpatientObj.setContactNo(pv1.getPv150_AlternateVisitID().getCm_pat_id_01921_IDNumber().getValue());
				}
				
				if(pv1.getPv111_TemporaryLocation().getCm_internal_location3_Bed().getValue()!=null){
					inpatientObj.setAddress(pv1.getPv111_TemporaryLocation().getCm_internal_location3_Bed().getValue());
				}
				
				if(pv1.getPv129_TransferToBadDebtCode().getValue()!=null){
					inpatientObj.setCriticalCondition(pv1.getPv129_TransferToBadDebtCode().getValue());
				}
				
				if(pv1.getPv117_AdmittingDoctor().getCn1_IDNumber().getValue()!=null){
					inpatientObj.setMlc(pv1.getPv117_AdmittingDoctor().getCn1_IDNumber().getValue());
				}
				
				if(pv1.getPv15_PreadmitNumber().getValue()!=null){
					inpatientObj.setDependentName(pv1.getPv15_PreadmitNumber().getValue());
				} 
				if(obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId().getValue()!=null){
					Users users=new Users(Integer.parseInt(obr.getObr3_FillerOrderNumber().getCm_filler1_UniqueFillerId().getValue()));
					inpatientObj.setAddEditBy(users); 
				}	 
				if(pv1.getPv143_PriorTemporaryLocation().getCm_internal_location3_Bed().getValue()!=null){
					MasPatientCategory category=new MasPatientCategory(Integer.parseInt(pv1.getPv143_PriorTemporaryLocation().getCm_internal_location3_Bed().getValue()));
					inpatientObj.setPatientCategory(category);
				}
				 if(pv1.getPv124_ContractCode(0).getValue()!=null){
					 MasRelation masRelation=new MasRelation(Integer.parseInt(pv1.getPv124_ContractCode(0).getValue()));
					 inpatientObj.setRelation(masRelation);
                 } 
				 if(pv1.getPv134_DeleteAccountIndicator().getValue()!=null){
					 MasDepartment dep=new MasDepartment(Integer.parseInt(pv1.getPv134_DeleteAccountIndicator().getValue()));
                     inpatientObj.setAdWard(dep);
                 }
				 if(pv1.getPv124_ContractCode(0).getValue()!=null){
					 HospitalDoctorUnitM doctorUnitM=new HospitalDoctorUnitM(Integer.parseInt(pv1.getPv124_ContractCode(0).getValue()));
					 inpatientObj.setUnitM(doctorUnitM); 
                  }
				 if( pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue()!=null){ 
					 inpatientObj.setDateOfAddmission(HMSUtil.convertStringyyyyMMddTypeToDateType(pv1.getPv144_AdmitDateTime().getTs2_DegreeOfPrecision().getValue()));
				 }
				 inpatientObj.setTimeOfAddmission(pid.getPid19_SocialSecurityNumberPatient().getValue());
				 if(orc.getOrc10_EnteredBy().getCn1_IDNumber().getValue()!=null){
					 inpatientObj.setListDate(HMSUtil.convertStringyyyyMMddTypeToDateType(orc.getOrc10_EnteredBy().getCn1_IDNumber().getValue()));
				 }
				 if(obr.getObr23_ChargeToPractice().getCm_moc1_DollarAmount().getValue()!=null){
					 MasAdmissionType admissionType=new MasAdmissionType(Integer.parseInt(obr.getObr23_ChargeToPractice().getCm_moc1_DollarAmount().getValue()));
					 inpatientObj.setAdmissionType(admissionType);
                 	 
                 } 
				 if(pv1.getPv148_TotalAdjustments().getValue()!=null){
					 inpatientObj.setAdNo(pv1.getPv148_TotalAdjustments().getValue());
				 }if(obr.getObr1_SetIDObservationRequest().getValue()!=null){
					 MasEmployee employee=new MasEmployee(Integer.parseInt(obr.getObr1_SetIDObservationRequest().getValue()));
					 inpatientObj.setDoctor(employee);
				 }
				 
				 MasBed bed=null;
				 String bedDetail[]=bedMessage.split("\\|");
				 if(bedDetail.length>4){
					 bed=(MasBed)session.get(MasBed.class, Integer.parseInt(bedDetail[0]));
					 
					 MasBed bedforIp=new MasBed(Integer.parseInt(bedDetail[0])); 
					 inpatientObj.setBed(bedforIp);
					 inpatientObj.setAdStatus("A");
					 DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
						try {
							Date dateForAdmission = (java.util.Date)formatter.parse(bedDetail[2]);
							inpatientObj.setBedAllocationDate(dateForAdmission);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}   
					 inpatientObj.setBedAllocationTime(bedDetail[3]);
					 MasBedStatus bedStatus = (MasBedStatus) session
								.createCriteria(MasBedStatus.class)
								.add(Restrictions
										.eq("BedStatusCode", bedDetail[4]))
								.uniqueResult();
					 if(bed!=null && bedStatus!=null){ 
						 bed.setBedStatus(bedStatus); 
					 }
				 }
				 
				 inpatientObj.setAddEditTime(pv1.getPv18_ReferringDoctor().getCn4_MiddleInitialOrName().getValue());
				 inpatientObj.setListTime(pv1.getPv140_BedStatus().getValue());
				 MasHospital hospital=new MasHospital(hospitalId);
				 inpatientObj.setHospital(hospital);
				 
				 
				 
				 
                //pv1.getPv139_ServicingFacility().setValue(inpatient.getOpdPatientDetails().getId()+""); 
                
                //*********patient***********
				 hinNo=pid.getPid2_PatientIDExternalID().getCk1_IDNumber().getValue();
                Patient patientObj=(Patient)session.createCriteria(Patient.class)
                		.add(Restrictions.eq("HinNo", hinNo)).uniqueResult();
                if(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()!=null){
                	 patientObj.setPatientStatus(pv1.getPv119_VisitNumber().getCm_pat_id1_IDNumber().getValue()); 
                }if(pid.getPid20_DriverSLicenseNumberPatient().getLicenseNumber().getValue()!=null){
                	 patientObj.setAb64Available(pid.getPid20_DriverSLicenseNumberPatient().getLicenseNumber().getValue());
                }
               
               
                if(pid.getPid18_PatientAccountNumber().getCheckDigit().getValue()!=null){
                	MasPatientType patientType=new MasPatientType(Integer.parseInt(pid.getPid18_PatientAccountNumber().getCheckDigit().getValue()));
                	patientObj.setPatientType(patientType);
                } if(pid.getPid8_Sex().getValue()!=null){
                	patientObj.setPastDue(pid.getPid8_Sex().getValue());
                }
                
                if(pid.getPid25_BirthOrder().getValue()!=null && pid.getPid25_BirthOrder().getValue().equalsIgnoreCase("1")){
                	patientObj.setBplStatus("y"); 
                }else{
                	patientObj.setBplStatus("n");
                }
                
                
                patientObj.setHinNo(pid.getPid2_PatientIDExternalID().getCk1_IDNumber().getValue());
                
               Criteria crit = session
    					.createCriteria(OpdPatientDetails.class, "opdpatientdetails")
    					.createAlias("opdpatientdetails.Visit", "visit")
    					.createAlias("visit.Hin", "hin")
    					.add(Restrictions.eq("opdpatientdetails.AdmissionAdvised",
    							"y".toLowerCase()).ignoreCase())
    					.add(Restrictions.eq("opdpatientdetails.Hospital.Id",
    							hospitalId))
    					.add(Restrictions.eq("opdpatientdetails.ReferredHospital.Id",
    							hospitalId))
    					.add(Restrictions.eq("opdpatientdetails.AdmissionDate",
    							inpatientObj.getDateOfAddmission()))
               			 .add(Restrictions.eq("hin.HinNo", hinNo));
    			 
               List<OpdPatientDetails> details=crit.list();
               if(details!=null&&details.size()>0){
            	   inpatientObj.setOpdPatientDetails(details.get(0));
               }
               inpatientObj.setHin(patientObj);
               inpatientObj.setHinNo(hinNo);
               HibernateTemplate hbt = getHibernateTemplate();
               hbt.setFlushModeName("FLUSH_EAGER");
       		   hbt.setCheckWriteOperations(false);
       		   hbt.saveOrUpdate(inpatientObj);
       		   hbt.saveOrUpdate(patientObj);
       		   if(bed!=null){
       			hbt.saveOrUpdate(bed);
       		   } 
       		   //inpatient,patient,bed is saved
               hbt.flush();
               hbt.clear();
               map.put("success", "success");
			
    		} 
		}catch(Exception e){
            e.printStackTrace();
             
		}   
		
		return map;
	}

	// Added by Amit Das on 02-03-2016
			@Override
			public Map<String, Object> getPatientScheme(int inpatientId) {
				Inpatient inpatient = new Inpatient();
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
				List<RsbyCardDetails> rsbyCardDetails = new ArrayList<RsbyCardDetails>();
				Session session = (Session) getSession();
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					authorizerList = session.createCriteria(MasAuthorizer.class)
							.add(Restrictions.eq("Status", "y")).list();
					inpatient = (Inpatient) session.load(Inpatient.class, inpatientId);
					
					if(inpatient!=null)
					rsbyCardDetails = session.createCriteria(RsbyCardDetails.class)
							.add(Restrictions.eq("Status", "Y")).add(Restrictions.eq("RsbyCardNo", inpatient.getHin().getRsbyCardNo())).list();
				
					} catch (Exception e) {
					e.printStackTrace();
				}
				// map.put("inpatientSet", inpatientList);
				map.put("inpatient", inpatient);
				map.put("authorizerList", authorizerList);
				map.put("rsbyCardDetails", rsbyCardDetails);
				return map;
			}
			
			// Added by Amit Das
			@Override
			public Map<String, Object> updatePatientScheme(Box box) {
				Inpatient inpatient = null;
				String result = null;
				int deptId = 0;
				int hospitalId = 0;
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
				List<RsbyCardDetails> rsbyCardDetails = new ArrayList<RsbyCardDetails>();
				List<Inpatient> inPatientList = new ArrayList<Inpatient>();
				Session session = (Session) getSession();
				try {
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					inpatient = (Inpatient) session.load(Inpatient.class, box.getInt(INPATIENT_ID));
					if(inpatient!=null){
					if (box.getInt("schemeList")!=0) {
						MasScheme masScheme = new MasScheme();
						masScheme = (MasScheme) session.load(MasScheme.class, box.getInt("schemeList"));
						inpatient.setScheme(masScheme);
					}
					if(box.getInt("authorizerId")!=0){
						MasAuthorizer masAuthorizer = new MasAuthorizer();
						masAuthorizer = (MasAuthorizer) session.load(MasAuthorizer.class, box.getInt("authorizerId"));
						inpatient.setAuthorizer(masAuthorizer);
					}
					
					if(box.get(DEPARTMENT_ID)!=null)
						deptId	= box.getInt(DEPARTMENT_ID);
						
					if(box.get(HOSPITAL_ID)!=null)	
						hospitalId	= box.getInt(HOSPITAL_ID);
					
					if(box.get("documents")!=null && !box.get("documents").trim().equals(""))
						inpatient.setDocuments(box.get("documents"));
					
					inPatientList = session
							.createCriteria(Inpatient.class, "ip")
							.createAlias("Hin","patient")
							.add(Restrictions.in("ip.AdStatus",
									new String[] { "A", "R" }))
							.add(Restrictions.eq("ip.Department.Id", deptId))
							.add(Restrictions.eq("ip.Hospital.id", hospitalId))
							.addOrder(Order.desc("DateOfAddmission")).list();
					
					authorizerList = session.createCriteria(MasAuthorizer.class)
							.add(Restrictions.eq("Status", "y")).list();
					
					
					hbt.update(inpatient);
					result = "successfully updated";
					}
					} catch (Exception e) {
						result = "failed";
					 // e.printStackTrace();
				}
				// map.put("inpatientSet", inpatientList);
				map.put("message", result);
				map.put("authorizerList", authorizerList);
				map.put("inPatientList", inPatientList);
				return map;
			}
	@Override
	public Map<String, Object> saveIpdObjectToServer(
			Map<String, Object> dataMap, Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		//String message="A | | |#955 |1 |0 |0 |0 |null |0.0 |17:30 |Sun Feb 28 00:00:00 IST 2016 |Sun Feb 28 00:00:00 IST 2016 |17:30 |0.0 | |null | | |All System NAD | | |#6 |1 |17:31 |432 |y |Sun Feb 28 00:00:00 IST 2016 | | | | | |IP |#703014 |Sun Feb 28 00:00:00 IST 2016 |17:31 |y |p |1 |#6 |1 |p |Sun Feb 28 00:00:00 IST 2016 |17:30 |955 |Sun Feb 28 00:00:00 IST 2016 |17:30 |5 |#6 |1 |p |Sun Feb 28 00:00:00 IST 2016 |17:30 |955 |#Sun Feb 28 00:00:00 IST 2016 |17:30 |1 |6 |955 |IP |Regular |164/2016 |P |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |#46 |1 |Sun Feb 28 00:00:00 IST 2016 |17:30 |P |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |#12 |1 | |$738 |1 | |$#342 |2 |1.0 | |1 |IP | | |2.0 |n |p |$340 |1 |1.0 | |1 |IP | | |1.0 |n |p |$#12 |1 |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |P |17 |35 |n |n |n |$738 |1 |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |P |23 |119 |n |n |n |$#738 |955 |y |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |P |Sun Feb 28 17:31:40 IST 2016 |23 |119 |738 |Sun Feb 28 17:31:40 IST 2016 |$#1 |432 |17:31 |Sun Feb 28 00:00:00 IST 2016 |2 |1 | |n |$#Sun Feb 28 00:00:00 IST 2016 |17:31 |null |null |$#Temperature |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |2 |1 | |n |$Pulse |432 |Sun Feb 28 00:00:00 IST 2016 |17:31 |2 |1 | |n |$#Sun Feb 28 00:00:00 IST 2016 |17:31 |null |null |$Sun Feb 28 00:00:00 IST 2016 |17:31 |null |null |$#";
		//String message="A | |T0009119011600013 |6 | | #955 |1 |0 |0 |0 |null |0.0 |00:03 |Mon Feb 29 00:00:00 IST 2016 |Mon Feb 29 00:00:00 IST 2016 |00:03 |0.0 | |null | | |All System NAD | | | #6 |1 |00:04 |432 |y |Mon Feb 29 00:00:00 IST 2016 | | | | | |IP | #703014 |Mon Feb 29 00:00:00 IST 2016 |00:04 |y |p |1 | # # # # # # # # # # # # #";
		String message=box.get("message");
		int hospitalId=box.getInt("hospitalId");
		message=message.replace("null", " ");
		
		Session session=(Session)getSession();
		Transaction tx = null;
		boolean cancelled=false;
		try{
			tx=session.beginTransaction();
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		
		
		String array[]=message.split("#");
		for(int i=0;i<array.length;i++){ 
			logger.info(array[i]);
		}
		int index=0;
		String inpatientData=array[index++];//0
		String opdPatientDetailsData=array[index++];//1
		String opdPatientHistoryData=array[index++];//2
		String dischargeIcdCodeData=array[index++];//3
		String inpatientPrescriptionHeaderData=array[index++];//4
		String patientInvestigationHeaderData=array[index++];//5
		String dgOrderhdData=array[index++];//6
		String dgSampleCollectionHeaderData =array[index++];//7  
		String patientInvestigatinDetailsListObjectData=array[index++];//8 
		String inpatientPrescriptionDetailsListObjectData=array[index++];//9
		String dgOrderDetailsListObjectData=array[index++];//10
		String dgSampleCollectionDeatilsListObjectData=array[index++];//11 
		String nursingcareSetupListObjectData=array[index++];//12
		String nursingcareHistoryListObjectData=array[index++];//13
		String ipdVitalSetupListObjectData=array[index++];//14
		String ipdVitalSetupHistoryListObjectData=array[index++];//15 
		
		String inpatientDataArray[]=inpatientData.trim().split("\\|"); 
		String opdPatientDetailsDataArray[]=opdPatientDetailsData.trim().split("\\|"); 
		String opdPatientHistoryDataArray[]=opdPatientHistoryData.trim().split("\\|");;
		String dischargeIcdCodeDataArray[]=dischargeIcdCodeData.trim().split("\\|");
		String inpatientPrescriptionHeaderDataArray[]=inpatientPrescriptionHeaderData.trim().split("\\|");
		String patientInvestigationHeaderDataArray[]=patientInvestigationHeaderData.trim().split("\\|");
		String dgOrderhdDataArray[]=dgOrderhdData.trim().split("\\|");
		String dgSampleCollectionHeaderDataArray[]=dgSampleCollectionHeaderData.trim().split("\\|");  
		
		//***********************inpatient patient****************************
		Inpatient in = saveInpatient(inpatientDataArray);
		List<Inpatient> inPatientList = session
				.createCriteria(Inpatient.class, "ip")
				.add(Restrictions.in("ip.AdStatus",
						new String[] { "A", "R" }))
				.add(Restrictions.eq("ip.Department.Id", in.getDepartment().getId()))
				.add(Restrictions.eq("ip.HinNo", in.getHinNo()))
				.add(Restrictions.eq("ip.Hospital.Id", hospitalId)).list();
		 
		if(inPatientList!=null && inPatientList.size()>0){ 
			Inpatient inpatient=inPatientList.get(0);
			inpatient.setAdStatus(in.getAdStatus());
			inpatient.setDiet(in.getDiet()); 
			inpatient.setRemarks(in.getRemarks());
			hbt.saveOrUpdate(inpatient);
			logger.info("Inpatient Saved");
		//***********************opd patient****************************
		OpdPatientDetails opdPatientDetails = saveOpdPatientDetail(
				opdPatientDetailsDataArray, inpatient); 
		hbt.save(opdPatientDetails);
		logger.info("OpdPatientDetails Saved ");
		
		//************************opd patient history*************************
		
		OpdPatientHistory opdPatientHistory = saveOPDPatientHistory(
				opdPatientHistoryDataArray, inpatient, opdPatientDetails);
		hbt.save(opdPatientHistory);
		logger.info("OpdPatientHistory Saved ");
		 //***********************discharge icd code***************************
		if(dischargeIcdCodeDataArray.length>1){
			DischargeIcdCode dischargeIcdCode = saveDischargeIcdCode(
					dischargeIcdCodeDataArray, inpatient, opdPatientDetails);
			hbt.save(dischargeIcdCode);
		}
		logger.info("Saved");
		//*************************inpatient prescription header*********************
		InpatientPrescriptionHeader inpatientPrescriptionHeader=null;
		if(inpatientPrescriptionHeaderDataArray.length>1){
			 inpatientPrescriptionHeader = saveInpatientPrescriptionHeader(
					inpatientPrescriptionHeaderDataArray, inpatient,
					opdPatientDetails);
			hbt.save(inpatientPrescriptionHeader);
		}
		
		logger.info("InpatientPrescriptionHeader Saved ");
		//*************************Patient Investigation header*********************
		PatientInvestigationHeader patientInvestigationHeader=null;
		if(patientInvestigationHeaderDataArray.length>1){
		 patientInvestigationHeader = savePatientInvestigationHeader(
				patientInvestigationHeaderDataArray, inpatient,
				opdPatientDetails); 
		hbt.save(patientInvestigationHeader);
		}
		logger.info("PatientInvestigationHeader Saved ");
		//*************************dg order hd header*********************
		DgOrderhd dgOrderhd=null;
		if(dgOrderhdDataArray.length>1){
		 dgOrderhd = saveDgOrderhd(
				dgOrderhdDataArray, inpatient,
				patientInvestigationHeader); 
		hbt.save(dgOrderhd);
		}
		logger.info("DgOrderhd Saved ");
		//*************************dgSampleCollectionHeader*********************
		DgSampleCollectionHeader dgSampleCollectionHeader=null;
		if(dgSampleCollectionHeaderDataArray.length>1){
		 dgSampleCollectionHeader = saveDgSampleCollectionHeader(
				dgSampleCollectionHeaderDataArray, inpatient, dgOrderhd);
		hbt.save(dgSampleCollectionHeader);
		}
		logger.info("DgSampleCollectionHeader Saved ");
		String patientInvestigatinDetailsListObjectDataArray[]=patientInvestigatinDetailsListObjectData.split("\\$"); 
		String inpatientPrescriptionDetailsListObjectDataArray[]=inpatientPrescriptionDetailsListObjectData.split("\\$");
		String dgOrderDetailsListObjectDataArray[]=dgOrderDetailsListObjectData.split("\\$"); 
		String dgSampleCollectionDeatilsListObjectDataArray[]=dgSampleCollectionDeatilsListObjectData.split("\\$"); 
		String nursingcareSetupListObjectDataArray[]=nursingcareSetupListObjectData.split("\\$"); 
		String nursingcareHistoryListObjectDataArray[]=nursingcareHistoryListObjectData.split("\\$"); 
		String ipdVitalSetupListObjectDataArray[]=ipdVitalSetupListObjectData.split("\\$"); 
		String ipdVitalSetupHistoryListObjectDataArray[]=ipdVitalSetupHistoryListObjectData.split("\\$"); 
		 
		//******************************inpatient prescription header******************************************************
		 
		if(inpatientPrescriptionDetailsListObjectDataArray.length>0 && inpatientPrescriptionHeader!=null){
			 
		List<InpatientPrescriptionDetails> inpatientPrescriptionDetailsList= saveInpatientPrescriptionDetailsList(
						inpatientPrescriptionHeader,
						inpatientPrescriptionDetailsListObjectDataArray);
				
				 for(InpatientPrescriptionDetails details:inpatientPrescriptionDetailsList){
					 hbt.save(details);
					 logger.info("InpatientPrescriptionDetails Saved "+details.getPrescription().getId());
						
		}}
		logger.info("InpatientPrescriptionDetails Saved ");
		//*************************patient investigation detail obj list*********************
		if(patientInvestigatinDetailsListObjectDataArray.length>0){
		List<PatientInvestigationDetails> PatientInvestigationDetailsList = savePatientInvestigationDetailsList(
				patientInvestigationHeader,patientInvestigatinDetailsListObjectDataArray);
		
		for(PatientInvestigationDetails details:PatientInvestigationDetailsList){
			hbt.save(details);
		}}
		logger.info("PatientInvestigationDetails Saved ");
		
		//*************************dg order  detail obj list*********************
		if(dgOrderDetailsListObjectDataArray.length>1){
		List<DgOrderdt> dgOrderdtList = saveDgOrderdtList(dgOrderhd,
				dgOrderDetailsListObjectDataArray);
		 for(DgOrderdt details:dgOrderdtList){
			 hbt.save(details);
		 }}
		logger.info("DgOrderdt Saved ");
		//*************************dg sample collection header list*********************
		if(dgSampleCollectionDeatilsListObjectDataArray.length>1){
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList = saveDgSampleCollectionDetailsList(
				dgSampleCollectionHeader,
				dgSampleCollectionDeatilsListObjectDataArray); 
		
		 for(DgSampleCollectionDetails details:dgSampleCollectionDetailsList){
			 hbt.save(details);
		 }}
		logger.info("DgSampleCollectionDetails Saved ");
		hbt.flush();
		hbt.clear();
		//***************************Nursing care setup and history******************************************************
		  
		if(nursingcareSetupListObjectDataArray.length>1){
				saveNusringCareDetails(inpatient,
						nursingcareSetupListObjectDataArray,
						nursingcareHistoryListObjectDataArray);
		}
		//***************************ipd vital setup******************************************************
		if(ipdVitalSetupListObjectDataArray.length>1){
				saveIpdVitalSetupDetails(inpatient,
						ipdVitalSetupListObjectDataArray,
						ipdVitalSetupHistoryListObjectDataArray);
		} 
		tx.commit();
		map.put("success", "success");
		} else{
			map.put("failure", "failure");
		}
		}catch(Exception e){
			e.printStackTrace();
			if(tx!=null){
				tx.rollback();
				map.put("failure", "failure");
			}
		}
	return map;
	}
	
	@Override
	 public Map<String, Object> getDataForServer() {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(CentralServerIpdData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<CentralServerIpdData> centralServerIpdDatas=criteria.list();
		
		MasHospital masHospital=null;
		if(centralServerIpdDatas!=null && centralServerIpdDatas.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(centralServerIpdDatas.get(0).getHospitalId().toString())); 
			dataMap.put("centralServerIpdDatas", centralServerIpdDatas);
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
	public Map<String, Object> getDataForLeanServer() {
		Map<String,Object> dataMap=new HashMap<String,Object>();
		Session session=(Session)getSession();
		try{
		Criteria criteria=session.createCriteria(LeanServerIpdData.class)
				.add(Restrictions.eq("Status", "N").ignoreCase())
				.addOrder(Order.asc("Id"))
				.setMaxResults(10);
		List<LeanServerIpdData> leanServerIpdDatas=criteria.list();
		
		MasHospital masHospital=null;
		if(leanServerIpdDatas!=null && leanServerIpdDatas.size()>0){
			masHospital=(MasHospital)session.get(MasHospital.class,
					Integer.parseInt(leanServerIpdDatas.get(0).getHospitalId().toString())); 
			dataMap.put("leanServerIpdDatas", leanServerIpdDatas);
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
	public String updateCentralServerIPDData(
			CentralServerIpdData centralServerIpdData) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false); 
  	  	String ipdDataSavedToServer="Y";
  	  	centralServerIpdData.setStatus(ipdDataSavedToServer);
  	  	hbt.update(centralServerIpdData);
  	  	hbt.flush();
  	  	hbt.clear();
		return "success";
	}
	
	@Override
	public String updateLeanServerIPDData(
			LeanServerIpdData leanServerIpdData) {
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false); 
  	  	String ipdDataSavedToLeanServer="Y";
  	  	leanServerIpdData.setStatus(ipdDataSavedToLeanServer);
  	  	hbt.update(leanServerIpdData);
  	  	hbt.flush();
  	  	hbt.clear();
		return "success";
	}
	
	public String makeFileIpdDetailFromLeanToServer(Map<String,Object> ipdPatientData,Map<String,List<Object>> ipdPatientDataList){
		try{
			
			OpdPatientDetails 	opdPatientDetails=(OpdPatientDetails)ipdPatientData.get("OpdPatientDetails");
			OpdPatientHistory opdPatientHistory=(OpdPatientHistory)ipdPatientData.get("OpdPatientHistory");
			DischargeIcdCode dischargeIcdCode=(DischargeIcdCode)ipdPatientData.get("DischargeIcdCode");
			InpatientPrescriptionHeader inpatientPrescriptionHeader=(InpatientPrescriptionHeader)ipdPatientData.get("inpatientPrescriptionHeader");
			PatientInvestigationHeader patientInvestigationHeader=(PatientInvestigationHeader)ipdPatientData.get("patientInvestigationHeader");
			DgOrderhd dgOrderhd=(DgOrderhd)ipdPatientData.get("dgOrderhd");
			DgSampleCollectionHeader dgSampleCollectionHeader =(DgSampleCollectionHeader)ipdPatientData.get("DgSampleCollectionHeader");
			Inpatient inpatient=(Inpatient)ipdPatientData.get("ip");
			
			
			
			List<PatientInvestigationDetails> patientInvestigatinDetailsListObject=
					(List<PatientInvestigationDetails>)(Object)ipdPatientDataList.get("patientInvestigatinDetailsListObject");
			
			List<InpatientPrescriptionDetails> inpatientPrescriptionDetailsList=
					(List<InpatientPrescriptionDetails>)(Object)ipdPatientDataList.get("inpatientPrescriptionDetailsListObject");
			
			List<DgOrderdt> dgOrderDetailsListObject=
					(List<DgOrderdt>)(Object)ipdPatientDataList.get("dgOrderDetailsListObject");
			
			List<DgSampleCollectionDetails> dgSampleCollectionDeatilsListObject=
					(List<DgSampleCollectionDetails>)(Object)ipdPatientDataList.get("dgSampleCollectionDeatilsListObject"); 
			
			List<NursingcareSetup>	nursingcareSetupListObject=
					(List<NursingcareSetup>)(Object)ipdPatientDataList.get("nursingcareSetupListObject"); 
			
			List<NursingcareSetupHistory> nursingcareHistoryListObject=
					(List<NursingcareSetupHistory>)(Object)ipdPatientDataList.get("nursingcareHistoryListObject"); 
			
			List<IpdVitalSetup> ipdVitalSetupListObject=
					(List<IpdVitalSetup>)(Object)ipdPatientDataList.get("ipdVitalSetupListObject"); 
			
			List<IpdVitalcareSetupHistory> ipdVitalSetupHistoryListObject=
					(List<IpdVitalcareSetupHistory>)(Object)ipdPatientDataList.get("ipdVitalSetupHistoryListObject");
			 
					StringBuilder builder=new StringBuilder(); 
					if(inpatient!=null){
						builder.append(inpatient.getAdStatus()).append(" |");  
						if(inpatient.getDiet()!=null){
							builder.append(inpatient.getDiet().getId()).append(" |");
						}else{
							builder.append(" |");
						}  
						builder.append(inpatient.getHinNo()).append(" |");
						builder.append(inpatient.getDepartment().getId()).append(" |");
						builder.append(inpatient.getRemarks()+" |");   
					}
					builder.append(" #");	
                    if(opdPatientDetails!=null){ 
                    	
                    	//builder.append(opdPatientDetails.getInpatient().getId()).append(" |");
                    	builder.append(opdPatientDetails.getEmployee().getId()).append(" |");  
                    	builder.append(opdPatientDetails.getHospital().getId()).append(" |");
                    	builder.append(opdPatientDetails.getHeight()).append(" |");
                    	builder.append(opdPatientDetails.getPulse()).append(" |");
                    	builder.append(opdPatientDetails.getWeight()).append(" |");
                    	builder.append(opdPatientDetails.getBp()).append(" |");
                    	builder.append(opdPatientDetails.getTemperature()).append(" |");
                    	builder.append(opdPatientDetails.getConsultationTime()).append(" |");
                    	builder.append(opdPatientDetails.getConsultationDate()).append(" |");
                    	builder.append(opdPatientDetails.getOpdDate()).append(" |");
                    	builder.append(opdPatientDetails.getOpdTime()).append(" |"); 
                    	builder.append(opdPatientDetails.getBmi()).append(" |");
                    	builder.append(opdPatientDetails.getClinicalNote().trim()).append(" |");
                    	builder.append(opdPatientDetails.getSystemDiagnosis()).append(" |");
                    	builder.append(opdPatientDetails.getGeneralExamination()).append(" |");
                    	builder.append(opdPatientDetails.getLocalExamination()).append(" |");
                    	builder.append(opdPatientDetails.getSystemicExamination()).append(" |");
                    	builder.append(opdPatientDetails.getOutsideInvestigation()).append(" |");
                    	builder.append(opdPatientDetails.getOutsideInvestigationImage()+" |"); 
                    }
                    builder.append(" #");	
                    if(opdPatientHistory!=null){
                    	builder.append(opdPatientHistory.getDepartment().getId()).append(" |");
                    	builder.append(opdPatientHistory.getHospital().getId()).append(" |");
                    	//builder.append(opdPatientHistory.getHin().getHinNo()).append(" |");
                    	//builder.append(opdPatientHistory.getInpatient().getId()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgTime()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgBy().getId()).append(" |");
                    	builder.append(opdPatientHistory.getStatus()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgDate()).append(" |");
                    	builder.append(opdPatientHistory.getPresentComplaintHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getPastIllnessHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getPersonalPresentHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getFamilyPastHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getMadicationHistory().trim()).append(" |"); 
                    	builder.append(opdPatientHistory.getIpOpPacStatus()).append(" |");
                    	//builder.append(opdPatientHistory.getOpdPatientDetails()+"");
                    	//builder.append(opdPatientHistory.getInpatient()).append(" |"); 
                    }
                    builder.append(" #");	
                    if(dischargeIcdCode!=null){
                    	//builder.append(	dischargeIcdCode.getHin().getHinNo()).append(" |");
                    	builder.append(dischargeIcdCode.getIcd().getId()).append(" |");
                    	builder.append(dischargeIcdCode.getAddEditDate()).append(" |");
                    	builder.append(dischargeIcdCode.getAddEditTime()).append(" |");
                    	builder.append(dischargeIcdCode.getStatus()).append(" |");
                    	builder.append(dischargeIcdCode.getDiagnosisStatus()).append(" |");
                    	//builder.append(dischargeIcdCode.getInpatient().getId()).append(" |");
                    	builder.append(dischargeIcdCode.getHospital().getId()+" |");
                    	//builder.append(dischargeIcdCode.getOpdPatientDetails().getId()).append(" |"); 
                    }
                    builder.append(" #");	
                    if(inpatientPrescriptionHeader!=null){
                    	
                    	//builder.append(inpatientPrescriptionHeader.getHin().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getDepartment().getId()).append(" |");
                    	//builder.append(inpatientPrescriptionHeader.getInpatient().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getHospital().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getStatus()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionDate()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionTime()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionBy().getId()).append(" |");
                    	//builder.append(inpatientPrescriptionHeader.getOpdPatientDetail().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionDate()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionTime()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionNo()+" |"); 
                    	
                    }
                    builder.append(" #");	
                    if(patientInvestigationHeader!=null){ 
                    	//builder.append(patientInvestigationHeader.getHin().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getDepartment().getId()).append(" |");
                    	//builder.append(patientInvestigationHeader.getInpatient().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getHospital().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getStatus()).append(" |");
                    	builder.append(patientInvestigationHeader.getInvestigationDate()).append(" |");
                    	builder.append(patientInvestigationHeader.getInvestigationTime()).append(" |");
                    	//builder.append(patientInvestigationHeader.getOpdPatientDetail()).append(" |");
                    	builder.append(	patientInvestigationHeader.getInvestigationBy().getId()+" |"); 
                    	
                    }
                    builder.append(" #");	
                    if(dgOrderhd!=null){
                    	builder.append(dgOrderhd.getOrderDate()).append(" |");
                    	builder.append(dgOrderhd.getOrderTime()).append(" |");
                    	builder.append(dgOrderhd.getHospital().getId()).append(" |");
                    	//builder.append(dgOrderhd.getInpatient().getId()).append(" |");
                    	//builder.append(dgOrderhd.getHin().getId()).append(" |");
                    	builder.append(dgOrderhd.getDepartment().getId()).append(" |");
                    	builder.append(dgOrderhd.getPrescribedBy().getId()).append(" |"); 
                    	builder.append(dgOrderhd.getPatientType()).append(" |");
                    	builder.append(dgOrderhd.getTestType()).append(" |");
                    	builder.append(dgOrderhd.getOrderNo()).append(" |");
                    	builder.append(dgOrderhd.getOrderStatus()).append(" |");
                    	builder.append(dgOrderhd.getLastChgBy().getId()).append(" |");
                    	builder.append(dgOrderhd.getLastChgDate()).append(" |");
                    	builder.append(dgOrderhd.getLastChgTime()).append(" |");
                    	//builder.append(dgOrderhd.getInvestigationRequestionNo()+" #");  	

                    }
                    builder.append(" #");	
                    if(dgSampleCollectionHeader!=null){
                    	//builder.append(dgSampleCollectionHeader.getHin().getId()).append(" |"); 
                    	//builder.append(dgSampleCollectionHeader.getInpatient().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDepartment().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getHospital().getId()).append(" |"); 
                    	//builder.append(dgSampleCollectionHeader.getOrder()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDiagnosisDate()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDiagnosisTime()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getOrderStatus()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgBy().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgDate()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgTime()+" |");  
                    }
                    builder.append(" #");	
                    if(patientInvestigatinDetailsListObject!=null && patientInvestigatinDetailsListObject.size()>0){
                    	for(PatientInvestigationDetails patientInvestigationDetails:patientInvestigatinDetailsListObject){ 
                    		//builder.append(patientInvestigationDetails.getInvestigationHeader().getId()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getChargeCode().getId()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getQuantity()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getClinicalNotes()+" |");
                    		builder.append("$");
                    	} 
                    }
                    builder.append(" #");
                    if(inpatientPrescriptionDetailsList!=null &&inpatientPrescriptionDetailsList.size()>0){
                    	for(InpatientPrescriptionDetails inpatientPrescriptionDetails:inpatientPrescriptionDetailsList){ 
                    		if(inpatientPrescriptionDetails.getItem()!=null){
                    			builder.append(inpatientPrescriptionDetails.getItem().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		} 
                    		if(inpatientPrescriptionDetails.getFrequency()!=null){
                    			builder.append(inpatientPrescriptionDetails.getFrequency().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		}
                    		builder.append(inpatientPrescriptionDetails.getDosage()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getSplInstruction()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getNoOfDays()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getType()).append(" |"); 
                    		if(inpatientPrescriptionDetails.getInsrtuction()!=null){
                    			builder.append(inpatientPrescriptionDetails.getInsrtuction().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		} 
                    		if(inpatientPrescriptionDetails.getRoute()!=null){
                    			builder.append(inpatientPrescriptionDetails.getRoute().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		}
                    		builder.append(inpatientPrescriptionDetails.getTotal()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getStopMedicine()).append(" |");
                    		//builder.append(inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader));
                    		builder.append(inpatientPrescriptionDetails.getIssuedStatus()).append(" |");
                    		builder.append("$");
                    	}
                    }
                    builder.append(" #");
                    if(dgOrderDetailsListObject!=null && dgOrderDetailsListObject.size()>0){
                    	for(DgOrderdt dgOrderdt:dgOrderDetailsListObject){
                    		//builder.append(dgOrderdt.getOrderhd().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getChargeCode().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getOrderQty()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgBy().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgDate()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgTime()).append(" |"); 
                    		builder.append(dgOrderdt.getOrderStatus()).append(" |"); 
                    		builder.append(dgOrderdt.getMainChargecode().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getSubChargeid().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getPaymentMade()).append(" |"); 
                    		builder.append(dgOrderdt.getMsgSent()).append(" |"); 
                    		builder.append(dgOrderdt.getPacsStatus()+" |");  
                    		builder.append("$");
                    	} 
                    }
                    builder.append(" #");
                    if(dgSampleCollectionDeatilsListObject!=null && dgSampleCollectionDeatilsListObject.size()>0){
                    	for(DgSampleCollectionDetails dgSampleCollectionDetails:dgSampleCollectionDeatilsListObject){
                    		
                    		//builder.append(dgSampleCollectionDetails.getSampleCollectionHeader().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getChargeCode().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getCollectedBy().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getCollected()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgBy().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgDate()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgTime()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getOrderStatus()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSampleCollDatetime()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getMaincharge().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSubcharge().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getInvestigation().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSampleCollDatetime()+" |");  
                    		builder.append("$");
                    	}
                    	
                    	
                    }
                    builder.append(" #"); 
                    if(nursingcareSetupListObject!=null && nursingcareSetupListObject.size()>0){
                    	for(NursingcareSetup nursingcareSetup:nursingcareSetupListObject){
                    		if(nursingcareSetup!=null){ 
                    		builder.append(nursingcareSetup.getNursing().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgBy().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgTime()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgDate()).append(" |"); 
                    		//builder.append(nursingcareSetup.getHin().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getFrequency().getId()).append(" |"); 
                    		//builder.append(nursingcareSetup.getInpatient().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getHospital().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getRemarks()).append(" |"); 
                    		builder.append(nursingcareSetup.getStopCare()+" |");   
                    		builder.append("$");
                    		}
                    	}
                    	
                    	
                    }
                    builder.append(" #");  
                    if(nursingcareHistoryListObject!=null && nursingcareHistoryListObject.size()>0){
                    	for(NursingcareSetupHistory nursingcareSetupHistory:nursingcareHistoryListObject){
                    		if(nursingcareSetupHistory!=null){ 
                    		builder.append(nursingcareSetupHistory.getStartDate()).append(" |"); 
                    		builder.append(nursingcareSetupHistory.getStartTime()).append(" |"); 
                    		//builder.append(nursingcareSetupHistory.getNursingcareSetup()).append(" |"); 
                    		builder.append(nursingcareSetupHistory.getEndDate()).append(" |");  
                    		builder.append(nursingcareSetupHistory.getEndTime()+" |"); 
                    		builder.append("$");
                    		}
                    	}
                    	
                    	
                    }
                    builder.append(" #");  
                    if(ipdVitalSetupListObject!=null && ipdVitalSetupListObject.size()>0){
                    	for(IpdVitalSetup ipdVitalSetup:ipdVitalSetupListObject){ 
                    		if(ipdVitalSetup!=null){
                    			
                    		
                    		builder.append(ipdVitalSetup.getVitalName()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgBy().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgDate()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgTime()).append(" |"); 
                    		//builder.append(ipdVitalSetup.getHin().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getFrequency().getId()).append(" |"); 
                    		//builder.append(ipdVitalSetup.getInpatient().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getHospital().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getRemarks()).append(" |"); 
                    		builder.append(ipdVitalSetup.getStopVital()+" |"); 	
                    		builder.append("$");
                    		}
                    	}
                    	
                    }
                    builder.append(" #");
                    if(ipdVitalSetupHistoryListObject!=null && ipdVitalSetupHistoryListObject.size()>0){
                    	for(IpdVitalcareSetupHistory ipdVitalcareSetupHistory:ipdVitalSetupHistoryListObject){
                    		if(ipdVitalcareSetupHistory!=null){
                    			
                    		
                    		builder.append(ipdVitalcareSetupHistory.getStartDate()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getStartTime()).append(" |");
                    		//builder.append(ipdVitalcareSetupHistory.getVitalSetup().getId()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getEndDate()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getEndTime()+" |");
                    		builder.append("$");
                    		}
                    	}  
                    } 
                    builder.append(" #"); 
			  	  	 
			  	  	 
                    String ipdData=builder.toString();
			  	  	
			  	  	HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
			  	  	CentralServerIpdData centralServerIpdData=new CentralServerIpdData();
			  	  	centralServerIpdData.setIpdData(builder.toString()); 
			  	  	centralServerIpdData.setLeanIpdId(Long.parseLong(inpatient.getId().toString()));
			  	  	String notSaveToServer="N";
			  	  	centralServerIpdData.setStatus(notSaveToServer);
			  	  	centralServerIpdData.setHospitalId(Long.parseLong(inpatient.getHospital().getId()+""));
			  	  	hbt.save(centralServerIpdData);
			  	  	hbt.flush();
			  	  	hbt.clear(); 
			  	  	logger.info("Done");
				 return "success";
        	}catch(Exception e){
                e.printStackTrace();
                return "failear";
        	}
        
} 	
	
	private List<InpatientPrescriptionDetails> saveInpatientPrescriptionDetailsList(
			InpatientPrescriptionHeader inpatientPrescriptionHeader,
			String[] inpatientPrescriptionDetailsListObjectDataArray) {
		int index;
		List<InpatientPrescriptionDetails> InpatientPrescriptionDetailsArray=new ArrayList<InpatientPrescriptionDetails>();
		for(int i=0;i<inpatientPrescriptionDetailsListObjectDataArray.length;i++){
			String inpatientPrescriptionDetailsArray[]=inpatientPrescriptionDetailsListObjectDataArray[i].split("\\|");
			logger.info("inpatientPrescriptionDetailsArray size = "+inpatientPrescriptionDetailsArray.length);
			if(inpatientPrescriptionDetailsArray.length>1){ 
			InpatientPrescriptionDetails inpatientPrescriptionDetails=new InpatientPrescriptionDetails();  
			inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader); 
			index=0;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				MasStoreItem masStoreItem=new MasStoreItem(Integer.parseInt(inpatientPrescriptionDetailsArray[index].trim()));
				inpatientPrescriptionDetails.setItem(masStoreItem);
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				MasFrequency masFrequency=new MasFrequency(Integer.parseInt(inpatientPrescriptionDetailsArray[index].trim()));
				inpatientPrescriptionDetails.setFrequency(masFrequency);
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setDosage(Float.parseFloat(inpatientPrescriptionDetailsArray[index].trim()));
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setSplInstruction(inpatientPrescriptionDetailsArray[index]);
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setNoOfDays(Integer.parseInt(inpatientPrescriptionDetailsArray[index].trim()));
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setType(inpatientPrescriptionDetailsArray[index].trim());
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment(
						Integer.parseInt(inpatientPrescriptionDetailsArray[index].trim()));
				inpatientPrescriptionDetails.setInsrtuction(instructionTreatment);
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				RouteOfAdministration routeOfAdministration=new RouteOfAdministration(
						Integer.parseInt(inpatientPrescriptionDetailsArray[index].trim()));
				inpatientPrescriptionDetails.setRoute(routeOfAdministration);
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setTotal(Float.parseFloat(inpatientPrescriptionDetailsArray[index].trim()));
			}
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setStopMedicine(inpatientPrescriptionDetailsArray[index].trim());
			} 
			index++;
			if(inpatientPrescriptionDetailsArray[index]!=null && !"".equals(inpatientPrescriptionDetailsArray[index].trim())){
				inpatientPrescriptionDetails.setIssuedStatus(inpatientPrescriptionDetailsArray[index].trim());
			}
			InpatientPrescriptionDetailsArray.add(inpatientPrescriptionDetails);
		}
		}
		return InpatientPrescriptionDetailsArray;
	}

	private void saveIpdVitalSetupDetails(Inpatient inpatient,
			String[] ipdVitalSetupListObjectDataArray,
			String[] ipdVitalSetupHistoryListObjectDataArray) {
		Session session=(Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		int index;
		for(int i=0;i<ipdVitalSetupListObjectDataArray.length;i++){
			String ipdVitalSetupArray[]=ipdVitalSetupListObjectDataArray[i].split("\\|"); 
			if(ipdVitalSetupArray.length>1){ 
			IpdVitalSetup ipdVitalSetup=new IpdVitalSetup(); 
			
			ipdVitalSetup.setHin(inpatient.getHin());
			ipdVitalSetup.setInpatient(inpatient); 
			index=0;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				ipdVitalSetup.setVitalName(ipdVitalSetupArray[index].trim());
			}
			index++;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				Users user=new Users(Integer.parseInt(ipdVitalSetupArray[index].trim()));
				ipdVitalSetup.setLastChgBy(user);
			}
			index++;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				ipdVitalSetup.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						ipdVitalSetupArray[index].trim()));
				
			}
			index++;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				ipdVitalSetup.setLastChgTime(ipdVitalSetupArray[index].trim());
			}
			index++; 
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				MasFrequency frequency=new MasFrequency(Integer.parseInt(ipdVitalSetupArray[index].trim()));
				ipdVitalSetup.setFrequency(frequency);
			}
			index++; 
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				MasHospital hospital=new MasHospital(Integer.parseInt(ipdVitalSetupArray[index].trim()));
				ipdVitalSetup.setHospital(hospital);
			}
			index++;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				ipdVitalSetup.setRemarks(ipdVitalSetupArray[index]);
			}
			index++;
			if(ipdVitalSetupArray[index]!=null && !"".equals(ipdVitalSetupArray[index].trim())){ 
				ipdVitalSetup.setStopVital(ipdVitalSetupArray[index]);
			}
			IpdVitalcareSetupHistory history=new IpdVitalcareSetupHistory();  
			if(ipdVitalSetupHistoryListObjectDataArray.length>i){ 
			 
			String ipdVitalSetupHistoryArray[]=ipdVitalSetupHistoryListObjectDataArray[i].split("\\|");
			if(ipdVitalSetupHistoryArray.length>1){ 
			
			index=0; 
			if(ipdVitalSetupHistoryArray[index]!=null && !"".equals(ipdVitalSetupHistoryArray[index].trim())){ 
				history.setStartDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						ipdVitalSetupHistoryArray[index].trim()));
			}
			index++;
			if(ipdVitalSetupHistoryArray[index]!=null && !"".equals(ipdVitalSetupHistoryArray[index].trim())){ 
				history.setStartTime(ipdVitalSetupHistoryArray[index]);
			} 
			index++;
			if(ipdVitalSetupHistoryArray[index]!=null && !"".equals(ipdVitalSetupHistoryArray[index].trim())){ 
				history.setEndDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(ipdVitalSetupHistoryArray[index].trim()));
				
			}
			index++;
			if(ipdVitalSetupHistoryArray[index]!=null && !"".equals(ipdVitalSetupHistoryArray[index].trim())){ 
				history.setEndTime(ipdVitalSetupHistoryArray[index].trim());
			}
			}
			}
			List<IpdVitalSetup> ipdVitalSetups=new ArrayList<IpdVitalSetup>();
			IpdVitalSetup ipdVitalSetupSave= null;
			ipdVitalSetups = session.createCriteria(IpdVitalSetup.class)
					.add(Restrictions.eq("VitalName", ipdVitalSetup.getVitalName()).ignoreCase())
					.add(Restrictions.eq("Inpatient.Id", inpatient.getId()))
					.add(Restrictions.eq("Hospital.Id", inpatient.getHospital().getId())).list();
			if(ipdVitalSetups!=null&& ipdVitalSetups.size()>0){
				ipdVitalSetupSave=ipdVitalSetups.get(0);
				ipdVitalSetupSave.setLastChgBy(ipdVitalSetup.getLastChgBy());
				ipdVitalSetupSave.setLastChgTime(ipdVitalSetup.getLastChgTime());
				ipdVitalSetupSave.setLastChgDate(ipdVitalSetup.getLastChgDate());
				ipdVitalSetupSave.setFrequency(ipdVitalSetup.getFrequency());
				ipdVitalSetupSave.setRemarks(ipdVitalSetup.getRemarks()); 	 
				ipdVitalSetupSave.setStopVital(ipdVitalSetup.getStopVital());	 
				IpdVitalcareSetupHistory savehistory=null;	  
				List<IpdVitalcareSetupHistory> ipdVitalcareSetupHistories=new ArrayList<IpdVitalcareSetupHistory>();						
							ipdVitalcareSetupHistories = session.createCriteria(IpdVitalcareSetupHistory.class,"vcsh")
									.createAlias("VitalSetup", "vcs") 
									.add(Restrictions.eq("vcs.Id", ipdVitalSetup.getId())).list();
							if(ipdVitalcareSetupHistories.size()>0)
							{
							savehistory=ipdVitalcareSetupHistories.get(0); 
							savehistory.setVitalSetup(ipdVitalSetup);
							savehistory.setEndDate(history.getEndDate());
							savehistory.setEndTime(history.getEndTime());
							savehistory.setStartDate(history.getStartDate());
							savehistory.setStartTime(history.getStartTime());
							} 
							if(ipdVitalSetupSave!=null){
								hbt.save(ipdVitalSetupSave);		
							}
							if(savehistory!=null){ 
								savehistory.setVitalSetup(ipdVitalSetupSave);
								hbt.save(savehistory);
							}
							
							 
			}
			else{
			hbt.save(ipdVitalSetup);
			history.setVitalSetup(ipdVitalSetup);
			hbt.save(history);
		}
			hbt.flush();
			hbt.clear();
		
		}}
	}

	private void saveNusringCareDetails(Inpatient inpatient,
			String[] nursingcareSetupListObjectDataArray,
			String[] nursingcareHistoryListObjectDataArray) {
			Session session=(Session)getSession();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
		  int index;
		for(int i=0;i<nursingcareSetupListObjectDataArray.length;i++){
			String nursingcareSetupArray[]=nursingcareSetupListObjectDataArray[i].split("\\|");
			
			if(nursingcareSetupArray.length>1){ 
			NursingcareSetup nursingcareSetup=new NursingcareSetup();  
			nursingcareSetup.setInpatient(inpatient); 
			nursingcareSetup.setHin(inpatient.getHin()); 
			index=0;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				MasNursingCare masNursingCare=new MasNursingCare(Integer.parseInt(nursingcareSetupArray[index].trim()));
				nursingcareSetup.setNursing(masNursingCare);
			}
			index++;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				Users user=new Users(Integer.parseInt(nursingcareSetupArray[index].trim()));
				nursingcareSetup.setLastChgBy(user);
			}
			index++;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				nursingcareSetup.setLastChgTime(nursingcareSetupArray[index].trim());
			}
			index++;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				nursingcareSetup.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(nursingcareSetupArray[index].trim()));
			}
			index++; 
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				MasFrequency masFrequency=new MasFrequency(Integer.parseInt(nursingcareSetupArray[index].trim()));
				nursingcareSetup.setFrequency(masFrequency);
			}
			index++; 
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				MasHospital hospital=new MasHospital(Integer.parseInt(nursingcareSetupArray[index].trim()));
				nursingcareSetup.setHospital(hospital);
			}
			index++;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				nursingcareSetup.setRemarks(nursingcareSetupArray[index].trim());
			}
			index++;
			if(nursingcareSetupArray[index]!=null && !"".equals(nursingcareSetupArray[index].trim())){ 
				nursingcareSetup.setStopCare(nursingcareSetupArray[index].trim());
			}
			NursingcareSetupHistory history=new NursingcareSetupHistory();
			if(nursingcareHistoryListObjectDataArray.length>i){ 
				String nursingcareHistoryArray[]=nursingcareHistoryListObjectDataArray[i].split("\\|");
			if(nursingcareHistoryArray.length>1){ 
			index=0;
			if(nursingcareHistoryArray[index]!=null && !"".equals(nursingcareHistoryArray[index].trim())){
				history.setStartDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						nursingcareHistoryArray[index].trim()));
			} 
			index++;
			if(nursingcareHistoryArray[index]!=null && !"".equals(nursingcareHistoryArray[index].trim())){
				history.setStartTime(nursingcareHistoryArray[index].trim());
			} 
			index++;
			if(nursingcareHistoryArray[index]!=null && !"".equals(nursingcareHistoryArray[index].trim())){
				history.setEndDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						nursingcareHistoryArray[index].trim()));
			} 
			index++;
			if(nursingcareHistoryArray[index]!=null && !"".equals(nursingcareHistoryArray[index].trim())){
				history.setEndTime(nursingcareHistoryArray[index].trim());
			}
			}
			}
			NursingcareSetup saveNursingcareSetup=null;
			List<NursingcareSetup> nursingcareSetups=new ArrayList<NursingcareSetup>();
			nursingcareSetups = session.createCriteria(NursingcareSetup.class)
					.add(Restrictions.eq("Nursing.Id", nursingcareSetup.getNursing().getId()))
					.add(Restrictions.eq("Inpatient.Id", inpatient.getId()))
					.add(Restrictions.eq("Hospital.Id", inpatient.getHospital().getId())).list();
			if(nursingcareSetups!=null && nursingcareSetups.size()>0){ 
				saveNursingcareSetup=nursingcareSetups.get(0); 
				saveNursingcareSetup.setLastChgBy(nursingcareSetup.getLastChgBy());
				saveNursingcareSetup.setLastChgTime(nursingcareSetup.getLastChgTime());
				saveNursingcareSetup.setLastChgDate(nursingcareSetup.getLastChgDate());
				saveNursingcareSetup.setFrequency(nursingcareSetup.getFrequency()); 
				saveNursingcareSetup.setRemarks(nursingcareSetup.getRemarks());
				saveNursingcareSetup.setStopCare(nursingcareSetup.getStopCare()); 
				NursingcareSetupHistory savehistory=null; 	 
				List<NursingcareSetupHistory> nursingcareSetupHistories=new ArrayList<NursingcareSetupHistory>();						
				nursingcareSetupHistories = session.createCriteria(NursingcareSetupHistory.class,"ncsh")
									.createAlias("NursingcareSetup", "ncs") 
									.add(Restrictions.eq("ncs.Id", nursingcareSetup.getId())).list();									
							if(nursingcareSetupHistories.size()>0)
							{
							savehistory=nursingcareSetupHistories.get(0); 
							savehistory.setNursingcareSetup(nursingcareSetup);
							savehistory.setEndDate(history.getEndDate());
							savehistory.setEndTime(history.getEndTime());
							savehistory.setStartDate(history.getStartDate());
							savehistory.setStartTime(history.getStartTime());
							} 
				if(saveNursingcareSetup!=null){
					hbt.saveOrUpdate(saveNursingcareSetup);			
				}
				if(savehistory!=null){

					hbt.saveOrUpdate(savehistory);
				}
			}else{ 
				hbt.save(nursingcareSetup);
				history.setNursingcareSetup(nursingcareSetup); 
				hbt.save(history);
			} 
			hbt.flush();
			hbt.clear();
		}}
	}

	private List<DgSampleCollectionDetails> saveDgSampleCollectionDetailsList(
			DgSampleCollectionHeader dgSampleCollectionHeader,
			String[] dgSampleCollectionDeatilsListObjectDataArray) {
		int index;
		List<DgSampleCollectionDetails> dgSampleCollectionDetailsList=new ArrayList<DgSampleCollectionDetails>(); 
		for(int i=0;i<dgSampleCollectionDeatilsListObjectDataArray.length;i++){
			String dgSampleCollectionDetailsArray[]=dgSampleCollectionDeatilsListObjectDataArray[i].split("\\|");
			if(dgSampleCollectionDetailsArray.length>1){
				
			
			DgSampleCollectionDetails dgSampleCollectionDetails=new DgSampleCollectionDetails(); 
			dgSampleCollectionDetails.setSampleCollectionHeader(dgSampleCollectionHeader);
			
			index=0;  
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				MasChargeCode masChargeCode=new MasChargeCode(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setChargeCode(masChargeCode); 
			} 
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				MasEmployee masEmployee=new MasEmployee(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setCollectedBy(masEmployee);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setCollected(dgSampleCollectionDetailsArray[index].trim());
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				Users user=new Users(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setLastChgBy(user);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						dgSampleCollectionDetailsArray[index].trim()));
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setLastChgTime(dgSampleCollectionDetailsArray[index].trim());
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setOrderStatus(dgSampleCollectionDetailsArray[index]);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setSampleCollDatetime(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						dgSampleCollectionDetailsArray[index]));
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				MasMainChargecode mainChargecode=new MasMainChargecode(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setMaincharge(mainChargecode);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				MasSubChargecode subCharge=new MasSubChargecode(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setSubcharge(subCharge);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				DgMasInvestigation investigation=new DgMasInvestigation(Integer.parseInt(dgSampleCollectionDetailsArray[index].trim()));
				dgSampleCollectionDetails.setInvestigation(investigation);
			}
			index++;
			if(dgSampleCollectionDetailsArray[index]!=null && !"".equals(dgSampleCollectionDetailsArray[index].trim())){ 
				dgSampleCollectionDetails.setSampleCollDatetime(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
						dgSampleCollectionDetailsArray[index].trim()));
			}
			dgSampleCollectionDetailsList.add(dgSampleCollectionDetails);
		}}
		return dgSampleCollectionDetailsList;
	}

	private List<DgOrderdt> saveDgOrderdtList(DgOrderhd dgOrderhd,
			String[] dgOrderDetailsListObjectDataArray) {
		int index;
		List<DgOrderdt> dgOrderdtList=new ArrayList<DgOrderdt>();
		for(int i=0;i<dgOrderDetailsListObjectDataArray.length;i++){
			String dgOrderDetailsArray[]=dgOrderDetailsListObjectDataArray[i].split("\\|");
			if(dgOrderDetailsArray.length>1){ 
			DgOrderdt dgOrderdt=new DgOrderdt();
			dgOrderdt.setOrderhd(dgOrderhd);
			index=0;  
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				MasChargeCode masChargeCode=new MasChargeCode(Integer.parseInt(dgOrderDetailsArray[index].trim()));
				dgOrderdt.setChargeCode(masChargeCode);
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setOrderQty(Integer.parseInt(dgOrderDetailsArray[index].trim()));
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				Users user=new Users(Integer.parseInt(dgOrderDetailsArray[index].trim()));
				dgOrderdt.setLastChgBy(user);
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dgOrderDetailsArray[index].trim()));
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setLastChgTime(dgOrderDetailsArray[index].trim());
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setOrderStatus(dgOrderDetailsArray[index]);
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				MasMainChargecode chargecode=new MasMainChargecode(Integer.parseInt(dgOrderDetailsArray[index].trim()));
				dgOrderdt.setMainChargecode(chargecode);	
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				MasSubChargecode masSubChargecode=new MasSubChargecode(Integer.parseInt(dgOrderDetailsArray[index].trim()));
				dgOrderdt.setSubChargeid(masSubChargecode);
			} 
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setPaymentMade(dgOrderDetailsArray[index].trim());
			}
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setMsgSent(dgOrderDetailsArray[index]);
			} 
			index++;
			if(dgOrderDetailsArray[index]!=null && !"".equals(dgOrderDetailsArray[index].trim())){ 
				dgOrderdt.setPacsStatus(dgOrderDetailsArray[index]);
			}
			dgOrderdtList.add(dgOrderdt);
			}
		}
		return dgOrderdtList;
	}

	private List<PatientInvestigationDetails> savePatientInvestigationDetailsList(
			PatientInvestigationHeader patientInvestigationHeader,
			String[] patientInvestigatinDetailsListObjectDataArray) {
		int index;
		List<PatientInvestigationDetails> PatientInvestigationDetailsList=new ArrayList<PatientInvestigationDetails>();
		for(int i=0;i<patientInvestigatinDetailsListObjectDataArray.length;i++){
			String patientInvestigatinDetailsArray[]=patientInvestigatinDetailsListObjectDataArray[i].split("\\|");
			if(patientInvestigatinDetailsArray.length>1){
			PatientInvestigationDetails patientInvestigationDetails=new PatientInvestigationDetails();
			patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
			index=0;
			if(patientInvestigatinDetailsArray[index]!=null && !"".equals(patientInvestigatinDetailsArray[index].trim())){
				MasChargeCode masChargeCode=new MasChargeCode(Integer.parseInt(patientInvestigatinDetailsArray[index].trim()));
				patientInvestigationDetails.setChargeCode(masChargeCode);
			} 
			index++; 
			if(patientInvestigatinDetailsArray[index]!=null && !"".equals(patientInvestigatinDetailsArray[index].trim())){
				patientInvestigationDetails.setQuantity(Integer.parseInt(patientInvestigatinDetailsArray[index].trim()));
			}
			index++; 
			if(patientInvestigatinDetailsArray[index]!=null && !"".equals(patientInvestigatinDetailsArray[index].trim())){
				patientInvestigationDetails.setClinicalNotes(patientInvestigatinDetailsArray[index]);
			}
			PatientInvestigationDetailsList.add(patientInvestigationDetails);
		}
		}
		return PatientInvestigationDetailsList;
	}

	private DgSampleCollectionHeader saveDgSampleCollectionHeader(
			String[] dgSampleCollectionHeaderDataArray, Inpatient inpatient,
			DgOrderhd dgOrderhd) {
		int index;
		DgSampleCollectionHeader dgSampleCollectionHeader=new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setHin(inpatient.getHin());
		dgSampleCollectionHeader.setOrder(dgOrderhd);
		dgSampleCollectionHeader.setInpatient(inpatient);
		index=0;   
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			MasDepartment department=new MasDepartment(Integer.parseInt(dgSampleCollectionHeaderDataArray[index].trim()));
			dgSampleCollectionHeader.setDepartment(department);
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			MasHospital masHospital=new MasHospital(Integer.parseInt(dgSampleCollectionHeaderDataArray[index].trim()));
			dgSampleCollectionHeader.setHospital(masHospital);
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					dgSampleCollectionHeaderDataArray[index].trim()));
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			dgSampleCollectionHeader.setDiagnosisTime(dgSampleCollectionHeaderDataArray[index].trim());
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			dgSampleCollectionHeader.setOrderStatus(dgSampleCollectionHeaderDataArray[index].trim());
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			Users user=new Users(Integer.parseInt(dgSampleCollectionHeaderDataArray[index].trim()));
			dgSampleCollectionHeader.setLastChgBy(user);
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			dgSampleCollectionHeader.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					dgSampleCollectionHeaderDataArray[index].trim()));
		}
		index++;
		if(dgSampleCollectionHeaderDataArray[index]!=null && !"".equals(dgSampleCollectionHeaderDataArray[index].trim())){
			dgSampleCollectionHeader.setLastChgTime(dgSampleCollectionHeaderDataArray[index].trim());
		}
		return dgSampleCollectionHeader;
	}

	private DgOrderhd saveDgOrderhd(
			String[] dgOrderhdDataArray, Inpatient inpatient,
			PatientInvestigationHeader patientInvestigationHeader) {
		
		DgOrderhd dgOrderhd=new DgOrderhd();
		dgOrderhd.setInpatient(inpatient);
		dgOrderhd.setHin(inpatient.getHin());
		dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
		int index=0; 
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setOrderDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					dgOrderhdDataArray[index].trim()));
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setOrderTime(dgOrderhdDataArray[index].trim());
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			MasHospital hospital=new MasHospital(Integer.parseInt(dgOrderhdDataArray[index].trim()));
			dgOrderhd.setHospital(hospital);
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			MasDepartment department=new MasDepartment(Integer.parseInt(dgOrderhdDataArray[index].trim()));
			dgOrderhd.setDepartment(department);
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			MasEmployee masEmployee=new MasEmployee(Integer.parseInt(dgOrderhdDataArray[index].trim()));
			dgOrderhd.setPrescribedBy(masEmployee);
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setPatientType(dgOrderhdDataArray[index].trim());
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setTestType(dgOrderhdDataArray[index].trim());
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setOrderNo(dgOrderhdDataArray[index].trim());
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setOrderStatus(dgOrderhdDataArray[index]);
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			Users user=new Users(Integer.parseInt(dgOrderhdDataArray[index].trim()));
			dgOrderhd.setLastChgBy(user);
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					dgOrderhdDataArray[index]));
		}
		index++;
		if(dgOrderhdDataArray[index]!=null && !"".equals(dgOrderhdDataArray[index].trim())){
			dgOrderhd.setLastChgTime(dgOrderhdDataArray[index]);
		}
		return dgOrderhd;
	}

	private PatientInvestigationHeader savePatientInvestigationHeader(
			String[] inpatientPrescriptionHeaderDataArray, Inpatient inpatient,
			OpdPatientDetails opdPatientDetails) {
		
		PatientInvestigationHeader patientInvestigationHeader=new PatientInvestigationHeader(); 
		patientInvestigationHeader.setHin(inpatient.getHin());
		patientInvestigationHeader.setInpatient(inpatient);
		patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);  
		
		int index=0;  
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasDepartment masDepartment=new MasDepartment(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			patientInvestigationHeader.setDepartment(masDepartment);
		} 
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasHospital hospital=new MasHospital(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			patientInvestigationHeader.setHospital(hospital);
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			patientInvestigationHeader.setStatus(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			patientInvestigationHeader.setInvestigationDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					inpatientPrescriptionHeaderDataArray[index].trim()));
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			patientInvestigationHeader.setInvestigationTime(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasEmployee employee=new MasEmployee(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			patientInvestigationHeader.setInvestigationBy(employee);
		}
		return patientInvestigationHeader;
	}

	private InpatientPrescriptionHeader saveInpatientPrescriptionHeader(
			String[] inpatientPrescriptionHeaderDataArray, Inpatient inpatient,
			OpdPatientDetails opdPatientDetails) {
		
		InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
		inpatientPrescriptionHeader.setHin(inpatient.getHin());
		inpatientPrescriptionHeader.setInpatient(inpatient); 
		inpatientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
		
		int index=0;  
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasDepartment department=new MasDepartment(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			inpatientPrescriptionHeader.setDepartment(department); 
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasHospital masHospital=new MasHospital(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			inpatientPrescriptionHeader.setHospital(masHospital);
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){ 
			inpatientPrescriptionHeader.setStatus(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					inpatientPrescriptionHeaderDataArray[index].trim()));
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			inpatientPrescriptionHeader.setPrescriptionTime(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			MasEmployee masEmployee=new MasEmployee(Integer.parseInt(inpatientPrescriptionHeaderDataArray[index].trim()));
			inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					inpatientPrescriptionHeaderDataArray[index].trim()));
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			inpatientPrescriptionHeader.setPrescriptionTime(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		index++;
		if(inpatientPrescriptionHeaderDataArray[index]!=null && !"".equals(inpatientPrescriptionHeaderDataArray[index].trim())){
			inpatientPrescriptionHeader.setPrescriptionNo(inpatientPrescriptionHeaderDataArray[index].trim());
		}
		return inpatientPrescriptionHeader;
	}

	private DischargeIcdCode saveDischargeIcdCode(
			String[] dischargeIcdCodeDataArray, Inpatient inpatient,
			OpdPatientDetails opdPatientDetails) { 
		DischargeIcdCode dischargeIcdCode=new DischargeIcdCode();  
		dischargeIcdCode.setHin(inpatient.getHin());
		dischargeIcdCode.setInpatient(inpatient);
		dischargeIcdCode.setOpdPatientDetails(opdPatientDetails);
		 
		int index=0;  
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			MasIcd icd=new MasIcd(Integer.parseInt(dischargeIcdCodeDataArray[index].trim()));
			dischargeIcdCode.setIcd(icd);
		} 
		index++;
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			dischargeIcdCode.setAddEditDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					dischargeIcdCodeDataArray[index].trim()));
		}
		index++;
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			dischargeIcdCode.setAddEditTime(dischargeIcdCodeDataArray[index].trim());
		}
		index++;
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			dischargeIcdCode.setStatus(dischargeIcdCodeDataArray[index].trim());
		}
		index++;
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			dischargeIcdCode.setDiagnosisStatus(dischargeIcdCodeDataArray[index].trim());
		}
		
		index++;
		if(dischargeIcdCodeDataArray[index]!=null && !"".equals(dischargeIcdCodeDataArray[index].trim())){
			MasHospital hospital=new MasHospital(Integer.parseInt(dischargeIcdCodeDataArray[index].trim()));
			dischargeIcdCode.setHospital(hospital);
		}
		return dischargeIcdCode;
	}

	private OpdPatientHistory saveOPDPatientHistory(
			String[] opdPatientHistoryDataArray, Inpatient inpatient,
			OpdPatientDetails opdPatientDetails) {
		OpdPatientHistory opdPatientHistory=new OpdPatientHistory(); 
		 
		opdPatientHistory.setHin(inpatient.getHin()); 
		opdPatientHistory.setInpatient(inpatient); 
		opdPatientHistory.setOpdPatientDetails(opdPatientDetails);
		 
		int index=0;  
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			MasDepartment department=new MasDepartment(Integer.parseInt(opdPatientHistoryDataArray[index].trim()));
			opdPatientHistory.setDepartment(department);
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			MasHospital masHospital=new MasHospital(Integer.parseInt(opdPatientHistoryDataArray[index].trim()));
			opdPatientHistory.setHospital(masHospital);
		}
		index++; 
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setLastChgTime(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			Users user=new Users(Integer.parseInt(opdPatientHistoryDataArray[index].trim()));
			opdPatientHistory.setLastChgBy(user);
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){ 
			opdPatientHistory.setStatus(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setLastChgDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					opdPatientHistoryDataArray[index].trim()));
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setPresentComplaintHistory(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setPastIllnessHistory(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setPersonalPresentHistory(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setFamilyPastHistory(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setMadicationHistory(opdPatientHistoryDataArray[index].trim());
		}
		index++;
		if(opdPatientHistoryDataArray[index]!=null && !"".equals(opdPatientHistoryDataArray[index].trim())){
			opdPatientHistory.setIpOpPacStatus(opdPatientHistoryDataArray[index].trim());
		} 
		return opdPatientHistory;
	}

	private OpdPatientDetails saveOpdPatientDetail(
			String[] opdPatientDetailsDataArray, Inpatient inpatient) {
		
		OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
		
		if(inpatient!=null){
			opdPatientDetails.setInpatient(inpatient);
		} 
		int index=0;
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			MasEmployee masEmployee=new MasEmployee(Integer.parseInt(opdPatientDetailsDataArray[index].trim()));
			opdPatientDetails.setEmployee(masEmployee);
		} 
		index++; 
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			MasHospital hospital=new MasHospital(Integer.parseInt(opdPatientDetailsDataArray[index].trim()));
			opdPatientDetails.setHospital(hospital);
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setHeight(Double.parseDouble(opdPatientDetailsDataArray[index].trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setPulse(Integer.parseInt(opdPatientDetailsDataArray[index].trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setWeight(Double.parseDouble(opdPatientDetailsDataArray[index].trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setBp(opdPatientDetailsDataArray[index].trim());
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setTemperature(Float.parseFloat(opdPatientDetailsDataArray[index].trim().trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setConsultationTime(opdPatientDetailsDataArray[index].trim());
		}
		index++; 
		
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){ 
			opdPatientDetails.setConsultationDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(
					opdPatientDetailsDataArray[index].trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setOpdDate(HMSUtil.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(opdPatientDetailsDataArray[index].trim()));
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setOpdTime(opdPatientDetailsDataArray[index].trim());
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setBmi(Float.parseFloat(opdPatientDetailsDataArray[index].trim()));
		}
		index++; 
		
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setClinicalNote(opdPatientDetailsDataArray[index].trim());
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			MasSystemDiagnosis diagnosis=new MasSystemDiagnosis(Integer.parseInt(opdPatientDetailsDataArray[index].trim()));
			opdPatientDetails.setSystemDiagnosis(diagnosis);
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setGeneralExamination(opdPatientDetailsDataArray[index].trim());
		}
		index++;
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){ 
			opdPatientDetails.setLocalExamination(opdPatientDetailsDataArray[index].trim());
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setSystemicExamination(opdPatientDetailsDataArray[index].trim());
		}
		index++;  
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){
			opdPatientDetails.setOutsideInvestigation(opdPatientDetailsDataArray[index].trim());
		}
		index++; 
		if(opdPatientDetailsDataArray[index]!=null && !"".equals(opdPatientDetailsDataArray[index].trim())){ 
			opdPatientDetails.setOutsideInvestigationImage(opdPatientDetailsDataArray[index].trim());
		}
		return opdPatientDetails;
	}

	private Inpatient saveInpatient(String[] inpatientDataArray) {
		int index;
		Inpatient inpatient=new Inpatient();
		index=0;
		if(inpatientDataArray[index]!=null && !"".equals(inpatientDataArray[index].trim())){
			inpatient.setAdStatus(inpatientDataArray[0].trim());
		}
		index++;
		if(inpatientDataArray[index]!=null && !"".equals(inpatientDataArray[index].trim())){
			MasDiet masDiet=new MasDiet(Integer.parseInt(inpatientDataArray[index].trim()));
			inpatient.setDiet(masDiet);
		}
		index++;
		if(inpatientDataArray[index]!=null && !"".equals(inpatientDataArray[index].trim())){
			inpatient.setHinNo(inpatientDataArray[index].trim());
		}
		index++;
		if(inpatientDataArray[index]!=null && !"".equals(inpatientDataArray[index].trim())){
			MasDepartment department=new MasDepartment(Integer.parseInt(inpatientDataArray[index].trim()));
			inpatient.setDepartment(department);
		}
		index++;
		if(inpatientDataArray[index]!=null && !"".equals(inpatientDataArray[index].trim())){
			inpatient.setRemarks(inpatientDataArray[index].trim());
		} 
		return inpatient;
	}
	@Override
	public Map<String, Object> getIPDNoFortDeathCertificate(String hinNo) {
		Map<String, Object>map=new HashMap<String,Object>();
		List<Discharge>dischargeList=new ArrayList<Discharge>();
		Session session =(Session)getSession();
		dischargeList=session.createCriteria(Discharge.class)
				.createAlias("Hin","hin")
				.add(Restrictions.eq("hin.HinNo",hinNo.trim()))
				.add(Restrictions.eq("DischargeStatus.Id",3))
				.list();
		
		int hinId=0;
		for(Discharge disc:dischargeList){
			hinId=disc.getHin().getId();
		}
		List<Inpatient>ipList=new ArrayList<Inpatient>();
		ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("ipList",ipList);
		return map;
	}	
	
	public Map<String, Object> getMotherBabyDeatils(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		int inpatientId = 0;
		Session session = (Session) getSession();
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}

		try {
			inPatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();

			employeeList = session.createCriteria(MasEmployee.class)
					.createAlias("EmpCategory", "empCat")
					.add(Restrictions.eq("empCat.EmpCategoryCode", "01"))
					.list();
			sexList = session.createCriteria(MasAdministrativeSex.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			deliveryTypeList = session.createCriteria(MasDeliveryType.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			bloodGroupList = session.createCriteria(MasBloodGroup.class).addOrder(Order.asc("BloodGroupName")).list();

			map.put("inPatientList", inPatientList);
			map.put("employeeList", employeeList);
			map.put("deliveryTypeList", deliveryTypeList);
			map.put("sexList", sexList);
			map.put("bloodGroupList", bloodGroupList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String,Object> sendIpdDetailFromLeanToServer(Map<String,Object> ipdPatientData,
			Map<String,List<Object>> ipdPatientDataList,MasHospital hospital){
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader in = null; 
		String message = "2"; 
		Map<String,Object> returnMap=new HashMap<String,Object>();
		try{
			
			OpdPatientDetails 	opdPatientDetails=(OpdPatientDetails)ipdPatientData.get("OpdPatientDetails");
			OpdPatientHistory opdPatientHistory=(OpdPatientHistory)ipdPatientData.get("OpdPatientHistory");
			DischargeIcdCode dischargeIcdCode=(DischargeIcdCode)ipdPatientData.get("DischargeIcdCode");
			InpatientPrescriptionHeader inpatientPrescriptionHeader=(InpatientPrescriptionHeader)ipdPatientData.get("inpatientPrescriptionHeader");
			PatientInvestigationHeader patientInvestigationHeader=(PatientInvestigationHeader)ipdPatientData.get("patientInvestigationHeader");
			DgOrderhd dgOrderhd=(DgOrderhd)ipdPatientData.get("dgOrderhd");
			DgSampleCollectionHeader dgSampleCollectionHeader =(DgSampleCollectionHeader)ipdPatientData.get("DgSampleCollectionHeader");
			Inpatient inpatient=(Inpatient)ipdPatientData.get("ip");
			
			
			
			List<PatientInvestigationDetails> patientInvestigatinDetailsListObject=
					(List<PatientInvestigationDetails>)(Object)ipdPatientDataList.get("patientInvestigatinDetailsListObject");
			
			List<InpatientPrescriptionDetails> inpatientPrescriptionDetailsList=
					(List<InpatientPrescriptionDetails>)(Object)ipdPatientDataList.get("inpatientPrescriptionDetailsListObject");
			
			List<DgOrderdt> dgOrderDetailsListObject=
					(List<DgOrderdt>)(Object)ipdPatientDataList.get("dgOrderDetailsListObject");
			
			List<DgSampleCollectionDetails> dgSampleCollectionDeatilsListObject=
					(List<DgSampleCollectionDetails>)(Object)ipdPatientDataList.get("dgSampleCollectionDeatilsListObject"); 
			
			List<NursingcareSetup>	nursingcareSetupListObject=
					(List<NursingcareSetup>)(Object)ipdPatientDataList.get("nursingcareSetupListObject"); 
			
			List<NursingcareSetupHistory> nursingcareHistoryListObject=
					(List<NursingcareSetupHistory>)(Object)ipdPatientDataList.get("nursingcareHistoryListObject"); 
			
			List<IpdVitalSetup> ipdVitalSetupListObject=
					(List<IpdVitalSetup>)(Object)ipdPatientDataList.get("ipdVitalSetupListObject"); 
			
			List<IpdVitalcareSetupHistory> ipdVitalSetupHistoryListObject=
					(List<IpdVitalcareSetupHistory>)(Object)ipdPatientDataList.get("ipdVitalSetupHistoryListObject");
			 
					StringBuilder builder=new StringBuilder(); 
					if(inpatient!=null){
						builder.append(inpatient.getAdStatus()).append(" |");  
						if(inpatient.getDiet()!=null){
							builder.append(inpatient.getDiet().getId()).append(" |");
						}else{
							builder.append(" |");
						}  
						builder.append(inpatient.getHinNo()).append(" |");
						builder.append(inpatient.getDepartment().getId()).append(" |");
						builder.append(inpatient.getRemarks()+" |");   
					}
					builder.append(" #");	
                    if(opdPatientDetails!=null){ 
                    	
                    	//builder.append(opdPatientDetails.getInpatient().getId()).append(" |");
                    	builder.append(opdPatientDetails.getEmployee().getId()).append(" |");  
                    	builder.append(opdPatientDetails.getHospital().getId()).append(" |");
                    	builder.append(opdPatientDetails.getHeight()).append(" |");
                    	builder.append(opdPatientDetails.getPulse()).append(" |");
                    	builder.append(opdPatientDetails.getWeight()).append(" |");
                    	builder.append(opdPatientDetails.getBp()).append(" |");
                    	builder.append(opdPatientDetails.getTemperature()).append(" |");
                    	builder.append(opdPatientDetails.getConsultationTime()).append(" |");
                    	builder.append(opdPatientDetails.getConsultationDate()).append(" |");
                    	builder.append(opdPatientDetails.getOpdDate()).append(" |");
                    	builder.append(opdPatientDetails.getOpdTime()).append(" |"); 
                    	builder.append(opdPatientDetails.getBmi()).append(" |");
                    	builder.append(opdPatientDetails.getClinicalNote().trim()).append(" |");
                    	builder.append(opdPatientDetails.getSystemDiagnosis()).append(" |");
                    	builder.append(opdPatientDetails.getGeneralExamination()).append(" |");
                    	builder.append(opdPatientDetails.getLocalExamination()).append(" |");
                    	builder.append(opdPatientDetails.getSystemicExamination()).append(" |");
                    	builder.append(opdPatientDetails.getOutsideInvestigation()).append(" |");
                    	builder.append(opdPatientDetails.getOutsideInvestigationImage()+" |"); 
                    }
                    builder.append(" #");	
                    if(opdPatientHistory!=null){
                    	builder.append(opdPatientHistory.getDepartment().getId()).append(" |");
                    	builder.append(opdPatientHistory.getHospital().getId()).append(" |");
                    	//builder.append(opdPatientHistory.getHin().getHinNo()).append(" |");
                    	//builder.append(opdPatientHistory.getInpatient().getId()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgTime()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgBy().getId()).append(" |");
                    	builder.append(opdPatientHistory.getStatus()).append(" |");
                    	builder.append(opdPatientHistory.getLastChgDate()).append(" |");
                    	builder.append(opdPatientHistory.getPresentComplaintHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getPastIllnessHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getPersonalPresentHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getFamilyPastHistory().trim()).append(" |");
                    	builder.append(opdPatientHistory.getMadicationHistory().trim()).append(" |"); 
                    	builder.append(opdPatientHistory.getIpOpPacStatus()).append(" |");
                    	//builder.append(opdPatientHistory.getOpdPatientDetails()+"");
                    	//builder.append(opdPatientHistory.getInpatient()).append(" |"); 
                    }
                    builder.append(" #");	
                    if(dischargeIcdCode!=null){
                    	//builder.append(	dischargeIcdCode.getHin().getHinNo()).append(" |");
                    	builder.append(dischargeIcdCode.getIcd().getId()).append(" |");
                    	builder.append(dischargeIcdCode.getAddEditDate()).append(" |");
                    	builder.append(dischargeIcdCode.getAddEditTime()).append(" |");
                    	builder.append(dischargeIcdCode.getStatus()).append(" |");
                    	builder.append(dischargeIcdCode.getDiagnosisStatus()).append(" |");
                    	//builder.append(dischargeIcdCode.getInpatient().getId()).append(" |");
                    	builder.append(dischargeIcdCode.getHospital().getId()+" |");
                    	//builder.append(dischargeIcdCode.getOpdPatientDetails().getId()).append(" |"); 
                    }
                    builder.append(" #");	
                    if(inpatientPrescriptionHeader!=null){
                    	
                    	//builder.append(inpatientPrescriptionHeader.getHin().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getDepartment().getId()).append(" |");
                    	//builder.append(inpatientPrescriptionHeader.getInpatient().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getHospital().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getStatus()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionDate()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionTime()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionBy().getId()).append(" |");
                    	//builder.append(inpatientPrescriptionHeader.getOpdPatientDetail().getId()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionDate()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionTime()).append(" |");
                    	builder.append(inpatientPrescriptionHeader.getPrescriptionNo()+" |"); 
                    	
                    }
                    builder.append(" #");	
                    if(patientInvestigationHeader!=null){ 
                    	//builder.append(patientInvestigationHeader.getHin().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getDepartment().getId()).append(" |");
                    	//builder.append(patientInvestigationHeader.getInpatient().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getHospital().getId()).append(" |");
                    	builder.append(patientInvestigationHeader.getStatus()).append(" |");
                    	builder.append(patientInvestigationHeader.getInvestigationDate()).append(" |");
                    	builder.append(patientInvestigationHeader.getInvestigationTime()).append(" |");
                    	//builder.append(patientInvestigationHeader.getOpdPatientDetail()).append(" |");
                    	builder.append(	patientInvestigationHeader.getInvestigationBy().getId()+" |"); 
                    	
                    }
                    builder.append(" #");	
                    if(dgOrderhd!=null){
                    	builder.append(dgOrderhd.getOrderDate()).append(" |");
                    	builder.append(dgOrderhd.getOrderTime()).append(" |");
                    	builder.append(dgOrderhd.getHospital().getId()).append(" |");
                    	//builder.append(dgOrderhd.getInpatient().getId()).append(" |");
                    	//builder.append(dgOrderhd.getHin().getId()).append(" |");
                    	builder.append(dgOrderhd.getDepartment().getId()).append(" |");
                    	builder.append(dgOrderhd.getPrescribedBy().getId()).append(" |"); 
                    	builder.append(dgOrderhd.getPatientType()).append(" |");
                    	builder.append(dgOrderhd.getTestType()).append(" |");
                    	builder.append(dgOrderhd.getOrderNo()).append(" |");
                    	builder.append(dgOrderhd.getOrderStatus()).append(" |");
                    	builder.append(dgOrderhd.getLastChgBy().getId()).append(" |");
                    	builder.append(dgOrderhd.getLastChgDate()).append(" |");
                    	builder.append(dgOrderhd.getLastChgTime()).append(" |");
                    	//builder.append(dgOrderhd.getInvestigationRequestionNo()+" #");  	

                    }
                    builder.append(" #");	
                    if(dgSampleCollectionHeader!=null){
                    	//builder.append(dgSampleCollectionHeader.getHin().getId()).append(" |"); 
                    	//builder.append(dgSampleCollectionHeader.getInpatient().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDepartment().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getHospital().getId()).append(" |"); 
                    	//builder.append(dgSampleCollectionHeader.getOrder()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDiagnosisDate()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getDiagnosisTime()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getOrderStatus()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgBy().getId()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgDate()).append(" |"); 
                    	builder.append(dgSampleCollectionHeader.getLastChgTime()+" |");  
                    }
                    builder.append(" #");	
                    if(patientInvestigatinDetailsListObject!=null && patientInvestigatinDetailsListObject.size()>0){
                    	for(PatientInvestigationDetails patientInvestigationDetails:patientInvestigatinDetailsListObject){ 
                    		//builder.append(patientInvestigationDetails.getInvestigationHeader().getId()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getChargeCode().getId()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getQuantity()).append(" |"); 
                    		builder.append(patientInvestigationDetails.getClinicalNotes()+" |");
                    		builder.append("$");
                    	} 
                    }
                    builder.append(" #");
                    if(inpatientPrescriptionDetailsList!=null &&inpatientPrescriptionDetailsList.size()>0){
                    	for(InpatientPrescriptionDetails inpatientPrescriptionDetails:inpatientPrescriptionDetailsList){ 
                    		if(inpatientPrescriptionDetails.getItem()!=null){
                    			builder.append(inpatientPrescriptionDetails.getItem().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		} 
                    		if(inpatientPrescriptionDetails.getFrequency()!=null){
                    			builder.append(inpatientPrescriptionDetails.getFrequency().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		}
                    		builder.append(inpatientPrescriptionDetails.getDosage()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getSplInstruction()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getNoOfDays()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getType()).append(" |"); 
                    		if(inpatientPrescriptionDetails.getInsrtuction()!=null){
                    			builder.append(inpatientPrescriptionDetails.getInsrtuction().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		} 
                    		if(inpatientPrescriptionDetails.getRoute()!=null){
                    			builder.append(inpatientPrescriptionDetails.getRoute().getId()).append(" |");
                    		}else{
                    			builder.append(" |");
                    		}
                    		builder.append(inpatientPrescriptionDetails.getTotal()).append(" |");
                    		builder.append(inpatientPrescriptionDetails.getStopMedicine()).append(" |");
                    		//builder.append(inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader));
                    		builder.append(inpatientPrescriptionDetails.getIssuedStatus()).append(" |");
                    		builder.append("$");
                    	}
                    }
                    builder.append(" #");
                    if(dgOrderDetailsListObject!=null && dgOrderDetailsListObject.size()>0){
                    	for(DgOrderdt dgOrderdt:dgOrderDetailsListObject){
                    		//builder.append(dgOrderdt.getOrderhd().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getChargeCode().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getOrderQty()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgBy().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgDate()).append(" |"); 
                    		builder.append(dgOrderdt.getLastChgTime()).append(" |"); 
                    		builder.append(dgOrderdt.getOrderStatus()).append(" |"); 
                    		builder.append(dgOrderdt.getMainChargecode().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getSubChargeid().getId()).append(" |"); 
                    		builder.append(dgOrderdt.getPaymentMade()).append(" |"); 
                    		builder.append(dgOrderdt.getMsgSent()).append(" |"); 
                    		builder.append(dgOrderdt.getPacsStatus()+" |");  
                    		builder.append("$");
                    	} 
                    }
                    builder.append(" #");
                    if(dgSampleCollectionDeatilsListObject!=null && dgSampleCollectionDeatilsListObject.size()>0){
                    	for(DgSampleCollectionDetails dgSampleCollectionDetails:dgSampleCollectionDeatilsListObject){
                    		
                    		//builder.append(dgSampleCollectionDetails.getSampleCollectionHeader().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getChargeCode().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getCollectedBy().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getCollected()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgBy().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgDate()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getLastChgTime()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getOrderStatus()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSampleCollDatetime()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getMaincharge().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSubcharge().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getInvestigation().getId()).append(" |"); 
                    		builder.append(dgSampleCollectionDetails.getSampleCollDatetime()+" |");  
                    		builder.append("$");
                    	}
                    	
                    	
                    }
                    builder.append(" #"); 
                    if(nursingcareSetupListObject!=null && nursingcareSetupListObject.size()>0){
                    	for(NursingcareSetup nursingcareSetup:nursingcareSetupListObject){
                    		if(nursingcareSetup!=null){ 
                    		builder.append(nursingcareSetup.getNursing().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgBy().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgTime()).append(" |"); 
                    		builder.append(nursingcareSetup.getLastChgDate()).append(" |"); 
                    		//builder.append(nursingcareSetup.getHin().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getFrequency().getId()).append(" |"); 
                    		//builder.append(nursingcareSetup.getInpatient().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getHospital().getId()).append(" |"); 
                    		builder.append(nursingcareSetup.getRemarks()).append(" |"); 
                    		builder.append(nursingcareSetup.getStopCare()+" |");   
                    		builder.append("$");
                    		}
                    	}
                    	
                    	
                    }
                    builder.append(" #");  
                    if(nursingcareHistoryListObject!=null && nursingcareHistoryListObject.size()>0){
                    	for(NursingcareSetupHistory nursingcareSetupHistory:nursingcareHistoryListObject){
                    		if(nursingcareSetupHistory!=null){ 
                    		builder.append(nursingcareSetupHistory.getStartDate()).append(" |"); 
                    		builder.append(nursingcareSetupHistory.getStartTime()).append(" |"); 
                    		//builder.append(nursingcareSetupHistory.getNursingcareSetup()).append(" |"); 
                    		builder.append(nursingcareSetupHistory.getEndDate()).append(" |");  
                    		builder.append(nursingcareSetupHistory.getEndTime()+" |"); 
                    		builder.append("$");
                    		}
                    	}
                    	
                    	
                    }
                    builder.append(" #");  
                    if(ipdVitalSetupListObject!=null && ipdVitalSetupListObject.size()>0){
                    	for(IpdVitalSetup ipdVitalSetup:ipdVitalSetupListObject){ 
                    		if(ipdVitalSetup!=null){
                    			
                    		
                    		builder.append(ipdVitalSetup.getVitalName()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgBy().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgDate()).append(" |"); 
                    		builder.append(ipdVitalSetup.getLastChgTime()).append(" |"); 
                    		//builder.append(ipdVitalSetup.getHin().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getFrequency().getId()).append(" |"); 
                    		//builder.append(ipdVitalSetup.getInpatient().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getHospital().getId()).append(" |"); 
                    		builder.append(ipdVitalSetup.getRemarks()).append(" |"); 
                    		builder.append(ipdVitalSetup.getStopVital()+" |"); 	
                    		builder.append("$");
                    		}
                    	}
                    	
                    }
                    builder.append(" #");
                    if(ipdVitalSetupHistoryListObject!=null && ipdVitalSetupHistoryListObject.size()>0){
                    	for(IpdVitalcareSetupHistory ipdVitalcareSetupHistory:ipdVitalSetupHistoryListObject){
                    		if(ipdVitalcareSetupHistory!=null){
                    			
                    		
                    		builder.append(ipdVitalcareSetupHistory.getStartDate()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getStartTime()).append(" |");
                    		//builder.append(ipdVitalcareSetupHistory.getVitalSetup().getId()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getEndDate()).append(" |");
                    		builder.append(ipdVitalcareSetupHistory.getEndTime()+" |");
                    		builder.append("$");
                    		}
                    	}  
                    } 
                    builder.append(" #"); 
			  	  	 
			  	  	 
                    String msg=builder.toString();
                    returnMap.put("IPDCasheetMessage", msg);
                      
			  	  try{
			  		msg=msg.replace("&", "$");
			  		msg=msg.replaceAll("[\r\n]", "*");
			  		String encode=URLEncoder.encode(msg,"UTF-8");
			  		String header="http://"+hospital.getClientIp()+":"+hospital.getClientPort();   
			  		String uri=header+"/hms/hms/ipd?method=submitIPDInformationFromLean&message="
			  					+encode+"&hospitalId="+hospital.getId();
			  		logger.info("Url>>>>"+uri);
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
			  				message = "1";
			  			}else if(responseMsg
			  					.contains("fail")){
			  				message = "2";
			  			}else if(responseMsg
			  					.contains("500")){
			  				message = "3";
			  			}
			  			logger.info("Input Stream: " + sb.toString());
			  		}catch (MalformedURLException e) {
			  			// TODO Auto-generated catch block
			  			e.printStackTrace();
			  			logger.info("Some Error occur in lean server when IPD Data saved ");
			  			
			  		} catch (IOException e) {
			  			// TODO Auto-generated catch block
			  			e.printStackTrace();
			  			logger.info("Some Error occur in lean server when IPD Data saved ");
			  			
			  		}
			  	  if("1".equals(message)){
			  		  logger.info("IPD Data successfuly save to lean server");
			  	  }else{
			  		  logger.info("Some Error occur in lean server when IPD Data saved ");
			  	  } 
			  	  returnMap.put("message", message);
				 return returnMap;
        	}catch(Exception e){
                e.printStackTrace();
                logger.info("Some Error occur in lean server when IPD Data saved ");
                returnMap.put("message", "failure");
				 return returnMap;
        	} 
        
} 	
	
	public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs,Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId = 0;
		String bloodLoss = "";
		String placenta = "";
		String treatment = "";
		Date dateOnSet = null;
		String timeOnSet = "";
		String purperium = "";
		String motherCondition = "";
		int pulse = 0;
		int perineum = 0;
		String bP = "";
		String bp2="";
		String additionalNotes = "";
		String complications = "";

		int assistedBy = 0;
		int masEmpIdConductedBy = 0;
		int masEmpIdAssistedBy = 0;
		int hospitalId = 0;
		int hinId = 0;
		int babyHinId = 0;
		
		int tsn = 0;
		int id = 0;
		Session session = (Session) getSession();
		List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();
		List<BabyDetails> birthList = new ArrayList<BabyDetails>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDated = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		/*if (mapForDs.get("masEmpIdConductedBy") != null) {
			masEmpIdConductedBy = (Integer) mapForDs.get("masEmpIdConductedBy");
		}
		if (mapForDs.get("masEmpIdAssistedBy") != null) {
			masEmpIdAssistedBy = (Integer) mapForDs.get("masEmpIdAssistedBy");
		}
		
		if (mapForDs.get("bloodLoss") != null) {
			bloodLoss = (String) mapForDs.get("bloodLoss");
		}
		if (mapForDs.get("placenta") != null) {
			placenta = (String) mapForDs.get("placenta");
		}
		if (mapForDs.get("treatment") != null) {
			treatment = (String) mapForDs.get("treatment");
		}
		if (mapForDs.get("dateOnSet") != null) {
			dateOnSet = (Date) mapForDs.get("dateOnSet");
		}
		if (mapForDs.get("timeOnSet") != null) {
			timeOnSet = (String) mapForDs.get("timeOnSet");
		}
		if (mapForDs.get("purperium") != null) {
			purperium = (String) mapForDs.get("purperium");
		}
		if (mapForDs.get("motherCondition") != null) {
			motherCondition = (String) mapForDs.get("motherCondition");
		}
		if (mapForDs.get("pulse") != null) {
			pulse = (Integer) mapForDs.get("pulse");
		}
		if (mapForDs.get("perineum") != null) {
			perineum = (Integer) mapForDs.get("perineum");
		}
		if (mapForDs.get("bP") != null) {
			bP = (String) mapForDs.get("bP");
		}
		if (mapForDs.get("bp2") != null) {
			bp2 = (String) mapForDs.get("bp2");
		}
		System.out.println(bP+"/"+bp2);
		if (mapForDs.get("additionalNotes") != null) {
			additionalNotes = (String) mapForDs.get("additionalNotes");
		}
		if (mapForDs.get("complications") != null) {
			complications = (String) mapForDs.get("complications");
		}*/
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean saved = true;
		boolean duplicate = true;
		String babyOfMotherName = "";
		String bplStatus="";
		String nationalDobStatus="";
		String motherHinNo ="";
		int patientTypeId=0;
		Date lastChangedate=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String curDate=sdf.format(date);
		Date currentDate = null;
		int  babyno=1;
		int  birthcertificateno=1;
		String babyHin = "";
		try {
			currentDate = sdf.parse(curDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Transaction tx = session.beginTransaction();
		try {
			deliveryDetailsList = session.createCriteria(DeliveryDetails.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
			int count = box.getInt("noOfBaby");

			if (deliveryDetailsList.size() == 0) {
				duplicate = false;

				DeliveryDetails deliveryDetails = new DeliveryDetails();

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				deliveryDetails.setInpatient(inpatient);

				/*if (masEmpIdConductedBy != 0) {
					MasEmployee conductedByEmp = new MasEmployee();
					conductedByEmp.setId(masEmpIdConductedBy);
					deliveryDetails.setConductedBy(conductedByEmp);
				}
				if (masEmpIdAssistedBy != 0) {
					MasEmployee assistedByEmp = new MasEmployee();
					assistedByEmp.setId(masEmpIdAssistedBy);
					deliveryDetails.setAssistedBy(assistedByEmp);
				}*/

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				deliveryDetails.setHospital(masHospital);
				
				Patient patient = new Patient();
				patient.setId(hinId);
				deliveryDetails.setHin(patient);
				
				if(!box.getString("termOfGestation").equals("")){
					deliveryDetails.setGestation(box.getString("termOfGestation"));
				}
				if(!box.getString("durationOfDelivery").equals("")){
					deliveryDetails.setDeliveryDuration(box.getString("durationOfDelivery"));
				}
				if(!box.getString("stageThree").equals("")){
					deliveryDetails.setStageThree(box.getString("stageThree"));
				}
				if(!box.getString("episiotomy").equals("")){
					deliveryDetails.setEpisiotomy(box.getString("episiotomy"));
				}
				if(!box.getString("anaesthesia").equals("")){
					deliveryDetails.setAnaesthesia(box.getString("anaesthesia"));
				}
				if(!box.getString("perinealTears").equals("")){
					deliveryDetails.setPerinealTears(box.getString("perinealTears"));
				}
				if(!box.getString("placentaAndMembranes").equals("")){
					deliveryDetails.setPlacenta(box.getString("placentaAndMembranes"));
				}
				if(!box.getString("bleeding").equals("")){
					deliveryDetails.setBleeding(box.getString("bleeding"));
				}
				if(!box.getString("bloodTransfusion").equals("")){
					deliveryDetails.setBloodTransfusion(box.getString("bloodTransfusion"));
				}
				if(!box.getString("sutureMaterial").equals("")){
					deliveryDetails.setSutureMaterial(box.getString("sutureMaterial"));
				}
				if(!box.getString("stateOfUterus").equals("")){
					deliveryDetails.setStateOfUterus(box.getString("stateOfUterus"));
				}
				if(!box.getString("lactation").equals("")){
					deliveryDetails.setLactation(box.getString("lactation"));
				}
				if(!box.getString("stageComplications").equals("")){
					deliveryDetails.setStageFiveComplications(box.getString("stageComplications"));
				}
				if(!box.getString("otherRemarks").equals("")){
					deliveryDetails.setOtherRemarks(box.getString("otherRemarks"));
				}
				

				/*deliveryDetails.setBloodLoss(bloodLoss);
				deliveryDetails.setPlacenta(placenta);
				deliveryDetails.setTreatment(treatment);
				deliveryDetails.setDateOfLabor(dateOnSet);
				deliveryDetails.setTimeOfLabor(timeOnSet);
				deliveryDetails.setPuperium(purperium);
				deliveryDetails.setMothersCondition(motherCondition);
				deliveryDetails.setPulse(pulse);
				deliveryDetails.setPerinum(perineum);
				deliveryDetails.setBp(bP+"/"+bp2);
				deliveryDetails.setAdditionalNotes(additionalNotes);
				deliveryDetails.setComplications(complications);*/
				List<Patient>ptList=new ArrayList<Patient>();
				ptList=session.createCriteria(Patient.class).add(Restrictions.eq("Id",hinId)).list();
				for(Patient pt:ptList){
					motherHinNo=pt.getHinNo();
					babyOfMotherName = pt.getPFirstName();
					if(pt.getBplStatus() != null){
					bplStatus = (String)pt.getBplStatus();
					}
					if(pt.getNotionalDobStatus() != null){
						nationalDobStatus = (String)pt.getNotionalDobStatus();
					}
					if(pt.getPatientType() != null && pt.getPatientType().getId() != null){
						patientTypeId = (Integer)pt.getPatientType().getId();
					}
					//Added by Arbind on 20-03-2017
					Patient motherPatient = null;
					motherPatient = (Patient) session.load(Patient.class, pt.getId());
					if(motherPatient!=null){
						if(box.getInt("bloodGroup") != 0){
							MasBloodGroup bloodGroupId = new MasBloodGroup();
							bloodGroupId.setId(box.getInt("bloodGroup"));
							motherPatient.setBloodGroup(bloodGroupId);
						}
						hbt.update(motherPatient);
					}
				}
				hbt.save(deliveryDetails);
	//---------------------------for generate hin no -----------------------------			
				List<Patient>hinList=new ArrayList<Patient>();
				int memberId=0;
				hinList=session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinId)).list();
				for(Patient pt:hinList){
					motherHinNo=pt.getHinNo();
					if(pt.getMember()!=null){
					memberId=pt.getMember().getId();
					}
				}
				
				
				
				for(int i=1;i<=count;i++){
//-------------------------	generate temporary registration of baby------------------------	
					
					birthList=session.createCriteria(BabyDetails.class).list();
					
					if(birthList.size()>0){
						babyno=birthList.get((birthList.size()-1)).getBabyNo();
						babyno=babyno+1;
						birthcertificateno=Integer.parseInt(birthList.get((birthList.size()-1)).getBirthCertificationNo());
						birthcertificateno=birthcertificateno+1;
					}else{
						babyno=1;
						birthcertificateno=1;
					}
					
					Patient babyPatient = new Patient();
					babyPatient.setNewBornBaby("y");
					babyPatient.setPatientStatus("Out Patient");
					
					masHospital.setId(hospitalId);
					babyPatient.setHospital(masHospital);

					
					String hinNo="";
				
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

				
					if(currentDate.compareTo(lastChangedate)>0){
						tsn=0;
					TransactionSequence transactionSequenceObj = (TransactionSequence) session
							.load(TransactionSequence.class, id);
					transactionSequenceObj.setTransactionSequenceNumber(1);
					transactionSequenceObj.setLastChgDate(date);
					hbt.update(transactionSequenceObj);
					
					
					}
					else{
						TransactionSequence transactionSequenceObj = (TransactionSequence) session
								.load(TransactionSequence.class, id);
						transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
						transactionSequenceObj.setLastChgDate(currentDate);
						hbt.update(transactionSequenceObj);
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
					
					
					hinNo = generateTemporaryRegNum(hinNo, hospitalId);
					babyPatient.setHinNo(hinNo);
					
					/** for admission of babies **/
					if(!babyHin.equals("")){
						babyHin = babyHin+", "+hinNo;
					}else{
						babyHin = hinNo;
					}
					
					
					Date addEditDate = null;
					addEditDate = HMSUtil.convertStringTypeDateToDateType(currentDated);
					babyPatient.setAddEditDate(addEditDate);
					babyPatient.setRegDate(addEditDate);
					babyPatient.setAddEditTime(time);
					babyPatient.setRegTime(time);
					Calendar calendar =Calendar.getInstance();
					babyPatient.setYearOfBirth(""+calendar.get(Calendar.YEAR));
				
					if (box.getInt("userId") != 0) {
						Users users = new Users();
						users.setId(box.getInt("userId"));
						babyPatient.setAddEditBy(users);
					}
				
					if (box.getInt("sexOfBaby"+i) !=0) {
						MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
						masAdministrativeSex.setId(box.getInt("sexOfBaby"+i));
						babyPatient.setSex(masAdministrativeSex);
					}
					
					if (babyOfMotherName != null) {
						babyPatient.setPFirstName("Baby"+i+" Of "+babyOfMotherName);
					}
					
					if (bplStatus != null) {
						babyPatient.setBplStatus(bplStatus);
					}
					
					if (nationalDobStatus != null) {
						babyPatient.setNotionalDobStatus(nationalDobStatus);
					}
					
					if (motherHinNo != null) {
						babyPatient.setMotherHinNo(motherHinNo);
					}
					
					if (patientTypeId!= 0) {
					MasPatientType patientType = new MasPatientType();
					patientType.setId(patientTypeId);
					babyPatient.setPatientType(patientType);
					}
					
					Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
					int relationId=0;
					try {
						properties.load(resourcePath.openStream());

						String relationIdForMother = properties.getProperty("relationIdForMother");
						logger.info("relationIdForMother"+relationIdForMother);
						relationId=Integer.parseInt(relationIdForMother);
					} catch (Exception e) {
						e.printStackTrace();
					}

					MasRelation r = new MasRelation();
					r.setId(relationId);
					babyPatient.setRelation(r);
					
					
					if(!box.getString("birthDate"+i).equals("")){
						babyPatient.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
					}
					int days =HMSUtil.getNoOfDays(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)), currentDate);
					
					if(days != 0){
					babyPatient.setAge(days+" days");
					}else{
						babyPatient.setAge((days+1) +" days");
					}
					babyPatient.setStatus("y");

					//Added by Arbind on 20-03-2017
					if(box.getInt("bloodGroup"+i) != 0){
						MasBloodGroup bloodGroupId = new MasBloodGroup();
						bloodGroupId.setId(box.getInt("bloodGroup"+i));
						babyPatient.setBloodGroup(bloodGroupId);
					}
					//babyPatient.setMotherHinNo(motherHinNo);
					hbt.save(babyPatient);
					babyHinId=babyPatient.getId();
					
					
					BabyDetails babyDetails = new BabyDetails();
					
					if(box.getInt("babyNo"+i) !=0){
						babyDetails.setBabyNo(box.getInt("babyNo"+i));
					}
					babyDetails.setBabyHin(babyPatient);
					babyDetails.setBirthCertificationNo(""+birthcertificateno);
					if(!box.getString("birthDate"+i).equals("")){
						babyDetails.setBirthCertificationDate(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
						}
					inpatient.setId(inpatientId);
					babyDetails.setInpatient(inpatient);
					
					
					
					if(box.getInt("sexOfBaby"+i) !=0){
						MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
						administrativeSex.setId(box.getInt("sexOfBaby"+i));
						babyDetails.setSex(administrativeSex);
					}
					if(!box.getString("live"+i).equals("")){
						babyDetails.setLiveStillBorn(box.getString("live"+i));
					}
					
					if(!box.getString("birthWeight"+i).equals("")){
						babyDetails.setWeight(box.getString("birthWeight"+i));
					}
					
					if(!box.getString("timeOfDelivery"+i).equals("")){
						babyDetails.setTimeOfBirth(box.getString("timeOfDelivery"+i));
					}
					if(!box.getString("birthDate"+i).equals("")){
						babyDetails.setDateOfBirth(HMSUtil.convertStringTypeDateToDateType(box.getString("birthDate"+i)));
					}
					
					if(box.getInt("typeOfDelivery"+i) !=0){
						MasDeliveryType masDeliveryType = new MasDeliveryType();
						masDeliveryType.setId(box.getInt("typeOfDelivery"+i));
						babyDetails.setDeliveryType(masDeliveryType);
					}
					if(!box.getString("presentation"+i).equals("")){
						babyDetails.setPresentation(box.getString("presentation"+i));
					}
					
					if(!box.getString("babyCry"+i).equals("")){
						babyDetails.setBabyCry(box.getString("babyCry"+i));
					}
					if(box.getInt("apgarAtone"+i) !=0){
						babyDetails.setApgarAt1(box.getInt("apgarAtone"+i));
					}
					if(box.getInt("apgarAtFive"+i) !=0){
						babyDetails.setApgarAt5(box.getInt("apgarAtFive"+i));
					}
					if(!box.getString("complications"+i).equals("")){
						babyDetails.setComplications(box.getString("complications"+i));
					}
					if(!box.getString("anomalies"+i).equals("")){
						babyDetails.setAnomalies(box.getString("anomalies"+i));
					}
					if(!box.getString("babyFeeding"+i).equals("")){
						babyDetails.setBabyFeeding(box.getString("babyFeeding"+i));
					}
					
					babyDetails.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDated));
					babyDetails.setLastChgTime(time);
					
					if (box.getInt("userId") != 0) {
						Users users = new Users();
						users.setId(box.getInt("userId"));
						babyDetails.setLastChgBy(users);
					}
					masHospital.setId(hospitalId);
					babyDetails.setHospital(masHospital);
					hbt.save(babyDetails);
		//---------------------------------data save in PHAlert Table--------------------------------------			
					PhAlert phAlert=new PhAlert();
					if(memberId!=0){
					PhMemberSurvey pms=new PhMemberSurvey();
					pms.setId(memberId);
					phAlert.setMember(pms);
					
					List<PhMemberSurvey>phSurveyDetails=new ArrayList<PhMemberSurvey>();
					phSurveyDetails=session.createCriteria(PhMemberSurvey.class).add(Restrictions.eq("Id", memberId)).list();
					int hospitalIdForphSrvey=0;
					for(PhMemberSurvey PhMemberSurvey:phSurveyDetails){
						hospitalIdForphSrvey=PhMemberSurvey.getHospital().getId();
					}
					phAlert.setHin(babyPatient);
					
					phAlert.setAlertType("Birth");
					if(hospitalIdForphSrvey!=0){
					MasHospital hospitalForAlert=new MasHospital();
					hospitalForAlert.setId(hospitalIdForphSrvey);
					phAlert.setHospital(hospitalForAlert);
					}
					hbt.save(phAlert);
					}
					
				}
				
			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			babyHin = "";
			saved = false;
			e.printStackTrace();
			tx.rollback();
		}
		String msg = "";
		if (saved) {
			if (duplicate) {
				msg = "Data Duplicate";
			} else {
				msg = "Mother Details Added Successfully";
			}
		} else {
			msg = "Data can not Saved";
		}
		map.put("msg", msg);
		//map.put("hinNo", hinNo);
		map.put("babyHin", babyHin);
		return map;
	}

	public Map<String, Object> getBabyDetails(Map<String, Object> mapForDs) {

		List<MasCsIndication> masCsIndicationList = new ArrayList<MasCsIndication>();
		List<MasGestation> masGestationList = new ArrayList<MasGestation>();
		List<MasNeonatalProblem> masNeonatalProblemList = new ArrayList<MasNeonatalProblem>();
		List<MasBabyStatus> masBabyStatusList = new ArrayList<MasBabyStatus>();
		List<MasDeliveryType> masDeliveryTypeList = new ArrayList<MasDeliveryType>();
		List<BabyDetails> babyDetailsList = new ArrayList<BabyDetails>();
		List<BabyDetails> birthList = new ArrayList<BabyDetails>();
		List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>();

		int  babyno=1;
		int  birthcertificateno=1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			birthList=session.createCriteria(BabyDetails.class).list();
			
			if(birthList.size()>0){
				babyno=birthList.get((birthList.size()-1)).getBabyNo();
				babyno=babyno+1;
				birthcertificateno=Integer.parseInt(birthList.get((birthList.size()-1)).getBirthCertificationNo());
				birthcertificateno=birthcertificateno+1;
			}else{
				babyno=1;
				birthcertificateno=1;
			}
			masCsIndicationList = session.createCriteria(MasCsIndication.class)
					.list();
			masGestationList = session.createCriteria(MasGestation.class)
					.list();
			masNeonatalProblemList = session.createCriteria(
					MasNeonatalProblem.class).list();
			masBabyStatusList = session.createCriteria(MasBabyStatus.class)
					.list();
			masDeliveryTypeList = session.createCriteria(MasDeliveryType.class)
					.list();
			masAdministrativeSexList = session.createCriteria(MasAdministrativeSex.class)
					.list();
			
			map.put("babyno", babyno);
			map.put("birthcertificateno", birthcertificateno);
			map.put("masCsIndicationList", masCsIndicationList);
			map.put("masGestationList", masGestationList);
			map.put("masNeonatalProblemList", masNeonatalProblemList);
			map.put("masBabyStatusList", masBabyStatusList);
			map.put("masDeliveryTypeList", masDeliveryTypeList);
			map.put("masAdministrativeSexList", masAdministrativeSexList);
			
			} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> addBabyDetails(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		int deliveryType = 0;
		int babyNo = 0;
		Date dateOfBirth = new Date();
		String timeOfBirth = "";
		String birthCertificationNo = "";
		Date birthCertificationDate = new Date();
		int babySex = 0;
		int csIndication = 0;
		int gestation = 0;
		double headCircumferance = 0.0;
		String csNo = "";
		String gestationAge = "";
		double lenght = 0.0;
		double apgarScore = 0.0;
		String estGestAge = "";
		String weight = "";
		int neonatalProblems = 0;
		int babyStatus = 0;
		String outCome = "";
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDated = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String curDate=sdf.format(date);
		Date currentDate = null;
		try {
			currentDate = sdf.parse(curDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String motherHinNo="";
		
		int tsn = 0;
		int id = 0;
		String hinNo = "";
		String hin_name = "";
		int hinId = 0;
		boolean addressStatus = false;
		Date lastChangedate=null;
		Session session = (Session) getSession();
		int hospitalId=0;
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("motherHinNo") != null) {
			motherHinNo = (String) mapForDs.get("motherHinNo");
		}
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		int userId = 0;
		if (mapForDs.get("deliveryType") != null) {
			deliveryType = (Integer) mapForDs.get("deliveryType");
		}
		if (mapForDs.get("babyNo") != null) {
			babyNo = (Integer) mapForDs.get("babyNo");
		}
		if (mapForDs.get("dateOfBirth") != null) {
			dateOfBirth = (Date) mapForDs.get("dateOfBirth");
		}
		if (mapForDs.get("timeOfBirth") != null) {
			timeOfBirth = (String) mapForDs.get("timeOfBirth");
		}
		if (mapForDs.get("birthCertificationNo") != null) {
			birthCertificationNo = (String) mapForDs
					.get("birthCertificationNo");
		}
		if (mapForDs.get("birthCertificationDate") != null) {
			birthCertificationDate = (Date) mapForDs
					.get("birthCertificationDate");
		}
		if (mapForDs.get("babySex") != null) {
			babySex = (Integer) mapForDs.get("babySex");
		}
		if (mapForDs.get("csIndication") != null) {
			csIndication = (Integer) mapForDs.get("csIndication");
		}
		if (mapForDs.get("gestation") != null) {
			gestation = (Integer) mapForDs.get("gestation");
		}
		if (mapForDs.get("headCircumferance") != null) {
			headCircumferance = (Double) mapForDs.get("headCircumferance");
		}
		if (mapForDs.get("csNo") != null) {
			csNo = (String) mapForDs.get("csNo");
		}
		if (mapForDs.get("gestationAge") != null) {
			gestationAge = (String) mapForDs.get("gestationAge");
		}
		if (mapForDs.get("lenght") != null) {
			lenght = (Double) mapForDs.get("lenght");
		}
		if (mapForDs.get("apgarScore") != null) {
			apgarScore = (Double) mapForDs.get("apgarScore");
		}
		if (mapForDs.get("estGestAge") != null) {
			estGestAge = (String) mapForDs.get("estGestAge");
		}
		if (mapForDs.get("weight") != null) {
			weight = (String) mapForDs.get("weight");
		}
		if (mapForDs.get("neonatalProblems") != null) {
			neonatalProblems = (Integer) mapForDs.get("neonatalProblems");
		}
		if (mapForDs.get("babyStatus") != null) {
			babyStatus = (Integer) mapForDs.get("babyStatus");
		}
		if (mapForDs.get("outCome") != null) {
			outCome = (String) mapForDs.get("outCome");
		}
		int inpatientId=0;
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		int hinIdMother=0;
		if (mapForDs.get("hinIdMother") != null) {
			hinIdMother = (Integer) mapForDs.get("hinIdMother");
		}
		
		int babyOfHinNo=0;
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<Patient>hinList=new ArrayList<Patient>();
			int memberId=0;
			hinList=session.createCriteria(Patient.class).add(Restrictions.eq("Id", hinIdMother)).list();
			for(Patient pt:hinList){
				motherHinNo=pt.getHinNo();
				if(pt.getMember()!=null){
				memberId=pt.getMember().getId();
				}
			}
			
			{
				List<Object[]> adList = session
						.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "HIN"))
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

			}
			if(currentDate.compareTo(lastChangedate)>0){
				tsn=0;
			TransactionSequence transactionSequenceObj = (TransactionSequence) session
					.load(TransactionSequence.class, id);
			transactionSequenceObj.setTransactionSequenceNumber(1);
			transactionSequenceObj.setLastChgDate(date);
			hbt.update(transactionSequenceObj);
			
			
			}
			else{
				TransactionSequence transactionSequenceObj = (TransactionSequence) session
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(tsn+1);
				//transactionSequenceObj.setLastChgDate(currentDate);
				hbt.update(transactionSequenceObj);
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
			
			
		Patient patient = new Patient();
		patient.setNewBornBaby("y");
		patient.setPatientStatus("In Patient");

		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		patient.setHospital(masHospital);

		
		hinNo = generateTemporaryRegNum(hinNo, hospitalId);
		patient.setHinNo(hinNo);

		Date addEditDate = null;
		addEditDate = HMSUtil.convertStringTypeDateToDateType(currentDated);
		patient.setAddEditDate(addEditDate);
		patient.setRegDate(addEditDate);
		String addEditTime = "";
		if (mapForDs.get("addEditTime") != null) {
			addEditTime = (String) mapForDs.get("addEditTime");
			patient.setAddEditTime(addEditTime);
			patient.setRegTime(addEditTime);
		}
		if (mapForDs.get("userId") != null) {
			userId = (Integer) mapForDs.get("userId");
			Users users = new Users();
			users.setId(userId);
			patient.setAddEditBy(users);
		}
		
	
		
		if (babySex != 0) {
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(babySex);
			patient.setSex(masAdministrativeSex);
		}
		String babyOfMotherName="";
		if (mapForDs.get("babyOfMotherName") != null) {
			babyOfMotherName = (String) mapForDs.get("babyOfMotherName");
		patient.setPFirstName("Baby Of "+babyOfMotherName);
		}
		
		
		String bplStatus="";
		if (mapForDs.get("bplStatus") != null) {
			bplStatus = (String) mapForDs.get("bplStatus");
		patient.setBplStatus(bplStatus);
		}
		String nationalDobStatus="";
		if (mapForDs.get("nationalDobStatus") != null) {
			nationalDobStatus = (String) mapForDs.get("nationalDobStatus");
		patient.setNotionalDobStatus(nationalDobStatus);
		}
		String hiNumber="";
		if (mapForDs.get("hiNumber") != null) {
			hiNumber = (String) mapForDs.get("hiNumber");
		patient.setMotherHinNo(hiNumber);
		}
		int patientTypeId=0;
		if (mapForDs.get("patientTypeId") != null) {
			patientTypeId = (Integer) mapForDs.get("patientTypeId");
		}
		if (patientTypeId!= 0) {
		MasPatientType patientType = new MasPatientType();
		patientType.setId(patientTypeId);
		patient.setPatientType(patientType);
		}
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("adt.properties");
		int relationId=0;
		try {
			properties.load(resourcePath.openStream());

			String relationIdForMother = properties.getProperty("relationIdForMother");
			
			relationId=Integer.parseInt(relationIdForMother);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MasRelation r = new MasRelation();
		r.setId(relationId);
		patient.setRelation(r);
		
		patient.setDateOfBirth(dateOfBirth);
		patient.setStatus("y");
		
		patient.setMotherHinNo(motherHinNo);
		hbt.save(patient);
		hinId=patient.getId();
		
		
		BabyDetails babyDetails = new BabyDetails();

		if (deliveryType != 0) {
			MasDeliveryType masDeliveryType = new MasDeliveryType();
			masDeliveryType.setId(deliveryType);
			babyDetails.setDeliveryType(masDeliveryType);
		}
		
		babyDetails.setBabyHin(patient);
		
		babyDetails.setBabyNo(babyNo);
		babyDetails.setDateOfBirth(dateOfBirth);
		babyDetails.setTimeOfBirth(timeOfBirth);
		babyDetails.setBirthCertificationNo(birthCertificationNo);
		babyDetails.setBirthCertificationDate(birthCertificationDate);
		if (babySex != 0) {
			MasAdministrativeSex masAdministrativeSex = new MasAdministrativeSex();
			masAdministrativeSex.setId(babySex);
			babyDetails.setSex(masAdministrativeSex);
		}
		/*if (csIndication != 0) {
			MasCsIndication masCsIndication = new MasCsIndication();
			masCsIndication.setId(csIndication);
			babyDetails.setCsIndication(masCsIndication);
		}
		if (gestation != 0) {
			MasGestation masGestation = new MasGestation();
			masGestation.setId(gestation);
			babyDetails.setGestation(masGestation);
		}
		babyDetails.setHeadCircumferance(headCircumferance);
		babyDetails.setCsNo(csNo);
		babyDetails.setGestationAge(gestationAge);
		babyDetails.setLength(lenght);
		babyDetails.setApgarScore(apgarScore);
		babyDetails.setEstGestAge(estGestAge);
		babyDetails.setWeight(weight);
		if (neonatalProblems != 0) {
			MasNeonatalProblem masNeonatalProblem = new MasNeonatalProblem();
			masNeonatalProblem.setId(neonatalProblems);
			babyDetails.setMasNeonatalProblem(masNeonatalProblem);
		}
		if (babyStatus != 0) {
			MasBabyStatus masBabyStatus = new MasBabyStatus();
			masBabyStatus.setId(babyStatus);
			babyDetails.setBabyStatus(masBabyStatus);
		}*/
		babyDetails.setOutcome(outCome);
		babyDetails.setLastChgDate( HMSUtil.convertStringTypeDateToDateType(currentDated));
		babyDetails.setLastChgTime(time);
		
		if (mapForDs.get("userId") != null) {
			userId = (Integer) mapForDs.get("userId");
			Users users = new Users();
			users.setId(userId);
			babyDetails.setLastChgBy(users);
		}

		Inpatient inpatient = new Inpatient();
		inpatient.setId(inpatientId);
		babyDetails.setInpatient(inpatient);
		
		masHospital.setId(hospitalId);
		babyDetails.setHospital(masHospital);

		hbt.save(babyDetails);
		
		/*
		 * Added by ujjwal in the system of Amit
		 */
		
		PhAlert phAlert=new PhAlert();
		if(memberId!=0){
		PhMemberSurvey pms=new PhMemberSurvey();
		pms.setId(memberId);
		phAlert.setMember(pms);
		}
		List<PhMemberSurvey>phSurveyDetails=new ArrayList<PhMemberSurvey>();
		phSurveyDetails=session.createCriteria(PhMemberSurvey.class).add(Restrictions.eq("Id", memberId)).list();
		int hospitalIdForphSrvey=0;
		for(PhMemberSurvey PhMemberSurvey:phSurveyDetails){
			hospitalIdForphSrvey=PhMemberSurvey.getHospital().getId();
		}
		phAlert.setHin(patient);
		
		phAlert.setAlertType("Birth");
		if(hospitalIdForphSrvey!=0){
		MasHospital hospitalForAlert=new MasHospital();
		hospitalForAlert.setId(hospitalIdForphSrvey);
		phAlert.setHospital(hospitalForAlert);
		}
		hbt.save(phAlert);
		// End By Ujjwal
		
		tx.commit();
		
		
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		
		map.put("hinId",hinId);
		return map;

	}
	public Map<String, Object> getPatinetDetails(String hinNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();

		Session session = (Session) getSession();

		try {
			inPatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();

			map.put("inPatientList", inPatientList);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
	
	
	// ---    Vaital View --------------------

	
		@Override
		public Map<String, Object> showViewVitalPopUp(Box box) {

			List<IpdVitalcareDetails> ipdVitalcareDetails = new ArrayList<IpdVitalcareDetails>();
			int nursingCareSetupId = 0;
			List<IpdVitalSetup> ipdVitalSetups=new ArrayList<IpdVitalSetup>();
			List<IpdVitalcareDetails> ipdVitalCareDetailList=new ArrayList<IpdVitalcareDetails>();
		
			Session session = (Session) getSession();
		
			 Map<String ,Object> map= new HashMap<String, Object>();
			 Inpatient inpatient=null;
			    int inpatientId=box.getInt("ipId");
				int hinId = (Integer) box.getInt("hinId");
				int hospitalId = (Integer) box.getInt("hospitalId");
				int userId = (Integer) box.getInt(USER_ID);
				int deptId = (Integer) box.getInt(DEPT_ID);
				Integer maxVitalFrequency=new Integer(0);
			try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				inpatient=(Inpatient) hbt.get(Inpatient.class, inpatientId);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");
		
				
						ipdVitalcareDetails=session.createCriteria(IpdVitalcareDetails.class,"icd")
						.createAlias("icd.VitalHeader", "ich")
						.createAlias("ich.Inpatient", "ip")
						.createAlias("ich.Hospital", "h")
						.add(Restrictions.eq("ip.Id", inpatientId))
						.add(Restrictions.eq("h.Id", hospitalId))
						.add(Restrictions.eq("ich.DateOfCare",HMSUtil.convertStringTypeDateToDateType(date)))
						.list();
						
						ipdVitalSetups = session.createCriteria(
								IpdVitalSetup.class)
								.add(Restrictions.eq("Inpatient.Id", inpatientId))
								.add(Restrictions.eq("Hospital.Id", hospitalId))
								//.add(Restrictions.eq("StopVital", "n").ignoreCase())
								.list();
						
						 maxVitalFrequency=(Integer) session.createCriteria(IpdVitalSetup.class,"ncs")
									.createAlias("ncs.Inpatient", "ip")
									.createAlias("ncs.Hospital", "h")
									.createAlias("ncs.Frequency", "frq")
									.add(Restrictions.eq("ip.Id", inpatientId))
									.add(Restrictions.eq("h.Id", hospitalId))
									//.add(Restrictions.eq("ncs.StopVital", "n").ignoreCase())
									.setProjection(Projections.max("frq.FrequencyCount")).uniqueResult();
						 
						 ipdVitalCareDetailList = session.createCriteria(IpdVitalcareDetails.class).createAlias("VitalHeader", "header")
									.add(Restrictions.eq("header.Inpatient.Id", inpatientId)).add(Restrictions.isNull("CareFrequencyCount"))
										.add(Restrictions.eq("header.Department.Id", deptId)).add(Restrictions.eq("header.Hospital.Id", hospitalId)).list();
							
						
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		

		if(maxVitalFrequency!=null)
			map.put("maxVitalFrequency", maxVitalFrequency.intValue());
		
			map.put("ipdVitalSetups", ipdVitalSetups);
			map.put("ipdVitalcareDetails", ipdVitalcareDetails);
			map.put("ipdVitalCareDetailList", ipdVitalCareDetailList);
			
			return map;
		}
		// *************************** BIRTH CERTIFICATE
		// ***************************************
		public Map<String, Object> showBirthCertificateJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Birthdeathreg> searchBirthList = new ArrayList<Birthdeathreg>();
			//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			List<Birthdeathreg> birthList = new ArrayList<Birthdeathreg>();
			int birthNo=0;
			Session session = (Session) getSession();
			try{
			//searchBirthList = session.createQuery("from jkt.hms.masters.business.Birthdeathreg ").list();
			//birthList = session.createQuery("from Birthdeathreg as bdr where bdr.Bdtype='b' order by bdr.Id desc").list();
			//
			searchBirthList=session.createCriteria(Birthdeathreg.class).list();
			birthList=session.createCriteria(Birthdeathreg.class,"bdr")
					.add(Restrictions.eq("bdr.Bdtype", "b")).list();
			//System.out.println("birthList>>>>>"+birthList.size());
			//System.out.println("searchBirthList>>>>>"+searchBirthList.size());
			if(birthList.size()>0){
				birthNo=birthList.get((birthList.size()-1)).getBirthCertificateNo();
				birthNo=birthNo+1;
			}else{
				birthNo=1;
			}
			
			logger.info("birth no:" +birthNo);
			/*employeeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasEmployee ");*/
	/*
			List<Patient> patientList=new ArrayList<Patient>();
			//patientList=getHibernateTemplate().find("from jkt.hms.masters.business.Patient");
			Session session = (Session) getSession();
			//patientList=session.createCriteria(Patient.class).setFirstResult(30000).setMaxResults(50000).list();
			patientList=session.createCriteria(Patient.class).add(Restrictions.between("Id", 150000, 200001)).list();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if(patientList.size()>0){
				for (Patient patient : patientList) {
					String address="";
					String addressForSet="";
					if(patient.getAddress()!=null){
						address=patient.getAddress();
						int ascciiValue=0;

						for (int i=0; i<address.length();i++){
							ascciiValue=(int)address.charAt(i);
							if(ascciiValue==13){
								//addressForSet="";
								addressForSet=""+(char)20;
							}else{
								addressForSet=""+(char)ascciiValue;
							}
						}
						Patient patient2=(Patient)session.load(Patient.class, patient.getId());
						patient2.setAddress(addressForSet);
						session.saveOrUpdate(patient2);
					}

				}
			}*/
			}catch (Exception e) {
				e.printStackTrace();
			}//finally{
				/**
				 * session.close() is done By Mukesh Narayan Singh
				 * Date 28 Sep 2010
				 */
			/*	if(session!=null){
					session.close();
				}
			}*/
			//map.put("employeeList", employeeList);
			map.put("searchBirthList", searchBirthList);
			map.put("birthNo", birthNo);
			return map;
		}

		public Map<String, Object> addBirthCertificate(
				Map<String, Object> generalMap) {
			List<Birthdeathreg> birthList = new ArrayList<Birthdeathreg>();
			Map<String, Object> map = new HashMap<String, Object>();
			String isRecordAlreadyExists = "";
			Session session = (Session) getSession();
			/*org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");*/
			Date dob = new Date();
			Date dor = new Date();
			int sexId = (Integer) generalMap.get("sexId");
			int employeeId = (Integer) generalMap.get("employeeId");
			int hospitalId = (Integer) generalMap.get("hospitalId");
			int usersid = (Integer) generalMap.get("user");
			String lastChgDate = (String) generalMap.get("lastChgDate");
			String lastChgTime = (String) generalMap.get("lastChgTime");
			String patientName = (String) generalMap.get("patientName");
			String birthCirtificateNo1 = (String) generalMap.get("birthCirtificateNo");
			dob = (Date) generalMap.get("dob");
			dor = (Date) generalMap.get("dor");
			int hintId=(Integer) generalMap.get("hintId");
			int birthCertificateNo=0; 
			int inpatientId = 0;
			inpatientId = (Integer) generalMap.get("inpatientId");
			  
			String regNo = "";
			 
			String motherName = "";
			String fatherName = ""; 
			String gender = "";
			Date currentDate = new Date();
			String currentTime = "";  
			String hintNo = "";
			
			int noOfCopies = 0;
			int amount = 0; 
			int serNo = 0;
			String time = "";
			String messageType = "";
			if (generalMap.get("serNo") != null) {
				serNo = Integer.parseInt("" + generalMap.get("serNo"));
			}
			if (generalMap.get("time") != null) {
				time = ("" + generalMap.get("time"));
			}
			try {
				/*birthList = session.createQuery("from Birthdeathreg as ip where ip.Inpatient.Id='"
						+ inpatientId + "' and ip.Bdtype='b'").list();*/
				birthList=session.createCriteria(Birthdeathreg.class,"ip")
						.add(Restrictions.eq("ip.Inpatient.Id", inpatientId ))
						.add(Restrictions.eq("ip.Bdtype", "b")).list();
				 		 
				Transaction transaction = null;
				if (birthList.size() == 0) {
				inpatientId = (Integer) generalMap.get("inpatientId");
				//noOfCopies = (Integer) generalMap.get("noOfCopies");
			//	amount = (Integer) generalMap.get("amount");
				
				motherName = (String) generalMap.get("motherName");
				fatherName = (String) generalMap.get("fatherName");
				currentTime = (String) generalMap.get("currentTime");
				currentDate = (Date) generalMap.get("currentDate");
				//lastChgBy = (String) generalMap.get("lastChgBy");
			
				gender = (String) generalMap.get("gender");
				regNo = (String) generalMap.get("regNo");
				logger.info("reg no : "+regNo);
				hintNo = (String) generalMap.get("hintNo");
		 

					 
					try {
						transaction = session.beginTransaction();
						org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_AUTO");
						hbt.setCheckWriteOperations(false);
						/*hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						*/
						List<Birthdeathreg> tempBirthDeathList=new ArrayList<Birthdeathreg>();
						//tempBirthDeathList = session.createQuery("from Birthdeathreg as bdr where bdr.Bdtype='d' order by bdr.Id desc").list();
						tempBirthDeathList=session.createCriteria(Birthdeathreg.class,"bdr")
								.add(Restrictions.eq("bdr.Bdtype", "b")).list();
						if(tempBirthDeathList.size()>0){
							birthCertificateNo=tempBirthDeathList.get(tempBirthDeathList.size()-1).getBirthCertificateNo();
							birthCertificateNo=birthCertificateNo+1;
						}else{
							birthCertificateNo=1;
						}
						Birthdeathreg birthdeathreg = new Birthdeathreg();
						if(generalMap.get("birthdeathreg")!=null){
							birthdeathreg = (Birthdeathreg)generalMap.get("birthdeathreg");
						}
						birthdeathreg.setBdtype("b");
					birthdeathreg.setDob(dob);
					birthdeathreg.setDor(dor);
					birthdeathreg.setName(patientName);
					birthdeathreg.setFname(fatherName);
					birthdeathreg.setMname(motherName);
					birthdeathreg.setRegno(regNo);
					//System.out.println("aaaaa : "+lastChgBy);
					Users users = new Users();
					users.setId(usersid);
					
					birthdeathreg.setLastChgBy(users);
					birthdeathreg.setLastChgDate(currentDate);
					birthdeathreg.setLastChgTime(currentTime);
					birthdeathreg.setAmount(amount);
					birthdeathreg.setNoOfCopies(noOfCopies);
					birthdeathreg.setTime(time);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					birthdeathreg.setHospital(masHospital);
					if (employeeId != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(employeeId);
						birthdeathreg.setEmp(masEmployee);
					}
					Patient patient = new Patient();
					patient.setHinNo(hintNo);
					birthdeathreg.setHin(patient);

					Patient patient1 = new Patient();
					patient1.setId(hintId);
					birthdeathreg.setHin(patient1);

					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					birthdeathreg.setInpatient(inpatient);
					
					if(sexId!=0){
					MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
					masAdministrativeSex1.setId(sexId);
					birthdeathreg.setAdministrativeSex(masAdministrativeSex1);}
						 
						birthdeathreg.setBirthCertificateNo(birthCertificateNo);
						birthdeathreg.setRegno(""+birthCertificateNo);
						logger.info("birthCertificateNo : "+birthCertificateNo);
						hbt.save(birthdeathreg);
						hbt.flush();
						hbt.clear();
						// don't delete , this is for Birth certificate auto generation
						// TransactionSequence transactionSequence
						// =(TransactionSequence) hbt.load(TransactionSequence.class,
						// 7);
						// transactionSequence.setTransactionSequenceNumber(serNo);
						// hbt.update(transactionSequence);
						transaction.commit();
					} catch (Exception e) {
						if (transaction != null) {
							transaction.rollback();
						}
						isRecordAlreadyExists = "Some problem Occured! Try Again.";
						messageType = "failure";
						e.printStackTrace();
					}
					isRecordAlreadyExists = "Information saved Successfully. Birth Certificate No is <"+birthCertificateNo+" > Do you want to print Birth Certificate?";
					messageType = "success";
					map.put("birthList", birthList);


				} else {
					messageType = "failure";
					isRecordAlreadyExists = "Birth Certificate Already Exists.Do you want to print Birth Certificate?";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}//finally{
				/**
				 * session.close() is done By Mukesh Narayan Singh
				 * Date 28 Sep 2010
				 */
				/*if(session!=null){
					session.close();
				}
			}*/
			map.put("isRecordAlreadyExists", isRecordAlreadyExists);
			map.put("messageType", messageType);
			return map;
		}

		
		@SuppressWarnings("unchecked")
		public Map<String, Object> showBirth(int inpatientId) {
			Session session = (Session) getSession(true);
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object> showList = new ArrayList<Object>();
			List<Patient> motherList = new ArrayList<Patient>();
			List addressList = new ArrayList();
			List<BabyDetails> babyDetailsList = new ArrayList<BabyDetails>();
			List<Patient> fatherList = new ArrayList<Patient>();
			List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
			String motherName = "";
			String fatherName = "";
			Date regDate=null;
			int hinId=0;
			List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
			String hinNo = "";
			String motherHinNo="";
			String timeOfBirth="";
			Date dateOfBirth=null;
			int apgarScore=0;
			String address="";
			String qry="";
			try {

				employeeList = session.createCriteria(MasEmployee.class)
						.add(Restrictions.eq("Status", "y")).list();
				showList = session.createQuery(
						"from jkt.hms.masters.business.Inpatient as ip where ip.Id='"
								+ inpatientId + "'").list();

				if (showList.size() > 0) {
					if (showList != null) {
						int counter = 0;
						Iterator ite = showList.iterator();
						while (ite.hasNext()) {
							Inpatient inpatient = (Inpatient) ite.next();
							//hinNo = inpatient.getHin().getHinNo();
							hinNo = inpatient.getHin().getMotherHinNo();
							hinId = inpatient.getHin().getId();
							counter++;
						}
					}
					
					if(hinId!=0){
						babyDetailsList = session.createQuery(
								"from jkt.hms.masters.business.BabyDetails as ip where  BabyHin.Id="
										+ hinId).list();
					}
					
				
					
					 logger.info(babyDetailsList.size()+"babyDetailsList");
					if (babyDetailsList.size() > 0) {
						for (BabyDetails b : babyDetailsList) {
							timeOfBirth =b.getTimeOfBirth();
							dateOfBirth=b.getDateOfBirth();	
							//apgarScore=	Integer.parseInt(b.getApgarScore());
							
						}
					}
					if (!hinNo.equals("")) {
						motherList = session.createQuery(
								"from Patient where HinNo='" + hinNo + "'").list();
						qry 	=  "select COALESCE(house_no,'') || COALESCE(village_name,'' )|| ' ' || COALESCE(block_name,'') || ' ' ||  COALESCE(district_name,'')  || ' ' || COALESCE(address,'') 	from patient_address pa  left join delivery_details p on p.hin_id=pa.hin_id left join patient pt on p.hin_id=pt.hin_id left join mas_village as mv  on pa.village=mv.village_id left join mas_block as b  on pa.block=b.block_id left join mas_district as d  on pa.district=d.district_id  where pt.hin_no ='" + hinNo + "'and address_type_id=1";
						
						addressList = (List) session.createSQLQuery(qry).list();
						logger.info(addressList.size()+"addressList");
						if(addressList.size()>0)
						{
							if (addressList.get(0) != null) {
								address = addressList.get(0).toString();
								
							}
						}
					}
					/*if (!hinNo.equals("")) {
						motherList = session.createQuery(
								"from Patient where HinNo='" + hinNo
										+ "' and Relation.Id=3").list();
						fatherList =session.createQuery(
								"from Patient where HinNo='" + hinNo
										+ "' and Relation.Id=2").list();
					}*/
					
					
					if (motherList.size() > 0) {
						for (Patient patient : motherList) {
							motherName = patient.getPFirstName();
									regDate=patient.getRegDate();
							
									//+ " "
									//+ patient.getPMiddleName() + " "
								//	+ patient.getPLastName()
									//;
						}
					}
					/*if (fatherList.size() > 0) {
						for (Patient patient2 : fatherList) {
							fatherName = "" + patient2.getPFirstName() + " "
									+ patient2.getPMiddleName() + " "
									+ patient2.getPLastName();
						}
					}*/
					logger.info(motherName+"motherName");
					map.put("regDate", regDate);
					map.put("fatherName", fatherName);
					map.put("motherName", motherName);
					map.put("apgarScore", apgarScore);
					map.put("timeOfBirth", timeOfBirth);
					map.put("dateOfBirth", dateOfBirth);
					map.put("address", address);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}//finally{
				/**
				 * session.close() is done By Mukesh Narayan Singh
				 * Date 28 Sep 2010
				 */
				/*if(session!=null){
					session.close();
				}
			}*/

			map.put("showList", showList);
			map.put("employeeList", employeeList);
			map.put("motherList", motherList);
			map.put("fatherList", fatherList);
			map.put("empAfmsfDetList", empAfmsfDetList);
			return map;
		}
		
		
		@SuppressWarnings("unchecked")
		public List getAdmissionNoHinNoList(Map<String, Object> detailsMap) {
			//String serviceNo = "";
			String hinNo = "";
			/*if (detailsMap.get("serviceNo") != null) {
				serviceNo = (String) detailsMap.get("serviceNo");
			}*/
			if (detailsMap.get("hinNo") != null) {
				hinNo = (String) detailsMap.get("hinNo");
			}
			List<Object> inpatientList = new ArrayList<Object>();

			try {
			/*	if (!serviceNo.equals("")) {
					inpatientList = getHibernateTemplate().find(
							"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
									+ serviceNo + "'");
				}*/
				if (!hinNo.equals("")) {
					/*inpatientList = getHibernateTemplate().find(
							"from Inpatient ip join ip.Hin as p where p.HinNo = '"
									+ hinNo + "'");*/    // commented by amit das on 30-07-2017
					
					inpatientList = getHibernateTemplate().find(
							"from Inpatient ip join ip.Hin as p where p.HinNo = ?", hinNo);
									// added by amit das on 30-07-2017
					
				}
				// inpatientList =
				// session.createCriteria(Inpatient.class).createAlias("Hin",
				// "p").add(Restrictions.eq("p.ServiceNo", serviceNo)).list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return inpatientList;
		}
		
		@SuppressWarnings({ "unused", "unchecked" })
		public List<Object> getMotherHin(String hinNo) {
			Session session = (Session) getSession(true);
			Map<String, Object> map = new HashMap<String, Object>();
			List<Object> motherHinList = new ArrayList<Object>();
			try {
				motherHinList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("hinNo", hinNo)).list();

			} catch (HibernateException e) {
				e.printStackTrace();
			}//finally{
				/**
				 * session.close() is done By Mukesh Narayan Singh
				 * Date 28 Sep 2010
				 */
				/*if(session!=null){
					session.close();
				}
			}*/
			map.put("motherHinList", motherHinList);
			return motherHinList;

		}

		@Override
		public Map<String, Object> getPatientInvestigationList(Map<String, Object> map) {
			int inpatientId=(Integer)map.get("inpatientId");
			Session session = (Session) getSession(true);
			Transaction tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_AUTO");
			hbt.setCheckWriteOperations(false);
			Inpatient inpatient = (Inpatient)hbt.load(Inpatient.class, inpatientId);
		
			/*List<Object[]> invList = new ArrayList<Object[]>();
			
			invList=session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "dgHd")
					.createAlias("dgHd.Inpatient", "inpatient")
					.createAlias("ChargeCode", "chargeCode")
					.setProjection(Projections.projectionList()
								.add(Projections.groupProperty("chargeCode.Id"))
								.add(Projections.groupProperty("chargeCode.ChargeCodeName")))
					.add(Restrictions.eq("inpatient.Id", inpatient.getId()))			
					.list();
			
			map.put("invList", invList);*/
			if(inpatient!=null){
				map.put("inpatient", inpatient);
			}
			List<IpdInvestigationMonitoring> invMontList = new ArrayList<IpdInvestigationMonitoring>();
			
			invMontList = session.createCriteria(IpdInvestigationMonitoring.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
			map.put("invMontList", invMontList);
			return map;
		}

		@Override
		public Map<String, Object> submitInvestigationMonitoring(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session)getSession();
			boolean succesfullyAdded = false;
			Transaction tx = null;
			Map<String, Object> utilMap = new HashMap<String, Object>();

			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);
			
			
			String time = (String) utilMap.get("currentTime");
			
			try {
				tx = session.beginTransaction();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				List<IpdInvestigationMonitoring> invMontList = new ArrayList<IpdInvestigationMonitoring>();
				
				invMontList = session.createCriteria(IpdInvestigationMonitoring.class).add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
						.list();
				if(invMontList.size()>0){
					for(IpdInvestigationMonitoring monitoring : invMontList){
						hbt.delete(monitoring);
					}
				}
				
				
				int count = box.getInt("hiddenValue");
				for(int i=1;i<=count;i++){
					String chargeCodeNameWithId = box.getString("chargeCodeName" + i);
					
					if(!chargeCodeNameWithId.equals("")){
						int index1 = chargeCodeNameWithId.lastIndexOf("[");
						int index2 = chargeCodeNameWithId.lastIndexOf("]");
						index1++;
						int chargeCodeId = Integer.parseInt(chargeCodeNameWithId.substring(index1,index2));

						IpdInvestigationMonitoring ipdInvestigationMonitoring = new IpdInvestigationMonitoring();
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt("inpatientId"));
						ipdInvestigationMonitoring.setInpatient(inpatient);


						MasChargeCode masChargeCode= new MasChargeCode();
						masChargeCode.setId(chargeCodeId);
						ipdInvestigationMonitoring.setChargeCode(masChargeCode);

						MasHospital hospital= new MasHospital();
						hospital.setId(box.getInt("hospitalId"));
						ipdInvestigationMonitoring.setHospital(hospital);

						Users user = new Users();
						user.setId(box.getInt("userId"));
						ipdInvestigationMonitoring.setLastChgBy(user);
						ipdInvestigationMonitoring.setLastChgDate(dateToInsert);
						ipdInvestigationMonitoring.setLastChgTime(time);

						hbt.save(ipdInvestigationMonitoring);
					}
				}
				tx.commit();
				succesfullyAdded = true;
			}catch(Exception e){
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			}
			
			if(succesfullyAdded)
				map.put("message", "Record added successfully.");
			else
				map.put("message", "Try Again!");
			
			return map;
		}

		@Override
		public Map<String, Object> showInvestigationTrend(Map<String, Object> map) {
			List<IpdInvestigationMonitoring> invMontList = new ArrayList<IpdInvestigationMonitoring>();
			int inpatientId=(Integer)map.get("inpatientId");
			Session session = (Session) getSession(true);
			
			List<Inpatient> inpatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
			
		
			invMontList = session.createCriteria(IpdInvestigationMonitoring.class).add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
			map.put("invMontList", invMontList);
			map.put("inpatient", inpatientList.get(0));
			return map;
		}

		@Override
		public Map<String, Object> getInvResultForTrend(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession(true);
		/*	List<DgOrderdt> orderList = new ArrayList<DgOrderdt>();
			orderList = session.createCriteria(DgOrderdt.class).createAlias("Orderhd", "re").add(Restrictions.eq("re.Inpatient.Id", box.getInt("inpatientId")))
					.add(Restrictions.eq("ChargeCode.Id", box.getInt("chargeCodeId"))).list();
			map.put("orderList", orderList);*/
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate"));
			Date toDate = HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"));
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			resultList = session.createCriteria(DgResultEntryHeader.class).add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
					.createAlias("Investigation", "inv").add(Restrictions.between("ResultDate", fromDate, toDate))
					.add(Restrictions.eq("inv.ChargeCode.Id", box.getInt("chargeCodeId"))).list();
			
			map.put("resultList", resultList);
			return map;
		}

	

		@Override
		public Map<String, Object> showPreDialysisChechupJsp(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int hospitalId=box.getInt(HOSPITAL_ID);
			int hin_id=0;
			String uhid="";
			String fname="";
			String age="";
			String gender="";
			int inpatientId=0;
			int depaId=0;
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<OpdNursingPatientDetails> opdNursingPatientDetailsList = new ArrayList<OpdNursingPatientDetails>();
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.idEq(box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if(inpatientList!=null && inpatientList.size()!=0){
				HibernateTemplate hbt = getHibernateTemplate();
				Patient patient =	hbt.load(Patient.class, inpatientList.get(0).getHin().getId());
				hin_id=inpatientList.get(0).getHin().getId();
				uhid=inpatientList.get(0).getHin().getHinNo();
				fname=inpatientList.get(0).getHin().getFullName();
				age=inpatientList.get(0).getHin().getAge();
				gender=inpatientList.get(0).getHin().getSex().getAdministrativeSexName();
				inpatientId=inpatientList.get(0).getId();
				depaId=inpatientList.get(0).getDepartment().getId();
				map.put("uhid", uhid);
				map.put("hin_id", hin_id);
				map.put("patientName", fname);
				map.put("age", age);
				map.put("gender", gender);
				map.put("inpatientId", inpatientId);
				map.put("depaId", depaId);
			}
			opdNursingPatientDetailsList = session.createCriteria(OpdNursingPatientDetails.class)
					.createAlias("Inpatient", "ip")
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("ip.Id", box.getInt("parent")))
					.add(Restrictions.eq("h.Id", hospitalId)).list();
			if(opdNursingPatientDetailsList.size()>0)
			{
				map.put("opdNursingPatientDetailsList", opdNursingPatientDetailsList);
			}
			map.put("inpatientList", inpatientList);
			
			
			
			return map;
		}

	
		@Override
		public Map<String, Object> submitPreConsultationAssessmentDetails(
				Box box) {
			   Map<String, Object> map = new HashMap<String, Object>();
				boolean flag = false;
			   try{
				   
				   Session session = (Session) getSession();
				   Transaction tx=session.beginTransaction();
				   HibernateTemplate hbt = getHibernateTemplate();
				   hbt.setFlushModeName("FLUSH_EAGER");
				   hbt.setCheckWriteOperations(false);
				   OpdNursingPatientDetails opdNursingPatientDetails=new OpdNursingPatientDetails();
				   
				   Map<String,Object> utilMap = new HashMap<String,Object>();
				   utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				   
				   String currentDate = (String)utilMap.get("currentDate");  
				   String currentTime = (String)utilMap.get("currentTime");
				   String consultationDate = (String)utilMap.get("currentDate");
				   String consultationTime = (String)utilMap.get("currentTime");
				   Integer userId = (Integer)utilMap.get("userId");
				   
				    Patient patient=new Patient();
				    int inpatientId=0;
					int visitId =0;
				    int token  =0;
				    int uhid=0;
				    int hin_id=0;

				    String presentComplaintAndHistory="";
				    String historyOfPastIllness="";
				    String personalHistory="";
				    String familyHistory="";
				    String medicationHistory="";
				    
				    int pulse=0;
				    Float temperature=0.0f;
				    int systolicBp=0;
				    int diastolicBp=0;
				    Double weight=0.0;
				    Double height=0.0;
				    int depaId=0;
				    Float bmi=null;
				    int hospitalId=0;
				    int docId=0;
				    
				    if(box.get("docId")!=null && (Integer.parseInt(box.get("docId")))!=0)
				    {
				    	docId =Integer.parseInt(box.get("docId"));
				    }
				    if(box.get("depaId")!=null && (Integer.parseInt(box.get("depaId")))!=0)
				    {
				    	depaId =Integer.parseInt(box.get("depaId"));
				    		opdNursingPatientDetails.setDepartment(new MasDepartment(depaId));
				    }
				    
				    if(box.get("hostpitalId")!=null && !box.get("hostpitalId").equals(""))
				    {
				      hospitalId =Integer.parseInt(box.get("hostpitalId"));
				      map.put("hospitalId", hospitalId);
				      opdNursingPatientDetails.setHospital(new MasHospital(hospitalId));
				    }
				    logger.info(">>>>>>>>>>>visitId >>>>>>>> "+box.get("visitId"));
				    if(box.get("inpatientId")!=null && (Integer.parseInt(box.get("inpatientId")))!=0)
				    {	
				    	inpatientId =Integer.parseInt(box.get("inpatientId"));
				    	Inpatient inpatient = new Inpatient();
				    	inpatient.setId(inpatientId);
				        opdNursingPatientDetails.setInpatient(inpatient);
				    }
				    
				    
				    						
				    /*immediate and urgent shifting process : End*/
			
						    
				
				    
				    if(box.get("presentComplain")!=null)
				    {
				    	presentComplaintAndHistory =box.get("presentComplain");
				    	opdNursingPatientDetails.setPresentComplaintHistory(presentComplaintAndHistory);
				    }
				    if(box.get("pastIllness")!=null)
				    {
				    	historyOfPastIllness =box.get("pastIllness");
				    	opdNursingPatientDetails.setPastIllnessHistory(historyOfPastIllness);
				    }
				    if(box.get("personalHistory")!=null)
				    {
				    	personalHistory =box.get("personalHistory");
				    	opdNursingPatientDetails.setPresentHistory(personalHistory);
				    }
				    if(box.get("familyHistory")!=null)
				    {
				    	familyHistory =box.get("familyHistory");
				    	opdNursingPatientDetails.setFamilyHistory(familyHistory);
				    }
				    
				    if(box.get("medicationhistory")!=null)
				    {
				    	medicationHistory =box.get("medicationhistory");
				    	opdNursingPatientDetails.setMadicationHistory(medicationHistory);
				    }
				    if(box.get("pulse")!=null && !box.get("pulse").equals(""))
				    {
				    	pulse =Integer.parseInt(box.get("pulse"));
				    	opdNursingPatientDetails.setPulse(pulse);
				    	
				    }
				    if(box.get("temperature")!=null && !box.get("temperature").equals(""))
				    {
				    	temperature =Float.valueOf(box.get("temperature"));
				    	opdNursingPatientDetails.setTemperature(temperature);
				    }
				    if(box.get("systolic")!=null && !box.get("systolic").equals("") 
				    		&& box.get("diastolic")!=null && !box.get("diastolic").equals(""))
				    {
				    	systolicBp =Integer.parseInt(box.get("systolic"));
				    	diastolicBp =Integer.parseInt(box.get("diastolic"));
				    	if(systolicBp!=0 && diastolicBp!=0){
				    		String systolic_diastolic=systolicBp+"/"+diastolicBp;
				    		opdNursingPatientDetails.setBp(systolic_diastolic);
					    }
				    }
				    
				    if(box.get("weight")!=null && !box.get("weight").equals(""))
				    {
				    	weight =Double.parseDouble(box.get("weight"));
				    	opdNursingPatientDetails.setWeight(weight);
				    }
				    if(box.get("height")!=null && !box.get("height").equals(""))
				    {
				    	height =Double.parseDouble(box.get("height"));
				    	opdNursingPatientDetails.setHeight(height);
				    }
				    if(box.get("bmi")!=null && !box.get("bmi").equals(""))
				    {
				    	bmi =new Float(box.get("bmi"));
				       	opdNursingPatientDetails.setBmi((bmi));
				    }
				    if(box.get("userId")!=null && !box.get("userId").equals(""))
				    {
				    	opdNursingPatientDetails.setLastChgBy(new Users(userId));
				    }
				    opdNursingPatientDetails.setStatus("Y");
				    opdNursingPatientDetails.setLastChgDate(new Date());
				    opdNursingPatientDetails.setLastChgTime(currentTime);
				    
				
				    hbt.save(opdNursingPatientDetails);
				    tx.commit();
				    flag=true;
				    
			   }catch(Exception exception){
				   exception.printStackTrace();
			   }
			   map.put("flag",flag);
				return map;
			}


		@Override
		public Map<String, Object> showDialysisProcessJsp(Box box) {
			 Map<String, Object> map = new HashMap<String, Object>();
			 List<OpdNursingPatientDetails>opdNursingPatientDetailsList = new ArrayList<OpdNursingPatientDetails>();
			  List<IpdDialysisProcess>ipdDialysisProcessList = new ArrayList<IpdDialysisProcess>();
			  List<IpdVitalcareDetails>ipdVitalCareDetailList = new ArrayList<IpdVitalcareDetails>();
			 Session session = (Session) getSession();
			 Inpatient inpatient = null;
			inpatient=(Inpatient) session.get(Inpatient.class,box.getInt("parent")); 
			logger.info("parent==="+box.getInt("parent"));
			opdNursingPatientDetailsList = session.createCriteria(OpdNursingPatientDetails.class)
					.createAlias("Inpatient", "ip")
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("ip.Id", box.getInt("parent")))
					.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
			ipdDialysisProcessList = session.createCriteria(IpdDialysisProcess.class)
					.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
					.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
			ipdVitalCareDetailList = session.createCriteria(IpdVitalcareDetails.class).createAlias("VitalHeader", "header")
									.add(Restrictions.eq("header.Inpatient.Id", box.getInt("parent"))).add(Restrictions.isNull("CareFrequencyCount"))
										.add(Restrictions.eq("header.Department.Id", box.getInt("deptId"))).add(Restrictions.eq("header.Hospital.Id", box.getInt("hospitalId"))).list();
			map.put("ipdDialysisProcessList",ipdDialysisProcessList);
			map.put("ipdVitalCareDetailList",ipdVitalCareDetailList);
			map.put("inpatient", inpatient);
			map.put("opdNursingPatientDetailsList", opdNursingPatientDetailsList);
			return map;
		}


		@Override
		public Map<String, Object> saveDialysisProcess(Box box) {
			  Map<String, Object> map = new HashMap<String, Object>();
			  List<OpdNursingPatientDetails>opdNursingPatientDetailsList = new ArrayList<OpdNursingPatientDetails>();
			  List<IpdDialysisProcess>ipdDialysisProcessList = new ArrayList<IpdDialysisProcess>();
			  List<IpdVitalcareDetails>ipdVitalCareDetailList = new ArrayList<IpdVitalcareDetails>();
				boolean flag = false;
				 Map<String,Object> utilMap = new HashMap<String,Object>();
				   utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				   String currentDate = (String)utilMap.get("currentDate");  
				   String currentTime = (String)utilMap.get("currentTime");
				   Inpatient inpatient = null;
				   Session session = (Session) getSession();
			   try{
					inpatient=(Inpatient) session.get(Inpatient.class,box.getInt("inpatientId")); 
				   Transaction tx=session.beginTransaction();
				   HibernateTemplate hbt = getHibernateTemplate();
				   hbt.setFlushModeName("FLUSH_EAGER");
				   hbt.setCheckWriteOperations(false);
				   int count = box.getInt("vitalcarecount");
				   
		if(box.getInt("ipdDialysisId")!=0){
			IpdDialysisProcess ipdDialysisProcess=(IpdDialysisProcess)hbt.load(IpdDialysisProcess.class, box.getInt("ipdDialysisId"));
			if(box.getString("startTime") != null){
		    	ipdDialysisProcess.setStartTime(box.getString("startTime"));
		    }
		    if(box.getString("startDate") != null){
		    	ipdDialysisProcess.setStartDate(HMSUtil.convertStringTypeDateToDateType(box.getString("startDate")));
		    }
		    if(box.getString("cramps").equals("y")){
			    if(box.getString("crampsValue") != null){
			    	ipdDialysisProcess.setCramps(box.getString("crampsValue"));
			     }
		    }
		    
		    if(box.getString("vomiting").equals("y")){
			    if(box.getString("vomitingValue") != null){
			    	ipdDialysisProcess.setVomiting(box.getString("vomitingValue"));
			    }	
		    }
		    
		    if(box.getString("chestPain").equals("y")){
			    if(box.getString("chestPainValue") != null){
			    	ipdDialysisProcess.setChestPain(box.getString("chestPainValue"));
			    }
		    }
		    
		    if(box.getString("shivering").equals("y")){
			    if(box.getString("shiveringValue") != null){
			    	ipdDialysisProcess.setShivering(box.getString("shiveringValue"));
			    }	
		    }
		    
		    if(box.getString("fever").equals("y")){
			    if(box.getString("feverValue") != null){
			    	ipdDialysisProcess.setFever(box.getString("feverValue"));
			    }
		    }
		    if(box.getString("otherHealthEvent") != null){
		    	ipdDialysisProcess.setOtherHealthEvent(box.getString("otherHealthEvent"));
		    }
		    if(box.getString("endTime") != null){
		    	ipdDialysisProcess.setEndTime(box.getString("endTime"));
		    }
		    if(box.getString("endDate") != null && !box.getString("endDate").equals("")){
		    	ipdDialysisProcess.setEndDate(HMSUtil.convertStringTypeDateToDateType(box.getString("endDate")));
		    }
		    if(box.getString("endEvent") != null){
		    	ipdDialysisProcess.setEndEvent(box.getString("endEvent"));
		    }
		    hbt.update(ipdDialysisProcess);
		    for(int i=1;i<=count;i++){
		    	
		    	if(!box.getString("vitalName"+i).equals("")){
				IpdVitalSetup ipdVitalSetup = new IpdVitalSetup();
			
				if(box.getString("vitalName"+i) != null){
					ipdVitalSetup.setVitalName(box.getString("vitalName"+i));
				
				if(box.getInt("hinId") != 0){
					Patient patient = new Patient();
					patient.setId(box.getInt("hinId"));
					ipdVitalSetup.setHin(patient);
				}
				if(box.getInt("hospitalId") != 0){
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					ipdVitalSetup.setHospital(masHospital);
				}
				 if(box.getInt("inpatientId")!=0){	
			    	Inpatient ipatient = new Inpatient();
			    	ipatient.setId(box.getInt("inpatientId"));
			    	ipdVitalSetup.setInpatient(ipatient);
			    }
				 if(box.getInt("userId")!=0){	
			    	Users user = new Users();
			    	user.setId(box.getInt("userId"));
			    	ipdVitalSetup.setLastChgBy(user);
			    }
				 ipdVitalSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				 ipdVitalSetup.setLastChgTime(currentTime);
				 hbt.save(ipdVitalSetup);
			 }
			IpdVitalcareHeader ipdVitalcareHeader = new IpdVitalcareHeader();
			if(box.getInt("hinId") != 0){
				Patient patient = new Patient();
				patient.setId(box.getInt("hinId"));
				ipdVitalcareHeader.setHin(patient);
			}
			if(box.getInt("hospitalId") != 0){
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				ipdVitalcareHeader.setHospital(masHospital);
			}
			if(box.getInt("deptId") != 0){
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(box.getInt("deptId"));
				ipdVitalcareHeader.setDepartment(masDepartment);
			}
			 if(box.getInt("inpatientId")!=0){	
		    	Inpatient inpatient2 = new Inpatient();
		    	inpatient2.setId(box.getInt("inpatientId"));
		    	ipdVitalcareHeader.setInpatient(inpatient2);
		    }
			 if(box.getInt("userId")!=0){	
		    	Users user = new Users();
		    	user.setId(box.getInt("userId"));
		    	ipdVitalcareHeader.setLastChgBy(user);
		    }
			 ipdVitalcareHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			 ipdVitalcareHeader.setLastChgTime(currentTime);
			 ipdVitalcareHeader.setVitalSetup(ipdVitalSetup);
			 hbt.save(ipdVitalcareHeader);
			 
			 
			 IpdVitalcareDetails ipdVitalcareDetails = new IpdVitalcareDetails();
			 ipdVitalcareDetails.setCareDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			 ipdVitalcareDetails.setCareTime(currentTime);
			 if(box.getString("vitalName"+i).equalsIgnoreCase("BP")){
				 String dBP = "";
				 String sBP = "";
				 String bpValue = "";
				if(box.getString("dBP"+i)!= null){ 
					dBP = box.getString("dBP"+i);
				}
				if(box.getString("sBP"+i)!= null){ 
					sBP = box.getString("sBP"+i);
				}
				bpValue = sBP+"/"+dBP;
			 ipdVitalcareDetails.setVitalValue(bpValue);
			 }else{
				 ipdVitalcareDetails.setVitalValue(box.getString("vitalValue"+i)); 
			 }
			 ipdVitalcareDetails.setVitalHeader(ipdVitalcareHeader);
			 hbt.save(ipdVitalcareDetails);
	     }
		}	
		
	}else{
				   IpdDialysisProcess ipdDialysisProcess=new IpdDialysisProcess();
				   if(box.getInt("hospitalId")!=0) {
					   MasHospital masHospital = new MasHospital();
					   masHospital.setId(box.getInt("hospitalId"));
				      ipdDialysisProcess.setHospital(masHospital);
				    }
				    if(box.getInt("inpatientId")!=0){	
				    	int inpatientId =box.getInt("inpatientId");
				    	Inpatient ip = new Inpatient();
				    	ip.setId(inpatientId);
				    	ipdDialysisProcess.setInpatient(ip);
				    }
				    if(box.getInt("deptId")!=0){	
				    	MasDepartment masDepartment = new MasDepartment();
				    	masDepartment.setId(box.getInt("deptId"));
				    	ipdDialysisProcess.setDepartment(masDepartment);
				    }
				    if(box.getString("startTime") != null){
				    	ipdDialysisProcess.setStartTime(box.getString("startTime"));
				    }
				    if(box.getString("startDate") != null){
				    	ipdDialysisProcess.setStartDate(HMSUtil.convertStringTypeDateToDateType(box.getString("startDate")));
				    }
				    if(box.getString("cramps").equals("y")){
					    if(box.getString("crampsValue") != null){
					    	ipdDialysisProcess.setCramps(box.getString("crampsValue"));
					     }
				    }
				    
				    if(box.getString("vomiting").equals("y")){
					    if(box.getString("vomitingValue") != null){
					    	ipdDialysisProcess.setVomiting(box.getString("vomitingValue"));
					    }	
				    }
				    
				    if(box.getString("chestPain").equals("y")){
					    if(box.getString("chestPainValue") != null){
					    	ipdDialysisProcess.setChestPain(box.getString("chestPainValue"));
					    }
				    }
				    
				    if(box.getString("shivering").equals("y")){
					    if(box.getString("shiveringValue") != null){
					    	ipdDialysisProcess.setShivering(box.getString("shiveringValue"));
					    }	
				    }
				    
				    if(box.getString("fever").equals("y")){
					    if(box.getString("feverValue") != null){
					    	ipdDialysisProcess.setFever(box.getString("feverValue"));
					    }
				    }
				    if(box.getString("otherHealthEvent") != null){
				    	ipdDialysisProcess.setOtherHealthEvent(box.getString("otherHealthEvent"));
				    }
				    if(box.getInt("userId")!=0){	
				    	Users user = new Users();
				    	user.setId(box.getInt("userId"));
				    	ipdDialysisProcess.setLastChgBy(user);
				    }
				    ipdDialysisProcess.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				    ipdDialysisProcess.setLastChgTime(currentTime);
				    ipdDialysisProcess.setStatus("y");
					 hbt.save(ipdDialysisProcess);
				    //int count = box.getInt("vitalcarecount");
					for(int i=1;i<=count;i++){
						IpdVitalSetup ipdVitalSetup = new IpdVitalSetup();
					
						if(box.getString("vitalName"+i) != null && !box.getString("vitalName"+i).equals("")){
							ipdVitalSetup.setVitalName(box.getString("vitalName"+i));
						
						if(box.getInt("hinId") != 0){
							Patient patient = new Patient();
							patient.setId(box.getInt("hinId"));
							ipdVitalSetup.setHin(patient);
						}
						if(box.getInt("hospitalId") != 0){
							MasHospital masHospital = new MasHospital();
							masHospital.setId(box.getInt("hospitalId"));
							ipdVitalSetup.setHospital(masHospital);
						}
						 if(box.getInt("inpatientId")!=0){	
					    	Inpatient ipatient = new Inpatient();
					    	ipatient.setId(box.getInt("inpatientId"));
					    	ipdVitalSetup.setInpatient(ipatient);
					    }
						 if(box.getInt("userId")!=0){	
					    	Users user = new Users();
					    	user.setId(box.getInt("userId"));
					    	ipdVitalSetup.setLastChgBy(user);
					    }
						 ipdVitalSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
						 ipdVitalSetup.setLastChgTime(currentTime);
						 hbt.save(ipdVitalSetup);
					 }
					IpdVitalcareHeader ipdVitalcareHeader = new IpdVitalcareHeader();
					if(box.getInt("hinId") != 0){
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						ipdVitalcareHeader.setHin(patient);
					}
					if(box.getInt("hospitalId") != 0){
						MasHospital masHospital = new MasHospital();
						masHospital.setId(box.getInt("hospitalId"));
						ipdVitalcareHeader.setHospital(masHospital);
					}
					if(box.getInt("deptId") != 0){
						MasDepartment masDepartment = new MasDepartment();
						masDepartment.setId(box.getInt("deptId"));
						ipdVitalcareHeader.setDepartment(masDepartment);
					}
					 if(box.getInt("inpatientId")!=0){	
				    	Inpatient inpatient2 = new Inpatient();
				    	inpatient2.setId(box.getInt("inpatientId"));
				    	ipdVitalcareHeader.setInpatient(inpatient2);
				    }
					 if(box.getInt("userId")!=0){	
				    	Users user = new Users();
				    	user.setId(box.getInt("userId"));
				    	ipdVitalcareHeader.setLastChgBy(user);
				    }
					 ipdVitalcareHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					 ipdVitalcareHeader.setLastChgTime(currentTime);
					 ipdVitalcareHeader.setVitalSetup(ipdVitalSetup);
					 hbt.save(ipdVitalcareHeader);
					 
					 IpdVitalcareDetails ipdVitalcareDetails = new IpdVitalcareDetails();
					 ipdVitalcareDetails.setCareDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
					 ipdVitalcareDetails.setCareTime(currentTime);
					 if(box.getString("vitalName"+i).equalsIgnoreCase("BP")){
						 String dBP = "";
						 String sBP = "";
						 String bpValue = "";
						if(box.getString("dBP"+i)!= null){ 
							dBP = box.getString("dBP"+i);
						}
						if(box.getString("sBP"+i)!= null){ 
							sBP = box.getString("sBP"+i);
						}
						bpValue = sBP+"/"+dBP;
					 ipdVitalcareDetails.setVitalValue(bpValue);
					 }else{
						 ipdVitalcareDetails.setVitalValue(box.getString("vitalValue"+i)); 
					 }
					 ipdVitalcareDetails.setVitalHeader(ipdVitalcareHeader);
					 hbt.save(ipdVitalcareDetails);
				}
		}
				   tx.commit();
				    flag=true;
				    
			   }catch(Exception exception){
				   exception.printStackTrace();
			   }
			   opdNursingPatientDetailsList = session.createCriteria(OpdNursingPatientDetails.class)
						.createAlias("Inpatient", "ip")
						.createAlias("Hospital", "h")
						.add(Restrictions.eq("ip.Id", box.getInt("inpatientId")))
						.add(Restrictions.eq("h.Id", box.getInt("hospitalId"))).list();
				map.put("opdNursingPatientDetailsList", opdNursingPatientDetailsList);
				ipdDialysisProcessList = session.createCriteria(IpdDialysisProcess.class)
										.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
										.add(Restrictions.eq("Department.Id", box.getInt("deptId"))).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
				ipdVitalCareDetailList = session.createCriteria(IpdVitalcareDetails.class).createAlias("VitalHeader", "header")
											.add(Restrictions.eq("header.Inpatient.Id", box.getInt("inpatientId"))).add(Restrictions.isNull("CareFrequencyCount"))
												.add(Restrictions.eq("header.Department.Id", box.getInt("deptId"))).add(Restrictions.eq("header.Hospital.Id", box.getInt("hospitalId"))).list();
			   map.put("ipdDialysisProcessList",ipdDialysisProcessList);
			   map.put("ipdVitalCareDetailList",ipdVitalCareDetailList);
			   map.put("flag",flag);
			   map.put("inpatient", inpatient);
				return map;
			}

		@Override
		public Map<String, Object> getInvestigationResultForTrend(Box box) {
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession(true);
		
			List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Id", box.getInt("resultId"))).list();
			map.put("resultList", resultList);
			return map;
		}

	

		@Override
		public Map<String, Object> showWardServiceCanCelledJsp(int inpatientId) {
			Session session=(Session)getSession();
			List<Inpatient>ipList=new ArrayList<Inpatient>();
			ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("ipList",ipList);
			return map;
		}

	

		@Override
		public Map<String, Object> showDetailsReferalRecord(Box box) {
			 Map<String, Object> map = new HashMap<String, Object>();
			  String allergyStr="";
			  List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
			  List<PatientPrescriptionDetails>patientPrescriptionDetailsList=new ArrayList<PatientPrescriptionDetails>();
			  List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
			  List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			  List<Inpatient> inpatientMotherList = new ArrayList<Inpatient>();
			  List<OpdPatientDetails> opdDetailsList = new  ArrayList<OpdPatientDetails>(); 
			  List<OpdPatientDetails>  ipdDetailsList = new ArrayList<OpdPatientDetails>();
			  List<PatientPrescriptionHeader> opdPrescriptionList = new  ArrayList<PatientPrescriptionHeader>();
			  List<PatientInvestigationHeader> opdInvestigationList = new  ArrayList<PatientInvestigationHeader>(); 
			   List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>(); 
			  // List<ProcedureHeader>   opdProcedureList = new ArrayList<ProcedureHeader>(); //
//			  List<PhysioRequisitionHeader> opdPhysiotherapyList = new   ArrayList<PhysioRequisitionHeader>();
			  List<OpdPatientHistory>  opdHistoryDetailsListForFollowUp = new  ArrayList<OpdPatientHistory>(); 
//			  List<IpdPatientDiet> ipdPatientDietList= new ArrayList<IpdPatientDiet>();
			  List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
//			  List<PatientFamilyHistory> familyHistoryList = new  ArrayList<PatientFamilyHistory>(); 
			  List<MasIcd> masIcdList = new   ArrayList<MasIcd>(); 
			  List<MasDiet> dietTypeList = new ArrayList<MasDiet>(); 
			  List<OpdPatientDetails> caseSheetList = new   ArrayList<OpdPatientDetails>();
			  List<OpdTemplate> templateList = new   ArrayList<OpdTemplate>();
			  
			  List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
			  List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
			  
			  List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
			 List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
				
			 List<OpdPatientDetails>  ipdPatientDetailList = new ArrayList<OpdPatientDetails>();
			 List<OpdPatientHistory>  ipdPatientHistoryList = new ArrayList<OpdPatientHistory>();
			 List<DischargeIcdCode>  ipdDischargeList = new ArrayList<DischargeIcdCode>();
			 
			 List<InpatientPrescriptionHeader>  ipdPatientPrescriptionHeaderList = new ArrayList<InpatientPrescriptionHeader>();
			 List<PatientInvestigationHeader>  ipdPatientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>(); 
			 List<OpdSurgeryHeader>  ipdOpdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
			 List<OpdPatientAllergyM>  ipdOpdPatientAllergyMList = new ArrayList<OpdPatientAllergyM>();
			 
			List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
			List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
			List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
			
			List<AmbulanceRegister> ambulanceRegistersList=new ArrayList<AmbulanceRegister>();
			
			List<MasDiet> masDietList = new ArrayList<MasDiet>();
			List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<RsbyCardDetails> rsbyCardDetailsList = new ArrayList<RsbyCardDetails>(); // added by Amit Das
			List<MasScheme> packageSchemeList = new ArrayList<MasScheme>(); // added by Amit Das
			List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>(); // added by Amit Das
			List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>(); // added by Amit Das
			 
			String departmentTypeCodeForCanteen=null;
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				Properties prop = new Properties();
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
				departmentTypeCodeForCanteen=prop.getProperty("departmentTypeCodeForCanteen");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int motherInpatientId=0;
			  int deptId=box.getInt(DEPT_ID);
			  int hospitalId=box.getInt(HOSPITAL_ID);
			  int inpatientId=box.getInt("parent");
			  int userId=0;
			  if(box.getInt("userId")!=0){
				  userId=box.getInt("userId");
			  }
			  Session session = (Session)getSession();
			  List<Users>userList=new ArrayList<Users>();
			  userList=session.createCriteria(Users.class).add(Restrictions.idEq(userId)).list();
			  int employeeId=0;
			  for(Users user:userList){
				  employeeId=user.getEmployee().getId();
			  }
			  List<WardRemarks>wardreamarksList=new ArrayList<WardRemarks>();
			  wardreamarksList=session.createCriteria(WardRemarks.class).add(Restrictions.eq("Inpatient.Id", inpatientId))
					  //.add(Restrictions.eq("Doctor.Id", employeeId))
					  .list();
					  
			  
			 // Session session = (Session)getSession();
			  inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("parent"))).list(); 
			  int hinId=  inpatientList.get (0).getHin().getId();
			  String motherHinNo=""; 
			  motherHinNo = inpatientList.get (0).getHin().getMotherHinNo()!=null?inpatientList.get (0).getHin().getMotherHinNo():"";
			  if(motherHinNo!=""){
				  inpatientMotherList =  session.createCriteria(Inpatient.class)
						  .createAlias("Hin", "hin")
						  .add(Restrictions.eq("hin.HinNo", motherHinNo)) 
						  .list();
				  for (Inpatient inp : inpatientMotherList) {
					  	motherInpatientId=  inp.getId();
				  	}
				  
			  }
			  
			  opdDetailsList = session.createCriteria(OpdPatientDetails.class)
					  .createAlias("Visit","v")
					  .createAlias("v.Hin", "hin")
					  .createAlias("Hospital","h")
					  .add(Restrictions.eq("hin.Id", hinId)) 
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					  .addOrder(Order.desc("id"))
					  .setMaxResults(1).list();
			  
			  ipdPatientDetailList =  session.createCriteria(OpdPatientDetails.class)
					  .createAlias("Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", inpatientId))
					  .createAlias("Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					  .addOrder(Order.desc("id"))
					  .setMaxResults(5)
					  .list();
			 
			  
			  if(ipdPatientDetailList.size()>0)
			  {
				  for (OpdPatientDetails details : ipdPatientDetailList) {
					  ipdPatientHistoryList.addAll(session.createCriteria(OpdPatientHistory.class)
							  .createAlias("OpdPatientDetails", "opdetails")
							  .add(Restrictions.eq("opdetails.Id", details.getId()))
							  .createAlias("Hospital","h")
							  .add(Restrictions.eq("h.Id", hospitalId)) 
							  .addOrder(Order.desc("opdetails.Id"))
							  .setMaxResults(5)
							  .list());
					  
					
				}
				  ipdDischargeList.addAll(session.createCriteria(DischargeIcdCode.class)
						  .createAlias("OpdPatientDetails", "opdetails")
						  .add(Restrictions.eq("opdetails.Id", ipdPatientDetailList.get(0).getId()))
						  .createAlias("Hospital","h")
						  .add(Restrictions.eq("h.Id", hospitalId)) 
						  .addOrder(Order.desc("opdetails.Id"))
						  .setMaxResults(5)
						  .list());
			  }
			  ipdPatientPrescriptionHeaderList=session.createCriteria(InpatientPrescriptionHeader.class,"pph")
					  .createAlias("pph.Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", inpatientId))
					  .createAlias("pph.Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					   .addOrder(Order.desc("id"))
					   .setMaxResults(5)
					  .list();
			  
			  ipdPatientInvestigationHeaderList=session.createCriteria(PatientInvestigationHeader.class,"pih")
					  .createAlias("pih.Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", inpatientId))
					  .createAlias("pih.Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					   .addOrder(Order.desc("id"))
					   .setMaxResults(5)
					  .list(); 
			  
			 
			  
			  ipdOpdSurgeryHeaderList=session.createCriteria(OpdSurgeryHeader.class,"osh")
					  .createAlias("osh.Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", inpatientId))
					  .createAlias("osh.Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					   .addOrder(Order.desc("id"))
					   .setMaxResults(5)
					   .list();
			  
			  ipdOpdPatientAllergyMList=session.createCriteria(OpdPatientAllergyM.class,"opam")
					  .createAlias("opam.Hin", "hin")
					  .add(Restrictions.eq("hin.Id", box.getInt("hinId")))
					   .addOrder(Order.desc("id"))
					   .list();
			  
			  
			  
			  
			  ipdDetailsList =  session.createCriteria(OpdPatientDetails.class)
					  .createAlias("Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", box.getInt("parent")))
					  .createAlias("Hospital","h")
					  .add(Restrictions.eq("h.Id", hospitalId)) 
					  .addOrder(Order.desc("id")).list();
			  
			  if(opdDetailsList.size() > 0) { 
				  int visitId = 0; 
				  visitId = opdDetailsList.get(0).getVisit().getId(); 
				  if(ipdDetailsList.size() == 0) { 
					  opdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class)
							  .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list(); 
					  opdInvestigationList = session.createCriteria(PatientInvestigationHeader.class)
							  .createAlias("Visit", "v")
							  .add(Restrictions.eq("v.Id",visitId)).list();
					  icdList =session.createCriteria(DischargeIcdCode.class)
							  .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list();
					  //  opdProcedureList =  session.createCriteria(ProcedureHeader.class)
//					  .createAlias("Visit","v").add(Restrictions.eq("v.Id", visitId)).list(); 
			  // opdPhysiotherapyList = session.createCriteria(PhysioRequisitionHeader.class)
//					  .createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId)).list(); 
					  opdHistoryDetailsListForFollowUp = session.createCriteria (OpdPatientHistory.class)
							  .createAlias("OpdPatientDetails", "details")
							  .createAlias("details.Visit", "visit").add(Restrictions.eq("visit.Id", visitId)).list(); } }
			  
			  List<PatientPrescriptionHeader> ipdPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
			  List<PatientInvestigationHeader> ipdInvestigationList = new  ArrayList<PatientInvestigationHeader>(); 
			  List<DischargeIcdCode> ipIcdList = new ArrayList<DischargeIcdCode>(); 
			  // List<ProcedureHeader> ipdProcedureList = new ArrayList<ProcedureHeader>(); 
			  // List<NursingcareSetup> ipdProcedureList = new ArrayList<NursingcareSetup>(); 
			  //  List<PhysioRequisitionHeader> ipdPhysiotherapyList = new  ArrayList<PhysioRequisitionHeader>();  
			  List<OpdPatientHistory> ipdHistoryDetailsListForFollowUp = new ArrayList<OpdPatientHistory>();
			  
			  if(ipdDetailsList.size() > 0) {
			  caseSheetList.addAll(ipdDetailsList);
			  // to display all previous case ist 
			  // opdDetailsList.add(ipdDetailsList.get(0));
			  // to display latest case sheet details in todays case sheet 
			  int opdPatientDetailsId = 0; 
			  opdPatientDetailsId = ipdDetailsList.get(0).getId(); 
			  ipdPrescriptionList = session.createCriteria(PatientPrescriptionHeader.class)
					  .createAlias("OpdPatientDetail", "ip")
					  .add(Restrictions.eq("ip.id",opdPatientDetailsId))
					  .addOrder(Order.desc("Id")).setMaxResults(1).list();
			  ipdInvestigationList = session.createCriteria (PatientInvestigationHeader.class)
					  .createAlias("OpdPatientDetail", "ip")
					  .add(Restrictions.eq("ip.id", opdPatientDetailsId))
					  .addOrder(Order.desc("Id")).setMaxResults(1).list(); 
			  // ipdProcedureList =session.createCriteria(NursingcareSetup.class)
//			  .createAlias ("Inpatient", "ip")
//			  .add(Restrictions.eq("ip.Id", box.getInt("parent"))).
//			  addOrder(Order.desc("Id")).setMaxResults(1).list(); 
			  // ipdPhysiotherapyList =session.createCriteria(PhysioRequisitionHeader.class)
//			  .createAlias("OpdPatientDetails","ip")
//			  .add(Restrictions.eq("ip.id",opdPatientDetailsId))
//			  .addOrder(Order.desc("Id")).setMaxResults(1).list();
			  ipdHistoryDetailsListForFollowUp = session.createCriteria(OpdPatientHistory.class)
					  .createAlias("OpdPatientDetails", "ip")
					  .add(Restrictions.eq("ip.id", opdPatientDetailsId)).list();
			  
//			  ipdPatientDietList =  session.createCriteria(IpdPatientDiet.class) 
//					  .createAlias("OpdPatientDetails", "ip")
//					  .add(Restrictions.eq("ip.id",opdPatientDetailsId))
//					  .addOrder(Order.desc("Id")).setMaxResults(1).list();
			  }
			  ipdPrescriptionList.addAll(opdPrescriptionList);
			  ipdInvestigationList.addAll(opdInvestigationList);
			  ipIcdList.addAll(icdList);
			  //ipdProcedureList.addAll(opdProcedureList); 
			  //ipdPhysiotherapyList.addAll(opdPhysiotherapyList);
			  ipdHistoryDetailsListForFollowUp.addAll(opdHistoryDetailsListForFollowUp);
			  ipIcdList = session.createCriteria(DischargeIcdCode.class)
					  .createAlias("Inpatient","ip")
					  .add(Restrictions.eq("ip.id", box.getInt("parent")))
					  .addOrder(Order.desc("Id")).list(); 
			  caseSheetList.addAll(opdDetailsList); 
			  //to display opd case sheet
			  frequencyList =   session.createCriteria(MasFrequency.class)
					  .add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
//			  familyHistoryList = session.createCriteria (PatientFamilyHistory.class)
//					  .add(Restrictions.eq("Status","y")).list();
			  
			  masIcdList = session.createCriteria(MasIcd.class)
					  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			  dietTypeList = session.createCriteria(MasDiet.class)
					  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list(); 
			  templateList =session.createCriteria(OpdTemplate.class)
					  .createAlias("Department","dept")
					  .add( Restrictions.eq("dept.Id", box.getInt("deptId")))
					  .add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
			  
			  routeOfAdministrationList=session.createCriteria(RouteOfAdministration.class)
					  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			  
			  			masInstructionMasterList=session.createCriteria(OpdInstructionTreatment.class)
					  .add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			  
			  			allergyProductsList = session.createCriteria(MasAllergyProduct.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
			  			saverityCodesList = session.createCriteria(MasSeverityCode.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
				
						inPatientDetailList = session
						.createCriteria(Inpatient.class)
						.add(Restrictions.eq("Id", box.getInt("parent")))
						.add(Restrictions.in("AdStatus", new String[] { "A", "R" }))
						.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
						.list();
						nursingCareList = session.createCriteria(MasNursingCare.class)
						.add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
				
						nursingCareSetupList = session
						.createCriteria(NursingcareSetup.class)
						.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
						.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
						.list();
					
					
					
					ambulanceRegistersList=session.createCriteria(AmbulanceRegister.class)
	                         .add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
	                          .add(Restrictions.eq("Hospital.Id", box.getInt(HOSPITAL_ID)))
	                           .add(Restrictions.eq("RequestStatus","p").ignoreCase())					                            
	                         .list();
					 
					departmentList = session
								.createCriteria(MasInstituteDepartment.class,"msd")
								.createAlias("msd.Department", "md")
								.createAlias("md.DepartmentType", "mdt")
								.createAlias("msd.Institute", "mh")
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.add(Restrictions.eq("mdt.DepartmentTypeCode", departmentTypeCodeForCanteen).ignoreCase())
								.add(Restrictions.eq("md.Status", "y").ignoreCase())
								.add(Restrictions.eq("mh.Id", box.getInt(HOSPITAL_ID)))
								.setProjection(Projections.projectionList().add(Projections.property("msd.Department"))).list();
						
					masMenuTypeList=session.createCriteria(MasMenuType.class)
								.add(Restrictions.eq("Status","y").ignoreCase())
								.list();
						List<IpdVitalSetup>ipdVitalSetupList=new ArrayList<IpdVitalSetup>();
					ipdVitalSetupList = session
							.createCriteria(IpdVitalSetup.class)
							.add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
							.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID)))
							.list();
					
					employeeList=session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
							.add(Restrictions.eq("EmpCategory.Id",1))
							.add(Restrictions.eq("Hospital.Id",hospitalId))
							.addOrder(Order.asc("FirstName"))
							.list();
					int visitId=0;
					List<Visit>visitList=new ArrayList<Visit>();
					visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hin.Id", hinId)).addOrder(Order.desc("Id")).setMaxResults(1).list();
					for(Visit visit:visitList){
						visitId=visit.getId();
					}
					patientPrescriptionDetailsList=session.createCriteria(PatientPrescriptionDetails.class)
							.createAlias("Prescription", "Prescription")
							.createAlias("Prescription.Visit", "visit")
							.add(Restrictions.eq("visit.Id", visitId))
							//.add(Restrictions.eq("h.Id", hospitalId)) 
							.list();
					DgOrderdtList=session.createCriteria(DgOrderdt.class)
							.createAlias("Orderhd", "Orderhd")
							.createAlias("Orderhd.Visit", "visit")
							.add(Restrictions.eq("visit.Id", visitId))
							//.add(Restrictions.eq("h.Id", hospitalId)) 
							.list();
			
			  // Added by Amit Das For Rsby & CHIS PLus schemes
				if(inpatientList!=null && inpatientList.size()!=0){
					HibernateTemplate hbt = getHibernateTemplate();
					Patient patient =	hbt.load(Patient.class, inpatientList.get(0).getHin().getId());
					if(patient!=null && patient.getRsbyCardNo()!=null){
						rsbyCardDetailsList =	session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("RsbyCardNo", patient.getRsbyCardNo())).add(Restrictions.eq("Status", "y").ignoreCase()).list();
					}
				}
				
			  // Added by Amit Das For Rsby & CHIS PLus schemes
			  packageList = session.createCriteria(BlPackageHeader.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			  
			  // Added by Amit Das For Rsby & CHIS PLus schemes
			  packageSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("PackageFlag", "Y").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			  
			  // Added by Amit Das For Rsby & CHIS PLus schemes
			  packageServicesList = session.createCriteria(BlPackageServicesDetails.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
			  
			 
			//patient allergy status :start
			  for(OpdPatientAllergyM allergyM:ipdOpdPatientAllergyMList)
				{		
				for(OpdPatientAllergyT allergyT:allergyM.getOpdPatientAllergyTs())
				{
				allergyStr=allergyStr+"\n"+allergyT.getAllergen();
				}
				}
				
				
				//patient comorbidity status :start
				List<DischargeIcdCode> comorbidityList = new ArrayList<DischargeIcdCode>();
				
				comorbidityList= session.createCriteria(DischargeIcdCode.class).add(Restrictions.eq("Hin.Id", hinId))
												.add(Restrictions.or( Restrictions.isNotNull("ComorbidityStatus"),  Restrictions.eq("ComorbidityStatus", "y").ignoreCase()) )
												//.setProjection(Projections.distinct(Projections.property("Icd")))
												.add(Restrictions.eq("Status", "y").ignoreCase()).list();
				
				String comorbidityStr="";
				for(DischargeIcdCode dic:comorbidityList){
					if(comorbidityStr.equals("")){
						if(dic.getSinceMonth() != null){
						comorbidityStr=dic.getIcd().getIcdName()+" :Since Month "+dic.getSinceMonth();
						}else if(dic.getSinceYear() != null){
							comorbidityStr=dic.getIcd().getIcdName()+" :Since Year "+dic.getSinceYear();
						}else{
							comorbidityStr=dic.getIcd().getIcdName();
						}
						
					}else{
						if(dic.getSinceMonth() != null){
						comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName()+"Since Month  "+dic.getSinceMonth();
						}else if(dic.getSinceYear() != null){
							comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName()+"Since Year  "+dic.getSinceYear();
						}else{
							comorbidityStr=comorbidityStr+"\n"+dic.getIcd().getIcdName();
						}
						
					}
				}
				map.put("comorbidityStr", comorbidityStr);
				
			  
			  map.put("motherInpatientId",motherInpatientId); 
					
			  map.put("caseSheetList",caseSheetList); 
			  map.put("inpatientList", inpatientList);
			  map.put("opdDetailsList", opdDetailsList);
			  map.put("ipdPrescriptionList", ipdPrescriptionList);
			  map.put("ipdInvestigationList", ipdInvestigationList);
			  map.put("ipIcdList", ipIcdList); 
			  // map.put("ipdProcedureList",ipdProcedureList);
			  // map.put("ipdPhysiotherapyList",ipdPhysiotherapyList); 
			  map.put("ipdHistoryDetailsListForFollowUp",ipdHistoryDetailsListForFollowUp);
//			  map.put("ipdPatientDietList",ipdPatientDietList);
			  map.put("frequencyList", frequencyList);
//			  map.put("familyHistoryList", familyHistoryList);
			  map.put("masIcdList", masIcdList); 
			  map.put("dietTypeList", dietTypeList);
			  
			  map.put("routeOfAdministrationList", routeOfAdministrationList);
			  map.put("masInstructionMasterList", masInstructionMasterList);
			  map.put("allergyProductsList", allergyProductsList);
			  map.put("saverityCodesList", saverityCodesList);
			  
			  
			  //new value added for history
			  map.put("ipdPatientDetailList", ipdPatientDetailList);
			  map.put("ipdPatientHistoryList", ipdPatientHistoryList);
			  map.put("ipdDischargeList", ipdDischargeList);
			  map.put("ipdPatientPrescriptionHeaderList",ipdPatientPrescriptionHeaderList);
			  map.put("ipdPatientInvestigationHeaderList",ipdPatientInvestigationHeaderList);
			  map.put("ipdOpdSurgeryHeaderList",ipdOpdSurgeryHeaderList);
			  map.put("ipdOpdPatientAllergyMList", ipdOpdPatientAllergyMList);
			  
			  	map.put("nursingCareSetupList", nursingCareSetupList);
				map.put("inPatientDetailList", inPatientDetailList);
				map.put("nursingCareList", nursingCareList);
				map.put("ambulanceRegistersList", ambulanceRegistersList);			
				map.put("masDietList", masDietList);
				map.put("masMenuTypeList", masMenuTypeList);
				map.put("departmentList", departmentList);
				
				map.put("templateList", templateList);
			 map.put("ipdVitalSetupList",ipdVitalSetupList);
			// map.put("opdProcedureList",opdProcedureList);
			 map.put("employeeList",employeeList);
			 map.put("wardreamarksList",wardreamarksList);
			 map.put("patientPrescriptionDetailsList",patientPrescriptionDetailsList);
			 map.put("DgOrderdtList",DgOrderdtList);
			 
			 // added by Amit Das
			 map.put("rsbyCardDetailsList",rsbyCardDetailsList);
			 map.put("packageList",packageList);
			 map.put("packageSchemeList",packageSchemeList);
			 map.put("packageServicesList",packageServicesList);
			 map.put("allergyStr",allergyStr);
			return map;
		}
		
		
		// added by amit das on 07-06-2016
		public Map<String, Object> getInpatientListForSchemeChange(Map<String, Object> map) {

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
			List<RsbyCardDetails> rsbyCardDetails = new ArrayList<RsbyCardDetails>();
			int deptId = 0;
			int hospitalId = 0;
			String hinNo = null;
			String patientName = null;
			Session session = null;
			
			try{
			if(map!=null && (map.get(DEPARTMENT_ID)!=null && map.get(HOSPITAL_ID)!=null) ){
				deptId	= (Integer)map.get(DEPARTMENT_ID);
				hospitalId	= (Integer)map.get(HOSPITAL_ID);
				hinNo	= (String)map.get("hinNo");
				patientName	= (String)map.get("patientName");
				
				session = (Session)getSession();
				
				authorizerList = session.createCriteria(MasAuthorizer.class)
						.add(Restrictions.eq("Status", "y")).list();
				
				Criteria criteria = session
					.createCriteria(Inpatient.class, "ip")
					.createAlias("Hin","patient")
					.add(Restrictions.in("ip.AdStatus",
							new String[] { "A", "R" }))
					.add(Restrictions.eq("ip.Department.Id", deptId))
					.add(Restrictions.eq("ip.Hospital.id", hospitalId))
					.addOrder(Order.desc("DateOfAddmission"));
				
				if(hinNo!=null && !map.get("hinNo").equals(""))
					criteria.add(Restrictions.eq("patient.HinNo", hinNo));
				
				if(patientName!=null && !map.get("patientName").equals(""))
					criteria.add(Restrictions.like("patient.FullName", patientName, MatchMode.ANYWHERE).ignoreCase());
				
				inPatientList = criteria.list();
				
				dataMap.put("inPatientList", inPatientList);
				dataMap.put("authorizerList", authorizerList);
				
			 }
			} catch(Exception e){
				e.printStackTrace();
			}
			
			return dataMap;
		}

		/*added by amit das on 22-07-2016*/
		@Override
		public Map<String, Object> showDepartmentSpeciality(Map<String, Object> map) {
			Session session = (Session)getSession();
			int hospitalId=0;
			int deptId=0;
			int userId = 0;
			if(map.get("hospitalId")!=null){
				hospitalId=(Integer)map.get("hospitalId");
			}
			if( map.get("deptId")!=null){
				deptId=(Integer) map.get("deptId");
			}
			if( map.get("userId")!=null){
				userId=(Integer) map.get("userId");
			}
			
			
			List<UserSpecialityTemplate> usersSpecialityTemplateList = new ArrayList<UserSpecialityTemplate>();
			List<Object[]> specialtyTemplateList=new ArrayList<Object[]>();
			List<Integer> templateList = new ArrayList<Integer>();
			Object[] templateType = {"IP","Both"};
			usersSpecialityTemplateList = session.createCriteria(UserSpecialityTemplate.class).add(Restrictions.eq("User.Id", userId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if(usersSpecialityTemplateList.size()>0){
			for(UserSpecialityTemplate userSpecialityTemplate :usersSpecialityTemplateList){
			int templateId =userSpecialityTemplate.getTemplate().getId();
			templateList.add(templateId);
			
			}
			specialtyTemplateList=session.createCriteria(MasSpecialtyTemplate.class)//.createAlias("Department", "dept").createAlias("Template", "temp")
					.add(Restrictions.in("Id", templateList)).add(Restrictions.in("TemplateType", templateType))
						.add(Restrictions.eq("Status", "y").ignoreCase())
							.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("Id"))).add(Projections.property("TemplateName")))
			.list();
			}
			
			/*specialtyTemplateList=session.createCriteria(MasSpecialityDeptGroup.class)
						.add(Restrictions.eq("Department.Id",deptId))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.setProjection(Projections.distinct(Projections.property("Template")))
						.list();*/
			map.put("specialtyTemplateList", specialtyTemplateList);
			return map;
		}
		
		// added by amit das on 22-07-2016
		@Override
		public Map<String, Object> showGroupAndParameterValues(Map map) {
			List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
			List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
			List<MasSpecialtyGroupParameter> groupParameterList=new ArrayList<MasSpecialtyGroupParameter>();

			int idForValue=0;
	    	int departId=(Integer)map.get("deptId");
	    	 String template=(String)map.get("template");
	    	 logger.info("templatetemplate "+template);
	    	 if(template!=null && !(template.equals(""))){
				Criteria crForGroupParameter=getSession().createCriteria(MasSpecialityDeptGroup.class,"mas")
					                      .createAlias("mas.Department", "dep")
					                       .add(Restrictions.eq("dep.Id",departId))
					                      .createAlias("mas.Template", "tem")
					                     .add(Restrictions.eq("tem.Id",Integer.parseInt(template)))	
					                     .addOrder(Order.asc("GroupSeqNo")).addOrder(Order.asc("ParameterSeqNo")).add(Restrictions.eq("Status", "y").ignoreCase());
			masForGorupParameter=crForGroupParameter.list();
			
			List<Integer> groupIds=new ArrayList<Integer>();
			for (MasSpecialityDeptGroup masSpecialityDeptGroup : masForGorupParameter) {
				groupIds.add(masSpecialityDeptGroup.getSpGroup().getSpGroup().getId());
				//idForValue=masSpecialityDeptGroup.getId();
			}
			
			if(groupIds.size()>0){
			groupParameterList=getSession().createCriteria(MasSpecialtyGroupParameter.class,"mas").createAlias("mas.SpGroup", "sgroup")
	                      .add(Restrictions.in("sgroup.Id", groupIds)).add(Restrictions.eq("Status", "y").ignoreCase()).list();
			}
			
			if(masForGorupParameter.size()>0){
				Criteria crForParaValues=getSession().createCriteria(MasSpecialityDeptGroupValue.class,"masVal")
		                   .createAlias("masVal.DeptGroup", "deptGroup")
		                   .add(Restrictions.eq("deptGroup.ValueType", "LOV").ignoreCase())
		                   .add(Restrictions.in("masVal.DeptGroup",masForGorupParameter));
				 masValue=crForParaValues.list();
			}
	      }	
	   
			map.put("masForGorupParameter",masForGorupParameter);
			map.put("groupParameterList",groupParameterList);
			map.put("masValue",masValue);
		
			return map;
		} 
		
		@Override
		public Map<String, Object> saveSpeciality(Map map) {
			MasSpecialtyTemplate masSpecialtyTemplate = null;
			try{
				Session session = (Session) getSession();
				Transaction tx=session.beginTransaction();
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				
				String[] parameterIds=(String[])map.get("parameterId");
				String[] textValue=(String[])map.get("textValue");
				String[] textValue1=(String[])map.get("textValue1");
				
				
				
				
				Integer hinId=0;
				Integer departmentId=0;
				Integer visitId=0;
				Integer hospitalId=0;
				Integer specialtyId=0;
				Integer userId=0;
				if(map.get("hinId")!=null){
					hinId=(Integer)  map.get("hinId");	
				}
				if(map.get("departmentId")!=null){
					departmentId=(Integer)  map.get("departmentId");	
				}
				if(map.get("visitId")!=null){
					visitId=(Integer)  map.get("visitId");	
				}
				if(map.get("hospitalId")!=null){
					hospitalId=(Integer)  map.get("hospitalId");	
				}
				if(map.get("userId")!=null){
					userId=(Integer)  map.get("userId");	
				}
				
				if(map.get("specialtyId")!=null){
					specialtyId=(Integer)  map.get("specialtyId");	
				}
				
				
				String time=(String)HMSUtil.getCurrentDateAndTime().get("currentTime");
				int count=0;
				logger.info("parameterIds = "+parameterIds.length +"specialtyId = "+specialtyId);
				
				for(String str:parameterIds){
					
					String[] ids=str.split(":");
					Integer groupId=Integer.parseInt(ids[0]);
					Integer parameterId=Integer.parseInt(ids[1]);
					String paramterValue=textValue[count];
					
					String paramterValue1="";
					if(textValue1!=null && textValue1[count]!=null)
						paramterValue1 = textValue1[count];
					
					IpdSpecialityDetails ipds=new IpdSpecialityDetails();
					ipds.setHin(new Patient(hinId));
					ipds.setVisit(new Visit(visitId));
					ipds.setHospital(new MasHospital(hospitalId));
					ipds.setSpGroup(new MasSpecialityGroup(groupId));
					ipds.setSpParameter(new MasSpecialityParameter(parameterId));
					if(paramterValue.equalsIgnoreCase("radio")){
						ipds.setSpValues("y");
					}else if(paramterValue.equalsIgnoreCase("checkbox")){
						ipds.setSpValues("y");
					}else{
						ipds.setSpValues(paramterValue);
						
					}
					if(paramterValue1!=null){
						ipds.setSpValues2(paramterValue1);
					}
					
					masSpecialtyTemplate = (MasSpecialtyTemplate)session.get(MasSpecialtyTemplate.class,specialtyId); // added by amit das on 22-07-2016
					ipds.setSpTemplate(masSpecialtyTemplate); // added by amit das on 22-07-2016
					//opds.setSpTemplate(new MasSpecialtyTemplate(specialtyId)); // commented by amit das on 22-07-2016
					ipds.setLastChgBy(new Users(userId));
					ipds.setLastChgDate(new Date());
					ipds.setLastChgTime(time);
					hbt.save(ipds);
					count = count+1;
				}
				map.put("masSpecialtyTemplate", masSpecialtyTemplate); // added by amit das on 22-07-2016
				tx.commit();
			}catch(Exception e){
				e.printStackTrace();
			}
			return map;
		}
		
		
		@Override
		public Map<String,Object> getOutSideAvailableBloodBankList(Map<String,Object> map) {
			
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<MasHospital> bloodBankList=new ArrayList<MasHospital>();
			
			Session session = (Session) getSession();
			int hospitalId=0;
			String group="";
			
			if(null !=map.get("hospitalId")){
				hospitalId=(Integer)map.get("hospitalId");
			}
			if(null !=map.get("group")){
				group=(String)map.get("group");
			}
			
			try {
				if( group.equalsIgnoreCase("I")){
				bloodBankList=session.createCriteria(MasHospital.class)
						.add(Restrictions.eq("Id", hospitalId))
					.add(Restrictions.eq("BbAvailable", "Y").ignoreCase()).list();
				
				}
				else{
					bloodBankList=session.createCriteria(MasHospital.class)
							
						.add(Restrictions.eq("BbAvailable", "Y").ignoreCase()).list();
				}
	
				detailsMap.put("bloodBankList", bloodBankList);
				
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			return detailsMap;
		}

	
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom1(Box box) {
			logger.info("Method getPatientDetailsForLaborRoom1");
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int hospitalId=box.getInt(HOSPITAL_ID);
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			List<LrProcedureDone> lrProcedureDoneList = null;
			List<LrInduction> lrInductionList = null;
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.idEq(box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(inpatientList.size()>0){
			//Patient patient=inpatientList.get(0).getHin();
				int inpatientId =inpatientList.get(0).getId();
			
			laborRoomList = session.createCriteria(LaborRoom.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 1L)).list();
			
			lrProcedureDoneList = session.createCriteria(LrProcedureDone.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 1)).list();
			
			lrInductionList = session.createCriteria(LrInduction.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 1)).list();
			}
			logger.info("patient list "+inpatientList.size()+" laborRoomList "+laborRoomList.size());
			
			map.put("inpatientList", inpatientList);
			map.put("laborRoomList", laborRoomList);
			map.put("lrProcedureDoneList", lrProcedureDoneList);
			map.put("lrInductionList", lrInductionList);
			return map;
		}


		@Override
		public boolean addLaborRoom1(Map<String, Object> map) {
			boolean successfullyAdded = false;
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			List<LrProcedureDone> lrProcedureDoneList=new ArrayList<LrProcedureDone>();
			List<LrInduction> lrInductionList=new ArrayList<LrInduction>();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			if (map.get("laborRoomList") != null) {
					laborRoomList = (List<LaborRoom>)(map.get("laborRoomList"));
			}
			if (map.get("lrProcedureDoneList") != null) {
				lrProcedureDoneList = (List<LrProcedureDone>)(map.get("lrProcedureDoneList"));
		    }
			if (map.get("lrInductionList") != null) {
				lrInductionList = (List<LrInduction>)(map.get("lrInductionList"));
		    }
			try {
				
				for(LaborRoom lab:laborRoomList){
					hbt.save(lab);
				}
				
				for(LrProcedureDone lrPD:lrProcedureDoneList){
					hbt.save(lrPD);
				}
				
				for(LrInduction lrI:lrInductionList){
					hbt.save(lrI);
				}
				
				successfullyAdded = true;
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			return successfullyAdded;
		}

	
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom2(Box box) {
		
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int hospitalId=box.getInt(HOSPITAL_ID);
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			List<LrProcedureDone> lrProcedureDoneList = null;
			List<LrInduction> lrInductionList = null;
			List<LrFetalDetails> lrfetalDetailsList= null;
			List<LrDilatationDescent> lrDilatationDescentList = null;
			List<LrContraction> lrContractionList =null;
			List<LrPulseBp> lrPulseBpList =null;
			List<LrTemperature> lrTemperatureList =null;
			List<LrUrineAnalysis> lrUrineAnalysisList =null;

			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.idEq(box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(inpatientList.size()>0){
				int inpatientId =inpatientList.get(0).getId();
			    Integer laborRoomType[] = {1,2};
			laborRoomList = session.createCriteria(LaborRoom.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.in ("LaborRoomType",new Long[]{1l,2l})).list();
			
			lrProcedureDoneList = session.createCriteria(LrProcedureDone.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.in("LaborRoomType", laborRoomType)).list();
			
			lrInductionList = session.createCriteria(LrInduction.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
				      .add(Restrictions.eq("LaborRoomType", 2)).list();

			lrfetalDetailsList = session.createCriteria(LrFetalDetails.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			lrDilatationDescentList = session.createCriteria(LrDilatationDescent.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			lrContractionList = session.createCriteria(LrContraction.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			lrPulseBpList = session.createCriteria(LrPulseBp.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			lrTemperatureList = session.createCriteria(LrTemperature.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			lrUrineAnalysisList = session.createCriteria(LrUrineAnalysis.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 2)).list();
			
			
			}
			map.put("inpatientList", inpatientList);
			map.put("laborRoomList", laborRoomList);
			map.put("lrfetalDetailsList",lrfetalDetailsList);
			map.put("lrInductionList",lrInductionList);
			map.put("lrDilatationDescentList",lrDilatationDescentList);
			map.put("lrContractionList",lrContractionList);
			map.put("lrContractionList",lrContractionList);
			map.put("lrPulseBpList",lrPulseBpList);
			map.put("lrTemperatureList",lrTemperatureList);
			map.put("lrUrineAnalysisList",lrUrineAnalysisList);
			return map;
		}
		//added by govind 5-9-2016
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom3(Box box) {
			logger.info("Method getPatientDetailsForLabourRoom3");
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int hospitalId=box.getInt(HOSPITAL_ID);
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.idEq(box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(inpatientList.size()>0){
			Patient patient=inpatientList.get(0).getHin();
			
			laborRoomList = session.createCriteria(LaborRoom.class)
					.add(Restrictions.eq("Hin.Id", patient.getId()))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 3L)).list();
			}
			logger.info("patient list "+inpatientList.size()+" laborRoomList "+laborRoomList.size());
			map.put("inpatientList", inpatientList);
			map.put("laborRoomList", laborRoomList);
			return map;
		}
		
		@Override
		public Map<String, Object> getPatientDetailsForLaborRoom4(Box box) {
			logger.info("Method getPatientDetailsForLabourRoom4");
			Map<String, Object> map = new HashMap<String, Object>();
			Session session = (Session) getSession();
			int hospitalId=box.getInt(HOSPITAL_ID);
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.idEq(box.getInt("parent")))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			if(inpatientList.size()>0){
			Patient patient=inpatientList.get(0).getHin();
			
			laborRoomList = session.createCriteria(LaborRoom.class)
					.add(Restrictions.eq("Hin.Id", patient.getId()))
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("LaborRoomType", 4L)).list();
			}
			logger.info("patient list "+inpatientList.size()+" laborRoomList "+laborRoomList.size());
			map.put("inpatientList", inpatientList);
			map.put("laborRoomList", laborRoomList);
			return map;
		}
		
		//added by govind 5-9-2016	
		
		
		// added by amit das on 09-09-2016
				@Override
				public List<PatientEpisode> getPatientEpisodeList(String hinNo) {
					List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>();
					Session session=(Session) getSession();
					Criteria crt=null;
					crt=session.createCriteria(PatientEpisode.class)
							 .add(Restrictions.eq("HinNo", hinNo));
					patientEpisodeList=crt.list();
					 
					return patientEpisodeList;
				}	
				
				
				// added by amit das on 09-09-2016
				@Override
				public Map<String, Object> getPatientEpisodeDetails(Box box) {
							
				Map<String,Object> map=new HashMap<String,Object>();
				PatientEpisode patientEpisode = null;
							
				Session session=(Session) getSession();
				int episodeId=box.getInt("episodeId");
							
				patientEpisode = (PatientEpisode)session.get(PatientEpisode.class, episodeId);
							 
				map.put("patientEpisode", patientEpisode);
				return map;
				}	
				//added by govind 20-9-2016
				public Map<String, Object> checkItem(Map<String, Object> dataMap) {
					logger.info("Method checkItem()");
					Map<String, Object> map = new HashMap<String, Object>();
					int visitId = 0;
					int hospitalId=0;;
					if (dataMap.get(HOSPITAL_ID) != null) {
						hospitalId=(Integer)dataMap.get(HOSPITAL_ID);
					}
					String pvmsNo = "";
					if (dataMap.get("pvmsNo") != null) {
						pvmsNo = (String) dataMap.get("pvmsNo");
					}
					
					String departmentCodeForPharmacy = "";
					URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("pharmacy.properties");
					try {
						Properties prop = new Properties();
						prop.load(new FileInputStream(new File(resourcePath.getFile())));
						departmentCodeForPharmacy = prop
								.getProperty("departmentCodeforpharmacy");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					Session session = (Session) getSession();
									
					StoreItemBatchStock itemBatchStock=(StoreItemBatchStock) session.createCriteria(StoreItemBatchStock.class)
							.createAlias("Item", "item")
							.createAlias("Hospital", "h")
							.createAlias("Department", "dept")
							.add(Restrictions.eq("item.PvmsNo", pvmsNo))
							/*.add(Restrictions.eq("dept.DepartmentCode",departmentCodeForPharmacy).ignoreCase())*/
							.add(Restrictions.eq("h.Id", hospitalId))
							.add(Restrictions.ge("ClosingStock", new BigDecimal(0)))
							.add(Restrictions.and(Restrictions.isNotNull("ExpiryDate"),
										Restrictions.ge("ExpiryDate",HMSUtil.convertStringTypeDateToDateType((String)HMSUtil.getCurrentDateAndTime().get("currentDate")))))
									.setMaxResults(1)
									.uniqueResult();
						logger.info("itemBatchStock "+(itemBatchStock!=null));
							map.put("itemBatchStock", itemBatchStock);
					return map;
				}
				
				//added by govind 22-9-2016
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
             //added by govind 22-9-2016 end
				
				//added by govind 23-9-2016 
				public Map<String, Object> getItemBatch(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
					int deptId = box.getInt("deptId");
					int itemId =  box.getInt("itemId");
					int appDtId=box.getInt("appDtId");
					int hospitalId = box.getInt("hospitalId");
					int appointmentHeaderId = box.getInt("appointmentHeaderId");
					
					Session session = (Session)getSession();
					
					List<InjAppointmentDetails>injAppointmentDetails=session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader","header")
									.add(Restrictions.eq("Item.Id",itemId))
									.add(Restrictions.eq("header.Id",appointmentHeaderId))
									.addOrder(Order.asc("Id")).list();
					
					int pharmacyDepId =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "pharmacyDepId".trim()));
					String blockStatus [] = {"Temporary Block","Parmanent Block"};
					batchList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
									.add(Restrictions.eq("item.Id", itemId))
					  				.createAlias("Department", "dept")
					  				.add(Restrictions.or( Restrictions.eq("dept.Id", deptId), Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))))
					  				//.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
					  				.list();
					map.put("batchList", batchList);
					map.put("injAppointmentDetails", injAppointmentDetails);
					
					return map;
				}
				
				@Override
				public Map<String,Object> submitIPNursingCare(Box box){
					logger.info("Method submitIPNursingCare(");
					Map<String,Object> datamap = new HashMap<String,Object>();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					boolean flag=false;
					Map<String, Object> utilMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					String currentDate = (String) utilMap.get("currentDate");
					String time = (String) utilMap.get("currentTime");
					
					int Id= box.getInt("Id");		
					String remarks = box.getString("remarks");
					String batchNo=box.getString("batchNo").split(":")[0];
					int adm=box.getInt("adm");
					int issueStock=box.getInt("issueStock");
					String procedure=box.get("procedure");
					String immunizationInj = box.getString("immunizationInj"); // added by amit das on 19-09-2016
					String frequencyCode = null; // added by amit das on 19-09-2016
					
				
					InjAppointmentDetails injAppointmentDetails = (InjAppointmentDetails) hbt.get(InjAppointmentDetails.class, Id);
					
					int noOfDays = 0;
					
					if(injAppointmentDetails.getNoOfDays()!=null)
						noOfDays = injAppointmentDetails.getNoOfDays();
						
					int nFrequencyCode =0;
					// int frequencyId= injAppointmentDetails.getFrequency().getId(); // commented by amit das on 19-09-2016
					int nursingId= injAppointmentDetails.getInpatientPrescriptionDetails().getId();
					if(injAppointmentDetails.getFrequency()!=null)
						frequencyCode = injAppointmentDetails.getFrequency().getFrequencyCode();
					
					
					if(frequencyCode!=null && frequencyCode.length()>0)
					{
					  nFrequencyCode =  Integer.parseInt(frequencyCode);
					}
					
					int nTotalProcedure = nFrequencyCode * noOfDays;
					
					int injAppointmentHeaderId = injAppointmentDetails.getInjAppointmentHeader().getId();
					
					List<InjAppointmentDetails> listA = new ArrayList<InjAppointmentDetails>();
					List<InjAppointmentDetails> listB = new ArrayList<InjAppointmentDetails>();
					
					Session session = (Session)getSession();
					/*
					 procedure updates for copper t 
					*/
					Criteria cr=session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "header")
							.createAlias("InpatientPrescriptionDetails", "nr")
							.add(Restrictions.eq("header.Id", injAppointmentHeaderId))
							.add(Restrictions.eq("nr.Id", nursingId))
							.add(Restrictions.isNull("ExceptionalPrescription"));
					listA = cr.list();
					
					Criteria crExce =session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "header")
							.createAlias("InpatientPrescriptionDetails", "nr")
							.add(Restrictions.eq("header.Id", injAppointmentHeaderId))
							.add(Restrictions.eq("nr.Id", nursingId))
							.add(Restrictions.eq("Status","p").ignoreCase())
							.add(Restrictions.and(Restrictions.eq("InjAppointmentDate", new Date()), Restrictions.le("ExceptionalPrescription","y").ignoreCase()));
					listB = crExce.list();
					
					
					List<StoreItemBatchStock>storeItemBatch=session.createCriteria(StoreItemBatchStock.class).add(Restrictions.eq("BatchNo",batchNo)).add(Restrictions.eq("Item.Id", injAppointmentDetails.getItem().getId())).list();
					StoreItemBatchStock stock=null; 
					if(storeItemBatch.size()>0){
						stock=storeItemBatch.get(0);
						stock.setClosingStock(stock.getClosingStock().subtract(new BigDecimal(issueStock)));
					}
					
					if(listA!=null && listA.size()>0){
						if(listA.size() != nTotalProcedure)
						{	
							InjAppointmentDetails newDetailsId = new InjAppointmentDetails();
							newDetailsId.setInpatientPrescriptionDetails(injAppointmentDetails.getInpatientPrescriptionDetails());
							newDetailsId.setInjAppointmentHeader(injAppointmentDetails.getInjAppointmentHeader());
							newDetailsId.setItem(injAppointmentDetails.getItem());
							newDetailsId.setDose(injAppointmentDetails.getDose());
							newDetailsId.setFrequency(injAppointmentDetails.getFrequency());
							newDetailsId.setStatus("p");
							newDetailsId.setNoOfDays(injAppointmentDetails.getNoOfDays());
							newDetailsId.setFinalStatus("n");
							
							if(box.getString("AppointmentFlag").equalsIgnoreCase("y"))
							{
								newDetailsId.setNextAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("AppointmentDate")));
								newDetailsId.setInjAppointmentDate(HMSUtil.convertStringTypeDateToDateType(box.getString("AppointmentDate")));
							}
							else
							{
								newDetailsId.setInjAppointmentDate(injAppointmentDetails.getInjAppointmentDate());
							}
							if(adm!=1 && stock!=null){
									hbt.saveOrUpdate(stock);
									hbt.save(newDetailsId);
									hbt.refresh(newDetailsId);
							}else{
								hbt.save(newDetailsId);
								hbt.refresh(newDetailsId);
							}
							
						}
						else
						{
							// update all injectiondetail row with final status
							for(InjAppointmentDetails dt: listA)
							{
								InjAppointmentDetails dt1 = new InjAppointmentDetails();
								dt1 =hbt.get(InjAppointmentDetails.class, dt.getId());
								if(dt1 != null)
								{
									dt1.setFinalStatus("y");
									hbt.update(dt1);
									hbt.refresh(dt1);
								}
							}
						}
							
						try{
								if(injAppointmentDetails != null)
								{
									injAppointmentDetails.setInjAppointmentDate(new Date());
									injAppointmentDetails.setAppointmentTime(time);
									injAppointmentDetails.setNursingRemark(remarks);
									injAppointmentDetails.setStatus("y");
									injAppointmentDetails.setIssueStock(issueStock);
									if(adm!=1){
										injAppointmentDetails.setBatchNo(batchNo);
										injAppointmentDetails.setIssueStock(1);
										injAppointmentDetails.setAdministrator("n");
									}else{
										injAppointmentDetails.setAdministrator("y");
									}
									
									if(adm!=1 && stock!=null){
										hbt.saveOrUpdate(stock);
										hbt.save(injAppointmentDetails);
										hbt.refresh(injAppointmentDetails);
									}else{
										hbt.save(injAppointmentDetails);
										hbt.refresh(injAppointmentDetails);
									}
									flag=true;
								}
						 }catch(Exception e)
						 {
							 e.printStackTrace();
						 }
					}
					if(listB!=null && listB.size()>0){
							try{
									if(injAppointmentDetails != null)
									{
										injAppointmentDetails.setInjAppointmentDate(new Date());
										injAppointmentDetails.setAppointmentTime(time);
										injAppointmentDetails.setNursingRemark(remarks);
										injAppointmentDetails.setStatus("y");
										injAppointmentDetails.setIssueStock(issueStock);
										injAppointmentDetails.setFinalStatus("y");
										if(adm!=1){
											injAppointmentDetails.setBatchNo(batchNo);
											injAppointmentDetails.setIssueStock(1);
											injAppointmentDetails.setAdministrator("n");
										}else{
											injAppointmentDetails.setAdministrator("y");
										}
										if(adm!=1 && stock!=null){
											hbt.saveOrUpdate(stock);
											
											hbt.save(injAppointmentDetails);
											hbt.refresh(injAppointmentDetails);
										}else{
											hbt.save(injAppointmentDetails);
											hbt.refresh(injAppointmentDetails);
										}
										flag=true;
									}
							 }catch(Exception e)
							 {
								 e.printStackTrace();
							 }
						
					}		
					logger.info("immunization "+immunizationInj);
					// added by amit das on 16-09-2016
					if(immunizationInj!=null && immunizationInj.equalsIgnoreCase("Y")){
						injAppointmentDetails.setFinalStatus("y");
						hbt.update(injAppointmentDetails);
						
						OpdVaccinationPlan vaccinationPlan = new OpdVaccinationPlan();
						int vaccinationPlanId =0 ;
						Patient hin = null;
						MasHospital masHospital	= (MasHospital)session.get(MasHospital.class, box.getInt("hospitalId"));
						
						OpdVaccinMst vaccinMst = new OpdVaccinMst();
						vaccinMst.setId(box.getInt("vaccinId"));
						vaccinationPlan.setVaccin(vaccinMst);
						
						
						if(box.getInt("hinId")!=0){
							hin = (Patient)session.get(Patient.class, box.getInt("hinId"));
							vaccinationPlan.setHin(hin);
						}
						
						
						vaccinationPlan.setHospital(masHospital);
						vaccinationPlan.setLastChgDate(new Date());
						vaccinationPlan.setLastChgTime(time);
						vaccinationPlan.setVaccinCompleteDate(new Date());
						/*Users users = new Users();
						users.setId(box.getInt("userId"));
						vaccinationPlan.setLastChgBy(users);*/
						hbt.save(vaccinationPlan);
						
						vaccinationPlanId=vaccinationPlan.getId();						
						
						if(hin!=null && hin.getMember()!=null){
						long memberId2=0L;
						List<PhMemberSurvey>PhMemberSurveyList=new ArrayList<PhMemberSurvey>();
						PhMemberSurveyList=session.createCriteria(PhMemberSurvey.class).add(Restrictions.eq("Id", hin.getMember().getId())).list();
						int subcentreId=0;
						for(PhMemberSurvey PhMemberSurvey:PhMemberSurveyList){
							if(PhMemberSurvey.getHospital()!=null){
							subcentreId=PhMemberSurvey.getHospital().getId();
							memberId2=PhMemberSurvey.getMemberId();
						  } 
						}
						List<OpdVaccinationPlan>OpdVaccinationPlanList=new ArrayList<OpdVaccinationPlan>();
						OpdVaccinationPlanList=session.createCriteria(OpdVaccinationPlan.class).add(Restrictions.eq("Id", vaccinationPlanId)).list();
						for(OpdVaccinationPlan opdVaccinationPlan :OpdVaccinationPlanList){
						if(subcentreId!=0){

						MasHospital mh=new MasHospital();
						mh.setId(subcentreId);
						opdVaccinationPlan.setSubCentre(mh);
						if(memberId2>0L)
							opdVaccinationPlan.setMember(memberId2);
						hbt.update(opdVaccinationPlan);
					    }
					  }
					  }
					}
					
					 datamap.put("flag", flag);
					 return datamap;
				}
				
				@Override
				public Map<String, Object> saveGeneralSurgery(Box box) {
					Map<String,Object>map = new HashMap<String,Object>();
					MasSpecialtyTemplate masSpecialtyTemplate = null;
					try{
						Session session = (Session) getSession();
						Transaction tx=session.beginTransaction();
						HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
								
						int hospitalId=0;
						if (box.getInt("hospitalId") != 0){
							hospitalId = box.getInt("hospitalId");
						}
						
						int opdPatientDetailId = 0;;
						if (box.getInt("opdPatientDetailId") != 0){
							opdPatientDetailId = box.getInt("opdPatientDetailId");
						}
						int hinId=0;
						if(box.getInt("hinId") !=0){
							hinId=box.getInt("hinId");	
						}
						
						int pastHistoryCount = 0;
						if(box.getInt("pastHistoryCount") != 0){
							pastHistoryCount = box.getInt("pastHistoryCount");
						}
						logger.info("pastHistoryCount==="+pastHistoryCount);
						for(int i=1;i<=pastHistoryCount;i++){
							OpdGeneralSurgeryPastSpeciality generalSurgeryPastSpeciality = new OpdGeneralSurgeryPastSpeciality();
							if(!box.getString("disease"+i).equals("") ||  !box.getString("duration"+i).equals("") ||  !box.getString("numberOfEpisodes"+i).equals("") 
									||  !box.getString("detailsOne"+i).equals("") ||  !box.getString("detailsTwo"+i).equals("") 
									||  !box.getString("drugs"+i).equals("")||  !box.getString("anyOtherSpecifyAnother"+i).equals("")  
									){
								
							if(!box.getString("disease"+i).equals("")){
								generalSurgeryPastSpeciality.setDisease(box.getString("disease"+i));
							}
							if(!box.getString("duration"+i).equals("")){
								generalSurgeryPastSpeciality.setDuration(box.getString("duration"+i));
							}
							if(!box.getString("numberOfEpisodes"+i).equals("")){
								generalSurgeryPastSpeciality.setNumberOfEpisodes(box.getString("numberOfEpisodes"+i));
							}
							if(!box.getString("detailsOne"+i).equals("")){
								generalSurgeryPastSpeciality.setDetailsOne(box.getString("detailsOne"+i));
							}
							if(!box.getString("detailsTwo"+i).equals("")){
								generalSurgeryPastSpeciality.setDetailsTwo(box.getString("detailsTwo"+i));
							}
							if(!box.getString("drugs"+i).equals("")){
								generalSurgeryPastSpeciality.setDrugs(box.getString("drugs"+i));
							}
							if(!box.getString("anyOtherSpecifyAnother"+i).equals("")){
								generalSurgeryPastSpeciality.setOthersAnother(box.getString("anyOtherSpecifyAnother"+i));
							}
							
							
							 Patient patient = new Patient();
							patient.setId(hinId);
							generalSurgeryPastSpeciality.setHin(patient);
							
							
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(opdPatientDetailId);
							generalSurgeryPastSpeciality.setOpdPatientDetails(opdPatientDetails);
							generalSurgeryPastSpeciality.setFlagSpeciality("past");
							hbt.save(generalSurgeryPastSpeciality);
							
							}
							
						}

						int familyHistoryCount = 0;
						if(box.getInt("familyHistoryCount") != 0){
							familyHistoryCount = box.getInt("familyHistoryCount");
						}
						logger.info("familyHistoryCount==="+familyHistoryCount);
						for(int i=1;i<=familyHistoryCount;i++){
							OpdGeneralSurgeryPastSpeciality generalSurgeryFamilySpeciality = new OpdGeneralSurgeryPastSpeciality();
							if(!box.getString("diseaseF"+i).equals("") || !box.getString("realationF"+i).equals("") || !box.getString("durationF"+i).equals("") ||  !box.getString("anyOtherSpecify"+i).equals("") ){
							if(!box.getString("diseaseF"+i).equals("")){
								generalSurgeryFamilySpeciality.setDisease(box.getString("diseaseF"+i));
							}
							if(!box.getString("realationF"+i).equals("0")){
								MasRelation masRelation =new MasRelation();
								masRelation.setId(box.getInt("realationF"+i));
								generalSurgeryFamilySpeciality.setRelation(masRelation);
							}
							if(!box.getString("durationF"+i).equals("")){
								generalSurgeryFamilySpeciality.setDuration(box.getString("durationF"+i));
							}
							if(!box.getString("anyOtherSpecify"+i).equals("")){
								generalSurgeryFamilySpeciality.setOthers(box.getString("anyOtherSpecify"+i));
							}
							
							generalSurgeryFamilySpeciality.setFlagSpeciality("family");
							
							Patient patient = new Patient();
							patient.setId(hinId);
							generalSurgeryFamilySpeciality.setHin(patient);
					
								
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(opdPatientDetailId);
							generalSurgeryFamilySpeciality.setOpdPatientDetails(opdPatientDetails);
							
							
							hbt.save(generalSurgeryFamilySpeciality);
							
						}
							
						}
						int previousSurgeriesCount = 0;
						if(box.getInt("previousSurgeriesCount") != 0){
							previousSurgeriesCount = box.getInt("previousSurgeriesCount");
						}
						logger.info("previousSurgeriesCount==="+previousSurgeriesCount);
						for(int i=1;i<=previousSurgeriesCount;i++){
							OpdGeneralSurgeryPrevSpeciality  generalSurgeryPrevSpeciality = new OpdGeneralSurgeryPrevSpeciality();
							if(!box.getString("typeP"+i).equals("") || !box.getString("dateYear"+i).equals("") ||  !box.getString("hospitalizationDuration"+i).equals("") ||  !box.getString("complications"+i).equals("") 
									||  !box.getString("institution"+i).equals("")){
								
								
							if(!box.getString("typeP"+i).equals("")){
								generalSurgeryPrevSpeciality.setTypePrev(box.getString("typeP"+i));
								
							}
							
							if(!box.getString("dateYear"+i).equals("")  ){
								generalSurgeryPrevSpeciality.setDatePrev(HMSUtil.convertStringTypeDateToDateType(box.getString("dateYear"+i)));
								
							}
							
							if(!box.getString("institution"+i).equals("")) {
								generalSurgeryPrevSpeciality.setInstitution(box.getString("institution"+i));
								
							}
						
							if(!box.getString("hospitalizationDuration"+i).equals("")){
								generalSurgeryPrevSpeciality.setHospitalizationDuration(box.getString("hospitalizationDuration"+i));
								
							}
						
							if(!box.getString("complications"+i).equals("")){
								generalSurgeryPrevSpeciality.setComplications(box.getString("complications"+i));
							
							}
							
							Patient patient = new Patient();
							patient.setId(hinId);
							generalSurgeryPrevSpeciality.setHin(patient);
					
								
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(opdPatientDetailId);
							generalSurgeryPrevSpeciality.setOpdPatientDetails(opdPatientDetails);
							
							
							hbt.save(generalSurgeryPrevSpeciality);
						}
						
						}
						
					/*	if(!box.getString("typePTemp"+i).equals("") || !box.getString("dateYeartypePTemp"+i).equals("") ||  !box.getString("hospitalizationDurationtypePTemp"+i).equals("") ||  !box.getString("complicationstypePTemp"+i).equals("") 
								||  !box.getString("institutiontypePTemp"+i).equals("")){
							System.out.println(box.getString("typeP"+i)+"---------" );
							System.out.println(box.getString("typePTemp"+i)+"---------" );
						
						if(!box.getString("typePTemp"+i).equals("") ){
							generalSurgeryPrevSpeciality.setTypePrev(box.getString("typePTemp"+i));
						}
						
						if(!box.getString("dateYearTemp"+i).equals("") ){
					
							generalSurgeryPrevSpeciality.setDatePrev(HMSUtil.convertStringTypeDateToDateType(box.getString("dateYearTemp"+i)));
						}
						
						if(!box.getString("institutionTemp"+i).equals("")) {
							
							generalSurgeryPrevSpeciality.setInstitution(box.getString("institutionTemp"+i));
						}
						
						if(!box.getString("hospitalizationDurationTemp"+i).equals("")){
							generalSurgeryPrevSpeciality.setHospitalizationDuration(box.getString("hospitalizationDurationTemp"+i));
							
						}
						
						if(!box.getString("complicationsTemp"+i).equals("")){
							generalSurgeryPrevSpeciality.setComplications(box.getString("complicationsTemp"+i));
						}
						Patient patient = new Patient();
						patient.setId(hinId);
						generalSurgeryPrevSpeciality.setHin(patient);
				
							
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(opdPatientDetailId);
						generalSurgeryPrevSpeciality.setOpdPatientDetails(opdPatientDetails);
						
						
						hbt.save(generalSurgeryPrevSpeciality);
					}
					
					}*/
						OpdGeneralSurgerySpeciality generalSurgerySpeciality = new OpdGeneralSurgerySpeciality();
						generalSurgerySpeciality.setBleeding(box.getString("bleeding"));
						generalSurgerySpeciality.setBleedingDuration(box.getString("bleedingDuration") +" "+box.getString("bleedingDurationParameter"));
						generalSurgerySpeciality.setBleedingSite(box.getString("bleedingSite"));
						
						generalSurgerySpeciality.setClaudication(box.getString("claudication"));
						generalSurgerySpeciality.setClaudicationDuration(box.getString("claudicationDuration") +" "+box.getString("claudicationDurationParameter"));
						generalSurgerySpeciality.setClaudicationSite(box.getString("claudicationSite"));
						generalSurgerySpeciality.setClaudicationType(box.getString("claudicationType"));
						/*generalSurgerySpeciality.setClaudicationShifting(box.getString("claudicationShifting"));
						generalSurgerySpeciality.setClaudicationReferral(box.getString("claudicationReferral"));*/
						generalSurgerySpeciality.setClaudicationDistance(box.getString("claudicationDistance"));
						generalSurgerySpeciality.setClaudicationRadiation(box.getString("claudicationRadiation"));
						
					
						generalSurgerySpeciality.setConstipation(box.getString("constipation"));
						generalSurgerySpeciality.setConstipationAbsoluteRelative(box.getString("constipationAbsoluteRelative"));
						generalSurgerySpeciality.setConstipationDuration(box.getString("constipationDuration")+" "+box.getString("constipationDurationParameter"));
						generalSurgerySpeciality.setConstipationProgressiveIntermittent(box.getString("constipationProgressiveIntermittent"));
						
						generalSurgerySpeciality.setCough(box.getString("cough"));
						generalSurgerySpeciality.setCoughDuration(box.getString("coughDuration")+" "+box.getString("coughDurationParameter"));
						generalSurgerySpeciality.setCoughType(box.getString("coughType"));
					
						generalSurgerySpeciality.setDilatedVeins(box.getString("dilatedVeins"));
						generalSurgerySpeciality.setDilatedVeinsDuration(box.getString("dilatedVeinsDuration")+" "+box.getString("dilatedVeinsDurationParameter"));
						generalSurgerySpeciality.setDilatedVeinsSite(box.getString("dilatedVeinsSite"));
						
						generalSurgerySpeciality.setDischarge(box.getString("discharge"));
						generalSurgerySpeciality.setDischargeDuration(box.getString("dischargeDuration")+" "+box.getString("dischargeDurationParameter"));
						generalSurgerySpeciality.setDischargeSite(box.getString("dischargeSite"));
						generalSurgerySpeciality.setDischargeType(box.getString("dischargeType"));
						
						
						generalSurgerySpeciality.setDiscoloration(box.getString("discoloration"));
						generalSurgerySpeciality.setDiscolorationDuration(box.getString("discolorationDuration")+" "+box.getString("discolorationDurationParameter"));
						generalSurgerySpeciality.setDiscolorationSite(box.getString("discolorationSite"));
						
						generalSurgerySpeciality.setDistension(box.getString("distension"));
						generalSurgerySpeciality.setDistensionDuration(box.getString("distensionDuration")+" "+box.getString("distensionDurationParameter"));
						generalSurgerySpeciality.setDistensionSite(box.getString("distensionSite"));
						
						
						generalSurgerySpeciality.setDysphagia(box.getString("dysphagia"));
						generalSurgerySpeciality.setDysphagiaDuration(box.getString("dysphagiaDuration")+" "+box.getString("dysphagiaDurationParameter"));
						if(box.getString("dysphagiaSolids").equals("Solids") && box.getString("dysphagiaLiquids").equals("Liquids")){
						generalSurgerySpeciality.setDysphagiaSolids(box.getString("dysphagiaSolids")+","+box.getString("dysphagiaLiquids"));
						}
						if(box.getString("dysphagiaSolids").equals("Solids") && !box.getString("dysphagiaLiquids").equals("Liquids")){
							generalSurgerySpeciality.setDysphagiaSolids(box.getString("dysphagiaSolids"));
							}
						if(!box.getString("dysphagiaSolids").equals("Solids") && box.getString("dysphagiaLiquids").equals("Liquids")){
							generalSurgerySpeciality.setDysphagiaSolids(box.getString("dysphagiaLiquids"));
							}
						generalSurgerySpeciality.setDysphagiaType(box.getString("dysphagiaType"));
						
						
						generalSurgerySpeciality.setDyspnea(box.getString("dyspnea"));
						generalSurgerySpeciality.setDyspneaDuration(box.getString("dyspneaDuration")+" "+box.getString("dyspneaDurationParameter"));
						generalSurgerySpeciality.setDyspneaType(box.getString("dyspneaType"));
						
						generalSurgerySpeciality.setDysuria(box.getString("dysuria"));
						generalSurgerySpeciality.setDysuriaDuration(box.getString("dysuriaDuration")+" "+box.getString("dysuriaDurationParameter"));
						generalSurgerySpeciality.setDysuriaType(box.getString("dysuriaType"));
					
						generalSurgerySpeciality.setFever(box.getString("fever"));
						generalSurgerySpeciality.setFeverDuration(box.getString("feverDuration")+" "+box.getString("feverDurationParameter"));
						generalSurgerySpeciality.setFeverType(box.getString("feverType"));
					
						
						generalSurgerySpeciality.setHaematochezia(box.getString("haematochezia"));
						generalSurgerySpeciality.setHaematocheziaDuration(box.getString("haematocheziaDuration")+" "+box.getString("haematocheziaDurationParameter"));
						generalSurgerySpeciality.setHaematocheziaInitial(box.getString("haematocheziaInitial"));
						
						
						generalSurgerySpeciality.setHaemetemesis(box.getString("haemetemesis"));
						generalSurgerySpeciality.setHaemetemesisDuration(box.getString("haemetemesisDuration")+" "+box.getString("haemetemesisDurationParameter"));
						generalSurgerySpeciality.setHaemetemesisInitial(box.getString("haemetemesisInitial"));
						
						
						generalSurgerySpeciality.setHeartburn(box.getString("heartburn"));
						generalSurgerySpeciality.setHeartburnDuration(box.getString("heartburnDuration")+" "+box.getString("heartburnDurationParameter"));
						generalSurgerySpeciality.setHeartburnType(box.getString("heartburnType"));
						
						
						generalSurgerySpeciality.setJaundice(box.getString("jaundice"));
						generalSurgerySpeciality.setJaundiceDuration(box.getString("jaundiceDuration")+" "+box.getString("jaundiceDurationParameter"));
						generalSurgerySpeciality.setJaundiceProgressiveIntermittent(box.getString("jaundiceProgressiveIntermittent"));
									
												
						generalSurgerySpeciality.setMalena(box.getString("malena"));
						generalSurgerySpeciality.setMalenaDuration(box.getString("malenaDuration")+" "+box.getString("malenaDurationParameter"));
						
										
						generalSurgerySpeciality.setNausea(box.getString("nausea"));
						generalSurgerySpeciality.setNauseaDuration(box.getString("nauseaDuration")+" "+box.getString("nauseaDurationParameter"));
						generalSurgerySpeciality.setNauseaType(box.getString("nauseaType"));
					
										
						generalSurgerySpeciality.setPain(box.getString("pain"));
						generalSurgerySpeciality.setPainDuration(box.getString("painDuration")+" "+box.getString("painDurationParameter"));
						generalSurgerySpeciality.setPainSite(box.getString("painSite"));
						generalSurgerySpeciality.setPainType(box.getString("painType"));
						generalSurgerySpeciality.setPainShifting(box.getString("painShifting"));
						generalSurgerySpeciality.setPainReferral(box.getString("painReferral"));
						generalSurgerySpeciality.setPainRadiation(box.getString("painRadiation"));
						
					
					
						generalSurgerySpeciality.setSwelling(box.getString("swelling"));
						generalSurgerySpeciality.setSwellingDuration(box.getString("swellingDuration")+" "+box.getString("swellingDurationParameter"));
						generalSurgerySpeciality.setSwellingSite(box.getString("swellingSite"));
						generalSurgerySpeciality.setSwellingSize(box.getString("swellingSize"));
						generalSurgerySpeciality.setSwellingShape(box.getString("swellingShape"));
						generalSurgerySpeciality.setSwellingGrowthRate(box.getString("swellingGrowthRate"));
					
						
						
						generalSurgerySpeciality.setTrauma(box.getString("trauma"));
						generalSurgerySpeciality.setTraumaDuration(box.getString("traumaDuration")+" "+box.getString("traumaDurationParameter"));
						generalSurgerySpeciality.setTraumaType(box.getString("traumaType"));
					
						generalSurgerySpeciality.setUlcer(box.getString("ulcer"));
						generalSurgerySpeciality.setUlcerDuration(box.getString("ulcerDuration")+" "+box.getString("ulcerDurationParameter"));
						generalSurgerySpeciality.setUlcerSite(box.getString("ulcerSite"));
						generalSurgerySpeciality.setUlcerSize(box.getString("ulcerSize"));
						generalSurgerySpeciality.setUlcerShape(box.getString("ulcerShape"));
						generalSurgerySpeciality.setUlcerGrowthRate(box.getString("ulcerGrowthRate"));
						
						generalSurgerySpeciality.setUrinaryObstruction(box.getString("urinaryObstruction"));
						generalSurgerySpeciality.setUrinaryObstructionDuration(box.getString("urinaryObstructionDuration")+" "+box.getString("urinaryObstructionDurationParameter"));
						generalSurgerySpeciality.setUrinaryObstructionContinuos(box.getString("urinaryObstructionContinuos"));
					
						generalSurgerySpeciality.setVomiting(box.getString("vomiting"));
						generalSurgerySpeciality.setVomitingDuration(box.getString("vomitingDuration")+" "+box.getString("vomitingDurationParameter"));
						generalSurgerySpeciality.setVomitingProjectile(box.getString("vomitingProjectile"));
						generalSurgerySpeciality.setVomitingTimeAfterFoodIntake(box.getString("vomitingTimeAfterFoodIntake"));
						generalSurgerySpeciality.setVomitingBilious(box.getString("vomitingBilious"));
						generalSurgerySpeciality.setPresentingComplaints(box.getString("presentingComplaints"));
						
						generalSurgerySpeciality.setDiet(box.getString("diet"));
						
						generalSurgerySpeciality.setSleep(box.getString("sleep"));
						
						generalSurgerySpeciality.setBowel(box.getString("bowel"));
						generalSurgerySpeciality.setBladder(box.getString("bladder"));
						generalSurgerySpeciality.setAppetite(box.getString("appetite"));
						generalSurgerySpeciality.setPersonalHabits(box.getString("personalHabits"));
						
						
					if(box.getString("smokingValue").equalsIgnoreCase("yes")){
						generalSurgerySpeciality.setSmokingValue(box.getString("smokingValue"));
						generalSurgerySpeciality.setSmoking(box.getString("smoking"));
						generalSurgerySpeciality.setMumberDay(box.getString("smokingDuration")+" "+box.getString("smokingDurationParameter"));
						//generalSurgerySpeciality.setSmokingDay(box.getString("smokingDay"));
					}
					if(box.getString("alcoholValue").equalsIgnoreCase("yes")){
						generalSurgerySpeciality.setAlcoholValue(box.getString("alcoholValue"));
						generalSurgerySpeciality.setAlcoholVolume(box.getString("alcoholVolume"));
						generalSurgerySpeciality.setAlcoholDay(box.getString("alcoholDuration")+" "+box.getString("alcoholDurationParameter"));
					}
					if(box.getString("otherAddictionsValue").equalsIgnoreCase("yes")){
						generalSurgerySpeciality.setOtherAddictionValue(box.getString("otherAddictionsValue"));
						generalSurgerySpeciality.setOtherAddictions(box.getString("otherAddictions"));
					}
						generalSurgerySpeciality.setMenarche(box.getString("menarche"));
						generalSurgerySpeciality.setCyclelength(box.getString("cyclelength"));
						generalSurgerySpeciality.setFlowdays(box.getString("flowdays"));
						generalSurgerySpeciality.setMenopause(box.getString("menopause"));
						if(!box.getString("lmpDate").equals("")){
							generalSurgerySpeciality.setLmpDate(HMSUtil.convertStringTypeDateToDateType(box.getString("lmpDate")));
						}
						
						generalSurgerySpeciality.setNumberOfChildren(box.getString("numberOfChildren"));
					
						
					
						
						if(box.getInt("typeOfDelivery") !=0){
							MasDeliveryType masDeliveryType = new MasDeliveryType();
							masDeliveryType.setId(box.getInt("typeOfDelivery"));
							generalSurgerySpeciality.setTypeOfDelivery(masDeliveryType);
						}
						
						generalSurgerySpeciality.setLactationDuration(box.getString("lactationDuration"));
						generalSurgerySpeciality.setPps(box.getString("pps"));
						generalSurgerySpeciality.setHrt(box.getString("hrt"));
						generalSurgerySpeciality.setOcp(box.getString("hrt"));
						generalSurgerySpeciality.setInfertitility(box.getString("infertitility"));
						
						generalSurgerySpeciality.setPallor(box.getString("pallor"));
						
						generalSurgerySpeciality.setIcterus(box.getString("icterus"));
						generalSurgerySpeciality.setCyanosis(box.getString("cyanosis"));
						generalSurgerySpeciality.setClubbing(box.getString("clubbing"));
						generalSurgerySpeciality.setGeneralizedLymphadenopathy(box.getString("generalizedLymphadenopathy"));
						generalSurgerySpeciality.setOthersData(box.getString("othersData"));
						generalSurgerySpeciality.setGeneralizedLymphadenopathyTxt(box.getString("lymphadenopathyValueSelect"));
						generalSurgerySpeciality.setGeneralizedLymphadenopathyTxtValue(box.getString("lymphadenopathyValue2"));
						generalSurgerySpeciality.setEdema(box.getString("edema"));
						generalSurgerySpeciality.setBones(box.getString("bones"));
						generalSurgerySpeciality.setGenitalia(box.getString("genitalia"));
						generalSurgerySpeciality.setJoints(box.getString("joints"));
						generalSurgerySpeciality.setNails(box.getString("nails"));
						generalSurgerySpeciality.setNerves(box.getString("nerves"));
						generalSurgerySpeciality.setScalp(box.getString("scalp"));
						generalSurgerySpeciality.setSkin(box.getString("skin"));
						generalSurgerySpeciality.setSkull(box.getString("skull"));
						generalSurgerySpeciality.setSpine(box.getString("spine"));
						generalSurgerySpeciality.setVessels(box.getString("vessels"));
						/*generalSurgerySpeciality.setHeight(box.getString("height"));
						generalSurgerySpeciality.setWeight(box.getString("weight "));
						generalSurgerySpeciality.setBmi(box.getString("bmi"));
						generalSurgerySpeciality.setBp(box.getString("bp"));
						generalSurgerySpeciality.setMm(box.getString("mm"));*/
						generalSurgerySpeciality.setJvp(box.getString("jvp"));
						//generalSurgerySpeciality.setSp(box.getString("sp"));
						
						generalSurgerySpeciality.setPulseRate(box.getString("pulseRate"));
						generalSurgerySpeciality.setPulseRhythm(box.getString("pulseRhythm")); 
						generalSurgerySpeciality.setPulseVolume(box.getString("pulseVolume")); 
						generalSurgerySpeciality.setPulseVesselWall(box.getString("pulseVesselWall")); 
						
						generalSurgerySpeciality.setRespirationRate(box.getString("respirationRate"));
						generalSurgerySpeciality.setRespirationRhythm(box.getString("respirationRhythm")); 
						generalSurgerySpeciality.setRespirationType(box.getString("respirationType"));
						generalSurgerySpeciality.setAsaGrade(box.getString("asaGrade"));
					
						generalSurgerySpeciality.setLesion(box.getString("lesion"));
						generalSurgerySpeciality.setLesionType(box.getString("lesionType"));
						generalSurgerySpeciality.setLesionSite(box.getString("lesionSite"));
						generalSurgerySpeciality.setLesionSize(box.getString("lesionSize"));
						generalSurgerySpeciality.setLesionSurface(box.getString("lesionSurface"));
						generalSurgerySpeciality.setLesionShape(box.getString("lesionShape"));
						generalSurgerySpeciality.setLesionConsistency(box.getString("lesionConsistency"));
						generalSurgerySpeciality.setLesionMobility(box.getString("lesionMobility"));
						generalSurgerySpeciality.setLesionPlane(box.getString("lesionPlane"));
						generalSurgerySpeciality.setLesionOthers(box.getString("lesionOthers"));
						
						generalSurgerySpeciality.setLocalLymph(box.getString("localLymph"));
						generalSurgerySpeciality.setLocalLymphType(box.getString("localLymphType"));
						generalSurgerySpeciality.setLocalLymphSite(box.getString("localLymphSite"));
						generalSurgerySpeciality.setLocalLymphSize(box.getString("localLymphSize"));
						generalSurgerySpeciality.setLocalLymphSurface(box.getString("localLymphSurface"));
						generalSurgerySpeciality.setLocalLymphShape(box.getString("localLymphShape"));
						generalSurgerySpeciality.setLocalLymphConsistency(box.getString("localLymphConsistency"));
						generalSurgerySpeciality.setLocalLymphMobility(box.getString("localLymphMobility"));
						generalSurgerySpeciality.setLocalLymphOthers(box.getString("localLymphOthers"));
						
						generalSurgerySpeciality.setLocalVessel(box.getString("localVessel"));
						generalSurgerySpeciality.setLocalVesselFlowVolume(box.getString("localVesselFlowVolume"));
						generalSurgerySpeciality.setLocalVesselBruit(box.getString("localVesselBruit"));
						generalSurgerySpeciality.setLocalVesselOthers(box.getString("localVesselOthers"));
						
						
						generalSurgerySpeciality.setLocalNerves(box.getString("localNerves"));
						generalSurgerySpeciality.setLocalNervesSensory(box.getString("localNervesSensory"));
						generalSurgerySpeciality.setLocalNervesMotor(box.getString("localNervesMotor"));
						generalSurgerySpeciality.setLocalNervesOthers(box.getString("localNervesOthers"));
						
						generalSurgerySpeciality.setLocalJoints(box.getString("localJoints"));
						generalSurgerySpeciality.setLocalJointsMovements(box.getString("localJointsMovements"));
						
						
						generalSurgerySpeciality.setOralCavity(box.getString("oralCavity"));
						generalSurgerySpeciality.setTongue(box.getString("tongue"));
						generalSurgerySpeciality.setThroat(box.getString("throat"));
						generalSurgerySpeciality.setAbdomen(box.getString("abdomen"));
						generalSurgerySpeciality.setGastroIntestinalTenderness(box.getString("gastroIntestinalTenderness"));
						generalSurgerySpeciality.setGastroIntestinalTendernessSite(box.getString("gastroIntestinalTendernessSite"));
						generalSurgerySpeciality.setGastroIntestinalTendernessType(box.getString("gastroIntestinalTendernessType"));
						generalSurgerySpeciality.setSwellingCheck(box.getString("swelswellingWnllings"));
						generalSurgerySpeciality.setSwellings(box.getString("swellings"));
						generalSurgerySpeciality.setLiverCheck(box.getString("liverWnl"));
						
						generalSurgerySpeciality.setLiver(box.getString("liver"));
						generalSurgerySpeciality.setRenalAngles(box.getString("renalAngles"));
						generalSurgerySpeciality.setTraubeSpace(box.getString("traubeSpace"));
						generalSurgerySpeciality.setAscites(box.getString("ascites"));
						generalSurgerySpeciality.setFluidThrill(box.getString("FluidThrill"));
						generalSurgerySpeciality.setBruit(box.getString("bruit"));
						generalSurgerySpeciality.setGastroIntestinalBruitSite(box.getString("gastroIntestinalBruitSite"));
						generalSurgerySpeciality.setGastroIntestinalBruitType(box.getString("gastroIntestinalBruitType"));
						generalSurgerySpeciality.setPrExamination(box.getString("prExamination"));
						generalSurgerySpeciality.setExternalGenitalia(box.getString("externalGenitalia"));
						
						
						generalSurgerySpeciality.setAirentry(box.getString("airEntry"));
						generalSurgerySpeciality.setRespiratoryTenderness(box.getString("respiratoryTenderness"));
						generalSurgerySpeciality.setRespiratoryTendernessSite(box.getString("respiratoryTendernessSite"));
						generalSurgerySpeciality.setRespiratoryTendernessType(box.getString("respiratoryTendernessType"));
						
						generalSurgerySpeciality.setRhonchi(box.getString("rhonchi"));
						generalSurgerySpeciality.setRespiratoryRhonchiSite(box.getString("rhonchiSite"));
						generalSurgerySpeciality.setRespiratoryRhonchiType(box.getString("rhonchiType"));
						
						generalSurgerySpeciality.setRespiratoryCrepitaions(box.getString("respiratoryCrepitaions"));
						generalSurgerySpeciality.setRespiratoryCrepitaionsSite(box.getString("respiratoryCrepitaionsSite"));
						generalSurgerySpeciality.setRespiratoryCrepitaionsType(box.getString("respiratoryCrepitaionsType"));
						
						
						generalSurgerySpeciality.setSounds(box.getString("sounds"));
						generalSurgerySpeciality.setCardiomegaly(box.getString("cardiomegaly"));
						
						
						generalSurgerySpeciality.setGcs(box.getString("GCS"));
						generalSurgerySpeciality.setGcsTotal(box.getString("totalSourceGCSS"));
						generalSurgerySpeciality.setEyeOpeningResponse(box.getString("eyeOpeningResponse"));
						generalSurgerySpeciality.setVerbalResponse(box.getString("verbalResponse"));
						generalSurgerySpeciality.setMotorResponse(box.getString("motorResponse"));
						generalSurgerySpeciality.setHeadInjuryClassification(box.getString("headInjury"));
						
						
						
						
						
						generalSurgerySpeciality.setCranialNerves(box.getString("cranialNerves"));
						generalSurgerySpeciality.setReflexes(box.getString("reflexes"));
						generalSurgerySpeciality.setMusculoskeletalMusclePower(box.getString("musclePower"));
						generalSurgerySpeciality.setMusculoskeletalJoints(box.getString("musculoskeletalJoints"));
						generalSurgerySpeciality.setPlan(box.getString("plan"));
						//generalSurgerySpeciality.setGeneralExamination(box.getString("plan"));
						
						Patient patient = new Patient();
						patient.setId(hinId);
						generalSurgerySpeciality.setHin(patient);
				
							
						OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
						opdPatientDetails.setId(opdPatientDetailId);
						generalSurgerySpeciality.setOpdPatientDetails(opdPatientDetails);
						
						
						
						hbt.save(generalSurgerySpeciality);
						map.put("tempalteName","General Surgery");
								
			
			
						tx.commit();
					
					}catch(Exception e){
						e.printStackTrace();
					}
					
					return map;
					}
				
				//added by govind 23-9-2016 end
				@Override
				public Map<String, Object> showNeonatalSpecialityScreenJsp(int inpatientId, String motherHinNo,int hinId) {
					Session session=(Session)getSession();
					Map<String,Object> map=new HashMap<String,Object>();
					
					List<Inpatient> ipList=new ArrayList<Inpatient>();
					ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", inpatientId)).list();
					
					List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
					bloodGroupList = session.createCriteria(MasBloodGroup.class).addOrder(Order.asc("BloodGroupName")).list();

					List<BabyDetails> babyDetailsList=new ArrayList<BabyDetails>();
					babyDetailsList=session.createCriteria(BabyDetails.class).createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId)).list();
					
					List<Patient> patientList=new ArrayList<Patient>();
					patientList=session.createCriteria(Patient.class)
							.add(Restrictions.eq("Id", hinId))
							
							//.add(Restrictions.eq("HinNo", motherHinNo))
							.list();
					List<Patient> motherPatientList=new ArrayList<Patient>();
					motherPatientList=session.createCriteria(Patient.class)
							.add(Restrictions.eq("HinNo", motherHinNo))
							.list();
					List<OpdNeonatalSpeciality> opdNeonatalSpecialityList =  new ArrayList<OpdNeonatalSpeciality>();
					opdNeonatalSpecialityList = session.createCriteria(OpdNeonatalSpeciality.class).add(Restrictions.eq("Hin.Id", hinId)).list();
					logger.info(hinId+"hinId");
					Date doa=null;
					for(Inpatient ip:ipList){
						doa=ip.getDateOfAddmission();
					}
					
					Date dob=null;
					for(Patient b:patientList){
						dob=b.getDateOfBirth();
					}
					String currentAge="";
					if(dob!=null){
						currentAge = HMSUtil.getDifferenceBetweenTwoDates(dob,doa);
					}					
					logger.info(babyDetailsList.size()+"---------");
					logger.info(ipList.size()+"---------");
					map.put("babyDetailsList",babyDetailsList);
					map.put("patientList",patientList);
					map.put("opdNeonatalSpecialityList",opdNeonatalSpecialityList);
					map.put("ipList",ipList);
					map.put("motherPatientList",motherPatientList);
					map.put("bloodGroupList",bloodGroupList);
					
					map.put("currentAge",currentAge);
					return map;
				}

				@Override
				public Map<String, Object> saveNeonatal(Box box) {
					Map<String,Object>map = new HashMap<String,Object>();
					
					try{
						Session session = (Session) getSession();
						Transaction tx=session.beginTransaction();
						HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
								
						
						int opdPatientDetailId = 0;;
						if (box.getInt("opdPatientDetailId") != 0){
							opdPatientDetailId = box.getInt("opdPatientDetailId");
						}
						int hinId=0;
						if(box.getInt("hinId") !=0){
							hinId=box.getInt("hinId");	
						}
						
						List<OpdNeonatalSpeciality> opdNeonatalSpecialityIdList =  new ArrayList<OpdNeonatalSpeciality>();
						opdNeonatalSpecialityIdList = session.createCriteria(OpdNeonatalSpeciality.class).add(Restrictions.eq("Hin.Id", hinId)).list();
						
						 
						if(opdNeonatalSpecialityIdList.size()>0)
						{
							int opdNeonatalSpecialityId = 0;
							for (OpdNeonatalSpeciality n : opdNeonatalSpecialityIdList) {
								opdNeonatalSpecialityId = n.getId();
							}
							OpdNeonatalSpeciality opdNeonatalSpeciality = (OpdNeonatalSpeciality) hbt
									.load(OpdNeonatalSpeciality.class, opdNeonatalSpecialityId);
							opdNeonatalSpeciality.setAbortion(box.getString("abortion"));
							opdNeonatalSpeciality.setAgeOfMarriage(box.getString("ageOfMarriage"));
							opdNeonatalSpeciality.setAmnioticFluid(box.getString("amnioticFluid"));
							opdNeonatalSpeciality.setAmnioticFluidVolume(box.getString("amnioticFluidVolume"));
							opdNeonatalSpeciality.setAntenatalSteroids(box.getString("antenatalSteroids"));
							opdNeonatalSpeciality.setAntenatalSteroidsYes(box.getString("antenatalSteroidsYes"));
							opdNeonatalSpeciality.setApgarAtFiveMin(box.getString("apgarAtFiveMin"));
							opdNeonatalSpeciality.setApgarAtOneMin(box.getString("apgarAtOneMin"));
							opdNeonatalSpeciality.setAph(box.getString("aph"));
							opdNeonatalSpeciality.setApnea(box.getString("apnea"));
							opdNeonatalSpeciality.setAttachment(box.getString("attachment"));
							opdNeonatalSpeciality.setBbsAg(box.getString("bbsAg"));
							opdNeonatalSpeciality.setBirthSpacing(box.getString("birthSpacing"));
							opdNeonatalSpeciality.setBleeding(box.getString("bleeding"));
							opdNeonatalSpeciality.setBleedingYes(box.getString("bleedingYes"));
							opdNeonatalSpeciality.setBloodGroup(box.getString("bloodGroup"));
							opdNeonatalSpeciality.setBloodSugar(box.getString("bloodSugar"));
							opdNeonatalSpeciality.setBreastFed(box.getString("breastFed"));
							opdNeonatalSpeciality.setBulgingAnteriorFontanel(box.getString("bulgingAnteriorFontanel"));
							opdNeonatalSpeciality.setChestInDrawing(box.getString("chestInDrawing"));
							opdNeonatalSpeciality.setCourseOfLabour(box.getString("courseOfLabour"));
							opdNeonatalSpeciality.setCns(box.getString("cns"));
							opdNeonatalSpeciality.setBWeight(box.getString("bWeight"));
							opdNeonatalSpeciality.setAgeOnAdmission(box.getString("ageOnAdmission"));
							opdNeonatalSpeciality.setMotherAge(box.getString("motherAge"));
							opdNeonatalSpeciality.setBirthRegNo(box.getString("birthRegNo"));
							opdNeonatalSpeciality.setBWt(box.getString("bwt"));
							opdNeonatalSpeciality.setWtOnAdmission(box.getString("wtOnAdmission"));
							opdNeonatalSpeciality.setBTime(box.getString("bTime"));
							
							
							
							opdNeonatalSpeciality.setColor(box.getString("color"));
							opdNeonatalSpeciality.setCongenitalMalformation(box.getString("congenitalMalformation"));
							opdNeonatalSpeciality.setCongenitalMalformationAnother(box.getString("congenitalMalformationAnother"));
							opdNeonatalSpeciality.setCongenitalMalformationAnotherOtherText(box.getString("congenitalMalformationAnotherOtherText"));
							opdNeonatalSpeciality.setConsanguinity(box.getString("consanguinity"));
							opdNeonatalSpeciality.setConvulsions(box.getString("convulsions"));
							opdNeonatalSpeciality.setCriedImmedAfterBirth(box.getString("criedImmedAfterBirth"));
							opdNeonatalSpeciality.setCrt(box.getString("crt"));
							opdNeonatalSpeciality.setCvs(box.getString("cvs"));
							opdNeonatalSpeciality.setDays(box.getString("days"));
							opdNeonatalSpeciality.setDeliveryAttendedBy(box.getString("deliveryAttendedBy"));
							opdNeonatalSpeciality.setDeliveryAttendedByOtherText(box.getString("deliveryAttendedByOtherText"));
							opdNeonatalSpeciality.setDrug(box.getString("drug"));
							opdNeonatalSpeciality.setDrugText(box.getString("drugText"));
							opdNeonatalSpeciality.setEdd(HMSUtil.convertStringTypeDateToDateType(box.getString("eddd")));
							opdNeonatalSpeciality.setEoFeotalDistress(box.getString("eoFeotalDistress"));
							opdNeonatalSpeciality.setFinalDiagnosisA(box.getString("finalDiagnosisA"));
							opdNeonatalSpeciality.setFinalDiagnosisB(box.getString("finalDiagnosisB"));
							opdNeonatalSpeciality.setFinalDiagnosisC(box.getString("finalDiagnosisC"));
							opdNeonatalSpeciality.setFinalDiagnosisD(box.getString("finalDiagnosisD"));
							opdNeonatalSpeciality.setFinalDiagnosisE(box.getString("finalDiagnosisE"));
							opdNeonatalSpeciality.setFoulSmellingDischarge(box.getString("foulSmellingDischarge"));
							opdNeonatalSpeciality.setGdm(box.getString("gdm"));
							opdNeonatalSpeciality.setGeneralCondition(box.getString("generalCondition"));
							opdNeonatalSpeciality.setGestationalAge(box.getString("gestationalAge"));
							opdNeonatalSpeciality.setGestationWeeks(box.getString("gestationWeeks"));
							opdNeonatalSpeciality.setGravida(box.getString("gravida"));
							opdNeonatalSpeciality.setGrunting(box.getString("grunting"));
							opdNeonatalSpeciality.setHb(box.getString("hb"));
							opdNeonatalSpeciality.setHeadCircumference(box.getString("headCircumference"));
							opdNeonatalSpeciality.setHivTesting(box.getString("hivTesting"));
							opdNeonatalSpeciality.setHoFever(box.getString("hoFever"));
							opdNeonatalSpeciality.setIllness(box.getString("illness"));
							opdNeonatalSpeciality.setIllnessOtherText(box.getString("illnessOtherText"));
							opdNeonatalSpeciality.setIndicationA(box.getString("indicationA"));
							opdNeonatalSpeciality.setIndicationB(box.getString("indicationB"));
							opdNeonatalSpeciality.setIndicationC(box.getString("indicationC"));
							opdNeonatalSpeciality.setIndicationD(box.getString("indicationD"));
							opdNeonatalSpeciality.setIndicationE(box.getString("indicationE"));
							opdNeonatalSpeciality.setIndicationForCaesareanApplicable(box.getString("indicationForCaesareanApplicable"));
							opdNeonatalSpeciality.setIndicationForCaesareanApplicableotherText(box.getString("indicationForCaesareanApplicableOtherText"));
							opdNeonatalSpeciality.setJaundice(box.getString("jaundice"));
							opdNeonatalSpeciality.setJaundiceYes(box.getString("jaundiceYes"));
							opdNeonatalSpeciality.setLabour(box.getString("labour"));
							opdNeonatalSpeciality.setLeasking(box.getString("leasking"));
							opdNeonatalSpeciality.setLength(box.getString("length"));
							opdNeonatalSpeciality.setLmp(HMSUtil.convertStringTypeDateToDateType(box.getString("lmpp")));
							opdNeonatalSpeciality.setLiveBirth(box.getString("liveBirth"));
							opdNeonatalSpeciality.setOtherSignificantFinding(box.getString("otherSignificantFinding"));
							opdNeonatalSpeciality.setOtherSignificantInformation(box.getString("otherSignificantInformation"));
							opdNeonatalSpeciality.setOtherSignificantInformationgeneral(box.getString("otherSignificantInformationGeneral"));
							opdNeonatalSpeciality.setOtherSignificantInformationLabour(box.getString("otherSignificantInformationLabour"));
							opdNeonatalSpeciality.setOxygenSaturation(box.getString("oxygenSaturation"));
							opdNeonatalSpeciality.setMaturity(box.getString("maturity"));
							opdNeonatalSpeciality.setMeconiumStainedCord(box.getString("meconiumStainedCord"));
							opdNeonatalSpeciality.setModeOfTransport(box.getString("modeOfTransport"));
							opdNeonatalSpeciality.setMotherWt(box.getString("motherWt"));
							opdNeonatalSpeciality.setNoseOfDoses(box.getString("noseOfDoses"));
							opdNeonatalSpeciality.setPara(box.getString("para"));
							opdNeonatalSpeciality.setPerAbdomen(box.getString("perAbdomen"));
							opdNeonatalSpeciality.setPih(box.getString("pih"));
							opdNeonatalSpeciality.setPihLabour(box.getString("pihLabour"));
							opdNeonatalSpeciality.setPlaceOfDelivery(box.getString("placeOfDelivery"));
							opdNeonatalSpeciality.setPlantarUlcer(box.getString("plantarUlcer"));
							opdNeonatalSpeciality.setPph(box.getString("pph"));
							opdNeonatalSpeciality.setPresentation(box.getString("presentation"));
							opdNeonatalSpeciality.setPresentingComplaints(box.getString("presentingComplaints"));
							opdNeonatalSpeciality.setRadiation(box.getString("radiation"));
							opdNeonatalSpeciality.setRespiratory(box.getString("respiratory"));
							opdNeonatalSpeciality.setResuscitationRequired(box.getString("resuscitationRequired"));
							opdNeonatalSpeciality.setSkinPinch(box.getString("skinPinch"));
							opdNeonatalSpeciality.setSkinPustules(box.getString("skinPustules"));
							opdNeonatalSpeciality.setSucking(box.getString("sucking"));
							opdNeonatalSpeciality.setUmbilious(box.getString("umbilious"));
							opdNeonatalSpeciality.setUterineTenderness(box.getString("uterineTenderness"));
							opdNeonatalSpeciality.setVdrl(box.getString("vdrl"));
							opdNeonatalSpeciality.setVitaminKGiven(box.getString("vitaminKGiven"));
							opdNeonatalSpeciality.setTakingBreastFeeds(box.getString("takingBreastFeeds"));
							opdNeonatalSpeciality.setThyroid(box.getString("thyroid"));
							opdNeonatalSpeciality.setTimeBetweenLastDoseDelivery(box.getString("timeBetweenLastDoseDelivery"));
							opdNeonatalSpeciality.setTone(box.getString("tone"));
							opdNeonatalSpeciality.setTtDoses(box.getString("ttDoses"));
							opdNeonatalSpeciality.setTypeOfAdmission(box.getString("typeOfAdmission"));
							opdNeonatalSpeciality.setTypeOfDelivery(box.getString("typeOfDelivery"));
							
									
									Patient patient = new Patient();
									patient.setId(hinId);
									opdNeonatalSpeciality.setHin(patient);
							
										
									OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
									opdPatientDetails.setId(opdPatientDetailId);
									opdNeonatalSpeciality.setOpdPatientDetails(opdPatientDetails);
									
									
									
									hbt.update(opdNeonatalSpeciality);
									map.put("tempalteName","Neonatal");
							
						}else{
						
							OpdNeonatalSpeciality opdNeonatalSpeciality = new OpdNeonatalSpeciality();
							opdNeonatalSpeciality.setAbortion(box.getString("abortion"));
							opdNeonatalSpeciality.setAgeOfMarriage(box.getString("ageOfMarriage"));
							opdNeonatalSpeciality.setAmnioticFluid(box.getString("amnioticFluid"));
							opdNeonatalSpeciality.setAmnioticFluidVolume(box.getString("amnioticFluidVolume"));
							opdNeonatalSpeciality.setAntenatalSteroids(box.getString("antenatalSteroids"));
							opdNeonatalSpeciality.setAntenatalSteroidsYes(box.getString("antenatalSteroidsYes"));
							opdNeonatalSpeciality.setApgarAtFiveMin(box.getString("apgarAtFiveMin"));
							opdNeonatalSpeciality.setApgarAtOneMin(box.getString("apgarAtOneMin"));
							opdNeonatalSpeciality.setAph(box.getString("aph"));
							opdNeonatalSpeciality.setApnea(box.getString("apnea"));
							opdNeonatalSpeciality.setAttachment(box.getString("attachment"));
							opdNeonatalSpeciality.setBbsAg(box.getString("bbsAg"));
							opdNeonatalSpeciality.setMotherAge(box.getString("motherAge"));
							opdNeonatalSpeciality.setBirthSpacing(box.getString("birthSpacing"));
							opdNeonatalSpeciality.setBleeding(box.getString("bleeding"));
							opdNeonatalSpeciality.setBleedingYes(box.getString("bleedingYes"));
							opdNeonatalSpeciality.setBloodGroup(box.getString("bloodGroup"));
							opdNeonatalSpeciality.setBloodSugar(box.getString("bloodSugar"));
							opdNeonatalSpeciality.setBreastFed(box.getString("breastFed"));
							opdNeonatalSpeciality.setBulgingAnteriorFontanel(box.getString("bulgingAnteriorFontanel"));
							opdNeonatalSpeciality.setChestInDrawing(box.getString("chestInDrawing"));
							opdNeonatalSpeciality.setCourseOfLabour(box.getString("courseOfLabour"));
							opdNeonatalSpeciality.setCns(box.getString("cns"));
							opdNeonatalSpeciality.setBWeight(box.getString("bWeight"));
							opdNeonatalSpeciality.setAgeOnAdmission(box.getString("ageOnAdmission"));
							opdNeonatalSpeciality.setBirthRegNo(box.getString("birthRegNo"));
							opdNeonatalSpeciality.setBWt(box.getString("bwt"));
							opdNeonatalSpeciality.setWtOnAdmission(box.getString("wtOnAdmission"));
							opdNeonatalSpeciality.setBTime(box.getString("bTime"));
							
							
							
							opdNeonatalSpeciality.setColor(box.getString("color"));
							opdNeonatalSpeciality.setCongenitalMalformation(box.getString("congenitalMalformation"));
							opdNeonatalSpeciality.setCongenitalMalformationAnother(box.getString("congenitalMalformationAnother"));
							opdNeonatalSpeciality.setCongenitalMalformationAnotherOtherText(box.getString("congenitalMalformationAnotherOtherText"));
							opdNeonatalSpeciality.setConsanguinity(box.getString("consanguinity"));
							opdNeonatalSpeciality.setConvulsions(box.getString("convulsions"));
							opdNeonatalSpeciality.setCriedImmedAfterBirth(box.getString("criedImmedAfterBirth"));
							opdNeonatalSpeciality.setCrt(box.getString("crt"));
							opdNeonatalSpeciality.setCvs(box.getString("cvs"));
							opdNeonatalSpeciality.setDays(box.getString("days"));
							opdNeonatalSpeciality.setDeliveryAttendedBy(box.getString("deliveryAttendedBy"));
							opdNeonatalSpeciality.setDeliveryAttendedByOtherText(box.getString("deliveryAttendedByOtherText"));
							opdNeonatalSpeciality.setDrug(box.getString("drug"));
							opdNeonatalSpeciality.setDrugText(box.getString("drugText"));
							opdNeonatalSpeciality.setEdd(HMSUtil.convertStringTypeDateToDateType(box.getString("eddd")));
							opdNeonatalSpeciality.setEoFeotalDistress(box.getString("eoFeotalDistress"));
							opdNeonatalSpeciality.setFinalDiagnosisA(box.getString("finalDiagnosisA"));
							opdNeonatalSpeciality.setFinalDiagnosisB(box.getString("finalDiagnosisB"));
							opdNeonatalSpeciality.setFinalDiagnosisC(box.getString("finalDiagnosisC"));
							opdNeonatalSpeciality.setFinalDiagnosisD(box.getString("finalDiagnosisD"));
							opdNeonatalSpeciality.setFinalDiagnosisE(box.getString("finalDiagnosisE"));
							opdNeonatalSpeciality.setFoulSmellingDischarge(box.getString("foulSmellingDischarge"));
							opdNeonatalSpeciality.setGdm(box.getString("gdm"));
							opdNeonatalSpeciality.setGeneralCondition(box.getString("generalCondition"));
							opdNeonatalSpeciality.setGestationalAge(box.getString("gestationalAge"));
							opdNeonatalSpeciality.setGestationWeeks(box.getString("gestationWeeks"));
							opdNeonatalSpeciality.setGravida(box.getString("gravida"));
							opdNeonatalSpeciality.setGrunting(box.getString("grunting"));
							opdNeonatalSpeciality.setHb(box.getString("hb"));
							opdNeonatalSpeciality.setHeadCircumference(box.getString("headCircumference"));
							opdNeonatalSpeciality.setHivTesting(box.getString("hivTesting"));
							opdNeonatalSpeciality.setHoFever(box.getString("hoFever"));
							opdNeonatalSpeciality.setIllness(box.getString("illness"));
							opdNeonatalSpeciality.setIllnessOtherText(box.getString("illnessOtherText"));
							opdNeonatalSpeciality.setIndicationA(box.getString("indicationA"));
							opdNeonatalSpeciality.setIndicationB(box.getString("indicationB"));
							opdNeonatalSpeciality.setIndicationC(box.getString("indicationC"));
							opdNeonatalSpeciality.setIndicationD(box.getString("indicationD"));
							opdNeonatalSpeciality.setIndicationE(box.getString("indicationE"));
							opdNeonatalSpeciality.setIndicationForCaesareanApplicable(box.getString("indicationForCaesareanApplicable"));
							opdNeonatalSpeciality.setIndicationForCaesareanApplicableotherText(box.getString("indicationForCaesareanApplicableOtherText"));
							opdNeonatalSpeciality.setJaundice(box.getString("jaundice"));
							opdNeonatalSpeciality.setJaundiceYes(box.getString("jaundiceYes"));
							opdNeonatalSpeciality.setLabour(box.getString("labour"));
							opdNeonatalSpeciality.setLeasking(box.getString("leasking"));
							opdNeonatalSpeciality.setLength(box.getString("length"));
							opdNeonatalSpeciality.setLmp(HMSUtil.convertStringTypeDateToDateType(box.getString("lmpp")));
							opdNeonatalSpeciality.setLiveBirth(box.getString("liveBirth"));
							opdNeonatalSpeciality.setOtherSignificantFinding(box.getString("otherSignificantFinding"));
							opdNeonatalSpeciality.setOtherSignificantInformation(box.getString("otherSignificantInformation"));
							opdNeonatalSpeciality.setOtherSignificantInformationgeneral(box.getString("otherSignificantInformationGeneral"));
							opdNeonatalSpeciality.setOtherSignificantInformationLabour(box.getString("otherSignificantInformationLabour"));
							opdNeonatalSpeciality.setOxygenSaturation(box.getString("oxygenSaturation"));
							opdNeonatalSpeciality.setMaturity(box.getString("maturity"));
							opdNeonatalSpeciality.setMeconiumStainedCord(box.getString("meconiumStainedCord"));
							opdNeonatalSpeciality.setModeOfTransport(box.getString("modeOfTransport"));
							opdNeonatalSpeciality.setMotherWt(box.getString("motherWt"));
							opdNeonatalSpeciality.setNoseOfDoses(box.getString("noseOfDoses"));
							opdNeonatalSpeciality.setPara(box.getString("para"));
							opdNeonatalSpeciality.setPerAbdomen(box.getString("perAbdomen"));
							opdNeonatalSpeciality.setPih(box.getString("pih"));
							opdNeonatalSpeciality.setPihLabour(box.getString("pihLabour"));
							opdNeonatalSpeciality.setPlaceOfDelivery(box.getString("placeOfDelivery"));
							opdNeonatalSpeciality.setPlantarUlcer(box.getString("plantarUlcer"));
							opdNeonatalSpeciality.setPph(box.getString("pph"));
							opdNeonatalSpeciality.setPresentation(box.getString("presentation"));
							opdNeonatalSpeciality.setPresentingComplaints(box.getString("presentingComplaints"));
							opdNeonatalSpeciality.setRadiation(box.getString("radiation"));
							opdNeonatalSpeciality.setRespiratory(box.getString("respiratory"));
							opdNeonatalSpeciality.setResuscitationRequired(box.getString("resuscitationRequired"));
							opdNeonatalSpeciality.setSkinPinch(box.getString("skinPinch"));
							opdNeonatalSpeciality.setSkinPustules(box.getString("skinPustules"));
							opdNeonatalSpeciality.setSucking(box.getString("sucking"));
							opdNeonatalSpeciality.setUmbilious(box.getString("umbilious"));
							opdNeonatalSpeciality.setUterineTenderness(box.getString("uterineTenderness"));
							opdNeonatalSpeciality.setVdrl(box.getString("vdrl"));
							opdNeonatalSpeciality.setVitaminKGiven(box.getString("vitaminKGiven"));
							opdNeonatalSpeciality.setTakingBreastFeeds(box.getString("takingBreastFeeds"));
							opdNeonatalSpeciality.setThyroid(box.getString("thyroid"));
							opdNeonatalSpeciality.setTimeBetweenLastDoseDelivery(box.getString("timeBetweenLastDoseDelivery"));
							opdNeonatalSpeciality.setTone(box.getString("tone"));
							opdNeonatalSpeciality.setTtDoses(box.getString("ttDoses"));
							opdNeonatalSpeciality.setTypeOfAdmission(box.getString("typeOfAdmission"));
							opdNeonatalSpeciality.setTypeOfDelivery(box.getString("typeOfDelivery"));
							
									
									Patient patient = new Patient();
									patient.setId(hinId);
									opdNeonatalSpeciality.setHin(patient);
							
										
									OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
									opdPatientDetails.setId(opdPatientDetailId);
									opdNeonatalSpeciality.setOpdPatientDetails(opdPatientDetails);
									
									
									
									hbt.save(opdNeonatalSpeciality);
									map.put("tempalteName","Neonatal");
						}
				
						
						
						
										
						tx.commit();
						
					}catch(Exception e){
						e.printStackTrace();
					}
					
					return map;
				}
				
				
				// added by amit das on 20-12-2016
				public Map<String, Object> getHospitalData(Map<String, Object> objectMap) {
					logger.info("Method getHospitalData()");
					Map<String, Object> map = new HashMap<String, Object>();
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

				@Override
				public Map<String, Object> showPatientLabResultIP(Box box) {
					Map<String, Object> map = new HashMap<String, Object>();
					List<Integer>maxDgOrderhdList = new ArrayList<Integer>();
					List<DgOrderhd>dgOrderhdList = new ArrayList<DgOrderhd>();
					List<DgOrderdt>dgOrderDtList = new ArrayList<DgOrderdt>();
					List<DgOrderdt>dgOrderDtListId = new ArrayList<DgOrderdt>();
					List<Integer>dgOrderList = new ArrayList<Integer>();
					Session session = (Session) getSession();
					
					int dgorderHdId = 0;
					dgOrderhdList = session.createCriteria(DgOrderhd.class)
									.createAlias("Inpatient", "hin").add(Restrictions.eq("hin.Id", box.getInt("hinId"))).list();
					
					maxDgOrderhdList = session.createCriteria(DgOrderhd.class).createAlias("Inpatient", "hin")
							.add(Restrictions.eq("hin.Id", box.getInt("hinId"))).setProjection(Projections.max("Id")).list();
					
					dgOrderDtListId = session.createCriteria(DgOrderdt.class)
							               .createAlias("Orderhd", "header")
							               .createAlias("header.Inpatient", "hin")
							               .createAlias("ChargeCode", "chargeCode")
							               .add(Restrictions.eq("OrderStatus","P"))
							               .add(Restrictions.eq("header.OrderStatus","P"))
							               .add(Restrictions.eq("header.OrderDate",new Date()))
							               .add(Restrictions.eq("hin.Id", box.getInt("hinId")))
							               .setProjection(Projections.property("chargeCode.Id")).list();
					Iterator it=dgOrderDtListId.iterator();
					while(it.hasNext())
					{
					    String s = it.next().toString();
					    dgOrderList.add(Integer.parseInt(s));
					   
					    // ---- print -----
					}
					
					String orderNo="";
					int OrderId=0;
					if(maxDgOrderhdList.size()>0){
						if(maxDgOrderhdList.get(0) != null && maxDgOrderhdList.get(0) != 0){
						dgorderHdId =maxDgOrderhdList.get(0);
						logger.info("dgorderHdId "+dgorderHdId);
						dgOrderDtList = session.createCriteria(DgOrderdt.class).createAlias("Orderhd", "header")
								.add(Restrictions.eq("header.Id", maxDgOrderhdList.get(0))).list();
						}
					}
					
					if(dgOrderDtList.size()>0){
						orderNo=dgOrderDtList.get(0).getOrderhd().getOrderNo();
						OrderId=dgOrderDtList.get(0).getOrderhd().getId();
					}
					
					logger.info("orderNo  "+dgOrderDtList.size());
					map.put("orderNo",orderNo);
					map.put("OrderId",OrderId);
					map.put("dgOrderList",dgOrderList);
					map.put("dgOrderDtList",dgOrderDtList);
					map.put("dgOrderhdList",dgOrderhdList);
					map.put("dgorderHdId",dgorderHdId);
					return map;
				}

				@Override
				public Map<String, Object> searchIPStickerReprint(
						Map<String, Object> datamap) {
					Map<String, Object> map = new HashMap<String, Object>();
					Session session = (Session) getSession();
					List<Inpatient> inpatientList=new ArrayList<Inpatient>();
					Criteria criteria=null;
					int hospitalId=0;
					  if(datamap.get("hospitalId")!=null){
						  hospitalId=(Integer) datamap.get("hospitalId");
						  
					   }									
							
					   String hinNo=null,adNo=null;
					   if(datamap.get("hinNo")!=null){
						   hinNo=(String) datamap.get("hinNo");
					   }
					   if(datamap.get("adNo")!=null){
						   adNo=(String) datamap.get("adNo");
					   }
					   if(hinNo!=null || adNo!=null){
						   criteria=session.createCriteria(Inpatient.class)
									.createAlias("Hospital", "h")
									 .add(Restrictions.eq("h.Id", hospitalId))
									.addOrder(Order.desc("DateOfAddmission"));
					   }
					   if(hinNo!=null){
						   criteria.add(Restrictions.eq("HinNo", hinNo));
					   }
					   if(adNo!=null){
						   criteria.add(Restrictions.eq("AdNo", adNo));
					   }
					   
					   logger.info("hospitalId "+hospitalId+" hinNo "+hinNo+" adNo "+adNo);
					   
					   if(criteria!=null){
					   inpatientList=criteria.list();
					   }
					  /* if(inpatientList.size()==1){
						   map.put("inpatientList", inpatientList);
					   }
					   if(inpatientList.size()>1){
						   List<Inpatient> inpatientNew=new ArrayList<Inpatient>();
						   inpatientNew.add(inpatientList.get(0));
						   map.put("inpatientList", inpatientNew);
					   }*/
					   logger.info("inpatientList "+inpatientList.size());
					   map.put("inpatientList", inpatientList);
					return map;
				}
				@Override
				public Map<String, Object> getIPPrescriptionDetails(Box box) {
					Map<String,Object>map=new HashMap<String,Object>();
					Session session=(Session)getSession();
					List<InpatientPrescriptionDetails> ipPrescriptionList=new ArrayList<InpatientPrescriptionDetails>();
					List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
					List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
					List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
					int inpatientId=0;
					if(box.get("inpatientId")!=null){
						inpatientId=box.getInt("inpatientId");
					}
					logger.info("inpatientId "+inpatientId);
					ipPrescriptionList=session.createCriteria(InpatientPrescriptionDetails.class)
							.createAlias("Prescription", "Prescription")  
							.createAlias("Prescription.Inpatient", "IP")
							.add(Restrictions.eq("IP.Id",inpatientId))
							.add(Restrictions.or(Restrictions.ne("Prescription.DischargeMedicationStatus","Y").ignoreCase(),
									Restrictions.isNull("Prescription.DischargeMedicationStatus")))
							.list();
					logger.info("ipPrescriptionList "+ipPrescriptionList.size());
					routeOfAdministrationList = session
							.createCriteria(RouteOfAdministration.class)
							.add(Restrictions.eq("Status", "y".toLowerCase())
									.ignoreCase()).addOrder(Order.asc("OrderNo")).list();
					masInstructionMasterList = session
							.createCriteria(OpdInstructionTreatment.class)
							.add(Restrictions.eq("Status", "y").ignoreCase()).list();
					frequencyList = session.createCriteria(MasFrequency.class).list();
					map.put("ipPrescriptionList",ipPrescriptionList);	
					map.put("frequencyList", frequencyList);
					map.put("routeOfAdministrationList", routeOfAdministrationList);
					map.put("masInstructionMasterList", masInstructionMasterList);
					map.put("inpatientId", inpatientId);
					return map;
				}

				
	@Override
	public Map<String, Object> showPrescribedMedicineJspForNurse(Box box) {
		Map<String,Object>map=new HashMap<String,Object>();
	 	  List<OpdTemplate> templateList = new   ArrayList<OpdTemplate>();
		  List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
		  List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
		  List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
		  List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
		  List<NursingcareSetup> nursingCareSetupList = new ArrayList<NursingcareSetup>();
		  List<RsbyCardDetails> rsbyCardDetailsList = new ArrayList<RsbyCardDetails>();
		  //List<MasScheme> packageSchemeList = new ArrayList<MasScheme>(); 
		  List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		  List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>();
		  List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		 // List<Object[]> opdPatientDetailList = new ArrayList<Object[]>();
		  Session session=(Session)getSession();
		 Inpatient inpatient=null;
		 int inpatientId=0;
	      inpatientId=box.getInt("inpatientId");
	     
	     try {
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						inpatient=(Inpatient) hbt.get(Inpatient.class, inpatientId);
						
	  templateList =session.createCriteria(OpdTemplate.class) .createAlias("Department","dept").add( Restrictions.eq("dept.Id", box.getInt("deptId")))
					  						.add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
				  
	  routeOfAdministrationList=session.createCriteria(RouteOfAdministration.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
				  
	  masInstructionMasterList=session.createCriteria(OpdInstructionTreatment.class).add(Restrictions.eq("Status","y".toLowerCase()).ignoreCase()).list();
				  			
	  frequencyList =   session.createCriteria(MasFrequency.class).add(Restrictions.eq("Status", "y".toLowerCase()).ignoreCase()).list();
		
	  nursingCareList = session.createCriteria(MasNursingCare.class).add(Restrictions.eq("Status", "Y".toLowerCase()).ignoreCase()).list();
		
	  nursingCareSetupList = session .createCriteria(NursingcareSetup.class).add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
										.add(Restrictions.eq("Hospital.Id",box.getInt(HOSPITAL_ID))).list();
	  
	  inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.idEq(box.getInt("inpatientId"))).list(); 	
			if(inpatientList!=null && inpatientList.size()!=0){
				Patient patient =	hbt.load(Patient.class, inpatientList.get(0).getHin().getId());
				if(patient!=null && patient.getRsbyCardNo()!=null){
					rsbyCardDetailsList =	session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("RsbyCardNo", patient.getRsbyCardNo())).add(Restrictions.eq("Status", "y").ignoreCase()).list();
				}
			}
			
	  packageList = session.createCriteria(BlPackageHeader.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		  
      //packageSchemeList = session.createCriteria(MasScheme.class).add(Restrictions.eq("PackageFlag", "Y").ignoreCase()).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		  
	  packageServicesList = session.createCriteria(BlPackageServicesDetails.class).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
	  
	 /* opdPatientDetailList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Inpatient.Id", box.getInt("parent")))
			  .setProjection(Projections.projectionList().add(Projections.property("Id"))).list();
	  if(opdPatientDetailList.size()>0){
		  int opdId = 0;
		 for(Object[] opd : opdPatientDetailList){
			 if(opd[0] != null){
				  opdId = (Integer) 
				 map.put("opdId", opdId);
				  System.out.println("opdId=="+opdId);
			 }
		 }
	  }*/
	
				
	} catch (Exception e) {
		e.printStackTrace();
	}
     map.put("inpatient", inpatient);
     map.put("templateList", templateList);
     map.put("routeOfAdministrationList", routeOfAdministrationList);
     map.put("masInstructionMasterList", masInstructionMasterList);
     map.put("frequencyList", frequencyList);
 	 map.put("nursingCareSetupList", nursingCareSetupList);
	 map.put("nursingCareList", nursingCareList);
	 map.put("rsbyCardDetailsList", rsbyCardDetailsList);
	 map.put("packageList", packageList);
	 map.put("packageServicesList", packageServicesList);
	 return map;
	}

				

				@Override
				public Map<String, Object> submitMedicinePrescriptionByNurse(Box box) {
					Map<String,Object> map= new HashMap<String,Object>();
					int hdb = box.getInt("hdb");
					String pvms = "";
					Map<String,Object> mapForDS= new HashMap<String,Object>();
					mapForDS.put("userId", box.getInt("userId"));
					mapForDS.put("userName", box.getString("userName"));
					mapForDS.put("hospitalId", box.getInt("hospitalId"));
					Map<String,Object> utilMap = new HashMap<String,Object>();
					utilMap = (Map)HMSUtil.getCurrentDateAndTime();
					String consultationTime = (String)utilMap.get("currentTime");
					String consultationDate = (String)utilMap.get("currentDate");
					Session session=(Session)getSession();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					Transaction tx= null;
					boolean flag  =  false;
				 try {
					 tx = session.beginTransaction();
					for (int l = 1; l <= hdb; l++) {
						if(box.getString("pvmsNotreatment"+l)!=null && !box.getString("pvmsNotreatment"+l).equals(""))
						{
						pvms = box.getString("pvmsNotreatment"+l);
						break;
						}
					}
					
					//added by govind 27-10-2017
					int taperHdb =0;
					if(box.get("taperedMedicineHdb")!=null){
						taperHdb=box.getInt("taperedMedicineHdb");
				    }
					List<TaperedMedicineUtil> taperUtilList=new ArrayList<TaperedMedicineUtil>();
					for (int i = 0; i <=hdb; i++)  {
					Integer itemId =0;//System.out.println("i "+i);
					if (box.get("nomenclaturetreatment" + i)!=null && !box.getString("nomenclaturetreatment" + i).equals("")) {

						 String nomencls = box.getString("nomenclaturetreatment" + i);
						 logger.info("nomenclaturetreatment "+nomencls);
						 int index1 = nomencls.lastIndexOf("(");
							int index2 = nomencls.lastIndexOf(")");
							if(index1>=0 ){
								index1++;
								itemId = Integer.parseInt(nomencls.substring(index1,index2));
							}
								for(int t=1;t<=taperHdb;t++){
										if(box.get("taperedItemId"+i+"_"+t)!=null){
											Integer itemId2=box.getInt("taperedItemId"+i+"_"+t);
										if(itemId.equals(itemId2)){
											TaperedMedicineUtil tap=new TaperedMedicineUtil();
											tap.setItemId(box.getInt("taperedItemId"+i+"_"+t));
										if(box.get("taperedFrequency"+i+"_"+t)!=null){
											tap.setFrequency(box.getInt("taperedFrequency"+i+"_"+t));
										}
										if(box.get("taperedDosage"+i+"_"+t)!=null){
											tap.setDosage(box.getString("taperedDosage"+i+"_"+t));
										}
										if(box.get("taperedDosageCount"+i+"_"+t)!=null){
											tap.setDosageCount(new BigDecimal(box.getString("taperedDosageCount"+i+"_"+t)));
										}
										if(box.get("taperedDuration"+i+"_"+t)!=null){
											tap.setDuration(box.getInt("taperedDuration"+i+"_"+t));
										}
										if(box.get("total"+i+"_"+t)!=null){
											tap.setTotal(new BigDecimal(box.getString("total"+i+"_"+t)));
										}
										taperUtilList.add(tap);
									  }
									}
								}
							}
					}logger.info("taperUtilList "+taperUtilList.size());
		     		//added by govind 27-10-2017 end
					if (!pvms.equals("")) {
						InpatientPrescriptionHeader inpatientPrescriptionHeader=new InpatientPrescriptionHeader();
						//PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						inpatientPrescriptionHeader.setHin(patient);
						/*if(wardreamarksList.size()>0){
							MasDepartment md = new MasDepartment();
							md.setId(referredDept);
							opdPatientHistory.setDepartment(md);
						}*/
						
						// else{
						MasDepartment md = new MasDepartment();
						md.setId(box.getInt("deptId"));
						inpatientPrescriptionHeader.setDepartment(md);
						// }
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt("inpatientId"));
						inpatientPrescriptionHeader.setInpatient(inpatient);
						
						MasHospital masHospitalObj = new MasHospital();
						masHospitalObj.setId(box.getInt("hospitalId"));
						inpatientPrescriptionHeader.setHospital(masHospitalObj);
						inpatientPrescriptionHeader.setStatus("p");
						inpatientPrescriptionHeader.setPrescriptionDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						inpatientPrescriptionHeader.setPrescriptionTime(consultationTime);
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("empId"));
						inpatientPrescriptionHeader.setPrescriptionBy(masEmployee);
						if(box.getInt("opdPatientDetailId") != 0){
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(box.getInt("opdPatientDetailId"));
							inpatientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);
						}
						inpatientPrescriptionHeader.setPrescriptionDate(new Date());
						inpatientPrescriptionHeader.setPrescriptionTime(consultationTime);
						inpatientPrescriptionHeader.setPrescribedByNurse("y");
						
						
//						need to be update after discussion
						int prescriptionNo=getTransactionSequenceNoForPrescriptionNo(mapForDS);
						inpatientPrescriptionHeader.setPrescriptionNo(String.valueOf(prescriptionNo));
//						String sqlItemId="";
//						List<Integer> itemIdList = new ArrayList<Integer>();
						hbt.save(inpatientPrescriptionHeader);
						//ipdPatientData.put("inpatientPrescriptionHeader", inpatientPrescriptionHeader);
						List<Object> inpatientPrescriptionDetailsListObject = new ArrayList<Object>();
						
						int item_class_id=0;//added by govind 22-09-2016
						int itemId= 0;
						//String currentDate = (String)box.get("currentDate");
						//Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
						//added by govind 22-09-2016 end 
						
						for (int i = 1; i <= hdb; i++) {
							if(box.getString("nomenclaturetreatment"+i)!=null && !box.getString("nomenclaturetreatment"+i).equals("")){
								
								int index1 = box.getString("nomenclaturetreatment"+i).lastIndexOf("[");
								 int index2 = box.getString("nomenclaturetreatment"+i).lastIndexOf("]");
								
								 index1++;
								String pvmsNo =box.getString("nomenclaturetreatment"+i).substring(index1, index2);
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
								if(box.getString("frequencytreatment"+i)!=null && box.getInt("frequencytreatment"+i)!=0)
								{
								masFrequency.setId(box.getInt("frequencytreatment"+i));
								inpatientPrescriptionDetails.setFrequency(masFrequency);
								}
								if(box.getString("dosagetreatment"+i)!=null && !box.getString("dosagetreatment"+i).equals(""))
								{
								inpatientPrescriptionDetails.setDosage(box.getFloat("dosagetreatment"+i));
								}
								if(box.getString("spslinstructiontreatment"+i)!=null && !box.getString("spslinstructiontreatment"+i).equals(""))
								{
								inpatientPrescriptionDetails.setSplInstruction(box.getString("spslinstructiontreatment"+i));
								}
								if(box.getString("noOfDaystreatment"+i)!=null && !box.getString("noOfDaystreatment"+i).equals(""))
								{
								inpatientPrescriptionDetails.setNoOfDays(box.getInt("noOfDaystreatment"+i));
								}
								inpatientPrescriptionDetails.setType("IP");
								
								if(box.getString("instructiontreatment"+i)!=null && !box.getString("instructiontreatment"+i).equals("") && box.getInt("instructiontreatment"+i)!=0)
								{
								OpdInstructionTreatment instructionTreatment=new OpdInstructionTreatment();
								instructionTreatment.setId(box.getInt("instructiontreatment"+i));
								inpatientPrescriptionDetails.setInsrtuction(instructionTreatment);
								}

								RouteOfAdministration routeOfAdministration=new RouteOfAdministration();
								if(box.getString("routetreatment"+i)!=null && !box.getString("routetreatment"+i).equals("")  && box.getInt("routetreatment"+i)!=0)
								{
								routeOfAdministration.setId(box.getInt("routetreatment"+i));
								inpatientPrescriptionDetails.setRoute(routeOfAdministration);
								}
								
								inpatientPrescriptionDetails.setTotal(box.getFloat("totaltreatment"+i));
								inpatientPrescriptionDetails.setStopMedicine("n");
								
								
								inpatientPrescriptionDetails.setActualTotal(box.getFloat("actualTotalAfterMix"+i)); // added by amit das on 19-11-2016
								
								inpatientPrescriptionDetails.setPrescription(inpatientPrescriptionHeader);
								inpatientPrescriptionDetails.setIssuedStatus("p");
//								
								List<MasStoreItem> itemIdListNew = new ArrayList<MasStoreItem>();
								itemIdListNew = getItemIdFromPVMS(pvmsNo);
									itemId=itemIdListNew.get(0).getId();
									logger.info("itemId "+itemId);
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
									
									inpatientPrescriptionDetails.setNotAvailable("y");
									inpatientPrescriptionDetails.setInjectionStatus("y");
								}else{
									
									inpatientPrescriptionDetails.setNotAvailable("n");
									inpatientPrescriptionDetails.setInjectionStatus("n");
								}
								//added by govind 22-9-2016
								hbt.save(inpatientPrescriptionDetails);
								inpatientPrescriptionDetailsListObject.add(inpatientPrescriptionDetails);
								
								//added by govind 26-10-2017
								for(TaperedMedicineUtil tapUtil:taperUtilList){
									if(tapUtil.getItemId().equals(item.getId())){
										logger.info("itemId-->"+tapUtil.getItemId()+" Frequency-->"+tapUtil.getFrequency());
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
								
								//added by govind 22-9-2016 start
								if(storeItemList.size() > 0){
									InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
									
									injectionAppointment.setHin(patient);
									//Visit visitInj = new Visit();
									//visitInj.setId(visitId);
									//injectionAppointment.setVisit(visitInj);
									
									injectionAppointment.setHospital(masHospitalObj);							
									injectionAppointment.setStatus("p");
									injectionAppointment.setLastChgTime(consultationTime);
									Users users = new Users();
									users.setId(box.getInt("userId"));
									injectionAppointment.setLastChgBy(users);
									injectionAppointment.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
									injectionAppointment.setInpatientPrescriptionHeader(inpatientPrescriptionHeader);
									injectionAppointment.setInpatient(inpatient);
									hbt.save(injectionAppointment);
									
									
									//start adding injAppointmentDetails data
									InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
									//injAppointmentDetails.setAppointmentTime(time);
									injAppointmentDetails.setInjAppointmentDate(new Date());
									injAppointmentDetails.setDose(""+box.getFloat("dosagetreatment"+i));
															
									injAppointmentDetails.setFrequency(masFrequency);
									injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
									
									 
									MasStoreItem item1 = new MasStoreItem();
									item1.setId(itemId);
									if(!checkForInsulinInjection(itemId)){								
									
									injAppointmentDetails.setItem(item1);
									injAppointmentDetails.setInjAppointmentHeader(injectionAppointment);
									injAppointmentDetails.setInpatientPrescriptionDetails(inpatientPrescriptionDetails);
									injAppointmentDetails.setNoOfDays(box.getInt("noOfDaystreatment"+i));
									injAppointmentDetails.setStatus("p");
									injAppointmentDetails.setFinalStatus("n");
									hbt.save(injAppointmentDetails);
								}
								}
								//added by govind 22-9-2016 end
								}
							}
						
						}
						//ipdPatientDataList.put("inpatientPrescriptionDetailsListObject", inpatientPrescriptionDetailsListObject);
											
					}
					//---------------------------------------for investigation-------------------------------------------------
					
					int hiddenValue = box.getInt("hiddenValue");
					String chargeCodeName = "";
					for (int l = 1; l <= hiddenValue; l++) {
						
						
						if(box.getString("chargeCodeName"+l)!=null && !box.getString("chargeCodeName"+l).equals("")){
							chargeCodeName = box.getString("chargeCodeName"+l);
							break;
						}
					}
					if (!chargeCodeName.equals("")) {

						PatientInvestigationHeader patientInvestigationHeader = new PatientInvestigationHeader();
						Patient patient = new Patient();
						patient.setId(box.getInt("hinId"));
						patientInvestigationHeader.setHin(patient);
						/*if(wardreamarksList.size()>0){
							MasDepartment md = new MasDepartment();
							md.setId(referredDept);
							patientInvestigationHeader.setDepartment(md);
						}else{*/
							MasDepartment md = new MasDepartment();
							md.setId(box.getInt("deptId"));
							patientInvestigationHeader.setDepartment(md);
						//}
						Inpatient inpatient = new Inpatient();
						inpatient.setId(box.getInt("inpatientId"));
						patientInvestigationHeader.setInpatient(inpatient);
						MasHospital masHospitalObj = new MasHospital();
						masHospitalObj.setId(box.getInt("hospitalId"));
						patientInvestigationHeader.setHospital(masHospitalObj);
						patientInvestigationHeader.setStatus("p");
						patientInvestigationHeader.setPrescribedByNurse("y");
						patientInvestigationHeader.setInvestigationDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
						patientInvestigationHeader.setInvestigationTime(consultationTime);
//						patientInvestigationHeader.setClinicalNote(box.getString("clinicalNotes1"));
						if(box.getInt("opdPatientDetailId") != 0){
							OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
							opdPatientDetails.setId(box.getInt("opdPatientDetailId"));
							patientInvestigationHeader.setOpdPatientDetail(opdPatientDetails);
						}
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(box.getInt("empId"));
						patientInvestigationHeader.setInvestigationBy(masEmployee);
						hbt.save(patientInvestigationHeader);
						//ipdPatientData.put("patientInvestigationHeader", patientInvestigationHeader);
						DgOrderhd dgOrderhd = new DgOrderhd();
						dgOrderhd.setOrderDate(HMSUtil.dateFormatterDDMMYYYY(consultationDate));
						dgOrderhd.setOrderTime(consultationTime);
						dgOrderhd.setHospital(masHospitalObj);
						dgOrderhd.setInpatient(inpatient);
						dgOrderhd.setHin(patient);
						/*if(wardreamarksList.size()>0){
							MasDepartment md = new MasDepartment();
							md.setId(referredDept);
							dgOrderhd.setDepartment(md);
						}else{*/
							dgOrderhd.setDepartment(md);
						//}
						dgOrderhd.setPrescribedBy(masEmployee);
						dgOrderhd.setPatientType("IP");
						dgOrderhd.setTestType("Regular");
						
		                //need discussion
						
//						String orderSeqNo = generateOrderNumber(box.getInt("hospitalId"));
						String orderSeqNo = labDataService.generateOrderNumber();
						
						dgOrderhd.setOrderNo(orderSeqNo);
						dgOrderhd.setPrescribedByNurse("y");

//						dgOrderhd.setClinicalNote(box.getString("clinicalNotes1"));
						dgOrderhd.setOrderStatus("P");
						//dgOrderhd.setLabOrderStatus("P");
						Users users = new Users();
						users.setId(box.getInt("userId"));
						dgOrderhd.setLastChgBy(users);
						dgOrderhd.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
						dgOrderhd.setLastChgTime(consultationTime);
						dgOrderhd.setInvestigationRequestionNo(patientInvestigationHeader);
						
						DgSampleCollectionHeader collHeader = null;
						hbt.save(dgOrderhd);
						//ipdPatientData.put("dgOrderhd", dgOrderhd);
						List<Object> patientInvestigatinDetailsListObject = new ArrayList<Object>();
						List<Object> dgOrderDetailsListObject = new ArrayList<Object>();
						List<Object> dgSampleCollectionDeatilsListObject=new ArrayList<Object>();
						
						float totalPkgAmount = 0.00f; // Added by Amit Das
						float totalPkgServiceAmount = 0.00f; // Added by Amit Das
						
						// added by AMit Das on 09-03-2016
						for (int i = 1; i <= hiddenValue; i++) {					
							if((box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")) &&
									(box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals(""))){
								
								String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
								int index1 = chargeCodeNameWithId.lastIndexOf("[");
								int index2 = chargeCodeNameWithId.lastIndexOf("]");
								index1++;
								String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
								MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
								totalPkgServiceAmount = totalPkgServiceAmount+ chargeCode.getCharge();
							}
							
						}
						
						// added by AMit Das on 10-03-2016
						if(box.getFloat("pkgCharge")!=0)
							totalPkgAmount = box.getFloat("pkgCharge");
						
						// added by Amit Das on 08-03-2016 for adding pkg service in bl_charge_slip_main and bl_charge_slip_details

						BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
						if(totalPkgAmount>0.00f) {
						//Patient patient = new Patient();
						//patient.setId(p.getId());
						blChargeSlipMain.setHin(patient);
						blChargeSlipMain.setInpatient(inpatient);
						MasHospital hospital = new MasHospital();

						hospital.setId(box.getInt("hospitalId"));
						blChargeSlipMain.setHospital(hospital);

						blChargeSlipMain.setChargeSlipNo(box.getInt("chargeSlipNo"));
						blChargeSlipMain.setChgSlpAmt(new BigDecimal(totalPkgAmount));
						blChargeSlipMain.setNetAmt(new BigDecimal(totalPkgAmount));
						blChargeSlipMain.setDiscount(new BigDecimal(totalPkgAmount));
						blChargeSlipMain.setDiscountAmt(new BigDecimal(totalPkgServiceAmount)); 
						blChargeSlipMain.setReceiptAmt(new BigDecimal(totalPkgAmount));
						blChargeSlipMain.setPayStatus("P");
						Users user1 = new Users();
						user1.setId(box.getInt("userId"));
						blChargeSlipMain.setLastChgBy(user1);
						blChargeSlipMain.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(consultationDate));
						blChargeSlipMain.setLastChgTime(consultationTime);
						blChargeSlipMain.setChgSlpDate(HMSUtil
								.convertStringTypeDateToDateType(consultationDate));
						blChargeSlipMain.setChgSlpTime(consultationTime);
						blChargeSlipMain.setStatus("y");
						if(box.getInt("pkgId")!=0){
							BlPackageHeader blPackageHeader = new BlPackageHeader();
							blPackageHeader.setId(box.getInt("pkgId"));
							blChargeSlipMain.setPackage(blPackageHeader);
						}
						
						hbt.save(blChargeSlipMain);
						
						
						// Added By Amit Das on 08-03-2016
						// ---------------Updating data into RsbyCardDetails Table 
						int pkgSchemeId = box.getInt("pkgScheme");
						String rsbyCardNo = box.getString("rsbyCardNo");
						if(pkgSchemeId!=0 && rsbyCardNo!=null){
							MasScheme pkgScheme = new MasScheme();
							pkgScheme.setId(pkgSchemeId);
						List<RsbyCardDetails> rsbyCardDetailsList =	session.createCriteria(RsbyCardDetails.class).add(Restrictions.eq("PkgScheme", pkgScheme)).add(Restrictions.eq("RsbyCardNo", rsbyCardNo)).list();
						if(rsbyCardDetailsList!=null && rsbyCardDetailsList.size()!=0){
								RsbyCardDetails cardDetails = rsbyCardDetailsList.get(0);
								cardDetails.setBalanceUtilized(cardDetails.getBalanceUtilized().add(new BigDecimal(totalPkgAmount)));
								hbt.update(cardDetails);
						 } else{
							    RsbyCardDetails cardDetails = new RsbyCardDetails();
								cardDetails.setBalanceUtilized(new BigDecimal(totalPkgAmount));
								cardDetails.setRsbyCardNo(rsbyCardNo);
								cardDetails.setStatus("Y");
								hbt.save(cardDetails);
						 }
						}
						
						
						
						for (int i = 1; i <= hiddenValue; i++) {					
								if((box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals("")) &&
										(box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")) ){	
									BlChargeSlipDetail blChargeSlipDetail = new BlChargeSlipDetail();
									blChargeSlipDetail.setHospital(hospital);
									String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
									int index1 = chargeCodeNameWithId.lastIndexOf("[");
									int index2 = chargeCodeNameWithId.lastIndexOf("]");
									index1++;
									String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
									
									MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
									
									blChargeSlipDetail.setChargeCode(chargeCode);

									BigDecimal rate = new BigDecimal(chargeCode.getCharge());
									blChargeSlipDetail.setRate(rate);
									blChargeSlipDetail.setAmt(rate);

									blChargeSlipDetail.setQuantity(1);

									blChargeSlipDetail.setDiscountPercent(new BigDecimal(
												100));

									blChargeSlipDetail.setDiscountAmt(rate);
									blChargeSlipDetail.setNetAmt(rate);

									//blChargeSlipDetail.setNetAmt(new BigDecimal(box.getString(NET_AMOUNT + i)));
									
									Users user2 = new Users();
									user2.setId(box.getInt("userId"));
									blChargeSlipDetail.setLastChgBy(user2);
									blChargeSlipDetail.setLastChgDate(HMSUtil
											.convertStringTypeDateToDateType(consultationDate));
									blChargeSlipDetail.setLastChgTime(consultationTime);
									blChargeSlipDetail.setStatus("y");
									
									blChargeSlipDetail.setChargeSlipMain(blChargeSlipMain);
									blChargeSlipDetail.setRefundableStatus("y");
									blChargeSlipDetail.setInPkgFlag("y");
									try {
										hbt.save(blChargeSlipDetail);
									} catch (RuntimeException e) {
										e.printStackTrace();
									}
								}
							}
						}
						
						/*end of code by Amit Das*/
						
						
						for (int i = 1; i <= hiddenValue; i++) {					
							if(box.getString("chargeCodeName" + i)!=null && !box.getString("chargeCodeName" + i).equals("")){
								
								
								String chargeCodeNameWithId =box.getString("chargeCodeName" + i);
								int index1 = chargeCodeNameWithId.lastIndexOf("[");
								int index2 = chargeCodeNameWithId.lastIndexOf("]");
								index1++;
								String chargeCodeId = chargeCodeNameWithId.substring(index1,index2);						
								MasChargeCode chargeCode = (MasChargeCode) hbt.get(MasChargeCode.class, Integer.parseInt(chargeCodeId));
								
							PatientInvestigationDetails patientInvestigationDetails = new PatientInvestigationDetails();
							patientInvestigationDetails.setInvestigationHeader(patientInvestigationHeader);
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(Integer.parseInt(chargeCodeId));
							patientInvestigationDetails.setChargeCode(masChargeCode);
							patientInvestigationDetails.setQuantity(1);   // default quantity is 1
							patientInvestigationDetails.setClinicalNotes(box.getString("chargecodeclinicalnote" + i));
							//patientInvestigationDetails.setReferToMh(box.getString("referToMh"+i));

							hbt.save(patientInvestigationDetails);
							patientInvestigatinDetailsListObject.add(patientInvestigationDetails);
							DgOrderdt dgOrderdt = new DgOrderdt();
							dgOrderdt.setOrderhd(dgOrderhd);
							masChargeCode.setId(Integer.parseInt(chargeCodeId));
							dgOrderdt.setChargeCode(masChargeCode);
							dgOrderdt.setOrderQty(1);

							dgOrderdt.setLastChgBy(users);
							dgOrderdt.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
							dgOrderdt.setLastChgTime(consultationTime);
							// method written for taking out the values of mascharge
							// code and subcharge
							List<MasChargeCode> masChargeList = new ArrayList<MasChargeCode>();
							masChargeList = session.createCriteria(MasChargeCode.class).add(
									Restrictions.eq("Id", Integer.parseInt(chargeCodeId))).list();

							MasChargeCode masChargeCodeObj = masChargeList.get(0);
							int mainChargeId = masChargeCodeObj.getMainChargecode()
							.getId();
							int subChargeId = masChargeCodeObj.getSubChargecode()
							.getId();
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
							
							// added by Amit Das For pkg services
							if(box.getString("isPackageFlag"+i)!=null && box.getString("isPackageFlag"+i).trim().equalsIgnoreCase("y")){
								dgOrderdt.setInPkgFlag("y");
								dgOrderdt.setPaymentMade("y");
								dgOrderdt.setAmount(new BigDecimal(masChargeCodeObj.getCharge()));
								if(blChargeSlipMain.getId()!=null)
									dgOrderdt.setChargeSlip(blChargeSlipMain);
							} else {
								dgOrderdt.setPaymentMade("n");
							}
							
//							dgOrderdt.setInvestigation(new DgMasInvestigation(Integer.parseInt(chargeCodeId)));
							//dgOrderdt.setInvestigationToMH("n");
							//dgOrderdt.setReferToMh(box.getString("referToMh"+i));
							hbt.save(dgOrderdt);
							dgOrderDetailsListObject.add(dgOrderdt);
							if (chargeCode.getDepartment().getDepartmentType().getDepartmentTypeCode().equals("RADIO")) {
							
								
								
								if(collHeader==null)
								{
								collHeader=new DgSampleCollectionHeader();
								collHeader.setHin(patient);
								collHeader.setInpatient(inpatient);

								if (chargeCode!= null) {
									collHeader.setDepartment(chargeCode.getDepartment());
								}
								collHeader.setHospital(masHospitalObj);
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
									investigation.setId(Integer.parseInt(chargeCodeId));
									sampleDetails.setInvestigation(investigation);
									sampleDetails.setSampleCollDatetime(new Date());
									hbt.save(sampleDetails);
									dgSampleCollectionDeatilsListObject.add(sampleDetails);
								
							}
								
							
						  }
						}
					}
						
						//ipdPatientDataList.put("patientInvestigatinDetailsListObject", patientInvestigatinDetailsListObject);
						//ipdPatientDataList.put("dgOrderDetailsListObject", dgOrderDetailsListObject);
						//ipdPatientDataList.put("dgSampleCollectionDeatilsListObject", dgSampleCollectionDeatilsListObject);
					//-----------------------------For---nursing--procedure----------------------------------------------------------//
						int i = 0;
						int count=box.getInt("nursingcarecount");
						
						List<Object> nursingcareSetupListObject = new ArrayList<Object>();
						List<Object> nursingcareHistoryListObject = new ArrayList<Object>();
						for (int j = 1; j <= count; j++) {
							if(box.getString("careTypeId"+j)!=null && !box.getString("careTypeId"+j).equals("") && box.getInt("careTypeId"+j)!=0)
							{
								NursingcareSetup nursingcareSetup = null;
								
								List<NursingcareSetup> nursingcareSetups=new ArrayList<NursingcareSetup>();
								
								nursingcareSetups = session.createCriteria(NursingcareSetup.class)
										.add(Restrictions.eq("Nursing.Id", box.getInt("careTypeId"+j)))
										.add(Restrictions.eq("Inpatient.Id", box.getInt("inpatientId")))
										.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
								
								if(nursingcareSetups.size()==0)
								{
									
								nursingcareSetup = new NursingcareSetup();
								MasNursingCare masNursingCare = new MasNursingCare();
								masNursingCare.setId(box.getInt("careTypeId"+j));
								nursingcareSetup.setNursing(masNursingCare);

//								nursingcareSetup.setAdNo(admissionNumber);
								Users users = new Users();
								users.setId(box.getInt("userId"));
								nursingcareSetup.setLastChgBy(users);
								nursingcareSetup.setLastChgTime(consultationTime);
								nursingcareSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
								Patient patient = new Patient();
								patient.setId(box.getInt("hinId"));
								nursingcareSetup.setHin(patient);
								MasFrequency masFrequency = new MasFrequency();
								masFrequency.setId(box.getInt("frequency"+j));
								nursingcareSetup.setFrequency(masFrequency);
								Inpatient inpatient = new Inpatient();
								inpatient.setId(box.getInt("inpatientId"));
								nursingcareSetup.setInpatient(inpatient);
								MasHospital masHospitalObj = new MasHospital();
								masHospitalObj.setId(box.getInt("hospitalId"));
								nursingcareSetup.setHospital(masHospitalObj);
								nursingcareSetup.setRemarks(box.getString("careremarks"+j));
								nursingcareSetup.setPrescribedByNurse("y");
								
								NursingcareSetupHistory history=new NursingcareSetupHistory();
								history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
								history.setStartTime(consultationTime);
								history.setNursingcareSetup(nursingcareSetup);
								if(!box.getString("carestop"+j).equals(""))
								{
									nursingcareSetup.setStopCare("y");
									history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
									history.setEndTime(consultationTime);
								}
								else
								{
									nursingcareSetup.setStopCare("n");
								}
								hbt.save(nursingcareSetup); 
								hbt.save(history);
								nursingcareSetupListObject.add(nursingcareSetup);
								nursingcareHistoryListObject.add(history);
								}
								else
								{
									
									//added by govind 2-12-2016
									if(nursingcareSetups.size()>0)
									{
									int careStopId=0;
									careStopId=Integer.parseInt(box.getString("carestop_id"+j));
									NursingcareSetup nurCare = (NursingcareSetup) hbt.load(NursingcareSetup.class, careStopId);	
															
									if(box.getString("carestop"+j).equals("1")){	
										nurCare.setStopCare("y");
										hbt.update(nurCare);
									}
															
									}						
									//added by govind 2-12-2016 end
									
									nursingcareSetup=nursingcareSetups.get(0);
									MasNursingCare masNursingCare = new MasNursingCare();
									masNursingCare.setId(box.getInt("careTypeId"+j));
									nursingcareSetup.setNursing(masNursingCare);
									Users users = new Users();
									users.setId(box.getInt("userId"));
									nursingcareSetup.setLastChgBy(users);
									nursingcareSetup.setLastChgTime(consultationTime);
									nursingcareSetup.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
									MasFrequency masFrequency = new MasFrequency();
									masFrequency.setId(box.getInt("frequency"+j));
									nursingcareSetup.setFrequency(masFrequency);
									
									nursingcareSetup.setRemarks(box.getString("careremarks"+j));
									
									NursingcareSetupHistory history=null;
									
									if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("y"))
									{
										if(!box.getString("vitalstop"+j).equals(""))
										{
											
										}
										else
										{
											history=new NursingcareSetupHistory();
											//nursingcareSetup.setStopCare("n");
											history.setNursingcareSetup(nursingcareSetup);
											history.setStartDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
											history.setStartTime(consultationTime);
										}
									}
									if(nursingcareSetup.getStopCare()!=null && nursingcareSetup.getStopCare().equalsIgnoreCase("n"))
									{
										 
										 if(!box.getString("vitalstop"+j).equals(""))
											{
											 
											 List<NursingcareSetupHistory> nursingcareSetupHistories=new ArrayList<NursingcareSetupHistory>();						
												nursingcareSetupHistories = session.createCriteria(NursingcareSetupHistory.class,"ncsh")
														.createAlias("NursingcareSetup", "ncs")
														.createAlias("ncs.Inpatient", "ncsi")
														.createAlias("ncs.Hospital", "ncsho")
														.add(Restrictions.eq("ncs.Id", nursingcareSetup.getId()))
														.add(Restrictions.eq("ncsi.Id", box.getInt("inpatientId")))
														.add(Restrictions.eq("ncsho.Id", box.getInt("hospitalId")))
														.add(Restrictions.isNotNull("ncsh.StartDate"))
														.addOrder(Order.desc("Id")).list();									
												if(nursingcareSetupHistories.size()>0)
												{
												history=nursingcareSetupHistories.get(0);
												//nursingcareSetup.setStopCare("y");
												history.setNursingcareSetup(nursingcareSetup);
												history.setEndDate(HMSUtil.convertStringTypeDateToDateType(consultationDate));
												history.setEndTime(consultationTime);
												}
											}
									}
									hbt.save(nursingcareSetup); 
									if(history!=null)
									{
									hbt.save(history);
									}	
									nursingcareSetupListObject.add(nursingcareSetup);
									nursingcareHistoryListObject.add(history);
								}
							}
						}
						//ipdPatientDataList.put("nursingcareSetupListObject", nursingcareSetupListObject);
						//ipdPatientDataList.put("nursingcareHistoryListObject", nursingcareHistoryListObject);
						
					
					flag = true;
					tx.commit();	
					} catch (DataAccessException e) {
						if(tx!=null)
							tx.rollback();
						e.printStackTrace();
					}
				 map.put("flag", flag);
					return map;
				}	
				
				@SuppressWarnings({ "unused", "unchecked" })
				public Map<String, Object> getPatientPrescriptionDetails(Map map) {
					   
					   Session session = (Session) getSession();
					   List<InpatientPrescriptionDetails> inPatientPrescriptionList = new ArrayList<InpatientPrescriptionDetails>();
					   String hinNo = (String) map.get("hinNo");
					   int hinId = (Integer) map.get("hinId");
					   int inPatientId= (Integer) map.get("inPatientId");
					try {

						inPatientPrescriptionList=session.createCriteria(InpatientPrescriptionDetails.class)
								 
								  .createAlias("Prescription", "Prescription")
								  .createAlias("Prescription.Inpatient", "Inpatient")
								  .add(Restrictions.eq("Inpatient.Id", inPatientId))
								  .list();
						
					} catch (HibernateException e) {
						e.printStackTrace();
					}
					
					map.put("inPatientPrescriptionList",inPatientPrescriptionList);
					return map;
				}

	

				@Override
				public Map<String, Object> showGeneralSurgrySpecialityTemplateJsp(Box box) {
					Session session = (Session) getSession();

					Map<String, Object> map = new HashMap<String, Object>();
					List<MasDeliveryType> deliveryTypeList;
					List<MasRelation> relationList;
					List<Inpatient> inpatientList = new ArrayList<Inpatient>();
					List<Patient> patientList = new ArrayList<Patient>();
					List<Integer> maxVisitIdList = new ArrayList<Integer>();
					List<Integer> opdPatientDetailsList = new ArrayList<Integer>();
					List<OpdGeneralSurgeryPastSpeciality> opdGeneralSurgeryPastSpecialityList = new ArrayList<OpdGeneralSurgeryPastSpeciality>();
					List<OpdGeneralSurgeryPastSpeciality> opdGeneralSurgeryFamilySpecialityList = new ArrayList<OpdGeneralSurgeryPastSpeciality>();
					List<OpdGeneralSurgeryPrevSpeciality> opdGeneralSurgeryPrevSpeciality = new ArrayList<OpdGeneralSurgeryPrevSpeciality>();
					try {
						deliveryTypeList = session.createCriteria(MasDeliveryType.class)
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.list();
						relationList = session
								.createCriteria(MasRelation.class)
								.add(Restrictions.eq("Status", "Y".toLowerCase())
										.ignoreCase()).list();
						if(box.getInt("inpatientId")!=0){
						inpatientList =  session.createCriteria(Inpatient.class).add(Restrictions.eq("Id", box.getInt("inpatientId"))).list();
						}
						int opdId=0;
						if(box.getInt("hinId")!=0){
							patientList =  	session.createCriteria(Patient.class).add(Restrictions.eq("Id", box.getInt("hinId"))).list();
				/*			maxVisitIdList = session.createCriteria(OpdPatientDetails.class).createAlias("Visit", "visit")
									.createAlias("visit.Hin", "hin")
									.add(Restrictions.eq("hin.Id", box.getInt("hinId")))
									.setProjection(Projections.max("visit.Id")).list();
							
							if(maxVisitIdList.size()>0){
								if(maxVisitIdList.get(0) != null){
								int maxVisitId = maxVisitIdList.get(0);
								
							System.out.println("-------------"+maxVisitId);
								opdPatientDetailsList = session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("Visit.Id",maxVisitId)).setProjection(Projections.projectionList().add(Projections.property("Id"))).list();
								if(opdPatientDetailsList.size()>0){
								opdId = opdPatientDetailsList.get(0);
								System.out.println("opdId---"+opdId);*/
								opdGeneralSurgeryPastSpecialityList = session.createCriteria(OpdGeneralSurgeryPastSpeciality.class).add(Restrictions.eq("Hin.Id",box.getInt("hinId")))
										.add(Restrictions.eq("FlagSpeciality","past"))
										.list();
								
								opdGeneralSurgeryFamilySpecialityList = session.createCriteria(OpdGeneralSurgeryPastSpeciality.class).add(Restrictions.eq("Hin.Id",box.getInt("hinId")))
										.add(Restrictions.eq("FlagSpeciality","family"))
										.list();
								
								
								
								
								opdGeneralSurgeryPrevSpeciality= session.createCriteria(OpdGeneralSurgeryPrevSpeciality.class).add(Restrictions.eq("Hin.Id",box.getInt("hinId"))).list();
								}
								//}
						//	}
							
					//	}
						map.put("opdGeneralSurgeryPastSpecialityList", opdGeneralSurgeryPastSpecialityList);
						map.put("opdGeneralSurgeryFamilySpecialityList", opdGeneralSurgeryFamilySpecialityList);
						map.put("opdGeneralSurgeryPrevSpeciality", opdGeneralSurgeryPrevSpeciality);
						map.put("inpatientList", inpatientList);
						map.put("patientList", patientList);
						map.put("relationList", relationList);
						map.put("deliveryTypeList", deliveryTypeList);
					} catch (HibernateException e) {
						e.printStackTrace();
					}
					return map;
				}			

				@Override
				public boolean addLaborRoom2(Map<String, Object> map) {
					logger.info("Method addLaborRoom2");
					boolean successfullyAdded = false;
					List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					if (map.get("laborRoomList") != null) {
							laborRoomList = (List<LaborRoom>)(map.get("laborRoomList"));
					}
					logger.info("impl laborRoomList size "+laborRoomList.size());
					try {
						
						for(LaborRoom lab:laborRoomList){
							hbt.save(lab);
						}
						
						successfullyAdded = true;
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
					return successfullyAdded;
				}

				@Override
				public boolean addLaborRoom4(Map<String, Object> map) {
					logger.info("Method addLaborRoom4()");
					boolean successfullyAdded = false;
					List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					if (map.get("laborRoomList") != null) {
							laborRoomList = (List<LaborRoom>)(map.get("laborRoomList"));
					}
					logger.info("impl laborRoomList size "+laborRoomList.size());
					try {
						
						for(LaborRoom lab:laborRoomList){
							hbt.save(lab);
						}
						
						successfullyAdded = true;
					} catch (RuntimeException e) {
						e.printStackTrace();
					}
					return successfullyAdded;
				}
				
				@Override
				public Map<String,Object> checkForBlockedMedicine(Map<String,Object> dataMap){
					Map<String,Object> map=new HashMap<String,Object>();
					map=opdDataServiceImpl.checkForBlockedMedicine(dataMap);
					return map;
				}

				
}