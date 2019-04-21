package jkt.hrms.attendance.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jkt.hms.masters.business.EmpScMapping;
import jkt.hms.masters.business.EmployeeCategory;
import jkt.hms.masters.business.HrAbsentRegister;
import jkt.hms.masters.business.HrDutyScheduleM;
import jkt.hms.masters.business.HrDutyScheduleT;
import jkt.hms.masters.business.HrInstEmpDept;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.DateNotMatchedException;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.Holidaycalendar;
import jkt.hrms.masters.business.HrAttendanceLoader;
import jkt.hrms.masters.business.HrEmployeeShiftDetails;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLocation;
import jkt.hrms.masters.business.HrMasParameterMaintenance;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;
import jkt.hrms.masters.business.HrParameter;
import jkt.hrms.masters.business.MasDesignation;
import jkt.hrms.masters.business.MasShift;
import jkt.hrms.masters.business.TempAttendanceData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.tools.ant.taskdefs.FixCRLF.AddAsisRemove;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class AttendanceDataServiceImpl extends HibernateDaoSupport implements
		AttendanceDataService {

	@SuppressWarnings("unchecked")
	Map<String, Object> map = new HashMap<String, Object>();
	public Map<String, Object> showEmployeeDetails() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrEmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		Session session = (Session) getSession();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		employeeShiftDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeShiftDetails");
		map.put("masEmployeeList", masEmployeeList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("employeeShiftDetailsList", employeeShiftDetailsList);
		return map;
	}

	public Map<String, Object> saveEmployeeShiftDetails(
			HrEmployeeShiftDetails hrEmployeeShiftDetails) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrEmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		List<HrEmployeeShiftDetails> existingEmployeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		int employeeId = 0;
		employeeId = hrEmployeeShiftDetails.getEmployee().getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sdf.format(hrEmployeeShiftDetails
				.getShiftStartDate());
		String endDate = sdf.format(hrEmployeeShiftDetails.getShiftEndDate());
		existingEmployeeShiftDetailsList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEmployeeShiftDetails as esd where esd.Employee.Id = '"
						+ employeeId
						+ "' and esd.ShiftStartDate <= '"
						+ startDate
						+ "' and esd.ShiftEndDate >= '"
						+ endDate
						+ "'");
		String message = "";
		if (existingEmployeeShiftDetailsList.size() > 0) {
			message = "Record Already Exist";
		} else {
			hbt.save(hrEmployeeShiftDetails);
			message = "Record saved successfully";
		}

		employeeShiftDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeShiftDetails");
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("masEmployeeList", masEmployeeList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("message", message);
		map.put("employeeShiftDetailsList", employeeShiftDetailsList);
		return map;
	}

	public Map<String, Object> editEmployeeShiftDetail(int employeeShiftDetailId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrEmployeeShiftDetails> singleEmployeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		List<HrEmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		singleEmployeeShiftDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeShiftDetails as sd where sd.Id = '"
						+ employeeShiftDetailId + "'");
		employeeShiftDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeShiftDetails");
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("singleEmployeeShiftDetailsList",
				singleEmployeeShiftDetailsList);
		map.put("employeeShiftDetailsList", employeeShiftDetailsList);
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateEmployeeShiftDetails(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrEmployeeShiftDetails> employeeShiftDetailsList = new ArrayList<HrEmployeeShiftDetails>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		Session session = (Session) getSession();
		int employeeShiftDetailId = 0;
		if (parameterMap.get("employeeShiftDetailId") != null) {
			employeeShiftDetailId = (Integer) parameterMap
					.get("employeeShiftDetailId");
		}
		int employeeId = 0;
		if (parameterMap.get("employeeId") != null) {
			employeeId = (Integer) parameterMap.get("employeeId");
		}
		int mondayShiftId = 0;
		if (parameterMap.get("mondayShiftId") != null) {
			mondayShiftId = (Integer) parameterMap.get("mondayShiftId");
		}
		int tuesdayShiftId = 0;
		if (parameterMap.get("tuesdayShiftId") != null) {
			tuesdayShiftId = (Integer) parameterMap.get("tuesdayShiftId");
		}
		int wednesdayShiftId = 0;
		if (parameterMap.get("wednesdayShiftId") != null) {
			wednesdayShiftId = (Integer) parameterMap.get("wednesdayShiftId");
		}
		int thursdayShiftId = 0;
		if (parameterMap.get("thursdayShiftId") != null) {
			thursdayShiftId = (Integer) parameterMap.get("thursdayShiftId");
		}
		int fridayShiftId = 0;
		if (parameterMap.get("fridayShiftId") != null) {
			fridayShiftId = (Integer) parameterMap.get("fridayShiftId");
		}
		int saturdayShiftId = 0;
		if (parameterMap.get("saturdayShiftId") != null) {
			saturdayShiftId = (Integer) parameterMap.get("saturdayShiftId");
		}
		int sundayShiftId = 0;
		if (parameterMap.get("sundayShiftId") != null) {
			sundayShiftId = (Integer) parameterMap.get("sundayShiftId");
		}
		Date shiftStartDate = new Date();
		if (parameterMap.get("shiftStartDate") != null) {
			shiftStartDate = (Date) parameterMap.get("shiftStartDate");
		}

		Date shiftEndDate = null;
		if (parameterMap.get("shiftEndDate") != null) {
			shiftEndDate = (Date) parameterMap.get("shiftEndDate");
		}
		String lastchangeBy = "";
		if (parameterMap.get("lastchangeBy") != null) {
			lastchangeBy = (String) parameterMap.get("lastchangeBy");
		}
		Date changedDate = new Date();
		if (parameterMap.get("changedDate") != null) {
			changedDate = (Date) parameterMap.get("changedDate");
		}
		String changedTime = "";
		if (parameterMap.get("changedTime") != null) {
			changedTime = (String) parameterMap.get("changedTime");
		}
		HrEmployeeShiftDetails hrEmployeeShiftDetails = new HrEmployeeShiftDetails();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hrEmployeeShiftDetails = (HrEmployeeShiftDetails) hbt.load(
				HrEmployeeShiftDetails.class, employeeShiftDetailId);

		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrEmployeeShiftDetails.setEmployee(masEmployee);

		HrMasShiftCodes monMasShiftCodes = new HrMasShiftCodes();
		monMasShiftCodes.setId(mondayShiftId);
		hrEmployeeShiftDetails.setMondayShift(monMasShiftCodes);

		HrMasShiftCodes tuesMasShiftCodes = new HrMasShiftCodes();
		tuesMasShiftCodes.setId(tuesdayShiftId);
		hrEmployeeShiftDetails.setTuesdayShift(tuesMasShiftCodes);

		HrMasShiftCodes wednesMasShiftCodes = new HrMasShiftCodes();
		wednesMasShiftCodes.setId(wednesdayShiftId);
		hrEmployeeShiftDetails.setWednesdayShift(wednesMasShiftCodes);

		HrMasShiftCodes thursMasShiftCodes = new HrMasShiftCodes();
		thursMasShiftCodes.setId(thursdayShiftId);
		hrEmployeeShiftDetails.setThursdayShift(thursMasShiftCodes);

		HrMasShiftCodes friMasShiftCodes = new HrMasShiftCodes();
		friMasShiftCodes.setId(fridayShiftId);
		hrEmployeeShiftDetails.setFridayShift(friMasShiftCodes);

		HrMasShiftCodes saturMasShiftCodes = new HrMasShiftCodes();
		saturMasShiftCodes.setId(saturdayShiftId);
		hrEmployeeShiftDetails.setSaturdayShift(saturMasShiftCodes);

		HrMasShiftCodes sunMasShiftCodes = new HrMasShiftCodes();
		sunMasShiftCodes.setId(sundayShiftId);
		hrEmployeeShiftDetails.setSundayShift(sunMasShiftCodes);

		hrEmployeeShiftDetails.setShiftStartDate(shiftStartDate);
		hrEmployeeShiftDetails.setShiftEndDate(shiftEndDate);
		hrEmployeeShiftDetails.setLastChgBy(lastchangeBy);
		hrEmployeeShiftDetails.setLastChgDate(changedDate);
		hrEmployeeShiftDetails.setLastChgTime(changedTime);
		hrEmployeeShiftDetails.setStatus("y");
		hbt.update(hrEmployeeShiftDetails);
		hbt.refresh(hrEmployeeShiftDetails);
		boolean flag = false;
		flag = true;
		String message = "";
		if (flag) {
			message = " Employee Shift Details Updated Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		employeeShiftDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeShiftDetails ");
		map.put("employeeShiftDetailsList", employeeShiftDetailsList);
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee ");
		map.put("masEmployeeList", masEmployeeList);
		map.put("message", message);
		map.put("masShiftCodesList", masShiftCodesList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showShiftJsp(int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		//masDepartmentList = getHibernateTemplate().find("from jkt.hms.masters.business.MasDepartment"); 
		masDepartmentList=session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();
		//System.out.println("masDepartmentList>>>>>>>>"+masDepartmentList.size());
		masShiftList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasShift hs where hs.Hospital.Id="+hospitalId);
		//masEmpCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmpCategory");
		masEmpCategoryList = session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("EmpCategoryName")).list();
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftList", masShiftList);
		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveShiftDetails(HrMasShift hrMasShift,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasShift> existingMassShiftList = new ArrayList<MasShift>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		// boolean successfullyAdded=false;
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int shiftCodeId = 0;
		shiftCodeId = hrMasShift.getShiftCodes().getId();
		String startTime = hrMasShift.getShiftStartTime();
		String endTime = hrMasShift.getShiftEndTime();
		existingMassShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift as ms where ms.ShiftCodes.Id = "
						+ shiftCodeId + " and ms.ShiftStartTime = '"
						+ startTime + "' and ms.ShiftEndTime = '" + endTime
						+ "' and ms.Hospital.Id="+hospitalId+" and EmployeeCategory.Id="+hrMasShift.getEmployeeCategory().getId());
		// successfullyAdded=true;
		if (existingMassShiftList.size() > 0) {
			message = "Data Already Exist.";
		} else {
			hbt.save(hrMasShift);
			message = "Data Saved Successfully.";
		}

		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment where lower(Status)='y'");
		masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift ms where ms.Hospital.Id="+hospitalId);
		masEmpCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmpCategory where lower(Status)='y'");
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("masShiftList", masShiftList);
		map.put("masEmpCategoryList",masEmpCategoryList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editShiftDetails(int shiftId,int hospitalId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> singleMasShiftList = new ArrayList<HrMasShift>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment  where lower(Status)='y' order by DepartmentName");
		singleMasShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift as ms where ms.Id = '"
						+ shiftId + "'");
		masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift ms where ms.Hospital.Id="+hospitalId);
		
		masEmpCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmpCategory where lower(Status)='y' order by EmpCategoryName");
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("singleMasShiftList", singleMasShiftList);
		map.put("masShiftList", masShiftList);
		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List getLateEmployeeList(MasEmployee user) {
		List<HrAttendanceLoader> approvedLeaves = new ArrayList<HrAttendanceLoader>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrAttendanceLoader.class);

		Date currentDate = new Date();
		String lateTime = "10:00:00";
		crit = crit.add(Restrictions.gt("TimeIn", lateTime));

		approvedLeaves = crit.list();
		return approvedLeaves;

	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updateShiftDetails(
			Map<String, Object> parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasShift> existingMassShiftList = new ArrayList<MasShift>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		Session session = (Session) getSession();
		boolean updated = false;
		int shiftId = 0;
		if (parameterMap.get("shiftId") != null) {
			shiftId = (Integer) parameterMap.get("shiftId");
		}
		int shiftCodeId = 0;
		if (parameterMap.get("shiftCodeId") != null) {
			shiftCodeId = (Integer) parameterMap.get("shiftCodeId");
		}
		int departmentId = 0;
		if (parameterMap.get("departmentId") != null) {
			departmentId = (Integer) parameterMap.get("departmentId");
		}
		int empCatId = 0;
		if (parameterMap.get("empCatId") != null) {
			empCatId = (Integer) parameterMap.get("empCatId");
		}
		String shiftStartTime = "";
		if (parameterMap.get("shiftStartTime") != null) {
			shiftStartTime = (String) parameterMap.get("shiftStartTime");
		}
		String shiftEndTime = "";
		if (parameterMap.get("shiftEndTime") != null) {
			shiftEndTime = (String) parameterMap.get("shiftEndTime");
		}

		String lastchangeBy = "";
		if (parameterMap.get("lastchangeBy") != null) {
			lastchangeBy = (String) parameterMap.get("lastchangeBy");
		}
		Date changedDate = null;
		if (parameterMap.get("changedDate") != null) {
			changedDate = (Date) parameterMap.get("changedDate");
		}

		String changedTime = "";
		if (parameterMap.get("changedTime") != null) {
			changedTime = (String) parameterMap.get("changedTime");
		}
		int hospitalId = (Integer)parameterMap.get("hospitalId");
		
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasShift hrMasShift = (HrMasShift) hbt
				.load(HrMasShift.class, shiftId);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		hrMasShift.setDepartment(masDepartment);
		HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
		hrMasShiftCodes.setId(shiftCodeId);
		hrMasShift.setShiftCodes(hrMasShiftCodes);
		hrMasShift.setShiftStartTime(shiftStartTime);
		hrMasShift.setShiftEndTime(shiftEndTime);
		//hrMasShift.setLastChgBy(lastchangeBy);
		
		MasEmpCategory masEmpCategory = new MasEmpCategory();
		masEmpCategory.setId(empCatId);
		hrMasShift.setEmployeeCategory(masEmpCategory);
		
		hrMasShift.setLastChgDate(changedDate);
		hrMasShift.setLastChgTime(changedTime);
		hbt.update(hrMasShift);
		updated = true;
		// existingMassShiftList = getHibernateTemplate().find("from
		// jkt.hrms.masters.business.HrMasShift as ms where ms.Department.Id =
		// "+departmentId+"");
		String message = "";
		if (updated) {
			message = "Data update Successfully.";
		} else {
			message = "Some Problem Occured.";
		}

		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y")).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment where lower(Status)='y'");
		masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift ms where ms.Hospital.Id="+hospitalId);
		masEmpCategoryList = getHibernateTemplate().find("from jkt.hms.masters.business.MasEmpCategory");
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("message", message);
		map.put("masShiftList", masShiftList);
		map.put("masEmpCategoryList", masEmpCategoryList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> importAttendanceFile(
			Map<String, Object> generalMap) throws DateNotMatchedException {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = getSession();
		int count = 0;
		int totalRows = 0;
		// Date attendanceDate = null;
		List<String> cardNoList = new ArrayList<String>();
		List<String> empNameList = new ArrayList<String>();
		List<String> inTimeList = new ArrayList<String>();
		List<String> outTimeList = new ArrayList<String>();
		List<String> dateList = new ArrayList<String>();
		String uploadURL = "";

		if (generalMap.get("uploadURL") != null) {
			uploadURL = (String) generalMap.get("uploadURL");
		}
		String attendanceDate = "";
		if (generalMap.get("attendanceDate") != null) {
			attendanceDate = (String) generalMap.get("attendanceDate");
		}
		try {
			File f = null;
			if (generalMap.get("file") != null) {
				f = (File) generalMap.get("file");
			}
			FileInputStream fis = new FileInputStream(f);
			// BufferedReader bRead = null;
			// String line="";
			long length = f.length();
			if (f != null && length > Integer.MAX_VALUE) {

			}
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(f));

			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			String inTime = new String();
			String outTime = new String();
			String cardNo = "";
			String employeeName = "";
			HSSFRow row;
			HSSFCell cell7;
			HSSFCell cell8;
			HSSFCell cell2;
			HSSFCell cell3;
			HSSFCell cellDate;
			// code by shaileshfor getting card no of all employess
			List<MasEmployee> employeList = new ArrayList<MasEmployee>();

			employeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.isNotNull("CardNo")).list();
			List<String> cardList = new ArrayList<String>();
			for (MasEmployee masEmployee : employeList) {
				cardList.add(masEmployee.getCardNo());
			}

			HSSFRow rowDate = sheet.getRow(4);
			Date attDate = null;
			if ((rowDate.getCell((short) 0) != null)) {
				cellDate = rowDate.getCell((short) 0);
				attDate = cellDate.getDateCellValue();

			} else {
				attDate = null;
			}
			if (attDate != null
					&& !attDate.equals(HMSUtil
							.convertStringTypeDateToDateType(attendanceDate))) {
				throw new DateNotMatchedException();
			}

			if (sheet.getRow(0) != null) {
				totalRows = sheet.getLastRowNum() - 7;
				for (int i = 7; i < sheet.getLastRowNum(); i++) {

					row = sheet.getRow(i);
					cell2 = row.getCell((short) 2);
					cell3 = row.getCell((short) 3);

					cardNo = cell2.getStringCellValue();

					if (cardList.contains(cardNo)) {
						count++;

						List<MasEmployee> employeeList = session
								.createCriteria(MasEmployee.class)
								.add(Restrictions.eq("CardNo", cardNo)).list();

						employeeName = employeeList.get(0).getFirstName() + " "
								+ employeeList.get(0).getLastName();
						cardNoList.add(cardNo);
						empNameList.add(employeeName);
						if ((row.getCell((short) 7) != null)) {
							cell7 = row.getCell((short) 7);
							inTime = cell7.getDateCellValue().getHours() + ":"
									+ cell7.getDateCellValue().getMinutes();

						} else {
							inTime = "0";
						}
						inTimeList.add(inTime);
						if (row.getCell((short) 8) != null) {
							cell8 = row.getCell((short) 8);
							outTime = cell8.getDateCellValue().getHours() + ":"
									+ cell8.getDateCellValue().getMinutes();

						} else {
							outTime = "0";
						}
						outTimeList.add(outTime);
						dateList.add(attendanceDate);
					}
				}
			}

			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int x = totalRows - count;
		map.put("discardedCardNos", x);
		map.put("cardNoList", cardNoList);
		map.put("empNameList", empNameList);
		map.put("inTimeList", inTimeList);
		map.put("outTimeList", outTimeList);
		map.put("dateList", dateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> processDataInAttendanceFile(
			Map<String, Object> generalMap) {
		Session session = getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List employeeAttendanceList = new ArrayList();
		List<String> cardNoList = new ArrayList<String>();
		List<String> empNameList = new ArrayList<String>();
		List<String> inTimeList = new ArrayList<String>();
		List<String> outTimeList = new ArrayList<String>();
		List<String> dateList = new ArrayList<String>();
		if (generalMap.get("employeeAttendanceList") != null) {
			employeeAttendanceList = (List) generalMap
					.get("employeeAttendanceList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String cardNo = "";
		if (employeeAttendanceList.size() > 0) {
			for (int i = 0; i < employeeAttendanceList.size(); i++) {
				HrAttendanceLoader hrAttendanceLoader = (HrAttendanceLoader) employeeAttendanceList
						.get(i);
				cardNo = hrAttendanceLoader.getCardNo();
				List<MasEmployee> employeeList = session
						.createCriteria(MasEmployee.class)
						.add(Restrictions.eq("CardNo", cardNo)).list();
				hrAttendanceLoader.setEmployee(new MasEmployee(employeeList
						.get(0).getId()));
				hrAttendanceLoader.setVerified("No");
				hrAttendanceLoader.setValidate("No");
				hbt.save(hrAttendanceLoader);
			}
		}
		boolean flag = false;
		flag = true;
		String message = "";
		if (flag) {
			message = " Record save Successfully.";

		} else {
			message = "Some problem Occured! Try Again.";
		}
		map.put("cardNoList", cardNoList);
		map.put("empNameList", empNameList);
		map.put("inTimeList", inTimeList);
		map.put("outTimeList", outTimeList);
		map.put("dateList", dateList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showShiftCodeJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.list();
		map.put("masShiftCodesList", masShiftCodesList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> saveShiftCode(HrMasShiftCodes hrMasShiftCodes) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasShiftCodes> existingShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		String shiftCode = hrMasShiftCodes.getShiftCode();
		String shiftName = hrMasShiftCodes.getShiftName();
		existingShiftCodeList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShiftCodes as msc where msc.ShiftCode = '"
						+ shiftCode + "' and msc.ShiftName = '" + shiftName
						+ "'");
		if (existingShiftCodeList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.save(hrMasShiftCodes);
			message = "Record save successfully";
		}
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class).list();
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("existingShiftCodeList", existingShiftCodeList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editShiftCode(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasShiftCodes> existingShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		Session session = (Session) getSession();
		int shiftCodeId = 0;
		if (generalMap.get("shiftCodeId") != null) {
			shiftCodeId = (Integer) generalMap.get("shiftCodeId");
		}
		String shiftCode = "";
		if (generalMap.get("shiftCode") != null) {
			shiftCode = (String) generalMap.get("shiftCode");
		}
		String shiftName = "";
		if (generalMap.get("shiftName") != null) {
			shiftName = (String) generalMap.get("shiftName");
		}
		int userId = 0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		Date currentDate = null;
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasShiftCodes hrMasShiftCodes = (HrMasShiftCodes) hbt.load(
				HrMasShiftCodes.class, shiftCodeId);
		hrMasShiftCodes.setShiftCode(shiftCode);
		hrMasShiftCodes.setShiftName(shiftName);
		Users user = new Users();
		user.setId(userId);
		hrMasShiftCodes.setLastChgBy(user);
		hrMasShiftCodes.setLastChgDate(currentDate);
		hrMasShiftCodes.setLastChgTime(currentTime);
		existingShiftCodeList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShiftCodes as msc where msc.ShiftCode = '"
						+ shiftCode + "' and msc.ShiftName = '" + shiftName
						+ "' and msc.Id != '" + shiftCodeId + "'");
		String message = "";
		if (existingShiftCodeList.size() > 0) {
			message = "Record already exist";
		} else {
			hbt.update(hrMasShiftCodes);
			message = "Record update successfully";
		}
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.list();
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("existingShiftCodeList", existingShiftCodeList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> deleteShiftCode(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		Session session = (Session) getSession();
		boolean dataDeleted = false;
		int shiftCodeId = 0;
		if (generalMap.get("shiftCodeId") != null) {
			shiftCodeId = (Integer) generalMap.get("shiftCodeId");
		}
		int userId = 0;
		if (generalMap.get("userId") != null) {
			userId = (Integer) generalMap.get("userId");
		}
		Date currentDate = new Date();
		if (generalMap.get("currentDate") != null) {
			currentDate = (Date) generalMap.get("currentDate");
		}
		String currentTime = "";
		if (generalMap.get("currentTime") != null) {
			currentTime = (String) generalMap.get("currentTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasShiftCodes hrMasShiftCodes = (HrMasShiftCodes) hbt.load(
				HrMasShiftCodes.class, shiftCodeId);
		Users user = new Users();
		user.setId(userId);
		hrMasShiftCodes.setLastChgBy(user);
		hrMasShiftCodes.setLastChgDate(currentDate);
		hrMasShiftCodes.setLastChgTime(currentTime);
		if (generalMap.get("flag") != null) {
			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				hrMasShiftCodes.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				hrMasShiftCodes.setStatus("y");
				dataDeleted = false;
			}
		}
		hbt.update(hrMasShiftCodes);
		String message = "";
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.list();
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> searchShiftCode(String shiftCode,
			String shiftName) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();

		try {
			if ((shiftName != null) || (shiftCode == null)) {

				masShiftCodesList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasShiftCodes  msc where msc.ShiftName like '"
								+ shiftName + "%' order by msc.ShiftName");
			} else {
				masShiftCodesList = getHibernateTemplate()
						.find("from jkt.hrms.masters.business.HrMasShiftCodes  msc where msc.ShiftCode like '"
								+ shiftCode + "%' order by msc.ShiftCode");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masShiftCodesList", masShiftCodesList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showEmployeeAttendanceJsp(int new_employee_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<Integer> maxEmployeeAttendanceList = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasDesignation> masDesignationList = new ArrayList<MasDesignation>();
	
		Session session = (Session) getSession();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("EmployeeName")).list();;			
		parameterList = session.createCriteria(HrParameter.class).list();
		masShiftCodeList = session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ShiftName")).list();
		
		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();				
		masDesignationList = session.createCriteria(MasDesignation.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DesignationName")).list();
				
		maxEmployeeAttendanceList = getHibernateTemplate()
				.find("select max(Id) from jkt.hrms.masters.business.HrAttendanceLoader ");
		int maxEmployeeAttendanceId = 0;
		if (maxEmployeeAttendanceList.size() > 0) {
			if ((Integer) maxEmployeeAttendanceList.get(0) != null) {
				maxEmployeeAttendanceId = (Integer) maxEmployeeAttendanceList
						.get(0);
				attendanceList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrAttendanceLoader as al where al.id = '"
								+ maxEmployeeAttendanceId + "'");
			}

		}
		map.put("attendanceList", attendanceList);
		map.put("masShiftCodeList", masShiftCodeList);
		map.put("parameterList", parameterList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("masDepartmentList", masDepartmentList);
	
		map.put("masDesignationList", masDesignationList);
		return map;
	}
	
	//public Map<String, Object> showEmployeeAttendanceForAdminJsp() {
	
	public Map<String, Object> showEmployeeAttendanceForAdminJsp(Map<String, Object> parameterMap) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasEmployee> masEmployeeList2 = new ArrayList<MasEmployee>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrAbsentRegister> absentList = new ArrayList<HrAbsentRegister>();
		List<Integer> maxEmployeeAttendanceList = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasRank> masDesignationList = new ArrayList<MasRank>();
		List<MasEmployeeDepartment> masEmployeeDepartments=new ArrayList<MasEmployeeDepartment>();
		Session session = (Session) getSession();
		masEmployeeList = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("EmployeeName")).list();
		masEmployeeList2 = session.createCriteria(MasEmployee.class).add(Restrictions.eq("Status","y").ignoreCase()).addOrder(Order.asc("EmployeeName")).list();
		parameterList = session.createCriteria(HrParameter.class).list();
		masShiftCodeList = session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ShiftName")).list();
		
		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();				
		masDesignationList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("RankName")).list();
		
		maxEmployeeAttendanceList = getHibernateTemplate().find("select max(Id) from jkt.hrms.masters.business.HrAttendanceLoader ");
		int maxEmployeeAttendanceId = 0;
		/*if(maxEmployeeAttendanceList.size()>0){
			
			
			if((Integer)maxEmployeeAttendanceList.get(0)!= null){
				maxEmployeeAttendanceId = (Integer)maxEmployeeAttendanceList.get(0);
				attendanceList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrAttendanceLoader as al where al.id = '"+maxEmployeeAttendanceId+"'");
			}

		}*/
		
		java.util.Date date = (java.util.Date)parameterMap.get("date");
		int hos = (Integer)parameterMap.get("hospitalId");
		
		attendanceList  = session.createCriteria(HrAttendanceLoader.class).add(Restrictions.eq("Date", date)).add(Restrictions.eq("Validate", "n"))
					.add(Restrictions.eq("Status", "y")).add(Restrictions.eq("Hospital.Id", hos)).list();
		absentList	 = session.createCriteria(HrAbsentRegister.class).add(Restrictions.eq("AbsentDate", date)).add(Restrictions.eq("Status", "y"))
						.add(Restrictions.eq("Hospital.Id", hos)).list();
		//--- For geting Hospital wise department
//		System.out.println(masEmployeeList.size()+"======"+masEmployeeList2.size());
		masEmployeeDepartments=getEmployeeDepartmentId(hos);
		map.put("attendanceList", attendanceList);
		map.put("masShiftCodeList", masShiftCodeList);
		map.put("parameterList", parameterList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("masEmployeeList2", masEmployeeList2);
//		map.put("masDepartmentList", masDepartmentList);
		map.put("masDesignationList", masDesignationList);
		map.put("absentList", absentList);
		map.put("masEmployeeDepartments", masEmployeeDepartments);
		return map;
	}
	//---Method For geting Hospital wise department
	public List<MasEmployeeDepartment> getEmployeeDepartmentId(int hospitalId){
		Session session=(Session)getSession();
		List<Integer> departmentList=new ArrayList<Integer>();
		List<MasEmployeeDepartment> masEmployeeDepartments=new ArrayList<MasEmployeeDepartment>();
		List<HrInstEmpDept> hrInstEmpDept=(List<HrInstEmpDept>)session.createCriteria(HrInstEmpDept.class).createAlias("Institute", "h").add(Restrictions.eq("h.Id", hospitalId)).add(Restrictions.eq("Status", "Y")).list();
		if(hrInstEmpDept.size()>0){
			String[] departmentId=hrInstEmpDept.get(0).getEmployeeDepartment().split(",");
			for(int i=0;i<departmentId.length;i++){
				departmentList.add(Integer.parseInt(departmentId[i]));
			}
			masEmployeeDepartments=session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.in("Id", departmentList)).add(Restrictions.eq("Status", "Y").ignoreCase()).list();
		}
		
		return masEmployeeDepartments;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> saveEmployeeAttenadance(HrAttendanceLoader hrAttendanceLoader) {
			
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> existingAttendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<Integer> maxEmployeeAttendanceList = new ArrayList<Integer>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		int employeeId = hrAttendanceLoader.getEmployee().getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String attendanceDate = sdf.format(hrAttendanceLoader.getDate());
		existingAttendanceList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrAttendanceLoader as al where al.Employee.Id = "
						+ employeeId
						+ " and al.Date = '"
						+ attendanceDate
						+ "' ");
		String message = "";
		if (existingAttendanceList.size() > 0) {
			message = "Attendance Allready Mark";
		} else {
			hbt.save(hrAttendanceLoader);
			message = "Record save successfully";
		}
		maxEmployeeAttendanceList = getHibernateTemplate()
				.find("select max(Id) from jkt.hrms.masters.business.HrAttendanceLoader ");
		int maxEmployeeAttendanceId = 0;
		if (maxEmployeeAttendanceList.size() > 0) {
			if ((Integer) maxEmployeeAttendanceList.get(0) != null) {
				maxEmployeeAttendanceId = (Integer) maxEmployeeAttendanceList
						.get(0);
				attendanceList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrAttendanceLoader as al where al.id = '"
								+ maxEmployeeAttendanceId + "'");
			}

		}

		//map = showEmployeeAttendanceJsp();
		map.put("attendanceList", attendanceList);
		map.put("existingAttendanceList", existingAttendanceList);
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> editEmployeeAttendance(int employeeAttendanceId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<Integer> maxEmployeeAttendanceList = new ArrayList<Integer>();
		List<HrAttendanceLoader> singleAttendanceList = new ArrayList<HrAttendanceLoader>();
		singleAttendanceList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrAttendanceLoader as al where al.Id = '"
						+ employeeAttendanceId + "'");
		maxEmployeeAttendanceList = getHibernateTemplate()
				.find("select max(Id) from jkt.hrms.masters.business.HrAttendanceLoader ");
		int maxEmployeeAttendanceId = 0;
		if (maxEmployeeAttendanceList.size() > 0) {
			if ((Integer) maxEmployeeAttendanceList.get(0) != null) {
				maxEmployeeAttendanceId = (Integer) maxEmployeeAttendanceList
						.get(0);
				attendanceList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrAttendanceLoader as al where al.id = '"
								+ maxEmployeeAttendanceId + "'");
			}

		}
		//map = showEmployeeAttendanceJsp();
		map.put("singleAttendanceList", singleAttendanceList);
		map.put("attendanceList", attendanceList);
		return map;
	}

	public Map<String, Object> updateEmployeeAttendance(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updated = false;
		int employeeAttendanceId = 0;
		if (generalMap.get("employeeAttendanceId") != null) {
			employeeAttendanceId = (Integer) generalMap
					.get("employeeAttendanceId");
		}
		int employeeId = 0;
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		Date attendanceDate = null;
		if (generalMap.get("attendanceDate") != null) {
			attendanceDate = (Date) generalMap.get("attendanceDate");
		}
		String timeIn = "";
		if (generalMap.get("timeIn") != null) {
			timeIn = (String) generalMap.get("timeIn");
		}
		String timeOut = "";
		if (generalMap.get("timeOut") != null) {
			timeOut = (String) generalMap.get("timeOut");
		}
		String lastChgBy = "";
		if (generalMap.get("lastChgBy") != null) {
			lastChgBy = (String) generalMap.get("lastChgBy");
		}
		Date changedDate = null;
		if (generalMap.get("changedDate") != null) {
			changedDate = (Date) generalMap.get("changedDate");
		}
		String changedTime = "";
		if (generalMap.get("changedTime") != null) {
			changedTime = (String) generalMap.get("changedTime");
		}
		String remark = "";
		if (generalMap.get("remark") != null) {
			remark = (String) generalMap.get("remark");
		}
		String attendanceMark = "";
		if (generalMap.get("attendanceMark") != null) {
			attendanceMark = (String) generalMap.get("attendanceMark");
		}
		Date outDate = null;
		if (generalMap.get("outDate") != null) {
			outDate = (Date) generalMap.get("outDate");
		}
		int shiftCodeId = 0;
		if (generalMap.get("shiftCodeId") != null) {
			shiftCodeId = (Integer) generalMap.get("shiftCodeId");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrAttendanceLoader hrAttendanceLoader = (HrAttendanceLoader) hbt.load(
				HrAttendanceLoader.class, employeeAttendanceId);
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		hrAttendanceLoader.setEmployee(masEmployee);
		HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
		hrMasShiftCodes.setId(shiftCodeId);
		hrAttendanceLoader.setShiftCodes(hrMasShiftCodes);
		hrAttendanceLoader.setDate(attendanceDate);
		hrAttendanceLoader.setTimeIn(timeIn);
		hrAttendanceLoader.setTimeOut(timeOut);
		hrAttendanceLoader.setAttendanceMark(attendanceMark);
		hrAttendanceLoader.setOutDate(outDate);
		hrAttendanceLoader.setRemark(remark);
		//hrAttendanceLoader.setLastChgBy(lastChgBy);
		hrAttendanceLoader.setLastChgDate(changedDate);
		hrAttendanceLoader.setLastChgTime(changedTime);
		hbt.update(hrAttendanceLoader);
		updated = true;
		String message = "";
		if (updated) {
			message = "Data update Successfully.";
		} else {
			message = "Some Problem Occured.";
		}
		//map = showEmployeeAttendanceJsp();
		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> displayEmployeeAttenadance(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> attendanceList = new ArrayList<HrAttendanceLoader>();
		List<HrParameter> parameterList = new ArrayList<HrParameter>();
		List<Holidaycalendar> holidayList = new ArrayList<Holidaycalendar>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		int employeeId = 0;
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		Date fromDate = null;
		if (generalMap.get("fromDate") != null) {
			fromDate = (Date) generalMap.get("fromDate");
		}
		Date toDate = null;
		if (generalMap.get("toDate") != null) {
			toDate = (Date) generalMap.get("toDate");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDate = sdf.format(fromDate);
		String secDate = sdf.format(toDate);
		masEmployeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		attendanceList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrAttendanceLoader as al where al.Employee.Id = '"
						+ employeeId
						+ "' and al.Date between '"
						+ firstDate
						+ "' and '" + secDate + "' ");
		parameterList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrParameter");
		holidayList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.Holidaycalendar");
		map.put("masEmployeeList", masEmployeeList);
		map.put("attendanceList", attendanceList);
		map.put("parameterList", parameterList);
		map.put("holidayList", holidayList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showDatawiseAttendanceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showLateAttendanceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showAttendanceCardReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("masEmployeeList", masEmployeeList);
		map.put("masDepartmentList", masDepartmentList);
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

	public Map<String, Object> printEmployeeAttendanceCardReport(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> attendanceCardReportList = new ArrayList<HrAttendanceLoader>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		int employeeId = 0;
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		int departmentId = 0;
		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		Date fromDate = new Date();
		if (generalMap.get("fromDate") != null) {
			fromDate = (Date) generalMap.get("fromDate");
		}
		Date toDate = new Date();
		if (generalMap.get("toDate") != null) {
			toDate = (Date) generalMap.get("toDate");
		}
		attendanceCardReportList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as hld right join hld.leaveType as type where hld.EmpId.Id = "
						+ employeeId + " ");
		for (Iterator iterator = attendanceCardReportList.iterator(); iterator
				.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			HrLeaveDetails hrLeaveDetails = (HrLeaveDetails) object[0];
			HrMasLeaveTypeMediator hrMasLeave = (HrMasLeaveTypeMediator) object[1];

		}

		map.put("conn", con);
		return map;
	}

	public Map<String, Object> getEmployeeList(int departmentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			List<MasEmployee> employeeList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.add(Restrictions.eq("Department.Id", departmentId)).list();
			map.put("employeeList", employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getWeekands() {
		Session session = getSession();
		List<HrMasParameterMaintenance> parameterList = new ArrayList<HrMasParameterMaintenance>();
		List<Integer> weekendList = new ArrayList<Integer>();
		try {
			parameterList = session
					.createCriteria(HrMasParameterMaintenance.class)
					.addOrder(Order.desc("Id")).list();
			if (parameterList.get(0).getHoliday1() != null) {
				weekendList.add(Integer.parseInt(parameterList.get(0)
						.getHoliday1()));

			}
			if (parameterList.get(0).getHoliday2() != null) {
				weekendList.add(Integer.parseInt(parameterList.get(0)
						.getHoliday2()));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weekendList;
	}

	@SuppressWarnings("unchecked")
	public int getNoOfLegalHolidays(java.util.Date startDate,
			java.util.Date endDate) {
		Session session = getSession();
		List<Holidaycalendar> holidayCalendarList = new ArrayList<Holidaycalendar>();
		try {

			holidayCalendarList = session
					.createCriteria(Holidaycalendar.class)
					.add(Restrictions
							.between("HolidayDate", startDate, endDate)).list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidayCalendarList.size();
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> showMonthlyAttendanceReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		masEmployeeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee");
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		map.put("masEmployeeList", masEmployeeList);
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	public Map<String, Object> showMonthlyAttendanceStatusReportJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		masDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("masDepartmentList", masDepartmentList);
		return map;
	}

	//public Map<String, Object> showAttendanceVerifyJsp(java.util.Date date) {
	public Map<String, Object> showAttendanceVerifyJsp(Map parameterMap ) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();		
//		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasRank> masDesignationList = new ArrayList<MasRank>();
		
		Session session = getSession();
		java.util.Date date = (java.util.Date)parameterMap.get("date");
		int hos = (Integer)parameterMap.get("hospitalId");
		int dept = (Integer)parameterMap.get("dept");
		int shift = (Integer)parameterMap.get("shift");
		int designation = (Integer)parameterMap.get("designation");
		List<MasEmployeeDepartment> masDepartmentList=getEmployeeDepartmentId(hos);
		List<HrAttendanceLoader> hrAttendanceLoaderList = new ArrayList<HrAttendanceLoader>();
	
		Criteria cr = session.createCriteria(HrAttendanceLoader.class).add(Restrictions.eq("Date", date)).
					add(Restrictions.eq("Validate", "n")).add(Restrictions.eq("Status", "Y").ignoreCase()).	add(Restrictions.eq("Hospital.Id", hos));
			
		
		
		if(dept != 0 && designation == 0) {
			cr.createAlias("Employee", "emp").add(Restrictions.eq("emp.EmployeeDepartment.Id",dept ));
					
			}else if(designation != 0 && dept == 0){
				cr.createAlias("Employee", "emp").add(Restrictions.eq("emp.Rank.Id",designation  ));
				
		}else if(designation != 0 && dept != 0 ){
			cr.createAlias("Employee", "emp").add(Restrictions.eq("emp.Rank.Id",designation )).add(Restrictions.eq("emp.EmployeeDepartment.Id",dept ));
					
		}
		hrAttendanceLoaderList = cr.list();
		
		
		
		masShiftCodeList = session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("ShiftName")).list();
//		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("DepartmentName")).list();				
		masDesignationList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("RankName")).list();
		
		map.put("masShiftCodeList", masShiftCodeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masDesignationList", masDesignationList);
		map.put("hrAttendanceLoaderList", hrAttendanceLoaderList);
		return map;
	}

	public Map<String, Object> saveAttendanceVerify(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAttendanceLoader> hrAttendanceVerifyList = new ArrayList<HrAttendanceLoader>();
		
		List<HrMasShiftCodes> masShiftCodeList = new ArrayList<HrMasShiftCodes>();		
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<MasRank> masDesignationList = new ArrayList<MasRank>();
		boolean updated = false;
		// int id = 0;
		if (generalMap.get("hrAttendanceVerifyList") != null) {
			hrAttendanceVerifyList = (ArrayList) generalMap
					.get("hrAttendanceVerifyList");
		}
		//System.out.println(hrAttendanceVerifyList.size());
		Session session = getSession();
		HrAttendanceLoader hrAttendanceLoader = new HrAttendanceLoader();
		for (int i = 0; i < hrAttendanceVerifyList.size(); i++) {
			hrAttendanceLoader = hrAttendanceVerifyList.get(i);
			int id = 0;
			if (hrAttendanceLoader.getId() != null) {
				id = hrAttendanceLoader.getId();
			}
			String timeIn = null;
			if (hrAttendanceLoader.getTimeIn() != null) {
				timeIn = hrAttendanceLoader.getTimeIn();
			}
			String timeOut = null;
			if (hrAttendanceLoader.getTimeOut() != null) {
				timeOut = hrAttendanceLoader.getTimeOut();
			}
			// ----------------------------
			String inDate = "23/01/2009";
			Map parameterMap = new HashMap();
			parameterMap.put("inDate", inDate);
			parameterMap.put("outDate", inDate);
			parameterMap.put("inTime", timeIn);
			parameterMap.put("outTime", timeOut);

			String totalTimeDiff = "";
			Map diffMap = new HashMap();

			diffMap = HMSUtil.calculateHourDiffForAttendance(parameterMap);

			if (diffMap.get("totalTimeDiff") != null) {
				totalTimeDiff = (String) diffMap.get("totalTimeDiff");

			}
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			HrAttendanceLoader hrNewAttendanceLoader = (HrAttendanceLoader) hbt
					.load(HrAttendanceLoader.class, id);
			String validate = "";
			if (timeIn.equals("")) {
				validate = "yes";
			} else {
				validate = "yes";
			}
			hrNewAttendanceLoader.setTimeIn(timeIn);
			hrNewAttendanceLoader.setTimeOut(timeOut);
			hrNewAttendanceLoader.setValidate(validate);
			hrNewAttendanceLoader.setVerified(validate);
			hrNewAttendanceLoader.setTotalHours(totalTimeDiff);
			hbt.update(hrNewAttendanceLoader);
			System.out.println("update"+id);
			updated = true;
			String message = "";
			if (updated) {
				message = "Data update Successfully.";
			} else {
				message = "Some Problem Occured.";
			}
			map.put("message", message);
		}
		

		masShiftCodeList = session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masDepartmentList = session.createCriteria(MasDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();				
		masDesignationList = session.createCriteria(MasRank.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		map.put("masShiftCodeList", masShiftCodeList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masDesignationList", masDesignationList);
		return map;
	}

	public Map<String, Object> showManualEmployeeAttendanceJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;
	}

	public Map<String, Object> saveManualEmployeeAttenadance(
			Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List attendanceIdList = new ArrayList();
		List attendanceDateList = new ArrayList();
		List outDateList = new ArrayList();
		List timeInList = new ArrayList();
		List timeOutList = new ArrayList();
		if (generalMap.get("attendanceIdList") != null) {
			attendanceIdList = (List) generalMap.get("attendanceIdList");
		}
		if (generalMap.get("attendanceDateList") != null) {
			attendanceDateList = (List) generalMap.get("attendanceDateList");
		}
		if (generalMap.get("outDateList") != null) {
			outDateList = (List) generalMap.get("outDateList");
		}
		if (generalMap.get("timeInList") != null) {
			timeInList = (List) generalMap.get("timeInList");
		}
		if (generalMap.get("timeOutList") != null) {
			timeOutList = (List) generalMap.get("timeOutList");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		if (attendanceIdList.size() > 0) {
			for (int i = 0; i < attendanceIdList.size(); i++) {
				HrAttendanceLoader attendanceLoader = new HrAttendanceLoader();

				if (attendanceDateList.size() > 0) {
					if (attendanceDateList.get(i) != null
							&& !attendanceDateList.get(i).equals("")) {
						Date attendanceDate = HMSUtil
								.convertStringTypeDateToDateType(attendanceDateList
										.get(i).toString());
						attendanceLoader.setDate(attendanceDate);

						if (outDateList.size() > 0) {
							if (outDateList.get(i) != null
									&& !outDateList.get(i).equals("")) {
								Date outDate = HMSUtil
										.convertStringTypeDateToDateType(outDateList
												.get(i).toString());
								attendanceLoader.setOutDate(outDate);
							}
							if (timeInList.size() > 0) {
								if (timeInList.get(i) != null
										&& !timeInList.get(i).equals("")) {
									String timeIn = timeInList.get(i)
											.toString();
									attendanceLoader.setTimeIn(timeIn);
								}
							}
							if (timeOutList.size() > 0) {
								if (timeOutList.get(i) != null
										&& !timeOutList.get(i).equals("")) {
									String timeOut = timeOutList.get(i)
											.toString();
									attendanceLoader.setTimeOut(timeOut);
								}
							}
							hbt.save(attendanceLoader);
						}
					}
				}
			}
		}
		Session session = (Session) getSession();
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y")).list();
		map.put("employeeList", employeeList);
		return map;
	}
	public Map<String, Object> showAttendanceLoaderJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLocation> hrMasLocationList = new ArrayList<HrMasLocation>();
		Session session = (Session)getSession();
		hrMasLocationList = session.createCriteria(HrMasLocation.class).add(Restrictions.eq("Status", "y")).list();
		map.put("hrMasLocationList", hrMasLocationList);
		return map;
	}


	public boolean importMsAccessFile() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users> employeeList = new ArrayList<Users>();
		List<Object[]>tempAttendanceList = new ArrayList<Object[]>();
		boolean updated = false;
		Session session = (Session)getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		try {
			Date currentDate = new Date();
			String cDate = HMSUtil.convertDateToStringWithoutTime(currentDate);
			String cuDate = cDate.substring(0, 2);
			String cMonth = cDate.substring(3, 5);
			String cYear = cDate.substring(6, 10);
			String currDate = cYear+""+cMonth+""+cuDate;
			String attDate = "";

	 		String user="sa";
	 		String password="jkt@123";
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//	String dataSourceName = "VBCHLIVE";
			String dbURL = "jdbc:sqlserver://127.0.0.1:1433;database=VBCHLIVE";
			try {
				Connection con = DriverManager.getConnection(dbURL, user,password);
				Statement s = con.createStatement();

				s.execute("select e_date,e_time,e_id,e_name from tenter where e_date = '"+currDate+"'"); // select the data from the table
				ResultSet rs = s.getResultSet();
				String attendanceDate = "";
				String timeIn = "";
				String timeOut = "";
				String userName = "";
				String empName = "";
				String dateAtt = "";

				int employeeId = 0;
				if (rs != null){
					while ( rs.next() )
					{
					userName = rs.getString(3);

			employeeList = session.createCriteria(Users.class).add(Restrictions.eq("UserName", userName)).list();
			if(employeeList.size()>0){
				for(Users users :employeeList){
					TempAttendanceData tempAttendanceData = new TempAttendanceData();
					employeeId = users.getEmployee().getId();
					attendanceDate = rs.getString(1);
					String aYear = attendanceDate.substring(0, 4);
					String aMonth = attendanceDate.substring(4, 6);
					String aDate = attendanceDate.substring(6, 8);
					dateAtt = (aYear).concat("-").concat(aMonth).concat("-").concat(aDate);
					 attDate = (aDate).concat("/").concat(aMonth).concat("/").concat(aYear);
					timeIn = rs.getString(2);
					String hr = timeIn.substring(0, 2);
					String min = timeIn.substring(2, 4);
					String sec = timeIn.substring(4, 6);
					String attTime = (hr.concat(":").concat(min).concat(":").concat(sec));

					tempAttendanceData.setAttendanceTime(attTime);
					tempAttendanceData.setAttendanceDate(HMSUtil.convertStringTypeDateToDateType(attDate));
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					tempAttendanceData.setEmployee(masEmployee);
					hbt.save(tempAttendanceData);
				}
			}
					}
				}
				String timeOutqry = "";

					timeOutqry = "SELECT max(attendance_time),min(attendance_time),employee_id,attendance_date FROM temp_attendance_data  where attendance_date = '"+(dateAtt)+"'  group by employee_id ";

					tempAttendanceList = session.createSQLQuery(timeOutqry).list();
					if(tempAttendanceList != null){
						for(Object[] obj : tempAttendanceList){
						HrAttendanceLoader  hrAttendanceLoader = new HrAttendanceLoader();
						hrAttendanceLoader.setTimeOut((String)obj[0]);
						hrAttendanceLoader.setTimeIn((String)obj[1]);
						MasEmployee masEmp = new MasEmployee();
						masEmp.setId((Integer)obj[2]);
						hrAttendanceLoader.setEmployee(masEmp);
						hrAttendanceLoader.setDate((Date)obj[3]);
						hbt.save(hrAttendanceLoader);
						}
					}
					updated = true;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated ;
	}

	@Override
	public Map<String, Object> saveShiftParameterDetails(Map<String, Object> valueMap) {
		List sesList= new ArrayList();
		List fromTimeList= new ArrayList();
		List toTimeList= new ArrayList();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		boolean successfullyAdded=false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasShift> existingMassShiftList = new ArrayList<MasShift>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		
		sesList=(List)valueMap.get("sesList");
		fromTimeList=(List)valueMap.get("fromTimeList");
		toTimeList=(List)valueMap.get("toTimeList");
		int cateId=(Integer)valueMap.get("cate_id");
		int hospitalId=(Integer)valueMap.get("hospitalId");
		int shiftCodeId=(Integer)valueMap.get("shiftCodeId");
		String changedDate = (String)valueMap.get("changedDate");
		String changedTime = (String)valueMap.get("changedTime" );
		Users user = (Users)valueMap.get("user");
		//System.out.println(valueMap.get("CHANGED_DATE")+">>>"+valueMap.get("changedTime" ));
		if(sesList.size()>0){
			for(int i=0;i<sesList.size();i++){
				HrMasShift hrMasShift = new HrMasShift();
				hrMasShift.setSession(""+sesList.get(i));
				hrMasShift.setShiftStartTime(""+fromTimeList.get(i));
				hrMasShift.setShiftEndTime(""+toTimeList.get(i));
				hrMasShift.setStatus("y");
				
				MasEmpCategory mec = new MasEmpCategory();
				mec.setId(cateId);
				hrMasShift.setEmployeeCategory(mec);
				
				MasHospital mh = new MasHospital();
				mh.setId(hospitalId);
				hrMasShift.setHospital(mh);
				
				HrMasShiftCodes hrmsc = new HrMasShiftCodes();
				hrmsc.setId(shiftCodeId);
				hrMasShift.setShiftCodes(hrmsc);
				hrMasShift.setDepartment(null);
				
				hrMasShift.setLastChgBy(user);
				hrMasShift.setLastChgTime(changedTime);
				hrMasShift.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(""+valueMap.get("CHANGED_DATE")));
			
				existingMassShiftList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasShift as ms where ms.ShiftCodes.Id = "
								+ shiftCodeId + " and ms.ShiftStartTime = '"
								+ fromTimeList.get(i) + "' and ms.ShiftEndTime = '" + toTimeList.get(i)
								+ "'");
				// successfullyAdded=true;
				if (existingMassShiftList.size() > 0) {
					message = "Data Already Exist.";
				} else {
					hbt.save(hrMasShift);
					message = "Data Saved Successfully.";
				}

			}
			
		}
		
		// boolean successfullyAdded=false;
		
		/*int shiftCodeId = 0;
		shiftCodeId = hrMasShift.getShiftCodes().getId();
		String startTime = hrMasShift.getShiftStartTime();
		String endTime = hrMasShift.getShiftEndTime();
		existingMassShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift as ms where ms.ShiftCodes.Id = "
						+ shiftCodeId + " and ms.ShiftStartTime = '"
						+ startTime + "' and ms.ShiftEndTime = '" + endTime
						+ "'");
		// successfullyAdded=true;
		if (existingMassShiftList.size() > 0) {
			message = "Data Already Exist.";
		} else {
			hbt.save(hrMasShift);
			message = "Data Saved Successfully.";
		}
*/
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		/*masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift");*/
		
		
		
		
		masEmpCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
	
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("masShiftList", masShiftList);
		map.put("message", message);
		return map;
	}

	@Override
	public Map<String, Object> searchShiftParameter(Map<String, Object> valueMap) {
		
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		boolean successfullyAdded=false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> srchmasShiftList = new ArrayList<HrMasShift>();
	
		Session session = (Session) getSession();
		String message = "";
		

		int cateId=(Integer)valueMap.get("cate_id");
		int hospitalId=(Integer)valueMap.get("hospitalId");
		int shiftCodeId=(Integer)valueMap.get("shiftCodeId");
		
		
				//
		srchmasShiftList =	session.createCriteria(HrMasShift.class).add(Restrictions.eq("ShiftCodes.Id", shiftCodeId))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("EmployeeCategory.Id", cateId)).list();
		

		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		/*masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift");*/
		
		
		
		
		masEmpCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
	
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		
		
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("srchmasShiftList", srchmasShiftList);
		map.put("message", message);
		return map;
	}

	@Override
	public Map<String, Object> updateShiftParameterDetails(
			Map<String, Object> valueMap) {
		List idList= new ArrayList();
		List sesList= new ArrayList();
		List fromTimeList= new ArrayList();
		List toTimeList= new ArrayList();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		boolean successfullyAdded=false;
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<HrMasShift> masShiftList = new ArrayList<HrMasShift>();
		List<MasShift> existingMassShiftList = new ArrayList<MasShift>();
		Session session = (Session) getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		idList=(List)valueMap.get("idList");
		sesList=(List)valueMap.get("sesList");
		fromTimeList=(List)valueMap.get("fromTimeList");
		toTimeList=(List)valueMap.get("toTimeList");
		int cateId=(Integer)valueMap.get("cate_id");
		int hospitalId=(Integer)valueMap.get("hospitalId");
		int shiftCodeId=(Integer)valueMap.get("shiftCodeId");
		String changedDate = (String)valueMap.get("changedDate");
		String changedTime = (String)valueMap.get("changedTime" );
		Users user = (Users)valueMap.get("user");
	
		if(sesList.size()>0){
			for(int i=0;i<sesList.size();i++){
				HrMasShift hrMasShift = null;
				int id =0;
				if(idList.get(i) != null)
					id = Integer.parseInt(""+idList.get(i));
				//System.out.println("id>>"+id);
				if(id == 0 ){
				 hrMasShift = new HrMasShift();
				}else{
					hrMasShift =(HrMasShift) session.load(HrMasShift.class, id);
					
				}
				hrMasShift.setSession(""+sesList.get(i));
				hrMasShift.setShiftStartTime(""+fromTimeList.get(i));
				hrMasShift.setShiftEndTime(""+toTimeList.get(i));
				hrMasShift.setStatus("y");
				
				MasEmpCategory mec = new MasEmpCategory();
				mec.setId(cateId);
				hrMasShift.setEmployeeCategory(mec);
				
				MasHospital mh = new MasHospital();
				mh.setId(hospitalId);
				hrMasShift.setHospital(mh);
				
				HrMasShiftCodes hrmsc = new HrMasShiftCodes();
				hrmsc.setId(shiftCodeId);
				hrMasShift.setShiftCodes(hrmsc);
				hrMasShift.setDepartment(null);
				
				hrMasShift.setLastChgBy(user);
				hrMasShift.setLastChgTime(changedTime);
				hrMasShift.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(""+valueMap.get("changedDate")));
			
				existingMassShiftList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrMasShift as ms where ms.ShiftCodes.Id = "
								+ shiftCodeId + " and ms.ShiftStartTime = '"
								+ fromTimeList.get(i) + "' and ms.ShiftEndTime = '" + toTimeList.get(i)
								+ "'");
			
				// successfullyAdded=true;
				if (existingMassShiftList.size() > 0) {
					message = "Data Already Exist.";
				} else {
					hbt.saveOrUpdate(hrMasShift);
					message = "Data Update Successfully.";
				}

			}
			
		}
		
		
		masShiftCodesList = session.createCriteria(HrMasShiftCodes.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		/*masShiftList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasShift");*/
		
		
		
		
		masEmpCategoryList=session.createCriteria(MasEmpCategory.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
		
	
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("masDepartmentList", masDepartmentList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("masShiftList", masShiftList);
		map.put("message", message);
		return map;
	}

	@Override
	public Map<String, Object> showDutyScheduleJsp(Map parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
//		List<Object[]> masDepartmentList = new ArrayList<Object[]>();
		List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> masGradeList = new ArrayList<MasGrade>();
		List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
		List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
		Session session = (Session) getSession();
	/*	masDepartmentList =session.createCriteria(MasDepartment.class).addOrder(Order.asc("DepartmentName"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("DepartmentName")))
				.addOrder(Order.asc("DepartmentName")).list();*/
		masEmpCategoryList =session.createCriteria(MasEmpCategory.class).addOrder(Order.asc("EmpCategoryName"))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masGradeList =session.createCriteria(MasGrade.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masShiftCodesList =session.createCriteria(HrMasShiftCodes.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		masEmployeeDepartmentList = session.createCriteria(MasEmployeeDepartment.class).add(Restrictions.eq("Status", "y").ignoreCase()).list();
		
//		map.put("masDepartmentList", masDepartmentList);
		map.put("masEmpCategoryList", masEmpCategoryList);
		map.put("masGradeList", masGradeList);
		map.put("masShiftCodesList", masShiftCodesList);
		map.put("masEmployeeDepartmentList", masEmployeeDepartmentList);
		return map;
	}

	@Override
	public Map<String, Object> searchDutyScheduleEmployee(Map parameterMap) {
		Map<String, Object> map1 = new HashMap<String, Object>();
		Session ses = getSession();
		int empCate = (Integer)parameterMap.get("empCate");
		int hos = (Integer)parameterMap.get("hospitalId");
		int deptId = (Integer)parameterMap.get("deptId");
		String month  = (String)parameterMap.get("month");
		String year  = (String)parameterMap.get("year");
//		List<Object[]> srchEmplList = new ArrayList<Object[]>();
		List<MasEmployee> srchEmplList = new ArrayList<MasEmployee>();
		List<HrDutyScheduleM> hrDutyScheduleMList = new ArrayList<HrDutyScheduleM>();
		List<HrDutyScheduleM> validateHrDutyScheduleMList = new ArrayList<HrDutyScheduleM>();
		List<HrDutyScheduleT> hrDutyScheduleTList = new ArrayList<HrDutyScheduleT>();
		hrDutyScheduleTList = ses.createCriteria(HrDutyScheduleT.class)
					.createAlias("ScheduleM","m").add(Restrictions.eq("m.Month",month )).add(Restrictions.eq("m.Hospital.Id", hos)).add(Restrictions.eq("m.EmployeeCate.Id",empCate ))
						.add(Restrictions.eq("m.Year", Integer.parseInt(year)))/*.add(Restrictions.isNull("m.ValidateBy"))*/.addOrder(Order.asc("Id")).list();
		Criteria c = ses.createCriteria(MasEmployee.class).add(Restrictions.eq("EmpCategory.Id",empCate )).createAlias("EmployeeDepartment", "ed")
				.createAlias("Rank", "rank").add(Restrictions.eq("Hospital.Id", hos));
				//.setProjection(Projections.projectionList().add(Projections.property("Id")).add(Projections.property("EmployeeName"))
				//.add(Projections.property("rank.RankName")).add(Projections.property("EmpScMappings"))).addOrder(Order.asc("EmployeeName"));
		if(deptId!=0)
			c = c.add(Restrictions.eq("ed.Id", deptId));
		srchEmplList = c.list();
		
		hrDutyScheduleMList = ses.createCriteria(HrDutyScheduleM.class).add(Restrictions.eq("Month",month )).add(Restrictions.eq("Hospital.Id", hos)).
				add(Restrictions.eq("EmployeeCate.Id",empCate ))
				.add(Restrictions.eq("Year", Integer.parseInt(year)))/*.add(Restrictions.isNull("ValidateBy"))*/.addOrder(Order.asc("Id")).list();
		
		validateHrDutyScheduleMList = ses.createCriteria(HrDutyScheduleM.class).add(Restrictions.eq("Month",month )).add(Restrictions.eq("Hospital.Id", hos))
				.add(Restrictions.eq("EmployeeCate.Id",empCate )).add(Restrictions.eq("Year", Integer.parseInt(year))).add(Restrictions.isNotNull("ValidateBy")).addOrder(Order.asc("Id")).list();
			
		map1.put("validateHrDutyScheduleMList", validateHrDutyScheduleMList);
		map1.put("hrDutyScheduleTList", hrDutyScheduleTList);
		map1.put("hrDutyScheduleMList", hrDutyScheduleMList);
		map1.put("srchEmplList", srchEmplList);
		map1.put("empCate", empCate);
		map1.put("month", month);
		map1.put("year", year);
		
		return map1;
	}

	@Override
	public Map<String, Object> getSessForShift(Map parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session ses = getSession();
		int empCate = (Integer)parameterMap.get("empCate");
		int hos = (Integer)parameterMap.get("hospitalId");
		int shift = (Integer)parameterMap.get("shift");
		String row  = (String)parameterMap.get("row");
		List<HrMasShift> hrMasShift = new ArrayList<HrMasShift>();
		List<MasDepartment> masDepart = new ArrayList<MasDepartment>();
		masDepart = ses.createCriteria(MasDepartment.class).add(Restrictions.eq("Status","y" ).ignoreCase()).list();
		hrMasShift = ses.createCriteria(HrMasShift.class).add(Restrictions.eq("EmployeeCategory.Id",empCate )).add(Restrictions.eq("Hospital.Id", hos))
						.add(Restrictions.eq("ShiftCodes.Id", shift)).list();
		map.put("masDepart", masDepart);
		map.put("hrMasShift", hrMasShift);
		map.put("empCate", empCate);
		map.put("row", row);
		return map;
	}

	@Override
	public Map<String, Object> saveDutySchedule(Map parameterMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List  empIdList= new ArrayList();
		List shiftIdList = new ArrayList();
		List ScheduleList = new ArrayList();
		List ScheduleMList = new ArrayList();
		List ScheduleTList = new ArrayList();
		List departmentList = new ArrayList();
		Session ses = getSession();
		Date D = new Date();
		String msg="";
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int empCate = Integer.parseInt(""+parameterMap.get("empCate"));
		empIdList = (List)parameterMap.get("empIdList");
		ScheduleMList = (List)parameterMap.get("ScheduleMList");
		ScheduleTList = (List)parameterMap.get("ScheduleTList");
		int hos = (Integer)parameterMap.get("hospitalId");		
		String changedDate = (String)parameterMap.get("chDate");
		String changedTime = (String)parameterMap.get("changedTime");
		String month = (String)parameterMap.get("month");
		String year = (String)parameterMap.get("year");
		Users user = (Users)parameterMap.get("lastchangeBy");
		shiftIdList = (List)parameterMap.get("shiftIdList");
		ScheduleList = (List)parameterMap.get("ScheduleList");
		departmentList = (List)parameterMap.get("departmentList");
		
		Box box = (Box)parameterMap.get("box");
		
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			if(empIdList.size()>0){
				int k=1;
				for(int i=0;i<empIdList.size();i++){
					String changeFlag = box.getString("changeFlag"+(k));
					
					HrDutyScheduleM hrDutyScheduleM  = new HrDutyScheduleM();
					if(changeFlag.equalsIgnoreCase("y")){
					if(ScheduleMList.get(i).toString().equals("0")){
						
						MasEmployee me =  new MasEmployee();
						me.setId((Integer)empIdList.get(i));
						hrDutyScheduleM.setEmployee(me);

						MasHospital mh =  new MasHospital();
						mh.setId(hos);
						hrDutyScheduleM.setHospital(mh);

						hrDutyScheduleM.setYear(Integer.parseInt("" +year.trim()));
						MasEmpCategory mec = new MasEmpCategory();
						mec.setId(empCate);
						hrDutyScheduleM.setEmployeeCate(mec);

						hrDutyScheduleM.setStatus("y");
						hrDutyScheduleM.setLastChgTime(changedTime);
						hrDutyScheduleM.setLastChgBy(user);
						hrDutyScheduleM.setMonth(month);
						hrDutyScheduleM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
						hbt.saveOrUpdate(hrDutyScheduleM);
					}else{
						hrDutyScheduleM.setId(Integer.parseInt(ScheduleMList.get(i).toString()));
					}

					Vector<String> shift = box.getVector("shift"+k);
					Vector<String> scheduleTId = box.getVector("scheduleT"+k);
					Vector<String> departmentId = box.getVector("departmentId"+k);
					int day=0;
					for (int j = 0; j < shift.size(); j++) {
						day++;
						HrDutyScheduleT hrDutyScheduleT  = new HrDutyScheduleT();
						if(!shift.get(j).toString().equals("0")){

							if(!scheduleTId.get(j).toString().equals("0")){
								hrDutyScheduleT = (HrDutyScheduleT)hbt.load(HrDutyScheduleT.class, Integer.parseInt(""+scheduleTId.get(j)));
							}

							hrDutyScheduleT.setScheduleM(hrDutyScheduleM);

							if(!departmentId.get(j).toString().equals("0")){
								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(Integer.parseInt(""+departmentId.get(j)));
								hrDutyScheduleT.setScheduleDepartment(masDepartment);
							}

							HrMasShiftCodes hms = new HrMasShiftCodes();
							hms.setId(Integer.parseInt(""+shift.get(j)));
							hrDutyScheduleT.setShiftCode(hms);



							hrDutyScheduleT.setDay(""+(day));
							hbt.saveOrUpdate(hrDutyScheduleT);
						
					}
				}
			}
					k++;
				}
			}
			tx.commit();
			msg = "Data Saved Successfully.";
		} catch (Exception e) {
			msg = "Try Again.";
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}
		
		map.put("message",msg);
		return map;
	}

	@Override
	public Map<String, Object> searchEmployeeForAttenadance(Map parameterMap) {
		
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		Session ses = getSession();
		
		int hos = (Integer)parameterMap.get("hospitalId");
		int dept = (Integer)parameterMap.get("dept");
		int shift = (Integer)parameterMap.get("shift");
		int designation = (Integer)parameterMap.get("designation");
		ArrayList empLeaveList = new ArrayList(); 
		Date dt = new Date();
		String dt1= HMSUtil.convertDateTypeToStringWithoutTime(dt);
		//System.out.println(dt1+" dt1  "+dept);
		List<MasEmployee> srchEmplList = new ArrayList<MasEmployee>();
		Criteria cr = ses.createCriteria(MasEmployee.class).add(Restrictions.eq("Hospital.Id", hos));
		if(dept != 0 && designation == 0) {
			cr.add(Restrictions.eq("EmployeeDepartment.Id",dept ));
					
			}else if(designation != 0 && dept == 0){
				cr.add(Restrictions.eq("Rank.Id",designation  ));
				
		}else if(designation != 0 && dept != 0 ){
			cr.add(Restrictions.eq("Rank.Id",designation )).add(Restrictions.eq("EmployeeDepartment.Id",dept ));
					
		}
		srchEmplList = cr.addOrder(Order.asc("EmployeeName")).add(Restrictions.isNotNull("Rank")).list();
//		System.out.println(dept+"======"+designation+"Emp======"+srchEmplList.size()+"Emp======"+hos);
		for(MasEmployee me : srchEmplList){
			String postgresDate = dt1.split("-")[2]+"-"+dt1.split("-")[1]+"-"+dt1.split("-")[0];
			String sql ="select * from hr_leave_details where empid="+me.getId()+" and status = 2 and from_date <='"+postgresDate+"' and to_date>='"+postgresDate+"'";
			List leaveList = (List)ses.createSQLQuery(sql).list();
		
//			System.out.println(" leaveList  "+leaveList.size());
			if(leaveList.size() >0){
				empLeaveList.add(me.getId());
				
			}
			
		}
		map1.put("srchEmplList", srchEmplList);
//		System.out.println("srchEmplList----->>"+srchEmplList.size());
		map1.put("dept", dept);
		map1.put("shift", shift);
		map1.put("designation", designation);
		map1.put("empLeaveList", empLeaveList);
		return map1;
	}

	@Override
	public void saveEmployeeAbsent(HrAbsentRegister hrAbsentRegister) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrAbsentRegister> existingEmployeeAbsentList = new ArrayList<HrAbsentRegister>();
		List<HrAbsentRegister> absentList = new ArrayList<HrAbsentRegister>();
		List<Integer> maxEmployeeAbsentList = new ArrayList<Integer>();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		int employeeId = hrAbsentRegister.getEmployee().getId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String attendanceDate = sdf.format(hrAbsentRegister.getAbsentDate());
		existingEmployeeAbsentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.HrAbsentRegister as al where al.Employee.Id = "
						+ employeeId
						+ " and al.AbsentDate = '"
						+ attendanceDate
						+ "' ");
		String message = "";
		if (existingEmployeeAbsentList.size() > 0) {
			//message = "Some Record already exist";
		} else {
			hbt.save(hrAbsentRegister);
			//message = "Record save successfully";
		}
		/*maxEmployeeAbsentList = getHibernateTemplate()
				.find("select max(Id) from jkt.hms.masters.business.HrAbsentRegister");
		int maxEmployeeAttendanceId = 0;
		if (maxEmployeeAbsentList.size() > 0) {
			if ((Integer) maxEmployeeAbsentList.get(0) != null) {
				maxEmployeeAttendanceId = (Integer) maxEmployeeAbsentList.get(0);
						
				absentList = getHibernateTemplate().find(
						"from jkt.hms.masters.business.HrAbsentRegister as al where al.id = '"
								+ maxEmployeeAttendanceId + "'");
			}

		}
		*/
	}

	@Override
	public Map<String, Object> updateEmployeeAttenadanceNew(	Map<String, Object> parameterMap) {
		
			Map map = new HashMap();
			Session ses = getSession();
		
		Vector attendanceIdList = (Vector) parameterMap.get("attendanceIdList");
		Vector empidList =  (Vector) parameterMap.get("empidList");
		Vector attendnaceStatusList = (Vector) parameterMap.get("attendnaceStatusList");
		Vector remarkList = (Vector)  parameterMap.get("remarkList");
		Vector absentIdList = (Vector)  parameterMap.get("absentIdList");
		Vector empid2List =(Vector)  parameterMap.get("empid2List");
		Vector attendnaceStatus2List = (Vector) parameterMap.get("attendnaceStatus2List");
		Vector remark2List = (Vector)  parameterMap.get("remark2List");
		int hospitalId = Integer.parseInt(""+parameterMap.get("hospitalId"));
		String changedTime = ""+parameterMap.get("changedTime");
		String changedDate=""+parameterMap.get("changedDate");
		Users lastChgBy =(Users) parameterMap.get("lastChgBy");
		java.util.Date attendanceDate = new java.util.Date();
		Transaction tx = ses.beginTransaction();
		Transaction tx1 = ses.beginTransaction();
		String msg="";
		
		try{
			
		for(int c=0 ; c<attendanceIdList.size();c++){
			if((""+attendnaceStatusList.get(c)).equalsIgnoreCase("P")){
						
			HrAttendanceLoader hrAttendanceLoader = (HrAttendanceLoader) ses.load(HrAttendanceLoader.class, Integer.parseInt(""+attendanceIdList.get(c)));

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(""+empidList.get(c)));
			hrAttendanceLoader.setEmployee(masEmployee);
			
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrAttendanceLoader.setShiftCodes(hrMasShiftCodes);*/
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrAttendanceLoader.setHospital(masHospital);
			
			/*hrAttendanceLoader.setDate(attendanceDate);*/
			/*hrAttendanceLoader.setTimeIn(timeIn);
			hrAttendanceLoader.setTimeOut(timeOut);*/
			/*hrAttendanceLoader.setVerified("n");
			hrAttendanceLoader.setValidate("n");*/
			hrAttendanceLoader.setLastChgBy(lastChgBy);
			hrAttendanceLoader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			hrAttendanceLoader.setLastChgTime(changedTime);
			hrAttendanceLoader.setStatus("y");
			
			hrAttendanceLoader.setRemark(""+remarkList.get(c));
			
			/*hrAttendanceLoader.setAuthorized("no");
			hrAttendanceLoader.setProcessed("no");*/
			
			hrAttendanceLoader.setAttendanceMark(""+attendnaceStatusList.get(c));
			ses.saveOrUpdate(hrAttendanceLoader);
			ses.flush();
			ses.refresh(hrAttendanceLoader);
			 if (!tx.wasCommitted()) {    
                 tx.commit();
        }
			msg="Successfully Updated";
			
			
		}else if((""+attendnaceStatusList.get(c)).equalsIgnoreCase("A")){
			
			
			HrAttendanceLoader hrAttendanceLoader = (HrAttendanceLoader) ses.load(HrAttendanceLoader.class, Integer.parseInt(""+attendanceIdList.get(c)));
			hrAttendanceLoader.setStatus("n");
			ses.saveOrUpdate(hrAttendanceLoader);
			ses.flush();
			ses.refresh(hrAttendanceLoader);
			
			HrAbsentRegister hrAbsentRegister = new HrAbsentRegister();
			
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(""+empidList.get(c)));
			hrAbsentRegister.setEmployee(masEmployee);
			
			hrAbsentRegister.setAbsentDate(attendanceDate);
			
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId();*/
			
			hrAbsentRegister.setShiftCodes(hrAttendanceLoader.getShiftCodes());
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrAbsentRegister.setHospital(masHospital);
			
			hrAbsentRegister.setLastChgBy(lastChgBy);
			hrAbsentRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			hrAbsentRegister.setLastChgTime(changedTime);
			hrAbsentRegister.setStatus("y");
			ses.saveOrUpdate(hrAbsentRegister);
			ses.flush();
			ses.refresh(hrAbsentRegister);
			 if (!tx.wasCommitted()) {    
                 tx.commit();
			 }
			msg="Successfully Updated";
			
			}
		}	
			
	}catch(Exception e){
		e.printStackTrace();
		tx.rollback();
		msg="Error Occured Try Again.";
		
	}
		
		

		try{
			
		for(int c=0 ; c<absentIdList.size();c++){
			if((""+attendnaceStatus2List.get(c)).equalsIgnoreCase("A")){
						
				HrAbsentRegister AbsentRegister = (HrAbsentRegister) ses.load(HrAbsentRegister.class, Integer.parseInt(""+absentIdList.get(c)));

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(""+empid2List.get(c)));
			AbsentRegister.setEmployee(masEmployee);
			
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrAttendanceLoader.setShiftCodes(hrMasShiftCodes);*/
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			AbsentRegister.setHospital(masHospital);
			
			/*hrAttendanceLoader.setDate(attendanceDate);*/
			/*hrAttendanceLoader.setTimeIn(timeIn);
			hrAttendanceLoader.setTimeOut(timeOut);*/
			/*hrAttendanceLoader.setVerified("n");
			hrAttendanceLoader.setValidate("n");*/
			AbsentRegister.setLastChgBy(lastChgBy);
			AbsentRegister.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			AbsentRegister.setLastChgTime(changedTime);
			AbsentRegister.setStatus("y");
			
			
			
			/*hrAttendanceLoader.setAuthorized("no");
			hrAttendanceLoader.setProcessed("no");*/
			
			
			ses.saveOrUpdate(AbsentRegister);
			ses.flush();
			ses.refresh(AbsentRegister);
			if (!tx1.wasCommitted()) {    
                tx1.commit();
			 }
			msg="Successfully Updated";
			
			
		}else if((""+attendnaceStatus2List.get(c)).equalsIgnoreCase("P")){
			
			
			HrAbsentRegister hrAbsentRegister = (HrAbsentRegister) ses.load(HrAbsentRegister.class, Integer.parseInt(""+absentIdList.get(c)));
			hrAbsentRegister.setStatus("n");
			ses.saveOrUpdate(hrAbsentRegister);
			ses.flush();
			ses.refresh(hrAbsentRegister);
			
			
			HrAttendanceLoader hrAttendanceLoader = new HrAttendanceLoader();

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(Integer.parseInt(""+empid2List.get(c)));
			hrAttendanceLoader.setEmployee(masEmployee);
			
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);*/
			hrAttendanceLoader.setShiftCodes(hrAbsentRegister.getShiftCodes());
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrAttendanceLoader.setHospital(masHospital);
			
			hrAttendanceLoader.setDate(attendanceDate);
			hrAttendanceLoader.setVerified("n");
			hrAttendanceLoader.setValidate("n");
			hrAttendanceLoader.setLastChgBy(lastChgBy);
			hrAttendanceLoader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			hrAttendanceLoader.setLastChgTime(changedTime);
			hrAttendanceLoader.setFlag("m");
			hrAttendanceLoader.setStatus("y");
			
			hrAttendanceLoader.setRemark(""+remark2List.get(c));
			
			hrAttendanceLoader.setAuthorized("no");
			hrAttendanceLoader.setProcessed("no");
			
			//hrAttendanceLoader.setAttendanceMark(attendanceMark);
			hrAttendanceLoader.setAttendanceMark(""+attendnaceStatus2List.get(c));
		
			ses.saveOrUpdate(hrAttendanceLoader);
			ses.flush();
			ses.refresh(hrAttendanceLoader);
			if (!tx1.wasCommitted()) {    
                tx1.commit();
			 }
			msg="Successfully Updated";
			
			}
		}	
			
	}catch(Exception e){
		e.printStackTrace();
		tx1.rollback();
		msg="Error Occured Try Again.";
		
	}
		
		map.put("message", msg);
		
		return map;
	}

	@Override
	public Map<String, Object> validateDutySchedule(Map parameterMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		List  empIdList= new ArrayList();
		List shiftIdList = new ArrayList();
		List ScheduleList = new ArrayList();
		List ScheduleMList = new ArrayList();
		List ScheduleTList = new ArrayList();
		Session ses = getSession();
		Session ses1 = getSession();
		Date D = new Date();
		String msg="";
		
		empIdList = (List)parameterMap.get("empIdList");
		ScheduleMList = (List)parameterMap.get("ScheduleMList");
		ScheduleTList = (List)parameterMap.get("ScheduleTList");
		int hos = (Integer)parameterMap.get("hospitalId");		
		String changedDate = (String)parameterMap.get("chDate");
		String changedTime = (String)parameterMap.get("changedTime");
		String month = (String)parameterMap.get("month");
		int year = Integer.parseInt(""+parameterMap.get("year"));
		Users user = (Users)parameterMap.get("lastchangeBy");
		shiftIdList = (List)parameterMap.get("shiftIdList");
		ScheduleList = (List)parameterMap.get("ScheduleList");
		
	Box box = (Box)parameterMap.get("box");
	org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
	hbt.setFlushModeName("FLUSH_AUTO");
	hbt.setCheckWriteOperations(false);
		
	if(empIdList.size()>0){
		int k=1;
		for(int i=0;i<empIdList.size();i++){
			HrDutyScheduleM hrDutyScheduleM  = new HrDutyScheduleM();
			hrDutyScheduleM.setId(Integer.parseInt(ScheduleMList.get(i).toString()));

			Vector<String> shift = box.getVector("shift"+k);
			Vector<String> scheduleTId = box.getVector("scheduleT"+k);
			Vector<String> departmentId = box.getVector("departmentId"+k);
			int day=0;
			for (int j = 0; j < shift.size(); j++) {
				day++;
				HrDutyScheduleT hrDutyScheduleT  = new HrDutyScheduleT();
				if(!shift.get(j).toString().equals("0")){

					if(!scheduleTId.get(j).toString().equals("0")){
						hrDutyScheduleT = (HrDutyScheduleT)hbt.load(HrDutyScheduleT.class, Integer.parseInt(""+scheduleTId.get(j)));


						hrDutyScheduleT.setScheduleM(hrDutyScheduleM);

						if(!departmentId.get(j).toString().equals("0")){
							MasDepartment masDepartment = new MasDepartment();
							masDepartment.setId(Integer.parseInt(""+departmentId.get(j)));
							hrDutyScheduleT.setScheduleDepartment(masDepartment);
						}

						HrMasShiftCodes hms = new HrMasShiftCodes();
						hms.setId(Integer.parseInt(""+shift.get(j)));
						hrDutyScheduleT.setShiftCode(hms);



						hrDutyScheduleT.setDay(""+(day));
						hbt.saveOrUpdate(hrDutyScheduleT);
					}
				}
			}
			k++;
		}
	}
		
		
		
	//	Transaction Tx = ses.beginTransaction();
		/*try {
			if(empIdList.size()>0 && ScheduleMList.size()>0){
				for(int i=0;i<ScheduleMList.size();i++){
					
					HrDutyScheduleM hrDutyScheduleM = (HrDutyScheduleM) ses.load(HrDutyScheduleM.class, Integer.parseInt(""+ScheduleMList.get(i)));
					
					MasEmployee me =  new MasEmployee();
					me.setId((Integer)empIdList.get(i));
					hrDutyScheduleM.setEmployee(me);
					
					MasHospital mh =  new MasHospital();
					mh.setId(hos);
					hrDutyScheduleM.setHospital(mh);
					
					hrDutyScheduleM.setYear(year);
					
					hrDutyScheduleM.setStatus("y");
					hrDutyScheduleM.setLastChgTime(changedTime);
					hrDutyScheduleM.setLastChgBy(user);
					hrDutyScheduleM.setMonth(month);
					hrDutyScheduleM.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
					
					hrDutyScheduleM.setValidateBy(user);
					
					hrDutyScheduleM.setValidateDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
					
					
					ses.saveOrUpdate(hrDutyScheduleM);
					ses.refresh(hrDutyScheduleM);
					String dept[] = (String [])ScheduleList.get(0);
					//System.out.println(">>>"+dept.length);
					int j =30*i+i;
					int days =0;
					for(int j=30*i;j<30*(i+1);j++){
						days++;
					//HrDutyScheduleT hrDutyScheduleT  = new HrDutyScheduleT();
					HrDutyScheduleT hrDutyScheduleT = (HrDutyScheduleT) ses.load(HrDutyScheduleT.class, Integer.parseInt(""+ScheduleTList.get(j)));
					hrDutyScheduleT.setScheduleM(hrDutyScheduleM);
					
					MasDepartment md = new MasDepartment();
					md.setId(Integer.parseInt(""+dept[j]));
					hrDutyScheduleT.setScheduleDepartment(md);
					
					HrMasShift hms = new HrMasShift();
					hms.setId(Integer.parseInt(""+shiftIdList.get(0)));
					hrDutyScheduleT.setShift(hms);
					
					HrMasShiftCodes hms = new HrMasShiftCodes();
					hms.setId(Integer.parseInt(""+shiftIdList.get(j)));
					hrDutyScheduleT.setShiftCode(hms);
					
					
					hrDutyScheduleT.setDay(""+days);
					ses1.saveOrUpdate(hrDutyScheduleT);
					}
					if(Tx.wasCommitted())
					Tx.commit();
				}
				msg="Successfuly Validate.";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="some Problem occuered !";
			//Tx.rollback();
		} 
			*/
		
		map.put("message",msg);
		return map;
	
	}

	@Override
	public Map<String, Object> getShiftForSchedule(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]>  shiftList = new ArrayList<Object[]>();
		int hospitalId = box.getInt("hospitalId");
		int serviceCentreId = box.getInt("serviceCentreId");
		int categoryId = box.getInt("categoryId");
		Session session =getSession();
		shiftList = session.createCriteria(HrMasShift.class).createAlias("ShiftCodes", "sc").add(Restrictions.eq("Department.Id", serviceCentreId))
				.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("EmployeeCategory.Id", categoryId))
				.setProjection(Projections.projectionList().add(Projections.property("sc.Id")).add(Projections.property("sc.ShiftName"))).list();
		map.put("shiftList", shiftList);
		return map;
	}

	@Override
	public Map<String, Object> getEmpServiceCentre(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> empdepartmentList = new ArrayList<String>();
		List<Object[]> departmentList = new ArrayList<Object[]>();
		Session session =getSession();
		departmentList = session.createCriteria(EmpScMapping.class).createAlias("Department", "dept").add(Restrictions.eq("Employee.Id",box.getInt("empId"))).setProjection(Projections.projectionList().add(Projections.property("dept.Id")).add(Projections.property("dept.DeparmentName"))).list();
		
		
		map.put("departmentList", departmentList);
		return map;
	}

}
