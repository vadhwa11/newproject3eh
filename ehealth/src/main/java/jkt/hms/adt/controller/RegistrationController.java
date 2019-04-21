/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * Class RegistrationController.java
 * Purpose of the class - This is for Registration, Visit Module.
 * It contains Registration and Visit of the patient.
 * @author  Ritu Sahu
 * Create Date: 3rd Jan,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/
package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.*;
import in.gov.uidai.auth.device.model.DeviceCollectedAuthData;
import in.gov.uidai.authentication.common.types._1.Meta;
import in.gov.uidai.authentication.uid_auth_request_data._1.MatchingStrategy;
import in.gov.uidai.sample.SampleClientMainFrame;

import java.awt.Image;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.billing.handler.OpBillingHandlerService;
import jkt.hms.masters.business.BlOpBillDetails;
import jkt.hms.masters.business.BlOpBillHeader;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.HospitalDoctorUnitT;
import jkt.hms.masters.business.MasAddressType;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasAuthorizer;
import jkt.hms.masters.business.MasBloodGroup;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasCountry;
import jkt.hms.masters.business.MasDiscount;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasIdCard;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasOccupation;
import jkt.hms.masters.business.MasPatientType;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasScheme;
import jkt.hms.masters.business.MasSession;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasVisaType;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.OnlinePatientVisit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientCategoryDetails;
import jkt.hms.masters.business.PhFamilySurvey;
import jkt.hms.masters.business.PhHouseSurvey;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.stores.handler.StoresHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.MasQualification;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class RegistrationController extends MultiActionController {

	private RegistrationHandlerService registrationHandlerService = null;
	private OpBillingHandlerService opBillingHandlerService = null;
	private AccountHandlerService accountHandlerService = null;
	private StoresHandlerService storesHandlerService = null;

	public RegistrationHandlerService getRegistrationHandlerService() {
		return registrationHandlerService;
	}

	public void setRegistrationHandlerService(final RegistrationHandlerService registrationHandlerService) {
		this.registrationHandlerService = registrationHandlerService;
	}

	public StoresHandlerService getStoresHandlerService() {
		return storesHandlerService;
	}

	public void setStoresHandlerService(final StoresHandlerService storesHandlerService) {
		this.storesHandlerService = storesHandlerService;
	}

	static final Logger LOGGER = Logger.getLogger(RegistrationController.class);

	/*
	 * Code for read from property file from src package
	 */
	private final Properties properties = new Properties();
	{
		try {
			ClassLoader loader = getClass().getClassLoader();
			InputStream inStream = loader.getResourceAsStream("commonReportFile.properties");
			properties.load(inStream);
		} catch (IOException ioException) {
			LOGGER.error("Error while loading  commonReportFile.properties" + ioException.getStackTrace().toString());
		}
	}

	/**
	 * ----------------------------------- Patient Registration Related
	 * Method----------------------------
	 */
	public ModelAndView showRegistrationJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showRegistrationJsp ");
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = registrationHandlerService.showRegistrationJsp(deptId, hospitalId);

		int districtId = registrationHandlerService.getDistrictIdByHospital(hospitalId);
		LOGGER.debug("districtId : " + districtId);
		map.put("districtId", districtId);
		map.put("contentJsp", REGISTRATION_JSP);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Show jsp for Unserviced
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showPendingUnservicedJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPendingUnservicedJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", PENDING_UNSERVICED_JSP);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Search Unserviced Patient
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView searchUnservicedPatient(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside searchUnservicedPatient ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(RequestConstants.DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(RequestConstants.DEPT_ID);
			LOGGER.debug("deptId : " + deptId);
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(RequestConstants.HOSPITAL_ID);
			LOGGER.debug("hospitalId : " + hospitalId);
		}
		box.put(RequestConstants.DEPT_ID, deptId);
		box.put(RequestConstants.HOSPITAL_ID, hospitalId);
		map = registrationHandlerService.searchUnservicedPatient(box);

		map.put("contentJsp", PENDING_UNSERVICED_JSP);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Submit Unserviced Patient
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitUnservicedPatient(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside submitUnservicedPatient ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = registrationHandlerService.submitUnservicedPatient(box);
		map.put("contentJsp", PENDING_UNSERVICED_JSP);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Mehtod for save the patient Details
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientInformation(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside submitPatientInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> regDataMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		MasIdCard idCard = new MasIdCard();
		Box box = HMSUtil.getBox(request);
		String hinNo2 = "";
		String message = "";
		long aadhaarNo = 0;
		boolean massageStatus = false;
		boolean addressStatus = true;
		boolean aadharNoStatus = false;
		boolean duplicateRegStatus = false;

		String rsbyCardNo = null;
		int rsbyCardPkgScheme = 0;

		String hinNoRequest = request.getParameter("hinNo2");
		if (hinNoRequest != null) {
			hinNo2 = hinNoRequest;
		}

		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
 
		String uploadURL = userHome + fileSeparator + "uploadedImage" + fileSeparator + hinNo2 + fileSeparator;
		LOGGER.debug("uploadURL : " + uploadURL);

		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		LOGGER.debug("resourcePath : " + resourcePath);
		String localityName = null;
		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading adt.properties" + ioException.getStackTrace().toString());
		}

		String hinNo = "";

		String newborn = "";
		Users userObj = new Users();
		if (request.getParameter("nbb") != null && !request.getParameter("nbb").equals("")) {
			newborn = request.getParameter("nbb");
		}

		Patient patient = new Patient();
		patient.setNewBornBaby(newborn);

		synchronized (this) {

			Map<String, Object> objectMap = new HashMap<String, Object>();
			int userId = (Integer) session.getAttribute("userId");
			userObj.setId(userId);
			LOGGER.debug("userId : " + userId);

			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			objectMap.put("hospitalId", hospitalId);
			LOGGER.debug("hospitalId : " + hospitalId);

			patient.setAddEditBy(userObj);

			String changedDate = request.getParameter(CHANGED_DATE);
			if (changedDate != null) {
				patient.setAddEditDate(HMSUtil.convertStringTypeDateToDateType(changedDate));
			}

			/*String changedTime = request.getParameter(CHANGED_TIME);
			if (changedTime != null) {
				patient.setAddEditTime(changedTime);
			}*/

			
			String nationDob = request.getParameter("NationDob");
			if (nationDob != null && !(nationDob.equals(""))) {
				patient.setNotionalDobStatus(nationDob);
			}

			String validUpTo = request.getParameter("validUpTo");
			if (validUpTo != null && !(validUpTo.equals(""))) {
				patient.setCardValidDate(HMSUtil.convertStringTypeDateToDateType(validUpTo));
			}

			String radio1 = request.getParameter("radio1");
			String radio2 = request.getParameter("radio2");

			if (radio1 != null) {
				if (radio1.equals("aadhaar")) {
					if(radio2 !=null){
						if(radio2.equals("qrScan")){
							String qpAdhaarNumber = request.getParameter(Q_P_AADHAAR_NUMBER);
							if (qpAdhaarNumber != null && !qpAdhaarNumber.equals("")) {
								aadhaarNo=Long.parseLong(qpAdhaarNumber);
								patient.setAadhaarNo(aadhaarNo);
								aadharNoStatus = true;
								objectMap.put("aadhaarNo", qpAdhaarNumber);
								objectMap.put("aadharNoStatus", aadharNoStatus);

							}else if(request.getParameter("ePAadhaarNumber")!=null && !request.getParameter("ePAadhaarNumber").equals("")){
								qpAdhaarNumber = request.getParameter("ePAadhaarNumber");   // Added By Srikanth 07/02/2018
								aadhaarNo=Long.parseLong(qpAdhaarNumber);
								patient.setAadhaarNo(aadhaarNo);
								aadharNoStatus = true;
								objectMap.put("aadhaarNo", qpAdhaarNumber);
								objectMap.put("aadharNoStatus", aadharNoStatus);
							}
						}
						else{
							String epAdhaarNumber = request.getParameter(E_P_AADHAAR_NUMBER);
							if (epAdhaarNumber != null && !epAdhaarNumber.equals("")) {
								aadhaarNo = Long.parseLong(epAdhaarNumber);
								patient.setAadhaarNo(aadhaarNo);
								aadharNoStatus = true;

							}
							objectMap.put("aadhaarNo", epAdhaarNumber);
							objectMap.put("aadharNoStatus", aadharNoStatus);
						}
						regDataMap.put("aadhaarNo", aadhaarNo);
					}else{
						objectMap.put("aadhaarNo", request.getParameter("aadhaarNo"));
						objectMap.put("aadharNoStatus", true);
					}
				} else if (radio1.equals("otherId")) {
					addressStatus = false;

					String otherIdCard = request.getParameter("otherIdCard");
					if (otherIdCard != null && !otherIdCard.equals("")) {
						int otherId = Integer.parseInt(otherIdCard);
						idCard.setId(otherId);
						patient.setIdCard(idCard);
						regDataMap.put("otherId", otherId);

					}

					String otherIdCardNumber = request.getParameter("otherIdCardNumber");
					if (otherIdCardNumber != null && !otherIdCardNumber.equals("")) {
						patient.setIdNo(otherIdCardNumber);
						regDataMap.put("otherIdNum", otherIdCardNumber);
					}
				} else {
					if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equals("yes")){
						if(request.getParameter("aadhaarNo")!=null && !request.getParameter("aadhaarNo").equals("")){
							aadhaarNo = Long.parseLong(request.getParameter("aadhaarNo"));
							patient.setAadhaarNo(aadhaarNo);
							regDataMap.put("aadhaarNo", aadhaarNo);
							objectMap.put("aadhaarNo", aadhaarNo);
							LOGGER.debug("aadhaar no : "+aadhaarNo);
						}
					}
					addressStatus = false;
				}
			}

			boolean duplicateRegisterStatus = registrationHandlerService.checkDuplicateRegistraiton(regDataMap);
			LOGGER.debug("duplicateRegisterStatus : " + duplicateRegisterStatus);

			if (!duplicateRegisterStatus) {

				String memberID = request.getParameter("memberID");
				if (memberID != null && !memberID.equals("")) {
					PhMemberSurvey phmember = new PhMemberSurvey();
					phmember.setId(Integer.parseInt(memberID));
					patient.setMember(phmember);
				}

				String bloodGroupValueId = request.getParameter("bloodGroupValueId");
				if (bloodGroupValueId != null && !bloodGroupValueId.equals("")) {
					patient.setBloodGroupValue(bloodGroupValueId);
				}

				String familyID = request.getParameter("familyID");
				if (familyID != null && !familyID.equals("") && !familyID.equals(" ") && !familyID.equals("0")
						&& !familyID.equals("null")) {

					PhFamilySurvey phfamily = new PhFamilySurvey();
					phfamily.setId(Integer.parseInt(familyID));
					patient.setFamily(phfamily);
				}

				String pFullName = request.getParameter(P_FULL_NAME);
				if (pFullName != null && !pFullName.equals("")) {
					patient.setFullName(pFullName);
					patient.setPFirstName(pFullName);
				}

				String relationId = request.getParameter(RELATION_ID);
				if (relationId != null && !relationId.equals("")) {
					MasRelation relation = new MasRelation();
					relation.setId(Integer.parseInt(relationId));
					patient.setRelation(relation);
				}

				String relationName = request.getParameter(RELATION_NAME);
				if (relationName != null && !relationName.equals("")) {
					patient.setFatherMotherName(relationName);
				}

				String gender = request.getParameter(GENDER);
				if (gender != null && !gender.equals("")) {
					MasAdministrativeSex sex = new MasAdministrativeSex();
					sex.setId(Integer.parseInt(gender));
					patient.setSex(sex);
				}

				if (request.getParameter("bloodGroupId") != null && !request.getParameter("bloodGroupId").equals("")) {
					int bloodGroupId = Integer.parseInt(request.getParameter("bloodGroupId"));
					MasBloodGroup masBloodGroup = new MasBloodGroup();
					masBloodGroup.setId(bloodGroupId);
					patient.setBloodGroup(masBloodGroup);

					if (request.getParameter("bloodGroupName") != null
							&& !request.getParameter("bloodGroupName").equals("")) {
						patient.setBloodGroupValue(request.getParameter("bloodGroupName"));
					}

					patient.setVerbalStatus("y");
				}

				String dob = request.getParameter(DATE_OF_BIRTH);
				if (dob != null && !dob.equals("")) {
					String citizenSearch = request.getParameter("citizenSearch");
					Date dateOfBirth = null;
					if (null != citizenSearch && citizenSearch.equalsIgnoreCase("citizen") && !citizenSearch.equals("")) {
						dateOfBirth = HMSUtil.dateFormatterToDDMMYYYY(dob);
					} else {
						dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(dob);
					}
					patient.setDateOfBirth(dateOfBirth);
				}
				String yob = request.getParameter(YOB);
				if (yob != null && !yob.equals("")) {
					patient.setYearOfBirth(yob.trim());
				}

				String ageWithUnit = "";
				String age = request.getParameter(AGE);
				if (age != null && !age.equals("")) {

					String ageUnit = request.getParameter(AGE_UNIT);
					if (ageUnit != null) {
						ageWithUnit = age.concat(" ").concat(ageUnit);
						patient.setAge(ageWithUnit);
						patient.setPatientAge(Integer.valueOf(age.trim()));
					}
					String tempageUnitId = request.getParameter("tempageUnitId");
					if (tempageUnitId != null && !tempageUnitId.equals("")) {
						ageWithUnit = age.concat(" ").concat(tempageUnitId);
						patient.setAge(ageWithUnit);
					}
				}

				String aadhaarVerifyStatus = request.getParameter("aadhaarVerifyStatus");
				if (!aadhaarVerifyStatus.equals("")) {
					patient.setAadhaarVerifyStatus("y");
				} else {
					patient.setAadhaarVerifyStatus("n");
				}

				String bplStatus = request.getParameter(BPL_STATUS);
				if (bplStatus != null && bplStatus.equals("bpl")) {
					patient.setBplStatus("y");
					String bplNumber = request.getParameter("bplTextbox");
					if (bplNumber!=null && !bplNumber.equals("")) {
						patient.setBplnumber(bplNumber);
					}
				}

				if (bplStatus != null && bplStatus.equals("apl")) {
					patient.setBplStatus("n");
				}

				String motherHinNo = "";
				String motherUHID = request.getParameter("motherUHID");
				if (motherUHID != null) {
					patient.setMotherHinNo(motherUHID);
				}

				String patientTypeId = request.getParameter(PATIENT_TYPE_ID);
				if (patientTypeId != null && !patientTypeId.equals("0")) {
					MasPatientType masPatientType = new MasPatientType();
					masPatientType.setId(Integer.parseInt(patientTypeId));
					patient.setPatientType(masPatientType);
				}
				
				String patientSchemeId = request.getParameter("patientScheme"); 
				if(patientSchemeId!=null && !patientSchemeId.equals("0")){
					MasScheme scheme = new MasScheme();
					scheme.setId(Integer.parseInt(patientSchemeId));
					patient.setScheme(scheme);
				}
				String ad = request.getParameter("ad");
				PatientAddress pAadhaarAddr = new PatientAddress();
				if (ad != null) {
					MasAddressType masAddrType = new MasAddressType();
					masAddrType.setId(Integer.parseInt(properties.getProperty("aadhaarAddressTypeId")));
					pAadhaarAddr.setAddressType(masAddrType);

					if (ad.equalsIgnoreCase("y")) {

						String houseName = request.getParameter(HOUSE_NAME);
						if (HMSUtil.isNotNull(houseName)) {
							pAadhaarAddr.setHouseNo(houseName);
						}

						String streetName = request.getParameter(STREET_NAME);
						if (streetName != null && !streetName.trim().equals("")) {
							pAadhaarAddr.setStreetRoad(streetName);
						}
						String village = request.getParameter(VILLAGE);
						if (village != null && !village.trim().equals("")) {
							MasVillage masVillage = new MasVillage();
							masVillage.setId(Integer.parseInt(village));
							pAadhaarAddr.setVillage(masVillage);
						}
						String aDistrict = request.getParameter(A_DISTRICT);
						if (aDistrict != null && !aDistrict.trim().equals("")) {
							MasDistrict masDist = new MasDistrict();
							masDist.setId(Integer.parseInt(aDistrict));
							pAadhaarAddr.setDistrict(masDist);
						} else if (request.getParameter("permanentDistrict") != null
								&& !request.getParameter("permanentDistrict").equals("")) {
							int districtId = Integer.parseInt(request.getParameter("permanentDistrict"));

							MasDistrict masDist = new MasDistrict();
							masDist.setId(districtId);
							pAadhaarAddr.setDistrict(masDist);
						}
						String aTaluk = request.getParameter(A_TALUK);
						if (aTaluk != null && !aTaluk.trim().equals("")) {
							MasTaluk masSubDistrict = new MasTaluk();
							masSubDistrict.setId(Integer.parseInt(aTaluk));
							pAadhaarAddr.setTaluk(masSubDistrict);
						}
						int postCodeId = 0;
						String aPostOffice = request.getParameter(A_POST_OFFICE);
						if (aPostOffice != null && !aPostOffice.trim().equals("")) {
							postCodeId = Integer.parseInt(aPostOffice);
							if (postCodeId > 0) {
								MasPostCode masPostCode = new MasPostCode();
								masPostCode.setId(postCodeId);
								pAadhaarAddr.setPostOffice(masPostCode);
							}
						} else if (request.getParameter(P_POST_OFFICE) != null
								&& !request.getParameter(P_POST_OFFICE).equalsIgnoreCase(" ")
								&& !request.getParameter(P_POST_OFFICE).equalsIgnoreCase("0")
								&& !request.getParameter(P_POST_OFFICE).equalsIgnoreCase("")) {
							postCodeId = Integer.parseInt(request.getParameter(P_POST_OFFICE));
							if (postCodeId > 0) {
								MasPostCode masPostCode = new MasPostCode();
								masPostCode.setId(postCodeId);
								pAadhaarAddr.setPostOffice(masPostCode);
							}
						}
						String aPinCode = request.getParameter(A_PINCODE);
						if (aPinCode != null && !aPinCode.trim().equals("")) {
							pAadhaarAddr.setPinCode(Long.parseLong(aPinCode));
						} else if (request.getParameter(P_PINCODE) != null
								&& !request.getParameter(P_PINCODE).equals("")) {
							long pinCode = Long.parseLong(request.getParameter(P_PINCODE));
							pAadhaarAddr.setPinCode(pinCode);
						}
					}
					objectMap.put("pAadhaarAddr", pAadhaarAddr);
				}

				MasAddressType masAddrType = new MasAddressType();
				masAddrType.setId(Integer.parseInt(properties.getProperty("permanentAddressTypeId")));
				PatientAddress pPermAddr = new PatientAddress();
				pPermAddr.setAddressType(masAddrType);

				String permAddr = request.getParameter("permAddr");
				if (permAddr != null && !permAddr.equals("")) {
					if (permAddr.equalsIgnoreCase("y")) {
						String pLsgName = request.getParameter(P_LSG_NAME);
						if (pLsgName != null && !pLsgName.trim().equals("")) {
							MasLsg masLsgName = new MasLsg();
							masLsgName.setId(Integer.parseInt(pLsgName));
							pPermAddr.setLsgName(masLsgName);
						}
						String pWard = request.getParameter(P_WARD);
						if (pWard != null && !pWard.equals("")) {
							pPermAddr.setWardName(pWard);
						}
						String pWardId = request.getParameter(P_WARD_ID);
						if (pWardId != null && !pWardId.equals("")) {
							MasWard ward = new MasWard();
							ward.setId(Integer.parseInt(pWardId));
							pPermAddr.setWardNo(ward);
						}
						
						String pLocality = request.getParameter(P_LOCALITY);
						if (pLocality != null && !pLocality.equals("")) {
							PhMasLocality masLocality = new PhMasLocality();
							masLocality.setId(Integer.parseInt(pLocality));
							pPermAddr.setLocality(masLocality);
						}else if(request.getParameter("locality") !=null && !request.getParameter("locality").equals("")){
							localityName=(String)request.getParameter("locality");
						}
						String pLsgHouseNo = request.getParameter(P_LSG_HOUSE_NO);
						if (pLsgHouseNo != null && !pLsgHouseNo.equals("")) {
							pPermAddr.setLsgHouseNo(pLsgHouseNo);
						}
						String pHouseNo = request.getParameter(P_HOUSE_NO);
						if (pHouseNo != null && !pHouseNo.equals("")) {
							pPermAddr.setHouseNo(pHouseNo);
						}
						String pHealthHouseId = request.getParameter(P_HEALTH_HOUSE_ID);
						if (pHealthHouseId != null && !pHealthHouseId.equals("")) {
							pPermAddr.setHealthHouseId(pHealthHouseId);
						}

						String permanantDistrict = request.getParameter("permanentDistrict");
						if (permanantDistrict != null && !permanantDistrict.equals("")) {

							MasDistrict masDist = new MasDistrict();
							masDist.setId(Integer.parseInt(permanantDistrict));
							pPermAddr.setDistrict(masDist);
						}
						String pTaluk = request.getParameter(P_TALUK);
						if (pTaluk != null && !pTaluk.equals("")) {
							MasTaluk subDistrict = new MasTaluk();
							subDistrict.setId(Integer.parseInt(pTaluk));
							pPermAddr.setTaluk(subDistrict);
						}
						String pPostOffice = request.getParameter(P_POST_OFFICE);
						if (pPostOffice != null && !pPostOffice.equalsIgnoreCase("")
								&& !pPostOffice.equalsIgnoreCase("0") && !pPostOffice.equalsIgnoreCase("")) {

							int postCodeId = Integer.parseInt(pPostOffice);
							if (postCodeId > 0) {
								MasPostCode masPostCode = new MasPostCode();
								masPostCode.setId(postCodeId);
								pPermAddr.setPostOffice(masPostCode);
							}
						}
						String pPinCode = request.getParameter(P_PINCODE);
						if (pPinCode != null && !pPinCode.equals("")) {
							pPermAddr.setPinCode(Long.parseLong(pPinCode));
						}
					}
					objectMap.put("pPermAddr", pPermAddr);
				}

				MasAddressType mastAddrType = new MasAddressType();
				mastAddrType.setId(Integer.parseInt(properties.getProperty("temporaryAddressTypeId")));

				PatientAddress pTempAddr = new PatientAddress();
				pTempAddr.setAddressType(mastAddrType);

				if (request.getParameter("pTempAddr") != null && !request.getParameter("pTempAddr").equals("")) {

					if (request.getParameter("pTempAddr").equalsIgnoreCase("y")) {

						String tLsgName = request.getParameter(T_LSG_NAME);
						if (tLsgName != null && !tLsgName.equals("")) {
							MasLsg masLsgName = new MasLsg();
							masLsgName.setId(Integer.parseInt(tLsgName));
							pTempAddr.setLsgName(masLsgName);
						}
						String tWard = request.getParameter(T_WARD);
						if (tWard != null && !tWard.equals("")) {
							pTempAddr.setWardName(tWard);
						}
						String tLocality = request.getParameter(T_LOCALITY);
						if (tLocality != null && !tLocality.equals(" ")) {
							PhMasLocality masLocality = new PhMasLocality();
							masLocality.setId(Integer.parseInt(tLocality));
							pPermAddr.setLocality(masLocality);
						}
						String tLsgHouseNo = request.getParameter(T_LSG_HOUSE_NO);
						if (tLsgHouseNo != null && !tLsgHouseNo.equals("")) {
							pTempAddr.setLsgHouseNo(tLsgHouseNo);
						}
						String tHouseNo = request.getParameter(T_HOUSE_NO);
						if (tHouseNo != null && !tHouseNo.equals("")) {
							pTempAddr.setHouseNo(tHouseNo);
						}
						String tHealthHouseId = request.getParameter(T_HEALTH_HOUSE_ID);
						if (tHealthHouseId != null && !tHealthHouseId.equals("")) {
							pTempAddr.setHealthHouseId(tHealthHouseId);
						}

						String tDistrict = request.getParameter(T_DISTRICT);
						if (tDistrict != null && !tDistrict.equals(" ")) {
							MasDistrict masDist = new MasDistrict();
							masDist.setId(Integer.parseInt(tDistrict));
							pTempAddr.setDistrict(masDist);

						}
						String tTaluk = request.getParameter(T_TALUK);
						if (tTaluk != null && !tTaluk.equals("")) {
							MasTaluk taluk = new MasTaluk();
							taluk.setId(Integer.parseInt(tTaluk));
							pTempAddr.setTaluk(taluk);
						}

						String tpostOffice = request.getParameter(T_POST_OFFICE);
						if (tpostOffice != null && !tpostOffice.equalsIgnoreCase("")
								&& !tpostOffice.equalsIgnoreCase(" ")) {
							int postCodeId = 0;
							postCodeId = Integer.parseInt(tpostOffice);
							if (postCodeId > 0) {
								MasPostCode masPostCode = new MasPostCode();
								masPostCode.setId(postCodeId);
								pTempAddr.setPostOffice(masPostCode);
							}
						}
						String tPinCode = request.getParameter(T_PINCODE);
						if (tPinCode != null && !tPinCode.equals("")) {
							pTempAddr.setPinCode(Long.parseLong(tPinCode));
						}
					}
					objectMap.put("pTempAddr", pTempAddr);
				}

				String foreigner = properties.getProperty("foreigner");
				String fromOtherIndianStates = properties.getProperty("fromOtherIndianStates");
				String nativer = properties.getProperty("nativer");
				String nativeDdd = request.getParameter("nativeddd");
				if (nativeDdd != null) {
					if (nativeDdd.equals("native")) {
						patient.setNativityType(nativer);
						String nativity = request.getParameter("nativity");
						if (nativity != null && !nativity.equals("") && nativity.equals("resident")) {
							String resident = request.getParameter("resident");
							patient.setNativity(resident);
						} else if (nativity != null && !nativity.equals("") && nativity.equals("nrk")) {

							String nrk = request.getParameter("nrk");
							patient.setNativity(nrk);

							String nrkState = request.getParameter(NRK_STATE);
							if (nrkState != null && !nrkState.equals("")) {
								MasState mState = new MasState();
								mState.setId(Integer.parseInt(nrkState));
								patient.setState(mState);
							}
						} else {
							String nri = request.getParameter("nri");
							patient.setNativity(nri);
							String nriNationality = request.getParameter(NRI_NATIONALITY);
							if (nriNationality != null && !nriNationality.equals("")) {
								MasCountry nationality = new MasCountry();
								nationality.setId(Integer.parseInt(nriNationality));
							}
						}
					} else if (request.getParameter("otherState").equals("otherState")) {

						patient.setNativityType(fromOtherIndianStates);
						String migrantState = request.getParameter(MIGRANT_STATE);
						if (migrantState != null && !migrantState.equals("")) {
							MasState mState = new MasState();
							mState.setId(Integer.parseInt(migrantState));
							patient.setState(mState);
						}
						String migrantDistrict = request.getParameter(MIGRANT_DISTRICT);
						if (migrantDistrict != null && !migrantDistrict.equals("")) {
							MasDistrict masDist = new MasDistrict();
							masDist.setId(Integer.parseInt(migrantDistrict));
							pTempAddr.setDistrict(masDist);
						}
						String migrantPurpose = request.getParameter(MIGRANT_PURPOSE);
						if (migrantPurpose != null && !migrantPurpose.equals("")) {
							MasOccupation masOccupation = new MasOccupation();
							masOccupation.setId(Integer.parseInt(migrantPurpose));
							patient.setOccupation(masOccupation);
						}
					} else {
						if (request.getParameter("foreigner").equals("foreigner")) {

							patient.setNativityType(foreigner);

							String foreignNationality = request.getParameter(FOREIGNER_NATIONALITY);
							if (foreignNationality != null && !foreignNationality.equals(" ")) {
								MasCountry nationality = new MasCountry();
								nationality.setId(Integer.parseInt(foreignNationality));
							}
							String foreignerPurpose = request.getParameter(FOREIGNER_PURPOSE);
							if (foreignerPurpose != null && !foreignerPurpose.equals(" ")) {
								MasOccupation masOccupation = new MasOccupation();
								masOccupation.setId(Integer.parseInt(foreignerPurpose));
								patient.setOccupation(masOccupation);
							}
							String passportNumber = request.getParameter(PASSPORTNUMBER);
							if (passportNumber != null && !passportNumber.equals("")) {
								patient.setPassportNo(passportNumber);
							}
							String visaType = request.getParameter(VISA_TYPE);
							if (visaType != null && !visaType.equals(" ")) {
								MasVisaType masVisaType = new MasVisaType();
								masVisaType.setId(Integer.parseInt(visaType));
								patient.setVisaType(masVisaType);
							}
							String visaFromDate = request.getParameter(VISA_FROMDATE);
							if (visaFromDate != null && !visaFromDate.equals("")) {
								patient.setVisaFrom(HMSUtil.dateFormatterDDMMYYYY(visaFromDate));
							}
							String visaToDate = request.getParameter(VISA_TODATE);
							if (visaToDate != null && !visaToDate.equals("")) {
								patient.setVisaTo(HMSUtil.dateFormatterDDMMYYYY(visaToDate));
							}
						}
					}
				}

				String otherCategory = request.getParameter(OTHER_CATEGORY);
				if (otherCategory != null && !otherCategory.equals("0")) {
					String[] othercategoryList = request.getParameterValues(OTHER_CATEGORY);
					objectMap.put("othercategoryList", othercategoryList);

				}

				String occupationId = request.getParameter(OCCUPATION_ID);
				if (occupationId != null && !occupationId.trim().equals("")) {
					MasOccupation masOccupation = new MasOccupation();
					masOccupation.setId(Integer.parseInt(occupationId));
					patient.setOccupation(masOccupation);
				}
				String mobileNoVerify = request.getParameter("mobileNoVerify");
				if (mobileNoVerify != null && !mobileNoVerify.equals("")) {
					patient.setMobileNumber(mobileNoVerify);
				}
				String emailId = request.getParameter(EMAIL_ID);
				if (emailId != null && !emailId.equals("")) {
					patient.setEmailId(emailId);
				}

				String education = request.getParameter(EDUCATION);
				if (education != null && !education.trim().equals("")) {
					MasQualification masQualification = new MasQualification();
					masQualification.setId(Integer.parseInt(education));
					patient.setEducation(masQualification);
				}
				patient.setPatientStatus("Out Patient");

				Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
				String currentTime = (String) utilMap.get("currentTime");

				patient.setRegDate(new Date());
				patient.setRegTime(currentTime);
				patient.setAddEditTime(currentTime);

				String monIncome = request.getParameter("monIncome");
				if (null != monIncome && !monIncome.equals("")) {
					patient.setMonthlyIncome(new BigDecimal(monIncome));
				}

				String hinName = "";

				// added by amit das on 05-05-2016
				rsbyCardNo = request.getParameter("rsbyCardNo");

				if (request.getParameter("rsbyCardPkgScheme") != null
						&& !request.getParameter("rsbyCardPkgScheme").trim().equals("")) {
					rsbyCardPkgScheme = Integer.parseInt(request.getParameter("rsbyCardPkgScheme"));
				}

				if (rsbyCardNo != null && !rsbyCardNo.trim().equals("")) {
					patient.setRsbyCardNo(rsbyCardNo);
				}
				objectMap.put("localityName", localityName);
				objectMap.put("patient", patient);
				objectMap.put("motherHinNo", motherHinNo);
				objectMap.put("pAadhaarAddr", pAadhaarAddr);
				objectMap.put("pPermAddr", pPermAddr);
				objectMap.put("pTempAddr", pTempAddr);
				objectMap.put("uploadURL", uploadURL);
				objectMap.put("hinNo2", hinNo2);
				objectMap.put("addressStatus", addressStatus);
				objectMap.put("hospitalId", hospitalId);
				objectMap.put("rsbyCardPkgScheme", rsbyCardPkgScheme); // added
																		// by
																		// amit
																		// das
																		// on
																		// 05-05-2016

				Map<String, Object> detailsMap = registrationHandlerService.submitPatientInformation(objectMap);

				hinNo = (String) detailsMap.get("hinNo");

				List<Patient> existingHinNoList = new ArrayList<Patient>();
				if (detailsMap.get("existingHinNoList") != null) {
					existingHinNoList = (List<Patient>) detailsMap.get("existingHinNoList");
				}

				boolean successfullyAdded = false;
				if (detailsMap.get("succesfullyAdded") != null) {
					successfullyAdded = (Boolean) detailsMap.get("succesfullyAdded");
				}

				if (successfullyAdded && existingHinNoList.size() == 0) {

					// Start of Create patient visit at the time of patient
					// registration

					Map<String, Object> visitMap = new HashMap<String, Object>();
					if (!visitMap.isEmpty()) {
						visitMap.clear();
					}

					String[] departmentIdlist = null;
					String[] nonClinicaldepartmentIdlist = null;

					int hinId = 0;
					ArrayList<String> serviceCentreList = new ArrayList<String>();

					String[] patientDepartment = request.getParameterValues(PATIENT_DEPARTMENT);
					if (patientDepartment != null && patientDepartment.length != 0) {

						departmentIdlist = patientDepartment;
						for (String s : departmentIdlist) {
							if (!s.equals("0")) {
								serviceCentreList.add(s);
							}
						}
					}

					String[] nonclinicalDeprtment = request.getParameterValues("nonclinicalDeprtment");
					if (nonclinicalDeprtment != null && nonclinicalDeprtment.length != 0) {
						nonClinicaldepartmentIdlist = nonclinicalDeprtment;
						for (String s : nonClinicaldepartmentIdlist) {
							serviceCentreList.add(s);
						}
					}

					Object patientHinId = detailsMap.get("patientHinId");
					if (null != serviceCentreList && serviceCentreList.size() > 0) {
						if (patientHinId != null) {
							hinId = (Integer) patientHinId;
						}
						visitMap.put("hinId", hinId);
						visitMap.put("userObj", userObj); // added by amit das
															// in 17-11-2016
						visitMap.put("age", ageWithUnit);

						String priorityName = request.getParameter("priorityName");
						if (priorityName != null && !priorityName.equals("")) {
							visitMap.put("currentPriority", Integer.parseInt(priorityName));
						}

						String loddrs = request.getParameter("loddrs");
						if (loddrs != null && !loddrs.equals("")) {
							visitMap.put("dutyDoctorId", Integer.parseInt(loddrs));
						}

						int unitId = 0;
						String unit = request.getParameter("unit");
						if (unit != null && !unit.equals("")) {

							unitId = Integer.parseInt(unit);
							visitMap.put("unitId", unitId);
							// Added by Arbind on 21-05-2017
							String patiaientDepartment = request.getParameter(PATIENT_DEPARTMENT);
							if (null != patiaientDepartment && !patiaientDepartment.equals("0")) {
								session.setAttribute(Integer.parseInt(patiaientDepartment) + "unit", unitId);
							}

						}

						String complaintId = request.getParameter(COMPLAINT_ID);
						if (complaintId != null && !complaintId.equals("0")) {
							visitMap.put("complaintId", Integer.parseInt(complaintId));
						}

						String visitDate = request.getParameter(VISIT_DATE);
						if (visitDate != null && !visitDate.equals("")) {
							visitMap.put("visitDate", HMSUtil.convertStringTypeDateToDateType(visitDate));

						}

						String visitTime = request.getParameter(VISIT_TIME);
						if (visitTime != null && !visitTime.equals("")) {
							visitMap.put("visitTime", visitTime);
						}

						String opsession = request.getParameter("opsession");
						if (opsession != null && !opsession.equals("")) {
							visitMap.put("opsessionId", Integer.parseInt(opsession));
						}

						String cashReceived = "n";
						if (null != request.getParameter("cashreceived")
								&& request.getParameter("cashreceived").equals("y")) {

							cashReceived = request.getParameter("cashreceived");

						}

						visitMap.put("cashReceived", cashReceived);
						// added by arbind on 10-02-2017
						String cashReason = request.getParameter("cashReason");
						if (null != cashReason && !cashReason.equals("")) {
							visitMap.put("cashNotReceivedReason", cashReason);
						}

						// added by arbind on 10-02-2017 end
						visitMap.put("departmentIdlist", serviceCentreList);
						visitMap.put("hospitalId", hospitalId);
						String visitNumber = request.getParameter(VISIT_NUMBER);
						if (visitNumber != null) {
							LOGGER.debug("currentVisitNo : " + Integer.parseInt(visitNumber) + 1);
							visitMap.put("currentVisitNo", Integer.parseInt(visitNumber) + 1);

						}
						visitMap.put("hinId", hinId);
						String hospitalCode = (String) session.getAttribute("hospitalCode");
						visitMap.put("hospitalCode", hospitalCode);

						detailsMap = registrationHandlerService.saveVisitInformation(visitMap);
						LOGGER.debug("Visist Information Saved..");
						map.put("departmentId", serviceCentreList);
					}
					if(patientHinId!=null)
						map.put("hinId", (Integer)patientHinId);
					map.put("hospitalId", hospitalId);
					if(hinNo!=null)
						map.put("hinNo", hinNo);

					// End

					massageStatus = true;
					message = " Registration Information saved Successfully.UHID  is " + hinNo
							+ ". Do you want to print ?";
					map.put("hinNo", hinNo);

				} else if (existingHinNoList.size() > 0) {
					message = "Data can not be saved.This " + hinName + " is already exists.";
				} else {
					message = "Some problem Occured! Try Again.";
				}
			} else {
				duplicateRegStatus = true;
				LOGGER.debug("duplicateRegStatus : " + duplicateRegStatus);
				message = "Data can not be saved.This Patient is already exists.";
				map.put("duplicateRegStatus", duplicateRegStatus);
			}
		}
		String backUrl = "/hms/hms/registration?method=showRegistrationJsp";
		map.put("backUrl", backUrl);
		map.put("massageStatus", massageStatus);

		// added by govind 1-12-2016
		String mobileno = "", pname = "";
		if (request.getParameter(MOBILE_NO) != null) {
			mobileno = request.getParameter(MOBILE_NO);
			map.put("mobileno", mobileno);
		}
		if (request.getParameter(P_FULL_NAME) != null) {
			pname = request.getParameter(P_FULL_NAME);
			map.put("pname", pname);
		}
		// added by govind 1-12-2016 end
		if(request.getParameter("quickRegistration")!=null && request.getParameter("quickRegistration").equals("yes")){
			map.put("quickRegistration", "yes");
		}
		map.put("contentJsp", MSG_FOR_REG);
		map.put("message", message);
		map.put("flag", "reg");
		map.put("pname", pname);
		map.put("mobileno", mobileno);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showMsgForRegJsp(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside showMsgForRegJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String patienthinNo = request.getParameter("patientHinNo");
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		map = registrationHandlerService.showMsgForReg(deptId);
		map.put("hinNo", patienthinNo);
		map.put("contentJsp", MSG_FOR_REG);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Method to Open otp Jsp
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showOPTjsp(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside showOPTjsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String opt = "";
		if (null != map.get("opt")) {
			opt = (String) map.get("opt");
		}
		map.put("opt", opt);
		String jsp = "otp";

		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	public void verifyMobileNum(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		LOGGER.debug("Inside verifyMobileNum ");
		String mobileNumber = "";
		if (request.getParameter("mobileNumber") != null) {
			mobileNumber = request.getParameter("mobileNumber");
			LOGGER.debug("mobileNumber : " + mobileNumber);
		}

		String otp = "";
		if (request.getParameter("otp") != null) {
			otp = request.getParameter("otp");
		}
		LOGGER.debug("otp : " + otp);
		Map<String, Object> map = registrationHandlerService.getOneTimePassword(mobileNumber, otp);

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		boolean status = false;
		if (null != map.get("status")) {
			status = (Boolean) map.get("status");
		}
		String message = "";
		LOGGER.debug("status : " + status);
		if (status) {
			message = "Verified";
			sb.append("<Verified>" + status + "</Verified>");
		} else {
			message = "Not Verified";
			sb.append("<Verified>" + status + "</Verified>");
		}
		map.put("message", message);
		map.put("status", status);
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/*
	 * get No of validity Days from table Code By Mukesh Narayan Singh Date 7
	 * July 2010
	 */
	/*
	 * Code for pop attachment of patient image code by Mukesh Narayan Singh
	 * date 04 Oct 2010
	 */
	public ModelAndView displayRegisPhoto(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside displayRegisPhoto ");
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		map = registrationHandlerService.displayRegisPhoto(hinNo);
		String jsp = REG_PHOTO_POPUP_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * Code for save patient image code by Mukesh Narayan Singh date 04 Oct 2010
	 */
	public ModelAndView addPhotoFile(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside addPhotoFile ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		HttpSession session = request.getSession();

		LOGGER.debug("MultipartFormDataRequest.isMultipartFormData(request) : "
				+ MultipartFormDataRequest.isMultipartFormData(request));
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException uploadException) {
				LOGGER.error("UploadException while creating MultipartFormDataRequest object"
						+ uploadException.getStackTrace().toString());
			} catch (IOException ioException) {
				LOGGER.error("Error while creating MultipartFormDataRequest object"
						+ ioException.getStackTrace().toString());
			}
		}

		String hinNo = "";
		if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("")) {
			int hinId = Integer.parseInt(mrequest.getParameter(HIN_ID));
			generalMap.put("hinId", hinId);
		}
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			generalMap.put("hinNo", hinNo);
		}
		String age = request.getParameter("age");
		if (age != null && !age.equals("")) {
			generalMap.put("age", age);
		}
		String address = request.getParameter("addrress");
		if (address != null && !request.getParameter("address").equals("")) {
			generalMap.put("addrress", address);
		}
		String gender = request.getParameter("gender");
		if (gender != null && !!gender.equals("")) {
			generalMap.put("gender", gender);
		}

		Users user = new Users();
		synchronized (session) {
			user = (Users) session.getAttribute("users");
			generalMap.put("userName", user.getUserName());
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			generalMap.put("hospitalId", hospitalId);
		}

		String filename = "";
		if (request.getParameter("filename") != null) {
			filename = request.getParameter("filename");
		}
		generalMap.put("filename", filename);

		String uploadURL = null;
		if (request.getParameter("uploadURL") != null) {
			uploadURL = request.getParameter("uploadURL");
		}
		generalMap.put("uploadURL", uploadURL);

		map = registrationHandlerService.addPhotoFile(generalMap);
		String jsp = REG_PHOTO_POPUP_JSP;
		jsp += ".jsp";
		map.put("filename", filename);
		map.put("hinNo", hinNo);
		map.put("contentJsp", jsp);

		return new ModelAndView("indexB", "map", map);
	}

	public void calculateRegistrationDaysInAjax(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside calculateRegistrationDaysInAjax ");
		Box box = HMSUtil.getBox(request);

		try {
			int patientTypeId = Integer.parseInt(box.get("patientTypeId"));
			int cardDays = registrationHandlerService.getPatientTypeValidityDays(patientTypeId);
			LOGGER.debug("cardDays : " + cardDays);

			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<age>" + cardDays + "</age>");
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to response object " + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView printRegistrationCardAfterUpdate(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside printRegistrationCardAfterUpdate ");
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = registrationHandlerService.getConnectionForReport();
		String hinName = properties.getProperty("com.jkt.hms.registration_no");
		LOGGER.debug("hin_name : " + hinName);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("hinNo", hinNo);

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("hinNo", hinNo);
		parameters.put("hin_name", hinName);
		parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("PATIENT_IMAGE",
				getServletContext().getRealPath("/uploadedImage/" + hinNo + "/" + hinNo + ".jpg"));
		parameters.put("HOSPITAL_ID", hospitalId);
		String reportName = "RegistrationCard";
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	/**
	 * Print the registration card for patient
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView printRegistrationCard(final HttpServletRequest request, final HttpServletResponse response) {
		//
		Map<String, Object> dMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int hospitalId = 0;
		String hinNo = "";
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			parameters.put("hinNo", hinNo);
		}

		Patient patient = new Patient();
		String patientHinIdStr = request.getParameter("patientHinId");
		int patientHinId =0;
		if (null != patientHinIdStr && !patientHinIdStr.equals("")) {
			patientHinId=Integer.parseInt(patientHinIdStr);
			patient.setId(patientHinId);
			BlOpBillHeader opBillHeader = new BlOpBillHeader();

			double totalPastDue = 0.0;
			double availableCreditBal = 0.0;
			double revisedCreditBalance = 0.0;

			String availableCreditBalance = request.getParameter("availableCreditBalance");
			if (null != availableCreditBalance && !availableCreditBalance.equals("")) {
				availableCreditBal = Double.parseDouble(availableCreditBalance);
				LOGGER.debug("availableCreditBal : " + availableCreditBal);
			}
			String revisedCredtBalance = request.getParameter("revisedCreditBalance");
			if (null != revisedCredtBalance && !revisedCredtBalance.equals("")) {
				revisedCreditBalance = Double.parseDouble(revisedCredtBalance);
				LOGGER.debug("revisedCreditBalance : " + revisedCreditBalance);
			}
			totalPastDue = availableCreditBal + revisedCreditBalance;
			LOGGER.debug("totalPastDue : " + totalPastDue);

			String billAmount = request.getParameter("billAmount");
			if (null != billAmount && !billAmount.equals("")) {
				opBillHeader.setBillAmt(new BigDecimal(billAmount));
			}

			String adjustAgainstCreditName = request.getParameter("adjustAgainstCreditName");
			if (null != adjustAgainstCreditName && !adjustAgainstCreditName.equals("")) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(adjustAgainstCreditName));
			}

			String amountTendered = request.getParameter("amountTendered");
			if (null != amountTendered && !amountTendered.equals("")) {
				opBillHeader.setActualCollectedAmt(new BigDecimal(amountTendered));
			}

			opBillHeader.setHin(patient);
			opBillHeader.setHinNo(hinNo);

			opBillHeader.setBillDate(HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE)));
			opBillHeader.setBillTime(request.getParameter(CHANGED_TIME));

			Users user = new Users();
			int userId = 0;
			Users userObj = new Users();
			synchronized (session) {
				user = (Users) session.getAttribute("users");
				userId = user.getId();
				userObj.setId(userId);
			}
			userObj.setId(userId);

			opBillHeader.setChangedBy(userObj);
			opBillHeader.setStatus("y");

			dMap.put("opBillHeader", opBillHeader);

			BlOpBillDetails opBillDetails = new BlOpBillDetails();
			if (null != billAmount) {
				opBillDetails.setRate(new BigDecimal(billAmount));
				opBillDetails.setAmount(new BigDecimal(billAmount));
			}

			String resgistrationType = request.getParameter("registrationType");
			if (null != resgistrationType && !resgistrationType.equals("0")) {
				MasChargeCode chargeCode = new MasChargeCode();
				chargeCode.setId(Integer.parseInt(resgistrationType));
				opBillDetails.setChargeCode(chargeCode);

			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = HMSUtil.getCurrentDateAndTime();

			opBillDetails.setBillDate(HMSUtil.convertStringTypeDateToDateType((String) utilMap.get("currentDate")));
			opBillDetails.setBillTime((String) utilMap.get("currentTime"));
			opBillDetails.setChangedBy(user);

			opBillDetails.setRefundableStatus("y");
			dMap.put("opBillDetails", opBillDetails);
			dMap.put("totalPastDue", totalPastDue);
			dMap.put("hospitalId", hospitalId);
			dMap.put("patientHinId", patientHinId);
			registrationHandlerService.saveRegistrationCardPrintAmount(dMap);
		}
		Random rnd = new Random(System.currentTimeMillis());
		int radonNumber = (rnd.nextInt(900) + 100);
		String hinNoRandom = hinNo + radonNumber;
		LOGGER.debug("hinNoRandom : " + hinNoRandom);

		registrationHandlerService.updatePatientPrintStatus(hinNo, radonNumber);
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		Map<String, Object> patientMap = registrationHandlerService.getPatientList(hinNo);
		String imgfile = "";
		String state = "";
		String district = "";
		String address = "";

		String houseNo = "";
		String lsgHouseNo = "";
		String postoffice = "";
		String pincode = "";

		List<UploadDocuments> uploadDocumentList = new ArrayList<UploadDocuments>();
		List<PatientAddress> patientAddressList = new ArrayList<PatientAddress>();
		if (patientMap.get("uploadDocumentList") != null) {
			uploadDocumentList = (List<UploadDocuments>) patientMap.get("uploadDocumentList");
		}
		if (patientMap.get("patientAddressList") != null) {
			patientAddressList = (List<PatientAddress>) patientMap.get("patientAddressList");
		}

		if (null != patientAddressList && patientAddressList.size() > 0) {
			for (PatientAddress paddress : patientAddressList) {
				if (null != paddress.getState()) {
					state = paddress.getState().getStateName();
				}
				if (null != paddress.getDistrict()) {
					district = paddress.getDistrict().getDistrictName();
				}
				if (null != paddress.getHouseNo()) {
					houseNo = paddress.getHouseNo();
				}
				if (null != paddress.getLsgHouseNo()) {
					lsgHouseNo = paddress.getLsgHouseNo();
				}
				if (null != paddress.getPostOffice()) {
					postoffice = paddress.getPostOffice().getPostCodeName();
				}
				if (null != paddress.getPinCode()) {
					pincode = "" + paddress.getPinCode();
				}
				address = houseNo + " " + lsgHouseNo + " " + postoffice + " " + pincode;
			}
		}

		String fileSeparator = System.getProperty("file.separator");

		String uploadURL = request.getSession().getServletContext()
				.getRealPath(fileSeparator + "photo" + fileSeparator);
		LOGGER.debug("uploadURL : " + uploadURL);

		String path = "";
		if (uploadDocumentList != null && uploadDocumentList.size() > 0) {
			UploadDocuments document = new UploadDocuments();
			document = uploadDocumentList.get(0);

			path = uploadURL;
			if (document.getPatientDocument() != null) {

				File f = new File(path);
				try {
					if (f.exists()) {
						f.delete();
					}
					f.mkdir();
					File someFile = new File(path + fileSeparator + hinNo + ".jpg");
					LOGGER.debug("someFile : " + someFile);
					FileOutputStream fos = new FileOutputStream(someFile);
					fos.write(document.getPatientDocument());
					fos.flush();
					fos.close();
				} catch (FileNotFoundException fileNotFoundException) {
					LOGGER.error("Error while searching for URL " + fileNotFoundException.getStackTrace().toString());
				} catch (IOException ioException) {
					LOGGER.error("Error while writing to output stream " + ioException.getStackTrace().toString());
				}
				imgfile = path + fileSeparator + hinNo + ".jpg";
				LOGGER.debug("imgfile : " + imgfile);
			}
		}

		File f2 = null;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		dataMap.put("hinNo", hinNo);
		parameters.put("hinNo", hinNo);
		parameters.put("hinNoRandom", hinNoRandom);
		try {
			path = uploadURL;
			File f = new File(path);
			f2 = new File(path + fileSeparator + hinNo + ".jpg");
			if (f.exists()) {
				if (!f2.exists()) {
					File someFile = new File(path + fileSeparator + "default.jpg");
					LOGGER.debug("someFile : " + someFile);
					FileOutputStream fos = new FileOutputStream(someFile);
					fos.write(1111);
					fos.flush();
					fos.close();
				}
			} else {
				f.mkdir();
				File someFile = new File(path + fileSeparator + "default.jpg");
				LOGGER.debug("someFile : " + someFile);
				FileOutputStream fos = new FileOutputStream(someFile);
				fos.write(1111);
				fos.flush();
				fos.close();
			}
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to output stream " + ioException.getStackTrace().toString());
		}

		parameters.put("Instruction_IMAGE", getServletContext().getRealPath("/images/instructionImag.jpg"));
		parameters.put("Logo_IMAGE", getServletContext().getRealPath("/images/ehealthLogo.jpg"));
		parameters.put("Logo_Aadram", getServletContext().getRealPath("/images/logo_1.jpg"));
		synchronized (this) {
			if (f2.exists()) {
				if (request.getSession().getServletContext().getRealPath("/photo/" + hinNo + ".jpg") != null) {
					parameters.put("paddress", address);
					parameters.put("state", state);
					parameters.put("district", district);
					parameters.put("PATIENT_IMAGE",
							request.getSession().getServletContext().getRealPath("/photo/" + hinNo + ".jpg"));

					map.put("Report_Path", request.getContextPath() + "/Reports/" + "RegistrationCardNew" + ".pdf");
					HMSUtil.generateReportForDirectPrint("RegistrationCardNew", parameters, (Connection) detailsMap
							.get("conn"), response, getServletContext(), getServletContext().getRealPath("/Reports/"));
				}
			} else {
				parameters.put("paddress", address);
				parameters.put("state", state);
				parameters.put("district", district);
				map.put("Report_Path", request.getContextPath() + "/Reports/" + "RegistrationCardNewD" + ".pdf");
				HMSUtil.generateReportForDirectPrint("RegistrationCardNewD", parameters, (Connection) detailsMap
						.get("conn"), response, getServletContext(), getServletContext().getRealPath("/Reports/"));
			}
		}

		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return new ModelAndView("printReports", "map", map);
	}

	/**
	 * Print Patient Token Number
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView printTokenCard(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside printTokenCard ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int pHinId = 0;
		String query = "";

		HttpSession session = request.getSession();

		if (request.getParameter("pHinId") != null) {
			pHinId = Integer.parseInt(request.getParameter("pHinId"));
			parameters.put("pHinId", pHinId);

		}
		String departmentIdList = "";
		if (request.getParameter("departmentId") != null) {
			departmentIdList = request.getParameter("departmentId");
			parameters.put("department", departmentIdList.substring(0, departmentIdList.length() - 1));
		}

		String department = registrationHandlerService.getDepartmentNameList(departmentIdList.substring(0,
				departmentIdList.length()));

		// Added by Dhananjay 25-Nov-2016
		Date currentDate = new Date();
		int departmentId = 0;
		synchronized (session) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameters.put("hospitalId", hospitalId);

			parameters.put("currentDate", currentDate);
			if (department != null && department.length() >= 2) {
				parameters.put("department", department.substring(1));
			}

			int opsessionId = 0;
			if (request.getParameter("opsessionId") != null) {
				opsessionId = Integer.parseInt(request.getParameter("opsessionId"));
			}
			query = " and v.department_id in(" + departmentIdList.substring(1, departmentIdList.length()) + ")";
			map = registrationHandlerService.getTotalVistByHospital(hospitalId, departmentId, currentDate, pHinId,
					opsessionId, (String) session.getAttribute("hospitalCode"));
			if (null != map.get("TotaltokenNo")) {
				int totalHospitalVisitNo = (Integer) map.get("TotaltokenNo");
				LOGGER.debug("totalHospitalVisitNo : " + totalHospitalVisitNo);
			}

			detailsMap = registrationHandlerService.getConnectionForReport();
			LOGGER.debug("query : " + query);
			parameters.put("query", query);
			parameters.put("currentDate", currentDate);

			map.put("Report_Path", request.getContextPath() + "/uploadedImage/" + "Patient_Token_Card" + pHinId + ""
					+ hospitalId + ".pdf");

			HMSUtil.generateReportForDirectPrintPatient("Patient_Token_Card", parameters, (Connection) detailsMap
					.get("conn"), response, getServletContext(), getServletContext().getRealPath("/uploadedImage/"),
					pHinId, hospitalId);

		}

		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return new ModelAndView("printReports", "map", map);

	}

	/**
	 * ----------------------------------- Patient Visit
	 * ----------------------------
	 */

	public ModelAndView showPatientVisitJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPatientVisitJsp ");
		int deptId = 0;
		int hospitalId = 0;
		String hinNo = "";
		if (request.getParameter("hinNo") != null && !(request.getParameter("hinNo").equals(""))) {
			hinNo = request.getParameter("hinNo");
		}
		String visitSearch = "";
		if (request.getParameter("visitSearch") != null && !(request.getParameter("visitSearch").equals(""))) {
			visitSearch = request.getParameter("visitSearch");

		}
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));

		}

		Map<String, Object> map = registrationHandlerService.populateRegistrationVisit(deptId, hospitalId, hinNo, page,
				visitSearch);
		String pathh = "/hms/hms/registration?method=displayImage&patientHinNo=" + hinNo;

		if (session.getAttribute("patientHinNum") != null && session.getAttribute("patientHinNum").equals("")) {
			session.setAttribute("patientHinNum", "");
		}

		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		map.put("pathh", pathh);
		map.put("hinNo", hinNo);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * populate patient visit details
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populatePatientForUpdate(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientForUpdate ");
		String hinNo = "";

		if (request.getParameter("hinNo") != null && !(request.getParameter("hinNo").equals(""))) {
			hinNo = request.getParameter("hinNo");
		}

		Map<String, Object> map = registrationHandlerService.populatePatientForUpdate(hinNo);

		int permanentDistrict = 0;
		int permanentTaluk = 0;
		int pLsgName = 0;
		String ward = "";
		int plocality = 0;
		String pLsgHouseName = "";
		String pColonyHouseNo = "";
		int postOffice = 0;
		long permanentpincode = 0;

		List<PatientAddress> permanentAddress = (List<PatientAddress>) map.get("permanentAddress");

		if (null != permanentAddress && permanentAddress.size() > 0) {
			for (PatientAddress permanentAadharAddr : permanentAddress) {

				if (null != permanentAadharAddr.getDistrict() && !permanentAadharAddr.getDistrict().equals("")) {
					permanentDistrict = permanentAadharAddr.getDistrict().getId();
				}
				if (null != permanentAadharAddr.getTaluk() && !permanentAadharAddr.getTaluk().equals("")) {
					permanentTaluk = permanentAadharAddr.getTaluk().getId();
				}
				if (null != permanentAadharAddr.getLsgName() && !permanentAadharAddr.getLsgName().equals("")) {
					pLsgName = permanentAadharAddr.getLsgName().getId();
				}
				if (null != permanentAadharAddr.getWardNo() && !permanentAadharAddr.getWardNo().equals("")) {
					ward = permanentAadharAddr.getWardNo().getWardName();
				}
				if (null != permanentAadharAddr.getLocality() && !permanentAadharAddr.getLocality().equals("")) {
					plocality = permanentAadharAddr.getLocality().getId();
				}
				if (null != permanentAadharAddr.getLsgHouseNo() && !permanentAadharAddr.getLsgHouseNo().equals("")) {
					pLsgHouseName = permanentAadharAddr.getLsgHouseNo();
				}
				if (null != permanentAadharAddr.getPostOffice() && !permanentAadharAddr.getPostOffice().equals("")) {
					postOffice = permanentAadharAddr.getPostOffice().getId();
				}
				if (null != permanentAadharAddr.getPinCode() && !permanentAadharAddr.getPinCode().equals("")) {
					permanentpincode = permanentAadharAddr.getPinCode();
				}
			}
		}
		int tdistrictId = 0;
		int ttalukId = 0;
		String twardId = "";
		int tlocality = 0;
		String tLsgHouseNo = "";
		int tpostOff = 0;
		long tpincode = 0;

		List<PatientAddress> tempAddress = new ArrayList<PatientAddress>();
		tempAddress = (List<PatientAddress>) map.get("tempAddress");

		if (null != tempAddress && tempAddress.size() > 0) {
			for (PatientAddress temporaryAddr : tempAddress) {

				if (null != temporaryAddr.getDistrict() && !temporaryAddr.getDistrict().equals("")) {
					tdistrictId = temporaryAddr.getDistrict().getId();
				}
				if (null != temporaryAddr.getTaluk() && !temporaryAddr.getTaluk().equals("")) {
					ttalukId = temporaryAddr.getTaluk().getId();
				}
				if (null != temporaryAddr.getWardNo() && !temporaryAddr.getWardNo().equals("")) {
					twardId = temporaryAddr.getWardNo().getWardName();
				}
				if (null != temporaryAddr.getLocality() && !temporaryAddr.getLocality().equals("")) {
					tlocality = temporaryAddr.getLocality().getId();
				}
				if (null != temporaryAddr.getLsgHouseNo() && !temporaryAddr.getLsgHouseNo().equals("")) {
					tLsgHouseNo = temporaryAddr.getLsgHouseNo();
				}
				if (null != temporaryAddr.getPostOffice() && !temporaryAddr.getPostOffice().equals("")) {
					tpostOff = temporaryAddr.getPostOffice().getId();
				}
				if (null != temporaryAddr.getPinCode() && !temporaryAddr.getPinCode().equals("")) {
					tpincode = temporaryAddr.getPinCode();
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");

		List<Patient> patientList = (List<Patient>) map.get("patientDetailsList");
		for (Patient patient : patientList) {

			sb.append("<Uhid>" + patient.getHinNo() + "</Uhid>");
			sb.append("<hinId>" + patient.getId() + "</hinId>");

			if (patient.getFullName() != null && !patient.getFullName().equals("")) {
				sb.append("<name>" + patient.getFullName() + "</name>");
			} else {
				sb.append("<name>" + "" + "</name>");
			}
			if (patient.getAadhaarNo() != null && !patient.getAadhaarNo().equals("")) {
				sb.append("<aadharNo>" + patient.getAadhaarNo() + "</aadharNo>");
			} else {
				sb.append("<aadharNo>" + "" + "</aadharNo>");
			}
			if (patient.getMobileNumber() != null && !patient.getMobileNumber().equals("")) {
				sb.append("<mobileNo>" + patient.getMobileNumber() + "</mobileNo>");
			} else {
				sb.append("<mobileNo>" + " " + "</mobileNo>");
			}

			if (patient.getAge() != null && !patient.getAge().equals("")) {
				sb.append("<age>" + patient.getAge() + "</age>");
			} else {
				sb.append("<age>" + " " + "</age>");
			}
			if (patient.getRelation() != null && !patient.getRelation().equals("")) {
				sb.append("<NameOf>" + patient.getRelation().getRelationName() + "</NameOf>");
			} else {
				sb.append("<NameOf>" + " " + "</NameOf>");
			}
			if (patient.getRelation() != null && !patient.getRelation().equals("")) {
				sb.append("<RelativeName>" + patient.getFatherMotherName() + "</RelativeName>");
			} else {
				sb.append("<RelativeName>" + " " + "</RelativeName>");
			}
			if (patient.getOccupation() != null && !patient.getOccupation().equals("")) {
				sb.append("<Occupation>" + patient.getOccupation().getOccupationName() + "</Occupation>");
			} else {
				sb.append("<Occupation>" + " " + "</Occupation>");
			}
			if (patient.getPatientType() != null && !patient.getPatientType().equals("")) {
				sb.append("<Category>" + patient.getPatientType().getPatientTypeName() + "</Category>");
				sb.append("<CategoryId>" + patient.getPatientType().getId() + "</CategoryId>");
			} else {
				sb.append("<Category>" + " " + "</Category>");
			}
			if (patient.getSex() != null && !patient.getSex().equals("")) {
				sb.append("<Gender>" + patient.getSex().getAdministrativeSexName() + "</Gender>");
			} else {
				sb.append("<Gender>" + " " + "</Gender>");
			}
			if (patient.getDateOfBirth() != null) {
				sb.append("<dob>" + patient.getDateOfBirth() + "</dob>");
			} else {
				sb.append("<dob>" + " " + "</dob>");
			}

			if (patient.getYearOfBirth() != null && !patient.getYearOfBirth().equals("")) {
				sb.append("<birthYear>" + patient.getYearOfBirth() + "</birthYear>");
			} else {
				sb.append("<birthYear>" + " " + "</birthYear>");
			}

			if (patient.getMobileNumber() != null && !patient.getMobileNumber().equals("")) {
				sb.append("<mob>" + patient.getMobileNumber() + "</mob>");
			} else {
				sb.append("<mob>" + " " + "</mob>");
			}

			if (patient.getEmailId() != null && !patient.getEmailId().equals("")) {
				sb.append("<email>" + patient.getEmailId() + "</email>");
			} else {
				sb.append("<email>" + " " + "</email>");
			}

		}

		int dist = 0;
		int taluk = 0;
		String houseNo = "";
		String streetNo = "";
		int postoffice = 0;
		long pincode = 0;
		int villageId = 0;

		List<PatientAddress> aadharAddress = (List<PatientAddress>) map.get("aadharAddress");
		if (null != aadharAddress && aadharAddress.size() > 0) {

			for (PatientAddress paadharAdd : aadharAddress) {
				dist = paadharAdd.getDistrict().getId();
				taluk = paadharAdd.getTaluk().getId();
				houseNo = paadharAdd.getHouseNo();
				streetNo = paadharAdd.getStreetRoad();
				postoffice = paadharAdd.getPostOffice().getId();
				pincode = paadharAdd.getPinCode();
				villageId = paadharAdd.getVillage().getId();
			}
		}
		if (dist > 0) {
			sb.append("<aDistrict>" + dist + "</aDistrict>");
		} else {
			sb.append("<aDistrict>" + " " + "</aDistrict>");
		}

		if (taluk > 0) {
			sb.append("<ataluk>" + taluk + "</ataluk>");
		} else {
			sb.append("<ataluk>" + " " + "</ataluk>");
		}

		if (houseNo != null && !houseNo.equals("")) {
			sb.append("<houseNo>" + houseNo + "</houseNo>");
		} else {
			sb.append("<houseNo>" + " " + "</houseNo>");
		}
		if (streetNo != null && !streetNo.equals("")) {
			sb.append("<StreetName>" + streetNo + "</StreetName>");
		} else {
			sb.append("<StreetName>" + " " + "</StreetName>");
		}

		if (postoffice > 0) {
			sb.append("<postOffice>" + postoffice + "</postOffice>");
		} else {
			sb.append("<postOffice>" + " " + "</postOffice>");
		}
		if (pincode > 0) {
			sb.append("<pin>" + pincode + "</pin>");
		} else {
			sb.append("<pin>" + " " + "</pin>");
		}

		if (villageId > 0) {
			sb.append("<village>" + villageId + "</village>");
		} else {
			sb.append("<village>" + " " + "</village>");
		}

		if (permanentpincode > 0) {
			sb.append("<permanentpincode>" + permanentpincode + "</permanentpincode>");
		} else {
			sb.append("<permanentpincode>" + " " + "</permanentpincode>");
		}

		if (!pColonyHouseNo.equals("")) {
			sb.append("<pColonyHouseNo>" + pColonyHouseNo + "</pColonyHouseNo>");
		} else {
			sb.append("<pColonyHouseNo>" + " " + "</pColonyHouseNo>");
		}

		if (!pLsgHouseName.equals("")) {
			sb.append("<pLsgHouseName>" + pLsgHouseName + "</pLsgHouseName>");
		} else {
			sb.append("<pLsgHouseName>" + " " + "</pLsgHouseName>");
		}

		if (postOffice > 0) {
			sb.append("<postOffice>" + postOffice + "</postOffice>");
		} else {
			sb.append("<postOffice>" + " " + "</postOffice>");
		}

		if (plocality > 0) {
			sb.append("<plocality>" + plocality + "</plocality>");
		} else {
			sb.append("<plocality>" + " " + "</plocality>");
		}

		if (!ward.equals("")) {
			sb.append("<ward>" + ward + "</ward>");
		} else {
			sb.append("<ward>" + " " + "</ward>");
		}

		if (permanentDistrict > 0) {
			sb.append("<permanLsgName>" + pLsgName + "</permanLsgName>");
		} else {
			sb.append("<permanLsgName>" + " " + "</permanLsgName>");
		}

		if (permanentDistrict > 0) {
			sb.append("<pDistrict>" + permanentDistrict + "</pDistrict>");
		} else {
			sb.append("<pDistrict>" + " " + "</pDistrict>");
		}
		if (permanentTaluk > 0) {
			sb.append("<ptaluk>" + permanentTaluk + "</ptaluk>");
		} else {
			sb.append("<ptaluk>" + " " + "</ptaluk>");
		}

		if (tpincode > 0) {
			sb.append("<tpincode>" + tpincode + "</tpincode>");
		} else {
			sb.append("<tpincode>" + " " + "</tpincode>");
		}

		if (!tLsgHouseNo.equals("")) {
			sb.append("<tLsgHouseNo>" + tLsgHouseNo + "</tLsgHouseNo>");
		} else {
			sb.append("<tLsgHouseNo>" + " " + "</tLsgHouseNo>");
		}

		if (!pLsgHouseName.equals("")) {
			sb.append("<pLsgHouseName>" + pLsgHouseName + "</pLsgHouseName>");
		} else {
			sb.append("<pLsgHouseName>" + " " + "</pLsgHouseName>");
		}

		if (tpostOff > 0) {
			sb.append("<tpostOff>" + tpostOff + "</tpostOff>");
		} else {
			sb.append("<tpostOff>" + " " + "</tpostOff>");
		}

		if (tlocality > 0) {
			sb.append("<tlocality>" + tlocality + "</tlocality>");
		} else {
			sb.append("<tlocality>" + " " + "</tlocality>");
		}

		if (!twardId.equals("")) {
			sb.append("<twardId>" + twardId + "</twardId>");
		} else {
			sb.append("<twardId>" + " " + "</twardId>");
		}

		if (permanentDistrict > 0) {
			sb.append("<permanLsgName>" + pLsgName + "</permanLsgName>");
		} else {
			sb.append("<permanLsgName>" + " " + "</permanLsgName>");
		}

		if (tdistrictId > 0) {
			sb.append("<tdistrictId>" + tdistrictId + "</tdistrictId>");
		} else {
			sb.append("<tdistrictId>" + " " + "</tdistrictId>");
		}
		if (ttalukId > 0) {
			sb.append("<ttalukId>" + ttalukId + "</ttalukId>");
		} else {
			sb.append("<ttalukId>" + " " + "</ttalukId>");
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * populate patient visit details
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populatePatientCitizenData(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientCitizenData ");

		int citizenId = 0;
		if (request.getParameter("citizenId") != null && !(request.getParameter("citizenId").equals(""))) {
			citizenId = Integer.parseInt(request.getParameter("citizenId"));
		}

		Map<String, Object> map = registrationHandlerService.populatePatientCitizenData(citizenId);
		List<PhMasLocality> localityList = new ArrayList<PhMasLocality>();
		int familySequenceId = 0;
		if (null != map.get("familySequenceId")) {
			familySequenceId = (Integer) map.get("familySequenceId");
		}
		int lsgId=0; 
		
		String patientName = "";
		String mobileNumber = "";
		int patientAge = 0;
		String nameOf = "";
		String relativeName = "";
		int occupation = 0;
		int education = 0;
		String pcategory = "";
		int patientGender = 0;
		String yearOfBirth = "";

		long familyId = 0;
		int memberId = 0;
		int aadharDistrict = 0;
		String houseName = "";
		String streetName = "";
		String aadharNumber = "";
		int memberHospitalId = 0;
		String bloodGroupValue = "";
        String address="";
		Date dob = null;
        String relation="";
        String bloodGroup="";
        String socialCategory="";
		// ------------Response------------------
		
        String wardName="";
        String districtName="";
        String postOfficeName="";
		List<PhMemberSurvey> memberList = (List<PhMemberSurvey>) map.get("memberList");
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		if (null != memberList && memberList.size() > 0) {
			for (PhMemberSurvey citizenList : memberList) {

				patientName = citizenList.getName();
				mobileNumber = citizenList.getContactNo() != null ? citizenList.getContactNo() : "";
				if (citizenList.getDateOfBirth() != null) {
					dob = citizenList.getDateOfBirth();
				}
				if (null != dob) {
					patientAge = HMSUtil.calculateAgeByDOB(dob);
				}
				yearOfBirth = citizenList.getYearOfBirth();
				relativeName = citizenList.getPersonName();

				if (null != citizenList.getFamilyId()) {
					familyId = citizenList.getFamilyId();

				}
				if (null != citizenList.getId()) {
					memberId = citizenList.getId();

				}
				if (null != citizenList.getRelationshipName()) {
					relation =  citizenList.getRelationshipName();

				}
				if (null != citizenList.getBloodGroup()) {
					bloodGroup = citizenList.getBloodGroup();

				}
				if (null != citizenList.getSocialCategory()) {
					socialCategory = citizenList.getSocialCategory().getCategoryCode();

				}
				if (null != citizenList.getOccupation()) {
					occupation = citizenList.getOccupation().getId();
				}

				if (null != citizenList.getEducation()) {
					education = Integer.parseInt(citizenList.getEducation());
				}

				if (null != citizenList.getGender()) {
					patientGender = citizenList.getGender().getId();
				}
				
				
				if (null != citizenList.getHouseName()) {
					houseName = citizenList.getHouseName();
					//address=houseName+",";
				}
				if (null != citizenList.getStreetName()) {
					streetName = citizenList.getStreetName();
					//address+=streetName+",";
				}
				if (null != citizenList.getAadhaarDistrict()) {
					aadharDistrict = citizenList.getAadhaarDistrict().getId();
					districtName=citizenList.getAadhaarDistrict().getDistrictName();
					//address+=districtName+",";
				}
				if (null != citizenList.getAadhaarNo()) {
					aadharNumber = String.valueOf(citizenList.getAadhaarNo());

				}
				if (citizenList.getBloodGroup() != null && !citizenList.getBloodGroup().equalsIgnoreCase("Select")
						&& !citizenList.getBloodGroup().equalsIgnoreCase("")) {
					bloodGroupValue = citizenList.getBloodGroup();
				}

				memberHospitalId = citizenList.getHospital().getId();
			}

		}

		int permanentDistrictId = 0;
		int permanentTalukId = 0;
		int permanentPostOfficeId = 0;
		int permanentPostCode = 0;
		String healthHouseId = null;
		String lsghouseNo = null;
		int wardId = 0;
		int localityId = 0;
		String localityName = null;
	
		List<PhHouseSurvey> houseList = new ArrayList<PhHouseSurvey>();
		if (null != map.get("houseList")) {
			houseList = (List<PhHouseSurvey>) map.get("houseList");
		}
		if (null != houseList && houseList.size() > 0) {
			for (PhHouseSurvey houseServey : houseList) {
				permanentDistrictId = houseServey.getVillage().getTaluk().getDistrict().getId();
				districtName=houseServey.getVillage().getTaluk().getDistrict().getDistrictName();
				permanentTalukId = houseServey.getVillage().getTaluk().getId();
				permanentPostOfficeId = houseServey.getPinCode().getId();
				permanentPostCode = houseServey.getPinCode().getPinCode();
				postOfficeName=houseServey.getPinCode().getPostCodeName();
				healthHouseId = houseServey.getHouseHoldId();
				lsghouseNo = houseServey.getLsgHouseNo();
				wardName=houseServey.getWard().getWardName();
				wardId = houseServey.getWard().getId();
				localityId = houseServey.getLocality().getId();
				lsgId = houseServey.getPanchayat().getId();
				localityName = houseServey.getLocality().getLocalityName();
				address=streetName+","+localityName+","+wardName+","+lsghouseNo+","+districtName+","+postOfficeName+","+permanentPostCode;
			}  

		}
		if (wardId > 0) {
			sb.append("<wardId>" + wardId + "</wardId>");
		}
		if (null !=wardName) {
			sb.append("<wardName>" + wardName + "</wardName>");
		}
		if (lsgId>0) {
			sb.append("<lsgId>" + lsgId + "</lsgId>");
		}
		if (localityId > 0) {
			sb.append("<localityId>" + localityId + "</localityId>");
			sb.append("<localityName>" + localityName + "</localityName>");
		}

		if (null != lsghouseNo) {
			sb.append("<lsghouseNo>" + lsghouseNo + "</lsghouseNo>");
		}
		if (null != healthHouseId) {
			sb.append("<healthHouseId>" + healthHouseId + "</healthHouseId>");
		}
		if (permanentDistrictId > 0) {
			sb.append("<permanentDistrictId>" + permanentDistrictId + "</permanentDistrictId>");
		}
		if (permanentTalukId > 0) {
			sb.append("<permanentTalukId>" + permanentTalukId + "</permanentTalukId>");
		}
		if (permanentPostOfficeId > 0) {
			sb.append("<permanentPostOfficeId>" + permanentPostOfficeId + "</permanentPostOfficeId>");
		}
		if (permanentPostCode > 0) {
			sb.append("<permanentPostCode>" + permanentPostCode + "</permanentPostCode>");

		}

		if (patientName != null && !patientName.equals("")) {
			sb.append("<name>" + patientName + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}
		if (address != null && !address.equals("")) {
			sb.append("<address>" + address + "</address>");
		} else {
			sb.append("<address>" + " " + "</address>");
		}
		if (memberId > 0) {
			sb.append("<memberId>" + memberId + "</memberId>");
		} else {
			sb.append("<memberId>" + " " + "</memberId>");
		}
		if (familyId > 0) {
			sb.append("<familyId>" + familySequenceId + "</familyId>");
		} else {
			sb.append("<familyId>" + " " + "</familyId>");
		}

		if (mobileNumber != null && !mobileNumber.equals("")) {
			sb.append("<mobileNo>" + mobileNumber + "</mobileNo>");
		} else {
			sb.append("<mobileNo>" + " " + "</mobileNo>");
		}

		if (yearOfBirth != null && !yearOfBirth.equals("")) {
			sb.append("<yearOfBirth>" + yearOfBirth + "</yearOfBirth>");
		} else {
			sb.append("<yearOfBirth>" + " " + "</yearOfBirth>");
		}
		if (dob != null) {
			sb.append("<dob>" + HMSUtil.convertDateTypeToStringWithoutTime(dob) + "</dob>");
		} else {
			sb.append("<dob>" + " " + "</dob>");
		}

		sb.append("<age>" + patientAge + "</age>");
		
		if (nameOf != null && !nameOf.equals("")) {
			sb.append("<NameOf>" + nameOf + "</NameOf>");
		} else {
			sb.append("<NameOf>" + " " + "</NameOf>");
		}
		if (relation != null && !relation.equals("")) {
			sb.append("<relation>" + relation + "</relation>");
		} else {
			sb.append("<relation>" + " " + "</relation>");
		}
		
		if (bloodGroup != null && !bloodGroup.equals("")) {
			sb.append("<bloodGroup>" + bloodGroup + "</bloodGroup>");
		} else {
			sb.append("<bloodGroup>" + " " + "</bloodGroup>");
		}
		
		if (socialCategory !=""){
			sb.append("<socialCategory>" + socialCategory + "</socialCategory>");
		} else {
			sb.append("<socialCategory>" + " " + "</socialCategory>");
		}
		
		
		if (relativeName != null && !relativeName.equals("")) {
			sb.append("<RelativeName>" + relativeName + "</RelativeName>");
		} else {
			sb.append("<RelativeName>" + " " + "</RelativeName>");
		}
		if (occupation > 0) {
			sb.append("<Occupation>" + occupation + "</Occupation>");
		} else {
			sb.append("<Occupation>" + " " + "</Occupation>");
		}
		if (pcategory != null && !pcategory.equals("")) {
			sb.append("<Category>" + pcategory + "</Category>");
			sb.append("<CategoryId>" + "" + "</CategoryId>");
		} else {
			sb.append("<Category>" + " " + "</Category>");
		}
		if (patientGender > 0) {
			sb.append("<Gender>" + patientGender + "</Gender>");
		} else {
			sb.append("<Gender>" + " " + "</Gender>");
		}

		if (houseName != null && !houseName.equals("")) {
			sb.append("<houseName>" + houseName + "</houseName>");
		} else {
			sb.append("<houseName>" + " " + "</houseName>");
		}

		if (streetName != null && !streetName.equals("")) {
			sb.append("<streetName>" + streetName + "</streetName>");
		} else {
			sb.append("<streetName>" + " " + "</streetName>");
		}

		if (education > 0) {
			sb.append("<education>" + education + "</education>");
		} else {
			sb.append("<education>" + " " + "</education>");
		}

		if (aadharDistrict > 0) {
			sb.append("<aadharDistrict>" + aadharDistrict + "</aadharDistrict>");
		} else {
			sb.append("<aadharDistrict>" + " " + "</aadharDistrict>");
		}

		if (memberHospitalId > 0) {
			sb.append("<memberHospitalId>" + memberHospitalId + "</memberHospitalId>");
		} else {
			sb.append("<memberHospitalId>" + " " + "</memberHospitalId>");
		}
		if (null != aadharNumber && !aadharNumber.equals("")) {
			sb.append("<aadharNo>" + aadharNumber + "</aadharNo>");
		} else {
			sb.append("<aadharNo>" + " " + "</aadharNo>");
		}
		if (null != bloodGroupValue && !bloodGroupValue.equals("")) {
			sb.append("<bloodGroupValue>" + bloodGroupValue + "</bloodGroupValue>");
		} else {
			sb.append("<bloodGroupValue>" + " " + "</bloodGroupValue>");
		}
		
		if (null != localityName && !localityName.equals("")) {
			sb.append("<localityNames>" + localityName + "</localityNames>");
		} else {
			sb.append("<localityNames>" + " " + "</localityNames>");
		}
		
		if (localityId!=0) {
			sb.append("<localitysId>" + localityId + "</localitysId>");
		} else {
			sb.append("<localitysId>" + " " + "</localitysId>");
		}
		
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * populate patient visit details
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populatePatientVisitDetail(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientVisitDetail ");
		int deptId = 0;
		int hospitalId = 0;
		String uhinNo = "";
		int lastVisitId = 0;
		String onlineRegStatus = "";

		if (request.getParameter("onlineRegStatus") != null && !(request.getParameter("onlineRegStatus").equals(""))) {
			onlineRegStatus = request.getParameter("onlineRegStatus");
		}

		if (request.getParameter("patientHinNo") != null && !(request.getParameter("patientHinNo").equals(""))) {
			uhinNo = request.getParameter("patientHinNo");
		}
		if (request.getParameter("lastVisitId") != null && !(request.getParameter("lastVisitId").equals(""))) {
			lastVisitId = Integer.parseInt(request.getParameter("lastVisitId"));
		}

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int page = 1;
		int previousVisitId = 0;
		if (request.getParameter("previousVisitId") != null
				&& !(request.getParameter("previousVisitId").equals("null"))) {
			previousVisitId = Integer.parseInt(request.getParameter("previousVisitId"));
		}

		String visitSearch = "";
		if (request.getParameter("visitSearch") != null && !(request.getParameter("visitSearch").equals(""))) {
			visitSearch = request.getParameter("visitSearch");
		}

		Map<String, Object> map = registrationHandlerService.populateRegistrationVisit(deptId, hospitalId, uhinNo,
				page, visitSearch);

		if (session.getAttribute("patientHinNum") != null && !session.getAttribute("patientHinNum").equals("")) {
			session.setAttribute("patientHinNum", "");
		}

		int patientvisitNo = 0;
		if (null != map.get("patientvisitNum")) {
			patientvisitNo = (Integer) map.get("patientvisitNum");
		}

		String patientUHinNo = "";
		String patientName = "";
		String mobileNumber = "";
		String patientAge = "";
		String nameOf = "";
		String relativeName = "";
		String occupation = "";
		String pcategory = "";
		String patientGender = "";
		int patientHinNo = 0;
		int pcategoryId = 0;

		String lastVisitDate = "";
		String docotorName = "";
		String visitdepartName = "";
		String patientPastDue = "";
		String priority = "";
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<onlineRegStatus>" + onlineRegStatus + "</onlineRegStatus>");

		int unitId = 0;
		String unitName = "";
		int doctorId = 0;
		String docName = "";
		int serviceCemterId = 0;

		List<Patient> patientList = (List<Patient>) map.get("patientDetailsList");
		for (Patient patient : patientList) {
			patientUHinNo = patient.getHinNo();
			patientHinNo = patient.getId();
			patientName = patient.getPFirstName();
			mobileNumber = patient.getMobileNumber();
			patientAge = patient.getAge();
			String[] age = null;
			int age1 = 0;
			if (patientAge != null && !patientAge.equals("")) {
				age = patientAge.split(" ");
			}
			if (age != null && age.length > 0) {
				age1 = Integer.parseInt("" + age[0]);
			}
			if (age1 >= 60) {
				priority = "1";
			} else {
				priority = "3";
			}
			if (null != patient.getRelation()) {
				nameOf = patient.getRelation().getRelationName();
			}
			relativeName = patient.getFatherMotherName();

			if (null != patient.getOccupation()) {
				occupation = patient.getOccupation().getOccupationName();
			}
			if (null != patient.getPatientType()) {
				pcategory = patient.getPatientType().getPatientTypeName();
				pcategoryId = patient.getPatientType().getId();
			}
			if (null != patient.getSex()) {
				patientGender = patient.getSex().getAdministrativeSexName();
			}

			patientPastDue = patient.getPastDue();
		}

		List<OpdPatientDetails> opdPatientDetailsList = (List<OpdPatientDetails>) map.get("opdPatientDetailsList");

		if (opdPatientDetailsList.size() > 0) {
			for (OpdPatientDetails opdPatientDetail : opdPatientDetailsList) {
				HospitalDoctorUnitM unit = opdPatientDetail.getVisit().getUnit();
				if (null != unit) {
					unitId = unit.getId();
					unitName = unit.getUnitCode();
				}
				MasEmployee employee = opdPatientDetail.getEmployee();
				if (null != employee) {
					doctorId = employee.getId();
					docName = employee.getEmployeeName();
				}
				serviceCemterId = opdPatientDetail.getVisit().getDepartment().getId();
				LOGGER.debug("serviceCemterId : " + serviceCemterId);
				LOGGER.debug("opdPatientDetail.getVisit().getDepartment().getDepartmentName() : "
						+ opdPatientDetail.getVisit().getDepartment().getDepartmentName());
			}
			sb.append("<unitId>" + unitId + "</unitId>");
			sb.append("<unitName>" + unitName + "</unitName>");
			sb.append("<doctorId>" + doctorId + "</doctorId>");
			sb.append("<docName>" + docName + "</docName>");
			sb.append("<serviceCemterId>" + serviceCemterId + "</serviceCemterId>");
		}

		sb.append("<priority>" + priority + "</priority>");
		sb.append("<Uhid>" + patientUHinNo + "</Uhid>");
		sb.append("<hinId>" + patientHinNo + "</hinId>");

		if (null != patientPastDue && !patientPastDue.equals("")) {
			sb.append("<pastDue>" + patientPastDue + "</pastDue>");
		} else {
			patientPastDue = "0.0";
			sb.append("<pastDue>" + patientPastDue + "</pastDue>");
		}

		if (patientName != null && !patientName.equals("")) {
			sb.append("<name>" + patientName + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}
		if (mobileNumber != null && !mobileNumber.equals("")) {
			sb.append("<mobileNo>" + mobileNumber + "</mobileNo>");
		} else {
			sb.append("<mobileNo>" + " " + "</mobileNo>");
		}

		if (patientAge != null && !patientAge.equals("")) {
			sb.append("<page>" + patientAge + "</page>");
		} else {
			sb.append("<page>" + "" + "</page>");
		}
		if (nameOf != null && !nameOf.equals("")) {
			sb.append("<NameOf>" + nameOf + "</NameOf>");
		} else {
			sb.append("<NameOf>" + " " + "</NameOf>");
		}
		if (relativeName != null && !relativeName.equals("")) {
			sb.append("<RelativeName>" + relativeName + "</RelativeName>");
		} else {
			sb.append("<RelativeName>" + " " + "</RelativeName>");
		}
		if (occupation != null && !occupation.equals("")) {
			sb.append("<Occupation>" + occupation + "</Occupation>");
		} else {
			sb.append("<Occupation>" + " " + "</Occupation>");
		}
		if (pcategory != null && !pcategory.equals("")) {
			sb.append("<Category>" + pcategory + "</Category>");
			sb.append("<CategoryId>" + pcategoryId + "</CategoryId>");
		} else {
			sb.append("<Category>" + " " + "</Category>");
		}
		if (patientGender != null && !patientGender.equals("")) {
			sb.append("<Gender>" + patientGender + "</Gender>");
		} else {
			sb.append("<Gender>" + " " + "</Gender>");
		}
		if (previousVisitId > 0) {
			sb.append("<previousVisitId>" + previousVisitId + "</previousVisitId>");
		} else {
			sb.append("<previousVisitId>" + " " + "</previousVisitId>");
		}

		if (lastVisitId > 0) {
			sb.append("<lastVisitId>" + lastVisitId + "</lastVisitId>");
		} else {
			sb.append("<lastVisitId>" + " " + "</lastVisitId>");
		}

		List<Visit> visitList = (List<Visit>) map.get("visitList");
		if (null != visitList && visitList.size() > 0) {

			for (Visit visit : visitList) {
				if (visit.getVisitDate() != null) {
					lastVisitDate = HMSUtil.convertDateTypeToStringWithoutTime(visit.getVisitDate());
				}

				if (null != visit.getDoctor()) {
					docotorName = visit.getDoctor().getEmployeeName();
				}

				if (null != visit.getDepartment()) {
					visitdepartName = visit.getDepartment().getDepartmentName();
				}
			}

		}
		if (lastVisitDate != null && !lastVisitDate.equals("")) {
			sb.append("<LastVisitDate>" + lastVisitDate + "</LastVisitDate>");
		} else {
			sb.append("<LastVisitDate>" + " " + "</LastVisitDate>");
		}
		if (docotorName != null && !docotorName.equals("")) {
			sb.append("<dutyDoct>" + docotorName + "</dutyDoct>");
		} else {
			sb.append("<dutyDoct>" + " " + "</dutyDoct>");
		}

		if (visitdepartName != null) {
			sb.append("<departmentName>" + visitdepartName + "</departmentName>");
		} else {
			sb.append("<departmentName>" + " " + "</departmentName>");
		}

		sb.append("<VisitNo>" + patientvisitNo + "</VisitNo>");

		// added by amit das on 08-06-2016 for JSSK scheme default selected for
		// pragnentwoman
		String pragnent = "no";
		if (map != null && map.get("pragnent") != null) {
			pragnent = (String) map.get("pragnent");
		}
		sb.append("<pragnent>" + pragnent + "</pragnent>");
		
		if (mobileNumber != null && !mobileNumber.equals("")) {
			sb.append("<mobileNo>" + mobileNumber + "</mobileNo>");
		} else {
			sb.append("<mobileNo>" + " " + "</mobileNo>");
		}
		
		sb.append("</item>");

		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

		response.getWriter().close();
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateUnitForDepartment(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateUnitForDepartment ");
		Map<String, Object> datmap = new HashMap<String, Object>();

		int deptId = 0;
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null && !(request.getParameter("hospitalId").equals(""))) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}

		if (request.getParameter("depatmentId") != null && !(request.getParameter("depatmentId").equals(""))) {
			deptId = Integer.parseInt(request.getParameter("depatmentId"));
		}
		if (request.getParameter("hinId") != null && !(request.getParameter("hinId").equals(""))) {
			int hinId = Integer.parseInt(request.getParameter("hinId"));
			datmap.put("hinId", hinId);
		}
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		String departmentValues = request.getParameter("depatmentId");
		datmap.put("departmentValues", departmentValues);
		datmap.put("hospitalId", hospitalId);

		List<HospitalDoctorUnitM> unitList = new ArrayList<HospitalDoctorUnitM>();
		Map<String, Object> map = registrationHandlerService.populateUnitForDepartment(datmap);

		if (null != map.get("unitList")) {
			unitList = (List<HospitalDoctorUnitM>) map.get("unitList");
		}

		// Added by Arbind on 21-05-2017
		int unitId = 0;
		if (null != session.getAttribute(deptId + "unit")) {
			unitId = Integer.parseInt(session.getAttribute(deptId + "unit").toString());
		} else if (null != unitList && unitList.size() > 0) {
			unitId = unitList.get(0).getId();
		}
		LOGGER.debug("unitId : " + unitId);

		StringBuffer sb = new StringBuffer();
		if (null != unitList && unitList.size() > 0) {
			for (HospitalDoctorUnitM docUnitList : unitList) {
				sb.append("<item>");
				// deptUnitId Added by Arbind on 21-05-2017
				if (unitId != 0) {
					sb.append("<deptUnitId>" + unitId + "</deptUnitId>");
				}
				sb.append("<unitId>" + docUnitList.getId() + "</unitId>");
				sb.append("<unitCode>" + docUnitList.getUnitCode() + "</unitCode>");
				sb.append("</item>");
			}
		}

		List<Object[]> empSCMappingStringList = new ArrayList<Object[]>();
		if (null != map.get("empSCMappingStringList")) {
			empSCMappingStringList = (List<Object[]>) map.get("empSCMappingStringList");
		}
		if (null != empSCMappingStringList && empSCMappingStringList.size() > 0) {
			for (Object[] empScMapping : empSCMappingStringList) {
				LOGGER.debug("empScMapping[0]" + empScMapping[0]);
				LOGGER.debug("empScMapping[2]" + empScMapping[2]);
				sb.append("<item>");
				sb.append("<doctorId>" + empScMapping[0] + "</doctorId>");
				sb.append("<doctorName>" + empScMapping[2] + "</doctorName>");
				sb.append("</item>");
			}
		}

		if(map.get("lastVisitDetailsList")!=null){
			List<Object[]> lastVisitDetailsList = (List<Object[]>)map.get("lastVisitDetailsList");
			
			if(lastVisitDetailsList.size()>0){
				for(Object[] obj : lastVisitDetailsList){
				sb.append("<item>");
				sb.append("<lastVisitedDoctorId>" + (obj[0]!=null?obj[0]:0 )+ "</lastVisitedDoctorId>");
				sb.append("<lastVisitedUnitId>" + (obj[1]!=null?obj[1]:0 ) + "</lastVisitedUnitId>");
				sb.append("</item>");
				}
			}
			
		}
		
		LOGGER.info("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateDoctorForDepartment(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateDoctorForDepartment ");

		String deptId = null;
		int hospitalId = 0;
		if (request.getParameter("depatmentId") != null && !(request.getParameter("depatmentId").equals(""))) {
			deptId = request.getParameter("depatmentId");
		}

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		List<Object[]> empList = new ArrayList<Object[]>();
		Map<String, Object> map = registrationHandlerService.populateDoctorForDepartment(deptId, hospitalId);

		if (null != map.get("masEmployeeList")) {
			empList = (List<Object[]>) map.get("masEmployeeList");
		}

		StringBuffer sb = new StringBuffer();
		if (null != empList && empList.size() > 0) {
			for (Object[] result : empList) {
				sb.append("<item>");
				sb.append("<docotId>" + result[0] + "</docotId>");
				sb.append("<docotCode>" + (String) result[1] + "</docotCode>");
				sb.append("</item>");
			}
		} else {
			sb.append("<item>");
			sb.append("<docotId>" + "" + "</docotId>");
			sb.append("<docotCode>" + "" + "</docotCode>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	@SuppressWarnings("unchecked")
	public void populateDoctorForUnit(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateDoctorForUnit ");

		int unitId = 0;
		if (request.getParameter("UnitId") != null && !(request.getParameter("UnitId").equals(""))) {
			unitId = Integer.parseInt(request.getParameter("UnitId"));
		}
		int departmentId = 0;
		if (request.getParameter("departmentId") != null && !(request.getParameter("departmentId").equals(""))) {
			departmentId = Integer.parseInt(request.getParameter("departmentId"));
		}

		StringBuffer sb = new StringBuffer();
		Map<String, Object> map = registrationHandlerService.populateDoctorForUnit(unitId,departmentId);
		List<HospitalDoctorUnitT> doctorList = new ArrayList<HospitalDoctorUnitT>();
		if (null != map.get("doctorList")) {
			doctorList = (List<HospitalDoctorUnitT>) map.get("doctorList");
		}
		if (null != doctorList && doctorList.size() > 0) {
			for (HospitalDoctorUnitT docUnitList : doctorList) {
				sb.append("<item>");
				MasEmployee employee = docUnitList.getEmployee();
				if (docUnitList.getHeadFleg().equalsIgnoreCase("y")) {
					LOGGER.debug("docotor Name " + employee.getEmployeeName());
					sb.append("<hedDoctId>" + employee.getId() + "</hedDoctId>");
					sb.append("<hedDoctName>" + employee.getEmployeeName() + "</hedDoctName>");
				}
				sb.append("<DoctId>" + employee.getId() + "</DoctId>");
				sb.append("<DoctName>" + employee.getEmployeeName() + "</DoctName>");
				sb.append("</item>");
			}
		}

		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		response.getWriter().close();
	}

	@SuppressWarnings("unchecked")
	public void populateUnitForDoctor(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateUnitForDoctor ");

		int doctorId = 0;
		int hospitalId = 0;

		if (request.getParameter("doctorId") != null && !(request.getParameter("doctorId").equals(""))) {
			doctorId = Integer.parseInt(request.getParameter("doctorId"));
		}

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = registrationHandlerService.populateUnitForDoctor(doctorId, hospitalId);
		List<HospitalDoctorUnitT> unitList = new ArrayList<HospitalDoctorUnitT>();
		if (null != map.get("unitList")) {
			unitList = (List<HospitalDoctorUnitT>) map.get("unitList");
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");

		if (null != unitList && unitList.size() > 0) {
			for (HospitalDoctorUnitT hospitalDoctorUnitT : unitList) {
				sb.append("<unitId>" + hospitalDoctorUnitT.getUnitM().getId() + "</unitId>");
				sb.append("<unitCode>" + hospitalDoctorUnitT.getUnitM().getUnitCode() + "</unitCode>");
			}
		} else {
			sb.append("<unitId>" + "" + "</unitId>");
			sb.append("<unitCode>" + "" + "</unitCode>");
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

		response.getWriter().close();
	}

	public void displayImage(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside displayImage ");
		String patientHinNo = request.getParameter("patientHinNo");
		Map<String, Object> map = registrationHandlerService.displayImage(patientHinNo);
		if (null != map.get("imageObj")) {
			OutputStream oImage = null;
			UploadDocuments item10 = (UploadDocuments) map.get("imageObj");
			try {
				byte[] photo = item10.getPatientDocument();
				response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
				oImage = response.getOutputStream();
				oImage.write(photo);
				oImage.flush();
				oImage.close();
			} catch (IOException ioException) {
				LOGGER.error("Error while writing to outputstream" + ioException.getStackTrace().toString());
			}
		}
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showVisitDetails(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showVisitDetails ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session = request.getSession();
		int deptId = 0;
		synchronized (session) {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
		}
		String hinNo = "";
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDs.put("hinNo", hinNo);
		} else {
			String patientName = request.getParameter(PATIENT_NAME);
			if (patientName != null) {
				mapForDs.put("patientName", patientName);
			}
		}

		String pFirstName = request.getParameter(P_FIRST_NAME);
		if (pFirstName != null && !(pFirstName.equals(""))) {
			mapForDs.put("patientFName", pFirstName);
		}
		String pMiddleName = request.getParameter(P_MIDDLE_NAME);
		if (pMiddleName != null && !(pMiddleName.equals(""))) {
			mapForDs.put("patientMName", pMiddleName);
		}
		String pLastName = request.getParameter(P_LAST_NAME);
		if (pLastName != null && !(pLastName.equals(""))) {
			mapForDs.put("patientLName", pLastName);
		}
		String hinId = request.getParameter("hinId");
		if (hinId != null) {
			mapForDs.put("hinId", Integer.parseInt(hinId));
		}

		String message = "";

		Map<String, Object> patientMap = registrationHandlerService.getPatientDetails(mapForDs);
		String jsp = "";
		boolean cardValidFlag = false;
		List<Patient> patientList = (List<Patient>) patientMap.get("patientList");
		if (patientList.size() > 0 || Integer.parseInt(hinId) != 0) {
			Patient patient = patientList.get(0);
			if (patient.getCardValidDate() != null) {
				cardValidFlag = HMSUtil.checkCardValidityDate(HMSUtil.convertDateToStringTypeDate(patient
						.getCardValidDate()));
			}

			if (cardValidFlag) {

				if (patient.getPatientStatus().equalsIgnoreCase("Out Patient")) {
					LOGGER.debug("patient is Outpatient ");
					detailsMap = registrationHandlerService.getVisitDetails(hospitalId);
					@SuppressWarnings("unused")
					List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
					chargeCodeList = (List<MasChargeCode>) detailsMap.get("chargeCodeList");
					BigDecimal amount = new BigDecimal("0");
					String billNo = opBillingHandlerService.generateBillNo("OS", "display", hospitalId);
					int patientType = patient.getPatientType().getId();
					// patient type from registration
					int companyId = 0;
					if (patient.getCompany() != null) {
						companyId = patient.getCompany().getId();
					}
					/**
					 * Added By Ritu as multiple Revisit charges in
					 * mas_charge_code table
					 * 
					 */
					parameterMap.put("chargeId", detailsMap.get("chargeId"));
					parameterMap.put("mainChargeId", detailsMap.get("mainChargeId"));
					parameterMap.put("subChargeId", detailsMap.get("subChargeId"));
					parameterMap.put("patientTypeId", patientType);
					parameterMap.put("companyId", companyId);
					parameterMap.put("patientCategory", "OP");
					parameterMap.put("billTypeId", 2);

					String regtype = "";
					if (patient.getRegistrationType() != null) {
						regtype = patient.getRegistrationType();
					} else {
						regtype = "G";
					}

					parameterMap.put("regType", regtype);
					map = opBillingHandlerService.getChargeAmountAfterDiscount(parameterMap);
					if (map.get("chargeAmountAfterDis") != null) {
						amount = (BigDecimal) map.get("chargeAmountAfterDis");
					}
					jsp = VISIT_BY_HIN_JSP;
					map.put("billNo", billNo);
					map.put("amount", amount);
				} else {
					LOGGER.debug("patient is admit ");
					map = registrationHandlerService.getDetailsForVisit();
					message = "Patient is admit";
					map.put("message", message);
					jsp = PATIENT_VISIT_SEARCH_JSP;
				}
			} else {

				parameterMap.put("hospitalId", hospitalId);
				parameterMap.put("hinNo", hinNo);
				Map<String, Object> patientDetailsMap = registrationHandlerService
						.getPatientDetailsForUpdate(parameterMap);
				map = registrationHandlerService.getUpdateRegistrationDetails();
				message = "Registration Expired ";
				map.put("message", message);
				map.put("patientDetailsMap", patientDetailsMap);
				jsp = UPDATE_REGISTRATION_JSP;
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}
		} else {
			message = "Patient Not Registered ";
			map.put("message", message);
			map = registrationHandlerService.getDetailsForVisit();
			jsp = PATIENT_VISIT_SEARCH_JSP;
		}
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		if (map.get("chargeCodeList") != null) {
			chargeCodeList = (List<MasChargeCode>) map.get("chargeCodeList");
		}
		map.put("chargeCodeList", chargeCodeList);
		if (cardValidFlag) {
			map.put("patientMap", patientMap);
			map.put("detailsMap", detailsMap);
		} else {
			map.put("patientMap", patientMap);
		}
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getIpAdmissionDetailsForBilling(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside getIpAdmissionDetailsForBilling ");
		String hinNo = "";
		int chargeCodeId = 0;
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		if (request.getParameter("chargeCodeId") != null) {
			chargeCodeId = Integer.parseInt(request.getParameter("chargeCodeId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("hinNo", hinNo);
		dataMap.put("chargeCodeId", chargeCodeId);
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			map = registrationHandlerService.getIpAdmissionDetailsForBilling(dataMap);
		} catch (RuntimeException e) {
			LOGGER.error("RuntimeException has occurred " + e.getStackTrace().toString());
		}

		List<Patient> patientList = new ArrayList<Patient>();
		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}

		BigDecimal amt = new BigDecimal(0.00);
		if (map.get("amt") != null) {
			amt = new BigDecimal("" + map.get("amt"));
		}

		int patientType = 0;
		int companyId = 0;
		Patient patient = patientList.get(0);
		if (patient.getPatientType() != null) {
			patientType = patient.getPatientType().getId();
		}
		if (patient.getCompany() != null) {
			companyId = patient.getCompany().getId();
		}
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		if (map.get("chargeCodeList") != null) {
			chargeCodeList = (List<MasChargeCode>) map.get("chargeCodeList");
		}
		BigDecimal amount = new BigDecimal("0");

		int roomTypeId = 0;
		if (request.getParameter("roomTypeId") != null && !request.getParameter("roomTypeId").equals("")) {
			roomTypeId = Integer.parseInt(request.getParameter("roomTypeId"));
		}
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("patientTypeId", patientType);
		parameterMap.put("companyId", companyId);
		parameterMap.put("chargeId", chargeCodeList.get(0).getId());
		parameterMap.put("mainChargeId", chargeCodeList.get(0).getMainChargecode().getId());
		parameterMap.put("subChargeId", chargeCodeList.get(0).getSubChargecode().getId());
		parameterMap.put("patientCategory", "OP");
		parameterMap.put("billTypeId", 2);
		parameterMap.put("roomTypeId", roomTypeId);
		parameterMap.put("regType", patient.getRegistrationType());
		try {
			Map<String, Object> chargeMap = opBillingHandlerService.getChargeAmountAfterDiscount(parameterMap);
			if ((chargeMap.get("chargeAmountAfterDis") != null)
					&& (patientType == Integer.parseInt(properties.getProperty("com.jkt.hms.ipd.INPATIENT_SC"))
							|| patientType == Integer.parseInt(properties.getProperty("com.jkt.hms.ipd.INPATIENT_ST")) || patientType == Integer
							.parseInt(properties.getProperty("com.jkt.hms.ipd.INPATIENT_DOMICILE")))) {
				amount = new BigDecimal(0);
			} else if (chargeMap.get("chargeAmountAfterDis") != null) {
				amount = (BigDecimal) chargeMap.get("chargeAmountAfterDis");
			}
			map.put("chargeMap", chargeMap);
		} catch (RuntimeException e) {
			LOGGER.error("RuntimeException has occurred " + e.getStackTrace().toString());
		}
		map.put("amount", amount);
		map.put("amt", amt);
		return new ModelAndView("responseForBillAmount", "map", map);

	}

	public ModelAndView saveVisitInformation(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside saveVisitInformation ");

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();

		Date currentDate = new Date();

		Patient patient = new Patient();
		boolean successfullyAdded = false;
		int hospitalId = 0;
		int hinId = 0;
		boolean duplicateVisitSatatus = false;
		String message = "";
		String hinNo = "";

		String hospitalCode = "";
		String deptCode = "";

		HttpSession session = request.getSession();
		synchronized (session) {
			if (request.getParameter("onlineRegStatus") != null && !request.getParameter("onlineRegStatus").equals("")) {
				mapForDs.put("onlineRegStatus", request.getParameter("onlineRegStatus"));
			}

			if (request.getParameter("priorityName") != null && !request.getParameter("priorityName").equals("")) {
				mapForDs.put("currentPriority", Integer.parseInt(request.getParameter("priorityName")));
			}

			if (request.getParameter("loddrs") != null && !request.getParameter("loddrs").equals("")) {
				mapForDs.put("dutyDoctorId", Integer.parseInt(request.getParameter("loddrs")));
			}

			if (request.getParameter("unit") != null && !request.getParameter("unit").equals("")) {

				int unitId = Integer.parseInt(request.getParameter("unit"));
				mapForDs.put("unitId", unitId);
				// Added by Arbind on 21-05-2017
				String patientDepartment = request.getParameter(PATIENT_DEPARTMENT);
				if (null != patientDepartment && !patientDepartment.equals("0")) {
					session.setAttribute(Integer.parseInt(patientDepartment) + "unit", unitId);
				}

			}

			if(request.getParameter("prevDoctorVisit")!=null){
				session.setAttribute("prevDoctorVisit", request.getParameter("prevDoctorVisit"));
			}
			/*if(request.getParameter("prevDoctorVisitId")!=null){
				session.setAttribute("prevDoctorVisit", request.getParameter("prevDoctorVisitId"));
			}*/
			
			if (request.getParameter("patientHinId") != null && !request.getParameter("patientHinId").equals("")) {
				hinId = Integer.parseInt(request.getParameter("patientHinId"));
				mapForDs.put("hinId", hinId);
			}

			if (request.getParameter(HIN_ID) != null && !request.getParameter(HIN_ID).equals("0")) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
				mapForDs.put("hinId", hinId);
			}

			if (request.getParameter("hinNO") != null) {
				hinNo = request.getParameter("hinNO");
				mapForDs.put("hinNo", hinNo);
			}

			String patientType = request.getParameter("patientTypeName");
			if (request.getParameter("patientTypeName") != null) {

				MasPatientType masPatientType = new MasPatientType();
				if (patientType != null && !patientType.equals("")) {
					masPatientType.setId(Integer.parseInt(patientType));
					patient.setPatientType(masPatientType);
				}
				mapForDs.put("patientType", patientType);
			}

			int billNo = 0;
			String refDoctor = request.getParameter("refDoctor");
			if (refDoctor != null && !refDoctor.equals("0")) {
				MasAuthorizer masAuthorizer = new MasAuthorizer();
				masAuthorizer.setId(Integer.parseInt(refDoctor));
				mapForDs.put("refDoctor", refDoctor);

			}

			Users userObj = new Users();

			Users user = (Users) session.getAttribute("users");
			int userId = user.getId();
			userObj.setId(userId);

			int consultingDoctorId = 0;
			String consultingDoctor = request.getParameter(CONSULTING_DOCTOR);
			if (consultingDoctor != null && !consultingDoctor.equals("0")) {
				consultingDoctorId = Integer.parseInt(consultingDoctor);
				mapForDs.put("consultingDoctorId", consultingDoctorId);
			}
			String complaintId = request.getParameter(COMPLAINT_ID);
			if (complaintId != null && !complaintId.equals("0")) {
				mapForDs.put("complaintId", Integer.parseInt(complaintId));
			}
			String caseTypeId = request.getParameter(CASE_TYPE_ID);
			if (caseTypeId != null && !caseTypeId.equals("0")) {
				mapForDs.put("caseTypeId", Integer.parseInt(caseTypeId));
			}
			String diagnosisId = request.getParameter(DIAGNOSIS_ID);
			if (diagnosisId != null && !diagnosisId.equals("0")) {
				mapForDs.put("diagnosisId", Integer.parseInt(diagnosisId));
			}

			String visitDate = request.getParameter(VISIT_DATE);
			if (visitDate != null && !visitDate.equals("")) {
				mapForDs.put("visitDate", HMSUtil.convertStringTypeDateToDateType(visitDate));
			}

			String visitTime = request.getParameter(VISIT_TIME);
			if (visitTime != null && !visitTime.equals("")) {
				mapForDs.put("visitTime", visitTime);
			}

			int opsessionId = 0;
			String opsession = request.getParameter("opsession");
			if (opsession != null && !opsession.equals("")) {
				mapForDs.put("opsessionId", Integer.parseInt(opsession));
			}
			String cashReceived = "n";
			if (null != request.getParameter("cashreceived") && request.getParameter("cashreceived").equals("y")) {
				cashReceived = request.getParameter("cashreceived");
			}
			mapForDs.put("cashReceived", cashReceived);

			String referalStatus = "n";
			if (null != request.getParameter("referalStatus")
					&& request.getParameter("referalStatus").equalsIgnoreCase("y")) {
				referalStatus = request.getParameter("referalStatus");
			}
			mapForDs.put("referalStatus", referalStatus);

			String refferalType = "";
			if (request.getParameter("referalType") != null) {
				refferalType = request.getParameter("referalType");
			}
			mapForDs.put("refferalType", refferalType);
			// added by arbind on 10-02-2017
			String cashNotReceivedReason = request.getParameter("cashReason");
			if (null != cashNotReceivedReason && !cashNotReceivedReason.equals("")) {
				mapForDs.put("cashNotReceivedReason", cashNotReceivedReason);
			}

			MasHospital masHospital = new MasHospital();
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				masHospital.setId(hospitalId);
				mapForDs.put("hospitalId", hospitalId);
			}

			if (session.getAttribute("deptCode") != null) {
				deptCode = (String) session.getAttribute("deptCode");
				mapForDs.put("deptCode", deptCode);
			}

			if (session.getAttribute("hospitalCode") != null) {
				hospitalCode = (String) session.getAttribute("hospitalCode");
				mapForDs.put("hospitalCode", hospitalCode);
			}

			// Billing Start

			double totalPastDue = 0.0;
			double availableCreditBal = 0.0;
			double revisedCreditBalance = 0.0;

			String availableCreditBalance = request.getParameter("availableCreditBalance");
			if (null != availableCreditBalance && !availableCreditBalance.equals("")) {
				availableCreditBal = Double.parseDouble(availableCreditBalance);
			}

			String revisedCreditBalanceStr = request.getParameter("revisedCreditBalance");
			if (null != revisedCreditBalanceStr && !revisedCreditBalanceStr.equals("")) {
				revisedCreditBalance = Double.parseDouble(revisedCreditBalanceStr);
			}
			totalPastDue = availableCreditBal + revisedCreditBalance;

			BlOpBillHeader opBillHeader = new BlOpBillHeader();
			String billAmount = request.getParameter("billAmount");
			if (null != billAmount && !billAmount.equals("")) {
				opBillHeader.setBillAmt(new BigDecimal(billAmount));
			}

			String adjustAgainstCreditName = request.getParameter("adjustAgainstCreditName");
			if (null != adjustAgainstCreditName && !adjustAgainstCreditName.equals("")) {
				opBillHeader.setAdvanceAdjustment(new BigDecimal(adjustAgainstCreditName));
			}

			String amountTendered = request.getParameter("amountTendered");
			if (null != amountTendered && !amountTendered.equals("")) {
				opBillHeader.setActualCollectedAmt(new BigDecimal(amountTendered));
			}

			String discountPerAmount = request.getParameter("discountPerAmount");
			if (null != discountPerAmount && !discountPerAmount.equals("")) {
				opBillHeader.setDiscountAmt(new BigDecimal(discountPerAmount));
			}

			// Added by Amit Das on 02-03-2016
			String visitScheme = request.getParameter("Visitscheme");
			if (null != visitScheme && !visitScheme.equals("0")) {
				MasScheme masScheme = new MasScheme();
				masScheme.setId(Integer.parseInt(visitScheme));
				opBillHeader.setScheme(masScheme);
			}
			// End by Amit Das on 02-03-2016

			opBillHeader.setHinNo(hinNo);
			opBillHeader.setHospital(masHospital);
			Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();

			String time = (String) utilMap.get("currentTime");
			opBillHeader.setBillDate(currentDate);
			opBillHeader.setBillTime(time);
			userObj.setId(userId);

			opBillHeader.setChangedBy(userObj);
			opBillHeader.setStatus("y");

			BlOpBillDetails opBillDetails = new BlOpBillDetails();
			if (null != billAmount) {
				opBillDetails.setRate(new BigDecimal(billAmount));
				opBillDetails.setAmount(new BigDecimal(billAmount));
			}

			if (null != request.getParameter("discountPercent") && !request.getParameter("discountPercent").equals("")) {
				opBillDetails.setDiscountPercent(new BigDecimal(request.getParameter("discountPercent")));
			}

			if (null != discountPerAmount && !discountPerAmount.equals("")) {
				opBillDetails.setDiscountAmt(new BigDecimal(discountPerAmount));
			}

			int chargeId = 0;
			String resgistrationType = request.getParameter("registrationType");
			if (null != resgistrationType && !resgistrationType.equals("0")) {
				chargeId = Integer.parseInt(resgistrationType);
				MasChargeCode chargeCode = new MasChargeCode();
				chargeCode.setId(chargeId);
				opBillDetails.setChargeCode(chargeCode);
			}

			opBillDetails.setBillDate(HMSUtil.convertStringTypeDateToDateType((String) utilMap.get("currentDate")));
			opBillDetails.setBillTime(time);
			opBillDetails.setChangedBy(user);
			opBillDetails.setRefundableStatus("y");

			String[] departmentIdlist = null;
			String[] nonClinicaldepartmentIdlist = null;
			ArrayList<String> serviceCentreList = new ArrayList<String>();

			String[] patientDepartment = request.getParameterValues(PATIENT_DEPARTMENT);
			if (patientDepartment != null && patientDepartment.length != 0) {
				departmentIdlist = patientDepartment;
				for (String s : departmentIdlist) {
					serviceCentreList.add(s);
				}
			}

			String[] nonclinicalDeprtment = request.getParameterValues("nonclinicalDeprtment");
			if (nonclinicalDeprtment != null && nonclinicalDeprtment.length != 0) {
				nonClinicaldepartmentIdlist = nonclinicalDeprtment;
				for (String s : nonClinicaldepartmentIdlist) {
					serviceCentreList.add(s);
				}
			}

			mapForDs.put("departmentIdlist", serviceCentreList);
			boolean opNursingAppointmentStatus = false;
			String nursingStation = request.getParameter("nursingStation");
			if (nursingStation != null && !nursingStation.equals("") && nursingStation.equalsIgnoreCase("nursing")) {
				opNursingAppointmentStatus = true;
			}
			mapForDs.put("opNursingAppointmentStatus", opNursingAppointmentStatus);

			int previousVisit = 0;
			String previousVisitId = request.getParameter("previousVisitId");
			if (previousVisitId != null && !previousVisitId.equals("")) {
				previousVisit = Integer.parseInt(previousVisitId);
			}
			mapForDs.put("previousVisit", previousVisit);

			if (request.getParameter("lastVisitId") != null && !request.getParameter("lastVisitId").equals("")) {
				int lastVisitId = Integer.parseInt(request.getParameter("lastVisitId"));
				mapForDs.put("lastVisitId", lastVisitId);
			}

			String visitNumber = request.getParameter(VISIT_NUMBER);
			if (visitNumber != null && !visitNumber.equals("")) {
				mapForDs.put("currentVisitNo", Integer.parseInt(visitNumber));
			}

			String age = (request.getParameter(AGE));
			mapForDs.put("userObj", userObj);
			mapForDs.put("age", age);

			String changedDate = request.getParameter(CHANGED_DATE);
			if (changedDate != null && !changedDate.equals("")) {
				mapForDs.put("addEditDate", HMSUtil.convertStringTypeDateToDateType(changedDate));
			}

			String changedTime = request.getParameter(CHANGED_TIME);
			if (changedTime != null && !changedTime.equals("")) {
				mapForDs.put("addEditTime", changedTime);
			}

			mapForDs.put("patient", patient);
			mapForDs.put("hinId", hinId);
			mapForDs.put("consultingDoctorId", consultingDoctorId);
			mapForDs.put("patientType", patientType);
			mapForDs.put("hospitalId", hospitalId);
			mapForDs.put("opBillHeader", opBillHeader);
			mapForDs.put("opBillDetails", opBillDetails);
			mapForDs.put("chargeId", chargeId);
			mapForDs.put("totalPastDue", totalPastDue);

			String appInvestigationStatus = "";
			String appFlag = request.getParameter("appFlag");
			if (appFlag != null && appFlag.equals("y")) {
				appInvestigationStatus = "y";
			} else {
				appInvestigationStatus = "n";
			}

			int appDepartmentId = 0;
			String appdepId = request.getParameter("appdepId");
			if (appdepId != null && !appdepId.equals("")) {
				appDepartmentId = Integer.parseInt(appdepId);
			}

			mapForDs.put("appDepartmentId", appDepartmentId);
			mapForDs.put("appInvestigationStatus", appInvestigationStatus);
			Map<String, Object> hospitalMap = registrationHandlerService.getHospital(hospitalId);

			if (hospitalMap.get("hospital") != null) {
				MasHospital hospital = (MasHospital) hospitalMap.get("hospital");
				savePatientEPFReportInToFileForLeanServer(request, response);
				if (hospital != null && hospital.getClientIp() != null && hospital.getClientPort() != null) {
					new Thread() {
						public void run() {
							// savePdfOfEhrToClient(requestVal,responseVal,finalHospital);
						}
					}.start();
				}
			}

			String pname = request.getParameter("pnameId");
			if (pname != null) {
				mapForDs.put("pname", pname);
			}

			String gender = request.getParameter("gender");
			if (gender != null) {
				mapForDs.put("gender", gender);
			}

			String ages = "";
			if (request.getParameter("age") != null) {
				ages = request.getParameter("age");
				mapForDs.put("ages", ages);
			}

			String mobno = request.getParameter("mobno");
			if (mobno != null) {
				mapForDs.put("mobileno", mobno);
			}

			String onlineAppointment = request.getParameter("onlineAppointment");
			if (onlineAppointment != null) {
				mapForDs.put("onlineAppointmentStauts", onlineAppointment);
			}

			String onlineAppId = request.getParameter("onlineAppId");
			if (onlineAppId != null) {
				mapForDs.put("onlineAppId", onlineAppId);
			}

			String requestedIP = request.getRemoteAddr();
			mapForDs.put("requestedIP", requestedIP);

			map = registrationHandlerService.saveVisitInformation(mapForDs);

			if (null != map.get("duplicateVisitSatatus")) {
				duplicateVisitSatatus = (Boolean) map.get("duplicateVisitSatatus");
			}

			if (!duplicateVisitSatatus) {
				if (null != map.get("successfullyAdded")) {
					successfullyAdded = (Boolean) map.get("successfullyAdded");
				}

				if (successfullyAdded) {
					message = " Visit information saved Successfully. Do You Want To Print Token ?";
				} else {
					message = "Some problem Occured! Try Again.";
				}

			} else {
				message = "Visit already created for this Department.";
			}

			String backUrl = "/hms/hms/registration?method=showPatientVisitJsp";
			map.put("backUrl", backUrl);
			map.put("departmentId", serviceCentreList);
			map.put("hinNo", hinNo);
			map.put("hinId", hinId);
			map.put("hospitalId", hospitalId);
			map.put("billNo", billNo);
			map.put("contentJsp", "PrintToken.jsp");
			map.put("flag", "visit");
			map.put("message", message);
			map.put("opsessionId", opsessionId);
			map.put("duplicateVisitSatatus", duplicateVisitSatatus);
			map.put("pname", pname);
			map.put("ages", ages);
			map.put("gender", gender);
			map.put("mobileno", mobno);
		}
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Mehtod for geting Discount Amount for scheme
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	public void Visitscheme(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside Visitscheme ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		String pUhidId = "";
		if (request.getParameter("hinNO") != null) {
			pUhidId = request.getParameter("hinNO");
		}

		int schemeId = 0;
		int chargeId = 0;
		if (request.getParameter("schemeId") != null) {
			schemeId = Integer.parseInt(request.getParameter("schemeId"));
		}

		if (request.getParameter("chargeId") != null) {
			chargeId = Integer.parseInt(request.getParameter("chargeId"));
		}

		map = registrationHandlerService.visitscheme(hospitalId, schemeId, chargeId, pUhidId);
		List<MasDiscount> localDiscountList = new ArrayList<MasDiscount>();
		if (null != map.get("localDiscountList")) {
			localDiscountList = (List<MasDiscount>) map.get("localDiscountList");
		}

		BigDecimal discountPer = null;
		BigDecimal discountAmount = null;
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (null != localDiscountList && localDiscountList.size() > 0) {
				for (MasDiscount masdiscount : localDiscountList) {
					discountPer = masdiscount.getDiscountPercentage();
					discountAmount = masdiscount.getDiscountValue();
					sb.append("<discount>" + discountPer + "</discount>");
					sb.append("<discountAmount>" + discountAmount + "</discountAmount>");
				}
			} else {
				sb.append("<discount>" + "0.0" + "</discount>");
				sb.append("<discountAmount>" + "0.0" + "</discountAmount>");
			}

			sb.append("</item>");
			LOGGER.debug("sb : " + sb.toString());

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while creating the response" + ioException.getStackTrace().toString());
		}
	}

	/**
	 * ----------------------------------- Update Patient
	 * Registration----------------------------
	 */

	public ModelAndView showUpdateSearchJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateSearchJsp ");

		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = registrationHandlerService.showRegistrationJsp(deptId, hospitalId);
		String jsp = "";
		if (null != request.getParameter("jsp") && request.getParameter("jsp").equals("registration")) {
			jsp = SEARCH_REGISTRATION_JSP;
		} else if (null != request.getParameter("jsp") && request.getParameter("jsp").equals("visit")) {
			jsp = SEARCH_VISIT_JSP;
		} else {
			jsp = SEARCH_REGISTRATION_JSP;
		}

		LOGGER.debug("jsp : " + jsp);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateRegistrationJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateRegistrationJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		String patientName = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
		} else if (request.getParameter(PATIENT_NAME) != null) {
			patientName = request.getParameter(PATIENT_NAME);
			parameterMap.put("patientName", patientName);
		}

		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome + fileSeparator + "uploadedImage" + fileSeparator;
		LOGGER.debug("uploadURL : " + uploadURL);
		parameterMap.put("hospitalId", hospitalId);
		Map<String, Object> patientDetailsMap = registrationHandlerService.getPatientDetailsForUpdate(parameterMap);
		List<Patient> patientList = new ArrayList<Patient>();
		if (patientDetailsMap.get("patientList") != null) {
			patientList = (List<Patient>) patientDetailsMap.get("patientList");
		}

		if (patientList.size() > 0) {
			map = registrationHandlerService.getUpdateRegistrationDetails();

			BigDecimal amount = new BigDecimal("0");
			String billNo = opBillingHandlerService.generateBillNo("OS", "display", hospitalId);
			LOGGER.debug("billNo : " + billNo);

			/**
			 * Added By Ritu as multiple Registration charges in mas_charge_code
			 * table
			 * 
			 */
			parameterMap.put("patientTypeId", patientDetailsMap.get("patientType"));
			parameterMap.put("companyId", patientDetailsMap.get("companyId"));
			parameterMap.put("regType", patientDetailsMap.get("regType")); // Default
																			// registration
																			// type
																			// is
			parameterMap.put("patientCategory", patientDetailsMap.get("patientCategory"));

			parameterMap.put("chargeId", map.get("chargeId"));
			parameterMap.put("mainChargeId", map.get("mainChargeId"));
			parameterMap.put("subChargeId", map.get("subChargeId"));
			parameterMap.put("billTypeId", 2);
			// general
			Map<String, Object> chargeMap = opBillingHandlerService.getChargeAmountAfterDiscount(parameterMap);
			if (chargeMap.get("chargeAmountAfterDis") != null) {
				amount = (BigDecimal) chargeMap.get("chargeAmountAfterDis");
				map.put("amount", amount);
			}
			if (chargeMap.get("rate") != null) {
				map.put("rate", chargeMap.get("rate"));
			}
			if (map.get("discAmt") != null) {
				map.put("discAmt", chargeMap.get("discAmt"));
			}
			if (chargeMap.get("stdDeduction") != null) {
				map.put("stdDeduction", chargeMap.get("stdDeduction"));
			}
			map.put("billNo", billNo);
			map.put("uploadURL", uploadURL);
			/*
			 * End of Code For Billing if registration is expired then renewval
			 * charge Code By Mukesh Narayan Singh Date 16 July 2010
			 */

			map.put("contentJsp", UPDATE_REGISTRATION_JSP);
			map.put("patientDetailsMap", patientDetailsMap);
		} else {
			map.put("contentJsp", SEARCH_REGISTRATION_JSP);
		}
		return new ModelAndView("index", "map", map);
	}

	/* /-----------Search for patient record-- added by kishore-----/ */

	/**
	 * Search patient from citizen database
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView searchPatientFromCitizen(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside searchPatientFromCitizen ");
		Map<String, Object> getDataMap = new HashMap<String, Object>();
		String uhid = "";

		int districtIdByHospital = 0;
		if (request.getParameter("districtId") != null) {
			districtIdByHospital = Integer.parseInt(request.getParameter("districtId"));
		}
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		String uh = request.getParameter("uh");
		if (uh != null && !uh.equals("")) {
			uhid = uh;
			getDataMap.put("uhid", uhid);
		}

		String hinNo = request.getParameter(HIN_NO);
		if (hinNo != null && !hinNo.equals("")) {
			uhid = hinNo;
			getDataMap.put("uhid", uhid);
		}

		String fullName = "";
		String fn = request.getParameter("fn");
		if (fn != null && !fn.equals("")) {
			fullName = fn.trim();
			getDataMap.put("fullName", fullName);
		}

		String pFullName = request.getParameter(P_FULL_NAME);
		if (pFullName != null && !pFullName.equals("")) {
			getDataMap.put("fullName", pFullName.trim());
		}

		String citizenAadhaar = request.getParameter("citzenAadhaar");
		if (citizenAadhaar != null && !citizenAadhaar.equals("")) {
			getDataMap.put("citzenAadhaar", citizenAadhaar.trim());
		}

		String dob = request.getParameter("dob");
		if (dob != null && !dob.equals("")) {
			getDataMap.put("dob", dob);
		}

		String birthDay = request.getParameter("birthDay");
		if (birthDay != null && !birthDay.equals("")) {
			getDataMap.put("dob", birthDay);
		}

		String dist = request.getParameter("dist");
		if (dist != null && !dist.equals("")) {
			getDataMap.put("districtId", Integer.parseInt(dist));
		}

		String pDistrict = request.getParameter(P_DISTRICT);
		if (pDistrict != null && !pDistrict.equals("")) {
			getDataMap.put("districtId", Integer.parseInt(pDistrict));
		}

		String sDistrict = request.getParameter("sdistrict");
		if (sDistrict != null && !sDistrict.equals("")) {
			getDataMap.put("districtId", Integer.parseInt(sDistrict));
		}

		String mobileNo = request.getParameter(MOBILE_NO);
		if (mobileNo != null && !mobileNo.equals("")) {
			getDataMap.put("mobileNumber", mobileNo);
		}

		String cMobile = request.getParameter("cmob");
		if (cMobile != null && !cMobile.equals("")) {
			getDataMap.put("mobileNumber", cMobile);
		}

		String tHouseNo = request.getParameter(T_HOUSE_NO);
		if (tHouseNo != null && !tHouseNo.equals("")) {
			getDataMap.put("HouseNo", tHouseNo);
		}

		getDataMap.put("page", page);

		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> searchDataMap = registrationHandlerService.searchPatientFromCitizen(getDataMap);
		if(request.getParameter("quickReg")!=null){
			map = registrationHandlerService.showQuickRegistrationJsp(deptId, hospitalId);
			map.put("contentJsp", "quickRegistration.jsp");

		}else{
			map = registrationHandlerService.showRegistrationJsp(deptId, hospitalId);
			map.put("contentJsp", REGISTRATION_JSP);
		}
		map.put("puhid", uhid);
		map.put("searchDataMap", searchDataMap);
		map.put("districtId", districtIdByHospital);

		map.put("ctizenDob", dob);
		map.put("citizenName", fullName);
		map.put("ctizenMob", mobileNo);
		map.put("citzenAadhaar", citizenAadhaar);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSearchPatientRecordsJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showSearchPatientRecordsJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> getDataMap = new HashMap<String, Object>();

		String uhid = "";

		if (request.getParameter("uh") != null && !request.getParameter("uh").equals("")) {
			uhid = request.getParameter("uh");
			getDataMap.put("uhid", uhid);
		}

		if (request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("")) {
			uhid = request.getParameter(HIN_NO);
			getDataMap.put("uhid", uhid);
		}

		String fullName = "";
		String fn = request.getParameter("fn");
		if (fn != null && !fn.equals("")) {
			fullName = fn.trim();
			getDataMap.put("fullName", fullName);
		}

		String pFullName = request.getParameter(P_FULL_NAME);
		if (pFullName != null && !pFullName.equals("")) {
			fullName = pFullName.trim();
			getDataMap.put("fullName", fullName);
		}

		String dob = request.getParameter("dob");
		if (dob != null && !dob.equals("")) {
			getDataMap.put("dob", dob);
		}

		String birthDay = request.getParameter("birthDay");
		if (birthDay != null && !birthDay.equals("")) {
			getDataMap.put("dob", birthDay);
		}

		String dist = request.getParameter("dist");
		if (dist != null && !dist.equals("")) {
			LOGGER.debug("districtId " + Integer.parseInt(dist));
			getDataMap.put("districtId", Integer.parseInt(dist));
		}
		String pDistrict = request.getParameter(P_DISTRICT);
		if (pDistrict != null && !pDistrict.equals("")) {
			LOGGER.debug("Test districtId " + Integer.parseInt(pDistrict));
			getDataMap.put("districtId", Integer.parseInt(pDistrict));
		}
		String mobileNo = request.getParameter(MOBILE_NO);
		if (mobileNo != null && !mobileNo.equals("")) {
			getDataMap.put("mobileNumber", mobileNo);
		}

		String tHouseNo = request.getParameter(T_HOUSE_NO);
		if (tHouseNo != null && !tHouseNo.equals("")) {
			getDataMap.put("HouseNo", tHouseNo);
		}
		String patientUpdate = "";
		String pUpdate = request.getParameter("pUpdate");
		if (pUpdate != null && !pUpdate.equals("")) {
			patientUpdate = pUpdate.trim();
		}

		HttpSession session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		String uidConver = "";
		String uIdConver = request.getParameter("UIDCOnver");
		if (uIdConver != null && !uIdConver.equals("")) {
			uidConver = uIdConver;
		}

		if (uidConver.equals("")) {
			map = registrationHandlerService.showRegistrationJsp(deptId, hospitalId);
		}

		int page = 1;
		String pageRequest = request.getParameter("page");
		if (pageRequest != null) {
			page = Integer.parseInt(pageRequest);
		}
		getDataMap.put("page", page);
		Map<String, Object> searchmap = registrationHandlerService.showSearchPatientRecords(getDataMap);

		String jsp = "";
		if (!uidConver.equals("") && uidConver.equalsIgnoreCase("UIDCOnver")) {
			jsp = UNHID_CONVERSION_JSP;
		} else if (!patientUpdate.equals("") && patientUpdate.equalsIgnoreCase("patientupdate")) {
			jsp = SEARCH_REGISTRATION_JSP;
		} else {
			jsp = REGISTRATION_JSP;
		}

		LOGGER.debug("Jsp : " + jsp);
		map.put("contentJsp", jsp);
		map.put("puhid", uhid);
		map.put("Searchmap", searchmap);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSearchPatientRecordsForVisitJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showSearchPatientRecordsForVisitJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> getDataMap = new HashMap<String, Object>();

		String uhid = "";
		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		getDataMap.put("page", page);
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			getDataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			getDataMap.put("deptId", deptId);
		}

		String fromAge = request.getParameter("fromAge");
		if (fromAge != null && !fromAge.equals("")) {
			getDataMap.put("FromAge", fromAge);
		}

		String toAge = request.getParameter("toAge");
		if (toAge != null && !toAge.equals("")) {
			LOGGER.debug("toAge " + toAge);
			getDataMap.put("toAge", toAge);
		}

		if (request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("")) {
			uhid = request.getParameter(HIN_NO);
			getDataMap.put("uhid", uhid);
			map.put("uhid", uhid);

		}
		if (request.getParameter("hinNo") != null && !request.getParameter("hinNo").equals("")) {
			uhid = request.getParameter("hinNo");
			getDataMap.put("uhid", uhid);
		}

		String fullName = "";
		if (request.getParameter(P_FULL_NAME) != null && !request.getParameter(P_FULL_NAME).equals("")) {
			fullName = request.getParameter(P_FULL_NAME).trim();
			getDataMap.put("fullName", fullName);
		}

		if (request.getParameter("fn") != null && !request.getParameter("fn").equals("")) {
			fullName = request.getParameter("fn").trim();
			getDataMap.put("fullName", fullName);
		}

		String mobNo = "";
		if (request.getParameter("mobno") != null && !request.getParameter("mobno").equals("")) {
			mobNo = request.getParameter("mobno").trim();
			getDataMap.put("mobno", mobNo);
		}

		if (request.getParameter("moNo") != null && !request.getParameter("moNo").equals("")) {
			mobNo = request.getParameter("moNo").trim();
			getDataMap.put("mobno", mobNo);
		}

		String dob = request.getParameter("dob");
		if (dob != null && !dob.equals("")) {
			getDataMap.put("dateOfBirth", HMSUtil.dateFormatterDDMMYYYY(dob));
		}

		String bitD = request.getParameter("bitD");
		if (bitD != null && !bitD.equals("") && !bitD.equals("null")) {
			getDataMap.put("dateOfBirth", HMSUtil.dateFormatterDDMMYYYY(bitD));
		}

		String pUhid = "";
		if (request.getParameter("pUhid") != null && !request.getParameter("pUhid").equals("")) {
			pUhid = request.getParameter("pUhid").trim();
		}
		
		if (request.getParameter("sAadhar") != null && !request.getParameter("sAadhar").equals("")) {
			String aadhar = request.getParameter("sAadhar").trim();
			getDataMap.put("aadhar", Long.parseLong(aadhar));
		}
		String visitSearch = "";
		if (request.getParameter("visitSearch") != null && !(request.getParameter("visitSearch").equals(""))) {
			visitSearch = request.getParameter("visitSearch");

		}
		getDataMap.put("visitSearch", visitSearch);
		map = registrationHandlerService.showSearchPatientRecordsForVisitJsp(getDataMap);

		map.put("visitSearch", visitSearch);
		map.put("pUhid", pUhid);
		
		if(request.getParameter("quickVisit")!=null){
			map.put("contentJsp", "quickRegistration.jsp");
		}else{
		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		}
		map.put("uhid", uhid);
		map.put("fullName", fullName);
		map.put("mobno", mobNo);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * Method for open the Update Patient Jsp
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showSearchPatientRecordsForUpdateJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showSearchPatientRecordsForUpdateJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> getDataMap = new HashMap<String, Object>();

		String uhinNo = "";
		String pUhid = "";
		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			getDataMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			getDataMap.put("deptId", deptId);
		}

		if (request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("")) {
			uhinNo = request.getParameter(HIN_NO);
			getDataMap.put("uhinNo", uhinNo);
		}

		String fullName = "";
		if (request.getParameter(P_FULL_NAME) != null && !request.getParameter(P_FULL_NAME).equals("")) {
			fullName = request.getParameter(P_FULL_NAME).trim();
			getDataMap.put("fullName", fullName);
		}

		if (request.getParameter("pUhid") != null && !request.getParameter("pUhid").equals("")) {
			pUhid = request.getParameter("pUhid").trim();
		}

		if (request.getParameter(DATE_OF_BIRTH) != null && !request.getParameter(DATE_OF_BIRTH).equals("")) {
			String dob = request.getParameter(DATE_OF_BIRTH);
			getDataMap.put("dob", dob);
		}

		String mobno = "";
		if (request.getParameter("mobno") != null && !request.getParameter("mobno").equals("")) {
			mobno = request.getParameter("mobno");
			getDataMap.put("mobno", mobno);
		}
		String dist = request.getParameter("district");
		if (dist != null && !dist.equals("")) {
			getDataMap.put("districtId", Integer.parseInt(dist));
		}
		String locality = "";
		if (request.getParameter("lsgName") != null && !request.getParameter("lsgName").equals("")) {
			locality = request.getParameter("lsgName");
			getDataMap.put("locality",Integer.parseInt(locality) );
		}
		String ward ="" ;
		if (request.getParameter("wardNo") != null && !request.getParameter("wardNo").equals("")) {
			ward=request.getParameter("wardNo");
			getDataMap.put("ward",Integer.parseInt(ward) );
		}
		map = registrationHandlerService.showSearchPatientRecordsForUpdateJsp(getDataMap);

		map.put("pUhid", pUhid);
		map.put("contentJsp", SEARCH_REGISTRATION_JSP);
		map.put("uhinNo", uhinNo);
		map.put("fullName", fullName);
		map.put("mobno", mobno);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * Update Patient Information
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView updatePatientInformation(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside updatePatientInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = 0;
		Map<String, Object> valuesMap = new HashMap<String, Object>();
		Patient patient = new Patient();

		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while creating the response " + ioException.getStackTrace().toString());
		}

		if (request.getParameter("phinId") != null) {
			hinId = Integer.parseInt(request.getParameter("phinId"));
			valuesMap.put("hinId", hinId);
		}

		String qpFullName = request.getParameter(Q_P_FULL_NAME);
		if (qpFullName != null && !qpFullName.equals("")) {
			patient.setPFirstName(qpFullName);
			patient.setFullName(qpFullName);
		}

		String monIncome = request.getParameter("monIncome");
		if (monIncome != null && !monIncome.equals("")) {
			patient.setMonthlyIncome(new BigDecimal(monIncome));
		}

		String incomeUpdateRemark = request.getParameter("incomeUpdateRemark");
		if (incomeUpdateRemark != null && !incomeUpdateRemark.equals("")) {
			patient.setIncomeUpdateRemarks(incomeUpdateRemark);
		}

		String ageUnit = "";
		if (request.getParameter(Q_AGE_UNIT) != null && !request.getParameter(Q_AGE_UNIT).equals("")) {
			ageUnit = request.getParameter(Q_AGE_UNIT);
		}

		String qRelationId = request.getParameter(Q_RELATION_ID);
		if (qRelationId != null && !qRelationId.equals("")) {
			MasRelation relation = new MasRelation();
			relation.setRelationName(qRelationId);
			patient.setRelation(relation);

		}
		String qRelativeName = request.getParameter(Q_RELATIVE_NAME);
		if (qRelativeName != null && !qRelativeName.equals("")) {
			patient.setFatherMotherName(qRelativeName);
		}

		String qAge = request.getParameter("qAge");
		if (qAge != null && !qAge.equals("")) {
			patient.setAge(qAge.concat(" ").concat(ageUnit));
		}

		String qGender = request.getParameter(Q_GENDER);
		if (qGender != null && !qGender.equals("")) {
			MasAdministrativeSex masSex = new MasAdministrativeSex();
			masSex.setId(Integer.parseInt(qGender));
			patient.setSex(masSex);
		}

		String qDateOfBirth = request.getParameter(Q_DATE_OF_BIRTH);
		if (qDateOfBirth != null && !(qDateOfBirth.equals(""))) {
			patient.setDateOfBirth(HMSUtil.dateFormatterDDMMYYYY(qDateOfBirth));
		}

		if (request.getParameter(Q_AGE) != null) {
			if (request.getParameter(Q_AGE) != null) {
				patient.setAge(qAge.concat(" ").concat(ageUnit));
			}
		}

		String dobDocumentId = request.getParameter("dobDocumentId");
		if (null != dobDocumentId && !dobDocumentId.equals("")) {
			MasIdCard dobIdCard = new MasIdCard();
			dobIdCard.setId(Integer.parseInt(dobDocumentId));
			patient.setDobOtherCard(dobIdCard);
		}

		String dobDocumentIdNumber = request.getParameter("dobDocumentIdNumber");
		if (null != dobDocumentIdNumber && !dobDocumentIdNumber.equals("")) {
			patient.setDobOtherCardNumber(dobDocumentIdNumber);
		}

		String updOtherIdCardId = request.getParameter("updOtherIdCardId");
		if (null != updOtherIdCardId && !updOtherIdCardId.equals("")) {
			MasIdCard updOtherIdCard = new MasIdCard();
			updOtherIdCard.setId(Integer.parseInt(updOtherIdCardId));
			patient.setIdCard(updOtherIdCard);
		}

		String updOtherIdCardNumber = request.getParameter("updOtherIdCardNumber");
		if (null != updOtherIdCardNumber && !updOtherIdCardNumber.equals("")) {
			patient.setIdNo(updOtherIdCardNumber);
		}
		String paientOldName = request.getParameter("paient_old_name");
		if (paientOldName != null && !paientOldName.equals("")) {
			patient.setPatientOldName(paientOldName);
		}

		PatientAddress pPermAddr = new PatientAddress();
		int permanentAddressTypeId = Integer.parseInt(properties.getProperty("permanentAddressTypeId"));
		int temporaryAddressTypeId = Integer.parseInt(properties.getProperty("temporaryAddressTypeId"));

		if (request.getParameter("permAddr") != null && !request.getParameter("permAddr").equals("")) {
			if (request.getParameter("permAddr").equalsIgnoreCase("y")) {
				MasAddressType masAddrType = new MasAddressType();
				masAddrType.setId(permanentAddressTypeId);
				pPermAddr.setAddressType(masAddrType);

				String pLocality = request.getParameter(P_LOCALITY);
				if (pLocality != null && !pLocality.equals("")) {
					PhMasLocality masLocality = new PhMasLocality();
					masLocality.setId(Integer.parseInt(pLocality));
					pPermAddr.setLocality(masLocality);
				}

				if (request.getParameter(P_LSG_HOUSE_NO) != null && !request.getParameter(P_LSG_HOUSE_NO).equals("")) {
					String lsgHno = request.getParameter(P_LSG_HOUSE_NO);
					pPermAddr.setLsgHouseNo(lsgHno);
				}

				String pHouseNo = request.getParameter(P_HOUSE_NO);
				if (pHouseNo != null && !pHouseNo.equals("")) {
					pPermAddr.setHouseNo(pHouseNo);
				}

				String pDistrict = request.getParameter(P_DISTRICT);
				if (pDistrict != null && !pDistrict.equals("")) {
					LOGGER.info("districtId  " + Integer.parseInt(pDistrict));
					MasDistrict masDist = new MasDistrict();
					masDist.setId(Integer.parseInt(pDistrict));
					pPermAddr.setDistrict(masDist);
				}

				String pPinCode = request.getParameter(P_PINCODE);
				if (pPinCode != null && !pPinCode.equals("")) {
					pPermAddr.setPinCode(Long.parseLong(pPinCode));
				}
			}

			valuesMap.put("pPermAddr", pPermAddr);

		}

		PatientAddress pTempAddr = new PatientAddress();
		if (request.getParameter("pTempAddr") != null && !request.getParameter("pTempAddr").equals("")) {

			String tempdocumentId = request.getParameter("tempdocumentId");
			if (tempdocumentId != null && !tempdocumentId.equals("")) {
				MasIdCard idCard = new MasIdCard();
				idCard.setId(Integer.parseInt(tempdocumentId));
				patient.setTemAddressIdProof(idCard);
				String tempotherIdCardNumber = request.getParameter("tempotherIdCardNumber");
				patient.setTempAddressIdProofNum(tempotherIdCardNumber);
			}

			if (request.getParameter("pTempAddr").equalsIgnoreCase("y")) {
				MasAddressType masAddrType = new MasAddressType();
				masAddrType.setId(temporaryAddressTypeId);
				pTempAddr.setAddressType(masAddrType);

				String tLsgName = request.getParameter(T_LSG_NAME);
				if (tLsgName != null && !tLsgName.equals("")) {
					MasLsg masLsgName = new MasLsg();
					masLsgName.setId(Integer.parseInt(tLsgName));
					pTempAddr.setLsgName(masLsgName);
				}
				String tWard = request.getParameter(T_WARD);
				if (tWard != null && !tWard.equals("")) {
					pTempAddr.setWardName(tWard);
				}
				String tLocality = request.getParameter(T_LOCALITY);
				if (tLocality != null && !tLocality.equals("")) {
					PhMasLocality masLocality = new PhMasLocality();
					masLocality.setId(Integer.parseInt(tLocality));
					pPermAddr.setLocality(masLocality);
				}
				String tlsgHouseNo = request.getParameter(T_LSG_HOUSE_NO);
				if (tlsgHouseNo != null && !tlsgHouseNo.equals("")) {
					pTempAddr.setLsgHouseNo(tlsgHouseNo);
				}
				String tHouseNo = request.getParameter(T_HOUSE_NO);
				if (tHouseNo != null && !tHouseNo.equals("")) {
					pTempAddr.setHouseNo(tHouseNo);
				}
				String tHealthHouseid = request.getParameter(T_HEALTH_HOUSE_ID);
				if (tHealthHouseid != null && !tHealthHouseid.equals("")) {
					pTempAddr.setHealthHouseId(tHealthHouseid);
				}

				String tDisctrict = request.getParameter(T_DISTRICT);
				if (tDisctrict != null && !tDisctrict.equals("")) {
					MasDistrict masDist = new MasDistrict();
					masDist.setId(Integer.parseInt(tDisctrict));
					pTempAddr.setDistrict(masDist);

				}
				String tTaluk = request.getParameter(T_TALUK);
				if (tTaluk != null && !tTaluk.equals("")) {
					MasTaluk taluk = new MasTaluk();
					taluk.setId(Integer.parseInt(tTaluk));
					pTempAddr.setTaluk(taluk);
				}

				String tPostOffice = request.getParameter(T_POST_OFFICE);
				if (tPostOffice != null && !tPostOffice.equalsIgnoreCase("") && !tPostOffice.equalsIgnoreCase(" ")) {
					int postCodeId = Integer.parseInt(tPostOffice);
					if (postCodeId > 0) {
						MasPostCode masPostCode = new MasPostCode();
						masPostCode.setId(postCodeId);
						pTempAddr.setPostOffice(masPostCode);
					}
				}

				String tPinCode = request.getParameter(T_PINCODE);
				if (tPinCode != null && !tPinCode.equals("")) {
					pTempAddr.setPinCode(Long.parseLong(tPinCode));
				}
			}

			valuesMap.put("pTempAddr", pTempAddr);
		}

		String fromOtherIndianStates = properties.getProperty("fromOtherIndianStates");
		String nativer = properties.getProperty("nativer");

		String nativeddd = request.getParameter("nativeddd");
		if (nativeddd != null) {
			if (nativeddd.equals("native")) {

				patient.setNativityType(nativer);
				String nativity = request.getParameter("nativity");
				if (nativity != null && !nativity.equals("") && nativity.equals("resident")) {
					patient.setNativity(request.getParameter("resident"));
				} else if (nativity != null && !nativity.equals("") && nativity.equals("nrk")) {
					patient.setNativity(request.getParameter("nrk"));

					String nrkState = request.getParameter(NRK_STATE);
					if (nrkState != null && !nrkState.equals("")) {
						MasState mState = new MasState();
						mState.setId(Integer.parseInt(nrkState));
						patient.setState(mState);
					}
				} else {
					patient.setNativity(request.getParameter("nri"));
					String nriNationality = request.getParameter(NRI_NATIONALITY);
					if (nriNationality != null && !nriNationality.equals("")) {
						MasCountry nationality = new MasCountry();
						nationality.setId(Integer.parseInt(nriNationality));
					}
				}
			} else if (request.getParameter("otherState").equals("otherState")) {

				patient.setNativityType(fromOtherIndianStates);
				String migrantState = request.getParameter(MIGRANT_STATE);
				if (migrantState != null && !migrantState.equals("")) {
					MasState mState = new MasState();
					mState.setId(Integer.parseInt(migrantState));
					patient.setState(mState);
				}
				String migrantDistrict = request.getParameter(MIGRANT_DISTRICT);
				if (migrantDistrict != null && !migrantDistrict.equals("")) {
					MasDistrict masDist = new MasDistrict();
					masDist.setId(Integer.parseInt(migrantDistrict));
					pTempAddr.setDistrict(masDist);
				}
				String migrantPurpose = request.getParameter(MIGRANT_PURPOSE);
				if (migrantPurpose != null && !migrantPurpose.equals("")) {
					MasOccupation masOccupation = new MasOccupation();
					masOccupation.setId(Integer.parseInt(migrantPurpose));
					patient.setOccupation(masOccupation);
				}
			} else {
				if (request.getParameter("foreigner").equals("foreigner")) {

					String foreigner = properties.getProperty("foreigner");
					patient.setNativityType(foreigner);

					String foriegnNationality = request.getParameter(FOREIGNER_NATIONALITY);
					if (foriegnNationality != null && !foriegnNationality.equals("")) {
						MasCountry nationality = new MasCountry();
						nationality.setId(Integer.parseInt(foriegnNationality));
					}
					String foriegnerPurpose = request.getParameter(FOREIGNER_PURPOSE);
					if (foriegnerPurpose != null && !foriegnerPurpose.equals("")) {
						MasOccupation masOccupation = new MasOccupation();
						masOccupation.setId(Integer.parseInt(foriegnerPurpose));
						patient.setOccupation(masOccupation);
					}
					String passportNumber = request.getParameter(PASSPORTNUMBER);
					if (passportNumber != null && !passportNumber.equals("")) {
						patient.setPassportNo(passportNumber);
					}
					String visaType = request.getParameter(VISA_TYPE);
					if (visaType != null && !visaType.equals("")) {
						MasVisaType masVisaType = new MasVisaType();
						masVisaType.setId(Integer.parseInt(visaType));
						patient.setVisaType(masVisaType);
					}
					String visaFromDate = request.getParameter(VISA_FROMDATE);
					if (visaFromDate != null && !visaFromDate.equals("")) {
						patient.setVisaFrom(HMSUtil.dateFormatterDDMMYYYY(visaFromDate));
					}
					String visaToDate = request.getParameter(VISA_TODATE);
					if (visaToDate != null && !visaToDate.equals("")) {
						patient.setVisaTo(HMSUtil.dateFormatterDDMMYYYY(visaToDate));
					}
				}
			}
		}

		String occupationId = request.getParameter(OCCUPATION_ID);
		if (occupationId != null && !occupationId.equals("")) {
			MasOccupation masOccupation = new MasOccupation();
			masOccupation.setId(Integer.parseInt(occupationId));
			patient.setOccupation(masOccupation);
		}

		String bloodGroupId = request.getParameter("bloodGroupId");
		LOGGER.debug("bloodGroupId : " + bloodGroupId);
		if (bloodGroupId != null && !bloodGroupId.equals("")) {
			MasBloodGroup masBloodGroup = new MasBloodGroup();
			masBloodGroup.setId(Integer.parseInt(bloodGroupId));
			patient.setBloodGroup(masBloodGroup);

			String bloodGroupName = request.getParameter("bloodGroupName");
			if (bloodGroupName != null && !bloodGroupName.equals("")) {
				patient.setBloodGroupValue(bloodGroupName);
			}
			patient.setVerbalStatus("y");
		}

		String mobile = request.getParameter(MOBILE);
		if (mobile != null && !mobile.equals("")) {
			patient.setMobileNumber(mobile);
		}
		patient.setPatientStatus("Out Patient");

		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String currentTime = (String) utilMap.get("currentTime");

		patient.setRegDate(new Date());
		patient.setRegTime(currentTime);

		valuesMap.put("patient", patient);

		Users userObj = new Users();
		if (session != null) {
			String deptId = null;
			synchronized (session) {
				if (session.getAttribute("users") != null) {
					userObj = (Users) session.getAttribute("users");
					int userId = userObj.getId();
					if (userObj.getDepartment().getId() != 0) {
						deptId = userObj.getDepartment().getId().toString();
					} else {
						deptId = null;
					}
					userObj.setId(userId);
					valuesMap.put("userId", userId);
					valuesMap.put("deptId", deptId);
				}
			}
		}

		String message = "";
		boolean successfullyUpdated = registrationHandlerService.updateRegistrationInformation(valuesMap);
		if (successfullyUpdated) {
			message = " Registration Information  Updated Successfully.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		String hinNo = registrationHandlerService.getHinNo(hinId);
		map.put("hinNo", hinNo);
		String backUrl = "/hms/hms/registration?method=showUpdateSearchJsp";
		map.put("backUrl", backUrl);
		map.put("contentJsp", MESSAGE_FOR_ADT_JSP + ".jsp");
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- Upadate Patient Visit
	 * ----------------------------
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView showUpdateVisitJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showUpdateVisitJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		String hinNo = "";
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			parameterMap.put("hinNo", hinNo);
		}
		String visitNumber = request.getParameter(VISIT_NUMBER);
		if (visitNumber != null && !visitNumber.equals("")) {
			parameterMap.put("visitNo", Integer.parseInt(visitNumber));
		}
		if (hospitalId != 0) {
			parameterMap.put("hospitalId", hospitalId);
		}
		Map<String, Object> patientVisitMap = registrationHandlerService.getPatientVisitDetailsForUpdate(parameterMap);
		List<Object> visitList = new ArrayList<Object>();
		if (patientVisitMap.get("visitList") != null) {
			visitList = (List<Object>) patientVisitMap.get("visitList");
		}
		if (visitList.size() > 0) {
			map = registrationHandlerService.getVisitDetails(hospitalId);
			map.put("contentJsp", UPDATE_PATIENT_VISIT_JSP);
			map.put("patientVisitMap", patientVisitMap);
		} else {
			map.put("contentJsp", SEARCH_VISIT_JSP);
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateIpPatientInformation(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside updateIpPatientInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int inpatientid = 0;
		if (request.getParameter("inPatientId") != null) {
			inpatientid = Integer.parseInt(request.getParameter("inPatientId"));
			parameterMap.put("inpatientid", inpatientid);
		}
		String address=null;
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
			parameterMap.put("address", address);

		}
		String bysterName=null;
		if (request.getParameter("bysterName") != null) {
			bysterName = request.getParameter("bysterName");
			parameterMap.put("bysterName", bysterName);

		}
		String contectNo=null;
		if (request.getParameter("contectNo") != null) {
			contectNo = request.getParameter("contectNo");
			parameterMap.put("contectNo", contectNo);

		}
		String relation=null;
		//System.out.println("..............1111..................."+request.getParameter("relation"));
		if (request.getParameter("relation")!= null) {
			relation = request.getParameter("relation");
			parameterMap.put("relation", relation);

		}
		HttpSession session = request.getSession();
		synchronized (session) {
			Users user = (Users) session.getAttribute("users");
			parameterMap.put("userId", user.getId());
		}
		int hinId=0;
		if (request.getParameter("hinId") != null) {
			 hinId = Integer.parseInt(request.getParameter("hinId"));
			parameterMap.put("hinId", hinId);
		}
		boolean successfullyUpdated = registrationHandlerService.updateIpPatientInformation(parameterMap);

		String message = "";

		if (successfullyUpdated) {
			message = " Patient Visit Information For In Patient Updated Successfully.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		String jsp = MESSAGE_FOR_ADT_JSP;
		jsp += ".jsp";
		String backUrl = "/hms/hms/adt?method=showIpAdmissionDetailJsp&selectedAppId=A2145&childAppId=A2144";
		map.put("backUrl", backUrl);
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateVisitInformation(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside updateVisitInformation ");
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String visitId = request.getParameter(VISIT_ID);
		if (visitId != null) {
			parameterMap.put("visitId", Integer.parseInt(visitId));
		}

		String complaintId = request.getParameter(COMPLAINT_ID);
		if (!(complaintId.equals("0"))) {
			parameterMap.put("complaintId", Integer.parseInt(complaintId));

		}
		String caseTypeId = request.getParameter(CASE_TYPE_ID);
		if (!(caseTypeId.equals("0"))) {
			parameterMap.put("caseTypeId", Integer.parseInt(caseTypeId));
		}

		String diagnoseId = request.getParameter(DIAGNOSIS_ID);
		if (!(diagnoseId.equals("0"))) {
			parameterMap.put("diagnosisId", Integer.parseInt(diagnoseId));
		}

		String disposalId = request.getParameter(DISPOSAL_ID);
		if (disposalId != null && !(disposalId.equals("0"))) {
			parameterMap.put("disposalId", Integer.parseInt(disposalId));
		}

		String hospitalStaff = request.getParameter(HOSPITAL_STAFF);
		if (hospitalStaff != null) {
			parameterMap.put("hospitalStaff", hospitalStaff);
		}

		synchronized (session) {
			Users user = (Users) session.getAttribute("users");
			parameterMap.put("userId", user.getId());
		}
		String changedDate = request.getParameter(CHANGED_DATE);
		if (changedDate != null) {
			parameterMap.put("addEditDate", HMSUtil.convertStringTypeDateToDateType(changedDate));
		}
		String changedTime = request.getParameter(CHANGED_TIME);
		if (changedTime != null) {
			parameterMap.put("addEditTime", changedTime);
		}

		boolean successfullyUpdated = registrationHandlerService.updateVisitInformation(parameterMap);
		LOGGER.debug("successfullyUpdated : " + successfullyUpdated);

		String message = "";
		if (successfullyUpdated) {
			message = " Patient Visit Information Updated Successfully.";
		} else {
			message = "Some problem Occured! Try Again.";
		}
		map.put("contentJsp", MESSAGE_FOR_ADT_JSP + ".jsp");
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- Methods For Ajax Response
	 * ----------------------------
	 */
	public void calculateAgeInAjax(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside calculateAgeInAjax ");
		Box box = HMSUtil.getBox(request);

		try {
			// get a calendar representing their birth date

			Calendar cal = Calendar.getInstance();
			cal.setTime(HMSUtil.dateFormatterDDMMYYYY(box.getString("dateOfBirth")));

			int birthYear = cal.get(Calendar.YEAR);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date birthDate = sdf.parse(box.getString("dateOfBirth"));

			int years = 0;
			int months = 0;
			int days = 0;
			// create calendar object for birth day
			Calendar birthDay = Calendar.getInstance();
			birthDay.setTimeInMillis(birthDate.getTime());
			// create calendar object for current day
			long currentTime = System.currentTimeMillis();
			Calendar now = Calendar.getInstance();
			now.setTimeInMillis(currentTime);
			// Get difference between years
			years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
			int currMonth = now.get(Calendar.MONTH) + 1;
			int birthMonth = birthDay.get(Calendar.MONTH) + 1;

			// Get difference between months
			months = currMonth - birthMonth;
			// if month difference is in negative then reduce years by one and

			// calculate the number of months.
			if (months < 0) {
				years--;
				months = 12 - birthMonth + currMonth;
				if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
					months--;
				}
			} else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
				years--;
				months = 11;
			}

			// Calculate the days
			if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
				days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
			} else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
				int today = now.get(Calendar.DAY_OF_MONTH);
				now.add(Calendar.MONTH, -1);
				days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
			} else {
				days = 0;
				if (months == 12) {
					years++;
					months = 0;
				}
			}
			LOGGER.debug("days : " + days + " months : " + months + " years : " + years);
			// added by govind 01-09-2017
			boolean leafYear = false;
			int dayCount = 0;
			if (birthYear % 400 == 0) {
				leafYear = true;
			} else if (birthYear % 100 == 0) {
				leafYear = false;
			} else if (birthYear % 4 == 0) {
				leafYear = true;
			} else {
				leafYear = false;
			}

			if (months > 1) {
				dayCount++;
			} else if (months == 1 && days == 0) {
				dayCount++;
			} else {
				if (leafYear) {
					if (birthMonth == 2) {
						if (days >= 29) {
							dayCount++;
						}
					} else {
						if (days >= 30) {
							dayCount++;
						}
					}
				} else {
					if (birthMonth == 2) {
						if (days >= 28) {
							dayCount++;
						}
					} else {
						if (days >= 30) {
							dayCount++;
						}
					}
				}
			}
			long calDays = new Date().getTime() - birthDate.getTime();
			int totDays = (int) TimeUnit.DAYS.convert(calDays, TimeUnit.MILLISECONDS);
			LOGGER.debug("totDays : " + totDays);
			LOGGER.debug("birth Month : " + birthMonth + " days : " + days + " birthYear : " + birthYear
					+ " leafYear : " + leafYear);
			LOGGER.debug("dayCount : " + dayCount);
			// added by govind 01-09-2017 end
			// Create new Age object
			String period = "";
			int age = 0;

			if (years <= 0 && months != 0 && dayCount > 0) {
				period = "Months";
				age = months;

			} else {
				if (birthMonth == 2) {
					if (totDays >= 28) {
						period = "Months";
						age = months;
					} else {
						period = "Days";
						age = days;
					}
				} else {
					if (totDays >= 30) {
						period = "Months";
						age = months;
					} else {
						period = "Days";
						age = days;
					}
				}

			}
			if (years > 0) {
				period = "Years";
				age = years;

			}
			if (years == 0 && months == 0 && days == 0) {
				period = "Days";
				age = 1;
			}

			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			sb.append("<age>" + age + "</age>");
			sb.append("<period>" + period + "</period>");
			sb.append("<birthYear>" + birthYear + "</birthYear>");
			sb.append("</item>");
			LOGGER.debug("sb : " + sb.toString());

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (ParseException parseException) {
			LOGGER.error("Error while parsing the date " + parseException.getStackTrace().toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while creating the response " + ioException.getStackTrace().toString());
		}
	}

	/**
	 * method to populate Ward based on taluk Id
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void populateWardOnTaluk(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

	}

	@SuppressWarnings("unchecked")
	public void populatePatientOnAadharNo(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientOnAadharNo ");
		Map<String, Object> map = registrationHandlerService
				.populatePatientOnAadharNo(request.getParameter("aadharNo"));

		List<PhMemberSurvey> memberServeyList = new ArrayList<PhMemberSurvey>();
		if (map.get("memberServeyList") != null) {
			memberServeyList = (List<PhMemberSurvey>) map.get("memberServeyList");
		}

		String name = "";
		long aadhar = 0;
		int genderId = 0;
		String dob = "";
		String yob = "";
		String mobNo = "";
		int ocupationId = 0;
		String nativity = "";

		for (PhMemberSurvey ph : memberServeyList) {
			if (ph.getAadhaarNo() != null) {
				aadhar = ph.getAadhaarNo();
			}
			name = ph.getName();
			if (ph.getGender() != null) {
				genderId = ph.getGender().getId();
			}
			if (ph.getDateOfBirth() != null) {
				dob = HMSUtil.convertDateTypeToStringWithoutTime(ph.getDateOfBirth());
			}

			yob = ph.getYearOfBirth();
			mobNo = ph.getContactNo();
			if (ph.getOccupation() != null) {
				ocupationId = ph.getOccupation().getId();
			}
			nativity = ph.getNativity();

			LOGGER.debug("mobNo : " + mobNo);
			LOGGER.debug("ocupationId : " + ocupationId);
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");

		if (aadhar != 0) {
			sb.append("<aadhar>" + aadhar + "</aadhar>");
		} else {
			sb.append("<aadhar>" + " " + "</aadhar>");
		}

		if (null != name) {
			sb.append("<name>" + name + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}
		if (genderId > 0) {
			sb.append("<gender>" + genderId + "</gender>");
		} else {
			sb.append("<gender>" + " " + "</gender>");
		}
		if (dob != null) {
			sb.append("<dob>" + dob + "</dob>");
		} else {
			sb.append("<dob>" + " " + "</dob>");
		}
		if (yob != null) {
			sb.append("<yob>" + yob + "</yob>");
		} else {
			sb.append("<yob>" + " " + "</yob>");
		}
		if (mobNo != null) {
			sb.append("<mob>" + mobNo + "</mob>");
		} else {
			sb.append("<mob>" + " " + "</mob>");
		}
		if (ocupationId > 0) {
			sb.append("<occupation>" + ocupationId + "</occupation>");
		} else {
			sb.append("<occupation>" + " " + "</occupation>");
		}

		if (nativity != null) {
			sb.append("<nativity>" + nativity + "</nativity>");
		} else {
			sb.append("<nativity>" + " " + "</nativity>");
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	/**
	 * Method to populate patient Registration update form
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void searchPatientForUpdateRegistration(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside searchPatientForUpdateRegistration");

		Patient patientDetail = null;
		PatientAddress aadharAddress = null;
		PatientAddress permanentAddress = null;
		PatientAddress temporaryAddress = null;

		String uhidNo = request.getParameter("uhidNo");
		Map<String, Object> map = registrationHandlerService.searchPatientForUpdateRegistration(uhidNo);

		if (map.get("patientDetail") != null) {
			patientDetail = (Patient) map.get("patientDetail");
		}
		if (map.get("aadharAddress") != null) {
			aadharAddress = (PatientAddress) map.get("aadharAddress");
		}
		if (map.get("permanentAddress") != null) {
			permanentAddress = (PatientAddress) map.get("permanentAddress");
		}
		if (map.get("TemporaryAddress") != null) {
			temporaryAddress = (PatientAddress) map.get("TemporaryAddress");
		}

		boolean status = true;
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");

		if (patientDetail != null && patientDetail.getAadhaarNo() != null) {
			status = false;
			sb.append("<aadharDoc>" + "Aadhaar" + "</aadharDoc>");
		}
		if (status) {
			if (patientDetail.getIdCard() != null) {
				sb.append("<otherDoc>" + patientDetail.getIdCard().getIdCardName() + "</otherDoc>");
				sb.append("<otherDocId>" + patientDetail.getIdCard().getId() + "</otherDocId>");
				sb.append("<otherDocNum>" + patientDetail.getIdNo() + "</otherDocNum>");
			} else {
				sb.append("<otherDoc>" + " " + "</otherDoc>");
				sb.append("<otherDocNum>" + " " + "</otherDocNum>");
				sb.append("<otherDocId>" + "" + "</otherDocId>");
			}
		} else {
			sb.append("<otherDoc>" + " " + "</otherDoc>");
			sb.append("<otherDocNum>" + " " + "</otherDocNum>");
			sb.append("<otherDocId>" + "" + "</otherDocId>");
		}
		if (patientDetail.getPFirstName() != null) {
			sb.append("<name>" + patientDetail.getPFirstName() + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}

		if (patientDetail.getAadhaarNo() != null) {
			sb.append("<aadhar>" + patientDetail.getAadhaarNo() + "</aadhar>");
		} else {
			sb.append("<aadhar>" + "" + "</aadhar>");
		}

		if (patientDetail.getDobOtherCard() != null) {
			sb.append("<dobOtherCardId>" + patientDetail.getDobOtherCard().getId() + "</dobOtherCardId>");
			sb.append("<dobOtherCardIdNum>" + patientDetail.getDobOtherCardNumber() + "</dobOtherCardIdNum>");

		} else {
			sb.append("<dobOtherCardId>" + "" + "</dobOtherCardId>");
			sb.append("<dobOtherCardIdNum>" + "" + "</dobOtherCardIdNum>");
		}

		if (patientDetail.getTemAddressIdProof() != null) {
			sb.append("<tempdocumentId>" + patientDetail.getTemAddressIdProof().getId() + "</tempdocumentId>");
			sb.append("<tempotherIdCardNumber>" + patientDetail.getTempAddressIdProofNum() + "</tempotherIdCardNumber>");

		} else {
			sb.append("<tempdocumentId>" + "" + "</tempdocumentId>");
			sb.append("<tempotherIdCardNumber>" + "" + "</tempotherIdCardNumber>");
		}

		if (patientDetail.getHinNo() != null) {
			sb.append("<uhidNo>" + patientDetail.getHinNo() + "</uhidNo>");
		} else {
			sb.append("<uhidNo>" + "" + "</uhidNo>");
		}
		if (patientDetail.getMonthlyIncome() != null) {
			sb.append("<monthlyIncome>" + patientDetail.getMonthlyIncome() + "</monthlyIncome>");
		} else {
			sb.append("<monthlyIncome>" + "" + "</monthlyIncome>");
		}

		if (patientDetail.getIncomeUpdateRemarks() != null) {
			sb.append("<incomeUpdateRemarks>" + patientDetail.getIncomeUpdateRemarks() + "</incomeUpdateRemarks>");
		} else {
			sb.append("<incomeUpdateRemarks>" + "" + "</incomeUpdateRemarks>");
		}

		if (patientDetail.getAge() != null) {
			String[] ageNum = patientDetail.getAge().split(" ");
			sb.append("<age>" + ageNum[0] + "</age>");
			sb.append("<ageUnit>" + ageNum[1] + "</ageUnit>");
		} else {
			sb.append("<age>" + "" + "</age>");
		}

		if (patientDetail.getBplStatus() != null) {
			sb.append("<familyStatus>" + patientDetail.getBplStatus() + "</familyStatus>");
		} else {
			sb.append("<familyStatus>" + "" + "</familyStatus>");
		}

		if (patientDetail.getVisaType() != null) {
			sb.append("<visaTypeId>" + patientDetail.getVisaType().getId() + "</visaTypeId>");
			sb.append("<visaTypeIdName>" + patientDetail.getVisaType().getVisaTypeName() + "</visaTypeIdName>");
			sb.append("<fromValid>" + HMSUtil.convertDateToStringTypeDateOnly(patientDetail.getVisaFrom())
					+ "</fromValid>");
			sb.append("<toValid>" + HMSUtil.convertDateToStringTypeDateOnly(patientDetail.getVisaTo()) + "</toValid>");
		} else {
			sb.append("<visaTypeId>" + "" + "</visaTypeId>");
			sb.append("<visaTypeIdName>" + "" + "</visaTypeIdName>");
			sb.append("<fromValid>" + "" + "</fromValid>");
			sb.append("<toValid>" + "" + "</toValid>");
		}

		if (patientDetail.getPassportNo() != null) {
			sb.append("<passortNo>" + patientDetail.getPassportNo() + "</passortNo>");
		} else {
			sb.append("<passortNo>" + "" + "</passortNo>");
		}
		if (patientDetail.getId() > 0) {
			sb.append("<Uhid>" + patientDetail.getId() + "</Uhid>");
			sb.append("<hinid>" + patientDetail.getId() + "</hinid>");
		} else {
			sb.append("<Uhid>" + "" + "</Uhid>");
			sb.append("<hinid>" + "" + "</hinid>");
		}

		if (patientDetail.getDateOfBirth() != null) {
			sb.append("<birthYear>" + HMSUtil.changeDateToddMMyyyy(patientDetail.getDateOfBirth()) + "</birthYear>");
		} else {
			sb.append("<birthYear>" + "" + "</birthYear>");
		}

		if (patientDetail.getEmailId() != null) {
			sb.append("<uemail>" + patientDetail.getEmailId() + "</uemail>");
		} else {
			sb.append("<uemail>" + "" + "</uemail>");
		}

		if (patientDetail.getMobileNumber() != null) {
			sb.append("<mobNumber>" + patientDetail.getMobileNumber() + "</mobNumber>");
		} else {
			sb.append("<mobNumber>" + "" + "</mobNumber>");
		}
		if (patientDetail.getAadhaarNo() != null) {
			sb.append("<aadhaarNo>" + patientDetail.getAadhaarNo() + "</aadhaarNo>");
		} else {
			sb.append("<aadhaarNo>" + "" + "</aadhaarNo>");
		}
		if (patientDetail.getSex() != null) {
			sb.append("<mgender>" + patientDetail.getSex().getAdministrativeSexName() + "</mgender>");
			sb.append("<mgenderId>" + patientDetail.getSex().getId() + "</mgenderId>");
		} else {
			sb.append("<mgender>" + "" + "</mgender>");
			sb.append("<mgenderId>" + "" + "</mgenderId>");
		}

		if (patientDetail.getRelation() != null) {
			sb.append("<relation>" + patientDetail.getRelation().getRelationName() + "</relation>");
		} else {
			sb.append("<relation>" + "" + "</relation>");
		}

		if (patientDetail.getFatherMotherName() != null) {
			sb.append("<relativeName>" + patientDetail.getFatherMotherName()+ "</relativeName>");
		} else {
			sb.append("<relativeName>" + "" + "</relativeName>");
		}

		if (patientDetail.getNotionalDobStatus() != null) {
			sb.append("<Ndob>" + patientDetail.getNotionalDobStatus() + "</Ndob>");
		} else {
			sb.append("<Ndob>" + "" + "</Ndob>");
		}
		if (null != patientDetail.getPatientType()) {
			sb.append("<socialId>" + patientDetail.getPatientType().getId() + "</socialId>");
			sb.append("<socialName>" + patientDetail.getPatientType().getPatientTypeName() + "</socialName>");
		} else {
			sb.append("<socialId>" + "" + "</socialId>");
		}

		if (null != patientDetail.getOccupation()) {
			sb.append("<ocupationId>" + patientDetail.getOccupation().getId() + "</ocupationId>");
			sb.append("<ocupationName>" + patientDetail.getOccupation().getOccupationName() + "</ocupationName>");
		} else {
			sb.append("<ocupationId>" + "" + "</ocupationId>");
		}

		if (null != patientDetail.getEducation()) {
			sb.append("<EduId>" + patientDetail.getEducation().getId() + "</EduId>");
			sb.append("<EduName>" + patientDetail.getEducation().getQualificationName() + "</EduName>");
		} else {
			sb.append("<EduId>" + "" + "</EduId>");
		}

		// Aadhaar Address
		if (aadharAddress != null) {
			if (null != aadharAddress.getHouseNo()) {
				sb.append("<AHouseNameID>" + aadharAddress.getHouseNo() + "</AHouseNameID>");
			} else {
				sb.append("<AHouseNameID>" + "" + "</AHouseNameID>");
			}

			if (null != aadharAddress.getStreetRoad()) {
				sb.append("<StreetName>" + aadharAddress.getStreetRoad() + "</StreetName>");
			} else {
				sb.append("<StreetName>" + "" + "</StreetName>");
			}

			if (null != aadharAddress.getVillage()) {
				sb.append("<avillage>" + aadharAddress.getVillage().getId() + "</avillage>");
			} else {
				sb.append("<avillage>" + "" + "</avillage>");

			}

			if (null != aadharAddress.getVillage()) {
				sb.append("<villageName>" + aadharAddress.getVillage().getVillageName() + "</villageName>");
			} else {
				sb.append("<villageName>" + "" + "</villageName>");
			}

			if (null != aadharAddress.getDistrict()) {

				sb.append("<district>" + aadharAddress.getDistrict().getId() + "</district>");
			} else {
				sb.append("<district>" + "" + "</district>");
			}

			if (null != aadharAddress.getDistrict()) {
				sb.append("<districtName>" + aadharAddress.getDistrict().getDistrictName() + "</districtName>");
			} else {
				sb.append("<districtName>" + "" + "</districtName>");
			}

			if (null != aadharAddress.getTaluk()) {
				sb.append("<taluk>" + aadharAddress.getTaluk().getId() + "</taluk>");
			} else {
				sb.append("<taluk>" + "" + "</taluk>");

			}

			if (null != aadharAddress.getTaluk()) {
				sb.append("<talukName>" + aadharAddress.getTaluk().getTalukName() + "</talukName>");
			} else {
				sb.append("<talukName>" + "" + "</talukName>");
			}

			if (null != aadharAddress.getPostOffice()) {
				sb.append("<postoffice>" + aadharAddress.getPostOffice().getId() + "</postoffice>");
			} else {
				sb.append("<postoffice>" + "" + "</postoffice>");
			}

			if (null != aadharAddress.getPostOffice()) {
				sb.append("<postofficeName>" + aadharAddress.getPostOffice().getPostCodeName() + "</postofficeName>");
			} else {
				sb.append("<postofficeName>" + "" + "</postofficeName>");

			}

			if (null != aadharAddress.getPinCode()) {
				sb.append("<pincode>" + aadharAddress.getPinCode() + "</pincode>");
			} else {
				sb.append("<pincode>" + "" + "</pincode>");
			}
		}

		// Permanent Address
		if (permanentAddress != null) {
			if (null != permanentAddress.getDistrict()) {
				sb.append("<pdistrict>" + permanentAddress.getDistrict().getId() + "</pdistrict>");
				sb.append("<pdistrictName>" + permanentAddress.getDistrict().getDistrictName() + "</pdistrictName>");
			} else {
				sb.append("<pdistrict>" + "" + "</pdistrict>");
				sb.append("<pdistrictName>" + "" + "</pdistrictName>");
			}
			if (null != permanentAddress.getTaluk()) {
				sb.append("<ptaluk>" + permanentAddress.getTaluk().getId() + "</ptaluk>");
				sb.append("<ptalukName>" + permanentAddress.getTaluk().getTalukName() + "</ptalukName>");
			} else {
				sb.append("<ptaluk>" + "" + "</ptaluk>");
				sb.append("<ptalukName>" + "" + "</ptalukName>");
			}
			if (null != permanentAddress.getLsgName()) {

				sb.append("<plsg>" + permanentAddress.getLsgName().getId() + "</plsg>");
				sb.append("<plsgname>" + permanentAddress.getLsgName().getLsgTypeName() + "</plsgname>");
			} else {
				sb.append("<plsg>" + "" + "</plsg>");
				sb.append("<plsgname>" + "" + "</plsgname>");
			}
			if (null != permanentAddress.getLsgHouseNo()) {
				sb.append("<plsgHpuseNo>" + permanentAddress.getLsgHouseNo() + "</plsgHpuseNo>");
			} else {
				sb.append("<plsgHpuseNo>" + "" + "</plsgHpuseNo>");
			}
			if (null != permanentAddress.getHouseNo()) {
				sb.append("<pHouseNo>" + permanentAddress.getHouseNo() + "</pHouseNo>");
			} else {
				sb.append("<pHouseNo>" + "" + "</pHouseNo>");
			}
			if (null != permanentAddress.getLocality()) {
				sb.append("<plocality>" + permanentAddress.getLocality().getId() + "</plocality>");
				sb.append("<plocalityName>" + permanentAddress.getLocality().getLocalityName() + "</plocalityName>");
			} else {
				sb.append("<plocality>" + "" + "</plocality>");
				sb.append("<plocalityName>" + "" + "</plocalityName>");
			}
			if (null != permanentAddress.getPostOffice()) {
				sb.append("<ppostoffice>" + permanentAddress.getPostOffice().getId() + "</ppostoffice>");
				sb.append("<ppostofficeName>" + permanentAddress.getPostOffice().getPostCodeName()
						+ "</ppostofficeName>");
				sb.append("<ppostcode>" + permanentAddress.getPostOffice().getPinCode() + "</ppostcode>");

			} else {
				sb.append("<ppostoffice>" + "" + "</ppostoffice>");
				sb.append("<ppostofficeName>" + "" + "</ppostofficeName>");
				sb.append("<ppostcode>" + "" + "</ppostcode>");
			}
			if (null != permanentAddress.getHealthHouseId()) {
				sb.append("<phealtHouseId>" + permanentAddress.getHealthHouseId() + "</phealtHouseId>");
			} else {
				sb.append("<phealtHouseId>" + "" + "</phealtHouseId>");
			}
		}

		// temporary address
		if (temporaryAddress != null) {
			if (null != temporaryAddress.getDistrict()) {
				sb.append("<tdistrict>" + temporaryAddress.getDistrict().getId() + "</tdistrict>");
				sb.append("<tdistrictName>" + temporaryAddress.getDistrict().getDistrictName() + "</tdistrictName>");
			} else {
				sb.append("<tdistrict>" + "" + "</tdistrict>");
				sb.append("<tdistrictName>" + "" + "</tdistrictName>");
			}
			if (null != temporaryAddress.getTaluk()) {
				sb.append("<ttaluk>" + temporaryAddress.getTaluk().getId() + "</ttaluk>");
				sb.append("<ttalukName>" + temporaryAddress.getTaluk().getTalukName() + "</ttalukName>");
			} else {
				sb.append("<ttaluk>" + "" + "</ttaluk>");
				sb.append("<ttalukName>" + "" + "</ttalukName>");
			}
			if (null != temporaryAddress.getLsgName()) {
				sb.append("<tlsg>" + temporaryAddress.getLsgName().getId() + "</tlsg>");
				sb.append("<tlsgname>" + temporaryAddress.getLsgName().getLsgTypeName() + "</tlsgname>");
			} else {
				sb.append("<tlsg>" + "" + "</tlsg>");
				sb.append("<tlsgname>" + "" + "</tlsgname>");
			}
			if (null != temporaryAddress.getLsgHouseNo()) {
				sb.append("<tlsgHpuseNo>" + temporaryAddress.getLsgName().getId() + "</tlsgHpuseNo>");
			} else {
				sb.append("<tlsgHpuseNo>" + "" + "</tlsgHpuseNo>");
			}
			if (null != temporaryAddress.getLocality()) {
				sb.append("<tlocality>" + temporaryAddress.getLocality().getId() + "</tlocality>");
				sb.append("<tlocalityName>" + temporaryAddress.getLocality().getLocalityName() + "</tlocalityName>");
			} else {
				sb.append("<tlocality>" + "" + "</tlocality>");
				sb.append("<tlocalityName>" + "" + "</tlocalityName>");
			}
			if (null != temporaryAddress.getPostOffice()) {
				sb.append("<tpostoffice>" + temporaryAddress.getPostOffice().getId() + "</tpostoffice>");
				sb.append("<tpostofficeName>" + temporaryAddress.getPostOffice().getPostCodeName()
						+ "</tpostofficeName>");
				sb.append("<tpostcode>" + temporaryAddress.getPostOffice().getPinCode() + "</tpostcode>");
			} else {
				sb.append("<tpostoffice>" + "" + "</tpostoffice>");
				sb.append("<tpostofficeName>" + "" + "</tpostofficeName>");
				sb.append("<tpostcode>" + "" + "</tpostcode>");
			}
			if (null != temporaryAddress.getHealthHouseId()) {
				sb.append("<thealtHouseId>" + temporaryAddress.getHealthHouseId() + "</thealtHouseId>");
			} else {
				sb.append("<thealtHouseId>" + "" + "</thealtHouseId>");
			}
			if (patientDetail.getBloodGroup() != null) {
				sb.append("<bloodGroup>" + patientDetail.getBloodGroup().getId() + "</bloodGroup>");
			} else {
				sb.append("<bloodGroup>" + "" + "</bloodGroup>");
			}

			if (patientDetail.getBloodGroupValue() != null) {
				sb.append("<bloodName>" + patientDetail.getBloodGroupValue() + "</bloodName>");
			}
		}

		// end
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items111>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items111>");

	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void populateUhidConversionPage(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateUhidConversionPage ");

		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();

		int hinId = 0;
		String uhid = "";
		if (request.getParameter("hinId") != null && !request.getParameter("hinId").equals("0")) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}

		Map<String, Object> map = registrationHandlerService.populateUhidConversionPage(hinId);

		StringBuffer sb = new StringBuffer();
		if (patientList != null) {
			for (Patient p : patientList) {
				uhid = p.getHinNo();
				sb.append("<item>");
				sb.append("<uhid>" + uhid + "</uhid>");
				sb.append("</item>");
			}
		}

		for (Visit v : visitList) {
			uhid = v.getHin().getHinNo();
			sb.append("<item>");
			if (null != v.getHin()) {
				sb.append("<uhid>" + uhid + "</uhid>");
			} else {
				sb.append("<uhid>" + " " + "</uhid>");
			}

			if (null != v.getVisitDate()) {
				sb.append("<date>" + HMSUtil.changeDateToddMMyyyy(v.getVisitDate()) + "</date>");
			} else {
				sb.append("<date>" + " " + "</date>");
			}

			if (null != v.getHospital()) {
				sb.append("<hosName>" + v.getHospital().getHospitalName() + "</hosName>");
			} else {
				sb.append("<hosName>" + " " + "</hosName>");
			}

			if (null != v.getDoctor()) {
				sb.append("<docName>" + v.getDoctor().getEmployeeName() + "</docName>");
			} else {
				sb.append("<docName>" + " " + "</docName>");
			}
			sb.append("</item>");
		}

		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	@SuppressWarnings("unchecked")
	public void populateSubCenterByHospital(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateSubCenterByHospital ");
		int districtId = 0;
		if (null != request.getParameter("districtId") && !request.getParameter("districtId").equals(" ")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}
		Map<String, Object> map = registrationHandlerService.populateSubCenterByHospital(districtId);
		List<MasHospital> subCenterList = (List<MasHospital>) map.get("subCenterList");

		StringBuffer sb = new StringBuffer();
		for (MasHospital v : subCenterList) {

			sb.append("<item>");
			if (null != v.getId()) {
				sb.append("<hosid>" + v.getId() + "</hosid>");
			} else {
				sb.append("<hosid>" + " " + "</hosid>");
			}

			if (null != v.getHospitalName()) {
				sb.append("<hospitalName>" + v.getHospitalName() + "</hospitalName>");
			} else {
				sb.append("<hospitalName>" + " " + "</hospitalName>");
			}

			sb.append("</item>");
		}

		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	public ModelAndView calculateAge(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside calculateAge ");
		Map<String, Object> map = new HashMap<String, Object>();
		Date dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("dateOfBirth"));
		String age = HMSUtil.calculateAge(dateOfBirth);
		LOGGER.debug("age : " + age);
		String jsp = "responseForAge";
		map.put("age", age);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNo(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside calculateAge ");
		Map<String, Object> map = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter("serviceNo") != null) {
			serviceNo = request.getParameter("serviceNo");
		}
		int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
		int relationId = Integer.parseInt(request.getParameter("relationId"));
		int serviceStatusId = Integer.parseInt(request.getParameter("serviceStatus"));
		if (serviceTypeId == 7) {
			String serviceNoTemp = "no";
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			String currentTime = (String) utilMap.get("currentTime");

			serviceNoTemp = currentDate.substring(0, currentDate.indexOf("/"))
					+ currentDate.substring(currentDate.indexOf("/") + 1, currentDate.lastIndexOf("/"))
					+ currentDate.substring(currentDate.lastIndexOf("/") + 3, currentDate.length())
					+ currentTime.substring(0, currentTime.indexOf(":"))
					+ currentTime.substring(currentTime.indexOf(":") + 1, currentTime.lastIndexOf(":"))
					+ currentTime.substring(currentTime.lastIndexOf(":") + 1, currentTime.length());
			serviceNo = serviceNoTemp;
			LOGGER.debug("serviceNo : " + serviceNo);
		}
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("serviceTypeId", serviceTypeId);
		parameterMap.put("relationId", relationId);
		parameterMap.put("serviceStatusId", serviceStatusId);

		Map<String, Object> serviceAndRelationMap = registrationHandlerService.getServiceTypeAndRelation(parameterMap);
		String relationCode = (String) serviceAndRelationMap.get("relationCode");
		String serviceTypeCode = (String) serviceAndRelationMap.get("serviceTypeCode");
		String serviceStatusCode = (String) serviceAndRelationMap.get("serviceStatusCode");
		String maxSequenceNo = "";
		maxSequenceNo = registrationHandlerService.getHinId(serviceNo, serviceTypeId);
		Integer i;
		if (!maxSequenceNo.equals("")) {
			i = Integer.parseInt(maxSequenceNo) + 1;
		} else {
			i = 01;
		}
		String seqNo = "";
		if (i <= 9) {
			seqNo = "0" + i.toString();
		} else {
			seqNo = i.toString();
		}
		if (!serviceNo.equals("0")) {
			hinNo = serviceTypeCode.concat(serviceStatusCode).concat(serviceNo).concat(relationCode)
					.concat(seqNo.toString());
		} else {
			hinNo = serviceTypeCode.concat(seqNo.toString());
		}

		String jsp = AJAX_MESSAGE_JSP;

		String message = hinNo;
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getMothersName(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getMothersName ");
		String motherHinNo = "";
		if (request.getParameter("motherHinNo") != null) {
			motherHinNo = request.getParameter("motherHinNo");
		}
		Map<String, Object> map = registrationHandlerService.getMothersName(motherHinNo);
		String motherName = (String) map.get("patientName");

		if (motherName.equals("")) {
			motherName = "No Records Matched !";
		}
		String jsp = AJAX_MESSAGE_JSP;
		String message = motherName;
		map.put("message", message);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getTokenNoForDepartment(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getTokenNoForDepartment ");
		Map<String, Object> map = new HashMap<String, Object>();
		int tokenNo = 0;
		if (!request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
			tokenNo = 1;
		} else if (request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
			tokenNo = 0;
		}
		String jsp = "responseForTokenNo";
		map.put("tokenNo", tokenNo);

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView checkPatientRegistration(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside checkPatientRegistration ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String serviceNo = request.getParameter("serviceNo");
		if (serviceNo != null) {
			parameterMap.put("serviceNo", serviceNo);
		}
		String serviceTypeId = request.getParameter("serviceTypeId");
		if (serviceTypeId != null) {
			parameterMap.put("serviceTypeId", Integer.parseInt(serviceTypeId));
		}
		String relationId = request.getParameter("relationId");
		if (relationId != null) {
			parameterMap.put("relationId", Integer.parseInt(relationId));
		}
		String serviceStatusId = request.getParameter("serviceStatus");
		if (serviceStatusId != null) {
			parameterMap.put("serviceStatusId", Integer.parseInt(serviceStatusId));
		}

		String patientName = request.getParameter("patientName");
		if (patientName != null) {
			parameterMap.put("patientName", patientName);
		}

		Map<String, Object> detailMap = new HashMap<String, Object>();
		detailMap.get("patientList");
		detailMap = registrationHandlerService.getPatientListForName(parameterMap);
		List<Patient> patientList = (List<Patient>) detailMap.get("patientList");
		List<Patient> patientListForInfo = (List<Patient>) detailMap.get("patientListForInfo");
		String jsp = "responsePatient";
		map.put("patientList", patientList);
		map.put("patientListForInfo", patientListForInfo);
		map.put("serviceTypeId", serviceTypeId);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHinNoForUpdateAdt(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getHinNoForUpdateAdt ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		String flag = request.getParameter("flag");
		if (flag != null && !(flag.equals(""))) {
			map.put("flag", flag);
		}

		List<Object> hinNoList = registrationHandlerService.getHinNoList(serviceNo);
		map.put("hinNoList", hinNoList);

		String jsp = "populateHinNoForUpdate";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientName(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getPatientName ");
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}

		Map<String, Object> map = registrationHandlerService.getMothersName(hinNo);
		String patientName = (String) map.get("patientName");

		String pastDue = (String) map.get("pastDue");
		int hinId = (Integer) map.get("hinId");

		String jsp = "populatePatientNameForUpdate";
		map.put("name", patientName);
		map.put("pastDue", pastDue);
		map.put("hinId", hinId);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getVisitNo(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getVisitNo ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (!hinNo.equals("")) {
			details.put("hinNo", hinNo);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		List<Visit> visitNoList = registrationHandlerService.getVisitNo(details);

		String jsp = "populateVisitNoForUpdate";
		map.put("visitNoList", visitNoList);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getServicePersonName(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getServicePersonName ");
		String serviceNo = "";
		int serviceTypeId = 0;
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (!request.getParameter(SERVICE_TYPE_ID).equals("0")) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		}
		Map<String, Object> map = registrationHandlerService.getServicePersonName(serviceNo, serviceTypeId);
		String jsp = "responseForServPersonName";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showRegistrationCardReportJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showRegistrationCardReportJsp ");
		HttpSession session = request.getSession();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = registrationHandlerService.showRegistrationCardReportJsp(hospitalId);

		String jsp = REGISTRATION_CARD_REPORT_JSP;
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showSickReportJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showSickReportJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", SICK_REPORT_JSP);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSickReport(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showSickReport ");
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Date date = null;
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		}
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("date", date);
		String hinName = properties.getProperty("com.jkt.hms.registration_no");
		parameters.put("hin_name", hinName);
		parameters.put("HOSPITAL_ID", hospitalId);
		HMSUtil.generateReport("sick_report", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView showOPDRegisterReportJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showOPDRegisterReportJsp ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}
		mapDetails.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.populateOPDRegister(hospitalId);

		map.put("contentJsp", OPD_REGISTER_REPORT_JSP);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOPDRegisterReport(final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {

		LOGGER.debug("Inside showOPDRegisterReport ");
		String fromDate = null;
		String toDate = null;
		String fromTime = "";
		String toTime = "";
		long fromAge = -1;
		long toAge = -1;
		String fromAgeType = null;
		String toAgeType = null;
		int sexId = 0;
		String qry = "";
		int empId = 0;
		int hospitalId = 0;
		int deptId = 0;
		int serviceCentreId = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = (request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = (request.getParameter(TO_DATE));
		}
		// added by arbind on 02-02-2017
		if (request.getParameter("fromTime") != null) {
			fromTime = request.getParameter("fromTime");
		}
		if (request.getParameter("toTime") != null) {
			toTime = request.getParameter("toTime");
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			deptId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter("serviceCentreId") != null && !request.getParameter("serviceCentreId").equals("")) {
			serviceCentreId = Integer.parseInt(request.getParameter("serviceCentreId"));
		}
		String fromAgeP = "", toAgeP = "";
		if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Long.parseLong(request.getParameter("fromAge"));
			fromAgeP = request.getParameter("fromAge");
			if (request.getParameter("fromAgeType") != null) {
				fromAgeType = request.getParameter("fromAgeType");
				if (fromAgeType.equalsIgnoreCase("years")) {
					fromAge = fromAge * 365 + (fromAge / 4);
				} else if (fromAgeType.equalsIgnoreCase("months")) {
					fromAge = fromAge * 30;
				}
				parameters.put("fromAge", fromAge);
			}
		}

		if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Long.parseLong(request.getParameter("toAge"));
			toAgeP = request.getParameter("toAge");
			if (request.getParameter("toAgeType") != null) {
				toAgeType = request.getParameter("toAgeType");
				if (toAgeType.equalsIgnoreCase("years")) {
					toAge = toAge * 365 + 364 + (toAge / 4);
				} else if (toAgeType.equalsIgnoreCase("months")) {
					toAge = toAge * 30 + 29;
				}
				parameters.put("toAge", toAge);
			}
		}
		if (!request.getParameter(SEX_ID).equals("")) {
			sexId = Integer.parseInt(request.getParameter(SEX_ID));
			parameters.put("sexId", sexId);
		}
		// added by arbind on 02-02-2017 end
		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}
		String cashReceived = "n";
		String cashReceivedStr = "";
		if (null != request.getParameter("cashreceived") && request.getParameter("cashreceived").equals("y")) {
			cashReceived = request.getParameter("cashreceived");
			cashReceivedStr = "Cash Received : Yes";

		}

		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTimeDBFormat();
		String currentDate = (String) utilMap.get("currentDate");

		String fDate = null;
		if (fromDate != null) {
			fDate = fromDate.substring(6, 10).concat("-").concat(fromDate.substring(3, 5)).concat("-")
					.concat(fromDate.substring(0, 2));
		}
		String tDate = null;
		if (toDate != null) {
			tDate = toDate.substring(6, 10).concat("-").concat(toDate.substring(3, 5)).concat("-")
					.concat(toDate.substring(0, 2));
		}
		String strValue = "";
		//Added by arbind on 16-12-2017 department and service centre
		if (deptId > 0) {
			strValue += " and mas_department.emp_dept_id=" + deptId;
		}
		if (serviceCentreId > 0) {
			strValue += " and visit.department_id=" + serviceCentreId;
		}
		if (fromAge >= 0 && toAge >= 0) {
			strValue += " and (visit.visit_date::date-patient.date_of_birth::date) between " + fromAge + " and "
					+ toAge;
		}
		if (sexId != 0) {
			strValue += " and patient.sex_id = " + sexId;
		}
		if (visitType.equals("new")) {
			visitType = "( New )";
			// added by arbind on 01-02-2017
			if (cashReceived.equalsIgnoreCase("y")) {
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and visit.cash_received_status= '"+ cashReceived +"' and (visit.visit_date + cast(visit.visit_time as time)) between (cast('" + fDate
					+ "' as date) + cast('" + fromTime + "' as time)) and (cast('" + tDate + "' as date) + cast('"
					+ toTime + "' as time))" + " and visit.visit_no = 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
			}else {
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and (visit.visit_date + cast(visit.visit_time as time)) between (cast('" + fDate
					+ "' as date) + cast('" + fromTime + "' as time)) and (cast('" + tDate + "' as date) + cast('"
					+ toTime + "' as time))" + " and visit.visit_no = 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
			}
		} else if (visitType.equals("repeat")) {
			visitType = "( Repeat )";
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and (visit.visit_date + cast(visit.visit_time as time)) between (cast('" + fDate
					+ "' as date) + cast('" + fromTime + "' as time)) and (cast('" + tDate + "' as date) + cast('"
					+ toTime + "' as time))" + " and visit.visit_no> 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
		} else if (visitType.equals("parked")) {
			visitType = "( Parked )";
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and visit.visit_date='" + currentDate + "' and visit.visit_time between '" + fromTime
					+ "' and '" + toTime
					+ "' and visit.visit_status='p' and visit.visit_no > 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
		} else if (visitType.equals("absconded")) {
			visitType = "( Absconded )";
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and (visit.visit_date + cast(visit.visit_time as time)) between (cast('" + fDate
					+ "' as date) + cast('" + fromTime + "' as time)) and (cast('" + tDate + "' as date) + cast('"
					+ toTime + "' as time))"
					+ " and visit.visit_status='a' and visit.visit_no > 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
		} else if (visitType.equals("incomplete")) {
			visitType = "( Incomplete Visit )";
			qry = " where visit.hospital_id=" + hospitalId + " and mas_hospital.hospital_Id =" + hospitalId
					+ " and (visit.visit_date + cast(visit.visit_time as time)) between (cast('" + fDate
					+ "' as date) + cast('" + fromTime + "' as time)) and (cast('" + tDate + "' as date) + cast('"
					+ toTime + "' as time))"
					+ " and visit.visit_status='w' and visit.visit_no > 1 and mas_department.department_type_id = 1 "
					+ strValue + " order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
		} else if (visitType.equals("newRepeat")) {
			visitType = "( New/Repeat )";
			if (cashReceived.equalsIgnoreCase("y")) {
				qry = " where visit.hospital_id="
						+ hospitalId
						+ " and mas_hospital.hospital_Id ="
						+ hospitalId
						+ " and visit.cash_received_status='y' and (visit.visit_date + cast(visit.visit_time as time)) between (cast('"
						+ fDate
						+ "' as date) + cast('"
						+ fromTime
						+ "' as time)) and (cast('"
						+ tDate
						+ "' as date) + cast('"
						+ toTime
						+ "' as time))"
						+ strValue
						+ "  and (visit.visit_no> 1 or visit.visit_no=1) and mas_department.department_type_id = 1  order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
			} else {
				qry = " where visit.hospital_id="
						+ hospitalId
						+ " and mas_hospital.hospital_Id ="
						+ hospitalId
						+ " and (visit.visit_date + cast(visit.visit_time as time)) between (cast('"
						+ fDate
						+ "' as date) + cast('"
						+ fromTime
						+ "' as time)) and (cast('"
						+ tDate
						+ "' as date) + cast('"
						+ toTime
						+ "' as time))"
						+ strValue
						+ "  and (visit.visit_no> 1 or visit.visit_no=1) and mas_department.department_type_id = 1  order by visit.visit_id,visit.visit_date,visit.visit_time,total_hospital_visit asc ";
			}
			// added by arbind on 01-02-2017 end
		}
		// added by govind 18-11-2016
		if (request.getParameter("empId") != null && request.getParameter("empId").equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
		}
		String userName = "";
		if (empId > 0) {
			userName = registrationHandlerService.getuserName(empId);

		} else {
			userName = "All";
		}

		// added by govind 18-11-2016 end
		String hospitalName = registrationHandlerService.getHospitalName(hospitalId);
		parameters.put("hospitalName", hospitalName);

		LOGGER.debug("visitType " + visitType);
		LOGGER.debug("Query " + qry);

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", HMSUtil.convertStringTypeDateToDateType(fromDate));
		parameters.put("toDate", HMSUtil.convertStringTypeDateToDateType(toDate));
		parameters.put("fromTime", fromTime);
		parameters.put("toTime", toTime);
		parameters.put("fromAgeType", fromAgeType);
		parameters.put("toAgeType", toAgeType);
		parameters.put("fromAgeP", fromAgeP);
		parameters.put("toAgeP", toAgeP);
		parameters.put("empId", empId);
		parameters.put("qry", qry);
		parameters.put("visitType", visitType); // added by amit das on
												// 24-06-2016
		parameters.put("HOSPITAL_ID", hospitalId);
		// added by govind 18-11-2016
		parameters.put("cashReceivedStr", cashReceivedStr);
		parameters.put("userName", userName);
		parameters.put("serviceCentreId", serviceCentreId); //Added by Arbind on 16-12-2017

		
		String flag="1";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		if (flag.equals("1"))
		{
			HMSUtil.generateReport("OPDRegister", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		else if(flag.equals("2")) {
					HMSUtil.generateHTMLReport("OPDRegister", parameters, (Connection) detailsMap.get("conn"), response,
							getServletContext());
		}
		
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	// -------------At Bangalore-------------

	public ModelAndView getEchsNo(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getEchsNo ");
		Map<String, Object> map = new HashMap<String, Object>();
		return new ModelAndView(ECHS_NO_JSP, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void populatePatientDetails(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientDetails ");
		Box box = HMSUtil.getBox(request);

		int serviceTypeId = box.getInt("serviceTypeId");
		String serviceNo = box.get("serviceNo");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("serviceTypeId", serviceTypeId);
		dataMap.put("serviceNo", serviceNo);
		Map<String, Object> detailsMap = registrationHandlerService.populatePatientDetails(dataMap);
		List<Patient> patientList = (List<Patient>) detailsMap.get("patientList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (Patient patient : patientList) {
			sb.append("<religionId>" + patient.getReligion().getId() + "</religionId>");
			if (patient.getPhoneNumber() != null && !patient.getPhoneNumber().equals("")) {
				sb.append("<phoneNo>" + patient.getPhoneNumber() + "</phoneNo>");
			} else {
				sb.append("<phoneNo>" + "0" + "</phoneNo>");
			}
			if (patient.getMobileNumber() != null && !patient.getMobileNumber().equals("")) {
				sb.append("<mobileNo>" + patient.getMobileNumber() + "</mobileNo>");
			} else {
				sb.append("<mobileNo>" + "0" + "</mobileNo>");
			}

		}
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	@SuppressWarnings("unchecked")
	public void populatePatientDetailsToRegistration(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {

		LOGGER.debug("Inside populatePatientDetailsToRegistration ");
		Box box = HMSUtil.getBox(request);

		String uhid = box.getString("uhid");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("uhid", uhid);
		Map<String, Object> detailsMap = registrationHandlerService.populatePatientDetailsToRegistration(dataMap);
		List<Patient> patientList = new ArrayList<Patient>();
		patientList = (List<Patient>) detailsMap.get("searchDataList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (Patient patient : patientList) {

			if (patient.getAadhaarNo() != null && !patient.getAadhaarNo().equals("")) {
				LOGGER.error("Inside response of Patient List " + patient.getAadhaarNo());
				sb.append("<pAadhaarNumber>" + patient.getAadhaarNo() + "</pAadhaarNumber>");
			} else {
				sb.append("<pAadhaarNumber>" + "0" + "</pAadhaarNumber>");
			}
			sb.append("</item>");
			break;

		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void getLastVisitDetails(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside getLastVisitDetails ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		String deptId = "";
		if (request.getParameter("deptId") != null && !request.getParameter("deptId").equals("")) {
			deptId = request.getParameter("deptId");
		}

		String hinNo = "";
		if (request.getParameter("hinNo") != null && !request.getParameter("hinNo").equals("")) {
			hinNo = request.getParameter("hinNo");
		}
		detailsMap.put("deptId", deptId);
		detailsMap.put("hinNo", hinNo);
		Map<String, Object> getDataMap = registrationHandlerService.getLastVisitDetails(detailsMap);

		if (getDataMap.get("visitList") != null) {
			visitList = (List<Visit>) getDataMap.get("visitList");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		for (Visit visit : visitList) {
			if (visit.getVisitDate() != null) {
				sb.append("<lastVisitDateId>" + visit.getVisitDate() + "</lastVisitDateId>");
			} else {
				sb.append("<lastVisitDateId>" + "0" + "</lastVisitDateId>");
			}
			if (visit.getDoctor().getEmployeeName() != null && !visit.getDoctor().getEmployeeName().equals("")) {
				sb.append("<lastVisitDoctorsIncharge>" + visit.getDoctor().getEmployeeName()
						+ "</lastVisitDoctorsIncharge>");
			} else {
				sb.append("<lastVisitDoctorsIncharge>" + "0" + "</lastVisitDoctorsIncharge>");
			}
			if (visit.getUnit() != null && visit.getUnit().getId() != 0) {
				sb.append("<lastVisitUnitId>" + visit.getUnit().getId() + "</lastVisitUnitId>");
			} else {
				sb.append("<lastVisitUnitId>" + "0" + "</lastVisitUnitId>");
			}
			if (visit.getDoctor().getEmployeeName() != null && !visit.getDoctor().getEmployeeName().equals("")) {
				sb.append("<lastVisitDutyDoctorId>" + visit.getDoctor().getEmployeeName() + "</lastVisitDutyDoctorId>");
			} else {
				sb.append("<lastVisitDutyDoctorId>" + "0" + "</lastVisitDutyDoctorId>");
			}
			break;
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void populatePatientDetailsToVisit(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientDetailsToVisit ");
		Box box = HMSUtil.getBox(request);
		String uhid = box.getString("uhid");
		int hospitalId = 0;
		HttpSession session = request.getSession();
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Visit> visitList = new ArrayList<Visit>();
		List<MasChargeCode> cListy = new ArrayList<MasChargeCode>();
		dataMap.put("uhid", uhid);
		Map<String, Object> detailsMap = registrationHandlerService.populatePatientDetailsToVisit(dataMap);
		String billNo = opBillingHandlerService.generateBillNo("OS", "display", hospitalId);
		LOGGER.debug("billNo : " + billNo);
		List<Patient> patientList = (List<Patient>) detailsMap.get("searchDataList");
		if (detailsMap.get("visitList") != null) {
			visitList = (List<Visit>) detailsMap.get("visitList");
		}
		if (detailsMap.get("chargeList12") != null) {
			cListy = (List<MasChargeCode>) detailsMap.get("chargeList12");
		}

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		if (billNo != null && !billNo.equals("0")) {
			sb.append("<billNoId>" + billNo + "</billNoId>");
		} else {
			sb.append("<billNoId>" + "0" + "</billNoId>");
		}

		for (Patient patient : patientList) {
			if (patient.getHinNo() != null && !patient.getHinNo().equals("")) {
				sb.append("<pUhidId>" + patient.getHinNo() + "</pUhidId>");
			} else {
				sb.append("<pUhidId>" + "0" + "</pUhidId>");
			}

			if (patient.getFullName() != null && !patient.getFullName().equals("")) {
				sb.append("<pnameId>" + patient.getFullName() + "</pnameId>");
			} else {
				sb.append("<pnameId>" + "0" + "</pnameId>");
			}

			if (patient.getSex().getAdministrativeSexName() != null
					&& !patient.getSex().getAdministrativeSexName().equals("")) {
				sb.append("<genderId>" + patient.getSex().getAdministrativeSexName() + "</genderId>");
			} else {
				sb.append("<genderId>" + "0" + "</genderId>");
			}

			if (patient.getAge() != null && !patient.getAge().equals("")) {
				sb.append("<ageId>" + patient.getAge() + "</ageId>");
			} else {
				sb.append("<ageId>" + "0" + "</ageId>");
			}

			if (patient.getRelation().getRelationName() != null && !patient.getRelation().getRelationName().equals("")) {

				sb.append("<relationId>" + patient.getRelation().getRelationName() + "</relationId>");
			} else {
				sb.append("<relationId>" + "0" + "</relationId>");
			}

			if (patient.getFatherMotherName() != null && !patient.getFatherMotherName().equals("")) {
				sb.append("<relationNameId>" + patient.getFatherMotherName() + "</relationNameId>");
			} else {
				sb.append("<relationNameId>" + "0" + "</relationNameId>");
			}

			if (patient.getOccupation().getOccupationName() != null
					&& !patient.getOccupation().getOccupationName().equals("")) {
				sb.append("<occupationId>" + patient.getOccupation().getOccupationName() + "</occupationId>");
			} else {
				sb.append("<occupationId>" + "0" + "</occupationId>");
			}

			if (patient.getMobileNumber() != null && !patient.getMobileNumber().equals("")) {
				sb.append("<mobileNoId>" + patient.getMobileNumber() + "</mobileNoId>");
			} else {
				sb.append("<mobileNoId>" + "0" + "</mobileNoId>");
			}

			if (patient.getPatientType().getPatientTypeName() != null
					&& !patient.getPatientType().getPatientTypeName().equals("")) {
				sb.append("<categoryId>" + patient.getPatientType().getPatientTypeName() + "</categoryId>");
			} else {
				sb.append("<categoryId>" + "0" + "</categoryId>");
			}

			if (patient.getPastDue() != null && !patient.getPastDue().equals("")) {

				sb.append("<availableCreditBalanceId>" + patient.getPastDue() + "</availableCreditBalanceId>");
			} else {
				sb.append("<availableCreditBalanceId>" + "0" + "</availableCreditBalanceId>");
			}

			if (patient.getId() != null && patient.getId() != 0) {
				sb.append("<hinId>" + patient.getId() + "</hinId>");
			} else {
				sb.append("<hinId>" + "0" + "</hinId>");
			}
			break;
		}

		for (Visit visit : visitList) {
			if (visit.getVisitNo() != null && visit.getVisitNo() != 0) {
				long visitNo = visit.getVisitNo();
				visitNo = visitNo + 1;
				sb.append("<visitNoId>" + visitNo + "</visitNoId>");
			} else {
				sb.append("<visitNoId>" + "0" + "</visitNoId>");
			}
			break;
		}
		for (MasChargeCode masChargeCode : cListy) {
			if (masChargeCode.getId() != null && masChargeCode.getId() != 0) {
				sb.append("<registrationTypeId>" + masChargeCode.getId() + "</registrationTypeId>");
			} else {
				sb.append("<registrationTypeId>" + "0" + "</registrationTypeId>");
			}

			if (masChargeCode.getCharge() != null && masChargeCode.getCharge() != 0) {
				sb.append("<amountId>" + masChargeCode.getCharge() + "</amountId>");
			} else {
				sb.append("<amountId>" + "0" + "</amountId>");
			}
			break;
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getAdmissionNoList(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside  getAdmissionNoList ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> inpatientList = new ArrayList<Object>();
		Map<String, Object> map = registrationHandlerService.getAdmissionNoList(detailsMap);
		if (map.get("inpatientList") != null) {
			inpatientList = (List<Object>) map.get("inpatientList");
		}
		map.put("inpatientList", inpatientList);
		String jsp = "responseForUpdateAdmin";
		return new ModelAndView(jsp, "map", map);

	}

	public void generateServiveNo(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside generateServiveNo ");
		String serviceNo = "no";
		Map<String, Object> utilMap = HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String currentTime = (String) utilMap.get("currentTime");

		serviceNo = currentDate.substring(0, currentDate.indexOf("/"))
				+ currentDate.substring(currentDate.indexOf("/") + 1, currentDate.lastIndexOf("/"))
				+ currentDate.substring(currentDate.lastIndexOf("/") + 3, currentDate.length())
				+ currentTime.substring(0, currentTime.indexOf(":"))
				+ currentTime.substring(currentTime.indexOf(":") + 1, currentTime.lastIndexOf(":"))
				+ currentTime.substring(currentTime.lastIndexOf(":") + 1, currentTime.length());
		LOGGER.debug("serviceNo : " + serviceNo);

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<serviceNo>" + serviceNo + "</serviceNo>");
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to outputstream" + ioException.getStackTrace().toString());
		}
	}

	public ModelAndView getAmount(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getAmount ");
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		int patientTypeId = 0;
		int companyId = 0;
		int chargeType = 0;
		String regType = "";
		BigDecimal amount = new BigDecimal("0");
		int subChargeId = 0;
		int mainChargeId = 0;
		if (request.getParameter(PATIENT_TYPE_ID) != null && !(request.getParameter(PATIENT_TYPE_ID)).equals("")) {
			patientTypeId = Integer.parseInt(request.getParameter(PATIENT_TYPE_ID));
		}
		if (request.getParameter(COMPANY) != null && !(request.getParameter(COMPANY).equals("0"))) {
			companyId = Integer.parseInt(request.getParameter(COMPANY));
		}
		if (request.getParameter("registrationType") != null && !(request.getParameter("registrationType").equals("0"))
				&& !(request.getParameter("registrationType").equals(""))) {
			chargeType = Integer.parseInt(request.getParameter("registrationType"));
		}
		if (request.getParameter("mainChargeId") != null && !(request.getParameter("mainChargeId").equals(""))) {
			mainChargeId = Integer.parseInt(request.getParameter("mainChargeId"));
		}
		if (request.getParameter("subChargeId") != null && !(request.getParameter("subChargeId").equals(""))) {
			subChargeId = Integer.parseInt(request.getParameter("subChargeId"));
		}
		if (request.getParameter("regisType") != null && !(request.getParameter("regisType").equals("0"))) {
			regType = request.getParameter("regisType");
		}
		parameterMap.put("patientTypeId", patientTypeId);
		parameterMap.put("companyId", companyId);
		parameterMap.put("chargeId", chargeType);
		parameterMap.put("mainChargeId", mainChargeId);
		parameterMap.put("subChargeId", subChargeId);

		parameterMap.put("patientCategory", "OP");
		parameterMap.put("billTypeId", 2);
		parameterMap.put("regType", regType);

		Map<String, Object> map = opBillingHandlerService.getChargeAmountAfterDiscount(parameterMap);

		if (map.get("chargeAmountAfterDis") != null) {
			amount = (BigDecimal) map.get("chargeAmountAfterDis");
		}
		map.put("amount", amount);
		map.put("patientTypeId", patientTypeId);

		String jsp = "responseForAmount";
		return new ModelAndView(jsp, "map", map);

	}

	public OpBillingHandlerService getOpBillingHandlerService() {
		return opBillingHandlerService;
	}

	public void setOpBillingHandlerService(final OpBillingHandlerService opBillingHandlerService) {
		this.opBillingHandlerService = opBillingHandlerService;
	}

	// ============================ Added By Vivek on 01-06-2009
	// ======================================

	@SuppressWarnings("unchecked")
	public void populatePostOff(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePostOff ");
		int blockId = 0;
		if (request.getParameter("blockId") != null) {
			blockId = Integer.parseInt(request.getParameter("blockId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("blockId", blockId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePostOff(dataMap);
		List<MasPostCode> masPostCodeList = (List<MasPostCode>) detailsMap.get("masPostCodeList");
		// ------------Response------------------
		StringBuffer sb = new StringBuffer();
		for (MasPostCode masPostCode : masPostCodeList) {
			sb.append("<item>");
			sb.append("<PostCodeName>" + masPostCode.getPostCodeName() + "</PostCodeName>");
			sb.append("<PostCodeId>" + masPostCode.getId() + "</PostCodeId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void populateChargeAmout(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateChargeAmout ");
		int chargeId = 0;
		if (request.getParameter("chargeId") != null) {
			chargeId = Integer.parseInt(request.getParameter("chargeId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("chargeId", chargeId);
		Map<String, Object> detailsMap = registrationHandlerService.populateChargeableAmount(dataMap);
		List<MasChargeCode> masChargeCodeList = (List<MasChargeCode>) detailsMap.get("masChargeCode");
		// ------------Response------------------
		StringBuffer sb = new StringBuffer();

		if (null != masChargeCodeList && masChargeCodeList.size() > 0) {
			for (MasChargeCode maschargecode : masChargeCodeList) {
				sb.append("<item>");
				sb.append("<Charge>" + maschargecode.getCharge() + "</Charge>");
				sb.append("</item>");
			}
		} else {
			sb.append("<item>");
			sb.append("<Charge>" + "0.0" + "</Charge>");
			sb.append("</item>");
		}

		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public void populateVillage(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateVillage ");
		int postOffId = 0;

		if (request.getParameter("postOffId") != null && !request.getParameter("postOffId").equals("0")
				&& !request.getParameter("postOffId").equals("") && !request.getParameter("postOffId").equals(" ")) {
			postOffId = Integer.parseInt(request.getParameter("postOffId"));

		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("postOffId", postOffId);
		Map<String, Object> detailsMap = registrationHandlerService.populateVillage(dataMap);

		int pincodeNumber = (Integer) detailsMap.get("pincodeNumber");

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<pincode>" + pincodeNumber + "</pincode>");
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * populate postOffice on click of Village
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populatePostOffice(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePostOffice ");
		int villageId = 0;
		if (request.getParameter("villageId") != null && !request.getParameter("villageId").equals("")) {
			villageId = Integer.parseInt(request.getParameter("villageId"));

		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("villageId", villageId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePostOfficeByVillage(dataMap);
		List<MasPostCode> postofficeList = (List<MasPostCode>) detailsMap.get("postofficeList");

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasPostCode postcode : postofficeList) {
			sb.append("<item>");
			sb.append("<postOffice>" + postcode.getPostCodeName() + "</postOffice>");

			sb.append("<postId>" + postcode.getId() + "</postId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

	}

	/**
	 * populate postOffice on click of Village
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateVillageTown(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateVillageTown ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals(" ")
				&& !request.getParameter("districtId").equals("") && !request.getParameter("districtId").equals("0")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));

		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populateVillageTown(dataMap);
		List<MasVillage> villageList = (List<MasVillage>) detailsMap.get("villageList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasVillage masVillage : villageList) {
			sb.append("<item>");
			sb.append("<VillageName>" + masVillage.getVillageName() + "</VillageName>");
			sb.append("<VillageId>" + masVillage.getId() + "</VillageId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * populate Taluk based on district drop down selected value
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populsubDistrictByDistrictId(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populsubDistrictByDistrictId ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("0")
				&& !request.getParameter("districtId").equals("") && !request.getParameter("districtId").equals(" ")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populsubDistrictByDistrictId(dataMap);
		List<Object[]> talukList = (List<Object[]>) detailsMap.get("talukList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (Object[] taluk : talukList) {
			sb.append("<item>");
			sb.append("<TalukName>" + taluk[1] + "</TalukName>");
			sb.append("<TalukId>" + taluk[0] + "</TalukId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void lsgByDistrict(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

		LOGGER.debug("Inside lsgByDistrict ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("")
				&& !request.getParameter("districtId").equals(" ")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}

		Map<String, Object> detailsMap = registrationHandlerService.lsgByDistrict(districtId);
		List<Object[]> masLsgList = (List<Object[]>) detailsMap.get("MasLsgList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (Object[] lsg : masLsgList) {

			sb.append("<item>");
			sb.append("<lsgName>" + lsg[1] + "</lsgName>");
			sb.append("<lsgId>" + lsg[0] + "</lsgId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void populatePincodeByDistrict(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePincodeByDistrict ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals(" ")
				&& !request.getParameter("districtId").equals("") && !request.getParameter("districtId").equals("0")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));

		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePincodeByDistrict(dataMap);
		List<Object[]> postcodeList = (List<Object[]>) detailsMap.get("masPostCodeList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (Object[] postcode : postcodeList) {
			sb.append("<item>");
			sb.append("<PostName>" + postcode[1] + "</PostName>");
			sb.append("<PostId>" + postcode[0] + "</PostId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void updatePincodeByDistrict(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside updatePincodeByDistrict ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			LOGGER.error("calling this " + districtId);
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePincodeByDistrict(dataMap);
		List<MasPostCode> postcodeList = (List<MasPostCode>) detailsMap.get("masPostCodeList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (MasPostCode postcode : postcodeList) {
			sb.append("<item>");
			sb.append("<PostName>" + postcode.getPostCodeName() + "</PostName>");
			sb.append("<PostId>" + postcode.getId() + "</PostId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * populate Taluk based on district drop down selected value
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populateDistByState(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateDistByState ");
		int stateId = 0;
		if (request.getParameter("stateId") != null && !request.getParameter("stateId").equals("")) {
			stateId = Integer.parseInt(request.getParameter("stateId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("stateId", stateId);
		Map<String, Object> detailsMap = registrationHandlerService.populateDistByState(dataMap);
		List<MasDistrict> districtList = (List<MasDistrict>) detailsMap.get("districtList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasDistrict district : districtList) {
			LOGGER.debug(district.getDistrictName());
			sb.append("<item>");
			sb.append("<DistrictName>" + district.getDistrictName() + "</DistrictName>");
			sb.append("<DistrictId>" + district.getId() + "</DistrictId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * papulate village on change of district
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	@SuppressWarnings("unchecked")
	public void populateVillageFromDist(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateVillageFromDist ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populateVillageFromDist(dataMap);
		List<MasVillage> masVillageList = (List<MasVillage>) detailsMap.get("masVillageList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasVillage masVillage : masVillageList) {
			sb.append("<item>");
			sb.append("<VillageName>" + masVillage.getVillageName() + "</VillageName>");
			sb.append("<VillageId>" + masVillage.getId() + "</VillageId>");
			sb.append("<pincode>" + "" + "</pincode>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * papulate village on change of block
	 * 
	 * @author Mukesh.narayan
	 * @param request
	 * @param response
	 * @throws IOException
	 */

	@SuppressWarnings("unchecked")
	public void populateVillageOfBlock(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateVillageOfBlock ");
		int blockId = 0;
		if (request.getParameter("blockId") != null && !request.getParameter("blockId").equals("")) {
			blockId = Integer.parseInt(request.getParameter("blockId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("blockId", blockId);
		Map<String, Object> detailsMap = registrationHandlerService.populateVillageOfBlock(dataMap);
		List<MasVillage> masVillageList = (List<MasVillage>) detailsMap.get("masVillageList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasVillage masVillage : masVillageList) {
			sb.append("<item>");
			sb.append("<VillageName>" + masVillage.getVillageName() + "</VillageName>");
			sb.append("<VillageId>" + masVillage.getId() + "</VillageId>");
			sb.append("<pincode>" + "" + "</pincode>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * papulate village on change of taluk
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * 
	 */

	@SuppressWarnings("unchecked")
	public void populateVillageBytaluk(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateVillageBytaluk ");
		int talukId = 0;
		if (request.getParameter("talukId") != null && !request.getParameter("talukId").equals("")
				&& !request.getParameter("talukId").equals(" ")) {
			talukId = Integer.parseInt(request.getParameter("talukId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("talukId", talukId);
		Map<String, Object> detailsMap = registrationHandlerService.populateVillageOftaluk(dataMap);
		List<MasVillage> masVillageList = (List<MasVillage>) detailsMap.get("masVillageList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasVillage masVillage : masVillageList) {
			sb.append("<item>");
			sb.append("<VillageName>" + masVillage.getVillageName() + "</VillageName>");
			sb.append("<VillageId>" + masVillage.getId() + "</VillageId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void ajaxForEmployeeDetails(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside ajaxForEmployeeDetails ");
		int employeeId = 0;
		if (request.getParameter("employeeId") != null) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("employeeId", employeeId);
		Map<String, Object> detailsMap = registrationHandlerService.ajaxForEmployeeDetails(dataMap);
		List<MasEmployee> employeeList = (List<MasEmployee>) detailsMap.get("masEmployeeList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (MasEmployee masEmployee : employeeList) {
			sb.append("<item>");
			sb.append("<firstName>" + masEmployee.getFirstName() + "</firstName>");
			sb.append("<middleName>");
			sb.append(masEmployee.getMiddleName() == null ? "" : masEmployee.getMiddleName());
			sb.append("</middleName>");
			sb.append("<lastName>");
			sb.append(masEmployee.getLastName() == null ? "" : masEmployee.getLastName());
			sb.append("</lastName>");
			sb.append("<titleId>");
			sb.append(masEmployee.getTitle() == null ? "0" : masEmployee.getTitle().getId());
			sb.append("</titleId>");
			sb.append("<titleName>");
			sb.append(masEmployee.getTitle() == null ? "" : masEmployee.getTitle().getTitleName());
			sb.append("</titleName>");
			sb.append("<address>");
			sb.append(masEmployee.getPermanentAddress() == null ? "" : masEmployee.getPermanentAddress());
			sb.append("</address>");
			sb.append("<religionId>");
			sb.append("</item>");
		}

		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		//
	}

	@SuppressWarnings("unchecked")
	public void populateDepandentList(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populateDepandentList ");
		int employeeId = 0;
		if (request.getParameter("employeeId") != null) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("employeeId", employeeId);
		Map<String, Object> detailsMap = registrationHandlerService.populateDepandentList(dataMap);
		List<MasEmployeeDependent> employeeDependentList = (List<MasEmployeeDependent>) detailsMap
				.get("employeeDependentList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasEmployeeDependent masEmployeeDependent : employeeDependentList) {
			sb.append("<item>");
			sb.append("<id>" + masEmployeeDependent.getId() + "</id>");
			String depandentName = "";
			if (masEmployeeDependent.getEmployeeDependentName() != null
					&& !masEmployeeDependent.getEmployeeDependentName().equals("")) {
				depandentName = masEmployeeDependent.getEmployeeDependentName();
			}
			sb.append("<name>" + depandentName + "</name>");
			sb.append("<relation>" + masEmployeeDependent.getRelation().getRelationName() + "</relation>");
			sb.append("</item>");

		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void getDepandentDetails(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside getDepandentDetails ");
		int employeeDependentId = 0;
		if (request.getParameter("employeeDependentId") != null) {
			employeeDependentId = Integer.parseInt(request.getParameter("employeeDependentId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("employeeDependentId", employeeDependentId);
		Map<String, Object> detailsMap = registrationHandlerService.getDepandentDetails(dataMap);
		List<MasEmployeeDependent> employeeDependentList = (List<MasEmployeeDependent>) detailsMap
				.get("employeeDependentList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (MasEmployeeDependent masEmployeeDependent : employeeDependentList) {
			sb.append("<item>");
			sb.append("<name>" + masEmployeeDependent.getEmployeeDependentName() + "</name>");
			sb.append("<genderId>");
			sb.append(masEmployeeDependent.getGender() == null ? "" : masEmployeeDependent.getGender().getId());
			sb.append("</genderId>");
			if (masEmployeeDependent.getAddress() != null) {
				sb.append("<address>" + masEmployeeDependent.getAddress() + "</address>");
			}

			String dob = "";
			if (masEmployeeDependent.getDateOfBirth() != null
					&& !HMSUtil.convertDateToStringTypeDate(masEmployeeDependent.getDateOfBirth()).equals("")) {
				dob = HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getDateOfBirth());

				String[] dobArray = dob.split("/");
				int year = Integer.parseInt(dobArray[2]);
				int currentYear = Calendar.getInstance().get(Calendar.YEAR);
				int age = currentYear - year;
				sb.append("<age>" + age + "</age>");
				sb.append("<dob>" + dob + "</dob>");
			} else {
				sb.append("<age></age>");
				sb.append("<dob></dob>");
			}
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * Note: getPatient Details
	 * 
	 * @author Mukesh.narayan
	 * @date 13 July 2010
	 * 
	 */
	public ModelAndView getPatientDetailForAutoComplete(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside getPatientDetailForAutoComplete ");
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String flagPop = "";
		if (request.getParameter("flagPop") != null) {
			flagPop = request.getParameter("flagPop");
		}
		/**
		 * if flagPop==1 means data come from popup window else come from
		 * autocomplete div area code by Mukesh Narayan Singh Date 14 July 2010
		 */
		if (flagPop.equalsIgnoreCase("1")) {
			String pFirstNameId = "";
			String pMiddleNameId = "";
			String pLastNameId = "";
			if (request.getParameter("pFirstNameId") != null) {
				pFirstNameId = request.getParameter("pFirstNameId").trim();
			}
			if (request.getParameter("pMiddleNameId") != null) {
				pMiddleNameId = request.getParameter("pMiddleNameId").trim();
			}
			if (request.getParameter("pLastNameId") != null) {
				pLastNameId = request.getParameter("pLastNameId").trim();
			}

			parameterMap.put("flagPop", flagPop);
			parameterMap.put("pFirstNameId", pFirstNameId);
			parameterMap.put("pMiddleNameId", pMiddleNameId);
			parameterMap.put("pLastNameId", pLastNameId);
		} else {
			String pFirstNameId = "";
			String nameField = "";
			if (request.getParameter("requiredField") != null) {
				nameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(nameField) != null) {
				pFirstNameId = (request.getParameter(nameField));
			}
			parameterMap.put("flagPop", flagPop);
			parameterMap.put("pFirstNameId", pFirstNameId);
		}

		Map<String, Object> map = registrationHandlerService.getPatientDetailForAutoComplete(parameterMap);
		return new ModelAndView(PATIENT_DETAIL_FOR_REGISTRATION_AUTO_COMPLETE_JSP, "map", map);
	}

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(final AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public ModelAndView testWebCam(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside testWebCam ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "testWebCam";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView savePatientImage(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside savePatientImage ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapDetails.put("hinNo", hinNo);
		}
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome + fileSeparator + "uploadedImage" + fileSeparator + hinNo + fileSeparator;
		LOGGER.debug("Path of the image in updatepatientimage()" + uploadURL);
		mapDetails.put("uploadURL", uploadURL);
		Map<String, Object> map = registrationHandlerService.updatePatientImage(mapDetails);
		String jsp = "";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updatePatientImage(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside updatePatientImage ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapDetails.put("hinNo", hinNo);
		}
		String userHome = getServletContext().getRealPath("");
		String fileSeparator = System.getProperty("file.separator");
		String uploadURL = userHome + fileSeparator + "uploadedImage" + fileSeparator + hinNo + fileSeparator;
		LOGGER.debug("uploadURL : " + uploadURL);
		mapDetails.put("uploadURL", uploadURL);
		Map<String, Object> map = registrationHandlerService.updatePatientImage(mapDetails);
		String jsp = "";
		return new ModelAndView(jsp, "map", map);
	}

	// Added by Manjul on 16/01/2012 to generate barcode after patient
	// registration

	public ModelAndView showReprintBarcodeJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showReprintBarcodeJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "rePrintBarcode.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateBarCode(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside generateBarCode ");
		Map<String, Object> parameters = new HashMap<String, Object>();
		String hinNo = "";
		String adNo = "";
		String reportName = "";

		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
			reportName = "patientBarCode";
			parameters.put("hinNo", hinNo);
		}
		if (request.getParameter("adNo") != null) {
			adNo = request.getParameter("adNo");
			reportName = "patientBarCodeAd";
			parameters.put("adNo", adNo);
		}
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView showOPDRegisterGenderReportJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOPDRegisterGenderReportJsp ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}
		mapDetails.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.getUserList(mapDetails);

		map.put("contentJsp", "opdRegisterGenderReport.jsp");
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateOPDRegisterGenderReport(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside generateOPDRegisterGenderReport ");
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String qry = "";
		int gender = 0;
		int empId = 0;
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("gender") != null && request.getParameter("gender") != "") {
			gender = Integer.parseInt(request.getParameter("gender"));

		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));

		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));

		}
		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}

		if (visitType.equals("new")) {
			qry = " and visit.visit_no = 1 ";
		} else if (visitType.equals("repeat")) {
			qry = " and visit.visit_no != 1 ";
		}

		if (request.getParameter("empId") != null && !(request.getParameter("empId")).equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
			map = registrationHandlerService.getUserName(empId);
			if (map.get("userList") != null) {
				userList = (List<Users>) map.get("userList");
			}

			if (userList.size() > 0) {
				Users users = userList.get(0);
				qry += " and  visit.add_edit_by_id=" + users.getId();

				parameters.put("userName", "User Name :" + users.getUserName());
				parameters.put("userId", users.getId());
			}
		}

		LOGGER.debug("qry : " + qry);
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("empId", empId);
		parameters.put("gender", gender);
		parameters.put("qry", qry);
		parameters.put("HOSPITAL_ID", hospitalId);

		HMSUtil.generateReport("OPDRegisterGender", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	// ------------OPD Register State

	public ModelAndView showOPDRegisterStateReportJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOPDRegisterStateReportJsp ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}

		mapDetails.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.getUserList(mapDetails);

		map.put("contentJsp", "opdRegisterStateReport.jsp");
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateOPDRegisterStateReport(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside generateOPDRegisterStateReport ");
		Date fromDate = null;
		Date toDate = null;
		String qry = "";
		int state = 0;
		int empId = 0;
		int hospitalId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();
		HttpSession session = request.getSession();

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("state") != null && !request.getParameter("state").equals("")) {
			state = Integer.parseInt(request.getParameter("state"));
			qry = " and p.state_id=" + state;
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("empId", empId);
		parameters.put("state", state);
		parameters.put("qry", qry);
		parameters.put("HOSPITAL_ID", hospitalId);
		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}
		LOGGER.debug("visitType : " + visitType);

		if (visitType.equals("new")) {
			HMSUtil.generateReport("OPDRegisterState_new", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (visitType.equals("repeat")) {
			HMSUtil.generateReport("OPDRegisterState_Repeat", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		} else if (visitType.equals("newRepeat")) {
			HMSUtil.generateReport("OPDRegisterState_newRepeat", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		}
		if (request.getParameter("empId") != null && !(request.getParameter("empId")).equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
			map = registrationHandlerService.getUserName(empId);
			if (map.get("userList") != null) {
				userList = (List<Users>) map.get("userList");
			}
			Users users = new Users();

			if (userList.size() > 0) {
				users = userList.get(0);
				qry += " and  visit.add_edit_by_id=" + users.getId();
				parameters.put("userName", "User Name :" + users.getUserName());
				parameters.put("userId", users.getId());
			}
		}

		LOGGER.debug("qry : " + qry);
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	// ------------OPD Register Above Age

	public ModelAndView showOPDRegisterAboveAgeReportJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOPDRegisterAboveAgeReportJsp ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}
		Map<String, Object> map = registrationHandlerService.getUserList(mapDetails);

		map.put("contentJsp", "opdRegisterAboveAgeReport.jsp");
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateOPDRegisterAboveAgeReport(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside generateOPDRegisterAboveAgeReport ");
		Date fromDate = null;
		Date toDate = null;
		String qry = "";
		int fromAge = 0;
		int toAge = 0;
		int empId = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();

		if (request.getParameter("fromAge") != null && !request.getParameter("fromAge").equals("")) {
			fromAge = Integer.parseInt(request.getParameter("fromAge"));
		}

		if (request.getParameter("toAge") != null && !request.getParameter("toAge").equals("")) {
			toAge = Integer.parseInt(request.getParameter("toAge"));
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}
		LOGGER.debug("visitType : " + visitType);

		if (request.getParameter("empId") != null && !(request.getParameter("empId")).equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
			map = registrationHandlerService.getUserName(empId);
			if (map.get("userList") != null) {
				userList = (List<Users>) map.get("userList");
			}
			Users users = new Users();

			if (userList.size() > 0) {
				users = userList.get(0);
				qry += " and  visit.add_edit_by_id=" + users.getId();

				parameters.put("userName", "User Name :" + users.getUserName());
				parameters.put("userId", users.getId());
			}
		}

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("empId", empId);
		parameters.put("fromAge", fromAge);
		parameters.put("toAge", toAge);
		parameters.put("qry", qry);
		if (visitType.equals("new")) {
			HMSUtil.generateReport("OPDRegisterAge", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (visitType.equals("repeat")) {
			HMSUtil.generateReport("OPDRegisterAge_Repeat", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (visitType.equals("newRepeat")) {
			HMSUtil.generateReport("OPDRegisterAge_newRepeat", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		}

		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	// ------------OPD Register Below Age

	public ModelAndView showOPDRegisterBelowAgeReportJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOPDRegisterBelowAgeReportJsp ");
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}
		Map<String, Object> map = registrationHandlerService.getUserList(mapDetails);
		map.put("contentJsp", "opdRegisterBelowAgeReport.jsp");
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView generateOPDRegisterBelowAgeReport(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside generateOPDRegisterBelowAgeReport ");
		Date fromDate = null;
		Date toDate = null;
		String qry = "";
		String fromAge = "";
		String toAge = "";
		String fAge = "";
		String tAge = "";
		String fUnit = "";
		String tUnit = "";
		int empId = 0;

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<Users> userList = new ArrayList<Users>();

		if (request.getParameter("fromAge") != null) {
			fromAge = request.getParameter("fromAge");
			fAge = fromAge.substring(0, fromAge.indexOf(' ')).trim();
			fUnit = fromAge.substring(fromAge.indexOf(' ')).trim();
		}

		if (request.getParameter("toAge") != null) {
			toAge = request.getParameter("toAge");
			tAge = toAge.substring(0, toAge.indexOf(' ')).trim();
			tUnit = toAge.substring(toAge.indexOf(' ')).trim();
		}

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}

		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}

		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}

		LOGGER.debug("visitType : " + visitType);
		if (visitType.equals("new")) {
			qry = " and visit.visit_no = 1 ";
		} else if (visitType.equals("repeat")) {
			qry = " and visit.visit_no != 1 ";
		}

		if (request.getParameter("empId") != null && !(request.getParameter("empId")).equals("0")) {
			empId = Integer.parseInt(request.getParameter("empId"));
			map = registrationHandlerService.getUserName(empId);
			if (map.get("userList") != null) {
				userList = (List<Users>) map.get("userList");
			}
			Users users = new Users();

			if (userList.size() > 0) {
				users = userList.get(0);
				qry += " and  visit.add_edit_by_id=" + users.getId();

				parameters.put("userName", "User Name :" + users.getUserName());
				parameters.put("userId", users.getId());
			}
		}
		LOGGER.debug("qry : " + qry);

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("empId", empId);
		parameters.put("fAge", fAge);
		parameters.put("tAge", tAge);
		parameters.put("fUnit", fUnit);
		parameters.put("tUnit", tUnit);
		parameters.put("qry", qry);
		HMSUtil.generateReport("OPDRegisterBelowAge", parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView showAboveBelowRegisterReport(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showAboveBelowRegisterReport ");
		Date fromDate = null;
		Date toDate = null;
		int empId = 0;
		int hospitalId = 0;
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		String visitType = "";
		if (request.getParameter("visitType") != null) {
			visitType = request.getParameter("visitType");
		}
		LOGGER.debug("visitType : " + visitType);

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("empId", empId);
		parameters.put("HOSPITAL_ID", hospitalId);
		if (visitType.equals("new")) {
			HMSUtil.generateReport("patient_age_below_one_year_new_stat", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		} else if (visitType.equals("repeat")) {
			HMSUtil.generateReport("patient_below_one_month_new_stat", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		} else if (visitType.equals("newRepeat")) {

			HMSUtil.generateReport("patient_visit_list_below_one_month_stat_report", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		} else if (visitType.equals("newRepeat1")) {

			HMSUtil.generateReport("patient_age_below_one_year_visit_stat", parameters,
					(Connection) detailsMap.get("conn"), response, getServletContext());
		}

		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView getDocForVisit(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getDocForVisit ");
		int deptId = 0;
		if (request.getParameter(PATIENT_DEPARTMENT) != null && !request.getParameter(PATIENT_DEPARTMENT).equals("0")) {
			deptId = Integer.parseInt(request.getParameter(PATIENT_DEPARTMENT));
		}
		Map<String, Object> map = registrationHandlerService.getDocForVisit(deptId);
		String jsp = "doclist";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPatientStatJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPatientStatJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetails = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			mapDetails.put("deptId", deptId);
		}
		String jsp = "patientStatReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generatePatientStatReport(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside generatePatientStatReport ");
		Date fromDate = null;
		Date toDate = null;
		String gender = "";
		String reportType = "";
		String condition = "";
		String query = "";
		Map<String, Object> parameters = new HashMap<String, Object>();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
		}
		if (request.getParameter("gender") != null && !request.getParameter("gender").equals("")) {
			gender = request.getParameter("gender");
		}
		if (request.getParameter("reportType") != null && !request.getParameter("reportType").equals("")) {
			reportType = request.getParameter("reportType");
		}
		if (request.getParameter("condition") != null && !request.getParameter("condition").equals("")) {
			condition = request.getParameter("condition");
		}

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();

		HttpSession seesion = request.getSession();
		int hospitalId = (Integer) seesion.getAttribute("hospitalId");

		if (gender.equals("Male") && condition.equals("Below 18 years") && reportType.equals("na")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ " and ip.date_of_addmission between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'  and ip.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Male") && condition.equals("Above 18 Years") && reportType.equals("na")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + " and ip.date_of_addmission between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'  and ip.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Below 18 years") && reportType.equals("na")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ " and ip.date_of_addmission between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female'  and ip.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Above 18 Years") && reportType.equals("na")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + " and ip.date_of_addmission between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female'  and ip.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Male") && condition.equals("Below 18 years") && reportType.equals("nr")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ "  and p.reg_date between '" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10)
					+ "-" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'  and p.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Male") && condition.equals("Above 18 Years") && reportType.equals("nr")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + "  and p.reg_date between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'  and p.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Below 18 years") && reportType.equals("nr")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ "  and p.reg_date between '" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10)
					+ "-" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female'  and p.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Above 18 Years") && reportType.equals("nr")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + "  and p.reg_date between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female' and p.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Male") && condition.equals("Below 18 years") && reportType.equals("nv")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ "  and v.visit_date between '" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10)
					+ "-" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'   and v.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Male") && condition.equals("Above 18 Years") && reportType.equals("nv")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + "  and v.visit_date between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Male'  and v.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Below 18 years") && reportType.equals("nv")) {
			query = "where cast(substring(p.age,0,3) as int)>0 and cast(substring(p.age,0,3) as int)<18 "
					+ "  and v.visit_date between '" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10)
					+ "-" + HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female'   and v.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		} else if (gender.equals("Female") && condition.equals("Above 18 Years") && reportType.equals("nv")) {
			query = "where  cast(substring(p.age,0,3) as int)>18 " + "  and v.visit_date between '"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(fromDate).substring(0, 2) + "' and '"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(6, 10) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(3, 5) + "-"
					+ HMSUtil.convertDateToStringTypeDate(toDate).substring(0, 2)
					+ "' and s.administrative_sex_name='Female'   and v.hospital_id=" + hospitalId
					+ " order by cast(substring(p.age,0,3) as int) ";
		}
		LOGGER.debug("query : " + query);

		parameters.put("query", query);
		if (!query.equals("") && reportType.equals("na")) {
			HMSUtil.generateReport("New_Admission_Statistics", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		} else if (!query.equals("") && reportType.equals("nr")) {
			HMSUtil.generateReport("New_Registration_Statistics", parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());
		} else if (!query.equals("") && reportType.equals("nv")) {
			HMSUtil.generateReport("New_Visit_Statistics", parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	public ModelAndView populateRegistrationContact(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside populateRegistrationContact ");
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		Map<String, Object> map = registrationHandlerService.populateRegistrationContact(deptId);
		String jsp = "populateRegContact";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView populateRegistrationVisit(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside populateRegistrationVisit ");
		int deptId = 0;
		int hospitalId = 0;
		String hinNo = "";
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		String visitSearch = "";
		if (request.getParameter("visitSearch") != null && !(request.getParameter("visitSearch").equals(""))) {
			visitSearch = request.getParameter("visitSearch");
		}

		int page = 1;
		Map<String, Object> map = registrationHandlerService.populateRegistrationVisit(deptId, hospitalId, hinNo, page,
				visitSearch);
		String jsp = "populateRegVisit";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView populateRegistrationBill(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside populateRegistrationBill ");
		int deptId = 0;
		HttpSession session = request.getSession();
		BigDecimal amount = new BigDecimal("0");

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		String billNo = opBillingHandlerService.generateBillNo("OS", "display", hospitalId);

		Map<String, Object> map = registrationHandlerService.populateRegistrationBill(deptId);
		map.put("patientTypeId", 3);
		map.put("companyId", 0);
		map.put("patientCategory", "OP");
		map.put("billTypeId", 2);
		map.put("regType", "G");

		Map<String, Object> chargeMap = opBillingHandlerService.getChargeAmountAfterDiscount(map);

		if (chargeMap.get("chargeAmountAfterDis") != null) {
			amount = (BigDecimal) chargeMap.get("chargeAmountAfterDis");
			map.put("amount", amount);
		}
		if (chargeMap.get("rate") != null) {
			map.put("rate", chargeMap.get("rate"));
		}
		if (map.get("discAmt") != null) {
			map.put("discAmt", chargeMap.get("discAmt"));
		}
		if (chargeMap.get("stdDeduction") != null) {
			map.put("stdDeduction", chargeMap.get("stdDeduction"));
		}
		if (chargeMap.get("regChargeId") != null) {
			map.put("regChargeId", chargeMap.get("regChargeId"));
		}

		map.put("billNo", billNo);
		String jsp = "populateRegBill";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("rawtypes")
	public void populateRegistrationCount(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside populateRegistrationCount ");
		Map<String, Object> map = registrationHandlerService.populateRegistrationCount();

		if (map.get("newRegistartion") != null) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write(((List) map.get("newRegistartion")).get(0) + "");
				pw.flush();
				pw.close();
			} catch (IOException ioException) {
				LOGGER.error("Error while writing to print writer" + ioException.getStackTrace().toString());
			}
		}
	}

	/**
	 * Method to convert patient temporary registration number to UHID
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView uhidConversion(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside uhidConversion ");
		boolean saveStatus = false;
		String message = "";
		String hinId = "";

		Box box = HMSUtil.getBox(request);
		hinId = request.getParameter("aadharNumber");
		LOGGER.debug("conversion hinId " + hinId);

		Map<String, Object> map = registrationHandlerService.uhidConversion(box);
		saveStatus = (Boolean) map.get("saveStatus");

		if (saveStatus) {
			message = " UHID Conversion Done Successfully. Do you want to print ? ";
		}

		String backUrl = "/hms/hms/registration?method=uhidConversion";
		map.put("backUrl", backUrl);
		map.put("message", message);
		map.put("hinNo", hinId);

		String jsp = "msgForUhidConversion.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	// Adding code for UHID conversion by kishore on 21st mar 15
	public ModelAndView showUHIDConversionJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showUHIDConversionJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contentJsp", UNHID_CONVERSION_JSP);
		return new ModelAndView("index", "map", map);

	}

	// Adding code for Print Token by kishore on 23st mar 15
	public ModelAndView showPrintTokenJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPrintTokenJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "PrintToken.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * To Open Online Appointment Page
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showOnlineAppointmentJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showOnlineAppointmentJsp ");
		int deptId = 0;
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		Map<String, Object> map = registrationHandlerService.populateOnlinePage(deptId, hospitalId);

		if (!box.getString("futureConsultFlag").equalsIgnoreCase("")) {
			map.put("pName", box.getString("pName"));
			String jsp = "onlineAppointment";
			return new ModelAndView(jsp, "map", map);
		} else {
			String jsp = "onlineAppointment.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	}
	
	
	public void getMinMaxDaysForAppointment(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getMinMaxDaysForAppointment ");
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		
		if (StringUtils.isNotBlank(request.getParameter("hospitalName"))) {
			hospitalId =  Integer.parseInt(request.getParameter("hospitalName"));
		}else if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (StringUtils.isNotBlank(request.getParameter("deptId")))  {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}

		Map<String, Object> map = registrationHandlerService.getMinMaxDaysForAppointment(deptId, hospitalId);
		try {
			PrintWriter writer = response.getWriter();
			writer.write(map.get("minday")+","+map.get("maxday"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* Added By Om Tripathi 26/08/2017Starts */
	public ModelAndView showOnlineAppointmentPreviewJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOnlineAppointmentPreviewJsp ");
		int deptId = 0;
		int hospitalId = 0;
		int empId = 0;
		int reviewInterval = 0;
		Date appointmentDate = null;
		String preference = null;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
	
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
		}
	
		if(StringUtils.isNotBlank(request.getParameter("reviewInterval"))){
			reviewInterval = 	Integer.parseInt(request.getParameter("reviewInterval"));
		}
		
		if(StringUtils.isNotBlank(request.getParameter("appointmentDate"))){
			appointmentDate = 	HMSUtil.dateFormatterDDMMYYYY(request.getParameter("appointmentDate"));
		}
		
		if(StringUtils.isNotBlank(request.getParameter("preference"))){
			preference = 	request.getParameter("preference");
		}
		
		Map<String, Object> map = registrationHandlerService.populateOnlinePage(deptId, hospitalId);
		
		Map<String, Object> personalReviewAppointmentDataMap  = registrationHandlerService.populatePersonalReviewAppointmentData(deptId, hospitalId,reviewInterval, appointmentDate, preference, empId);
		
		map.put("reviewInterval", personalReviewAppointmentDataMap.get("reviewInterval"));
		map.put("appointmentDate", personalReviewAppointmentDataMap.get("appointmentDate"));
		map.put("opSession", personalReviewAppointmentDataMap.get("opSession"));
		map.put("tokenCounterTimeSlotmap", personalReviewAppointmentDataMap.get("tokenCounterTimeSlotMap"));
		map.put("minday", personalReviewAppointmentDataMap.get("minday"));
		map.put("maxday", personalReviewAppointmentDataMap.get("maxday"));
		map.put("unitDays", personalReviewAppointmentDataMap.get("unitDays"));
		map.put("appSetupDaysList", personalReviewAppointmentDataMap.get("appSetupDaysList"));
		map.put("empId", empId);
		if (!box.getString("futureConsultFlag").equalsIgnoreCase("")) {
			String jsp = "personalreview";
			return new ModelAndView(jsp, "map", map);
		} else {
			String jsp = "personalreview.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}
	}

	public ModelAndView showOnlineAppointmentPreviewResponseJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOnlineAppointmentPreviewResponseJsp ");
		int deptId = 0;
		int hospitalId = 0;
		int empId = 0;
		int reviewInterval = 0;
		Date appointmentDate = null;
		String preference = null;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
		}

		if(StringUtils.isNotBlank(request.getParameter("reviewInterval"))){
			reviewInterval = 	Integer.parseInt(request.getParameter("reviewInterval"));
		}
		
		if(StringUtils.isNotBlank(request.getParameter("appointmentDate"))){
			appointmentDate = 	HMSUtil.dateFormatterDDMMYYYY(request.getParameter("appointmentDate"));
		}
		
		if(StringUtils.isNotBlank(request.getParameter("preference"))){
			preference = 	request.getParameter("preference");
		}
		
		Map<String, Object> map = registrationHandlerService.populateOnlinePage(deptId, hospitalId);
		
		Map<String, Object> personalReviewAppointmentDataMap  = registrationHandlerService.populatePersonalReviewAppointmentData(deptId, hospitalId,reviewInterval, appointmentDate, preference,empId);
		
		map.put("reviewInterval", personalReviewAppointmentDataMap.get("reviewInterval"));
		map.put("appointmentDate", personalReviewAppointmentDataMap.get("appointmentDate"));
		map.put("opSession", personalReviewAppointmentDataMap.get("opSession"));
		map.put("tokenCounterTimeSlotmap", personalReviewAppointmentDataMap.get("tokenCounterTimeSlotMap"));

		map.put("empId", empId); //Added by Arbind on 15-12-2017
		String jsp = "responseForPersonalReviewTokens";
		return new ModelAndView(jsp, "map", map);
		
	}
	
	/* Added By Om Tripathi 26/08/2017End */

	/**
	 * Method for saving Online Patient's Appointment
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView saveOnlineAppointment(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside saveOnlineAppointment ");

		int hospitalId = 0;
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		box.put("tokenNo", 0);

		Map<String, Object> map = registrationHandlerService.saveOnlineAppointment(box);

		String jsp = "onlineAppointment.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView showAppRegistrationList(final HttpServletRequest request, final HttpServletResponse response)
			throws ParseException {

		LOGGER.debug("Inside showAppRegistrationList ");
		String title = "";
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map1 = registrationHandlerService.showSessionList(hospitalId);
		List<MasSession> masSessionList = new ArrayList<MasSession>();

		if (null != map1.get("masSessionList")) {
			masSessionList = (List<MasSession>) map1.get("masSessionList");
		}
		int visitSessionId = 0;
		if (null != masSessionList && masSessionList.size() > 0) {

			Date currentSessionTime = new Date();
			SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
			String ct = parser.format(currentSessionTime);
			Date cur = parser.parse(ct);

			for (MasSession masSession : masSessionList) {
				Date fromTime = parser.parse(masSession.getFromTime());
				Date toTime = parser.parse(masSession.getToTime());
				if (cur.after(fromTime) && cur.before(toTime)) {
					visitSessionId = masSession.getId();

				}
			}
		}
		Map<String, Object> map = registrationHandlerService.showAppRegistrationList(hospitalId, visitSessionId);
		title = "Appointment Registration List";
		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientInvestigationApp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPatientInvestigationApp ");
		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		Map<String, Object> map = registrationHandlerService.showPatientInvestigationApp(hospitalId);
		String title = "Appointment Investigation List";
		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * method to show the Patient Referral List
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	public ModelAndView showPatientReferalList(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPatientReferalList ");
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
			}
		}
		Map<String, Object> map = registrationHandlerService.showPatientReferalList(hospitalId, deptId);

		String title = "Refered Patient List";
		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getVisitNoNew(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getVisitNoNew ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		if (!hinNo.equals("")) {
			details.put("hinNo", hinNo);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		List<Visit> visitNoList = registrationHandlerService.getVisitNo(details);

		String jsp = "populateVisitNoForUpdateNew";
		map.put("visitNoList", visitNoList);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveServerSideEPFToClient(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside saveServerSideEPFToClient ");
		MultipartFormDataRequest mrequest = null;
		try {
			if (MultipartFormDataRequest.isMultipartFormData(request)) {
				mrequest = new MultipartFormDataRequest(request);
			}

			@SuppressWarnings("rawtypes")
			Enumeration enumeration = null;
			if (mrequest != null) {
				enumeration = mrequest.getParameterNames();
			}
			String[] values = null;
			String[] hin = null;
			String[] pxVal = null;
			if (enumeration != null) {
				while (enumeration.hasMoreElements()) {
					String key = (String) enumeration.nextElement();
					if ("uploaded_file".equalsIgnoreCase(key)) {
						values = mrequest.getParameterValues(key);
					}
					if ("type".equalsIgnoreCase(key)) {
						hin = mrequest.getParameterValues(key);
					}
					if ("pxvalue".equalsIgnoreCase(key)) {
						pxVal = mrequest.getParameterValues(key);
					}
					LOGGER.debug("Key : " + key);
					LOGGER.debug("Value : " + mrequest.getParameterValues(key));
				}
			}

			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					LOGGER.debug("Value of PDF : " + values[i]);
				}
			}

			if (hin != null) {
				for (int i = 0; i < hin.length; i++) {
					LOGGER.debug("Value of HIN : " + values[i]);
				}
			}

			if (pxVal != null) {
				for (int i = 0; i < pxVal.length; i++) {
					LOGGER.debug("Value of Px : " + values[i]);
				}
			}

			String support = getServletContext().getRealPath("/uploadedImage/" + hin[0] + ".html_files");
			File sup = new File(support);
			if (!(sup.exists())) {
				sup.mkdirs();
			}

			File fileNamePx = new File(sup, "px");
			if (fileNamePx.exists()) {
				fileNamePx.delete();
			}

			byte[] bytesPx = pxVal[0].getBytes();
			FileOutputStream fileOuputStreamPx = new FileOutputStream(fileNamePx);
			DataOutputStream outputStreamPx = new DataOutputStream(fileOuputStreamPx);
			outputStreamPx.write(bytesPx);
			outputStreamPx.close();

			String uploadURL = getServletContext().getRealPath("/uploadedImage/");
			File dir = new File(uploadURL);
			if (!(dir.exists())) {
				dir.mkdirs();
			}

			File fileName = new File(dir, hin[0] + ".html");
			if (fileName.exists()) {
				fileName.delete();
			}

			byte[] bytes = null;
			if (values != null) {
				bytes = values[0].getBytes();
			}
			FileOutputStream fileOuputStream = new FileOutputStream(fileName);
			DataOutputStream outputStream = new DataOutputStream(fileOuputStream);
			outputStream.write(bytes);
			outputStream.close();
		} catch (UploadException uploadException) {
			LOGGER.error("Error while creating MultipartFormDataRequest object "
					+ uploadException.getStackTrace().toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to outputstream" + ioException.getStackTrace().toString());
		}

		return null;
	}

	private String savePatientEPFReportInToFileForLeanServer(final HttpServletRequest request,
			final HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";

		Map<String, Object> parameters = new HashMap<String, Object>();
		String reportName = "PATIENT_EPF1";
		if (box.get("hinNO") != null) {
			hinNo = box.getArrayList("hinNO").get(0).toString();
		}
		String from;
		try {
			from = HMSUtil.convertDateToStringTypeDate(toDate);
			fromDate = HMSUtil.addDaysToDate(from, -30);
		} catch (Exception e1) {
			LOGGER.error("Exception occured in HMSUtil.convertDateToStringTypeDate");
		}

		String address = "";
		Map<String, Object> map = registrationHandlerService.showPaitentDetail(hinNo);
		PatientAddress patientAddress = (PatientAddress) map.get("patientAddress");
		UploadDocuments uploadDocuments = (UploadDocuments) map.get("uploadDocument");
		if (patientAddress != null) {
			if ("P".equalsIgnoreCase(patientAddress.getAddressType().getAddressTypeCode())) {
				address = patientAddress.getAddress();
				if (patientAddress.getVillage() != null) {
					address = "," + patientAddress.getVillage().getVillageName();
				}
				if (patientAddress.getCity() != null) {
					address = "," + patientAddress.getCity();
				}
				if (patientAddress.getDistrict() != null) {
					address = "," + patientAddress.getDistrict().getDistrictName();
				}
				if (patientAddress.getState() != null) {
					address = "," + patientAddress.getState().getStateName();
				}
				LOGGER.debug("address : " + address);
			}
		}
		java.awt.image.BufferedImage img = null;
		if (uploadDocuments != null) {
			byte[] byteImg = uploadDocuments.getPatientDocument();
			try {
				img = ImageIO.read(new java.io.ByteArrayInputStream(byteImg));
			} catch (IOException ioException) {
				LOGGER.error("Error while reading byte array from ImageIO" + ioException.getStackTrace().toString());
			}

		}

		parameters.put("image", img);
		parameters.put("address", address);
		parameters.put("hin_no", hinNo);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
		parameters.put("IMAGE_DIR_LFT", getServletContext().getRealPath("/jsp/images/gok-logo.jpg"));

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		map.put(HIN_NO, hinNo);
		HMSUtil.generateReportToSaveFile(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext(), map);
		return null;
	}

	public String saveClientRegisterPatientToServer(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside saveClientRegisterPatientToServer ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = registrationHandlerService.saveClientRegisterPatientToServer(box);
		String status;
		if (map.get("success") != null) {
			status = "success";
		} else {
			status = "faliure";
		}
		return status;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	public ModelAndView showNursingAppointmentList(final HttpServletRequest request, final HttpServletResponse response)
			throws ParseException {

		LOGGER.debug("Inside showNursingAppointmentList ");

		int hospitalId = 0;
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);

		Map<String, Object> map = registrationHandlerService.showNursingAppointmentList(box);
		String jsp = "patientVisitSearch.jsp";
		String title = "Nursing Appointment  List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openUploadPopWindow(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside openUploadPopWindow ");
		Map<String, Object> details = new HashMap<String, Object>();
		int departmentId = 0;
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}
		if (departmentId != 0) {
			details.put("departmentId", departmentId);
		}

		if (request.getParameter("updatePatienthinid") != null) {
			details.put("hinId", Integer.parseInt(request.getParameter("updatePatienthinid")));
		}
		details.put("flag", "n");

		Map<String, Object> map = registrationHandlerService.uploadAndViewDocuments(details);
		String jsp = "patientUploadAndViewDocument";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView uploadAndViewDocuments(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside uploadAndViewDocuments ");
		Map<String, Object> details = new HashMap<String, Object>();

		int departmentId = 0;
		int hinId = 0;
		String flag = "n";
		String uploadFrom = "NA";

		MultipartFormDataRequest mrequest = null;
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException uploadException) {
				LOGGER.error("Error creating MultipartFormDataRequest object "
						+ uploadException.getStackTrace().toString());
			} catch (IOException ioException) {
				LOGGER.error("Error while writing to outputstream" + ioException.getStackTrace().toString());
			}

		}
		if (mrequest != null) {
			if (mrequest.getParameter("hinId") != null) {
				hinId = Integer.parseInt(mrequest.getParameter("hinId"));
				details.put("hinId", Integer.parseInt(mrequest.getParameter("hinId")));
			}

			if (mrequest.getParameter("uploadFrom") != null) {
				uploadFrom = mrequest.getParameter("uploadFrom");
				details.put("uploadFrom", mrequest.getParameter("uploadFrom"));
			}

			if (mrequest.getParameter("visitId") != null) {
				details.put("visitId", Integer.parseInt(mrequest.getParameter("visitId")));
			}

			if (mrequest.getParameter("inpatientId") != null) {
				details.put("inpatientId", Integer.parseInt(mrequest.getParameter("inpatientId")));
			}

			String filename = "";
			String uploadURL = getServletContext().getRealPath("/UploadedDocuments/registration/" + hinId + "/");

			LOGGER.debug("uploadFrom : " + uploadFrom);
			if (uploadFrom.equalsIgnoreCase("OPD")) {
				uploadURL = getServletContext().getRealPath("/UploadedDocuments/registration/" + hinId + "/");
			}

			if (uploadFrom.equalsIgnoreCase("IP")) {
				uploadURL = getServletContext().getRealPath("/UploadedDocuments/IP/" + hinId + "/");
			}

			if (mrequest.getParameter("department") != null) {
				departmentId = Integer.parseInt(request.getParameter("department"));
			}
			if (departmentId != 0) {
				details.put("departmentId", departmentId);
			}
			if (mrequest.getParameter("fileName") != null) {
				filename = mrequest.getParameter("fileName");
			}

			if (mrequest.getParameter("flag") != null) {
				flag = mrequest.getParameter("flag");
			}
			details.put("flag", flag);

			if (mrequest.getParameter("comments") != null) {
				String comments = mrequest.getParameter("comments");
				details.put("comments", comments);
			}
			details.put("uploadURL", uploadURL);

			if (flag.equalsIgnoreCase("y")) {

				details.put("filename", filename);
				StringTokenizer strToken = new StringTokenizer(filename, ".");
				Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
				filename = strToken.nextToken();
				String fileExtension = strToken.nextToken();
				String whiteList = "*." + fileExtension;
				HMSUtil.uploadFileMaintenance(mrequest, uploadURL, whiteList, fileSizeLimit, filename);
			}
		}
		Map<String, Object> map = registrationHandlerService.uploadAndViewDocuments(details);
		String jsp = "patientUploadAndViewDocument";
		String msg = "File Successfuly Uploaded.";
		map.put("message", msg);

		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unchecked")
	public void populatePPWardByDistrict(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePPWardByDistrict ");
		int districtId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("districtId", districtId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePPWardByDistrict(dataMap);
		List<Object[]> wardList = (List<Object[]>) detailsMap.get("wardList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (Object[] ward : wardList) {
			sb.append("<item>");
			sb.append("<WardName>" + ward[1] + "</WardName>");
			sb.append("<WardId>" + ward[0] + "</WardId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public ModelAndView getNameAndMobile(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside getNameAndMobile ");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String mobNo = "";
		String name = "";
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		if (request.getParameter("mobNo") != null && !request.getParameter("mobNo").equals("")) {
			mobNo = request.getParameter("mobNo");
			dataMap.put("mobNo", mobNo);
		}

		if (request.getParameter("name") != null && !request.getParameter("name").equals("")) {
			name = request.getParameter("name");
			dataMap.put("name", name);
		}

		if (request.getParameter("mobNoForSearch") != null && !request.getParameter("mobNoForSearch").equals("")) {
			mobNo = request.getParameter("mobNoForSearch");
			dataMap.put("mobNo", mobNo);
		}

		if (request.getParameter("nameForMobNoSearch") != null
				&& !request.getParameter("nameForMobNoSearch").equals("")) {
			name = request.getParameter("nameForMobNoSearch");
			dataMap.put("name", name);
		}

		dataMap.put("page", page);

		String jsp = "responsePatientForMobile";
		Map<String, Object> map = registrationHandlerService.getNameAndMobile(dataMap);
		map.put("mobNo", mobNo);
		map.put("name", name);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * Method for pagination of current registered patient in visit screen
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView paginationForPatientVisitJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside paginationForPatientVisitJsp ");
		int deptId = 0;
		int hospitalId = 0;
		String hinNo = "";
		if (request.getParameter("hinNo") != null && !(request.getParameter("hinNo").equals(""))) {
			hinNo = request.getParameter("hinNo");
		}

		String visitSearch = "";
		if (request.getParameter("visitSearch") != null && !(request.getParameter("visitSearch").equals(""))) {
			visitSearch = request.getParameter("visitSearch");
		}

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Map<String, Object> map = registrationHandlerService.paginationForPatientVisitJsp(deptId, hospitalId, hinNo,
				page, visitSearch);
		String pathh = "/hms/hms/registration?method=displayImage&patientHinNo=" + hinNo;

		map.put("contentJsp", PATIENT_VISIT_SEARCH_JSP);
		map.put("pathh", pathh);
		map.put("hinNo", hinNo);
		map.put("hospitalId", hospitalId);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * Print Patient Prescription Added by Arbind
	 */
	public ModelAndView printPrescriptionCard(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside printPrescriptionCard ");

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();

		int pHinId = 0;
		int hospitalId = 0;
		String view = "";
		Date appointmentDateOp=new Date();
		HttpSession session = request.getSession();

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameters.put("hospitalId", hospitalId);

			if (request.getParameter("pHinId") != null) {
				pHinId = Integer.parseInt(request.getParameter("pHinId"));
				parameters.put("pHinId", pHinId);
			}

			String departmentIdList = "";
			if (request.getParameter("departmentId") != null) {
				departmentIdList = request.getParameter("departmentId");
				parameters.put("departmentIdList", departmentIdList);
			}

			List<String> depIdList = new ArrayList<String>(Arrays.asList(departmentIdList.split(",")));
			parameters.put("depIdList", depIdList);
			String pname = request.getParameter("pname");
			if (pname != null) {
				parameters.put("pname", pname);
			}

			String ages = request.getParameter("ages");
			if (ages != null) {
				parameters.put("ages", ages);
			}

			String gender = request.getParameter("gender");
			if (gender != null) {
				parameters.put("gender", gender);
			}

			String filename = request.getParameter("filename");
			if (filename != null) {
				parameters.put("filename", filename);
			}
			String mobileno = request.getParameter("mobileno");
			if (mobileno != null) {
				parameters.put("mobileno", mobileno);
			}

			String hospitalName = "";
			if (session.getAttribute("hospitalName") != null) {
				hospitalName = (String) session.getAttribute("hospitalName");
				parameters.put("hospitalName", hospitalName);
			}
			if (request.getParameter("appointmentDateOp") != null) {
				appointmentDateOp = HMSUtil.convertStringTypeDateToDateType(request.getParameter("appointmentDateOp"));
				parameters.put("appointmentDateOp", appointmentDateOp);
			}
			String header="";
			if (request.getParameter("header") != null) {
				header =(String)request.getParameter("header");
			}

			Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
			String query = " and v.department_id in(" + departmentIdList.substring(1, departmentIdList.length()) + ")";
			LOGGER.debug("query : " + query);

			parameters.put("query", query);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Visit visit = null;
			Map<String, Object> dataMap = registrationHandlerService.getPatientDetailsForOPCard(parameters);
			if (dataMap.get("hospitalName") != null) {
				parameters.put("hospitalName", (String)dataMap.get("hospitalName"));
			}
			if (dataMap.get("hospitalAddress") != null) {
				parameters.put("hospitalAddress", (String)dataMap.get("hospitalAddress"));
				}
			if (dataMap.get("patientList") != null) {
				@SuppressWarnings("unchecked")
				List<Visit> patientList = (List<Visit>) dataMap.get("patientList");
				if (patientList != null && patientList.size() > 0) {
					visit = patientList.get(0);

					String unitCode = "";
					String income = "";
					String mobileNo = "";
					String creationSource = "";
					String visitTime = "";
					String address = visit.getHin().getPatientAddress();
					// Added by Arbind on 09-11-2017
					if (address != null && !address.equals("") && address.charAt(0) == ',') {
						address = address.substring(1);
					}
					if (address != null && !address.equals("")) {
						address = address.replaceAll("\n", " ").replaceAll("\r", " ");
					}
					String hinNo = visit.getHin().getHinNo();

					if (visit.getHin().getMonthlyIncome() != null) {
						income = visit.getHin().getMonthlyIncome().toString();
					}

					if (visit.getHin().getMobileNumber() != null) {
						mobileNo = visit.getHin().getMobileNumber();
					}

					String name = visit.getHin().getPFirstName();

					if (visit.getHin().getPMiddleName() != null) {
						name = name + visit.getHin().getPMiddleName();
					}

					if (visit.getHin().getPLastName() != null) {
						name = name + visit.getHin().getPLastName();
					}

					String visitDate = simpleDateFormat.format(visit.getVisitDate());
					String departmentName = visit.getDepartment().getDepartmentName();

					if (visit.getUnit() != null) {
						unitCode = visit.getUnit().getUnitCode();
					}

					if (visit.getVisitTime() != null) {
						visitTime = visit.getVisitTime();
					}

					String tokenNo = visit.getTokenNo().toString();
					String sno = visit.getTotalHospitalVisit().toString();
					gender = visit.getHin().getSex().getAdministrativeSexName();

					String age = visit.getHin().getAge();
					String yearMonth = "";
					if (visit.getHin().getDateOfBirth() != null) {
						Date dob = visit.getHin().getDateOfBirth();
						String ymd = HMSUtil.calculateYearMonthDay(dob);
						String[] d = ymd.split("&");
						int year1 = Integer.parseInt(d[0].toString());
						int months1 = Integer.parseInt(d[1].toString());
						int days1 = Integer.parseInt(d[2].toString());
						yearMonth = year1 != 0 ? d[0] + " Y " : "";
						yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
						yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
					}
					age = yearMonth;
					if (visit.getCreationSource() != null) {
						creationSource = visit.getCreationSource();
					}
					parameters.put("unit_code", unitCode);
					parameters.put("income", income);
					parameters.put("mobileno", mobileNo);
					parameters.put("address", address);
					parameters.put("gender", gender);
					parameters.put("hin_no", hinNo);
					parameters.put("name", name);
					parameters.put("visit_date", visitDate);
					parameters.put("visit_time", visitTime);
					parameters.put("department_name", departmentName);
					parameters.put("ages", age);
					parameters.put("creation_source", creationSource);
					parameters.put("token_no", tokenNo);
					parameters.put("sno", sno);
					parameters.put("pHinId", pHinId);

					LOGGER.debug("*****************************************************pateint Data for op card***********************************************************");
					LOGGER.debug("pATH  " + request.getContextPath() + "/uploadedImage/" + "Patient_Prescription_Card"
							+ pHinId + "" + hospitalId + ".pdf");
					if(!header.equals("true")){
					map.put("Report_Path", request.getContextPath() + "/uploadedImage/" + "Patient_Prescription_Card"
							+ pHinId + "" + hospitalId + ".pdf");
					HMSUtil.generateReportForDirectPrintPatient("Patient_Prescription_Card", parameters,
							(Connection) detailsMap.get("conn"), response, getServletContext(), getServletContext()
									.getRealPath("/uploadedImage/"), pHinId, hospitalId);
					view = "printReports";
					}else{
						map.put("Report_Path", request.getContextPath() + "/uploadedImage/" + "Patient_Prescription_Card_With_Header"
								+ pHinId + "" + hospitalId + ".pdf");
						HMSUtil.generateReportForDirectPrintPatient("Patient_Prescription_Card_With_Header", parameters,
								(Connection) detailsMap.get("conn"), response, getServletContext(), getServletContext()
										.getRealPath("/uploadedImage/"), pHinId, hospitalId);
						view = "printReports";
					}
				}
			}

			try {
				((Connection) detailsMap.get("conn")).close();
			} catch (SQLException sqlException) {
				LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
			}
		}
		return new ModelAndView(view, "map", map);
	}

	/**
	 * Mehtod for save the patient Details from online portal, android app and
	 * kisosk
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientInformationFromOtherSource(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside submitPatientInformationFromOtherSource ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		List<OnlinePatientVisit> onlinePatientVisitList = null;
		OnlinePatientVisit onlinePatientVisit = null;
		List<Patient> existingHinNoList = null;
		int deptId = 0;
		int userId = 0;
		int hospitalId = 0;
		int hinId = 0;
		String hinNo = null;
		String message = null;
		String patientFlag = null;
		Boolean successfullyAdded = false;
		Boolean alreadyAdded = false;
		Boolean successfullyVisitCreated = false;
		Boolean duplicateRegisterStatus = false;

		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}

		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}

		if (request.getParameter("patientFlag") != null && !request.getParameter("patientFlag").trim().equals("")) {
			patientFlag = request.getParameter("patientFlag");
		}
		if (patientFlag != null && patientFlag.equalsIgnoreCase("new")) {
			map = registrationHandlerService.submitPatientInformationFromOtherSrc(box);
		} else if (patientFlag != null && patientFlag.equalsIgnoreCase("old")) {
			map = registrationHandlerService.getPatientDetailsForVisitFromOthrSrc(box);
			alreadyAdded = true;
		}

		hinNo = (String) map.get("hinNo");

		if (map.get("existingHinNoList") != null) {
			existingHinNoList = (List<Patient>) map.get("existingHinNoList");
		}

		if (map.get("onlinePatientVisitList") != null) {
			onlinePatientVisitList = (List<OnlinePatientVisit>) map.get("onlinePatientVisitList");
		}

		if (map.get("succesfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("succesfullyAdded");
		}

		if (map.get("duplicateRegisterStatus") != null) {
			duplicateRegisterStatus = (Boolean) map.get("duplicateRegisterStatus");
		}

		if ((successfullyAdded && (existingHinNoList == null || existingHinNoList.size() == 0)) || alreadyAdded) {
			// Start of Create patient visit at the time of patient registration
			Map<String, Object> visitMap = new HashMap<String, Object>();
			int currentPriority = 0;
			hinId = 0;
			ArrayList<String> serviceCentreList = new ArrayList<String>();

			if (onlinePatientVisitList != null && onlinePatientVisitList.size() > 0) {
				onlinePatientVisit = onlinePatientVisitList.get(0);
				for (OnlinePatientVisit onlinePatientVisitObj : onlinePatientVisitList) {
					serviceCentreList.add(String.valueOf(onlinePatientVisitObj.getDepartmentId()));
				}
			}

			if (null != serviceCentreList && serviceCentreList.size() > 0) {
				if (map.get("patientHinId") != null) {
					hinId = (Integer) map.get("patientHinId");
				}
				visitMap.put("hinId", hinId);
				visitMap.put("age", onlinePatientVisitList.get(0).getAge());

				if (onlinePatientVisit.getPriorityNumber() != null) {
					currentPriority = onlinePatientVisit.getPriorityNumber();
					visitMap.put("currentPriority", currentPriority);
				}

				int dutyDoctorId = 0;
				if (onlinePatientVisit.getDoctorId() != null && onlinePatientVisit.getDoctorId() != 0) {
					dutyDoctorId = onlinePatientVisit.getDoctorId();
					visitMap.put("dutyDoctorId", dutyDoctorId);
				}

				int unitId = 0;
				if (onlinePatientVisit.getUnitId() != null && onlinePatientVisit.getUnitId() != 0) {
					unitId = onlinePatientVisit.getUnitId();
					visitMap.put("unitId", unitId);
				}

				if (onlinePatientVisit.getComplaintId() != null && onlinePatientVisit.getComplaintId() != 0) {
					int complaintId = onlinePatientVisit.getComplaintId();
					visitMap.put("complaintId", complaintId);
				}

				if (onlinePatientVisit.getVisitDate() != null) {
					Date visitDate = onlinePatientVisit.getVisitDate();
					visitMap.put("visitDate", visitDate);
				}

				if (onlinePatientVisit.getVisitTime() != null) {
					visitMap.put("visitTime", onlinePatientVisit.getVisitTime());
				}

				if (onlinePatientVisit.getOpSession() != null && onlinePatientVisit.getOpSession() != 0) {
					visitMap.put("opsessionId", onlinePatientVisit.getOpSession());
				}

				if (onlinePatientVisit.getAppointmentType() != null
						&& !onlinePatientVisit.getAppointmentType().trim().equals("")) {
					visitMap.put("appointmentType", onlinePatientVisit.getAppointmentType());
				}

				String cashReceived = "n";
				if (onlinePatientVisit.getCashReceivedStatus() != null
						&& onlinePatientVisit.getCashReceivedStatus().equals("y")) {
					cashReceived = onlinePatientVisit.getCashReceivedStatus();
				}
				visitMap.put("cashReceived", cashReceived);
				visitMap.put("departmentIdlist", serviceCentreList);
				visitMap.put("hospitalId", hospitalId);
				int currentVisitNo = 0;
				if (onlinePatientVisit.getVisitNo() != null) {
					currentVisitNo = onlinePatientVisit.getVisitNo();
					currentVisitNo = currentVisitNo - 1;
					visitMap.put("currentVisitNo", currentVisitNo);
				}

				map = registrationHandlerService.saveVisitInformation(visitMap);

				map.put("departmentId", serviceCentreList);
				map.put("hinId", hinId);
				map.put("hospitalId", hospitalId);
				map.put("hinNo", hinNo);
			}

			if (map != null & map.get("successfullyVisitCreated") != null) {
				successfullyVisitCreated = (Boolean) map.get("successfullyVisitCreated");
			}

			if (successfullyAdded && successfullyVisitCreated) {
				message = " Registration and Visit Information saved successfully. UHID  is " + hinNo
						+ ". Do you want to print ?";
				map.put("hinNo", hinNo);

			} else if (successfullyAdded) {
				message = " Registration Information saved successfully but Visit Data can not be saved. Do you want to print ?";
			} else if (successfullyVisitCreated) {
				message = " Visit Information saved successfully. Do you want to print ?";
			} else if (!successfullyVisitCreated) {
				message = "Visit already created for this department !";
			} else {
				message = "Some problem Occured! Try Again !";
			}
		} else if (duplicateRegisterStatus) {
			message = "Data can not be saved.This patient is already exists.";
		}

		String backUrl = "/hms/hms/registration?method=showRegistrationJsp";
		map.put("backUrl", backUrl);

		map.put("contentJsp", MSG_FOR_REG);
		map.put("message", message);
		map.put("successfullyAdded", successfullyAdded);
		map.put("successfullyVisitCreated", successfullyVisitCreated);
		map.put("flag", "regFrmOthrSrc");
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientRegFromSourcesJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showPatientRegFromSourcesJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "patientRegFrmOthrSrc.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPatientRegistrationDataFromOtherSrc(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside getPatientRegistrationDataFromOtherSrc ");
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}

		Map<String, Object> map = registrationHandlerService.getPatientRegistrationDataFromOtherSrc(box);
		String jsp = "responseForPatientDetails";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showOnlineAppointmentVisitJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOnlineAppointmentVisitJsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "onlineAppointmentVisit.jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOnlineAppointmentDetails(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getOnlineAppointmentDetails ");
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}

		Map<String, Object> map = registrationHandlerService.getOnlineAppointmentDetails(box);
		String jsp = "responseForOnlineAppointmentVisit";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOnlineAppointmentVisitDetails(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside submitOnlineAppointmentVisitDetails ");
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		String requestedIP = request.getRemoteAddr();
		String message = "";
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}

		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
		}
		box.put("requestedIP", requestedIP);

		boolean duplicateVisitSatatus = false;
		Map<String, Object> map = registrationHandlerService.submitOnlineAppointmentVisitDetails(box);
		if (null != map.get("duplicateVisitSatatus")) {
			duplicateVisitSatatus = (Boolean) map.get("duplicateVisitSatatus");
		}

		boolean successfullyAdded = false;
		if (!duplicateVisitSatatus) {
			if (null != map.get("successfullyAdded")) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}

			if (successfullyAdded) {
				message = " Visit information saved Successfully.?";
			} else {
				message = "Some problem Occured! Try Again.";
			}

		} else {
			message = "Visit already created for this Department.";
		}
		String jsp = "onlineAppointmentVisit.jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitMobileNumberForOTP(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside submitMobileNumberForOTP ");
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		String mobNo = "";
		if (null != request.getParameter("mobNo") && !request.getParameter("mobNo").equalsIgnoreCase("")) {
			mobNo = request.getParameter("mobNo");
		}
		if (null != request.getParameter("mobileNoVerify")
				&& !request.getParameter("mobileNoVerify").equalsIgnoreCase("")) {
			mobNo = request.getParameter("mobileNoVerify");
		}

		box.put("mobNo", mobNo);
		Map<String, Object> detailsMap = registrationHandlerService.submitMobileNumberForOTP(box);
		String responseMsg = "Mobile Number is not registered.";
		if (detailsMap.get("msg") != null) {
			responseMsg = (String) detailsMap.get("msg");
		}

		try {
			response.getWriter().write(responseMsg);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
		map.put("mobileNumber", mobNo);
		String jsp = "otp";
		return new ModelAndView(jsp, "map", map);

	}

	public void eKycAuthenticationOtp(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside eKycAuthenticationOtp ");

		String cerFileName = null, pfxFileName = null;
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");

		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading authclient.properties : " + ioException.getStackTrace().toString());
		}
		cerFileName = properties.getProperty("cerFileName");
		pfxFileName = properties.getProperty("pfxFileName");

		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");

		}
		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();

		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		// Assemble gender
		request1.setGender("");

		// Assemble DOB
		String dob = null;
		LOGGER.debug("dob : " + dob);

		request1.setDob(dob);

		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setNameMatchStrategy(MatchingStrategy.P);

		// Pa match strategy
		request1.setAddressMatchStrategy(MatchingStrategy.P);

		// Pfa match strategy
		request1.setFullAddressMatchStrategy(MatchingStrategy.P);
		String signatureVariferKey = "";

		if (request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".pfx");
		}

		String publicKeyFile = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName) != null) {
			publicKeyFile = request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName);
		}

		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);

		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		boolean authenticateStatus = false;
		String message = "";
		String otpTxn = "";
		Map<String, Object> map = f.sendOTPRequestActionPerformed(aadharNo);
		if (map.get("status") != null) {
			authenticateStatus = (Boolean) map.get("status");
		}
		if (map.get("otpTxn") != null) {
			otpTxn = (String) map.get("otpTxn");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<authenticateStatus>" + authenticateStatus + "</authenticateStatus>");
		sb.append("<otpTxn>" + otpTxn + "</otpTxn>");

		sb.append("<message>" + message + "</message>");
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public void eKycAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside eKycAuthentication ");

		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");

		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading authclient.properties : " + ioException.getStackTrace().toString());
		}
		String cerFileName = properties.getProperty("cerFileName");
		String pfxFileName = properties.getProperty("pfxFileName");

		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}
		String otpTxn = "";
		if (request.getParameter("otpTxn") != null && !request.getParameter("otpTxn").equals("")) {
			otpTxn = request.getParameter("otpTxn");

		}
		String otp = "";
		if (request.getParameter("otp") != null && !request.getParameter("otp").equals("")) {
			otp = request.getParameter("otp");
		}

		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();

		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		String dynamicPin = otp;
		if ((dynamicPin != null) && (dynamicPin.length() > 0)) {
			request1.setDynamicPin(dynamicPin);
		}
		request1.setGender("Select gender");
		request1.setOtpTxn(otpTxn);

		// Assemble DOB
		String dob = null;
		LOGGER.debug("dob : " + dob);

		request1.setDob(dob);

		request1.setNameMatchValue(100);
		request1.setLocalNameMatchValue(90);

		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setFullAddressMatchValue(100);
		request1.setLocalFullAddressMatchValue(90);

		request1.setNameMatchStrategy(MatchingStrategy.E);
		request1.setAddressMatchStrategy(MatchingStrategy.E);
		request1.setFullAddressMatchStrategy(MatchingStrategy.E);
		String publicKeyFile = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName) != null) {
			publicKeyFile = request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName);

		}

		String signatureVariferKey = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".pfx");
		}

		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);
		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		boolean ekycAuthenticateStatus = false;
		String message = "";

		Map<String, Object> eKycResponseMap = f.authenticateRequest(request1, false, dynamicPin);

		if (null != eKycResponseMap.get("message")) {
			message = (String) eKycResponseMap.get("message");
		}
		if (null != eKycResponseMap.get("ekycAuthenticateStatus")) {
			ekycAuthenticateStatus = (Boolean) eKycResponseMap.get("ekycAuthenticateStatus");
		}
		if (null != eKycResponseMap.get("otpTxn")) {
			otpTxn = (String) eKycResponseMap.get("otpTxn");
		}

		String residentName = "";
		if (null != eKycResponseMap.get("resident_Name")) {
			residentName = (String) eKycResponseMap.get("resident_Name");
		}

		String ekycdob = "";
		String[] ageAndUnit = null;
		String[] yearofBirth = null;
		if (null != eKycResponseMap.get("dob")) {
			ekycdob = (String) eKycResponseMap.get("dob");
			ekycdob = HMSUtil.changeDobFormat(ekycdob);
			if (ekycdob.contains("/")) {
				ageAndUnit = HMSUtil.calculateEkycAgeByDOB(ekycdob);
				yearofBirth = ekycdob.split("/");
			} else {
				yearofBirth = ekycdob.split("-");
			}
		}
		String phoneno = "";
		if (null != eKycResponseMap.get("phone_no")) {
			phoneno = (String) eKycResponseMap.get("phone_no");
		}
		String ekycemail = "";
		if (null != eKycResponseMap.get("email")) {
			ekycemail = (String) eKycResponseMap.get("email");
		}

		String careof = "";
		String careOfName = "";
		if (null != eKycResponseMap.get("care_of")) {
			careof = (String) eKycResponseMap.get("care_of");
			if (!careof.equalsIgnoreCase("")) {
				careOfName = careof.substring(3);
			}
		}

		String houseNo = "";
		if (null != eKycResponseMap.get("house_no")) {
			houseNo = (String) eKycResponseMap.get("house_no");
		}
		String Landmark = "";
		if (null != eKycResponseMap.get("Landmark")) {
			Landmark = (String) eKycResponseMap.get("Landmark");
		}
		String Locality = "";
		if (null != eKycResponseMap.get("Locality")) {
			Locality = (String) eKycResponseMap.get("Locality");
		}
		String vtc = "";
		if (null != eKycResponseMap.get("Vtc")) {
			vtc = (String) eKycResponseMap.get("Vtc");
		}
		String subDistrict = "";
		if (null != eKycResponseMap.get("sub_district")) {
			subDistrict = (String) eKycResponseMap.get("sub_district");
		}
		String ekycdistrict = "";
		if (null != eKycResponseMap.get("district")) {
			ekycdistrict = (String) eKycResponseMap.get("district");
		}
		String ekycstate = "";
		if (null != eKycResponseMap.get("state")) {
			ekycstate = (String) eKycResponseMap.get("state");
		}

		String pincode = "";
		if (null != eKycResponseMap.get("Pincode")) {
			pincode = (String) eKycResponseMap.get("Pincode");
		}

		String postoffice = "";
		if (null != eKycResponseMap.get("postoffice")) {
			postoffice = (String) eKycResponseMap.get("postoffice");
		}
		String ekycstreet = "";
		if (null != eKycResponseMap.get("street")) {
			ekycstreet = (String) eKycResponseMap.get("street");
		}
		String gender = "";
		if (null != eKycResponseMap.get("gender")) {
			gender = (String) eKycResponseMap.get("gender");
			if (gender.equalsIgnoreCase("M")) {
				gender = "Male";
			} else if (gender.equalsIgnoreCase("F")) {
				gender = "Female";
			} else {
				gender = "Transgender";
			}
		}

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		sb.append("<item>");

		sb.append("<authenticateStatus>" + ekycAuthenticateStatus + "</authenticateStatus>");
		sb.append("<gender>" + gender + "</gender>");
		sb.append("<ekycstreet>" + ekycstreet + "</ekycstreet>");
		sb.append("<postoffice>" + postoffice + "</postoffice>");
		sb.append("<Pincode>" + pincode + "</Pincode>");
		sb.append("<ekycstate>" + ekycstate + "</ekycstate>");
		sb.append("<ekycdistrict>" + ekycdistrict + "</ekycdistrict>");
		sb.append("<sub_district>" + subDistrict + "</sub_district>");
		sb.append("<Vtc>" + vtc + "</Vtc>");
		sb.append("<Locality>" + Locality + "</Locality>");
		sb.append("<Landmark>" + Landmark + "</Landmark>");
		sb.append("<house_no>" + houseNo + "</house_no>");
		sb.append("<care_of>" + careOfName + "</care_of>");
		sb.append("<ekycemail>" + ekycemail + "</ekycemail>");
		sb.append("<phone_no>" + phoneno + "</phone_no>");
		sb.append("<ekycdob>" + ekycdob + "</ekycdob>");
		sb.append("<resident_Name>" + residentName + "</resident_Name>");
		sb.append("<message>" + message + "</message>");
		sb.append("<otpTxn>" + otpTxn + "</otpTxn>");
		sb.append("<aadharNo>" + aadharNo + "</aadharNo>");
		if (null != yearofBirth && null != yearofBirth[2]) {
			sb.append("<yearofBirth>" + yearofBirth[2] + "</yearofBirth>");
		} else {
			sb.append("<yearofBirth>" + "" + "</yearofBirth>");
		}
		if (null != ageAndUnit && null != ageAndUnit[0]) {
			sb.append("<unit>" + ageAndUnit[0] + "</unit>");
		} else {
			sb.append("<unit>" + "" + "</unit>");
		}
		if (null != ageAndUnit && null != ageAndUnit[1]) {
			sb.append("<age>" + ageAndUnit[1] + "</age>");
		} else {
			sb.append("<age>" + "" + "</age>");
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public void webEKycAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, JSONException {

		LOGGER.debug("Inside webEKycAuthentication ");
		JSONObject ekycDetailsResponse = new JSONObject();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");

		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading authclient.properties : " + ioException.getStackTrace().toString());
		}
		String cerFileName = properties.getProperty("cerFileName");
		String pfxFileName = properties.getProperty("pfxFileName");

		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}
		String otp = "";
		if (request.getParameter("otp") != null && !request.getParameter("otp").equals("")) {
			otp = request.getParameter("otp");
		}

		String otpTxn = "";
		if (request.getParameter("otpTxn") != null && !request.getParameter("otpTxn").equals("")) {
			otpTxn = request.getParameter("otpTxn");
		}

		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();
		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		String dynamicPin = otp;
		if ((dynamicPin != null) && (dynamicPin.length() > 0)) {
			request1.setDynamicPin(dynamicPin);
		}

		request1.setGender("Select gender");
		request1.setOtpTxn(otpTxn);

		// Assemble DOB
		String dob = null;

		request1.setDob(dob);
		request1.setNameMatchValue(100);
		request1.setLocalNameMatchValue(90);
		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setFullAddressMatchValue(100);
		request1.setLocalFullAddressMatchValue(90);
		request1.setNameMatchStrategy(MatchingStrategy.E);
		request1.setAddressMatchStrategy(MatchingStrategy.E);
		request1.setFullAddressMatchStrategy(MatchingStrategy.E);
		String publicKeyFile = "";
		String signatureVariferKey = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".pfx");
		}

		if (request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName) != null) {
			publicKeyFile = request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName);
		}
		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);
		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		boolean ekycAuthenticateStatus = false;
		Map<String, Object> eKycResponseMap = f.authenticateRequest(request1, false, dynamicPin);

		Image image = null;
		if (null != eKycResponseMap.get("image")) {
			image = (Image) eKycResponseMap.get("image");
			ekycDetailsResponse.put("image", image);
		}
		byte[] imageBytes = null;
		if (null != eKycResponseMap.get("imageBytes")) {
			imageBytes = (byte[]) eKycResponseMap.get("imageBytes");
			ekycDetailsResponse.put("image", imageBytes);
		}
		ekycDetailsResponse.put("aadharNo", aadharNo);

		if (null != eKycResponseMap.get("ekycAuthenticateStatus")) {
			ekycAuthenticateStatus = (Boolean) eKycResponseMap.get("ekycAuthenticateStatus");
			ekycDetailsResponse.put("ekycAuthenticateStatus", ekycAuthenticateStatus);
		}
		String residentName = "";
		if (null != eKycResponseMap.get("resident_Name")) {
			residentName = (String) eKycResponseMap.get("resident_Name");
			ekycDetailsResponse.put("resident_Name", residentName);
		}
		String ekycdob = "";
		String[] yearofBirth = null;
		if (null != eKycResponseMap.get("dob")) {
			ekycdob = (String) eKycResponseMap.get("dob");
			ekycdob = HMSUtil.changeDobFormat(ekycdob);
			String[] ageAndUnit = null;
			if (ekycdob.contains("/")) {
				ageAndUnit = HMSUtil.calculateEkycAgeByDOB(ekycdob);
				ekycDetailsResponse.put("unit", ageAndUnit[0]);
				ekycDetailsResponse.put("age", ageAndUnit[1]);
				yearofBirth = ekycdob.split("/");
				ekycDetailsResponse.put("yearofBirth", yearofBirth[2]);
			} else {
				yearofBirth = ekycdob.split("-");
			}
		}
		if (null != eKycResponseMap.get("phone_no")) {
			String phoneno = (String) eKycResponseMap.get("phone_no");
			ekycDetailsResponse.put("phone_no", phoneno);
		}

		if (null != eKycResponseMap.get("email")) {
			String ekycemail = (String) eKycResponseMap.get("email");
			ekycDetailsResponse.put("ekycemail", ekycemail);
		}
		if (null != eKycResponseMap.get("care_of")) {
			String careofname = "";
			String careoftitle = "";
			String careof = (String) eKycResponseMap.get("care_of");
			if (!careof.equalsIgnoreCase("")) {
				careofname = careof.substring(3);
				careoftitle = careof.substring(0, 2);
			}
			ekycDetailsResponse.put("care_of_title", careoftitle);
			ekycDetailsResponse.put("care_of_name", careofname);
		}

		if (null != eKycResponseMap.get("house_no")) {
			String houseNo = (String) eKycResponseMap.get("house_no");
			ekycDetailsResponse.put("house_no", houseNo);
		}
		if (null != eKycResponseMap.get("Landmark")) {
			String Landmark = (String) eKycResponseMap.get("Landmark");
			ekycDetailsResponse.put("Landmark", Landmark);
		}
		if (null != eKycResponseMap.get("Locality")) {
			String Locality = (String) eKycResponseMap.get("Locality");
			ekycDetailsResponse.put("Locality", Locality);
		}
		if (null != eKycResponseMap.get("Vtc")) {
			String vtc = (String) eKycResponseMap.get("Vtc");
			ekycDetailsResponse.put("Vtc", vtc);
		}
		if (null != eKycResponseMap.get("sub_district")) {
			String subDistrict = (String) eKycResponseMap.get("sub_district");
			ekycDetailsResponse.put("sub_district", subDistrict);
		}
		if (null != eKycResponseMap.get("district")) {
			String ekycdistrict = (String) eKycResponseMap.get("district");
			ekycDetailsResponse.put("ekycdistrict", ekycdistrict);
		}
		if (null != eKycResponseMap.get("state")) {
			String ekycstate = (String) eKycResponseMap.get("state");
			ekycDetailsResponse.put("ekycstate", ekycstate);
		}
		if (null != eKycResponseMap.get("Pincode")) {
			String pincode = (String) eKycResponseMap.get("Pincode");
			ekycDetailsResponse.put("Pincode", pincode);
		}

		if (null != eKycResponseMap.get("postoffice")) {
			String postoffice = (String) eKycResponseMap.get("postoffice");
			ekycDetailsResponse.put("postoffice", postoffice);
		}
		if (null != eKycResponseMap.get("street")) {
			String ekycstreet = (String) eKycResponseMap.get("street");
			ekycDetailsResponse.put("ekycstreet", ekycstreet);
		}

		if (null != eKycResponseMap.get("message")) {
			String message = (String) eKycResponseMap.get("message");
			ekycDetailsResponse.put("message", message);
		}
		if (null != eKycResponseMap.get("gender")) {
			String gender = (String) eKycResponseMap.get("gender");
			if (gender.equalsIgnoreCase("M")) {
				gender = "Male";
			} else if (gender.equalsIgnoreCase("F")) {
				gender = "Female";
			} else {
				gender = "Transgender";
			}
			ekycDetailsResponse.put("gender", gender);
			ekycDetailsResponse.put("dob", ekycdob);
		}
		try {
			response.setContentType("application/json");
			response.getWriter().write(ekycDetailsResponse.toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public void webPortalEKycAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, JSONException {

		LOGGER.debug("Inside webPortalEKycAuthentication ");
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");

		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception ioException) {
			LOGGER.error("Error while loading the properties file authclient.properties : "
					+ ioException.getStackTrace().toString());
		}
		String cerFileName = properties.getProperty("cerFileName");
		String pfxFileName = properties.getProperty("pfxFileName");

		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}
		String otp = "";
		if (request.getParameter("otp") != null && !request.getParameter("otp").equals("")) {
			otp = request.getParameter("otp");
		}
		String otpTxn = "";
		if (request.getParameter("otpTxn") != null && !request.getParameter("otpTxn").equals("")) {
			otpTxn = request.getParameter("otpTxn");
		}

		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();

		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		String dynamicPin = otp;
		if ((dynamicPin != null) && (dynamicPin.length() > 0)) {
			request1.setDynamicPin(dynamicPin);
		}
		request1.setGender("Select gender");
		request1.setOtpTxn(otpTxn);

		// Assemble DOB
		String dob = null;
		LOGGER.debug("dob : " + dob);

		request1.setDob(dob);
		request1.setNameMatchValue(100);
		request1.setLocalNameMatchValue(90);
		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setFullAddressMatchValue(100);
		request1.setLocalFullAddressMatchValue(90);
		request1.setNameMatchStrategy(MatchingStrategy.E);
		request1.setAddressMatchStrategy(MatchingStrategy.E);
		request1.setFullAddressMatchStrategy(MatchingStrategy.E);

		String publicKeyFile = "";
		String signatureVariferKey = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".pfx");
		}
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName) != null) {
			publicKeyFile = request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName);
		}
		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);
		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		Map<String, Object> eKycResponseMap = new HashMap<String, Object>();
		eKycResponseMap = f.authenticateRequest(request1, false, dynamicPin);

		JSONObject ekycDetailsResponse = new JSONObject();
		ekycDetailsResponse.put("aadharNo", aadharNo);
		Image image = null;
		if (null != eKycResponseMap.get("image")) {
			image = (Image) eKycResponseMap.get("image");
			ekycDetailsResponse.put("image", image);
		}
		if (null != eKycResponseMap.get("imageBytes")) {
			byte[] imageBytes = (byte[]) eKycResponseMap.get("imageBytes");
			ekycDetailsResponse.put("image", imageBytes);
		}

		if (null != eKycResponseMap.get("ekycAuthenticateStatus")) {
			boolean ekycAuthenticateStatus = (Boolean) eKycResponseMap.get("ekycAuthenticateStatus");
			ekycDetailsResponse.put("ekycAuthenticateStatus", ekycAuthenticateStatus);
		}
		if (null != eKycResponseMap.get("resident_Name")) {
			String residentName = (String) eKycResponseMap.get("resident_Name");
			ekycDetailsResponse.put("resident_Name", residentName);
		}
		String[] yearofBirth = null;
		String ekycdob = "";
		if (null != eKycResponseMap.get("dob")) {
			ekycdob = (String) eKycResponseMap.get("dob");
			ekycdob = HMSUtil.changeDobFormat(ekycdob);
			if (ekycdob.contains("/")) {
				String[] ageAndUnit = HMSUtil.calculateEkycAgeByDOB(ekycdob);
				ekycDetailsResponse.put("unit", ageAndUnit[0]);
				ekycDetailsResponse.put("age", ageAndUnit[1]);
				yearofBirth = ekycdob.split("/");
				ekycDetailsResponse.put("yearofBirth", yearofBirth[2]);
			} else {
				yearofBirth = ekycdob.split("-");
			}
		}

		if (null != eKycResponseMap.get("phone_no")) {
			String phoneno = (String) eKycResponseMap.get("phone_no");
			ekycDetailsResponse.put("phone_no", phoneno);
		}

		if (null != eKycResponseMap.get("email")) {
			String ekycemail = (String) eKycResponseMap.get("email");
			ekycDetailsResponse.put("ekycemail", ekycemail);
		}

		if (null != eKycResponseMap.get("care_of")) {
			String careof = "";
			String careofName = "";
			String careOfTitle = "";
			careof = (String) eKycResponseMap.get("care_of");
			if (!careof.equalsIgnoreCase("")) {
				careofName = careof.substring(3);
				careOfTitle = careof.substring(0, 2);
			}
			ekycDetailsResponse.put("care_of_title", careOfTitle);
			ekycDetailsResponse.put("care_of_name", careofName);
		}

		if (null != eKycResponseMap.get("house_no")) {
			String houseNo = (String) eKycResponseMap.get("house_no");
			ekycDetailsResponse.put("house_no", houseNo);
		}
		if (null != eKycResponseMap.get("Landmark")) {
			String Landmark = (String) eKycResponseMap.get("Landmark");
			ekycDetailsResponse.put("Landmark", Landmark);
		}
		if (null != eKycResponseMap.get("Locality")) {
			String Locality = (String) eKycResponseMap.get("Locality");
			ekycDetailsResponse.put("Locality", Locality);
		}
		if (null != eKycResponseMap.get("Vtc")) {
			String vtc = (String) eKycResponseMap.get("Vtc");
			ekycDetailsResponse.put("Vtc", vtc);
		}
		if (null != eKycResponseMap.get("sub_district")) {
			String subDistrict = (String) eKycResponseMap.get("sub_district");
			ekycDetailsResponse.put("sub_district", subDistrict);
		}
		if (null != eKycResponseMap.get("district")) {
			String ekycdistrict = (String) eKycResponseMap.get("district");
			ekycDetailsResponse.put("ekycdistrict", ekycdistrict);
		}
		if (null != eKycResponseMap.get("state")) {
			String ekycstate = (String) eKycResponseMap.get("state");
			ekycDetailsResponse.put("ekycstate", ekycstate);
		}
		if (null != eKycResponseMap.get("Pincode")) {
			String pincode = (String) eKycResponseMap.get("Pincode");
			ekycDetailsResponse.put("Pincode", pincode);
		}

		if (null != eKycResponseMap.get("postoffice")) {
			String postoffice = (String) eKycResponseMap.get("postoffice");
			ekycDetailsResponse.put("postoffice", postoffice);
		}
		if (null != eKycResponseMap.get("street")) {
			String ekycstreet = (String) eKycResponseMap.get("street");
			ekycDetailsResponse.put("ekycstreet", ekycstreet);
		}

		if (null != eKycResponseMap.get("message")) {
			String message = (String) eKycResponseMap.get("message");
			ekycDetailsResponse.put("message", message);
		}

		if (null != eKycResponseMap.get("gender")) {
			String gender = (String) eKycResponseMap.get("gender");
			if (gender.equalsIgnoreCase("M")) {
				gender = "Male";
			} else if (gender.equalsIgnoreCase("F")) {
				gender = "Female";
			} else {
				gender = "Transgender";
			}
			ekycDetailsResponse.put("gender", gender);
			ekycDetailsResponse.put("dob", ekycdob);
		}
		try {
			response.setContentType("application/json");
			response.getWriter().write(ekycDetailsResponse.toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter " + ioException.getStackTrace().toString());
		}

	}

	public void webPortalEKycAuthenticationOtp(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, JSONException {

		LOGGER.debug("Inside webPortalEKycAuthenticationOtp ");
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("authclient.properties");

		Properties properties = new Properties();
		try {
			properties.load(resourcePath.openStream());
		} catch (IOException ioException) {
			LOGGER.error("Error while loading the properties file : " + ioException.getStackTrace().toString());
		}
		String cerFileName = properties.getProperty("cerFileName");
		String pfxFileName = properties.getProperty("pfxFileName");

		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}

		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();
		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		// Assemble gender
		request1.setGender("");

		// Assemble DOB
		String dob = null;

		request1.setDob(dob);
		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setNameMatchStrategy(MatchingStrategy.P);

		// Pa match strategy
		request1.setAddressMatchStrategy(MatchingStrategy.P);

		// Pfa match strategy
		request1.setFullAddressMatchStrategy(MatchingStrategy.P);

		String signatureVariferKey = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + pfxFileName + ".pfx");
		}

		String publicKeyFile = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName) != null) {
			publicKeyFile = request.getSession().getServletContext().getRealPath("/eKYC/" + cerFileName);
		}

		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);

		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		boolean authenticateStatus = false;
		String authStatus = "";

		String message = "";
		String otpTxn = "";

		Map<String, Object> map = f.sendOTPRequestActionPerformed(aadharNo);
		if (map.get("status") != null) {
			authenticateStatus = (Boolean) map.get("status");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (map.get("otpTxn") != null) {
			otpTxn = (String) map.get("otpTxn");
		}

		if (authenticateStatus) {
			authStatus = "true";
		} else {
			authStatus = "false";
		}

		JSONObject ekycDetailsResponse = new JSONObject();
		ekycDetailsResponse.put("ekycStatus", authStatus);
		ekycDetailsResponse.put("ekycmessage", message);
		ekycDetailsResponse.put("otpTxn", otpTxn);

		try {
			response.setContentType("application/json");
			response.getWriter().write(ekycDetailsResponse.toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter" + ioException.getStackTrace().toString());
		}
	}

	public void webEKycAuthenticationOtp(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, JSONException {

		LOGGER.debug("Inside webEKycAuthenticationOtp ");
		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}
		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();

		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		// Assemble gender
		request1.setGender("");

		// Assemble DOB
		String dob = null;

		request1.setDob(dob);

		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setNameMatchStrategy(MatchingStrategy.P);
		// Pa match strategy
		request1.setAddressMatchStrategy(MatchingStrategy.P);

		// Pfa match strategy
		request1.setFullAddressMatchStrategy(MatchingStrategy.P);
		String signatureVariferKey = "";

		if (request.getSession().getServletContext().getRealPath("/eKYC/" + "PFXfiLE" + ".cer") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + "PFXfiLE" + ".pfx");
		}

		String publicKeyFile = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + "uidai_auth_encrypt_preprodnew" + ".cer") != null) {
			publicKeyFile = request.getSession().getServletContext()
					.getRealPath("/eKYC/" + "uidai_auth_encrypt_preprodnew" + ".cer");
		}
		SampleClientMainFrame f = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);

		Meta m = f.createMeta();
		request1.setDeviceMetaData(m);

		boolean authenticateStatus = false;
		String authStatus = "";
		String message = "";
		Map<String, Object> map = f.sendOTPRequestActionPerformed(aadharNo);
		if (map.get("status") != null) {
			authenticateStatus = (Boolean) map.get("status");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}

		if (authenticateStatus) {
			authStatus = "true";
		} else {
			authStatus = "false";
		}

		JSONObject ekycDetailsResponse = new JSONObject();
		ekycDetailsResponse.put("ekycStatus", authStatus);
		ekycDetailsResponse.put("ekycmessage", message);

		try {
			response.setContentType("application/json");
			response.getWriter().write(ekycDetailsResponse.toString());
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to printwriter " + ioException.getStackTrace().toString());
		}
	}

	public void kioskEKycAuthentication(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside kioskEKycAuthentication ");
		String aadharNo = "";
		if (request.getParameter("aadharNo") != null && !request.getParameter("aadharNo").equals("")) {
			aadharNo = request.getParameter("aadharNo");
		}

		String otp = "";
		if (request.getParameter("otp") != null && !request.getParameter("otp").equals("")) {
			otp = request.getParameter("otp");
		}

		String otpTxn = "";
		if (request.getParameter("otpTxn") != null && !request.getParameter("otpTxn").equals("")) {
			otpTxn = request.getParameter("otpTxn");
		}

		DeviceCollectedAuthData request1 = new DeviceCollectedAuthData();
		String uid = aadharNo;
		request1.setUid(uid);
		request1.setLanguage(null);

		String dynamicPin = otp;
		if ((dynamicPin != null) && (dynamicPin.length() > 0)) {
			request1.setDynamicPin(dynamicPin);
		}

		request1.setGender("Select gender");
		request1.setOtpTxn(otpTxn);

		// Assemble DOB
		String dob = null;
		request1.setDob(dob);

		request1.setNameMatchValue(100);
		request1.setLocalNameMatchValue(90);
		request1.setFullAddress("");
		request1.setLocalFullAddress("");
		request1.setFullAddressMatchValue(100);
		request1.setLocalFullAddressMatchValue(90);
		request1.setNameMatchStrategy(MatchingStrategy.E);
		request1.setAddressMatchStrategy(MatchingStrategy.E);
		request1.setFullAddressMatchStrategy(MatchingStrategy.E);
		String publicKeyFile = "";
		if (request.getSession().getServletContext().getRealPath("/eKYC/" + "uidai_auth_encrypt_preprodnew" + ".cer") != null) {
			publicKeyFile = request.getSession().getServletContext()
					.getRealPath("/eKYC/" + "uidai_auth_encrypt_preprodnew" + ".cer");
		}
		String signatureVariferKey = "";

		if (request.getSession().getServletContext().getRealPath("/eKYC/" + "PFXfiLE" + ".pfx") != null) {
			signatureVariferKey = request.getSession().getServletContext().getRealPath("/eKYC/" + "PFXfiLE" + ".pfx");
		}
		SampleClientMainFrame sampleClientMainFrame = new SampleClientMainFrame(publicKeyFile, signatureVariferKey);
		Meta m = sampleClientMainFrame.createMeta();
		request1.setDeviceMetaData(m);

		boolean ekycAuthenticateStatus = false;
		String message = "";

		Map<String, Object> eKycResponseMap = sampleClientMainFrame.authenticateRequest(request1, false, dynamicPin);

		if (null != eKycResponseMap.get("message")) {
			message = (String) eKycResponseMap.get("message");
		}
		if (null != eKycResponseMap.get("ekycAuthenticateStatus")) {
			ekycAuthenticateStatus = (Boolean) eKycResponseMap.get("ekycAuthenticateStatus");
		}

		String residentName = "";
		if (null != eKycResponseMap.get("resident_Name")) {
			residentName = (String) eKycResponseMap.get("resident_Name");
		}
		String ekycdob = "";
		String[] ageAndUnit = null;
		String[] yearofBirth = null;
		if (null != eKycResponseMap.get("dob")) {
			ekycdob = (String) eKycResponseMap.get("dob");
			ekycdob = HMSUtil.changeDobFormat(ekycdob);
			if (ekycdob.contains("/")) {
				ageAndUnit = HMSUtil.calculateEkycAgeByDOB(ekycdob);
				yearofBirth = ekycdob.split("/");
			} else {
				yearofBirth = ekycdob.split("-");
			}
		}
		String phoneno = "";
		if (null != eKycResponseMap.get("phone_no")) {
			phoneno = (String) eKycResponseMap.get("phone_no");
		}
		String ekycemail = "";
		if (null != eKycResponseMap.get("email")) {
			ekycemail = (String) eKycResponseMap.get("email");
		}

		String careOfName = "";
		if (null != eKycResponseMap.get("care_of")) {
			String careof = (String) eKycResponseMap.get("care_of");
			if (!careof.equalsIgnoreCase("")) {
				careOfName = careof.substring(3);

			}

		}
		String houseNo = "";
		if (null != eKycResponseMap.get("house_no")) {
			houseNo = (String) eKycResponseMap.get("house_no");
		}
		String Landmark = "";
		if (null != eKycResponseMap.get("Landmark")) {
			Landmark = (String) eKycResponseMap.get("Landmark");
		}
		String Locality = "";
		if (null != eKycResponseMap.get("Locality")) {
			Locality = (String) eKycResponseMap.get("Locality");
		}
		String vtc = "";
		if (null != eKycResponseMap.get("Vtc")) {
			vtc = (String) eKycResponseMap.get("Vtc");
		}
		String subDistrict = "";
		if (null != eKycResponseMap.get("sub_district")) {
			subDistrict = (String) eKycResponseMap.get("sub_district");
		}
		String ekycdistrict = "";
		if (null != eKycResponseMap.get("district")) {
			ekycdistrict = (String) eKycResponseMap.get("district");
		}
		String ekycstate = "";
		if (null != eKycResponseMap.get("state")) {
			ekycstate = (String) eKycResponseMap.get("state");
		}
		String pincode = "";
		if (null != eKycResponseMap.get("Pincode")) {
			pincode = (String) eKycResponseMap.get("Pincode");
		}

		String postoffice = "";
		if (null != eKycResponseMap.get("postoffice")) {
			postoffice = (String) eKycResponseMap.get("postoffice");
		}
		String ekycstreet = "";
		if (null != eKycResponseMap.get("street")) {
			ekycstreet = (String) eKycResponseMap.get("street");
		}
		String gender = "";
		if (null != eKycResponseMap.get("gender")) {
			gender = (String) eKycResponseMap.get("gender");
			if (gender.equalsIgnoreCase("M")) {
				gender = "Male";
			} else if (gender.equalsIgnoreCase("F")) {
				gender = "Female";
			} else {
				gender = "Transgender";
			}
		}
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<authenticateStatus>" + ekycAuthenticateStatus + "</authenticateStatus>");
		sb.append("<gender>" + gender + "</gender>");
		sb.append("<ekycstreet>" + ekycstreet + "</ekycstreet>");
		sb.append("<postoffice>" + postoffice + "</postoffice>");
		sb.append("<Pincode>" + pincode + "</Pincode>");
		sb.append("<ekycstate>" + ekycstate + "</ekycstate>");
		sb.append("<ekycdistrict>" + ekycdistrict + "</ekycdistrict>");
		sb.append("<sub_district>" + subDistrict + "</sub_district>");
		sb.append("<Vtc>" + vtc + "</Vtc>");
		sb.append("<Locality>" + Locality + "</Locality>");
		sb.append("<Landmark>" + Landmark + "</Landmark>");
		sb.append("<house_no>" + houseNo + "</house_no>");
		sb.append("<care_of>" + careOfName + "</care_of>");
		sb.append("<ekycemail>" + ekycemail + "</ekycemail>");
		sb.append("<phone_no>" + phoneno + "</phone_no>");
		sb.append("<ekycdob>" + ekycdob + "</ekycdob>");
		sb.append("<resident_Name>" + residentName + "</resident_Name>");
		sb.append("<message>" + message + "</message>");
		sb.append("<aadharNo>" + aadharNo + "</aadharNo>");
		if (null != yearofBirth && null != yearofBirth[2]) {
			sb.append("<yearofBirth>" + yearofBirth[2] + "</yearofBirth>");
		} else {
			sb.append("<yearofBirth>" + "" + "</yearofBirth>");
		}
		if (null != ageAndUnit && null != ageAndUnit[0]) {
			sb.append("<unit>" + ageAndUnit[0] + "</unit>");
		} else {
			sb.append("<unit>" + "" + "</unit>");
		}
		if (null != ageAndUnit && null != ageAndUnit[1]) {
			sb.append("<age>" + ageAndUnit[1] + "</age>");
		} else {
			sb.append("<age>" + "" + "</age>");
		}

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		//
	}

	public ModelAndView showPrintTokenCardOp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showPrintTokenCardOp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "tokenCardOp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// added by arbind on 19-01-2017
	public ModelAndView getTokenCardOpList(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getTokenCardOpList ");
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String hinNo = box.get("uhid");
		int tokenNo = box.getInt("tokenNo");
		Boolean flag = registrationHandlerService.checkTokenExist(hinNo, tokenNo);
		map.put("flag", flag);
		String jsp = "responseForTokenCardOp";
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	/**
	 * Print Patient Token Number
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView printTokenCardOp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside printTokenCardOp ");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int hospitalId = 0;
		Date currentDate = new Date();

		HttpSession session = request.getSession();

		if (request.getParameter("uhid") != null) {
			String hinNo = request.getParameter("uhid");
			parameters.put("pHinNo", hinNo);
			LOGGER.debug("hinNo --> " + hinNo);
		}

		// added by amit das on 16-01-2017
		String tokenNo = request.getParameter("tokenNo");
		if (tokenNo != null && !tokenNo.trim().equals("")) {
			parameters.put("pTokenNo", Integer.parseInt(tokenNo));
			LOGGER.debug("tokenNo --> " + Integer.parseInt(tokenNo));
		}

		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameters.put("hospitalId", hospitalId);
		}
		parameters.put("currentDate", currentDate);

		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		parameters.put("currentDate", currentDate);

		map.put("Report_Path", request.getContextPath() + "/Reports/" + "Patient_Token_Card_Op" + ".pdf");
		HMSUtil.generateReportForDirectPrint("Patient_Token_Card_Op", parameters, (Connection) detailsMap.get("conn"),
				response, getServletContext(), getServletContext().getRealPath("/Reports/"));

		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}

		return new ModelAndView("printReports", "map", map);

	}

	/**
	 * populate patient visit details
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populatePatientCitizenDataAadhaar(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientCitizenDataAadhaar ");

		String aadhaarno = "";
		if (request.getParameter("aadhaarno") != null && !(request.getParameter("aadhaarno").equals(""))) {
			aadhaarno = request.getParameter("aadhaarno");
		}

		Map<String, Object> map = registrationHandlerService.populatePatientCitizenDataAadhaar(aadhaarno);

		List<PhMemberSurvey> memberList = (List<PhMemberSurvey>) map.get("memberList");

		int familySequenceId = 0;
		if (null != map.get("familySequenceId")) {
			familySequenceId = (Integer) map.get("familySequenceId");
		}

		List<PhHouseSurvey> houseList = new ArrayList<PhHouseSurvey>();
		if (null != map.get("houseList")) {
			houseList = (List<PhHouseSurvey>) map.get("houseList");
		}

		String patientName = "";
		String mobileNumber = "";
		int patientAge = 0;
		String nameOf = "";
		String relativeName = "";
		int occupation = 0;
		int education = 0;
		String pcategory = "";
		int patientGender = 0;
		String yearOfBirth = "";
		int pcategoryId = 0;
		long familyId = 0;
		int memberId = 0;
		int aadharDistrict = 0;
		String houseName = "";
		String streetName = "";
		String aadharNumber = "";
		int memberHospitalId = 0;
		boolean searchStatus = false;

		Date dob = null;

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		if (null != memberList && memberList.size() > 0) {
			for (PhMemberSurvey citizenList : memberList) {

				patientName = citizenList.getName();
				mobileNumber = citizenList.getContactNo();
				dob = citizenList.getDateOfBirth();
				if (null != dob) {
					patientAge = HMSUtil.calculateAgeByDOB(dob);
				}
				yearOfBirth = citizenList.getYearOfBirth();
				relativeName = citizenList.getPersonName();

				if (null != citizenList.getFamilyId()) {
					familyId = citizenList.getFamilyId();
				}
				if (null != citizenList.getId()) {
					memberId = citizenList.getId();
				}
				if (null != citizenList.getOccupation()) {
					occupation = citizenList.getOccupation().getId();
				}

				if (null != citizenList.getEducation()) {
					education = Integer.parseInt(citizenList.getEducation());
				}

				if (null != citizenList.getGender()) {
					patientGender = citizenList.getGender().getId();
				}
				if (null != citizenList.getAadhaarDistrict()) {
					aadharDistrict = citizenList.getAadhaarDistrict().getId();
				}
				if (null != citizenList.getHouseName()) {
					houseName = citizenList.getHouseName();
				}
				if (null != citizenList.getStreetName()) {
					streetName = citizenList.getStreetName();
				}
				if (null != citizenList.getAadhaarNo()) {
					aadharNumber = String.valueOf(citizenList.getAadhaarNo());
				}
				memberHospitalId = citizenList.getHospital().getId();
			}
			searchStatus = true;
		}

		int permanentDistrictId = 0;
		int permanentTalukId = 0;
		int permanentPostOfficeId = 0;
		int permanentPostCode = 0;
		String healthHouseId = null;
		String lsghouseNo = null;
		int wardId = 0;
		int localityId = 0;
		String localityName = null;

		if (null != houseList && houseList.size() > 0) {
			for (PhHouseSurvey houseServey : houseList) {
				permanentDistrictId = houseServey.getVillage().getTaluk().getDistrict().getId();
				permanentTalukId = houseServey.getVillage().getTaluk().getId();
				permanentPostOfficeId = houseServey.getPinCode().getId();
				permanentPostCode = houseServey.getPinCode().getPinCode();
				healthHouseId = houseServey.getHouseHoldId();
				lsghouseNo = houseServey.getLsgHouseNo();
				wardId = houseServey.getWard().getId();
				localityId = houseServey.getLocality().getId();
				localityName = houseServey.getLocality().getLocalityName();
			}

		}
		if (wardId > 0) {
			sb.append("<wardId>" + wardId + "</wardId>");
		}
		if (localityId > 0) {
			sb.append("<localityId>" + localityId + "</localityId>");
			sb.append("<localityName>" + localityName + "</localityName>");
		}

		if (null != lsghouseNo) {
			sb.append("<lsghouseNo>" + lsghouseNo + "</lsghouseNo>");
		}
		if (null != healthHouseId) {
			sb.append("<healthHouseId>" + healthHouseId + "</healthHouseId>");
		}
		if (permanentDistrictId > 0) {
			sb.append("<permanentDistrictId>" + permanentDistrictId + "</permanentDistrictId>");
		}
		if (permanentTalukId > 0) {
			sb.append("<permanentTalukId>" + permanentTalukId + "</permanentTalukId>");
		}
		if (permanentPostOfficeId > 0) {
			sb.append("<permanentPostOfficeId>" + permanentPostOfficeId + "</permanentPostOfficeId>");
		}
		if (permanentPostCode > 0) {
			sb.append("<permanentPostCode>" + permanentPostCode + "</permanentPostCode>");
		}

		if (patientName != null && !patientName.equals("")) {
			sb.append("<name>" + patientName + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}
		if (memberId > 0) {
			sb.append("<memberId>" + memberId + "</memberId>");
		} else {
			sb.append("<memberId>" + " " + "</memberId>");
		}
		if (familyId > 0) {
			sb.append("<familyId>" + familySequenceId + "</familyId>");
		} else {
			sb.append("<familyId>" + " " + "</familyId>");
		}

		if (mobileNumber != null && !mobileNumber.equals("")) {
			sb.append("<mobileNo>" + mobileNumber + "</mobileNo>");
		} else {
			sb.append("<mobileNo>" + " " + "</mobileNo>");
		}

		if (yearOfBirth != null && !yearOfBirth.equals("")) {
			sb.append("<yearOfBirth>" + yearOfBirth + "</yearOfBirth>");
		} else {
			sb.append("<yearOfBirth>" + " " + "</yearOfBirth>");
		}
		if (dob != null) {
			sb.append("<dob>" + HMSUtil.convertDateTypeToStringWithoutTime(dob) + "</dob>");
		} else {
			sb.append("<dob>" + " " + "</dob>");
		}

		sb.append("<age>" + patientAge + "</age>");
		if (nameOf != null && !nameOf.equals("")) {
			sb.append("<NameOf>" + nameOf + "</NameOf>");
		} else {
			sb.append("<NameOf>" + " " + "</NameOf>");
		}
		if (relativeName != null && !relativeName.equals("")) {
			sb.append("<RelativeName>" + relativeName + "</RelativeName>");
		} else {
			sb.append("<RelativeName>" + " " + "</RelativeName>");
		}
		if (occupation > 0) {
			sb.append("<Occupation>" + occupation + "</Occupation>");
		} else {
			sb.append("<Occupation>" + " " + "</Occupation>");
		}
		if (pcategory != null && !pcategory.equals("")) {
			sb.append("<Category>" + pcategory + "</Category>");
			sb.append("<CategoryId>" + pcategoryId + "</CategoryId>");
		} else {
			sb.append("<Category>" + " " + "</Category>");
		}
		if (patientGender > 0) {
			sb.append("<Gender>" + patientGender + "</Gender>");
		} else {
			sb.append("<Gender>" + " " + "</Gender>");
		}

		if (houseName != null && !houseName.equals("")) {
			sb.append("<houseName>" + houseName + "</houseName>");
		} else {
			sb.append("<houseName>" + " " + "</houseName>");
		}

		if (streetName != null && !streetName.equals("")) {
			sb.append("<streetName>" + streetName + "</streetName>");
		} else {
			sb.append("<streetName>" + " " + "</streetName>");
		}

		if (education > 0) {
			sb.append("<education>" + education + "</education>");
		} else {
			sb.append("<education>" + " " + "</education>");
		}

		if (aadharDistrict > 0) {
			sb.append("<aadharDistrict>" + aadharDistrict + "</aadharDistrict>");
		} else {
			sb.append("<aadharDistrict>" + " " + "</aadharDistrict>");
		}

		if (memberHospitalId > 0) {
			sb.append("<memberHospitalId>" + memberHospitalId + "</memberHospitalId>");
		} else {
			sb.append("<memberHospitalId>" + " " + "</memberHospitalId>");
		}
		if (null != aadharNumber && !aadharNumber.equals("")) {
			sb.append("<aadharNo>" + aadharNumber + "</aadharNo>");
		} else {
			sb.append("<aadharNo>" + " " + "</aadharNo>");
		}
		sb.append("<searchStatus>" + searchStatus + "</searchStatus>");

		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	@SuppressWarnings("unchecked")
	public void populatePPLocalityByWardLsg(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePPLocalityByWardLsg ");
		int wardId = 0, lsgId = 0;
		if (request.getParameter("wardId") != null && !request.getParameter("wardId").equals("")) {
			wardId = Integer.parseInt(request.getParameter("wardId"));
		}

		if (request.getParameter("lsgId") != null && !request.getParameter("lsgId").equals("")
				&& !request.getParameter("lsgId").equals(" ")) {
			lsgId = Integer.parseInt(request.getParameter("lsgId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("wardId", wardId);
		dataMap.put("lsgId", lsgId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePPLocalityByWardLsg(dataMap);
		List<PhMasLocality> localityList = (List<PhMasLocality>) detailsMap.get("localityList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (PhMasLocality ward : localityList) {
			sb.append("<item>");
			sb.append("<localName>" + ward.getLocalityName() + "</localName>");
			sb.append("<localId>" + ward.getId() + "</localId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * Method to reprint patient op card
	 * 
	 * @param request
	 * @param response
	 * @return Added by dhananjay kumar 13-feb-17
	 */
	public ModelAndView showRePrintOpTicketJsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showRePrintOpTicketJsp ");
		HttpSession session = request.getSession();

		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.showRePrintOpTicketJsp(box);

		String jsp = "rePrintOpTicketCard.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * Method to reprint patient op card
	 * 
	 * @param request
	 * @param response
	 * @return Added by dhananjay kumar 13-feb-17
	 */
	public ModelAndView rePrintOpTicketCard(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside rePrintOpTicketCard ");
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		String FromTime=null;
		String ToTime=null;
		String uhid = null;
		String Name=null;
		String MobileNo=null;
		int patientDept = 0;
		
		if(!StringUtils.isBlank(box.getString("FromTime")))
			FromTime = box.getString("FromTime");
		
		if(!StringUtils.isBlank(box.getString("ToTime")))
			ToTime = box.getString("ToTime");
		
		if(!StringUtils.isBlank(box.getString("uhid")))
			uhid = box.getString("uhid");
		
		if(!StringUtils.isBlank(box.getString("Name")))
			Name = box.getString("Name");
		
		if(!StringUtils.isBlank(box.getString("MobileNo")))
			MobileNo = box.getString("MobileNo");
		if(box.getInt(PATIENT_DEPARTMENT)!=0)
			patientDept = box.getInt(PATIENT_DEPARTMENT);
		
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.showRePrintOpTicketJsp(box);
        
		map.put("FromTime",FromTime );
		map.put("ToTime",ToTime);
		map.put("uhid", uhid);
		map.put("Name",Name);
		map.put("MobileNo",MobileNo);
		map.put(PATIENT_DEPARTMENT,patientDept);
		
		String jsp = "rePrintOpTicketCard.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * Print Patient Prescription Added by Arbind
	 */
	public ModelAndView reapetPrintPrescriptionCard(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside reapetPrintPrescriptionCard ");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		synchronized (this) {

			int pHinId = 0;
			int hospitalId = 0;
			HttpSession session = request.getSession();
			synchronized (session) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameters.put("hospitalId", hospitalId);

				if (request.getParameter("pHinId") != null) {
					pHinId = Integer.parseInt(request.getParameter("pHinId"));
					parameters.put("pHinId", pHinId);
				}

				String hospitalName = "";
				if (session.getAttribute("hospitalName") != null) {
					hospitalName = (String) session.getAttribute("hospitalName");
					parameters.put("hospitalName", hospitalName);
				}
				parameters.put("currentDate", new Date());
				LOGGER.debug("pHinId : " + pHinId);
				LOGGER.debug("hospitalId : " + hospitalId);
				detailsMap = registrationHandlerService.getConnectionForReport();

				LOGGER.debug("pATH : " + request.getContextPath() + "/uploadedImage/"
						+ "DuplicatePatient_Prescription_Card" + pHinId + "" + hospitalId + ".pdf");
				map.put("Report_Path", request.getContextPath() + "/uploadedImage/"
						+ "DuplicatePatient_Prescription_Card" + pHinId + "" + hospitalId + ".pdf");
				HMSUtil.generateReportForDirectPrintPatient("DuplicatePatient_Prescription_Card", parameters,
						(Connection) detailsMap.get("conn"), response, getServletContext(), getServletContext()
								.getRealPath("/uploadedImage/"), pHinId, hospitalId);
			}
			try {
				((Connection) detailsMap.get("conn")).close();
			} catch (SQLException sqlException) {
				LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
			}
			return new ModelAndView("printReports", "map", map);
		}
	}

	/**
	 * Method to reprint patient op card
	 * 
	 * @param request
	 * @param response
	 * @return Added by arbind 14-feb-17
	 */
	public ModelAndView showReferralPrintOpTicketJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showReferralPrintOpTicketJsp ");
		HttpSession session = request.getSession();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.showReferralPrintOpTicketJsp(box);

		String jsp = "referralPrintOpTicketCard.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * Method to reprint patient op card
	 * 
	 * @param request
	 * @param response
	 * @return Added by arbind 14-feb-17
	 */
	public ModelAndView referralPrintOpTicketCard(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside referralPrintOpTicketCard ");
		HttpSession session = request.getSession();

		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.showReferralPrintOpTicketJsp(box);

		String jsp = "referralPrintOpTicketCard.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);

	}

	/**
	 * Print Patient Prescription Added by Arbind
	 */
	public ModelAndView referralPrintPrescriptionCard(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside referralPrintPrescriptionCard ");

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		synchronized (this) {

			int pHinId = 0;
			int hospitalId = 0;
			HttpSession session = request.getSession();
			synchronized (session) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				parameters.put("hospitalId", hospitalId);

				if (request.getParameter("pHinId") != null) {
					pHinId = Integer.parseInt(request.getParameter("pHinId"));
					parameters.put("pHinId", pHinId);
				}

				String hospitalName = "";
				if (session.getAttribute("hospitalName") != null) {
					hospitalName = (String) session.getAttribute("hospitalName");
					parameters.put("hospitalName", hospitalName);
				}
				parameters.put("currentDate", new Date());

				LOGGER.debug("pHinId : " + pHinId);
				LOGGER.debug("hospitalId : " + hospitalId);
				detailsMap = registrationHandlerService.getConnectionForReport();

				map.put("Report_Path", request.getContextPath() + "/uploadedImage/"
						+ "Referral_Patient_Prescription_Card" + pHinId + "" + hospitalId + ".pdf");
				HMSUtil.generateReportForDirectPrintPatient("Referral_Patient_Prescription_Card", parameters,
						(Connection) detailsMap.get("conn"), response, getServletContext(), getServletContext()
								.getRealPath("/uploadedImage/"), pHinId, hospitalId);
			}
			try {
				((Connection) detailsMap.get("conn")).close();
			} catch (SQLException sqlException) {
				LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
			}
			return new ModelAndView("printReports", "map", map);
		}
	}

	// added by arbind on 16-02-2017
	@SuppressWarnings("unchecked")
	public void populatePPWardByLsg(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePPWardByLsg ");
		int lsgId = 0;
		if (request.getParameter("lsgId") != null && !request.getParameter("lsgId").equals("")
				&& !request.getParameter("lsgId").equals(" ")) {
			lsgId = Integer.parseInt(request.getParameter("lsgId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("lsgId", lsgId);
		Map<String, Object> detailsMap = registrationHandlerService.populatePPWardByLsg(dataMap);
		List<MasWard> wardList = (List<MasWard>) detailsMap.get("wardList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();

		for (MasWard ward : wardList) {
			sb.append("<item>");
			sb.append("<WardName>" + ward.getWardName() + "</WardName>");
			sb.append("<WardId>" + ward.getId() + "</WardId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	/**
	 * VerhoeffAlgorithm to check aaadhar no is valid or not
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void VerhoeffAlgorithm(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside VerhoeffAlgorithm ");
		StringBuffer sb = new StringBuffer();
		synchronized (response) {

			String aadharNo = "";
			if (request.getParameter("aadharno") != null && !request.getParameter("aadharno").equals("")) {
				aadharNo = request.getParameter("aadharno");

			}
			LOGGER.debug("aadharNo : " + aadharNo);
			boolean aadhaarValidationStatus = HMSUtil.VerhoeffAlgorithm(aadharNo);
			// ------------Response------------------
			sb.append("<item>");
			sb.append("<status>" + aadhaarValidationStatus + "</status>");
			sb.append("</item>");
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	// added by amit das on 20-03-2017
	public void submitTokenSerialInformationFromLean(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside submitTokenSerialInformationFromLean ");
		int hospitalId = 0;
		String result = null;

		if (request.getParameter("hospitalId") != null && !request.getParameter("hospitalId").trim().equals("")) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}

		String msgData = request.getParameter("message");
		Map<String, Object> map = registrationHandlerService.updateTokenNumber(msgData, hospitalId);

		if (map.get("success") != null) {
			result = "success";
		} else {
			result = "failure";
		}

		try {
			response.getWriter().write(result);
		} catch (IOException ioException) {
			LOGGER.error("Error while writing to outputstream" + ioException.getStackTrace().toString());
		}
	}

	/**
	 * To Open Online Appointment Page for other Hospital
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	// Add by dhananjay Kumar 04-May-17
	public ModelAndView showOtherHospitalOnlineAppointmentJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOtherHospitalOnlineAppointmentJsp ");
		int deptId = 0;
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		Map<String, Object> map = registrationHandlerService.populateOnlinePageOtherHospital(deptId, hospitalId);

		if (!box.getString("futureConsultFlag").equalsIgnoreCase("")) {
			String jsp = "otherHospitalOnlineAppointment.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		} else {
			String jsp = "otherHospitalOnlineAppointment.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
	}

	/**
	 * populate Taluk based on district drop down selected value
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public void populMasHospitalNameByType(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populMasHospitalNameByType ");
		int districtId = 0;
		int hospitalTypeId = 0;
		if (request.getParameter("districtId") != null && !request.getParameter("districtId").equals("0")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}

		if (request.getParameter("hospitalTypeId") != null && !request.getParameter("hospitalTypeId").equals("0")) {
			hospitalTypeId = Integer.parseInt(request.getParameter("hospitalTypeId"));
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();

		dataMap.put("districtId", districtId);
		dataMap.put("hospitalTypeId", hospitalTypeId);

		Map<String, Object> detailsMap = registrationHandlerService.populHospitalByDistrictIdHospitalTypeId(dataMap);
		List<MasHospital> masHospitalList = (List<MasHospital>) detailsMap.get("masHospitalList");
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		for (MasHospital masHospital : masHospitalList) {
			sb.append("<item>");
			sb.append("<HospitalName>" + masHospital.getHospitalName() + "</HospitalName>");
			sb.append("<HospitalId>" + masHospital.getId() + "</HospitalId>");
			sb.append("</item>");
		}
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public ModelAndView getServiceCenterByHospital(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside populMasHospitalNameByType ");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter("hospitalId") != null) {
			int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			detailsMap.put("hospitalId", hospitalId);
		}

		String jspParam = "";
		if (request.getParameter("jspParam") != null) {
			jspParam = request.getParameter("jspParam");
		}
		Map<String, Object> map = registrationHandlerService.getServiceCenterByHospital(detailsMap);
		String jsp = "department_div";
		String title = "DepartmentType";
		map.put("jspParam", jspParam);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSessionByHospital(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside getSessionByHospital ");
		int hospitalId = 0;
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getParameter("hospitalId") != null) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			detailsMap.put("hospitalId", hospitalId);
		}

		String jspParam = "";
		if (request.getParameter("jspParam") != null) {
			jspParam = request.getParameter("jspParam");
		}
		Map<String, Object> map = registrationHandlerService.getSessionByHospital(detailsMap);
		String jsp = "session_div";
		String title = "DepartmentType";
		map.put("jspParam", jspParam);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unchecked")
	public void getDoctorUnit(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
			ServletException {

		LOGGER.debug("Inside getDoctorUnit ");
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		String appointmentDate = request.getParameter("appointmentDate");
		int departmentId = Integer.parseInt(request.getParameter("departmentId"));
		map.put("departmentId", departmentId);
		map.put("hospitalId", hospitalId);
		map.put("appointmentDate", appointmentDate);
		map = registrationHandlerService.getDoctorUnit(map);
		List<HospitalDoctorUnitM> unitList = (List<HospitalDoctorUnitM>) map.get("unitList");
		List<String> list = new ArrayList<String>();
		for (HospitalDoctorUnitM unit : unitList) {
			list.add(unit.getId() + ":" + unit.getUnitCode());
		}

		PrintWriter out = response.getWriter();
		out.print(list);

	}

	public void isUnitExist(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
			ServletException {

		LOGGER.debug("Inside isUnitExist ");
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		String exist = registrationHandlerService.isUnitExist(hospitalId);
		PrintWriter out = response.getWriter();
		out.print(exist);

	}

	public void getUnitDoctors(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException, ServletException {

		LOGGER.debug("Inside getUnitDoctors ");
		String unitId = request.getParameter("unitId");
		String hospitalId = request.getParameter("hospitalId");
		List<HospitalDoctorUnitT> doctorList = registrationHandlerService.getUnitDoctors(unitId, hospitalId);
		List<String> list = new ArrayList<String>();
		for (HospitalDoctorUnitT doctor : doctorList) {
			list.add(doctor.getEmployee().getId() + ":" + doctor.getEmployee().getEmployeeName());
		}
		PrintWriter out = response.getWriter();
		out.print(list);
	}

	// To get Session based on Service Center
	public void getSessionForDepartment(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside getSessionForDepartment ");
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		List<String> masSessionList = registrationHandlerService.getSessionForDepartment(deptId, hospitalId);
		PrintWriter out = response.getWriter();
		out.print(masSessionList);
	}
	
	public void getEmployeeDepartment(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		LOGGER.debug("Inside populateVillage ");
		int deptId = 0;
		String empDeptCode = "";
		if (request.getParameter("deptId") != null && !request.getParameter("deptId").equals("0")
				&& !request.getParameter("deptId").equals("") && !request.getParameter("deptId").equals(" ")) {
			deptId = Integer.parseInt(request.getParameter("deptId"));

		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("deptId", deptId);
		map= registrationHandlerService.getEmployeeDepartment(dataMap);

		if(map.get("empDeptCode") != null){
			empDeptCode = (String)map.get("empDeptCode");
		}

		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<empDeptCode>" + empDeptCode + "</empDeptCode>");
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

	public void getServiceCentersList(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside getServiceCentersList ");
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String serviceCenterType = request.getParameter("serviceCenterType");
		List<String> serviceCenterList = registrationHandlerService
				.getServiceCentersList(hospitalId, serviceCenterType);
		PrintWriter out = response.getWriter();
		out.print(serviceCenterList);
	}

	// Added by Om Tripathi 27/07/2017

	/**
	 * Using this method open the advanced ticket page.
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView showRePrintAdvancedOpTicketJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showRePrintAdvancedOpTicketJsp ");
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		if (request.getParameter("fromDate") != null) {
			box.put("FromDate", request.getParameter("fromDate"));
		}
		if (request.getParameter("toDate") != null) {
			box.put("ToDate", request.getParameter("toDate"));
		}

		if (request.getParameter("FromTime") != null) {
			box.put("FromTime", request.getParameter("FromTime"));
			LOGGER.debug("FromTime : " + request.getParameter("FromTime"));
		}
		if (request.getParameter("ToTime") != null) {
			box.put("ToTime", request.getParameter("ToTime"));
			LOGGER.debug("ToTime : " + request.getParameter("ToTime"));
		}

		box.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.rePrintAdvanceOpTicket(box);
		String jsp = "rePrintAdvancedOpTicket.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * This method is used for searching advanced booked patient details.
	 * 
	 * @param request
	 * @param response
	 * @return Added By Om Triapthi 9/8/2017
	 */
	public ModelAndView rePrintAdvancedOpTicket(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside rePrintAdvancedOpTicket ");
		HttpSession session = request.getSession();

		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Box box = HMSUtil.getBox(request);
		if (request.getParameter("FromDate") != null) {
			String fromDate = request.getParameter("FromDate");
			box.put("FromDate", fromDate);
			LOGGER.debug("fromDate : " + fromDate);
		}
		if (request.getParameter("ToDate") != null) {
			String toDate = request.getParameter("ToDate");
			box.put("ToDate", toDate);
			LOGGER.debug("ToDate : " + toDate);
		}

		box.put("hospitalId", hospitalId);

		Map<String, Object> map = registrationHandlerService.rePrintAdvanceOpTicket(box);
		String jsp = "rePrintAdvancedOpTicket.jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	/**
	 * This method is used for printing the online advanced visit tokens
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView printAppointmentSlips(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside printAppointmentSlips ");
		Integer visitId = 0;
		String query = "";
		int hinId = 0;
		if (request.getParameter("pHinId") != null && !(request.getParameter("pHinId").equals(""))) {
			hinId = Integer.parseInt(request.getParameter("pHinId"));
		}

		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		}
		Map<String, Object> appointMap = new HashMap<String, Object>();
		appointMap.put("hinId", hinId);
		appointMap.put("hospitalId", hospitalId);
		Map<String, Object> map = registrationHandlerService.getAppointmentDetails(appointMap);
		if (map.get("appointmentNo") != null && !(map.get("appointmentNo").equals(""))) {
			String appointmentNo = (String) (map.get("appointmentNo"));
			query = "where app_patient_appointments.appointment_no = '" + appointmentNo + "'";
		}
		if (request.getParameter("visitId") != null && !(request.getParameter("visitId").equals(""))) {
			visitId = Integer.valueOf((request.getParameter("visitId")));
			query = "and visit.visit_id= '" + visitId + "'";
		}

		Map<String, Object> parameters = new HashMap<String, Object>();

		String hospitalName = registrationHandlerService.getHospitalName(hospitalId);
		parameters.put("hospitalName", hospitalName);
		parameters.put("QUERY", query);
		LOGGER.debug("query : " + query);
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		LOGGER.debug("hinId : " + hinId);
		map.put("Report_Path", request.getContextPath() + "/Reports/" + "app_slip_sameHospital_advanced" + hinId + ""
				+ hospitalId + ".pdf");
		HMSUtil.generateReportForDirectPrintPatient("app_slip_sameHospital_advanced", parameters,
				(Connection) detailsMap.get("conn"), response, getServletContext(),
				getServletContext().getRealPath("/Reports/"), hinId, hospitalId);
		return new ModelAndView("printReports", "map", map);

	}

	public ModelAndView showOnlineAdvancedAppointmentJsp(final HttpServletRequest request,
			final HttpServletResponse response) {

		LOGGER.debug("Inside showOnlineAdvancedAppointmentJsp ");
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		box.put("futureConsultFlag", "A");
		HttpSession session = request.getSession();
		if (request.getParameter(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter("department") != null) {
			deptId = Integer.parseInt(request.getParameter("department"));
		}

		LOGGER.debug("deptId : " + deptId + "hospitalId : " + hospitalId);
		synchronized (session) {
			hospitalId = (int) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}

		Map<String, Object> map = registrationHandlerService.populateOnlinePage(deptId, hospitalId);

		if (!box.getString("futureConsultFlag").equalsIgnoreCase("")) {
			String jsp = "onlineAppointment.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		} else {
			String jsp = "onlineAppointment.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

	}

	// added by amit das on 09-08-2017
	public void getUHID(final HttpServletRequest request, final HttpServletResponse response) throws IOException,
			ServletException {

		LOGGER.debug("Inside getUHID ");
		String hospitalCode = request.getParameter("hospitalCode");
		Map<String, Object> objectMap = new HashMap<String, Object>();
		objectMap.put("hospitalCode", hospitalCode);
		String hinNo = registrationHandlerService.generateUHIDForOtherPlatform(objectMap);
		PrintWriter out = response.getWriter();
		out.print(hinNo);
	}

	public ModelAndView showFitnessCertificatejsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showFitnessCertificatejsp ");
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "fitnessCertificateReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printFitnessCertificate(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside printFitnessCertificate ");
		Map<String, Object> parameters = new HashMap<String, Object>();
		String uhId = "";

		if (request.getParameter("hinNo") != null) {
			uhId = request.getParameter("hinNo");
		}

		Map<String, Object> map = registrationHandlerService.showHeightWeight(uhId);

		Double height = (Double) map.get("height");
		Double weight = (Double) map.get("weight");
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();
		if(height!=0)
		{
			parameters.put("height", height);
		}else
		{
			parameters.put("height",0.0);
		}
		if(weight!=0)
		{
		parameters.put("weight", weight);
		}
		else
		{
			parameters.put("weight",0.0);
		}
		parameters.put("uhId", uhId);

		String reportName = "medicalFitnessCertificate";
		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}

	public ModelAndView showDrivingCertificatejsp(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside showDrivingCertificatejsp ");
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "drivingCertificateReport.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView drivingFitnessCertificate(final HttpServletRequest request, final HttpServletResponse response) {

		LOGGER.debug("Inside drivingFitnessCertificate ");
		Map<String, Object> parameters = new HashMap<String, Object>();
		String uhId = "";
		String flag = "";

		if (request.getParameter("hinNo") != null) {
			uhId = request.getParameter("hinNo");
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}
		Map<String, Object> detailsMap = registrationHandlerService.getConnectionForReport();

		parameters.put("uhId", uhId);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

		String reportName = "";
		if (flag.equals("p")) {
			reportName = "Form1";
		}
		if (flag.equals("m")) {
			reportName = "Form1A";
		}
		if (flag.equals("v")) {
			reportName = "Visual_standards";
		}

		HMSUtil.generateReport(reportName, parameters, (Connection) detailsMap.get("conn"), response,
				getServletContext());
		try {
			((Connection) detailsMap.get("conn")).close();
		} catch (SQLException sqlException) {
			LOGGER.error("Error while closing the connection " + sqlException.getStackTrace().toString());
		}
		return null;
	}
	
	public ModelAndView showQuickRegistrationJsp(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside showQuickRegistrationJsp ");
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> map = registrationHandlerService.showQuickRegistrationJsp(deptId, hospitalId);
		String jsp = "quickRegistration.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getLocalityAutocomplete(final HttpServletRequest request, final HttpServletResponse response) {
		LOGGER.debug("Inside getLocalityAutocomplete ");
		Map<String, Object> map = new HashMap<String, Object>();
	
		String locality = request.getParameter("locality");
		
		map = registrationHandlerService.getLocalityAutocomplete(locality);

		return new ModelAndView("responseLocalityAutocomplete", "map", map);
	}
	
	
	@SuppressWarnings("unchecked")
	public void populatePatientVisitDetailShortScreen(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {

		LOGGER.debug("Inside populatePatientVisitDetail ");
		int deptId = 0;
		int hospitalId = 0;
		int lastVisitId = 0;
		int hinId = 0;
		String onlineRegStatus = "";

		if (request.getParameter("onlineRegStatus") != null && !(request.getParameter("onlineRegStatus").equals(""))) {
			onlineRegStatus = request.getParameter("onlineRegStatus");
		}

		if (request.getParameter("hinId") != null && !(request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		
		HttpSession session = request.getSession();
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("hospitalId", hospitalId);
		dataMap.put("hinId", hinId);
		
		Map<String, Object> map = registrationHandlerService.getPatientDetailsForShortScreen(dataMap);

		
		
		String patientUHinNo = "";
		String patientName = "";
		String mobileNumber = "";
		String patientAge = "";
		String pcategory = "";
		String patientGender = "";
		int patientHinNo = 0;
		String priority = "";
		BigDecimal income =null;
		int unitId = 0;
		String unitName = "";
		int doctorId = 0;
		String docName = "";
		int serviceCemterId = 0;
		// ------------Response------------------

		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<onlineRegStatus>" + onlineRegStatus + "</onlineRegStatus>");

	
		String splCategory = "";
		String scheme = "";
		
		List<Patient> patientList = (List<Patient>) map.get("patientDetailsList");
		for (Patient patient : patientList) {
			patientUHinNo = patient.getHinNo();
			patientHinNo = patient.getId();
			patientName = patient.getPFirstName();
			mobileNumber = patient.getMobileNumber();
			patientAge = patient.getAge();
			scheme = patient.getScheme()!=null? patient.getScheme().getSchemeName():"";
			String[] age = null;
			int age1 = 0;
			if (patientAge != null && !patientAge.equals("")) {
				age = patientAge.split(" ");
			}
			if (age != null && age.length > 0) {
				if(age[0]!=null && !"".equals(age[0])){
					age1 = Integer.parseInt(age[0]+"");	
				}else if(age[1]!=null && age[1]!=""){
					age1 = Integer.parseInt(age[1]+"");
				}
				
			}
			if (age1 >= 60) {
				priority = "1";
			} else {
				priority = "3";
			}
			
			if (null != patient.getBplStatus()) {
				if(patient.getBplStatus().equalsIgnoreCase("n"))
					pcategory = "APL";
				else if(patient.getBplStatus().equalsIgnoreCase("y"))
					pcategory = "BPL";
			}else{
				pcategory = "";
			}
			if (null != patient.getSex()) {
				patientGender = patient.getSex().getAdministrativeSexName();
			}
			if (null != patient.getMonthlyIncome()) {
				income = patient.getMonthlyIncome();
			}
			
			Set<PatientCategoryDetails> splCatSet = patient.getPatientCategoryDetails();
			if(splCatSet!=null){
				for(PatientCategoryDetails paCategoryDetails : splCatSet){
					splCategory = paCategoryDetails.getOtherCategory().getPatientTypeName();
				}
			}
			
			
			
		}

	

		sb.append("<priority>" + priority + "</priority>");
		sb.append("<Uhid>" + patientUHinNo + "</Uhid>");
		sb.append("<hinId>" + patientHinNo + "</hinId>");


		if (patientName != null && !patientName.equals("")) {
			sb.append("<name>" + patientName + "</name>");
		} else {
			sb.append("<name>" + " " + "</name>");
		}
		if (mobileNumber != null && !mobileNumber.equals("")) {
			sb.append("<mobileNo>" + mobileNumber + "</mobileNo>");
		} else {
			sb.append("<mobileNo>" + " " + "</mobileNo>");
		}

		if (pcategory != null && !pcategory.equals("")) {
			sb.append("<Category>" + pcategory + "</Category>");
		} else {
			sb.append("<Category>" + " " + "</Category>");
		}
		if (patientGender != null && !patientGender.equals("")) {
			sb.append("<Gender>" + patientGender + "</Gender>");
		} else {
			sb.append("<Gender>" + " " + "</Gender>");
		}
		List<OpdPatientDetails> opdPatientDetailsList = (List<OpdPatientDetails>) map.get("opdPatientDetailsList");

		if (opdPatientDetailsList.size() > 0) {
			for (OpdPatientDetails opdPatientDetail : opdPatientDetailsList) {
				HospitalDoctorUnitM unit = opdPatientDetail.getVisit().getUnit();
				if (null != unit) {
					unitId = unit.getId();
					unitName = unit.getUnitCode();
				}
				MasEmployee employee = opdPatientDetail.getEmployee();
				if (null != employee) {
					doctorId = employee.getId();
					docName = employee.getEmployeeName();
				}
				serviceCemterId = opdPatientDetail.getVisit().getDepartment().getId();
				LOGGER.debug("serviceCemterId : " + serviceCemterId);
				LOGGER.debug("opdPatientDetail.getVisit().getDepartment().getDepartmentName() : "
						+ opdPatientDetail.getVisit().getDepartment().getDepartmentName());
			}
			sb.append("<unitId>" + unitId + "</unitId>");
			sb.append("<unitName>" + unitName + "</unitName>");
			sb.append("<doctorId>" + doctorId + "</doctorId>");
			sb.append("<docName>" + docName + "</docName>");
			sb.append("<serviceCemterId>" + serviceCemterId + "</serviceCemterId>");
		}

		if (patientAge != null && !patientAge.equals("")) {
			sb.append("<age>" + patientAge + "</age>");
		} else {
			sb.append("<age>" + " " + "</age>");
		}
		if (income != null && !income.equals("")) {
			sb.append("<income>" + income + "</income>");
		} else {
			sb.append("<income>" + " " + "</income>");
		}
		if (splCategory != null && !splCategory.equals("")) {
			sb.append("<splCategory>" + splCategory + "</splCategory>");
		} else {
			sb.append("<splCategory>" + " " + "</splCategory>");
		}
		sb.append("<scheme>" + scheme + "</scheme>");
		
		List<PatientAddress> addressList = (List<PatientAddress>) map.get("addressList");
		for(PatientAddress add : addressList){
			if (add.getLocality() != null ) {
				sb.append("<locality>" + add.getLocality().getLocalityName() + "</locality>");
			} else {
				sb.append("<locality>" + " " + "</locality>");
			}
		}
		sb.append("<VisitNo>" +( map.get("visitNo")!=null?map.get("visitNo"):"") + "</VisitNo>");
		sb.append("</item>");

		LOGGER.debug("sb : " + sb.toString());
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");

		response.getWriter().close();
	}

	public ModelAndView showEditVisitDetails(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null){
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map.put("hospitalId", hospitalId);
		int deptId=0;
		if(request.getParameter("deptId")!=null){
			deptId=Integer.parseInt(request.getParameter("deptId"));
		}
		map.put("deptId", deptId);
		
		int docId=0;
		if(request.getParameter("docId")!=null){
			docId=Integer.parseInt(request.getParameter("docId"));
		}
		map.put("docId", docId);
		
		map=registrationHandlerService.showEditVisitDetails(map);
		
		String jsp = "editVisitDetails.jsp";
		String title = "Edit Visit Details";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
public void getDoctorsForDept(HttpServletRequest request,HttpServletResponse response) throws IOException{
	Map<String,Object> map=new HashMap<String,Object>();
	HttpSession session = request.getSession();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map.put("hospitalId", hospitalId);
	
	int deptId=0;
	if(request.getParameter("depatmentId")!=null){
		deptId=Integer.parseInt(request.getParameter("depatmentId"));
	}
	map.put("depatmentId", deptId);
	map=registrationHandlerService.getDoctorsForDept(map);
	List<String> doctors=new ArrayList<String>();
	if(map.get("DoctorsList")!=null){
		doctors=(List<String>)map.get("DoctorsList");
	}
	
	PrintWriter out=response.getWriter();
	out.print(doctors);
}

public ModelAndView submitEditVisitDetails(HttpServletRequest request,HttpServletResponse response){
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	String commonPool="";
	if(request.getParameter("commonPool")!=null){
		commonPool=request.getParameter("commonPool");
	}
	
	if (session.getAttribute("deptId") != null) {
		box.put("departmentId", (Integer) session.getAttribute("deptId"));
	}
	if(session.getAttribute("empId")!=null){
		box.put("userId", (Integer)session.getAttribute("empId"));
	}
	
	box.put("commonPool", commonPool);
	map=registrationHandlerService.submitEditVisitDetails(box);
	
	String jsp = "editVisitDetails.jsp";
	String title = "Edit Visit Details";

	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public void getLocalityId(final HttpServletRequest request, final HttpServletResponse response)
		throws IOException {

	LOGGER.debug("Inside getLocalityIds ");
	String localityName =  request.getParameter("localityName");

	List<Object[]> localityList = registrationHandlerService.getLocalityId(localityName);
	// ------------Response------------------

	StringBuffer sb = new StringBuffer();
	for (Object[] obj: localityList) {
		sb.append("<item>");
		sb.append("<localityId>" + obj[0] + "</localityId>");
		sb.append("<wardId>" + obj[1] + "</wardId>");
		sb.append("<districtId>" + obj[2] + "</districtId>");
		sb.append("</item>");
	}
	LOGGER.debug("sb : " + sb.toString());

	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
	response.getWriter().write("<items>");
	response.getWriter().write(sb.toString());
	response.getWriter().write("</items>");
}
//Added By OM Tripathi 18/02/2018
public ModelAndView patientVisitDetails(HttpServletRequest request,HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	HttpSession session = request.getSession();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map.put("hospitalId", hospitalId);
	int deptId=0;
	if(request.getParameter("deptId")!=null){
		deptId=Integer.parseInt(request.getParameter("deptId"));
	}
	int tokenNumber=0;
	if(request.getParameter("tokenNumber")!=null && !"".equals(request.getParameter("tokenNumber"))){
		tokenNumber=Integer.parseInt(request.getParameter("tokenNumber").trim());
	}
	map.put("deptId", deptId);
	map.put("tokenNumber",tokenNumber);
	int docId=0;
	if(request.getParameter("docId")!=null){
		docId=Integer.parseInt(request.getParameter("docId"));
	}
	map.put("docId", docId);
	
	map=registrationHandlerService.patientVisitDetails(map);
	
	String jsp = "patientVisitDetails.jsp";
	String title = "Patient Visit Details";
	
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
  }

public ModelAndView submitPatientVisitDetails(HttpServletRequest request,HttpServletResponse response){
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	String unrelease="";
	String commonPool="";
	if(request.getParameter("commonPool")!=null){
		commonPool=request.getParameter("commonPool");
	}
	if (session.getAttribute("deptId") != null) {
		box.put("departmentId", (Integer) session.getAttribute("deptId"));
	}
	if(session.getAttribute("empId")!=null){
		box.put("userId", (Integer)session.getAttribute("empId"));
	}
	if(request.getParameter("unrelease")!=null){
		unrelease=request.getParameter("unrelease");
	}
	box.put("unrelease", unrelease);
	box.put("commonPool", commonPool);
	
	map=registrationHandlerService.submitPatientVisitDetails(box);
	
	String jsp = "patientVisitDetails.jsp";
	String title = "Edit Released Patient visit Details";

	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public void checkForDoctorWaitingPatients(HttpServletRequest request,HttpServletResponse response) throws IOException{
	Map<String,Object> map=new HashMap<String,Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	int noOfPatients = 0;
	
	if(session.getAttribute(HOSPITAL_ID)!=null){
		box.put("hospitalId", (Integer) session.getAttribute(HOSPITAL_ID));
	}
	
	if (session.getAttribute("deptId") != null) {
		box.put("departmentId", (Integer) session.getAttribute("deptId"));
	}
	
	if (session.getAttribute("empId") != null) {
		box.put("employeeId", (Integer) session.getAttribute("empId"));
	}
	
	map		=	registrationHandlerService.checkForDoctorWaitingPatients(box);
	
	if(map.get("noOfPatients")!=null){
		noOfPatients=(Integer)map.get("noOfPatients");
	}
	
	PrintWriter out=response.getWriter();
	out.print(noOfPatients);
}
public ModelAndView showTransferPatientListJsp(HttpServletRequest request,HttpServletResponse response){
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map.put("hospitalId", hospitalId);
	int deptId=0;
	if(request.getParameter("deptId")!=null){
		deptId=Integer.parseInt(request.getParameter("deptId"));
	}
	map.put("deptId", deptId);
	
	int docId=0;
	if(request.getParameter("docId")!=null){
		docId=Integer.parseInt(request.getParameter("docId"));
	}
	map.put("docId", docId);
	
	map=registrationHandlerService.showTransferPatientListJsp(map);
	
	return new ModelAndView("transfer_patient_window","map",map);
}

public ModelAndView submitTransferPatients(HttpServletRequest request,HttpServletResponse response){
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	
	int hospitalId=0;
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		dataMap.put("hospitalId", hospitalId);
	}
	
	if (session.getAttribute("deptId") != null) {
		box.put("departmentId", (Integer) session.getAttribute("deptId"));
		dataMap.put("deptId", (Integer) session.getAttribute("deptId"));
	}
	if(session.getAttribute("empId")!=null){
		box.put("userId", (Integer)session.getAttribute("empId"));
		dataMap.put("docId", (Integer)session.getAttribute("empId"));
	}
	
	map=registrationHandlerService.submitTransferPatients(box);
	
	boolean succesMsg=false;
	if(map.get("success")!=null){
		succesMsg=(boolean) map.get("success");
	}
	map=registrationHandlerService.showTransferPatientListJsp(dataMap);
	
	map.put("success", succesMsg);
	
	return new ModelAndView("transfer_patient_window","map",map);
}

public ModelAndView showMeraApatalDataJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp="";
	HttpSession session = request.getSession();

	jsp = "meraAspatalData";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}


@SuppressWarnings("unused")
public ModelAndView generateMeraApatalData(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> parameters = new HashMap<String, Object>();
	Map<String, Object> requestParameters = new HashMap<String, Object>();

	HttpSession session = request.getSession();
	
	Date fromDate = null, toDate = null;
	int hospitalId = 0;
	String hospitalName ="", query="";
	
	try {
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			requestParameters.put("hospitalId", hospitalId);
		}
//		System.out.println("query  --> " + query);
		requestParameters.put("query", query);
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
	
		Map<String, Object> connectionMap = registrationHandlerService.getConnectionForReport();
		HMSUtil.generateReportExl("meraAspatalDataExcel", requestParameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
}

	public ModelAndView releasedPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map.put("hospitalId", hospitalId);
		int deptId = 0;
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		int tokenNumber = 0;
		if (request.getParameter("tokenNumber") != null
				&& !"".equals(request.getParameter("tokenNumber"))) {
			tokenNumber = Integer.parseInt(request.getParameter("tokenNumber")
					.trim());
		}
		map.put("deptId", deptId);
		map.put("tokenNumber", tokenNumber);
		int docId = 0;
		if (request.getParameter("docId") != null) {
			docId = Integer.parseInt(request.getParameter("docId"));
		}
		map.put("docId", docId);

		map = registrationHandlerService.releasedPatientDetails(map);

		String jsp = "releasedPatientDetails.jsp";
		String title = "Patient Visit Details";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public void getAssignedPatientForDoctorSpecific(final HttpServletRequest request, final HttpServletResponse response)
			throws IOException {
		LOGGER.debug("Inside getAssignedPatientForDoctorSpecific ");
		int docId = 0;
		if (request.getParameter("docId") != null && !(request.getParameter("docId").equals(""))) {
			docId = Integer.parseInt(request.getParameter("docId"));
		}
		String patientsCount="";
		Map<String, Object> map = registrationHandlerService.getAssignedPatientForDoctorSpecific(docId);
		if(map.get("patientsCountForDr") != null){
			patientsCount = (String)map.get("patientsCountForDr").toString();
		}
		
		String patientsCount1="";
		Map<String, Object> map1 = registrationHandlerService.getAssignedPatientForDoctorSpecific(docId);
		if(map1.get("patientsCountForDr") != null){
			patientsCount = (String)map1.get("patientsCountForDr").toString();
		}
		
		// ------------Response------------------
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<patientsCount>" + patientsCount + "</patientsCount>");
		sb.append("<patientsCount1>" + patientsCount1 + "</patientsCount1>");
		sb.append("</item>");
		LOGGER.debug("sb : " + sb.toString());

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
	}

}


// controller class is completed