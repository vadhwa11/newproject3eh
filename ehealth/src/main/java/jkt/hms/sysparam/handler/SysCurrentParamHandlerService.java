package jkt.hms.sysparam.handler;

import java.util.Map;

import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.util.Box;

public interface SysCurrentParamHandlerService {
	public Map<String, Object> getSysCurrentParamJsp();

	public boolean saveChangedSysParam(Map valueMap);

	public Map<String, Object> getHospitalParamJsp(Box box);

	public Map<String, Object> saveHospitalParam(Map valueMap);

	public Map<String, Object> getTransactionSeqSetupJsp();

	public Map<String, Object> getSearchTransSeqSetupJSP(
			String transactionSqName, String transactionPrefix);

	public Map<String, Object> checkForExistingTransSq(Map valueMap);

	public boolean addTransactionSeq(TransactionSequence transactionSequence);

	public boolean editTransactionNoToDatabase(Map valueMap);

	public Map<String, Object> getHospitalDetails(Box box);

}
