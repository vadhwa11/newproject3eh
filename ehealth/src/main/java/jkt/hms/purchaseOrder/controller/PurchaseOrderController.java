/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class PurchaseOrderController.java
 * Tables Used: store_po_detail, store_po_header
 * Purpose of the class - For Local Purchase (LP) of PVMS and NIV Items
 * @author  Deepti Tevatia
 * Create Date: 4th Feb,2008
 * Revision Date:      		Revision By:
 * @version 1.0
 * @see PurchaseOrderHandlerService.java, PurchaseOrderHandlerServiceImpl.java, PurchaseOrderDataService.java, PurchaseOrderDataServiceImpl.java
 **/
package jkt.hms.purchaseOrder.controller;

import static jkt.hms.util.RequestConstants.ABC_ANALYSIS_FINAL_REPORT;
import static jkt.hms.util.RequestConstants.AMOUNT;
import static jkt.hms.util.RequestConstants.APPROVAL_AUTHORITY_JSP;
import static jkt.hms.util.RequestConstants.BRAND_ID;
import static jkt.hms.util.RequestConstants.BUDGET_STATUS_JSP;
import static jkt.hms.util.RequestConstants.DELIVERY_DATE;
import static jkt.hms.util.RequestConstants.DELIVERY_TERMS;
import static jkt.hms.util.RequestConstants.DETAIL_ID;
import static jkt.hms.util.RequestConstants.DISCOUNT_PERCENTAGE;
import static jkt.hms.util.RequestConstants.DRUG_EXPIRY_REPORT;
import static jkt.hms.util.RequestConstants.DRUG_EXPIRY_REPORT_JSP;
import static jkt.hms.util.RequestConstants.FREE_ITEM;
import static jkt.hms.util.RequestConstants.FREE_QTY;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.LOCAL_PO_FORMAT_JSP;
import static jkt.hms.util.RequestConstants.LOCAL_PO_FORMAT_REPORT;
import static jkt.hms.util.RequestConstants.LOCAL_PURCHASE_JSP;
import static jkt.hms.util.RequestConstants.LOCAL_SUPPLY_ORDER_PRINT_FOR_STORES;
import static jkt.hms.util.RequestConstants.LPO_REGISTER_REPORT;
import static jkt.hms.util.RequestConstants.LPO_SIGNING_AUTHORITY;
import static jkt.hms.util.RequestConstants.MANUFACTURER_ID;
import static jkt.hms.util.RequestConstants.MORE_INFO_PURCHASE_JSP;
import static jkt.hms.util.RequestConstants.NO_DETAIL_RECORDS;
import static jkt.hms.util.RequestConstants.NO_OF_ROWS;
import static jkt.hms.util.RequestConstants.PAY_TERMS;
import static jkt.hms.util.RequestConstants.PO_DATE;
import static jkt.hms.util.RequestConstants.PO_DELIVERY_TERMS_JSP;
import static jkt.hms.util.RequestConstants.PO_ID;
import static jkt.hms.util.RequestConstants.PO_NO;
import static jkt.hms.util.RequestConstants.PO_PAYMENT_TERMS_JSP;
import static jkt.hms.util.RequestConstants.PO_REGISTER_REPORT_JSP;
import static jkt.hms.util.RequestConstants.QUANTITY;
import static jkt.hms.util.RequestConstants.QUOTATION_DATE;
import static jkt.hms.util.RequestConstants.QUOTATION_NO;
import static jkt.hms.util.RequestConstants.REMARKS;
import static jkt.hms.util.RequestConstants.SR_NO;
import static jkt.hms.util.RequestConstants.STORES_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.SUPPLIER_ID;
import static jkt.hms.util.RequestConstants.TAX_PERCENT;
import static jkt.hms.util.RequestConstants.TOTAL_AMOUNT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.UNIT_RATE;
import static jkt.hms.util.RequestConstants.UPDATE_LOCAL_PURCHASE_JSP;
import static jkt.hms.util.RequestConstants.VENDOR_NAME;

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
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasSetupParameterMaintaince;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.StoreTenderM;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.HospitalDetailsMasterHandlerService;
import jkt.hms.purchaseOrder.handler.PurchaseOrderHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.JKTRequestUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.Session;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PurchaseOrderController extends MultiActionController {
	PurchaseOrderHandlerService purchaseOrderHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService = null;

	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";

	public ModelAndView showPurchaseOrderJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		map = purchaseOrderHandlerService.showPurchaseOrderJsp(deptId,hospitalId);
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);
		jsp = LOCAL_PURCHASE_JSP;
		jsp = jsp + ".jsp";
		title = "Supply Order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		String previousPage = "no";
		map.put("poNumberList", poNumberList);
		map.put("previousPage", previousPage);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingSupplyOrderPoWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);
		map.put("poNumberList", poNumberList);

		String jsp = "pendingSupplyOrderPoWise" + ".jsp";
		map.put("contentJsp", jsp);
		return (new ModelAndView("index", "map", map));

	}

	// ------ PO Generation For Item Below Reorder Level--------------

	public ModelAndView showPOGenerationBelowReorderJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		map = purchaseOrderHandlerService.showPOGenerationBelowReorderJsp(deptId,hospitalId);
		jsp = "poGenerationBelowReorder";
		jsp += ".jsp";
		title = "PO Generation For Item Below Reorder Level";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitPurchaseOrderBelowReorder(HttpServletRequest request,
			HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		String loginName = "";
		int userId = 0;
		int hospitalId = 0;
		List<String> poList = new ArrayList<String>();

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		box.put("userId", userId);
		if (session.getAttribute("loginName") != null) {
			loginName = (String) session.getAttribute("loginName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		boolean flag = false;
		Map<String, Object> poMap = purchaseOrderHandlerService.submitPurchaseOrderBelowReorder(box,departmentId,loginName,hospitalId);
		if (poMap.get("flag") != null)
		{
			flag = (Boolean) poMap.get("flag");
		}

		if (poMap.get("poList") != null)
		{
			poList = (List<String>) poMap.get("poList");
		}

		String messageTOBeVisibleToTheUser = "";
		if(flag)
		{
			messageTOBeVisibleToTheUser = "Purchase Order has been done Successfully";
		}
		else
		{
			messageTOBeVisibleToTheUser = "Purchase Order has not been done Successfully";
		}

		jsp = "poItemBelowReorderPrint";
		jsp += ".jsp";

		title = "PO Generation For Item Below Reorder Level";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		map.put("message", messageTOBeVisibleToTheUser);
		map.put("poList", poList);
		return new ModelAndView("index", "map", map);
	}

	// For Adding the New Local Purchase Order respective to a vendor
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ModelAndView submitPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();

		int supplierId = 0;
		String poNumber = "";
		String quotationNo = "";
		String remarks = "";
		String payTerms = "";
		Date poDate = new Date();
		Date quotationDate = new Date();
		Date deliveryDate = new Date();
		String signingAuthority = "";

		String deliveryTerms = "";
		int pageNo = 1;
		int noOfRecords = 0;
		int poId = 0;
		String date = "";
		String time = "";
		String buttonFlag = "";
		String loginName = "";
		

		int departmentId = 0;
		BigDecimal totalAmount = new BigDecimal(0);

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		//---------------code by anamika-------------
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}

		StorePoHeader storePoHeader = new StorePoHeader();
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}

		if (!request.getParameter(PO_ID).equals("0")) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if (request.getParameter(PO_NO) != null) {
			poNumber = request.getParameter(PO_NO);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (pageNo != 1) {
			poId = purchaseOrderHandlerService.getPurchaseOrderId(poNumber);
		}
		if (request.getParameter(PO_DATE) != null) {
			poDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PO_DATE));
		}
		if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
		}
		if (request.getParameter(QUOTATION_NO) != null) {
			quotationNo = request.getParameter(QUOTATION_NO);
		}
		if (request.getParameter(QUOTATION_DATE) != null) {
			quotationDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(QUOTATION_DATE));
		}
		if (request.getParameter(DELIVERY_DATE) != null) {
			deliveryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DELIVERY_DATE));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(PAY_TERMS) != null) {
			payTerms = request.getParameter(PAY_TERMS);
		}
		if (request.getParameter(DELIVERY_TERMS) != null) {
			deliveryTerms = request.getParameter(DELIVERY_TERMS);
		}

		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}

		signingAuthority = box.getString(LPO_SIGNING_AUTHORITY);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		String headerStored = "no";
		if (pageNo == 1) {
			storePoHeader.setPoNumber(poNumber);
			storePoHeader.setPoDate(poDate);

			MasStoreSupplier supplier = new MasStoreSupplier();
			supplier.setId(supplierId);
			storePoHeader.setSupplier(supplier);

			storePoHeader.setQuotationNumber(quotationNo);
			storePoHeader.setQuotationDate(quotationDate);
			storePoHeader.setDeliveryDate(deliveryDate);
			storePoHeader.setRemarks(remarks);
			storePoHeader.setPayTerms(payTerms);
			storePoHeader.setDeliveryTerms(deliveryTerms);
			storePoHeader.setNetAmount(totalAmount);
			storePoHeader.setSigningAuthority(signingAuthority);

			storePoHeader.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
			storePoHeader.setLastChgTime(time);
			//commented for maven
			/*storePoHeader.setStatus("o");*/

			/*if (session.getAttribute("loginName") != null) {
				loginName = (String) session.getAttribute("loginName");
			}*/
			Users users = new Users();
			users.setId(userId);
			storePoHeader.setLastChgBy(users);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			storePoHeader.setDepartment(masDepartment);
			//-------------code by anamika-----------------
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			storePoHeader.setHospital(masHospital);
			//-------------------------------------------
			
			//commented for maven
			/*storePoHeader.setPoTime(time);
			storePoHeader.setPOGeneratedThrough("MANUAL");*/
		} else {
			headerStored = "yes";
			infoMap.put("headerStored", headerStored);
			infoMap.put("totalAmount", totalAmount);
		}
		int length = 0;

		BigDecimal[] quantityArr = new BigDecimal[10];
		BigDecimal[] taxArr = new BigDecimal[10];
		BigDecimal[] unitRateArr = new BigDecimal[10];
		BigDecimal[] discountArr = new BigDecimal[10];

		// BigDecimal[] freeQtyArr = new BigDecimal[10];
		BigDecimal[] amountArr = new BigDecimal[10];

		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();

		try {
			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,
					ITEM_ID);
			// int manufacturerIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,MANUFACTURER_ID);
			Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
			// int brandIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,BRAND_ID);
			@SuppressWarnings("unused")
			Vector brandIdArr = box.getVector(BRAND_ID);
			// String freeItemArr[] =
			// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
			Vector freeItemArr = box.getVector(FREE_ITEM);

			String xx[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY);
			int xxLen = xx.length;
			for (int i = 0; i < xxLen; i++) {
				BigDecimal val = new BigDecimal(xx[i]);
				quantityArr[i] = val;
			}
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
			/*
			 * String pp[] =
			 * JKTRequestUtils.getRequiredStringParameters(request, FREE_QTY);
			 * int ppLen = pp.length; for( int i = 0 ;i < ppLen ; i++){
			 * BigDecimal val = new BigDecimal(pp[i]); freeQtyArr[i] = val; }
			 */
			Vector freeQtyArr = box.getVector(FREE_QTY);

			String qq[] = JKTRequestUtils.getRequiredStringParameters(request,
					AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}

			if (buttonFlag.equals("next")) {
				// if(buttonFlag != null){
				length = 10;
			} else {
				length = noOfRecords;
			}

			// get mdq, dispense type, rate per mdq

			Vector mdq = box.getVector("mdq");
			Vector dispenseType = box.getVector("dipenseType");
			Vector ratePerMdq = box.getVector("ratePerMdq");

			Vector mrp = box.getVector("mrp");
			Vector otherTaxes = box.getVector("otherTaxes");

			for (int i = 0; i < length; i++) {
				if (itemIdArr[i] != 0) {
					StorePoDetail storePoDetail = new StorePoDetail();
					
					//commented for maven
					/*storePoDetail.setSerialNo(srNo[i]);*/

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArr[i]);
					storePoDetail.setItem(masItem);

					storePoDetail.setQuantityOrdered(quantityArr[i]);
					try {
						storePoDetail.setFreeQuantity(new BigDecimal(freeQtyArr
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setFreeQuantity(new BigDecimal("0"));
					}
					storePoDetail.setTaxPercent(taxArr[i]);
					storePoDetail.setDiscountAmount(null);

					storePoDetail.setAmount(amountArr[i]);
					storePoDetail.setUnitRate(unitRateArr[i]);
					storePoDetail.setDiscountPercent(discountArr[i]);

					if (freeItemArr.get(i).toString() != null) {
						storePoDetail
								.setFreeItem(freeItemArr.get(i).toString());
					}

					if (manufacturerIdArr.get(i).toString() != "") {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(Integer
								.parseInt(manufacturerIdArr.get(i).toString()));
						storePoDetail.setManufacturer(masManufacturer);
					}

					storePoDetail.setNotes("");
					storePoDetail.setQuantityReceived(null);
					storePoDetail.setTaxAmount(null);

					// add mdq, dispense type, rate per mdq
					storePoDetail.setDispType(dispenseType.get(i).toString());
					storePoDetail
							.setMdqValue(new BigDecimal(mdq.get(i).toString()));
					try {
						storePoDetail.setRatePerMdq(new BigDecimal(ratePerMdq
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setRatePerMdq(new BigDecimal(0));
					}

					/*
					 * if(brandIdArr.get(i).toString() != ""){ MasStoreBrand
					 * masStoreBrand = new MasStoreBrand();
					 * masStoreBrand.setId(Integer
					 * .parseInt(brandIdArr.get(i).toString()));
					 * storePoDetail.setBrand(masStoreBrand); }
					 */
					//commented for maven
					/*storePoDetail.setBrand(null);*/
					try {
						storePoDetail.setMrp(new BigDecimal(mrp.get(i)
								.toString()));
					} catch (Exception e) {
						storePoDetail.setMrp(new BigDecimal(0));
					}

					try {
						storePoDetail.setOtherTaxes(new BigDecimal(otherTaxes
								.get(i).toString()));
					} catch (Exception e) {
						storePoDetail.setOtherTaxes(new BigDecimal(0));
					}

					poDetailList.add(storePoDetail);
				}
			}
		} catch (Exception e) {
		}
		infoMap.put("pageNo", pageNo);
		infoMap.put("poNumber", poNumber);
		infoMap.put("poId", poId);

		infoMap.put("storePoHeader", storePoHeader);
		infoMap.put("poDetailList", poDetailList);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);

		boolean flag = false;
		Map<String, Object> poMap = purchaseOrderHandlerService
				.submitPurchaseOrder(infoMap);
		if (poMap.get("flag") != null) {
			flag = (Boolean) poMap.get("flag");
		}

		String messageTOBeVisibleToTheUser = "";
		String url = "";
		if (flag) {
			if (buttonFlag.equals("next")) {
				jsp = LOCAL_PURCHASE_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Purchase Order has been done Successfully";
				map = purchaseOrderHandlerService
						.showPurchaseOrderJsp(departmentId,hospitalId);
				if (poMap.get("poId") != null) {
					poId = (Integer) poMap.get("poId");
				}
				List<StorePoHeader> poHeaderList = purchaseOrderHandlerService
						.getPoHeader(poId);
				map.put("poHeaderList", poHeaderList);

			} else {
				url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";
				jsp = STORES_MESSAGE_JSP;
				pageNo++;
				messageTOBeVisibleToTheUser = "Purchase Order  has been done Successfully";
			}
		} else {
			messageTOBeVisibleToTheUser = "Purchase Order has not been done Successfully";
			map.put("messageType", "failure");
		}

		url = "/hms/hms/purchaseOrder?method=showPurchaseOrderJsp";
		jsp += ".jsp";

		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("poNumber", poNumber);

		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	// More Parameters of a PVMS/NIV Item that are Non-Mandatory Fields.

	public ModelAndView showMoreInfoPurchaseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<StorePoDetail> poDetailMoreInfoList = new ArrayList<StorePoDetail>();
		map = purchaseOrderHandlerService.getDetailsForMoreInfoPurchase();
		int rowNo = 0;
		int poDetailId = 0;

		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		if (request.getParameter("detailId") != null) {
			poDetailId = Integer.parseInt(request.getParameter("detailId"));
			poDetailMoreInfoList = purchaseOrderHandlerService
			.getPoDetailListForMoreInfoPurchase(poDetailId);
			map.put("poDetailMoreInfoList", poDetailMoreInfoList);
		}
		jsp = MORE_INFO_PURCHASE_JSP;
		title = "Supply Order";
		map.put("title", title);
		map.put("rowNo", rowNo);
		return new ModelAndView(jsp, "map", map);
	}

	// For Budget Status of a Local Purchase Order for a Particular Financial
	// Year
	public ModelAndView showBudgetStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> budgetStatusList = purchaseOrderHandlerService
				.getBudgetStatusList();
		jsp = BUDGET_STATUS_JSP;
		title = "Budget Status";
		map.put("budgetStatusList", budgetStatusList);
		return new ModelAndView(jsp, "map", map);
	}

	// Search For Local Purchase Order By PO No., Vendor Name, Between From Date
	// & To Date
	@SuppressWarnings("unchecked")
	public ModelAndView searchPO(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String fromDate = "";
		String toDate = "";
		int supplierId = 0;
		int departmentId = 0;
		String includedJsp = "";
		int poId = 0;
		String jsp = "poMain";
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		title = "View All P.O.";
		jsp += ".jsp";
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		try {
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter(TO_DATE) != null) {
				toDate = request.getParameter(TO_DATE);
			}
			if (request.getParameter(PO_ID) != null) {
				poId = Integer.parseInt(request.getParameter(PO_ID));
			}
			if (request.getParameter(SUPPLIER_ID) != null) {
				supplierId = Integer
						.parseInt(request.getParameter(SUPPLIER_ID));
			}
		} catch (Exception e) {
		}
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();

		searchFieldMap.put("fromDate", fromDate);
		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("poId", poId);
		searchFieldMap.put("supplierId", supplierId);
		searchFieldMap.put("departmentId", departmentId);

		poMap = (Map) purchaseOrderHandlerService.getViewAllMap();

		supplierList = (List) poMap.get("supplierList");
		poDetailList = (List) poMap.get("poDetailList");
		poHeaderList = (List) poMap.get("poHeaderList");

		if (searchFieldMap.size() != 0) {
			map = purchaseOrderHandlerService.searchPO(searchFieldMap);
			includedJsp = "done";
		} else {
		}
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService.getPoNumberList(departmentId,hospitalId);
		map.put("poDetailList", poDetailList);
		map.put("supplierList", supplierList);
		map.put("poHeaderList", poHeaderList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);

		map.put("poNumberList", poNumberList);
		return new ModelAndView("index", "map", map);
	}

	// Modification of a Purchase Order on the basis of a particular search
	public ModelAndView poModifyJsp(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		jsp = UPDATE_LOCAL_PURCHASE_JSP;
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (request.getParameter("parent") != null) {
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) purchaseOrderHandlerService
					.poModifyMap(radio_str, 0);
		}

		purchaseMap = purchaseOrderHandlerService.showPurchaseOrderJsp(deptId,hospitalId);
		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);

		map.put("purchaseMap", purchaseMap);
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView poPrintJsp(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		jsp = "poPrint";
		jsp += ".jsp";
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);

		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// Updating the Purchase Order which already exists.
	@SuppressWarnings({ "deprecation", "unused", "unchecked" })
	public ModelAndView updatePurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		session = request.getSession();

		int supplierId = 0;
		String poNumber = "";
		String quotationNo = "";
		String remarks = "";
		String payTerms = "";
		Date poDate = new Date();
		Date quotationDate = new Date();
		Date deliveryDate = new Date();
		String signingAuthority = "";

		String deliveryTerms = "";
		int pageNo = 1;
		int noOfRecords = 0;
		int poId = 0;
		String date = "";
		String time = "";
		String buttonFlag = "";
		int totalRecords = 0;
		int departmentId = 0;
		int hospitalId = 0;
		BigDecimal totalAmount = new BigDecimal(0);

		String url = "";
		int userId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		

		String noDetailRecords = "";
		/** Represents */
		StorePoHeader storePoHeader = new StorePoHeader();
		if (request.getParameter(NO_DETAIL_RECORDS) != null) {
			noDetailRecords = (request.getParameter(NO_DETAIL_RECORDS));

		}
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
		}
		if (request.getParameter("totalRecords") != null) {
			totalRecords = Integer.parseInt(request
					.getParameter("totalRecords"));
		}
		if (request.getParameter(PO_ID) != null) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter(NO_OF_ROWS) != null) {
			noOfRecords = Integer.parseInt(request.getParameter(NO_OF_ROWS));
		}
		if (request.getParameter(PO_NO) != null) {
			poNumber = request.getParameter(PO_NO);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		if (request.getParameter(PO_DATE) != null) {
			poDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PO_DATE));
		}
		if (!request.getParameter(SUPPLIER_ID).equals("0")) {
			supplierId = Integer.parseInt(request.getParameter(SUPPLIER_ID));
		}
		if (request.getParameter(QUOTATION_NO) != null) {
			quotationNo = request.getParameter(QUOTATION_NO);
		}
		if (request.getParameter(QUOTATION_DATE) != null) {
			quotationDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(QUOTATION_DATE));
		}
		if (request.getParameter(DELIVERY_DATE) != null) {
			deliveryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DELIVERY_DATE));
		}
		if (request.getParameter(REMARKS) != null) {
			remarks = request.getParameter(REMARKS);
		}
		if (request.getParameter(PAY_TERMS) != null) {
			payTerms = request.getParameter(PAY_TERMS);
		}
		if (request.getParameter(DELIVERY_TERMS) != null) {
			deliveryTerms = request.getParameter(DELIVERY_TERMS);
		}
		if (request.getParameter(TOTAL_AMOUNT) != null) {
			totalAmount = new BigDecimal(request.getParameter(TOTAL_AMOUNT));
		}
		signingAuthority = box.getString(LPO_SIGNING_AUTHORITY);

		/*
		 * Users user = (Users)session.getAttribute("users"); int userId =
		 * user.getId(); Users userObj = new Users(); userObj.setId(userId);
		 * storePoHeader.setLastChgBy(userObj);
		 */
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		String jsp1 = "";
		int goPage = 0;
		if (request.getParameter("goPage") != null
				&& !request.getParameter("goPage").equals("")) {
			String messageTOBeVisibleToTheUser = "";
			List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
			if (request.getParameter("goPage") != null) {
				pageNo = Integer.parseInt(request.getParameter("goPage"));
			}

			map = (Map<String, Object>) purchaseOrderHandlerService
					.poModifyMap(poId, pageNo);
			map.put("poId", poId);

			poDetailList = (List<StorePoDetail>) map.get("poDetailList");
			if (poDetailList.size() == 0) {
				noDetailRecords = "yes";
			}
			List<StorePoHeader> poNumberList = purchaseOrderHandlerService
					.getPoNumberList(departmentId,hospitalId);

			map.put("poNumberList", poNumberList);
			jsp1 = UPDATE_LOCAL_PURCHASE_JSP;

			jsp1 = jsp1 + ".jsp";

			Map<String, Object> purchaseMap = purchaseOrderHandlerService
					.showPurchaseOrderJsp(departmentId,hospitalId);

			url = "/hms/hms/purchaseOrder?method=poModifyJsp&parent=" + poId
					+ "";

			map.put("url", url);
			map.put("poId", poId);
			map.put("purchaseMap", purchaseMap);
			map.put("pageNo", pageNo);
			map.put("poNumber", poNumber);
			map.put("noDetailRecords", noDetailRecords);

			map.put("contentJsp", jsp1);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			return new ModelAndView("index", "map", map);
		} else {

			String headerStored = "no";
			if (pageNo == 1) {
				storePoHeader.setId(poId);
				storePoHeader.setPoNumber(poNumber);
				storePoHeader.setPoDate(poDate);

				MasStoreSupplier supplier = new MasStoreSupplier();
				supplier.setId(supplierId);
				storePoHeader.setSupplier(supplier);

				storePoHeader.setQuotationNumber(quotationNo);
				storePoHeader.setQuotationDate(quotationDate);
				storePoHeader.setRemarks(remarks);
				storePoHeader.setPayTerms(payTerms);
				storePoHeader.setDeliveryTerms(deliveryTerms);
				storePoHeader.setSigningAuthority(signingAuthority);
				Users users = new Users();
				users.setId(userId);
				storePoHeader.setLastChgBy(users);
				storePoHeader.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(date));
				storePoHeader.setLastChgTime(time);
				//commented for maven
				/*storePoHeader.setStatus("o");*/
				storePoHeader.setDeliveryDate(deliveryDate);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				storePoHeader.setDepartment(masDepartment);
				
				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				storePoHeader.setHospital(masHospital);

				storePoHeader.setNetAmount(totalAmount);
				storePoHeader.setPoTime(time);
				if (box.getInt("tender_id") != 0) {
					//commented for maven
					/*storePoHeader.setTenderM(new StoreTenderM(box
							.getInt("tender_id")));*/
				}
				if (box.getInt("group_id") != 0) {
					storePoHeader.setGroup(new MasStoreGroup(box
							.getInt("group_id")));
				}
			} else {
				headerStored = "yes";
				infoMap.put("headerStored", headerStored);
				infoMap.put("totalAmount", totalAmount);
			}
			int length = 0;

			BigDecimal[] quantityArr = new BigDecimal[10];
			BigDecimal[] taxArr = new BigDecimal[10];
			BigDecimal[] unitRateArr = new BigDecimal[10];
			BigDecimal[] discountArr = new BigDecimal[10];
			BigDecimal[] amountArr = new BigDecimal[10];

			List<StorePoDetail> poDetailList = new ArrayList<StorePoDetail>();
			List<StorePoDetail> poDetailListAdd = new ArrayList<StorePoDetail>();

			int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,
					SR_NO);
			int itemIdArr[] = JKTRequestUtils.getRequiredIntParameters(request,
					ITEM_ID);
			// int manufacturerIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,MANUFACTURER_ID);
			Vector manufacturerIdArr = box.getVector(MANUFACTURER_ID);
			// int brandIdArr[] =
			// JKTRequestUtils.getRequiredIntParameters(request,BRAND_ID);
			// Vector brandIdArr = box.getVector(BRAND_ID);
			// String freeItemArr[] =
			// JKTRequestUtils.getRequiredStringParameters(request,FREE_ITEM);
			Vector freeItemArr = box.getVector(FREE_ITEM);
			Vector freeQtyArr = box.getVector(FREE_QTY);

			length = srNo.length;

			String xx[] = JKTRequestUtils.getRequiredStringParameters(request,
					QUANTITY);
			int xxLen = xx.length;
			for (int i = 0; i < xxLen; i++) {
				BigDecimal val = new BigDecimal(xx[i]);
				quantityArr[i] = val;
			}

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
			/*
			 * String pp[] =
			 * JKTRequestUtils.getRequiredStringParameters(request, FREE_QTY);
			 * int ppLen = pp.length; for( int i = 0 ;i < ppLen ; i++){
			 * BigDecimal val = new BigDecimal(pp[i]); freeQtyArr[i] = val; }
			 */String qq[] = JKTRequestUtils.getRequiredStringParameters(
					request, AMOUNT);
			int qqLen = qq.length;
			for (int i = 0; i < qqLen; i++) {
				BigDecimal val = new BigDecimal(qq[i]);
				amountArr[i] = val;
			}

			// get mdq, dispense type, rate per mdq

			Vector mdq = box.getVector("mdq");
			Vector dispenseType = box.getVector("dipenseType");
			Vector ratePerMdq = box.getVector("ratePerMdq");
			Vector mrp = box.getVector("mrp");
			Vector otherTaxes = box.getVector("otherTaxes");

			if (noDetailRecords.equals("no")) {
				int idArray[] = JKTRequestUtils.getRequiredIntParameters(
						request, DETAIL_ID);
				int idArrayLength = idArray.length;
				for (int i = 0; i < length; i++) {

					if (idArrayLength > 0) { // if any records in
						// storePoDetails
						StorePoDetail storePoDetail = new StorePoDetail();
						storePoDetail.setId(idArray[i]);
						//commented for maven
						/*storePoDetail.setSerialNo(srNo[i]);*/

						MasStoreItem masItem = new MasStoreItem();
						masItem.setId(itemIdArr[i]);
						storePoDetail.setItem(masItem);

						storePoDetail.setQuantityOrdered(quantityArr[i]);

						try {
							storePoDetail.setFreeQuantity(new BigDecimal(
									freeQtyArr.get(i).toString()));
						} catch (Exception e) {
							storePoDetail.setFreeQuantity(new BigDecimal("0"));
						}

						if (freeItemArr.get(i).toString() != null) {
							storePoDetail.setFreeItem(freeItemArr.get(i)
									.toString());
						}

						if (manufacturerIdArr.get(i).toString() != "") {
							MasManufacturer masManufacturer = new MasManufacturer();
							masManufacturer.setId(Integer
									.parseInt(manufacturerIdArr.get(i)
											.toString()));
							storePoDetail.setManufacturer(masManufacturer);
						}

						/*
						 * if(brandIdArr.get(i).toString() != "") {
						 * MasStoreBrand masStoreBrand = new MasStoreBrand();
						 * masStoreBrand
						 * .setId(Integer.parseInt(brandIdArr.get(i)
						 * .toString())); storePoDetail.setBrand(masStoreBrand);
						 * }
						 */

						storePoDetail.setTaxPercent(taxArr[i]);
						storePoDetail.setDiscountAmount(null);

						storePoDetail.setAmount(amountArr[i]);
						storePoDetail.setUnitRate(unitRateArr[i]);
						storePoDetail.setDiscountPercent(discountArr[i]);

						StorePoHeader po = new StorePoHeader();
						po.setId(poId);
						storePoDetail.setPo(po);

						storePoDetail.setNotes("");
						storePoDetail.setQuantityReceived(null);
						storePoDetail.setTaxAmount(null);

						// mdq, dispense type, rate per mdq
						storePoDetail.setDispType(dispenseType.get(i)
								.toString());
						storePoDetail.setMdqValue(new BigDecimal(mdq.get(i)
								.toString()));
						try {
							storePoDetail.setRatePerMdq(new BigDecimal(
									ratePerMdq.get(i).toString()));
						} catch (Exception e) {
							storePoDetail.setRatePerMdq(new BigDecimal(0));
						}

						try {
							storePoDetail.setMrp(new BigDecimal(mrp.get(i)
									.toString()));
						} catch (Exception e) {
							storePoDetail.setMrp(new BigDecimal(0));
						}

						try {
							storePoDetail.setOtherTaxes(new BigDecimal(
									otherTaxes.get(i).toString()));
						} catch (Exception e) {
							storePoDetail.setOtherTaxes(new BigDecimal(0));
						}

						poDetailList.add(storePoDetail);

					} else {
						if (itemIdArr[i] != 0) { // grid records
							StorePoDetail storePoDetailAdd = new StorePoDetail();
							// storePoDetailAdd.setId(idArray[i]);
							//commented for maven
							/*storePoDetailAdd.setSerialNo(srNo[i]);*/

							MasStoreItem masItem = new MasStoreItem();
							masItem.setId(itemIdArr[i]);
							storePoDetailAdd.setItem(masItem);

							storePoDetailAdd.setQuantityOrdered(quantityArr[i]);

							try {
								storePoDetailAdd
										.setFreeQuantity(new BigDecimal(
												freeQtyArr.get(i).toString()));
							} catch (Exception e) {
								storePoDetailAdd
										.setFreeQuantity(new BigDecimal("0"));
							}

							if (freeItemArr.get(i).toString() != null) {
								storePoDetailAdd.setFreeItem(freeItemArr.get(i)
										.toString());
							}

							if (manufacturerIdArr.get(i).toString() != "") {
								MasManufacturer masManufacturer = new MasManufacturer();
								masManufacturer.setId(Integer
										.parseInt(manufacturerIdArr.get(i)
												.toString()));
								storePoDetailAdd
										.setManufacturer(masManufacturer);
							}
							/*
							 * if(brandIdArr.get(i).toString() != "") {
							 * MasStoreBrand masStoreBrand = new
							 * MasStoreBrand();
							 * masStoreBrand.setId(Integer.parseInt
							 * (brandIdArr.get(i).toString()));
							 * storePoDetailAdd.setBrand(masStoreBrand); }
							 */
							storePoDetailAdd.setTaxPercent(taxArr[i]);
							storePoDetailAdd.setDiscountAmount(null);

							storePoDetailAdd.setAmount(amountArr[i]);
							storePoDetailAdd.setUnitRate(unitRateArr[i]);
							storePoDetailAdd.setDiscountPercent(discountArr[i]);

							// mdq, dispense type, rate per mdq
							storePoDetailAdd.setDispType(dispenseType.get(i)
									.toString());
							storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i)
									.toString()));
							try {
								storePoDetailAdd.setRatePerMdq(new BigDecimal(
										ratePerMdq.get(i).toString()));
							} catch (Exception e) {
								storePoDetailAdd
										.setRatePerMdq(new BigDecimal(0));
							}

							StorePoHeader po = new StorePoHeader();
							po.setId(poId);
							storePoDetailAdd.setPo(po);

							storePoDetailAdd.setNotes("");
							storePoDetailAdd.setQuantityReceived(null);
							storePoDetailAdd.setTaxAmount(null);

							try {
								storePoDetailAdd.setMrp(new BigDecimal(mrp.get(
										i).toString()));
							} catch (Exception e) {
								storePoDetailAdd.setMrp(new BigDecimal(0));
							}

							try {
								storePoDetailAdd.setOtherTaxes(new BigDecimal(
										otherTaxes.get(i).toString()));
							} catch (Exception e) {
								storePoDetailAdd
										.setOtherTaxes(new BigDecimal(0));
							}

							poDetailListAdd.add(storePoDetailAdd);
						}
					}
					idArrayLength--;

				}

			} else { // next page grid records
				length = srNo.length;
				for (int i = 0; i < length; i++) {
					StorePoDetail storePoDetailAdd = new StorePoDetail();
					// storePoDetailAdd.setId(idArray[i]);
					//commented for maven
					/*storePoDetailAdd.setSerialNo(srNo[i]);*/

					MasStoreItem masItem = new MasStoreItem();
					masItem.setId(itemIdArr[i]);
					storePoDetailAdd.setItem(masItem);

					storePoDetailAdd.setQuantityOrdered(quantityArr[i]);

					try {
						storePoDetailAdd.setFreeQuantity(new BigDecimal(
								freeQtyArr.get(i).toString()));
					} catch (Exception e) {
						storePoDetailAdd.setFreeQuantity(new BigDecimal("0"));
					}

					if (freeItemArr.get(i).toString() != null) {
						storePoDetailAdd.setFreeItem(freeItemArr.get(i)
								.toString());
					}

					if (manufacturerIdArr.get(i).toString() != "") {
						MasManufacturer masManufacturer = new MasManufacturer();
						masManufacturer.setId(Integer
								.parseInt(manufacturerIdArr.get(i).toString()));
						storePoDetailAdd.setManufacturer(masManufacturer);
					}

					/*
					 * if(brandIdArr.get(i).toString() != "") { MasStoreBrand
					 * masStoreBrand = new MasStoreBrand();
					 * masStoreBrand.setId(Integer
					 * .parseInt(brandIdArr.get(i).toString()));
					 * storePoDetailAdd.setBrand(masStoreBrand); }
					 */

					storePoDetailAdd.setTaxPercent(taxArr[i]);
					storePoDetailAdd.setDiscountAmount(null);

					storePoDetailAdd.setAmount(amountArr[i]);
					storePoDetailAdd.setUnitRate(unitRateArr[i]);
					storePoDetailAdd.setDiscountPercent(discountArr[i]);

					StorePoHeader po = new StorePoHeader();
					po.setId(poId);
					storePoDetailAdd.setPo(po);

					storePoDetailAdd.setNotes("");
					storePoDetailAdd.setQuantityReceived(null);
					storePoDetailAdd.setTaxAmount(null);

					try {
						storePoDetailAdd.setRatePerMdq(new BigDecimal(
								ratePerMdq.get(i).toString()));
					} catch (Exception e) {
						storePoDetailAdd.setRatePerMdq(new BigDecimal(0));
					}

					// mdq, dispense type, rate per mdq
					storePoDetailAdd
							.setDispType(dispenseType.get(i).toString());
					storePoDetailAdd.setMdqValue(new BigDecimal(mdq.get(i)
							.toString()));

					try {
						storePoDetailAdd.setMrp(new BigDecimal(mrp.get(i)
								.toString()));
					} catch (Exception e) {
						storePoDetailAdd.setMrp(new BigDecimal(0));
					}

					try {
						storePoDetailAdd.setOtherTaxes(new BigDecimal(
								otherTaxes.get(i).toString()));
					} catch (Exception e) {
						storePoDetailAdd.setOtherTaxes(new BigDecimal(0));
					}

					poDetailListAdd.add(storePoDetailAdd);

				}
			}
			infoMap.put("pageNo", pageNo);
			infoMap.put("poNumber", poNumber);
			infoMap.put("poId", poId);

			infoMap.put("storePoHeader", storePoHeader);
			infoMap.put("poDetailList", poDetailList);
			infoMap.put("poDetailListAdd", poDetailListAdd);

			boolean flag = purchaseOrderHandlerService
					.updatePurchaseOrder(infoMap);

			String messageTOBeVisibleToTheUser = "";

			if (flag) {
				if (infoMap.get("poId") != null) {
					poId = (Integer) infoMap.get("poId");
					map = (Map<String, Object>) purchaseOrderHandlerService
							.poModifyMap(poId, pageNo);
					map.put("poId", poId);
				}
				poDetailList = (List<StorePoDetail>) map.get("poDetailList");
				if (poDetailList.size() == 0) {
					noDetailRecords = "yes";
				}
				if ((poDetailList.size() != 0) || (buttonFlag.equals("next"))) {
					jsp = UPDATE_LOCAL_PURCHASE_JSP;
				}
				if (!(buttonFlag.equals("next"))) {
					jsp = STORES_MESSAGE_JSP;
					messageTOBeVisibleToTheUser = "Purchase Order has been updated Successfully";
				}

			} else {
				jsp = STORES_MESSAGE_JSP;
				messageTOBeVisibleToTheUser = "Purchase Order has not been updated Successfully";
				map.put("messageType", "failure");
				url = "/hms/hms/purchase?method=poModifyJsp&parent=" + poId
						+ "";
			}
			jsp += ".jsp";
			Map<String, Object> purchaseMap = purchaseOrderHandlerService
					.showPurchaseOrderJsp(departmentId,hospitalId);

			url = "/hms/hms/purchaseOrder?method=poModifyJsp&parent=" + poId
					+ "";

			map.put("url", url);
			map.put("poId", poId);
			map.put("purchaseMap", purchaseMap);
			map.put("pageNo", pageNo);
			map.put("poNumber", poNumber);
			map.put("noDetailRecords", noDetailRecords);

			map.put("contentJsp", jsp);
			map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
			List<StorePoHeader> poNumberList = purchaseOrderHandlerService
					.getPoNumberList(departmentId,hospitalId);

			map.put("poNumberList", poNumberList);
			return new ModelAndView("index", "map", map);
		}
	}

	// Checking & Updating the Approval Authorities for Local Purchase Order.
	@SuppressWarnings("unused")
	public ModelAndView showApprovalAuthority(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		List<MasAuthorizer> authorityList = purchaseOrderHandlerService
				.getApprovalAuthoritiesList();

		title = "Approval Authority";
		jsp = APPROVAL_AUTHORITY_JSP;
		String[] checkId = null;
		int poId = 0;

		if (request.getParameter("poId") != null) {
			poId = Integer.parseInt(request.getParameter("poId"));
		}
		if (request.getParameterValues("checkId") != null) {
			checkId = request.getParameterValues("checkId");
		}

		map.put("poId", poId);
		map.put("authorityList", authorityList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// Updating the Approval Authorities for Local Purchase Order.
	public ModelAndView submitApprovalAuthority(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		title = "Approval Authority";
		int counter = 0;
		int poId = 0;
		String approvalId = "";

		if (request.getParameter(PO_ID) != null) {
			poId = Integer.parseInt(request.getParameter(PO_ID));
		}
		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}

		StringBuffer approvalIds = new StringBuffer();
		for (int i = 0; i < counter; i++) {
			if (request.getParameter("id" + i) != null) {
				approvalId = request.getParameter("id" + i);
				approvalIds.append(approvalId + ",");
			}
		}

		boolean flag = false;
		if (approvalIds.length() != 0) {
			approvalIds.deleteCharAt(approvalIds.length() - 1);
			flag = purchaseOrderHandlerService.submitApprovalAuthority(
					approvalIds.toString(), poId);
		} else {
			flag = purchaseOrderHandlerService
					.submitApprovalAuthority("", poId);
		}

		String messageTOBeVisibleToTheUser = "";
		@SuppressWarnings("unused")
		String url = "";
		if (flag == true) {
			messageTOBeVisibleToTheUser = "Approval Authorities has been submitted successfully.";
		} else {
			messageTOBeVisibleToTheUser = "Please First Select Any SO No.";
		}

		jsp = "messageForPurchase";
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// For selecting a PO Number For the Local Po Format Report.
	public ModelAndView showLocalPoFormatJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Local PO Format";
		session = request.getSession();

		int deptId = 0;
		int hospitalId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		List<StorePoHeader> poNumberList = purchaseOrderHandlerService
				.getPoNumberList(deptId,hospitalId);
		jsp = LOCAL_PO_FORMAT_JSP;
		jsp = jsp + ".jsp";
		map.put("poNumberList", poNumberList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	// Generate a Local PO Format report on the basis PO Number.
	public ModelAndView generateLocalPoFormatReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String poNo = null;
		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter(PO_NO) != null
					&& !(request.getParameter(PO_NO).equals(""))) {
				poNo = request.getParameter(PO_NO);
				requestParameters.put("poNo", poNo);
			}
			// requestParameters.put(", 123);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(LOCAL_PO_FORMAT_REPORT),
					requestParameters, (Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ LOCAL_PO_FORMAT_REPORT + ".pdf");
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

	// Method used for Jasper Report of Local Po Format.
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	

	public ModelAndView showPORegisterReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId= 0;

	  session = request.getSession();

	  deptId = (Integer)session.getAttribute("deptId");

		title = "PO Register Report";

		List<MasStoreSupplier> supplierList = purchaseOrderHandlerService
				.getSupplierList();

	/*	List<StorePoHeader> ponumberList = purchaseOrderHandlerService.
		   getPoNumberList(deptId);*/

		jsp = PO_REGISTER_REPORT_JSP;

		map.put("supplierList", supplierList);

/*		map.put("ponumberList", ponumberList);*/

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView getPONumberAgainstVendor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Integer hospitalId= 0;
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

	  if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(VENDOR_NAME) != null
				&& !(request.getParameter(VENDOR_NAME).equals("") && !(request
						.getParameter(VENDOR_NAME).equals("0")))) {
			vendorName = request.getParameter(VENDOR_NAME);
		}



		dataMap.put("fromDate", fromDate);
		dataMap.put("toDate", toDate);
		dataMap.put("vendorName", vendorName);
		dataMap.put("hospitalId", hospitalId);
		map = purchaseOrderHandlerService.getPoNumberAgainstVendorList(dataMap);

		String message = "";
		String jsp = "";
		jsp = "responceForPOList";

		return new ModelAndView(jsp, "map", map);
	}


	@SuppressWarnings("unused")
	public ModelAndView generatePORegisterReport(HttpServletRequest request,
			HttpServletResponse response) {


		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;

		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		String query = "";
		requestParameters.put("hospitalId", session.getAttribute("hospitalId"));
		requestParameters.put("deptId", session.getAttribute("deptId"));

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			if (request.getParameter(VENDOR_NAME) != null
					&& !(request.getParameter(VENDOR_NAME).equals("") && !(request
							.getParameter(VENDOR_NAME).equals("0")))) {
				vendorName = request.getParameter(VENDOR_NAME);
				requestParameters.put("supplierId",
						Integer.parseInt(vendorName));
			}
			if (!vendorName.equals("") && !vendorName.equals("0")) {
				query = query + "and a.supplier_id = '" + vendorName + "'";
			}
			if (query.length() > 0) {
				requestParameters.put("query", query);
			}
			map = getHospitalParameterDetails(request);
			if (map.get("hospitalName") != null) {
				requestParameters.put("hospitalName",
						(String) map.get("hospitalName"));
			}
			if (map.get("hospitalAddress") != null) {
				requestParameters.put("hospitalAddress",
						(String) map.get("hospitalAddress"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(LPO_REGISTER_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public ModelAndView generateABCAnalysisReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		String fileName = null;
		String vendorName = "";
		int hospitalId = 0;
		int deptId=0;
		int itemCatId=0;
		String hospitalName = "";
		String fromDate="";
		String newFromDate="";
		String toDate="";
		String newToDate="";

		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

		/*Map<String, Object> classMap = purchaseOrderHandlerService
				.getStoreSetUpDetails();
		if (classMap.get("classList") != null) {
			classList = (List<StoreSetup>) classMap.get("classList");
		}*/
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = purchaseOrderHandlerService
					.getHospitalName(hospitalId);
		//	hospitalName = "'"+hospitalName+"'";
			requestParameters.put("hospitalName", hospitalName);
		}
		if(session.getAttribute("deptId")!=null)
		{
			deptId=Integer.parseInt(""+session.getAttribute("deptId"));
			requestParameters.put("deptId", session.getAttribute("deptId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!="")
		{
			int newToYear=0;
			int newToMonth=0;
			fromDate=request.getParameter("fromDate");
			String[] date = fromDate.split("/");
			/*if(date[1].equalsIgnoreCase("12")){
				newToYear= Integer.parseInt(date[2])+1;
			}else{
				newToYear= Integer.parseInt(date[2]);
			}
			if(!(date[1].equalsIgnoreCase("12"))){
				newToMonth= (Integer.parseInt(date[1])+1);
			}else{
				newToMonth=1;
			}
			toDate=newToYear+"/"+newToMonth+"/"+date[0];*/
			newFromDate = date[2]+"/"+date[1]+"/"+date[0];
		}
		if(request.getParameter(TO_DATE)!=null && request.getParameter(TO_DATE)!="")
		{
			int newToYear=0;
			int newToMonth=0;
			toDate=request.getParameter(TO_DATE);
			String[] date = toDate.split("/");
			newToDate = date[2]+"/"+date[1]+"/"+date[0];
		}
		if(request.getParameter("itemCat")!=null && request.getParameter("itemCat")!=""){
			itemCatId=Integer.parseInt(request.getParameter("itemCat"));
		}
		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		//Added By Manjul for new ABC analysis report using procedure
		Map<String, Object> classMap = purchaseOrderHandlerService
		.runAbcProcedure(deptId,newFromDate,newToDate,itemCatId);
		HMSUtil.generateReport("ABC_Analysis_Final_Report_new1", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;

	}
	//Added by manjul to show abc analysis report jsp
	public ModelAndView showABCJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = purchaseOrderHandlerService.showABCJsp();
		List<MasStoreGroup> categoryList = new ArrayList<MasStoreGroup>();
		if(map.get("categoryList")!=null){
			categoryList=(List)map.get("categoryList");
		}
		title = "ABC Analysis Report";

		jsp = "abcAnalysisJsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("categoryList", categoryList);

		return new ModelAndView("index", "map", map);
	}

	
	//Added by manjul to show fsn analysis report jsp
	public ModelAndView showFSNJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = purchaseOrderHandlerService.showABCJsp();
		List<MasStoreGroup> categoryList = new ArrayList<MasStoreGroup>();
		if(map.get("categoryList")!=null){
			categoryList=(List)map.get("categoryList");
		}
		title = "ABC Analysis Report";

		jsp = "fsnAnalysisReportJsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("categoryList", categoryList);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateFSNAnalysisReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		String fileName = null;
		String vendorName = "";
		int hospitalId = 0;
		int deptId=0;
		int itemCatId=0;
		String hospitalName = "";
		String fromDate="";
		String newFromDate="";
		String toDate="";

		session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

		/*Map<String, Object> classMap = purchaseOrderHandlerService
				.getStoreSetUpDetails();
		if (classMap.get("classList") != null) {
			classList = (List<StoreSetup>) classMap.get("classList");
		}*/
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			hospitalName = purchaseOrderHandlerService
					.getHospitalName(hospitalId);
		//	hospitalName = "'"+hospitalName+"'";
			requestParameters.put("hospitalName", hospitalName);
		}
		if(session.getAttribute("deptId")!=null)
		{
			deptId=Integer.parseInt(""+session.getAttribute("deptId"));
			requestParameters.put("deptId", session.getAttribute("deptId"));
		}
		if(request.getParameter(FROM_DATE)!=null && request.getParameter(FROM_DATE)!="")
		{
			
			fromDate = (String) request.getParameter(FROM_DATE);
			requestParameters.put("fromDate", fromDate);
				
			/*int newToYear=0;
			int newToMonth=0;
			fromDate=request.getParameter("fromDate");
			String[] date = fromDate.split("/");
			if(date[1].equalsIgnoreCase("12")){
				newToYear= Integer.parseInt(date[2])+1;
			}else{
				newToYear= Integer.parseInt(date[2]);
			}
			if(!(date[1].equalsIgnoreCase("12"))){
				newToMonth= (Integer.parseInt(date[1])+1);
			}else{
				newToMonth=1;
			}
			toDate=newToYear+"/"+newToMonth+"/"+date[0];
			newFromDate = date[2]+"/"+date[1]+"/"+date[0];*/
		}
		if(request.getParameter(TO_DATE)!=null && request.getParameter(TO_DATE)!=""){
			toDate = (String) request.getParameter(TO_DATE);
			requestParameters.put("toDate", toDate);
		}
		if(request.getParameter("itemCat")!=null && request.getParameter("itemCat")!=""){
			itemCatId=Integer.parseInt(request.getParameter("itemCat"));
			requestParameters.put("itemCatId", itemCatId);
		}
		try{
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL1 = formatterOut.format(formatterIn
				.parse(fromDate));
		String date4MySQL2 = formatterOut.format(formatterIn.parse(toDate));
		java.sql.Date startDate = java.sql.Date.valueOf(date4MySQL1);
		java.sql.Date endDate = java.sql.Date.valueOf(date4MySQL2);
		Map<String, Object> classMap = purchaseOrderHandlerService
		.runFsnProcedure(deptId,startDate,endDate,itemCatId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*float costPriceForAClass = 0.0f;
		float costPriceForBClass = 0.0f;
		for (StoreSetup storeSetup : classList) {
			costPriceForAClass = storeSetup.getAClass();
			costPriceForBClass = storeSetup.getBClass();

		}
		float costPrice = 50000f;
		Map<String, Object> costMap = new HashMap<String, Object>();
		costMap.put("costPriceForAClass", costPriceForAClass);
		costMap.put("costPriceForBClass", costPriceForBClass);

		requestParameters.put("costPriceForAClass", costPriceForAClass);
		requestParameters.put("costPriceForBClass", costPriceForBClass);

		Map<String, Object> stockMap = purchaseOrderHandlerService
				.getStockDetails(costMap);*/
		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		/*Float sumOfStock = null;

		if (stockMap.get("sumOfStock") != null) {
			sumOfStock = (Float) stockMap.get("sumOfStock");
		}
		requestParameters.put("sumOfStock", sumOfStock);*/
		/*HMSUtil.generateReport(ABC_ANALYSIS_FINAL_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());*/
		//Added By Manjul for new ABC analysis report using procedure
		HMSUtil.generateReport("fsn_analysis_report_new", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;

	}

	
	
	
	public ModelAndView showDrugExpiryReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Drug Expiry Report";

		jsp = DRUG_EXPIRY_REPORT_JSP;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDrugExpiryReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fromDate = "";
		@SuppressWarnings("unused")
		String day = "";
		@SuppressWarnings("unused")
		String year = "";
		@SuppressWarnings("unused")
		String month = "";
		@SuppressWarnings("unused")
		String monthAndYear = "";
		@SuppressWarnings("unused")
		int hospitalId = 0;
		String hospitalName = "";

		session = request.getSession();

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = request.getParameter(FROM_DATE);

				requestParameters.put("fromDate",
						HMSUtil.convertStringTypeDateToDateType(fromDate));
			}
			requestParameters.put("deptId",
					(Integer) session.getAttribute("deptId"));
			Map<String, Object> dataMap = new HashMap<String, Object>();

			dataMap = getHospitalParameterDetails(request);

			hospitalName = (String) dataMap.get("hospitalName");
			String hospitalAddress = (String) dataMap.get("hospitalAddress");
			hospitalId= (Integer) dataMap.get("hospitalId");
			requestParameters.put("hospitalName", hospitalName);
			requestParameters.put("hospitalAddress", hospitalAddress);
			requestParameters.put("hospitalId", hospitalId);
			/*StringTokenizer str = new StringTokenizer(fromDate, "/");

			while (str.hasMoreTokens()) {
				day = str.nextToken();
				month = str.nextToken();
				year = str.nextToken();
			}

			monthAndYear = year + "-" + month;*/

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(DRUG_EXPIRY_REPORT, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showPaymentTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Payment Terms";

		List<MasStorePoDeliveryTerms> paymentDetailsList = purchaseOrderHandlerService
				.getPaymentDetails();

		jsp = PO_PAYMENT_TERMS_JSP;

		map.put("paymentDetailsList", paymentDetailsList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		title = "Delivery Terms";
		List<MasStorePoDeliveryTerms> deliveryDetailsList = purchaseOrderHandlerService
				.getDeliveryDetails();
		jsp = PO_DELIVERY_TERMS_JSP;

		map.put("deliveryDetailsList", deliveryDetailsList);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPoListForPurchaseOrder(HttpServletRequest request,
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
		String itemNameField = "";
		String autoHint = "";
		@SuppressWarnings("unused")
		int poId = 0;

		Map<String, Object> dataMap = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			@SuppressWarnings("unused")
			List<StorePoHeader> poList = new ArrayList<StorePoHeader>();
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			// dataMap.put("poId",poId);

			map = purchaseOrderHandlerService
					.getPoListForPurchaseOrder(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "resultForPo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForPurchaseOrder(HttpServletRequest request,
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
			deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		}
 		// --------------------------------------------------------------------------------
		String itemNameField = "";
		String autoHint = "";
		int poId = 0;

		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			dataMap.put("autoHint", autoHint);
			dataMap.put("deptId", deptId);
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("poId", poId);

			map = purchaseOrderHandlerService
					.getItemListForPurchaseOrder(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "result";
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * public ModelAndView displayPaymentTerms(HttpServletRequest request,
	 * HttpServletResponse response){
	 * Map<String, Object> map = new HashMap<String, Object>();
	 *
	 * title = "Delivery Terms"; List<MasStorePoDeliveryTerms>
	 * deliveryDetailsList = purchaseOrderHandlerService.getDeliveryDetails();
	 * jsp = PO_PAYMENT_TERMS_JSP;
	 *
	 * int counter = 0; int poDeliveryTermId = 0;
	 *
	 * if(request.getParameter("counter") != null){ counter =
	 * Integer.parseInt(request.getParameter("counter")); }
	 * counter; i++) { if(request.getParameter("id"+i) != null){
	 * poDeliveryTermId = Integer.parseInt(request.getParameter("id"+i)); } }
	 * List<MasStorePoDeliveryTerms> poDeliveryDescList =
	 * purchaseOrderHandlerService
	 * .getDescriptionForDeliveryTermId(poDeliveryTermId);
	 *
	 * map.put("poDeliveryDescList", poDeliveryDescList);
	 *
	 * String desc = ""; if(request.getParameter(PO_DELIVERY_TERMS_DESC) !=
	 * null){ desc = request.getParameter(PO_DELIVERY_TERMS_DESC); }
	 * //map.put("deliveryDetailsList", deliveryDetailsList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 *
	 * public ModelAndView displayDeliveryTerms(HttpServletRequest request,
	 * HttpServletResponse response){ Map<String, Object> map = new
	 * HashMap<String, Object>();
	 *
	 * title = "Delivery Terms"; List<MasStorePoDeliveryTerms>
	 * deliveryDetailsList = purchaseOrderHandlerService.getDeliveryDetails();
	 * jsp = PO_DELIVERY_TERMS_JSP; int counter = 0; int poDeliveryTermId = 0;
	 *
	 * if(request.getParameter("counter") != null){ counter =
	 * Integer.parseInt(request.getParameter("counter")); }
	 * counter; i++) { if(request.getParameter("id"+i) != null){
	 * poDeliveryTermId = Integer.parseInt(request.getParameter("id"+i)); } }
	 * List<MasStorePoDeliveryTerms> poDeliveryDescList =
	 * purchaseOrderHandlerService
	 * .getDescriptionForDeliveryTermId(poDeliveryTermId);
	 * map.put("poDeliveryDescList", poDeliveryDescList);
	 * //map.put("deliveryDetailsList", deliveryDetailsList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 */

	/*
	 * public ModelAndView poViewAllJsp(HttpServletRequest request,
	 * HttpServletResponse response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>(); jsp =
	 * PO_VIEW_ALL_JSP; map=(Map)purchaseOrderHandlerService.getViewAllMap();
	 *
	 * title = "View All P.O."; map.put("contentJsp",jsp); map.put("title",
	 * title);
	 *
	 * return new ModelAndView(jsp,"map", map); } public ModelAndView
	 * poCreateJsp(HttpServletRequest request, HttpServletResponse response) {
	 *
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map=purchaseOrderHandlerService.showPurchaseOrderJsp(); //jsp =
	 * PO_CREATE_JSP; title = "PurchaseOrder"; map.put("contentJsp",jsp);
	 * map.put("title", title);
	 *
	 * return new ModelAndView(jsp,"map", map); }
	 *
	 * public ModelAndView poModifyJsp(HttpServletRequest request,
	 * HttpServletResponse response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>(); jsp =
	 * PO_MODIFY_JSP; jsp += ".jsp"; String radio_str=""; if
	 * (request.getParameter("parent") != null) { radio_str =
	 * request.getParameter("parent");
	 * map=(Map)purchaseOrderHandlerService.poModifyMap(radio_str); }
	 *
	 * radio_str ="+radio_str); map.put("contentJsp",jsp); map.put("title",
	 * title); map.put("radio_str",radio_str);
	 *
	 *
	 * ModelAndView("index","map", map); }
	 *
	 *
	 * private String getTextFromFile(String filePath) { // Opens a text file
	 * and returns the text from it. StringBuffer contents = new StringBuffer();
	 *
	 * BufferedReader reader = null; try { reader = new BufferedReader(new
	 * FileReader(filePath)); String line = null; while ((line =
	 * reader.readLine()) != null){ contents.append(line);
	 * contents.append( } } catch
	 * (FileNotFoundException ex1) { System.err.println("Invalid file path
	 * :"+ex1); } catch (IOException ex2){ System.err.println("cannot read from
	 * the file :"+ex2); } finally { try { reader.close(); } catch (IOException
	 * ex3) { System.err.println("cannot close the file :"+ex3); } } return
	 * contents.toString(); }
	 *
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * searchPO(HttpServletRequest request, HttpServletResponse response) throws
	 * IOException{
	 *
	 *
	 * @SuppressWarnings("unused") String fromDate="";
	 *
	 * @SuppressWarnings("unused") String toDate=""; @SuppressWarnings("unused")
	 * int supplierId=0; int departmentId=0; String includedJsp=""; int poNo=0;
	 *
	 * @SuppressWarnings("unused") String storeCode="";
	 *
	 * @SuppressWarnings("unused") String jsp="poMain";
	 *
	 * title = "View All P.O."; jsp += ".jsp"; Map<String,
	 * Object>searchFieldMap= new HashMap<String, Object>(); try{ if
	 * (request.getParameter(FROM_DATE) != null) { fromDate =
	 * request.getParameter(FROM_DATE);  } if (request.getParameter(TO_DATE) != null) { toDate =
	 * request.getParameter(TO_DATE);  }
	 * if (request.getParameter(PO_NO) != null) { poNo =Integer.parseInt(
	 * request.getParameter(PO_NO)); } if
	 * (request.getParameter(STORE_SUPPLIER_ID) != null) { supplierId
	 * =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID));
	 * } }catch (Exception e) {
	 *  } Map<String, Object>poMap= new
	 * HashMap<String, Object>(); Map<String, Object> map = new HashMap<String,
	 * Object>(); @SuppressWarnings("unused") Map<String, Object>tempMap= new
	 * HashMap<String, Object>();
	 *
	 * List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
	 * List<PoDetail> poDetailList = new ArrayList<PoDetail>(); List<PoHeader>
	 * poHeaderList = new ArrayList<PoHeader>();
	 *
	 * searchFieldMap.put("fromDate",fromDate);
	 * searchFieldMap.put("toDate",toDate); searchFieldMap.put("poNo",poNo);
	 * searchFieldMap.put("supplierId",supplierId);
	 * searchFieldMap.put("departmentId",departmentId);
	 *
	 *
	 * poMap=(Map)purchaseOrderHandlerService.getViewAllMap();
	 *
	 * supplierList=(List)poMap.get("supplierList");
	 * poDetailList=(List)poMap.get("poDetailList");
	 * poHeaderList=(List)poMap.get("poHeaderList");
	 *try{
	 * if(searchFieldMap.size()!=0){
	 * map=purchaseOrderHandlerService.searchPO(searchFieldMap);
	 *} else{
	 * }
	 *
	 * }catch (Exception e) { 
	 * } map.put("poDetailList", poDetailList); map.put("supplierList",
	 * supplierList); map.put("poHeaderList", poHeaderList);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 * map.put("includedJsp", includedJsp);
	 *
	 * return new ModelAndView("index","map", map);
	 *
	 *
	 * } public ModelAndView addPurchaseOrder(HttpServletRequest request,
	 * HttpServletResponse response) { 
	 * Map<String, Object> map = new HashMap<String, Object>(); StorePoHeader
	 * poHeader= new StorePoHeader(); StorePoDetail poDetail = new
	 * StorePoDetail(); int storeId=0; int supplierId=0; String poNumber="";
	 * String poReferenceNo=""; String remarks=""; String payTerms=""; String
	 * poTime=""; Date poDate = new Date(); String deliveryDate = ""; int
	 * itemId=0; String notes=""; String indentQty=""; String quantity="";
	 * String freeQty=""; String rate=""; String discount=""; String amount="";
	 * int salesTypeId=0; BigDecimal quantityOrdered=null; Date currentDate =
	 * new Date(); String changedBy = "";
	 *
	 *
	 * Map<String, Object> listMap=new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>();
	 *
	 *
	 * if (request.getParameter(DEPARTMENT_ID) != null) { storeId =
	 * Integer.valueOf(request.getParameter(DEPARTMENT_ID)); } if
	 * (request.getParameter(STORE_SUPPLIER_ID) != null) { supplierId =
	 * Integer.valueOf(request.getParameter(STORE_SUPPLIER_ID)); } if
	 * (request.getParameter(ITEM_ID) != null) { itemId =
	 * Integer.valueOf(request.getParameter(ITEM_ID)); } if
	 * (request.getParameter(PO_NO) != null) { poNumber =
	 * request.getParameter(PO_NO); }
	 *
	 * if (request.getParameter(PO_DATE) != null) { poDate=
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(PO_DATE)); }
	 *
	 * if (request.getParameter(PO_REFERENCE_NO) != null) { poReferenceNo=
	 * request.getParameter(PO_REFERENCE_NO); }
	 *
	 * if (request.getParameter(DELIVERY_DATE) != null) { deliveryDate=
	 * request.getParameter(DELIVERY_DATE); } if (request.getParameter(REMARKS)
	 * != null) { remarks= request.getParameter(REMARKS); } if
	 * (request.getParameter(PAY_TERMS) != null) { payTerms=
	 * request.getParameter(PAY_TERMS); }
	 *
	 * if (request.getParameter(PO_TIME) != null) { poTime=
	 * request.getParameter(PO_TIME); } if (request.getParameter(NOTES) != null)
	 * { notes= request.getParameter(NOTES); }
	 *
	 *
	 * if (request.getParameter(INDENT_QTY) != null) { indentQty=
	 * request.getParameter(INDENT_QTY); }
	 *
	 * if (request.getParameter(FREE_QTY) != null) { freeQty=
	 * request.getParameter(FREE_QTY); }
	 *
	 * if (request.getParameter(RATE) != null) { rate=
	 * request.getParameter(RATE); }
	 *
	 * if (request.getParameter(DISCOUNT) != null) { discount=
	 * request.getParameter(DISCOUNT); } if (request.getParameter(AMOUNT) !=
	 * null) { amount= request.getParameter(AMOUNT); }
	 *
	 * if (request.getParameter(SALES_TYPE_ID) != null) { salesTypeId=
	 * Integer.valueOf(request.getParameter(SALES_TYPE_ID)); }
	 *
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME);}
	 *
	 * if(request.getParameter(QUANTITY_ORDERED)!=null &&
	 * !(request.getParameter(QUANTITY_ORDERED).equals(""))){
	 * quantityOrdered=BigDecimal
	 * .valueOf(Double.parseDouble(request.getParameter(QUANTITY_ORDERED))); }
	 * if(request.getParameter(QUANTITY)!=null &&
	 * !(request.getParameter(QUANTITY).equals(""))){
	 * quantity=request.getParameter(QUANTITY); }
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName"); }
	 * if(request.getParameter("pojoPropertyName") != null){ pojoPropertyName =
	 * request.getParameter("pojoPropertyName"); }
	 * if(request.getParameter("pojoPropertyCode") != null){ pojoPropertyCode =
	 * request.getParameter("pojoPropertyCode"); } generalMap.put("poNumber",
	 * poNumber); generalMap.put("poDate", poDate);
	 * generalMap.put("poReferenceNo", poReferenceNo);
	 * generalMap.put("deliveryDate", deliveryDate); generalMap.put("remarks",
	 * remarks); generalMap.put("payTerms", payTerms); generalMap.put("poTime",
	 * poTime); generalMap.put("notes", notes); //generalMap.put("quantity",
	 * quantity); generalMap.put("indentQty", indentQty);
	 * generalMap.put("freeQty", freeQty); generalMap.put("rate", rate);
	 * generalMap.put("discount", discount); generalMap.put("amount", amount);
	 * generalMap.put("currentDate", currentDate); generalMap.put("currentTime",
	 * currentTime); generalMap.put("pojoName", pojoName);
	 * generalMap.put("quantityOrdered",quantityOrdered);
	 *
	 *
	 * boolean successfullyAdded = false; //poHeader.setPoNumber(poNumber);
	 * poHeader.setPoDate(poDate); poHeader.setPoTime(poTime);
	 * //poHeader.setReferenceNumber(poReferenceNo);
	 * poHeader.setDeliveryDate(deliveryDate); poHeader.setRemarks(remarks);
	 * poHeader.setPayTerms(payTerms); poHeader.setStatus("y");
	 * poHeader.setLastChgBy("admin"); poHeader.setLastChgDate(currentDate);
	 * poHeader.setLastChgTime(currentTime); poDetail.setNotes(notes);
	 * poDetail.setQuantityOrdered(quantityOrdered);
	 *
	 * MasDepartment masDepartment = new MasDepartment();
	 * masDepartment.setId(storeId); poHeader.setDepartment(masDepartment);
	 *
	 * MasStoreSupplier masSupplier = new MasStoreSupplier();
	 * masSupplier.setId(supplierId); poHeader.setSupplier(masSupplier);
	 *
	 * MasStoreItem masItem = new MasStoreItem(); masItem.setId(itemId);
	 * poDetail.setItem(masItem);
	 *
	 * successfullyAdded =
	 * purchaseOrderHandlerService.addPurchaseOrder(poHeader,poDetail);
	 * if(successfullyAdded) { message="Record Added Successfully"; } else {
	 * message="Try Again !"; } //jsp = PO_CREATE_JSP; title = "Purchase Order";
	 * map.put("contentJsp",jsp); map.put("title", title); return new
	 * ModelAndView(jsp,"map", map); }
	 */

	// -------------------------------------Prints by
	// Mansi--------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView printLocalPoFormatJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String poNo = null;
		session = request.getSession();
		/*
		 * int departmentId = 0; if(session.getAttribute("deptId") != null){
		 * departmentId = (Integer)session.getAttribute("deptId"); }
		 */
		requestParameters.put("DEPT", session.getAttribute("deptId"));

		try {
			if (request.getParameter(PO_NO) != null
					&& !(request.getParameter(PO_NO).equals(""))) {
				poNo = request.getParameter(PO_NO);
				requestParameters.put("po_number", poNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int hospitalId = 0;
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		hospitalId = Integer.parseInt(request.getSession().getAttribute(HOSPITAL_ID).toString());
		
		dataMap.put(HOSPITAL_ID, hospitalId);
		
		dataMap = hospitalDetailsMasterHandlerService.getHospitalList(dataMap);
		if (dataMap.get("masHospitalList") != null) {
			masHospitalList = (List<MasHospital>) dataMap.get("masHospitalList");
			requestParameters.put("hospitalName",
					masHospitalList.get(0).getHospitalName());
			requestParameters.put("hospitalAddress",
					masHospitalList.get(0).getAddress());
			requestParameters.put("hospitalId",hospitalId);
		}
		
		/*dataMap = hospitalDetailsMasterHandlerService.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			requestParameters.put("hospitalName",
					masSetupParameterMaintainceList.get(0).getHospital()
							.getHospitalName());
			requestParameters.put("hospitalAddress",
					masSetupParameterMaintainceList.get(0).getHospital()
							.getAddress());
			requestParameters.put("hospitalId",hospitalId);
		}*/

		Map<String, Object> connectionMap = purchaseOrderHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			if (request.getParameter("withStock") != null) {
				bytes = JasperRunManager
						.runReportToPdf(
								getCompiledReport("LocalSupplyOrderPrintForStoreswithstock"),
								requestParameters,
								(Connection) connectionMap.get("con"));
			} else {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport(LOCAL_SUPPLY_ORDER_PRINT_FOR_STORES),
						requestParameters,
						(Connection) connectionMap.get("con"));
			}
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ LOCAL_SUPPLY_ORDER_PRINT_FOR_STORES + ".pdf");
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

	@SuppressWarnings("unchecked")
	public Map<String, Object> getHospitalParameterDetails(
			HttpServletRequest request) {
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		//List<MasSetupParameterMaintaince> masSetupParameterMaintainceList = new ArrayList<MasSetupParameterMaintaince>();
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		hospitalId = Integer.parseInt(request.getSession().getAttribute(HOSPITAL_ID).toString());
		dataMap.put(HOSPITAL_ID, hospitalId);
		
		dataMap = hospitalDetailsMasterHandlerService.getHospitalList(dataMap);
		if (dataMap.get("masHospitalList") != null) {
			masHospitalList = (List<MasHospital>) dataMap.get("masHospitalList");
			dataMap.put("hospitalName", masHospitalList.get(0).getHospitalName());
			dataMap.put("hospitalAddress",
					masHospitalList.get(0).getAddress());
			dataMap.put("hospitalId",hospitalId);
		
		
		/*dataMap = hospitalDetailsMasterHandlerService.getSetupParameterMap(dataMap);
		if (dataMap.get("masSetupParameterMaintainceList") != null) {
			masSetupParameterMaintainceList = (List<MasSetupParameterMaintaince>) dataMap
					.get("masSetupParameterMaintainceList");
			dataMap.put("hospitalName", masSetupParameterMaintainceList.get(0)
					.getHospital().getHospitalName());
			dataMap.put("hospitalAddress",
					masSetupParameterMaintainceList.get(0).getHospital()
							.getAddress());
			dataMap.put("hospitalId",hospitalId);*/
		}
		return dataMap;
	}

	public PurchaseOrderHandlerService getPurchaseOrderHandlerService() {
		return purchaseOrderHandlerService;
	}

	public void setPurchaseOrderHandlerService(
			PurchaseOrderHandlerService purchaseOrderHandlerService) {
		this.purchaseOrderHandlerService = purchaseOrderHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public void setHospitalDetailsMasterHandlerService(
			HospitalDetailsMasterHandlerService hospitalDetailsMasterHandlerService) {
		this.hospitalDetailsMasterHandlerService = hospitalDetailsMasterHandlerService;
	}

	
	public ModelAndView showROLJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = purchaseOrderHandlerService.showROLJsp(deptId);
		jsp = "rolJsp";
		jsp += ".jsp";
		title = "Re- Order Level";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getItemListByGroup(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int groupId =0;
		if(request.getParameter("groupId")!=null)
		{
			groupId =Integer.parseInt(request.getParameter("groupId"));
		}
		map = purchaseOrderHandlerService.showROLJsp(deptId,groupId);
		jsp = "response_rol_jsp";
		//jsp += ".jsp";
		title = "Re Order Level";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView submitReorderLevel(HttpServletRequest request,
			HttpServletResponse response)
	{
		Box box = HMSUtil.getBox(request);
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		int departmentId = 0;
		String loginName = "";
	//	List<String> poList = new ArrayList<String>();
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("loginName") != null) {
			loginName = (String) session.getAttribute("loginName");
		}
		boolean flag = false;
		Map<String, Object> poMap = purchaseOrderHandlerService.submitReorderLevel(box,departmentId,loginName);
		if (poMap.get("flag") != null)
		{
			flag = (Boolean) poMap.get("flag");
		}
		/*if (poMap.get("poList") != null)
		{
			poList = (List<String>) poMap.get("poList");
		}*/
		String messageTOBeVisibleToTheUser = "";
		if(flag)
		{
			messageTOBeVisibleToTheUser = "ReOrder Level has been done Successfully";
		}
		else
		{
			messageTOBeVisibleToTheUser = "ReOrder Level has not been done Successfully";
		}
		jsp = "printrol";
		jsp += ".jsp";
		title = "ReOrder Level";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pageNo", 1);
		map.put("message", messageTOBeVisibleToTheUser);
	//	map.put("poList", poList);
		return new ModelAndView("index", "map", map);
	}
}
