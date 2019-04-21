package jkt.hms.util;

public class MmfItemDetails {
	private int id;
	private String Nomeclature;
	private double previousYearSum;
	private double currentYearSum;
	private double requestMMfSum;
	private String Remarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeclature() {
		return Nomeclature;
	}

	public void setNomeclature(String nomeclature) {
		Nomeclature = nomeclature;
	}

	public double getPreviousYearSum() {
		return previousYearSum;
	}

	public void setPreviousYearSum(double previousYearSum) {
		this.previousYearSum = previousYearSum;
	}

	public double getCurrentYearSum() {
		return currentYearSum;
	}

	public void setCurrentYearSum(double currentYearSum) {
		this.currentYearSum = currentYearSum;
	}

	public double getRequestMMfSum() {
		return requestMMfSum;
	}

	public void setRequestMMfSum(double requestMMfSum) {
		this.requestMMfSum = requestMMfSum;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

}
