package jkt.hms.mis.dataservice;

import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_ID;
import static jkt.hms.util.RequestConstants.SERVICE_TYPE_NAME;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import jkt.hms.masters.business.BabyDetails;
import jkt.hms.masters.business.Birthdeathreg;
import jkt.hms.masters.business.DeliveryDetails;
import jkt.hms.masters.business.Discharge;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.ExpiryDetails;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasBabyStatus;
import jkt.hms.masters.business.MasCsIndication;
import jkt.hms.masters.business.MasDeliveryType;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDisposal;
import jkt.hms.masters.business.MasDisposedTo;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasGestation;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIcd;
import jkt.hms.masters.business.MasNeonatalProblem;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MisAnnualMedicalExam;
import jkt.hms.masters.business.MisFatalTracking;
import jkt.hms.masters.business.MisFrw;
import jkt.hms.masters.business.MisNotifiable;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Priyanka Garg MIS Module data service layer
 *
 */

public class MISDataServiceImpl extends HibernateDaoSupport implements
		MISDataService {

	@SuppressWarnings("unchecked")
	/*
	 * * showEDReturnsJsp() is used in ED returns form for displaying data in a
	 * JSP In EDReturnsJsp, Visit is the primary table for fetching data.
	 */
	public Map<String, Object> showEDReturnsJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		// List<Object> showList = new ArrayList<Object>();
		// List<MasDisposedTo> disposalList = new ArrayList<MasDisposedTo>();
		// Date currentDate = new Date();
		// String today;
		// today = HMSUtil.convertDateToStringWithoutTime(currentDate);

		// int toYear = 1900 + currentDate.getYear();
		// int toMonth = currentDate.getMonth() + 1;
		// today = Integer.toString(toYear) + "-" + Integer.toString(toMonth)
		// + "-" + Integer.toString(currentDate.getDate());

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
					.add(Restrictions.eq("Status", "y")).list();
			// /disposalList = session.createCriteria(MasDisposedTo.class).add(
			// Restrictions.eq("Status", "y")).list();
			// /showList = getHibernateTemplate()
			// .find(
			// "from Visit v join v.Hin as p join p.Rank as r join
			// r.RankCategory as rc join p.Trade as t join p.Unit as u join
			// v.Disposal as d where v.VisitDate between '"
			// + today
			// + "' and '"
			// + today
			// + "' and r.RankCategory='1' and v.EdStatus='n'");

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("rankCategoryList", rankCategoryList);
		// map.put("disposalList", disposalList);
		// map.put("showList", showList);

		return map;

	}

	/**
	 * showEDReturns() function is called when some criteria is passed for
	 * fetching data Visit is the primary table used.
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Map<String, Object> showEDReturns(String toDate, String fromDate,
			String category, String edStatus) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasDisposedTo> disposalList = new ArrayList<MasDisposedTo>();
		List<Visit> showList = new ArrayList<Visit>();
		@SuppressWarnings("unused")
		String fromDateStr = "";
		String toDateStr = "";
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fromDateStr = formatterOut.format(formatterIn.parse("" + fromDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			toDateStr = formatterOut1.format(formatterIn1.parse("" + toDate));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		rankCategoryList = session.createCriteria(MasRankCategory.class)
				.add(Restrictions.eq("Status", "y")).list();
		disposalList = session.createCriteria(MasDisposedTo.class)
				.add(Restrictions.eq("Status", "y")).list();
		@SuppressWarnings("unused")
		String qry = null;
		try {
			if ((toDate != null) && (fromDate != null) && (category != null)
					&& !category.equals("") && !category.equals("0")) {
				// showList = getHibernateTemplate()
				// // .find("from Visit v join v.Hin as p left join p.Rank as r
				// left join r.RankCategory as rc left join p.Trade as t left
				// join p.Unit as u join p.Relation rel where v.VisitDate
				// between '"
				// + date4MySQL2
				// + "' and '"
				// + date4MySQL
				// + "' and r.RankCategory='"
				// + category
				// + "' and v.EdStatus='n'"
				// +" and rel.RelationName='Self'");
				showList = session
						.createCriteria(Visit.class)
						.createAlias("Hin", "pt")
						.createAlias("pt.Rank", "rank")
						.createAlias("rank.RankCategory", "rankCt")
						.add(Restrictions.eq("rankCt.Id",
								Integer.parseInt(category)))
						.add(Restrictions.eq("EdStatus", "n"))
						.add(Restrictions.eq("pt.Relation.Id", 8))
						.add(Restrictions.between("VisitDate",
								java.sql.Date.valueOf(fromDateStr),
								java.sql.Date.valueOf(toDateStr))).list();
			} else if ((toDate != null) && (fromDate != null)) {
				showList = session
						.createCriteria(Visit.class)
						.createAlias("Hin", "pt")
						.add(Restrictions.eq("EdStatus", "n"))
						.add(Restrictions.eq("pt.Relation.Id", 8))
						.add(Restrictions.between("VisitDate",
								java.sql.Date.valueOf(fromDateStr),
								java.sql.Date.valueOf(toDateStr))).list();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("rankCategoryList", rankCategoryList);
		map.put("disposalList", disposalList);
		map.put("showList", showList);

		return map;
	}

	/**
	 * editEDReturnsToDatabase() is used for updating records on the ED Returns
	 * form. records are updated in the Visit table.
	 */
	public boolean editEDReturnsToDatabase(Map<String, Object> generalMap) {

		boolean dataUpdated = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String occupationName = "";
		@SuppressWarnings("unused")
		int visitId = 0;
		// String edDate = null;
		Date edDate = new Date();
		int edDays = 0;
		String dispose = null;
		String edStatusChg = "";
		Date edDate1 = new Date();
		Date edDate2 = new Date();
		Date edDate3 = new Date();
		Date ldDate = new Date();
		int ldDays = 0;
		String diagnosis = "";

		visitId = (Integer) generalMap.get("id");
		edDate = (Date) generalMap.get("edDate");
		dispose = (String) generalMap.get("dispose");
		edDays = (Integer) generalMap.get("edDays");
		edStatusChg = (String) generalMap.get("edStatus");
		edDate1 = (Date) generalMap.get("edDate1");
		edDate2 = (Date) generalMap.get("edDate2");
		edDate3 = (Date) generalMap.get("edDate3");
		diagnosis = (String) generalMap.get("diagnosis");
		// ldDays=(Integer)generalMap.get("ldDays");

		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			Visit visit = (Visit) hbt.load(Visit.class, visitId);
			// MasDisposedTo masDisposedTo=new MasDisposedTo();
			// masDisposedTo.setId(dispose);
			visit.setEdStartDate(edDate);
			visit.setEdDays(edDays);
			visit.setEdDispose(dispose);
			visit.setDiagnosisName(diagnosis);
			if (dispose.equals("ED")) {
				visit.setEdDate1(edDate1);
				visit.setEdDate2(edDate2);
				visit.setEdDate3(edDate3);
			}
			/*
			 * visit.setLdStartDate(ldDate); visit.setLdDays(ldDays);
			 */
			visit.setEdStatus("y");
			hbt.update(visit);
			dataUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * ED Return Report is the criteria screen which passed to the .jasper file.
	 * showEDreportsjsp(), is used for showing the criteria JSP file.
	 */

	// ------------------------ ED Return Report form
	// ----------------------------
	public Map<String, Object> showEDreportsjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
					.add(Restrictions.eq("Status", "y")).list();
			masServiceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("rankCategoryList", rankCategoryList);

		return map;

	}

	/**
	 * searchEDReturn() is used for fetching records from the database,
	 * according to the criteria that is passed on the criteria screen. Visit is
	 * the primary table that is used for fetching records.
	 */

	public Map<String, Object> searchEDReturn(Date toDate, Date fromDate,
			String category) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List showList = null;

		rankCategoryList = session.createCriteria(MasRankCategory.class)
				.add(Restrictions.eq("Status", "y")).list();

		int toYear = 1900 + toDate.getYear();
		int fromYear = 1900 + fromDate.getYear();
		int toMonth = toDate.getMonth() + 1;
		int fromMonth = fromDate.getMonth() + 1;
		String dateTo = Integer.toString(toYear) + "-"
				+ Integer.toString(toMonth) + "-"
				+ Integer.toString(toDate.getDate());
		String dateFrom = Integer.toString(fromYear) + "-"
				+ Integer.toString(fromMonth) + "-"
				+ Integer.toString(fromDate.getDate());
		try {
			if ((toDate != null) && (fromDate != null) && (category != null)) {

				showList = getHibernateTemplate()
						.find("Select rc.RankCategoryName,p.ServiceNo,p.PFirstName,p.PLastName,t.TradeName,d.DisposalName,u.UnitName,v.Age,v.EdDays,v.EdDate,dd.DiagnosisConclusionName,r.RankName from Visit v join v.Hin as p join p.Rank as r join r.RankCategory as rc join p.Trade as t join p.Unit as u join v.Disposal as d join v.Diagnosis as dd where  v.VisitDate between '"
								+ dateFrom
								+ "' and '"
								+ dateTo
								+ "' and r.RankCategory='" + category + "'");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("rankCategoryList", rankCategoryList);
		map.put("showList", showList);

		return map;
	}

	/**
	 * Patient Movement Order Report is the criteria screen which passed to the
	 * .jasper file. showPatientMovementOrderjsp, is used for showing the
	 * criteria JSP file.
	 */

	// ---------------------------- Patient Movement Order
	// -----------------------------
	public Map<String, Object> showPatientMovementOrderjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> serviceNoList = new ArrayList<Patient>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		try {
			// serviceNoList = session.createCriteria(Patient.class).add(
			// Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNoList", serviceNoList);
		map.put("disposalList", disposalList);

		return map;
	}

	/**
	 * searchPatientMovementOrder() is used for fetching records from the
	 * database, according to the criteria that is passed on the criteria
	 * screen. Patient is the primary table that is used for fetching records.
	 */

	public Map<String, Object> searchPatientMovementOrder(String disposal,
			String serviceNo) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		List showList = null;

		disposalList = session.createCriteria(MasDisposal.class)
				.add(Restrictions.eq("Status", "y")).list();
		try {
			if (disposal != null) {
				showList = getHibernateTemplate()
						.find("select p.ServiceNo,p.PFirstName,p.PLastName,r.RankName,u.UnitName,d.DisposalName from Patient p join p.Visits as v join p.Unit as u join p.Rank as r join v.Disposal as d where p.ServiceNo='"
								+ serviceNo
								+ "' and v.EdDispose='"
								+ disposal
								+ "'");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("disposalList", disposalList);
		map.put("showList", showList);
		return map;
	}

	/**
	 * Deficient AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	// -------------------------- Afmsf-1 Def -------------------------------
	public Map<String, Object> showAfmsfDefjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		// List<MasMedicalCategory> masMedicalList = new
		// ArrayList<MasMedicalCategory>();

		try {
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();
			tradeList = session.createCriteria(MasTrade.class)
					.add(Restrictions.eq("Status", "y")).list();
			// masMedicalList =
			// session.createCriteria(MasMedicalCategory.class).add(Restrictions.eq("Status",
			// "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("tradeList", tradeList);
		map.put("unitList", unitList);
		// map.put("masMedicalList", masMedicalList);

		return map;
	}

	public Map<String, Object> showAfmsfDef(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		// List<MasMedicalCategory> masMedicalList = new
		// ArrayList<MasMedicalCategory>();
		String serviceNo = null;
		String queryString = null;
		try {
			serviceNo = (String) generalMap.get("serviceNo");
			queryString = "from MasEmployee where ServiceNo=" + serviceNo;

			employeeList = getHibernateTemplate().find(queryString);
			queryString = "from EmpAfmsfDet where ServiceNo=" + serviceNo;

			empAfmsfDetList = getHibernateTemplate().find(queryString);
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();
			tradeList = session.createCriteria(MasTrade.class)
					.add(Restrictions.eq("Status", "y")).list();
			// masMedicalList =
			// session.createCriteria(MasMedicalCategory.class).add(Restrictions.eq("Status",
			// "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNo", serviceNo);
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("employeeList", employeeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		// map.put("masMedicalList",masMedicalList);

		return map;

	}

	/**
	 * editAfmsfDef()is used for:- 1) if fetching records from MasEmployee then
	 * enter a new record in EmpAfmsfDet table. 2) else, it is fetching records
	 * from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Receipt Status is set to 'R'.
	 */

	public boolean editAfmsfDef(Map<String, Object> generalMap) {
		Session session = (Session) getSession();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		session = (Session) getSession();
		Transaction tx = null;
		String postedFromId = null;
		String postedToId = null;
		int presentUnit = 0;
		String auth = "";
		String remarks = "";
		int medicalCat = 0;
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		String letterNo = "0";
		String status = "";
		String serviceNo = null;
		String datePostingIn = null;
		String datePostingOut = null;
		String employeeName = null;
		Date receiptDate = null;
		String docStatus = "";
		Date postingInDate = null;
		Date datePostingDate = null;
		String authpostingOut = null;
		String disRemarks = null;
		String disletterNo = null;
		Date dispatchDate = null;
		String suffix = "";
		String lastName = null;
		String unitName = null;
		String unitAddress = null;
		String localUnit = null;

		// Date dispatchdate =null;
		Date nextreviewdate = null;
		String diagnosis = null;

		String receiptStatusChg;
		int empAfmsId = 0;
		serviceNo = (String) generalMap.get("serviceNo");

		receiptDate = (Date) generalMap.get("receiptdate");

		employeeName = (String) generalMap.get("employeeName");
		empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		letterNo = (String) generalMap.get("letterNo");
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// empafmsfdetId = (Integer) generalMap.get("empafmsfdetId");
		status = (String) generalMap.get("status");
		Date currentDateDate = HMSUtil
				.convertStringTypeDateToDateType(currentDate);
		auth = (String) generalMap.get("auth");
		remarks = (String) generalMap.get("remarks");
		medicalCat = (Integer) generalMap.get("medicalcategory");
		postedToId = (String) generalMap.get("postedToId");
		postedFromId = (String) generalMap.get("postedFromId");
		presentUnit = (Integer) generalMap.get("presentUnit");
		empAfmsId = (Integer) generalMap.get("empAfmsId");
		tradeId = (Integer) generalMap.get("tradeId");
		datePostingIn = (String) generalMap.get("datePostingIn");
		datePostingOut = (String) generalMap.get("datePostingOut");
		authpostingOut = (String) generalMap.get("authpostingOut");
		disRemarks = (String) generalMap.get("disRemarks");
		disletterNo = (String) generalMap.get("disletterNo");
		dispatchDate = (Date) generalMap.get("dispatchdate");
		nextreviewdate = (Date) generalMap.get("nextreviewDate");
		docStatus = (String) generalMap.get("docStatus");
		suffix = (String) generalMap.get("suffix");
		diagnosis = (String) generalMap.get("diagnosis");
		lastName = (String) generalMap.get("lastName");
		unitName = (String) generalMap.get("unitName");
		unitAddress = (String) generalMap.get("unitAddress");
		localUnit = (String) generalMap.get("localUnit");

		if (datePostingIn != null) {
			postingInDate = HMSUtil
					.convertStringTypeDateToDateType(datePostingIn);
		}

		if (datePostingOut != null) {
			datePostingDate = HMSUtil
					.convertStringTypeDateToDateType(datePostingOut);
		}

		if (dispatchDate != null) {
			// dispatchdate =
			// HMSUtil.convertStringTypeDateToDateType(dispatchDate);
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			tx = session.beginTransaction();
			EmpAfmsfDet empAfmsfDet = new EmpAfmsfDet();
			if (empAfmsId == 0) {
				List<MasEmployee> EmployeeList = new ArrayList<MasEmployee>();
				EmployeeList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.MasEmployee e where e.ServiceNo='"
								+ serviceNo + "'");
				int id = 0;
				List objectList = new ArrayList();
				String idqry = "SELECT max(empafmsfdet_id) FROM emp_afmsf_det";
				objectList = (List) session.createSQLQuery(idqry).list();

				if (objectList.get(0) != null) {
					id = 1 + Integer.parseInt("" + objectList.get(0));
				}

				if (EmployeeList.size() == 0) {
					List objectList2 = new ArrayList();
					String empCode = "";
					String eCode = "";
					int EMPid = 0;

					List objectList3 = new ArrayList();
					String EmpIdqry = "SELECT max(employee_id) FROM mas_employee e";
					objectList3 = (List) session.createSQLQuery(EmpIdqry)
							.list();
					if (objectList3.get(0) != null) {
						EMPid = 1 + Integer.parseInt("" + objectList3.get(0));
					}
					empCode = "E".concat(generateNumberForseq());

					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(EMPid);
					masEmployee.setEmployeeCode(empCode);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					masEmployee.setHospital(masHospital);
					masEmployee.setFirstName(employeeName);
					masEmployee.setLastName(lastName);

					MasEmpStatus masEmpStatus = new MasEmpStatus();
					masEmpStatus.setId(1);
					masEmployee.setEmployeeStatus(masEmpStatus);

					masEmployee.setJoinDate(postingInDate);
					masEmployee.setStatus("n");
					//commented for maven
					/*masEmployee.setLastChgBy(changedBy);*/
					masEmployee.setLastChgDate(currentDateDate);
					masEmployee.setLastChgTime(currentTime);
					masEmployee.setServiceNo(serviceNo);

					MasRank masRank = new MasRank();
					masRank.setId(rankId);
					masEmployee.setRank(masRank);
					masEmployee.setUnit(new MasUnit(presentUnit));
					MasTrade masTrade = new MasTrade();
					masTrade.setId(tradeId);
					masEmployee.setTrade(masTrade);
					hbt.save(masEmployee);
					hbt.refresh(masEmployee);

					empAfmsfDet.setEmployee(masEmployee);
				} else {
					MasEmployee masEmployee = (MasEmployee) EmployeeList.get(0);
					empAfmsfDet.setEmployee(masEmployee);
				}

				// if(postedFromId != null && !postedFromId.equals("0")){
				// if(!postedFromId.equals("Other")){
				// empAfmsfDet.setPostedFrom(new
				// MasUnit(Integer.parseInt(postedFromId)));
				// }else if(postedFromId.equals("Other")){
				// Map<String, Object> tempmap = new HashMap<String, Object>();
				//
				// tempmap =
				// unitTemp(unitName,unitAddress,localUnit,currentDateDate,currentTime,changedBy);
				// MasUnit masunitObj = (MasUnit) tempmap.get("masUnitObj");
				// empAfmsfDet.setPostedFrom(new MasUnit(masunitObj.getId()));
				// }
				// }

				if (postedToId != null && !postedToId.equals("0")) {
					if (!postedToId.equals("Other")) {
						// empAfmsfDet.setPostedTo(new
						// MasUnit(Integer.parseInt(postedToId)));
					} else if (postedToId.equals("Other")) {
						Map<String, Object> tempmap = new HashMap<String, Object>();
						tempmap = unitTemp(unitName, unitAddress, localUnit,
								currentDateDate, currentTime, changedBy);
						MasUnit masunitObj = (MasUnit) tempmap
								.get("masUnitObj");
						// empAfmsfDet.setPostedTo(new
						// MasUnit(masunitObj.getId()));
					}
				}

				if (presentUnit != 0) {
					empAfmsfDet.setUnit(new MasUnit(presentUnit));
				}

				if (rankId != 0) {
					empAfmsfDet.setRank(new MasRank(rankId));
				}

				if (tradeId != 0) {
					if (hospitalId != 0) {
						empAfmsfDet.setHospital(new MasHospital(hospitalId));
					}
				}

				if (status != null) {
					if (status.equals("arrival") || status.equals("receipt")) {
						empAfmsfDet.setAfmsfType("IN");
					} else if (status.equals("clearance")
							|| status.equals("dispatch")) {
						empAfmsfDet.setAfmsfType("OUT");
					}
				}
				if (docStatus != "" && docStatus != null) {
					if (receiptDate != null) {
						if (serviceNo != null) {
							if (employeeName != null) {
								empAfmsfDet.setEmpName(employeeName);
							}
						}
					}
				}

				if (lastName != null && !lastName.equals("")) {
					if (nextreviewdate != null) {
						empAfmsfDet.setNextReview(nextreviewdate);
					}
				}

				// if(diagnosis != null && !diagnosis.equals("")){
				// empAfmsfDet.setDiagnosis(diagnosis);
			}

			if (letterNo != "") {
				empAfmsfDet.setLetterNo(letterNo);
			}

			empAfmsfDet.setLastChgDate(currentDateDate);

			empAfmsfDet.setLastChgTime(currentTime);

			empAfmsfDet.setLastChgBy(changedBy);
			// empAfmsfDet.setFmsfDate(receiptDate);
			if (auth != "") {
				if (remarks != "") {
					empAfmsfDet.setRemarks(remarks);
				}
			}

			if (medicalCat != 0) {
				if (postingInDate != null) {
					hbt.save(empAfmsfDet);
				}
			}
			/*
			 * }catch (Exception e) {
			 * e.printStackTrace(); }
			 */
			dataUpdated = true;
			// }else{
			// // empAfmsfDet = (EmpAfmsfDet)
			// hbt.load(EmpAfmsfDet.class,empAfmsId);
			// //
			// // if(postedFromId != null && !postedFromId.equals("0")){
			// // if(!postedFromId.equals("Other")){
			// // empAfmsfDet.setPostedFrom(new
			// MasUnit(Integer.parseInt(postedFromId)));
			// // }else if(postedFromId.equals("Other")){
			// // Map<String, Object> tempmap = new HashMap<String, Object>();
			// //
			// // tempmap =
			// unitTemp(unitName,unitAddress,localUnit,currentDateDate,currentTime,changedBy);
			// // MasUnit masunitObj = (MasUnit) tempmap.get("masUnitObj");
			// // empAfmsfDet.setPostedFrom(new MasUnit(masunitObj.getId()));
			// // }
			// }
			//
			// if(postedToId != null && !postedToId.equals("0")){
			// if(!postedToId.equals("Other")){
			// empAfmsfDet.setPostedTo(new
			// MasUnit(Integer.parseInt(postedToId)));
			// }else if(postedToId.equals("Other")){
			// Map<String, Object> tempmap = new HashMap<String, Object>();
			// tempmap =
			// unitTemp(unitName,unitAddress,localUnit,currentDateDate,currentTime,changedBy);
			// MasUnit masunitObj = (MasUnit) tempmap.get("masUnitObj");
			// empAfmsfDet.setPostedTo(new MasUnit(masunitObj.getId()));
			// }
			// }
			// if(presentUnit != 0)
			// empAfmsfDet.setUnit(new MasUnit(presentUnit));
			//
			// if(rankId !=0)
			// empAfmsfDet.setRank(new MasRank(rankId));
			//
			// if(tradeId !=0)
			// empAfmsfDet.setTrade(new MasTrade(tradeId));
			//
			// if(hospitalId !=0)
			// empAfmsfDet.setHospital(new MasHospital(hospitalId));
			//
			// if(status != null){
			// if(status.equals("arrival") || status.equals("receipt")){
			// empAfmsfDet.setAfmsfType("IN");
			// }else if(status.equals("clearance") ||
			// status.equals("dispatch")){
			// empAfmsfDet.setAfmsfType("OUT");
			// }
			// }
			//
			// if(docStatus != "" && docStatus != null){
			// empAfmsfDet.setDocStatus(docStatus);
			// }
			//
			// if(receiptDate != null)
			// empAfmsfDet.setRecDate(receiptDate);
			//
			// if(serviceNo != null && serviceNo != "")
			// empAfmsfDet.setServiceNo(serviceNo);
			//
			// if(employeeName != null )
			// empAfmsfDet.setEmpName(employeeName);
			//
			//
			// if(lastName != null && !lastName.equals(""))
			// empAfmsfDet.setEmpLastName(lastName);
			//
			// if(nextreviewdate != null)
			// empAfmsfDet.setNextReview(nextreviewdate);
			//
			// if(diagnosis != null && !diagnosis.equals("")){
			// empAfmsfDet.setDiagnosis(diagnosis);
			// }
			//
			// if(letterNo != "" && letterNo != null)
			// empAfmsfDet.setLetterNo(letterNo);
			//
			// empAfmsfDet.setLastChgDate(currentDateDate);
			//
			// empAfmsfDet.setLastChgTime(currentTime);
			//
			// empAfmsfDet.setLastChgBy(changedBy);
			// // empAfmsfDet.setFmsfDate(receiptDate);
			// if(auth != "" && auth != null)
			// empAfmsfDet.setAuthPosting(auth);
			//
			// empAfmsfDet.setStatus("y");
			//
			// if(remarks != "" && remarks != null)
			// empAfmsfDet.setRemarks(remarks);
			//
			// if(medicalCat != 0)
			// empAfmsfDet.setMedicalCategory(new
			// MasMedicalCategory(medicalCat));
			//
			// if(postingInDate != null)
			// empAfmsfDet.setPostInDate(postingInDate);
			//
			// if(datePostingDate != null)
			// empAfmsfDet.setPostOutDate(datePostingDate);
			//
			// if(authpostingOut != null && authpostingOut != "")
			// empAfmsfDet.setAuthPostOut(authpostingOut);
			//
			// if(disRemarks != null && disRemarks != "")
			// empAfmsfDet.setDisRemarks(disRemarks);
			//
			// if(disletterNo != null && disletterNo != "")
			// empAfmsfDet.setDisLetterNo(disletterNo);
			//
			// if(dispatchDate != null)
			// empAfmsfDet.setDisDate(dispatchDate);
			//
			// if(suffix != "" && suffix != null)
			// empAfmsfDet.setSuffix(suffix);
			//
			// hbt.update(empAfmsfDet);
			// }
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		return dataUpdated;
	}

	public Map<String, Object> unitTemp(String uName, String uAddress,
			String lUnit, Date crDate, String crTime, String chby) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		MasUnit masUnitObj = new MasUnit();
		if (uName != null) {

			StringBuffer output_str1 = new StringBuffer();
			StringTokenizer s1 = new StringTokenizer(uName + "", "\'");

			while (s1.hasMoreTokens()) {
				output_str1.append(s1.nextToken());
				if (s1.hasMoreTokens()) {
					output_str1.append(" ");
				}
			}

			StringBuffer output_str2 = new StringBuffer();
			StringTokenizer s2 = new StringTokenizer(output_str1 + "", "\"");

			while (s2.hasMoreTokens()) {
				output_str2.append(s2.nextToken());
				if (s2.hasMoreTokens()) {
					output_str2.append(" ");
				}
			}
			masUnitObj.setUnitName("" + output_str2);
		}
		if (uAddress != null) {

			StringBuffer output_str3 = new StringBuffer();
			StringTokenizer s3 = new StringTokenizer(uAddress + "", "\'");

			while (s3.hasMoreTokens()) {
				output_str3.append(s3.nextToken());
				if (s3.hasMoreTokens()) {
					output_str3.append(" ");
				}
			}

			StringBuffer output_str4 = new StringBuffer();
			StringTokenizer s4 = new StringTokenizer(output_str3 + "", "\"");

			while (s4.hasMoreTokens()) {
				output_str4.append(s4.nextToken());
				if (s4.hasMoreTokens()) {
					output_str4.append(" ");
				}
			}
			masUnitObj.setUnitAddress("" + output_str4);
		}
		if (lUnit != null) {
			masUnitObj.setLocalUnit("y");
		} else {
			masUnitObj.setLocalUnit("n");
		}
		masUnitObj.setLastChgDate(crDate);
		masUnitObj.setLastChgTime(crTime);
		//commented for maven
		/*masUnitObj.setLastChgBy(chby);*/
		masUnitObj.setStatus("t");
		hbt.save(masUnitObj);
		map.put("masUnitObj", masUnitObj);
		return map;
	}

	/**
	 * Surplus AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	// --------------------------- Afmsf-1 Surplus
	// -------------------------------
	public Map<String, Object> showAfmsfSurplusjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();

		try {
			masTradeList = session.createCriteria(MasTrade.class)
					.add(Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("masTradeList", masTradeList);
		map.put("rankList", rankList);
		map.put("unitList", unitList);

		return map;
	}

	public Map<String, Object> showAfmsfSurplus(Map<String, Object> generalMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		String serviceNo = null;
		String queryString = null;
		List<MasTrade> masTradeList = new ArrayList<MasTrade>();
		try {
			serviceNo = (String) generalMap.get("serviceNo");

			queryString = "from MasEmployee where ServiceNo=" + serviceNo;
			employeeList = getHibernateTemplate().find(queryString);

			queryString = "from EmpAfmsfDet ead where ServiceNo='" + serviceNo
					+ "' group by ead.EmpName";
			empAfmsfDetList = getHibernateTemplate().find(queryString);
			masTradeList = session.createCriteria(MasTrade.class)
					.add(Restrictions.eq("Status", "y")).list();
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("employeeList", employeeList);
		map.put("serviceNo", serviceNo);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("masTradeList", masTradeList);
		return map;
	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */

	public boolean editAfmsfSurplus(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		int postedFromId = 0;
		int postedToId = 0;
		String description = "";
		String medicalCat = "";
		int hospitalId = 0;
		int rankId = 0;
		int empId = 0;
		int tradeId = 0;
		String letterNo = "0";
		String status = "";
		String serviceNo = null;

		String employeeName = null;
		Date receiptDate = null;

		String receiptStatusChg;
		int empAfmsId = 0;
		serviceNo = (String) generalMap.get("serviceNo");
		receiptDate = (Date) generalMap.get("receiptDate");

		employeeName = (String) generalMap.get("employeeName");
		empId = (Integer) generalMap.get("employeeId");
		rankId = (Integer) generalMap.get("rankId");
		letterNo = (String) generalMap.get("letterNo");

		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		hospitalId = (Integer) generalMap.get("hospitalId");
		// empafmsfdetId = (Integer) generalMap.get("empafmsfdetId");
		status = (String) generalMap.get("status");
		Date currentDateDate = HMSUtil
				.convertStringTypeDateToDateType(currentDate);
		description = (String) generalMap.get("description");
		medicalCat = (String) generalMap.get("medicalCat");
		postedToId = (Integer) generalMap.get("postedToId");
		postedFromId = (Integer) generalMap.get("postedFromId");
		empAfmsId = (Integer) generalMap.get("empAfmsId");
		tradeId = (Integer) generalMap.get("tradeId");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			if (empAfmsId == 0) {
				EmpAfmsfDet empAfmsfDet = new EmpAfmsfDet();
				if (empId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(empId);
					empAfmsfDet.setEmployee(masEmployee);
				}
				if (postedFromId != 0) {
					MasUnit masUnit = new MasUnit();
					masUnit.setId(postedFromId);
					empAfmsfDet.setUnit(masUnit);
				}
				if (postedToId != 0) {
					// empAfmsfDet.setPostedTo(new MasUnit(postedToId));
					// if(rankId !=0)
					// empAfmsfDet.setRank(new MasRank(rankId));
					//
					// MasHospital masHospital=new MasHospital();
					// masHospital.setId(hospitalId);
					// empAfmsfDet.setHospital(masHospital);
					//
					// empAfmsfDet.setAfmsfType("D");
					// empAfmsfDet.setDocStatus("y");
					// empAfmsfDet.setVideWithDate(receiptDate);
					// empAfmsfDet.setServiceNo(serviceNo);
					// empAfmsfDet.setEmpName(employeeName);
					// empAfmsfDet.setLetterNo(letterNo);
					//
					// empAfmsfDet.setLastChgDate(currentDateDate);
					// empAfmsfDet.setLastChgTime(currentTime);
					// empAfmsfDet.setLastChgBy(changedBy);
					// empAfmsfDet.setFmsfDate(receiptDate);
					// empAfmsfDet.setAuthPosting(description);
					// empAfmsfDet.setStatus(status);
					// if(tradeId !=0)
					// empAfmsfDet.setTrade(new MasTrade(tradeId));
					// hbt.save(empAfmsfDet);
					// dataUpdated = true;
					// }else{
					// EmpAfmsfDet empAfmsfDet = (EmpAfmsfDet)
					// hbt.load(EmpAfmsfDet.class,empAfmsId);
					// empAfmsfDet.setStatus(status);
					hbt.update(empAfmsfDet);
				}
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * Surplus AFMSF-1 is a screen used for displaying and updating records.
	 * Fetching records from two tables: 1)MasEmployee:- When there are no
	 * records in the EmpAfmsfDet table and the receipt status is 'No' selected
	 * in the form. 2)EmpAfmsfDet:- when there are records present in
	 * EmpAfmsfDet, and the receipt status selected is 'YES' in the form.
	 */

	/**
	 * ------------------------------- Afmsf-1 AnnualMedicalExamination
	 * -------------------------------*
	 */

	public Map<String, Object> showAfmsfAnnualMedicalExaminationjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MisAnnualMedicalExam> annualMedicalExamList = new ArrayList<MisAnnualMedicalExam>();

		try {
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();
			annualMedicalExamList = session
					.createCriteria(MisAnnualMedicalExam.class)
					.add(Restrictions.eq("Status", "y")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("annualMedicalExamList", annualMedicalExamList);

		return map;
	}

	public Map<String, Object> showAfmsfAnnualMedicalExamination(
			String serviceNo) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<EmpAfmsfDet> showList = new ArrayList<EmpAfmsfDet>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MisAnnualMedicalExam> annualMedicalExamList = new ArrayList<MisAnnualMedicalExam>();

		try {

			showList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.EmpAfmsfDet as e where e.AfmsfType='M' and e.ServiceNo='"
							+ serviceNo + "'");

			// if (showList.size() == 0) {
			// employeeList = getHibernateTemplate().find(
			// "from MasEmployee me where me.Id not in (select e.Employee from
			// EmpAfmsfDet e where e.AfmsfType='M')) and
			// me.ServiceNo='"+serviceNo+"'");
			employeeList = getHibernateTemplate().find(
					"from MasEmployee me where me.ServiceNo='" + serviceNo
							+ "'");
			rankList = session.createCriteria(MasRank.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();
			annualMedicalExamList = session
					.createCriteria(MisAnnualMedicalExam.class)
					.add(Restrictions.eq("Status", "y")).list();
			// }
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("annualMedicalExamList", annualMedicalExamList);
		map.put("showList", showList);
		map.put("employeeList", employeeList);
		map.put("serviceNo", serviceNo);
		return map;

	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */

	public Map<String, Object> editAfmsfAnnualMedicalExamination(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String message = "";
		String messageType = "";
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int categoryId = 0;
		int empAfmsfDetId = 0;
		String period = "";
		int ameId = 0;
		Date nextReviewDateDate = null;
		Date ameDateDate = null;
		ameId = Integer.parseInt("" + generalMap.get("ameId"));
		categoryId = Integer.parseInt("" + generalMap.get("categoryId"));
		period = (String) generalMap.get("period");
		if (generalMap.get("ameDate") != null) {
			ameDateDate = HMSUtil.convertStringTypeDateToDateType(""
					+ generalMap.get("ameDate"));
		}
		if (generalMap.get("nextReviewDate") != null) {
			nextReviewDateDate = HMSUtil.convertStringTypeDateToDateType(""
					+ generalMap.get("nextReviewDate"));
		}
		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");
		empAfmsfDetId = Integer.parseInt("" + generalMap.get("empAfmsfDetId"));

		Date currentDateDate = HMSUtil
				.convertStringTypeDateToDateType(currentDate);
		Session session = (Session) getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// if(ameId ==0){
			// AnnualMediacalExamination annualMediacalExamination = new
			// AnnualMediacalExamination();
			//
			// annualMediacalExamination.setNextReview(nextReviewDateDate);
			// annualMediacalExamination.setLastBoard(ameDateDate);
			// annualMediacalExamination.setAfmsfDet(new
			// EmpAfmsfDet(empAfmsfDetId));
			// annualMediacalExamination.setLastChgBy(changedBy);
			// annualMediacalExamination.setLastChgDate(currentDateDate);
			// annualMediacalExamination.setLastChgTime(currentTime);
			// annualMediacalExamination.setStatus("y");
			// annualMediacalExamination.setPeriod(period);
			// hbt.save(annualMediacalExamination);
			// // if(empAfmsfDetId >0 ){
			// // EmpAfmsfDet empAfmsfDet
			// =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId);
			// // empAfmsfDet.setMedicalCategory(new
			// MasMedicalCategory(categoryId));
			// // hbt.update(empAfmsfDet);
			// // }
			// // }else{
			// // AnnualMediacalExamination annualMediacalExamination =
			// (AnnualMediacalExamination)
			// hbt.load(AnnualMediacalExamination.class, ameId);
			// // annualMediacalExamination.setNextReview(nextReviewDateDate);
			// // annualMediacalExamination.setLastBoard(ameDateDate);
			// // //annualMediacalExamination.setAfmsfDet(new
			// EmpAfmsfDet(empAfmsfDetId));
			// // annualMediacalExamination.setLastChgBy(changedBy);
			// // annualMediacalExamination.setLastChgDate(currentDateDate);
			// // annualMediacalExamination.setLastChgTime(currentTime);
			// // annualMediacalExamination.setStatus("y");
			// // annualMediacalExamination.setPeriod(period);
			// // hbt.update(annualMediacalExamination);
			// // if(empAfmsfDetId >0 ){
			// // EmpAfmsfDet empAfmsfDet
			// =(EmpAfmsfDet)hbt.load(EmpAfmsfDet.class, empAfmsfDetId);
			// // empAfmsfDet.setMedicalCategory(new
			// MasMedicalCategory(categoryId));
			// // hbt.update(empAfmsfDet);
			// }
			// }
			transaction.commit();
			message = "Data saved successfully. ";
			messageType = "success";
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			message = "Some problem occurred";
			messageType = "failure";
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("messageType", messageType);
		return map;
	}

	// ------------------------------- Fatal Case Documentation
	// -------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFatalCasejsp(int inpatientid) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MisFatalTracking> misFatalTrackingList = new ArrayList<MisFatalTracking>();

		try {
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientid)).list();
			misFatalTrackingList = session
					.createCriteria(MisFatalTracking.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientid)).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		map.put("inpatientList", inpatientList);
		map.put("misFatalTrackingList", misFatalTrackingList);
		return map;
	}

	/**
	 * editAfmsfSurplus()is used for:- 1) if fetching records from MasEmployee
	 * then enter a new record in EmpAfmsfDet table. 2) else, it is fetching
	 * records from the EmpAfmsfDet table, then update the selected record in
	 * EmpAfmsfDet table. Surplus Status is set to 'S'
	 */

	public boolean editFatalCase(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hospitalId = 0;
		int hinId = 0;
		int inpatientId = 0;
		@SuppressWarnings("unused")
		int misFatalId = 0;
		@SuppressWarnings("unused")
		String adNo = null;
		String postmortem = null;

		String dateOfDeath = null;
		String dateOfPostmortem = null;
		String dateOfConcerned = null;
		String dateOfOpinion = null;
		String dateOfWardMaster = null;
		String dateOfMoWard = null;
		String dateOfHOD = null;
		String dateOfStats = null;
		String dateOfCommandant = null;
		String dateOfSA1 = null;
		String dateOfSA2 = null;
		String dateOfSA3 = null;
		String dateOfSA4 = null;
		String dateOfConcernedCommand = null;
		String dateOfPathology = "";
		String deathRemark = null;
		String postmortemRemark = null;
		String postmortemDateRemark = null;
		String concernedDateRemark = null;
		String opinionDateRemark = null;
		String wardMasterDateRemark = null;
		String wardDateRemark = null;
		String hodDateRemark = null;
		String statsDateRemark = null;
		String commandantDateRemark = null;
		String pathologyDateRemark = null;
		String sa1DateRemark = null;
		String sa2DateRemark = null;
		String sa3DateRemark = null;
		String sa4DateRemark = null;
		String concernedCommandDateRemark = null;

		misFatalId = Integer.parseInt("" + generalMap.get("misFatalId"));
		if (generalMap.get("dateOfDeath") != null) {
			dateOfDeath = (String) generalMap.get("dateOfDeath");
		}
		if (generalMap.get("dateOfPostmortem") != null) {
			dateOfPostmortem = (String) generalMap.get("dateOfPostmortem");
		}
		if (generalMap.get("dateOfConcerned") != null) {
			dateOfConcerned = (String) generalMap.get("dateOfConcerned");
		}
		if (generalMap.get("dateOfOpinion") != null) {
			dateOfOpinion = (String) generalMap.get("dateOfOpinion");
		}
		if (generalMap.get("dateOfWardMaster") != null) {
			dateOfWardMaster = (String) generalMap.get("dateOfWardMaster");
		}
		if (generalMap.get("dateOfMoWard") != null) {
			dateOfMoWard = (String) generalMap.get("dateOfMoWard");
		}
		if (generalMap.get("dateOfHOD") != null) {
			dateOfHOD = (String) generalMap.get("dateOfHOD");
		}
		if (generalMap.get("dateOfStats") != null) {
			dateOfStats = (String) generalMap.get("dateOfStats");
		}
		if (generalMap.get("dateOfCommandant") != null) {
			dateOfCommandant = (String) generalMap.get("dateOfCommandant");
		}
		if (generalMap.get("dateOfSA1") != null) {
			dateOfSA1 = (String) generalMap.get("dateOfSA1");
		}
		if (generalMap.get("dateOfSA2") != null) {
			dateOfSA2 = (String) generalMap.get("dateOfSA2");
		}
		if (generalMap.get("dateOfSA3") != null) {
			dateOfSA3 = (String) generalMap.get("dateOfSA3");
		}
		if (generalMap.get("dateOfSA4") != null) {
			dateOfSA4 = (String) generalMap.get("dateOfSA4");
		}
		if (generalMap.get("dateOfConcernedCommand") != null) {
			dateOfConcernedCommand = (String) generalMap
					.get("dateOfConcernedCommand");
		}
		if (generalMap.get("dateOfPathology") != null) {
			dateOfPathology = (String) generalMap.get("dateOfPathology");
		}

		if (generalMap.get("adNo") != null) {
			adNo = (String) generalMap.get("adNo");
		}
		if (generalMap.get("postmortem") != null) {
			postmortem = (String) generalMap.get("postmortem");
		}
		if (generalMap.get("hospitalId") != null) {
			hospitalId = (Integer) generalMap.get("hospitalId");
		}
		if (generalMap.get("hinId") != null) {
			hinId = (Integer) generalMap.get("hinId");
		}
		if (generalMap.get("inpatientId") != null) {
			inpatientId = (Integer) generalMap.get("inpatientId");
		}

		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");

		deathRemark = (String) generalMap.get("deathRemark");
		postmortemRemark = (String) generalMap.get("postmortemRemark");
		postmortemDateRemark = (String) generalMap.get("postmortemDateRemark");
		concernedDateRemark = (String) generalMap.get("concernedDateRemark");
		opinionDateRemark = (String) generalMap.get("opinionDateRemark");
		wardMasterDateRemark = (String) generalMap.get("wardMasterDateRemark");
		wardDateRemark = (String) generalMap.get("wardDateRemark");
		hodDateRemark = (String) generalMap.get("hodDateRemark");
		statsDateRemark = (String) generalMap.get("statsDateRemark");
		commandantDateRemark = (String) generalMap.get("commandantDateRemark");
		pathologyDateRemark = (String) generalMap.get("pathologyDateRemark");
		sa1DateRemark = (String) generalMap.get("sa1DateRemark");
		sa2DateRemark = (String) generalMap.get("sa2DateRemark");
		sa3DateRemark = (String) generalMap.get("sa3DateRemark");
		sa4DateRemark = (String) generalMap.get("sa4DateRemark");
		concernedCommandDateRemark = (String) generalMap
				.get("concernedCommandDateRemark");

		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MisFatalTracking misFatalTracking = null;
			if (misFatalId == 0) {
				misFatalTracking = new MisFatalTracking();
			} else {
				misFatalTracking = (MisFatalTracking) hbt.load(
						MisFatalTracking.class, misFatalId);
			}
			MasHospital masHospital = new MasHospital();
			Patient patient = new Patient();
			Inpatient inpatient = new Inpatient();

			masHospital.setId(hospitalId);
			patient.setId(hinId);
			inpatient.setId(inpatientId);

			String status = "";
			Date statusDate = null;
			String statusRemarks = "";

			if (generalMap.get("dateOfDeath") != null) {
				misFatalTracking.setDateofDeath(HMSUtil
						.convertStringTypeDateToDateType(dateOfDeath));
				status = "Date of Death";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfDeath);
				statusRemarks = deathRemark;
			}
			if (generalMap.get("dateOfPostmortem") != null) {
				misFatalTracking.setDateofPostRec(HMSUtil
						.convertStringTypeDateToDateType(dateOfPostmortem));
				status = "Date of Postmortem Received";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfPostmortem);
				statusRemarks = postmortemRemark;
			}
			if (generalMap.get("dateOfConcerned") != null) {
				misFatalTracking.setHoSplconceDate(HMSUtil
						.convertStringTypeDateToDateType(dateOfConcerned));
				status = "Documents H/O spl concerned Date";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfConcerned);
				statusRemarks = concernedDateRemark;
			}
			if (generalMap.get("dateOfOpinion") != null) {
				misFatalTracking.setRecSplOpDate(HMSUtil
						.convertStringTypeDateToDateType(dateOfOpinion));
				status = "Received from spl with opinion and Date";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfOpinion);
				statusRemarks = opinionDateRemark;
			}
			if (generalMap.get("dateOfWardMaster") != null) {
				misFatalTracking.setWardMaster(HMSUtil
						.convertStringTypeDateToDateType(dateOfWardMaster));
				status = "Completion of documents by Ward Master and Date";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfWardMaster);
				statusRemarks = wardMasterDateRemark;
			}
			if (generalMap.get("dateOfMoWard") != null) {
				misFatalTracking.setMoicWard(HMSUtil
						.convertStringTypeDateToDateType(dateOfMoWard));
				status = "Signature of MO i/c Ward";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfMoWard);
				statusRemarks = wardDateRemark;
			}
			if (generalMap.get("dateOfHOD") != null) {
				misFatalTracking.setHodPerusal(HMSUtil
						.convertStringTypeDateToDateType(dateOfHOD));
				status = "HOD persual on (Date)";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfHOD);
				statusRemarks = hodDateRemark;
			}
			if (generalMap.get("dateOfStats") != null) {
				misFatalTracking.setStatasWard(HMSUtil
						.convertStringTypeDateToDateType(dateOfStats));
				status = "Date of submission of Stats by Ward Master";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfStats);
				statusRemarks = statsDateRemark;
			}
			if (generalMap.get("dateOfCommandant") != null) {
				misFatalTracking.setCommanRemarks(HMSUtil
						.convertStringTypeDateToDateType(dateOfCommandant));
				status = "Date of submission for remarks of commandant";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfCommandant);
				statusRemarks = commandantDateRemark;
			}
			if (generalMap.get("dateOfPathology") != null) {
				misFatalTracking.setPatologyHead(HMSUtil
						.convertStringTypeDateToDateType(dateOfPathology));
				status = "Date of Dispatch to Senior Advisor Pathology for Persual";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfPathology);
				statusRemarks = pathologyDateRemark;
			}
			if (generalMap.get("dateOfSA1") != null) {
				misFatalTracking.setSeniorAdvisor1(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA1));
				status = " 	Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA1);
				statusRemarks = sa1DateRemark;
			}
			if (generalMap.get("dateOfSA2") != null) {
				misFatalTracking.setSeniorAdvisor2(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA2));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA2);
				statusRemarks = sa2DateRemark;
			}
			if (generalMap.get("dateOfSA3") != null) {
				misFatalTracking.setSeniorAdvisor3(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA3));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA3);
				statusRemarks = sa3DateRemark;
			}
			if (generalMap.get("dateOfSA4") != null) {
				misFatalTracking.setSeniorAdvisor4(HMSUtil
						.convertStringTypeDateToDateType(dateOfSA4));
				status = "Date of Dispatch to Senior Advisor for Persual";
				statusDate = HMSUtil.convertStringTypeDateToDateType(dateOfSA4);
				statusRemarks = sa4DateRemark;
			}
			if (generalMap.get("dateOfConcernedCommand") != null) {
				misFatalTracking
						.setDespatchCommandant(HMSUtil
								.convertStringTypeDateToDateType(dateOfConcernedCommand));
				status = "Date of Dispatch to Concerned Command for Persual";
				statusDate = HMSUtil
						.convertStringTypeDateToDateType(dateOfConcernedCommand);
				statusRemarks = concernedCommandDateRemark;
			}
			if (generalMap.get("currentDate") != null) {
				misFatalTracking.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));
			}
			misFatalTracking.setInpatient(inpatient);

			misFatalTracking.setLatestStatus(status);
			misFatalTracking.setLatestStatusDate(statusDate);
			misFatalTracking.setLatestStatusRemarks(statusRemarks);

			misFatalTracking.setPostmortem(postmortem);
			misFatalTracking.setPostmortemRem(postmortemRemark);
			misFatalTracking.setDateofDeathRem(deathRemark);
			misFatalTracking.setDateofPostRecRem(postmortemDateRemark);
			misFatalTracking.setHoSplconceRem(concernedDateRemark);
			misFatalTracking.setRecSplOpRem(opinionDateRemark);
			misFatalTracking.setWardMasterRem(wardMasterDateRemark);
			misFatalTracking.setMoicWardRem(wardDateRemark);
			misFatalTracking.setHodPerusalRem(hodDateRemark);
			misFatalTracking.setStatasWardRem(statsDateRemark);
			misFatalTracking.setCommanRemarksRem(commandantDateRemark);
			misFatalTracking.setPatologyHeadRem(pathologyDateRemark);
			misFatalTracking.setSeniorAdvisor1Rem(sa1DateRemark);
			misFatalTracking.setSeniorAdvisor2Rem(sa2DateRemark);
			misFatalTracking.setSeniorAdvisor3Rem(sa3DateRemark);
			misFatalTracking.setSeniorAdvisor4Rem(sa4DateRemark);
			misFatalTracking
					.setDespatchCommandantRem(concernedCommandDateRemark);
			misFatalTracking.setLastChgBy(changedBy);
			misFatalTracking.setLastChgTime(currentTime);
			misFatalTracking.setHospital(masHospital);
			misFatalTracking.setHin(patient);

			if (misFatalId == 0) {
				hbt.save(misFatalTracking);
			} else {
				hbt.update(misFatalTracking);
			}
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	// ------------------ Total Admissions Date wise------------

	public Map<String, Object> showTotalAdmissionjsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		try {

			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);

		return map;
	}

	public Map<String, Object> searchTotalAdmission(Date fromDate, Date toDate,
			String serviceType) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		try {

			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);

		int toYear = 1900 + toDate.getYear();
		int fromYear = 1900 + fromDate.getYear();
		int toMonth = toDate.getMonth() + 1;
		int fromMonth = fromDate.getMonth() + 1;
		String dateTo = Integer.toString(toYear) + "-"
				+ Integer.toString(toMonth) + "-"
				+ Integer.toString(toDate.getDate());
		String dateFrom = Integer.toString(fromYear) + "-"
				+ Integer.toString(fromMonth) + "-"
				+ Integer.toString(fromDate.getDate());

		Connection conn = session.connection();
		map.put("conn", conn);

		return map;
	}

	/**
	 * ------------------------------- Total discharge Date Wise
	 * -----------------------
	 */
	public Map<String, Object> showTotalDischargejsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		try {

			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("serviceTypeList", serviceTypeList);
		map.put("disposalList", disposalList);
		return map;
	}

	public Map<String, Object> searchTotalDischarge() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		Connection conn = session.connection();
		map.put("conn", conn);

		return map;
	}

	// --------------------------- Monthly Sick Report
	// ---------------------------
	public Map<String, Object> showMonthlySickReportsjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
					.add(Restrictions.eq("Status", "y")).list();
			masUnitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("rankCategoryList", rankCategoryList);
		map.put("masUnitList", masUnitList);
		return map;

	}

	/**
	 * ---------------------- Monthly Sick Discharge Report
	 * --------------------------
	 */
	public Map<String, Object> showMonthlySickDischargeReportjsp() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();

		try {
			rankCategoryList = session.createCriteria(MasRankCategory.class)
					.add(Restrictions.eq("Status", "y")).list();
			masUnitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("rankCategoryList", rankCategoryList);
		map.put("masUnitList", masUnitList);
		return map;
	}

	/**
	 * ---------------------- Fatal Document Panchnama
	 * --------------------------
	 */
	@SuppressWarnings("unchecked")
	public List getAdmissionNoList(Map<String, Object> detailsMap) {
		String serviceNo = "";
		String hinNo = "";
		String fatalCase = "";
		String onlyReport = "";
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("fatalCase") != null) {
			fatalCase = (String) detailsMap.get("fatalCase");
		}
		if (detailsMap.get("onlyReport") != null) {
			onlyReport = (String) detailsMap.get("onlyReport");
		}
		List<Object> inpatientList = new ArrayList<Object>();

		try {
			if (!serviceNo.equals("")) {
				inpatientList = session.createQuery(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
								+ serviceNo + "'").list();
			}
			if (!hinNo.equals("")) {
				inpatientList = session.createQuery(
						"from Inpatient ip join ip.Hin as p where  p.HinNo = '"
								+ hinNo + "'").list();

			}
			if (!fatalCase.equals("")) {
				inpatientList = session.createQuery(
						"from ExpiryDetails e join e.Hin as p where p.HinNo = '"
								+ hinNo + "'").list();
			}
			// if(!onlyReport.equals("")){
			// inpatientList = getHibernateTemplate().find(
			// "from Birthdeathreg bd join bd.Hin as p where p.HinNo = '"
			// + hinNo + "'");
			// }
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	public Map<String, Object> getDBConnection() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;
	}

	/**
	 * -------------------------------- FRW CASES
	 * -------------------------------
	 *
	 * @return
	 */

	public Map<String, Object> showFrwCasesJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> serviceNoList = new ArrayList<Patient>();
		List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
		try {
			serviceNoList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("Status", "y")).list();
			disposalList = session.createCriteria(MasDisposal.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("serviceNoList", serviceNoList);
		map.put("disposalList", disposalList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showFrwCases() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDisposedTo> disposalToList = new ArrayList<MasDisposedTo>();
		disposalToList = session.createCriteria(MasDisposedTo.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("disposalToList", disposalToList);
		return map;
	}

	public Map<String, Object> submitFrwCases(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hinId = 0;
		int disposalId = 0;
		Date frwDate = new Date();
		String to = null;
		String toClass = null;
		String frwSerialNo = "";
		String por = null;
		String message = "";
		String messageType = "";
		String otherHospital = "";
		String sickleave = "";
		Date fromDate = null;
		Date toDate = null;
		String review = null;

		hinId = (Integer) generalMap.get("hinId");
		disposalId = (Integer) generalMap.get("disposalId");
		frwDate = (Date) generalMap.get("frwDate");
		fromDate = (Date) generalMap.get("fromDate");
		toDate = (Date) generalMap.get("toDate");
		to = (String) generalMap.get("to");
		toClass = (String) generalMap.get("toClass");
		frwSerialNo = "" + generalMap.get("frwSerialNo");
		por = (String) generalMap.get("por");
		if (generalMap.get("otherHospital") != null) {
			otherHospital = (String) generalMap.get("otherHospital");
		}

		if (generalMap.get("sickLeave") != null) {
			sickleave = (String) generalMap.get("sickLeave");
		}


		if (generalMap.get("review") != null) {
			review = (String) generalMap.get("review");
		}

		Session session = (Session) getSession();
		List<Inpatient> misFrwList = new ArrayList<Inpatient>();
		misFrwList = session.createCriteria(MisFrw.class)
				.add(Restrictions.eq("Hin.Id", hinId)).list();

		try {
			if (misFrwList.size() == 0) {
				HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				MisFrw misFrw = new MisFrw();
				Patient patient = new Patient();
				MasDisposedTo masDisposed = new MasDisposedTo();
				masDisposed.setId(disposalId);
				misFrw.setDisposedTo(masDisposed);
				patient.setId(hinId);
				misFrw.setHin(patient);
				misFrw.setFrwDate(frwDate);
				misFrw.setToDesc(to);
				misFrw.setToClass(toClass);
				misFrw.setFrwSerialNo(frwSerialNo);
				misFrw.setPor(por);
				misFrw.setOtherHospital(otherHospital);
				misFrw.setSickleave(sickleave);
				misFrw.setReview(review);
				misFrw.setFromdate(fromDate);
				misFrw.setTodate(toDate);
				hbt.save(misFrw);
				message = "FRW details Saved Successfully.Do want to print";
				messageType = "success";
			} else {
				message = "FRW details Already exists.Do want to print";
				messageType = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("messageType", messageType);
		return map;
	}

	/**
	 * -------------------- NOTIFIABLE DISEASE ENTRY FORM ------------
	 */

	public Map<String, Object> showNotifiableDiseaseJsp(
			Map<String, Object> generalMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		// List<Object> showList = new ArrayList<Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		// int inpatientId=0;
		// inpatientId=(Integer)generalMap.get("inpatientId");
		// String adNo=null;
		// adNo=(String) generalMap.get("adNo");
		try {

			// showList = getHibernateTemplate().find("from Inpatient ip join
			// ip.Hin as p join p.Unit as u join p.Rank as r " +
			// "where ip.Id='"+ inpatientId + "'");
			diagnosisList = session.createCriteria(MasIcd.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		// map.put("showList", showList);

		map.put("diagnosisList", diagnosisList);
		return map;

	}

	public Map<String, Object> showNotifiableDisease(
			Map<String, Object> generalMap) {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		String adNo = null;
		adNo = (String) generalMap.get("adNo");
		try {

			showList = getHibernateTemplate()
					.find("from Inpatient ip join ip.Hin as p left join p.Unit as u left join p.Rank as r "
							+ "where ip.Id='" + inpatientId + "'");
			diagnosisList = session.createCriteria(MasIcd.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("showList", showList);

		map.put("diagnosisList", diagnosisList);
		return map;

	}

	public boolean editNotifiableDisease(Map<String, Object> generalMap) {
		boolean dataUpdated = false;
		String currentDate = null;
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		@SuppressWarnings("unused")
		int hospitalId = 0;
		int hinId = 0;
		int basisOfDiagnosis = 0;
		int inpatientId = 0;

		String adNo = null;
		String postmortem = null;

		Date dateOfOnset = new Date();
		Date dateOfReportingSick = new Date();
		Date dateOfPreventive = new Date();
		Date dateOfNotifiable = new Date();

		String designation = null;
		String suspectedSource = null;
		String measuresOfControl = null;
		String contact = null;
		String generalRemarks = null;
		String station = null;

		dateOfOnset = (Date) generalMap.get("dateOfOnset");
		dateOfReportingSick = (Date) generalMap.get("dateOfReportingSick");
		dateOfPreventive = (Date) generalMap.get("dateOfPreventive");
		dateOfNotifiable = (Date) generalMap.get("dateOfNotifiable");
		basisOfDiagnosis = (Integer) generalMap.get("basisOfDiagnosis");
		designation = (String) generalMap.get("designation");
		suspectedSource = (String) generalMap.get("suspectedSource");
		measuresOfControl = (String) generalMap.get("measuresOfControl");
		contact = (String) generalMap.get("contact");
		generalRemarks = (String) generalMap.get("generalRemarks");
		station = (String) generalMap.get("station");

		inpatientId = (Integer) generalMap.get("inpatientId");
		hospitalId = (Integer) generalMap.get("hospitalId");
		hinId = (Integer) generalMap.get("hinId");

		currentDate = (String) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		changedBy = (String) generalMap.get("changedBy");

		try {
			HibernateTemplate hbt = getHibernateTemplate();
			// hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			MisNotifiable misNotifiable = new MisNotifiable();
			MasHospital masHospital = new MasHospital();
			Patient patient = new Patient();
			MasIcd icd = new MasIcd();
			Inpatient inpatient = new Inpatient();

			icd.setId(basisOfDiagnosis);
			masHospital.setId(hospitalId);
			patient.setId(hinId);
			inpatient.setId(inpatientId);

			misNotifiable.setNotifiableDate(dateOfNotifiable);
			misNotifiable.setDateOnSetDate(dateOfOnset);
			misNotifiable.setDateOfReportingSick(dateOfReportingSick);
			misNotifiable.setDateOfPreventive(dateOfPreventive);
			misNotifiable.setDesignationOfQuaters(designation);
			misNotifiable.setIcd(icd);
			misNotifiable.setSuspectedSource(suspectedSource);
			misNotifiable.setMeasuresOfControl(measuresOfControl);
			misNotifiable.setContact(contact);
			misNotifiable.setGeneralRemarks(generalRemarks);

			misNotifiable.setLastChgBy(changedBy);
			misNotifiable.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(currentDate));
			misNotifiable.setLastChgTime(currentTime);

			misNotifiable.setHospital(masHospital);
			misNotifiable.setHin(patient);
			misNotifiable.setInpatient(inpatient);

			hbt.saveOrUpdate(misNotifiable);
			dataUpdated = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/**
	 * -------------------- NOTIFIABLE DISEASE REPORT ------------
	 */

	public Map<String, Object> showNotifiableDiseaseReportJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> diagnosisList = new ArrayList<MasIcd>();
		try {

			diagnosisList = session.createCriteria(MasIcd.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("diagnosisList", diagnosisList);
		return map;

	}

	/**
	 * -------------------- MALARIA CASE REPORT ------------
	 */

	public Map<String, Object> showMalariaCaseReportJsp() {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasIcd> icdCodeList = new ArrayList<MasIcd>();
		try {

			icdCodeList = session.createCriteria(MasIcd.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("icdCodeList", icdCodeList);
		return map;

	}

	// ------------------------Daily Bed Status---------------------------------
	public Map<String, Object> showDailyBedStatusReport() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y")).list();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		java.sql.Connection con = session.connection();
		map.put("departmentList", departmentList);
		map.put("con", con);
		return map;
	}

	public Map<String, Object> showBedStatisticsSummary() {
		Session session = (Session) getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		java.sql.Connection con = session.connection();
		map.put("con", con);
		String sql = "{call p_bedStats('2008-05-09')}";
		try {
			CallableStatement cals = con.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
		searchBirthList = session.createQuery("from jkt.hms.masters.business.Birthdeathreg ").list();
		birthList = session.createQuery("from Birthdeathreg as bdr where bdr.Bdtype='b' order by bdr.Id desc").list();
		if(birthList.size()>0){
			birthNo=birthList.get(0).getBirthCertificateNo();
			birthNo=birthNo+1;
		}else{
			birthNo=1;
		}
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
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		/*String lastChgBy = "";
		String regNo = "";
		String patientName = "";
		String motherName = "";
		String fatherName = "";
		Date dob = new Date();
		Date dor = new Date();
		String gender = "";
		Date currentDate = new Date();
		String currentTime = "";
		int hospitalId = 0;
		int sexId = 0;
		int employeeId = 0;
		String hintNo = "";
		int hintId = 0;
		int noOfCopies = 0;
		int amount = 0;
		*/
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
			birthList = session.createQuery("from Birthdeathreg as ip where ip.Inpatient.Id='"
					+ inpatientId + "' and ip.Bdtype='b'").list();

			Transaction transaction = null;
			if (birthList.size() == 0) {
				/*inpatientId = (Integer) generalMap.get("inpatientId");
			noOfCopies = (Integer) generalMap.get("noOfCopies");
			amount = (Integer) generalMap.get("amount");
			patientName = (String) generalMap.get("patientName");
			motherName = (String) generalMap.get("motherName");
			fatherName = (String) generalMap.get("fatherName");
			currentTime = (String) generalMap.get("currentTime");
			currentDate = (Date) generalMap.get("currentDate");
			lastChgBy = (String) generalMap.get("lastChgBy");
			dob = (Date) generalMap.get("dob");
			dor = (Date) generalMap.get("dor");
			gender = (String) generalMap.get("gender");
			regNo = (String) generalMap.get("regNo");
			hospitalId = (Integer) generalMap.get("hospitalId");
			hintNo = (String) generalMap.get("hintNo");
			hintId = (Integer) generalMap.get("hintId");
			sexId = (Integer) generalMap.get("sexId");
			employeeId = (Integer) generalMap.get("employeeId");*/

				int birthCertificateNo=0;
				try {
					transaction = session.beginTransaction();
					/*hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					*/
					List<Birthdeathreg> tempBirthDeathList=new ArrayList<Birthdeathreg>();
					tempBirthDeathList = session.createQuery("from Birthdeathreg as bdr where bdr.Bdtype='d' order by bdr.Id desc").list();
					if(tempBirthDeathList.size()>0){
						birthCertificateNo=tempBirthDeathList.get(0).getBirthCertificateNo();
						birthCertificateNo=birthCertificateNo+1;
					}else{
						birthCertificateNo=1;
					}
					Birthdeathreg birthdeathreg = new Birthdeathreg();
					if(generalMap.get("birthdeathreg")!=null){
						birthdeathreg = (Birthdeathreg)generalMap.get("birthdeathreg");
					}
					/*birthdeathreg.setBdtype("b");
				birthdeathreg.setDob(dob);
				birthdeathreg.setDor(dor);
				birthdeathreg.setName(patientName);
				birthdeathreg.setFname(fatherName);
				birthdeathreg.setMname(motherName);
				birthdeathreg.setRegno(regNo);
				birthdeathreg.setLastChgBy(lastChgBy);
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

				MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
				masAdministrativeSex1.setId(sexId);
				birthdeathreg.setAdministrativeSex(masAdministrativeSex1);
					 */
					birthdeathreg.setBirthCertificateNo(birthCertificateNo);
					birthdeathreg.setRegno(""+birthCertificateNo);
					session.save(birthdeathreg);

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
		List<Patient> fatherList = new ArrayList<Patient>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		String motherName = "";
		String fatherName = "";
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		String hinNo = "";
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
						hinNo = inpatient.getHin().getHinNo();
						counter++;
					}
				}
				if (!hinNo.equals("")) {
					motherList = session.createQuery(
							"from Patient where HinNo='" + hinNo
									+ "' and Relation.Id=3").list();
					fatherList =session.createQuery(
							"from Patient where HinNo='" + hinNo
									+ "' and Relation.Id=2").list();
				}
				if (motherList.size() > 0) {
					for (Patient patient : motherList) {
						motherName = "" + patient.getPFirstName() + " "
								+ patient.getPMiddleName() + " "
								+ patient.getPLastName();
					}
				}
				if (fatherList.size() > 0) {
					for (Patient patient2 : fatherList) {
						fatherName = "" + patient2.getPFirstName() + " "
								+ patient2.getPMiddleName() + " "
								+ patient2.getPLastName();
					}
				}
				map.put("fatherName", fatherName);
				map.put("motherName", motherName);
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
		map.put("empAfmsfDetList", empAfmsfDetList);
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List<Object> getMotherHin(String serviceNo) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> motherHinList = new ArrayList<Object>();
		try {
			motherHinList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();

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

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> generateRegNumber(Map<String, Object> regMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String regNo = "";
		String bOrD = "";
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		String year = (String) regMap.get("year");
		Session session = (Session) getSession();
		if (regMap.get("bOrD") != null) {
			bOrD = "" + regMap.get("bOrD");
		}
		try {
			if (bOrD.equals("birth")) {
				regList = session.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "BC")).list();
			} else if (bOrD.equals("death")) {
				regList = session.createCriteria(TransactionSequence.class)
						.add(Restrictions.eq("TransactionPrefix", "DC")).list();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo = 0;
		int yearTemp = 0;
		if (regList.size() > 0) {
			for (TransactionSequence transactionSequence : regList) {
				seqNo = transactionSequence.getTransactionSequenceNumber();
				yearTemp = Integer
						.parseInt("" + transactionSequence.getMonth());

			}
			if (year.equals("" + yearTemp)) {
				seqNo++;
				regNo = String.valueOf(seqNo).concat("/");
				regNo = regNo.concat(year);
			} else {
				seqNo = 1;
				try {
					TransactionSequence transactionSequence = (TransactionSequence) hbt
							.load(TransactionSequence.class, 16);
					transactionSequence.setMonth(Integer.parseInt("" + year));
					hbt.update(transactionSequence);
					TransactionSequence transactionSequence2 = (TransactionSequence) hbt
							.load(TransactionSequence.class, 7);
					transactionSequence2.setMonth(Integer.parseInt("" + year));
					hbt.update(transactionSequence2);
				} catch (Exception e) {
					e.printStackTrace();
				}
				regNo = String.valueOf(seqNo).concat("/");
				regNo = regNo.concat(year);
			}

		} else if (regList.size() == 0) {
			seqNo = 1;
			regNo = String.valueOf(seqNo).concat("/");
			regNo = regNo.concat(year);
		}
		map.put("regNo", regNo);
		map.put("serNo", seqNo);
		return map;
	}

	public Map<String, Object> showUpdateBirthCertificate(
			Map<String, Object> map) {
		String birthCertificateNo = null;
		List<Object> birthList = new ArrayList<Object>();
		birthCertificateNo = (String) map.get("birthCertificateNo");
		Session session = (Session) getSession(true);
		try {
			birthList = session.createQuery(
					"from Birthdeathreg as b where b.BirthCertificateNo=" + birthCertificateNo
							+ " and Bdtype='b'").list();
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
		map.put("birthList", birthList);
		return map;
	}

	// --------------------Death
	// Certificate---------------------------------------

	public Map<String, Object> showDeathCertificateJsp() {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Birthdeathreg> searchDeathList = new ArrayList<Birthdeathreg>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		searchDeathList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.Birthdeathreg ");
		map.put("searchDeathList", searchDeathList);
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> showDeath(int inpatientId) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> showList = new ArrayList<Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<Object> expiryList = new ArrayList<Object>();
		String Expired = "";
		String hinNo = "";
		int expiredHinNo = 0;
		List<Patient> motherList = new ArrayList<Patient>();
		List<Patient> fatherList = new ArrayList<Patient>();
		String motherName = "";
		String fatherName = "";
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y")).list();
			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inpatientId)).list();


		if (inpatientList.size() > 0) {
			if (inpatientList != null) {
				for (Inpatient inpatient : inpatientList) {
					hinNo = inpatient.getHin().getHinNo();
				}
			}
			if (!hinNo.equals("")) {
				motherList = session.createQuery(
						"from Patient where HinNo='" + hinNo
								+ "' and Relation.Id=3").list();
				fatherList = session.createQuery(
						"from Patient where HinNo='" + hinNo
								+ "' and Relation.Id=2").list();
			}
			if (motherList.size() > 0) {
				for (Patient patient : motherList) {
					motherName = "" + patient.getPFirstName() + " "
							+ patient.getPMiddleName() + " "
							+ patient.getPLastName();
				}
			}
			if (fatherList.size() > 0) {
				for (Patient patient2 : fatherList) {
					fatherName = "" + patient2.getPFirstName() + " "
							+ patient2.getPMiddleName() + " "
							+ patient2.getPLastName();
				}
			}
		}
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
		map.put("fatherName", fatherName);
		map.put("motherName", motherName);
		map.put("inpatientList", inpatientList);
		map.put("employeeList", employeeList);

		return map;
	}

	public List<Object> getExpiredHin(String hinNo) {
		Session session = (Session) getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> expiredHinNo = new ArrayList<Object>();
		try {

			expiredHinNo = getHibernateTemplate().find(
					"from Patient where HinNo='" + hinNo
							+ "' and PatientStatus='Expired'");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("expiredHinNo", expiredHinNo);
		return expiredHinNo;

	}

	public Map<String, Object> addDeathCertificate(
			Map<String, Object> generalMap) {
		List<Birthdeathreg> deathList = new ArrayList<Birthdeathreg>();
		Map<String, Object> map = new HashMap<String, Object>();
		String messageType = "";
		String isRecordAlreadyExists = "";
		Session session = (Session) getSession();
		/*org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		*/String regNo = "";
		int inpatientId = 0;
		inpatientId = (Integer) generalMap.get("inpatientId");
		/*String patientName = "";
		String motherName = "";
		String fatherName = "";
		String addressDeath = "";
		String addressPermanent = "";
		String remarks = "";
		Date issueDate = new Date();
		Date dod = new Date();
		Date dor = new Date();
		String gender = "";
		String lastChgBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		int hospitalId = 0;
		int sexId = 0;
		int employeeId = 0;
		int noOfCopies = 0;
		int amount = 0;
		String hintNo = "";
		int hintId = 0;
		*/
		int serNo = 0;
		String time = "";
		if (generalMap.get("serNo") != null) {
			serNo = Integer.parseInt("" + generalMap.get("serNo"));
		}
		if (generalMap.get("time") != null) {
			time = ("" + generalMap.get("time"));
		}
		List<Birthdeathreg> tempBirthDeathList=new ArrayList<Birthdeathreg>();
		int birthCertificateNo=0;
		if (deathList.size() == 0) {

			Birthdeathreg birthdeathreg = new Birthdeathreg();
			if(generalMap.get("birthdeathreg")!=null){
				birthdeathreg = (Birthdeathreg)generalMap.get("birthdeathreg");
			}

			inpatientId = (Integer) generalMap.get("inpatientId");
			/*
			 * patientName = (String) generalMap.get("patientName");
			noOfCopies = (Integer) generalMap.get("noOfCopies");
			amount = (Integer) generalMap.get("amount");
			gender = (String) generalMap.get("gender");
			sexId = (Integer) generalMap.get("sexId");
			dod = (Date) generalMap.get("dod");
			motherName = (String) generalMap.get("motherName");
			fatherName = (String) generalMap.get("fatherName");
			addressPermanent = (String) generalMap.get("addressPermanent");
			addressDeath = (String) generalMap.get("addressDeath");
			regNo = (String) generalMap.get("regNo");
			dor = (Date) generalMap.get("dor");
			remarks = (String) generalMap.get("remarks");
			issueDate = (Date) generalMap.get("issueDate");
			currentTime = (String) generalMap.get("currentTime");
			currentDate = (Date) generalMap.get("currentDate");
			lastChgBy = (String) generalMap.get("lastChgBy");
			hospitalId = (Integer) generalMap.get("hospitalId");
			hintNo = (String) generalMap.get("hintNo");
			hintId = (Integer) generalMap.get("hintId");
			employeeId = (Integer) generalMap.get("employeeId");
*/
			Transaction transaction = null;
			try {
				deathList = session.createQuery("from Birthdeathreg as ip where ip.Inpatient.Id='"
						+ inpatientId + "' and ip.Bdtype='d'").list();
		tempBirthDeathList = session.createQuery("from Birthdeathreg as bdr where bdr.Bdtype='d' order by bdr.Id desc").list();
		if(tempBirthDeathList.size()>0){
			Birthdeathreg birthdeathreg2=new Birthdeathreg();
			if(tempBirthDeathList.get(0)!=null){
				birthdeathreg2=(Birthdeathreg)tempBirthDeathList.get(0);
				birthCertificateNo=birthdeathreg2.getBirthCertificateNo();
				birthCertificateNo=birthCertificateNo+1;
			}else{
				birthCertificateNo=1;
			}

		}else{
			birthCertificateNo=1;
		}
				transaction = session.beginTransaction();
				/*hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);*/
				/*Birthdeathreg birthdeathreg = new Birthdeathreg();
				birthdeathreg.setBdtype("d");

				birthdeathreg.setName(patientName);

				MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
				masAdministrativeSex1.setId(sexId);
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					birthdeathreg.setEmp(masEmployee);
				}
				birthdeathreg.setAdministrativeSex(masAdministrativeSex1);

				birthdeathreg.setFname(fatherName);
				birthdeathreg.setMname(motherName);
				birthdeathreg.setAddressDeath(addressDeath);
				birthdeathreg.setAddressPermanent(addressPermanent);
				birthdeathreg.setRegno(regNo);
				birthdeathreg.setDob(dod);
				birthdeathreg.setDor(dor);
				birthdeathreg.setRemarks(remarks);
				birthdeathreg.setDateOfIssue(issueDate);
				birthdeathreg.setLastChgBy(lastChgBy);
				birthdeathreg.setLastChgDate(currentDate);
				birthdeathreg.setLastChgTime(currentTime);
				birthdeathreg.setAmount(amount);
				birthdeathreg.setNoOfCopies(noOfCopies);
				birthdeathreg.setTime(time);
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				birthdeathreg.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setHinNo(hintNo);
				birthdeathreg.setHin(patient);

				Patient patient1 = new Patient();
				patient1.setId(hintId);
				birthdeathreg.setHin(patient1);

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				birthdeathreg.setInpatient(inpatient);*/
				birthdeathreg.setBirthCertificateNo(birthCertificateNo);
				birthdeathreg.setRegno(""+birthCertificateNo);
				session.save(birthdeathreg);

				// -----------------don't delete, this is for death certificate
				// TransactionSequence transactionSequence
				// =(TransactionSequence) hbt.load(TransactionSequence.class,
				// 16);
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
			}//finally{
				/**
				 * session.close() is done By Mukesh Narayan Singh
				 * Date 28 Sep 2010
				 */
				/*if(session!=null){
					session.close();
				}
			}*/
			isRecordAlreadyExists = "Information saved Successfully. Death Certificate No is < "+birthCertificateNo+ " >. Do you want to print Death Certificate?";
			messageType = "success";
			map.put("deathList", deathList);

		} else {
			messageType = "failure";
			isRecordAlreadyExists = "Death Certificate Already Exists.Do you want to print Death Certificate?";

		}
		map.put("isRecordAlreadyExists", isRecordAlreadyExists);
		map.put("messageType", messageType);
		return map;
	}

	public boolean submitUpdateBirthCertificate(Map<String, Object> generalMap) {
		int birthDeathId = 0;
		String patientName;
		String motherName;
		String fatherName;
		String remarks;
		Date dor;
		String lastChgBy;
		Date lastChgDate;
		String lastChgTime;
		Date dod = null;
		int amount = 0;
		int noOfCopies = 0;
		int empId = 0;
		boolean dataUpdated = false;
		String time = "";
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		birthdeathreg = (Birthdeathreg) generalMap.get("birthdeathreg");
		birthDeathId = (Integer) generalMap.get("birthDeathId");
		patientName = (String) generalMap.get("patientName");
		motherName = (String) generalMap.get("motherName");
		fatherName = (String) generalMap.get("fatherName");
		remarks = (String) generalMap.get("remarks");
		dor = (Date) generalMap.get("dor");
		lastChgBy = (String) generalMap.get("lastChgBy");
		lastChgDate = (Date) generalMap.get("currentDate");
		lastChgTime = (String) generalMap.get("currentTime");
		amount = Integer.parseInt("" + generalMap.get("amount"));
		noOfCopies = Integer.parseInt("" + generalMap.get("noOfCopies"));
		dod = (Date) generalMap.get("dod");
		time = "" + generalMap.get("time");

		/*HibernateTemplate hbt = getHibernateTemplate();
		hbt.setCheckWriteOperations(false);
		hbt.setFlushModeName("FLUSH_EAGER");*/
		Transaction transaction = null;
		Session session = (Session) getSession();
		String addressPermanent = "";
		addressPermanent = (String) generalMap.get("addressPermanent");

		try {
			transaction = session.beginTransaction();
			birthdeathreg = (Birthdeathreg) session.load(Birthdeathreg.class,birthDeathId);
			birthdeathreg.setName(patientName);
		/*	birthdeathreg.setMname(motherName);
			birthdeathreg.setFname(fatherName);
			birthdeathreg.setRemarks(remarks);*/
			birthdeathreg.setAddressPermanent(addressPermanent);
			birthdeathreg.setDor(dor);
			birthdeathreg.setDod(dod);
		//	birthdeathreg.setLastChgBy(lastChgBy);
			birthdeathreg.setLastChgDate(lastChgDate);
			birthdeathreg.setLastChgTime(lastChgTime);
			birthdeathreg.setAmount(amount);
			birthdeathreg.setNoOfCopies(noOfCopies);
			birthdeathreg.setTime(time);

			Birthdeathreg birthdeathregBackup=new Birthdeathreg();
			if(generalMap.get("birthdeathregBackup")!=null){
				birthdeathregBackup=(Birthdeathreg)generalMap.get("birthdeathregBackup");
				birthdeathreg.setAntenatalCheckup(birthdeathregBackup.getAntenatalCheckup());
				birthdeathreg.setDateOfAdmOfMother(birthdeathregBackup.getDateOfAdmOfMother());
				birthdeathreg.setBabyDeliveryDate(birthdeathregBackup.getBabyDeliveryDate());
				birthdeathreg.setBabyDeliveryTime(birthdeathregBackup.getBabyDeliveryTime());
				birthdeathreg.setDeliveryType(birthdeathregBackup.getDeliveryType());

				birthdeathreg.setBabyStatus(birthdeathregBackup.getBabyStatus());
				birthdeathreg.setCry(birthdeathregBackup.getCry());

				birthdeathreg.setColor(birthdeathregBackup.getColor());
				birthdeathreg.setResuscitatino(birthdeathregBackup.getResuscitatino());
				birthdeathreg.setAnyCongAbnormality(birthdeathregBackup.getAnyCongAbnormality());
				birthdeathreg.setApgarScoreAtBirth(birthdeathregBackup.getApgarScoreAtBirth());

				birthdeathreg.setBirthWeight(birthdeathregBackup.getBirthWeight());
				birthdeathreg.setFinalDiagnosis(birthdeathregBackup.getFinalDiagnosis());
				birthdeathreg.setDischargeDate(birthdeathregBackup.getDischargeDate());
				birthdeathreg.setConditionAtdischarge(birthdeathregBackup.getConditionAtdischarge());
			}
			session.saveOrUpdate(birthdeathreg);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
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

		dataUpdated = true;
		return dataUpdated;
	}

	public boolean submitUpdateDeathCertificate(Map<String, Object> generalMap) {
		int birthDeathId = 0;
		String patientName;
		/*String motherName;
		String fatherName;
		String remarks;
		Date dor;*/
		Date dod;
		String lastChgBy;
		Date lastChgDate;
		String lastChgTime;

		/*String addressDeath = "";
		String addressPermanent = "";
		*/boolean dataUpdated = false;
		/*int amount = 0;
		int noOfCopies = 0;
		*/String time = "";
		Birthdeathreg birthdeathreg = new Birthdeathreg();
		birthdeathreg = (Birthdeathreg) generalMap.get("birthdeathreg");
		birthDeathId = (Integer) generalMap.get("birthDeathId");
		patientName = (String) generalMap.get("patientName");

		String immediateCause="";
		String antecedentCause="";
		String otherSignificantCondition="";
		String deliveryType="";
		String injuryOccur="";
		String deceasedFemalePregnancyDelivery="";
		String deceasedFemalePregnancyDeath="";
		if(generalMap.get("immediateCause")!=null){
			immediateCause=(String)generalMap.get("immediateCause");
		}
		if(generalMap.get("antecedentCause")!=null){
			antecedentCause=(String)generalMap.get("antecedentCause");
		}
		if(generalMap.get("otherSignificantCondition")!=null){
			otherSignificantCondition=(String)generalMap.get("otherSignificantCondition");
		}
		if(generalMap.get("deliveryType")!=null){
			deliveryType=(String)generalMap.get("deliveryType");
		}
		if(generalMap.get("injuryOccur")!=null){
			injuryOccur=(String)generalMap.get("injuryOccur");
		}
		if(generalMap.get("deceasedFemalePregnancyDelivery")!=null){
			deceasedFemalePregnancyDelivery=(String)generalMap.get("deceasedFemalePregnancyDelivery");
		}
		if(generalMap.get("deceasedFemalePregnancyDeath")!=null){
			deceasedFemalePregnancyDeath=(String)generalMap.get("deceasedFemalePregnancyDeath");
		}
		/*motherName = (String) generalMap.get("motherName");
		fatherName = (String) generalMap.get("fatherName");
		remarks = (String) generalMap.get("remarks");
		dor = (Date) generalMap.get("dor");
		*/dod = (Date) generalMap.get("dod");
		lastChgBy = (String) generalMap.get("lastChgBy");
		lastChgDate = (Date) generalMap.get("currentDate");
		lastChgTime = (String) generalMap.get("currentTime");
		/*addressDeath = (String) generalMap.get("addressDeath");
		addressPermanent = (String) generalMap.get("addressPermanent");
*/
		/*amount = (Integer) generalMap.get("amount");
		noOfCopies = (Integer) generalMap.get("noOfCopies");
		*/time = "" + generalMap.get("time");
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		Session session = (Session) getSession();
		Transaction tx = session.beginTransaction();
		try {
			birthdeathreg = (Birthdeathreg) hbt.load(Birthdeathreg.class,
					birthDeathId);
			birthdeathreg.setName(patientName);
			birthdeathreg.setImmediateCause(immediateCause);
			birthdeathreg.setAntecedentCause(antecedentCause);
			birthdeathreg.setOtherSignificantCondition(otherSignificantCondition);
			birthdeathreg.setDeliveryType(deliveryType);
			birthdeathreg.setInjuryOccur(injuryOccur);
			birthdeathreg.setDeceasedFemalePregnancyDelivery(deceasedFemalePregnancyDelivery);
			birthdeathreg.setDeceasedFemalePregnancyDeath(deceasedFemalePregnancyDeath);

			/*birthdeathreg.setMname(motherName);
			birthdeathreg.setFname(fatherName);
			birthdeathreg.setRemarks(remarks);
			birthdeathreg.setDor(dor);*/
		//	birthdeathreg.setLastChgBy(lastChgBy);
			birthdeathreg.setLastChgDate(lastChgDate);
			birthdeathreg.setLastChgTime(lastChgTime);
			/*birthdeathreg.setAddressDeath(addressDeath);
			birthdeathreg.setAddressPermanent(addressPermanent);*/
			birthdeathreg.setDod(dod);
			/*birthdeathreg.setAmount(amount);
			birthdeathreg.setNoOfCopies(noOfCopies);*/
			birthdeathreg.setBabyDeliveryTime(time);
			hbt.update(birthdeathreg);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
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

		dataUpdated = true;
		return dataUpdated;
	}

	public Map<String, Object> showUpdateDeathCertificate(
			Map<String, Object> map) {
		String regNo = null;
		List<Object> deathList = new ArrayList<Object>();
		Session session = (Session) getSession();
		regNo = (String) map.get("regNo");
		try {
			deathList = session.createQuery(
					"from Birthdeathreg as b where b.BirthCertificateNo='" + regNo
							+ "' and Bdtype='d'").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("deathList", deathList);
		return map;
	}

	public Map<String, Object> showBedStatisticsDetailReport(
			Map<String, Object> generalap) {
		List showList = new ArrayList();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		java.util.Date utilFromDate = (java.util.Date) generalap
				.get("fromDate");
		java.util.Date utilToDate = (java.util.Date) generalap.get("toDate");

		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(utilFromDate);
		calTo.setTime(utilToDate);

		java.sql.Date sqlFromDate = new java.sql.Date(calFrom.getTime()
				.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(calTo.getTime().getTime());

		/*
		 * java.sql.Date sqlToDate = java.sql.Date.valueOf((String)
		 * map.get("toDate"));
		 */

		try {
			CallableStatement calstmt = conn
					.prepareCall("{call proc_to_from(?,?)}");

			calstmt.setDate("from_date", sqlFromDate);
			calstmt.setDate("to_date", sqlToDate);
			calstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> showIIBedStateReport(
			Map<String, Object> generalap) {
		List showList = new ArrayList();
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		java.util.Date utilFromDate = (java.util.Date) generalap
				.get("fromDate");
		java.util.Date utilToDate = (java.util.Date) generalap.get("toDate");

		Calendar calFrom = Calendar.getInstance();
		Calendar calTo = Calendar.getInstance();
		calFrom.setTime(utilFromDate);
		calTo.setTime(utilToDate);

		java.sql.Date sqlFromDate = new java.sql.Date(calFrom.getTime()
				.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(calTo.getTime().getTime());

		try {
			CallableStatement calstmt = conn
					.prepareCall("{call p_IIBedState(?,?)}");

			calstmt.setDate("from_date", sqlFromDate);
			calstmt.setDate("to_date", sqlToDate);
			calstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> chechBed(Map<String, Object> dataMap) {
		String regNo = "";
		String exists = "no";
		String type = "";
		List<Birthdeathreg> birthdeathregList = new ArrayList<Birthdeathreg>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (dataMap.get("regNo") != null) {
			regNo = "" + dataMap.get("regNo");
		}
		if (dataMap.get("type") != null) {
			type = "" + dataMap.get("type");
		}
		Session session = (Session) getSession();
		if (type.equalsIgnoreCase("birth")) {
			birthdeathregList = session.createCriteria(Birthdeathreg.class)
					.add(Restrictions.eq("Regno", regNo))
					.add(Restrictions.eq("Bdtype", "b")).list();
			if (birthdeathregList.size() > 0) {
				exists = "yes";
			}
		} else if (type.equalsIgnoreCase("death")) {
			birthdeathregList = session.createCriteria(Birthdeathreg.class)
					.add(Restrictions.eq("Regno", regNo))
					.add(Restrictions.eq("Bdtype", "d")).list();
			if (birthdeathregList.size() > 0) {
				exists = "yes";
			}
		}
		map.put("exists", exists);
		return map;
	}

	public List<Object> getExpiredAdmissionNumberList(
			Map<String, Object> detailsMap) {

		String serviceNo = "";
		String hinNo = "";
		String fatalCase = "";
		String onlyReport = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = (String) detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinNo") != null) {
			hinNo = (String) detailsMap.get("hinNo");
		}
		if (detailsMap.get("fatalCase") != null) {
			fatalCase = (String) detailsMap.get("fatalCase");
		}
		if (detailsMap.get("onlyReport") != null) {
			onlyReport = (String) detailsMap.get("onlyReport");
		}
		List<Object> inpatientList = new ArrayList<Object>();
		Session session = (Session) getSession();
		try {
			if (!serviceNo.equals("")) {
				inpatientList = session.createQuery(
						"from Inpatient ip join ip.Hin as p where p.ServiceNo = '"
								+ serviceNo + "'").list();
			}
			if (!hinNo.equals("")) {
				inpatientList = session.createQuery(
						"from Inpatient ip join ip.Hin as p where  p.HinNo = '"
								+ hinNo + "'").list();
			}
			if (!fatalCase.equals("")) {
				inpatientList = session.createQuery(
						"from ExpiryDetails e join e.Hin as p where p.HinNo = '"
								+ hinNo + "'").list();
			}
			// if(!onlyReport.equals("")){
			// inpatientList = getHibernateTemplate().find(
			// "from Birthdeathreg bd join bd.Hin as p where p.HinNo = '"
			// + hinNo + "'");
			// }

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
		return inpatientList;

	}

	public Map<String, Object> getHinAdNoDetailsFatalCase(
			Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo))
					.add(Restrictions.eq("PatientStatus", "Expired")).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.Id", hinId))
					.add(Restrictions.eq("pt.PatientStatus", "Expired")).list();
			map.put("inpatientList", inpatientList);
		}
		return map;
	}

	public Map<String, Object> populateHinNo(Map<String, Object> dataMap) {
		String serviceNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class)
				.createAlias("Hin", "pt")
				.add(Restrictions.eq("pt.ServiceNo", serviceNo))
				.add(Restrictions.ne("pt.PatientStatus", "Expired")).list();
		map.put("inpatientList", inpatientList);
		return map;
	}

	public Map<String, Object> getFRWDetails(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hinId = 0;
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + dataMap.get("hinId"));
		}
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Inpatient> misFrwList = new ArrayList<Inpatient>();
		inpatientList = session.createCriteria(Inpatient.class)
				.createAlias("Hin", "pt").add(Restrictions.eq("pt.Id", hinId))
				.list();

		misFrwList = session.createCriteria(MisFrw.class)
				.add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("inpatientList", inpatientList);
		map.put("misFrwList", misFrwList);
		return map;
	}

	public Map<String, Object> getHinAdNoFatalPanchanama(
			Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo))
					.add(Restrictions.eq("PatientStatus", "Expired")).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.Id", hinId))
					.add(Restrictions.eq("pt.PatientStatus", "Expired")).list();
			map.put("inpatientList", inpatientList);
		}
		return map;

	}

	public Map<String, Object> showDeathInformation(
			Map<String, Object> detailsMap) {
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<ExpiryDetails> expiryDetailsList = new ArrayList<ExpiryDetails>();
		int inpatientId = 0;
		if (detailsMap.get("inpatientId") != null) {
			inpatientId = Integer.parseInt("" + detailsMap.get("inpatientId"));
		}
		inpatientList = session.createCriteria(Inpatient.class)
				.add(Restrictions.eq("Id", inpatientId)).list();
		expiryDetailsList = session.createCriteria(ExpiryDetails.class)
				.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		map.put("inpatientList", inpatientList);
		map.put("expiryDetailsList", expiryDetailsList);
		return map;
	}

	public Map<String, Object> showEDreports(Map<String, Object> map) {
		Session session = (Session) getSession();
		Map<String, Object> temp = new HashMap<String, Object>();
		Connection conn = session.connection();
		List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
		masRankCategoryList = session.createCriteria(MasRankCategory.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("conn", conn);
		map.put("masRankCategoryList", masRankCategoryList);
		return map;
	}

	public Map<String, Object> getHinNoForDeficient(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String message = "";
		String respForm = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		if (dataMap.get("respForm") != null) {
			respForm = "" + dataMap.get("respForm");
		}

		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasUnit> presentUnitList = new ArrayList<MasUnit>();
		// List<MasMedicalCategory> masMedicalList = new
		// ArrayList<MasMedicalCategory>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		rankList = session.createCriteria(MasRank.class)
				.add(Restrictions.eq("Status", "y")).list();
		unitList = session.createCriteria(MasUnit.class)
				.add(Restrictions.eq("Status", "y")).list();
		tradeList = session.createCriteria(MasTrade.class)
				.add(Restrictions.eq("Status", "y")).list();
		// masMedicalList =
		// session.createCriteria(MasMedicalCategory.class).add(Restrictions.eq("Status",
		// "y")).list();
		empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class)
				.add(Restrictions.eq("ServiceNo", serviceNo)).list();

		List objectList = new ArrayList();
		objectList.add(31);
		objectList.add(184);
		objectList.add(160);
		objectList.add(59);

		presentUnitList = session.createCriteria(MasUnit.class)
				.add(Restrictions.in("Id", objectList)).list();

		if (empAfmsfDetList.size() > 0) {
			message = "This Personnel details already added";
		} else {
			message = "This Personnel not found";
		}
		map.put("message", message);
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		// map.put("masMedicalList", masMedicalList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		map.put("presentUnitList", presentUnitList);
		return map;
	}

	public Map<String, Object> getHinNoForSurplus(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		Session session = (Session) getSession();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		tradeList = session.createCriteria(MasTrade.class)
				.add(Restrictions.eq("Status", "y")).list();
		rankList = session.createCriteria(MasRank.class)
				.add(Restrictions.eq("Status", "y")).list();
		unitList = session.createCriteria(MasUnit.class)
				.add(Restrictions.eq("Status", "y")).list();
		empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class)
				.add(Restrictions.eq("AfmsfType", "D"))
				.add(Restrictions.eq("ServiceNo", serviceNo)).list();
		map.put("rankList", rankList);
		map.put("unitList", unitList);
		map.put("tradeList", tradeList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		return map;

	}

	public Map<String, Object> showMisDailyReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		masDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	public Map<String, Object> getHinAdNoForND(Map<String, Object> detailsMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		Session session = (Session) getSession();
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (!serviceNo.equals("")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();
			map.put("patientList", patientList);
		}
		if (hinId != 0) {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "pt")
					.add(Restrictions.eq("pt.Id", hinId)).list();
			map.put("inpatientList", inpatientList);
		}
		return map;

	}

	public Map<String, Object> getResponceForAME(Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();

		String serviceNo = "";
		if (dataMap.get("serviceNo") != null) {
			serviceNo = "" + dataMap.get("serviceNo");
		}
		Session session = (Session) getSession();
		// List<AnnualMediacalExamination> annualMediacalExaminationList = new
		// ArrayList<AnnualMediacalExamination>();
		List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
		// List<MasMedicalCategory> masMedicalCategoryList = new
		// ArrayList<MasMedicalCategory>();
		try {
			empAfmsfDetList = session.createCriteria(EmpAfmsfDet.class)
					.add(Restrictions.eq("AfmsfType", "IN"))
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();

			// annualMediacalExaminationList
			// =session.createCriteria(AnnualMediacalExamination.class)
			// .createAlias("AfmsfDet", "afmsfDet")
			// .add(Restrictions.eq("afmsfDet.ServiceNo", serviceNo)).list();

			// masMedicalCategoryList
			// =session.createCriteria(MasMedicalCategory.class)
			// .add(Restrictions.eq("Status", "y")).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("annualMediacalExaminationList",
		// annualMediacalExaminationList);
		map.put("empAfmsfDetList", empAfmsfDetList);
		// map.put("masMedicalCategoryList", masMedicalCategoryList);
		return map;
	}

	public Map<String, Object> getHiAdListForBD(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		int hinId = 0;
		String flag = "";
		if (detailsMap.get("serviceNo") != null) {
			serviceNo = "" + detailsMap.get("serviceNo");
		}
		if (detailsMap.get("hinId") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hinId"));
		}
		if (detailsMap.get("flag") != null) {
			flag = "" + detailsMap.get("flag");
		}
		Session session = (Session) getSession();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		if (flag.equals("hin")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();
		} else if (flag.equals("ad")) {
			inPatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Hin.Id", hinId)).list();
		}
		map.put("patientList", patientList);
		map.put("inPatientList", inPatientList);

		return map;
	}

	public Map<String, Object> printPMO(Map<String, Object> detailsMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		List<MisFrw> misFrwList = new ArrayList<MisFrw>();
		List<Patient> patientList = new ArrayList<Patient>();
		int hinId = 0;
		String serviceNo = null;
		if (detailsMap.get("hin_id") != null) {
			hinId = Integer.parseInt("" + detailsMap.get("hin_id"));
		}
		if (detailsMap.get("serviceNo") != null
				&& !detailsMap.get("serviceNo").equals("")) {
			serviceNo = String.valueOf("" + detailsMap.get("serviceNo"));
		}

		if (serviceNo != null) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("ServiceNo", serviceNo)).list();
			Patient patient = (Patient) patientList.get(0);
			hinId = patient.getId();
		}

		misFrwList = session.createCriteria(MisFrw.class)
				.add(Restrictions.eq("Hin.Id", hinId)).list();
		map.put("conn", con);
		map.put("misFrwList", misFrwList);
		map.put("hinId", hinId);
		return map;
	}

	public Map<String, Object> bedStatisticsSummary(Map<String, Object> dataMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = "";
		String toDate = "";
		Session session = (Session) getSession();
		if (dataMap.get("fromDate") != null) {
			fromDate = "" + dataMap.get("fromDate");
		}
		if (dataMap.get("toDate") != null) {
			toDate = "" + dataMap.get("toDate");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = null;
		try {
			date4MySQL = formatterOut.format(formatterIn.parse(fromDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date FROM_DATE = java.sql.Date.valueOf(date4MySQL);

		SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = null;
		try {
			date4MySQL2 = formatterOut2.format(formatterIn2.parse(toDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Date TO_DATE = java.sql.Date.valueOf(date4MySQL2);

		List objectList1 = new ArrayList();
		List objectList2 = new ArrayList();
		try {
			String idqry = "select distinct(date_of_addmission) from inpatient where date_of_addmission between '"
					+ FROM_DATE
					+ "' and '"
					+ TO_DATE
					+ "' order by date_of_addmission";

			objectList1 = (List) session.createSQLQuery(idqry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BigDecimal no_days_of_month = new BigDecimal("0");
		String qry = "";
		BigDecimal off_max = new BigDecimal("0");
		BigDecimal off_total = new BigDecimal("0");
		BigDecimal off_avg = new BigDecimal("0");

		BigDecimal off_fam_max = new BigDecimal("0");
		BigDecimal off_fam_total = new BigDecimal("0");
		BigDecimal off_fam_avg = new BigDecimal("0");

		BigDecimal ors_max = new BigDecimal("0");
		BigDecimal ors_total = new BigDecimal("0");
		BigDecimal ors_avg = new BigDecimal("0");

		BigDecimal ors_fam_max = new BigDecimal("0");
		BigDecimal ors_fam_total = new BigDecimal("0");
		BigDecimal ors_fam_avg = new BigDecimal("0");

		BigDecimal af_max = new BigDecimal("0");
		BigDecimal af_min = new BigDecimal("0");
		BigDecimal af_avg = new BigDecimal("0");

		BigDecimal army_max = new BigDecimal("0");
		BigDecimal army_min = new BigDecimal("0");
		BigDecimal army_avg = new BigDecimal("0");

		BigDecimal navy_max = new BigDecimal("0");
		BigDecimal navy_min = new BigDecimal("0");
		BigDecimal navy_avg = new BigDecimal("0");

		BigDecimal total_death = new BigDecimal("0");
		BigDecimal total_death_avg = new BigDecimal("0");

		BigDecimal total_adm = new BigDecimal("0");
		BigDecimal total_adm_avg = new BigDecimal("0");

		BigDecimal total_discharge = new BigDecimal("0");
		BigDecimal total_discharge_avg = new BigDecimal("0");

		BigDecimal stay_of_patient_total = new BigDecimal("0");
		BigDecimal stay_of_patient_avg = new BigDecimal("0");

		BigDecimal occupency_rate_avg = new BigDecimal("0");
		BigDecimal min_bed = new BigDecimal("0");
		BigDecimal max_bed = new BigDecimal("0");
		BigDecimal internal_turnover = new BigDecimal("0");
		for (int i = 0; i < objectList1.size(); i++) {
			qry = "select  d.REMD,ADM,b.Death,c.DIS,ifnull(a.ADM,0) + ifnull(d.REMD,0) - ifnull(b.Death,0) - ifnull(c.DIS,0) as TOT"
					+ ",e.OFF_AF,f.OFF_ARMY,g.OFF_NAVY,ifnull(e.OFF_AF,0)+ifnull(f.OFF_ARMY,0)+ifnull(g.OFF_NAVY,0)AS OFF_TOT,"
					+ "h.OFF_FAM_AF,i.OFF_FAM_ARMY,j.OFF_FAM_NAVY,ifnull(h.OFF_FAM_AF,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(OFF_FAM_NAVY,0)AS OFF_FAM_TOT"
					+ ",k.ORS_AF,l.ORS_ARMY,m.ORS_NAVY,ifnull(k.ORS_AF,0)+ifnull(l.ORS_ARMY,0)+ifnull(m.ORS_NAVY,0)AS ORS_TOT,"
					+ "n.ORS_FAM_AF,o.ORS_FAM_ARMY,p.ORS_FAM_NAVY,ifnull(n.ORS_FAM_AF,0)+ifnull(o.ORS_FAM_ARMY,0)+ifnull(p.ORS_FAM_NAVY,0)AS ORS_FAM_TOT,"
					+ "ifnull(e.OFF_AF,0)+ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0)+ifnull(n.ORS_FAM_AF,0) AS AF_TOT,"
					+ "ifnull(f.OFF_ARMY,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(l.ORS_ARMY,0)+ifnull(o.ORS_FAM_ARMY,0) AS ARMY_TOT,"
					+ "ifnull(g.OFF_NAVY,0)+ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0)+ifnull(p.ORS_FAM_NAVY,0) AS NAVY_TOT,"
					+ "q.CE_NE AS CE_NE,"
					+ "r.FORG,"
					+ "ifnull(ifnull(e.OFF_AF,0)+ifnull(h.OFF_FAM_AF,0)+ifnull(k.ORS_AF,0)+ifnull(n.ORS_FAM_AF,0),0)"
					+ "+ifnull(ifnull(f.OFF_ARMY,0)+ifnull(i.OFF_FAM_ARMY,0)+ifnull(l.ORS_ARMY,0)+ifnull(o.ORS_FAM_ARMY,0),0)"
					+ "+ifnull(ifnull(g.OFF_NAVY,0)+ifnull(j.OFF_FAM_NAVY,0)+ifnull(m.ORS_NAVY,0)+ifnull(p.ORS_FAM_NAVY,0),0)"
					+ "+ifnull(CE_NE,0)+ifnull(r.FORG,0) AS FINAL_TOT"
					+

					" from "
					+ "(SELECT count(*) as ADM FROM inpatient inpatient  where inpatient.date_of_addmission = '"
					+ objectList1.get(i)
					+ "' and inpatient.ad_status !='C') a,"
					+ "(SELECT count(*) as Death FROM expiry_details expiry_details where expiry_details.expiry_date  = '"
					+ objectList1.get(i)
					+ "'  ) b,"
					+ "(SELECT count(*) as DIS FROM discharge discharge where discharge.date_of_discharge = '"
					+ objectList1.get(i)
					+ "') c,"
					+ "(SELECT count(*) as REMD FROM "
					+ "inpatient inp2 where inp2.date_of_addmission <= DATE_ADD('"
					+ objectList1.get(i)
					+ "',INTERVAL '-1'DAY)  and DATE_ADD('"
					+ objectList1.get(i)
					+ "',INTERVAL '-1'DAY) <= ifNull(inp2.discharge_date,NOW()) and inp2.ad_status !='C') d,"
					+

					"(SELECT count(*) as OFF_AF FROM inpatient inp3 "
					+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
					+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
					+ " where inp3.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp3.discharge_date,NOW() ) and inp3.ad_status !='C' "
					+ "and rank1.`rank_category_id` =1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) e,"
					+

					"(SELECT count(*) as OFF_ARMY FROM inpatient inp4 "
					+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
					+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
					+ " where inp4.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp4.discharge_date,NOW()) "
					+ " and rank2.`rank_category_id` =1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1 and inp4.ad_status !='C') f,"
					+

					"(SELECT count(*) as OFF_NAVY FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
					+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
					+ " where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
					+ "and rank3.`rank_category_id` =1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) g,"
					+

					"(SELECT count(*) as OFF_FAM_AF FROM inpatient inp3 "
					+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
					+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
					+ " where inp3.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
					+ "and rank1.`rank_category_id` =1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) h,"
					+

					"(SELECT count(*) as OFF_FAM_ARMY FROM inpatient inp4 "
					+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
					+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
					+ " where inp4.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp4.discharge_date,NOW())  and inp4.ad_status !='C' "
					+ " and rank2.`rank_category_id` =1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1) i,"
					+

					"(SELECT count(*) as OFF_FAM_NAVY FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
					+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
					+ " where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
					+ "and rank3.`rank_category_id` =1 and patient3.`relation_id` !=8 and patient3.`service_type_id` IN (4,6)) j,"
					+

					"(SELECT count(*) as ORS_AF FROM inpatient inp3 "
					+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
					+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
					+ " where inp3.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C' "
					+ "and rank1.`rank_category_id` !=1 and patient1.`relation_id` =8 and patient1.`service_type_id` =2) k,"
					+

					"(SELECT count(*) as ORS_ARMY FROM inpatient inp4 "
					+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
					+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
					+ " where inp4.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "'and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
					+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id` =8 and patient2.`service_type_id` =1) l,"
					+

					"(SELECT count(*) as ORS_NAVY FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
					+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
					+ " where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C' "
					+ "and rank3.`rank_category_id` !=1 and patient3.`relation_id` =8 and patient3.`service_type_id` IN (4,6)) m,"
					+

					"(SELECT count(*) as ORS_FAM_AF FROM inpatient inp3 "
					+ " LEFT OUTER JOIN patient patient1 ON inp3.`hin_id` = patient1.`hin_id`"
					+ " left outer JOIN mas_rank rank1 ON rank1.`rank_id` = patient1.`rank_id`"
					+ " where inp3.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp3.discharge_date,NOW()) and inp3.ad_status !='C'"
					+ " and rank1.`rank_category_id` !=1 and patient1.`relation_id` !=8 and patient1.`service_type_id` =2) n,"
					+

					"(SELECT count(*) as ORS_FAM_ARMY FROM inpatient inp4 "
					+ " LEFT OUTER JOIN patient patient2 ON inp4.`hin_id` = patient2.`hin_id`"
					+ " left outer JOIN mas_rank rank2 ON rank2.`rank_id` = patient2.`rank_id`"
					+ " where inp4.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp4.discharge_date,NOW()) and inp4.ad_status !='C' "
					+ " and rank2.`rank_category_id` !=1 and patient2.`relation_id`!=8 and patient2.`service_type_id` =1)o,"
					+

					"(SELECT count(*) as ORS_FAM_NAVY FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
					+ " left outer JOIN mas_rank rank3 ON rank3.`rank_id` = patient3.`rank_id`"
					+ " where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
					+ " and rank3.`rank_category_id` !=1 and patient3.`relation_id` !=8 and patient3.`service_type_id`IN (4,6)) p,"
					+

					"(SELECT count(*) as CE_NE FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id` and inp5.ad_status !='C'"
					+

					"where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
					+ "and  patient3.`service_type_id` IN (3,7)) q,"
					+

					"(SELECT count(*) as FORG FROM inpatient inp5 "
					+ " LEFT OUTER JOIN patient patient3 ON inp5.`hin_id` = patient3.`hin_id`"
					+ "  where inp5.date_of_addmission <= '"
					+ objectList1.get(i)
					+ "' and '"
					+ objectList1.get(i)
					+ "' <= ifNull(inp5.discharge_date,NOW()) and inp5.ad_status !='C'"
					+ " and  patient3.`service_type_id` =5) r";
			no_days_of_month = no_days_of_month.add(new BigDecimal("1"));
			objectList2 = (List) session.createSQLQuery(qry).list();
			// for (Iterator iterator = objectList2.iterator();
			// iterator.hasNext();) {
			Object[] object = (Object[]) objectList2.get(0);

			// Block for officers Calculation
			if (off_max.compareTo(new BigDecimal("0")) == 0) {
				off_max = new BigDecimal("" + object[8]);
			} else if (off_max.compareTo(new BigDecimal("" + object[8])) == -1) {
				off_max = new BigDecimal("" + object[8]);
			}
			off_total = off_total.add(new BigDecimal("" + object[8]));

			// Block for officers family Calculation
			if (off_fam_max.compareTo(new BigDecimal("0")) == 0) {
				off_fam_max = new BigDecimal("" + object[12]);
			} else if (off_fam_max.compareTo(new BigDecimal("" + object[12])) == -1) {
				off_fam_max = new BigDecimal("" + object[12]);
			}
			off_fam_total = off_fam_total.add(new BigDecimal("" + object[12]));

			// Block for ors Calculation
			if (ors_max.compareTo(new BigDecimal("0")) == 0) {
				ors_max = new BigDecimal("" + object[16]);
			} else if (ors_max.compareTo(new BigDecimal("" + object[16])) == -1) {
				ors_max = new BigDecimal("" + object[16]);
			}
			ors_total = ors_total.add(new BigDecimal("" + object[16]));

			// Block for ors family Calculation
			if (ors_fam_max.compareTo(new BigDecimal("0")) == 0) {
				ors_fam_max = new BigDecimal("" + object[20]);
			} else if (ors_fam_max.compareTo(new BigDecimal("" + object[20])) == -1) {
				ors_fam_max = new BigDecimal("" + object[20]);
			}
			ors_fam_total = ors_fam_total.add(new BigDecimal("" + object[20]));

			// Block for AF Calculation
			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				af_min = new BigDecimal("" + object[21]);
			} else if (af_min.compareTo(new BigDecimal("" + object[21])) == 1) {
				af_min = new BigDecimal("" + object[21]);
			}

			if (af_max.compareTo(new BigDecimal("" + object[21])) == -1) {
				af_max = new BigDecimal("" + object[21]);
			}

			// Block for Army Calculation
			if (army_min.compareTo(new BigDecimal("0")) == 0) {
				army_min = new BigDecimal("" + object[22]);
			} else if (army_min.compareTo(new BigDecimal("" + object[22])) == 1) {
				army_min = new BigDecimal("" + object[22]);
			}

			if (army_max.compareTo(new BigDecimal("" + object[22])) == -1) {
				army_max = new BigDecimal("" + object[22]);
			}

			// Block for Navy Calculation
			if (navy_min.compareTo(new BigDecimal("0")) == 0) {
				navy_min = new BigDecimal("" + object[23]);
			} else if (navy_min.compareTo(new BigDecimal("" + object[23])) == 1) {
				navy_min = new BigDecimal("" + object[23]);
			}

			if (navy_max.compareTo(new BigDecimal("" + object[23])) == -1) {
				navy_max = new BigDecimal("" + object[23]);
			}

			// Block for Navy Calculation
			total_death = total_death.add(new BigDecimal("" + object[3]));

			// Block for ADM Calculation
			total_adm = total_adm.add(new BigDecimal("" + object[1]));

			// Block for Discharge Calculation
			total_discharge = total_discharge
					.add(new BigDecimal("" + object[2]));

			// Block for stay of patient Calculation

			if (af_min.compareTo(new BigDecimal("0")) == 0) {
				min_bed = new BigDecimal("" + object[26]);
			} else if (af_min.compareTo(new BigDecimal("" + object[26])) == 1) {
				min_bed = new BigDecimal("" + object[26]);
			}
			if (max_bed.compareTo(new BigDecimal("" + object[26])) == -1) {
				max_bed = new BigDecimal("" + object[26]);
			}
			stay_of_patient_total = stay_of_patient_total.add(new BigDecimal(""
					+ object[26]));

			// }
		}
		// Final Caluculation
		off_avg = off_total.divide(no_days_of_month, 2, 0);
		off_fam_avg = off_fam_total.divide(no_days_of_month, 2, 0);
		ors_avg = ors_total.divide(no_days_of_month, 2, 0);
		ors_fam_avg = ors_fam_total.divide(no_days_of_month, 2, 0);
		af_avg = af_min.add(af_max).divide(new BigDecimal("2"), 2, 0);
		army_avg = army_min.add(army_max).divide(new BigDecimal("2"), 2, 0);
		navy_avg = navy_min.add(navy_max).divide(new BigDecimal("2"), 2, 0);
		BigDecimal af_army_navy_min = new BigDecimal("0");
		BigDecimal af_army_navy_max = new BigDecimal("0");
		af_army_navy_min = af_army_navy_min.add(af_min.add(army_min).add(
				navy_min));
		af_army_navy_max = af_army_navy_max.add(af_max.add(army_max).add(
				navy_max));
		BigDecimal death_avg = new BigDecimal("0");
		death_avg = total_death.divide(no_days_of_month, 2, 0);
		BigDecimal adm_avg = new BigDecimal("0");
		adm_avg = total_adm.divide(no_days_of_month, 2, 0);
		BigDecimal discharge_avg = new BigDecimal("0");
		discharge_avg = total_discharge.divide(no_days_of_month, 2, 0);
		stay_of_patient_avg = stay_of_patient_total.divide(
				total_discharge.add(total_adm), 2, 0);

		occupency_rate_avg = stay_of_patient_total.divide(
				no_days_of_month.multiply(new BigDecimal("800")), 2, 0)
				.multiply(new BigDecimal("100"));
		try {
			internal_turnover = no_days_of_month
					.multiply(new BigDecimal("800"))
					.subtract(stay_of_patient_total)
					.divide(total_discharge.add(total_death), 2, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("off_max", off_max);
		map.put("off_avg", off_avg);
		map.put("off_fam_max", off_fam_max);
		map.put("off_fam_avg", off_fam_avg);
		map.put("ors_max", ors_max);
		map.put("ors_avg", ors_avg);
		map.put("ors_fam_max", ors_fam_max);
		map.put("ors_fam_avg", ors_fam_avg);

		map.put("af_min", af_min);
		map.put("af_max", af_max);
		map.put("af_avg", af_avg);

		map.put("army_min", army_min);
		map.put("army_max", army_max);
		map.put("army_avg", army_avg);

		map.put("navy_min", navy_min);
		map.put("navy_max", navy_max);
		map.put("navy_avg", navy_avg);

		map.put("total_death", total_death);
		map.put("total_death_avg", death_avg);

		map.put("total_adm", total_adm);
		map.put("total_adm_avg", adm_avg);

		map.put("total_discharge", total_discharge);
		map.put("total_discharge_avg", discharge_avg);

		map.put("stay_of_patient_avg", stay_of_patient_avg);
		map.put("occupency_rate_avg", occupency_rate_avg);
		map.put("min_bed", min_bed);
		map.put("max_bed", max_bed);
		map.put("internal_turnover", internal_turnover);

		return map;
	}

	public String generateNumberForseq() {
		String regNo = "";
		List<TransactionSequence> regList = new ArrayList<TransactionSequence>();
		Session session = (Session) getSession();
		try {
			regList = session.createCriteria(TransactionSequence.class)
					.add(Restrictions.eq("TransactionPrefix", "EMP")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int seqNo = 0;
		if (regList.size() > 0) {
			for (TransactionSequence transactionSequence : regList) {
				TransactionSequence obj = (TransactionSequence) regList.get(0);
				int id = obj.getId();
				seqNo = obj.getTransactionSequenceNumber();
				int temp = 0;
				temp = seqNo;
				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);

				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);

				regNo = String.valueOf(temp);
			}
		} else if (regList.size() == 0) {
			seqNo = 1;
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("mas_employee");
			tsObj.setTransactionPrefix("EMP");
			tsObj.setTransactionSequenceName("Employee Master");
			tsObj.setTransactionSequenceNumber(seqNo);
			tsObj.setCreatedby("admin");
			tsObj.setStatus("y");

			hbt.save(tsObj);

			regNo = String.valueOf(seqNo);
		}
		return regNo;
	}

	public Map<String, Object> totalAdmissionExcelSoftCopy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String grp_name = "TOTALADMISSIONS";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String fromDateStr = "";
			String toDateStr = "";
			String ServiceType_id = "";
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""
						+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""
						+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ServiceType_id = box.getString(SERVICE_TYPE_NAME);
			List<Object> TotalAdmList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			Criteria crit = null;
			crit = session.createCriteria(Inpatient.class).createAlias("Hin",
					"pt");
			if (!ServiceType_id.equals("0")) {
				crit = crit.add(Restrictions.eq("pt.ServiceType.Id",
						Integer.parseInt(ServiceType_id)));
			}
			crit = crit.add(
					Restrictions.between("DateOfAddmission",
							java.sql.Date.valueOf(fromDateStr),
							java.sql.Date.valueOf(toDateStr))).addOrder(
					Order.asc("Id"));
			inpatientList = crit.list();

			serviceTypeList = session
					.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Id", Integer.parseInt(ServiceType_id)))
					.list();
			String serviceType = "";
			for (MasServiceType serv : serviceTypeList) {
				serviceType = serv.getServiceTypeName();
			}

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10.setCellValue("                                                                                                       AFMSF-40");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue("COMMAND HOSPITAL AIR FORCE, BANGALORE -7");
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue("Hospital Admission Records of "
						+ serviceType + " Personnel in CHAF Bangalore -7");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40.setCellValue("From Date :");
				cell40.setCellStyle(style1);
				HSSFCell cell43 = row4.createCell((short) 4);
				cell43.setCellValue(fromDateStr + "  To Date: " + toDateStr);
				cell43.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell50 = headingRow.createCell((short) 0);
				cell50.setCellValue("Sl.No");
				cell50.setCellStyle(style);
				HSSFCell cell51 = headingRow.createCell((short) 1);
				cell51.setCellValue("A&D No");
				cell51.setCellStyle(style);
				HSSFCell cell52 = headingRow.createCell((short) 2);
				cell52.setCellValue("Service No");
				cell52.setCellStyle(style);

				HSSFCell cell53 = headingRow.createCell((short) 3);
				cell53.setCellValue("Relation");
				cell53.setCellStyle(style);
				HSSFCell cell531 = headingRow.createCell((short) 4);
				cell531.setCellValue("Rank");
				cell531.setCellStyle(style);
				HSSFCell cell54 = headingRow.createCell((short) 5);
				cell54.setCellValue("Name");
				cell54.setCellStyle(style);
				HSSFCell cell55 = headingRow.createCell((short) 6);
				cell55.setCellValue("Trade");
				cell55.setCellStyle(style);
				HSSFCell cell56 = headingRow.createCell((short) 7);
				cell56.setCellValue("R/O");
				cell56.setCellStyle(style);
				HSSFCell cell57 = headingRow.createCell((short) 8);
				cell57.setCellValue("Total Serv");
				cell57.setCellStyle(style);
				HSSFCell cell58 = headingRow.createCell((short) 9);
				cell58.setCellValue("Age");
				cell58.setCellStyle(style);
				HSSFCell cell59 = headingRow.createCell((short) 10);
				cell59.setCellValue("Unit");
				cell59.setCellStyle(style);
				HSSFCell cell510 = headingRow.createCell((short) 11);
				cell510.setCellValue("Adm Date");
				cell510.setCellStyle(style);
				HSSFCell cell511 = headingRow.createCell((short) 12);
				cell511.setCellValue("Dis Date");
				cell511.setCellStyle(style);
				HSSFCell cell512 = headingRow.createCell((short) 13);
				cell512.setCellValue("Patient Diagnosis");
				cell512.setCellStyle(style);
				HSSFCell cell513 = headingRow.createCell((short) 14);
				cell513.setCellValue("Disposal");
				cell513.setCellStyle(style);

				int row = 7;
				int slno = 0;

				for (Iterator iterator = inpatientList.iterator(); iterator
						.hasNext();) {
					Inpatient inpatient = (Inpatient) iterator.next();

					sheet.createRow((short) row).createCell((short) 0)
							.setCellValue(++slno);
					sheet.createRow((short) row).createCell((short) 1)
							.setCellValue(inpatient.getAdNo());
					sheet.createRow((short) row).createCell((short) 2)
							.setCellValue(inpatient.getHin().getServiceNo());
					if (inpatient.getHin().getRelation() != null) {
						sheet.createRow((short) row)
								.createCell((short) 3)
								.setCellValue(
										inpatient.getHin().getRelation()
												.getRelationName());
					} else {
						sheet.createRow((short) row).createCell((short) 3)
								.setCellValue("");
					}

					if (inpatient.getHin().getRank() != null) {
						sheet.createRow((short) row)
								.createCell((short) 4)
								.setCellValue(
										inpatient.getHin().getRank()
												.getRankName());
					} else {
						sheet.createRow((short) row).createCell((short) 4)
								.setCellValue("");
					}
					String name = inpatient.getHin().getSFirstName() + "  "
							+ inpatient.getHin().getSMiddleName() + "  "
							+ inpatient.getHin().getSLastName();
					sheet.createRow((short) row).createCell((short) 5)
							.setCellValue(name);

					if (inpatient.getHin().getTrade() != null) {
						sheet.createRow((short) row)
								.createCell((short) 6)
								.setCellValue(
										inpatient.getHin().getTrade()
												.getTradeName());
					} else {
						sheet.createRow((short) row).createCell((short) 6)
								.setCellValue("");
					}

					if (inpatient.getHin().getRecordOfficeAddress() != null) {
						sheet.createRow((short) row)
								.createCell((short) 7)
								.setCellValue(
										inpatient.getHin()
												.getRecordOfficeAddress()
												.getAddress()
												+ "\n PtDt:"
												+ inpatient.getHin()
														.getDistrict()
														.getDistrictName());
					} else {
						sheet.createRow((short) row).createCell((short) 7)
								.setCellValue("");
					}
					sheet.createRow((short) row)
							.createCell((short) 8)
							.setCellValue(
									inpatient.getHin().getServiceYears()
											+ inpatient.getHin()
													.getTotalServicePeriod());
					sheet.createRow((short) row).createCell((short) 9)
							.setCellValue(inpatient.getHin().getAge());

					if (inpatient.getHin().getUnit() != null) {
						sheet.createRow((short) row)
								.createCell((short) 10)
								.setCellValue(
										inpatient.getHin().getUnit()
												.getUnitName());
					} else {
						sheet.createRow((short) row).createCell((short) 10)
								.setCellValue("");
					}

					SimpleDateFormat dateformatOut = new SimpleDateFormat(
							"dd-MM-yyyy");
					SimpleDateFormat dateformatIn = new SimpleDateFormat(
							"yyyy-MM-dd");

					if (inpatient.getDateOfAddmission() != null) {
						try {
							sheet.createRow((short) row)
									.createCell((short) 11)
									.setCellValue(
											dateformatOut.format(dateformatIn
													.parse(inpatient
															.getDateOfAddmission()
															.toString())));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 11)
								.setCellValue("");
					}

					if (inpatient.getDischargeDate() != null) {
						try {
							SimpleDateFormat formatOut1 = new SimpleDateFormat(
									"dd-MM-yyyy");
							SimpleDateFormat formatIn1 = new SimpleDateFormat(
									"yyyy-MM-dd");

							sheet.createRow((short) row)
									.createCell((short) 12)
									.setCellValue(
											formatOut1.format(formatIn1
													.parse(inpatient
															.getDischargeDate()
															.toString())));
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
					} else {
						sheet.createRow((short) row).createCell((short) 12)
								.setCellValue("still in hospital");
					}

					List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();

					icdList = session
							.createCriteria(DischargeIcdCode.class)
							.createAlias("Inpatient", "inpatient")
							.add(Restrictions.eq("DiagnosisStatus", "f"))
							.add(Restrictions.eq("inpatient.Id",
									inpatient.getId()))
							.addOrder(Order.asc("Id")).list();
					String icdCode = "";
					int i = 1;
					if (icdList.size() > 0) {
						for (Iterator iterator1 = icdList.iterator(); iterator1
								.hasNext();) {
							DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1
									.next();
							String SubicdCode = "";
							SubicdCode = ""
									+ i
									+ ")"
									+ dischargeIcdCode.getIcd()
											.getIcdSubCategory()
											.getIcdSubCategoryName() + " "
									+ dischargeIcdCode.getIcd().getIcdName()
									+ " ICD No "
									+ dischargeIcdCode.getIcd().getIcdCode();
							icdCode = icdCode + SubicdCode + "\n";
							i++;
						}
					}

					sheet.createRow((short) row).createCell((short) 13)
							.setCellValue(icdCode);

					List<Discharge> dischargeList = new ArrayList<Discharge>();

					dischargeList = session.createCriteria(Discharge.class)
							.add(Restrictions.eq("AdNo", inpatient.getAdNo()))
							.addOrder(Order.asc("Id")).list();

					if (dischargeList.size() > 0) {
						for (Iterator iterator2 = dischargeList.iterator(); iterator2
								.hasNext();) {
							Discharge discharge = (Discharge) iterator2.next();
							if (discharge.getDisposedTo() != null) {
								sheet.createRow((short) row)
										.createCell((short) 14)
										.setCellValue(
												discharge.getDisposedTo()
														.getDisposedToName());
							} else {
								sheet.createRow((short) row)
										.createCell((short) 14)
										.setCellValue("");
							}
						}
					} else {
						sheet.createRow((short) row).createCell((short) 14)
								.setCellValue("");
					}

					sheet.setColumnWidth((short) 0, (short) (6 * 256));
					sheet.setColumnWidth((short) 1, (short) (15 * 256));
					sheet.setColumnWidth((short) 2, (short) (15 * 256));
					sheet.setColumnWidth((short) 3, (short) (15 * 256));
					sheet.setColumnWidth((short) 4, (short) (15 * 256));
					sheet.setColumnWidth((short) 5, (short) (20 * 256));
					sheet.setColumnWidth((short) 6, (short) (25 * 256));
					sheet.setColumnWidth((short) 7, (short) (25 * 256));
					sheet.setColumnWidth((short) 8, (short) (10 * 256));
					sheet.setColumnWidth((short) 9, (short) (23 * 256));
					sheet.setColumnWidth((short) 10, (short) (10 * 256));
					sheet.setColumnWidth((short) 11, (short) (23 * 256));
					sheet.setColumnWidth((short) 12, (short) (30 * 256));
					sheet.setColumnWidth((short) 13, (short) (60 * 256));
					sheet.setColumnWidth((short) 14, (short) (20 * 256));
					row++;
				}
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}

	public Map<String, Object> totalDischargeExcelSoftCopy(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String grp_name = "TOTALDISCHARGE";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			String fromDateStr = "";
			String toDateStr = "";
			String ServiceType_id = "";
			SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
			try {
				fromDateStr = formatterOut.format(formatterIn.parse(""
						+ box.getString(FROM_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			SimpleDateFormat formatterIn1 = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formatterOut1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				toDateStr = formatterOut1.format(formatterIn1.parse(""
						+ box.getString(TO_DATE)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			ServiceType_id = box.getString(SERVICE_TYPE_ID);
			List<Object> TotalAdmList = new ArrayList<Object>();
			List<Inpatient> inpatientList = new ArrayList<Inpatient>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			String query = "";
			query = "from Inpatient i where i.DischargeDate between '"
					+ java.sql.Date.valueOf(fromDateStr)
					+ "'"
					+ " and '"
					+ java.sql.Date.valueOf(toDateStr)
					+ "' and i.AdStatus = 'D' group by i.AdNo order by i.DischargeDate";
			inpatientList = getHibernateTemplate().find(query);
			serviceTypeList = session
					.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Id", Integer.parseInt(ServiceType_id)))
					.list();
			String serviceType = "";
			for (MasServiceType serv : serviceTypeList) {
				serviceType = serv.getServiceTypeName();
			}

			try {
				byte[] buffer = new byte[18024];
				HSSFWorkbook wb = new HSSFWorkbook();
				HSSFSheet sheet = wb.createSheet("TESTEXCEL");
				// Create a new font and alter it.
				HSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setColor((short) 62);
				font.setItalic(false);
				font.setStrikeout(false);
				font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				HSSFFont font1 = wb.createFont();
				font1.setFontHeightInPoints((short) 10);
				font1.setFontName(HSSFFont.FONT_ARIAL);
				font1.setColor((short) 80);
				font1.setItalic(false);
				font1.setStrikeout(false);
				font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

				// Fonts are set into a style so create a new one to
				// use.
				HSSFCellStyle style = wb.createCellStyle();
				style.setFont(font);

				HSSFCellStyle style1 = wb.createCellStyle();
				style1.setFont(font1);
				style1.setLocked(true);

				/*
				 * HSSFRow row1 = sheet.createRow((short) 1); // Create a cell
				 * and put a value in it. HSSFCell cell10 =
				 * row1.createCell((short) 3); cell10.setCellValue(" AFMSF-40");
				 * cell10.setCellStyle(style1); sheet.addMergedRegion(new
				 * Region(1, (short) 3, 1, (short) 7));
				 */

				HSSFRow row1 = sheet.createRow((short) 1);
				// Create a cell and put a value in it.
				HSSFCell cell10 = row1.createCell((short) 3);
				cell10.setCellValue("COMMAND HOSPITAL AIR FORCE, BANGALORE -7");
				cell10.setCellStyle(style1);
				sheet.addMergedRegion(new Region(1, (short) 3, 1, (short) 7));

				HSSFRow row2 = sheet.createRow((short) 2);
				// Create a cell and put a value in it.
				HSSFCell cell20 = row2.createCell((short) 3);
				cell20.setCellValue("Statistical Registration No. AA/844 (b)      ");
				cell20.setCellStyle(style1);
				sheet.addMergedRegion(new Region(2, (short) 3, 2, (short) 7));

				HSSFRow row3 = sheet.createRow((short) 3);
				// Create a cell and put a value in it.
				HSSFCell cell30 = row3.createCell((short) 3);
				cell30.setCellValue(" Name of Medical Unit : Command Hospital   AF Bangalore       ");
				cell30.setCellStyle(style1);
				sheet.addMergedRegion(new Region(3, (short) 3, 3, (short) 7));

				HSSFRow row4 = sheet.createRow((short) 4);
				// Create a cell and put a value in it.
				HSSFCell cell40 = row4.createCell((short) 3);
				cell40.setCellValue(" Particulars of cases admitted before but disposed of or whose diagnosis changed \n during the period ending :");
				cell40.setCellStyle(style1);
				sheet.addMergedRegion(new Region(4, (short) 3, 4, (short) 7));

				HSSFRow row5 = sheet.createRow((short) 5);
				// Create a cell and put a value in it.
				HSSFCell cell50 = row5.createCell((short) 3);
				cell50.setCellValue("                                  RESTRICTED                                 AFMSF-42");
				cell50.setCellStyle(style1);
				sheet.addMergedRegion(new Region(5, (short) 3, 5, (short) 7));

				HSSFRow row6 = sheet.createRow((short) 6);
				// Create a cell and put a value in it.
				HSSFCell cell60 = row6.createCell((short) 3);
				cell60.setCellValue("Discharge Records of " + serviceType
						+ " Personnel in CHAF Bangalore -7");
				cell60.setCellStyle(style1);
				sheet.addMergedRegion(new Region(6, (short) 3, 6, (short) 7));

				HSSFRow row7 = sheet.createRow((short) 7);
				// Create a cell and put a value in it.
				HSSFCell cell70 = row7.createCell((short) 3);
				cell70.setCellValue("From Date :");
				cell70.setCellStyle(style1);
				HSSFCell cell73 = row7.createCell((short) 4);
				cell73.setCellValue(fromDateStr + "  To Date: " + toDateStr);
				cell73.setCellStyle(style1);
				sheet.addMergedRegion(new Region(7, (short) 3, 7, (short) 7));

				// Create a row and put some cells in it. Rows are 0
				// based.
				HSSFRow headingRow = sheet.createRow((short) 9);
				// Create a cell and put a value in it.
				HSSFCell cell80 = headingRow.createCell((short) 0);
				cell80.setCellValue("Sl.No");
				cell80.setCellStyle(style);
				HSSFCell cell81 = headingRow.createCell((short) 1);
				cell81.setCellValue("Ser No in A&D Book with Month and year of admission       ");
				cell81.setCellStyle(style);
				HSSFCell cell82 = headingRow.createCell((short) 2);
				cell82.setCellValue("Name in full");
				cell82.setCellStyle(style);

				HSSFCell cell83 = headingRow.createCell((short) 3);
				cell83.setCellValue("Dt of Disposal");
				cell83.setCellStyle(style);
				HSSFCell cell831 = headingRow.createCell((short) 4);
				cell831.setCellValue("Discharged/Transferredto");
				cell831.setCellStyle(style);
				HSSFCell cell84 = headingRow.createCell((short) 5);
				cell84.setCellValue("No.Of Days Hospital");
				cell84.setCellStyle(style);
				HSSFCell cell85 = headingRow.createCell((short) 6);
				cell85.setCellValue("Patient Diagnosis");
				cell85.setCellStyle(style);

				int row = 10;
				int slno = 0;

				/*
				 * for (Iterator iterator = inpatientList.iterator(); iterator
				 * .hasNext();) {
				 */

				// if(!ServiceType_id.equals("0") && ServiceType_id != null &&
				// ServiceType_id.equals("")){
				for (Inpatient inpatient : inpatientList) {
					if (Integer.parseInt(ServiceType_id) == inpatient.getHin()
							.getServiceType().getId()) {
						// Inpatient inpatient = (Inpatient) iterator.next();

						sheet.createRow((short) row).createCell((short) 0)
								.setCellValue(++slno);
						sheet.createRow((short) row).createCell((short) 1)
								.setCellValue(inpatient.getAdNo());
						String name = inpatient.getHin().getSFirstName() + "  "
								+ inpatient.getHin().getSMiddleName() + "  "
								+ inpatient.getHin().getSLastName();
						sheet.createRow((short) row).createCell((short) 2)
								.setCellValue(name);
						if (inpatient.getDischargeDate() != null) {
							try {
								SimpleDateFormat formatOut1 = new SimpleDateFormat(
										"dd-MM-yyyy");
								SimpleDateFormat formatIn1 = new SimpleDateFormat(
										"yyyy-MM-dd");

								sheet.createRow((short) row)
										.createCell((short) 3)
										.setCellValue(
												formatOut1.format(formatIn1
														.parse(inpatient
																.getDischargeDate()
																.toString())));
							} catch (ParseException e2) {
								e2.printStackTrace();
							}
						} else {
							sheet.createRow((short) row).createCell((short) 3)
									.setCellValue("");
						}

						List<Discharge> dischargeList = new ArrayList<Discharge>();
						dischargeList = session
								.createCriteria(Discharge.class)
								.add(Restrictions.eq("AdNo",
										inpatient.getAdNo()))
								.addOrder(Order.asc("Id")).list();

						if (dischargeList.size() > 0) {
							for (Iterator iterator2 = dischargeList.iterator(); iterator2
									.hasNext();) {
								Discharge discharge = (Discharge) iterator2
										.next();
								if (discharge.getDisposedTo() != null) {
									sheet.createRow((short) row)
											.createCell((short) 4)
											.setCellValue(
													discharge
															.getDisposedTo()
															.getDisposedToName());
								} else {
									sheet.createRow((short) row)
											.createCell((short) 4)
											.setCellValue("");
								}
							}
						} else {
							sheet.createRow((short) row).createCell((short) 4)
									.setCellValue("");
						}
						long one_day = 1000 * 60 * 60 * 24;
						Double diffDays = Math.ceil((inpatient
								.getDischargeDate().getTime() - inpatient
								.getDateOfAddmission().getTime())
								/ one_day);
						int noDays = diffDays.intValue();

						sheet.createRow((short) row).createCell((short) 5)
								.setCellValue(noDays);

						List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
						icdList = session
								.createCriteria(DischargeIcdCode.class)
								.createAlias("Inpatient", "inpatient")
								.add(Restrictions.eq("DiagnosisStatus", "f"))
								.add(Restrictions.eq("inpatient.Id",
										inpatient.getId()))
								.addOrder(Order.asc("Id")).list();
						String icdCode = "";
						int i = 1;
						if (icdList.size() > 0) {
							for (Iterator iterator1 = icdList.iterator(); iterator1
									.hasNext();) {
								DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iterator1
										.next();
								String SubicdCode = "";
								SubicdCode = ""
										+ i
										+ ")"
										+ dischargeIcdCode.getIcd()
												.getIcdSubCategory()
												.getIcdSubCategoryName()
										+ " "
										+ dischargeIcdCode.getIcd()
												.getIcdName()
										+ " [ICD No "
										+ dischargeIcdCode.getIcd()
												.getIcdCode() + "]";
								icdCode = icdCode + SubicdCode + "\n";
								i++;
							}
						}

						sheet.createRow((short) row).createCell((short) 6)
								.setCellValue(icdCode);

						sheet.setColumnWidth((short) 0, (short) (6 * 256));
						sheet.setColumnWidth((short) 1, (short) (15 * 256));
						sheet.setColumnWidth((short) 2, (short) (15 * 256));
						sheet.setColumnWidth((short) 3, (short) (15 * 256));
						sheet.setColumnWidth((short) 4, (short) (15 * 256));
						sheet.setColumnWidth((short) 5, (short) (20 * 256));
						sheet.setColumnWidth((short) 6, (short) (25 * 256));
						sheet.setColumnWidth((short) 7, (short) (25 * 256));
						sheet.setColumnWidth((short) 8, (short) (10 * 256));
						sheet.setColumnWidth((short) 9, (short) (23 * 256));
						sheet.setColumnWidth((short) 10, (short) (10 * 256));
						sheet.setColumnWidth((short) 11, (short) (23 * 256));
						sheet.setColumnWidth((short) 12, (short) (30 * 256));
						sheet.setColumnWidth((short) 13, (short) (60 * 256));
						sheet.setColumnWidth((short) 14, (short) (20 * 256));
						row++;
					}
				}
				// }
				// Write the output to a file
				grp_name = grp_name + ".xls";
				FileOutputStream fileOut = new FileOutputStream(grp_name);
				wb.write(fileOut);
				fileOut.close();

				map.put("flag", "DataFound");
				map.put("download_path", grp_name);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				map.put("flag", "NoData");
			}

		} catch (HibernateException e) {
			e.printStackTrace();
			map.put("flag", "NoData");
		}
		return map;
	}

	public Map<String, Object> getTotalMisDailyReport(
			Map<String, Object> dataMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		String toDate = "";
		String TO_DATE = null;
		int deptId = 0;
		Session session = (Session) getSession();

		if (dataMap.get("Date") != null) {
			TO_DATE = "" + dataMap.get("Date");
		}
		if (dataMap.get("Dept_ID") != null) {
			deptId = Integer.parseInt("" + dataMap.get("Dept_ID"));
		}

		// java.sql.Date TO_DATE = java.sql.Date.valueOf(date4MySQL2);

		List objectList1 = new ArrayList();
		List objectList2 = new ArrayList();
		try {
			String idqry = "SELECT mas_department.`department_id` , mas_department.`department_name` FROM "
					+ " `mas_department` mas_department , `mas_department_type` mas_dept_type "
					+ " where mas_department.department_type_id = mas_dept_type.department_type_id "
					+ " and mas_dept_type.department_type_code = 'WARD' and mas_department.`status` = 'y' ";
			objectList1 = (List) session.createSQLQuery(idqry).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		String qry = "";
		BigDecimal REMD = new BigDecimal("0");
		BigDecimal ADM = new BigDecimal("0");
		BigDecimal DIS = new BigDecimal("0");

		BigDecimal TIN = new BigDecimal("0");
		BigDecimal TOUT = new BigDecimal("0");
		BigDecimal SIL = new BigDecimal("0");

		BigDecimal DIL = new BigDecimal("0");
		BigDecimal DINOUT = new BigDecimal("0");
		BigDecimal DEATH = new BigDecimal("0");

		BigDecimal REMG = new BigDecimal("0");
		for (int i = 0; i < objectList1.size(); i++) {
			Object[] object1 = (Object[]) objectList1.get(i);
			qry = "select  d.REMD,a.ADM,c.DIS,e.TIN,f.TOUT,g.SIL,h.DIL,b.Death,i.REMG from"
					+ " (SELECT count(*) as ADM FROM inpatient inpatient  where inpatient.date_of_addmission = '"
					+ TO_DATE
					+ "' and  inpatient.department_id = "
					+ object1[0]
					+ ") a, "
					+ " (SELECT count(*) as Death FROM expiry_details expiry_details where expiry_details.expiry_date  = '"
					+ TO_DATE
					+ "'  and  expiry_details.ward_id = "
					+ object1[0]
					+ ") b, "
					+ " (SELECT count(*) as DIS FROM discharge discharge where discharge.date_of_discharge = '"
					+ TO_DATE
					+ "' and  discharge.ward_id = "
					+ object1[0]
					+ ") c, "
					+ " (SELECT count(*) as REMD FROM inpatient inp2 where inp2.date_of_addmission < '"
					+ TO_DATE
					+ "' and inp2.ad_status = 'A' and inp2.department_id = "
					+ object1[0]
					+ ") d, "
					+ " (SELECT count(distinct(inp3.inpatient_id)) as TIN FROM inpatient inp3 where inp3.date_of_addmission = '"
					+ TO_DATE
					+ "' and inp3.department_id = "
					+ object1[0]
					+ " and inp3.ad_ward_id !="
					+ object1[0]
					+ ") e, "
					+ " (SELECT count(distinct(inp4.inpatient_id)) as TOUT FROM inpatient inp4 where inp4.date_of_addmission = '"
					+ TO_DATE
					+ "' and inp4.department_id != "
					+ object1[0]
					+ " and inp4.ad_ward_id ="
					+ object1[0]
					+ ") f, "
					+ "(SELECT count(distinct(sil.inpatient_id)) as SIL FROM sil_dil_status sil where sil.last_chg_date = '"
					+ TO_DATE
					+ "' and sil.department_id = "
					+ object1[0]
					+ " and sil.condition_status ='SIL' ) g,"
					+ "(SELECT count(distinct(dil.inpatient_id)) as DIL FROM sil_dil_status dil where dil.last_chg_date = '"
					+ TO_DATE
					+ "' and dil.department_id = "
					+ object1[0]
					+ " and dil.condition_status ='DIL' ) h,"
					+ " (SELECT count(*) as REMG FROM inpatient inp5 where inp5.date_of_addmission <= '"
					+ TO_DATE
					+ "' and inp5.ad_status = 'A' and inp5.department_id = "
					+ object1[0] + ") i";

			objectList2 = (List) session.createSQLQuery(qry).list();
			// for (Iterator iterator = objectList2.iterator();
			// iterator.hasNext();) {
			Object[] object = (Object[]) objectList2.get(0);

			// Block for officers Calculation
			if (REMD.compareTo(new BigDecimal("0")) == 0) {
				REMD = new BigDecimal("" + object[0]);
			} else if (REMD.compareTo(new BigDecimal("0")) == -1) {
				REMD = REMD.add(new BigDecimal("" + object[0]));
			}

			if (ADM.compareTo(new BigDecimal("0")) == 0) {
				ADM = new BigDecimal("" + object[1]);
			} else if (ADM.compareTo(new BigDecimal("0")) == -1) {
				ADM = ADM.add(new BigDecimal("" + object[1]));
			}
			if (DIS.compareTo(new BigDecimal("0")) == 0) {
				DIS = new BigDecimal("" + object[2]);
			} else if (DIS.compareTo(new BigDecimal("0")) == -1) {
				DIS = DIS.add(new BigDecimal("" + object[2]));
			}

			if (TIN.compareTo(new BigDecimal("0")) == 0) {
				TIN = new BigDecimal("" + object[3]);
			} else if (TIN.compareTo(new BigDecimal("0")) == -1) {
				TIN = TIN.add(new BigDecimal("" + object[3]));
			}

			if (TOUT.compareTo(new BigDecimal("0")) == 0) {
				TOUT = new BigDecimal("" + object[4]);
			} else if (TOUT.compareTo(new BigDecimal("0")) == -1) {
				TOUT = TOUT.add(new BigDecimal("" + object[4]));
			}
			if (SIL.compareTo(new BigDecimal("0")) == 0) {
				SIL = new BigDecimal("" + object[5]);
			} else if (SIL.compareTo(new BigDecimal("0")) == -1) {
				SIL = SIL.add(new BigDecimal("" + object[5]));
			}

			if (DIL.compareTo(new BigDecimal("0")) == 0) {
				DIL = new BigDecimal("" + object[6]);
			} else if (DIL.compareTo(new BigDecimal("0")) == -1) {
				DIL = DIL.add(new BigDecimal("" + object[6]));
			}

			if (DINOUT.compareTo(new BigDecimal("0")) == 0) {
				DINOUT = new BigDecimal("0");
			} else if (DINOUT.compareTo(new BigDecimal("0")) == -1) {
				DINOUT = new BigDecimal("0");
			}

			if (DEATH.compareTo(new BigDecimal("0")) == 0) {
				DEATH = new BigDecimal("" + object[7]);
			} else if (DEATH.compareTo(new BigDecimal("0")) == -1) {
				DEATH = DEATH.add(new BigDecimal("" + object[7]));
			}

			if (REMG.compareTo(new BigDecimal("0")) == 0) {
				REMG = new BigDecimal("" + object[8]);
			} else if (REMG.compareTo(new BigDecimal("0")) == -1) {
				REMG = REMG.add(new BigDecimal("" + object[8]));
			}
			// Block for officers family Calculation
		}

		map.put("REMD", REMD);
		map.put("ADM", ADM);
		map.put("DIS", DIS);
		map.put("TIN", TIN);
		map.put("TOUT", TOUT);
		map.put("SIL", SIL);
		map.put("DIL", DIL);
		map.put("DINOUT", DINOUT);
		map.put("DEATH", DEATH);
		map.put("REMG", REMG);
		return map;
	}

	public Map<String, Object> getDeliveryDetailsForSearch() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		Session session =null;
		session = (Session) getSession();

		try {
			rankList = session
					.createQuery(
							"select rank from MasRank as rank where rank.Status='y'  order by rank.RankName ")
					.list();
			serviceTypeList = session.createCriteria(MasServiceType.class)
					.add(Restrictions.eq("Status", "y")).list();
			unitList = session.createCriteria(MasUnit.class)
					.add(Restrictions.eq("Status", "y")).list();
			wardList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("DepartmentType", "dt")
					.add(Restrictions.eq("dt.DepartmentTypeName", "Ward"))
					.list();
			map.put("rankList", rankList);
			map.put("serviceTypeList", serviceTypeList);
			map.put("unitList", unitList);
			map.put("wardList", wardList);
		} catch (Exception e) {
			e.printStackTrace();
		}//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 18 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDeliveryDetails(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		Session session = null;
		session = (Session) getSession();

		String hinNo = "";
		int inpatientId = 0;
		String adNo = "";
		int wardId = 0;
		String serviceNo = "";

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
try{
		List objectList = new ArrayList();
		objectList.add("A");
		Criteria crit = session.createCriteria(Inpatient.class).add(
				Restrictions.in("AdStatus", objectList));

		if (!adNo.equals("") && !hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("AdNo", adNo))
					.createAlias("Hin", "hin")
					.add(Restrictions.eq("hin.PatientStatus", "In Patient"));
		} else if (!adNo.equals("") && hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("AdNo", adNo));
		}
		if (adNo.equals("")) {
			crit = crit.createAlias("Hin", "hin").add(
					Restrictions.eq("hin.PatientStatus", "In Patient"));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		if (wardId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", wardId));
		}
		if (inpatientId != 0) {
			crit = crit.add(Restrictions.idEq(inpatientId));
		}

		inPatientList = crit.list();

		/*
		 * This part is commented because of new reqirement That is patient will
		 * discharged without discharge Summary
		 *
		 * Changed by ------------------Vivek
		 *
		 * for (Inpatient inpatient : inPatientTempList) { String admNo =
		 * inpatient.getAdNo(); dischargeSummaryList =
		 * session.createCriteria(DischargeSummary
		 * .class).add(Restrictions.eq("AdNo", admNo)).list();
		 * if(dischargeSummaryList.size() > 0){ inPatientList.add(inpatient); }
		 * }
		 */
		}catch (Exception e) {
			 e.printStackTrace();
		}
		//finally{
			/**
			 * session.close() is done By Ramdular Prajapati
			 * Date 18 May 2010
			 */
			/*if(session!=null){
				session.close();
			}
		}*/
		map.put("inpatientList", inPatientList);
		return map;
	}

	public Map<String, Object> getMotherAndBabyDetails(
			Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasDepartment> deliveryDetailsList = new ArrayList<MasDepartment>();
		int inpatientId = 0;
		Session session = (Session) getSession();
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
		}

		try {
			deliveryDetailsList = session.createCriteria(DeliveryDetails.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

			map.put("deliveryDetailsList", deliveryDetailsList);
		} catch (Exception e) {
			e.printStackTrace();
		}

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

	public Map<String, Object> getMotherBabyDeatils(Map<String, Object> mapForDs) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
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


			map.put("inPatientList", inPatientList);
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public Map<String, Object> addMotherDetails(Map<String, Object> mapForDs) {
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
		int bP = 0;
		String additionalNotes = "";
		String complications = "";

		int assistedBy = 0;
		int masEmpIdConductedBy = 0;
		int masEmpIdAssistedBy = 0;
		int hospitalId = 0;
		int hinId = 0;

		Session session = (Session) getSession();
		List<DeliveryDetails> deliveryDetailsList = new ArrayList<DeliveryDetails>();

		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("masEmpIdConductedBy") != null) {
			masEmpIdConductedBy = (Integer) mapForDs.get("masEmpIdConductedBy");
		}
		if (mapForDs.get("masEmpIdAssistedBy") != null) {
			masEmpIdAssistedBy = (Integer) mapForDs.get("masEmpIdAssistedBy");
		}
		if (mapForDs.get("inpatientId") != null) {
			inpatientId = (Integer) mapForDs.get("inpatientId");
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
			bP = (Integer) mapForDs.get("bP");
		}
		if (mapForDs.get("additionalNotes") != null) {
			additionalNotes = (String) mapForDs.get("additionalNotes");
		}
		if (mapForDs.get("complications") != null) {
			complications = (String) mapForDs.get("complications");
		}
		boolean saved = true;
		boolean duplicate = true;

		Transaction tx = session.beginTransaction();
		try {
			deliveryDetailsList = session.createCriteria(DeliveryDetails.class)
					.add(Restrictions.eq("Inpatient.Id", inpatientId)).list();

			if (deliveryDetailsList.size() == 0) {
				duplicate = false;

				DeliveryDetails deliveryDetails = new DeliveryDetails();

				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				deliveryDetails.setInpatient(inpatient);

				if (masEmpIdConductedBy != 0) {
					MasEmployee conductedByEmp = new MasEmployee();
					conductedByEmp.setId(masEmpIdConductedBy);
					deliveryDetails.setConductedBy(conductedByEmp);
				}
				if (masEmpIdAssistedBy != 0) {
					MasEmployee assistedByEmp = new MasEmployee();
					assistedByEmp.setId(masEmpIdAssistedBy);
					deliveryDetails.setAssistedBy(assistedByEmp);
				}

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				deliveryDetails.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				deliveryDetails.setHin(patient);

				deliveryDetails.setBloodLoss(bloodLoss);
				deliveryDetails.setPlacenta(placenta);
				deliveryDetails.setTreatment(treatment);
				deliveryDetails.setDateOfLabor(dateOnSet);
				deliveryDetails.setTimeOfLabor(timeOnSet);
				deliveryDetails.setPuperium(purperium);
				deliveryDetails.setMothersCondition(motherCondition);
				deliveryDetails.setPulse(pulse);
				deliveryDetails.setPerinum(perineum);
//				deliveryDetails.setBp(bP);
				deliveryDetails.setAdditionalNotes(additionalNotes);
				deliveryDetails.setComplications(complications);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(deliveryDetails);
			}
			tx.commit();
		} catch (Exception e) {
			saved = false;
			e.printStackTrace();
			tx.rollback();
		}
		String msg = "";
		if (saved) {
			if (duplicate) {
				msg = "Data Duplicate";
			} else {
				msg = "Data Saved";
			}
		} else {
			msg = "Data can not Saved";
		}
		map.put("msg", msg);
		return map;
	}

	public Map<String, Object> getBabyDetails(Map<String, Object> mapForDs) {

		List<MasCsIndication> masCsIndicationList = new ArrayList<MasCsIndication>();
		List<MasGestation> masGestationList = new ArrayList<MasGestation>();
		List<MasNeonatalProblem> masNeonatalProblemList = new ArrayList<MasNeonatalProblem>();
		List<MasBabyStatus> masBabyStatusList = new ArrayList<MasBabyStatus>();
		List<MasDeliveryType> masDeliveryTypeList = new ArrayList<MasDeliveryType>();
		List<BabyDetails> babyDetailsList = new ArrayList<BabyDetails>();

		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
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

			map.put("masCsIndicationList", masCsIndicationList);
			map.put("masGestationList", masGestationList);
			map.put("masNeonatalProblemList", masNeonatalProblemList);
			map.put("masBabyStatusList", masBabyStatusList);
			map.put("masDeliveryTypeList", masDeliveryTypeList);

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

		BabyDetails babyDetails = new BabyDetails();

		if (deliveryType != 0) {
			MasDeliveryType masDeliveryType = new MasDeliveryType();
			masDeliveryType.setId(deliveryType);
			babyDetails.setDeliveryType(masDeliveryType);
		}
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
		if (csIndication != 0) {
			MasCsIndication masCsIndication = new MasCsIndication();
			masCsIndication.setId(csIndication);
			//babyDetails.setCsIndication(masCsIndication);
		}
		if (gestation != 0) {
			MasGestation masGestation = new MasGestation();
			masGestation.setId(gestation);
			//babyDetails.setGestation(masGestation);
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
			//babyDetails.setMasNeonatalProblem(masNeonatalProblem);
		}
		if (babyStatus != 0) {
			MasBabyStatus masBabyStatus = new MasBabyStatus();
			masBabyStatus.setId(babyStatus);
			//babyDetails.setBabyStatus(masBabyStatus);
		}
		babyDetails.setOutcome(outCome);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.save(babyDetails);
		return map;

	}
}