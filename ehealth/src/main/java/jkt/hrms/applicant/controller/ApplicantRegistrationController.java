package jkt.hrms.applicant.controller;

import static jkt.hrms.util.HrmsRequestConstants.ADDRESS;
import static jkt.hrms.util.HrmsRequestConstants.APPLICANT_EDUCATION_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPLICANT_EXPERIENCE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPLICANT_PERSONAL_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPLICANT_REGISTRATION_JSP;
import static jkt.hrms.util.HrmsRequestConstants.APPLICANT_SUCCESS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.AWARDS;
import static jkt.hrms.util.HrmsRequestConstants.COUNTRY;
import static jkt.hrms.util.HrmsRequestConstants.COURSE;
import static jkt.hrms.util.HrmsRequestConstants.COURSE_DURATION;
import static jkt.hrms.util.HrmsRequestConstants.CURRENT_DESIGNATION;
import static jkt.hrms.util.HrmsRequestConstants.CURRENT_EMPLOYER;
import static jkt.hrms.util.HrmsRequestConstants.CUR_END_REASON;
import static jkt.hrms.util.HrmsRequestConstants.CUR_SER_END_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CUR_SER_START_DATE;
import static jkt.hrms.util.HrmsRequestConstants.DATE_OF_BIRTH;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.DISLIKES;
import static jkt.hrms.util.HrmsRequestConstants.DISTRICT;
import static jkt.hrms.util.HrmsRequestConstants.DRIVING_LICENCE_NO;
import static jkt.hrms.util.HrmsRequestConstants.DURATION_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.EDUCATION_TYPE;
import static jkt.hrms.util.HrmsRequestConstants.EMAIL_ID;
import static jkt.hrms.util.HrmsRequestConstants.END_DATE;
import static jkt.hrms.util.HrmsRequestConstants.FATHER_NAME;
import static jkt.hrms.util.HrmsRequestConstants.FIRST_NAME;
import static jkt.hrms.util.HrmsRequestConstants.GENDER;
import static jkt.hrms.util.HrmsRequestConstants.GENERAL_INTEREST;
import static jkt.hrms.util.HrmsRequestConstants.HEIGHT;
import static jkt.hrms.util.HrmsRequestConstants.INSTITUTE_LIST;
import static jkt.hrms.util.HrmsRequestConstants.JOB_ID;
import static jkt.hrms.util.HrmsRequestConstants.JOB_RESPONSIBILTY;
import static jkt.hrms.util.HrmsRequestConstants.LAST_NAME;
import static jkt.hrms.util.HrmsRequestConstants.LIKES;
import static jkt.hrms.util.HrmsRequestConstants.MARTIAL_STATUS;
import static jkt.hrms.util.HrmsRequestConstants.MIDDLE_NAME;
import static jkt.hrms.util.HrmsRequestConstants.MOBILE;
import static jkt.hrms.util.HrmsRequestConstants.MOTHER_NAME;
import static jkt.hrms.util.HrmsRequestConstants.NATIONALITY;
import static jkt.hrms.util.HrmsRequestConstants.NO_OF_CHILDREN;
import static jkt.hrms.util.HrmsRequestConstants.PAN_NO;
import static jkt.hrms.util.HrmsRequestConstants.PASSPORT_NO;
import static jkt.hrms.util.HrmsRequestConstants.PERCENTAGE;
import static jkt.hrms.util.HrmsRequestConstants.PHIC_NO;
import static jkt.hrms.util.HrmsRequestConstants.PLACE_OF_BIRTH;
import static jkt.hrms.util.HrmsRequestConstants.PREVIOUS_DESIGNATION;
import static jkt.hrms.util.HrmsRequestConstants.PREVIOUS_EMPLOYER;
import static jkt.hrms.util.HrmsRequestConstants.PRE_ADDRESS;
import static jkt.hrms.util.HrmsRequestConstants.PRE_COUNTRY;
import static jkt.hrms.util.HrmsRequestConstants.PRE_DISTRICT;
import static jkt.hrms.util.HrmsRequestConstants.PRE_END_REASON;
import static jkt.hrms.util.HrmsRequestConstants.PRE_SER_END_DATE;
import static jkt.hrms.util.HrmsRequestConstants.PRE_SER_START_DATE;
import static jkt.hrms.util.HrmsRequestConstants.PRE_STATE;
import static jkt.hrms.util.HrmsRequestConstants.QUALIFICATION_OBTAINED;
import static jkt.hrms.util.HrmsRequestConstants.QUALIFIED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.RELIGION;
import static jkt.hrms.util.HrmsRequestConstants.SKILLS;
import static jkt.hrms.util.HrmsRequestConstants.SPL_QUALIFICATION;
import static jkt.hrms.util.HrmsRequestConstants.SPOUSE_NAME;
import static jkt.hrms.util.HrmsRequestConstants.SSC_NO;
import static jkt.hrms.util.HrmsRequestConstants.START_DATE;
import static jkt.hrms.util.HrmsRequestConstants.STATE;
import static jkt.hrms.util.HrmsRequestConstants.STRENGHT;
import static jkt.hrms.util.HrmsRequestConstants.TELEPHONE_NO;
import static jkt.hrms.util.HrmsRequestConstants.TIN_NO;
import static jkt.hrms.util.HrmsRequestConstants.TITLE;
import static jkt.hrms.util.HrmsRequestConstants.TOTAL_EXPERIENCE;
import static jkt.hrms.util.HrmsRequestConstants.TRIBE;
import static jkt.hrms.util.HrmsRequestConstants.WEEKNESS;
import static jkt.hrms.util.HrmsRequestConstants.WEIGHT;
import static jkt.hrms.util.HrmsRequestConstants.ZIPCODE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.util.HMSUtil;
import jkt.hrms.applicant.handler.ApplicantRegistrationHandlerService;
import jkt.hrms.masters.business.ApplicantEducation;
import jkt.hrms.masters.business.ApplicantExperience;
import jkt.hrms.masters.business.ApplicantPersonal;
import jkt.hrms.masters.business.ApplicantRefrenceDetails;
import jkt.hrms.masters.business.MasApplicant;
import jkt.hrms.masters.business.MasCourse;
import jkt.hrms.masters.business.MasDurationType;
import jkt.hrms.masters.business.MasInstitute;
import jkt.hrms.masters.business.MasJob;
import jkt.hrms.masters.business.MasNationality;
import jkt.hrms.masters.business.MasQualification;
import jkt.hrms.masters.business.MasSplQualification;
import jkt.hrms.masters.business.MasTribe;
//commented for maven
/*import org.jboss.logging.Logger;*/
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class ApplicantRegistrationController extends MultiActionController {
	ApplicantRegistrationHandlerService applicantHandlerService;
	MasApplicant storedMasApplicant = null;
	ApplicantPersonal storedApplicantPersonal = null;
	List<ApplicantRefrenceDetails> storedApplicantRefrenceDetailsList = null;
	ApplicantRefrenceDetails storedApplicantRefrenceDetails = new ApplicantRefrenceDetails();
	ApplicantRefrenceDetails storedApplicantRefrenceDetails1 = new ApplicantRefrenceDetails();
	List<ApplicantEducation> applicantEducationList = new ArrayList<ApplicantEducation>();
	ApplicantExperience storedApplicantExperience = null;

	public void setApplicantHandlerService(
			ApplicantRegistrationHandlerService applicantHandlerService) {
		this.applicantHandlerService = applicantHandlerService;
	}

	Map<String, Boolean> flagStore = new HashMap<String, Boolean>();
	Map<String, Object> map = null;

	public ModelAndView showApplicantRegistrationJsp(
			HttpServletRequest request, HttpServletResponse response) {

		map = applicantHandlerService.showApplicantRegistrationJsp(request);
		String jsp = APPLICANT_REGISTRATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveMasterDetails(HttpServletRequest request,
			HttpServletResponse response) {
		if ((Integer) request.getSession().getAttribute("token") == (Integer
				.parseInt(request.getParameter("token")))) {
			MasApplicant masApplicant = new MasApplicant();

			Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

			masApplicant.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String) dateMap
							.get("currentDate")));

			masApplicant.setAppliedDate(HMSUtil
					.convertStringTypeDateToDateType((String) dateMap
							.get("currentDate")));
			masApplicant.setLastChgTime((String) dateMap.get("currentTime"));
			masApplicant.setLastChgBy("applicant");
			masApplicant.setStatus("e");
			masApplicant.setFirstName(request.getParameter(FIRST_NAME));

			if (!("").equalsIgnoreCase(request.getParameter(MIDDLE_NAME))) {
				masApplicant.setMiddleName(request.getParameter(MIDDLE_NAME));
			}
			if (!("").equalsIgnoreCase(request.getParameter(LAST_NAME))) {
				masApplicant.setLastName(request.getParameter(LAST_NAME));
			}
			if (!"".equalsIgnoreCase((request.getParameter("code")))) {
				masApplicant.setApplicantCode(request.getParameter("code"));
			}

			if (!request.getParameter(TITLE).equals("0")) {
				int titleId = Integer.parseInt(request.getParameter(TITLE));
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masApplicant.setTitle(masTitle);
			}
			if (!request.getParameter(JOB_ID).equals("0")) {
				int jobId = Integer.parseInt(request.getParameter(JOB_ID));
				MasJob masJob = new MasJob();
				masJob.setId(jobId);
				masApplicant.setJob(masJob);
			}
			if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
				int departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masApplicant.setDepartment(masDepartment);
			}
			if (!"".equalsIgnoreCase(request.getParameter(ADDRESS))) {
				masApplicant.setAddress(request.getParameter(ADDRESS));
			}
			if (!"0".equalsIgnoreCase(request.getParameter(DISTRICT))) {
				int districtId = Integer.parseInt(request
						.getParameter(DISTRICT));
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				masApplicant.setCity(masDistrict);
			}

			if (!"".equalsIgnoreCase(request.getParameter(ZIPCODE))) {
				masApplicant.setZipCode((request.getParameter(ZIPCODE)));
			}

			if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {

				int countryId = Integer.parseInt(request.getParameter(COUNTRY));
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				masApplicant.setCountry(masCountry);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(STATE))) {

				int stateId = Integer.valueOf(request.getParameter(STATE));
				MasState masState = new MasState();
				masState.setId(stateId);
				masApplicant.setState(masState);
			}

			if (!(("").equalsIgnoreCase(request.getParameter(TELEPHONE_NO)))) {
				masApplicant
						.setTelephoneNo((request.getParameter(TELEPHONE_NO)));
			}
			if (!("".equalsIgnoreCase(request.getParameter(MOBILE)))) {
				// int cell=Integer.parseInt(request.getParameter(MOBILE));

				masApplicant.setCellNo(request.getParameter(MOBILE));
			}
			if (!"".equalsIgnoreCase(request.getParameter(EMAIL_ID))) {
				masApplicant.setEmail(request.getParameter(EMAIL_ID));
			}

			ApplicantRefrenceDetails applicantRefrenceDetails = new ApplicantRefrenceDetails();
			applicantRefrenceDetails.setSrNo(1);
			if (!"".equalsIgnoreCase(request.getParameter("rName1"))) {
				applicantRefrenceDetails
						.setName(request.getParameter("rName1"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rAddress1"))) {
				applicantRefrenceDetails.setAddress(request
						.getParameter("rAddress1"));
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rDistrict1"))) {
				int districtId = Integer.parseInt(request
						.getParameter("rDistrict1"));
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				applicantRefrenceDetails.setCity(masDistrict);
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rState1"))) {
				int stateId = Integer.parseInt(request.getParameter("rState1"));
				MasState masState = new MasState();
				masState.setId(stateId);
				applicantRefrenceDetails.setState(masState);
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rCountry1"))) {
				int countryId = Integer.parseInt(request
						.getParameter("rCountry1"));
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				applicantRefrenceDetails.setCountry(masCountry);
			}
			if (!"".equalsIgnoreCase(request.getParameter("rZipCode1"))) {
				applicantRefrenceDetails.setZipCode((request
						.getParameter("rZipCode1")).trim());
			}
			if (!"".equalsIgnoreCase(request.getParameter("rPhoneNo1"))) {
				applicantRefrenceDetails.setPhoneNo((request
						.getParameter("rPhoneNo1")));
			}

			if (!"".equalsIgnoreCase(request.getParameter("rComments1"))) {
				applicantRefrenceDetails.setComments(request
						.getParameter("rComments1"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rDesignation1"))) {
				applicantRefrenceDetails.setDesignation(request
						.getParameter("rDesignation1"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rCompany1"))) {
				applicantRefrenceDetails.setCompanyName(request
						.getParameter("rCompany1"));
			}

			ApplicantRefrenceDetails applicantRefrenceDetails1 = new ApplicantRefrenceDetails();
			applicantRefrenceDetails1.setSrNo(2);
			if (!"".equalsIgnoreCase(request.getParameter("rName2"))) {
				applicantRefrenceDetails1.setName(request
						.getParameter("rName2"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rAddress2"))) {
				applicantRefrenceDetails1.setAddress(request
						.getParameter("rAddress2"));
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rDistrict2"))) {
				int districtId = Integer.parseInt(request
						.getParameter("rDistrict2"));
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				applicantRefrenceDetails1.setCity(masDistrict);
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rState2"))) {
				int stateId = Integer.parseInt(request.getParameter("rState2"));
				MasState masState = new MasState();
				masState.setId(stateId);
				applicantRefrenceDetails1.setState(masState);
			}
			if (!"0".equalsIgnoreCase(request.getParameter("rCountry2"))) {
				int countryId = Integer.parseInt(request
						.getParameter("rCountry2"));
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				applicantRefrenceDetails1.setCountry(masCountry);
			}
			if (!"".equalsIgnoreCase(request.getParameter("rZipCode2"))) {
				applicantRefrenceDetails1.setZipCode(((request
						.getParameter("rZipCode2").trim())));
			}

			if (!"".equalsIgnoreCase(request.getParameter("rPhoneNo2"))) {
				applicantRefrenceDetails1.setPhoneNo(((request
						.getParameter("rPhoneNo2").trim())));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rComments2"))) {
				applicantRefrenceDetails1.setComments(request
						.getParameter("rComments2"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rDesignation2"))) {
				applicantRefrenceDetails1.setDesignation(request
						.getParameter("rDesignation2"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("rCompany2"))) {
				applicantRefrenceDetails1.setCompanyName(request
						.getParameter("rCompany2"));
			}
			Map<String, Object> dataContentMap = new HashMap<String, Object>();

			dataContentMap.put("masApplicant", masApplicant);
			dataContentMap.put("applicantRefrenceDetails",
					applicantRefrenceDetails);
			dataContentMap.put("applicantRefrenceDetails1",
					applicantRefrenceDetails1);
			//commented for maven
			/*Logger logger = Logger
					.getLogger(ApplicantRegistrationController.class);*/

			try {
				List<String> flag = applicantHandlerService
						.saveMasterDetails(dataContentMap);

				map = new HashMap<String, Object>();

				String contentJsp = "";
				if (!flag.contains("false")) {
					request.getSession().setAttribute(
							"token",
							(Integer) request.getSession()
									.getAttribute("token") + 1);
					map = applicantHandlerService
							.showApplicantRegistrationJsp(request);

					contentJsp = APPLICANT_PERSONAL_JSP;

					contentJsp += ".jsp";
					map.put("contentJsp", contentJsp);

				} else {

					contentJsp = APPLICANT_REGISTRATION_JSP;
					contentJsp += ".jsp";
					map.put("contentJsp", contentJsp);
					map.put("error", "errors occured while saving Data");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView updateMasterDetails(HttpServletRequest request,
			HttpServletResponse response) {

		storedMasApplicant = applicantHandlerService.getMasterDetails(Integer
				.parseInt(request.getParameter("applicantId")));

		Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

		storedMasApplicant.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType((String) dateMap
						.get("currentDate")));

		storedMasApplicant.setAppliedDate(HMSUtil
				.convertStringTypeDateToDateType((String) dateMap
						.get("currentDate")));
		storedMasApplicant.setLastChgTime((String) dateMap.get("currentTime"));
		storedMasApplicant.setLastChgBy("applicant");
		storedMasApplicant.setFirstName(request.getParameter(FIRST_NAME));

		if (!("").equalsIgnoreCase(request.getParameter(MIDDLE_NAME))) {
			storedMasApplicant.setMiddleName(request.getParameter(MIDDLE_NAME));
		}
		if (!("").equalsIgnoreCase(request.getParameter(LAST_NAME))) {
			storedMasApplicant.setLastName(request.getParameter(LAST_NAME));
		}
		if (!"".equalsIgnoreCase((request.getParameter("code")))) {
			storedMasApplicant.setApplicantCode(request.getParameter("code"));
		}

		if (!request.getParameter(TITLE).equals("0")) {
			int titleId = Integer.parseInt(request.getParameter(TITLE));
			MasTitle masTitle = new MasTitle();
			masTitle.setId(titleId);
			storedMasApplicant.setTitle(masTitle);
		}
		if (!request.getParameter(JOB_ID).equals("0")) {
			int jobId = Integer.parseInt(request.getParameter(JOB_ID));
			MasJob masJob = new MasJob();
			masJob.setId(jobId);
			storedMasApplicant.setJob(masJob);
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			int departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			storedMasApplicant.setDepartment(masDepartment);
		}
		if (!"".equalsIgnoreCase(request.getParameter(ADDRESS))) {
			storedMasApplicant.setAddress(request.getParameter(ADDRESS));
		}
		if (!"0".equalsIgnoreCase(request.getParameter(DISTRICT))) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			storedMasApplicant.setCity(masDistrict);
		}

		if (!"".equalsIgnoreCase(request.getParameter(ZIPCODE))) {
			storedMasApplicant.setZipCode((request.getParameter(ZIPCODE)));
		}

		if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {

			int countryId = Integer.parseInt(request.getParameter(COUNTRY));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			storedMasApplicant.setCountry(masCountry);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(STATE))) {

			int stateId = Integer.valueOf(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			storedMasApplicant.setState(masState);
		}

		if (!(("").equalsIgnoreCase(request.getParameter(TELEPHONE_NO)))) {
			storedMasApplicant.setTelephoneNo((request
					.getParameter(TELEPHONE_NO)));
		}
		if (!("".equalsIgnoreCase(request.getParameter(MOBILE)))) {
			// int cell=Integer.parseInt(request.getParameter(MOBILE));

			storedMasApplicant.setCellNo(request.getParameter(MOBILE));
		}
		if (!"".equalsIgnoreCase(request.getParameter(EMAIL_ID))) {
			storedMasApplicant.setEmail(request.getParameter(EMAIL_ID));
		}
		storedApplicantRefrenceDetailsList = applicantHandlerService
				.getApplicantRefrenceDetailsList(storedMasApplicant.getId());
		storedApplicantRefrenceDetails = storedApplicantRefrenceDetailsList
				.get(0);
		storedApplicantRefrenceDetails.setSrNo(1);
		if (!"".equalsIgnoreCase(request.getParameter("rName1"))) {
			storedApplicantRefrenceDetails.setName(request
					.getParameter("rName1"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rAddress1"))) {
			storedApplicantRefrenceDetails.setAddress(request
					.getParameter("rAddress1"));
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rDistrict1"))) {
			int districtId = Integer.parseInt(request
					.getParameter("rDistrict1"));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			storedApplicantRefrenceDetails.setCity(masDistrict);
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rState1"))) {
			int stateId = Integer.parseInt(request.getParameter("rState1"));
			MasState masState = new MasState();
			masState.setId(stateId);
			storedApplicantRefrenceDetails.setState(masState);
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rCountry1"))) {
			int countryId = Integer.parseInt(request.getParameter("rCountry1"));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			storedApplicantRefrenceDetails.setCountry(masCountry);
		}
		if (!"".equalsIgnoreCase(request.getParameter("rZipCode1"))) {
			storedApplicantRefrenceDetails.setZipCode((request
					.getParameter("rZipCode1")).trim());
		}
		if (!"".equalsIgnoreCase(request.getParameter("rPhoneNo1"))) {
			storedApplicantRefrenceDetails.setPhoneNo((request
					.getParameter("rPhoneNo1")));
		}

		if (!"".equalsIgnoreCase(request.getParameter("rComments1"))) {
			storedApplicantRefrenceDetails.setComments(request
					.getParameter("rComments1"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rDesignation1"))) {
			storedApplicantRefrenceDetails.setDesignation(request
					.getParameter("rDesignation1"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rCompany1"))) {
			storedApplicantRefrenceDetails.setCompanyName(request
					.getParameter("rCompany1"));
		}

		storedApplicantRefrenceDetails1 = storedApplicantRefrenceDetailsList
				.get(1);
		storedApplicantRefrenceDetails1.setSrNo(2);
		if (!"".equalsIgnoreCase(request.getParameter("rName2"))) {
			storedApplicantRefrenceDetails1.setName(request
					.getParameter("rName2"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rAddress2"))) {
			storedApplicantRefrenceDetails1.setAddress(request
					.getParameter("rAddress2"));
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rDistrict2"))) {
			int districtId = Integer.parseInt(request
					.getParameter("rDistrict2"));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			storedApplicantRefrenceDetails1.setCity(masDistrict);
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rState2"))) {
			int stateId = Integer.parseInt(request.getParameter("rState2"));
			MasState masState = new MasState();
			masState.setId(stateId);
			storedApplicantRefrenceDetails1.setState(masState);
		}
		if (!"0".equalsIgnoreCase(request.getParameter("rCountry2"))) {
			int countryId = Integer.parseInt(request.getParameter("rCountry2"));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			storedApplicantRefrenceDetails1.setCountry(masCountry);
		}
		if (!"".equalsIgnoreCase(request.getParameter("rZipCode2"))) {
			storedApplicantRefrenceDetails1.setZipCode(((request
					.getParameter("rZipCode2").trim())));
		}

		if (!"".equalsIgnoreCase(request.getParameter("rPhoneNo2"))) {
			storedApplicantRefrenceDetails1.setPhoneNo(((request
					.getParameter("rPhoneNo2").trim())));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rComments2"))) {
			storedApplicantRefrenceDetails1.setComments(request
					.getParameter("rComments2"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rDesignation2"))) {
			storedApplicantRefrenceDetails1.setDesignation(request
					.getParameter("rDesignation2"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("rCompany2"))) {
			storedApplicantRefrenceDetails1.setCompanyName(request
					.getParameter("rCompany2"));
		}
		Map<String, Object> dataContentMap = new HashMap<String, Object>();

		dataContentMap.put("storedMasApplicant", storedMasApplicant);
		dataContentMap.put("storedApplicantRefrenceDetails",
				storedApplicantRefrenceDetails);
		dataContentMap.put("storedApplicantRefrenceDetails1",
				storedApplicantRefrenceDetails1);
		//commented for maven
		/*Logger logger = Logger.getLogger(ApplicantRegistrationController.class);
*/
		try {
			List<String> flag = applicantHandlerService
					.updateMasterDetails(dataContentMap);

			String contentJsp = "";
			map = applicantHandlerService.showApplicantRegistrationJsp(request);

			if (!flag.contains("false")) {

				map = applicantHandlerService
						.showApplicantRegistrationJsp(request);

				contentJsp = APPLICANT_PERSONAL_JSP;

				contentJsp += ".jsp";
				map.put("contentJsp", contentJsp);

			} else {

				contentJsp = APPLICANT_REGISTRATION_JSP;
				contentJsp += ".jsp";
				map.put("contentJsp", contentJsp);
				map.put("error", "errors occured while saving Data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView savePersonalDetails(HttpServletRequest request,
			HttpServletResponse response) {
		if ((Integer) request.getSession().getAttribute("token") == (Integer
				.parseInt(request.getParameter("token")))) {
			ApplicantPersonal applicantPersonal = new ApplicantPersonal();

			Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

			applicantPersonal.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String) dateMap
							.get("currentDate")));

			applicantPersonal.setLastChgTime((String) dateMap
					.get("currentTime"));
			applicantPersonal.setLastChgBy("applicant");
			Date dateOfBirth = null;
			if (!"".equalsIgnoreCase(request.getParameter(DATE_OF_BIRTH))) {
				dateOfBirth = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(DATE_OF_BIRTH));
				applicantPersonal.setDateOfBirth(dateOfBirth);

			}

			if (!"".equalsIgnoreCase(request.getParameter(GENDER))) {
				applicantPersonal.setGender(request.getParameter(GENDER));
			}
			if (!"".equalsIgnoreCase(request.getParameter(PLACE_OF_BIRTH))) {
				applicantPersonal.setPlaceOfBirth(request
						.getParameter(PLACE_OF_BIRTH));
			}

			if (!"".equalsIgnoreCase(request.getParameter(SSC_NO))) {
				applicantPersonal.setSscNo(request.getParameter(SSC_NO));
			}
			if (!"".equalsIgnoreCase(request.getParameter(TIN_NO))) {
				applicantPersonal.setTinNo(request.getParameter(TIN_NO));
			}
			if (!"".equalsIgnoreCase(request.getParameter(PHIC_NO))) {
				applicantPersonal.setPhicNo(request.getParameter(PHIC_NO));
			}
			if (!"".equalsIgnoreCase(request.getParameter(PASSPORT_NO))) {
				applicantPersonal.setPassportNo(request
						.getParameter(PASSPORT_NO));
			}
			if (!"".equalsIgnoreCase(request.getParameter(PAN_NO))) {
				applicantPersonal.setPanNo(request.getParameter(PAN_NO));
			}

			if (!"".equalsIgnoreCase(request.getParameter(DRIVING_LICENCE_NO))) {
				applicantPersonal.setDrivingLicenceNo(request
						.getParameter(DRIVING_LICENCE_NO));
			}
			if (!"0".equalsIgnoreCase(request.getParameter(NATIONALITY))) {
				MasNationality masNationality = new MasNationality();
				masNationality.setId(Integer.parseInt(request
						.getParameter(NATIONALITY)));
				applicantPersonal.setNationality(masNationality);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {
				MasCountry masCountry = new MasCountry();
				masCountry
						.setId(Integer.parseInt(request.getParameter(COUNTRY)));
				applicantPersonal.setCountry(masCountry);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(TRIBE))) {
				MasTribe masTribe = new MasTribe();
				masTribe.setId(Integer.parseInt(request.getParameter(TRIBE)));
				applicantPersonal.setTribe(masTribe);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(RELIGION))) {
				MasReligion masReligion = new MasReligion();
				masReligion.setId(Integer.parseInt(request
						.getParameter(RELIGION)));
				applicantPersonal.setReligion(masReligion);
			}

			if (!"".equalsIgnoreCase(request.getParameter("emgContactNo"))) {
				applicantPersonal.setEmgContactNo((request
						.getParameter("emgContactNo")));
			}
			if (!"".equalsIgnoreCase(request.getParameter("emgPersonName"))) {
				applicantPersonal.setEmgPersonName(request
						.getParameter("emgPersonName"));
			}
			if (!"".equalsIgnoreCase(request.getParameter("emgPersonAddress"))) {
				applicantPersonal.setEmgAddress(request
						.getParameter("emgPersonAddress"));
			}
			if (!"".equalsIgnoreCase(request.getParameter(MARTIAL_STATUS))) {

				applicantPersonal.setMartialStatus(request
						.getParameter(MARTIAL_STATUS));
			}
			if (!"".equalsIgnoreCase(request.getParameter(FATHER_NAME))) {

				applicantPersonal.setFatherName(request
						.getParameter(FATHER_NAME));
			}
			if (!"".equalsIgnoreCase(request.getParameter(MOTHER_NAME))) {

				applicantPersonal.setMotherName(request
						.getParameter(MOTHER_NAME));
			}
			if (!"".equalsIgnoreCase(request.getParameter(SPOUSE_NAME))) {

				applicantPersonal.setSpouseName(request
						.getParameter(SPOUSE_NAME));
			}
			if (!"".equalsIgnoreCase(request.getParameter(NO_OF_CHILDREN))
					&& request.getParameter(NO_OF_CHILDREN) != null) {

				applicantPersonal.setNoOfChildren(Integer.parseInt(request
						.getParameter(NO_OF_CHILDREN)));
			}
			if (!"".equalsIgnoreCase(request.getParameter(HEIGHT))
					&& request.getParameter(HEIGHT) != null) {

				applicantPersonal.setHeight(Float.parseFloat(request
						.getParameter(HEIGHT)));

			}
			if (!"".equalsIgnoreCase(request.getParameter(WEIGHT))
					&& request.getParameter(WEIGHT) != null) {

				applicantPersonal.setWeight(Float.parseFloat(request
						.getParameter(WEIGHT)));
			}

			if (!"".equalsIgnoreCase(request.getParameter(GENERAL_INTEREST))) {

				applicantPersonal.setGeneralInterest(request
						.getParameter(GENERAL_INTEREST));
			}
			if (!"".equalsIgnoreCase(request.getParameter(LIKES))) {

				applicantPersonal.setLikes(request.getParameter(LIKES));
			}
			if (!"".equalsIgnoreCase(request.getParameter(DISLIKES))) {

				applicantPersonal.setDislike(request.getParameter(DISLIKES));
			}
			if (!"".equalsIgnoreCase(request.getParameter(STRENGHT))) {

				applicantPersonal.setStrength(request.getParameter(STRENGHT));
			}
			if (!"".equalsIgnoreCase(request.getParameter(WEEKNESS))) {

				applicantPersonal.setWeekness(request.getParameter(WEEKNESS));
			}

			map = applicantHandlerService.showApplicantRegistrationJsp(request);
			applicantPersonal.setApplicant((MasApplicant) map
					.get("masApplicant"));
			boolean flag = applicantHandlerService
					.savePersonalDetails(applicantPersonal);

			String contentJsp = "";
			String errorMsg = "";
			if (flag) {
				request.getSession()
						.setAttribute(
								"token",
								(Integer) request.getSession().getAttribute(
										"token") + 1);
				contentJsp = APPLICANT_EDUCATION_JSP;
				contentJsp += ".jsp";
				map.put("contentJsp", contentJsp);
			} else {
				contentJsp = APPLICANT_PERSONAL_JSP + ".jsp";
				errorMsg = "unable to save date";
				map.put("errorMsg", errorMsg);
			}
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updatePersonalDetails(HttpServletRequest request,
			HttpServletResponse response) {

		storedApplicantPersonal = applicantHandlerService
				.getPersonalDetails(Integer.parseInt(request
						.getParameter("applicantId")));

		Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

		storedApplicantPersonal.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType((String) dateMap
						.get("currentDate")));

		storedApplicantPersonal.setLastChgTime((String) dateMap
				.get("currentTime"));
		storedApplicantPersonal.setLastChgBy("applicant");
		Date dateOfBirth = null;
		if (!"".equalsIgnoreCase(request.getParameter(DATE_OF_BIRTH))) {
			dateOfBirth = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_BIRTH));
			storedApplicantPersonal.setDateOfBirth(dateOfBirth);

		}

		if (!"".equalsIgnoreCase(request.getParameter(GENDER))) {
			storedApplicantPersonal.setGender(request.getParameter(GENDER));
		}
		if (!"".equalsIgnoreCase(request.getParameter(PLACE_OF_BIRTH))) {
			storedApplicantPersonal.setPlaceOfBirth(request
					.getParameter(PLACE_OF_BIRTH));
		}

		if (!"".equalsIgnoreCase(request.getParameter(SSC_NO))) {
			storedApplicantPersonal.setSscNo(request.getParameter(SSC_NO));
		}
		if (!"".equalsIgnoreCase(request.getParameter(TIN_NO))) {
			storedApplicantPersonal.setTinNo(request.getParameter(TIN_NO));
		}
		if (!"".equalsIgnoreCase(request.getParameter(PHIC_NO))) {
			storedApplicantPersonal.setPhicNo(request.getParameter(PHIC_NO));
		}
		if (!"".equalsIgnoreCase(request.getParameter(PASSPORT_NO))) {
			storedApplicantPersonal.setPassportNo(request
					.getParameter(PASSPORT_NO));
		}
		if (!"".equalsIgnoreCase(request.getParameter(PAN_NO))) {
			storedApplicantPersonal.setPanNo(request.getParameter(PAN_NO));
		}

		if (!"".equalsIgnoreCase(request.getParameter(DRIVING_LICENCE_NO))) {
			storedApplicantPersonal.setDrivingLicenceNo(request
					.getParameter(DRIVING_LICENCE_NO));
		}
		if (!"0".equalsIgnoreCase(request.getParameter(NATIONALITY))) {
			MasNationality masNationality = new MasNationality();
			masNationality.setId(Integer.parseInt(request
					.getParameter(NATIONALITY)));
			storedApplicantPersonal.setNationality(masNationality);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {
			MasCountry masCountry = new MasCountry();
			masCountry.setId(Integer.parseInt(request.getParameter(COUNTRY)));
			storedApplicantPersonal.setCountry(masCountry);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(TRIBE))) {
			MasTribe masTribe = new MasTribe();
			masTribe.setId(Integer.parseInt(request.getParameter(TRIBE)));
			storedApplicantPersonal.setTribe(masTribe);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(RELIGION))) {
			MasReligion masReligion = new MasReligion();
			masReligion.setId(Integer.parseInt(request.getParameter(RELIGION)));
			storedApplicantPersonal.setReligion(masReligion);
		}

		if (!"".equalsIgnoreCase(request.getParameter("emgContactNo"))) {
			storedApplicantPersonal.setEmgContactNo((request
					.getParameter("emgContactNo")));
		}
		if (!"".equalsIgnoreCase(request.getParameter("emgPersonName"))) {
			storedApplicantPersonal.setEmgPersonName(request
					.getParameter("emgPersonName"));
		}
		if (!"".equalsIgnoreCase(request.getParameter("emgPersonAddress"))) {
			storedApplicantPersonal.setEmgAddress(request
					.getParameter("emgPersonAddress"));
		}
		if (!"".equalsIgnoreCase(request.getParameter(MARTIAL_STATUS))) {

			storedApplicantPersonal.setMartialStatus(request
					.getParameter(MARTIAL_STATUS));
		}
		if (!"".equalsIgnoreCase(request.getParameter(FATHER_NAME))) {

			storedApplicantPersonal.setFatherName(request
					.getParameter(FATHER_NAME));
		}
		if (!"".equalsIgnoreCase(request.getParameter(MOTHER_NAME))) {

			storedApplicantPersonal.setMotherName(request
					.getParameter(MOTHER_NAME));
		}
		if (!"".equalsIgnoreCase(request.getParameter(SPOUSE_NAME))) {

			storedApplicantPersonal.setSpouseName(request
					.getParameter(SPOUSE_NAME));
		}
		if (!"".equalsIgnoreCase(request.getParameter(NO_OF_CHILDREN))
				&& request.getParameter(NO_OF_CHILDREN) != null) {

			storedApplicantPersonal.setNoOfChildren(Integer.parseInt(request
					.getParameter(NO_OF_CHILDREN)));
		}
		if (!"".equalsIgnoreCase(request.getParameter(HEIGHT))
				&& request.getParameter(HEIGHT) != null) {

			storedApplicantPersonal.setHeight(Float.parseFloat(request
					.getParameter(HEIGHT)));

		}
		if (!"".equalsIgnoreCase(request.getParameter(WEIGHT))
				&& request.getParameter(WEIGHT) != null) {

			storedApplicantPersonal.setWeight(Float.parseFloat(request
					.getParameter(WEIGHT)));
		}

		if (!"".equalsIgnoreCase(request.getParameter(GENERAL_INTEREST))) {

			storedApplicantPersonal.setGeneralInterest(request
					.getParameter(GENERAL_INTEREST));
		}
		if (!"".equalsIgnoreCase(request.getParameter(LIKES))) {

			storedApplicantPersonal.setLikes(request.getParameter(LIKES));
		}
		if (!"".equalsIgnoreCase(request.getParameter(DISLIKES))) {

			storedApplicantPersonal.setDislike(request.getParameter(DISLIKES));
		}
		if (!"".equalsIgnoreCase(request.getParameter(STRENGHT))) {

			storedApplicantPersonal.setStrength(request.getParameter(STRENGHT));
		}
		if (!"".equalsIgnoreCase(request.getParameter(WEEKNESS))) {

			storedApplicantPersonal.setWeekness(request.getParameter(WEEKNESS));
		}

		map = applicantHandlerService.showApplicantRegistrationJsp(request);
		storedApplicantPersonal.setApplicant((MasApplicant) map
				.get("masApplicant"));
		boolean flag = applicantHandlerService
				.updatePersonalDetails(storedApplicantPersonal);

		String contentJsp = "";
		String errorMsg = "";
		if (flag) {
			contentJsp = APPLICANT_EDUCATION_JSP;
			contentJsp += ".jsp";
			map.put("contentJsp", contentJsp);
		} else {
			contentJsp = APPLICANT_PERSONAL_JSP + ".jsp";
			errorMsg = "unable to save date";
			map.put("errorMsg", errorMsg);
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveEducationalDetails(HttpServletRequest request,
			HttpServletResponse response) {
		if ((Integer) request.getSession().getAttribute("token") == (Integer
				.parseInt(request.getParameter("token")))) {
			List<String> flagList = new ArrayList<String>();
			for (int count = 1; count <= 3; count++) {
				ApplicantEducation applicantEducation = new ApplicantEducation();

				Map<String, Object> dateMap = (HashMap<String, Object>) HMSUtil
						.getCurrentDateAndTime();

				applicantEducation.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType((String) dateMap
								.get("currentDate")));

				applicantEducation.setLastChgTime((String) dateMap
						.get("currentTime"));
				applicantEducation.setLastChgBy("applicant");
				applicantEducation.setSrNo(count);
				if (request.getParameter(EDUCATION_TYPE + count) != null) {

					applicantEducation.setEducationType(request
							.getParameter(EDUCATION_TYPE + count));
				}
				if (!"0".equalsIgnoreCase(request
						.getParameter(QUALIFICATION_OBTAINED + count))
						&& request.getParameter(QUALIFICATION_OBTAINED + count) != null) {
					MasQualification masQualification = new MasQualification();
					masQualification.setId(Integer.parseInt(request
							.getParameter(QUALIFICATION_OBTAINED + count)));
					applicantEducation.setQualification(masQualification);
				}
				if (!"0".equalsIgnoreCase(request.getParameter(INSTITUTE_LIST
						+ count))
						&& request.getParameter(INSTITUTE_LIST + count) != null) {

					MasInstitute masInstitute = new MasInstitute();
					masInstitute.setId(Integer.parseInt(request
							.getParameter(INSTITUTE_LIST + count)));

					applicantEducation.setInstitute(masInstitute);
				}
				if (!"0".equalsIgnoreCase(request.getParameter(COURSE + count))
						&& request.getParameter(COURSE + count) != null) {
					MasCourse masCourse = new MasCourse();
					masCourse.setId(Integer.parseInt(request
							.getParameter(COURSE + count)));
					applicantEducation.setCourse(masCourse);
				}
				if (!"0".equalsIgnoreCase(request
						.getParameter(SPL_QUALIFICATION + count))
						&& request.getParameter(SPL_QUALIFICATION + count) != null) {
					MasSplQualification splQualification = new MasSplQualification();
					splQualification.setId(Integer.parseInt(request
							.getParameter(SPL_QUALIFICATION + count)));
					applicantEducation.setSplQualification(splQualification);
				}
				if (request.getParameter(START_DATE + count) != null
						&& !"".equals(request.getParameter(START_DATE + count))) {
					Date startDate = HMSUtil
							.convertStringTypeDateToDateType(request
									.getParameter(START_DATE + count));
					applicantEducation.setStartDate(startDate);
				}
				if (request.getParameter(END_DATE + count) != null
						&& !"".equals(request.getParameter(END_DATE + count))) {

					Date endDate = HMSUtil
							.convertStringTypeDateToDateType(request
									.getParameter(END_DATE + count));
					applicantEducation.setEndDate(endDate);
				}
				if (request.getParameter(COURSE_DURATION + count) != null
						&& !"".equalsIgnoreCase(request
								.getParameter(COURSE_DURATION + count))) {

					applicantEducation.setDuration(Float.parseFloat(request
							.getParameter(COURSE_DURATION + count)));
				}
				if (!"0".equalsIgnoreCase(request.getParameter(DURATION_TYPE
						+ count))
						&& request.getParameter(DURATION_TYPE + count) != null) {
					MasDurationType masDurationType = new MasDurationType();
					masDurationType.setId(Integer.parseInt(request
							.getParameter(DURATION_TYPE + count)));
					applicantEducation.setDurationType(masDurationType);

				}
				if (request.getParameter(QUALIFIED_DATE + count) != null
						&& !"".equals(request.getParameter(QUALIFIED_DATE
								+ count))) {
					Date qualifiedDate = HMSUtil
							.convertStringTypeDateToDateType(request
									.getParameter(QUALIFIED_DATE + count));
					applicantEducation.setQualifiedDate(qualifiedDate);
				}
				if (request.getParameter(PERCENTAGE + count) != null
						&& !"".equalsIgnoreCase(request.getParameter(PERCENTAGE
								+ count))) {

					applicantEducation.setGradePercentage((Float
							.parseFloat(request
									.getParameter(PERCENTAGE + count))));
				}
				if (request.getParameter(AWARDS + count) != null
						&& !"".equalsIgnoreCase(request.getParameter(AWARDS
								+ count))) {

					applicantEducation.setAwards(request.getParameter(AWARDS
							+ count));
				}
				if (request.getParameter(SKILLS + count) != null
						&& !"".equalsIgnoreCase(request.getParameter(SKILLS
								+ count))) {

					applicantEducation.setSkills(request.getParameter(SKILLS
							+ count));
				}
				map = applicantHandlerService
						.showApplicantRegistrationJsp(request);
				applicantEducation.setApplicant((MasApplicant) map
						.get("masApplicant"));
				if (request.getParameter(EDUCATION_TYPE + count) != null) {
					boolean flag = applicantHandlerService
							.saveEducationalDetails(applicantEducation);
					if (flag) {
						flagList.add("true");
					} else {
						flagList.add("false");
					}
				}
			}
			String contentJsp = "";
			String errorMsg = "";

			if (!(flagList.contains("false"))) {
				request.getSession()
						.setAttribute(
								"token",
								(Integer) request.getSession().getAttribute(
										"token") + 1);
				contentJsp = APPLICANT_EXPERIENCE_JSP;
				contentJsp += ".jsp";
				map.put("contentJsp", contentJsp);
			} else {
				contentJsp = APPLICANT_EDUCATION_JSP;
				contentJsp += ".jsp";
				errorMsg = "unable to save date";
				map.put("errorMsg", errorMsg);
				map.put("contentJsp", contentJsp);
			}
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateEducationalDetails(HttpServletRequest request,
			HttpServletResponse response) {
		List<String> flagList = new ArrayList<String>();
		applicantEducationList = applicantHandlerService
				.getEducationalDetails(Integer.parseInt(request
						.getParameter("applicantId")));
		for (int count = 1; count <= applicantEducationList.size(); count++) {

			ApplicantEducation applicantEducation = applicantEducationList
					.get(count - 1);
			Map<String, Object> dateMap = (HashMap<String, Object>) HMSUtil
					.getCurrentDateAndTime();

			applicantEducation.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String) dateMap
							.get("currentDate")));

			applicantEducation.setLastChgTime((String) dateMap
					.get("currentTime"));
			applicantEducation.setLastChgBy("applicant");
			applicantEducation.setSrNo(count);
			if (request.getParameter(EDUCATION_TYPE + count) != null) {

				applicantEducation.setEducationType(request
						.getParameter(EDUCATION_TYPE + count));
			}
			if (!"0".equalsIgnoreCase(request
					.getParameter(QUALIFICATION_OBTAINED + count))
					&& request.getParameter(QUALIFICATION_OBTAINED + count) != null) {
				MasQualification masQualification = new MasQualification();
				masQualification.setId(Integer.parseInt(request
						.getParameter(QUALIFICATION_OBTAINED + count)));
				applicantEducation.setQualification(masQualification);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(INSTITUTE_LIST
					+ count))
					&& request.getParameter(INSTITUTE_LIST + count) != null) {

				MasInstitute masInstitute = new MasInstitute();
				masInstitute.setId(Integer.parseInt(request
						.getParameter(INSTITUTE_LIST + count)));

				applicantEducation.setInstitute(masInstitute);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(COURSE + count))
					&& request.getParameter(COURSE + count) != null) {
				MasCourse masCourse = new MasCourse();
				masCourse.setId(Integer.parseInt(request.getParameter(COURSE
						+ count)));
				applicantEducation.setCourse(masCourse);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(SPL_QUALIFICATION
					+ count))
					&& request.getParameter(SPL_QUALIFICATION + count) != null) {
				MasSplQualification splQualification = new MasSplQualification();
				splQualification.setId(Integer.parseInt(request
						.getParameter(SPL_QUALIFICATION + count)));
				applicantEducation.setSplQualification(splQualification);
			}
			if (request.getParameter(START_DATE + count) != null
					&& !"".equals(request.getParameter(START_DATE + count))) {
				Date startDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(START_DATE + count));
				applicantEducation.setStartDate(startDate);
			}
			if (request.getParameter(END_DATE + count) != null
					&& !"".equals(request.getParameter(END_DATE + count))) {

				Date endDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(END_DATE + count));
				applicantEducation.setEndDate(endDate);
			}
			if (request.getParameter(COURSE_DURATION + count) != null
					&& !"".equalsIgnoreCase(request
							.getParameter(COURSE_DURATION + count))) {

				applicantEducation.setDuration(Float.parseFloat(request
						.getParameter(COURSE_DURATION + count)));
			}
			if (!"0".equalsIgnoreCase(request.getParameter(DURATION_TYPE
					+ count))
					&& request.getParameter(DURATION_TYPE + count) != null) {
				MasDurationType masDurationType = new MasDurationType();
				masDurationType.setId(Integer.parseInt(request
						.getParameter(DURATION_TYPE + count)));
				applicantEducation.setDurationType(masDurationType);

			}
			if (request.getParameter(QUALIFIED_DATE + count) != null
					&& !"".equals(request.getParameter(QUALIFIED_DATE + count))) {
				Date qualifiedDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(QUALIFIED_DATE + count));
				applicantEducation.setQualifiedDate(qualifiedDate);
			}
			if (request.getParameter(PERCENTAGE + count) != null
					&& !"".equalsIgnoreCase(request.getParameter(PERCENTAGE
							+ count))) {

				applicantEducation.setGradePercentage((Float.parseFloat(request
						.getParameter(PERCENTAGE + count))));
			}
			if (request.getParameter(AWARDS + count) != null
					&& !"".equalsIgnoreCase(request
							.getParameter(AWARDS + count))) {

				applicantEducation.setAwards(request.getParameter(AWARDS
						+ count));
			}
			if (request.getParameter(SKILLS + count) != null
					&& !"".equalsIgnoreCase(request
							.getParameter(SKILLS + count))) {

				applicantEducation.setSkills(request.getParameter(SKILLS
						+ count));
			}
			map = applicantHandlerService.showApplicantRegistrationJsp(request);
			applicantEducation.setApplicant((MasApplicant) map
					.get("masApplicant"));
			if (request.getParameter(EDUCATION_TYPE + count) != null) {
				boolean flag = applicantHandlerService
						.updateEducationalDetails(applicantEducation);
				if (flag) {
					flagList.add("true");
				} else {
					flagList.add("false");
				}
			}
		}
		String contentJsp = "";
		String errorMsg = "";

		if (!(flagList.contains("false"))) {
			contentJsp = APPLICANT_EXPERIENCE_JSP;
			contentJsp += ".jsp";
			map.put("contentJsp", contentJsp);
		} else {
			contentJsp = APPLICANT_EDUCATION_JSP;
			contentJsp += ".jsp";
			errorMsg = "unable to save date";
			map.put("errorMsg", errorMsg);
		}

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveExperienceDetails(HttpServletRequest request,
			HttpServletResponse response) {
		if ((Integer) request.getSession().getAttribute("token") == (Integer
				.parseInt(request.getParameter("token")))) {
			ApplicantExperience applicantExperience = new ApplicantExperience();

			Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

			applicantExperience.setLastChgDate(HMSUtil
					.convertStringTypeDateToDateType((String) dateMap
							.get("currentDate")));

			applicantExperience.setLastChgTime((String) dateMap
					.get("currentTime"));
			applicantExperience.setLastChgBy("applicant");

			if (!("").equalsIgnoreCase(request.getParameter(TOTAL_EXPERIENCE))) {
				applicantExperience.setTotalExperience(Float.parseFloat(request
						.getParameter(TOTAL_EXPERIENCE)));
			}
			if (!("0").equalsIgnoreCase(request.getParameter(DURATION_TYPE))) {
				MasDurationType masDurationType = new MasDurationType();
				masDurationType.setId(Integer.parseInt(request
						.getParameter(DURATION_TYPE)));
				applicantExperience.setDurationType(masDurationType);
			}
			if (!"".equalsIgnoreCase((request.getParameter(CURRENT_EMPLOYER)))) {
				applicantExperience.setCurEmployer(request
						.getParameter(CURRENT_EMPLOYER));
			}

			if (!request.getParameter(DISTRICT).equals("0")) {
				int districtId = Integer.parseInt(request
						.getParameter(DISTRICT));
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				applicantExperience.setCity(masDistrict);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(STATE))) {

				int stateId = Integer.valueOf(request.getParameter(STATE));
				MasState masState = new MasState();
				masState.setId(stateId);
				applicantExperience.setState(masState);
			}

			if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {

				int countryId = Integer.parseInt(request.getParameter(COUNTRY));
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				applicantExperience.setCountry(masCountry);
			}
			if (!"".equalsIgnoreCase(request.getParameter(ADDRESS))) {
				applicantExperience.setAddress(request.getParameter(ADDRESS));
			}
			if (request.getParameter(CUR_SER_START_DATE) != null
					&& !"".equals(request.getParameter(CUR_SER_START_DATE))) {
				Date startDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(CUR_SER_START_DATE));
				applicantExperience.setCurSerStartDate(startDate);
			}
			if (request.getParameter(CUR_SER_END_DATE) != null
					&& !"".equals(request.getParameter(CUR_SER_END_DATE))) {
				Date endDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(CUR_SER_END_DATE));
				applicantExperience.setCurSerEndDate(endDate);
			}
			if (!"".equalsIgnoreCase(request.getParameter(CURRENT_DESIGNATION))) {
				applicantExperience.setDesignation(request
						.getParameter(CURRENT_DESIGNATION));
			}
			if (!"".equalsIgnoreCase(request.getParameter(CUR_END_REASON))) {
				applicantExperience.setCurEndReason(request
						.getParameter(CUR_END_REASON));
			}
			if (!"".equalsIgnoreCase((request.getParameter(PREVIOUS_EMPLOYER)))) {
				applicantExperience.setPreEmployer(request
						.getParameter(PREVIOUS_EMPLOYER));
			}

			if (!request.getParameter(PRE_DISTRICT).equals("0")) {
				int districtId = Integer.parseInt(request
						.getParameter(PRE_DISTRICT));
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(districtId);
				applicantExperience.setPreCity(masDistrict);
			}
			if (!"0".equalsIgnoreCase(request.getParameter(PRE_STATE))) {

				int stateId = Integer.valueOf(request.getParameter(PRE_STATE));
				MasState masState = new MasState();
				masState.setId(stateId);
				applicantExperience.setPreState(masState);
			}

			if (!"0".equalsIgnoreCase(request.getParameter(PRE_COUNTRY))) {

				int countryId = Integer.parseInt(request
						.getParameter(PRE_COUNTRY));
				MasCountry masCountry = new MasCountry();
				masCountry.setId(countryId);
				applicantExperience.setPreCountry(masCountry);
			}
			if (!"".equalsIgnoreCase(request.getParameter(PRE_ADDRESS))) {
				applicantExperience.setPreAddress(request
						.getParameter(PRE_ADDRESS));
			}
			if (request.getParameter(PRE_SER_START_DATE) != null
					&& !"".equals(request.getParameter(PRE_SER_START_DATE))) {
				Date startDate = HMSUtil
						.convertStringTypeDateToDateType(request
								.getParameter(PRE_SER_START_DATE));
				applicantExperience.setPreServiceStartDate(startDate);
			}
			if (request.getParameter(PRE_SER_END_DATE) != null
					&& !"".equals(request.getParameter(PRE_SER_END_DATE))) {
				Date endDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(PRE_SER_END_DATE));
				applicantExperience.setPreServiceEndDate(endDate);
			}
			if (!"".equalsIgnoreCase(request.getParameter(PREVIOUS_DESIGNATION))) {
				applicantExperience.setPreDesignation(request
						.getParameter(PREVIOUS_DESIGNATION));
			}
			if (!"".equalsIgnoreCase(request.getParameter(PRE_END_REASON))) {
				applicantExperience.setPreEndReason(request
						.getParameter(PRE_END_REASON));
			}
			if (!"".equalsIgnoreCase(request.getParameter(AWARDS))) {
				applicantExperience.setAwards(request.getParameter(AWARDS));
			}
			if (!"".equalsIgnoreCase(request.getParameter(SKILLS))) {
				applicantExperience.setSkills(request.getParameter(SKILLS));
			}
			if (!"".equalsIgnoreCase(request.getParameter(JOB_RESPONSIBILTY))) {
				applicantExperience.setJobResponsibility(request
						.getParameter(JOB_RESPONSIBILTY));
			}

			map = applicantHandlerService.showApplicantRegistrationJsp(request);
			applicantExperience.setApplicant((MasApplicant) map
					.get("masApplicant"));
			boolean flag = applicantHandlerService
					.saveExperienceDetails(applicantExperience);
			String contentJsp = "";
			String errorMsg = "";
			if (flag) {
				request.getSession()
						.setAttribute(
								"token",
								(Integer) request.getSession().getAttribute(
										"token") + 1);
				contentJsp = APPLICANT_SUCCESS_JSP;
				contentJsp += ".jsp";
				map.put("contentJsp", contentJsp);
			} else {
				contentJsp = APPLICANT_EXPERIENCE_JSP + ".jsp";
				errorMsg = "unable to save date";
				map.put("errorMsg", errorMsg);
				map.put("contentJsp", contentJsp);
			}
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateExperienceDetails(HttpServletRequest request,
			HttpServletResponse response) {
		storedApplicantExperience = applicantHandlerService
				.getApplicantExperience(Integer.parseInt(request
						.getParameter("applicantId")));
		Map<String, Object> dateMap = HMSUtil.getCurrentDateAndTime();

		storedApplicantExperience.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType((String) dateMap
						.get("currentDate")));

		storedApplicantExperience.setLastChgTime((String) dateMap
				.get("currentTime"));
		storedApplicantExperience.setLastChgBy("applicant");

		if (!("").equalsIgnoreCase(request.getParameter(TOTAL_EXPERIENCE))) {
			storedApplicantExperience.setTotalExperience(Float
					.parseFloat(request.getParameter(TOTAL_EXPERIENCE)));
		}
		if (!("0").equalsIgnoreCase(request.getParameter(DURATION_TYPE))) {
			MasDurationType masDurationType = new MasDurationType();
			masDurationType.setId(Integer.parseInt(request
					.getParameter(DURATION_TYPE)));
			storedApplicantExperience.setDurationType(masDurationType);
		}
		if (!"".equalsIgnoreCase((request.getParameter(CURRENT_EMPLOYER)))) {
			storedApplicantExperience.setCurEmployer(request
					.getParameter(CURRENT_EMPLOYER));
		}

		if (!request.getParameter(DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request.getParameter(DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			storedApplicantExperience.setCity(masDistrict);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(STATE))) {

			int stateId = Integer.valueOf(request.getParameter(STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			storedApplicantExperience.setState(masState);
		}

		if (!"0".equalsIgnoreCase(request.getParameter(COUNTRY))) {

			int countryId = Integer.parseInt(request.getParameter(COUNTRY));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			storedApplicantExperience.setCountry(masCountry);
		}
		if (!"".equalsIgnoreCase(request.getParameter(ADDRESS))) {
			storedApplicantExperience.setAddress(request.getParameter(ADDRESS));
		}
		if (request.getParameter(CUR_SER_START_DATE) != null
				&& !"".equals(request.getParameter(CUR_SER_START_DATE))) {
			Date startDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CUR_SER_START_DATE));
			storedApplicantExperience.setCurSerStartDate(startDate);
		}
		if (request.getParameter(CUR_SER_END_DATE) != null
				&& !"".equals(request.getParameter(CUR_SER_END_DATE))) {
			Date endDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CUR_SER_END_DATE));
			storedApplicantExperience.setCurSerEndDate(endDate);
		}
		if (!"".equalsIgnoreCase(request.getParameter(CURRENT_DESIGNATION))) {
			storedApplicantExperience.setDesignation(request
					.getParameter(CURRENT_DESIGNATION));
		}
		if (!"".equalsIgnoreCase(request.getParameter(CUR_END_REASON))) {
			storedApplicantExperience.setCurEndReason(request
					.getParameter(CUR_END_REASON));
		}
		if (!"".equalsIgnoreCase((request.getParameter(PREVIOUS_EMPLOYER)))) {
			storedApplicantExperience.setPreEmployer(request
					.getParameter(PREVIOUS_EMPLOYER));
		}

		if (!request.getParameter(PRE_DISTRICT).equals("0")) {
			int districtId = Integer.parseInt(request
					.getParameter(PRE_DISTRICT));
			MasDistrict masDistrict = new MasDistrict();
			masDistrict.setId(districtId);
			storedApplicantExperience.setPreCity(masDistrict);
		}
		if (!"0".equalsIgnoreCase(request.getParameter(PRE_STATE))) {

			int stateId = Integer.valueOf(request.getParameter(PRE_STATE));
			MasState masState = new MasState();
			masState.setId(stateId);
			storedApplicantExperience.setPreState(masState);
		}

		if (!"0".equalsIgnoreCase(request.getParameter(PRE_COUNTRY))) {

			int countryId = Integer.parseInt(request.getParameter(PRE_COUNTRY));
			MasCountry masCountry = new MasCountry();
			masCountry.setId(countryId);
			storedApplicantExperience.setPreCountry(masCountry);
		}
		if (!"".equalsIgnoreCase(request.getParameter(PRE_ADDRESS))) {
			storedApplicantExperience.setPreAddress(request
					.getParameter(PRE_ADDRESS));
		}
		if (request.getParameter(PRE_SER_START_DATE) != null
				&& !"".equals(request.getParameter(PRE_SER_START_DATE))) {
			Date startDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(PRE_SER_START_DATE));
			storedApplicantExperience.setPreServiceStartDate(startDate);
		}
		if (request.getParameter(PRE_SER_END_DATE) != null
				&& !"".equals(request.getParameter(PRE_SER_END_DATE))) {
			Date endDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(PRE_SER_END_DATE));
			storedApplicantExperience.setPreServiceEndDate(endDate);
		}
		if (!"".equalsIgnoreCase(request.getParameter(PREVIOUS_DESIGNATION))) {
			storedApplicantExperience.setPreDesignation(request
					.getParameter(PREVIOUS_DESIGNATION));
		}
		if (!"".equalsIgnoreCase(request.getParameter(PRE_END_REASON))) {
			storedApplicantExperience.setPreEndReason(request
					.getParameter(PRE_END_REASON));
		}
		if (!"".equalsIgnoreCase(request.getParameter(AWARDS))) {
			storedApplicantExperience.setAwards(request.getParameter(AWARDS));
		}
		if (!"".equalsIgnoreCase(request.getParameter(SKILLS))) {
			storedApplicantExperience.setSkills(request.getParameter(SKILLS));
		}
		if (!"".equalsIgnoreCase(request.getParameter(JOB_RESPONSIBILTY))) {
			storedApplicantExperience.setJobResponsibility(request
					.getParameter(JOB_RESPONSIBILTY));
		}

		map = applicantHandlerService.showApplicantRegistrationJsp(request);
		storedApplicantExperience.setApplicant((MasApplicant) map
				.get("masApplicant"));
		boolean flag = applicantHandlerService
				.updateExperienceDetails(storedApplicantExperience);

		String contentJsp = "";
		String errorMsg = "";
		if (flag) {
			contentJsp = APPLICANT_EXPERIENCE_JSP;

			contentJsp += ".jsp";
			map.put("contentJsp", contentJsp);
		} else {
			contentJsp = APPLICANT_EXPERIENCE_JSP + ".jsp";
			errorMsg = "unable to update date";
			map.put("errorMsg", errorMsg);
		}

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getDepartmentCode(HttpServletRequest request,
			HttpServletResponse response) {
		int departmentId = Integer
				.parseInt(request.getParameter(DEPARTMENT_ID));

		String departmentCode = applicantHandlerService
				.getDepartmentCode(departmentId);
		Map<String, Object> map = new HashMap<String, Object>();

		String contentJsp = "";

		map.put("departmentCode", departmentCode);

		return new ModelAndView("applicantDepartmentAjax", "map", map);

	}

	public ModelAndView getJobCode(HttpServletRequest request,
			HttpServletResponse response) {
		int jobId = Integer.parseInt(request.getParameter(JOB_ID));
		String jobCode = applicantHandlerService.getJobCode(jobId);

		Map<String, Object> map = new HashMap<String, Object>();

		String contentJsp = "";

		map.put("jobCode", jobCode);

		return new ModelAndView("applicantJobAjax", "map", map);
	}
}
