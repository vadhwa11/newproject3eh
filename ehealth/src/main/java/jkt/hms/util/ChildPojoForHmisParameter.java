package jkt.hms.util;

import jkt.hms.masters.business.HmisDistrictReport;
import jkt.hms.masters.business.HmisHospitalReport;
import jkt.hms.masters.business.MasHmisParameters;
import jkt.hms.masters.business.MasPhReportsParameters;

public class ChildPojoForHmisParameter {
	
	private int countOfTotalStock, countOfstockReceived, countOfUnusableStock, countOfStockDistributed, countOfBalanceOfPreviousMonth;
	private HmisDistrictReport hmisDistrictReport;
	private HmisHospitalReport hmisHospitalReport;
	private MasPhReportsParameters masPhReportsParameters;
	
	
	
	
	public MasPhReportsParameters getMasPhReportsParameters() {
		return masPhReportsParameters;
	}

	public void setMasPhReportsParameters(
			MasPhReportsParameters masPhReportsParameters) {
		this.masPhReportsParameters = masPhReportsParameters;
	}

	public int getCountOfBalanceOfPreviousMonth() {
		return countOfBalanceOfPreviousMonth;
	}

	public void setCountOfBalanceOfPreviousMonth(int countOfBalanceOfPreviousMonth) {
		this.countOfBalanceOfPreviousMonth = countOfBalanceOfPreviousMonth;
	}

	

	public HmisDistrictReport getHmisDistrictReport() {
		return hmisDistrictReport;
	}

	public void setHmisDistrictReport(HmisDistrictReport hmisDistrictReport) {
		this.hmisDistrictReport = hmisDistrictReport;
	}

	public int getCountOfTotalStock() {
		return countOfTotalStock;
	}

	public void setCountOfTotalStock(int countOfTotalStock) {
		this.countOfTotalStock = countOfTotalStock;
	}

	public int getCountOfstockReceived() {
		return countOfstockReceived;
	}

	public void setCountOfstockReceived(int countOfstockReceived) {
		this.countOfstockReceived = countOfstockReceived;
	}

	public int getCountOfUnusableStock() {
		return countOfUnusableStock;
	}

	public void setCountOfUnusableStock(int countOfUnusableStock) {
		this.countOfUnusableStock = countOfUnusableStock;
	}

	public int getCountOfStockDistributed() {
		return countOfStockDistributed;
	}

	public void setCountOfStockDistributed(int countOfStockDistributed) {
		this.countOfStockDistributed = countOfStockDistributed;
	}
	
	public HmisHospitalReport getHmisHospitalReport() {
		return hmisHospitalReport;
	}

	public void setHmisHospitalReport(HmisHospitalReport hmisHospitalReport) {
		this.hmisHospitalReport = hmisHospitalReport;
	}

}
