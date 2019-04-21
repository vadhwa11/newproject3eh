package jkt.hrms.recruitment.controller;

import static jkt.hrms.util.HrmsRequestConstants.ADD_RESUME_DETAILS;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_RESUME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.Users;
import jkt.hms.util.EmployeeComparator;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.recruitment.handler.RecruitmentHandlerService;
import jkt.hrms.recruitment.handler.ResumeHandlerService;
import jkt.hrms.recruitment.masters.business.HrRequisitionHistory;
import jkt.hrms.recruitment.masters.business.HrResourceRequisitionStatus;
import jkt.hrms.recruitment.masters.business.HrResumePayElements;
import jkt.hrms.recruitment.masters.business.RequestStatusMaster;
import jkt.hrms.recruitment.masters.business.ResourceRequisition;
import jkt.hrms.recruitment.masters.business.Resumehrdetails;
import jkt.hrms.recruitment.masters.business.Resumehrdetailshistory;
import jkt.hrms.recruitment.masters.business.Resumejobprofile;
import jkt.hrms.recruitment.masters.business.Resumepersonaldetails;
import jkt.hrms.recruitment.masters.business.Resumeremarks;
import jkt.hrms.recruitment.masters.business.Resumestatus;
import jkt.hrms.recruitment.masters.business.Resumestatushistory;
import jkt.hrms.recruitment.masters.business.Resumestatusmaster;
import jkt.hrms.recruitment.masters.business.Resumetechnical;
import jkt.hrms.recruitment.masters.business.Resumetechnicalhistory;
import jkt.hrms.recruitment.masters.business.Uploads;
import jkt.hrms.util.SendMail;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ResumeController extends MultiActionController {
	private ResumeHandlerService resumeHandlerService;
	private RecruitmentHandlerService recruitmentHandlerService;
	static String fileName = null;
	boolean error = false;

	public ResumeHandlerService getResumeHandlerService() {
		return resumeHandlerService;
	}

	public RecruitmentHandlerService getRecruitmentHandlerService() {
		return recruitmentHandlerService;
	}

	public void setRecruitmentHandlerService(
			RecruitmentHandlerService recruitmentHandlerService) {
		this.recruitmentHandlerService = recruitmentHandlerService;
	}

	public void setResumeHandlerService(
			ResumeHandlerService resumeHandlerService) {
		this.resumeHandlerService = resumeHandlerService;
	}

	public ResumeController() {
		error = false;
	}

	public ModelAndView showAddResume(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		List skillmasterList = resumeHandlerService.getSkillMasterList();

		List duList = resumeHandlerService.getDuList();
		List projectDetails = resumeHandlerService.getProjectDetails();
		List jobProfiles = resumeHandlerService.getJobProfiles();

		String title = "Add Resume";

		String verificationStatus = "";
		map.put("title", title);
		map.put("firstName", "");
		map.put("lastName", "");
		map.put("emailId", "");
		map.put("dateOfBirth", "");
		map.put("errorString", verificationStatus);
		map.put("skillMasterList", skillmasterList);

		map.put("duList", duList);
		map.put("projectDetails", projectDetails);
		map.put("jobProfiles", jobProfiles);
		String jsp = ADD_RESUME_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView checkResumeUniqueness(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> passportPanMap = new HashMap<String, Object>();

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		List countryList = resumeHandlerService.getMasterList("MasCountry");
		List stateList = resumeHandlerService.getMasterList("MasState");
		List districtList = resumeHandlerService.getMasterList("MasDistrict");
		List qualificationList = resumeHandlerService
				.getQualificationMasterList();
		List departmentList = resumeHandlerService
				.getMasterList(MasDepartment.class);
		// List projectList =
		// resumeHandlerService.getMasterListWithoutStatus(MstrProject.class);
		List designationList = resumeHandlerService
				.getMasterList(MasRank.class);
		List titleList = resumeHandlerService.getMasterList(MasTitle.class);
		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
				Map<String, Object> verificationMap = new HashMap<String, Object>();

				String resumeThrough = mrequest
						.getParameter(RequestConstants.RESUMETHROUGHVERIFICATION);
				String firstName = mrequest
						.getParameter(RequestConstants.FIRSTNAMEFORVERIFICATION);
				String lastName = mrequest
						.getParameter(RequestConstants.LASTNAMEFORVERIFICATION);
				String dateOfBirth = mrequest
						.getParameter(RequestConstants.DATEOFBIRTHFORVARIFICATION);
				String emailId = "";
				String passportNo = "";
				String currentEmployer = "";
				String previousEmployer = "";
				if (mrequest
						.getParameter(RequestConstants.EMAILIDFORVERIFICATION) != null) {
					emailId = mrequest
							.getParameter(RequestConstants.EMAILIDFORVERIFICATION);
				}
				if (mrequest
						.getParameter(RequestConstants.PASSPORTNUMBERFORVERIFICATION) != null) {
					passportNo = mrequest
							.getParameter(RequestConstants.PASSPORTNUMBERFORVERIFICATION);
				}
				if (mrequest
						.getParameter(RequestConstants.PREVIOUSEMPLOYERFORVERIFICATION) != null) {
					previousEmployer = mrequest
							.getParameter(RequestConstants.PREVIOUSEMPLOYERFORVERIFICATION);
				}
				if (mrequest
						.getParameter(RequestConstants.CURRENTEMPLOYERFORVERIFICAITON) != null) {
					currentEmployer = mrequest
							.getParameter(RequestConstants.CURRENTEMPLOYERFORVERIFICAITON);
				}
				verificationMap.put("resumeThrough", resumeThrough);
				verificationMap.put("firstName", firstName);
				verificationMap.put("lastName", lastName);
				verificationMap.put("dateOfBirth", dateOfBirth);
				verificationMap.put("emailId", emailId);
				verificationMap.put("passportNumber", passportNo);
				verificationMap.put("currentEmployer", currentEmployer);
				verificationMap.put("previousEmployer", previousEmployer);

				passportPanMap = resumeHandlerService
						.checkResumeUniqueness(verificationMap);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String jsp = ADD_RESUME_DETAILS;
		jsp += ".jsp";
		String title = "Add Resume";
		passportPanMap.put("contentJsp", jsp);
		passportPanMap.put("title", title);
		passportPanMap.put("countryList", countryList);
		passportPanMap.put("stateList", stateList);
		passportPanMap.put("districtList", districtList);
		passportPanMap.put("qualificationList", qualificationList);
		passportPanMap.put("departmentList", departmentList);
		// passportPanMap.put("projectList",projectList);
		passportPanMap.put("designationList", designationList);
		passportPanMap.put("titleList", titleList);
		return new ModelAndView("index", "map", passportPanMap);
	}

	public ModelAndView addResume(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		int resumeId = resumeHandlerService.getLastResumeId();
		Map<String, Object> addResumeDetails = setPersonalDetails(request,
				resumeId);
		Map<String, Object> map = new HashMap<String, Object>();

		Boolean isUploaded = false;

		if (addResumeDetails.get("isUploaded") != null) {
			isUploaded = (Boolean) addResumeDetails.get("isUploaded");
		}
		if (isUploaded) {
			Map addResumeMap = new HashMap();
			addResumeMap = resumeHandlerService.addResume(addResumeDetails);
			Boolean isAddResume = false;
			if (addResumeMap.get("isAddResume") != null) {
				isAddResume = (Boolean) addResumeMap.get("isAddResume");
			}
			if (isAddResume) {
				String message[] = {
						"Resume has been added successfully to the database.<br />Click <a href ='/hms/hrms/resume?method=showAddResume'>here</a> to Add New Resume.",
						"javascript:history.back()",
						"/hms/hms/login?method=validate" };
				map.put("message", message);
			} else {
				String errorString = null;
				errorString = (String) addResumeMap.get("errorString");
				String message[] = { "", "", "" };
				if (errorString != null) {
					message[0] = errorString
							+ "<br><br><div align='center'><input class = 'button' style='float:none!important' onclick=history.go(-1) type=button value=Back></div>";
					message[1] = "javascript(-1)";
					message[2] = "/hms/hrms/login?method=validate";
				} else {
					message[0] = "This Record Already Exists. Hence This Resume cannot be Added. \nPlease Try Again! ";
					message[1] = "javascript(-1)";
					message[2] = "/hms/hms/login?method=validate";
				}
				map.put("message", message);
			}
		} else {
			String message[] = {
					"Resume cannot be uploaded because size was greater than 2MB. Try again later!",
					"javascript(-1)", "/hms/hms/login?method=validate" };
			map.put("message", message);
		}

		String jsp = "hr_message.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public Map<String, Object> setPersonalDetails(HttpServletRequest request,
			int resumeId) throws IOException {
		HttpSession session = request.getSession(false);
		Resumepersonaldetails personalDetails = new Resumepersonaldetails();
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> addResumeDetails = new HashMap<String, Object>();

		Users currentUser = (Users) session
				.getAttribute(RequestConstants.USERS);
		Resumeremarks resumeRemarks = new Resumeremarks();

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		Properties properties = new Properties();
		properties.load(resourcePath.openStream());

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Mandatory Fields
			if (mrequest.getParameter(RequestConstants.NAMEOFSOURCE) == null) {
				personalDetails.setNameOfSource("--");
			} else {
				personalDetails.setNameOfSource(mrequest
						.getParameter(RequestConstants.NAMEOFSOURCE));
			}

			if (mrequest.getParameter(RequestConstants.TITLE) != null
					&& (!mrequest.getParameter(RequestConstants.TITLE).equals(
							"0"))) {
				Integer titleId = new Integer(
						mrequest.getParameter(RequestConstants.TITLE));
				// MasTitle title = new MasTitle();
				// title.setId(titleId);
				personalDetails.setTitleId(titleId);
			}

			personalDetails.setFirstName(mrequest
					.getParameter(RequestConstants.FIRSTNAME));

			if (mrequest.getParameter(RequestConstants.MIDNAME) != null
					&& (!mrequest.getParameter(RequestConstants.MIDNAME)
							.equals(""))) {
				personalDetails.setMiddleName(mrequest
						.getParameter(RequestConstants.MIDNAME));
			} else {
				personalDetails.setMiddleName("");
			}

			personalDetails.setLastName(mrequest
					.getParameter(RequestConstants.LASTNAME));

			if (mrequest.getParameter(RequestConstants.DATEOFBIRTH) != null
					&& (!mrequest.getParameter(RequestConstants.DATEOFBIRTH)
							.equals(""))) {
				personalDetails.setDateOfBirth(mrequest
						.getParameter(RequestConstants.DATEOFBIRTH));
			} else {
				personalDetails.setDateOfBirth("");
			}
			Integer countryId = new Integer(
					mrequest.getParameter(RequestConstants.COUNTRY));
			Integer stateId = new Integer(
					mrequest.getParameter(RequestConstants.STATE));
			if (countryId != 0) {
				personalDetails.setCountryId(countryId);
			}

			if (stateId != 0) {
				personalDetails.setStateId(stateId);
			}

			if (mrequest.getParameter(RequestConstants.DISTRICT).equals("-1")) {
				personalDetails.setCityId(-1);
				personalDetails.setOtherCity(mrequest
						.getParameter(RequestConstants.OTHERCITY));
			} else {
				Integer cityId = new Integer(
						mrequest.getParameter(RequestConstants.DISTRICT));
				if (cityId != 0) {
					personalDetails.setCityId(cityId);
				}
			}
			personalDetails.setEmailId(mrequest
					.getParameter(RequestConstants.EMAIL));
			personalDetails.setResidencePhone(mrequest
					.getParameter(RequestConstants.HOMEPHONE));
			if (mrequest.getParameter(RequestConstants.MOBILEPHONE) != null) {
				personalDetails.setMobile(mrequest
						.getParameter(RequestConstants.MOBILEPHONE));
			} else {
				personalDetails.setMobile("");
			}

			if (mrequest.getParameter(RequestConstants.OTHERPHONE) != null) {
				personalDetails.setOtherPhone(mrequest
						.getParameter(RequestConstants.OTHERPHONE));
			} else {
				personalDetails.setOtherPhone("");
			}
			personalDetails.setAddress1(mrequest
					.getParameter(RequestConstants.ADDRESSLINE1));
			personalDetails.setAddress2(mrequest
					.getParameter(RequestConstants.ADDRESSLINE2));
			personalDetails.setAddress3(mrequest
					.getParameter(RequestConstants.ADDRESSLINE3));
			if (mrequest.getParameter(RequestConstants.EDUCATION).equals(
					"Other")) {
				personalDetails.setEducation(mrequest
						.getParameter(RequestConstants.OTHEREDUCATION));
			} else {
				personalDetails.setEducation(mrequest
						.getParameter(RequestConstants.EDUCATION));
			}

			if (mrequest.getParameter(RequestConstants.YEARPASSING) != null
					&& !mrequest.getParameter(RequestConstants.YEARPASSING)
							.equals("")) {
				personalDetails.setYearpassing(new Integer(mrequest
						.getParameter(RequestConstants.YEARPASSING)));
			} else {
				personalDetails.setYearpassing(0);
			}
			if (mrequest.getParameter(RequestConstants.UNIVERSITY) != null) {
				personalDetails.setInstitution(mrequest
						.getParameter(RequestConstants.UNIVERSITY));
			} else {
				personalDetails.setInstitution("");
			}
			personalDetails.setDomainKnowledge(mrequest
					.getParameter(RequestConstants.DOMAIN));
			personalDetails.setExperienceYear(Integer.parseInt(mrequest
					.getParameter(RequestConstants.YEARS).trim()));
			personalDetails.setExperienceMonth(Integer.parseInt(mrequest
					.getParameter(RequestConstants.MONTHS).trim()));

			if (mrequest.getParameter(RequestConstants.JOBPROFILE) != null
					&& !mrequest.getParameter(RequestConstants.JOBPROFILE)
							.equals("")) {
				personalDetails.setJobProfileID(Integer.valueOf(mrequest
						.getParameter(RequestConstants.JOBPROFILE)));
			} else {
				personalDetails.setJobProfileID(null);
			}

			boolean onsite = false;
			if (mrequest.getParameter(RequestConstants.ONSITEAVAILABILITY) != null
					&& (mrequest
							.getParameter(RequestConstants.ONSITEAVAILABILITY)
							.equalsIgnoreCase("on"))) {
				onsite = true;
			}

			personalDetails.setOnSiteAvailability(onsite);

			personalDetails.setCurrentEmployer(mrequest
					.getParameter(RequestConstants.CURRENTEMPLOYER));
			personalDetails.setPreviousEmployer(mrequest
					.getParameter(RequestConstants.PREVIOUSEMPLOYER));
			if (mrequest.getParameter(RequestConstants.CURRENTCTC) != null) {
				personalDetails.setCurrentCtc(mrequest
						.getParameter(RequestConstants.CURRENTCTC));
			} else {
				personalDetails.setCurrentCtc("");
			}

			if (mrequest.getParameter(RequestConstants.EXPECTEDSALARY) != null) {
				personalDetails.setExpectedCtc(mrequest
						.getParameter(RequestConstants.EXPECTEDSALARY));
			} else {
				personalDetails.setExpectedCtc("");
			}

			if (mrequest.getParameter(RequestConstants.CURRENTROLE) != null) {
				personalDetails.setCurrentDesignation(mrequest
						.getParameter(RequestConstants.CURRENTROLE));
			} else {
				personalDetails.setCurrentDesignation("");
			}

			if (mrequest.getParameter(RequestConstants.SALARYREMARKS) != null) {
				personalDetails.setSalaryRemarks(mrequest
						.getParameter(RequestConstants.SALARYREMARKS));
			} else {
				personalDetails.setSalaryRemarks("");
			}

			if (mrequest.getParameter(RequestConstants.DU_ID) != null
					&& !mrequest.getParameter(RequestConstants.DU_ID)
							.equals("")) {
				personalDetails.setDuID(Integer.valueOf(mrequest
						.getParameter(RequestConstants.DU_ID)));
			} else {
				personalDetails.setDuID(null);
			}

			if (mrequest.getParameter(RequestConstants.JOININGTIME) != null
					&& !mrequest.getParameter(RequestConstants.JOININGTIME)
							.equals("")) {
				personalDetails.setJoiningPeriod(Integer.valueOf(mrequest
						.getParameter(RequestConstants.JOININGTIME)));
			} else {
				personalDetails.setJoiningPeriod(null);
			}

			if (mrequest.getParameter(RequestConstants.PROJECT_ID) != null
					&& !mrequest.getParameter(RequestConstants.PROJECT_ID)
							.equals("")) {
				if ((Integer.valueOf(mrequest
						.getParameter(RequestConstants.PROJECT_ID))).equals(0)) {
					String projectName = mrequest
							.getParameter(RequestConstants.OTHERPROJECT);
					addResumeDetails.put("othersProject", projectName);

				} else {
					personalDetails.setProjectId(Integer.valueOf(mrequest
							.getParameter(RequestConstants.PROJECT_ID)));
				}
			} else {
				personalDetails.setProjectId(null);
			}

			if (mrequest.getParameter(RequestConstants.PASSPORTSTATUS) != null) {
				personalDetails.setPassportStatus(mrequest
						.getParameter(RequestConstants.PASSPORTSTATUS));
			} else {
				personalDetails.setPassportStatus("");
			}

			if (mrequest.getParameter(RequestConstants.PASSPORTNUMBER) != null) {
				personalDetails.setPassportNo(mrequest
						.getParameter(RequestConstants.PASSPORTNUMBER));
			} else {
				personalDetails.setPassportNo("");
			}

			if (mrequest.getParameter(RequestConstants.PASSPORTEXPIRYDATE) != null) {
				personalDetails.setPassportExpiryDate(mrequest
						.getParameter(RequestConstants.PASSPORTEXPIRYDATE));
			} else {
				personalDetails.setPassportExpiryDate("");
			}

			if (mrequest.getParameter(RequestConstants.VISAREMARKS) != null) {
				personalDetails.setVisaRemarks((mrequest
						.getParameter(RequestConstants.VISAREMARKS)));
			} else {
				personalDetails.setVisaRemarks("");
			}

			// Primary and Secondary Skills
			String[] primarySkills, secondrySkills;

			primarySkills = mrequest
					.getParameterValues(RequestConstants.PRIMARYSKILLS);
			addResumeDetails.put("primarySkills", primarySkills);

			if (mrequest.getParameterValues(RequestConstants.SECONDARYSKILLS) != null
					&& !mrequest.getParameterValues(
							RequestConstants.SECONDARYSKILLS).equals("")) {
				secondrySkills = mrequest
						.getParameterValues(RequestConstants.SECONDARYSKILLS);
				addResumeDetails.put("secondrySkills", secondrySkills);
			}

			String uploadURL = getServletContext().getRealPath(
					"/uploads/rms_resume"); // properties.getProperty("uploadResume");

			String whiteList = "*.doc,*.txt,*.rtf,*.DOC,*.TXT,*.RTF,*.pdf";
			Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
			String firstName = personalDetails.getFirstName();

			int id = resumeId + 1;
			String fileNameToBeAssigned = firstName + id;

			List fileUploadedList = null;
			// Connection connection = resumeHandlerService.getDBConnection();
			fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
					whiteList, fileSizeLimit, fileNameToBeAssigned);
			Boolean fileUploaded = false;
			if (fileUploadedList != null && fileUploadedList.size() != 0) {
				fileUploaded = (Boolean) fileUploadedList.get(0);
			}

			/*
			 * personalDetails.setResumeThrough(mrequest.getParameter(
			 * RequestConstants .RESUMETHROUGH)); if
			 * (mrequest.getParameter(RequestConstants.REFERENCEBY) != null &&
			 * (!
			 * mrequest.getParameter(RequestConstants.REFERENCEBY).equals("")))
			 * {personalDetails.setReferenceBy((mrequest.getParameter(
			 * RequestConstants.REFERENCEBY))); }
			 */

			personalDetails.setAddBy(currentUser.getId());

			personalDetails.setAddOn(HMSUtil.getCurrentDateAndTimeObject());
			personalDetails.setUpdatedOn(HMSUtil.getCurrentDateAndTimeObject());
			personalDetails.setOwnershipChnagedOn(HMSUtil
					.getCurrentDateAndTimeObject());
			personalDetails.setActive(true);

			// Organising Remarks
			resumeRemarks.setRemarks(mrequest
					.getParameter(RequestConstants.REMARKS));
			resumeRemarks.setDateRemarks(HMSUtil.getCurrentDateAndTimeObject());
			resumeRemarks
					.setRemarksBy(currentUser.getEmployee().getFirstName());

			addResumeDetails.put("personalDetails", personalDetails);
			addResumeDetails.put("resumeRemarks", resumeRemarks);
			addResumeDetails.put("isUploaded", fileUploaded);
		}
		return addResumeDetails;
	}

	public ModelAndView editResume(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute("users");
		String currentUser = user.getEmployee().getFirstName() + " "
				+ user.getEmployee().getLastName();

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		properties.load(resourcePath.openStream());

		Map<String, Object> detailsOfResume = (HashMap<String, Object>) session
				.getAttribute("detailsOfResume");
		List<Resumepersonaldetails> rs1 = (List<Resumepersonaldetails>) detailsOfResume
				.get("resumePersonalDetails");
		Resumepersonaldetails personalDetailstobeEdited = rs1.get(0);
		List personalDetailsList = resumeHandlerService
				.getResumePersonalDetailsById(personalDetailstobeEdited.getId());
		Resumepersonaldetails personalDetails = (Resumepersonaldetails) personalDetailsList
				.get(0);
		MultipartFormDataRequest mrequest = null;
		Map editResumeDetails = new HashMap();
		long fileSize = 0;

		// Resumevisadetails resumevisadetails = new Resumevisadetails();
		// Resumepersonaldetails rpd =
		// (Resumepersonaldetails)getHibernateTemplate().load(Resumepersonaldetails.class,new
		// Integer(resumeID));
		Resumeremarks resumeRemarks = new Resumeremarks();
		int resumeId = 0;
		Boolean fileUpdated = false;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
				resumeId = Integer.parseInt(mrequest
						.getParameter(RequestConstants.RESUMEID));
				personalDetails.setId(Integer.parseInt(mrequest
						.getParameter(RequestConstants.RESUMEID)));

				personalDetails.setResumeThrough(mrequest
						.getParameter(RequestConstants.RESUMETHROUGH));

				if (mrequest.getParameter(RequestConstants.NAMEOFSOURCE) == null) {
					personalDetails.setNameOfSource("--");
				} else {
					personalDetails.setNameOfSource(mrequest
							.getParameter(RequestConstants.NAMEOFSOURCE));
				}

				if (mrequest.getParameter(RequestConstants.TITLE) != null
						&& !mrequest.getParameter(RequestConstants.TITLE)
								.equals("0")) {

					personalDetails.setTitleId(new Integer(mrequest
							.getParameter(RequestConstants.TITLE)));
				}

				personalDetails.setFirstName(mrequest
						.getParameter(RequestConstants.FIRSTNAME));
				personalDetails.setLastName(mrequest
						.getParameter(RequestConstants.LASTNAME));
				personalDetails.setMiddleName(mrequest
						.getParameter(RequestConstants.MIDNAME));
				personalDetails.setAddress1(mrequest
						.getParameter(RequestConstants.ADDRESSLINE1));
				personalDetails.setAddress2(mrequest
						.getParameter(RequestConstants.ADDRESSLINE2));
				personalDetails.setAddress3(mrequest
						.getParameter(RequestConstants.ADDRESSLINE3));
				personalDetails.setDateOfBirth(mrequest
						.getParameter(RequestConstants.DATEOFBIRTH));

				Integer countryId = new Integer(
						mrequest.getParameter(RequestConstants.COUNTRY));
				if (countryId != 0) {
					personalDetails.setCountryId(countryId);
				}

				Integer stateId = new Integer(
						mrequest.getParameter(RequestConstants.STATE));
				if (stateId != 0) {
					personalDetails.setStateId(stateId);
				}

				if (mrequest.getParameter(RequestConstants.DISTRICT).equals(
						"-1")) {
					personalDetails.setCityId(-1);
					personalDetails.setOtherCity(mrequest
							.getParameter(RequestConstants.OTHERCITY));
				} else {
					Integer cityId = new Integer(
							mrequest.getParameter(RequestConstants.DISTRICT));
					if (cityId != 0) {
						personalDetails.setCityId(cityId);
					}

					personalDetails.setOtherCity("");
				}

				personalDetails.setEmailId(mrequest
						.getParameter(RequestConstants.EMAIL));

				personalDetails.setResidencePhone(mrequest
						.getParameter(RequestConstants.HOMEPHONE));

				if (mrequest.getParameter(RequestConstants.MOBILEPHONE) != null) {
					personalDetails.setMobile(mrequest
							.getParameter(RequestConstants.MOBILEPHONE));
				} else {
					personalDetails.setMobile("");
				}

				if (mrequest.getParameter(RequestConstants.OTHERPHONE) != null) {
					personalDetails.setOtherPhone(mrequest
							.getParameter(RequestConstants.OTHERPHONE));
				} else {
					personalDetails.setOtherPhone("");
				}

				if (mrequest.getParameter(RequestConstants.EDUCATION).equals(
						"Other")) {
					personalDetails.setEducation(mrequest
							.getParameter(RequestConstants.OTHEREDUCATION));
				} else {
					personalDetails.setEducation(mrequest
							.getParameter(RequestConstants.EDUCATION));
				}

				if ((mrequest.getParameter(RequestConstants.YEARPASSING) != null)
						&& (!mrequest
								.getParameter(RequestConstants.YEARPASSING)
								.equals(""))) {
					personalDetails
							.setYearpassing(Integer.parseInt(mrequest
									.getParameter(RequestConstants.YEARPASSING)
									.trim()));
				}

				if (mrequest.getParameter(RequestConstants.UNIVERSITY) != null) {
					personalDetails.setInstitution(mrequest
							.getParameter(RequestConstants.UNIVERSITY));
				} else {
					personalDetails.setInstitution("");
				}

				personalDetails.setDomainKnowledge(mrequest
						.getParameter(RequestConstants.DOMAIN));
				personalDetails.setExperienceYear(Integer.parseInt(mrequest
						.getParameter(RequestConstants.YEARS)));
				personalDetails.setExperienceMonth(Integer.parseInt(mrequest
						.getParameter(RequestConstants.MONTHS)));

				if (mrequest.getParameter(RequestConstants.JOBPROFILE) != null
						&& !mrequest.getParameter(RequestConstants.JOBPROFILE)
								.equals("")) {
					personalDetails.setJobProfileID(Integer.valueOf(mrequest
							.getParameter(RequestConstants.JOBPROFILE)));
				} else {
					personalDetails.setJobProfileID(null);
				}

				boolean onsite = false;
				if (mrequest.getParameter(RequestConstants.ONSITEAVAILABILITY) != null
						&& (mrequest
								.getParameter(RequestConstants.ONSITEAVAILABILITY)
								.equalsIgnoreCase("on"))) {
					onsite = true;
				}

				personalDetails.setOnSiteAvailability(onsite);

				personalDetails.setCurrentEmployer(mrequest
						.getParameter(RequestConstants.CURRENTEMPLOYER));
				personalDetails.setPreviousEmployer(mrequest
						.getParameter(RequestConstants.PREVIOUSEMPLOYER));

				if (mrequest.getParameter(RequestConstants.CURRENTCTC) != null) {
					personalDetails.setCurrentCtc(mrequest
							.getParameter(RequestConstants.CURRENTCTC));
				} else {
					personalDetails.setCurrentCtc("");
				}

				if (mrequest.getParameter(RequestConstants.EXPECTEDSALARY) != null) {
					personalDetails.setExpectedCtc(mrequest
							.getParameter(RequestConstants.EXPECTEDSALARY));
				} else {
					personalDetails.setExpectedCtc("");
				}

				if (mrequest.getParameter(RequestConstants.CURRENTROLE) != null) {
					personalDetails.setCurrentDesignation(mrequest
							.getParameter(RequestConstants.CURRENTROLE));
				} else {
					personalDetails.setCurrentDesignation("");
				}

				if (mrequest.getParameter(RequestConstants.SALARYREMARKS) != null) {
					personalDetails.setSalaryRemarks(mrequest
							.getParameter(RequestConstants.SALARYREMARKS));
				} else {
					personalDetails.setSalaryRemarks("");
				}

				if (mrequest.getParameter(RequestConstants.DU_ID) != null
						&& !mrequest.getParameter(RequestConstants.DU_ID)
								.equals("")) {
					personalDetails.setDuID(Integer.valueOf(mrequest
							.getParameter(RequestConstants.DU_ID)));
				} else {
					personalDetails.setDuID(null);
				}

				if (mrequest.getParameter(RequestConstants.JOININGTIME) != null
						&& !mrequest.getParameter(RequestConstants.JOININGTIME)
								.equals("")) {
					personalDetails.setJoiningPeriod(Integer.valueOf(mrequest
							.getParameter(RequestConstants.JOININGTIME)));
				} else {
					personalDetails.setJoiningPeriod(null);
				}

				if (mrequest.getParameter(RequestConstants.PROJECT_ID) != null
						&& !mrequest.getParameter(RequestConstants.PROJECT_ID)
								.equals("")) {
					if ((Integer.valueOf(mrequest
							.getParameter(RequestConstants.PROJECT_ID)))
							.equals(0)) {
						String projectName = mrequest
								.getParameter(RequestConstants.OTHERPROJECT);
						editResumeDetails.put("othersProject", projectName);

					} else {
						personalDetails.setProjectId(Integer.valueOf(mrequest
								.getParameter(RequestConstants.PROJECT_ID)));
					}
				} else {
					personalDetails.setProjectId(null);
				}

				if (mrequest.getParameter(RequestConstants.PASSPORTSTATUS) != null) {
					personalDetails.setPassportStatus(mrequest
							.getParameter(RequestConstants.PASSPORTSTATUS));
				} else {
					personalDetails.setPassportStatus("");
				}

				if (mrequest.getParameter(RequestConstants.PASSPORTNUMBER) != null) {
					personalDetails.setPassportNo(mrequest
							.getParameter(RequestConstants.PASSPORTNUMBER));
				} else {
					personalDetails.setPassportNo("");
				}

				if (mrequest.getParameter(RequestConstants.PASSPORTEXPIRYDATE) != null) {
					personalDetails.setPassportExpiryDate(mrequest
							.getParameter(RequestConstants.PASSPORTEXPIRYDATE));
				} else {
					personalDetails.setPassportExpiryDate("");
				}

				if (mrequest.getParameter(RequestConstants.VISAREMARKS) != null) {
					personalDetails.setVisaRemarks((mrequest
							.getParameter(RequestConstants.VISAREMARKS)));
				} else {
					personalDetails.setVisaRemarks("");
				}

				String[] primarySkills, secondrySkills;
				primarySkills = mrequest
						.getParameterValues(RequestConstants.PRIMARYSKILLS);
				editResumeDetails.put("primarySkills", primarySkills);

				if (mrequest
						.getParameterValues(RequestConstants.SECONDARYSKILLS) != null
						&& !mrequest.getParameterValues(
								RequestConstants.SECONDARYSKILLS).equals("")) {
					secondrySkills = mrequest
							.getParameterValues(RequestConstants.SECONDARYSKILLS);
					editResumeDetails.put("secondrySkills", secondrySkills);
				}

				/*
				 * if (mrequest.getParameter(RequestConstants.REFERENCEBY) !=
				 * null &&
				 * (!mrequest.getParameter(RequestConstants.REFERENCEBY).
				 * equals(""))) {
				 * personalDetails.setReferenceBy((mrequest.getParameter
				 * (RequestConstants.REFERENCEBY))); }
				 */

				// personalDetails.setAddBy(user.getId());
				personalDetails.setUpdatedOn(HMSUtil
						.getCurrentDateAndTimeObject());

				UploadBean upBean = new UploadBean();
				String uploadURL = properties.getProperty("uploadResume");

				upBean.setFolderstore(uploadURL);
				upBean.setFilesizelimit(RequestConstants.MAX_FILE_SIZE);
				upBean.setOverwrite(true);
				upBean.setWhitelist("*.doc,*.txt,*.rtf,*.DOC,*.TXT,*.RTF,*.pdf");
				Hashtable files = mrequest.getFiles();
				if ((files != null) || (!files.isEmpty())) {
					UploadFile file = (UploadFile) files
							.get(RequestConstants.UPLOAD);
					String fileName = file.getFileName();
					fileSize = file.getFileSize();

					int id = resumeId;
					if (fileName != null && fileSize > 0
							&& fileSize <= RequestConstants.MAX_FILE_SIZE) {
						SimpleDateFormat sdf = new SimpleDateFormat(
								"yyyyMMdd_HHmmss");
						String date = sdf.format(new Date());
						int length = fileName.length();
						int index = fileName.indexOf(".");
						String ext = fileName.substring(index, length);
						String firstname = mrequest
								.getParameter(RequestConstants.FIRSTNAME);
						file.setFileName(firstname + id + "_" + date + ext);
						upBean.store(mrequest, "upload");
					}
				}
				editResumeDetails.put("personalDetails", personalDetails);

				resumeRemarks.setRemarks(mrequest
						.getParameter(RequestConstants.REMARKS));
				resumeRemarks.setDateRemarks(HMSUtil
						.getCurrentDateAndTimeObject());
				resumeRemarks.setRemarksBy(currentUser);
				editResumeDetails.put("resumeRemarks", resumeRemarks);
				// editResumeDetails.put("resumevisadetails",resumevisadetails);

			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map editResumeMap = resumeHandlerService.editResume(editResumeDetails);
		Boolean isEditResume = (Boolean) editResumeMap.get("isEditResume");

		if (isEditResume
				&& (fileSize == -1 || fileSize <= RequestConstants.MAX_FILE_SIZE)) {
			String message[] = {
					"Resume has been edited successfully.<br />Click <a href ='/hms/hrms/resume?method=viewResume&resumeID="
							+ resumeId
							+ "'>here</a> to go back to View Resume. ",
					"javascript:history.back()",
					"/hms/hms/login?method=validate" };
			map.put("message", message);
		} else if (isEditResume && fileSize > RequestConstants.MAX_FILE_SIZE) {
			String message[] = {
					"Resume has been edited but attached resume cannot be uploaded because size was greater than 2MB. Try again later!",
					"javascript(-1)", "/hms/hms/login?method=validate" };
			map.put("message", message);
		} else {
			String errorString = null;
			errorString = (String) editResumeMap.get("errorString");
			String message[] = { "", "", "" };
			if (errorString != null) {
				message[0] = errorString;
				message[1] = "javascript(-1)";
				message[2] = "/hms/hrms/login?method=validate";
			} else {
				message[0] = "There is Some problem editing your resume. Please Try Again! ";
				message[1] = "javascript(-1)";
				message[2] = "/hms/hms/login?method=validate";
			}
			map.put("message", message);
		}
		String title = "Edit Resume";
		map.put("title", title);
		String jsp = "hr_message.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSearchPage(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		boolean error = false;
		Map<String, Object> map = new HashMap<String, Object>();
		String statusVal;
		String showAllResume = "";
		session.setAttribute("checkValue", false);
		if (request.getParameter("statusVal") == null) {
			statusVal = "s";
		} else {
			statusVal = request.getParameter("statusVal");
		}

		List skillList = resumeHandlerService.getSkillMasterList();
		List statusMasterList = resumeHandlerService.getStatusMasterList();
		// List<MstrProject> projectList =
		// resumeHandlerService.getMasterListWithoutStatus(MstrProject.class);
		List<Resumejobprofile> jobProfileList = resumeHandlerService
				.getJobProfiles();
		List<MasQualification> qualificationList = resumeHandlerService
				.getQualificationMasterList();
		List<MasDepartment> departmentList = resumeHandlerService
				.getDepartmentList();
		String jsp = SEARCH_RESUME;
		jsp += ".jsp";
		// map.put("projectList", projectList);
		map.put("statusMasterList", statusMasterList);
		map.put("errorSearch", error);
		map.put("statusVal", statusVal);
		map.put("contentJsp", jsp);
		map.put("skillList", skillList);
		map.put("jobProfiles", jobProfileList);
		map.put("qualificationList", qualificationList);
		map.put("departmentList", departmentList);
		String title = "Search Resume";
		map.put("title", title);
		session.setAttribute("showAllResume", showAllResume);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchResume(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);

		Users user = (Users) session.getAttribute("users");

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String roleForRMSAdmin = properties.getProperty("roleForRMSAdmin");
		String roleForRMSUser = properties.getProperty("roleForRMSTechnical");
		String roleForRMSRecruiter = properties
				.getProperty("roleForRMSRecruiter");
		String statusVal = request.getParameter("statusVal");
		Boolean checkValue = new Boolean(request.getParameter("checkValue"));
		if (checkValue != null) {
			session.setAttribute("checkValue", checkValue);
		}
		Map applicationMap = new HashMap();
		List rmsIdList = new ArrayList();
		List rmsUsersList = new ArrayList();
		String roleId = "";

		/*
		 * try { 
		 * applicationMap = resumeHandlerService.app(user); roleId =
		 * (String)applicationMap.get("roleId"); StringTokenizer str1 = new
		 * StringTokenizer(roleId,",");
		 * 
		 * while(str1.hasMoreTokens()){ roleId = str1.nextToken();
		 * if(roleId.equals(roleForRMSAdmin)) { map.put("isAdmin",true); }
		 * if((roleId.equals(roleForRMSAdmin) ||
		 * roleId.equals(roleForRMSRecruiter
		 * ))&&(ServletRequestUtils.getIntParameter(request
		 * ,RequestConstants.STATUS,-1)<7)){ roleId = roleForRMSUser;
		 * rmsUsersList = resumeHandlerService.getRmsUsersList(roleId); Iterator
		 * iter2 = rmsUsersList.iterator(); int rmsEmpId = 0; StringBuffer
		 * rmsEmpIds = new StringBuffer(); while(iter2.hasNext()){ rmsEmpId =
		 * (Integer)iter2.next(); rmsEmpIds.append(rmsEmpId + ","); }
		 * if(rmsEmpIds != null && !("".equals(rmsEmpIds.toString()))) {
		 * rmsEmpIds.deleteCharAt(rmsEmpIds.length() - 1); rmsIdList =
		 * resumeHandlerService.getRecruitersList(rmsEmpIds.toString()); }
		 * roleId = roleForRMSAdmin; map.put("roleFlag",true);
		 * map.put("rmsIdList",rmsIdList); break; } } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		rmsIdList = resumeHandlerService.getRecruitersList();
		map.put("roleFlag", true);
		map.put("rmsIdList", rmsIdList);
		Map<String, Object> searchMap = null;
		Map<String, Object> searchCriteriaMap = new HashMap<String, Object>();
		String byArchievedRecords = ServletRequestUtils.getStringParameter(request,
				RequestConstants.ARCHIEVEDRECORDS, "").trim();
		searchCriteriaMap.put("byArchivedRecords", byArchievedRecords);
		if (statusVal.equalsIgnoreCase("s")) {
			String showAllResume = "";
			if (request.getParameter("showAllResume") != null) {
				showAllResume = (String) request.getParameter("showAllResume");
			}
			if (!showAllResume.equals("")) {
				searchCriteriaMap.put("ShowAllResume", showAllResume);
			}
			session.setAttribute("showAllResume", showAllResume);
			String byFirstName = ServletRequestUtils.getStringParameter(request,
					RequestConstants.FIRSTNAME, "").trim();
			String byLastName = ServletRequestUtils.getStringParameter(request,
					RequestConstants.LASTNAME, "").trim();
			String bySkills = ServletRequestUtils.getStringParameter(request,
					RequestConstants.SKILLS, "").trim();
			String byLocation = ServletRequestUtils.getStringParameter(request,
					RequestConstants.LOCATION, "").trim();
			String byEducation = ServletRequestUtils.getStringParameter(request,
					RequestConstants.EDUCATION, "").trim();
			String byJobProfile = ServletRequestUtils.getStringParameter(request,
					RequestConstants.JOBPROFILE, "").trim();
			Integer byProject = ServletRequestUtils.getIntParameter(request,
					RequestConstants.PROJECTNAME, 0);
			String fromDate = ServletRequestUtils.getStringParameter(request,
					RequestConstants.FROMDATE, "").trim();
			String toDate = ServletRequestUtils.getStringParameter(request,
					RequestConstants.TODATE, "").trim();
			String byOnsiteAvailability = ServletRequestUtils.getStringParameter(
					request, RequestConstants.ONSITEAVAILABILITY, "").trim();
			int byStatus = ServletRequestUtils.getIntParameter(request,
					RequestConstants.STATUS, -1);
			int byExperience = ServletRequestUtils.getIntParameter(request,
					RequestConstants.EXPERIENCE, -1);
			int byResumeId = ServletRequestUtils.getIntParameter(request,
					RequestConstants.RESUMEID, 0);
			int operatorInt = ServletRequestUtils.getIntParameter(request,
					RequestConstants.OPERATOR1, 0);
			int departmentId = ServletRequestUtils.getIntParameter(request,
					RequestConstants.DEPARTMENT_ID, 0);
			String operator = "";
			if (operatorInt == 1) {
				operator = "<";
			} else if (operatorInt == 2) {
				operator = ">";
			} else if (operatorInt == 3) {
				operator = "=";
			}

			Date byFromDate = null;
			Date byToDate = null;
			if (!"".equals(fromDate)) {
				byFromDate = HMSUtil.dateFormatterDDMMYYYY(fromDate);
			}
			if (!"".equals(toDate)) {
				byToDate = HMSUtil.dateFormatterDDMMYYYY(toDate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(byToDate);
				cal.roll(Calendar.SECOND, 59);
				cal.roll(Calendar.MINUTE, 59);
				cal.roll(Calendar.HOUR, 11);
				cal.roll(Calendar.AM_PM, 1);
				byToDate = cal.getTime();
			}

			if (byFirstName.equals("") && byLastName.equals("")
					&& byResumeId == 0 && operator.equals("")
					&& byExperience == -1 && byStatus == -1
					&& byJobProfile.equals("") && byEducation.equals("")
					&& bySkills.equals("") && byProject.equals("")
					&& byLocation.equals("") && byFromDate == null
					&& byToDate == null && byOnsiteAvailability.equals("")) {
				searchCriteriaMap.put("ShowAllResume", "All");
			} else {
				searchCriteriaMap.put("byFirstName", byFirstName);
				searchCriteriaMap.put("byLastName", byLastName);
				searchCriteriaMap.put("byResumeId", byResumeId);
				searchCriteriaMap.put("operator", operator);
				searchCriteriaMap.put("byExperience", byExperience);
				searchCriteriaMap.put("byStatus", byStatus);
				searchCriteriaMap.put("byJobProfile", byJobProfile);
				searchCriteriaMap.put("byEducation", byEducation);
				searchCriteriaMap.put("bySkills", bySkills);
				searchCriteriaMap.put("byProject", byProject);
				searchCriteriaMap.put("byLocation", byLocation);
				searchCriteriaMap.put("byFromDate", byFromDate);
				searchCriteriaMap.put("byToDate", byToDate);
				searchCriteriaMap.put("byOnsiteAvailability",
						byOnsiteAvailability);
				searchCriteriaMap.put("departmentId", departmentId);
			}
		} else {
			searchCriteriaMap.put("ShowAllResume", "All");
		}
		searchMap = (HashMap<String, Object>) resumeHandlerService
				.searchResume(searchCriteriaMap);
		List statusMasterList = resumeHandlerService.getStatusMasterList();
		List<Resumepersonaldetails> searchResultList = (ArrayList<Resumepersonaldetails>) searchMap
				.get("searchResultList");
		List<Resumepersonaldetails> searchList = new ArrayList<Resumepersonaldetails>();
		String all = "";
		String any = "";
		String exclude = "";
		if (request.getParameter(RequestConstants.ALLPARAMETER) != null) {
			all = request.getParameter(RequestConstants.ALLPARAMETER)
					.toLowerCase().trim();
		}

		if (request.getParameter(RequestConstants.ANYPARAMETER) != null) {
			any = request.getParameter(RequestConstants.ANYPARAMETER)
					.toLowerCase().trim();
		}

		if (request.getParameter(RequestConstants.EXCLUDEPARAMETER) != null) {
			exclude = request.getParameter(RequestConstants.EXCLUDEPARAMETER)
					.toLowerCase().trim();
		}

		if (!all.equals("") || !any.equals("") || !exclude.equals("")) {

			List<Resumepersonaldetails> resumeList = new ArrayList<Resumepersonaldetails>();
			File myFile = new File(properties.getProperty("uploadResume"));
			File[] allFiles = null;

			if (myFile.isDirectory()) {
				allFiles = myFile.listFiles();
			}
			ONE: for (Resumepersonaldetails rs : searchResultList) {
				File fName = null;
				String fileName = rs.getFirstName() + rs.getId();
				StringTokenizer st = null;
				boolean flag = true;
				for (int i = 0; allFiles != null && i < allFiles.length; i++) {
					if (allFiles[i].getName().contains(fileName)) {
						fName = allFiles[i];
						break;
					}
				}
				if (fName != null) {
					try {
						BufferedReader in = new BufferedReader(new FileReader(
								fName));
						String str = new String();
						StringBuffer sb = new StringBuffer();

						while ((str = in.readLine()) != null) {
							sb.append(str.toLowerCase());
						}
						in.close();

						st = new StringTokenizer(all, ",");
						while (st.hasMoreTokens()) {
							String token1 = st.nextToken().trim();
							if (!token1.equals("")) {
								if (!(sb.indexOf(token1) >= 0)) {
									continue ONE;
								}
							}
						}
						if (!any.trim().equals("")) {
							flag = false;
							st = new StringTokenizer(any, ",");
							while (st.hasMoreTokens()) {
								String token1 = st.nextToken().trim();
								if (!token1.equals("")) {
									if ((sb.indexOf(token1) >= 0)) {
										flag = true;
										break;
									}
								}
							}
						} else {
							flag = true;
						}

						if (flag == false) {
							continue ONE;
						} else {
							st = new StringTokenizer(exclude, ",");
							while (st.hasMoreTokens()) {
								String token1 = st.nextToken().trim();
								if (!token1.equals("")) {
									if ((sb.indexOf(token1) >= 0)) {
										continue ONE;
									}
								}
							}
						}
						resumeList.add(rs);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			searchResultList = resumeList;
		}

		if (searchResultList != null && !searchResultList.isEmpty()) {
			for (int i = 0; i < RequestConstants.PAGE_RECORDS
					&& i < searchResultList.size(); ++i) {
				searchList.add(searchResultList.get(i));
			}
		}
		session.setAttribute("searchList", searchResultList);

		List skillList = (List) searchMap.get("skillList");

		if (searchResultList != null && skillList != null
				&& !searchResultList.isEmpty() && !skillList.isEmpty()) {
			error = false;
			map.put("searchResumeList", searchList);
			map.put("roleId", roleId);
			map.put("totalRecords", searchResultList.size());
			session.setAttribute("searchResumeResultMap", map);
		} else {
			error = true;
		}

		List projectList = (List) searchMap.get("projectList");
		List jobProfiles = (List) searchMap.get("jobProfiles");
		List departmentList = (List) searchMap.get("departmentList");
		String jsp = SEARCH_RESUME;
		jsp += ".jsp";
		String title = "Search Resume";
		map.put("title", title);
		map.put("skillList", skillList);
		map.put("departmentList", departmentList);
		map.put("statusMasterList", statusMasterList);
		map.put("projectList", projectList);
		map.put("jobProfiles", jobProfiles);
		map.put("errorSearch", error);
		map.put("contentJsp", jsp);
		map.put("min", 0);
		map.put("statusVal", statusVal);
		map.put("max", RequestConstants.PAGE_RECORDS);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewResume(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("users") == null) {
			return new ModelAndView("index");
		}

		Map detailsOfResume = null;

		Map<String, Object> map = new HashMap<String, Object>();
		int resumeID = ServletRequestUtils.getIntParameter(request, "resumeID", 0);
		String message = "";
		if (resumeID == 0) {
			message = "Offer Letter and CTC Annexure has been sent for approval";
		}
		String resumeStatus = "";
		String uploadUrl = getServletContext().getRealPath("/uploads");
		Users users = (Users) session.getAttribute(RequestConstants.USERS);
		if (resumeID != 0) {
			detailsOfResume = resumeHandlerService.getdetailsOfResume(resumeID,
					uploadUrl);
		} else {
			detailsOfResume = resumeHandlerService.getdetailsOfResume(Integer
					.valueOf(request.getParameter(RequestConstants.RESUMEID)),
					uploadUrl);
		}

		session.setAttribute("detailsOfResume", detailsOfResume);
		List resumeList = (List) detailsOfResume.get("resumePersonalDetails");
		Resumepersonaldetails personal = (Resumepersonaldetails) resumeList
				.get(0);
		List<Resumestatusmaster> statusList = resumeHandlerService
				.getStatusMasterList();

		for (Resumestatusmaster status : statusList) {
			if (status.getId().equals(personal.getResumeStatus().getStatusId())) {
				resumeStatus = status.getStatusDesc();
				break;
			}
		}

		Map<String, Boolean> roleMap = getRoleMap(request);
		Boolean ownerFlag = false;
		Boolean assignToFlag = false;
		Boolean ownerShipTimeFlag = true;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(HMSUtil.getCurrentDateAndTimeObject());
		cal2.setTime(personal.getOwnershipChnagedOn());
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();
		long diff = milis1 - milis2;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		if (personal.getAddBy().equals(users.getId())) {
			ownerFlag = true;
		}
		if (personal.getAssignedTo() != null
				&& personal.getAssignedTo().equals(users.getId())
				&& personal.getResumeStatus().getStatusId() < 7) {
			assignToFlag = true;
		}
		if (diffDays > 60) {
			ownerShipTimeFlag = false;
		}
		if (personal.getResumeStatus().getStatusId() > 6) {
			roleMap.put("techFlag", false);
		}

		roleMap.put("ownerFlag", ownerFlag);
		roleMap.put("assignToFlag", assignToFlag);
		roleMap.put("ownerShipTimeFlag", ownerShipTimeFlag);

		String title = "View Resume Details";
		String jsp = "hr_view_resume.jsp";

		map.put("detailsOfResume", detailsOfResume);
		map.put("resumeStatus", resumeStatus);
		map.put("roleMap", roleMap);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public Map getRoleMap(HttpServletRequest request) {
		Map<String, Boolean> roleMap = new HashMap<String, Boolean>();

		HttpSession session = request.getSession(false);
		Users user = (Users) session.getAttribute("user");
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String roleForRMSAdmin = properties.getProperty("roleForRMSAdmin");
		String roleForRMSRecruiter = properties
				.getProperty("roleForRMSRecruiter");
		String roleForRMSHRUser = properties.getProperty("roleForRMSHRUser");
		String roleForRMSTechnical = properties
				.getProperty("roleForRMSTechnical");
		Boolean adminFlag = false;
		Boolean recFlag = false;
		Boolean hrFlag = false;
		Boolean techFlag = false;

		Map applicationMap = new HashMap();
		String roleId = "";
		/*
		 * try { applicationMap = resumeHandlerService.app(user); roleId =
		 * (String)applicationMap.get("roleId"); StringTokenizer str1 = new
		 * StringTokenizer(roleId,",");
		 * 
		 * while(str1.hasMoreTokens()){ roleId = str1.nextToken();
		 * if(roleId.equals(roleForRMSAdmin)) { adminFlag = true; }
		 * if(roleId.equals(roleForRMSRecruiter)) { recFlag = true; }
		 * if(roleId.equals(roleForRMSHRUser)) { hrFlag = true; }
		 * if(roleId.equals(roleForRMSTechnical)) { techFlag = true; } } } catch
		 * (Exception e) { e.printStackTrace(); }
		 */
		roleMap.put("adminFlag", true);
		roleMap.put("recFlag", true);
		roleMap.put("hrFlag", true);
		roleMap.put("techFlag", true);
		return roleMap;
	}

	public List getCheckedResumeList(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		Users user = (Users) session.getAttribute(RequestConstants.USERS);

		List<Object> tempList = new ArrayList<Object>();
		List searchResumeList = new ArrayList();
		if (session.getAttribute("searchResumeList") != null) {
			searchResumeList = (List) session.getAttribute("searchResumeList");
		}

		for (int i = 1; i <= searchResumeList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				tempList.add(searchResumeList.get(i - 1));
			}
		}
		return tempList;
	}

	public ModelAndView changeAssignedTo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		properties.load(resourcePath.openStream());

		Map<String, Object> map = new HashMap<String, Object>();
		Users user = (Users) session.getAttribute(RequestConstants.USERS);

		Integer assignedTo = Integer.parseInt(request
				.getParameter("assignedTo"));
		List<Resumepersonaldetails> resumeListToBeShortListed = null;
		/*
		 * if (session.getAttribute("resumeListToBeShortListed") != null) {
		 * resumeListToBeShortListed = (List<Resumepersonaldetails>)
		 * session.getAttribute("resumeListToBeShortListed"); }
		 */
		String requestId = request.getParameter("requestId");
		Integer requestIdInt = null;
		if (requestId != null) {
			requestIdInt = new Integer(requestId);
		}
		List tempList = null;
		if (resumeListToBeShortListed == null) {
			tempList = getCheckedResumeList(request);
		} else {
			tempList = resumeListToBeShortListed;
		}

		Map<String, Object> authorizationMap = new HashMap<String, Object>();

		authorizationMap.put("tempList", tempList);
		authorizationMap.put("assignedTo", assignedTo);
		authorizationMap.put("requestId", requestIdInt);
		String name = "";
		String newOwnerEmailId = "";
		int arraySize = tempList.size();
		String fullName = "";
		String location = "";
		String exp = "";
		String company = "";
		String currentCtc = "";
		String expectedCtc = "";

		Map updateAuthorizationMap = resumeHandlerService
				.updateAuthorizationTo(authorizationMap);
		if (updateAuthorizationMap.get("name") != null) {
			name = (String) updateAuthorizationMap.get("name");
		}
		if (updateAuthorizationMap.get("emailId") != null) {
			newOwnerEmailId = (String) updateAuthorizationMap.get("emailId");
		}

		String emailId = "";
		String candidateName = "";
		String candidateNameWithEmailId = "";
		String oldOwnerName = "";
		String oldOwnerMailId = "";
		String emailMessage = "";
		String emailMessage1 = "";
		String emailMessage2 = "";
		for (int i = 0; i < tempList.size(); i++) {
			Resumepersonaldetails resumepersonaldetails = (Resumepersonaldetails) tempList
					.get(i);
			emailId = emailId.concat(resumepersonaldetails.getEmailId())
					.concat("\n");
			candidateNameWithEmailId = candidateNameWithEmailId
					.concat(i + 1 + "). Name :- ")
					.concat(resumepersonaldetails.getFirstName() + " "
							+ resumepersonaldetails.getLastName()).concat(",")
					.concat(" Email Id :- ")
					.concat(resumepersonaldetails.getEmailId()).concat("\n");
			String ccListString = request.getParameter(RequestConstants.CCLIST);

			candidateName = candidateName.concat(
					resumepersonaldetails.getFirstName() + " "
							+ resumepersonaldetails.getLastName()).concat("\n");
			fullName = fullName.concat(
					resumepersonaldetails.getFirstName() + " "
							+ resumepersonaldetails.getLastName()).concat(
					"<br />");
			String city = "--";
			if (resumepersonaldetails.getCity() != null) {
				city = resumepersonaldetails.getCity().getDistrictName();
			}
			location = location.concat(city).concat("<br />");
			exp = exp.concat(
					resumepersonaldetails.getExperienceYear() + "."
							+ resumepersonaldetails.getExperienceMonth())
					.concat("<br />");
			company = company.concat("<br />");
			currentCtc = currentCtc.concat(
					resumepersonaldetails.getCurrentCtc()).concat("<br />");
			expectedCtc = expectedCtc.concat(
					resumepersonaldetails.getExpectedCtc()).concat("<br />");

			if (resumepersonaldetails.getAssignedResumeTo() != null
					&& resumepersonaldetails.getAssignedResumeTo()
							.getUserName() != null) {
				oldOwnerName = resumepersonaldetails.getAssignedResumeTo()
						.getUserName();
			}

			if (i == arraySize - 1) {
				emailMessage = "Hi \n\n  1     Following is the List of candidate profiles has been shortlisted for final technical interview :- \n\n";
				emailMessage = emailMessage.concat(candidateNameWithEmailId
						.substring(0, candidateNameWithEmailId.length() - 1));
				emailMessage = emailMessage
						.concat("\r\r\rThanks and Regards,\r");
				emailMessage = emailMessage.concat(user.getUserName());

				emailMessage1 = "Hi \n\n      Following is the List of candidate profiles has been assigned to Mr. "
						+ name
						+ " for final technical interview by you :- \n\n";
				emailMessage1 = emailMessage1.concat(candidateNameWithEmailId
						.substring(0, candidateNameWithEmailId.length() - 1));

				if (resumepersonaldetails.getAssignedResumeTo() != null) {
					emailMessage2 = "Hi \n\n  Following is the List of candidate profiles that has been assigned to Mr. "
							+ name + " for final technical interview :- \n\n";
					emailMessage2 = emailMessage2
							.concat(candidateNameWithEmailId.substring(0,
									candidateNameWithEmailId.length() - 1));
					emailMessage2 = emailMessage2
							.concat("\r\r\rThanks and Regards,\r");
					emailMessage2 = emailMessage2.concat(user.getUserName());
				}
				String subject = "Resume Shorlisted";

				String loginId = user.getEmailAddress();
				String to[] = new String[1];
				to[0] = newOwnerEmailId;
				String emailMsg[] = new String[1];
				emailMsg[0] = emailMessage;

				// SendMail.sendMailForRMS("",to,loginId,ccListString,"",subject,emailMsg);
				// SendMail.sendMail("",loginId,loginId,"","",subject,emailMessage1);

				if (resumepersonaldetails.getAssignedResumeTo() != null) {
					oldOwnerMailId = resumepersonaldetails
							.getAssignedResumeTo().getEmployee().getEmail();
					// SendMail.sendMail("",oldOwnerMailId,loginId,"","",subject,emailMessage2);
				}
			}
			String message[] = {
					"Selected Candidates has been shortlisted successfully.<div class='clear'></div><table width='100%' cellpadding='0' cellspacing='0' align=center><tr><th>Candidate's Name</th><th>Present Location</th><th>Years Of Experience</th><th>Current CTC</th><th>Expected CTC</th></tr></th><tbody><tr><td><font color='black'>"
							+ fullName
							+ "</font></td><td><font color='black'>"
							+ location
							+ "</font></td><td><font color='black'>"
							+ exp
							+ "</font></td><td><font color='black'>"
							+ currentCtc
							+ "</font></td><td><font color='black'>"
							+ expectedCtc
							+ "</font></td></tr></tbody></table> ",
					"javascript:history.back()",
					"/hms/hms/login?method=validate" };

			map.put("message", message);
		}
		map.put("tempList", tempList);
		map.put("contentJsp", "hr_message.jsp");

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showShortListResumeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		Map map = new HashMap();
		String jsp = "hr_shortlistResume.jsp";
		List resumeListToBeShortListed = resumeHandlerService
				.getUploadedResumes();
		List manPowerRequisitionList = recruitmentHandlerService
				.getAllApprovedRequests();
		List rmsIdList = resumeHandlerService.getRecruitersList();
		map.put("resumeListToBeShortListed", resumeListToBeShortListed);
		map.put("manPowerRequisitionList", manPowerRequisitionList);
		map.put("rmsIdList", rmsIdList);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showTechDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Map map = new HashMap();
		int resumeId = Integer.parseInt(ServletRequestUtils.getStringParameter(
				request, RequestConstants.RESUMEID, ""));
		String name = ServletRequestUtils.getStringParameter(request,
				RequestConstants.NAME, "");

		List<Resumestatusmaster> statusMasterList = (List<Resumestatusmaster>) resumeHandlerService
				.getStatusMasterList();
		List techDetailsList = resumeHandlerService
				.getTechnicalHistory(resumeId);
		List statusList = resumeHandlerService.getCurrentStatus(resumeId);
		Integer statusId = ((Resumestatus) statusList.get(0)).getStatusId();

		String resumeStatus = "Uploded";
		for (Resumestatusmaster status : statusMasterList) {
			if (status.getId().equals(statusId)) {
				resumeStatus = status.getStatusDesc();
				break;
			}
		}

		String jsp = "hr_resume_tech_details.jsp";
		String title = "Resume Technical Details";

		map.put("name", name);
		map.put("resumeId", resumeId);
		map.put("status", resumeStatus);
		map.put("contentJsp", jsp);
		map.put("statusMasterList", statusMasterList);
		map.put("techDetailsList", techDetailsList);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addTechDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(RequestConstants.USERS);

		Map map = (Map) session.getAttribute("map");
		Resumetechnical resumeTechnical = null;
		if (map.get("technicalDetails") != null) {
			Resumetechnical resumeTech = (Resumetechnical) map
					.get("technicalDetails");
			resumeTechnical = resumeHandlerService
					.getResumeTechnical(resumeTech.getId());
		} else {
			resumeTechnical = new Resumetechnical();
		}

		Resumetechnicalhistory resumeTechnicalHistory = new Resumetechnicalhistory();
		Resumepersonaldetails resumepersonaldetails = new Resumepersonaldetails();
		Map<String, Object> techMap = new HashMap<String, Object>();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		Properties properties = new Properties();
		properties.load(resourcePath.openStream());
		MultipartFormDataRequest mrequest = null;
		int resumeId = 0;
		boolean addTechDetails = false;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			resumeId = new Integer(
					mrequest.getParameter(RequestConstants.RESUMEID));

			if (resumeId != 0) {
				resumeTechnical.setResumeId(resumeId);
				resumeTechnical.setDateOfInterview(mrequest
						.getParameter(RequestConstants.DATEOFINTERVIEW));
				resumeTechnical.setTechnicalKnowledge(mrequest
						.getParameter(RequestConstants.TECHSTATUS));
				// resumeTechnical.setRelevantExperience(mrequest.getParameter(RequestConstants.EXPERIENCE));
				resumeTechnical.setRelExperienceYears(new Integer(mrequest
						.getParameter(RequestConstants.YEARS)));
				resumeTechnical.setRelExperienceMonths(new Integer(mrequest
						.getParameter(RequestConstants.MONTHS)));
				resumeTechnical.setMajorStrength(mrequest
						.getParameter(RequestConstants.STRENGTHS));
				resumeTechnical.setMajorWeakness(mrequest
						.getParameter(RequestConstants.WEAKNESS));
				resumeTechnical.setAreaProbed(mrequest
						.getParameter(RequestConstants.AREAPROBED));
				resumeTechnical.setStatus(mrequest
						.getParameter(RequestConstants.RESULT));
				resumeTechnical.setReasonHold(mrequest.getParameter("reason"));
				resumeTechnical.setRecommended(mrequest
						.getParameter("recomended"));
				resumeTechnical.setInterviewerName(mrequest
						.getParameter(RequestConstants.INTERVIEWERNAME));
				// resumeTechnical.setInterviewerName(currentUser);
				resumeTechnical.setDate(HMSUtil.getCurrentDateAndTimeObject());
				if (mrequest.getParameter(RequestConstants.OBSERVER1) != null) {

					resumeTechnical.setObserver1(mrequest
							.getParameter(RequestConstants.OBSERVER1));
				}
				if (mrequest.getParameter(RequestConstants.OBSERVER2) != null) {

					resumeTechnical.setObserver2(mrequest
							.getParameter(RequestConstants.OBSERVER2));
				}
				if (mrequest.getParameter(RequestConstants.OBSERVER3) != null) {

					resumeTechnical.setObserver3(mrequest
							.getParameter(RequestConstants.OBSERVER3));
				}

				resumeTechnicalHistory.setResumeId(resumeId);
				resumeTechnicalHistory.setDateOfInterview(mrequest
						.getParameter(RequestConstants.DATEOFINTERVIEW));
				resumeTechnicalHistory.setTechnicalKnowledge(mrequest
						.getParameter(RequestConstants.TECHSTATUS));
				resumeTechnicalHistory.setRelevantExperience(mrequest
						.getParameter(RequestConstants.EXPERIENCE));
				resumeTechnicalHistory.setMajorStrength(mrequest
						.getParameter(RequestConstants.STRENGTHS));
				resumeTechnicalHistory.setMajorWeakness(mrequest
						.getParameter(RequestConstants.WEAKNESS));
				resumeTechnicalHistory.setAreaProbed(mrequest
						.getParameter(RequestConstants.AREAPROBED));
				resumeTechnicalHistory.setStatus(mrequest
						.getParameter(RequestConstants.RESULT));
				resumeTechnicalHistory.setReasonHold(mrequest
						.getParameter("reason"));
				resumeTechnicalHistory.setRecommended(mrequest
						.getParameter("recomended"));
				resumeTechnicalHistory.setInterviewerName(mrequest
						.getParameter(RequestConstants.INTERVIEWERNAME));
				// resumeTechnicalHistory.setInterviewerName(currentUser);
				resumeTechnicalHistory.setDate(HMSUtil
						.getCurrentDateAndTimeObject());

				addTechDetails = resumeHandlerService.addTechDetails(
						resumeTechnical, resumeTechnicalHistory);

				if (addTechDetails) {
					String uploadURL = getServletContext().getRealPath(
							"/uploads/evaluationSheets");// properties.getProperty("uploadEvaluationSheet");

					String whiteList = "*.doc,*.txt,*.rtf,*.DOC,*.TXT,*.RTF,*.pdf";
					Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
					String firstName = resumeTechnical
							.getResumepersonaldetails().getFirstName();

					int id = resumeId;
					String fileNameToBeAssigned = firstName + id;

					List fileUploadedList = null;
					// Connection connection =
					// resumeHandlerService.getDBConnection();
					fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
							whiteList, fileSizeLimit, fileNameToBeAssigned);
					Boolean fileUploaded = false;
					if (fileUploadedList != null
							&& fileUploadedList.size() != 0) {
						fileUploaded = (Boolean) fileUploadedList.get(0);
					}
				}
			}
		}

		if (addTechDetails) {
			String message[] = {
					"Technical Details has been added successfully.<br />Click <a href ='/hms/hrms/resume?method=viewResume&resumeID="
							+ resumeId
							+ "'>here</a> to go back to View Resume. ",
					"javascript:history.back()",
					"/hms/hms/login?method=validate" };
			map.put("message", message);
		} else {
			String message[] = {
					"There is Some problem in adding technical details. Please Try Again! ",
					"javascript:history.back()",
					"/hms/hms/login?method=validate" };
			map.put("message", message);
		}
		String jsp = "hr_message.jsp";
		map.put("contentJsp", jsp);
		String title = "Resume Technical Details";
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHRDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		int resumeId = ServletRequestUtils.getIntParameter(request,
				RequestConstants.RESUMEID, 0);
		String name = ServletRequestUtils.getStringParameter(request,
				RequestConstants.NAME, "");
		String status = ServletRequestUtils.getStringParameter(request,
				RequestConstants.STATUS, "");

		Map map = new HashMap();
		List statusMasterList = resumeHandlerService.getStatusMasterList();
		List hrDetails = resumeHandlerService.getHrDetails(resumeId);
		String jsp = "hr_resume_hr_details.jsp";
		map.put("resumeId", resumeId);
		map.put("name", name);
		map.put("contentJsp", jsp);
		map.put("statusMasterList", statusMasterList);
		map.put("hrDetails", hrDetails);
		map.put("status", status);
		String title = "Resume HR Details";
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addHRDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		Users user = (Users) session.getAttribute(RequestConstants.USERS);
		String currentUser = user.getUserName();
		Map map = new HashMap();

		Resumehrdetails resumeHrDetails = null;
		if (session.getAttribute("resumehrDetails") != null) {
			Resumehrdetails resumeHr = (Resumehrdetails) session
					.getAttribute("resumehrDetails");
			resumeHrDetails = resumeHandlerService
					.getResumeHr(resumeHr.getId());
		} else {
			resumeHrDetails = new Resumehrdetails();
		}
		Resumehrdetailshistory resumeHrDetailsHistory = new Resumehrdetailshistory();
		int resumeId = ServletRequestUtils.getIntParameter(request,
				RequestConstants.RESUMEID, 0);
		String maritalStatus = ServletRequestUtils.getStringParameter(request,
				RequestConstants.MARITALSTATUS, "");
		String locationPreference = ServletRequestUtils.getStringParameter(request,
				RequestConstants.LOCATION, "");
		String familyDetails = ServletRequestUtils.getStringParameter(request,
				RequestConstants.FAMILYDETAILS, "");
		String reportingStructure = ServletRequestUtils.getStringParameter(request,
				RequestConstants.CURRENTREPORTING, "");
		String reasonToLeave = ServletRequestUtils.getStringParameter(request,
				RequestConstants.REASONOFLEAVING, "");
		String HrRatings = ServletRequestUtils.getStringParameter(request,
				RequestConstants.HRRATING, "");
		String overallAssesment = ServletRequestUtils.getStringParameter(request,
				RequestConstants.OVERALLASSESSMENT, "");
		String recommended = ServletRequestUtils.getStringParameter(request,
				RequestConstants.RECOMENDED, "");
		String interviewersName = ServletRequestUtils.getStringParameter(request,
				RequestConstants.INTERVIEWERNAME, "");

		// String approvalDirector =
		// ServletRequestUtils.getStringParameter(request,RequestConstants.APPROVALDIRECTOR,
		// "");

		if (resumeId != 0) {
			resumeHrDetails.setResumeId(resumeId);
			resumeHrDetails.setMaritalStatus(maritalStatus);
			resumeHrDetails.setLocationPreference(locationPreference);
			resumeHrDetails.setFamilyDetails(familyDetails);
			resumeHrDetails.setReportingStructure(reportingStructure);
			resumeHrDetails.setReasonToLeave(reasonToLeave);
			resumeHrDetails.setHrRatings(HrRatings);
			resumeHrDetails.setOverallAssesment(overallAssesment);
			resumeHrDetails.setRecommended(recommended);
			// resumeHrDetails.setApprovalDirector(approvalDirector);
			// resumeHrDetails.setInterviewerName(currentUser);
			resumeHrDetails.setDate(HMSUtil.getCurrentDateAndTimeObject());
			resumeHrDetails.setInterviewerName(interviewersName);
		}
		resumeHrDetailsHistory.setResumeId(resumeId);
		resumeHrDetailsHistory.setMaritalStatus(maritalStatus);
		resumeHrDetailsHistory.setLocationPreference(locationPreference);
		resumeHrDetailsHistory.setFamilyDetails(familyDetails);
		resumeHrDetailsHistory.setReportingStructure(reportingStructure);
		resumeHrDetailsHistory.setReasonToLeave(reasonToLeave);
		resumeHrDetailsHistory.setHrRatings(HrRatings);
		resumeHrDetailsHistory.setOverallAssesment(overallAssesment);
		resumeHrDetailsHistory.setRecommended(recommended);
		// resumeHrDetailsHistory.setApprovalDirector(approvalDirector);
		resumeHrDetailsHistory.setInterviewerName(interviewersName);
		resumeHrDetailsHistory.setDate(HMSUtil.getCurrentDateAndTimeObject());

		boolean addHRDetails = resumeHandlerService.addHRDetails(
				resumeHrDetails, resumeHrDetailsHistory);

		if (addHRDetails) {
			String message[] = {
					"HR Details has been added successfully.<br />Click <a href ='/hms/hrms/resume?method=viewResume&resumeID="
							+ resumeId
							+ "'>here</a> to go back to View Resume.",
					"javascript:history.back()",
					"/hms/rms/login?method=validate" };
			map.put("message", message);
		} else {
			String message[] = {
					"There is Some problem in adding HR details. Please Try Again! ",
					"javascript:history.back()",
					"/hms/hms/login?method=validate" };
			map.put("message", message);
		}
		String title = "Resume HR Details";
		map.put("title", title);
		String jsp = "hr_message.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFinalStatus(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Map map = new HashMap();

		int resumeId = Integer.parseInt(ServletRequestUtils.getStringParameter(
				request, RequestConstants.RESUMEID, ""));
		String offer = "";
		if (request.getParameter("offer") != null) {
			offer = request.getParameter("offer");
		}
		List resumeStatus = resumeHandlerService.getCurrentStatus(resumeId);
		List statusMasterList = resumeHandlerService
				.getStatusMasterListForFinalStatus();
		List designationMasterList = resumeHandlerService
				.getMasterList("MasRank");
		List locationMasterList = resumeHandlerService
				.getMasterList(MasLocation.class);
		// LocationMaster l= new LocationMaster();
		List currencyMasterList = resumeHandlerService
				.getMasterList("MasCurrency");
		List countryMasterList = resumeHandlerService
				.getMasterList("MasCountry");
		String name = ServletRequestUtils.getStringParameter(request,
				RequestConstants.NAME, "");
		String jsp = "hr_add_final_status.jsp";
		String title = "Resume Status";

		map.put("name", name);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("statusMasterList", statusMasterList);
		map.put("designationMasterList", designationMasterList);
		map.put("locationMasterList", locationMasterList);
		map.put("currencyMasterList", currencyMasterList);
		map.put("countryMasterList", currencyMasterList);
		map.put("resumeStatus", resumeStatus);
		map.put("offer", offer);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addResumeStatus(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Map map = new HashMap();

		int statusId = 0;
		if (request.getParameter("statusId") != null) {
			statusId = new Integer(request.getParameter("statusId"));
		}
		int resumeId = ServletRequestUtils.getIntParameter(request,
				RequestConstants.RESUMEID, 0);
		String dateOfJoin = ServletRequestUtils.getStringParameter(request,
				RequestConstants.DATEOFJOINING, "");
		Integer designation = ServletRequestUtils.getIntParameter(request,
				RequestConstants.DESIGNATION, 0);
		String CTC = ServletRequestUtils.getStringParameter(request,
				RequestConstants.CTC, "");

		// salary details
		String currentCTC = ServletRequestUtils.getStringParameter(request,
				RequestConstants.CURRENTCTC, "");
		String expectedCTC = ServletRequestUtils.getStringParameter(request,
				RequestConstants.EXPECTEDSALARY, "");
		String salaryRemarks = ServletRequestUtils.getStringParameter(request,
				RequestConstants.SALARYREMARKS, "");
		String curreny = ServletRequestUtils.getStringParameter(request,
				RequestConstants.CURRENCY, "");

		String location = ServletRequestUtils.getStringParameter(request,
				RequestConstants.LOCATION, "");
		String project_assign = ServletRequestUtils.getStringParameter(request,
				RequestConstants.PROJECTASSIGNED, "");

		Integer relocationReimbursement = ServletRequestUtils.getIntParameter(request,
				RequestConstants.RELOCATION_REIMBURSEMENT, 0);
		Integer noticePeriodRelocationReimbursement = ServletRequestUtils
				.getIntParameter(request,
						RequestConstants.NOTICE_PERIOD_REIMBURSEMENTS, 0);

		Integer probationPeriod = ServletRequestUtils.getIntParameter(request,
				RequestConstants.PROBATION_PERIOD, 0);
		Integer noticePeriod = ServletRequestUtils.getIntParameter(request,
				RequestConstants.NOTICE_PERIOD, 0);

		String remarks = ServletRequestUtils.getStringParameter(request,
				RequestConstants.REMARKS, "");

		List<Resumepersonaldetails> resumepersonaldetailsList = resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resumepersonaldetails = resumepersonaldetailsList
				.get(0);
		Resumestatus resumeStatus = resumepersonaldetails.getResumeStatus();
		Resumestatushistory resumeStatusHistory = new Resumestatushistory();

		resumeStatus.setResumeId(resumeId);
		resumeStatus.setStatusId(statusId);

		if (!dateOfJoin.equals("")) {
			resumeStatus.setDateOfJoin(dateOfJoin);
		}

		MasRank masRank = new MasRank();
		if (!designation.equals(0)) {
			masRank.setId(designation);
			resumeStatus.setDesignation(masRank);
		}
		if (!location.equals("")) {
			resumeStatus.setLocation(location);
		}

		if (!CTC.equals("")) {
			resumeStatus.setCtc(CTC);
		}

		if (!currentCTC.equals("")) {
			resumeStatus.setCurrentCTC(currentCTC);
		}

		if (!expectedCTC.equals("")) {
			resumeStatus.setExpectedCTC(expectedCTC);
		}

		if (!curreny.equals("")) {
			resumeStatus.setCurrency(curreny);
		}

		if (!salaryRemarks.equals("")) {
			resumeStatus.setSalaryRemarks(salaryRemarks);
		}

		if (!project_assign.equals("")) {
			resumeStatus.setProjectAssign(project_assign);
		}

		if (!relocationReimbursement.equals(0)) {
			resumeStatus.setRelocationReimbursement(relocationReimbursement);
		}

		if (!noticePeriod.equals(0)) {
			resumeStatus.setNoticePeriod(noticePeriod);
		}

		resumeStatus
				.setNoticePeriodReimbursements(noticePeriodRelocationReimbursement);

		if (!probationPeriod.equals(0)) {
			resumeStatus.setProbationPeriod(probationPeriod);
		}
		resumeStatus.setDate(HMSUtil.getCurrentDateAndTimeObject());

		resumeStatus.setRemarks(remarks);

		resumeStatusHistory.setResumeId(resumeId);
		resumeStatusHistory.setDateOfJoin(dateOfJoin);
		resumeStatusHistory.setDesignation(masRank);
		resumeStatusHistory.setLocation(location);
		resumeStatusHistory.setCtc(CTC);
		resumeStatusHistory.setCurrentCTC(currentCTC);
		resumeStatusHistory.setExpectedCTC(expectedCTC);
		resumeStatusHistory.setCurrency(curreny);
		resumeStatusHistory.setSalaryRemarks(salaryRemarks);
		resumeStatusHistory.setProjectAssign(project_assign);
		resumeStatusHistory.setRelocationReimbursement(relocationReimbursement);
		resumeStatusHistory.setNoticePeriod(noticePeriod);
		resumeStatusHistory.setProbationPeriod(probationPeriod);
		resumeStatusHistory.setStatusId(statusId);
		resumeStatusHistory.setDate(HMSUtil.getCurrentDateAndTimeObject());
		resumeStatusHistory.setRemarks(remarks);

		boolean addStatus = resumeHandlerService.addResumeStatus(resumeStatus,
				resumeStatusHistory);

		if (statusId == 18) {
			ResourceRequisition resourceRequisition = resumepersonaldetails
					.getResourceRequisition();
			Integer noOfPositionsOccupied = resourceRequisition
					.getNoOfPositionOccupied();

			if (noOfPositionsOccupied != null) {
				resourceRequisition
						.setNoOfPositionOccupied(++noOfPositionsOccupied);
			}
			recruitmentHandlerService
					.saveResourceRequisitionDetail(resourceRequisition);
		}

		/*
		 * if(resumeStatus.getResumepersonaldetails().getResumePayElements()
		 * !=null &&
		 * resumeStatus.getResumepersonaldetails().getResumePayElements
		 * ().size()>0) { session.setAttribute("offerDetailsUpdated",true);
		 * return updateCTC(request, response); }
		 */

		if (addStatus) {
			String message[] = {
					"Resume Status has been added successfully.<br />Click <a href ='/hms/hrms/resume?method=viewResume&resumeID="
							+ resumeId
							+ "'>here</a> to go back to View Resume.",
					"javascript:history.back()",
					"/hms/hrms/resume?method=searchResume" };
			map.put("message", message);
			map.put("resumeId", resumeId);
			map.put("statusId", statusId);
		} else {
			String message[] = {
					"There is Some problem in adding resume status. Please Try Again! ",
					"javascript:history.back()",
					"/hms/hrms/resume?method=searchResume" };
			map.put("message", message);
			map.put("statusId", statusId);
		}
		String title = "Resume Status";
		map.put("title", title);
		String jsp = "hr_message.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchResumeExcelReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);

		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		Map excelMap = new HashMap();
		Map map = new HashMap();
		if (session.getAttribute("searchResumeResultMap") != null) {
			map = (Map) session.getAttribute("searchResumeResultMap");
		}

		List searchResumeList = (List) map.get("searchResumeList");
		List tempResumeList = new ArrayList();
		String ids = request.getParameter("allIds");

		for (int i = 0; i < searchResumeList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				tempResumeList.add(searchResumeList.get(i));
			}
		}

		map.put("excelResumeList", tempResumeList);

		map.put("tempResumeList", tempResumeList);
		return new ModelAndView("hr_searchResumeExcelReport", "map", map);
		/*
		 * map.remove("main"); map.put("main","search_resume_excel.jsp"); return
		 * new ModelAndView("mainPage", "map", map);
		 */
	}

	public ModelAndView broadcastMail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		session = request.getSession(false);

		Users user = (Users) session.getAttribute(RequestConstants.USERS);

		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("searchResumeResultMap") != null) {
			map = (HashMap<String, Object>) session
					.getAttribute("searchResumeResultMap");
		}
		List<Resumepersonaldetails> searchResumeList = (ArrayList<Resumepersonaldetails>) map
				.get("searchResumeList");
		List<Resumepersonaldetails> tempMailList = new ArrayList<Resumepersonaldetails>();

		for (int i = 0; i < searchResumeList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				tempMailList.add(searchResumeList.get(i));
			}
		}

		Iterator mailIterator = tempMailList.iterator();
		int arraySize = 0;
		arraySize = tempMailList.size();
		String mailList[] = new String[arraySize];
		String emailMessage = "";
		String emailMessageList[] = new String[arraySize];
		for (int i = 0; mailIterator.hasNext(); i++) {
			Resumepersonaldetails resumepersonaldetails2 = (Resumepersonaldetails) mailIterator
					.next();
			String emailId = resumepersonaldetails2.getEmailId();
			String name = resumepersonaldetails2.getFirstName() + " "
					+ resumepersonaldetails2.getLastName();
			mailList[i] = name + "<" + emailId + ">";
			emailMessage = "Hi ";
			emailMessage = emailMessage.concat(resumepersonaldetails2
					.getFirstName()
					+ " "
					+ resumepersonaldetails2.getLastName() + "\n\n");
			emailMessage = emailMessage.concat(ServletRequestUtils.getStringParameter(
					request, RequestConstants.MAIL_BODY, ""));
			emailMessage = emailMessage.concat("\r\r\rThanks and Regards,\r");
			emailMessage = emailMessage.concat(user.getUserName());
			emailMessageList[i] = emailMessage;
		}

		String subject = ServletRequestUtils.getStringParameter(request,
				RequestConstants.MAIL_SUBJECT, "");
		Map mapForMailMsg = new HashMap();

		try {
			mapForMailMsg = SendMail.sendMailForRMS("", mailList,
					user.getEmailAddress(), "", "", subject, emailMessageList);
		} catch (Exception e) {
		}
		String sentSuccessfullyMsg = (String) mapForMailMsg
				.get("sentSuccessfullyMsg");
		String notSentSuccessfullyMsg = (String) mapForMailMsg
				.get("notSentSuccessfullyMsg");

		map.put("sentSuccessfullyMsg", sentSuccessfullyMsg);
		map.put("notSentSuccessfullyMsg", notSentSuccessfullyMsg);
		map.put("title", "Broadcast Mail");
		String jsp = "hr_RMSMessage.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEditResume(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		int resumeid = ServletRequestUtils.getIntParameter(request,
				RequestConstants.RESUMEID, 0);
		Map detailsOfResume = (Map) session.getAttribute("detailsOfResume");
		// resumeHandlerService.getdetailsOfResume(resumeid);
		List jobProfiles = resumeHandlerService.getMasterList(MasRank.class);
		List duList = resumeHandlerService.getDuList();
		// List projectDetails = resumeHandlerService.getProjectDetails();
		List qualificationList = resumeHandlerService
				.getQualificationMasterList();
		List projectList = new ArrayList();
		// List projectList =new ArrayList();
		// resumeHandlerService.getMasterListWithoutStatus(MstrProject.class);
		List titleList = resumeHandlerService.getMasterList(MasTitle.class);
		// List countryList = resumeHandlerService.getCountryList();
		map = resumeHandlerService.getAddressMap();
		String title = "Edit Resume";
		String jsp = "hr_edit_resume.jsp";

		map.put("detailsOfResume", detailsOfResume);
		map.put("jobProfiles", jobProfiles);
		map.put("duList", duList);
		// map.put("projectDetails",projectDetails);
		map.put("projectList", projectList);
		map.put("qualificationList", qualificationList);
		map.put("titleList", titleList);
		map.put("editResumeid", resumeid);
		map.put("title", title);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public void generateOfferLetter(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String resumeId = request.getParameter(RequestConstants.RESUMEID);
		List resumeList = resumeHandlerService
				.getResumePersonalDetailsById(new Integer(resumeId));
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);
		ServletContext context = session.getServletContext();
		String report = request.getParameter("letterType");
		String cd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.format(new Date());
		String fileName = report + "_" + resume.getFirstName() + "_" + cd;
		Integer resumeIdInt = new Integer(resumeId) * 17;
		String uniqueId = report.substring(0, 1) + resumeIdInt.toString()
				+ resume.getFirstName().substring(0, 1)
				+ resume.getLastName().substring(0, 1)
				+ new Float((Math.random() * 13)).intValue();
		Date issueDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter("issueDate"));
		MasRank designationVPHR = (MasRank) resumeHandlerService.loadObject(
				MasRank.class, 82);
		Set empSet = designationVPHR.getMasEmployees();
		List<MasEmployee> empList = null;
		MasEmployee HRHead = null;
		if (empSet != null && empSet.size() > 0) {
			empList = new ArrayList(empSet);
			List<MasEmployee> tempList = empList;
			for (MasEmployee emp : empList) {
				tempList.remove(emp);
			}
			if (tempList.size() > 0) {
				HRHead = (MasEmployee) tempList.get(0);
			}

		}
		String hrHeadName = "";
		if (HRHead != null) {
			hrHeadName = HRHead.getFirstName() + " " + HRHead.getLastName();
		} else {
			hrHeadName = "";
		}
		Map parameters = new HashMap();
		parameters.put("uniqueId", uniqueId);
		parameters.put("vicePresidentname", hrHeadName);
		parameters.put("SUBREPORT_DIR", context.getRealPath("/Reports/"));
		parameters.put("issueDate", issueDate);
		byte[] bytes = null;

		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					report);
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					resumeList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream outputStream = response.getOutputStream();

			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void generateJoiningLetter(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String resumeId = request.getParameter(RequestConstants.RESUMEID);
		List resumeList = resumeHandlerService
				.getResumePersonalDetailsById(new Integer(resumeId));
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);
		ServletContext context = session.getServletContext();
		String report = request.getParameter("letterType");
		String cd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.format(new Date());
		String fileName = report + "_" + resume.getFirstName() + "_" + cd;
		Integer resumeIdInt = new Integer(resumeId) * 17;
		String uniqueId = report.substring(0, 1) + resumeIdInt.toString()
				+ resume.getFirstName().substring(0, 1)
				+ resume.getLastName().substring(0, 1)
				+ new Float((Math.random() * 13)).intValue();
		Date issueDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter("issueDate"));
		MasRank designationVPHR = (MasRank) resumeHandlerService.loadObject(
				MasRank.class, 82);
		Set empSet = designationVPHR.getMasEmployees();
		List<MasEmployee> empList = null;
		MasEmployee HRHead = null;
		if (empSet != null && empSet.size() > 0) {
			empList = new ArrayList(empSet);
			List<MasEmployee> tempList = empList;
			for (MasEmployee emp : empList) {
				tempList.remove(emp);
			}
			if (tempList.size() > 0) {
				HRHead = (MasEmployee) tempList.get(0);
			}

		}
		String hrHeadName = "";
		if (HRHead != null) {
			hrHeadName = HRHead.getFirstName() + " " + HRHead.getLastName();
		} else {
			hrHeadName = "";
		}
		Map parameters = new HashMap();
		parameters.put("issueDate", issueDate);
		parameters.put("uniqueId", uniqueId);
		parameters.put("resumeID", resume.getId());
		parameters.put("vicePresidentname", hrHeadName);
		parameters.put("SUBREPORT_DIR", context.getRealPath("/Reports//"));
		byte[] bytes = null;

		try {
			Connection conn = resumeHandlerService.getDBConnection();
			HMSUtil.generateReport("joiningLetter", parameters, conn, response,
					context);
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream outputStream = response.getOutputStream();

			outputStream.write(bytes, 0, bytes.length);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ModelAndView showHistory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}

		String jspName = request.getParameter("jspName");
		String candidateName = request.getParameter("candidateName");
		Map<String, Object> historyMap = new HashMap<String, Object>();
		List<String> tableHeaderList = new ArrayList<String>();
		List<Object> tableValueList = new ArrayList<Object>();
		int resumeId = ServletRequestUtils.getIntParameter(request, "resumeId", 0);

		List statusMasterList = resumeHandlerService.getStatusMasterList();
		String title = "";
		if (jspName.equals("technical")) {
			tableHeaderList.add("Interviewer Name");
			tableHeaderList.add("Relevant Exp.");
			tableHeaderList.add("Date of Interview");
			tableHeaderList.add("Technical Knowledge");
			tableHeaderList.add("Strengths");
			tableHeaderList.add("Weakness");
			tableHeaderList.add("Area Probed");
			tableHeaderList.add("Result of Interview");
			tableHeaderList.add("Reason");
			tableHeaderList.add("Recommended");
			tableValueList = resumeHandlerService.getTechnicalHistory(resumeId);
			title = "Technical View History";
			historyMap.put("objectType", "technical");
		} else if (jspName.equals("hr")) {
			tableHeaderList.add("Interviewer Name");
			tableHeaderList.add("Marital Status");
			tableHeaderList.add("Location Preferece");
			tableHeaderList.add("Family Details");
			tableHeaderList.add("Current Reporting Structure");
			tableHeaderList.add("Reasons for leaving present job");
			tableHeaderList.add("HR Ratings");
			tableHeaderList.add("Overall Assessment & Remarks");
			tableHeaderList.add("Recommended");
			tableHeaderList.add("Director Approval");
			title = "Hr View History";
			tableValueList = resumeHandlerService.getHRHistory(resumeId);
			historyMap.put("objectType", "hr");
		} else {
			tableHeaderList.add("Status");
			tableHeaderList.add("Designation");
			tableHeaderList.add("Current CTC");
			tableHeaderList.add("Currency");
			tableHeaderList.add("Expected CTC");
			tableHeaderList.add("Date Of Joining");
			tableHeaderList.add("Salary Remarks");
			tableHeaderList.add("Location Allocated");
			tableHeaderList.add("Project Assigned");
			tableHeaderList.add("Remarks");
			title = "Status View History";
			tableValueList = resumeHandlerService.getStatusHistory(resumeId);
			historyMap.put("objectType", "status");
		}

		tableHeaderList.add("");
		historyMap.put("tableHeaderList", tableHeaderList);
		historyMap.put("tableValueList", tableValueList);
		historyMap.put("statusMasterList", statusMasterList);
		String jsp = "hr_resumeHistory.jsp";
		historyMap.put("contentJsp", jsp);
		historyMap.put("title", title);
		historyMap.put("candidateName", candidateName);
		return new ModelAndView("index", "map", historyMap);
	}

	public ModelAndView getStateList(HttpServletRequest request,
			HttpServletResponse response) {

		String countryId = request.getParameter("countryId");
		List stateList = resumeHandlerService.getStateList(countryId);
		Map map = new HashMap();
		String message = "";
		if (stateList != null) {
			map.put("stateList", stateList);
		} else {
			message = "State List Not available";
			map.put("error", message);
		}
		String jsp = "hr_responseList";
		map.put("jsp", jsp);
		map.put("title", "");
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getCityList(HttpServletRequest request,
			HttpServletResponse response) {

		String countryId = request.getParameter("stateId");
		List districtList = resumeHandlerService.getDistrictList(countryId);
		Map map = new HashMap();
		String message = "";
		if (districtList != null) {
			map.put("districtList", districtList);
		} else {
			message = "City List Not available";
			map.put("error", message);
		}
		String jsp = "hr_responseList";
		map.put("jsp", jsp);
		map.put("title", "");
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showResume(HttpServletRequest request,
			HttpServletResponse response) {
		Object o = resumeHandlerService.getBinaryFile();
		Uploads uploads = (Uploads) o;
		byte[] bytes = uploads.getBinaryfile();
		response.setContentType("application/msword");
		response.setHeader("Content-Disposition", "inline");
		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showJoiningApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map map = new HashMap();
		String jsp = "hr_approveJoining";
		List resumeList = resumeHandlerService.getHrSelectedResumeList();
		List requestStatusMasterList = recruitmentHandlerService
				.getRequestStatusMasterList();
		jsp = jsp + ".jsp";
		map.put("resumeList", resumeList);
		map.put("requestStatusMasterList", requestStatusMasterList);
		map.put("contentJsp", jsp);
		map.put("preview", request.getAttribute("preview"));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateResumeStatus(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (session.getAttribute("map") != null) {
			map = (HashMap<String, Object>) session.getAttribute("map");
		}
		String resumeStatus = request.getParameter("resumetStatus");
		String hrRemarks = request.getParameter("hrRemarks");
		Integer resumeStatusId = new Integer(resumeStatus);
		// RequestStatusMaster requestStatusMaster =
		// recruitmentHandlerService.getRequestStatusMasterById(requestStatusId);
		List<Resumepersonaldetails> resumeList = (List<Resumepersonaldetails>) map
				.get("resumeList");
		List<Resumepersonaldetails> resumeListToBeUpdated = new ArrayList<Resumepersonaldetails>();
		for (int i = 0; i <= resumeList.size(); i++) {
			String checkedIds = request.getParameter("id" + i);
			if (checkedIds != null) {
				resumeListToBeUpdated.add(resumeList.get(i));
			}
		}

		for (Resumepersonaldetails resumepersonaldetails : resumeListToBeUpdated) {
			Resumestatus resumeStatus2 = resumepersonaldetails
					.getResumeStatus();
			resumeStatus2.setStatusId(resumeStatusId);
			resumeStatus2.setHrRemarks(hrRemarks);
			resumeHandlerService.updateResumeStatus(resumeStatus2);
			if (resumeStatusId == 18) {
				ResourceRequisition resourceRequisition = resumepersonaldetails
						.getResourceRequisition();
				Integer noOfPositionsOccupied = resourceRequisition
						.getNoOfPositionOccupied();

				if (noOfPositionsOccupied != null) {
					resourceRequisition
							.setNoOfPositionOccupied(++noOfPositionsOccupied);
				}
				recruitmentHandlerService
						.saveResourceRequisitionDetail(resourceRequisition);
			}
		}

		String message = "Status of following resumes has been processed";
		String url = "/hms/hrms/resume?method=showJoiningApprovalJsp";
		/*
		 * if(updatedList!=null && updatedList.size()!=0){ //String
		 * updatedStatus = ((ResourceRequisition)updatedList.get(0)).atusDesc();
		 * 
		 * if(requestStatusMaster.getId() == 3) { message = "Selected Requests
		 * for man power has been put " + requestStatusMaster.getStatusDesc(); }
		 * else { message = "Selected Requests for man power has been " +
		 * requestStatusMaster.getStatusDesc(); } }
		 */

		map.put("messageTOBeVisibleToTheUser", message);
		map.put("resumeListToBeUpdated", resumeListToBeUpdated);
		map.put("url", url);
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAssignPayElements(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}

		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}

		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);
		String jsp = RequestConstants.HR_RESUME_PAY_ELEMENTS;
		jsp += ".jsp";
		Map map = resumeHandlerService.showResumePayElementsJsp(resume);
		map.put("resume", resume);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView assignPayElements(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		MasHospital company = null;
		List resumePayELementsList = new ArrayList();
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			int companyId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
			company = new MasHospital();
			company.setId(companyId);
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}

		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);

		Map map = resumeHandlerService.showResumePayElementsJsp(resume);
		List<HrMasPayElement> payELementsList = new ArrayList();
		if (map.get("payElementsList") != null) {
			payELementsList = (List) map.get("payElementsList");
		}

		List<HrMasPayElement> payElementListToBeAssigned = new ArrayList<HrMasPayElement>();
		if (session.getAttribute("searchResumePayElementsList") != null) {

			List<HrResumePayElements> resumePayElementsList = (List) session
					.getAttribute("searchResumePayElementsList");
			for (HrResumePayElements resumePayElements : resumePayElementsList) {
				payElementListToBeAssigned.add(resumePayElements
						.getPayElement());
			}

		}
		/*
		 * else if(session.getAttribute("offerDetailsUpdated")!=null &&
		 * (Boolean)session.getAttribute("offerDetailsUpdated")) {
		 * payElementListToBeAssigned = null;
		 * session.removeAttribute("offerDetailsUpdated"); }
		 */
		else {
			for (int i = 0; i <= payELementsList.size(); i++) {
				String checkedIds = request.getParameter("id" + i);
				if (checkedIds != null) {
					payElementListToBeAssigned.add(payELementsList.get(i));
				}
			}
		}

		if (payElementListToBeAssigned != null) {
			for (HrMasPayElement payElement : payElementListToBeAssigned) {
				HrResumePayElements resumePayElement = new HrResumePayElements();
				resumePayElement.setResume(resume);
				resumePayElement.setPayElement(payElement);

				BigDecimal payAmount = new BigDecimal(0);

				if (payElement.getBasicDependent().equals("y")) {
					Double basic = new Integer(resume.getResumeStatus()
							.getCtc()) * .35;
					payAmount = new BigDecimal(
							(basic * payElement.getBasicMultiplier()) / 100);

					if (payElement.getMaxAmount() != null
							&& payAmount.compareTo(payElement.getMaxAmount()) == 1) {
						payAmount = payElement.getMaxAmount().multiply(
								new BigDecimal(12));
					}
				}
				resumePayElement.setPayAmount(payAmount);

				resumePayElement.setStatus("y");
				resumePayElement.setStartDate(new Date());
				resumePayElement.setCompany(company);
				resumePayElement.setLastChgBy(users.getEmployee()
						.getFirstName()
						+ " "
						+ users.getEmployee().getLastName());
				resumePayELementsList.add(resumePayElement);
			}
		}
		/*
		 * else { List<HrResumePayElements> resumePayElementsList2 = new
		 * ArrayList(resume.getResumePayElements()); Integer ctc = 0;
		 * if(request.getParameter(RequestConstants.CTC)!=null &&
		 * !request.getParameter(RequestConstants.CTC).equals("")) ctc = new
		 * Integer(request.getParameter(RequestConstants.CTC));
		 * for(HrResumePayElements resumePayElements1 : resumePayElementsList2)
		 * { Double payAmount = 0.0;
		 * 
		 * Double basic = ctc * .35;
		 * if(resumePayElements1.getPayElement().getBasicMultiplier()!=null)
		 * payAmount = (basic *
		 * resumePayElements1.getPayElement().getBasicMultiplier())/100;
		 * resumePayElements1.setPayAmount(payAmount.floatValue()); }
		 * resumePayELementsList = resumePayElementsList2; }
		 */

		if (resumePayELementsList != null && resumePayELementsList.size() > 0) {
			resumeHandlerService
					.addResumePayELementsList(resumePayELementsList);
		}
		map = resumeHandlerService.showResumePayElementsJsp(resume);
		String jsp = RequestConstants.HR_CTC_ANEXURE;
		String message = "";
		if (session.getAttribute("searchResumePayElementsList") != null) {
			message = "CTC has been updated and all Pay Elements have been adjusted accordingly";
		} else {
			message = "Pay Elements has been assigned successfully";
		}
		jsp += ".jsp";
		map.put("message", message);
		map.put("resume", resume);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCTCAnnexureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}

		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}

		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);
		String jsp = RequestConstants.HR_CTC_ANEXURE;
		jsp += ".jsp";
		Map map = resumeHandlerService.showResumePayElementsJsp(resume);
		map.put("resume", resume);
		map.put("contentJsp", jsp);
		map.put("preview", request.getAttribute("preview"));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateCTC(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}

		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}
		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);

		Float updatedCTC = null;
		Integer CTC = 0;
		if (request.getParameter(RequestConstants.CTC) != null) {
			updatedCTC = new Float(request.getParameter(RequestConstants.CTC));
			CTC = updatedCTC.intValue();

		}

		Resumestatus resumeStatus = resume.getResumeStatus();
		resumeStatus.setCtc(CTC.toString());
		resumeHandlerService.updateResumeStatus(resumeStatus);
		resume.setResumeStatus(resumeStatus);

		return assignPayElements(request, response);
		/*
		 * String message = "CTC updated sucessfully";
		 * 
		 * 
		 * String jsp = RequestConstants.HR_CTC_ANEXURE; jsp += ".jsp"; Map map
		 * = resumeHandlerService.showResumePayElementsJsp(resume);
		 * map.put("resume", resume); map.put("contentJsp", jsp);
		 * map.put("message", message); return new
		 * ModelAndView("index","map",map);
		 */
	}

	public ModelAndView addOrUpdateResumePayElement(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		MasHospital company = new MasHospital();
		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			int companyId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
			company = new MasHospital();
			company.setId(companyId);
		}
		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}
		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);

		Integer commonId = 0;
		Integer payElementId = 0;
		BigDecimal payAmount = new BigDecimal(0);
		Date startDate = new Date();
		if (request.getParameter(RequestConstants.COMMON_ID) != null
				&& !request.getParameter(RequestConstants.COMMON_ID).equals("")) {
			commonId = new Integer(
					request.getParameter(RequestConstants.COMMON_ID));
		}
		if (request.getParameter(RequestConstants.PAY_ELEMENT_CODE) != null) {
			payElementId = new Integer(
					request.getParameter(RequestConstants.PAY_ELEMENT_CODE));
		}
		if (request.getParameter(RequestConstants.PAY_AMOUNT) != null
				&& !request.getParameter(RequestConstants.PAY_AMOUNT)
						.equals("")) {
			payAmount = new BigDecimal(
					request.getParameter(RequestConstants.PAY_AMOUNT));
		}
		if (request.getParameter(RequestConstants.PAY_ELEMENT_START_DATE) != null) {
			startDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(RequestConstants.PAY_ELEMENT_START_DATE));
		}

		HrResumePayElements resumePayElements = null;
		if (commonId.equals(0)) {
			resumePayElements = new HrResumePayElements();

		} else {
			resumePayElements = (HrResumePayElements) resumeHandlerService
					.loadObject(HrResumePayElements.class, commonId);
		}

		if (!payElementId.equals(0)) {
			HrMasPayElement payElement = new HrMasPayElement();
			payElement.setId(payElementId);
			resumePayElements.setPayElement(payElement);
		}
		resumePayElements.setPayAmount(payAmount);
		resumePayElements.setResume(resume);
		resumePayElements.setStartDate(startDate);
		resumePayElements.setCompany(company);
		resumePayElements.setStatus("y");
		resumePayElements.setLastChgBy(users.getLoginName());
		resumePayElements.setLastChgDate(new Date());
		String message = "";
		try {
			resumeHandlerService.addOrUpdate(resumePayElements);
			if (commonId.equals(0)) {
				message = "Pay element added successfully";
			} else {
				message = "Pay element updated successfully";
			}

		} catch (Exception e) {
			message = "Problem adding pay element";
			e.printStackTrace();
		}

		String jsp = RequestConstants.HR_CTC_ANEXURE;
		jsp += ".jsp";
		Map map = resumeHandlerService.showResumePayElementsJsp(resume);
		map.put("resume", resume);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public void previewCTCAnnexure(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;

		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		MasHospital company = new MasHospital();
		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			int companyId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
			company = new MasHospital();
			company.setId(companyId);
		}
		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}
		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);

		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		String output = "";
		Map mapForInterApprover = (Map) recruitmentHandlerService.loadObject(
				MasEmployee.class, 1);
		MasRank intermediateApproverDesg = (MasRank) mapForInterApprover
				.get("intermediateApproverDesignation");
		Set employeeSet = EmployeeComparator.getEmployeeTreeSet();
		employeeSet.addAll(intermediateApproverDesg.getMasEmployees());
		List empList = new ArrayList(employeeSet);
		MasEmployee interMediateApprover = null;
		String nameOfapprover = "";
		if (empList.size() > 0) {
			interMediateApprover = (MasEmployee) empList.get(0);
			nameOfapprover = interMediateApprover.getFirstName() + " "
					+ interMediateApprover.getLastName();
		}
		Integer resumeIdInt = new Integer(resumeId) * 17;
		String uniqueId = "C" + resumeIdInt.toString()
				+ resume.getFirstName().substring(0, 1)
				+ resume.getLastName().substring(0, 1)
				+ new Float((Math.random() * 13)).intValue();
		try {
			// int resumeId = resume.getId

			parameters.put("resumeId", resumeId);
			parameters.put("uniqueId", uniqueId);
			parameters.put("nameOfapprover", nameOfapprover);
			Connection connection = (Connection) resumeHandlerService
					.getDBConnection();

			// byte bytes[] = null;

			try {

				HMSUtil.generateReport("ctcAnnexure", parameters, connection,
						response, context);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {

		}

	}

	public ModelAndView previewCTCAnnexureHrHead(HttpServletRequest request,
			HttpServletResponse response) {
		previewCTCAnnexure(request, response);
		request.setAttribute("preview", true);
		return showJoiningApprovalJsp(request, response);

	}

	public ModelAndView previewCTCAnnexureHr(HttpServletRequest request,
			HttpServletResponse response) {
		previewCTCAnnexure(request, response);
		request.setAttribute("preview", true);
		return showCTCAnnexureJsp(request, response);

	}

	public ModelAndView sendForApproval(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null
				|| session.getAttribute(RequestConstants.USERS) == null) {
			return new ModelAndView("index");
		}
		if (session != null
				&& session.getAttribute(RequestConstants.USERS) != null) {
			users = (Users) session.getAttribute(RequestConstants.USERS);
		}
		MasHospital company = new MasHospital();
		if (session != null
				&& session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			int companyId = (Integer) session
					.getAttribute(RequestConstants.HOSPITAL_ID);
			company = new MasHospital();
			company.setId(companyId);
		}
		Integer resumeId = 0;
		if (request.getParameter(RequestConstants.RESUMEID) != null) {
			resumeId = new Integer(
					request.getParameter(RequestConstants.RESUMEID));
		}
		List resumeList = (List) resumeHandlerService
				.getResumePersonalDetailsById(resumeId);
		Resumepersonaldetails resume = (Resumepersonaldetails) resumeList
				.get(0);

		Resumestatus resumestatus = resume.getResumeStatus();
		resumestatus.setStatusId(20);
		resumeHandlerService.updateResumeStatus(resumestatus);

		/*
		 * RequestDispatcher dispatcher =request.getRequestDispatcher(
		 * "/hms/hrms/resume?method=viewResume&resumeID"+ resume.getId()); try {
		 * dispatcher.forward( request, response ); } catch (ServletException e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		request.setAttribute("resumeID", resume.getId());
		return viewResume(request, response);

	}

public ModelAndView showShortListEmpForPromo(HttpServletRequest request,HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		Map<String, Object> map2= new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index");
		}
		Map map = new HashMap();
		String jsp = "hr_shortlistPromoEmp.jsp";
		String flag="";
		String id="";
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
		}
		if(request.getParameter("id") != null){
			id = request.getParameter("id");
		}
		List manPowerRequisitionList = recruitmentHandlerService.getAllApprovedRequests();
		
		//List rmsIdList = resumeHandlerService.getRecruitersList("1");
		if(flag != null && ! flag.equals("") && flag.equals("s")){
			System.out.println("map2"+id);
			map2 = resumeHandlerService.getEmployeeForPromo(id);
		map.put("map2",map2);
		}
		map.put("manPowerRequisitionList",manPowerRequisitionList);
		//map.put("rmsIdList",rmsIdList);
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}


public ModelAndView saveEmpPromo(HttpServletRequest request, HttpServletResponse response)throws IOException{
	HttpSession session = request.getSession(false);
	if (session == null) {
		return new ModelAndView("index");
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	Users user = (Users)session.getAttribute("users");
	
	
	
	// internally generate requisition for promo
	
	Map<String, Object> detailMap = new HashMap<String, Object>();
	int hospitalId =0;
	if (session.getAttribute("hospitalId")!= null) {
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	
	ResourceRequisition resourceRequisition = new ResourceRequisition();

	String name ="";
	int empId =0
			;
	String loginId="";
	if(session.getAttribute("users") != null){
		user = (Users)session.getAttribute("users");
		name = user.getEmployee().getFirstName();
		empId = user.getEmployee().getId();
		loginId = user.getEmployee().getEmail();
	}
	
	
	int reqAddByEmpId = 0;
	//if (request.getParameter(EMPLOYEE_ID)!= null) {
		//reqAddByEmpId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		MasEmployee  masEmployee = new MasEmployee();
		masEmployee.setId(empId);
		
	//}

	
	if (request.getParameter("changedDate") != null && !(request.getParameter("changedDate").equals(""))) {
		Date requisitionDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("changedDate"));
	}
	
	int count=0;
	if (request.getParameter("counter") != null && !(request.getParameter("counter").equals(""))) {
		count = Integer.parseInt(""+request.getParameter("counter"));
	}
/*
	if (request.getParameter(EMPLOYEE_TYPE)!=null && !request.getParameter(EMPLOYEE_TYPE).equals("0")) {
		int employeeTypeId = Integer.parseInt(request.getParameter(EMPLOYEE_TYPE));
		MasEmployeeType masEmployeeType=new MasEmployeeType();
		masEmployeeType.setId(employeeTypeId);
	}*/
	List departList = new ArrayList();
	List desigList = new ArrayList();
	List noOfpositionList = new ArrayList();
	List directReqList = new ArrayList();
	List promReqList = new ArrayList();
	List approveList = new ArrayList();
	List availList = new ArrayList();
	List promList = new ArrayList();
	List directList = new ArrayList();
	Integer  totalNoPosition = 0;
	
	int val=0;
	for(int i=0; i<count;i++){
		/*if ((request.getParameter("directReq"+i) != null && !(request.getParameter("directReq"+i).equals(""))) || 
				(request.getParameter("promReq"+i) != null && !(request.getParameter("promReq"+i).equals("")))){*/

		
			if (request.getParameter("rb"+i)!=null && !request.getParameter("rb"+i).equals("")) {
				val++;
			
			
	
		if (request.getParameter("dept"+i)!=null && !request.getParameter("dept"+i).equals("0")) {
		int departmentId = Integer.parseInt(request.getParameter("dept"+i));
		departList.add(departmentId);
	}
	
	/*if (request.getParameter(LOCATION_ID)!=null && !request.getParameter(LOCATION_ID).equals("0")) {
		int locationId = Integer.parseInt(request.getParameter(LOCATION_ID));
		MasLocation masLocation = new MasLocation();
		masLocation.setId(locationId);
	}*/
	
	if (request.getParameter("desig"+i) != null && !(request.getParameter("desig"+i).equals(""))) {		
		String proposedDesignation = request.getParameter("desig"+i);
		desigList.add(proposedDesignation);
	}
	
	if (request.getParameter("vacant"+i) != null && !(request.getParameter("vacant"+i).equals(""))){
		 totalNoPosition = Integer.parseInt(request.getParameter("vacant"+i));
		noOfpositionList.add(totalNoPosition);
		
	}
	if (request.getParameter("approve"+i) != null && !(request.getParameter("approve"+i).equals(""))){
		approveList.add(Integer.parseInt(request.getParameter("approve"+i)));	
	}
	if (request.getParameter("avail"+i) != null && !(request.getParameter("avail"+i).equals(""))){
		availList.add(Integer.parseInt(request.getParameter("avail"+i)));	
	}
	/*if (request.getParameter("prom"+i) != null && !(request.getParameter("prom"+i).equals(""))){
		promList.add(Integer.parseInt(request.getParameter("prom"+i)));	
	}*/
	/*if (request.getParameter("direct"+i) != null && !(request.getParameter("direct"+i).equals(""))){
		directList.add(Integer.parseInt(request.getParameter("direct"+i)));	
	}*/
	/*if (request.getParameter("directReq"+i) != null && !(request.getParameter("directReq"+i).equals(""))){
		 directReqList.add(Integer.parseInt(request.getParameter("directReq"+i)));	
	}else{*/
		 directReqList.add(0);
	/*}*/
	if (request.getParameter("promReq"+i) != null && !(request.getParameter("promReq"+i).equals(""))){
		promReqList.add(Integer.parseInt(request.getParameter("promReq"+i)));	
	}else{
		promReqList.add(1); // hard code
	}
			}
//}
}
	
	Integer approvingManagerId = 0;
	
	
	String lastchangeBy = "";
	if (request.getParameter("changedBy")!= null) {
		lastchangeBy = request.getParameter("changedBy");
	}
	//Date changedDate = null;
	String changedDate = null;
	if(request.getParameter("changedDate") != null && !(request.getParameter("changedDate").equals(""))){
		//changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));
		changedDate =request.getParameter("changedDate");
	}
	String	changedTime = "";
	if(request.getParameter("changedTime") != null && !(request.getParameter("changedTime").equals(""))){
		changedTime = request.getParameter("changedTime");
	}

	
	detailMap.put("departList", departList);
	detailMap.put("desigList", desigList);
	detailMap.put("noOfpositionList", noOfpositionList);
	detailMap.put("directReqList", directReqList);
	detailMap.put("promReqList", promReqList);
	detailMap.put("approveList", approveList);
	detailMap.put("availList", availList);
	detailMap.put("promList", promList);
	detailMap.put("directList", directList);
	detailMap.put("lastchangeBy", lastchangeBy);
	detailMap.put("changedDate", changedDate);
	detailMap.put("changedTime", changedTime);
	detailMap.put("hospitalId", hospitalId);
	detailMap.put("val", val);
	detailMap.put("empId", empId);
	detailMap.put("user", user);
   // System.out.println("val>>>> "+val);
    
	//map = recruitmentHandlerService.saveResourceRequisitionDetail(resourceRequisition);
	map = resumeHandlerService.saveResourceRequisitionDetail(detailMap);
	
	//-------setting status -------//

	HrResourceRequisitionStatus hrResourceRequisitionStatus = new HrResourceRequisitionStatus();
	
	RequestStatusMaster requestStatusMaster = new RequestStatusMaster();
	
	
	hrResourceRequisitionStatus.setCurrentLevel(0);
	requestStatusMaster.setId(2);  // for set approve
	
	hrResourceRequisitionStatus.setMasEmployee(user.getEmployee());
	
	hrResourceRequisitionStatus.setRequestStatusMaster(requestStatusMaster);
	
	hrResourceRequisitionStatus.setResourceRequisition(resourceRequisition);
	hrResourceRequisitionStatus.setActionDate(HMSUtil.getCurrentDateAndTimeObject());

	
	/*HrRequisitionHistory requisitionHistory = new HrRequisitionHistory();
	requisitionHistory.setRequisition(resourceRequisition);
	requisitionHistory.setEmployee(user.getEmployee());
	
	
	requisitionHistory.setStatus(requestStatusMaster);
	
	requisitionHistory.setActionDate(HMSUtil.getCurrentDateAndTimeObject());
	requisitionHistory.setTotalNoPosition(totalNoPosition);

	Map parameterMap = new HashMap();

	parameterMap.put("hospitalId",hospitalId);
	Map requisitionListMap = recruitmentHandlerService.searchResourceRequests(parameterMap);
	List resourceRequisitionList = new ArrayList();
	if(requisitionListMap!=null)
	{
		resourceRequisitionList = (List)requisitionListMap.get("resourceRequisitionList");
	}*/
	
	
	
	//end code for internally generate requisition for promo
	
	

	/*Integer assignedTo = Integer.parseInt(request.getParameter("assignedTo"));*/
	List<Resumepersonaldetails> resumeListToBeShortListed = null;

	/*String requestId = request.getParameter("requestId");*/
	int requestIdInt = 0;
	if(request.getParameter("requestId") != null){
	 requestIdInt = Integer.parseInt(""+request.getParameter("requestId"));
	}
	List tempList = new ArrayList();
	List rankList = new ArrayList();
	/*if(resumeListToBeShortListed == null){
		tempList = getCheckedResumeList(request);
	}else{
		 tempList = resumeListToBeShortListed;
	}*/
	
	int counter = Integer.parseInt(""+request.getParameter("empcount"));

	for(int i=0;i<counter;i++)
	{
		String checkedIds=request.getParameter("id"+i);
		if(checkedIds!=null)
		{
			tempList.add(checkedIds);
			rankList.add(request.getParameter("rankId"+i));
		}
	}
	
	Map<String, Object> authorizationMap = new HashMap<String,Object>();

	authorizationMap.put("tempList",tempList);
	/*authorizationMap.put("assignedTo",assignedTo);*/
	authorizationMap.put("requestId",requestIdInt);
	authorizationMap.put("rankList",rankList);
	authorizationMap.put("userId",user.getId());
	
	ResourceRequisition resourceRequisition1 =(ResourceRequisition) map.get("resourceRequisition");
	authorizationMap.put("resourceRequisition",resourceRequisition1);
	//String name = "";
	String newOwnerEmailId = "";
	int arraySize = tempList.size();
	String fullName = "";
	String location = "";
	String exp = "";
	String company = "";
	String currentCtc = "";
	String expectedCtc = "";

	//Map updateAuthorizationMap = resumeHandlerService.updateAuthorizationTo(authorizationMap);
	Map updateAuthorizationMap = resumeHandlerService.saveEmpPromo(authorizationMap);
	if(updateAuthorizationMap.get("name") != null){
		name = (String)updateAuthorizationMap.get("name");
	}
	if(updateAuthorizationMap.get("emailId") != null){
		newOwnerEmailId = (String)updateAuthorizationMap.get("emailId");
	}

	String emailId = "";
	String candidateName = "";
	String candidateNameWithEmailId = "";
	String oldOwnerName = "";
	String oldOwnerMailId = "";
	String emailMessage = "";
	String emailMessage1 = "";
	String emailMessage2 = "";
	
		String message[]={"Selected Candidates has been Promotede successfully.<div class='clear'></div>",	
			//"javascript:history.back()",
				"/hms/hrms/recruitment?method=showResourceReqJsp",
			"/hms/hms/login?method=validate"
			};
	
	map.put("message",message);
	
	map.put("tempList",tempList);
	map.put("contentJsp","hr_message.jsp");
	
	return new ModelAndView("index","map",map);
}

	
	public ModelAndView showshortListEmpForHrApproval(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		Map<String, Object> map= new HashMap<String, Object>();
		Map<String, Object> detailMap= new HashMap<String, Object>();
		//int promoId=0;
		int deptId=0;
		int empId=0;
		Date fromDate = null;
		Date toDate = null;
		
		System.out.println("from Date=="+request.getParameter("fromDate"));
		if (request.getParameter("fromDate") != null && !(request.getParameter("fromDate").equals(""))) {
			 fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromDate"));
			detailMap.put("fromDate", fromDate);	
		}
		if (request.getParameter("toDate") != null && !(request.getParameter("toDate").equals(""))) {
			 toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toDate"));
			detailMap.put("toDate", toDate);	
		}
		/*if (request.getParameter("promoId") != null && !(request.getParameter("promoId").equals(""))) {
			promoId = Integer.parseInt((request.getParameter("promoId")));
			detailMap.put("promoId", promoId);	
		}*/
		System.out.println("deptId=="+request.getParameter("deptId"));
		if (request.getParameter("deptId") != null && !(request.getParameter("deptId").equals("0"))) {
			deptId = Integer.parseInt((request.getParameter("deptId")));
			detailMap.put("deptId", deptId);	
		}
		if (request.getParameter("empId") != null && !(request.getParameter("empId").equals("0"))) {
			empId = Integer.parseInt((request.getParameter("empId")));
			detailMap.put("empId", empId);	
		}
		
		
		
		String flag="";
		String id="";
		if(request.getParameter("flag") != null){
			flag = request.getParameter("flag");
		}
		if(request.getParameter("id") != null){
			id = request.getParameter("id");
		}
		detailMap.put("flag", flag);	
		/*List manPowerRequisitionList = recruitmentHandlerService.getAllApprovedRequests();
		
		List rmsIdList = resumeHandlerService.getRecruitersList("1");*/
		
		
		map = resumeHandlerService.getEmployeeForHrApprovePromo(detailMap);
		String jsp = "hr_shortlistPromoEmpForHr.jsp";
		map.put("flag",flag);
		map.put("contentJsp", jsp);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("deptId", deptId);
		map.put("empId", empId);
		return new ModelAndView("index","map",map);
	}

	public ModelAndView updateEmpPromoStatus(HttpServletRequest request,HttpServletResponse response ){
		
		HttpSession session = request.getSession();
		Users users = null;
		if (session == null	) {
			return new ModelAndView("index");
		}
		if (session != null	&& session.getAttribute("users") != null) {
			users = (Users)session.getAttribute("users");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String,Object> detailMap = new HashMap<String,Object>();
		
		String requestStatus = request.getParameter("requestStatus");
		String remraks = request.getParameter("remraks");
		String flag = request.getParameter("flag");
		//RequestStatusMaster requestStatusMaster = recruitmentHandlerService.getRequestStatusMasterById(requestStatusId);

		
		//List<ResourceRequisition> requisitionListToBeUpdated = new ArrayList<ResourceRequisition>();
		List tempList = new ArrayList();
		List reqList = new ArrayList();
		List reqfrPromotionIdList = new ArrayList();
		int counter = Integer.parseInt(""+request.getParameter("counter"));

		for(int i=0;i<counter;i++)
		{
			String reqfrPromotionIds ="";
			String checkedIds=request.getParameter("id"+i);
			if(request.getParameter("req_fr_promotion_id"+i) != null){
				reqfrPromotionIds = request.getParameter("req_fr_promotion_id"+i);
			}
			System.out.println("reqfrPromotionIds=="+reqfrPromotionIds);
			if(checkedIds!=null)
			{
				tempList.add(checkedIds);
				reqfrPromotionIdList.add(reqfrPromotionIds);
				/*reqList.add(""+request.getParameter("req_id"+i));*/
				
			}
		}
		System.out.println("reqfrPromotionIdList=con===="+reqfrPromotionIdList.size());
		detailMap.put("tempList", tempList);
		detailMap.put("remraks", remraks);
		detailMap.put("requestStatus", requestStatus);
		detailMap.put("reqList", reqList);
		detailMap.put("reqfrPromotionIdList", reqfrPromotionIdList);
		detailMap.put("userId",users.getId());
		detailMap.put("flag",flag);

		Map updatemap = resumeHandlerService.updateEmpPromoStatus(detailMap);
		String message = "";
		String url = "/erp/erp/resume?method=showshortListEmpForHrApproval&flag="+flag;
		if(updatemap.get("update")!=null){
			//String updatedStatus = ((ResourceRequisition)updatedList.get(0)).atusDesc();
			System.out.println(updatemap.get("update"));
			boolean update = (Boolean)updatemap.get("update");
			if(update)
			{
				message = "Data has been  successfully save.<div class='clear'></div>" ;
			}
			else
			{	
				message = "Data not successfully save";
			}
		}
		
		map.put("messageTOBeVisibleToTheUser",message);
		map.put("url", url);
		map.put("contentJsp", "message.jsp");
		return new ModelAndView("index","map",map);
	}


	
}
