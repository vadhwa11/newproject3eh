package jkt.hms.appointment.dataservice;


import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AGEUNIT;
import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;
import static jkt.hms.util.RequestConstants.APPOINTMENT_ID;
import static jkt.hms.util.RequestConstants.APPOINTMENT_NO;
import static jkt.hms.util.RequestConstants.BEFORETIME;
import static jkt.hms.util.RequestConstants.BREAKFROMTIME;
import static jkt.hms.util.RequestConstants.BREAKFROMTIME2;
import static jkt.hms.util.RequestConstants.BREAKFROMTIME3;
import static jkt.hms.util.RequestConstants.BREAKTOTIME;
import static jkt.hms.util.RequestConstants.BREAKTOTIME2;
import static jkt.hms.util.RequestConstants.BREAKTOTIME3;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DAYS;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DR;
import static jkt.hms.util.RequestConstants.EQUIPMENT_ID;
import static jkt.hms.util.RequestConstants.EQUIP_ID;
import static jkt.hms.util.RequestConstants.FROMTIME;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INVESTIGATION_ID;
import static jkt.hms.util.RequestConstants.MAXDAYS;
import static jkt.hms.util.RequestConstants.MINDAYS;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PERCENTAGE;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.SEX;
import static jkt.hms.util.RequestConstants.SLOTTIME;
import static jkt.hms.util.RequestConstants.TOTIME;
import static jkt.hms.util.RequestConstants.WARD_ID;

import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Vector;

import jkt.hms.adt.dataservice.RegistrationDataService;
import jkt.hms.masters.business.AppEquipmentMaster;
import jkt.hms.masters.business.AppInvestigationAppointments;
import jkt.hms.masters.business.AppInvestigationSetup;
import jkt.hms.masters.business.AppPatientAppointments;
import jkt.hms.masters.business.AppSetup;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.CentralServerPatientAppointmentData;
import jkt.hms.masters.business.CentralServerVisitData;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DialysisSchudeling;
import jkt.hms.masters.business.DialysisSetup;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.LeanServerPatientAppointmentData;
import jkt.hms.masters.business.LeanServerVisitData;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasInstituteDepartment;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.OpdHoliday;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.QueueManagment;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * @ author: Priyanka Garg Made on: 9th July 2008
 */

public class AppointmentDataServiceImpl extends HibernateDaoSupport implements
		AppointmentDataService {
	RegistrationDataService registrationDataService;
	
	private static final Logger logger = Logger.getLogger(AppointmentDataServiceImpl.class);
	
	public RegistrationDataService getRegistrationDataService() {
		return registrationDataService;
	}

	public void setRegistrationDataService(
			RegistrationDataService registrationDataService) {
		this.registrationDataService = registrationDataService;
	}

	public Map<String, Object> showAppSetupJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", 1)).list();
		

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("departmentList", departmentList);

		return map;

	}

	public Map<String, Object> getRecords(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<Object[]> employeeList = new ArrayList<Object[]>();
		String queryString = null;
		int departmentId = box.getInt(DEPARTMENT_ID);
		//int doctorId = box.getInt(RequestConstants.CONSULTING_DOCTOR);
		int hospitalId = box.getInt("hospitalId");
		
		queryString = "from AppSetup where Dept.Id=" + departmentId+" and Hospital.Id="+hospitalId+" order by Id asc";
		try {
			/*departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", 1)).list();*/
			
			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep").createAlias("dep.DepartmentType", "dt").add(Restrictions.eq("dt.Id", 1))
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			
			if(departmentId>0)
			appSetupList = getHibernateTemplate().find(queryString);
			logger.info("App : "+appSetupList.size());
			employeeList = session.createCriteria(MasEmployee.class).createAlias("EmpCategory", "empCat")
			.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id",hospitalId))
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("FirstName")).add(Projections.property("LastName"))
					.add(Projections.property("Department.Id")).add(Projections.property("empCat.EmpCategoryCode"))).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("appSetupList", appSetupList);
		map.put("employeeList", employeeList);
 
		return map;
	}

	public boolean submitAppointmentSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		/*Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);*/
		
		Vector breakFromTime2 = box.getVector("TokenStart");
		
		Vector breakToTime2 = box.getVector("TokenInterval");
		
		Vector breakFromTime3 = box.getVector("TotalToken");
		
		/*Vector breakToTime3 = box.getVector(BREAKTOTIME3);*/
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		
		Vector numberOfPatients = box.getVector("numberofPatient");
		
		/*Vector beforeTime = box.getVector(BEFORETIME);*/
		int departmentId = box.getInt(DEPARTMENT_ID);
		//System.out.println("departmentId >>>  "+departmentId);
		
		int doctorId = box.getInt(RequestConstants.CONSUNTANT);
		int hospitalId = box.getInt("hospitalId");
		//String userName = box.getString("userName");
		
		int sessionId = box.getInt("sessionId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i <= 6; i++) {
			try {
				AppSetup appSetup = new AppSetup();
				appSetup.setDays((String) days.get(i));
				//appSetup.setNoOfDoctor(1);
				/*if (!dr.get(i).equals("") && dr.get(i) != null) {
					appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				} else {
					appSetup.setNoOfDoctor(0);
				}*/
			/*	appSetup.setFromTime((String) fromTime.get(i));
				appSetup.setToTime((String) toTime.get(i));
				appSetup.setSlotDuration((String) slotTime.get(i));*/

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appSetup.setPercentageForSlots(0);
				}*/
				//appSetup.setBreakFromTime((String) breakFromTime.get(i));
				//appSetup.setBreakToTime((String) breakToTime.get(i));
				//System.out.println(" #@#@  "+breakFromTime3.get(i));
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals("")){
				appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
				}else{
					appSetup.setTotalToken(null);
				}
				
				if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals("")){
				appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));
				}else{
					appSetup.setTotalInterval(null);
				}
				
				if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals("")){
				appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));
				}else{
					appSetup.setStartToken(null);
				}
				//appSetup.setBreakToTime3((String) breakToTime3.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(null);
				}

				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(null);
				}
				
				
				if (!numberOfPatients.get(i).equals("") && numberOfPatients.get(i) != null) {
					appSetup.setNumberOfPatients(Integer.parseInt((String) numberOfPatients
							.get(i)));
				} else {
					appSetup.setNumberOfPatients(null);
				}
				
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appSetup.setDept(masDepartment);

				if (doctorId !=0 ) {
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(doctorId);
					appSetup.setDoctor(masEmployee);

				}
				
				if(sessionId!=0){
					MasSession masSession  = new MasSession();
					masSession.setId(sessionId);
					appSetup.setSession(masSession);
				}


				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appSetup.setHospital(masHospital);
				
				Users user = new Users();
				user.setId(Integer.parseInt(box.get("usersId")));
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);

				hbt.save(appSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	public boolean updateAppointmentSetup(Box box) {
		//Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		/*Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);*/
		Vector breakFromTime2 = box.getVector("TokenStart");
		
		Vector breakToTime2 = box.getVector("TokenInterval");
		
		Vector breakFromTime3 = box.getVector("TotalToken");
		
		/*Vector breakFromTime2 = box.getVector(BREAKFROMTIME2);
		Vector breakToTime2 = box.getVector(BREAKTOTIME2);
		Vector breakFromTime3 = box.getVector(BREAKFROMTIME3);
		Vector breakToTime3 = box.getVector(BREAKTOTIME3);*/
		
		Vector numberofPatient = box.getVector("numberofPatient");
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		Vector beforeTime = box.getVector(BEFORETIME);
		Vector departmentId = box.getVector(DEPARTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int i = 0;

		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		
		
		for (i = 0; i <= appointmentId.size() - 1; i++) {
			try {
				AppSetup appSetup = (AppSetup) hbt.load(AppSetup.class,
						Integer.parseInt((String) appointmentId.get(i)));
				appSetup.setDays((String) days.get(i));
			//	appSetup.setNoOfDoctor(1);
				/*if (!dr.get(i).equals("") && dr.get(i) != null) {
					appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				} else {
					appSetup.setNoOfDoctor(0);
				}*/

				/*appSetup.setFromTime((String) fromTime.get(i));
				appSetup.setToTime((String) toTime.get(i));
				appSetup.setSlotDuration((String) slotTime.get(i));*/

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appSetup.setPercentageForSlots(0);
				}*/
				//appSetup.setBreakFromTime((String) breakFromTime.get(i));
				//appSetup.setBreakToTime((String) breakToTime.get(i));
				//appSetup.setBreakFromTime2((String) breakFromTime2.get(i));
				//appSetup.setBreakToTime2((String) breakToTime2.get(i));
				//appSetup.setBreakFromTime3((String) breakFromTime3.get(i));
				//appSetup.setBreakToTime3((String) breakToTime3.get(i));
				
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals(""))
				{
					appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
				}else{
					appSetup.setTotalToken(null);
				}
					
					if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals("")){
						appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));	
					}else{
						appSetup.setTotalInterval(null);
					}
					
					
					if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals("")){
						appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));
					}else{
						appSetup.setStartToken(null);
					}					


				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(null);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(null);
				}
				if (!numberofPatient.get(i).equals("") && numberofPatient.get(i) != null) {
					appSetup.setNumberOfPatients(Integer.parseInt((String) numberofPatient
							.get(i)));
				} else {
					appSetup.setNumberOfPatients(null);
				}
				
				Users user = new Users();
				user.setId(Integer.parseInt(box.get("usersId")));
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);

				hbt.update(appSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}

		}

		while (i <= 6) {
			try {
				AppSetup appSetup = new AppSetup();
				appSetup.setDays((String) days.get(i));
				if (!dr.get(i).equals("") && dr.get(i) != null) {
				//	appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				}
				/*appSetup.setFromTime((String) fromTime.get(i));
				appSetup.setToTime((String) toTime.get(i));
				appSetup.setSlotDuration((String) slotTime.get(i));
*/
				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appSetup.setPercentageForSlots(0);
				}*/
				if(null !=breakFromTime3.get(i) && !breakFromTime3.get(i).equals(""))
					appSetup.setTotalToken(Integer.parseInt((String)breakFromTime3.get(i)));
					
					if(null !=breakToTime2.get(i) && !breakToTime2.get(i).equals(""))
					appSetup.setTotalInterval(Integer.parseInt((String) breakToTime2.get(i)));
					
					if(null !=breakFromTime2.get(i) && !breakFromTime2.get(i).equals(""))
					appSetup.setStartToken(Integer.parseInt((String) breakFromTime2.get(i)));

				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					appSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					appSetup.setMinNoOfDays(0);
				}

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(Integer.parseInt((String) departmentId
						.get(0)));
				appSetup.setDept(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appSetup.setHospital(masHospital);

				Users user = new Users();
				user.setId(Integer.parseInt(box.get("usersId")));
				appSetup.setLastChgBy(user);
				
				appSetup.setLastChgDate(date);
				appSetup.setLastChgTime(time);

				hbt.save(appSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
			i++;
		}

		return dataSaved;
	}

	/**
	 * ---------------------------- PATIENT APPOINTMENTS --------------------
	 */
	public Map<String, Object> showAppointmentPatientJsp(Map<String, Object> dtailsMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		List<MasEmployee> employeeList=new ArrayList<MasEmployee>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		int hospitalId = (Integer)dtailsMap.get("hospitalId");
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", 1)).list();

			holidayList = session.createCriteria(OpdHoliday.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

			employeeList = session.createCriteria(MasEmployee.class)
			.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("holidayList", holidayList);

		map.put("employeeList", employeeList);

		return map;

	}

	public Map<String, Object> showAppointmentPatientDepartmentWise(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<AppPatientAppointments> patientAppointmentList = new
		// ArrayList<AppPatientAppointments>();
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		List<AppPatientAppointments> patientAppointmentsList = new ArrayList<AppPatientAppointments>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<AppPatientAppointments> slotAvailableList = new ArrayList<AppPatientAppointments>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		String slotList[][] = null;

		int departmentId = box.getInt(DEPARTMENT_ID);
		int doctorId = box.getInt(RequestConstants.CONSULTING_DOCTOR);

		int noOfDoctors = 0;
		int counter = 1;
		int noOfSlots = 0;
		int percentageForSlots = 0;

		Integer[] noOfDoctorsList = new Integer[200];
		String queryString = null;
		//String breakFromTime = "00:00:00";
		//String breakToTime = "00:00:00";
		String days[] = new String[8];
		Time d_fromTime = Time.valueOf("00:00:00");
		Time d_toTime = Time.valueOf("00:00:00");
		Time d_slotDuration = Time.valueOf("00:00:00");
		Time d_breakFromTime = Time.valueOf("00:00:00");
		Time d_breakToTime = Time.valueOf("00:00:00");
		Time d_breakFromTime2 = Time.valueOf("00:00:00");
		Time d_breakToTime2 = Time.valueOf("00:00:00");
		Time d_breakFromTime3 = Time.valueOf("00:00:00");
		Time d_breakToTime3 = Time.valueOf("00:00:00");

		int totalAppointments = 0;
		int maxNoOfDays = 0;
		int minNoOfDays = 0;
		Date maxDate = new Date();
		Date minDate = new Date();
		Date sysDate = new Date();
		Date apmtDate = new Date();
		int hospitalId=box.getInt("hospitalId");
		//System.out.println("hospitalId>>"+hospitalId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_appointmentDate = Calendar.getInstance();
		if (box.get(APPOINTMENT_DATE) != null
				&& !box.get(APPOINTMENT_DATE).equals("")) {
			c_appointmentDate
					.setTime(HMSUtil.convertStringTypeDateToDateType(box
							.get(APPOINTMENT_DATE)));
			apmtDate = HMSUtil.convertStringTypeDateToDateType(box
					.get(APPOINTMENT_DATE));
		}
		String formattedDate = sdf.format(c_appointmentDate.getTime());
		days[1] = "Sunday";
		days[2] = "Monday";
		days[3] = "Tuesday";
		days[4] = "Wednesday";
		days[5] = "Thursday";
		days[6] = "Friday";
		days[7] = "Saturday";

		queryString = "from AppSetup where Dept=" + departmentId
				+ " and Days='"+ days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)] + "' and  doctor_id="+doctorId;
				
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", 1)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			appSetupList = getHibernateTemplate().find(queryString);
			patientAppointmentsList = getHibernateTemplate().find(
					"from AppPatientAppointments apmt where Department="
							+ box.getInt(DEPARTMENT_ID)
							+ " and AppointmentDate='" + formattedDate + "'");

			if (appSetupList != null && appSetupList.size() > 0) {
				Iterator ite = appSetupList.iterator();
				while (ite.hasNext()) {
					AppSetup appSetup = (AppSetup) ite.next();
					if (appSetup.getFromTime() != null
							&& !appSetup.getFromTime().equals("")) {
						d_fromTime = Time.valueOf(appSetup.getFromTime());
					} else {
						d_fromTime = Time.valueOf("00:00:00");
					}
					if (appSetup.getToTime() != null
							&& !appSetup.getToTime().equals("")) {
						d_toTime = Time.valueOf(appSetup.getToTime());
					} else {
						d_toTime = Time.valueOf("00:00:00");
					}
					if (appSetup.getSlotDuration() != null
							&& !appSetup.getSlotDuration().equals("")) {
						d_slotDuration = Time.valueOf(appSetup
								.getSlotDuration());
					} else {
						d_slotDuration = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakFromTime() != null
							&& !appSetup.getBreakFromTime().equals("")) {
						d_breakFromTime = Time.valueOf(appSetup
								.getBreakFromTime());
					} else {
						d_breakFromTime = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakToTime() != null
							&& !appSetup.getBreakToTime().equals("")) {
						d_breakToTime = Time.valueOf(appSetup.getBreakToTime());
					} else {
						d_breakToTime = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakFromTime2() != null
							&& !appSetup.getBreakFromTime2().equals("")) {
						d_breakFromTime2 = Time.valueOf(appSetup
								.getBreakFromTime2());
					} else {
						d_breakFromTime2 = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakToTime2() != null
							&& !appSetup.getBreakToTime2().equals("")) {
						d_breakToTime2 = Time.valueOf(appSetup.getBreakToTime2());
					} else {
						d_breakToTime2 = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakFromTime3() != null
							&& !appSetup.getBreakFromTime3().equals("")) {
						d_breakFromTime3 = Time.valueOf(appSetup
								.getBreakFromTime3());
					} else {
						d_breakFromTime3 = Time.valueOf("00:00:00");
					}
					if (appSetup.getBreakToTime3() != null
							&& !appSetup.getBreakToTime3().equals("")) {
						d_breakToTime3 = Time.valueOf(appSetup.getBreakToTime3());
					} else {
						d_breakToTime3 = Time.valueOf("00:00:00");
					}
					if (appSetup.getNoOfDoctor() != null
							&& !(appSetup.getNoOfDoctor() == 0)) {
					//	noOfDoctors = appSetup.getNoOfDoctor();
					} else {
						noOfDoctors = 0;
					}
					if (appSetup.getMaxNoOfDays() != null
							&& !(appSetup.getMaxNoOfDays() == 0)) {
						maxNoOfDays = appSetup.getMaxNoOfDays();
					} else {
						maxNoOfDays = 0;
					}
					if (appSetup.getMinNoOfDays() != null
							&& !(appSetup.getMinNoOfDays() == 0)) {
						minNoOfDays = appSetup.getMinNoOfDays();
					} else {
						minNoOfDays = 0;
					}
					if (appSetup.getPercentageForSlots() != null
							&& !(appSetup.getPercentageForSlots() == 0)) {
						percentageForSlots = appSetup.getPercentageForSlots();
					} else {
						percentageForSlots = 0;
					}
					maxDate = new Date(c_appointmentDate.getTimeInMillis()
							- maxNoOfDays * 24 * 60 * 60 * 1000);
					minDate = new Date(c_appointmentDate.getTimeInMillis()
							- minNoOfDays * 24 * 60 * 60 * 1000);
					Date minParsedDate = null;
					Date sysParsedDate = null;
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						minParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(minDate));
						sysParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(sysDate));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					/*System.out.println(sysDate+"   "+c_appointmentDate+"  "+minDate+"  "+maxDate);
					System.out.println(minParsedDate+"   minParsedDate");
					System.out.println((sysDate.compareTo(maxDate)) +"   com   "+(sysDate.compareTo(minDate)) );*/

					if (sysDate.compareTo(maxDate) >= 0	&& (sysDate.compareTo(minDate) < 0 ||
						    sysParsedDate.equals(minParsedDate)) && apmtDate.compareTo(sysDate) >= 0) {
						
						map = calculateSlotsDoc(d_fromTime, d_toTime,d_slotDuration, d_breakFromTime, d_breakToTime,d_breakFromTime2, d_breakToTime2,d_breakFromTime3, d_breakToTime3 );
								
					//	map = calculateSlots(d_fromTime, d_toTime,	d_slotDuration, d_breakFromTime, d_breakToTime);
							
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");

						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfDoctors * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {

									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									slotAvailableList = getHibernateTemplate()
											.find("from AppPatientAppointments where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and AppointmentDate='"
													+ formattedDate + "'");
									int temp = noOfDoctors
											- slotAvailableList.size();
									noOfDoctorsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						} else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else if (minNoOfDays == 0 || maxNoOfDays == 0) {
						map = calculateSlots(d_fromTime, d_toTime,
								d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");
						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfDoctors * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									slotAvailableList = getHibernateTemplate()
											.find("from AppPatientAppointments where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and AppointmentDate='"
													+ formattedDate + "'");
									int temp = noOfDoctors
											- slotAvailableList.size();
									noOfDoctorsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}

						else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else {
						String message = "Wrong Appointment Date!!";
						map.put("message", message);
					}
				}

			} else if (appSetupList != null && appSetupList.size() == 0) {

				String message = "Appointment Schedule for this department on the following day is not set.";
				map.put("message", message);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
	
		map.put("noOfDoctorsList", noOfDoctorsList);
		map.put("departmentList", departmentList);
		map.put("apmtDate", apmtDate);
		// map.put("patientAppointmentsList", patientAppointmentsList);

		return map;

	}

	/**
	 * ------------------------------------------------------------------------
	 * ------ common method for calculation of slots in both patient appointment
	 * screen and in investigation appointment screen.
	 *
	 * @param fromTime
	 * @param toTime
	 * @param slot
	 * @param breakFromTime
	 * @param breakToTime
	 * @return
	 *         ------------------------------------------------------------------
	 *         ------------
	 */
	public Map<String, Object> calculateSlots(Time fromTime, Time toTime,
			Time slot, Time breakFromTime, Time breakToTime) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		String slotList[][] = new String[200][2];

		Calendar c_fromTime = Calendar.getInstance();
		c_fromTime.setTime(fromTime);

		Calendar c_breakFromTime = Calendar.getInstance();
		c_breakFromTime.setTime(breakFromTime);

		Calendar c_breakToTime = Calendar.getInstance();
		c_breakToTime.setTime(breakToTime);

		Calendar c_toTime = Calendar.getInstance();
		c_toTime.setTime(toTime);

		Calendar c_slot = Calendar.getInstance();
		c_slot.setTime(slot);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date = sdf.format(c_fromTime.getTime());

		int counter = 0;

		while (c_fromTime.before(c_toTime)) {
			if ((c_fromTime.before(c_breakFromTime)) || (c_fromTime.after(c_breakToTime))) {
				slotList[counter][0] = sdf.format(fromTime);
				c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
				c_fromTime.add(Calendar.HOUR_OF_DAY,
						c_slot.get(Calendar.HOUR_OF_DAY));
				date = sdf.format(c_fromTime.getTime());
				slotList[counter][1] = date;
				fromTime = java.sql.Time.valueOf(date);
			} else {
				c_breakToTime.add(Calendar.HOUR_OF_DAY,
						-c_breakFromTime.get(Calendar.HOUR_OF_DAY));
				c_breakToTime.add(Calendar.MINUTE,
						-c_breakFromTime.get(Calendar.MINUTE));
				c_fromTime.add(Calendar.HOUR_OF_DAY,
						c_breakToTime.get(Calendar.HOUR_OF_DAY));
				c_fromTime.add(Calendar.MINUTE,
						c_breakToTime.get(Calendar.MINUTE));
				date = sdf.format(c_fromTime.getTime());
				fromTime = java.sql.Time.valueOf(date);
			}
			counter++;
		}
		slotList[counter][0] = sdf.format(fromTime);
		map.put("slotList", slotList);
		map.put("counter", counter);
		return map;

	}

	/**
	 * ------------------------------------------------------------------------
	 * ------ common method for calculation of slots in both patient appointment
	 * screen and in investigation appointment screen.
	 *
	 * @param fromTime
	 * @param toTime
	 * @param slot
	 * @param breakFromTime
	 * @param breakToTime
	 * @return
	 *         ------------------------------------------------------------------
	 *         ------------
	 */

	//==================================================================
	public Map<String, Object> calculateSlotsDoc(Time fromTime, Time toTime,
			Time slot, Time breakFromTime, Time breakToTime,Time breakFromTime2, Time breakToTime2,Time breakFromTime3, Time breakToTime3 ) {
		

		Map<String, Object> map = new HashMap<String, Object>();
		String slotList[][] = new String[200][2];

		Calendar c_fromTime = Calendar.getInstance();
		c_fromTime.setTime(fromTime);

		Calendar c_breakFromTime = Calendar.getInstance();
		c_breakFromTime.setTime(breakFromTime);

		Calendar c_breakToTime = Calendar.getInstance();
		c_breakToTime.setTime(breakToTime);

		Calendar c_breakFromTime2 = Calendar.getInstance();
		c_breakFromTime2.setTime(breakFromTime2);

		Calendar c_breakToTime2 = Calendar.getInstance();
		c_breakToTime2.setTime(breakToTime2);

		Calendar c_breakFromTime3 = Calendar.getInstance();
		c_breakFromTime3.setTime(breakFromTime3);

		Calendar c_breakToTime3 = Calendar.getInstance();
		c_breakToTime3.setTime(breakToTime3);

		Calendar c_toTime = Calendar.getInstance();
		c_toTime.setTime(toTime);

		Calendar c_slot = Calendar.getInstance();
		c_slot.setTime(slot);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String date = sdf.format(c_fromTime.getTime());

		int counter = 0;
		//int kk = 0;
		while (c_fromTime.before(c_breakToTime)) {

		 //   if(c_fromTime.before(c_breakFromTime2))  {

					if (((c_fromTime.before(c_breakFromTime)) ||  (c_fromTime.after(c_breakToTime))))  {

						slotList[counter][0] = sdf.format(fromTime);
						c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_slot.get(Calendar.HOUR_OF_DAY));
						date = sdf.format(c_fromTime.getTime());
						slotList[counter][1] = date;
						fromTime = java.sql.Time.valueOf(date);
					} else {

						c_breakToTime.add(Calendar.HOUR_OF_DAY,
								-c_breakFromTime.get(Calendar.HOUR_OF_DAY));
						c_breakToTime.add(Calendar.MINUTE,
								-c_breakFromTime.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_breakToTime.get(Calendar.HOUR_OF_DAY));
						c_fromTime.add(Calendar.MINUTE,
								c_breakToTime.get(Calendar.MINUTE));
						date = sdf.format(c_fromTime.getTime());
						fromTime = java.sql.Time.valueOf(date);
					}
					counter++;
		  //  }

		}


		while (c_fromTime.before(c_breakToTime2)) {

		 //   if(c_fromTime.before(c_breakFromTime2))  {

					if (((c_fromTime.before(c_breakFromTime2)) ||  (c_fromTime.after(c_breakToTime2))))  {

						slotList[counter][0] = sdf.format(fromTime);
						c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_slot.get(Calendar.HOUR_OF_DAY));
						date = sdf.format(c_fromTime.getTime());
						slotList[counter][1] = date;
						fromTime = java.sql.Time.valueOf(date);

					} else {
						c_breakToTime2.add(Calendar.HOUR_OF_DAY,
								-c_breakFromTime2.get(Calendar.HOUR_OF_DAY));
						c_breakToTime2.add(Calendar.MINUTE,
								-c_breakFromTime2.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_breakToTime2.get(Calendar.HOUR_OF_DAY));
						c_fromTime.add(Calendar.MINUTE,
								c_breakToTime2.get(Calendar.MINUTE));
						date = sdf.format(c_fromTime.getTime());
						fromTime = java.sql.Time.valueOf(date);
					}
					counter++;
		   // }

		}
		while (c_fromTime.before(c_toTime)) {

			 //   if(c_fromTime.before(c_breakFromTime2))  {

						if (((c_fromTime.before(c_breakFromTime3)) || (c_fromTime.after(c_breakToTime3)))) {

							slotList[counter][0] = sdf.format(fromTime);
							c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
							c_fromTime.add(Calendar.HOUR_OF_DAY,
									c_slot.get(Calendar.HOUR_OF_DAY));
							date = sdf.format(c_fromTime.getTime());
							slotList[counter][1] = date;
							fromTime = java.sql.Time.valueOf(date);

						} else {
							c_breakToTime3.add(Calendar.HOUR_OF_DAY,
									-c_breakFromTime3.get(Calendar.HOUR_OF_DAY));
							c_breakToTime3.add(Calendar.MINUTE,
									-c_breakFromTime3.get(Calendar.MINUTE));
							c_fromTime.add(Calendar.HOUR_OF_DAY,
									c_breakToTime3.get(Calendar.HOUR_OF_DAY));
							c_fromTime.add(Calendar.MINUTE,
									c_breakToTime3.get(Calendar.MINUTE));
							date = sdf.format(c_fromTime.getTime());
							fromTime = java.sql.Time.valueOf(date);
						}
						counter++;
			   // }

			}








	/*	while (c_fromTime.before(c_toTime)) {

			    if(c_fromTime.before(c_breakFromTime2))  {

						if (((c_fromTime.before(c_breakFromTime)) ||  (c_fromTime.after(c_breakToTime))))  {

							slotList[counter][0] = sdf.format(fromTime);
							date = sdf.format(c_fromTime.getTime());
							c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
							c_fromTime.add(Calendar.HOUR_OF_DAY,
									c_slot.get(Calendar.HOUR_OF_DAY));

							slotList[counter][1] = date;
							fromTime = java.sql.Time.valueOf(date);
						} else {

							c_breakToTime.add(Calendar.HOUR_OF_DAY,
									-c_breakFromTime.get(Calendar.HOUR_OF_DAY));
							c_breakToTime.add(Calendar.MINUTE,
									-c_breakFromTime.get(Calendar.MINUTE));
							c_fromTime.add(Calendar.HOUR_OF_DAY,
									c_breakToTime.get(Calendar.HOUR_OF_DAY));
							c_fromTime.add(Calendar.MINUTE,
									c_breakToTime.get(Calendar.MINUTE));
							date = sdf.format(c_fromTime.getTime());
							fromTime = java.sql.Time.valueOf(date);
						}
			    }

			    if(c_fromTime.after(c_breakFromTime2) && (c_fromTime.before(c_breakFromTime3)))  {
					if (((c_fromTime.before(c_breakFromTime2)) || (c_fromTime.after(c_breakToTime2)))) {
						slotList[counter][0] = sdf.format(fromTime);
						date = sdf.format(c_fromTime.getTime());
						c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_slot.get(Calendar.HOUR_OF_DAY));

						slotList[counter][1] = date;
						fromTime = java.sql.Time.valueOf(date);
					} else {

						c_breakToTime2.add(Calendar.HOUR_OF_DAY,
								-c_breakFromTime2.get(Calendar.HOUR_OF_DAY));
						c_breakToTime2.add(Calendar.MINUTE,
								-c_breakFromTime2.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_breakToTime2.get(Calendar.HOUR_OF_DAY));
						c_fromTime.add(Calendar.MINUTE,
								c_breakToTime2.get(Calendar.MINUTE));
						date = sdf.format(c_fromTime.getTime());
						fromTime = java.sql.Time.valueOf(date);
					}
			    }else if ((c_fromTime.after(c_breakFromTime3))){

				  	if (((c_fromTime.before(c_breakFromTime3)) || (c_fromTime.after(c_breakToTime3)))) {
						slotList[counter][0] = sdf.format(fromTime);
						date = sdf.format(c_fromTime.getTime());
						c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_slot.get(Calendar.HOUR_OF_DAY));

						slotList[counter][1] = date;
						fromTime = java.sql.Time.valueOf(date);
					} else {
						c_breakToTime3.add(Calendar.HOUR_OF_DAY,
								-c_breakFromTime3.get(Calendar.HOUR_OF_DAY));
						c_breakToTime3.add(Calendar.MINUTE,
								-c_breakFromTime3.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_breakToTime3.get(Calendar.HOUR_OF_DAY));
						c_fromTime.add(Calendar.MINUTE,
								c_breakToTime3.get(Calendar.MINUTE));
						date = sdf.format(c_fromTime.getTime());
						fromTime = java.sql.Time.valueOf(date);
					}
			    }else{

				    	slotList[counter][0] = sdf.format(fromTime);
						date = sdf.format(c_fromTime.getTime());
						c_fromTime.add(Calendar.MINUTE, c_slot.get(Calendar.MINUTE));
						c_fromTime.add(Calendar.HOUR_OF_DAY,
								c_slot.get(Calendar.HOUR_OF_DAY));

						slotList[counter][1] = date;
						fromTime = java.sql.Time.valueOf(date);

			    }


			counter++;
		} */
		slotList[counter][0] = sdf.format(fromTime);
		map.put("slotList", slotList);
		map.put("counter", counter);
		return map;

	}
	//==========================================================================
	public Map<String, Object> showExistingPatients(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		boolean recordExists = true;

		try {
			registeredPatientList = session
					.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", box.getString(SERVICE_NO)))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("registeredPatientList", registeredPatientList);
		if (registeredPatientList.size() > 0) {
			recordExists = true;
		} else {
			recordExists = false;
		}
		map.put("recordExists", recordExists);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> showListBasedonHinNo(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> listBasedonHinNo = new ArrayList<Patient>();
		boolean hinNoExist = true;
		try {
			listBasedonHinNo = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", box.getString(HIN_NO)))
					.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("listBasedonHinNo", listBasedonHinNo);
		if (listBasedonHinNo.size() > 0) {
			hinNoExist = true;
		} else {
			hinNoExist = false;
		}
		//System.out.println( box.getString(HIN_NO)+"    @@  "+listBasedonHinNo);
		map.put("hinNoExist", hinNoExist);
		map.put("listBasedonHinNo", listBasedonHinNo);
		map.put("box", box);
		return map;
	}

	public Map<String, Object> checkForHinNo(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("appointmentDate"));
		boolean patientNameExist = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(AppPatientAppointments.class)
					.add(Restrictions.eq("AppointmentStatus", "y"))
					.add(Restrictions.eq("AppointmentDate", apmtDate))
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", box.getInt(WARD_ID)));

			if (!box.getString(HIN_ID).equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id",
								Integer.parseInt(box.getString(HIN_ID))));
			}
			if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName",
						box.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age",
						box.getString(AGE) + " " + box.getString(AGEUNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo",
						box.get(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex",
						box.getString(SEX)));
			}
			hinList = criteria.list();

			if (box.getString(HIN_NO).equals("")
					&& !box.getString(PATIENT_NAME).equals("")
					&& hinList.size() > 0) {
				patientNameExist = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinList", hinList);
		map.put("patientNameExist", patientNameExist);
		return map;
	}
	

	public Map<String, Object> checkForApmtInDiffDept(Box box) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		
		//Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
			//	.getString("appointmentDate"));
		
		//int doctorId = box.getInt("loddrs");
		int departmentId = box.getInt("department");

		int hospitalId = box.getInt("hospitalId");
		
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("appointmentDate"));
		
		int phinid=box.getInt("phinId");
		
		boolean recordExists = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(AppPatientAppointments.class)
					.createAlias("Department", "dep").createAlias("Hospital", "hosp").createAlias("Hin", "pt")
					.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase())
					.add(Restrictions.eq("AppointmentDate", appointmentDate))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
					.add(Restrictions.eq("pt.Id", phinid));

			
			
			/*if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName",
						box.getString(PATIENT_NAME)));
			}*/
			/*if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age",
						box.getString(AGE) + " " + box.getString(AGE_UNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo",
						box.get(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex",
						box.getString(SEX)));
			}
*/
			hinList = criteria.list();
			if (hinList != null && hinList.size() > 0) {
				recordExists = true;
				System.out.println("recordExists "+recordExists);
				/*Iterator ite = hinList.iterator();
				while (ite.hasNext()) {
					AppPatientAppointments appPatientAppointments = (AppPatientAppointments) ite
							.next();
					if (!appPatientAppointments.getDepartment().getId()
							.equals(box.getInt(WARD_ID))) {
						recordExists = true;
						map.put("existingDept", appPatientAppointments
								.getDepartment().getDepartmentName());
						map.put("existingStartTime",
								appPatientAppointments.getFromTimeSlot());
						map.put("existingEndTime",
								appPatientAppointments.getToTimeSlot());
					}

				}*/

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("recordExists", recordExists);
		map.put("hinList", hinList);
		return map;
	}

	public List<Patient> showExistingPatientDetail(Integer hinId) {
		Session session = (Session) getSession();
		//Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();

		try {
			registeredPatientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return registeredPatientList;
	}
	
	public List<Patient> showExistingPatientDetailForDialysis(Integer hinId) {
		Session session = (Session) getSession();
		//Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();

		try {
			registeredPatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", hinId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return registeredPatientList;
	}

	public String generateAppointmentNo(Date appointmentDate, int departmentId,
			int appointmentId, String var_prefix) {
		String appointmentNo = null;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		String date = sdf.format(appointmentDate);
		/**
		 * format of appointment no. AP as prefix - Appointment date in ddmmyyyy
		 * format - departmentId - appointmentId
		 */
		appointmentNo = var_prefix + "-" + date + "-" + departmentId + "-"
				+ appointmentId;
		return appointmentNo;
	}
	
	public String generateAppointmentNoForDialysis(String appointmentDays, int departmentId,
			int appointmentId, String var_prefix) {
		String appointmentNo = null;
		//SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		//String date = sdf.format(appointmentDate);
		/**
		 * format of appointment no. AP as prefix - Appointment date in ddmmyyyy
		 * format - departmentId - appointmentId
		 */
		appointmentNo = var_prefix + "-" + appointmentDays + "-" + departmentId + "-"
				+ appointmentId;
		return appointmentNo;
	}

	@SuppressWarnings("unchecked")
	public synchronized Map<String, Object> submitPatientAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppPatientAppointments> hinList = new ArrayList<AppPatientAppointments>();
		List<Patient> patientList=new ArrayList<Patient>();
		List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<>();
		Session session = (Session) getSession();
		String opdStartTime = null;
		String rankCode = null;
		int avgNoOfPatients = 0;
		boolean dataSaved = false;
		boolean duplicateRecord = false;
		String appointmentNo = null;
		int hinId=0;
		int queuePriority=0;
		boolean uhidStatus=false;
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
		String reportingTime = null;
		String fromTimeSlot = box.getString("visitTime");
		String review = null;
		//String toTimeSlot = box.getString("TOTIMESLOT");
		
		int departmentId = box.getInt("department");
		queuePriority=box.getInt("preQueue");
		
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("appointmentDate"));
		String mobileNo = box.get("mob");
		
		int doctorId = box.getInt("loddrs");
		int unitId=0;
		if(box.get("HospitalUnit")!=null){
			unitId=box.getInt("HospitalUnit");
		}
		if(box.get("review")!=null){
			review=box.get("review");
		}
		
		String visitTime=null;
		if(box.getString("visitTime")!=null && !"".equals(box.getString("visitTime"))){
			visitTime=box.getString("visitTime");
		}

		int hospitalId = box.getInt("hospitalId");
		//String userName = box.getString("userName");
		int userId= Integer.parseInt(""+box.get("userId"));
		
		String message="";
		String Uhid="";
		Uhid=box.get("uhid");
		
		String patientName="";
		String sex="";
		String age="";
		String appointmentDetail="";
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", Uhid)).list();
		 for(Patient pat:patientList){
			 
			 hinId=pat.getId();
			 patientName=pat.getPFirstName();
			 if(null !=pat.getSex())
			 sex=pat.getSex().getAdministrativeSexName();
			 age=pat.getAge();
			 
		 }
		logger.info("patient hinNo "+Uhid);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean patientNameExist = false;
		boolean recordExists = false;

		box.put("phinId", hinId);
		map = checkForApmtInDiffDept(box);
		
		/*String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");*/
		if (map.get("recordExists") != null) {
			recordExists = (Boolean) map.get("recordExists");
		}
		/*map = checkForHinNo(box);
		if (hinList != null) {
			hinList = (List) map.get("hinList");
		}*/

		/*patientNameExist = (Boolean) map.get("patientNameExist");*/

		int visitSession=0;
		
		
		visitSession=box.getInt("opsession");
		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
				                .createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 1)).list();
				
				
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		appointmentDetail = box.getString("appointmentDetail");
		List<AppPatientAppointments> appList= new ArrayList<AppPatientAppointments>();
		if(appointmentDetail!=null && !appointmentDetail.equals("W")){
			//added by govind 2017-05-26
			appList = session.createCriteria(AppPatientAppointments.class)
					.createAlias("Department", "dept") 
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dept.Id",departmentId))
					.add(Restrictions.eq("AppointmentDate",appointmentDate))
					.add(Restrictions.eq("QueuePriority",queuePriority)).add(Restrictions.eq("AppSession.Id", visitSession))
					.list();
			//added by govind 2017-05-26
		}else{
			appList = session.createCriteria(AppPatientAppointments.class)
					.createAlias("Department", "dept") 
					.createAlias("Hospital", "hosp")
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dept.Id",departmentId))
					.add(Restrictions.eq("AppointmentDate",appointmentDate))
					.list();
		}

		try {
			//int i = 0;
			if(appList.size()>0){
				message=queuePriority+ " is already taken";
				logger.info(queuePriority+" is already taken");
				map.put("message",message);
			}else{
				logger.info(queuePriority+" is not already taken");
			AppPatientAppointments appPatientAppointments = new AppPatientAppointments();
			appPatientAppointments.setFromTimeSlot((String) fromTimeSlot);
			/*appPatientAppointments.setToTimeSlot((String) toTimeSlot);*/

			appPatientAppointments.setAppointmentDate(appointmentDate);
			appPatientAppointments.setQueuePriority(queuePriority);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appPatientAppointments.setDepartment(masDepartment);

			Patient patient = hbt.get(Patient.class, hinId);
			if (patient!=null) {
				//patient.setId(hinId);
				appPatientAppointments.setHin(patient);
				appPatientAppointments.setRegisteredStatus("y");
				appPatientAppointments.setAge(age);
				uhidStatus=true;
			} else {
				appPatientAppointments.setRegisteredStatus("n");
				/*if (ageUnit != null) {
					appPatientAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appPatientAppointments.setAge((String) age);
				}*/
			}
			/*if (serviceNo != null && !serviceNo.equals("")) {
				appPatientAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appPatientAppointments
						.setServicePersonName((String) servicePerson);
			}*/
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appPatientAppointments.setEmployee(masEmployee);
			}
			MasSession massession=null;
			if(visitSession>0){
				massession=new MasSession();
				massession.setId(visitSession);
				appPatientAppointments.setAppSession(massession);
			}
			appPatientAppointments.setPatientName((String) patientName);
			appPatientAppointments.setMobileNo(mobileNo);
			appPatientAppointments.setSex((String) sex);

			appPatientAppointments.setAppointmentStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appPatientAppointments.setHospital(masHospital);
			
			Users u = new Users();
			u.setId(userId);
			appPatientAppointments.setLastChgBy(u);
			appPatientAppointments.setLastChgDate(date);
			appPatientAppointments.setLastChgTime(time);
			
			
			//added by govind 23-05-2017 for appointment added in visit directly
			Users user=new Users();
			user.setId(userId);
			String visitAge="";
			Map<String,Object> mapTot=null;
			List<Visit> visitList = new ArrayList<Visit>();
			int visitNo=0;
			Integer totalHospitalVisitNo=0;
			visitList=session.createCriteria(Visit.class)
					.createAlias("Hin", "hin")
		    		.add(Restrictions.eq("hin.Id",patient.getId()))
		    		.addOrder(Order.desc("Id"))
		    		.list();
			if(visitList.size()>0)
				visitNo=visitList.get(0).getVisitNo()+1;
			else
				visitNo=1;

			Patient pat=hbt.load(Patient.class, hinId);
			if(pat!=null){
			visitAge=pat.getAge();
			}
			
			mapTot=getTotalVistByHospital(masHospital.getId(), departmentId, appointmentDate,patient.getId(),visitSession,masHospital.getHospitalCode());
			if(null !=mapTot.get("TotaltokenNo")){
				totalHospitalVisitNo=(Integer)mapTot.get("TotaltokenNo");

				if(totalHospitalVisitNo==0){
					totalHospitalVisitNo++;
				}
			}
			Visit visit=new Visit();
			QueueManagment queue=new QueueManagment();
			visit.setDepartment(masDepartment);
			queue.setDepartment(masDepartment);
			visit.setHin(patient);
			queue.setHin(patient);
			visit.setCashReceivedStatus("n");
			visit.setCashNotReceivedReason("");
			visit.setPriorityNumber(3);
			//Added by Arbind on 15-12-2017 for doctor_id
			//if (doctorId !=0 ) {
				/*MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);*/
				MasEmployee masEmployee = (MasEmployee)session.get(MasEmployee.class, doctorId);
				if(masEmployee!=null){
					rankCode =	masEmployee.getRank().getRankCode();
					if(rankCode==null || !rankCode.equals("366")){
						visit.setDoctor(masEmployee);
						queue.setDocotor(masEmployee);
						queue.setInitialDr(masEmployee);
					}
				}
				//}
			visit.setDoctorName(null);
			visit.setUnit(null);
			//if(appointmentDetail!=null && !appointmentDetail.equals("W")){
				visit.setVisitSession(massession);
			//}			
			visit.setAddEditBy(user);
			visit.setVisitNo(visitNo);//--savevisitnumber function
			visit.setTokenNo(queuePriority);//token_no
			queue.setTokenNo(queuePriority);
			visit.setHin(patient);//hinId
			visit.setAge(visitAge);//age
			visit.setVisitDate(appointmentDate);//visitdate
			queue.setLsCngDate(appointmentDate);
			if(visitTime!=null && !visitTime.equals("")){
				logger.info("visit time "+visitTime);
				visit.setVisitTime(visitTime); 
				queue.setOpVisitTime(visitTime);
			}else{
			visit.setVisitTime("07:01");
			queue.setOpVisitTime("07:01");
			}
			visit.setCurPharVisitStatus("Y");//cur_phar_visit_status 'Y'
			visit.setVisitStatus("w");//visit_status "w"
			queue.setTokenStatus("w");
			visit.setAppointmentType("A");//appointment_type = 'A'
			visit.setStatus("Y");//status = 'Y'
			visit.setHospital(masHospital); // hospitalid
			queue.setHospital(masHospital);
			visit.setPriorityNumber(3); //priority no =3
			visit.setTotalHospitalVisit(totalHospitalVisitNo); //totalhospitalvisit
			queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
			visit.setReferralStatus("n");// referstatus ='n'
			visit.setEdStatus("n");//added by govind 15-07-2017 for lean and central server problem
			
			visit.setDisplayAfterNo(queuePriority-1); // added by amit das on 24-07-2017 for op wating list sorting
			visit.setLastDisplayAfterNo(queuePriority-1); 
			
			/*Added By Srikanth Start*/
			if(unitId>0){                // adding Unit
				HospitalDoctorUnitM hospUnitM=new HospitalDoctorUnitM();
				 hospUnitM.setId(unitId);
				visit.setUnit(hospUnitM);
			}
			visit.setAddEditDate(date);
			visit.setAddEditTime(time);
			/*Added By Srikanth End*/
			queue.setLastChgDate(new Date());
			queue.setLastChgTime("");
			queue.setVisit(visit);
			//added by govind 23-05-2017 end 
			
			
			// condition added by amit das on 29-08-2017
			masHospital =(MasHospital)session.get(MasHospital.class, hospitalId); 
			if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
				visit.setCreationSource("C");
			}else if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
				visit.setCreationSource("L");
			}

			
				instituteDepartmentList = session
						.createCriteria(MasInstituteDepartment.class)
						.add(Restrictions.eq("Institute.Id", hospitalId))
						.add(Restrictions.eq("Department.Id", departmentId))
						.list();
				opdStartTime = instituteDepartmentList.get(0).getOpeningTime();

				if (instituteDepartmentList.get(0).getAvgNoOfPatients() != null
						&& opdStartTime != null) {
					avgNoOfPatients = instituteDepartmentList.get(0)
							.getAvgNoOfPatients();
					Date opdDate = timeFormat.parse(opdStartTime);
					Calendar cal = new GregorianCalendar();
					cal.setTime(opdDate);

					cal.add(Calendar.HOUR_OF_DAY, visit.getTokenNo()
							/ avgNoOfPatients);
					reportingTime = timeFormat.format(cal.getTime());
					visit.setReportingTime(reportingTime);
					visit.setVisitTime(reportingTime);
				}
			
			List<Visit> visitlist=new ArrayList<Visit>();
			List<QueueManagment> managements=new ArrayList<QueueManagment>(); 
			
			if(uhidStatus){
			if ( hinList != null) {
				if (hinList.size() == 0 && recordExists == false ) {
					hbt.save(appPatientAppointments);
					hbt.save(visit);//added by govind 23-05-2017
					hbt.save(queue);
					
					visitlist.add(visit);
					managements.add(queue);
					
					int appointmentId = appPatientAppointments.getId();
					
					appointmentNo = generateAppointmentNo(appointmentDate,
							departmentId, appointmentId, "AP");
					
					AppPatientAppointments appPatientAppointments1 = (AppPatientAppointments) hbt
							.get(AppPatientAppointments.class, appointmentId);
					appPatientAppointments1.setAppointmentNo(appointmentNo);
					hbt.saveOrUpdate(appPatientAppointments1);
					
					
					appPatientAppointments.setAppointmentNo(appointmentNo); // added by amit das on 11-08-2017
					
					
					
					
					dataSaved = true;
					duplicateRecord = false;
					map.put("appointmentNo", appointmentNo);
					
					String patientMobileNumber = visit.getHin().getMobileNumber();
					if(review!=null && (patientMobileNumber!=null && !patientMobileNumber.trim().equals(""))){
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
						MasDepartment department =(MasDepartment)session.get(MasDepartment.class, departmentId);
						OneToOne one = new OneToOne();
						String smsText = "Dear "+pat.getPFirstName()+((pat.getPMiddleName()!=null)?" "+pat.getPMiddleName()+" ":"")+((pat.getPLastName()!=null)?pat.getPLastName():"")+", Your appointment on "+simpleDateFormat.format(appointmentDate)+" for "+
						"Hospital: "+masHospital.getShortName()+" Dept: "+department.getDepartmentName()+" is confirmed."+
						" Your Token Number is "+queuePriority+" & Reporting Time is : "+appPatientAppointments.getFromTimeSlot()+".";
						one.setMobileNo(patientMobileNumber);
						//one.setMessage("Your Appointment for "+appPatientAppointments.getDepartment().getDepartmentName()+" on "+simpleDateFormat.format(appointmentDate)+" is configured and the token no is "+appPatientAppointments.getQueuePriority());
						one.setMessage(smsText);
						one.setStatus("U");
						one.setType("T");
						one.setHospital(masHospital);
						one.setSentDate(new Date());
						one.setSentTime(time);
						hbt.save(one);
					}
					//added by govind for LeanAndCentral Server 26-05-2017

			        
					final MasHospital hospital=(MasHospital)session.get(MasHospital.class, hospitalId);
					final List<Visit> finalVisitlist=visitlist;
					final List<QueueManagment> finalManagements=managements; 
					final BlOpBillHeader finalOpBillHeader=null;
					final BlOpBillDetails finalOpBillDetails=null;
					final Patient finalPatient = pat;
					final Visit finalVisit = visit;
					final AppPatientAppointments finalAppPatientAppointments = appPatientAppointments1;
					
					//#13- Tech Debt: Comment out the code those are related to Lean server
					/*new Thread(){
						public void run(){
							String serverSideName = null; // added by amit das on 09-08-2017
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							if(hospital!=null && hospital.getClientIp()!=null && !hospital.getClientIp().trim().equals("") && !hospital.getClientIp().trim().equals("null") && hospital.getClientPort()!=null && !hospital.getClientPort().trim().equals("") && !hospital.getClientPort().trim().equals("null")){
								Map<String,Object> data=registrationDataService.saveVisitInformationInLeanServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
								String message=(String)data.get("message");
								Parser p1 = new PipeParser(); 
						  	  	String encodedVisitDataMessage;
						  	  	serverSideName = "lean";
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
									
								// added by amit das on 09-08-2017	
								message = savePatientDataForAppointmentToLeanCentralServer(finalAppPatientAppointments,hospital,serverSideName);
									
								
									
									
								} catch (HL7Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
								
							}
							if(hospital!=null && hospital.getServerIp()!=null && !hospital.getServerIp().trim().equals("") && !hospital.getServerIp().trim().equals("null") && hospital.getServerPort()!=null && !hospital.getServerPort().trim().equals("") && !hospital.getServerPort().trim().equals("null")){


								Map<String,Object> data=registrationDataService.saveVisitInformationInCentralServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
								String message=(String)data.get("message");
								Parser p1 = new PipeParser(); 
						  	  	String encodedVisitDataMessage;
						  	  	serverSideName = "central"; // added by amit das on 09-08-2017
								try {
									// encodedVisitDataMessage = p1.encode((ADT_A01)data.get("ADTMessage")); //commented by amit das on 19-12-2016
									List<ADT_A01> adt_A01List  = (List<ADT_A01>)data.get("ADTMessage"); // added by amit das on 19-12-2016
									
									if(adt_A01List!=null && adt_A01List.size()>0){ // added by amit das on 19-12-2016
									for(int i=0;i<adt_A01List.size();i++) {
									//if("success".equalsIgnoreCase(message)){ //commented by amit das on 19-12-2016
										encodedVisitDataMessage = p1.encode(adt_A01List.get(i));						
									
								  	  	CentralServerVisitData centralServerVisitData=new CentralServerVisitData();
										centralServerVisitData.setCentralVisitId(Long.parseLong(finalVisit.getId()+""));
										centralServerVisitData.setVisitData(encodedVisitDataMessage);
										centralServerVisitData.setHospitalId(Long.parseLong(hospital.getId()+""));  
										String visitSavedToLeanServer="N";
										centralServerVisitData.setStatus(visitSavedToLeanServer);   
										hbt.save(centralServerVisitData);
								  	}
								   }
									
									// added by amit das on 09-08-2017
									message = savePatientDataForAppointmentToLeanCentralServer(finalAppPatientAppointments,hospital,serverSideName);
									
										
									
								} catch (HL7Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
						  	  	
								
							}
						}
						}.start();*/
						
					//added by govind for LeanAndCentral Server 26-05-2017 end
				} else if ( recordExists == true) {
					message=
							 "This patient has already availed Appointment for this Department on selected date";
					map.put("message",message);
					dataSaved = false;
					duplicateRecord = true;
				} /*else if (recordExists == true && hinList.size() == 0
						&& patientNameExist == false) {
					map.put("existingDept", existingDept);
					map.put("existingStartTime", existingStartTime);
					map.put("existingEndTime", existingEndTime);
					duplicateRecord = false;
				} *//*else if (hinList.size() > 0 && patientNameExist == false
						&& recordExists == true) {
					map.put("message",
							patientName
									+ " already taken Appointment for this Department!!");
					map.put("existingDept", existingDept);
					map.put("existingStartTime", existingStartTime);
					map.put("existingEndTime", existingEndTime);
					dataSaved = false;
					duplicateRecord = true;
				}*/

			}
			}
			else{
				message=Uhid+ " is not valid UHID!";
				map.put("message",message);
			}
			map.put("recordExists", recordExists);
			map.put("patientNameExist", patientNameExist);

			map.put("dataSaved", dataSaved);
			map.put("appointmentDate", appointmentDate);
			map.put("patientName", patientName);
			map.put("duplicateRecord", duplicateRecord);
			map.put("queuePriority", queuePriority);
			map.put("age", age);
			map.put("sex", sex);
			}
		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		map.put("phinId", hinId);
		return map;
	}

	public Map<String, Object> submitDulicatePatientNameAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		String appointmentNo = null;

		String fromTimeSlot = box.getString("returnStartTime");
		String toTimeSlot = box.getString("returnEndTime");
		int departmentId = box.getInt("returnDeptId");
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("returnAppointmentDate"));
		String patientName = box.getString("returnPatientName");
		String sex = box.getString("returnSex");
		String age = box.getString("returnAge");
		String ageUnit = box.getString("returnAgeUnit");
		// String serviceNo = box.getString("returnServiceNo");
		// String servicePerson = box.getString("returnServicePerson");
		String hinId = box.getString("returnHinId");
		String mobileNo = box.get("returnMobileNo");
		int doctorId = box.getInt("returnDoctorId");
		int hospitalId = box.getInt("hospitalId");
		//String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AppPatientAppointments appPatientAppointments = new AppPatientAppointments();
			appPatientAppointments.setFromTimeSlot((String) fromTimeSlot);
			appPatientAppointments.setToTimeSlot((String) toTimeSlot);

			appPatientAppointments.setAppointmentDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appPatientAppointments.setDepartment(masDepartment);

			Patient patient = new Patient();
			if (hinId != null && !hinId.equals("")) {
				patient.setId(Integer.parseInt(hinId));
				appPatientAppointments.setHin(patient);
				appPatientAppointments.setRegisteredStatus("y");
				appPatientAppointments.setAge(age);

			} else {
				appPatientAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appPatientAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appPatientAppointments.setAge((String) age);
				}
			}
			/*
			 * if(serviceNo!=null && !serviceNo.equals("")) {
			 * appPatientAppointments.setServiceNo((String)serviceNo); }
			 * if(servicePerson!=null && !servicePerson.equals("")) {
			 * appPatientAppointments
			 * .setServicePersonName((String)servicePerson); }
			 */
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appPatientAppointments.setEmployee(masEmployee);
			}

			appPatientAppointments.setPatientName((String) patientName);
			appPatientAppointments.setMobileNo(mobileNo);
			appPatientAppointments.setSex((String) sex);

			appPatientAppointments.setAppointmentStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appPatientAppointments.setHospital(masHospital);

			/*appPatientAppointments.setLastChgBy(userName);*/
			appPatientAppointments.setLastChgDate(date);
			appPatientAppointments.setLastChgTime(time);
			hbt.save(appPatientAppointments);

			int appointmentId = appPatientAppointments.getId();
			appointmentNo = generateAppointmentNo(appointmentDate,
					departmentId, appointmentId, "AP");
			AppPatientAppointments appPatientAppointments1 = (AppPatientAppointments) hbt
					.load(AppPatientAppointments.class, appointmentId);
			appPatientAppointments1.setAppointmentNo(appointmentNo);
			hbt.saveOrUpdate(appPatientAppointments1);
			dataSaved = true;
			map.put("appointmentNo", appointmentNo);
			map.put("dataSaved", dataSaved);
			map.put("departmentList", departmentList);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * --------------- INVESTIGATION SETUP -------------------------
	 */

	public Map<String, Object> showAppointmentInvestigationSetupJsp(Map<String, Object> detailMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		//List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
		
		//boolean recordExists = true;
		/*Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;*/
		int hosId = (Integer)detailMap.get("hospitalId");
		try {
			/*departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();*/
			
			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hosId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			
			
			
			equipmentList = session.createCriteria(HesEquipmentMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hosId)).list();
			logger.info("equipmentList equipmentList "+equipmentList.size());
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;
	}

	public Map<String, Object> showAppointmentInvestigationSetupDetails(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationSetup> investigationList = new ArrayList<AppInvestigationSetup>();
		//boolean recordExists = true;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
		int hospitalId = box.getInt("hospitalId");
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
					            .createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
					
					
			equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
					                  .add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("NoOfEquipments", 0)).list();
					
			investigationList = session.createCriteria(AppInvestigationSetup.class).createAlias("Department", "md").add(Restrictions.eq("md.Id", box.getInt(DEPARTMENT_ID)))
					            .createAlias("Equipment", "em").add(Restrictions.eq("em.Id", box.getInt(EQUIPMENT_ID))).addOrder(Order.asc("Id")).list();
							
					
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println(investigationList.iterator());
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("investigationList", investigationList);
		map.put("box", box);
		return map;
	}

	public boolean submitAppointmentInvestigationSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();

		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		int noOfEquipments = 0;
		Vector startToken = box.getVector("startToken");
		
		Vector tokenInterval = box.getVector("tokenInterval");
		Vector totalToken = box.getVector("totalToken");
		
		/*Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);*/
		
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		
		int departmentId = box.getInt("departmentId");
		
		int equipmentId = box.getInt(EQUIPMENT_ID);
		logger.info("equipmentId "+equipmentId);
		int hospitalId = box.getInt("hospitalId");
		
		int userId = box.getInt("userId");
		//String userName = box.getString("userName");
		/*Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
*/
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

	//	departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
		
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("Id", equipmentId)).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
				             .add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("NoOfEquipments", 0)).list();
				
				
		//noOfEquipments = (Integer) equipmentList.get(0).getNoOfEquipments();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i <= 6; i++) {
			try {
				AppInvestigationSetup appInvestigationSetup = new AppInvestigationSetup();
				appInvestigationSetup.setDays((String) days.get(i));
				//appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				if(null !=startToken.get(i) && !startToken.get(i).equals(""))
				appInvestigationSetup.setStartToken(Integer.parseInt((String) startToken.get(i)));
				
				if(null !=tokenInterval.get(i) && !tokenInterval.get(i).equals(""))
				appInvestigationSetup.setTotalInterval(Integer.parseInt((String) tokenInterval.get(i)));
				
				if(null !=totalToken.get(i) && !totalToken.get(i).equals(""))
				appInvestigationSetup.setTotalToken(Integer.parseInt((String) totalToken.get(i)));

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}*/
				/*appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));*/
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appInvestigationSetup.setDepartment(masDepartment);

				MasStoreItem masStoreItem = new MasStoreItem();
				masStoreItem.setId(equipmentId);
				appInvestigationSetup.setEquipment(masStoreItem);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationSetup.setHospital(masHospital);
				
				Users u = new Users();
				u.setId(userId);
				appInvestigationSetup.setLastChgBy(u);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.save(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	public boolean updateAppointmentInvestigationSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		int departmentId = box.getInt(WARD_ID);
		int equipmentId = box.getInt(EQUIP_ID);
		// Vector departmentId=box.getVector(DEPT_ID);
		int hospitalId = box.getInt("hospitalId");
		int userId = box.getInt("userId");
		Vector investigationId = box.getVector(INVESTIGATION_ID);
		int i = 0;
		int noOfEquipments = 0;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;

		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.in("dt.Id", dept)).list();

		equipmentList = session.createCriteria(AppEquipmentMaster.class)
				.add(Restrictions.eq("Id", equipmentId))
				.add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
				.add(Restrictions.gt("NoOfEquipments", 0)).list();
		noOfEquipments = (Integer) equipmentList.get(0).getNoOfEquipments();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i <= investigationId.size() - 1; i++) {
			try {
				AppInvestigationSetup appInvestigationSetup = (AppInvestigationSetup) hbt
						.load(AppInvestigationSetup.class, Integer
								.parseInt((String) investigationId.get(i)));
				appInvestigationSetup.setDays((String) days.get(i));
				appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				appInvestigationSetup.setFromTime((String) fromTime.get(i));
				appInvestigationSetup.setToTime((String) toTime.get(i));
				appInvestigationSetup.setSlotDuration((String) slotTime.get(i));

				if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}
				appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}
				
				Users u = new Users();
				u.setId(userId);
				appInvestigationSetup.setLastChgBy(u);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.saveOrUpdate(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}

		}

		while (i <= 6) {
			try {
				AppInvestigationSetup appInvestigationSetup = new AppInvestigationSetup();
				appInvestigationSetup.setDays((String) days.get(i));
				appInvestigationSetup.setNoOfEquipments(noOfEquipments);
				appInvestigationSetup.setFromTime((String) fromTime.get(i));
				appInvestigationSetup.setToTime((String) toTime.get(i));
				appInvestigationSetup.setSlotDuration((String) slotTime.get(i));

				if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					appInvestigationSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					appInvestigationSetup.setPercentageForSlots(0);
				}
				appInvestigationSetup.setBreakFromTime((String) breakFromTime
						.get(i));
				appInvestigationSetup.setBreakToTime((String) breakToTime
						.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					appInvestigationSetup.setMaxNoOfDays(Integer
							.parseInt((String) maxDays.get(i)));
				} else if (maxDays.get(i).equals("") || maxDays.get(i) == null) {
					appInvestigationSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					appInvestigationSetup.setMinNoOfDays(Integer
							.parseInt((String) minDays.get(i)));
				} else if (minDays.get(i).equals("") || minDays.get(i) == null) {
					appInvestigationSetup.setMinNoOfDays(0);
				}

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				appInvestigationSetup.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationSetup.setHospital(masHospital);

				Users u = new Users();
				u.setId(userId);
				appInvestigationSetup.setLastChgBy(u);
				appInvestigationSetup.setLastChgDate(date);
				appInvestigationSetup.setLastChgTime(time);

				hbt.save(appInvestigationSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
			i++;
		}

		return dataSaved;
	}

	/**
	 * ------------------------ INVESTIGATION APPOINTMENT
	 * -------------------------- STARTTED ON 26 TH AUG 2008 AUTHOR: PRIYANKA
	 * GARG
	 */
	public Map<String, Object> showAppointmentInvestigationJsp(Map<String, Object> detailMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
/*		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
*/		
		List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
		List<OpdHoliday> holidayList = new ArrayList<OpdHoliday>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
		int hospitalId=(Integer)detailMap.get("hospitalId");
		try {
			/*departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "Y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();
			
			equipmentList = session.createCriteria(AppEquipmentMaster.class)
					.add(Restrictions.eq("EquipmentStatus", "Y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.gt("NoOfEquipments", 0)).list();*/
			
			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			equipmentList = session.createCriteria(HesEquipmentMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
		//	holidayList = session.createCriteria(OpdHoliday.class).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
					

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("holidayList", holidayList);

		return map;

	}

	public Map<String, Object> showAppointmentInvestigationWise(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<AppPatientAppointments> patientAppointmentList = new
		// ArrayList<AppPatientAppointments>();
		List<AppInvestigationSetup> appInvestigationSetupList = new ArrayList<AppInvestigationSetup>();
		
		List<AppInvestigationAppointments> patientAppointmentsList = new ArrayList<AppInvestigationAppointments>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<HesEquipmentMaster> equipmentList = new ArrayList<HesEquipmentMaster>();
		
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		
		//List<AppInvestigationAppointments> slotAvailableList = new ArrayList<AppInvestigationAppointments>();
		//List<Patient> registeredPatientList = new ArrayList<Patient>();
		Map<String,String> prioritymap=new HashMap<String,String>();
		
		//String slotList[][] = null;

		int departmentId = box.getInt(DEPARTMENT_ID);
		int equipmentId = box.getInt(EQUIPMENT_ID);
		
		//int noOfEquipments = 0;
		//int counter = 1;
		//int noOfSlots = 0;
		//int percentageForSlots = 0;

		Integer[] noOfEquipmentsList = new Integer[200];
		String queryString = null;
		//String breakFromTime = "00:00:00";
		//String breakToTime = "00:00:00";
		String days[] = new String[8];
		//Time d_fromTime = Time.valueOf("00:00:00");
		//Time d_toTime = Time.valueOf("00:00:00");
		//Time d_slotDuration = Time.valueOf("00:00:00");
		//Time d_breakFromTime = Time.valueOf("00:00:00");
		//Time d_breakToTime = Time.valueOf("00:00:00");

		//int totalAppointments = 0;
		//int maxNoOfDays = 0;
		//int minNoOfDays = 0;
		//Date maxDate = new Date();
		//Date minDate = new Date();
		//Date sysDate = new Date();
		Date apmtDate = new Date();
		int hospitalId = box.getInt("hospitalId");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c_appointmentDate = Calendar.getInstance();
		if (box.get(APPOINTMENT_DATE) != null
				&& !box.get(APPOINTMENT_DATE).equals("")) {
			c_appointmentDate
					.setTime(HMSUtil.convertStringTypeDateToDateType(box
							.get(APPOINTMENT_DATE)));
			apmtDate = HMSUtil.convertStringTypeDateToDateType(box
					.get(APPOINTMENT_DATE));
		}
		String formattedDate = sdf.format(c_appointmentDate.getTime());
		days[1] = "Sunday";
		days[2] = "Monday";
		days[3] = "Tuesday";
		days[4] = "Wednesday";
		days[5] = "Thursday";
		days[6] = "Friday";
		days[7] = "Saturday";

		/*Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;*/

		queryString = "from AppInvestigationSetup where Department="
				+ departmentId + " and Equipment=" + equipmentId
				+ " and Days='"
				+ days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)] + "'";
		
		logger.info("days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)] "+days[c_appointmentDate.get(Calendar.DAY_OF_WEEK)]);
		try {
			/*departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();
			
			equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("NoOfEquipments", 0)).list();
					*/
			
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			equipmentList = session.createCriteria(HesEquipmentMaster.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			/*employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();*/
			
			appInvestigationSetupList = getHibernateTemplate()
					.find(queryString);
			logger.info("appInvestigationSetupList "+appInvestigationSetupList.size());
			patientAppointmentsList = getHibernateTemplate().find(
					"from AppInvestigationAppointments apmt where Department="
							+ box.getInt(DEPARTMENT_ID) + " and Equipment="
							+ box.getInt(EQUIPMENT_ID)
							+ " and InvestigationDate='" + formattedDate + "'");
			String queueNo="";
			for(AppInvestigationAppointments investigationApp:patientAppointmentsList){
			
				queueNo=String.valueOf(investigationApp.getPriorityNum());
			
			prioritymap.put(queueNo, queueNo);
			}
			if (appInvestigationSetupList != null
					&& appInvestigationSetupList.size() > 0) {/*
				Iterator ite = appInvestigationSetupList.iterator();
				while (ite.hasNext()) {
					AppInvestigationSetup appInvestigationSetup = (AppInvestigationSetup) ite
							.next();
					if (appInvestigationSetup.getFromTime() != null
							&& !appInvestigationSetup.getFromTime().equals("")) {
						d_fromTime = Time.valueOf(appInvestigationSetup
								.getFromTime());
					} else {
						d_fromTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getToTime() != null
							&& !appInvestigationSetup.getToTime().equals("")) {
						d_toTime = Time.valueOf(appInvestigationSetup
								.getToTime());
					} else {
						d_toTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getSlotDuration() != null
							&& !appInvestigationSetup.getSlotDuration().equals(
									"")) {
						d_slotDuration = Time.valueOf(appInvestigationSetup
								.getSlotDuration());
					} else {
						d_slotDuration = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getBreakFromTime() != null
							&& !appInvestigationSetup.getBreakFromTime()
									.equals("")) {
						try {
							d_breakFromTime = Time
									.valueOf(appInvestigationSetup
											.getBreakFromTime());
						} catch (Exception e) {
							d_breakFromTime = Time.valueOf("00:00:00");
						}
					} else {
						d_breakFromTime = Time.valueOf("00:00:00");
					}
					if (appInvestigationSetup.getBreakToTime() != null
							&& !appInvestigationSetup.getBreakToTime().equals(
									"")) {
						try {
							d_breakToTime = Time.valueOf(appInvestigationSetup
									.getBreakToTime());
						} catch (Exception e) {
							d_breakToTime = Time.valueOf("00:00:00");
						}
					} else {
						d_breakToTime = Time.valueOf("00:00:00");
					}

					if (appInvestigationSetup.getMaxNoOfDays() != null
							&& !(appInvestigationSetup.getMaxNoOfDays() == 0)) {
						maxNoOfDays = appInvestigationSetup.getMaxNoOfDays();
					} else {
						maxNoOfDays = 0;
					}
					if (appInvestigationSetup.getMinNoOfDays() != null
							&& !(appInvestigationSetup.getMinNoOfDays() == 0)) {
						minNoOfDays = appInvestigationSetup.getMinNoOfDays();
					} else {
						minNoOfDays = 0;
					}
					if (appInvestigationSetup.getPercentageForSlots() != null
							&& !(appInvestigationSetup.getPercentageForSlots() == 0)) {
						percentageForSlots = appInvestigationSetup
								.getPercentageForSlots();
					} else {
						percentageForSlots = 0;
					}
					if (appInvestigationSetup.getNoOfEquipments() != null
							&& !(appInvestigationSetup.getNoOfEquipments() == 0)) {
						noOfEquipments = appInvestigationSetup
								.getNoOfEquipments();
					} else {
						noOfEquipments = 0;
					}
					maxDate = new Date(c_appointmentDate.getTimeInMillis()
							- maxNoOfDays * 24 * 60 * 60 * 1000);
					minDate = new Date(c_appointmentDate.getTimeInMillis()
							- minNoOfDays * 24 * 60 * 60 * 1000);
					Date minParsedDate = null;
					Date sysParsedDate = null;
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						minParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(minDate));
						sysParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(sysDate));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					if (sysDate.compareTo(maxDate) >= 0
							&& (sysDate.compareTo(minDate) < 0 || sysParsedDate
									.equals(minParsedDate))
							&& apmtDate.compareTo(sysDate) >= 0) {
						map = calculateSlots(d_fromTime, d_toTime,
								d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");

						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfEquipments * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									slotAvailableList = getHibernateTemplate()
											.find("from AppInvestigationAppointments where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and InvestigationDate='"
													+ formattedDate
													+ "' and Equipment="
													+ equipmentId);
									int temp = noOfEquipments
											- slotAvailableList.size();
									noOfEquipmentsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						} else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null && !box.get("parent").equals("")) {
								
							registeredPatientList = showExistingPatientDetail(Integer.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",registeredPatientList);		
							
									
						}

					} else if (minNoOfDays == 0 || maxNoOfDays == 0) {
						map = calculateSlots(d_fromTime, d_toTime,d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");		
						

						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the
						// percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfEquipments * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									slotAvailableList = getHibernateTemplate()
											.find("from AppInvestigationAppointments where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and InvestigationDate='"
													+ formattedDate + "'");
									int temp = noOfEquipments
											- slotAvailableList.size();
									noOfEquipmentsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}

						else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this date is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else {
						String message = "Wrong Appointment Date!!";
						map.put("message", message);
					}
				}

			*/} else if (appInvestigationSetupList != null
					&& appInvestigationSetupList.size() == 0) {

				String message = "Investigation Schedule for this department on the following day for this equipment is not set.";
				map.put("message", message);
			}

		} catch (HibernateException e) {

			e.printStackTrace();
		}
		map.put("employeeList", employeeList);
		map.put("noOfEquipmentsList", noOfEquipmentsList);
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);
		map.put("apmtDate", apmtDate);
		 map.put("appInvestigationSetupList", appInvestigationSetupList);
		 map.put("patientAppointmentsList", patientAppointmentsList);
		 map.put("prioritymap", prioritymap);
		 
		return map;

	}

	public Map<String, Object> checkForHinNoInvApmt(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APPOINTMENT_DATE));
		boolean patientNameExist = false;
		Criteria criteria = null;
		try {
			criteria = session
					.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationStatus", "y").ignoreCase())
					.add(Restrictions.eq("InvestigationDate", apmtDate))
					.createAlias("Department", "md")
					.add(Restrictions.eq("md.Id", box.getInt(DEPARTMENT_ID)))
					.createAlias("Equipment", "equip")
					.add(Restrictions.eq("equip.Id", box.getInt(EQUIPMENT_ID)))
					.createAlias("Hospital", "hospital")
			.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")));

			if (!box.getString("hinId").equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id",box.getInt("hinId")));
			}
			/*if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName",
						box.getString(PATIENT_NAME)));
			}
			if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age",
						box.getString(AGE) + " " + box.getString(AGEUNIT)));
			}*/
			/*if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo",
						box.getInt(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex",
						box.getString(SEX)));
			}*/
			hinList = criteria.list();

			if (box.getString("hinId").equals("") && hinList.size() > 0) {
				patientNameExist = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinList", hinList);
		map.put("patientNameExist", patientNameExist);
		return map;
	}

	public Map<String, Object> checkForInvApmtInDiffDept(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		Date apmtDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(APPOINTMENT_DATE));
		boolean recordExists = false;
		Criteria criteria = null;
		try {
			criteria = session
					.createCriteria(AppInvestigationAppointments.class)
					.add(Restrictions.eq("InvestigationStatus", "y").ignoreCase())
					.add(Restrictions.eq("InvestigationDate", apmtDate))
					.createAlias("Equipment", "equip")
					.add(Restrictions.eq("equip.Id", box.getInt(EQUIPMENT_ID)))
			.createAlias("Hospital", "hospital")
			.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
			.add(Restrictions.eq("Department.Id", box.getInt(DEPARTMENT_ID)));

			if (box.getInt("hinId")>0) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.Id",(box.getInt("hinId"))));
			}
			/*if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName",
						box.getString(PATIENT_NAME)));
			}*/
			/*if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age",
						box.getString(AGE) + " " + box.getString(AGE_UNIT)));
			}*/
			/*if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo",
						box.getInt(MOBILE_NO)));
			}*/
			/*if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex",
						box.getString(SEX)));
			}*/

			hinList = criteria.list();
			if (hinList != null && hinList.size() > 0) {
				recordExists = true;
				/*Iterator ite = hinList.iterator();
				while (ite.hasNext()) {
					AppInvestigationAppointments appInvestigationAppointments = (AppInvestigationAppointments) ite
							.next();
					if (!appInvestigationAppointments.getDepartment().getId()
							.equals(box.getInt(DEPARTMENT_ID))) {
						recordExists = true;
						map.put("existingDept", appInvestigationAppointments
								.getDepartment().getDepartmentName());
						map.put("priority",
								appInvestigationAppointments.getPriorityNum());
						
					}

				}*/

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("recordExists", recordExists);
		map.put("hinList", hinList);
		return map;
	}

	public Map<String, Object> submitInvestigationAppointment(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationAppointments> hinList = new ArrayList<AppInvestigationAppointments>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		boolean duplicateRecord = false;
		String appointmentNo = null;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
		String visitAge="";
		Map<String,Object> mapTot=null;
		List<Visit> visitList = new ArrayList<Visit>();
		int visitNo=0;
		Integer totalHospitalVisitNo=0;
		MasSession massession=null;
		int visitSession=box.getInt("opsession");
		/*String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);
		int departmentId = box.getInt(WARD_ID);
		int equipmentId = box.getInt(EQUIP_ID);*/
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get(APPOINTMENT_DATE));
		
		//String serviceNo = box.getString(SERVICE_NO);
		//String servicePerson = box.getString("servicePerson");
		
		String uhid = box.get("uhid");
		
		int equipmentId=box.getInt(EQUIPMENT_ID);
		MasStoreItem item=new MasStoreItem();
		item.setId(equipmentId);
		
		int departmentId=box.getInt(DEPARTMENT_ID);
		MasDepartment department=new MasDepartment();
		department.setId(departmentId);
		
		int preQueue=box.getInt("preQueue");
		
		

		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		int userId = box.getInt("userId");
		
		
		String patientInvestigationList=box.get("patientInvestigationList");
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		

		Patient patient=(Patient) session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", uhid)).list().get(0);
		String UhidNumber=uhid;
		box.put("hinId", patient.getId());
		
		
		if(visitSession>0){
			massession=new MasSession();
			massession.setId(visitSession);
		}
		
		visitList=session.createCriteria(Visit.class)
				.createAlias("Hin", "hin")
	    		.add(Restrictions.eq("hin.Id",patient.getId()))
	    		.addOrder(Order.desc("Id"))
	    		.list();
		if(visitList.size()>0)
			visitNo=visitList.get(0).getVisitNo()+1;
		else
			visitNo=1;

		visitAge=patient.getAge();
		

		boolean patientNameExist = false;
		boolean recordExists = false;

		map = checkForInvApmtInDiffDept(box);
		String existingDept = (String) map.get("existingDept");
		String priority = (String) map.get("priority");
		//String existingEndTime = (String) map.get("existingEndTime");
		if (map.get("recordExists") != null) {
			recordExists = (Boolean) map.get("recordExists");
		}
		map = checkForHinNoInvApmt(box);
		/*if (hinList != null) {
			hinList = (List) map.get("hinList");
		}
*/
		patientNameExist = (Boolean) map.get("patientNameExist");

		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
				          .createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
				
		equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
				            .add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.gt("NoOfEquipments", 0)).list();
			
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			int i = 0;
				String tempInves[]=patientInvestigationList.split(",");
				for(String investigation:tempInves){
					
						DgOrderdt orderDt=new DgOrderdt();
						int orderDtId=Integer.parseInt(investigation);
						orderDt.setId(orderDtId);
				
			AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();
			appInvestigationAppointments.setInvestigationDate(appointmentDate);
			appInvestigationAppointments.setDepartment(department);
			appInvestigationAppointments.setEquipment(item);
			appInvestigationAppointments.setPriorityNum(preQueue);
			appInvestigationAppointments.setHin(patient);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appInvestigationAppointments.setHospital(masHospital);
			//appInvestigationAppointments.setDgSampleCollectionDetailsId(sampleCollectionDtId);
			appInvestigationAppointments.setDgOrder(orderDt);
			Users u = new Users();
			u.setId(userId);
			//appInvestigationAppointments.setLastChgBy(u);
			appInvestigationAppointments.setLastChgDate(date);
			appInvestigationAppointments.setLastChgTime(time);
			appInvestigationAppointments.setInvestigationStatus("y");
			appInvestigationAppointments.setCurrentVisitStatus("y");


			Visit visit=new Visit();
			QueueManagment queue=new QueueManagment();
			visit.setDepartment(department);
			queue.setDepartment(department);
			visit.setHin(patient);
			queue.setHin(patient);
			visit.setCashReceivedStatus("n");
			visit.setCashNotReceivedReason("");
			visit.setPriorityNumber(3);
			visit.setDoctor(null);
			queue.setDocotor(null);
			visit.setDoctorName(null);
			visit.setUnit(null);
			visit.setVisitSession(massession);
			visit.setAddEditBy(u);
			visit.setVisitNo(visitNo);
			visit.setTokenNo(preQueue);
			queue.setTokenNo(preQueue);
			visit.setHin(patient);
			visit.setAge(visitAge);
			visit.setVisitDate(appointmentDate);
			queue.setLsCngDate(appointmentDate);
			visit.setVisitTime("07:01"); 
			queue.setOpVisitTime("07:01");
			visit.setCurPharVisitStatus("Y");
			visit.setVisitStatus("w");
			queue.setTokenStatus("w");
			visit.setAppointmentType("A");
			visit.setStatus("Y");
			visit.setHospital(masHospital); 
			queue.setHospital(masHospital);
			visit.setPriorityNumber(3); 
			visit.setTotalHospitalVisit(totalHospitalVisitNo);
			queue.setTotalHospitalVisit((int)totalHospitalVisitNo);
			visit.setReferralStatus("n");
			visit.setEdStatus("n");
			
			visit.setDisplayAfterNo(preQueue-1);
			visit.setLastDisplayAfterNo(preQueue-1);
			
			visit.setAddEditDate(date);
			visit.setAddEditTime(time);
			queue.setLastChgDate(new Date());
			queue.setLastChgTime("");
			queue.setVisit(visit);
			
			
			masHospital =(MasHospital)session.get(MasHospital.class, hospitalId); 
			if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
				visit.setCreationSource("C");
			}else if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
				visit.setCreationSource("L");
			}

			List<Visit> visitlist=new ArrayList<Visit>();
			List<QueueManagment> managements=new ArrayList<QueueManagment>(); 

			if (hinList != null) {
				if (hinList.size() == 0 ) {
					
					appInvestigationAppointments.setVisit(visit);
					
					hbt.save(visit);
					hbt.save(queue);
					hbt.save(appInvestigationAppointments);
					
					visitlist.add(visit);
					managements.add(queue);

					int appointmentId = appInvestigationAppointments.getId();
					appointmentNo = generateAppointmentNo(appointmentDate,
							departmentId, appointmentId, "IV");
					appInvestigationAppointments = (AppInvestigationAppointments) hbt
							.load(AppInvestigationAppointments.class,
									appointmentId);

					appInvestigationAppointments
							.setInvestigationAppointmentNo(appointmentNo);
					hbt.saveOrUpdate(appInvestigationAppointments);


					final MasHospital hospital=(MasHospital)session.get(MasHospital.class, hospitalId); 
					final List<Visit> finalVisitlist=visitlist;
					final List<QueueManagment> finalManagements=managements; 
					final BlOpBillHeader finalOpBillHeader=null;
					final BlOpBillDetails finalOpBillDetails=null;
					final Patient finalPatient = patient;
					final Visit finalVisit = visit;
					//final AppPatientAppointments finalAppPatientAppointments = appPatientAppointments1;
					
					//#13- Tech Debt: Comment out the code those are related to Lean server
					/*new Thread(){
						public void run(){
							String serverSideName = null; // added by amit das on 09-08-2017
							org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
							if(hospital!=null && hospital.getClientIp()!=null && !hospital.getClientIp().trim().equals("") && !hospital.getClientIp().trim().equals("null") && hospital.getClientPort()!=null && !hospital.getClientPort().trim().equals("") && !hospital.getClientPort().trim().equals("null")){
								Map<String,Object> data=registrationDataService.saveVisitInformationInLeanServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
								String message=(String)data.get("message");
								Parser p1 = new PipeParser(); 
						  	  	String encodedVisitDataMessage;
						  	  	serverSideName = "lean";
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
									
								// added by amit das on 09-08-2017	
								//message = savePatientDataForAppointmentToLeanCentralServer(finalAppPatientAppointments,hospital,serverSideName);
									
								
									
									
								} catch (HL7Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								
								
							}
							if(hospital!=null && hospital.getServerIp()!=null && !hospital.getServerIp().trim().equals("") && !hospital.getServerIp().trim().equals("null") && hospital.getServerPort()!=null && !hospital.getServerPort().trim().equals("") && !hospital.getServerPort().trim().equals("null")){


								Map<String,Object> data=registrationDataService.saveVisitInformationInCentralServer(finalVisitlist, finalManagements,finalOpBillHeader,finalOpBillDetails,finalPatient,hospital);
								String message=(String)data.get("message");
								Parser p1 = new PipeParser(); 
						  	  	String encodedVisitDataMessage;
						  	  	serverSideName = "central"; // added by amit das on 09-08-2017
								try {
									// encodedVisitDataMessage = p1.encode((ADT_A01)data.get("ADTMessage")); //commented by amit das on 19-12-2016
									List<ADT_A01> adt_A01List  = (List<ADT_A01>)data.get("ADTMessage"); // added by amit das on 19-12-2016
									
									if(adt_A01List!=null && adt_A01List.size()>0){ // added by amit das on 19-12-2016
									for(int i=0;i<adt_A01List.size();i++) {
									//if("success".equalsIgnoreCase(message)){ //commented by amit das on 19-12-2016
										encodedVisitDataMessage = p1.encode(adt_A01List.get(i));						
									
								  	  	CentralServerVisitData centralServerVisitData=new CentralServerVisitData();
										centralServerVisitData.setCentralVisitId(Long.parseLong(finalVisit.getId()+""));
										centralServerVisitData.setVisitData(encodedVisitDataMessage);
										centralServerVisitData.setHospitalId(Long.parseLong(hospital.getId()+""));  
										String visitSavedToLeanServer="N";
										centralServerVisitData.setStatus(visitSavedToLeanServer);   
										hbt.save(centralServerVisitData);
								  	}
								   }
									
									// added by amit das on 09-08-2017
									//message = savePatientDataForAppointmentToLeanCentralServer(finalAppPatientAppointments,hospital,serverSideName);
									
										
									
								} catch (HL7Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
						  	  	
								
							}
						}
						}.start();*/
					
				}
					dataSaved = true;
					duplicateRecord = false;
					map.put("appointmentNo", appointmentNo);

				} /*else if (hinList.size() > 0 && patientNameExist == false
						&& recordExists == false) {
					map.put("message",UhidNumber+" already taken Appointment for this Department!!");
					dataSaved = false;
					duplicateRecord = true;
				} else if (recordExists == true && hinList.size() == 0
						&& patientNameExist == false) {
					map.put("existingDept", existingDept);
					map.put("priority", priority);
					
					duplicateRecord = false;
				} else if (hinList.size() > 0 && patientNameExist == false
						&& recordExists == true) {
					map.put("message",UhidNumber+" already taken Appointment for this Department!!");
					map.put("existingDept", existingDept);
					map.put("priority", priority);
					
					dataSaved = false;
					duplicateRecord = true;
				}
*/
			}
			map.put("recordExists", recordExists);
			map.put("patientNameExist", patientNameExist);

			map.put("dataSaved", dataSaved);

			/*map.put("patientName", patientName);*/
			map.put("duplicateRecord", duplicateRecord);

			/*map.put("age", age);
			map.put("sex", sex);
*/
		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> submitDulicatePatientNameInvAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		String appointmentNo = null;

		String fromTimeSlot = box.getString("returnStartTime");
		String toTimeSlot = box.getString("returnEndTime");
		int departmentId = box.getInt("returnDeptId");
		int equipId = box.getInt("returnEquipId");
		Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box
				.get("returnAppointmentDate"));
		String patientName = box.getString("returnPatientName");
		String sex = box.getString("returnSex");
		String age = box.getString("returnAge");
		String ageUnit = box.getString("returnAgeUnit");
		String serviceNo = box.getString("returnServiceNo");
		String servicePerson = box.getString("returnServicePerson");
		int hinId = box.getInt("returnHinId");
		int mobileNo = box.getInt("returnMobileNo");
		int doctorId = box.getInt("returnDoctorId");
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y"))
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.in("dt.Id", dept)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();
			appInvestigationAppointments.setFromTimeSlot((String) fromTimeSlot);
			appInvestigationAppointments.setToTimeSlot((String) toTimeSlot);

			appInvestigationAppointments.setInvestigationDate(appointmentDate);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			appInvestigationAppointments.setDepartment(masDepartment);

			MasStoreItem appEquipmentMaster = new MasStoreItem();
			appEquipmentMaster.setId(equipId);
			appInvestigationAppointments.setEquipment(appEquipmentMaster);

			Patient patient = new Patient();
			if (hinId != 0) {
				patient.setId(hinId);
				appInvestigationAppointments.setHin(patient);
				appInvestigationAppointments.setRegisteredStatus("y");
				appInvestigationAppointments.setAge(age);

			} else {
				appInvestigationAppointments.setRegisteredStatus("n");
				if (ageUnit != null) {
					appInvestigationAppointments.setAge((String) age + " "
							+ (String) ageUnit);
				} else {
					appInvestigationAppointments.setAge((String) age);
				}
			}
			if (serviceNo != null && !serviceNo.equals("")) {
				appInvestigationAppointments.setServiceNo((String) serviceNo);
			}
			if (servicePerson != null && !servicePerson.equals("")) {
				appInvestigationAppointments
						.setServicePersonName((String) servicePerson);
			}
			appInvestigationAppointments.setInvestigationStatus("y");
			if (doctorId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(doctorId);
				appInvestigationAppointments.setEmployee(masEmployee);
			}

			appInvestigationAppointments.setPatientName((String) patientName);
			//appInvestigationAppointments.setMobileNo(mobileNo);
			appInvestigationAppointments.setSex((String) sex);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			appInvestigationAppointments.setHospital(masHospital);

			/*appInvestigationAppointments.setLastChgBy(userName);*/
			appInvestigationAppointments.setLastChgDate(date);
			appInvestigationAppointments.setLastChgTime(time);
			hbt.save(appInvestigationAppointments);

			hbt.save(appInvestigationAppointments);
			int appointmentId = appInvestigationAppointments.getId();
			appointmentNo = generateAppointmentNo(appointmentDate,
					departmentId, appointmentId, "IV");
			appInvestigationAppointments = (AppInvestigationAppointments) hbt
					.load(AppInvestigationAppointments.class, appointmentId);

			appInvestigationAppointments
					.setInvestigationAppointmentNo(appointmentNo);
			hbt.saveOrUpdate(appInvestigationAppointments);

			dataSaved = true;
			map.put("appointmentNo", appointmentNo);
			map.put("dataSaved", dataSaved);
			map.put("departmentList", departmentList);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * ------------------------ CANCELLATION FOR PATIENT APPOINTMENTS
	 * ----------------------- STARTED ON 1ST SEPT 2008 AUTHOR: PRIYANKA GARG
	 */
	public Map<String, Object> showAppointmentPatientCancellationJsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.Id", 1)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);

		return map;

	}

	public Map<String, Object> patientAppointmentList(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
		Integer[] dept = new Integer[3];

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String hinNo = box.getString(HIN_NO);
		String patientName = box.getString(PATIENT_NAME);
		String age = box.getString(AGE);
		String appointmentNo = box.getString(APPOINTMENT_NO);
		String appointmentDate = box.getString(APPOINTMENT_DATE);
		int departmentId = box.getInt(DEPARTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		Criteria criteria = null;
		criteria = session.createCriteria(AppPatientAppointments.class).add(
				Restrictions.eq("AppointmentStatus", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospitalId));
		try {
			if (!hinNo.equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientName.equals("")) {
				criteria = criteria.add(Restrictions.like("PatientName", "%"
						+ patientName + "%"));
			}
			if (!age.equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", age));
			}
			if (!appointmentNo.equals("")) {
				criteria = criteria.add(Restrictions.eq("AppointmentNo",
						appointmentNo));
			}
			if (!appointmentDate.equals("")) {
				criteria = criteria
						.add(Restrictions.eq(
								"AppointmentDate",
								HMSUtil.convertStringTypeDateToDateType(appointmentDate)));
			}
			if (departmentId != 0) {
				criteria = criteria.createAlias("Department", "md").add(
						Restrictions.eq("md.Id", departmentId));
			}
			patientList = criteria.list();
			dept[0] = 1;
			dept[1] = 4;
			dept[2] = 12;
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (patientList.size() <= 0) {
			map.put("message", "No Record Found !!");
		}
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);

		return map;

	}

	public boolean submitCancelPatientAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("DepartmentType", "dt")
				.add(Restrictions.eq("dt.Id", 1)).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i < appointmentId.size(); i++) {
			try {
				AppPatientAppointments appPatientAppointments = new AppPatientAppointments();

				if (!appointmentId.get(i).equals("")
						&& appointmentId.get(i) != null) {
					appPatientAppointments = (AppPatientAppointments) hbt.load(
							AppPatientAppointments.class,
							Integer.parseInt((String) appointmentId.get(i)));
					appPatientAppointments.setAppointmentStatus("c");
					appPatientAppointments.setAppointmentCancelDate(date);

				}

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appPatientAppointments.setHospital(masHospital);
				
				int userId = box.getInt("UserId");
				Users u = new Users();
				u.setId(userId);
				/*appPatientAppointments.setLastChgBy(userName);*/
				appPatientAppointments.setLastChgBy(u);
				appPatientAppointments.setLastChgDate(date);
				appPatientAppointments.setLastChgTime(time);

				hbt.saveOrUpdate(appPatientAppointments);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	/**
	 * --------------------------- CANCELLATION FOR APPOINTMENT INVESTIGATION
	 * -------------------- STARTED ON 4 TH SEPT 2008 AUTHOR: PRIYANKA GARG
	 */

	public Map<String, Object> showAppointmentInvestigationCancellationJsp(Map<String, Object> detailMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
		int hospital_id=(Integer)detailMap.get("hospitalId");
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").
					ignoreCase()).createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
					.add(Restrictions.eq("Hospital.Id", hospital_id)).add(Restrictions.gt("NoOfEquipments", 0)).list();						

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;

	}

	public Map<String, Object> investigationAppointmentList(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		List<AppInvestigationAppointments> patientList = new ArrayList<AppInvestigationAppointments>();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String hinNo = box.getString(HIN_NO);
		String patientName = box.getString(PATIENT_NAME);
		String age = box.getString(AGE);
		String appointmentNo = box.getString(APPOINTMENT_NO);
		String appointmentDate = box.get(APPOINTMENT_DATE);
		int departmentId = box.getInt(DEPARTMENT_ID);
		int equipmentId =0;
		
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;

		Criteria criteria = null;
		int hospital_id=box.getInt("hospitalId");
		equipmentId=box.getInt("equipmentId");
		try {
			departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
					

			equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
					.add(Restrictions.gt("NoOfEquipments", 0)).add(Restrictions.eq("Hospital.Id", hospital_id)).list();
					

			criteria = session.createCriteria(AppInvestigationAppointments.class).add(Restrictions.eq("InvestigationStatus", "y").ignoreCase()).add(Restrictions.eq("Hospital.Id", hospital_id));
					
					
			if (!hinNo.equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientName.equals("")) {
				criteria = criteria.add(Restrictions.like("PatientName", "%"
						+ patientName + "%"));
			}
			if (!age.equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", age));
			}
			if (!appointmentNo.equals("")) {
				criteria = criteria.add(Restrictions.eq("InvestigationNo",
						appointmentNo));
			}
			if (!appointmentDate.equals("") && appointmentDate != null) {
				criteria = criteria
						.add(Restrictions.eq(
								"InvestigationDate",
								HMSUtil.convertStringTypeDateToDateType(appointmentDate)));
			}
			if (departmentId != 0) {
				criteria = criteria.createAlias("Department", "md").add(
						Restrictions.eq("md.Id", departmentId));
			}
			if (equipmentId != 0) {
				criteria = criteria.createAlias("Equipment", "eq").add(
						Restrictions.eq("eq.Id", equipmentId));
			}
			patientList = criteria.addOrder(Order.asc("Id")).list();
			dept[0] = 1;
			dept[1] = 4;
			dept[2] = 12;
			/*departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();*/

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (patientList.size() <= 0) {
			map.put("message", "No Record Found !!");
		}
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;

	}

	public boolean submitCancelInvestigationAppointment(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;

		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int hospitalId = box.getInt("hospitalId");
		int userId = box.getInt("UserId");
		String userName = box.getString("userName");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase())
							.createAlias("DepartmentType", "dt").add(Restrictions.in("dt.Id", dept)).list();
				
				

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i < appointmentId.size(); i++) {
			try {
				AppInvestigationAppointments appInvestigationAppointments = new AppInvestigationAppointments();

				if (!appointmentId.get(i).equals("")
						&& appointmentId.get(i) != null) {
					appInvestigationAppointments = (AppInvestigationAppointments) hbt
							.load(AppInvestigationAppointments.class, Integer
									.parseInt((String) appointmentId.get(i)));
					appInvestigationAppointments.setInvestigationStatus("c");
					appInvestigationAppointments
							.setInvestigationCancelDate(date);

				}

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				appInvestigationAppointments.setHospital(masHospital);
				
				Users users = new Users();
				users.setId(userId);
				//appInvestigationAppointments.setLastChgBy(users);
				appInvestigationAppointments.setLastChgDate(date);
				appInvestigationAppointments.setLastChgTime(time);

				hbt.saveOrUpdate(appInvestigationAppointments);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}

		return dataSaved;
	}

	// ***************************For Report by
	// Vishal****************************************
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@SuppressWarnings("unchecked")
	// ---------------------for Appointment List---------------------------
	public Map<String, Object> getEmployeeDepartmentCategory(Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		int hospitalId = (Integer)	detailMap.get("hospitalId");
		try {
			String departmentTypeName = "Consultation Room";
			departmentList = session.createCriteria(MasDepartment.class).createAlias("DepartmentType", "deptType").
					           add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("deptType.DepartmentTypeName",departmentTypeName)).list();
			employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase())
								.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("FirstName")).list();
					
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		//System.out.println("employeeList>>>"+employeeList.size());
		map.put("departmentList", departmentList);
		map.put("employeeList", employeeList);
		return map;
	}

	// ---------------------for Investigation List---------------------------

	public Map<String, Object> getEquipmentDepartmentCategory(Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppEquipmentMaster> equipmentList = new ArrayList<AppEquipmentMaster>();
		Integer dept[] = new Integer[3];
		dept[0] = 1;
		dept[1] = 4;
		dept[2] = 12;
		int hospitalId= (Integer)detailMap.get("hospitalId");
		try {
			String departmentTypeName = "Consultation Room";
			departmentList = session.createCriteria(MasDepartment.class)
					.createAlias("DepartmentType", "deptType")
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.in("deptType.Id", dept)).list();
			equipmentList = session.createCriteria(AppEquipmentMaster.class).add(Restrictions.eq("EquipmentStatus", "y").ignoreCase())
					          .add(Restrictions.gt("NoOfEquipments", 0)).add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("equipmentList", equipmentList);

		return map;
	}

	public Map<String, Object> submitUploadDocuments(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> viewUploadDocuments(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> patientAppointmentRegisterList(Box box) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<AppPatientAppointments> patientList = new ArrayList<AppPatientAppointments>();
		Integer[] dept = new Integer[3];

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");

		String hinNo = box.getString(HIN_NO);
		String patientName = box.getString(PATIENT_NAME);
		String age = box.getString(AGE);
		String appointmentNo = box.getString(APPOINTMENT_NO);
		String appointmentDate = box.getString(APPOINTMENT_DATE);
		int departmentId = box.getInt(DEPARTMENT_ID);

		Criteria criteria = null;
		criteria = session.createCriteria(AppPatientAppointments.class).add(
				Restrictions.eq("AppointmentStatus", "y"));
		try {
			if (!hinNo.equals("")) {
				criteria = criteria.createAlias("Hin", "pt").add(
						Restrictions.eq("pt.HinNo", hinNo));
			}
			if (!patientName.equals("")) {
				criteria = criteria.add(Restrictions.like("PatientName", "%"
						+ patientName + "%"));
			}
			if (!age.equals("")) {
				criteria = criteria.add(Restrictions.eq("Age", age));
			}
			if (!appointmentNo.equals("")) {
				criteria = criteria.add(Restrictions.eq("AppointmentNo",
						appointmentNo));
			}
			if (!appointmentDate.equals("")) {
				criteria = criteria
						.add(Restrictions.eq(
								"AppointmentDate",
								HMSUtil.convertStringTypeDateToDateType(appointmentDate)));
			}
			if (departmentId != 0) {
				criteria = criteria.createAlias("Department", "md").add(
						Restrictions.eq("md.Id", departmentId));
			}
			patientList = criteria.list();
			dept[0] = 1;
			dept[1] = 4;
			dept[2] = 12;
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.in("dt.Id", dept)).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		if (patientList.size() <= 0) {
			map.put("message", "No Record Found !!");
		}
		map.put("patientList", patientList);
		map.put("departmentList", departmentList);

		return map;

	}
	
	
	/* (non-Javadoc)
	 * @see jkt.hms.appointment.dataservice.AppointmentDataService#getPriorityQueueByDepartId(int, int)
	 */
	public Map<String, Object> getPriorityQueueByDepartId(int departmentId,
			int hospitalId, String appointmentDateStr, String appointmentTime,
			String visitTime) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Integer> tokenList = new ArrayList<Integer>();
		Session session = (Session) getSession();
		Criteria criteria = null;
		String queueNo = null;
		Date appointmentDate = null;
		
		if (StringUtils.isNotBlank(appointmentDateStr) && StringUtils.isNotBlank(visitTime)) {
			int visitHour = Integer.parseInt(visitTime.split(":")[0]);
			appointmentDate = HMSUtil
					.convertStringTypeDateToDateType(appointmentDateStr);

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
					.createAlias("Dept", "dept");
			criteria.add(Restrictions.eq("hosp.Id", hospitalId));
			criteria.add(Restrictions.eq("dept.Id", departmentId))
			.add(Restrictions.isNotNull("TotalInterval"))
					.add(Restrictions.isNotNull("StartToken"))
					.add(Restrictions.isNotNull("TotalToken"));
			criteria.add(Restrictions.eq("Days", dayName));

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
	public Map<String, Object> populatePatientinvestigation(String UhidNo,int orderhdId,int hospitalId) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		int hinId=0;
		
		DgSampleCollectionHeader sampleCollectionHeader=null;
		List<DgSampleCollectionDetails> sampleCollectionDetails=null;
		List<DgOrderdt> dgOrderdtList=new ArrayList<DgOrderdt>();
		
		Criteria crt=null;
		String patientName="";
		
		Session session=(Session)getSession();
		
		/*Patient patient=null;
		crt= session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", UhidNo));*/
		
		/*if( crt.list() !=null && crt.list().size()>0 ){
		patient=(Patient) crt.list().get(0);
		 hinId=patient.getId();
		 patientName=patient.getFullName();
		}*/
		
		
			crt= session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "orderhd").createAlias("Orderhd.Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("orderhd.OrderStatus","P").ignoreCase()).add(Restrictions.eq("orderhd.Id", orderhdId));
			dgOrderdtList=crt.list();
	
		
		
		
		/*if(hinId>0 ){
		 sampleCollectionHeader= (DgSampleCollectionHeader) session.createCriteria(DgSampleCollectionHeader.class)
				 .createAlias("Hin", "Hin").createAlias("Hospital", "hospital").createAlias("Department", "department")
				.add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("hospital.Id", hospitalId)).add(Restrictions.eq("department.Id", departmentId))
				.add(Restrictions.eq("OrderStatus", "p").ignoreCase()).list().get(0);  
		
		int dhSampleCollectionHeaderId=0;
		dhSampleCollectionHeaderId=sampleCollectionHeader.getId();
		
		
		
		if(dhSampleCollectionHeaderId>0){
		 sampleCollectionDetails=(List<DgSampleCollectionDetails>) session.createCriteria(DgSampleCollectionDetails.class)
		 .createAlias("SampleCollectionHeader", "SampleCollectionHeader").add(Restrictions.eq("SampleCollectionHeader.Id", dhSampleCollectionHeaderId)).list();
		}
		System.out.println("sampleCollectionDetails  "+sampleCollectionDetails.size());
		}
		map.put("sampleCollectionDetails", sampleCollectionDetails);*/
		map.put("patientName", patientName);
		map.put("dgOrderdtList", dgOrderdtList);
		return map;
	}

	@Override
	public Map<String, Object> populateInvestigationOrder(String UhidNo,int departmentId,int hospitalId) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		int hinId=0;
		
		List<DgSampleCollectionHeader> sampleCollectionHeader=new ArrayList<DgSampleCollectionHeader>();
		List<DgSampleCollectionDetails> sampleCollectionDetails=null;
		List<DgOrderhd> dgOrderhdList=new ArrayList<DgOrderhd>();
		List<DgOrderhd> tempdgOrderhdList=new ArrayList<DgOrderhd>();
		
		Criteria crt=null;
		String patientName="";
		
		Session session=(Session)getSession();
		
		Patient patient=null;
		crt= session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", UhidNo));
		
		if( crt.list() !=null && crt.list().size()>0 ){
		patient=(Patient) crt.list().get(0);
		 hinId=patient.getId();
		 patientName=patient.getFullName();
		}
		List<Integer> orderList=new ArrayList<Integer>();
		/*if(hinId>0 ){
			 sampleCollectionHeader= session.createCriteria(DgSampleCollectionHeader.class)
					 .createAlias("Hin", "Hin").createAlias("Hospital", "hospital").createAlias("Department", "department")
					.add(Restrictions.eq("Hin.Id", hinId)).add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("OrderStatus", "p").ignoreCase()).list();  
			
			if(null !=sampleCollectionHeader && sampleCollectionHeader.size()>0){
				for(DgSampleCollectionHeader samplecollection:sampleCollectionHeader){
					orderList.add(samplecollection.getOrder().getId());
				}
			}
			
			}*/
		if(hinId>0){
			crt= session.createCriteria(DgOrderhd.class)
					.createAlias("Hin", "Hin").createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("OrderStatus","P").ignoreCase()).add(Restrictions.eq("Hin.Id", hinId));
			dgOrderhdList=crt.list();
		}
		/*if(null!=orderList && orderList.size()>0){
			crt= session.createCriteria(DgOrderhd.class).add(Restrictions.in("Id", orderList))
					.createAlias("Hin", "Hin").createAlias("Hospital", "hospital").add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("OrderStatus","P").ignoreCase()).add(Restrictions.eq("Hin.Id", hinId));
			tempdgOrderhdList=crt.list();
		}
		if(null!=tempdgOrderhdList && tempdgOrderhdList.size()>0){
			dgOrderhdList.addAll(tempdgOrderhdList);
		}
		*/
		logger.info("dgOrderhdList  "+dgOrderhdList.size());
		
		/*if(dhSampleCollectionHeaderId>0){
		 sampleCollectionDetails=(List<DgSampleCollectionDetails>) session.createCriteria(DgSampleCollectionDetails.class)
		 .createAlias("SampleCollectionHeader", "SampleCollectionHeader").add(Restrictions.eq("SampleCollectionHeader.Id", dhSampleCollectionHeaderId)).list();
		}
		System.out.println("sampleCollectionDetails  "+sampleCollectionDetails.size());
		}
		map.put("sampleCollectionDetails", sampleCollectionDetails);*/
		map.put("patientName", patientName);
		map.put("dgOrderhdList", dgOrderhdList);
		return map;
	}

	@Override
	public Map<String, Object> getAppDetails(int deptId,int hospitalId, int sessionId) {
		Map<String,Object>map=new HashMap<String,Object>();
		Session session=(Session)getSession();
		List<AppSetup>setupList=new ArrayList<AppSetup>();

		if(deptId>0){
		setupList=session.createCriteria(AppSetup.class).add(Restrictions.eq("Dept.Id", deptId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).addOrder(Order.asc("Id")).add(Restrictions.eq("Session.Id", sessionId))
				.list();
		}
		map.put("setupList",setupList);
		return map;
	}

	@Override
	public Map<String, Object> ShowDialysisSchedulingSetUpJsp(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DialysisSetup> dialysisSetupList = new ArrayList<DialysisSetup>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String queryString = null;
		//int departmentId = box.getInt(DEPARTMENT_ID);
		
		int departmentId = box.getInt(RequestConstants.WARD_ID);
		
		
		int doctorId = box.getInt(RequestConstants.CONSULTING_DOCTOR);

		//queryString = "from DialysisSetup where Dept=" + departmentId;
		try {
		/*departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
						.createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 1)).list();*/
			
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
		    String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",box.getInt("hospitalId")))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "depType")
					.add(Restrictions.eq("depType.DepartmentTypeCode",depTypeCodeDialysis))
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
			for(MasDepartment insDept : departmentList){
				departmentId = insDept.getId();
			}
			dialysisSetupList = session.createCriteria(DialysisSetup.class).add(Restrictions.eq("Dept.Id", departmentId))
					.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).list();
		employeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("departmentList", departmentList);
		map.put("dialysisSetupList", dialysisSetupList);
		map.put("employeeList", employeeList);
		return map;
	}

	@Override
	public Map<String, Object> submitDialysisSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DialysisSetup> dialysisSetupList = new ArrayList<DialysisSetup>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);
		Vector breakFromTime2 = box.getVector(BREAKFROMTIME2);
		Vector breakToTime2 = box.getVector(BREAKTOTIME2);
		Vector breakFromTime3 = box.getVector(BREAKFROMTIME3);
		Vector breakToTime3 = box.getVector(BREAKTOTIME3);
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		int departmentId = box.getInt(WARD_ID);
		int doctorId = box.getInt(RequestConstants.CONSUNTANT);
		int hospitalId = box.getInt("hospitalId");
		int userId = box.getInt("usersId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		

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
	    String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "depType")
				.add(Restrictions.eq("depType.DepartmentTypeCode",depTypeCodeDialysis))
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (int i = 0; i <= 6; i++) {
			try {
				DialysisSetup dialysisSetup = new DialysisSetup();
				dialysisSetup.setDays((String) days.get(i));
				//dialysisSetup.setNoOfDoctor(1);
				/*if (!dr.get(i).equals("") && dr.get(i) != null) {
					appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				} else {
					appSetup.setNoOfDoctor(0);
				}*/
				dialysisSetup.setFromTime((String) fromTime.get(i));
				dialysisSetup.setToTime((String) toTime.get(i));
				dialysisSetup.setSlotDuration((String) slotTime.get(i));

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					dialysisSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					dialysisSetup.setPercentageForSlots(0);
				}
				dialysisSetup.setBreakFromTime((String) breakFromTime.get(i));
				dialysisSetup.setBreakToTime((String) breakToTime.get(i));
				dialysisSetup.setBreakFromTime2((String) breakFromTime2.get(i));
				dialysisSetup.setBreakToTime2((String) breakToTime2.get(i));
				dialysisSetup.setBreakFromTime3((String) breakFromTime3.get(i));
				dialysisSetup.setBreakToTime3((String) breakToTime3.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					dialysisSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					dialysisSetup.setMaxNoOfDays(0);
				}

				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					dialysisSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					dialysisSetup.setMinNoOfDays(0);
				}
*/
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				dialysisSetup.setDept(masDepartment);

				/*if (doctorId !=0 ) {
					MasEmployee masEmployee=new MasEmployee();
					masEmployee.setId(doctorId);
					dialysisSetup.setDoctor(masEmployee);

				}*/
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dialysisSetup.setHospital(masHospital);
				Users users = new Users();
				users.setId(userId);
				dialysisSetup.setLastChgBy(users);
				dialysisSetup.setLastChgDate(date);
				dialysisSetup.setLastChgTime(time);

				hbt.save(dialysisSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
		}
		dialysisSetupList = session.createCriteria(DialysisSetup.class).add(Restrictions.eq("Dept.Id", departmentId))
								.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("dialysisSetupList", dialysisSetupList);
		map.put("dataSaved", dataSaved);
		return map;
	}

	@Override
	public Map<String, Object> updateDialysisSetup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DialysisSetup> dialysisSetupList = new ArrayList<DialysisSetup>();
		Session session = (Session) getSession();
		boolean dataSaved = false;

		Vector days = box.getVector(DAYS);
		Vector dr = box.getVector(DR);
		Vector fromTime = box.getVector(FROMTIME);
		Vector toTime = box.getVector(TOTIME);
		Vector slotTime = box.getVector(SLOTTIME);
		Vector percentage = box.getVector(PERCENTAGE);
		Vector breakFromTime = box.getVector(BREAKFROMTIME);
		Vector breakToTime = box.getVector(BREAKTOTIME);
		Vector breakFromTime2 = box.getVector(BREAKFROMTIME2);
		Vector breakToTime2 = box.getVector(BREAKTOTIME2);
		Vector breakFromTime3 = box.getVector(BREAKFROMTIME3);
		Vector breakToTime3 = box.getVector(BREAKTOTIME3);
		Vector maxDays = box.getVector(MAXDAYS);
		Vector minDays = box.getVector(MINDAYS);
		//Vector departmentId = box.getVector(DEPT_ID);
		int departmentId = box.getInt(WARD_ID);
		int hospitalId = box.getInt("hospitalId");
		Vector appointmentId = box.getVector(APPOINTMENT_ID);
		int i = 0;

		int userId = box.getInt("usersId");

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
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
	    String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
		departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",box.getInt("hospitalId")))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "depType")
				.add(Restrictions.eq("depType.DepartmentTypeCode",depTypeCodeDialysis))
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
		
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i <= appointmentId.size() - 1; i++) {
			try {
				DialysisSetup dialysisSetup = (DialysisSetup) hbt.load(DialysisSetup.class,
						Integer.parseInt((String) appointmentId.get(i)));
				dialysisSetup.setDays((String) days.get(i));
				dialysisSetup.setNoOfDoctor(1);
				/*if (!dr.get(i).equals("") && dr.get(i) != null) {
					appSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				} else {
					appSetup.setNoOfDoctor(0);
				}*/

				dialysisSetup.setFromTime((String) fromTime.get(i));
				dialysisSetup.setToTime((String) toTime.get(i));
				dialysisSetup.setSlotDuration((String) slotTime.get(i));

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					dialysisSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					dialysisSetup.setPercentageForSlots(0);
				}*/
				/*dialysisSetup.setBreakFromTime((String) breakFromTime.get(i));
				dialysisSetup.setBreakToTime((String) breakToTime.get(i));
				dialysisSetup.setBreakFromTime2((String) breakFromTime2.get(i));
				dialysisSetup.setBreakToTime2((String) breakToTime2.get(i));
				dialysisSetup.setBreakFromTime3((String) breakFromTime3.get(i));
				dialysisSetup.setBreakToTime3((String) breakToTime3.get(i));
*/

				/*if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					dialysisSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					dialysisSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					dialysisSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					dialysisSetup.setMinNoOfDays(0);
				}
*/
				Users users = new Users();
				users.setId(userId);
				dialysisSetup.setLastChgBy(users);
				dialysisSetup.setLastChgDate(date);
				dialysisSetup.setLastChgTime(time);

				hbt.saveOrUpdate(dialysisSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}

		}

		while (i <= 6) {
			try {
				DialysisSetup diaSetup = new DialysisSetup();
				diaSetup.setDays((String) days.get(i));
				if (!dr.get(i).equals("") && dr.get(i) != null) {
					diaSetup.setNoOfDoctor(Integer.parseInt((String) dr.get(i)));
				}
				diaSetup.setFromTime((String) fromTime.get(i));
				diaSetup.setToTime((String) toTime.get(i));
				diaSetup.setSlotDuration((String) slotTime.get(i));

				/*if (!percentage.get(i).equals("") && percentage.get(i) != null) {
					diaSetup.setPercentageForSlots(Integer
							.parseInt((String) percentage.get(i)));
				} else {
					diaSetup.setPercentageForSlots(0);
				}
				diaSetup.setBreakFromTime((String) breakFromTime.get(i));
				diaSetup.setBreakToTime((String) breakToTime.get(i));
				if (!maxDays.get(i).equals("") && maxDays.get(i) != null) {
					diaSetup.setMaxNoOfDays(Integer.parseInt((String) maxDays
							.get(i)));
				} else {
					diaSetup.setMaxNoOfDays(0);
				}
				if (!minDays.get(i).equals("") && minDays.get(i) != null) {
					diaSetup.setMinNoOfDays(Integer.parseInt((String) minDays
							.get(i)));
				} else {
					diaSetup.setMinNoOfDays(0);
				}*/

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				diaSetup.setDept(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				diaSetup.setHospital(masHospital);

				Users users = new Users();
				users.setId(userId);
				diaSetup.setLastChgBy(users);
				diaSetup.setLastChgDate(date);
				diaSetup.setLastChgTime(time);

				hbt.save(diaSetup);
				dataSaved = true;
			} catch (Exception e) {
				dataSaved = false;
				e.printStackTrace();
			}
			i++;
		}

		dialysisSetupList = session.createCriteria(DialysisSetup.class).add(Restrictions.eq("Dept.Id",departmentId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
		map.put("dialysisSetupList", dialysisSetupList);
		map.put("dataSaved", dataSaved);
		return map;
	}

	@Override
	public Map<String, Object> showDialysisSchedulingJsp(int deptId,
			int hospitalId) {

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<Object[]> doctorList = new ArrayList<Object[]>();
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		try {

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
		    String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
			departmentList=session.createCriteria(MasInstituteDepartment.class)
					.setProjection(Projections.property("Department"))
					.add(Restrictions.eq("Institute.Id",hospitalId))
					.add(Restrictions.eq("Status","y").ignoreCase())
					.createAlias("Department", "dep")
					.createAlias("dep.DepartmentType", "depType")
					.add(Restrictions.eq("depType.DepartmentTypeCode",depTypeCodeDialysis))
					.addOrder(Order.asc("dep.DepartmentName"))
					.list();
			
		
	
			map.put("departmentList", departmentList);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

/*	
	
	public Map<String, Object> getPriorityQueueByDepartIdDialysis(int departmentId,int hospitalId,String AppointmentDate){
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, String> queueMap = new HashMap<String, String>();

		List<AppPatientAppointments> queueList=new ArrayList<AppPatientAppointments>();
		Session session = (Session) getSession();
		Criteria crt=null;
		String queueNo=null;
		
		Date appointmentDate=HMSUtil.convertStringTypeDateToDateType(AppointmentDate);
		
		crt=session.createCriteria(AppPatientAppointments.class).createAlias("Hospital", "hosp").createAlias("Department", "dept");
		crt.add(Restrictions.eq("hosp.Id", hospitalId));
		crt.add(Restrictions.eq("dept.Id", departmentId));
		crt.add(Restrictions.eq("AppointmentDate", appointmentDate)); 
		queueList=crt.list();
		
		for(AppPatientAppointments qNo : queueList){
			queueNo=String.valueOf(qNo.getQueuePriority());
			
			queueMap.put(queueNo, queueNo);
		}
		
		 SimpleDateFormat formatter = new SimpleDateFormat("EEEE"); 
		  String dayName = formatter.format(appointmentDate);
		   List<DialysisSetup>  dialysisSetupList=new ArrayList<DialysisSetup>();
		   
		crt=session.createCriteria(DialysisSetup.class).createAlias("Hospital", "hosp").createAlias("Dept", "dept");
		crt.add(Restrictions.eq("hosp.Id", hospitalId));
		crt.add(Restrictions.eq("dept.Id", departmentId));
		crt.add(Restrictions.eq("Days", dayName)); 
		
		dialysisSetupList=crt.list();
		System.out.println(" >>>>>>> "+dialysisSetupList.size());
		map.put("dialysisSetupList", dialysisSetupList);
		map.put("queueMap", queueMap);
		
		return map;
		
	}*/

	/**
	 * --------------------------- END OF CLASS
	 * ---------------------------------
	 */

	
	public Map<String, Object> getPriorityQueueByDepartIdDialysis(Box box) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, String> queueMap = new HashMap<String, String>();

		List<DialysisSchudeling> queueList=new ArrayList<DialysisSchudeling>();
		Criteria crt=null;
		String queueNo=null;
		
		
		List<DialysisSetup>  dialysisSetupList=new ArrayList<DialysisSetup>();
		List<DialysisSchudeling> patientAppointmentsList = new ArrayList<DialysisSchudeling>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DialysisSchudeling> slotAvailableList = new ArrayList<DialysisSchudeling>();
		List<Patient> registeredPatientList = new ArrayList<Patient>();
		List<DialysisSchudeling>filledDialysisSchedulingList = new ArrayList<DialysisSchudeling>();
		String slotList[][] = null;

		int departmentId = box.getInt("department");
		int noOfDoctors = 0;
		int counter = 1;
		int noOfSlots = 0;
		int percentageForSlots = 0;

		Integer[] noOfDoctorsList = new Integer[200];
		String queryString = null;
		String breakFromTime = "00:00:00";
		String breakToTime = "00:00:00";
		String days[] = new String[8];
		Time d_fromTime = Time.valueOf("00:00:00");
		Time d_toTime = Time.valueOf("00:00:00");
		Time d_slotDuration = Time.valueOf("00:00:00");
		Time d_breakFromTime = Time.valueOf("00:00:00");
		Time d_breakToTime = Time.valueOf("00:00:00");
		Time d_breakFromTime2 = Time.valueOf("00:00:00");
		Time d_breakToTime2 = Time.valueOf("00:00:00");
		Time d_breakFromTime3 = Time.valueOf("00:00:00");
		Time d_breakToTime3 = Time.valueOf("00:00:00");
		int consultId=0;
		int totalAppointments = 0;
		int maxNoOfDays = 0;
		int minNoOfDays = 0;
		Date maxDate = new Date();
		Date minDate = new Date();
		Date sysDate = new Date();
		Date apmtDate = new Date();
		int hospitalId=box.getInt("hospitalId");
		//System.out.println("hospitalId>>"+hospitalId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		/*Calendar c_appointmentDate = Calendar.getInstance();
		if (box.get("appointmentDate") != null && !box.get("appointmentDate").equals("")) {
			c_appointmentDate.setTime(HMSUtil.convertStringTypeDateToDateType(box.get("appointmentDate")));
			apmtDate = HMSUtil.convertStringTypeDateToDateType(box.get("appointmentDate"));
		}
		System.out.println(apmtDate+"apmtDate");*/
		String appointmentDays = "";
		if(!box.getString("appointmentDays").equals("")){
			appointmentDays =box.getString("appointmentDays"); 
		}
		logger.info("dayas========="+box.getString("appointmentDays"));
		if (box.get(CONSULTING_DOCTOR) != null && !box.get(CONSULTING_DOCTOR).equals("")) {
			consultId=Integer.parseInt(box.get(CONSULTING_DOCTOR));
		}
		String f="";
		if (box.get("FROMTIMESLOT") != null && !box.get("FROMTIMESLOT").equals("")) {
			f=box.get("FROMTIMESLOT");
		}
		
		String t="";
		if (box.get("TOTIMESLOT") != null && !box.get("TOTIMESLOT").equals("")) {
			t=box.get("TOTIMESLOT");
		}
		
		crt=session.createCriteria(DialysisSchudeling.class).createAlias("Hospital", "hosp").createAlias("Department", "dept");
		crt.add(Restrictions.eq("hosp.Id", hospitalId));
		crt.add(Restrictions.eq("dept.Id", departmentId));
		crt.add(Restrictions.eq("AppointmentDays",appointmentDays));
		crt.add(Restrictions.eq("FromTimeSlot",f));
		crt.add(Restrictions.eq("ToTimeSlot",t));
		
		
		queueList=crt.list();
		
		for(DialysisSchudeling qNo : queueList){
			queueNo=String.valueOf(qNo.getQueuePriority());
			
			queueMap.put(queueNo, queueNo);
		}
		logger.info(" Queue No" +queueNo);
		//String formattedDate = sdf.format(c_appointmentDate.getTime());

		SimpleDateFormat formatter = new SimpleDateFormat("EEEE"); 
	    String dayName = formatter.format(apmtDate);
	    logger.info(dayName+"====dayName" +hospitalId+"====hospitalId" +departmentId+"====departmentId");
		
		crt=session.createCriteria(DialysisSetup.class).createAlias("Hospital", "hosp").createAlias("Dept", "dept");
		crt.add(Restrictions.eq("hosp.Id", hospitalId));
		crt.add(Restrictions.eq("dept.Id", departmentId));
		crt.add(Restrictions.eq("Days",appointmentDays)); 
		dialysisSetupList=crt.list();
		
		logger.info("dialysisSetupList=="+dialysisSetupList.size());
		try {
			
			patientAppointmentsList = getHibernateTemplate().find(
					"from DialysisSchudeling apmt where Department= ?"
							+ " and AppointmentDays= ?",departmentId,appointmentDays); //changed by amit das on 01-08-2017
			
			logger.info("dialysisSetupList"+dialysisSetupList.size());
			
			if (dialysisSetupList != null && dialysisSetupList.size() > 0) {
				Iterator ite = dialysisSetupList.iterator();
				while (ite.hasNext()) {
					
					DialysisSetup dialysisSetup = (DialysisSetup) ite.next();
					
					logger.info(dialysisSetup.getFromTime() +"dialysisSetup.getFromTime() ");

					
			
					if (dialysisSetup.getFromTime() != null
							&& !dialysisSetup.getFromTime().equals("")) {
						d_fromTime = Time.valueOf(dialysisSetup.getFromTime()+":00");
					} else {
						d_fromTime = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getToTime() != null
							&& !dialysisSetup.getToTime().equals("")) {
						d_toTime = Time.valueOf(dialysisSetup.getToTime()+":00");
					} else {
						d_toTime = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getSlotDuration() != null
							&& !dialysisSetup.getSlotDuration().equals("")) {
						d_slotDuration = Time.valueOf(dialysisSetup
								.getSlotDuration()+":00");
					} else {
						d_slotDuration = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakFromTime() != null
							&& !dialysisSetup.getBreakFromTime().equals("")) {
						d_breakFromTime = Time.valueOf(dialysisSetup
								.getBreakFromTime()+":00");
					} else {
						d_breakFromTime = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakToTime() != null
							&& !dialysisSetup.getBreakToTime().equals("")) {
						d_breakToTime = Time.valueOf(dialysisSetup.getBreakToTime());
					} else {
						d_breakToTime = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakFromTime2() != null
							&& !dialysisSetup.getBreakFromTime2().equals("")) {
						d_breakFromTime2 = Time.valueOf(dialysisSetup
								.getBreakFromTime2());
					} else {
						d_breakFromTime2 = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakToTime2() != null
							&& !dialysisSetup.getBreakToTime2().equals("")) {
						d_breakToTime2 = Time.valueOf(dialysisSetup.getBreakToTime2());
					} else {
						d_breakToTime2 = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakFromTime3() != null
							&& !dialysisSetup.getBreakFromTime3().equals("")) {
						d_breakFromTime3 = Time.valueOf(dialysisSetup
								.getBreakFromTime3());
					} else {
						d_breakFromTime3 = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getBreakToTime3() != null
							&& !dialysisSetup.getBreakToTime3().equals("")) {
						d_breakToTime3 = Time.valueOf(dialysisSetup.getBreakToTime3());
					} else {
						d_breakToTime3 = Time.valueOf("00:00:00");
					}
					if (dialysisSetup.getNoOfDoctor() != null && !(dialysisSetup.getNoOfDoctor() == 0)) {
						noOfDoctors = dialysisSetup.getNoOfDoctor();
					} else {
						noOfDoctors = 0;
					}
				
					if (dialysisSetup.getMaxNoOfDays() != null
							&& !(dialysisSetup.getMaxNoOfDays() == 0)) {
						maxNoOfDays = dialysisSetup.getMaxNoOfDays();
					} else {
						maxNoOfDays = 0;
					}
					if (dialysisSetup.getMinNoOfDays() != null
							&& !(dialysisSetup.getMinNoOfDays() == 0)) {
						minNoOfDays = dialysisSetup.getMinNoOfDays();
					} else {
						minNoOfDays = 0;
					}
					if (dialysisSetup.getPercentageForSlots() != null
							&& !(dialysisSetup.getPercentageForSlots() == 0)) {
						percentageForSlots = dialysisSetup.getPercentageForSlots();
					} else {
						percentageForSlots = 0;
					}
					//maxDate = new Date(c_appointmentDate.getTimeInMillis()- maxNoOfDays * 24 * 60 * 60 * 1000);
					//minDate = new Date(c_appointmentDate.getTimeInMillis()- minNoOfDays * 24 * 60 * 60 * 1000);
					Date minParsedDate = null;
					Date sysParsedDate = null;
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					try {
						minParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(minDate));
						sysParsedDate = (Date) format.parse(HMSUtil
								.convertDateToStringWithoutTime(sysDate));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				
					if (sysDate.compareTo(maxDate) >= 0	&& (sysDate.compareTo(minDate) < 0 ||
						    sysParsedDate.equals(minParsedDate)) && apmtDate.compareTo(sysDate) >= 0) {
						
						map = calculateSlotsDoc(d_fromTime, d_toTime,d_slotDuration, d_breakFromTime, d_breakToTime,d_breakFromTime2, d_breakToTime2,d_breakFromTime3, d_breakToTime3 );
								
							
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfDoctors * noOfSlots)
									* percentageForSlots / 100;
						}
						int actualAvailableAppointments = totalAppointments
								- patientAppointmentsList.size();
						// **********************************************************
						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {

									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									slotAvailableList = getHibernateTemplate()
											.find("from DialysisSchudeling where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and AppointmentDays='"
													+ appointmentDays + "'");
									int temp = noOfDoctors
											- slotAvailableList.size();
									noOfDoctorsList[i] = temp;

								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						} else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this day is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetailForDialysis(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else if (minNoOfDays == 0 || maxNoOfDays == 0) {
						map = calculateSlots(d_fromTime, d_toTime,
								d_slotDuration, d_breakFromTime, d_breakToTime);
						slotList = (String[][]) map.get("slotList");
						counter = (Integer) map.get("counter");
						// **********************************************************
						// for counting no. of slots calculated done on 22 Aug
						// 2008.
						// calculation for restricting appointments according to
						// the percentage for slots
						// **********************************************************

						for (int i = 0; i < counter; i++) {
							if (slotList[i][1] != null) {
								noOfSlots++;
							}
						}
						if (percentageForSlots > 0) {
							totalAppointments = (noOfDoctors * noOfSlots)* percentageForSlots / 100;
						}
												
						int actualAvailableAppointments = totalAppointments	- patientAppointmentsList.size();
												
						// **********************************************************

						if (actualAvailableAppointments > 0) {
							map.put("actualAvailableAppointments",
									actualAvailableAppointments);
							try {
								for (int i = 0; i < counter; i++) {
									String slotDuration = slotList[i][0]
											+ " - " + slotList[i][1];
									
									
									slotAvailableList = getHibernateTemplate()
											.find("from DialysisSchudeling where FromTimeSlot>='"
													+ slotList[i][0]
													+ "' and ToTimeSlot<='"
													+ slotList[i][1]
													+ "' and Department="
													+ departmentId
													+ " and AppointmentDays='"
													+ appointmentDays + "'");
									
								
									
									int temp = noOfDoctors
											- slotAvailableList.size();
									noOfDoctorsList[i] = temp;
								}
							} catch (DataAccessException e) {
								e.printStackTrace();
							}
						}

						else {
							String message = null;
							if (noOfSlots == 0) {
								message = "Appointment for this day is not available!!";
							} else {
								message = "Appointments are full!!";
							}
							map.put("message", message);
						}
						if (box.get("parent") != null
								&& !box.get("parent").equals("")) {
							registeredPatientList = showExistingPatientDetail(Integer
									.parseInt((String) box.get("parent")));
							map.put("registeredPatientList",
									registeredPatientList);
						}

					} else {
						String message = "Wrong Appointment Date!!";
						map.put("message", message);
					}
				}

			} else if (dialysisSetupList != null && dialysisSetupList.size() == 0) {

				String message = "Dialysis Schedule for this department on the following day is not set.";
				map.put("message", message);
			}
			
			
			filledDialysisSchedulingList = session.createCriteria(DialysisSchudeling.class).add(Restrictions.eq("Department.Id", departmentId))
										.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("AppointmentDays", appointmentDays)).list();
			
			

		} catch (HibernateException e) {

			e.printStackTrace();
		}
		map.put("consultId", consultId);
		map.put("departmentList", departmentList);
		//map.put("apmtDate", apmtDate);
		map.put("appointmentDays", appointmentDays);
		map.put("filledDialysisSchedulingList", filledDialysisSchedulingList);
		// map.put("patientAppointmentsList", patientAppointmentsList);
		map.put("queueMap", queueMap);
		return map;

	}
	
	public Map<String, Object> submitDialysisScheduling(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DialysisSchudeling> hinList = new ArrayList<DialysisSchudeling>();
		List<Patient> patientList=new ArrayList<Patient>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		boolean duplicateRecord = false;
		String appointmentNo = null;
		int hinId=0;
		int queuePriority=0;
		boolean uhidStatus=false;

		String fromTimeSlot = box.getString("FROMTIMESLOT");
		String toTimeSlot = box.getString("TOTIMESLOT");
		
		int departmentId = box.getInt("department");
		queuePriority=box.getInt("preQueue");
		
		//Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box.get("appointmentDate"));
		String appointmentDays = box.getString("appointmentDays");
		String mobileNo = box.get("mob");
		
	
		int hospitalId = box.getInt("hospitalId");
		String userName = box.getString("userName");
		int userId= Integer.parseInt(""+box.get("userId"));
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");
		
		String Uhid="";
		Uhid=box.get("uhid");
		
		String patientName="";
		String sex="";
		String age="";
		
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", Uhid)).list();
		 for(Patient pat:patientList){
			 
			 hinId=pat.getId();
			 patientName=pat.getPFirstName();
			 if(null !=pat.getSex())
			 sex=pat.getSex().getAdministrativeSexName();
			 age=pat.getAge();
			 
		 }

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean patientNameExist = false;
		boolean recordExists = false;

		box.put("phinId", hinId);
		map = checkForApmtInDiffDeptDialysis(box);
		
	
		if (map.get("recordExists") != null) {
			recordExists = (Boolean) map.get("recordExists");
		}
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
	    String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");

	
		/*departmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y"))
				                .createAlias("DepartmentType", "dt").add(Restrictions.eq("dt.Id", 1)).list();*/
	    
	    departmentList=session.createCriteria(MasInstituteDepartment.class)
				.setProjection(Projections.property("Department"))
				.add(Restrictions.eq("Institute.Id",hospitalId))
				.add(Restrictions.eq("Status","y").ignoreCase())
				.createAlias("Department", "dep")
				.createAlias("dep.DepartmentType", "depType")
				.add(Restrictions.eq("depType.DepartmentTypeCode",depTypeCodeDialysis))
				.addOrder(Order.asc("dep.DepartmentName"))
				.list();
				
				
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			int i = 0;
			DialysisSchudeling dialysisSchudeling = new DialysisSchudeling();
			dialysisSchudeling.setFromTimeSlot((String) fromTimeSlot);
			dialysisSchudeling.setToTimeSlot((String) toTimeSlot);

			//dialysisSchudeling.setAppointmentDate(appointmentDate);
			dialysisSchudeling.setQueuePriority(queuePriority);
			dialysisSchudeling.setAppointmentDays(appointmentDays);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			dialysisSchudeling.setDepartment(masDepartment);

			Patient patient = new Patient();
			if (hinId >0) {
				patient.setId(hinId);
				dialysisSchudeling.setHin(patient);
				dialysisSchudeling.setRegisteredStatus("y");
				dialysisSchudeling.setAge(age);
				uhidStatus=true;
			} else {
				dialysisSchudeling.setRegisteredStatus("n");
				
			}
			
		
		
			dialysisSchudeling.setPatientName((String) patientName);
			dialysisSchudeling.setMobileNo(mobileNo);
			dialysisSchudeling.setSex((String) sex);

			dialysisSchudeling.setAppointmentStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			dialysisSchudeling.setHospital(masHospital);
			
			Users u = new Users();
			u.setId(userId);
			dialysisSchudeling.setLastChgBy(u);
			dialysisSchudeling.setLastChgDate(date);
			dialysisSchudeling.setLastChgTime(time);
			if(uhidStatus){
			if ( hinList != null) {
				if (hinList.size() == 0 && recordExists == false ) {
					hbt.save(dialysisSchudeling);
					int dialysisSchudelingId = dialysisSchudeling.getId();
					
					appointmentNo = generateAppointmentNoForDialysis(appointmentDays,departmentId, dialysisSchudelingId, "DS");
					
					DialysisSchudeling dialysisSchudeling1 = (DialysisSchudeling) hbt
							.load(DialysisSchudeling.class, dialysisSchudelingId);
					dialysisSchudeling1.setAppointmentNo(appointmentNo);
					hbt.saveOrUpdate(dialysisSchudeling1);
					dataSaved = true;
					duplicateRecord = false;
					map.put("appointmentNo", appointmentNo);
				} else if ( recordExists == true) {
					map.put("message",patientName	+ " already taken Dialysis Schudeling for this Department!!");
					dataSaved = false;
					duplicateRecord = true;
				}  else if (recordExists == true && hinList.size() == 0	&& patientNameExist == false) {
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			duplicateRecord = false;
		} else if (hinList.size() > 0 && patientNameExist == false	&& recordExists == true) {
			map.put("message",	patientName	+ " already taken Appointment for this Department!!");
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			dataSaved = false;
			duplicateRecord = true;
		}

			}
			}
			else{
				map.put("message",Uhid+ " is not valid UHID!");
			}
			map.put("recordExists", recordExists);
			map.put("patientNameExist", patientNameExist);
			map.put("dataSaved", dataSaved);
			map.put("patientName", patientName);
			map.put("duplicateRecord", duplicateRecord);
			map.put("age", age);
			map.put("sex", sex);

		} catch (Exception e) {
			dataSaved = false;
			e.printStackTrace();
		}
		return map;
	}
	

public Map<String, Object> checkForApmtInDiffDeptDialysis(Box box) {
		
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<DialysisSchudeling> hinList = new ArrayList<DialysisSchudeling>();
	
		
		int departmentId = box.getInt("department");

		int hospitalId = box.getInt("hospitalId");
		
		//Date appointmentDate = HMSUtil.convertStringTypeDateToDateType(box.get("appointmentDate"));
		String appointmentDays = box.getString("appointmentDays");
		
		int phinid=box.getInt("phinId");
		
		boolean recordExists = false;
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(DialysisSchudeling.class)
					.createAlias("Department", "dep").createAlias("Hospital", "hosp").createAlias("Hin", "pt")
					.add(Restrictions.eq("AppointmentStatus", "y").ignoreCase())
					.add(Restrictions.eq("AppointmentDays", appointmentDays))
					.add(Restrictions.eq("hosp.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", departmentId))
					.add(Restrictions.eq("pt.Id", phinid));

			
			
			/*if (!box.getString(PATIENT_NAME).equals("")) {
				criteria = criteria.add(Restrictions.eq("PatientName",
						box.getString(PATIENT_NAME)));
			}*/
			/*if (!box.getString(AGE).equals("")) {
				criteria = criteria.add(Restrictions.eq("Age",
						box.getString(AGE) + " " + box.getString(AGE_UNIT)));
			}
			if (!box.getString(MOBILE_NO).equals("")) {
				criteria = criteria.add(Restrictions.eq("MobileNo",
						box.get(MOBILE_NO)));
			}
			if (!box.getString(SEX).equals("")) {
				criteria = criteria.add(Restrictions.eq("Sex",
						box.getString(SEX)));
			}
*/
			hinList = criteria.list();
			if (hinList != null && hinList.size() > 0) {
				recordExists = true;
				logger.info("recordExists "+recordExists);
				Iterator ite = hinList.iterator();
				while (ite.hasNext()) {
					DialysisSchudeling d = (DialysisSchudeling) ite
							.next();
					if (!d.getDepartment().getId().equals(departmentId)) {
						recordExists = true;
						map.put("existingDept", d.getDepartment().getDepartmentName());
						map.put("existingStartTime",d.getFromTimeSlot());
						map.put("existingEndTime",d.getToTimeSlot());
					}

				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("recordExists", recordExists);
		map.put("hinList", hinList);
		return map;
	}

@Override
public synchronized Map<String,Object> getTotalVistByHospital(int hospitalId, int departmentId, Date vdate,
		int pHinId,int opsessionId,String hospitalCode) {
	String opSerialNo="hospital_code_"+hospitalCode+"_seq";
	
	logger.info("opSerialNo"+ opSerialNo);
	Map<String,Object> map=new HashMap<String,Object>();
	
	//System.out.println("hospitalId "+hospitalId+" departmentId "+departmentId+" vdate "+vdate+" pHinId "+pHinId+" opsessionId "+opsessionId+" hospitalCode "+hospitalCode);
	boolean ispreviouesToken=false;
	long TotaltokenNo = 0l;
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
	logger.info(" TotaltokenNo "+ TotaltokenNo);
	
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
public Map<String, Object> getServiceCentreWiseSession(Box box) {
	Session session = (Session) getSession();

	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> sessionList = new ArrayList<Object[]>();
	List<Object[]> hospitalSessionList = new ArrayList<Object[]>();
	sessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.eq("Department.Id", box.getInt("departmentId")))
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SessionName")))
			.list();
	
	if(sessionList.size() ==0){
		hospitalSessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.isNull("Department"))
				.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SessionName")))
				.list();
	}
	map.put("hospitalSessionList", hospitalSessionList);
	map.put("sessionList", sessionList);
	return map;
}

@Override
public Map<String, Object> getServiceCentreSessionForAppointment(Box box) {
	Session session = (Session) getSession();

	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> sessionList = new ArrayList<Object[]>();
	sessionList = session.createCriteria(MasSession.class).add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId"))).add(Restrictions.or(Restrictions.eq("Department.Id", box.getInt("departmentId")), Restrictions.isNull("Department")))
			.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("SessionName")))
			.list();
	
	
	map.put("sessionList", sessionList);
	return map;
}

@Override
public Map<String, Object> saveClientAppointmentPatientToServer(Box box) {
	Session session=(Session)getSession();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	//String data = "Out Patient |Mon Feb 29 00:00:00 IST 2016 |16:35 |123456213456 |123456213456 |Central1 |Central1 |null |Mon Jan 01 00:00:00 IST 1990 |26 Years |3 |3 |y |null |null | |null | | |null |null | |2 |16:38 |y |Mon Feb 29 16:38:08 IST 2016 |1990 |1 |432 |";
	String data=box.get("message");
	data = data.replace("null", " ");
	String hinNo = null;
	List<Patient> existPatientList = null;
	String dataPart = null;
	//data = "T000352001170060 |45 Years |AP-14082017-5-3664 |y |null |Mon Aug 14 00:00:00 IST 2017 |18 |5 | |null |1 |14:29 |431 |Fri Aug 11 00:00:00 IST 2017 |2222222222 |T AJITHKUMAR |18 |y |null |null |Male |null |";
	logger.info("this is data === "+data);
	String array[] = data.split("\\|"); 
	
	
	try{
	 
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	AppPatientAppointments appPatientAppointments = new AppPatientAppointments();
	int index = 0;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		List<Patient> patientList = 	 session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", dataPart.trim())).list();
		if(patientList!=null && patientList.size()==1){ 
			appPatientAppointments.setHin(patientList.get(0));
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAge(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentNo(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentStatus(dataPart.trim());
	
			
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentCancelDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasSession appSession = new MasSession(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setAppSession(appSession);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasDepartment masDepartment = new MasDepartment(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setDepartment(masDepartment);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasEmployee masEmployee = new MasEmployee(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setEmployee(masEmployee);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setFromTimeSlot(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasHospital masHospital = new MasHospital(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setHospital(masHospital);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setLastChgTime(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		Users users = new Users(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setLastChgBy(users);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setLastChgDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setMobileNo(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setPatientName(dataPart.trim());
		
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setQueuePriority(Integer.parseInt(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setRegisteredStatus(dataPart.trim());
		
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setServiceNo(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setServicePersonName(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setSex(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setToTimeSlot(dataPart.trim());
	
	
	hbt.save(appPatientAppointments);
	hbt.flush();
	hbt.clear();

	dataMap.put("success", "success");
	 }
    }
	
	}catch(Exception e){
		e.printStackTrace();
		dataMap.put("failure", "failure");
	}
	
	finally{
		session.close();
	}
		
	
	return dataMap;
}

//added by amit das on 09-08-2017
public String savePatientDataForAppointmentToLeanCentralServer(AppPatientAppointments appPatientAppointment, MasHospital hospital,String serverSideName){
	String message="failure";
	String patientAppointmentDataNotUploadToServer="N";
	try{
	StringBuilder insertAppPatientAppointmentFilds = new StringBuilder();
	
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getHin().getHinNo()).append(" |"); 
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getAge()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getAppointmentNo()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getAppointmentStatus()).append(" |"); 
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getAppointmentCancelDate()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getAppointmentDate()).append(" |");
	
	if(appPatientAppointment.getAppSession()!=null)
		insertAppPatientAppointmentFilds.append(appPatientAppointment.getAppSession().getId()).append(" |");
	else 
		insertAppPatientAppointmentFilds.append(" |");
	
	
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getDepartment().getId()).append(" |");
	
	if(appPatientAppointment.getEmployee()!=null)
		insertAppPatientAppointmentFilds.append(appPatientAppointment.getEmployee().getId()).append(" |");
	else 
		insertAppPatientAppointmentFilds.append(" |");	
	
	
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getFromTimeSlot()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getHospital().getId()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getLastChgTime()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getLastChgBy().getId()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getLastChgDate()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getMobileNo()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getPatientName()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getQueuePriority()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getRegisteredStatus()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getServiceNo()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getServicePersonName()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getSex()).append(" |");
	insertAppPatientAppointmentFilds.append(appPatientAppointment.getToTimeSlot()).append(" |");

	String dataOfAppPatientAppointment = insertAppPatientAppointmentFilds.toString();
	logger.info("Patient Appointment data from server "+dataOfAppPatientAppointment);
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	
	if(serverSideName!=null && serverSideName.equalsIgnoreCase("lean")){
		LeanServerPatientAppointmentData leanServerAppointmentData = new LeanServerPatientAppointmentData();
		leanServerAppointmentData.setPaitentAppointmentData(dataOfAppPatientAppointment);
		leanServerAppointmentData.setLeanAppointmentId(appPatientAppointment.getId());
		leanServerAppointmentData.setStatus(patientAppointmentDataNotUploadToServer);
		leanServerAppointmentData.setHospitalId(hospital.getId().longValue());
		hbt.save(leanServerAppointmentData);
	}else if(serverSideName.equalsIgnoreCase("central")){
		CentralServerPatientAppointmentData centralServerAppointmentData = new CentralServerPatientAppointmentData();
		centralServerAppointmentData.setPaitentAppointmentData(dataOfAppPatientAppointment);
		centralServerAppointmentData.setCentralAppointmentId(appPatientAppointment.getId());
		centralServerAppointmentData.setStatus(patientAppointmentDataNotUploadToServer);
		centralServerAppointmentData.setHospitalId(hospital.getId().longValue());
		hbt.save(centralServerAppointmentData);
	}
	
	
	hbt.flush();
	hbt.clear();
	message="success";
	logger.info("patient appointment data save successfuly at "+serverSideName+" server patient appointment data table");

	} catch(Exception e){
		e.printStackTrace();
	}
	
	
	return message;
}


@Override
public Map<String, Object> updateClientAppointmentPatientToServer(Box box) {
	Session session=(Session)getSession();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	//String data = "Out Patient |Mon Feb 29 00:00:00 IST 2016 |16:35 |123456213456 |123456213456 |Central1 |Central1 |null |Mon Jan 01 00:00:00 IST 1990 |26 Years |3 |3 |y |null |null | |null | | |null |null | |2 |16:38 |y |Mon Feb 29 16:38:08 IST 2016 |1990 |1 |432 |";
	String data=box.get("message");
	data = data.replace("null", " ");
	String dataPart = null;
	AppPatientAppointments appPatientAppointments = null;
	//data = "T000352001170060 |45 Years |AP-14082017-5-3664 |y |null |Mon Aug 14 00:00:00 IST 2017 |18 |5 | |null |1 |14:29 |431 |Fri Aug 11 00:00:00 IST 2017 |2222222222 |T AJITHKUMAR |18 |y |null |null |Male |null |";
	logger.info("this is data === "+data);

	String array[] = data.split("\\|"); 
	String appointmentNo = null;
	int departmentId = 0;
	int hospitalId = 0;
	Date appointmentDate = null;
	
	try{
	 
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_EAGER");
	hbt.setCheckWriteOperations(false);
	
	
	int index = 0;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		 appointmentNo = dataPart.trim();
		
	index++;
    dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		departmentId = Integer.parseInt(dataPart.trim());
		
		
		
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
			hospitalId = Integer.parseInt(dataPart.trim());
		

	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appointmentDate = HMSUtil
					.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim());
		
	List<AppPatientAppointments> appPatientAppointmentList = 	 session.createCriteria(AppPatientAppointments.class).add(Restrictions.eq("AppointmentNo", appointmentNo)).add(Restrictions.eq("Department.Id", departmentId)).add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("AppointmentDate", appointmentDate)).list();
	if(appPatientAppointmentList!=null && appPatientAppointmentList.size()==1){ 
			appPatientAppointments = appPatientAppointmentList.get(0);
					
		
		
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAge(dataPart.trim());
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
			List<Patient> patientList = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", dataPart.trim())).list();
			if(patientList!=null && patientList.size()>0){
				appPatientAppointments.setHin(patientList.get(0));
	

	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentStatus(dataPart.trim());
	
			
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setAppointmentCancelDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasSession appSession = new MasSession(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setAppSession(appSession);
	}
	
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		MasEmployee masEmployee = new MasEmployee(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setEmployee(masEmployee);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setFromTimeSlot(dataPart.trim());
	
	
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setLastChgTime(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) {
		Users users = new Users(Integer.parseInt(dataPart.trim()));
		appPatientAppointments.setLastChgBy(users);
	}
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setLastChgDate(HMSUtil
				.getDateForm_E_MMM_dd_HH_mm_ss_Z_yyyy(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setMobileNo(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setPatientName(dataPart.trim());
		
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setQueuePriority(Integer.parseInt(dataPart.trim()));
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setRegisteredStatus(dataPart.trim());
		
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setServiceNo(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setServicePersonName(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setSex(dataPart.trim());
	
	
	index++;
	dataPart = array[index];
	if (dataPart != null && !"".equals(dataPart.trim())) 
		appPatientAppointments.setToTimeSlot(dataPart.trim());
	
	
	hbt.update(appPatientAppointments);
	hbt.flush();
	hbt.clear();

	dataMap.put("success", "success");
			}
    	}
	  }
	}	
	}catch(Exception e){
		e.printStackTrace();
		dataMap.put("failure", "failure");
	}
	
	finally{
		session.close();
	}
		
	
	return dataMap;
}

public Map<String, Object> getDoctorUnit(Map<String, Object> map){
	List<HospitalDoctorUnitM> unitList = new ArrayList<HospitalDoctorUnitM>();
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	int departmentId = (Integer)map.get("departmentId");
	int hospitalId = (Integer)map.get("hospitalId");
	String appointmentDate = (String) map.get("appointmentDate");
	Session session = (Session) getSession();
	int doctor = 0;
	if(map.get("doctor")!=null){
		doctor =(Integer)map.get("doctor");
	}
	masDepartmentList = session.createCriteria(MasInstituteDepartment.class)
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
	
	String unitDay = "";
	/*try {
		unitDay = HMSUtil.getDayStringFromDate(appointmentDate).toLowerCase();
	} catch (ParseException e) {
		e.printStackTrace();
	}*/
	
	if(empDepartmentId.size()>0){
		unitList=session.createCriteria(HospitalDoctorUnitT.class).createAlias("UnitM","unitM")
		 .createAlias("unitM.Hospital", "Hospital").createAlias("unitM.EmpDept", "EmpDept")
		 .createAlias("Employee", "employee")
		 .add(Restrictions.eq("unitM.Hospital.Id", hospitalId))
		 .add(Restrictions.in("EmpDept.Id", empDepartmentId))
		 .add(Restrictions.eq("employee.Id", doctor))
		 .add(Restrictions.eq("Status", "y").ignoreCase())
		 .add(Restrictions.eq("unitM.Status", "y").ignoreCase())
		 .setProjection(Projections.projectionList()
		 .add(Projections.property("UnitM"))).list();
		//.add(Restrictions.eq(((String) unitDay.subSequence(0,1)).toUpperCase()+unitDay.substring(1),"y"))
	}
	
	if(map.get("personalReview")!=null && map.get("personalReview").equals("yes")){
		if(unitList.size()>0 && doctor!=0){
			HospitalDoctorUnitM unitM=unitList.get(0);
			
			List<HospitalDoctorUnitT> unitT=new ArrayList<HospitalDoctorUnitT>();
			unitT=session.createCriteria(HospitalDoctorUnitT.class)
					.createAlias("UnitM", "unitM")
					.add(Restrictions.eq("unitM.Id", unitM.getId()))
					.add(Restrictions.eq("Employee.Id", doctor))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.list();
			if(unitT.size()==0){
				map.put("message", "Current OP Unit and Future OP Unit Does Not Match.\nDo You Want To Continue ?");
			}
			
		}else{
			map.put("message", "No Unit is Available For Selected Date !");
		}
	}
	map.put("unitList", unitList);
	return map;
}

	public Map<String, Object> getCounterTimingForDepartment(int department, int hospital) {
		List<HospitalDoctorUnitM> unitList = new ArrayList<HospitalDoctorUnitM>();
		List<MasInstituteDepartment> masDepartmentList = new ArrayList<MasInstituteDepartment>();
		Map<String, Object> map=new HashMap();
		Session session = (Session) getSession();
		
		String openTime=null;
		String closeTime=null;
		try {
			masDepartmentList = session
					.createCriteria(MasInstituteDepartment.class)
					.add(Restrictions.eq("Institute.Id", hospital))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dep")
					.add(Restrictions.eq("dep.Id", department)).list();
			if(masDepartmentList.size() > 0){
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
	
	 @Override
	 public List<String> getSessionForDepartment(int deptId, int hospitalId,String appointmentTime) {
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
	 	
		/*SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy HH:mm");
		Date date = null;
		try {
			date=sdf.parse(appointmentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
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
	 			if(masSessionList.size() ==0){
	 				for(MasSession masSession:sessionList){ 
	 						masSessionList.add(masSession.getId()+":"+masSession.getSessionName());
	 				}
	 			}
	 		}
	 		
	 	}catch(Exception e){
	 		e.printStackTrace();
	 	}
	 	
	 	return masSessionList;
	 }

}
