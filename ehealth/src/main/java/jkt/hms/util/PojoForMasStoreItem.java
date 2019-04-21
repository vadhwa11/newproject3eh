package jkt.hms.util;

import java.math.BigDecimal;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PojoForMasStoreItem {
	private int id;
	private int itemId;
	private String itemCode;
	private String itemName;
	private BigDecimal closingStock;
	private BigDecimal openingStock;
	public BigDecimal getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(BigDecimal openingStock) {
		this.openingStock = openingStock;
	}

	private BigDecimal receiptQnty;
	private BigDecimal issueQnty;
	private String purchingUnit;
	private String dispencingUnit;
	private String supplierName;
	private String ledgerDate;
	


	public String getLedgerDate() {
		return ledgerDate;
	}

	public void setLedgerDate(String ledgerDate) {
		this.ledgerDate = ledgerDate;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	private List<ChildPojoForMasstoreItem> childPojoForMasstoreItemList;
	private JRBeanCollectionDataSource subrepDs;

	public JRBeanCollectionDataSource getSubrepDs() {
		return subrepDs;
	}

	public void setSubrepDs(JRBeanCollectionDataSource subrepDs) {
		this.subrepDs = subrepDs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getClosingStock() {
		return closingStock;
	}

	public void setClosingStock(BigDecimal closingStock) {
		this.closingStock = closingStock;
	}

	public List<ChildPojoForMasstoreItem> getChildPojoForMasstoreItemList() {
		return childPojoForMasstoreItemList;
	}

	public void setChildPojoForMasstoreItemList(
			List<ChildPojoForMasstoreItem> childPojoForMasstoreItemList) {
		this.childPojoForMasstoreItemList = childPojoForMasstoreItemList;
	}

	public BigDecimal getReceiptQnty() {
		return receiptQnty;
	}

	public void setReceiptQnty(BigDecimal receiptQnty) {
		this.receiptQnty = receiptQnty;
	}

	public BigDecimal getIssueQnty() {
		return issueQnty;
	}

	public void setIssueQnty(BigDecimal issueQnty) {
		this.issueQnty = issueQnty;
	}

	public String getPurchingUnit() {
		return purchingUnit;
	}

	public void setPurchingUnit(String purchingUnit) {
		this.purchingUnit = purchingUnit;
	}

	public String getDispencingUnit() {
		return dispencingUnit;
	}

	public void setDispencingUnit(String dispencingUnit) {
		this.dispencingUnit = dispencingUnit;
	}

}
