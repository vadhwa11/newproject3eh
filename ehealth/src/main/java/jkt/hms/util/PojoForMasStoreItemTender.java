package jkt.hms.util;


import java.math.BigDecimal;

public class PojoForMasStoreItemTender {
	private String itemCode;
	private String nomenclature;
	private String strength;
	private String group_name;
	private String brandName;
	private String manufacturerName;
	private String item_unit_name;
	private String disp_type;
	private BigDecimal tender_qty;
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getNomenclature() {
		return nomenclature;
	}
	public void setNomenclature(String nomenclature) {
		this.nomenclature = nomenclature;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String groupName) {
		group_name = groupName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getManufacturerName() {
		return manufacturerName;
	}
	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}
	public String getItem_unit_name() {
		return item_unit_name;
	}
	public void setItem_unit_name(String itemUnitName) {
		item_unit_name = itemUnitName;
	}
	public String getDisp_type() {
		return disp_type;
	}
	public void setDisp_type(String dispType) {
		disp_type = dispType;
	}
	public BigDecimal getTender_qty() {
		return tender_qty;
	}
	public void setTender_qty(BigDecimal tenderQty) {
		tender_qty = tenderQty;
	}
	
}
