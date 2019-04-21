package jkt.hms.sms.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;

import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.COUNTRY_JSP;
import static jkt.hms.util.RequestConstants.CURRENCY_ID;
import static jkt.hms.util.RequestConstants.GROUP_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasBulkDetail;
import jkt.hms.masters.business.MasBulkMain;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.sms.handler.SmsHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;

import org.hibernate.Session;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class SmsController extends MultiActionController{
SmsHandlerService smsHandlerService=null;

public SmsHandlerService getSmsHandlerService() {
	return smsHandlerService;
}

public void setSmsHandlerService(SmsHandlerService smsHandlerService) {
	this.smsHandlerService = smsHandlerService;
}
CommonMasterHandlerService commonMasterHandlerService = null;
public CommonMasterHandlerService getCommonMasterHandlerService() {
	return commonMasterHandlerService;
}

public void setCommonMasterHandlerService(
		CommonMasterHandlerService commonMasterHandlerService) {
	this.commonMasterHandlerService = commonMasterHandlerService;
}
String jsp="";
String messsageForDisplay="";
String message="";
String url="";
String title="";
String code="";
String name="";
String currentTime="";
//String po
public ModelAndView showSendonetoOneSmsJsp(HttpServletRequest request,
		HttpServletResponse response) {
	//
	System.out.println("hi in controller");
	Map<String, Object> map = new HashMap<String, Object>();
	map=smsHandlerService.showSendonetoOneSmsJsp();
	String jsp = "oneToOne.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView submitOneToOneService(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	String  mobileNo="";
	String messageToBeSent="";
	if(request.getParameter("mobileNo")!=null){
		mobileNo=(request.getParameter("mobileNo"));
	}
	if(request.getParameter("message")!=null){
		messageToBeSent=(request.getParameter("message"));
	}
	OneToOne oto=new OneToOne();
	oto.setMobileNo(""+mobileNo);
	oto.setMessage(messageToBeSent);
	oto.setSentDate(new Date());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	oto.setSentTime(time);
	oto.setStatus("U");
	oto.setType("T");
	MasHospital mh=new MasHospital();
	mh.setId(hospitalId);
	oto.setHospital(mh);
	
	boolean saved=false;
	saved=smsHandlerService.saveOneToOne(oto);
	System.out.println("saved----->"+saved);
	if(saved==true){
		messsageForDisplay="SMS Sent Succesfully to"+mobileNo;		
	}
	System.out.println("messsageForDisplay--->"+messsageForDisplay);
	String jsp = "oneToOne.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	map.put("messsageForDisplay",messsageForDisplay);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showSendBulkSmsJsp(HttpServletRequest request,
		HttpServletResponse response) {
	System.out.println("hi in controller");
	Map<String, Object> map = new HashMap<String, Object>();
	map=smsHandlerService.showSendBulkSmsJsp();
	String jsp = "bulkSms.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView updateBulkDetails(HttpServletRequest request,
		HttpServletResponse response) {
	//System.out.println("hi in controller");
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	String priority = "";
	@SuppressWarnings("unused")
	String message = "";
	String repeat = "n";
	String groupName = "-";
	String date = "";
	String time = "";
	String type="";
	String repeat_frequestuency = "";
	String repeat_time = "";
	String repeat_day_of_month = "";
	String repeat_week_day = "";
	String repeat_year = "";
	Box box=HMSUtil.getBox(request);
	int hiddenValue = 0;
	int mainId = 0;
	if (request.getParameter("mainId") != null) {
		mainId = Integer.parseInt("" + request.getParameter("mainId"));
	}
	if (request.getParameter("hiddenValue") != null) {
		hiddenValue = Integer.parseInt(""
				+ request.getParameter("hiddenValue"));
	}
	if(request.getParameter("type")!=null){
		type=request.getParameter("type");
	}
	if (request.getParameter("priority") != null)
		priority = "" + request.getParameter("priority");
	if (request.getParameter("repeat") != null)
		repeat = "" + request.getParameter("repeat");
	if (request.getParameter("message") != null)
		message = "" + request.getParameter("message");
	if (request.getParameter("time") != null)
		time = "" + request.getParameter("time");
	if (request.getParameter("date") != null)
		date = "" + request.getParameter("date");

	if (repeat.equalsIgnoreCase("y")) {
		repeat_frequestuency = "" + request.getParameter("repeatFrequestuency");
		SimpleDateFormat formatterIn1 = new SimpleDateFormat(
				"yyyy-MM-dd");
		SimpleDateFormat formatterOut1 = new SimpleDateFormat(
				"dd/MM/yyyy");
		try {
			repeat_year = formatterOut1.format(formatterIn1.parse(""
					+ request.getParameter("repeatDate")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		repeat_day_of_month = "" + request.getParameter("monthDay");
		repeat_week_day = "" + request.getParameter("weekDay");
		repeat_time = "" + request.getParameter("repeatTime");
	}
	SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
	String activate_date = "";

	try {
		activate_date = formatterOut.format(formatterIn
				.parse("" + date));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	String mobileNo= request.getParameter("mobileNo");
	dataMap.put("hiddenValue",hiddenValue);
	dataMap.put("priority", priority);
	dataMap.put("repeat", repeat);
	dataMap.put("groupName", groupName);
	dataMap.put("date", date);
	dataMap.put("time", time);
	dataMap.put("repeat_frequestuency", repeat_frequestuency);
	dataMap.put("repeat_year", repeat_year);
	dataMap.put("activate_date", activate_date);
	dataMap.put("repeat_day_of_month",repeat_day_of_month);
	dataMap.put("repeat_week_day",repeat_week_day);
	dataMap.put("repeat_time", repeat_time);
	dataMap.put("mainId", mainId);
	dataMap.put("mobileNo",mobileNo);
	dataMap.put("type",type);
	map=smsHandlerService.updateBulkDetails(dataMap,box);
	String jsp = "bulkSms.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showBulkSmsReportJsp(HttpServletRequest request,
		HttpServletResponse response) {
	System.out.println("hi in controller");
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasBulkMain>mainList=new ArrayList<MasBulkMain>();
	map=smsHandlerService.showSendBulkSmsJsp();
	if(map.get("mainList")!=null){
		mainList=(List<MasBulkMain>)map.get("mainList");
	}
	map.put("mainList",mainList);
	String jsp = "bulkReport.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showServieWiseReportJsp(HttpServletRequest request,
		HttpServletResponse response) {
/*	System.out.println("hi in controller");
 * 
*/	@SuppressWarnings("unused")
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	Map<String, Object> map = new HashMap<String, Object>();
/*	map=smsHandlerService.showSendBulkSmsJsp();
*/	String jsp = "dpsmsReport.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView printBulkReport(HttpServletRequest request,
		HttpServletResponse response) {
	//
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> parameters = new HashMap<String, Object>();
	String adNo = "";
	if (request.getParameter("adNo") != null) {
		adNo = request.getParameter("adNo");
	}
	detailsMap = smsHandlerService.getConnectionForReport();
	parameters.put("adNo", adNo);
	// try {
	// byte bytes[] = null;
	// try
	// {
	// bytes =
	// JasperRunManager.runReportToPdf(getCompiledReport("IPAdmissionSlip"),parameters,(Connection)detailsMap.get("conn"));
	// }
	// catch(JRException e)
	// {
	// e.printStackTrace();
	// }
	//
	// //response.setHeader("Content-Disposition", "attachment;
	// filename=RegistrationCard.pdf");
	// response.setContentType("application/pdf");
	// response.setContentLength(bytes.length);
	// ServletOutputStream ouputStream;
	// try {
	// ouputStream = response.getOutputStream();
	// ouputStream.write(bytes, 0, bytes.length);
	// ouputStream.flush();
	// ouputStream.close();
	// } catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	String FROMDATE = "";
	String TODATE = "";
	String service_name = "";
	String mainGroupId = "";
	
	
	String input_string = "";
	if (request.getParameter("fromDate") != null && request.getParameter("fromDate") != ""	&& request.getParameter("toDate") != null
			&& request.getParameter("toDate") != "") {
		FROMDATE = request.getParameter("fromDate");
		TODATE = request.getParameter("toDate");
		/*input_string = "and bulk_main.activate_date between to_date('"
				+ DPUtil.converStringToDate(FROMDATE)
				+ "','YYYY-MM-DD') and to_date('"
				+ DPUtil.converStringToDate(TODATE) + "','YYYY-MM-DD')";*/
		input_string = "and bulk_main.active_date > '"
			+ HMSUtil.convertStringTypeDateToDateType(FROMDATE)
			+ "' and bulk_main.active_date < '"
			+ HMSUtil.convertStringTypeDateToDateType(TODATE) + "'";
	}

	/*if (request.getParameter("serName") != null) {
		service_name = request.getParameter("serName");
	}*/
	if (request.getParameter("mainGroupId") != null) {
		mainGroupId = request.getParameter("mainGroupId");
		input_string = input_string + " and bulk_main.name='"+mainGroupId+"'";
	}
	Map<String, Object> map = new HashMap<String, Object>();

	//System.out.println("string="+input_string);
	map.put("input_string", input_string);
	/*DPUtil.generateReport("bulkReport", map, ConnectionFactory
			.getConnectionFromMysql(), response, getServletContext());
	
*/	HMSUtil.generateReport("bulkReport", parameters,
			(Connection) detailsMap.get("conn"), response,
			getServletContext());
	// } catch (IllegalStateException e) {
	// e.printStackTrace();
	// }
	return null;
}
public ModelAndView showGroupMasterJsp(HttpServletRequest request,
		HttpServletResponse response) {
	//
	System.out.println("hi in controller");
	Map<String, Object> map = new HashMap<String, Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	map.put("hospitalId", hospitalId);
	map=smsHandlerService.showGroupMasterJsp(hospitalId);
	String jsp = "groupMasterSMS.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView addGroupSMS(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();
	MasBulkMain masBulkMain = new MasBulkMain();
	int hospitalId=0;
	String groupTypeName="";
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	int currencyId = 0;
	String changedBy = "";
	Map<String, Object> listMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	
	int userId = (Integer) session.getAttribute("userId");

	if (request.getParameter(CODE) != null) {
		code = request.getParameter(CODE);
	}
	if (request.getParameter(SEARCH_NAME) != null) {
		name = request.getParameter(SEARCH_NAME);
	}

	if (request.getParameter(CURRENCY_ID) != null) {
		currencyId = Integer.valueOf(request.getParameter(CURRENCY_ID));

	}
	if(request.getParameter("groupTypeName")!=null){
		groupTypeName=request.getParameter("groupTypeName");
	}
	if (request.getParameter(CHANGED_BY) != null
			&& !(request.getParameter(CHANGED_BY).equals(""))) {
		changedBy = request.getParameter(CHANGED_BY);
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
	
	
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	String pojoName;
	if (request.getParameter("pojoName") != null) {
		pojoName = request.getParameter("pojoName");
	}
	String pojoPropertyName;
	if (request.getParameter("pojoPropertyName") != null) {
		pojoPropertyName = request.getParameter("pojoPropertyName");
	}
	String pojoPropertyCode;
	if (request.getParameter("pojoPropertyCode") != null) {
		pojoPropertyCode = request.getParameter("pojoPropertyCode");
	}
	generalMap.put("code", code);
	generalMap.put("name", name);

	generalMap.put("currentDate", currentDate);
	generalMap.put("currentTime", currentTime);
//int pojoPropertyName=0;
	 pojoPropertyName="";
	 pojoPropertyCode="";
	 pojoName="";
	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoPropertyCode", pojoPropertyCode);
	generalMap.put("pojoName", pojoName);

	listMap = commonMasterHandlerService
			.checkForExistingMasters(generalMap);
	List countryCodeList = new ArrayList();
	List countryNameList = new ArrayList();

	if (listMap.get("duplicateGeneralCodeList") != null) {
		countryCodeList = (List) listMap.get("duplicateGeneralCodeList");
	}
	if (listMap.get("duplicateGeneralNameList") != null) {
		countryNameList = (List) listMap.get("duplicateGeneralNameList");
	}
	boolean successfullyAdded = false;

	if ((countryCodeList.size() == 0 || countryCodeList == null)
			&& (countryNameList.size() == 0 || countryNameList == null))

	{
		masBulkMain.setGroupCode(code);
		masBulkMain.setGroupName(name);
		

		masBulkMain.setStatus("y");
		Users users = new Users();
		users.setId(userId);
		masBulkMain.setLastChgBy(users);

		MasHospital mh= new MasHospital();
		mh.setId(hospitalId);
		masBulkMain.setHospital(mh);
		
		masBulkMain.setLastChgDate(currentDate);
		masBulkMain.setLastChgTime(currentTime);
		masBulkMain.setGroupType(groupTypeName);
		successfullyAdded = smsHandlerService.addGroupSMS(masBulkMain);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";

		}
	} else if ((countryCodeList.size() != 0 || countryCodeList != null)
			|| (countryNameList.size() != 0) || countryNameList != null) {

		if ((countryCodeList.size() != 0 || countryCodeList != null)
				&& (countryNameList.size() == 0 || countryNameList == null)) {

			message = "Country Code  already exists.";
		} else if ((countryNameList.size() != 0 || countryNameList != null)
				&& (countryCodeList.size() == 0 || countryCodeList == null)) {

			message = "Country Name  already exists.";
		} else if ((countryCodeList.size() != 0 || countryCodeList != null)
				&& (countryNameList.size() != 0 || countryNameList != null)) {

			message = "Country Code and Country Name already exist.";
		}
	}

	url = "/hms/hms/generalMaster?method=showCountryJsp";

	try {
		map = smsHandlerService.showGroupMasterJsp(hospitalId);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "groupMasterSMS";
	title = "Add Country";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}
public ModelAndView deletegroupSMS(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();

	int countryId = 0;
	String message = null;
	String changedBy = "";
	String changedTime = "";
	Date changedDate = null;
	String flag = "";
	HttpSession session = request.getSession();
	int userId = (Integer) session.getAttribute("userId");
	int hospitalId=0;
//ttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	if (request.getParameter("flag") != null) {
		flag = request.getParameter("flag");
		generalMap.put("flag", flag);
	}
	if (request.getParameter(COMMON_ID) != null
			&& !(request.getParameter(COMMON_ID).equals(""))) {
		countryId = Integer.parseInt(request.getParameter(COMMON_ID));
	}
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	if (request.getParameter(CHANGED_BY) != null
			&& !(request.getParameter(CHANGED_BY).equals(""))) {
		changedBy = request.getParameter(CHANGED_BY);
	}
	changedDate = new Date();
	changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");

	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);

	generalMap.put("userId", userId);
	boolean dataDeleted = false;
	dataDeleted = smsHandlerService.deletegroupSMS(countryId,
			generalMap);
	if (dataDeleted == true) {
		message = "Record is InActivated successfully !!";
	}

	else {
		message = "Record is Activated successfully !!";
	}
	url = "/hms/hms/generalMaster?method=showCountryJsp";
	try {
		map = smsHandlerService.showGroupMasterJsp(hospitalId);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "groupMasterSMS";
	title = "delete Country";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}
public ModelAndView editGroupSMS(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();

HttpSession	session = request.getSession();
	String countryCode = "";
	String countryName = "";
	int currencyId = 0;
	int countryId = 0;
	String changedBy = "";
	int hospitalId=0;
	//ttpSession session=request.getSession();
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
	Date changedDate = null;
	@SuppressWarnings("unused")
	String changedTime = "";
	//HttpSession session = request.getSession();
	int userId = (Integer) session.getAttribute("userId");

	if (request.getParameter(CURRENCY_ID) != null
			&& !(request.getParameter(CURRENCY_ID).equals(""))) {
		currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
	}
	if (request.getParameter(COMMON_ID) != null
			&& !(request.getParameter(COMMON_ID).equals(""))) {
		countryId = Integer.parseInt(request.getParameter(COMMON_ID));
	}
	if (request.getParameter(CODE) != null
			&& !(request.getParameter(CODE).equals(""))) {
		countryCode = request.getParameter(CODE);
	}
	if (request.getParameter(SEARCH_NAME) != null
			&& !(request.getParameter(SEARCH_NAME).equals(""))) {
		countryName = request.getParameter(SEARCH_NAME);
	}
	if (request.getParameter(CHANGED_BY) != null
			&& !(request.getParameter(CHANGED_BY).equals(""))) {
		changedBy = request.getParameter(CHANGED_BY);
	}
	String pojoName="";
	if (request.getParameter("pojoName") != null) {
		pojoName = request.getParameter("pojoName");
	}
	String pojoPropertyName="";
	if (request.getParameter("pojoPropertyName") != null) {
		pojoPropertyName = request.getParameter("pojoPropertyName");
	}
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	changedDate = new Date();
	changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
			"currentTime");

	generalMap.put("id", countryId);
	generalMap.put("countryCode", countryCode);
	generalMap.put("name", countryName);
	generalMap.put("currencyId", currencyId);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	generalMap.put("userId", userId);
	Map<String, Object> listMap = new HashMap<String, Object>();
	generalMap.put("pojoPropertyName", pojoPropertyName);
	generalMap.put("pojoName", pojoName);
	generalMap.put("flag", true);
	listMap = commonMasterHandlerService
			.checkForExistingMasters(generalMap);
	List existingCountryNameList = (List) listMap
			.get("duplicateMastersList");
	boolean dataUpdated = false;
	if (existingCountryNameList.size() == 0) {
		dataUpdated = smsHandlerService
				.editCountryToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
	} else if (existingCountryNameList.size() > 0) {
		message = "Name already exists.";
	}
	url = "/hms/hms/generalMaster?method=showCountryJsp";

	try {
		map = smsHandlerService.showGroupMasterJsp(hospitalId);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "groupMasterSMS";
	title = "Edit Country";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchGroupSMS(HttpServletRequest request,
		HttpServletResponse response) throws ServletRequestBindingException {
	System.out.println("<<==== in  ====>>");
	Map<String, Object> map = new HashMap<String, Object>();
	String groupCode = null;
	String groupName = null;
	String searchField = null;

	if (request.getParameter(CODE) != null
			&& !(request.getParameter(CODE).equals(""))) {
		groupCode = request.getParameter(CODE);
	}

	if (request.getParameter(SEARCH_NAME) != null
			&& !(request.getParameter(SEARCH_NAME).equals(""))) {
		groupName = request.getParameter(SEARCH_NAME);
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
		System.out.println("searchRadio" + searchRadio);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (searchRadio == 1) {
		groupCode = searchField;
		groupName = null;
	} else {
		groupCode = null;
		groupName = searchField;
	}
	map = smsHandlerService.searchGroupSMS(groupCode, groupName);
	jsp = "groupMasterSMS";
	jsp += ".jsp";
	map.put("search", "search");
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("groupCode", groupCode);
	map.put("groupName", groupName);
	return new ModelAndView("index", "map", map);
}
public ModelAndView showGroupWiseDetailJsp(HttpServletRequest request,
		HttpServletResponse response) {
	//
	List<MasBulkMain> mainList = new ArrayList<MasBulkMain>();
	System.out.println("hi in controller");
	Map<String, Object> map = new HashMap<String, Object>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	
	map.put("hospitalId", hospitalId);
	map=smsHandlerService.showGroupWiseDetailJsp(hospitalId);
	if(map.get("mainList")!=null){
		mainList=(List<MasBulkMain>)map.get("mainList");
	}
	String jsp = "groupWiseDetail.jsp";
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	map.put("mainList",mainList);
	return new ModelAndView("index", "map", map);
}
public ModelAndView getValForGroup(HttpServletRequest request,
		HttpServletResponse response) {
	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	Map<String,Object>map=new HashMap<String,Object>();
	empList=smsHandlerService.getValForGroup(hospitalId);
	map.put("empList",empList);
	jsp="responseForEmployeeForSMS";
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView getValForGroup1(HttpServletRequest request,
		HttpServletResponse response) {
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	Map<String,Object>map=new HashMap<String,Object>();
	supplierList=smsHandlerService.getValForGroup1(hospitalId);
	map.put("supplierList",supplierList);
	jsp="responseForEmployeeForSMS";
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView getValForGeneral(HttpServletRequest request,
		HttpServletResponse response) {

	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	int hospitalId=0;
	/*HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}*/
	Map<String,Object>map=new HashMap<String,Object>();
	//supplierList=smsHandlerService.getValForGroup1(hospitalId);
	map.put("supplierList",supplierList);
	jsp="responseForEmployeeForSMS";
	return new ModelAndView(jsp, "map", map);

}
public ModelAndView saveGroupDetailsForSMS(HttpServletRequest request,
		HttpServletResponse response) {
	int hospitalId=0;
	boolean saved=false;
	Map<String,Object>map=new HashMap<String,Object>();
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	String groupName="";
	if(request.getParameter("groupName")!=null && !request.getParameter("groupName").equals("")){
		groupName=request.getParameter("groupName");
	}

	int count=0;
	if(request.getParameter("count")!=null){
		count=Integer.parseInt(request.getParameter("count"));
	}
	for(int i=1;i<count;i++){
		System.out.println("--------->>"+request.getParameter("vendorCheckStatus"+i));
		if(request.getParameter("vendorCheckStatus"+i).equals("y")){
			String mobile="";
			mobile=smsHandlerService.getEmployeeMobile(Integer.parseInt(request.getParameter("empName"+i)));
			if(!mobile.equals("")){
			MasBulkDetail mbd=new MasBulkDetail();
			mbd.setChk("C");
			
			MasEmployee me =new MasEmployee();
			me.setId(Integer.parseInt(request.getParameter("empName"+i)));
			mbd.setEmployeeId(me);
			
			int empCategoryId=0;
			empCategoryId=smsHandlerService.getEmployeeCategory(Integer.parseInt(request.getParameter("empName"+i)));
			int groupId=0;
			if(empCategoryId==2){
				groupId=3;
			}else if(empCategoryId==1){
				groupId=2;
			}else {
				groupId=1;
			}
			
			MasBulkMain main=new MasBulkMain();
			main.setId(groupId);
			mbd.setGroup(main);
			mbd.setMobile(mobile);
			mbd.setPriority(2);
			mbd.setStatus("A");
			map=smsHandlerService.saveGroupWiseDetail(hospitalId,mbd);
			}
			
		}
	}
	if(map.get("successfullyAdded")!=null){
		saved=(Boolean)map.get("successfullyAdded");
	}
		if(saved==true){
			message="Saved Successfully!!";
		}
	String jsp = "groupWiseDetail.jsp";
	
	//jsp = ECHS_NO_JSP;
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	map.put("message", message);
	System.out.println("message------>>"+message);
//	map.put("mainList",mainList);
	return new ModelAndView("index", "map", map);
}
public ModelAndView sendBulk(HttpServletRequest request,
		HttpServletResponse response) {
	System.out.println("in controller");
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	Map<String,Object>map=new HashMap<String,Object>();
	Date ScheduleDate=new Date();
	String scheduleTime="";
	String minute="";
	String message="";
	String groupName="";
	int mainGroupId=0;
	int tempId=0;
	int userId =0;
	if(session.getAttribute("userId")!=null){
		userId=(Integer) session.getAttribute("userId");
	}

	if(request.getParameter("mainGroupId")!=null && !request.getParameter("mainGroupId").equals("0") && !request.getParameter("mainGroupId").equals("")){
		mainGroupId=Integer.parseInt(request.getParameter("mainGroupId"));
	}
	if(request.getParameter("tempId")!=null && !request.getParameter("tempId").equals("0") && !request.getParameter("tempId").equals("")){
		tempId=Integer.parseInt(request.getParameter("tempId"));
	}
	String hours="";
	if(request.getParameter("hours")!=null && !request.getParameter("hours").equals("") && !request.getParameter("hours").equals("0")){
		hours=request.getParameter("hours");
	}
	String minutes="";
	if(request.getParameter("minutes")!=null && !request.getParameter("minutes").equals("") && !request.getParameter("minutes").equals("0")){
		minutes=request.getParameter("minutes");
	}
	String messageToBeSent="";
	if(request.getParameter("message")!=null && !request.getParameter("message").equals("") && !request.getParameter("message").equals("0")){
		messageToBeSent=request.getParameter("message");
	}
	if(request.getParameter("ScheduleDate")!=null && !request.getParameter("ScheduleDate").equals("") && !request.getParameter("ScheduleDate").equals("0")){
		ScheduleDate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("ScheduleDate"));
	}
	System.out.println("mainGroupId>>>"+mainGroupId);
	System.out.println("tempId>>>"+tempId);
	System.out.println("hours>>>"+hours);
	System.out.println("minutes>>>"+minutes);
	String jsp = "bulkSms.jsp";
	
	Map<String,Object>generalMap=new HashMap<String,Object>();
	generalMap.put("mainGroupId", mainGroupId);
	generalMap.put("tempId", tempId);
	generalMap.put("hours", hours);
	generalMap.put("minutes", minutes);
	generalMap.put("messageToBeSent", messageToBeSent);
	generalMap.put("ScheduleDate", ScheduleDate);
	generalMap.put("hospitalId", hospitalId);
	generalMap.put("userId", userId);
	
	boolean saved=false;
	saved=smsHandlerService.saveBulkSMS(generalMap); 
	if(saved==true){
		message="Bulk Mesaages have been Sent Successfully!!";
	}
	
	//jsp = ECHS_NO_JSP;
	
	System.out.println(""+jsp);
	map.put("contentJsp", jsp);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
	
}
}
