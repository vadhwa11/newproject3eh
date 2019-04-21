package jkt.hrms.recruitment.dataservice;

import java.util.List;
import java.util.Map;

import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;
import jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;

public interface RecruitmentDataService {
	Map<String, Object> showResourceReqJsp(Map<String, Object> detailsMap);

	Map<String, Object> saveResourceRequisitionDetail(
			ResourceRequisition resourceRequisition);

	Map<String, Object> updateResourceRequisitionDetail(
			Map<String, Object> parameterMap);

	Map<String, Object> searchResourceRequests(Map<String, Object> parameterMap);

	Map<String, Object> showResourceDetailForUpdate(int hospitalId,
			int requisitionId);

	Map getRequistionListForUser(Map map);

	List getRequestStatusMasterList();

	List<ResourceRequisition> updateRequisitionStatus(
			List<ResourceRequisition> list);

	RequestStatusMaster getRequestStatusMasterById(Integer requestStatusId);

	List getAllApprovedRequests();

	void saveOrUpdateResourceRequisitionStatus(
			HrResourceRequisitionStatus hrResourceRequisitionStatus);

	Map getRequistionListForMarketCTCAnalysis(Map map);

	void saveOrUpdateRequisitionHistory(HrRequisitionHistory requisitionHistory);

	List<ResourceRequisition> addDepartmentTotalCTC(
			List<ResourceRequisition> resourceRequisitionList);

	Map loadObject(Class klass, Integer id);

	Map<String, Object> getEmployeeForPromo(Map<String, Object> detailMap);

	Map<String, Object> searchResourceReqJsp(Map<String, Object> detailMap);

	Map<String, Object> showPostJsp(Map<String, Object> detailMap);
}
