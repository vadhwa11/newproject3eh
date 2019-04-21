package jkt.hms.masters.business.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the bl_package_header table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bl_package_header"
 */

public abstract class BaseBlPackageHeader  implements Serializable {

	public static String REF = "BlPackageHeader";
	public static String PROP_DISCOUNTED_VALUE_OF_MEDICINES = "DiscountedValueOfMedicines";
	public static String PROP_DISTRIBUTED_PKG_TARIFF = "DistributedPkgTariff";
	public static String PROP_LAST_CHG_BY = "LastChgBy";
	public static String PROP_ACCOUNT = "Account";
	public static String PROP_TO_AGE = "ToAge";
	public static String PROP_FROM_AGE = "FromAge";
	public static String PROP_PACKAGE_DESC = "PackageDesc";
	public static String PROP_TOTAL_VALUE_OF_MEDICINES = "TotalValueOfMedicines";
	public static String PROP_ADDITIONAL_MEDICINE_AMT = "AdditionalMedicineAmt";
	public static String PROP_TOTAL_VALUE_OF_PACKAGE = "TotalValueOfPackage";
	public static String PROP_EFFECTIVE_TO_DATE = "EffectiveToDate";
	public static String PROP_EFFECTIVE_FROM_DATE = "EffectiveFromDate";
	public static String PROP_PACKAGE_CODE = "PackageCode";
	public static String PROP_DISTRIBUTED_PKG_DISCOUNT = "DistributedPkgDiscount";
	public static String PROP_DISCOUNTED_VALUE_OF_PACKAGE = "DiscountedValueOfPackage";
	public static String PROP_LAST_CHG_DATE = "LastChgDate";
	public static String PROP_PACKAGE_DISCOUNT_TARIFF_PERCENT = "PackageDiscountTariffPercent";
	public static String PROP_DAYS = "Days";
	public static String PROP_DEPARTMENT = "Department";
	public static String PROP_LAST_CHG_TIME = "LastChgTime";
	public static String PROP_SEX = "Sex";
	public static String PROP_SCHEME = "Scheme";
	public static String PROP_TOTAL_VALUE_OF_SERVICES = "TotalValueOfServices";
	public static String PROP_HOSPITAL = "Hospital";
	public static String PROP_ICD_NAME = "IcdName";
	public static String PROP_STATUS = "Status";
	public static String PROP_FROZEN = "Frozen";
	public static String PROP_DISCOUNTED_VALUE_OF_SERVICES = "DiscountedValueOfServices";
	public static String PROP_ID = "Id";
	public static String PROP_PACKAGE_DISCOUNT_TARIFF_AMT = "PackageDiscountTariffAmt";
	public static String PROP_DISCOUNT_TYPE = "DiscountType";


	// constructors
	public BaseBlPackageHeader () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBlPackageHeader (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String packageCode;
	private java.lang.String packageDesc;
	private java.lang.String fromAge;
	private java.lang.String toAge;
	private java.util.Date effectiveFromDate;
	private java.util.Date effectiveToDate;
	private java.math.BigDecimal totalValueOfPackage;
	private java.math.BigDecimal discountedValueOfPackage;
	private java.math.BigDecimal totalValueOfServices;
	private java.math.BigDecimal discountedValueOfServices;
	private java.math.BigDecimal totalValueOfMedicines;
	private java.math.BigDecimal discountedValueOfMedicines;
	private java.math.BigDecimal packageDiscountTariffPercent;
	private java.math.BigDecimal distributedPkgDiscount;
	private java.math.BigDecimal distributedPkgTariff;
	private java.lang.String discountType;
	private java.math.BigDecimal packageDiscountTariffAmt;
	private java.util.Date lastChgDate;
	private java.lang.String lastChgTime;
	private java.lang.String status;
	private java.lang.String frozen;
	private java.math.BigDecimal additionalMedicineAmt;
	private java.math.BigDecimal days;
	private java.lang.String icdName;

	// many to one
	private jkt.hms.masters.business.MasHospital hospital;
	private jkt.hms.masters.business.MasDepartment department;
	private jkt.hms.masters.business.MasAdministrativeSex sex;
	private jkt.hms.masters.business.Users lastChgBy;
	private jkt.hms.masters.business.FaMasAccount account;
	private jkt.hms.masters.business.MasScheme scheme;

	// collections
	private java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> blPackageServicesDetails;
	private java.util.Set<jkt.hms.masters.business.BlPackageMedicineDetails> blPackageMedicineDetails;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="package_header_id"
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
	 * Return the value associated with the column: package_code
	 */
	public java.lang.String getPackageCode () {
		return packageCode;
	}

	/**
	 * Set the value related to the column: package_code
	 * @param packageCode the package_code value
	 */
	public void setPackageCode (java.lang.String packageCode) {
		this.packageCode = packageCode;
	}



	/**
	 * Return the value associated with the column: package_desc
	 */
	public java.lang.String getPackageDesc () {
		return packageDesc;
	}

	/**
	 * Set the value related to the column: package_desc
	 * @param packageDesc the package_desc value
	 */
	public void setPackageDesc (java.lang.String packageDesc) {
		this.packageDesc = packageDesc;
	}



	/**
	 * Return the value associated with the column: from_age
	 */
	public java.lang.String getFromAge () {
		return fromAge;
	}

	/**
	 * Set the value related to the column: from_age
	 * @param fromAge the from_age value
	 */
	public void setFromAge (java.lang.String fromAge) {
		this.fromAge = fromAge;
	}



	/**
	 * Return the value associated with the column: to_age
	 */
	public java.lang.String getToAge () {
		return toAge;
	}

	/**
	 * Set the value related to the column: to_age
	 * @param toAge the to_age value
	 */
	public void setToAge (java.lang.String toAge) {
		this.toAge = toAge;
	}



	/**
	 * Return the value associated with the column: effective_from_date
	 */
	public java.util.Date getEffectiveFromDate () {
		return effectiveFromDate;
	}

	/**
	 * Set the value related to the column: effective_from_date
	 * @param effectiveFromDate the effective_from_date value
	 */
	public void setEffectiveFromDate (java.util.Date effectiveFromDate) {
		this.effectiveFromDate = effectiveFromDate;
	}



	/**
	 * Return the value associated with the column: effective_to_date
	 */
	public java.util.Date getEffectiveToDate () {
		return effectiveToDate;
	}

	/**
	 * Set the value related to the column: effective_to_date
	 * @param effectiveToDate the effective_to_date value
	 */
	public void setEffectiveToDate (java.util.Date effectiveToDate) {
		this.effectiveToDate = effectiveToDate;
	}



	/**
	 * Return the value associated with the column: total_value_of_package
	 */
	public java.math.BigDecimal getTotalValueOfPackage () {
		return totalValueOfPackage;
	}

	/**
	 * Set the value related to the column: total_value_of_package
	 * @param totalValueOfPackage the total_value_of_package value
	 */
	public void setTotalValueOfPackage (java.math.BigDecimal totalValueOfPackage) {
		this.totalValueOfPackage = totalValueOfPackage;
	}



	/**
	 * Return the value associated with the column: discounted_value_of_package
	 */
	public java.math.BigDecimal getDiscountedValueOfPackage () {
		return discountedValueOfPackage;
	}

	/**
	 * Set the value related to the column: discounted_value_of_package
	 * @param discountedValueOfPackage the discounted_value_of_package value
	 */
	public void setDiscountedValueOfPackage (java.math.BigDecimal discountedValueOfPackage) {
		this.discountedValueOfPackage = discountedValueOfPackage;
	}



	/**
	 * Return the value associated with the column: total_value_of_services
	 */
	public java.math.BigDecimal getTotalValueOfServices () {
		return totalValueOfServices;
	}

	/**
	 * Set the value related to the column: total_value_of_services
	 * @param totalValueOfServices the total_value_of_services value
	 */
	public void setTotalValueOfServices (java.math.BigDecimal totalValueOfServices) {
		this.totalValueOfServices = totalValueOfServices;
	}



	/**
	 * Return the value associated with the column: discounted_value_of_services
	 */
	public java.math.BigDecimal getDiscountedValueOfServices () {
		return discountedValueOfServices;
	}

	/**
	 * Set the value related to the column: discounted_value_of_services
	 * @param discountedValueOfServices the discounted_value_of_services value
	 */
	public void setDiscountedValueOfServices (java.math.BigDecimal discountedValueOfServices) {
		this.discountedValueOfServices = discountedValueOfServices;
	}



	/**
	 * Return the value associated with the column: total_value_of_medicines
	 */
	public java.math.BigDecimal getTotalValueOfMedicines () {
		return totalValueOfMedicines;
	}

	/**
	 * Set the value related to the column: total_value_of_medicines
	 * @param totalValueOfMedicines the total_value_of_medicines value
	 */
	public void setTotalValueOfMedicines (java.math.BigDecimal totalValueOfMedicines) {
		this.totalValueOfMedicines = totalValueOfMedicines;
	}



	/**
	 * Return the value associated with the column: discounted_value_of_medicines
	 */
	public java.math.BigDecimal getDiscountedValueOfMedicines () {
		return discountedValueOfMedicines;
	}

	/**
	 * Set the value related to the column: discounted_value_of_medicines
	 * @param discountedValueOfMedicines the discounted_value_of_medicines value
	 */
	public void setDiscountedValueOfMedicines (java.math.BigDecimal discountedValueOfMedicines) {
		this.discountedValueOfMedicines = discountedValueOfMedicines;
	}



	/**
	 * Return the value associated with the column: package_discount_tariff_percent
	 */
	public java.math.BigDecimal getPackageDiscountTariffPercent () {
		return packageDiscountTariffPercent;
	}

	/**
	 * Set the value related to the column: package_discount_tariff_percent
	 * @param packageDiscountTariffPercent the package_discount_tariff_percent value
	 */
	public void setPackageDiscountTariffPercent (java.math.BigDecimal packageDiscountTariffPercent) {
		this.packageDiscountTariffPercent = packageDiscountTariffPercent;
	}



	/**
	 * Return the value associated with the column: distributed_pkg_discount
	 */
	public java.math.BigDecimal getDistributedPkgDiscount () {
		return distributedPkgDiscount;
	}

	/**
	 * Set the value related to the column: distributed_pkg_discount
	 * @param distributedPkgDiscount the distributed_pkg_discount value
	 */
	public void setDistributedPkgDiscount (java.math.BigDecimal distributedPkgDiscount) {
		this.distributedPkgDiscount = distributedPkgDiscount;
	}



	/**
	 * Return the value associated with the column: distributed_pkg_tariff
	 */
	public java.math.BigDecimal getDistributedPkgTariff () {
		return distributedPkgTariff;
	}

	/**
	 * Set the value related to the column: distributed_pkg_tariff
	 * @param distributedPkgTariff the distributed_pkg_tariff value
	 */
	public void setDistributedPkgTariff (java.math.BigDecimal distributedPkgTariff) {
		this.distributedPkgTariff = distributedPkgTariff;
	}



	/**
	 * Return the value associated with the column: discount_type
	 */
	public java.lang.String getDiscountType () {
		return discountType;
	}

	/**
	 * Set the value related to the column: discount_type
	 * @param discountType the discount_type value
	 */
	public void setDiscountType (java.lang.String discountType) {
		this.discountType = discountType;
	}



	/**
	 * Return the value associated with the column: package_discount_tariff_amt
	 */
	public java.math.BigDecimal getPackageDiscountTariffAmt () {
		return packageDiscountTariffAmt;
	}

	/**
	 * Set the value related to the column: package_discount_tariff_amt
	 * @param packageDiscountTariffAmt the package_discount_tariff_amt value
	 */
	public void setPackageDiscountTariffAmt (java.math.BigDecimal packageDiscountTariffAmt) {
		this.packageDiscountTariffAmt = packageDiscountTariffAmt;
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
	 * Return the value associated with the column: frozen
	 */
	public java.lang.String getFrozen () {
		return frozen;
	}

	/**
	 * Set the value related to the column: frozen
	 * @param frozen the frozen value
	 */
	public void setFrozen (java.lang.String frozen) {
		this.frozen = frozen;
	}



	/**
	 * Return the value associated with the column: additional_medicine_amt
	 */
	public java.math.BigDecimal getAdditionalMedicineAmt () {
		return additionalMedicineAmt;
	}

	/**
	 * Set the value related to the column: additional_medicine_amt
	 * @param additionalMedicineAmt the additional_medicine_amt value
	 */
	public void setAdditionalMedicineAmt (java.math.BigDecimal additionalMedicineAmt) {
		this.additionalMedicineAmt = additionalMedicineAmt;
	}



	/**
	 * Return the value associated with the column: days
	 */
	public java.math.BigDecimal getDays () {
		return days;
	}

	/**
	 * Set the value related to the column: days
	 * @param days the days value
	 */
	public void setDays (java.math.BigDecimal days) {
		this.days = days;
	}



	/**
	 * Return the value associated with the column: icd_name
	 */
	public java.lang.String getIcdName () {
		return icdName;
	}

	/**
	 * Set the value related to the column: icd_name
	 * @param icdName the icd_name value
	 */
	public void setIcdName (java.lang.String icdName) {
		this.icdName = icdName;
	}



	/**
	 * Return the value associated with the column: hospital_id
	 */
	public jkt.hms.masters.business.MasHospital getHospital () {
		return hospital;
	}

	/**
	 * Set the value related to the column: hospital_id
	 * @param hospital the hospital_id value
	 */
	public void setHospital (jkt.hms.masters.business.MasHospital hospital) {
		this.hospital = hospital;
	}



	/**
	 * Return the value associated with the column: department_id
	 */
	public jkt.hms.masters.business.MasDepartment getDepartment () {
		return department;
	}

	/**
	 * Set the value related to the column: department_id
	 * @param department the department_id value
	 */
	public void setDepartment (jkt.hms.masters.business.MasDepartment department) {
		this.department = department;
	}



	/**
	 * Return the value associated with the column: sex_id
	 */
	public jkt.hms.masters.business.MasAdministrativeSex getSex () {
		return sex;
	}

	/**
	 * Set the value related to the column: sex_id
	 * @param sex the sex_id value
	 */
	public void setSex (jkt.hms.masters.business.MasAdministrativeSex sex) {
		this.sex = sex;
	}



	/**
	 * Return the value associated with the column: last_chg_by_id
	 */
	public jkt.hms.masters.business.Users getLastChgBy () {
		return lastChgBy;
	}

	/**
	 * Set the value related to the column: last_chg_by_id
	 * @param lastChgBy the last_chg_by_id value
	 */
	public void setLastChgBy (jkt.hms.masters.business.Users lastChgBy) {
		this.lastChgBy = lastChgBy;
	}



	/**
	 * Return the value associated with the column: account_id
	 */
	public jkt.hms.masters.business.FaMasAccount getAccount () {
		return account;
	}

	/**
	 * Set the value related to the column: account_id
	 * @param account the account_id value
	 */
	public void setAccount (jkt.hms.masters.business.FaMasAccount account) {
		this.account = account;
	}



	/**
	 * Return the value associated with the column: scheme_id
	 */
	public jkt.hms.masters.business.MasScheme getScheme () {
		return scheme;
	}

	/**
	 * Set the value related to the column: scheme_id
	 * @param scheme the scheme_id value
	 */
	public void setScheme (jkt.hms.masters.business.MasScheme scheme) {
		this.scheme = scheme;
	}



	/**
	 * Return the value associated with the column: BlPackageServicesDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> getBlPackageServicesDetails () {
		return blPackageServicesDetails;
	}

	/**
	 * Set the value related to the column: BlPackageServicesDetails
	 * @param blPackageServicesDetails the BlPackageServicesDetails value
	 */
	public void setBlPackageServicesDetails (java.util.Set<jkt.hms.masters.business.BlPackageServicesDetails> blPackageServicesDetails) {
		this.blPackageServicesDetails = blPackageServicesDetails;
	}

	public void addToBlPackageServicesDetails (jkt.hms.masters.business.BlPackageServicesDetails blPackageServicesDetails) {
		if (null == getBlPackageServicesDetails()) setBlPackageServicesDetails(new java.util.TreeSet<jkt.hms.masters.business.BlPackageServicesDetails>());
		getBlPackageServicesDetails().add(blPackageServicesDetails);
	}



	/**
	 * Return the value associated with the column: BlPackageMedicineDetails
	 */
	public java.util.Set<jkt.hms.masters.business.BlPackageMedicineDetails> getBlPackageMedicineDetails () {
		return blPackageMedicineDetails;
	}

	/**
	 * Set the value related to the column: BlPackageMedicineDetails
	 * @param blPackageMedicineDetails the BlPackageMedicineDetails value
	 */
	public void setBlPackageMedicineDetails (java.util.Set<jkt.hms.masters.business.BlPackageMedicineDetails> blPackageMedicineDetails) {
		this.blPackageMedicineDetails = blPackageMedicineDetails;
	}

	public void addToBlPackageMedicineDetails (jkt.hms.masters.business.BlPackageMedicineDetails blPackageMedicineDetails) {
		if (null == getBlPackageMedicineDetails()) setBlPackageMedicineDetails(new java.util.TreeSet<jkt.hms.masters.business.BlPackageMedicineDetails>());
		getBlPackageMedicineDetails().add(blPackageMedicineDetails);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof jkt.hms.masters.business.BlPackageHeader)) return false;
		else {
			jkt.hms.masters.business.BlPackageHeader blPackageHeader = (jkt.hms.masters.business.BlPackageHeader) obj;
			if (null == this.getId() || null == blPackageHeader.getId()) return false;
			else return (this.getId().equals(blPackageHeader.getId()));
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