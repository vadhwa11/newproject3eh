package jkt.hms.sysparam.handler;

import java.util.Map;

import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.sysparam.dataservice.SysCurrentParamDataService;
import jkt.hms.util.Box;

public class SysCurrentParamHandlerServiceImpl implements
		SysCurrentParamHandlerService {

	SysCurrentParamDataService sysCurrentParamDataService = null;

	public void setSysCurrentParamDataService(
			SysCurrentParamDataService sysCurrentParamDataService) {
		this.sysCurrentParamDataService = sysCurrentParamDataService;
	}

	public Map<String, Object> getSysCurrentParamJsp() {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.getSysCurrentParamJsp();
	}

	public boolean saveChangedSysParam(Map valueMap) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.saveChangedSysParam(valueMap);
	}

	public Map<String, Object> getHospitalParamJsp(Box box) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.getHospitalParamJsp(box);
	}

	public Map<String, Object> saveHospitalParam(Map valueMap) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.saveHospitalParam(valueMap);
	}

	public Map<String, Object> getTransactionSeqSetupJsp() {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.getTransactionSeqSetupJsp();
	}

	public Map<String, Object> getSearchTransSeqSetupJSP(
			String transactionSqName, String transactionPrefix) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.getSearchTransSeqSetupJSP(
				transactionSqName, transactionPrefix);
	}

	public Map<String, Object> checkForExistingTransSq(Map valueMap) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.checkForExistingTransSq(valueMap);
	}

	public boolean addTransactionSeq(TransactionSequence transactionSequence) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService
				.addTransactionSeq(transactionSequence);
	}

	public boolean editTransactionNoToDatabase(Map valueMap) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.editTransactionNoToDatabase(valueMap);
	}

	public Map<String, Object> getHospitalDetails(Box box) {
		// TODO Auto-generated method stub
		return sysCurrentParamDataService.getHospitalDetails(box);
	}

	

		
}
