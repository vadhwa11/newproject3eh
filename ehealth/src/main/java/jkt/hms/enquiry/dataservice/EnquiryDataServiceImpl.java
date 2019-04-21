package jkt.hms.enquiry.dataservice;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.BlPackageBill;
import jkt.hms.masters.business.BlPaymentAdviceHeader;
import jkt.hms.masters.business.BlPymntAdviceDispHeader;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientPrescriptionDetails;
import jkt.hms.masters.business.IpdVitalcareSetupHistory;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MlcCase;
import jkt.hms.masters.business.OpdNursingPatientDetails;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdSurgeryDetail;
import jkt.hms.masters.business.OpdSurgeryHeader;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtPreAnaesthesiaProcNotesMain;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientEpisode;
import jkt.hms.masters.business.PatientInvestigationHeader;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PatientStoreIndentDetails;
import jkt.hms.masters.business.PatientStoreIndentHeader;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.SilDilStatus;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EnquiryDataServiceImpl extends HibernateDaoSupport implements
		EnquiryDataService {

	@SuppressWarnings("unchecked")
	public List<MasDepartment> getWardList() {
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			wardList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
						.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.DepartmentTypeCode", "CR")).addOrder(Order.asc("DepartmentName")).list();
					

		} catch (HibernateException e) {
			e.printStackTrace();
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 11 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/
		return wardList;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDoctorList(Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		String doctorName = "";
		int departmentId = 0;
		String hql = "";
		int hospitalId=0;
		Session session = (Session) getSession();

		if (enquiryMap.get("doctorName") != null) {
			doctorName = (String) enquiryMap.get("doctorName");
		}
		if (enquiryMap.get("departmentId") != null) {
			departmentId = (Integer) enquiryMap.get("departmentId");
		}
		
		if (enquiryMap.get("hospitalId") != null) {
			hospitalId = (Integer) enquiryMap.get("hospitalId");
		}
		hql = "from MasEmployee me join me.Department as md";
		if (enquiryMap.size() > 0) {

			if (!doctorName.equals("")) {
				hql += " where me.FirstName like '" + doctorName + "%' and me.Hospital.Id="+hospitalId;
			}

			if (departmentId != 0 && (doctorName.equals(""))) {
				hql += " where me.Department=" + departmentId+"  and me.Hospital.Id="+hospitalId;
			} else if (departmentId != 0 && (!doctorName.equals(""))) {
				hql += " and me.Department=" + departmentId+"  and me.Hospital.Id="+hospitalId;
			}
		}
		try {
			if (!hql.equals("")) {
				Query query = session.createQuery(hql);
				doctorList = query.list();
			}
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

		map.put("doctorList", doctorList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForEnquiry() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		try {
			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			stateList = session.createCriteria(MasState.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			districtList = session.createCriteria(MasDistrict.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			wardList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.DepartmentTypeName", "Ward")).list();					
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 11 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/

		map.put("serviceTypeList", serviceTypeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("stateList", stateList);
		map.put("districtList", districtList);
		map.put("wardList", wardList);
		map.put("relationList", relationList);
		return map;
	}

	public Map<String, Object> getPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String relativeName = "";
		String village = "";
		String hinNo = "";
		String serPersonName = "";
		String patientName = "";
		int hinId = 0;
		String address = "";
		int stateId = 0;
		String adNo = "";
		String patientStatus = "";
		int patientRelation = 0;
		Date fromDate = null;
		Date toDate = null;
		String policeStation = "";
		String mobileNo = "";
		int hos_id=0;
		Session session = (Session) getSession();

		if (enquiryMap.get("hinNo") != null) {
			hinNo = (String) enquiryMap.get("hinNo");
		}
		if (enquiryMap.get("hospitalId") != null) {
			hos_id = (Integer) enquiryMap.get("hospitalId");
		}
		if (enquiryMap.get("serPersonName") != null) {
			serPersonName = (String) enquiryMap.get("serPersonName");
		}
		if (enquiryMap.get("patientName") != null) {
			patientName = (String) enquiryMap.get("patientName");
		}
		if (enquiryMap.get("hinId") != null) {
			hinId = (Integer) enquiryMap.get("hinId");
		}
		if (enquiryMap.get("address") != null) {
			address = (String) enquiryMap.get("address");
		}
		if (enquiryMap.get("stateId") != null) {
			stateId = (Integer) enquiryMap.get("stateId");
		}
		if (enquiryMap.get("adNo") != null) {
			adNo = (String) enquiryMap.get("adNo");
		}
		if (enquiryMap.get("patientStatus") != null) {
			patientStatus = (String) enquiryMap.get("patientStatus");
		}
		if (enquiryMap.get("relativeName") != null) {
			relativeName = (String) enquiryMap.get("relativeName");
		}
		if (enquiryMap.get("patientRelation") != null) {
			patientRelation = (Integer) enquiryMap.get("patientRelation");
		}
		if (enquiryMap.get("fromDate") != null) {
			fromDate = (Date) enquiryMap.get("fromDate");
		}
		if (enquiryMap.get("toDate") != null) {
			toDate = (Date) enquiryMap.get("toDate");
		}
		if (enquiryMap.get("village") != null) {
			village = (String) enquiryMap.get("village");
		}
		if (enquiryMap.get("policeStation") != null) {
			policeStation = (String) enquiryMap.get("policeStation");
		}
		if (enquiryMap.get("mobileNo") != null) {
			mobileNo = (String) enquiryMap.get("mobileNo");
		}
		try {
			Criteria crit = session.createCriteria(Patient.class);

			if (!relativeName.equals("")) {
				crit = crit.add(Restrictions.like("NextOfKinName", relativeName
						+ "%"));
			}
			if (!village.equals("")) {
				crit = crit.createAlias("Village", "Village").add(
						Restrictions.eq("Village.VillageCode", village));
			}
			if (patientRelation != 0) {
				crit = crit.createAlias("NextOfKinRelation", "mr").add(
						Restrictions.eq("mr.Id", patientRelation));
			}
			if (fromDate != null && toDate != null) {

				crit = crit.add(Restrictions.between("RegDate", fromDate,
						toDate));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.like("HinNo", hinNo + "%"));
			}
			if (!patientName.equals("")) {
				crit = crit.add(Restrictions.like("PFirstName", patientName
						+ "%"));
			}
			if (!address.equals("")) {
				crit = crit.add(Restrictions.eq("Address", address + "%"));
			}
			if (stateId != 0) {
				crit = crit.createAlias("State", "state").add(
						Restrictions.eq("state.Id", stateId));
			}
			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatients", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!policeStation.equals("")) {
				crit = crit.add(Restrictions.like("PoliceStation",
						policeStation + "%"));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.like("MobileNumber", mobileNo+"%"));
			}
			if (!patientStatus.equals("")) {
				if (patientStatus.equals("Expired")) {
					crit = crit
							.add(Restrictions.eq("PatientStatus", "Expired"));
				} else if (patientStatus.equals("In Patient")) {
					crit = crit.add(Restrictions.eq("PatientStatus",
							"In Patient"));
				} else if (patientStatus.equals("Out Patient")) {
					crit = crit.add(Restrictions.eq("PatientStatus",
							"Out Patient"));
				}
			}

			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	// -----------------------------------------InPatient

	public Map<String, Object> getInPatientDetailsForEnquiry(
			Map<String, Object> enquiryMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();

		String serviceNo = "";
		String hinNo = "";
		int serviceTypeId = 0;
		int rankId = 0;
		int unitId = 0;
		String serPersonName = "";
		String patientName = "";
		int hinId = 0;
		String address = "";
		int districtId = 0;
		int stateId = 0;
		String adNo = "";

		Session session = (Session) getSession();

		if (enquiryMap.get("serviceNo") != null) {
			serviceNo = (String) enquiryMap.get("serviceNo");
		}
		if (enquiryMap.get("hinNo") != null) {
			hinNo = (String) enquiryMap.get("hinNo");
		}
		if (enquiryMap.get("serviceTypeId") != null) {
			serviceTypeId = (Integer) enquiryMap.get("serviceTypeId");
		}
		if (enquiryMap.get("rankId") != null) {
			rankId = (Integer) enquiryMap.get("rankId");
		}
		if (enquiryMap.get("unitId") != null) {
			unitId = (Integer) enquiryMap.get("unitId");
		}
		if (enquiryMap.get("serPersonName") != null) {
			serPersonName = (String) enquiryMap.get("serPersonName");
		}
		if (enquiryMap.get("patientName") != null) {
			patientName = (String) enquiryMap.get("patientName");
		}
		if (enquiryMap.get("hinId") != null) {
			hinId = (Integer) enquiryMap.get("hinId");
		}
		if (enquiryMap.get("address") != null) {
			address = (String) enquiryMap.get("address");
		}
		if (enquiryMap.get("districtId") != null) {
			districtId = (Integer) enquiryMap.get("districtId");
		}
		if (enquiryMap.get("stateId") != null) {
			stateId = (Integer) enquiryMap.get("stateId");
		}
		if (enquiryMap.get("adNo") != null) {
			adNo = (String) enquiryMap.get("adNo");
		}
		try {
			Criteria crit = session.createCriteria(Patient.class).add(
					Restrictions.eq("PatientStatus", "In Patient"));
			if (hinId == 0) {
				if (!serviceNo.equals("")) {
					crit = crit.add(Restrictions.like("ServiceNo", serviceNo
							+ "%"));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.like("HinNo", hinNo + "%"));
				}
				if (!patientName.equals("")) {
					crit = crit.add(Restrictions.like("PFirstName", patientName
							+ "%"));
				}
				if (!serPersonName.equals("")) {
					crit = crit.add(Restrictions.like("SFirstName",
							serPersonName + "%"));
				}
				if (!address.equals("")) {
					crit = crit.add(Restrictions.eq("Address", address + "%"));
				}
				if (serviceTypeId != 0) {
					crit = crit.createAlias("ServiceType", "st").add(
							Restrictions.eq("st.Id", serviceTypeId));
				}
				if (rankId != 0) {
					crit = crit.createAlias("Rank", "rank").add(
							Restrictions.eq("rank.Id", rankId));
				}
				if (unitId != 0) {
					crit = crit.createAlias("Unit", "unit").add(
							Restrictions.eq("unit.Id", unitId));
				}
				if (districtId != 0) {
					crit = crit.createAlias("District", "dist").add(
							Restrictions.eq("dist.Id", districtId));
				}
				if (stateId != 0) {
					crit = crit.createAlias("State", "state").add(
							Restrictions.eq("state.Id", stateId));
				}
				if (!adNo.equals("")) {
					crit = crit.createAlias("Inpatients", "ip").add(
							Restrictions.eq("ip.AdNo", adNo));
				}
			} else if (hinId != 0) {
				crit = crit.add(Restrictions.idEq(hinId));
			}
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getDetailsForSearch() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getInPatientDetailsForEnquiry2(
			Map<String, Object> mapForDs) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Object> inPatientList = new ArrayList<Object>();
		Session session = (Session) getSession();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String policeStation = "";
		String village = "";
		int hos_id=0;
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("hospitalId") != null) {
			hos_id = (Integer) mapForDs.get("hospitalId");
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
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}
		if (mapForDs.get("wardId") != null) {
			wardId = (Integer) mapForDs.get("wardId");
		}
		if (mapForDs.get("village") != null) {
			village = (String) mapForDs.get("village");
		}
		if (mapForDs.get("policeStation") != null) {
			policeStation = (String) mapForDs.get("policeStation");
		}
		try{
		Criteria crit = null;

		if (inpatientId == 0)
		{
			crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", new String[]{"A","D"})).add(Restrictions.eq("Hospital.Id", hos_id));
			if (!adNo.equals(""))
			{
				crit = crit.add(Restrictions.eq("AdNo", adNo));
			}
			if (!hinNo.equals("") || !patientFName.equals("")
				|| !patientMName.equals("") || !patientMName.equals("")
				|| !patientLName.equals("") || !patientLName.equals("") )
			{
				crit = crit.createAlias("Hin", "hin");
			}

			if (!hinNo.equals(""))
			{
				crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
			}
			if (!patientFName.equals(""))
			{
				crit = crit.add(Restrictions.like("hin.PFirstName",patientFName + "%"));
			}

			if (!patientMName.equals(""))
			{
				crit = crit.add(Restrictions.like("hin.PMiddleName",patientMName + "%"));
			}

			if (!patientLName.equals(""))
			{
				crit = crit.add(Restrictions.like("hin.PLastName",patientLName+"%"));
			}

			if (wardId != 0)
			{
				crit = crit.createAlias("Department", "dept").add(Restrictions.eq("dept.Id", wardId));
			}

			if (!policeStation.equals(""))
			{
				crit = crit.createAlias("Hin", "hin").add(Restrictions.like("hin.PoliceStation", policeStation+ "%"));
			}

			if (!village.equals(""))
			{
				crit = crit.createAlias("Hin", "hin").createAlias("hin.Village", "village")
				.add(Restrictions.eq("village.VillageCode", village));
			}

		}
		else if (inpatientId != 0)
		{	crit = session.createCriteria(Inpatient.class).add(Restrictions.in("AdStatus", new String[]{"A","D"}));
			crit = crit.add(Restrictions.eq("Id",inpatientId));
		}

		inPatientList = crit.addOrder(Order.asc("DateOfAddmission")).list();
	}catch (Exception e) {
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
		map.put("inpatientList", inPatientList);
		return map;

	}

	// --------------- Added at Bangalore By Vivek-------
	@SuppressWarnings("unchecked")
	public Map<String, Object> showPatientDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<DischargeIcdCode>icdCodeList=new ArrayList<DischargeIcdCode>();

		List<PatientEpisode> patientEpisodeList = new ArrayList<PatientEpisode>(); // added by amit das on 09-09-2016
		List<Visit> visitList = new ArrayList<Visit>();
		String diagnosis="";
		String hinNo = "";
		int currentVisitId= 0;
		int episodeId= 0;
		if (dataMap.get("hinNo") != null) {
			hinNo = (String) dataMap.get("hinNo");
		}
		if (dataMap.get("currentVisitId") != null) {
			currentVisitId = (Integer) dataMap.get("currentVisitId");
		}
		if (dataMap.get("episodeId") != null) {
			episodeId = (Integer) dataMap.get("episodeId");
		}
		int inpatientId=0;
		Session session = getSession();
		Criteria inpatientCriteria = null;
		Criteria visitCriteria = null;
		try {
			patientList = (List<Patient>) session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", hinNo)).list();
			inpatientCriteria = session
					.createCriteria(Inpatient.class).createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.HinNo", hinNo))
					.addOrder(Order.asc("DateOfAddmission"));
			
			if(episodeId!=0)
				inpatientCriteria.createAlias("PatientEpisode", "pe").add(Restrictions.eq("pe.Id", episodeId)); // added by amit das on 12-09-2016
			
			
			inPatientList =  (List<Inpatient>)inpatientCriteria.list();
			
			for(Inpatient inpatient:inPatientList){
				inpatientId=inpatient.getId();	
			}
			
			/*visitList = (List<Visit>) session.createCriteria(Visit.class)
					.createAlias("Hin", "pt")
					//.add(Restrictions.ne("Id", currentVisitId))
					.add(Restrictions.eq("pt.HinNo", hinNo))
					.addOrder(Order.desc("VisitNo")).list();*/
			/*commented by amit das on 12-09-2016*/
			
			
			
			/*added by amit das on 12-09-2016*/
			if(episodeId!=0){							
				visitList = (List<Visit>) session.createCriteria(OpdPatientDetails.class)
						.createAlias("Visit", "v",Criteria.LEFT_JOIN)
						.createAlias("PatientEpisode", "pe",Criteria.LEFT_JOIN)
						.createAlias("v.Hin", "pt",Criteria.LEFT_JOIN)
						.setProjection(Projections.property("Visit"))
						.add(Restrictions.eq("pt.HinNo", hinNo))
						.add(Restrictions.eq("pe.Id", episodeId))
						.add(Restrictions.eq("v.VisitStatus","c").ignoreCase())
						.addOrder(Order.desc("v.VisitNo")).list();
				
				
				} else {
				visitCriteria = session.createCriteria(Visit.class)
						.createAlias("Hin", "pt")
						//.add(Restrictions.ne("Id", currentVisitId))
						.add(Restrictions.eq("pt.HinNo", hinNo))
						.add(Restrictions.eq("VisitStatus","c").ignoreCase())
						.addOrder(Order.desc("VisitNo"));
				visitList = visitCriteria.list();
				System.out.println("visitLivvst="+visitList.size());
			}
			
			
			icdCodeList=session.createCriteria(DischargeIcdCode.class)
							   .add(Restrictions.eq("Inpatient.Id",inpatientId))
							   .addOrder(Order.desc("Id")).setMaxResults(1).list();
			
			for(DischargeIcdCode DischargeIcdCode:icdCodeList){
				diagnosis=DischargeIcdCode.getIcd().getIcdName();
			}
			
			// added by amit das on 09-09-2016
			patientEpisodeList  =session.createCriteria(PatientEpisode.class)
					 .add(Restrictions.eq("HinNo", hinNo)).list();
			
		} catch (Exception e) {
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
		map.put("patientList", patientList);
		map.put("inPatientList", inPatientList);
		map.put("visitList", visitList);
		map.put("diagnosis",diagnosis);
		map.put("patientEpisodeList",patientEpisodeList); // added by amit das on 09-09-2016
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAdVisitDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		int id = 0;
		Session session = null;
		 session= getSession();
		if (dataMap.get("id") != null) {
			id = Integer.parseInt("" + dataMap.get("id"));
		}
		try{
			inPatientList = (List<Inpatient>) session
					.createCriteria(Inpatient.class).add(Restrictions.eq("Id", id))
					.list();
		}catch (Exception e) {
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
		map.put("inPatientList", inPatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllEnquiry(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<Discharge> dischargeList = new ArrayList<Discharge>();
		List<Discharge> dischargeList1 = new ArrayList<Discharge>();
		List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		List<MlcCase> mlcCaseList = new ArrayList<MlcCase>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		List<DgOrderhd> diagList = new ArrayList<DgOrderhd>();
		List<PatientPrescriptionHeader> opPrescriptionList = new ArrayList<PatientPrescriptionHeader>();
		List<PatientStoreIndentHeader> ipPrescriptionList = new ArrayList<PatientStoreIndentHeader>();
		List<OtBooking> operationsList = new ArrayList<OtBooking>();
		List<OpdSurgeryDetail> headerList = new ArrayList<OpdSurgeryDetail>();
// 		List<InpatientPrescriptionHeader> inpatientPrescriptionList = new ArrayList<InpatientPrescriptionHeader>();
 		List<PatientInvestigationHeader>  patientInvestigationList = new ArrayList<PatientInvestigationHeader>();
// definition of vitalList By Ujjwal fo OP
 		List<OpdPatientDetails>vitalList=new ArrayList<OpdPatientDetails>();
 		List<OpdNursingPatientDetails>preOpcList=new ArrayList<OpdNursingPatientDetails>();
 	 	// definition of vitalList By Ujjwal fo IP
 		List<IpdVitalcareSetupHistory>vitalListIP=new ArrayList<IpdVitalcareSetupHistory>();
 		List<OpdPatientDetails>examinationList=new ArrayList<OpdPatientDetails>();
 		//definition ended by Ujjwal 		

 		
		  List<DgOrderhd> dgOrderhds=new ArrayList<DgOrderhd>();
 		 List<PatientPrescriptionHeader>  ipdPatientPrescriptionHeaderList = new ArrayList<PatientPrescriptionHeader>();
 		List<InpatientPrescriptionDetails>  inpatientPrescriptionDetailsList = new ArrayList<InpatientPrescriptionDetails>();
 		 
 		 List<PatientInvestigationHeader>  ipdPatientInvestigationHeaderList = new ArrayList<PatientInvestigationHeader>();
		 List<OpdSurgeryHeader>  ipdOpdSurgeryHeaderList = new ArrayList<OpdSurgeryHeader>();
		 List<OpdSurgeryDetail> ipdOpdSurgeryDetailList = null;  // added by amit das on 28-09-2016
		 List<DgOrderdt>DgOrderdtList=new ArrayList<DgOrderdt>();
 		Session session = null;
		 session= getSession();
		int id = 0;
		int hinId = 0;
		int visitId =0;
		String adVisitNo="";
		String opOrString = "";
		String detailId = "";
		if (dataMap.get("adVisitNo") != null) {
			adVisitNo = ("" + dataMap.get("adVisitNo"));
		}
		if (dataMap.get("id") != null) {
			id = Integer.parseInt("" + dataMap.get("id"));
		}
		if (dataMap.get("opOrString") != null) {
			opOrString = ("" + dataMap.get("opOrString"));
		}
		if (dataMap.get("detailId") != null) {
			detailId = ("" + dataMap.get("detailId"));
		}
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		if (dataMap.get("id") != null) {
			visitId = Integer.parseInt("" + dataMap.get("id"));
		}
		System.out.println("visitId==>>" + dataMap.get("visitId"));
		 try{
		if (opOrString.equals("IP")) {
			String opdRemarks="";
			String consultation="";
			/*Done By Awadhesh Singh*/
			String hql1 = " FROM OpdPatientDetails opd where opd.Visit.Id = "+visitId;
			Query query = session.createQuery(hql1);
			List<OpdPatientDetails> opdDetails = query.list();
			
			
			for(OpdPatientDetails row : opdDetails){
			/*Done By Awadhesh Singh*/
			
			if(null !=row.getOpdRemarks())
				opdRemarks=row.getOpdRemarks();
			if(null !=row.getSummaryConsultation())
				consultation=row.getSummaryConsultation();
			
			}
			map.put("opdRemarks", opdRemarks);//Added By Awadhesh Singh
			map.put("consultation", consultation);//Added By Awadhesh Singh
			map.put("opdDetails", opdDetails);//Awadhesh Singh
			inPatientList = (List<Inpatient>) session
					.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", id)).list();
			Inpatient inpatient = inPatientList.get(0);
			hinId = Integer.parseInt("" + inpatient.getHin().getId());
			
			inpatientPrescriptionDetailsList=session.createCriteria(InpatientPrescriptionDetails.class)
					 
					  .createAlias("Prescription", "Prescription")
					  .createAlias("Prescription.Inpatient", "Inpatient")
					  
					  .add(Restrictions.eq("Inpatient.Id", id))
					   .setMaxResults(5)
					  .list();
			dgOrderhds = session.createCriteria(DgOrderhd.class) 
					.add(Restrictions.eq("Inpatient.Id", id))
					//.add(Restrictions.eq("v.Id", id))
					.list(); 
			DgOrderdtList=session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "Orderhd")
					.add(Restrictions.eq("Orderhd.Inpatient.Id", id))
					//.add(Restrictions.eq("v.Id", id))
					.list();
			 ipdPatientInvestigationHeaderList=session.createCriteria(PatientInvestigationHeader.class,"pih")
					  .createAlias("pih.Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", id))
					  .list();
			  
			  ipdOpdSurgeryHeaderList=session.createCriteria(OpdSurgeryHeader.class,"osh")
					  .createAlias("osh.Inpatient", "ip")
					  .add(Restrictions.eq("ip.Id", id))
					  .setMaxResults(5)
					   .list();

							if (detailId.equals("Discharge")) {
								dischargeIcdCodeList = (List<DischargeIcdCode>) session
										.createCriteria(DischargeIcdCode.class)
										.add(Restrictions.eq("Inpatient.Id", id))
										.add(Restrictions.eq("DiagnosisStatus", "f")).list();
										//
				
										dischargeList1 = (List<Discharge>) session
										.createCriteria(Discharge.class)
										.add(Restrictions.eq("Hin.Id", hinId))
										//.add(Restrictions.eq("Inpatient.Id", id))
										.list();
										dischargeList = (List<Discharge>) session
									.createCriteria(Discharge.class)
									.add(Restrictions.eq("Hin.Id", hinId))
									.add(Restrictions.eq("Inpatient.Id", id))
									.list();
										
								
								
								
								} else if (detailId.equals("Mlc")) {
									mlcCaseList = (List<MlcCase>) session
									.createCriteria(MlcCase.class)
									.add(Restrictions.eq("Hin.Id", hinId)).list();
								} else if (detailId.equals("Sil/Dil")) {
									silDilStatusList = (List<SilDilStatus>) session
									.createCriteria(SilDilStatus.class)
									.add(Restrictions.eq("Inpatient.Id", id)).list();
									} else if (detailId.equals("Transfer")) {
										transferList = (List<Transfer>) session
										.createCriteria(Transfer.class)
										.add(Restrictions.eq("AdNo", adVisitNo))
										.add(Restrictions.eq("Hin.Id", hinId))
										.list();
									}
							
							/*
							 * Added By Awadhesh for Examination IP History
							 */
									else if(detailId.equalsIgnoreCase("examination")){
										examinationList=session.createCriteria(OpdPatientDetails.class).add(Restrictions.eq("VitalSetup.Inpatient.Id", id)).list();
									}
							/*
							 * Added By Ujjwal for Vital IP History
							 */
									else if(detailId.equalsIgnoreCase("Vitals")){
										vitalListIP=session.createCriteria(IpdVitalcareSetupHistory.class).add(Restrictions.eq("VitalSetup.Inpatient.Id", id)).list();
									}
								// added by amit das on 28-09-2016
								else if(detailId.equalsIgnoreCase("Procedures")){
									if(ipdOpdSurgeryHeaderList!=null && ipdOpdSurgeryHeaderList.size()>0){
										ipdOpdSurgeryDetailList =	session.createCriteria(OpdSurgeryDetail.class).add(Restrictions.eq("OpdSurgery.Id",ipdOpdSurgeryHeaderList.get(0).getId())).list();
									} 
									if(ipdOpdSurgeryDetailList!=null && ipdOpdSurgeryDetailList.size()>0){
										List<OtBooking> bookings = session.createCriteria(OtBooking.class).add(Restrictions.eq("OpdSurseryHeader.Id",ipdOpdSurgeryHeaderList.get(0).getId())).list();
										if(bookings!=null && bookings.size()>0){
											List<OtPreAnaesthesiaProcNotesMain> anaesthesiaProcNotesMains = session.createCriteria(OtPreAnaesthesiaProcNotesMain.class).add(Restrictions.eq("Booking.Id",bookings.get(0).getId())).list();
											if(anaesthesiaProcNotesMains!=null && anaesthesiaProcNotesMains.size()>0){
												OtPreAnaesthesiaProcNotesMain preAnaesthesiaProcNotesMain = anaesthesiaProcNotesMains.get(0);
												ipdOpdSurgeryDetailList.get(0).setRemarks(preAnaesthesiaProcNotesMain.getPreOperativeAdvice()+","+preAnaesthesiaProcNotesMain.getRemarks()+","+preAnaesthesiaProcNotesMain.getDoctorNotes());
											}
										}
									}
								}
							

			diagList = session.createCriteria(DgOrderhd.class)
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.Id", id)).list();
			ipPrescriptionList = session
					.createCriteria(PatientStoreIndentHeader.class)
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.Id", id)).list();
			headerList=session.createCriteria(OpdSurgeryDetail.class)
			.createAlias("OpdSurgery", "OpdSurgery")
			.createAlias("OpdSurgery.Hin", "p")
			.add(Restrictions.eq("p.Id", hinId))
			.createAlias("OpdSurgery.Inpatient", "ip")
			.add(Restrictions.eq("ip.Id", id)).list();

			operationsList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId))
					.createAlias("Inpatient", "ip")
					.add(Restrictions.eq("ip.Id", id)).list();
			map.put("ipPrescriptionList", ipPrescriptionList);
			
			
			  map.put("ipdPatientPrescriptionHeaderList",ipdPatientPrescriptionHeaderList);
			  map.put("ipdPatientInvestigationHeaderList",ipdPatientInvestigationHeaderList);
			  map.put("ipdOpdSurgeryHeaderList",ipdOpdSurgeryHeaderList);
			  map.put("ipdOpdSurgeryDetailList",ipdOpdSurgeryDetailList); // added by amit das on 28-09-2016
			  map.put("vitalListIP",vitalListIP);
			  map.put("inpatientPrescriptionDetailsList",inpatientPrescriptionDetailsList);
			  map.put("dgOrderHd", dgOrderhds);
			  map.put("DgOrderdtList",DgOrderdtList);
		} 
		
		else if (opOrString.equals("OP")) {
			String opdRemarks="";
			String consultation="";
			/*Done By Awadhesh Singh*/
			String hql1 = " FROM OpdPatientDetails opd where opd.Visit.Id = "+visitId;
			Query query = session.createQuery(hql1);
			List<OpdPatientDetails> opdDetails = query.list();
			
			
			for(OpdPatientDetails row : opdDetails){
				
			/*Done By Awadhesh Singh*/
			
			if(null !=row.getOpdRemarks())
				opdRemarks=row.getOpdRemarks();
			if(null !=row.getSummaryConsultation())
				consultation=row.getSummaryConsultation();
			
			}
			map.put("opdRemarks", opdRemarks);//Added By Awadhesh Singh
			map.put("consultation", consultation);//Added By Awadhesh Singh
			map.put("opdDetails", opdDetails);//Awadhesh Singh
			Visit visit=null;
			visitList = (List<Visit>) session.createCriteria(Visit.class)
					.add(Restrictions.eq("Id", id)).list();
			if(visitList.size()>0)
			visit = visitList.get(0);
			if (detailId.equals("OP-Mlc")) {
				mlcCaseList = (List<MlcCase>) session
						.createCriteria(MlcCase.class)
						.add(Restrictions.eq("VisitNo", visit.getVisitNo()))
						.add(Restrictions.eq("Hin.Id", hinId)).list();
			}
			 else if (detailId.equals("Investigation")) {
 					patientInvestigationList = (List<PatientInvestigationHeader>) session
							.createCriteria(PatientInvestigationHeader.class)
							.createAlias("Hin", "p")
					 		.add(Restrictions.eq("p.Id", hinId))
					 		.createAlias("Visit", "v").add(Restrictions.eq("v.Id", visitId))
							.list();
 					map.put("patientInvestigationList",patientInvestigationList);
			}
			
			dischargeIcdCodeList = session
					.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "visit")
					.add(Restrictions.eq("visit.Id", id)).list();
			
			if(detailId.equalsIgnoreCase("diag")){
				List<DischargeIcdCode>diagnosis=(List<DischargeIcdCode>)session.createCriteria(DischargeIcdCode.class)
				 		.createAlias("Visit", "v")
				 		.add(Restrictions.eq("v.Id",id))
				 		.list();
				String strDiag="";
				
				for(DischargeIcdCode diagStr:diagnosis){
					if(strDiag.equals("")){
						strDiag=diagStr.getIcd().getIcdName();
					}else{
						strDiag=strDiag+"\n"+ diagStr.getIcd().getIcdName();
					}
				}	
				
				// Added by Dhananjay kumar 27-feb-17
				if(strDiag.equals("")){
					/*SQLQuery query = session.createSQLQuery("select  from OpdPatientDetails where visit_id  = :visit_id");
					query.setParameter("visit_id", id);*/
					
					String hql = " FROM OpdPatientDetails opd where opd.Visit.Id  = '"+id+"'";
					Query query1 = session.createQuery(hql);
					List<OpdPatientDetails> results = query1.list();
					
					
					for(OpdPatientDetails row : results){
						if(null !=row.getInitialDiagnosis())
						strDiag=row.getInitialDiagnosis();
						
						/*Done By Awadhesh Singh*/
						
						if(null !=row.getOpdRemarks())
							opdRemarks=row.getOpdRemarks();
						if(null !=row.getSummaryConsultation())
							consultation=row.getSummaryConsultation();
							
					}
				}
					map.put("diagnosisIcd",strDiag);
					
			}
			
			List<ProcedureDetails>procedureDetailsList=new ArrayList<ProcedureDetails>();
			if(detailId.equalsIgnoreCase("Procedures")){
				procedureDetailsList=(List<ProcedureDetails>)session.createCriteria(ProcedureDetails.class)
						.createAlias("ProcedureHeader", "prc")
				 		.createAlias("prc.Visit", "v")
				 		.add(Restrictions.eq("v.Id",id))
				 		.list();
					map.put("procedureDetailsList",procedureDetailsList);
			}
			
			 //Code Added By Ujjwal to retrieve vital data for OP on 07012016 at 04:33 pm
			if(detailId.equalsIgnoreCase("Vitals")){
				vitalList=(List<OpdPatientDetails>)session.createCriteria(OpdPatientDetails.class)
				 		.createAlias("Visit", "v")
				 		.add(Restrictions.eq("v.Id",id))
				 		.list();
				if(vitalList.size()>0){
					OpdPatientDetails opdVisitIds=(OpdPatientDetails)vitalList.get(0);
					map.put("vitalList",opdVisitIds);
					if(opdVisitIds!=null){
						if(opdVisitIds.getPulse()!=0){
							map.put("vitalListSize",1);
						}
						if(opdVisitIds.getTemperature()!=0){
							map.put("vitalListSize",1);
						}
						if(opdVisitIds.getHeight()!=null  && opdVisitIds.getHeight()!=0){
							map.put("vitalListSize",1);
						}
						if(opdVisitIds.getWeight()!=null && opdVisitIds.getWeight()!=0){
							map.put("vitalListSize",1);
						}
						if(opdVisitIds.getBmi()!=0){
							map.put("vitalListSize",1);	
						}
						if(!opdVisitIds.getBp().equals("")){
							map.put("vitalListSize",1);
						}
					}else{
						map.put("vitalListSize",0);
					}
				}
				
			}
			
			if(detailId.equalsIgnoreCase("pre-opc")){
				preOpcList=(List<OpdNursingPatientDetails>)session.createCriteria(OpdNursingPatientDetails.class)
				 		.createAlias("Visit", "v")
				 		.add(Restrictions.eq("v.Id",id)).setMaxResults(1)
				 		.list();
				if(preOpcList.size()>0){
					OpdNursingPatientDetails opnp=(OpdNursingPatientDetails)preOpcList.get(0);
					map.put("preOpc",preOpcList.get(0));
					map.put("preOpcSize",preOpcList.size());
				}
				
			}
			
			// ended By Ujjwal
			dgOrderhds = session.createCriteria(DgOrderhd.class) 
					.createAlias("Visit", "v")
					.add(Restrictions.eq("v.Id", id)).list(); 
			diagList = session.createCriteria(DgOrderhd.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId))
					.createAlias("Visit", "v", CriteriaSpecification.LEFT_JOIN)
					.add(Restrictions.eq("v.Id", id)).list();
			opPrescriptionList = session
					.createCriteria(PatientPrescriptionHeader.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId))
					.createAlias("Visit", "v").add(Restrictions.eq("v.Id", id))
					.list();
			headerList=session.createCriteria(OpdSurgeryHeader.class)
								//.createAlias("OpdSurgery", "OpdSurgery")
								.createAlias("Hin", "p")
								.add(Restrictions.eq("p.Id", hinId))
								//.createAlias("OpdSurgery.Visit", "v").add(Restrictions.eq("v.Id", id))
								.list();
			/*operationsList = session.createCriteria(OtBooking.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.Id", hinId))
					.createAlias("Visit", "v").add(Restrictions.eq("v.Id", id))
					.list();*/
			dischargeIcdCodeList = session
					.createCriteria(DischargeIcdCode.class)
					.createAlias("Visit", "visit")
					.add(Restrictions.eq("visit.Id", id)).list();
			
			ipdPatientPrescriptionHeaderList=session.createCriteria(PatientPrescriptionHeader.class,"pph")
					  .createAlias("pph.Visit", "v")
					  .add(Restrictions.eq("v.Hin", visit.getHin()))
					   .setMaxResults(5)
					  .list();
			 ipdPatientInvestigationHeaderList=session.createCriteria(PatientInvestigationHeader.class,"pih")
					  .createAlias("pih.Visit", "v")
					 .add(Restrictions.eq("v.Hin", visit.getHin()))
					  .list();
			  
			  ipdOpdSurgeryHeaderList=session.createCriteria(OpdSurgeryHeader.class,"osh")
					  .createAlias("osh.Visit", "v")
					 .add(Restrictions.eq("v.Hin", visit.getHin()))
					  .setMaxResults(5)
					   .list();
			  
			  map.put("ipdPatientPrescriptionHeaderList",ipdPatientPrescriptionHeaderList);
			  map.put("ipdPatientInvestigationHeaderList",ipdPatientInvestigationHeaderList);
			  map.put("ipdOpdSurgeryHeaderList",ipdOpdSurgeryHeaderList);
			  map.put("opPrescriptionList", opPrescriptionList);
			  
			  map.put("dgOrderHd", dgOrderhds);

		}
		 }catch (Exception e) {
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
		map.put("dischargeIcdCodeList", dischargeIcdCodeList);
		map.put("visitList", visitList);
		map.put("mlcCaseList", mlcCaseList);
		map.put("transferList", transferList);
		map.put("silDilStatusList", silDilStatusList);
		if(dischargeList.size()>0){
		map.put("dischargeList", dischargeList);
		}else{
			map.put("dischargeList", dischargeList1);
		}
		map.put("diagList", diagList);
		map.put("operationsList", operationsList);
		//
		map.put("headerList", headerList);
		map.put("inPatientList", inPatientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemsForPrescription(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PatientPrescriptionDetails> prescpDetailsList = new ArrayList<PatientPrescriptionDetails>();
		List<PatientStoreIndentDetails> patientIndDetailsList = new ArrayList<PatientStoreIndentDetails>();
		Session session = getSession();

		if (box.getInt("presHdId") != 0) {
			prescpDetailsList = session
					.createCriteria(PatientPrescriptionDetails.class)
					.createAlias("Prescription", "p")
					.add(Restrictions.eq("p.Id", box.getInt("presHdId")))
					.list();
			map.put("prescpDetailsList", prescpDetailsList);

		} else if (box.getInt("presIndHdId") != 0) {
			patientIndDetailsList = session
					.createCriteria(PatientStoreIndentDetails.class)
					.createAlias("PatientStoreIndentHeader", "p")
					.add(Restrictions.eq("p.Id", box.getInt("presIndHdId")))
					.list();
			map.put("patientIndDetailsList", patientIndDetailsList);

		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPatientDetailsForFinalBill(int patientHinId,String patientIpd)
	{

		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
		List<Object[]> chargeSlipList = new ArrayList<Object[]>();
		List<Object[]> advanceSlipList = new ArrayList<Object[]>();
		List<Object[]> dispenseDetailsList = new ArrayList<Object[]>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<BlPackageBill> packageBillList = new ArrayList<BlPackageBill>();

		List<Object[]> paidAmtList = new ArrayList<Object[]>();
		List<BigDecimal> servAdvList = new ArrayList<BigDecimal>();
		List<BigDecimal> dispAdvList = new ArrayList<BigDecimal>();
		List<Object[]> adviceDtList = new ArrayList<Object[]>();
		List<Object[]> adviceDispDtList = new ArrayList<Object[]>();

		Session session = (Session) getSession();
		int inpatientId = 0;
		Criteria crit = null;
		try
		{
			crit = session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", patientIpd));
			crit = crit.createAlias("Hin", "p").add(Restrictions.eq("p.Id", patientHinId));
			patientDetailsList = crit.list();

			if (patientDetailsList.size() > 0) {
				inpatientId = patientDetailsList.get(0).getId();
				map.put("patientDetailsList", patientDetailsList);
			}

			if (inpatientId != 0)
			{
				chargeSlipList=getHibernateTemplate().find("select mcc.Id,mcc.MainChargecodeName,sum(csd.Quantity), sum(csd.NetAmt),mcc.MainChargecodeCode from jkt.hms.masters.business.BlChargeSlipDetail as csd join csd.ChargeSlipMain as csm join csd.ChargeCode as cc join cc.MainChargecode as mcc where csm.Inpatient='"+inpatientId+"' and csd.Status='y' and csm.PackageBill is null group by mcc.MainChargecodeCode,mcc.MainChargecodeName,mcc.Id");

				if (chargeSlipList.size() > 0) {
					map.put("chargeSlipList", chargeSlipList);
				}

				advanceSlipList = getHibernateTemplate().find("select bd.ReceiptDate, bd.Amount, bd.PaymentMode from jkt.hms.masters.business.BlReceiptHeader as bh left join bh.BlReceiptDetails as bd where bh.ReceiptType = 'adv' and bh.Hin.Id = '"+patientHinId+"' and bh.Inpatient.Id = '"+inpatientId+"'");

				if (advanceSlipList.size() > 0) {
					map.put("advanceSlipList", advanceSlipList);
				}

				String qryForDispense = "SELECT msi.item_id,msi.nomenclature, sum(dd.qty) ,sum(dd.net_amt)"
				+ " FROM bl_dispensing_header dh left join bl_dispensing_details dd on dh.dispensing_header_id = dd.dispensing_header_id"
				+" left join mas_store_item msi on dd.item_id = msi.item_id where dh.inpatient_id = "+ inpatientId
				+ " and dh.package_bill_id is null and dh.status = 'y' group by msi.item_id,msi.nomenclature";

				//dispenseDetailsList = session.createSQLQuery(qryForDispense).list();
				dispenseDetailsList =getHibernateTemplate().find("select msi.Id,msi.Nomenclature, sum(dd.Qty) ,sum(dd.NetAmt) " +
				" from jkt.hms.masters.business.BlDispensingDetails as dd join dd.DispensingHeader as dh join dd.Item as msi " +
				"where dh.Inpatient='"+inpatientId+"' and dh.PackageBill is null and dh.Status='y' " +
				"group by msi.Id,msi.Nomenclature");

				if (dispenseDetailsList.size() > 0) {
					map.put("dispenseDetailsList", dispenseDetailsList);
				}

				packageBillList = session.createCriteria(BlPackageBill.class).createAlias("Inpatient", "ip")
				.add(Restrictions.eq("ip.Id", inpatientId)).list();

				String[] resType = { "chs", "bld", "pkb" };

				paidAmtList = session.createCriteria(BlReceiptHeader.class).add(Restrictions.in("ReceiptType", resType))
				.createAlias("Inpatient", "ip").add(Restrictions.eq("ip.Id", inpatientId))
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

		}
		catch (HibernateException e)
		{
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
		return map;
	}

	@Override
	public Map<String, Object> showPatientEpfJsp() {
			Map<String, Object> map = new HashMap<String, Object>();
				return map ;
		
	}

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> showWardWiseDetails(Map<String, Object>detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = null;
		session = (Session) getSession();
		String deptName="";
		try{
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String time = (String) utilMap.get("currentTime");
			List<Inpatient> inPatientList = new ArrayList<Inpatient>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			int hospitalId = (Integer)detailMap.get("hospitalId");
			departmentList = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "deptType")
			.add(Restrictions.eq("deptType.DepartmentTypeCode", "WARD")).list();
			List<String> listStr = new ArrayList<String>();
			listStr.add("A");listStr.add("R");
			inPatientList = session.createCriteria(Inpatient.class).add(Restrictions.in("Department", departmentList)).add(Restrictions.in("AdStatus", listStr))
							.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Department.Id")).list();
			//inPatientList = session.createCriteria(Inpatient.class).add(Restrictions.eq("Department.Id", 44)).list();
			map.put("inPatientList", inPatientList);
			map.put("deptName", deptName);
			map.put("departmentList", departmentList);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> showPaitentDetail(Box box) {
		Map<String, Object> objectMap=new HashMap<String,Object>();
		List<PatientAddress> patientAddressList =new ArrayList<PatientAddress>();
		PatientAddress patientAddress=null;
		UploadDocuments uploadDocuments=null;
		Patient patient=null;
		String ehrAccsess="";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Transaction tx=null;
		Session session=getSession(); 
		String countEhr[] = null;
		int eherCount=0;
		
		try {
			tx = session.beginTransaction();
		patientAddress=(PatientAddress)session.createCriteria(PatientAddress.class)
				.createAlias("Hin", "p")
				.createAlias("AddressType", "AT")
				.add(Restrictions.eq("p.HinNo", box.getString("hin_no")))
				//.add(Restrictions.eq("AT.AddressTypeCode", "p").ignoreCase())
				.add(Restrictions.eq("AT.AddressTypeCode", "C").ignoreCase())//Changed by arbind on 13-01-2017
				.uniqueResult();
		patient=(Patient)session.createCriteria(Patient.class)
				.add(Restrictions.eq("HinNo", box.getString("hin_no")))
				.uniqueResult();
		
	
		if( patient!=null){
			uploadDocuments=(UploadDocuments)session.createCriteria(UploadDocuments.class)
					.add(Restrictions.eq("Hin.Id", patient.getId()))
					.uniqueResult();
		Patient ehrpatient = (Patient) hbt.load(Patient.class,patient.getId());
		ehrAccsess=ehrpatient.getEhrAccessDetail();
		
		
		
		if(ehrAccsess==null){
		ehrpatient.setEhrAccessDetail(box.getString("name")+" "+box.getString("addEditDate")+" "+box.getString("editTime"));
		}
		else if (ehrAccsess!=null) {
			ehrpatient.setEhrAccessDetail(ehrAccsess+","+box.getString("name")+" "+box.getString("addEditDate")+" "+box.getString("editTime"));
		}
		if(ehrAccsess!=null){
			countEhr=ehrAccsess.split(",");
			eherCount=countEhr.length;
		}
		
		//added by govind 8-12-2016
		patientAddressList=session.createCriteria(PatientAddress.class)
				.createAlias("Hin", "p")
				.createAlias("AddressType", "AT")
				.add(Restrictions.eq("p.HinNo", box.getString("hin_no"))).list();
		//added by govind 8-12-2016 end
				
		hbt.update(ehrpatient);
		tx.commit();
		}
		}catch(Exception e){
			e.printStackTrace();
			if (tx == null) {
				tx.rollback();
			}
			
		}
		objectMap.put("patientAddress", patientAddress);
		objectMap.put("paitent", patient);
		objectMap.put("uploadDocument", uploadDocuments);
		objectMap.put("eherCount", eherCount);
		objectMap.put("patientAddressList", patientAddressList);
		return objectMap;
	}

	@Override
	public Map<String, Object> investigationResult(Box box) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String orderNo = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		int chargeCodeId=0;
		Criteria crit = null;
		try {
			if (box.get("orderNo") != null) {
				orderNo = (String) box.get("orderNo");
			}
			
			if (box.get("chargeCodeId") != null) {
				chargeCodeId = box.getInt("chargeCodeId");
			}
			Session session = (Session) getSession();

			List<DgOrderhd> hdList = new ArrayList<DgOrderhd>();
			hdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("OrderNo", orderNo)).list();
			List<DgOrderhd> dtList = new ArrayList<DgOrderhd>();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			if (!orderNo.equals("")) {
				dgResultEntryHeaderByOrderNo = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.Id", chargeCodeId)) 
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo)) 
						.add(Restrictions.eq("Verified", "V").ignoreCase()) 
						.createAlias("MainChargecode", "mcc")
						/*.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB")) */
					
						.addOrder(Order.asc("Id")).list();
			}
			
			List<UploadDocuments> documentList = new ArrayList<UploadDocuments>();
			int resultHeaderId=0;
			
			for(DgResultEntryHeader header : dgResultEntryHeaderByOrderNo)
			{
				resultHeaderId = header.getId();
			}
			
			System.out.println("resultHeaderId="+resultHeaderId);
			
			documentList = session
					.createCriteria(UploadDocuments.class)
					.createAlias("ResultEntry", "resultEntry")
					.add(Restrictions.eq("resultEntry.Id", resultHeaderId)).list();
			
			detailsMap.put("documentList", documentList);
			
			
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("Investigation", "inv")
						.add(Restrictions.eq("inv.Id", chargeCodeId)) 
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo)) 
						.add(Restrictions.eq("Verified", "V").ignoreCase()) 
						.createAlias("MainChargecode", "mcc")
						/*.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))*/
						.createAlias("SubChargecode", "subCharg")
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
												.property("subCharg.SubChargecodeName"))));

				subChargeCodeGroup = crit.list();
			}
			

			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();

			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				detailsMap.put("dgResultEntryHeaderByOrderNo",
						dgResultEntryHeaderByOrderNo);

			}

			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSens().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSens().iterator().next();
				}
			}
			if (flag) {
				if (dgResultEntryDetailForData.getResultEntry().getHin() != null) {
					detailsMap.put("hinNo", dgResultEntryDetailForData
							.getResultEntry().getHin().getHinNo());
				}

				detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrder().getDepartment().getDepartmentName());
				/*
				 * detailsMap.put("departmentType",session.getAttribute("deptId")
				 * );
				 */

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
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());

				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
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
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
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
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getRank() != null) {
						String entryPersonNameDesignation = e1.getRank()
								.getRankName();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

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
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getRank() != null) {
						String verifiedPersonNameDesignation = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			} else {
				if (dgResultEntryDetailSenForData.getResultEntry() != null) {
					if (dgResultEntryDetailSenForData.getResultEntry().getHin() != null) {
						detailsMap.put("hinNo", dgResultEntryDetailSenForData
								.getResultEntry().getHin().getHinNo());
					}

					detailsMap.put("orderByDepartment",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSampleCollectionHeader().getOrder()
									.getDepartment().getDepartmentName());

					Patient p = dgResultEntryDetailSenForData.getResultEntry()
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
					detailsMap.put("orderNo", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderNo());
					detailsMap.put("orderDate", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderDate());

					detailsMap.put("patientAge", p.getAge());
					detailsMap
							.put("sex", p.getSex().getAdministrativeSexName());
					detailsMap.put("resultDate", dgResultEntryDetailSenForData
							.getResultEntry().getResultDate());
					detailsMap.put("subChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSubChargecode().getSubChargecodeName());
					detailsMap.put("mainChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getMainChargecode()
									.getMainChargecodeName());
					detailsMap.put("charge", dgResultEntryDetailSenForData
							.getInvestigation().getInvestigationName());
					String clinicalNote = dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getClinicalNote();
					detailsMap.put("clinicalNote", clinicalNote);
					String confidential = dgResultEntryDetailSenForData
							.getInvestigation().getConfidential();
					if (confidential != null && !confidential.equals("")
							&& !confidential.equalsIgnoreCase("n")) {
						detailsMap.put("confidential", "y");
					} else {
						detailsMap.put("confidential", "n");
					}

					MasEmployee e = dgResultEntryDetailSenForData
							.getResultEntry().getSampleCollectionHeader()
							.getOrder().getPrescribedBy();
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
						detailsMap.put("doctorName", dFirst + " " + dMiddleName
								+ " " + dLastName);
					}

					MasEmployee e1 = dgResultEntryDetailSenForData
							.getResultEntry().getEmployee();
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
						detailsMap.put("entryPersonName", eFirst + " "
								+ eMiddleName + " " + eLastName);
						if (e1.getRank() != null) {
							String entryPersonNameDesignation = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameDesignation",
									entryPersonNameDesignation);
						}
						if (e1.getRank() != null) {
							String entryPersonNameRank = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameRank",
									entryPersonNameRank);

						}

					}
					MasEmployee e2 = dgResultEntryDetailSenForData
							.getResultEntry().getResultVerifiedBy();
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
						detailsMap.put("verifiedPersonName", vFirst + " "
								+ vMiddleName + " " + vLastName);
						if (e2.getRank() != null) {
							String verifiedPersonNameDesignation = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameDesignation",
									verifiedPersonNameDesignation);
						}
						if (e2.getRank() != null) {
							String verifiedPersonNameRank = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameRank",
									verifiedPersonNameRank);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	@Override
	public Map<String, Object> saveClinicalObservation(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> sampleCollectionDetailsList = new ArrayList<DgSampleCollectionDetails>();
		List<DgResultEntryHeader> resultEntryHeaderList = new ArrayList<DgResultEntryHeader>();
		Set<DgResultEntryDetail> resultEntryDetailSet = new HashSet<DgResultEntryDetail>();
		Session session = (Session)getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean flag = false;
		int val=0;
		if(box.getInt("flag")!=0){
			
			val=box.getInt("flag");
		}
		sampleCollectionDetailsList = session.createCriteria(DgSampleCollectionDetails.class).createAlias("SampleCollectionHeader", "sch").add(Restrictions.eq("sch.Order.Id", box.getInt("dgHeaderId")))
				.add(Restrictions.eq("ChargeCode.Id", box.getInt("chargeCodeId"))).list();
		System.out.println("val ------------->>>>"+val);
		if(val==1){
		if(sampleCollectionDetailsList.size()>0){
			for(DgSampleCollectionDetails sampleDetails : sampleCollectionDetailsList){
				resultEntryDetailSet = sampleDetails.getDgResultEntryDetails();
				for(DgResultEntryDetail dgResultEntryDetail :resultEntryDetailSet){
					int resultEntryDetailId =dgResultEntryDetail.getId();
					DgResultEntryDetail dgResultEntryDt = (DgResultEntryDetail)hbt.load(DgResultEntryDetail.class, resultEntryDetailId);
					if(!box.get("clinicalObservation").equals("")){
						dgResultEntryDetail.setRemarks(box.get("clinicalObservation"));
						hbt.update(dgResultEntryDetail);
						flag = true;
					}
				}
			}
			
			
		}
		}else if(val==2){
			for(DgSampleCollectionDetails sampleDetails : sampleCollectionDetailsList){
				resultEntryDetailSet = sampleDetails.getDgResultEntryDetails();
				for(DgResultEntryDetail dgResultEntryDetail :resultEntryDetailSet){
					int resultEntryDetailId =dgResultEntryDetail.getId();
					DgResultEntryDetail dgResultEntryDt = (DgResultEntryDetail)hbt.load(DgResultEntryDetail.class, resultEntryDetailId);
					if(!box.get("clinicalObservation").equals("")){
						dgResultEntryDetail.setRemarksOne(box.get("clinicalObservation"));
						hbt.update(dgResultEntryDetail);
						flag = true;
					}
				}
			}
			
			
		}else if(val==3){

			for(DgSampleCollectionDetails sampleDetails : sampleCollectionDetailsList){
				resultEntryDetailSet = sampleDetails.getDgResultEntryDetails();
				for(DgResultEntryDetail dgResultEntryDetail :resultEntryDetailSet){
					int resultEntryDetailId =dgResultEntryDetail.getId();
					DgResultEntryDetail dgResultEntryDt = (DgResultEntryDetail)hbt.load(DgResultEntryDetail.class, resultEntryDetailId);
					if(!box.get("clinicalObservation").equals("")){
						dgResultEntryDetail.setRemarksTwo(box.get("clinicalObservation"));
						hbt.update(dgResultEntryDetail);
						flag = true;
					}
				}
			}
			
			
		
		}else if(val==4){

			for(DgSampleCollectionDetails sampleDetails : sampleCollectionDetailsList){
				resultEntryDetailSet = sampleDetails.getDgResultEntryDetails();
				for(DgResultEntryDetail dgResultEntryDetail :resultEntryDetailSet){
					int resultEntryDetailId =dgResultEntryDetail.getId();
					DgResultEntryDetail dgResultEntryDt = (DgResultEntryDetail)hbt.load(DgResultEntryDetail.class, resultEntryDetailId);
					if(!box.get("clinicalObservation").equals("")){
						dgResultEntryDetail.setRemarksThree(box.get("clinicalObservation"));
						hbt.update(dgResultEntryDetail);
						flag = true;
					}
				}
			}
			
			
		
		}else if(val==5){

			for(DgSampleCollectionDetails sampleDetails : sampleCollectionDetailsList){
				resultEntryDetailSet = sampleDetails.getDgResultEntryDetails();
				for(DgResultEntryDetail dgResultEntryDetail :resultEntryDetailSet){
					int resultEntryDetailId =dgResultEntryDetail.getId();
					DgResultEntryDetail dgResultEntryDt = (DgResultEntryDetail)hbt.load(DgResultEntryDetail.class, resultEntryDetailId);
					if(!box.get("clinicalObservation").equals("")){
						dgResultEntryDetail.setRemarksFour(box.get("clinicalObservation"));
						hbt.update(dgResultEntryDetail);
						flag = true;
					}
				}
			}
			
			
		
		}
		map.put("flag", flag);
		return map;
	}
	public List<Patient> getPatientList(String hinNo) {
		List<Patient> patientList = new ArrayList<Patient>();
		Session session=(Session) getSession();
		Criteria crt=null,crt1=null;
		crt1=session.createCriteria(Patient.class)
				 .add(Restrictions.eq("HinNo", hinNo))
				 .add(Restrictions.eq("PatientStatus", "Expired"));
		patientList=crt1.list();
			 
		return patientList;
	}	
}
