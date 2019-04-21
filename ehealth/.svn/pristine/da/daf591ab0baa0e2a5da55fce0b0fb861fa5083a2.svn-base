package jkt.hrms.leave.dataservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.Holidaycalendar;
import jkt.hrms.masters.business.HrEmployeeBalance;
import jkt.hrms.masters.business.HrEmployeeBalanceHistory;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeeBalanceNewHistory;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrEncashmentDetails;
import jkt.hrms.masters.business.HrEncashmentDetailsHistory;
import jkt.hrms.masters.business.HrLeaveDetails;
import jkt.hrms.masters.business.HrLeaveDetailsHistory;
import jkt.hrms.masters.business.HrMasLeave;
import jkt.hrms.masters.business.HrMasLeaveStatus;
import jkt.hrms.masters.business.HrMasLeaveType;
import jkt.hrms.masters.business.HrMasLeaveTypeBackup;
import jkt.hrms.masters.business.HrMasLeaveTypeHistory;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLeaveTypeMediatorHistory;
import jkt.hrms.masters.business.HrMasLeaveTypeNew;
import jkt.hrms.masters.business.HrUpdateLeaveBalanceHistory;
import jkt.hrms.masters.business.UserManager;
import jkt.hrms.util.LeaveManagementUtil;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.servlet.ModelAndView;

public class LeaveDetailsDataServiceImpl extends HibernateDaoSupport implements
		LeaveDetailsDataService {
	Session session = null;

	public List getLeaveTypeList() {
		List<HrMasLeave> leaveType = new ArrayList<HrMasLeave>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrMasLeave.class);

		crit = crit.add(Restrictions.eq("Status", "y"));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		leaveType = crit.list();

		// leaveType=hbt.find("from jkt.hrms.masters.business.HrMasLeave as
		// leave");

		return leaveType;
	}

	@SuppressWarnings("unchecked")
	public Map leaveRecord(int leaveId) {
		HrLeaveDetails leaveDetails = (HrLeaveDetails) getHibernateTemplate()
				.load(HrLeaveDetails.class, leaveId);
		List userList = (List) getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee us where us.Id = "
						+ leaveDetails.getLeaveApprovedBy().getId());
		Map detailsMap = new HashMap();
		detailsMap.put("leaveDetails", leaveDetails);
		detailsMap.put("userList", userList);
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public List getManager(int userId) {
		// List<MasEmployee>
		// manager=(List<MasEmployee>)getHibernateTemplate().find("from
		// com.jkt.intranet.business.UserManager as mgr where
		// mgr.EmpId="+userId);
		// changes
		List<UserManager> manager = (List<UserManager>) getHibernateTemplate()
				.find("from jkt.hrms.masters.business.UserManager as mgr where mgr.EmpId="
						+ userId);
		return manager;
	}

	@SuppressWarnings("unchecked")
	public List getRestrictedHolidays() {
		// Date today = new Date();

		List<Holidaycalendar> rholidays = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.Holidaycalendar as h where h.Rh='yes' and h.HolidayDate >'"
						+ HMSUtil.getDateFormat(new Date(), "yyyy-MM-dd") + "'");
		return rholidays;
	}

	@SuppressWarnings("unchecked")
	public List getHolidays() {
		List<Holidaycalendar> holidays = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.Holidaycalendar as h where h.Rh='no'");
		return holidays;
	}

	@SuppressWarnings("unchecked")
	public List getManagers() {
		List listOfManagers = null;
		listOfManagers = (List<MasEmployee>) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as user where user.Id IN( select distinct mgr.ManagerId from jkt.hrms.masters.business.UserManager as mgr) order by user.FirstName");
		return listOfManagers;
	}

	public void submitLeaveForm(HrLeaveDetails leave, int userId,
			String applierId) {
		String fromToDate = "";
		String halfDayLeave = "";
		getHibernateTemplate().save(leave);
		saveLeaveHistory(leave);
		MasEmployee manager = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, leave.getLeaveApprovedBy().getId());
		HrLeaveDetails leaveDetails = new HrLeaveDetails();
		leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
				HrLeaveDetails.class, leave.getId());
		if (leave.getFromDate() != null && leave.getToDate() != null) {
			fromToDate = "\nLeave period : "
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leave
							.getFromDate())
					+ " to "
					+ LeaveManagementUtil.convertDateToStringWithoutTime(leave
							.getToDate());
		} else {
			fromToDate = "\nNo. of days : " + leave.getNoOfWorkingDays();
		}
		if (leave.getHalfDay() != null || "".equals(leave.getHalfDay())) {
			halfDayLeave = "\nHalf Day Leave : " + leave.getHalfDay();
		}
		String emailMessage = "There is a leave with leave ID " + leave.getId()
				+ " applied by "
				+ leaveDetails.getEmpId().getFirstName()
				+ " with employee code "
				+ leaveDetails.getEmpId().getEmployeeCode()
				+ " and base location "
				+ leaveDetails.getEmpId()/* .getLocation().getLocationDesc() */
				+ " waiting for the approval.\n"
				+
				// "\nLeave ID is : "+leave.getId()+
				"\nLeave Status is : Waiting"
				+ "\nLeave Type is : "
				+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
						.getDescription() + halfDayLeave + fromToDate;
		String hrEmailId = getHRLeaveEmail();
		@SuppressWarnings("unused")
		String recipientAddresses = manager.getEmail().concat(",")
				.concat(hrEmailId);
		// mail
		//LeaveManagementUtil.intranetEmailFunction(recipientAddresses,	applierId, emailMessage, "Leave Application");
	}

	@SuppressWarnings("unchecked")
	public List waitingLeavesList(MasEmployee user,int hospitalId) {
		List<Object> waitingLeaves = new ArrayList<Object>();
		List<Object> recomendWaitingLeaves = new ArrayList<Object>();
		
		System.out.println(" user.getId()"+ user.getId());
		int userRanrkId=0;
		int parentHospitalId=0;
		
		
		if(null !=user.getRank()){
		userRanrkId=user.getRank().getId();
		}
		
		waitingLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id in (3,6) and leave.leaveApprovedBy.Id = "
						+ user.getId() + " order by leave.Id");
		
		recomendWaitingLeaves=getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id in (1) and leave.RecommendStatus ='y'  order by leave.Id");
		
		Iterator iterator = recomendWaitingLeaves.iterator();
		for (int i = 1; iterator.hasNext(); i++) {
			HrLeaveDetails waitingLeavess = (HrLeaveDetails) iterator.next();
			
			if(null !=waitingLeavess && null !=waitingLeavess.getLeaveApprovedBy().getHospital() && null !=waitingLeavess.getLeaveApprovedBy().getHospital().getParentInstitute()){
				parentHospitalId=waitingLeavess.getLeaveApprovedBy().getHospital().getParentInstitute().getId();
				}
		}
		System.out.println("hospitalId=="+hospitalId);
		System.out.println("parentHospitalId=="+parentHospitalId);
		System.out.println("recomendWaitingLeaves=="+recomendWaitingLeaves.size());
		
		if(hospitalId==parentHospitalId){
		
		waitingLeaves.addAll(recomendWaitingLeaves);
		}
		/*if(null !=recomendWaitingLeaves && recomendWaitingLeaves.size()>0){
			waitingLeaves.addAll(recomendWaitingLeaves);
			
		}*/
		
		return waitingLeaves;
	}

	@SuppressWarnings("unchecked")
	public List approvedLeavesList(MasEmployee user) {
		List<Object> approvedLeaves = new ArrayList<Object>();
		approvedLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=2 and leave.leaveApprovedBy.Id = "
						+ user.getId() + " order by leave.FromDate desc");
		return approvedLeaves;
	}

	@SuppressWarnings("unchecked")
	public List getApprovedLeavesEncashment(MasEmployee user) {
		List<Object> approvedLeaves = new ArrayList<Object>();
		approvedLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=2 and leave.ApprovedBy.Id = "
						+ user.getId() + " order by leave.ApprovedOn desc");
		return approvedLeaves;
	}

	/*
	 * public List getTodayApprovedLeavesEncashment(MasEmployee user) {
	 * List<HrEncashmentDetails> approvedLeaves=new
	 * ArrayList<HrEncashmentDetails>();
	 *
	 * Session session = (Session)getSession(); Criteria crit =
	 * session.createCriteria(HrEncashmentDetails.class);
	 *
	 * Date currentDate = new Date();
	 *
	 * crit = crit.add(Restrictions.eq("ApprovedBy.Id", user.getId() )); crit =
	 * crit.add(Restrictions.eq("LeaveStatus.Id", 2 )); crit =
	 * crit.add(Restrictions.ge("FromDate",currentDate )); crit =
	 * crit.add(Restrictions.le("ToDate",currentDate ));
	 *
	 * Order order=Order.asc("Id"); crit =
	 * crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id", userId));
	 *
	 * approvedLeaves = crit.list();
	 *
	 * approvedLeaves=getHibernateTemplate().find("from
	 * jkt.hrms.masters.business.HrEncashmentDetails as leave where
	 * leave.LeaveStatus.Id=2 and leave.ApprovedBy.Id = "+user.getId());
	 *
	 * return approvedLeaves; }
	 */

	@SuppressWarnings("unchecked")
	public List getTodayApprovedLeavesList(MasEmployee user) {
		List<HrLeaveDetails> approvedLeaves = new ArrayList<HrLeaveDetails>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrLeaveDetails.class);

		Date currentDate = new Date();

		crit = crit.add(Restrictions.eq("leaveApprovedBy.Id", user.getId()));
		crit = crit.add(Restrictions.eq("leaveStatus.Id", 2));
		crit = crit.add(Restrictions.le("FromDate", currentDate));
		crit = crit.add(Restrictions.ge("ToDate", currentDate));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		approvedLeaves = crit.list();


		return approvedLeaves;

	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public List disapprovedLeavesList(MasEmployee user) {
		List<Object> disapprovedLeaves = new ArrayList<Object>();
		disapprovedLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=4 and leave.EmpId.Id = "
						+ user.getId() + " order by leave.FromDate");
		return disapprovedLeaves;
	}

	@SuppressWarnings("unchecked")
	public List getDisapprovedLeavesEncashment(MasEmployee user) {
		List<Object> disapprovedLeaves = new ArrayList<Object>();
		disapprovedLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=4 and leave.ApprovedBy.Id = "
						+ user.getId());
		return disapprovedLeaves;
	}

	@SuppressWarnings("unchecked")
	public List getLeaveList(int empId) {
		List<HrLeaveDetails> leaveList = new ArrayList<HrLeaveDetails>();
		// leaveList=getHibernateTemplate().find("from
		// jkt.hrms.masters.business.HrLeaveDetails as l where
		// l.EmpId.Id="+empId+" and l.leaveStatus.Id<>1 order by l.FromDate");
		leaveList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrLeaveDetails as l where l.EmpId.Id="
						+ empId
						+ " and l.leaveStatus.Id<>5 order by l.FromDate");
		return leaveList;
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId) {

		List<HrEmployeeBalanceNew> leaveBal = new ArrayList<HrEmployeeBalanceNew>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);
		crit = crit.add(Restrictions.eq("Emp.Id", empId));
		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		leaveBal = crit.list();

		return leaveBal;
	}

	public void approveLeaves(MasEmployee user, String remarks,Box box) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		System.out.println("count==="+box.getInt("count"));
		for (int i = 1; i <= box.getInt("count"); i++) {
			if(box.getInt("checkboxVal"+i)!=0){
			HrLeaveDetails leaveDetails = (HrLeaveDetails) getHibernateTemplate()
					.load(HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			
			System.out.println("Size=="+box.getInt("checkboxVal"+i));
			int balanceId = leaveDetails.getEmpIdBal()!=null?leaveDetails.getEmpIdBal().getId():0;
			double noOfWorkingDays = Float.valueOf(leaveDetails
					.getNoOfWorkingDays());

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// changes
			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			int statusId = 0;
			if ((leaveDetails != null)
					&& (leaveDetails.getLeaveStatus().getId() == 6)) {
				statusId = leaveDetails.getLeaveStatus().getId();
				leaveStatus.setId(5);
			} else {
				System.out.println("in status approved 2");
				leaveStatus.setId(2);
			}
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setSuggestion(remarks);

			
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			saveLeaveHistory(leaveDetails);
			// if(typeOfLeave!=8 ) {//&& typeOfLeave!=3 && typeOfLeave!=4){
			HrEmployeeBalanceNew leaveBal=null;
			if(balanceId!=0)
			{
			 leaveBal = (HrEmployeeBalanceNew) getHibernateTemplate()
					.load(HrEmployeeBalanceNew.class, balanceId);
			}
			// double bal=0.0;
			/*
			 * if((leaveDetails.getEmpId().getLocationId()!=null) &&
			 * (leaveDetails.getEmpId().getLocationId()==5)){
			 * bal=Float.valueOf(leaveBal.getOnsiteUkBalance());
			 */

			// bal=Float.valueOf(leaveBal.getEarned());
			// double decreaseBalance=bal-noOfWorkingDays;
			// String decBal=new
			// DecimalFormat("0.##").format((double)decreaseBalance);
			String noOfWorkingDaysToSave = "";
			if(leaveBal!=null)
			{
			if (statusId == 6) {
				double takenAlready = Float.valueOf(leaveBal.getTaken());
				double takenTotal = takenAlready - noOfWorkingDays;
				double closingBal = Float.valueOf(leaveBal.getClosingBalance());
				String taken = new DecimalFormat("0.##")
						.format((double) takenTotal);

				double takenTotalYearly = Float.valueOf(leaveBal
						.getTotalLeaveTaken()) + noOfWorkingDays;
				String takenTotalYearlyStr = new DecimalFormat("0.##")
						.format((double) takenTotalYearly);

				noOfWorkingDaysToSave = new DecimalFormat("0.##")
						.format((double) noOfWorkingDays);
				if (leaveBal.getLeaveType().getLeaveType().getLeaveType()
						.getId().equals(4)
						|| leaveBal.getLeaveType().getLeaveType()
								.getLeaveType().getId().equals(3)) {
					leaveBal.setAlreadyAvailedPatMat("n");
				}
				double closingBalAfterAprov = closingBal + noOfWorkingDays;
				leaveBal.setClosingBalance(new DecimalFormat("0.##")
						.format((double) closingBalAfterAprov));
				leaveBal.setTaken(taken);
				leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
			} else {
				if (leaveBal.getLeaveType().getLeaveType().getLeaveType()
						.getId().equals(20)) {
					noOfWorkingDays = 1;
				}
				if (leaveBal.getLeaveType().getLeaveType().getLeaveType()
						.getId().equals(4)
						|| leaveBal.getLeaveType().getLeaveType()
								.getLeaveType().getId().equals(3)) {
					leaveBal.setAlreadyAvailedPatMat("y");
				}
				double takenAlready = Float.valueOf(leaveBal.getTaken());
				double takenTotal = takenAlready + noOfWorkingDays;
				// total taken yearly
				double takenTotalYearly = Float.valueOf(leaveBal
						.getTotalLeaveTaken()) + noOfWorkingDays;
				String takenTotalYearlyStr = new DecimalFormat("0.##")
						.format((double) takenTotalYearly);

				double closingBal = Float.valueOf(leaveBal.getClosingBalance());
				String taken = new DecimalFormat("0.##")
						.format((double) takenTotal);

				noOfWorkingDaysToSave = new DecimalFormat("0.##")
						.format((double) noOfWorkingDays);

				double closingBalAfterAprov = closingBal - noOfWorkingDays;
				leaveBal.setClosingBalance(new DecimalFormat("0.##")
						.format((double) closingBalAfterAprov));

				// if((leaveDetails.getEmpId().getLocationId()!=null) &&
				// (leaveDetails.getEmpId().getLocationId()==5))
				// leaveBal.setOnsiteUkBalance(decBal);
				// else
				leaveBal.setTaken(taken);
				leaveBal.setTotalLeaveTaken(takenTotalYearlyStr);
			}
			
			// leaveBal.setEarned(decBal);

			org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);

			hbt1.update(leaveBal);
			hbt1.refresh(leaveBal);
			saveEmployeeLeaveBalanceNewHistory(leaveBal, noOfWorkingDaysToSave,
					"n");
			}
			// }

			leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
					HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			recipientId = leaveDetails.getEmpId().getEmail();
			if (leaveDetails.getFromDate() != null) {
				fromToDate = "\nLeave period : "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getFromDate())
						+ " to "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getToDate());
			} else {
				fromToDate = "\nNo. of days : "
						+ leaveDetails.getNoOfWorkingDays();
			}
			if (leaveDetails.getHalfDay() != null
					|| "".equals(leaveDetails.getHalfDay())) {
				halfDayLeave = "\nHalf Day Leave : "
						+ leaveDetails.getHalfDay();
			}
			String emailMessage = "The leave with Leave ID "
					+ leaveDetails.getId()
					+ " from "
					+ leaveDetails.getEmpId().getFirstName()
					+ ", employee code "
					+ leaveDetails.getEmpId().getEmployeeCode()
					+ " "
					+ " has been approved by "
					+ user.getFirstName()
					+ "("
					+ user.getEmployeeCode()
					+ ").\n"
					+
					// "\nLeave ID is : "+leaveDetails.getId()+
					"\nLeave Status is : Approved"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription() + halfDayLeave + fromToDate;

			if (remarks != null && (!remarks.equals(""))) {
				emailMessage = emailMessage + "\nWith Remarks :" + remarks;
			}

			String hrEmail = getHRLeaveEmail();
			String DUHeadEmail = getDUHeadEmail(leaveDetails.getEmpId().getId());
			recipientId = recipientId.concat(",").concat(hrEmail).concat(",")
					.concat(DUHeadEmail);

			// mail
			//LeaveManagementUtil.intranetEmailFunction(recipientId,	user.getEmail(), emailMessage, "Leave Approved");
			// saveLeaveHistory(leaveDetails);
			// sendingSMS(leaveDetails,empId);
		}
		}
	}
	
	public Map<String,Object> recomendLeaves(String[] approve, MasEmployee user, String remarks,String recommend,String recommendRemarks,Box box) {
		Map<String,Object> map=new HashMap<String,Object>();
		MasEmployee emp=new MasEmployee();
		HrLeaveDetails leaveDetails = null;
		emp.setId(user.getId());
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		String fileName = null;
        String fileExtension = null;
        String uploadURL = box.getString("uploadURL");
        String fileSeparator = box.getString("fileSeparator");
        int uploadCount = box.getInt("uploadCount");
        
        org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		int j = 0;
		for (int i = 1; i <= uploadCount; i++) {
			if(box.getInt("checkboxVal"+i)!=0){
				leaveDetails = (HrLeaveDetails) getHibernateTemplate()
					.load(HrLeaveDetails.class, box.getInt("checkboxVal"+i));

			//System.out.println("file name==111==="+box.getString("filename"+i));
			if(box.getString("filename"+i) != null && !box.getString("filename"+i).equals("") && !box.getString("filename"+i).equals("0"))
			{
				UploadDocuments uploadDocuments = new UploadDocuments();
				File file=null;
				file = new File(uploadURL+fileSeparator+"LeaveDoc" +fileSeparator+box.getString("filename"+i));
				System.out.println("uploadURL=="+uploadURL);
				System.out.println("fileSeparator=="+fileSeparator);
				System.out.println("file=1212==="+file);
				if(!file.equals("")){
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
							// Create the byte array to hold the data
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
							System.out.println("bytes2222===="+bytes);
							uploadDocuments.setPatientDocument(bytes);
							is.close();
						} else {
							f.mkdir();
							FileInputStream is = new FileInputStream(file);
							long length = file.length();
							//ByteBuffer byteBuff=null;
							//  int modLength=length/
									if (length > Integer.MAX_VALUE) {
										// File is too large
									}
									// Create the byte array to hold the data
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
									System.out.println("bytes===444=="+bytes);
									is.close();      
									System.out.println("bytes===5555=="+bytes);
									uploadDocuments.setPatientDocument(bytes);
						}                                                
						//fileExtension=strToken.nextToken();

					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("file name for upload==="+box.getString("filename" + i));
					StringTokenizer strToken = new StringTokenizer(box.getString("filename" + i), ".");
					fileName = strToken.nextToken();
					fileExtension = strToken.nextToken();
					uploadDocuments.setFileExtension(fileExtension);
					uploadDocuments.setFileName(fileName);
					//uploadDocuments.setUploadDate(date);
					//uploadDocuments.setLastChgDate(date);
					//uploadDocuments.setLastChgTime(time);
					HrLeaveDetails dt = new HrLeaveDetails();
					//System.out.println("1111111======="+approve[i]);
					dt.setId(box.getInt("checkboxVal"+i));
					uploadDocuments.setLeaveDetail(dt);
					Users users=new Users();
					users.setId(box.getInt("userId"));
					uploadDocuments.setLastChgBy(users);
					MasHospital masHospital = new MasHospital();
					masHospital.setId(leaveDetails.getEmpId().getHospital().getId());
					uploadDocuments.setHospital(masHospital);
					hbt.save(uploadDocuments);

					//file.delete();
				
				}
			}

			// changes
			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			int statusId = 0;
			if ((leaveDetails != null) && !recommend.equals("")) {

				leaveStatus.setId(1);
			} else {
				leaveStatus.setId(1);
			}
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setSuggestion(remarks);
			//leaveDetails.seta
			leaveDetails.setLeaveApprovedBy(emp);
			if(box.getInt("userType")==1){
				leaveDetails.setRecommendStatus("s");
			}else{
				leaveDetails.setRecommendStatus(recommend);
			}
			leaveDetails.setRecomemdRemarks(recommendRemarks);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			saveLeaveHistory(leaveDetails);
			// if(typeOfLeave!=8 ) {//&& typeOfLeave!=3 && typeOfLeave!=4){
			/*HrEmployeeBalanceNew leaveBal=null;
			if(balanceId!=0)
			{
			 leaveBal = (HrEmployeeBalanceNew) getHibernateTemplate()
					.load(HrEmployeeBalanceNew.class, balanceId);
			}*/
			// double bal=0.0;
			/*
			 * if((leaveDetails.getEmpId().getLocationId()!=null) &&
			 * (leaveDetails.getEmpId().getLocationId()==5)){
			 * bal=Float.valueOf(leaveBal.getOnsiteUkBalance());
			 */

			// bal=Float.valueOf(leaveBal.getEarned());
			// double decreaseBalance=bal-noOfWorkingDays;
			// String decBal=new
			// DecimalFormat("0.##").format((double)decreaseBalance);
			/*String noOfWorkingDaysToSave = "";
			if(leaveBal!=null)
			{}*/
			// }

			leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
					HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			recipientId = leaveDetails.getEmpId().getEmail();
			if (leaveDetails.getFromDate() != null) {
				fromToDate = "\nLeave period : "
						+ LeaveManagementUtil
						.convertDateToStringWithoutTime(leaveDetails
								.getFromDate())
								+ " to "
								+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getToDate());
			} else {
				fromToDate = "\nNo. of days : "
						+ leaveDetails.getNoOfWorkingDays();
			}
			if (leaveDetails.getHalfDay() != null
					|| "".equals(leaveDetails.getHalfDay())) {
				halfDayLeave = "\nHalf Day Leave : "
						+ leaveDetails.getHalfDay();
			}
			String emailMessage = "The leave with Leave ID "
					+ leaveDetails.getId()
					+ " from "
					+ leaveDetails.getEmpId().getFirstName()
					+ ", employee code "
					+ leaveDetails.getEmpId().getEmployeeCode()
					+ " "
					+ " has been approved by "
					+ user.getFirstName()
					+ "("
					+ user.getEmployeeCode()
					+ ").\n"
					+
					// "\nLeave ID is : "+leaveDetails.getId()+
					"\nLeave Status is : Approved"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
					.getDescription() + halfDayLeave + fromToDate;

			if (remarks != null && (!remarks.equals(""))) {
				emailMessage = emailMessage + "\nWith Remarks :" + remarks;
			}

			String hrEmail = getHRLeaveEmail();
			String DUHeadEmail = getDUHeadEmail(leaveDetails.getEmpId().getId());
			recipientId = recipientId.concat(",").concat(hrEmail).concat(",")
					.concat(DUHeadEmail);

			// mail
			//LeaveManagementUtil.intranetEmailFunction(recipientId,	user.getEmail(), emailMessage, "Leave Approved");
			// saveLeaveHistory(leaveDetails);
			// sendingSMS(leaveDetails,empId);
			
		}
		}
		map.put("leaveDetails", leaveDetails);  // added by amit das on 15-11-2016
		return map;
	}


	public void approveLeavesEncashment(String[] approve, MasEmployee user,
			String remarks) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		String enchashedOrSimple = "";

		for (int i = 0; i < approve.length; i++) {
			HrEncashmentDetails leaveDetails = (HrEncashmentDetails) getHibernateTemplate()
					.load(HrEncashmentDetails.class,
							Integer.parseInt(approve[i]));
			int balanceId = leaveDetails.getEmpIdBal().getId();
			double noOfWorkingDays = Float.valueOf(leaveDetails
					.getLeaveToEncash());
			int typeOfLeave = leaveDetails.getLeaveType().getLeaveType()
					.getId();

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// changes
			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			leaveStatus.setId(2);

			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setRemarks(remarks);

			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			saveLeaveEncashmentHistory(leaveDetails);
			if (typeOfLeave != 8) {// && typeOfLeave!=3 && typeOfLeave!=4){
				HrEmployeeBalanceNew leaveBal = (HrEmployeeBalanceNew) getHibernateTemplate()
						.load(HrEmployeeBalanceNew.class, balanceId);
				// double bal=0.0;


				/*
				 * if((leaveDetails.getEmpId().getLocationId()!=null) &&
				 * (leaveDetails.getEmpId().getLocationId()==5)){
				 * bal=Float.valueOf(leaveBal.getOnsiteUkBalance());
				 */

				// bal=Float.valueOf(leaveBal.getEarned());
				// double decreaseBalance=bal-noOfWorkingDays;
				// String decBal=new
				// DecimalFormat("0.##").format((double)decreaseBalance);
				// String taken =new
				// DecimalFormat("0.##").format((double)noOfWorkingDays);
				double takenAlready = Float.valueOf(leaveBal.getTaken());
				double takenTotal = takenAlready + noOfWorkingDays;
				double openingBal = Float.valueOf(leaveBal.getOpeningBalance());
				double closingBal = Float.valueOf(leaveBal.getClosingBalance());
				String taken = new DecimalFormat("0.##")
						.format((double) takenTotal);
				String noOfWorkingDaysToSave = new DecimalFormat("0.##")
						.format((double) noOfWorkingDays);
				String strclosingBal = new DecimalFormat("0.##")
						.format((double) closingBal - (double) noOfWorkingDays);
				// if((leaveDetails.getEmpId().getLocationId()!=null) &&
				// (leaveDetails.getEmpId().getLocationId()==5))
				// leaveBal.setOnsiteUkBalance(decBal);
				// else
				enchashedOrSimple = "y";
				// leaveBal.setEarned(noOfWorkingDaysToSave);
				leaveBal.setTaken(taken);
				leaveBal.setClosingBalance(strclosingBal);
				// leaveBal.setEarned(decBal);

				org.springframework.orm.hibernate3.HibernateTemplate hbt1 = getHibernateTemplate();
				hbt1.setFlushModeName("FLUSH_EAGER");
				hbt1.setCheckWriteOperations(false);

				hbt1.update(leaveBal);
				hbt1.refresh(leaveBal);
				saveEmployeeLeaveBalanceNewHistory(leaveBal,
						noOfWorkingDaysToSave, enchashedOrSimple);

			}

			leaveDetails = (HrEncashmentDetails) getHibernateTemplate().load(
					HrEncashmentDetails.class, Integer.parseInt(approve[i]));
			recipientId = leaveDetails.getEmp().getEmail();

			fromToDate = "\nNo. of days : " + leaveDetails.getLeaveToEncash();
			String emailMessage = "The leave for encashment with Leave ID "
					+ leaveDetails.getId() + " from "
					+ leaveDetails.getEmp().getFirstName()
					+ ", employee code "
					+ leaveDetails.getEmp().getEmployeeCode()
					+ " "
					+ " has been approved by "
					+ user.getFirstName()
					+ "("
					+ user.getEmployeeCode()
					+ ").\n"
					+
					// "\nLeave ID is : "+leaveDetails.getId()+
					"\nLeave Status is : Approved"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription() + fromToDate;

			if (remarks != null && (!remarks.equals(""))) {
				emailMessage = emailMessage + "\nWith Remarks :" + remarks;
			}

			String hrEmail = getHRLeaveEmail();
			String DUHeadEmail = getDUHeadEmail(leaveDetails.getEmp().getId());
			recipientId = recipientId.concat(",").concat(hrEmail).concat(",")
					.concat(DUHeadEmail);

			// mail
			// LeaveManagementUtil.intranetEmailFunction(recipientId,
			// user.getEmail(), emailMessage, "Leave Approved");
			// saveLeaveHistory(leaveDetails);
			// sendingSMS(leaveDetails,empId);
		}

	}

	private String getDUHeadEmail(int empId) {
		// changes
		// List duHead = getHibernateTemplate().find("from
		// com.jkt.intranet.business.Duempmap as du where du.EmpId =" + empId);
		// Duempmap dumap = (Duempmap) duHead.get(0);
		// String emailId =
		// dumap.getSelectedEmpDuMaster().getDuHeadName().getEmailId();
		// return emailId;
		return "ddd.ddd@jktech.com";
	}

	private String getHRLeaveEmail() {
		// changes
		// List<CategoryUser> hrUser = getHibernateTemplate().find("from
		// com.jkt.intranet.business.CategoryUser as catUser where
		// catUser.CategoryId =15");
		// CategoryUser catUser = hrUser.get(0);
		// return catUser.getUsers().getEmailId();
		return "nares.dfssf@jktech.com";
	}

	public void disapproveLeaves(MasEmployee user,
			String disapproveMessage,Box box) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		
		System.out.println("count==="+box.getInt("count"));
		for (int i = 1; i <= box.getInt("count"); i++) {
			if(box.getInt("checkboxVal"+i)!=0){
			HrLeaveDetails leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			System.out.println("Size=="+box.getInt("checkboxVal"+i));

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// changes
			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();

			leaveStatus.setId(4);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setDisapproveReason(disapproveMessage);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			saveLeaveHistory(leaveDetails);
			leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
					HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			recipientId = leaveDetails.getEmpId().getEmail();
			if (leaveDetails.getFromDate() != null) {
				fromToDate = "\nLeave period : "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getFromDate())
						+ " to "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getToDate());
			} else {
				fromToDate = "\nNo. of days : "
						+ leaveDetails.getNoOfWorkingDays();
			}
			if (leaveDetails.getHalfDay() != null
					|| "".equals(leaveDetails.getHalfDay())) {
				halfDayLeave = "\nHalf Day Leave : "
						+ leaveDetails.getHalfDay();
			}
			String emailMessage = "The leave with Leave ID "
					+ leaveDetails.getId() + " from "
					+ leaveDetails.getEmpId().getFirstName()
					+ ", employee code "
					+ leaveDetails.getEmpId().getEmployeeCode()
					+ " has been disapproved  by " + user.getFirstName() + "("
					+ user.getEmployeeCode() + ")";

			if (disapproveMessage != null && (!disapproveMessage.equals(""))) {
				emailMessage = emailMessage
						+ ", due to following reason.\n Reason :"
						+ disapproveMessage;
			}

			emailMessage = emailMessage
					+ "\nLeave Status is : Disapproved"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription() + halfDayLeave + fromToDate;
			// mail
			// LeaveManagementUtil.intranetEmailFunction(recipientId,
			// user.getEmail(), emailMessage, "Leave Disapproved");
			// saveLeaveHistory(leaveDetails);
			// sendingSMS(leaveDetails,empId);
			}
		}
	}

	public void disapproveLeavesEncashment(String[] disapprove,
			MasEmployee user, String disapproveMessage) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";

		for (int i = 0; i < disapprove.length; i++) {
			HrEncashmentDetails leaveDetails = (HrEncashmentDetails) getHibernateTemplate()
					.load(HrEncashmentDetails.class,
							Integer.parseInt(disapprove[i]));

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			// changes
			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			leaveStatus.setId(4);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setRemarks(disapproveMessage);
			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);
			hbt.update(leaveDetails);
			saveLeaveEncashmentHistory(leaveDetails);
			leaveDetails = (HrEncashmentDetails) getHibernateTemplate().load(
					HrEncashmentDetails.class, Integer.parseInt(disapprove[i]));
			recipientId = leaveDetails.getEmp().getEmail();

			fromToDate = "\nNo. of days : " + leaveDetails.getLeaveToEncash();
			String emailMessage = "The leave with Leave ID "
					+ leaveDetails.getId() + " from "
					+ leaveDetails.getEmp().getFirstName() + ", employee code "
					+ leaveDetails.getEmp().getEmployeeCode()
					+ " has been disapproved  by " + user.getFirstName() + "("
					+ user.getEmployeeCode() + ")";

			if (disapproveMessage != null && (!disapproveMessage.equals(""))) {
				emailMessage = emailMessage
						+ ", due to following reason.\n Reason :"
						+ disapproveMessage;
			}

			emailMessage = emailMessage
					+ "\nLeave Status is : Disapproved"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription() + fromToDate;

			// mail
			// LeaveManagementUtil.intranetEmailFunction(recipientId,
			// user.getEmail(), emailMessage, "Leave Disapproved");
			// saveLeaveHistory(leaveDetails);
			// sendingSMS(leaveDetails,empId);
		}
	}

	public void deleteLeaves(String[] delete, MasEmployee user,
			String deleteMessage) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		if (delete != null) {

			for (int i = 0; i < delete.length; i++) {
				HrLeaveDetails leaveDetails = (HrLeaveDetails) getHibernateTemplate()
						.load(HrLeaveDetails.class, Integer.parseInt(delete[i]));
				HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
				if (leaveDetails != null) {
					if (leaveDetails.getLeaveStatus().getId() == 2) {

						leaveStatus.setId(6);
					} else {

						leaveStatus.setId(5);
					}
				}
				// changes

				leaveDetails.setLeaveStatus(leaveStatus);

				leaveDetails.setDeleteReason(deleteMessage);
				Date currentDate = new Date();
				leaveDetails.setApprovedOn(currentDate);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);

				saveLeaveHistory(leaveDetails);
				leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
						HrLeaveDetails.class, Integer.parseInt(delete[i]));
				recipientId = leaveDetails.getEmpId().getEmail();
				if (leaveDetails.getFromDate() != null) {
					fromToDate = "\nLeave period : "
							+ LeaveManagementUtil
									.convertDateToStringWithoutTime(leaveDetails
											.getFromDate())
							+ " to "
							+ LeaveManagementUtil
									.convertDateToStringWithoutTime(leaveDetails
											.getToDate());
				} else {
					fromToDate = "\nNo. of days : "
							+ leaveDetails.getNoOfWorkingDays();
				}
				if (leaveDetails.getHalfDay() != null
						|| "".equals(leaveDetails.getHalfDay())) {
					halfDayLeave = "\nHalf Day Leave : "
							+ leaveDetails.getHalfDay();
				}
				String emailMessage = user.getFirstName()
						+ " (Employee code: "
						+ user.getEmployeeCode()
						+ ") has deleted the leave record, due to following reason:\n"
						+ deleteMessage
						+
						// "\nLeave ID is : "+leaveDetails.getId()+
						"\nLeave Status is : Deleted"
						+ "\nLeave Type is : "
						+ leaveDetails.getLeaveType().getLeaveType()
								.getLeaveType().getDescription() + halfDayLeave
						+ fromToDate;
				// mail
				// LeaveManagementUtil.intranetEmailFunction(recipientId,
				// user.getEmail(), emailMessage, "Leave Record Deleted");
				// saveLeaveHistory(leaveDetails);
			}
		}

	}

	public void deleteLeavesEncashment(String[] delete, MasEmployee user,
			String deleteMessage) {
		String recipientId = "";
		String fromToDate = "";
		String halfDayLeave = "";
		if (delete != null) {

			for (int i = 0; i < delete.length; i++) {
				HrEncashmentDetails leaveDetails = (HrEncashmentDetails) getHibernateTemplate()
						.load(HrEncashmentDetails.class,
								Integer.parseInt(delete[i]));

				// changes
				HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
				leaveStatus.setId(5);
				leaveDetails.setLeaveStatus(leaveStatus);

				leaveDetails.setDeleteReason(deleteMessage);
				Date currentDate = new Date();
				leaveDetails.setApprovedOn(currentDate);

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				hbt.update(leaveDetails);
				hbt.refresh(leaveDetails);

				saveLeaveEncashmentHistory(leaveDetails);

				leaveDetails = (HrEncashmentDetails) getHibernateTemplate()
						.load(HrEncashmentDetails.class,
								Integer.parseInt(delete[i]));
				recipientId = leaveDetails.getEmp().getEmail();

				fromToDate = "\nNo. of days : "
						+ leaveDetails.getLeaveToEncash();

				String emailMessage = user.getFirstName()
						+ " (Employee code: "
						+ user.getEmployeeCode()
						+ ") has deleted the leave record, due to following reason:\n"
						+ deleteMessage
						+
						// "\nLeave ID is : "+leaveDetails.getId()+
						"\nLeave Status is : Deleted"
						+ "\nLeave Type is : "
						+ leaveDetails.getLeaveType().getLeaveType()
								.getLeaveType().getDescription() + fromToDate;
				// mail
				// LeaveManagementUtil.intranetEmailFunction(recipientId,
				// user.getEmail(), emailMessage, "Leave Record Deleted");
				// saveLeaveHistory(leaveDetails);
			}
		}

	}

	public List getempNamesList(int userId) {
		List empList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as users where users.Id IN(select mgr.EmpId from jkt.hrms.masters.business.UserManager as mgr where mgr.ManagerId="
						+ userId + ") order by users.FirstName");
		return empList;
	}

	public void sendSuggestion(MasEmployee user,
			String suggestionMessage,Box box) {
		String memberId = "";
		String fromToDate = "";
		String halfDayLeave = "";

		System.out.println("count==="+box.getInt("count"));
		for (int i = 1; i <= box.getInt("count"); i++) {
			if(box.getInt("checkboxVal"+i)!=0){
			HrLeaveDetails leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			System.out.println("Size=="+box.getInt("checkboxVal"+i));
			// change
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			leaveStatus.setId(1);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setSuggestion(suggestionMessage);

			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);

			hbt.update(leaveDetails);

			saveLeaveHistory(leaveDetails);
			leaveDetails = (HrLeaveDetails) getHibernateTemplate().load(
					HrLeaveDetails.class, box.getInt("checkboxVal"+i));
			memberId = leaveDetails.getEmpId().getEmail();
			if (leaveDetails.getFromDate() != null) {
				fromToDate = "\nLeave period : "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getFromDate())
						+ " to "
						+ LeaveManagementUtil
								.convertDateToStringWithoutTime(leaveDetails
										.getToDate());
			} else {
				fromToDate = "\nNo. of days : "
						+ leaveDetails.getNoOfWorkingDays();
			}
			if (leaveDetails.getHalfDay() != null
					|| "".equals(leaveDetails.getHalfDay())) {
				halfDayLeave = "\nHalf Day Leave : "
						+ leaveDetails.getHalfDay();
			}

			String emailMessage = "The leave with Leave ID "
					+ leaveDetails.getId() + " from "
					+ leaveDetails.getEmpId().getFirstName()
					+ ", employee code "
					+ leaveDetails.getEmpId().getEmployeeCode()
					+ " has been put on hold by " + user.getFirstName() + "("
					+ user.getEmployeeCode() + ")";

			if (suggestionMessage != null && (!suggestionMessage.equals(""))) {
				emailMessage = emailMessage
						+ ", with following remarks .\n Remarks :"
						+ suggestionMessage;
			}

			emailMessage = emailMessage
					+ "\nLeave Status is : On Hold"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription() + halfDayLeave + fromToDate;

			// getHibernateTemplate().update(leaveDetails);
			// saveLeaveHistory(leaveDetails);
			// mail
			// LeaveManagementUtil.intranetEmailFunction(memberId,
			// user.getEmail(), emailMessage, "Suggestion");
			}
		}

	}

	public void onHoldEncashment(String[] suggestion, MasEmployee user,
			String suggestionMessage) {
		String memberId = "";
		String fromToDate = "";
		String halfDayLeave = "";

		for (int i = 0; i < suggestion.length; i++) {

			HrEncashmentDetails leaveDetails = (HrEncashmentDetails) getHibernateTemplate()
					.load(HrEncashmentDetails.class,
							Integer.parseInt(suggestion[i]));
			// change
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			HrMasLeaveStatus leaveStatus = new HrMasLeaveStatus();
			leaveStatus.setId(1);
			leaveDetails.setLeaveStatus(leaveStatus);

			leaveDetails.setRemarks(suggestionMessage);

			Date currentDate = new Date();
			leaveDetails.setApprovedOn(currentDate);

			hbt.update(leaveDetails);

			saveLeaveEncashmentHistory(leaveDetails);
			leaveDetails = (HrEncashmentDetails) getHibernateTemplate().load(
					HrEncashmentDetails.class, Integer.parseInt(suggestion[i]));
			memberId = leaveDetails.getEmp().getEmail();

			String emailMessage = "The leave for encashment with Leave ID "
					+ leaveDetails.getId() + " from "
					+ leaveDetails.getEmp().getFirstName() + ", employee code "
					+ leaveDetails.getEmp().getEmployeeCode()
					+ " has been put on hold by " + user.getFirstName() + "("
					+ user.getEmployeeCode() + ")";

			if (suggestionMessage != null && (!suggestionMessage.equals(""))) {
				emailMessage = emailMessage
						+ ", with following remarks .\n Remarks :"
						+ suggestionMessage;
			}

			emailMessage = emailMessage
					+ "\nLeave Status is : On Hold"
					+ "\nLeave Type is : "
					+ leaveDetails.getLeaveType().getLeaveType().getLeaveType()
							.getDescription();

			// getHibernateTemplate().update(leaveDetails);
			// saveLeaveHistory(leaveDetails);
			// mail
			// LeaveManagementUtil.intranetEmailFunction(memberId,
			// user.getEmail(), emailMessage, "Suggestion");
		}

	}

	public List commonEmpMgr(int userId) {
		// List<MasEmployee>
		// empList=(List<MasEmployee>)getHibernateTemplate().find("from
		// com.jkt.intranet.business.UserManager as mgr where
		// mgr.EmpId="+userId);

		// changes
		List<UserManager> empList = (List<UserManager>) getHibernateTemplate()
				.find("from jkt.hrms.masters.business.UserManager as user where user.ManagerId ="
						+ userId);
		return empList;
	}

	public void saveLeaveHistory(HrLeaveDetails leave) {
		HrLeaveDetailsHistory leaveHist = new HrLeaveDetailsHistory();
		leaveHist.setAppliedOn(leave.getAppliedOn());
		leaveHist.setApprovedBy(leave.getLeaveApprovedBy().getId());
		leaveHist.setContactAddress(leave.getContactAddress());
		leaveHist.setContactPhone(leave.getContactPhone());
		leaveHist.setEmpid(leave.getEmpId().getId());
		leaveHist.setFromDate(leave.getFromDate());
		leaveHist.setJoiningDate(leave.getJoiningDate());
		leaveHist.setModifiedBy(leave.getModifiedBy());
		leaveHist.setModifiedOn(leave.getModifiedOn());
		leaveHist.setNoOfWorkingDays(leave.getNoOfWorkingDays());
		leaveHist.setReason(leave.getReason());
		leaveHist.setEmpIdBal(leave.getEmpIdBal());

		if (leave.getDeleteReason() != null) {
			leaveHist.setDeleteReason(leave.getDeleteReason());
		}

		leaveHist.setStatus(leave.getLeaveStatus().getId());
		leaveHist.setToDate(leave.getToDate());
		//leaveHist.setType(leave.getLeaveType().getId());
		if(leave.getLeaveType()!= null){
			leaveHist.setType(leave.getLeaveType().getId());
		}
		if (leave.getSuggestion() != null) {
			leaveHist.setSuggestion(leave.getSuggestion());
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(leaveHist);
		// hbt.refresh(leaveHist);
	}

	public void saveLeaveEncashmentHistory(HrEncashmentDetails leave) {
		HrEncashmentDetailsHistory leaveHist = new HrEncashmentDetailsHistory();
		leaveHist.setAppliedOn(leave.getAppliedOn());
		leaveHist.setApprovedBy(leave.getApprovedBy());
		// leaveHist.setContactAddress(leave.getContactAddress());
		// leaveHist.setContactPhone(leave.getContactPhone());
		leaveHist.setEmp(leave.getEmp());
		// leaveHist.setFromDate(leave.getFromDate());
		// leaveHist.setJoiningDate(leave.getJoiningDate());
		// leaveHist.setModifiedBy(leave.getModifiedBy());
		// leaveHist.setModifiedOn(leave.getModifiedOn());
		leaveHist.setLeaveToEncash(leave.getLeaveToEncash());
		if (leave.getDeleteReason() != null) {
			leaveHist.setDeleteReason(leave.getDeleteReason());
		}
		leaveHist.setReason(leave.getReason());
		leaveHist.setLeaveStatus(leave.getLeaveStatus());
		// leaveHist.setToDate(leave.getToDate());
		leaveHist.setBalance(leave.getEmpIdBal());
		leaveHist.setCompany(leave.getCompany());
		leaveHist.setStatus(leave.getStatus());
		leaveHist.setLastChgBy(leave.getLastChgBy());
		leaveHist.setLastChgDate(leave.getLastChgDate());
		leaveHist.setLastChgTime(leave.getLastChgTime());

		leaveHist.setLeaveType(leave.getLeaveType());
		if (leave.getRemarks() != null) {
			leaveHist.setRemarks(leave.getRemarks());
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(leaveHist);
		hbt.refresh(leaveHist);
	}

	public Map getEmpLeaveDetails(int empId) {
		Map map = new HashMap();
		List leaveBalanceList = new ArrayList();
		List leaveDetailsList = new ArrayList();
		List userList = new ArrayList();

		userList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasEmployee us where us.Id = "
						+ empId);
		leaveBalanceList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEmployeeBalanceNew ul where ul.Emp.Id="
						+ empId);
		leaveDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrLeaveDetails ld where ld.EmpId.Id="
						+ empId);

		map.put("leaveBalanceList", leaveBalanceList);
		map.put("leaveDetailsList", leaveDetailsList);
		map.put("userList", userList);
		return map;
	}

	public void updateLeaveBalance(HrUpdateLeaveBalanceHistory leaveHistory,
			String newLeaveBalance, String newOnsiteUkBalance, int empId,
			String balanceAdjustedBy) {
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<HrEmployeeBalanceNew> leaveBalanceList = new ArrayList<HrEmployeeBalanceNew>();
		int leaveTypeId = leaveHistory.getLeaveType().getId();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);
		crit = crit.createAlias("LeaveType", "lt");
		crit = crit.add(Restrictions.eq("lt.Id", leaveTypeId));
		crit = crit.add(Restrictions.eq("Emp.Id", empId));
		Order order = Order.asc("Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));
		leaveBalanceList = crit.list();

		HrEmployeeBalanceNew userLeaveBalance = (HrEmployeeBalanceNew) leaveBalanceList
				.get(0);

		leaveHistory.setPreviousLeaveBalance(userLeaveBalance
				.getClosingBalance());
		hbt.save(leaveHistory);

		/*
		 * String balanceAdjustedAlreadyString =
		 * userLeaveBalance.getBalanceAdjustedBy(); double
		 * balanceAdjustedByDouble = Float.valueOf(balanceAdjustedBy); double
		 * balanceAdjustedAlreadyDouble =
		 * Float.valueOf(balanceAdjustedAlreadyString); double
		 * balanceAdjustmentToSaveDouble = balanceAdjustedAlreadyDouble +
		 * balanceAdjustedByDouble;
		 */

		double balanceAdjusted = Float.valueOf(userLeaveBalance
				.getBalanceAdjustedBy()) + Float.valueOf(balanceAdjustedBy);
		String balanceAdjustmentToSave = new DecimalFormat("0.##")
				.format((double) balanceAdjusted);
		userLeaveBalance.setBalanceAdjustedBy(balanceAdjustmentToSave);
		userLeaveBalance.setClosingBalance(newLeaveBalance);
		hbt.update(userLeaveBalance);
	}

	public Map getEmailId(int hrId, int empId) {
		Map map = new HashMap();

		List hrManagerList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.UserManager um where um.EmpId="
						+ hrId);
		// changes
		UserManager hrManager = (UserManager) hrManagerList.get(0);
		String hrManagerEmailId = hrManager.getManagers().getEmail();

		MasEmployee empUser = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, empId);
		String empEmailId = empUser.getEmail();

		List userManagerList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.UserManager um where um.EmpId="
						+ empId);
		String userManagerEmailId = "";
		if (userManagerList.size() != 0) {
			// changes
			UserManager userManager = (UserManager) userManagerList.get(0);
			userManagerEmailId = userManager.getUsers().getEmail();
		}
		// changes
		map.put("hrManagerEmailId", hrManagerEmailId);

		// map.put("hrManagerEmailId", "bn.sjdh@jks.co");
		map.put("empEmailId", empEmailId);
		map.put("userManagerEmailId", userManagerEmailId);

		return map;

	}

	public List viewLeaveHistory(int empId) {
		List leaveHistoryList = new ArrayList();
		leaveHistoryList = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrUpdateLeaveBalanceHistory balanceHistory where balanceHistory.EmpId = "
						+ empId);
		return leaveHistoryList;
	}

	public List getAvailedRhList(MasEmployee user) {
		int empId = user.getId();
		Calendar currentDate = new GregorianCalendar();
		int currentYear = currentDate.get(Calendar.YEAR);
		List availedRh = null;
		availedRh = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails leave where leave.leaveType.Id=7 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id="
						+ empId + " and year(leave.FromDate)=" + currentYear);
		return availedRh;
	}

	public List getBirthdayLeave(int empId) {
		Calendar currentDate = new GregorianCalendar();
		int currentYear = currentDate.get(Calendar.YEAR);
		List birthdayLeave = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 5 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "
						+ empId + " and year(leave.FromDate)=" + currentYear);
		return birthdayLeave;
	}

	public List getAnniversaryLeave(int empId) {
		Calendar currentDate = new GregorianCalendar();
		int currentYear = currentDate.get(Calendar.YEAR);
		List anniversaryLeave = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 6 and leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "
						+ empId + " and year(leave.FromDate)=" + currentYear);
		return anniversaryLeave;
	}

	public List getPaternityLeave(int empId) {
		Calendar currentDate = new GregorianCalendar();
		int currentYear = currentDate.get(Calendar.YEAR);
		List paternityLeave = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails leave where leave.leaveType.Id = 4 and  leave.leaveStatus.Id IN(2,3) and leave.EmpId.Id = "
						+ empId + " and year(leave.FromDate)=" + currentYear);
		return paternityLeave;
	}

	public List getWaitingEncashmentLeave(MasEmployee user) {
		List encashmentLeaveWaiting = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrEncashmentDetails as leave where leave.LeaveStatus.Id=3 and leave.ApprovedBy.Id = "
						+ user.getId() + " order by leave.Id");
		return encashmentLeaveWaiting;
	}

	public void sendingSMS(HrLeaveDetails leaveDetails, int empId) {
		// EmployeeDetails mobilePhoneDetails =
		// (EmployeeDetails)getHibernateTemplate().load(EmployeeDetails.class,empId);
		// if(mobilePhoneDetails!=null)
		// if(mobilePhoneDetails.getMobileNumber()!=null);
		// (new SmsReceiver()).startReceiving(leaveDetails);
	}

	public MasEmployee getMemberDetails(int memberId) {
		MasEmployee memberDetail = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, memberId);
		return memberDetail;
	}

	public List getAllWaitingLeavesForHR(int empId) {
		List<Object> allWaitingLeaves = new ArrayList<Object>();
		allWaitingLeaves = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=3 and leave.EmpId in (select Id from MasEmployee where LineManager="
						+ empId + ") order by leave.Id");
		return allWaitingLeaves;
	}

	public List getIdsToSendMail() {
		List listOfManagers = new ArrayList();
		List waitingLeavesFromWeek = getHibernateTemplate()
				.find("from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.leaveStatus.Id=3");
		for (Iterator iter = waitingLeavesFromWeek.iterator(); iter.hasNext();) {
			HrLeaveDetails leave = (HrLeaveDetails) iter.next();
			Date appliedDate = leave.getAppliedOn();
			Date currentDate = new Date();
			long days = LeaveManagementUtil.daysDifferenceBetweenTwoDates(
					appliedDate, currentDate);
			if (days >= 7) {
				// is>>>"+leave.getLeaveApprovedBy().getFullName());
				listOfManagers.add(leave.getLeaveApprovedBy());
				// list>>>"+listOfManagers.get(0));
			}
		}
		return listOfManagers;
	}

	public List getLeaveStatusList() {
		List<Object> leaveStatusList = new ArrayList<Object>();
		leaveStatusList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrMasLeaveStatus");
		return leaveStatusList;
	}

	public List<HrLeaveDetails> getLeavesList(Integer userId, String fromDate,
			String toDate, String leaveType, String leaveStatus) {
		
		 StringBuffer query = new StringBuffer(" from HrLeaveDetails as leaveDetails order by leaveDetails.Id desc where  leaveDetails.EmpId.Id = '"+userId+"'");
		 
		
		  if(fromDate !=null && !fromDate.trim().equals("") && toDate != null &&  !toDate.trim().equals("")){
			  query.append(" and leaveDetails.FromDate >= '" + fromDate+"' and leaveDetails.FromDate <= '" + toDate + "'" ); 
			  }
		 
		   if(leaveType   != null && !leaveType.trim().equals("")){
			   query.append("and leaveDetails.leaveType.Id = '"+ leaveType +"'"); 
			   }
		
		  
		  if(leaveStatus !=null && !leaveStatus.trim().equals("")){
			  query.append("and leaveDetails.leaveStatus.Id = '"+ leaveStatus +"'"); 
		 } 
		 
		List<HrLeaveDetails> leaveDetailList = null; // =
		// getHibernateTemplate().find(query.toString());

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrLeaveDetails.class);

		if (fromDate != null && !fromDate.trim().equals("")) {

			Date fromDateForQuery = HMSUtil
					.convertStringTypeDateToDateType(fromDate);
			crit = crit.add(Restrictions.ge("FromDate", fromDateForQuery));
		}
		if (toDate != null && !toDate.trim().equals("")) {

			Date toDateForQuery = HMSUtil
					.convertStringTypeDateToDateType(toDate);
			crit = crit.add(Restrictions.le("FromDate", toDateForQuery));
		}
		if (leaveType != null && !leaveType.trim().equals("")) {
			crit = crit.add(Restrictions.eq("leaveType.Id",
					Integer.parseInt(leaveType)));

		}
		if (leaveStatus != null && !leaveStatus.trim().equals("")) {
			crit = crit.add(Restrictions.eq("leaveStatus.Id",
					Integer.parseInt(leaveStatus)));
		}
		Order order = Order.desc("Id");

		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));
		crit = crit.add(Restrictions.eq("EmpId.Id", userId));

		leaveDetailList = crit.list();

		return leaveDetailList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]>getUploadDataList(Map<String, Object> mapForDs) {
		List<Object[]> uploadDocList = new ArrayList<Object[]>();
		Session session = (Session) getSession();
		int hospitalId = 0;
		if(mapForDs.get("hospitalId") != null){
			hospitalId = (Integer)mapForDs.get("hospitalId");
		}
		uploadDocList = session.createCriteria(UploadDocuments.class).createAlias("LeaveDetail", "leave").add(Restrictions.eq("Hospital.Id", hospitalId))
				.setProjection(Projections.projectionList().add(Projections.property("leave.Id"))
						.add(Projections.property("FileName")).add(Projections.property("FileExtension")).add(Projections.property("Id"))).list();
		System.out.println("uploadDocList==in ds=="+uploadDocList.size());
		return uploadDocList;
	}

	public List<HrEncashmentDetails> getLeavesEncashmentList(Integer userId,
			String fromDate, String toDate, String leaveType, String leaveStatus) {

		List<HrEncashmentDetails> leaveDetailList = null; // =
		// getHibernateTemplate().find(query.toString());

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrEncashmentDetails.class);

		if (fromDate != null && !fromDate.trim().equals("") && toDate != null
				&& !toDate.trim().equals("")) {
			Date fromDateForQuery = HMSUtil
					.convertStringTypeDateToDateType(fromDate);
			Date toDateForQuery = HMSUtil
					.convertStringTypeDateToDateType(toDate);

			crit = crit.add(Restrictions.ge("AppliedOn", fromDateForQuery));
			crit = crit.add(Restrictions.le("AppliedOn", toDateForQuery));
		}
		if (leaveType != null && !leaveType.trim().equals("")) {
			crit = crit.add(Restrictions.eq("LeaveType.Id",
					Integer.parseInt(leaveType)));

		}
		if (leaveStatus != null && !leaveStatus.trim().equals("")) {
			crit = crit.add(Restrictions.eq("LeaveStatus.Id",
					Integer.parseInt(leaveStatus)));
		}
		Order order = Order.desc("Id");

		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		
		  if(userId != -1) { crit = crit.createAlias("ApprovedBy",
		  "Emp").add(Restrictions.eq("Emp.Id", userId)); }
		 
		if (userId != -1) {
			crit = crit.add(Restrictions.eq("Emp.Id", userId));
		}

		leaveDetailList = crit.list();

		return leaveDetailList;
	}

	/*public void submitLeaveForm(List<HrLeaveDetails> optionalleaveList,
			int userId, String applierId) {
		String fromToDate = "";
		String halfDayLeave = "";
		String emailMessage = "";
		Iterator<HrLeaveDetails> iterateoptionalleaveList = optionalleaveList
				.iterator();

		List<HrLeaveDetails> leaveDetailsList = new ArrayList<HrLeaveDetails>();
		if (optionalleaveList != null) {
			while (iterateoptionalleaveList.hasNext()) {
				HrLeaveDetails leave = iterateoptionalleaveList.next();

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);
				hbt.save(leave);
				hbt.refresh(leave);

				// getHibernateTemplate().save(leave);

				saveLeaveHistory(leave);

				MasEmployee manager = (MasEmployee) getHibernateTemplate()
						.load(MasEmployee.class,
								leave.getLeaveApprovedBy().getId());

				HrLeaveDetails leaveDetails = null;

				Session session = (Session) getSession();
				leaveDetailsList = getHibernateTemplate().find(
						"from jkt.hrms.masters.business.HrLeaveDetails as leave where leave.Id='"
								+ leave.getId() + "'");
				// leaveDetailsList =
				// session.createCriteria(HrLeaveDetails.class).add(Restrictions.eq("Id",leave.getId())).list();

				leaveDetails = leaveDetailsList.get(0);
				// leaveDetails=
				// (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class,
				// leave.getId());
				if (leave.getFromDate() != null && leave.getToDate() != null) {
					fromToDate = "\nLeave period : "
							+ LeaveManagementUtil
									.convertDateToStringWithoutTime(leave
											.getFromDate())
							+ " to "
							+ LeaveManagementUtil
									.convertDateToStringWithoutTime(leave
											.getToDate());
				} else {
					fromToDate = "\nNo. of days : "
							+ leave.getNoOfWorkingDays();
				}
				if (leave.getHalfDay() != null || "".equals(leave.getHalfDay())) {
					halfDayLeave = "\nHalf Day Leave : " + leave.getHalfDay();
				}
				if(leave.getLeaveType().getLeaveType()!= null){
				if(leave.getLeaveType().getLeaveType().getLeaveType()!= null){
				if (leave.getLeaveType().getLeaveType().getLeaveType().getId() != null) {
					if (leave.getLeaveType().getLeaveType().getLeaveType()
							.getId() == 5) {
						emailMessage = "There is a leave with leave ID "
								+ leave.getId()
								+ " applied by "
								+ leaveDetails.getEmpId().getFirstName()
								+ " with employee code "
								+ leaveDetails.getEmpId().getEmployeeCode()
								+
								// " and base location
								// "+leaveDetails.getEmpId()/*.getLocation().getLocationDesc()
								// +" waiting for the approval.\n"+
								// "\nLeave ID is : "+leave.getId()+
								"\nLeave Status is : Waiting"
								+ "\nLeave Type is : "
								+ leaveDetails.getLeaveType().getLeaveType()
										.getLeaveType().getDescription()
								+ halfDayLeave + fromToDate;
					} else if (leave.getLeaveType().getLeaveType()
							.getLeaveType().getId() == 6) {
						emailMessage = "There is a leave with leave ID "
								+ leave.getId()
								+ " applied by "
								+ leaveDetails.getEmpId().getFirstName()
								+ " with employee code "
								+ leaveDetails.getEmpId().getEmployeeCode()
								+
								// " and base location
								// "+leaveDetails.getEmpId().getLocation().getLocationDesc()
								// +" waiting for the approval.\n"+
								// "\nLeave ID is : "+leave.getId()+
								"\nLeave Status is : Waiting"
								+ "\nLeave Type is : "
								+ leaveDetails.getLeaveType().getLeaveType()
										.getLeaveType().getDescription()
								+ halfDayLeave + fromToDate;
					} else {
						emailMessage = "There is a leave with leave ID "
								+ leave.getId()
								+ " applied by "
								+ leaveDetails.getEmpId().getFirstName()
								+ " with employee code "
								+ leaveDetails.getEmpId().getEmployeeCode()
								+
								// " and base location
								// "+leaveDetails.getEmpId().getLocation().getLocationDesc()
								// +" waiting for the approval.\n"+
								// "\nLeave ID is : "+leave.getId()+
								"\nLeave Status is : Waiting"
								+ "\nLeave Type is : "
								+ leaveDetails.getLeaveType().getLeaveType()
										.getLeaveType().getDescription()
								+ halfDayLeave + fromToDate;
					}
				}
				}
				}
				String hrEmailId = getHRLeaveEmail();

				// changes
				String recipientAddresses = manager.getEmail().concat(",")
						.concat(hrEmailId);
				// String recipientAddresses = "nar.xys@jjsfdfdfdf.com";
				// mail
				LeaveManagementUtil.emailFunctionLeave("uhghjhj",
						"uihghghjghym", emailMessage, "Leave Application");
				
				

			}
		}
	}*/
	
	public void submitLeaveForm(List<HrLeaveDetails> optionalleaveList,int userId,String applierId)
	{
		String fromToDate="";
		String emailMessage="";
		String firstOrSecondHalf = "";
		Iterator<HrLeaveDetails> iterateoptionalleaveList = optionalleaveList.iterator();
		/*MasEmployee employee=null;
		employee=(MasEmployee) session.load(MasEmployee.class, userId);
		Date dob=null;
		Date doj=null;
		if(null !=employee){
			dob=employee.getDateOfBirth();
			doj=employee.getJoinDate();
			
		}*/
		//List<HrLeaveDetails> leaveDetailsList = new ArrayList<HrLeaveDetails>();
		if(optionalleaveList != null){
			while(iterateoptionalleaveList.hasNext()){
				HrLeaveDetails leave=	iterateoptionalleaveList.next();

				org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
				hbt.setFlushModeName("FLUSH_EAGER");
				hbt.setCheckWriteOperations(false);

				hbt.save(leave);
				hbt.refresh(leave);

				//getHibernateTemplate().save(leave);

				saveLeaveHistory(leave);
//////////////////////////////////
				String leaveAppliedBy = leave.getEmpId().getFirstName() + " " + leave.getEmpId().getLastName();
				String toBeApprovedBy = leave.getLeaveApprovedBy().getFirstName() + " " + leave.getLeaveApprovedBy().getLastName();
				String leaveType = "";
				if(leave.getLeaveType().getLeaveType().getLeaveType() != null){
				 leaveType = leave.getLeaveType().getLeaveType().getLeaveType().getDescription();
				}
				
				/*if(leave.getHrMasLeaveTypeNew().getLeaveType().getDescription() != null){
					 leaveType = leave.getHrMasLeaveTypeNew().getLeaveType().getDescription();
					}*/
				
				String subject = "Leave Application/" + leaveType
				   + "/" + leaveAppliedBy
				   + "/" + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getAppliedOn());
				//Subject: Leave Application/Leave type/Emp. Name/Application Date

				//Dear (Title)(first and last name),

				//Emp. Name has applied for (leave type name) from date to date and will be joining back on date.
				//Kindly take up the necessary action by entering into your OMEGA account or by clicking on the link mentioned below.
///////////////////////////////////////////////////////////////////

				emailMessage = "Dear " /*+ leave.getLeaveApprovedBy().getTitle()!=null?leave.getLeaveApprovedBy().getTitle().getTitleName():""*/
				                + " " + toBeApprovedBy
				                + ",\n\n";

				emailMessage = emailMessage + leaveAppliedBy
				       + " has applied";

				if(leave.getHalfDay() != null && !leave.getHalfDay().equals("")) {
					if(leave.getHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leave.getHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a half day " + leaveType + " for " + firstOrSecondHalf + " on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate()) + "";
				} else if (leave.getShortLeaveHalfDay() != null){
					if(leave.getShortLeaveHalfDay().equalsIgnoreCase("f")){
						firstOrSecondHalf = "first half";
					}else if(leave.getShortLeaveHalfDay().equalsIgnoreCase("s")){
						firstOrSecondHalf = "second half";
					}
					fromToDate=" for a " + leaveType + " for " + firstOrSecondHalf + " on "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate()) + "";
				} else {
					fromToDate=" for " + leaveType
						+ " from " + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getFromDate())
						+ " to "
						+ LeaveManagementUtil.convertDateToStringWithoutTime(leave.getToDate());
				}
				emailMessage = emailMessage + fromToDate + " and will be joining back on "
				   + LeaveManagementUtil.convertDateToStringWithoutTime(leave.getJoiningDate())
				   + ".\n"
				   + "Kindly take up the necessary action by entering into " +
				   		"your KSSC account or by clicking on the link mentioned below.\n" +
                  		
                  		"This is an auto generated mail through KSSC. Do not reply.";

				List<String> recipientAddresses = new ArrayList<String>();
				String senderAddresses = new String();
				List<String> ccAddresses = new ArrayList<String>();
				List<String> bccAddresses = new ArrayList<String>();

				if(leave.getLeaveApprovedBy().getEmail() != null  && !leave.getLeaveApprovedBy().getEmail().equals("")
						&& leave.getEmpId().getEmail() != null && !leave.getEmpId().getEmail().equals("")){
					recipientAddresses.add(leave.getLeaveApprovedBy().getEmail());
					senderAddresses = new String(leave.getEmpId().getEmail());

					ccAddresses.add(leave.getEmpId().getEmail());
					//ccAddresses.add("hrhelpdesk@clinirx.com");

					LeaveManagementUtil.sendMailUsingAuthenticator(recipientAddresses, senderAddresses,
							ccAddresses , bccAddresses ,emailMessage, subject);
				}
			}
		}
	}

	public Map getAddOrEdit(MasEmployee user) {
		Map addOrEdit = new HashMap();
		boolean teamSkills = false;
		if(user.getId()!=null)
		{
		List teamSkillsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.UserManager as um where um.ManagerId= '"
						+ user.getId()+ "'");
		if (!teamSkillsList.isEmpty()) {
			teamSkills = true;
		}
		}
		addOrEdit.put("teamSkills", teamSkills);
		return addOrEdit;
	}
	public void submitTypeMaster(HrMasLeaveType hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		saveMasLeaveTypeBackUp(hrMasLeaveType);
	}

	public List getMasLeaveTypeList() {
		List<HrMasLeaveType> masleaveTypeList = new ArrayList<HrMasLeaveType>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrMasLeaveType.class);

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		Date currentDate = HMSUtil
				.convertStringTypeDateToDateType((String) utilMap
						.get("currentDate"));

		crit = crit.add(Restrictions.le("ValidFromDate", currentDate));
		crit = crit.add(Restrictions.ge("ValidToDate", currentDate));

		Order order = Order.desc("Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeList(int leaveType) {

		List<HrMasLeaveType> masleaveTypeList = new ArrayList<HrMasLeaveType>();

		Session session = (Session) getSession();

		Criteria crit = session.createCriteria(HrMasLeaveType.class);

		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));

		Order order = Order.desc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();

		return masleaveTypeList;

	}

	public List getMasLeaveTypeNewList(int leaveType) {

		List<HrMasLeaveTypeNew> masleaveTypeList = new ArrayList<HrMasLeaveTypeNew>();

		Session session = (Session) getSession();

		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);

		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();
		System.out.println("masleaveTypeList in ds===="+masleaveTypeList.size());

		return masleaveTypeList;
	}

	public List getMasLeaveTypeNewMinFromDateForLeaveType(int leaveType) {

		List<String> masleaveTypeList = new ArrayList<String>();

		// masleaveTypeList = getHibernateTemplate().find("select
		// hrmlt.Id,min(hrmlt.ValidFromDate),hrmlt.LeaveType from
		// jkt.hrms.masters.business.HrMasLeaveTypeNew as hrmlt group by
		// hrmlt.LeaveType having hrmlt.LeaveType.Id="+leaveType);

		Session session = (Session) getSession();
		Query query = session.createQuery("select hrmlt.ValidFromDate from jkt.hrms.masters.business.HrMasLeaveTypeNew as hrmlt where hrmlt.LeaveType.Id="+ leaveType);


		/*
		 * crit = crit.setProjection(Projections.projectionList()
		 * .add(Projections.min("ValidFromDate"))
		 * .add(Projections.property("LeaveType.Id"))
		 * .add(Projections.groupProperty("LeaveType.Id")));
		 *
		 * crit = crit.add(Restrictions.le("ValidFromDate",currentDate )); crit
		 * = crit.add(Restrictions.ge("ValidToDate",currentDate ));
		 *
		 * Order order=Order.asc("LeaveType.Id"); crit =
		 * crit.addOrder(order);//add(Restrictions.(lhs, rhs)("EmpId.Id",
		 * userId));
		 */

		masleaveTypeList = query.list();
		System.out.println("masleaveTypeList=="+masleaveTypeList.size());
		return masleaveTypeList;
	}

	@SuppressWarnings("unchecked")
	public List getMasLeaveTypeNewList() {

		List<HrMasLeaveTypeNew> masleaveTypeList = new ArrayList<HrMasLeaveTypeNew>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);

		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		Date currentDate = HMSUtil
				.convertStringTypeDateToDateType((String) utilMap
						.get("currentDate"));

		crit = crit.add(Restrictions.le("ValidFromDate", currentDate));
		crit = crit.add(Restrictions.ge("ValidToDate", currentDate));

		Order order = Order.asc("LeaveType.Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeMediatorList() {

		List<HrMasLeaveTypeMediator> masleaveTypeList = new ArrayList<HrMasLeaveTypeMediator>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrMasLeaveTypeMediator.class);

		crit = crit.createAlias("LeaveType", "lt");
		Order order = Order.asc("lt.LeaveType.Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		masleaveTypeList = crit.list();

		return masleaveTypeList;
	}

	public List getMasLeaveTypeNewForMaxDate(int leaveType, Date maxDate) {

		List<HrMasLeaveTypeNew> masleaveTypeList = new ArrayList<HrMasLeaveTypeNew>();

		Session session = (Session) getSession();

		Criteria crit = session.createCriteria(HrMasLeaveTypeNew.class);

		crit = crit.add(Restrictions.eq("LeaveType.Id", leaveType));
		crit = crit.add(Restrictions.eq("ValidToDate", maxDate));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		masleaveTypeList = crit.list();
		System.out.println("masleaveTypeList=="+masleaveTypeList.size());

		return masleaveTypeList;
	}

	public List getMasLeaveTypeListForId(int id) {

		List<HrMasLeaveTypeNew> masleaveTypeList = new ArrayList<HrMasLeaveTypeNew>();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		HrMasLeaveTypeNew masleaveType = (HrMasLeaveTypeNew) hbt.load(
				HrMasLeaveTypeNew.class, id);

		masleaveTypeList.add(masleaveType);

		return masleaveTypeList;

	}

	public List getEncashableMasLeaveType(int empId) {

		List<HrEmployeeBalanceNew> hrEmployeeBalance = new ArrayList<HrEmployeeBalanceNew>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);

		// utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		// Date currentDate =
		// HMSUtil.convertStringTypeDateToDateType((String)utilMap.get("currentDate"));

		// crit = crit.add(Restrictions.le("ValidFromDate",currentDate ));
		// crit = crit.add(Restrictions.ge("ValidToDate",currentDate ));
		crit = crit.createAlias("LeaveType", "lt");
		crit = crit.createAlias("lt.LeaveType", "lt1");
		// crit = crit.createAlias("lt1.LeaveType", "lt2");
		crit = crit.add(Restrictions.eq("lt1.Encashable", "y"));
		crit = crit.add(Restrictions.eq("Emp.Id", empId));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		hrEmployeeBalance = crit.list();
		return hrEmployeeBalance;

	}

	public void applyForEncashment(HrEncashmentDetails encashmentDetails) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(encashmentDetails);
		hbt.refresh(encashmentDetails);
		saveLeaveEncashmentHistory(encashmentDetails);

		String fromToDate = "";
		String emailMessage = "";

		MasEmployee manager = (MasEmployee) getHibernateTemplate().load(
				MasEmployee.class, encashmentDetails.getApprovedBy().getId());

		HrEncashmentDetails leaveDetails = null;
		List<HrEncashmentDetails> leaveDetailsList = new ArrayList<HrEncashmentDetails>();

		Session session = (Session) getSession();
		leaveDetailsList = getHibernateTemplate().find(
				"from jkt.hrms.masters.business.HrEncashmentDetails as leave where leave.Id='"
						+ encashmentDetails.getId() + "'");
		// leaveDetailsList =
		// session.createCriteria(HrLeaveDetails.class).add(Restrictions.eq("Id",leave.getId())).list();


		leaveDetails = leaveDetailsList.get(0);


		// leaveDetails=
		// (HrLeaveDetails)getHibernateTemplate().load(HrLeaveDetails.class,
		// leave.getId());

		fromToDate = "\nNo. of days : " + encashmentDetails.getLeaveToEncash();

		if (encashmentDetails.getLeaveType().getLeaveType().getId() != null) {
			if (encashmentDetails.getLeaveType().getLeaveType().getLeaveType()
					.getId() == 5) {
				emailMessage = "There is a Encashment leave Request with leave ID "
						+ encashmentDetails.getId()
						+ " applied by "
						+ leaveDetails.getEmp().getFirstName()
						+ " with employee code "
						+ leaveDetails.getEmp().getEmployeeCode()
						+
						// " and base location
						// "+leaveDetails.getEmpId()/*.getLocation().getLocationDesc()
						// */+" waiting for the approval.\n"+
						// "\nLeave ID is : "+leave.getId()+
						"\nLeave Status is : Waiting"
						+ "\nLeave Type is : "
						+ leaveDetails.getLeaveType().getLeaveType()
								.getLeaveType().getDescription() + fromToDate;
			} else if (encashmentDetails.getLeaveType().getLeaveType()
					.getLeaveType().getId() == 6) {
				emailMessage = "There is a Encashment leave Request with leave ID "
						+ encashmentDetails.getId()
						+ " applied by "
						+ leaveDetails.getEmp().getFirstName()
						+ " with employee code "
						+ leaveDetails.getEmp().getEmployeeCode()
						+
						// " and base location
						// "+leaveDetails.getEmpId()/*.getLocation().getLocationDesc()*/
						// +" waiting for the approval.\n"+
						// "\nLeave ID is : "+leave.getId()+
						"\nLeave Status is : Waiting"
						+ "\nLeave Type is : "
						+ leaveDetails.getLeaveType().getLeaveType()
								.getLeaveType().getDescription() + fromToDate;

			} else {
				emailMessage = "There is a Encashment leave Request with leave ID "
						+ encashmentDetails.getId()
						+ " applied by "
						+ leaveDetails.getEmp().getFirstName()
						+ " with employee code "
						+ leaveDetails.getEmp().getEmployeeCode()
						+
						// " and base location
						// "+leaveDetails.getEmpId()/*.getLocation().getLocationDesc()*/
						// +" waiting for the approval.\n"+
						// "\nLeave ID is : "+leave.getId()+
						"\nLeave Status is : Waiting"
						+ "\nLeave Type is : "
						+ leaveDetails.getLeaveType().getLeaveType()
								.getLeaveType().getDescription() + fromToDate;
			}
		}
		String hrEmailId = getHRLeaveEmail();

		// changes
		// String recipientAddresses =
		// manager.getEmail().concat(",").concat(hrEmailId);
		// String recipientAddresses = "nar.xys@jjsfdfdfdf.com";
		// mail
		// LeaveManagementUtil.intranetEmailFunction(recipientAddresses,
		// applierId, emailMessage, "Leave Application");


	}

	public void updateLeaveTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveTypeNew) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveTypeNew);
		hbt.refresh(hrMasLeaveTypeNew);

		// saveMasLeaveTypeBackUp(hrMasLeaveType);

	}

	public void updateTypeMaster(HrMasLeaveType hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		// saveMasLeaveTypeBackUp(hrMasLeaveType);

	}

	public void saveEmployeeLeaveBalance(HrEmployeeBalance employeeBalance) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(employeeBalance);
		hbt.refresh(employeeBalance);
		saveEmployeeLeaveBalanceHistory(employeeBalance);

	}

	public void saveEmployeeLeaveBalanceNew(HrEmployeeBalanceNew employeeBalance) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(employeeBalance);
		hbt.refresh(employeeBalance);
		saveEmployeeLeaveBalanceNewHistory(employeeBalance, "0", "n");

	}

	public void saveEmployeeLeaveBalanceNewHistory(
			HrEmployeeBalanceNew employeeBalance, String noOfWorkingDaysToSave,
			String encashedOrSimple) {

		HrEmployeeBalanceNewHistory employeeBalanceHistory = new HrEmployeeBalanceNewHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		employeeBalanceHistory.setClosingBalance(employeeBalance
				.getClosingBalance());
		// employeeBalanceHistory.setEarned(employeeBalance.getEarned());
		employeeBalanceHistory.setEmp(employeeBalance.getEmp());
		employeeBalanceHistory.setLastChgBy(employeeBalance.getLastChgBy());
		employeeBalanceHistory.setLastChgDate(employeeBalance.getLastChgDate());
		employeeBalanceHistory.setLastChgTime(employeeBalance.getLastChgTime());
		employeeBalanceHistory.setLeaveType(employeeBalance.getLeaveType());
		employeeBalanceHistory.setOpeningBalance(employeeBalance
				.getOpeningBalance());
		employeeBalanceHistory.setStatus(employeeBalance.getStatus());
		employeeBalanceHistory.setTaken(employeeBalance.getTaken());
		employeeBalanceHistory.setNoOfWorkingDays(noOfWorkingDaysToSave);
		employeeBalanceHistory.setEncashedOrSimple(encashedOrSimple);
		hbt.save(employeeBalanceHistory);
		hbt.refresh(employeeBalanceHistory);
	}

	public void saveEmployeeLeaveBalanceHistory(
			HrEmployeeBalance employeeBalance) {

		HrEmployeeBalanceHistory employeeBalanceHistory = new HrEmployeeBalanceHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		employeeBalanceHistory.setClosingBalance(employeeBalance
				.getClosingBalance());
		employeeBalanceHistory.setEarned(employeeBalance.getEarned());
		employeeBalanceHistory.setEmp(employeeBalance.getEmp());
		employeeBalanceHistory.setLastChgBy(employeeBalance.getLastChgBy());
		employeeBalanceHistory.setLastChgDate(employeeBalance.getLastChgDate());
		employeeBalanceHistory.setLastChgTime(employeeBalance.getLastChgTime());
		employeeBalanceHistory.setLeaveType(employeeBalance.getLeaveType());
		employeeBalanceHistory.setOpeningBalance(employeeBalance
				.getOpeningBalance());
		employeeBalanceHistory.setStatus(employeeBalance.getStatus());
		employeeBalanceHistory.setTaken(employeeBalance.getTaken());

		hbt.save(employeeBalanceHistory);
		hbt.refresh(employeeBalanceHistory);
	}

	public void saveMasLeaveTypeBackUp(HrMasLeaveType hrMasLeaveType) {
		HrMasLeaveTypeBackup hrMasLeaveTypeBackup = new HrMasLeaveTypeBackup();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeBackup.setAllowedDays(hrMasLeaveType.getAllowedDays());
		hrMasLeaveTypeBackup.setCrFrdable(hrMasLeaveType.getCrFrdable());
		hrMasLeaveTypeBackup.setEncashable(hrMasLeaveType.getEncashable());
		hrMasLeaveTypeBackup.setEncashablePercent(hrMasLeaveType
				.getEncashablePercent());
		hrMasLeaveTypeBackup.setEnchFormula(hrMasLeaveType.getEnchFormula());
		hrMasLeaveTypeBackup.setLastChgBy(hrMasLeaveType.getLastChgBy());
		hrMasLeaveTypeBackup.setLastChgDate(hrMasLeaveType.getLastChgDate());
		hrMasLeaveTypeBackup.setLastChgTime(hrMasLeaveType.getLastChgTime());
		hrMasLeaveTypeBackup.setLeaveType(hrMasLeaveType.getLeaveType());
		hrMasLeaveTypeBackup
				.setMonthOrYear(hrMasLeaveType.getMonthlyOrYearly());
		hrMasLeaveTypeBackup.setRemarks(hrMasLeaveType.getRemarks());
		hrMasLeaveTypeBackup.setStatus(hrMasLeaveType.getStatus());
		hrMasLeaveTypeBackup
				.setValidFromDate(hrMasLeaveType.getValidFromDate());
		hrMasLeaveTypeBackup.setValidToDate(hrMasLeaveType.getValidToDate());

		hbt.save(hrMasLeaveTypeBackup);
		hbt.refresh(hrMasLeaveTypeBackup);

		saveMasLeaveTypeHistory(hrMasLeaveTypeBackup);
	}

	public void saveMasLeaveTypeHistory(
			HrMasLeaveTypeBackup hrMasLeaveTypeBackup) {
		HrMasLeaveTypeHistory hrMasLeaveTypeHistory = new HrMasLeaveTypeHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeHistory.setAllowedDays(hrMasLeaveTypeBackup
				.getAllowedDays());
		hrMasLeaveTypeHistory.setCrFrdable(hrMasLeaveTypeBackup.getCrFrdable());
		hrMasLeaveTypeHistory.setEncashable(hrMasLeaveTypeBackup
				.getEncashable());
		hrMasLeaveTypeHistory.setEncashablePercent(hrMasLeaveTypeBackup
				.getEncashablePercent());
		hrMasLeaveTypeHistory.setEnchFormula(hrMasLeaveTypeBackup
				.getEnchFormula());
		hrMasLeaveTypeHistory.setLastChgBy(hrMasLeaveTypeBackup.getLastChgBy());
		hrMasLeaveTypeHistory.setLastChgDate(hrMasLeaveTypeBackup
				.getLastChgDate());
		hrMasLeaveTypeHistory.setLastChgTime(hrMasLeaveTypeBackup
				.getLastChgTime());
		hrMasLeaveTypeHistory.setLeaveType(hrMasLeaveTypeBackup.getLeaveType());
		hrMasLeaveTypeHistory.setMonthOrYear(hrMasLeaveTypeBackup
				.getMonthOrYear());
		hrMasLeaveTypeHistory.setRemarks(hrMasLeaveTypeBackup.getRemarks());
		hrMasLeaveTypeHistory.setStatus(hrMasLeaveTypeBackup.getStatus());
		hrMasLeaveTypeHistory.setValidFromDate(hrMasLeaveTypeBackup
				.getValidFromDate());
		hrMasLeaveTypeHistory.setValidToDate(hrMasLeaveTypeBackup
				.getValidToDate());

		hbt.save(hrMasLeaveTypeHistory);
		hbt.refresh(hrMasLeaveTypeHistory);
	}

	public List<HrEmployeeBalanceNew> getLeaveBalance(int empId,
			String leaveType) {

		List<HrEmployeeBalanceNew> leaveBal = new ArrayList<HrEmployeeBalanceNew>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrEmployeeBalanceNew.class);

		if (leaveType != null && !leaveType.trim().equals("")) {
			crit = crit.add(Restrictions.eq("LeaveType.Id",
					Integer.parseInt(leaveType)));
		}

		crit = crit.add(Restrictions.eq("Emp.Id", empId));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);// add(Restrictions.(lhs, rhs)("EmpId.Id",
		// userId));

		leaveBal = crit.list();

		return leaveBal;
	}

	public void submitTypeMasterNew(HrMasLeaveTypeNew hrMasLeaveType) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveType);
		hbt.refresh(hrMasLeaveType);

		// saveMasLeaveTypeBackUp(hrMasLeaveType);
	}

	public void saveToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.save(hrMasLeaveTypeMediator);
		hbt.refresh(hrMasLeaveTypeMediator);

		// save to history
		saveToHrMasLeaveTypeMediatorHistory(hrMasLeaveTypeMediator);
	}

	public void updateToHrMasLeaveTypeMediator(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrMasLeaveTypeMediator);
		hbt.refresh(hrMasLeaveTypeMediator);

		saveToHrMasLeaveTypeMediatorHistory(hrMasLeaveTypeMediator);
	}

	public void saveToHrMasLeaveTypeMediatorHistory(
			HrMasLeaveTypeMediator hrMasLeaveTypeMediator) {
		HrMasLeaveTypeMediatorHistory hrMasLeaveTypeMediatorHistory = new HrMasLeaveTypeMediatorHistory();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hrMasLeaveTypeMediatorHistory.setLeaveType(hrMasLeaveTypeMediator
				.getLeaveType());

		hbt.save(hrMasLeaveTypeMediatorHistory);
		hbt.refresh(hrMasLeaveTypeMediatorHistory);

	}

	public void updateLeavePolicy() {
		int hrMasLeaveTypeNewId = 0;
		String tomorrow = "";
		Calendar cal = Calendar.getInstance();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, +1);
		tomorrow = dateFormat.format(cal.getTime());

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		HrMasLeaveTypeNew hrMasLeaveTypeNew = new HrMasLeaveTypeNew();
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();

		hrMasLeaveTypeMediatorList = hbt
				.find("from HrMasLeaveTypeMediator as hmt where hmt.LeaveType.ValidToDate='"
						+ HMSUtil.getDateFormat(new Date(), "yyyy-MM-dd") + "'");
		if (hrMasLeaveTypeMediatorList != null
				&& hrMasLeaveTypeMediatorList.size() > 0) {
			for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator : hrMasLeaveTypeMediatorList) {
				int mediatorId = hrMasLeaveTypeMediator.getId();
				hrMasLeaveTypeNewId = hrMasLeaveTypeMediator.getLeaveType()
						.getId();

				HrMasLeaveTypeNew hrMasLeaveTypeNewobj = hrMasLeaveTypeMediator
						.getLeaveType();

				if (hrMasLeaveTypeNewobj.getStatus().equalsIgnoreCase("y")) {
					hrMasLeaveTypeNewobj.setStatus("n");
				}
				// leaveType=hrMasLeaveTypeNewobj.getLeaveType();
				int leaveTypeId = 0;
				leaveTypeId = hrMasLeaveTypeNewobj.getLeaveType().getId();
				hbt.update(hrMasLeaveTypeNewobj);
				hbt.refresh(hrMasLeaveTypeNewobj);

				HrMasLeaveTypeNew hrMasLeaveTypeNewFresh = (HrMasLeaveTypeNew) hbt
						.find("from HrMasLeaveTypeNew as leaveType where leaveType.ValidFromDate='"
								+ tomorrow
								+ "' and leaveType.LeaveType.Id='"
								+ leaveTypeId + "'").get(0);
				int noOfDaysAllowed = 0;
				String crFwd = "";
				String mnthORyear = "";

				noOfDaysAllowed = Integer.valueOf(hrMasLeaveTypeNewFresh
						.getAllowedDays());
				mnthORyear = hrMasLeaveTypeNewFresh.getMonthlyOrYearly();
				crFwd = hrMasLeaveTypeNewFresh.getCrFrdable();

				if (hrMasLeaveTypeNewFresh.getStatus().equalsIgnoreCase("n")) {
					hrMasLeaveTypeNewFresh.setStatus("y");
				}
				hrMasLeaveTypeMediator.setLeaveType(hrMasLeaveTypeNewFresh);
				hbt.update(hrMasLeaveTypeMediator);
				hbt.refresh(hrMasLeaveTypeMediator);
				List<HrEmployeeBalanceNew> hrEmployeeBalanceNewList = hbt
						.find("from HrEmployeeBalanceNew as empBal where empBal.LeaveType.Id='"
								+ mediatorId + "'");
				for (HrEmployeeBalanceNew hrEmployeeBalanceNew : hrEmployeeBalanceNewList) {
					Date date = new Date();
					// int
					// sexid=hrEmployeeBalanceNew.getEmp().getEmployeePersonalDetails().getGender().getId();
					// int
					// leaveid=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId();

					double closingBal = 0;
					double openingBal = 0;
					double earn = 0;
					double taken = 0;
					double newOpeningBal = 0;
					// openingBal = noOfDaysAllowed;
					// if(((sexid==2) &&
					// (leaveid==3))||((sexid==3)&&(leaveid==4)))
					// {

					// }else{
					if (mnthORyear.equalsIgnoreCase("m")) {
						if ((date.getMonth() == 12) && (date.getDay() == 31)) {
							earn = noOfDaysAllowed;// wrong calculation
						} else {
							earn = noOfDaysAllowed;
						}
					} else if (mnthORyear.equalsIgnoreCase("y")) {
						earn = noOfDaysAllowed / 12;
					}

					if (hrEmployeeBalanceNew.getClosingBalance() != null) {
						closingBal = Double.valueOf(hrEmployeeBalanceNew
								.getClosingBalance());
					} else {
						closingBal = 0;
					}

					// if(hrEmployeeBalanceNew.getOpeningBalance()!=null)
					// {
					// openingBal
					// =Double.valueOf(hrEmployeeBalanceNew.getOpeningBalance());
					// }
					// else
					// {
					// openingBal =0;
					// }
					if (hrEmployeeBalanceNew.getTaken() != null) {
						taken = Double.valueOf(hrEmployeeBalanceNew.getTaken());
					} else {
						taken = 0;
					}

					if (crFwd.equalsIgnoreCase("y")) {
						if ((date.getMonth() == 12) && (date.getDay() == 31)) {
							newOpeningBal = 0;
							closingBal = 0;
							earn = 0;
						} else {
							newOpeningBal = closingBal;
						}
					} else {
						newOpeningBal = openingBal;
					}
					// }
					hrEmployeeBalanceNew.setOpeningBalance(new DecimalFormat(
							"0.##").format((double) newOpeningBal));
					hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat(
							"0.##")
							.format((double) (newOpeningBal + earn - taken)));

					hrEmployeeBalanceNew.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(currentDate));
					hrEmployeeBalanceNew.setLastChgTime(time);
					hbt.update(hrEmployeeBalanceNew);
					hbt.refresh(hrEmployeeBalanceNew);
				}
			}
		}
	}

	public void updateLeaveBalanceMonthly() {
		// int hrMasLeaveTypeNewId=0;
		Session session = getSession();

		HrMasLeave leaveType = new HrMasLeave();
		String tomorrow = "";
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, +1);
		tomorrow = dateFormat.format(cal.getTime());

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		int childrenCount = 0;
		HrMasLeaveTypeNew hrMasLeaveTypeNew = new HrMasLeaveTypeNew();
		List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = new ArrayList<HrMasLeaveTypeMediator>();

		hrMasLeaveTypeMediatorList = session
				.createCriteria(HrMasLeaveTypeMediator.class)
				.createAlias("LeaveType", "lt")
				.add(Restrictions.eq("lt.Status", "y")).list();

		if (hrMasLeaveTypeMediatorList != null
				&& hrMasLeaveTypeMediatorList.size() > 0) {
			for (HrMasLeaveTypeMediator hrMasLeaveTypeMediator : hrMasLeaveTypeMediatorList) {

				int mediatorId = hrMasLeaveTypeMediator.getId();
				// hrMasLeaveTypeNewId=hrMasLeaveTypeMediator.getLeaveType().getId();

				// HrMasLeaveTypeNew hrMasLeaveTypeNewobj =
				// (HrMasLeaveTypeNew)hbt.get(HrMasLeaveTypeNew.class,hrMasLeaveTypeNewId);
				HrMasLeaveTypeNew hrMasLeaveTypeNewobj = hrMasLeaveTypeMediator
						.getLeaveType();
				leaveType = hrMasLeaveTypeNewobj.getLeaveType();
				int leaveTypeId = 0;
				leaveTypeId = leaveType.getId();

				double noOfDaysAllowed = 0;
				String crFwd = "";
				String mnthORyear = "";

				noOfDaysAllowed = Double.valueOf(hrMasLeaveTypeNewobj
						.getAllowedDays());
				mnthORyear = hrMasLeaveTypeNewobj.getMonthlyOrYearly();
				crFwd = hrMasLeaveTypeNewobj.getCrFrdable();

				List<HrEmployeeBalanceNew> hrEmployeeBalanceNewList = hbt
						.find("from HrEmployeeBalanceNew as empBal where empBal.LeaveType.Id='"
								+ mediatorId + "' and empBal.Emp.Id='192'");
				if (hrEmployeeBalanceNewList.size() > 0) {
					for (HrEmployeeBalanceNew hrEmployeeBalanceNew : hrEmployeeBalanceNewList) {

						List<Integer> empDependents = new ArrayList<Integer>();
						empDependents = session
								.createCriteria(MasEmployeeDependent.class)
								.add(Restrictions.eq("Employee.Id",
										hrEmployeeBalanceNew.getEmp().getId()))
								.createAlias("Relation", "rel")
								.add(Restrictions.or(Restrictions.eq(
										"rel.RelationCode", "03"), Restrictions
										.eq("rel.RelationCode", "04")))
								.setProjection(
										Projections
												.projectionList()
												.add(Projections
														.count("rel.RelationCode")))
								.list();

						int sexid = 0;
						if (hrEmployeeBalanceNew.getEmp()
								.getPersonalDetails() != null) {
							sexid = hrEmployeeBalanceNew.getEmp()
									.getPersonalDetails().getGender()
									.getId();
						}

						// int
						// leaveid=hrEmployeeBalanceNew.getLeaveType().getLeaveType().getLeaveType().getId();

						// double closingBal=0;
						double openingBal = 0;
						double earn = 0;
						// double taken=0;
						double takenYearly = 0;
						Date date = new Date();
						double newOpeningBal = 0;
						double newClosingBal = 0;
						String alreadyAvailed = "";
						childrenCount = empDependents.get(0);

						/*
						 * Calendar calendar=Calendar.getInstance(); int
						 * currentYear = calendar.get(Calendar.YEAR);
						 *
						 * Date empJoiningDate =
						 * hrEmployeeBalanceNew.getEmp().getJoinDate(); Calendar
						 * calEmpJoin = Calendar.getInstance();
						 * calEmpJoin.setTime(empJoiningDate); int yearOfJoining
						 * = calEmpJoin.get(Calendar.YEAR);
						 */

						if (((sexid == 2) && (leaveTypeId == 4))
								|| ((sexid == 3) && (leaveTypeId == 3))) {
							if ((date.getMonth() == 12)
									&& (date.getDay() == 31)) {
								if (childrenCount <= 2) {
									hrEmployeeBalanceNew
											.setEarned(new DecimalFormat("0.##")
													.format((double) noOfDaysAllowed));
									hrEmployeeBalanceNew
											.setClosingBalance(new DecimalFormat(
													"0.##")
													.format((double) noOfDaysAllowed));
								} else {
									hrEmployeeBalanceNew
											.setEarned(new DecimalFormat("0.##")
													.format((double) 0));
									hrEmployeeBalanceNew
											.setClosingBalance(new DecimalFormat(
													"0.##").format((double) 0));
								}
								hrEmployeeBalanceNew.setBalanceAdjustedBy("0");
								hrEmployeeBalanceNew.setTotalLeaveTaken("0");
							} else {
								if (alreadyAvailed.equals("y")) {
									hrEmployeeBalanceNew
											.setEarned(new DecimalFormat("0.##")
													.format((double) 0));
									hrEmployeeBalanceNew
											.setClosingBalance(new DecimalFormat(
													"0.##").format((double) 0));
								}
							}
							hrEmployeeBalanceNew
									.setOpeningBalance(new DecimalFormat("0.##")
											.format((double) 0));
							hrEmployeeBalanceNew.setTaken(new DecimalFormat(
									"0.##").format((double) 0));
							hrEmployeeBalanceNew
									.setLastChgDate(HMSUtil
											.convertStringTypeDateToDateType(currentDate));
							hrEmployeeBalanceNew.setLastChgTime(time);
						} else {
							if (hrEmployeeBalanceNew.getOpeningBalance() != null) {
								openingBal = Double
										.valueOf(hrEmployeeBalanceNew
												.getOpeningBalance());
							} else {
								openingBal = 0;
							}
							if (mnthORyear.equalsIgnoreCase("m")) {
								earn = new Double(noOfDaysAllowed);
								if ((date.getMonth() == 12)
										&& (date.getDay() == 31)) {
									if (crFwd.equalsIgnoreCase("y")) {
										newOpeningBal = (Double
												.valueOf(hrEmployeeBalanceNew
														.getEarned()) + openingBal)
												- Double.valueOf(hrEmployeeBalanceNew
														.getTaken());
										newClosingBal = newOpeningBal + earn;
									} else {
										newOpeningBal = 0;
										newClosingBal = earn;
									}
									hrEmployeeBalanceNew
											.setBalanceAdjustedBy("0");
									hrEmployeeBalanceNew
											.setTotalLeaveTaken("0");
									// taken=0;
								} else {
									newOpeningBal = (Double
											.valueOf(hrEmployeeBalanceNew
													.getEarned()) + openingBal)
											- Double.valueOf(hrEmployeeBalanceNew
													.getTaken());

									newClosingBal = newOpeningBal + earn;
									// taken=0;
								}
							} else if (mnthORyear.equalsIgnoreCase("y")) {
								earn = new Double(noOfDaysAllowed / 12.0);
								if ((date.getMonth() == 12)
										&& (date.getDay() == 31)) {
									if (crFwd.equalsIgnoreCase("y")) {
										newOpeningBal = (Double
												.valueOf(hrEmployeeBalanceNew
														.getEarned()) + openingBal)
												- Double.valueOf(hrEmployeeBalanceNew
														.getTaken());
										newClosingBal = newOpeningBal + earn;
									} else {
										newOpeningBal = 0;
										newClosingBal = earn;
									}
									// taken=0;
									hrEmployeeBalanceNew
											.setBalanceAdjustedBy("0");
									hrEmployeeBalanceNew
											.setTotalLeaveTaken("0");
								} else {
									newOpeningBal = (Double
											.valueOf(hrEmployeeBalanceNew
													.getEarned()) + openingBal)
											- Double.valueOf(hrEmployeeBalanceNew
													.getTaken());

									newClosingBal = newOpeningBal + earn;
									// taken=0;
								}
							}

							/*
							 * if(hrEmployeeBalanceNew.getClosingBalance()!=null)
							 * { closingBal
							 * =Double.valueOf(hrEmployeeBalanceNew.
							 * getClosingBalance()); } else { closingBal =0; }
							 *
							 * if(crFwd.equalsIgnoreCase("y")||(closingBal<0)) {
							 * if((date.getMonth()== 12) && (date.getDay()==31)
							 * ) { newOpeningBal=0; closingBal=0; }else{
							 * newOpeningBal = openingBal+closingBal; } }else{
							 * newOpeningBal = openingBal; }
							 */
							if (leaveTypeId == 20) {
								newOpeningBal = 0;
								// taken = 0;
								// takenYearly = 0;
								earn = new Double(noOfDaysAllowed);
								newClosingBal = new Double(noOfDaysAllowed);
								hrEmployeeBalanceNew.setBalanceAdjustedBy("0");
							}
							hrEmployeeBalanceNew
									.setOpeningBalance(new DecimalFormat("0.##")
											.format((double) newOpeningBal));
							// hrEmployeeBalanceNew.setClosingBalance(new
							// DecimalFormat("0.##").format((double)(newOpeningBal+earn-taken)));
							hrEmployeeBalanceNew
									.setClosingBalance(new DecimalFormat("0.##")
											.format((double) (newClosingBal)));
							hrEmployeeBalanceNew.setTaken(new DecimalFormat(
									"0.##").format("0"));
							hrEmployeeBalanceNew.setEarned(new DecimalFormat(
									"0.##").format((double) earn));
							hrEmployeeBalanceNew
									.setLastChgDate(HMSUtil
											.convertStringTypeDateToDateType(currentDate));
							hrEmployeeBalanceNew.setLastChgTime(time);
						}
						hbt.update(hrEmployeeBalanceNew);
						hbt.refresh(hrEmployeeBalanceNew);
					}
				} else {
					List<MasEmployee> masEmployeeList = hbt
							.find("from MasEmployee as emp where emp.Status='y'");
					for (MasEmployee masEmployee : masEmployeeList) {

						List<Integer> empDependents = new ArrayList<Integer>();
						empDependents = session
								.createCriteria(MasEmployeeDependent.class)
								.add(Restrictions.eq("Employee.Id",
										masEmployee.getId()))
								.createAlias("Relation", "rel")
								.add(Restrictions.or(Restrictions.eq(
										"rel.RelationCode", "03"), Restrictions
										.eq("rel.RelationCode", "04")))
								.setProjection(
										Projections
												.projectionList()
												.add(Projections
														.count("rel.RelationCode")))
								.list();

						childrenCount = empDependents.get(0);
						int joinDate = new Integer(
								(HMSUtil.convertDateToStringTypeDate(masEmployee
										.getJoinDate())).substring(0, 2));
						// int joinMonth= new Integer(
						// (HMSUtil.convertDateToStringTypeDate(masEmployee.getJoinDate())).substring(4,
						// 7));
						// int joinYear= new Integer(
						// (HMSUtil.convertDateToStringTypeDate(masEmployee.getJoinDate())).substring(4,
						// 7));
						HrEmployeeBalanceNew newObj = new HrEmployeeBalanceNew();
						double closingBal = 0;
						double openingBal = 0;
						double earn = 0;
						double taken = 0;
						Date date = new Date();
						int sexid = masEmployee.getPersonalDetails()
								.getGender().getId();
						// openingBal = noOfDaysAllowed;
						if (((sexid == 2) && (leaveTypeId == 3))
								|| ((sexid == 3) && (leaveTypeId == 4))) {

							HrMasLeaveTypeMediator mediator = new HrMasLeaveTypeMediator();
							mediator.setId(mediatorId);
							newObj.setLeaveType(mediator);
							newObj.setEmp(masEmployee);
							newObj.setTaken("0");
							newObj.setTotalLeaveTaken("0");
							newObj.setOpeningBalance(new DecimalFormat("0.##")
									.format((double) 0));
							newObj.setClosingBalance(new DecimalFormat("0.##")
									.format((double) (noOfDaysAllowed)));
							if (childrenCount <= 2) {
								newObj.setAlreadyAvailedPatMat("n");
								newObj.setEarned(new DecimalFormat("0.##")
										.format((double) noOfDaysAllowed));
							} else {
								newObj.setEarned(new DecimalFormat("0.##")
										.format((double) 0));
							}
							newObj.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(currentDate));
							newObj.setLastChgTime(time);
							newObj.setStatus("y");
							newObj.setBalanceAdjustedBy("0");
						} else {
							if (mnthORyear.equalsIgnoreCase("m")) {
								// if((date.getMonth()== 12) &&
								// (date.getDay()==31) ) {
								// earn = 0;
								// taken=0;
								// }else{
								earn = noOfDaysAllowed;
								closingBal = noOfDaysAllowed;
								taken = 0;
								// }
							} else if (mnthORyear.equalsIgnoreCase("y")) {
								// if((date.getMonth()== 12) &&
								// (date.getDay()==31) ) {
								// earn = 0;
								// taken=0;
								// }else{
								earn = noOfDaysAllowed / 12;
								closingBal = noOfDaysAllowed / 12;
								taken = 0;
								// }//closingBal= openingBal;
							}

							/*
							 * double newOpeningBal= 0;
							 * if(crFwd.equalsIgnoreCase("y")||(closingBal < 0))
							 * { if((date.getMonth()== 12) &&
							 * (date.getDay()==31) ) { newOpeningBal = 0;
							 * closingBal=0; }else{ newOpeningBal =
							 * openingBal+closingBal; } }else{
							 * if((date.getMonth()== 12) && (date.getDay()==31)
							 * ) { newOpeningBal = 0; closingBal=0; }else{
							 * newOpeningBal = openingBal; } }
							 */
							HrMasLeaveTypeMediator mediator = new HrMasLeaveTypeMediator();
							mediator.setId(mediatorId);
							newObj.setLeaveType(mediator);
							newObj.setEmp(masEmployee);
							newObj.setOpeningBalance(new DecimalFormat("0.##")
									.format((double) openingBal));
							newObj.setClosingBalance(new DecimalFormat("0.##")
									.format((double) (closingBal)));
							Date today = new Date();
							if ((masEmployee.getJoinDate().getYear() == today
									.getYear())
									&& (masEmployee.getJoinDate().getMonth() == today
											.getMonth())) {
								if (joinDate <= 15) {
									newObj.setEarned(new DecimalFormat("0.##")
											.format((double) earn));
								} else {
									earn = 0;
									newObj.setEarned(new DecimalFormat("0.##")
											.format((double) earn));
								}
							}
							newObj.setTaken(new DecimalFormat("0.##")
									.format((double) taken));
							newObj.setTotalLeaveTaken("0");
							newObj.setLastChgDate(HMSUtil
									.convertStringTypeDateToDateType(currentDate));
							newObj.setLastChgTime(time);
							newObj.setBalanceAdjustedBy("0");
							newObj.setStatus("y");
						}
						hbt.save(newObj);
						hbt.refresh(newObj);
					}
				}
			}
		}
	}

	public HrMasLeaveTypeNew getCurrentPolicy(int hrMasLeaveTypeMediatorID) {
		Session session = getSession();
		HrMasLeaveTypeNew hrMasLeaveTypeNew = new HrMasLeaveTypeNew();
		try {
			HrMasLeave hrMasLeave;

			HrMasLeaveTypeMediator hrMasLeaveTypeMediator = (HrMasLeaveTypeMediator) session
					.load(HrMasLeaveTypeMediator.class,
							hrMasLeaveTypeMediatorID);
			hrMasLeaveTypeNew = (HrMasLeaveTypeNew) session.load(
					HrMasLeaveTypeNew.class, hrMasLeaveTypeMediator
							.getLeaveType().getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return hrMasLeaveTypeNew;
	}

	public Map<String, Object> getConnectionForReport() {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Connection con = session.connection();
		map.put("con", con);
		return map;
	}

	/*public HrEmployeePersonelDetails getEmpPersonalDeatil(int uid) {
		HrEmployeePersonelDetails hrEmployeePersonelDetails = new HrEmployeePersonelDetails();
		Session session = (Session) getSession();
		hrEmployeePersonelDetails = (HrEmployeePersonelDetails) session
				.createCriteria(HrEmployeePersonelDetails.class)
				.add(Restrictions.eq("Id", uid)).uniqueResult();

		return hrEmployeePersonelDetails;
	}*/
	
	public Map<String, Object> getEmpPersonalDeatil(int uid)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<Users>usersList = new ArrayList<Users>();
		//HrEmployeePersonelDetails hrEmployeePersonelDetails = new HrEmployeePersonelDetails();
		Session session = (Session)getSession();
		///hrEmployeePersonelDetails = (HrEmployeePersonelDetails)session.createCriteria(HrEmployeePersonelDetails.class).add(Restrictions.eq("Id", uid)).uniqueResult();
		usersList = session.createCriteria(Users.class).createAlias("Employee", "emp").createAlias("emp.PersonalDetails", "detail").add(Restrictions.idEq(uid)).list();
		Date dob = null;
		Date anniversery = null;
		if(usersList.size()>0){
			for(Users users : usersList){
				dob =users.getEmployee().getPersonalDetails().getDateOfBirth();
				anniversery =users.getEmployee().getPersonalDetails().getMarriageDate();
				map.put("dob", dob);
				map.put("anniversery", anniversery);
				
			}
		}
		return map ;
	}

	public Map<String, Object> getLeaveListJsp(Map<String, Object> generalMap) {

		List<HrMasLeaveTypeMediator> leaveTypeList = new ArrayList<HrMasLeaveTypeMediator>();
		int employeeId = 0;
		String halfday = "";
		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		if (generalMap.get("halfday") != null) {
			halfday = (String) generalMap.get("halfday");
		}
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		if (halfday.equalsIgnoreCase("n")) {
			Criteria crit = session
					.createCriteria(HrMasLeaveTypeMediator.class);
			crit = crit.createAlias("LeaveType", "lt").add(
					Restrictions.eq("lt.HalfDayAllow", halfday));
			Order order = Order.asc("lt.LeaveType.Id");
			crit = crit.addOrder(order);// add(Restrictions.(lhs,
			// rhs)("EmpId.Id", userId));
			leaveTypeList = crit.list();

		} else {
			leaveTypeList = getMasLeaveTypeMediatorList();
		}

		List<Integer> empDependents = new ArrayList<Integer>();
		empDependents = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Employee.Id", employeeId))
				.createAlias("Relation", "rel")
				.add(Restrictions.or(Restrictions.eq("rel.RelationCode", "03"),
						Restrictions.eq("rel.RelationCode", "04")))
				.setProjection(
						Projections.projectionList().add(
								Projections.count("rel.RelationCode"))).list();

		List<Object> empPatMatAvailedOrNot = new ArrayList<Object>();
		empPatMatAvailedOrNot = session
				.createCriteria(HrEmployeeBalanceNew.class)
				.add(Restrictions.eq("Emp.Id", employeeId))
				.createAlias("LeaveType", "med")
				.createAlias("med.LeaveType", "leaveNew")
				.createAlias("leaveNew.LeaveType", "actLeaveType")
				.add(Restrictions.or(Restrictions.eq("actLeaveType.Id", 3),
						Restrictions.eq("actLeaveType.Id", 4)))
				.setProjection(
						Projections
								.projectionList()
								.add(Projections
										.property("AlreadyAvailedPatMat"))
								.add(Projections.property("actLeaveType.Id")))
				.addOrder(Order.asc("actLeaveType.Id")).list();

		utilMap.put("empDependents", empDependents);
		utilMap.put("empPatMatAvailedOrNot", empPatMatAvailedOrNot);
		utilMap.put("leaveTypeList", leaveTypeList);

		return utilMap;
	}

	public Map<String, Object> getUserDetails(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId = 0;
		int deptId=0;
		if (generalMap.get("employeeId") != null) {
			
			employeeId = (Integer) generalMap.get("employeeId");
		}
		if (generalMap.get("deptId") != null) {
			deptId = (Integer) generalMap.get("deptId");
		}
		Session session = (Session) getSession();
		List<Integer> empDependents = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

		Criteria crit = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Employee.Id", employeeId))
				.createAlias("Relation", "rel")
				.add(Restrictions.or(Restrictions.eq("rel.RelationCode", "03"),
						Restrictions.eq("rel.RelationCode", "04")))
				.setProjection(
						Projections.projectionList().add(
								Projections.count("rel.RelationCode")));
		empDependents = crit.list();

		List<Object> empMatAvailedOrNot = new ArrayList<Object>();
		empMatAvailedOrNot = session
				.createCriteria(HrEmployeeBalanceNew.class)
				.add(Restrictions.eq("Emp.Id", employeeId))
				.createAlias("LeaveType", "med")
				.createAlias("med.LeaveType", "leaveNew")
				.createAlias("leaveNew.LeaveType", "actLeaveType")
				.add(Restrictions.eq("actLeaveType.Id", 3))
				.setProjection(
						Projections.projectionList().add(
								Projections.property("AlreadyAvailedPatMat")))
				.list();

		List<Object> empPatAvailedOrNot = new ArrayList<Object>();
		empPatAvailedOrNot = session
				.createCriteria(HrEmployeeBalanceNew.class)
				.add(Restrictions.eq("Emp.Id", employeeId))
				.createAlias("LeaveType", "med")
				.createAlias("med.LeaveType", "leaveNew")
				.createAlias("leaveNew.LeaveType", "actLeaveType")
				.add(Restrictions.eq("actLeaveType.Id", 4))
				.setProjection(
						Projections.projectionList().add(
								Projections.property("AlreadyAvailedPatMat")))
				.list();

		masDepartmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y")).list();
		MasEmployee me = (MasEmployee)session.load(MasEmployee.class,employeeId);
				
	
		List desigList = new ArrayList();
		List<MasEmployee> approverList = new ArrayList<MasEmployee>();
		
		
		if(me.getRank()!=null && me.getRank().getDesignationOrder() != null && ! me.getRank().getDesignationOrder().equals("")){
		  int designation_order =me.getRank().getDesignationOrder();
		
		 // LogicalExpression exp =  Restrictions.or(Restrictions.eq("DesignationOrder", (designation_order-1)), Restrictions.eq("DesignationOrder", (designation_order-2)));
		  List al = new ArrayList();
		  
		  al.add((designation_order-1)); 
		 // al.add((designation_order-2)); 
		 // al.add((designation_order-3));

		 
		  desigList = getSession().createCriteria(MasRank.class).add(Restrictions.eq("Status","y").ignoreCase()).add(Restrictions.in("DesignationOrder",al))
				  					.setProjection(Projections.projectionList().add(Projections.groupProperty("Id"))).list();
		 // System.out.println("desigList = "+desigList.size());
		  if(desigList.size()>0){
			  approverList = getSession().createCriteria(MasEmployee.class).add(Restrictions.in("Rank.Id", desigList)).add(Restrictions.eq("Department.Id", deptId)).list();
		  }
		}
		map.put("masDepartmentList", masDepartmentList);
		map.put("empDependents", empDependents);
		map.put("empPatAvailedOrNot", empPatAvailedOrNot);
		map.put("empMatAvailedOrNot", empMatAvailedOrNot);
		map.put("approverList", approverList);

		return map;
	}

	public Map<String, Object> getPersonalDetailsPatMatDetails(
			Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId = 0;

		if (generalMap.get("employeeId") != null) {
			employeeId = (Integer) generalMap.get("employeeId");
		}
		Session session = (Session) getSession();
		List<Integer> empDependents = new ArrayList<Integer>();
		List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();

		Criteria crit = session
				.createCriteria(MasEmployeeDependent.class)
				.add(Restrictions.eq("Employee.Id", employeeId))
				.createAlias("Relation", "rel")
				.add(Restrictions.or(Restrictions.eq("rel.RelationCode", "03"),
						Restrictions.eq("rel.RelationCode", "04")))
				.setProjection(
						Projections.projectionList().add(
								Projections.count("rel.RelationCode")));

		empDependents = crit.list();

		List<Object> empMatAvailedOrNot = new ArrayList<Object>();
		empMatAvailedOrNot = session
				.createCriteria(HrEmployeeBalanceNew.class)
				.add(Restrictions.eq("Emp.Id", employeeId))
				.createAlias("LeaveType", "med")
				.createAlias("med.LeaveType", "leaveNew")
				.createAlias("leaveNew.LeaveType", "actLeaveType")
				.add(Restrictions.eq("actLeaveType.Id", 3))
				.setProjection(
						Projections.projectionList().add(
								Projections.property("AlreadyAvailedPatMat")))
				.list();

		List<Object> empPatAvailedOrNot = new ArrayList<Object>();
		empPatAvailedOrNot = session
				.createCriteria(HrEmployeeBalanceNew.class)
				.add(Restrictions.eq("Emp.Id", employeeId))
				.createAlias("LeaveType", "med")
				.createAlias("med.LeaveType", "leaveNew")
				.createAlias("leaveNew.LeaveType", "actLeaveType")
				.add(Restrictions.eq("actLeaveType.Id", 4))
				.setProjection(
						Projections.projectionList().add(
								Projections.property("AlreadyAvailedPatMat")))
				.list();

		map.put("empDependents", empDependents);
		map.put("empMatAvailedOrNot", empMatAvailedOrNot);
		map.put("empPatAvailedOrNot", empPatAvailedOrNot);
		return map;
	}

	public Map<String, Object> showEmpForDept(Map<String, Object> generalMap) {

		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;

		if (generalMap.get("departmentId") != null) {
			departmentId = (Integer) generalMap.get("departmentId");
		}
		Session session = (Session) getSession();
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		Criteria crit = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Department.Id", departmentId))
				.add(Restrictions.eq("Status", "y"));

		masEmployeeList = crit.list();
		map.put("masEmployeeList", masEmployeeList);
		return map;
	}

	// Start Leave Master Added by Ramdular 14/04/2011 ++++++++++++++++++++++++


	public Map<String, Object> showLeaveJsp() {
		Map<String,Object>  map=new HashMap<String,Object>();
		List<HrMasLeave>  masLeaveList=new ArrayList<HrMasLeave>();
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		masLeaveList=getHibernateTemplate().find( "from jkt.hrms.masters.business.HrMasLeave ");
		hospitalList=getHibernateTemplate().find( "from jkt.hms.masters.business.MasHospital as mh where mh.Status = 'y'");
	
		map.put("masLeaveList",masLeaveList);
		map.put("hospitalList",hospitalList);
		
		return map;
	}
	public Map<String, Object> addLeave(HrMasLeave hrMasLeave) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>(); 
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String description = hrMasLeave.getDescription();
		existingDescriptionList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasLeave as msc where msc.Description = '"+description+"'");
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		if(existingDescriptionList.size()>0){
			message = "Record already exist...";
		}else{
			hbt.save(hrMasLeave);
			message = "Record save successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class).add(Restrictions.eq("Status", "y")).list();
		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> editLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> existingDescriptionList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>(); 
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		Session session = (Session)getSession();
		int leaveId = 0;
		if (generalMap.get("leaveId")!= null) {
			leaveId = (Integer)generalMap.get("leaveId"); 
		}
		int hospitalId=0;
		if (generalMap.get("hospitalId")!= null) {
			hospitalId = (Integer)generalMap.get("hospitalId"); 
		}
		String description = "";
		if (generalMap.get("description")!= null) {
			description = (String)generalMap.get("description"); 
		}
		int changedBy =0;
		if (generalMap.get("changedBy")!= null) {
			changedBy = (Integer)generalMap.get("changedBy"); 
		}	
	
		Date currentDate = null; 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLeave hrMasLeave = (HrMasLeave)hbt.load(HrMasLeave.class, leaveId);
		hrMasLeave.setDescription(description);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrMasLeave.setCompany(masHospital);
		
		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		existingDescriptionList = getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasLeave as msc where msc.Description = '"+description+"' and msc.Id != '"+leaveId+"'");
		masLeaveList = session.createCriteria(HrMasLeave.class).add(Restrictions.eq("Status", "y")).list();
		hospitalList = session.createCriteria(MasHospital.class).add(Restrictions.eq("Status", "y")).list();
		String message = "";
		if(existingDescriptionList.size()>0){
			message = "Record already exist";
		}else{
			hbt.update(hrMasLeave);
			message = "Record update successfully !!";
		}
		
		map.put("masLeaveList", masLeaveList);
		map.put("existingDescriptionList", existingDescriptionList);
		map.put("hospitalList", hospitalList);
		map.put("message", message);
		return map;
		}

	public Map<String, Object> searchLeave(String description) {
		List<HrMasLeave> masLeaveList=new ArrayList<HrMasLeave>();
		Map<String,Object>  leaveFieldsMap = new HashMap<String,Object>();
		try{
			if((description !=null)){
				
				masLeaveList=getHibernateTemplate().find("from jkt.hrms.masters.business.HrMasLeave imc where imc.Description like '"+ description+"%' order by imc.Description");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
			leaveFieldsMap.put("masLeaveList",masLeaveList);
		return leaveFieldsMap;	
	}
	public Map<String, Object> deleteLeave(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrMasLeave> masLeaveList = new ArrayList<HrMasLeave>();
		List<HrMasLeave> hospitalList = new ArrayList<HrMasLeave>();
		Session session = (Session)getSession();
		 boolean dataDeleted=false;
		int leaveId = 0;
		if (generalMap.get("leaveId")!= null) {
			leaveId = (Integer)generalMap.get("leaveId"); 
		}
		int changedBy =0;
		if (generalMap.get("changedBy")!= null) {
			changedBy = Integer.parseInt((String) generalMap.get("changedBy")); 
		}
		Date currentDate = new Date(); 
		if (generalMap.get("currentDate")!= null) {
			currentDate = (Date)generalMap.get("currentDate"); 
		}
		String currentTime = "";
		if (generalMap.get("currentTime")!= null) {
			currentTime = (String)generalMap.get("currentTime"); 
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		HrMasLeave hrMasLeave = (HrMasLeave)hbt.load(HrMasLeave.class, leaveId);
		
		hrMasLeave.setLastChgBy(changedBy);
		hrMasLeave.setLastChgDate(currentDate);
		hrMasLeave.setLastChgTime(currentTime);
		hospitalList=getHibernateTemplate().find("from jkt.hms.masters.business.MasHospital as isc where isc.Id='"+leaveId+"' and isc.Status='y'");
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  hrMasLeave.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  hrMasLeave.setStatus("y");
				  dataDeleted=false;
			  }
			  hbt.update(hrMasLeave);
		  }
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		masLeaveList = session.createCriteria(HrMasLeave.class).list();
		map.put("masLeaveList", masLeaveList);
		map.put("hospitalList",hospitalList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> showHolidayMasterJsp() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
		map.put("holidayMasterList", holidayMasterList);
		return map;
	}
	public Map<String, Object> addHolidayMaster(Holidaycalendar holidaycalendar) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		List<Holidaycalendar> existingHolidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		String message = "";
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);
		String year = holidaycalendar.getHolidayListYear();
		SimpleDateFormat sdf= new  SimpleDateFormat("yyyy-MM-dd");
		String holidayDate =sdf.format(holidaycalendar.getHolidayDate());
		//String holidayDate =HMSUtil.convertDateToStringWithoutTime(holidaycalendar.getHolidayDate());
		existingHolidayMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar as hc where hc.HolidayDate = '"+holidayDate+"' and hc.HolidayListYear = '"+year+"'");
		if(existingHolidayMasterList.size()>0){
			message = "Record already exist...";
		}else{
			hbt.save(holidaycalendar);
			message = "Record save successfully !!";
		}
			holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
			map.put("holidayMasterList", holidayMasterList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> editHolidayMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		List<Holidaycalendar> existingHolidayMasterList = new ArrayList<Holidaycalendar>();
		int holidayMasterId = 0;
		if(generalMap.get("holidayMasterId")!= null){
			holidayMasterId = (Integer)generalMap.get("holidayMasterId");
		}
		String year = "";
		if(generalMap.get("year")!= null){
			year = (String)generalMap.get("year");
		}
		String description = "";
		if(generalMap.get("description")!= null){
			description = (String)generalMap.get("description");
		}
		Date holidayDate = null;
		if(generalMap.get("holidayDate")!= null){
			holidayDate = (Date)generalMap.get("holidayDate");
		}
		String rh= "";
		if(generalMap.get("rh")!= null){
			rh = (String)generalMap.get("rh");
		}
		String changedBy = "";
		if(generalMap.get("changedBy")!= null){
			changedBy = (String)generalMap.get("changedBy");
		}
		Date changedDate= new Date();
		if(generalMap.get("changedDate")!= null){
			changedDate = (Date)generalMap.get("changedDate");
		}
		String changedTime = "";
		if(generalMap.get("changedTime")!= null){
			changedTime = (String)generalMap.get("changedTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Holidaycalendar holidaycalendar = (Holidaycalendar)hbt.load(Holidaycalendar.class, holidayMasterId);
		holidaycalendar.setTitle(description);
		holidaycalendar.setLastChgBy(changedBy);
		holidaycalendar.setLastChgDate(changedDate);
		holidaycalendar.setLastChgTime(changedTime);
		holidaycalendar.setHolidayDate(holidayDate);
		holidaycalendar.setHolidayListYear(year);
		holidaycalendar.setRh(rh);
		existingHolidayMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar as hc where hc.HolidayDate = '"+holidayDate+"' and hc.HolidayListYear = '"+year+"'");
		String message = "";
		if(existingHolidayMasterList.size()>0){
			message = "Record already exist";
		}else{
			hbt.update(holidaycalendar);
			message = "Record update successfully !!";
		}
		Session session = (Session)getSession();
		holidayMasterList = session.createCriteria(Holidaycalendar.class).add(Restrictions.eq("Status", "y")).list();
		map.put("holidayMasterList", holidayMasterList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> deleteHolidayMaster(Map<String, Object> generalMap) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
		Session session = (Session)getSession();
		boolean dataDeleted=false;
		int holidayMasterId = 0;
		if(generalMap.get("holidayMasterId")!= null){
			holidayMasterId = (Integer)generalMap.get("holidayMasterId");
		}
		String changedBy = "";
		if(generalMap.get("changedBy")!= null){
			changedBy = (String)generalMap.get("changedBy");
		}
		Date changedDate= new Date();
		if(generalMap.get("changedDate")!= null){
			changedDate = (Date)generalMap.get("changedDate");
		}
		String changedTime = "";
		if(generalMap.get("changedTime")!= null){
			changedTime = (String)generalMap.get("changedTime");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Holidaycalendar holidaycalendar = (Holidaycalendar)hbt.load(Holidaycalendar.class, holidayMasterId);
		holidaycalendar.setLastChgBy(changedBy);
		holidaycalendar.setLastChgDate(changedDate);
		holidaycalendar.setLastChgTime(changedTime);
		if(generalMap.get("flag") != null){
			  String flag = (String)generalMap.get("flag");
			  if (flag.equals("InActivate")){
				  holidaycalendar.setStatus("n");
			   dataDeleted=true;
			  }else if(flag.equals("Activate")){
				  holidaycalendar.setStatus("y");
				  dataDeleted=false;
			  }
			  hbt.update(holidaycalendar);
		  }
		String message = "";
		if (dataDeleted==true)
		{
			message="Record is InActivated successfully !!";
		}

		else{
			message="Record is Activated successfully !!";
		}
		holidayMasterList = session.createCriteria(Holidaycalendar.class).list();
		map.put("holidayMasterList", holidayMasterList);
		map.put("message", message);
		return map;
	}
	public Map<String, Object> searchHolidayMaster(String name, String year) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Holidaycalendar> holidayMasterList = new ArrayList<Holidaycalendar>();
			try{
			if((name!=null) || (year == null)){
				
				holidayMasterList = getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar hc where hc.Title like '"+ name+"' ");
			}
			else{
				holidayMasterList=getHibernateTemplate().find("from jkt.hrms.masters.business.Holidaycalendar hc where hc.HolidayListYear like '"+ year+"'");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		map.put("year", year);
		map.put("name", name);
		map.put("holidayMasterList", holidayMasterList);
		return map;
	}

	@Override
	public List<MasEmployee> getEmployeeOfSameDepartment(int empId, int deptId) {
		List<MasEmployee> manager=new ArrayList<MasEmployee>();
		System.out.println("empId=="+empId);
		/*manager = (List<MasEmployee>) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as masemp where masemp.Id="
						+ empId +" and masemp.EmployeeDepartment.Id="+deptId +" and lower(Status)='y' order by masemp.EmployeeName");*/
		manager = (List<MasEmployee>) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as masemp where masemp.Id="+ empId +"  and lower(Status)=lower('y') order by masemp.EmployeeName");
		System.out.println("manager==="+manager.size());
		return manager;
	}
	@Override
	public Map<String, Object> getUserDetails(int empId) {
		
		List<MasEmployee> manager=new ArrayList<MasEmployee>();
		Map<String,Object> map=new HashMap<String,Object>();
		/*manager = (List<MasEmployee>) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as masemp where masemp.Id="
						+ empId +" and masemp.EmployeeDepartment.Id="+deptId +" and lower(Status)='y' order by masemp.EmployeeName");*/
		manager = (List<MasEmployee>) getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasEmployee as masemp where masemp.Id="+ empId +"  and lower(Status)='y' order by masemp.EmployeeName");
		String department="";
		String postheld="";
		if(null !=manager && manager.size()>0){
			for(MasEmployee emp:manager){
				department=emp.getEmployeeDepartment().getEmpDeptName();
				postheld=emp.getRank().getRankName();
			}
		}
		map.put("department", department);
		map.put("postheld", postheld);
		return map;
	}

	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		
		Session session = (Session) getSession();
		
		
		uploadDocuments = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("Id", uploadedDocumentId)).list();
		for(UploadDocuments upDocuments : uploadDocuments){
			System.out.println("111=="+upDocuments.getPatientDocument());
			System.out.println("22=="+upDocuments.getFileName());
		}
		
		
		return uploadDocuments;
	}

}