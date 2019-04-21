package jkt.hms.masters.business;


public class CommonLabTestReport {
	
	String resultDate;
	String resultTime;
	String testName;
	String testResult;
	String testType;
	String testStatus;
    int dgId;
    int investigationId;
	
	
	public String getResultTime() {
		return resultTime;
	}

	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public CommonLabTestReport()
	{}

	public String getResultDate() {
		return resultDate;
	}

	public void setResultDate(String resultDate) {
		this.resultDate = resultDate;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public int getDgId() {
		return dgId;
	}

	public void setDgId(int dgId) {
		this.dgId = dgId;
	}

	public int getInvestigationId() {
		return investigationId;
	}

	public void setInvestigationId(int investigationId) {
		this.investigationId = investigationId;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	
	
	
}
