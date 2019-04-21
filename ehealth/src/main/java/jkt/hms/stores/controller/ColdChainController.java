package jkt.hms.stores.controller;


import static jkt.hms.util.RequestConstants.BATCH_ID;
import static jkt.hms.util.RequestConstants.NE_GRN_JSP;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.stores.handler.ColdChainHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ColdChainController extends MultiActionController {
	ColdChainHandlerService coldChainHandlerService = null;

	public ColdChainHandlerService getColdChainHandlerService() {
		return coldChainHandlerService;
	}

	public void setColdChainHandlerService(
			ColdChainHandlerService coldChainHandlerService) {
		this.coldChainHandlerService = coldChainHandlerService;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	String jsp="";
	String title="";
	public ModelAndView showPendingListForRefrigeratorAllocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int userId = 0;
		int hospitalId = 0;
		int deptId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		

		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		
		
		map = coldChainHandlerService.showPendingListForRefrigeratorAllocation(box);
		jsp = "pendingListForRefrigeratorAllocation.jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchForRefrigeratorAllocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
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

		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.searchForRefrigeratorAllocation(box);
		jsp = "pendingListForRefrigeratorAllocation.jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showRefrigeratorColdRoomAllocationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = coldChainHandlerService.showRefrigeratorColdRoomAllocationJsp(box);
		jsp = "refrigeratorColdRoomAllocation";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitColdRoomAllocation(HttpServletRequest request,HttpServletResponse response) {
		int hospitalId = 0;
		int userId = 0;
		int deptId = 0;
		String url = "";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.submitColdRoomAllocation(box);
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
		url = "/hms/hms/coldChain?method=showPendingListForRefrigeratorAllocation";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showTemperatureMonitoringJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int userId = 0;
		int hospitalId = 0;
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		box.put("userId", userId);
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);

		
		map = coldChainHandlerService.showTemperatureMonitoringJsp(box);
		jsp = "temperatureMonitoring";
		jsp = jsp + ".jsp";
		title = "Temperature Monitoring";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitTemperatureMonitoring(HttpServletRequest request,HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int userId = 0;
		int hospitalId = 0;
		int deptId = 0;
		String url = "";
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		
		map = coldChainHandlerService.submitTemperatureMonitoring(box);
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
		url = "/hms/hms/coldChain?method=showTemperatureMonitoringJsp";
		jsp = jsp + ".jsp";
		title = "Temperature Monitoring";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showTemperatureValidationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int hospitalId = 0;
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		box.put("userId", userId);
		map = coldChainHandlerService.showTemperatureValidationJsp(box);
		jsp = "temperatureTracker";
		jsp = jsp + ".jsp";
		title = "Temperature Tracker";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("monitorongMId", box.getInt("monitoromgMId"));
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTransferPendingList(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();	
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		map = coldChainHandlerService.showTransferPendingList(box);
		jsp = "pendingListForTransfer";
		jsp = jsp + ".jsp";
		title = "Temperature Tracker";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	/*public ModelAndView showReAllocationOfItemsJsp(HttpServletRequest request,HttpServletResponse response) {
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

		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
	//	map = coldChainHandlerService.showTemperatureTrackerJsp(box, dataMap);
		jsp = "reAllocationOfItems";
		jsp = jsp + ".jsp";
		title = "Temperature Tracker";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	*/
	public ModelAndView showRefrigeratorAllocationPopup(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.showRefrigeratorAllocationPopup(box);
		jsp = "refrigeratorAllocationPopup";
		map.put("contentJsp", jsp);
		//map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView showPendingListForPotencyCheck(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt(session.getAttribute("deptId").toString());
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = coldChainHandlerService.showPendingListForPotencyCheck(box);
		jsp = "pendingListForPotencyCheck";
		jsp = jsp + ".jsp";
		title = "Temperature Tracker";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitTemperatureValidation(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int userId = 0;
		String url = "";
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}
		box.put("hospitalId", hospitalId);
		box.put("userId", userId);
		map = coldChainHandlerService.submitTemperatureValidation(box);
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
		url = "/hms/hms/coldChain?method=showTemperatureValidationJsp";
		jsp = jsp + ".jsp";
		title = "Temperature Tracker";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRefrigeratorColdRoomReAllocationJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.showRefrigeratorColdRoomReAllocationJsp(box);
		jsp = "refrigeratorColdRoomReAllocation";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitColdRoomReAllocation(HttpServletRequest request,HttpServletResponse response) {
		int hospitalId = 0;
		int userId = 0;
		int deptId = 0;
		String url ="";
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.submitColdRoomReAllocation(box);
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
		url = "/hms/hms/coldChain?method=showTransferPendingList";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showDashBoardOfTemperatureMonitoringJsp(HttpServletRequest request,HttpServletResponse response) {
		int hospitalId = 0;
		int userId = 0;
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.showDashBoardOfTemperatureMonitoringJsp(box);
		jsp = "dashBoardOfTemperatureMonitoring";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchForTemperatureMonitoringDashBord(HttpServletRequest request,HttpServletResponse response) {
		int hospitalId = 0;
		int userId = 0;
		int deptId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt(""+ session.getAttribute("userId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
		}
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);
		map = coldChainHandlerService.searchForTemperatureMonitoringDashBord(box);
		jsp = "dashBoardOfTemperatureMonitoring";
		jsp = jsp + ".jsp";
		title = "Cold Chain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public void getRefrigeratorTemperature(HttpServletRequest request,HttpServletResponse response) {
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int serialId = 0;
		if(request.getParameter("serialId") != null){
			serialId = Integer.parseInt(request.getParameter("serialId"));
			box.put("serialId", serialId);
		}
		
		
		map = coldChainHandlerService.getRefrigeratorTemperature(box);
		List<HesEquipmentMaster>eqipmentMasterList = new ArrayList<HesEquipmentMaster>();
		if(map.get("eqipmentMasterList") != null){
			eqipmentMasterList = (List<HesEquipmentMaster>)map.get("eqipmentMasterList");
		}
		BigDecimal maxTemperature = new BigDecimal(0);
		BigDecimal minTemperature = new BigDecimal(0);
		if(eqipmentMasterList.size()>0){
			HesEquipmentMaster hesEquipmentMaster = eqipmentMasterList.get(0);
			if(hesEquipmentMaster.getItem() != null){
				maxTemperature = hesEquipmentMaster.getItem().getTempratureMax();
			}
			if(hesEquipmentMaster.getItem() != null){
				minTemperature = hesEquipmentMaster.getItem().getTempratureMin();
			}
		
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<item>");
			sb.append("<maxTemperature>" + maxTemperature + "</maxTemperature>");
			sb.append("<minTemperature>" + minTemperature + "</minTemperature>");
			sb.append("</item>");
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
	}


@SuppressWarnings("unchecked")
public void getRefrigeratorSerialNo(HttpServletRequest request,HttpServletResponse response) {
	session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int refId = 0;
	int hospitalId = 0;
	if(request.getParameter("refId") != null){
		refId = Integer.parseInt(request.getParameter("refId"));
		box.put("refId", refId);
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);
	}
	
	map = coldChainHandlerService.getRefrigeratorSerialNo(box);
	List<StoreItemBatchStock>itemBatchStockList = new ArrayList<StoreItemBatchStock>();
	List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
	if(map.get("itemBatchStockList") != null){
		itemBatchStockList = (List<StoreItemBatchStock>)map.get("itemBatchStockList");
	}
	if (map.get("itemList") != null) {
		itemList = (List) map.get("itemList");
	}
	StringBuffer sb = new StringBuffer();
	try {
		
		sb.append("<item>");
	for (MasStoreItem masStoreItem : itemList) {
		if(itemBatchStockList.size()>0){
			sb.append("<batchs>");
			for (StoreItemBatchStock  batch : itemBatchStockList) {
				sb.append("<batch>");
				sb.append("<batchName>" + batch.getBatchNo()
						+ "</batchName>");
				sb.append("</batch>");
			}
			sb.append("</batchs>");

		}/*else{
			
			sb.append("<msg>" + "Item Batch Not Available" + "</msg>");
		}*/
	
	}
	sb.append("</item>");

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

}
