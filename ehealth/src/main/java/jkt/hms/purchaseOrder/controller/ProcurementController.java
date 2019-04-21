/**
 *  * Copyright 2008 JK Technosoft Ltd. All rights reserved.
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

import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.TO_DATE;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.MasAssetCategory;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.MmServiceRequest;
import jkt.hms.masters.business.PhAtpJphnJhiDetails;
import jkt.hms.masters.business.PhDayBlock;
import jkt.hms.masters.business.StorePoDetail;
import jkt.hms.masters.business.StorePoHeader;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.purchaseOrder.handler.ProcurementHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ProcurementController extends MultiActionController {
	private static final String HOSPITAL_ID = null;
	ProcurementHandlerService procurementHandlerService = null;

	public ProcurementHandlerService getProcurementHandlerService() {
		return procurementHandlerService;
	}

	public void setProcurementHandlerService(
			ProcurementHandlerService procurementHandlerService) {
		this.procurementHandlerService = procurementHandlerService;
	}

	CommonMasterHandlerService commonMasterHandlerService = null;

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String jspName = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String status = "";
	int id = 0;
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	String jsp="";
	String title="";
	
	
	//-------------pending List for local purchase-----------------------
	public ModelAndView showPendingItemsForLocalPurchaseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		String fromDate="";
		String toDate="";
		String itemName="";
		String itemCode="";
		int group=0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		//System.out.println("======="+request.getParameter("group"));
		if (request.getParameter("group") != null) {
			group =Integer.parseInt(""+request.getParameter("group"));
		}
		dataMap.put("group", group);

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		
		Map<String, Object> map = new HashMap<String, Object>();
    	map = procurementHandlerService.showPendingitemsforLocalPurchaseJsp(box, dataMap);
		jsp = "pendingItemsForLocalPurchase";
		jsp = jsp + ".jsp";
		title = "Pending items for Local Purchase";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//--------------------------End--------------------------------
	
	
	//------------------------ShowQuotationReuisition----------------------
	public ModelAndView showQuotationRequisitionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Integer> item=new ArrayList<Integer>();
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
		
		if(request.getParameterValues("selectCheckBox")!=null){
			for(int i=0;i<request.getParameterValues("selectCheckBox").length;i++){
				item.add(Integer.parseInt(request.getParameterValues("selectCheckBox")[i]));
			}
			dataMap.put("itemName", item);
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showQuotationRequisitionJsp(box, dataMap);
		jsp = "quotationRequisition";
		jsp = jsp + ".jsp";
		title = "Quotation Requisition";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//-------------------------------End-----------------------
	
	
	
	/*
	public ModelAndView getItemTypeGLList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int group = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("group") != null) {
			group = Integer.parseInt(request.getParameter("group"));
		}
		dataMap.put("group", group);
		map = procurementHandlerService.getItemTypeGLList(dataMap);

		jsp = "responseQuotationItem";


		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	 
	 public ModelAndView getSectionGLList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int type = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("type") != null) {
					type = Integer.parseInt(request.getParameter("type"));
				}
				dataMap.put("type", type);
				map = procurementHandlerService.getSectionGLList(dataMap);
				jsp = "responseQuotationSection";
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}
	 
	 
	 public ModelAndView responseQuotationRequisition(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int type = 0;
			int section=0;
			int group=0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("itemType") != null) {
					type = Integer.parseInt(request.getParameter("itemType"));
				}
				if (request.getParameter("sectionId") != null) {
					section = Integer.parseInt(request.getParameter("sectionId"));
				}
				if (request.getParameter("group") != null) {
					group = Integer.parseInt(request.getParameter("group"));
				}
				dataMap.put("type", type);
				dataMap.put("section", section);
				dataMap.put("group", group);
				map = procurementHandlerService.responseQuotationRequisition(dataMap);
				jsp = "responseQuotationRequisition";
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}
	 */
	//-------------------------------Open vendor List Controller-----------------------
	public ModelAndView openVendorListJsp(HttpServletRequest request,
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
    	map = procurementHandlerService.openVendorListJsp(box, dataMap);
		jsp = "openVendorList";
//		String jsp = "populateEquipmentList";
//		map.put("equipmentList", hesEquipmentMaster);
		return new ModelAndView(jsp, "map", map);
	}
	
	//-------------------End----------------------------------------------

	
	
	//-----------------------------SaveQuotationRequisition--------------------
	public ModelAndView saveQuotationRequisitionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId=0;
		int districtId = 0;
	
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer)session.getAttribute("hospitalId");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
		}
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer)session.getAttribute("districtId");
		}
         System.out.println("hospitalid"+hospitalId);
		dataMap.put("deptId", deptId);
		dataMap.put("districtId", districtId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(RequestConstants.USER_ID, userId);
	    
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map=procurementHandlerService.saveQuotationRequisitionJsp(box, dataMap);
		jsp = "mSubmitInfo";
		jsp = jsp + ".jsp";
		title = "Quotation Requisition";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new  ModelAndView("index", "map", map);
	}
	//-----------------------------End---------------------------------------
	
	//---------------------------Show pending list for Approval----------------
	public ModelAndView showPendingListForApprovalOfQuotationRequisitionJsp(HttpServletRequest request,
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
     	map = procurementHandlerService.showPendingListForApprovalOfQuotationRequisitionJsp(box, dataMap);
		jsp = "pendingListForApprovalOfQuotationRequisition";
		jsp = jsp + ".jsp";
		title = "Pending List For Approval Of Quotation Requisition";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
//--------------------------End-----------------------------------------------------------------------------
	
	//------------------------Show Quotation Requisition Approval------------------------
	public ModelAndView showQuotationRequisitionApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int requisitionId=0;
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
		
		if(request.getParameter("requitionId")!=null){
			 requisitionId = Integer.parseInt(""+request.getParameter("requitionId"));
		}
		System.out.println("---qqqq"+requisitionId);
        dataMap.put("requisitionId", requisitionId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
    	map = procurementHandlerService.showQuotationRequisitionApprovalJsp(box, dataMap);
		jsp = "quotationRequisitionApproval";
		jsp = jsp + ".jsp";
		title = "Quotation Requisition Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//------------End---------------------------
	
	//----------------------for vendor show in Quotation approval------------------
	public ModelAndView showVendorListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int requisitionId=0;
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
		if(request.getParameter("requisitionId")!=null){
			 requisitionId = Integer.parseInt(""+request.getParameter("requisitionId"));
		}
		 dataMap.put("requisitionId", requisitionId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
    	//map = procurementHandlerService.showVendorListJsp(box, dataMap);
		jsp = "showvendorlist";
		return new ModelAndView(jsp, "map", map);
	}
	//-------------------------------End-----------------------------------------
	
	//-------------controller for saving quotation requisition approval----------------------
	
	   public ModelAndView  saveQuotationRequisitionApprovalJsp(HttpServletRequest request,
			               HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId=0;
	
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Integer> item=new ArrayList<Integer>();
		session = request.getSession();

		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer)
					session.getAttribute(RequestConstants.HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
		}
		
		dataMap.put("deptId", deptId);
		dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
		dataMap.put("userName", userName);
		dataMap.put(RequestConstants.USER_ID, userId);
	    
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map=procurementHandlerService.saveQuotationRequisitionApprovalJsp(box, dataMap);
		jsp = "mSubmitInfo";
		jsp = jsp + ".jsp";
		title = "Quotation Requisition";
		map.put("contentJsp",jsp);
		map.put("title", title);
		return new  ModelAndView("index", "map", map);
	}
	   //----------------------End---------------------------------------
	
	//-------------------------show pending list for Quotation Submission-------------------
	public ModelAndView showPendingListForSubmittingQuotationJsp(HttpServletRequest request,
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
    	map = procurementHandlerService.showPendingListForSubmittingQuotationJsp(box, dataMap);
		jsp = "pendingListForSubmittingQuotation";
		jsp = jsp + ".jsp";
		title = "Pending List For Submitting Quotation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	//------------------End----------------------------------------------------
	
	//-----------------------ShowQuotationSubmission---------------------------
	public ModelAndView showQuotationSubmissionJsp(HttpServletRequest request,
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
     	map = procurementHandlerService.showQuotationSubmissionJsp(box, dataMap);
		jsp = "quotationSubmission";
		jsp = jsp + ".jsp";
		title = "Quotation Submission";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
   //------------------------------------End-------------------------------------
	
	//------------------------ShowQuotationSubmissionVendor----------------------------
	public ModelAndView showQuotationSubmissionSelectJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int requestId=0;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("requestId")!=null){
			requestId = Integer.parseInt(""+request.getParameter("requestId"));
		}
		map = procurementHandlerService.showAccessoryDetailsJsp(box, dataMap);
		jsp = "quotationSubmissionSelect";
		map.put("contentJsp", jsp);
		map.put("requestId", requestId);
		return new ModelAndView(jsp, "map", map);
	}
       
	//=================================save selected vendor=======================================
	public ModelAndView saveQuotationSubmissionSelectJsp(HttpServletRequest request,
 HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int requestId = 0;
		int hospitalId = 0;
		int deptId = 0;
		int userId = 0;
		
		HttpSession session=request.getSession();

		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (mrequest != null) {
			Box box = HMSUtil.getBox(request);
			
			int itemCount = 0;
			if (mrequest.getParameter("itemCount") != null
					&& !mrequest.getParameter("itemCount").equalsIgnoreCase("")) {
				itemCount = Integer
						.parseInt(mrequest.getParameter("itemCount"));
				box.put("itemCount",
						Integer.parseInt(mrequest.getParameter("itemCount")));
			}
			if (mrequest.getParameter("headerId") != null
					&& !mrequest.getParameter("headerId").equalsIgnoreCase("")) {
				box.put("headerId",
						Integer.parseInt(mrequest.getParameter("headerId")));
			}
			if (mrequest.getParameter("requestId") != null
					&& !mrequest.getParameter("requestId").equalsIgnoreCase("")) {
				box.put("requestId",
						Integer.parseInt(mrequest.getParameter("requestId")));
			}
			if (mrequest.getParameter("quotationSubmissionDate") != null
					&& !mrequest.getParameter("quotationSubmissionDate")
							.equalsIgnoreCase("")) {
				box.put("quotationSubmissionDate",
						(mrequest.getParameter("quotationSubmissionDate")));
			}
			for (int i = 1; i <= itemCount; i++) {
				if (mrequest.getParameter("item" + i) != null
						&& !mrequest.getParameter("item" + i)
								.equalsIgnoreCase("")) {
					box.put("item" + i, Integer.parseInt(mrequest
							.getParameter("item" + i)));
				}
				if (mrequest.getParameter("manufacture" + i) != null
						&& !mrequest.getParameter("manufacture" + i)
								.equalsIgnoreCase("")) {
					box.put("manufacture" + i, Integer.parseInt(mrequest
							.getParameter("manufacture" + i)));
				}

				if (mrequest.getParameter("ammount" + i) != null
						&& !mrequest.getParameter("ammount" + i)
								.equalsIgnoreCase("")) {
					box.put("ammount" + i,
							Float.parseFloat(mrequest.getParameter("ammount"
									+ i)));
				}

				if (mrequest.getParameter("rate" + i) != null
						&& !mrequest.getParameter("rate" + i).equalsIgnoreCase(
								"")) {
					box.put("rate" + i,
							Float.parseFloat(mrequest.getParameter("rate" + i)));
				}
				if (mrequest.getParameter("exciseOption" + i) != null
						&& !mrequest.getParameter("exciseOption" + i)
								.equalsIgnoreCase("")) {
					box.put("exciseOption" + i,
							mrequest.getParameter("exciseOption" + i));
				}
				if (mrequest.getParameter("exciseDuty" + i) != null
						&& !mrequest.getParameter("exciseDuty" + i)
								.equalsIgnoreCase("")) {
					box.put("exciseDuty" + i, Float.parseFloat(mrequest
							.getParameter("exciseDuty" + i)));
				}

				if (mrequest.getParameter("netAmount" + i) != null
						&& !mrequest.getParameter("netAmount" + i)
								.equalsIgnoreCase("")) {
					box.put("netAmount" + i,
							Float.parseFloat(mrequest.getParameter("netAmount"
									+ i)));
				}

				if (mrequest.getParameter("dicount" + i) != null
						&& !mrequest.getParameter("dicount" + i)
								.equalsIgnoreCase("")) {
					box.put("dicount" + i,
							Float.parseFloat(mrequest.getParameter("dicount"
									+ i)));
				}

				if (mrequest.getParameter("qty" + i) != null
						&& !mrequest.getParameter("qty" + i).equalsIgnoreCase(
								"")) {
					box.put("qty" + i,
							Float.parseFloat(mrequest.getParameter("qty" + i)));
				}

				if (mrequest.getParameter("remarks" + i) != null
						&& !mrequest.getParameter("remarks" + i)
								.equalsIgnoreCase("")) {
					box.put("remarks" + i, mrequest.getParameter("remarks" + i));
				}

				if (mrequest.getParameter("tax" + i) != null
						&& !mrequest.getParameter("tax" + i).equalsIgnoreCase(
								"")) {
					box.put("tax" + i,
							Float.parseFloat(mrequest.getParameter("tax" + i)));
				}
				if (mrequest.getParameter("technicalSpecification" + i) != null
						&& !mrequest.getParameter("technicalSpecification" + i)
								.equalsIgnoreCase("")) {
					box.put("technicalSpecification" + i,
							mrequest.getParameter("technicalSpecification" + i));
				}
				if (mrequest.getParameter("totalAmmount" + i) != null
						&& !mrequest.getParameter("totalAmmount" + i)
								.equalsIgnoreCase("")) {
					box.put("totalAmmount" + i, Float.parseFloat(mrequest
							.getParameter("totalAmmount" + i)));
				}
				if (mrequest.getParameter("vat" + i) != null
						&& !mrequest.getParameter("vat" + i).equalsIgnoreCase(
								"")) {
					box.put("vat" + i,
							Float.parseFloat(mrequest.getParameter("vat" + i)));
				}
			}
			if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
				hospitalId = (Integer) session
						.getAttribute(RequestConstants.HOSPITAL_ID);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			if (session.getAttribute(RequestConstants.USER_ID) != null) {
				userId = (Integer) session
						.getAttribute((RequestConstants.USER_ID));
			}

			dataMap.put("deptId", deptId);
			dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
			dataMap.put(RequestConstants.USER_ID, userId);
			map = procurementHandlerService.saveAccessoryDetailsJsp(box,
					dataMap);
			jsp = "mSubmitInfo";
			map.put("contentJsp", jsp);
			map.put("requestId", requestId);
		} else {
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
				hospitalId = (Integer) session
						.getAttribute(RequestConstants.HOSPITAL_ID);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			if (session.getAttribute(RequestConstants.USER_ID) != null) {
				userId = (Integer) session
						.getAttribute((RequestConstants.USER_ID));
			}

			dataMap.put("deptId", deptId);
			dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
			dataMap.put(RequestConstants.USER_ID, userId);

			map = procurementHandlerService.saveAccessoryDetailsJsp(box,
					dataMap);
			jsp = "mSubmitInfo";
			map.put("contentJsp", jsp);
			map.put("requestId", requestId);
		}

		if(request.getParameter("nextVendor")!=null && !request.getParameter("nextVendor").equals(""))
		{
			Box box = HMSUtil.getBox(request);
			if(request.getParameter("nextVendor")!=null){
				requestId = Integer.parseInt(""+request.getParameter("nextVendor"));
			}
			box.put("requestId", requestId);
			map = procurementHandlerService.showAccessoryDetailsJsp(box, dataMap);
			jsp = "quotationSubmissionSelect";
			map.put("contentJsp", jsp);
			
			map.put("requestId", requestId);
			return new ModelAndView(jsp, "map", map);
		}
		else
		{
			return new ModelAndView(jsp, "map", map);
		}
		
	}
       
	 //==============================method for save Item submission========================
	public ModelAndView saveItemQuotationSubmissionSelectJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		
		//map = procurementHandlerService.saveItemQuotationSubmissionSelectJsp(box, dataMap);
		jsp = "quotationSubmission";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
  
	  //====================================================================================================  
	
	public ModelAndView getItemTypeGLList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int quotationRequisitionNo = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("quotationRequisitionNo") != null) {
//			quotationRequisitionNo = Integer.parseInt(request.getParameter("quotationRequisitionNo"));
			 dataMap.put("quotationRequisitionNo", request.getParameter("quotationRequisitionNo"));
		}
		
		//System.out.println("------------"+quotationRequisitionNo);
		  map = procurementHandlerService.getItemTypeGLList(dataMap);

		  jsp = "vendorListDisplay";


		  map.put("contentJsp", jsp);
		  map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	//-----------------method for tecnical approval-------------
	public ModelAndView showTechnicalApprovalJsp(HttpServletRequest request,
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
     	map = procurementHandlerService.showTechnicalApprovalJsp(box, dataMap);
		jsp = "technicalApproval";
		jsp = jsp +".jsp";
		title = "Technical Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	//======================response for technical approval==================
	public ModelAndView responseTechnicalApproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		int requisitionId=0;
		if(request.getParameter("requisitionId")!=null){
			 requisitionId = Integer.parseInt(""+request.getParameter("requisitionId"));
			 dataMap.put("requisitionId", requisitionId);
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			 dataMap.put("flag", request.getParameter("flag"));
		}
		System.out.println("------"+request.getParameter("requisitionId"));
		map = procurementHandlerService.responseTechnicalApproval(box, dataMap);
		jsp = "responseTechnicalApproval";
		map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
//	=======================================================================================
	
	
	//======================save technical Approval==========================
	
	 public ModelAndView  saveTechnicalApproval(HttpServletRequest request,
             HttpServletResponse response) {
       String userName = "";
        int deptId = 0;
        int hospitalId = 0;
          int userId=0;

               Map<String, Object> dataMap = new HashMap<String, Object>();
               List<Integer> item=new ArrayList<Integer>();
               session = request.getSession();

              if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
               }
            if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
             hospitalId = (Integer)
		   session.getAttribute(RequestConstants.HOSPITAL_ID);
          }
          if (session.getAttribute("deptId") != null) {
          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
           }

            if (session.getAttribute(RequestConstants.USER_ID) != null) {
               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
                  }

             dataMap.put("deptId", deptId);
             dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
             dataMap.put("userName", userName);
              dataMap.put(RequestConstants.USER_ID, userId);

            Box box = HMSUtil.getBox(request);
            Map<String, Object> map = new HashMap<String, Object>();
            map=procurementHandlerService.saveTechnicalApproval(box, dataMap);
            
            //code to revert on same page of technical approval
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
    		if (request.getParameter("quotationRequisitionNo") != null && request.getParameter("quotationRequisitionNo") != "") {
    			map.put("quotationNo", request.getParameter("quotationRequisitionNo"));
    		}
    		if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != "") {
    			dataMap.put("fromDate", request.getParameter("fromDate"));
    		}
    		if (request.getParameter("toDate") != null && request.getParameter("toDate") != "") {
    			dataMap.put("toDate", request.getParameter("toDate"));
    		}
    		dataMap.put("deptId", deptId);
    		dataMap.put("hospitalId", hospitalId);
    		dataMap.put("userName", userName);

         	map.putAll(procurementHandlerService.showTechnicalApprovalJsp(box, dataMap));
    		jsp = "technicalApproval";
    		jsp = jsp + ".jsp";
    		title = "technicalApproval";
    		map.put("contentJsp", jsp);
    		map.put("title", title);
            
            /* jsp = "mSubmitInfo";
             jsp = jsp + ".jsp";
              title = "Quotation Requisition";
             map.put("contentJsp",jsp);
             map.put("title", title);*/
              return new  ModelAndView("index", "map", map);
                 }
	
	//---------------------End-------------------------------------------
	public ModelAndView showCommercialApprovalJsp(HttpServletRequest request,
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
     	map = procurementHandlerService.showCommercialApprovalJsp(box, dataMap);
		jsp = "commercialApproval";
		jsp = jsp + ".jsp";
		title = "Commercial Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//==========================================================================================
	
	   public ModelAndView getItemListForCommercial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int quotationRequisitionNo = 0;
		int hospitalId = 0;
		session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("quotationRequisitionNo1") != null) {
			quotationRequisitionNo = Integer.parseInt(request.getParameter("quotationRequisitionNo1"));
		}
		if (request.getParameter("flag") != null) {
			dataMap.put("flag", request.getParameter("flag"));
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			dataMap.put("hospitalId", hospitalId);
		}
		  dataMap.put("quotationRequisitionNo", quotationRequisitionNo);
		  map = procurementHandlerService.getItemListForCommercial(dataMap);

		  jsp = "itemListForCommercialApproval";


		  map.put("contentJsp", jsp);
		  map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	//=============================================================================================
	   
	//=============================================================================================
	   public ModelAndView vendorListCommercialJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			int requisitionId=0;
			String flag="";
			if(request.getParameter("requisitionId")!=null){
				 requisitionId = Integer.parseInt(""+request.getParameter("requisitionId"));
				 dataMap.put("requisitionId", requisitionId);
			}
			if (request.getParameter("flag") != null) {
				dataMap.put("flag", request.getParameter("flag"));
			}
			//System.out.println("------"+request.getParameter("requisitionId"));
			map = procurementHandlerService.vendorListCommercialJsp(box, dataMap);
			jsp = "vendorListForCommercial";

			map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
	   
	   
	   
   //=============================================================================================
	   
	  //============================save commercial approval================================
	   public ModelAndView  saveCommercialApproval(HttpServletRequest request,
	             HttpServletResponse response) {
	       String userName = "";
	        int deptId = 0;
	        int hospitalId = 0;
	          int userId=0;

	               Map<String, Object> dataMap = new HashMap<String, Object>();
	               List<Integer> item=new ArrayList<Integer>();
	               session = request.getSession();

	              if (session.getAttribute("userName") != null) {
	               userName = (String) session.getAttribute("userName");
	               }
	            if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
	             hospitalId = (Integer)
			   session.getAttribute(RequestConstants.HOSPITAL_ID);
	          }
	          if (session.getAttribute("deptId") != null) {
	          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	           }

	            if (session.getAttribute(RequestConstants.USER_ID) != null) {
	               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
	                  }

	             dataMap.put("deptId", deptId);
	             dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
	             dataMap.put("userName", userName);
	              dataMap.put(RequestConstants.USER_ID, userId);

	            Box box = HMSUtil.getBox(request);
	            Map<String, Object> map = new HashMap<String, Object>();
	            map=procurementHandlerService.saveCommercialApproval(box, dataMap);
	            //code for revert jsp page
	            
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
	    		if (request.getParameter("quotationRequisitionNo") != null && request.getParameter("quotationRequisitionNo") != "") {
	    			map.put("quotationNo", request.getParameter("quotationRequisitionNo"));
	    		}
	    		if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != "") {
	    			dataMap.put("fromDate", request.getParameter("fromDate"));
	    		}
	    		if (request.getParameter("toDate") != null && request.getParameter("toDate") != "") {
	    			dataMap.put("toDate", request.getParameter("toDate"));
	    		}
	    		dataMap.put("deptId", deptId);
	    		dataMap.put("hospitalId", hospitalId);
	    		dataMap.put("userName", userName);

	         	map.putAll(procurementHandlerService.showCommercialApprovalJsp(box, dataMap));
	    		jsp = "commercialApproval";
	    		jsp = jsp + ".jsp";
	    		title = "commercialApproval";
	    		map.put("contentJsp", jsp);
	    		map.put("title", title);
	            /* jsp = "mSubmitInfo";
	             jsp = jsp + ".jsp";
	             title = "Commercial Approval";
	             map.put("contentJsp",jsp);
	             map.put("title", title);*/
	             return new  ModelAndView("index", "map", map);
	                 }
	   //==========================================End========================
	   //============================vendor display for negotiation===========
	   
	   public ModelAndView vendorListNegotiation(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			int requisitionId=0;
			if(request.getParameter("requisitionId")!=null){
				requisitionId = Integer.parseInt(""+request.getParameter("requisitionId"));
				 dataMap.put("requisitionId", requisitionId);
			}
			System.out.println("====="+requisitionId);
			map = procurementHandlerService.vendorListNegotiation(box, dataMap);
			jsp = "vendorListForNegotiation";

			map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
	   //==================End========================================
	   
	 //==================item list for negotiation=====================
	   
	   public ModelAndView getItemListForNegotiation(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int requitionId = 0;
			int hospitalId = 0;
			session = request.getSession();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("requitionId") != null) {
				requitionId = Integer.parseInt(request.getParameter("requitionId"));
			}
			
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
				dataMap.put("hospitalId", hospitalId);
			}
			  dataMap.put("requitionId", requitionId);
			  System.out.println(requitionId);
			 map = procurementHandlerService.getItemListForNegotiation(box, dataMap);

			  jsp = "itemListForNegotiation";
			  jsp = jsp + ".jsp";
	             title = "Negotiation Process";
               map.put("contentJsp", jsp);
			  map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	  //=============================================================
	   //===========save negotiation==================================
	   public ModelAndView  saveNegotiation(HttpServletRequest request,
	             HttpServletResponse response) {
	       String userName = "";
	        int deptId = 0;
	        int requitionId = 0;
			int hospitalId = 0;
	          int userId=0;

	               Map<String, Object> dataMap = new HashMap<String, Object>();
	               session = request.getSession();

	              if (session.getAttribute("userName") != null) {
	               userName = (String) session.getAttribute("userName");
	               }
	            if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
	             hospitalId = (Integer)
			   session.getAttribute(RequestConstants.HOSPITAL_ID);
	          }
	          if (session.getAttribute("deptId") != null) {
	          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	           }

	            if (session.getAttribute(RequestConstants.USER_ID) != null) {
	               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
	                  }

	             dataMap.put("deptId", deptId);
	             dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
	             dataMap.put("userName", userName);
	              dataMap.put(RequestConstants.USER_ID, userId);

	            Box box = HMSUtil.getBox(request);
	            Map<String, Object> map = new HashMap<String, Object>();
	              map=procurementHandlerService.saveNegotiation(box, dataMap);
	              
	              if (request.getParameter("requitionId") != null) {
	  				requitionId = Integer.parseInt(request.getParameter("requitionId"));
	  			}
	  			
	  			if (session.getAttribute("hospitalId") != null) {
	  				hospitalId = Integer.parseInt(""
	  						+ session.getAttribute("hospitalId"));
	  				dataMap.put("hospitalId", hospitalId);
	  			}
	  			  dataMap.put("requitionId", requitionId);
	  			 map.putAll(procurementHandlerService.getItemListForNegotiation(box, dataMap));

	  			  jsp = "itemListForNegotiation";
	  			  jsp = jsp + ".jsp";
	  	             title = "Negotiation Process";
	                 map.put("contentJsp", jsp);
	  			  map.put("title", title);
	  			return new ModelAndView("index", "map", map);
	             /*jsp = "mSubmitInfo";
	             jsp = jsp + ".jsp";
	             title = "Negotiation Process";
	             map.put("contentJsp",jsp);
	             map.put("title", title);
	             return new  ModelAndView("index", "map", map);*/
	             
	                 }
	   
	   
	   //==================end========================================
	public ModelAndView showPendingListForCreatingPOWOJsp(HttpServletRequest request,
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
		if (request.getParameter("quotationNo") != null && request.getParameter("quotationNo") != "") {
			dataMap.put("quotationNo", request.getParameter("quotationNo"));
		}
		if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != "") {
			dataMap.put("fromDate", request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null && request.getParameter("toDate") != "") {
			dataMap.put("toDate", request.getParameter("toDate"));
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
     	map = procurementHandlerService.showPendingListForCreatingPOWOJsp(box, dataMap);
		jsp = "pendingListForCreatingPOWO";
		jsp = jsp + ".jsp";
		title = "Pending List For Creating Purchase order or work order";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
//	Pending List Of Technical Approval Start
	public ModelAndView showPendingTechnicalApprovalJsp(HttpServletRequest request,
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
		if (request.getParameter("quotationNo") != null && request.getParameter("quotationNo") != "") {
			dataMap.put("quotationNo", request.getParameter("quotationNo"));
		}
		if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != "") {
			dataMap.put("fromDate", request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null && request.getParameter("toDate") != "") {
			dataMap.put("toDate", request.getParameter("toDate"));
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
     	map = procurementHandlerService.showPendingTechnicalApprovalJsp(box, dataMap);
		jsp = "pendingTechnicalApproval";
		jsp = jsp + ".jsp";
		title = "Pending List For Technical Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
//	End ----------------------------------------------------------

//	Pending List Of Commercial Approval Start
	public ModelAndView showPendingCommercialApprovalJsp(HttpServletRequest request,
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
		if (request.getParameter("quotationNo") != null && request.getParameter("quotationNo") != "") {
			dataMap.put("quotationNo", request.getParameter("quotationNo"));
		}
		if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != "") {
			dataMap.put("fromDate", request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null && request.getParameter("toDate") != "") {
			dataMap.put("toDate", request.getParameter("toDate"));
		}
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
     	map = procurementHandlerService.showPendingCommercialApprovalJsp(box, dataMap);
		jsp = "pendingCommercialApproval";
		jsp = jsp + ".jsp";
		title = "Pending List For Technical Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
//	End ----------------------------------------------------------

//	================================================================================================
	//Method for submit po creation==============================================================
	   public ModelAndView  submitPoCreation(HttpServletRequest request,
	             HttpServletResponse response) {
	       String userName = "";
	        int deptId = 0;
	        int hospitalId = 0;
	          int userId=0;

	               Map<String, Object> dataMap = new HashMap<String, Object>();
	               session = request.getSession();

	              if (session.getAttribute("userName") != null) {
	               userName = (String) session.getAttribute("userName");
	               }
	              if (session.getAttribute("hospitalId") != null) {
	      			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	      		}
	          if (session.getAttribute("deptId") != null) {
	          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	           }

	            if (session.getAttribute(RequestConstants.USER_ID) != null) {
	               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
	                  }
                  System.out.println("hospital"+hospitalId);
	             dataMap.put("deptId", deptId);
	             dataMap.put("hospitalId", hospitalId);
	             dataMap.put("userName", userName);
	              dataMap.put(RequestConstants.USER_ID, userId);
                     
	            Box box = HMSUtil.getBox(request);
	            Map<String, Object> map = new HashMap<String, Object>();
	              map=procurementHandlerService.submitPoCreation(box, dataMap);
	             jsp = "mSubmitInfo";
	             jsp = jsp + ".jsp";
	             title = "Po Creation";
	             map.put("contentJsp",jsp);
	             map.put("title", title);
	             return new  ModelAndView("index", "map", map);
	                 }
	   
	//===============================================================================
	public ModelAndView showPOCreationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int requitionId=0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			dataMap.put("flag", flag);
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
		if (request.getParameter("requitionId") != null) {
			requitionId = Integer.parseInt(request.getParameter("requitionId"));
		}
		dataMap.put("requitionId", requitionId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showPOCreationJsp(box, dataMap);
		jsp = "poCreation";
		jsp = jsp + ".jsp";
		title = "PO Creation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//=======================================================================
	public ModelAndView showPendingForPOApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int vendorName=0;
		String poNo="";
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
		if (request.getParameter("vendorName") != null) {
			vendorName =Integer.parseInt(""+request.getParameter("vendorName"));
		}
		//System.out.println("---"+vendorName);
		if (request.getParameter("poNo") != null && request.getParameter("poNo") != "") {
			dataMap.put("poNo", request.getParameter("poNo"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			dataMap.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			dataMap.put("toDate", request.getParameter("toDate"));
		}
		dataMap.put("vendorName", vendorName);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
     	map = procurementHandlerService.showPendingForPOApprovalJsp(box, dataMap);
		jsp = "pendingForPOApproval";
		jsp = jsp + ".jsp";
		title = "Pending for PO Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	//============================controller for direct po creation===========================
	public ModelAndView directPoCreation(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		//String poNo="";
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
     	map = procurementHandlerService.directPoCreation(box, dataMap);
     	
		jsp = "directPoCreation";
		jsp = jsp + ".jsp";
		title = "Direct po Creation";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	//=====================================================================================
	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

		int deptId = 0;
		int hospitalId = 0;
		String itemNameField="";
		String hint="";

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if(!itemNameField.equals(""))
		{
			hint=(request.getParameter(itemNameField));
		}
		int vendorId =0;

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("vendorId") != null) {
				vendorId = Integer.parseInt (request.getParameter("vendorId"));
			}
			map.put("itemNameField", hint);
			map.put("vendorId", vendorId);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = procurementHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "pItemDetails";
		return new ModelAndView(jsp, "map", map);
	}

	//==============================================================================
	public ModelAndView showPOApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int requitionId=0;
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
		if (request.getParameter("requitionId") != null) {
			requitionId = Integer.parseInt(request.getParameter("requitionId"));
		}
		 System.out.println("id"+requitionId);
		dataMap.put("requitionId", requitionId);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
  		map = procurementHandlerService.showPOApprovalJsp(box, dataMap);
		jsp = "poApproval";
		jsp = jsp + ".jsp";
		title = "PO Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	//================================po approval=====================================
	   public ModelAndView  poApproval(HttpServletRequest request,
	             HttpServletResponse response) {
	       String userName = "";
	        int deptId = 0;
	        int hospitalId = 0;
	          int userId=0;

	               Map<String, Object> dataMap = new HashMap<String, Object>();
	               session = request.getSession();

	              if (session.getAttribute("userName") != null) {
	               userName = (String) session.getAttribute("userName");
	               }
	            if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
	             hospitalId = (Integer)
			   session.getAttribute(RequestConstants.HOSPITAL_ID);
	          }
	          if (session.getAttribute("deptId") != null) {
	          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	           }

	            if (session.getAttribute(RequestConstants.USER_ID) != null) {
	               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
	                  }

	             dataMap.put("deptId", deptId);
	             dataMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
	             dataMap.put("userName", userName);
	              dataMap.put(RequestConstants.USER_ID, userId);

	            Box box = HMSUtil.getBox(request);
	            Map<String, Object> map = new HashMap<String, Object>();
	              map=procurementHandlerService.poApproval(box, dataMap);
	             jsp = "mSubmitInfo";
	             jsp = jsp + ".jsp";
	             title = "Po Approval";
	             map.put("contentJsp",jsp);
	             map.put("title", title);
	             return new  ModelAndView("index", "map", map);
	                 }
	   //===============================================================================================

	public ModelAndView showPendingListForEnterEquipmentDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
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
		if(request.getParameter("equipmentName") != null && !request.getParameter("equipmentName").equals("")){
			String itemName = request.getParameter("equipmentName");
			Integer index1 = itemName.lastIndexOf("[") + 1;
			int index2 = itemName.lastIndexOf("]");
			int itemId =Integer.parseInt(itemName.substring(index1, index2));
			box.put("itemId", itemId);
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		//Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap);
		jsp = "pendingListForEnterEquipmentDetail";
		jsp = jsp + ".jsp";
		title = "Pending List for enter equipment detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	// Methods for Equipment Details Master ------- START  
		public ModelAndView showEquipmentDetailsMasterJsp(HttpServletRequest request,
				HttpServletResponse response)
		{   Map<String, Object> dataMap = new HashMap<String, Object>();
			int  deptId=0;
			int hospitalId= 0 ;
			session = request.getSession();
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
				hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
			}
			map.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			
//			map = hesHandlerService.showEquipmentDetailsMasterJsp(hospitalId);
			jsp = "hesEquipmentDetailsMaster";
			jsp += ".jsp";
			title = "Equipment Entry Master";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitEquipmentDetails(HttpServletRequest request,
				HttpServletResponse response)
		{   Map<String, Object> dataMap = new HashMap<String, Object>();
			int deptId = 0;
			int hospitalId = 0;
			int userId=0;
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
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
	
			dataMap.put("userId", userId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);
			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			map = procurementHandlerService.submitEquipmentDetails(box, dataMap);
			map.putAll(procurementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap));;
			jsp = "pendingListForEnterEquipmentDetail";
			jsp = jsp + ".jsp";
			title = "Pending List for enter equipment detail";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
	public ModelAndView showEquipmentDetailJsp(HttpServletRequest request,	HttpServletResponse response) {
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
		map = procurementHandlerService.showEquipmentDetailJsp(box, dataMap);
		//map = procurementHandlerService.showPendingListForEnterEquipmentDetailJsp(box, dataMap);
		jsp = "equipmentDetail";
		jsp = jsp + ".jsp";
		title = "Pending List for enter equipment detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	

	public ModelAndView showManufactureDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showManufactureDetailJsp(box);
		jsp = "manufactureDetailJsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showWarrantyDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showManufactureDetailJsp(box);
		jsp = "warrantyDetailJsp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}


	public ModelAndView showAccessoryDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showAccessoryDetailsJsp(box);
		jsp = "accessoryDetails";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	/////////////////////////------------------------Asset Master Creation------------------//////////////////////////////
	
	public ModelAndView showCategoryMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showCategoryMasterJsp();
		String jsp = "category";
		jsp += ".jsp";
		title = "Title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showSubCategoryMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showSubCategoryMasterJsp();
		String jsp = "assetCategory";
		jsp += ".jsp";
		title = "Title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView showAssetDetailsMovableJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			details.put("hospitalId", hospitalId);
		}
	map = procurementHandlerService.showAssetDetailsMovableJsp(details);
		String jsp = "assetsDetailsMovable";
		jsp += ".jsp";
		title = "Asset Details for Movable Fixed Assets";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	/** Populate Store Item Name based on item Code
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateStoreItemCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasItemCategory> masItemCategories=new ArrayList<MasItemCategory>();
		
		int storeSectionId=0;
		if(null !=request.getParameter("storeSectionId") && !request.getParameter("storeSectionId").equals("")){
			storeSectionId=Integer.parseInt(request.getParameter("storeSectionId"));
		}
		
		map=procurementHandlerService.populateStoreItemCategory(storeSectionId);
		
		if(null !=map.get("masItemCategories")){
			masItemCategories=(List<MasItemCategory>) map.get("masItemCategories");
		}
		
		
	StringBuffer sb = new StringBuffer();
		
		if(null !=masItemCategories && masItemCategories.size()>0){
			for(MasItemCategory itemCategory:masItemCategories){
							
				sb.append("<item>");
				
				sb.append("<itemName>"+itemCategory.getItemCategoryName() + "</itemName>");
				sb.append("<itemId>"+itemCategory.getId() + "</itemId>");
				
				sb.append("</item>");
			}
			
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();

		
	}
	
	/** Populate Store Item Name based on item Code
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateImmovableStoreItemCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasItemCategory> masItemCategories=new ArrayList<MasItemCategory>();
		
		int storeSectionId=0;
		if(null !=request.getParameter("storeSectionId") && !request.getParameter("storeSectionId").equals("")){
			storeSectionId=Integer.parseInt(request.getParameter("storeSectionId"));
		}
		
		map=procurementHandlerService.populateImmovableStoreItemCategory(storeSectionId);
		
		if(null !=map.get("masItemCategories")){
			masItemCategories=(List<MasItemCategory>) map.get("masItemCategories");
		}
		
		
	StringBuffer sb = new StringBuffer();
		
		if(null !=masItemCategories && masItemCategories.size()>0){
			for(MasItemCategory itemCategory:masItemCategories){
							System.out.println(""+itemCategory.getItemCategoryName() );
				sb.append("<item>");
				
				sb.append("<itemName>"+itemCategory.getItemCategoryName() + "</itemName>");
				sb.append("<itemId>"+itemCategory.getId() + "</itemId>");
				
				sb.append("</item>");
			}
			
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();

		
	}
	
	
	@SuppressWarnings("unchecked")
	public void populateCodeByItemName(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasStoreItem> itemCodeList= new ArrayList<MasStoreItem>();
		
		int itemNameId=0;
		if(null !=request.getParameter("itemNameId") && !request.getParameter("itemNameId").equals("") ){
			itemNameId=Integer.parseInt(request.getParameter("itemNameId"));
		}
		
		map=procurementHandlerService.populateCodeByItemName(itemNameId);
		
		if(null !=map.get("itemList")){
			itemCodeList=(List<MasStoreItem>) map.get("itemList");
		}
		
		
	StringBuffer sb = new StringBuffer();
		
		if(null !=itemCodeList && itemCodeList.size()>0){
			for(MasStoreItem itemCode:itemCodeList){
							
				sb.append("<item>");
				sb.append("<itemName>"+itemCode.getNomenclature() + "</itemName>"); // added by amit das 
				sb.append("<pvsm_no>"+itemCode.getPvmsNo() + "</pvsm_no>");
				sb.append("<itemId>"+itemCode.getId() + "</itemId>");
				
				sb.append("</item>");
			}
			
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();

		
	}
	
	
	@SuppressWarnings("unchecked")
	public void populateImmovableCodeByItemName(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<MasStoreItem> itemCodeList= new ArrayList<MasStoreItem>();
		
		int itemNameId=0;
		if(null !=request.getParameter("itemNameId") && !request.getParameter("itemNameId").equals("") ){
			itemNameId=Integer.parseInt(request.getParameter("itemNameId"));
		}
		
		map=procurementHandlerService.populateImmovableCodeByItemName(itemNameId);
		
		if(null !=map.get("itemList")){
			itemCodeList=(List<MasStoreItem>) map.get("itemList");
		}
		
		
	StringBuffer sb = new StringBuffer();
		
		if(null !=itemCodeList && itemCodeList.size()>0){
			for(MasStoreItem itemCode:itemCodeList){
							
				sb.append("<item>");
				sb.append("<itemName>"+itemCode.getNomenclature() + "</itemName>"); // added by amit das on 02-08-2016
				sb.append("<pvsm_no>"+itemCode.getPvmsNo() + "</pvsm_no>");
				sb.append("<itemId>"+itemCode.getId() + "</itemId>");
				
				sb.append("</item>");
			}
			
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();

		
	}
	
	

	/** Populate Store Item Name based on item Code
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void populateStoreItemNameByCode(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> map = new HashMap<String, Object>();
		int itemCode=0;
		if(null !=request.getParameter("itemCode") && !request.getParameter("itemCode").equals("")){
			itemCode=Integer.parseInt(request.getParameter("itemCode"));
		}
		
		map=procurementHandlerService.populateStoreItemNameByCode(itemCode);
		String itemName="";
		if(null !=map.get("itemName")){
			itemName=(String) map.get("itemName");
		}
		
		
	StringBuffer sb = new StringBuffer();
		
		if(null !=itemName && !itemName.equals("")){
			
				sb.append("<item>");
				
				sb.append("<itemName>"+itemName + "</itemName>");
				
				sb.append("</item>");
			
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();

		
	}
	
	
	public ModelAndView showAssetDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
			details.put("hospitalId", hospitalId);
		}
		map = procurementHandlerService.showAssetDetailsJsp(details);
		String jsp = "assetDetails";
		jsp += ".jsp";
		title = "Asset Details for Immovable(Fixed Assets)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}



	public ModelAndView showPendingListForAuctionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.showPendingListForAuctionJsp(box);
		jsp = "pendingListForAuction";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}	


	public ModelAndView showAuctionDetailJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		
		box.put("hospitalId", hospitalId);

		map = procurementHandlerService.showAuctionDetailJsp(box);
		jsp = "auctionDetail";
		jsp = jsp + ".jsp";
		title = "Auction Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}	

//============================================Insurance details==============================================
	public ModelAndView showInsuranceDetailJsp(HttpServletRequest request,HttpServletResponse response) {
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
		if (request.getParameter("assetCode") != null && request.getParameter("assetCode") != "") {
			dataMap.put("assetCode", request.getParameter("assetCode"));
		}
		if (request.getParameter("assetname") != null && request.getParameter("assetname") != "") {
			dataMap.put("assetname", request.getParameter("assetname"));
		}
		/*if (request.getParameter("catogery") != null && request.getParameter("catogery") != "") {
			dataMap.put("catogery", request.getParameter("catogery"));
		}*/
		if (request.getParameter("insuranceDetailDate") != null && request.getParameter("insuranceDetailDate") != "") {
			dataMap.put("insuranceDetailDate", request.getParameter("insuranceDetailDate"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map = procurementHandlerService.showInsuranceDetailJsp(box, dataMap);
		jsp = "insuranceDetail";
		jsp = jsp + ".jsp";
		title = "Insurance Detail";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}	

//============================================================================================================================================
	//======================================Submit insurance==============================================================================
	 public ModelAndView  submitInsuranceDetails(HttpServletRequest request,
             HttpServletResponse response) {
       String userName = "";
        int deptId = 0;
        int hospitalId = 0;
          int userId=0;

               Map<String, Object> dataMap = new HashMap<String, Object>();
               session = request.getSession();

              if (session.getAttribute("userName") != null) {
               userName = (String) session.getAttribute("userName");
               }
              if (session.getAttribute("hospitalId") != null) {
      			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
      		}
          if (session.getAttribute("deptId") != null) {
          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
           }

            if (session.getAttribute(RequestConstants.USER_ID) != null) {
               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
                  }
              System.out.println("hospital"+hospitalId);
             dataMap.put("deptId", deptId);
             dataMap.put("hospitalId", hospitalId);
             dataMap.put("userName", userName);
              dataMap.put(RequestConstants.USER_ID, userId);
                 
            Box box = HMSUtil.getBox(request);
            Map<String, Object> map = new HashMap<String, Object>();
              map=procurementHandlerService.submitInsuranceDetails(box, dataMap);
             jsp = "mSubmitInfo";
             jsp = jsp + ".jsp";
             title = "Insurance Details";
             map.put("contentJsp",jsp);
             map.put("title", title);
             return new  ModelAndView("index", "map", map);
                 }
   //=======================================================================================
	 
	 //===========================pending insurance renewal======================================
	 public ModelAndView showPendingRenewalInsurance(HttpServletRequest request,
				HttpServletResponse response) {
			String userName = "";
			int deptId = 0;
			int hospitalId = 0;
			String fromDate="";
			String toDate="";
			String itemName="";
			String itemCode="";
			int dueDay=0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			session = request.getSession();

			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
			}
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		    if (request.getParameter("dueDay") != null) {
			dueDay =Integer.parseInt(""+request.getParameter("dueDay"));
			}
			dataMap.put("dueDay", dueDay);
             System.out.println("duedaye"+dueDay);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);

			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
	    	map = procurementHandlerService.showPendingRenewalInsurance(box, dataMap);
			jsp = "pendingInsuranceRenewal";
			jsp = jsp + ".jsp";
			title = "Pending Renewal List";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	 
	 //==============================================================================================
	 //=================================renewal detail=========================================
	 
	 public ModelAndView showRenewaljsp(HttpServletRequest request,
				HttpServletResponse response) {
			String userName = "";
			int deptId = 0;
			int hospitalId = 0;
			int requisitionId=0;
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
			if(request.getParameter("requitionId")!=null){
				 requisitionId = Integer.parseInt(""+request.getParameter("requitionId"));
			}
			 dataMap.put("requisitionId", requisitionId);
			 System.out.println("----"+requisitionId);
			dataMap.put("deptId", deptId);
			dataMap.put("hospitalId", hospitalId);
			dataMap.put("userName", userName);

			Box box = HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
	    	map = procurementHandlerService.showRenewaljsp(box, dataMap);
			jsp = "renewalDetail";
			jsp = jsp + ".jsp";
			title = "Renewal Details";
			map.put("contentJsp", jsp);
			map.put("title", title);
			
			return new ModelAndView("index", "map", map);
		}
	 
	 //==========================================================================================
	public ModelAndView showInsuranceClaimAndTrackingJsp(HttpServletRequest request,HttpServletResponse response) {
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
		if (request.getParameter("assetCode") != null && request.getParameter("assetCode") != "") {
			dataMap.put("assetCode", request.getParameter("assetCode"));
		}
		if (request.getParameter("assetname") != null && request.getParameter("assetname") != "") {
			dataMap.put("assetname", request.getParameter("assetname"));
		}
		
		if (request.getParameter("insuranceDetailDate") != null && request.getParameter("insuranceDetailDate") != "") {
			dataMap.put("insuranceDetailDate", request.getParameter("insuranceDetailDate"));
		}

		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("userName", userName);

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
    	map = procurementHandlerService.showInsuranceClaimAndTrackingJsp(box, dataMap);
		jsp = "insuranceClaimAndTracking";
		jsp = jsp + ".jsp";
		title = "Insurance Claim and Tracking";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}	

	public ModelAndView showPhysicalInventoryDetailsJsp(HttpServletRequest request,HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		HttpSession	session = request.getSession();

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
		map = procurementHandlerService.showPhysicalInventoryDetailsJsp(dataMap,box);
		jsp = "physicalInventoryDetails";
		jsp = jsp + ".jsp";
		title = "Physical Inventory Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitPhysicalInventoryDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		HttpSession	session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = procurementHandlerService.submitPhysicalInventoryDetails(box);
		boolean flag = true;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			messageTOBeVisibleToTheUser = "Record Saved Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
			map.put("messageType", "failure");
		}
		jsp = "annualIndentMessage";
		url = "/hms/hms/procurement?method=showPhysicalInventoryDetailsJsp";
		/*jsp = "physicalInventoryDetails";*/
		jsp = jsp + ".jsp";
		title = "Physical Inventory Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView showNegotiationJsp(HttpServletRequest request,HttpServletResponse response) {
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
         map = procurementHandlerService.showNegotiationJsp(box, dataMap);
		jsp = "negotiation";
		jsp = jsp + ".jsp";
		title = "Negotiation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	// -------------------------category
	// ------------------------------------------------

	public ModelAndView searchCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String categoryCode = null;
		String categoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			categoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			categoryName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			categoryCode = searchField;
			categoryName = null;

		} else {
			categoryCode = null;
			categoryName = searchField;
		}
		map = procurementHandlerService.searchCategory(categoryCode,categoryName);

		jsp = "category";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("categoryCode", categoryCode);
		map.put("categoryName", categoryName);
		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasAssetCategory masCategory = new MasAssetCategory();
		String code="";
		String name="";
		String currentTime="";
		HttpSession session = request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
	/*	if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}*/
	
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

		List categoryCodeList = new ArrayList();
		List categoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			categoryCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			categoryNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((categoryCodeList.size() == 0 || categoryCodeList == null)
				&& (categoryNameList.size() == 0 || categoryNameList == null)) {
			masCategory.setAssetCategoryCode(code);
			masCategory.setAssetCategoryName(name);
			masCategory.setStatus("y");

			
			Users users = new Users();
			users.setId(userId);
			masCategory.setLastChgBy(users);
			
			masCategory.setLastChgDate(currentDate);
			masCategory.setLastChgTime(currentTime);
			successfullyAdded = procurementHandlerService.addCategory(masCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((categoryCodeList.size() != 0 || categoryCodeList != null)
				|| (categoryNameList.size() != 0) || categoryNameList != null) {

			if ((categoryCodeList.size() != 0 || categoryCodeList != null)
					&& (categoryNameList.size() == 0 || categoryNameList == null)) {
				message = "Category Code  already exists.";
			} else if ((categoryNameList.size() != 0 || categoryNameList != null)
					&& (categoryCodeList.size() == 0 || categoryCodeList == null)) {
				message = "Category Name already exists.";
			} else if ((categoryCodeList.size() != 0 || categoryCodeList != null)
					&& (categoryNameList.size() != 0 || categoryNameList != null)) {
				message = "Category Code and Category Name already exist.";
			}
		}
		url = "/hms/hms/procurement?method=showCategoryMasterJsp";

		try {
			map = procurementHandlerService.showCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "category";
		title = "Add category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String categoryCode = "";
		String categoryName = "";
		int categoryId = 0;
		Date changedDate = null;
		HttpSession session = request.getSession();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			categoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			categoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			categoryName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", categoryId);
		generalMap.put("categoryCode", categoryCode);
		generalMap.put("name", categoryName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingCategoryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingCategoryNameList.size() == 0) {
			dataUpdated = procurementHandlerService.editCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/procurement?method=showCategoryMasterJsp";
		try {
			map = procurementHandlerService.showCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "category";
		title = "Update category";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int categoryId = 0;
		String message = null;
		String changedTime = "";
		HttpSession session = request.getSession();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		System.out.println(flag);
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			categoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		System.out.println(categoryId);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = procurementHandlerService.deleteCategory(categoryId,generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/procurement?method=showCategoryMasterJsp";
		try {
			map = procurementHandlerService.showCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "category";
		title = "Delete category";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}
	//------------------- SUB Category
	/*

	public ModelAndView searchSubCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String subCategoryCode = null;
		String subCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			subCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			subCategoryName = request.getParameter(SEARCH_NAME);
		}

		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			subCategoryCode = searchField;
			subCategoryName = null;

		} else {
			subCategoryCode = null;
			subCategoryName = searchField;
		}
		map = procurementHandlerService.searchSubCategory(subCategoryCode,subCategoryName);

		jsp = "subCategory";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("subCategoryCode", subCategoryCode);
		map.put("subCategoryName", subCategoryName);
		return new ModelAndView("index", "map", map);
	}


	@SuppressWarnings("unchecked")
	public ModelAndView addSubCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasSubCategory masSubCategory = new MasSubCategory();
		String code="";
		String name="";
		String currentTime="";
		
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
	
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);

		List subCategoryCodeList = new ArrayList();
		List subCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			subCategoryCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			subCategoryNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((subCategoryCodeList.size() == 0 || subCategoryCodeList == null)
				&& (subCategoryNameList.size() == 0 || subCategoryNameList == null)) {
			masSubCategory.setSubCategoryCode(code);
			masSubCategory.setSubCategoryName(name);
			masSubCategory.setStatus("y");

			
			Users users = new Users();
			users.setId(userId);
			masSubCategory.setLastChgBy(users);
			
			masSubCategory.setLastChgDate(currentDate);
			masSubCategory.setLastChgTime(currentTime);
			successfullyAdded = procurementHandlerService.addSubCategory(masSubCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((subCategoryCodeList.size() != 0 || subCategoryCodeList != null)
				|| (subCategoryNameList.size() != 0) || subCategoryNameList != null) {

			if ((subCategoryCodeList.size() != 0 || subCategoryCodeList != null)
					&& (subCategoryNameList.size() == 0 || subCategoryNameList == null)) {
				message = "SubCategory Code  already exists.";
			} else if ((subCategoryNameList.size() != 0 || subCategoryNameList != null)
					&& (subCategoryCodeList.size() == 0 || subCategoryCodeList == null)) {
				message = "SubCategory Name already exists.";
			} else if ((subCategoryCodeList.size() != 0 || subCategoryCodeList != null)
					&& (subCategoryNameList.size() != 0 || subCategoryNameList != null)) {
				message = "SubCategory Code and SubCategory Name already exist.";
			}
		}
		url = "/hms/hms/procurement?method=showSubCategoryMasterJsp";

		try {
			map = procurementHandlerService.showSubCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "subCategory";
		title = "Add subCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editSubCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String subCategoryCode = "";
		String subCategoryName = "";
		int subCategoryId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			subCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			subCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			subCategoryName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", subCategoryId);
		generalMap.put("subCategoryCode", subCategoryCode);
		generalMap.put("name", subCategoryName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingSubCategoryNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingSubCategoryNameList.size() == 0) {
			dataUpdated = procurementHandlerService.editSubCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingSubCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/procurement?method=showSubCategoryMasterJsp";
		try {
			map = procurementHandlerService.showSubCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "subCategory";
		title = "Update subCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteSubCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int subCategoryId = 0;
		String message = null;
		String changedTime = "";
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			subCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = procurementHandlerService.deleteSubCategory(subCategoryId,generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/procurement?method=showSubCategoryMasterJsp";
		try {
			map = procurementHandlerService.showSubCategoryMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "subCategory";
		title = "Delete subCategory";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}*/
	public ModelAndView showPendingListNegotiation(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("QuotationNo")!=null && request.getParameter("QuotationNo")!=""){
			details.put("QuotationNo", request.getParameter("QuotationNo"));
		}
		map=procurementHandlerService.showPendingListNegotiation(details);
	   String jsp = "pendingListForNegotiation";
		jsp += ".jsp";
		title = "Pending List For Negotiation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
	
	
	
	public ModelAndView showTransferOfAssetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showTransferOfAssetJsp();
		String jsp = "transferOfAsset";
		jsp += ".jsp";
		title = "Transfer Of Asset";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showApproveTransferOfAssetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showTransferOfAssetJsp();
		String jsp = "approveTransferOfAsset";
		jsp += ".jsp";
		title = "Approve Transfer Of Asset";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAssetApprovedJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//map = procurementHandlerService.showTransferOfAssetJsp();
		String jsp = "assetApproved";
		jsp += ".jsp";
		title = "Approved Asset";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//========================================================================================================
	   public ModelAndView  submitPoCreationDirect(HttpServletRequest request,
	             HttpServletResponse response) {
	       String userName = "";
	        int deptId = 0;
	        int hospitalId = 0;
	          int userId=0;

	               Map<String, Object> dataMap = new HashMap<String, Object>();
	               session = request.getSession();

	              if (session.getAttribute("userName") != null) {
	               userName = (String) session.getAttribute("userName");
	               }
	              if (session.getAttribute("hospitalId") != null) {
	      			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	      		}
	          if (session.getAttribute("deptId") != null) {
	          deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	           }

	            if (session.getAttribute(RequestConstants.USER_ID) != null) {
	               userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
	                  }
                System.out.println("hospital"+hospitalId);
	             dataMap.put("deptId", deptId);
	             dataMap.put("hospitalId", hospitalId);
	             dataMap.put("userName", userName);
	              dataMap.put(RequestConstants.USER_ID, userId);
                   
	            Box box = HMSUtil.getBox(request);
	            Map<String, Object> map = new HashMap<String, Object>();
	              map=procurementHandlerService.submitPoCreationDirect(box, dataMap);
	             jsp = "mSubmitInfo";
	             jsp = jsp + ".jsp";
	             title = "Po Creation";
	             map.put("contentJsp",jsp);
	             map.put("title", title);
	             return new  ModelAndView("index", "map", map);
	                 }

	public ModelAndView addImmuableAssets(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mes = new HashMap<String, Object>();
		HttpSession session = request.getSession(); 
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		Users users=null; 
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		try {
			if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
					&& !"".equalsIgnoreCase(session.getAttribute(
							RequestConstants.HOSPITAL_ID).toString())) {
				hospitalId = Integer.parseInt(session.getAttribute(
						RequestConstants.HOSPITAL_ID).toString());
			}
			if(session.getAttribute(RequestConstants.USERS)!=null){
				users=(Users)session.getAttribute(RequestConstants.USERS);
			}

			String userHome = getServletContext().getRealPath(""); 
			generalMap.put(RequestConstants.USERS, users);
			generalMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
			generalMap.put("userHome", userHome);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		boolean successfullyAdded = false;
		mes=procurementHandlerService.addImmuableAssets(mrequest, generalMap); 
		if(mes.get("message")!=null){
			successfullyAdded=(Boolean) mes.get("message"); 
		} 
		String message="";
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		} 
		map = procurementHandlerService.showAssetDetailsJsp(generalMap);  
		String jsp = "assetDetails";
		jsp += ".jsp";
		title = "Asset Details for Immovable(Fixed Assets)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		}
	public ModelAndView addMovableAssets(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object>dataMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(); 
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		Users users=null; 
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			
			try {
				mrequest = new MultipartFormDataRequest(request);
				System.out.println("yes This is mrequest");
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 
		try {
			if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null
					&& !"".equalsIgnoreCase(session.getAttribute(
							RequestConstants.HOSPITAL_ID).toString())) {
				hospitalId = Integer.parseInt(session.getAttribute(
						RequestConstants.HOSPITAL_ID).toString());
			}
			if(session.getAttribute(RequestConstants.USERS)!=null){
				users=(Users)session.getAttribute(RequestConstants.USERS);
			}

			String userHome = getServletContext().getRealPath(""); 
			generalMap.put(RequestConstants.USERS, users);
			generalMap.put(RequestConstants.HOSPITAL_ID, hospitalId);
			generalMap.put("userHome", userHome);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean successfullyAdded = false;
		dataMap=procurementHandlerService.addMuableAssets(mrequest, generalMap); 
		map = procurementHandlerService.showAssetDetailsMovableJsp(generalMap);
		System.out.println("saveFlag=="+dataMap.get("message"));
		if(dataMap.get("message")!=null){
			successfullyAdded=Boolean.parseBoolean(dataMap.get("message").toString());
		}
		System.out.println("successfullyAdded=="+successfullyAdded);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		} 
		map = procurementHandlerService.showAssetDetailsMovableJsp(generalMap);
		String jsp = "assetsDetailsMovable";
		jsp += ".jsp";
		title = "Asset Details for Immovable(Fixed Assets)";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView showMarkForAuctionJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.showMarkForAuctionJsp(box);
		String jsp = "markForAuction";
		jsp += ".jsp";
		title = "Mark For Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchAssetsMarkForAuction(HttpServletRequest request,HttpServletResponse response){
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
			}
			box.put("hospitalId", hospitalId);
			map =procurementHandlerService.searchAssetsMarkForAuction(box);
			String jsp = "markForAuction";
			jsp += ".jsp";
			title = "Mark For Auction";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	public ModelAndView submitMarkForAuction(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		int employeeId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("users") != null){
			Users users =(Users)session.getAttribute("users");
			employeeId = users.getEmployee().getId();
			box.put("employeeId", employeeId);
		}
		box.put("hospitalId", hospitalId);
		map =procurementHandlerService.submitMarkForAuction(box);
		boolean flag = true;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			messageTOBeVisibleToTheUser = "Record Saved Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
			map.put("messageType", "failure");
		}
		jsp = "annualIndentMessage";
		url = "/hms/hms/procurement?method=showMarkForAuctionJsp";
		jsp += ".jsp";
		title = "Mark For Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPendingListForAuction(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.searchPendingListForAuction(box);
		jsp = "pendingListForAuction";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAuctionApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.showAuctionApprovalJsp(box);
		jsp = "auctionApproval";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitAuctionApproval(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.submitAuctionApproval(box);
		boolean flag = true;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			messageTOBeVisibleToTheUser = "Record Saved Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
			map.put("messageType", "failure");
		}
		jsp = "annualIndentMessage";
		url = "/hms/hms/procurement?method=showPendingListForAuctionJsp";
		jsp += ".jsp";
		title = "Auction Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingListForAuctionDetailJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.showPendingListForAuctionDetailJsp(box);
		jsp = "pendingListForAuctionDetail";
		jsp = jsp + ".jsp";
		title = "Pending list for Auctiony";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPendingListForAuctionDetail(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.searchPendingListForAuctionDetail(box);
		jsp = "pendingListForAuctionDetail";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitAuctionDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = procurementHandlerService.submitAuctionDetail(box);
		boolean flag = true;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		String messageTOBeVisibleToTheUser = "";
		if (flag) {
			messageTOBeVisibleToTheUser = "Record Saved Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
			map.put("messageType", "failure");
		}
		jsp = "annualIndentMessage";
		url = "/hms/hms/procurement?method=showPendingListForAuctionDetailJsp";
		jsp += ".jsp";
		title = "Auction Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	

public ModelAndView  submitrenewalInsuranceDetails(HttpServletRequest request,
        HttpServletResponse response) {
  String userName = "";
   int deptId = 0;
   int hospitalId = 0;
     int userId=0;

          Map<String, Object> dataMap = new HashMap<String, Object>();
          session = request.getSession();

         if (session.getAttribute("userName") != null) {
          userName = (String) session.getAttribute("userName");
          }
         if (session.getAttribute("hospitalId") != null) {
 			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
 		}
     if (session.getAttribute("deptId") != null) {
     deptId = Integer.parseInt("" + session.getAttribute("deptId"));
      }

       if (session.getAttribute(RequestConstants.USER_ID) != null) {
          userId = (Integer)session.getAttribute((RequestConstants.USER_ID));
             }
         System.out.println("hospital"+hospitalId);
        dataMap.put("deptId", deptId);
        dataMap.put("hospitalId", hospitalId);
        dataMap.put("userName", userName);
         dataMap.put(RequestConstants.USER_ID, userId);
            
       Box box = HMSUtil.getBox(request);
       Map<String, Object> map = new HashMap<String, Object>();
        map=procurementHandlerService.submitrenewalInsuranceDetails(box, dataMap);
        jsp = "mSubmitInfo";
        jsp = jsp + ".jsp";
        title = "Renewal Details";
        map.put("contentJsp",jsp);
        map.put("title", title);
        return new  ModelAndView("index", "map", map);
}
public ModelAndView getMasStoreItemList(HttpServletRequest request,
		HttpServletResponse response) {
	 
	int deptId = 0;
	session = request.getSession(); 
	String itemNameField = "";
	Box box = HMSUtil.getBox(request); 
	int hospitalId = 0; 
	String autoHint = "";  
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
		box.put("deptId", deptId);
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
	}
	if (request.getParameter("requiredField") != null) {
		itemNameField = (request.getParameter("requiredField"));
	}
	if (request.getParameter(itemNameField) != null) {
		autoHint = (request.getParameter(itemNameField));
	}
	box.put("autoHint", autoHint);  
	map = procurementHandlerService.getMasStoreItemList(box);
	map.put("deptId", deptId);
	jsp = "masStoreItemListForAutoComplete";
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView showPhysicalInventoryApprovalListJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	session = request.getSession();
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	}
	box.put("hospitalId", hospitalId);
	map = procurementHandlerService.showPhysicalInventoryApprovalListJsp(box);
	jsp = "physicalInventoryApprovalPendingList";
    jsp = jsp + ".jsp";
    map.put("contentJsp",jsp);
    return new  ModelAndView("index", "map", map);
}
public ModelAndView showPhysicalInventoryApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	session = request.getSession();
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	}
	box.put("hospitalId", hospitalId);
	map = procurementHandlerService.showPhysicalInventoryApprovalJsp(box);
	jsp = "physicalInventoryApproval";
    jsp = jsp + ".jsp";
    map.put("contentJsp",jsp);
    return new  ModelAndView("index", "map", map);
}
public ModelAndView submitPhysicalInventoryApproval(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	session = request.getSession();
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	}
	box.put("hospitalId", hospitalId);
	map = procurementHandlerService.submitPhysicalInventoryApproval(box);
	boolean flag = true;
	if (map.get("flag") != null) {
		flag = (Boolean) map.get("flag");
	}
	String messageTOBeVisibleToTheUser = "";
	if (flag) {
		messageTOBeVisibleToTheUser = "Record Saved Successfully";
	} else {
		messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
		map.put("messageType", "failure");
	}
	jsp = "annualIndentMessage";
	url = "/hms/hms/procurement?method=showPendingListForAuctionJsp";
	jsp += ".jsp";
	title = "Auction Approval";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitInsuranceClaimTracking(HttpServletRequest request,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Box box = HMSUtil.getBox(request);
	int hospitalId = 0;
	session = request.getSession();
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	}
	box.put("hospitalId", hospitalId);
	map = procurementHandlerService.submitInsuranceClaimTracking(box);
	boolean flag = true;
	if (map.get("flag") != null) {
		flag = (Boolean) map.get("flag");
	}
	String messageTOBeVisibleToTheUser = "";
	if (flag) {
		messageTOBeVisibleToTheUser = "Record Saved Successfully";
	} else {
		messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
		map.put("messageType", "failure");
	}
	jsp = "annualIndentMessage";
	url = "/hms/hms/procurement?method=showInsuranceClaimAndTrackingJsp";
	jsp += ".jsp";
	title = "Auction Approval";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showLocalPurchaseItemTracking(HttpServletRequest request,HttpServletResponse response){
	Map<String,Object>map=new HashMap<String,Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
	hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	map=procurementHandlerService.showLocalPurchaseItemTracking(hospitalId);
	String jsp1 = "localPurchaseItemTracking";
	url = "/hms/hms/procurement?method=showLocalPurchaseItemTracking";
	jsp1 += ".jsp";
	title = "Auction Approval";
	map.put("contentJsp", jsp1);
	map.put("title", title);
	map.put("url", url);
	//map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
	return new ModelAndView("index", "map", map);
}
public ModelAndView printForLocalPurchaseItemTracking(HttpServletRequest request,HttpServletResponse response){
	int poId=0;
	if(request.getParameter("poNubner")!=null && !request.getParameter("poNubner").equals("0")){
		poId=Integer.parseInt(request.getParameter("poNubner"));
	}
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
	hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	
	Box box = HMSUtil.getBox(request);
	String pvmsNo="";
	pvmsNo = box.getString("pvmsNo");
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	java.sql.Date fromDate = null;
	java.sql.Date toDate = null;
	int item_id=0;
	String query="";
	String dt1 = (String) box.get(FROM_DATE);
	String dt2 = (String) box.get(TO_DATE);
	try {
		
		if (dt1 != null && !dt1.equals("") && dt2 != null && !dt2.equals("")) {
			
		
		String date4MySQL = formatterOut.format(formatterIn.parse(dt1));
		fromDate = java.sql.Date.valueOf(date4MySQL);
		date4MySQL = formatterOut.format(formatterIn.parse(dt2));
		toDate = java.sql.Date.valueOf(date4MySQL);
		
		query=query+ " and m.grn_date between '"+ fromDate +"' and '"+ toDate +"'"; 
		}
	} catch (Exception e) {
	}
	if (request.getParameter("pvms") != null && !request.getParameter("pvms").equals("")) {
		pvmsNo = request.getParameter("pvms");
		query=query+ " and i.pvms_no='"+pvmsNo+"'";
	}
/*	if (request.getParameter("item_id") != null && ! request.getParameter("item_id").equals("0") && !request.getParameter("item_id").equals("")) {
	
		item_id =Integer.parseInt(request.getParameter("item_id"));
		
		
		query=query+ " and i.item_id="+item_id;
	}*/
	System.out.println(query+"----query");
	
	
	Map<String,Object>map=new HashMap<String,Object>();
	Map<String,Object>parameters=new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = procurementHandlerService.getConnectionForReport();
	parameters.put("poId", poId);
	parameters.put("query", query);
	parameters.put("hospitalId", hospitalId);
	HMSUtil.generateReport("Local_Purchase_Item_Tracking",
			parameters, (Connection) detailsMap.get("con"),
			response, getServletContext());

	return null;
}
public ModelAndView printForLocalPurchaseItemTrackingScreen(HttpServletRequest request,HttpServletResponse response){

	Map<String,Object>map=new HashMap<String,Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
	hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	int poId=0;
	if(request.getParameter("poNubner")!=null && !request.getParameter("poNubner").equals("0")){
		poId=Integer.parseInt(request.getParameter("poNubner"));
	}
	Box box = HMSUtil.getBox(request);
	String pvmsNo="";
	
	int item_id=0;
	String fromDate ="";
	String toDate = "";
	try {
		if(request.getParameter(FROM_DATE)!=null && request.getParameter(FROM_DATE)!=""){
			fromDate=request.getParameter(FROM_DATE);
		
		}
		if(request.getParameter(TO_DATE)!=null && request.getParameter(TO_DATE)!=""){
			toDate=request.getParameter(TO_DATE);
		
		}
	} catch (Exception e) {
	}
	if (request.getParameter("pvms") != null) {
		pvmsNo = request.getParameter("pvms");
	}
	/*if (request.getParameter("item_id") != null && ! request.getParameter("item_id").equals("0") && !request.getParameter("item_id").equals("")) {
		item_id =Integer.parseInt(request.getParameter("item_id"));
	}*/
	box.put("fromDate", fromDate);
	box.put("toDate", toDate);
	box.put("item_id", item_id);
	box.put("pvmsNo", pvmsNo);
	map=procurementHandlerService.printForLocalPurchaseItemTrackingScreen(hospitalId,poId,box);
	String jsp1 = "localPurchaseItemTrackingScreen";
	url = "/hms/hms/procurement?method=showLocalPurchaseItemTracking";
	jsp1 += ".jsp";
	title = "Auction Approval";
	map.put("contentJsp", jsp1);
	map.put("title", title);
	map.put("url", url);
	//map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
	return new ModelAndView("index", "map", map);

}
//=====================pending list for condemnation =================
public ModelAndView showPendingCondemnationJsp(HttpServletRequest request,
		HttpServletResponse response) {
	String userName = "";
	int deptId = 0;
	int hospitalId = 0;
	String fromDate="";
	String toDate="";
	String itemName="";
	String itemCode="";
	int group=0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	session = request.getSession();

	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
	}
	if (session.getAttribute("deptId") != null) {
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	}
	dataMap.put("deptId", deptId);
	dataMap.put("hospitalId", hospitalId);
	dataMap.put("userName", userName);
	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	map = procurementHandlerService.showPendingCondemnationJsp(box, dataMap);
	jsp = "pendingItemsForCondem";
	jsp = jsp + ".jsp";
	title = "Pending items for Local Purchase";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showCondemAuctionJsp(HttpServletRequest request,
		HttpServletResponse response) {
	String userName = "";
	int deptId = 0;
	int hospitalId = 0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	List<Integer> item=new ArrayList<Integer>();
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
	
	if(request.getParameterValues("selectCheckBox")!=null){
		for(int i=0;i<request.getParameterValues("selectCheckBox").length;i++){
			item.add(Integer.parseInt(request.getParameterValues("selectCheckBox")[i]));
		}
		dataMap.put("itemName", item);
	}
	dataMap.put("deptId", deptId);
	dataMap.put("hospitalId", hospitalId);
	dataMap.put("userName", userName);

	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	map = procurementHandlerService.showCondemAuctionJsp(box, dataMap);
	jsp = "condemAuction";
	jsp = jsp + ".jsp";
	title = "Condemnation Auction";
	map.put("contentJsp",jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView getItemListForEquipDetail(
		HttpServletRequest request, HttpServletResponse response) {

	HttpSession session = request.getSession();
	String itemNameField = "";
	int deptId = 0;
	String autoHint = "";
	int counter = 0;
	int hospitalId = 0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	try {
		
		if (request.getParameter("requiredField") != null) {
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null) {
			autoHint = (request.getParameter(itemNameField));
		}
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);

		map = procurementHandlerService.getItemListForEquipDetail(dataMap);
	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "responseForEquipmentDetail";
	title = "BIN Card Reports";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView getFromDateAndToDate(HttpServletRequest request, HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	String fromDate="";
	String toDate="";
	int hospitalId = 0;
	session = request.getSession();
	try {
		
	if(request.getParameter(FROM_DATE)!=null && request.getParameter(FROM_DATE)!=""){
		fromDate=request.getParameter(FROM_DATE);
	
	}
	if(request.getParameter(TO_DATE)!=null && request.getParameter(TO_DATE)!=""){
		toDate=request.getParameter(TO_DATE);
	
	}

	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
	}

    detailsMap.put("fromDate", fromDate);
    detailsMap.put("toDate", toDate);
		
		detailsMap.put("hospitalId", hospitalId);
	
		
		map = procurementHandlerService.getFromDateAndToDate(detailsMap);
	
		
		/*else{
		map=procurementHandlerService.showLocalPurchaseItemTracking(hospitalId);
	
		}*/
		
		
		jsp = "responseFromDateToDateList";
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return new ModelAndView(jsp, "map", map);

}

}
