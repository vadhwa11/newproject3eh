package jkt.hms.stores.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StoreAmcM;
import jkt.hms.masters.business.StoreAmcT;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreGrnT;
import jkt.hms.masters.business.StoreIndentM;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreLoaninM;
import jkt.hms.masters.business.StoreLoaninT;
import jkt.hms.masters.business.StoreRepairCivilFirm;
import jkt.hms.masters.business.StoreWorkOrderM;
import jkt.hms.masters.business.StoreWorkOrderT;
import jkt.hms.stores.handler.NonExpendableStoresHandlerService;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NonExpendableStoresController extends MultiActionController {

	StoresHandlerService storesHandlerService = null;
	NonExpendableStoresHandlerService nonExpendableStoresHandlerService = null;
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";

	// ======================== methods by abha ====================
	// GRN jsp for non expendable items
	public ModelAndView showNeGrnJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showNeGrnJsp(box, dataMap);
		jsp = NE_GRN_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.
	public ModelAndView showInfoOfNeGrnJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreGrnT> storeGrnTMoreInfoList = new ArrayList<StoreGrnT>();
		map = storesHandlerService.getDetailsForMoreInfoGrn();
		int rowNo = 0;
		int storeGrnTId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			storeGrnTId = Integer.parseInt(request.getParameter("detailId"));
			storeGrnTMoreInfoList = nonExpendableStoresHandlerService
					.getStoreGrnTListForMoreInfo(storeGrnTId);
			map.put("storeGrnTMoreInfoList", storeGrnTMoreInfoList);
		}
		jsp = MORE_INFO_NE_GRN_JSP;
		title = "GRN";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	// For adding Grn
	public ModelAndView submitGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		StoreGrnM storeGrnM = new StoreGrnM();
		StoreGrnT storeGrnT = new StoreGrnT();
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
		List addOrUpdate = new ArrayList();
		String grnNo = "";
		int rows = 0;
		String sourceOfSupply = "";
		Date grnDate = null;
		int grnId = 0;
		int unitId = 0;
		int indentId = 0;
		int poId = 0;
		String howReceived = "";
		Date dateReceivedSurplus = null;
		String rrNo = "";
		String modeOfConveyance = "";
		int employeeId = 0;
		String invoiceNo = "";
		Date invoiceDate = null;
		BigDecimal invoiceAmount = null;
		BigDecimal freightDuty = null;
		BigDecimal exciseDuty = null;
		BigDecimal octroi = null;
		BigDecimal customDuty = null;
		BigDecimal insuranceCharge = null;
		BigDecimal otherCharges = null;
		BigDecimal grnValue = null;
		BigDecimal roundOffValue = null;
		BigDecimal grnAmount = null;
		BigDecimal totalAmount = null;
		int supplierId = 0;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		Date challanDate = null;
		String lastChgTime = "";
		String atSoNo = "";
		String remarks = "";
		String date = "";
		String time = "";
		String choice = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		int meScaleId = 0;
		String technicalDetails = "";
		String amcContract = "";
		String technicalSpecification = "";
		String challanNo = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			}

			if (request.getParameter("noOfRows") != null) {
				noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
			}

			if (request.getParameter(GRN_ID) != null) {
				grnId = Integer.parseInt(request.getParameter(GRN_ID));
			}

			if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));
			}

			if (!request.getParameter(ME_SCALE_ID).equals("0")) {
				meScaleId = Integer.parseInt(request.getParameter(ME_SCALE_ID));
			}

			if (request.getParameter(GRN_NO) != null) {
				grnNo = (request.getParameter(GRN_NO));
			}

			if (request.getParameter(TECHNICAL_DETAILS) != null) {
				technicalDetails = (request.getParameter(TECHNICAL_DETAILS));
			}

			if (request.getParameter(TECHNICAL_SPECIFICATION) != null) {
				technicalSpecification = (request
						.getParameter(TECHNICAL_SPECIFICATION));
			}

			if (request.getParameter(AMC_CONTRACT) != null) {
				amcContract = (request.getParameter(AMC_CONTRACT));
			}

			if (request.getParameter(INVOICE_NO) != null) {
				invoiceNo = (request.getParameter(INVOICE_NO));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = request.getParameter(REMARKS);
			}
			if (request.getParameter(RR_NO) != null) {
				rrNo = request.getParameter(RR_NO);
			}
			if (request.getParameter(MODE_OF_CONVEYANCE) != null) {
				modeOfConveyance = request.getParameter(MODE_OF_CONVEYANCE);
			}
			if (request.getParameter(SUPPLY_ORDER_NO) != null) {
				atSoNo = request.getParameter(SUPPLY_ORDER_NO);
			}
			if (request.getParameter(HOW_RECEIVED) != null) {
				howReceived = request.getParameter(HOW_RECEIVED);
			}
			if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
				sourceOfSupply = request.getParameter(SOURCE_OF_SUPPLY);

			}
			// --- indent and supplier on basis of source of supply ---------
			if (request.getParameter(SOURCE_OF_SUPPLY).equals("d")) {
				if (request.getParameter(INDENT_ID) != null) {
					indentId = Integer.parseInt((request
							.getParameter(INDENT_ID)));
				}
				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("p")) {

				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("s")) {
				if (request.getParameter(INDENT_ID) != null) {
					indentId = Integer.parseInt((request
							.getParameter(INDENT_ID)));
				}
				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("g")) {
				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}

			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("m")) {
				if (request.getParameter(SUPPLIER_ID) != null) {
					supplierId = Integer.parseInt((request
							.getParameter(SUPPLIER_ID)));
				}
			}

			// ------- end of select

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String te = "";

			if (request.getParameter(GRN_DATE) != null) {
				te = (String) (request.getParameter(GRN_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(GRN_DATE)));
				grnDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
		}

		try {
			String teinvoice = "";
			if (request.getParameter(INVOICE_DATE) != null) {
				teinvoice = (String) (request.getParameter(INVOICE_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(INVOICE_DATE)));
				invoiceDate = java.sql.Date.valueOf(date4MySQL);

			}
		} catch (Exception e) {
		}

		try {
			String tedaterecd = "";
			if (request.getParameter(RECEIVED_DATE) != null) {
				tedaterecd = (String) (request.getParameter(RECEIVED_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(RECEIVED_DATE)));
				dateReceivedSurplus = java.sql.Date.valueOf(date4MySQL);

			}
		} catch (Exception e) {
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		if (request.getParameter(INVOICE_AMOUNT) != null
				&& !request.getParameter(INVOICE_AMOUNT).equals("")) {
			invoiceAmount = new BigDecimal(request.getParameter(INVOICE_AMOUNT));
		} else {
			invoiceAmount = new BigDecimal(0);
		}
		if (request.getParameter(FREIGHT_DUTY) != null
				&& !request.getParameter(FREIGHT_DUTY).equals("")) {
			freightDuty = new BigDecimal(request.getParameter(FREIGHT_DUTY));
		} else {
			freightDuty = new BigDecimal(0);
		}
		if (request.getParameter(EXCISE_DUTY) != null
				&& !request.getParameter(EXCISE_DUTY).equals("")) {
			exciseDuty = new BigDecimal(request.getParameter(EXCISE_DUTY));
		} else {
			exciseDuty = new BigDecimal(0);
		}

		if (request.getParameter(OCTROI) != null
				&& !request.getParameter(OCTROI).equals("")) {
			octroi = new BigDecimal(request.getParameter(OCTROI));
		} else {
			octroi = new BigDecimal(0);
		}
		if (request.getParameter(CUSTOM_DUTY) != null
				&& !request.getParameter(CUSTOM_DUTY).equals("")) {
			customDuty = new BigDecimal(request.getParameter(CUSTOM_DUTY));
		} else {
			customDuty = new BigDecimal(0);
		}
		if (request.getParameter(INSURANCE_CHARGES) != null
				&& !request.getParameter(INSURANCE_CHARGES).equals("")) {
			insuranceCharge = new BigDecimal(
					request.getParameter(INSURANCE_CHARGES));
		} else {
			insuranceCharge = new BigDecimal(0);
		}

		if (request.getParameter(OTHER_CHARGES) != null
				&& !request.getParameter(OTHER_CHARGES).equals("")) {
			otherCharges = new BigDecimal(request.getParameter(OTHER_CHARGES));
		} else {
			otherCharges = new BigDecimal(0);
		}

		if (request.getParameter(GRN_VALUE) != null
				&& !request.getParameter(GRN_VALUE).equals("")) {
			grnValue = new BigDecimal(request.getParameter(GRN_VALUE));
		}
		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !request.getParameter(TOTAL_AMOUNT).equals("")) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}

		String headerStored = "no";

		if (pageNo == 1) {

			storeGrnM.setGrnNo(grnNo);
			storeGrnM.setCustomDuty(customDuty);
			storeGrnM.setDateReceivedSurplus(dateReceivedSurplus);
			// --- set on indent and supplier on basis of source of supply -----
			if (request.getParameter(SOURCE_OF_SUPPLY).equals("d")) {

				StoreIndentM storeIndentM = new StoreIndentM();
				storeIndentM.setId(indentId);
				//commented for maven
				/*storeGrnM.setIndent(storeIndentM);*/

				MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
				masStoreAirForceDepot.setId(supplierId);
				storeGrnM.setUnit(masStoreAirForceDepot);

			}

			else if (request.getParameter(SOURCE_OF_SUPPLY).equals("p")) {

				MasStoreSupplier masStoreSupplier2 = new MasStoreSupplier();
				masStoreSupplier2.setId(supplierId);
				storeGrnM.setSupplier(masStoreSupplier2);

				storeGrnM.setUnit(null);
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);

			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("s")) {
				StoreIndentM storeIndentM = new StoreIndentM();
				storeIndentM.setId(indentId);
				//commented for maven
				/*storeGrnM.setIndent(storeIndentM);*/

				MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
				masStoreAirForceDepot.setId(supplierId);
				storeGrnM.setUnit(masStoreAirForceDepot);

			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("g")) {
				MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
				masStoreAirForceDepot.setId(supplierId);
				storeGrnM.setUnit(masStoreAirForceDepot);

				storeGrnM.setSupplier(null);
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);
			} else if (request.getParameter(SOURCE_OF_SUPPLY).equals("m")) {

				MasStoreSupplier masStoreSupplier2 = new MasStoreSupplier();
				masStoreSupplier2.setId(supplierId);
				storeGrnM.setSupplier(masStoreSupplier2);

				storeGrnM.setUnit(null);
				storeGrnM.setIndent(null);
				storeGrnM.setPo(null);
			}
			// ----- end ----------
			storeGrnM.setInvoiceAmount(invoiceAmount);
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			storeGrnM.setEmployee(masEmployee);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeGrnM.setDepartment(masDepartment);
			storeGrnM.setRemarks(remarks);
			storeGrnM.setExciseDuty(exciseDuty);
			storeGrnM.setFreightDuty(freightDuty);
			storeGrnM.setGrnDate(grnDate);
			storeGrnM.setExciseDuty(exciseDuty);

			MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
			masStoreMeScale.setId(meScaleId);
			storeGrnM.setMeScale(masStoreMeScale);
			storeGrnM.setReceiveType(sourceOfSupply);

			storeGrnM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeGrnM.setLastChgTime(time);
			storeGrnM.setAtSoNo(atSoNo);
			storeGrnM.setGrnValue(grnValue);
			storeGrnM.setHowReceived(howReceived);
			storeGrnM.setInsuranceCharge(insuranceCharge);
			storeGrnM.setInvoiceDate(invoiceDate);

			storeGrnM.setInvoiceNo(invoiceNo);
			storeGrnM.setModeOfConveyance(modeOfConveyance);
			storeGrnM.setOctroi(octroi);
			storeGrnM.setOtherCharges(otherCharges);
			storeGrnM.setReceiveType(sourceOfSupply);
			storeGrnM.setTechnicalDetails(technicalDetails);
			storeGrnM.setTechnicalSpecification(technicalSpecification);
			storeGrnM.setAmcContract(amcContract);
			storeGrnM.setGrnAmount(totalAmount);

			storeGrnM.setRrNo(rrNo);
			storeGrnM.setStatus("o");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			storeGrnM.setHospital(masHospital);
			//commented for maven
			/*storeGrnM.setLastChgBy("admin");*/

		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}
		int length = 0;
		List<StoreGrnT> storeGrnTlist = new ArrayList<StoreGrnT>();

		try {

			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			int freeQty[] = JKTRequestUtils.getRequiredIntParameters(request,
					FREE_QTY);
			int manufacturerIdArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, MANUFACTURER_ID);

			String lotNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, LOT_NO);
			String batchNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_NO);
			String freeItemArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, FREE_ITEM);
			String warrantyDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, WARRANTY_DATE);
			String installationDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, INSTALLATION_DATE);
			String amcStartDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, AMC_START_DATE);
			String amcEndDate[] = JKTRequestUtils.getRequiredStringParameters(
					request, AMC_END_DATE);
			String acceptedModel[] = JKTRequestUtils
					.getRequiredStringParameters(request, ACCEPTED_MODEL);

			BigDecimal[] quantityReceivedArray = new BigDecimal[10];
			BigDecimal[] taxArr = new BigDecimal[10];
			BigDecimal[] unitRateArr = new BigDecimal[10];
			BigDecimal[] discountArr = new BigDecimal[10];
			BigDecimal[] amountArr = new BigDecimal[10];
			BigDecimal[] totAmountArr = new BigDecimal[10];
			BigDecimal[] costPrice = new BigDecimal[10];

			String yy[] = JKTRequestUtils.getRequiredStringParameters(request,
					TAX_PERCENT);
			int yyLen = yy.length;
			for (int i = 0; i < yyLen; i++) {
				BigDecimal val = new BigDecimal(yy[i]);
				taxArr[i] = val;
			}
			String tt[] = JKTRequestUtils.getRequiredStringParameters(request,
					UNIT_RATE);
			int ttLen = tt.length;
			for (int i = 0; i < ttLen; i++) {
				BigDecimal val = new BigDecimal(tt[i]);
				unitRateArr[i] = val;
			}
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					DISCOUNT_PERCENTAGE);
			int zzLen = zz.length;
			for (int i = 0; i < zzLen; i++) {
				BigDecimal val = new BigDecimal(zz[i]);
				discountArr[i] = val;
			}
			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,
					AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}
			String mm[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY_RECEIVED);
			int mmLen = mm.length;
			for (int i = 0; i < mmLen; i++) {
				BigDecimal val = new BigDecimal(mm[i]);
				quantityReceivedArray[i] = val;
			}

			String gg[] = JKTRequestUtils.getRequiredStringParameters(request,
					COST_PRICE);
			int ggLen = gg.length;
			for (int i = 0; i < ggLen; i++) {
				BigDecimal val = new BigDecimal(gg[i]);
				costPrice[i] = val;
			}

			if (buttonFlag.equals("next")) {

				length = 10;
			} else {
				length = noOfRows;
			}

			for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreGrnT storeGrnTObj = new StoreGrnT();
					storeGrnTObj.setSerialNo(srNo[i]);
					storeGrnTObj.setFreeQty(freeQty[i]);

					if (freeItemArr[i].equalsIgnoreCase("y")) {
						storeGrnTObj.setFreeItem("y");
					} else {
						storeGrnTObj.setFreeItem("n");
					}
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeGrnTObj.setItem(masItem);

					if (manufacturerIdArray[i] != 0) {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(manufacturerIdArray[i]);
						storeGrnTObj.setManufacturer(masManufacturer);
					}

					storeGrnTObj.setReceivedQty(quantityReceivedArray[i]);
					storeGrnTObj.setTax(taxArr[i]);
					storeGrnTObj.setAmountValue(amountArr[i]);
					storeGrnTObj.setUnitRate(unitRateArr[i]);
					storeGrnTObj.setBatchNo(batchNoArr[i]);
					storeGrnTObj.setLotNo(lotNoArr[i]);
					storeGrnTObj.setDiscount(discountArr[i]);
					storeGrnTObj.setWarrantyDate(warrantyDate[i]);
					storeGrnTObj.setInstallationDate(installationDate[i]);
					storeGrnTObj.setAmcEndDate(amcEndDate[i]);
					storeGrnTObj.setAmcStartDate(amcStartDate[i]);
					storeGrnTObj.setFinalCostPrice(costPrice[i]);
					storeGrnTObj.setAcceptedModel(acceptedModel[i]);
					storeGrnTlist.add(storeGrnTObj);
				}

			}
		} catch (Exception e) {
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("grnNo", grnNo);
		infoMap.put("grnId", grnId);
		infoMap.put("addOrUpdate", addOrUpdate);
		infoMap.put("storeGrnM", storeGrnM);
		infoMap.put("storeItemBatchStock", storeItemBatchStock);
		infoMap.put("storeGrnTlist", storeGrnTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("sourceOfSupply", sourceOfSupply);
		// infoMap.put("userName", userName);
		// infoMap.put("hospitalId", hospitalId);
		infoMap.put("indentId", indentId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addGrns(infoMap);

		} catch (Exception e) {
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}

		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = NE_GRN_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "CRV created Successfully !";
				map = nonExpendableStoresHandlerService.showNeGrnJsp(box,
						dataMap);
				if (map.get("grnId") != null) {
					grnId = (Integer) map.get("grnId");
				}
				List<StoreGrnM> grnMList = storesHandlerService.getGrn(grnId);
				map.put("grnMList", grnMList);

			} else {
				jsp = NE_GRN_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "CRV created Successfully !";
			}
		} else {
			messageTOBeVisibleToTheUser = "CRV not created.";
		}

		jsp = "neGrn";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showNeGrnJsp";
		map.put("grnNo", grnNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView responseNeGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		if (request.getParameter(SOURCE_OF_SUPPLY) != null) {
			choice = request.getParameter(SOURCE_OF_SUPPLY);
		}
		map = (Map<String, Object>) nonExpendableStoresHandlerService
				.getListForNeGrn(choice);
		jsp = RESPONSE_FOR_NE_GRN_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView responseIndentList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		map = nonExpendableStoresHandlerService.getResponseIndentList(box);
		jsp = RESPONSE_INDENT_LIST_FOR_NE;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView responseGridList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String choice = "";
		jsp = "gridForNe";
		return new ModelAndView(jsp, "map", map);
	}

	// For searching Grn on basis of GRN No
	public ModelAndView searchGrn(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String fromDate = "";
		String toDate = "";
		String grnNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreGrnM> searchGrnList = new ArrayList<StoreGrnM>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);

			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);

			}
			if (request.getParameter(GRN_NO) != null) {
				grnNo = request.getParameter(GRN_NO);

			}
		} catch (Exception e) {
		}
		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("grnNo", grnNo);
		try {
			tempMap = nonExpendableStoresHandlerService.showNeGrnJsp(box,
					dataMap);
			if (tempMap.get("searchGrnList") != null) {
				searchGrnList = (List) tempMap.get("searchGrnList");
			}
			map = nonExpendableStoresHandlerService.searchGrn(searchFieldMap);

			map.put("searchGrnList", searchGrnList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SEARCH_NE_GRN_JSP;
		jsp = jsp + ".jsp";
		title = "GRN";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView modifyGrn(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		jsp = MODIFY_NE_GRN_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) nonExpendableStoresHandlerService
					.modifyGrn(radio_str, 0);
		}
		purchaseMap = nonExpendableStoresHandlerService.showNeGrnJsp(box,
				dataMap);
		List<StoreGrnM> grnList = storesHandlerService.getGrnList();

		map.put("purchaseMap", purchaseMap);
		map.put("grnList", grnList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------- new grid
	// method---------------------------

	public ModelAndView getItemListForGrnByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String sos = box.getString("sourceOfSupply").trim();
		String itemNameField = "";
		String autoHint = "";
		String indentNo = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (sos.equalsIgnoreCase("d") || (sos.equalsIgnoreCase("s"))) {
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt((request.getParameter("indentId")));
			}

		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForGrnByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForGrn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String nomenclature = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			nomenclature = (request.getParameter("requiredField"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("nomenclature", nomenclature);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForGrn(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// --------------------------------- NON EXPENDABLE LOAN IN
	// -----------------------
	public ModelAndView showNeLoanInJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession(true);

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showNeLoanInJsp(box, dataMap);
		jsp = NE_LOAN_IN_JSP;
		jsp = jsp + ".jsp";
		title = "Loan IN";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ===================== adding loanin ================================

	public ModelAndView submitLoanIn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		StoreLoaninM storeLoaninM = new StoreLoaninM();
		StoreLoaninT storeLoaninT = new StoreLoaninT();
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();

		String loanInNo = "";
		int rows = 0;
		int noOfRecords = 0;
		String receiveType = "";
		Date loanInDate = new Date();

		int loanInId = 0;
		int unitId = 0;
		int poId = 0;
		String howReceived = "";
		String challanNo = "";
		Date challanDate = new Date();
		Date dateReceivedSurplus = new Date();
		String rrNo = "";
		String modeOfConveyance = "";
		int employeeId = 0;
		BigDecimal freightDuty = null;
		BigDecimal exciseDuty = null;
		BigDecimal octroi = null;
		BigDecimal customDuty = null;
		BigDecimal insuranceCharge = null;
		BigDecimal otherCharges = null;
		BigDecimal grnValue = null;
		BigDecimal roundOffValue = null;
		BigDecimal grnAmount = null;
		BigDecimal totalAmount = null;
		int supplierId = 0;
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		String atSoNo = "";
		String buttonFlag = "";
		String remarks = "";
		String date = "";
		String time = "";
		int meScaleId = 0;
		String technicalDetails = "";
		String technicalSpecification = "";
		String amcContract = "";
		String extnIvNo = "";
		String periodFrom = "";
		int hospitalId = 0;
		String userName = "";
		int deptId = 0;
		int indentId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		int noOfRows = 0;
		int pageNo = 1;
		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter("buttonFlag") != null) {
				buttonFlag = request.getParameter("buttonFlag");

			}

			if (request.getParameter("noOfRows") != null) {
				noOfRows = Integer.parseInt(request.getParameter("noOfRows"));
			}
			if (request.getParameter(LOANIN_ID) != null) {
				loanInId = Integer.parseInt(request.getParameter(LOANIN_ID));

			}
			if (!request.getParameter(SUPPLIER_ID).equals("0")) {
				supplierId = Integer
						.parseInt(request.getParameter(SUPPLIER_ID));

			}

			if (!request.getParameter(EMPLOYEE_ID).equals("0")) {
				employeeId = Integer
						.parseInt(request.getParameter(EMPLOYEE_ID));

			}
			if (!request.getParameter(ME_SCALE_ID).equals("0")) {
				meScaleId = Integer.parseInt(request.getParameter(ME_SCALE_ID));

			}

			if (request.getParameter(EXTN_IV) != null) {
				extnIvNo = (request.getParameter(EXTN_IV));
			}
			if (request.getParameter(REMARKS) != null) {
				remarks = (request.getParameter(REMARKS));
			}
			if (request.getParameter(LOANIN_NO) != null) {
				loanInNo = (request.getParameter(LOANIN_NO));
			}

			if (request.getParameter(TECHNICAL_DETAILS) != null) {
				technicalDetails = (request.getParameter(TECHNICAL_DETAILS));
			}

			if (request.getParameter(TECHNICAL_SPECIFICATION) != null) {
				technicalSpecification = (request
						.getParameter(TECHNICAL_SPECIFICATION));
			}

			if (request.getParameter(AMC_CONTRACT) != null) {
				amcContract = (request.getParameter(AMC_CONTRACT));
			}

			if (request.getParameter(PERIOD_FROM) != null) {
				periodFrom = (request.getParameter(PERIOD_FROM));
			}
			if (pageNo != 1) {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String te = "";

			if (request.getParameter(LOANIN_DATE) != null) {
				te = (String) (request.getParameter(LOANIN_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(LOANIN_DATE)));
				loanInDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		if (request.getParameter(GRN_VALUE) != null
				&& !request.getParameter(GRN_VALUE).equals("")) {
			grnValue = new BigDecimal(request.getParameter(GRN_VALUE));
		}

		if (request.getParameter(TOTAL_AMOUNT) != null
				&& !request.getParameter(TOTAL_AMOUNT).equals("")) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}

		String headerStored = "no";

		if (pageNo == 1) {
			storeLoaninM.setLoaninDate(loanInDate);
			storeLoaninM.setLoaninNo(loanInNo);
			storeLoaninM.setRemarks(remarks);

			MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
			masStoreAirForceDepot.setId(supplierId);
			storeLoaninM.setUnit(masStoreAirForceDepot);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			storeLoaninM.setEmployee(masEmployee);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeLoaninM.setDepartment(masDepartment);

			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			storeLoaninM.setHospital(masHospital);
			storeLoaninM.setRoundOffValue(roundOffValue);
			storeLoaninM.setLoaninValue(grnValue);
			storeLoaninM.setStatus("o");
			storeLoaninM.setLastChgBy("admin");
			storeLoaninM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeLoaninM.setLastChgTime(time);
			storeLoaninM.setExtnIvNo(extnIvNo);
			storeLoaninM.setPeriodFrom(periodFrom);

			MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
			masStoreMeScale.setId(meScaleId);
			storeLoaninM.setMeScale(masStoreMeScale);

		} else {

			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}

		int length = 0;
		List<StoreLoaninT> storeLoaninTlist = new ArrayList<StoreLoaninT>();

		try {

			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			int freeQty[] = JKTRequestUtils.getRequiredIntParameters(request,
					FREE_QTY);
			int manufacturerIdArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, MANUFACTURER_ID);
			String lotNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, LOT_NO);
			String batchNoArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_NO);
			String freeItemArr[] = JKTRequestUtils.getRequiredStringParameters(
					request, FREE_ITEM);
			String warrantyDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, WARRANTY_DATE);
			String installationDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, INSTALLATION_DATE);
			String amcStartDate[] = JKTRequestUtils
					.getRequiredStringParameters(request, AMC_START_DATE);
			String amcEndDate[] = JKTRequestUtils.getRequiredStringParameters(
					request, AMC_END_DATE);
			String acceptedModel[] = JKTRequestUtils
					.getRequiredStringParameters(request, ACCEPTED_MODEL);

			BigDecimal[] taxArr = new BigDecimal[10];
			BigDecimal[] unitRateArr = new BigDecimal[10];
			BigDecimal[] discountArr = new BigDecimal[10];
			BigDecimal[] amountArr = new BigDecimal[10];
			BigDecimal[] quantityReceivedArray = new BigDecimal[10];
			BigDecimal[] costPrice = new BigDecimal[10];

			String yy[] = JKTRequestUtils.getRequiredStringParameters(request,
					TAX_PERCENT);
			int yyLen = yy.length;
			for (int i = 0; i < yyLen; i++) {
				BigDecimal val = new BigDecimal(yy[i]);
				taxArr[i] = val;
			}
			String tt[] = JKTRequestUtils.getRequiredStringParameters(request,
					UNIT_RATE);
			int ttLen = tt.length;
			for (int i = 0; i < ttLen; i++) {
				BigDecimal val = new BigDecimal(tt[i]);
				unitRateArr[i] = val;
			}
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					DISCOUNT_PERCENTAGE);
			int zzLen = zz.length;
			for (int i = 0; i < zzLen; i++) {
				BigDecimal val = new BigDecimal(zz[i]);
				discountArr[i] = val;
			}
			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,
					AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}
			String mm[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY_RECEIVED);
			int mmLen = qq.length;
			for (int i = 0; i < mmLen; i++) {
				BigDecimal val = new BigDecimal(mm[i]);
				quantityReceivedArray[i] = val;
			}

			String gg[] = JKTRequestUtils.getRequiredStringParameters(request,
					COST_PRICE);
			int ggLen = gg.length;
			for (int i = 0; i < ggLen; i++) {
				BigDecimal val = new BigDecimal(gg[i]);
				costPrice[i] = val;
			}

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}
			for (int i = 0; i < length; i++) {

				if (itemIdArray[i] != 0) {

					StoreLoaninT storeLoaninTObj = new StoreLoaninT();
					storeLoaninTObj.setSerialNo(srNo[i]);

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeLoaninTObj.setItem(masItem);

					storeLoaninTObj.setReceivedQty(quantityReceivedArray[i]);
					storeLoaninTObj.setTax(taxArr[i]);
					storeLoaninTObj.setDiscount(discountArr[i]);
					storeLoaninTObj.setAmountValue(amountArr[i]);
					storeLoaninTObj.setUnitRate(unitRateArr[i]);
					storeLoaninTObj.setBatchNo(batchNoArr[i]);
					storeLoaninTObj.setFreeQty(freeQty[i]);

					if (freeItemArr[i].equalsIgnoreCase("y")) {
						storeLoaninTObj.setFreeItem("y");
					} else {
						storeLoaninTObj.setFreeItem("n");
					}
					storeLoaninTObj.setLotNo(lotNoArr[i]);
					storeLoaninTObj.setAcceptedModel(acceptedModel[i]);
					storeLoaninTObj.setAmcEndDate(amcEndDate[i]);
					storeLoaninTObj.setAmcStartDate(amcStartDate[i]);
					storeLoaninTObj.setWarrantyDate(warrantyDate[i]);
					storeLoaninTObj.setInstallationDate(installationDate[i]);
					storeLoaninTObj.setFinalCostPrice(costPrice[i]);

					if (manufacturerIdArray[i] != 0) {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(manufacturerIdArray[i]);
						storeLoaninTObj.setManufacturer(masManufacturer);
					}
					storeLoaninTlist.add(storeLoaninTObj);

				}

			}
		} catch (Exception e) {
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("loanInNo", loanInNo);
		infoMap.put("loanInId", loanInId);
		infoMap.put("pageNo", pageNo);
		infoMap.put("storeLoaninM", storeLoaninM);
		infoMap.put("storeItemBatchStock", storeItemBatchStock);
		infoMap.put("storeLoaninTlist", storeLoaninTlist);
		infoMap.put("deptId", deptId);
		infoMap.put("userName", userName);
		infoMap.put("hospitalId", hospitalId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addLoanIn(infoMap);

		} catch (Exception e) {
		}
		String messageTOBeVisibleToTheUser = "";

		if (flag) {

			pageNo++;
			messageTOBeVisibleToTheUser = "LoanIn Records Added Successfully";
		} else {
			messageTOBeVisibleToTheUser = "LoanIn Records Not Added, Some Error";
		}
		jsp = "neLoanIn";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showNeLoanInJsp";
		map.put("loanInNo", loanInNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}

	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.
	public ModelAndView showInfoOfNeLoanInJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreLoaninT> loanInMoreInfoList = new ArrayList<StoreLoaninT>();
		map = storesHandlerService.getDetailsForLoanIn();
		int rowNo = 0;
		int loaninDetailId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			loaninDetailId = Integer.parseInt(request.getParameter("detailId"));
			loanInMoreInfoList = nonExpendableStoresHandlerService
					.getLoanInListForMoreInfo(loaninDetailId);
			map.put("loanInMoreInfoList", loanInMoreInfoList);
		}
		jsp = MORE_INFO_NE_LOANIN_JSP;
		title = "LOAN IN";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchLoanin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Box box = HMSUtil.getBox(request);
		String fromDate = "";
		String toDate = "";
		String loanInNo = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<StoreLoaninM> searchLoanInList = new ArrayList<StoreLoaninM>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);

			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);

			}
			if (request.getParameter(LOANIN_NO) != null) {
				loanInNo = request.getParameter(LOANIN_NO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("loanInNo", loanInNo);
		try {
			tempMap = nonExpendableStoresHandlerService.showNeLoanInJsp(box,
					dataMap);
			if (tempMap.get("searchLoanInList") != null) {
				searchLoanInList = (List) tempMap.get("searchLoanInList");
			}
			map = nonExpendableStoresHandlerService
					.searchLoanin(searchFieldMap);
			map.put("searchLoanInList", searchLoanInList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SEARCH__NE_LOANIN;
		jsp = jsp + ".jsp";
		title = "LOANIN";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView modifyLoanin(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		jsp = MODIFY_NE_LOANIN_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) nonExpendableStoresHandlerService
					.modifyLoanin(radio_str, 0);
		}
		dataMap.put("deptId", deptId);
		purchaseMap = nonExpendableStoresHandlerService.showNeLoanInJsp(box,
				dataMap);
		List<StoreLoaninM> loaninList = nonExpendableStoresHandlerService
				.getloanList(dataMap);

		map.put("purchaseMap", purchaseMap);
		map.put("loaninList", loaninList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------- new grid
	// method---------------------------

	public ModelAndView getItemListForLoanInByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String sos = box.getString("sourceOfSupply").trim();
		String itemNameField = "";
		String autoHint = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (sos.equalsIgnoreCase("d") || (sos.equalsIgnoreCase("s"))) {
			if (request.getParameter("indentId") != null) {
				indentId = Integer.parseInt((request.getParameter("indentId")));
			}
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("indentId", indentId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForLoanInByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForLoanIn(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String nomenclature = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			nomenclature = (request.getParameter("requiredField"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("nomenclature", nomenclature);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForLoanIn(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	// ================= WORK ORDER=======================
	public ModelAndView showWorkOrderJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		String departmentName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("departmentName") != null) {
			departmentName = (String) session.getAttribute("departmentName");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put("departmentName", departmentName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService
				.getWorkOrderList();
		map = nonExpendableStoresHandlerService.showWorkOrderJsp(box, dataMap);
		jsp = WORK_ORDER_JSP;
		jsp = jsp + ".jsp";
		title = "WORK ORDER";
		map.put("workOrderList", workOrderList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemListForWorkOrderByAutocomplete(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String autoHint = "";
		int indentId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String userName = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("box", box);
		map = nonExpendableStoresHandlerService
				.getItemListForWorkOrderByAutocomplete(dataMap);
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		String itemNameField = "";
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = (request.getParameter("pvmsNo"));
		}
		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		List<StoreItemBatchStock> batchList = new ArrayList<StoreItemBatchStock>();

		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		map = nonExpendableStoresHandlerService.fillItemsForWorkOrder(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		if (map.get("batchList") != null) {
			batchList = (List) map.get("batchList");
		}

		StringBuffer sb = new StringBuffer();
		try {
			for (MasStoreItem masStoreItem : itemList) {

				sb.append("<item>");
				sb.append("<id>" + masStoreItem.getId() + "</id>");
				sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
				sb.append("<au>"
						+ masStoreItem.getItemConversion().getItemUnitName()
						+ "</au>");
				sb.append("<batchs>");
				for (StoreItemBatchStock batch : batchList) {
					sb.append("<batch>");
					sb.append("<batchId>" + batch.getId() + "</batchId>");
					sb.append("<batchName>" + batch.getBatchNo()
							+ "</batchName>");
					sb.append("</batch>");
				}
				sb.append("</batchs>");
				sb.append("</item>");
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "WORK ORDER REPORT";
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService
				.getWorkOrderList();
		jsp = WORK_ORDER_REPORT;
		jsp = jsp + ".jsp";
		map.put("workOrderList", workOrderList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkOrderReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		byte[] bytes = null;

		int workOrderId = 0;
		session = request.getSession();
		try {

			if (request.getParameter(WORK_ORDER_ID) != null
					&& !(request.getParameter(WORK_ORDER_ID).equals(""))) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));
			}
			requestParameters.put("workOrderId", workOrderId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = nonExpendableStoresHandlerService
				.getConnectionForReport();
		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("work_order_performa"),
					requestParameters, (Connection) connectionMap.get("con"));

		} catch (JRException e) {

			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ========= common function for report

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	// ==================== end of common function ==================
	public ModelAndView submitWorkOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		StoreWorkOrderM storeWorkOrderM = new StoreWorkOrderM();
		StoreWorkOrderT storeWorkOrderT = new StoreWorkOrderT();
		int workOrderId = 0;
		Date workOrderDate = new Date();
		String encodedBy = "";
		Date encodedDate = null;
		String lastChgBy = "A";
		Date lastChgDate = null;
		String lastChgTime = "";
		int departmentId = 0;
		String date = "";
		String time = "";
		int noOfRows = 0;
		int pageNo = 1;
		String buttonFlag = "";
		String repairingCell = "";
		int hospitalId = 0;
		String workOrderNo = "";
		String authority = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		try {
			if (request.getParameter("pageNo") != null) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));

			}
			if (request.getParameter(NO_OF_ROWS) != null) {
				noOfRows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
			}
			if (request.getParameter(WORK_ORDER_ID) != null) {
				workOrderId = Integer.parseInt(request
						.getParameter(WORK_ORDER_ID));

			}

			if (request.getParameter(HOSPITAL_ID) != null) {
				hospitalId = Integer
						.parseInt(request.getParameter(HOSPITAL_ID));
			}

			if (request.getParameter(AUTHORITY) != null) {
				authority = request.getParameter(AUTHORITY);
			}
			if (request.getParameter(WORK_ORDER_NO) != null) {
				workOrderNo = request.getParameter(WORK_ORDER_NO);
			}
			if (request.getParameter(REPAIRING_CELL) != null) {
				repairingCell = request.getParameter(REPAIRING_CELL);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String te = "";

			if (request.getParameter(WORK_ORDER_DATE) != null) {
				te = (String) (request.getParameter(WORK_ORDER_DATE));

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(request.getParameter(WORK_ORDER_DATE)));
				workOrderDate = java.sql.Date.valueOf(date4MySQL);
			}
		} catch (Exception e) {
		}

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String headerStored = "no";

		if (pageNo == 1) {

			storeWorkOrderM.setAuthorityNo(authority);
			storeWorkOrderM.setRepairingCell(repairingCell);
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			storeWorkOrderM.setDepartment(masDepartment);

			storeWorkOrderM.setWorkOrderDate(workOrderDate);
			storeWorkOrderM.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storeWorkOrderM.setLastChgTime(time);
			storeWorkOrderM.setStatus("y");

			MasHospital masHospital = new MasHospital();
			masHospital.setId(1);
			storeWorkOrderM.setHospital(masHospital);

			storeWorkOrderM.setLastChgBy("admin");
			storeWorkOrderM.setStatus("o");
			storeWorkOrderM.setWorkOrderNo(workOrderNo);

		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
		}
		int length = 0;
		List<StoreWorkOrderT> storeWorkOrderTlist = new ArrayList<StoreWorkOrderT>();

		try {
			String srNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, SR_NO);
			int itemIdArray[] = JKTRequestUtils.getRequiredIntParameters(
					request, ITEM_ID);
			String remarks[] = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			String natureOfWork[] = JKTRequestUtils
					.getRequiredStringParameters(request, NATURE_OF_WORK);
			int quantityReceivedArray[] = JKTRequestUtils
					.getRequiredIntParameters(request, QUANTITY_RECEIVED);
			String batchNo[] = JKTRequestUtils.getRequiredStringParameters(
					request, BATCH_ID);

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRows;
			}

			for (int i = 0; i < length; i++) {
				if (itemIdArray[i] != 0) {

					StoreWorkOrderT storeWOrderTObj = new StoreWorkOrderT();
					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArray[i]);
					storeWOrderTObj.setItem(masItem);

					storeWOrderTObj.setRemarks(remarks[i]);
					storeWOrderTObj.setSrNo(srNo[i]);
					storeWOrderTObj.setQuantity(quantityReceivedArray[i]);
					storeWOrderTObj.setNatureOfWork(natureOfWork[i]);
					storeWOrderTObj.setSerialNo(batchNo[i]);
					storeWorkOrderTlist.add(storeWOrderTObj);
				}

			}
		} catch (Exception e) {
		}

		infoMap.put("pageNo", pageNo);
		infoMap.put("workOrderNo", workOrderNo);
		infoMap.put("workOrderId", workOrderId);
		infoMap.put("storeWorkOrderM", storeWorkOrderM);
		infoMap.put("storeWorkOrderTlist", storeWorkOrderTlist);
		infoMap.put("deptId", deptId);

		boolean flag = false;
		try {
			flag = nonExpendableStoresHandlerService.addWorkOrder(infoMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}

		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order  Entry has  been done Successfully";
				map = nonExpendableStoresHandlerService.showWorkOrderJsp(box,
						dataMap);
				if (map.get("workOrderId") != null) {
					workOrderId = (Integer) map.get("workOrderId");
				}

			} else {
				jsp = WORK_ORDER_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Work Order Entry has been done Successfully";
			}
		} else {
			messageTOBeVisibleToTheUser = "Work Order Entry has not been done Successfully";
		}

		jsp = "workOrder";
		jsp += ".jsp";
		String url = "";
		url = "/hms/hms/neStores?method=showWorkOrderJsp";
		// map.put("workOrderNo",workOrderNo);
		map.put("pageNo", pageNo);
		map.put("contentJsp", jsp);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchWorkOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession(true);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		List<StoreWorkOrderM> workOrderList = nonExpendableStoresHandlerService
				.getWorkOrderList();

		int workOrderId = 0;
		if (request.getParameter(WORK_ORDER_ID) != null) {
			workOrderId = Integer.parseInt(request.getParameter(WORK_ORDER_ID));

		}
		Box box = HMSUtil.getBox(request);

		box.put("workOrderId", workOrderId);
		int pageNo = 1;
		jsp = MODIFY_WORK_ORDER;
		jsp += ".jsp";
		int radio_str = 0;
		if (request.getParameter(WORK_ORDER_NO) != null) {
			radio_str = Integer.parseInt(request.getParameter(WORK_ORDER_NO));
			map = (Map) nonExpendableStoresHandlerService.getWorkOrderModify(
					radio_str, pageNo);
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		map.put("workOrderList", workOrderList);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showGrnReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);

		title = "GRN REPORT";
		List<StoreGrnM> crvNumberList = nonExpendableStoresHandlerService
				.getCrvNumberList(dataMap);
		jsp = NE_GRN_REPORT;
		jsp = jsp + ".jsp";
		map.put("crvNumberList", crvNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateCrvReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String grnNo = null;
		String flag = null;
		int deptId = 0;
		byte[] bytes = null;

		session = request.getSession();
		if (request.getParameter(GRN_NO) != null
				&& !(request.getParameter(GRN_NO).equals(""))) {
			grnNo = request.getParameter(GRN_NO);
		}

		deptId = (Integer) session.getAttribute("deptId");
		requestParameters = storesHandlerService.getDBConnection();
		requestParameters.put("Dept_ID", deptId);
		requestParameters.put("CRV_No", grnNo);
		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		try {

			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("CertificateReceiptVoucher"),
					requestParameters, (Connection) connectionMap.get("con"));

		} catch (JRException e) {

			e.printStackTrace();
		}
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	// ===================================================================================
	// =============== end of methods by abha
	// ======================================
	// ====================================================================================

	// ===================================================================================
	// =============== start of methods by hitesh
	// ======================================
	// ====================================================================================
	public ModelAndView amcMaintenanceViewJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showAmcMaintenanceJsp(box);
		jsp = AMC_MAINTENANCE_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		List<String> entryNoList = new ArrayList<String>();
		List<StoreAmcM> docentryList = new ArrayList<StoreAmcM>();
		if (map.get("departmentList") != null) {
			departmentList = (List) map.get("departmentList");
		}
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		docentryList = nonExpendableStoresHandlerService.getDocEntryNo();
		map.put("suppList", suppList);
		map.put("docentryList", docentryList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getNomenclature(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = SHOW_AMC_NOMENCLATURE_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getNomenclatureSearch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		departmentId = Integer.parseInt(request.getParameter("departmentId"));
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = SHOW_AMC_SEARCH_NOMENCLATURE_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPvmsNoAndGetSerialNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		nomenclatureId = Integer.parseInt(request.getParameter("nomenclature"));
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_PVMS_AND_SERIALNO_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoforSearch(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		nomenclatureId = Integer.parseInt(request.getParameter("nomenclature"));
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_SERIALNO_SEARCH_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		String serialNo = "";
		int itemId = 0;
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		itemId = Integer.parseInt(request.getParameter("nomenclature"));
		serialNo = request.getParameter(SERIAL_NUMBER);
		map = nonExpendableStoresHandlerService.getSerialNoDetails(serialNo,
				itemId);
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		map.put("suppList", suppList);
		jsp = SHOW_AMC_SERIALNO_DETAIL_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addOrUpdateAmcMaintenance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreAmcT> storeList = new ArrayList<StoreAmcT>();

		String supplyOrderNo = null;
		String crvNo = null;
		int id = 0;
		Date dofInstallation, fASDate, warantStartDate, warantEndDate, supptStartDate, supptEndDate = null;
		String dateofInstallation = "";
		String warrantyStartDate = null;
		String warrantyEndDate = null;
		String supportEndDate = null;
		String supportStartDate = null;
		Date fasd = null;
		Date amcEndDate = null;
		Date entDate = null;
		BigDecimal totalRecievedQty = null;
		String costOfEquipment = null;
		BigDecimal costEquipment = null;
		BigDecimal advBillAmount = null;
		BigDecimal balanceBillNo = null;
		BigDecimal balanceBillAmount = null;
		BigDecimal costAmc = null;
		String departmentCode = "";
		String pvmsNO = "";
		int itemId = 0;
		String serialNo = "";
		String entryDate = "";
		String firstAmcStartDate = "";
		String docEntryNo = "";
		Date wsd = null;
		Date wed = null;
		Date ssd = null;
		Date sed = null;
		Date installationDate = null;
		Date amcStartDate = null;
		Date advBDate = null;
		boolean flag1 = false;
		Date balanceBillDate = null;
		int noOfRows = 0;
		Date amcDtFrom = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		int departmentId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");

		StoreAmcM storeAmcM = new StoreAmcM();

		MasDepartment masDepartment = new MasDepartment();
		MasDepartment masDepartment1 = new MasDepartment();
		MasStoreItem masStoreItem = new MasStoreItem();
		MasHospital masHospital = new MasHospital();
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		masHospital.setId(hospitalId);
		departmentId = (Integer) session.getAttribute("deptId");
		masDepartment1.setId(departmentId);
		try {

			if (request.getParameter("docentryno") != null) {
				docEntryNo = request.getParameter("docentryno");
			}
			if (request.getParameter("departmentId") != null) {
				departmentCode = request.getParameter("departmentId");
			}
			if (request.getParameter("nomenclature") != null) {
				itemId = Integer.parseInt(request.getParameter("nomenclature"));
			}
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNO = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(FIRST_AMC_START_DATE) != null) {
				firstAmcStartDate = (request.getParameter(FIRST_AMC_START_DATE));
			}
			if (request.getParameter(CRV) != null) {
				crvNo = (request.getParameter(CRV));
			}
			if (request.getParameter(ENTRY_DATE) != null) {
				entryDate = (request.getParameter(ENTRY_DATE));
			}
			if (request.getParameter(SUPPLY_ORDER_NO) != null) {
				supplyOrderNo = (request.getParameter(SUPPLY_ORDER_NO));
			}

			if (request.getParameter(COST) != null
					&& request.getParameter(COST) != "") {
				costOfEquipment = (request.getParameter(COST));
				if (costOfEquipment.equalsIgnoreCase("null")) {
					BigDecimal val = new BigDecimal(0);
					costEquipment = val;

				} else {
					BigDecimal val = new BigDecimal(costOfEquipment);
					costEquipment = val;

				}

			}

			if (request.getParameter(WARRANTY_DATE) != null) {
				warrantyStartDate = (request.getParameter(WARRANTY_DATE));
			}
			if (request.getParameter(WARRANTY_END_DATE) != null) {
				warrantyEndDate = (request.getParameter(WARRANTY_END_DATE));
			}
			if (request.getParameter(SUPPORT_START_DATE) != null) {
				supportStartDate = (request.getParameter(SUPPORT_START_DATE));
			}
			if (request.getParameter(SUPPORT_END_DATE) != null) {
				supportEndDate = (request.getParameter(SUPPORT_END_DATE));
			}
			if (request.getParameter(INSTALLATION_DATE) != null) {
				dateofInstallation = (request.getParameter(INSTALLATION_DATE));
			}
			if (request.getParameter(TOTAL_QUANTITY_RECIEVED) != null
					&& !request.getParameter(TOTAL_QUANTITY_RECIEVED)
							.equalsIgnoreCase("null")) {
				totalRecievedQty = new BigDecimal(
						request.getParameter(TOTAL_QUANTITY_RECIEVED));
			}

			if (entryDate != "" && entryDate != "0") {
				entDate = HMSUtil.convertStringTypeDateToDateType(entryDate);
			}
			if (firstAmcStartDate != "" && firstAmcStartDate != "0"
					&& !firstAmcStartDate.equalsIgnoreCase("null")) {
				fasd = HMSUtil
						.convertStringTypeDateToDateType(firstAmcStartDate);
			}
			if (warrantyStartDate != "" && warrantyStartDate != "0"
					&& !warrantyStartDate.equalsIgnoreCase("null")) {
				wsd = HMSUtil
						.convertStringTypeDateToDateType(warrantyStartDate);
			}
			if (warrantyEndDate != "" && warrantyEndDate != "0"
					&& !warrantyEndDate.equalsIgnoreCase("null")) {
				wed = HMSUtil.convertStringTypeDateToDateType(warrantyEndDate);
			}
			if (supportStartDate != "" && supportStartDate != "0"
					&& !supportStartDate.equalsIgnoreCase("null")) {
				ssd = HMSUtil.convertStringTypeDateToDateType(supportStartDate);
			}
			if (supportEndDate != "" && supportEndDate != "0"
					&& !supportEndDate.equalsIgnoreCase("null")) {
				sed = HMSUtil.convertStringTypeDateToDateType(supportEndDate);
			}
			if (dateofInstallation != "" && dateofInstallation != "0"
					&& !dateofInstallation.equalsIgnoreCase("null")) {
				installationDate = HMSUtil
						.convertStringTypeDateToDateType(dateofInstallation);
			}

			masDepartment.setDepartmentCode(departmentCode);
			masStoreItem.setId(itemId);
			// storeAmcM.setId(id);
			storeAmcM.setEntryDate(entDate);
			storeAmcM.setDepartment(masDepartment1);
			storeAmcM.setEquipmentDept(masDepartment);
			storeAmcM.setItem(masStoreItem);
			storeAmcM.setSerialNo(serialNo);
			storeAmcM.setTotReceivedQty(totalRecievedQty);
			storeAmcM.setFirstAmcStartDate(fasd);
			storeAmcM.setEntryNo(docEntryNo);
			storeAmcM.setSupplyOrderNo(supplyOrderNo);
			storeAmcM.setCrvNo(crvNo);
			storeAmcM.setCostOfEquipment(costEquipment);
			storeAmcM.setDateOfInstallation(installationDate);
			storeAmcM.setWarrantyStartDate(wsd);
			storeAmcM.setWarrantyEndDate(wed);
			storeAmcM.setSupportStartDate(ssd);
			storeAmcM.setSupportEndDate(sed);
			storeAmcM.setLastChagTime(time);
			storeAmcM.setLastChgBy(userid);
			storeAmcM.setLastChgDate(lastChgDate);
			storeAmcM.setHospitalId(hospitalId);
			storeAmcM.setStatus("o");

			try {

				noOfRows = Integer.parseInt(request
						.getParameter("amcTDetailListSize"));
				String supplierCode[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_CONTRACT);
				String amcDateFrom[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_START_DATE);
				String amcDateTo[] = JKTRequestUtils
						.getRequiredStringParameters(request, AMC_END_DATE);
				String advBillNo[] = JKTRequestUtils
						.getRequiredStringParameters(request, ADDVANCE_BILL_NO);
				String advBillDate[] = JKTRequestUtils
						.getRequiredStringParameters(request,
								ADDVANCE_BILL_DATE);
				String balBillNo[] = JKTRequestUtils
						.getRequiredStringParameters(request, BALANCE_NO);
				String balBillDate[] = JKTRequestUtils
						.getRequiredStringParameters(request, BALANCE_BILL_DATE);
				String remarks[] = JKTRequestUtils.getRequiredStringParameters(
						request, REMARKS);

				BigDecimal[] costofAmc = new BigDecimal[10];
				BigDecimal[] advBillAmt = new BigDecimal[10];
				BigDecimal[] balBillAmt = new BigDecimal[10];

				String tt[] = JKTRequestUtils.getRequiredStringParameters(
						request, COST_OF_AMC);
				int ttLen = tt.length;
				for (int i = 0; i < ttLen; i++) {
					if (tt[i] != null || tt[i] != "") {
						BigDecimal val = new BigDecimal(tt[i]);
						costofAmc[i] = val;
					}
				}

				String zz[] = JKTRequestUtils.getRequiredStringParameters(
						request, ADDVANCE_BILL_AMOUNT);
				int zzLen = zz.length;
				for (int i = 0; i < zzLen; i++) {
					if (zz[i] != null || zz[i] != "") {
						BigDecimal val = new BigDecimal(zz[i]);
						advBillAmt[i] = val;
					}
				}
				String qq[] = JKTRequestUtils.getRequiredStringParameters(
						request, BALANCE_AMOUNT);
				int qqLen = qq.length;
				for (int i = 0; i < qqLen; i++) {
					BigDecimal val = new BigDecimal(qq[i]);
					balBillAmt[i] = val;
				}

				for (int j = 0; j < noOfRows; j++) {
					StoreAmcT storeAmcT = new StoreAmcT();

					MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
					masStoreSupplier.setSupplierCode(supplierCode[j]);
					storeAmcT.setAmcCompany(masStoreSupplier);

					if (!amcDateFrom[j].equals("")) {
						amcStartDate = HMSUtil
								.dateFormatterDDMMYYYY(amcDateFrom[j]);
					}
					storeAmcT.setAmcStartDate(amcStartDate);

					if (!amcDateTo[j].equals("")) {
						amcEndDate = HMSUtil
								.dateFormatterDDMMYYYY(amcDateTo[j]);
					}
					storeAmcT.setAmcEndDate(amcEndDate);
					storeAmcT.setCostOfAmc(costofAmc[j]);
					storeAmcT.setAdvBillNo(advBillNo[j]);
					if (!advBillDate[j].equals("")) {

						advBDate = HMSUtil
								.dateFormatterDDMMYYYY(advBillDate[j]);
					}
					storeAmcT.setAdvBillDate(advBDate);

					storeAmcT.setAdvBillAmount(advBillAmt[j]);
					storeAmcT.setBalanceBillNo(balBillNo[j]);
					if (balBillDate[j] != "") {
						balanceBillDate = HMSUtil
								.dateFormatterDDMMYYYY(balBillDate[j]);
					}
					storeAmcT.setBalanceBillDate(balanceBillDate);
					storeAmcT.setBalanceBillAmount(balBillAmt[j]);
					storeAmcT.setRemarks(remarks[j]);
					storeAmcT.setAmcM(storeAmcM);
					storeList.add(storeAmcT);
				}
				try {
					flag1 = nonExpendableStoresHandlerService
							.addAmcMDetailsandaddAmcTDetails(storeAmcM,
									storeList);

				} catch (Exception e) {

				}

			} catch (Exception e) {

			}

			String messageTOBeVisibleToTheUser = "";
			if (flag1) {

				messageTOBeVisibleToTheUser = "Records Added Successfully";
			} else {
				messageTOBeVisibleToTheUser = "Records Not Added, Some Error";
			}
			jsp = "message";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView amcSearchResult(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		List<StoreAmcM> docentryList = new ArrayList<StoreAmcM>();
		List<StoreAmcT> amcTlist = new ArrayList<StoreAmcT>();
		List amcMaintenanceDetails = new ArrayList();
		StoreAmcM amcMDetails = null;
		String docEntryNo = "";
		int departmentCode = 0;
		int itemId = 0;
		String serialNo = "";
		if (request.getParameter("docentryno") != null) {
			docEntryNo = request.getParameter("docentryno");
		}
		if (request.getParameter("departmentId") != null
				&& request.getParameter("departmentId") != "") {
			departmentCode = Integer.parseInt(request
					.getParameter("departmentId"));
		}
		if (request.getParameter("nomenclature") != null
				&& request.getParameter("nomenclature") != "") {
			itemId = Integer.parseInt(request.getParameter("nomenclature"));
		}
		if (request.getParameter(SERIAL_NUMBER) != null
				&& request.getParameter("SERIAL_NUMBER") != "") {
			serialNo = request.getParameter(SERIAL_NUMBER);
		}
		searchFieldMap.put("docentryno", docEntryNo);
		searchFieldMap.put("departmentId", departmentCode);
		searchFieldMap.put("nomenclature", itemId);
		searchFieldMap.put("SERIAL_NUMBER", serialNo);
		map = nonExpendableStoresHandlerService.getNomenclature(departmentCode);
		suppList = nonExpendableStoresHandlerService.getSupplierList();
		docentryList = nonExpendableStoresHandlerService.getDocEntryNo();
		map = nonExpendableStoresHandlerService
				.getAmcSearchResult(searchFieldMap);
		if (map.get("amcMaintenanceDetails") != null) {
			amcMaintenanceDetails = (List) map.get("amcMaintenanceDetails");
			for (int i = 0; i < amcMaintenanceDetails.size(); i++) {
				amcMDetails = (StoreAmcM) amcMaintenanceDetails.get(i);
				int id = amcMDetails.getId();
				amcTlist = nonExpendableStoresHandlerService.getStoreAmcT(id);
			}
		}
		map.put("amcTDetailsList", amcTlist);
		map.put("suppList", suppList);
		map.put("docentryList", docentryList);

		jsp = AMC_MAINTENANCE_SEARCH_RESULT_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView amcRepairViewJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		List<String> repairNoList = new ArrayList<String>();
		List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer departmentId = null;
		session = request.getSession();
		departmentId = (Integer) session.getAttribute("deptId");
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		jsp = AMC_REPAIR_JSP;
		jsp = jsp + ".jsp";
		title = "AMC";
		repairNoList = nonExpendableStoresHandlerService.getRepairNoList();
		storerepairList = nonExpendableStoresHandlerService.getRepairNo();
		map.put("repairNoList", repairNoList);
		map.put("storerepairList", storerepairList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPvmsNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;

		if (request.getParameter(NOMENCLATURE) != null
				&& !request.getParameter(NOMENCLATURE).equals("")) {
			nomenclatureId = Integer.parseInt(request
					.getParameter(NOMENCLATURE));
		} else {
			nomenclatureId = 0;
		}
		map = nonExpendableStoresHandlerService
				.getPvmsNoAndGetSerialNo(nomenclatureId);
		jsp = SHOW_AMC_PVMS_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSerialNoAmcRepairDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String serialNo = "";
		int itemId = 0;
		List<MasStoreSupplier> suppList = new ArrayList<MasStoreSupplier>();
		itemId = Integer.parseInt(request.getParameter(NOMENCLATURE));
		serialNo = request.getParameter(SERIAL_NUMBER);
		map = nonExpendableStoresHandlerService.getSerialNoDetails(serialNo,
				itemId);
		jsp = SHOW_AMC_SERIALNO_REPAIR_DETAIL_JSP;
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addAmcRepair(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MasDepartment masDepartment = new MasDepartment();
		MasHospital masHospital = new MasHospital();
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		masHospital.setId(hospitalId);
		masDepartment.setId(deptId);
		String repairNo = "";
		String commandrepaircell = "";
		String repairDate = "";
		String certificatefromeme = "";
		int itemId = 0;
		String pvmsNo = "";
		String breakdownrepaircharges = "";
		String au = "";
		String reasonablenesscost = "";
		int quantity = 0;
		String costOfRepair = "";
		String nuumberoftimeseqpt = "";
		String crv = "";
		String serialNo = "";
		String sourceofreciept = "";
		String amceneteredlasttime = "";
		String quantitycondition = "";
		int quantityrequired = 0;
		String natureofrepair = "";
		String cost = "";
		String compartivequatations = "";
		String reasonforrecommending = "";
		BigDecimal costRepair = null;
		Date repdate = null;
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		BigDecimal costofEquipment = null;
		BigDecimal reasonablecost = null;
		int id = 0;
		try {

			if (request.getParameter("repairno") != null) {
				repairNo = request.getParameter("repairno");
			}
			if (request.getParameter("REPAIR_CELL") != null) {
				commandrepaircell = request.getParameter("REPAIR_CELL");
			}
			if (request.getParameter("repairdate") != null) {
				repairDate = request.getParameter("repairdate");
				repdate = HMSUtil.convertStringTypeDateToDateType(repairDate);

			}
			if (request.getParameter("CERTIFICATE_FROM_DEPENDENT_EME") != null) {
				certificatefromeme = request
						.getParameter("CERTIFICATE_FROM_DEPENDENT_EME");
			}
			if (request.getParameter(NOMENCLATURE) != null) {
				itemId = Integer.parseInt(request.getParameter(NOMENCLATURE));
			}
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNo = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(BREAKDOWN_REPAIR_CHARGES) != null) {
				breakdownrepaircharges = (request
						.getParameter(BREAKDOWN_REPAIR_CHARGES));
			}
			if (request.getParameter(AU) != null) {
				au = (request.getParameter(AU));
			}
			if (request.getParameter(REASONABLENESS_OF_COST) != null) {
				reasonablenesscost = (request
						.getParameter(REASONABLENESS_OF_COST));
				BigDecimal val = new BigDecimal(reasonablenesscost);
				reasonablecost = val;
			}
			if (request.getParameter(QUANTITY) != null) {
				quantity = Integer.parseInt((request.getParameter(QUANTITY)));
			}

			if (request.getParameter(COST_OF_REPAIR) != null
					&& request.getParameter(COST_OF_REPAIR) != "") {
				costOfRepair = (request.getParameter(COST_OF_REPAIR));

			}
			if (request.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT) != null) {
				nuumberoftimeseqpt = (request
						.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT));
			}
			if (request.getParameter(CRV) != null) {
				crv = (request.getParameter(CRV));
			}
			if (request.getParameter(SOURCE_OF_RECIEPT) != null) {
				sourceofreciept = (request.getParameter(SOURCE_OF_RECIEPT));
			}
			if (request.getParameter(AMC_ENTERED_LAST_TIME) != null) {
				amceneteredlasttime = (request
						.getParameter(AMC_ENTERED_LAST_TIME));
			}
			if (request.getParameter(QUANTITY_HELD_WITH_CONDITION) != null) {
				quantitycondition = (request
						.getParameter(QUANTITY_HELD_WITH_CONDITION));
			}
			if (request.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED) != null) {
				quantityrequired = Integer.parseInt(request
						.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED));
			}
			if (request.getParameter(NATURE_OF_REPAIR) != null) {
				natureofrepair = (request.getParameter(NATURE_OF_REPAIR));
			}
			if (request.getParameter(COST) != null) {
				cost = (request.getParameter(COST));
				BigDecimal val = new BigDecimal(cost);
				costofEquipment = val;
			}
			if (request.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS) != null) {
				compartivequatations = request
						.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS);
			}
			if (request.getParameter(REASON_FOR_RECOMMENDING) != null) {
				reasonforrecommending = request
						.getParameter(REASON_FOR_RECOMMENDING);
			}
			try {

				storeRepairCivilFirm = new StoreRepairCivilFirm();
				MasStoreItem storeItem = new MasStoreItem();
				storeItem.setId(itemId);
				storeRepairCivilFirm.setRepairNo(repairNo);
				storeRepairCivilFirm.setRepairDate(repdate);
				storeRepairCivilFirm.setSerialNo(serialNo);
				storeRepairCivilFirm.setItem(storeItem);
				storeRepairCivilFirm.setCrvNo(crv);
				storeRepairCivilFirm.setQty(quantity);
				storeRepairCivilFirm.setSourceOfReceipt(sourceofreciept);
				storeRepairCivilFirm.setLastChgBy(userid);
				storeRepairCivilFirm.setLastChgDate(lastChgDate);
				storeRepairCivilFirm.setLastChgTime(time);
				storeRepairCivilFirm.setConditionOfItem(quantitycondition);
				storeRepairCivilFirm.setQtyRepair(quantityrequired);
				storeRepairCivilFirm.setBlrBerCertificate(certificatefromeme);
				storeRepairCivilFirm
						.setComparativeStatOfQuotation(compartivequatations);
				storeRepairCivilFirm.setCostOfEquipment(costofEquipment);
				storeRepairCivilFirm.setCostOfRepair(costOfRepair);
				storeRepairCivilFirm.setDepartment(masDepartment);
				storeRepairCivilFirm.setHospital(masHospital);
				storeRepairCivilFirm.setLastCostOfRepair(amceneteredlasttime);
				storeRepairCivilFirm.setNatureOfRepair(natureofrepair);
				storeRepairCivilFirm.setNoOfTimeOutorder(nuumberoftimeseqpt);
				storeRepairCivilFirm.setRepairBreakdown(breakdownrepaircharges);
				storeRepairCivilFirm.setReasonableOfRepairCost(reasonablecost);
				storeRepairCivilFirm
						.setReasonForRecommend(reasonforrecommending);
				storeRepairCivilFirm.setStatus("o");
			} catch (Exception e) {
			e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			map = nonExpendableStoresHandlerService
					.addStoreRepairCivilFirm(storeRepairCivilFirm);

		} catch (Exception e) {
		}

		jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateStoreRepairCivilFirm(HttpServletRequest request,
			HttpServletResponse response) {
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		StoreRepairCivilFirm storeRepairCivilFirm = null;
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		MasDepartment masDepartment = new MasDepartment();
		MasHospital masHospital = new MasHospital();
		String userid = "";
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		userid = (String) session.getAttribute("loginName");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		deptId = (Integer) session.getAttribute("deptId");
		masHospital.setId(hospitalId);
		masDepartment.setId(deptId);
		String repairNo = "";
		String commandrepaircell = "";
		String repairDate = "";
		String certificatefromeme = "";
		int itemId = 0;
		String pvmsNo = "";
		String breakdownrepaircharges = "";
		String au = "";
		String reasonablenesscost = "";
		int quantity = 0;
		String costOfRepair = "";
		String nuumberoftimeseqpt = "";
		String crv = "";
		String serialNo = "";
		String sourceofreciept = "";
		String amceneteredlasttime = "";
		String quantitycondition = "";
		int quantityrequired = 0;
		String natureofrepair = "";
		String cost = "";
		String compartivequatations = "";
		String reasonforrecommending = "";
		BigDecimal costRepair = null;
		Date repdate = null;
		Date lastChgDate = HMSUtil.convertStringTypeDateToDateType(date);
		BigDecimal costofEquipment = null;
		BigDecimal reasonablecost = null;
		int id = 0;
		try {
			if (request.getParameter("repairid") != null
					&& request.getParameter("repairid") != "") {
				id = Integer.parseInt(request.getParameter("repairid"));
			}
			if (request.getParameter("repairno") != null) {
				repairNo = request.getParameter("repairno");
			}
			if (request.getParameter("REPAIR_CELL") != null) {
				commandrepaircell = request.getParameter("REPAIR_CELL");
			}
			if (request.getParameter("repairdate") != null) {
				repairDate = request.getParameter("repairdate");
				repdate = HMSUtil.convertStringTypeDateToDateType(repairDate);

			}
			if (request.getParameter("CERTIFICATE_FROM_DEPENDENT_EME") != null) {
				certificatefromeme = request
						.getParameter("CERTIFICATE_FROM_DEPENDENT_EME");
			}
			if (request.getParameter(NOMENCLATURE) != null) {
				itemId = Integer.parseInt(request.getParameter(NOMENCLATURE));
			}
			if (request.getParameter(PVMS_NO) != null) {
				pvmsNo = request.getParameter(PVMS_NO);
			}
			if (request.getParameter(SERIAL_NUMBER) != null) {
				serialNo = request.getParameter(SERIAL_NUMBER);
			}
			if (request.getParameter(BREAKDOWN_REPAIR_CHARGES) != null) {
				breakdownrepaircharges = (request
						.getParameter(BREAKDOWN_REPAIR_CHARGES));
			}
			if (request.getParameter(AU) != null) {
				au = (request.getParameter(AU));
			}
			if (request.getParameter(REASONABLENESS_OF_COST) != null) {
				reasonablenesscost = (request
						.getParameter(REASONABLENESS_OF_COST));
				BigDecimal val = new BigDecimal(reasonablenesscost);
				reasonablecost = val;
			}
			if (request.getParameter(QUANTITY) != null) {
				quantity = Integer.parseInt((request.getParameter(QUANTITY)));
			}

			if (request.getParameter(COST_OF_REPAIR) != null
					&& request.getParameter(COST_OF_REPAIR) != "") {
				costOfRepair = (request.getParameter(COST_OF_REPAIR));

			}
			if (request.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT) != null) {
				nuumberoftimeseqpt = (request
						.getParameter(NUMBER_OF_TIMES_EQPT_WENT_OUT));
			}
			if (request.getParameter(CRV) != null) {
				crv = (request.getParameter(CRV));
			}
			if (request.getParameter(SOURCE_OF_RECIEPT) != null) {
				sourceofreciept = (request.getParameter(SOURCE_OF_RECIEPT));
			}
			if (request.getParameter(AMC_ENTERED_LAST_TIME) != null) {
				amceneteredlasttime = (request
						.getParameter(AMC_ENTERED_LAST_TIME));
			}
			if (request.getParameter(QUANTITY_HELD_WITH_CONDITION) != null) {
				quantitycondition = (request
						.getParameter(QUANTITY_HELD_WITH_CONDITION));
			}
			if (request.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED) != null) {
				quantityrequired = Integer.parseInt(request
						.getParameter(QUANTITY_REQUIRED_TO_BE_REPAIRED));
			}
			if (request.getParameter(NATURE_OF_REPAIR) != null) {
				natureofrepair = (request.getParameter(NATURE_OF_REPAIR));
			}
			if (request.getParameter(COST) != null) {
				cost = (request.getParameter(COST));
				BigDecimal val = new BigDecimal(cost);
				costofEquipment = val;
			}
			if (request.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS) != null) {
				compartivequatations = request
						.getParameter(COMPARATIVE_STATEMENT_OF_QUATATIONS);
			}
			if (request.getParameter(REASON_FOR_RECOMMENDING) != null) {
				reasonforrecommending = request
						.getParameter(REASON_FOR_RECOMMENDING);
			}
			try {

				storeRepairCivilFirm = new StoreRepairCivilFirm();
				MasStoreItem storeItem = new MasStoreItem();
				storeItem.setId(itemId);
				storeRepairCivilFirm.setRepairNo(repairNo);
				storeRepairCivilFirm.setId(id);
				storeRepairCivilFirm.setRepairDate(repdate);
				storeRepairCivilFirm.setSerialNo(serialNo);
				storeRepairCivilFirm.setItem(storeItem);
				storeRepairCivilFirm.setCrvNo(crv);
				storeRepairCivilFirm.setQty(quantity);
				storeRepairCivilFirm.setSourceOfReceipt(sourceofreciept);
				storeRepairCivilFirm.setLastChgBy(userid);
				storeRepairCivilFirm.setLastChgDate(lastChgDate);
				storeRepairCivilFirm.setLastChgTime(time);
				storeRepairCivilFirm.setConditionOfItem(quantitycondition);
				storeRepairCivilFirm.setQtyRepair(quantityrequired);
				storeRepairCivilFirm.setBlrBerCertificate(certificatefromeme);
				storeRepairCivilFirm
						.setComparativeStatOfQuotation(compartivequatations);
				storeRepairCivilFirm.setCostOfEquipment(costofEquipment);
				storeRepairCivilFirm.setCostOfRepair(costOfRepair);
				storeRepairCivilFirm.setDepartment(masDepartment);
				storeRepairCivilFirm.setHospital(masHospital);
				storeRepairCivilFirm.setLastCostOfRepair(amceneteredlasttime);
				storeRepairCivilFirm.setNatureOfRepair(natureofrepair);
				storeRepairCivilFirm.setNoOfTimeOutorder(nuumberoftimeseqpt);
				storeRepairCivilFirm.setRepairBreakdown(breakdownrepaircharges);
				storeRepairCivilFirm.setReasonableOfRepairCost(reasonablecost);
				storeRepairCivilFirm
						.setReasonForRecommend(reasonforrecommending);
				storeRepairCivilFirm.setStatus("Y");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			map = nonExpendableStoresHandlerService
					.updateStoreRepairCivilFirm(storeRepairCivilFirm);

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAmcRepair(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int nomenclatureId = 0;
		String repairNO = "";
		List<MasStoreItem> nomenclatureList = new ArrayList<MasStoreItem>();
		List<StoreRepairCivilFirm> storerepairList = new ArrayList<StoreRepairCivilFirm>();
		Integer departmentId = null;
		session = request.getSession(true);
		departmentId = (Integer) session.getAttribute("deptId");
		map = nonExpendableStoresHandlerService.getNomenclature(departmentId);
		List<String> repairNoList = new ArrayList<String>();
		repairNoList = nonExpendableStoresHandlerService.getRepairNoList();
		if (map.get("nomenclatureList") != null) {
			nomenclatureList = (List) map.get("nomenclatureList");
		}
		if (request.getParameter("searchNomenclature") != null
				&& request.getParameter("searchNomenclature") != "") {
			nomenclatureId = Integer.parseInt(request
					.getParameter("searchNomenclature"));
		}

		if (request.getParameter("repairNo") != null
				&& request.getParameter("repairNo") != "") {
			repairNO = request.getParameter("repairNo");

		}
		map = nonExpendableStoresHandlerService.getAmcRepairDetails(
				nomenclatureId, repairNO);
		storerepairList = nonExpendableStoresHandlerService.getRepairNo();
		jsp = SHOW_AMC_REPAIR_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("repairNoList", repairNoList);
		map.put("title", title);
		map.put("nomenclatureList", nomenclatureList);
		map.put("storerepairList", storerepairList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBoarddofSurveyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		String userName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		map = nonExpendableStoresHandlerService.showBoardOfSurvey();
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp = jsp + ".jsp";
		title = "Board Of Survey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView createAndImportBosData(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.createAndImportBosData(box);
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp = jsp + ".jsp";
		title = "Board Of Survey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateGridItemsBos(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.updateGridItemsBos(box);
		jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		jsp += ".jsp";
		title = "Board Of Survey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBosData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String BosNo = request.getParameter(BOS_ID);
		map = nonExpendableStoresHandlerService.searchBosData(BosNo, box);
		jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateSearchGridItemsBos(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean updategrid = false;
		Box box = HMSUtil.getBox(request);
		map = nonExpendableStoresHandlerService.updateSearchGridItemsBos(box);
		jsp = SHOW_BOARD_OF_SURVEY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getBosData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Session-----
		session = request.getSession();
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getBosData(box);
		jsp = SHOW_BOARD_OF_SURVEY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBoardOfSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String bosNo = "";
		int deptId = 0;
		String subPath = "";
		File reportFile = new File(getServletContext().getRealPath("/Reports/"));
		if (request.getParameter(BOS_ID) != null) {
			bosNo = request.getParameter(BOS_ID);
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		detailsMap = nonExpendableStoresHandlerService.getConnectionForReport();
		parameters.put("Bos_No", bosNo);
		parameters.put("Dept_Id", deptId);
		subPath = reportFile.toString();
		parameters.put("SUBREPORT_DIR", subPath);
		try {
			byte bytes[] = null;
			try {
				bytes = JasperRunManager
						.runReportToPdf(
								getCompiledReport("NonExpendableMedicalStoresUnderBoardOfSurvey"),
								parameters, (Connection) detailsMap.get("con"));
			} catch (JRException e) {
				e.printStackTrace();
			}

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index");

	}

	// ===================================================================================
	// =============== end of methods by hitesh
	// ======================================
	// ====================================================================================

	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek ------------------------------------------
	// ****************************************************************************************************************

	// ============================Start of ME Scale Equipment
	// Details==============================
	public ModelAndView deleteMeScaleItems(HttpServletRequest request,
			HttpServletResponse response) {

		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		Box box = HMSUtil.getBox(request);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.deleteMeScaleItems(box);
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		title = "MMF Deletion ";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView viewMeScaleAdditionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleMasterId = Integer.parseInt(box.get("meScaleMasterId"));
		// map = nonExpendableStoresHandlerService.getItemDetails(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		map.put("contentJsp", jsp);
		map.put("meScaleMasterId", meScaleMasterId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addItemToMeScale(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);

		map = nonExpendableStoresHandlerService.addItemToMeScale(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchItemsForMEScale(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession(true);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		session = request.getSession(true);
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);

		map = nonExpendableStoresHandlerService.searchItemsForMEScale(box);
		jsp = VIEW_ME_SCALE_ADDITION_JSP;
		title = "MMF Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getMeScaleDescription(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession(true);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleNumber = 0;
		String meScaleDescription = "";
		meScaleNumber = Integer.parseInt(request.getParameter(ME_SCALE_NUMBER));
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getMeScaleDescription(
				meScaleNumber, box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		box.put("meScaleNumber", meScaleNumber);
		map.put("box", box);

		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("title", title);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getMeScaleData(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession(true);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int meScaleNumber = 0;
		String meScaleDescription = "";
		meScaleNumber = Integer.parseInt(request.getParameter(ME_SCALE_NUMBER));
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = nonExpendableStoresHandlerService.getMeScaleData(box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		box.put("meScaleNumber", meScaleNumber);
		map.put("box", box);

		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("title", title);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateGridItemsInViewMeScale(
			HttpServletRequest request, HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		session = request.getSession(true);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		boolean flag = false;
		String messageTOBeVisibleToTheUser = "";
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = nonExpendableStoresHandlerService
				.updateGridItemsInViewMeScale(box);
		String meScaleDesc = "";
		meScaleDesc = "" + map.get("meScaleDesc");
		box.put("meScaleDesc", meScaleDesc);
		map.put("box", box);
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewMeScaleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		Box box = HMSUtil.getBox(request);

		map = nonExpendableStoresHandlerService.viewMeScaleJsp();
		jsp = VIEW_ME_SCALE_JSP;
		jsp += ".jsp";
		title = "ViewMeScale";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// ============================End of ME Scale Equipment
	// Details==============================
	// *********************************************************************************************************************
	// ------------------------------------Start of Methods Written By Anand &
	// Vivek------------------------------------------
	// ****************************************************************************************************************

	// ******************************************************************************************
	// ========================== start of reports by abha
	// =========================
	// *****************************************************************************************

	public ModelAndView showWorkRegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = nonExpendableStoresHandlerService.showWorkRegisterReportJsp();
		String pvmsNo = "";
		if (request.getParameter(PVMS_NO) != null) {
			pvmsNo = request.getParameter(PVMS_NO);

		}
		title = "Work Order Register Report";
		jsp = WORK_ORDER_REGISTER_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("pvmsNo", pvmsNo);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String pvmsNo = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession(true);
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {

			// if(session.getAttribute("hospitalId") != null)
			// {
			// hospitalId = (Integer)session.getAttribute("hospitalId");
			// hospitalName = storesHandlerService.getHospitalName(hospitalId);
			// requestParameters.put("HOSP_NAME", hospitalName);
			// }

			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			if ((request.getParameter(PVMS_NO)) != null
					&& !(request.getParameter(PVMS_NO).equals(""))) {
				pvmsNo = (request.getParameter(PVMS_NO));
				requestParameters.put("PVMS_NO", pvmsNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(WORK_ORDER_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showReceiptRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Receipt Register Report";
		jsp = RECEIPT_REGISTER_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showInternalIssueReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Internal Issue Report";
		jsp = INTERNAL_ISSUE_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateInternalIssueReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession(true);
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(INTERNAL_ISSUE_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateActualStockReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession(true);
		try {

			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(ACTUAL_STOCK_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReceiptRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession(true);
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(RECEIPT_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSocReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "SOC Report";
		jsp = SOC_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSocReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession(true);
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				// hospitalName =
				// storesHandlerService.getHospitalName(hospitalId);
				requestParameters.put("HOSP_NAME", hospitalName);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("From_Date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("To_Date", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(SOC_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateNewWorkRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String workOrderNo = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession(true);
		requestParameters.put("DEPART", session.getAttribute("deptId"));
		try {

			if ((request.getParameter(WORK_ORDER_NO)) != null
					&& !(request.getParameter(WORK_ORDER_NO).equals(""))) {
				workOrderNo = (request.getParameter(WORK_ORDER_NO));
				requestParameters.put("WORK_ORDER_NO", workOrderNo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(WORK_ORDER_REGISTER_NEW_REPORT,
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ============================end of reports by abha
	// =====================================

	// ============================Start of reports by Mansi
	// =====================================

	public ModelAndView printAMCRepairJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String repairNo = null;
		session = request.getSession(true);
		requestParameters.put("Dept_Id", session.getAttribute("deptId"));
		try {
			if (request.getParameter("repairno") != null
					&& !(request.getParameter("repairno").equals(""))) {
				repairNo = request.getParameter("repairno");
				requestParameters.put("Repair_No", repairNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = storesHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(AMC_REPAIR_REPORT), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ AMC_REPAIR_REPORT + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	// ============================End of reports by Mansi
	// =====================================
	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(
			StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	public NonExpendableStoresHandlerService getNonExpendableStoresHandlerService() {
		return nonExpendableStoresHandlerService;
	}

	public void setNonExpendableStoresHandlerService(
			NonExpendableStoresHandlerService nonExpendableStoresHandlerService) {
		this.nonExpendableStoresHandlerService = nonExpendableStoresHandlerService;
	}
}
