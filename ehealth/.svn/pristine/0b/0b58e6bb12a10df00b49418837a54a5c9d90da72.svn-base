package jkt.hrms.recruitment.handler;

import java.util.List;
import java.util.Map;

import jkt.hrms.recruitment.dataservice.RecruitmentDataService;
import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;
import jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;

public class RecruitmentHandlerServiceImpl implements RecruitmentHandlerService {
	private RecruitmentDataService recruitmentDataService = null;

	public RecruitmentDataService getRecruitmentDataService() {
		return recruitmentDataService;
	}

	public void setRecruitmentDataService(
			RecruitmentDataService recruitmentDataService) {
		this.recruitmentDataService = recruitmentDataService;
	}

	/*public Map<String, Object> showResourceReqJsp(int hospitalId) {
		return recruitmentDataService.showResourceReqJsp(hospitalId);
	}*/
	
	public Map<String, Object> showResourceReqJsp(Map<String, Object> detailsMap) {
		return recruitmentDataService.showResourceReqJsp(detailsMap);
	}

	public Map<String, Object> saveResourceRequisitionDetail(
			ResourceRequisition resourceRequisition) {
		return recruitmentDataService
				.saveResourceRequisitionDetail(resourceRequisition);
	}

	public Map<String, Object> updateResourceRequisitionDetail(
			Map<String, Object> parameterMap) {
		return recruitmentDataService
				.updateResourceRequisitionDetail(parameterMap);
	}

	public Map<String, Object> searchResourceRequests(
			Map<String, Object> parameterMap) {
		return recruitmentDataService.searchResourceRequests(parameterMap);
	}

	public Map<String, Object> showResourceDetailForUpdate(int hospitalId,
			int requisitionId) {
		return recruitmentDataService.showResourceDetailForUpdate(hospitalId,
				requisitionId);
	}

	public Map getRequistionListForUser(Map map) {
		return recruitmentDataService.getRequistionListForUser(map);
	}

	public List getRequestStatusMasterList() {
		return recruitmentDataService.getRequestStatusMasterList();
	}

	public List<ResourceRequisition> updateRequisitionStatus(
			List<ResourceRequisition> list) {
		return recruitmentDataService.updateRequisitionStatus(list);
	}

	public RequestStatusMaster getRequestStatusMasterById(
			Integer requestStatusId) {
		return recruitmentDataService
				.getRequestStatusMasterById(requestStatusId);
	}

	public List getAllApprovedRequests() {
		return recruitmentDataService.getAllApprovedRequests();
	}

	public void saveOrUpdateResourceRequisitionStatus(
			HrResourceRequisitionStatus hrResourceRequisitionStatus) {
		recruitmentDataService
				.saveOrUpdateResourceRequisitionStatus(hrResourceRequisitionStatus);
	}

	public Map getRequistionListForMarketCTCAnalysis(Map map) {
		return recruitmentDataService
				.getRequistionListForMarketCTCAnalysis(map);
	}

	public void saveOrUpdateRequisitionHistory(
			HrRequisitionHistory requisitionHistory) {
		recruitmentDataService
				.saveOrUpdateRequisitionHistory(requisitionHistory);
	}

	public List<ResourceRequisition> addDepartmentTotalCTC(
			List<ResourceRequisition> resourceRequisitionList) {
		return recruitmentDataService
				.addDepartmentTotalCTC(resourceRequisitionList);
	}

	public Map loadObject(Class klass, Integer id) {
		return recruitmentDataService.loadObject(klass, id);
	}

	@Override
	public Map<String, Object> getEmployeeForPromo(Map<String, Object> detailMap) {
		return recruitmentDataService.getEmployeeForPromo(detailMap);
	}

	@Override
	public Map<String, Object> searchResourceReqJsp(Map<String, Object> detailMap) {
		
		return recruitmentDataService.searchResourceReqJsp(detailMap);
	}

	@Override
	public Map<String, Object> showPostJsp(Map<String, Object> detailMap) {
		
		return recruitmentDataService.showPostJsp(detailMap);
	}
}
