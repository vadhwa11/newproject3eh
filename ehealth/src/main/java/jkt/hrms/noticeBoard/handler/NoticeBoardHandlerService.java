package jkt.hrms.noticeBoard.handler;

import java.util.List;
import java.util.Map;

import jkt.hrms.masters.business.HrNoticeBoardData;

public interface NoticeBoardHandlerService {

	public List getNoticeBoardDataListForId(int noticeId);

	public List getNoticeBoardList();

	public String addNotice(Map requestMap);

	public void deleteMany(String[] deleteNotices);

	public void updateNoticeBoard(HrNoticeBoardData hrNoticeBoardData);

	public List getNoticeToDisplay(String noticeType);

	public Map showLeaveDetailsOnDashboard(int uid);

	public Map showRecruitmentDetailsOnDashboard(int uid);

	public Map showtimeSheetDetailsOnDashboard(int uid);

	public Map showEtravelDetailsOnDashboard(int uid);

	public Map showDCFDetailsOnDashboard(int uid);

	public Map showSqVisitDetailsOnDashboard(int uid);

	public Map getMrdDetailsForDashboard(String date);

	public Map getBillingDetailsForDashboard();

	public Map getPharmacyDetailsForDashboard();

	public Map getCompanyBillDetailsForDashboard();

	// public Map showRecruitmentDetailsOnDashboard(int uid);
}
