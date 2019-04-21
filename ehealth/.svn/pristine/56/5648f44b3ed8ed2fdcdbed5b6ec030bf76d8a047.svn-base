package jkt.hms.pubHealth.dataservice;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.IMEI;
import static jkt.hms.util.RequestConstants.MAC;
import static jkt.hms.util.RequestConstants.SIM;
import static jkt.hms.util.RequestConstants.UTID;
import static jkt.hms.util.RequestConstants.INSTITUTE_CODE;
import static jkt.hms.util.RequestConstants.INSTITUTE_NAME;
import static jkt.hms.util.RequestConstants.INSTITUTE_TYPE;
import static jkt.hms.util.RequestConstants.DISTRICT_NAME;
import static jkt.hms.util.RequestConstants.HOSPITAL;
import static jkt.hms.util.RequestConstants.INSTITUTE_TYPES;
import static jkt.hms.util.RequestConstants.INSTITUTE_TYPES_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.AshaMapping;
import jkt.hms.masters.business.AshaWorker;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DiseasesIcdMapping;
import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.HmisDistrictReport;
import jkt.hms.masters.business.HmisHospitalReport;
import jkt.hms.masters.business.HmisParameterMapping;
import jkt.hms.masters.business.HrEmployeeAddress;
import jkt.hms.masters.business.IdspHospitalReport;
import jkt.hms.masters.business.IdspHospitalReportForml;
import jkt.hms.masters.business.InjAppointmentDetails;
import jkt.hms.masters.business.InjAppointmentHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InvestigationIcdMapping;
import jkt.hms.masters.business.LocationParameterMapping;
import jkt.hms.masters.business.MasActionTaken;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAnswers;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasDeliveryType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasFrequency;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasNursingCare;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPhReportsParameters;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasQuestionAnswers;
import jkt.hms.masters.business.MasQuestions;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasSpecialityDeptGroup;
import jkt.hms.masters.business.MasSpecialityDeptGroupValue;
import jkt.hms.masters.business.MasSpecialityGroup;
import jkt.hms.masters.business.MasSpecialityParameter;
import jkt.hms.masters.business.MasSpecialtyGroupParameter;
import jkt.hms.masters.business.MasSpecialtyTemplate;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasSurveyTarget;
import jkt.hms.masters.business.MasSurveyTargetStatus;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.OpdSpecialityDetails;
import jkt.hms.masters.business.OpdVaccinMst;
import jkt.hms.masters.business.OpdVaccinationPlan;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.PatientPrescriptionHeader;
import jkt.hms.masters.business.PhAncSurvey;
import jkt.hms.masters.business.PhAntenatalRegistrationSurvey;
import jkt.hms.masters.business.PhAtpJphnJhiDetails;
import jkt.hms.masters.business.PhAtpJphnJhiHeader;
import jkt.hms.masters.business.PhBirthDeathReg;
import jkt.hms.masters.business.PhClassDetails;
import jkt.hms.masters.business.PhDayBlock;
import jkt.hms.masters.business.PhDayBlockDetail;
import jkt.hms.masters.business.PhDiseaseRegistration;
import jkt.hms.masters.business.PhFamilyPlaningReg;
import jkt.hms.masters.business.PhFamilySurvey;
import jkt.hms.masters.business.PhHouseSurvey;
import jkt.hms.masters.business.PhJphnJhiDetails;
import jkt.hms.masters.business.PhJphnJhiHeader;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasOrgCategory;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.PhMemberTransferDetails;
import jkt.hms.masters.business.PhStudentHealthDetails;
import jkt.hms.masters.business.PhStudentRegistration;
import jkt.hms.masters.business.PhSyndromicSurvcillenceMapping;
import jkt.hms.masters.business.PhVillageSurvey;
import jkt.hms.masters.business.ProcedureDetails;
import jkt.hms.masters.business.ProcedureHeader;
import jkt.hms.masters.business.RouteOfAdministration;
import jkt.hms.masters.business.StoreFyDocumentNo;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreReservationCamp;
import jkt.hms.masters.business.StoreReservationCampGroup;
import jkt.hms.masters.business.StoreReservationJphn;
import jkt.hms.masters.business.StoreReservationM;
import jkt.hms.masters.business.StoreReservationPartialStock;
import jkt.hms.masters.business.StoreReservationT;
import jkt.hms.masters.business.SurveyDetailMails;
import jkt.hms.masters.business.UserHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
/*import jkt.hms.masters.business.*;*/
import jkt.hms.masters.dataservice.BillingMasterDataService;
import jkt.hms.opd.dataservice.OPDDataService;
import jkt.hms.snomed.SNOMEDAgentUtil;
import jkt.hms.snomed.SuffixCount;
import jkt.hms.util.Box;
import jkt.hms.util.ChildPojoForHmisParameter;
import jkt.hms.util.DiseasesContsants;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.ImmunizationUtil;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.util.SendMail;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.derby.tools.sysinfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.apache.xerces.parsers.IntegratedParserConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Transaction;
import org.hibernate.annotations.FetchMode;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import sun.reflect.generics.visitor.Reifier;

@SuppressWarnings("unused")
public class PubHealthDataServiceImpl extends HibernateDaoSupport implements
		PubHealthDataService {

	private OPDDataService opdDataService = null; // added by amit das on
													// 15-09-2016
	private static final Logger logger = Logger.getLogger(PubHealthDataServiceImpl.class);
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showDayBlockAllocationJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();

		List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();
		Session session = (Session) getSession();
		phMasLocalityList = session
				.createCriteria(LocationParameterMapping.class)
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				// .add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		/*phHouseSurveyList = session.createCriteria(PhHouseSurvey.class)
		// .add(Restrictions.eq("Status","y").ignoreCase())
				.list();*/

		map.put("phMasLocalityList", phMasLocalityList);
		map.put("phHouseSurveyList", phHouseSurveyList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> fillLoc(String val,
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session ses = (Session) getSession();
		int empId = (Integer) detailsMap.get("empId");
		int hospitalId = (Integer) detailsMap.get("hospitalId");
		Integer instId = Integer.parseInt(val);
		int day = (Integer) detailsMap.get("day");
		List<Integer> houseSurveys = ses.createCriteria(PhDayBlockDetail.class)
				.setProjection(Projections.property("Survey.Id")).list();
		List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();
		Criteria crt = ses
				.createCriteria(PhHouseSurvey.class)
				.createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Hospital.Id",
						detailsMap.get("hospitalId")))
				.add(Restrictions.eq("Locality.Id", instId))
				.add(Restrictions.eq("Hospital.Id",
						detailsMap.get("hospitalId")))
				.add(Restrictions.eq("Locality.Id", instId));
		if (houseSurveys.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", houseSurveys)));
		}
		phHouseSurveyList = crt.list();

		/*
		 * List<String> phLocalityDayBlockList =
		 * ses.createCriteria(PhDayBlock.class) .createAlias("Employee", "e")
		 * .add(Restrictions.eq("e.Id", empId)) .createAlias("Hospital", "h")
		 * .add(Restrictions.eq("h.Id", hospitalId))
		 * .add(Restrictions.eq("ForDay",
		 * day)).setProjection(Projections.property("HouseId")) .list();
		 * 
		 * List<Integer> hidList = new ArrayList<Integer>();
		 * 
		 * if(phLocalityDayBlockList.size() > 0){ String hIds =
		 * phLocalityDayBlockList.get(0); String[] houseId = hIds.split(",");
		 * for (int i = 0; i < houseId.length; i++) {
		 * 
		 * hidList.add(Integer.parseInt(houseId[i].trim())); }
		 * List<PhHouseSurvey> dayBlockHouseList =
		 * ses.createCriteria(PhHouseSurvey.class).add(Restrictions.in("Id",
		 * hidList)).add(Restrictions.eq("Locality.Id", instId)).list();
		 * map.put("dayBlockHouseList", dayBlockHouseList); }
		 */

		map.put("phHouseSurveyList", phHouseSurveyList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAdvanceTourPlanJPHNAndJHIJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();

		List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();
		Session session = (Session) getSession();
		phMasLocalityList = session.createCriteria(PhMasLocality.class)
				.createAlias("Ward", "w").createAlias("w.SubCenter", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				// .add(Restrictions.eq("Status","y").ignoreCase())
				.list();
		phHouseSurveyList = session.createCriteria(PhHouseSurvey.class)
		// .add(Restrictions.eq("Status","y").ignoreCase())
				.list();

		List<PhDayBlock> pList = new ArrayList<PhDayBlock>();
		pList = session.createCriteria(PhDayBlock.class)
		// .add(Restrictions.eq("ForDay",day))
		// .createAlias("Employee","e")
		// .add(Restrictions.eq("e.Id", detailsMap.get("empId")))
				.list();
		map.put("phDayBlockList", pList);
		map.put("phMasLocalityList", phMasLocalityList);
		map.put("phHouseSurveyList", phHouseSurveyList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> saveDayBlockAllocation(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		String flag = "";
		if (detailsMap.get("flag") != null) {
			flag = (String) detailsMap.get("flag");
		}

		if (flag.equalsIgnoreCase("u")) {
			int day = 0;
			if (detailsMap.get("day") != null) {
				day = (Integer) detailsMap.get("day");
			}

			List<PhDayBlock> pList = new ArrayList<PhDayBlock>();

			pList = session.createCriteria(PhDayBlock.class)
					.add(Restrictions.eq("ForDay", day))
					.createAlias("Employee", "e")
					.add(Restrictions.eq("e.Id", detailsMap.get("empId")))
					.list();

			for (PhDayBlock ph : pList) {
				int dbaId = ph.getId();
				PhDayBlock phDayBlock = (PhDayBlock) hbt.load(PhDayBlock.class,
						dbaId);
				try {
					int days = 0;

					if (detailsMap.get("day") != null) {
						days = (Integer) detailsMap.get("day");
						phDayBlock.setForDay(days);
					}
					int empId = 0;
					if (detailsMap.get("empId") != null) {
						empId = (Integer) detailsMap.get("empId");
						MasEmployee employee = new MasEmployee();
						employee.setId(empId);
						phDayBlock.setEmployee(employee);
					}
					int hospitalId = 0;
					if (detailsMap.get("hospitalId") != null) {
						hospitalId = (Integer) detailsMap.get("hospitalId");
						MasHospital hospital = new MasHospital();
						hospital.setId(hospitalId);
						phDayBlock.setHospital(hospital);
					}
					String houseStr = "";
					if (detailsMap.get("houseStr") != null) {
						houseStr = (String) detailsMap.get("houseStr");
						phDayBlock.setHouseId(houseStr);
					}
					phDayBlock.setLastChgDate(date);
					phDayBlock.setLastChgTime(time);

					int userId = 0;

					if (detailsMap.get("userId") != null) {
						userId = (Integer) detailsMap.get("userId");
						Users users = new Users();
						users.setId(userId);
						phDayBlock.setLastChgBy(users);
					}

					hbt.update(phDayBlock);
					saved = true;

					List<PhDayBlockDetail> pdList = new ArrayList<PhDayBlockDetail>();
					pdList = session.createCriteria(PhDayBlockDetail.class)
							.createAlias("Day", "d")
							.add(Restrictions.eq("d.Id", dbaId))
							// .createAlias("d.Employee","e")
							// .add(Restrictions.eq("e.Id",
							// detailsMap.get("empId")))
							.list();

					if (pdList.size() > 0) {
						hbt.deleteAll(pdList);
					}
					String[] house = null;
					if (detailsMap.get("house") != null) {
						house = (String[]) detailsMap.get("house");

						for (int i = 0; i < house.length; i++) {
							List<Object[]> locWardList = new ArrayList<Object[]>();
							locWardList = session
									.createCriteria(PhHouseSurvey.class)
									.add(Restrictions.eq("Id",
											Integer.parseInt(house[i])))
									.setProjection(
											Projections
													.projectionList()
													.add(Projections
															.property("Locality.Id"))
													.add(Projections
															.property("Ward.Id")))
									.list();
							Object[] obj = locWardList.get(0);
							int localityId = (Integer) obj[0];
							int wardId = (Integer) obj[1];
							PhDayBlockDetail phDayBlockDetail = new PhDayBlockDetail();
							PhHouseSurvey phHouseSurvey = new PhHouseSurvey();
							phHouseSurvey.setId(Integer.parseInt(house[i]));
							phDayBlockDetail.setSurvey(phHouseSurvey);

							PhMasLocality locality = new PhMasLocality();
							locality.setId(localityId);
							phDayBlockDetail.setLocality(locality);

							MasWard ward = new MasWard();
							ward.setId(wardId);
							phDayBlockDetail.setWard(ward);

							phDayBlockDetail.setDay(phDayBlock);

							hbt.save(phDayBlockDetail);
							saved = true;
						}

					}

				} catch (Exception e) {
					saved = false;
					e.printStackTrace();
				}
			}
		} else {
			PhDayBlock phDayBlock = new PhDayBlock();

			try {

				int day = 0;

				if (detailsMap.get("day") != null) {
					day = (Integer) detailsMap.get("day");
					phDayBlock.setForDay(day);
				}
				int empId = 0;
				if (detailsMap.get("empId") != null) {
					empId = (Integer) detailsMap.get("empId");
					MasEmployee employee = new MasEmployee();
					employee.setId(empId);
					phDayBlock.setEmployee(employee);
				}
				int hospitalId = 0;
				if (detailsMap.get("hospitalId") != null) {
					hospitalId = (Integer) detailsMap.get("hospitalId");
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					phDayBlock.setHospital(hospital);
				}
				String houseStr = "";
				if (detailsMap.get("houseStr") != null) {
					houseStr = (String) detailsMap.get("houseStr");
					phDayBlock.setHouseId(houseStr);
				}
				phDayBlock.setLastChgDate(date);
				phDayBlock.setLastChgTime(time);

				int userId = 0;

				if (detailsMap.get("userId") != null) {
					userId = (Integer) detailsMap.get("userId");
					Users users = new Users();
					users.setId(userId);
					phDayBlock.setLastChgBy(users);
				}

				hbt.save(phDayBlock);
				saved = true;

				String[] house = null;
				if (detailsMap.get("house") != null) {
					house = (String[]) detailsMap.get("house");

					for (int i = 0; i < house.length; i++) {
						List<Object[]> locWardList = new ArrayList<Object[]>();
						locWardList = session
								.createCriteria(PhHouseSurvey.class)
								.add(Restrictions.eq("Id",
										Integer.parseInt(house[i])))
								.setProjection(
										Projections
												.projectionList()
												.add(Projections
														.property("Locality.Id"))
												.add(Projections
														.property("Ward.Id")))
								.list();
						Object[] obj = locWardList.get(0);
						int localityId = (Integer) obj[0];
						int wardId = (Integer) obj[1];
						PhDayBlockDetail phDayBlockDetail = new PhDayBlockDetail();
						PhHouseSurvey phHouseSurvey = new PhHouseSurvey();
						phHouseSurvey.setId(Integer.parseInt(house[i]));
						phDayBlockDetail.setSurvey(phHouseSurvey);

						PhMasLocality locality = new PhMasLocality();
						locality.setId(localityId);
						phDayBlockDetail.setLocality(locality);

						MasWard ward = new MasWard();
						ward.setId(wardId);
						phDayBlockDetail.setWard(ward);

						phDayBlockDetail.setDay(phDayBlock);

						hbt.save(phDayBlockDetail);
						saved = true;
					}

				}
			} catch (Exception e) {
				saved = false;
				e.printStackTrace();
			}
		}
		map.put("flag", flag);
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDayBlockId(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
		List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();
		List<PhDayBlock> pList = new ArrayList<PhDayBlock>();
		List<PhDayBlockDetail> pdList = new ArrayList<PhDayBlockDetail>();
		Session session = (Session) getSession();
		int day = 0;
		int ward = 0;
		if (detailsMap.get("day") != null) {
			day = (Integer) detailsMap.get("day");
		}
		if (detailsMap.get("ward") != null) {
			ward = (Integer) detailsMap.get("ward");
		}

		pList = session.createCriteria(PhDayBlock.class)
				.add(Restrictions.eq("ForDay", day))
				.createAlias("Employee", "e")
				.add(Restrictions.eq("e.Id", detailsMap.get("empId"))).list();
		logger.info(detailsMap.get("hospitalId") + " hospitalId");

		Criteria cr = session.createCriteria(LocationParameterMapping.class)
				.add(Restrictions.eq("Hospital.Id",	detailsMap.get("hospitalId")));
		if(ward != 0)
				cr.add(Restrictions.eq("Ward.Id", ward));

		// .add(Restrictions.eq("Status","y").ignoreCase())
		phMasLocalityList = cr.list();
		
		logger.info(phMasLocalityList.size() + "phMasLocalityList");
		
		phHouseSurveyList = session
				.createCriteria(PhHouseSurvey.class)
				.createAlias("Hospital", "Hospital")
				.add(Restrictions.eq("Hospital.Id",
						detailsMap.get("hospitalId"))).list();
		
		pdList = session.createCriteria(PhDayBlockDetail.class)
				.createAlias("Day", "d").add(Restrictions.eq("d.ForDay", day))
				.createAlias("d.Employee", "e")
				.add(Restrictions.eq("e.Id", detailsMap.get("empId"))).list();
		
		logger.info(pdList.size() + "pdList");
		/*
		 * List<String> phLocalityDayBlockList =
		 * session.createCriteria(PhDayBlock.class) .createAlias("Employee",
		 * "e") .add(Restrictions.eq("e.Id", detailsMap.get("empId")))
		 * .createAlias("Hospital", "h") .add(Restrictions.eq("h.Id",
		 * detailsMap.get("hospitalId"))) .add(Restrictions.eq("ForDay",
		 * day)).setProjection(Projections.property("HouseId")) .list();
		 * 
		 * List<Integer> hidList = new ArrayList<Integer>();
		 * 
		 * if(phLocalityDayBlockList.size() > 0){ String hIds =
		 * phLocalityDayBlockList.get(0); String[] houseId = hIds.split(",");
		 * for (int i = 0; i < houseId.length; i++) {
		 * 
		 * hidList.add(Integer.parseInt(houseId[i].trim())); }
		 * List<PhHouseSurvey> dayBlockHouseList =
		 * session.createCriteria(PhHouseSurvey.class).add(Restrictions.in("Id",
		 * hidList)).list(); map.put("dayBlockHouseList", dayBlockHouseList); }
		 */
		map.put("pdList", pdList);
		map.put("pList", pList);
		map.put("phMasLocalityList", phMasLocalityList);
		map.put("phHouseSurveyList", phHouseSurveyList);
		return map;
	}

	@Override
	public Map<String, Object> getWard(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> phMasWard = new ArrayList<Object[]>();
		List<MasWard> phMasWardList = new ArrayList<MasWard>();
		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference

		try {

			Criteria cr = session.createCriteria(LocationParameterMapping.class)
					.createAlias("Ward", "ward")
					.add(Restrictions.eq("Hospital.Id",	dataMap.get("hospitalId")))
					.add(Restrictions.isNotNull("Ward.Id"))
			 		.setProjection(Projections.projectionList()
			 		.add(Projections.groupProperty("ward.Id"))
			 		.add(Projections.groupProperty("ward.WardName")));
			phMasWard = cr.list();

			for (Object[] objects : phMasWard) {
				MasWard masWard = new MasWard();
				masWard.setId((Integer) objects[0]);
				masWard.setWardName((String) objects[1]);
				phMasWardList.add(masWard);
			}
			logger.info(phMasWardList.size() + "phMasWardList");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("phMasWardList", phMasWardList);

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAtpJphnJhiJsp(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();

		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();

		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);

		Session session = (Session) getSession();

		phDayBlockList = session.createCriteria(PhDayBlock.class)
				.createAlias("Employee", "e")
				.add(Restrictions.eq("e.Id", detailsMap.get("empId"))).list();
		/*
		 * phAtpJphnJhiDetailsList =
		 * session.createCriteria(PhAtpJphnJhiDetails.class
		 * ).createAlias("PendingDayBlock", "pdb").createAlias("DayBlock", "db")
		 * .createAlias("pdb.PhDayBlockDetails",
		 * "pdbd").createAlias("pdbd.Survey", "psu").createAlias("psu.Locality",
		 * "ploc").createAlias("psu.Ward", "pw")
		 * .createAlias("db.PhDayBlockDetails", "dbd").createAlias("dbd.Survey",
		 * "dsu").createAlias("dsu.Locality", "dloc").createAlias("dsu.Ward",
		 * "dw") .createAlias("AtpHeader",
		 * "ah").createAlias("ah.AshaWorker","e").add(Restrictions.eq("e.Id",
		 * detailsMap.get("empId")))
		 * .setProjection(Projections.projectionList().
		 * add(Projections.property("DateAtp"))
		 * .add(Projections.groupProperty("pdb.ForDay"
		 * )).add(Projections.count("psu.Id"
		 * )).add(Projections.count("ploc.Id")).add(Projections.count("pw.Id"))
		 * .add(Projections.groupProperty("db.ForDay")).add(Projections.count(
		 * "dsu.Id"
		 * )).add(Projections.count("dloc.Id")).add(Projections.count("dw.Id"))
		 * .add(Projections.property("RoutineActivity"))
		 * .add(Projections.property("OtherActivity"))
		 * .add(Projections.property("AfterNoonActivity"))
		 * .add(Projections.property("Remarks"))
		 * .add(Projections.groupProperty("DateAtp"
		 * )).add(Projections.groupProperty
		 * ("psu.Id")).add(Projections.groupProperty
		 * ("ploc.Id")).add(Projections.groupProperty("pw.Id"))
		 * .add(Projections.
		 * groupProperty("dsu.Id")).add(Projections.groupProperty
		 * ("dloc.Id")).add(Projections.groupProperty("dw.Id"))
		 * .add(Projections.groupProperty("RoutineActivity"))
		 * .add(Projections.groupProperty("OtherActivity"))
		 * .add(Projections.groupProperty("AfterNoonActivity"))
		 * .add(Projections.groupProperty("Remarks")) ) .list();
		 */
		/*
		 * String qry=
		 * "select pajjd.date_atp,pdb.for_day,COUNT(dbd.survey_id),count(dbd.ward_id),COUNT(dbd.locality_id) from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id "
		 * +
		 * "LEFT OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id "
		 * +
		 * "LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id  group by pajjd.date_atp,pdb.for_day;"
		 * ;
		 * 
		 * phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();
		 */

		/*
		 * String qry =
		 * "select x.A1,X.A2,X.A3,X.A4,X.A5,X.B2,X.B3,X.B4,X.B5,X.A6,X.A7,X.A8,X.A10,X.A9,X.B6,X.B7,X.B8,X.B10,X.B9 FROM ((select pajjd.day_block_id AS A0,pajjd.date_atp as A1,pdb.for_day AS A2,COUNT(dbd.survey_id) AS A3,count(dbd.locality_id) AS A4,COUNT(dbd.ward_id) AS A5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS A6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS A7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS A8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS A9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS A10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id where pajjh.for_month ='"
		 * + month +
		 * "'  group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)a left outer join (select pajjd.day_block_id AS B0,pajjd.date_atp AS B1,pdb.for_day AS B2,COUNT(dbd.survey_id) AS B3,count(dbd.locality_id) AS B4,COUNT(dbd.ward_id) B5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS B6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS B7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS B8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS B9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS B10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id  where pajjh.for_month ='"
		 * + month +
		 * "' group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)b on a.A0=b.B0)x;"
		 * ; phAtpJphnJhiDetailsList = (List)
		 * session.createSQLQuery(qry).list();
		 */
		String qry = "select ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id),ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker left outer join mm_mas_request_status mmrs ON mmrs.status_id = ajjh.status where ajjh.for_month ='"
				+ month
				+ "'group by ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name,	ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name";

		phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();

		/*
		 * if(phAtpJphnJhiDetailsList.size()==0) { qry=
		 * "select x.A1,X.A2,X.A3,X.A4,X.A5,X.B2,X.B3,X.B4,X.B5,X.A6,X.A7,X.A8,X.A10,X.A9,X.B6,X.B7,X.B8,X.B10,X.B9 FROM ((select pajjd.day_block_id AS A0,pajjd.date_atp as A1,pdb.for_day AS A2,COUNT(dbd.survey_id) AS A3,count(dbd.locality_id) AS A4,COUNT(dbd.ward_id) AS A5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS A6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS A7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS A8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS A9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS A10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)a left outer join (select pajjd.day_block_id AS B0,pajjd.date_atp AS B1,pdb.for_day AS B2,COUNT(dbd.survey_id) AS B3,count(dbd.locality_id) AS B4,COUNT(dbd.ward_id) B5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS B6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS B7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS B8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS B9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS B10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)b on a.A0=b.B0)x;"
		 * ; phAtpJphnJhiDetailsList = (List)
		 * session.createSQLQuery(qry).list(); }
		 */
		map.put("phDayBlockList", phDayBlockList);
		map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitAtpJphnJhi(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			PhAtpJphnJhiHeader phAtpJphnJhiHeader = new PhAtpJphnJhiHeader();

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("empId"));
			phAtpJphnJhiHeader.setAshaWorker(masEmployee);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			phAtpJphnJhiHeader.setHospital(hospital);

			phAtpJphnJhiHeader.setForMonth(box.getString("atpJphniJhiMonths"));

			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			phAtpJphnJhiHeader.setLastChgBy(user);

			phAtpJphnJhiHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			phAtpJphnJhiHeader.setLastChgTime(box.getString(CHANGED_TIME));

			hbt.save(phAtpJphnJhiHeader);

			int counter = box.getInt("hiddenValueCharge");

			for (int i = 1; i <= counter; i++) {
				int dayBlockId = 0;
				String typeName = "";
				String remarks = "";
				int dayBlockIdP = 0;
				PhAtpJphnJhiDetails PhAtpJphnJhi = new PhAtpJphnJhiDetails();
				if (!box.getString("dateAtp" + i).equals("")) {
					PhAtpJphnJhi.setAtpHeader(phAtpJphnJhiHeader);

					PhDayBlock phDayBlock = new PhDayBlock();
					if (box.getInt("dayBlockId" + i) != 0) {
						dayBlockId = box.getInt("dayBlockId" + i);
						phDayBlock.setId(dayBlockId);
						PhAtpJphnJhi.setDayBlock(phDayBlock);
					}

					PhDayBlock phDayBlockP = new PhDayBlock();
					if (box.getInt("dayBlockIdP" + i) != 0) {
						dayBlockIdP = box.getInt("dayBlockIdP" + i);
						phDayBlockP.setId(dayBlockIdP);
						PhAtpJphnJhi.setPendingDayBlock(phDayBlockP);
					}

					PhAtpJphnJhi.setDateAtp(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("dateAtp" + i)));

					if (!box.getString("remarks" + i).equals("")) {
						remarks = box.getString("remarks" + i);
						PhAtpJphnJhi.setRemarks(remarks);
					}

					String routineActivity = "";
					if (!box.getString("routineActivity" + i).equals("")) {
						routineActivity = box.getString("routineActivity" + i);
						PhAtpJphnJhi.setRoutineActivity(routineActivity);
					}

					String otherActivity = "";
					if (!box.getString("otherActivity" + i).equals("")) {
						otherActivity = box.getString("otherActivity" + i);
						PhAtpJphnJhi.setOtherActivity(otherActivity);
					}

					String afterNoonActivity = "";
					if (!box.getString("afterNoonActivity" + i).equals("")) {
						afterNoonActivity = box.getString("afterNoonActivity"
								+ i);
						PhAtpJphnJhi.setAfterNoonActivity(afterNoonActivity);
					}
					hbt.save(PhAtpJphnJhi);

				}
			}

			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		String monthValue = box.getString("atpJphniJhiMonths");
		/*
		 * String qry =
		 * "select x.A1,X.A2,X.A3,X.A4,X.A5,X.B2,X.B3,X.B4,X.B5,X.A6,X.A7,X.A8,X.A10,X.A9,X.B6,X.B7,X.B8,X.B10,X.B9 FROM ((select pajjd.day_block_id AS A0,pajjd.date_atp as A1,pdb.for_day AS A2,COUNT(dbd.survey_id) AS A3,count(dbd.locality_id) AS A4,COUNT(dbd.ward_id) AS A5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS A6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS A7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS A8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS A9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS A10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id where pajjh.for_month ='"
		 * + monthValue +
		 * "'  group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)a left outer join (select pajjd.day_block_id AS B0,pajjd.date_atp AS B1,pdb.for_day AS B2,COUNT(dbd.survey_id) AS B3,count(dbd.locality_id) AS B4,COUNT(dbd.ward_id) B5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS B6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS B7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS B8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS B9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS B10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id  where pajjh.for_month ='"
		 * + monthValue +
		 * "' group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)b on a.A0=b.B0)x;"
		 * ;
		 */

		String qry = "select ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id),ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker left outer join mm_mas_request_status mmrs ON mmrs.status_id = ajjh.status where ajjh.for_month ='"
				+ monthValue
				+ "'group by ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name,	ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name";

		phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();

		phDayBlockList = session.createCriteria(PhDayBlock.class)
		// .add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		map.put("saved", saved);
		map.put("phDayBlockList", phDayBlockList);
		map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showAtpJphnJhiApprovalJsp(int hospitalId) {
		List<Object> phAtpJphnJhiHeaderList = new ArrayList<Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MmMasRequestStatus> mmMasRequestStatusList = new ArrayList<MmMasRequestStatus>();
		Session session = (Session) getSession();
		/*
		 * phAtpJphnJhiHeaderList =
		 * session.createCriteria(PhAtpJphnJhiHeader.class) .list();
		 */
		Integer[] id = { 2, 6 };
		phAtpJphnJhiHeaderList = session
				.createCriteria(PhAtpJphnJhiHeader.class)
				.createAlias("AshaWorker", "aw")
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("aw.Id"))
								.add(Projections.property("aw.FirstName"))
								.add(Projections.groupProperty("aw.Id"))
								.add(Projections.groupProperty("aw.FirstName")))
				.list();
		
		phDayBlockList = session.createCriteria(PhDayBlock.class).list();
		mmMasRequestStatusList = session
				.createCriteria(MmMasRequestStatus.class)
				.add(Restrictions.in("Id", id)).list();
		map.put("phAtpJphnJhiHeaderList", phAtpJphnJhiHeaderList);
		map.put("phDayBlockList", phDayBlockList);
		map.put("mmMasRequestStatusList", mmMasRequestStatusList);
		/*for (int i = 0; i < phAtpJphnJhiHeaderList.size(); i++) {
			System.out.println(phAtpJphnJhiHeaderList.get(i) + "" + i);
		}*/

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAtpJphnJhiDetail(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
		List<PhAtpJphnJhiDetails> phAtpJphnJhiDetailsObjList = new ArrayList<PhAtpJphnJhiDetails>();
		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
		List<MmMasRequestStatus> mmMasRequestStatusList = new ArrayList<MmMasRequestStatus>();
		Session session = (Session) getSession();
		int atpHeaderId = 0;
		if (detailsMap.get("atpHeaderId") != null) {
			atpHeaderId = (Integer) detailsMap.get("atpHeaderId");
		}

		Integer[] id = { 2, 6 };
		/*
		 * phAtpJphnJhiDetailsList =
		 * session.createCriteria(PhAtpJphnJhiDetails.class
		 * ).createAlias("PendingDayBlock",
		 * "pdb").createAlias("pdb.PhDayBlockDetails", "pdbd")
		 * .createAlias("pdbd.Survey", "psu").createAlias("psu.Locality",
		 * "ploc").createAlias("psu.Ward", "pw") .createAlias("DayBlock",
		 * "db").createAlias("db.PhDayBlockDetails", "dbd")
		 * .createAlias("dbd.Survey", "su").createAlias("su.Locality",
		 * "loc").createAlias("su.Ward", "w") .createAlias("AtpHeader", "ah")
		 * .createAlias("ah.AshaWorker","e") //.add(Restrictions.eq("e.Id",
		 * detailsMap.get("empId"))) .add(Restrictions.eq("ah.Id", atpHeaderId))
		 * .setProjection(Projections.projectionList().add(Projections.property(
		 * "DateAtp"))
		 * .add(Projections.groupProperty("pdb.ForDay")).add(Projections
		 * .count("psu.Id"
		 * )).add(Projections.count("ploc.Id")).add(Projections.count("pw.Id"))
		 * .
		 * add(Projections.groupProperty("db.ForDay")).add(Projections.count("su.Id"
		 * )).add(Projections.count("loc.Id")).add(Projections.count("w.Id"))
		 * .add(Projections.property("RoutineActivity"))
		 * .add(Projections.property("OtherActivity"))
		 * .add(Projections.property("AfterNoonActivity"))
		 * .add(Projections.property("Remarks"))
		 * .add(Projections.property("ah.Remarks"))
		 * .add(Projections.property("ah.Id")) .add(Projections.property("Id"))
		 * .add(Projections.property("Supervision"))
		 * .add(Projections.groupProperty
		 * ("DateAtp")).add(Projections.groupProperty
		 * ("psu.Id")).add(Projections.
		 * groupProperty("ploc.Id")).add(Projections.groupProperty("pw.Id"))
		 * .add
		 * (Projections.groupProperty("su.Id")).add(Projections.groupProperty
		 * ("loc.Id")).add(Projections.groupProperty("w.Id"))
		 * .add(Projections.groupProperty("RoutineActivity"))
		 * .add(Projections.groupProperty("OtherActivity"))
		 * .add(Projections.groupProperty("AfterNoonActivity"))
		 * .add(Projections.groupProperty("Remarks"))
		 * .add(Projections.groupProperty("ah.Remarks"))
		 * .add(Projections.groupProperty("ah.Id"))
		 * .add(Projections.groupProperty("Id"))
		 * .add(Projections.groupProperty("Supervision")) ) .list();
		 */
		/*
		 * String qry=
		 * "select pajjd.date_atp,pdb.for_day,COUNT(dbd.survey_id),count(dbd.ward_id),COUNT(dbd.locality_id) from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id "
		 * +
		 * "LEFT OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id "
		 * +
		 * "LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id where pajjh.atp_header_id= '"
		 * + atpHeaderId + "' group by pajjd.date_atp,pdb.for_day;";
		 */
		// String
		// qry="select x.A1,X.A2,X.A3,X.A4,X.A5,X.B2,X.B3,X.B4,X.B5,X.A6,X.A7,X.A8,X.A10,X.A9,X.B6,X.B7,X.B8,X.B10,X.B9,A11,A12,B11,B12,A13,A14 FROM ((select pajjd.day_block_id AS A0,pajjd.date_atp as A1,pdb.for_day AS A2,COUNT(dbd.survey_id) AS A3,count(dbd.locality_id) AS A4,COUNT(dbd.ward_id) AS A5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS A6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS A7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS A8,(case when(pajjd.supervision) ='c' then 'c' else 'Not Given' end) AS A9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS A10,pajjd.atp_details_id as A11,pajjd.atp_header_id as A12,(case when(pajjh.remarks) !='' then pajjh.remarks else 'Not Given' end) as A13,mstatus.status_id as A14 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id LEFT OUTER JOIN mm_mas_request_status mstatus ON mstatus.status_id=pajjh.status where pajjh.asha_worker="+
		// atpHeaderId +
		// "   group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks,pajjd.atp_details_id,pajjd.atp_header_id,pajjh.remarks,mstatus.status_id)a left outer join (select pajjd.day_block_id AS B0,pajjd.date_atp AS B1,pdb.for_day AS B2,COUNT(dbd.survey_id) AS B3,count(dbd.locality_id) AS B4,COUNT(dbd.ward_id) B5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS B6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS B7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS B8,(case when(pajjd.supervision) ='c' then 'c' else 'Not Given' end) AS B9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS B10,pajjd.atp_details_id as B11,pajjd.atp_header_id as B12 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id LEFT OUTER JOIN mm_mas_request_status mstatus ON mstatus.status_id=pajjh.status where pajjh.asha_worker="+atpHeaderId
		// +
		// " group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks,pajjd.atp_details_id,pajjd.atp_header_id)b on a.A0=b.B0)x;";
		// String
		// qry="select pdb.day_id,ajjh.atp_header_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id),ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker where ajjh.asha_worker ="+
		// atpHeaderId
		// +" group by pdb.day_id,ajjh.atp_header_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity";
		String qry = "select ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id), ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker where ajjh.asha_worker="
				+ atpHeaderId + " and ajjh.status is null"
				+ "  group by ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name, ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity";

		phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();

		/*
		 * phAtpJphnJhiDetailsObjList =
		 * session.createCriteria(PhAtpJphnJhiDetails.class)
		 * .createAlias("AtpHeader","e") //.add(Restrictions.eq("e.Id",
		 * atpHeaderId)) .createAlias("e.AshaWorker","a")
		 * .add(Restrictions.eq("a.Id",atpHeaderId)) .list();
		 */
		phDayBlockList = session.createCriteria(PhDayBlock.class).list();

		mmMasRequestStatusList = session
				.createCriteria(MmMasRequestStatus.class)
				.add(Restrictions.in("Id", id)).list();

		map.put("phDayBlockList", phDayBlockList);
		map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);
		map.put("mmMasRequestStatusList", mmMasRequestStatusList);
		// map.put("phAtpJphnJhiDetailsObjList", phAtpJphnJhiDetailsObjList);

		return map;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> submitAtpJphnJhiApproval(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();

			/*
			 * MasEmployee masEmployee = new MasEmployee();
			 * masEmployee.setId(box.getInt("empId"));
			 * phAtpJphnJhiHeader.setAshaWorker(masEmployee);
			 * 
			 * MasHospital hospital = new MasHospital();
			 * hospital.setId(box.getInt("hospitalId"));
			 * phAtpJphnJhiHeader.setHospital(hospital);
			 */

			Vector detId = box.getVector("detId");
			Vector headerId = box.getVector("hdrId");
			Vector supervision = box.getVector("supervision");
			for (int i = 0; i < detId.size(); i++) {
				PhAtpJphnJhiHeader phAtpJphnJhiHeader = (PhAtpJphnJhiHeader) hbt
						.load(PhAtpJphnJhiHeader.class,
								Integer.parseInt(headerId.get(i).toString()));
				if (phAtpJphnJhiHeader != null
						&& phAtpJphnJhiHeader.getApprovedBy() == null) {
					phAtpJphnJhiHeader.setRemarks(box.getString("remarksHdr"));

					MasEmployee masEmployee2 = new MasEmployee();
					masEmployee2.setId(box.getInt("empId"));
					phAtpJphnJhiHeader.setApprovedBy(masEmployee2);

					MmMasRequestStatus mmMasRequestStatus = new MmMasRequestStatus();
					if (box.getInt("appStatus") != 0) {
						mmMasRequestStatus.setId(box.getInt("appStatus"));
						phAtpJphnJhiHeader.setStatus(mmMasRequestStatus);
					}
					/*
					 * Users user = new Users();
					 * user.setId(box.getInt("changedBy"));
					 * phAtpJphnJhiHeader.setLastChgBy(user);
					 * 
					 * phAtpJphnJhiHeader.setLastChgDate(HMSUtil.
					 * convertStringTypeDateToDateType
					 * (box.getString(CHANGED_DATE)));
					 * phAtpJphnJhiHeader.setLastChgTime
					 * (box.getString(CHANGED_TIME));
					 */

					hbt.update(phAtpJphnJhiHeader);
				}

				PhAtpJphnJhiDetails PhAtpJphnJhi = new PhAtpJphnJhiDetails();
				if (detId.get(i) != null && !detId.get(i).equals("")) {

					int vId = Integer.parseInt(detId.get(i).toString());
					PhAtpJphnJhi = (PhAtpJphnJhiDetails) getHibernateTemplate()
							.load(PhAtpJphnJhiDetails.class, vId);

					// PhAtpJphnJhi.setAtpHeader(phAtpJphnJhiHeader);

					if (supervision.get(i) != null
							&& !supervision.get(i).equals("")) {
						PhAtpJphnJhi
								.setSupervision((String) supervision.get(i));
					}

					hbt.update(PhAtpJphnJhi);

				}
			}
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		phDayBlockList = session.createCriteria(PhDayBlock.class)
		// .add(Restrictions.eq("Status", "y").ignoreCase())
				.list();
		paramMap.put("hospitalId", box.getInt("hospitalId"));
		map.put("saved", saved);
		map.put("phDayBlockList", phDayBlockList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showSchoolAnganwadiRegistrationJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
		// List<PhMasLocality> phMasLocalityList = new
		// ArrayList<PhMasLocality>();
		List<Object> phMasLocalityList = new ArrayList<Object>();
		Session session = (Session) getSession();
		int hospitalId = box.getInt("hospitalId");
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		try {

			postCodeList = session.createCriteria(MasPostCode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			phMasLocalityList = session
					.createCriteria(LocationParameterMapping.class)
					.add(Restrictions.eq("Hospital.Id",	box.getInt("hospitalId")))
					.add(Restrictions.eq("LastChgBy.Id", box.getInt("userId")))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Locality", "l")
					.addOrder(Order.asc("l.LocalityName"))
					// .setProjection(Projections.distinct(Projections.property("l.Id"))).list();
					.setProjection(
							Projections
									.projectionList()
									.add(Projections.groupProperty("l.Id"))
									.add(Projections.property("l.LocalityName")))
					.list();
			// phMasLocalityList =
			// session.createCriteria(PhMasLocality.class).add(Restrictions.eq("Status",
			// "y").ignoreCase()).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("postCodeList", postCodeList);
		map.put("phMasLocalityList", phMasLocalityList);
		return map;

	}

	@Override
	public Map<String, Object> submitSchoolAnganwadiRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			PhVillageSurvey phVillageSurvey = (PhVillageSurvey) hbt.load(
					PhVillageSurvey.class, box.getInt("survey"));

			if (!box.getString("facilitiesAvailables").equals("")) {
				phVillageSurvey.setFacilityAvaliable(box
						.getString("facilitiesAvailables"));
			}

			hbt.update(phVillageSurvey);

			List<PhClassDetails> pdList = new ArrayList<PhClassDetails>();
			pdList = session.createCriteria(PhClassDetails.class)
					.createAlias("Survey", "d")
					.add(Restrictions.eq("d.Id", box.getInt("survey"))).list();

			/*
			 * System.out.println(pdList.size()+" Class List ");
			 * if(pdList.size()>0){ hbt.deleteAll(pdList); }
			 */

			int counter = box.getInt("hiddenValueCharge");
			for (int i = 1; i <= counter; ++i) {

				int classId = 0;
				classId = box.getInt("classId" + i);
				
				if (classId != 0) {
					PhClassDetails phClassDetails = (PhClassDetails) hbt.load(
							PhClassDetails.class, classId);
					if (!box.getString("class" + i).equals("")) {

						phClassDetails.setSurvey(phVillageSurvey);

						phClassDetails.setSchoolClass(box
								.getString("class" + i));

						if (!box.getString("section" + i).equals("")) {
							phClassDetails.setSchoolSection(box
									.getString("section" + i));
						}
						hbt.update(phClassDetails);
					}
				} else {
					PhClassDetails phClassDetails = new PhClassDetails();
					if (!box.getString("class" + i).equals("")) {

						phClassDetails.setSurvey(phVillageSurvey);

						phClassDetails.setSchoolClass(box
								.getString("class" + i));

						if (!box.getString("section" + i).equals("")) {
							phClassDetails.setSchoolSection(box
									.getString("section" + i));
						}
						hbt.save(phClassDetails);
					}
				}

			}
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		map.put("saved", saved);

		return map;
	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getNameList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhVillageSurvey> phVillageSurveyList = new ArrayList<PhVillageSurvey>();
		Session session = (Session) getSession();

		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int localityId = 0;
		int schoolTypeVal = 0;
		long hospitalId = 0;

		try {

			
			if (dataMap.get("localityId") != null) { 
				localityId = (Integer) dataMap.get("localityId"); }
			 
			if (dataMap.get("hospitalId") != null) {
				hospitalId = (Long) dataMap.get("hospitalId");
			}
			if (dataMap.get("schoolTypeVal") != null) {
				schoolTypeVal = (Integer) dataMap.get("schoolTypeVal");
			}
			logger.info("schoolTypeVal=11=" + schoolTypeVal);
			if (schoolTypeVal != 0) {
				phVillageSurveyList = session
						.createCriteria(PhVillageSurvey.class)
						.createAlias("Locality", "l")
						.add(Restrictions.eq("HospitalId", hospitalId))
						// .createAlias("PhMasOrgCategory", "q")
						.add(Restrictions.eq("l.Id", localityId))
						.add(Restrictions.eq("SurveyType", schoolTypeVal))
						.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("phVillageSurveyList", phVillageSurveyList);
		map.put("localityIdMap", localityId);

		map.put("schoolTypeMap", schoolTypeVal);
		return map;

	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getNameDetailList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhVillageSurvey> phVillageSurveyDataList = new ArrayList<PhVillageSurvey>();
		Session session = (Session) getSession();
		List<PhClassDetails> phClassDetailsList = new ArrayList<PhClassDetails>();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int villageSurveyId = 0;
		int localityIdMap = 0;
		int schoolTypeMap = 0;
		try {

			if (dataMap.get("localityIdMap") != null) {
				localityIdMap = (Integer) dataMap.get("localityIdMap");
			}
			if (dataMap.get("villageSurveyId") != null) {
				villageSurveyId = (Integer) dataMap.get("villageSurveyId");
			}
			if (villageSurveyId != 0) {
				phVillageSurveyDataList = session
						.createCriteria(PhVillageSurvey.class)
						.add(Restrictions.eq("Id", villageSurveyId)).list();

				phClassDetailsList = session
						.createCriteria(PhClassDetails.class)
						.add(Restrictions.eq("Survey.Id", villageSurveyId))
						.list();

			}

			/*
			 * List<String> facilitiesAvailableList =
			 * session.createCriteria(PhVillageSurvey.class)
			 * .add(Restrictions.eq("Id",villageSurveyId)) .list();
			 */

			/*
			 * List<String> fidList = new ArrayList<String>();
			 * 
			 * 
			 * PhVillageSurvey phVillageSurvey= new PhVillageSurvey();
			 * 
			 * if(phVillageSurveyDataList.size() > 0){ phVillageSurvey =
			 * (PhVillageSurvey) phVillageSurveyDataList.get(0);
			 * 
			 * String fIds = phVillageSurvey.getFacilityAvaliable();
			 * 
			 * String[] faId = fIds.split(",");
			 * 
			 * 
			 * for (int i = 0; i < faId.length; i++) {
			 * 
			 * fidList.add((faId[i].trim())); } List<PhVillageSurvey>
			 * facilitiesAvailableDataList =
			 * session.createCriteria(PhVillageSurvey.class)
			 * .add(Restrictions.eq("Id", villageSurveyId))
			 * .add(Restrictions.eq("FacilityAvaliable", fIds)).list();
			 * 
			 * map.put("facilitiesAvailableDataList",
			 * facilitiesAvailableDataList);
			 * 
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("phClassDetailsList", phClassDetailsList);
		map.put("phVillageSurveyDataList", phVillageSurveyDataList);
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showStudentRegistrationJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		List<MasBloodGroup> bloodGrpList = new ArrayList<MasBloodGroup>();
		List<PhVillageSurvey> schoolList = new ArrayList<PhVillageSurvey>();
		List<PhVillageSurvey> anganwadiList = new ArrayList<PhVillageSurvey>();
		int s = 1002;
		int a = 1001;

		genderList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		bloodGrpList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y")).list();
		schoolList = session.createCriteria(PhVillageSurvey.class)
				.add(Restrictions.eq("HospitalId", box.getLong("hospitalId")))
				.add(Restrictions.eq("SurveyType", s)).list();
		anganwadiList = session.createCriteria(PhVillageSurvey.class)
				.add(Restrictions.eq("HospitalId", box.getLong("hospitalId")))
				.add(Restrictions.eq("SurveyType", a)).list();

		map.put("genderList", genderList);
		map.put("bloodGrpList", bloodGrpList);
		map.put("schoolList", schoolList);
		map.put("anganwadiList", anganwadiList);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		return map;
	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getAnganwadiNameList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> phClassDetailsList = new ArrayList<String>();
		Session session = (Session) getSession();

		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int surveyId = 0;

		try {

			if (dataMap.get("surveyId") != null) {
				surveyId = (Integer) dataMap.get("surveyId");
			}

			if (surveyId != 0) {
				phClassDetailsList = session
						.createCriteria(PhClassDetails.class)
						.createAlias("Survey", "s")
						.add(Restrictions.eq("s.Id", surveyId))
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
												.property("SchoolClass"))))
						.list();

				/*
				 * String qry =
				 * "select DISTINCT(school_class) from ph_class_details where survey_id='"
				 * + surveyId+ "'";
				 * 
				 * phClassDetailsList = (List)
				 * session.createSQLQuery(qry).list();
				 * 
				 * 
				 * 
				 * phClassDetailsList=getHibernateTemplate().find(
				 * "SELECT  DISTINCT SchoolClass FROM PhClassDetails as cd join cd.Survey as su where su.Id="
				 * +surveyId);
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("phClassDetailsList", phClassDetailsList);
		map.put("surveyIdMap", surveyId);
		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> populateSection(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String classId = "";
			int surveyIdMap = 0;
			classId = (String) dataMap.get("classId");
			surveyIdMap = (Integer) dataMap.get("surveyIdMap");
			List<PhClassDetails> phClassDetailsSectionList = new ArrayList<PhClassDetails>();
			Session session = (Session) getSession();
			phClassDetailsSectionList = (List<PhClassDetails>) session
					.createCriteria(PhClassDetails.class)
					.createAlias("Survey", "s")
					.add(Restrictions.eq("s.Id", surveyIdMap))
					.add(Restrictions.eq("SchoolClass", classId)).list();
			map.put("phClassDetailsSectionList", phClassDetailsSectionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getMemberSurveyList(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String studentName = "";
			int genderIdSearch = 0;
			Long uhid = new Long(0);
			uhid = (Long) dataMap.get("uhid");
			studentName = (String) dataMap.get("studentName");
			int age = (Integer) dataMap.get("age");
			genderIdSearch = (Integer) dataMap.get("genderIdSearch");
			List<PhMemberSurvey> phMemberSurveyList = new ArrayList<PhMemberSurvey>();
			Session session = (Session) getSession();
			Criteria criteria = null;

			criteria = session.createCriteria(PhMemberSurvey.class);
			if (studentName != "" && studentName != null) {
				criteria.add(Restrictions.like("Name", "%" + studentName + "%")
						.ignoreCase());
			}
			if (genderIdSearch != 0) {
				criteria.createAlias("Gender", "s").add(
						Restrictions.eq("s.Id", genderIdSearch));
			}
			if (uhid != 0) {
				criteria.add(Restrictions.eq("AadhaarNo", uhid));
			}
			if (age != 0) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal1 = Calendar.getInstance();
				Calendar cal2 = Calendar.getInstance();
				cal1.add(Calendar.YEAR, -age);
				cal2.add(Calendar.MONTH, -12);
				criteria.add(Restrictions.and(Restrictions.ge("DateOfBirth",
						HMSUtil.convertStringTypeDateToDateType(dateFormat
								.format(cal1.getTime()))), Restrictions.le(
						"DateOfBirth", HMSUtil
								.convertStringTypeDateToDateType(dateFormat
										.format(cal2.getTime())))));
			}

			phMemberSurveyList = criteria.list();
			map.put("phMemberSurveyList", phMemberSurveyList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getValueMemberSurvey(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			int memberSurveyId = 0;
			long hospitalId = 0;
			hospitalId = (Long) dataMap.get("hospitalId");
			memberSurveyId = (Integer) dataMap.get("memberSurveyId");
			List<PhMemberSurvey> phMemberSurveyValueList = new ArrayList<PhMemberSurvey>();
			Session session = (Session) getSession();
			Criteria criteria = null;

			criteria = session.createCriteria(PhMemberSurvey.class);
			if (memberSurveyId != 0) {
				criteria = session.createCriteria(PhMemberSurvey.class).add(
						Restrictions.eq("Id", memberSurveyId));
			}

			phMemberSurveyValueList = criteria.list();

			map.put("phMemberSurveyValueList", phMemberSurveyValueList);

			List<PhStudentRegistration> phStudentRegistrationList = new ArrayList<PhStudentRegistration>();

			if (memberSurveyId != 0) {
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "m")
						.add(Restrictions.eq("m.Id", memberSurveyId));
			}
			phStudentRegistrationList = criteria.list();
			map.put("phStudentRegistrationList", phStudentRegistrationList);

			List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
			List<MasBloodGroup> bloodGrpList = new ArrayList<MasBloodGroup>();
			List<PhVillageSurvey> schoolList = new ArrayList<PhVillageSurvey>();
			List<PhVillageSurvey> anganwadiList = new ArrayList<PhVillageSurvey>();
			List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
			List<PhClassDetails> classList = new ArrayList<PhClassDetails>();
			List<MasRelation> relationList = new ArrayList<MasRelation>();
			String[] relName = { "Son", "Daughter", "PSO", "Brother", "Friend" };
			int s = 1002;
			int a = 1001;
			classList = session.createCriteria(PhClassDetails.class).list();
			genderList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			bloodGrpList = session.createCriteria(MasBloodGroup.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			schoolList = session.createCriteria(PhVillageSurvey.class)
					.add(Restrictions.eq("HospitalId", hospitalId))
					.add(Restrictions.eq("SurveyType", s)).list();
			
			logger.info(schoolList.size() + "----------schoolList");
			anganwadiList = session.createCriteria(PhVillageSurvey.class)
					.add(Restrictions.eq("HospitalId", hospitalId))
					.add(Restrictions.eq("SurveyType", a)).list();
			occupationList = session.createCriteria(MasOccupation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.in("RelationName", relName))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			map.put("genderList", genderList);
			map.put("bloodGrpList", bloodGrpList);
			map.put("schoolList", schoolList);
			map.put("anganwadiList", anganwadiList);
			map.put("occupationList", occupationList);
			map.put("relationList", relationList);
			map.put("classList", classList);
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			return map;

		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	public Map<String, Object> uploadExcel(Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		return map;
	}

	@SuppressWarnings({ "resource", "unchecked", "unchecked", "unchecked" })
	public Map<String, Object> addorUpdateStudentRescord(
			Map<String, Object> infoMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String fileExtension = null;
		File file = null;
		String filename = "";
		if (infoMap.get("filename") != null) {
			filename = (String) infoMap.get("filename");
		}
		String uploadURL = "";
		if (infoMap.get("uploadURL") != null) {
			uploadURL = (String) infoMap.get("uploadURL");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String fileSeparator = System.getProperty("file.separator");

		try {/*
			 * HibernateTemplate hbt = getHibernateTemplate();
			 * 
			 * hbt.setCheckWriteOperations(false);
			 */
			file = new File(uploadURL + fileSeparator + filename);
			logger.info("uploadURL  final---->"+ (uploadURL + fileSeparator + filename));
			
			FileInputStream is = new FileInputStream(uploadURL + fileSeparator
					+ filename);
			/*
			 * long length = file.length(); // ByteBuffer byteBuff=null; // int
			 * modLength=length/ if (length > Integer.MAX_VALUE) { // File is
			 * too large } // Create the byte array to hold the data byte[]
			 * bytes = new byte[(int) length]; int offset = 0; int numRead = 0;
			 * while (offset < bytes.length && (numRead = is.read(bytes, offset,
			 * bytes.length - offset)) >= 0) { offset += numRead; }
			 * 
			 * if (offset < bytes.length) { throw new
			 * IOException("Could not completely read file " + file.getName());
			 * 
			 * }
			 */

			// Close the input stream and return bytes
			// StringTokenizer strToken = new StringTokenizer(filename, ".");
			HSSFWorkbook workbook = new HSSFWorkbook(is);

			HSSFSheet worksheet = workbook.getSheet("Student Register");
			for (int i = 6; i <= 65000; i++) {
				HSSFRow row1 = worksheet.getRow(i);
				if (worksheet.getRow(i) != null
						&& !worksheet.getRow(i).equals("")) {
					HSSFCell cellA1 = null;
					if (row1.getCell((short) 0) != null) {
						cellA1 = row1.getCell((short) 0);
					}

					int a1Val = 0;
					if (cellA1 != null && cellA1.getNumericCellValue() != 0) {
						a1Val = (int) cellA1.getNumericCellValue();
					}

					HSSFCell cellB1 = null;
					if (row1.getCell((short) 1) != null
							&& !row1.getCell((short) 1).equals("")) {
						cellB1 = row1.getCell((short) 1);
					}
					String b1Val = "";
					if (cellB1 != null && cellB1.getStringCellValue() != null) {
						b1Val = cellB1.getStringCellValue();
					}
					/*
					 * HSSFCell cellC1 = null;
					 * 
					 * if (row1.getCell((short) 2) != null &&
					 * !row1.getCell((short) 2).equals("")) { cellC1 =
					 * row1.getCell((short) 2); } String c1Val = ""; if (cellC1
					 * != null && cellC1.getStringCellValue() != null) { c1Val =
					 * "" + cellC1.getStringCellValue(); }
					 */
					HSSFCell cellD1 = null;
					if (row1.getCell((short) 2) != null
							&& !row1.getCell((short) 2).equals("")) {
						cellD1 = row1.getCell((short) 2);
					}
					String d1Val = "";
					if (cellD1 != null && cellD1.getStringCellValue() != null) {
						d1Val = cellD1.getStringCellValue();
					}
					HSSFCell cellE1 = null;
					if (row1.getCell((short) 3) != null
							&& !row1.getCell((short) 3).equals("")) {

						cellE1 = row1.getCell((short) 3);
					}

					String e1Val = "";
					if (cellE1 != null && cellE1.getStringCellValue() != null) {
						e1Val = cellE1.getStringCellValue();
					}
					HSSFCell cellF1 = null;
					if (row1.getCell((short) 4) != null
							&& !row1.getCell((short) 4).equals("")) {
						cellF1 = row1.getCell((short) 4);
					}
					String f1Val = "";
					if (cellF1 != null && cellF1.getStringCellValue() != null) {
						f1Val = cellF1.getStringCellValue();
					}
					/*
					 * HSSFCell cellG1 = null; if (row1.getCell((short) 6) !=
					 * null && !row1.getCell((short) 6).equals("")) { cellG1 =
					 * row1.getCell((short) 6); } String g1Val = ""; if (cellG1
					 * != null && cellG1.getStringCellValue() != null) { g1Val =
					 * cellG1.getStringCellValue(); }
					 */
					HSSFCell cellH1 = null;
					if (row1.getCell((short) 5) != null
							&& !row1.getCell((short) 5).equals("")) {
						cellH1 = row1.getCell((short) 5);
					}
					String h1Val = "";
					if (cellH1 != null && cellH1.getStringCellValue() != null) {
						h1Val = cellH1.getStringCellValue();
					}
					HSSFCell cellI1 = null;
					if (row1.getCell((short) 6) != null
							&& !row1.getCell((short) 6).equals("")) {
						cellI1 = row1.getCell((short) 6);
					}
					String i1Val = "";
					if (cellI1 != null && cellI1.getStringCellValue() != null) {
						i1Val = cellI1.getStringCellValue();
					}
					HSSFCell cellJ1 = null;
					if (row1.getCell((short) 7) != null
							&& !row1.getCell((short) 7).equals("")) {
						cellJ1 = row1.getCell((short) 7);
					}
					String j1Val = "";
					if (cellJ1 != null && cellJ1.getStringCellValue() != null) {
						j1Val = cellJ1.getStringCellValue();
					}
					/*
					 * HSSFCell cellK1 = null; if (row1.getCell((short) 10) !=
					 * null && !row1.getCell((short) 10).equals("")) { cellK1 =
					 * row1.getCell((short) 10); } String k1Val = ""; if (cellK1
					 * != null && cellK1.getStringCellValue() != null) { k1Val =
					 * cellK1.getStringCellValue(); }
					 */
					HSSFCell cellL1 = null;
					if (row1.getCell((short) 8) != null
							&& !row1.getCell((short) 8).equals("")) {
						cellL1 = row1.getCell((short) 8);
					}
					String l1Val = "";
					if (cellL1 != null && cellL1.getStringCellValue() != null) {
						l1Val = cellL1.getStringCellValue();
					}
					/*
					 * HSSFCell cellM1 = null; if (row1.getCell((short) 9) !=
					 * null && !row1.getCell((short) 9).equals("")) { cellM1 =
					 * row1.getCell((short) 9); } String m1Val = ""; if (cellM1
					 * != null && cellM1.getStringCellValue() != null) { m1Val =
					 * cellM1.getStringCellValue(); } HSSFCell cellN1 = null; if
					 * (row1.getCell((short) 13) != null &&
					 * !row1.getCell((short) 13).equals("")) {
					 * row1.getCell((short) 13); } String n1Val = ""; if (cellN1
					 * != null && cellN1.getStringCellValue() != null) { n1Val =
					 * cellN1.getStringCellValue(); } HSSFCell cellO1 = null; if
					 * (row1.getCell((short) 14) != null &&
					 * !row1.getCell((short) 14).equals("")) { cellO1 =
					 * row1.getCell((short) 14); } String o1Val = ""; if (cellO1
					 * != null && cellO1.getStringCellValue() != null) { o1Val =
					 * cellO1.getStringCellValue(); }
					 */
					HSSFCell cellP1 = null;
					if (row1.getCell((short) 9) != null
							&& !row1.getCell((short) 9).equals("")) {
						cellP1 = row1.getCell((short) 9);
					}

					String p1Val = "";
					if (cellP1 != null && cellP1.getStringCellValue() != null) {
						p1Val = cellP1.getStringCellValue();
					}
					HSSFCell cellQ1 = null;
					if (row1.getCell((short) 10) != null
							&& !row1.getCell((short) 10).equals("")) {
						cellQ1 = row1.getCell((short) 10);
					}

					String q1Val = "";
					if (cellQ1 != null && cellQ1.getStringCellValue() != null) {
						q1Val = cellQ1.getStringCellValue();
					}
					/*
					 * HSSFCell cellR1 = null; if (row1.getCell((short) 11) !=
					 * null && !row1.getCell((short) 11).equals("")) { cellR1 =
					 * row1.getCell((short) 11); } String r1Val = ""; if (cellR1
					 * != null && cellR1.getStringCellValue() != null) { r1Val =
					 * cellR1.getStringCellValue(); }
					 * 
					 * HSSFCell cellS1 = null; if (row1.getCell((short) 18) !=
					 * null && !row1.getCell((short) 18).equals("")) { cellS1 =
					 * row1.getCell((short) 18); } double s1Val = 0; if (cellS1
					 * != null && cellS1.getNumericCellValue() != 0) { s1Val =
					 * cellS1.getNumericCellValue();
					 * 
					 * } System.out.println("s1Val--->" + s1Val); int s1Val1 =
					 * (int) s1Val; HSSFCell cellT1 = null; if
					 * (row1.getCell((short) 19) != null &&
					 * !row1.getCell((short) 19).equals("")) { cellT1 =
					 * row1.getCell((short) 19); } double t1Val = 0; if (cellT1
					 * != null && cellT1.getNumericCellValue() != 0) { t1Val =
					 * cellT1.getNumericCellValue(); }
					 * 
					 * int t1Val1 = (int) t1Val;
					 */
					logger.info("Id: " + a1Val + "School Name: " + b1Val + "Standard: " + d1Val + "Division: " + e1Val);
					logger.info("DOB: " + f1Val +"Student Name: " + h1Val + "Father Name: " + i1Val +"Mother Name: " + j1Val);
					logger.info("Gender: " + l1Val +"Address: " + p1Val +"Age: " + q1Val);
					
				
					int studentId = 0;
					/*
					 * String[] a=a1Val.split(".");
					 * studentId=Integer.parseInt(""+a[0]);
					 */

					String item1[] = b1Val.split("\\[");
					String item11[] = item1[1].split("]");
					String item111 = item11[0];
					logger.info("itemId" +item111);;
					
					Session session = (Session) getSession();
					
					List<PhStudentRegistration> studentList = new ArrayList<PhStudentRegistration>();
					studentList = session.createCriteria(PhStudentRegistration.class)
							.add(Restrictions.eq("Id", a1Val))
							// .add(Restrictions.ne("AcademicYear.Id",
							// academicYearId))
							.list();

					// if(r1Val!=academicYear){
					if (studentList.size() > 0) {

						for (PhStudentRegistration student : studentList) {

						}
					}

					// }
					else {
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> submitStudentRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		int studentId = box.getInt("studentId");
		try {
			tx = session.beginTransaction();
			PhStudentRegistration phStudentRegistration = new PhStudentRegistration();
			
			if (studentId != 0) {
				phStudentRegistration = (PhStudentRegistration) hbt.load(
						PhStudentRegistration.class, studentId);
			}
			logger.info(box.getInt("classIdSection") + " class section" +box.getInt("classIdDivision")
					+ " class Division");
			
			PhClassDetails phClassDetails = new PhClassDetails();
			if (box.getInt("classIdSection") != 0) {
				phClassDetails.setId(box.getInt("classIdSection"));
				phStudentRegistration.setClassdetails(phClassDetails);
			}
			if (box.getInt("classIdDivision") != 0) {
				phClassDetails.setId(box.getInt("classIdDivision"));
				phStudentRegistration.setClassdetails(phClassDetails);
			}
			if (box.getString("joiningDateIdSection") != "") {
				phStudentRegistration.setJoiningdate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("joiningDateIdSection")));
			}
			if (box.getString("joiningDateIdDivision") != "") {
				phStudentRegistration.setJoiningdate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("joiningDateIdDivision")));
			}
			if (box.getString("admissionNoDivision") != "") {
				phStudentRegistration.setAdmissionNo((box
						.getString("admissionNoDivision")));
			}
			if (box.getString("admissionNoSection") != "") {
				phStudentRegistration.setAdmissionNo((box
						.getString("admissionNoSection")));
			}

			if (box.getInt("hospitalId") != 0) {
				MasHospital masHospital = new MasHospital();
				masHospital.setId(box.getInt("hospitalId"));
				phStudentRegistration.setHospital(masHospital);
			}

			if (box.getInt("memberSurveyId") != 0) {
				PhMemberSurvey phMemberSurvey = new PhMemberSurvey();
				phMemberSurvey.setId(box.getInt("memberSurveyId"));
				phStudentRegistration.setMembersurvey(phMemberSurvey);
			}
			if (box.getInt("occupationMother") != 0) {
				MasOccupation masOccupationMother = new MasOccupation();
				masOccupationMother.setId(box.getInt("occupationMother"));
				phStudentRegistration.setOccupationMother(masOccupationMother);
			}

			if (box.getInt("occupationFather") != 0) {
				MasOccupation masOccupationFather = new MasOccupation();
				masOccupationFather.setId(box.getInt("occupationFather"));
				phStudentRegistration.setOccupationFather(masOccupationFather);
			}

			phStudentRegistration.setMotherName(box.getString("motherName"));

			phStudentRegistration.setFatherName(box.getString("fatherName"));

			phStudentRegistration.setEducationStatusMother(box
					.getString("educationStatusMother"));

			phStudentRegistration.setEducationStatusFather(box
					.getString("educationStatusFather"));

			phStudentRegistration.setContactNoFather(box
					.getString("contactNoFather"));

			phStudentRegistration.setContactNoMother(box
					.getString("contactNoMother"));

			phStudentRegistration.setIdentificationMarkOne(box
					.getString("IdentificationMarkOne"));
			phStudentRegistration.setIdentificationMarkTwo(box
					.getString("IdentificationMarkTwo"));

			phStudentRegistration.setAddress(box.getString("address"));

			phStudentRegistration.setNameOfSiblings(box
					.getString("nameOfSiblings"));

			phStudentRegistration.setBirthOrderOfThisChild(box
					.getString("birthOrderOfThisChild"));
			phStudentRegistration
					.setPlaceOfBirth(box.getString("placeOfBirth"));

			phStudentRegistration
					.setGuardianName(box.getString("guardianName"));
			phStudentRegistration.setGuardianContactno(box
					.getString("guardianContactNo"));
			phStudentRegistration.setGuardianAddress(box
					.getString("guardianAddress"));

			if (box.getInt("relationId") != 0) {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(box.getInt("relationId"));
				phStudentRegistration.setRelation(masRelation);
			}
			
			if (studentId != 0) {
				hbt.update(phStudentRegistration);
			} else {
				hbt.save(phStudentRegistration);
			}
			tx.commit();
			saved = true;

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> showImmunizationJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> subCenterList = new ArrayList<MasHospital>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		try {
			Session	 session=(Session)getSession();
			Transaction tx=session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<Visit> patientList = new ArrayList<Visit>();
			List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
			Date date = new Date();
			int searchFlag = 0, tokenNo = 0;
			String patientName = "";
			String uhid = "";
			int deptId = 0, immunCode = 0;
			int hospitalId=0;
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
			immunCode  = Integer.parseInt(properties.getProperty("empDeptCodeForImmu"));
			if(box.get("searchFlag")!=null){
				searchFlag = box.getInt("searchFlag");
			}
			if(box.get("tokenNo")!=null){
				tokenNo =box.getInt("tokenNo");
			}
			if(box.get("patientName")!=null){
				patientName =(String) box.get("patientName");
			}
			if(box.get("uhid")!=null){
				uhid =(String) box.get("uhid");
			}
			if (box.get("deptId") != null) {
				deptId = box.getInt("deptId");
			}
			if (box.get("hospitalId") != null) {
				hospitalId = Integer.parseInt(box.get("hospitalId"));
			}
			
			if(deptId == immunCode) {
				/*Criteria criteria= session.createCriteria(Visit.class)
						.createAlias("Department", "dept")
						.add(Restrictions.eq("VisitDate", date));*/
				Criteria criteria= session.createCriteria(Visit.class)
						.add(Restrictions.eq("VisitDate", new Date()))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.eq("VisitStatus", "w").ignoreCase())
						.add(Restrictions.eq("Status", "y").ignoreCase());
				if(searchFlag == 1) {
					criteria.createAlias("Hin", "hin");
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
				patientList = criteria.list();
			}

			departmentList=	session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.add(Restrictions.eq("DepartmentType.Id", 1))
					.addOrder(Order.asc("DepartmentName")).list();
			
			map.put("departmentList", departmentList);
			map.put("patientList", patientList);
			map.put("uhid", box.getString("uhid"));
			map.put("patientName", box.getString("patientName"));
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public Map<String, Object> searchImmunizationDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<PhMemberSurvey> immunizationList = new ArrayList<PhMemberSurvey>();
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		Session session = (Session) getSession();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -18);
		// Date backDate = calendar.getTime();
		Date dateOfBirth=null; // added by amit das on 18-10-2016
		
		
		Criteria crit = null;
		crit = session.createCriteria(Patient.class);

		if (!box.getString("aadharNo").trim().equals("")) {
			crit = crit
					.add(Restrictions.eq("HinNo", box.getString("aadharNo")));
		}
		if (!box.getString("patientName").trim().equalsIgnoreCase("")) {
			String patientName = (String) box.getString("patientName")
					+ "%";
			crit = crit.add(Restrictions.like("PFirstName",
					patientName));
		}
		
		// added by amit das on 18-10-2016
		if(box.getString("dob")!=null && !box.getString("dob").trim().equals("")){
		dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(box.getString("dob"));
		crit = crit
				.add(Restrictions.eq("DateOfBirth", dateOfBirth));
		}

		// added by amit das on 18-10-2016
		if (box.getInt("fromAge")!=0) {
			crit = crit
					.add(Restrictions.ge("PatientAge", box.getInt("fromAge")));
		}
		
		// added by amit das on 18-10-2016
		if (box.getInt("toAge")!=0) {
			crit = crit
					.add(Restrictions.le("PatientAge",box.getInt("toAge")));
		}
		
		
		// added by amit das on 18-10-2016
		if (box.getString("mobileNo")!=null && !box.getString("mobileNo").trim().equals("")) {
			crit = crit.add(Restrictions.eq("MobileNumber",box.getString("mobileNo")));
		}
		
		
		
		patientList = crit.list();
		map.put("patientList", patientList);
		if (patientList.size() == 0) {
			Criteria cr = session.createCriteria(PhMemberSurvey.class);
			// .add(Restrictions.ge("DateOfBirth", backDate))
			// .add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
			
			if (box.getLong("aadharNo") != 0) {
				cr = cr.add(Restrictions.eq("AadhaarNo",
						box.getLong("aadharNo")));
			}
			if (!box.getString("patientName").trim().equalsIgnoreCase("")) {
				String patientName = (String) box.getString("patientName")
						+ "%";
				cr = cr.add(Restrictions.like("Name", patientName).ignoreCase());
			}
			
			// added by amit das on 18-10-2016
			if (box.getString("mobileNo")!=null && !box.getString("mobileNo").trim().equals("")) {
				crit = crit.add(Restrictions.eq("ContactNo",box.getString("mobileNo")));
			}
			
			// added by amit das on 18-10-2016
			if(box.getString("dob")!=null && !box.getString("dob").trim().equals("")){
			crit = crit
					.add(Restrictions.eq("DateOfBirth", dateOfBirth));
			}
			
			immunizationList = cr.list();
			map.put("immunizationList", immunizationList);
		}
		map.put("aadharNo", box.getString("aadharNo"));
		map.put("patientName", box.getString("patientName"));
		map.put("dob", box.getString("dob"));
		map.put("fromAge", box.getInt("fromAge"));
		map.put("toAge", box.getInt("toAge"));
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showVaccineDetailJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session)getSession();
		List<OpdVaccinationPlan>vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
		List<OpdVaccinMst> vaccineList = new ArrayList<OpdVaccinMst>();
		List<Patient>patientList=new ArrayList<Patient>();
		List<RouteOfAdministration> routeOfAdministrationList = null;
		List<MasFrequency> frequencyList = null;
		Integer visitId=box.getInt("visitId");
		Integer hospitalId=box.getInt("hospitalId");
		Visit visit=null;
		int hinId=0;
		if(visitId!=0){
		      visit=(Visit)session.load(Visit.class, visitId);
		}
		Integer inpatientId=0;
		if(box.getInt("inpatientId")!=0){
			inpatientId=box.getInt("inpatientId");
		}
		Inpatient inpatient=null;
		if(inpatientId!=0){
		 inpatient=(Inpatient)session.load(Inpatient.class,inpatientId);
		}

		if(visitId!=0 && visit!=null){
			hinId=visit.getHin().getId();

			vaccinationPlanList = session.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.eq("Hin.Id",hinId))
					.list();
		}else if(inpatientId!=0 && inpatient!=null){
			hinId=inpatient.getHin().getId();
			vaccinationPlanList = session.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.or(Restrictions.eq("Hin.Id",inpatient.getHin().getId()),Restrictions.eq("Member",inpatient.getHin().getMember()!=null?inpatient.getHin().getMember().getId():0))).list();
		}
		
		
		logger.info("vaccinationPlanList ----- "+vaccinationPlanList.size());
		vaccineList = session.createQuery("from OpdVaccinMst order by cast(VaccinCode as integer) asc").list(); 
		
		logger.info("vaccineList ----- >>"+vaccineList.size());
		
		patientList=session.createCriteria(Patient.class).add(Restrictions.eq("Id",hinId)).list();

		Date dob=new Date();
		if(patientList.size()>0){
		for(Patient patient:patientList){
			if(patient!=null){
				if(patient.getDateOfBirth()!=null)
					dob=patient.getDateOfBirth();
			}
		}
		}
	int minDays=0,maxDays=0,doseCount=0;
	long diff;
	int calDay=1,vacId=0;
	String vaccinName="";
	Date toDate=new Date(),schedDate=new Date(),tempVacDate=new Date();
	String vaccineDate = "";
	String vaccineToDate="";
	Calendar cal = new GregorianCalendar();
	Calendar cal2 = new GregorianCalendar();
	List<ImmunizationUtil> immunizationList=new ArrayList<ImmunizationUtil>();
	Map<Integer,String> schedDateList=new HashMap<Integer,String>();
	Map<Integer,String> toDateList=new HashMap<Integer,String>();
	Map<Integer,String> complDateList=new HashMap<Integer,String>();
	Boolean dateNull=false;
		
		if(vaccineList.size()>0){			
		for(OpdVaccinMst mst:vaccineList){
			vaccinName=mst.getVaccinName();
			cal.setTime(dob);
			cal2.setTime(dob);
			
			doseCount=mst.getDose();
			minDays=mst.getVaccinDuration();
			maxDays=mst.getVaccinToDays(); 
			
			int pCount=0;
			if(vaccinationPlanList.size()>0){ 
				for(OpdVaccinationPlan vaccPlan : vaccinationPlanList){
					pCount++;
					if(vaccPlan.getVaccin().getId().equals(mst.getId())){
						if(vaccPlan.getVaccinDate()!=null){
						schedDate=vaccPlan.getVaccinDate();
						}
						if(vaccPlan.getVaccinCompleteDate()!=null){
						tempVacDate=vaccPlan.getVaccinCompleteDate();
						}
						if(vaccPlan.getVaccinDate()!=null){
						cal.setTime(vaccPlan.getVaccinDate());
						}
						if(vaccPlan.getVaccinToDate()!=null){
						cal2.setTime(vaccPlan.getVaccinToDate());
						}
						vaccineDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
						vaccineToDate = HMSUtil.convertDateToStringWithoutTime(cal2.getTime());	
						
						schedDateList.put(mst.getId(), vaccineDate);
						toDateList.put(mst.getId(), vaccineToDate);
						
						dateNull=true;
						vacId=mst.getId();
						break;
					}
				}
			}
			
			if(dateNull){
			if(getMstSecondList(vaccinName,doseCount,hinId).size()>0){
				
				cal.setTime(dob);
				cal2.setTime(dob);
				OpdVaccinMst mp=getMstSecondList(vaccinName,doseCount,hinId).get(0);
				
				diff = tempVacDate.getTime()-schedDate.getTime();
				diff=TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
				calDay=Integer.parseInt(Long.toString(diff));
				 
				minDays=mp.getVaccinDuration();
				maxDays=mp.getVaccinToDays();
				minDays=minDays+calDay;
				maxDays=maxDays+calDay;
								
					cal.add(Calendar.DAY_OF_MONTH, minDays);
					cal2.add(Calendar.DAY_OF_MONTH, maxDays);

				vaccineDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
				vaccineToDate = HMSUtil.convertDateToStringWithoutTime(cal2.getTime());	
				

				schedDateList.put(mp.getId(), vaccineDate);
				toDateList.put(mp.getId(), vaccineToDate);
				}
			}else{
				if(schedDateList.get(mst.getId())!=null && toDateList.get(mst.getId())!=null){
					
				}else{
					cal.add(Calendar.DAY_OF_MONTH, minDays);
					cal2.add(Calendar.DAY_OF_MONTH, maxDays);
					vaccineDate = HMSUtil.convertDateToStringWithoutTime(cal.getTime());
					vaccineToDate = HMSUtil.convertDateToStringWithoutTime(cal2.getTime());
					schedDateList.put(mst.getId(), vaccineDate);
					toDateList.put(mst.getId(), vaccineToDate);		
				}						
			}
			
			ImmunizationUtil imm=new ImmunizationUtil();
			imm.setId(mst.getId());
			imm.setMinDays(mst.getVaccinDuration());
			imm.setMaxDays(mst.getVaccinToDays());
			imm.setName(mst.getVaccinName());
			imm.setScheDate(schedDateList.get(mst.getId()));
			imm.setVaccinToDate(toDateList.get(mst.getId()));
			immunizationList.add(imm);
			
			dateNull=false;
		}
		
	}
		
		List<Integer> prescribedVaccinList  = session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "i")
							 .createAlias("i.Hin", "h").add(Restrictions.eq("h.Id",hinId)).setProjection(Projections.property("VaccinId")).list();
		
		routeOfAdministrationList =   session.createCriteria(RouteOfAdministration.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
		map.put("vaccineList", vaccineList);
		if(visit!=null && visit.getHin()!=null && visitId!=0  ){
		map.put("patient", visit.getHin());
		}else if(inpatient!=null && inpatient.getHin()!=null && inpatientId!=0 ){
		map.put("patient", inpatient.getHin());	
		}
	
		
		map.put("vaccinationPlanList", vaccinationPlanList);
		map.put("patientList",patientList);
		map.put("prescribedVaccinList",prescribedVaccinList); 
		map.put("routeOfAdministrationList",routeOfAdministrationList); 
		
		map.put("immunizationList",immunizationList);
		return map;
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitVaccineDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdVaccinationPlan> vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
		List<PhMemberSurvey> immunizationList = new ArrayList<PhMemberSurvey>();
		List<OpdVaccinMst> vaccineList = new ArrayList<OpdVaccinMst>();
		List<OpdVaccinationPlan> existingVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<InjAppointmentHeader> injectionRegisterList = new ArrayList<InjAppointmentHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailsList = null;
		List<InjAppointmentDetails> injAppointmentDetailsList = null;

		int count = 0;
		boolean flag = false;
		if (box.getInt("count") != 0) {
			count = (Integer) box.getInt("count");
		}
		int memberServeyId = 0;
		if (box.getInt("memberServeyId") != 0) {
			memberServeyId = (Integer) box.getInt("memberServeyId");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		// hbt.setCheckWriteOperations(false);
		Session session = hbt.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String message = "";
		int vaccinationPlanId = 0;
		int route = 0;   // added by amit das on 20-10-2016
		RouteOfAdministration routeOfAdministration = null;   // added by amit das on 20-10-2016
		Integer pHeaderId = box.getInt("pHeaderId");
		Integer visitId = box.getInt("visitId");
		// Integer departmentId = box.getInt("departmentId");

		try {
			InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			List<Patient> patientList2 = new ArrayList<Patient>();
			patientList2 = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", box.getInt("hinId"))).list();
			int memberId = 0;
			String uhId = "";
			for (Patient pt : patientList2) {
				if (pt.getMember() != null) {
					memberId = pt.getMember().getId();
				}
				if (pt.getHinNo() != null) {
					uhId = pt.getHinNo();
				}
			}

			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			List<Integer> itemIdList = new ArrayList<Integer>();
			Visit visitObjToUpdate = (Visit) hbt.get(Visit.class, visitId);
			List<PatientPrescriptionHeader> patientPrescriptionHeaderList = session
					.createCriteria(PatientPrescriptionHeader.class)
					.createAlias("Hin", "h").createAlias("Visit", "v")
					.add(Restrictions.eq("h.Id", patientList2.get(0).getId()))
					.add(Restrictions.eq("v.Id", visitId)).list();

			if (patientPrescriptionHeaderList.size() > 0) {
				patientPrescriptionHeader = patientPrescriptionHeaderList
						.get(0);
				pHeaderId = patientPrescriptionHeader.getId();
			} else {
				patientPrescriptionHeader = new PatientPrescriptionHeader();
			}
			
			String prescriptionNo = "";
			 /*prescriptionNo=opdDataService
					.generatePrecriptionNo(patientList2.get(0).getId());*/
			 prescriptionNo=generatePrecriptionNo(patientList2.get(0).getId());
			 
			MasDepartment masDepartment = new MasDepartment();

			injectionRegisterList = hbt
					.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="
							+ visitId);

			if (injectionRegisterList != null
					&& injectionRegisterList.size() > 0) {
				for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
					injectionAppointment = injectionRegisterTemp;
				}

				SQLQuery query = session
						.createSQLQuery("delete from inj_appointment_details where inj_appointment_header_id = "
								+ injectionAppointment.getId());
				query.executeUpdate();
			}

			SQLQuery query = session
					.createSQLQuery("delete from patient_prescription_details where prescription_id = "
							+ pHeaderId);
			query.executeUpdate();

			session.flush();

			for (int i = 1; i <= count; i++) {
				if (memberServeyId != 0) {
					existingVaccinationPlanList = session
							.createCriteria(OpdVaccinationPlan.class)
							.add(Restrictions.eq("Member.Id", memberServeyId))
							.add(Restrictions.eq("Vaccin.Id",
									box.getInt("vaccineId" + i)))
							.add(Restrictions.eq("Hospital.Id",
									box.getInt("hospitalId"))).list();
				} else {
					existingVaccinationPlanList = session
							.createCriteria(OpdVaccinationPlan.class)
							.add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
							.add(Restrictions.eq("Vaccin.Id",
									box.getInt("vaccineId" + i)))
							.add(Restrictions.eq("Hospital.Id",
									box.getInt("hospitalId"))).list();
				}
				if (existingVaccinationPlanList.size() > 0) {
					/*
					 * if(box.getString("vaccineDate"+i)!=null &&
					 * !box.getString("vaccineDate"+i).equals("")){
					 * OpdVaccinationPlan vaccinationPlan = new
					 * OpdVaccinationPlan();
					 * vaccinationPlan.setVaccinDate(HMSUtil
					 * .convertStringTypeDateToDateType
					 * (box.getString("vaccineDate"+i)));
					 * if(box.getString("completionDate"+i)!=null &&
					 * !box.getString("completionDate"+i).equals("")){
					 * vaccinationPlan.setVaccinCompleteDate(HMSUtil.
					 * convertStringTypeDateToDateType
					 * (box.getString("completionDate"+i))); }
					 * if(box.getInt("vaccineId"+i) != 0){ OpdVaccinMst
					 * vaccinMst = new OpdVaccinMst();
					 * vaccinMst.setId(box.getInt("vaccineId"+i));
					 * vaccinationPlan.setVaccin(vaccinMst); }
					 * if(box.getString("remarks"+i)!=null &&
					 * !box.getString("remarks"+i).equals("")){
					 * vaccinationPlan.setRemarks(box.getString("remarks"+i)); }
					 * if(memberServeyId != 0){ PhMemberSurvey memberSurvey =
					 * new PhMemberSurvey(); memberSurvey.setId(memberServeyId);
					 * vaccinationPlan.setMember(memberSurvey); } MasHospital
					 * masHospital = new MasHospital();
					 * masHospital.setId(box.getInt("hospitalId"));
					 * vaccinationPlan.setHospital(masHospital);
					 * vaccinationPlan.
					 * setLastChgDate(HMSUtil.convertStringTypeDateToDateType
					 * (date)); vaccinationPlan.setLastChgTime(time); Users
					 * users = new Users(); users.setId(box.getInt("userId"));
					 * vaccinationPlan.setLastChgBy(users);
					 * hbt.save(vaccinationPlan); }
					 */
				} else {
					// added by amit das on 15-09-2016
					
					/*if (box.getString("vaccineItemPvmsNo" + i) != null
							&& !box.getString("vaccineItemPvmsNo" + i).equals(
									"")) {*/
					if (box.getString("checkItem" + i).equals("Y")) {
						String pvmsNo = box.getString("vaccineItemPvmsNo" + i);

						if (box.getString("completionDate" + i) != null
								&& !box.getString("completionDate" + i).equals(
										"")) {
							
							
							OpdVaccinationPlan vaccinationPlan = new OpdVaccinationPlan();

							vaccinationPlan.setVaccinCompleteDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString("completionDate" + i)));
							
							if (box.getString("vaccineDate" + i) != null
									&& !box.getString("vaccineDate" + i)
											.equals("")) {
								vaccinationPlan.setVaccinDate(HMSUtil
										.convertStringTypeDateToDateType(box
												.getString("vaccineDate" + i)));
							}
							if (box.getInt("vaccineId" + i) != 0) {
								OpdVaccinMst vaccinMst = new OpdVaccinMst();
								vaccinMst.setId(box.getInt("vaccineId" + i));
								vaccinationPlan.setVaccin(vaccinMst);
							}
							if (box.getString("remarks" + i) != null
									&& !box.getString("remarks" + i).equals("")) {
								vaccinationPlan.setRemarks(box
										.getString("remarks" + i));
							}
							//Added by Arbind on 02-08-2017
							if (box.getString("vaccinePlace" + i) != null
									&& !box.getString("vaccinePlace" + i).equals("")) {
								vaccinationPlan.setVaccinePlace(box.getString("vaccinePlace" + i));
							}
							if (box.getInt("hinId") != 0) {
								Patient hin = new Patient();
								hin.setId(box.getInt("hinId"));
								vaccinationPlan.setHin(hin);
							}
							//added by govind 6-12-2016
							if (box.getString("vaccineToDate" + i) != null
									&& !box.getString("vaccineToDate" + i)
											.equals("")) {
								vaccinationPlan.setVaccinToDate(HMSUtil
										.convertStringTypeDateToDateType(box
												.getString("vaccineToDate" + i)));
							}//added by govind 6-12-2016 end 
							//Added by Arbind on 12-09-2017
							if (box.getString("vaccineHospital" + i) != null
									&& !box.getString("vaccineHospital" + i).equals("")) {
								vaccinationPlan.setPlaceName(box.getString("vaccineHospital" + i));
							}
							vaccinationPlan.setVaccinInstitute(masHospital);
							vaccinationPlan.setHospital(masHospital);
							vaccinationPlan.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(date));
							vaccinationPlan.setLastChgTime(time);
							Users users = new Users();
							users.setId(box.getInt("userId"));
							vaccinationPlan.setLastChgBy(users);
							hbt.save(vaccinationPlan);

							vaccinationPlanId = vaccinationPlan.getId();

							long memberId2 = 0;
							List<PhMemberSurvey> PhMemberSurveyList = new ArrayList<PhMemberSurvey>();
							PhMemberSurveyList = session
									.createCriteria(PhMemberSurvey.class)
									.add(Restrictions.eq("Id", memberId))
									.list();
							int subcentreId = 0;
							for (PhMemberSurvey PhMemberSurvey : PhMemberSurveyList) {
								if (PhMemberSurvey.getHospital() != null) {
									subcentreId = PhMemberSurvey.getHospital()
											.getId();
									memberId2 = PhMemberSurvey.getMemberId();

								}
							}
							List<OpdVaccinationPlan> OpdVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
							OpdVaccinationPlanList = session
									.createCriteria(OpdVaccinationPlan.class)
									.add(Restrictions.eq("Id",
											vaccinationPlanId)).list();
							for (OpdVaccinationPlan opdVaccinationPlan : OpdVaccinationPlanList) {
								if (subcentreId != 0) {

									MasHospital mh = new MasHospital();
									mh.setId(subcentreId);
									opdVaccinationPlan.setSubCentre(mh);

									opdVaccinationPlan.setMember(memberId2);
									hbt.update(opdVaccinationPlan);
								}
							}
						}
						
						//if (box.getString("checkItem" + i).equals("Y")) {
							
						if (box.getInt("route" + i) != 0) {
							route = box.getInt("route" + i);
							routeOfAdministration = new RouteOfAdministration(route);
						}
						
						
						patientPrescriptionHeader.setHin(patientList2.get(0));
						/*
						 * masDepartment.setId(departmentId);
						 * patientPrescriptionHeader
						 * .setDepartment(masDepartment);
						 */
						patientPrescriptionHeader
								.setPrescriptionNo(prescriptionNo);
						patientPrescriptionHeader.setVisit(visitObjToUpdate);
						patientPrescriptionHeader.setHospital(masHospital);
						patientPrescriptionHeader.setStatus("p");
						patientPrescriptionHeader
								.setPrescriptionDate(new Date());
						// patientPrescriptionHeader.setPrescriptionTime(consultationTime);
						// patientPrescriptionHeader.setDispencingDate(date);
						// patientPrescriptionHeader.setOpdPatientDetail(opdPatientDetails);

						if (pHeaderId != null && pHeaderId != 0) {
							hbt.update(patientPrescriptionHeader);
						} else {
							hbt.save(patientPrescriptionHeader);
						}

						/*
						 * List<MasStoreItem> itemIdListNew = new
						 * ArrayList<MasStoreItem>(); itemIdListNew =
						 * opdDataService.getItemIdFromPVMS(pvmsNo); for (int k
						 * = 0; k < itemIdListNew.size(); k++) {
						 * itemIdList.add(itemIdListNew.get(k).getId()); }
						 */

						int item_class_id = 0;
						List<MasFrequency> masFrequencies = null;
						MasFrequency masFrequency = null;
						MasStoreItem masStoreItem = null;

						
						
						masFrequencies = session.createCriteria(MasFrequency.class).add(Restrictions.eq("FrequencyName", "OD").ignoreCase()).list();
						if(masFrequencies!=null && masFrequencies.size()>0)
							masFrequency = masFrequencies.get(0);
						// if(itemIdList!=null && itemIdList.size()>0) {

						// for (int m = 0; m < itemIdList.size(); m++) {
						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();

						// if (itemIdList != null && itemIdList.size() > 0 &&
						// itemIdList.get(m) != 0)

						masStoreItem = (MasStoreItem) session.load(
								MasStoreItem.class,
								box.getInt("vaccineItemId" + i));

						patientPrescriptionDetails.setItem(masStoreItem);
						patientPrescriptionDetails.setNoOfDays(1);
						
						patientPrescriptionDetails.setFrequency(masFrequency);
						patientPrescriptionDetails.setType("OP");
						patientPrescriptionDetails.setNursingStatus("n");
						patientPrescriptionDetails
								.setPrescription(patientPrescriptionHeader);
						patientPrescriptionDetails.setInjectionStatus("p");
						patientPrescriptionDetails.setDosage(1.0f);  // 1 is set because it is vaccin given to a child
						if(routeOfAdministration!=null)
							patientPrescriptionDetails.setRoute(routeOfAdministration);

						hbt.save(patientPrescriptionDetails);

						injectionAppointment.setHospital(masHospital);
						injectionAppointment.setStatus("p");
						injectionAppointment.setLastChgTime(time);
						injectionAppointment.setLastChgDate(new Date());
						injectionAppointment
								.setPrescription(patientPrescriptionHeader);
						if (injectionRegisterList.size() > 0) {
							hbt.update(injectionAppointment);
						} else {
							Patient patientInj = new Patient();
							patientInj.setId(patientList2.get(0).getId());
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(visitId);
							injectionAppointment.setVisit(visitInj);
							hbt.save(injectionAppointment);
						}

						
						InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
						injAppointmentDetails.setInjAppointmentDate(new Date());
						injAppointmentDetails.setDose("1");   // 1 is set because it is vaccin given to a child
						injAppointmentDetails.setItem(masStoreItem);
						injAppointmentDetails
								.setInjAppointmentHeader(injectionAppointment);
						injAppointmentDetails
								.setPrescriptionDetails(patientPrescriptionDetails);
						injAppointmentDetails.setNoOfDays(1); // 1 is set because it is vaccin given to a child
						injAppointmentDetails.setFrequency(masFrequency);
						injAppointmentDetails.setStatus("p");
						injAppointmentDetails.setFinalStatus("n");
						injAppointmentDetails.setImmunizationInj("Y");
						injAppointmentDetails.setVaccinId(box
								.getInt("vaccineId" + i));
						
						injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
						
						hbt.save(injAppointmentDetails);  
					//}
						// }
						// }

					}else if (box.getString("checkItem" + i).equals("N")) {
						
						if (box.getString("completionDate" + i) != null
								&& !box.getString("completionDate" + i).equals("")) {
						OpdVaccinationPlan vaccinationPlan = new OpdVaccinationPlan();

						vaccinationPlan.setVaccinCompleteDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("completionDate" + i)));

						if (box.getString("vaccineDate" + i) != null
								&& !box.getString("vaccineDate" + i).equals("")) {
							vaccinationPlan.setVaccinDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString("vaccineDate" + i)));
						}
						if (box.getInt("vaccineId" + i) != 0) {
							OpdVaccinMst vaccinMst = new OpdVaccinMst();
							vaccinMst.setId(box.getInt("vaccineId" + i));
							vaccinationPlan.setVaccin(vaccinMst);
						}
						if (box.getString("remarks" + i) != null
								&& !box.getString("remarks" + i).equals("")) {
							vaccinationPlan.setRemarks(box.getString("remarks"
									+ i));
						}
						//Added by Arbind on 02-08-2017
						if (box.getString("vaccinePlace" + i) != null
								&& !box.getString("vaccinePlace" + i).equals("")) {
							vaccinationPlan.setVaccinePlace(box.getString("vaccinePlace" + i));
						}
						/*
						 * if (memberServeyId != 0) { PhMemberSurvey
						 * memberSurvey = new PhMemberSurvey();
						 * memberSurvey.setId(memberServeyId);
						 * vaccinationPlan.setMember(memberSurvey); }
						 */
						if (box.getInt("hinId") != 0) {
							Patient hin = new Patient();
							hin.setId(box.getInt("hinId"));
							vaccinationPlan.setHin(hin);
						}
						//added by govind 6-12-2016
						if (box.getString("vaccineToDate" + i) != null
								&& !box.getString("vaccineToDate" + i)
										.equals("")) {
							vaccinationPlan.setVaccinToDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString("vaccineToDate" + i)));
						}//added by govind 6-12-2016 end 
						//Added by Arbind on 12-09-2017
						if (box.getString("vaccineHospital" + i) != null
								&& !box.getString("vaccineHospital" + i).equals("")) {
							vaccinationPlan.setPlaceName(box.getString("vaccineHospital" + i));
						}
						vaccinationPlan.setVaccinInstitute(masHospital);
						vaccinationPlan.setHospital(masHospital);
						vaccinationPlan.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(date));
						vaccinationPlan.setLastChgTime(time);
						Users users = new Users();
						users.setId(box.getInt("userId"));
						vaccinationPlan.setLastChgBy(users);
						// vaccinationPlan.setMember(member);
						hbt.save(vaccinationPlan);

						/*
						 * Added By Ujjwal to save sub center in tab
						 */
						vaccinationPlanId = vaccinationPlan.getId();

						long memberId2 = 0;
						List<PhMemberSurvey> PhMemberSurveyList = new ArrayList<PhMemberSurvey>();
						PhMemberSurveyList = session
								.createCriteria(PhMemberSurvey.class)
								.add(Restrictions.eq("Id", memberId)).list();
						int subcentreId = 0;
						for (PhMemberSurvey PhMemberSurvey : PhMemberSurveyList) {
							if (PhMemberSurvey.getHospital() != null) {
								subcentreId = PhMemberSurvey.getHospital()
										.getId();
								memberId2 = PhMemberSurvey.getMemberId();

							}
						}
						List<OpdVaccinationPlan> OpdVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
						OpdVaccinationPlanList = session
								.createCriteria(OpdVaccinationPlan.class)
								.add(Restrictions.eq("Id", vaccinationPlanId))
								.list();
						for (OpdVaccinationPlan opdVaccinationPlan : OpdVaccinationPlanList) {
							if (subcentreId != 0) {

								MasHospital mh = new MasHospital();
								mh.setId(subcentreId);
								opdVaccinationPlan.setSubCentre(mh);

								opdVaccinationPlan.setMember(memberId2);
								hbt.update(opdVaccinationPlan);

							}

						}
					}
					}

				}
			}

			flag = true;

			/*
			 * if (map.get("flag") != null) { flag = (Boolean) map.get("flag");
			 * }
			 */

			if (flag) {
				message = "Record Saved Successfully";
			} else {
				message = "Records Not Added/Updated!... Try Again.....";

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (memberServeyId != 0) {
			vaccinationPlanList = session
					.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.eq("Member.Id", memberServeyId)).list();
			immunizationList = session.createCriteria(PhMemberSurvey.class)
					.add(Restrictions.idEq(memberServeyId)).list();
			
		} else if (box.getInt("hinId") != 0) {
			vaccinationPlanList = session
					.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.eq("Hin.Id", box.getInt("hinId"))).list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.idEq(box.getInt("hinId"))).list();
		}
		vaccineList = session.createCriteria(OpdVaccinMst.class)
				.add(Restrictions.eq("Status", "y")).list();

		tx.commit();
		map.put("vaccineList", vaccineList);
		map.put("immunizationList", immunizationList);
		map.put("patientList", patientList);
		map.put("message", message);
		map.put("vaccinationPlanList", vaccinationPlanList);
		map.put("pHeaderId", pHeaderId);
		return map;
	}

	public OPDDataService getOpdDataService() {
		return opdDataService;
	}

	public void setOpdDataService(OPDDataService opdDataService) {
		this.opdDataService = opdDataService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showJphnAndJhiMonthlyObservationsJsp(
			int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasQuestions> masQuestionsList = new ArrayList<MasQuestions>();
		List<MasAnswers> masAnswersList = new ArrayList<MasAnswers>();
		List<PhJphnJhiDetails> phJphnJhiDetailsList = new ArrayList<PhJphnJhiDetails>();
		List<Object[]> phAtpJphnJhiHeaderList = new ArrayList<Object[]>();

		Session session = (Session) getSession();

		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
		int monthVal = Integer.parseInt(month);

		phJphnJhiDetailsList = session.createCriteria(PhJphnJhiDetails.class)
				.createAlias("JphnJhiHeader", "e")
				.add(Restrictions.eq("e.JphnJhiMonths", monthVal)).list();

		phAtpJphnJhiHeaderList = session
				.createCriteria(PhAtpJphnJhiHeader.class)
				.createAlias("AshaWorker", "e")
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("e.Id"))
								.add(Projections.property("e.FirstName"))
								.add(Projections.property("e.MiddleName"))
								.add(Projections.property("e.LastName"))
								.add(Projections.groupProperty("e.Id"))).list();
		// .add(Projections.groupProperty("e.FirstName")).add(Projections.groupProperty("e.MiddleName")).add(Projections.groupProperty("e.LastName"))).list();
		Object[] obj = phAtpJphnJhiHeaderList.get(0);
		int empId = (Integer) obj[0];
		String empName = (String) obj[1];

		map.put("empId", empId);
		map.put("empName", empName);

		masQuestionsList = session.createCriteria(MasQuestions.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masAnswersList = session.createCriteria(MasAnswers.class)
		// .add(Restrictions.eq("Status","y").ignoreCase())
				.list();

		List<MasQuestionAnswers> masQuestionAnswersList = new ArrayList<MasQuestionAnswers>();

		masQuestionAnswersList = session
				.createCriteria(MasQuestionAnswers.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();

		masEmployeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("phJphnJhiDetailsList", phJphnJhiDetailsList);
		
		map.put("masQuestionsList", masQuestionsList);
		map.put("masQuestionAnswersList", masQuestionAnswersList);
		map.put("masAnswersList", masAnswersList);
		map.put("phAtpJphnJhiHeaderList", phAtpJphnJhiHeaderList);
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}

	@Override
	public Map<String, Object> submitJphniJhi(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			PhJphnJhiHeader phJphnJhiHeader = new PhJphnJhiHeader();

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(box.getInt("ashaWorker"));
			phJphnJhiHeader.setAshaWorker(masEmployee);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			phJphnJhiHeader.setHospital(hospital);

			phJphnJhiHeader.setJphnJhiMonths(box.getInt("jphniJhiMonths"));

			Users user = new Users();
			user.setId(box.getInt("changedBy"));
			phJphnJhiHeader.setLastChgBy(user);

			phJphnJhiHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			phJphnJhiHeader.setLastChgTime(box.getString(CHANGED_TIME));

			hbt.save(phJphnJhiHeader);

			int counter = box.getInt("hiddenValueCharge");

			for (int i = 1; i <= counter; i++) {
				int question_answers_id = 0;
				int question_id = 0;
				PhJphnJhiDetails phJphnJhiDetails = new PhJphnJhiDetails();
				if (!box.getString("questionAnswers" + i).equals("")) {

					phJphnJhiDetails.setJphnJhiHeader(phJphnJhiHeader);

					MasQuestions masQuestions = new MasQuestions();
					if (box.getInt("question" + i) != 0) {
						question_id = box.getInt("question" + i);
						masQuestions.setId(question_id);
						phJphnJhiDetails.setQuestion(masQuestions);
					}

					MasQuestionAnswers masQuestionAnswers = new MasQuestionAnswers();
					if (box.getInt("questionAnswers" + i) != 0) {
						question_answers_id = box.getInt("questionAnswers" + i);
						masQuestionAnswers.setId(question_answers_id);
						phJphnJhiDetails.setQuestionAnswers(masQuestionAnswers);
					}

					/*
					 * if(!box.getString("remarks"+i).equals("")){ remarks =
					 * box.getString("remarks"+i);
					 * phJphnJhiDetails.setRemarks(remarks); }
					 */

					hbt.save(phJphnJhiDetails);

				}
			}

			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		paramMap.put("hospitalId", box.getInt("hospitalId"));
		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> generateStudentExcel(Map<String, Object> infoMap) {

		int hospitalId = 0;

		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List studentList = new ArrayList();
		/*
		 * if(infoMap.get("hospitalName") != null){ hospitalName =
		 * (String)infoMap.get("hospitalName"); } if(infoMap.get("hospitalId")
		 * != null){ hospitalId = (Integer)infoMap.get("hospitalId"); }
		 * if(infoMap.get("deptName") != null){ deptName =
		 * (String)infoMap.get("deptName"); } if(infoMap.get("deptId") != null){
		 * deptId = (Integer)infoMap.get("deptId"); }
		 */
		int schoolId = 0;
		if (infoMap.get("schoolId") != null) {
			schoolId = (Integer) infoMap.get("schoolId");
		}
		String hospitalName = "";
		if (infoMap.get("hospitalName") != null) {
			hospitalName = (String) infoMap.get("hospitalName");
		}
		studentList = session.createCriteria(PhStudentRegistration.class)
				.createAlias("Classdetails", "c").createAlias("c.Survey", "s")
				.add(Restrictions.eq("s.Id", schoolId))
				.addOrder(Order.asc("c.SchoolClass")).list();
		// storeItemList=session.createSQLQuery(qry).list();

		
		Iterator itr = studentList.iterator();
		try {
			// create work book
			WorkbookSettings ws = new WorkbookSettings();
			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					"D:/test/TestReport.xls"), ws);

			// create work sheet
			WritableSheet workSheet = null;
			workSheet = workbook.createSheet("Test Report222", 0);
			SheetSettings sh = workSheet.getSettings();

			// Creating Writable font to be used in the report
			WritableFont normalFont = new WritableFont(
					WritableFont.createFont("MS Sans Serif"),
					WritableFont.DEFAULT_POINT_SIZE,
					// WritableFont.createFont("Arial"),
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);

			// creating plain format to write data in excel sheet
			WritableCellFormat normalFormat = new WritableCellFormat(normalFont);
			normalFormat.setWrap(true);
			normalFormat.setAlignment(jxl.format.Alignment.CENTRE);
			normalFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
			normalFormat.setWrap(true);
			// normalFormat.set
			normalFormat.setBorder(jxl.format.Border.ALL,
					jxl.format.BorderLineStyle.THIN, jxl.format.Colour.BLUE);

			// write to datasheet
			workSheet.addCell(new jxl.write.Label(0, 0, "User Name",
					normalFormat));
			workSheet.addCell(new jxl.write.Label(1, 0, "Password",
					normalFormat));
			// workSheet.set

			// write to the excel sheet
			workbook.write();

			// close the workbook
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Student Register");
		// sheet.setColumnWidth((short) 1, (short)10);
		// Create a new font and alter it.

		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName(HSSFFont.FONT_ARIAL);
		font.setColor((short) 80);
		font.setItalic(false);
		font.setStrikeout(false);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFFont font1 = wb.createFont();
		/*
		 * font1.setFontHeightInPoints((short) 12);
		 * font1.setFontName(HSSFFont.FONT_ARIAL); font1.setColor((short) 80);
		 * font1.setItalic(false); font1.setStrikeout(false);
		 * //font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 */
		HSSFFont font2 = wb.createFont();
		/*
		 * font2.setFontHeightInPoints((short) 9);
		 * font2.setFontName(HSSFFont.FONT_ARIAL); font2.setColor((short) 80);
		 * font2.setItalic(false); font2.setStrikeout(false);
		 * font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 */
		// Fonts are set into a style so create a new one to
		// use.
		HSSFCellStyle style = wb.createCellStyle();
		style.setLocked(true);
		// style.setFont(font);
		style.setHidden(true);
		style.setAlignment((short) 2);

		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setFont(font1);
		style1.setAlignment((short) 2);

		HSSFCellStyle style2 = wb.createCellStyle();
		style2.setFont(font2);
		style2.setAlignment((short) 2);

		// style1.setLocked(true);

		HSSFRow row2 = sheet.createRow((short) 2);
		HSSFCell cell20 = row2.createCell((short) 3);
		cell20.setCellValue(new HSSFRichTextString(hospitalName));
		cell20.setCellStyle(style1);
		sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

		HSSFRow row3 = sheet.createRow((short) 3);
		HSSFCell cell30 = row3.createCell((short) 3);
		cell30.setCellValue(new HSSFRichTextString("Student Master"));
		cell30.setCellStyle(style1);
		sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

		// HSSFCell cell32 = row3.createCell((short) 7);
		// cell32.setCellValue(new HSSFRichTextString("25/12/2011"));

		HSSFRow row4 = sheet.createRow((short) 4);
		HSSFCell cell40 = row4.createCell((short) 1);
		cell40.setCellStyle(style1);
		cell40.setCellValue(new HSSFRichTextString(""));
		sheet.addMergedRegion(new Region(4, (short) 0, 4, (short) 7));

		// =====Heading Row Start===========================
		HSSFRow headingRow1 = sheet.createRow((short) 5);

		HSSFCell cell70 = headingRow1.createCell((short) 0);
		cell70.setCellValue(new HSSFRichTextString("STUDENT ID"));
		cell70.setCellStyle(style);
		sheet.autoSizeColumn((short) 0);

		HSSFCell cell71 = headingRow1.createCell((short) 1);
		cell71.setCellValue(new HSSFRichTextString("      School Name        "));
		cell71.setCellStyle(style2);
		sheet.autoSizeColumn((short) 1);

		HSSFCell cell73 = headingRow1.createCell((short) 2);
		cell73.setCellValue(new HSSFRichTextString("Standard"));
		cell73.setCellStyle(style2);
		sheet.autoSizeColumn((short) 3);

		HSSFCell cell74 = headingRow1.createCell((short) 3);
		cell74.setCellValue(new HSSFRichTextString("Division"));
		cell74.setCellStyle(style2);
		sheet.autoSizeColumn((short) 4);

		HSSFCell cell75 = headingRow1.createCell((short) 4);
		cell75.setCellStyle(style);
		cell75.setCellValue(new HSSFRichTextString("DOB"));
		cell75.setCellStyle(style2);
		sheet.autoSizeColumn((short) 5);

		HSSFCell cell77 = headingRow1.createCell((short) 5);
		cell77.setCellValue(new HSSFRichTextString("  Student Name  "));
		cell77.setCellStyle(style2);
		sheet.autoSizeColumn((short) 7);

		HSSFCell cell78 = headingRow1.createCell((short) 6);
		cell78.setCellValue(new HSSFRichTextString("  Father Name  "));
		cell78.setCellStyle(style2);
		sheet.autoSizeColumn((short) 8);

		HSSFCell cell79 = headingRow1.createCell((short) 7);
		cell79.setCellValue(new HSSFRichTextString("  Mother Name  "));
		cell79.setCellStyle(style2);
		sheet.autoSizeColumn((short) 9);

		HSSFCell cell81 = headingRow1.createCell((short) 8);
		cell81.setCellValue(new HSSFRichTextString("Gender"));
		cell81.setCellStyle(style2);
		sheet.autoSizeColumn((short) 11);

		HSSFCell cell85 = headingRow1.createCell((short) 9);
		cell85.setCellValue(new HSSFRichTextString("    Address    "));
		cell85.setCellStyle(style2);
		sheet.autoSizeColumn((short) 15);

		HSSFCell cell86 = headingRow1.createCell((short) 10);
		cell86.setCellValue(new HSSFRichTextString("Age"));
		cell86.setCellStyle(style2);
		sheet.autoSizeColumn((short) 16);

		// ============Heading Completed=======================

		// Region(int rowFrom, short colFrom, int rowTo, short colTo)
		// sheet.addMergedRegion(new Region(6, (short) 1, 6, (short) 2));

		int row = 6;
		int i = 1;
		while (itr.hasNext()) {
			
			if (i <= 65000) {
				PhStudentRegistration masStudent = (PhStudentRegistration) itr
						.next();
				String studentName = masStudent.getMembersurvey().getName();
				Long grNo = masStudent.getMembersurvey().getAadhaarNo();
				String genderName = "";
				String schoolName = "";
				String standard = "";
				String division = "";
				Date dob = null;
				String fatherName = "";
				String motherName = "";
				String address = "";
				String age = "";
				int studenntId = 0;

				if (masStudent.getClassdetails().getSurvey() != null) {
					if (masStudent.getClassdetails().getSurvey().getPlaceName() != null) {
						schoolName = masStudent.getClassdetails().getSurvey()
								.getPlaceName();
					}
				}
				if (masStudent.getId() != 0) {
					studenntId = masStudent.getId();
				}

				if (masStudent.getMembersurvey().getGender() != null) {
					if (masStudent.getMembersurvey().getGender()
							.getAdministrativeSexName() != null) {
						genderName = masStudent.getMembersurvey().getGender()
								.getAdministrativeSexName();
					}
				}
				if (masStudent.getClassdetails() != null
						&& masStudent.getClassdetails().getSchoolClass() != null) {
					standard = masStudent.getClassdetails().getSchoolClass();
				}

				if (masStudent.getMembersurvey().getPersonName() != null) {
					fatherName = masStudent.getMembersurvey().getPersonName();
				}
				if (masStudent.getMembersurvey().getPersonName() != null) {
					motherName = masStudent.getMembersurvey().getPersonName();
				}
				if (masStudent.getClassdetails() != null
						&& masStudent.getClassdetails().getSchoolSection() != null) {
					division = masStudent.getClassdetails().getSchoolSection();
				}
				if (masStudent.getMembersurvey().getDateOfBirth() != null) {
					dob = masStudent.getMembersurvey().getDateOfBirth();
				}
				if (masStudent.getAddress() != null) {
					address = masStudent.getAddress();
				}
				/*
				 * if (masStudent.getAge() != null) { age = masStudent.getAge();
				 * }
				 */
				/*
				 * if (masStudent.getCategory() != null) { category =
				 * masStudent.getCategory(); }
				 */
				/*
				 * Object[] pair = (Object[]) itr.next(); String pvms_no= float
				 * received_qty=Float.parseFloat(pair[0].toString()); float
				 * issue_qty=Float.parseFloat(pair[1].toString()); float
				 * opening_balance_qty=Float.parseFloat(pair[2].toString());
				 * float adjust_qty=Float.parseFloat(pair[3].toString()); String
				 * pvms_no=pair[4].toString(); String
				 * nomenclature=pair[5].toString(); float
				 * issue_return=Float.parseFloat(pair[6].toString()); float
				 * balance_qty=Float.parseFloat(pair[7].toString()); float
				 * item_id=Float.parseFloat(pair[8].toString());
				 */
				
				HSSFRow detailRow = sheet.createRow((short) row);

				HSSFCell cell90 = detailRow.createCell((short) 0);
				cell90.setCellValue(studenntId);

				HSSFCell cell91 = detailRow.createCell((short) 1);
				cell91.setCellValue(new HSSFRichTextString(schoolName
						.concat("[")
						.concat(""
								+ masStudent.getClassdetails().getSurvey()
										.getId()).concat("]")));

				HSSFCell cell93 = detailRow.createCell((short) 2);
				cell93.setCellValue(standard);

				HSSFCell cell94 = detailRow.createCell((short) 3);
				cell94.setCellValue(division);

				HSSFCell cell95 = detailRow.createCell((short) 4);
				if (dob != null) {
					cell95.setCellValue(HMSUtil
							.convertDateToStringTypeDateOnly(dob));
				}

				HSSFCell cell97 = detailRow.createCell((short) 5);
				cell97.setCellValue(studentName);

				HSSFCell cell98 = detailRow.createCell((short) 6);
				cell98.setCellValue(fatherName);

				HSSFCell cell99 = detailRow.createCell((short) 7);
				cell99.setCellValue(motherName);

				HSSFCell cell101 = detailRow.createCell((short) 8);
				cell101.setCellValue(genderName);

				HSSFCell cell105 = detailRow.createCell((short) 9);
				cell105.setCellValue(address);

				HSSFCell cell106 = detailRow.createCell((short) 10);
				cell106.setCellValue(age);

				i++;
				row = row + 1;
			} else {
				PhStudentRegistration masStudent = (PhStudentRegistration) itr
						.next();
				String studentName = masStudent.getMembersurvey().getName();
				String genderName = "";
				String schoolName = "";
				String standard = "";
				String division = "";
				Date dob = null;
				int cardNo = 0;
				String fatherName = "";
				String motherName = "";
				String category = "";
				String address = "";
				String age = "";
				int studenntId = 0;
				int academicYearId = 0;
				if (masStudent.getClassdetails().getSurvey() != null) {
					if (masStudent.getClassdetails().getSurvey().getPlaceName() != null) {
						schoolName = masStudent.getClassdetails().getSurvey()
								.getPlaceName();
					}
				}
				if (masStudent.getId() != 0) {
					studenntId = masStudent.getId();
				}

				if (masStudent.getMembersurvey().getGender() != null) {
					if (masStudent.getMembersurvey().getGender()
							.getAdministrativeSexName() != null) {
						genderName = masStudent.getMembersurvey().getGender()
								.getAdministrativeSexName();
					}
				}
				if (masStudent.getClassdetails() != null
						&& masStudent.getClassdetails().getSchoolClass() != null) {
					standard = masStudent.getClassdetails().getSchoolClass();
				}

				if (masStudent.getMembersurvey().getPersonName() != null) {
					fatherName = masStudent.getMembersurvey().getPersonName();
				}
				if (masStudent.getMembersurvey().getPersonName() != null) {
					motherName = masStudent.getMembersurvey().getPersonName();
				}
				if (masStudent.getClassdetails() != null
						&& masStudent.getClassdetails().getSchoolSection() != null) {
					division = masStudent.getClassdetails().getSchoolSection();
				}
				if (masStudent.getMembersurvey().getDateOfBirth() != null) {
					dob = masStudent.getMembersurvey().getDateOfBirth();
				}
				if (masStudent.getAddress() != null) {
					address = masStudent.getAddress();
				}
				/*
				 * Object[] pair = (Object[]) itr.next(); String pvms_no= float
				 * received_qty=Float.parseFloat(pair[0].toString()); float
				 * issue_qty=Float.parseFloat(pair[1].toString()); float
				 * opening_balance_qty=Float.parseFloat(pair[2].toString());
				 * float adjust_qty=Float.parseFloat(pair[3].toString()); String
				 * pvms_no=pair[4].toString(); String
				 * nomenclature=pair[5].toString(); float
				 * issue_return=Float.parseFloat(pair[6].toString()); float
				 * balance_qty=Float.parseFloat(pair[7].toString()); float
				 * item_id=Float.parseFloat(pair[8].toString());
				 */

				HSSFRow detailRow = sheet.createRow((short) row);

				HSSFCell cell90 = detailRow.createCell((short) 0);
				cell90.setCellValue(studenntId);

				HSSFCell cell91 = detailRow.createCell((short) 1);
				cell91.setCellValue(new HSSFRichTextString(schoolName
						.concat("[")
						.concat(""
								+ masStudent.getClassdetails().getSurvey()
										.getId()).concat("]")));

				HSSFCell cell93 = detailRow.createCell((short) 2);
				cell93.setCellValue(standard);

				HSSFCell cell94 = detailRow.createCell((short) 3);
				cell94.setCellValue(division);

				HSSFCell cell95 = detailRow.createCell((short) 4);
				if (dob != null) {
					cell95.setCellValue(HMSUtil
							.convertDateToStringTypeDateOnly(dob));
				}

				HSSFCell cell97 = detailRow.createCell((short) 5);
				cell97.setCellValue(studentName);

				HSSFCell cell98 = detailRow.createCell((short) 6);
				cell98.setCellValue(fatherName);

				HSSFCell cell99 = detailRow.createCell((short) 7);
				cell99.setCellValue(motherName);

				HSSFCell cell101 = detailRow.createCell((short) 8);
				cell101.setCellValue(genderName);

				HSSFCell cell105 = detailRow.createCell((short) 9);
				cell105.setCellValue(address);

				HSSFCell cell106 = detailRow.createCell((short) 10);
				cell106.setCellValue(age);

				i++;
				row = row + 1;
			}

		}
		map.put("wb", wb);

		return map;
	}

	public Map<String, Object> getMonths(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();

		String month = "";
		Date fromDate = null;
		Date toDate = null;
		month = (String) dataMap.get("monthValue");
		fromDate = HMSUtil.convertStringTypeDateToDateType(dataMap.get("fromDate").toString());
		toDate = HMSUtil.convertStringTypeDateToDateType(dataMap.get("toDate").toString());
		Session session = (Session) getSession();
		
		/*
		 * String qry =
		 * "select x.A1,X.A2,X.A3,X.A4,X.A5,X.B2,X.B3,X.B4,X.B5,X.A6,X.A7,X.A8,X.A10,X.A9,X.B6,X.B7,X.B8,X.B10,X.B9 FROM ((select pajjd.day_block_id AS A0,pajjd.date_atp as A1,pdb.for_day AS A2,COUNT(dbd.survey_id) AS A3,count(dbd.locality_id) AS A4,COUNT(dbd.ward_id) AS A5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS A6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS A7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS A8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS A9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS A10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.pending_day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id where pajjh.for_month ='"
		 * + monthValue +
		 * "'  group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)a left outer join (select pajjd.day_block_id AS B0,pajjd.date_atp AS B1,pdb.for_day AS B2,COUNT(dbd.survey_id) AS B3,count(dbd.locality_id) AS B4,COUNT(dbd.ward_id) B5,(case when (pajjd.routine_activity)='m' then 'Meeting' else 'Not Given' end ) AS B6,(case when(pajjd.other_activity) ='t' then 'Training' else 'Not Given' end) AS B7,(case when(pajjd.after_noon_activity) ='t' then 'Training' else 'Not Given' end) AS B8,(case when(pajjd.supervision) ='c' then 'Training' else 'Not Given' end) AS B9,(case when(pajjd.remarks) !='' then pajjd.remarks else 'Not Given' end) AS B10 from ph_day_block pdb LEFT OUTER JOIN ph_day_block_detail dbd ON dbd.day_id=pdb.day_id right OUTER JOIN ph_atp_jphn_jhi_details pajjd ON pajjd.day_block_id=pdb.day_id LEFT OUTER JOIN ph_atp_jphn_jhi_header pajjh ON pajjh.atp_header_id=pajjd.atp_header_id LEFT OUTER JOIN ph_house_survey phs ON phs.survey_id=dbd.survey_id  where pajjh.for_month ='"
		 * + monthValue +
		 * "' group by pajjd.date_atp,pdb.for_day,pajjd.day_block_id,pajjd.routine_activity,pajjd.other_activity,pajjd.after_noon_activity,pajjd.supervision,pajjd.remarks)b on a.A0=b.B0)x;"
		 * ;
		 */

		String qry = "select ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id),ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker left outer join mm_mas_request_status mmrs ON mmrs.status_id = ajjh.status where ajjh.for_month ='"
				+ month + "' and ajjd.date_atp between '" + fromDate + "' and '" + toDate
				+ "' group by ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name,	ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity,ajjd.remarks,status_name";

		phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();

		map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);

		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> showPhMappingJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> cscList = new ArrayList<MasHospital>();
		cscList = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "csc")
				/*
				 * .add(Restrictions.eq("csc.HospitalTypeName",
				 * "Community Health Centre"))
				 */
				.add(Restrictions.eq("csc.Id", 49))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("cscList", cscList);
		int hospitalTypeId = 0;
		if (box.getInt("hospitalTypeId") != 0) {
			hospitalTypeId = box.getInt("hospitalTypeId");
		}
		map.put("hospitalTypeId", hospitalTypeId);
		String healthBlock = "";
		int healthBlockId = 0;
		String phcCHC = "";
		int hospitalId = 0;
		if (box.getInt("hospitalId") != 0) {
			hospitalId = box.getInt("hospitalId");
		}
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		String labelName = "";
		String hospitalName = "";
		int hospitaltype = 0;
		int hospialIdphcCHC = 0;
		int subCenterIdd = 0;
		if (hospitalTypeId == 1 || hospitalTypeId == 2) {
			hospitalList = session
					.createCriteria(MasHospital.class)
					.add(Restrictions.idEq(hospitalId))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.property("ParentInstitute.Id"))
									.add(Projections.property("HospitalName"))
									.add(Projections
											.property("HospitalType.Id"))

									.add(Projections.property("Id"))).list();
			if (hospitalList.size() > 0) {
				for (Object[] hospital : hospitalList) {
					hospialIdphcCHC = Integer.parseInt("" + hospital[0]);
					hospitalName = "" + hospital[1];
					hospitaltype = Integer.parseInt("" + hospital[2]);
					subCenterIdd = Integer.parseInt("" + hospital[3]);
				}
				logger.info("subCenterIdd####" + subCenterIdd + "hospialIdphcCHC " + hospialIdphcCHC +"hospitalName####" + hospitalName);
				if (hospitaltype == 1) {
					labelName = "Sub Center";
				} else if (hospitaltype == 2) {
					labelName = "Basic Section";
				}
				map.put("labelName", labelName);
				map.put("hospitalName", hospitalName);
				map.put("subCenterIdd", subCenterIdd);
				map.put("hospialIdphcCHC", hospialIdphcCHC);

			}
			List<Object[]> phcCHCList = new ArrayList<Object[]>();
			if (hospialIdphcCHC != 0) {
				phcCHCList = session
						.createCriteria(MasHospital.class)
						.add(Restrictions.idEq(hospialIdphcCHC))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("HospitalName"))
										.add(Projections
												.property("ParentInstitute.Id")))
						.list();
			}
			int hospitalIdHB = 0;
			if (phcCHCList.size() > 0) {
				for (Object[] obj : phcCHCList) {
					phcCHC = "" + obj[0];
					hospitalIdHB = Integer.parseInt("" + obj[1]);
				}
			}
			logger.info("hospitalIdHB####" + hospitalIdHB);
			
			map.put("phcCHC", phcCHC);
			map.put("hospitalIdHB", hospitalIdHB);
			List<Object[]> healthBlockList = new ArrayList<Object[]>();
			if (hospitalIdHB != 0) {
				healthBlockList = session
						.createCriteria(MasHospital.class)
						.add(Restrictions.idEq(hospitalIdHB))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("HospitalName"))
										.add(Projections
												.property("ParentInstitute.Id")))
						.list();
			}
			if (healthBlockList.size() > 0) {
				for (Object[] healthBlock1 : healthBlockList) {
					healthBlock = "" + healthBlock1[0];
					healthBlockId = Integer.parseInt("" + "" + healthBlock1[1]);
				}
			}
			map.put("healthBlock", healthBlock);
			map.put("healthBlockId", healthBlockId);

		}
		
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPhcList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> phcList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		phcList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "phc")
				// .add(Restrictions.eq("phc.HospitalTypeName",
				// "Primary Health Centre"))
				.add(Restrictions.or(Restrictions.eq("phc.HospitalTypeName",
						"Primary Health Centre"), Restrictions.eq(
						"phc.HospitalTypeName", "24x7 Primary Health Centre")))
				.add(Restrictions.eq("ParentInstitute.Id", box.getInt("chcId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("phcList", phcList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getSubCenterList(Box box) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		subcenterList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				/*
				 * .add(Restrictions .eq("SubCentre.HospitalTypeName",
				 * "Sub Centre"))
				 */
				/* .add(Restrictions */
				/* .eq("SubCentre.Id", 1)) */
				.add(Restrictions.eq("SubCentre.Id", 1))
				.add(Restrictions.eq("ParentInstitute.Id", box.getInt("phcId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("subcenterList", subcenterList);
		return map;
	}

	@Override
	public Map<String, Object> getbasicSectionList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> basicSectionList = new ArrayList<MasHospital>();
		
		Session session = (Session) getSession();
		basicSectionList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "basicSection")
				/*
				 * .add(Restrictions.eq("basicSection.HospitalTypeName",
				 * "Basic Section"))
				 */
				.add(Restrictions.eq("basicSection.Id", 2))
				.add(Restrictions.eq("ParentInstitute.Id", box.getInt("phcId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("basicSectionList", basicSectionList);
		return map;
	}

	@Override
	public Map<String, Object> getParametersList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasParliyamentAssembly> parliament = new ArrayList<PhMasParliyamentAssembly>();
		Session session = (Session) getSession();
		parliament = session.createCriteria(PhMasParliyamentAssembly.class)
				.add(Restrictions.eq("Category", "p").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		map.put("parliament", parliament);
		return map;
	}

	@Override
	public Map<String, Object> showAtPhnJhiPrepairAndSubmmitJsp(
			Map<String, Object> detailMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) detailMap.get(HOSPITAL_ID);
		int empId = (Integer) detailMap.get("empId");
		MasEmployee masEmp = new MasEmployee();
		masEmp.setId(empId);
		Calendar calendar = Calendar.getInstance();
		String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
		String forMonth = "";
		Date fromDate = null;
		Date toDate = null;
		Integer id = 2;
		if (detailMap.get("forMonth") != null) {
			forMonth = (String) detailMap.get("forMonth");
		}
		if (detailMap.get("fromDate") != null && detailMap.get("toDate") != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(detailMap.get("fromDate").toString());
			toDate = HMSUtil.convertStringTypeDateToDateType(detailMap.get("toDate").toString());
		}
		List<PhAtpJphnJhiDetails> atpJphnJhiDetailsTable = new ArrayList<PhAtpJphnJhiDetails>();
		Set<String> name = new HashSet<String>();

		Criteria cr = getSession().createCriteria(PhAtpJphnJhiDetails.class)
				.createAlias("AtpHeader", "head")
				//.add(Restrictions.eq("head.ForMonth", "12"));
				.add(Restrictions.eq("head.Status.Id", id));
		if(!forMonth.equals("")) {
			cr.add(Restrictions.eq("head.ForMonth", forMonth))
			  .add(Restrictions.between("DateAtp", fromDate, toDate));
		} else {
			cr.add(Restrictions.eq("head.ForMonth", month));
		}

		atpJphnJhiDetailsTable = cr.list();

/*		for (PhAtpJphnJhiDetails fgs : atpJphnJhiDetailsTable) {
			System.out.println(fgs.getDateAtp());
			if (fgs.getDayBlock() != null) {
				System.out.println(fgs.getDayBlock());
			}
			PhAtpJphnJhiHeader heder = (PhAtpJphnJhiHeader) fgs.getAtpHeader();
			System.out.println(heder.getAshaWorker().getEmployeeName());

			if (fgs.getSupervision() != null) {
				if (fgs.getSupervision().equalsIgnoreCase("c")) {

					System.out.println("concsicutive");
				}
			} else if (fgs.getSupervision() != null) {
				if (fgs.getSupervision().equalsIgnoreCase("cv")) {

					System.out.println("concurrent");
				}
			}

			if (fgs.getDayBlock() != null) {
				PhDayBlock ds = (PhDayBlock) fgs.getDayBlock();

				Set<PhDayBlockDetail> dtail = (Set<PhDayBlockDetail>) ds
						.getPhDayBlockDetails();
				for (PhDayBlockDetail de : dtail) {
					System.out.println(de.getLocality().getLocalityName());
					System.out.println(de.getWard().getWardName());
				}
			}
		}*/
		map.put("atpJphnJhiDetailsTable", atpJphnJhiDetailsTable);

		return map;
	}

	@Override
	public Map<String, Object> getDtailThroughDate(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhAtpJphnJhiDetails> atpJphnJhiDetails = new ArrayList<PhAtpJphnJhiDetails>();
		List<PhAtpJphnJhiHeader> atpJphnJhiHeaders = new ArrayList<PhAtpJphnJhiHeader>();

		int count = box.getInt("hiddenValueCharge");
		Criteria cr = null;
		for (int i = 1; i <= count; i++) {
			Date date = (Date) HMSUtil.convertStringTypeDateToDateType(box
					.getString("dateAtp" + i));
			
			if (date != null) {

				cr = getSession().createCriteria(PhAtpJphnJhiDetails.class,
						"phAtp").add(Restrictions.eq("phAtp.DateAtp", date));
			}
			map.put("date", date);

		}
		atpJphnJhiDetails = cr.list();
		if (atpJphnJhiDetails.size() > 0) {

			Criteria cr2 = getSession()
					.createCriteria(PhAtpJphnJhiHeader.class, "phAtp")
					.createAlias("phAtp.Hospital", "hospital")
					.add(Restrictions.eq("hospital.Id", box.getInt("hsId")))
					.createAlias("phAtp.AshaWorker", "ashaWorker")
					.add(Restrictions.eq("ashaWorker.Id", box.getInt("empId")));
			atpJphnJhiHeaders = cr2.list();
		}
		
		map.put("atpJphnJhiDetails", atpJphnJhiDetails);
		map.put("atpJphnJhiHeaders", atpJphnJhiHeaders);
		

		return map;
	}

	@Override
	public Map<String, Object> addApproveSubmit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		int count = box.getInt("hiddenValueCharge");
		List<PhAtpJphnJhiDetails> atpJphnJhiDetailslist = new ArrayList<PhAtpJphnJhiDetails>();
		boolean saved = false;
		Criteria cr = getSession().createCriteria(PhAtpJphnJhiDetails.class);
		atpJphnJhiDetailslist = cr.list();
		for (int i = 1; i <= count; i++) {
			if (!box.get("jphnNameCv" + i).equals("")
					|| !box.get("jphnNameC" + i).equals("")) {
				for (PhAtpJphnJhiDetails detai : atpJphnJhiDetailslist) {

					/*
					 * int empId=0; List<String>
					 * v=box.getArrayList("jphnNameCv"+i);
					 * System.out.println(v.size
					 * ()+"===="+v.get(0)+"===="+v.get(1)); if(v.get(0)!=""){
					 * if(v.get(0)!=""){
					 * 
					 * empId=Integer.parseInt(v.get(0));
					 * 
					 * }else{
					 * 
					 * empId=Integer.parseInt(v.get(1)); } }
					 * 
					 * System.out.println(empId+"===Test====");
					 */

					if (detai.getId().equals(box.getInt("jphnNameCv" + i))
							|| detai.getId()
									.equals(box.getInt("jphnNameC" + i))) {
						HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
						Session session = (Session) getSession();
						Transaction tx = null;
						saved = false;
						try {
							tx = session.beginTransaction();

							PhAtpJphnJhiDetails dAtpJphnJhiDetails = (PhAtpJphnJhiDetails) getHibernateTemplate()
									.load(PhAtpJphnJhiDetails.class,
											box.getInt("jphnNameCv" + i) != 0 ? box
													.getInt("jphnNameCv" + i)
													: box.getInt("jphnNameC"
															+ i));

							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(box.getInt("empId"));
							dAtpJphnJhiDetails.setEmployee(masEmployee);
							hbt.update(dAtpJphnJhiDetails);
							tx.commit();
							saved = true;

						} catch (Exception e) {
							tx.rollback();
						}
					}
				}
			}
		}
		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> datewiseCompletion(Box box) {
		List<PhHouseSurvey> atpJphlist = new ArrayList<PhHouseSurvey>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhDayBlock> dayBlockList = new ArrayList<PhDayBlock>();
		List<PhAtpJphnJhiDetails> phAtpJphnJhiDetails = new ArrayList<PhAtpJphnJhiDetails>();
		List<PhAtpJphnJhiDetails> phAtpJphnJhiDetList = new ArrayList<PhAtpJphnJhiDetails>();

		Date date = new Date();

		if (!box.getString("date").equals("")) {
			HMSUtil.convertStringTypeDateToDateType(box.getString("date"));
		}

		int hospitalId = (Integer) box.getInt(HOSPITAL_ID);
		int empId = (Integer) box.getInt("empId");
		Criteria crForAtpList = null;
		Criteria crForAtpDetail = getSession()
				.createCriteria(PhAtpJphnJhiDetails.class, "atph")
				.add(Restrictions.eq("DateAtp", date))
				.createAlias("atph.AtpHeader", "head")
				.createAlias("head.AshaWorker", "emp")
				.add(Restrictions.eq("emp.Id", empId))
				.createAlias("head.Hospital", "hs")
				.add(Restrictions.eq("hs.Id", hospitalId))
				.add(Restrictions.isNull("atph.WorkStatus"));

		phAtpJphnJhiDetails = crForAtpDetail.list();
		
		if (phAtpJphnJhiDetails.size() == 0) {
			crForAtpList = getSession()
					.createCriteria(PhAtpJphnJhiDetails.class, "atph")
					.add(Restrictions.eq("DateAtp", date))
					.createAlias("atph.AtpHeader", "head")
					.createAlias("head.AshaWorker", "emp")
					.add(Restrictions.eq("emp.Id", empId))
					.createAlias("head.Hospital", "hs")
					.add(Restrictions.eq("hs.Id", hospitalId))
					.createAlias("head.Status", "st")
					.add(Restrictions.eq("st.StatusName", "Approved"))
					.add(Restrictions.isNotNull("atph.WorkStatus"));
			phAtpJphnJhiDetList = crForAtpList.list();

		}

		

		/*
		 * Criteria cr=getSession().createCriteria(PhDayBlock.class,"dyBlock")
		 * .createAlias("dyBlock.Hospital", "hospital")
		 * .add(Restrictions.eq("hospital.Id",hospitalId))
		 * .createAlias("dyBlock.Employee", "employee")
		 * .add(Restrictions.eq("employee.Id",empId))
		 * .add(Restrictions.eq("LastChgDate",date)) ; Criteria
		 * crForHouse=getSession().createCriteria(PhHouseSurvey.class);
		 * 
		 * atpJphlist=crForHouse.list();
		 * 
		 * dayBlockList=cr.list();
		 * System.out.println("sizeggghh"+dayBlockList.size()); for(PhDayBlock
		 * daybl:dayBlockList){
		 * 
		 * Set<PhDayBlockDetail> dlist= daybl.getPhDayBlockDetails();
		 * for(PhDayBlockDetail df:dlist){
		 * System.out.println(df.getLocality().getLocalityName());
		 * System.out.println(df.getSurvey().getHouseHoldId()); } }
		 * System.out.println("Total No Of Hoeses in"); for(PhHouseSurvey
		 * servey:atpJphlist){ System.out.println(servey.getHouseHoldId()); }
		 * 
		 * 
		 * 
		 * System.out.println("Size" + phAtpJphnJhiDetails.size());
		 * 
		 * for (PhAtpJphnJhiDetails obj : phAtpJphnJhiDetails) {
		 * System.out.println(obj.getDayBlock().getHouseId()); PhDayBlock ds =
		 * (PhDayBlock) obj.getDayBlock(); Set<PhDayBlockDetail> dtail =
		 * (Set<PhDayBlockDetail>) ds .getPhDayBlockDetails(); for
		 * (PhDayBlockDetail vf : dtail) {
		 * System.out.println(vf.getSurvey().getHouseHoldId()+"///");
		 * 
		 * }
		 * 
		 * }
		 */

		map.put("phAtpJphnJhiDetails", phAtpJphnJhiDetails);
		map.put("phAtpJphnJhiDetList", phAtpJphnJhiDetList);
		return map;

	}

	@Override
	public Map<String, Object> saveDailyWork(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhAtpJphnJhiDetails> atpJphnJhiDetailslist = new ArrayList<PhAtpJphnJhiDetails>();
		boolean saved = false;
		Criteria cr = getSession().createCriteria(PhAtpJphnJhiDetails.class);
		atpJphnJhiDetailslist = cr.list();

		for (PhAtpJphnJhiDetails detai : atpJphnJhiDetailslist) {
			if (detai.getId().equals(box.getInt("tempId"))) {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session = (Session) getSession();
				Transaction tx = null;
				saved = false;
				try {
					tx = session.beginTransaction();
					PhAtpJphnJhiDetails dAtpJphnJhiDetails = (PhAtpJphnJhiDetails) getHibernateTemplate()
							.load(PhAtpJphnJhiDetails.class,
									box.getInt("tempId"));

					dAtpJphnJhiDetails.setWorkStatus("complete");
					hbt.update(dAtpJphnJhiDetails);
					tx.commit();
					saved = true;
				} catch (Exception e) {
					tx.rollback();
				}

			}
		}

		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> getlocality(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDistrict> district = new ArrayList<MasDistrict>();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		district = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("district", district);
		return map;
	}

	@Override
	public Map<String, Object> getTalukList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<MasWard> ward = new ArrayList<MasWard>();
		List<MasLsg> lsg = new ArrayList<MasLsg>();
		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi extra reference
		int district = 0;
		try {

			if (dataMap.get("district") != null) {
				district = (Integer) dataMap.get("district");
			}
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			ward = session.createCriteria(MasWard.class)
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			lsg = session.createCriteria(MasLsg.class)
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		map.put("ward", ward);
		map.put("talukList", talukList);
		map.put("lsg", lsg);
		return map;

	}

	@Override
	public Map<String, Object> getvilageList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> village = new ArrayList<MasVillage>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		List<MasDistrict> district = new ArrayList<MasDistrict>();

		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int taluk = 0;

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		int stateId = Integer.parseInt(prop.getProperty("stateId"));

		try {
			if (dataMap.get("taluk") != null) {
				taluk = (Integer) dataMap.get("taluk");
			}

			district = session.createCriteria(MasDistrict.class)
					.createAlias("State", "state")
					.add(Restrictions.eq("state.Id", stateId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("DistrictCode")).list();

			village = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.addOrder(Order.asc("VillageName")).list();
			// mappingsList=session.createCriteria(LocationParameterMapping.class).add(Restrictions.isNotNull("Village.Id")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("village", village);
		map.put("district", district);
		map.put("mappingsList", mappingsList);
		return map;
	}

	@Override
	public Map<String, Object> getWardList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWard> ward = new ArrayList<MasWard>();
		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int village = 0;
		try {
			if (dataMap.get("village") != null) {
				village = (Integer) dataMap.get("village");
			}
			ward = session.createCriteria(MasWard.class)
					.createAlias("Lsg", "v")
					.add(Restrictions.eq("v.Id", village))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info(ward.size() + "ward size");;

		map.put("ward", ward);

		return map;
	}

	@Override
	public Map<String, Object> getlocalityList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasLocality> masloc = new ArrayList<PhMasLocality>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		List<LocationParameterMapping> village = new ArrayList<LocationParameterMapping>();
		Session session = (Session) getSession();
		//session = (Session) getSession();

		int hospitalId = 0;
		int subcenterId = 0;
		int taluk = 0;

		int distr = 0;
		int lsgId = 0;
		int wardId = 0;

		int villSubcenterId = 0;
		if (dataMap.get("distr") != null && !dataMap.get("distr").equals("")) {
			distr = Integer.parseInt(dataMap.get("distr").toString());
		}
		if (dataMap.get("lsgId") != null && !dataMap.get("lsgId").equals("")) {
			lsgId = Integer.parseInt(dataMap.get("lsgId").toString());
		}
		if (dataMap.get("wardId") != null && !dataMap.get("wardId").equals("")) {
			wardId = Integer.parseInt(dataMap.get("wardId").toString());
		}

		if (dataMap.get("hospitalId") != null
				&& !dataMap.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(dataMap.get("hospitalId").toString());
		}
		if (dataMap.get("villSubcenterId") != null
				&& !dataMap.get("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(dataMap.get("villSubcenterId")
					.toString());
		}
		if (dataMap.get("subcenterId") != null
				&& !dataMap.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(dataMap.get("subcenterId")
					.toString());
		}
		if (dataMap.get("taluk") != null && !dataMap.get("taluk").equals("")) {
			taluk = Integer.parseInt(dataMap.get("taluk").toString());
		}
		int ward = 0;
		try {
			if (dataMap.get("ward") != null) {
				ward = (Integer) dataMap.get("ward");
			}

			//Added by Arbind for avoid duplication on 04-10-2017
			List<Integer> locationMappingList = session.createCriteria(LocationParameterMapping.class)
					.createAlias("MasDistrict", "dist").createAlias("Ward", "ward")
					.createAlias("Lsg", "lsg").createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id", villSubcenterId))
					.add(Restrictions.eq("lsg.Id", lsgId))
					.add(Restrictions.eq("ward.Id", wardId))
					.add(Restrictions.eq("dist.Id", distr))
					.add(Restrictions.isNotNull("Locality"))
					.setProjection(Projections.property("Locality.Id")).list();

			Criteria crt = session.createCriteria(PhMasLocality.class)
					.createAlias("Ward", "w")
					.add(Restrictions.eq("w.Id", ward))
					.add(Restrictions.eq("Status", "y").ignoreCase());
			if(locationMappingList.size() > 0) {
				crt.add(Restrictions.not(Restrictions.in("Id", locationMappingList)));
			}
			masloc = crt.list();

			village = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Criteria cr = getSession()
				.createCriteria(LocationParameterMapping.class)
				.createAlias("MasDistrict", "dist").createAlias("Ward", "ward")
				.createAlias("Lsg", "lsg")
				.add(Restrictions.eq("lsg.Id", lsgId))
				.add(Restrictions.eq("ward.Id", wardId))
				.add(Restrictions.eq("dist.Id", distr));

		/*
		 * if (subcenterId != 0) { cr.createAlias("Hospital", "h").add(
		 * Restrictions.eq("h.Id", subcenterId)); }
		 */
		if (villSubcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", villSubcenterId));
		}

		mappingsList = cr.list();

		map.put("mappingsList", mappingsList);
		map.put("masloc", masloc);
		map.put("village", village);
		
		return map;
	}

	@Override
	public Map<String, Object> getParalamentList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasParliyamentAssembly> parliament = new ArrayList<PhMasParliyamentAssembly>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();

		int subcenterId = 0;
		int hospitalId = 0;
		int distId = 0;
		if (box.get("hospitalId") != null && !box.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(box.get("hospitalId").toString());
		}
		if (box.get("subcenterId") != null
				&& !box.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(box.get("subcenterId").toString());
		}
		if (null != box.get("disId") && box.getInt("disId") != 0) {
			distId = box.getInt("disId");
		}

		Session session = (Session) getSession();

		Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
				.createAlias("Parliyament", "par")
				.add(Restrictions.isNotNull("Parliyament"));
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		}
		if(distId != 0) {
			cr.createAlias("par.District", "dis").add(Restrictions.eq("dis.Id", distId));
		}
		mappingsList = cr.list();
		//Added by Arbind for avoid duplication on 04-10-2017
		List<Integer> phMasLocalityId = cr.setProjection(Projections.property("Parliyament.Id")).list();
		Criteria crt = session.createCriteria(PhMasParliyamentAssembly.class)
				.createAlias("District", "d")
				.add(Restrictions.eq("d.Id", box.getInt("disId")))
				.add(Restrictions.eq("Category", "p").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if(phMasLocalityId.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
		}
		parliament = crt.list();

		/*if (box.getInt("disId") != 0) {
			cr.createAlias("MasDistrict", "district").add(Restrictions.eq("district.Id", box.getInt("disId")));
		}*/

		map.put("parliament", parliament);
		map.put("mappingsList", mappingsList);
		return map;
	}

	@Override
	public Map<String, Object> getAssamblyList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		List<PhMasParliyamentAssembly> parliament = new ArrayList<PhMasParliyamentAssembly>();
		Session session = (Session) getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		int distId = 0;
		if (box.get("hospitalId") != null && !box.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(box.get("hospitalId").toString());
		}
		if (box.get("subcenterId") != null
				&& !box.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(box.get("subcenterId").toString());
		}
		if (null != box.get("disId") && box.getInt("disId") != 0) {
			distId = box.getInt("disId");
		}

		Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
				.createAlias("Assembly", "asm")
				.add(Restrictions.isNotNull("Assembly"));
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		}
		if(distId != 0) {
			cr.createAlias("asm.District", "dis").add(Restrictions.eq("dis.Id", distId));
		}
		mappingsList = cr.list();
		//Added by Arbind for avoid duplication on 04-10-2017
		List<Integer> phMasLocalityId = cr.setProjection(Projections.property("Assembly.Id")).list();
		Criteria crt = session.createCriteria(PhMasParliyamentAssembly.class)
				.createAlias("District", "d")
				.add(Restrictions.eq("d.Id", box.getInt("disId")))
				.add(Restrictions.eq("Category", "A").ignoreCase())
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if(phMasLocalityId.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
		}
		parliament = crt.list();

		map.put("parliament", parliament);
		map.put("mappingsList", mappingsList);
		return map;
	}

	@Override
	public Map<String, Object> getLsgiList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		List<MasLsg> masLsg = new ArrayList<MasLsg>();
		Session session = (Session) getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		if (box.get("hospitalId") != null && !box.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(box.get("hospitalId").toString());
		}
		if (box.get("subcenterId") != null
				&& !box.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(box.get("subcenterId").toString());
		}

		masLsg = session.createCriteria(MasLsg.class)
				.createAlias("District", "d")
				.add(Restrictions.eq("d.Id", box.getInt("disId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		Criteria cr = getSession().createCriteria(
				LocationParameterMapping.class);
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", hospitalId));
		}

		mappingsList = cr.list();
		map.put("masLsg", masLsg);
		map.put("mappingsList", mappingsList);
		return map;
	}

	@Override
	public Map<String, Object> getElectrickSectionList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		List<PhMasElectricalSection> masElSection = new ArrayList<PhMasElectricalSection>();
		Session session = (Session) getSession();

		int subcenterId = 0;
		int hospitalId = 0;
		if (box.get("hospitalId") != null && !box.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(box.get("hospitalId").toString());
		}
		if (box.get("subcenterId") != null
				&& !box.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(box.get("subcenterId").toString());
		}

		masElSection = session.createCriteria(PhMasElectricalSection.class)
				.createAlias("Village", "v")
				.add(Restrictions.eq("v.Id", box.getInt("village")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		Criteria cr = getSession().createCriteria(
				LocationParameterMapping.class);
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", hospitalId));
		}

		mappingsList = cr.list();
		map.put("mappingsList", mappingsList);
		map.put("masElSection", masElSection);
		return map;
	}

	@Override
	public Map<String, Object> getPostOfficeList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPostCode> maspostCode = new ArrayList<MasPostCode>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		Session session = (Session) getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		int distId = 0;
		if (box.get("hospitalId") != null && !box.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(box.get("hospitalId").toString());
		}
		if (box.get("subcenterId") != null
				&& !box.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(box.get("subcenterId").toString());
		}
		if (null != box.get("disId") && box.getInt("disId") != 0) {
			distId = box.getInt("disId");
		}

		Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
				.createAlias("PostCode", "post")
				.add(Restrictions.isNotNull("PostCode"));
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
		}
		if(distId != 0) {
			cr.createAlias("post.DistrictId", "dis").add(Restrictions.eq("dis.Id", distId));
		}
		mappingsList = cr.list();
		//Added by Arbind for avoid duplication on 05-10-2017
		List<Integer> phMasLocalityId = cr.setProjection(Projections.property("PostCode.Id")).list();
		Criteria crt = session.createCriteria(MasPostCode.class)
				.createAlias("DistrictId", "d")
				.add(Restrictions.eq("d.Id", box.getInt("disId")))
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if(phMasLocalityId.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
		}
		maspostCode = crt.list();

		map.put("mappingsList", mappingsList);
		map.put("maspostCode", maspostCode);
		return map;
	}

	@Override
	public Map<String, Object> saveIntoLocationParameter(
			LocationParameterMapping locmaPing) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saveFlag = false;
		boolean duplicateStatus = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Session session = (Session) getSession();

			int districtId = 0;
			int talukId = 0;
			int hospitalIdforvillageMapping = 0;
			int villageId = 0;

			hospitalIdforvillageMapping = locmaPing.getHospital().getId();
			if (null != locmaPing.getMasDistrict()) {
				districtId = locmaPing.getMasDistrict().getId();
			}
			if (null != locmaPing.getMasTaluk()) {
				talukId = locmaPing.getMasTaluk().getId();
			}
			if (null != locmaPing.getVillage())
				villageId = locmaPing.getVillage().getId();

			// checking for Duplicate
			List results = null;
			Query query = null;
			if (villageId > 0 && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where Village.Id = :villId and MasTaluk.Id= :talukId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("villId", villageId);
				//query.setParameter("distId", districtId);
				query.setParameter("talukId", talukId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int lsg = 0;
			int wardId = 0;
			int locality = 0;
			if (null != locmaPing.getLsg()) {
				lsg = locmaPing.getLsg().getId();
			}
			if (null != locmaPing.getWard()) {
				wardId = locmaPing.getWard().getId();
			}
			if (null != locmaPing.getLocality()) {
				locality = locmaPing.getLocality().getId();
			}

			if (wardId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where Ward.Id = :wardId and MasDistrict.Id= :distId and Lsg.Id= :lsgId and Locality.Id= :localityId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("wardId", wardId);
				query.setParameter("distId", districtId);
				query.setParameter("lsgId", lsg);
				query.setParameter("localityId", locality);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int electricSectionId = 0;
			if (null != locmaPing.getElectricalSection()) {
				electricSectionId = locmaPing.getElectricalSection().getId();
			}

			if (electricSectionId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where ElectricalSection.Id = :electricId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("electricId", electricSectionId);
				//query.setParameter("distId", districtId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int postofficeId = 0;
			if (null != locmaPing.getPostCode()) {
				postofficeId = locmaPing.getPostCode().getId();
			}

			if (postofficeId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where PostCode.Id = :postcodeId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("postcodeId", postofficeId);
				//query.setParameter("distId", districtId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int subcentreId = 0;
			if (null != locmaPing.getSubCentre()) {
				subcentreId = locmaPing.getSubCentre().getId();
			}

			if (subcentreId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where SubCentre.Id = :subcenterId   and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("subcenterId", subcentreId);

				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int parliamentId = 0;
			if (null != locmaPing.getParliyament()) {
				parliamentId = locmaPing.getParliyament().getId();
			}

			if (parliamentId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where Parliyament.Id = :parliyamentId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("parliyamentId", parliamentId);
				//query.setParameter("distId", districtId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int assemblyId = 0;
			if (null != locmaPing.getAssembly()) {
				assemblyId = locmaPing.getAssembly().getId();
			}

			if (assemblyId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where Assembly.Id = :assemblyId and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("assemblyId", assemblyId);
				//query.setParameter("distId", districtId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			int basicSectionId = 0;
			if (null != locmaPing.getBasicSection()) {
				basicSectionId = locmaPing.getBasicSection().getId();
			}
			
			if (basicSectionId > 0  && hospitalIdforvillageMapping > 0) {
				String hql = "from LocationParameterMapping where BasicSection.Id = :basicSectionId  and Hospital.Id= :hosp";
				query = session.createQuery(hql);
				query.setParameter("basicSectionId", basicSectionId);
				// query.setParameter("distId", districtId);
				query.setParameter("hosp", hospitalIdforvillageMapping);
			}

			results = query.list();

			//
			if (results.size() == 0) {
				hbt.save(locmaPing);
				hbt.flush();
				hbt.clear();
				saveFlag = true;
			} else {
				saveFlag = true;
				duplicateStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("saveFlag", saveFlag);
		map.put("duplicateStatus", duplicateStatus);
		return map;
	}

	@Override
	public Map<String, Object> getDistrictList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("masDistrict", masDistrict);

		return map;

	}

	@Override
	public Map<String, Object> getDistrictForAssamblyList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	@Override
	public Map<String, Object> getDistrictForLsgList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	@Override
	public Map<String, Object> getDistrictForElectricalSecList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	@Override
	public Map<String, Object> getDistrictForPostOfficeList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("DistrictCode")).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	@Override
	public Map<String, Object> showPublicHealthHouseSurveyJsp(Box box,
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhHouseSurvey> phHouseSurveys = new ArrayList<PhHouseSurvey>();
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String[] scbasic = { "FWC", "BS" };
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		int page = (Integer) details.get("page");
		Criteria houseSurvey = session.createCriteria(PhHouseSurvey.class)
								.createAlias("Hospital", "hos");
		//Changed by Arbind on 30-06-2017 for search and hospital wise
		if(box.getString("chcphc").equals("") && box.getString("district").equals("") && box.getString("base").equals("")){
			houseSurvey = houseSurvey.add(Restrictions.eq("hos.Id", box.getInt("hospitalId")));
		}
		if (box.getInt("district") != 0 && !box.getString("district").equals("0")) {
			houseSurvey = houseSurvey.createAlias("hos.District", "dis").add(Restrictions.eq("dis.Id", box.getInt("district")));
		}
		if (box.getString("fromDate") != "" && box.getString("toDate") != "") {
			houseSurvey = houseSurvey.add(Restrictions.between("HouseSurveyDate", 
					HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")), 
					HMSUtil.convertStringTypeDateToDateType(box.getString("toDate"))));
		}
		if (box.getString("village") != null && !box.getString("village").equals("")) {
			houseSurvey = houseSurvey.createAlias("Village", "v").add(Restrictions.eq("v.VillageName", box.getString("village")));
		}
		if (box.getString("houseNo") != null && !box.getString("houseNo").equals("")) {
			houseSurvey = houseSurvey.add(Restrictions.eq("LsgHouseNo",	box.getString("houseNo")));
		}
		
		if (box.getInt("ward") != 0 && !box.getString("ward").equals("0")) {
			houseSurvey = houseSurvey.createAlias("Ward", "w").add(Restrictions.eq("w.Id", box.getInt("ward")));
		}
		if (box.getInt("localityId") != 0 && !box.getString("localityId").equals("0")) {
			houseSurvey = houseSurvey.createAlias("Locality", "l").add(
					Restrictions.eq("l.Id", box.getInt("localityId")));
		}
		if (box.getInt("chcphc") != 0 && !(box.getString("chcphc").equals("0"))) {
			houseSurvey = houseSurvey.add(Restrictions.eq("hos.ParentInstitute.Id", box.getInt("chcphc")));
		}
		if (box.getInt("base") != 0 && !(box.getString("base").equals("0"))) {
			houseSurvey = houseSurvey.add(Restrictions.eq("hos.Id", box.getInt("base")));
		}

		noOfRecords = houseSurvey.list().size();
		houseSurvey.setFirstResult((page - 1)*recordsPerPage);
		houseSurvey.setMaxResults(recordsPerPage);
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		phHouseSurveys = houseSurvey.list();
		

		List<MasWard> ward = new ArrayList<MasWard>();
		ward = session.createCriteria(MasWard.class)
				.createAlias("District", "dist")
				.add(Restrictions.eq("dist.Id", box.getInt("districtId")))
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		chcList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				.add(Restrictions.in("SubCentre.InstituteTypeShortName",
						scbasic))
				.add(Restrictions.eq("ParentInstitute.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("chcList", chcList);
		map.put("ward", ward);
		map.put("phHouseSurveys", phHouseSurveys);
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		return map;
	}

	@Override
	public Map<String, Object> phFamilySurveys(Box box,
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhFamilySurvey> phFamilySurveys = new ArrayList<PhFamilySurvey>();
		Criteria familySurvey = getSession().createCriteria(
				PhFamilySurvey.class);
		if (box.getString("requestId") != "") {
			familySurvey = familySurvey.add(Restrictions.eq("HouseId",
					box.getString("requestId")));
		}
		if (box.getString("familyName") != "") {
			familySurvey = familySurvey.add(Restrictions.like("FamilyName",
					box.getString("familyName")));
		}
		if (box.getString("rationCard") != "") {
			familySurvey = familySurvey.add(Restrictions.eq("RationCardNo",
					box.getString("rationCard")));
		}
		if (box.getString("contact") != "") {
			familySurvey = familySurvey.add(Restrictions.eq("ContactNo",
					box.getString("contact")));
		}
		phFamilySurveys = familySurvey.list();
		map.put("phFamilySurveys", phFamilySurveys);
		return map;
	}

	@Override
	public Map<String, Object> updateInlocationParameter(
			LocationParameterMapping locmaPingMap, Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saveFlag = false;

		int wardId = 0;
		String basicSec = "";
		int distr = 0;
		int lsgId = 0;
		int villSubcenterId = 0;
		int talukId = 0;

		if (null != dataMap.get("wardId"))
			wardId = (Integer) dataMap.get("wardId");

		if (null != dataMap.get("talukId"))
			talukId = (Integer) dataMap.get("talukId");

		if (null != dataMap.get("distr"))
			distr = (Integer) dataMap.get("distr");
		if (null != dataMap.get("lsgId"))
			lsgId = (Integer) dataMap.get("lsgId");
		villSubcenterId = (Integer) dataMap.get("villSubcenterId");
		basicSec = (String) dataMap.get("basicSec");

		try {

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Session session = (Session) getSession();

			if (null != basicSec && basicSec.equals("")) {
				LocationParameterMapping obj = (LocationParameterMapping) hbt
						.get(LocationParameterMapping.class,
								locmaPingMap.getId());
				// hbt.delete(obj);
			}

			if (basicSec.equals("basicSec")) {
				Query query = session
						.createQuery("delete LocationParameterMapping where hospital_id = :ID and basic_section_id =:basicSectionId  ");
				query.setParameter("ID", villSubcenterId);
				query.setParameter("basicSectionId", locmaPingMap.getId());

				int result = query.executeUpdate();
			} else if (basicSec.equals("subcenterdelete")) {
				Query query = session
						.createQuery("delete LocationParameterMapping where sub_centre_id =:subcentreid  ");
				// query.setParameter("ID", villSubcenterId);
				
				query.setParameter("subcentreid", locmaPingMap.getId());

				int result = query.executeUpdate();
			} else if (basicSec.equals("localilty")) {
				Query query = session
						.createQuery("delete LocationParameterMapping where hospital_id = :ID and locality_id =:locality and lsg_id =:lsg and mas_district_id =:district and ward_id= :ward");
				query.setParameter("ID", villSubcenterId);
				query.setParameter("locality", locmaPingMap.getId());
				query.setParameter("lsg", lsgId);
				query.setParameter("district", distr);
				query.setParameter("ward", wardId);

				int result = query.executeUpdate();
			}

			//DistrictId removed by Arbind on 04-10-2017
			else if (basicSec.equals("parliyament")) {
				Query query = session.createQuery("delete LocationParameterMapping where hospital_id = :ID and parliyament_id= :parliyament");
						/*.createQuery("delete LocationParameterMapping where hospital_id = :ID  and mas_district_id =:district and parliyament_id= :parliyament");*/
				query.setParameter("ID", villSubcenterId);
				query.setParameter("parliyament", locmaPingMap.getId());

				//query.setParameter("district", distr);

				int result = query.executeUpdate();
			} else if (basicSec.equals("Assemebly")) {
				Query query = session.createQuery("delete LocationParameterMapping where hospital_id = :ID and assembly_id= :assembly");
						/*.createQuery("delete LocationParameterMapping where hospital_id = :ID  and mas_district_id =:district and assembly_id= :assembly");*/
				query.setParameter("ID", villSubcenterId);
				query.setParameter("assembly", locmaPingMap.getId());

				//query.setParameter("district", distr);

				int result = query.executeUpdate();
			} else if (basicSec.equals("postOffice")) {
				Query query = session.createQuery("delete LocationParameterMapping where hospital_id = :ID and post_code_id= :postCodeId");
						/*.createQuery("delete LocationParameterMapping where hospital_id = :ID  and mas_district_id =:district and post_code_id= :postCodeId");*/
				query.setParameter("ID", villSubcenterId);
				query.setParameter("postCodeId", locmaPingMap.getId());

				//query.setParameter("district", distr);

				int result = query.executeUpdate();
			} else if (basicSec.equals("electricSection")) {
				Query query = session.createQuery("delete LocationParameterMapping where hospital_id = :ID and electrical_section_id= :electricalSection");
						/*.createQuery("delete LocationParameterMapping where hospital_id = :ID  and mas_district_id =:district and electrical_section_id= :electricalSection");*/
				query.setParameter("ID", villSubcenterId);
				query.setParameter("electricalSection", locmaPingMap.getId());

				//query.setParameter("district", distr);

				int result = query.executeUpdate();
			} else if (basicSec.equals("village")) {
				Query query = session.createQuery("delete LocationParameterMapping where hospital_id = :ID and mas_taluk_id =:taluk and village_id= :village");
						/*.createQuery("delete LocationParameterMapping where hospital_id = :ID and mas_taluk_id =:taluk and mas_district_id =:district and village_id= :village");*/
				query.setParameter("ID", villSubcenterId);
				query.setParameter("village", locmaPingMap.getId());
				query.setParameter("taluk", talukId);
				//query.setParameter("district", distr);

				int result = query.executeUpdate();
			}

			// electricSection
			
			hbt.flush();
			hbt.clear();
			saveFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("saveFlag", saveFlag);
		return map;
	}

	@Override
	public Map<String, Object> phEligibleCouple(Box box,
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMemberSurvey> phEligbleCoupleRegs = new ArrayList<PhMemberSurvey>();
		Criteria eligibleCouple = getSession().createCriteria(
				PhMemberSurvey.class);
		if (box.getString("requestId") != "") {
			eligibleCouple = eligibleCouple.add(Restrictions.eq("FamilyId",
					box.getInt("requestId")));
		}
		phEligbleCoupleRegs = eligibleCouple.list();
		map.put("phEligbleCoupleRegs", phEligbleCoupleRegs);
		return map;
	}

	@Override
	public Map<String, Object> getTalukForElSectionList(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<PhMasElectricalSection> electricSectionList = new ArrayList<PhMasElectricalSection>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();

		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi unused reference
		int district = 0;
		int hospitalId = 0;
		try {

			if (dataMap.get("district") != null) {
				district = (Integer) dataMap.get("district");
			}

			if (dataMap.get("hospitalId") != null) {
				hospitalId = (Integer) dataMap.get("hospitalId");
			}
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			
			Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
					.createAlias("ElectricalSection", "es")
					.add(Restrictions.isNotNull("ElectricalSection"));
			if (hospitalId != 0) {
				cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", hospitalId));
			}
			if(district != 0) {
				cr.createAlias("es.District", "dis").add(Restrictions.eq("dis.Id", district));
			}
			phMasLocalityList = cr.list();
			//Added by Arbind for avoid duplication on 04-10-2017
			List<Integer> phMasLocalityId = cr.setProjection(Projections.property("ElectricalSection.Id")).list();
			Criteria crt = session.createCriteria(PhMasElectricalSection.class)
					.createAlias("District", "d")
					.add(Restrictions.eq("d.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase());
			if(phMasLocalityId.size() > 0) {
				crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
			}
			electricSectionList = crt.list();

			/*electricSectionList = session
					.createCriteria(PhMasElectricalSection.class)
					.createAlias("District", "District")
					.add(Restrictions.eq("District.Id", district)).list();

			Criteria cr = getSession().createCriteria(
					LocationParameterMapping.class);

			if (hospitalId != 0) {
				cr.createAlias("Hospital", "h").add(
						Restrictions.eq("h.Id", hospitalId));
			}
			phMasLocalityList = cr.list();

			map.put("phMasLocalityList", phMasLocalityList);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		map.put("talukList", talukList);
		map.put("phMasLocalityList", phMasLocalityList);
		map.put("electricSectionList", electricSectionList);
		return map;

	}

	@Override
	public Map<String, Object> getvilageElSectionList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> village = new ArrayList<MasVillage>();
		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi unused reference
		int taluk = 0;
		try {
			if (dataMap.get("taluk") != null) {
				taluk = (Integer) dataMap.get("taluk");
			}
			village = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		map.put("village", village);

		return map;
	}

	// -----------------------------Village Survey------------------------

	@Override
	public Map<String, Object> showPublicHealthVillageSurveyJsp(
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhVillageSurvey> villageSurveys = new ArrayList<PhVillageSurvey>();
		List<PhMasOrgCategory> phOrgCata = new ArrayList<PhMasOrgCategory>();
		List<PhMasOrgCategory> phOrgCataList = new ArrayList<PhMasOrgCategory>();

		Criteria cr = getSession().createCriteria(PhVillageSurvey.class);
		Criteria crForSurvey = getSession()
				.createCriteria(PhMasOrgCategory.class)
				.add(Restrictions.eq("Type", "VMI"))
				.add(Restrictions.eq("Status", "y").ignoreCase());
		Criteria crforVoc = getSession().createCriteria(PhMasOrgCategory.class)
				.add(Restrictions.eq("Type", "VOC"))
				.add(Restrictions.eq("Status", "y").ignoreCase());

		villageSurveys = cr.list();
		phOrgCata = crForSurvey.list();
		phOrgCataList = crforVoc.list();

		map.put("villageSurveys", villageSurveys);
		map.put("phOrgCata", phOrgCata);
		map.put("phOrgCataList", phOrgCataList);
		return map;

	}

	@Override
	public Map<String, Object> searChPublicHealthVillageSurveyJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhVillageSurvey> villageDetail = new ArrayList<PhVillageSurvey>();
		Session session = (Session) getSession();
		int idFor = (Integer) box.getInt("survey");
		map.put("idFor", idFor);
		Long hospitalId = box.getLong("hospitalId");
		Criteria cr = session.createCriteria(PhVillageSurvey.class)
				.add(Restrictions.eq("HospitalId", hospitalId));
		//villageDetail = cr.list();
		if (box.getString("fromDate") != "" && box.getString("toDate") != "") {
			cr.add(Restrictions.between("SurveyDate",
					HMSUtil.convertStringTypeDateToDateType(box
							.getString("fromDate")), HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("toDate"))));
		}
		if (!box.getString("survey").equals("")) {
			cr.add(Restrictions.eq("SurveyType", box.getInt("survey")));
		}
		if (box.getString("clinical") != null && !box.getString("clinical").equals("")) {
			cr.add(Restrictions.eq("Type", box.getString("clinical")));
		}

		if (!box.getString("cli").equals("")) {
			cr.add(Restrictions.eq("CategoryCode", box.getString("cli")));
		}

		villageDetail = cr.list();
		
		
		map.put("villageDetail", villageDetail);

		return map;
	}

	@Override
	public Map<String, Object> getMonthsForApprve(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhAtpJphnJhiHeader> atpJphnJhiHeaders = new ArrayList<PhAtpJphnJhiHeader>();
		String month = (String) dataMap.get("monthValue");
		Criteria cr = session.createCriteria(PhAtpJphnJhiHeader.class).add(
				Restrictions.eq("ForMonth", month));

		atpJphnJhiHeaders = cr.list();
		map.put("atpJphnJhiHeaders", atpJphnJhiHeaders);
		return map;
	}

	@Override
	public Map<String, Object> getDetailByName(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhAtpJphnJhiHeader> atpJphnJhiHeder = new ArrayList<PhAtpJphnJhiHeader>();
		List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
		int apprBy = box.getInt("nameId");

		String qry = "select ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,count(pdbd.survey_id), ajjd.supervision,me.emp_name,ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity from ph_day_block pdb left outer join ph_day_block_detail pdbd ON pdb.day_id=pdbd.day_id left outer join ph_atp_jphn_jhi_details ajjd ON ajjd.day_block_id=pdb.day_id left outer join ph_atp_jphn_jhi_header ajjh ON ajjh.atp_header_id= ajjd.atp_header_id left outer join ph_mas_locality pml ON pml.locality_id=pdbd.locality_id left outer join mas_ward mw ON mw.ward_id=pdbd.ward_id left outer join mas_employee me ON me.employee_id = ajjh.asha_worker where ajjh.asha_worker="
				+ apprBy
				+ " group by ajjd.atp_details_id ,ajjh.atp_header_id,pdb.day_id,pdb.for_day,mw.ward_name,pml.locality_name,ajjd.date_atp,ajjd.supervision,me.emp_name, ajjd.routine_activity,ajjd.other_activity,ajjd.after_noon_activity";

		phAtpJphnJhiDetailsList = (List) session.createSQLQuery(qry).list();

		map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);

		return map;
	}

	// ------------ Mapping -------------------
	@Override
	public Map<String, Object> getDistrictBesickSectionList(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	public Map<String, Object> getBesicSectionlist(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
		List<MasHospital> basicSectionList = new ArrayList<MasHospital>();
		int subcenterId = 0;
		int hospitalId = 0;
		if (dataMap.get("hospitalId") != null
				&& !dataMap.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(dataMap.get("hospitalId").toString());
		}
		if (dataMap.get("subcenterId") != null
				&& !dataMap.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(dataMap.get("subcenterId")
					.toString());
		}

		Session session = (Session) getSession();
		basicSectionList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "basicSection")
				/*
				 * .add(Restrictions.eq("basicSection.HospitalTypeName",
				 * "Basic Section"))
				 */
				.add(Restrictions.eq("basicSection.Id", 2))
				.add(Restrictions.eq("ParentInstitute.Id", dataMap.get("phcId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		Criteria cr = getSession().createCriteria(
				LocationParameterMapping.class);
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", hospitalId));
		}
		phMasLocalityList = cr.list();

		map.put("basicSectionList", basicSectionList);
		map.put("phMasLocalityList", phMasLocalityList);

		return map;

	}

	public Map<String, Object> getSubcenterList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
		int subcenterId = 0;
		int hospitalId = 0;
		if (dataMap.get("hospitalId") != null
				&& !dataMap.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(dataMap.get("hospitalId").toString());
		}
		if (dataMap.get("subcenterId") != null
				&& !dataMap.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(dataMap.get("subcenterId")
					.toString());
		}
		int villSubcenterId = 0;
		if (dataMap.get("villSubcenterId") != null
				&& !dataMap.get("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(dataMap.get("villSubcenterId").toString());
		}

		Session session = (Session) getSession();
		//Added by Arbind for avoid duplication on 04-10-2017
		List<Integer> phMasLocalityId = session.createCriteria(LocationParameterMapping.class)
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", villSubcenterId))
						.add(Restrictions.isNotNull("SubCentre"))
						.setProjection(Projections.property("SubCentre.Id")).list();

		Criteria crt = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				.add(Restrictions.eq("SubCentre.Id", 1))
				.add(Restrictions.eq("ParentInstitute.Id", (Integer) (dataMap.get("hospialIdphcCHC"))))
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if(phMasLocalityId.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
		}
		subcenterList = crt.list();
		
		logger.info("subcenterList " + subcenterList.size());
		Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
				.add(Restrictions.isNotNull("SubCentre"));
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", subcenterId));
		}
		if (villSubcenterId != 0) {
			cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", villSubcenterId));
			phMasLocalityList = cr.list();
		}

		logger.info("phMasLocalityList " + phMasLocalityList.size());
		map.put("subcenterList", subcenterList);
		map.put("phMasLocalityList", phMasLocalityList);

		return map;
	}

	@Override
	public Map<String, Object> getMonthsAndVisit(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhAtpJphnJhiHeader> atpJphnJhiHeaders = new ArrayList<PhAtpJphnJhiHeader>();
		String month = (String) dataMap.get("monthValue");
		Criteria cr = session.createCriteria(PhAtpJphnJhiHeader.class).add(
				Restrictions.eq("ForMonth", month));

		atpJphnJhiHeaders = cr.list();
		map.put("atpJphnJhiHeaders", atpJphnJhiHeaders);
		return map;
	}

	@Override
	public Map<String, Object> getlistbyVisit(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhAtpJphnJhiDetails> atpJphnJhiDetails = new ArrayList<PhAtpJphnJhiDetails>();
		String month = (String) box.getString("atpJphniJhiMonths");
		int nameId = (Integer) box.getInt("nameId");
		String superVision = (String) box.getString("clinical");
		Criteria cr = session.createCriteria(PhAtpJphnJhiDetails.class)
				.add(Restrictions.eq("Supervision", superVision))
				.createAlias("AtpHeader", "ah")
				.add(Restrictions.eq("ah.ForMonth", month))
				.createAlias("ah.AshaWorker", "e")
				.add(Restrictions.eq("e.Id", nameId));

		atpJphnJhiDetails = cr.list();

		/*for (PhAtpJphnJhiDetails vf : atpJphnJhiDetails) {
			System.out.println(vf.getAtpHeader().getAshaWorker()
					.getEmployeeName());
			System.out.println(vf.getDateAtp());
		}*/

		map.put("atpJphnJhiDetails", atpJphnJhiDetails);
		return map;
	}

	@Override
	public Map<String, Object> submitStatus(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();

			Vector status = box.getVector("status");
			Vector detId = box.getVector("detId");
			for (int i = 0; i < status.size(); i++) {
				PhAtpJphnJhiDetails phAtpJphnJhihDetails = (PhAtpJphnJhiDetails) hbt
						.load(PhAtpJphnJhiDetails.class,
								Integer.parseInt(detId.get(i).toString()));

				if (status.get(i) != "") {
					phAtpJphnJhihDetails.setObservationStatus(status.get(i)
							.toString());
				}

				hbt.update(phAtpJphnJhihDetails);
			}

			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> submitHSAndMOapproval(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();

			Vector detId = box.getVector("detId");
			Vector headerId = box.getVector("hdrId");

			for (int i = 0; i < detId.size(); i++) {
				PhAtpJphnJhiHeader phAtpJphnJhiHeader = (PhAtpJphnJhiHeader) hbt
						.load(PhAtpJphnJhiHeader.class,
								Integer.parseInt(headerId.get(i).toString()));

				MasEmployee masEmployee2 = new MasEmployee();
				masEmployee2.setId(box.getInt("empId"));
				phAtpJphnJhiHeader.setHiMo(masEmployee2);

				hbt.update(phAtpJphnJhiHeader);

			}
			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		map.put("saved", saved);

		return map;
	}

	@Override
	public Map<String, Object> showAshaWorker(Map<String, Object> datamap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmp = new ArrayList<MasEmployee>();
		int hospitalId = 0;
		int empId = 0;
		if (datamap.get("hospitalId") != null) {
			hospitalId = (Integer) datamap.get("hospitalId");
		}

		if (datamap.get("empId") != null) {
			empId = (Integer) datamap.get("empId");
		}

		Session session = (Session) getSession();
		Criteria cr = session.createCriteria(MasEmployee.class)
				.createAlias("EmpCategory", "Catogry")
				.add(Restrictions.eq("Catogry.EmpCategoryName", "Asha Worker"))
				.createAlias("Hospital", "h")
				.add(Restrictions.eq("h.Id", hospitalId))
				.add(Restrictions.eq("LineManager.Id", empId));
		masEmp = cr.list();

		map.put("masEmp", masEmp);

		return map;
	}

	@Override
	public Map<String, Object> getAshaworkerDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmpDetail = new ArrayList<MasEmployee>();
		List<HrEmployeeAddress> empAdd = new ArrayList<HrEmployeeAddress>();
		Session session = (Session) getSession();
		Criteria cr = session.createCriteria(MasEmployee.class).add(
				Restrictions.eq("Id", box.getInt("ashaId")));

		Criteria crAdd = session.createCriteria(HrEmployeeAddress.class)
				.createAlias("AddressType", "type")
				.add(Restrictions.eq("type.AddressTypeCode", "P"))
				.createAlias("Employee", "emp")
				.add(Restrictions.eq("emp.Id", box.getInt("ashaId")));

		masEmpDetail = cr.list();
		empAdd = crAdd.list();

		map.put("masEmpDetail", masEmpDetail);
		map.put("empAdd", empAdd);
		return map;
	}

	@Override
	public Map<String, Object> getRegistrationDetail(Box box) {

		return null;
	}

	@Override
	public Map<String, Object> getBirthRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhBirthDeathReg> empAdd = new ArrayList<PhBirthDeathReg>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		int empId = box.getInt("empId");

		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session
				.createCriteria(PhBirthDeathReg.class)
				.add(Restrictions.eq("RegType", "birth"))
				.add(Restrictions.between("DobDeathDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));

		empAdd = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);
		memId = crMem.list();


		map.put("empAdd", empAdd);
		map.put("memId", memId);

		return map;
	}

	@Override
	public Map<String, Object> getDeathRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhBirthDeathReg> empAdd = new ArrayList<PhBirthDeathReg>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		Session session = (Session) getSession();

		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria crMem = session.createCriteria(PhMemberSurvey.class);
		Criteria cr = session
				.createCriteria(PhBirthDeathReg.class)
				.add(Restrictions.eq("RegType", "death"))
				.add(Restrictions.between("DobDeathDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));

		memId = crMem.list();
		empAdd = cr.list();


		map.put("empAdd", empAdd);
		map.put("memId", memId);

		return map;

	}

	@Override
	public Map<String, Object> getAncRegistration(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<PhAncSurvey> ancRe = new ArrayList<PhAncSurvey>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session.createCriteria(PhAncSurvey.class).add(
				Restrictions.between("RegDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));

		ancRe = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);

		memId = crMem.list();


		map.put("ancRe", ancRe);
		map.put("memId", memId);

		return map;

	}

	@Override
	public Map<String, Object> getEcRegistration(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<PhAntenatalRegistrationSurvey> phAnti = new ArrayList<PhAntenatalRegistrationSurvey>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session.createCriteria(
				PhAntenatalRegistrationSurvey.class).add(
				Restrictions.between("RegDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));
		phAnti = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);

		memId = crMem.list();


		map.put("phAnti", phAnti);
		map.put("memId", memId);

		return map;
	}

	@Override
	public Map<String, Object> getFamilyPalRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhFamilyPlaningReg> phFP = new ArrayList<PhFamilyPlaningReg>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session.createCriteria(PhFamilyPlaningReg.class).add(
				Restrictions.between("",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));
		phFP = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);

		memId = crMem.list();


		map.put("phFP", phFP);
		map.put("memId", memId);

		return map;
	}

	@Override
	public Map<String, Object> getCDRRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhDiseaseRegistration> phComm = new ArrayList<PhDiseaseRegistration>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		int empId = box.getInt("empId");

		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session
				.createCriteria(PhDiseaseRegistration.class)
				.add(Restrictions.eq("DiseaseType", "cd"))
				.add(Restrictions.between("RegDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));

		phComm = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);
		memId = crMem.list();


		map.put("phComm", phComm);
		map.put("memId", memId);

		return map;
	}

	@Override
	public Map<String, Object> getNonCDRRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhDiseaseRegistration> phNonComm = new ArrayList<PhDiseaseRegistration>();
		List<PhMemberSurvey> memId = new ArrayList<PhMemberSurvey>();
		int empId = box.getInt("empId");

		Session session = (Session) getSession();
		String numberOfDays = HMSUtil.countNoOfDays(box.get("year") + "",
				box.get("month") + "");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String todate = numberOfDays + "/" + box.get("month") + "/"
				+ box.get("year");

		Criteria cr = session
				.createCriteria(PhDiseaseRegistration.class)
				.add(Restrictions.eq("DiseaseType", "ncd"))
				.add(Restrictions.between("RegDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate),
						HMSUtil.convertStringTypeDateToDateType(todate)));

		phNonComm = cr.list();
		Criteria crMem = session.createCriteria(PhMemberSurvey.class);
		memId = crMem.list();


		map.put("phNonComm", phNonComm);
		map.put("memId", memId);

		return map;
	}

	// --------------- Report -----------------

	@Override
	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> connectionMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		connectionMap.put("con", con);
		return connectionMap;
	}

	@Override
	public Map<String, Object> runDilevery_detail_Procedure(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		Session session = (Session) getSession();
		try {
			java.sql.Connection con = session.connection();
			String sql = "";
			sql = "{call del_rpt('" + hospitalId + "')}";

			try {
				if (sql != "") {
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> runDelivryPlaceProcedure(String fromDate, String toDate) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		Session session = (Session) getSession();
		try {
			java.sql.Connection con = session.connection();
			String sql = "";
			sql = "{call del_place_rpt('" + fromDate + "'," + "'" + toDate + "')}";

			try {
				if (sql != "") {
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		map.put("flag", flag);
		return map;

	}

	public Map<String, Object> getDistrictList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		List<MasDeliveryType> deliveryTypeList = new ArrayList<MasDeliveryType>();
		Session session = (Session) getSession();
		masDistrict = session.createCriteria(MasDistrict.class)
				.createAlias("State", "state")
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("state.Id", 32)).list();
		map.put("masDistrict", masDistrict);
		genderList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("genderList", genderList);
		deliveryTypeList = session.createCriteria(MasDeliveryType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("deliveryTypeList", deliveryTypeList);

		return map;
	}
	
	@Override
	public Map<String, Object> getchclist(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		List<MasHospital> phcList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi unused reference
		String[] phc = { "PHC", "24x7 PHC" };
		Vector dist = box.getVector("district");
		int district = 0;

		try {
			if ("chc".equalsIgnoreCase(dist.get(0).toString())) {
				district = Integer.parseInt(dist.get(1).toString().trim());
			}
			if ("chc".equalsIgnoreCase(dist.get(0).toString())) {

				chcList = session
						.createCriteria(MasHospital.class)
						.createAlias("HospitalType", "SubCentre")
						.add(Restrictions.eq(
								"SubCentre.InstituteTypeShortName", "CHC"))
						.createAlias("District", "dis")
						.add(Restrictions.eq("dis.Id", district))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
				/*
				 * chcList = session .createCriteria(MasHospital.class)
				 * .createAlias("HospitalType", "SubCentre")
				 * .add(Restrictions.eq("SubCentre.HospitalTypeCode",
				 * "115")).createAlias("District", "dis")
				 * .add(Restrictions.eq("dis.Id", district))
				 * .add(Restrictions.eq("Status", "y").ignoreCase()) .list();
				 */
			} else if ("phc".equalsIgnoreCase(dist.get(0).toString())) {
				district = Integer.parseInt(dist.get(1).toString().trim());
				phcList = session
						.createCriteria(MasHospital.class)
						.createAlias("HospitalType", "SubCentre")
						.add(Restrictions.in(
								"SubCentre.InstituteTypeShortName", phc))
						.createAlias("District", "dis")
						.add(Restrictions.eq("dis.Id", district))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("chcList", chcList);
		map.put("phcList", phcList);
		return map;

	}

	@Override
	public Map<String, Object> getBasicCenterList(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		List<MasHospital> phcList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		
		String[] scbasic = { "FWC", "BS" };
		Vector dist = box.getVector("chcphc");

		if (!dist.get(0).toString().equals("")) {
			int district = 0;

			try {
				chcList = session
						.createCriteria(MasHospital.class)
						.createAlias("HospitalType", "SubCentre")
						.add(Restrictions.in(
								"SubCentre.InstituteTypeShortName", scbasic))
						.add(Restrictions.eq("ParentInstitute.Id",
								Integer.parseInt(dist.get(0).toString())))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		

		map.put("chcList", chcList);

		return map;

	}

	@Override
	public Map<String, Object> getSurveyCount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SurveyDetailMails> mails = new ArrayList<SurveyDetailMails>();

		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int countHouse = 0;
		int coutnVillage = 0;
		int countSchool = 0;
		int anganCount = 0;
		int memberCount = 0;
		int collCount = 0;
		Integer count = 0;
		int hospitalId = box.getInt("hospitalId");

		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate"));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate"));
		List<Integer> cou = new ArrayList<Integer>();
		String fDate = box.getString("fromDate").split("/")[2] + "/"
				+ box.getString("fromDate").split("/")[1] + "/"
				+ box.getString("fromDate").split("/")[0];
		String tDate = box.getString("toDate").split("/")[2] + "/"
				+ box.getString("toDate").split("/")[1] + "/"
				+ box.getString("toDate").split("/")[0];
		

		try {

			countHouse = ((BigInteger) (session
					.createSQLQuery("select count(*) from  ph_house_survey where house_survey_date between '"
							+ fDate
							+ "' and '"
							+ tDate
							+ "' and hospital_id = '" + hospitalId + "'")
					.uniqueResult())).intValue();

			coutnVillage = ((BigInteger) session.createSQLQuery(
					"select count(*) from  ph_village_survey where survey_date between '"
							+ fDate + "' and '" + tDate
							+ "' and hospital_id = '" + hospitalId + "'")
					.uniqueResult()).intValue();

			countSchool = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1002 and  survey_date  between '"
									+ fDate
									+ "' and '"
									+ tDate
									+ "' and hospital_id = '"
									+ hospitalId
									+ "'").uniqueResult()).intValue();

			memberCount = ((BigInteger) session.createSQLQuery(
					"select count(*) from  ph_member_survey where member_survey_date   between '"
							+ fDate + "' and '" + tDate
							+ "' and hospital_id = '" + hospitalId + "'")
					.uniqueResult()).intValue();

			anganCount = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1001 and survey_date  between '"
									+ fDate
									+ "' and '"
									+ tDate
									+ "' and hospital_id = '"
									+ hospitalId
									+ "'").uniqueResult()).intValue();

			collCount = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1003 and  survey_date between '"
									+ fDate
									+ "' and '"
									+ tDate
									+ "' and hospital_id = '"
									+ hospitalId
									+ "'").uniqueResult()).intValue();

			Criteria cr = session.createCriteria(SurveyDetailMails.class);

			mails = cr.list();

		} catch (Exception e) {
			e.printStackTrace();

		}

		map.put("countHouse", countHouse);
		map.put("coutnVillage", coutnVillage);
		map.put("countSchool", countSchool);
		map.put("anganCount", anganCount);
		map.put("collCount", collCount);
		map.put("memberCount", memberCount);
		map.put("mails", mails);

		return map;
	}

	@Override
	public Map<String, Object> sendMailOfSurvey(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		String fromEmail = "";
		String toEmail = "";
		String messageToBeSent = "";

		int hSurvey = 0;
		int mSurvey = 0;
		int vSurvey = 0;
		int scSurvey = 0;
		int angSurvey = 0;
		int coSurvey = 0;

		List<SurveyDetailMails> mails = new ArrayList<SurveyDetailMails>();

		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi extra reference
		int countHouse = 0;
		int coutnVillage = 0;
		int countSchool = 0;
		int anganCount = 0;
		int memberCount = 0;
		int collCount = 0;
		int familyCount = 0;

		Integer count = 0;
		Boolean successfullSends = false;
		int hospitalId = box.getInt("hospitalId");

		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate"));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate"));
		List<Integer> cou = new ArrayList<Integer>();
		String fDate = box.getString("fromDate").split("/")[2] + "/"
				+ box.getString("fromDate").split("/")[1] + "/"
				+ box.getString("fromDate").split("/")[0];
		String tDate = box.getString("toDate").split("/")[2] + "/"
				+ box.getString("toDate").split("/")[1] + "/"
				+ box.getString("toDate").split("/")[0];
		

		try {

			countHouse = ((BigInteger) (session
					.createSQLQuery("select count(*) from  ph_house_survey where house_survey_date between '"
							+ fDate + "' and '" + tDate + "'").uniqueResult()))
					.intValue();

			coutnVillage = ((BigInteger) session.createSQLQuery(
					"select count(*) from  ph_village_survey where survey_date between '"
							+ fDate + "' and '" + tDate + "'").uniqueResult())
					.intValue();

			countSchool = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1002 and  survey_date  between '"
									+ fDate + "' and '" + tDate

									+ "'").uniqueResult()).intValue();

			memberCount = ((BigInteger) session.createSQLQuery(
					"select count(*) from  ph_member_survey where member_survey_date   between '"
							+ fDate + "' and '" + tDate + "'").uniqueResult())
					.intValue();

			anganCount = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1001 and survey_date  between '"
									+ fDate + "' and '" + tDate +

									"'").uniqueResult()).intValue();

			collCount = ((BigInteger) session
					.createSQLQuery(
							"select count(*) from  ph_village_survey   where survey_type = 1003 and  survey_date between '"
									+ fDate + "' and '" + tDate

									+ "'").uniqueResult()).intValue();

			familyCount = ((BigInteger) session.createSQLQuery(
					"select count(*) from  ph_family_survey where survey_date between '"
							+ fDate + "' and '" + tDate

							+ "'").uniqueResult()).intValue();

			Criteria cr = session.createCriteria(SurveyDetailMails.class);

			mails = cr.list();

		} catch (Exception e) {
			e.printStackTrace();

		}
		List<String> name = new ArrayList<String>();

		// name=session.createCriteria(MasStoreItem.class).add(Restrictions.idEq(itemId)).setProjection(Projections.property("Nomenclature")).list();

		String Subject = "Survey Details Of Survey:";
		messageToBeSent = "Survey Status as of : " + tDate + "\n"
				+ "Village Survey Total No. :" + coutnVillage + "\n "
				+ "House Survey Total No. : " + countHouse + "\n "
				+ "Member Survey Total No. :" + memberCount + "\n";
		if (mails != null && mails.size() > 0) {

			for (SurveyDetailMails object11 : mails) {

				fromEmail = box.getString("fromEmail");

				SendMail sendMail = new SendMail();

				if (object11.getEmails() != null
						&& !object11.getEmails().equals("")) {
					toEmail = object11.getEmails();
				}

				try {
					sendMail.sendMail("imap.gmail.com", toEmail, "egov@jkt.in",
							"", "", Subject, messageToBeSent);
					successfullSends = true;

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		map.put("countHouse", countHouse);
		map.put("coutnVillage", coutnVillage);
		map.put("countSchool", countSchool);
		map.put("anganCount", anganCount);
		map.put("collCount", collCount);
		map.put("memberCount", memberCount);
		map.put("familyCount", familyCount);
		map.put("mails", mails);

		map.put("successfullSends", successfullSends);

		return map;
	}

	// VK

	@Override
	public Map<String, Object> showTransferMemberJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<PhMemberSurvey> memberList = new ArrayList<PhMemberSurvey>();

		memberList = session.createCriteria(PhMemberSurvey.class)
				.add(Restrictions.eq("MemberId", box.getLong("memberId")))
				.list();
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		subcenterList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				.add(Restrictions
						.eq("SubCentre.HospitalTypeName", "Sub Centre"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("subcenterList", subcenterList);

		List<Object[]> phmsList = new ArrayList<Object[]>();

		String query = "select pms.survey_id, name, administrative_sex_name ,(current_date - date_of_birth)/365 as age ,person_name ,uhid_no , phs.contact_no ,mh.hospital_name ,mh2.hospital_name as parentName from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id "
				+ " left outer join mas_ward mw on phs.ward_id=mw.ward_id "
				+ " left outer join mas_hospital mh on pms.hospital_id=mh.hospital_id "
				+ " left outer join mas_administrative_sex mas on mas.administrative_sex_id=pms.gender "
				+ "left outer join mas_hospital mh2 on mh2.hospital_id  = mh.parent_institute_id "
				+ "where  lower(pms.transfer_status)=lower('Y') group by mh.hospital_id , name,phs.contact_no ,person_name ,pms.survey_id ,administrative_sex_name ,mh2.hospital_name";

		// String
		// query="select * from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id  where   pms.transfer_status='Y' or pms.transfer_status='y' ";
		phmsList = session.createSQLQuery(query).list();

		/*
		 * List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		 * districtList = session.createCriteria(MasDistrict.class)
		 * .addOrder(Order.asc("DistrictName")) .add(Restrictions.eq("Status",
		 * "y").ignoreCase()).list();
		 */
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		talukList = session.createCriteria(MasTaluk.class)
				.addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasWard> wardList = new ArrayList<MasWard>();
		wardList = session.createCriteria(MasWard.class)
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("districtList", districtList);
		map.put("talukList", talukList);
		map.put("villageList", villageList);
		map.put("wardList", wardList);
		map.put("memberList", memberList);
		map.put("phmsList", phmsList);
		return map;
	}

	// VK
	@Override
	public Map<String, Object> detailTransferMember(Box box,
			Map<String, Object> details) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List<PhMemberSurvey> phmsList = new ArrayList<PhMemberSurvey>();
		List<Object[]> phmsList = new ArrayList<Object[]>();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int stateId = Integer.parseInt(prop.getProperty("stateId"));

		// String
		// query="select pms.survey_id, name,phs.contact_no , hospital_name ,person_name from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join mas_ward mw on phs.ward_id=mw.ward_id left outer join mas_hospital mh on mw.sub_center_id=mh.hospital_id   where phs.ward_id ="+box.getInt("wardId")
		// +" and lower(pms.transfer_status)=lower('Y')";
		String query = "select pms.survey_id, name, administrative_sex_name ,(current_date - date_of_birth)/365 as age ,person_name ,uhid_no , phs.contact_no ,mh.hospital_name ,mh2.hospital_name as parentName  from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id "
				+ " left outer join mas_ward mw on phs.ward_id=mw.ward_id "
				+ " left outer join mas_hospital mh on pms.hospital_id=mh.hospital_id "
				+ " left outer join mas_administrative_sex mas on mas.administrative_sex_id=pms.gender "
				+ "left outer join mas_hospital mh2 on mh2.hospital_id  = mh.parent_institute_id "
				+ "where  phs.ward_id ="
				+ box.getInt("wardId")
				+ " and lower(pms.transfer_status)=lower('Y') group by mh.hospital_id , name,phs.contact_no ,person_name ,pms.survey_id ,administrative_sex_name,mh2.hospital_name ";

		phmsList = session.createSQLQuery(query).list();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", stateId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		talukList = session.createCriteria(MasTaluk.class)
				.addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasWard> wardList = new ArrayList<MasWard>();
		wardList = session.createCriteria(MasWard.class)
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("phmsList", phmsList);
		map.put("districtList", districtList);
		map.put("talukList", talukList);
		map.put("villageList", villageList);
		map.put("wardList", wardList);
		map.put("phmsList", phmsList);
		return map;
	}

	// VK
	@Override
	public Map<String, Object> addNewTransferMember(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String msg = "";
		Transaction tx = null;
		int hospitalId = (Integer) box.getInt("hospitalId");
		int districtId = (Integer) box.getInt("districtId");
		// int subcenter=(Integer) box.getInt("subcenter");
		// int memberId=(Integer) box.getInt("memberId");
		// System.out.println("memberId<addNew>memberId"+memberId);

		try {
			tx = session.beginTransaction();
			int count = box.getInt("counter");
			for (int i = 1; i < count; i++) {
				int memberId = box.getInt("phms" + i);
				if (memberId > 0) {

					PhMemberTransferDetails details = new PhMemberTransferDetails();
					PhMemberSurvey memberSurvey = new PhMemberSurvey();
					memberSurvey.setId(memberId);
					details.setMember(memberSurvey);
					details.setStatus("p");

					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					details.setHospital(hospital);
					hbt.save(details);
					PhMemberSurvey survey = (PhMemberSurvey) hbt.load(
							PhMemberSurvey.class, memberId);
					survey.setTransferStatus("N");
					hbt.save(survey);
					// successfullyAdded = true;
				}
			}

			tx.commit();
			hbt.flush();
			hbt.clear();
			msg = "Record Added Successfully.";
		} catch (Exception e) {
			e.printStackTrace();
			if (tx == null) {
				msg = "Try Again.";
				tx.rollback();
			}
		}
		map.put("msg", msg);
		return map;
	}

	// KM
	@Override
	public Map<String, Object> showApplockPassword(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		return map;
	}

	@Override
	public Map<String, Object> detailApplockPassword(Box box,
			Map<String, Object> details) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> applockPass = new ArrayList<Object[]>();

		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate"));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate"));
		List<Integer> cou = new ArrayList<Integer>();
		String fDate = box.getString("fromDate").split("/")[2] + "-"
				+ box.getString("fromDate").split("/")[1] + "-"
				+ box.getString("fromDate").split("/")[0];
		String tDate = box.getString("toDate").split("/")[2] + "-"
				+ box.getString("toDate").split("/")[1] + "-"
				+ box.getString("toDate").split("/")[0];
		

		String query = "select u.login_name,palp.imei_no,palp.app_lock_psw,palp.last_chg_date,palp.status from users u,ph_app_lock_psw palp where u.imei_no=CAST(palp.imei_no AS bigint) and palp.last_chg_date between '"
				+ fDate
				+ "' and  '"
				+ tDate
				+ "'  group by  u.login_name,palp.imei_no,palp.app_lock_psw,palp.last_chg_date,palp.status	order by palp.last_chg_date DESC";
		applockPass = session.createSQLQuery(query).list();

		map.put("applockPass", applockPass);
		return map;
	}

	// ------------------ House Survey -------

	@Override
	public Map<String, Object> getTalukForTransferedMemberList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		Session session = (Session) getSession();
		//session = (Session) getSession(); //commented by Om Tripathi extra reference
		int district = 0;
		try {

			if (dataMap.get("district") != null) {
				district = (Integer) dataMap.get("district");
			}
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("talukList", talukList);
		return map;

	}

	@Override
	public Map<String, Object> getVillageForTransferedMemberList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> villageList = new ArrayList<MasVillage>();
		Session session = (Session) getSession();
		// session = (Session) getSession();   //commented by Om Tripathi extra reference
		int taluk = 0;
		try {
			if (dataMap.get("taluk") != null) {
				taluk = (Integer) dataMap.get("taluk");
			}
			villageList = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(villageList.size() + "dddddddddd");

		map.put("villageList", villageList);

		return map;
	}

	@Override
	public Map<String, Object> getWardForTransferedMemberList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasWard> wardList = new ArrayList<MasWard>();
		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int village = 0;
		try {
			if (dataMap.get("village") != null) {
				village = (Integer) dataMap.get("village");
			}
			wardList = session.createCriteria(MasWard.class)
					.createAlias("Village", "v")
					.add(Restrictions.eq("v.Id", village))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(wardList.size() + "dddddddddd");

		map.put("wardList", wardList);

		return map;
	}

	@Override
	public Map<String, Object> getSubCentreForTransferedMemberList(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> subCentreList = new ArrayList<Object>();
		Session session = (Session) getSession();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String hospTypeCodeSC = prop.getProperty("hospital_type_code_sc");
		String hospTypeCodeBS = prop.getProperty("hospital_type_code_bs");
		String[] hospTypeCode = { hospTypeCodeSC, hospTypeCodeBS };
		int ward = 0;
		try {
			if (dataMap.get("ward") != null) {
				ward = (Integer) dataMap.get("ward");
			}

			subCentreList = session
					.createCriteria(LocationParameterMapping.class)
					.createAlias("Hospital", "h")
					.createAlias("h.HospitalType", "ht")
					.createAlias("Locality", "l")
					.createAlias("l.Ward", "w")
					.add(Restrictions.eq("w.Id", ward))
					.add(Restrictions.in("ht.HospitalTypeCode", hospTypeCode))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections.groupProperty("h.Id"))
									.add(Projections.property("h.HospitalName")))
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		map.put("subCentreList", subCentreList);

		return map;
	}

	@Override
	public Map<String, Object> showJHIJPHNHouseSurveyJsp(Box box,
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhHouseSurvey> phHouseSurveys = new ArrayList<PhHouseSurvey>();
		Session session = (Session) getSession();
		Criteria houseSurvey = getSession().createCriteria(PhHouseSurvey.class);
		if (box.getString("fromDate") != "" && box.getString("toDate") != "") {
			houseSurvey = houseSurvey.add(Restrictions.between(
					"HouseSurveyDate", HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("fromDate")), HMSUtil
							.convertStringTypeDateToDateType(box
									.getString("toDate"))));
		}
		/*
		 * if (box.getString("village") != "") { houseSurvey =
		 * houseSurvey.createAlias("Village", "v").add(
		 * Restrictions.eq("v.VillageName", box.getString("village"))); }
		 */
		if (!box.getString("houseNo").equals("")) {
			houseSurvey = houseSurvey.add(Restrictions.eq("LsgHouseNo",	box.getString("houseNo")));
		}
		if (box.getInt("ward") != 0 && !box.getString("ward").equals("0")) {
			houseSurvey = houseSurvey.createAlias("Ward", "w").add(Restrictions.eq("w.Id", box.getInt("ward")));
		}
		if (box.getInt("localityId") != 0 && !box.getString("localityId").equals("0")) {
			houseSurvey = houseSurvey.createAlias("Locality", "l").add(
					Restrictions.eq("l.Id", box.getInt("localityId")));
		}
		if (box.getInt("lsg") != 0 && !box.getString("lsg").equals("0")) {
			houseSurvey = houseSurvey.createAlias("Panchayat", "p").add(Restrictions.eq("p.Id", box.getInt("lsg")));
		}

		/*
		 * if(box.getString("hospitalId")!=""){
		 * System.out.println(box.getString("hospitalId"));
		 * houseSurvey=houseSurvey.createAlias("Hospital", "h")
		 * .add(Restrictions
		 * .eq("h.Id",Integer.parseInt(box.getString("hospitalId"
		 * ).toString())));
		 * 
		 * }
		 */
		/*
		 * if(box.getString("phc")!=""){
		 * System.out.println(box.getString("phc"));
		 * houseSurvey=houseSurvey.createAlias("Hospital", "h")
		 * .add(Restrictions
		 * .eq("h.Id",Integer.parseInt(box.getString("phc").toString())));
		 * 
		 * }
		 */
		if (box.getString("scBSPHC") != "")// ---------------- CHC/ Health block
											// level users ( HS/PHNS/CHC MO)
		{

			houseSurvey = houseSurvey.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", Integer.parseInt(box.getString(
							"scBSPHC").toString())));

		} else if (box.getString("scBS") != "" && !box.getString("scBS").equals(""))// ---------------- Phc level
												// users(HI/PHN/MO)
		{

			houseSurvey = houseSurvey
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id",
							Integer.parseInt(box.getString("scBS").toString())));

		} else if (box.getString("hospitalId") != "")// ---------------- Sub
														// center/Basic
		{

			houseSurvey = houseSurvey.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", Integer.parseInt(box.getString(
							"hospitalId").toString())));

		}
		phHouseSurveys = houseSurvey.list();

		List<MasHospital> masHospitalPHC = new ArrayList<MasHospital>();
		masHospitalPHC = session
				.createCriteria(MasHospital.class)
				.add(Restrictions.eq("ParentInstitute.Id", Integer.parseInt(box
						.getString("hospitalId").toString())))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("masHospitalPHC", masHospitalPHC);

		List<MasLsg> masLsg = new ArrayList<MasLsg>();
		masLsg = session
				.createCriteria(MasLsg.class)
				.createAlias("District", "d")
				.add(Restrictions.eq("d.Id", Integer.parseInt(box.getString(
						"districtId").toString())))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("masLsg", masLsg);

		List<MasWard> ward = new ArrayList<MasWard>();
		ward = session.createCriteria(MasWard.class)
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("ward", ward);
		map.put("phHouseSurveys", phHouseSurveys);
		return map;
	}

	@Override
	public Map<String, Object> showHouseSurveyINDistrict(Box box,
			Map<String, Object> details) {
		MasHospital hospital = new MasHospital();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		List<PhHouseSurvey> phHouseSurveys = new ArrayList<PhHouseSurvey>();
		Transaction tx = null;
		boolean saved = false;
		Criteria taluk = getSession().createCriteria(MasTaluk.class);
		Criteria houseSurvey = null;
		try {
			tx = session.beginTransaction();

			if (!box.getString("hospitalId").equals("")) {
				hospital = (MasHospital) hbt.load(MasHospital.class, Integer
						.parseInt(box.getString("hospitalId").toString()));
			}
			taluk = taluk.createAlias("District", "dis").add(
					Restrictions.eq(
							"dis.Id",
							Integer.parseInt(hospital.getDistrict().getId()
									.toString())));
			talukList = taluk.list();

			if (box.getInt("villageId") != 0) {
				houseSurvey = getSession().createCriteria(PhHouseSurvey.class);
				houseSurvey.createAlias("Village", "v").add(
						Restrictions.eq("v.Id", box.getInt("villageId")));
			}

			if (box.getString("fromDate") != ""
					&& box.getString("toDate") != "") {
				houseSurvey = houseSurvey.add(Restrictions.between(
						"HouseSurveyDate", HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("fromDate")), HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("toDate"))));
			}

			if (box.getString("houseNo") != "") {
				houseSurvey = houseSurvey.add(Restrictions.eq("LsgHouseNo",
						box.getString("houseNo")));
			}
			/*
			 * if(box.getString("hospitalId")!=""){
			 * System.out.println(box.getString("hospitalId"));
			 * houseSurvey.createAlias("Hospital", "h")
			 * .add(Restrictions.eq("h.Id"
			 * ,Integer.parseInt(box.getString("hospitalId").toString())));
			 * 
			 * }
			 */

			phHouseSurveys = houseSurvey.list();

			

		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("talukList", talukList);
		map.put("phHouseSurveys", phHouseSurveys);

		return map;

	}

	@Override
	public Map<String, Object> getPHC(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> masHospitalSCBS = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference
		int phc = 0;
		try {
			if (dataMap.get("phc") != null) {
				phc = (Integer) dataMap.get("phc");
			}

			masHospitalSCBS = session.createCriteria(MasHospital.class)
					.add(Restrictions.eq("ParentInstitute.Id", phc))
					.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masHospitalSCBS", masHospitalSCBS);

		return map;

	}

	@Override
	public Map<String, Object> getVillageListHouseSurvey(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> village = new ArrayList<MasVillage>();
		Session session = (Session) getSession();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		int taluk = 0;
		try {
			if (dataMap.get("taluk") != null) {
				taluk = (Integer) dataMap.get("taluk");
			}
			village = session.createCriteria(MasVillage.class)
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("village", village);

		return map;

	}

	@Override
	public Map<String, Object> showHouseSurveyInStateJsp(Box box,
			Map<String, Object> details) {
		MasHospital hospital = new MasHospital();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> districts = new ArrayList<MasDistrict>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		List<PhHouseSurvey> phHouseSurveys = new ArrayList<PhHouseSurvey>();
		Transaction tx = null;
		boolean saved = false;
		Criteria district = getSession().createCriteria(MasDistrict.class);
		Criteria houseSurvey = null;
		try {
			tx = session.beginTransaction();

			if (!box.getString("hospitalId").equals("")) {
				hospital = (MasHospital) hbt.load(MasHospital.class, Integer
						.parseInt(box.getString("hospitalId").toString()));
			}
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			Properties prop = new Properties();

			try {
				prop.load(new FileInputStream(new File(resourcePath.getFile())));
			} catch (Exception e1) {

				e1.printStackTrace();
			}

			int stateId = Integer.parseInt(prop.getProperty("stateId"));

			district = district.createAlias("State", "state").add(
					Restrictions.eq("state.Id", stateId));
			districts = district.list();
			if (box.getInt("villageId") != 0) {
				houseSurvey = getSession().createCriteria(PhHouseSurvey.class);
				houseSurvey.createAlias("Village", "v").add(
						Restrictions.eq("v.Id", box.getInt("villageId")));
			}

			if (box.getString("fromDate") != ""
					&& box.getString("toDate") != "") {
				houseSurvey.add(Restrictions.between("HouseSurveyDate", HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("fromDate")), HMSUtil
						.convertStringTypeDateToDateType(box
								.getString("toDate"))));
			}

			if (box.getString("houseNo") != "") {
				houseSurvey.add(Restrictions.eq("LsgHouseNo",
						box.getString("houseNo")));
			}
			/*
			 * if(box.getString("hospitalId")!=""){
			 * System.out.println(box.getString("hospitalId"));
			 * houseSurvey=houseSurvey.createAlias("Hospital", "h")
			 * .add(Restrictions
			 * .eq("h.Id",Integer.parseInt(box.getString("hospitalId"
			 * ).toString())));
			 * 
			 * }
			 */
			if (houseSurvey.list().size() != 0) {
				phHouseSurveys = houseSurvey.list();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		map.put("phHouseSurveys", phHouseSurveys);
		map.put("districts", districts);
		return map;

	}

	@Override
	public Map<String, Object> getTalukListHouseSurvey(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		Session session = (Session) getSession();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		int district = 0;
		try {

			if (dataMap.get("district") != null) {
				district = (Integer) dataMap.get("district");
			}
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("talukList", talukList);
		return map;
	}

	@Override
	public Map<String, Object> phMemberSurvey(Box box,
			Map<String, Object> details) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> memberSurveys = new ArrayList<Object>();
		Date date = new Date();
		Session session = (Session) getSession();
		List<MasAdministrativeSex> sex = new ArrayList<MasAdministrativeSex>();
		Criteria cr = session.createCriteria(MasAdministrativeSex.class);
		sex = cr.list();
		//System.out.println(box.getString("rationCard"));
		//System.out.println(box.getString("contact"));

		/*
		 * Criteria member = getSession().createCriteria( PhMemberSurvey.class);
		 * if (box.getString("requestId").toString() != "") {
		 * member.createAlias("House", "hs")
		 * .add(Restrictions.eq("hs.HouseHoldId ", box.getString("requestId")));
		 * } if (box.getString("familyName") != "") {
		 * member.add(Restrictions.like("FamilyName",
		 * box.getString("familyName"))); } if (box.getString("rationCard") !=
		 * "") { member.add(Restrictions.eq("RationCardNo",
		 * box.getString("rationCard"))); } if (box.getString("contact") != "")
		 * { member.add(Restrictions.eq("ContactNo", box.getString("contact")));
		 * } // memberSurveys = member.list();
		 * System.out.println(memberSurveys.size());
		 * 
		 * for(PhMemberSurvey memberSurvey:memberSurveys){
		 * 
		 * System.out.println(memberSurvey.getDateOfBirth()); }
		 */
		/*System.out.println("all "+box.getString("requestId")+" "+box.getString("hospitalId")+box.getString("familyName")
				+" "+box.getString("rationCard"));*/
		String query = "";
		if (box.getString("requestId") != "" && !box.getString("requestId").equals("")) {
		
			//Changed by Arbind on 22-06-2017 for age
			/*String query = "select pms.name,((CURRENT_DATE - pms.date_of_birth)/365) AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pms.house_id ='"*/
			query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no,pms.house_id from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.family_id= cast(pms.family_id as character varying) left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pms.house_id ='"		
					+ box.getString("requestId")
					+ "' and pms.hospital_id = '"
					+ box.getString("hospitalId") + "'";
			//memberSurveys = session.createSQLQuery(query).list();
		}

		if (!box.getString("familyName").equals("")) {
			/*String query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pfs.family_name like'"
					+ box.getString("familyName")
					+ "%' and pms.hospital_id = '"
					+ box.getString("hospitalId") + "'";
			memberSurveys = session.createSQLQuery(query).list();
			System.out.println("familyName "+box.getString("familyName"));*/
			query += " and pfs.family_name like '" + box.getString("familyName") + "%'";
		}

		if (!box.getString("rationCard").equals("")) {
			/*String query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pms.ration_card_no  like '"
					+ box.getString("rationCard")
					+ "%'  and pms.hospital_id = '"
					+ box.getString("hospitalId") + "'";
			memberSurveys = session.createSQLQuery(query).list();*/
			query += " and pms.ration_card_no like '" + box.getString("rationCard") + "%'";
		}

		if (!box.getString("contact").equals("")) {
			/*String query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pms.contact_no like '"
					+ box.getString("contact")
					+ "%' and pms.hospital_id = '"
					+ box.getString("hospitalId") + "'";
			memberSurveys = session.createSQLQuery(query).list();*/
			query += " and pms.contact_no like '" + box.getString("contact") + "%'";
		} 
		if (!box.getString("sexId").equals("")) {
			/*String query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where mas.administrative_sex_id ='"
					+ box.getString("sexId")
					+ "'and pms.hospital_id ='"
					+ box.getString("hospitalId") + "'";
			memberSurveys = session.createSQLQuery(query).list();*/
			query += " and mas.administrative_sex_id = '" + box.getString("sexId") + "'";
		}
		if (!box.getString("name").equals("")) {
			/*String query = "select pms.name,case when pms.date_of_birth is not null then ((CURRENT_DATE - pms.date_of_birth)/365) else ((CURRENT_DATE - pms.notional_dob)/365) end AS Age,mas.administrative_sex_name ,phs.contact_no,pfs.family_name,pms.ration_card_no from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id left outer join ph_family_survey pfs on  pfs.house_id=phs.house_hold_id left outer join mas_administrative_sex  mas on mas.administrative_sex_id = pms.gender where pms.name like '"
					+ box.getString("name")
					+ "%' and pms.hospital_id ='"
					+ box.getString("hospitalId") + "'";
			memberSurveys = session.createSQLQuery(query).list();*/
			query += " and pms.name like '" + box.getString("name") + "%'";
		}

		//System.out.println("Query --->  " + query);
		memberSurveys = session.createSQLQuery(query).list();

		map.put("memberSurveys", memberSurveys);
		map.put("sex", sex);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showPhOpdMainJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId = (Integer) box.getInt("hospitalId");
		List<MasAdministrativeSex> genderList = new ArrayList<MasAdministrativeSex>();
		List<MasBloodGroup> bloodGrpList = new ArrayList<MasBloodGroup>();
		List<PhVillageSurvey> schoolList = new ArrayList<PhVillageSurvey>();
		List<PhVillageSurvey> anganwadiList = new ArrayList<PhVillageSurvey>();
		int s = 1002;

		genderList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		bloodGrpList = session.createCriteria(MasBloodGroup.class)
				.add(Restrictions.eq("Status", "y")).list();
		schoolList = session.createCriteria(PhVillageSurvey.class)
				.add(Restrictions.eq("SurveyType", s)).list();

		map.put("genderList", genderList);
		map.put("bloodGrpList", bloodGrpList);
		map.put("schoolList", schoolList);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		return map;
	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getClassList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object> phClassDetailsList = new ArrayList<Object>();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		int villageSurveyId = 0;
		try {

			if (dataMap.get("villageSurveyId") != null) {
				villageSurveyId = (Integer) dataMap.get("villageSurveyId");
			}

			if (villageSurveyId != 0) {
				phClassDetailsList = session
						.createCriteria(PhClassDetails.class)
						.add(Restrictions.eq("Survey.Id", villageSurveyId))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("SchoolClass"))
										.add(Projections
												.property("SchoolClass")))
						.list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("phClassDetailsList", phClassDetailsList);
		return map;

	}

	@SuppressWarnings({ "unchecked" })
	public Map<String, Object> getSectionList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<PhClassDetails> phSectionList = new ArrayList<PhClassDetails>();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		String schoolClass = "";
		try {

			if (dataMap.get("schoolClass") != null) {
				schoolClass = (String) dataMap.get("schoolClass");
			}
			if (!schoolClass.equals("")) {
				phSectionList = session.createCriteria(PhClassDetails.class)
						.add(Restrictions.eq("SchoolClass", schoolClass))
						.list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("phSectionList", phSectionList);
		return map;

	}

	public Map<String, Object> getPhStudentRegistrationOpdMainList(
			Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			String studentName = (String) dataMap.get("studentName");
			String schoolClass = (String) dataMap.get("schoolClass");
			int villageSurveyId = (Integer) dataMap.get("villageSurveyId");
			int sectionId = (Integer) dataMap.get("sectionId");

			List<PhStudentRegistration> phStudentRegistrationList = new ArrayList<PhStudentRegistration>();
			Session session = (Session) getSession();
			Criteria criteria = null;
			
			// - StudentName
			if (!studentName.equals("") && villageSurveyId == 0
					&& sectionId == 0 && schoolClass.equals("")) {
				
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name",
								"%" + studentName + "%").ignoreCase());
			}
			if (!studentName.equals("") && villageSurveyId != 0
					&& sectionId == 0 && schoolClass.equals("")) {
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name",
								"%" + studentName + "%").ignoreCase())
						.createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId));

			}
			if (!studentName.equals("") && villageSurveyId == 0
					&& sectionId != 0 && schoolClass.equals("")) {
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name",
								"%" + studentName + "%").ignoreCase())
						.createAlias("Classdetails", "c")
						.add(Restrictions.eq("c.Id", sectionId));

			}
			if (!studentName.equals("") && villageSurveyId == 0
					&& sectionId == 0 && !schoolClass.equals("")) {
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name",
								"%" + studentName + "%").ignoreCase())
						.createAlias("Classdetails", "c")
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}

			// - villageSurveyId
			if (studentName == "" && villageSurveyId != 0 && sectionId == 0
					&& schoolClass.equals("")) {
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId));
			}
			if (studentName.equals("") && villageSurveyId != 0
					&& sectionId != 0 && schoolClass.equals("")) {
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId))
						.add(Restrictions.eq("c.Id", sectionId));

			}

			if (studentName.equals("") && villageSurveyId != 0
					&& sectionId != 0 && !schoolClass.equals("")) {
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId))
						.add(Restrictions.eq("c.Id", sectionId))
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}
			if (!studentName.equals("") && villageSurveyId != 0
					&& sectionId != 0 && schoolClass.equals("")) {
				
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name", "%" + studentName
								+ "%")).createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId))
						.add(Restrictions.eq("c.Id", sectionId));

			}
			if (!studentName.equals("") && villageSurveyId != 0
					&& sectionId == 0 && !schoolClass.equals("")) {
				
				criteria = session
						.createCriteria(PhStudentRegistration.class)
						.createAlias("Membersurvey", "s")
						.add(Restrictions.like("s.Name", "%" + studentName
								+ "%")).createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId))
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}

			if (studentName.equals("") && villageSurveyId != 0
					&& sectionId == 0 && !schoolClass.equals("")) {
				
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.createAlias("c.Survey", "v")
						.add(Restrictions.eq("v.Id", villageSurveyId))
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}

			// - sectionId
			if (studentName.equals("") && villageSurveyId == 0
					&& sectionId != 0 && schoolClass.equals("")) {
				
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.add(Restrictions.eq("c.Id", sectionId));

			}
			if (studentName.equals("") && villageSurveyId == 0
					&& sectionId != 0 && !schoolClass.equals("")) {
				
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.add(Restrictions.eq("c.Id", sectionId))
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}

			if (studentName.equals("") && villageSurveyId == 0
					&& sectionId == 0 && !schoolClass.equals("")) {
				
				criteria = session.createCriteria(PhStudentRegistration.class)
						.createAlias("Classdetails", "c")
						.add(Restrictions.eq("c.SchoolClass", schoolClass));

			}
			if (studentName.equals("") && villageSurveyId == 0
					&& sectionId == 0 && schoolClass.equals("")) {
				
				criteria = session.createCriteria(PhStudentRegistration.class);
			}

			phStudentRegistrationList = criteria.list();

			map.put("phStudentRegistrationList", phStudentRegistrationList);
			String classD = "";
			int cstdId = 0;
			List<PhStudentHealthDetails> phStudentHealthDetailsList = new ArrayList<PhStudentHealthDetails>();

			if (phStudentRegistrationList.size() > 0) {

				PhStudentRegistration p = (PhStudentRegistration) phStudentRegistrationList.get(0);
				if(p.getClassdetails() != null) {
					classD = p.getClassdetails().getSchoolClass();
				}

				if (classD != null && !classD.equals("")) {
					phStudentHealthDetailsList = session
							.createCriteria(PhStudentHealthDetails.class)
							.add(Restrictions.eq("SchoolClass", classD)).list();

					if (phStudentHealthDetailsList.size() > 0) {
						PhStudentHealthDetails ph = (PhStudentHealthDetails) phStudentHealthDetailsList
								.get(0);
						cstdId = ph.getStudent().getId();
						logger.info(cstdId + "cstdId");
					}
				}

			}

			map.put("cstdId", cstdId);
			map.put("classD", classD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return map;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getValueStudentRegistration(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId = (Integer) box.getInt("hospitalId");
		int deptId = (Integer) box.getInt("deptId");
		int studentRegistrationId = (Integer) box
				.getInt("studentRegistrationId");
		List<PhStudentRegistration> phStudentRegistrationList = new ArrayList<PhStudentRegistration>();

		List<MasActionTaken> masActionTakenList = new ArrayList<MasActionTaken>();

		phStudentRegistrationList = session
				.createCriteria(PhStudentRegistration.class)
				.add(Restrictions.eq("Id", studentRegistrationId)).list();

		map.put("phStudentRegistrationList", phStudentRegistrationList);

		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		districtList = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("districtList", districtList);

		List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
		masHospitalTypeList = session.createCriteria(MasHospitalType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masHospitalTypeList", masHospitalTypeList);

		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		masHospitalList = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masHospitalList", masHospitalList);

		masActionTakenList = session.createCriteria(MasActionTaken.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masActionTakenList", masActionTakenList);

		List<MasSpecialityDeptGroup> masForGorupParameter = new ArrayList<MasSpecialityDeptGroup>();
		List<MasSpecialityDeptGroupValue> masValue = new ArrayList<MasSpecialityDeptGroupValue>();
		List<MasSpecialtyGroupParameter> groupParameterList = new ArrayList<MasSpecialtyGroupParameter>();

		int idForValue = 0;
		// int departId=(Integer)map.get("deptId");

		String empDeptCodeForPH = HMSUtil.getValuesFromPropertiesFile(
				"adt.properties", "empDeptCodeForPH");
		Criteria crForGroupParameter = getSession()
				.createCriteria(MasSpecialityDeptGroup.class, "mas")
				.createAlias("mas.Department", "dep")
				.createAlias("dep.EmpDept", "empDp")
				// .add(Restrictions.eq("dep.Id",deptId))
				.add(Restrictions.eq("empDp.EmpDeptCode", empDeptCodeForPH))
				.addOrder(Order.asc("GroupSeqNo"));
		masForGorupParameter = crForGroupParameter.list();

		List<Integer> groupIds = new ArrayList<Integer>();
		for (MasSpecialityDeptGroup masSpecialityDeptGroup : masForGorupParameter) {
			groupIds.add(masSpecialityDeptGroup.getSpGroup().getSpGroup()
					.getId());
			// idForValue=masSpecialityDeptGroup.getId();
		}

		if (groupIds.size() > 0) {
			groupParameterList = getSession()
					.createCriteria(MasSpecialtyGroupParameter.class, "mas")
					.createAlias("mas.SpGroup", "sgroup")
					.add(Restrictions.in("sgroup.Id", groupIds)).list();
		}

		if (masForGorupParameter.size() > 0) {
			Criteria crForParaValues = getSession()
					.createCriteria(MasSpecialityDeptGroupValue.class, "masVal")
					.createAlias("masVal.DeptGroup", "deptGroup")
					.add(Restrictions.eq("deptGroup.ValueType", "LOV")
							.ignoreCase())
					.add(Restrictions.in("masVal.DeptGroup",
							masForGorupParameter));
			masValue = crForParaValues.list();
		}

		
		map.put("masForGorupParameter", masForGorupParameter);
		map.put("groupParameterList", groupParameterList);
		map.put("masValue", masValue);

		return map;
	}

	public Map<String, Object> fillDataForDistrictHospitalType(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session ses = (Session) getSession();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		int districtId = 0;
		if (dataMap.get("districtId") != null) {
			districtId = Integer.parseInt("" + dataMap.get("districtId"));
		}
		int hospitalTypeId = 0;
		if (dataMap.get("hospitalTypeId") != null) {
			hospitalTypeId = Integer.parseInt(""
					+ dataMap.get("hospitalTypeId"));
		}
		if (hospitalTypeId != 0 && districtId != 0) {
			masHospitalList = ses.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "ht")
					.add(Restrictions.eq("ht.Id", hospitalTypeId))
					.createAlias("District", "d")
					.add(Restrictions.eq("d.Id", districtId)).list();
		}
		if (hospitalTypeId == 0 && districtId != 0) {
			masHospitalList = ses.createCriteria(MasHospital.class)
					.createAlias("District", "d")
					.add(Restrictions.eq("d.Id", districtId)).list();
		}
		if (hospitalTypeId != 0 && districtId == 0) {
			masHospitalList = ses.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "ht")
					.add(Restrictions.eq("ht.Id", hospitalTypeId)).list();
		}

		map.put("masHospitalList", masHospitalList);
		return map;
	}

	@Override
	public Map<String, Object> showDepartmentSpeciality(Map<String, Object> map) {
		Session session = (Session) getSession();
		int hospitalId = 0;
		int deptId = 0;
		if (map.get("hospitalId") != null) {
			hospitalId = (Integer) map.get("hospitalId");
		}
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
			;
		}
		List<MasSpecialtyTemplate> specialtyTemplateList = new ArrayList<MasSpecialtyTemplate>();
		specialtyTemplateList = session
				.createCriteria(MasSpecialityDeptGroup.class)
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.setProjection(
						Projections.distinct(Projections.property("Template")))
				.list();
		map.put("specialtyTemplateList", specialtyTemplateList);
		logger.info("specialtyTemplateList--in data--"	+ specialtyTemplateList.size());
		return map;

	}

	@Override
	public Map<String, Object> showGroupAndParameterValues(Map map) {
		List<MasSpecialityDeptGroup> masForGorupParameter = new ArrayList<MasSpecialityDeptGroup>();
		List<MasSpecialityDeptGroupValue> masValue = new ArrayList<MasSpecialityDeptGroupValue>();
		List<MasSpecialtyGroupParameter> groupParameterList = new ArrayList<MasSpecialtyGroupParameter>();

		int idForValue = 0;
		int departId = (Integer) map.get("deptId");
		String template = (String) map.get("template");
		logger.info("templatetemplate " + template);
		if (template != null && !(template.equals(""))) {
			Criteria crForGroupParameter = getSession()
					.createCriteria(MasSpecialityDeptGroup.class, "mas")
					.createAlias("mas.Department", "dep")
					.add(Restrictions.eq("dep.Id", departId))
					.createAlias("mas.Template", "tem")
					.add(Restrictions.eq("tem.Id", Integer.parseInt(template)))
					.addOrder(Order.asc("GroupSeqNo"));
			masForGorupParameter = crForGroupParameter.list();

			List<Integer> groupIds = new ArrayList<Integer>();
			for (MasSpecialityDeptGroup masSpecialityDeptGroup : masForGorupParameter) {
				groupIds.add(masSpecialityDeptGroup.getSpGroup().getSpGroup()
						.getId());
				// idForValue=masSpecialityDeptGroup.getId();
			}

			if (groupIds.size() > 0) {
				groupParameterList = getSession()
						.createCriteria(MasSpecialtyGroupParameter.class, "mas")
						.createAlias("mas.SpGroup", "sgroup")
						.add(Restrictions.in("sgroup.Id", groupIds)).list();
			}

			if (masForGorupParameter.size() > 0) {
				Criteria crForParaValues = getSession()
						.createCriteria(MasSpecialityDeptGroupValue.class,
								"masVal")
						.createAlias("masVal.DeptGroup", "deptGroup")
						.add(Restrictions.eq("deptGroup.ValueType", "LOV")
								.ignoreCase())
						.add(Restrictions.in("masVal.DeptGroup",
								masForGorupParameter));
				masValue = crForParaValues.list();
			}
		}
		map.put("masForGorupParameter", masForGorupParameter);
		map.put("groupParameterList", groupParameterList);
		map.put("masValue", masValue);

		return map;
	}

	@Override
	public Map<String, Object> saveSpeciality(Map<String, Object> mapForDS) {
		boolean saved = false;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Session session = (Session) getSession();
			Transaction tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<Integer> actionTakenList = new ArrayList<Integer>();
			List<String> parameterList = new ArrayList<String>();
			List<String> valueList = new ArrayList<String>();

			actionTakenList = (List) mapForDS.get("actionTakenList");
			parameterList = (List) mapForDS.get("parameterList");
			valueList = (List) mapForDS.get("valueList");
			int studentId = 0;
			int deptId = 0;
			int hospitalId = 0;
			int userId = 0;
			if (mapForDS.get("studentId") != null) {
				studentId = (Integer) mapForDS.get("studentId");
			}
			if (mapForDS.get("deptId") != null) {
				deptId = (Integer) mapForDS.get("deptId");
			}
			if (mapForDS.get("hospitalId") != null) {
				hospitalId = (Integer) mapForDS.get("hospitalId");
			}
			if (mapForDS.get("userId") != null) {
				userId = (Integer) mapForDS.get("userId");
			}

			String time = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			int count = 0;
			for (int i = 0; i < parameterList.size(); i++) {
				String str = parameterList.get(i);
				String[] ids = str.split(":");
				Integer groupId = Integer.parseInt(ids[0]);
				Integer parameterId = Integer.parseInt(ids[1]);
				Integer actionTakenId = 0;
				OpdSpecialityDetails opds = new OpdSpecialityDetails();

				actionTakenId = Integer.parseInt(actionTakenList.get(i)
						.toString());
				if (actionTakenId != 0)
					opds.setActionTaken(new MasActionTaken(actionTakenId));

				String paramterValue = valueList.get(i).toString();
				opds.setStudentRegistration(new PhStudentRegistration(studentId));
				opds.setHospital(new MasHospital(hospitalId));
				opds.setSpGroup(new MasSpecialityGroup(groupId));
				opds.setSpParameter(new MasSpecialityParameter(parameterId));
				if (paramterValue.equalsIgnoreCase("radio")) {
					opds.setSpValues("y");
				} else if (paramterValue.equalsIgnoreCase("checkbox")) {
					opds.setSpValues("y");
				} else {
					opds.setSpValues(paramterValue);
				}
				// opds.setSpTemplate(new MasSpecialtyTemplate(specialtyId));
				opds.setLastChgBy(new Users(userId));
				opds.setLastChgDate(new Date());
				opds.setLastChgTime(time);
				hbt.save(opds);
				count++;

			}
			int hospitalStudId = 0;
			if (mapForDS.get("hospitalStudId") != null) {
				hospitalStudId = (Integer) mapForDS.get("hospitalStudId");
			}
			int hospitalTypeId = 0;
			if (mapForDS.get("hospitalTypeId") != null) {
				hospitalTypeId = (Integer) mapForDS.get("hospitalTypeId");
			}
			int districtId = 0;
			if (mapForDS.get("districtId") != null) {
				districtId = (Integer) mapForDS.get("districtId");
			}
			int age = 0;
			if (mapForDS.get("age") != null) {
				age = (Integer) mapForDS.get("age");
			}
			String allergy = "";
			if (mapForDS.get("allergy") != null) {
				allergy = (String) mapForDS.get("allergy");
			}
			String allergyYesText = "";
			if (mapForDS.get("allergyYesText") != null) {
				allergyYesText = (String) mapForDS.get("allergyYesText");
			}
			String bcgDueDated = "";
			Date bcgDueDate = null;
			if (mapForDS.get("bcgDueDate") != null
					&& mapForDS.get("bcgDueDate") != null) {
				bcgDueDated = (String) mapForDS.get("bcgDueDate");
				bcgDueDate = HMSUtil
						.convertStringTypeDateToDateType(bcgDueDated);
			}

			String bcgImmDated = "";
			Date bcgImmDate = null;
			if (mapForDS.get("bcgImmDate") != null
					&& mapForDS.get("bcgImmDate") != null) {
				bcgImmDated = (String) mapForDS.get("bcgImmDate");
				bcgImmDate = HMSUtil
						.convertStringTypeDateToDateType(bcgImmDated);
			}
			int dbp = 0;
			if (mapForDS.get("dbp") != null) {
				dbp = (Integer) mapForDS.get("dbp");
			}
			int height = 0;
			if (mapForDS.get("height") != null) {
				height = (Integer) mapForDS.get("height");
			}
			int weight = 0;
			if (mapForDS.get("weight") != null) {
				weight = (Integer) mapForDS.get("weight");
			}

			String hepatitiesBoDueDated = "";
			Date hepatitiesBoDueDate = null;
			if (mapForDS.get("hepatitiesBoDueDate") != ""
					&& mapForDS.get("hepatitiesBoDueDate") != null) {
				hepatitiesBoDueDated = (String) mapForDS
						.get("hepatitiesBoDueDate");
				hepatitiesBoDueDate = HMSUtil
						.convertStringTypeDateToDateType(hepatitiesBoDueDated);
			}

			String hepatitiesBoImmDated = "";
			Date hepatitiesBoImmDate = null;
			if (mapForDS.get("hepatitiesBoImmDate") != ""
					&& mapForDS.get("hepatitiesBoImmDate") != null) {
				hepatitiesBoImmDated = (String) mapForDS
						.get("hepatitiesBoImmDate");
				hepatitiesBoImmDate = HMSUtil
						.convertStringTypeDateToDateType(hepatitiesBoImmDated);
			}

			String opvODueDated = "";
			Date opvODueDate = null;
			if (mapForDS.get("opvODueDate") != "") {
				opvODueDated = (String) mapForDS.get("opvODueDate");
				opvODueDate = HMSUtil
						.convertStringTypeDateToDateType(opvODueDated);
			}

			String opvOImmDated = "";
			Date opvOImmDate = null;
			if (mapForDS.get("opvOImmDate") != ""
					&& mapForDS.get("opvOImmDate") != null) {
				opvOImmDated = (String) mapForDS.get("opvOImmDate");
				opvOImmDate = HMSUtil
						.convertStringTypeDateToDateType(opvOImmDated);
			}
			int pulse = 0;
			if (mapForDS.get("pulse") != null) {
				pulse = (Integer) mapForDS.get("pulse");
			}

			int sbp = 0;
			if (mapForDS.get("sbp") != null) {
				sbp = (Integer) mapForDS.get("sbp");
			}
			BigDecimal bmi = new BigDecimal(0);
			if (mapForDS.get("bmi") != null) {
				bmi = (BigDecimal) mapForDS.get("bmi");
			}

			PhStudentHealthDetails phStudHealDts = new PhStudentHealthDetails();

			MasHospital hospital = new MasHospital();
			hospital.setId(hospitalStudId);
			phStudHealDts.setHospital(hospital);

			phStudHealDts.setStudent(new PhStudentRegistration(studentId));

			String classD = "";
			List pshList = new ArrayList();
			if (studentId != 0) {
				pshList = getSession()
						.createCriteria(PhStudentRegistration.class)
						.add(Restrictions.eq("Id", studentId)).list();
				if (pshList.size() > 0) {
					PhStudentRegistration p = (PhStudentRegistration) pshList
							.get(0);
					if(p.getClassdetails() != null) {
						classD = p.getClassdetails().getSchoolClass();
					}
					phStudHealDts.setSchoolClass(classD);

				}
			}

			MasDistrict district = new MasDistrict();
			district.setId(districtId);
			phStudHealDts.setDistrict(district);

			MasHospitalType hospitalType = new MasHospitalType();
			hospitalType.setId(hospitalTypeId);
			phStudHealDts.setHospitalType(hospitalType);

			phStudHealDts.setAge(age);
			phStudHealDts.setAllergy(allergy);
			phStudHealDts.setAllergyYesText(allergyYesText);
			phStudHealDts.setBcgDueDate(bcgDueDate);
			phStudHealDts.setBcgImmDate(bcgImmDate);
			phStudHealDts.setBmi(bmi);
			phStudHealDts.setDbp(dbp);
			phStudHealDts.setHeight(height);
			phStudHealDts.setWeight(weight);
			phStudHealDts.setHepatitiesBoImmDate(hepatitiesBoImmDate);
			phStudHealDts.setHepatitiesBoDueDate(hepatitiesBoDueDate);
			phStudHealDts.setOpvODueDate(opvODueDate);
			phStudHealDts.setOpvOImmDate(opvOImmDate);
			phStudHealDts.setPulse(pulse);
			phStudHealDts.setSbp(sbp);

			phStudHealDts.setLastChgBy(new Users(userId));
			phStudHealDts.setLastChgDate(new Date());
			phStudHealDts.setLastChgTime(time);
			hbt.save(phStudHealDts);

			tx.commit();
			saved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> getDistrictForXml() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Session session = (Session) getSession();
		int StateId = Integer.parseInt(HMSUtil.getValuesFromPropertiesFile(
				"adt.properties", "stateId"));

		masDistrict = session.createCriteria(MasDistrict.class)
				.add(Restrictions.eq("State.Id", StateId))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("masDistrict", masDistrict);

		return map;
	}

	@Override
	public Map<String, Object> shownXmplRepordt() {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	public List<Object[]> generateHMISExcelReport(String queryForhmisDataExcel) {

		List<Object[]> objects = new ArrayList<Object[]>();
		List list = new ArrayList();
		Session session = (Session) getSession();
		String qry = queryForhmisDataExcel;
		

		objects = session.createSQLQuery(qry).list();
		// objects=
		// session.createSQLQuery("select (select count(*) as t1 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where district_id=1), (select count((current_date - date_of_birth)/365) as t2 from ph_anc_survey pas left outer join ph_member_survey  pms on pas.member_id=pms.member_id  left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where ((current_date - date_of_birth)/365) < 19  and district_id=1 )").list();
		
		// System.out.println("jjjjj----->"+objects.get(0)[3]);
		return objects;

	}

	@Override
	public Map<String, Object> generateHMISExcelReport(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> showNewTransferMemberJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();

		List<PhMemberSurvey> memberList = new ArrayList<PhMemberSurvey>();

		memberList = session.createCriteria(PhMemberSurvey.class)
				.add(Restrictions.eq("MemberId", box.getInt("memberId")))
				.list();
		logger.info("memberList>>>>" + memberList.size());
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		subcenterList = session
				.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				.add(Restrictions
						.eq("SubCentre.HospitalTypeName", "Sub Centre"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("subcenterList", subcenterList);
		logger.info("subcenterList>>>" + subcenterList.size());

		List<Object[]> phmsList = new ArrayList<Object[]>();

		String query = "select pms.survey_id, name, administrative_sex_name ,(current_date - date_of_birth)/365 as age ,person_name ,uhid_no , phs.contact_no ,mh.hospital_name , mh2.hospital_name as parent from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id "
				+ " left outer join mas_ward mw on phs.ward_id=mw.ward_id "
				+ " left outer join mas_hospital mh on pms.hospital_id=mh.hospital_id "
				+ "left outer join mas_administrative_sex mas on mas.administrative_sex_id=pms.gender "
				+ "left outer join mas_hospital mh2 on mh2.hospital_id  = mh.parent_institute_id "
				+ "where  lower(pms.transfer_status)=lower('Y') and  pms.survey_id ="
				+ box.getInt("memberId")
				+ " group by mh.hospital_id , name,phs.contact_no ,person_name ,pms.survey_id ,administrative_sex_name ,mh2.hospital_name";

		// String
		// query="select * from ph_member_survey pms left outer join ph_house_survey phs on pms.house_id=phs.house_hold_id  where   pms.transfer_status='Y' or pms.transfer_status='y' ";
		phmsList = session.createSQLQuery(query).list();

		/*
		 * List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		 * districtList = session.createCriteria(MasDistrict.class)
		 * .addOrder(Order.asc("DistrictName")) .add(Restrictions.eq("Status",
		 * "y").ignoreCase()).list();
		 */
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int districtId = box.getInt("districtId");

		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		talukList = session.createCriteria(MasTaluk.class)
				.add(Restrictions.eq("District.Id", districtId))
				.addOrder(Order.asc("TalukName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasVillage> villageList = new ArrayList<MasVillage>();
		villageList = session.createCriteria(MasVillage.class)
				.addOrder(Order.asc("VillageName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		List<MasWard> wardList = new ArrayList<MasWard>();
		wardList = session.createCriteria(MasWard.class)
				.addOrder(Order.asc("WardName"))
				.add(Restrictions.eq("Status", "Y").ignoreCase()).list();

		map.put("talukList", talukList);
		map.put("villageList", villageList);
		map.put("wardList", wardList);
		map.put("memberList", memberList);
		map.put("phmsList", phmsList);
		return map;
	}

	@Override
	public Map<String, Object> getPhReportDataFromDatabase(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<MasHmisParameters> hmisParameters = new ArrayList<MasHmisParameters>(); //commented by amit das on 01-12-2016
		List<MasPhReportsParameters> hmisParameters = new ArrayList<MasPhReportsParameters>(); //added by amit das on 01-12-2016
		List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
		List<HmisDistrictReport> list = new ArrayList<HmisDistrictReport>();
		Session session = (Session) getSession();
		// hmisParameters = session.createCriteria(MasHmisParameters.class).list(); //commented by amit das on 01-12-2016
		int month = box.getInt("month");
		int year = box.getInt("year");
		int hospitalId = box.getInt("hospitalId");
		String reportName = box.get("reportName");
		String reportParameterIdColumn = null;
		String reportParameterNameColumn = null;
		String districtName = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String propertyName = "";
		// added by amit das on 26-04-2016
		Query queryForStockDistributed = null;
		Query queryForTotalStock = null;
		Query queryForStockRecieved = null;
		List listForQuery = null;
		try {
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtName = hospital.getDistrict().getDistrictName();

			if (districtName.equalsIgnoreCase("THIRUVANANTHAPURAM")) {
				propertyName = "Thiruvananthapuram";
			} else if (districtName.equalsIgnoreCase("ALAPPUZHA")) {
				propertyName = "ALAPPUZHA";
			} else if (districtName.equalsIgnoreCase("Ernakulam")) {
				propertyName = "Ernakulam";
			} else if (districtName.equalsIgnoreCase("Idukki")) {
				propertyName = "Idukki";
			} else if (districtName.equalsIgnoreCase("Kannur")) {
				propertyName = "Kannur";
			} else if (districtName.equalsIgnoreCase("Kasaragod")) {
				propertyName = "Kasaragod";
			} else if (districtName.equalsIgnoreCase("Kollam")) {
				propertyName = "Kollam";
			} else if (districtName.equalsIgnoreCase("Kottayam")) {
				propertyName = "Kottayam";
			} else if (districtName.equalsIgnoreCase("Kozhikode")) {
				propertyName = "Kozhikode";
			} else if (districtName.equalsIgnoreCase("Malappuram")) {
				propertyName = "Malappuram";
			} else if (districtName.equalsIgnoreCase("Palakkad")) {
				propertyName = "Palakkad";
			} else if (districtName.equalsIgnoreCase("Pathanamthitta")) {
				propertyName = "Pathanamthitta";
			} else if (districtName.equalsIgnoreCase("Thrissur")) {
				propertyName = "Thrissur";
			} else if (districtName.equalsIgnoreCase("Wayanad")) {
				propertyName = "Wayanad";
			}

			if(reportName!=null){
			
			if(reportName.equalsIgnoreCase("hmis")){
				reportParameterIdColumn = "HmisId";
				reportParameterNameColumn = "HmisParameter";
			}else if(reportName.equalsIgnoreCase("goiMonthly")){
				reportParameterIdColumn = "GoiMonthlyId";
				reportParameterNameColumn = "GoiMonthlyParameter";
			}else if(reportName.equalsIgnoreCase("goiQuarterly")){
				reportParameterIdColumn = "GoiQuarterlyId";
				reportParameterNameColumn = "GoiQuarterlyParameter";
			}else if(reportName.equalsIgnoreCase("goiAnnually")){
				reportParameterIdColumn = "GoiAnnuallyId";
				reportParameterNameColumn = "GoiAnnuallyParameter";
			}
			
			
			// added by Amit Das on 26-04-2016
			queryForStockDistributed = session
					.createSQLQuery("select coalesce(sum(sit.qty_issued),0) as count from store_issue_t sit join store_issue_m sim on sit.issue_m_id = sim.id "
							+ "join hmis_parameter_mapping hpm on sit.item_id = hpm.item_id "
							+ "where EXTRACT(MONTH FROM sim.issue_date)  = :month and hpm.parameter_id = :parameterId");
			queryForTotalStock = session
					.createSQLQuery("select coalesce(sum(sibs.closing_stock),0) as count from store_item_batch_stock sibs "
							+ "join hmis_parameter_mapping hpm on sibs.item_id = hpm.item_id "
							+ "where hpm.parameter_id = :parameterId and sibs.hospital_id = :hospitalId");
			queryForStockRecieved = session
					.createSQLQuery("select coalesce(sum(sgt.received_qty),0) as count from store_grn_t sgt "
							+ "join store_grn_m sgm on sgt.grn_master_id = sgm.grn_master_id "
							+ "join hmis_parameter_mapping hpm on sgt.item_id = hpm.item_id "
							+ "where  EXTRACT(MONTH FROM sgm.grn_date)  = :month and hpm.parameter_id = :parameterId");

			/*Criteria cr = session.createCriteria(MasHmisParameters.class)
					.addOrder(Order.asc("Id"));*/
			// commented by amit das on 01-12-2016
			
			// added by amit das on 01-12-2016
			if(reportParameterIdColumn!=null && reportParameterNameColumn!=null) {
			Criteria cr = session.createCriteria(MasPhReportsParameters.class).add(Restrictions.isNotNull(reportParameterIdColumn)).add(Restrictions.isNotNull(reportParameterNameColumn))
						  .add(Restrictions.ne(reportParameterIdColumn,"")).add(Restrictions.ne(reportParameterNameColumn,""))
						  .addOrder(Order.asc("Id"));
			
			hmisParameters = cr.list();
			
			Criteria crforRettrive = session
					.createCriteria(HmisDistrictReport.class)
					.add(Restrictions.in("Parameter", hmisParameters)) // added by amit das on 01-12-2016
					.add(Restrictions.eq("ReportMonth", month))
					.add(Restrictions.eq("ReportYear", year))
					.addOrder(Order.asc("Id"));

			list = crforRettrive.list();

			// added by Amit Das on 26-04-2016
			if (list != null && list.size() > 0) {
				for (HmisDistrictReport hmisDistrictReport : list) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();
					pojoForHmisParameter
							.setHmisDistrictReport(hmisDistrictReport);

					queryForStockDistributed.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForStockDistributed.setParameter("month", month);

					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter
							.setCountOfStockDistributed(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForTotalStock.setParameter("hospitalId", hospitalId);

					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter
							.setCountOfTotalStock(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForStockRecieved.setParameter("month", month);

					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter
							.setCountOfstockReceived(((BigDecimal) listForQuery
									.get(0)).intValue());

					pojoForHmisParameter
							.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter
									.getCountOfTotalStock()
									- (pojoForHmisParameter
											.getCountOfstockReceived() + pojoForHmisParameter
											.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);

				}

			} else if (hmisParameters != null && hmisParameters.size() > 0) {
				for (MasPhReportsParameters hmisParameter : hmisParameters) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();
					pojoForHmisParameter.setMasPhReportsParameters(hmisParameter);

					queryForStockDistributed.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForStockDistributed.setParameter("month", month);

					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter
							.setCountOfStockDistributed(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForTotalStock.setParameter("hospitalId", hospitalId);

					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter
							.setCountOfTotalStock(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForStockRecieved.setParameter("month", month);

					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter
							.setCountOfstockReceived(((BigDecimal) listForQuery
									.get(0)).intValue());

					pojoForHmisParameter
							.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter
									.getCountOfTotalStock()
									- (pojoForHmisParameter
											.getCountOfstockReceived() + pojoForHmisParameter
											.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);

				}

			}
		  }	
		}
			// end of Amit Das code

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("hmisParameters", hmisParameters);
		map.put("propertyName", propertyName);
		map.put("hmisParametersList", hmisParametersList);
		return map;
	}

	// Kaushal Mishra

	public String getHospitalName(int hospitalId) {
		Session session = (Session) getSession();
		String hospitalName = "";
		List<MasHospital> list = session.createCriteria(MasHospital.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Id", hospitalId)).list();

		if (list != null && list.size() > 0) {
			MasHospital obj = (MasHospital) list.get(0);
			hospitalName = obj.getHospitalName();
		}
		return hospitalName;
	}

	@Override
	public Map<String, Object> getHMISCountFromDatabase(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> countList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		int currentMonth = 0;
		int districtID = 0;
		String fromDate = null;
		String toDate = null;
		int hospitalId = box.getInt("hospitalId");
		Calendar calendar = Calendar.getInstance();

		if (box.getInt("month") != 0) {
			currentMonth = box.getInt("month");
		} else {
			currentMonth = box.getInt("currentMonth");
		}
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (currentMonth != 0)
			calendar.set(Calendar.MONTH, currentMonth - 1);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date sDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date eDate = calendar.getTime();
		String startDate = sdf.format(sDate);
		String endDate = sdf.format(eDate);

		try {
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtID = hospital.getDistrict().getId();

			String queryCount = "select "
					+

					"(select count(*) as t1 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  "
					+ "    where district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+ ",(select count((current_date - date_of_birth)/365) as t2 from ph_anc_survey pas "
					+ "left outer join ph_member_survey  pms on pas.member_id=pms.member_id  left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id "
					+ " where ((current_date - date_of_birth)/365) < 19  and district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					" ,(select count(*) as t3 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where lower(jsy_flag) =lower('Yes') and district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+ ",(select count(*) as t4 from (select count(*) as cnt from ph_anc_followup  anc left outer join ph_anc_survey  anf on anc.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=anf.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' group by  anc.anc_reg_id having count(*)>3) t1 )  "
					+

					",(select count(*) as t5 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and tt1 is not null ) "
					+

					",(select count(*) as t6 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and  tt2 is not null ) "
					+

					",(select count(*) as t7 from ph_anc_followup  anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('100')) "
					+

					",(select count(*) as t8 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('200') ) "
					+

					",(select count(*) as t9 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID
					+ "  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and delivery_place ='Home' )  "
					+

					",(select count(*) as t10 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ " and attended_by  in ('Doctor')  and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t11  from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ " and attended_by in('Trained birth Attendant') and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t12 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ "    and attended_by in('Trained birth Attendant','Doctor','Specialist Doctor','Untrained birth Attendant')  and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t13 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_place ='Government Hospital' and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t14 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='PHC' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t15 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='CHC' and ptm.delivery_type = 'C-Section(LSCS)' and  mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",( select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where mt.hospital_type_code='DH' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t17 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t18 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and gender_id = 3 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t19 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and gender_id = 2 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t20 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Still Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' )"
					+

					",(select count(*) as t21 from ph_anc_survey pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and abortions in('1','2','3','4','5','6','7','8','9','10') and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' ) "
					+

					",(select count(*) as t22 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and reg_type ='birth' and birth_weigth is not null  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t23 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and reg_type ='birth' and birth_weigth < 2.50  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t24 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '84' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t25 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '86' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t26 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t27 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and termination_type='mtp' and anf.refer_to_type = 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select district_name as disName from mas_district where district_id  ="
					+ districtID
					+ ")"
					+ ",(select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where  ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 27-04-2016
					",(select count(*) as t30 from ph_anc_followup  where (hb < 7.00 or hb = 7.00) and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(*) as t31 from ph_anc_followup  where (hb < 11.00 or hb = 11.00) and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 25-08-2016
					",(select count(opd_antenatal_card_id) as t32 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID
					+ " and tetanus_onest_dose_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(opd_antenatal_card_id) as t33 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID
					+ " and tetanus_twond_dose_date between '"
					+ startDate + "' and '" + endDate + "')";
			countList = session.createSQLQuery(queryCount).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("countList", countList);

		return map;
	}

	@Override
	public Map<String, Object> submitHmisReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		// String districtName = ""; // commented by amit das on 06-12-2016
		String districtName = box.get("districtName"); // added by amit das on 06-12-2016
		int toSet = 0 ;
		int toSetActual = 0;
		int parameterId = 0; // added by amit das on 01-12-2016
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		MasPhReportsParameters masPhReportsParameters = null;
		Transaction tx = null;
		boolean saved = false;
		try {
			
			if(districtName==null || districtName.trim().equals("")){ // condition added by amit das on 06-12-2016
				MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
				districtName = hospital.getDistrict().getDistrictName();
			}
			
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						toSet = Integer.parseInt(box.getString("hmisCount" + i)
								.toString());
					}
					if (box.getString("ahmisCount" + i) != null
							&& !box.getString("ahmisCount" + i).equals("")) {
						toSetActual = Integer.parseInt(box.getString(
								"ahmisCount" + i).toString());
					}
					if (box.getString("parameterId" + i) != null
							&& !box.getString("parameterId" + i).equals("")) {
						parameterId = Integer.parseInt(box.getString(
								"parameterId" + i).toString());
						masPhReportsParameters = new MasPhReportsParameters();
						masPhReportsParameters.setId(parameterId);
					}
					
					
					HmisDistrictReport districtReport = new HmisDistrictReport();
					districtReport.setParameter(masPhReportsParameters);
					districtReport.setReportMonth(box.getInt("months"));
					districtReport.setReportYear(box.getInt("year"));
					
					if (districtName.equalsIgnoreCase("THIRUVANANTHAPURAM")){
						districtReport.setThiruvananthapuramModify(toSet);
						districtReport.setThiruvananthapuramActula(toSetActual);
					} else if (districtName.equalsIgnoreCase("ALAPPUZHA")) {
						districtReport.setAlappuzhaModify(toSet);
						districtReport.setAlappuzhaActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Ernakulam")) {
						districtReport.setErnakulamModify(toSet);
						districtReport.setErnakulamActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Idukki")) {
						districtReport.setIdukkiModify(toSet);
						districtReport.setIdukkiActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Kannur")) {
						districtReport.setKannurModify(toSet);
						districtReport.setKannurActual(toSetActual);
					} else 	if (districtName.equalsIgnoreCase("Kasaragod")) {
						districtReport.setKasaragodModify(toSet);
						districtReport.setKasaragodActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Kollam")) {
						districtReport.setKollamModify(toSet);
						districtReport.setKollamActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Kottayam")) {
						districtReport.setKottayamModify(toSet);
						districtReport.setKottayamActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Kozhikode")) {
						districtReport.setKozhikodeModify(toSet);
						districtReport.setKozhikodeActual(toSetActual);
					} else if (districtName.equalsIgnoreCase("Malappuram")) {
						districtReport.setMalappuramModify(toSet);
						districtReport.setMalappuramActula(toSetActual);
					} else if (districtName.equalsIgnoreCase("Palakkad")) {
						districtReport.setPalakkadModify(toSet);
						districtReport.setPalakkadActula(toSetActual);
					} else if (districtName.equalsIgnoreCase("Pathanamthitta")) {
						districtReport.setPathanamthittaModify(toSet);
						districtReport.setPathanamthittaActula(toSetActual);
					} else if (districtName.equalsIgnoreCase("Thrissur")) {
						districtReport.setThrissurModify(toSet);
						districtReport.setThrissurActual(toSetActual);
					} else 	if (districtName.equalsIgnoreCase("Wayanad")) {
						districtReport.setWayanadModify(toSet);
						districtReport.setWayanadActula(toSetActual);
					
					}
					/*districtReport.setHmisParameter(box
							.getString("hmisParameter" + i));
					districtReport.setHmisId(box.getString("hmisId" + i));*/
					hbt.save(districtReport);
					saved = true;
				}


		} catch (Exception e) {
			e.printStackTrace();

		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> updateHmisReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		String districtName = "";

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtName = hospital.getDistrict().getDistrictName();

			if (districtName.equalsIgnoreCase("THIRUVANANTHAPURAM")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setThiruvananthapuramModify(toSet);
							hbt.update(districtReport);
						}

						saved = true;
					}

				}

			}

			if (districtName.equalsIgnoreCase("ALAPPUZHA")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setAlappuzhaModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Ernakulam")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setErnakulamModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Idukki")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setIdukkiModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Kannur")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setKannurModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}
			if (districtName.equalsIgnoreCase("Kasaragod")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setKasaragodModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}
			if (districtName.equalsIgnoreCase("Kollam")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setKollamModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Kottayam")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setKottayamModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}
			if (districtName.equalsIgnoreCase("Kozhikode")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setKozhikodeModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Malappuram")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setMalappuramModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Palakkad")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setPalakkadModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Pathanamthitta")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setPathanamthittaModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Thrissur")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setThrissurModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			if (districtName.equalsIgnoreCase("Wayanad")) {
				for (int i = 1; i < box.getInt("counter"); i++) {
					if (box.getString("hmisCount" + i) != null
							&& !box.getString("hmisCount" + i).equals("")) {
						int toSet = Integer.parseInt(box.getString(
								"hmisCount" + i).toString());
						int reptId = box.getInt("hmis" + i);
						HmisDistrictReport districtReport = hbt.load(
								HmisDistrictReport.class, reptId);
						if (reptId != 0) {
							districtReport.setWayanadModify(toSet);
							// districtReport.setHmisMonth(box.getInt("months"));
							// districtReport.setHmisYear(box.getInt("year"));
							hbt.update(districtReport);
						}
						saved = true;
					}
				}

			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> gethmisbyMonthValue(
			Map<String, Object> requestmap) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<MasHmisParameters> hmisParameters = new ArrayList<MasHmisParameters>(); //commented by amit das on 01-12-2016
		List<MasPhReportsParameters> hmisParameters = new ArrayList<MasPhReportsParameters>(); //commented by amit das on 01-12-2016
		List<HmisDistrictReport> list = new ArrayList<HmisDistrictReport>();
		List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
		Session session = (Session) getSession();
		// hmisParameters = session.createCriteria(MasHmisParameters.class).list(); //commented by amit das on 01-12-2016
		int month = Integer.parseInt(""
				+ requestmap.get("fromMonth").toString());
		int year = Integer.parseInt("" + requestmap.get("year").toString());
		int hospitalId = Integer.parseInt(""
				+ requestmap.get("hospitalId").toString());
		String districtName = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String propertyName = "";
		// added by amit das on 26-04-2016
		Query queryForStockDistributed = null;
		Query queryForTotalStock = null;
		Query queryForStockRecieved = null;
		List listForQuery = null;

		try {
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtName = hospital.getDistrict().getDistrictName();

			if (districtName.equalsIgnoreCase("THIRUVANANTHAPURAM")) {
				propertyName = "Thiruvananthapuram";
			} else if (districtName.equalsIgnoreCase("ALAPPUZHA")) {
				propertyName = "ALAPPUZHA";
			} else if (districtName.equalsIgnoreCase("Ernakulam")) {
				propertyName = "Ernakulam";
			} else if (districtName.equalsIgnoreCase("Idukki")) {
				propertyName = "Idukki";
			} else if (districtName.equalsIgnoreCase("Kannur")) {
				propertyName = "Kannur";
			} else if (districtName.equalsIgnoreCase("Kasaragod")) {
				propertyName = "Kasaragod";
			} else if (districtName.equalsIgnoreCase("Kollam")) {
				propertyName = "Kollam";
			} else if (districtName.equalsIgnoreCase("Kottayam")) {
				propertyName = "Kottayam";
			} else if (districtName.equalsIgnoreCase("Kozhikode")) {
				propertyName = "Kozhikode";
			} else if (districtName.equalsIgnoreCase("Malappuram")) {
				propertyName = "Malappuram";
			} else if (districtName.equalsIgnoreCase("Palakkad")) {
				propertyName = "Palakkad";
			} else if (districtName.equalsIgnoreCase("Pathanamthitta")) {
				propertyName = "Pathanamthitta";
			} else if (districtName.equalsIgnoreCase("Thrissur")) {
				propertyName = "Thrissur";
			} else if (districtName.equalsIgnoreCase("Wayanad")) {
				propertyName = "Wayanad";
			}

			// added by Amit Das on 26-04-2016
			queryForStockDistributed = session
					.createSQLQuery("select coalesce(sum(sit.qty_issued),0) as count from store_issue_t sit join store_issue_m sim on sit.issue_m_id = sim.id "
							+ "join hmis_parameter_mapping hpm on sit.item_id = hpm.item_id "
							+ "where EXTRACT(MONTH FROM sim.issue_date)  = :month and hpm.parameter_id = :parameterId");
			queryForTotalStock = session
					.createSQLQuery("select coalesce(sum(sibs.closing_stock),0) as count from store_item_batch_stock sibs "
							+ "join hmis_parameter_mapping hpm on sibs.item_id = hpm.item_id "
							+ "where hpm.parameter_id = :parameterId and sibs.hospital_id = :hospitalId");
			queryForStockRecieved = session
					.createSQLQuery("select coalesce(sum(sgt.received_qty),0) as count from store_grn_t sgt "
							+ "join store_grn_m sgm on sgt.grn_master_id = sgm.grn_master_id "
							+ "join hmis_parameter_mapping hpm on sgt.item_id = hpm.item_id "
							+ "where  EXTRACT(MONTH FROM sgm.grn_date)  = :month and hpm.parameter_id = :parameterId");

			/*Criteria cr = session.createCriteria(MasHmisParameters.class)
			.addOrder(Order.asc("Id"));*/
			// commented by amit das on 01-12-2016
	
			// added by amit das on 01-12-2016
			Criteria cr = session.createCriteria(MasPhReportsParameters.class).add(Restrictions.isNotNull("HmisId")).add(Restrictions.isNotNull("HmisParameter"))
				  .add(Restrictions.ne("HmisId","")).add(Restrictions.ne("HmisParameter",""))
				  .addOrder(Order.asc("Id"));
	
			hmisParameters = cr.list();
	
			Criteria crforRettrive = session
			.createCriteria(HmisDistrictReport.class)
			.add(Restrictions.in("Parameter", hmisParameters)) // added by amit das on 01-12-2016
			.add(Restrictions.eq("ReportMonth", month))
			.add(Restrictions.eq("ReportYear", year))
			.addOrder(Order.asc("Id"));

			list = crforRettrive.list();
			// added by Amit Das on 26-04-2016
			if (list != null && list.size() > 0) {
				for (HmisDistrictReport hmisDistrictReport : list) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();
					pojoForHmisParameter
							.setHmisDistrictReport(hmisDistrictReport);

					queryForStockDistributed.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForStockDistributed.setParameter("month", month);

					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter
							.setCountOfStockDistributed(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForTotalStock.setParameter("hospitalId", hospitalId);

					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter
							.setCountOfTotalStock(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId",
							hmisDistrictReport.getParameter().getId()); // changed by amit das on 01-12-2016
					queryForStockRecieved.setParameter("month", month);

					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter
							.setCountOfstockReceived(((BigDecimal) listForQuery
									.get(0)).intValue());

					pojoForHmisParameter
							.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter
									.getCountOfTotalStock()
									- (pojoForHmisParameter
											.getCountOfstockReceived() + pojoForHmisParameter
											.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);

				}

			} else if (hmisParameters != null && hmisParameters.size() > 0) {
				for (MasPhReportsParameters hmisParameter : hmisParameters) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();
					pojoForHmisParameter.setMasPhReportsParameters(hmisParameter);

					queryForStockDistributed.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForStockDistributed.setParameter("month", month);

					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter
							.setCountOfStockDistributed(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForTotalStock.setParameter("hospitalId", hospitalId);

					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter
							.setCountOfTotalStock(((BigDecimal) listForQuery
									.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId",
							hmisParameter.getId()); // changed by amit das on 01-12-2016
					queryForStockRecieved.setParameter("month", month);

					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter
							.setCountOfstockReceived(((BigDecimal) listForQuery
									.get(0)).intValue());

					pojoForHmisParameter
							.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter
									.getCountOfTotalStock()
									- (pojoForHmisParameter
											.getCountOfstockReceived() + pojoForHmisParameter
											.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);

				}

			}
			// end of Amit Das code

		} catch (Exception e) {
			e.printStackTrace();

		}

		map.put("list", list);
		map.put("hmisParameters", hmisParameters);
		map.put("hmisParametersList", hmisParametersList);
		map.put("propertyName", propertyName);

		return map;
	}

	@Override
	public Map<String, Object> createHmisbyMonthExcelList(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> hmisDistrictReportList = new ArrayList<Object[]>();
		int fromMonth = Integer.parseInt("" + box.get("fromMonth").toString());
		int toMonth = Integer.parseInt("" + box.get("toMonth").toString());
		int year = Integer.parseInt("" + box.get("year").toString());

		/*hmisDistrictReportList = session
				.createCriteria(HmisDistrictReport.class)
				.createAlias("Parameter", "reportParm")
				//.add(Restrictions.eq("ReportMonth", month)) //Changed by arbind on 21-09-2017
				.add(Restrictions.between("ReportMonth", fromMonth, toMonth))
				.add(Restrictions.eq("ReportYear", year))
				.addOrder(Order.asc("Id"))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("reportParm.HmisId"))
								.add(Projections.property("reportParm.HmisParameter"))
								.add(Projections.property("AlappuzhaModify"))
								.add(Projections.property("ErnakulamModify"))
								.add(Projections.property("IdukkiModify"))
								.add(Projections.property("KannurModify"))
								.add(Projections.property("KasaragodModify"))
								.add(Projections.property("KollamModify"))
								.add(Projections.property("KottayamModify"))
								.add(Projections.property("KozhikodeModify"))
								.add(Projections.property("MalappuramModify"))
								.add(Projections.property("PalakkadModify"))
								.add(Projections.property("PathanamthittaModify"))
								.add(Projections.property("ThiruvananthapuramModify"))
								.add(Projections.property("ThrissurModify"))
								.add(Projections.property("WayanadModify")))
				.list();*/
		hmisDistrictReportList = session
				.createCriteria(HmisDistrictReport.class)
				.createAlias("Parameter", "reportParm")
				.add(Restrictions.between("ReportMonth", fromMonth, toMonth))
				.add(Restrictions.eq("ReportYear", year))
				.addOrder(Order.asc("reportParm.Id"))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("reportParm.HmisId"))
								.add(Projections.property("reportParm.HmisParameter"))
								.add(Projections.sum("AlappuzhaModify"))
								.add(Projections.sum("ErnakulamModify"))
								.add(Projections.sum("IdukkiModify"))
								.add(Projections.sum("KannurModify"))
								.add(Projections.sum("KasaragodModify"))
								.add(Projections.sum("KollamModify"))
								.add(Projections.sum("KottayamModify"))
								.add(Projections.sum("KozhikodeModify"))
								.add(Projections.sum("MalappuramModify"))
								.add(Projections.sum("PalakkadModify"))
								.add(Projections.sum("PathanamthittaModify"))
								.add(Projections.sum("ThiruvananthapuramModify"))
								.add(Projections.sum("ThrissurModify"))
								.add(Projections.sum("WayanadModify"))
								.add(Projections.groupProperty("reportParm.Id"))
								.add(Projections.groupProperty("reportParm.HmisId"))
								.add(Projections.groupProperty("reportParm.HmisParameter")))
				.list();

		map.put("hmisDistrictReportList", hmisDistrictReportList);
		return map;

	}

	// added by Amit Das on 22-04-2016
	@Override
	public Map<String, Object> getHMISParameters(Box box) {
		int hospitalId = box.getInt("hospitalId");

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPhReportsParameters> hmisParametersList = new ArrayList<MasPhReportsParameters>();

		Session session = (Session) getSession();

		try {
			hmisParametersList = session
					.createCriteria(MasPhReportsParameters.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("hmisParametersList", hmisParametersList);
		return map;
	}

	// added by Amit Das on 22-04-2016
	@Override
	public Map<String, Object> getHMISParameterMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HmisParameterMapping> hmisParameterMappingList = new ArrayList<HmisParameterMapping>();

		Session session = (Session) getSession();
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(HmisParameterMapping.class);

			if (box.get("hmisParameterId") != null
					&& !box.get("hmisParameterId").equals("0")) {
				criteria.add(Restrictions.eq("HmisParameterId",
						box.get("hmisParameterId")).ignoreCase());
			}
			if (box.get("hmisParameterForIcd") != null
					&& box.get("hmisParameterForIcd").equalsIgnoreCase("icd")) {

				criteria.add(Restrictions.eq("ItemCategory",
						box.get("hmisParameterForIcd")).ignoreCase());
			} else if (box.get("hmisParameterCategory") != null
					&& !box.get("hmisParameterCategory").equals("0")) {
				criteria.add(Restrictions.eq("ItemCategory",
						box.get("hmisParameterCategory")).ignoreCase());
			}

			hmisParameterMappingList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("hmisParameterMappingList", hmisParameterMappingList);
		return map;
	}

	// added by Amit Das on 22-04-2016
	@Override
	public Map<String, Object> addHmisParameterMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			HmisParameterMapping hmisParameterMapping = new HmisParameterMapping();
			if (box.get("parameterId") != null)
				hmisParameterMapping.setParameterId(box
						.get("parameterId"));

			if (box.get("itemId") != null)
				hmisParameterMapping.setItemId(box.getLong("itemId"));

			if (box.get("itemName") != null)
				hmisParameterMapping.setItemName(box.get("itemName"));

			if (box.get("hmisParameterForIcd") != null
					&& box.get("hmisParameterForIcd").equalsIgnoreCase("icd")) {
				hmisParameterMapping.setItemCategory(box
						.get("hmisParameterForIcd"));
			} else if (box.get("itemCategory") != null) {
				hmisParameterMapping.setItemCategory(box.get("itemCategory"));
			}

			hibernateTemplate.save(hmisParameterMapping);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 22-04-2016
	@Override
	public Map<String, Object> deleteHmisParameterMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		String[] hmisParameterMappingIds = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			if (box.get("hmisParameterMappingIds") != null
					&& !box.get("hmisParameterMappingIds").trim().equals("")) {
				hmisParameterMappingIds = box.get("hmisParameterMappingIds")
						.split(",");
			}
			HmisParameterMapping hmisParameterMapping = new HmisParameterMapping();

			for (String hmisParameterMappingId : hmisParameterMappingIds) {
				if (hmisParameterMappingId != null
						&& !hmisParameterMappingId.trim().equals(""))
					hmisParameterMapping.setId(Integer
							.parseInt(hmisParameterMappingId));
				hibernateTemplate.delete(hmisParameterMapping);
			}
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 22-04-2016
	@Override
	public Map<String, Object> getItemListForAutoCompleteForHmisParameterMapping(
			Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String hmisParameterCategory = null;
		String str = null;
		Criteria crit;
		List<Object[]> objectList = null;
		List<MasStoreItem> masStoreItemsList = new ArrayList<MasStoreItem>();
		List<DgMasInvestigation> dgMasInvestigationsList = new ArrayList<DgMasInvestigation>();

		try {
			str = "%" + mapForDS.get("autoHint") + "%";
			hmisParameterCategory = (String) mapForDS
					.get("hmisParameterCategory");

			if (hmisParameterCategory != null
					&& hmisParameterCategory.equalsIgnoreCase("medicine")) {
				objectList = session
						.createCriteria(MasStoreItem.class)
						.createAlias("Section", "se")
						.add(Restrictions.like("Nomenclature", str)
								.ignoreCase())
						.add(Restrictions.eq("se.SectionName", "Medicinal"))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections.property("Id"))
										.add(Projections
												.property("Nomenclature")))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();

				for (Object[] objects : objectList) {
					MasStoreItem masStoreItem = new MasStoreItem();
					masStoreItem.setId((Integer) objects[0]);
					masStoreItem.setNomenclature((String) objects[1]);
					masStoreItemsList.add(masStoreItem);
				}

			} else if (hmisParameterCategory != null
					&& !hmisParameterCategory.equalsIgnoreCase("")
					&& hmisParameterCategory.equalsIgnoreCase("investigation")) {
				objectList = session
						.createCriteria(DgMasInvestigation.class)
						.add(Restrictions.like("InvestigationName", str)
								.ignoreCase())
						.setProjection(
								Projections
										.projectionList()
										.add(Projections.property("Id"))
										.add(Projections
												.property("InvestigationName")))
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();

				for (Object[] objects : objectList) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId((Integer) objects[0]);
					dgMasInvestigation
							.setInvestigationName((String) objects[1]);
					dgMasInvestigationsList.add(dgMasInvestigation);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masStoreItemsList", masStoreItemsList);
		map.put("dgMasInvestigationsList", dgMasInvestigationsList);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> updateIdspReportFormLDataHospitalWise(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			DiseasesIcdMapping diseasesIcdMapping = new DiseasesIcdMapping();
			if (box.get("diseasesName") != null)
				diseasesIcdMapping.setDiseasesName(box.get("diseasesName"));

			if (box.get("icdId") != null) {
				MasIcd masIcd = new MasIcd();
				masIcd.setId(box.getInt("icdId"));
				diseasesIcdMapping.setIcdCode(masIcd);
			}

			hibernateTemplate.save(diseasesIcdMapping);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> updateIdspReportDataHospitalWise(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			DiseasesIcdMapping diseasesIcdMapping = new DiseasesIcdMapping();
			if (box.get("diseasesName") != null)
				diseasesIcdMapping.setDiseasesName(box.get("diseasesName"));

			if (box.get("icdId") != null) {
				MasIcd masIcd = new MasIcd();
				masIcd.setId(box.getInt("icdId"));
				diseasesIcdMapping.setIcdCode(masIcd);
			}

			hibernateTemplate.save(diseasesIcdMapping);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> addDiseasesIcdMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			DiseasesIcdMapping diseasesIcdMapping = new DiseasesIcdMapping();
			if (box.get("diseasesName") != null)
				diseasesIcdMapping.setDiseasesName(box.get("diseasesName"));

			if (box.get("icdId") != null) {
				MasIcd masIcd = new MasIcd();
				masIcd.setId(box.getInt("icdId"));
				diseasesIcdMapping.setIcdCode(masIcd);
			}

			hibernateTemplate.save(diseasesIcdMapping);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getDiseasesIcdMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<DiseasesIcdMapping> diseasesIcdMappingList = new ArrayList<DiseasesIcdMapping>();

		Session session = (Session) getSession();
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(DiseasesIcdMapping.class);

			if (box.get("diseasesName") != null
					&& !box.get("diseasesName").equals("0")) {
				criteria.add(Restrictions.eq("DiseasesName",
						box.get("diseasesName")).ignoreCase());
			}

			diseasesIcdMappingList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("diseasesIcdMappingList", diseasesIcdMappingList);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getItemListForAutoCompleteForDiseasesIcdMapping(
			Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = null;
		Criteria crit;
		List<Object[]> objectList = null;
		List<MasIcd> masIcdList = new ArrayList<MasIcd>();

		try {
			str = "%" + mapForDS.get("autoHint") + "%";

			objectList = session
					.createCriteria(MasIcd.class)
					.add(Restrictions.like("IcdName", str).ignoreCase())
					.setProjection(
							Projections.projectionList()
									.add(Projections.property("Id"))
									.add(Projections.property("IcdName"))
									.add(Projections.property("IcdCode")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			for (Object[] objects : objectList) {
				MasIcd masIcd = new MasIcd();
				masIcd.setId((Integer) objects[0]);
				masIcd.setIcdName((String) objects[1]);
				masIcd.setIcdCode((String) objects[2]);
				masIcdList.add(masIcd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masIcdList", masIcdList);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> deleteDiseasesIcdMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		String[] diseasesIcdMappingIds = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			if (box.get("diseasesIcdMappingIds") != null
					&& !box.get("diseasesIcdMappingIds").trim().equals("")) {
				diseasesIcdMappingIds = box.get("diseasesIcdMappingIds").split(
						",");
			}
			DiseasesIcdMapping diseasesIcdMapping = new DiseasesIcdMapping();

			for (String diseasesIcdMappingId : diseasesIcdMappingIds) {
				if (diseasesIcdMappingId != null
						&& !diseasesIcdMappingId.trim().equals("")) {
					diseasesIcdMapping.setId(Integer
							.parseInt(diseasesIcdMappingId));
					hibernateTemplate.delete(diseasesIcdMapping);
				}
			}
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getIdspReportDataHospitalWise(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<IdspHospitalReport> idspHospitalReportList = new ArrayList<IdspHospitalReport>(); // list
																								// from
																								// idsp_hosiptal_report
																								// table
		List<IdspHospitalReport> idspHospitalReportByCountList = new ArrayList<IdspHospitalReport>(); // list
																										// from
																										// discharge_icd_code
																										// table
		Session session = null;
		HibernateTemplate hibernateTemplate = null;
		Criteria criteria = null;
		Query query = null;
		List list = null;
		int deptId = 0; // added by amit das on 1-7-2016
		String queryStr = null;
		int noOfOpdAttendence = 0;
		IdspHospitalReport idspHospitalReport = null;
		MasHospital masHospital = null;
		try {
			session = (Session) getSession();
			hibernateTemplate = getHibernateTemplate();

			// hospital data
			if (box.getInt(HOSPITAL_ID) != 0)
				masHospital = hibernateTemplate.get(MasHospital.class,
						box.getInt(HOSPITAL_ID));

			if (box.getInt("deptId") != 0)
				deptId = box.getInt("deptId");

			// opd attendence data
			criteria = session.createCriteria(Visit.class);
			criteria.add(Restrictions.and(Restrictions.eq("Hospital",
					masHospital), Restrictions.between("VisitDate", HMSUtil
					.convertStringTypeDateToDateType(box.get("fromDate")),
					HMSUtil.convertStringTypeDateToDateType(box.get("toDate")))));

			criteria.add(Restrictions.eq("VisitNo", 1)); // added by amit das on
															// 13-09-2016

			noOfOpdAttendence = (Integer) criteria.setProjection(
					Projections.rowCount()).uniqueResult();

			criteria = session.createCriteria(IdspHospitalReport.class);
			criteria.add(Restrictions.eq("Hospital", masHospital));
			if (box.get("fromDate") != null) {
				criteria.add(Restrictions.eq("StartDate", HMSUtil
						.convertStringTypeDateToDateType(box.get("fromDate"))));
			}
			if (box.get("toDate") != null) {
				criteria.add(Restrictions.eq("EndDate", HMSUtil
						.convertStringTypeDateToDateType(box.get("toDate"))));
			}
			idspHospitalReportList = criteria.list();

			if (idspHospitalReportList == null
					|| idspHospitalReportList.size() == 0) {
				queryStr = "select count(*) FROM discharge_icd_code dic join "
						+ "diseases_icd_mapping dim on dic.icd_id = dim.icd_code_id "
						+ "left join visit v on dic.visit_id = v.visit_id "
						+ // added by amit das on 1-7-2016
						"where dim.diseases_name =:diseasesName "
						+ "and dic.hospital_id = :hospital and dic.add_edit_date between :fromDate and :toDate";
				if (deptId != 0)
					queryStr = queryStr
							+ " and v.department_id = :departmentId";

				for (String diseasesName : DiseasesContsants.DISEASES_LIST_FOR_ICD_MAPPING) {
					idspHospitalReport = new IdspHospitalReport();
					query = session.createSQLQuery(queryStr);
					query.setParameter("diseasesName", diseasesName);
					query.setParameter("hospital", masHospital.getId());
					query.setParameter("fromDate", HMSUtil
							.convertStringTypeDateToDateType(box
									.get("fromDate")));
					query.setParameter("toDate", HMSUtil
							.convertStringTypeDateToDateType(box.get("toDate")));

					if (deptId != 0)
						query.setParameter("departmentId", deptId);

					list = query.list();
					idspHospitalReport.setDiseasesName(diseasesName);
					idspHospitalReport.setNoOfCases(((BigInteger) list.get(0))
							.intValue());
					idspHospitalReportByCountList.add(idspHospitalReport);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("idspHospitalReportList", idspHospitalReportList);
		map.put("idspHospitalReportByCountList", idspHospitalReportByCountList);
		map.put("noOfOpdAttendence", noOfOpdAttendence);
		map.put("masHospital", masHospital);
		return map;
	}

	// added by Amit Das on 29-04-2016
	@Override
	public Map<String, Object> getIdspReportDataFormLHospitalWise(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		// List<IdspHospitalReport> idspHospitalReportList = new
		// ArrayList<IdspHospitalReport>(); // list from idsp_hosiptal_report
		// table
		List<IdspHospitalReportForml> idspHospitalReportByCountList = new ArrayList<IdspHospitalReportForml>(); // list
																												// from
																												// sample_colleaction_details
																												// table
		Session session = (Session) getSession();
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		Criteria criteria = null;
		Query query = null;
		List list = null;
		IdspHospitalReportForml idspHospitalReport = null;
		MasHospital masHospital = null;
		try {
			// hospital data
			if (box.getInt(HOSPITAL_ID) != 0)
				masHospital = hibernateTemplate.get(MasHospital.class,
						box.getInt(HOSPITAL_ID));

			if (idspHospitalReportByCountList == null
					|| idspHospitalReportByCountList.size() == 0) {
				for (String diseasesName : DiseasesContsants.DISEASES_LIST_FOR_ICD_MAPPING) {
					idspHospitalReport = new IdspHospitalReportForml();
					// query changed by amit das on 29-08-2016
					query = session
							.createSQLQuery("select count(distinct dscd.sample_collection_header_id) from dg_sample_collection_details dscd "
									+ "join dg_sample_collection_header dsch on dscd.sample_collection_header_id = dsch.sample_collection_header_id "
									+ "join investigation_icd_mapping iim on dscd.investigation_id = iim.investigation_id "
									+ "join diseases_icd_mapping dim on iim.icd_code = dim.icd_code_id "
									+ "where dsch.hospital_id = :hospital and dim.diseases_name = :diseasesName and dscd.sample_coll_datetime between :fromDate and :toDate ");
					query.setParameter("diseasesName", diseasesName);
					query.setParameter("hospital", masHospital.getId());
					query.setParameter("fromDate", HMSUtil
							.convertStringTypeDateToDateType(box
									.get("fromDate")));
					query.setParameter("toDate", HMSUtil
							.convertStringTypeDateToDateType(box.get("toDate")));
					list = query.list();
					idspHospitalReport.setDiseasesName(diseasesName);
					idspHospitalReport.setNoOfSamplesTested(((BigInteger) list
							.get(0)).intValue());
					idspHospitalReportByCountList.add(idspHospitalReport);
				}
			}

			for (String diseasesName : DiseasesContsants.DISEASES_LIST_FOR_ICD_MAPPING) {
				query = session
						.createSQLQuery("select p.full_name,p.age,s.administrative_sex_code,ms.state_name,mi.investigation_name from patient p "
								+ "left join mas_administrative_sex s on p.sex_id = s.administrative_sex_id "
								+ "left join mas_state ms on p.state_id = ms.state_id "
								+ "left join inpatient ip on p.hin_no = ip.hin_no  "
								+ "left join dg_sample_collection_header dsch on ip.inpatient_id = dsch.inpatient_id  "
								+ "left join dg_sample_collection_details dscd on dscd.sample_collection_header_id = dsch.sample_collection_header_id  "
								+ "join dg_mas_investigation mi on mi.investigation_id = dscd.investigation_id  "
								+ "join investigation_icd_mapping iim on dscd.investigation_id = iim.investigation_id  "
								+ "join diseases_icd_mapping dim on iim.icd_code = dim.icd_code_id  "
								+ "where dsch.hospital_id = :hospital and dim.diseases_name = :diseasesName and dscd.sample_coll_datetime between :fromDate and :toDate ");
				query.setParameter("diseasesName", diseasesName);
				query.setParameter("hospital", masHospital.getId());
				query.setParameter("fromDate", HMSUtil
						.convertStringTypeDateToDateType(box.get("fromDate")));
				query.setParameter("toDate", HMSUtil
						.convertStringTypeDateToDateType(box.get("toDate")));
				list = query.list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("idspHospitalReportByCountList", idspHospitalReportByCountList);
		map.put("masHospital", masHospital);
		map.put("patientList", list);
		return map;
	}

	@Override
	public Map<String, Object> getItemListForAutoCompleteForICDandInvastigation(
			Map mapForDS) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String str = null;
		String strInv = null;
		Criteria crit;
		List<Object[]> objectList = null;
		List<Object[]> objectListInv = null;

		List<MasIcd> masIcdList = new ArrayList<MasIcd>();
		List<DgMasInvestigation> masInvList = new ArrayList<DgMasInvestigation>();
		try {

			strInv = "%" + mapForDS.get("invName") + "%";

			objectListInv = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.like("InvestigationName", strInv)
							.ignoreCase())
					.setProjection(
							Projections
									.projectionList()
									.add(Projections.property("Id"))
									.add(Projections
											.property("InvestigationName")))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			for (Object[] objectsInv : objectListInv) {
				DgMasInvestigation dgInv = new DgMasInvestigation();
				dgInv.setId((Integer) objectsInv[0]);
				dgInv.setInvestigationName((String) objectsInv[1]);
				masInvList.add(dgInv);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masInvList", masInvList);
		return map;
	}

	@Override
	public Map<String, Object> addInvastigationIcdMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {

			InvestigationIcdMapping icdMapping = new InvestigationIcdMapping();
			/*
			 * if(box.get("invName")!=null)
			 * icdMapping.setInvestigationName(box.get("invName"));
			 */

			if (box.getInt("invId") != 0) {
				DgMasInvestigation dgMasInvestigation = new DgMasInvestigation(
						box.getInt("invId"));
				icdMapping.setInvestigation(dgMasInvestigation);
			}

			if (box.get("icdId") != null) {
				MasIcd masIcd = new MasIcd();
				masIcd.setId(box.getInt("icdId"));
				icdMapping.setIcdCode(masIcd);
			}

			hibernateTemplate.save(icdMapping);
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	// Added by Kaushal Mishra
	@Override
	public Map<String, Object> getStudentAllDetailsById(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhStudentHealthDetails> studentList = new ArrayList<PhStudentHealthDetails>();
		Session session = (Session) getSession();
		int studentId = 0;
		if (dataMap.get("studentId") != null) {
			studentId = (Integer) dataMap.get("studentId");
		}
		studentList = session.createCriteria(PhStudentHealthDetails.class)
				.createAlias("Student", "s")
				.add(Restrictions.eq("s.Id", studentId)).list();
		logger.info("StudentListSize" + studentList.size());

		map.put("studentList", studentList);
		map.put("studentId", studentId);
		return map;
	}

	@Override
	public Map<String, Object> getIndividualStudentDetails(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhStudentHealthDetails> phStudHealthList = new ArrayList<PhStudentHealthDetails>();
		List<OpdSpecialityDetails> opdSpecialityDetails = new ArrayList<OpdSpecialityDetails>();
		Session session = (Session) getSession();
		int studentId = 0;
		int phStudentsHealthDetailsId = 0;
		Date lastChangeDate;

		if (dataMap.get("studentId") != null) {
			studentId = (Integer) dataMap.get("studentId");
		}
		if (dataMap.get("phStudentsHealthDetailsId") != null) {
			phStudentsHealthDetailsId = (Integer) dataMap
					.get("phStudentsHealthDetailsId");
		}
		phStudHealthList = session.createCriteria(PhStudentHealthDetails.class)
				.add(Restrictions.eq("Id", phStudentsHealthDetailsId)).list();

		lastChangeDate = phStudHealthList.get(0).getLastChgDate();
		opdSpecialityDetails = session
				.createCriteria(OpdSpecialityDetails.class)
				.createAlias("StudentRegistration", "sr")
				.add(Restrictions.eq("LastChgDate", lastChangeDate))
				.add(Restrictions.eq("sr.Id", studentId))
				.addOrder(Order.asc("Id")).list();

		List<MasSpecialityDeptGroup> masForGorupParameter = new ArrayList<MasSpecialityDeptGroup>();
		String empDeptCodeForPH = HMSUtil.getValuesFromPropertiesFile(
				"adt.properties", "empDeptCodeForPH");
		Criteria crForGroupParameter = getSession()
				.createCriteria(MasSpecialityDeptGroup.class, "mas")
				.createAlias("mas.Department", "dep")
				.createAlias("dep.EmpDept", "empDp")
				.add(Restrictions.eq("empDp.EmpDeptCode", empDeptCodeForPH))
				.addOrder(Order.asc("GroupSeqNo"));
		masForGorupParameter = crForGroupParameter.list();

		map.put("masForGorupParameter", masForGorupParameter);
		map.put("phStudHealthList", phStudHealthList);
		map.put("opdSpecialityDetails", opdSpecialityDetails);
		return map;
	}

	@Override
	public Map<String, Object> showStockReservationForImmunization(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
		/*
		 * List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
		 * List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		 * List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
		 * List<MasItemCategory> categoryList = new
		 * ArrayList<MasItemCategory>(); List<MasItemClass> itemClassList = new
		 * ArrayList<MasItemClass>();
		 */
		/* List<MasEmployee> jphnJphiList = new ArrayList<MasEmployee>(); */
		List<StoreReservationPartialStock> partialStockList = new ArrayList<StoreReservationPartialStock>();
		List<StoreFyDocumentNo> reservationNoList = new ArrayList<StoreFyDocumentNo>();
		/* Object jphnJphiCode[]= {"248","249","95","96"}; */
		Map<String, Object> maxMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		campGroupList = session.createCriteria(StoreReservationCampGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.list();
		reservationNoList = session.createCriteria(StoreFyDocumentNo.class)
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.list();
		/*
		 * jphnJphiList =
		 * session.createCriteria(MasEmployee.class).createAlias("Rank", "rank")
		 * .add(Restrictions.in("rank.RankCode",
		 * jphnJphiCode)).add(Restrictions.eq("Status",
		 * "y").ignoreCase()).list();
		 */
		partialStockList = session
				.createCriteria(StoreReservationPartialStock.class)
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.add(Restrictions.ge("OpenBottleExpiryDate", new Date()))
				.add(Restrictions.eq("ItemStatus", "r").ignoreCase()).list();
		String no = "";
		String finalreservationNo = "";
		int storeFyDocumentNoId = 0;
		if (reservationNoList.size() > 0) {
			for (StoreFyDocumentNo storeFyDocumentNo : reservationNoList) {
				if (storeFyDocumentNo.getReservationNo() != null) {
					no = ("" + storeFyDocumentNo.getReservationNo());
					no = getMaxNo(no);
				} else {
					no = getMaxNo("");
				}
			}
		} else {
			no = getMaxNo("");
		}
		map.put("max", no);
		map.put("campGroupList", campGroupList);
		// map.put("jphnJphiList", jphnJphiList);
		map.put("partialStockList", partialStockList);
		return map;
	}

	public String getMaxNo(String no) {
		String maxNo = "";
		String y1 = "";
		String y2 = "";
		String y3 = "";
		int tempMonth = 0;

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		int currentMonth = gregorianCalendar.get(Calendar.MONTH) + 1;
		String currentYear = "" + gregorianCalendar.get(Calendar.YEAR);

		if ((Integer.parseInt(currentYear.substring(2)) - 1) <= 9) {
			y1 = "0" + (Integer.parseInt(currentYear.substring(2)) - 1);
		} else {
			y1 = "" + (Integer.parseInt(currentYear.substring(2)) - 1);
		}

		if (Integer.parseInt(currentYear.substring(2)) <= 9) {
			y2 = "0" + Integer.parseInt(currentYear.substring(2));
		} else {
			y2 = "" + Integer.parseInt(currentYear.substring(2));
		}
		if ((Integer.parseInt(currentYear.substring(2)) + 1) <= 9) {
			y3 = "0" + (Integer.parseInt(currentYear.substring(2)) + 1);
		} else {
			y3 = "" + (Integer.parseInt(currentYear.substring(2)) + 1);
		}

		try {
			if (!no.equals("") && !no.equals("0")) {
				StringTokenizer stringTokenizer = new StringTokenizer(no, "/");
				tempMonth = Integer.parseInt(stringTokenizer.nextToken());

				String arr[] = no.split("/");
				// for no also containging month

				if (arr.length > 2) {
					if (currentMonth == (Integer.parseInt(arr[1]))) {
						tempMonth++;
					} else {
						tempMonth = 01;
					}
				}

				if (currentMonth < 4) {

					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = tempMonth + "/" + currentMonth + "/" + currentYear;
				}

			} else {
				if (currentMonth < 4) {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				} else {
					maxNo = "01" + "/" + currentMonth + "/" + currentYear;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxNo;
	}

	@Override
	public Map<String, Object> submitResrvedStockForImmunization(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		List<StoreItemBatchStock> batchStockList = new ArrayList<StoreItemBatchStock>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector itemId = box.getVector("itemId");
		Vector batchName = box.getVector("batchName");
		Vector auId = box.getVector("auId");
		Vector actualStock = box.getVector("stock");
		Vector reservedStock = box.getVector("reservedStock");
		/*
		 * Vector tillDate = box.getVector("tillDate"); Vector extension =
		 * box.getVector("extension"); Vector extensionDate =
		 * box.getVector("extensionDate");
		 */
		Session session = (Session) getSession();
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		/*
		 * int empCount = 0; if(box.getInt("hdbEmp") != 0){ empCount =
		 * (Integer)box.getInt("hdbEmp"); }
		 */

		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// ---------------------------------------code for partial stock
			// ---------------------------------------
			List<StoreItemBatchStock> itemBatchStockPartialStockList = new ArrayList<StoreItemBatchStock>();
			if (box.getString("srNo").equalsIgnoreCase("y")) {
				StoreReservationPartialStock partialStock = (StoreReservationPartialStock) hbt
						.load(StoreReservationPartialStock.class,
								box.getInt("partialstockId"));
				partialStock.setItemStatus("o");
				if (box.getInt("group") != 0) {
					StoreReservationCampGroup storeReservationCampGroup = new StoreReservationCampGroup();
					storeReservationCampGroup.setId(box.getInt("group"));
					partialStock.setCampGroup(storeReservationCampGroup);
				}
				hbt.update(partialStock);

				/*
				 * itemBatchStockPartialStockList =
				 * session.createCriteria(StoreItemBatchStock
				 * .class).add(Restrictions.eq("Item.Id",
				 * box.getInt("partialItemId"))) .add(Restrictions.eq("BatchNo",
				 * box
				 * .getString("partialBatchNo"))).add(Restrictions.eq("Hospital.Id"
				 * , box.getInt("hospitalId")))
				 * .add(Restrictions.eq("Department.Id",
				 * box.getInt("deptId"))).list();
				 * System.out.println("itemBatchStockList==="
				 * +itemBatchStockList.size());
				 * if(itemBatchStockPartialStockList.size()>0){
				 * for(StoreItemBatchStock batchStock : itemBatchStockList){ int
				 * batchStockId = batchStock.getId(); BigDecimal
				 * itemPartialStock = batchStock.getClosingStock();
				 * System.out.println("itemPartialStock==="+itemPartialStock);
				 * StoreItemBatchStock stock = (StoreItemBatchStock)
				 * hbt.load(StoreItemBatchStock.class, batchStockId);
				 * stock.setClosingStock(itemPartialStock.add(new
				 * BigDecimal(1))); hbt.update(stock);
				 * 
				 * } }
				 */

			}

			StoreReservationM storeReservationM = new StoreReservationM();
			storeReservationM.setReservationNo(box.getString("reservationNo"));
			storeReservationM.setRemarks(box.getString("remarks"));
			storeReservationM.setStatus("i");
			storeReservationM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeReservationM.setLastChgTime(time);
			Users users = new Users();
			users.setId(box.getInt("userId"));
			storeReservationM.setLastChgBy(users);
			if (box.getInt("group") != 0) {
				StoreReservationCampGroup storeReservationCampGroup = new StoreReservationCampGroup();
				storeReservationCampGroup.setId(box.getInt("group"));
				storeReservationM.setGroup(storeReservationCampGroup);
			}

			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			storeReservationM.setHospital(masHospital);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(box.getInt("deptId"));
			storeReservationM.setDepartment(masDepartment);
			hbt.save(storeReservationM);

			for (int i = 0; i < batchName.size(); i++) {
				StoreReservationT storeReservationT = new StoreReservationT();
				if (batchName.get(i) != null && !batchName.get(i).equals("")) {
					String batchNo = (String) batchName.get(i).toString();
					batchStockList = session
							.createCriteria(StoreItemBatchStock.class)
							.add(Restrictions.eq("BatchNo", batchNo)).list();
					if (batchStockList.size() > 0) {
						for (StoreItemBatchStock batchStock : batchStockList) {
							int batchId = batchStock.getId();
							StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
							storeItemBatchStock = (StoreItemBatchStock) hbt
									.load(StoreItemBatchStock.class, batchId);
							if (itemId.get(i) != null
									&& !itemId.get(i).equals("")) {
								// int itemId =
								// Integer.parseInt(itemIds.get(i).toString());
								MasStoreItem masStoreItem = new MasStoreItem();
								masStoreItem.setId(Integer.parseInt(itemId.get(
										i).toString()));
								storeReservationT.setItem(masStoreItem);
							}

							// if (stockId.get(i) != null &&
							// !stockId.get(i).equals("")) {
							StoreItemBatchStock stock = new StoreItemBatchStock();
							storeItemBatchStock.setId(batchId);
							storeReservationT.setStock(storeItemBatchStock);
							// }

							/*
							 * if (tillDate.get(i) != null &&
							 * !tillDate.get(i).equals("")) {
							 * storeReservationT.setReservationTillDate(HMSUtil
							 * .convertStringTypeDateToDateType(tillDate
							 * .get(i).toString())); }
							 */
							if (actualStock.get(i) != null
									&& !actualStock.get(i).equals("")) {
								storeReservationT
										.setActualStock(new BigDecimal(
												actualStock.get(i).toString()));
							}
							// ------------------------item
							// conversion-----------------------------
							itemConversionList = session
									.createCriteria(
											MasStoreItemConversion.class)
									.add(Restrictions.idEq(Integer
											.parseInt(auId.get(i).toString())))
									.list();
							int doses = 0;
							if (itemConversionList.size() > 0) {
								for (MasStoreItemConversion itemConversion : itemConversionList) {
									doses = itemConversion
											.getConversionFactor2();

									if (reservedStock.get(i) != null
											&& !reservedStock.get(i).equals("")) {
										BigDecimal reservedStockInDoses = new BigDecimal(
												reservedStock.get(i).toString());
										BigDecimal reservedStockInVials = new BigDecimal(
												reservedStockInDoses.intValue()
														/ doses);
										storeReservationT
												.setReservedStock(reservedStockInVials);
									}
								}

							}
							storeReservationT
									.setReservationM(storeReservationM);
							storeReservationT.setItemStatus("i");
							hbt.save(storeReservationT);

							StoreItemBatchStock itemBatchStock = (StoreItemBatchStock) hbt
									.load(StoreItemBatchStock.class, batchId);

							itemBatchStockList = session
									.createCriteria(StoreItemBatchStock.class)
									.add(Restrictions.idEq(batchId))
									.add(Restrictions.ge("ClosingStock",
											new BigDecimal(0))).list();
							if (itemBatchStockList != null
									&& itemBatchStockList.size() > 0) {
								if (itemBatchStockList.get(0) != null) {
									BigDecimal closingStock = itemBatchStockList
											.get(0).getClosingStock();
									
									if (reservedStock.get(i) != null
											&& !reservedStock.get(i).equals("")) {
										BigDecimal reserveStockInDoses = new BigDecimal(
												reservedStock.get(i).toString());
										BigDecimal reservedStockInVials = reserveStockInDoses
												.divide(new BigDecimal(doses));

										itemBatchStock
												.setClosingStock(closingStock
														.subtract(reservedStockInVials));
										itemBatchStock
												.setReservedQty(reservedStockInVials);
									}
									hbt.update(itemBatchStock);

								}
							}
						}
					}
				}
			}
			/*
			 * for (int i = 1; i <= empCount; i++) {
			 * System.out.println("empCount==rrrrrrr"
			 * +box.getInt("employeeId"+i)); StoreReservationJphn
			 * storeReservationJphn = new StoreReservationJphn();
			 * if(box.getInt("employeeId"+i) != 0){ MasEmployee masEmployee =
			 * new MasEmployee(); masEmployee.setId(box.getInt("employeeId"+i));
			 * storeReservationJphn.setEmployee(masEmployee);
			 * storeReservationJphn.setReservationM(storeReservationM);
			 * 
			 * MasHospital hospital = new MasHospital();
			 * hospital.setId(box.getInt("hospitalId"));
			 * storeReservationJphn.setHospital(hospital);
			 * hbt.save(storeReservationJphn); }
			 * 
			 * 
			 * 
			 * }
			 */

			/*
			 * Synchronization code by to generate the correct reservationNo on
			 * 04082014 at silvassa
			 */
			synchronized (this) {

				List<StoreFyDocumentNo> demandNoList = new ArrayList<StoreFyDocumentNo>();
				demandNoList = session
						.createCriteria(StoreFyDocumentNo.class)
						.add(Restrictions.eq("Department.Id",
								box.getInt("deptId")))
						.add(Restrictions.eq("Hospital.Id",
								box.getInt("hospitalId"))).list();
				if (demandNoList.size() > 0) {
					StoreFyDocumentNo storeFyDocumentNo = (StoreFyDocumentNo) demandNoList
							.get(0);
					storeFyDocumentNo.setReservationNo(box
							.getString("reservationNo"));

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
					storeFyDocumentNo.setDepartment(new MasDepartment(box
							.getInt("deptId")));
					storeFyDocumentNo.setGrnNo("0");
					storeFyDocumentNo.setGrnStartNo("0");
					storeFyDocumentNo.setIssueDeptNo("0");
					storeFyDocumentNo.setIssueDeptReturnNo("0");
					storeFyDocumentNo.setIssueDeptReturnStartNo("0");
					storeFyDocumentNo.setIssueDeptStartNo("0");
					storeFyDocumentNo.setVendorReturnNo("0");
					storeFyDocumentNo.setVendorReturnStartNo("0");
					storeFyDocumentNo.setReservationNo(box
							.getString("reservationNo"));
					String issueDeptNo = "";
					issueDeptNo = getMaxNo("0");
					String issueDeptStartNo = issueDeptNo;
					storeFyDocumentNo.setIssueDeptNo(issueDeptNo);
					storeFyDocumentNo.setIssueDeptStartNo(issueDeptStartNo);
					MasHospital hospital = new MasHospital();
					hospital.setId(box.getInt("hospitalId"));
					storeFyDocumentNo.setHospital(hospital);
					hbt.save(storeFyDocumentNo);
					hbt.refresh(storeFyDocumentNo);
					// session.save(storeFyDocumentNo);
					// session.refresh(storeFyDocumentNo);

				}
			}

			/*
			 * End By for synchronization
			 */
			//

			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showStockConsumptionForImmunization(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReservationM> storeReservationMList = new ArrayList<StoreReservationM>();
		List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
		Session session = (Session) getSession();
		storeReservationMList = session.createCriteria(StoreReservationM.class)
				.add(Restrictions.eq("Status", "i").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.list();
		campGroupList = session.createCriteria(StoreReservationCampGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("storeReservationMList", storeReservationMList);
		map.put("campGroupList", campGroupList);
		return map;
	}

	@Override
	public Map<String, Object> responseForStockConsumptionForImmunization(
			Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<StoreReservationM> reservationNoList = new ArrayList<StoreReservationM>();
		List<StoreReservationM> storeReservationMList = new ArrayList<StoreReservationM>();
		List<StoreReservationT> storeReservationTList = new ArrayList<StoreReservationT>();
		reservationNoList = session.createCriteria(StoreReservationM.class)
				.add(Restrictions.idEq(box.getInt("reservationId")))
				.add(Restrictions.eq("Status", "i").ignoreCase()).list();
		storeReservationMList = session.createCriteria(StoreReservationM.class)
				.add(Restrictions.eq("Status", "i").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.list();
		storeReservationTList = session.createCriteria(StoreReservationT.class)
				.createAlias("ReservationM", "header")
				.add(Restrictions.eq("header.Id", box.getInt("reservationId")))
				.add(Restrictions.eq("header.Status", "i").ignoreCase())
				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.list();

		map.put("reservationNoList", reservationNoList);
		map.put("storeReservationMList", storeReservationMList);
		map.put("storeReservationTList", storeReservationTList);
		return map;
	}

	@Override
	public Map<String, Object> submitConsumptionForImmunization(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemBatchStockList = new ArrayList<StoreItemBatchStock>();
		List<StoreItemBatchStock> batchStockList = new ArrayList<StoreItemBatchStock>();
		List<StoreItemBatchStock> stockList = new ArrayList<StoreItemBatchStock>();
		List<MasStoreItemConversion> itemConversionList = new ArrayList<MasStoreItemConversion>();
		List<StoreReservationPartialStock> partialStockList = new ArrayList<StoreReservationPartialStock>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector itemId = box.getVector("itemId");
		Vector batchId = box.getVector("batchId");
		Vector auId = box.getVector("auId");
		Vector actualStock = box.getVector("stock");
		Vector reservedStock = box.getVector("reservedStock");
		Vector consumedQty = box.getVector("consumedQty");
		Vector returnQty = box.getVector("returnQty");
		Vector reservationTId = box.getVector("reservationTId");
		Vector expiryDays = box.getVector("expiryDays");
		Vector batchNo = box.getVector("batchNo");

		/*
		 * Vector tillDate = box.getVector("tillDate"); Vector extension =
		 * box.getVector("extension"); Vector extensionDate =
		 * box.getVector("extensionDate");
		 */
		Session session = (Session) getSession();
		boolean flag = false;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		int empCount = 0;
		if (box.getInt("hdbEmp") != 0) {
			empCount = (Integer) box.getInt("hdbEmp");
		}

		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			for (int i = 0; i < reservationTId.size(); i++) {
				if (reservationTId.get(i) != null
						&& !reservationTId.get(i).equals("")) {

					StoreReservationT storeReservationT = (StoreReservationT) hbt
							.load(StoreReservationT.class, Integer
									.parseInt(reservationTId.get(i).toString()));
					if (actualStock.get(i) != null
							&& !actualStock.get(i).equals("")) {
						storeReservationT.setActualStock(new BigDecimal(
								actualStock.get(i).toString()));
					}
				
					itemConversionList = session
							.createCriteria(MasStoreItemConversion.class)
							.add(Restrictions.idEq(Integer.parseInt(auId.get(i)
									.toString()))).list();

					if (itemConversionList.size() > 0) {
						for (MasStoreItemConversion itemConversion : itemConversionList) {
							int doses = itemConversion.getConversionFactor2();
							

							if (consumedQty.get(i) != null
									&& !consumedQty.get(i).equals("")) {
								BigDecimal consumedQtyInDoses = new BigDecimal(
										consumedQty.get(i).toString());
								BigDecimal consumedQtyInVials = new BigDecimal(
										consumedQtyInDoses.intValue() / doses);
								
								logger.info("consumedQtyInVials=="
										+ consumedQtyInVials);
								storeReservationT
										.setConsumedQty(consumedQtyInVials);
							}

							/*
							 * if (consumedQty.get(i) != null &&
							 * !consumedQty.get(i).equals("")) { BigDecimal
							 * consumedQtyInDoses = new
							 * BigDecimal(consumedQty.get(i).toString());
							 * BigDecimal consumedQtyInVials =
							 * consumedQtyInDoses.divide(new BigDecimal(10));
							 * System.out.println("consumedQtyInVials=="+
							 * consumedQtyInVials);
							 * storeReservationT.setConsumedQty
							 * (consumedQtyInVials); }
							 */

							if (returnQty.get(i) != null
									&& !returnQty.get(i).equals("")) {
								BigDecimal returnQtyInDoses = new BigDecimal(
										returnQty.get(i).toString());
								
								logger.info("returnQtyInDoses=="+ returnQtyInDoses);

								BigDecimal returnQtyInVials = new BigDecimal(
										returnQtyInDoses.intValue() / doses);
								
								logger.info("returnQtyInVials=="	+ returnQtyInVials);
								BigDecimal returnQtyremainder = returnQtyInDoses
										.remainder(new BigDecimal(doses));
								
								logger.info("returnQtyremainder=="
										+ returnQtyremainder);
								BigDecimal returnQtyInStock = returnQtyInDoses
										.divideToIntegralValue(new BigDecimal(
												doses));
								
								logger.info("returnQtyInStock=="
										+ returnQtyInStock);
								storeReservationT
										.setReturnQty(returnQtyInVials);
								// ------------------save partial
								// Stock-----------------------------------
								/*
								 * partialStockList = session.createCriteria(
								 * StoreReservationPartialStock
								 * .class).add(Restrictions.eq("Hospital.Id",
								 * box.getInt("hospitalId")))
								 * .add(Restrictions.eq("Department.Id",
								 * box.getInt("deptId")))
								 * .add(Restrictions.eq("Item.Id",
								 * Integer.parseInt(itemId.get(i).toString())))
								 * .add(Restrictions.eq("BatchNo",
								 * batchNo.get(i)
								 * .toString())).add(Restrictions.eq
								 * ("ItemStatus", "r")).list();
								 * System.out.println
								 * ("partialStockList==="+partialStockList
								 * .size()); if(partialStockList.size()>0){
								 * for(StoreReservationPartialStock partialStock
								 * : partialStockList){
								 * partialStock.setItemStatus("c");
								 * hbt.save(partialStock);
								 * 
								 * itemBatchStockList =
								 * session.createCriteria(StoreItemBatchStock
								 * .class).add(Restrictions.eq("Item.Id",
								 * Integer.parseInt(itemId.get(i).toString())))
								 * .add(Restrictions.eq("BatchNo",
								 * batchNo.get(i).toString())).list();
								 * System.out.println("itemBatchStockList==="+
								 * itemBatchStockList.size());
								 * if(itemBatchStockList.size()>0){
								 * for(StoreItemBatchStock batchStock :
								 * itemBatchStockList){ int batchStockId =
								 * batchStock.getId(); BigDecimal itemStock =
								 * batchStock.getClosingStock();
								 * System.out.println("itemStock==="+itemStock);
								 * StoreItemBatchStock stock =
								 * (StoreItemBatchStock)
								 * hbt.load(StoreItemBatchStock.class,
								 * batchStockId);
								 * stock.setClosingStock(itemStock.add(new
								 * BigDecimal(1))); hbt.update(stock);
								 * 
								 * } }
								 * 
								 * }
								 * 
								 * }
								 */

								if (returnQtyremainder
										.compareTo(new BigDecimal(0)) > 0) {
									StoreReservationPartialStock storeReservationPartialStock = new StoreReservationPartialStock();
									if (itemId.get(i) != null
											&& !itemId.get(i).equals("")) {
										MasStoreItem masStoreItem = new MasStoreItem();
										masStoreItem.setId(Integer
												.parseInt(itemId.get(i)
														.toString()));
										storeReservationPartialStock
												.setItem(masStoreItem);
									}
									int noOfDays = 0;
									if (expiryDays.get(i) != null
											&& !expiryDays.get(i).equals("")) {
										noOfDays = Integer.parseInt(expiryDays
												.get(i).toString());
									}
									logger.info("noOfDays==" + noOfDays);
									
									storeReservationPartialStock
											.setOpenDate(new Date());
									String openVialExpiryDate = "";
									Calendar cal = new GregorianCalendar();
									cal.setTime(new Date());
									cal.add(Calendar.DAY_OF_MONTH, noOfDays);

									openVialExpiryDate = HMSUtil
											.convertDateToStringWithoutTime(cal
													.getTime());
									
									logger.info("openVialExpiryDate=="
											+ openVialExpiryDate);
									storeReservationPartialStock
											.setOpenBottleExpiryDate(HMSUtil
													.convertStringTypeDateToDateType(openVialExpiryDate));
									if (batchNo.get(i) != null
											&& !batchNo.get(i).equals("")) {
										storeReservationPartialStock
												.setBatchNo(batchNo.get(i)
														.toString());
									}

									MasHospital hospital = new MasHospital();
									hospital.setId(box.getInt("hospitalId"));
									storeReservationPartialStock
											.setHospital(hospital);

									MasDepartment masDepartment = new MasDepartment();
									masDepartment.setId(box.getInt("deptId"));
									storeReservationPartialStock
											.setDepartment(masDepartment);

									storeReservationPartialStock
											.setQty(new BigDecimal(1));
									storeReservationPartialStock
											.setQtyInDoses(returnQtyremainder);
									storeReservationPartialStock
											.setItemStatus("r");
									hbt.save(storeReservationPartialStock);
								}
								// -------------update return qty in
								// Stock----------------------------------
								if (returnQtyInStock
										.compareTo(new BigDecimal(0)) > 0) {
									if (batchId.get(i) != null
											&& !batchId.get(i).equals("")) {
										
										StoreItemBatchStock batchStock = (StoreItemBatchStock) hbt
												.load(StoreItemBatchStock.class,
														Integer.parseInt(batchId
																.get(i)
																.toString()));

										batchStockList = session
												.createCriteria(
														StoreItemBatchStock.class)
												.add(Restrictions.idEq(Integer
														.parseInt(batchId
																.get(i)
																.toString())))
												.add(Restrictions.ge(
														"ClosingStock",
														new BigDecimal(0)))
												.list();
										if (batchStockList != null
												&& batchStockList.size() > 0) {
											if (batchStockList.get(0) != null) {
												BigDecimal closingStock = batchStockList
														.get(0)
														.getClosingStock();
												BigDecimal reservedStockIn = batchStockList
														.get(0)
														.getReservedQty();
												
												logger.info("closingStock==="
														+ closingStock);
												BigDecimal totalClosingStock = closingStock
														.add(returnQtyInStock);
												logger.info("totalClosingStock==="
														+ totalClosingStock);
												batchStock
														.setClosingStock(totalClosingStock);
												batchStock
														.setReservedQty(new BigDecimal(
																0));
												hbt.update(batchStock);
											}

										}
									}
								}
							}

							hbt.update(storeReservationT);
							// }

							/*
							 * if (batchId.get(i) != null &&
							 * !batchId.get(i).equals("")) { StoreItemBatchStock
							 * itemBatchStock = (StoreItemBatchStock)
							 * hbt.load(StoreItemBatchStock.class,
							 * Integer.parseInt(batchId.get(i).toString()));
							 * 
							 * itemBatchStockList =
							 * session.createCriteria(StoreItemBatchStock
							 * .class).
							 * add(Restrictions.idEq(Integer.parseInt(batchId
							 * .get
							 * (i).toString()))).add(Restrictions.ge("ReservedQty"
							 * ,new BigDecimal(0))).list(); if
							 * (itemBatchStockList != null &&
							 * itemBatchStockList.size() > 0) { if
							 * (itemBatchStockList.get(0) != null) { BigDecimal
							 * reservedQtyStock =
							 * itemBatchStockList.get(0).getReservedQty();
							 * 
							 * if (consumedQty.get(i) != null &&
							 * !consumedQty.get(i).equals("")) { BigDecimal
							 * consumeQty = new
							 * BigDecimal(consumedQty.get(i).toString());
							 * itemBatchStock
							 * .setReservedQty(reservedQtyStock.subtract
							 * (consumeQty)); } hbt.update(itemBatchStock); }
							 * 
							 * } }
							 */
						}
					}
				}

			}
			if (box.getInt("storeReservationMId") != 0) {
				StoreReservationM storeReservationM = (StoreReservationM) hbt
						.load(StoreReservationM.class,
								box.getInt("storeReservationMId"));
				storeReservationM.setStatus("Consumed");
				hbt.update(storeReservationM);
			}

			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> fillItemsForDefectiveDrugs(
			Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		// String pvms = null;
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		List<Object[]> batchList = new ArrayList<Object[]>();
		int deptId = 0;
		int hospitalId = 0;
		String blockFlag = "";
		// BigDecimal stockIn = null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("blockFlag") != null) {
			blockFlag = (String) dataMap.get("blockFlag");
		}
		int userType = 0;
		if (dataMap.get("userType") != null) {
			userType = Integer.parseInt("" + dataMap.get("userType"));
		}
		Date currentDate = new Date();
		try {
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			String date4MySQL = formatterOut.format(formatterIn.parse(date));
			currentDate = java.sql.Date.valueOf(date4MySQL);
		} catch (java.text.ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			String str = "" + dataMap.get("pvmsNo");

			Criteria c = session
					.createCriteria(MasStoreItem.class)
					.add(Restrictions.eq("PvmsNo", str))
					.createAlias("Section", "section")
					.add(Restrictions.eq("section.SectionName", "DRUGS")
							.ignoreCase());
			itemList = c.list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		try {
			int itemId = 0;
			for (MasStoreItem masStoreItem : itemList) {
				itemId = masStoreItem.getId();

			}

			/*
			 * if (itemId != 0) { Criteria c2 =
			 * session.createCriteria(MasStoreBrand.class).add(
			 * Restrictions.eq("Item.Id", itemId)); brandList = c2.list(); }
			 */
			// code for manufacturer List which will be updated by updating
			// masStore-item Screen
			if (itemId != 0) {

				
				String blockStatus[] = { "Temporary Block", "Parmanent Block" };
				Criteria c3 = session
						.createCriteria(StoreItemBatchStock.class)
						.add(Restrictions.eq("Item.Id", itemId))
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("Department.Id", deptId))
						.add(Restrictions.gt("ClosingStock", new BigDecimal(0)))
						.add(Restrictions.or(Restrictions.not(Restrictions.in(
								"BlockStatus", blockStatus)), Restrictions
								.isNull("BlockStatus")))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.groupProperty("Item.Id"))
										.add(Projections
												.groupProperty("BatchNo")));
				batchList = c3.list();

			}

			// map.put("brandList", brandList);
			map.put("itemList", itemList);
			map.put("batchList", batchList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public Map<String, Object> getExpiryDateInAjax(Map<String, Object> dataMap) {
		Session session = (Session) getSession();
		int batchNo = 0;
		Date expiryDate = null;
		Date manufactureDate = null;
		int manufactureId = 0;
		String manufactureName = "";
		String batchNoString = "";
		int itemId = 0;
		// List objectList = new ArrayList();
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
		Map<String, Object> map = new HashMap<String, Object>();
		int mId = 1;
		String batchName = "";
		int hospitalId = (Integer) dataMap.get("hospitalId");
		int deptId = (Integer) dataMap.get("deptId");
		try {
			/*
			 * if (dataMap.get("deptId") != null) { deptId = Integer.parseInt(""
			 * + dataMap.get("deptId")); }
			 */

			if (dataMap.get("itemId") != null) {
				itemId = Integer.parseInt("" + dataMap.get("itemId"));

			}
			if (dataMap.get("batchNo") != null) {
				batchNo = Integer.parseInt("" + dataMap.get("batchNo"));

			} else if (dataMap.get("batchName") != null) {
				batchName = ("" + dataMap.get("batchName"));

				
				if (!batchName.equals("")) {
					List<Integer> batchIdList = new ArrayList<Integer>();
					batchIdList = session
							.createCriteria(StoreItemBatchStock.class)
							.add(Restrictions.eq("BatchNo", batchName))
							.add(Restrictions.eq("Department.Id", deptId))
							.add(Restrictions.eq("Hospital.Id", hospitalId))
							.add(Restrictions.eq("Item.Id", itemId))
							.setProjection(Projections.property("Id")).list();
					batchNo = batchIdList.get(0);
				}
			}
			storeItemBatchStock = (StoreItemBatchStock) session.load(
					StoreItemBatchStock.class, batchNo);
			if (storeItemBatchStock != null) {
				if (storeItemBatchStock.getExpiryDate() != null) {
					expiryDate = java.sql.Date
							.valueOf(("" + storeItemBatchStock.getExpiryDate()));
					map.put("expiryDate", expiryDate);
				}
				if (storeItemBatchStock.getManufactureDate() != null) {
					manufactureDate = java.sql.Date
							.valueOf(("" + storeItemBatchStock
									.getManufactureDate()));
				}
				if (storeItemBatchStock.getManufacturer() != null) {
					manufactureId = storeItemBatchStock.getManufacturer()
							.getId();
					manufactureName = storeItemBatchStock.getManufacturer()
							.getManufacturerName();
				}
				if (storeItemBatchStock.getBatchNo() != null) {
					batchNoString = storeItemBatchStock.getBatchNo();

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("batchNoString", batchNoString);
		map.put("manufactureDate", manufactureDate);
		map.put("manufactureId", manufactureId);
		map.put("manufactureName", manufactureName);
		map.put("storeItemBatchStock", storeItemBatchStock);
		map.put("mId", mId);
		return map;
	}

	// Added by Amit Das on 04-05-2016
	@Override
	public Map<String, Object> addTempDataForAntenatalCareReport(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhStudentHealthDetails> studentList = new ArrayList<PhStudentHealthDetails>();
		Session session = (Session) getSession();
		int hospitalId = 0;
		if (box.getInt(HOSPITAL_ID) != 0) {
			hospitalId = box.getInt(HOSPITAL_ID);
		}
		session.createSQLQuery(
				"select monthly_data_of_antenatal_care(:hospitalId)")
				.setParameter("hospitalId", hospitalId);

		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getIcdInvestigationMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<InvestigationIcdMapping> investigationIcdMappingList = new ArrayList<InvestigationIcdMapping>();

		Session session = (Session) getSession();
		Criteria criteria = null;
		try {
			criteria = session.createCriteria(InvestigationIcdMapping.class);
			/*
			 * if (box.get("diseasesName") != null &&
			 * !box.get("diseasesName").equals("0")) {
			 * criteria.add(Restrictions.eq("DiseasesName",
			 * box.get("diseasesName")).ignoreCase()); }
			 */
			investigationIcdMappingList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("investigationIcdMappingList", investigationIcdMappingList);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> deleteIcdInvestigationMapping(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		String[] icdInvestigationMappingIds = null;
		HibernateTemplate hibernateTemplate = getHibernateTemplate();
		hibernateTemplate.setFlushModeName("FLUSH_EAGER");
		hibernateTemplate.setCheckWriteOperations(false);
		try {
			if (box.get("icdInvestigationMappingIds") != null
					&& !box.get("icdInvestigationMappingIds").trim().equals("")) {
				icdInvestigationMappingIds = box.get(
						"icdInvestigationMappingIds").split(",");
			}
			InvestigationIcdMapping investigationIcdMapping = new InvestigationIcdMapping();

			for (String icdInvestigationMappingId : icdInvestigationMappingIds) {
				if (icdInvestigationMappingId != null
						&& !icdInvestigationMappingId.trim().equals("")) {
					investigationIcdMapping.setId(Integer
							.parseInt(icdInvestigationMappingId));
					hibernateTemplate.delete(investigationIcdMapping);
				}
			}
			result = "success";
		} catch (Exception e) {
			result = "fail";
			e.printStackTrace();
		}

		map.put("result", result);
		return map;
	}

	@Override
	public Map<String, Object> vectorSurveyDetail(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		Session session = (Session) getSession();
		List<LocationParameterMapping> locationParameterList = session
				.createCriteria(LocationParameterMapping.class)
				.createAlias("Locality", "loc")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("loc.LocalityName")).list();
		MasHospital masHospital = (MasHospital) session.get(MasHospital.class,
				hospitalId);
		map.put("locationParameterList", locationParameterList);
		if (masHospital != null) {
			map.put("masHospital", masHospital);
		}
		return map;
	}

	@Override
	public Map<String, Object> showVectorDetail(Box box, String[] loc) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> phOsVectorValues = new ArrayList<Object[]>();
		int hospitalId = box.getInt("hospitalId");
		// String localityId = box.getString("location");
		/*
		 * List<Integer> locIdList = new ArrayList<Integer>();
		 * if(box.getArrayList("locIdList")!=null){ locIdList =
		 * box.getArrayList("locIdList"); }
		 */
		Session session = (Session) getSession();
		List<LocationParameterMapping> locationParameterList = session
				.createCriteria(LocationParameterMapping.class)
				.createAlias("Locality", "loc")
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.addOrder(Order.asc("loc.LocalityName")).list();
		MasHospital masHospital = (MasHospital) session.get(MasHospital.class,
				hospitalId);
		if (masHospital != null) {
			map.put("masHospital", masHospital);
		}
		Date fromDateFormat = null;
		Date toDateFormat = null;

		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = "";
		String toDate = "";
		if (box.getString("fromDate") != "" && box.getString("toDate") != "") {
			fromDateFormat = HMSUtil.convertStringTypeDateToDateType(box
					.getString("fromDate"));
			toDateFormat = HMSUtil.convertStringTypeDateToDateType(box
					.getString("toDate"));
			fromDate = formatterOut.format(fromDateFormat);
			toDate = formatterOut.format(toDateFormat);

		}

		if (!box.getString("locId").equals("")
				&& !box.getString("fromDate").equals("")
				&& !box.getString("toDate").equals("")) {
			String query = "select pov.breeding_water_source_positive,pov.breeding_water_source_count,pov.pupae_count"
					+ " from ph_os_vector pov"
					+ " inner join ph_house_survey phs on  phs.house_hold_id=pov.house_id"
					+ " inner join ph_village_survey pvs on pvs.survey_unique_id=cast(pov.house_id as integer)"
					+ " where phs.locality_id in ("
					+ box.getString("locId")
					+ ") and phs.hospital_id="
					+ hospitalId
					+ " and pov.reg_date between '"
					+ fromDate
					+ "' and  '"
					+ toDate
					+ "' or pvs.locality_id in ("
					+ box.getString("locId")
					+ ")  and pvs.hospital_id="
					+ hospitalId
					+ " and pov.reg_date between '"
					+ fromDate
					+ "' and  '" + toDate + "'";
			phOsVectorValues = session.createSQLQuery(query).list();
		}
		if (box.getString("locId").equals("")
				&& !box.getString("fromDate").equals("")
				&& !box.getString("toDate").equals("")) {
			String query = "select pov.breeding_water_source_positive,pov.breeding_water_source_count,pov.pupae_count"
					+ " from ph_os_vector pov"
					+ " inner join ph_house_survey phs on  phs.house_hold_id=pov.house_id"
					+ " inner join ph_village_survey pvs on pvs.survey_unique_id=cast(pov.house_id as integer)"
					+ " where  phs.hospital_id="
					+ hospitalId
					+ " and pov.reg_date between '"
					+ fromDate
					+ "' and  '"
					+ toDate
					+ "' or pvs.hospital_id="
					+ hospitalId
					+ " and pov.reg_date between '"
					+ fromDate
					+ "' and  '"
					+ toDate + "'";
			phOsVectorValues = session.createSQLQuery(query).list();
		}
		
		int noOfHouseInspected = phOsVectorValues.size();
		int noOfHouseInfected = 0;
		int noOfPositiveContainer = 0;
		int noOfContainerInspected = 0;
		int noOfPupae = 0;
		for (Object[] obj : phOsVectorValues) {
			if (Integer.parseInt(obj[0] + "") > 0) {
				// count of breeding_water_source_positive
				noOfHouseInfected = noOfHouseInfected + 1;
			}
			if (Integer.parseInt(obj[0] + "") > 0) {
				// sum of breeding_water_source_positive
				noOfPositiveContainer = noOfPositiveContainer
						+ Integer.parseInt(obj[0] + "");
			}
			if (Integer.parseInt(obj[1] + "") > 0) {
				// sum of breeding_water_source_count
				noOfContainerInspected = noOfContainerInspected
						+ Integer.parseInt(obj[1] + "");
			}
			if (Integer.parseInt(obj[2] + "") > 0) {
				// sum of pupae_count
				noOfPupae = noOfPupae + Integer.parseInt(obj[2] + "");
			}

		}
		double houseIndex = 0;
		double breteauIndex = 0;
		double pupaeIndex = 0;
		double containerIndex = 0;
		if (noOfHouseInspected != 0) {
			houseIndex = noOfHouseInfected * 100 / noOfHouseInspected;
			breteauIndex = noOfPositiveContainer * 100 / noOfHouseInspected;
			pupaeIndex = noOfPupae * 100 / noOfHouseInspected;
		}
		if (noOfContainerInspected != 0) {
			containerIndex = noOfPositiveContainer * 100
					/ noOfContainerInspected;
		}

		map.put("locationParameterList", locationParameterList);
		map.put("houseIndex", houseIndex);
		map.put("containerIndex", containerIndex);
		map.put("breteauIndex", breteauIndex);
		map.put("pupaeIndex", pupaeIndex);
		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getMCTSReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = null;
		HibernateTemplate hibernateTemplate = null;
		Criteria criteria = null;
		Query query = null;
		List<Object[]> list = null;
		int noOfOpdAttendence = 0;
		IdspHospitalReport idspHospitalReport = null;
		MasHospital masHospital = null;
		try {
			session = (Session) getSession();

			query = session
					.createSQLQuery("select distinct pas.reg_date,pas.last_chg_date as updated_date, mh.hospital_name, "
							+ "mv.village_name, phs.address, extract(year from pas.reg_date) as year, pas.anc_reg_id as mother_id,pms.name as mother_name, "
							+ "(select name from ph_member_survey where member_id = per.member2_id) as husband_name, pms.contact_no, "
							+ "pms.date_of_birth, extract (year from age(now(),pms.date_of_birth)) as age, mr.religion_name as caste, "
							+ "pms.aadhaar_no, pas.lmp_date,(select followup_date from ph_anc_followup where anc_reg_id = pas.anc_reg_id order by anc_reg_id limit 1) as anc1_date, "
							+ "(select followup_date from ph_anc_followup where anc_reg_id = pas.anc_reg_id order by anc_reg_id limit 1 offset 1) as anc2_date, "
							+ "(select followup_date from ph_anc_followup where anc_reg_id = pas.anc_reg_id order by anc_reg_id limit 1 offset 2) as anc3_date, "
							+ "(select followup_date from ph_anc_followup where anc_reg_id = pas.anc_reg_id order by anc_reg_id limit 1 offset 3) as anc4_date, "
							+ "(select tt1 from ph_anc_followup where anc_reg_id = pas.anc_reg_id and tt1 is not null limit 1 ) as tt1_date, "
							+ "(select tt2 from ph_anc_followup where anc_reg_id = pas.anc_reg_id and tt2 is not null limit 1 ) as tt2_date, "
							+ "paf.booster as tt_booster_date, patm.termination_date as delievery_or_abortion_date, pas.edc_date as expected_date_of_delivery, "
							+ "patm.delivery_type, patm.complications, d.date_of_discharge, "
							+ "( CASE "
							+ "WHEN exists(select * from ph_pnc_survey where pnc_type = 'MO' and anc_reg_id = pas.anc_reg_id) "
							+ "THEN 'Yes'"
							+ "ELSE 'No'"
							+ "END ) as pnc_home_visit, "
							+ "(select condition from ph_pnc_survey_details where anc_reg_id = pas.anc_reg_id limit 1) as condition, "
							+ "pas.bank_name,pas.ifsc_code,pas.acc_no,pas.remarks "
							+ "from ph_anc_survey pas "
							+ "left join mas_hospital mh on mh.hospital_id = pas.hospital_id "
							+ "left join ph_member_survey pms on pms.member_id = pas.member_id "
							+ "left join ph_house_survey phs on phs.house_hold_id = pms.house_id "
							+ "left join mas_village mv on mv.village_id = phs.village_id "
							+ "left join ph_ecr_registration per on per.member1_id = pms.member_id "
							+ "left join mas_religion mr on mr.religion_id = pms.religion "
							+ "left join ph_anc_followup paf on paf.anc_reg_id = pas.anc_reg_id "
							+ "left join ph_anc_termination_m patm on patm.anc_reg_id = pas.anc_reg_id and (termination_type = 'del' or termination_type = 'mis') "
							+ "left join patient p on p.member_id = pms.member_id "
							+ "left join discharge d on d.hin_id = p.hin_id "
							+ "left join ph_pnc_survey_details ppsd on ppsd.anc_reg_id = pas.anc_reg_id "
							+ "where (pas.hospital_id = :hospitalId or mh.parent_institute_id = :hospitalId)"
							+ " and (pas.reg_date between :fromDate and :toDate)");
			query.setParameter("hospitalId", box.getInt(HOSPITAL_ID));
			query.setParameter("fromDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
			query.setParameter("toDate", HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));

			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getlocalityList2(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasLocality> masloc = new ArrayList<PhMasLocality>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		Session session = (Session) getSession();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference

		int hospitalId = 0;
		int subcenterId = 0;
		if (dataMap.get("hospitalId") != null
				&& !dataMap.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(dataMap.get("hospitalId").toString());
		}
		if (dataMap.get("subcenterId") != null
				&& !dataMap.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(dataMap.get("subcenterId")
					.toString());
		}

		int ward = 0;
		try {
			if (dataMap.get("ward") != null) {
				ward = (Integer) dataMap.get("ward");
			}
			
			masloc = session.createCriteria(PhMasLocality.class)
					.createAlias("Ward", "w")
					.add(Restrictions.eq("w.Id", ward))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Criteria cr = getSession().createCriteria(
				LocationParameterMapping.class);
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", subcenterId));
		}
		if (hospitalId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", hospitalId));
		}

		mappingsList = cr.list();

		map.put("mappingsList", mappingsList);
		map.put("masloc", masloc);

		return map;
	}

	@Override
	public Map<String, Object> getTalukListForVillageMapping(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasTaluk> talukList = new ArrayList<MasTaluk>();
		List<MasWard> ward = new ArrayList<MasWard>();
		List<MasLsg> lsg = new ArrayList<MasLsg>();
		Session session = (Session) getSession();
		//session = (Session) getSession();   //commented by Om Tripathi extra reference
		int district = 0;
		try {

			if (dataMap.get("district") != null) {
				district = (Integer) dataMap.get("district");
			}
			talukList = session.createCriteria(MasTaluk.class)
					.createAlias("District", "g")
					.add(Restrictions.eq("g.Id", district))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

			/*
			 * ward = session.createCriteria(MasWard.class)
			 * .createAlias("District", "dist") .add(Restrictions.eq("dist.Id",
			 * district)) .add(Restrictions.eq("Status",
			 * "y").ignoreCase()).list();
			 * 
			 * lsg= session.createCriteria(MasLsg.class)
			 * .createAlias("District", "dist") .add(Restrictions.eq("dist.Id",
			 * district)) .add(Restrictions.eq("Status",
			 * "y").ignoreCase()).list();
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		map.put("ward", ward);
		map.put("talukList", talukList);
		map.put("lsg", lsg);
		return map;

	}

	@Override
	public Map<String, Object> getvilageListForVillageMapping(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasVillage> village = new ArrayList<MasVillage>();
		List<LocationParameterMapping> mappingsList = new ArrayList<LocationParameterMapping>();
		//List<MasDistrict> district = new ArrayList<MasDistrict>();

		Session session = (Session) getSession();
		// session = (Session) getSession();   //commented by Om Tripathi extra reference
		int taluk = 0;

		/*URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}

		int stateId = Integer.parseInt(prop.getProperty("stateId"));*/

		int districtId = 0;
		int villSubcenterId = 0;
		if (dataMap.get("districtId") != null) {
			districtId = (Integer) dataMap.get("districtId");
		}
		if (dataMap.get("villSubcenterId") != null) {
			villSubcenterId = (Integer) dataMap.get("villSubcenterId");
		}

		try {
			if (dataMap.get("taluk") != null) {
				taluk = (Integer) dataMap.get("taluk");
			}

			/*
			 * district=session.createCriteria(MasDistrict.class)
			 * .createAlias("State", "state") .add(Restrictions.eq("state.Id",
			 * stateId)) .add(Restrictions.eq("Status", "y").ignoreCase())
			 * .addOrder(Order.asc("DistrictCode")) .list();
			 */

			Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
					.createAlias("Village", "vill")
					.createAlias("MasTaluk", "taluk")
					.add(Restrictions.eq("taluk.Id", taluk))
					.add(Restrictions.isNotNull("Village"));
			if (villSubcenterId != 0) {
				cr.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", villSubcenterId));
			}
			mappingsList = cr.list();
			//Added by Arbind for avoid duplication on 05-10-2017
			List<Integer> phMasLocalityId = cr.setProjection(Projections.property("Village.Id")).list();
			Criteria crt = session.createCriteria(MasVillage.class)
					.createAlias("District", "d")
					.createAlias("Taluk", "t")
					.add(Restrictions.eq("t.Id", taluk))
					.add(Restrictions.eq("d.Id", districtId))
					.add(Restrictions.eq("Status", "y").ignoreCase());
			if(phMasLocalityId.size() > 0) {
				crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
			}
			village = crt.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("village", village);
		//map.put("district", district);
		map.put("mappingsList", mappingsList);
		return map;
	}

	public Map<String, Object> populateSubcenterList(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		List<LocationParameterMapping> phMasLocalityList = new ArrayList<LocationParameterMapping>();
		int subcenterId = 0;
		int hospitalId = 0;
		if (dataMap.get("hospitalId") != null
				&& !dataMap.get("hospitalId").equals("")) {
			hospitalId = Integer.parseInt(dataMap.get("hospitalId").toString());
		}
		if (dataMap.get("subcenterId") != null
				&& !dataMap.get("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(dataMap.get("subcenterId")
					.toString());
		}

		int villSubcenterId = 0;

		if (dataMap.get("villSubcenterId") != null
				&& !dataMap.get("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(dataMap.get("villSubcenterId")
					.toString());
		}
		Session session = (Session) getSession();
		//Added by Arbind for avoid duplication on 04-10-2017
		List<Integer> phMasLocalityId = session.createCriteria(LocationParameterMapping.class)
						.createAlias("Hospital", "h").add(Restrictions.eq("h.Id", villSubcenterId))
						.add(Restrictions.isNotNull("BasicSection"))
						.setProjection(Projections.property("BasicSection.Id")).list();
		Criteria crt = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "SubCentre")
				.add(Restrictions.eq("SubCentre.Id", 2))
				.add(Restrictions.eq("ParentInstitute.Id", (Integer) (dataMap.get("hospialIdphcCHC"))))
				.add(Restrictions.eq("Status", "y").ignoreCase());
		if(phMasLocalityId.size() > 0) {
			crt.add(Restrictions.not(Restrictions.in("Id", phMasLocalityId)));
		}
		subcenterList = crt.list();

		Criteria cr = getSession().createCriteria(LocationParameterMapping.class)
				.add(Restrictions.isNotNull("BasicSection"));
		if (subcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", subcenterId));
		}
		if (villSubcenterId != 0) {
			cr.createAlias("Hospital", "h").add(
					Restrictions.eq("h.Id", villSubcenterId));
		}

		phMasLocalityList = cr.list();

		map.put("subcenterList", subcenterList);
		map.put("phMasLocalityList", phMasLocalityList);

		return map;
	}

	// added by amit das on 1-7-2016
	@SuppressWarnings("unchecked")
	public Map<String, Object> showFormPJsp(Map map) {
		Session session = (Session) getSession();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		int userId = 0;
		try {
			if (map.get("userId") != null && !map.get("userId").equals("0")) {
				userId = (Integer) map.get("userId");
				deptList = getHibernateTemplate()
						.find("SELECT  DISTINCT dept FROM UserTemplate as ut join ut.Template as mt join mt.TemplateDepartments as td join ut.User as user join td.Department as dept where user.Id="
								+ userId
								+ " and upper(ut.Status)=upper('y') and upper(td.Status)=upper('y') and upper(user.Status)=upper('y') ORDER BY dept.DepartmentName asc ");
				resultMap.put("deptList", deptList);
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	@Override
	public Map<String, Object> getlocalitySearch(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhMasLocality> masloc = new ArrayList<PhMasLocality>();
		Session session = (Session) getSession();
		//session = (Session) getSession();  //commented by Om Tripathi extra reference

		int ward = 0;
		if (dataMap.get("ward") != null && !dataMap.get("ward").equals("")) {
			ward = Integer.parseInt(dataMap.get("ward").toString());
		}

		try {

			masloc = session.createCriteria(PhMasLocality.class)
					.createAlias("Ward", "w")
					.add(Restrictions.eq("w.Id", ward))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("masloc", masloc);

		return map;
	}

	@Override
	public Map<String, Object> showCampGroupJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> jphnJphiList = new ArrayList<MasEmployee>();
		List<EmpScMapping> moList = new ArrayList<EmpScMapping>();
		List<EmpScMapping> phnList = new ArrayList<EmpScMapping>();
		List<MasHospital> subcenterList = new ArrayList<MasHospital>();
		List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
		List<StoreReservationJphn> jphnList = new ArrayList<StoreReservationJphn>();
		Session session = (Session) getSession();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		String phnCode = prop.getProperty("phnCode");
		String moCode = prop.getProperty("moCode");
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		int page = (Integer) box.getInt("page");
		Criteria criteria=null;

		Object jphnJphiCode[] = { "248", "249", "95", "96" };
		subcenterList = session
				.createCriteria(MasHospital.class)
				.add(Restrictions.eq("ParentInstitute.Id",
						box.getInt("hospitalId")))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (subcenterList.size() > 0) {
			List<Integer> hospitalList = new ArrayList<Integer>();
			for (MasHospital hospital : subcenterList) {
				int subCenterId = hospital.getId();
				hospitalList.add(subCenterId);
			}

			if (hospitalList.size() > 0) {
				jphnJphiList = session.createCriteria(MasEmployee.class)
						.createAlias("Hospital", "hospital")
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.add(Restrictions.in("hospital.Id", hospitalList))
						.createAlias("Rank", "rank")
						.add(Restrictions.in("rank.RankCode", jphnJphiCode))
						.addOrder(Order.asc("EmployeeName")).list();
			}
		}

		phnList = session.createCriteria(EmpScMapping.class)
				.createAlias("Employee", "emp")
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.createAlias("emp.Hospital", "hospital")
				.add(Restrictions.eq("emp.Status", "y").ignoreCase())
				.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
				.createAlias("emp.Rank", "rank")
				.add(Restrictions.eq("rank.RankCode", phnCode))
				.addOrder(Order.asc("emp.EmployeeName")).list();

		moList = session.createCriteria(EmpScMapping.class)
				.createAlias("Employee", "emp")
				.add(Restrictions.eq("Department.Id", box.getInt("deptId")))
				.createAlias("emp.Hospital", "hospital")
				.add(Restrictions.eq("emp.Status", "y").ignoreCase())
				.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
				.createAlias("emp.Rank", "rank")
				.add(Restrictions.eq("rank.RankCode", moCode))
				.addOrder(Order.asc("emp.EmployeeName")).list();

		jphnList = session.createCriteria(StoreReservationJphn.class)
				.createAlias("Hospital", "hospital")
				.createAlias("CampGroup", "campGroup")
				.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")))
				.add(Restrictions.eq("campGroup.Id", box.getInt("campGroupId"))).list();

		criteria = session.createCriteria(StoreReservationCampGroup.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")));
				
		noOfRecords = criteria.list().size();
		criteria.setFirstResult((page - 1)*recordsPerPage);
		criteria.setMaxResults(recordsPerPage);
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		
		campGroupList=criteria.list();
		
		
		logger.info("noOfPages "+noOfPages+" currentPage "+page);
		map.put("jphnJphiList", jphnJphiList);
		map.put("phnList", phnList);
		map.put("moList", moList);
		map.put("jphnList", jphnList);
		map.put("campGroupList", campGroupList);
		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		return map;
	}

	@Override
	public Map<String, Object> submitCampGroup(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int empCount = 0;
		if (box.getInt("hdbEmp") != 0) {
			empCount = (Integer) box.getInt("hdbEmp");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		boolean flag = false;
		Transaction tx = null;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			StoreReservationCampGroup storeReservationCampGroup = new StoreReservationCampGroup();
			if (!box.getString("groupName").equals("")) {
				storeReservationCampGroup.setGroupName(box
						.getString("groupName"));
			}
			if (box.getInt("mo") != 0) {
				MasEmployee mo = new MasEmployee();
				mo.setId(box.getInt("mo"));
				storeReservationCampGroup.setMo(mo);
			}
			if (box.getInt("phn") != 0) {
				MasEmployee phn = new MasEmployee();
				phn.setId(box.getInt("phn"));
				storeReservationCampGroup.setPhn(phn);
			}
			if (box.getInt("userId") != 0) {
				Users users = new Users();
				users.setId(box.getInt("userId"));
				storeReservationCampGroup.setLastChgBy(users);
			}
			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			storeReservationCampGroup.setHospital(hospital);

			storeReservationCampGroup.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(currentDate));
			storeReservationCampGroup.setLastChgTime(time);
			storeReservationCampGroup.setStatus("y");
			hbt.save(storeReservationCampGroup);

			for (int i = 1; i <= empCount; i++) {

				StoreReservationJphn storeReservationJphn = new StoreReservationJphn();
				if (box.getInt("employeeId" + i) != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(box.getInt("employeeId" + i));
					storeReservationJphn.setEmployee(masEmployee);
					storeReservationJphn
							.setCampGroup(storeReservationCampGroup);

					hospital.setId(box.getInt("hospitalId"));
					storeReservationJphn.setHospital(hospital);
					hbt.save(storeReservationJphn);
				}

			}

			flag = true;
			tx.commit();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		return map;
	}

	@Override
	public Map<String, Object> showCampJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReservationCampGroup> campGroupList = new ArrayList<StoreReservationCampGroup>();
		List<StoreReservationCamp> campList = new ArrayList<StoreReservationCamp>();
		Session session = (Session) getSession();
		int noOfPages = 0;
		int noOfRecords = 0;
		int recordsPerPage = 5;
		int page = (Integer) box.getInt("page");
		Criteria criteria=null;

		campGroupList = session.createCriteria(StoreReservationCampGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		criteria = session.createCriteria(StoreReservationCamp.class)
				.createAlias("Hospital", "hospital")
				.add(Restrictions.eq("hospital.Id", box.getInt("hospitalId")));

		noOfRecords = criteria.list().size();
		criteria.setFirstResult((page - 1)*recordsPerPage);
		criteria.setMaxResults(recordsPerPage);
		noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

		campList=criteria.list();

		logger.info("noOfPages "+noOfPages+" currentPage "+page);

		map.put("noOfPages", noOfPages);
		map.put("currentPage", page);
		map.put("campGroupList", campGroupList);
		map.put("campList", campList);
		return map;
	}

	@Override
	public Map<String, Object> submitCamp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreReservationCamp> existingCampList = new ArrayList<StoreReservationCamp>();
		int campCount = 0;
		String message = "";
		if (box.getInt("hdbCamp") != 0) {
			campCount = (Integer) box.getInt("hdbCamp");
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Session session = (Session) getSession();
		boolean flag = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			for (int i = 1; i <= campCount; i++) {
				existingCampList = session
						.createCriteria(StoreReservationCamp.class)
						.add(Restrictions.eq("Date", HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("date" + i))))
						.add(Restrictions.eq("CampName",
								box.getString("camp" + i))).list();

				if (existingCampList.size() > 0) {
					message = "Record already exist!!!";
				} else {
					StoreReservationCamp storeReservationCamp = new StoreReservationCamp();

					if (!box.getString("camp" + i).equals("")) {
						storeReservationCamp.setCampName(box.getString("camp"
								+ i));
					}
					if (!box.getString("locality" + i).equals("")) {
						storeReservationCamp.setLocality(box
								.getString("locality" + i));
					}
					if (!box.getString("date" + i).equals("")) {
						storeReservationCamp.setDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("date" + i)));
					}
					storeReservationCamp.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(currentDate));
					storeReservationCamp.setLastChgTime(time);
					storeReservationCamp.setStatus("y");
					MasHospital masHospital = new MasHospital();
					masHospital.setId(box.getInt("hospitalId"));
					storeReservationCamp.setHospital(masHospital);
					if (box.getInt("userId") != 0) {
						Users users = new Users();
						users.setId(box.getInt("userId"));
						storeReservationCamp.setLastChgBy(users);
					}

					if (box.getInt("group") != 0) {
						StoreReservationCampGroup campGroup = new StoreReservationCampGroup();
						campGroup.setId(box.getInt("group"));
						storeReservationCamp.setGroup(campGroup);
					}
					hbt.save(storeReservationCamp);
				}
			}

			flag = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("flag", flag);
		map.put("message", message);
		return map;
	}

	@Override
	public Map<String, Object> getBasicCenterListForPhcChc(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		Session session = (Session) getSession();
		String[] scbasic = { "FWC", "BS" };

		try {
			chcList = session
					.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "SubCentre")
					.add(Restrictions.in("SubCentre.InstituteTypeShortName",
							scbasic))
					.add(Restrictions.eq("ParentInstitute.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("chcList", chcList);
		return map;
	}

	@Override
	public String getInstituteTypeName(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String sql = "select institute_type_short_name from mas_hospital_type mht "
				+ "left outer join mas_hospital mh on mh.hospital_type_id = mht.hospital_type_id "
				+ "where hospital_id = " + hospitalId;
		SQLQuery query = session.createSQLQuery(sql);
		List instType = query.list();
		String instituteTypeShortName = "";
		for (Object str : instType) {
			instituteTypeShortName = (String) str;
		}
		
		logger.info("instituteTypeShortName ---> " + instituteTypeShortName);
		
		map.put("instituteTypeShortName", instituteTypeShortName);
		return instituteTypeShortName;
	}



	@Override
	public Map showPhSyndromicSurvcillenceMappingJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PhSyndromicSurvcillenceMapping> searchPhSyndromicSurvcillenceMappingList = new ArrayList<PhSyndromicSurvcillenceMapping>();
		searchPhSyndromicSurvcillenceMappingList = getHibernateTemplate().find("from jkt.hms.masters.business.PhSyndromicSurvcillenceMapping ");
		map.put("searchPhSyndromicSurvcillenceMappingList", searchPhSyndromicSurvcillenceMappingList);
		return map;
	}

	@Override
	public boolean addPhSyndromicSurvcillenceMapping(
			PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping) {
		boolean successfullyAdded = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(phSyndromicSurvcillenceMapping);
		successfullyAdded = true;
		return successfullyAdded;
	}

	@Override
	public boolean editPhSyndromicSurvcillenceMapping(
			Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String unitName = "";
		int phSyndromicSurvcillenceMappingId = 0;
		int mainGroupId = 0;
		String mainGroupName = "";
		int subGroupId = 0;
		String subGroupName = "";
		String parameterName = "";
		int userId=0;
		phSyndromicSurvcillenceMappingId = (Integer) generalMap.get("id");
		mainGroupId= (Integer) generalMap.get("mainGroupId");
		subGroupId= (Integer) generalMap.get("subGroupId");
		subGroupName = (String) generalMap.get("subGroupName");
		parameterName = (String) generalMap.get("name");
		mainGroupName = (String) generalMap.get("mainGroupName");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		userId= (Integer) generalMap.get("userId");
		PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping = (PhSyndromicSurvcillenceMapping) getHibernateTemplate().load(PhSyndromicSurvcillenceMapping.class,
				phSyndromicSurvcillenceMappingId);

		phSyndromicSurvcillenceMapping.setId(phSyndromicSurvcillenceMappingId);
		phSyndromicSurvcillenceMapping.setMainGroupId(mainGroupId);
		phSyndromicSurvcillenceMapping.setMainGroupName(mainGroupName);
		phSyndromicSurvcillenceMapping.setSubGroupId(subGroupId);
		phSyndromicSurvcillenceMapping.setSubGroupName(subGroupName);
		//phSyndromicSurvcillenceMapping.setParameterName(parameterName);
		phSyndromicSurvcillenceMapping.setStatus("y");
		phSyndromicSurvcillenceMapping.setLastChgDate(currentDate);
		phSyndromicSurvcillenceMapping.setLastChgTime(currentTime);
		Users user=new Users();
        user.setId(userId);
        phSyndromicSurvcillenceMapping.setLastChgBy(user);
        
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(phSyndromicSurvcillenceMapping);
		dataUpdated = true;
		return dataUpdated;
	}

	@Override
	public boolean deletePhSyndromicSurvcillenceMapping(
			int phSyndromicSurvcillenceMappingId, Map<String, Object> generalMap) {
		boolean dataDeleted = false;

		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping = new PhSyndromicSurvcillenceMapping();
		phSyndromicSurvcillenceMapping = (PhSyndromicSurvcillenceMapping) getHibernateTemplate().load(PhSyndromicSurvcillenceMapping.class, phSyndromicSurvcillenceMappingId);

		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				phSyndromicSurvcillenceMapping.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				phSyndromicSurvcillenceMapping.setStatus("y");
				dataDeleted = false;
			}
		}

		phSyndromicSurvcillenceMapping.setLastChgDate(currentDate);
		phSyndromicSurvcillenceMapping.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(phSyndromicSurvcillenceMapping);
		return dataDeleted;
	}

	@Override
	public Map<String, Object> searchPhSyndromicSurvcillenceMapping(String parameterName) {
		List<PhSyndromicSurvcillenceMapping> searchPhSyndromicSurvcillenceMappingList = new ArrayList<PhSyndromicSurvcillenceMapping>();
		Map<String, Object> unitFieldsMap = new HashMap<String, Object>();
		try {
			if ((parameterName != null)) {
				searchPhSyndromicSurvcillenceMappingList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.PhSyndromicSurvcillenceMapping imc where lower(imc.ParameterName) like '"
								+ parameterName.toLowerCase()
								+ "%' order by imc.ParameterName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		unitFieldsMap.put("searchPhSyndromicSurvcillenceMappingList", searchPhSyndromicSurvcillenceMappingList);
		return unitFieldsMap;
	}
	
	@Override
	public Map<String, Object> fun_ph_form_s(Date fromDate, Date toDate, int userId) {

		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = false;
		Session session = (Session) getSession();
		try {
			java.sql.Connection con = session.connection();
			String sql = "";
			sql = "{call fun_ph_form_s('" + fromDate + "'," + "'" + toDate + "'," + userId + ")}";
			

			try {
				if (sql != "") {
					CallableStatement cals = con.prepareCall(sql);
					cals.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		map.put("flag", flag);
		return map;

	}
	
	// added by amit das on 01-12-2016
	@Override
	public Map<String, Object> getPhReportsParametersMappings(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPhReportsParameters> masPhReportsParameterList = null;
		Criteria criteria = null;
		Session session = null;
		
		try{
			session = (Session)getSession();
			criteria = session.createCriteria(MasPhReportsParameters.class);
			masPhReportsParameterList =	criteria.list();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		map.put("masPhReportsParameterList", masPhReportsParameterList);
		return map;
	}
	
	// added by amit das on 01-12-2016
	@Override
	public Map<String, Object> updatePhReportsParametersMappings(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPhReportsParameters> masPhReportsParameterList = null;
		Criteria criteria = null;
		Session session = null;
		String message = null;
		MasPhReportsParameters masPhReportsParameters = null;
		int count = 0;
		int paramaterId = 0;
		String hmisParameterId = null;
		String hmisParameterName = null;
		String goiMonthlyParameterId = null;
		String goiMonthlyParameterName = null;
		String goiQuarterlyParameterId = null;
		String goiQuarterlyParameterName = null;
		String goiAnnuallyParameterId = null;
		String goiAnnuallyParameterName = null;
		String internalReportDistrictMonthlyParameterId = null;
		String internalReportDistrictMonthlyParameterName = null;
		String internalReportDistrictQuarterlyParameterId = null;
		String internalReportDistrictQuarterlyParameterName = null;
		String internalReportDistrictAnnuallyParameterId = null;
		String internalReportDistrictAnnuallyParameterName = null;
		String internalReportStateQuarterlyParameterId = null;
		String internalReportStateQuarterlyParameterName = null;
		String internalReportStateAnnuallyParameterId = null;
		String internalReportStateAnnuallyParameterName = null;
		String internalReportMonthlyScParameterId = null;
		String internalReportMonthlyScParameterName = null;
		String internalReportMonthlyChcParameterId = null;
		String internalReportMonthlyChcParameterName = null;
		String internalReportMonthlyPhcParameterId = null;
		String internalReportMonthlyPhcParameterName = null;
		String internalReportMonthlySubDistrictParameterId = null;
		String internalReportMonthlySubDistrictParameterName = null;
		String internalReportMonthlyDistrictHospitalParameterId = null;
		String internalReportMonthlyDistrictHospitalParameterName = null;
		String infrastructurelReportMonthlySubDistrict1ParameterId = null;
		String infrastructurelReportMonthlySubDistrict1ParameterName = null;
		String infrastructurelReportMonthlySubDistrict2ParameterId = null;
		String infrastructurelReportMonthlySubDistrict2ParameterName = null;
		String infrastructurelReportMonthlyDistrict1ParameterId = null;
		String infrastructurelReportMonthlyDistrict1ParameterName = null;
		String infrastructurelReportMonthlyDistrict2ParameterId = null;
		String infrastructurelReportMonthlyDistrict2ParameterName = null;
		
		String infrastructurelReportMonthlyDistrict3ParameterId = null;
		String infrastructurelReportMonthlyDistrict3ParameterName = null;
		String nvbdcpParameterId = null;
		String nvbdcpParameterName = null;
		
		try{
			session = (Session)getSession();
			
			count = box.getInt("count");
			
			for(int i=1;i<=count;i++){
				masPhReportsParameters =	(MasPhReportsParameters)session.get(MasPhReportsParameters.class,box.getInt("paramaterId"+i));
				
				if(masPhReportsParameters!=null) {
				if(box.get("hmisParameterId"+i)!=null)
					masPhReportsParameters.setHmisId(box.get("hmisParameterId"+i));
				
				if(box.get("hmisParameterName"+i)!=null)
					masPhReportsParameters.setHmisParameter(box.get("hmisParameterName"+i));
				
				if(box.get("goiMonthlyParameterId"+i)!=null)
					masPhReportsParameters.setGoiMonthlyId(box.get("goiMonthlyParameterId"+i));
				
				if(box.get("goiMonthlyParameterName"+i)!=null)
					masPhReportsParameters.setGoiMonthlyParameter(box.get("goiMonthlyParameterName"+i));
				
				if(box.get("goiQuarterlyParameterId"+i)!=null)
					masPhReportsParameters.setGoiQuarterlyId(box.get("goiQuarterlyParameterId"+i));
				
				if(box.get("goiQuarterlyParameterName"+i)!=null)
					masPhReportsParameters.setGoiQuarterlyParameter(box.get("goiQuarterlyParameterName"+i));
				
				if(box.get("goiAnnuallyParameterId"+i)!=null)
					masPhReportsParameters.setGoiAnnuallyId(box.get("goiAnnuallyParameterId"+i));
				
				if(box.get("goiAnnuallyParameterName"+i)!=null)
					masPhReportsParameters.setGoiAnnuallyParameter(box.get("goiAnnuallyParameterName"+i));
				
				if(box.get("internalReportDistrictMonthlyParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyDistrictId(box.get("internalReportDistrictMonthlyParameterId"+i));
				
				if(box.get("internalReportDistrictMonthlyParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyDistrictParameter(box.get("internalReportDistrictMonthlyParameterName"+i));
				
				if(box.get("internalReportDistrictQuarterlyParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportQuarterlyDistrictId(box.get("internalReportDistrictQuarterlyParameterId"+i));
				
				if(box.get("internalReportDistrictQuarterlyParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportQuarterlyDistrictParameter(box.get("internalReportDistrictQuarterlyParameterName"+i));
				
				if(box.get("internalReportDistrictAnnuallyParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportAnnuallyDistrictId(box.get("internalReportDistrictAnnuallyParameterId"+i));
				
				if(box.get("internalReportDistrictAnnuallyParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportAnnuallyDistrictParameter(box.get("internalReportDistrictAnnuallyParameterName"+i));
				
				if(box.get("internalReportStateQuarterlyParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportQuarterlyStateId(box.get("internalReportStateQuarterlyParameterId"+i));
				
				if(box.get("internalReportStateQuarterlyParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportQuarterlyStateParameter(box.get("internalReportStateQuarterlyParameterName"+i));
				
				if(box.get("internalReportStateAnnuallyParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportAnnuallyStateId(box.get("internalReportStateAnnuallyParameterId"+i));
				
				if(box.get("internalReportStateAnnuallyParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportAnnuallyStateParameter(box.get("internalReportStateAnnuallyParameterName"+i));
				
				if(box.get("internalReportMonthlyScParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyScId(box.get("internalReportMonthlyScParameterId"+i));
				
				if(box.get("internalReportMonthlyScParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyScParameter(box.get("internalReportMonthlyScParameterName"+i));
				
				if(box.get("internalReportMonthlyChcParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyChcId(box.get("internalReportMonthlyChcParameterId"+i));
				
				if(box.get("internalReportMonthlyChcParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyChcParameter(box.get("internalReportMonthlyChcParameterName"+i));
				
				if(box.get("internalReportMonthlyPhcParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyPhcId(box.get("internalReportMonthlyPhcParameterId"+i));
				
				if(box.get("internalReportMonthlyPhcParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyPhcParameter(box.get("internalReportMonthlyPhcParameterName"+i));
				
				if(box.get("internalReportMonthlySubDistrictParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlySubDistrictId(box.get("internalReportMonthlySubDistrictParameterId"+i));
				
				if(box.get("internalReportMonthlySubDistrictParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlySubDistrictParameter(box.get("internalReportMonthlySubDistrictParameterName"+i));
				
				if(box.get("internalReportMonthlyDistrictHospitalParameterId"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyDistrictHospitalId(box.get("internalReportMonthlyDistrictHospitalParameterId"+i));
				
				if(box.get("internalReportMonthlyDistrictHospitalParameterName"+i)!=null)
					masPhReportsParameters.setInternalReportMonthlyDistrictHospitalParameter(box.get("internalReportMonthlyDistrictHospitalParameterName"+i));
				
				if(box.get("infrastructurelReportMonthlySubDistrict1ParameterId"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlySubDistrict1Id(box.get("infrastructurelReportMonthlySubDistrict1ParameterId"+i));
				
				if(box.get("infrastructurelReportMonthlySubDistrict1ParameterName"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlySubDistrict1Parameter(box.get("infrastructurelReportMonthlySubDistrict1ParameterName"+i));
				
				if(box.get("infrastructurelReportMonthlySubDistrict2ParameterId"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlySubDistrict2Id(box.get("infrastructurelReportMonthlySubDistrict2ParameterId"+i));
				
				if(box.get("infrastructurelReportMonthlySubDistrict2ParameterName"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlySubDistrict2Parameter(box.get("infrastructurelReportMonthlySubDistrict2ParameterName"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict1ParameterId"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict1Id(box.get("infrastructurelReportMonthlyDistrict1ParameterId"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict1ParameterName"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict1Parameter(box.get("infrastructurelReportMonthlyDistrict1ParameterName"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict2ParameterId"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict2Id(box.get("infrastructurelReportMonthlyDistrict2ParameterId"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict2ParameterName"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict2Parameter(box.get("infrastructurelReportMonthlyDistrict2ParameterName"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict3ParameterId"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict3Id(box.get("infrastructurelReportMonthlyDistrict3ParameterId"+i));
				
				if(box.get("infrastructurelReportMonthlyDistrict3ParameterName"+i)!=null)
					masPhReportsParameters.setInfrastructurelReportMonthlyDistrict3Parameter(box.get("infrastructurelReportMonthlyDistrict3ParameterName"+i));
				
				if(box.get("nvbdcpParameterId"+i)!=null)
					masPhReportsParameters.setNvbdcpReportId(box.get("nvbdcpParameterId"+i));
				
				if(box.get("nvbdcpParameterName"+i)!=null)
					masPhReportsParameters.setNvbdcpReportParameter(box.get("nvbdcpParameterName"+i));
				
				session.update(masPhReportsParameters);
				
				message = "Mappings assigned sucessfully !!";
				}
			}
			
			criteria = session.createCriteria(MasPhReportsParameters.class);
			masPhReportsParameterList =	criteria.list();
		} catch (Exception e){
			message = "Error occured !";
			e.printStackTrace();
		}
		
		map.put("masPhReportsParameterList", masPhReportsParameterList);
		map.put("message", message);
		return map;
	}
	//added by govind 5-12-2016
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
				
				if(objectList.size()>0)
				{
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
			return prescriptionNo;
		}//added by govind 5-12-2016 end 
		

		
		@Override
		public Map<String, Object> getAshapage(Map<String, Object> map) {
			Session session=(Session)getSession();
			List<MasHospitalType>hospitalTypes=new ArrayList<MasHospitalType>();
			hospitalTypes=session.createCriteria(MasHospitalType.class).list();
			List<AshaWorker>list=session.createCriteria(AshaWorker.class).list();
			List<MasQualification>masQualifications=session.createCriteria(MasQualification.class).list();
			
			int statiId =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "stateId"));
			List<MasDistrict>masDistricts=session.createCriteria(MasDistrict.class).add(Restrictions.eq("State.Id", statiId)).list();
			
			map.put("masDistricts", masDistricts);
			map.put("masQualifications", masQualifications);
			map.put("hospitalTypes", hospitalTypes);
			map.put("ashaDetails", list);
			return map;
		}
		
		@Override
		public Map<String, Object> getAshaEntity(Map<String, Object> map) {
			Session session=(Session)getSession();
			Integer districtId=null;
			Integer hospitalId=null;
			if(map.get("districtId")!=null){
				districtId=(Integer)map.get("districtId");
				List<MasLsg>masLsgs=new ArrayList<MasLsg>();
				masLsgs=session.createCriteria(MasLsg.class).add(Restrictions.eq("District.Id", districtId)).list();
				map.put("masLsgs", masLsgs);
			}
			if(map.get("hospitalId")!=null){
				hospitalId=(Integer)map.get("hospitalId");
				List<MasHospital>parent_masHospitals=new ArrayList<MasHospital>();
				parent_masHospitals=session.createCriteria(MasHospital.class).add(Restrictions.eq("ParentInstitute.Id", hospitalId)).list();
				map.put("parent_masHospitals", parent_masHospitals);
			}
			
			return map;
		}
		
		@Override
		public Map<String, Object> getHospitals(Map<String, Object> map) {
			Session session=(Session)getSession();
			List<MasHospital>hospitals=new ArrayList<MasHospital>();
			Integer ashaId=null;
			Integer hosptalTypeId=null;
			if(map.get("ashaId")!=null){
				ashaId=(Integer)map.get("ashaId");
				hospitals=session.createCriteria(AshaMapping.class).setProjection(Projections.property("Hospital")).add(Restrictions.eq("Asha.Id", ashaId)).list();
				AshaWorker asha=(AshaWorker)session.load(AshaWorker.class, ashaId);
				
				map.put("asha", asha);
				map.put("hospitals", hospitals);
			}
			if(map.get("hospitalTypeId")!=null){
				hosptalTypeId=(Integer)map.get("hospitalTypeId");
				hospitals=session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalType.Id", hosptalTypeId)).list();
				map.put("hospitals", hospitals);
			}
			return map;
		}
		
		@Override
		public Map<String, Object> submitAshaWorker(Box box) {
			Map<String, Object> map=new HashMap<String, Object>();
			Session session=(Session)getSession();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Transaction transaction=session.beginTransaction();
			String ashaName=null;
			String ashaCode=null;
			String ashaId=null;
			String contactNo=null;
			String backAc=null;
			String bankName=null;
			Integer qualification=null;
			String ifsc=null;
			Integer lsgId=null;
			Integer hospitalType=null;
			Integer hospitalId=null;
			
			AshaWorker aw=new AshaWorker();
			if(box.get("ashaName")!=null){
				ashaName=box.get("ashaName");
				aw.setAshaName(ashaName);
			}
			if(box.get("ashaCode")!=null){
				ashaCode=box.get("ashaCode");
				aw.setAshaCode(ashaCode);
			}
			if(box.get("contactNo")!=null){
				contactNo=box.get("contactNo");
				aw.setContactNo(contactNo);
			}
			if(box.get("qualification")!=null){
				qualification=box.getInt("qualification");
				aw.setQualification(new MasQualification(qualification));
			}
			if(box.get("backAc")!=null){
				backAc=box.get("backAc");
				aw.setBankAccount(backAc);
			}
			if(box.get("bankName")!=null){
				bankName=box.get("bankName");
				aw.setBankName(bankName);
			}
			if(box.get("ifsc")!=null){
				ifsc=box.get("ifsc");
				aw.setIfsc(ifsc);
			}
			if(box.get("lsgName")!=null){
				lsgId=box.getInt("lsgName");
				aw.setLsg(new MasLsg(lsgId));
			}
			if(box.get("hospitalType")!=null){
				hospitalType=box.getInt("hospitalType");
				aw.setHospitalType(new MasHospitalType(hospitalType));
			}
			
			if(box.get("hospitals")!=null){
				hospitalId=box.getInt("hospitals");
				aw.setHospital(new MasHospital(hospitalId));;
			}
			
			hbt.save(aw);
			
			hbt.save(aw);
			List<String>hospitalIds=new ArrayList<String>();
			if(box.getArrayList("subCenters")!=null){
				hospitalIds=box.getArrayList("subCenters");
				for(String hIds:hospitalIds){
					Integer subCentersIds=Integer.parseInt(hIds);
					AshaMapping mapping=new AshaMapping();
					mapping.setAsha(aw);
					mapping.setHospital(new MasHospital(subCentersIds));
					hbt.save(mapping);
				}
			}
			
			transaction.commit();
			
			List<AshaWorker>list=session.createCriteria(AshaWorker.class).list();
			map.put("ashaDetails", list);
			return map;
		}
	
	
	@Override
	public Map<String, Object> getGoiMonthlyCountFromDatabase(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> countList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		int currentMonth = 0;
		int districtID = 0;
		String fromDate = null;
		String toDate = null;
		int hospitalId = box.getInt("hospitalId");
		Calendar calendar = Calendar.getInstance();

		if (box.getInt("month") != 0) {
			currentMonth = box.getInt("month");
		} else {
			currentMonth = box.getInt("currentMonth");
		}
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (currentMonth != 0)
			calendar.set(Calendar.MONTH, currentMonth - 1);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date sDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date eDate = calendar.getTime();
		String startDate = sdf.format(sDate);
		String endDate = sdf.format(eDate);

		try {
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtID = hospital.getDistrict().getId();

			String queryCount = "select "
					+

					"(select count(*) as t1 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  "
					+ "    where district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+ ",(select count((current_date - date_of_birth)/365) as t2 from ph_anc_survey pas "
					+ "left outer join ph_member_survey  pms on pas.member_id=pms.member_id  left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id "
					+ " where ((current_date - date_of_birth)/365) < 19  and district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					" ,(select count(*) as t3 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where lower(jsy_flag) =lower('Yes') and district_id="
					+ districtID
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+ ",(select count(*) as t4 from (select count(*) as cnt from ph_anc_followup  anc left outer join ph_anc_survey  anf on anc.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=anf.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' group by  anc.anc_reg_id having count(*)>3) t1 )  "
					+

					",(select count(*) as t5 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and tt1 is not null ) "
					+

					",(select count(*) as t6 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and  tt2 is not null ) "
					+

					",(select count(*) as t7 from ph_anc_followup  anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('100')) "
					+

					",(select count(*) as t8 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('200') ) "
					+

					",(select count(*) as t9 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID
					+ "  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and delivery_place ='Home' )  "
					+

					",(select count(*) as t10 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ " and attended_by  in ('Doctor')  and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t11  from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ " and attended_by in('Trained birth Attendant') and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t12 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID
					+ "    and attended_by in('Trained birth Attendant','Doctor','Specialist Doctor','Untrained birth Attendant')  and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t13 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_place ='Government Hospital' and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t14 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='PHC' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t15 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='CHC' and ptm.delivery_type = 'C-Section(LSCS)' and  mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",( select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where mt.hospital_type_code='DH' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t17 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t18 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and gender_id = 3 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t19 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Live Birth' and gender_id = 2 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t20 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and delivery_out_come='Still Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' )"
					+

					",(select count(*) as t21 from ph_anc_survey pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and abortions in('1','2','3','4','5','6','7','8','9','10') and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' ) "
					+

					",(select count(*) as t22 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and reg_type ='birth' and birth_weigth is not null  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t23 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and reg_type ='birth' and birth_weigth < 2.50  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t24 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '84' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t25 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '86' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t26 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t27 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID
					+ " and termination_type='mtp' and anf.refer_to_type = 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select district_name as disName from mas_district where district_id  ="
					+ districtID
					+ ")"
					+ ",(select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where  ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 27-04-2016
					",(select count(*) as t30 from ph_anc_followup  where (hb < 7.00 or hb = 7.00) and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(*) as t31 from ph_anc_followup  where (hb < 11.00 or hb = 11.00) and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 25-08-2016
					",(select count(opd_antenatal_card_id) as t32 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID
					+ " and tetanus_onest_dose_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(opd_antenatal_card_id) as t33 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID
					+ " and tetanus_twond_dose_date between '"
					+ startDate + "' and '" + endDate + "')";
			countList = session.createSQLQuery(queryCount).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("countList", countList);

		return map;
	}

	public String getRankName(int rankId) {
		Session session = (Session) getSession();
		String sql = "select rank_name from mas_rank where rank_id = " + rankId;
		SQLQuery query = session.createSQLQuery(sql);
		List rankList = query.list();
		String rankName = "";
		for (Object str : rankList) {
			rankName = (String) str;
		}
		return rankName;
	}

	//added by arbind 10-01-2017
	public List<OpdVaccinMst> getMstSecondList(String vacName,int dose,int hinId){
		
		
		Session session = (Session)getSession();
		dose++;
		List<OpdVaccinMst> vacList=new ArrayList<OpdVaccinMst>();
		List<OpdVaccinationPlan> planList=new ArrayList<OpdVaccinationPlan>();
		vacList=session.createCriteria(OpdVaccinMst.class)
				.add(Restrictions.eq("VaccinName",vacName))
				.add(Restrictions.eq("Dose",dose))
				.addOrder(Order.asc("Dose"))
				.list();
		if(vacList.size()>0){
		OpdVaccinMst ms=vacList.get(0);
		planList=session.createCriteria(OpdVaccinationPlan.class)
				.add(Restrictions.eq("Hin.Id",hinId))
				.add(Restrictions.eq("Vaccin.Id",ms.getId()))
				.add(Restrictions.isNull("VaccinCompleteDate"))
				.list();
		
		if(planList.size()>0){
			vacList=new ArrayList<OpdVaccinMst>();
		}
		}
		return vacList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> submitVaccineDetailPH(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OpdVaccinationPlan> vaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
		List<PhMemberSurvey> immunizationList = new ArrayList<PhMemberSurvey>();
		List<OpdVaccinMst> vaccineList = new ArrayList<OpdVaccinMst>();
		List<OpdVaccinationPlan> existingVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<InjAppointmentHeader> injectionRegisterList = new ArrayList<InjAppointmentHeader>();
		List<PatientPrescriptionDetails> patientPrescriptionDetailsList = null;
		List<InjAppointmentDetails> injAppointmentDetailsList = null;

		int count = 0;
		boolean flag = false;
		if (box.getInt("count") != 0) {
			count = (Integer) box.getInt("count");
		}
		int memberServeyId = 0;
		if (box.getInt("memberServeyId") != 0) {
			memberServeyId = (Integer) box.getInt("memberServeyId");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = hbt.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String message = "";
		int vaccinationPlanId = 0;
		int route = 0;
		RouteOfAdministration routeOfAdministration = null;
		Integer pHeaderId = box.getInt("pHeaderId");
		Integer visitId = box.getInt("visitId");
		int opsessionId = 0;

		try {
			InjAppointmentHeader injectionAppointment = new InjAppointmentHeader();
			MasHospital masHospital = new MasHospital();
			masHospital.setId(box.getInt("hospitalId"));
			List<Patient> patientList2 = new ArrayList<Patient>();
			patientList2 = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Id", box.getInt("hinId"))).list();
			int memberId = 0;
			String uhId = "";
			for (Patient pt : patientList2) {
				if (pt.getMember() != null) {
					memberId = pt.getMember().getId();
				}
				if (pt.getHinNo() != null) {
					uhId = pt.getHinNo();
				}
			}

			PatientPrescriptionHeader patientPrescriptionHeader = new PatientPrescriptionHeader();
			List<Integer> itemIdList = new ArrayList<Integer>();
			Visit visitObjToUpdate = (Visit) hbt.get(Visit.class, visitId);
			//Added by Arbind on 26-10-2017
			if(visitObjToUpdate.getVisitSession() != null) {
				opsessionId = visitObjToUpdate.getVisitSession().getId();
				logger.info("opsessionId  --  "+opsessionId);
			}
			List<PatientPrescriptionHeader> patientPrescriptionHeaderList = session
					.createCriteria(PatientPrescriptionHeader.class)
					.createAlias("Hin", "h").createAlias("Visit", "v")
					.add(Restrictions.eq("h.Id", patientList2.get(0).getId()))
					.add(Restrictions.eq("v.Id", visitId)).list();

			if (patientPrescriptionHeaderList.size() > 0) {
				patientPrescriptionHeader = patientPrescriptionHeaderList
						.get(0);
				pHeaderId = patientPrescriptionHeader.getId();
			} else {
				patientPrescriptionHeader = new PatientPrescriptionHeader();
			}
			
			String prescriptionNo = "";
			 prescriptionNo=generatePrecriptionNo(patientList2.get(0).getId());

			injectionRegisterList = hbt
					.find("select inj from jkt.hms.masters.business.InjAppointmentHeader as inj join inj.Visit as visit where visit.Id="
							+ visitId);

			if (injectionRegisterList != null
					&& injectionRegisterList.size() > 0) {
				for (InjAppointmentHeader injectionRegisterTemp : injectionRegisterList) {
					injectionAppointment = injectionRegisterTemp;
				}

				SQLQuery query = session
						.createSQLQuery("delete from inj_appointment_details where inj_appointment_header_id = "
								+ injectionAppointment.getId());
				query.executeUpdate();
			}

			SQLQuery query = session
					.createSQLQuery("delete from patient_prescription_details where prescription_id = "
							+ pHeaderId);
			query.executeUpdate();

			session.flush();

		if(box.getInt("referral") !=1 ){

			for (int i = 1; i <= count; i++) {
				if (memberServeyId != 0) {
					existingVaccinationPlanList = session
							.createCriteria(OpdVaccinationPlan.class)
							.add(Restrictions.eq("Member.Id", memberServeyId))
							.add(Restrictions.eq("Vaccin.Id",
									box.getInt("vaccineId" + i)))
							.add(Restrictions.eq("Hospital.Id",
									box.getInt("hospitalId"))).list();
				} else {
					existingVaccinationPlanList = session
							.createCriteria(OpdVaccinationPlan.class)
							.add(Restrictions.eq("Hin.Id", box.getInt("hinId")))
							.add(Restrictions.eq("Vaccin.Id",
									box.getInt("vaccineId" + i)))
							.add(Restrictions.eq("Hospital.Id",
									box.getInt("hospitalId"))).list();
				}
				if (existingVaccinationPlanList.size() > 0) {

				} else {
					if (box.getString("vaccineItemPvmsNo" + i) != null
							&& !box.getString("vaccineItemPvmsNo" + i).equals(
									"")) {

						String pvmsNo = box.getString("vaccineItemPvmsNo" + i);

						OpdVaccinationPlan vaccinationPlan = null;
						vaccinationPlan = new OpdVaccinationPlan();
//						session.refresh( vaccinationPlan );

						if (box.getString("completionDate" + i) != null
								&& !box.getString("completionDate" + i).equals("")) {
							vaccinationPlan.setVaccinCompleteDate(HMSUtil
									.convertStringTypeDateToDateType(box.getString("completionDate" + i)));
						}
						if (box.getString("vaccineDate" + i) != null
								&& !box.getString("vaccineDate" + i).equals("")) {
							vaccinationPlan.setVaccinDate(HMSUtil
									.convertStringTypeDateToDateType(box.getString("vaccineDate" + i)));
						}
						if (box.getInt("vaccineId" + i) != 0) {
							OpdVaccinMst vaccinMst = new OpdVaccinMst();
							vaccinMst.setId(box.getInt("vaccineId" + i));
							vaccinationPlan.setVaccin(vaccinMst);
						}
						if (box.getString("vaccineToDate" + i) != null
								&& !box.getString("vaccineToDate" + i).equals("")) {
							vaccinationPlan.setVaccinToDate(HMSUtil
								.convertStringTypeDateToDateType(box.getString("vaccineToDate" + i)));
						}
						if (box.getString("vaccinePlace" + i) != null
								&& !box.getString("vaccinePlace" + i).equals("")) {
							vaccinationPlan.setVaccinePlace(box.getString("vaccinePlace" + i));
						}
						if (box.getString("remarks" + i) != null
								&& !box.getString("remarks" + i).equals("")) {
							vaccinationPlan.setRemarks(box.getString("remarks" + i));
						}
						if (box.getInt("hinId") != 0) {
							Patient hin = new Patient();
							hin.setId(box.getInt("hinId"));
							vaccinationPlan.setHin(hin);
						}
						if (box.getInt("deptId") != 0) {
							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId(box.getInt("deptId"));
							vaccinationPlan.setDepartment(masDepartment);
						}
						if (box.getInt("visitId") != 0) {
							Visit visit = new Visit();
							visit.setId(box.getInt("visitId"));
							vaccinationPlan.setVisit(visit);
						}
						//Added by Arbind on 09-10-2017
						if (box.getString("vaccineHospital" + i) != null
								&& !box.getString("vaccineHospital" + i).equals("")) {
							vaccinationPlan.setPlaceName(box.getString("vaccineHospital" + i));
						}

						vaccinationPlan.setVaccinInstitute(masHospital);
						vaccinationPlan.setHospital(masHospital);
						vaccinationPlan.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
						vaccinationPlan.setLastChgTime(time);
						Users users = new Users();
						users.setId(box.getInt("userId"));
						vaccinationPlan.setLastChgBy(users);
						hbt.save(vaccinationPlan);
						visitObjToUpdate.setVisitStatus("C");
						hbt.update(visitObjToUpdate);
						flag = true;

						vaccinationPlanId = vaccinationPlan.getId();

						long memberId2 = 0;
						List<PhMemberSurvey> PhMemberSurveyList = new ArrayList<PhMemberSurvey>();
						PhMemberSurveyList = session
								.createCriteria(PhMemberSurvey.class)
								.add(Restrictions.eq("Id", memberId))
								.list();
						int subcentreId = 0;
						for (PhMemberSurvey PhMemberSurvey : PhMemberSurveyList) {
							if (PhMemberSurvey.getHospital() != null) {
								subcentreId = PhMemberSurvey.getHospital()
										.getId();
								memberId2 = PhMemberSurvey.getMemberId();
								}
						}
						List<OpdVaccinationPlan> OpdVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
						OpdVaccinationPlanList = session
								.createCriteria(OpdVaccinationPlan.class)
								.add(Restrictions.eq("Id",
										vaccinationPlanId)).list();
						for (OpdVaccinationPlan opdVaccinationPlan : OpdVaccinationPlanList) {
							if (subcentreId != 0) {
									MasHospital mh = new MasHospital();
								mh.setId(subcentreId);
								opdVaccinationPlan.setSubCentre(mh);
								opdVaccinationPlan.setMember(memberId2);
								hbt.update(opdVaccinationPlan);
							}
						}

						if (box.getInt("route" + i) != 0) {
							route = box.getInt("route" + i);
							routeOfAdministration = new RouteOfAdministration(route);
						}

						patientPrescriptionHeader.setHin(patientList2.get(0));
						patientPrescriptionHeader.setPrescriptionNo(prescriptionNo);
						patientPrescriptionHeader.setVisit(visitObjToUpdate);
						patientPrescriptionHeader.setHospital(masHospital);
						patientPrescriptionHeader.setStatus("p");
						patientPrescriptionHeader.setPrescriptionDate(new Date());

						if (pHeaderId != null && pHeaderId != 0) {
							hbt.update(patientPrescriptionHeader);
						} else {
							hbt.save(patientPrescriptionHeader);
						}

						int item_class_id = 0;
						List<MasFrequency> masFrequencies = null;
						MasFrequency masFrequency = null;
						MasStoreItem masStoreItem = null;

						masFrequencies = session.createCriteria(MasFrequency.class).add(Restrictions.eq("FrequencyName", "OD").ignoreCase()).list();
						if(masFrequencies!=null && masFrequencies.size()>0)
							masFrequency = masFrequencies.get(0);

						PatientPrescriptionDetails patientPrescriptionDetails = new PatientPrescriptionDetails();

						masStoreItem = (MasStoreItem) session.load(
								MasStoreItem.class,
								box.getInt("vaccineItemId" + i));

						patientPrescriptionDetails.setItem(masStoreItem);
						patientPrescriptionDetails.setNoOfDays(1);
						
						patientPrescriptionDetails.setFrequency(masFrequency);
						patientPrescriptionDetails.setType("OP");
						patientPrescriptionDetails.setNursingStatus("n");
						patientPrescriptionDetails
								.setPrescription(patientPrescriptionHeader);
						patientPrescriptionDetails.setInjectionStatus("p");
						patientPrescriptionDetails.setDosage(1.0f);  // 1 is set because it is vaccin given to a child
						if(routeOfAdministration!=null)
							patientPrescriptionDetails.setRoute(routeOfAdministration);

						hbt.save(patientPrescriptionDetails);

						injectionAppointment.setHospital(masHospital);
						injectionAppointment.setStatus("p");
						injectionAppointment.setLastChgTime(time);
						injectionAppointment.setLastChgDate(new Date());
						injectionAppointment
								.setPrescription(patientPrescriptionHeader);
						if (injectionRegisterList.size() > 0) {
							hbt.update(injectionAppointment);
						} else {
							Patient patientInj = new Patient();
							patientInj.setId(patientList2.get(0).getId());
							injectionAppointment.setHin(patientInj);
							Visit visitInj = new Visit();
							visitInj.setId(visitId);
							injectionAppointment.setVisit(visitInj);
							hbt.save(injectionAppointment);
						}

						InjAppointmentDetails injAppointmentDetails = new InjAppointmentDetails();
						injAppointmentDetails.setInjAppointmentDate(new Date());
						injAppointmentDetails.setDose("1");   // 1 is set because it is vaccin given to a child
						injAppointmentDetails.setItem(masStoreItem);
						injAppointmentDetails
								.setInjAppointmentHeader(injectionAppointment);
						injAppointmentDetails
								.setPrescriptionDetails(patientPrescriptionDetails);
						injAppointmentDetails.setNoOfDays(1); // 1 is set because it is vaccin given to a child
						injAppointmentDetails.setFrequency(masFrequency);
						injAppointmentDetails.setStatus("p");
						injAppointmentDetails.setFinalStatus("n");
						injAppointmentDetails.setImmunizationInj("Y");
						injAppointmentDetails.setVaccinId(box
								.getInt("vaccineId" + i));
						
						injAppointmentDetails.setRoute(routeOfAdministration.getRouteName());
						
						hbt.save(injAppointmentDetails);  

					} else if (box.getString("completionDate" + i) != null
							&& !box.getString("completionDate" + i).equals("")) {
						OpdVaccinationPlan vaccinationPlan = new OpdVaccinationPlan();

						vaccinationPlan.setVaccinCompleteDate(HMSUtil
								.convertStringTypeDateToDateType(box
										.getString("completionDate" + i)));

						if (box.getString("vaccineDate" + i) != null
								&& !box.getString("vaccineDate" + i).equals("")) {
							vaccinationPlan.setVaccinDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString("vaccineDate" + i)));
						}
						if (box.getInt("vaccineId" + i) != 0) {
							OpdVaccinMst vaccinMst = new OpdVaccinMst();
							vaccinMst.setId(box.getInt("vaccineId" + i));
							vaccinationPlan.setVaccin(vaccinMst);
						}
						if (box.getString("vaccineToDate" + i) != null
								&& !box.getString("vaccineToDate" + i)
										.equals("")) {
							vaccinationPlan.setVaccinToDate(HMSUtil
									.convertStringTypeDateToDateType(box
											.getString("vaccineToDate" + i)));
						}
						if (box.getString("remarks" + i) != null
								&& !box.getString("remarks" + i).equals("")) {
							vaccinationPlan.setRemarks(box.getString("remarks"
									+ i));
						}
						if (box.getString("vaccinePlace" + i) != null
								&& !box.getString("vaccinePlace" + i).equals("")) {
							vaccinationPlan.setVaccinePlace(box.getString("vaccinePlace" + i));
						}

						if (box.getInt("hinId") != 0) {
							Patient hin = new Patient();
							hin.setId(box.getInt("hinId"));
							vaccinationPlan.setHin(hin);
						}
						if (box.getInt("deptId") != 0) {
							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId(box.getInt("deptId"));
							vaccinationPlan.setDepartment(masDepartment);
						}
						if (box.getInt("visitId") != 0) {
							Visit visit = new Visit();
							visit.setId(box.getInt("visitId"));
							vaccinationPlan.setVisit(visit);
						}
						//Added by Arbind on 09-10-2017
						if (box.getString("vaccineHospital" + i) != null
								&& !box.getString("vaccineHospital" + i).equals("")) {
							vaccinationPlan.setPlaceName(box.getString("vaccineHospital" + i));
						}

						vaccinationPlan.setVaccinInstitute(masHospital);
						vaccinationPlan.setHospital(masHospital);
						vaccinationPlan.setLastChgDate(HMSUtil
								.convertStringTypeDateToDateType(date));
						vaccinationPlan.setLastChgTime(time);
						Users users = new Users();
						users.setId(box.getInt("userId"));
						vaccinationPlan.setLastChgBy(users);
						hbt.save(vaccinationPlan);
						visitObjToUpdate.setVisitStatus("C");
						hbt.update(visitObjToUpdate);
						flag = true;

						vaccinationPlanId = vaccinationPlan.getId();

						long memberId2 = 0;
						List<PhMemberSurvey> PhMemberSurveyList = new ArrayList<PhMemberSurvey>();
						PhMemberSurveyList = session
								.createCriteria(PhMemberSurvey.class)
								.add(Restrictions.eq("Id", memberId)).list();
						int subcentreId = 0;
						for (PhMemberSurvey PhMemberSurvey : PhMemberSurveyList) {
							if (PhMemberSurvey.getHospital() != null) {
								subcentreId = PhMemberSurvey.getHospital()
										.getId();
								memberId2 = PhMemberSurvey.getMemberId();

							}
						}
						List<OpdVaccinationPlan> OpdVaccinationPlanList = new ArrayList<OpdVaccinationPlan>();
						OpdVaccinationPlanList = session
								.createCriteria(OpdVaccinationPlan.class)
								.add(Restrictions.eq("Id", vaccinationPlanId))
								.list();
						for (OpdVaccinationPlan opdVaccinationPlan : OpdVaccinationPlanList) {
							if (subcentreId != 0) {

								MasHospital mh = new MasHospital();
								mh.setId(subcentreId);
								opdVaccinationPlan.setSubCentre(mh);

								opdVaccinationPlan.setMember(memberId2);
								hbt.update(opdVaccinationPlan);

							}

						}
					}

				}
			}
		} else {
			OpdVaccinationPlan vaccinationPlan = null;
			vaccinationPlan = new OpdVaccinationPlan();
			if(box.get("referral") !=null && box.getInt("referral") == 1) {

				if (box.getInt("visitId") != 0) {
					Visit visit = new Visit();
					visit.setId(box.getInt("visitId"));
					vaccinationPlan.setVisit(visit);
				}
				if (box.getInt("hinId") != 0) {
					Patient hin = new Patient();
					hin.setId(box.getInt("hinId"));
					vaccinationPlan.setHin(hin);
				}
				if (box.getInt("deptId") != 0) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(box.getInt("deptId"));
					vaccinationPlan.setDepartment(masDepartment);
				}
				if (box.get("referVisitDate") != null && !box.get("referVisitDate").equals("")) {
					vaccinationPlan.setReferDate(HMSUtil.convertStringTypeDateToDateType(box.get("referVisitDate")));
				}
				if (box.get("referdepartment") != null && box.getInt("referdepartment") != 0) {
					MasDepartment masDepartment = new MasDepartment();
					masDepartment.setId(box.getInt("referdepartment"));
					vaccinationPlan.setReferDeptId(masDepartment);
					
				}
				if (box.get("rferRemarks") != null && !box.get("rferRemarks").equals("")) {
					vaccinationPlan.setReferRemarks(box.get("rferRemarks"));
				}
				vaccinationPlan.setHospital(masHospital);
				vaccinationPlan.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
				vaccinationPlan.setLastChgTime(time);
				Users users = new Users();
				users.setId(box.getInt("userId"));
				vaccinationPlan.setLastChgBy(users);
				vaccinationPlan.setReferStatus("y");
				hbt.save(vaccinationPlan);
				flag = true;
				/*visitObjToUpdate.setVisitStatus("C");
				hbt.update(visitObjToUpdate);*/
			}
		}

			if (flag) {
				message = "Record Saved Successfully";
			} else {
				message = "Records Not Added/Updated!... Try Again.....";

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (memberServeyId != 0) {
			vaccinationPlanList = session
					.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.eq("Member.Id", memberServeyId)).list();
			immunizationList = session.createCriteria(PhMemberSurvey.class)
					.add(Restrictions.idEq(memberServeyId)).list();
			logger.info("immunizationList==" + immunizationList.size());
			
		} else if (box.getInt("hinId") != 0) {
			vaccinationPlanList = session
					.createCriteria(OpdVaccinationPlan.class)
					.add(Restrictions.eq("Hin.Id", box.getInt("hinId"))).list();
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.idEq(box.getInt("hinId"))).list();
		}
		vaccineList = session.createCriteria(OpdVaccinMst.class)
				.add(Restrictions.eq("Status", "y")).list();

		tx.commit();
		map.put("vaccineList", vaccineList);
		map.put("immunizationList", immunizationList);
		map.put("patientList", patientList);
		map.put("message", message);
		map.put("vaccinationPlanList", vaccinationPlanList);
		map.put("pHeaderId", pHeaderId);
		map.put("referredSession", opsessionId);
		return map;
	}

	@Override
	public Map<String, Object> getImmunNursingCareWaitingList(Map<String, Object> map) {
		Integer hospitalId=(Integer)map.get("hospitalId");
		int deptId=(Integer)map.get("deptId");
		Date FromDateId=(Date)map.get("FromDateId");
		Date ToDateId=(Date)map.get("ToDateId");
		List<PatientPrescriptionHeader> pendingInjectionList = new ArrayList<PatientPrescriptionHeader>();
		List<InjAppointmentHeader> InjectionList = new ArrayList<InjAppointmentHeader>();
		
		Session session = (Session)getSession();
		Criteria crit = null;
		Criteria critApp = null;
		
		List<ProcedureDetails> procedureDetails = new ArrayList<ProcedureDetails>();
		procedureDetails = session.createCriteria(ProcedureDetails.class)
				.createAlias("ProcedureHeader", "ph")
				.createAlias("ph.Hospital", "h")
				.add(Restrictions.eq("h.Id",hospitalId))
				.add(Restrictions.eq("AppointmentDate", new Date()))
				.add(Restrictions.eq("Status", 'n').ignoreCase()).list();
		
		List<Integer> visitList = new ArrayList<Integer>(new HashSet());
		for(ProcedureDetails listA: procedureDetails)
		{
			visitList.add(listA.getProcedureHeader().getVisit().getId());
		}
		procedureDetails.clear();
				
		

		critApp = session.createCriteria(InjAppointmentDetails.class)
				.createAlias("InjAppointmentHeader", "injAph")
				.createAlias("injAph.Hospital", "h")
				.add(Restrictions.eq("Status", "p").ignoreCase())
				.add(Restrictions.eq("h.Id", hospitalId))
				/*.add(Restrictions.or(Restrictions.in("injAph.Visit.Id", visitList), Restrictions.eq("injAph.AppointmentDate",new Date())))*/
				//.add(Restrictions.eq("injAph.AppointmentDate",new Date()))
				.add(Restrictions.eq("InjAppointmentDate",new Date()))
				//added by Arbind on 22-11-2017
				.add(Restrictions.eq("ImmunizationInj", "Y").ignoreCase())
				.setProjection(Projections.groupProperty("InjAppointmentHeader"));
		
		
		
		InjectionList = critApp.list();		
		for(InjAppointmentHeader listB: InjectionList)
		{
			if(listB.getVisit()!=null){
				visitList.add(listB.getVisit().getId());
			    }
		}
		List<Visit>pendingNursingList = new ArrayList<Visit>();		
		if(visitList.size()>0){
			pendingNursingList = session.createCriteria(Visit.class).add(Restrictions.in("Id", visitList)).list();
			procedureDetails.clear();
		}
		map.put("pendingNursingList", pendingNursingList);
		

		return map;
	}

	@Override
	public Map<String, Object> getDrugAndProcedureDetails(Map<String, Object> map) {
		try{
			String hinNo=(String)map.get("hinNo");
			Integer injAppId=(Integer)map.get("injAppId");
			Integer departmentId=(Integer)map.get("departmentId");
			Integer hospitalId=(Integer)map.get("hospitalId");
			int visitId=(Integer)map.get("visitId");
			String strDate=(String)map.get("opdDate");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date date=sdf.parse(strDate);
			Date today = new Date();
			
			Session session = (Session) getSession();
			List<PatientPrescriptionHeader> injectionList = new ArrayList<PatientPrescriptionHeader>();
			List<InjAppointmentDetails> injectionAppList = new ArrayList<InjAppointmentDetails>();
			if(injAppId!=null && injAppId!=0){
				injectionAppList=session.createCriteria(InjAppointmentDetails.class)
								.createAlias("InjAppointmentHeader","injAPNTHDR")
								.add(Restrictions.eq("injAPNTHDR.Id", injAppId)).list();  
			}
			
			List<InjAppointmentDetails> injappList = session.createCriteria(InjAppointmentDetails.class)
					.createAlias("InjAppointmentHeader", "injHeader")
					.add(Restrictions.eq("injHeader.Visit.Id", visitId))
					//added by Arbind on 22-11-2017
					.add(Restrictions.eq("ImmunizationInj", "Y").ignoreCase())
					.list();
		
			//Added by Arbind on 26-10-2017
			List<StoreItemBatchStock> batchList =  new ArrayList<StoreItemBatchStock>();
			for(InjAppointmentDetails injAppointmentDetails : injappList) {
				List<StoreItemBatchStock> storeItemBatchStocks = session.createCriteria(StoreItemBatchStock.class)
					.createAlias("Item", "item")
					.add(Restrictions.eq("item.Id", injAppointmentDetails.getItem().getId()))
	  				.add(Restrictions.eq("Department.Id", departmentId))
	  				.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
					batchList.addAll(storeItemBatchStocks);
			}

			List<Visit> visitList = new ArrayList<Visit>();
			visitList= session.createCriteria(Visit.class).add(Restrictions.eq("Id", visitId)).list();
			
			Map<String,Object> mapProce = getDetailsForProcWaitList(hospitalId,visitId);
			map.put("pendingProcList", (List<ProcedureHeader>)mapProce.get("pendingProcList"));
			map.put("injectionAppList", injectionAppList);
			map.put("aList",injappList);
			map.put("visitList",visitList);
			map.put("batchList", batchList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getDetailsForProcWaitList(int hospitalId, int visitId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
		List<MasNursingCare> procedureList = new ArrayList<MasNursingCare>();
		Session session = (Session)getSession();
		
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		doctorList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y")).createAlias("Hospital", "h")
						.add(Restrictions.eq("h.Id", hospitalId)).createAlias("EmpCategory", "ec")
						.add(Restrictions.eq("ec.EmpCategoryCode", empCategoryCodeForDoctor))
						.addOrder(Order.asc("FirstName")).list();
		procedureList = session.createCriteria(MasNursingCare.class)
						.add(Restrictions.eq("Status", "y"))
						/*.add(Restrictions.eq("NursingType", "p").ignoreCase())*/
						.addOrder(Order.asc("NursingName")).list();
		
		List<ProcedureHeader> pendingProcList = new ArrayList<ProcedureHeader>();
		Date fromDate = new Date();
		Date toDate =  new Date();
		
		pendingProcList = session.createCriteria(ProcedureDetails.class)
						.createAlias("ProcedureHeader", "ph")
						.createAlias("ph.Hospital", "h")
						.createAlias("ph.Visit", "v")
						.add(Restrictions.eq("v.Id", visitId))
						.add(Restrictions.eq("h.Id", hospitalId))
						/*.add(Restrictions.between("ph.RequisitionDate", fromDate, toDate))*/.list();
		
		map.put("doctorList", doctorList);
		map.put("procedureList", procedureList);		
		map.put("pendingProcList", pendingProcList);
		logger.info("pendingProcListpendingProcList "+pendingProcList.size());
		
		return map;
	}

	public Map<String, Object> getItemBatch(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();
		int deptId = box.getInt("deptId");
		int itemId =  box.getInt("itemId");
		int appDtId=box.getInt("appDtId");
		int hospitalId = box.getInt("hospitalId");
		int appointmentHeaderId = box.getInt("appointmentHeaderId");
		List<MasSession> sessionList = null;
		
		Session session = (Session)getSession();
		

		sessionList = session.createCriteria(MasSession.class).list(); 
		
		List<InjAppointmentDetails>injAppointmentDetails=session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader","header")
						.add(Restrictions.eq("Item.Id",itemId))
						.add(Restrictions.eq("header.Id",appointmentHeaderId))
						.addOrder(Order.asc("Id")).list();
		
		int pharmacyDepId =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "pharmacyDepId".trim()));
		String blockStatus [] = {"Temporary Block","Parmanent Block"};
		batchList = session.createCriteria(StoreItemBatchStock.class).createAlias("Item", "item")
						.add(Restrictions.eq("item.Id", itemId))
		  				.createAlias("Department", "dept")
		  				.add(Restrictions.eq("dept.Id", deptId))
		  				.add(Restrictions.eq("Hospital.Id", box.getInt("hospitalId")))
		  				//.add(Restrictions.or(Restrictions.not(Restrictions.in("BlockStatus", blockStatus)), Restrictions.isNull("BlockStatus")))
		  				.list();
		
		map.put("batchList", batchList);
		map.put("sessionList", sessionList);
		map.put("injAppointmentDetails", injAppointmentDetails);
		
		return map;
	}

	@Override
	public Map<String,Object> submitNursingCare(Box box){
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
		String immunizationInj = box.getString("immunizationInj");
		String frequencyCode = null;
		
		int sessionId = 0;
		if(box.get("sessionId") != null) 
			sessionId= box.getInt("sessionId");
		MasSession masSession = null;
		
		
		if(sessionId!=0)
			masSession = (MasSession) hbt.get(MasSession.class, sessionId);		
				
		InjAppointmentDetails injAppointmentDetails = (InjAppointmentDetails) hbt.get(InjAppointmentDetails.class, Id);
		
		int noOfDays = 0;
		
		if(injAppointmentDetails.getNoOfDays()!=null)
			noOfDays = injAppointmentDetails.getNoOfDays();
			
		int nFrequencyCode =0;
		// int frequencyId= injAppointmentDetails.getFrequency().getId();
		int nursingId= injAppointmentDetails.getPrescriptionDetails().getId();
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
				.createAlias("PrescriptionDetails", "nr")
				.add(Restrictions.eq("header.Id", injAppointmentHeaderId))
				.add(Restrictions.eq("nr.Id", nursingId))
				.add(Restrictions.isNull("ExceptionalPrescription"));
		listA = cr.list();
		
		Criteria crExce =session.createCriteria(InjAppointmentDetails.class).createAlias("InjAppointmentHeader", "header")
				.createAlias("PrescriptionDetails", "nr")
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
				newDetailsId.setPrescriptionDetails(injAppointmentDetails.getPrescriptionDetails());
				newDetailsId.setInjAppointmentHeader(injAppointmentDetails.getInjAppointmentHeader());
				newDetailsId.setItem(injAppointmentDetails.getItem());
				newDetailsId.setDose(injAppointmentDetails.getDose());
				newDetailsId.setFrequency(injAppointmentDetails.getFrequency());
				newDetailsId.setStatus("p");
				newDetailsId.setNoOfDays(injAppointmentDetails.getNoOfDays());
				newDetailsId.setFinalStatus("n");
				
				if(masSession!=null)
					newDetailsId.setSession(masSession);
				
				if(box.get("AppointmentFlag") != null && box.getString("AppointmentFlag").equalsIgnoreCase("y"))
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
						
						if(masSession!=null)
							injAppointmentDetails.setSession(masSession);
						
						
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
							
							if(masSession!=null)
								injAppointmentDetails.setSession(masSession);
							
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
		
		if(immunizationInj!=null && immunizationInj.equalsIgnoreCase("Y")){
			injAppointmentDetails.setFinalStatus("y");
			hbt.update(injAppointmentDetails);

			Patient hin = null;
			int hinId=0, vaccinId=0;
			hinId = box.getInt("hinId");
			vaccinId = box.getInt("vaccinId");
			if(hinId!=0){
				hin = (Patient)session.get(Patient.class, box.getInt("hinId"));
			}

			List<OpdVaccinationPlan>opdVaccinationPlanPh=session.createCriteria(OpdVaccinationPlan.class)
					.createAlias("Vaccin", "vaccin").createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.Id", hinId))
					.add(Restrictions.eq("vaccin.Id", vaccinId)).list();
			OpdVaccinationPlan vaccinationPlan=null; 
			if(opdVaccinationPlanPh.size()>0){
				vaccinationPlan=opdVaccinationPlanPh.get(0);
				if(!(vaccinationPlan.getVaccinePlace() != null)){
					vaccinationPlan.setVaccinePlace("Govt Hospital");
				}
			}

			logger.info("hin Id"+hinId +" vaccinId "+vaccinId+" size  "+opdVaccinationPlanPh.size());
//			OpdVaccinationPlan vaccinationPlan = new OpdVaccinationPlan();
			int vaccinationPlanId =0 ;
			
			MasHospital masHospital	= (MasHospital)session.get(MasHospital.class, box.getInt("hospitalId"));
			
			OpdVaccinMst vaccinMst = new OpdVaccinMst();
			vaccinMst.setId(vaccinId);
			vaccinationPlan.setVaccin(vaccinMst);
			vaccinationPlan.setVaccinCompleteDate(new Date());

		/*	vaccinationPlan.setHospital(masHospital);
			vaccinationPlan.setLastChgDate(new Date());
			vaccinationPlan.setLastChgTime(time);
			vaccinationPlan.setVaccinCompleteDate(new Date());
			Users users = new Users();
			users.setId(box.getInt("userId"));
			vaccinationPlan.setLastChgBy(users);*/
			hbt.update(vaccinationPlan);
			
			vaccinationPlanId=vaccinationPlan.getId();						
			
			if(hin!=null && hin.getMember()!=null){
			long memberId2=0;
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
	public Map<String, Object> showDashboardSurveyCount(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSurveyTarget> masSurveyTargets=new ArrayList<MasSurveyTarget>();
		List<MasSurveyTargetStatus> masSurveyTargetStatus=new ArrayList<MasSurveyTargetStatus>();
		
		Multimap<String, Long> tagetCount = ArrayListMultimap.create();
		Session session = (Session) getSession();
		
		int countHouse = 0;
		int memberCount = 0;
		int phcCount = 0;
		String query = "";

		Boolean successfullSends = false;
		int hospitalIds =0;
		int userType = 0;
		int districtId = 0;
		String instName=null;
		int dayBlockMonthly=0;
		int dayBlockCount=0;
		
		int instType=0;
		int base=0;		
		int healthBlock=0;
		int ListOfCenterId=0;
		int chcphc=0;
		
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));
		if(box.getInt("districtId")!=0){
			districtId= box.getInt("districtId");
		}
		if(box.getInt("userType")!=0){
			userType= box.getInt("userType");
		}
		if(box.getInt("hospitalIds")!=0){
			hospitalIds= box.getInt("hospitalIds");
		}
		if(box.getString("instName")!=null){
			instName= box.getString("instName");
		}
		if(box.getInt("instType") != 0 ) {
			instType = box.getInt("instType");
		}
		if(box.getInt("base")!=0){
			base= box.getInt("base");
		}
		if(box.getInt("healthBlockId")!=0){
			healthBlock= box.getInt("healthBlockId");
		}
		if(box.getInt("ListOfCenterId")!=0){
			ListOfCenterId= box.getInt("ListOfCenterId");
		}
		if(box.getInt("chcphc")!=0){
			chcphc= box.getInt("chcphc");
		}
		int instituteType=0;
		if(box.getInt("instituteType") != 0 ) {
			instituteType = box.getInt("instituteType");
		}
		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate"));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate"));
		String fromDateMonth = box.getString("fromDate").split("/")[2] + "/"
				+ box.getString("fromDate").split("/")[1] + "/"
				+ box.getString("fromDate").split("/")[0];
		String toDateMonth = box.getString("toDate").split("/")[2] + "/"
				+ box.getString("toDate").split("/")[1] + "/"
				+ box.getString("toDate").split("/")[0];
		
		
				String qry	=	"select phs.house_hold_id, jjd.date_atp as atp_date, pdb.house_id ,pdb.for_day from ph_atp_jphn_jhi_details jjd "
						+ " left outer join   ph_atp_jphn_jhi_header  jjh on jjd.atp_header_id=jjh.atp_header_id "
						+ " left outer join ph_day_block  pdb on jjd.day_block_id=pdb.day_id left outer  join "
						+ "ph_day_block_detail dbd on dbd.day_id=pdb.day_id left outer join ph_house_survey phs "
						+ " on phs.survey_id=dbd.survey_id left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
						+ "where jjh.status=2 AND jjd.date_atp between '"+fromDate+"' and '"+toDate+"'";

		try {
			if(districtId!=0 &&  instType!=0 && healthBlock!=0 &&  chcphc!=0 &&  base!=0 &&  hospitalIds!=0 ){
						countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
								+ " and mh.district_id = " + districtId	
								
								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
								+ " and mh.parent_institute_id="+chcphc
								+ " and mh.hospital_id="+base
									).uniqueResult())).intValue();
						
						memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
								+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
								+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
								+ " and mh.district_id = " + districtId
								
								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
								+ " and mh.parent_institute_id="+chcphc
								+ " and mh.hospital_id="+base
								).uniqueResult()).intValue();
						
				qry = qry+ " and mh.district_id = "
								+ districtId
								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
								+ healthBlock
								+ "))"
								+ " and mh.parent_institute_id="
								+ chcphc
								+ " and mh.hospital_id="
								+ base
								+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}
						
						masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
								.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
								.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
								.add(Restrictions.eq("dis.Id", districtId))
								.add(Restrictions.eq("hb.Id", healthBlock))
								.add(Restrictions.eq("CI.Id", chcphc))
								.add(Restrictions.eq("BSCI.Id", base))
								.add(Restrictions.ge("FromDate", fromDate))
								.add(Restrictions.le("ToDate", toDate)).list();
								if(masSurveyTargets.size()>0){
									MasSurveyTarget masSurveyTarget=masSurveyTargets.get(0);
									int surveytargetId=masSurveyTarget.getId();
									masSurveyTargetStatus = session.createCriteria(MasSurveyTargetStatus.class).createAlias("Target", "target")
									.add(Restrictions.eq("target.Id", new Integer(surveytargetId)))
									.add(Restrictions.eq("institutionTypeId", instituteType))
									.list();
								}
							
			}
				
				else if(districtId !=0 &&instType!=0 && healthBlock!=0 &&  chcphc!=0 && hospitalIds!=0){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId	
							
							+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
							+ " and mh.parent_institute_id="+chcphc
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId
							
							+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
							+ " and mh.parent_institute_id="+chcphc
							).uniqueResult()).intValue();
					
				qry = qry +" and mh.district_id = "
								+ districtId
								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
								+ healthBlock
								+ "))"
								+ " and mh.parent_institute_id="
								+ chcphc
								+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

					masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
							.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
							.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI")
						 .add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.eq("hb.Id", healthBlock))
						.add(Restrictions.eq("CI.Id", chcphc))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate )).list();
					
							if(masSurveyTargets.size()>0){
								MasSurveyTarget masSurveyTarget=masSurveyTargets.get(0);
								int surveytargetId=masSurveyTarget.getId();
								masSurveyTargetStatus = session.createCriteria(MasSurveyTargetStatus.class).createAlias("Target", "target")
								.add(Restrictions.eq("target.Id", new Integer(surveytargetId))).list();
							}
				
				}
				
				else if(districtId !=0 &&instType!=0 && healthBlock!=0 &&  hospitalIds!=0){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId	

							+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId

							+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlock+"))"
							).uniqueResult()).intValue();
				
					qry = qry +" and mh.district_id = "
							+ districtId
							+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
							+ healthBlock
							+ "))"
							+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
			Query qrey = session.createSQLQuery(qry);
			List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
			for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}					

					masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
							.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
							.createAlias("HealthBlock", "hb")
								.add(Restrictions.eq("hos.Id", hospitalIds)).add(Restrictions.eq("dis.Id", districtId))//.add(Restrictions.eq("hosType.Id", instType))
								.add(Restrictions.eq("hb.Id", healthBlock)).add(Restrictions.ge("FromDate", fromDate))
								.add(Restrictions.le("ToDate", toDate))
								.list();
						if (masSurveyTargets.size() > 0) {
							
							MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
							int surveytargetId = masSurveyTarget.getId();
							masSurveyTargetStatus = session
									.createCriteria(MasSurveyTargetStatus.class)
									.createAlias("Target", "target")
									.add(Restrictions.eq("target.Id", new Integer(surveytargetId))).list();
							}
						
				}
				
				else if(districtId !=0 &&instType!=0 && hospitalIds!=0){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId	
							//+ " and mh.hospital_type_id = " + instType
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId
							//+ " and mh.hospital_type_id = " + instType
							).uniqueResult()).intValue();
					
					qry = qry +" and mh.district_id = "
							+ districtId
							+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
			Query qrey = session.createSQLQuery(qry);
			List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
			for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}
	
					masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
							.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
						.add(Restrictions.eq("dis.Id", districtId))//.add(Restrictions.eq("hosType.Id", instType)) .add(Restrictions.eq("hos.Id", hospitalIds))
						.add(Restrictions.ge("FromDate", fromDate))
								.add(Restrictions.le("ToDate", toDate)).list();
							if(masSurveyTargets.size()>0){
								MasSurveyTarget masSurveyTarget=masSurveyTargets.get(0);
								int surveytargetId=masSurveyTarget.getId();
								masSurveyTargetStatus = session.createCriteria(MasSurveyTargetStatus.class).createAlias("Target", "target")
										.add(Restrictions.eq("target.Id", new Integer(surveytargetId))).list();
							}
				
				}
				
				else if(districtId !=0 && hospitalIds!=0){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId	
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId
							).uniqueResult()).intValue();
					
					qry = qry +" and mh.district_id = "
							+ districtId
							+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
			Query qrey = session.createSQLQuery(qry);
			List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
			for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}
	
					masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
							.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
							.add(Restrictions.eq("hos.Id", hospitalIds)).add(Restrictions.eq("dis.Id", districtId))
							.add(Restrictions.between("FromDate", fromDate, toDate))
								.add(Restrictions.between("ToDate", fromDate, toDate)).list();
							if(masSurveyTargets.size()>0){
								MasSurveyTarget masSurveyTarget=masSurveyTargets.get(0);
								int surveytargetId=masSurveyTarget.getId();
								masSurveyTargetStatus = session.createCriteria(MasSurveyTargetStatus.class).createAlias("Target", "target")
								.add(Restrictions.eq("target.Id", new Integer(surveytargetId))).list();
							}
				
				}
			
				else if(districtId !=0 ){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId	
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							+ " and mh.district_id = " + districtId
							).uniqueResult()).intValue();
				}
				
				else if(districtId ==0 && hospitalIds!=0){
					
					countHouse = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
							+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
							+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
							).uniqueResult())).intValue();
					
					memberCount = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
							+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
							+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
							).uniqueResult()).intValue();
					
					qry = qry +" group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
			Query qrey = session.createSQLQuery(qry);
			List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
			for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}
					
					masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
							.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
							.add(Restrictions.ge("FromDate", fromDate))//.add(Restrictions.eq("hos.Id", hospitalIds))
							.add(Restrictions.le("ToDate", toDate))
							.list();
							if(masSurveyTargets.size()>0){
								MasSurveyTarget masSurveyTarget=masSurveyTargets.get(0);
								int surveytargetId=masSurveyTarget.getId();
								masSurveyTargetStatus = session.createCriteria(MasSurveyTargetStatus.class).createAlias("Target", "target")
								.add(Restrictions.eq("target.Id", new Integer(surveytargetId))).list();
							}
					
				}
			

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		Map statusMap = new HashMap<>();
		if(masSurveyTargetStatus.size()>0 && masSurveyTargetStatus!=null){
			for(MasSurveyTargetStatus surveyTargetStatus:masSurveyTargetStatus){
				String designation =null;String status =null;
				try {
					designation= surveyTargetStatus.getLastChangeBy().getEmployee().getRank().getRankName();
				} catch (Exception e) {
				}try {
					status= surveyTargetStatus.getStatus();
				} catch (Exception e) {
				}
				
				statusMap.put(designation.replaceAll("\\s",""), status);
			}
		}
		int targetId=0;
		Long annualHStarget=0l;
		
		Long annualHVisitTarget=0l;
		String status=null;
		String remarks=null;
		long annualMemberSurveyTarget=0;
		if(masSurveyTargets.size()>0){
			
			targetId=masSurveyTargets.get(0).getId();
			
			status=masSurveyTargets.get(0).getRemarks();
			remarks=masSurveyTargets.get(0).getStatus();
			
			for(MasSurveyTarget masSurveyTarget :masSurveyTargets)
			{
				
				try {
					annualHStarget += masSurveyTarget.getAnnualHouseSurveyTarget();	
				} catch (Exception e) {
				}
				try {
					annualMemberSurveyTarget += masSurveyTarget.getAnnualMemberSurveyTarget();						
				} catch (Exception e) {
				}
				try {
					annualHVisitTarget += masSurveyTarget.getAnnualHouseVisitCount();		
				} catch (Exception e) {
				}
			}
		}
		map.put("annualMemberSurveyTarget", annualMemberSurveyTarget); 
		map.put("annualHStarget", annualHStarget);
		map.put("annualHVisitTarget", annualHVisitTarget);
		map.put("tagetCount", tagetCount);
		map.put("targetId",targetId);
		map.put("status", status);
		map.put("remarks", remarks);
		
		map.put("statusMap",statusMap);
		map.put("masSurveyTargetStatus", masSurveyTargetStatus);
		map.put("masSurveyTargets", masSurveyTargets);
		
		map.put("dayBlockCount", dayBlockCount);
		map.put("dayBlockMonthly", dayBlockMonthly);
		map.put("successfullSends", successfullSends);
		map.put("countHouse", countHouse);
		map.put("memberCount", memberCount);

		return map;
	}

	// added by Amit Das on 28-04-2016
	@Override
	public Map<String, Object> getMCTSChildReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = null;
		HibernateTemplate hibernateTemplate = null;
		Criteria criteria = null;
		Query query = null;
		List<Object[]> list = null;
		int noOfOpdAttendence = 0;
		//IdspHospitalReport idspHospitalReport = null;
		//MasHospital masHospital = null;
		int hospitalId = 0;
		hospitalId = box.getInt(HOSPITAL_ID);
		String hospitalName = "";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			session = (Session) getSession();

			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			hospitalName = hospital.getShortName();
			query = session.createSQLQuery(
					"(select distinct member_survey_date as reg_date, (select max(vaccin_complete_date) from opd_vaccination_plan ovp where ovp.member_id = pms.member_id) as updated_date, "
							+ "hospital_type_name, mh.short_name, "
							+ "mv.village_name, phs.address, cast(extract(year from pms.member_survey_date) as character varying) as year, cast(pms.member_id as character varying) as child_id, "
							+ "pms.name as child_name, case when relationship_name = 'Mother' then person_name end as mother_name, "
							+ "pms.contact_no, pms.date_of_birth, delivery_place, case when pms.blood_group not in  ('Select', ' Select')  then pms.blood_group end as blood_group, "
							+ "administrative_sex_name as sex, mr.religion_name as caste, asha_name, asha_contact, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'BCG - BACILLUS CALMETTE GUERIN%' and dose = 1 order by dose limit 1 ) as bcg, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 0 order by dose limit 1 ) as opv0, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'HEPATITIS B%' and dose = 0 order by dose limit 1 ) as HepB0, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 1 order by dose limit 1 ) as dtp1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 1 order by dose limit 1) as opv1, "

							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'HEPATITIS B%' and dose = 1 order by dose limit 1 ) as hepb1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 2 order by dose limit 1 ) as dtp2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 2 order by dose limit 1 ) as opv2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'HEPATITIS B%' and dose = 2 order by dose limit 1 ) as hepb2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 3 order by dose limit 1 ) as dtp3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 3 order by dose limit 1) as opv3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.member_id = pms.member_id and vaccin_name like 'HEPATITIS B%' and dose = 3 order by dose limit 1 ) as hepb3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Measles%' and dose = 1 order by dose limit 1 ) as measles1, "
							
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Vitamin A%' and dose = 1 order by dose limit 1 ) as vit1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'MMR - MEASLES, MUMPS, AND RUBELLA%' and dose = 1 order by dose limit 1 ) as mr, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'DPT 1st Booster%' and dose = 1 order by dose limit 1 ) as dptbooster, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'OPV Booster%' and dose = 1 order by dose limit 1 ) as opvbooster, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Vitamin A%' and dose = 2 order by dose limit 1 ) as vit2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Vitamin A%' and dose = 3 order by dose limit 1 ) as vit3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'JAPANESE ENCEPHALITIS VACCINE%' and dose = 1 order by dose limit 1 ) as je, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Vitamin A%' and dose = 1 order by dose limit 1 ) as vit9, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'DT%' and dose = 5 order by dose limit 1 ) as dt, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'TT Booster 1%' and dose = 1 order by dose limit 1 ) as ttbooster1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'TT Booster 2%' and dose = 2 order by dose limit 1 ) as ttbooster2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Measles%' and dose = 2 order by dose limit 1 ) as measles2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 1 order by dose limit 1 ) as pentavalent1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 2 order by dose limit 1 ) as pentavalent2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.member_id = pms.member_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 3 order by dose limit 1 ) as pentavalent3, "
							+ " 'Tab Application' as isUpload "
							
							+ "from ph_member_survey pms "
							+ "left outer join mas_hospital mh on mh.hospital_id = pms.hospital_id "
							+ "left outer join mas_hospital_type mht on mh.hospital_type_id = mht.hospital_type_id "
							+ "left join ph_birth_death_reg birth on pms.member_id = birth.member_id " 
							+ "left join ph_house_survey phs on phs.house_hold_id = pms.house_id " 
							+ "left join mas_village mv on mv.village_id = phs.village_id "
							+ "left join mas_administrative_sex mas on mas.administrative_sex_id = pms.gender " 
							+ "left join mas_religion mr on mr.religion_id = pms.religion " 
							+ "left join ph_jsy_reg pjr on pjr.member_id = pms.member_id "
							+ "where (pms.hospital_id = :hospitalId or mh.parent_institute_id = :hospitalId) "
							+ " and extract (year from age(now(),pms.date_of_birth)) <= 18 "
							+ " and (pms.member_survey_date between :fromDate and :toDate)) "
							+ "UNION ALL "
							+ "(select distinct reg_date, (select max(vaccin_complete_date) from opd_vaccination_plan ovp where ovp.hin_id = pt.hin_id) as updated_date, " 
							+ "hospital_type_name, mh.short_name, "
							+ "village_name, patient_address as address, cast(extract(year from pt.reg_date) as character varying) as year, pt.hin_no as child_id, "
							+ "pt.p_first_name as child_name, case when pt.relation_id = 3 then relation_name end as mother_name, "
							+ "pt.mobile_number, pt.date_of_birth, case when pt.member_id is null then cast(pt.member_id as char) end as delivery_place, blood_group_name as blood_group, "
							+ "administrative_sex_name as sex, mr.religion_name as caste, case when pt.member_id is null then cast(pt.member_id as char) end as asha_name, " 
							+ "case when pt.member_id is null then cast(pt.member_id as char) end as asha_contact, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'BCG - BACILLUS CALMETTE GUERIN%' and dose = 1 order by dose limit 1 ) as bcg, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 0 order by dose limit 1 ) as opv0, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'HEPATITIS B%' and dose = 0 order by dose limit 1 ) as hepb0, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 1 order by dose limit 1 ) as dtp1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 1 order by dose limit 1) as opv1, "

							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'HEPATITIS B%' and dose = 1 order by dose limit 1 ) as hepb1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 2 order by dose limit 1 ) as dtp2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 2 order by dose limit 1 ) as opv2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'HEPATITIS B%' and dose = 2 order by dose limit 1 ) as hepb2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'DTP - DIPHTHERIA, TETANUS, AND PERTUSSIS%' and dose = 3 order by dose limit 1 ) as dtp3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'OPV - ORAL POLIO VACCINE%' and dose = 3 order by dose limit 1) as opv3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ "	where ovp.hin_id = pt.hin_id and vaccin_name like 'HEPATITIS B%' and dose = 3 order by dose limit 1 ) as hepb3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Measles%' and dose = 1 order by dose limit 1 ) as measles1, "
							
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Vitamin A%' and dose = 1 order by dose limit 1 ) as vit1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'MMR - MEASLES, MUMPS, AND RUBELLA%' and dose = 1 order by dose limit 1 ) as mr, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'DPT 1st Booster%' and dose = 1 order by dose limit 1 ) as dptbooster, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'OPV Booster%' and dose = 1 order by dose limit 1 ) as opvbooster, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Vitamin A%' and dose = 2 order by dose limit 1 ) as vit2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Vitamin A%' and dose = 3 order by dose limit 1 ) as vit3, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'JAPANESE ENCEPHALITIS VACCINE%' and dose = 1 order by dose limit 1 ) as je, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Vitamin A%' and dose = 1 order by dose limit 1 ) as vit9, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'DT%' and dose = 5 order by dose limit 1 ) as dt, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'TT Booster 1%' and dose = 1 order by dose limit 1 ) as ttbooster1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'TT Booster 2%' and dose = 2 order by dose limit 1 ) as ttbooster2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Measles%' and dose = 2 order by dose limit 1 ) as measles2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 1 order by dose limit 1 ) as pentavalent1, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 2 order by dose limit 1 ) as pentavalent2, "
							+ "(select vaccin_complete_date from opd_vaccination_plan ovp left outer join opd_vaccin_mst ovm on ovp.vaccin_id = ovm.vaccin_id "
							+ " where ovp.hin_id = pt.hin_id and vaccin_name like 'Pentavalent Vaccine%' and dose = 3 order by dose limit 1 ) as pentavalent3, "
							+ " 'Web Application' as isUpload "
							
							+ "from patient pt "
							+ "left outer join mas_hospital mh on mh.hospital_id = pt.hospital_id "
							+ "left outer join mas_hospital_type mht on mh.hospital_type_id = mht.hospital_type_id "
							+ "left join mas_administrative_sex mas on mas.administrative_sex_id = pt.sex_id " 
							+ "left join mas_religion mr on mr.religion_id = pt.religion_id "
							+ "left join mas_relation mre on mre.relation_id = pt.relation_id "
							+ "left join patient_address pa on pa.hin_id = pt.hin_id and address_type_id = 2 "
							+ "left join mas_village mv on mv.village_id = pa.village "
							+ "left join mas_blood_group mbg on mbg.blood_group_id = pt.blood_group_id "
							+ "where (pt.hospital_id = :hospitalId or mh.parent_institute_id = :hospitalId) "
							+ " and extract (year from age(now(),pt.date_of_birth)) <= 18 and member_id is null "
							+ " and (pt.reg_date between :fromDate and :toDate)) " );

			query.setParameter("hospitalId", box.getInt(HOSPITAL_ID));
			query.setParameter("fromDate", HMSUtil.convertStringTypeDateToDateType(box.getString("fromDate")));
			query.setParameter("toDate", HMSUtil.convertStringTypeDateToDateType(box.getString("toDate")));

			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("list", list);
		map.put("hospitalName", hospitalName);
		return map;
	}
	

	@Override
	public Map<String, Object> showPhMappingAdminJsp(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasHospital> cscList = new ArrayList<MasHospital>();
		cscList = session.createCriteria(MasHospital.class)
				.createAlias("HospitalType", "csc")
				.add(Restrictions.eq("csc.Id", 49))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		map.put("cscList", cscList);
		int hospitalTypeId = 0;
		if (box.getInt("hospitalTypeId") != 0) {
			hospitalTypeId = box.getInt("hospitalTypeId");
		}
		map.put("hospitalTypeId", hospitalTypeId);
		String healthBlock = "";
		int healthBlockId = 0;
		String phcCHC = "";
		int hospitalId = 0;
		if (box.getInt("hospitalId") != 0) {
			hospitalId = box.getInt("hospitalId");
		}
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		String labelName = "";
		String hospitalName = "";
		int hospitaltype = 0;
		int hospialIdphcCHC = 0;
		int subCenterIdd = 0;
		int userType = 4;/*General User*/
		int userId = 0;
		userType = box.getInt("userType");
		userId =  box.getInt("userId");
		if(userType == 5){ /* usertype 5 = PH Admin */
			
			List<String> parentInst = session.createCriteria(MasHospital.class).createAlias("ParentInstitute", "parent")
					.add(Restrictions.idEq(hospitalId)).setProjection(Projections.property("parent.HospitalName")).list();
			
			hospitalList  = session.createCriteria(UserHospital.class).createAlias("Hospital", "h")
					.add(Restrictions.eq("User.Id", userId)).add(Restrictions.eq("Status", "y").ignoreCase())
					.setProjection(Projections.projectionList().add(Projections.property("h.Id")).add(Projections.property("h.HospitalName")).add(Projections.property("h.HospitalType.Id"))).addOrder(Order.asc("h.HospitalName")).list();
			map.put("hospitalList", hospitalList);
			map.put("parentInst", parentInst.get(0));
			
		}
		/*if (hospitalTypeId == 1 || hospitalTypeId == 2) {
		
			hospitalList = session
					.createCriteria(MasHospital.class)
					.add(Restrictions.idEq(hospitalId))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.property("ParentInstitute.Id"))
									.add(Projections.property("HospitalName"))
									.add(Projections
											.property("HospitalType.Id"))

									.add(Projections.property("Id"))).list();
			if (hospitalList.size() > 0) {
				for (Object[] hospital : hospitalList) {
					hospialIdphcCHC = Integer.parseInt("" + hospital[0]);
					hospitalName = "" + hospital[1];
					hospitaltype = Integer.parseInt("" + hospital[2]);
					subCenterIdd = Integer.parseInt("" + hospital[3]);
				}
				System.out.println("subCenterIdd####" + subCenterIdd);
				System.out.println("hospialIdphcCHC " + hospialIdphcCHC);
				System.out.println("hospitalName####" + hospitalName);
				if (hospitaltype == 1) {
					labelName = "Sub Center";
				} else if (hospitaltype == 2) {
					labelName = "Basic Section";
				}
				map.put("labelName", labelName);
				map.put("hospitalName", hospitalName);
				map.put("subCenterIdd", subCenterIdd);
				map.put("hospialIdphcCHC", hospialIdphcCHC);

			}
			List<Object[]> phcCHCList = new ArrayList<Object[]>();
			if (hospialIdphcCHC != 0) {
				phcCHCList = session
						.createCriteria(MasHospital.class)
						.add(Restrictions.idEq(hospialIdphcCHC))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("HospitalName"))
										.add(Projections
												.property("ParentInstitute.Id")))
						.list();
			}
			int hospitalIdHB = 0;
			if (phcCHCList.size() > 0) {
				for (Object[] obj : phcCHCList) {
					phcCHC = "" + obj[0];
					hospitalIdHB = Integer.parseInt("" + obj[1]);
				}
			}

			System.out.println("hospitalIdHB####" + hospitalIdHB);
			map.put("phcCHC", phcCHC);
			map.put("hospitalIdHB", hospitalIdHB);
			List<Object[]> healthBlockList = new ArrayList<Object[]>();
			if (hospitalIdHB != 0) {
				healthBlockList = session
						.createCriteria(MasHospital.class)
						.add(Restrictions.idEq(hospitalIdHB))
						.setProjection(
								Projections
										.projectionList()
										.add(Projections
												.property("HospitalName"))
										.add(Projections
												.property("ParentInstitute.Id")))
						.list();
			}
			if (healthBlockList.size() > 0) {
				for (Object[] healthBlock1 : healthBlockList) {
					healthBlock = "" + healthBlock1[0];
					healthBlockId = Integer.parseInt("" + "" + healthBlock1[1]);
				}
			}
			map.put("healthBlock", healthBlock);
			map.put("healthBlockId", healthBlockId);
		}
	*/
		return map;
	}

	// -------------- HMIS Hospital Wise REPORT by Arbind on 23-09-2017 ---------------------

	@Override
	public Map<String, Object> getHMISReportDataFromDatabase(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasPhReportsParameters> hmisParameters = new ArrayList<MasPhReportsParameters>();
		List<ChildPojoForHmisParameter> hmisParametersList = new ArrayList<ChildPojoForHmisParameter>();
		List<HmisHospitalReport> list = new ArrayList<HmisHospitalReport>();
		Session session = (Session) getSession();
		int month = box.getInt("month");
		int year = box.getInt("year");
		int hospitalId = box.getInt("hospitalId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Query queryForStockDistributed = null;
		Query queryForTotalStock = null;
		Query queryForStockRecieved = null;
		List listForQuery = null;
		try {
			
			queryForStockDistributed = session
					.createSQLQuery("select coalesce(sum(sit.qty_issued),0) as count from store_issue_t sit join store_issue_m sim on sit.issue_m_id = sim.id "
							+ "join hmis_parameter_mapping hpm on sit.item_id = hpm.item_id "
							+ "where EXTRACT(MONTH FROM sim.issue_date)  = :month and hpm.parameter_id = :parameterId and sim.hospital_id = :hospitalId");
			queryForTotalStock = session
					.createSQLQuery("select coalesce(sum(sibs.closing_stock),0) as count from store_item_batch_stock sibs "
							+ "join hmis_parameter_mapping hpm on sibs.item_id = hpm.item_id "
							+ "where hpm.parameter_id = :parameterId and sibs.hospital_id = :hospitalId");
			queryForStockRecieved = session
					.createSQLQuery("select coalesce(sum(sgt.received_qty),0) as count from store_grn_t sgt "
							+ "join store_grn_m sgm on sgt.grn_master_id = sgm.grn_master_id "
							+ "join hmis_parameter_mapping hpm on sgt.item_id = hpm.item_id "
							+ "where  EXTRACT(MONTH FROM sgm.grn_date)  = :month and hpm.parameter_id = :parameterId and sgm.hospital_id = :hospitalId");

			Criteria cr = session.createCriteria(MasPhReportsParameters.class).add(Restrictions.isNotNull("HmisId")).add(Restrictions.isNotNull("HmisParameter"))
						  .add(Restrictions.ne("HmisId","")).add(Restrictions.ne("HmisParameter",""))
						  .addOrder(Order.asc("Id"));
			
			hmisParameters = cr.list();

			Criteria crforRettrive = session
					.createCriteria(HmisHospitalReport.class)
					.createAlias("Parameter", "par")
					.createAlias("Hospital", "hos")
					.add(Restrictions.in("Parameter", hmisParameters))
					.add(Restrictions.eq("ReportMonth", month))
					.add(Restrictions.eq("ReportYear", year))
					.add(Restrictions.eq("hos.Id", hospitalId))
					.addOrder(Order.asc("Id"));

			list = crforRettrive.list();

			if (list != null && list.size() > 0) {
				for (HmisHospitalReport hmisHospitalReport : list) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();

					pojoForHmisParameter.setHmisHospitalReport(hmisHospitalReport);
					queryForStockDistributed.setParameter("parameterId", hmisHospitalReport.getParameter().getId()); 
					queryForStockDistributed.setParameter("month", month);
					queryForStockDistributed.setParameter("hospitalId", hospitalId);
					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter.setCountOfStockDistributed(((BigDecimal) listForQuery.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId", hmisHospitalReport.getParameter().getId()); 
					queryForTotalStock.setParameter("hospitalId", hospitalId);
					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter.setCountOfTotalStock(((BigDecimal) listForQuery.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId", hmisHospitalReport.getParameter().getId()); 
					queryForStockRecieved.setParameter("month", month);
					queryForStockRecieved.setParameter("hospitalId", hospitalId);
					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter.setCountOfstockReceived(((BigDecimal) listForQuery.get(0)).intValue());

					pojoForHmisParameter.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter.getCountOfTotalStock()
										- (pojoForHmisParameter.getCountOfstockReceived() + pojoForHmisParameter.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);
				}
			} else if (hmisParameters != null && hmisParameters.size() > 0) {
				for (MasPhReportsParameters hmisParameter : hmisParameters) {
					ChildPojoForHmisParameter pojoForHmisParameter = new ChildPojoForHmisParameter();
					pojoForHmisParameter.setMasPhReportsParameters(hmisParameter);

					queryForStockDistributed.setParameter("parameterId", hmisParameter.getId()); 
					queryForStockDistributed.setParameter("month", month);
					queryForStockDistributed.setParameter("hospitalId", hospitalId);
					listForQuery = queryForStockDistributed.list();
					pojoForHmisParameter.setCountOfStockDistributed(((BigDecimal) listForQuery.get(0)).intValue());

					queryForTotalStock.setParameter("parameterId", hmisParameter.getId()); 
					queryForTotalStock.setParameter("hospitalId", hospitalId);
					listForQuery = queryForTotalStock.list();
					pojoForHmisParameter.setCountOfTotalStock(((BigDecimal) listForQuery.get(0)).intValue());

					queryForStockRecieved.setParameter("parameterId", hmisParameter.getId()); 
					queryForStockRecieved.setParameter("month", month);
					queryForStockRecieved.setParameter("hospitalId", hospitalId);
					listForQuery = queryForStockRecieved.list();
					pojoForHmisParameter.setCountOfstockReceived(((BigDecimal) listForQuery.get(0)).intValue());

					pojoForHmisParameter.setCountOfBalanceOfPreviousMonth(pojoForHmisParameter.getCountOfTotalStock()
										- (pojoForHmisParameter.getCountOfstockReceived() + pojoForHmisParameter.getCountOfStockDistributed()));

					hmisParametersList.add(pojoForHmisParameter);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("list", list);
		map.put("hmisParameters", hmisParameters);
		map.put("hmisParametersList", hmisParametersList);
		return map;
	}

	@Override
	public Map<String, Object> getHMISHospitalCountFromDatabase(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> countList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		HibernateTemplate hbt = getHibernateTemplate();
		int currentMonth = 0;
		int districtID = 0;
		String fromDate = null;
		String toDate = null;
		int hospitalId = box.getInt("hospitalId");
		Calendar calendar = Calendar.getInstance();

		if (box.getInt("month") != 0) {
			currentMonth = box.getInt("month");
		} else {
			currentMonth = box.getInt("currentMonth");
		}
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (currentMonth != 0)
			calendar.set(Calendar.MONTH, currentMonth - 1);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date sDate = calendar.getTime();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date eDate = calendar.getTime();
		String startDate = sdf.format(sDate);
		String endDate = sdf.format(eDate);

		try {
			MasHospital hospital = hbt.load(MasHospital.class, hospitalId);
			districtID = hospital.getDistrict().getId();

			String queryCount = "select "
					+

					"(select count(*) as t1 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  "
					+ "    where district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+ ",(select count((current_date - date_of_birth)/365) as t2 from ph_anc_survey pas "
					+ "left outer join ph_member_survey  pms on pas.member_id=pms.member_id  left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id "
					+ " where ((current_date - date_of_birth)/365) < 19  and district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					" ,(select count(*) as t3 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where lower(jsy_flag) =lower('Yes') and district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+ ",(select count(*) as t4 from (select count(*) as cnt from ph_anc_followup  anc left outer join ph_anc_survey  anf on anc.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=anf.hospital_id  where mh.district_id="
					+ districtID + " and anc.hospital_id=" + hospitalId
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' group by  anc.anc_reg_id having count(*)>3) t1 )  "
					+

					",(select count(*) as t5 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID + " and anf.hospital_id=" + hospitalId
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and tt1 is not null ) "
					+

					",(select count(*) as t6 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID + " and anf.hospital_id=" + hospitalId
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and  tt2 is not null ) "
					+

					",(select count(*) as t7 from ph_anc_followup  anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID + " and anf.hospital_id=" + hospitalId
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('100')) "
					+

					",(select count(*) as t8 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
					+ districtID + " and anf.hospital_id=" + hospitalId
					+ " and followup_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and iron_folic_qty  in ('200') ) "
					+

					",(select count(*) as t9 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID + " and pbr.hospital_id=" + hospitalId
					+ "  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and delivery_place ='Home' )  "
					+

					",(select count(*) as t10 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID + " and pat.hospital_id=" + hospitalId
					+ " and attended_by  in ('Doctor')  and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t11  from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID + " and pat.hospital_id=" + hospitalId
					+ " and attended_by in('Trained birth Attendant') and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t12 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
					+ districtID + " and pat.hospital_id=" + hospitalId
					+ "    and attended_by in('Trained birth Attendant','Doctor','Specialist Doctor','Untrained birth Attendant')  and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t13 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
					+ districtID + " and pbr.hospital_id=" + hospitalId
					+ " and delivery_place ='Government Hospital' and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t14 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='PHC' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID + " and ptm.hospital_id=" + hospitalId
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t15 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='CHC' and ptm.delivery_type = 'C-Section(LSCS)' and  mh.district_id="
					+ districtID + " and ptm.hospital_id=" + hospitalId
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",( select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where mt.hospital_type_code='DH' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID + " and ptm.hospital_id=" + hospitalId
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t17 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and patm.hospital_id=" + hospitalId
					+ " and delivery_out_come='Live Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t18 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and patm.hospital_id=" + hospitalId
					+ " and delivery_out_come='Live Birth' and gender_id = 3 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t19 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and patm.hospital_id=" + hospitalId
					+ " and delivery_out_come='Live Birth' and gender_id = 2 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t20 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and patm.hospital_id=" + hospitalId
					+ " and delivery_out_come='Still Birth' and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' )"
					+

					",(select count(*) as t21 from ph_anc_survey pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and abortions in('1','2','3','4','5','6','7','8','9','10') and reg_date  between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' ) "
					+

					",(select count(*) as t22 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and reg_type ='birth' and birth_weigth is not null  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t23 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pas.hospital_id=" + hospitalId
					+ " and reg_type ='birth' and birth_weigth < 2.50  and reg_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')  "
					+

					",(select count(*) as t24 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pntm.hospital_id=" + hospitalId
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '84' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select count(*) as t25 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pntm.hospital_id=" + hospitalId
					+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '86' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t26 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pntm.hospital_id=" + hospitalId
					+ " and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "') "
					+

					",(select count(*) as t27 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
					+ districtID + " and pntm.hospital_id=" + hospitalId
					+ " and termination_type='mtp' and anf.refer_to_type = 0 and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+

					",(select district_name as disName from mas_district where district_id  ="
					+ districtID
					+ ")"
					+ ",(select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where  ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
					+ districtID + " and ptm.hospital_id=" + hospitalId
					+ " and termination_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 27-04-2016
					",(select count(*) as t30 from ph_anc_followup paf where (hb < 7.00 or hb = 7.00) and paf.hospital_id=" + hospitalId
					+ " and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(*) as t31 from ph_anc_followup paf where (hb < 11.00 or hb = 11.00) and paf.hospital_id=" + hospitalId
					+ " and followup_date between  '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+
					// start of queries by amit das on 25-08-2016
					",(select count(opd_antenatal_card_id) as t32 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID + " and oac.hospital_id=" + hospitalId
					+ " and tetanus_onest_dose_date between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "')"
					+ ",(select count(opd_antenatal_card_id) as t33 from opd_antenatal_card oac left join  mas_hospital mh on mh.hospital_id=oac.hospital_id  where mh.district_id="
					+ districtID + " and oac.hospital_id=" + hospitalId
					+ " and tetanus_twond_dose_date between '"
					+ startDate + "' and '" + endDate + "')";
			countList = session.createSQLQuery(queryCount).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("countList", countList);

		return map;
	}

	@Override
	public Map<String, Object> submitHmisHospitalReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");
		int districtId = box.getInt("districtId");
		int parameterId = 0; 
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		MasPhReportsParameters masPhReportsParameters = null;
		Transaction tx = null;
		boolean saved = false;
		try {
			
			for (int i = 1; i < box.getInt("counter"); i++) {
				int toSet = 0 ;
				int toSetActual = 0;
				if (box.getString("hmisCount" + i) != null && !box.getString("hmisCount" + i).equals("")) {
					toSet = Integer.parseInt(box.getString("hmisCount" + i).toString());
				}
				if (box.getString("ahmisCount" + i) != null	&& !box.getString("ahmisCount" + i).equals("")) {
					toSetActual = Integer.parseInt(box.getString("ahmisCount" + i).toString());
				}
				if (box.getString("parameterId" + i) != null && !box.getString("parameterId" + i).equals("")) {
					parameterId = Integer.parseInt(box.getString("parameterId" + i).toString());
					masPhReportsParameters = new MasPhReportsParameters();
					masPhReportsParameters.setId(parameterId);
				}
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);

				HmisHospitalReport hospitalReport = new HmisHospitalReport();
				hospitalReport.setHospitalActual(toSetActual);
				hospitalReport.setHospitalModify(toSet);
				hospitalReport.setReportMonth(box.getInt("months"));
				hospitalReport.setReportYear(box.getInt("year"));
				hospitalReport.setParameter(masPhReportsParameters);
				hospitalReport.setHospital(masHospital);
				hospitalReport.setDistrict(masDistrict);
				

				hbt.save(hospitalReport);
				saved = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> updateHmisHospitalReportData(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = box.getInt("hospitalId");

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();
		Transaction tx = null;
		boolean saved = false;
		try {
			tx = session.beginTransaction();

			for (int i = 1; i < box.getInt("counter"); i++) {
				if (box.getString("hmisCount" + i) != null && !box.getString("hmisCount" + i).equals("")) {
					int toSet = Integer.parseInt(box.getString("hmisCount" + i).toString());
					int reptId = box.getInt("hmis" + i);
					
					HmisHospitalReport hospitalReport = hbt.load(HmisHospitalReport.class, reptId);
					if (reptId != 0) {
						hospitalReport.setHospitalModify(toSet);
						hbt.update(hospitalReport);
					}
						saved = true;
					}
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		map.put("saved", saved);
		return map;
	}

	@Override
	public Map<String, Object> createHmisHospitalExcelList(Box box) {

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Object[]> hmisDistrictReportList = new ArrayList<Object[]>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int districtId = 0;
		int chcphcId = 0;
		int hospitalId = 0;
		String facilityName ="";
		if (box.get("district") != null && !(box.get("district").equals("0"))) {
			districtId = box.getInt("district");
			MasHospital hospital = hbt.load(MasHospital.class, box.getInt("hospitalId"));
			facilityName = hospital.getDistrict().getDistrictName();
			map.put("facilityName", facilityName);
		}
		if (box.get("chcphc") != null && !(box.get("chcphc").equals("0"))) {
			chcphcId = box.getInt("chcphc");
			facilityName = getHospitalName(chcphcId);
			map.put("facilityName", facilityName);
		}
		if (box.get("base") != null && !box.get("base").equals("0") && !box.get("base").equals("")) {
			hospitalId = box.getInt("base");
			facilityName = getHospitalName(hospitalId);
			map.put("facilityName", facilityName);
		}
		int fromMonth = Integer.parseInt("" + box.get("fromMonth").toString());
		int toMonth = Integer.parseInt("" + box.get("toMonth").toString());
		int year = Integer.parseInt("" + box.get("year").toString());

		Criteria cr = session
				.createCriteria(HmisHospitalReport.class)
				.createAlias("Parameter", "reportParm")
				.createAlias("Hospital", "hos")
				.add(Restrictions.between("ReportMonth", fromMonth, toMonth))
				.add(Restrictions.eq("ReportYear", year))
				.addOrder(Order.asc("reportParm.Id"))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections.property("reportParm.HmisId"))
								.add(Projections.property("reportParm.HmisParameter"))
								.add(Projections.sum("HospitalModify"))
								.add(Projections.groupProperty("reportParm.Id"))
								.add(Projections.groupProperty("reportParm.HmisId"))
								.add(Projections.groupProperty("reportParm.HmisParameter")));
				if(districtId != 0) {
					cr.add(Restrictions.eq("District.Id", districtId));
				}
				if(chcphcId != 0) {
					cr.add(Restrictions.eq("hos.ParentInstitute.Id", chcphcId));
				}
				if(hospitalId != 0) {
					cr.add(Restrictions.eq("hos.Id", hospitalId));
				}
		
		hmisDistrictReportList = cr.list();

		map.put("hmisDistrictReportList", hmisDistrictReportList);
		return map;

	}
	
	/* 
	 * This Method is used to get the record for survey graph.
	 * Added By Om Tripathi 18/10/2017 
	 * 
	 */
	@Override
	public Map<String,Integer> publicHealthPieChart(Box box, List<MasHospital> basicSubList) {
		HibernateTemplate hbt = getHibernateTemplate();
		Session session = hbt.getSessionFactory().getCurrentSession();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Map<String,Integer> map = new HashMap<String,Integer>();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File(resourcePath.getFile())));
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		int healthBlock = Integer.parseInt(prop.getProperty("healthBlockId"));
		String houseSurveyDone = prop.getProperty("houseSurveyDone");
		String houseSurveyTarget = prop.getProperty("houseSurveyTarget");
		String memberSurveyDone = prop.getProperty("memberSurveyDone");
		String memberSurveyTarget = prop.getProperty("memberSurveyTarget");
		
		int hospitalIds =0;
		int userType = 0;
		int districtId = 0;
		if(box.getInt("districtId")!=0){
			districtId= box.getInt("districtId");
		}
		if(box.getInt("userType")!=0){
			userType= box.getInt("userType");
		}
		if(box.getInt("hospitalIds")!=0){
			hospitalIds= box.getInt("hospitalIds");
		}
		String instName=null;
		if(box.getString("instName")!=null){
			instName= box.getString("instName");
		}
		int instType=0;
		if(box.getInt("instType")!=0){
			instType= box.getInt("instType");
		}
		String SurveyGraph=null;
		if(box.getString("SurveyGraph")!=null){
			SurveyGraph= box.getString("SurveyGraph");
		}
		
		int base=0;
		if(box.getInt("base")!=0){
			base= box.getInt("base");
		}
		int healthBlockId=0;
		if(box.getInt("healthBlockId")!=0){
			healthBlockId= box.getInt("healthBlockId");
		}
		int ListOfCenterId=0;
		if(box.getInt("ListOfCenterId")!=0){
			ListOfCenterId= box.getInt("ListOfCenterId");
		}
		int chcphc=0;
		if(box.getInt("chcphc")!=0){
			chcphc= box.getInt("chcphc");
		}
		Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("fromDate"));
		Date toDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString("toDate"));

		String fromDateMonth = box.getString("fromDate").split("/")[2] + "/"
				+ box.getString("fromDate").split("/")[1] + "/"
				+ box.getString("fromDate").split("/")[0];
		String toDateMonth = box.getString("toDate").split("/")[2] + "/"
				+ box.getString("toDate").split("/")[1] + "/"
				+ box.getString("toDate").split("/")[0];
		Map maps=new HashMap<>();
		try {
			if(districtId!=0 &&  instType!=0 && healthBlockId!=0 &&  chcphc!=0 &&  base!=0 &&  hospitalIds!=0 ){
				
				if(SurveyGraph.equalsIgnoreCase("HS")){
					if(basicSubList.size()>0){
						for(MasHospital masHospital:basicSubList){
							int hospitalId=masHospital.getId();
							String hospitalName = masHospital.getHospitalName();
							if(hospitalId==base){
							int Id=0;
							Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
									+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
									+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
									+ " and mh.district_id = " + districtId	
									//+ " and mh.hospital_type_id = " + instType
									+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlockId+"))"
									+ " and mh.hospital_id=" + base
									).uniqueResult())).intValue();
							maps.put(hospitalName+ houseSurveyDone, Id);
							try {
							List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
										.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
										.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
										.add(Restrictions.eq("dis.Id", districtId))//.add(Restrictions.eq("hosType.Id", instType)).add(Restrictions.eq("hos.Id", hospitalIds))
										.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", base))
										.add(Restrictions.ge("FromDate", fromDate))
										.add(Restrictions.le("ToDate", toDate))
										.list();

									if (masSurveyTargets.size() > 0) {
										Long annualHStarget = 0l;
										for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
											try {
												annualHStarget += masSurveyTarget.getAnnualHouseSurveyTarget();
											} catch (Exception e) {
											}
											maps.put(hospitalName+ houseSurveyTarget,annualHStarget.intValue());
										}
									}

								} catch (Exception e) {
								}
							int target=0;int done=0;
							if(maps.get(hospitalName+ houseSurveyDone)!=null){
								done = (int)maps.get(hospitalName+ houseSurveyDone);
							}
							if(maps.get(hospitalName+ houseSurveyTarget)!=null){
								target = (int)maps.get(hospitalName+ houseSurveyTarget);
								target = target-done;
								if(target<0){
									target=0;
								}
							}
							
							map.put(hospitalName+ houseSurveyDone, done);
							map.put(hospitalName+ houseSurveyTarget, target);
							
							}
						}
					}
				}
				if(SurveyGraph.equalsIgnoreCase("MS")){
					if(basicSubList.size()>0){
						for(MasHospital masHospital:basicSubList){
							int hospitalId=masHospital.getId();
							String hospitalName = masHospital.getHospitalName();
							if(hospitalId==base){
							int Id=0;
							Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_member_survey phs "
									+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
									+ "where member_survey_date between '" + fromDate + "' and '" + toDate + "'"
									+ " and mh.district_id = " + districtId	
									//+ " and mh.hospital_type_id = " + instType
									+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlockId+"))"
									+ " and mh.hospital_id=" + base
									).uniqueResult())).intValue();
							maps.put(hospitalName+ memberSurveyDone, Id);
							try {
								List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
											.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
											.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
											.add(Restrictions.eq("dis.Id", districtId))//.add(Restrictions.eq("hosType.Id", instType)).add(Restrictions.eq("hos.Id", hospitalIds))
											.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", base))
											.add(Restrictions.ge("FromDate", fromDate))
										.add(Restrictions.le("ToDate", toDate)).list();

										if (masSurveyTargets.size() > 0) {
											Long annualMStarget = 0l;
											for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
												try {
													annualMStarget += masSurveyTarget.getAnnualMemberSurveyTarget();
												} catch (Exception e) {
												}
												maps.put(hospitalName+ memberSurveyTarget,annualMStarget.intValue());
											}
										}

									} catch (Exception e) {
									}
							int done=0;int target=0;
							if(maps.get(hospitalName+ memberSurveyDone)!=null){
								done = (int)maps.get(hospitalName+ memberSurveyDone);
							}
							if(maps.get(hospitalName+ memberSurveyTarget)!=null){
								target = (int)maps.get(hospitalName+ memberSurveyTarget);
								target = target-done;
								if(target<0){
									target=0;
								}
							}
							
							map.put(hospitalName+ memberSurveyDone, done);
							map.put(hospitalName+ memberSurveyTarget, target);
							
						}
					  }
					}
				}
			}
				
				else if(districtId !=0 &&instType!=0 && healthBlockId!=0 &&  chcphc!=0 && hospitalIds!=0){
					if(SurveyGraph.equalsIgnoreCase("HS")){
						List<MasSurveyTarget> masSurveyTargets=new ArrayList<MasSurveyTarget>();
						if(basicSubList.size()>0){
							for(MasHospital masHospital:basicSubList){
								int hospitalId=masHospital.getId();int Id=0;
								String hospitalName = masHospital.getHospitalName();
								String hospitalNameTarget = masHospital.getHospitalName();
								
								Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
										+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
										+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + districtId	
										//+ " and mh.hospital_type_id = " + instType
										+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlockId+"))"
										+ " and mh.parent_institute_id=" + chcphc
										+ " and mh.hospital_id=" + hospitalId
										).uniqueResult())).intValue();
								map.put(hospitalName+houseSurveyDone, Id);
								try {
									 masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
												.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
												.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
												.add(Restrictions.eq("dis.Id", districtId))
												.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", hospitalId))
												.add(Restrictions.ge("FromDate", fromDate))
												.add(Restrictions.le("ToDate", toDate))
												.list();

											if (masSurveyTargets.size() > 0) {
												Long annualMStarget = 0l;
												for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
													try {
														annualMStarget += masSurveyTarget
																.getAnnualHouseSurveyTarget();
													} catch (Exception e) {
													}
													map.put(hospitalNameTarget+houseSurveyTarget,annualMStarget.intValue());
												}
											}

										} catch (Exception e) {
										}
							}
						}
						
					}
					if(SurveyGraph.equalsIgnoreCase("MS")){
						List<MasSurveyTarget> masSurveyTargets=new ArrayList<MasSurveyTarget>();
						if(basicSubList.size()>0){
							for(MasHospital masHospital:basicSubList){
								int hospitalId=masHospital.getId();int Id=0;
								String hospitalName = masHospital.getHospitalName();
								
								
								Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_member_survey phs "
										+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
										+ "where member_survey_date between '" + fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + districtId	
										//+ " and mh.hospital_type_id = " + instType
										+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+healthBlockId+"))"
										+ " and mh.parent_institute_id=" + chcphc
										+ " and mh.hospital_id=" + hospitalId
										).uniqueResult())).intValue();
								map.put(hospitalName+ memberSurveyDone, Id);
								
								try {
									masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
												.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
												.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
												.add(Restrictions.eq("dis.Id", districtId))
												.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", hospitalId)) //.add(Restrictions.eq("BSCI.Id", hospitalId))
												.add(Restrictions.ge("FromDate", fromDate))
												.add(Restrictions.le("ToDate", toDate)).list();
											if (masSurveyTargets.size() > 0) {
												Long annualMStarget = 0l;
												for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
													try {
														annualMStarget += masSurveyTarget.getAnnualMemberSurveyTarget();
													} catch (Exception e) {
													}
													map.put(hospitalName+memberSurveyTarget ,annualMStarget.intValue());
												}
											}

										} catch (Exception e) {
										}
							}
						}
						}
				}
				
				else if(districtId !=0 &&instType!=0 && healthBlockId!=0 &&  hospitalIds!=0){
					int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));
					
					if(SurveyGraph.equalsIgnoreCase("HS")){
						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
							if(healthBlockList.size()>0){int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName();
									hospitalId = masHospital.getId();
									if(hospitalId==healthBlockId){
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										maps.put(hospitalName+ houseSurveyDone, Id);
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", healthBlockId))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate))
														.list();

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualHouseSurveyTarget();
															} catch (Exception e) {
															}
															maps.put(hospitalName+ houseSurveyTarget,annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
										int done=0;int target=0;
										if(maps.get(hospitalName+ houseSurveyDone)!=null){
											done = (int)maps.get(hospitalName+ houseSurveyDone);
										}
										if(maps.get(hospitalName+ houseSurveyTarget)!=null){
											target = (int)maps.get(hospitalName+ houseSurveyTarget);
											target = target-done;
											if(target<0){
												target=0;
											}
										}
										
										map.put(hospitalName+ houseSurveyDone, done);
										map.put(hospitalName+ houseSurveyTarget, target);
										map.put("chart", 1);
								}
							}
							}
						}catch(Exception e){
						}
							
					}
					else if(SurveyGraph.equalsIgnoreCase("MS")){
						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
							if(healthBlockList.size()>0){int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName();
									hospitalId = masHospital.getId();
									if(hospitalId==healthBlockId){
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_member_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where member_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										maps.put(hospitalName+ memberSurveyDone, Id);
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", healthBlockId))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate))
														.list();

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualMemberSurveyTarget();
															} catch (Exception e) {
															}
															maps.put(hospitalName	+ memberSurveyTarget,	annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
										int done=0;int target=0;
										if(maps.get(hospitalName+ memberSurveyDone)!=null){
											done = (int)maps.get(hospitalName+ memberSurveyDone);
										}
										if(maps.get(hospitalName+ memberSurveyTarget)!=null){
											target = (int)maps.get(hospitalName+ memberSurveyTarget);
											target = target-done;
											if(target<0){
												target=0;
											}
										}
										
										map.put(hospitalName+ memberSurveyDone, done);
										map.put(hospitalName+ memberSurveyTarget, target);
										
								}	
							}		
							}
						}catch(Exception e){
						}    
							 
					}
				
				}
				
				else if(districtId !=0 &&instType!=0 && hospitalIds!=0){
					
					if(SurveyGraph.equalsIgnoreCase("HS")){
						int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));

						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
							if(healthBlockList.size()>0){int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName();
									hospitalId = masHospital.getId();
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										map.put(hospitalName+ houseSurveyDone, Id);
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", hospitalId))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate))
														.list(); 

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualHouseSurveyTarget();
															} catch (Exception e) {
															}
															map.put(hospitalName+ houseSurveyTarget,annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
								}	
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					else if(SurveyGraph.equalsIgnoreCase("MS")){
						int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));
						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	
									session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
						
							if(healthBlockList.size()>0){
								int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName(); 
									hospitalId = masHospital.getId();
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_member_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where member_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										map.put(hospitalName+ memberSurveyDone, Id);
										
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", hospitalId))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate))
														//+ " and mh.hospital_type_id = " + instType
														.list();

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualMemberSurveyTarget();
															} catch (Exception e) {
															}
															map.put(hospitalName	+ memberSurveyTarget,annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
								}
								}	
							}catch(Exception e){
							}
														
					}
			
				}
				
				else if(districtId !=0 && hospitalIds!=0){
					
					if(SurveyGraph.equalsIgnoreCase("HS")){
						int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));

						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
							if(healthBlockList.size()>0){int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName().replaceAll("\\s+","");
									hospitalId = masHospital.getId();
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										map.put(hospitalName+houseSurveyDone, Id);
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", base))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate)).list();

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualHouseSurveyTarget();
															} catch (Exception e) {
															}
															map.put(hospitalName+ houseSurveyTarget,annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
								}	
							}
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						
					}
					else if(SurveyGraph.equalsIgnoreCase("MS")){
						int healthBlockIds = Integer.parseInt(prop.getProperty("healthBlockId"));
						try {
							String hospitalName=null;int hospitalId=0;
							List<MasHospital> healthBlockList =(List<MasHospital>)	
									session.createCriteria(MasHospital.class,"mashos")
								.createAlias("mashos.District", "dist")
								.createAlias("mashos.ParentInstitute", "parent")
								.createAlias("mashos.HospitalType", "hosType")
								.add(Restrictions.eq("hosType.Id", new Integer(healthBlockIds)))
								.add(Restrictions.eq("dist.Id", new Integer(districtId)))
								.list();
						
							if(healthBlockList.size()>0){
								int Id=0;
								for(MasHospital masHospital:healthBlockList){
									hospitalName = masHospital.getHospitalName(); 
									hospitalId = masHospital.getId();
										Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_member_survey phs "
												+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
												+ "where member_survey_date between '" + fromDate + "' and '" + toDate + "'"
												+ " and mh.district_id = " + districtId	
												//+ " and mh.hospital_type_id = " + instType
												+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="+hospitalId+"))"
												).uniqueResult())).intValue();
										map.put(hospitalName+ memberSurveyDone, Id);
										
										try {
											List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
														.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
														.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
														.add(Restrictions.eq("dis.Id", districtId))
														.add(Restrictions.eq("hb.Id", healthBlockId)).add(Restrictions.eq("CI.Id", chcphc)).add(Restrictions.eq("BSCI.Id", base))
														.add(Restrictions.ge("FromDate", fromDate))
														.add(Restrictions.le("ToDate", toDate)).list();

													if (masSurveyTargets.size() > 0) {
														Long annualMStarget = 0l;
														for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
															try {
																annualMStarget += masSurveyTarget
																		.getAnnualMemberSurveyTarget();
															} catch (Exception e) {
															}
															map.put(hospitalName	+ memberSurveyTarget,annualMStarget.intValue());
														}
													}

												} catch (Exception e) {
												}
								}
								}	
							}catch(Exception e){
							}
														
					}
			
				}
				
				else if(districtId ==0 && hospitalIds!=0){

					
					if(SurveyGraph.equalsIgnoreCase("HS")){
						String distName=null;int distId=0;
						int stateId = Integer.parseInt(prop.getProperty("stateId"));
						List<MasDistrict> masDistrict = session.createCriteria(MasDistrict.class)
								.add(Restrictions.eq("State.Id", stateId))
								.add(Restrictions.eq("Status", "y").ignoreCase())
								.addOrder(Order.asc("DistrictCode")).list();
						int Id=0;	for(MasDistrict mDistrict:masDistrict){
							distName = mDistrict.getDistrictName();
							distId = mDistrict.getId();
							Id = ((BigInteger) (session.createSQLQuery("select count(*) from ph_house_survey phs "
									+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
									+ "where house_survey_date between '" + fromDate + "' and '" + toDate + "'"
									+ " and mh.district_id = " + distId
							).uniqueResult())).intValue(); map.put(distName+ houseSurveyDone, Id);
							
							try {
								List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
											.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
											.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
											.add(Restrictions.eq("dis.Id", distId))
											.add(Restrictions.ge("FromDate", fromDate))
											.add(Restrictions.le("ToDate", toDate))
											.list();

										if (masSurveyTargets.size() > 0) {
											Long annualMStarget = 0l;
											for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
												try {
													annualMStarget += masSurveyTarget
															.getAnnualHouseSurveyTarget();
												} catch (Exception e) {
												}
												map.put(distName+ houseSurveyTarget,annualMStarget.intValue());
											}
										}

									} catch (Exception e) {
									}
						}
						
						
						}
						if(SurveyGraph.equalsIgnoreCase("MS")){
							String distName=null;int distId=0;
							int stateId = Integer.parseInt(prop.getProperty("stateId"));
							List<MasDistrict> masDistrict = session.createCriteria(MasDistrict.class)
									.add(Restrictions.eq("State.Id", stateId))
									.add(Restrictions.eq("Status", "y").ignoreCase())
									.addOrder(Order.asc("DistrictCode")).list();
							int Id=0;	for(MasDistrict mDistrict:masDistrict){
								distName = mDistrict.getDistrictName();
								distId = mDistrict.getId();
								Id = ((BigInteger) session.createSQLQuery("select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '" + fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + distId
										).uniqueResult()).intValue();
								map.put(distName+ memberSurveyDone, Id);
							
								try {
									List<MasSurveyTarget> masSurveyTargets = session.createCriteria(MasSurveyTarget.class)
												.createAlias("Hospital", "hos").createAlias("DistrictSurvey", "dis").createAlias("HospitalType", "hosType")
												.createAlias("HealthBlock", "hb").createAlias("ChcInstitute", "CI").createAlias("BasicSubCenterInstitute", "BSCI")
												.add(Restrictions.eq("dis.Id", distId))
												.add(Restrictions.ge("FromDate", fromDate))
												.add(Restrictions.le("ToDate", toDate))
												.list();

											if (masSurveyTargets.size() > 0) {
												Long annualMStarget = 0l;
												for (MasSurveyTarget masSurveyTarget : masSurveyTargets) {
													try {
														annualMStarget += masSurveyTarget
																.getAnnualMemberSurveyTarget();
													} catch (Exception e) {
													}
													map.put(distName+ memberSurveyTarget,annualMStarget.intValue());
												}
											}

										} catch (Exception e) {
										}

							}
							}
				}
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return map;
	}
	
			// Added By Om Tripathi 04/10/2017 
			@Override
			public Map<String,String> addSupervisoryDashboardTarget(Box box) {
				Map<String,String> hospitalMap = new HashMap<String,String>();
				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				Session session=(Session)getSession();
				List<MasSurveyTarget>masSurveyList=new ArrayList<MasSurveyTarget>();
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				MasSurveyTarget masSurveyTargetList=new MasSurveyTarget();
				try{
					
				
				int userId=0;
				if(box.getInt("userId")!=0){
					userId=box.getInt("userId");
				}
				long memberSurveyTarget=0;
				if(box.getLong("memberSurveyTarget")!=0){
					memberSurveyTarget =box.getLong("memberSurveyTarget");
					
				}
				long houseSurveyTarget=0;
				if(box.getLong("houseSurveyTarget")!=0){
					houseSurveyTarget = box.getLong("houseSurveyTarget");
					
				}
				String instName=null;
				if(box.getString("instName")!=null){
					instName = box.getString("instName");
					
				}
				int instType=0;
				if(box.getInt("instType")!=0){
					instType = box.getInt("instType");
					
				}
				int annualhstarget=0;
				if(box.getInt("annualhstarget")!=0){
					annualhstarget = (Integer)box.getInt("annualhstarget");
				}
				
				String Status=null;
				if(box.getString("Status")!=null){
					Status = (String)box.getString("Status");
				}
				int annualhouseVisitTarget=0;
				if(box.getInt("annualhouseVisitTarget")!=0){
					annualhouseVisitTarget = box.getInt("annualhouseVisitTarget");
				}
				
				int userType=0;
				if(box.getInt("userType")!=0){
					userType = (Integer)box.getInt("userType");
				}
				int hospitalId=0;
				if(box.getInt("hospitalId")!=0){
					hospitalId = (Integer)box.getInt("hospitalId");
				}
				int districtId=0;
				if(box.getInt("districtId")!=0){
					districtId = (Integer)box.getInt("districtId");
				}
				
				String verified="N";
				if(box.getString("verified")!="Y" && box.getString("verified")!="" ){
					verified = box.getString("verified");
				}
				String remarks=null;
				if(box.getString("remarks")!=null){
					remarks = box.getString("remarks");
				}
				
				int targetId=0;
				if(box.getString("targetIds")!=null){
					targetId = box.getInt("targetIds");
				}
				
				String houseSurveyFromDate=null;
				if(box.getString("houseSurveyFromDate")!=null){
					houseSurveyFromDate = box.getString("houseSurveyFromDate");
				}
				String houseSurveyTodate=null;
				if(box.getString("houseSurveyTodate")!=null){
					houseSurveyTodate = box.getString("houseSurveyTodate");
				}
				String memberSurveyFromDate=null;
				if(box.getString("memberSurveyFromDate")!=null){
					memberSurveyFromDate = box.getString("memberSurveyFromDate");
				}
				String memberSurveyToDate=null;
				if(box.getString("memberSurveyToDate")!=null){
					memberSurveyToDate = box.getString("memberSurveyToDate");
				}
				String housevisitToDate=null;
				if(box.getString("housevisitToDate")!=null){
					housevisitToDate = box.getString("housevisitToDate");
				}
				String housevisitFromDate=null;
				if(box.getString("housevisitFromDate")!=null){
					housevisitFromDate = box.getString("housevisitFromDate");
				}
				int healthBlock=0;
				if(box.getInt("healthBlock")!=0){
					healthBlock = box.getInt("healthBlock");
				}
				int chcphc=0;
				if(box.getInt("chcphc")!=0){
					chcphc = box.getInt("chcphc");
				}
				String ListOfCenter=null;
				if(box.getString("ListOfCenter")!=null){
					ListOfCenter = box.getString("ListOfCenter");
				}
				int base=0;
				if(box.getInt("base")!=0){
					base = box.getInt("base");
				}
				
				String message="";
				Users user=new Users();
				user.setId(userId);
				masSurveyTargetList.setCreatedBy(user);
				/*BigInteger bigInts = (BigInteger) (session.createSQLQuery("select  count(*) from ph_member_survey phms  left outer join ph_house_survey phs on phms.house_id=phs.house_hold_id where phs.survey_id between (select survey_id from ph_house_survey  order BY  survey_id asc offset 0 Rows fetch next 1 rows only) and (select t.survey_id from ( select *, row_number() OVER(ORDER BY survey_id asc) as row from ph_house_survey ) t where t.row =:RowNumber)")
						.setInteger("RowNumber",annualhstarget).uniqueResult());
				Long msTargetCount=bigInts.longValue();
				System.out.println("bigInts"+msTargetCount);*/
				masSurveyTargetList.setAnnualHouseSurveyTarget(houseSurveyTarget);
				masSurveyTargetList.setAnnualMemberSurveyTarget(new Long(memberSurveyTarget));
				masSurveyTargetList.setCreateDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				user.setId(userId);		
				masSurveyTargetList.setCreatedBy(user);
				MasDistrict masDistrict= new MasDistrict();
				masDistrict.setId(districtId);
				masSurveyTargetList.setDistrictSurvey(masDistrict);
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				masSurveyTargetList.setHospital(masHospital);
				masSurveyTargetList.setFromDate(HMSUtil.convertStringTypeDateToDateType(houseSurveyFromDate));
				masSurveyTargetList.setToDate(HMSUtil.convertStringTypeDateToDateType(houseSurveyTodate));
				
				
				if(healthBlock!=0){
				MasHospital mHospital=new MasHospital();
				mHospital.setId(healthBlock);
				masSurveyTargetList.setHealthBlock(mHospital);
				}
				if(chcphc!=0){
				MasHospital masHospitals=new MasHospital();
				masHospitals.setId(chcphc);
				masSurveyTargetList.setChcInstitute(masHospitals);
				}
				if(base!=0){
				MasHospital basicCenter=new MasHospital();
				basicCenter.setId(base);
				masSurveyTargetList.setBasicSubCenterInstitute(basicCenter);
				}
				if(instType!=0){
					MasHospitalType masHospitalType= new MasHospitalType();
					masHospitalType.setId(instType);
					masSurveyTargetList.setHospitalType(masHospitalType);
				}
				masSurveyTargetList.setBasicSectionSubCenterName(ListOfCenter);
				masSurveyTargetList.setAnnualHouseVisitCount(new Long(annualhouseVisitTarget));
				masSurveyTargetList.setShortName(instName);
				masSurveyTargetList.setRemarks(remarks);
				masSurveyTargetList.setStatus(Status);
				
				masSurveyTargetList.setUpdateDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				masSurveyTargetList.setUpdatedBy(user);
				targetId=(Integer) hbt.save(masSurveyTargetList);
				
				hospitalMap.put("message", message);
			}catch(Exception e){
				e.printStackTrace();
			}
				return hospitalMap;
			}
			
			//Added By Om Tripathi 30/10/2017
			@Override
			public List<Object[]> getHospitalListForTemplateApplication(int districtId) {
				List<Object[]> hospitalList = new ArrayList<Object[]>();
				
				Session session = (Session) getSession();
				
				hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("District.Id", districtId))
						.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("HospitalName")).add(Projections.property("ShortName"))).addOrder(Order.asc("HospitalName")).list();

				
				return hospitalList;
			}
			//Added By Om Tripathi 30/10/2017
			@Override
			public List<MasHospitalType> getHospitalTypeListForPH() {
				List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
				mhospitalTypetList = getHibernateTemplate()
						.find("from jkt.hms.masters.business.MasHospitalType as isc where UPPER(isc.Status) = 'Y' and isc.HospitalTypeCode in ('115','101','102','109')  order by HospitalTypeName asc");
				return mhospitalTypetList;
			}
			
			//Added By Om Tripathi 30/10/2017
			@Override
			public Map<String, Object> gethealthblocklist(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasHospital> healthBlock = new ArrayList<MasHospital>();
				Session session = (Session) getSession();
				Vector dist = box.getVector("district");
				int district = 0;
				int hospitalId=0;
				int healthBlocksId=0;
				if(box.getInt("hospitalId")!=0){
					hospitalId =box.getInt("hospitalId");
				}
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				Properties prop = new Properties();
				try {
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				int healthBlockId = Integer.parseInt(prop.getProperty("healthBlockId"));

				try {
						//district = Integer.parseInt(dist.get(1).toString().trim());
						district =  box.getInt("district");
						
						healthBlock=session.createCriteria(MasHospital.class,"mashos")
						.createAlias("mashos.District", "dist")
						.createAlias("mashos.ParentInstitute", "parent")
						.createAlias("mashos.HospitalType", "hosType")
						.add(Restrictions.eq("hosType.Id", new Integer(healthBlockId)))
						.add(Restrictions.eq("dist.Id", new Integer(district)))
						.list();
						
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String querys= "select hospital_id from mas_hospital where hospital_id in (select parent_institute_id from mas_hospital where hospital_id =:hospitalId)";
					Query quer=session.createSQLQuery(querys);
					quer.setParameter("hospitalId", hospitalId);
					
					if(quer.list().size()> 0){
						healthBlocksId = (int) quer.list().get(0);
					}
					
					
				} catch (Exception e) {
				}
				map.put("healthBlock", healthBlock);
				map.put("healthBlocksId", healthBlocksId);
				return map;

			}
			
			//Added By Om Tripathi 30/10/2017
			@Override
			public Map<String, Object> getPhcChclist(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<MasHospital> chcList = new ArrayList<MasHospital>();
				List<MasHospital> phcList = new ArrayList<MasHospital>();
				List<MasHospital> ppunit = new ArrayList<MasHospital>();
				List<MasHospital> chcs = new ArrayList<MasHospital>();
				List<MasHospital> phcs = new ArrayList<MasHospital>();
				List<MasHospital> ppus = new ArrayList<MasHospital>();
				int chcphc=0;
				Session session = (Session) getSession();
				String[] phc = { "PHC", "24x7 PHC" };
				
				int district = 0;
				if(box.getInt("district")!=0){
					district=box.getInt("district");
				}
				int healthblock=0;
				if(box.getInt("healthblock")!=0){
					healthblock=box.getInt("healthblock");
				}
				int listOfCenterId=0;
				if(box.getInt("listOfCenterId")!=0){
					listOfCenterId=box.getInt("listOfCenterId");
				}
				int hospitalId=0;
				if(box.getInt("hospitalId")!=0){
					hospitalId=box.getInt("hospitalId");
				}
				try { 
					if(listOfCenterId==0){
					
				}else if(listOfCenterId==1){
					
					chcList = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.eq(
									"SubCentre.InstituteTypeShortName", "CHC"))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					
					chcs = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.eq(
									"SubCentre.InstituteTypeShortName", "CHC"))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Id", hospitalId))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					
					if (chcs.size()>0) {
						chcphc=chcs.get(0).getId();
					}
				}
				else if(listOfCenterId==2){
					
					phcList = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.in(
									"SubCentre.InstituteTypeShortName", phc))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					
					phcs = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.in(
									"SubCentre.InstituteTypeShortName", phc))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Id", hospitalId))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					if (phcs.size()>0) {
						chcphc=phcs.get(0).getId();
					}
				}
				else if(listOfCenterId==3){

					ppunit = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.eq(
									"SubCentre.InstituteTypeShortName", "PPU"))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					
					ppus = session
							.createCriteria(MasHospital.class)
							.createAlias("HospitalType", "SubCentre")
							.add(Restrictions.eq(
									"SubCentre.InstituteTypeShortName", "PPU"))
							.createAlias("District", "dis")
							.add(Restrictions.eq("dis.Id", district))
							.add(Restrictions.eq("ParentInstitute.Id", healthblock))
							.add(Restrictions.eq("Id", hospitalId))
							.add(Restrictions.eq("Status", "y").ignoreCase())
							.list();
					if (ppus.size()>0) {
						chcphc=ppus.get(0).getId();
					}
				}

				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("ppunit", ppunit);
				map.put("chcList", chcList);
				map.put("phcList", phcList);
				map.put("chcphc", chcphc);
				
				return map;

			}
			
			@Override
			public Map<String, Object> showDashboardTargetDetails(Box box) {
				Map<String, Object> map = new HashMap<String, Object>();
				Session session = (Session) getSession();
				List<MasSurveyTarget> masSurveyTargets=new ArrayList<MasSurveyTarget>();
				List<MasSurveyTargetStatus> masSurveyTargetStatus=new ArrayList<MasSurveyTargetStatus>();

				int dayBlockMonthlyCount=0;
				int dayBlockCount=0;
				String query = "";
				
				int countHouse = 0;
				int memberCount = 0;
				int phcCount = 0;

				Boolean successfullSends = false;
				int hospitalIds =0;
				int userType = 0;
				int districtId = 0;

				if(box.getInt("districtId")!=0){
					districtId= box.getInt("districtId");
				}
				if(box.getInt("userType")!=0){
					userType= box.getInt("userType");
				}
				if(box.getInt("hospitalIds")!=0){
					hospitalIds= box.getInt("hospitalIds");
				}
				String instName=null;
				if(box.getString("instName")!=null){
					instName= box.getString("instName");
				}
				int instType=0;
				if(box.getInt("instType") != 0 ) {
					instType = (int)box.getInt("instType");
				}
				int base=0;
				if(box.getInt("base")!=0){
					base= box.getInt("base");
				}
				int healthBlockId=0;
				if(box.getInt("healthBlockId")!=0){
					healthBlockId= box.getInt("healthBlockId");
				}
				int ListOfCenterId=0;
				if(box.getInt("ListOfCenterId")!=0){
					ListOfCenterId= box.getInt("ListOfCenterId");
				}
				int chcphc=0;
				if(box.getInt("chcphc")!=0){
					chcphc= box.getInt("chcphc");
				}
								
				Date fromDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString("fromDate"));
				Date toDate = HMSUtil.convertStringTypeDateToDateType(box
						.getString("toDate"));
				URL resourcePath = Thread.currentThread().getContextClassLoader()
						.getResource("adt.properties");
				Properties prop = new Properties();
				try {
					prop.load(new FileInputStream(new File(resourcePath.getFile())));
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				int healthBlock = Integer.parseInt(prop.getProperty("healthBlockId"));

		String qry = "select phs.house_hold_id, jjd.date_atp as atp_date, pdb.house_id ,pdb.for_day from ph_atp_jphn_jhi_details jjd "
				+ " left outer join   ph_atp_jphn_jhi_header  jjh on jjd.atp_header_id=jjh.atp_header_id "
				+ " left outer join ph_day_block  pdb on jjd.day_block_id=pdb.day_id left outer  join "
				+ "ph_day_block_detail dbd on dbd.day_id=pdb.day_id left outer join ph_house_survey phs "
				+ " on phs.survey_id=dbd.survey_id left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
				+ "where jjh.status=2 AND jjd.date_atp between '"
				+ fromDate
				+ "' and '" + toDate + "'";
				
				try {
			if (districtId != 0 && instType != 0 && healthBlockId != 0
					&& chcphc != 0 && base != 0 && hospitalIds != 0) {
				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = "
								+ districtId

								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
								+ healthBlockId
								+ "))"
								+ " and mh.hospital_id="
								+ base).uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate
										+ "' and '"
										+ toDate
										+ "'"
										+ " and mh.district_id = "
										+ districtId

										+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
										+ healthBlockId + "))"
										+ " and mh.hospital_id=" + base)
						.uniqueResult()).intValue();

				qry = qry
						+ " and mh.district_id = "
						+ districtId
						+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
						+ healthBlockId
						+ "))"

						+ " and mh.hospital_id="
						+ base
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.createAlias("HealthBlock", "hb")
						.createAlias("ChcInstitute", "CI")
						.createAlias("BasicSubCenterInstitute", "BSCI")
						.add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.eq("hb.Id", healthBlockId))
						.add(Restrictions.eq("CI.Id", chcphc))
						.add(Restrictions.eq("BSCI.Id", base))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}
			}
						
			else if (districtId != 0 && instType != 0 && healthBlockId != 0
					&& chcphc != 0 && hospitalIds != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = "
								+ districtId

								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
								+ healthBlockId
								+ "))"
								+ " and mh.parent_institute_id=" + chcphc)
						.uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate
										+ "' and '"
										+ toDate
										+ "'"
										+ " and mh.district_id = "
										+ districtId

										+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
										+ healthBlockId + "))"
										+ " and mh.parent_institute_id="
										+ chcphc).uniqueResult()).intValue();

				qry = qry
						+ " and mh.district_id = "
						+ districtId
						+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
						+ healthBlockId
						+ "))"
						+ " and mh.parent_institute_id="
						+ chcphc
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.createAlias("HealthBlock", "hb")
						.createAlias("ChcInstitute", "CI")
						.add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.eq("hb.Id", healthBlockId))
						.add(Restrictions.eq("CI.Id", chcphc))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}

			}
						
			else if (districtId != 0 && instType != 0 && healthBlockId != 0
					&& hospitalIds != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = "
								+ districtId

								+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
								+ healthBlockId + "))").uniqueResult()))
						.intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate
										+ "' and '"
										+ toDate
										+ "'"
										+ " and mh.district_id = "
										+ districtId

										+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
										+ healthBlockId + "))").uniqueResult())
						.intValue();

				qry = qry
						+ " and mh.district_id = "
						+ districtId
						+ " and mh.hospital_id in (select hospital_id from mas_hospital where parent_institute_id in (select hospital_id from mas_hospital where parent_institute_id  ="
						+ healthBlockId
						+ "))"
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.createAlias("HealthBlock", "hb")
						.add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.eq("hb.Id", healthBlockId))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}

			}
						
			else if (districtId != 0 && instType != 0 && hospitalIds != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = " + districtId

						).uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + districtId

						).uniqueResult()).intValue();

				qry = qry
						+ " and mh.district_id = "
						+ districtId
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}
			}
						
			else if (districtId != 0 && hospitalIds != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = " + districtId)
						.uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + districtId)
						.uniqueResult()).intValue();

				qry = qry
						+ " and mh.district_id = "
						+ districtId
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.add(Restrictions.eq("dis.Id", districtId))
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}

			}
					
			else if (districtId != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate
								+ "' and '"
								+ toDate
								+ "'"
								+ " and mh.district_id = " + districtId)
						.uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate + "' and '" + toDate + "'"
										+ " and mh.district_id = " + districtId)
						.uniqueResult()).intValue();
			}
						
			else if (districtId == 0 && hospitalIds != 0) {

				countHouse = ((BigInteger) (session
						.createSQLQuery("select count(*) from ph_house_survey phs "
								+ "left outer join mas_hospital mh on phs.hospital_id = mh.hospital_id "
								+ "where house_survey_date between '"
								+ fromDate + "' and '" + toDate + "'")
						.uniqueResult())).intValue();

				memberCount = ((BigInteger) session
						.createSQLQuery(
								"select count(*) from  ph_member_survey pms "
										+ "left outer join mas_hospital mh on pms.hospital_id = mh.hospital_id "
										+ "where member_survey_date   between '"
										+ fromDate + "' and '" + toDate + "'")
						.uniqueResult()).intValue();

				qry = qry
						+ " group by phs.house_hold_id ,jjd.date_atp ,pdb.house_id,pdb.for_day ";
				Query qrey = session.createSQLQuery(qry);
				List<Object[]> daysBlockslist = (List<Object[]>) qrey.list();
				for (Object[] dayBlock : daysBlockslist) {
					String houseid = (String) dayBlock[0];
					int houseCount = ((String) dayBlock[2]).split(",").length;
					Integer daysCount = (Integer) dayBlock[3];
					dayBlockCount += houseCount;
				}

				masSurveyTargets = session
						.createCriteria(MasSurveyTarget.class)
						.createAlias("Hospital", "hos")
						.createAlias("DistrictSurvey", "dis")
						.createAlias("HospitalType", "hosType")
						.add(Restrictions.ge("FromDate", fromDate))
						.add(Restrictions.le("ToDate", toDate)).list();
				if (masSurveyTargets.size() > 0) {
					MasSurveyTarget masSurveyTarget = masSurveyTargets.get(0);
					int surveytargetId = masSurveyTarget.getId();
					masSurveyTargetStatus = session
							.createCriteria(MasSurveyTargetStatus.class)
							.createAlias("Target", "target")
							.add(Restrictions.eq("target.Id", new Integer(
									surveytargetId))).list();
				}
			}

				} catch (Exception e) {
					e.printStackTrace();

				}

			Map statusMap = new HashMap<>();
			if(masSurveyTargetStatus.size()>0 && masSurveyTargetStatus!=null){
				String designation=null;String status=null;
				for(MasSurveyTargetStatus surveyTargetStatus:masSurveyTargetStatus){
					try {
						designation = surveyTargetStatus.getLastChangeBy().getEmployee().getRank().getRankName();
					} catch (Exception e) {
					}
					try {
						status = surveyTargetStatus.getStatus();	
					} catch (Exception e) {
					}
					
					statusMap.put(designation.replaceAll("\\s",""), status);
				}
			}
			Long annualHVisitTarget=0l;
			int targetId=0;
			Long annualHStarget=0l;
			String status=null;
			String remarks=null;
			long annualMemberSurveyTarget=0;
			if(masSurveyTargets.size()>0){
				try {
					targetId=masSurveyTargets.get(0).getId();
				} catch (Exception e) {
				}try {
					status=masSurveyTargets.get(0).getStatus();
				} catch (Exception e) {
				}try {
					remarks=masSurveyTargets.get(0).getRemarks();	
				} catch (Exception e) {
				}
				
				for(MasSurveyTarget masSurveyTarget :masSurveyTargets)
				{
					try {
						annualHStarget += masSurveyTarget.getAnnualHouseSurveyTarget();	
					} catch (Exception e) {
					}
					try {
						annualMemberSurveyTarget += masSurveyTarget.getAnnualMemberSurveyTarget();						
					} catch (Exception e) {
					}
					try {
						annualHVisitTarget += masSurveyTarget.getAnnualHouseVisitCount();		
					} catch (Exception e) {
					}
				}
				
			}
			map.put("annualHStarget", annualHStarget);
			map.put("annualMemberSurveyTarget", annualMemberSurveyTarget);
			map.put("annualHVisitTarget", annualHVisitTarget);
			map.put("countHouse", countHouse);
			map.put("memberCount", memberCount);
			map.put("dayBlockCount", dayBlockCount);
			map.put("dayBlockMonthlyCount", dayBlockMonthlyCount);

			map.put("targetId",targetId);
			map.put("status", status);
			map.put("remarks", remarks);
			
			map.put("statusMap",statusMap);
			map.put("masSurveyTargetStatus", masSurveyTargetStatus);
			map.put("masSurveyTargets", masSurveyTargets);
			
			return map;
			
		}
			
	// Added By Om Tripathi 04/10/2017 
	@Override
	public Map<String, String> dashboardAuthentication(Box box) {
		Map<String, String> hospitalMap = new HashMap<String, String>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Session session = (Session) getSession();

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		try {

			int userId = 0;
			if (box.getInt("userId") != 0) {
				userId = box.getInt("userId");
			}
			int instType = 0;
			if (box.getInt("instType") != 0) {
				instType = box.getInt("instType");
			}

			String Status = null;
			if (box.getString("Status") != null) {
				Status = (String) box.getString("Status");
			}

			int userType = 0;
			if (box.getInt("userType") != 0) {
				userType = (Integer) box.getInt("userType");
			}
			int hospitalId = 0;
			if (box.getInt("hospitalId") != 0) {
				hospitalId = (Integer) box.getInt("hospitalId");
			}
			int districtId = 0;
			if (box.getInt("districtId") != 0) {
				districtId = (Integer) box.getInt("districtId");
			}

			String verified = "N";
			if (box.getString("verified") != "Y"
					&& box.getString("verified") != "") {
				verified = box.getString("verified");
			}

			int targetId = 0;
			if (box.getString("targetIds") != null) {
				targetId = box.getInt("targetIds");
			}
			Long annualMemberSurveyTarget=0l;
			if (box.getLong("memberSurveyTarget") != 0l) {
				annualMemberSurveyTarget = box.getLong("memberSurveyTarget");
			}
			Long annualHouseSurveyTarget=0l;
			if (box.getLong("houseSurveyTarget") != 0l) {
				annualHouseSurveyTarget = box.getLong("houseSurveyTarget");
			}
			int healthBlock = 0;
			if (box.getInt("healthBlock") != 0) {
				healthBlock = box.getInt("healthBlock");
			}
			int chcphc = 0;
			if (box.getInt("chcphc") != 0) {
				chcphc = box.getInt("chcphc");
			}
			int  institutionTypeId = 0;
			if(box.getInt("instituteType")!=0){
				institutionTypeId = box.getInt("instituteType");
			}
			String ListOfCenter = null;
			if (box.getString("ListOfCenter") != null) {
				ListOfCenter = box.getString("ListOfCenter");
			}
			int base = 0;
			if (box.getInt("base") != 0) {
				base = box.getInt("base");
			}
			String message=null;
			try {
				if(targetId!=0){
				MasSurveyTarget masSurveyTarget = (MasSurveyTarget) session
						.get(MasSurveyTarget.class, new Integer(targetId));
				if (!masSurveyTarget.equals("null")	&& !masSurveyTarget.equals("")) {
					
					MasSurveyTargetStatus masSurveyTargetStatus = new MasSurveyTargetStatus();
					masSurveyTargetStatus.setCreatedDate(HMSUtil
							.convertStringTypeDateToDateType(currentDate));
					masSurveyTargetStatus.setCreatedTime(time);
					Users users = new Users();
					users.setId(userId);
					masSurveyTargetStatus.setLastChangeBy(users);
					masSurveyTargetStatus.setStatus(verified);
					
					masSurveyTargetStatus.setInstitutionTypeId(institutionTypeId);
					
						MasSurveyTarget masSurveyTargets=new MasSurveyTarget();
						masSurveyTargets.setId(targetId);
						masSurveyTargetStatus.setTarget(masSurveyTargets);
					
					masSurveyTargetStatus.setVarifiedBy("");
					
					masSurveyTarget.setAnnualHouseSurveyTarget(annualHouseSurveyTarget);
					masSurveyTarget.setAnnualMemberSurveyTarget(annualMemberSurveyTarget);
					hbt.saveOrUpdate(masSurveyTarget);
					Integer id=(Integer) hbt.save(masSurveyTargetStatus);
					if(id>0){
						 message = "Varified Successfully.";
					}else{
						 message = "!Varification failed.";
					}
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalMap;
	}
	
	
	@Override
	public Map<String, Object> getHospitalDetails(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			Session session = hbt.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			List<MasHospital> hospitals=new ArrayList<MasHospital>();
			 MasHospital masHospital =null;
			String hospitalCode=null;
			if(box.getString("instituteCode")!=null){
				hospitalCode =box.getString("instituteCode");
			}String autoCompleate = null;
			if(box.getString("autoCompleate")!=null){
				autoCompleate =box.getString("autoCompleate");
			}
			if(autoCompleate=="Y"){
				hospitals = session.createCriteria(MasHospital.class).add(Restrictions.like("HospitalCode", hospitalCode,MatchMode.START)).list();
			}else {
				hospitals = session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalCode", hospitalCode)).list();
			}
			map.put("hospitals",hospitals);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> addTabletAssets(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			Session session = hbt.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) dateMap.get("currentDate");
			String time = (String) dateMap.get("currentTime");
			List<MasHospital> hospitals=null;
			String hospitalCode=null;
			 MasHospital masHospital = null;
			 String simNo=null;
			 if(box.getString(SIM)!=null){
				 simNo=box.getString(SIM);
			 }
			 Long imeiNo = null;
			 if(box.getLong(IMEI)!=0l){
				 imeiNo = box.getLong(IMEI);
			 }
			 String utid = null;
			 if(box.getString(UTID)!=null){
				 utid = box.getString(UTID);
			 }
			 String mac = null;
			 if(box.getString(MAC)!=null){
				 mac = box.getString(MAC);
			 }
			 String message=null;
			 String assignedDate=null;
			 
			 int instituteType=0;
			 if(box.getInt(INSTITUTE_TYPES_ID)!=0){
				 instituteType = box.getInt(INSTITUTE_TYPES_ID); 
			 }
			 String status=null;
			 if(box.getString("status")!=null && !"".equals(box.getString("status"))){
				 status = box.getString("status");
			 }
			 String transferStatus=null;
			 if(box.getString("transferStatus")!=null){
				 transferStatus = box.getString("transferStatus"); 
			 }
			  int district=0;
			 if(box.getInt(DISTRICT_ID)!=0){
				 district = box.getInt(DISTRICT_ID); 
			 }
			 int hospital=0;
			 if(box.getInt(HOSPITAL)!=0){
				 hospital = box.getInt(HOSPITAL); 
			 }
			 String instituteCode=null;
			 if(box.getString(INSTITUTE_CODE)!=null){
				 instituteCode = box.getString(INSTITUTE_CODE);
			 }
			 String instituteName=null;
			 if(box.getString(INSTITUTE_NAME)!=null){
				 instituteName = box.getString(INSTITUTE_NAME);
			 }
			 int userId = 0;
			if (box.getInt("userId") != 0) {
					userId = (Integer) box.getInt("userId");
			}
			String update=null;
			if(box.getString("update")!=null){
				update = box.getString("update");
			}
			String flag=null;
			if(!"".equals(box.getString("flag")) && box.getString("flag")!=null){
				flag = box.getString("flag");
			}
			hospitals =session.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "instType")
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id", district))
					.add(Restrictions.eq("instType.Id", instituteType))
					.add(Restrictions.or(Restrictions.or(Restrictions.eq("SimNo", simNo), Restrictions.eq("ImeiNo", imeiNo)), Restrictions.or(Restrictions.eq("Utid", utid), Restrictions.eq("Mac", mac))))
					.list();
			
			if(hospitals.size()>0){
			if(update.equals("update")){
					MasHospital masHospitals = (MasHospital)session.get(MasHospital.class,new Integer(hospitals.get(0).getId()));
					masHospitals.setImeiNo(imeiNo);
					masHospitals.setMac(mac);
					masHospitals.setSimNo(simNo);
					masHospitals.setUtid(utid);
					masHospitals.setTabletStatus("A");
					Users users=new Users();
					users.setId(userId);
					masHospitals.setLastChgBy(users);
					masHospitals.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
  				    hbt.saveOrUpdate(masHospitals);
					message ="Record Updated Successfully!";
				}else if(flag.equals("InActivate")){
					MasHospital masHospitals = (MasHospital)session.get(MasHospital.class,new Integer(hospitals.get(0).getId()));
					masHospitals.setImeiNo(imeiNo);
					masHospitals.setMac(mac);
					masHospitals.setSimNo(simNo);
					masHospitals.setUtid(utid);
					masHospitals.setTabletStatus("I");
					Users users=new Users();
					users.setId(userId);
					masHospitals.setLastChgBy(users);
					masHospitals.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
  				    hbt.saveOrUpdate(masHospitals);
					message ="Record Updated Successfully!";
				}else{
					MasHospital masHospitals = (MasHospital) session.get(MasHospital.class, new Integer(hospitals.get(0).getId()));
					masHospitals.setImeiNo(imeiNo);
					masHospitals.setUtid(utid);
					masHospitals.setMac(mac);
					masHospitals.setSimNo(simNo);
					Users users=new Users();
					users.setId(userId);
					masHospitals.setLastChgBy(users);
					masHospitals.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
					masHospitals.setLastChgTime(time);
					hbt.saveOrUpdate(masHospitals);
				}
			}else{
				List<MasHospital> hospitalList = session.createCriteria(MasHospital.class)
					.createAlias("HospitalType", "instType")
					.createAlias("District", "dist")
					.add(Restrictions.eq("dist.Id", district))
					.add(Restrictions.eq("instType.Id", instituteType)).list();
			try {
			if(hospitalList.size()>0){
			MasHospital masHospitals= (MasHospital) session.load(MasHospital.class, new Integer(hospitalList.get(0).getId()));
			masHospitals.setImeiNo(imeiNo);
			masHospitals.setMac(mac);
			masHospitals.setSimNo(simNo);
			masHospitals.setLastChgTime(time);
			masHospitals.setTabletStatus("A");
			Users users=new Users();
			users.setId(userId);
			masHospitals.setLastChgBy(users);
			masHospitals.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			
			masHospitals.setUtid(utid);
			hbt.saveOrUpdate(masHospitals);
			 message ="Record Saved Successfully!";
			}
			} catch (Exception e) {
				 e.printStackTrace();
			}
			}
			tx.commit();
			map.put("message", message);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@Override
	public Map<String, Object> importAssetsDetails(Map utilMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> instituteCode = new ArrayList<String>();
		List<String> UTID = new ArrayList<String>();
		List<String> MAC = new ArrayList<String>();
		List<String> SIM = new ArrayList<String>();
		List<Long> IMEI = new ArrayList<Long>();
		List<String> transferStatus = new ArrayList<String>();
		
		instituteCode = (List) utilMap.get("instituteCode");
		UTID = (List) utilMap.get("UTID");
		MAC = (List) utilMap.get("MAC");
		SIM =(List) utilMap.get("SIM");
		IMEI =(List) utilMap.get("IMEI");
		transferStatus = (List) utilMap.get("transferStatus");
		
		int deptId = (Integer) utilMap.get("deptId");
		int hospitalId = (Integer) utilMap.get("hospitalId");
		int userId = (Integer) utilMap.get("userId");
		List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();
		
		String userName = (String) utilMap.get("utilMap");
		
		Map dateMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) dateMap.get("currentDate");
		String time = (String) dateMap.get("currentTime");
		org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);
		Transaction tx = null;
		String msg = "";
		boolean succesfullyAdded = false;
		try {
			tx = session.beginTransaction();

			String instCode = "";
			String UTIDs="";
			int i = 0;
			
			if (instituteCode.size() > 0) {
				for (i = 0; i < instituteCode.size(); i++) {
					int localityId = 0;
					int hosTypeId=0;int distId =0; String hospName=null;int hospitalsId=0;
					instCode = instituteCode.get(i);
					String status = transferStatus.get(i);
					String utid = UTID.get(i);
					String mac = MAC.get(i);
					String sim = SIM.get(i);
					Long imei = IMEI.get(i);
					
					if(!instCode.equals("")){
						
						List<MasHospital> tablets = session.createCriteria(MasHospital.class).add(Restrictions.eq("HospitalCode", instCode)).list();
						if(tablets.size()>0){
							int tabletId = tablets.get(0).getId();
							MasHospital masHospital =(MasHospital)session.get(MasHospital.class, new Integer(tabletId));
							if(status.equals("T")){
								masHospital.setTabletStatus("T");
								Users user = new Users();
								user.setId(userId);
								masHospital.setLastChgBy(user);
								masHospital.setLastChgTime(time);
								masHospital.setImeiNo(imei);
								masHospital.setUtid(utid);
								masHospital.setMac(mac);
								masHospital.setSimNo(sim);
								hbt1.saveOrUpdate(masHospital);
							}else if(status.equals("I")){
								masHospital.setTabletStatus("I");
								Users users=new Users();
								users.setId(userId);
								masHospital.setLastChgBy(users);
								masHospital.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								masHospital.setLastChgTime(time);
								masHospital.setImeiNo(imei);
								masHospital.setUtid(utid);
								masHospital.setMac(mac);
								masHospital.setSimNo(sim);
								hbt1.saveOrUpdate(masHospital);
							}else if(status.equals("Y")){
								masHospital.setTabletStatus("A");
								masHospital.setUtid(utid);
								masHospital.setSimNo(sim);
								masHospital.setMac(mac);
								masHospital.setImeiNo(imei);
								Users users=new Users();
								users.setId(userId);
								masHospital.setLastChgBy(users);
								masHospital.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								masHospital.setLastChgTime(time);
								hbt1.saveOrUpdate(masHospital);
							}else{
								masHospital.setUtid(utid);
								masHospital.setSimNo(sim);
								masHospital.setMac(mac);
								masHospital.setImeiNo(imei);
								String contact = masHospital.getContactNumber();
								if(!"".equalsIgnoreCase(contact) && contact!=null){
									
								}else {
									masHospital.setContactNumber("");
								}
								
								Users users=new Users();
								users.setId(userId);
								masHospital.setTabletStatus("A");
								masHospital.setLastChgBy(users);
								masHospital.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								masHospital.setLastChgTime(time);
								hbt1.saveOrUpdate(masHospital);
							}
							
							String message ="Record updated successfully!";
						}else{
							List<MasHospital> masTablets = session.createCriteria(MasHospital.class).add(Restrictions.or(Restrictions.or(Restrictions.eq("Mac", mac), Restrictions.eq("ImeiNo", imei)), Restrictions.or(Restrictions.eq("SimNo", sim), Restrictions.eq("Utid", utid)))).list();
							if(masTablets.size()>0){
								int hospId = masTablets.get(0).getId();
								MasHospital masHospital =(MasHospital)session.get(MasHospital.class, new Integer(hospId));
								masHospital.setUtid(utid);
								masHospital.setSimNo(sim);
								masHospital.setMac(mac);
								masHospital.setTabletStatus("A");
								masHospital.setImeiNo(imei);
								Users users=new Users();
								users.setId(userId);
								masHospital.setLastChgBy(users);
								masHospital.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));
								masHospital.setLastChgTime(time);
								hbt1.saveOrUpdate(masHospital);
							}
					  }
				   }
				}	
			}
			tx.commit();
		} catch (Exception e) {
			msg = "Try Again..";
			tx.rollback();
			e.printStackTrace();
		}
		map.put("succesfullyAdded", succesfullyAdded);
		map.put("msg", msg);
		return map;
	}
	
	@Override
	public Map<String, Object> searchAssetTablet(Box box) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			Session session = hbt.getSessionFactory().getCurrentSession();
			
			int hospitalId=0;
			if(box.getInt("hospitalIds")!=0){
				hospitalId =box.getInt("hospitalIds");
			}List<MasHospital> masHospList=new ArrayList<MasHospital>();
			if(box.getString("search")!=null && !"".equals(box.getString("search")) && box.getString("search").equals("Y")){
				Criteria crit = null;
				crit = session.createCriteria(MasHospital.class).createAlias("District", "dist")
						.createAlias("HospitalType","hostType");
				int districtId =0;
				if(box.getInt("districtName")!=0){
					districtId = box.getInt("districtName");
					crit.add(Restrictions.eq("dist.Id", districtId));
				}int instituteType=0;
				if(box.getInt("instituteType")!=0){
					instituteType = box.getInt("instituteType");
					crit.add(Restrictions.eq("hostType.Id", instituteType));
				}
				String institution="";
				if(!"".equals(box.getString(INSTITUTE_NAME))&& box.getString(INSTITUTE_NAME)!=null ){
					institution = box.getString(INSTITUTE_NAME);
					crit.add(Restrictions.like("ShortName", institution, MatchMode.START));
				}
				Long IMEIS=0l;
				if(box.getLong(IMEI)!=0l){
					IMEIS =box.getLong(IMEI);
					crit.add(Restrictions.eq("ImeiNo", IMEIS));
				}
				String UTIDS="";
				if(!"".equals(box.getString(UTID)) && box.getString(UTID)!= null){
					UTIDS =box.getString(UTID);
					crit.add(Restrictions.eq("Utid", UTIDS));
				}
				List<MasHospital> masTablets = crit.list();
				map.put("masTablets",masTablets);
				
			}else if(hospitalId!=0){
				masHospList= session.createCriteria(MasHospital.class).createAlias("District", "dist")
						.createAlias("HospitalType","hostType").add(Restrictions.eq("Id", hospitalId)).list();
				map.put("masHospList", masHospList);
			}
			else{
			List<MasHospital> hospitals=new ArrayList<MasHospital>();
			
			Criteria crit = null;
			crit = session.createCriteria(MasHospital.class).createAlias("District", "dist")
					.createAlias("HospitalType","hostType");
			int districtId =0;
			if(box.getInt("districtName")!=0){
				districtId = box.getInt("districtName");
				crit.add(Restrictions.eq("dist.Id", districtId));
			}int instituteType=0;
			if(box.getInt("instituteType")!=0){
				instituteType = box.getInt("instituteType");
				crit.add(Restrictions.eq("hostType.Id", instituteType));
			}
			String institution="";
			if(!"".equals(box.getString(INSTITUTE_NAME))&& box.getString(INSTITUTE_NAME)!=null ){
				institution = box.getString(INSTITUTE_NAME);
				crit.add(Restrictions.like("ShortName", institution, MatchMode.START));
			}
			Long IMEIS=0l;
			if(box.getLong(IMEI)!=0l){
				IMEIS =box.getLong(IMEI);
				crit.add(Restrictions.eq("ImeiNo", IMEIS));
			}
			String UTIDS="";
			if(!"".equals(box.getString(UTID)) && box.getString(UTID)!= null){
				UTIDS =box.getString(UTID);
				crit.add(Restrictions.eq("Utid", UTIDS));
			}
			List<MasHospital> masTablets = crit.list();
			map.put("masTablets",masTablets);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
