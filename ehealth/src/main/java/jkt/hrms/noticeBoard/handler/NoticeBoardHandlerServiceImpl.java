package jkt.hrms.noticeBoard.handler;

import java.util.List;
import java.util.Map;

import jkt.hrms.masters.business.HrNoticeBoardData;
import jkt.hrms.noticeBoard.dataservice.NoticeBoardDataService;

public class NoticeBoardHandlerServiceImpl implements NoticeBoardHandlerService {
	private NoticeBoardDataService noticeBoardDataService = null;

	public List getNoticeBoardDataListForId(int noticeId) {
		return noticeBoardDataService.getNoticeBoardDataListForId(noticeId);
	}

	public List getNoticeBoardList() {
		return noticeBoardDataService.getNoticeBoardList();
	}

	public String addNotice(Map requestMap) {
		return noticeBoardDataService.addNotice(requestMap);
	}

	public void deleteMany(String[] deleteNotices) {
		noticeBoardDataService.deleteMany(deleteNotices);
	}

	public void updateNoticeBoard(HrNoticeBoardData hrNoticeBoardData) {
		noticeBoardDataService.updateNoticeBoard(hrNoticeBoardData);
	}

	public NoticeBoardDataService getNoticeBoardDataService() {
		return noticeBoardDataService;
	}

	public void setNoticeBoardDataService(
			NoticeBoardDataService noticeBoardDataService) {
		this.noticeBoardDataService = noticeBoardDataService;
	}

	public List getNoticeToDisplay(String noticeType) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.getNoticeToDisplay(noticeType);
	}

	public Map showLeaveDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showLeaveDetailsOnDashboard(uid);
	}

	public Map showRecruitmentDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showRecruitmentDetailsOnDashboard(uid);
	}

	public Map showDCFDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showDCFDetailsOnDashboard(uid);
	}

	public Map showSqVisitDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showSqVisitDetailsOnDashboard(uid);
	}

	public Map showtimeSheetDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showtimeSheetDetailsOnDashboard(uid);
	}

	public Map showEtravelDetailsOnDashboard(int uid) {
		// TODO Auto-generated method stub
		return noticeBoardDataService.showEtravelDetailsOnDashboard(uid);
	}

	public Map getBillingDetailsForDashboard() {
		return noticeBoardDataService.getBillingDetailsForDashboard();
	}

	public Map getCompanyBillDetailsForDashboard() {
		return noticeBoardDataService.getCompanyBillDetailsForDashboard();
	}

	public Map getMrdDetailsForDashboard(String date) {
		return noticeBoardDataService.getMrdDetailsForDashboard(date);
	}

	public Map getPharmacyDetailsForDashboard() {
		return noticeBoardDataService.getPharmacyDetailsForDashboard();
	}
}
