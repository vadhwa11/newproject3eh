package jkt.hrms.noticeBoard.controller;

import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.DISPLAY_CHECK;
import static jkt.hrms.util.HrmsRequestConstants.HR_NOTICEBOARD_JSP;
import static jkt.hrms.util.HrmsRequestConstants.NOTICE_DATA;
import static jkt.hrms.util.HrmsRequestConstants.USERS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.BlReceiptHeader;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.masters.business.HrNoticeBoardData;
import jkt.hrms.noticeBoard.handler.NoticeBoardHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class NoticeBoardController extends MultiActionController {

	private NoticeBoardHandlerService noticeBoardHandlerService = null;

	@SuppressWarnings("unchecked")
	public ModelAndView addNotice(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String message = "";
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List<HrNoticeBoardData> hrNoticeBoardList = new ArrayList<HrNoticeBoardData>();
		List<HrNoticeBoardData> noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();

		Map<String, Object> map = new HashMap<String, Object>();

		// String displayYOrN ="";
		@SuppressWarnings("unused")
		// HrNoticeBoardData hrNoticeBoardData = new HrNoticeBoardData();
		// if(request.getParameter(DISPLAY_CHECK) != null){
		// displayYOrN = request.getParameter(DISPLAY_CHECK);
		// hrNoticeBoardData.setDisplayOnIndex(displayYOrN);
		//
		// }
		// else {
		// displayYOrN = "n";
		// hrNoticeBoardData.setDisplayOnIndex(displayYOrN);
		// }
		String noticeType = "";

		Map requestMap = new HashMap();

		if (request.getParameter("noticeType") != null
				&& !request.getParameter("noticeType").trim().equals("")) {
			noticeType = request.getParameter("noticeType");
			requestMap.put("noticeType", noticeType);
		}
		String msgToDisplay = "";
		if (request.getParameter("msgToDisplay") != null
				&& !request.getParameter("msgToDisplay").trim().equals("")) {
			msgToDisplay = request.getParameter("msgToDisplay");
			requestMap.put("msgToDisplay", msgToDisplay);
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			requestMap.put("lastChgBy", lastchangeBy);
		}
		String changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = request.getParameter(CHANGED_DATE);
			requestMap.put("lastChgDate", changedDate);

		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			requestMap.put("lastChgTime", changedTime);
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			requestMap.put("hospitalId", hospitalId);
		}
		message = noticeBoardHandlerService.addNotice(requestMap);
		hrNoticeBoardList = noticeBoardHandlerService.getNoticeBoardList();

		map.put("hrNoticeBoardList", hrNoticeBoardList);
		map.put("noticeBoardForEdit", noticeBoardForEdit);

		String jsp = HR_NOTICEBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showNotice(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		List<HrNoticeBoardData> noticeToDisplayList = new ArrayList<HrNoticeBoardData>();

		List<MasEmployee> userList = null;
		Map<String, Object> map = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		String noticeType = "";
		if (request.getParameter("noticeType") != null) {
			noticeType = (String) request.getParameter("noticeType");
		}
		String viewOnly = "";
		if (request.getParameter("viewOnly") != null) {
			viewOnly = (String) request.getParameter("viewOnly");
		}
		noticeToDisplayList = noticeBoardHandlerService
				.getNoticeToDisplay(noticeType);

		if (noticeToDisplayList != null && noticeToDisplayList.size() > 0) {
			map.put("noticeToDisplayList", noticeToDisplayList);
		}
		String jsp = "";
		if (viewOnly != null && viewOnly.equalsIgnoreCase("y")) {
			jsp = "hr_NoticeToEdit";
		} else {
			jsp = "hr_NoticeToDisplay";
		}
		// jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put(TITLE,"Apply Leave" );
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showNoticeBoard(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		List<HrNoticeBoardData> noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();

		List<MasEmployee> userList = null;
		Map<String, Object> map = new HashMap<String, Object>();

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();

		int noticeId = 0;
		if (request.getParameter("noticeId") != null) {
			noticeId = Integer.parseInt(request.getParameter("noticeId"));
			noticeBoardForEdit = noticeBoardHandlerService
					.getNoticeBoardDataListForId(noticeId);
		}

		List<HrNoticeBoardData> hrNoticeBoardList = noticeBoardHandlerService
				.getNoticeBoardList();

		map.put("userList", userList);

		map.put("hrNoticeBoardList", hrNoticeBoardList);
		map.put("noticeBoardForEdit", noticeBoardForEdit);

		// map.put(MAIN,APPLY_LEAVES_JSP);

		String jsp = HR_NOTICEBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		// map.put(TITLE,"Apply Leave" );
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView updateDisplayStatus(HttpServletRequest
	 * request,HttpServletResponse response) { HttpSession session =
	 * request.getSession(false);
	 * 
	 * if (session == null || session.getAttribute(USERS) == null) { return new
	 * ModelAndView("index"); } Map<String,Object> map=new
	 * HashMap<String,Object>(); List<HrNoticeBoardData> noticeBoardForEdit =
	 * new ArrayList<HrNoticeBoardData>(); List<HrNoticeBoardData>
	 * hrNoticeBoardList =new ArrayList<HrNoticeBoardData>();
	 * 
	 * String displayStatus[]=request.getParameterValues("checkbox");
	 * 
	 * noticeBoardHandlerService.updateDisplayStatus(displayStatus);
	 * 
	 * hrNoticeBoardList = noticeBoardHandlerService.getNoticeBoardList();
	 * 
	 * 
	 * map.put("hrNoticeBoardList", hrNoticeBoardList);
	 * map.put("noticeBoardForEdit", noticeBoardForEdit);
	 * 
	 * String jsp = HR_NOTICEBOARD_JSP; jsp += ".jsp"; map.put("contentJsp",
	 * jsp);
	 * 
	 * return new ModelAndView("index","map",map); }
	 */

	public ModelAndView deleteMany(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrNoticeBoardData> noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();
		List<HrNoticeBoardData> hrNoticeBoardList = new ArrayList<HrNoticeBoardData>();

		String deleteNotices[] = request.getParameterValues("checkbox");

		noticeBoardHandlerService.deleteMany(deleteNotices);

		hrNoticeBoardList = noticeBoardHandlerService.getNoticeBoardList();

		map.put("hrNoticeBoardList", hrNoticeBoardList);
		map.put("noticeBoardForEdit", noticeBoardForEdit);

		String jsp = HR_NOTICEBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateNotice(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrNoticeBoardData> noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();
		List<HrNoticeBoardData> hrNoticeBoardList = new ArrayList<HrNoticeBoardData>();
		int noticeId = 0;

		if (request.getParameter("noticeId") != null
				&& !request.getParameter("noticeId").trim().equals("")) {
			noticeId = Integer.parseInt(request.getParameter("noticeId"));
			noticeBoardForEdit = noticeBoardHandlerService
					.getNoticeBoardDataListForId(noticeId);
		}

		if (noticeBoardForEdit.size() > 0) {
			HrNoticeBoardData hrNoticeBoardData = noticeBoardForEdit.get(0);
			String displayYOrN = "";

			if (request.getParameter(DISPLAY_CHECK) != null) {
				displayYOrN = request.getParameter(DISPLAY_CHECK);
				hrNoticeBoardData.setDisplayOnIndex(displayYOrN);

			} else {
				displayYOrN = "n";
				hrNoticeBoardData.setDisplayOnIndex(displayYOrN);
			}

			if (request.getParameter(NOTICE_DATA) != null
					&& !request.getParameter(NOTICE_DATA).trim().equals("")) {
				hrNoticeBoardData.setNoticeData(request
						.getParameter(NOTICE_DATA));
			}

			String lastchangeBy = "";
			if (request.getParameter(CHANGED_BY) != null) {
				lastchangeBy = request.getParameter(CHANGED_BY);
				hrNoticeBoardData.setLastChgBy(lastchangeBy);
			}
			Date changedDate = null;
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				changedDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(CHANGED_DATE));
				hrNoticeBoardData.setLastChgDate(changedDate);
				hrNoticeBoardData.setEntryDate(changedDate);
			}

			String changedTime = "";
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				changedTime = request.getParameter(CHANGED_TIME);
				hrNoticeBoardData.setLastChgTime(changedTime);
			}

			noticeBoardHandlerService.updateNoticeBoard(hrNoticeBoardData);
		}

		noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();

		hrNoticeBoardList = noticeBoardHandlerService.getNoticeBoardList();

		map.put("hrNoticeBoardList", hrNoticeBoardList);
		map.put("noticeBoardForEdit", noticeBoardForEdit);

		String jsp = HR_NOTICEBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteNotice(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		List<HrNoticeBoardData> noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();
		List<HrNoticeBoardData> hrNoticeBoardList = new ArrayList<HrNoticeBoardData>();
		int noticeId = 0;

		if (request.getParameter("noticeId") != null
				&& !request.getParameter("noticeId").trim().equals("")) {
			noticeId = Integer.parseInt(request.getParameter("noticeId"));
			noticeBoardForEdit = noticeBoardHandlerService
					.getNoticeBoardDataListForId(noticeId);
		}

		if (noticeBoardForEdit.size() > 0) {
			HrNoticeBoardData hrNoticeBoardData = noticeBoardForEdit.get(0);

			hrNoticeBoardData.setStatus("n");
			noticeBoardHandlerService.updateNoticeBoard(hrNoticeBoardData);
		}

		noticeBoardForEdit = new ArrayList<HrNoticeBoardData>();

		hrNoticeBoardList = noticeBoardHandlerService.getNoticeBoardList();

		map.put("hrNoticeBoardList", hrNoticeBoardList);
		map.put("noticeBoardForEdit", noticeBoardForEdit);

		String jsp = HR_NOTICEBOARD_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public NoticeBoardHandlerService getNoticeBoardHandlerService() {
		return noticeBoardHandlerService;
	}

	public void setNoticeBoardHandlerService(
			NoticeBoardHandlerService noticeBoardHandlerService) {
		this.noticeBoardHandlerService = noticeBoardHandlerService;
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showLeaveDetailsOnDashboard(HttpServletRequest request,
			HttpServletResponse response) {
		String ip = "";
		// Properties prop = new Properties();
		try {
			URL url = Thread.currentThread().getContextClassLoader()
					.getResource("ipAddress.properties");
			Properties p = new Properties();
			p.load(new FileInputStream(new File(url.getFile())));
			ip = (String) p.get("address");

		} catch (Exception e) {
			// TODO: handle exception
		}
		HttpSession session = request.getSession(false);
		Map map = new HashMap();
		String jsp = "";
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(USERS);
		int userId = user.getId();
		MasEmployee employee = user.getEmployee();
		int uid = employee.getId();
		String tab = "";
		if (request.getParameter("tab") != null) {
			tab = request.getParameter("tab");
		}
		if (tab != null && tab.equalsIgnoreCase("leave")) {
			map = noticeBoardHandlerService.showLeaveDetailsOnDashboard(uid);
			String url = "/hms/hrms/leave?method=showWaitingLeaves";
			map.put("url", url);
			jsp = "hr_userReqForNoticeBoard";
		} else if (tab != null && tab.equalsIgnoreCase("recruitment")) {
			map = noticeBoardHandlerService
					.showRecruitmentDetailsOnDashboard(uid);

			jsp = "hr_userReqForNoticeBoard";

		} else if (tab != null && tab.equalsIgnoreCase("etravel")) {
			map = noticeBoardHandlerService.showEtravelDetailsOnDashboard(uid);
			String url = "http://" + ip
					+ "/PTTSClinirx/Shared/frmHomepage.aspx?UserID=" + userId
					+ "&Opt=Etravel";
			map.put("url", url);
			jsp = "hr_userReqForNoticeBoard";

		} else if (tab != null && tab.equalsIgnoreCase("timeSheet")) {
			map = noticeBoardHandlerService
					.showtimeSheetDetailsOnDashboard(uid);
			String url = "/hms/hrms/timeSheet?method=showTimeSheetApprovalJsp";
			map.put("url", url);
			jsp = "hr_userReqForNoticeBoard";

		} else if (tab != null && tab.equalsIgnoreCase("dcf")) {
			map = noticeBoardHandlerService.showDCFDetailsOnDashboard(uid);
			String url = "http://" + ip
					+ "/PTTSClinirx/Shared/frmHomepage.aspx?UserID=" + userId
					+ "&Opt=ProjectTracking";
			map.put("url", url);
			jsp = "hr_userReqForNoticeBoard";

		} else if (tab != null && tab.equalsIgnoreCase("sqvisit")) {
			// map=
			// noticeBoardHandlerService.showSqVisitDetailsOnDashboard(uid);
			jsp = "hr_userReqForNoticeBoard";

		}

		// jsp = "hr_userReqForNoticeBoard";
		// jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showMrdBillingDetailsOnDashboard(
			HttpServletRequest request, HttpServletResponse response) {
		Map map = new HashMap();
		String jsp = "";

		Box box = HMSUtil.getBox(request);
		String date = "";
		String time = "";
		String tab = "";
		tab = box.getString("tab");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		if (!tab.equals("") && tab.equalsIgnoreCase("mrd")) {
			map = noticeBoardHandlerService.getMrdDetailsForDashboard(date);
		} else if (tab != null && tab.equalsIgnoreCase("billing")) {
			map = noticeBoardHandlerService.getBillingDetailsForDashboard();

		} else if (tab != null && tab.equalsIgnoreCase("pharmacy")) {
			map = noticeBoardHandlerService.getPharmacyDetailsForDashboard();

		} else if (tab != null && tab.equalsIgnoreCase("compbill")) {
			map = noticeBoardHandlerService.getCompanyBillDetailsForDashboard();

		}
		map.put("tab", tab);
		xmlForGraph(tab);
		jsp = "responseForNoticeBoardTab";
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void xmlForGraph(String tab) {
		Map<String, Object> map = new HashMap<String, Object>();
		String date = "";
		String time = "";

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		String ENCODING = "ISO-8859-1";
		if (!tab.equals("") && tab.equalsIgnoreCase("mrd")) {
			map = noticeBoardHandlerService.getMrdDetailsForDashboard(date);
			Integer totalReg = 0;
			Integer totalVisit = 0;
			Integer totalOP = 0;
			Integer totalAdm = 0;
			if (map.get("newRegistrations") != null) {
				totalReg = (Integer) map.get("newRegistrations");
			}
			if (map.get("newVisits") != null) {
				totalVisit = (Integer) map.get("newVisits");
			}
			if (map.get("newAdmission") != null) {
				totalAdm = (Integer) map.get("newAdmission");
			}
			totalOP = totalReg + totalVisit;

			try {
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(getServletContext().getRealPath(
								"/jsp/chart/amcolumn_data.xml")));
				out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
						+ "\"?>");
				out.write("<chart>");
				out.write("<series>");
				out.write("<value xid='0'>New Registration</value>");
				out.write("<value xid='1'>Repeat Visit</value>");
				out.write("<value xid='2'>Total OP</value>");
				out.write("<value xid='3'>Admission</value>");
				out.write("</series>");
				out.write("<graphs>");
				out.write("<graph gid='1'>");
				out.write("<value xid='0' color='FF0F00'>" + totalReg
						+ "</value>");
				out.write("<value xid='1' color='FF6600'>" + totalVisit
						+ "</value>");
				out.write("<value xid='2' color='FF9E01'>" + totalOP
						+ "</value>");
				out.write("<value xid='3' color='FCD202'>" + totalAdm
						+ "</value>");
				out.write("</graph>");
				out.write("</graphs>");
				out.write("</chart>");
				out.close();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tab != null && tab.equalsIgnoreCase("billing")) {
			map = noticeBoardHandlerService.getBillingDetailsForDashboard();
			List<BlReceiptHeader> receiptList = new ArrayList<BlReceiptHeader>();
			List<BigDecimal> onAccList = new ArrayList<BigDecimal>();
			List<BigDecimal> finalSettlementList = new ArrayList<BigDecimal>();

			if (map.get("receiptList") != null) {
				receiptList = (List<BlReceiptHeader>) map.get("receiptList");
			}
			if (map.get("onAccList") != null) {
				onAccList = (List<BigDecimal>) map.get("onAccList");
			}
			if (map.get("finalSettlementList") != null) {
				finalSettlementList = (List<BigDecimal>) map
						.get("finalSettlementList");
			}
			BigDecimal totalServAmt = new BigDecimal(0.0);
			BigDecimal totalDispAmt = new BigDecimal(0.00);
			BigDecimal totalAdvAmt = new BigDecimal(0.00);
			BigDecimal totalFinalStAmt = new BigDecimal(0.00);
			BigDecimal totalOnAccAmt = new BigDecimal(0.00);

			if (receiptList.size() > 0) {
				for (BlReceiptHeader receiptHeader : receiptList) {
					if (receiptHeader.getReceiptType().equals("opb")
							|| receiptHeader.getReceiptType().equals("chs")) {
						totalServAmt = totalServAmt.add(receiptHeader
								.getAmount());
					}
					if (receiptHeader.getReceiptType().equals("bld")) {
						totalDispAmt = totalDispAmt.add(receiptHeader
								.getAmount());
					}
					if (receiptHeader.getReceiptType().equals("adv")) {
						totalAdvAmt = totalAdvAmt
								.add(receiptHeader.getAmount());
					}
					/*
					 * if(receiptHeader.getReceiptType().equals("fs")){
					 * totalFinalStAmt =
					 * totalFinalStAmt.add(receiptHeader.getAmount()); }
					 * 
					 * if(receiptHeader.getOpBillHeader() != null){
					 * if(receiptHeader.getOpBillHeader().getOutstanding() !=
					 * null) totalOnAccAmt =
					 * totalOnAccAmt.add(receiptHeader.getOpBillHeader
					 * ().getOutstanding()); }
					 * if(receiptHeader.getDispensingHeader() != null){
					 * if(receiptHeader.getDispensingHeader().getOutstanding()
					 * != null) totalOnAccAmt =
					 * totalOnAccAmt.add(receiptHeader.getDispensingHeader
					 * ().getOutstanding()); }
					 * if(receiptHeader.getChargeSlipMain() != null){
					 * if(receiptHeader.getChargeSlipMain().getOsAmt() != null)
					 * totalOnAccAmt =
					 * totalOnAccAmt.add(receiptHeader.getChargeSlipMain
					 * ().getOsAmt()); }
					 */
				}

				if (finalSettlementList.size() > 0
						&& finalSettlementList != null) {
					if (finalSettlementList.get(0) != null) {
						totalFinalStAmt = (BigDecimal) finalSettlementList
								.get(0);
					}
				}
				if (onAccList.size() > 0 && onAccList != null) {
					if (onAccList.get(0) != null) {
						totalOnAccAmt = (BigDecimal) onAccList.get(0);
					}
				}
			}

			try {
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(getServletContext().getRealPath(
								"/jsp/chart/amcolumn_billing_data.xml")));
				out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
						+ "\"?>");
				out.write("<chart>");
				out.write("<series>");
				out.write("<value xid='0'>OP Servicing Total</value>");
				out.write("<value xid='1'>OP Dispensing Total</value>");
				out.write("<value xid='2'>Advance</value>");
				out.write("<value xid='3'>Final Settlement</value>");
				out.write("<value xid='4'>On Account</value>");
				out.write("</series>");
				out.write("<graphs>");
				out.write("<graph gid='1'>");
				out.write("<value xid='0' color='FF0F00'>" + totalServAmt
						+ "</value>");
				out.write("<value xid='1' color='FF6600'>" + totalDispAmt
						+ "</value>");
				out.write("<value xid='2' color='FF9E01'>" + totalAdvAmt
						+ "</value>");
				out.write("<value xid='3' color='FCD202'>" + totalFinalStAmt
						+ "</value>");
				out.write("<value xid='4' color='FCD202'>" + totalOnAccAmt
						+ "</value>");
				out.write("</graph>");
				out.write("</graphs>");
				out.write("</chart>");
				out.close();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tab != null && tab.equalsIgnoreCase("compbill")) {
			map = noticeBoardHandlerService.getCompanyBillDetailsForDashboard();
			List<BigDecimal> compBillList = new ArrayList<BigDecimal>();
			List<Object[]> patientTypeBillList = new ArrayList<Object[]>();
			if (map.get("compBillList") != null) {
				compBillList = (List<BigDecimal>) map.get("compBillList");
			}
			if (map.get("patientTypeBillList") != null) {
				patientTypeBillList = (List<Object[]>) map
						.get("patientTypeBillList");
			}
			BigDecimal compBillAmount = new BigDecimal(0.00);
			BigDecimal stfBillAmount = new BigDecimal(0.00);
			BigDecimal stfDepBillAmount = new BigDecimal(0.00);
			BigDecimal retBillAmount = new BigDecimal(0.00);

			if (compBillList.size() > 0) {
				if (compBillList.get(0) != null) {
					compBillAmount = (BigDecimal) compBillList.get(0);
				}
			}

			if (patientTypeBillList.size() > 0) {
				for (Object[] obj : patientTypeBillList) {
					if (obj[1] != null) {
						if (obj[1].equals("STF")) {
							stfBillAmount = (BigDecimal) obj[0];
						}
						if (obj[1].equals("DEP")) {
							stfDepBillAmount = (BigDecimal) obj[0];
						}
						if (obj[1].equals("RET")) {
							retBillAmount = (BigDecimal) obj[0];
						}
					}
				}
			}

			try {
				OutputStreamWriter out = new OutputStreamWriter(
						new FileOutputStream(getServletContext().getRealPath(
								"/jsp/chart/amcolumn_comp_billing_data.xml")));
				out.write("<?xml version=\"1.0\" encoding=\"" + ENCODING
						+ "\"?>");
				out.write("<chart>");
				out.write("<series>");
				out.write("<value xid='0'>Company Billing</value>");
				out.write("<value xid='1'>Staff Billing</value>");
				out.write("<value xid='2'>Staff Depenedent Billing</value>");
				out.write("<value xid='3'>Retired Billing</value>");
				out.write("</series>");
				out.write("<graphs>");
				out.write("<graph gid='1'>");

				out.write("<value xid='0' color='FF0F00'>" + compBillAmount
						+ "</value>");
				out.write("<value xid='1' color='FF6600'>" + stfBillAmount
						+ "</value>");
				out.write("<value xid='2' color='FF9E01'>" + stfDepBillAmount
						+ "</value>");
				out.write("<value xid='3' color='FCD202'>" + retBillAmount
						+ "</value>");

				out.write("</graph>");
				out.write("</graphs>");
				out.write("</chart>");
				out.close();
			} catch (RuntimeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tab != null && tab.equalsIgnoreCase("pharmacy")) {
			/*
			 * map= noticeBoardHandlerService.getPharmacyDetailsForDashboard();
			 * List<Integer> pendingGrnList = new ArrayList<Integer>();
			 * List<Integer> pendingPOList = new ArrayList<Integer>();
			 * if(map.get("pendingGrnList") != null){ pendingGrnList =
			 * (List<Integer>)map.get("pendingGrnList"); }
			 * if(map.get("pendingPOList") != null){ pendingPOList =
			 * (List<Integer>)map.get("pendingPOList"); }
			 */

		}

	}
}
