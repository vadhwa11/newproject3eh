//------------------------------BLOOD BANK BY DIPALI--------------------------------
package jkt.hms.bloodBank.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.bloodBank.handler.BloodBankHandlerService;
import jkt.hms.masters.business.BloodAssessmentEntryM;
import jkt.hms.masters.business.BloodAssessmentEntryT;
import jkt.hms.masters.business.BloodConsent;
import jkt.hms.masters.business.BloodDiscardEntry;
import jkt.hms.masters.business.BloodDonationEntryDetail;
import jkt.hms.masters.business.BloodDonationEntryHeader;
import jkt.hms.masters.business.BloodDonorSampleScreeningHeader;
import jkt.hms.masters.business.BloodIssueHeader;
import jkt.hms.masters.business.BloodMasComponent;
import jkt.hms.masters.business.BloodReactionEntry;
import jkt.hms.masters.business.BloodRequestEntryDetail;
import jkt.hms.masters.business.BloodRequestEntryHeader;
import jkt.hms.masters.business.BloodResultEntryHeader;
import jkt.hms.masters.business.BloodSampleCollection;
import jkt.hms.masters.business.BloodSampleScreeningHeader;
import jkt.hms.masters.business.BloodStockDetail;
import jkt.hms.masters.business.BloodStockMain;
import jkt.hms.masters.business.BloodTestEntryHeader;
import jkt.hms.masters.business.BloodTransfusion;
import jkt.hms.masters.business.BloodTransfussionReactionHd;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAssessment;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BloodBankController extends MultiActionController {
	BloodBankHandlerService bloodBankHandlerService;
	CommonMasterHandlerService commonMasterHandlerService;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	String jspName = "";
	String pojoName = "";
	Date currentDate = new Date();
	String currentTime = "";
	HttpSession session = null;
	String userName = "";
	String changedBy = "";
	String donorUID = null;
	String donorName = null;

	// ----------Blood Component Master-----------------
	@SuppressWarnings("unchecked")
	public ModelAndView showBloodComponentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		session = request.getSession();
		
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(departmentId,hospitalId);
		jsp = BLOOD_COMPONENT;
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing blood bank Physical Examination page 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPhysicalExaminationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String donorAssesstMid = request.getParameter("donorAssesstMid");
		Map<String,Object> map =new HashMap<String,Object>();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		session = request.getSession();
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(hospitalId,departmentId);
		jsp = "bld_PhysicalExamination";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("donorAssesstMid", donorAssesstMid);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Donor Search Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingListBloodCollection(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		int page = 1;
		int recordsPerPage = 10;

		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
			box.put("page", page);
		}
		box.put("recordsPerPage", recordsPerPage);
		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingListBloodCollection(box);
		jsp = "bld_pendingListBloodCollection";
		// jsp ="bld_pendingBloodSampleCollection";

		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListBloodSampleCollection(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		int page = 1;
		int totalNumberOfRecords = 0;
		int recordsPerPage = 5;
		HttpSession session=request.getSession();
		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		if(session.getAttribute(HOSPITAL_ID)!=null){
			box.put(HOSPITAL_ID, session.getAttribute(HOSPITAL_ID));
		}
		box.put("page", page);
		box.put("totalNumberOfRecords", totalNumberOfRecords);
		box.put("recordsPerPage", recordsPerPage);

		
		map = bloodBankHandlerService.showPendingListBloodSampleCollection(box);
		jsp = "bld_pendingListBloodSampleCollection.jsp";
		//jsp = "bld_donorPendingSampleScreening" + ".jsp";
		/* map.put("detailsMap", detailsMap); */
		// map.put("patientMap", patientMap);
		/* map.put("deptName", deptName); */
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Donor Assessment Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showDonorAssessmentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String uhid_no="";
		if(null !=request.getParameter("uId") && !request.getParameter("uId").equals("")){
			uhid_no=request.getParameter("uId");
			System.out.println("uhid_no "+uhid_no);
		}
		String registerNum = request.getParameter("registerNum");
		String donorAssesstMid = request.getParameter("assesstmentMid");
		String donorSerialNum = request.getParameter("donorSerialNum");
		//System.out.println("donorAssesstMid " + donorAssesstMid);
		//System.out.println("registerNum " + registerNum);
		session = request.getSession();
		String donorRegNo=""; 
		int donorIdNum =0;
		donorUID = request.getParameter(UID);

		donorName = request.getParameter(DONOR_NAME);
		map = (Map<String, Object>) bloodBankHandlerService
				.showAssesstmentList(uhid_no);
		if(null !=map.get("registerNum")){
			donorRegNo=(String)map.get("registerNum");
			registerNum=donorRegNo;
		}
		if(null !=map.get("donorIdNum")){
			donorSerialNum=(String)map.get("donorIdNum");
			//registerNum=donorRegNo;
		}
		
		jsp = "bld_donorAssessment";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("registerNum", registerNum);
		map.put("donorUID", donorUID);
		map.put("donorName", donorName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("donorAssesstMid", donorAssesstMid);
		map.put("donorSerialNum", donorSerialNum);
		return new ModelAndView("index", "map", map);
	}
	
	
	/** Method for genrate pdf for patient declaration form before blood collection
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView printDeclarationForm(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>(); 
		int hospitalId = 0;
		String hinNo = "";
		String hinNoRandom="";
		HttpSession session = request.getSession();
		//@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		String billNo = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			parameters.put("hinNo", hinNo);
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		
		int donorSequenceNumer = 0;
		donorSequenceNumer = Integer.parseInt(request
				.getParameter("donorSerialNum"));
		System.out.println("@@@@@@ donorSequenceNumer  " + donorSequenceNumer);

		
		
		parameters.put("donorId", donorSequenceNumer);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("BloodBank_1", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}

	public ModelAndView printDeclarationFormAfterPhysicalExam(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>(); 
		int hospitalId = 0;
		String hinNo = "";
		String hinNoRandom="";
		HttpSession session = request.getSession();
		//@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		String billNo = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			parameters.put("hinNo", hinNo);
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		int donorbloodAssessmentEntryM=0;
		
		donorbloodAssessmentEntryM = Integer.parseInt(request.getParameter("donorbloodAssessmentEntryM"));
		
		parameters.put("donorbloodAssessmentEntryM", donorbloodAssessmentEntryM);
		
		int assestment_m_id = 0;
		assestment_m_id = Integer.parseInt(request.getParameter("donorAsstId"));
				
		parameters.put("assestment_m_id", assestment_m_id);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("bld_declaration_form", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}
	
	
	public ModelAndView printDonorRegCard(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>(); 
		int hospitalId = 0;
		String hinNo = "";
		String hinNoRandom="";
		HttpSession session = request.getSession();
		//@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		String billNo = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			parameters.put("hinNo", hinNo);
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		
		int donorRegSerialNo = 0;
		donorRegSerialNo = Integer.parseInt(request.getParameter("donorRegSerialNo"));
				
		parameters.put("donorRegSerialNo", donorRegSerialNo);
		//parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("donor_reg_card", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}


	public ModelAndView printFormAfterBooldCollection(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>(); 
		int hospitalId = 0;
		String hinNo = "";
		String hinNoRandom="";
		HttpSession session = request.getSession();
		//@SuppressWarnings("unused")
		// String opdPrint ="n";
		String pSlip = "n";
		String billNo = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			parameters.put("hinNo", hinNo);
		}

		if (request.getParameter(PRESCRIPTION_SLIP) != null) {
			pSlip = request.getParameter(PRESCRIPTION_SLIP);
		}
		
		
		int donorSequenceId = 0;
		donorSequenceId = Integer.parseInt(request.getParameter("donorSequenceId"));
		
		int donorSampleCollectionId = 0;
		donorSampleCollectionId = Integer.parseInt(request.getParameter("donorSampleCollectionId"));
				
		parameters.put("donorSequenceId", donorSequenceId);
		parameters.put("donorSampleCollectionId", donorSampleCollectionId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("bld_declaration_form_collection", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}

	
	
	/**
	 * For showing Pending List To Issue Blood Jsp Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingListIssueBlood(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(departmentId,hospitalId);
		jsp = "bld_pendingBloodIssue";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Screening Process Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showScreeningProcessJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		String bagNum = null;
		String tubNum = null;
		String quantityNum = null;

		String samplId = request.getParameter("samplId");
		if (null != samplId && !samplId.isEmpty()) {

			bagNum = request.getParameter("bagNum" + samplId);
			tubNum = request.getParameter("tubNum" + samplId);
			quantityNum = request.getParameter("quantityNum" + samplId);

		}
		map = (Map<String, Object>) bloodBankHandlerService.showBloodTestList();
		jsp = "bld_screeningProcess";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("samplId", samplId);
		map.put("bagNum", bagNum);
		map.put("tubNum", tubNum);
		map.put("quantityNum", quantityNum);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Show Blood Test List
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodTestList(HttpServletRequest request,
			HttpServletResponse response) {
		map = (Map<String, Object>) bloodBankHandlerService.showBloodTestList();
		jsp = "bld_PopupTestList";
		//jsp += ".jsp";
		title = "BloodComponent";

		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * For showing Issue Blood Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showIssueBloodJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(departmentId,hospitalId);
		jsp = "bld_issueBlood";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showIssueBloodJsp1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDs=new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		mapForDs.put("hospitalId", hospitalId);
		map = (Map<String, Object>) bloodBankHandlerService
				.getBloodIssueGrid(mapForDs);
		jsp = "bld_issueBlood";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * For showing Blood Collection Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingListForResult(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int page= 1;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		map = (Map<String, Object>) bloodBankHandlerService.showPendingListResultEntry(hospitalId);
		
			jsp = "bld_pendingListResult";
		
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingListForResultCount(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int page= 1;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map = (Map<String, Object>) bloodBankHandlerService.showPendingListResultEntryCg(hospitalId);
		
	
			jsp = "bld_pendingListResult1";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showdonorCellGroupingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int page= 1;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map = (Map<String, Object>) bloodBankHandlerService.showPendingListResultEntryCg(hospitalId);
		
	
			jsp = "bld_pendingListResult1";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingListForResultSc(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int page=0;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = (Map<String, Object>) bloodBankHandlerService.showPendingListResultEntrySg(hospitalId);
		
	
			jsp = "bld_pendingListResultSc";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}


	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView	resultEntryFormJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		int bldSampleId=Integer.parseInt(request.getParameter("Id"));
		int page=1;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		session = request.getSession();
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = (Map<String, Object>) bloodBankHandlerService
				.resultEntryFormJsp(bldSampleId,hospitalId);
		//jsp = "bld_resultEntry.jsp";
		
			jsp = "bld_TestEntry.jsp";
	
		//jsp += ".jsp";
		title = "resultEntry";
		map.put("contentJsp", jsp);
		map.put("bldSamplescreenigHedId", bldSampleId);
		//map.put("title", title);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView	resultEntryFormContJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		int bldSampleId=0;
		if(null !=request.getParameter("Id") && !request.getParameter("Id").isEmpty())
		 bldSampleId=Integer.parseInt(request.getParameter("Id"));
		int page=1;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		session = request.getSession();
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = (Map<String, Object>) bloodBankHandlerService
				.resultEntryFormContJsp(bldSampleId,hospitalId);
		//jsp = "bld_resultEntry.jsp";
		
		
			jsp = "bld_TestEntry1.jsp";
		
		//jsp += ".jsp";
		title = "resultEntry";
		map.put("contentJsp", jsp);
		//map.put("title", title);
		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView	resultEntryFormScJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		int bldSampleId=Integer.parseInt(request.getParameter("Id"));
		int page=1;
		if(request.getParameter("page")!=null && !request.getParameter("page").equals("")){
			page=Integer.parseInt(request.getParameter("page"));
		}
		session = request.getSession();
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		map = (Map<String, Object>) bloodBankHandlerService
				.resultEntryFormContJsp(bldSampleId,hospitalId);
		//jsp = "bld_resultEntry.jsp";
		
		
			jsp = "bld_TestEntrySc.jsp";
		
		//jsp += ".jsp";
		title = "resultEntry";
		map.put("contentJsp", jsp);
		//map.put("title", title);
		return new ModelAndView("index", "map", map);
		
	}
	
	public void	componentQuantity(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		int componentId=Integer.parseInt(request.getParameter("componentId"));
		System.out.println("bldSampleId "+componentId);
		session = request.getSession();
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(componentId);
		
		List<BloodMasComponent> searchBloodComponentList = new ArrayList<BloodMasComponent>();
		if (map.get("searchBloodComponentList") != null) {
			searchBloodComponentList = (List<BloodMasComponent>) map.get("searchBloodComponentList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodMasComponent compoList : searchBloodComponentList) {
				sb.append("<item>");
				sb.append("<quantity>" + compoList.getQtyUnit() + "</quantity>");
				
				sb.append("</item>");
			
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		//map.put("title", title);
		
		
	}
	
	/**
	 * For showing Blood Collection Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodCollectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String donorRegno = null;
		String idCardNo = null;
		String donorName = null;
		String donorGender = null;
		String donorDOB = null;
		String donorMob = null;
		String donorSequenceId = null;
		String idcardTypeCode = null;
		String bp = null;
		String pulse = null;
		String uhidNo = null;
		String bpDiastolic=null;
		int itemId=0;
		String itemExpiryDate="";
		String tempDate[]=null;
		session = request.getSession();
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		String sequence = request.getParameter("sequence");
		
		if (null != sequence && !sequence.isEmpty()) {
			donorRegno = request.getParameter("donorRegNo" + sequence);
			idCardNo = request.getParameter("idCardNo" + sequence);
			donorName = request.getParameter("donorNam" + sequence);
			donorGender = request.getParameter("donorGender" + sequence);
			donorDOB = request.getParameter("donorDOB" + sequence);
			donorMob = request.getParameter("donorMob" + sequence);
			donorSequenceId = request.getParameter("donorSequenceId");
			idcardTypeCode = request.getParameter("idcardTypeCode" + sequence);
			bp = request.getParameter("bp" + sequence);
			pulse = request.getParameter("pulse" + sequence);
			uhidNo = request.getParameter("uhidNo" + sequence);
			
			bpDiastolic = request.getParameter("dpDiastolic" + sequence);
			
			if(null !=request.getParameter("storeitemId" + sequence) && !request.getParameter("storeitemId" + sequence).equals(""))
			itemId=Integer.parseInt(request.getParameter("storeitemId" + sequence));
			
			if(null !=request.getParameter("expieyDate" + sequence) && !request.getParameter("expieyDate" + sequence).equals("")){
			itemExpiryDate=request.getParameter("expieyDate" + sequence);
			
			 tempDate=itemExpiryDate.split("-");
			// System.out.println("#######itemExpiryDate"+tempDate);
			}
			//System.out.println("itemExpiryDate  "+ tempDate[2]+"/"+tempDate[1]+"/"+ tempDate[0]);
		}
		
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodCollectionDetail(itemId,hospitalId);
		String bagNo=bloodBankHandlerService.generateSampleCollectionNumber();
		jsp = "bld_bloodCollection";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("uhidNo", uhidNo);
		map.put("bp", bp);
		map.put("pulse", pulse);
		map.put("sequence", sequence);
		map.put("donorRegno", donorRegno);
		map.put("idCardNo", idCardNo);
		map.put("donorName", donorName);
		map.put("donorGender", donorGender);
		map.put("donorDOB", donorDOB);
		map.put("donorMob", donorMob);
		map.put("donorSequenceId", donorSequenceId);
		map.put("idcardTypeCode", idcardTypeCode);
		map.put("bpDiastolic", bpDiastolic);
		map.put("bagNo", bagNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("itemId", itemId);
		if(null !=tempDate && null !=tempDate[2] && null !=tempDate[1] && null !=tempDate[0]){
		map.put("itemExpiryDate", tempDate[2]+"/"+tempDate[1]+"/"+ tempDate[0]);
		System.out.println("itemExpiryDate"+tempDate[2]+"/"+tempDate[1]+"/"+ tempDate[0]);
		}
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showBloodSampleCollectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Box box=HMSUtil.getBox(request); 
		HttpSession session = request.getSession();
		
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		box.put("hospitalId", hospitalId);
		String sequence = request.getParameter("sequence");
		 
		
		map = (Map<String, Object>) bloodBankHandlerService
				.getBloodSampleCollectionDetail(box);
		//String bagNo=bloodBankHandlerService.generateSampleCollectionNumber();
		jsp = "bloodSampleCollection";
		jsp += ".jsp";
		title = "BloodComponent"; 
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Donor Search Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showDonorSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int hospitalId=0;
		if(null !=session.getAttribute(HOSPITAL_ID)){
			hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodDonationEntryJsp(box);
		jsp = "bld_donorSearch";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Issue Of Indent Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ModelAndView showPendingAcknowledgmentListJsp(
			HttpServletRequest request, HttpServletResponse response) {
		
			HttpSession session = request.getSession();
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	
		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingAcknowledgmentListJsp(hospitalId);
		jsp = "bld_pendingAcknowledgmentList";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showbldIssueAcknowledgmentListJsp(
			HttpServletRequest request, HttpServletResponse response) {
		
			HttpSession session = request.getSession();
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	
		map = (Map<String, Object>) bloodBankHandlerService
				.showbldIssueAcknowledgmentListJsp(hospitalId);
		jsp = "bld_issueAcknowledgmentList";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	 
	public void populateIssueQuantityDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		int bldIndentIssueMId =0;
		int hospitalId=0;
			
		HttpSession session = request.getSession();
		 hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
			if (request.getParameter("bldIndentIssueMId") != null) {
				bldIndentIssueMId =Integer.parseInt(request.getParameter("bldIndentIssueMId"));
			}
		
			//BloodRequestEntryDetail bloodRequestDetails=null;
			int quantity = 0;
			BigDecimal issuedQuantity=null;
			
		map = bloodBankHandlerService.populateIssueQuantityDetails(bldIndentIssueMId,hospitalId);
		
		if (map.get("quantity") != null) {
			quantity = (Integer) map.get("quantity");
		}
		if (map.get("issuedQuantity") != null) {
			issuedQuantity = (BigDecimal) map.get("issuedQuantity");
		}
		
		
		
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			
				sb.append("<item>");
				sb.append("<requestQuantity>" + quantity + "</requestQuantity>");
				
				sb.append("<issuedQuantity>" +issuedQuantity + "</issuedQuantity>");
				
				sb.append("<bldIndentIssueMNameId>" +bldIndentIssueMId + "</bldIndentIssueMNameId>");
				
				
				
				sb.append("</item>");
			
		
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	/** Method for save the acknowledgement Data
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveAcknownledgeData(HttpServletRequest request, HttpServletResponse response){

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		int indentId=Integer.parseInt(request.getParameter("bldIndentIssueMName"));
		
		boolean status=false;
		String message=null;
		
		map = (Map<String, Object>) bloodBankHandlerService
				.saveAcknownledgeData(hospitalId,indentId);
	
		status=(Boolean)map.get("status");
		if(status){
			message="Data Saved SuccessFully ";
		}
		else{
			message="Some Error Occure  ";
		}
		map.put("message", message);
		jsp = "msg_bld_indentAck";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

		
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView populateIssueIndentBagDetal(HttpServletRequest request, HttpServletResponse response){

		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String userName=null;
		String AckuserName=null;
		int indentId=Integer.parseInt(request.getParameter("indentId"));
		
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			map.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		AckuserName=user.getEmployee().getEmployeeName();
		
		map.put("userId", userId);
		
		map = (Map<String, Object>) bloodBankHandlerService
				.populateIssueIndentBagDetal(hospitalId,indentId);
	
		jsp = "bld_indentAck";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("AckuserName", AckuserName);
		map.put("userId", userId);
		
		return new ModelAndView("index", "map", map);

		
	}

	/**
	 * For showing Issue Of Indent Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showIssueOfIndentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int requestHeaderId=Integer.parseInt(request.getParameter("RequestHeaderId"));
		
		map = (Map<String, Object>) bloodBankHandlerService
				.showIssueOfIndentJsp(requestHeaderId);
		jsp = "bld_issueOfIndent";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing pending Indent List Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingIndentListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingIndentListJsp(hospitalId);
		jsp = "bld_pendingIndentList";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * for Search Assesstment
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView searchAssesstment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = (Map<String, Object>) bloodBankHandlerService
				.searchAssesstment(box);
		jsp = "bld_donorAssesstmentMaster";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Add Master Assesstment For Donor
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveAssesstment(HttpServletRequest request,
			HttpServletResponse response) {
		boolean saveStatus = false;
		boolean checkDuplicateAssessstment=false;
		Map<String,Object> map=new HashMap<String,Object>();
		String message="";
		HttpSession session = request.getSession();
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date changedDate = new Date();
		System.out.println(" " + changedDate);

		Box box = HMSUtil.getBox(request);
		box.put("changedBy", changedBy);
		box.put("currentDate", changedDate);

		map = bloodBankHandlerService.saveAssesstment(box);
		saveStatus=(Boolean)map.get("save");
		checkDuplicateAssessstment=(Boolean)map.get("checkDuplicateAssessstment");
		if(!checkDuplicateAssessstment){
		if (saveStatus) {
			message = "Assesstment has been added Successfully !!";
		} else {
			message = "Try Again!";
		}
		}else{
			message="Record Already Exist !";
		}

		map.put("message", message);
		jsp = "bld_msgAssesstmentMaster";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * Update Master Assesstment
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updateAssesstment(HttpServletRequest request,
			HttpServletResponse response) {
		boolean saveStatus = false;
		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);

		saveStatus = bloodBankHandlerService.updateAssesstment(box);
		String message="";
		if(saveStatus){
			message="Updation Successful ";
			jsp = "msg_bld_updateAssesstmentMaster";
			
		}
		else{
			message="Some Error Occure ! ";
			jsp = "msg_bld_updateAssesstmentMaster";
			
		}
		//jsp = "bld_donorAssesstmentMaster";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * For showing Indent Blood Bank Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showIndentBloodBankJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		map = (Map<String, Object>) bloodBankHandlerService
				.showIndentBloodBankJsp();
		jsp = "bld_indentBloodBank";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing blood bank Physical Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodReactionFormDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(departmentId,hospitalId);
		jsp = "bld_BloodReactionFormDetails";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing blood bank Physical Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showCrossMatchingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int bloodRequestHeaderId=0;
		HttpSession session = request.getSession();
		if(request.getParameter("bloodRequestHeaderId")!=null && !request.getParameter("bloodRequestHeaderId").equals("")){
			bloodRequestHeaderId=Integer.parseInt(request.getParameter("bloodRequestHeaderId"));
		}
		
		String uhid="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String crossMatchbyName="";
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		crossMatchbyName=user.getEmployee().getEmployeeName();
		map = (Map<String, Object>) bloodBankHandlerService
				.showCrossMatchingJsp(bloodRequestHeaderId,hospitalId);
	
		
		jsp = "bld_crossMatching";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("userId", userId);
		map.put("crossMatchbyName", crossMatchbyName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	  
	public void populateBloodBags(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		int bloodGroupId =0;
		HttpSession session=request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
			if (request.getParameter("bloodGroupId") != null) {
				bloodGroupId =Integer.parseInt(request.getParameter("bloodGroupId"));
			}
			
		
		map = bloodBankHandlerService.populateBloodBags(bloodGroupId,hospitalId);
		
		if (map.get("bloodstockdetailList") != null) {
			bloodstockdetailList = (List) map.get("bloodstockdetailList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			//sb.append("<>");
			if(null !=bloodstockdetailList && bloodstockdetailList.size()>0){
			for (BloodStockDetail bsd : bloodstockdetailList) {
				//System.out.println("bsd.getBloodBagNo() "+bsd.getBloodBagNo());
				sb.append("<item>");
				sb.append("<bagNo>" + bsd.getBloodBagNo() + "</bagNo>");
				
				
				
				sb.append("</item>");
				
			}
			}
			else{
				//System.out.println("bsd.getBloodBagNo() empty ");
				sb.append("<item>");
				sb.append("<bagNo>" +"" + "</bagNo>");
				sb.append("</item>");
			}
		//	sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public void populateBagDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		String bloodBag ="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
			if (request.getParameter("bloodBag") != null) {
				bloodBag =request.getParameter("bloodBag");
				//System.out.println(bloodBag +"  bloodBag");
			}
			dataMap = bloodBankHandlerService.populateBloodBags(bloodBag,hospitalId);
			
		String componentName="";
		if (dataMap.get("bloodstockdetailList") != null) {
			bloodstockdetailList = (List<BloodStockDetail>) dataMap.get("bloodstockdetailList");
		}
		/*if (dataMap.get("componentName") != null) {
			componentName = (String) map.get("componentName");
		}*/
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bsd : bloodstockdetailList) {
				/*System.out.println("### "+ bsd.getComponent().getComponentName());*/
				sb.append("<item>");
				sb.append("<bloodgroup>" + bsd.getStockMain().getBloodGroup().getBloodGroupName() + "</bloodgroup>");
				sb.append("<componentName>" + bsd.getComponent().getComponentName() + "</componentName>");
				sb.append("<quantity>" + bsd.getQty() + "</quantity>");
				sb.append("<expiryDate>" +HMSUtil.convertDateToStringTypeDateOnly(bsd.getStockMain().getExpiryDate())  + "</expiryDate>");
				sb.append("<bag>" + bsd.getBloodBagNo() + "</bag>");
				
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void populateComponentBagDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bloodstockdetailList=new ArrayList<BloodStockDetail>();
		String bloodBag ="";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			if (request.getParameter("bloodBag") != null) {
				bloodBag =request.getParameter("bloodBag");
			}
			dataMap = bloodBankHandlerService.populateBloodBags(bloodBag,hospitalId);
		
		if (dataMap.get("bloodstockdetailList") != null) {
			bloodstockdetailList = (List<BloodStockDetail>) dataMap.get("bloodstockdetailList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bsd : bloodstockdetailList) {
				sb.append("<item>");
				
				
				sb.append("<stockDetailId>" + bsd.getId() + "</stockDetailId>");
				sb.append("<stockMainId>" + bsd.getStockMain().getId() + "</stockMainId>");
				if(null !=bsd.getStockMain().getBloodGroup()){
				sb.append("<bloodgroup>" + bsd.getStockMain().getBloodGroup().getId() + "</bloodgroup>");
				}else{
					sb.append("<bloodgroup>" + "" + "</bloodgroup>");
				}
				sb.append("<componentName>" + bsd.getComponent().getComponentName() + "</componentName>");
				sb.append("<quantity>" + bsd.getQty() + "</quantity>");
				sb.append("<expiryDate>" + bsd.getStockMain().getExpiryDate() + "</expiryDate>");
				sb.append("<bag>" + bsd.getBloodBagNo() + "</bag>");
				//sb.append("<tubeNo>" + bsd.getTubeNo() + "</tubeNo>");
				
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingSampleScreeningTestJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingSampleScreeningTestJsp(box );
		jsp = "bld_pendingList_Cross_Matching";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveCrossMatching(
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Calling  submitCrossMatching");
		session = request.getSession();
		Box box=HMSUtil.getBox(request);
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		map = (Map<String, Object>) bloodBankHandlerService
				.submitCrossMatching(box );
		boolean status=(Boolean)map.get("saveResult");
		String message="";
		if(status){
			message="Cross Matching Successfuly done.";
		}
		else{
			message="Some error occur";
		}
		
		jsp = "msg_crossMatching";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Show Assesstment Master Jsp Page
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showDonorAssesstmentMasterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		int recordsPerPage = 5;

		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = (Map<String, Object>) bloodBankHandlerService
				.showDonorAssesstmentMasterJsp(page, recordsPerPage);
		jsp = "bld_donorAssesstmentMaster";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView registerBloodBank(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		boolean status=false;
		map =  bloodBankHandlerService.registerBloodBank(box);
		status=(Boolean)map.get("successfullyAdded");
		String message="";
		if(status){
			message="Registration scuccessful ";
		}else{
			message="Some Problem Occure ! try again ";
		}
		jsp = "MsgForBloodBankReg";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * For showing Sample Validation Page Examination page added
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSampleValidationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentJsp(departmentId,hospitalId);
		jsp = "blood_sampleValidation";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchBloodComponent(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String bloodComponentCode = null;
		String bloodComponentName = null;
		String searchField = null;
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bloodComponentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bloodComponentName = request.getParameter(SEARCH_NAME);
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
			bloodComponentCode = searchField;
			bloodComponentName = null;

		} else {
			bloodComponentCode = null;
			bloodComponentName = searchField;
		}
		map = bloodBankHandlerService.searchBloodComponent(bloodComponentCode,
				bloodComponentName);
		jsp = BLOOD_COMPONENT;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("bloodComponentCode", bloodComponentCode);
		map.put("bloodComponentName", bloodComponentName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> map = new HashMap<String, Object>();
		BloodMasComponent bloodMasComponent = new BloodMasComponent();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String wholeBlood = "";
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LIFE_SPAN) != null
				&& !request.getParameter(LIFE_SPAN).equals("")) {
			lifeSpan = Integer.parseInt(request.getParameter(LIFE_SPAN));
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			temperature = Integer.parseInt(request.getParameter(TEMPERATURE));
		}
		if (request.getParameter(QTY_PER_UNIT) != null
				&& !request.getParameter(QTY_PER_UNIT).equals("")) {
			qtyUnit = Integer.parseInt(request.getParameter(QTY_PER_UNIT));
		}
		if (request.getParameter(WHOLE_BLOOD) != null) {
			wholeBlood = request.getParameter(WHOLE_BLOOD);
		}
		String days = "";
		if (request.getParameter(DAYS) != null) {
			days = request.getParameter(DAYS);
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List bloodComponentCodeList = new ArrayList();
		List bloodComponentNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			bloodComponentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			bloodComponentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((bloodComponentCodeList.size() == 0 || bloodComponentCodeList == null)
				&& (bloodComponentNameList.size() == 0 || bloodComponentNameList == null)) {
			bloodMasComponent.setComponentCode(code);
			bloodMasComponent.setComponentName(name);
			bloodMasComponent.setTemperature(temperature);
			bloodMasComponent.setLifeSpan(lifeSpan);
			bloodMasComponent.setQtyUnit(qtyUnit);
			bloodMasComponent.setPeriod(days);
			bloodMasComponent.setWholeBlood(wholeBlood);
			bloodMasComponent.setStatus("y");
			bloodMasComponent.setLastChgBy(changedBy);
			bloodMasComponent.setLastChgDate(currentDate);
			bloodMasComponent.setLastChgTime(currentTime);
			successfullyAdded = bloodBankHandlerService
					.addBloodComponent(bloodMasComponent);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
				|| (bloodComponentNameList.size() != 0)
				|| bloodComponentNameList != null) {
			if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
					&& (bloodComponentNameList.size() == 0 || bloodComponentNameList == null)) {
				message = "Component Code  already exists.";
			} else if ((bloodComponentNameList.size() != 0 || bloodComponentNameList != null)
					&& (bloodComponentCodeList.size() == 0 || bloodComponentCodeList == null)) {
				message = "Component Name already exists.";
			} else if ((bloodComponentCodeList.size() != 0 || bloodComponentCodeList != null)
					&& (bloodComponentNameList.size() != 0 || bloodComponentNameList != null)) {
				message = "Component Code and Component Name already exist.";
			}
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp(hospitalId,departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Add Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String bloodComponentCode = "";
		String bloodComponentName = "";
		String wholeBlood = "";
		int qtyUnit = 0;
		int temperature = 0;
		int lifeSpan = 0;
		int bloodComponentId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		Date currentDate = new Date();

		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !(request.getParameter(BLOOD_COMPONENT_ID).equals(""))) {
			bloodComponentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			bloodComponentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			bloodComponentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LIFE_SPAN) != null
				&& !(request.getParameter(LIFE_SPAN).equals(""))) {
			lifeSpan = Integer.parseInt(request.getParameter(LIFE_SPAN));
		}
		if (request.getParameter(TEMPERATURE) != null
				&& !(request.getParameter(TEMPERATURE).equals(""))) {
			temperature = Integer.parseInt(request.getParameter(TEMPERATURE));
		}
		if (request.getParameter(QTY_PER_UNIT) != null
				&& !(request.getParameter(TEMPERATURE).equals("0"))) {
			qtyUnit = Integer.parseInt(request.getParameter(QTY_PER_UNIT));
		}
		if (request.getParameter(WHOLE_BLOOD) != null) {
			wholeBlood = request.getParameter(WHOLE_BLOOD);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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

		generalMap.put("id", bloodComponentId);
		generalMap.put("bloodComponentCode", bloodComponentCode);
		generalMap.put("name", bloodComponentName);
		generalMap.put("lifeSpan", lifeSpan);
		generalMap.put("temperature", temperature);
		generalMap.put("qtyUnit", qtyUnit);
		generalMap.put("wholeBlood", wholeBlood);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		Map<String, Object> listMap = new HashMap<String, Object>();
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBloodComponentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingBloodComponentNameList.size() == 0) {
			dataUpdated = bloodBankHandlerService
					.editBloodComponent(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBloodComponentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp(hospitalId,departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Update Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBloodComponent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		int bloodComponentId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !(request.getParameter(BLOOD_COMPONENT_ID).equals(""))) {
			bloodComponentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
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
		boolean dataDeleted = false;
		dataDeleted = bloodBankHandlerService.deleteBloodComponent(
				bloodComponentId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/bloodBank?method=showBloodComponentJsp";
		try {
			map = bloodBankHandlerService.showBloodComponentJsp(hospitalId,departmentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_COMPONENT;
		title = "Delete Blood Component";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------Consent for Blood TransfusionEntry------------

	public ModelAndView showPatientSearchForBloodTransfusionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showPatientSearchForBloodTransfusionJsp();
		jsp = SEARCH_BLOOD_TRANSFUSION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForBloodTransfusion(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		String adNo = "";
		String patientFName = "";
		String patientLName = "";
		int inpatientId = 0;
		int hinId = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			adNo = request.getParameter(AD_NO);
			mapForDs.put("adNo", adNo);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		patientMap = bloodBankHandlerService
				.getPatientForBloodTransfusion(mapForDs);
		map = bloodBankHandlerService.showPatientSearchForBloodTransfusionJsp();
		jsp = SEARCH_BLOOD_TRANSFUSION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showConsentBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientId").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDS.put("inpatientId", inpatientId);
		}
		if (inpatientId != 0) {
			map = bloodBankHandlerService
					.showConsentBloodTransfusion(inpatientId);
			int entrySeqNo = 0;
			entrySeqNo = bloodBankHandlerService
					.getTransfusionEntrySeqForDisplay("TEN");
			if (entrySeqNo != 0) {
				map.put("entrySeqNo", entrySeqNo);
			}
		}
		jsp = BLOOD_TRANSFUSION_ENTRY + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();

		int inpatientId = 0;
		int hinId = 0;
		int componentId = 0;
		int entrySeqNo = 0;

		String witnessName = "";
		String date = "";
		String time = "";
		String hinNo = "";
		String adNo = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(BLOOD_COMPONENT_ID) != null
				&& !request.getParameter(BLOOD_COMPONENT_ID).equals("0")) {
			componentId = Integer.parseInt(request
					.getParameter(BLOOD_COMPONENT_ID));
		}
		if (request.getParameter(ENTRY_NO) != null
				&& !request.getParameter(ENTRY_NO).equals("")) {
			entrySeqNo = Integer.parseInt(request.getParameter(ENTRY_NO));
		}
		if (request.getParameter(WITNESS_NAME) != null
				&& !request.getParameter(WITNESS_NAME).equals("")) {
			witnessName = request.getParameter(WITNESS_NAME);
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(AD_NO) != null
				&& !request.getParameter(AD_NO).equals("")) {
			adNo = request.getParameter(AD_NO);
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

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTransfusion bloodTransfusion = new BloodTransfusion();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodTransfusion.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodTransfusion.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodTransfusion.setDepartment(masDepartment);
		}
		if (componentId != 0) {
			BloodMasComponent bloodMasComponent = new BloodMasComponent();
			bloodMasComponent.setId(componentId);
			bloodTransfusion.setComponent(bloodMasComponent);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodTransfusion.setHospital(masHospital);
		}
		bloodTransfusion.setWitnessName(witnessName);

		bloodTransfusion.setEntryNo(entrySeqNo);
		int temp = bloodBankHandlerService.generateTransfusionEntryNumber();

		bloodTransfusion.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodTransfusion.setLasChgBy(userName);
		bloodTransfusion.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodTransfusion.setLastChgTime(time);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("componentId", componentId);
		infoMap.put("hinId", hinId);
		infoMap.put("inpatientId", inpatientId);
		infoMap.put("entrySeqNo", entrySeqNo);

		String jsp = "";
		String message = "";
		if (returnMap.get("entrySeqNo") != null) {
			entrySeqNo = (Integer) returnMap.get("entrySeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService
				.submitBloodTransfusion(bloodTransfusion);
		if (saved) {
			message = "Data saved Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = SEARCH_BLOOD_TRANSFUSION + ".jsp";
		map.put("hinNo", hinNo);
		map.put("adNo", adNo);
		map.put("entrySeqNo", entrySeqNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBloodTransfusion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String query = "";

		try {

			if (request.getParameter("entryNo") != null
					&& (!request.getParameter("entryNo").equals(""))) {
				query = "where blood_transfusion.`entry_no` = '"
						+ request.getParameter("entryNo") + "' ";
			}
			if (request.getParameter("adNo") != null
					&& (!request.getParameter("adNo").equals(""))) {
				query = query + "AND inpatient.`ad_no` = '"
						+ request.getParameter("adNo") + "' ";
			}
			if (request.getParameter("hinNo") != null
					&& (!request.getParameter("hinNo").equals(""))) {
				query = query + "AND patient.`hin_no` = '"
						+ request.getParameter("hinNo") + "' ";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = bloodBankHandlerService.getDBConnection();
		parameters.put("QUERY", query);
		try {
			response.setContentType("application/pdf");
			HMSUtil.generateReport("blood_consenttransfusion", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------Blood Request Entry----------------------------------------
	public ModelAndView showPatientSearchForBloodRequestJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		patientMap = bloodBankHandlerService
				.populateBloodRequestForm(mapForDs);
	
		map.put("patientMap", patientMap);
		jsp = BLOOD_REQUEST_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView searchPatientForBloodRequest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		String adNo = "";
		String pType = "";
		String patientFName = "";
		String patientLName = "";
		int inpatientId = 0;
		int hinId = 0;
		Box box = HMSUtil.getBox(request);
		//session.setAttribute("box", box);
		session = request.getSession();
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put("hospitalId", hospitalId);
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			mapForDs.put("inpatientId", inpatientId);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			pType = request.getParameter(PATIENT_TYPE);
			mapForDs.put("pType", pType);
		}

		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		/*if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}*/
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			mapForDs.put("hinId", hinId);
		}
		int districtId=0;
		if (request.getParameter("district") != null
				&& !(request.getParameter("district").equals(""))) {
			districtId =Integer.parseInt(request.getParameter("district"));
			mapForDs.put("districtId", districtId);
		}
		
		patientMap = bloodBankHandlerService
				.getPatientForBloodRequest(mapForDs);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_REQUEST_ENTRY + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getComponentNameForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);
		map = bloodBankHandlerService
				.getComponentNameForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "bld_responseForComponentName";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getComponentNameSeparationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);
		map = bloodBankHandlerService
				.getComponentNameSeparationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "bld_responseForComponentName";
		return new ModelAndView(jsp, "map", map);
	}

	public void fillItemsForComponentname(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		String componentName = "";
		int bloodBankName=0;
		int bloodGroupId=0;
		
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		
			if (request.getParameter("componentName") != null) {
				componentName = request.getParameter("componentName");
			}
			if (request.getParameter("bloodBankName") != null) {
				bloodBankName = Integer.parseInt(request.getParameter("bloodBankName"));
			}
			if (request.getParameter("bloodGroupId") != null) {
				bloodGroupId = Integer.parseInt(request.getParameter("bloodGroupId"));
			}
			 
			dataMap.put("bloodGroupId", bloodGroupId);
		dataMap.put("componentName", componentName);
		dataMap.put("bloodBankName", bloodBankName);

		map = bloodBankHandlerService.fillItemsForComponentname(dataMap);
		if (map.get("componentList") != null) {
			componentList = (List) map.get("componentList");
		}
		int availableStock=0;
		
		if (map.get("availableStock") != null) {
			availableStock = (Integer) map.get("availableStock");
		}
		
		StringBuffer sb = new StringBuffer();

		
		sb.append("<item>");
		for (BloodMasComponent bloodMasComponent : componentList) {
			
			sb.append("<componentId>" + bloodMasComponent.getId()
					+ "</componentId>");
			 sb.append("<componentCode>" +
			 bloodMasComponent.getComponentCode() + "</componentCode>");
			sb.append("<quantity>" + bloodMasComponent.getQtyUnit()
					+ "</quantity>");
			
		}
		sb.append("<availableStock>" + availableStock
				+ "</availableStock>");
		
		sb.append("</item>");
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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
	
	public void populateAvailableBlood(HttpServletRequest request,
			HttpServletResponse response){
		
		
		int bloodBankId = 0;
		int componentId=0;
		int availableBlood=0;
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		try {
			if (request.getParameter("bloodBankId") != null) {
				bloodBankId =Integer.parseInt(request.getParameter("bloodBankId"));
				System.out.println("bloodBankId "+bloodBankId);
			}
			if (request.getParameter("componentId") != null) {
				componentId =Integer.parseInt(request.getParameter("componentId"));
				System.out.println("componentId "+componentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		availableBlood = bloodBankHandlerService.populateAvailableBlood(bloodBankId,componentId);
		if (map.get("componentList") != null) {
			componentList = (List) map.get("componentList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		
			sb.append("<item>");
			sb.append("<availableBlood>" + availableBlood
					+ "</availableBlood>");
			
			
			sb.append("</item>");
		
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodRequestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		int hinId = 0;
		if (request.getParameter("hinId") != null
				&& !(request.getParameter("hinId").equals("0"))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			
			mapForDS.put("hinId", hinId);
		}
		int visitId=0;
		if(request.getParameter("visitId") != null
				&& !(request.getParameter("visitId").equals(""))){
			visitId=Integer.parseInt(request.getParameter("visitId"));
		}
		
		String pTye="";
		if(request.getParameter("pTye")!=null){
			pTye=request.getParameter("pTye");
			mapForDS.put("pTye", pTye);
		}
		System.out.println("hinId   "+hinId);	
		if (hinId != 0) {
			map = bloodBankHandlerService.showBloodRequestEntryJsp(hinId,pTye);
			String orderSeqNo = "";
			orderSeqNo = bloodBankHandlerService.getOrderSeqForDisplay("RON",hospitalId);
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		jsp = BLOOD_REQUEST + ".jsp";

		map.put("contentJsp", jsp);
		map.put("hinId", hinId);
		map.put("visitId",visitId);
		
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitBloodRequestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;
		String remarks="";
		String orderSeqNo = "";
		String requestStatus = "";
		String hinNo = "";
		String date = "";
		String time = "";
		String requestType = "";
		String noOfBottles = "";
		String hb = "";
		String presence1 = "";
		String fever = "";
		String ofTime = "";
		String ifAny = "";
		String pregnancies = "";
		String specificReference = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List componentList = new ArrayList();
		int visitId=0;
		
		List qtyList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int bloodBankId = Integer.parseInt( request.getParameter("bloodBanknameId"));
		System.out.println("bloodBanknameId  "+bloodBankId);
		
		if (request.getParameter("BloodhdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("BloodhdId"));
		}
		int donationMainIdFromRequest = 0;
		if (request.getParameter("donationhdId") != null) {
			donationMainIdFromRequest = Integer.parseInt(request
					.getParameter("donationhdId"));
		}
		if (request.getParameter("patientHinId") != null
				&& !request.getParameter("patientHinId").equals("0")) {
			hinId = Integer.parseInt(request.getParameter("patientHinId"));
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if(request.getParameter("remarks")!=null && !request.getParameter("remarks").equals("")){
			remarks=request.getParameter("remarks");
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		
		if (request.getParameter("inpatientAdId") != null
				&& !request.getParameter("inpatientAdId").equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientAdId"));
		}
		
		if (request.getParameter(REQUEST_TYPE) != null
				&& !request.getParameter(REQUEST_TYPE).equals("")) {
			requestType = request.getParameter(REQUEST_TYPE);
		}
		if (request.getParameter(BOTTLES_NO) != null
				&& !request.getParameter(BOTTLES_NO).equals("")) {
			noOfBottles = request.getParameter(BOTTLES_NO);
		}
		if (request.getParameter(HB) != null
				&& !request.getParameter(HB).equals("")) {
			hb = request.getParameter(HB);
		}
		if (request.getParameter(PRESENCE1) != null
				&& !request.getParameter(PRESENCE1).equals("")) {
			presence1 = request.getParameter(PRESENCE1);
		}
		if (request.getParameter(FEVER) != null
				&& !request.getParameter(FEVER).equals("")) {
			fever = request.getParameter(FEVER);
		}
		if (request.getParameter(OF_TIME) != null
				&& !request.getParameter(OF_TIME).equals("")) {
			ofTime = request.getParameter(OF_TIME);
		}
		if (request.getParameter(IF_ANY) != null
				&& !request.getParameter(IF_ANY).equals("")) {
			ifAny = request.getParameter(IF_ANY);
		}
		if (request.getParameter(PREGNANCIES) != null
				&& !(request.getParameter(PREGNANCIES).equals(""))) {
			pregnancies = request.getParameter(PREGNANCIES);
		}
		if (request.getParameter(SPECIFIC_REFERENCE) != null
				&& !(request.getParameter(SPECIFIC_REFERENCE).equals(""))) {
			specificReference = request.getParameter(SPECIFIC_REFERENCE);
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
		if (request.getParameter(REQUEST_STATUS) != null
				&& !(request.getParameter(REQUEST_STATUS).equals(""))) {
			requestStatus = request.getParameter(REQUEST_STATUS);
		}
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		if(request.getParameter("visitId")!=null){
			visitId=Integer.parseInt(request.getParameter("visitId"));
		}
		
		int bloodGroupId=0;
		if (request.getParameter("bloodGroup") != null && !request.getParameter("bloodGroup").equals("")) {
			bloodGroupId = Integer.parseInt(request.getParameter("bloodGroup"));
		}
		MasBloodGroup bloodgroup=new MasBloodGroup();
		if(bloodGroupId>0){
			bloodgroup.setId(bloodGroupId);
		}
		String referTo="";
		if(request.getParameter("referTo")!=null){
			referTo=request.getParameter("referTo");
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		
		if (request.getParameter(ORDER_NO) != null
				&& !request.getParameter(ORDER_NO).equals("")) {
			orderSeqNo = request.getParameter(ORDER_NO);
		}
		int i = 0;
		BloodRequestEntryHeader bloodEntryHeader = null;
		Vector quantity = null;
		;
		Vector req_date = null;
		int rowCount = box.getInt("rowCount");
		try {
		if (rowCount > 0) {
			for (i = 1; i <= rowCount; i++) {
				if (box.getInt(BLOOD_COMPONENT_ID + i) != 0) {	
					bloodEntryHeader = new BloodRequestEntryHeader();
		
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodEntryHeader.setHin(patient);
		}
		if (inpatientId > 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			bloodEntryHeader.setInpatient(inpatient);
		}else if(visitId>0){
			Visit visit=new Visit();
			visit.setId(visitId);
			bloodEntryHeader.setVisit(visit);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodEntryHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodEntryHeader.setHospital(masHospital);
		}
		if (bloodBankId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(bloodBankId);
			bloodEntryHeader.setBloodBank(masHospital);
		}
		
		
		if(remarks!=null && !remarks.equals("")){
			bloodEntryHeader.setRemarks(remarks);
			
		}
		bloodEntryHeader.setOrderNo(orderSeqNo);
		//String temp = bloodBankHandlerService.generateOrderNumber();

		if(bloodGroupId>0){
			bloodEntryHeader.setBloodGroup(bloodgroup);  
		}
		bloodEntryHeader.setOrderTime(time);
		bloodEntryHeader.setRequestType(requestType);
		bloodEntryHeader
				.setDate1(HMSUtil.convertStringTypeDateToDateType(date));
		bloodEntryHeader.setNoBottles(noOfBottles);
		bloodEntryHeader.setHb(hb);
		bloodEntryHeader.setPresence1(presence1);
		bloodEntryHeader.setFever(fever);
		bloodEntryHeader.setOfTime(ofTime);
		bloodEntryHeader.setIfAny(ifAny);
		bloodEntryHeader.setPregnancies(pregnancies);
		bloodEntryHeader.setSpecificReference(specificReference);
		bloodEntryHeader.setRequestStatus("P");
		bloodEntryHeader.setBloodRequestStatus("P");
		bloodEntryHeader.setLastChgBy(userName);
		bloodEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodEntryHeader.setLastChgTime(time);
		bloodEntryHeader.setReferTo(referTo);
		bloodEntryHeader.setSampleCollectionStatus("P");
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("orderSeqNo", orderSeqNo);

		
			 quantity = new Vector();
			
			 req_date = new Vector();
			

						componentList.add(box.getInt(BLOOD_COMPONENT_ID + i));
						quantity.add(box.getString(QUANTITY + i));
						req_date.add(box.getString(REQUIRED_DATE + i));
						bloodEntryHeader.setNoBottles(box.get("bloodUnit"+i));
						bloodEntryHeader.setOrderDate(HMSUtil
								.convertStringTypeDateToDateType(box.getString(REQUIRED_DATE + i)));
					
						
						infoMap.put("bloodEntryHeader"+i, bloodEntryHeader);
						
						infoMap.put("componentMainIdFromRequest"+i,
								componentMainIdFromRequest);
						infoMap.put("componentList"+i, componentList);
						infoMap.put("quantity"+i, quantity);
						infoMap.put("req_date"+i, req_date);
					}

				}

			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		i=i-1;
		infoMap.put("box", box);
		infoMap.put("size", i);
		String jsp = "";
		String message = "";
		if (returnMap.get("orderSeqNo") != null) {
			orderSeqNo = (String) returnMap.get("orderSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodRequestEntry(infoMap);
		if (saved) {
			message = "Blood Request Entry has been done Successfully !!";
		} else {
			message = "Blood Request Entry Not Saved !!";
		}
		
		jsp = BLD_MSG_REQ_ENTRY + ".jsp";
		map.put("orderSeqNo", orderSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -------------Pending Sample Collection----------------------------------
	public ModelAndView showPendingSampleCollectionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		detailsMap = bloodBankHandlerService.getDetailsForSampleCollection();
		patientMap = bloodBankHandlerService.getSampleCollectionGrid(mapForDs);
		jsp = PENDING_BLOOD_SAMPLE_COLLECTION + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForSampleCollection(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serPersonFName = "";
		String patientFName = "";
		String patientLName = "";
		String requestStatus = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";

		int requestId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(REQUEST_STATUS) != null
					&& !(request.getParameter(REQUEST_STATUS).equals("0"))) {
				requestStatus = request.getParameter(REQUEST_STATUS);
				mapForDs.put("requestStatus", requestStatus);
			}
			if (request.getParameter(BLOOD_REQUEST_ID) != null
					&& !(request.getParameter(BLOOD_REQUEST_ID).equals("0"))) {
				requestId = new Integer(request.getParameter(BLOOD_REQUEST_ID));
				mapForDs.put("requestId", requestId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = bloodBankHandlerService
				.getPatientDetailSampleCollection(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleCollection();
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = PENDING_BLOOD_SAMPLE_COLLECTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method for saving pending Patient Blood Collection
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitBloodSampleCollection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String buttonName = "";
		buttonName = request.getParameter("discard");
		//System.out.println("buttonName   " + buttonName);
		
		Box box = HMSUtil.getBox(request);
		box.put("buttonName", buttonName);
		boolean saved = false;
		int hospitalId = 0;

		String userName = "";

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		int requestHeaderId = 0;
		int newRequestId = 0;
		String bagNo="";
		
		map = bloodBankHandlerService.submitBloodSampleCollection(box);
		saved = (Boolean) map.get("saved");
		
		if(null !=map.get("bagNo")){
		bagNo=(String) map.get("bagNo");
		}
		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Sample Collection Done Successfully !!";
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		}
		String url1 = "";
		url = "/hms/hms/bloodBank?method=showPendingListBloodCollection";
		//url1 = "/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp";
		url1 = "/hms/hms/bloodBank?method=showPendingListBloodSampleCollection";
		
		String jsp = MSG_BLOOD_SAMPLE_COLLETION + ".jsp";

		map.put("requestHeaderId", requestHeaderId);
		map.put("newRequestId", newRequestId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		map.put("bagNo", bagNo);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitSampleOfBlood(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		 
		Box box = HMSUtil.getBox(request); 
		boolean saved = true;
		int hospitalId = 0;

		String userName = "";

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			System.out.println("hospitalId "+hospitalId);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		int requestHeaderId = 0;
		int newRequestId = 0;
		
		map = bloodBankHandlerService.submitSampleOfBlood(box); 
		if(map.get("saved")!=null){
			saved = (Boolean) map.get("saved");
		}
		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Blood Sample Collection Done Successfully !!";
			map.put("bagNumber", box.get("bagNumber"));
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		} 
		String jsp = "bld_messageSampleOfBlood" + ".jsp"; 
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBloodSampleColletionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int requestId = 0;
		if (request.getParameter("requestId") != null
				&& !(request.getParameter("requestId").equals("0"))) {
			requestId = Integer.parseInt(request.getParameter("requestId"));
			mapForDS.put("requestId", requestId);
		}
		if (requestId != 0) {
			map = bloodBankHandlerService
					.showBloodSampleColletionJsp(requestId);
			String collectionSeqNo = "";
			collectionSeqNo = bloodBankHandlerService
					.getSampleCollectionSeqForDisplay("SCN");
			if (collectionSeqNo != null) {
				map.put("collectionSeqNo", collectionSeqNo);
			}
		}
		jsp = BLOOD_SAMPLE_COLLECTION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -----------Pending Sample Validation--------------------------
	public ModelAndView showPendingSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();*/
		HttpSession session = request.getSession();
		int bloodBankId = 0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			bloodBankId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map=bloodBankHandlerService.showPendingSampleValidationJsp(bloodBankId);
		
		/*detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		patientMap = bloodBankHandlerService.getSampleValidationGrid(mapForDs);*/
		
		jsp = BLOOD_PENDING_SAMPLE_VALIDATION + ".jsp";
		//map.put("detailsMap", detailsMap);
		
	
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView bloodRequestValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();*/
		int bloodrequestHeaderId=0;
		if(null !=request.getParameter("bloodrequestHeaderId")){
			bloodrequestHeaderId=Integer.parseInt(request.getParameter("bloodrequestHeaderId"));
		}
		HttpSession session = request.getSession();
		String deptName = "";
		String userName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
int hospitalId = 0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		/*if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			System.out.println("userName  "+userName);
			//infoMap.put("userName", userName);
		}*/
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		 userName=user.getEmployee().getEmployeeName();
		
		map=bloodBankHandlerService.bloodtRequestValidationJsp(bloodrequestHeaderId,hospitalId );
		
		/*detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		patientMap = bloodBankHandlerService.getSampleValidationGrid(mapForDs);*/
		
		jsp = "patient_bloodrequestValidationJsp.jsp";
		//map.put("detailsMap", detailsMap);
		map.put("userId", userId);
		map.put("userName", userName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView bloodRequestValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		/*Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();*/
		int bloodrequestHeaderId=0;
		if(null !=request.getParameter("bloodrequestHeaderId")){
			bloodrequestHeaderId=Integer.parseInt(request.getParameter("bloodrequestHeaderId"));
		}
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int hospitalId = 0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map=bloodBankHandlerService.bloodtRequestValidationJsp(bloodrequestHeaderId,hospitalId);
		
		/*detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		patientMap = bloodBankHandlerService.getSampleValidationGrid(mapForDs);*/
		
		jsp = "patient_bloodrequestValidationJsp.jsp";
		//map.put("detailsMap", detailsMap);
		
	
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	/** method for validate blood requested by patient
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView validatePatientBloodRequest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean status=false;
		
		String uhidNo="";
		if(null !=request.getParameter("uhidNo")){
			uhidNo=request.getParameter("uhidNo");
		}
		
		int hinId=0;
		if(null !=request.getParameter("hinId")){
			hinId=Integer.parseInt(request.getParameter("hinId"));
		}
		
		int bloodrequestHeaderId=0;
		if(null !=request.getParameter("requestHeaderId")){
			bloodrequestHeaderId=Integer.parseInt(request.getParameter("requestHeaderId"));
			dataMap.put("bloodrequestHeaderId", bloodrequestHeaderId);
		}
		
		String validateStatus="";
		if(null !=request.getParameter("blodvalidate")){
			validateStatus=request.getParameter("blodvalidate");
			dataMap.put("validateStatus", validateStatus);
		}
		String validationTime="";
		if(null !=request.getParameter("validationTime")){
		validationTime=request.getParameter("validationTime");
		dataMap.put("validationTime", validationTime);
		}
	
		int validatedBy=0;
		if(null !=request.getParameter("validatedById")){
			validatedBy=Integer.parseInt(request.getParameter("validatedById"));
			dataMap.put("validatedBy", validatedBy);
		}
		int validatebloodGroupId=0;
		if(null !=request.getParameter("validatebloodGroupId")){
		validatebloodGroupId=Integer.parseInt(request.getParameter("validatebloodGroupId"));
		dataMap.put("validatebloodGroupId", validatebloodGroupId);
		}
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		int containerId=0;
		if(null !=request.getParameter("containerId")){
			containerId=Integer.parseInt(request.getParameter("containerId"));
			dataMap.put("containerId", containerId);
		}
		
		
		status=bloodBankHandlerService.validatePatientBloodRequest(dataMap);
		String message="";
		if(status){
		message="Blood Sample Collection successfully Done.";
		jsp = "msg_bldRequestValidation.jsp";
		}
		else
		{
		message="Some Error Occure. Try Again !!";
		jsp = "patient_bloodrequestValidationJsp.jsp";
		}
		
		map.put("bloodrequestHeaderId", bloodrequestHeaderId);
		map.put("uhidNo", uhidNo);
		map.put("hinId", hinId);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForSampleValidation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String patientLName = "";
		String requestStatus = "";
		String hinNo = "";
		String adNo = "";
		String flag = "";
		String pType = "";

		int sampleId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(REQUEST_STATUS) != null
					&& !(request.getParameter(REQUEST_STATUS).equals("0"))) {
				requestStatus = request.getParameter(REQUEST_STATUS);
				mapForDs.put("requestStatus", requestStatus);
			}

			if (request.getParameter(SAMPLE_COLLECTION_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_ID).equals("0"))) {
				sampleId = new Integer(
						request.getParameter(SAMPLE_COLLECTION_ID));
				mapForDs.put("sampleId", sampleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailSampleValidation(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_PENDING_SAMPLE_VALIDATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBloodSampleValidationJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int sampleId = 0;
		if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleId"));
			mapForDS.put("sampleId", sampleId);
		}
		if (sampleId != 0) {
			map = bloodBankHandlerService
					.showBloodSampleValidationJsp(sampleId);
		}
		jsp = BLOOD_SAMPLE_VALIDATION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitBloodSampleValidation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String diagSeqNo = "";
		String userName = "";
		int noOfRecords = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		int sampleCollectionId = 0;
		int newRequestId = 0;

		sampleCollectionId = Integer.parseInt(request
				.getParameter(SAMPLE_COLLECTION_ID));
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = bloodBankHandlerService
				.submitBloodSampleValidation(parameterMap);
		String message = "";
		if (successfullyUpdated) {
			message = "Sample Validation Done Successfully !!";
		} else {
			message = "Some Problem Occured !! Try Again ..";
		}
		String url1 = "";
		url = "/hms/hms/bloodBank?method=showPendingSampleValidationJsp";
		url1 = "/hms/hms/bloodBank?method=showPendingSampleValidationJsp";

		String jsp = MSG_BLOOD_SAMPLE_VALIDATION + ".jsp";

		map.put("sampleCollectionId", sampleCollectionId);
		map.put("newRequestId", newRequestId);
		map.put("url", url);
		map.put("url1", url1);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView validateResulTestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		int hospitalId = 0;
		String userName = "";
		
		
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			parameterMap.put("userName", userName);
		}
		parameterMap.put("box", box);
		boolean successfullyUpdated = false;
		successfullyUpdated = bloodBankHandlerService
				.validateResulTestEntryt(parameterMap);
		String message = "";
		if (successfullyUpdated) {
			message = "Result Validation Done Successfully !!";
		} else {
			message = "Some Problem Occured !! Try Again ..";
		}
		String url1 = "";
		url = "/hms/hms/bloodBank?method=showPendingForResultValidation";
		url1 = "/hms/hms/bloodBank?method=showPendingForResultValidation";

		String jsp = MSG_BLOOD_SAMPLE_VALIDATION + ".jsp";

		
		map.put("url", url);
		map.put("url1", url1);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------method to Show Pending Blood Sample
	 * Screening-------------------------------------
	 */

	public ModelAndView showDonorPendingSampleScreeningJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		int page = 1;
		int recordsPerPage = 5;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		box.put("page", page);
		box.put("recordsPerPage", recordsPerPage);
		box.put("hospitalId", hospitalId);

		
		map = bloodBankHandlerService.getSampleScreeningTestGrid(box);
		jsp = "bld_donorPendingSampleScreening" + ".jsp";
		/* map.put("detailsMap", detailsMap); */
		// map.put("patientMap", patientMap);
		/* map.put("deptName", deptName); */
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ----method to search Blood Sample Screening----

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForBloodSampleScreening(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientFName = "";
		String sampleStatus = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";

		int sampleId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(SAMPLE_STATUS) != null
					&& !(request.getParameter(SAMPLE_STATUS).equals("0"))) {
				sampleStatus = request.getParameter(SAMPLE_STATUS);
				mapForDs.put("sampleStatus", sampleStatus);
			}

			if (request.getParameter(SAMPLE_COLLECTION_ID) != null
					&& !(request.getParameter(SAMPLE_COLLECTION_ID).equals("0"))) {
				sampleId = new Integer(
						request.getParameter(SAMPLE_COLLECTION_ID));
				mapForDs.put("sampleId", sampleId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailBloodSampleScreening(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForSampleScreeningTest();
		map.put("box", box);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_PENDING_SAMPLE_SCREENING_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -----------method to Show Blood Sample Screening

	public ModelAndView showBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int sampleId = 0;
		if (request.getParameter("sampleId") != null
				&& !(request.getParameter("sampleId").equals("0"))) {
			sampleId = Integer.parseInt(request.getParameter("sampleId"));
			mapForDS.put("sampleId", sampleId);
		}
		if (sampleId != 0) {
			map = bloodBankHandlerService.showBloodSampleScreening(sampleId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService
					.getSampleTestSeqForDisplay("STN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = SAMPLE_SCREENING_TEST + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------method to get test name
	 * -------------------------------------
	 */
	public ModelAndView getTestName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String nameField = "";
		String autoHint = "";
		if (request.getParameter("requiredField") != null) {
			nameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(nameField) != null) {
			autoHint = (request.getParameter(nameField));
		}
		parameterMap.put("autoHint", autoHint);

		map = bloodBankHandlerService.getTestName(parameterMap);
		String jsp = "";
		jsp = "bld_responseForInvestigationName";
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * ----------------------------------method to get data regarding selected
	 * Test -------------------------------------
	 */
	public void fillItemsForInvestigationName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String investigationName = "";
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		try {
			if (request.getParameter("investigationName") != null) {
				investigationName = request.getParameter("investigationName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("investigationName", investigationName);
		map = bloodBankHandlerService.fillItemsForInvestigationName(dataMap);
		if (map.get("investigationList") != null) {
			investigationList = (List) map.get("investigationList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (DgMasInvestigation masInvestigation : investigationList) {
			sb.append("<item>");
			sb.append("<investigationCodeId>" + masInvestigation.getId()
					+ "</investigationCodeId>");
			sb.append("</item>");
		}
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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
	
	
	
	public void populateComponentExpirydetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int  inc = 0;
		int componentId=0;
	
		//List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		
			if (request.getParameter("inc") != null) {
				inc =Integer.parseInt(request.getParameter("inc"));
			}
			if (request.getParameter("componentId") != null) {
				componentId =Integer.parseInt(request.getParameter("componentId"));
			}
		 
		dataMap.put("inc", inc);
		String columnName=null;
		columnName="dateOfBirth"+inc;
		dataMap.put("componentId", componentId);
		map = bloodBankHandlerService.populateComponentExpirydetails(dataMap);
		
		Date expiryDate=null;
				if (map.get("expixyDate") != null) {
					expiryDate = (Date) map.get("expixyDate");
				}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		
			sb.append("<item>");
			sb.append("<expiryDate>" +  HMSUtil.convertDateToStringWithoutTime(expiryDate)
					+ "</expiryDate>");
			sb.append("<colName>" + columnName
					+ "</colName>");
			sb.append("</item>");
		
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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
	

	/**
	 * ----------------------------------method to submit Blood Sample Screening
	 * -------------------------------------
	 */

	public ModelAndView submitBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();

		DgOrderhd dgorderhd=new DgOrderhd();
		List investigationList = new ArrayList();
		String discardsample = "";
		discardsample = request.getParameter("discardsample");

		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();

		HttpSession session = request.getSession();

		String BagNumber = "";
		String TubeNumber = "";
		int samplId = 0;

		Box box = HMSUtil.getBox(request);

		BagNumber = box.get("BagNumber");
		TubeNumber = box.get("TubeNumber");
		samplId = box.getInt("sampleSequenceId");
		
		
		String[] chargeId = request.getParameterValues("chargeId");
		List chargeList = new ArrayList();
		if(null !=chargeId && chargeId.length>0 ){
			for (String charge : chargeId) {
				
				chargeList.add(charge);
			}
			}
		List mainChargeList = new ArrayList();
	
		
		String[] mainchargeId = request.getParameterValues("mainchargeId");
		
		if(null !=mainchargeId && mainchargeId.length>0 ){
			for (String maincharge : mainchargeId) {
				
				mainChargeList.add(maincharge);
			}
			}
		
		String[] selectedItems = request.getParameterValues("selectedTest");
		if(null !=selectedItems && selectedItems.length>0 ){
		for (String selectedItem : selectedItems) {
			
			investigationList.add(selectedItem);
		}
		}
		int sampleTestBy = 0;
		int sampleColelctionId = 0;
		int pageNo = 1;
		int hinId = 0;

		String fitBloodIssue = "";

		String date = "";
		String time = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		/*
		 * if (request.getParameter("scrneeinghdId") != null) {
		 * componentMainIdFromRequest = Integer.parseInt(request
		 * .getParameter("scrneeinghdId")); }
		 */

		String testSeqNo = "";
		testSeqNo = bloodBankHandlerService
				.getDonorSampleTestSeqForDisplay("DSTN");
		/*
		 * if (testSeqNo != null) { map.put("testSeqNo", testSeqNo); }
		 */

		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			sampleTestBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		
		BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();
		BloodResultEntryHeader bloodResultEntryHeader=new BloodResultEntryHeader();
		//DgSampleCollectionHeader dgSampleCollectionHeader= new DgSampleCollectionHeader();
		
		String orderSeqNo = "";
		orderSeqNo = bloodBankHandlerService.getOrderSeqForDisplay("ON",hospitalId);
		dgorderhd.setOrderNo(orderSeqNo);
		if (hinId != 0) {
			
			Patient patient = new Patient();
			patient.setId(hinId);
			sampleScreeningHeader.setHin(patient);
			
			//dgSampleCollectionHeader.setHin(patient);
		}

		if (departmentId != 0) {
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			sampleScreeningHeader.setDepartment(masDepartment);
			//dgSampleCollectionHeader.setDepartment(masDepartment);
			dgorderhd.setDepartment(masDepartment);
			
		}
		if (hospitalId != 0) {
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			sampleScreeningHeader.setHospital(masHospital);
			//dgSampleCollectionHeader.setHospital(masHospital);
			dgorderhd.setHospital(masHospital);
			bloodResultEntryHeader.setHospital(masHospital);
		}

		if (sampleTestBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(sampleTestBy);
			sampleScreeningHeader.setSampleTestBy(masEmployee);
		}

		if (sampleColelctionId != 0) {
			
			BloodSampleCollection bloodSampleCollection = new BloodSampleCollection();
			bloodSampleCollection.setId(sampleColelctionId);
			sampleScreeningHeader.setSampleCollection(bloodSampleCollection);
			bloodResultEntryHeader.setSampleCollection(bloodSampleCollection);
			// dgSampleCollectionHeader.setBloodSampleCollection(bloodSampleCollection);
		}
		sampleScreeningHeader.setSampleTestNo(testSeqNo);
		
		String temp = bloodBankHandlerService.generateSampleTestNumber();

		
		BloodSampleCollection bldsampleCollection=new BloodSampleCollection();

		
		bldsampleCollection.setId(samplId);


		/*sampleScreeningHeader.setSampleCollection(bldsampleCollection);*/
		//dgSampleCollectionHeader.setBloodSampleCollection(bldsampleCollection);
		
		/*sampleScreeningHeader.setBloodIssue("n");*/
		sampleScreeningHeader.setSampleCollection(bldsampleCollection);
		sampleScreeningHeader.setBloodIssue("n");
		bloodResultEntryHeader.setSampleCollection(bldsampleCollection);

		
		if (!discardsample.equalsIgnoreCase("Discard Blood")) {

			sampleScreeningHeader.setResultEntryStatus("P");
			bloodResultEntryHeader.setCgStatus("P");
			bloodResultEntryHeader.setSgStatus("P");
			bloodResultEntryHeader.setResultEntryValidation("P");
		} else {
			sampleScreeningHeader.setResultEntryStatus("D");
			bloodResultEntryHeader.setCgStatus("D");
			bloodResultEntryHeader.setSgStatus("D");
			bloodResultEntryHeader.setResultEntryValidation("D");
			/*dgSampleCollectionHeader.setOrderStatus("P");*/
		}
		
		
		/*sampleScreeningHeader.setSampleTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		
		/*dgSampleCollectionHeader.setBloodSampleCollectionDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		
		/*sampleScreeningHeader.setSampleTestTime(time);*/
		
	//	dgSampleCollectionHeader.setBloodSampleCollectionTime(time);
		
		sampleScreeningHeader.setFitBloodIssue(fitBloodIssue);
		
		sampleScreeningHeader.setLastChgBy(userName);
		
		//dgSampleCollectionHeader.setLastChgBy(user);
		
		/*sampleScreeningHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		//dgSampleCollectionHeader.setDiagnosisDate(HMSUtil.convertStringTypeDateToDateType(date));
		/*dgSampleCollectionHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		
		//dgSampleCollectionHeader.setOrderStatus("P");

		/*sampleScreeningHeader.setLastChgTime(time);*/
		
		//dgSampleCollectionHeader.setLastChgTime(time);
		
		/*dgorderhd.setPatientType("OP");
		dgorderhd.setOrderStatus("P");
		dgorderhd.setOrderTime(time);
		time = (String) utilMap.get("currentTime");
		dgorderhd.setOrderDate(HMSUtil.convertStringTypeDateToDateType(date));*/
		//dgorderhd.setLastChgBy(users);
		
		infoMap.put("mainChargeList", mainChargeList);
		infoMap.put("chargeList", chargeList);
		infoMap.put("dgorderhd", dgorderhd);
		infoMap.put("discardsample", discardsample);
		infoMap.put("investigationList", investigationList);
		
		infoMap.put("bloodResultEntryHeader", bloodResultEntryHeader);
		
		infoMap.put("sampleScreeningHeader", sampleScreeningHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);
		infoMap.put("BagNumber", BagNumber);
		infoMap.put("TubeNumber", TubeNumber);
		infoMap.put("sampleId", samplId);
		//infoMap.put("bldsampleCollection", bldsampleCollection);

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodSampleScreeningTest(infoMap);
		if (saved) {
			message = "Sample Validation  done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = MSG_BLOOD_SCRREEING_TEST + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		
		int bloodBankId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = bloodBankHandlerService.getPendingForBloodIssue(bloodBankId);
		
		jsp = BLD_PENDING_BLOOD_ISSUE + ".jsp";
		
		
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * -----------------method to search Blood Issue -------------------------
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientForBloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String patientLName = "";
		String patientFName = "";
		String bloodIssue = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		String orderNo = "";
		int screeningId = 0;
		int departmentId = 0;
		int inpatientId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals("0"))) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
				mapForDs.put("inpatientId", inpatientId);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(PATIENT_TYPE) != null
					&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
				pType = request.getParameter(PATIENT_TYPE);
				mapForDs.put("pType", pType);
			}
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				mapForDs.put("departmentId", departmentId);
			}

			if (request.getParameter(BLOOD_ISSUE) != null
					&& !(request.getParameter(BLOOD_ISSUE).equals("0"))) {
				bloodIssue = request.getParameter(BLOOD_ISSUE);
				mapForDs.put("bloodIssue", bloodIssue);
			}
			if (request.getParameter(ORDER_NO) != null
					&& !(request.getParameter(ORDER_NO).equals(""))) {
				orderNo = request.getParameter(ORDER_NO);
				mapForDs.put("orderNo", orderNo);
			}
			if (request.getParameter(SAMPLE_SCREENING_HD_ID) != null
					&& !(request.getParameter(SAMPLE_SCREENING_HD_ID)
							.equals("0"))) {
				screeningId = new Integer(
						request.getParameter(SAMPLE_SCREENING_HD_ID));
				mapForDs.put("screeningId", screeningId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getPatientDetailBloodIssue(mapForDs);
		detailsMap = bloodBankHandlerService.getDetailsForBloodIssue();
		map.put("box", box);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLD_PENDING_BLOOD_ISSUE + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int crossMatchingId = 0;
		if (request.getParameter("crossMatchingId") != null
				&& !(request.getParameter("crossMatchingId").equals("0"))) {
			crossMatchingId = Integer.parseInt(request.getParameter("crossMatchingId"));
			mapForDS.put("screeningId", crossMatchingId);
		}
		if (crossMatchingId != 0) {
			map = bloodBankHandlerService.showBloodIssueJsp(crossMatchingId);
			String monthlySeqNo = "";
			monthlySeqNo = bloodBankHandlerService
					.getBloodIssueSeqForDisplay("MIN");
			if (monthlySeqNo != null) {
				map.put("monthlySeqNo", monthlySeqNo);
			}
		}
		jsp = "bld_issueBlood" + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	/*public ModelAndView submitBloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int receivedBy = 0;
		int bloodGroupId = 0;
		int pageNo = 1;
		int hinId = 0;
		int screeningId = 0;

		String monthlySeqNo = "";
		String salRt = "";
		String sal = "";
		String alb = "";
		String ahg = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List stockList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("issuehdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("issuehdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(MONTHLY_ISSUE_NO) != null
				&& !request.getParameter(MONTHLY_ISSUE_NO).equals("")) {
			monthlySeqNo = request.getParameter(MONTHLY_ISSUE_NO);
		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));
		}
		if (request.getParameter(RECEIVED_BY) != null
				&& !request.getParameter(RECEIVED_BY).equals("0")) {
			receivedBy = Integer.parseInt(request.getParameter(RECEIVED_BY));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}

		if (request.getParameter(SAL) != null) {
			sal = "y";
		} else {
			sal = "n";
		}
		if (request.getParameter(SAL_RT) != null) {
			salRt = "y";
		} else {
			salRt = "n";
		}
		if (request.getParameter(AHG) != null) {
			ahg = "y";
		} else {
			ahg = "n";
		}
		if (request.getParameter(ALB) != null) {
			alb = "y";
		} else {
			alb = "n";
		}
		if (request.getParameter(SAMPLE_SCREENING_HD_ID) != null
				&& !request.getParameter(SAMPLE_SCREENING_HD_ID).equals("0")) {
			screeningId = Integer.parseInt(request
					.getParameter(SAMPLE_SCREENING_HD_ID));
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

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodIssueHeader bloodIssueHeader = new BloodIssueHeader();
		if (screeningId != 0) {
			BloodSampleScreeningHeader sampleScreeningHeader = new BloodSampleScreeningHeader();
			sampleScreeningHeader.setId(screeningId);
			bloodIssueHeader.setScreeningHd(sampleScreeningHeader);
		}
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			bloodIssueHeader.setHin(patient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			bloodIssueHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodIssueHeader.setHospital(masHospital);
		}

		if (issuedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(issuedBy);
			bloodIssueHeader.setIssuedBy(masEmployee);
		}

		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			bloodIssueHeader.setReceivedBy(masEmployee);
		}
		if (crossMatchedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossMatchedBy);
			bloodIssueHeader.setMatchedBy(masEmployee);
		}
		if (bloodGroupId != 0) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(bloodGroupId);
			bloodIssueHeader.setBloodGroup(masBloodGroup);
		}
		bloodIssueHeader.setMonthlyNo(monthlySeqNo);
		String temp = bloodBankHandlerService.generateMonthlyNumber();

		bloodIssueHeader.setSal(sal);
		bloodIssueHeader.setSalRt(salRt);
		bloodIssueHeader.setAhg(ahg);
		bloodIssueHeader.setAlb(alb);
		bloodIssueHeader.setIssueDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodIssueHeader.setIssueTime(time);
		bloodIssueHeader.setLastChgBy(userName);
		bloodIssueHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		bloodIssueHeader.setLastChgTime(time);
		infoMap.put("bloodIssueHeader", bloodIssueHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("screeningId", screeningId);
		infoMap.put("hinId", hinId);
		infoMap.put("monthlySeqNo", monthlySeqNo);

		try {

			Vector stock_detail_id = box.getVector(STOCK_DETAIL_ID);
			for (int i = 0; i < stock_detail_id.size(); i++) {
				if (!stock_detail_id.get(i).equals("")) {
					stockList.add(stock_detail_id.get(i));
				}
			}

			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("stockList", stockList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		String jsp = "";
		String message = "";
		if (returnMap.get("monthlySeqNo") != null) {
			monthlySeqNo = (String) returnMap.get("monthlySeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodIssue(infoMap);
		if (saved) {
			message = "Blood Issue has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showPendingBloodIssueJsp";

		jsp = BLD_MSG_BLOOD_ISSUE + ".jsp";
		map.put("monthlySeqNo", monthlySeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
*/
	// ----------Blood Strock Opening Balance---------------
	public ModelAndView submitBloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			
		}
		int deptId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		
		int empId = (Integer) session.getAttribute("empId");
		box.put("userId", userId);
		box.put("empId", empId);
		
		/*int crossMatchHeaderName=0;
		if (request.getParameter("crossMatchHeaderName") != null) {
			crossMatchHeaderName = Integer.parseInt( request.getParameter("crossMatchHeaderName"));
			box.put("hospitalId", hospitalId);
		}
		int bldrequestheaderId=0;
		if (request.getParameter("bldrequestheaderId") != null) {
			bldrequestheaderId = Integer.parseInt( request.getParameter("bldrequestheaderId"));
			box.put("bldrequestheaderId", bldrequestheaderId);
		}*/

		
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List stockList = new ArrayList();

		/*HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));*/
	


		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodIssue(box);
		if (saved) {
			message = "Blood Issue  done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showPendingBloodIssueJsp";

		jsp = BLD_MSG_BLOOD_ISSUE + ".jsp";
		
		map.put("url", url);
		
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showStockOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showStockOpeningBalance();
		session = request.getSession();
		String stockSeqNo = "";
		stockSeqNo = bloodBankHandlerService.getStockSeqNoForDisplay("SN");
		jsp = BLD_STOCK_OPENING_BALANCE;
		jsp += ".jsp";
		map.put("stockSeqNo", stockSeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitStockOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> paraMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		boolean saved = false;
		String message = "";
		int hospitalId = 0;
		int noOfRecords = 0;
		int deptId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			infoMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			infoMap.put("deptId", deptId);
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		infoMap.put("box", box);
		map = bloodBankHandlerService.submitStockOpeningBalance(infoMap);
		saved = (Boolean) map.get("saved");

		if (saved == true) {
			message = "Data saved Successfully !!";
		} else {
			message = "Try Again!";
		}

		/*
		 * String stockSeqNo = ""; if (infoMap.get("stockSeqNo") != null) {
		 * stockSeqNo = (String) infoMap.get("stockSeqNo"); }
		 */
		url = "/hms/hms/bloodBank?method=showStockOpeningBalance";

		String jsp = BLD_MSG_STOCK_OPENING + ".jsp";

		map.put("message", message);
		// map.put("stockSeqNo", stockSeqNo);
		map.put("url", url);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	// ----------Blood Donation Entry---------------
	public ModelAndView showBloodDonationEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		String donoruhid = "";
		Box box = HMSUtil.getBox(request);

		int hospitalId = 0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		
		if (request.getParameter("donoruhid") != null) {
			donoruhid = request.getParameter("donoruhid");
			map.put("donoruhid", donoruhid);
		}
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodDonationEntryJsp(box);
		String donationSeqNo = "";
		donationSeqNo = bloodBankHandlerService
				.getDonationSeqNoForDisplay("BDN");
		if (donationSeqNo != null) {
			map.put("donationSeqNo", donationSeqNo);
		}

		jsp = BLOOD_DONATION_ENTRY;
		jsp += ".jsp";
		title = "BloodDonationEntry";
		map.put("donoruhid", donoruhid);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	// -------------------Blood Discrad Entry-----------------------------------
	public ModelAndView showPendingBloodDiscard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapForDs.put("hospitalId", hospitalId);
		patientMap = bloodBankHandlerService.showPendingBloodDiscard(mapForDs);
		jsp = BLD_PND_DISCARD + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showBloodDiscardJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodStockDetailId = 0;
		if (request.getParameter("bloodStockDetailId") != null
				&& !(request.getParameter("bloodStockDetailId").equals("0"))) {
			bloodStockDetailId = Integer.parseInt(request
					.getParameter("bloodStockDetailId"));
			mapForDS.put("bloodStockDetailId", bloodStockDetailId);
		}
		if (bloodStockDetailId != 0) {
			map = bloodBankHandlerService
					.showBloodDiscardJsp(bloodStockDetailId);
			String discardSeqNo = "";
			discardSeqNo = bloodBankHandlerService
					.getDiscardSeqForDisplay("DSN");
			if (discardSeqNo != null) {
				map.put("discardSeqNo", discardSeqNo);
			}
		}
		jsp = BLD_DISCARD_ENTRY + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitBloodDiscard(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodDiscardEntry bloodDiscardEntry = new BloodDiscardEntry();
		Date currentDate = new Date();
		Date discardDate = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		Box box = HMSUtil.getBox(request);
		map.put("box", box);
		String discardSeqNo = "";
		String remarks = "";
		int approvedBy = 0;
		int stockDetailId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			bloodDiscardEntry.setHospital(masHospital);
		}
		bloodDiscardEntry.setDiscardNo(discardSeqNo);
		String temp = bloodBankHandlerService.generateDiscardNumber();

		if (request.getParameter(REMARKS) != null
				&& !request.getParameter(REMARKS).equals("")) {
			remarks = request.getParameter(REMARKS);
			bloodDiscardEntry.setRemarks(remarks);
		}

		if (request.getParameter(APPROVED_BY) != null
				&& !request.getParameter(APPROVED_BY).equals("0")) {
			approvedBy = Integer.parseInt(request.getParameter(APPROVED_BY));
			if (approvedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(approvedBy);
				bloodDiscardEntry.setApprovedBy(masEmployee);
			}
		} else {
			if (session.getAttribute("empId") != null) {
				approvedBy = (Integer) session.getAttribute("empId");
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(approvedBy);
				bloodDiscardEntry.setApprovedBy(masEmployee);
			}
		}
		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			bloodDiscardEntry.setDepartment(masDepartment);
		}
		if (request.getParameter(STOCK_DETAIL_ID) != null
				&& !request.getParameter(STOCK_DETAIL_ID).equals("0")) {
			stockDetailId = Integer.parseInt(request
					.getParameter(STOCK_DETAIL_ID));
		}
		if (stockDetailId != 0) {
			BloodStockDetail stockDetail = new BloodStockDetail();
			stockDetail.setId(stockDetailId);
			bloodDiscardEntry.setStockDetail(stockDetail);

		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			//bloodDiscardEntry.setLastChgBy(userName);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			bloodDiscardEntry.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			bloodDiscardEntry.setLastChgTime(time);
		}
		if (request.getParameter(DISCARD_DATE) != null
				&& !(request.getParameter(DISCARD_DATE).equals(""))) {
			discardDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DISCARD_DATE));
			bloodDiscardEntry.setDiscardDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (session.getAttribute(CHANGED_BY) != null) {
			userName = (String) session.getAttribute(CHANGED_BY);
		}
		parameterMap.put("stockDetailId", stockDetailId);
		parameterMap.put("bloodDiscardEntry", bloodDiscardEntry);
		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodDiscard(parameterMap);
		mapForDs.put("hospitalId", hospitalId); //Added by arbind on 11-10-2017
		patientMap = bloodBankHandlerService.showPendingBloodDiscard(mapForDs);
		if (saved) {
			message = "Blood Discard Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_PND_DISCARD + ".jsp";
		map.put("url", url);
		map.put("approvedBy", approvedBy);
		map.put("userName", userName);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("discardSeqNo", discardSeqNo);
		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------Blood Test Entry-----------------------------------

	/**
	 * Method for result Entry
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showBloodTestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String bagNum = null;
		String tubNum = null;
		String quantityNum = null;
		// trettttt
		String samplId = request.getParameter("samplId");
		if (null != samplId && !samplId.isEmpty()) {

			bagNum = request.getParameter("bagNum" + samplId);
			tubNum = request.getParameter("tubNum" + samplId);
			quantityNum = request.getParameter("quantityNum" + samplId);

		}
		map = bloodBankHandlerService.showBloodTestEntryJsp();
		String serialSeqNo = "";
		serialSeqNo = bloodBankHandlerService.getSerialSeqForDisplay("TSN");
		if (serialSeqNo != null) {
			map.put("serialSeqNo", serialSeqNo);
		}
		jsp = BLD_TEST_ENTRY;
		jsp += ".jsp";
		map.put("bagNum", bagNum);
		map.put("tubNum", tubNum);
		map.put("quantityNum", quantityNum);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}

		map.put("hinNo", hinNo);
		map = bloodBankHandlerService.getPatientList(hinNo);
		jsp = BLD_TEST_ENTRY;
		jsp += ".jsp";
		// map.put("hinId",hinId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// --------------------------Reports-----------------------------------------
	// ----------------------Stock Ledger----------------------------------
	public ModelAndView showStockLedgerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "blood Stock Ledger";

		jsp = BLD_STOCK_LEDGER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printStockLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_stockLedger", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ----------------------ABO & RH Grouping-------------------------
	public ModelAndView showAboRhReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Abo Rh Grouping";

		jsp = BLD_ABORH_GROUPING;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printAboRhReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_AboRhReport", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------------------------Blood Issue
	// Register----------------------------
	public ModelAndView showBloodIssueRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "blood Issue register";

		jsp = BLD_ISSUE_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBloodIssueRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_issue_register", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView printBloodCollectionIssueRegister(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_collectionIssueRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------Compatibility Register----------------------------
	public ModelAndView showCompatibilityRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Compatibility Register";

		jsp = BLD_COMPATIBILITY_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// --------"Direct Indirect TestRegister--------
	public ModelAndView showDirectIndirectRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = bloodBankHandlerService.showDirectIndirectRegisterReport();
		title = "Direct Indirect Test Register";
		jsp = BLD_DIRECT_INDIRECT_TEST_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDirectIndirectRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();
		String investigationName = "";
		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(INVESTIGATION_NAME) != null
					&& !(request.getParameter(INVESTIGATION_NAME).equals(""))) {
				investigationName = request.getParameter(INVESTIGATION_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("investigationName", investigationName);
		try {
			HMSUtil.generateReport("blood_directIndirectTestRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------Cell Serum Screening Register-----------
	public ModelAndView showCellSerumScreeningReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Cell Serum Screening Register";

		jsp = BLD_CELL_SERUM_SCREENING_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// -------------------------Vdrl Test Register---------------------------
	public ModelAndView showVdrlTestRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Vdrl Test Register";

		jsp = BLD_VDRL_TEST_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printVdrlTestRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {
		Date fromDate = new Date();
		Date toDate = new Date();

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		try {
			HMSUtil.generateReport("blood_vdrlTestRegister", map,
					(Connection) map.get("con"), response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView editBloodBank(HttpServletRequest request,
			HttpServletResponse response) {
		
		boolean saveStatus=false;
		String message="";
		
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> dataMap=new HashMap<String,Object>();
		
		Box box=HMSUtil.getBox(request);
		
		
		map = bloodBankHandlerService.editBloodBank(box);
		
		saveStatus=(Boolean)map.get("saveStatus"); 
		if(saveStatus){
			message="Data Updated successfully !!";
		}
		else{
			message="Some problem occure";
		}
		
		jsp = "bld_bloodBankRegistry";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
		
		
	}
	
	// ------Collection Issue Register---------------------------
	public ModelAndView showCollectionIssueRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Collection Issue Register";

		jsp = BLD_COLLECTION_ISSUE_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// -----Record Proforma Register----------------------------
	public ModelAndView showRecordProformaRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Record Proforma Register";

		jsp = BLD_RECORD_PROFORMA_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPateintDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		String flag = "";
		List<Patient> patientList = new ArrayList<Patient>();
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}
		patientList = bloodBankHandlerService.getPateintDetail(hinNo);
		if (patientList.size() > 0) {
			map.put("patientList", patientList);
		}
		String jsp = BLD_STOCK_OPENING_BALANCE;
		return new ModelAndView(jsp, "map", map);
	}

	// ----------------For Submit to bloodDonation Entry--------------------
	/**
	 * For Blood Donor Registration
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 */
	public ModelAndView submitBloodDonationEntry(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		int userId=0;
		if(null !=session.getAttribute("userId")){
		userId = (Integer) session.getAttribute("userId");
		Users user = new Users();
		user.setId(userId);
		}
		Box box = HMSUtil.getBox(request);

		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();

		int donationhdId = 0;
		int donationMainIdFromRequest = 0;
		int noOfRecords = 0;
		int hinId = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int occupationId = 0;
		int stateId = 0;
		int numberOfTime = 0;

		int uhid = 0;
		int identityCard = 0;
		String idNo = "";

		int sexId = 0;
		String organization = "";
		String teleNo = "";
		String mobNo = "";
		String date = "";
		String time = "";
		String donationSeqNo = "";
		String donerName = "";
		String donerType = "";
		String fatherName = "";
		String husbandName = "";
		String previouslyDonated = "";

		String smthingEat = "";
		String MobileNo = "";
		String dob = "";

		int bloodDonationId = 0;
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			donationEntryHeader.setHospital(masHospital);
		}
		if (request.getParameter("donationhdId") != null) {
			donationMainIdFromRequest = Integer.parseInt(request
					.getParameter("donationhdId"));
		}

		donationSeqNo = bloodBankHandlerService.generateDonationNumber();
		
		
		//donationEntryHeader.setDonationNo(donationSeqNo);
		int uid = 0;
		if (request.getParameter(UID) != null
				&& !request.getParameter(UID).equals("")) {
			// uid = Integer.parseInt(request.getParameter(UID));
			// if (UID != null) {
			/*
			 * Patient patient = new Patient(); patient.setId(hinId);
			 * donationEntryHeader.setHin(patient);
			 */
			donationEntryHeader.setUhidNo(request.getParameter(UID));
			// }
		}

		if (request.getParameter(DATE_OF_BIRTH) != null
				&& !request.getParameter(DATE_OF_BIRTH).equals("")) {
			dob = request.getParameter(DATE_OF_BIRTH);

			donationEntryHeader.setDateOfBirth(HMSUtil
					.convertStringTypeDateToDateType(dob));
		}

		if (request.getParameter(Identity_Card) != null	
				&& !request.getParameter(Identity_Card).equals("")) {
			identityCard = Integer
					.parseInt(request.getParameter(Identity_Card));
			MasIdCard idcard = new MasIdCard();
			idcard.setId(identityCard);
			donationEntryHeader.setIdentityCard(idcard);
		}

		if (request.getParameter(ID_NO) != null
				&& !request.getParameter(ID_NO).equals("")) {
			idNo = request.getParameter(ID_NO);

			donationEntryHeader.setIdentityCardNo(idNo);
		}

		if (request.getParameter(MOBILE_NO) != null
				&& !request.getParameter(MOBILE_NO).equals("")) {
			MobileNo = request.getParameter(MOBILE_NO);
			donationEntryHeader.setMobNo(MobileNo);
		}
		if (request.getParameter(DONOR_NAME) != null
				&& !request.getParameter(DONOR_NAME).equals("")) {
			donerName = request.getParameter(DONOR_NAME);
			donationEntryHeader.setDonerName(donerName);
		}
		if (request.getParameter(DONER_TYPE) != null
				&& !request.getParameter(DONER_TYPE).equals("")) {
			donerType = request.getParameter(DONER_TYPE);
			donationEntryHeader.setDonerType(donerType);
		}
		if (request.getParameter(FATHER_NAME) != null
				&& !request.getParameter(FATHER_NAME).equals("")) {
			fatherName = request.getParameter(FATHER_NAME);
			donationEntryHeader.setFatherName(fatherName);
		}

		if (request.getParameter(OCCUPATION_ID) != null
				&& !request.getParameter(OCCUPATION_ID).equals("0")) {
			occupationId = Integer
					.parseInt(request.getParameter(OCCUPATION_ID));
			if (occupationId != 0) {
				MasOccupation masOccupation = new MasOccupation();
				masOccupation.setId(occupationId);
				donationEntryHeader.setOccupation(masOccupation);
			}
		}

		if (request.getParameter(ORGANIZATION) != null
				&& !request.getParameter(ORGANIZATION).equals("")) {
			organization = request.getParameter(ORGANIZATION);
			donationEntryHeader.setOrganization(organization);
		}

		if (request.getParameter(SEX_ID) != null
				&& !request.getParameter(SEX_ID).equals("")) {
				sexId = Integer.parseInt(request.getParameter(SEX_ID));
			if (sexId != 0) {
				MasAdministrativeSex administrativeSex = new MasAdministrativeSex();
				administrativeSex.setId(sexId);
				donationEntryHeader.setSex(administrativeSex);
			}
		}

		if (request.getParameter(AGE) != null
				&& !request.getParameter(AGE).equals("")) {
			String age = request.getParameter(AGE);
			donationEntryHeader.setAge(age);

		}

		if (request.getParameter(TELE_NO) != null) {
			teleNo = request.getParameter(TELE_NO);
			donationEntryHeader.setTelNo(teleNo);
		}

		String houseAprtno = null;
		if (request.getParameter(House_NO) != null) {
			houseAprtno = request.getParameter(House_NO);
			donationEntryHeader.setHouseAptNo(houseAprtno);
		}

		String landMark = null;
		if (request.getParameter(Land_Mark) != null) {
			landMark = request.getParameter(Land_Mark);
			donationEntryHeader.setLandMark(landMark);
		}

		if (request.getParameter(STATE_ID) != null
				&& !request.getParameter(STATE_ID).equals("0")) {
			stateId = Integer.parseInt(request.getParameter(STATE_ID));
			if (stateId != 0) {
				MasState masState = new MasState();
				masState.setId(stateId);
				donationEntryHeader.setState(masState);
			}
		}

		int districtId = 0;

		if (request.getParameter(DISTRICT_NAME) != null
				&& !request.getParameter(DISTRICT_NAME).equals("")) {
			districtId = Integer
					.parseInt(request.getParameter(DISTRICT_NAME));
			MasDistrict district=new MasDistrict();
			district.setId(districtId);
			donationEntryHeader.setDistrict(district);
		}

		long subDistrictName = 0;
		if (request.getParameter(Sub_District_NAME) != null
				&& !request.getParameter(Sub_District_NAME).equals("")) {
			subDistrictName = Integer.parseInt(request
					.getParameter(Sub_District_NAME));
			donationEntryHeader.setSubDistrict(subDistrictName);
		}

		String lsgType = null;
		String hinNo="";
		

		if (request.getParameter(Lsg_Type) != null
				&& !request.getParameter(Lsg_Type).equals("")) {
			lsgType = request.getParameter(Lsg_Type);
			donationEntryHeader.setLsgType(lsgType);
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
			donationEntryHeader.setUhidNo(hinNo);
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patient=new Patient();
			patient.setId(hinId);
			donationEntryHeader.setHin(patient);
		}
		
		
		
		int  postOffice = 0;
		if (request.getParameter(Post_Office_Name) != null
				&& !request.getParameter(Post_Office_Name).equals("")) {
			postOffice = Integer.parseInt(request
					.getParameter(Post_Office_Name));
			MasPostCode postcode=new MasPostCode();
			postcode.setId(postOffice);
			
			donationEntryHeader.setPostOffice(postcode);
		}

		String email = null;

		if (request.getParameter(EMAIL) != null
				&& !request.getParameter(EMAIL).equals("")) {
			email = request.getParameter(EMAIL);
			donationEntryHeader.setEmail(email);
		}
		String pinCode = null;

		if (request.getParameter(Pincode) != null
				&& !request.getParameter(Pincode).equals("")) {
			pinCode = request.getParameter(Pincode);
			donationEntryHeader.setPinCode(pinCode);
		}
		/*
		 * if (request.getParameter(MOBILE_NO) != null &&
		 * !request.getParameter(MOBILE_NO).equals("")) { mobNo =
		 * request.getParameter(MOBILE_NO); donationEntryHeader.setMobNo(mobNo);
		 * }
		 */

		if (request.getParameter(BLOOD_GROUP_NAME) != null
				&& !request.getParameter(BLOOD_GROUP_NAME).equals("")) {
			int bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_NAME));
			if (bloodGroupId != 0) {
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				donationEntryHeader.setBloodGroup(masBloodGroup);
			}
		}
		if(null != request.getParameter("RhFactor") && !request.getParameter("RhFactor").equals("0")){
			
			donationEntryHeader.setRhFactor(request.getParameter("RhFactor"));
		}
		Date currentDate=null;
		currentDate=new Date();
		donationEntryHeader.setRegistrationDate(currentDate);

		if (bloodDonationId != 0) {
			infoMap.put("bloodDonationId", bloodDonationId);
		}
		infoMap.put("donationhdId", donationhdId);
		infoMap.put("donationEntryHeader", donationEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("donationSeqNo", donationSeqNo);

		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		
		if (returnMap.get("donationSeqNo") != null) {
			donationSeqNo = (String) returnMap.get("donationSeqNo");
		}
		 
		boolean saved = false;
		boolean bBAvailabilityStatus=false;
		boolean duplicateRegistration=false;
		
		map = bloodBankHandlerService.submitBloodDonationEntry(infoMap);
		if(null !=map.get("bBAvailabilityStatus"))
		bBAvailabilityStatus=(Boolean)map.get("bBAvailabilityStatus");
		

		if(null !=map.get("duplicateRegistration"))
			duplicateRegistration=(Boolean)map.get("duplicateRegistration");
			
		
		if(null !=map.get("saved"))
		saved=(Boolean)map.get("saved");
		
		if(null !=map.get("tmpDonorRegNo"))
			donationSeqNo=(String)map.get("tmpDonorRegNo");
			
		if(!bBAvailabilityStatus){
			message = "This Hospital do not have blood bank ";
		}else{
		if (saved && !duplicateRegistration) {
			message = "Donor registration  done Successfully !!"
					+ "Registration Number is  " + donationSeqNo;
		} 
		else {
			message = "Donor already registered";
		}
		}
		map.put("message", message);
		url = "/hms/hms/bloodBank?method=showBloodDonationEntryJsp";
		jsp = BLD_MSG_DONATION + ".jsp";

		map.put("duplicateRegistration", duplicateRegistration);
		map.put("donationhdId", donationhdId);
		map.put("donationSeqNo", donationSeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * save Donor Assessstment Details
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitDonarAssessment(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infomap = new HashMap<String, Object>();
		Map<String, Object> assesstmentMap = new HashMap<String, Object>();

		List<String> temporaryNameList = new ArrayList<String>();
		List<String> permanentlyNameList = new ArrayList<String>();

		BloodDonationEntryHeader donationEntryHeader = new BloodDonationEntryHeader();
		BloodAssessmentEntryM assessmentEntryM = new BloodAssessmentEntryM();
		Set<BloodAssessmentEntryT> assesstmentEntryT = new HashSet<BloodAssessmentEntryT>();
		/*
		 * Map<String,Object> temDonorDeferMap=null; Map<String,Object>
		 * permananetlyDonorDeferMap=null;
		 */

		String donorRegistrationNum = "";
		int assesstmentId = 0;
		String assesstmentType = "";
		int donorSequenceNumer = 0;
		int assesstmentMid = 0;
		String deferredStatus = null;
		String donorRegNumber = null;
		String donorAssesstMid = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		
		
		/* int donorSerialNum=0; */
		donorSequenceNumer = Integer.parseInt(request
				.getParameter("donorSerialNum"));
		

		donorAssesstMid = request.getParameter("assesstmentMid");
		donorRegNumber = request.getParameter("registerNum");
		
		String uhidNo="";
		if(null !=request.getParameter("uhidNo") && !request.getParameter("uhidNo").equals("")){
			uhidNo=request.getParameter("uhidNo");
		}

		String cellGroupRequired="";
		if(null !=request.getParameter("cellGroupingRequest") && request.getParameter("cellGroupingRequest").equals("y")){
			cellGroupRequired="y";
		}
		else{
			cellGroupRequired="n";
		}
		assessmentEntryM.setCellGroupingRequest(cellGroupRequired);
		
		if (donorSequenceNumer > 0) {
			donationEntryHeader.setId(donorSequenceNumer);
			assessmentEntryM.setDonation(donationEntryHeader);
		}
		assessmentEntryM.setBldCollectionStatus("P");
		
		assessmentEntryM.setBloodBank(hospital);
		assesstmentMid = bloodBankHandlerService
				.saveAssesstmentEntryHeader(assessmentEntryM);

		assessmentEntryM.setAssessmentDate(new Date());
		assesstmentMap = (Map<String, Object>) bloodBankHandlerService
				.showAssesstmentList(uhidNo);
		List<MasAssessment> massAssesstmntList = new ArrayList<MasAssessment>();

		if (null != assesstmentMap && !assesstmentMap.isEmpty()) {
			massAssesstmntList = (List<MasAssessment>) assesstmentMap
					.get("assesstmentDetailList");
		}

		String result = null;

		for (MasAssessment assesstment : massAssesstmntList) {
			if (request.getParameter(assesstment.getAssessmentName()) != null
					&& !request.getParameter(assesstment.getAssessmentName())
							.equals("")) {
				MasAssessment massAssestment = new MasAssessment();

				assessmentEntryM.setId(assesstmentMid);
				assesstmentType = request.getParameter(assesstment
						.getAssessmentType()
						+ Integer.parseInt(request.getParameter(String
								.valueOf(assesstment.getId()))));
				
				result = request.getParameter(assesstment.getAssessmentName());
				massAssestment.setId(Integer.parseInt(request
						.getParameter(String.valueOf(assesstment.getId()))));
				assesstmentEntryT.add(new BloodAssessmentEntryT(result,
						massAssestment, assessmentEntryM));
				String assesstValue = request.getParameter(assesstment
						.getAssessmentName());
				if (assesstmentType.trim().equalsIgnoreCase("Temporary")
						&& assesstValue.equalsIgnoreCase("y")) {

					temporaryNameList.add(request.getParameter(assesstment
							.getAssessmentName()
							+ Integer.parseInt(request.getParameter(String
									.valueOf(assesstment.getId())))));

				}
				if (assesstmentType.equalsIgnoreCase("Permanently")
						&& assesstValue.equalsIgnoreCase("y")) {
					permanentlyNameList.add(request.getParameter(assesstment
							.getAssessmentName()
							+ Integer.parseInt(request.getParameter(String
									.valueOf(assesstment.getId())))));

				}

			}
			//System.out.println("temporaryNameList  "+temporaryNameList.size() +"permanentlyNameList "+permanentlyNameList.size());
			if (null != temporaryNameList && temporaryNameList.size()>0  && permanentlyNameList.isEmpty()) {
				deferredStatus = "Temporar";
			}
			else if (null != permanentlyNameList
					&& !permanentlyNameList.isEmpty()) {
				deferredStatus = "Permanen";
			} else {
				deferredStatus = "Non ";
			}
		}
//System.out.println("deferredStatus +++++ @@@@  "+deferredStatus);
		infomap.put("cellGroupRequired", cellGroupRequired);
		infomap.put("donorSequenceNumer", donorSequenceNumer);
		infomap.put("donorRegNumber", donorRegNumber);
		infomap.put("deferredStatus", deferredStatus);
		infomap.put("assesstmentMid", assesstmentMid);
		infomap.put("assesstmentEntryT", assesstmentEntryT);
		infomap.put("hospitalId", hospitalId);

		boolean saved = false;
		String statusMessage = "";
		saved = bloodBankHandlerService.submitDonerAssesstmentEntry(infomap);
		if (saved) {
			statusMessage = " Donor Assesstment has been done Successfully !!";
		} else {
			statusMessage = "Try Again!";
		}
		map.put("assesstmentDetailList", massAssesstmntList);
		map.put("assesstmentMid", assesstmentMid);
		map.put("statusMessage", statusMessage);
		map.put("temporaryNameList", temporaryNameList);
		map.put("permanentlyNameList", permanentlyNameList);
		map.put("donorAssesstMid", donorAssesstMid);

		url = "/hms/hms/bloodBank?method=showDonorAssessmentJsp";
		jsp = "bld_MsgDonoorAssessment" + ".jsp";

		map.put("url", url);
		map.put("formName", "donorAssessment");
		map.put("message", statusMessage);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * Method to save Donor Deferred Detail
	 * 
	 * @param donationEntryHeader
	 * 
	 */
	public ModelAndView submitDonorDeferredStatus(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String,Object> map=new HashMap<String,Object>();
		boolean status = false;
		String message = "";
		String assesstmentMid = request.getParameter("assesstmentMid");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map.put("box", box);
		
		
	map=bloodBankHandlerService.submitDonorDeferredStatus(box);
	status=(Boolean)map.get("save");
		if (status) {
			message = "Physical Examination Done SuccessFully. Do you want to print patient declaration form ?";
		} else {
			message = "error";
		}
		int donorAsstId=box.getInt("donorAssesstMid");
		
		jsp = "bld_MsgPhysicalExam" + ".jsp";
		//jsp = "bld_MsgDonoorAssessment" + ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("assesstmentMid", assesstmentMid);
		map.put("donorAsstId", donorAsstId);
		return new ModelAndView("index", "map", map);

	}

	
	// ------Donor Blood Pending For Sample Screening-------
	/*
	 * public ModelAndView showDonorPendingSampleScreeningJsp(
	 * HttpServletRequest request, HttpServletResponse response) { Map<String,
	 * Object> detailsMap = new HashMap<String, Object>(); Map<String, Object>
	 * patientMap = new HashMap<String, Object>(); Map<String, Object> mapForDs
	 * = new HashMap<String, Object>(); HttpSession session =
	 * request.getSession(); String deptName = ""; if
	 * (session.getAttribute("deptName") != null) { deptName = (String)
	 * session.getAttribute("deptName"); } detailsMap = bloodBankHandlerService
	 * .getDetailsForDonorSampleScreening(); patientMap =
	 * bloodBankHandlerService .getDonorSampleScreeningGrid(mapForDs); jsp =
	 * DONOR_PENDING_SAMPLE_SCREENING + ".jsp"; map.put("detailsMap",
	 * detailsMap); map.put("patientMap", patientMap); map.put("deptName",
	 * deptName); map.put("contentJsp", jsp); return new ModelAndView("index",
	 * "map", map); }
	 */

	public ModelAndView showBillInstituteWiseServices(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		detailsMap = bloodBankHandlerService
				.getDetailsForDonorSampleScreening();
		patientMap = bloodBankHandlerService
				.getDonorSampleScreeningGrid(mapForDs);
		jsp = DONOR_PENDING_SAMPLE_SCREENING + ".jsp";
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------Search -Donor Deatil For Sample
	// Screening--------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView searchDonorForBloodSampleScreening(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = new Date();
		Date toDate = new Date();
		String screeningStatus = "";
		String hinNo = "";
		String adNo = "";
		String donationNo = "";
		String patName = "";

		int donationId = 0;
		int hinId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();

		try {

			if (session.getAttribute("deptName") != null) {
				deptName = (String) session.getAttribute("deptName");
			}

			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals("0"))) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(FROM_DATE));
				mapForDs.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(TO_DATE));
				mapForDs.put("toDate", toDate);
			}
			if (request.getParameter(DONATION_NO) != null
					&& !(request.getParameter(DONATION_NO).equals(""))) {
				donationNo = request.getParameter(DONATION_NO);
				mapForDs.put("donationNo", donationNo);
			}
			if (request.getParameter(AD_NO) != null
					&& !(request.getParameter(AD_NO).equals(""))) {
				adNo = request.getParameter(AD_NO);
				mapForDs.put("adNo", adNo);
			}
			if (request.getParameter(DONOR_NAME) != null
					&& !(request.getParameter(DONOR_NAME).equals(""))) {
				patName = request.getParameter(DONOR_NAME);
				mapForDs.put("patName", patName);
			}
			if (request.getParameter(SCREENING_STATUS) != null
					&& !(request.getParameter(SCREENING_STATUS).equals("0"))) {
				screeningStatus = request.getParameter(SCREENING_STATUS);
				mapForDs.put("screeningStatus", screeningStatus);
			}

			if (request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID) != null
					&& !(request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID)
							.equals("0"))) {
				donationId = new Integer(
						request.getParameter(BLOOD_DONATION_ENTRY_HEADER_ID));
				mapForDs.put("donationId", donationId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		patientMap = bloodBankHandlerService
				.getDonorDetailBloodSampleScreening(mapForDs);
		map.put("box", box);
		map.put("deptName", deptName);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = DONOR_PENDING_SAMPLE_SCREENING + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDonorSampleScreeningJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int donationId = 0;
		if (request.getParameter("donationId") != null
				&& !(request.getParameter("donationId").equals("0"))) {
			donationId = Integer.parseInt(request.getParameter("donationId"));
			mapForDS.put("donationId", donationId);
		}
		if (donationId != 0) {
			map = bloodBankHandlerService
					.showDonorBloodSampleScreeningTest(donationId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService
					.getDonorSampleTestSeqForDisplay("DSTN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = DONOR_SAMPLE_SCREENING + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDonorBloodSampleScreeningTest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int sampleTestBy = 0;
		int donationId = 0;
		int pageNo = 1;
		int hinId = 0;

		String testSeqNo = "";
		String date = "";
		String time = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();
		List resultList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("scrneeinghdId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("scrneeinghdId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(SAMPLE_TEST_NO) != null
				&& !request.getParameter(SAMPLE_TEST_NO).equals("")) {
			testSeqNo = request.getParameter(SAMPLE_TEST_NO);
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			sampleTestBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID) != null
				&& !request.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID)
						.equals("0")) {
			donationId = Integer.parseInt(request
					.getParameter(BLOOD_DONATION_ENTRY_DETAIL_ID));
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
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodDonorSampleScreeningHeader donorSampleScreeningHeader = new BloodDonorSampleScreeningHeader();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			donorSampleScreeningHeader.setHin(patient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			donorSampleScreeningHeader.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			donorSampleScreeningHeader.setHospital(masHospital);
		}

		if (sampleTestBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(sampleTestBy);
			donorSampleScreeningHeader.setSampleTestBy(masEmployee);
		}

		if (donationId != 0) {
			BloodDonationEntryDetail donationEntryDetail = new BloodDonationEntryDetail();
			donationEntryDetail.setId(donationId);
			donorSampleScreeningHeader.setDonationDetail(donationEntryDetail);
		}
		donorSampleScreeningHeader.setSampleTestNo(testSeqNo);
		String temp = bloodBankHandlerService.generateDonorSampleTestNumber();

		donorSampleScreeningHeader.setSampleTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		donorSampleScreeningHeader.setLastChgBy(userName);
		donorSampleScreeningHeader.setBloodIssue("n");
		donorSampleScreeningHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		donorSampleScreeningHeader.setLastChgTime(time);
		infoMap.put("donorSampleScreeningHeader", donorSampleScreeningHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("donationId", donationId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);

		try {

			Vector result = box.getVector(RESULT);
			Vector investigation_id = box.getVector(INVESTIGATION_ID);
			Vector donation_id = box.getVector(BLOOD_DONATION_ID);
			int counter = 0;

			for (int i = 0; i < investigation_id.size(); i++) {
				if (!investigation_id.get(i).toString().equals("")) {
					counter++;
				}
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				investigationList.add(investigation_id.get(i));
			}
			infoMap.put("donation_id", donation_id);
			infoMap.put("result", result);
			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		String jsp = "";
		String message = "";
		if (returnMap.get("testSeqNo") != null) {
			testSeqNo = (String) returnMap.get("testSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService
				.submitDonorBloodSampleScreeningTest(infoMap);
		if (saved) {
			message = "Screening Test has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp";

		jsp = BLD_DONOR_MSG_REQ_ENTRY + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("url", url);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------Blood Component Separation ------------------
	public ModelAndView showBloodComponentSeparationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		map = (Map<String, Object>) bloodBankHandlerService
				.showBloodComponentSeparationJsp(hospitalId);
		jsp = BLOOD_COMPONENT_SEPERATION;
		jsp += ".jsp";
		title = "BloodComponentSeperation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingForResultValidation(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingForResultValidation(hospitalId);
		jsp = "bld_result_validation";
		jsp += ".jsp";
		
		title = "BloodComponentSeperation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView populateResultEntryValidation(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = (Map<String, Object>) bloodBankHandlerService
				.showPendingForResultValidation(hospitalId);
		jsp = "bld_result_validation";
		jsp += ".jsp";
		
		title = "BloodComponentSeperation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView submitBloodTestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;
		int componentId = 0;
		int sexId = 0;
		int receivedBy = 0;

		String patientType = "";
		String date = "";
		String time = "";
		String serialSeqNo = "";
		String name = "";
		String teleNo = "";
		String age = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		
		List investigationList = new ArrayList();
		List result = new ArrayList();
		
		String[] investigation=request.getParameterValues("investigationName");
		for(String s:investigation){
			investigationList.add(s);
			
			result.add(request.getParameter("reactive"+s));
		}
		
		/*int ccbloodGroup=Integer.parseInt(request.getParameter("ccbloodGroup"));
		MasBloodGroup masbldgroup=new MasBloodGroup();
		masbldgroup.setId(ccbloodGroup);*/
		
	/*	String cgRh=request.getParameter("cgRh");
		String sgRh=request.getParameter("sgRh");*/
		

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		int bldSamplescreenHId=Integer.parseInt(request.getParameter("bldSamplescreenHId"));
		BloodSampleScreeningHeader bsh=new BloodSampleScreeningHeader();
		bsh.setId(bldSamplescreenHId);
		
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		//BloodResultEntryHeader resultEntryHeader=new BloodResultEntryHeader();
		/*resultEntryHeader.setCgRhFactor(cgRh);
		resultEntryHeader.setRhFactor(sgRh);*/
		//resultEntryHeader.setCgBloodGroup(masbldgroup);
		
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			testEntryHeader.setHospital(masHospital);
		//	resultEntryHeader.setHospital(masHospital);
		}
		
		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			testEntryHeader.setReceivedBy(masEmployee);
		}
		testEntryHeader.setSerialNo(serialSeqNo);
		String temp = bloodBankHandlerService.generateSerialNumber();

		testEntryHeader.setType(patientType);
		testEntryHeader.setName(name);
		testEntryHeader.setTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setAge(age);
		testEntryHeader.setTeleNo(teleNo);
		testEntryHeader.setLastChgBy(userName);
		testEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setLastChgTime(time);
		
		//resultEntryHeader.setScreeningTest(bsh);
		//resultEntryHeader.setResultEntryValidation("P");
		//resultEntryHeader.setCgStatus("P");
		//resultEntryHeader.setSgStatus("P");
		//resultEntryHeader.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		//resultEntryHeader.setLastChgTime(time);
		
		infoMap.put("bldSamplescreenHId", bldSamplescreenHId);
		//infoMap.put("resultEntryHeader", resultEntryHeader);
		infoMap.put("testEntryHeader", testEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("serialSeqNo", serialSeqNo);
		infoMap.put("investigationList", investigationList);
		infoMap.put("result", result);

		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) returnMap.get("serialSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodTestEntry(infoMap);
		if (saved) {
			message = "TTI Screnning done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showBloodTestEntryJsp";

		jsp = BLD_MSG_TEST_ENTRY + ".jsp";
		map.put("serialSeqNo", serialSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitBloodTestEntryCg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;
		int componentId = 0;
		int sexId = 0;
		int receivedBy = 0;

		String patientType = "";
		String date = "";
		String time = "";
		String serialSeqNo = "";
		String name = "";
		String teleNo = "";
		String age = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		
		List investigationList = new ArrayList();
		List result = new ArrayList();
		
		/*String[] investigation=request.getParameterValues("investigationName");
		for(String s:investigation){
			investigationList.add(s);
			
			result.add(request.getParameter("reactive"+s));
		}*/
		
		/*int ccbloodGroup=Integer.parseInt(request.getParameter("ccbloodGroup"));
		MasBloodGroup masbldgroup=new MasBloodGroup();
		masbldgroup.setId(ccbloodGroup);*/
		
	/*	String cgRh=request.getParameter("cgRh");
		String sgRh=request.getParameter("sgRh");*/
		

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		
		int bldSamplescreenHId=0;
		if(null !=request.getParameter("bldSamplescreenHId") && !request.getParameter("bldSamplescreenHId").equals("0") )
		{
			bldSamplescreenHId=Integer.parseInt(request.getParameter("bldSamplescreenHId"));
		BloodSampleScreeningHeader bsh=new BloodSampleScreeningHeader();
		bsh.setId(bldSamplescreenHId);
		}
		
		/*int bloodResultEntryHeaderId=0;
		if(null !=request.getParameter("bloodResultEntryHeaderId") && !request.getParameter("bloodResultEntryHeaderId").equals("") )
		{
			bloodResultEntryHeaderId=Integer.parseInt(request.getParameter("bloodResultEntryHeaderId"));
		
		}
		*/
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		BloodResultEntryHeader resultEntryHeader=new BloodResultEntryHeader();
		/*resultEntryHeader.setCgRhFactor(cgRh);
		resultEntryHeader.setRhFactor(sgRh);*/
		//resultEntryHeader.setCgBloodGroup(masbldgroup);
		
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			testEntryHeader.setHospital(masHospital);
			resultEntryHeader.setHospital(masHospital);
		}
		
		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			testEntryHeader.setReceivedBy(masEmployee);
		}
		testEntryHeader.setSerialNo(serialSeqNo);
		String temp = bloodBankHandlerService.generateSerialNumber();

		testEntryHeader.setType(patientType);
		testEntryHeader.setName(name);
		testEntryHeader.setTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setAge(age);
		//testEntryHeader.setTeleNo(teleNo);
		//testEntryHeader.setLastChgBy(userName);
		testEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setLastChgTime(time);
		
		//resultEntryHeader.setScreeningTest(bsh);
		//resultEntryHeader.setResultEntryValidation("P");
		resultEntryHeader.setCgStatus("C");
		//resultEntryHeader.setSgStatus("P");
		resultEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		resultEntryHeader.setLastChgTime(time);
		
		infoMap.put("bldSamplescreenHId", bldSamplescreenHId);
		infoMap.put("resultEntryHeader", resultEntryHeader);
		infoMap.put("testEntryHeader", testEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("serialSeqNo", serialSeqNo);
		infoMap.put("investigationList", investigationList);
		infoMap.put("result", result);

		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) returnMap.get("serialSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodTestEntryCg(infoMap);
		if (saved) {
			message = "Blood Test Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showBloodTestEntryJsp";

		jsp = BLD_MSG_TEST_ENTRY + ".jsp";
		map.put("serialSeqNo", serialSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView submitBloodTestEntrySg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int pageNo = 1;
		int hinId = 0;
		int componentId = 0;
		int sexId = 0;
		int receivedBy = 0;

		String patientType = "";
		String date = "";
		String time = "";
		String serialSeqNo = "";
		String name = "";
		String teleNo = "";
		String age = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		
		List investigationList = new ArrayList();
		List result = new ArrayList();
		
		/*String[] investigation=request.getParameterValues("investigationName");
		for(String s:investigation){
			investigationList.add(s);
			
			result.add(request.getParameter("reactive"+s));
		}*/
		
		/*int ccbloodGroup=Integer.parseInt(request.getParameter("ccbloodGroup"));
		MasBloodGroup masbldgroup=new MasBloodGroup();
		masbldgroup.setId(ccbloodGroup);*/
		
	/*	String cgRh=request.getParameter("cgRh");
		String sgRh=request.getParameter("sgRh");*/
		

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		
		int bldSamplescreenHId=0;
		if(null !=request.getParameter("bldSamplescreenHId") && !request.getParameter("bldSamplescreenHId").equals("0")){
			 bldSamplescreenHId=Integer.parseInt(request.getParameter("bldSamplescreenHId"));
		BloodSampleScreeningHeader bsh=new BloodSampleScreeningHeader();
		bsh.setId(bldSamplescreenHId);
		}
		int bldSampleCollectionId=0;
		if(null !=request.getParameter("bldSampleCollectionId") && !request.getParameter("bldSampleCollectionId").equals("0")){
		 bldSampleCollectionId=Integer.parseInt(request.getParameter("bldSampleCollectionId"));
		}
		
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTestEntryHeader testEntryHeader = new BloodTestEntryHeader();
		BloodResultEntryHeader resultEntryHeader=new BloodResultEntryHeader();
		/*resultEntryHeader.setCgRhFactor(cgRh);
		resultEntryHeader.setRhFactor(sgRh);*/
		//resultEntryHeader.setCgBloodGroup(masbldgroup);
		
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			testEntryHeader.setHospital(masHospital);
			resultEntryHeader.setHospital(masHospital);
		}
		
		if (receivedBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(receivedBy);
			testEntryHeader.setReceivedBy(masEmployee);
		}
		testEntryHeader.setSerialNo(serialSeqNo);
		String temp = bloodBankHandlerService.generateSerialNumber();

		testEntryHeader.setType(patientType);
		testEntryHeader.setName(name);
		testEntryHeader.setTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setAge(age);
		//testEntryHeader.setTeleNo(teleNo);
		//testEntryHeader.setLastChgBy(userName);
		testEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		testEntryHeader.setLastChgTime(time);
		
		//resultEntryHeader.setScreeningTest(bsh);
		//resultEntryHeader.setResultEntryValidation("P");
		resultEntryHeader.setCgStatus("C");
		//resultEntryHeader.setSgStatus("P");
		resultEntryHeader.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		resultEntryHeader.setLastChgTime(time);
		
		infoMap.put("bldSampleCollectionId", bldSampleCollectionId);
		infoMap.put("bldSamplescreenHId", bldSamplescreenHId);
		infoMap.put("bldSamplescreenHId", bldSamplescreenHId);
	//	infoMap.put("resultEntryHeader", resultEntryHeader);
		infoMap.put("testEntryHeader", testEntryHeader);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("serialSeqNo", serialSeqNo);
		infoMap.put("investigationList", investigationList);
		infoMap.put("result", result);

		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("serialSeqNo") != null) {
			serialSeqNo = (String) returnMap.get("serialSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodTestEntrySg(infoMap);
		if (saved) {
			message = "Blood Test Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}
		url = "/hms/hms/bloodBank?method=showBloodTestEntryJsp";

		jsp = BLD_MSG_TEST_ENTRY + ".jsp";
		map.put("serialSeqNo", serialSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	// ---------------Blood Reaction Form Entry ---------------------------
	
	/** Method for populate patient reaction list
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSearchPatientForReactionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		
		int hospitalId = 0;
		HttpSession session = request.getSession();
		hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = bloodBankHandlerService.showSearchPatientForReactionJsp(hospitalId);
		jsp = BLD_SEARCH_REACTION_FORM + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView searchPatientForBloodReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String patientFName = "";
		String patientLName = "";
		String hinNo = "";
		String adNo = "";
		String pType = "";
		int inpatientId = 0;
		int departmentId = 0;
		int deptId = 0;
		String deptName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(AD_NO) != null
				&& !(request.getParameter(AD_NO).equals(""))) {
			adNo = request.getParameter(AD_NO);
			mapForDs.put("adNo", adNo);
		}
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientIds").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDs.put("inpatientId", inpatientId);
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			mapForDs.put("departmentId", departmentId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForBloodReaction(mapForDs);
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		if (patientMap.get("wardList") != null) {
			wardList = (List<MasDepartment>) patientMap.get("wardList");
			map.put("wardList", wardList);
		}
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLD_SEARCH_REACTION_FORM + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showReactionFormEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int inpatientId = 0;
		int bldIssueDeatialId=0;
		
		if (request.getParameter("bldIssueDeatialId") != null
				&& !(request.getParameter("bldIssueDeatialId").equals("0"))) {
			bldIssueDeatialId = Integer.parseInt(request.getParameter("bldIssueDeatialId"));
			
			mapForDS.put("bldIssueDeatialId", bldIssueDeatialId);
		}
		
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientId").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			mapForDS.put("inpatientId", inpatientId);
		}else if(request.getParameter("parent") != null
				&& !(request.getParameter("parent").equals("0"))) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
			mapForDS.put("inpatientId", inpatientId);
		}
		int hospitalId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("hospitalId")!=null ){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		int deptId=0;
		if(session.getAttribute("deptId")!=null ){
			deptId=(Integer)session.getAttribute("deptId");
		}
		
		if(bldIssueDeatialId!=0){
			map = bloodBankHandlerService.showReactionFormEntryJsp(bldIssueDeatialId,hospitalId,deptId);
			String entrySeqNo = "";
			//entrySeqNo = bloodBankHandlerService.getEntrySeqForDisplay("EN");
			if (entrySeqNo != null) {
				map.put("entrySeqNo", entrySeqNo);
			}
			jsp = BLD_REACTION_FORM_ENTRY + ".jsp";
			map.put("bldIssueDeatialId", bldIssueDeatialId);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}else{
			
			jsp = BLD_REACTION_FORM_ENTRY + ".jsp";
			String msg="No Blood Transfusion Related Data Available";
			map.put("bldIssueDeatialId", bldIssueDeatialId);
			map.put("msg", msg);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitBloodReactionEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodReactionEntry bldReactionEntry = new BloodReactionEntry();
		Date currentDate = new Date();
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();
		Box box = HMSUtil.getBox(request);
		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String timeCompleted = "";
		
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;

		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		MasHospital masHospital = new MasHospital();
		if (hospitalId != 0) {
			masHospital.setId(hospitalId);
			bldReactionEntry.setHospital(masHospital);
		}
		if (deptId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(deptId);
			bldReactionEntry.setDepartment(masDepartment);
		}
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		bldReactionEntry.setEntryNo(entrySeqNo);
		//String temp = bloodBankHandlerService.generateEntryNumber();

		if (request.getParameter(REACTION_DATE) != null
				&& !(request.getParameter(REACTION_DATE).equals(""))) {
			reactionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REACTION_DATE));
			bldReactionEntry.setRactionDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				bldReactionEntry.setHin(patient);
			}
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			if (hinId != 0) {
				Inpatient inpatient = new Inpatient();
				inpatient.setId(inpatientId);
				bldReactionEntry.setInpatient(inpatient);
			}
		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !request.getParameter(BLOOD_BAG_NO).equals("")) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);
			bldReactionEntry.setBloodBagNo(bloodBagNo);
		}
		if (request.getParameter(ISSUED_DATE) != null
				&& !(request.getParameter(ISSUED_DATE).equals(""))) {
			issuedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUED_DATE));
			bldReactionEntry.setIssuedDate(HMSUtil
					.convertStringTypeDateToDateType(date));
		}
		if (request.getParameter(ISSUED_TIME) != null
				&& !(request.getParameter(ISSUED_TIME).equals(""))) {
			issuedTime = request.getParameter(ISSUED_TIME);
			bldReactionEntry.setIssuedTime(issuedTime);
		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			bldReactionEntry.setDonorName(donorName);
		}

		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
			if (bloodGroupId != 0) {
				MasBloodGroup masBloodGroup = new MasBloodGroup();
				masBloodGroup.setId(bloodGroupId);
				bldReactionEntry.setBloodGroup(masBloodGroup);
			}
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
			if (crossMatchedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(crossMatchedBy);
				bldReactionEntry.setCrossMatchedBy(masEmployee);
			}
		}
		if (request.getParameter(ISSUED_TO) != null
				&& !(request.getParameter(ISSUED_TO).equals(""))) {
			issuedTo = request.getParameter(ISSUED_TO);
			bldReactionEntry.setIssuedTo(issuedTo);
		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("") && !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));
			if (issuedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(issuedBy);
				bldReactionEntry.setIssuedBy(masEmployee);
			}
		}

		if (request.getParameter(WD_NO) != null
				&& !(request.getParameter(WD_NO).equals(""))) {
			wdNo = request.getParameter(WD_NO);
		}
		bldReactionEntry.setWdNo(wdNo);

		if (request.getParameter(TEMP_TRANSFUSSION) != null
				&& !(request.getParameter(TEMP_TRANSFUSSION).equals(""))) {
			tempTransfussion = request.getParameter(TEMP_TRANSFUSSION);
		}
		bldReactionEntry.setTransfussion(tempTransfussion);
		if (request.getParameter(TRANSFUSSION_DATE) != null
				&& !(request.getParameter(TRANSFUSSION_DATE).equals(""))) {
			dateTransfussion = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRANSFUSSION_DATE));
		}
		bldReactionEntry.setDateTransfussion(HMSUtil
				.convertStringTypeDateToDateType(date));

		if (request.getParameter(STARTED_TIME) != null
				&& !(request.getParameter(STARTED_TIME).equals(""))) {
			timeStarted = request.getParameter(STARTED_TIME);
		}
		bldReactionEntry.setTimeStarted(timeStarted);

		if (request.getParameter(COMPLETED_TIME) != null
				&& !(request.getParameter(COMPLETED_TIME).equals(""))) {
			timeCompleted = request.getParameter(COMPLETED_TIME);
		}
		bldReactionEntry.setTimeCompleted(timeCompleted);

		/*
		 * bldReactionEntry.setPyrexia(pyrexia);
		 * bldReactionEntry.setRigor(rigor);
		 * bldReactionEntry.setRiseTemp(riseTemp);
		 * bldReactionEntry.setFallOfBp(fallOfBp);
		 * bldReactionEntry.setItching(itching);
		 * bldReactionEntry.setUrticarla(urticarla);
		 * bldReactionEntry.setAnaphylaxia(anaphylaxia);
		 * bldReactionEntry.setPainBack(painBack);
		 * bldReactionEntry.setHead(head); bldReactionEntry.setChest(chest);
		 * bldReactionEntry.setElseWehere(elseWehere);
		 * bldReactionEntry.setJaundice(jaundice);
		 * bldReactionEntry.setHaemoglobinuria(haemoglobin);
		 * bldReactionEntry.setAnuria(anuria);
		 * bldReactionEntry.setUntowardReaction(untowardReaction);
		 */

		bldReactionEntry.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));

		bldReactionEntry.setLastChgTime(time);

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			map.put("userName", userName);
		}
		Users user = null;
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
			bldReactionEntry.setLastChgBy(user);
		}
		bldReactionEntry.setScreening("n");
		bldReactionEntry.setRemarks((String) request
				.getParameter("vitalRemark"));
		if (request.getParameter("BeforeTemperature") != null
				&& !"".equalsIgnoreCase(request
						.getParameter("BeforeTemperature"))) {
			bldReactionEntry.setTemperature(new BigDecimal(request.getParameter("BeforeTemperature").toString()));
		}
		if (request.getParameter("BeforePulse") != null
				&& !"".equalsIgnoreCase(request.getParameter("BeforePulse"))) {
			bldReactionEntry.setBpMax(Integer.parseInt(request
					.getParameter("BeforePulse")));
		}
		if (request.getParameter("BeforePulseMin") != null
				&& !"".equalsIgnoreCase(request.getParameter("BeforePulseMin"))) {
			bldReactionEntry.setBpMin(Integer.parseInt(request
					.getParameter("BeforePulseMin")));
		}
		if (request.getParameter("BeforePulseMax") != null
				&& !"".equalsIgnoreCase(request.getParameter("BeforePulseMax"))) {
			bldReactionEntry.setPulse(Integer.parseInt(request
					.getParameter("BeforePulseMax")));
		}
		
		String afterTemperature="";
		String afterPulse="";
		String afterPulseMax="";
		String afterPulseMin="";
		
		if (request.getParameter("BeforeTemperature") != null && !(request.getParameter("BeforeTemperature").equalsIgnoreCase(""))) {
			afterTemperature=request.getParameter("BeforeTemperature");
			bldReactionEntry.setTempAfterTransfusion(new BigDecimal(request.getParameter("BeforeTemperature")));
			}
			
		if (request.getParameter("AfterPulse") != null && !(request.getParameter("AfterPulse").equalsIgnoreCase(""))) {
			afterPulse=request.getParameter("BeforeTemperature");
			bldReactionEntry.setPulseAfterTransfusion(Integer.parseInt(afterPulse));
			}
			
		if (request.getParameter("AfterPulseMax") != null && !(request.getParameter("AfterPulseMax").equalsIgnoreCase(""))) {
			afterPulseMax=request.getParameter("BeforeTemperature");
			bldReactionEntry.setBpMaxAfterTransfusion(Integer.parseInt(afterPulseMax));
			}
		
		if (request.getParameter("AfterPulseMin") != null && !(request.getParameter("AfterPulseMin").equalsIgnoreCase(""))) {
			afterPulseMin=request.getParameter("AfterPulseMin");
			bldReactionEntry.setBpMinAfterTransfusion(Integer.parseInt(afterPulseMin));
			}
			
		
		String duringTemperature="";
		String duringPulse="";
		String duringPulseMax="";
		String duringPulseMin="";
		
		if (request.getParameter("DuringTemperature") != null && !(request.getParameter("DuringTemperature").equalsIgnoreCase(""))) {
			duringTemperature=request.getParameter("DuringTemperature");
			bldReactionEntry.setTempDuringTransfusion(new BigDecimal(request.getParameter("DuringTemperature")));
			}
			
		if (request.getParameter("DuringPulse") != null && !(request.getParameter("DuringPulse").equalsIgnoreCase(""))) {
			duringPulse=request.getParameter("DuringTemperature");
			bldReactionEntry.setPulseDuringTransfusion(Integer.parseInt(duringPulse));
			}
			
		if (request.getParameter("DuringPulseMax") != null && !(request.getParameter("DuringPulseMax").equalsIgnoreCase(""))) {
			duringPulseMax=request.getParameter("DuringPulseMax");
			bldReactionEntry.setBpMaxDuringTransfusion(Integer.parseInt(duringPulseMax));
			}
		
		if (request.getParameter("DuringPulseMin") != null && !(request.getParameter("DuringPulseMin").equalsIgnoreCase(""))) {
			duringPulseMin=request.getParameter("DuringPulseMin");
			bldReactionEntry.setBpMinDuringTransfusion(Integer.parseInt(duringPulseMin));
			}
		
		
		if (request.getParameter("Rigor") != null && (request.getParameter("Rigor").equalsIgnoreCase("y"))) {
			bldReactionEntry.setRigor("y");
			}
			else{
			bldReactionEntry.setRigor("n");
			}
		
		
		if (request.getParameter("Chills") != null && (request.getParameter("Chills").equalsIgnoreCase("y"))) {
			bldReactionEntry.setChills("y");
			}
			else{
			bldReactionEntry.setChills("n");
			}
		if (request.getParameter("Rash") != null
		&& (request.getParameter("Rash").equalsIgnoreCase("y"))) {
			bldReactionEntry.setRashItching("y");
			}
		else{
			bldReactionEntry.setRashItching("n");;
			}
		
		if (request.getParameter("Back") != null
		&& (request.getParameter("Back").equalsIgnoreCase("y"))) {
			bldReactionEntry.setPainBack("y");
			}
		else{
			bldReactionEntry.setPainBack("n");;
			}
		
		if (request.getParameter("Head") != null
				&& (request.getParameter("Head").equalsIgnoreCase("y"))) {
			bldReactionEntry.setPainHead("y");
		}
		else{
			bldReactionEntry.setPainHead("n");;
		}
		
		if (request.getParameter("Chest") != null
				&& (request.getParameter("Chest").equalsIgnoreCase("y"))) {
			bldReactionEntry.setPainChest("y");
		}
		else{
			bldReactionEntry.setPainChest("n");;
		}
		
		if (request.getParameter("Elsewhere") != null
				&& (request.getParameter("Elsewhere").equalsIgnoreCase("y"))) {
			bldReactionEntry.setPainElsewhere("y");
		}
		else{
			bldReactionEntry.setPainElsewhere("n");;
		}
		
		if (request.getParameter("Haemoglobinuana") != null
				&& (request.getParameter("Haemoglobinuana").equalsIgnoreCase("y"))) {
			bldReactionEntry.setHaemoglobinuana("y");
		}
		else{
			bldReactionEntry.setHaemoglobinuana("n");;
		}
		
		if (request.getParameter("Pulmonary") != null
				&& (request.getParameter("Pulmonary").equalsIgnoreCase("y"))) {
			bldReactionEntry.setPulmonaryOedema("y");
		}
		else{
			bldReactionEntry.setPulmonaryOedema("n");;
		}
		
		
		if (request.getParameter("Jaundice") != null
				&& (request.getParameter("Jaundice").equalsIgnoreCase("y"))) {
			bldReactionEntry.setJaundice("y");
		}
		else{
			bldReactionEntry.setJaundice("n");;
		}
		
		
		if (request.getParameter("AnyOther") != null
				&& (request.getParameter("AnyOther").equalsIgnoreCase("y"))) {
			bldReactionEntry.setAnyOtherSigns("y");
		}
		else{
			bldReactionEntry.setAnyOtherSigns("n");;
		}
		

		boolean saved = false;
		saved = bloodBankHandlerService.submitBloodReactionEntry(
				bldReactionEntry, box);
		if (saved) {
			message = "Blood Reaction Entry has been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_ENTRY + ".jsp";
		map.put("userName", userName);
		map.put("hospitalId", hospitalId);
		map.put("deptId", deptId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public void fillPatientDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String hinNo = "";

		try {
			if (request.getParameter("hinNo") != null) {
				hinNo = request.getParameter("hinNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("hinNo", hinNo);
		map = bloodBankHandlerService.fillPatientDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				sb.append("<donerName>" + patient.getPFirstName()
						+ "</donerName>");
				if (patient.getBloodGroup() != null) {
					sb.append("<bloodGroupId>"
							+ patient.getBloodGroup().getId()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// -----For update Donation entryForm-------------
	public ModelAndView showPatientSearchForDonationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_DONATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method for Search Donor
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView searchDonor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		/* session.setAttribute("box", box); */

		int page = 1;
		int recordsPerPage = 5;

		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		box.put("page", page);
		box.put("recordsPerPage", recordsPerPage);
		dataMap.put("box", box);
		String donationReg = "";
		int genderId = 0;
		String donorname = "";
		String Uid = "";
		String mobilenumber = "";
		String bloodbankname = "";
		String bloodbanknumber = "";
		if (request.getParameter("registrationNumber") != null
				&& !(request.getParameter("registrationNumber").equals(""))) {
			donationReg = request.getParameter("registrationNumber");

			dataMap.put("donationReg", donationReg);

		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dataMap.put("hospitalId", hospitalId);
		
		
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorname = request.getParameter(DONOR_NAME);

			dataMap.put("donorname", donorname);

		}
		if (request.getParameter(GENDER) != null
				&& !(request.getParameter(GENDER).equals(""))) {
			genderId = Integer.parseInt(request.getParameter(GENDER));

			dataMap.put("genderId", genderId);

		}
		if (request.getParameter("mobileNumber") != null
				&& !(request.getParameter("mobileNumber").equals(""))) {
			mobilenumber = request.getParameter("mobileNumber");
			dataMap.put("mobilenumber", mobilenumber);

		}
		if (request.getParameter("bloodBankName") != null
				&& !(request.getParameter("bloodBankName").equals(""))) {
			bloodbankname = request.getParameter("bloodBankName");
			dataMap.put("bloodbankname", bloodbankname);

		}
		if (request.getParameter("bloodBankNumber") != null
				&& !(request.getParameter("bloodBankNumber").equals(""))) {
			bloodbanknumber = request.getParameter("bloodBankNumber");
			dataMap.put("bloodbanknumber", bloodbanknumber);

		}
		if (request.getParameter("uId") != null
				&& !(request.getParameter("uId").equals(""))) {
			Uid = request.getParameter("uId");

			dataMap.put("UhID", Uid);

		}
		map = bloodBankHandlerService.showPatientSearchForDonationJsp(dataMap);

		jsp = "bld_donorSearch" + ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchPatientForUpdateDonation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String donationNo = "";
		String adNo = "";
		String pType = "";
		String deptType = "";
		int bloodDonationId = 0;
		int departmentId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		String donorName = "";
		String hinNo = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(DONATION_NO) != null
				&& !(request.getParameter(DONATION_NO).equals(""))) {
			donationNo = request.getParameter(DONATION_NO);
			mapForDs.put("donationNo", donationNo);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			mapForDs.put("donorName", donorName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		if (request.getParameter("bloodDonationId") != null
				&& !(request.getParameter("bloodDonationId").equals("0"))) {
			bloodDonationId = Integer.parseInt(request
					.getParameter("bloodDonationId"));
			mapForDs.put("bloodDonationId", bloodDonationId);
		}

		patientMap = bloodBankHandlerService
				.getPatientForUpdateDonation(mapForDs);

		map.put("deptType", deptType);
		map.put("deptName", deptName);
		map.put("deptId", deptId);
		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_SEARCH_DONATION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateDonationEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodDonationId = 0;
		if (request.getParameter("bloodDonationId") != null
				&& !(request.getParameter("bloodDonationId").equals("0"))) {
			bloodDonationId = Integer.parseInt(request
					.getParameter("bloodDonationId"));
			mapForDS.put("bloodDonationId", bloodDonationId);
		}
		if (bloodDonationId != 0) {
			map = bloodBankHandlerService
					.showUpdateDonationEntry(bloodDonationId);
		}
		jsp = BLOOD_UPDATE_DONATION + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showPopUpBloodIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		session = request.getSession();
		int bloodComponentId = 0;
		int rowNo = 0;

		if (request.getParameter("bloodComponentId") != null) {
			bloodComponentId = Integer.parseInt(request
					.getParameter("bloodComponentId"));
		}
		if (request.getParameter("rowNo") != null) {
			rowNo = Integer.parseInt(request.getParameter("rowNo"));
		}
		map.put("bloodComponentId", bloodComponentId);
		dataMap = bloodBankHandlerService.showPopUpBloodIssueJsp(map);
		;
		jsp = BLOOD_POP_UP_ISSUE;
		jsp += ".jsp";
		title = "BloodComponent";
		dataMap.put("rowNo", rowNo);
		dataMap.put("contentJsp", jsp);
		dataMap.put("title", title);
		return new ModelAndView(BLOOD_POP_UP_ISSUE, "map", dataMap);
	}

	public ModelAndView showPatientSearchForReactionJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForUpdateReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String entryNo = "";
		String hinNo = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		String patientName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}

		if (request.getParameter(PATIENT_NAME) != null
				&& !(request.getParameter(PATIENT_NAME).equals(""))) {
			patientName = request.getParameter(PATIENT_NAME);
			mapForDs.put("patientName", patientName);
		}
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDs.put("reactionId", reactionId);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		patientMap = bloodBankHandlerService
				.searchPatientForUpdateReaction(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_SEARCH_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateTestEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bloodTestId = 0;
		if (request.getParameter(BLOOD_TEST_ID) != null
				&& !(request.getParameter(BLOOD_TEST_ID).equals("0"))) {
			bloodTestId = Integer.parseInt(request.getParameter(BLOOD_TEST_ID));
			mapForDS.put("bloodTestId", bloodTestId);
		}
		if (bloodTestId != 0) {
			map = bloodBankHandlerService.showUpdateTestEntry(bloodTestId);
		}
		jsp = BLOOD_UPDATE_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateBloodReaction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		BloodReactionEntry bldReactionEntry = new BloodReactionEntry();
		Date currentDate = new Date();
		Date reactionDate = new Date();
		Date issuedDate = new Date();
		Date dateTransfussion = new Date();

		String changedBy = "";
		String date = "";
		String time = "";
		String issuedTime = "";
		String donorName = "";
		String issuedTo = "";
		String entrySeqNo = "";
		String pyrexia = "";
		String itching = "";
		String urticarla = "";
		String elseWehere = "";
		String painBack = "";
		String head = "";
		String chest = "";
		String jaundice = "";
		String anaphylaxia = "";
		String fallOfBp = "";
		String rigor = "";
		String riseTemp = "";
		String haemoglobinuria = "";
		String timeCompleted = "";
		String anuria = "";
		String bloodBagNo = "";
		String tempTransfussion = "";
		String wdNo = "";
		String timeStarted = "";
		String untowardReaction = "";
		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");

		int hinId = 0;
		int inpatientId = 0;
		int issuedBy = 0;
		int crossMatchedBy = 0;
		int stockDetailId = 0;
		int bloodGroupId = 0;

		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		if (hospitalId != 0) {

		}
		if (deptId != 0) {

		}
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entrySeqNo = request.getParameter(ENTRY_NO);
		}
		if (request.getParameter(REACTION_DATE) != null
				&& !(request.getParameter(REACTION_DATE).equals(""))) {
			reactionDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(REACTION_DATE));

		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));

		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !request.getParameter(BLOOD_BAG_NO).equals("")) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);

		}
		if (request.getParameter(ISSUED_DATE) != null
				&& !(request.getParameter(ISSUED_DATE).equals(""))) {
			issuedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(ISSUED_DATE));

		}
		if (request.getParameter(ISSUED_TIME) != null
				&& !(request.getParameter(ISSUED_TIME).equals(""))) {
			issuedTime = request.getParameter(ISSUED_TIME);

		}
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);

		}

		if (request.getParameter(BLOOD_GROUP_ID) != null
				&& !request.getParameter(BLOOD_GROUP_ID).equals("0")) {
			bloodGroupId = Integer.parseInt(request
					.getParameter(BLOOD_GROUP_ID));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossMatchedBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(ISSUED_TO) != null
				&& !(request.getParameter(ISSUED_TO).equals(""))) {
			issuedTo = request.getParameter(ISSUED_TO);

		}
		if (request.getParameter(ISSUED_BY) != null
				&& !request.getParameter(ISSUED_BY).equals("0")) {
			issuedBy = Integer.parseInt(request.getParameter(ISSUED_BY));

		}

		if (request.getParameter(WD_NO) != null
				&& !(request.getParameter(WD_NO).equals(""))) {
			wdNo = request.getParameter(WD_NO);

		}

		if (request.getParameter(TEMP_TRANSFUSSION) != null
				&& !(request.getParameter(TEMP_TRANSFUSSION).equals(""))) {
			tempTransfussion = request.getParameter(TEMP_TRANSFUSSION);

		}
		if (request.getParameter(TRANSFUSSION_DATE) != null
				&& !(request.getParameter(TRANSFUSSION_DATE).equals(""))) {
			dateTransfussion = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(TRANSFUSSION_DATE));

		}

		if (request.getParameter(STARTED_TIME) != null
				&& !(request.getParameter(STARTED_TIME).equals(""))) {
			timeStarted = request.getParameter(STARTED_TIME);

		}

		if (request.getParameter(COMPLETED_TIME) != null
				&& !(request.getParameter(COMPLETED_TIME).equals(""))) {
			timeCompleted = request.getParameter(COMPLETED_TIME);

		}
		if (request.getParameter(PYREXIA) != null) {
			pyrexia = request.getParameter(PYREXIA);
		}
		if (request.getParameter(RIGOR) != null) {
			rigor = request.getParameter(RIGOR);
		}
		if (request.getParameter(RISE_TEMP) != null) {
			riseTemp = request.getParameter(RISE_TEMP);
		}

		if (request.getParameter(FALL_BP) != null) {
			fallOfBp = request.getParameter(FALL_BP);
		}

		if (request.getParameter(ITCHING) != null
				&& !(request.getParameter(ITCHING).equals(""))) {
			itching = request.getParameter(ITCHING);
		}

		if (request.getParameter(URTICARLA) != null
				&& !(request.getParameter(URTICARLA).equals(""))) {
			urticarla = request.getParameter(URTICARLA);
		}
		if (request.getParameter(ANAPHYLAXIA) != null
				&& !(request.getParameter(ANAPHYLAXIA).equals(""))) {
			anaphylaxia = request.getParameter(ANAPHYLAXIA);
		}

		if (request.getParameter(PAIN_BACK) != null
				&& !(request.getParameter(PAIN_BACK).equals(""))) {
			painBack = request.getParameter(PAIN_BACK);
		}

		if (request.getParameter(HEAD) != null
				&& !(request.getParameter(HEAD).equals(""))) {
			head = request.getParameter(HEAD);
		}

		if (request.getParameter(CHEST) != null) {
			chest = request.getParameter(CHEST);
		}

		if (request.getParameter(ELSE_WHERE) != null
				&& !(request.getParameter(ELSE_WHERE).equals(""))) {
			elseWehere = request.getParameter(ELSE_WHERE);
		}
		if (request.getParameter(JAUNDICE) != null
				&& !(request.getParameter(JAUNDICE).equals(""))) {
			jaundice = request.getParameter(JAUNDICE);
		}

		if (request.getParameter(HEMOGLOBIN) != null
				&& !(request.getParameter(HEMOGLOBIN).equals(""))) {
			haemoglobinuria = request.getParameter(HEMOGLOBIN);
		}

		if (request.getParameter(ANURIA) != null
				&& !(request.getParameter(ANURIA).equals(""))) {
			anuria = request.getParameter(ANURIA);
		}

		if (request.getParameter(UNTOWARD_REACTION) != null
				&& !(request.getParameter(UNTOWARD_REACTION).equals(""))) {
			untowardReaction = request.getParameter(UNTOWARD_REACTION);

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
		int blooReactionId = 0;
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals(""))) {
			blooReactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
		}
		if (session.getAttribute(CHANGED_BY) != null) {
			userName = (String) session.getAttribute(CHANGED_BY);
		}
		generalMap.put("blooReactionId", blooReactionId);
		generalMap.put("entrySeqNo", entrySeqNo);
		generalMap.put("hinId", hinId);
		generalMap.put("inpatientId", inpatientId);
		generalMap.put("bloodGroupId", bloodGroupId);
		generalMap.put("haemoglobinuria", haemoglobinuria);
		generalMap.put("anaphylaxia", anaphylaxia);
		generalMap.put("bloodBagNo", bloodBagNo);
		generalMap.put("wdNo", wdNo);
		generalMap.put("tempTransfussion", tempTransfussion);
		generalMap.put("currentDate", dateTransfussion);
		generalMap.put("issuedTo", issuedTo);
		generalMap.put("timeCompleted", timeCompleted);
		generalMap.put("timeStarted", timeStarted);
		generalMap.put("pyrexia", pyrexia);
		generalMap.put("riseTemp", riseTemp);
		generalMap.put("fallOfBp", fallOfBp);
		generalMap.put("rigor", rigor);
		generalMap.put("reactionDate", reactionDate);
		generalMap.put("itching", itching);
		generalMap.put("crossMatchedBy", crossMatchedBy);
		generalMap.put("issuedBy", issuedBy);
		generalMap.put("urticarla", urticarla);
		generalMap.put("donorName", donorName);
		generalMap.put("reactionDate", reactionDate);
		generalMap.put("itching", itching);
		generalMap.put("crossMatchedBy", crossMatchedBy);
		generalMap.put("urticarla", urticarla);
		generalMap.put("currentDate", issuedDate);
		generalMap.put("painBack", painBack);
		generalMap.put("head", head);
		generalMap.put("chest", chest);
		generalMap.put("elseWehere", elseWehere);
		generalMap.put("untowardReaction", untowardReaction);
		generalMap.put("issuedTime", issuedTime);
		generalMap.put("jaundice", jaundice);
		generalMap.put("anuria", anuria);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		boolean dataUpdated = false;
		dataUpdated = bloodBankHandlerService.updateBloodReaction(generalMap);
		if (dataUpdated) {
			message = "Blood Reaction Entry has been Updated Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_ENTRY + ".jsp";
		map.put("userName", userName);
		map.put("blooReactionId", blooReactionId);
		map.put("hospitalId", hospitalId);
		map.put("userName", userName);
		map.put("deptId", deptId);
		map.put("entrySeqNo", entrySeqNo);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------Show--Investigation Pending Transfusion Reaction-----------
	public ModelAndView showPendingForTransfussionReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		map = bloodBankHandlerService.showPendingForTransfussionReaction();
		//map = bloodBankHandlerService.searchPatientForTransfussionReaction();
		
		patientMap = bloodBankHandlerService
				.getTransfusionReactionGrid(mapForDs);
		jsp = BLOOD_PND_TRANS_REACTION + ".jsp";
		map.put("patientMap", patientMap);
		map.put("mapForDs", mapForDs);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * To Open Blood Bank Registry Page
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showBloodBankRegistryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> bankMap=new HashMap<String,Object>();
		Box box=HMSUtil.getBox(request);
		jsp = "bld_bloodBankRegistry" + ".jsp";
		
		bankMap = bloodBankHandlerService.showBloodBankRegistryJsp(box);

		/*map.put("bankMap", bankMap);*/
		bankMap.put("contentJsp", jsp);
		return new ModelAndView("index", "map", bankMap);
	}
	public void populateComponentdetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int componentId=0;
		if(null !=request.getParameter("componentId"))
		componentId=Integer.parseInt(request.getParameter("componentId"));
		
		Map<String,Object> bankMap=new HashMap<String,Object>();
		List<BloodMasComponent> bldMasCompList = new ArrayList<BloodMasComponent>();
		
		jsp = "bld_bloodBankRegistry" + ".jsp";
		
		bankMap = bloodBankHandlerService.populateComponentdetails(componentId);

		if (bankMap.get("bldMasCompList") != null) {
			bldMasCompList = (List<BloodMasComponent>) bankMap.get("bldMasCompList");
		}
		StringBuffer sb = new StringBuffer();
		
		Calendar now = Calendar.getInstance();
		
		
			for (BloodMasComponent component : bldMasCompList) {
				int lifespanDays=component.getLifeSpan();
				String expiryDate="";
				expiryDate=(now.get(Calendar.DATE)+lifespanDays)+"-"+now.get(Calendar.MONTH)+"-"+ now.get(Calendar.YEAR);
			
				sb.append("<item>");
				sb.append("<unit>" + component.getQtyUnit() + "</unit>");
				sb.append("<expirYDate>" + expiryDate+ "</expirYDate>");
				
				sb.append("</item>");
			}
				
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			return;
	}
	
	public void populateBloodBankRegField(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int regBloodBank=0;
		regBloodBank=Integer.parseInt(request.getParameter("bloodBankId"));
		Map<String,Object> bankMap=new HashMap<String,Object>();
		List<MasHospital> hospitalList=new ArrayList<MasHospital>();
		
		jsp = "bld_bloodBankRegistry" + ".jsp";
		
		bankMap = bloodBankHandlerService.populateBloodBankRegistryJsp(regBloodBank);

		if (bankMap.get("hospitalList") != null) {
			hospitalList = (List<MasHospital>) bankMap.get("hospitalList");
		}
		StringBuffer sb = new StringBuffer();
		
			
			for (MasHospital bloodBank : hospitalList) {
			
				sb.append("<item>");
				sb.append("<Id>" + bloodBank.getId() + "</Id>");
				sb.append("<reg>" + bloodBank.getBbRegistrationNumber()
						+ "</reg>");
				sb.append("<bloodBankName>" + bloodBank.getHospitalName()
						+ "</bloodBankName>");
				sb.append("<bbavailable>" + bloodBank.getBbAvailable()
						+ "</bbavailable>");
				sb.append("<status>" + bloodBank.getStatus()
						+ "</status>");
				sb.append("<status>" + bloodBank.getStatus()
						+ "</status>");
				if (bloodBank.getContactNumber() != null) {
					sb.append("<contact>"+ bloodBank.getContactNumber()+ "</contact>");
				} 
				else {
					sb.append("<contact>" + " " + "</contact>");
				}
				if (bloodBank.getDistrict() != null) {
					sb.append("<districtId>"+ bloodBank.getDistrict().getId()+ "</districtId>");
					sb.append("<districtname>"+ bloodBank.getDistrict().getDistrictName()+ "</districtname>");
				} 
				else {
					sb.append("<districtId>" + " " + "</districtId>");
				}
				if (bloodBank.getTaluk() != null) {
					sb.append("<talukId>"+ bloodBank.getTaluk().getId()+ "</talukId>");
					sb.append("<talukname>"+ bloodBank.getTaluk().getTalukName()+ "</talukname>");
				} 
				else {
					sb.append("<talukId>" + " " + "</talukId>");
				}
				if (bloodBank.getOpeningTime() != null) {
					
					sb.append("<opentime>"+ bloodBank.getOpeningTime()+ "</opentime>");
				} 
				else {
					sb.append("<opentime>" + " " + "</opentime>");
				}
				if (bloodBank.getClosingTime() != null) {
					
					sb.append("<closetime>"+ bloodBank.getClosingTime()+ "</closetime>");
				} 
				else {
					sb.append("<closetime>" + " " + "</closetime>");
				}
				
				if (bloodBank.getValidFrom() != null) {
					
					sb.append("<validFrom>"+HMSUtil.convertDateToStringWithoutTime(bloodBank.getValidFrom()) + "</validFrom>");
				} 
				else {
					sb.append("<validFrom>" + " " + "</validFrom>");
				}
				
				if (bloodBank.getValidTo() != null) {
					
					sb.append("<validTo>"+HMSUtil.convertDateToStringWithoutTime( bloodBank.getValidTo())+ "</validTo>");
				} 
				else {
					sb.append("<validTo>" + " " + "</validTo>");
				}
				
				sb.append("</item>");
			}
				
			
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			return;
	}

	// ---------Search Patient For Transfusion Reaction----
	public ModelAndView searchPatientForTransfussionReaction(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String bloodBagNo = "";
		String entryNo = "";
		String adNo = "";
		String pType = "";
		String deptType = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		int deptId = 0;
		String deptName = "";
		String patientFName = "";
		String patientLName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(BLOOD_BAG_NO) != null
				&& !(request.getParameter(BLOOD_BAG_NO).equals(""))) {
			bloodBagNo = request.getParameter(BLOOD_BAG_NO);
			mapForDs.put("bloodBagNo", bloodBagNo);
		}
		/*
		 * String reactionDate = null; if (request.getParameter(REACTION_DATE)
		 * != null && !(request.getParameter(REACTION_DATE).equals("0"))) {
		 * reactionDate = request.getParameter(REACTION_DATE);
		 * mapForDs.put("reactionDate", reactionDate); }
		 */
		if (request.getParameter(P_FIRST_NAME) != null
				&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
			patientFName = request.getParameter(P_FIRST_NAME);
			mapForDs.put("patientFName", patientFName);
		}
		if (request.getParameter(P_LAST_NAME) != null
				&& !(request.getParameter(P_LAST_NAME).equals(""))) {
			patientLName = request.getParameter(P_LAST_NAME);
			mapForDs.put("patientLName", patientLName);
		}
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDs.put("reactionId", reactionId);
		}
		String donorName = "";
		if (request.getParameter(DONOR_NAME) != null
				&& !(request.getParameter(DONOR_NAME).equals(""))) {
			donorName = request.getParameter(DONOR_NAME);
			mapForDs.put("donorName", donorName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForTransfussionReaction(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_PND_TRANS_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitTransfussionReaction(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int componentMainIdFromRequest = 0;
		int noOfRecords = 0;
		int inpatientId = 0;
		int testBy = 0;
		int bldIssueHdId = 0;
		int pageNo = 1;
		int hinId = 0;
		int crossmatchBy = 0;
		int testSeqNo = 0;

		String fitBloodIssue = "";
		String hinNo = "";
		String date = "";
		String time = "";
		String compatibility = "";
		String minorRsDc = "";
		String majorRsDc = "";

		date = (String) utilMap.get("currentDate");
		time = (String) utilMap.get("currentTime");
		List investigationList = new ArrayList();

		@SuppressWarnings("unused")
		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("bloodIssueDetailId") != null) {
			componentMainIdFromRequest = Integer.parseInt(request
					.getParameter("bloodIssueDetailId"));
		}
		if (request.getParameter(HIN_ID) != null
				&& !request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter(HIN_NO) != null
				&& !request.getParameter(HIN_NO).equals("")) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (request.getParameter(INPATIENT_ID) != null
				&& !request.getParameter(INPATIENT_ID).equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter(TEST_NO) != null
				&& !request.getParameter(TEST_NO).equals("0")) {
			testSeqNo = Integer.parseInt(request.getParameter(TEST_NO));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("0")) {
			testBy = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(CROSS_MATCHED_BY) != null
				&& !request.getParameter(CROSS_MATCHED_BY).equals("0")) {
			crossmatchBy = Integer.parseInt(request
					.getParameter(CROSS_MATCHED_BY));
		}
		if (request.getParameter(BLOOD_ISSUE_DETAIL_ID) != null
				&& !request.getParameter(BLOOD_ISSUE_DETAIL_ID).equals("0")) {
			bldIssueHdId = Integer.parseInt(request
					.getParameter(BLOOD_ISSUE_DETAIL_ID));
		}
		if (request.getParameter(BLOOD_ISSUE) != null
				&& !(request.getParameter(BLOOD_ISSUE).equals(""))) {
			fitBloodIssue = request.getParameter(BLOOD_ISSUE);
		}
		if (request.getParameter(COMPATIBILITY) != null
				&& !(request.getParameter(COMPATIBILITY).equals(""))) {
			compatibility = request.getParameter(COMPATIBILITY);
		}
		String majorRs = "";
		if (request.getParameter(MAJOR_RS_DC) != null) {
			majorRs = "y";
		} else {
			majorRs = "n";
		}
		String majorDsDc = "";
		if (request.getParameter(MAJOR_DS_RC) != null) {
			majorDsDc = "y";
		} else {
			majorDsDc = "n";
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

		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		String feedback="";
		if (request.getParameter("feedbackdetail") != null && !request.getParameter("feedbackdetail").equals("")) {
			feedback = request.getParameter("feedbackdetail");
		}

		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			infoMap.put("userName", userName);
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		BloodTransfussionReactionHd transfussionReactionHd = new BloodTransfussionReactionHd();
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			transfussionReactionHd.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			transfussionReactionHd.setInpatient(inpatient);
		}
		if (departmentId != 0) {
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			transfussionReactionHd.setDepartment(masDepartment);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			transfussionReactionHd.setHospital(masHospital);
		}

		if (testBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(testBy);
			transfussionReactionHd.setTestBy(masEmployee);
		}
		if (crossmatchBy != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(crossmatchBy);
			transfussionReactionHd.setCrossMatchBy(masEmployee);
		}

		if (bldIssueHdId != 0) {
			BloodIssueHeader issueHeader=new BloodIssueHeader();
			issueHeader.setId(bldIssueHdId);
			//BloodReactionEntry bloodReactionEntry = new BloodReactionEntry();
			//bloodReactionEntry.setId(reactionId);
			//transfussionReactionHd.setReaction(bloodReactionEntry);
			transfussionReactionHd.setBldIssueHdId(issueHeader);
		}
		transfussionReactionHd.setFeedback(feedback);
		transfussionReactionHd.setTestNo(testSeqNo);
		int temp = bloodBankHandlerService.generateTransfusionTestNumber();

		transfussionReactionHd.setCompatibility(compatibility);
		transfussionReactionHd.setMajorRs(majorRs);
		transfussionReactionHd.setMajorDs(majorDsDc);
		transfussionReactionHd.setTestDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		transfussionReactionHd.setLastChgBy(userName);
		transfussionReactionHd.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		transfussionReactionHd.setLastChgTime(time);
		transfussionReactionHd.setReactionStatus("P");
		infoMap.put("transfussionReactionHd", transfussionReactionHd);
		infoMap.put("departmentId", departmentId);
		infoMap.put("hospitalId", hospitalId);
		infoMap.put("hinId", hinId);
		infoMap.put("testSeqNo", testSeqNo);
		infoMap.put("bldIssueHdId", bldIssueHdId);
		
		try {

			Vector result = box.getVector(RESULT);
			Vector investigation_id = box.getVector(INVESTIGATION_ID);
			int counter = 0;

			for (int i = 0; i < investigation_id.size(); i++) {
				if (!investigation_id.get(i).toString().equals("")) {
					counter++;
				}
			}
			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				investigationList.add(investigation_id.get(i));
			}

			infoMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			infoMap.put("investigationList", investigationList);
			infoMap.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		infoMap.put("box", box);
		boolean success = false;
		String jsp = "";
		String message = "";
		if (returnMap.get("testSeqNo") != null) {
			testSeqNo = (Integer) returnMap.get("testSeqNo");
		}

		boolean saved = false;
		saved = bloodBankHandlerService.submitTransfussionReaction(infoMap);
		if (saved) {
			message = "Transfusion Reaction been done Successfully !!";
		} else {
			message = "Try Again!";
		}

		jsp = BLD_MSG_REACTION_TRNASFUSION + ".jsp";
		map.put("testSeqNo", testSeqNo);
		map.put("pageNo", pageNo);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ---------show Transfusion Reaction---Screen----------
	public ModelAndView showTransfussionReaction(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptName = (String) session.getAttribute("deptName");
		int deptId = (Integer) session.getAttribute("deptId");
		int bloodIssudeDetailId = 0;
		if (request.getParameter(BLOOD_ISSUE_DETAIL_ID) != null
				&& !(request.getParameter(BLOOD_ISSUE_DETAIL_ID).equals("0"))) {
			bloodIssudeDetailId = Integer.parseInt(request
					.getParameter(BLOOD_ISSUE_DETAIL_ID));
			mapForDS.put("bloodIssudeDetailId", bloodIssudeDetailId);
		}
		int hospitalId=0;
		if(session.getAttribute("hospitalId")!=null ){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		if (bloodIssudeDetailId != 0) {
			map = bloodBankHandlerService
					.showTransfussionReaction(bloodIssudeDetailId, hospitalId);
			String testSeqNo = "";
			testSeqNo = bloodBankHandlerService
					.getTransfussionTestSeqForDisplay("TRN");
			if (testSeqNo != null) {
				map.put("testSeqNo", testSeqNo);
			}
		}
		jsp = BLOOD_TRANSFUSSION_REACTION + ".jsp";

		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ------fill donor detail related Service Number---
	public void fillDonorDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<BloodDonationEntryHeader> donationList = new ArrayList<BloodDonationEntryHeader>();
		// String hinNo = "";
		String uId = null;
		String donoruId = null;
		try {
			if (request.getParameter("uId") != null) {

				uId = request.getParameter("uId");
			}
			if (request.getParameter("donoruId") != null) {
				donoruId = request.getParameter("donoruId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("uId", uId);
		dataMap.put("donoruId", donoruId);
		map = bloodBankHandlerService.fillDonorDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		if (map.get("donationList") != null) {
			donationList = (List) map.get("donationList");
		}
		StringBuffer sb = new StringBuffer();
		System.out.println(patientList.size());

		try {
			if (null != patientList) {
				System.out.println(" patientList " + patientList.size());
				for (Patient patient : patientList) {
					System.out.println(" patientId " + patient.getId());
					System.out.println(" donorName " + patient.getPFirstName());

					sb.append("<item>");
					sb.append("<uidNo>" + patient.getHinNo() + "</uidNo>");
					sb.append("<donorName>" + patient.getPFirstName()
							+ "</donorName>");
					sb.append("<teleNo>" + patient.getPhoneNumber()
							+ "</teleNo>");
					/*
					 * if (patient.getPhoneNumber() != null) {
					 * 
					 * sb.append("<teleNo>" + patient.getPhoneNumber() +
					 * "</teleNo>"); } else { sb.append("<teleNo>" + "" +
					 * "</teleNo>"); }
					 */
					sb.append("<age>" + patient.getAge() + "</age>");

					if (patient.getMobileNumber() != null) {
						sb.append("<mobNo>" + patient.getMobileNumber()
								+ "</mobNo>");
					}
					if (patient.getBloodGroup() != null) {
						sb.append("<bloodGroupId>"
								+ patient.getBloodGroup().getId()
								+ "</bloodGroupId>");
					} else {
						sb.append("<bloodGroupId>-</bloodGroupId>");
					}
					if (patient.getIdCard() != null) {
						sb.append("<identityCardType>" + patient.getIdCard()
								+ "</identityCardType>");
					} else {
						sb.append("<identityCardType>-</identityCardType>");
					}
					/*
					 * if (patient.getState() != null) { sb.append("<stateId>" +
					 * patient.getState().getId() + "</stateId>"); } else {
					 * sb.append("<stateId>-</stateId>"); }
					 */
					if (patient.getSex() != null) {
						sb.append("<sexId>" + patient.getSex().getId()
								+ "</sexId>");
					} else {
						sb.append("<sexId>-</sexId>");
					}

					if (patient.getOccupation() != null
							&& !("" + patient.getOccupation()).trim()
									.equals("")) {
						sb.append("<occupId>" + patient.getOccupation().getId()
								+ "</occupId>");
					} else {
						sb.append("<occupId>-</occupId>");
					}
					if (map.get("ableForDonation") != null) {
						sb.append("<ableForDonation>"
								+ map.get("ableForDonation")
								+ "</ableForDonation>");
					} else {
						sb.append("<ableForDonation>" + ""
								+ "</ableForDonation>");
					}

					/*
					 * PatientAddress patientaddress=new PatientAddress();
					 * patientaddress=patient.getpati
					 */

					sb.append("</item>");
					break;

				}
			}
			if (null != donationList) {
				for (BloodDonationEntryHeader donor : donationList) {

					sb.append("<item>");
					sb.append("<uidNo>" + donor.getUhidNo() + "</uidNo>");
					sb.append("<donorName>" + donor.getDonerName()
							+ "</donorName>");
					sb.append("<fatherName>" + donor.getFatherName()
							+ "</fatherName>");
					sb.append("<organization>" + donor.getOccupation()
							+ "</organization>");

					sb.append("<emailId>" + donor.getEmail() + "</emailId>");
					sb.append("<pincodeId>" + donor.getPinCode()
							+ "</pincodeId>");

					sb.append("<landmark>" + donor.getLandMark()
							+ "</landmark>");
					sb.append("<streetNo>" + donor.getHouseAptNo()
							+ "</streetNo>");

					if (donor.getMobNo() != null) {
						sb.append("<teleNo>" + donor.getMobNo() + "</teleNo>");
					} else {
						sb.append("<teleNo>" + "" + "</teleNo>");
					}
					sb.append("<age>" + donor.getAge() + "</age>");

					if (donor.getMobNo() != null) {
						System.out.println("donor.getMobNo() "
								+ donor.getMobNo());
						sb.append("<mobNo>" + donor.getMobNo() + "</mobNo>");
					}
					if (donor.getIdentityCardNo() != null) {
						System.out.println("donor.getIdentityCardNo() "
								+ donor.getIdentityCardNo());
						sb.append("<idNo>" + donor.getIdentityCardNo()
								+ "</idNo>");
					}
					if (donor.getBloodGroup() != null) {
						sb.append("<bloodGroupId>"
								+ donor.getBloodGroup().getId()
								+ "</bloodGroupId>");
					} else {
						sb.append("<bloodGroupId>-</bloodGroupId>");
					}
					if (donor.getState() != null) {
						sb.append("<stateId>" + donor.getState().getId()
								+ "</stateId>");
					} else {
						sb.append("<stateId>-</stateId>");
					}
					if (donor.getSex() != null) {

						sb.append("<sexId>" + donor.getSex().getId()
								+ "</sexId>");
					} else {
						sb.append("<sexId>-</sexId>");
					}

					if (donor.getOccupation() != null
							&& !("" + donor.getOccupation()).trim().equals("")) {
						sb.append("<occupId>" + donor.getOccupation().getId()
								+ "</occupId>");
					} else {
						sb.append("<occupId>-</occupId>");
					}
					if (map.get("ableForDonation") != null) {
						sb.append("<ableForDonation>"
								+ map.get("ableForDonation")
								+ "</ableForDonation>");
					} else {
						sb.append("<ableForDonation>" + ""
								+ "</ableForDonation>");
					}

					/*
					 * PatientAddress patientaddress=new PatientAddress();
					 * patientaddress=patient.getpati
					 */

					sb.append("</item>");
					break;

				}
			}
			// sb.append("</items>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

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

	@SuppressWarnings("unchecked")
	public ModelAndView submitPopbloodIssue(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int stockDetailId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(STOCK_DETAIL_ID) != null
				&& !(request.getParameter(STOCK_DETAIL_ID).equals(""))) {
			stockDetailId = Integer.parseInt(request
					.getParameter(STOCK_DETAIL_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		boolean dataDeleted = false;
		dataDeleted = bloodBankHandlerService.submitPopbloodIssue(
				stockDetailId, generalMap);
		if (dataDeleted == true) {
			message = "Blood Bag Issued successfully !!";
		} else {
			message = "Try Again!!";
		}
		url = "/hms/hms/bloodBank?method=showPopUpBloodIssueJsp";
		try {
			map = bloodBankHandlerService.showPopUpBloodIssueJsp(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BLOOD_POP_UP_ISSUE;
		title = "Pop Blood issue";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateBloodDonation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = bloodBankHandlerService.updateBloodDonation(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Eror Occurred !! Try Again !!";
		}
		jsp = BLOOD_SEARCH_DONATION;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// ----method for fill detials of particular hin No............
	public void fillTestPatientDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		String hinNo = "";

		try {
			if (request.getParameter("hinId") != null) {
				hinNo = request.getParameter("hinId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("hinNo", hinNo);
		map = bloodBankHandlerService.fillDonorDetail(dataMap);
		if (map.get("patientList") != null) {
			patientList = (List) map.get("patientList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (Patient patient : patientList) {
				sb.append("<item>");
				sb.append("<hinId>" + patient.getId() + "</hinId>");
				sb.append("<name>" + patient.getPFirstName() + "</name>");
				sb.append("<age>" + patient.getAge() + "</age>");
				sb.append("<pType>" + patient.getPatientStatus() + "</pType>");
				if (patient.getPhoneNumber() != null) {
					sb.append("<teleNo>" + patient.getPhoneNumber()
							+ "</teleNo>");
				} else {
					sb.append("<teleNo>-</teleNo>");
				}
				if (patient.getSex() != null) {
					sb.append("<sexId>" + patient.getSex().getId() + "</sexId>");
				} else {
					sb.append("<sexId>-</sexId>");
				}

				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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

	// -------Methods for update test Entry------
	public ModelAndView showUpdateBloodTestEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = BLOOD_SEARCH_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientForUpdateTest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String entryNo = "";
		String hinNo = "";
		String pType = "";
		int reactionId = 0;
		int departmentId = 0;
		int hinId = 0;
		String patientName = "";
		Box box = HMSUtil.getBox(request);
		session.setAttribute("box", box);
		session = request.getSession();
		if (request.getParameter(ENTRY_NO) != null
				&& !(request.getParameter(ENTRY_NO).equals(""))) {
			entryNo = request.getParameter(ENTRY_NO);
			mapForDs.put("entryNo", entryNo);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_NAME) != null
				&& !(request.getParameter(PATIENT_NAME).equals(""))) {
			patientName = request.getParameter(PATIENT_NAME);
			mapForDs.put("patientName", patientName);
		}
		if (request.getParameter(HIN_ID) != null
				&& !(request.getParameter(HIN_ID).equals("0"))) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			mapForDs.put("hinId", hinId);
		}
		int bloodTestId = 0;
		if (request.getParameter("bloodTestId") != null
				&& !(request.getParameter("bloodTestId").equals("0"))) {
			bloodTestId = Integer.parseInt(request.getParameter("bloodTestId"));
			mapForDs.put("bloodTestId", bloodTestId);
		}

		patientMap = bloodBankHandlerService
				.searchPatientForUpdateTest(mapForDs);

		map.put("detailsMap", detailsMap);
		map.put("patientMap", patientMap);
		jsp = BLOOD_SEARCH_TEST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showUpdateReactionEntry(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int reactionId = 0;
		if (request.getParameter(BLOOD_REACTION_ID) != null
				&& !(request.getParameter(BLOOD_REACTION_ID).equals("0"))) {
			reactionId = Integer.parseInt(request
					.getParameter(BLOOD_REACTION_ID));
			mapForDS.put("bloodReactionId", reactionId);
		}
		if (reactionId != 0) {
			map = bloodBankHandlerService.showUpdateReactonEntry(reactionId);
		}
		jsp = BLOOD_UPDATE_REACTION + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	/** Mehtod for validate the result Entry 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView resultEntryValidationJsp(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int resultValidId=0;
		resultValidId=Integer.parseInt(request.getParameter("Id"));
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		map = bloodBankHandlerService.resultEntryValidationJsp(resultValidId,hospitalId);
		
		jsp = "bld_result_validate";
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		
	}

	public ModelAndView updateBloodTestEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		Box box = HMSUtil.getBox(request);

		boolean bool = bloodBankHandlerService.updateBloodTestEntry(box);
		if (bool) {
			message = "Data  updated Successfully!!";
		} else {
			message = "Error Occurred !! Try Again !!";
		}
		jsp = BLD_MSG_UPDATE_TEST;
		jsp += ".jsp";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public void fillBloodbagForDiscrad(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		String bloodbagNo = "";

		try {
			if (request.getParameter("bloodbagNo") != null) {
				bloodbagNo = request.getParameter("bloodbagNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bloodbagNo", bloodbagNo);
		map = bloodBankHandlerService.fillBloodbagForDiscrad(dataMap);
		if (map.get("bagList") != null) {
			bagList = (List) map.get("bagList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bloodStockDetail : bagList) {
				sb.append("<item>");
				sb.append("<stockId>" + bloodStockDetail.getId() + "</stockId>");
				sb.append("<hinNo>"
						+ bloodStockDetail.getStockMain().getHin().getHinNo()
						+ "</hinNo>");
				sb.append("<hinId>"
						+ bloodStockDetail.getStockMain().getHin().getId()
						+ "</hinId>");
				sb.append("<collDate>"
						+ HMSUtil
								.convertDateToStringWithoutTime(bloodStockDetail
										.getStockMain().getCollectionDate())
						+ "</collDate>");
				sb.append("<expiryDate>"
						+ HMSUtil
								.convertDateToStringWithoutTime(bloodStockDetail
										.getStockMain().getExpiryDate())
						+ "</expiryDate>");
				sb.append("<quantity>" + bloodStockDetail.getQty()
						+ "</quantity>");
				sb.append("<name>" + bloodStockDetail.getStockMain().getName()
						+ "</name>");

				if (bloodStockDetail.getStockMain().getHin().getBloodGroup() != null) {
					sb.append("<bloodGroupId>"
							+ bloodStockDetail.getStockMain().getHin()
									.getBloodGroup().getId()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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

	// --------Fill recod for reaction form related blood bag no--
	public void fillBloodbagForReaction(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<BloodStockDetail> bagList = new ArrayList<BloodStockDetail>();
		String bloodBagNo = "";

		try {
			if (request.getParameter("bloodBagNo") != null) {
				bloodBagNo = request.getParameter("bloodBagNo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("bloodBagNo", bloodBagNo);
		map = bloodBankHandlerService.fillBloodbagForReaction(dataMap);
		if (map.get("bagList") != null) {
			bagList = (List) map.get("bagList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			sb.append("<items>");
			for (BloodStockDetail bloodStockDetail : bagList) {
				sb.append("<item>");
				sb.append("<stockId>" + bloodStockDetail.getId() + "</stockId>");
				sb.append("<donorName>"
						+ bloodStockDetail.getStockMain().getName()
						+ "</donorName>");
				if (bloodStockDetail.getStockMain().getBloodGroup() != null) {
					sb.append("<bloodGroupId>"
							+ bloodStockDetail.getStockMain().getBloodGroup()
							+ "</bloodGroupId>");
				} else {
					sb.append("<bloodGroupId>-</bloodGroupId>");
				}
				sb.append("</item>");
				break;
			}
			sb.append("</items>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<chargeCodes>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</chargeCodes>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkBloodBagNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String bloodBagId = "";
		String exists = "no";
		if (request.getParameter("bloodBagId") != null) {
			bloodBagId = (request.getParameter("bloodBagId"));
		}
		dataMap.put("bloodBagId", bloodBagId);
		map = bloodBankHandlerService.chechBloodBag(dataMap);
		if (map.get("exists") != null) {
			exists = "" + map.get("exists");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<exists>" + exists + "</exists>");
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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

	public void fillItemsForComponentnameSeperation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String componentName = "";
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		try {
			if (request.getParameter("componentName") != null) {
				componentName = request.getParameter("componentName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("componentName", componentName);

		map = bloodBankHandlerService
				.fillItemsForComponentnameSeparation(dataMap);
		if (map.get("componentList") != null) {
			componentList = (List) map.get("componentList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (BloodMasComponent bloodMasComponent : componentList) {
			sb.append("<item>");
			sb.append("<componentId>" + bloodMasComponent.getId()
					+ "</componentId>");
			sb.append("<componentCode>" + bloodMasComponent.getComponentCode()
					+ "</componentCode>");
			sb.append("<quantity>" + bloodMasComponent.getQtyUnit()
					+ "</quantity>");
			sb.append("</item>");
		}
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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
	
	
	
	
	/**
	 * @param request
	 * @param response
	 */
	public void populateBagDetalForIndent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		int componentId = 0;
		int bloodGroupId = 0;
			if (request.getParameter("componentId") != null) {
				componentId =Integer.parseInt(request.getParameter("componentId")) ;
			}
			
			if (request.getParameter("bloodGroupId") != null) {
				bloodGroupId =Integer.parseInt(request.getParameter("bloodGroupId")) ;
			}
		
		dataMap.put("componentId", componentId);
		dataMap.put("bloodGroupId", bloodGroupId);

		map = bloodBankHandlerService.populateBagDetalForIndent(dataMap);
		List<BloodStockDetail> bldStockDetailsList=new ArrayList<BloodStockDetail>();
		
		if (map.get("bldStockDetailsList") != null) {
			bldStockDetailsList = (List<BloodStockDetail>) map.get("bldStockDetailsList");
		}
		StringBuffer sb = new StringBuffer();

		sb.append("<items>");
		for (BloodStockDetail bloodStockDetail : bldStockDetailsList) {
			sb.append("<item>");
			sb.append("<bagNo>" + bloodStockDetail.getBloodBagNo()
					+ "</bagNo>");
			sb.append("<quantity>" + bloodStockDetail.getQty()
					+ "</quantity>");
			sb.append("<expiryDate>" +HMSUtil.convertDateToStringTypeDateOnly(bloodStockDetail.getExpiryDate()) 
					+ "</expiryDate>");
			sb.append("</item>");
		}
		sb.append("</items>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
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
	
	/** Mehtod for save issued od Indent details
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveIssueofIndent(HttpServletRequest request, HttpServletResponse response){
		
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> datamap=new HashMap<String,Object>();
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		
		Box box=HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		
		
		map = bloodBankHandlerService.saveIssueofIndent(box);
		
		boolean status=false;
		String message="";
		status=(Boolean) map.get("status");
		if(status){
			message="Indent completed Sucussfully ";
		}
		else{
			message="Some Error Occur !  ";
		}
		jsp = "msg_bld_Indent";
		jsp += ".jsp";
		title = "Blood Component separation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView submitBloodComponentSeperation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		Vector<String> blood_bag_no = new Vector<String>();
		boolean saved = false;
		int noOfRecords = 0;
		int stockMainId = 0;
		int componentMainIdFromRequest = 0;
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		List componentList = new ArrayList();
		List qtyList = new ArrayList();
		BloodStockMain stockMain = new BloodStockMain();
		int stockDtId = 0;
		if (request.getParameter("counter") != null) {
			noOfRecords = Integer.parseInt(request.getParameter("counter"));
		}
		if (request.getParameter(BLOOD_STOCK_MAIN_ID) != null
				&& !(request.getParameter(BLOOD_STOCK_MAIN_ID).equals(""))) {
			stockMainId = Integer.parseInt(request
					.getParameter(BLOOD_STOCK_MAIN_ID));
		}
		if (request.getParameter("stockDtId") != null
				&& !request.getParameter("stockDtId").equals("")) {
			stockDtId = Integer.parseInt(request.getParameter("stockDtId"));
			
		}
		dataMap.put("stockMainId", stockMainId);
		dataMap.put("stockDtId", stockDtId);
		dataMap.put("stockMain", stockMain);

		try {
			int counter = 0;
			int count=box.getInt("hiddenValue");
			Vector tube_bag_no=new Vector();
			
			for(int i=1;i<=count; i++){
				tube_bag_no.add(box.get("tubeNumber"+i));
			}
			
			
			for(int i=1;i<=count; i++){
				blood_bag_no.add(box.get("bagNo"+i));
			}
			
			Vector stock_mainId = box.getVector("smainId");
			
			Vector quantity =new Vector();
			
			for(int i=1;i<=count; i++){
				quantity.add(box.get("childquantity"+i));
			}
			
			Vector expiry =new Vector<Date>();
			
			for(int i=1;i<=count; i++){
				expiry.add(HMSUtil.convertStringTypeDateToDateType(box.get("dateOfBirth"+i)) );
			}
			
			
			Vector component_id = new Vector();
			Vector bloodComponentName =new Vector();
			
			for(int i=1;i<=count; i++){
				bloodComponentName.add(box.get("mascomponentName"+i));
			}
			
			
			component_id.clear();
			for (int cnt = 0; cnt < bloodComponentName.size(); cnt++) {
				if (!bloodComponentName.get(cnt).equals("")) {
					String name = (String) bloodComponentName.get(cnt);

					/*int index = name.lastIndexOf("[");
					index++;
					int id = Integer.parseInt(name.substring(index,
							(name.length() - 1)));*/
					
					int id = Integer.parseInt(name);
					
					counter++;
					component_id.add(id);
				}
			}

			noOfRecords = counter;
			for (int i = 0; i < noOfRecords; i++) {
				componentList.add(component_id.get(i));
				qtyList.add(quantity.get(i));
			}
			dataMap.put("stock_mainId", stockMainId);
			dataMap.put("expiry", expiry);
			dataMap.put("blood_bag_no", blood_bag_no);
			dataMap.put("tube_bag_no", tube_bag_no);
			dataMap.put("quantity", quantity);
			dataMap.put("componentMainIdFromRequest",
					componentMainIdFromRequest);
			dataMap.put("componentList", componentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("box", box);
		map = bloodBankHandlerService.submitBloodComponentSeperation(box,
				dataMap);
		saved = (Boolean) map.get("saved");
		if (saved == true) {
			message = "Component Seperation Done Successfully !!";
		} else {
			message = "Try Again !!";
		}
		jsp = BLD_MSG_COMP_SEPRATION;
		jsp += ".jsp";
		title = "Blood Component separation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		map.put("stockDtId", stockDtId);
		map.put("blood_bag_no", blood_bag_no);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showBloodStockReportjsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = bloodBankHandlerService.showBloodStockRegisterjsp();

		jsp = BLOOD_STOCK_REGISTER_JSP;

		jsp += ".jsp";

		title = "Total Admission";

		map.put("contentJsp", jsp);

		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	
	/**Save Indent request
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitBloodIndentRequest(HttpServletRequest request,
			HttpServletResponse response){
		
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		String message="Blood Indent Successful";
		
		String indentOrderNo = "";
		
		indentOrderNo=bloodBankHandlerService.generateIndentOrderNumber();
		box.put("indentOrderNo", indentOrderNo);
		map = bloodBankHandlerService.submitBloodIndentRequest(box);
		
		jsp = "msg_bloodIndent";

		jsp += ".jsp";

		title = "Total Admission";

		map.put("contentJsp", jsp);

		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView printBloodStockReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String detailSummry = "";
		String bloodComponentName = "All";
		String query = "";
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
		}
		if ((!request.getParameter(BLOOD_COMPONENT_ID).equals("0"))
				&& (request.getParameter(BLOOD_COMPONENT_ID) != null)) {
			if (request.getParameter(BLOOD_COMPONENT_NAME) != null) {
				String componentname=request.getParameter(BLOOD_COMPONENT_NAME);
				
				/*query = "where blood_mas_component.`component_name` = '"
						+ request.getParameter(BLOOD_COMPONENT_NAME) + "' and ";*/
				query = "and blood_mas_component.component_name = '"+ componentname + "'";
			}
		}
		if (request.getParameter("summaryDetail") != null) {
			detailSummry = request.getParameter("summaryDetail");
		}
		detailsMap = bloodBankHandlerService.getDBConnection();
		parameters.put("QUERY", query);
		parameters.put("hospitalId", hospitalId);
		if (null !=detailSummry && !detailSummry.equals("") && detailSummry.equals("summary")) {
			HMSUtil.generateReport("bld_stock_reportNew", parameters,(Connection) detailsMap.get("con"), response,getServletContext());
		}
		if (detailSummry.equals("details")) {
			HMSUtil.generateReport("bld_stock_dt_report", parameters,(Connection) detailsMap.get("con"), response,getServletContext());

		}
		return null;
	}
	public ModelAndView printBloodBagNoReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>(); 
		HttpSession session=request.getSession();
		String bagNo = ""; 
		int hospitalId=0;
		if (request.getParameter("bagNo") != null) {
			bagNo = request.getParameter("bagNo"); 
		}if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
		}
		detailsMap = bloodBankHandlerService.getDBConnection();
		parameters.put("bagNo", bagNo);  
		parameters.put("hospitalId", hospitalId);
		HMSUtil.generateReport("blood_bag", parameters,
					(Connection) detailsMap.get("con"), response,
					getServletContext()); 
		return null;
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void populateDistrictByStateId(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		HttpSession session=request.getSession();
		int hospitalId=0;
		int stateId=0;
		if(null !=request.getParameter("stateId") && !request.getParameter("stateId").equals("")){
			stateId=Integer.parseInt(request.getParameter("stateId"));
		}
		
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId=Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
		}
		detailsMap = bloodBankHandlerService.populateDistrictByStateId(stateId);
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		if(null !=detailsMap.get("districtList")){
			districtList=(List<MasDistrict>)detailsMap.get("districtList");
			
		}
		StringBuffer sb = new StringBuffer();
		
		if(null !=districtList && districtList.size()>0){
			for (MasDistrict district : districtList) {
			sb.append("<item>");
			sb.append("<id>" + district.getId() + "</id>");
			sb.append("<name>" + district.getDistrictName() + "</name>");
			
			sb.append("</item>");
		
			}
		}
		else{
			sb.append("<item>");
			sb.append("<id>" + "" + "</id>");
			sb.append("<name>" + "" + "</name>");
			
			sb.append("</item>");
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
	
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		
		
	
	}
	public ModelAndView	showSearchPatientRecordsForVisitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> getDataMap = new HashMap<String, Object>();
		//ArrayList<Patient> patientDetailsMap = ArrayList<Patient>;
		
		String uhid="";
		String pUhid="";
		int deptId =0;
		int hospitalId = 0;
		String FromAge="";
		String toAge="";
		
		HttpSession session = request.getSession();
		
		 int page = 1;
		 if(request.getParameter("page") != null){
	            page = Integer.parseInt(request.getParameter("page"));    
	           
		 }
		 getDataMap.put("page",page);
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			getDataMap.put("hospitalId", hospitalId);
		}
		if(session.getAttribute("deptId")!=null)
		{
			deptId = (Integer)session.getAttribute("deptId");
			getDataMap.put("deptId", deptId);
		}
		
		if(request.getParameter("fromDate") != null && !request.getParameter("fromDate").equals("") ){
			FromAge=request.getParameter("fromDate");
			getDataMap.put("FromAge", FromAge);
		}
		
		
		if(request.getParameter("toDate") != null && !request.getParameter("toDate").equals("") ){
			toAge=request.getParameter("toDate");
			getDataMap.put("toAge", toAge);
		}
		
		if(request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("") ){
			uhid=request.getParameter(HIN_NO);
			getDataMap.put("uhid", uhid);
			map.put("uhid", uhid);
			
		}
		if(request.getParameter("hinNo") != null && !request.getParameter("hinNo").equals("") ){
			uhid=request.getParameter("hinNo");
			getDataMap.put("uhid", uhid);
			
			
		}
		
		String fullName="";
		if(request.getParameter(P_FULL_NAME) != null && !request.getParameter(P_FULL_NAME).equals("") ){
			fullName = request.getParameter(P_FULL_NAME).trim();
			
			getDataMap.put("fullName", fullName);
		}
		if(request.getParameter("fn") != null && !request.getParameter("fn").equals("") ){
			fullName = request.getParameter("fn").trim();
			
			getDataMap.put("fullName", fullName);
		}
		String mobNo="";
		if(request.getParameter("mobno") != null && !request.getParameter("mobno").equals("") ){
			mobNo = request.getParameter("mobno").trim();
			
			getDataMap.put("mobno", mobNo);
		}
		if(request.getParameter("moNo") != null && !request.getParameter("moNo").equals("") ){
			mobNo = request.getParameter("moNo").trim();
			
			getDataMap.put("mobno", mobNo);
		}
		
		Date dateOfBirth=null;
		if(request.getParameter("dob")!=null && !request.getParameter("dob").equals("")){
		dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("dob"));
		getDataMap.put("dateOfBirth", dateOfBirth);
		}
		if(request.getParameter("bitD")!=null && !request.getParameter("bitD").equals("") && !request.getParameter("bitD").equals("null")){
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("bitD"));
			getDataMap.put("dateOfBirth", dateOfBirth);
			}
		
		if(request.getParameter("pUhid") != null && !request.getParameter("pUhid").equals("") ){
			pUhid = request.getParameter("pUhid").trim();
		}
		
			map=bloodBankHandlerService.showSearchPatientRecordsForVisitJsp(getDataMap);
	/*map.put("getDa	taMap", getDataMap);*/
		
		String jsp = "bld_DonationEntry";
		/*jsp = "registration";*/
		jsp += ".jsp";
		map.put("pUhid", pUhid);
		map.put("contentJsp", jsp);
		map.put("uhid", uhid);
		map.put("fullName",fullName);
		map.put("mobno", mobNo);
		//map.put("message", message);
		return new ModelAndView("index", "map", map);
		
	}
	
	public void populateDonorRegistrationFrom(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> visitmap = new HashMap<String, Object>();
		int deptId =0;
		int hospitalId = 0;
		String uhinNo="";
		
		String onlineRegStatus="";
		
		if (request.getParameter("onlineRegStatus") != null
				&& !(request.getParameter("onlineRegStatus").equals(""))) {
			onlineRegStatus = request.getParameter("onlineRegStatus");
			
			/*map=registrationHandlerService.visitCreation(hinNo);*/
		}
		
		
		if (request.getParameter("patientHinNo") != null
				&& !(request.getParameter("patientHinNo").equals(""))) {
			uhinNo = request.getParameter("patientHinNo");
			
			/*map=registrationHandlerService.visitCreation(hinNo);*/
		}
				
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if(session.getAttribute("deptId")!=null)
		{
			deptId = (Integer)session.getAttribute("deptId");
		}
		int page=1;
		boolean assestmentStatus=false;
		map = bloodBankHandlerService.populateDonorRegistrationFrom(deptId,hospitalId,uhinNo,page);
		if(null !=map.get("assestmentStatus")){
			assestmentStatus=(Boolean)map.get("assestmentStatus");
		}
		
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>) map.get("patientDetailsList");
		
		List<PatientAddress> addressList = new ArrayList<PatientAddress>();
		addressList = (List<PatientAddress>) map.get("addressList");
		
		int patientvisitNo=0;
		
		
		
		String patientUHinNo="";
		String patientName="";
		String mobileNumber="";
		String patientAge="";
		String temppatientAge[]=null;
		String NameOf="";
		String relativeName="";
		int occupation=0;
		String pcategory="";
		String patientGender="";
		int patientHinNo=0;
		int pcategoryId=0;
		
		String LastvisitDate="";
		String docotorName="";
		String visitdepartName="";
		String patientPastDue="";
		int patientGenderid=0;
		String email="";
		String dob=null;
		
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<onlineRegStatus>" + onlineRegStatus
				+ "</onlineRegStatus>");
		
		for (Patient patient : patientList) {
			patientUHinNo=patient.getHinNo();
			patientHinNo=patient.getId();
			patientName=patient.getPFirstName();
			mobileNumber=patient.getMobileNumber();
			if(null !=patient.getAge() && !patient.getAge().equals("")){
			patientAge=patient.getAge();
			
			temppatientAge=patientAge.trim().split(" ");
			
			}
			if(null !=patient.getDateOfBirth())
			dob=HMSUtil.convertDateToStringTypeDateOnly( patient.getDateOfBirth());
			if(null!=patient.getRelation()){
			NameOf=patient.getRelation().getRelationName();
			}
			relativeName=patient.getFatherMotherName();
			
			if(null != patient.getOccupation())
			{
			occupation=patient.getOccupation().getId();
			}
			if(null !=patient.getPatientType()){
			pcategory=patient.getPatientType().getPatientTypeName();
			pcategoryId=patient.getPatientType().getId();
			}
			if(null!=patient.getSex()){
			patientGender=patient.getSex().getAdministrativeSexName();
			
			patientGenderid=patient.getSex().getId();
			}
			if(null !=patient.getEmailId())
			email=patient.getEmailId();
		}
			
		sb.append("<email>" + email
				+ "</email>");
			sb.append("<Uhid>" + patientUHinNo
					+ "</Uhid>");
			sb.append("<hinId>" + patientHinNo
					+ "</hinId>");
			
			
			if (dob!= null
			&& !dob.equals("")) {
		sb.append("<dob>" + dob + "</dob>");
	} else {
		sb.append("<dob>" + " " + "</dob>");
	}
			if (patientName!= null
					&& !patientName.equals("")) {
				sb.append("<name>" + patientName + "</name>");
			} else {
				sb.append("<name>" + " " + "</name>");
			}
			if (mobileNumber != null
					&& !mobileNumber.equals("")) {
				sb.append("<mobileNo>" + mobileNumber
						+ "</mobileNo>");
			} else {
				sb.append("<mobileNo>" + "" + "</mobileNo>");
			}

			if ( patientAge!= null && !patientAge.equals("")) {
				sb.append("<page>" + temppatientAge[0] + "</page>");
			} 
			else {
				sb.append("<page>" + "" + "</page>");
			}
			if ( NameOf!= null
					&& !NameOf.equals("")) {
				sb.append("<NameOf>" + NameOf
						+ "</NameOf>");
			} else {
				sb.append("<NameOf>" + " " + "</NameOf>");
			}
			if (relativeName != null
					&& !relativeName.equals("")) {
				sb.append("<RelativeName>" +relativeName 
						+ "</RelativeName>");
			} else {
				sb.append("<RelativeName>" + " " + "</RelativeName>");
			}
			if (occupation >0) {
				sb.append("<Occupation>" + occupation
						+ "</Occupation>");
			} else {
				sb.append("<Occupation>" + " " + "</Occupation>");
			}
			if (pcategory != null
					&& !pcategory.equals("")) {
				sb.append("<Category>" + pcategory
						+ "</Category>");
				sb.append("<CategoryId>" + pcategoryId
						+ "</CategoryId>");
			} else {
				sb.append("<Category>" + " " + "</Category>");
			}
			if (patientGender != null
					&& !patientGender.equals("")) {
				
				sb.append("<Gender>" + patientGender
						+ "</Gender>");
				sb.append("<GenderId>" + patientGenderid
						+ "</GenderId>");
			} else {
				sb.append("<Gender>" + " " + "</Gender>");
				sb.append("<GenderId>" + ""
						+ "</GenderId>");
			}
			
				sb.append("<assesstSatatus>" + assestmentStatus + "</assesstSatatus>");
				
			
			
			Properties properties = new Properties();
		       URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		      
		       try
		       {
		               properties.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       int aadhaarAddressTypeId = Integer.parseInt(properties.getProperty("aadhaarAddressTypeId"));
		       
			if(null !=addressList && addressList.size()>0){
				for(PatientAddress address :addressList){
					
					if(address.getAddressType().getId()==aadhaarAddressTypeId){
						if(address.getState() !=null ){
						sb.append("<stateId>" + address.getState().getId()
								+ "</stateId>");
						}
						else{
							sb.append("<stateId>" + ""
									+ "</stateId>");
						}
						if(address.getDistrict() !=null){
							sb.append("<districtId>" + address.getDistrict().getId()
									+ "</districtId>");
						}
						else{
							sb.append("<districtId>" + ""
									+ "</districtId>");
						}
						if(address.getTaluk()!=null){
							sb.append("<talukId>" + address.getTaluk().getId()
									+ "</talukId>");
						}
						else{
							sb.append("<talukId>" + ""
									+ "</talukId>");
						}
						if(address.getPostOffice() !=null){
							sb.append("<postOfficeId>" + address.getPostOffice().getId()
									+ "</postOfficeId>");
							sb.append("<postCode>" + address.getPostOffice().getId()
									+ "</postCode>");
						}
						else{
							sb.append("<postOfficeId>" + ""
									+ "</postOfficeId>");
							sb.append("<postCode>" + ""
									+ "</postCode>");
						}
					}
				}
			}
		
		
		sb.append("</item>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	
	response.getWriter().close();

		//
		//return;
	}
	public ModelAndView printBarcode(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>(); 
		int hospitalId = 0;
		String bagNo = "";
		String hinNoRandom="";
		HttpSession session = request.getSession();
		
	
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter("bagNo") != null) {
			bagNo = request.getParameter("bagNo");
			parameters.put("bagNo", bagNo);
		}

		//parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("blood_bag_bar_code", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}
	public ModelAndView showbloodBagBarCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		jsp = "bld_printBagBarCode";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showbloodBagCrossCheckJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Box box = HMSUtil.getBox(request);
		int page = 1;
		int recordsPerPage = 5;

		if (null != request.getParameter("page")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		box.put("page", page);
		box.put("recordsPerPage", recordsPerPage);

		
		//map = bloodBankHandlerService.getSampleScreeningTestGrid(box);
		map = bloodBankHandlerService.getSampleCrossMatchingTestGrid(box);
		
		jsp = "bld_sample_cross_checking";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showbloodBagCrossCheckDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		//session = request.getSession();ffff
	
	// strat
	 
		Box box = HMSUtil.getBox(request); 
		boolean saved = true;
		int hospitalId = 0;
		int sampleId = box.getInt("sampleId");
		String userName = "";

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			System.out.println("hospitalId "+hospitalId);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		int requestHeaderId = 0;
		int newRequestId = 0;
		
		//map = bloodBankHandlerService.submitSampleOfBlood(box); 
		BloodSampleCollection bloodSampleCollection=null;
		if(map.get("bloodSampleCollection")!=null){
			bloodSampleCollection = (BloodSampleCollection) map.get("bloodSampleCollection");
		}
		
		if(map.get("saved")!=null){
			saved = (Boolean) map.get("saved");
		}
		String messageTOBeVisibleToTheUser = "";
		if (saved) {
			messageTOBeVisibleToTheUser = "Blood Sample Collection Done Successfully !!";
			map.put("bagNumber", box.get("bagNumber"));
		} else {
			messageTOBeVisibleToTheUser = "Some Problem Occured !! Try Again ..";
		} 
	
	
	//end
		String bagNum = null;
		String tubNum = null;
		int quantityNum =0;

		//String samplId = request.getParameter("samplId");
		//if (null != samplId && !samplId.isEmpty()) {
		
		bagNum =bloodSampleCollection.getBagNumber() ;
		tubNum = bloodSampleCollection.getTubeNumber();
		quantityNum = bloodSampleCollection.getComponentQuantity();
			/*bagNum = request.getParameter("bagNum" + samplId);
			tubNum = request.getParameter("tubNum" + samplId);
			quantityNum = request.getParameter("quantityNum" + samplId);
*/
		//}
		//map = (Map<String, Object>) bloodBankHandlerService.showBloodTestList();
		jsp = "bld_sample_cross_check_detail";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("samplId", sampleId);
		map.put("bagNum", bagNum);
		map.put("tubNum", tubNum);
		map.put("quantityNum", quantityNum);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveUntestedBloodBags(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		String bagNum = null;
		String tubNum = null;
		String quantityNum = null;
		Box box=HMSUtil.getBox(request);
		int hospitalId=0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String samplId = request.getParameter("sampleSequenceId");
		//System.out.println("samplId  "+samplId);
		if (null != samplId && !samplId.isEmpty()) {

			bagNum = request.getParameter("BagNumber" );
			tubNum = request.getParameter("TubeNumber" );
			quantityNum = request.getParameter("Quntity");

		}
		box.put("hospitalId", hospitalId);
		box.put("samplId", samplId);
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		
		box.put("userId", userId);
		
		String message="";
		boolean status=false;
		
		map =  bloodBankHandlerService.saveUntestedBloodBags(box);
		if(null != map.get("status")){
			status=(Boolean)map.get("status");
		}
		if(status){
			message="Data Saved Successfully ";
		}
		jsp = "msg_bld_cross_check_detail";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("samplId", samplId);
		map.put("bagNum", bagNum);
		map.put("tubNum", tubNum);
		map.put("quantityNum", quantityNum);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("status", status);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView printBloodBagSticker(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int hospitalId = 0;
		String bloodBagNo="";
		if(null !=request.getParameter("bloodBagNo")){
			bloodBagNo=request.getParameter("bloodBagNo");
		}
		
		HttpSession session = request.getSession();
		
	
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		
		int stockDetailId = 0;
		stockDetailId = Integer.parseInt(request.getParameter("stockDetailName"));
		

		parameters.put("bloodBagNo", bloodBagNo);
		parameters.put("hospitalId", hospitalId);
		parameters.put("stockDetailId", stockDetailId);
		//parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("bld_product_sticker", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}

	public void populateItemDetailFromStock(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		int hospitalId=0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int deptId=0;
		if(session.getAttribute("deptId")!=null)
		{
			deptId = (Integer)session.getAttribute("deptId");
		}
		 int itemId=0;
		 if(null !=request.getParameter("itemId") &&  !request.getParameter("itemId").equals("")){
			 itemId=Integer.parseInt(request.getParameter("itemId")) ;
		 }
		map = bloodBankHandlerService.populateItemDetailFromStock(deptId,hospitalId,itemId);
		
		List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
		bagTypeList = (List<StoreItemBatchStock>) map.get("bagTypeList");
		
		StringBuffer sb = new StringBuffer();
		
		
		if(null !=bagTypeList && bagTypeList.size()>0){
			for(StoreItemBatchStock stock:bagTypeList){
				sb.append("<item>");
				//System.out.println("stock.getBatchNo()  "+stock.getBatchNo());
					sb.append("<batchNo>" + stock.getBatchNo()
							+ "</batchNo>");
					sb.append("<itemId>" + stock.getId()
							+ "</itemId>");
					sb.append("<ExpiryDate>" + stock.getExpiryDate()
							+ "</ExpiryDate>");
					sb.append("</item>");
					
			}
			    
		}
		else{
			sb.append("<item>");
			//System.out.println("stock.getBatchNo()  "+stock.getBatchNo());
				sb.append("<batchNo>" + ""
						+ "</batchNo>");
				sb.append("<ExpiryDate>" + ""
						+ "</ExpiryDate>");
				sb.append("</item>");
		}
		
		
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	//System.out.println(sb.toString());
	

		
	}
	
	public ModelAndView getForDateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String hin_no="";
		if(request.getParameter("hin_no")!=null){
			hin_no=request.getParameter("hin_no");
		}
		
		jsp = "dateForEHRJsp";
		//jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hin_no",hin_no);
		System.out.println(""+hin_no);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	
	
	
	
	public void populateBagVolume(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
	
		int hospitalId=0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int deptId=0;
		if(session.getAttribute("deptId")!=null)
		{
			deptId = (Integer)session.getAttribute("deptId");
		}
		 int itemId=0;
		 if(null !=request.getParameter("itemId") &&  !request.getParameter("itemId").equals("")){
			 itemId=Integer.parseInt(request.getParameter("itemId")) ;
		 }
		map = bloodBankHandlerService.populateBagVolume(deptId,hospitalId,itemId);
		
		List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
		bagTypeList = (List<StoreItemBatchStock>) map.get("bagTypeList");
		
		StringBuffer sb = new StringBuffer();
		
		
		if(null !=bagTypeList && bagTypeList.size()>0){
			for(StoreItemBatchStock stock:bagTypeList){
				sb.append("<item>");
				System.out.println("####stock.getBatchNo()  "+stock.getOpeningBalanceQty());
					sb.append("<ExipryDate>" + stock.getExpiryDate()
							+ "</ExipryDate>");
					sb.append("<volume>" + stock.getOpeningBalanceQty()
							+ "</volume>");
					
					sb.append("</item>");
					
			}
			    
		}
		else{
			sb.append("<item>");
			//System.out.println("stock.getBatchNo()  "+stock.getBatchNo());
				sb.append("<ExipryDate>" + ""
						+ "</ExipryDate>");
				sb.append("<volume>" + ""
						+ "</volume>");
				sb.append("</item>");
		}
		
		
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	//System.out.println(sb.toString());
	

		
	}

	public void populateBagVolume1(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		int hospitalId=0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int deptId=0;
		if(session.getAttribute("deptId")!=null)
		{
			deptId = (Integer)session.getAttribute("deptId");
		}
		 int itemId=0;
		 if(null !=request.getParameter("itemId") &&  !request.getParameter("itemId").equals("")){
			 itemId=Integer.parseInt(request.getParameter("itemId")) ;
		 }
		map = bloodBankHandlerService.populateBagVolume(deptId,hospitalId,itemId);
		
		List<StoreItemBatchStock> bagTypeList = new ArrayList<StoreItemBatchStock>();
		bagTypeList = (List<StoreItemBatchStock>) map.get("bagTypeList");
		
		StringBuffer sb = new StringBuffer();
		
		
		if(null !=bagTypeList && bagTypeList.size()>0){
			for(StoreItemBatchStock stock:bagTypeList){
				sb.append("<item>");
				
					sb.append("<ExipryDate>" +HMSUtil.changeDateToddMMyyyy(stock.getExpiryDate()) 
							+ "</ExipryDate>");
					sb.append("<volume>" + stock.getOpeningBalanceQty()
							+ "</volume>");
					
					sb.append("</item>");
					
			}
			    
		}
		else{
			sb.append("<item>");
			//System.out.println("stock.getBatchNo()  "+stock.getBatchNo());
				sb.append("<ExipryDate>" + ""
						+ "</ExipryDate>");
				sb.append("<volume>" + ""
						+ "</volume>");
				sb.append("</item>");
		}
		
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	//System.out.println(sb.toString());
	

		
	}
	public ModelAndView showTransfussionFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		
		int hospitalId=0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		map = bloodBankHandlerService.showTransfussionFeedback(hospitalId);
		jsp = "transFussionFeedbackJsp";
		jsp += ".jsp";
		title = "transFussionFeedbackJsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView showtransfussionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		
		int hospitalId=0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int bldReactionEntryDetaiId=0;
		
		 if(null !=request.getParameter("bldReactionEntryDetaiId") &&  !request.getParameter("bldReactionEntryDetaiId").equals("")){
			 bldReactionEntryDetaiId=Integer.parseInt(request.getParameter("bldReactionEntryDetaiId")) ;
		 }
		map = bloodBankHandlerService.showtransfussionDetails(hospitalId,bldReactionEntryDetaiId);
		jsp = "transfussionFeedbackDetails";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
		
	}
	public ModelAndView submitDonorDeferredDate(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String,Object> map=new HashMap<String,Object>();
		boolean status = false;
		String message = "";
		String assesstmentMid = request.getParameter("assesstmentMid");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map.put("box", box);
		
		
	map=bloodBankHandlerService.submitDonorDeferredDate(box);
	status=(Boolean)map.get("save");
		if (status) {
			message = "Data save successful";
		} else {
			message = "error";
		}
		int donorAsstId=box.getInt("donorAssesstMid");
		
		jsp = "bld_donorDefferdSubmitMsg" + ".jsp";
		//jsp = "bld_MsgDonoorAssessment" + ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("assesstmentMid", assesstmentMid);
		map.put("donorAsstId", donorAsstId);
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView showPendingbloodRequestJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();*/
		HttpSession session = request.getSession();
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		detailsMap.put("hospitalId", hospitalId);
		String deptName = "";
		if (session.getAttribute("deptName") != null) {
			deptName = (String) session.getAttribute("deptName");
		}
		map=bloodBankHandlerService.showPendingbloodRequestJsp(detailsMap);
		
		/*detailsMap = bloodBankHandlerService.getDetailsForSampleValidation();
		patientMap = bloodBankHandlerService.getSampleValidationGrid(mapForDs);*/
		
		//jsp = "bld_pendingBloodRequest.jsp";
		//map.put("detailsMap", detailsMap);
		
		jsp = "bld_pendingBlooldRequest";
		jsp += ".jsp";
		title = "BloodComponent";
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public void populatebloodBankQuantity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datmap = new HashMap<String, Object>();
	
		int bloodBankId = 0;
		int bloodGroupId = 0;
		String componentName="";
		
		if (request.getParameter("bloodBankId") != null
				&& !(request.getParameter("bloodBankId").equals(""))) {
			bloodBankId =Integer.parseInt(request.getParameter("bloodBankId"));	
		}
		
		if (request.getParameter("bloodGroupId") != null
				&& !(request.getParameter("bloodGroupId").equals(""))) {
			bloodGroupId =Integer.parseInt(request.getParameter("bloodGroupId"));	
		}
		
		if (request.getParameter("componentName") != null
				&& !(request.getParameter("componentName").equals(""))) {
			componentName =request.getParameter("componentName");	
		}
			
		datmap.put("bloodBankId", bloodBankId);
		datmap.put("bloodGroupId", bloodGroupId);
		datmap.put("componentName", componentName);
		
		int count=0;
		
		map = bloodBankHandlerService.populatebloodBankQuantity(datmap);
		
	if(null !=map.get("count")){
		count=(Integer)map.get("count");
	}
	
	
		StringBuffer sb = null;
		sb = new StringBuffer();
		
			sb.append("<item>");
			sb.append("<unitId>" +count+"</unitId>");
				
			
			sb.append("</item>");
		

	
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	response.getWriter().write(
			"<?xml version='1.0' encoding='ISO-8859-1'?>");
	response.getWriter().write("<items>");
	response.getWriter().write(sb.toString());
	response.getWriter().write("</items>");
	

		//
		
	}
	public ModelAndView printBarCodeStickerForContainer(HttpServletRequest request,
			HttpServletResponse response){

		//
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int hospitalId = 0;
		
		HttpSession session = request.getSession();
		
	
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String uhidNo="";
		
		if(request.getParameter("uhidNo") != null){
			uhidNo =request.getParameter("uhidNo");
		}
		
		int bloodrequestHeaderId=0;
		if(request.getParameter("bloodrequestHeaderId") != null){
			bloodrequestHeaderId =Integer.parseInt(request.getParameter("bloodrequestHeaderId"));
		}
		int hinId=0;
		if(request.getParameter("hinId") != null){
			hinId =Integer.parseInt(request.getParameter("hinId"));
		}
		System.out.println("hinId "+hinId);
		System.out.println("hospitalId "+hospitalId);
		System.out.println("uhidNo "+uhidNo);
		System.out.println("bloodrequestHeaderId "+bloodrequestHeaderId);
		
		parameters.put("hinId", hinId);
		parameters.put("hospitalId", hospitalId);
		parameters.put("uhidNo", uhidNo);
		parameters.put("bloodrequestHeaderId", bloodrequestHeaderId);
		//parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		detailsMap = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport("print_stick_blood_collection", parameters,(Connection) detailsMap.get("conn"), response,getServletContext());
		
	
		return null;
	
	}
	
	//Added by Arbind on 31-10-2017
	public ModelAndView showBloodConsentDetails(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		String hinNo = "";
		String patientName = "";
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);

		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientName);
			}
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("0")) {
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.searchPatientConsentDetails(mapForDS);
		String jsp = "";
		jsp = "bld_patientSearchForConsent" + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showConsentEntryJsp(HttpServletRequest request,	HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		int deptId = (Integer) session.getAttribute("deptId");
		int inpatientId = 0;
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").trim().equals("")){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		
		
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		mapForDS.put("hinNo", hinNo);

		try {
			map = bloodBankHandlerService.showConsentEntryJsp(mapForDS);
			jsp = "bld_ConsentEntryDetails";

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("inpatientId", inpatientId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitConsentForBlood(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hinId = 0;
		int relationId = 0;
		String name = "";
		Date date = new Date();
		String procedureExplained = "";
		String cause = "";
		String address = "";
		int inpatientId = 0;
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		if (request.getParameter("relation") != null && !request.getParameter("relation").equals("")) {
			relationId = Integer.parseInt(request.getParameter("relation"));
		}
		if (request.getParameter("legalName") != null && !request.getParameter("legalName").equals("")) {
			name = request.getParameter("legalName");
		}
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		}
		if (request.getParameter("checkpro") != null && !request.getParameter("checkpro").equals("")) {
			procedureExplained = request.getParameter("checkpro");
		}
		if (request.getParameter("cause") != null && !request.getParameter("cause").equals("")) {
			cause = request.getParameter("cause");
		}
		if (request.getParameter("address") != null && !request.getParameter("address").equals("")) {
			address = request.getParameter("address");
		}
		if (request.getParameter("inpatientId") != null && !request.getParameter("inpatientId").trim().equals("")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		Box box = HMSUtil.getBox(request);

		BloodConsent bloodConsent = new BloodConsent();
		bloodConsent.setName(name);
		bloodConsent.setDate(date);
		bloodConsent.setConsentCause(cause);
		bloodConsent.setAddress(address);
		bloodConsent.setProcedureExplianed(procedureExplained);
		MasRelation masRelation = new MasRelation();
		masRelation.setId(relationId);
		bloodConsent.setRelation(masRelation);
		Patient pat = new Patient();
		pat.setId(hinId);
		bloodConsent.setHin(pat);
		map = bloodBankHandlerService.submitConsentForBlood(bloodConsent, box);
		String save = "";
		if (map.get("save") != null) {
			save = (String) map.get("save");
		}
		if (save != null) {
			message = "Record Added Successfully !! <br /> Do you wish to print??";
		} else {
			message = "Error occured !! ";
		}
		int bloodConsentId = 0;
		bloodConsentId = bloodConsent.getId();
		String jsp = "";
		jsp = "messageForBloodConsent" + ".jsp";
		map.put("message", message);
		map.put("bloodConsentId", bloodConsentId);
		map.put("inpatientId", inpatientId);
		map.put("hinId", hinId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printBloodConsent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;

		String returnNumber = null;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String hospitalName = "";
		String address = "";
		int bloodConsentId = 0;
		int inpatientId = 0;
		int hinId = 0; 
		String reportFileName = null; 

		if (request.getParameter("inpatientId") != null
						&& !(request.getParameter("inpatientId").equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			requestParameters.put("inpatientId", inpatientId);
		}
		map = bloodBankHandlerService.getHospitalName(hospitalId);
		reportFileName = "blood_consent";
		
		if (map.get("hospitalName") != null
				&& !map.get("hospitalName").equals("")) {
			hospitalName = (String) map.get("hospitalName");
		}
		if (map.get("address") != null && !map.get("address").equals("")) {
			address = (String) map.get("address");
		}
		requestParameters.put("address", address);
		requestParameters.put("hospitalName", hospitalName);
		try {
			if (request.getParameter("bloodConsentId") != null && !(request.getParameter("bloodConsentId").equals(""))) {

				bloodConsentId = Integer.parseInt(request.getParameter("bloodConsentId"));
				requestParameters.put("bloodConsentId", bloodConsentId);
			}
			
			if (request.getParameter("hinId") != null && !(request.getParameter("hinId").equals(""))) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				requestParameters.put("hinId", hinId);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = bloodBankHandlerService.getConnectionForReport();
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		
		map = bloodBankHandlerService.getConnectionForReport();
		
		HMSUtil.generateReport(reportFileName, requestParameters,(Connection) map.get("conn"), response,getServletContext());
		
		return null;
	}
	
	public ModelAndView showUploadBloodConsentLetter(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		String hinNo = "";
		String patientName = "";
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);

		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientName", patientName);
			}
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("0")) {
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map = bloodBankHandlerService.searchBloodPatientConsentLetter(mapForDS);
		String jsp = "";
		jsp = "bld_patientConsentLetter" + ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView uploadBloodConsentLetter(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		int inpatientId = 0;
		int visitId = 0;
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").trim().equals("")){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if(request.getParameter("visitId")!=null && !request.getParameter("visitId").trim().equals("")){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		mapForDS.put("hinNo", hinNo);

		try {
			map = bloodBankHandlerService.uploadBloodConsentLetter(mapForDS);
			jsp = "bld_ConsentLetterStored";

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("inpatientId", inpatientId);
			map.put("visitId", visitId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView openUploadPopWindow(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int hinId=0;
		
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if(request.getParameter("hinId")!=null){
			details.put("hinId", Integer.parseInt(request.getParameter("hinId")));
	    }
		if(request.getParameter("visitId")!=null){
	       	 details.put("visitId", Integer.parseInt((String)request.getParameter("visitId")));
        }
		if(request.getParameter("inpatientId")!=null){
	       	 details.put("inpatientId", Integer.parseInt((String)request.getParameter("inpatientId")));
		}
		
		details.put("flag", "n");
		
		map = bloodBankHandlerService.uploadAndViewDocuments(details);
		String jsp = "bloodConsentUploadAndViewDocuments";

		return new ModelAndView(jsp, "map", map);
	}


	public ModelAndView uploadAndViewDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int hinId=0;
		String flag="n";	
		String uploadFrom ="NA";
		
		 MultipartFormDataRequest mrequest = null;
	     if (MultipartFormDataRequest.isMultipartFormData(request))
	        {
	             try
	             {
	                 mrequest = new MultipartFormDataRequest(request);
	             }
	             catch (UploadException e)
	             {
	                 e.printStackTrace();
	             }
	             catch (IOException e)
	             {
	                 e.printStackTrace();
	             }
	        }
	     if(mrequest.getParameter("hinId")!=null){
	    	 hinId= Integer.parseInt((String)mrequest.getParameter("hinId"));
	       	 details.put("hinId", Integer.parseInt((String)mrequest.getParameter("hinId")));
	        }
	     
	     if(mrequest.getParameter("uploadFrom")!=null){
	    	 uploadFrom= (String)mrequest.getParameter("uploadFrom");
	       	 details.put("uploadFrom", (String)mrequest.getParameter("uploadFrom"));
	        }
	     
	     if(mrequest.getParameter("visitId")!=null){
	    	
	       	 details.put("visitId", Integer.parseInt((String)mrequest.getParameter("visitId")));
	        }
	     
	     if(mrequest.getParameter("inpatientId")!=null){
	    	
	       	 details.put("inpatientId", Integer.parseInt((String)mrequest.getParameter("inpatientId")));
	        }
	     
	    
	     String filename = "";
	     String uploadURL="";
	     if(uploadFrom.equalsIgnoreCase("OPD"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/OPD/"+hinId+"/");
	     }
	     if(uploadFrom.equalsIgnoreCase("IP"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/IP/"+hinId+"/");
	     }
	    
	     String comments = "";
	     String fileExtension=null;
	     
	     if (mrequest.getParameter("department") != null) {
	 		departmentId = Integer.parseInt(request.getParameter("department"));
	 	}if (departmentId!=0) {
	 		details.put("departmentId", departmentId);
	 	}
	 	if(mrequest.getParameter("fileName")!= null){
	        filename = mrequest.getParameter("fileName");
	    }

	    
	    
	    if(mrequest.getParameter("flag")!=null){
	      	 flag = (String)mrequest.getParameter("flag");
	       }
	    details.put("flag", flag);
	    
	    if( mrequest.getParameter("comments")!= null){
	        comments = mrequest.getParameter("comments");
	        details.put("comments", comments);
	    }
	    details.put("uploadURL", uploadURL);
	    
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            details.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
	    }    
	         
	        
	     map = bloodBankHandlerService.uploadAndViewDocuments(details);
	     String jsp = "bloodConsentUploadAndViewDocuments";
	     String msg="File Successfuly Uploaded.";
	     map.put("message", msg);
	     
	     return new ModelAndView(jsp, "map", map);

	}
	//Added by Arbind on 31-10-2017 end

	
	
	// ----------------------------------------------------------------------------------------------------
	public BloodBankHandlerService getBloodBankHandlerService() {
		return bloodBankHandlerService;
	}

	public void setBloodBankHandlerService(BloodBankHandlerService bloodBankHandlerService) {
		this.bloodBankHandlerService = bloodBankHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

}
