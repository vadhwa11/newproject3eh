package jkt.hms.billing.controller;

import static jkt.hms.util.RequestConstants.BILLING_PACKAGE_LIST_JSP;
import static jkt.hms.util.RequestConstants.BILLING_PACKAGE_MASTER_JSP;
import static jkt.hms.util.RequestConstants.BILL_IP_PACKAGE_BILLING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.BILL_OP_PACKAGE_BOOKING_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.BILL_PACKAGE_BILLING_FOR_IP;
import static jkt.hms.util.RequestConstants.BILL_PACKAGE_BOOKING_FOR_OP;
import static jkt.hms.util.RequestConstants.BILL_PACKAGE_MEDICINES_JSP;
import static jkt.hms.util.RequestConstants.BILL_PACKAGE_SERVICES_JSP;
import static jkt.hms.util.RequestConstants.BILL_RESPONSE_FOR_PKG_BILL;
import static jkt.hms.util.RequestConstants.BILL_UPDATE_PACKAGE_MASTER_JSP;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ITEM_ID;
import static jkt.hms.util.RequestConstants.PACKAGE_CODE;
import static jkt.hms.util.RequestConstants.PACKAGE_DESCRIPTION;
import static jkt.hms.util.RequestConstants.PACKAGE_ID;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.billing.handler.BillingHandlerService;
import jkt.hms.billing.handler.OpBillingHandlerService;
import jkt.hms.billing.handler.PackageBillingHandlerService;
import jkt.hms.lab.handler.LabHandlerService;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PackageBillingController extends MultiActionController {

	PackageBillingHandlerService packageBillingHandlerService = null;
	OpBillingHandlerService opBillingHandlerService = null;
	LabHandlerService labHandlerService = null;
	AccountHandlerService accountHandlerService = null;
	BillingHandlerService billingHandlerService = null;

	public ModelAndView showBillingPackageListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = packageBillingHandlerService.getPackageMasterList();
		String jsp = BILLING_PACKAGE_LIST_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPackageMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = packageBillingHandlerService.getDetailsForPackageMaster();
		String jsp = BILLING_PACKAGE_MASTER_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePackageDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int userId = 0;
		HttpSession session = request.getSession();
		System.out.println("session"+session.hashCode());
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		System.out.println(hospitalId+"----"+userId);
		box.put("hospitalId",hospitalId);
		//Users user = (Users) session.getAttribute("users");
		box.put("userId", userId); 
		map = packageBillingHandlerService.savePackageDetails(box);

		String jsp = BILLING_PACKAGE_LIST_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPackageServicesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int packageId = box.getInt("parent");
		map = packageBillingHandlerService
				.getDetailsForPackageServices(packageId);
		String jsp = BILL_PACKAGE_SERVICES_JSP + ".jsp";
		map.put("packageId", packageId);
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePackageServices(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		box.put("userId", user.getId());

		map = packageBillingHandlerService.savePackageServices(box);
		map.put("packageId", box.getInt(PACKAGE_ID));
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		String jsp = BILL_PACKAGE_SERVICES_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updatePackageServices(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		box.put("userId", user.getId());

		map = packageBillingHandlerService.updatePackageServices(box);
		String jsp = BILL_PACKAGE_SERVICES_JSP + ".jsp";
		map.put("packageId", box.getInt(PACKAGE_ID));
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPackageMedicinesJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int packageId = box.getInt("parent");
		map = packageBillingHandlerService
				.getDetailsForPackageMedicines(packageId);
		String jsp = BILL_PACKAGE_MEDICINES_JSP + ".jsp";
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		map.put("packageId", packageId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getItemName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = packageBillingHandlerService.getItemName(box);
		String jsp = "billResponseForItem";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView savePackageMedicines(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		box.put("userId", user.getId());

		map = packageBillingHandlerService.savePackageMedicines(box);
		String jsp = BILL_PACKAGE_MEDICINES_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("packageId", box.getInt(PACKAGE_ID));
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDispensingPriceForItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int itemId = box.getInt(ITEM_ID);
		map = packageBillingHandlerService.getDispensingPriceForItem(itemId);
		String jsp = "billResponseForDispensingPrice";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updatePackageMedicines(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		box.put("userId", user.getId());

		map = packageBillingHandlerService.updatePackageMedicines(box);
		String jsp = BILL_PACKAGE_MEDICINES_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("packageId", box.getInt(PACKAGE_ID));
		map.put("packageCode", box.getString(PACKAGE_CODE));
		map.put("packageDesc", box.getString(PACKAGE_DESCRIPTION));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPackageDetailsForDisplay(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int packageId = box.getInt("packageId");
		map = packageBillingHandlerService
				.getPackageDetailsForDisplay(packageId);
		String jsp = "billResponseForPackageDetails";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showUpdatePackageMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int packageId = box.getInt("parent");
		map = packageBillingHandlerService
				.getDetailsForUpdatePackageMaster(packageId);
		String jsp = BILL_UPDATE_PACKAGE_MASTER_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("packageId", packageId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updatePackageDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("users");
		box.put("userId", user.getId());
		map = packageBillingHandlerService.updatePackageDetails(box);

		String jsp = BILLING_PACKAGE_LIST_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOPPackageBookingSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = BILL_OP_PACKAGE_BOOKING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getDetailsForPackageBilling(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = packageBillingHandlerService.getDetailsForPackageBilling(box);

		String jsp = "";

		if (box.getString("patientType").equals("OP")) {
			map.put("registered", box.getString("registered"));
			jsp = BILL_PACKAGE_BOOKING_FOR_OP + ".jsp";
		} else {
			jsp = BILL_PACKAGE_BILLING_FOR_IP + ".jsp";
		}
		map.put("patientType", box.getString("patientType"));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getPackageDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int packageId = box.getInt(PACKAGE_ID);
		map = packageBillingHandlerService.getPackageDetails(packageId);
		String jsp = BILL_RESPONSE_FOR_PKG_BILL;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOPPkgBillingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		int departmentId = 0;
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}
		
		//commented for maven
		/*String servBillNo = opBillingHandlerService
				.generateBillNo("OS", "save");
		String dispBillno = opBillingHandlerService
				.generateBillNo("OD", "save");
		String receiptNo = opBillingHandlerService.generateReceiptNo("save");*/
		String orderNo = labHandlerService.generateOrderNumber();
		//String voucherNo = accountHandlerService.generateVoucherNo("RES","save");

		
		//commented for maven
		/*int chargeSlipNo = billingHandlerService.getChargeSlipNo("save");

		box.put("servBillNo", servBillNo);
		box.put("dispBillNo", dispBillno);
		box.put("receiptNo", receiptNo);*/
		box.put("orderNo", orderNo);
		//====code commented by anamika=========//
		//box.put("voucherNo", voucherNo);
		
		//commented for maven
		/*box.put("chargeSlipNo", chargeSlipNo);*/

		map = packageBillingHandlerService.submitOPPkgBillingDetails(box);
		String message = "";
		if ((Boolean) map.get("saved") == true) {
			message = "Record Saved Successfully.";
		} else {
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp = BILL_OP_PACKAGE_BOOKING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIPPackageBillingSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = BILL_IP_PACKAGE_BILLING_SEARCH_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public PackageBillingHandlerService getPackageBillingHandlerService() {
		return packageBillingHandlerService;
	}

	public void setPackageBillingHandlerService(
			PackageBillingHandlerService packageBillingHandlerService) {
		this.packageBillingHandlerService = packageBillingHandlerService;
	}

	public OpBillingHandlerService getOpBillingHandlerService() {
		return opBillingHandlerService;
	}

	public void setOpBillingHandlerService(
			OpBillingHandlerService opBillingHandlerService) {
		this.opBillingHandlerService = opBillingHandlerService;
	}

	public LabHandlerService getLabHandlerService() {
		return labHandlerService;
	}

	public void setLabHandlerService(LabHandlerService labHandlerService) {
		this.labHandlerService = labHandlerService;
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(
			AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public BillingHandlerService getBillingHandlerService() {
		return billingHandlerService;
	}

	public void setBillingHandlerService(
			BillingHandlerService billingHandlerService) {
		this.billingHandlerService = billingHandlerService;
	}

}
