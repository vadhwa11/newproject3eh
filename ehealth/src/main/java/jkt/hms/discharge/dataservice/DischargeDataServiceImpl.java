/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms
 * Class DischargeDataServiceImpl.java
 * To feed discharge summary details
 * Tables Used: discharge_items, discharge_items_category, discharge_summary, discharge_icd_code, mas_icd
 * @author  Create Date: 11.02.2008 Name: Othivadivel K R
 * Revision Date:      		Revision By:
 * @version 1.0
 * @see DischargeController.java, DischargeHandlerService.java, DischargeHandlerServiceImpl.java, DischargeDataService.java
 **/

package jkt.hms.discharge.dataservice;

import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.INPATIENT_ID;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.USER_ID;

import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.DischargeItemsCategory;
import jkt.hms.masters.business.DischargeSummary;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientPrescriptionDetails;
import jkt.hms.masters.business.IpdIntakeOutputChart;
import jkt.hms.masters.business.IpdTemperature;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtPostAnaesthesiaProcedure;
import jkt.hms.masters.business.OtSurgeyPaSurgeyDetail;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientPrescriptionDetails;
import jkt.hms.masters.business.Transfer;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.renderers.JFreeChartRenderer;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class DischargeDataServiceImpl extends HibernateDaoSupport implements
		DischargeDataService {

	@SuppressWarnings("unchecked")
	/*
	 * public Map<String, Object> getDischargePatientDetails(int inPatient) {
	 * List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	 * Map<String ,Object> map= new HashMap<String, Object>(); Session session =
	 * (Session) getSession(); try {
	 * org.springframework.orm.hibernate3.HibernateTemplate hbt =
	 * getHibernateTemplate(); hbt.setFlushModeName("FLUSH_EAGER");
	 * hbt.setCheckWriteOperations(false); inPatientDetailList =
	 * session.createCriteria(Inpatient.class).add(Restrictions.eq("Id",
	 * inPatient)).list(); } catch (HibernateException e) { e.printStackTrace();
	 * } map.put("inPatientDetailList", inPatientDetailList); return map; }
	 */
	public Map<String, Object> getDischargePatientDetails(Map<String, Object> dataMap) {
		List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		String admitingIcd="";
		List<OtBooking> otBookingList = new ArrayList<OtBooking>();
		List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
		DischargeSummary dischargeSummaryObj = new DischargeSummary();
		Inpatient inPatientObj = new Inpatient();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		String admn_no = null;
		int inPatient=(Integer)dataMap.get("inPatient");
		int hospitalId=(Integer)dataMap.get(HOSPITAL_ID);
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			
			inPatientDetailList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("Id", inPatient))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			
			
			
			
			otBookingList = session.createCriteria(OtBooking.class)
					.add(Restrictions.eq("Inpatient.Id", inPatient))
					.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
			if (inPatientDetailList != null && inPatientDetailList.size() > 0) {
				inPatientObj = inPatientDetailList.get(0);
				admn_no = inPatientObj.getAdNo();
				dischargeSummaryList = session
						.createCriteria(DischargeSummary.class, "inp")
						.add(Restrictions.eq("inp.AdNo", admn_no))
						.add(Restrictions.eq("Hospital.Id", hospitalId)).list();
				// dischargeSummaryList = hbt
				// .find("from jkt.hms.masters.business.DischargeSummary as inp where inp.AdNo = '"
				// + admn_no + "'");
				if (dischargeSummaryList != null
						&& dischargeSummaryList.size() > 0) {
					dischargeSummaryObj = dischargeSummaryList.get(0);
					String category_name = dischargeSummaryObj.getItemCode()
							.getCategoryName();
					map.put("category_name", category_name);
				}
			}
		}

		catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("otBookingList", otBookingList);
		map.put("inPatientDetailList", inPatientDetailList);
		map.put("admitingIcd",admitingIcd);
		return map;
	}

	public Map<String, Object> getAdmissionNumberList(Map requestParameters) {
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean hinNoFound = false;
		String hinNo = "";
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (requestParameters.get(HIN_NO) != null) {
				hinNo = (String) requestParameters.get(HIN_NO).toString()
						.trim();
			}
			// int hospital_id = (Integer)requestParameters.get(HOSPITAL_ID);
			// hospitalList =
			// session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",
			// hospital_id)).list();

			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo)).list();
			map.put("inpatientList", inpatientList);
			if (inpatientList != null && inpatientList.size() > 0) {
				hinNoFound = true;
			}
			/*
			 * Set<Patient> patientSet = null; Set admissionNumbersSet = new
			 * TreeSet(); if (hospitalList != null && hospitalList.size() > 0)
			 * patientSet = (Set)hospitalList.get(0).getPatients();
			 * 
			 * for (Iterator iter = patientSet.iterator(); iter.hasNext();) {
			 * Patient patient = (Patient) iter.next();
			 * 
			 * if (requestParameters.get(SERVICE_NO)!=null &&
			 * requestParameters.get
			 * (SERVICE_NO).toString().trim().equalsIgnoreCase
			 * (patient.getServiceNo())) { hinNoFound = true; Set<Inpatient>
			 * inpatientSet = (Set)patient.getInpatients();
			 * map.put("inpatientSet", inpatientSet);
			 * 
			 * //Join using HQL
			 * 
			 * Query q = session.createQuery("from
			 * jkt.hms.masters.business.DischargeSummary a join a.ItemCode b
			 * where a.Hin.HinNo='"+ requestParameters.get(HIN_NO).toString()
			 * +"'"); Iterator pairs = q.list().iterator(); DischargeSummary a =
			 * null; DischargeItemsCategory b = null; while ( pairs.hasNext() )
			 * { Object[] pair = (Object[]) pairs.next(); a = (DischargeSummary)
			 * pair[0]; b = (DischargeItemsCategory) pair[1];
			 * a.getItemCode().getCategoryName());
			 * admissionNumbersSet.add(a.getAdNo());
			 * map.put(a.getAdNo(),a.getItemCode().getCategoryName()); }
			 * map.put("admissionNumbersSet", admissionNumbersSet); } }
			 */} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("inpatientSet", inpatientList);
		map.put("hinNoFound", hinNoFound);
		return map;
	}

	/*
	 * This method is used to get the input fields dynamically from the database
	 * depends upon the department(General, Obestetrics and Gynaecology &
	 * Pediatrics) which is selected by the User.
	 * 
	 * Phase I: (Implemented)
	 * 
	 * Diagnosis Details (ie.ICD Code and Name) of the concerned patient should
	 * be available to the Input Screen at the time of Entry. This Diagnosis
	 * Detail is retrieved using the tables discharge_icd_code and mas_icd.
	 * 
	 * 
	 * 
	 * Phase II: (To be implemented at a Later Stage)
	 * 
	 * Investigation Details should also be available to the Input Screen at the
	 * time of Data Entry. Investigation Details can be retrieved from the
	 * concerned tables.
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeFields(Map requestParameters) {
		Session session = (Session) getSession();
		List<DischargeItemsCategory> dischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Map<String, Object> map = new HashMap<String, Object>();
		boolean isRecordAlreadyExists = false;
		String casetype = (String) requestParameters.get("casetype");
		String type="";
		if(requestParameters.get("type")!=null){
			type=(String)requestParameters.get("type");
		}
		String admitingIcd="";
		String admissionNumber = (String) requestParameters
				.get(ADMISSION_NUMBER);
		int hospitalid = (Integer) requestParameters
				.get(RequestConstants.HOSPITAL_ID);
		String discharge_item_code = "";
		String reply = "";
		StringBuffer icd_code_and_name = new StringBuffer();
		int inpatientId = Integer.parseInt(requestParameters.get(INPATIENT_ID)
				.toString());
		int hinId = Integer.parseInt(requestParameters.get(HIN_ID).toString());
		List<BlDispensingDetails> blDispensingDetailsList = new ArrayList<BlDispensingDetails>();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (casetype != null) {
				dischargeItemsCategoryList = session
						.createCriteria(DischargeItemsCategory.class, "inp")
						.add(Restrictions.eq("inp.CategoryName", casetype))
						.add(Restrictions.eq("inp.Status", "y").ignoreCase())
						.addOrder(Order.asc("inp.Orderno")).list();
				// dischargeItemsCategoryList = hbt
				// .find("from jkt.hms.masters.business.DischargeItemsCategory as inp where inp.CategoryName ='"
				// + casetype + "' order by inp.Orderno");
			}
			
			String query="   select t1.icd_code,t1.icd_name,t1.snomed_concept_id,t2.term from  "+
					"	discharge_icd_code dic left outer join  mas_icd t1 on t1.icd_id=dic.icd_id "+
					"   left outer join sct2_description t2 on t1.snomed_concept_id = t2.conceptId "+
					"   where dic.inpatient_id="+inpatientId+" limit 1";
								
								List<Object[]>aList=new ArrayList<Object[]>();
								aList=session.createSQLQuery(query).list();
								for(Object[] obj:aList){
									admitingIcd="Icd :  "+obj[1]+"("+obj[0]+")-- Snomed :"+obj[3];
								}
								map.put("admitingIcd", admitingIcd);
			
			
			if (admissionNumber != null) {
				dischargeSummaryList = session
						.createCriteria(DischargeSummary.class, "inp")
						.add(Restrictions.eq("inp.AdNo", admissionNumber.trim()))
						.add(Restrictions.eq("inp.Hospital.Id", hospitalid))
						.list();
				// dischargeSummaryList = hbt
				// .find("from jkt.hms.masters.business.DischargeSummary as inp where inp.AdNo = '"
				// + admissionNumber.trim() + "'");
			}
			inpatientList = session.createCriteria(Inpatient.class, "inp")
					.add(Restrictions.eq("inp.Id", inpatientId)).list();
			// inpatientList = hbt
			// .find("from jkt.hms.masters.business.Inpatient as inp where inp.Id = "
			// + inpatientId);
			blDispensingDetailsList = session
					.createCriteria(BlDispensingDetails.class, "bldetails")
					.createAlias("bldetails.DispensingHeader", "header")
					.createAlias("bldetails.Item", "item")
					.add(Restrictions.eq("header.Hin.Id", hinId))
					.add(Restrictions.eq("header.Inpatient.Id", inpatientId))
					.add(Restrictions.eq("header.Hospital.Id", hospitalid))
					.list();
			// blDispensingDetailsList = hbt
			// .find("from  jkt.hms.masters.business.BlDispensingDetails as bldetails join bldetails.DispensingHeader as header join bldetails.Item as item where header.Hin.Id="
			// + hinId
			// + " and header.Inpatient.Id ="
			// + inpatientId);
			if (blDispensingDetailsList.size() > 0) {
				map.put("blDispensingDetailsList", blDispensingDetailsList);

			}
			if (dischargeSummaryList.size() > 0) {
				isRecordAlreadyExists = true;
			}

			if (inpatientList != null && inpatientList.size() > 0) {
				dischargeIcdCodeSet = inpatientList.get(0)
						.getDischargeIcdCodes();

				for (Iterator iter = dischargeIcdCodeSet.iterator(); iter
						.hasNext();) {
					DischargeIcdCode dischargeIcdCode = (DischargeIcdCode) iter
							.next();
					if (dischargeIcdCode.getDiagnosisStatus().equalsIgnoreCase(
							"f")) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(dischargeIcdCode
										.getIcd().getIcdCode());
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(dischargeIcdCode
										.getIcd().getIcdCode());
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}

						try {
							icd_code_and_name.append(dischargeIcdCode.getIcd()
									.getIcdName());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				map.put("DIAG", icd_code_and_name.toString());
				// dischargeIcdCodeSet Iterator for loop ends here

				// ------------- Getting Investigation
				// Details----------------------

				StringBuffer investigationName = new StringBuffer();

				/*List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
				resultList = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientList.get(0)
								.getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalid))
						.createAlias("Investigation", "inv")
						.addOrder(Order.desc(("ResultDate")))
						.addOrder(Order.asc(("inv.Id"))).list();*/

				//int j = 1;
				/*for (DgResultEntryHeader resultHd : resultList) {
					Set<DgResultEntryDetail> resultDt = new HashSet<DgResultEntryDetail>();
					Set<DgResultEntryDetailSen> resultSenDt = new HashSet<DgResultEntryDetailSen>();
					if (resultHd.getDgResultEntryDetails() != null) {
						resultDt = resultHd.getDgResultEntryDetails();
					}
					if (resultHd.getDgResultEntryDetailSens() != null) {
						resultSenDt = resultHd.getDgResultEntryDetailSens();
					}

					if (resultDt.size() > 0) {
						for (DgResultEntryDetail dgResultEntryDetail : resultDt) {
							if (dgResultEntryDetail.getInvestigation()
									.getAppearInDischargeSummary() != null
									&& !dgResultEntryDetail.getInvestigation()
											.getAppearInDischargeSummary()
											.equals("n")
									&& dgResultEntryDetail.getResult() != null
									&& !dgResultEntryDetail.getResult().equals(
											"-")
									&& !dgResultEntryDetail.getResult().equals(
											"")
									&& !dgResultEntryDetail.getResult().equals(
											"null")) {
								// Commented by Mohit
								// if(dgResultEntryDetail.getResultForDischargeSummary()
								// != null)
								// {
								if (investigationName.length() > 0) {
									investigationName.append(" , ");
									investigationName.append("\n");
									// investigationName.append(" , ");
								}
								investigationName.append(j + ". ");
								investigationName
										.append(HMSUtil
												.convertDateToStringWithoutTime(dgResultEntryDetail
														.getResultEntry()
														.getResultDate()));
								investigationName.append(" - ");
								investigationName.append(dgResultEntryDetail
										.getInvestigation()
										.getInvestigationName());
								investigationName.append(" - ");
								if (dgResultEntryDetail.getResultType().equals(
										"m")) {
									if (dgResultEntryDetail
											.getSubInvestigation() != null) {
										investigationName
												.append(dgResultEntryDetail
														.getSubInvestigation()
														.getSubInvestigationName());
										investigationName.append(" - ");
									}
								}

								if (!dgResultEntryDetail.getResultType()
										.equals("t")) {
									investigationName
											.append(dgResultEntryDetail
													.getResult());
								}
								// Commented by Mohit
								
								 * else {
								 * investigationName.append(dgResultEntryDetail
								 * .getResultForDischargeSummary()); }
								 
								investigationName.append(" ");

								if (dgResultEntryDetail.getUom() != null) {
									investigationName
											.append(dgResultEntryDetail
													.getUom().getUomName());
								}

								j++;
							}
							// }
						}
					}

					if (resultSenDt.size() > 0) {
						for (DgResultEntryDetailSen dgResultEntryDetailSen : resultSenDt) {
							if (dgResultEntryDetailSen.getInvestigation()
									.getAppearInDischargeSummary() != null
									&& !dgResultEntryDetailSen
											.getInvestigation()
											.getAppearInDischargeSummary()
											.equals("n")
									&& dgResultEntryDetailSen.getResult() != null
									&& dgResultEntryDetailSen.getResult()
											.equals("")
									&& dgResultEntryDetailSen.getResult()
											.equals("null")) {
								if (dgResultEntryDetailSen.getResult() != null) {
									// investigationName.append("<div class='clear'></div><label>&nbsp;&nbsp;"+i+".</label><label class='valueAuto'>");
									if (investigationName.length() > 0) {
										investigationName.append(" , ");
									}
									investigationName.append(j + ". ");
									investigationName
											.append(HMSUtil
													.convertDateToStringWithoutTime(dgResultEntryDetailSen
															.getResultEntry()
															.getResultDate()));
									investigationName.append(" - ");
									investigationName
											.append(dgResultEntryDetailSen
													.getInvestigation()
													.getInvestigationName());
									investigationName.append(" - ");

									investigationName
											.append(dgResultEntryDetailSen
													.getResult());
									investigationName.append("\n");
									j++;
								}
							}
						}
					}
					map.put("INVS", investigationName.toString());
				}*/
				// ------------------------------- End Of Investigation
				// details--------------------

				// ---------------------- Getting Operation
				// Details-----------------------

				StringBuffer anesthesiaName = new StringBuffer();
				StringBuffer operationNames = new StringBuffer();
				List<OtPostAnaesthesiaProcedure> postAnestDetailsList = new ArrayList<OtPostAnaesthesiaProcedure>();
				postAnestDetailsList = session
						.createCriteria(OtPostAnaesthesiaProcedure.class)
						.createAlias("Booking", "ob")
						.createAlias("ob.Inpatient", "ip")
						.add(Restrictions.eq("ip.Id", inpatientList.get(0)
								.getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalid)).list();
				if (postAnestDetailsList.size() > 0) {
					for (OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure : postAnestDetailsList) {
						if (otPostAnaesthesiaProcedure.getAnesthesia() != null) {
							if (anesthesiaName.length() > 0) {
								anesthesiaName = anesthesiaName.append(" , ");
							}
							anesthesiaName = anesthesiaName
									.append(otPostAnaesthesiaProcedure
											.getAnesthesia()
											.getAnesthesiaName());
						}
						Set<OtSurgeyPaSurgeyDetail> surgerySet = new HashSet<OtSurgeyPaSurgeyDetail>();
						if (otPostAnaesthesiaProcedure
								.getOtSurgeyPaSurgeyDetails() != null) {
							surgerySet = otPostAnaesthesiaProcedure
									.getOtSurgeyPaSurgeyDetails();
							if (surgerySet.size() > 0) {
								for (OtSurgeyPaSurgeyDetail otSurgeyPaSurgeyDetail : surgerySet) {
									if (otSurgeyPaSurgeyDetail.getChargeCode() != null) {
										if (operationNames.length() > 0) {
											operationNames = operationNames
													.append(" , ");
										}
										operationNames = operationNames
												.append(otSurgeyPaSurgeyDetail
														.getChargeCode()
														.getChargeCodeName());
									}
								}
							}
						}

					}
					map.put("ANES", anesthesiaName.toString());
					map.put("OPER", operationNames.toString());

				}

				// -------------------- End Of Operation
				// Details-------------------------

				// ---------------------------- Getting Patient
				// History-----------------------

				List<OpdPatientHistory> historyList = new ArrayList<OpdPatientHistory>();
				historyList = session
						.createCriteria(OpdPatientHistory.class)
						.createAlias("Hin", "hin")
						.add(Restrictions.eq("hin.Id", inpatientList.get(0)
								.getHin().getId()))
						.add(Restrictions.eq("Hospital.Id", hospitalid)).list();
				StringBuffer history = new StringBuffer("");
				/*
				 * if(historyList.size() > 0){ OpdPatientHistory patientHistory
				 * = (OpdPatientHistory)historyList.get(0);
				 * if(patientHistory.getPersonalPastHistory() != null &&
				 * !patientHistory.getPersonalPastHistory().equals(" ")){
				 * history
				 * .append("Past History : "+patientHistory.getPersonalPastHistory
				 * ()+" \n"); } if(patientHistory.getPersonalPresentHistory() !=
				 * null &&
				 * !patientHistory.getPersonalPresentHistory().equals(" ")){
				 * history.append("Present History : "+patientHistory.
				 * getPersonalPresentHistory()+" \n"); }
				 * if(patientHistory.getFamilyPresentHistory() != null &&
				 * !patientHistory.getFamilyPresentHistory().equals(" ")){
				 * history.append("Family History : "+patientHistory.
				 * getFamilyPresentHistory()+" \n"); }
				 * 
				 * map.put("HIST", history.toString()); }
				 */

				// -----------------------------------------------------------------
				for (int i = 0; i < dischargeSummaryList.size(); i++) {
					String code = dischargeSummaryList.get(i).getItemCode()
							.getId().toString();
					try {
						discharge_item_code = dischargeSummaryList.get(i)
								.getItemCode().getItemCode().getItemCode();
					} catch (Exception e) {
						discharge_item_code = "";
					}

					if (discharge_item_code.equalsIgnoreCase("DIAG")) {
						// reply = icd_code_and_name.toString();
						reply = dischargeSummaryList.get(i).getItemReply();
						map.put(discharge_item_code, reply);
					}

					else {
						reply = dischargeSummaryList.get(i).getItemReply();
					}
					if (discharge_item_code.equalsIgnoreCase("PRES")) {
						reply = dischargeSummaryList.get(i).getItemReply();
					}

					if (discharge_item_code.equalsIgnoreCase("DOCT")) {
						reply = dischargeSummaryList.get(i).getItemReply();
					}
					if (discharge_item_code.equalsIgnoreCase("NURS")) {
						reply = dischargeSummaryList.get(i).getItemReply();
					}
					if (discharge_item_code.equalsIgnoreCase("HIST")) {
						reply = dischargeSummaryList.get(i).getItemReply();
					}

					map.put(code, reply);
				} // dischargeSummaryList for loop ends here
				map.put("isRecordAlreadyExists", isRecordAlreadyExists);
				
				//Added by Arbind on 30-03-2017 for Advice medicine on discharge
				List<PatientPrescriptionDetails> adviceList = new ArrayList<PatientPrescriptionDetails>();
				adviceList = session.createCriteria(PatientPrescriptionDetails.class)
						.createAlias("Prescription", "p")
						.add(Restrictions.eq("p.Inpatient.Id", inpatientList.get(0).getId()))
						.add(Restrictions.eq("p.DischargeMedicationStatus", 'Y').ignoreCase())
						.add(Restrictions.eq("p.Hospital.Id", hospitalid))
						.list();
				String advices = "";
				if(adviceList != null && adviceList.size() > 0) {
					PatientPrescriptionDetails advice = new PatientPrescriptionDetails();
					for(int i = 0; i < adviceList.size(); i++) {
						advice = adviceList.get(i);
						advices += advice.getItem().getNomenclature() + " ";
						advices += advice.getFrequency().getFrequencyName() + " X ";
						advices += advice.getNoOfDays() + ", ";
					}
				}
				map.put("advices", advices);
				System.out.println("advices  "+advices);
			}
		} // main try block ends here
		catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dischargeItemsCategoryList", dischargeItemsCategoryList);

		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public Map<String, Object> addDischargeSummary(Map requestDataMap) {
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DischargeItemsCategory> dischargeItemsCategoryList = new ArrayList<DischargeItemsCategory>();
		List<MasDepartment> deptList = new ArrayList<MasDepartment>();
		// DischargeSummary dischargeSummary = null;

		String casetype = null;
		String ad_no = null;
		int hin_id = 0;
		int hospital_id = 0;
		int userId=0;
		String message = null;
		//String last_chg_by = null;
		String date = null;
		String time = null;

		try {
			casetype = (String) requestDataMap.get("casetype");
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			dischargeItemsCategoryList = session
					.createCriteria(DischargeItemsCategory.class, "inp")
					.add(Restrictions.eq("inp.CategoryName", casetype))
					.add(Restrictions.eq("inp.Status", "y").ignoreCase())
					.addOrder(Order.asc("inp.Orderno")).list();
			// dischargeItemsCategoryList = hbt
			// .find("from jkt.hms.masters.business.DischargeItemsCategory as inp where inp.CategoryName ='"
			// + casetype + "' order by inp.Orderno");
			if (requestDataMap.get("admissionNumber") != null
					&& !requestDataMap.get("admissionNumber").equals("")) {
				ad_no = requestDataMap.get("admissionNumber").toString();
			}
			if (requestDataMap.get("hinId") != null
					&& !requestDataMap.get("hinId").equals("")) {
				hin_id = Integer.parseInt(requestDataMap.get("hinId")
						.toString());
			}
			hospital_id = Integer.parseInt(requestDataMap.get(HOSPITAL_ID)
					.toString());
			userId=(Integer)requestDataMap.get(USER_ID);
			//last_chg_by = requestDataMap.get("changed_by").toString();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			date = (String) utilMap.get("currentDate");
			Date dateToInsert = HMSUtil.convertStringTypeDateToDateType(date);

			boolean isRecordAlreadyExists = Boolean.parseBoolean(requestDataMap
					.get("isRecordAlreadyExists").toString());

			if (isRecordAlreadyExists) {
				String hql = "delete from jkt.hms.masters.business.DischargeSummary as a where a.AdNo like :adNo and a.Hospital.id=:hospitalid";
				Query query = session
						.createQuery(hql)
						.setParameter("adNo",
								requestDataMap.get("admissionNumber"))
						.setParameter("hospitalid", hospital_id);
				int row = query.executeUpdate();

			}
			List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
			dischargeSummaryList = session
					.createCriteria(DischargeSummary.class)
					.add(Restrictions.eq("Hin.Id", hin_id))
					.add(Restrictions.eq("AdNo", ad_no)).list();
			if (dischargeSummaryList.size() == 0) {
				for (int i = 0; i < dischargeItemsCategoryList.size(); i++) {
					DischargeSummary dischargeSummary = new DischargeSummary();
					Patient patient = new Patient();
					patient.setId(new Integer(hin_id));

					DischargeItemsCategory dischargeItemsCategory = new DischargeItemsCategory();
					dischargeItemsCategory.setId(dischargeItemsCategoryList
							.get(i).getId());
					MasHospital masHospital = new MasHospital();
					masHospital.setId(new Integer(hospital_id));

					dischargeSummary.setAdNo(ad_no);
					dischargeSummary.setHin(patient);
					dischargeSummary.setItemCode(dischargeItemsCategory);
					dischargeSummary.setLabel(dischargeItemsCategoryList.get(i)
							.getLabel());

					String item_reply_code = Integer
							.toString(dischargeItemsCategoryList.get(i).getId()
									.intValue());

					if (dischargeItemsCategoryList.get(i).getLabelDataType()
							.equalsIgnoreCase("DATE")) {
						item_reply_code = "date" + item_reply_code;
					}
					try {
						dischargeSummary.setItemReply(requestDataMap.get(
								item_reply_code).toString());
					} catch (Exception e) {
						e.printStackTrace();
					}
					Users users=new Users();
					users.setId(userId);
					dischargeSummary.setLastChgBy(users);
					dischargeSummary.setLastChgDate(dateToInsert);

					time = (String) utilMap.get("currentTime");
					dischargeSummary.setLastChgTime(time);

					dischargeSummary.setHospital(masHospital);
					hbt.save(dischargeSummary);
				}
			}

			/*
			 * 
			 * Updation adstatus of Inpatient Table as "D" after entering
			 * Discharge Summary Details
			 */

			/*
			 * hbt.setFlushModeName("FLUSH_EAGER");
			 * hbt.setCheckWriteOperations(false); Inpatient inpatientObj =
			 * (Inpatient)hbt.load(Inpatient.class,
			 * Integer.parseInt(requestDataMap.get("inpatientId").toString()));
			 * inpatientObj.setAdStatus("D"); hbt.update(inpatientObj);
			 */

			/*
			 * 
			 * Get Inpatient Lists concerned to the particular Department Id
			 */

			//Added by Arbind on 31-03-2013 for Discharge summary
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			Inpatient inpatientObj = (Inpatient)hbt.load(Inpatient.class,
			Integer.parseInt(requestDataMap.get("parent").toString()));
			inpatientObj.setDischargeSummaryStatus("y"); 
			hbt.update(inpatientObj);

			try {
				deptList = session
						.createCriteria(MasDepartment.class)
						.add(Restrictions.eq(
								"Id",
								Integer.parseInt(requestDataMap.get(
										DEPARTMENT_ID).toString()))).list();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
			MasDepartment masDepartment = (MasDepartment) deptList.get(0);
			map.put("deptName", masDepartment.getDepartmentName());
			Set inPatientSet = (Set) masDepartment.getInpatients();
			String takeSetFromSessionInJsp = "false";
			map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
			map.put("inpatientSet", inPatientSet);
			message = "Discharge Summary Updated/Added Successfully .Do you want print ?";
		} catch (HibernateException e) {
			message = "Record not Added!! Please Try Again...";
			e.printStackTrace();
		}

		map.put("message", message);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDischargeSummaryReportDetails(
			Map requestParameters) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean dischargeSummaryReportDetailsExist = false;
		String casetype = "";
		String hinNo = (String) requestParameters.get("hinNo");
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (hinNo != null && !hinNo.equals("")) {
				List<Patient> patientList = session
						.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo",
								(String) requestParameters.get("hinNo")))
						.list();

				if (patientList != null && patientList.size() > 0) {
					Patient patient = patientList.get(0);
					if (requestParameters.get(HIN_NO).toString()
							.equalsIgnoreCase(patientList.get(0).getHinNo())) {
						Set<DischargeSummary> dischargeSummarySet = (Set) patient
								.getDischargeSummaries();
						for (Iterator iterator = dischargeSummarySet.iterator(); iterator
								.hasNext();) {
							DischargeSummary dischargeSummary = (DischargeSummary) iterator
									.next();
							if (dischargeSummary.getAdNo().equalsIgnoreCase(
									requestParameters.get(ADMISSION_NUMBER)
											.toString().trim())) {
								dischargeSummaryReportDetailsExist = true;
								casetype = dischargeSummary.getItemCode()
										.getCategoryName();
								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("BWHT")) {
										map.put("bodyWeight",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("bodyWeight", "-");
								}

								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("ANTH")) {
										map.put("anthropometry",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("anthropometry", "-");
								}
								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("OFC")) {
										map.put("ofc",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("ofc", "-");
								}

								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("WGHT")) {
										map.put("weight",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("weight", "-");
								}
								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("HGHT")) {
										map.put("height",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("height", "-");
								}
								try {
									if (dischargeSummary.getItemCode()
											.getItemCode().getItemCode()
											.equalsIgnoreCase("HC")) {
										map.put("HC",
												dischargeSummary.getItemReply());
									}
								} catch (Exception e) {
									map.put("HC", "-");
								}
							} // end of Admission Number checking
						} // end of dischargeSummary iterator loop
						map.put("patientName",
								patient.getPFirstName() + " "
										+ patient.getPMiddleName() + " "
										+ patient.getPLastName());
						/*
						 * map.put("serviceNo", patient.getServiceNo());
						 * 
						 * try { map.put("rank",
						 * patient.getRank().getRankName()); } catch (Exception
						 * e) { map.put("rank", "-"); }
						 */

						try {
							map.put("relation", patient.getRelation()
									.getRelationName());
						} catch (Exception e) {
							map.put("relation", "-");
						}
						try {
							map.put("sex", patient.getSex()
									.getAdministrativeSexName());
						} catch (Exception e) {
							map.put("sex", "-");
						}
						/*
						 * map.put("servicePersonName", patient.getSFirstName()
						 * + " " + patient.getSMiddleName() + " " +
						 * patient.getSLastName()); try { map.put("unit",
						 * patient.getUnit().getUnitName()); } catch (Exception
						 * e) { map.put("unit", "-"); }
						 */
						try {
							map.put("bloodGroup", patient.getBloodGroup()
									.getBloodGroupName());
						} catch (Exception e) {
							map.put("bloodGroup", "-");
						}

						try {
							//map.put("address", patient.getAddress());
						} catch (Exception e) {
							map.put("address", "-");
						}

						Set<Inpatient> inpatientSet = (Set) patient
								.getInpatients();
						for (Iterator iterator = inpatientSet.iterator(); iterator
								.hasNext();) {
							Inpatient inpatient = (Inpatient) iterator.next();
							if (requestParameters.get(ADMISSION_NUMBER)
									.toString()
									.equalsIgnoreCase(inpatient.getAdNo())) {
								if (inpatient.getDischargeDate() != null) {
									map.put("doa", inpatient
											.getDateOfAddmission().toString());
								} else {
									map.put("doa", "-");
								}

								if (inpatient.getDischargeDate() != null) {
									map.put("dod", inpatient.getDischargeDate()
											.toString());
								} else {
									map.put("dod", "-");
								}

								map.put("age", inpatient.getAge());
							}
						}
					} // end of if block (hinNo checking)
				} // end of patientSet iterator loop
			}
			Connection con = session.connection();
			map.put("conn", con);
		}
		// end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("dischargeSummaryReportDetailsExist",
				Boolean.valueOf(dischargeSummaryReportDetailsExist));
		map.put("casetype", casetype);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getClinicalSheetReportDetails(
			Map requestParameters) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<IpdIntakeOutputChart> ipdIntakeOutputChart = new ArrayList<IpdIntakeOutputChart>();
		List<OpdPatientDetails> opdPatientDetailsList = new ArrayList<OpdPatientDetails>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Transfer> transferList = new ArrayList<Transfer>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		Set<DischargeIcdCode> dischargeIcdCodeSet = null;
		StringBuffer icd_code_and_name = new StringBuffer();
		try {
			String hinNo = "";
			String AdNo = "";
			String serviceNo = "";
			int hospitalId=0;
			if(requestParameters.get(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)requestParameters.get(HOSPITAL_ID);
			}
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			if (requestParameters.get("hinNo") != null
					&& !(requestParameters.get("hinNo").equals(""))) {
				hinNo = requestParameters.get("hinNo").toString().trim();
			}
			if (requestParameters.get(SERVICE_NO) != null
					&& !(requestParameters.get(SERVICE_NO).equals(""))) {
				serviceNo = requestParameters.get(SERVICE_NO).toString().trim();
			}
			AdNo = requestParameters.get(ADMISSION_NUMBER).toString().trim();

			if (hinNo != "") {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", hinNo)).list();
			} else {
				patientList = session.createCriteria(Patient.class)
						.add(Restrictions.eq("HinNo", serviceNo)).list();
			}

			inpatientList = session.createCriteria(Inpatient.class)
					.add(Restrictions.eq("AdNo", AdNo))
					.add(Restrictions.eq("Hospital.Id",hospitalId ))
					.list();

			if (inpatientList != null && inpatientList.size() > 0) {
				for (Patient patient : patientList) {
					if (patient.getRelation() != null) {
						map.put("relation", patient.getRelation()
								.getRelationName());
					} else {
						map.put("relation", "-");
					}
					if (patient.getSex() != null) {
						map.put("sex", patient.getSex()
								.getAdministrativeSexName());
					} else {
						map.put("sex", "-");
					}

					map.put("patientName",
							patient.getPFirstName() + " "
									+ patient.getPMiddleName() + " "
									+ patient.getPLastName());
					if (patient.getUnit() != null) {
						map.put("unit", patient.getUnit().getUnitName());
					} else {
						map.put("unit", "-");
					}
					if (patient.getRank() != null) {
						map.put("rank", patient.getRank().getRankName());
					} else {
						map.put("rank", "-");
					}
				}
				for (Inpatient inpatient : inpatientList) {
					map.put("age", inpatient.getAge());

					if (inpatient.getDischargeDate() != null) {
						map.put("doa", inpatient.getDateOfAddmission()
								.toString());
					} else {
						map.put("doa", "-");
					}
					if (inpatient.getDischargeDate() != null) {
						map.put("dod", inpatient.getDischargeDate().toString());
					} else {
						map.put("dod", "-");
					}

					dischargeIcdCodeSet = inpatient.getDischargeIcdCodes();
					for (DischargeIcdCode icdCode : dischargeIcdCodeSet) {
						try {
							if (icd_code_and_name.length() > 0) {
								icd_code_and_name.append(", ");
								icd_code_and_name.append(icdCode.getIcd()
										.getIcdCode());
								icd_code_and_name.append(" ");
							} else {
								icd_code_and_name.append(icdCode.getIcd()
										.getIcdCode());
								icd_code_and_name.append(" ");
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					map.put("diag", icd_code_and_name.toString());
				}

				transferList = session.createCriteria(Transfer.class)
						.createAlias("Hin", "p")
						.add(Restrictions.eq("Hospital.Id", hospitalId))
						.add(Restrictions.eq("p.HinNo", hinNo))
						.add(Restrictions.eq("AdNo", AdNo)).list();
				// transferList = hbt.find("from
				// jkt.hms.masters.business.Transfer as inp where inp.AdNo = '"+
				// requestParameters.get(ADMISSION_NUMBER).toString() + "' and
				// inp.Hin.ServiceNo='" +
				// requestParameters.get(SERVICE_NO).toString() + "' order by
				// inp.ListDate desc");

				if (transferList.size() > 0) {
					try {
						map.put("sil", transferList.get(0).getListDate()
								.toString());
					} catch (Exception e) {
						map.put("sil", "-");
					}
				} else {
					map.put("sil", "-");
				}

			}

			opdPatientDetailsList = session
					.createCriteria(OpdPatientDetails.class)
					.createAlias("Hospital", "h")
					.add(Restrictions.eq("h.Id",hospitalId))
					.createAlias("Inpatient", "p")
					.add(Restrictions.eq("p.AdNo",
							requestParameters.get(ADMISSION_NUMBER).toString()))
					.list();

			/*ipdIntakeOutputChart = session
					.createCriteria(IpdIntakeOutputChart.class)
					.add(Restrictions.eq("Hospital.Id",hospitalId ))
					.add(Restrictions.eq("AdNo",
							requestParameters.get(ADMISSION_NUMBER).toString()))
					.list();*/
			TimeSeries series1 = new TimeSeries("Temperature", Minute.class);
			TimeSeries series2 = new TimeSeries("Pulse", Minute.class);
			TimeSeriesCollection dataset = new TimeSeriesCollection();

		//	if (ipdIntakeOutputChart.size() > 0) {
				if (opdPatientDetailsList.size() > 0) {
			/*	Set<IpdTemperature> ipdTemperatureSet = (Set) ipdIntakeOutputChart
						.get(0).getIpdTemperatures();*/
				// for (Iterator iter = ipdTemperatureSet.iterator();
				// iter.hasNext();)
				for (OpdPatientDetails opdPatientDetails : opdPatientDetailsList) {
					// IpdTemperature ipdTemperature = (IpdTemperature)
					// iter.next();
					float temp = 0;
					int pulse = 0;
					int hh = 0;
					int mm = 0;
					Hour hour = null;
/*					if (ipdTemperature.getTemperature() != 0) {
						temp = ipdTemperature.getTemperature();
					}

					if (ipdTemperature.getPulse() != null) {
						pulse = ipdTemperature.getPulse().intValue();
					}

					Date date = ipdTemperature.getDate();
					String time = ipdTemperature.getTime();*/
					if (opdPatientDetails.getTemperature() != 0) {
						temp = opdPatientDetails.getTemperature();
					}

					if (opdPatientDetails.getPulse() != null) {
						pulse = opdPatientDetails.getPulse().intValue();
					}
System.out.println(temp+"temp");
System.out.println(pulse+"pulse");
					Date date = opdPatientDetails.getOpdDate();
					String time = opdPatientDetails.getOpdTime();
					if (time != null) {
						hh = Integer.parseInt(time.substring(0, 2));
						mm = Integer.parseInt(time.substring(3, 5));
						hour = new Hour(hh, new Day(date));

						if (temp != 0) {
							series1.addOrUpdate(new Minute(mm, hour), temp);
						}

						if (pulse != 0) {
							series2.addOrUpdate(new Minute(mm, hour), pulse);
						}
					}
				}
				dataset.addSeries(series1);
				dataset.addSeries(series2);
			} else // if record not exists in ipd_input_output_chart
			{
				map.put("status", "nodata");
			}

			// JFreeChart tempchart = ChartFactory.createBarChart(arg0, arg1,
			// arg2, arg3, arg4, arg5, arg6, arg7);
			JFreeChart chart = ChartFactory.createTimeSeriesChart("", // title
					"Time", // x-axis label
					"Temperature / Pulse", // y-axis label
					dataset, // data
					true, // create legend?
					true, // generate tooltips?
					false // generate URLs?
					);

			chart.setBackgroundPaint(Color.white);

			XYPlot plot = (XYPlot) chart.getPlot();
			plot.setBackgroundPaint(Color.lightGray);
			plot.setDomainGridlinePaint(Color.white);
			plot.setRangeGridlinePaint(Color.white);
			plot.setAxisOffset(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
			plot.setDomainCrosshairVisible(true);
			plot.setRangeCrosshairVisible(true);

			XYItemRenderer r = plot.getRenderer();
			if (r instanceof XYLineAndShapeRenderer) {
				XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
				renderer.setBaseShapesVisible(true);
				renderer.setBaseShapesFilled(true);
			}

			DateAxis axis = (DateAxis) plot.getDomainAxis();
			axis.setAutoRange(true);
			axis.setDateFormatOverride(new SimpleDateFormat("d-MM-yyyy-hh:mma"));

			JFreeChartRenderer jfcRenderer = new JFreeChartRenderer(chart);
			System.out.println(jfcRenderer+"jfcRenderer");
			map.put("jfcRenderer", jfcRenderer);
		} // end of try block
		catch (HibernateException e) {
			e.printStackTrace();
		}
		Connection con = session.connection();
		map.put("conn", con);
		return map;
	}

	public Map<String, Object> getSearchPatientComboDetails(
			Map requestParameters) {
		List<MasServiceType> masServiceTypeList = new ArrayList<MasServiceType>();
		List<MasRank> masRankList = new ArrayList<MasRank>();
		List<MasUnit> masUnitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			masRankList = session.createCriteria(MasRank.class).list();
			masUnitList = session.createCriteria(MasUnit.class).list();
			masServiceTypeList = session.createCriteria(MasServiceType.class)
					.list();
			String queryString = null;
			queryString = "select inp from jkt.hms.masters.business.Patient as inp,jkt.hms.masters.business.Inpatient as inpatient where 1 = 1 ";

			if (requestParameters.get("deptId") != null
					&& requestParameters.get("deptId").toString().length() > 0) {
				queryString = queryString
						+ "and inp.Id = inpatient.Hin.Id and inpatient.Department.Id  = '"
						+ requestParameters.get("deptId") + "'";
			}
			if (requestParameters.get("adNo") != null
					&& requestParameters.get("adNo").toString().length() > 0) {
				queryString = queryString + "  and inpatient.AdNo = '"
						+ requestParameters.get("adNo") + "'";
			}

			if (requestParameters.get("serviceNo") != null
					&& requestParameters.get("serviceNo").toString().length() > 0) {
				queryString = queryString + " and inp.ServiceNo = '"
						+ requestParameters.get("serviceNo") + "'";
			}

			if (requestParameters.get("serviceType") != null
					&& requestParameters.get("serviceType").toString().length() > 0) {
				queryString = queryString
						+ " and inp.ServiceType.ServiceTypeCode = '"
						+ requestParameters.get("serviceType") + "'";
			}

			if (requestParameters.get("rank") != null
					&& requestParameters.get("rank").toString().length() > 0) {
				queryString = queryString + " and inp.Rank.RankCode= '"
						+ requestParameters.get("rank") + "'";
			}

			if (requestParameters.get("unit") != null
					&& requestParameters.get("unit").toString().length() > 0) {
				queryString = queryString + " and inp.Unit.Id = '"
						+ requestParameters.get("unit") + "'";
			}

			if (requestParameters.get("patientName") != null
					&& requestParameters.get("patientName").toString().length() > 0) {
				queryString = queryString + " and (inp.PFirstName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PMiddleName like '%"
						+ requestParameters.get("patientName")
						+ "%' or inp.PLastName like '%"
						+ requestParameters.get("patientName") + "%')";
			}

			if (requestParameters.get("servicePersonnelName") != null
					&& requestParameters.get("servicePersonnelName").toString()
							.length() > 0) {
				queryString = queryString + " and (inp.SFirstName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SMiddleName like '%"
						+ requestParameters.get("servicePersonnelName")
						+ "%' or inp.SLastName like '%"
						+ requestParameters.get("servicePersonnelName") + "%')";
			}

			if (requestParameters.get("SearchFlag") != null
					&& requestParameters.get("SearchFlag").toString()
							.equals("true")) {
				patientList = hbt.find(queryString);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("masServiceTypeList", masServiceTypeList);
		map.put("masUnitList", masUnitList);
		map.put("masRankList", masRankList);
		map.put("patientList", patientList);
		return map;
	}

	// ---By Dipali--09/nov--
	public Map<String, Object> getAdmissionNumberList1(
			Map<String, Object> detailmap) {
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		String hinNo = "";
		if (detailmap.get("hinNo") != null) {
			hinNo = (String) detailmap.get("hinNo").toString().trim();
		}
		String department = null;
		boolean hinNoFound = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			// int hospital_id = (Integer) requestParameters.get(HOSPITAL_ID);
			// hospitalList =
			// session.createCriteria(MasHospital.class).add(Restrictions.eq("Id",
			// hospital_id)).list();
			// code added by shailesh
			// if (hospitalList != null && hospitalList.size() > 0)
			// patientSet = (Set)hospitalList.get(0).getPatients();
			// for (Iterator iter = patientSet.iterator(); iter.hasNext();)
			// {
			inpatientList = session.createCriteria(Inpatient.class)
					.createAlias("Hin", "p")
					.add(Restrictions.eq("p.HinNo", hinNo)).list();
			if (inpatientList != null && inpatientList.size() > 0) {
				hinNoFound = true;
			}
			// Get the department/ward
			/*
			 * if (inpatientSet != null && inpatientSet.size() > 0) { for
			 * (Iterator iterator = inpatientSet.iterator(); iterator
			 * .hasNext();) { Inpatient inpatient = (Inpatient) iterator.next();
			 * try { department = inpatient.getDepartment().getDepartmentName();
			 * break; } catch (Exception e) { department = ""; } } }
			 * map.put("department", department);
			 */
			// map.put("inpatientSet", inpatientSet);

			// }

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		map.put("hinNoFound", hinNoFound);
		return map;
	}


	@Override
	public Map<String, Object> viewDischargeSummary(Box box) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		Session session = (Session) getSession();
		inPatientList =session.createCriteria(Inpatient.class).createAlias("Hin", "hin").add(Restrictions.eq("hin.HinNo",  box.getString("hinNo"))).list();
		String adNo = "";
		int inPatientId = 0;
		if(inPatientList.size()>0){
			 inPatientId = inPatientList.get(0).getId();
			 adNo = inPatientList.get(0).getAdNo();
			 map.put("inPatientId", inPatientId);
			 map.put("adNo", adNo);
		}
		System.out.println("inPatientList=="+inPatientList.size());
		return map;
	}


	@Override
	public String getHinNo(String admissionNumber) {
		String hinNo="";
		List<Inpatient>ipList=new ArrayList<Inpatient>();
		Session session=(Session)getSession();
		ipList=session.createCriteria(Inpatient.class).add(Restrictions.eq("AdNo", admissionNumber)).list();
		for(Inpatient ip:ipList){
			
			hinNo=ip.getHinNo();
		}
		
		return hinNo;
	}
}