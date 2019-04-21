package jkt.hrms.masters.handler;

import java.util.Map;

import org.hibernate.loader.custom.Return;

import com.lowagie.text.rtf.field.RtfAnchor;

import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrStandardAllowance;
import jkt.hrms.masters.dataservice.EtravelMasterDataService;

public class EtravelMasterHandlerServiceImpl  implements EtravelMasterHandlerService {
	EtravelMasterDataService etravelMasterDataService=null;

	public EtravelMasterDataService getEtravelMasterDataService() {
		return etravelMasterDataService;
	}

	public void setEtravelMasterDataService(
			EtravelMasterDataService etravelMasterDataService) {
		this.etravelMasterDataService = etravelMasterDataService;
	}

	public Map<String, Object> showETravelMasterJsp() {
		return etravelMasterDataService.showETravelMasterJsp();
	}
	
	public Map<String, Object> searchExpenseHead(String expenseCode,String expenseDesc) {
		return etravelMasterDataService.searchExpenseHead(expenseCode, expenseDesc);
	}
	
	public boolean addExpenseHead(MstrCode mstrCode) {
		return etravelMasterDataService.addExpenseHead(mstrCode);
	}
	
	public boolean editExpenseHead(Map<String, Object> generalMap) {
		return etravelMasterDataService.editExpenseHead(generalMap);
	}
	
	public boolean deleteExpenseHead(int mstrCodeId,Map<String, Object> generalMap) {
		return etravelMasterDataService.deleteExpenseHead(mstrCodeId, generalMap);
	}
	
	public Map<String, Object> showStandardAllowanceMasterJsp() {
		return etravelMasterDataService.showStandardAllowanceMasterJsp();
	}
	
	public Map<String, Object> searchStandardAllowance(String standardAllowanceCode,String standardAllowanceDesc) {
		return etravelMasterDataService.searchStandardAllowance(standardAllowanceCode, standardAllowanceDesc);
	}
	
	public boolean addStandardAllowance(MstrStandardAllowance mstrStandardAllowance) {
		return etravelMasterDataService.addStandardAllowance(mstrStandardAllowance);
	}
	
	public boolean editStandardAllowance(Map<String, Object> generalMap) {
		return etravelMasterDataService.editStandardAllowance(generalMap);
	}
	
	public boolean deleteStandardAllowance(int mstrStandardAllowanceId,Map<String, Object> generalMap) {
		return etravelMasterDataService.deleteStandardAllowance(mstrStandardAllowanceId, generalMap);
	}
}
