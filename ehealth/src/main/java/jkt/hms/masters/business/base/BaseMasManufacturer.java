package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the mas_manufacturer table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="mas_manufacturer"
 */

public abstract class BaseMasManufacturer  implements Serializable {

	public static String REF = "MasManufacturer";
	public static String PROP_PIN_CODE = "PinCode";
	public static String PROP_TIN_NO1 = "TinNo1";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_PIN_CODE3 = "PinCode3";
	public static String PROP_DISTRICT_ID = "DistrictId";
	public static String PROP_PIN_CODE2 = "PinCode2";
	public static String PROP_TIN_NO2 = "TinNo2";
	public static String PROP_TIN_NO3 = "TinNo3";
	public static String PROP_MANUFACTURER_NAME = "ManufacturerName";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_DISTRICT2 = "District2";
	public static String PROP_URL = "Url";
	public static String PROP_STATE3 = "State3";
	public static String PROP_DISTRICT3 = "District3";
	public static String PROP_ADDRESS2 = "Address2";
	public static String PROP_STATE2 = "State2";
	public static String PROP_LICENCE_NO2 = "LicenceNo2";
	public static String PROP_FAX_NUMBER = "FaxNumber";
	public static String PROP_MOBILENO = "Mobileno";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_LICENCE_NO3 = "LicenceNo3";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_NAME2 = "CfLocalDistributorName2";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_NAME3 = "CfLocalDistributorName3";
	public static String PROP_URL3 = "Url3";
	public static String PROP_URL2 = "Url2";
	public static String PROP_EMAIL_ID = "EmailId";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS3 = "CfLocalDistributorAddress3";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS2 = "CfLocalDistributorAddress2";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_ADDRESS1 = "CfLocalDistributorAddress1";
	public static String PROP_CONTACT_PERSON = "ContactPerson";
	public static String PROP_LICENCE_NO = "LicenceNo";
	public static String PROP_PHONENO = "Phoneno";
	public static String PROP_CF_LOCAL_DISTRIBUTOR_NAME = "CfLocalDistributorName";
	public static String PROP_CITY = "City";
	public static String PROP_MANUFACTURER_CODE = "ManufacturerCode";
	public static String PROP_MOBILENO2 = "Mobileno2";
	public static String PROP_SALES_TAX_NO = "SalesTaxNo";
	public static String PROP_MOBILENO3 = "Mobileno3";
	public static String PROP_STATUS = "Status";
	public static String PROP_EMAIL_ID2 = "EmailId2";
	public static String PROP_STATE = "State";
	public static String PROP_EMAIL_ID3 = "EmailId3";
	public static String PROP_ID = "Id";


	// constructors
	public BaseMasManufacturer () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasManufacturer (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String manufacturerCode;
	private java.lang.String manufacturerName;
	private java.lang.String status;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String address1;
	private java.lang.String address2;
	private java.lang.String phoneno;
	private java.lang.String mobileno;
	private java.lang.String emailId;
	private java.lang.String faxNumber;
	private java.lang.String url;
	private java.lang.String contactPerson;
	private java.lang.Integer pinCode;
	private java.lang.String licenceNo;
	private java.lang.String salesTaxNo;
	private java.lang.String cfLocalDistributorName;
	private java.lang.String cfLocalDistributorAddress1;
	private java.lang.String cfLocalDistributorAddress2;
	private java.lang.Integer districtId;
	private java.lang.String cfLocalDistributorName2;
	private java.lang.String cfLocalDistributorName3;
	private java.lang.String cfLocalDistributorAddress3;
	private java.lang.Integer pinCode2;
	private java.lang.Integer pinCode3;
	private java.lang.Integer mobileno2;
	private java.lang.Integer mobileno3;
	private java.lang.Integer tinNo1;
	private java.lang.Integer tinNo2;
	private java.lang.Integer tinNo3;
	private java.lang.String licenceNo2;
	private java.lang.String licenceNo3;
	private java.lang.String emailId2;
	private java.lang.String emailId3;
	private java.lang.String url2;
	private java.lang.String url3;

	// many to one
	private jkt.hms.masters.business.MasDistrict district3;
	private jkt.hms.masters.business.MasDistrict city;
	private jkt.hms.masters.business.MasState state;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.MasState state3;
	private jkt.hms.masters.business.MasDistrict district2;
	private jkt.hms.masters.business.MasState state2;

	// collections
	private java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs;
	private java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs;
	private java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs;
	private java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturers;
	private java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs;
	private java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs;
	private java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails;
	private java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems;
	private java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="manufacturer_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: manufacturer_code
	 */
	public java.lang.String getManufacturerCode () {
		return manufacturerCode;
	}

	/**
	 * Set the value related to the column: manufacturer_code
	 * @param manufacturerCode the manufacturer_code value
	 */
	public void setManufacturerCode (java.lang.String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}



	/**
	 * Return the value associated with the column: manufacturer_name
	 */
	public java.lang.String getManufacturerName () {
		return manufacturerName;
	}

	/**
	 * Set the value related to the column: manufacturer_name
	 * @param manufacturerName the manufacturer_name value
	 */
	public void setManufacturerName (java.lang.String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}



	/**
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: last_chg_date
	 */
	public java.util.Date getLastChgDate () {
		return lastChgDate;
	}

	/**
	 * Set the value related to the column: last_chg_date
	 * @param lastChgDate the last_chg_date value
	 */
	public void setLastChgDate (java.util.Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}



	/**
	 * Return the value associated with the column: last_chg_time
	 */
	public java.lang.String getLastChgTime () {
		return lastChgTime;
	}

	/**
	 * Set the value related to the column: last_chg_time
	 * @param lastChgTime the last_chg_time value
	 */
	public void setLastChgTime (java.lang.String lastChgTime) {
		this.lastChgTime = lastChgTime;
	}



	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * @param address1 the address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
	}



	/**
	 * Return the value associated with the column: address2
	 */
	public java.lang.String getAddress2 () {
		return address2;
	}

	/**
	 * Set the value related to the column: address2
	 * @param address2 the address2 value
	 */
	public void setAddress2 (java.lang.String address2) {
		this.address2 = address2;
	}



	/**
	 * Return the value associated with the column: phoneno
	 */
	public java.lang.String getPhoneno () {
		return phoneno;
	}

	/**
	 * Set the value related to the column: phoneno
	 * @param phoneno the phoneno value
	 */
	public void setPhoneno (java.lang.String phoneno) {
		this.phoneno = phoneno;
	}



	/**
	 * Return the value associated with the column: mobileno
	 */
	public java.lang.String getMobileno () {
		return mobileno;
	}

	/**
	 * Set the value related to the column: mobileno
	 * @param mobileno the mobileno value
	 */
	public void setMobileno (java.lang.String mobileno) {
		this.mobileno = mobileno;
	}



	/**
	 * Return the value associated with the column: email_id
	 */
	public java.lang.String getEmailId () {
		return emailId;
	}

	/**
	 * Set the value related to the column: email_id
	 * @param emailId the email_id value
	 */
	public void setEmailId (java.lang.String emailId) {
		this.emailId = emailId;
	}



	/**
	 * Return the value associated with the column: fax_number
	 */
	public java.lang.String getFaxNumber () {
		return faxNumber;
	}

	/**
	 * Set the value related to the column: fax_number
	 * @param faxNumber the fax_number value
	 */
	public void setFaxNumber (java.lang.String faxNumber) {
		this.faxNumber = faxNumber;
	}



	/**
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: contact_person
	 */
	public java.lang.String getContactPerson () {
		return contactPerson;
	}

	/**
	 * Set the value related to the column: contact_person
	 * @param contactPerson the contact_person value
	 */
	public void setContactPerson (java.lang.String contactPerson) {
		this.contactPerson = contactPerson;
	}



	/**
	 * Return the value associated with the column: pin_code
	 */
	public java.lang.Integer getPinCode () {
		return pinCode;
	}

	/**
	 * Set the value related to the column: pin_code
	 * @param pinCode the pin_code value
	 */
	public void setPinCode (java.lang.Integer pinCode) {
		this.pinCode = pinCode;
	}



	/**
	 * Return the value associated with the column: licence_no
	 */
	public java.lang.String getLicenceNo () {
		return licenceNo;
	}

	/**
	 * Set the value related to the column: licence_no
	 * @param licenceNo the licence_no value
	 */
	public void setLicenceNo (java.lang.String licenceNo) {
		this.licenceNo = licenceNo;
	}



	/**
	 * Return the value associated with the column: sales_tax_no
	 */
	public java.lang.String getSalesTaxNo () {
		return salesTaxNo;
	}

	/**
	 * Set the value related to the column: sales_tax_no
	 * @param salesTaxNo the sales_tax_no value
	 */
	public void setSalesTaxNo (java.lang.String salesTaxNo) {
		this.salesTaxNo = salesTaxNo;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_name
	 */
	public java.lang.String getCfLocalDistributorName () {
		return cfLocalDistributorName;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_name
	 * @param cfLocalDistributorName the cf_local_distributor_name value
	 */
	public void setCfLocalDistributorName (java.lang.String cfLocalDistributorName) {
		this.cfLocalDistributorName = cfLocalDistributorName;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_address1
	 */
	public java.lang.String getCfLocalDistributorAddress1 () {
		return cfLocalDistributorAddress1;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_address1
	 * @param cfLocalDistributorAddress1 the cf_local_distributor_address1 value
	 */
	public void setCfLocalDistributorAddress1 (java.lang.String cfLocalDistributorAddress1) {
		this.cfLocalDistributorAddress1 = cfLocalDistributorAddress1;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_address2
	 */
	public java.lang.String getCfLocalDistributorAddress2 () {
		return cfLocalDistributorAddress2;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_address2
	 * @param cfLocalDistributorAddress2 the cf_local_distributor_address2 value
	 */
	public void setCfLocalDistributorAddress2 (java.lang.String cfLocalDistributorAddress2) {
		this.cfLocalDistributorAddress2 = cfLocalDistributorAddress2;
	}



	/**
	 * Return the value associated with the column: district_id
	 */
	public java.lang.Integer getDistrictId () {
		return districtId;
	}

	/**
	 * Set the value related to the column: district_id
	 * @param districtId the district_id value
	 */
	public void setDistrictId (java.lang.Integer districtId) {
		this.districtId = districtId;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_name2
	 */
	public java.lang.String getCfLocalDistributorName2 () {
		return cfLocalDistributorName2;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_name2
	 * @param cfLocalDistributorName2 the cf_local_distributor_name2 value
	 */
	public void setCfLocalDistributorName2 (java.lang.String cfLocalDistributorName2) {
		this.cfLocalDistributorName2 = cfLocalDistributorName2;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_name3
	 */
	public java.lang.String getCfLocalDistributorName3 () {
		return cfLocalDistributorName3;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_name3
	 * @param cfLocalDistributorName3 the cf_local_distributor_name3 value
	 */
	public void setCfLocalDistributorName3 (java.lang.String cfLocalDistributorName3) {
		this.cfLocalDistributorName3 = cfLocalDistributorName3;
	}



	/**
	 * Return the value associated with the column: cf_local_distributor_address3
	 */
	public java.lang.String getCfLocalDistributorAddress3 () {
		return cfLocalDistributorAddress3;
	}

	/**
	 * Set the value related to the column: cf_local_distributor_address3
	 * @param cfLocalDistributorAddress3 the cf_local_distributor_address3 value
	 */
	public void setCfLocalDistributorAddress3 (java.lang.String cfLocalDistributorAddress3) {
		this.cfLocalDistributorAddress3 = cfLocalDistributorAddress3;
	}



	/**
	 * Return the value associated with the column: pin_code2
	 */
	public java.lang.Integer getPinCode2 () {
		return pinCode2;
	}

	/**
	 * Set the value related to the column: pin_code2
	 * @param pinCode2 the pin_code2 value
	 */
	public void setPinCode2 (java.lang.Integer pinCode2) {
		this.pinCode2 = pinCode2;
	}



	/**
	 * Return the value associated with the column: pin_code3
	 */
	public java.lang.Integer getPinCode3 () {
		return pinCode3;
	}

	/**
	 * Set the value related to the column: pin_code3
	 * @param pinCode3 the pin_code3 value
	 */
	public void setPinCode3 (java.lang.Integer pinCode3) {
		this.pinCode3 = pinCode3;
	}



	/**
	 * Return the value associated with the column: mobileno2
	 */
	public java.lang.Integer getMobileno2 () {
		return mobileno2;
	}

	/**
	 * Set the value related to the column: mobileno2
	 * @param mobileno2 the mobileno2 value
	 */
	public void setMobileno2 (java.lang.Integer mobileno2) {
		this.mobileno2 = mobileno2;
	}



	/**
	 * Return the value associated with the column: mobileno3
	 */
	public java.lang.Integer getMobileno3 () {
		return mobileno3;
	}

	/**
	 * Set the value related to the column: mobileno3
	 * @param mobileno3 the mobileno3 value
	 */
	public void setMobileno3 (java.lang.Integer mobileno3) {
		this.mobileno3 = mobileno3;
	}



	/**
	 * Return the value associated with the column: tin_no1
	 */
	public java.lang.Integer getTinNo1 () {
		return tinNo1;
	}

	/**
	 * Set the value related to the column: tin_no1
	 * @param tinNo1 the tin_no1 value
	 */
	public void setTinNo1 (java.lang.Integer tinNo1) {
		this.tinNo1 = tinNo1;
	}



	/**
	 * Return the value associated with the column: tin_no2
	 */
	public java.lang.Integer getTinNo2 () {
		return tinNo2;
	}

	/**
	 * Set the value related to the column: tin_no2
	 * @param tinNo2 the tin_no2 value
	 */
	public void setTinNo2 (java.lang.Integer tinNo2) {
		this.tinNo2 = tinNo2;
	}



	/**
	 * Return the value associated with the column: tin_no3
	 */
	public java.lang.Integer getTinNo3 () {
		return tinNo3;
	}

	/**
	 * Set the value related to the column: tin_no3
	 * @param tinNo3 the tin_no3 value
	 */
	public void setTinNo3 (java.lang.Integer tinNo3) {
		this.tinNo3 = tinNo3;
	}



	/**
	 * Return the value associated with the column: licence_no2
	 */
	public java.lang.String getLicenceNo2 () {
		return licenceNo2;
	}

	/**
	 * Set the value related to the column: licence_no2
	 * @param licenceNo2 the licence_no2 value
	 */
	public void setLicenceNo2 (java.lang.String licenceNo2) {
		this.licenceNo2 = licenceNo2;
	}



	/**
	 * Return the value associated with the column: licence_no3
	 */
	public java.lang.String getLicenceNo3 () {
		return licenceNo3;
	}

	/**
	 * Set the value related to the column: licence_no3
	 * @param licenceNo3 the licence_no3 value
	 */
	public void setLicenceNo3 (java.lang.String licenceNo3) {
		this.licenceNo3 = licenceNo3;
	}



	/**
	 * Return the value associated with the column: email_id2
	 */
	public java.lang.String getEmailId2 () {
		return emailId2;
	}

	/**
	 * Set the value related to the column: email_id2
	 * @param emailId2 the email_id2 value
	 */
	public void setEmailId2 (java.lang.String emailId2) {
		this.emailId2 = emailId2;
	}



	/**
	 * Return the value associated with the column: email_id3
	 */
	public java.lang.String getEmailId3 () {
		return emailId3;
	}

	/**
	 * Set the value related to the column: email_id3
	 * @param emailId3 the email_id3 value
	 */
	public void setEmailId3 (java.lang.String emailId3) {
		this.emailId3 = emailId3;
	}



	/**
	 * Return the value associated with the column: url2
	 */
	public java.lang.String getUrl2 () {
		return url2;
	}

	/**
	 * Set the value related to the column: url2
	 * @param url2 the url2 value
	 */
	public void setUrl2 (java.lang.String url2) {
		this.url2 = url2;
	}



	/**
	 * Return the value associated with the column: url3
	 */
	public java.lang.String getUrl3 () {
		return url3;
	}

	/**
	 * Set the value related to the column: url3
	 * @param url3 the url3 value
	 */
	public void setUrl3 (java.lang.String url3) {
		this.url3 = url3;
	}



	/**
	 * Return the value associated with the column: district3_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict3 () {
		return district3;
	}

	/**
	 * Set the value related to the column: district3_id
	 * @param district3 the district3_id value
	 */
	public void setDistrict3 (jkt.hms.masters.business.MasDistrict district3) {
		this.district3 = district3;
	}



	/**
	 * Return the value associated with the column: city_id
	 */
	public jkt.hms.masters.business.MasDistrict getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city_id
	 * @param city the city_id value
	 */
	public void setCity (jkt.hms.masters.business.MasDistrict city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: state_id
	 */
	public jkt.hms.masters.business.MasState getState () {
		return state;
	}

	/**
	 * Set the value related to the column: state_id
	 * @param state the state_id value
	 */
	public void setState (jkt.hms.masters.business.MasState state) {
		this.state = state;
	}



	/**
	 * Return the value associated with the column: last_chg_by
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by
	 * @param lastChgBy the last_chg_by value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: state3_id
	 */
	public jkt.hms.masters.business.MasState getState3 () {
		return state3;
	}

	/**
	 * Set the value related to the column: state3_id
	 * @param state3 the state3_id value
	 */
	public void setState3 (jkt.hms.masters.business.MasState state3) {
		this.state3 = state3;
	}



	/**
	 * Return the value associated with the column: district2_id
	 */
	public jkt.hms.masters.business.MasDistrict getDistrict2 () {
		return district2;
	}

	/**
	 * Set the value related to the column: district2_id
	 * @param district2 the district2_id value
	 */
	public void setDistrict2 (jkt.hms.masters.business.MasDistrict district2) {
		this.district2 = district2;
	}



	/**
	 * Return the value associated with the column: state2_id
	 */
	public jkt.hms.masters.business.MasState getState2 () {
		return state2;
	}

	/**
	 * Set the value related to the column: state2_id
	 * @param state2 the state2_id value
	 */
	public void setState2 (jkt.hms.masters.business.MasState state2) {
		this.state2 = state2;
	}



	/**
	 * Return the value associated with the column: StoreIndentTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreIndentT> getStoreIndentTs () {
		return storeIndentTs;
	}

	/**
	 * Set the value related to the column: StoreIndentTs
	 * @param storeIndentTs the StoreIndentTs value
	 */
	public void setStoreIndentTs (java.util.Set<jkt.hms.masters.business.StoreIndentT> storeIndentTs) {
		this.storeIndentTs = storeIndentTs;
	}

	public void addToStoreIndentTs (jkt.hms.masters.business.StoreIndentT storeIndentT) {
		if (null == getStoreIndentTs()) setStoreIndentTs(new java.util.TreeSet<jkt.hms.masters.business.StoreIndentT>());
		getStoreIndentTs().add(storeIndentT);
	}



	/**
	 * Return the value associated with the column: StoreGrnTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreGrnT> getStoreGrnTs () {
		return storeGrnTs;
	}

	/**
	 * Set the value related to the column: StoreGrnTs
	 * @param storeGrnTs the StoreGrnTs value
	 */
	public void setStoreGrnTs (java.util.Set<jkt.hms.masters.business.StoreGrnT> storeGrnTs) {
		this.storeGrnTs = storeGrnTs;
	}

	public void addToStoreGrnTs (jkt.hms.masters.business.StoreGrnT storeGrnT) {
		if (null == getStoreGrnTs()) setStoreGrnTs(new java.util.TreeSet<jkt.hms.masters.business.StoreGrnT>());
		getStoreGrnTs().add(storeGrnT);
	}



	/**
	 * Return the value associated with the column: StoreLoaninTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreLoaninT> getStoreLoaninTs () {
		return storeLoaninTs;
	}

	/**
	 * Set the value related to the column: StoreLoaninTs
	 * @param storeLoaninTs the StoreLoaninTs value
	 */
	public void setStoreLoaninTs (java.util.Set<jkt.hms.masters.business.StoreLoaninT> storeLoaninTs) {
		this.storeLoaninTs = storeLoaninTs;
	}

	public void addToStoreLoaninTs (jkt.hms.masters.business.StoreLoaninT storeLoaninT) {
		if (null == getStoreLoaninTs()) setStoreLoaninTs(new java.util.TreeSet<jkt.hms.masters.business.StoreLoaninT>());
		getStoreLoaninTs().add(storeLoaninT);
	}



	/**
	 * Return the value associated with the column: MasStoreVendorWiseManufacturers
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> getMasStoreVendorWiseManufacturers () {
		return masStoreVendorWiseManufacturers;
	}

	/**
	 * Set the value related to the column: MasStoreVendorWiseManufacturers
	 * @param masStoreVendorWiseManufacturers the MasStoreVendorWiseManufacturers value
	 */
	public void setMasStoreVendorWiseManufacturers (java.util.Set<jkt.hms.masters.business.MasStoreVendorWiseManufacturer> masStoreVendorWiseManufacturers) {
		this.masStoreVendorWiseManufacturers = masStoreVendorWiseManufacturers;
	}

	public void addToMasStoreVendorWiseManufacturers (jkt.hms.masters.business.MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer) {
		if (null == getMasStoreVendorWiseManufacturers()) setMasStoreVendorWiseManufacturers(new java.util.TreeSet<jkt.hms.masters.business.MasStoreVendorWiseManufacturer>());
		getMasStoreVendorWiseManufacturers().add(masStoreVendorWiseManufacturer);
	}



	/**
	 * Return the value associated with the column: StoreDefectiveDrugTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> getStoreDefectiveDrugTs () {
		return storeDefectiveDrugTs;
	}

	/**
	 * Set the value related to the column: StoreDefectiveDrugTs
	 * @param storeDefectiveDrugTs the StoreDefectiveDrugTs value
	 */
	public void setStoreDefectiveDrugTs (java.util.Set<jkt.hms.masters.business.StoreDefectiveDrugT> storeDefectiveDrugTs) {
		this.storeDefectiveDrugTs = storeDefectiveDrugTs;
	}

	public void addToStoreDefectiveDrugTs (jkt.hms.masters.business.StoreDefectiveDrugT storeDefectiveDrugT) {
		if (null == getStoreDefectiveDrugTs()) setStoreDefectiveDrugTs(new java.util.TreeSet<jkt.hms.masters.business.StoreDefectiveDrugT>());
		getStoreDefectiveDrugTs().add(storeDefectiveDrugT);
	}



	/**
	 * Return the value associated with the column: StoreQuotationRequestTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> getStoreQuotationRequestTs () {
		return storeQuotationRequestTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationRequestTs
	 * @param storeQuotationRequestTs the StoreQuotationRequestTs value
	 */
	public void setStoreQuotationRequestTs (java.util.Set<jkt.hms.masters.business.StoreQuotationRequestT> storeQuotationRequestTs) {
		this.storeQuotationRequestTs = storeQuotationRequestTs;
	}

	public void addToStoreQuotationRequestTs (jkt.hms.masters.business.StoreQuotationRequestT storeQuotationRequestT) {
		if (null == getStoreQuotationRequestTs()) setStoreQuotationRequestTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationRequestT>());
		getStoreQuotationRequestTs().add(storeQuotationRequestT);
	}



	/**
	 * Return the value associated with the column: StoreQuotationReceiptTs
	 */
	public java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> getStoreQuotationReceiptTs () {
		return storeQuotationReceiptTs;
	}

	/**
	 * Set the value related to the column: StoreQuotationReceiptTs
	 * @param storeQuotationReceiptTs the StoreQuotationReceiptTs value
	 */
	public void setStoreQuotationReceiptTs (java.util.Set<jkt.hms.masters.business.StoreQuotationReceiptT> storeQuotationReceiptTs) {
		this.storeQuotationReceiptTs = storeQuotationReceiptTs;
	}

	public void addToStoreQuotationReceiptTs (jkt.hms.masters.business.StoreQuotationReceiptT storeQuotationReceiptT) {
		if (null == getStoreQuotationReceiptTs()) setStoreQuotationReceiptTs(new java.util.TreeSet<jkt.hms.masters.business.StoreQuotationReceiptT>());
		getStoreQuotationReceiptTs().add(storeQuotationReceiptT);
	}



	/**
	 * Return the value associated with the column: StorePoDetails
	 */
	public java.util.Set<jkt.hms.masters.business.StorePoDetail> getStorePoDetails () {
		return storePoDetails;
	}

	/**
	 * Set the value related to the column: StorePoDetails
	 * @param storePoDetails the StorePoDetails value
	 */
	public void setStorePoDetails (java.util.Set<jkt.hms.masters.business.StorePoDetail> storePoDetails) {
		this.storePoDetails = storePoDetails;
	}

	public void addToStorePoDetails (jkt.hms.masters.business.StorePoDetail storePoDetail) {
		if (null == getStorePoDetails()) setStorePoDetails(new java.util.TreeSet<jkt.hms.masters.business.StorePoDetail>());
		getStorePoDetails().add(storePoDetail);
	}



	/**
	 * Return the value associated with the column: MasStoreItems
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreItem> getMasStoreItems () {
		return masStoreItems;
	}

	/**
	 * Set the value related to the column: MasStoreItems
	 * @param masStoreItems the MasStoreItems value
	 */
	public void setMasStoreItems (java.util.Set<jkt.hms.masters.business.MasStoreItem> masStoreItems) {
		this.masStoreItems = masStoreItems;
	}

	public void addToMasStoreItems (jkt.hms.masters.business.MasStoreItem masStoreItem) {
		if (null == getMasStoreItems()) setMasStoreItems(new java.util.TreeSet<jkt.hms.masters.business.MasStoreItem>());
		getMasStoreItems().add(masStoreItem);
	}



	/**
	 * Return the value associated with the column: MasStoreBrands
	 */
	public java.util.Set<jkt.hms.masters.business.MasStoreBrand> getMasStoreBrands () {
		return masStoreBrands;
	}

	/**
	 * Set the value related to the column: MasStoreBrands
	 * @param masStoreBrands the MasStoreBrands value
	 */
	public void setMasStoreBrands (java.util.Set<jkt.hms.masters.business.MasStoreBrand> masStoreBrands) {
		this.masStoreBrands = masStoreBrands;
	}

	public void addToMasStoreBrands (jkt.hms.masters.business.MasStoreBrand masStoreBrand) {
		if (null == getMasStoreBrands()) setMasStoreBrands(new java.util.TreeSet<jkt.hms.masters.business.MasStoreBrand>());
		getMasStoreBrands().add(masStoreBrand);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.MasManufacturer)) return false;
		else {
			jkt.hms.masters.business.MasManufacturer masManufacturer = (jkt.hms.masters.business.MasManufacturer) obj;
			if (null == this.getId() || null == masManufacturer.getId()) return false;
			else return (this.getId().equals(masManufacturer.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}