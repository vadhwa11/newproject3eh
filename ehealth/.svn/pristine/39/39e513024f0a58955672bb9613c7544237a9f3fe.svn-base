package jkt.hms.billing.dataservice;

import static jkt.hms.util.RequestConstants.ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.ADDITIONAL_MEDICINE_AMOUNT;
import static jkt.hms.util.RequestConstants.ADVANCE_ADJUSTMENT;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.AGE;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.AMOUNT_RECEIVED;
import static jkt.hms.util.RequestConstants.AUTHORIZER_ID;
import static jkt.hms.util.RequestConstants.BANK_NAME;
import static jkt.hms.util.RequestConstants.BATCH_ID;
import static jkt.hms.util.RequestConstants.BATCH_ITEM_ID;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.CHEQUE_DATE;
import static jkt.hms.util.RequestConstants.CHEQUE_NO;
import static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DISCOUNTED_VALUE_PACKAGE;
import static jkt.hms.util.RequestConstants.DISCOUNT_ON;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.DISCOUNT_TYPE;
import static jkt.hms.util.RequestConstants.DISCOUNT_VALUE;
import static jkt.hms.util.RequestConstants.DISPENSING_PRICE;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_FROM;
import static jkt.hms.util.RequestConstants.EFFECTIVE_DATE_TO;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.FA_ACCOUNT_ID;
import static jkt.hms.util.RequestConstants.FA_SUB_LED_ID;
import static jkt.hms.util.RequestConstants.FROM_AGE;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.ISSUE_QUANTITY;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.NET_VALUE_MEDICINES;
import static jkt.hms.util.RequestConstants.NET_VALUE_PACKAGE;
import static jkt.hms.util.RequestConstants.NET_VALUE_SERVICES;
import static jkt.hms.util.RequestConstants.OUTSTANDING;
import static jkt.hms.util.RequestConstants.PACKAGE_CODE;
import static jkt.hms.util.RequestConstants.PACKAGE_DESCRIPTION;
import static jkt.hms.util.RequestConstants.PACKAGE_ID;
import static jkt.hms.util.RequestConstants.PACKAGE_MEDICINE_ID;
import static jkt.hms.util.RequestConstants.PACKAGE_SERVICE_ID;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PAYMENT_MODE;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.RATE;
import static jkt.hms.util.RequestConstants.ROUND_OF_VALUE;
import static jkt.hms.util.RequestConstants.SEX_ID;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_AGE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import jkt.hms.masters.business.BlChargeSlipDetail;
import jkt.hms.masters.business.BlChargeSlipMain;
import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.BlDispensingHeader;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.BlPackageBill;
import jkt.hms.masters.business.BlPackageHeader;
import jkt.hms.masters.business.BlPackageMedicineDetails;
import jkt.hms.masters.business.BlPackageServicesDetails;
import jkt.hms.masters.business.BlParameter;
import jkt.hms.masters.business.BlReceiptDetails;
import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DiagParam;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaMasVoucherType;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.FaVoucherHeader;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PackageBillingDataServiceImpl extends HibernateDaoSupport
		implements PackageBillingDataService {

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPackageMasterList() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		Session session = getSession();

		try {
			packageList = session.createCriteria(BlPackageHeader.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("packageList", packageList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForPackageMaster() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<MasScheme> schemeList = new ArrayList<MasScheme>(); // added by Amit Das on 07-03-2016
		
		Session session = getSession();

		try {
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			accountList = session.createCriteria(FaMasAccount.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			schemeList = session.createCriteria(MasScheme.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).add(Restrictions.eq("PackageFlag", "y").ignoreCase()).list(); // added by Amit Das on 07-03-2016
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        System.out.println("departmentList"+departmentList.size());
		map.put("departmentList", departmentList);
		map.put("sexList", sexList);
		map.put("accountList", accountList);
		map.put("schemeList", schemeList); // added by Amit Das on 07-03-2016
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> savePackageDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		Session session = getSession();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_AUTO");
		hbt.setCheckWriteOperations(false);

		try {
			BlPackageHeader blPackageHeader = new BlPackageHeader();

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			blPackageHeader.setHospital(hospital);

			blPackageHeader.setPackageCode(box.getString(PACKAGE_CODE));
			blPackageHeader.setPackageDesc(box.getString(PACKAGE_DESCRIPTION));
			//blPackageHeader.setFromAge(box.getString(FROM_AGE));
			//blPackageHeader.setToAge(box.getString(TO_AGE));
			
			if (!box.getString("icdname").equals("")) {
				blPackageHeader.setIcdName(box.getString("icdname"));
			}
			if (!box.getString("days").equals("")) {
				blPackageHeader.setDays(new BigDecimal(box.getString("days")));
			}
			if (!box.getString("rate").equals("")) {
				blPackageHeader.setTotalValueOfPackage(new BigDecimal(box.getString("rate")));
			}
			
			if (!box.getString(EFFECTIVE_DATE_FROM).equals("")) {
				blPackageHeader.setEffectiveFromDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(EFFECTIVE_DATE_FROM)));
			}
			if (!box.getString(EFFECTIVE_DATE_TO).equals("")) {
				blPackageHeader.setEffectiveToDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(EFFECTIVE_DATE_TO)));
			}

			if (box.getInt(DEPARTMENT_ID) != 0) {
				MasDepartment department = new MasDepartment();
				department.setId(box.getInt(DEPARTMENT_ID));
				blPackageHeader.setDepartment(department);
			}
			if (box.getInt(SEX_ID) != 0) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
				administrativeSex.setId(box.getInt(SEX_ID));
				blPackageHeader.setSex(administrativeSex);
			}
			// added by Amit Das on 07-03-2016
			if (box.getInt("schemeId") != 0) {
				MasScheme scheme = new MasScheme();
				scheme.setId(box.getInt("schemeId"));
				blPackageHeader.setScheme(scheme);
			}

			if (box.getInt(ACCOUNT_ID) != 0) {
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				blPackageHeader.setAccount(masAccount);
			}
			if (!box.getString(ADDITIONAL_MEDICINE_AMOUNT).equals("")) {
				blPackageHeader.setAdditionalMedicineAmt(new BigDecimal(box
						.getString(ADDITIONAL_MEDICINE_AMOUNT)));
			}
			Users user = new Users();
			user.setId(box.getInt("userId"));
			blPackageHeader.setLastChgBy(user);
			blPackageHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			blPackageHeader.setLastChgTime(box.getString(CHANGED_TIME));
			blPackageHeader.setStatus("y");

			hbt.save(blPackageHeader);
			hbt.flush();
			hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		try {
			packageList = session.createCriteria(BlPackageHeader.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Saved Successfully!";
		} else {
			message = "Try Again!";
		}
		map.put("packageList", packageList);
		map.put("message", message);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForPackageServices(int packageId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>();
		List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasChargeCode> chargeList = new ArrayList<MasChargeCode>();

		Session session = getSession();

		packageServicesList = session
				.createCriteria(BlPackageServicesDetails.class)
				.createAlias("PackageHeader", "ph")
				.add(Restrictions.eq("ph.Id", packageId)).list();
		mainChargeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		subChargeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		chargeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		for (MasChargeCode chargeCode : chargeList) {
			if (chargeCode.getChargeType().getChargeTypeCode().equals("DIAG")) {
				if (chargeCode.getDgMasInvestigations() != null
						|| chargeCode.getDgMasInvestigations().size() > 0) {
					chargeCodeList.add(chargeCode);
				}
			} else {
				chargeCodeList.add(chargeCode);
			}
		}

		map.put("packageServicesList", packageServicesList);
		map.put("mainChargeList", mainChargeList);
		map.put("subChargeList", subChargeList);
		map.put("chargeCodeList", chargeCodeList);
		return map;
	}

	public Map<String, Object> savePackageServices(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		BlPackageHeader blPackageHeader = new BlPackageHeader();
		try {
			BlPackageServicesDetails packageServicesDetails = new BlPackageServicesDetails();

			BlPackageHeader packageHeader = new BlPackageHeader();
			packageHeader.setId(box.getInt(PACKAGE_ID));
			packageServicesDetails.setPackageHeader(packageHeader);

			MasChargeCode chargeCode = new MasChargeCode();
			chargeCode.setId(box.getInt(CHARGE_CODE_ID));
			packageServicesDetails.setChargeCode(chargeCode);
			if (box.getString(RATE)!=null&&!box.getString(RATE).equals("") ) {
				packageServicesDetails.setRate(new BigDecimal(box
						.getString(RATE)));
			}
			//packageServicesDetails.setRate(new BigDecimal(box.getString(RATE)));
			packageServicesDetails.setQuantity(box.getInt(QUANTITY));
			if (!box.getString(AMOUNT).equals("") ) {
				packageServicesDetails.setChargeAmount(new BigDecimal(box
						.getString(AMOUNT)));
			}
			/*packageServicesDetails.setChargeAmount(new BigDecimal(box
					.getString(AMOUNT)));*/
			/*packageServicesDetails.setChargeAmount(new BigDecimal(box
					.getString(AMOUNT)));*/
			if (!box.getString(DISCOUNT_TYPE).equals("")) {
				packageServicesDetails.setDiscountType(
						box.getString(DISCOUNT_TYPE));
			}
			/*packageServicesDetails
					.setDiscountType(box.getString(DISCOUNT_TYPE));*/
			if (!box.getString(DISCOUNT_VALUE).equals("")) {
				packageServicesDetails.setDiscountAmount(new BigDecimal(box
						.getString(DISCOUNT_VALUE)));
			}

			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				packageServicesDetails.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_PERCENTAGE)));
			}
			if (!box.getString(NET_VALUE_SERVICES).equals("")) {
				packageServicesDetails.setNetChargeAmt(new BigDecimal(box
						.getString(NET_VALUE_SERVICES)));
			}

			Users user = new Users();
			user.setId(box.getInt("userId"));
			packageServicesDetails.setLastChgBy(user);
			packageServicesDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			packageServicesDetails.setLastChgTime(box.getString(CHANGED_TIME));
			packageServicesDetails.setStatus("y");

			hbt.save(packageServicesDetails);

			BigDecimal totalValueOfServices = new BigDecimal(0);
			BigDecimal totalValueOfPackage = new BigDecimal(0);
			BigDecimal valueOfServices = new BigDecimal(0);
			BigDecimal valueOfPackage = new BigDecimal(0);
			BigDecimal discValueOfServices = new BigDecimal(0);
			BigDecimal discValueOfPackage = new BigDecimal(0);

			blPackageHeader = (BlPackageHeader) hbt.load(BlPackageHeader.class,
					box.getInt(PACKAGE_ID));
			if (blPackageHeader.getTotalValueOfServices() != null) {
				valueOfServices = blPackageHeader.getTotalValueOfServices();
			}

			if (blPackageHeader.getTotalValueOfPackage() != null) {
				valueOfPackage = blPackageHeader.getTotalValueOfPackage();
			}

			if (blPackageHeader.getDiscountedValueOfServices() != null) {
				discValueOfServices = blPackageHeader
						.getDiscountedValueOfServices();
			}

			if (blPackageHeader.getDiscountedValueOfPackage() != null) {
				discValueOfPackage = blPackageHeader
						.getDiscountedValueOfPackage();
			}
			
			/*blPackageHeader.setTotalValueOfServices(new BigDecimal(box
					.getString(AMOUNT)));*/
			totalValueOfServices = valueOfServices.add(new BigDecimal(box
					.getString(AMOUNT)));
			blPackageHeader.setTotalValueOfServices(totalValueOfServices);
			/*totalValueOfPackage = valueOfPackage.add(new BigDecimal(box
					.getString(AMOUNT)));
			blPackageHeader.setTotalValueOfPackage(totalValueOfPackage);*/

			/*blPackageHeader.setDiscountedValueOfPackage(discValueOfPackage
					.add(new BigDecimal(box.getString(NET_VALUE_SERVICES))));
			blPackageHeader.setDiscountedValueOfServices(discValueOfServices
					.add(new BigDecimal(box.getString(NET_VALUE_SERVICES))));*/

			BigDecimal pkgDiscount = new BigDecimal(0);
			BigDecimal pkgTariff = new BigDecimal(0);

			if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
				if (blPackageHeader.getDistributedPkgDiscount() != null) {
					pkgDiscount = blPackageHeader.getDistributedPkgDiscount();
				}
				blPackageHeader.setDistributedPkgDiscount(pkgDiscount
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
				if (blPackageHeader.getDistributedPkgTariff() != null) {
					pkgTariff = blPackageHeader.getDistributedPkgTariff();
				}
				blPackageHeader.setDistributedPkgTariff(pkgTariff
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			}

			hbt.update(blPackageHeader);

			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Saved Successfully!";
		} else {
			message = "Try Again!";
		}
		map = getDetailsForPackageServices(box.getInt(PACKAGE_ID));
		map.put("message", message);
		map.put("packageCode", blPackageHeader.getPackageCode());
		map.put("packageDesc", blPackageHeader.getPackageDesc());
		return map;
	}

	public Map<String, Object> updatePackageServices(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BlPackageServicesDetails packageServicesDetails = (BlPackageServicesDetails) hbt
					.load(BlPackageServicesDetails.class,
							box.getInt(PACKAGE_SERVICE_ID));

			packageServicesDetails.setQuantity(box.getInt(QUANTITY));
			packageServicesDetails
					.setDiscountType(box.getString(DISCOUNT_TYPE));
			if (!box.getString(DISCOUNT_VALUE).equals("")) {
				packageServicesDetails.setDiscountAmount(new BigDecimal(box
						.getString(DISCOUNT_VALUE)));
			}

			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				packageServicesDetails.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_PERCENTAGE)));
			}
			if (box.getString(NET_VALUE_SERVICES)!=null && !box.getString(NET_VALUE_SERVICES).equals("")) {
				packageServicesDetails.setNetChargeAmt(new BigDecimal(box
						.getString(NET_VALUE_SERVICES)));
			}
			if (!box.getString(AMOUNT).equals("") ) {
				packageServicesDetails.setChargeAmount(new BigDecimal(box
						.getString(AMOUNT)));
			}
			/*packageServicesDetails.setNetChargeAmt(new BigDecimal(box
					.getString(NET_VALUE_SERVICES)));*/
			Users user = new Users();
			user.setId(box.getInt("userId"));
			packageServicesDetails.setLastChgBy(user);
			packageServicesDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			packageServicesDetails.setLastChgTime(box.getString(CHANGED_TIME));
			packageServicesDetails.setStatus("y");

			hbt.update(packageServicesDetails);

			BigDecimal totalValueOfServices = new BigDecimal(0);
			BigDecimal totalValueOfPackage = new BigDecimal(0);
			BigDecimal valueOfServices = new BigDecimal(0);
			BigDecimal valueOfPackage = new BigDecimal(0);
			BigDecimal discValueOfServices = new BigDecimal(0);
			BigDecimal discValueOfPackage = new BigDecimal(0);

			BlPackageHeader blPackageHeader = (BlPackageHeader) hbt.load(
					BlPackageHeader.class, box.getInt(PACKAGE_ID));
			if (blPackageHeader.getTotalValueOfServices() != null) {
				valueOfServices = blPackageHeader.getTotalValueOfServices();
			}

			if (blPackageHeader.getTotalValueOfPackage() != null) {
				valueOfPackage = blPackageHeader.getTotalValueOfPackage();
			}

			if (blPackageHeader.getDiscountedValueOfServices() != null) {
				discValueOfServices = blPackageHeader
						.getDiscountedValueOfServices();
			}

			if (blPackageHeader.getDiscountedValueOfPackage() != null) {
				discValueOfPackage = blPackageHeader
						.getDiscountedValueOfPackage();
			}
			/*totalValueOfServices = valueOfServices.add(new BigDecimal(box
					.getString(AMOUNT)));
			blPackageHeader.setTotalValueOfServices(totalValueOfServices);*/
			valueOfServices = valueOfServices.subtract(new BigDecimal(box
					.getString("prevChargeAmount")));
			totalValueOfServices = valueOfServices.add(new BigDecimal(box
					.getString(AMOUNT)));
			blPackageHeader.setTotalValueOfServices(totalValueOfServices);

			/*valueOfPackage = valueOfPackage.subtract(new BigDecimal(box
					.getString("prevChargeAmount")));
			totalValueOfPackage = valueOfPackage.add(new BigDecimal(box
					.getString(AMOUNT)));
			blPackageHeader.setTotalValueOfPackage(totalValueOfPackage);

			discValueOfPackage = discValueOfPackage.subtract(new BigDecimal(box
					.getString("prevDiscountAmount")));
			discValueOfServices = discValueOfServices.subtract(new BigDecimal(
					box.getString("prevDiscountAmount")));
			blPackageHeader.setDiscountedValueOfPackage(discValueOfPackage
					.add(new BigDecimal(box.getString(NET_VALUE_SERVICES))));
			blPackageHeader.setDiscountedValueOfServices(discValueOfServices
					.add(new BigDecimal(box.getString(NET_VALUE_SERVICES))));*/

			BigDecimal pkgDiscount = new BigDecimal(0);
			BigDecimal pkgTariff = new BigDecimal(0);

			if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
				if (blPackageHeader.getDistributedPkgDiscount() != null) {
					pkgDiscount = blPackageHeader.getDistributedPkgDiscount();
				}
				pkgDiscount = pkgDiscount.subtract(new BigDecimal(box
						.getString("prevDiscountValue")));
				blPackageHeader.setDistributedPkgDiscount(pkgDiscount
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
				if (blPackageHeader.getDistributedPkgTariff() != null) {
					pkgTariff = blPackageHeader.getDistributedPkgTariff();
				}
				pkgTariff = pkgTariff.subtract(new BigDecimal(box
						.getString("prevDiscountValue")));
				blPackageHeader.setDistributedPkgTariff(pkgTariff
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			}

			hbt.update(blPackageHeader);
            hbt.flush();
            hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Updated Successfully!";
		} else {
			message = "Try Again!";
		}
		map = getDetailsForPackageServices(box.getInt(PACKAGE_ID));
		map.put("message", message);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForPackageMedicines(int packageId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageMedicineDetails> packageMedicinesList = new ArrayList<BlPackageMedicineDetails>();
		List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		List<MasStoreGroup> itemGroupList = new ArrayList<MasStoreGroup>();
		List<MasStoreItemGeneric> itemGenList = new ArrayList<MasStoreItemGeneric>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();

		Session session = getSession();
		packageMedicinesList = session
				.createCriteria(BlPackageMedicineDetails.class)
				.createAlias("PackageHeader", "ph")
				.add(Restrictions.eq("ph.Id", packageId)).list();
		itemTypeList = session.createCriteria(MasItemType.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemGroupList = session.createCriteria(MasStoreGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		itemGenList = session.createCriteria(MasStoreItemGeneric.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		itemCategoryList = session.createCriteria(MasItemCategory.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		String qry = "";
		qry = "Select item_id,nomenclature,mic.item_category_id from mas_store_item msi  "
				+ " left join mas_item_category mic on msi.item_category_id = mic.item_category_id where msi.status='y'and msi.nomenclature is not null";

		itemList = session.createSQLQuery(qry).list();
		 System.out.println("itemList"+itemList.size());

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		map.put("packageMedicinesList", packageMedicinesList);
		map.put("itemCategoryList", itemCategoryList);
		map.put("itemTypeList", itemTypeList);
		map.put("itemGroupList", itemGroupList);
		map.put("itemGenList", itemGenList);
		map.put("itemList", itemList);
		map.put("departmentList", departmentList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getItemName(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemGroupId = 0;
		int itemGenericId = 0;

		itemTypeId = box.getInt("itemType");
		itemCategoryId = box.getInt("itemCategory");
		itemGroupId = box.getInt("itemGroup");
		itemGenericId = box.getInt("itemGeneric");

		Session session = getSession();
		try {
			Criteria crit = session.createCriteria(MasStoreItem.class);

			if (itemTypeId != 0) {
				crit = crit.createAlias("ItemType", "it").add(
						Restrictions.eq("it.Id", itemTypeId));
			}
			if (itemCategoryId != 0) {
				crit = crit.createAlias("ItemCategory", "ic").add(
						Restrictions.eq("ic.Id", itemCategoryId));
			}
			if (itemGroupId != 0) {
				crit = crit.createAlias("Group", "ig").add(
						Restrictions.eq("ig.Id", itemGroupId));
			}

			if (itemGenericId != 0) {
				crit = crit.createAlias("ItemGeneric", "gen").add(
						Restrictions.eq("gen.Id", itemGenericId));
			}

			itemList = crit.list();

			if (itemList.size() > 0) {
				map.put("itemList", itemList);
			}
		} catch (DataAccessResourceFailureException e) {
			e.printStackTrace();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		return map;
	}

	public Map<String, Object> savePackageMedicines(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BlPackageMedicineDetails packageMedicinesDetails = new BlPackageMedicineDetails();

			BlPackageHeader packageHeader = new BlPackageHeader();
			packageHeader.setId(box.getInt(PACKAGE_ID));
			packageMedicinesDetails.setPackageHeader(packageHeader);

			MasStoreItem storeItem = new MasStoreItem();
			storeItem.setId(box.getInt(ITEM_ID));
			packageMedicinesDetails.setItem(storeItem);

			/*MasDepartment department = new MasDepartment();
			department.setId(box.getInt(DEPARTMENT_ID));
			packageMedicinesDetails.setDepartment(department);*/
			if (!box.getString(RATE).equals("")) {
				packageMedicinesDetails.setDispensingPrice(new BigDecimal(box
						.getString(RATE)));
			}
			if (!box.getString(DISCOUNT_TYPE).equals("")) {
				packageMedicinesDetails.setDiscountType(box
						.getString(DISCOUNT_TYPE));
			}
			if (!box.getString(DISPENSING_PRICE).equals("")) {
				packageMedicinesDetails.setItemAmount(new BigDecimal(box
						.getString(DISPENSING_PRICE)));
			}
			if (!box.getString(QUANTITY).equals("")) {
				packageMedicinesDetails.setQuantity(new BigDecimal(box
						.getString(QUANTITY)));
			}
			/*packageMedicinesDetails.setDispensingPrice(new BigDecimal(box
					.getString(RATE)));*/
			/*packageMedicinesDetails.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));*/
			/*packageMedicinesDetails.setItemAmount(new BigDecimal(box
					.getString(DISPENSING_PRICE)));*/
			/*packageMedicinesDetails.setDiscountType(box
					.getString(DISCOUNT_TYPE));*/
			if (!box.getString(DISCOUNT_VALUE).equals("")) {
				packageMedicinesDetails.setDiscountAmount(new BigDecimal(box
						.getString(DISCOUNT_VALUE)));
			}

			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				packageMedicinesDetails.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_PERCENTAGE)));
			}
			if (!box.getString(NET_VALUE_MEDICINES).equals("")) {
				packageMedicinesDetails.setNetItemAmt(new BigDecimal(box
						.getString(NET_VALUE_MEDICINES)));
			}
			/*packageMedicinesDetails.setNetItemAmt(new BigDecimal(box
					.getString(NET_VALUE_MEDICINES)));*/
			Users user = new Users();
			user.setId(box.getInt("userId"));
			packageMedicinesDetails.setLastChgBy(user);
			packageMedicinesDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			packageMedicinesDetails.setLastChgTime(box.getString(CHANGED_TIME));
			packageMedicinesDetails.setStatus("y");

			hbt.save(packageMedicinesDetails);

			BigDecimal totalValueOfMedicines = new BigDecimal(0);
			BigDecimal totalValueOfPackage = new BigDecimal(0);
			BigDecimal valueOfMedicines = new BigDecimal(0);
			BigDecimal valueOfPackage = new BigDecimal(0);
			BigDecimal discValueOfMedicines = new BigDecimal(0);
			BigDecimal discValueOfPackage = new BigDecimal(0);

			BlPackageHeader blPackageHeader = (BlPackageHeader) hbt.load(
					BlPackageHeader.class, box.getInt(PACKAGE_ID));
			if (blPackageHeader.getTotalValueOfMedicines() != null) {
				valueOfMedicines = blPackageHeader.getTotalValueOfMedicines();
			}

			if (blPackageHeader.getTotalValueOfPackage() != null) {
				valueOfPackage = blPackageHeader.getTotalValueOfPackage();
			}

			if (blPackageHeader.getDiscountedValueOfMedicines() != null) {
				discValueOfMedicines = blPackageHeader
						.getDiscountedValueOfMedicines();
			}

			if (blPackageHeader.getDiscountedValueOfPackage() != null) {
				discValueOfPackage = blPackageHeader
						.getDiscountedValueOfPackage();
			}

			totalValueOfMedicines = valueOfMedicines.add(new BigDecimal(box
					.getString(DISPENSING_PRICE)));
			blPackageHeader.setTotalValueOfMedicines(totalValueOfMedicines);
			/*totalValueOfPackage = valueOfPackage.add(new BigDecimal(box
					.getString(DISPENSING_PRICE)));
			blPackageHeader.setTotalValueOfPackage(totalValueOfPackage);*/
            if(box.getString(NET_VALUE_MEDICINES)!=null &&!box.getString(NET_VALUE_MEDICINES).equals("")){
			blPackageHeader.setDiscountedValueOfPackage(discValueOfPackage
					.add(new BigDecimal(box.getString(NET_VALUE_MEDICINES))));
			blPackageHeader.setDiscountedValueOfMedicines(discValueOfMedicines
					.add(new BigDecimal(box.getString(NET_VALUE_MEDICINES))));
            }
			BigDecimal pkgDiscount = new BigDecimal(0);
			BigDecimal pkgTariff = new BigDecimal(0);

			if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
				if (blPackageHeader.getDistributedPkgDiscount() != null) {
					pkgDiscount = blPackageHeader.getDistributedPkgDiscount();
				}
				blPackageHeader.setDistributedPkgDiscount(pkgDiscount
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
				if (blPackageHeader.getDistributedPkgTariff() != null) {
					pkgTariff = blPackageHeader.getDistributedPkgTariff();
				}
				blPackageHeader.setDistributedPkgTariff(pkgTariff
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			}

			hbt.update(blPackageHeader);

			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Saved Successfully!";
		} else {
			message = "Try Again!";
		}
		map = getDetailsForPackageMedicines(box.getInt(PACKAGE_ID));
		map.put("message", message);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDispensingPriceForItem(int itemId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BigDecimal> dispensingPriceList = new ArrayList<BigDecimal>();

		Session session = getSession();
		dispensingPriceList = session.createCriteria(StoreItemBatchStock.class)
				.createAlias("Item", "i").add(Restrictions.eq("i.Id", itemId))
				.setProjection(Projections.max("CostPrice")).list();
		map.put("dispensingPriceList", dispensingPriceList);
		return map;
	}

	public Map<String, Object> updatePackageMedicines(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BlPackageMedicineDetails packageMedicinesDetails = (BlPackageMedicineDetails) hbt
					.load(BlPackageMedicineDetails.class,
							box.getInt(PACKAGE_MEDICINE_ID));

			packageMedicinesDetails.setQuantity(new BigDecimal(box
					.getString(QUANTITY)));
			packageMedicinesDetails.setDiscountType(box
					.getString(DISCOUNT_TYPE));
			packageMedicinesDetails.setItemAmount(new BigDecimal(box
					.getString(DISPENSING_PRICE)));
			if (!box.getString(DISCOUNT_VALUE).equals("")) {
				packageMedicinesDetails.setDiscountAmount(new BigDecimal(box
						.getString(DISCOUNT_VALUE)));
			}

			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				packageMedicinesDetails.setDiscountPercent(new BigDecimal(box
						.getString(DISCOUNT_PERCENTAGE)));
			}

			packageMedicinesDetails.setNetItemAmt(new BigDecimal(box
					.getString(NET_VALUE_MEDICINES)));
			Users user = new Users();
			user.setId(box.getInt("userId"));
			packageMedicinesDetails.setLastChgBy(user);
			packageMedicinesDetails.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			packageMedicinesDetails.setLastChgTime(box.getString(CHANGED_TIME));
			packageMedicinesDetails.setStatus("y");

			hbt.update(packageMedicinesDetails);

			BigDecimal totalValueOfMedicines = new BigDecimal(0);
			BigDecimal totalValueOfPackage = new BigDecimal(0);
			BigDecimal valueOfMedicines = new BigDecimal(0);
			BigDecimal valueOfPackage = new BigDecimal(0);
			BigDecimal discValueOfMedicines = new BigDecimal(0);
			BigDecimal discValueOfPackage = new BigDecimal(0);

			BlPackageHeader blPackageHeader = (BlPackageHeader) hbt.load(
					BlPackageHeader.class, box.getInt(PACKAGE_ID));
			if (blPackageHeader.getTotalValueOfServices() != null) {
				valueOfMedicines = blPackageHeader.getTotalValueOfMedicines();
			}

			if (blPackageHeader.getTotalValueOfPackage() != null) {
				valueOfPackage = blPackageHeader.getTotalValueOfPackage();
			}

			if (blPackageHeader.getDiscountedValueOfServices() != null) {
				discValueOfMedicines = blPackageHeader
						.getDiscountedValueOfMedicines();
			}

			if (blPackageHeader.getDiscountedValueOfPackage() != null) {
				discValueOfPackage = blPackageHeader
						.getDiscountedValueOfPackage();
			}

			totalValueOfMedicines = valueOfMedicines.add(new BigDecimal(box
					.getString(DISPENSING_PRICE)));
			blPackageHeader.setTotalValueOfMedicines(totalValueOfMedicines);
			totalValueOfPackage = valueOfPackage.add(new BigDecimal(box
					.getString(DISPENSING_PRICE)));
			blPackageHeader.setTotalValueOfPackage(totalValueOfPackage);

			blPackageHeader.setDiscountedValueOfPackage(discValueOfPackage
					.add(new BigDecimal(box.getString(NET_VALUE_MEDICINES))));
			blPackageHeader.setDiscountedValueOfMedicines(discValueOfMedicines
					.add(new BigDecimal(box.getString(NET_VALUE_MEDICINES))));

			BigDecimal pkgDiscount = new BigDecimal(0);
			BigDecimal pkgTariff = new BigDecimal(0);

			if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("d")) {
				if (blPackageHeader.getDistributedPkgDiscount() != null) {
					pkgDiscount = blPackageHeader.getDistributedPkgDiscount();
				}
				pkgDiscount = pkgDiscount.subtract(new BigDecimal(box
						.getString("prevDiscountValue")));
				blPackageHeader.setDistributedPkgDiscount(pkgDiscount
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			} else if (box.getString(DISCOUNT_TYPE).equalsIgnoreCase("t")) {
				if (blPackageHeader.getDistributedPkgTariff() != null) {
					pkgTariff = blPackageHeader.getDistributedPkgTariff();
				}
				pkgTariff = pkgTariff.subtract(new BigDecimal(box
						.getString("prevDiscountValue")));
				blPackageHeader.setDistributedPkgTariff(pkgTariff
						.add(new BigDecimal(box.getString(DISCOUNT_VALUE))));
			}

			hbt.update(blPackageHeader);
            hbt.flush();
            hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Updated Successfully!";
		} else {
			message = "Try Again!";
		}
		map = getDetailsForPackageMedicines(box.getInt(PACKAGE_ID));
		map.put("message", message);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPackageDetailsForDisplay(int packageId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();

		Session session = getSession();

		packageList = session.createCriteria(BlPackageHeader.class)
				.add(Restrictions.idEq(packageId)).list();
		map.put("packageList", packageList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForUpdatePackageMaster(int packageId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		Session session = getSession();

		try {
			packageList = session.createCriteria(BlPackageHeader.class)
					.add(Restrictions.idEq(packageId)).list();
			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			sexList = session.createCriteria(MasAdministrativeSex.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			accountList = session.createCriteria(FaMasAccount.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("packageList", packageList);
		map.put("departmentList", departmentList);
		map.put("sexList", sexList);
		map.put("accountList", accountList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> updatePackageDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		Session session = getSession();

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {
			BlPackageHeader blPackageHeader = (BlPackageHeader) hbt.load(
					BlPackageHeader.class, box.getInt(PACKAGE_ID));

			blPackageHeader.setPackageDesc(box.getString(PACKAGE_DESCRIPTION));
			//blPackageHeader.setFromAge(box.getString(FROM_AGE));
			//blPackageHeader.setToAge(box.getString(TO_AGE));

			if (!box.getString(EFFECTIVE_DATE_FROM).equals("")) {
				blPackageHeader.setEffectiveFromDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(EFFECTIVE_DATE_FROM)));
			}
			if (!box.getString(EFFECTIVE_DATE_TO).equals("")) {
				blPackageHeader.setEffectiveToDate(HMSUtil
						.convertStringTypeDateToDateType(box
								.getString(EFFECTIVE_DATE_TO)));
			}

			if (box.getInt(DEPARTMENT_ID) != 0) {
				MasDepartment department = new MasDepartment();
				department.setId(box.getInt(DEPARTMENT_ID));
				blPackageHeader.setDepartment(department);
			}
			if (box.getInt(SEX_ID) != 0) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
				administrativeSex.setId(box.getInt(SEX_ID));
				blPackageHeader.setSex(administrativeSex);
			}

			if (box.getInt(ACCOUNT_ID) != 0) {
				FaMasAccount masAccount = new FaMasAccount();
				masAccount.setId(box.getInt(ACCOUNT_ID));
				blPackageHeader.setAccount(masAccount);
			}
			if (!box.getString(ADDITIONAL_MEDICINE_AMOUNT).equals("")) {
				blPackageHeader.setAdditionalMedicineAmt(new BigDecimal(box
						.getString(ADDITIONAL_MEDICINE_AMOUNT)));
			}
			String discountType = box.getString(DISCOUNT_TYPE);
			if (!discountType.equals("")) {
				blPackageHeader.setDiscountType(discountType);
			}

			BigDecimal discPercent = new BigDecimal(0);
			if (!box.getString(DISCOUNT_PERCENTAGE).equals("")) {
				discPercent = new BigDecimal(box.getString(DISCOUNT_PERCENTAGE));
				blPackageHeader.setPackageDiscountTariffPercent(discPercent);
			}

			if (!box.getString(DISCOUNT_VALUE).equals("")) {
				blPackageHeader.setPackageDiscountTariffAmt(new BigDecimal(box
						.getString(DISCOUNT_VALUE)));
			}

			if (!box.getString(NET_VALUE_PACKAGE).equals("")) {
				blPackageHeader.setDiscountedValueOfPackage(new BigDecimal(box
						.getString(NET_VALUE_PACKAGE)));
			}
			if (!box.getString(NET_VALUE_SERVICES).equals("")) {
				blPackageHeader.setDiscountedValueOfServices(new BigDecimal(box
						.getString(NET_VALUE_SERVICES)));
			}
			if (!box.getString("costOfPackage").equals("")) {
				blPackageHeader.setTotalValueOfPackage(new BigDecimal(box
						.getString("costOfPackage")));
			}
			if (!box.getString(NET_VALUE_MEDICINES).equals("")) {
				blPackageHeader.setDiscountedValueOfMedicines(new BigDecimal(
						box.getString(NET_VALUE_MEDICINES)));
			}
			if (!box.getString("frozen").equals("")) {
				blPackageHeader.setFrozen("y");
			}
			Users user = new Users();
			user.setId(box.getInt("userId"));
			blPackageHeader.setLastChgBy(user);
			blPackageHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(box
							.getString(CHANGED_DATE)));
			blPackageHeader.setLastChgTime(box.getString(CHANGED_TIME));
			blPackageHeader.setStatus("y");

			hbt.update(blPackageHeader);

			Set<BlPackageServicesDetails> servicesSet = new HashSet<BlPackageServicesDetails>();
			if (blPackageHeader.getBlPackageServicesDetails() != null) {
				servicesSet = blPackageHeader.getBlPackageServicesDetails();
			}
			if (servicesSet.size() > 0) {
				for (BlPackageServicesDetails servicesDetails : servicesSet) {
					BlPackageServicesDetails packageServicesDetails = (BlPackageServicesDetails) hbt
							.load(BlPackageServicesDetails.class,
									servicesDetails.getId());
					BigDecimal pkgServAmt = new BigDecimal(0);
					BigDecimal pkgServDiscAmt = new BigDecimal(0);
					BigDecimal pkgServNetAmt = new BigDecimal(0);

					if (!box.getString(DISCOUNT_ON).equals("")) {
						if (box.getString(DISCOUNT_ON).equals("1")) {
							pkgServAmt = servicesDetails.getChargeAmount();
						} else if (box.getString(DISCOUNT_ON).equals("2")) {
							pkgServAmt = servicesDetails.getNetChargeAmt();
						}
					}
					pkgServNetAmt = servicesDetails.getNetChargeAmt();
					pkgServDiscAmt = (pkgServAmt.multiply(discPercent))
							.divide(new BigDecimal(100));

					packageServicesDetails.setPkgDiscType(discountType);
					packageServicesDetails.setPkgDiscTrfPercent(discPercent);
					packageServicesDetails.setPkgDiscTrfAmount(pkgServDiscAmt);

					if (discountType.equalsIgnoreCase("D")) {
						packageServicesDetails.setNetChargeAmt(pkgServNetAmt
								.subtract(pkgServDiscAmt));
					} else if (discountType.equalsIgnoreCase("T")) {
						packageServicesDetails.setNetChargeAmt(pkgServNetAmt
								.add(pkgServDiscAmt));
					}

					hbt.update(packageServicesDetails);
				}
			}

			Set<BlPackageMedicineDetails> medicinSet = new HashSet<BlPackageMedicineDetails>();
			if (blPackageHeader.getBlPackageMedicineDetails() != null) {
				medicinSet = blPackageHeader.getBlPackageMedicineDetails();
			}
			if (medicinSet.size() > 0) {
				for (BlPackageMedicineDetails medicinDetails : medicinSet) {
					BlPackageMedicineDetails packageMedicineDetails = (BlPackageMedicineDetails) hbt
							.load(BlPackageMedicineDetails.class,
									medicinDetails.getId());

					BigDecimal pkgMedicinAmt = new BigDecimal(0);
					BigDecimal pkgMedDiscAmt = new BigDecimal(0);
					BigDecimal pkgMedNetAmt = new BigDecimal(0);

					if (!box.getString(DISCOUNT_ON).equals("")) {
						if (box.getString(DISCOUNT_ON).equals("1")) {
							pkgMedicinAmt = medicinDetails.getItemAmount();
						} else if (box.getString(DISCOUNT_ON).equals("2")) {
							pkgMedicinAmt = medicinDetails.getNetItemAmt();
						}
					}
					pkgMedNetAmt = medicinDetails.getNetItemAmt();
					pkgMedDiscAmt = (pkgMedicinAmt.multiply(discPercent))
							.divide(new BigDecimal(100));

					packageMedicineDetails.setPkgDiscType(discountType);
					packageMedicineDetails.setPkgDiscTrfPercent(discPercent);
					packageMedicineDetails.setPkgDiscTrfAmount(pkgMedDiscAmt);

					if (discountType.equalsIgnoreCase("D")) {
						packageMedicineDetails.setNetItemAmt(pkgMedNetAmt
								.subtract(pkgMedDiscAmt));
					} else if (discountType.equalsIgnoreCase("T")) {
						packageMedicineDetails.setNetItemAmt(pkgMedNetAmt
								.add(pkgMedDiscAmt));
					}

					hbt.update(packageMedicineDetails);
				}
			}
			hbt.flush();
            hbt.clear();
			saved = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		try {
			packageList = session.createCriteria(BlPackageHeader.class).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		String message = "";
		if (saved) {
			message = "Record Updated Successfully!";
		} else {
			message = "Try Again!";
		}
		map.put("packageList", packageList);
		map.put("message", message);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForPackageBilling(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();

		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();
		List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();

		Session session = getSession();

		if (box.getString("patientType").equals("OP")) {
			patientList = session.createCriteria(Patient.class)
					.add(Restrictions.eq("HinNo", box.getString(HIN_NO)))
					.add(Restrictions.eq("PatientStatus", "Out Patient"))
					.list();

		} else if (box.getString("patientType").equals("IP")) {

			Criteria crit = null;
			System.out.println("bdg"+box.getString(AD_NO));
			crit = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("AdNo", box.getString(AD_NO)));
					//.add(Restrictions.eq("AdStatus", "A"));
			if (!box.getString(HIN_NO).equals("")) {
				crit = crit.createAlias("Hin", "p")
						.add(Restrictions.eq("p.HinNo", box.getString(HIN_NO)))
						.add(Restrictions.eq("p.PatientStatus", "In Patient"));
			}
			inpatientList = crit.list();
		}
		
		
		
       System.out.println("==="+inpatientList.size());
		packageList = session.createCriteria(BlPackageHeader.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		authorizerList = session.createCriteria(MasAuthorizer.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		bankList = session.createCriteria(MasBankMaster.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		sexList = session.createCriteria(MasAdministrativeSex.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();

		String pkgbillno = genratePackageBillNo("display");

		map.put("pkgbillno", pkgbillno);
		map.put("patientList", patientList);
		map.put("inpatientList", inpatientList);
		map.put("packageList", packageList);
		map.put("authorizerList", authorizerList);
		map.put("bankList", bankList);
		map.put("sexList", sexList);
		map.put("employeeList", employeeList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPackageDetails(int packageId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageServicesDetails> pkgServList = new ArrayList<BlPackageServicesDetails>();
		List<BlPackageMedicineDetails> pkgMedList = new ArrayList<BlPackageMedicineDetails>();

		Session session = getSession();

		pkgServList = session.createCriteria(BlPackageServicesDetails.class)
				.add(Restrictions.eq("Status", "y"))
				.createAlias("PackageHeader", "ph")
				.add(Restrictions.eq("ph.Id", packageId)).list();

		pkgMedList = session.createCriteria(BlPackageMedicineDetails.class)
				.add(Restrictions.eq("Status", "y"))
				.createAlias("PackageHeader", "ph")
				.add(Restrictions.eq("ph.Id", packageId)).list();

		map.put("pkgServList", pkgServList);
		map.put("pkgMedList", pkgMedList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitOPPkgBillingDetails(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BlPackageHeader> packageHeaderList = new ArrayList<BlPackageHeader>();
		Set<BlPackageServicesDetails> pkgServSet = new HashSet<BlPackageServicesDetails>();

		boolean saved = false;

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		Date billDate = HMSUtil.convertStringTypeDateToDateType(box
				.getString(CHANGED_DATE));

		Session session = getSession();

		packageHeaderList = session.createCriteria(BlPackageHeader.class)
				.add(Restrictions.idEq(box.getInt(PACKAGE_ID))).list();
		BlPackageHeader packageHeaderObj = new BlPackageHeader();
		if (packageHeaderList.size() > 0) {
			packageHeaderObj = packageHeaderList.get(0);
		}

		try {
			BlPackageBill packageBill = new BlPackageBill();

			Patient patient = new Patient();
			if (box.getInt(HIN_ID) != 0) {
				patient.setId(box.getInt(HIN_ID));
				packageBill.setHin(patient);
			}
			Inpatient inpatient = new Inpatient();
			if (box.getInt(INPATIENT_ID) != 0) {
				inpatient.setId(box.getInt(INPATIENT_ID));
				packageBill.setInpatient(inpatient);
			}

			BlPackageHeader packageHeader = new BlPackageHeader();
			packageHeader.setId(box.getInt(PACKAGE_ID));
			packageBill.setPackage(packageHeader);

			MasEmployee employee = new MasEmployee();
			employee.setId(box.getInt(EMPLOYEE_ID));
			packageBill.setConsultant(employee);

			MasHospital hospital = new MasHospital();
			hospital.setId(box.getInt("hospitalId"));
			packageBill.setHospital(hospital);

			Users user = new Users();
			user.setId(box.getInt("userId"));

			String pkgbillno = genratePackageBillNo("save");
			System.out.println("pkgbillno"+pkgbillno);
			packageBill.setPackageBillNo(pkgbillno);

			packageBill
					.setPackageAmt(packageHeaderObj.getTotalValueOfPackage());
			packageBill.setPkgDiscountAmt(packageHeaderObj
					.getPackageDiscountTariffAmt());
			packageBill.setNetPkgAmt(packageHeaderObj
					.getDiscountedValueOfPackage());

			BigDecimal advAdjAmt = new BigDecimal(0);
			BigDecimal advAdjAmtForServ = new BigDecimal(0);
			BigDecimal advAdjAmtForDisp = new BigDecimal(0);

			if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
				advAdjAmt = new BigDecimal(box.getString(ADVANCE_ADJUSTMENT));
				BigDecimal advAdjPercent = new BigDecimal(0);

				advAdjPercent = (advAdjAmt.multiply(new BigDecimal(100)))
						.divide(packageHeaderObj.getDiscountedValueOfPackage(),
								2, RoundingMode.HALF_UP);
				advAdjAmtForServ = (packageHeaderObj
						.getDiscountedValueOfServices().multiply(advAdjPercent))
						.divide(new BigDecimal(100));
				advAdjAmtForDisp = (packageHeaderObj
						.getDiscountedValueOfMedicines()
						.multiply(advAdjPercent)).divide(new BigDecimal(100));
				packageBill.setAdvAdjustmentAmt(advAdjAmt);
			}

			BigDecimal osAmt = new BigDecimal(0);
			BigDecimal osAmtForServ = new BigDecimal(0);
			BigDecimal osAmtForDisp = new BigDecimal(0);

			if (!box.getString(OUTSTANDING).equals("")) {
				osAmt = new BigDecimal(box.getString(OUTSTANDING));
				BigDecimal osPercent = new BigDecimal(0);

				osPercent = (osAmt.multiply(new BigDecimal(100))).divide(
						packageHeaderObj.getDiscountedValueOfPackage(), 2,
						RoundingMode.HALF_UP);
				osAmtForServ = (packageHeaderObj.getDiscountedValueOfServices()
						.multiply(osPercent)).divide(new BigDecimal(100));
				osAmtForDisp = (packageHeaderObj
						.getDiscountedValueOfMedicines().multiply(osPercent))
						.divide(new BigDecimal(100));
				packageBill.setOutstandingAmt(osAmt);
			}
			if (!box.getString(ROUND_OF_VALUE).equals("")) {
				packageBill.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}

			packageBill.setLastChgBy(user);
			packageBill.setLastChgDate(billDate);
			packageBill.setLastChgTime(box.getString(CHANGED_TIME));

			hbt.save(packageBill);
			hbt.flush();
			hbt.clear();

			/*FaVoucherHeader voucherHeader = new FaVoucherHeader();
			voucherHeader.setVoucherNo(box.getString("voucherNo"));
			FaMasVoucherType voucherType = new FaMasVoucherType();
			voucherType.setId(2);
			voucherHeader.setVoucherType(voucherType);
			voucherHeader.setLastChgBy(box.getString(CHANGED_BY));
			voucherHeader.setLastChgDate(billDate);
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			voucherHeader.setCrBalance(new BigDecimal(box
					.getString(DISCOUNTED_VALUE_PACKAGE)));
			voucherHeader.setDrBalance(new BigDecimal(box
					.getString(DISCOUNTED_VALUE_PACKAGE)));
			voucherHeader.setHospital(hospital);
			voucherHeader.setNaration("Package Billing");
			voucherHeader.setStatus("y");
			voucherHeader.setLastChgBy(box.getString(CHANGED_BY));
			voucherHeader.setLastChgDate(billDate);
			voucherHeader.setLastChgTime(box.getString(CHANGED_TIME));
			voucherHeader.setVoucherDate(billDate);
			voucherHeader.setVoucherTime(box.getString(CHANGED_TIME));
			hbt.save(voucherHeader);*/

			BlOpBillHeader billHeader = new BlOpBillHeader();
			BlChargeSlipMain blChargeSlipMain = new BlChargeSlipMain();
			List<BlPackageServicesDetails> blPackageServicesDetail=session.createCriteria(BlPackageServicesDetails.class,"pkg").add(Restrictions.eq("pkg.PackageHeader.Id", packageHeaderObj.getId())).list();
           System.out.println("packageHeaderObj.getBlPackageServicesDetails().size()"+blPackageServicesDetail.size());
			if (blPackageServicesDetail.size() > 0) {
				pkgServSet = packageHeaderObj.getBlPackageServicesDetails();

				if (box.getInt(INPATIENT_ID) == 0) {

					billHeader.setPackageBill(packageBill);
					System.out.println(pkgbillno);
					billHeader.setBillNo(pkgbillno);
					billHeader.setConsultant(employee);
					if (box.getInt(HIN_ID) != 0) {
						billHeader.setHin(patient);
						billHeader.setPatientStatus("r");
					} else {
						billHeader.setPatientStatus("u");
					}
					billHeader.setHinNo(box.getString(HIN_NO));
					billHeader.setPatientName(box.getString(PATIENT_NAME));
					billHeader.setConsultantName(box
							.getString(CONSULTING_DOCTOR));
					MasAdministrativeSex sex = new MasAdministrativeSex();
					sex.setId(box.getInt(SEX_ID));
					billHeader.setSex(sex);
					billHeader.setAge(box.getString(AGE));
					billHeader.setHospital(hospital);

					billHeader.setBillAmt(packageHeaderObj
							.getTotalValueOfServices());

					if (packageHeaderObj.getDiscountedValueOfServices() != null) {
						billHeader
								.setDiscountAmt(packageHeaderObj
										.getTotalValueOfServices()
										.subtract(
												packageHeaderObj
														.getDiscountedValueOfServices()));
					}
					if (packageHeaderObj.getDiscountedValueOfServices() != null) {
						billHeader.setNetAmt(packageHeaderObj
								.getDiscountedValueOfServices());
					}
					if (!box.getString(OUTSTANDING).equals("")) {
						billHeader.setOutstanding(osAmtForServ);
					}
					if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
						billHeader.setAdvanceAdjustment(advAdjAmtForServ);
					}
					BigDecimal payableAmt = new BigDecimal(0);

					if (!box.getString(TOTAL_AMOUNT).equals("")) {
						payableAmt = packageHeaderObj
								.getDiscountedValueOfServices();
						if (!box.getString(OUTSTANDING).equals("")) {
							payableAmt = payableAmt.subtract(osAmtForServ);
						}
						if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
							payableAmt = payableAmt.subtract(advAdjAmtForServ);
						}
						billHeader.setPayableAmt(payableAmt);
					}
					billHeader.setStatus("y");
					billHeader.setChangedBy(user);
					billHeader.setBillDate(billDate);
					billHeader.setBillTime(box.getString(CHANGED_TIME));

					hbt.save(billHeader);
					

				} else if (box.getInt(INPATIENT_ID) != 0) {

					blChargeSlipMain.setHin(patient);
					inpatient.setId(box.getInt(INPATIENT_ID));
					blChargeSlipMain.setInpatient(inpatient);
					blChargeSlipMain.setHospital(hospital);
					blChargeSlipMain
							.setChargeSlipNo(box.getInt("chargeSlipNo"));
					blChargeSlipMain.setChgSlpAmt(packageHeaderObj
							.getTotalValueOfServices());

					blChargeSlipMain.setPackageBill(packageBill);

					if (!box.getString(OUTSTANDING).equals("")) {
						blChargeSlipMain.setOsAmt(osAmtForServ);
					}

					if (packageHeaderObj.getDiscountedValueOfServices() != null) {
						blChargeSlipMain
								.setDiscountAmt(packageHeaderObj
										.getTotalValueOfServices()
										.subtract(
												packageHeaderObj
														.getDiscountedValueOfServices()));
					}

					if (packageHeaderObj.getDiscountedValueOfServices() != null) {
						blChargeSlipMain.setNetAmt(packageHeaderObj
								.getDiscountedValueOfServices());
					}

					BigDecimal payableAmt = new BigDecimal(0);

					if (!box.getString(TOTAL_AMOUNT).equals("")) {
						payableAmt = packageHeaderObj
								.getDiscountedValueOfServices();
						if (!box.getString(OUTSTANDING).equals("")) {
							payableAmt = payableAmt.subtract(osAmtForServ);
						}
						if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
							payableAmt = payableAmt.subtract(advAdjAmtForServ);
						}
						blChargeSlipMain.setReceiptAmt(payableAmt);
					}
					if (box.getInt(AUTHORIZER_ID) != 0) {
						MasAuthorizer authorizer = new MasAuthorizer();
						authorizer.setId(box.getInt(AUTHORIZER_ID));
						blChargeSlipMain.setAuthorizer(authorizer);
					}
					blChargeSlipMain.setChgSlpDate(billDate);
					blChargeSlipMain.setChgSlpTime(box.getString(CHANGED_TIME));
					blChargeSlipMain.setLastChgBy(user);
					blChargeSlipMain.setLastChgDate(billDate);
					blChargeSlipMain
							.setLastChgTime(box.getString(CHANGED_TIME));
					blChargeSlipMain.setStatus("y");
					if (box.getInt(EMPLOYEE_ID) != 0) {
						MasEmployee consultant = new MasEmployee();
						consultant.setId(box.getInt(EMPLOYEE_ID));
						blChargeSlipMain.setConsultant(consultant);
					}

					hbt.save(blChargeSlipMain);
					

				}

				boolean diag = false;
				for (BlPackageServicesDetails blPackageServicesDetails : blPackageServicesDetail) {
					if (blPackageServicesDetails.getChargeCode()
							.getMainChargecode().getDepartment()
							.getDepartmentType().getDepartmentTypeCode()
							.equals("RADIO")
							|| blPackageServicesDetails.getChargeCode()
									.getMainChargecode().getDepartment()
									.getDepartmentType()
									.getDepartmentTypeCode().equals("DIAG")) {
						diag = true;
						break;
					}
				}

				if (diag == true) {
					DgOrderhd orderhd = new DgOrderhd();
					orderhd.setHospital(hospital);
					orderhd.setOrderNo(box.getString("orderNo"));
					MasDepartment dept = new MasDepartment();
					dept.setId(box.getInt("departmentId"));
					orderhd.setDepartment(dept);
					orderhd.setTestType("Regular");
					orderhd.setOrderStatus("P");
					orderhd.setPatientType("OP");
					orderhd.setOrderDate(billDate);
					orderhd.setOrderTime(box.getString(CHANGED_TIME));
					
					//commented for maven
					/*orderhd.setLastChgBy(box.getString(CHANGED_BY));*/
					orderhd.setLastChgDate(billDate);
					orderhd.setLastChgTime(box.getString(CHANGED_TIME));
					orderhd.setBillChargeSlpNo(box.getString("chargeSlipNo"));
					orderhd.setOrderNo(box.getString("orderNo"));
					if (box.getInt(HIN_ID) != 0) {
						orderhd.setHin(patient);
					}
					if (box.getInt(EMPLOYEE_ID) != 0) {
						orderhd.setPrescribedBy(employee);
					}
					orderhd.setNetAmount(packageHeaderObj
							.getDiscountedValueOfServices());

					hbt.save(orderhd);
					

					DgSampleCollectionHeader collHeader = new DgSampleCollectionHeader();

					for (BlPackageServicesDetails blPackageServicesDetails : blPackageServicesDetail) {
						if (blPackageServicesDetails.getChargeCode()
								.getMainChargecode().getDepartment()
								.getDepartmentType().getDepartmentTypeCode()
								.equals("RADIO")) {
							if (box.getInt(HIN_ID) != 0) {
								collHeader.setHin(patient);
							}
							MasDepartment department = new MasDepartment();
							department.setId(blPackageServicesDetails
									.getChargeCode().getMainChargecode()
									.getDepartment().getId());
							collHeader.setDepartment(department);
							collHeader.setHospital(hospital);
							collHeader.setOrder(orderhd);
							collHeader.setDiagnosisDate(billDate);
							collHeader.setDiagnosisTime(box
									.getString(CHANGED_TIME));
							collHeader.setOrderStatus("P");
							collHeader.setSampleValidationDate(billDate);
							collHeader.setSampleValidationTime(box
									.getString(CHANGED_TIME));
							
							//commented for maven
							/*collHeader.setLastChgBy(box.getString(CHANGED_BY));*/
							collHeader.setLastChgDate(billDate);
							collHeader.setLastChgTime(box
									.getString(CHANGED_TIME));

							hbt.save(collHeader);
							
							break;
						}
					}

					for (BlPackageServicesDetails blPackageServicesDetails : blPackageServicesDetail) {
						if (box.getInt(INPATIENT_ID) == 0) {
							BlOpBillDetails billDetails = new BlOpBillDetails();

							billDetails.setOpBillHeader(billHeader);
							billDetails.setChargeCode(blPackageServicesDetails
									.getChargeCode());
							billDetails.setAmount(blPackageServicesDetails
									.getChargeAmount());
							/*billDetails.setDiscountAmt(blPackageServicesDetails
									.getChargeAmount().subtract(
											blPackageServicesDetails
													.getNetChargeAmt()));
							billDetails.setNetAmt(blPackageServicesDetails
									.getNetChargeAmt());*/
							billDetails.setQuantity(blPackageServicesDetails
									.getQuantity());
							billDetails.setRate(blPackageServicesDetails
									.getRate());
							billDetails.setRefundableStatus("n");
							billDetails.setChangedBy(user);
							billDetails.setBillDate(billDate);
							billDetails
									.setBillTime(box.getString(CHANGED_TIME));

							hbt.save(billDetails);
							hbt.flush();
						} else if (box.getInt(INPATIENT_ID) != 0) {
							BlChargeSlipDetail chargeslipDetails = new BlChargeSlipDetail();

							chargeslipDetails
									.setChargeSlipMain(blChargeSlipMain);
							chargeslipDetails
									.setChargeCode(blPackageServicesDetails
											.getChargeCode());
							chargeslipDetails.setAmt(blPackageServicesDetails
									.getChargeAmount());
							/*chargeslipDetails
									.setDiscountAmt(blPackageServicesDetails
											.getChargeAmount().subtract(
													blPackageServicesDetails
															.getNetChargeAmt()));
							chargeslipDetails
									.setNetAmt(blPackageServicesDetails
											.getNetChargeAmt());*/
							chargeslipDetails
									.setQuantity(blPackageServicesDetails
											.getQuantity());
							chargeslipDetails.setRate(blPackageServicesDetails
									.getRate());
							chargeslipDetails.setRefundableStatus("n");
							
							//commented for maven
							/*chargeslipDetails.setLastChgBy(box
									.getString(CHANGED_BY));*/
							chargeslipDetails.setLastChgDate(billDate);
							chargeslipDetails.setLastChgTime(box
									.getString(CHANGED_TIME));
							chargeslipDetails.setHospital(hospital);
							chargeslipDetails.setStatus("y");
							hbt.save(chargeslipDetails);
							hbt.flush();
						}
						//======================code commented by anamika====================//
						//FaVoucherDetails voucherDetails = new FaVoucherDetails();
						//BigDecimal amount = new BigDecimal(0);

					//	voucherDetails.setVoucherHeader(voucherHeader);
						//voucherDetails.setHospital(hospital);
						//voucherDetails.setNaration("For Package Services");

						//FaMasAccount masAccount = new FaMasAccount();
						//masAccount.setId(blPackageServicesDetails
							//	.getChargeCode().getAccount().getId());
						//voucherDetails.setAcc(masAccount);

						/*FaMasSubLed masSubLed = new FaMasSubLed();
						masSubLed.setId(blPackageServicesDetails
								.getChargeCode().getSubAccount().getId());
						voucherDetails.setSubLed(masSubLed);

						amount = blPackageServicesDetails.getNetChargeAmt();
						voucherDetails.setCrBalance(amount);
						voucherDetails.setStatus("y");
						voucherDetails.setLastChgDate(billDate);
						voucherDetails.setLastChgTime(box
								.getString(CHANGED_TIME));
						voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
						hbt.save(voucherDetails);*/

						//BigDecimal crBalanceForAc = new BigDecimal(0);
						//BigDecimal crBalanceForSbldAc = new BigDecimal(0);
						/*if (blPackageServicesDetails.getChargeCode()
								.getAccount() != null) {
							FaMasAccount accObj = (FaMasAccount) hbt.load(
									FaMasAccount.class,
									blPackageServicesDetails.getChargeCode()
											.getAccount().getId());
							if (accObj.getCrBalance() != null) {
								crBalanceForAc = accObj.getCrBalance();
							}
							accObj.setCrBalance(crBalanceForAc
									.add(blPackageServicesDetails
											.getNetChargeAmt()));
							hbt.update(accObj);
						}
*/
						/*if (blPackageServicesDetails.getChargeCode()
								.getSubAccount() != null) {
							FaMasSubLed subLed = (FaMasSubLed) hbt.load(
									FaMasSubLed.class, blPackageServicesDetails
											.getChargeCode().getSubAccount()
											.getId());
							if (subLed.getCrBalance() != null) {
								crBalanceForSbldAc = subLed.getCrBalance();
							}
							subLed.setCrBalance(crBalanceForSbldAc
									.add(blPackageServicesDetails
											.getNetChargeAmt()));
							hbt.update(subLed);
						}*/

						// ------------------Save or Update Data into dg_orderdt
						// table-------------------------

						String deptCode = blPackageServicesDetails
								.getChargeCode().getMainChargecode()
								.getDepartment().getDepartmentType()
								.getDepartmentTypeCode();

						if (deptCode.equals("RADIO") || deptCode.equals("DIAG") || deptCode.equals("LAB")) {
							DgOrderdt orderdt = new DgOrderdt();
							orderdt.setOrderhd(orderhd);
							MasChargeCode masChargeCode = new MasChargeCode();
							int chargeId = blPackageServicesDetails
									.getChargeCode().getId();
							masChargeCode.setId(chargeId);
							orderdt.setChargeCode(masChargeCode);

							int qty = blPackageServicesDetails.getQuantity();
							orderdt.setOrderQty(qty);

							BigDecimal netAmount = blPackageServicesDetails
									.getNetChargeAmt();
							orderdt.setAmount(netAmount);

							int mainChargeId = blPackageServicesDetails
									.getChargeCode().getMainChargecode()
									.getId();
							MasMainChargecode mainChargecode = new MasMainChargecode();
							mainChargecode.setId(mainChargeId);
							orderdt.setMainChargecode(mainChargecode);

							int subChargeId = blPackageServicesDetails
									.getChargeCode().getSubChargecode().getId();
							MasSubChargecode subChargecode = new MasSubChargecode();
							subChargecode.setId(subChargeId);
							orderdt.setSubChargeid(subChargecode);

							orderdt.setPaymentMade("y");
							orderdt.setOrderStatus("P");
							orderdt.setLastChgDate(billDate);
							orderdt.setLastChgTime(box.getString(CHANGED_TIME));
							
							//commented for maven
						/*	orderdt.setLastChgBy(box.getString(CHANGED_BY));*/
							if (box.getInt(INPATIENT_ID) != 0) {
								orderdt.setChargeSlip(blChargeSlipMain);
							} else if (box.getInt(INPATIENT_ID) == 0) {
								orderdt.setBill(billHeader);
							}
							try {
								hbt.save(orderdt);
							} catch (RuntimeException e) {
								e.printStackTrace();
							}

							if (deptCode.equals("RADIO")) {
								DgSampleCollectionDetails collDetails = new DgSampleCollectionDetails();
								collDetails
										.setSampleCollectionHeader(collHeader);
								collDetails.setChargeCode(masChargeCode);
								String diagNo = generateDiagNumber(blPackageServicesDetails
										.getChargeCode().getSubChargecode()
										.getId());
								System.out.println("diag"+diagNo);
								collDetails.setDiagNo(diagNo);
								collDetails.setCollected("y");
								//commented for maven
								/*collDetails.setLastChgBy(box
										.getString(CHANGED_BY));*/
								collDetails.setLastChgDate(billDate);
								collDetails.setLastChgTime(box
										.getString(CHANGED_TIME));
								collDetails.setOrderStatus("P");
								collDetails.setSampleCollDatetime(billDate);
								MasMainChargecode maincharge = new MasMainChargecode();
								maincharge.setId(blPackageServicesDetails
										.getChargeCode().getMainChargecode()
										.getId());
								collDetails.setMaincharge(maincharge);
								MasSubChargecode subCharge = new MasSubChargecode();
								subCharge.setId(blPackageServicesDetails
										.getChargeCode().getSubChargecode()
										.getId());
								collDetails.setSubcharge(subCharge);
								DgMasInvestigation investigation = new DgMasInvestigation();
								investigation.setId(blPackageServicesDetails
										.getChargeCode().getId());
								collDetails.setInvestigation(investigation);
								collDetails.setSampleCollDatetime(new Date());
								hbt.save(collDetails);
								
							}
						}
					}

				}
			}
			List<BlPackageMedicineDetails> blPackageMedicineDetails=session.createCriteria(BlPackageMedicineDetails.class,"pkgmdsn").add(Restrictions.eq("pkgmdsn.PackageHeader.Id",packageHeaderObj.getId())).list();
			if (blPackageMedicineDetails.size() > 0) {
				BlDispensingHeader dispHeader = new BlDispensingHeader();

				dispHeader.setPackageBill(packageBill);
				//dispHeader.setBillNo(box.getString("dispBillNo"));
				dispHeader.setBillNo(pkgbillno);
				dispHeader.setConsultant(employee);
				if (box.getInt(HIN_ID) != 0) {
					dispHeader.setHin(patient);
					dispHeader.setPatientStatus("r");
				} else {
					dispHeader.setPatientStatus("u");
				}
				dispHeader.setHinNo(box.getString(HIN_NO));
				dispHeader.setPatientName(box.getString(PATIENT_NAME));
				dispHeader.setConsultantName(box.getString(CONSULTING_DOCTOR));
				MasAdministrativeSex sex = new MasAdministrativeSex();
				sex.setId(box.getInt(SEX_ID));
				dispHeader.setSex(sex);
				dispHeader.setAge(box.getString(AGE));
				dispHeader.setHospital(hospital);
				dispHeader.setBillAmt(packageHeaderObj
						.getTotalValueOfMedicines());
				if (packageHeaderObj.getDiscountedValueOfMedicines() != null) {
					dispHeader.setDiscountAmt(packageHeaderObj
							.getTotalValueOfMedicines().subtract(
									packageHeaderObj
											.getDiscountedValueOfMedicines()));
				}
				if (packageHeaderObj.getDiscountedValueOfMedicines() != null) {
					dispHeader.setNetAmt(packageHeaderObj
							.getDiscountedValueOfMedicines());
				}
				if (!box.getString("totalAdditionalDiscount").equals("")) {
					dispHeader.setDiscountAmt(new BigDecimal(box
							.getString("totalAdditionalDiscount")));
				}

				if (!box.getString(OUTSTANDING).equals("")) {
					dispHeader.setOutstanding(osAmtForDisp);
				}
				if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
					dispHeader.setAdvAdjustment(advAdjAmtForDisp);
				}
				BigDecimal payableAmt = new BigDecimal(0);

				if (!box.getString(TOTAL_AMOUNT).equals("")) {
					payableAmt = packageHeaderObj
							.getDiscountedValueOfMedicines();
					if (!box.getString(OUTSTANDING).equals("")) {
						payableAmt = payableAmt.subtract(osAmtForDisp);
					}
					if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
						payableAmt = payableAmt.subtract(advAdjAmtForDisp);
					}
					dispHeader.setPayableAmt(payableAmt);
				}
				dispHeader.setStatus("y");
				dispHeader.setChangedBy(user);
				dispHeader.setBillDate(billDate);
				dispHeader.setBillTime(box.getString(CHANGED_TIME));

				hbt.save(dispHeader);

				int batchWiseItemListLength = box.getInt("batchNoCounter");

				for (int i = 1; i < batchWiseItemListLength; i++) {
					BlDispensingDetails dispensingDetails = new BlDispensingDetails();
					dispensingDetails.setDispensingHeader(dispHeader);

					if (box.getInt(BATCH_ITEM_ID + i) != 0) {
						MasStoreItem storeItem = new MasStoreItem();
						storeItem.setId(box.getInt(BATCH_ITEM_ID + i));
						dispensingDetails.setItem(storeItem);
					}
					if (box.getInt(BATCH_ID + i) != 0) {
						StoreItemBatchStock itemBatchStock = new StoreItemBatchStock();
						itemBatchStock.setId(box.getInt(BATCH_ID + i));
						dispensingDetails.setBatch(itemBatchStock);
					}
					if (box.getString(ISSUE_QUANTITY + i) != null
							&& !box.getString(ISSUE_QUANTITY + i).equals("")) {
						dispensingDetails.setQty(new BigDecimal(box
								.getString(ISSUE_QUANTITY + i)));
					}
					if (box.getString("batchAmt" + i) != null
							&& !box.getString("batchAmt" + i).equals("")) {
						dispensingDetails.setAmount(new BigDecimal(box
								.getString("batchAmt" + i)));
					}
					if (box.getString("batchDisPer" + i) != null
							&& !box.getString("batchDisPer" + i).equals("")) {
						dispensingDetails.setDiscountPercent(new BigDecimal(box
								.getString("batchDisPer" + i)));
					}
					if (box.getString("batchDisAmt" + i) != null
							&& !box.getString("batchDisAmt" + i).equals("")) {
						dispensingDetails.setDiscountAmt(new BigDecimal(box
								.getString("batchDisAmt" + i)));
					}
					if (box.getString("batchPrptDisAmt" + i) != null
							&& !box.getString("batchPrptDisAmt" + i).equals("")) {
						dispensingDetails.setProportionalDisAmt(new BigDecimal(
								box.getString("batchPrptDisAmt" + i)));
					}
					if (box.getString("batchNetAmt" + i) != null
							&& !box.getString("batchNetAmt" + i).equals("")) {
						dispensingDetails.setNetAmt(new BigDecimal(box
								.getString("batchNetAmt" + i)));
					}
					dispensingDetails.setRefundableStatus("n");

					hbt.save(dispensingDetails);
					
				}

			/*	int itemWiseListLength = box.getInt("hiddenValueItem");
				if (itemWiseListLength > 0) {
					for (int j = 1; j <= itemWiseListLength; j++) {
						FaVoucherDetails voucherDetails = new FaVoucherDetails();
						BigDecimal amount = new BigDecimal(0);
						//voucherDetails.setVoucherHeader(voucherHeader);
						voucherDetails.setHospital(hospital);
						voucherDetails.setNaration("For Package Dispensing");
						if (box.getInt(FA_ACCOUNT_ID + j) != 0) {
							FaMasAccount masAccount = new FaMasAccount();
							masAccount.setId(box.getInt(FA_ACCOUNT_ID + j));
							voucherDetails.setAcc(masAccount);
						}
						if (box.getInt(FA_SUB_LED_ID + j) != 0) {
							FaMasSubLed masSubLed = new FaMasSubLed();
							masSubLed.setId(box.getInt(FA_SUB_LED_ID + j));
							voucherDetails.setSubLed(masSubLed);
						}
						if (!box.getString("netAmtDisp" + j).equals("")) {
							amount = new BigDecimal(box.getString("netAmtDisp"
									+ j));
							voucherDetails.setCrBalance(amount);
						}
						voucherDetails.setStatus("y");
						voucherDetails.setLastChgDate(billDate);
						voucherDetails.setLastChgTime(box
								.getString(CHANGED_TIME));
						voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
						hbt.save(voucherDetails);

						BigDecimal crBalanceForAc = new BigDecimal(0);
						BigDecimal crBalanceForSbldAc = new BigDecimal(0);
						if (box.getInt(FA_ACCOUNT_ID + j) != 0) {
							FaMasAccount accObj = (FaMasAccount) hbt.load(
									FaMasAccount.class,
									box.getInt(FA_ACCOUNT_ID + j));
							if (accObj.getCrBalance() != null) {
								crBalanceForAc = accObj.getCrBalance();
							}
							accObj.setCrBalance(crBalanceForAc
									.add(new BigDecimal(box
											.getString("batchNetAmt" + j))));
							hbt.update(accObj);
						}

						if (box.getInt(FA_SUB_LED_ID + j) != 0) {
							FaMasSubLed subLed = (FaMasSubLed) hbt.load(
									FaMasSubLed.class,
									box.getInt(FA_SUB_LED_ID + j));
							if (subLed.getCrBalance() != null) {
								crBalanceForSbldAc = subLed.getCrBalance();
							}
							subLed.setCrBalance(crBalanceForSbldAc
									.add(new BigDecimal(box
											.getString("batchNetAmt" + j))));
							hbt.update(subLed);
						}
					}
				}
			}
*/
			int payListLength = box.getInt("hiddenValuePayment");
			BlReceiptHeader receiptHeader = new BlReceiptHeader();
			/*receiptHeader
					.setAmount(new BigDecimal(box.getString(TOTAL_AMOUNT)));*/
			if (box.getInt(HIN_ID) != 0) {
				receiptHeader.setHin(patient);
			}
			if (box.getInt(INPATIENT_ID) != 0) {
				receiptHeader.setInpatient(inpatient);
			}
			if (!box.getString(ROUND_OF_VALUE).equals("")) {
				receiptHeader.setRoundOff(new BigDecimal(box
						.getString(ROUND_OF_VALUE)));
			}

			receiptHeader.setHospital(hospital);
			receiptHeader.setReceiptDate(billDate);
			receiptHeader.setReceiptTime(box.getString(CHANGED_TIME));
			receiptHeader.setReceiptType("pkb");
			receiptHeader.setReceiptNo(pkgbillno);
			receiptHeader.setPackageBill(packageBill);
			receiptHeader.setChangedBy(user);
			hbt.save(receiptHeader);

			for (int j = 1; j <= payListLength; j++) {
				BlReceiptDetails receiptDetails = new BlReceiptDetails();
				if (!box.getString(PAYMENT_MODE + j).equals("")) {
					receiptDetails.setPaymentMode(box.getString(PAYMENT_MODE
							+ j));
				}
				if (!box.getString(AMOUNT_RECEIVED + j).equals("")) {
					receiptDetails.setAmount(new BigDecimal(box
							.getString(AMOUNT_RECEIVED + j)));
				}
				if (!box.getString(CHEQUE_NO + j).equals("")) {
					receiptDetails.setChequeNo(box.getString(CHEQUE_NO + j));
				}
				if (!box.getString(CHEQUE_DATE + j).equals("")) {
					receiptDetails.setChequeDate(HMSUtil
							.convertStringTypeDateToDateType(box
									.getString(CHEQUE_DATE + j)));
				}
				if (!box.getString(BANK_NAME + j).equals("")) {
					MasBankMaster bankMaster = new MasBankMaster();
					bankMaster.setId(box.getInt(BANK_NAME + j));
					receiptDetails.setBank(bankMaster);
				}

				receiptDetails.setReceiptDate(billDate);
				receiptDetails.setReceiptTime(box.getString(CHANGED_TIME));
				receiptDetails.setChangedBy(user);
				receiptDetails.setReceiptHeader(receiptHeader);
				hbt.save(receiptDetails);
				hbt.flush();

				//FaVoucherDetails voucherDetails = new FaVoucherDetails();
				//BigDecimal amount = new BigDecimal(0);
				//voucherDetails.setVoucherHeader(voucherHeader);
				//voucherDetails.setHospital(hospital);
				//FaMasAccount acc = new FaMasAccount();
				//FaMasSubLed subLed = new FaMasSubLed();

				//if (box.getString(PAYMENT_MODE + j).equals("C")) {
					//voucherDetails
							//.setNaration("Cash Payment For Package Billing");
					//acc.setId(2);
					//subLed.setId(4);

				//} else if (box.getString(PAYMENT_MODE + j).equals("Q")
						//|| box.getString(PAYMENT_MODE + j).equals("R")) {
					//voucherDetails
						//	.setNaration("Credit Card/Cheque Payment For Package Billing");
					//acc.setId(6);
					//subLed.setId(5);
				//}
				//voucherDetails.setAcc(acc);
				//voucherDetails.setSubLed(subLed);

				//if (!box.getString(AMOUNT_RECEIVED + j).equals("")) {
					//amount = new BigDecimal(box.getString(AMOUNT_RECEIVED + j));
					//voucherDetails.setDrBalance(amount);
				//}
				//voucherDetails.setStatus("y");
				//voucherDetails.setLastChgDate(billDate);
				//voucherDetails.setLastChgTime(box.getString(CHANGED_TIME));
				//voucherDetails.setLastChgBy(box.getString(CHANGED_BY));
				//hbt.save(voucherDetails);

				/*FaMasAccount accountObj = new FaMasAccount();
				FaMasSubLed subLedObj = new FaMasSubLed();

				if (box.getString(PAYMENT_MODE + j).equals("C")) {
					accountObj = (FaMasAccount) hbt.load(FaMasAccount.class, 2);
					subLedObj = (FaMasSubLed) hbt.load(FaMasSubLed.class, 4);

				} else if (box.getString(PAYMENT_MODE + j).equals("Q")
						|| box.getString(PAYMENT_MODE + j).equals("R")) {
					accountObj = (FaMasAccount) hbt.load(FaMasAccount.class, 6);
					subLedObj = (FaMasSubLed) hbt.load(FaMasSubLed.class, 5);
				}

				BigDecimal drBalanceForAc = new BigDecimal(0);
				BigDecimal drBalanceForSbldAc = new BigDecimal(0);

				if (accountObj.getDrBalance() != null) {
					drBalanceForAc = accountObj.getDrBalance();
				}
				accountObj.setDrBalance(drBalanceForAc.add(new BigDecimal(box
						.getString(AMOUNT_RECEIVED + j))));
				hbt.update(accountObj);

				if (subLedObj.getDrBalance() != null) {
					drBalanceForSbldAc = subLedObj.getDrBalance();
				}
				subLedObj.setDrBalance(drBalanceForSbldAc.add(new BigDecimal(
						box.getString(AMOUNT_RECEIVED + j))));
				hbt.update(subLedObj);*/
			}

			//int batchWiseItemListLength = box.getInt("batchNoCounter");
			for (int j = 1; j < batchWiseItemListLength; j++) {
				int batchId = box.getInt(BATCH_ID + j);
				StoreItemBatchStock batchStock = (StoreItemBatchStock) hbt
						.load(StoreItemBatchStock.class, batchId);
				BigDecimal blockedQty = new BigDecimal(0);
				BigDecimal totalBlockedQty = new BigDecimal(0);
				BigDecimal issueQty = new BigDecimal(0);

				if (batchStock.getBlockedQty() != null) {
					blockedQty = batchStock.getBlockedQty();
				}

				issueQty = new BigDecimal(box.getString(ISSUE_QUANTITY + j));
				totalBlockedQty = blockedQty.add(issueQty);
				//batchStock.setBlockedQty(totalBlockedQty);

				hbt.update(batchStock);
				
			}

			int hinId = box.getInt(HIN_ID);
			BigDecimal advAdj = new BigDecimal(0);
			BigDecimal outstanding = new BigDecimal(0);

			if (!box.getString(ADVANCE_ADJUSTMENT).equals("")) {
				advAdj = new BigDecimal(box.getString(ADVANCE_ADJUSTMENT));
			}
			if (!box.getString(OUTSTANDING).equals("")) {
				outstanding = new BigDecimal(box.getString(OUTSTANDING));
			}

			BigDecimal pastDueBD = new BigDecimal(0);
			if (hinId != 0) {
				Patient patientObj = (Patient) hbt.load(Patient.class, hinId);
				String pastDue = "";
				if (patientObj.getPastDue() != null) {
					pastDue = patientObj.getPastDue();
				}

				String sign = "";
				if (pastDue != null && !pastDue.equals("")
						&& !pastDue.equals("0")) {
					sign = pastDue.substring(0, 1);
					pastDueBD = new BigDecimal(pastDue);
					if (sign.equals("-")) {
						if (!advAdj.equals(0)) {
							pastDueBD = pastDueBD.add(advAdj);
						}
						if (!outstanding.equals(0)) {
							pastDueBD = pastDueBD.subtract(outstanding);
						}
					} else {
						if (!outstanding.equals(0)) {
							pastDueBD = pastDueBD.add(outstanding);
						}
					}
				} else {
					if (!outstanding.equals(0)) {
						pastDueBD = pastDueBD.add(outstanding);
					}
				}
				patientObj.setPastDue(pastDueBD.toString());
				hbt.update(patientObj);
			}

			saved = true;
		}} catch (DataAccessException e) {
			e.printStackTrace();
		}
       hbt.flush();
       hbt.clear();
		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public String genratePackageBillNo(String flag) {
		String pkgBillNo = "";
		Integer pkgBillSeqNo = 0;
		List<BlParameter> pkgSeqNoList = new ArrayList<BlParameter>();
		// List<BlPatientPackage> patientPkgList = new
		// ArrayList<BlPatientPackage>();

		Session session = (Session) getSession();
		try {
			pkgSeqNoList = session.createCriteria(BlParameter.class)
					.add(Restrictions.eq("Prefix", "PKG")).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		/*
		 * patientPkgList =
		 * session.createCriteria(BlPatientPackage.class).list(); String
		 * lastPkgBlNo = ""; if (patientPkgList.size() > 0) { for
		 * (BlPatientPackage patientPackage : patientPkgList) { lastPkgBlNo =
		 * patientPackage.getPackageNo(); } }
		 */
         System.out.println("bl"+pkgSeqNoList.size());
		int id = 0;
		int seqNo = 0;
		String criteria = "";
		if (pkgSeqNoList.size() > 0) {
			for (BlParameter blParameter : pkgSeqNoList) {
				id = blParameter.getId();
				seqNo = blParameter.getSeqNo();
				criteria = blParameter.getCriteria();
				pkgBillSeqNo = ++seqNo;
			}
			if (criteria.equalsIgnoreCase("c")) {
				pkgBillNo = pkgBillSeqNo.toString();

			}
			if (flag.equals("save")) {
				BlParameter parameterObj = (BlParameter) hbt.load(
						BlParameter.class, id);
				parameterObj.setSeqNo(pkgBillSeqNo);
				hbt.update(parameterObj);
				hbt.flush();
				hbt.clear();
			}
		}
		return pkgBillNo;
	}

	@SuppressWarnings("unchecked")
	public String generateDiagNumber(int subChargeId) {
		Integer dgSeqNo = 0;
		String diagSeqNo = "";
		List<DiagParam> diagSeqNoList = new ArrayList<DiagParam>();
		List<DgSampleCollectionDetails> dgDetailsList = new ArrayList<DgSampleCollectionDetails>();

		Session session = (Session) getSession();

		try {
			diagSeqNoList = session.createCriteria(DiagParam.class)
					.createAlias("SubCharge", "sc")
					.add(Restrictions.eq("sc.Id", subChargeId)).list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		dgDetailsList = session.createCriteria(DgSampleCollectionDetails.class)
				.list();
		String lastDiagNo = "";
		if (dgDetailsList.size() > 0) {
			for (DgSampleCollectionDetails collDetails : dgDetailsList) {
				lastDiagNo = collDetails.getDiagNo();
			}
		}
		String lastMnt = "";
		String lastYr = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");

		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		StringTokenizer str = new StringTokenizer(lastDiagNo, "/");

		int id = 0;
		String criteria = "";
		int seqNo = 0;
		String subcharge = "";
		if (diagSeqNoList.size() > 0) {
			for (DiagParam dgParam : diagSeqNoList) {
				id = dgParam.getId();
				seqNo = dgParam.getSeqNo();
				subcharge = dgParam.getSubCharge().getSubChargecodeCode();
				criteria = dgParam.getCriteria();
				dgSeqNo = ++seqNo;

			}
			if (criteria.equalsIgnoreCase("c")) {
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("m")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					str.nextToken();
					if (str.hasMoreTokens()) {
						lastMnt = str.nextToken();
					}
					if (str.hasMoreTokens()) {
						lastYr = str.nextToken();
					}
				}
				if (!lastMnt.equals(currentMonth)
						&& !lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}
				diagSeqNo = dgSeqNo.toString().concat("/").concat(subcharge)
						.concat("/").concat(currentMonth).concat("/")
						.concat(currentYear);
			} else if (criteria.equalsIgnoreCase("y")) {
				while (str.hasMoreTokens()) {
					str.nextToken();
					if (str.hasMoreTokens()) {
						lastYr = str.nextToken();
					}
				}
				if (!lastYr.equals(currentYear)) {
					dgSeqNo = 1;
				}
				diagSeqNo = dgSeqNo.toString().concat("/").concat(currentYear)
						.concat(subcharge).concat("/").concat(currentMonth)
						.concat("/").concat(currentYear);
			}

			DiagParam diagParam = (DiagParam) hbt.load(DiagParam.class, id);
			diagParam.setSeqNo(dgSeqNo);
			hbt.update(diagParam);
			hbt.flush();
			hbt.clear();

		}
		return diagSeqNo;
	}

}
