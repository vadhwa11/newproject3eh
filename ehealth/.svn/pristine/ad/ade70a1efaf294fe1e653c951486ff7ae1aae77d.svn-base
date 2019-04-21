package jkt.hrms.masters.dataservice;

import java.util.Map;

import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrStandardAllowance;

public interface EtravelMasterDataService {
	public Map<String, Object> showETravelMasterJsp() ;

	public Map<String, Object> searchExpenseHead(String expenseCode,String expenseDesc) ;
	
	public boolean addExpenseHead(MstrCode mstrCode) ;
	
	public boolean editExpenseHead(Map<String, Object> generalMap) ;
	
	public boolean deleteExpenseHead(int mstrCodeId,Map<String, Object> generalMap) ;
	
	public Map<String, Object> showStandardAllowanceMasterJsp() ;
	
	public Map<String, Object> searchStandardAllowance(String standardAllowanceCode,String standardAllowanceDesc) ;
	
	public boolean addStandardAllowance(MstrStandardAllowance mstrStandardAllowance) ;
	
	public boolean editStandardAllowance(Map<String, Object> generalMap) ;
	
	public boolean deleteStandardAllowance(int mstrStandardAllowanceId,Map<String, Object> generalMap) ;
}
