package jkt.hrms.noticeBoard.dataservice;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreInternalIndentM;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrNoticeBoardData;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NoticeBoardDataServiceImpl extends HibernateDaoSupport implements
		NoticeBoardDataService {

	public List getNoticeBoardDataListForId(int noticeId) {
		List<HrNoticeBoardData> notices = new ArrayList<HrNoticeBoardData>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrNoticeBoardData.class);

		crit = crit.add(Restrictions.eq("Status", "y"));
		crit = crit.add(Restrictions.eq("Id", noticeId));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		notices = crit.list();

		// leaveType=hbt.find("from jkt.hrms.masters.business.HrMasLeave as
		// leave");

		return notices;
	}

	public List getNoticeBoardList() {
		List<HrNoticeBoardData> noticeList = new ArrayList<HrNoticeBoardData>();

		Session session = (Session) getSession();
		Criteria crit = session.createCriteria(HrNoticeBoardData.class);

		crit = crit.add(Restrictions.eq("Status", "y"));
		// crit = crit.add(Restrictions.eq("Id", noticeId));

		Order order = Order.asc("Id");
		crit = crit.addOrder(order);

		noticeList = crit.list();

		// leaveType=hbt.find("from jkt.hrms.masters.business.HrMasLeave as
		// leave");

		return noticeList;
	}

	public List getNoticeToDisplay(String noticeType) {
		List<HrNoticeBoardData> noticeList = new ArrayList<HrNoticeBoardData>();

		Session session = (Session) getSession();
		// ln(noticeType+"-----noticeType");
		Criteria crit = session.createCriteria(HrNoticeBoardData.class).add(
				Restrictions.eq("DisplayOnIndex", noticeType));
		// noticeList=getHibernateTemplate().find("from
		// jkt.hrms.masters.business.HrNoticeBoardData notice where
		// notice.DisplayOnIndex ='"+noticeType+"'");
		noticeList = crit.list();
		// (noticeList.size()+"dkkkkkkkkkkkkkkkkkkkkkkkkkk");
		return noticeList;
	}

	@SuppressWarnings("unchecked")
	public String addNotice(Map requestMap) {
		String message = "";
		String noticeType = "";
		String msgToDisplay = "";
		int hospitalId = 0;
		String lastChgBy = "";
		String lastChgDate = "";
		String lastChgTime = "";
		String entryDate = "";
		Session session = (Session) getSession();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		@SuppressWarnings("unused")
		List<HrNoticeBoardData> hrNoticeList = new ArrayList<HrNoticeBoardData>();
		try {
			if (requestMap != null) {
				noticeType = (String) requestMap.get("noticeType");
				msgToDisplay = (String) requestMap.get("msgToDisplay");
				lastChgBy = (String) requestMap.get("lastChgBy");
				lastChgDate = (String) requestMap.get("lastChgDate");
				lastChgTime = (String) requestMap.get("lastChgTime");
				hospitalId = (Integer) requestMap.get("hospitalId");
				Criteria crit = session.createCriteria(HrNoticeBoardData.class)
						.add(Restrictions.eq("DisplayOnIndex", noticeType));
				hrNoticeList = crit.list();
				if (hrNoticeList != null && hrNoticeList.size() == 1) {
					HrNoticeBoardData hrNoticeBoardData = hrNoticeList.get(0);
					hrNoticeBoardData.setNoticeData(msgToDisplay);
					hrNoticeBoardData.setLastChgBy(lastChgBy);
					hrNoticeBoardData.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					hrNoticeBoardData.setLastChgTime(lastChgTime);
					hrNoticeBoardData.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					MasHospital company = (MasHospital) session
							.createCriteria(MasHospital.class)
							.add(Restrictions.eq("Id", hospitalId)).list()
							.get(0);
					hrNoticeBoardData.setCompany(company);
					hbt.update(hrNoticeBoardData);
					message = "Post done sucessfully";
				} else {
					HrNoticeBoardData newHrNoticeBoardData = new HrNoticeBoardData();
					newHrNoticeBoardData.setNoticeData(msgToDisplay);
					newHrNoticeBoardData.setLastChgBy(lastChgBy);
					newHrNoticeBoardData.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					newHrNoticeBoardData.setLastChgTime(lastChgTime);
					newHrNoticeBoardData.setEntryDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					newHrNoticeBoardData.setDisplayOnIndex(noticeType);
					MasHospital company = (MasHospital) session
							.createCriteria(MasHospital.class)
							.add(Restrictions.eq("Id", hospitalId)).list()
							.get(0);
					newHrNoticeBoardData.setCompany(company);
					hbt.save(newHrNoticeBoardData);
					hbt.refresh(newHrNoticeBoardData);
					message = "Post done sucessfully";
				}

			} else {
				// request map is empty
			}
		} catch (Exception e) {
			message = "Post not done sucessfully";
		}

		return message;

		// hbt.save(hrNoticeBoardData);
		// hbt.refresh(hrNoticeBoardData);
	}

	/*
	 * public void updateDisplayStatus(String[] displayStatus) {
	 * 
	 * for (int i = 0; i < displayStatus.length; i++) { HrNoticeBoardData
	 * hrNoticeBoardData =
	 * (HrNoticeBoardData)getHibernateTemplate().load(HrNoticeBoardData.class,
	 * Integer.parseInt(displayStatus[i]));
	 * 
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false);
	 * 
	 * hrNoticeBoardData.setDisplayOnIndex("y"); hbt.update(hrNoticeBoardData);
	 * } }
	 */

	public void deleteMany(String[] deleteNotices) {

		for (int i = 0; i < deleteNotices.length; i++) {
			HrNoticeBoardData hrNoticeBoardData = (HrNoticeBoardData) getHibernateTemplate()
					.load(HrNoticeBoardData.class,
							Integer.parseInt(deleteNotices[i]));

			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hrNoticeBoardData.setStatus("n");
			hbt.update(hrNoticeBoardData);
			hbt.refresh(hrNoticeBoardData);
		}
	}

	public void updateNoticeBoard(HrNoticeBoardData hrNoticeBoardData) {

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		hbt.update(hrNoticeBoardData);
		hbt.refresh(hrNoticeBoardData);
	}

	@SuppressWarnings("unchecked")
	public Map showLeaveDetailsOnDashboard(int uid) {

		Map map = new HashMap();
		int pendingListSize = 0;
		int onHoldListSize = 0;
		int rejectedListSize = 0;
		int receivedApprovalListSize = 0;

		HibernateTemplate hbt = getHibernateTemplate();
		pendingListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.EmpId="
						+ uid + " and hd.leaveStatus=" + 3).size();
		onHoldListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.EmpId="
						+ uid + " and hd.leaveStatus=" + 1).size();
		rejectedListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.EmpId="
						+ uid + " and hd.leaveStatus=" + 4).size();
		receivedApprovalListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.EmpId="
						+ uid + " and hd.leaveStatus=" + 2).size();

		// List openingBalList = hbt.find("from
		// jkt.hrms.masters.business.HrEmployeeBalanceNew as bal where
		// hd.Emp="+uid);

		map.put("pendingListSize", pendingListSize);

		map.put("onHoldListSize", onHoldListSize);

		map.put("rejectedListSize", rejectedListSize);

		map.put("receivedApprovalListSize", receivedApprovalListSize);

		// map.put("openingBalList",openingBalList);

		int ReqPendingListSize = 0;
		int ReqOnHoldListSize = 0;
		int ReqRejectedListSize = 0;
		int ReqReceivedApprovalListSize = 0;

		ReqPendingListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.leaveApprovedBy="
						+ uid + " and hd.leaveStatus=" + 3).size();
		ReqOnHoldListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.leaveApprovedBy="
						+ uid + " and hd.leaveStatus=" + 1).size();
		ReqRejectedListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.leaveApprovedBy="
						+ uid + " and hd.leaveStatus=" + 4).size();
		ReqReceivedApprovalListSize = hbt.find(
				"from jkt.hrms.masters.business.HrLeaveDetails as hd where hd.leaveApprovedBy="
						+ uid + " and hd.leaveStatus=" + 2).size();

		map.put("ReqPendingListSize", ReqPendingListSize);

		map.put("ReqOnHoldListSize", ReqOnHoldListSize);

		map.put("ReqRejectedListSize", ReqRejectedListSize);

		map.put("ReqReceivedApprovalListSize", ReqReceivedApprovalListSize);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map showRecruitmentDetailsOnDashboard(int uid) {
		Map map = new HashMap();
		int pendingListSize = 0;
		// int onHoldListSize=0;
		// int rejectedListSize=0;
		// int receivedApprovalListSize=0;

		HibernateTemplate hbt = getHibernateTemplate();
		pendingListSize = hbt
				.find("from jkt.hrms.recruitment.masters.business.ResourceRequisition as hd where hd.Initiator="
						+ uid).size();

		map.put("pendingListSize", pendingListSize);
		return map;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Map showDCFDetailsOnDashboard(int uid) {
		Map map = new HashMap();
		int pendingListSize = 0;
		int onHoldListSize = 0;
		int rejectedListSize = 0;

		int receivedApprovalListSize = 0;

		Session session = getSession();
		String query = "select * from prj_dcf_gen D"
				+ " inner join prj_add_patient A on A.ap_id=D.ap_id"
				+ " inner join prj_site_res_map RES on RES.Role_id=7 and RES.prj_id=A.prj_id and A.site_id=RES.site_id"
				+ " inner join mstr_project P on P.prj_id=RES.prj_id and P.Prj_status=1"
				+ " where D.Dcf_id in (select MAX(Dcf_id) from prj_dcf_gen  group by rev_no)"
				+ " and D.iss_status=2 and RES.Emp_id=" + uid;
		pendingListSize = session.createSQLQuery(query).list().size();
		return map;
	}

	public Map showSqVisitDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map showtimeSheetDetailsOnDashboard(int uid) {

		Map map = new HashMap();
		int requestedListSize = 0;
		int pendingListSize = 0;
		int onHoldListSize = 0;
		int rejectedListSize = 0;
		int receivedApprovalListSize = 0;

		HibernateTemplate hbt = getHibernateTemplate();
		requestedListSize = hbt.find(
				"from jkt.hrms.masters.business.Tbltimesheet as hd where hd.EmpId="
						+ uid).size();
		pendingListSize = hbt.find(
				"from jkt.hrms.masters.business.Tbltimesheet as hd where hd.EmpId="
						+ uid + " and hd.Status='Submitted'").size();
		onHoldListSize = hbt.find(
				"from jkt.hrms.masters.business.Tbltimesheet as hd where hd.EmpId="
						+ uid + " and hd.Status='Forwaded'").size();
		rejectedListSize = hbt.find(
				"from jkt.hrms.masters.business.Tbltimesheet as hd where hd.EmpId="
						+ uid + " and hd.Status='Rejected'").size();
		receivedApprovalListSize = hbt.find(
				"from jkt.hrms.masters.business.Tbltimesheet as hd where hd.EmpId="
						+ uid + " and hd.Status='Approved'").size();

		// map.put("requestedListSize", requestedListSize);

		map.put("pendingListSize", pendingListSize);

		map.put("onHoldListSize", onHoldListSize);

		map.put("rejectedListSize", rejectedListSize);

		map.put("receivedApprovalListSize", receivedApprovalListSize);

		int ReqPendingListSize = 0;
		int ReqOnHoldListSize = 0;
		int ReqRejectedListSize = 0;
		int ReqReceivedApprovalListSize = 0;
		List ReqPendingListSizelist = hbt
				.find("from jkt.hrms.masters.business.Tbltimesheet t where  t.Status ='Submitted' and t.EmpId in (select Id from jkt.hms.masters.business.MasEmployee emp where emp.LineManager ="
						+ uid + ")");
		ReqPendingListSize = ReqPendingListSizelist.size();// hbt.find("from
		// jkt.hrms.masters.business.TbltimesheetAprl
		// as hd where
		// hd.Approver="+uid+"
		// and
		// hd.TaStatus='Submitted'").size();

		ReqOnHoldListSize = hbt
				.find("from jkt.hrms.masters.business.Tbltimesheet t where  t.Status ='Forwarded' and t.EmpId in (select Id from jkt.hms.masters.business.MasEmployee emp where emp.LineManager ="
						+ uid + ")").size();
		ReqRejectedListSize = hbt
				.find("from jkt.hrms.masters.business.Tbltimesheet t where  t.Status ='Rejected' and t.EmpId in (select Id from jkt.hms.masters.business.MasEmployee emp where emp.LineManager ="
						+ uid + ")").size();
		ReqReceivedApprovalListSize = hbt
				.find("from jkt.hrms.masters.business.Tbltimesheet t where  t.Status ='Approved' and t.EmpId in (select Id from jkt.hms.masters.business.MasEmployee emp where emp.LineManager ="
						+ uid + ")").size();

		map.put("ReqPendingListSize", ReqPendingListSize);

		map.put("ReqOnHoldListSize", ReqOnHoldListSize);

		map.put("ReqRejectedListSize", ReqRejectedListSize);

		map.put("ReqReceivedApprovalListSize", ReqReceivedApprovalListSize);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map showEtravelDetailsOnDashboard(int uid) {

		Map map = new HashMap();
		int requestedListSize = 0;
		int pendingListSize = 0;
		int onHoldListSize = 0;
		int rejectedListSize = 0;
		int receivedApprovalListSize = 0;

		HibernateTemplate hbt = getHibernateTemplate();
		requestedListSize = hbt.find(
				"from jkt.hrms.masters.business.EtrTravelreq as hd where hd.EmpId="
						+ uid).size();
		pendingListSize = hbt.find(
				"from jkt.hrms.masters.business.EtrTravelreq as hd where hd.EmpId="
						+ uid + " and hd.TrvStatus=" + 0).size();
		onHoldListSize = hbt.find(
				"from jkt.hrms.masters.business.EtrTravelreq as hd where hd.EmpId="
						+ uid + " and hd.TrvStatus=" + 3).size();
		rejectedListSize = hbt.find(
				"from jkt.hrms.masters.business.EtrTravelreq as hd where hd.EmpId="
						+ uid + " and hd.TrvStatus=" + 2).size();
		receivedApprovalListSize = hbt.find(
				"from jkt.hrms.masters.business.EtrTravelreq as hd where hd.EmpId="
						+ uid + " and hd.TrvStatus=" + 1).size();

		// map.put("requestedListSize", requestedListSize);

		map.put("pendingListSize", pendingListSize);

		map.put("onHoldListSize", onHoldListSize);

		map.put("rejectedListSize", rejectedListSize);

		map.put("receivedApprovalListSize", receivedApprovalListSize);

		int ReqPendingListSize = 0;
		int ReqOnHoldListSize = 0;
		int ReqRejectedListSize = 0;
		int ReqReceivedApprovalListSize = 0;

		ReqPendingListSize = hbt
				.find("from jkt.hrms.masters.business.EtrApptbl as hd where hd.ApprSts=0 and hd.ApprId="
						+ uid).size();
		ReqOnHoldListSize = hbt
				.find("from jkt.hrms.masters.business.EtrApptbl as hd where hd.ApprSts=4 and hd.ApprId="
						+ uid).size();
		ReqRejectedListSize = hbt
				.find("from jkt.hrms.masters.business.EtrApptbl as hd where hd.ApprSts=2 and hd.ApprId="
						+ uid).size();
		ReqReceivedApprovalListSize = hbt
				.find("from jkt.hrms.masters.business.EtrApptbl as hd where hd.ApprSts=1 and hd.ApprId="
						+ uid).size();

		map.put("ReqPendingListSize", ReqPendingListSize);

		map.put("ReqOnHoldListSize", ReqOnHoldListSize);

		map.put("ReqRejectedListSize", ReqRejectedListSize);

		map.put("ReqReceivedApprovalListSize", ReqReceivedApprovalListSize);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getMrdDetailsForDashboard(String date) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> newRegistrations = new ArrayList<Integer>();
		List<Integer> newVisits = new ArrayList<Integer>();
		List<Integer> newAdmission = new ArrayList<Integer>();

		Date currentDate = HMSUtil.convertStringTypeDateToDateType(date);
		Session session = (Session) getSession();
		//
		//
if( currentDate!=null){
	
	String queryForNewPatient="select count(hin_id) from patient where reg_date='"+date.substring(6,10).concat("-").concat(date.substring(3,5).concat("-").concat(date.substring(0,2)))+"'";
	//
	newRegistrations = session.createSQLQuery(queryForNewPatient).list();
	
	String queryForRepeatVisit="select count(visit_id) from visit where visit_date='"+date.substring(6,10).concat("-").concat(date.substring(3,5).concat("-").concat(date.substring(0,2)))+"'";
	//
	newVisits = session.createSQLQuery(queryForRepeatVisit).list();
	String queryForAdmission="select count(inpatient_id) from inpatient where date_of_addmission='"+date.substring(6,10).concat("-").concat(date.substring(3,5).concat("-").concat(date.substring(0,2)))+"'";
	
	newAdmission = session.createSQLQuery(queryForAdmission).list();
}
//
//
if(newRegistrations.size()>0){
		map.put("newRegistrations", newRegistrations.get(0));
		
}
if(newVisits.size()>0){
		map.put("newVisits", newVisits.get(0));
	
}
if(newAdmission.size()>0){
map.put("newAdmission", newAdmission.get(0));
}
		//Integer newReg=0;
		//map.put("newReg",newRegistrations);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getBillingDetailsForDashboard() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlReceiptHeader> receiptList = new ArrayList<BlReceiptHeader>();
		List<BigDecimal> onAccList = new ArrayList<BigDecimal>();
		List<BigDecimal> finalSettlementList = new ArrayList<BigDecimal>();
		Date currentDate = new Date();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(currentDate.getTime());

		receiptList = session.createCriteria(BlReceiptHeader.class)
				.add(Restrictions.eq("ReceiptDate", currentDate)).list();
		finalSettlementList = session.createCriteria(BlFinalBillDetails.class)
				.setProjection(Projections.sum("SettledAmt"))
				.add(Restrictions.eq("FinalBillDate", currentDate)).list();
		String qry = "";
		qry = "Select sum(onacc) from ("
				+ " select sum(outstanding) as onacc from bl_op_bill_header op where bill_date = '"
				+ formattedDate
				+ "'"
				+ " union "
				+ " select sum(outstanding) as onacc from bl_dispensing_header op where bill_date = '"
				+ formattedDate
				+ "'"
				+ " union "
				+ " select sum(os_amt) as onacc from bl_charge_slip_main op where chg_slp_date = '"
				+ formattedDate + "') a";

		onAccList = session.createSQLQuery(qry).list();
		if (onAccList.size() > 0) {
			map.put("onAccList", onAccList);
		}
		if (finalSettlementList.size() > 0) {
			map.put("finalSettlementList", finalSettlementList);
		}
		map.put("receiptList", receiptList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCompanyBillDetailsForDashboard() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigDecimal> compBillList = new ArrayList<BigDecimal>();
		List<Object[]> patientTypeBillList = new ArrayList<Object[]>();

		Date currentDate = new Date();
		Session session = (Session) getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(currentDate.getTime());
		String qry = "";
		String qryForPatientType = "";

		qry = " select sum(amt) from("
				+ " select sum(bl.net_amt) as amt "
				+ " from bl_receipt_header rh left join "
				+ " bl_op_bill_header bl  on rh.op_bill_header_id = bl.op_bill_header_id left join mas_company mc on bl.company_id = mc.company_id"
				+ " where bl.company_id is not null and rh.receipt_date = '"
				+ formattedDate
				+ "' "
				+ " union "
				+ " select sum(net_amt) as amt "
				+ " from bl_receipt_header rh left join "
				+ " bl_dispensing_header bl  on rh.dispensing_header_id = bl.dispensing_header_id left join mas_company mc on bl.company_id = mc.company_id"
				+ " where bl.company_id is not null and rh.receipt_date = '"
				+ formattedDate
				+ "' "
				+ " union "
				+ " select sum(net_amt) as amt "
				+ " from bl_receipt_header rh left join bl_final_bill_details "
				+ " bl  on rh.ip_final_bill_id = bl.final_bill_details_id left join mas_company mc on bl.company_id = mc.company_id"
				+ " where bl.company_id is not null and rh.receipt_date = '"
				+ formattedDate + "' " + " ) a ";

		compBillList = session.createSQLQuery(qry).list();

		qryForPatientType = " select sum(amt),patienttype from("
				+ " select sum(bl.net_amt) as amt,mc.patient_type_code as patienttype "
				+ " from bl_op_bill_header bl left join mas_patient_type mc on bl.patient_type_id = mc.patient_type_id"
				+ " where bl.patient_type_id is not null and bl.bill_date = '"
				+ formattedDate
				+ "' group by bl.patient_type_id "
				+ " union "
				+ " select sum(net_amt) as amt,mc.patient_type_code  as patienttype "
				+ " from bl_dispensing_header bl left join mas_patient_type mc on bl.patient_type_id = mc.patient_type_id"
				+ " where bl.patient_type_id is not null and bl.bill_date = '"
				+ formattedDate
				+ "' group by bl.patient_type_id  "
				+ " union "
				+ " select sum(net_amt) as amt,mc.patient_type_code as patienttype "
				+ " from bl_final_bill_details "
				+ " bl left join mas_patient_type mc on bl.patient_type_id = mc.patient_type_id"
				+ " where bl.patient_type_id is not null and bl.final_bill_date = '"
				+ formattedDate + "' group by bl.patient_type_id  "
				+ " ) a group by patienttype";

		patientTypeBillList = session.createSQLQuery(qryForPatientType).list();

		if (compBillList.size() > 0) {
			map.put("compBillList", compBillList);
		}

		if (patientTypeBillList.size() > 0) {
			map.put("patientTypeBillList", patientTypeBillList);
		}

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPharmacyDetailsForDashboard() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> pendingGrnList = new ArrayList<Object[]>();
		List<Object[]> pendingPOList = new ArrayList<Object[]>();
		List<Object[]> pendingDeptIssueList = new ArrayList<Object[]>();

		Session session = getSession();

		pendingGrnList = session
				.createCriteria(StoreGrnM.class)
				.add(Restrictions.eq("Status", "o"))
				.createAlias("Department", "d")
				.setProjection(
						Projections.projectionList()
								.add(Projections.count("GrnNo"))
								.add(Projections.property("d.Id"))
								.add(Projections.groupProperty("d.Id"))).list();
		pendingPOList = session
				.createCriteria(StorePoHeader.class)
				.add(Restrictions.eq("Status", "o"))
				.createAlias("Department", "d")
				.setProjection(
						Projections.projectionList()
								.add(Projections.count("PoNumber"))
								.add(Projections.property("d.Id"))
								.add(Projections.groupProperty("d.Id"))).list();
		pendingDeptIssueList = session
				.createCriteria(StoreInternalIndentM.class)
				.add(Restrictions.eq("Status", "o"))
				.createAlias("ToStore", "d")
				.setProjection(
						Projections.projectionList()
								.add(Projections.count("DemandNo"))
								.add(Projections.property("d.Id"))
								.add(Projections.groupProperty("d.Id"))).list();

		if (pendingGrnList.size() > 0) {
			map.put("pendingGrnList", pendingGrnList);
		}
		if (pendingPOList.size() > 0) {
			map.put("pendingPOList", pendingPOList);
		}
		if (pendingDeptIssueList.size() > 0) {
			map.put("pendingDeptIssueList", pendingDeptIssueList);
		}

		return map;
	}

}
