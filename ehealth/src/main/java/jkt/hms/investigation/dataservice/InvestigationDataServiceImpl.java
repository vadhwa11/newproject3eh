package jkt.hms.investigation.dataservice;

import static jkt.hms.util.RequestConstants.ADDITIONAL_REMARKS;
import static jkt.hms.util.RequestConstants.CHARGE_CODE_ID;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.RESULT;
import static jkt.hms.util.RequestConstants.RESULT_DETAIL_ID;
import static jkt.hms.util.RequestConstants.RESULT_ID;
import static jkt.hms.util.RequestConstants.RESULT_ID_SINGLE_VALUE;
import static jkt.hms.util.RequestConstants.SAMPLE_ID;
import static jkt.hms.util.RequestConstants.SAMPLE_ID_SINGLE_VALUE;
import static jkt.hms.util.RequestConstants.SUB_TEST_SIZE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

import jkt.hms.lab.dataservice.LabDataService;
import jkt.hms.masters.business.CentralServerResultData;
import jkt.hms.masters.business.DgFixedValue;
import jkt.hms.masters.business.DgHistoSampleCollectionDetails;
import jkt.hms.masters.business.DgMasCollection;
import jkt.hms.masters.business.DgMasInvestigation;
import jkt.hms.masters.business.DgMasOrganism;
import jkt.hms.masters.business.DgMasOrganismGroup;
import jkt.hms.masters.business.DgNormalValue;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgOrgDtl;
import jkt.hms.masters.business.DgOrgGrpDtl;
import jkt.hms.masters.business.DgResultEntryDetail;
import jkt.hms.masters.business.DgResultEntryDetailSen;
import jkt.hms.masters.business.DgResultEntryHeader;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.DgSampleCollectionHeader;
import jkt.hms.masters.business.DgSubMasInvestigation;
import jkt.hms.masters.business.DgTemplate;
import jkt.hms.masters.business.DgUom;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.LeanServerResultData;
import jkt.hms.masters.business.MasAntibioticLab;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDepartmentType;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLionc;
import jkt.hms.masters.business.MasLioncSubClass;
import jkt.hms.masters.business.MasMainChargecode;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasSample;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasSubChargecode;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PhAlert;
import jkt.hms.masters.business.PhMemberSurvey;
import jkt.hms.masters.business.PharmacyLabQueue;
import jkt.hms.masters.business.StoreGrnM;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TransactionSequence;
import jkt.hms.masters.business.UploadDocuments;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.DiagNoComparator;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

public class InvestigationDataServiceImpl extends HibernateDaoSupport implements
		InvestigationDataService {
	HibernateTransactionManager transactionManager = null;
	LabDataService labDataService = null;
	
	public LabDataService getLabDataService() {
		return labDataService;
	}

	public void setLabDataService(LabDataService labDataService) {
		this.labDataService = labDataService;
	}
	Session session;

	static final Logger LOGGER = Logger.getLogger(InvestigationDataServiceImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * showInvestigationJsp(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> showInvestigationJsp(Box box) {
		LOGGER.info("in showInvestigationJsp");
		String deptType = "";
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (box.get("deptType") != null) {
			deptType = ("" + box.get("deptType"));
		}
		String str = "";
		if (map.get("autoHint") != null) {
			str = map.get("autoHint") + "%";
		}

		if (box.getInt("deptId") != 0) {
			deptId = box.getInt("deptId");
		}
		Session session = (Session) getSession();
		List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasCollection> collectionList = new ArrayList<DgMasCollection>();
		List<MasMainChargecode> gridMainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> gridSubChargecodeList = new ArrayList<MasSubChargecode>();
		List<MasSample> gridSampleList = new ArrayList<MasSample>();
		List<DgUom> gridUnitOfMeasurementList = new ArrayList<DgUom>();
		List<MasChargeCode> gridChargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasCollection> gridCollectionList = new ArrayList<DgMasCollection>();
		List<MasDepartmentType> masDepartmentTypeList = new ArrayList<MasDepartmentType>();
		List<MasLionc> masLioncList = new ArrayList<MasLionc>();

		List lst = new ArrayList();
		// lst.add("DIAG");
		// lst.add("RADIO");
		masDepartmentTypeList = session.createCriteria(MasDepartmentType.class)
				.add(Restrictions.eq("DepartmentTypeCode", deptType)).list();

		mainChargecodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
			//	.createAlias("Department", "dept")
			//	.createAlias("dept.DepartmentType", "dt")
				// .add(Restrictions.eq("dt.DepartmentTypeCode", deptType))
				// .add(Restrictions.eq("Department.Id", deptId))
				.addOrder(Order.asc("MainChargecodeName")).list();

		searchInvestigationList = session
				.createCriteria(DgMasInvestigation.class)
				.createAlias("MainChargecode", "mainChargecode")
				.add(Restrictions.eq("mainChargecode.Department.Id", deptId))
				.addOrder(Order.asc("InvestigationName")).list();

		if (mainChargecodeList.size() > 0) {
			map.put("mainChargecodeList", mainChargecodeList);
		}
		uomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgUom as isc where upper(isc.Status) = 'Y' order by isc.UomName");
		subChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as isc where upper(isc.Status) = 'Y' order by isc.SubChargecodeName");
		// searchInvestigationList = getHibernateTemplate()
		// .find("from jkt.hms.masters.business.DgMasInvestigation order by InvestigationName");

		sampleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSample as isc where upper(isc.Status) = 'Y' order by SampleDescription ");
		chargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeCode as stm where upper(stm.Status) = 'Y' and stm.ChargeType.Id='2' order by ChargeCodeName");
		collectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasCollection as isc where upper(isc.Status) = 'Y' order by CollectionName");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode where Department.Id="
						+ deptId);
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgUom ");
		gridChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode");
		gridCollectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasCollection");

		map.put("chargeCodeList", chargeCodeList);
		map.put("gridSubChargecodeList", gridSubChargecodeList);
		map.put("gridSampleList", gridSampleList);
		map.put("gridMainChargecodeList", gridMainChargecodeList);
		map.put("gridUnitOfMeasurementList", gridUnitOfMeasurementList);
		map.put("searchInvestigationList", searchInvestigationList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("sampleList", sampleList);
		map.put("uomList", uomList);
		map.put("subChargecodeList", subChargecodeList);
		map.put("gridChargeCodeList", gridChargeCodeList);
		map.put("gridCollectionList", gridCollectionList);
		map.put("collectionList", collectionList);
		map.put("masLioncList", masLioncList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * checkInvestigationExsist(java.lang.String, java.lang.String)
	 */

	@SuppressWarnings("unchecked")
	public boolean checkInvestigationExsist(String investigationCode,
			String investigationName) {
		LOGGER.info("in checkInvestigationExsist");
		List investigationExsistList = null;
		boolean investigationExsist = true;
		try {
			investigationExsistList = getHibernateTemplate()
					.find("from jkt.hms.masters.business.DgMasInvestigation as ccm where ccm.InvestigationName = '"
							+ investigationName + "' ");
			if (investigationExsistList.size() > 0) {
				investigationExsist = false;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return investigationExsist;
	}

	/*
	 * for getting charge code details
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeDetails(int subChargeCodeId) {
		LOGGER.info("in getChargeDetails");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasChargeCode> chargeDetailsList = new ArrayList<MasChargeCode>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		Session session = (Session) getSession();
		chargeDetailsList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("SubChargecode.Id", subChargeCodeId))
				.list();
		uomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgUom as isc where isc.Status = 'y'");
		detailsMap.put("uomList", uomList);
		detailsMap.put("chargeDetailsList", chargeDetailsList);
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getParameterDetails(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getParameterDetails(Box box) {
		LOGGER.info("in getParameterDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgMasInvestigation> testList = new ArrayList<DgMasInvestigation>();
		List<DgUom> uomList = new ArrayList<DgUom>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<DgSubMasInvestigation> subMasList = new ArrayList<DgSubMasInvestigation>();
		chargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeCode as mi where  mi.SubChargecode.Id = "
						+ box.getInt(RequestConstants.SUB_CHARGECODE_ID) + "");
		uomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgUom as isc where isc.Status = 'y'");
		testList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasInvestigation as mi where  mi.ChargeCode.Id = "
						+ box.getInt(RequestConstants.CHARGE_CODE_ID) + "");
		sampleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y'");
		subMasList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgSubMasInvestigation as isc  where isc.ChargeCode.Id ="
						+ box.getInt(RequestConstants.CHARGE_CODE_ID) + "");
		map.put("testList", testList);
		map.put("chargeCodeList", chargeCodeList);
		map.put("uomList", uomList);
		map.put("sampleList", sampleList);
		map.put("subMasList", subMasList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getChargeDetails
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getChargeDetails(Box box) {
		LOGGER.info("in getChargeDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		List investigationList = new ArrayList();
		investigationList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgSubMasInvestigation as mi where  mi.Investigation.Id = "
						+ box.getInt(RequestConstants.INVESTIGATION_ID) + "");
		map.put("investigationList", investigationList);
		return map;
	}

	/*
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#addSubTest
	 * (jkt.hms.util.Box, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> addSubTest(Box box, Map dataMap) {
		LOGGER.info("in addSubTest");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataSaved = false;
		int i = 0;
		int multiTestSize = 0;
		multiTestSize = (Integer) dataMap.get("multiTestSize");
		Users users = (Users) dataMap.get(RequestConstants.USERS);
		Vector quantity = box.getVector(RequestConstants.QUANTITY);
		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int mainChargeCodeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleId = box.getInt(RequestConstants.SAMPLE_ID);
		int collectionCenterId = box
				.getInt(RequestConstants.COLLECTION_CENTER_ID);
		Vector investigationName = box
				.getVector(RequestConstants.INVESTIGATION_NAME);
		String confidential = box.getString(RequestConstants.CONFIDENTIAL);
		Vector investigationType = box
				.getVector(RequestConstants.INVESTIGATION_TYPE);
		Vector dischargeSummary = box
				.getVector(RequestConstants.DSICHARGE_SUMMARY);
		int subChargeId = box.getInt("subChargeCodeId");
		String userName = box.getString("userName");
		String rareCommon = box.getString(RequestConstants.RARE_COMMON);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeId);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		DgMasInvestigation dgmasInvestigation = new DgMasInvestigation();
		dgmasInvestigation.setId(chargeCodeId);
		if (investigationName != null && investigationName.size() > 0) {
			dgmasInvestigation.setInvestigationName((String) investigationName
					.get(i));
		}
		if (investigationType != null && investigationType.size() > 0) {
			dgmasInvestigation.setInvestigationType((String) investigationType
					.get(i));

		}
		if (quantity != null && quantity.size() > 0) {
			dgmasInvestigation.setQuantity((String) quantity.get(i));
		}
		dgmasInvestigation.setConfidential(confidential);
		if (dischargeSummary != null && dischargeSummary.size() > 0) {
			dgmasInvestigation
					.setAppearInDischargeSummary((String) dischargeSummary
							.get(i));
		}
		dgmasInvestigation.setRareCommon(rareCommon);
		dgmasInvestigation.setStatus("y");
		dgmasInvestigation.setSubChargecode(masSubChargecode);
		dgmasInvestigation.setChargeCode(masChargeCode);
		dgmasInvestigation.setMainChargecode(masMainChargecode);
		if (sampleId != 0) {
			MasSample masSample = new MasSample();
			masSample.setId(sampleId);
			dgmasInvestigation.setSample(masSample);
		}
		if (collectionCenterId != 0) {
			DgMasCollection dgMasCollection = new DgMasCollection();
			dgMasCollection.setId(collectionCenterId);
			dgmasInvestigation.setCollection(dgMasCollection);
		}
		dgmasInvestigation.setLastChgBy(users);
		dgmasInvestigation.setLastChgDate(date);
		dgmasInvestigation.setLastChgTime(time);
		if (investigationType.contains("m")) {
			dgmasInvestigation.setMultipleResults("y");
		} else {
			dgmasInvestigation.setMultipleResults("n");
		}
		hbt.save(dgmasInvestigation);
		HibernateTemplate hbt1 = getHibernateTemplate();
		hbt1.setFlushModeName("FLUSH_EAGER");
		hbt1.setCheckWriteOperations(false);

		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);

		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		try {
			for (i = 0; i < multiTestSize; i++) {
				if (orderNo.get(i) != null && !orderNo.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
					dgSubMasInvestigation.setInvestigation(dgmasInvestigation);
					dgSubMasInvestigation
							.setSubInvestigationName((String) subTestName
									.get(i));
					dgSubMasInvestigation
							.setSubInvestigationCode((String) subTestCode
									.get(i));
					if (resultType.get(i) != null
							&& !resultType.get(i).equals("")) {
						dgSubMasInvestigation.setResultType((String) resultType
								.get(i));
					}
					dgSubMasInvestigation.setOrderNo(Integer
							.parseInt((String) orderNo.get(i)));
					if (comparisonType.get(i) != null
							&& !comparisonType.get(i).equals("")) {
						dgSubMasInvestigation
								.setComparisonType((String) comparisonType
										.get(i));
					}
					dgSubMasInvestigation.setStatus("y");
					dgSubMasInvestigation.setLastChgBy(users);
					dgSubMasInvestigation.setLastChgDate(date);
					dgSubMasInvestigation.setLastChgTime(time);
					dgSubMasInvestigation.setSubChargecode(masSubChargecode);
					dgSubMasInvestigation.setChargeCode(masChargeCode);
					dgSubMasInvestigation.setMainChargecode(masMainChargecode);

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgSubMasInvestigation.setUom(dgUom);
					}

					hbt1.save(dgSubMasInvestigation);
					map.put("dgSubMasInvestigation", dgSubMasInvestigation);
					subInvestigationlist.add(dgSubMasInvestigation);

				}
			}
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		map.put("dataSaved", dataSaved);
		map.put("subInvestigationlist", subInvestigationlist);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getResponseSubchargeList(jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getResponseSubchargeList(Box box) {
		LOGGER.info("in getResponseSubchargeList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		subChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as mi where  mi.MainChargecode.Id = "
						+ box.getInt(RequestConstants.MAIN_CHARGECODE_ID) + "");
		map.put("subChargecodeList", subChargecodeList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getNormalValueDetails(jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getNormalValueDetails(Box box) {
		LOGGER.info("in getNormalValueDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgNormalValue> normalValueList = new ArrayList<DgNormalValue>();
		normalValueList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgNormalValue as isc where isc.SubInvestigation.Id="
						+ box.getInt(RequestConstants.SUBTEST_ID) + "");
		map.put("normalValueList", normalValueList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#updateSubTest
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean updateSubTest(Box box) {
		LOGGER.info("in updateSubTest");
		boolean dataUpdated = false;
		int i = 0;
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector status = box.getVector(RequestConstants.STATUS);
		Vector chargeCodeId = box.getVector(RequestConstants.CHARGE_CODE_ID);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		for (i = 0; i < subTestId.size(); i++) {
			DgSubMasInvestigation dgMasInvestigation = new DgSubMasInvestigation();
			if (subTestId.get(i).toString() != null
					&& !subTestId.get(i).toString().equals("")) {
				int sId = Integer.parseInt(subTestId.get(i).toString());
				dgMasInvestigation = (DgSubMasInvestigation) getHibernateTemplate()
						.load(DgSubMasInvestigation.class, sId);
				dgMasInvestigation.setId(Integer.parseInt((String) subTestId
						.get(i)));
				dgMasInvestigation.setSubInvestigationName((String) subTestName
						.get(i));
				dgMasInvestigation.setSubInvestigationCode((String) subTestCode
						.get(i));
				dgMasInvestigation.setComparisonType((String) comparisonType
						.get(i));
				dgMasInvestigation.setResultType((String) resultType.get(i));
				dgMasInvestigation.setOrderNo(Integer.parseInt((String) orderNo
						.get(i)));
				if (uomId.get(i) != null && !uomId.get(i).equals("")) {
					DgUom dgUom = new DgUom();
					dgUom.setId(Integer.parseInt((String) uomId.get(i)));
					dgMasInvestigation.setUom(dgUom);
				}
				hbt.update(dgMasInvestigation);
			}
		}
		return dataUpdated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForSearch()
	 */
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultPendingResult(Map<String, Object> dataMap) {
		LOGGER.info("in getResultPendingResult");
		
		// String userName = "";
		List<DgOrderhd> appList = new ArrayList<DgOrderhd>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<PharmacyLabQueue> pendingLabQueueList=new ArrayList<PharmacyLabQueue>();
		int deptId = 0;
		int hospitalId = 0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" +dataMap.get("hospitalId"));
		}
		int hinId = 0;
		if (dataMap.get("hinId") != null) {
			hinId = Integer.parseInt("" +dataMap.get("hinId"));
		}
		
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		
		try {
			URL	resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
		
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile()))); 
		//	int department_type_id= pacProper.get("department_type_id");
			//List<Integer> orderDtList=new ArrayList<Integer>();
			// List<Integer> orderhdtList=new ArrayList<Integer>();
			crit=session.createCriteria(DgOrderdt.class)
					.createAlias("Orderhd", "hd")
					.createAlias("hd.Department", "dep")
					.createAlias("hd.Hospital", "hospital")
					.createAlias("hd.Hin", "hin")
					/*.createAlias("Orderhd", "orderHd")*/
					.add(Restrictions.eq("hospital.Id", hospitalId))
					.add(Restrictions.eq("dep.Id", deptId))
					.add(Restrictions.eq("hin.Id", hinId))
				.add(Restrictions.eq("OrderStatus", "P").ignoreCase());
			patientList = crit.list();
			LOGGER.info("patientList patientList patientList ..................."+patientList.size());
			/*if(null !=appList && appList.size()>0){
				for(DgOrderhd appInves:appList){
					orderhdtList.add(appInves.getId());
					
				}
			}*/
			
			/*crit = session.createCriteria(PharmacyLabQueue.class)
					.createAlias("DgOrderhdId", "dgOrderhdId")
					.createAlias("Department", "department")
					.createAlias("Hospital", "oh")
					.add(Restrictions.eq("PharmacyLabStatus", "P").ignoreCase())
					.add(Restrictions.eq("oh.Id", hospitalId))
					.add(Restrictions.eq("department.Id", deptId))
					.add(Restrictions.eq("Status", "P").ignoreCase());
			         pendingLabQueueList=crit.list();
			System.out.println(" pharmacyLabQueueList  "+pendingLabQueueList.size());*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		detailsMap.put("patientList", patientList);
			
			return detailsMap;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForSearch(Map<String, Object> dataMap) {
		LOGGER.info("in getDetailsForSearch");
		// String userName = "";
		
		int deptId = 0;
		int hospitalId = 0;
		int currentLabId = 0; // added by amit das on 17-07-2017
		
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		/*
		 * if (dataMap.get("userName") != null) { userName = ("" +
		 * dataMap.get("userName")); }
		 */
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		
		// added by amit das on 17-07-2017
		MasHospital masHospital = (MasHospital)session.get(MasHospital.class, hospitalId);
		
		if(dataMap.get("userId")!=null){
			int userId = (Integer)dataMap.get("userId");
			Users user = (Users)session.get(Users.class, userId);
			
			if(user.getCurrentLab()!=null)
					currentLabId = 	user.getCurrentLab().getId();
			
		}
		
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("MainChargecode", "mcc")
				//.createAlias("mcc.Department", "dept")
				.add(Restrictions.eq("mcc.Id", 17)).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}
		investigationList=session.createCriteria(DgMasInvestigation.class)
				//.createAlias("MainChargecode","MainChargecode")
				
				.add(Restrictions.eq("MainChargecode.Id", 17)).addOrder(Order.asc("InvestigationName")).list();
		sampleList = session.createCriteria(MasSample.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).addOrder(Order.asc("SampleDescription")).list();
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}
		if(investigationList.size()>0){
			detailsMap.put("investigationList", investigationList);
		}
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		/*
		 * chargeCodeList = session.createCriteria(MasChargeCode.class)
		 * .add(Restrictions.eq("Status", "y")).list(); if
		 * (chargeCodeList.size() > 0) { detailsMap.put("chargeCodeList",
		 * chargeCodeList); }
		 */
		/*
		 * List<String> orderBillList = new ArrayList<String>();
		 * 
		 * orderBillList =
		 * session.createCriteria(DgOrderhd.class).add(Restrictions
		 * .eq("PatientType", "OP")) .setProjection(Projections.projectionList()
		 * .add(Projections.property("BillChargeSlpNo")))
		 * .addOrder(Order.asc("BillChargeSlpNo")).list();
		 * 
		 * detailsMap.put("orderBillList", orderBillList);
		 */

		detailsMap.put("currentLabId", currentLabId); // added by amit das on 17-07-2017
		detailsMap.put("masHospital", masHospital); // added by amit das on 18-07-2017
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getPatientDetails
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetails(Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int departmentId = 0;
		int hinId = 0;
		int subChargeCodeId = 0;
		int sampleCollectionDetailId = 0;
		int deptId = 0;
		int hospitalId=0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		} 
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("sampleCollectionDetailId") != null) {
			sampleCollectionDetailId = (Integer) mapForDs
					.get("sampleCollectionDetailId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}

		crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "A").ignoreCase())
				.createAlias("SampleCollectionHeader", "sampleHead")
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				// .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(Restrictions.between("sampleHead.SampleValidationDate",
						fromDate, toDate));

		crit =	crit.createAlias("sampleHead.Hin", "pt");
		if (!hinNo.equals("")) {
			crit = crit.add(
					Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.add(
					Restrictions.eq("pt.Id", hinId));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(
					Restrictions.like("pt.PFirstName", patientFName + "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("sampleHead.Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (deptId != 0) {
			crit = crit.createAlias("sampleHead.Department", "dept").add(
					Restrictions.eq("dept.Id", deptId));
		}
		if (subChargeCodeId != 0) {
			crit = crit.createAlias("ChargeCode", "charge")
					.createAlias("charge.SubChargecode", "subChrg")
					.add(Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getAllDetails
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getAllDetails(Box box) {
		LOGGER.info("in getAllDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * List<DgSampleCollectionHeader> patientList=new
		 * ArrayList<DgSampleCollectionHeader>();
		 * List<DgSubMasInvestigation>investigationList = new
		 * ArrayList<DgSubMasInvestigation>();
		 * patientList=getHibernateTemplate().find( "from
		 * jkt.hms.masters.business.DgSampleCollectionHeader");
		 * investigationList=getHibernateTemplate().find("from
		 * jkt.hms.masters.business.DgSubMasInvestigation as dgm ");
		 * 
		 * map.put("investigationList", investigationList);
		 * map.put("patientList", patientList);
		 */
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getChargeList
	 * (jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public List<DgSubMasInvestigation> getChargeList(Box box) {
		LOGGER.info("in getChargeList");
		Session session = (Session) getSession();
		List investigationList = new ArrayList();
		try {
			investigationList = session
					.createQuery(
							"select ugh from DgSubMasInvestigation as ugh where ugh.ChargeCode.Id="
									+ box.getInt(RequestConstants.CHARGE_CODE_ID)
									+ " ").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return investigationList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getTemplateList
	 * (int)
	 */

	@SuppressWarnings("unchecked")
	public List<DgTemplate> getTemplateList(int chargeCodeId) {
		LOGGER.info("in getTemplateList");
		Session session = (Session) getSession();
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		try {
			templateList = session.createQuery(
					"select ugh from DgTemplate as ugh where ugh.ChargeCode.Id="
							+ chargeCodeId + " ").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return templateList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getFixedList
	 * (jkt.hms.util.Box)
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getFixedList(Box box) {
		LOGGER.info("in getFixedList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgFixedValue> fixedList = new ArrayList<DgFixedValue>();
		fixedList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgFixedValue as isc where isc.SubInvestigation.Id="
						+ box.getInt(RequestConstants.SUBTEST_ID) + " ");
		map.put("fixedList", fixedList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * searchInvestigation(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> searchInvestigation(String investigationCode,
			String investigationName) {
		LOGGER.info("in searchInvestigation");
		List<DgMasInvestigation> searchInvestigationList = new ArrayList<DgMasInvestigation>();
		List chargeTypeList = null;
		List departmentList = null;
		List mainChargecodeList = null;
		List subChargecodeList = null;
		List sampleList = null;
		List uomList = null;
		List subTestList = null;
		List<MasChargeCode> chargeCodeList = null;
		List<DgMasCollection> collectionList = null;
		List gridChargeTypeList = null;
		List gridDepartmentList = null;
		List gridMainChargecodeList = null;
		List gridSubChargecodeList = null;
		List gridUnitOfMeasurementList = null;
		List gridSampleList = null;
		List gridSubTestList = null;
		List<MasChargeCode> gridChargeCodeList = null;
		List<DgMasCollection> gridCollectionList = null;
		Session session = (Session) getSession();
		Map<String, Object> chargeCodeFieldsMap = new HashMap<String, Object>();
		try {
			/*
			 * if ((investigationName != null)) { searchInvestigationList =
			 * getHibernateTemplate() .find(
			 * "from jkt.hms.masters.business.DgMasInvestigation as i where i.InvestigationName like '"
			 * + investigationName + "%' order by i.InvestigationName"); }
			 */

			Criteria crit = session.createCriteria(DgMasInvestigation.class)
					.add(Restrictions
							.eq("InvestigationType", investigationName));
			if (investigationCode != null) {
				crit.add(Restrictions.like("InvestigationName",
						investigationCode + "%"));
			}

			searchInvestigationList = crit.list();
			// else{
			// searchInvestigationList=getHibernateTemplate().find("from
			// jkt.hms.masters.business.DgMasInvestigation as i where
			// i.InvestigationCode like '"+ investigationCode+"%' order by
			// i.InvestigationCode");}
		} catch (Exception e) {
			e.printStackTrace();
		}
		chargeTypeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeType as isc where isc.Status = 'y' or status='Y'");
		departmentList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasDepartment as isc where isc.Status = 'y' or status='Y'");
		subChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y' or status='Y'");
		sampleList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSample as isc where isc.Status = 'y' or status='Y'");
		mainChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasMainChargecode as isc where isc.Status = 'y' or status='Y'");
		uomList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgUom as uomm where uomm.Status='y' or status='Y'");
		subTestList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubTest as stm where stm.Status = 'y' or status='Y'");
		chargeCodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasChargeCode as stm where stm.Status = 'y' or status='Y'");
		collectionList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgMasCollection as stm where stm.Status = 'y' or status='Y'");

		gridChargeTypeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeType");
		gridDepartmentList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasDepartment");
		gridSubChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubChargecode ");
		gridSampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		gridMainChargecodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasMainChargecode");
		gridUnitOfMeasurementList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgUom ");
		gridSubTestList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSubTest ");
		gridChargeCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasChargeCode ");
		gridCollectionList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgMasCollection ");

		chargeCodeFieldsMap.put("gridChargeTypeList", gridChargeTypeList);
		chargeCodeFieldsMap.put("gridDepartmentList", gridDepartmentList);
		chargeCodeFieldsMap.put("gridSubChargecodeList", gridSubChargecodeList);
		chargeCodeFieldsMap.put("gridSubTestList", gridSubTestList);
		chargeCodeFieldsMap.put("gridSampleList", gridSampleList);
		chargeCodeFieldsMap.put("gridMainChargecodeList",
				gridMainChargecodeList);
		chargeCodeFieldsMap.put("gridUnitOfMeasurementList",
				gridUnitOfMeasurementList);
		chargeCodeFieldsMap.put("gridCollectionList", gridCollectionList);

		chargeCodeFieldsMap.put("searchInvestigationList",
				searchInvestigationList);
		chargeCodeFieldsMap.put("subTestList", subTestList);
		chargeCodeFieldsMap.put("chargeTypeList", chargeTypeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("departmentList", departmentList);
		chargeCodeFieldsMap.put("mainChargecodeList", mainChargecodeList);
		chargeCodeFieldsMap.put("subChargecodeList", subChargecodeList);
		chargeCodeFieldsMap.put("sampleList", sampleList);
		chargeCodeFieldsMap.put("uomList", uomList);
		chargeCodeFieldsMap.put("gridChargeCodeList", gridChargeCodeList);
		chargeCodeFieldsMap.put("chargeCodeList", chargeCodeList);
		chargeCodeFieldsMap.put("collectionList", collectionList);

		return chargeCodeFieldsMap;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#addInvestigation
	 * (jkt.hms.masters.business.DgMasInvestigation)
	 */
	@SuppressWarnings("unchecked")
	public boolean addInvestigation(DgMasInvestigation dgMasInvestigation) {
		LOGGER.info("in addInvestigation");
		boolean dataSaved = false;
		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgMasInvestigation);
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#editInvestigation
	 * (jkt.hms.masters.business.DgMasInvestigation)
	 */

	@SuppressWarnings("unchecked")
	public boolean editInvestigation(Map<String, Object> generalMap) {
		LOGGER.info("in editInvestigation");
		boolean editedSuccessfully = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";
		String quantity = "";
		String normalValue = "";
		String minNormalValue = "";
		String maxNormalValue = "";
		String confidential = "";
		String dischargeSummary = "";
		String investigationType = "";
		String rareCommon = "";
		String variation = "n";
		String screenTest = "";
		String reactionTest = "";
		String lioncCodeId = "";
		String remarks = "";
		String submittedByOPD = "";
		String phInvestigation = "";
		Users users = null;
		String invShortCode=null;
		if (generalMap.get("remarks") != null) {
			remarks = (String) generalMap.get("remarks");
		}
		if (generalMap.get("invShortCode") != null) {
			invShortCode = (String) generalMap.get("invShortCode");
		}
		users = (Users) generalMap.get(RequestConstants.USERS);
		screenTest = (String) generalMap.get("screenTest");
		lioncCodeId = (String) generalMap.get("lioncCodeId");
		reactionTest = (String) generalMap.get("reactionTest");
		int investigationId = (Integer) generalMap.get("investigationId");
		int mainChargecodeId = (Integer) generalMap.get("mainChargeId");
		String investigationName = (String) generalMap.get("investigationName");
		int chargeCodeId = (Integer) generalMap.get("chargeCodeId");
		int subChargeCodeId = (Integer) generalMap.get("subChargeId");
		int sampleId = 0;
		sampleId = (Integer) generalMap.get("sampleId");
		int collectionId = 0;
		collectionId = (Integer) generalMap.get("collectionId");
		int uomId = 0;
		uomId = (Integer) generalMap.get("unitOfResult");
		quantity = (String) generalMap.get("quantity");
		normalValue = (String) generalMap.get("normalValue");
		minNormalValue = (String) generalMap.get("minNormalValue");
		maxNormalValue = (String) generalMap.get("maxNormalValue");
		confidential = (String) generalMap.get("checkBoxConfidence");
		dischargeSummary = (String) generalMap.get("checkBoxDischargeSummary");
		investigationType = (String) generalMap.get("investigationType");
		submittedByOPD = (String) generalMap.get("submittedByOPD");
		phInvestigation= (String) generalMap.get("phInvestigation");
		
		
		rareCommon = (String) generalMap.get("rareCommon");
		if (generalMap.get("variation") != null) {
			variation = (String) generalMap.get("variation");
		}
		DgMasInvestigation dgMasInvestigation2 = (DgMasInvestigation) getHibernateTemplate()
				.get(DgMasInvestigation.class, investigationId);
		if (investigationId != '0') {
			dgMasInvestigation2.setId(investigationId);

			dgMasInvestigation2.setInvestigationName(investigationName);
			if (lioncCodeId != null && !(lioncCodeId).equals("")) {
				MasLionc masLionc = new MasLionc();
				masLionc.setId(lioncCodeId);
				dgMasInvestigation2.setLoincNum(masLionc);
			}

			dgMasInvestigation2.setInvestigationType(investigationType);

			MasMainChargecode masMainChargecode = new MasMainChargecode();
			masMainChargecode.setId(mainChargecodeId);
			dgMasInvestigation2.setMainChargecode(masMainChargecode);

			MasSubChargecode masSubChargecode = new MasSubChargecode();
			masSubChargecode.setId(subChargeCodeId);
			dgMasInvestigation2.setSubChargecode(masSubChargecode);

			MasChargeCode masChargeCode = new MasChargeCode();
			masChargeCode.setId(chargeCodeId);
			dgMasInvestigation2.setChargeCode(masChargeCode);

			if (sampleId != 0) {
				MasSample masSample = new MasSample();
				masSample.setId(sampleId);
				dgMasInvestigation2.setSample(masSample);
			}
			if (uomId != 0) {
				DgUom dgUom = new DgUom();
				dgUom.setId(uomId);
				dgMasInvestigation2.setUom(dgUom);
			}

			if (collectionId != 0) {
				DgMasCollection dgMasCollection = new DgMasCollection();
				dgMasCollection.setId(collectionId);
				dgMasInvestigation2.setCollection(dgMasCollection);
			}
			dgMasInvestigation2.setQuantity(quantity);

			if ((normalValue != null && !normalValue.equals(""))
					|| (minNormalValue == null && minNormalValue.equals("")
							&& maxNormalValue == null && maxNormalValue
								.equals(""))) {
				dgMasInvestigation2.setNormalValue(normalValue);
				dgMasInvestigation2.setMinNormalValue("");
				dgMasInvestigation2.setMaxNormalValue("");
			}
			if ((minNormalValue != null && !minNormalValue.equals(""))
					|| ((normalValue == null && normalValue.equals("")))) {
				dgMasInvestigation2.setNormalValue("");
				dgMasInvestigation2.setMinNormalValue(minNormalValue);
			}
			if ((maxNormalValue != null && !maxNormalValue.equals(""))
					|| ((normalValue == null && normalValue.equals("")))) {
				dgMasInvestigation2.setNormalValue("");
				dgMasInvestigation2.setMaxNormalValue(maxNormalValue);
			}
			dgMasInvestigation2.setBloodBankScreenTest(screenTest);
			dgMasInvestigation2.setBloodReactionTest(reactionTest);
			dgMasInvestigation2.setRareCommon(rareCommon);
			dgMasInvestigation2.setConfidential(confidential);
			dgMasInvestigation2.setAppearInDischargeSummary(dischargeSummary);
			dgMasInvestigation2.setLastChgBy(users);
			dgMasInvestigation2.setLastChgDate(currentDate);
			dgMasInvestigation2.setLastChgTime(currentTime);
			dgMasInvestigation2.setVariationRequired(variation);
			dgMasInvestigation2.setRemark(remarks);
			LOGGER.info("submittedByOPD in data="+submittedByOPD);
			dgMasInvestigation2.setSubmittedByDoctor(submittedByOPD);
			dgMasInvestigation2.setPhLab(phInvestigation);
			dgMasInvestigation2.setInvestigationShortCode(invShortCode);
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(dgMasInvestigation2);
		editedSuccessfully = true;
		return editedSuccessfully;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteInvestigation(int investigationId,
			Map<String, Object> generalMap) {
		LOGGER.info("in deleteInvestigation");
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		DgMasInvestigation masCaseType = new DgMasInvestigation();
		masCaseType = (DgMasInvestigation) getHibernateTemplate().get(
				DgMasInvestigation.class, investigationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		Users users = (Users) generalMap.get(RequestConstants.USERS);
		if (generalMap.get("flag") != null) {
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			List departmentList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasDepartment as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			List chargeTypeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasChargeCode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			List sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			@SuppressWarnings("unused")
			List unitOfMeasurementList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.DgUom as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masCaseType.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masCaseType.setStatus("y");
				dataDeleted = false;
			}
		}
		masCaseType.setLastChgBy(users);
		masCaseType.setLastChgDate(currentDate);
		masCaseType.setLastChgTime(currentTime);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masCaseType);
		return dataDeleted;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getSubTestList
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSubTestList(Box box) {
		LOGGER.info("in getSubTestList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSubMasInvestigation> subCodeList = new ArrayList<DgSubMasInvestigation>();
		subCodeList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgSubMasInvestigation as mi where  mi.Id = "
						+ box.getInt(RequestConstants.SUBTEST_ID) + "");
		map.put("subCodeList", subCodeList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean submitNormalValues(Box box) {
		LOGGER.info("in submitNormalValues");
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<DgNormalValue> subTestList = new ArrayList<DgNormalValue>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		int submitNormalValues = box.getInt("submitNormalValues");
		int i = 0;
		Vector fromAge = box.getVector(RequestConstants.FROM_AGE);
		Vector toAge = box.getVector(RequestConstants.TO_AGE);
		Vector sex = box.getVector(RequestConstants.SEX);
		Vector minNormalValue = box
				.getVector(RequestConstants.MIN_NORMAL_VALUE);
		Vector maxNormalValue = box
				.getVector(RequestConstants.MAX_NORMAL_VALUE);
		Vector normalValue = box.getVector(RequestConstants.NORMAL_VALUE);
		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int subTestId = box.getInt(RequestConstants.SUBTEST_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		DgSubMasInvestigation dgSubMasObj = new DgSubMasInvestigation();
		dgSubMasObj.setId(subTestId);
		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			for (i = 0; i < sex.size(); i++) {
				if (sex.get(i) != null && !sex.get(i).equals("0")) {
					DgNormalValue dgNormalValue = new DgNormalValue();
					dgNormalValue.setChargeCode(masChargeCode);
					dgNormalValue.setSubInvestigation(dgSubMasObj);
					if (!fromAge.get(i).equals("")) {
						dgNormalValue.setFromAge(Integer
								.parseInt((String) fromAge.get(i)));
					}
					if (!toAge.get(i).equals("")) {
						dgNormalValue.setToAge(Integer.parseInt((String) toAge
								.get(i)));
					}
					if (minNormalValue.size() > i) {
						if (!minNormalValue.get(i).equals("")) {
							dgNormalValue
									.setMinNormalValue((String) minNormalValue
											.get(i));
						}
					}
					if (maxNormalValue.size() > i) {
						if (!maxNormalValue.get(i).equals("")) {
							dgNormalValue
									.setMaxNormalValue((String) maxNormalValue
											.get(i));
						}
					}
					if (!sex.get(i).equals("")) {
						dgNormalValue.setSex((String) sex.get(i));
					}
					if (normalValue.size() > i) {
						if (!normalValue.get(i).equals("")) {
							dgNormalValue.setNormalValue((String) normalValue
									.get(i));
						}
					}
					hbt.save(dgNormalValue);
				}
			}
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitFixedValues
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitFixedValues(Box box) {
		LOGGER.info("in submitFixedValues");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		boolean dataSaved = false;
		int i = 0;
		// amcTDetailsListSize
		// Vector fixedValue1 = box.getVector("fixedValue1");
		Integer fixedValueSize = box.getInt("amcTDetailsListSize");
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (i = 0; i < subTestId.size(); i++) {
				if (subTestId.get(i) != null && !subTestId.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasObj = new DgSubMasInvestigation();
					dgSubMasObj.setId(Integer.parseInt((String) subTestId
							.get(i)));
					for (int x = 1; x <= fixedValueSize; x++) {
						DgFixedValue dgFixedValue = new DgFixedValue();
						dgFixedValue.setSubInvestigation(dgSubMasObj);
						dgFixedValue.setFixedValue(box.getString("fixedValue"
								+ x));
						hbt.save(dgFixedValue);
					}

					/*
					 * if (fixedValue1.get(i) != null &&
					 * !fixedValue1.get(i).equals("")) {
					 * 
					 * dgFixedValue1.setSubInvestigation(dgSubMasObj1);
					 * dgFixedValue1 .setFixedValue((String)
					 * fixedValue1.get(i)); }
					 * 
					 * hbt.save(dgFixedValue1);
					 */
				}
			}
			dataSaved = true;

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			dataSaved = false;
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitTemplate
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitTemplate(Map<String, Object> dataMap) {
		LOGGER.info("in submitTemplate");
		Session session = (Session) getSession();

		DgMasInvestigation dgMasInv = (DgMasInvestigation) dataMap
				.get("dgMasInv");

		int chargeCodeId = (Integer) dataMap.get("chargeCodeId");
		DgTemplate dgTemp = (DgTemplate) dataMap.get("dgTemp");
		boolean dataSaved = false;
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		try {

			hbt.saveOrUpdate(dgMasInv);
			hbt.refresh(dgMasInv);
			hbt.save(dgTemp);
			dataSaved = true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#updateTemplate
	 * (jkt.hms.util.Box)
	 */
	@SuppressWarnings("unchecked")
	public boolean updateTemplate(Map<String, Object> map) {
		LOGGER.info("in updateTemplate");
		boolean dataUpdated = false;
		int i = 0;
		int Id = (Integer) map.get("templateId");
		byte[] result = (byte[]) map.get("result");
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		DgTemplate dgTemplate = (DgTemplate) hbt.load(DgTemplate.class, Id);
		dgTemplate.setResult(result);
		hbt.update(dgTemplate);
		dataUpdated = true;
		return dataUpdated;
	}

	/** for updation of normal value * */
	@SuppressWarnings("unchecked")
	public boolean updateNormalValue(Box box) {
		LOGGER.info("in updateNormalValue");
		boolean dataUpdated = false;
		int i = 0;
		Vector fromAge = box.getVector(RequestConstants.FROM_AGE);
		Vector toAge = box.getVector(RequestConstants.TO_AGE);
		Vector sex = box.getVector(RequestConstants.SEX);
		Vector minNormalValue = box
				.getVector(RequestConstants.MIN_NORMAL_VALUE);
		Vector maxNormalValue = box
				.getVector(RequestConstants.MAX_NORMAL_VALUE);
		Vector normalValue = box.getVector(RequestConstants.NORMAL_VALUE);

		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
		Vector normalId = box.getVector(RequestConstants.NORMAL_ID);

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		for (i = 0; i < subTestId.size(); i++) {
			DgNormalValue dgNormalValue = new DgNormalValue();
			if (subTestId.get(i).toString() != null
					&& !subTestId.get(i).toString().equals("")) {
				int sId = Integer.parseInt(subTestId.get(i).toString());
				int nId = Integer.parseInt(normalId.get(i).toString());
				dgNormalValue = (DgNormalValue) getHibernateTemplate().load(
						DgNormalValue.class, nId);
				if (toAge.get(i) != null && !toAge.get(i).equals("")) {
					dgNormalValue.setToAge(Integer.parseInt((String) toAge
							.get(i)));
				}

				if (sex.get(i) != null && !sex.get(i).equals("")) {
					dgNormalValue.setSex((String) sex.get(i));
				}

				if (fromAge.get(i) != null && !fromAge.get(i).equals("")) {
					dgNormalValue.setFromAge(Integer.parseInt((String) fromAge
							.get(i)));
				}
				if (minNormalValue.get(i) != null
						&& !minNormalValue.get(i).equals("")) {
					dgNormalValue.setMinNormalValue((String) minNormalValue
							.get(i));
				}
				if (maxNormalValue.get(i) != null
						&& !maxNormalValue.get(i).equals("")) {
					dgNormalValue.setMaxNormalValue((String) maxNormalValue
							.get(i));
				}
				hbt.saveOrUpdate(dgNormalValue);
			}
		}
		return dataUpdated;
	}

	@SuppressWarnings("unchecked")
	public boolean updateFixedValues(Box box) {
		LOGGER.info("in updateFixedValues");
		boolean dataUpdated = false;
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		Vector fixedValue = box.getVector(RequestConstants.FIXED_VALUE);
		try {
			for (int j = 0; j < fixedValue.size(); j++) {
				DgFixedValue dgFixedValue = new DgFixedValue();
				int sId = Integer.parseInt(fixedId.get(j).toString());
				dgFixedValue = (DgFixedValue) getHibernateTemplate().load(
						DgFixedValue.class, sId);
				dgFixedValue.setFixedValue((String) fixedValue.get(j));
				hbt.update(dgFixedValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataUpdated;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * generateResultNumber(java.util.Map)
	 */

	@SuppressWarnings("unchecked")
	public String generateResultNumber(Map<String, Object> diagMap) {
		LOGGER.info("in generateResultNumber");
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> resultSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String resultSeqNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
		String month = "";
		String year = "";
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		resultSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RES")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (resultSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : resultSeqNoList) {
				TransactionSequence obj = (TransactionSequence) resultSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				transactionSequenceObj.setTransactionSequenceNumber(++seqNo);
				hbt.update(transactionSequenceObj);

				resultSeqNo = resultSeqNo.concat(String.valueOf(seqNo));
				resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
				resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
			}
		} else if (resultSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgResultEntryHeader");
			tsObj.setTransactionPrefix("RES");
			tsObj.setTransactionSequenceName("Result No");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
		}
		return resultSeqNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#submitResultEntry
	 * (java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForMultiple(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForMultiple");
		Map<String, Object> map = new HashMap<String, Object>();
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		boolean saved = false;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		Users users = (Users) parameterMap.get(RequestConstants.USERS);
		String resultNo = box.getString(RequestConstants.RESULT_NO);
		String remarks = box.getString(RequestConstants.REMARKS);
		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
		int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);

		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(users);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("P");
		dgResultEntryHeader.setResultTime(time);
		dgResultEntryHeader.setResultType("m");
		dgResultEntryHeader.setVerified("Y");
		dgResultEntryHeader.setVerifiedOn(date);
		dgResultEntryHeader.setVerifiedTime(time);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		dgResultEntryHeader.setHospital(masHospital);

		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			dgResultEntryHeader.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}

		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
			dgResultEntryHeader.setResultVerifiedBy(masEmployee);
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(dgResultEntryHeader);
			Vector result = box.getVector(RequestConstants.RESULT);
			Vector additionalRemarks = box
					.getVector(RequestConstants.ADDITIONAL_REMARKS);
			Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);
			Vector sample_Id = box.getVector(SAMPLE_ID);
			Vector normalId = box.getVector(RequestConstants.NORMAL_ID);
			Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
			Vector uomId = box
					.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
			Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
			Vector investigationId = box
					.getVector(RequestConstants.INVESTIGATION_ID);
			Vector sampleDetailId = box
					.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID);

			for (int i = 0; i < subTestId.size(); i++) {
				if (subTestId.get(i) != null && !subTestId.get(i).equals("")) {
					DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
					if (sample_Id.get(i) != null
							&& !sample_Id.get(i).equals("")) {
						MasSample masSample = new MasSample();
						masSample.setId(Integer.parseInt((String) sample_Id
								.get(i)));
						dgResultEntryDetail.setSample(masSample);
					} else {
						dgResultEntryDetail.setSample(null);
					}
					if (normalId.get(i) != null && !normalId.get(i).equals("")) {

						DgNormalValue dgNormalValue = new DgNormalValue();
						dgNormalValue.setId(Integer.parseInt((String) normalId
								.get(i)));
						dgResultEntryDetail.setNormal(dgNormalValue);
					} else {
						dgResultEntryDetail.setNormal(null);
					}

					if (fixedId.get(i) != null && !fixedId.get(i).equals("")) {
						DgFixedValue dgFixedValue = new DgFixedValue();
						dgFixedValue.setId(Integer.parseInt((String) fixedId
								.get(i)));
						dgResultEntryDetail.setFixed(dgFixedValue);
					}

					if (investigationId.get(i) != null
							&& !investigationId.get(i).equals("")) {
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
					}
					if (investigationId.get(i) != null
							&& !investigationId.get(i).equals("")) {
						MasChargeCode masChargeCode = new MasChargeCode();
						masChargeCode.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail.setChargeCode(masChargeCode);
					}
					if (result != null && !result.equals("")) {
						dgResultEntryDetail.setResult((String) result.get(i));
					}

					if (additionalRemarks.get(i) != null) {
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
					}

					if (resultType != null && !resultType.equals("")) {
						dgResultEntryDetail.setResultType((String) resultType
								.get(i));
					}

					if (subTestId.get(i) != null
							&& !subTestId.get(i).equals("")) {
						DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
						dgSubMasInvestigation.setId(Integer
								.parseInt((String) subTestId.get(i)));
						dgResultEntryDetail
								.setSubInvestigation(dgSubMasInvestigation);
					}
					dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setValidated("Y");

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgResultEntryDetail.setUom(dgUom);
					}
					if (sampleDetailId.get(i) != null
							&& !sampleDetailId.get(i).equals("")) {
						DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
						dgSample.setId(Integer.parseInt((String) sampleDetailId
								.get(i)));
						dgResultEntryDetail
								.setSampleCollectionDetails(dgSample);
					}
					dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
					hbt.save(dgResultEntryDetail);
					map.put("resultType", (String) resultType.get(i));
					int sId = Integer.parseInt((String) sampleDetailId.get(i));
					DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
							.load(DgSampleCollectionDetails.class, sId);
					dgDetails.setOrderStatus("E");
					hbt.update(dgDetails);
					hbt.refresh(dgDetails);

				}
			}

			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}
		map.put("saved", saved);
		map.put("resultNo", resultNo);

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultEntryForSingleParameter(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameterWithNormalValue(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSingleParameterWithNormalValue");
		Map<String, Object> map = new HashMap<String, Object>();
		DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
		boolean saved = false;
		Transaction tx = null;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		Users users = (Users) parameterMap.get(RequestConstants.USERS);
		String resultNo = box.getString(RequestConstants.RESULT_NO);
		String remarks = box.getString(RequestConstants.REMARKS);

		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
		int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);

		dgResultEntryHeader.setResultNo(resultNo);
		dgResultEntryHeader.setLastChgdBy(users);
		dgResultEntryHeader.setLastChgdDate(date);
		dgResultEntryHeader.setLastChgdTime(time);
		dgResultEntryHeader.setRemarks(remarks);
		dgResultEntryHeader.setResultDate(date);
		dgResultEntryHeader.setResultStatus("A");
		dgResultEntryHeader.setResultTime(time);
		dgResultEntryHeader.setResultType("s");
		dgResultEntryHeader.setVerified("Y");
		dgResultEntryHeader.setVerifiedOn(date);
		dgResultEntryHeader.setVerifiedTime(time);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeId);
		dgResultEntryHeader.setMainChargecode(masMainChargecode);

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subchargeId);
		dgResultEntryHeader.setSubChargecode(masSubChargecode);

		DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
		dgSampleCollectionHeader.setId(sampleCollectionId);
		dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(deptId);
		dgResultEntryHeader.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		dgResultEntryHeader.setHospital(masHospital);
		if (hinId != 0) {
			Patient patient = new Patient();
			patient.setId(hinId);
			dgResultEntryHeader.setHin(patient);
		}
		if (inpatientId != 0) {
			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			dgResultEntryHeader.setInpatient(inpatient);
		}
		if (employeeId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			dgResultEntryHeader.setEmployee(masEmployee);
			dgResultEntryHeader.setResultVerifiedBy(masEmployee);
		}
		if (resultEnteredId != 0) {
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(resultEnteredId);
			dgResultEntryHeader.setEmployee(masEmployee);
		}

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			hbt.save(dgResultEntryHeader);

			String result = box.getString(RequestConstants.RESULT);

			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			int charge_code_Id = box.getInt(CHARGE_CODE_ID);
			int sample_Id = box.getInt(SAMPLE_ID);
			int investigationId = box.getInt(RequestConstants.INVESTIGATION_ID);
			int uomId = box.getInt(RequestConstants.UNIT_OF_MEASUREMENT_ID);
			String resultType = box.getString(RequestConstants.RESULT_TYPE);
			int sampleDetailId = box
					.getInt(RequestConstants.DG_SAMPLE_DETAIL_ID);

			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			if (investigationId != 0) {
				if (sample_Id != 0) {
					MasSample masSample = new MasSample();
					masSample.setId(sample_Id);
					dgResultEntryDetail.setSample(masSample);
				}

				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetail.setInvestigation(dgMasInvestigation);
				}
				dgResultEntryDetail.setResult(result);
				dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResultType(resultType);
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setValidated("Y");

				if (charge_code_Id != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(charge_code_Id);
					dgResultEntryDetail.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetail.setSampleCollectionDetails(dgSample);
				}
				if (uomId != 0) {
					DgUom dgUom = new DgUom();
					dgUom.setId(uomId);
					dgResultEntryDetail.setUom(dgUom);
				}
				hbt.save(dgResultEntryDetail);
				map.put("resultType", resultType);
				DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
						.load(DgSampleCollectionDetails.class, sampleDetailId);
				dgDetails.setOrderStatus("E");
				hbt.update(dgDetails);
				hbt.refresh(dgDetails);

			}
			saved = true;
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}

		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getPatientDetailsForResultValidation(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForResultValidation(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForResultValidation");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int resultId = 0;
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		Integer hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}

		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");
		}
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "A"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId));
			if (!deptType.equalsIgnoreCase("RADIO")) {
				crit = crit.add(Restrictions.between("ResultDate", fromDate,
						toDate));
			}
			//
			crit = crit.createAlias("Hin", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}

		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		Date sampleCollDate = new Date();
		if (deptType.equalsIgnoreCase("RADIO")) {
			for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetails();
				for (DgResultEntryDetail dgResultEntryDetail : dgResultEntrySet) {
					DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
							.getSampleCollectionDetails();
					Date sampleCollectionDate = dgSampleCollectionDetails
							.getSampleCollDatetime();

					sampleCollDateString = HMSUtil
							.convertDateToStringWithoutTime(sampleCollectionDate);
					sampleCollDate = HMSUtil
							.convertStringTypeDateToDateType(sampleCollDateString);
					if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
							.compareTo(toDate) <= 0)) {
						patientListTemp.add(dgResultEntryHeader);
					}
				}
			}
			patientList = patientListTemp;
			// patientList.removeAll(patientListTemp);
		}

		map.put("patientDetailsList", patientList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getSampleCollectionDetails(int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetails(
			int sampleCollectionDetailId, int deptId) {
		LOGGER.info("in getSampleCollectionDetails");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgFixedValue> fixedValAllList = new ArrayList<DgFixedValue>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int subTestId = 0;
		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			sampleCollectionList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("Id", sampleCollectionDetailId))
					.list();
			if (sampleCollectionList.size() > 0) {
				detailsMap.put("sampleCollectionList", sampleCollectionList);

			}
			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();
					subList = session
							.createCriteria(DgSubMasInvestigation.class)
							.add(Restrictions.eq("Investigation.Id",
									investigationId))
							.addOrder(Order.asc("OrderNo")).list();

				}
			}
			if (subList.size() > 0) {
				// for(DgSubMasInvestigation dgSubMasInvestigation : subList){
				detailsMap.put("subList", subList);
				// }
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subInvSet = dgApp.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

					fixedValList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
									+ subTestId + "' and ga.FixedValue != null");
					if (fixedValList.size() > 0) {
						fixedValAllList.addAll(fixedValList);
						detailsMap.put("fixedValList", fixedValAllList);

					}
				}

			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subTempSet = dgApp.getInvestigation().getDgTemplates();
				for (DgTemplate dgTemplate : subTempSet) {
					investigationId = dgTemplate.getInvestigation().getId();
					templateList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= '"
									+ investigationId + "'");

					if (templateList.size() > 0) {
						detailsMap.put("templateList", templateList);
					}
				}
			}
			Criteria criteria = null;
			criteria = session.createCriteria(DgResultEntryDetail.class).add(
					Restrictions.eq("SampleCollectionDetails.Id",
							sampleCollectionDetailId));
			dgResultEntryDetailList = criteria.list();
			detailsMap.put("dgResultEntryDetailListForResult",
					dgResultEntryDetailList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//added by govind 15-01-2018
		List<DgOrderdt> orderList=null;
		if(sampleCollectionList.size()>0){
			DgSampleCollectionHeader samplHeader=sampleCollectionList.get(0).getSampleCollectionHeader()!=null?sampleCollectionList.get(0).getSampleCollectionHeader():null;
			if(samplHeader!=null && samplHeader.getOrder()!=null){
				orderList=session.createCriteria(DgOrderdt.class)
						.add(Restrictions.eq("Orderhd.Id", samplHeader.getOrder().getId())).list();					
			}
		}
		Map<Integer,Object> orderChargeMap=new HashMap<Integer,Object>();
		if(orderList.size()>0){
			for(DgOrderdt odt:orderList){
				orderChargeMap.put(odt.getChargeCode().getId(), odt);
			}
		}
		detailsMap.put("orderChargeMap", orderChargeMap);
		//added by govind 15-01-2018 end
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getResultList
	 * (int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultList(int resultId) {
		LOGGER.info("in getResultList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> resultHeaderList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> resultDetailList = new ArrayList<DgResultEntryDetail>();
		resultHeaderList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.DgResultEntryHeader as md where md.Id='"
						+ resultId + "'");
		resultDetailList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.DgResultEntryDetail as md where md.ResultEntry.Id ='"
						+ resultId + "'");

		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getResultEntryDetails(int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultEntryDetails(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultEntryDetails");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		int fixedId = 0;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List<UploadDocuments> documentList = new ArrayList<UploadDocuments>();
		Integer hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		Integer deptId = (Integer) mapForDs.get("deptId");
		Integer resultId = (Integer) mapForDs.get("resultId");
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Id", resultId)).list();
			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();

					resultHeaderId = dgResultHeader.getId();

				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session
							.createCriteria(DgResultEntryDetail.class)
							.add(Restrictions.eq("ResultEntry.Id",
									resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "P"))
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session
							.createCriteria(DgResultEntryDetailSen.class)
							.createAlias("ResultEntry", "rs")
							.add(Restrictions.eq("rs.Id", resultHeaderId))
							.list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session
						.createCriteria(DgMasOrganismGroup.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session
						.createCriteria(MasAntibioticLab.class)
						.add(Restrictions.eq("Status", "y").ignoreCase())
						.list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}

			}
			
			documentList = session.createCriteria(UploadDocuments.class)
					.createAlias("ResultEntry", "resultEntry")
					.add(Restrictions.eq("resultEntry.Id", resultId))
					.list();
			detailsMap.put("documentList", documentList);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> getResultEntryDetailsLab(
			Map<String, Object> requestMap) {
		LOGGER.info("in getResultEntryDetailsLab");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Map<String, Object> fixedListMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		int fixedId = 0;
		int deptId = 0;
		String resultId = "";
		String stringOfIds = "";
		Integer stringSubDeptIds = 0;
		Integer resultIdToRemove = 0;
		String[] idsArray = new String[0];
		String[] headerIdsValue = new String[0];
		List<Integer> headerIdsInt = new ArrayList<Integer>();
		Integer hospitalId = null;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();//added by govind
		List<DgSubMasInvestigation> subListNew = new ArrayList<DgSubMasInvestigation>();
		int index=0,myIndex=0;//added by govind 26-10-2016
		if (requestMap.get("resultId") != null) {
			resultId = (String) requestMap.get("resultId");
		}
		if (requestMap.get("resultIdToRemove") != null) {
			resultIdToRemove = (Integer) requestMap.get("resultIdToRemove");
		}

		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}
		if (requestMap.get("hospitalId") != null) {
			hospitalId = (Integer) requestMap.get("hospitalId");
		}
		/*
		 * if(resultIdToRemove != 0){ if(!resultId.equals("")){ idsArray =
		 * resultId.split("@"); stringOfIds = idsArray[0]; stringSubDeptIds =
		 * Integer.parseInt(idsArray[1]);
		 * 
		 * for(String id : headerIdsValue ){
		 * headerIdsInt.add(Integer.parseInt(id)); } } }else{
		 */
		if (!resultId.equals("")) {
			idsArray = resultId.split("@");
			stringOfIds = idsArray[0];
			stringSubDeptIds = Integer.parseInt(idsArray[1]);

			headerIdsValue = stringOfIds.split(",");
			for (String id : headerIdsValue) {
				headerIdsInt.add(Integer.parseInt(id));
			}
		}
		//
		//
		// }
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.in("Id", headerIdsInt))
					.add(Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
					.add(Restrictions.eq("ResultStatus", "P")).list();

			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);

			}
			
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();
				}
				LOGGER.info("resultHeaderId "+resultHeaderId);
				if (resultHeaderId > 0) {
					dgResultdetailList = session
							.createCriteria(DgResultEntryDetail.class)
							.add(Restrictions.eq("ResultEntry.Id",
									resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "P")) 
							.createAlias("SubInvestigation", "subInv")
							//.addOrder(Order.asc("subInv.OrderNo"))
							.addOrder(Order.asc("Id"))
							.list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session
							.createCriteria(DgResultEntryDetailSen.class)
							.createAlias("ResultEntry", "rs")
							.add(Restrictions.eq("rs.Id", resultHeaderId))
							.list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						
						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						LOGGER.info("fixedValList "+fixedValList.size());
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
							
						}
					}
					
				}
				
				//added by govind 25-10-2016
				int hCuount=0;
				for (DgResultEntryHeader dgResultHeader : resultList) {
					
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();
					if (resultHeaderId > 0) {
						dgResultdetailList = session
								.createCriteria(DgResultEntryDetail.class)
								.add(Restrictions.eq("ResultEntry.Id",
										resultHeaderId))
								.add(Restrictions.or(Restrictions.eq("ResultDetailStatus", "P"),Restrictions.eq("ResultDetailStatus", "A")))
								//.createAlias("SubInvestigation", "subInv")
								//.addOrder(Order.asc("subInv.OrderNo"))
								.addOrder(Order.asc("Id"))
								.list();
						
						if(dgResultdetailList.size()>0){
							hCuount++;
						for (DgResultEntryDetail dgDetail : dgResultdetailList) {
							index=index+1;
							if(dgDetail.getResult()!=null){
							if(dgDetail.getResult().equalsIgnoreCase("Positive") || dgDetail.getResult().equalsIgnoreCase("Negative")){
								myIndex=index;
							}
						   }
							if (dgDetail.getFixed() != null) {
								fixedId = dgDetail.getSubInvestigation().getId();
								System.out.println("fixedId "+fixedId);
								
								fixedValList = getHibernateTemplate().find(
										"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
												+ fixedId
												+ "' and ga.FixedValue != null");
								if (fixedValList.size() > 0) {
									//detailsMap.put("fixedValList", fixedValList);
									fixedListMap.put(""+fixedId, fixedValList);//added by govind 25-10-2016
								}
							}
						}
						}
					}
				}
				
				//added by govind 25-10-2016 end
			}
		detailsMap.put("index", index);
		detailsMap.put("fixedListMap", fixedListMap);//added by govind 25-10-2016
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
	
	public Map<String, Object> getResultEntryDetailsLabForPostQC(
			Map<String, Object> requestMap) {
		LOGGER.info("in getResultEntryDetailsLabForPostQC");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		int fixedId = 0;
		int deptId = 0;
		String resultId = "";
		String stringOfIds = "";
		Integer stringSubDeptIds = 0;
		Integer resultIdToRemove = 0;
		String[] idsArray = new String[0];
		String[] headerIdsValue = new String[0];
		List<Integer> headerIdsInt = new ArrayList<Integer>();
		Integer hospitalId = null;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
		List<MasAntibioticLab> masAntibioticLabList = new ArrayList<MasAntibioticLab>();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();

		if (requestMap.get("resultId") != null) {
			resultId = (String) requestMap.get("resultId");
		}
		if (requestMap.get("resultIdToRemove") != null) {
			resultIdToRemove = (Integer) requestMap.get("resultIdToRemove");
		}

		if (requestMap.get("deptId") != null) {
			deptId = (Integer) requestMap.get("deptId");
		}
		if (requestMap.get("hospitalId") != null) {
			hospitalId = (Integer) requestMap.get("hospitalId");
		}
		/*
		 * if(resultIdToRemove != 0){ if(!resultId.equals("")){ idsArray =
		 * resultId.split("@"); stringOfIds = idsArray[0]; stringSubDeptIds =
		 * Integer.parseInt(idsArray[1]);
		 * 
		 * for(String id : headerIdsValue ){
		 * headerIdsInt.add(Integer.parseInt(id)); } } }else{
		 */
		if (!resultId.equals("")) {
			idsArray = resultId.split("@");
			stringOfIds = idsArray[0];
			stringSubDeptIds = Integer.parseInt(idsArray[1]);

			headerIdsValue = stringOfIds.split(",");
			for (String id : headerIdsValue) {
				headerIdsInt.add(Integer.parseInt(id));
			}
		}
		//
		//
		// }
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.in("Id", headerIdsInt))
					.add(Restrictions.eq("SubChargecode.Id", stringSubDeptIds))
					.add(Restrictions.eq("ResultStatus", "Q").ignoreCase()).list();

			if (resultList != null || resultList.size() > 0) {
				detailsMap.put("resultList", resultList);

			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();
				}
				if (resultHeaderId > 0) {
					dgResultdetailList = session
							.createCriteria(DgResultEntryDetail.class)
							.add(Restrictions.eq("ResultEntry.Id",
									resultHeaderId))
							.add(Restrictions.eq("ResultDetailStatus", "Q").ignoreCase())
							.createAlias("SubInvestigation", "subInv")
							.addOrder(Order.asc("subInv.OrderNo")).list();
				}
				if (dgResultdetailList != null) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}

				if (resultHeaderId > 0) {
					dgResultEntryDetailSenList = session
							.createCriteria(DgResultEntryDetailSen.class)
							.createAlias("ResultEntry", "rs")
							.add(Restrictions.eq("rs.Id", resultHeaderId))
							.list();
				}
				if (dgResultEntryDetailSenList.size() > 0) {
					detailsMap.put("dgResultEntryDetailSenList",
							dgResultEntryDetailSenList);
				}
				dgOrgDtlList = session.createCriteria(DgOrgDtl.class).list();
				if (dgOrgDtlList.size() > 0) {
					detailsMap.put("dgOrgDtlList", dgOrgDtlList);
				}
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.list();
				if (dgOrgGrpDtlList.size() > 0) {
					detailsMap.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
				}
				dgMasOrganismGroupList = session.createCriteria(
						DgMasOrganismGroup.class).list();
				if (dgMasOrganismGroupList.size() > 0) {
					detailsMap.put("dgMasOrganismGroupList",
							dgMasOrganismGroupList);
				}
				dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
						.list();
				if (dgMasOrganismList.size() > 0) {
					detailsMap.put("dgMasOrganismList", dgMasOrganismList);
				}
				masAntibioticLabList = session.createCriteria(
						MasAntibioticLab.class).list();
				if (masAntibioticLabList.size() > 0) {
					detailsMap
							.put("masAntibioticLabList", masAntibioticLabList);
				}
				for (DgResultEntryDetail dgDetail : dgResultdetailList) {
					if (dgDetail.getFixed() != null) {
						fixedId = dgDetail.getSubInvestigation().getId();
						fixedValList = getHibernateTemplate().find(
								"from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
										+ fixedId
										+ "' and ga.FixedValue != null");
						if (fixedValList.size() > 0) {
							detailsMap.put("fixedValList", fixedValList);
						}
					}
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidation(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidationForMultiple(Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForMultiple");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}
			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			// dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			Vector dgResultDetailsId = box
					.getVector(RequestConstants.RESULT_DETAIL_ID);

			Vector result = box.getVector(RequestConstants.RESULT);
			Vector additionalRemarks = box
					.getVector(RequestConstants.ADDITIONAL_REMARKS);
			Vector validated = box.getVector(RequestConstants.VALIDATED);
			List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			dgResultDetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", resultId)).list();
			for (int i = 0; i < validated.size(); i++) {
				if (validated.get(i) != null && !validated.get(i).equals("")) {
					DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) hbt
							.load(DgResultEntryDetail.class,
									Integer.parseInt((String) dgResultDetailsId
											.get(i)));

					dgResultEntryDetail.setResultEntry(dgEntryHeader);
					dgResultEntryDetail.setValidated("Y");
					dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setRemarks((String) additionalRemarks
							.get(i));
					dgResultEntryDetail.setResult((String) result.get(i));

					hbt.saveOrUpdate(dgResultEntryDetail);
				}
			}

			List<DgResultEntryDetail> tempList = new ArrayList<DgResultEntryDetail>();
			tempList = session.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "res")
					.add(Restrictions.eq("res.Id", resultId)).list();

			String headerOrderStaus = "";
			for (DgResultEntryDetail object : tempList) {
				if (object.getResultDetailStatus().equals("P")) {
					headerOrderStaus = "P";
					break;
				} else {
					headerOrderStaus = "A";
				}

			}
			dgEntryHeader.setResultStatus(headerOrderStaus);
			hbt.saveOrUpdate(dgEntryHeader);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getPatientDetailsForReportCollection(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForReportCollection(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForReportCollection");
		Session session = (Session) getSession();
		Criteria crit = null;
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String diagnosisNo = "";
		int deptId = 0;
		Integer hospitalId = 0;
		String mobileNo = "";
		String wardName = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ mapForDs.get(RequestConstants.HOSPITAL_ID));
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}

		crit = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("Department.Id", deptId))
				.add(Restrictions.eq("ResultStatus", "A"))
				.add(Restrictions.between("VerifiedOn", fromDate, toDate))
				.createAlias("Hin", "pt");
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.like("ip.AdNo", adNo + "%"));
		}

		if (departmentId != 0) {

			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.createAlias("SubChargecode", "SubChargecode").add(
					Restrictions.like("SubChargecode.Id", subChargeCodeId));
		}

		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sh")
					.createAlias("sh.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getResultDetails
	 * (int)
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getResultDetails(int resultId) {
		LOGGER.info("in getResultDetails");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		int userId = 0;
		if (dataMap.get("userId") != null) {
			userId = Integer.parseInt("" + dataMap.get("userId"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		List<MasEmployee> prescribedByList = new ArrayList<MasEmployee>();
		int resultHeaderId = 0;
		Session session = (Session) getSession();
		Integer hospitalId = 0;
		try {
			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Verified", "V"))
					.add(Restrictions.eq("Id", resultId)).list();
			hospitalId = resultList.get(0).getHospital().getId();
			employeeList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("EmpCategory", "empCat")
					.add(Restrictions.eq("empCat.EmpCategoryName",
							"ParaMedical")).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			relationList = session.createCriteria(MasRelation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (relationList.size() > 0) {
				detailsMap.put("relationList", relationList);
			}
			prescribedByList = session
					.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("EmpCategory", "empCat")
					.add(Restrictions.not(Restrictions.eq(
							"empCat.EmpCategoryName", "Doctor"))).list();

			if (prescribedByList.size() > 0) {
				detailsMap.put("prescribedByList", prescribedByList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
			if (resultList.size() > 0) {
				detailsMap.put("resultList", resultList);
			}

			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();

				}
				dgResultdetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.eq("ResultEntry.Id", resultHeaderId))
						.createAlias("SubInvestigation", "subInv")
						.addOrder(Order.asc("subInv.OrderNo")).list();
				if (dgResultdetailList.size() > 0) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidationForSingleParameter(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidationForSingleParameter(
			Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForSingleParameter");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int hinId = 0;
		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}
		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}
			if (hinId != 0) {
				Patient patient = new Patient();
				patient.setId(hinId);
				dgEntryHeader.setHin(patient);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			String result = box.getString(RequestConstants.RESULT);
			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			String validated = box.getString(RequestConstants.VALIDATED);
			List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();

			dgResultDetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", resultId)).list();
			if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
				dgResultEntryDetail = dgResultDetailList.get(0);
				dgResultEntryDetail.setValidated("Y");
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setRemarks(additionalRemarks);
				dgResultEntryDetail.setResult(result);

				hbt.saveOrUpdate(dgResultEntryDetail);

			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public boolean submitResultValidationForSingleParameterOnly(
			Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForSingleParameterOnly");
		Session session =null;
		session= (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> validatedListSingleType = new ArrayList<String>();
		int hospitalId = 0;
		
		final Map<String, Object> dataForResult =  new HashMap<String, Object>(); // added by amit das on 14-09-2017
		Map<DgResultEntryHeader, Set<DgResultEntryDetail>> resultEntryMap = new HashMap<DgResultEntryHeader, Set<DgResultEntryDetail>>();  // added by amit das on 14-09-2017
		Set<DgResultEntryDetail> entryDetailsSet = null; // added by amit das on 14-09-2017
		DgResultEntryHeader dgResultEntryHeaderTemp = null; // added by amit das on 14-09-2017
		MasHospital hospital = null; // added by amit das on 14-09-2017
		

		boolean successfullyAdded = true;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListSingleType") != null) {
			validatedListSingleType = (List) infoMap
					.get("validatedListSingleType");
		}
		// added by amit das  on 15-09-2017
		if (infoMap.get("hospitalId") != null) {
			hospitalId = (Integer) infoMap
					.get("hospitalId");
		}

		Vector resultIdSingleValue = box.getVector(RESULT_ID_SINGLE_VALUE);

		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector qcResult = box
				.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector collectionId = box.getVector("collectionId");
		int resultValidatedBy = 0;

		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		//added by govind 29-06-2017
		int retestCountS=0;
		if (infoMap.get("retestCountS") != null) {
			retestCountS = (Integer)infoMap.get("retestCountS");
		}
		
		List<Integer> retestIdListS=new ArrayList<Integer>();
		if (infoMap.get("retestIdListS") != null) {
			retestIdListS = (List<Integer>)infoMap.get("retestIdListS");
		}
		//added by govind 29-06-2017 end
		//added by govind 15-07-2017 for recolecting 
		DgOrderhd recolOrderhd=null;
		String orderSeqNo = "";
		int recolCount=0;
		int tempChargeId=0;
		List<Integer> checkChargeId=new ArrayList<Integer>();
		DgResultEntryHeader dgEntryHeader = null;
		//added by govind 15-07-2017 for recolecting end
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt =null;
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hospital = hbt.get(MasHospital.class, hospitalId);
			for (int i = 0; i < resultIdSingleValue.size(); i++) {
				if (resultIdSingleValue.get(i) != null) {
					if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("y")) {
						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						if (resultValidatedBy != 0) {
							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(resultValidatedBy);
							dgEntryHeader.setResultVerifiedBy(masEmployee);
						}
                        if(retestIdListS.size()>0){
                        }else{
						dgEntryHeader.setVerified("V");
						dgEntryHeader.setVerifiedOn(date);
						dgEntryHeader.setVerifiedTime(time);
						dgEntryHeader.setResultStatus("A");
                        }
						/*save data for message*/ 
						DgOrderhd orderhd=dgEntryHeader.getSampleCollectionHeader().getOrder();
						if(dgEntryHeader.getHin().getMobileNumber()!=null){
							OneToOne messageToPatient=new OneToOne();
							messageToPatient.setMessage("UHID:"+orderhd.getHin().getHinNo()
										+" Name: "+orderhd.getHin().getFullName()
										+" your investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
										+" is ready kindly get the same collected");
							messageToPatient.setMobileNo(dgEntryHeader.getHin().getMobileNumber());
							messageToPatient.setSentDate(date);
							messageToPatient.setSentTime(time);
							messageToPatient.setStatus("U");
							messageToPatient.setType("T");  
							messageToPatient.setHospital(orderhd.getHospital());
							hbt.save(messageToPatient);
						}
						
						if("yes".equalsIgnoreCase(box.getString("sms"+i)) && orderhd.getPrescribedBy()!=null){
							OneToOne messageToDoctor=new OneToOne();
							messageToDoctor.setMessage("UHID:"+orderhd.getHin().getHinNo()
									+" Name: "+orderhd.getHin().getFullName()
									+" investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
									+" is abnormal kindly view the result");
							messageToDoctor.setMobileNo(orderhd.getPrescribedBy().getCellNoEmergency());
							messageToDoctor.setSentDate(date);
							messageToDoctor.setSentTime(time);
							messageToDoctor.setStatus("U");
							messageToDoctor.setType("T");  
							messageToDoctor.setHospital(orderhd.getHospital());
							hbt.save(messageToDoctor);
						}
						 
						hbt.update(dgEntryHeader);
						hbt.refresh(dgEntryHeader);
						LOGGER.info("%%%%%%%%%%%% resultId  "+resultId);
						List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
						dgResultDetailList = session
								.createCriteria(DgResultEntryDetail.class)
								.add(Restrictions
										.eq("ResultEntry.Id", resultId)).list();
						if (dgResultDetailList != null
								&& dgResultDetailList.size() > 0) {
							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
							dgResultEntryDetail = dgResultDetailList.get(0);
							dgResultEntryDetail.setValidated("V");
							dgResultEntryDetail.setResultDetailStatus("A");
							dgResultEntryDetail
									.setRemarks((String) additionalRemarks
											.get(i));
							dgResultEntryDetail.setResult((String) result.get(i));//added by govind 14-06-2017
							/*
							 * dgResultEntryDetail.setResult((String) result
							 * .get(i));
							 */
							hbt.saveOrUpdate(dgResultEntryDetail);
							hbt.refresh(dgResultEntryDetail);
						}
						// user mark as retest go in this condition
					} else if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("RT")) {
						
						//System.out.println("RT "+collectionId.get(i));
						//int sampleId=Integer.parseInt((String)collectionId.get(i));
						//added by govind 16-06-2017
						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgSampleCollectionHeader dgSampleCollectionHeader = dgEntryHeader
								.getSampleCollectionHeader();
						
					/*	DgSampleCollectionDetails sampleColl=hbt.load(DgSampleCollectionDetails.class, sampleId);
						sampleColl.setOrderStatus("A");
						hbt.update(sampleColl);
						
						/*Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
								.getDgSampleCollectionDetails();
						
						for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
							dgSampleCollectionDetails.setOrderStatus("A");
							hbt.update(dgSampleCollectionDetails);
						}*/
						
						dgSampleCollectionHeader.setOrderStatus("A");
						hbt.update(dgSampleCollectionHeader);
						dgEntryHeader.setResultStatus("R");//govind 16-06-2017 single param
						hbt.update(dgEntryHeader);
						
						List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
						dgResultDetailList = session
								.createCriteria(DgResultEntryDetail.class)
								.add(Restrictions
										.eq("ResultEntry.Id", resultId)).list();
						if (dgResultDetailList != null
								&& dgResultDetailList.size() > 0) {
							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
							dgResultEntryDetail = dgResultDetailList.get(0);
						dgResultEntryDetail.setValidated("Y");
						dgResultEntryDetail.setResultDetailStatus("A");
						//statusForRecollect = "R";
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						}
						//added by govind 16-06-2017 end 
						
						/*int resultId = Integer   //commented by govind 16-06-2017 end 
								.parseInt((String) resultIdSingleValue.get(i));
						DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgSampleCollectionHeader dgSampleCollectionHeader = dgEntryHeader
								.getSampleCollectionHeader();

						Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
								.getDgSampleCollectionDetails();
						for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
							dgSampleCollectionDetails.setOrderStatus("A");
							hbt.update(dgSampleCollectionDetails);
						}
						dgSampleCollectionHeader.setOrderStatus("A");
						hbt.update(dgSampleCollectionHeader);
						dgEntryHeader.setResultStatus("R");
						hbt.update(dgEntryHeader);*/
						// user mark as recollect go in this condition
					} else if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("RC")) {

						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgOrderhd dgOrderhd = dgEntryHeader
								.getSampleCollectionHeader().getOrder();
						Set<DgOrderdt> ordertDetailSet = dgOrderhd
								.getDgOrderdts();
						/*for (DgOrderdt dgOrderdt : ordertDetailSet) {//commented by govind 13-07-2017
							dgOrderdt.setOrderStatus("P");
							hbt.update(dgOrderdt);
						}*/
						dgOrderhd.setOrderStatus("P");
						hbt.update(dgOrderhd);
						dgEntryHeader.setResultStatus("R");
						hbt.update(dgEntryHeader);
						
						//added by govind 13-07-2017 for Recollecting Single Parameter
						if(recolCount==0){
							recolOrderhd=new DgOrderhd();
							orderSeqNo = labDataService.generateOrderNumber();
							LOGGER.info("recolecting orderseqNo "+orderSeqNo);
							recolOrderhd.setHin(dgOrderhd.getHin());
							recolOrderhd.setDepartment(dgOrderhd.getDepartment());
							recolOrderhd.setOrderDate(new Date());
							recolOrderhd.setOrderTime(time);
							recolOrderhd.setHospital(dgOrderhd.getHospital());
							recolOrderhd.setPrescribedBy(dgOrderhd.getPrescribedBy());
							recolOrderhd.setVisit(dgOrderhd.getVisit());
							recolOrderhd.setOrderNo(orderSeqNo);
							recolOrderhd.setTestType(dgOrderhd.getTestType());
							recolOrderhd.setNetAmount(dgOrderhd.getNetAmount());
							recolOrderhd.setClinicalNote(dgOrderhd.getClinicalNote());
							recolOrderhd.setOrderTime(time);
							recolOrderhd.setPatientType("OP");
							recolOrderhd.setOrderStatus("P");
							recolOrderhd.setLastChgBy(dgOrderhd.getLastChgBy());
							recolOrderhd.setLastChgDate(dgOrderhd.getLastChgDate());
							recolOrderhd.setLastChgTime(time);
							recolOrderhd.setRoutineUrgentStatus("r");
							recolOrderhd.setUrgentRemarks(dgOrderhd.getUrgentRemarks());
							recolOrderhd.setBulkOrder(dgOrderhd.getBulkOrder());
							hbt.save(recolOrderhd);
							
							
							PharmacyLabQueue OldlabQue =(PharmacyLabQueue)session.createCriteria(PharmacyLabQueue.class)
									.createAlias("DgOrderhdId", "head")
									.add(Restrictions.eq("head.Id", dgOrderhd.getId())).uniqueResult();
							
							PharmacyLabQueue labQue=new PharmacyLabQueue();
							labQue.setStatus("P");
							labQue.setVisit(OldlabQue.getVisit());
							labQue.setTokenNo(OldlabQue.getTokenNo());
							labQue.setDepartment(OldlabQue.getDepartment());
							labQue.setHospital(OldlabQue.getHospital());
							labQue.setOpdDate(new Date());
							labQue.setOpdTime(time);
							labQue.setPharmacyLabStatus(OldlabQue.getPharmacyLabStatus());
							labQue.setTotalHospitalVisit(OldlabQue.getTotalHospitalVisit());
							labQue.setDgOrderhdId(recolOrderhd);
							hbt.save(labQue);
						}
						recolCount++;
						LOGGER.info("dgOrderhd.getId "+dgOrderhd.getId()+" ChargeCode.Id "+dgEntryHeader.getInvestigation().getChargeCode().getId());
						
						
						
						List<DgOrderdt> dgOrderdList =session.createCriteria(DgOrderdt.class)
								.createAlias("Orderhd", "head")
								.add(Restrictions.eq("head.Id", dgOrderhd.getId()))
								.add(Restrictions.eq("ChargeCode.Id", dgEntryHeader.getInvestigation().getChargeCode().getId())).list();
						
						if(dgOrderdList.size()>0){							
						DgOrderdt dgOrderdtOld=dgOrderdList.get(0);
						DgOrderdt dgOrderdt=new DgOrderdt();
						dgOrderdt.setChargeCode(dgOrderdtOld.getChargeCode());
						dgOrderdt.setAmount(dgOrderdtOld.getAmount());
						dgOrderdt.setMainChargecode(dgOrderdtOld.getMainChargecode());
						dgOrderdt.setSubChargeid(dgOrderdtOld.getSubChargeid());
						dgOrderdt.setOrderQty(dgOrderdtOld.getOrderQty());
						dgOrderdt.setOrderStatus("P");
						dgOrderdt.setPaymentMade(dgOrderdtOld.getPaymentMade());
						dgOrderdt.setBill(dgOrderdtOld.getBill());
						dgOrderdt.setMsgSent(dgOrderdtOld.getMsgSent());
						dgOrderdt.setPacsStatus(dgOrderdtOld.getPacsStatus());
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(time);
						dgOrderdt.setLastChgBy(dgOrderdtOld.getLastChgBy());
						dgOrderdt.setOrderhd(recolOrderhd);
						hbt.save(dgOrderdt);
						}	
						//added by govind 13-07-2017 end
					}						

					//added by govind 29-06-2017
									for(Integer up:retestIdListS){
										//System.out.println("checkIdRetest collectionId "+up);	
										if(up>0){
										DgResultEntryDetail dgResultEntryDetail=hbt.load(DgResultEntryDetail.class, up);
										dgResultEntryDetail.setResultDetailStatus("A");
										hbt.saveOrUpdate(dgResultEntryDetail);
										hbt.refresh(dgResultEntryDetail);
										
									DgSampleCollectionDetails dgSampleCollectionDetails=dgResultEntryDetail.getSampleCollectionDetails();
											dgSampleCollectionDetails.setOrderStatus("A");
											hbt.update(dgSampleCollectionDetails);
										}
							         }
									//added by govind 29-06-2017
				}
				
				if (dgEntryHeader != null) {
					hbt.refresh(dgEntryHeader);
					entryDetailsSet = dgEntryHeader.getDgResultEntryDetails();
					Hibernate.initialize(entryDetailsSet);
					Hibernate.initialize(dgEntryHeader.getHin());
					Hibernate.initialize(dgEntryHeader.getSampleCollectionHeader().getOrder().getVisit());
					resultEntryMap.put(dgEntryHeader, entryDetailsSet);
				}
			}

			
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			successfullyAdded = false;
			e.printStackTrace();
		}
		
		Hibernate.initialize(hospital);
		dataForResult.put("resultMap", resultEntryMap); // added by amit das on  14-09-2017
		dataForResult.put("hospital", hospital);// added by amit das on  12-09-2017
		
		final MasHospital masHospital = hospital;
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
					if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
							resultManipulactionToCentralServer(dataForResult,"validation");
					} 
					if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
							resultManipulactionToLeanServer(dataForResult,"validation");
						
					}
			}
			
		}.start();*/
		
		return successfullyAdded;
	}
	
	public boolean submitResultValidationForSingleParameterOnlyForEmpanelled(
			Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForSingleParameterOnlyForEmpanelled");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		List<String> validatedListSingleType = new ArrayList<String>();

		boolean successfullyAdded = true;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListSingleType") != null) {
			validatedListSingleType = (List) infoMap
					.get("validatedListSingleType");
		}

		Vector resultIdSingleValue = box.getVector(RESULT_ID_SINGLE_VALUE);

		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector qcResult = box
				.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		int resultValidatedBy = 0;

		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int i = 0; i < resultIdSingleValue.size(); i++) {
				if (resultIdSingleValue.get(i) != null) {
					if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("y")) {
						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						if (resultValidatedBy != 0) {
							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(resultValidatedBy);
							//dgEntryHeader.setResultVerifiedBy(masEmployee);
						}

						dgEntryHeader.setVerified("V");
						dgEntryHeader.setVerifiedOn(date);
						dgEntryHeader.setVerifiedTime(time);
						dgEntryHeader.setResultStatus("A");
						/*save data for message*/ 
						DgOrderhd orderhd=dgEntryHeader.getSampleCollectionHeader().getOrder();
						if(dgEntryHeader.getHin().getMobileNumber()!=null){
							OneToOne messageToPatient=new OneToOne();
							messageToPatient.setMessage("UHID:"+orderhd.getHin().getHinNo()
										+" Name: "+orderhd.getHin().getFullName()
										+" your investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
										+" is ready kindly get the same collected");
							messageToPatient.setMobileNo(dgEntryHeader.getHin().getMobileNumber());
							messageToPatient.setSentDate(date);
							messageToPatient.setSentTime(time);
							messageToPatient.setStatus("U");
							messageToPatient.setType("T");  
							messageToPatient.setHospital(orderhd.getHospital());
							hbt.save(messageToPatient);
						}
						
						if("yes".equalsIgnoreCase(box.getString("sms"+i)) && orderhd.getPrescribedBy()!=null){
							OneToOne messageToDoctor=new OneToOne();
							messageToDoctor.setMessage("UHID:"+orderhd.getHin().getHinNo()
									+" Name: "+orderhd.getHin().getFullName()
									+" investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
									+" is abnormal kindly view the result");
							messageToDoctor.setMobileNo(orderhd.getPrescribedBy().getCellNoEmergency());
							messageToDoctor.setSentDate(date);
							messageToDoctor.setSentTime(time);
							messageToDoctor.setStatus("U");
							messageToDoctor.setType("T");  
							messageToDoctor.setHospital(orderhd.getHospital());
							hbt.save(messageToDoctor);
						}
						 
						hbt.update(dgEntryHeader);
						hbt.refresh(dgEntryHeader);

						List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
						dgResultDetailList = session
								.createCriteria(DgResultEntryDetail.class)
								.add(Restrictions
										.eq("ResultEntry.Id", resultId)).list();
						if (dgResultDetailList != null
								&& dgResultDetailList.size() > 0) {
							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
							dgResultEntryDetail = dgResultDetailList.get(0);
							dgResultEntryDetail.setValidated("V");
							dgResultEntryDetail.setResultDetailStatus("A");
							dgResultEntryDetail
									.setRemarks((String) additionalRemarks
											.get(i));
							/*
							 * dgResultEntryDetail.setResult((String) result
							 * .get(i));
							 */
							hbt.saveOrUpdate(dgResultEntryDetail);
							hbt.refresh(dgResultEntryDetail);
						}
						// user mark as retest go in this condition
					} else if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("RT")) {

						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgSampleCollectionHeader dgSampleCollectionHeader = dgEntryHeader
								.getSampleCollectionHeader();

						Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
								.getDgSampleCollectionDetails();
						for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
							dgSampleCollectionDetails.setOrderStatus("A");
							hbt.update(dgSampleCollectionDetails);
						}
						dgSampleCollectionHeader.setOrderStatus("A");
						hbt.update(dgSampleCollectionHeader);
						dgEntryHeader.setResultStatus("R");
						hbt.update(dgEntryHeader);
						// user mark as recollect go in this condition
					} else if (validatedListSingleType.get(i) != null
							&& validatedListSingleType.get(i).equals("RC")) {

						int resultId = Integer
								.parseInt((String) resultIdSingleValue.get(i));
						DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgOrderhd dgOrderhd = dgEntryHeader
								.getSampleCollectionHeader().getOrder();
						Set<DgOrderdt> ordertDetailSet = dgOrderhd
								.getDgOrderdts();
						for (DgOrderdt dgOrderdt : ordertDetailSet) {
							dgOrderdt.setOrderStatus("P");
							hbt.update(dgOrderdt);
						}
						dgOrderhd.setOrderStatus("P");
						hbt.update(dgOrderhd);
						dgEntryHeader.setResultStatus("R");
						hbt.update(dgEntryHeader);
					}
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultValidationForTemplate(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public boolean submitResultValidationForTemplate(Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForTemplate");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		String validated = "";
		String additionalRemarks = "";

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}

		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}

		if (infoMap.get("additionalRemarks") != null) {
			additionalRemarks = (String) infoMap.get("additionalRemarks");
		}

		if (infoMap.get("validated") != null) {
			validated = (String) infoMap.get("validated");
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);

			dgEntryHeader.setResultStatus("A");
			

			/*save data for message*/ 
			DgOrderhd orderhd=dgEntryHeader.getSampleCollectionHeader().getOrder();
			if(dgEntryHeader.getHin().getMobileNumber()!=null){
				OneToOne messageToPatient=new OneToOne();
				messageToPatient.setMessage("UHID:"+orderhd.getHin().getHinNo()
							+" Name: "+orderhd.getHin().getFullName()
							+" your investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
							+" is ready kindly get the same collected");
				messageToPatient.setMobileNo(dgEntryHeader.getHin().getMobileNumber());
				messageToPatient.setSentDate(date);
				messageToPatient.setSentTime(time);
				messageToPatient.setStatus("U");
				messageToPatient.setType("T"); 
				messageToPatient.setHospital(orderhd.getHospital());
				hbt.save(messageToPatient);
			}
			
			if("yes".equalsIgnoreCase(box.getString("sms")) && orderhd.getPrescribedBy()!=null){
				OneToOne messageToDoctor=new OneToOne();
				messageToDoctor.setMessage("UHID:"+orderhd.getHin().getHinNo()
						+" Name: "+orderhd.getHin().getFullName()
						+" investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
						+" is abnormal kindly view the result");
				messageToDoctor.setMobileNo(orderhd.getPrescribedBy().getCellNoEmergency());
				messageToDoctor.setSentDate(date);
				messageToDoctor.setSentTime(time);
				messageToDoctor.setStatus("U");
				messageToDoctor.setType("T");  
				messageToDoctor.setHospital(orderhd.getHospital());
				hbt.save(messageToDoctor);
			}
			
			hbt.update(dgEntryHeader);

			Vector result = box.getVector("test2");
			/*
			 * Vector additionalRemarks =
			 * box.getVector(RequestConstants.ADDITIONAL_REMARKS); Vector
			 * validated = box.getVector(RequestConstants.VALIDATED);
			 */List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			dgResultDetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", resultId)).list();
			/*
			 * for (int i = 0; i< validated.size() ; i++) {
			 */if (validated.equalsIgnoreCase("on")) {
				if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
					dgResultEntryDetail = dgResultDetailList.get(0);
					dgResultEntryDetail.setValidated("V");
					dgResultEntryDetail.setResultDetailStatus("A");
					dgResultEntryDetail.setRemarks(additionalRemarks);

					// dgResultEntryDetail.setResult((String)result.get(i));

					hbt.saveOrUpdate(dgResultEntryDetail);
				}
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForResultValidation()
	 */

	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForResultValidation(
			Map<String, Object> dataMap) {
		LOGGER.info("in getDetailsForResultValidation");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int currentLabId = 0; // added by amit das on 17-07-2017
		
		
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		Date FromDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
		Date ToDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
		
		// added by amit das on 17-07-2017
				MasHospital masHospital = (MasHospital)session.get(MasHospital.class, hospitalId);
				
				if(dataMap.get("userId")!=null){
					int userId = (Integer)dataMap.get("userId");
					Users user = (Users)session.get(Users.class, userId);
					
					if(user.getCurrentLab()!=null)
							currentLabId = 	user.getCurrentLab().getId();
					
				}

		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("MainChargecode", "mcc")
				.createAlias("mcc.Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId)).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		/*chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
		List<Integer>chargeTypeList=new ArrayList<Integer>();
		chargeTypeList.add(2);
		chargeTypeList.add(37);
		chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.in("ChargeType.Id",chargeTypeList))
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}

		detailsMap.put("currentLabId", currentLabId); // added by amit das on 17-07-2017
		detailsMap.put("masHospital", masHospital); // added by amit das on 18-07-2017
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * getDetailsForReportCollection()
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetailsForReportCollection(
			Map<String, Object> dataMap) {
		LOGGER.info("in getDetailsForReportCollection");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<DgResultEntryHeader> reportCollectionList = new ArrayList<DgResultEntryHeader>();
		Session session = (Session) getSession();

		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("MainChargecode", "mcc")
				.createAlias("mcc.Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId)).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}

		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jkt.hms.investigation.dataservice.InvestigationDataService#getDetails()
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getDetails(Map<String, Object> dataMap) {
		LOGGER.info("in getDetails");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		dgMasOrganismGroupList = session
				.createCriteria(DgMasOrganismGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("MainChargecode", "mn")
				.createAlias("mn.Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId)).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample ");
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}

		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}

		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}
		detailsMap.put("dgMasOrganismGroupList", dgMasOrganismGroupList);
		return detailsMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejkt.hms.investigation.dataservice.InvestigationDataService#
	 * submitResultEntryForTemplate(java.util.Map)
	 */
	/*
	 * @SuppressWarnings("unchecked") public Map<String, Object>
	 * submitResultEntryForTemplate(Map<String, Object> parameterMap) {
	 * Map<String, Object> map = new HashMap<String, Object>(); boolean saved =
	 * false; int sampleDetailId=0; DgResultEntryHeader dgResultEntryHeader =
	 * (DgResultEntryHeader)parameterMap.get("dgResultEntryHeader");
	 * DgResultEntryDetail dgResultEntryDetail =
	 * (DgResultEntryDetail)parameterMap.get("dgResultEntryDetail");
	 * if(dgResultEntryDetail
	 * .getSampleCollectionDetails().getSampleCollectionHeader().getHin() !=
	 * null){ sampleDetailId = (Integer)parameterMap.get("sampleDetailId"); }
	 * 
	 * session = (Session)getSession(); Transaction tx = null; try { tx =
	 * session.beginTransaction(); HibernateTemplate hbt=getHibernateTemplate();
	 * hbt.setFlushModeName("FLUSH_EAGER"); hbt.setCheckWriteOperations(false);
	 * hbt.save(dgResultEntryHeader); hbt.save(dgResultEntryDetail);
	 * 
	 * DgSampleCollectionDetails
	 * dgDetails=(DgSampleCollectionDetails)getHibernateTemplate
	 * ().load(DgSampleCollectionDetails.class,sampleDetailId);
	 * dgDetails.setOrderStatus("E"); hbt.update(dgDetails);
	 * hbt.refresh(dgDetails); tx.commit(); } catch (Exception e) { or display
	 * error message e.printStackTrace(); }
	 * 
	 * map.put("saved", saved); return map ; }
	 */
	public Map<String, Object> getResultEntryDetailsForNext(int newResultId,
			int deptId) {
		LOGGER.info("in getResultEntryDetailsForNext");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgResultEntryHeader> previousresultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Session session = (Session) getSession();
		int resultDetailId = 0;
		int resultHeaderId = 0;
		Set<DgResultEntryDetail> dgRSet = new HashSet<DgResultEntryDetail>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			resultList = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Id", newResultId))
					.addOrder(Order.asc("Id")).list();
			if (resultList != null || resultList.size() > 0) {

				detailsMap.put("resultList", resultList);
			}
			if (resultList.size() > 0) {
				for (DgResultEntryHeader dgResultHeader : resultList) {
					dgRSet = dgResultHeader.getDgResultEntryDetails();
					resultHeaderId = dgResultHeader.getId();

				}
				dgResultdetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.eq("ResultEntry.Id", resultHeaderId))
						.add(Restrictions.eq("ResultDetailStatus", "P"))
						.createAlias("SubInvestigation", "subInv")
						.addOrder(Order.asc("subInv.OrderNo")).list();
				if (dgResultdetailList.size() > 0) {
					detailsMap.put("dgResultdetailList", dgResultdetailList);
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	/** For updating report Collction records* */
	public boolean updateReceivedDetails(Map<String, Object> infoMap) {
		LOGGER.info("in updateReceivedDetails");
		Session session = (Session) getSession();
		int dispatchedId = 0;
		int relationId = 0;
		String receivedBy = "";
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}
		if (infoMap.get("dispatchedId") != null) {
			dispatchedId = Integer.parseInt("" + infoMap.get("dispatchedId"));
		}
		if (infoMap.get("relationId") != null) {
			relationId = Integer.parseInt("" + infoMap.get("relationId"));
		}
		if (infoMap.get("receivedBy") != null
				&& !infoMap.get("receivedBy").equals("")) {
			receivedBy = (String) infoMap.get("receivedBy");
		}

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (dispatchedId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(dispatchedId);
				dgEntryHeader.setPrescribedBy(masEmployee);
			}
			if (relationId != 0) {
				MasRelation masRelation = new MasRelation();
				masRelation.setId(relationId);
				dgEntryHeader.setRelation(masRelation);
			}
			if (receivedBy != null && !receivedBy.equals("")) {
				dgEntryHeader.setReceivedBy(receivedBy);
			}
			dgEntryHeader.setResultStatus("R");

			hbt.saveOrUpdate(dgEntryHeader);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		return successfullyAdded;
	}

	/** For Result Validation Grid Data * */
	public Map<String, Object> getResultValidationGrid(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultValidationGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			if (deptType.equalsIgnoreCase("RADIO")) {
				crit = session.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.eq("ResultStatus", "P"))
						.createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId));
				// .add(Restrictions.eq("ResultDate", currentDate));

				patientList = crit.list();
				for (DgResultEntryHeader dgResultEntryHeader : patientList) {
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					for (DgResultEntryDetail dgResultEntryDetail : dgResultEntrySet) {
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				}
				patientList.removeAll(patientListTemp);
			} else {
				crit = session.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.eq("ResultStatus", "P"))
						.createAlias("Department", "dept")
						.add(Restrictions.eq("dept.Id", deptId))
						.add(Restrictions.eq("ResultDate", currentDate));
				patientList = crit.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getResultValidationLabGrid(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultValidationLabGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		Integer hospitalId = 0;
		int subChargeCodeId = 0;
		Date currentDate = new Date();
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		String patientType = "";
		String orderType = "";
		int departmentId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int deptId = 0;
		String mobileNo = "";
		String wardName = "";
		String barcodetext = "";
		String sampleId="";
		String sampleIdNo ="";
		String subchargeCodeCode=null;
		String diagNo = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		
		// added by amit das on 27-07-2017
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		
		
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		} 
		
		if (mapForDs.get("patientType") != null) {
			patientType = (String) mapForDs.get("patientType");
		} 
		
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("sampleCollectionDetailId") != null) {
			sampleCollectionDetailId = (Integer) mapForDs
					.get("sampleCollectionDetailId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String) mapForDs.get("barcodetext");
		}
		if (mapForDs.get("wardName") != null) {
			wardName = (String) mapForDs.get("wardName");
		}
		
		if (mapForDs.get("sampleId") != null) {
			sampleId = (String) mapForDs.get("sampleId");
		}
		if (mapForDs.get("sampleIdNo") != null) {
			sampleIdNo = (String) mapForDs.get("sampleIdNo");
			String[] sampleIdNoArray = 	sampleIdNo.split("/");
			subchargeCodeCode = 	sampleIdNoArray[0].trim();
			diagNo = sampleIdNoArray[1].trim();
		}

		String hospitalCode="";
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			MasHospital hos=(MasHospital)session.get(MasHospital.class, hospitalId);
						if(hos!=null){
							hospitalCode=hos.getHospitalCode();
						}
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P").ignoreCase()) 
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
					.createAlias("Department", "dept")
					
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Hin", "pt")
					.add(Restrictions.eq("dept.Id", deptId));
			
			// added by amit das on 27-07-2017 
			if(subChargeCodeId!=0)
					crit =	crit.add(Restrictions.eq("SubChargecode.Id", subChargeCodeId));
						
			
				crit = 	crit.add(Restrictions.ge("ResultDate",
						fromDate))
				.add(Restrictions.le("ResultDate",
						toDate))
					.addOrder(Order.asc("SampleCollectionHeader.Id"))
					.addOrder(Order.asc("SubChargecode.Id"));

				
				
				if (!barcodetext.equals("")) {
					if(hospitalCode!=null){
					barcodetext=hospitalCode+barcodetext;
					}
					LOGGER.info("barcodetext "+barcodetext);
					crit=crit.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
				}

				if (subchargeCodeCode!=null) {
					crit= crit.createAlias("SubChargecode", "subChargecode");
					crit = crit.add(Restrictions.eq("subChargecode.SubChargecodeCode", subchargeCodeCode));
				}
				if (diagNo!=null) {
					crit = crit.createAlias("sampleHead.DgSampleCollectionDetails", "sampleCollectionDetails");
					crit = crit.add(Restrictions.eq("sampleCollectionDetails.DiagNo", diagNo));
				}
				
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
				}
				

				if (hinId != 0) {
					crit = crit.add(Restrictions.eq("pt.Id", hinId));
				}
				if (!hinNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
				}
				
				if (!patientType.equals("")) {
					crit = crit.add(Restrictions.eq("pt.PatientStatus", patientType));
				}
				
				if (!patientFName.equals("")) {
					crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName
							+ "%").ignoreCase());
				}
				if (!mobileNo.equals("")) {
					crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
				}
				
				if (!adNo.equals("") || !wardName.equals("")) {
					crit = crit.createAlias("sampleHead.Inpatient", "ip");
				}
				if (!adNo.equals("")) {
					crit = crit.add(
							Restrictions.eq("ip.AdNo", adNo));
				}
				if (!wardName.equals("")) {
					crit = crit.createAlias("ip.Department", "dept");
					crit = crit.add(Restrictions.eq("dept.DepartmentName",
							wardName));
					}
			patientList = crit.list();
		
			//added by govind 07-07-2017 
			//
		/*	for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				//
				if (dgResultEntryHeader.getResultType() != null
						&& dgResultEntryHeader.getResultType()
								.equalsIgnoreCase("v")) {
					//
					Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetailSens();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetailSen dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollection();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				} else {
					//
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						if(!dgResultEntryDetail.getValidated().equalsIgnoreCase("v")){
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
						}
					}
				}
			}
			patientList.removeAll(patientListTemp);

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList
							.get(ilop)
							.getSampleCollectionHeader()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSampleCollectionHeader().getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList
								.get(ilop)
								.getSubChargecode()
								.getId()
								.equals(patientList.get(ilop + 1)
										.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;*/
			Date sampleCollDate = new Date();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currentD = (String) utilMap.get("currentDate");
		 	 //fromDate = HMSUtil.dateFormatterDDMMYYYY(currentD);
		 	// toDate = HMSUtil.dateFormatterDDMMYYYY(currentD);
			for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				if (dgResultEntryHeader.getResultType() != null
						&& dgResultEntryHeader.getResultType()
								.equalsIgnoreCase("v")) {
					Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetailSens();
					if (dgResultEntrySet.size() > 0) {
					
					DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntrySet
							.iterator().next();
							
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetailSen
							.getSampleCollection();
					Date sampleCollectionDate = dgSampleCollectionDetails
							.getSampleCollDatetime();

					sampleCollDateString = HMSUtil
							.convertDateToStringWithoutTime(sampleCollectionDate);
					sampleCollDate = HMSUtil
							.convertStringTypeDateToDateType(sampleCollDateString);
					if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
							.compareTo(toDate) <= 0)) {
						patientListTemp.add(dgResultEntryHeader);
					
					}
				   }
				} else {
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();

						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						sampleCollDate = HMSUtil
								.convertStringTypeDateToDateType(sampleCollDateString);
						if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
								.compareTo(toDate) <= 0)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				}
			}
			patientList = patientListTemp;
			
			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";


			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList
							.get(ilop)
							.getSampleCollectionHeader()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSampleCollectionHeader().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList
								.get(ilop)
								.getSubChargecode()
								.getId()
								.equals(patientList.get(ilop + 1)
										.getSubChargecode().getId())) {

							patientListSubDepartWise.add(patientList.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1).getId()
									.toString());
							stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
									.getSubChargecode().getId().toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds + ","
									+ patientList.get(ilop + 1).getId().toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}

			patientList = patientListSubDepartWise;
			//added by govind 07-07-2017  end
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}
	
	public Map<String, Object> getResultValidationLabGridForEmpanelled(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultValidationLabGridForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		Integer hospitalId = 0;
		Date currentDate = new Date();
		int empanelledId=0;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.USERS) != null) {
			MasEmpaneled masEmpaneled = (MasEmpaneled) mapForDs.get(RequestConstants.USERS);
			empanelledId=masEmpaneled.getId();
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P")) 
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					.add(Restrictions.eq("Empaneled.Id", empanelledId))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("ResultDate", currentDate))
					.addOrder(Order.asc("SampleCollectionHeader.Id"))
					.addOrder(Order.asc("SubChargecode.Id"));

			patientList = crit.list();
			//
			for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				//
				if (dgResultEntryHeader.getResultType() != null
						&& dgResultEntryHeader.getResultType()
								.equalsIgnoreCase("v")) {
					//
					Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetailSens();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetailSen dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollection();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				} else {
					//
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				}
			}
			patientList.removeAll(patientListTemp);

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList
							.get(ilop)
							.getSampleCollectionHeader()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSampleCollectionHeader().getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList
								.get(ilop)
								.getSubChargecode()
								.getId()
								.equals(patientList.get(ilop + 1)
										.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}
	
	public Map<String, Object> getResultEntryLabGridForPostQC(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultEntryLabGridForPostQC");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		Integer hospitalId = 0;
		/*Date toDate = HMSUtil.dateFormatterDDMMYYYY(request
				.getParameter(TO_DATE));*/
		Date fromDate = new Date();
		Date toDate = new Date();
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			fromDate = (Date) mapForDs.get("currentDate");
			toDate=(Date) mapForDs.get("currentDate");
		}
		
		int deptId = 0;
		String deptType = "";
		if(mapForDs.get("box")!=null){
			Box box=(Box)mapForDs.get("box");
			if(box.get("fromDate")!=null &&!"".equalsIgnoreCase(box.get("fromDate").trim())){
				 fromDate = HMSUtil.dateFormatterDDMMYYYY(box.get("fromDate"));
			}if(box.get("toDate")!=null &&!"".equalsIgnoreCase(box.get("toDate").trim())){
				 toDate = HMSUtil.dateFormatterDDMMYYYY(box.get("toDate"));
			} 	
		}
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(fromDate);
		try {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "Q").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.between("ResultDate", fromDate, toDate))
					.addOrder(Order.asc("SampleCollectionHeader.Id"))
					.addOrder(Order.asc("SubChargecode.Id"));

			patientList = crit.list();
			//
			Date sampleCollDate = new Date();
			for (DgResultEntryHeader dgResultEntryHeader : patientList) {
				//
				if (dgResultEntryHeader.getResultType() != null
						&& dgResultEntryHeader.getResultType()
								.equalsIgnoreCase("Q")) {
					//
					Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetailSens();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetailSen dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollection();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						/*sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}*/
						
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						String fromDateWithoutTime = HMSUtil
								.convertDateToStringWithoutTime(fromDate);
						String toDateWithoutTime = HMSUtil
								.convertDateToStringWithoutTime(toDate);
						sampleCollDate = HMSUtil
								.convertStringTypeDateToDateType(sampleCollDateString);
						if ((sampleCollDate.compareTo(HMSUtil
								.convertStringTypeDateToDateType(fromDateWithoutTime)) >= 0 && sampleCollDate
								.compareTo(HMSUtil
										.convertStringTypeDateToDateType(toDateWithoutTime)) <= 0)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				} else {
					//
					Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
							.getDgResultEntryDetails();
					if (dgResultEntrySet.size() > 0) {
						DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
								.iterator().next();
						DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
								.getSampleCollectionDetails();
						Date sampleCollectionDate = dgSampleCollectionDetails
								.getSampleCollDatetime();
						/*sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						if (!sampleCollDateString.equals(currentDate1)) {
							patientListTemp.add(dgResultEntryHeader);
						}*/
						
						sampleCollDateString = HMSUtil
								.convertDateToStringWithoutTime(sampleCollectionDate);
						String fromDateWithoutTime = HMSUtil
								.convertDateToStringWithoutTime(fromDate);
						String toDateWithoutTime = HMSUtil
								.convertDateToStringWithoutTime(toDate);
						sampleCollDate = HMSUtil
								.convertStringTypeDateToDateType(sampleCollDateString);
						if ((sampleCollDate.compareTo(HMSUtil
								.convertStringTypeDateToDateType(fromDateWithoutTime)) >= 0 && sampleCollDate
								.compareTo(HMSUtil
										.convertStringTypeDateToDateType(toDateWithoutTime)) <= 0)) {
							patientListTemp.add(dgResultEntryHeader);
						}
					}
				}
			}
			//patientList.removeAll(patientListTemp);
			patientList = patientListTemp;
			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList
							.get(ilop)
							.getSampleCollectionHeader()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSampleCollectionHeader().getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList
								.get(ilop)
								.getSubChargecode()
								.getId()
								.equals(patientList.get(ilop + 1)
										.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}
	

	public Map<String, Object> getResultEntryCorrectionLabGrid(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultEntryCorrectionLabGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}

		int deptId = 0;
		String deptType = "";
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		String currentDate1 = "";
		String sampleCollDateString = "";
		currentDate1 = HMSUtil.convertDateToStringWithoutTime(currentDate);
		try {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("ResultStatus", "P"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("ResultDate", currentDate))
					.addOrder(Order.asc("SampleCollectionHeader.Id"))
					.addOrder(Order.asc("SubChargecode.Id"));

			patientList = crit.list();

			List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
			String stringOfIds = "";
			String stringOfSubDeptIds = "";

			if (patientList.size() > 0) {
				patientListSubDepartWise.add(patientList.get(0));
				stringOfIds = stringOfIds + patientList.get(0).getId();
				stringOfSubDeptIds = stringOfSubDeptIds
						+ patientList.get(0).getSubChargecode().getId();

				stringOfIdsList.add(stringOfIds);
				stringOfSubDeptIdsList.add(stringOfSubDeptIds);

				for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
					if (!patientList
							.get(ilop)
							.getSampleCollectionHeader()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSampleCollectionHeader().getId())) {
						patientListSubDepartWise.add(patientList.get(ilop + 1));

						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						if (!patientList
								.get(ilop)
								.getSubChargecode()
								.getId()
								.equals(patientList.get(ilop + 1)
										.getSubChargecode().getId())) {
							patientListSubDepartWise.add(patientList
									.get(ilop + 1));
							stringOfIdsList.add(patientList.get(ilop + 1)
									.getId().toString());
							stringOfSubDeptIdsList.add(patientList
									.get(ilop + 1).getSubChargecode().getId()
									.toString());
						} else {
							int ii = stringOfIdsList.size() - 1;
							stringOfIds = stringOfIdsList.get(ii);
							stringOfIdsList.remove(ii);
							stringOfIds = stringOfIds
									+ ","
									+ patientList.get(ilop + 1).getId()
											.toString();
							stringOfIdsList.add((ii), stringOfIds);
						}
					}
				}
			}
			patientList = patientListSubDepartWise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);
		return map;
	}

	// /* Result For Update Film Size Accepted Only */
	public Map<String, Object> getResultValidationAcceptedGrid(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getResultValidationAcceptedGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		Date currentDate = new Date();
		;

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}

		try {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("ResultStatus", "P"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("ResultDate", currentDate));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	/** for result entry * */

	public Map<String, Object> getResultGrid(Map<String, Object> mapForDs) {
		LOGGER.info("in getResultGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int subChargeCodeId = 0;
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		String deptName = "";
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		Integer hospitalId = 0;
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ mapForDs.get(RequestConstants.HOSPITAL_ID));
		}
		
		int hinId = 0;
		String RequisitionFrom ="NA";
		if (mapForDs.get("hinId") != null) {
			hinId = Integer.parseInt("" + mapForDs.get("hinId"));
		}
		if (mapForDs.get("RequisitionFrom") != null) {
			RequisitionFrom =(String) mapForDs.get("RequisitionFrom");
		}
		
		// added by amit das on 27-07-2017
				if (mapForDs.get("subChargeCodeId") != null) {
					subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
				}
				
		
		/*try {
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "A"))
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
					.add(Restrictions.eq("sampleHead.SampleValidationDate",
							currentDate));
			
			patientList = crit.list();

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "A").ignoreCase())
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("Investigation", "inv")
					.add(Restrictions.eq("sampleHead.SampleValidationDate",
							currentDate))
					.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId));
					
			//System.out.println("hinId="+hinId);
		//	System.out.println("deptId="+deptId);
			//System.out.println("RequisitionFrom="+RequisitionFrom+"v");
			
			// added by amit das on 27-07-2017 
			if(subChargeCodeId!=0)
				crit =	crit.createAlias("Subcharge", "scc").add(Restrictions.eq("scc.Id", subChargeCodeId));
			
			
			if(hinId != 0)
			{
				if(RequisitionFrom.equalsIgnoreCase("OPD"))
				{
					crit = crit.add(Restrictions.eq("inv.SubmittedByDoctor", "y").ignoreCase());
				}
			}
			else
			{
				crit= crit.createAlias("sampleHead.Department", "dept");
				crit= crit.add(Restrictions.eq("dept.Id", deptId));
				// commented by dhananjay 16-nov-16
				//crit = crit.add(Restrictions.eq("inv.SubmittedByDoctor", "n").ignoreCase());
			}
			patientList = crit.list();
			//System.out.println("patientList="+patientList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*new Thread(){
			
			public void run(){
				
					try {
						pacsMethodForPacsServerReceiver();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
		}.start(); */   // commented by amit das on 16-09-2017 due to pacs error
		map.put("patientList", patientList);
		return map;
	}

	public Map<String, Object> getResultViewGrid(Map<String, Object> mapForDs) {
		LOGGER.info("in getResultViewGrid");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date currentDate = new Date();
		Integer hospitalId = null;
		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ mapForDs.get(RequestConstants.HOSPITAL_ID));
		}
		try {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Department.Id", deptId))
					.add(Restrictions.eq("ResultStatus", "A"))
					.add(Restrictions.eq("VerifiedOn", currentDate));
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	// =============================== end of methods by ABHA
	// =========================

	/** stsrt of methods by mansi * */

	@Override
	public Map<String, Object> getAllPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getAllPatientDetailsForResultValidationOrderNo");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList1 = new ArrayList<DgResultEntryHeader>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int deptId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String orderNo = "";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}

		crit = session
				.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.in("ResultStatus", new String[] { "A", "R" }))
				.add(Restrictions.between("ResultDate", fromDate, toDate))
				.createAlias("Hin", "pt");

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (departmentId != 0) {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", departmentId));
		} else {
			crit = crit.createAlias("Department", "dept").add(
					Restrictions.eq("dept.Id", deptId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}
		if (!orderNo.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.OrderNo", orderNo));
		}

		patientList1 = crit.list();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();

		if (patientList1.size() > 0) {
			patientList.add(patientList1.get(0));
			for (int ilop = 0; ilop < patientList1.size() - 1; ilop++) {
				if (!patientList1
						.get(ilop)
						.getSampleCollectionHeader()
						.getOrder()
						.getOrderNo()
						.equals(patientList1.get(ilop + 1)
								.getSampleCollectionHeader().getOrder()
								.getOrderNo())) {
					patientList.add(patientList1.get(ilop + 1));
				}
			}
			map.put("patientDetailsList", patientList);
		} else {
			map.put("patientDetailsList", patientList1);
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForResultValidationOrderNo(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForResultValidationOrderNo");
		Map<String, Object> map = new HashMap<String, Object>();
		//List<DgOrderhd> patientList1 = new ArrayList<DgOrderhd>();
		
		 List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
		 List<Object[]> objList = new ArrayList<Object[]>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String orderNo = "";
		Integer hospitalId = 0;
		String mobileNo = "";
		String wardName = "";
		String fromAge="";
		String toAge="";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		
		if (mapForDs.get("fromAge") != null) {
			fromAge = (String) mapForDs.get("fromAge");
		}
		if (mapForDs.get("toAge") != null) {
			toAge = (String) mapForDs.get("toAge");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get(RequestConstants.AD_NO) != null) {
			adNo = (String) mapForDs.get(RequestConstants.AD_NO);
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		
		if (mapForDs.get("fromDate") != null) {
			if(!mapForDs.get("fromDate").equals("")){
			fromDate = HMSUtil.dateFormatterDDMMYYYY((String) mapForDs.get("fromDate"));
			}
		}
		if (mapForDs.get("toDate") != null) {
			if(!mapForDs.get("toDate").equals("")){
			toDate = HMSUtil.dateFormatterDDMMYYYY((String) mapForDs.get("toDate"));
			}
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}

		String barcodetext="";
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String)mapForDs.get("barcodetext");
	 	    mapForDs.put("barcodetext",barcodetext); 
	 					
		}
		
		// added by amit das on 27-07-2017
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		/*session.beginTransaction();
		try {
			String hql = String
					.format("delete from DgResultEntryDetail where Investigation.Id="
							+ 1081 + " and Validated is null");
			Query query = session.createQuery(hql);
			query.executeUpdate();

		} catch (Exception e) {
		}
		session.getTransaction().commit();*/
		
		Criteria crt=session.createCriteria(DgResultEntryDetail.class)//added by govind 22-07-2017
				//session.createCriteria(DgResultEntryHeader.class) 
				.createAlias("ResultEntry", "resultEntry") 
				  .createAlias("resultEntry.Hospital", "hosp")				  
			     .createAlias("resultEntry.SampleCollectionHeader", "sampleHead")
			     .createAlias("sampleHead.Order", "order")
			      .createAlias("resultEntry.Hin", "hin")
				  .add(Restrictions.between("resultEntry.ResultDate", fromDate, toDate))
				    .add(Restrictions.eq("resultEntry.ResultStatus", "A").ignoreCase())
				 .add(Restrictions.eq("hosp.Id", hospitalId))
				  .add(Restrictions.eq("resultEntry.Verified", "V").ignoreCase())
				  //added by govind 22-07-2017
				  .addOrder(Order.asc("ResultEntry.Id"))
				  .setProjection(Projections.projectionList().add(Projections.groupProperty("ResultEntry"))
						  .add(Projections.groupProperty("resultEntry.Investigation"))
						   .add(Projections.groupProperty("resultEntry.Hin"))
						  )//added by govind 22-07-2017 end
				  /*.add(Restrictions.eq("ResultDetailStatus", "A").ignoreCase())*/;
		//System.out.println("hinNo  "+hinNo);
		

		// added by amit das on 27-07-2017 
		if(subChargeCodeId!=0)
				crt =	crt.createAlias("ChargeCode", "cc").createAlias("cc.SubChargecode", "scc").add(Restrictions.eq("scc.Id", subChargeCodeId));


		if(hinNo != null && !hinNo.equals("")){
			//crt.createAlias("Hin", "hin");
			crt.add(Restrictions.eq("hin.HinNo", hinNo));
		}
		 if(fromAge!=null && !fromAge.equals("") && Integer.parseInt(fromAge) >0){
			  
			  crt.add(Restrictions.ge("hin.PatientAge", Integer.parseInt(fromAge))); 
			  }
			  
			  if(toAge !=null && !toAge.equals("") && Integer.parseInt(toAge) >0 ){
				    crt.add(Restrictions.le("hin.PatientAge", Integer.parseInt(toAge)));
				  }
			
		
		if(!adNo.equals("") || !wardName.equals("")){
		//added by govind 22-07-2017
			crt.createAlias("resultEntry.Inpatient", "inpatient");
			if (!wardName.equals("")) {
		
				crt.add(Restrictions.eq("inpatient.AdNo", adNo));
			}
			else
			{
				crt.createAlias("inpatient.Department", "ipDpt")
				.add(Restrictions.eq("ipDpt.DepartmentName",
						wardName));
			}
		}
		
		
		if(!patientFName.equals("")){
			crt.add(Restrictions.like("hin.PFirstName","%"+patientFName +"%").ignoreCase());
		}
		
		if (!mobileNo.equals("")) {
			crt.add(Restrictions.eq("hin.MobileNumber", mobileNo));
		}
		
		if (!barcodetext.equals("")) {
			crt.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
		}
		
		objList=crt.list();
		Map<Integer,Boolean> headMap=new HashMap<Integer,Boolean>();
		//added by govind 22-07-2017
		int peviousDgId=0;
		int hCount=0;
		if(objList.size()>0){
		for (int i=0;i<objList.size();i++) {
			
			DgResultEntryHeader header=((DgResultEntryHeader)objList.get(i)[0]);
			if(hCount==0){
				headMap.put(header.getSampleCollectionHeader().getId(), true);
				patientListResult.add(header);
			}else{
				if(headMap.get(header.getSampleCollectionHeader().getId())!=null && headMap.get(header.getSampleCollectionHeader().getId())==true){
				}else{
					headMap.put(header.getSampleCollectionHeader().getId(), true);
				    patientListResult.add(header);
				}
			}
			hCount++;
		}
		}
		//added by govind 22-07-2017 end
		//patientListResult=crt.list();
	/*if (hinNo != null && !hinNo.equals("")) {
		patientList1 = session.createCriteria(DgOrderhd.class)
				.createAlias("Hin", "pt")
				.add(Restrictions.eq("pt.HinNo", hinNo))
				.createAlias("Hospital", "ho")
				.add(Restrictions.eq("ho.Id", hospitalId))
				.add(Restrictions.between("OrderDate", fromDate, toDate))
				.list();
	} else {
		patientList1 = session.createCriteria(DgOrderhd.class)
				.createAlias("Hospital", "ho")
				.add(Restrictions.eq("OrderStatus", "A").ignoreCase())
				.add(Restrictions.eq("ho.Id", hospitalId))
				.add(Restrictions.between("OrderDate", fromDate, toDate))
				.list();
	}*/
		
		
	//System.out.println("ssss "+patientListResult.size());
	//map.put("patientDetailsList", patientList1);
		map.put("patientListResult", patientListResult);
		// }
		//
		//
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getPatientDetailsForResultPrinting(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForResultPrinting");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrderhd> patientList1 = new ArrayList<DgOrderhd>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int chargeCodeId = 0;
		int hinId = 0;
		int resultId = 0;
		String orderNo = "";
		Integer hospitalId = 0;
		String mobileNo = "";
		String wardName = "";
		String pType = "";
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = (Integer) mapForDs.get("hospitalId");
		}
		//
		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("resultId") != null) {
			resultId = (Integer) mapForDs.get("resultId");
		}

		if (mapForDs.get("orderNo") != null) {
			orderNo = (String) mapForDs.get("orderNo");
		}
		if (mapForDs.get(RequestConstants.PATIENT_TYPE) != null) {
			pType = (String) mapForDs.get(RequestConstants.PATIENT_TYPE);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}

		/*
		 * patientList1 = session.createCriteria(DgOrderhd.class)
		 * .createAlias("Hospital", "ho") .add(Restrictions.eq("OrderStatus",
		 * "A")) .add(Restrictions.eq("ho.Id", hospitalId))
		 * .add(Restrictions.between("OrderDate", fromDate, toDate)) .list();
		 */
		/*
		 * patientList1 = session.createCriteria(DgOrderhd.class)
		 * .createAlias("Hospital", "ho") .add(Restrictions.eq("OrderStatus",
		 * "A")) .add(Restrictions.eq("ho.Id", hospitalId))
		 * .add(Restrictions.between("OrderDate", fromDate, toDate)) .list();
		 */
		try {

			if (fromDate != null && toDate != null) {
				crit = session
						.createCriteria(DgOrderhd.class)
						//.add(Restrictions.eq("OrderStatus", "A"))
						.add(Restrictions
								.between("OrderDate", fromDate, toDate))
						.createAlias("Hin", "pt").createAlias("Hospital", "oh")
						.add(Restrictions.eq("oh.Id", hospitalId));
			} else {
				crit = session.createCriteria(DgOrderhd.class)
						//.add(Restrictions.eq("OrderStatus", "A"))
						.createAlias("Hin", "pt").createAlias("Hospital", "oh")
						.add(Restrictions.eq("oh.Id", hospitalId));
			}
			if (!pType.equals("")) {

				crit = crit.add(Restrictions.eq("PatientType", pType));
			}

			if (!adNo.equals("")) {
				crit = crit.createAlias("Inpatient", "ip").add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			/*
			 * if (!wardName.equals("")) { crit = crit.createAlias("Inpatient",
			 * "ip").add( Restrictions.eq("ip.AdNo", wardName)); }
			 */
			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}

			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
						+ "%"));
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}
			/*
			 * if (subGroupId != 0) { crit = crit.createAlias("SubChargeid",
			 * "sc").add( Restrictions.eq("sc.Id", subGroupId)); }
			 */
			/*
			 * if (chargeCodeId != 0) { crit = crit.createAlias("ChargeCode",
			 * "ch").add( Restrictions.eq("ch.Id", chargeCodeId)); }
			 */
			if (departmentId != 0) {
				crit = crit.createAlias("Department", "dept").add(
						Restrictions.eq("dept.Id", departmentId));
			}
			/*
			 * if (visitNumber != null) { crit =
			 * crit.add(Restrictions.eq("OrderNo", visitNumber)); }
			 */
			/*
			 * if (!doctorName.equals("")) { crit =
			 * crit.createAlias("PrescribedBy", "emp").add(
			 * Restrictions.like("emp.FirstName", doctorName + "%")); }
			 */

			patientList1 = crit.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		map.put("patientDetailsList", patientList1);
		return map;
	}

	/** method for connection of report * */

	public Map<String, Object> getConnectionForReport() {
		LOGGER.info("in getConnectionForReport");
		Session session = (Session) getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Connection conn = session.connection();
		map.put("conn", conn);
		return map;

	}

	/**
	 * new method for next functionality in result entry
	 */
	public Map<String, Object> getResultEntryForNext(int newSampleCollectionId,
			int deptId) {
		LOGGER.info("in getResultEntryForNext");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int subTestId = 0;
		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		Session session = (Session) getSession();
		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Status", "y"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}

			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}

			sampleCollectionList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("Id", newSampleCollectionId))
					.addOrder(Order.asc("Id")).list();
			if (sampleCollectionList != null || sampleCollectionList.size() > 0) {

				detailsMap.put("sampleCollectionList", sampleCollectionList);
			}
			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();
					subList = session
							.createCriteria(DgSubMasInvestigation.class)
							.add(Restrictions.eq("Investigation.Id",
									investigationId))
							.addOrder(Order.asc("OrderNo")).list();

				}
			}
			if (subList.size() > 0) {
				for (DgSubMasInvestigation dgSubMasInvestigation : subList) {
					detailsMap.put("subList", subList);
				}
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subInvSet = dgApp.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

					fixedValList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
									+ subTestId + "' and ga.FixedValue != null");
					if (fixedValList.size() > 0) {
						detailsMap.put("fixedValList", fixedValList);

					}
				}

			}

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	// -------------------------------Start Methods developed by Vivek
	// --------------------------------------

	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrganismList(Map<String, Object> dataMap) {
		LOGGER.info("in getOrganismList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgOrgGrpDtl> dgOrgGrpDtlList = new ArrayList<DgOrgGrpDtl>();
		List objectList = new ArrayList();
		String orGroupId = "";
		try {
			if (dataMap.get("orGroupId") != null) {
				orGroupId = ("" + dataMap.get("orGroupId"));
			}
			StringTokenizer s1 = new StringTokenizer(orGroupId, ".");
			while (s1.hasMoreTokens()) {
				objectList.add(Integer.parseInt("" + s1.nextToken()));
			}
			Session session = (Session) getSession();
			if (objectList.size() > 0) {
				dgOrgGrpDtlList = session.createCriteria(DgOrgGrpDtl.class)
						.add(Restrictions.in("OrganismGroup.Id", objectList))
						.addOrder(Order.asc("OrganismGroup.Id")).list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("dgOrgGrpDtlList", dgOrgGrpDtlList);
		return map;
	}

	public Map<String, Object> submitResultEntryForTemplateTemparory(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForTemplateTemparory");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int sampleDetailId = 0;
		int dgResultEntryHeaderId = 0;

		List<DgResultEntryDetail> dgResultEntryList = new ArrayList<DgResultEntryDetail>();

		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) parameterMap
				.get("dgResultEntryDetail");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
					.load(DgSampleCollectionDetails.class, sampleDetailId);
			dgDetails.setOrderStatus("E");
			hbt.saveOrUpdate(dgDetails); 
			//System.out.println();
			Criteria criteria = null;

			criteria = session.createCriteria(DgResultEntryDetail.class).add(
					Restrictions.eq("SampleCollectionDetails.Id",
							sampleDetailId));

			dgResultEntryList = criteria.list();
			if (dgResultEntryList.size() > 0) {
				DgResultEntryDetail dgResultEntryDetail2 = dgResultEntryList
						.get(0);
				DgResultEntryHeader dgResultEntryHeader2 = dgResultEntryList
						.get(0).getResultEntry();
				// ///////////
				dgResultEntryHeader2.setResultNo(dgResultEntryHeader
						.getResultNo());
				dgResultEntryHeader2.setLastChgdBy(dgResultEntryHeader
						.getLastChgdBy());
				dgResultEntryHeader2.setLastChgdDate(dgResultEntryHeader
						.getLastChgdDate());
				dgResultEntryHeader2.setLastChgdTime(dgResultEntryHeader
						.getLastChgdTime());
				dgResultEntryHeader2.setRemarks(dgResultEntryHeader
						.getRemarks());
				dgResultEntryHeader2.setResultDate(dgResultEntryHeader
						.getResultDate());
				// dgResultEntryHeader2.setResultStatus(dgResultEntryHeader
				// .getResultStatus());
				dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader2.setResultTime(dgResultEntryHeader
						.getResultTime());
				dgResultEntryHeader2.setEmployee(dgResultEntryHeader
						.getEmployee());
				hbt.update(dgResultEntryHeader2);
				hbt.refresh(dgResultEntryHeader2);

				// /////////
				dgResultEntryDetail2.setResult(dgResultEntryDetail.getResult());
				dgResultEntryDetail2.setResultEntry(dgResultEntryHeader2);
				dgResultEntryDetail2.setRemarks(dgResultEntryDetail
						.getRemarks());
				dgResultEntryDetail2.setResultDetailStatus(dgResultEntryDetail
						.getResultDetailStatus());
				// //////////////
				/*
				 * dgResultEntryHeader2 = dgResultEntryHeader;
				 * dgResultEntryHeader2
				 * .setId(dgResultEntryList.get(0).getResultEntry().getId());
				 * 
				 * dgResultEntryDetail2 = dgResultEntryDetail;
				 * dgResultEntryDetail2.setId(dgResultEntryList.get(0).getId());
				 */
				// ////////
				hbt.update(dgResultEntryDetail2);
				hbt.refresh(dgResultEntryDetail2);
			} else {
				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);
				hbt.save(dgResultEntryDetail);
				hbt.refresh(dgResultEntryDetail);
			}

			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> getSensitivityList(Map<String, Object> dataMap) {
		LOGGER.info("in getSensitivityList");
		Map<String, Object> map = new HashMap<String, Object>();
		String[] idsArray = new String[0];
		String orIds = "";

		List<Integer> organismIds = new ArrayList<Integer>();
		List<Integer> organismGroupIds = new ArrayList<Integer>();

		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("orIds") != null) {
				orIds = "" + dataMap.get("orIds");
			}
			StringTokenizer s1 = new StringTokenizer(orIds, ".");
			while (s1.hasMoreTokens()) {
				try {
					int organismId = 0;
					int organismGroupId = 0;
					String combinedOrgGrpOrgId = s1.nextToken();

					idsArray = combinedOrgGrpOrgId.split("@");

					organismId = Integer.parseInt(idsArray[0]);
					organismIds.add(organismId);

					organismGroupId = Integer.parseInt(idsArray[1]);
					organismGroupIds.add(organismGroupId);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Session session = (Session) getSession();
			if (organismIds.size() > 0) {

				int cnt = 0;
				for (Integer obj : organismIds) {
				}
				cnt = 0;
				for (Integer obj : organismGroupIds) {

				}
				dgOrgDtlList = session
						.createCriteria(DgOrgDtl.class)
						.add(Restrictions.in("Organism.Id", organismIds))
						.add(Restrictions.in("OrganismGroup.Id",
								organismGroupIds)).list();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public Map<String, Object> saveSensitivity(Map<String, Object> parameterMap) {
		LOGGER.info("in saveSensitivity");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean saved = false;
		int sampleDetailId = 0;
		String remarks = "";
		String result1 = "";
		String result2 = "";
		int investigationId = 0;
		String nosoc = "";

		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		// DgResultEntryDetailSen dgResultEntryDetailSen =
		// (DgResultEntryDetailSen)parameterMap.get("dgResultEntryDetailSen");

		investigationId = (Integer) parameterMap.get("investigationId");

		nosoc = (String) parameterMap.get("nosoc");
		String[] resArray = (String[]) parameterMap.get("resArray");
		result1 = (String) parameterMap.get("result1");
		result2 = (String) parameterMap.get("result2");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");
		String[] senArray = (String[]) parameterMap.get("senArray");
		String growthOption = "";
		growthOption = (String) parameterMap.get("growthOption");

		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgResultEntryHeader);

			if (growthOption.equalsIgnoreCase("o")) {

				DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
				if (investigationId != 0) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(investigationId);
					dgResultEntryDetailSen.setInvestigation(dgMasInvestigation);
				}
				if (investigationId != 0) {
					MasChargeCode masChargeCode = new MasChargeCode();
					masChargeCode.setId(investigationId);
					// dgResultEntryDetailSen.setChargeCode(masChargeCode);
				}
				if (sampleDetailId != 0) {
					DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
					dgSample.setId(sampleDetailId);
					dgResultEntryDetailSen.setSampleCollection(dgSample);
				}
				dgResultEntryDetailSen.setResult(result1);
				dgResultEntryDetailSen.setResultOther(result2);
				dgResultEntryDetailSen.setGrowthOption(growthOption);
				dgResultEntryDetailSen.setNosocomial(nosoc);
				dgResultEntryDetailSen.setResultEntry(dgResultEntryHeader);
				hbt.save(dgResultEntryDetailSen);
			}
			if (growthOption.equalsIgnoreCase("g")) {
				for (int ilop = 0; ilop < senArray.length; ilop++) {
					if (senArray[ilop] != null) {
						DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
						if (investigationId != 0) {
							if (investigationId != 0) {
								DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
								dgMasInvestigation.setId(investigationId);
								dgResultEntryDetailSen
										.setInvestigation(dgMasInvestigation);
							}
							if (investigationId != 0) {
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(investigationId);
								// dgResultEntryDetailSen.setChargeCode(masChargeCode);
							}
							if (sampleDetailId != 0) {
								DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
								dgSample.setId(sampleDetailId);
								dgResultEntryDetailSen
										.setSampleCollection(dgSample);
							}
							// MasAntibioticLab masAntibioticLab = new
							// MasAntibioticLab();
							// masAntibioticLab.setId(senArray[ilop]);
							String[] idsArray = new String[0];

							idsArray = senArray[ilop].split("@");
							int antibiticId = 0;
							int organismId = 0;
							int organismGroupId = 0;

							antibiticId = Integer.parseInt(idsArray[0]);

							organismId = Integer.parseInt(idsArray[1]);

							organismGroupId = Integer.parseInt(idsArray[2]);

							DgOrgDtl dgOrgDtl = (DgOrgDtl) session
									.createCriteria(DgOrgDtl.class)
									.createAlias("AntibioticLab", "Ab")
									.add(Restrictions.eq("Ab.Id", antibiticId))
									.add(Restrictions.eq("Organism.Id",
											organismId))
									.add(Restrictions.eq("OrganismGroup.Id",
											organismGroupId)).list().get(0);
							if (dgOrgDtl != null) {
								dgResultEntryDetailSen.setSensitivity(dgOrgDtl
										.getAntibioticLab());
								dgResultEntryDetailSen.setOrganism(dgOrgDtl
										.getOrganism());
								dgResultEntryDetailSen
										.setOrganismGroup(dgOrgDtl.getOrgGrp());
							}
							dgResultEntryDetailSen.setResult(resArray[ilop]);
							dgResultEntryDetailSen.setNosocomial(nosoc);
							dgResultEntryDetailSen
									.setResultEntry(dgResultEntryHeader);
							dgResultEntryDetailSen
									.setGrowthOption(growthOption);
							hbt.save(dgResultEntryDetailSen);
							dgResultEntryDetailSen = null;
						}
					}
				}
			}

			DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
					.load(DgSampleCollectionDetails.class, sampleDetailId);
			dgDetails.setOrderStatus("E");
			hbt.update(dgDetails);
			hbt.refresh(dgDetails);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	// -------------------------------End Methods developed by
	// Vivek------------------------------------------

	public Map<String, Object> getResultOrganismList(Map<String, Object> dataMap) {
		LOGGER.info("in getResultOrganismList");
		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("resultId") != null) {
				resultId = (Integer) dataMap.get("resultId");
			}

			Session session = (Session) getSession();

			List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
			List<DgMasOrganism> dgMasOrganismList = new ArrayList<DgMasOrganism>();
			dgMasOrganismList = session.createCriteria(DgMasOrganism.class)
					.add(Restrictions.eq("Status", "y")).list();
			if (resultId > 0) {
				dgResultEntryDetailSenList = session
						.createCriteria(DgResultEntryDetailSen.class)
						.createAlias("ResultEntry", "rs")
						.add(Restrictions.eq("rs.Id", resultId)).list();
			}

			if (dgResultEntryDetailSenList.size() > 0) {
				map.put("dgResultEntryDetailSenList",
						dgResultEntryDetailSenList);
			}
			map.put("dgMasOrganismList", dgMasOrganismList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public Map<String, Object> getResultSensitivityList(
			Map<String, Object> dataMap) {
		LOGGER.info("in getResultSensitivityList");
		Map<String, Object> map = new HashMap<String, Object>();
		int resultId = 0;
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		try {
			if (dataMap.get("resultId") != null) {
				resultId = (Integer) dataMap.get("resultId");
			}

			Session session = (Session) getSession();

			List<DgResultEntryDetailSen> dgResultEntryDetailSenList = new ArrayList<DgResultEntryDetailSen>();
			if (resultId > 0) {
				dgResultEntryDetailSenList = session
						.createCriteria(DgResultEntryDetailSen.class)
						.createAlias("ResultEntry", "rs")
						.add(Restrictions.eq("rs.Id", resultId)).list();
			}
			if (dgResultEntryDetailSenList.size() > 0) {
				map.put("dgResultEntryDetailSenList",
						dgResultEntryDetailSenList);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// map.put("dgOrgDtlList", dgOrgDtlList);
		return map;
	}

	public Map<String, Object> getResultEntryDetailsForTemplate(
			String resultNo, int deptId) {
		LOGGER.info("in getResultEntryDetailsForTemplate");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";

		Session session = (Session) getSession();
		try {
			dgResultdetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "r")
					.add(Restrictions.eq("r.ResultNo", resultNo))
					.add(Restrictions.eq("r.Department.Id", deptId)).list();
			if (dgResultdetailList != null || dgResultdetailList.size() > 0) {
				detailsMap.put("resultList", dgResultdetailList);
				detailsMap.put("hinNo", dgResultdetailList.get(0)
						.getResultEntry().getHin().getHinNo());

				Patient p = dgResultdetailList.get(0).getResultEntry().getHin();
				String prefix = "";
				prefix = p.getPrefix();
				detailsMap.put("prefix", prefix);

				String suffix = "";
				suffix = p.getSuffix();
				detailsMap.put("suffix", suffix);

				String pFullName = p.getPFirstName();
				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				// String sFullName = p.getSFirstName();
				// if(p.getSMiddleName() != null){
				// sFullName = sFullName + " " +p.getSMiddleName();
				// }
				// if(p.getSLastName() != null ){
				// sFullName = sFullName + " " +p.getSLastName();
				// }
				// detailsMap.put("servicePersonName", sFullName);

				detailsMap.put("orderNo", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultdetailList.get(0)
						.getResultEntry().getResultDate());
				detailsMap.put("subChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultdetailList.get(0)
						.getInvestigation().getInvestigationName());
				DgResultEntryDetail dgResultEntryDetail = dgResultdetailList
						.get(0);
				String clinicalNotes = dgResultEntryDetail
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNotes", clinicalNotes);

				String radioId = dgResultEntryDetail
						.getSampleCollectionDetails().getDiagNo();
				detailsMap.put("radioId", radioId);

				String confidential = dgResultEntryDetail.getInvestigation()
						.getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultdetailList.get(0).getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getEmpCategory().getEmpCategoryName() != null) {
						String entryPersonNameDesignation = e1.getEmpCategory()
								.getEmpCategoryName();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getEmpCategory().getEmpCategoryName() != null) {
						String entryPersonNameRank = e1.getEmpCategory()
								.getEmpCategoryName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}
				}
				MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getEmpCategory().getEmpCategoryName() != null) {
						String verifiedPersonNameDesignation = e2
								.getEmpCategory().getEmpCategoryName();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getEmpCategory().getEmpCategoryName() != null) {
						String verifiedPersonNameRank = e2.getEmpCategory()
								.getEmpCategoryName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForTemplate(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForTemplate");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemStockList = new ArrayList<StoreItemBatchStock>();
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		boolean saved = false;
		int sampleDetailId = 0;
		int itemId = 0;
		int fileUsed = 0;
		int balance = 0;
		StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
		DgResultEntryHeader dgResultEntryHeader = (DgResultEntryHeader) parameterMap
				.get("dgResultEntryHeader");
		DgResultEntryDetail dgResultEntryDetail = (DgResultEntryDetail) parameterMap
				.get("dgResultEntryDetail");
		sampleDetailId = (Integer) parameterMap.get("sampleDetailId");
		if (parameterMap.get("itemId") != null) {
			itemId = (Integer) parameterMap.get("itemId");
		}
		if (parameterMap.get("filmUsed") != null) {
			fileUsed = (Integer) parameterMap.get("filmUsed");
		}
		
		String filename = "";
		if(parameterMap.get("filename")!= null){
			filename =(String) parameterMap.get("filename");
		}
		String uploadURL = "";
		if(parameterMap.get("uploadURL")!= null){
			uploadURL =(String) parameterMap.get("uploadURL");
		}
		
		
		session = (Session) getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(dgResultEntryHeader);
			hbt.save(dgResultEntryDetail);
			DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
					.load(DgSampleCollectionDetails.class, sampleDetailId);
			dgDetails.setOrderStatus("E");
			hbt. saveOrUpdate(dgDetails); 
			//hbt.refresh(dgDetails);
			balance = fileUsed;
			int remainStock = 0;
			int balanceStock = 0;
			Criteria crit =null;
			if(itemId>0){
			 crit = session.createCriteria(StoreItemBatchStock.class)
					.add(Restrictions.eq("Item.Id", itemId))
					.add(Restrictions.gt("ClosingStock", new BigDecimal(0)));
			itemStockList = crit.list();
			}
			if (itemStockList.size() > 0) {
				for (int i = 0; i < itemStockList.size(); i++) {

					if (fileUsed <= itemStockList.get(i).getClosingStock()
							.intValue()) {
						remainStock = itemStockList.get(i).getClosingStock()
								.intValue()
								- fileUsed;
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class,
										itemStockList.get(i).getId());
						storeItemBatchStock.setClosingStock(new BigDecimal(
								remainStock));
						hbt.update(storeItemBatchStock);
						break;
					} else if (fileUsed > itemStockList.get(i)
							.getClosingStock().intValue()) {
						balanceStock = fileUsed
								- itemStockList.get(i).getClosingStock()
										.intValue();
						storeItemBatchStock = (StoreItemBatchStock) getHibernateTemplate()
								.load(StoreItemBatchStock.class,
										itemStockList.get(i).getId());
						storeItemBatchStock.setClosingStock(new BigDecimal(0));
						hbt.update(storeItemBatchStock);
						fileUsed = balanceStock;
					}

				}
			}
			
			// upload documents Added by vinay
			
			String fileExtension=null;
			 File file=null;
			
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					if(filename.length()>0)
					{
						//System.out.println(uploadURL+" -- "+filename);
						 file=new File(uploadURL + "/" + filename);
			    		// System.out.println("path>>"+file.getPath());
			    		
			    	     FileInputStream is = new FileInputStream(file);
			    	     long length = file.length();
			    	     ByteBuffer byteBuff=null;
			    	   //  int modLength=length/
			    	     if (length > Integer.MAX_VALUE) {
			            // File is too large
			    	     }
			    	     // Create the byte array to hold the data
			    	     byte[] bytes = new byte[(int)length];
			    	     int offset = 0;
			    	     int numRead = 0;
			    	     while (offset < bytes.length
			    	    		 && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			    	    	 offset += numRead;
			    	    	
			    	     }
			    
			    	     if (offset < bytes.length) {
			    	    	 throw new IOException("Could not completely read file "+file.getName());
			    	         
			    	     }
			    	     is.close();
			        
			    	     
			    	     UploadDocuments resultEntryDoc = new UploadDocuments();
			    	     resultEntryDoc.setPatientDocument(bytes);
			    	     
			    	     int indexNo = filename.lastIndexOf("."); 
			    	     String actualfileName = filename.substring(0, indexNo);
			    	     fileExtension = filename.substring(indexNo+1);
			    	     resultEntryDoc.setFileName(actualfileName);
			    	     resultEntryDoc.setFileExtension(fileExtension);
			    	     resultEntryDoc.setResultEntry(dgResultEntryHeader);
			    	     if(parameterMap.get("hospitalId")!= null){
			    				int hospitalId =(Integer)(parameterMap.get("hospitalId"));
			    				
			    				if(hospitalId != 0)
			    				{
			    					MasHospital h = new MasHospital();
			    					h.setId(hospitalId);
			    					resultEntryDoc.setHospital(h);
			    				}
			    			}    	    
			    	   
			    	    
			    	     hbt.save(resultEntryDoc);
			    	     hbt.flush();
			    	     hbt.refresh(resultEntryDoc);
					}
					

			tx.commit();
			saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			// throw e; // or display error message
			e.printStackTrace();
		}

		map.put("saved", saved);
		return map;
	}

	public boolean updateResultTemplateForValidation(Map<String, Object> dataMap) {
		LOGGER.info("in updateResultTemplateForValidation");
		List<DgResultEntryHeader> resultList = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
		Session session = (Session) getSession();
		String resultNo = "";
		String templateData = "";
		boolean flag = false;

		int deptId = 0;
		try {
			if (dataMap.get("resultNo") != null) {
				resultNo = (String) dataMap.get("resultNo");
			}
			if (dataMap.get("deptId") != null) {
				deptId = (Integer) dataMap.get("deptId");
			}
			if (dataMap.get("templateData") != null) {
				templateData = (String) dataMap.get("templateData");
			}
			dgResultdetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "r")
					.add(Restrictions.eq("r.ResultNo", resultNo))
					.add(Restrictions.eq("r.Department.Id", deptId)).list();
			DgResultEntryDetail dgResultEntryDetail = dgResultdetailList.get(0);
			dgResultEntryDetail.setResult(templateData);
			session.update(dgResultEntryDetail);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean submitResultValidationForSensitivity(
			Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationForSensitivity");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		String remarks = "";
		remarks = (String) infoMap.get("remarks");

		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}
		String result1 = "";
		String result2 = "";
		String nosoc = "";
		result1 = (String) infoMap.get("result1");
		result2 = (String) infoMap.get("result2");
		nosoc = (String) infoMap.get("nosoc");
		String growthOption = "";
		if (infoMap.get("growthOption") != null) {
			growthOption = (String) infoMap.get("growthOption");
		}
		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultValidatedBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultValidatedBy);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}

			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setRemarks(remarks);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			String result = box.getString(RequestConstants.RESULT);
			String additionalRemarks = box
					.getString(RequestConstants.ADDITIONAL_REMARKS);
			String validated = box.getString(RequestConstants.VALIDATED);
			/*
			 * List<DgResultEntryDetail> dgResultDetailList = new
			 * ArrayList<DgResultEntryDetail>();
			 * 
			 * dgResultDetailList =
			 * session.createCriteria(DgResultEntryDetail.class
			 * ).add(Restrictions.eq("ResultEntry.Id", resultId)).list(); if
			 * (dgResultDetailList!=null && dgResultDetailList.size()>0) {
			 * DgResultEntryDetail dgResultEntryDetail = new
			 * DgResultEntryDetail();
			 * dgResultEntryDetail=dgResultDetailList.get(0);
			 * dgResultEntryDetail.setValidated("Y");
			 * dgResultEntryDetail.setResultDetailStatus("A");
			 * dgResultEntryDetail.setRemarks(additionalRemarks);
			 * dgResultEntryDetail.setResult(result);
			 * hbt.saveOrUpdate(dgResultEntryDetail); }
			 */
			List dgResultEntryDetailSenList = session
					.createCriteria(DgResultEntryDetailSen.class)
					.createAlias("ResultEntry", "result")
					.add(Restrictions.eq("result.Id", resultId)).list();
			int index = 1;

			String[] senArray = (String[]) infoMap.get("senArray");
			int sampleDetailId = 0;
			int investigationId = 0;

			if (infoMap.get("sampleDetailId") != null) {
				sampleDetailId = (Integer) infoMap.get("sampleDetailId");
			}
			if (infoMap.get("investigationId") != null) {
				investigationId = (Integer) infoMap.get("investigationId");
			}
			String[] resArray = (String[]) infoMap.get("resArray");
			DgResultEntryDetailSen temp = null;
			if (growthOption.equalsIgnoreCase("g")) {
				if (senArray != null && senArray.length > 0) {
					Query deleteQuery = session
							.createQuery("delete from DgResultEntryDetailSen "
									+ "where ResultEntry.Id=" + resultId);
					int row = deleteQuery.executeUpdate();
					if (row == 0) {

					} else {

					}
					tx.commit();
					tx = session.beginTransaction();
					for (int ilop = 0; ilop < senArray.length; ilop++) {
						if (senArray[ilop] != null) {
							DgResultEntryDetailSen dgResultEntryDetailSen = new DgResultEntryDetailSen();
							if (investigationId != 0) {
								if (investigationId != 0) {
									DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
									dgMasInvestigation.setId(investigationId);
									dgResultEntryDetailSen
											.setInvestigation(dgMasInvestigation);
								}

								if (sampleDetailId != 0) {
									DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
									dgSample.setId(sampleDetailId);
									dgResultEntryDetailSen
											.setSampleCollection(dgSample);
								}

								String[] idsArray = new String[0];

								idsArray = senArray[ilop].split("@");
								int antibiticId = 0;
								int organismId = 0;
								int organismGroupId = 0;

								antibiticId = Integer.parseInt(idsArray[0]);
								organismId = Integer.parseInt(idsArray[1]);
								organismGroupId = Integer.parseInt(idsArray[2]);

								MasAntibioticLab antibioticLab = new MasAntibioticLab();
								antibioticLab.setId(antibiticId);
								dgResultEntryDetailSen
										.setSensitivity(antibioticLab);

								DgMasOrganism dgMasOrganism = new DgMasOrganism();
								dgMasOrganism.setId(organismId);
								dgResultEntryDetailSen
										.setOrganism(dgMasOrganism);

								DgMasOrganismGroup dgMasOrganismGroup = new DgMasOrganismGroup();
								dgMasOrganismGroup.setId(organismGroupId);
								dgResultEntryDetailSen
										.setOrganismGroup(dgMasOrganismGroup);

								dgResultEntryDetailSen
										.setResult(resArray[ilop]);
								dgResultEntryDetailSen.setNosocomial(nosoc);
								dgResultEntryDetailSen
										.setResultEntry(dgEntryHeader);
								dgResultEntryDetailSen
										.setGrowthOption(growthOption);
								hbt.save(dgResultEntryDetailSen);
								dgResultEntryDetailSen = null;
							}
						}
					}
				}

			} else {
				DgResultEntryDetailSen newDgResultEntryDetailSen = (DgResultEntryDetailSen) dgResultEntryDetailSenList
						.get(0);
				newDgResultEntryDetailSen.setResultOther(result2);
				newDgResultEntryDetailSen.setResult(result1);
				newDgResultEntryDetailSen.setNosocomial(nosoc);
				hbt.update(newDgResultEntryDetailSen);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}

		return successfullyAdded;
	}

	public Map<String, Object> getResultGridLab(Map<String, Object> mapForDs) {
		LOGGER.info("in getResultGridLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Object[]> patientList = new ArrayList<Object[]>();
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();
		int subChargeCodeId = 0;
		Date currentDate = new Date();
		Date fromDate = new Date();
		Date toDate = new Date();
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		String patientType = "";
		String orderType = "";
		int departmentId = 0;
		int hinId = 0;
		int sampleCollectionDetailId = 0;
		int deptId = 0;
		int hospitalId=0;
		String mobileNo = "";
		String wardName = "";
		String barcodetext = "";

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		String deptName = "";
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ mapForDs.get(RequestConstants.HOSPITAL_ID));
		}
		String RequisitionFrom ="NA";
		if (mapForDs.get("hinId") != null) {
			hinId = Integer.parseInt("" + mapForDs.get("hinId"));
		}
		if (mapForDs.get("RequisitionFrom") != null) {
			RequisitionFrom =(String) mapForDs.get("RequisitionFrom");
		}
		
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		} 
		
		if (mapForDs.get("patientType") != null) {
			patientType = (String) mapForDs.get("patientType");
		} 
		
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("sampleCollectionDetailId") != null) {
			sampleCollectionDetailId = (Integer) mapForDs
					.get("sampleCollectionDetailId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		
		if (mapForDs.get("wardName") != null) {
			wardName = (String) mapForDs.get("wardName");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String) mapForDs.get("barcodetext");
		}
		
		
		// added by amit das on 27-07-2017
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}

		String hospitalCode="";
		
		try {
			MasHospital hos=(MasHospital)session.get(MasHospital.class, hospitalId);
						if(hos!=null){
							hospitalCode=hos.getHospitalCode();
						}
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "A"))
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("Investigation", "inv")
					.createAlias("sampleHead.Hin", "pt")
					.add(Restrictions.ge("sampleHead.SampleValidationDate",
							fromDate))
					.add(Restrictions.le("sampleHead.SampleValidationDate",
							toDate));					
				// added by amit das on 27-07-2017 
				if(subChargeCodeId!=0)
					crit =	crit.createAlias("Subcharge", "scc").add(Restrictions.eq("scc.Id", subChargeCodeId));
							
							
				crit = crit.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			//System.out.println("hinId="+hinId);
			//System.out.println("RequisitionFrom="+RequisitionFrom+"v");
			
			if(hinId != 0)
			{
				if(RequisitionFrom.equalsIgnoreCase("OPD"))
				{
					crit = crit.add(Restrictions.eq("inv.SubmittedByDoctor", "y").ignoreCase());
				}
			}
			else
			{
				crit= crit.createAlias("ChargeCode", "mcc").createAlias("mcc.Department", "dept");
				crit= crit.add(Restrictions.eq("dept.Id", deptId));
				//crit = crit.add(Restrictions.or(Restrictions.eq("inv.SubmittedByDoctor", "n").ignoreCase(),Restrictions.isNull("inv.SubmittedByDoctor")));
			}
			
			if (!barcodetext.equals("")) {
				if(hospitalCode!=null){
					barcodetext=hospitalCode+barcodetext;
				}
				System.out.println("barcodetext "+barcodetext);
				crit=crit.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
			}


			if (hinId != 0) {
				crit = crit.add(Restrictions.eq("pt.Id", hinId));
			}
			if (!hinNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
			}
			
			if (!patientType.equals("")) {
				crit = crit.add(Restrictions.eq("pt.PatientStatus", patientType));
			}
			
			if (!patientFName.equals("")) {
				crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName
						+ "%").ignoreCase());
			}
			if (!mobileNo.equals("")) {
				crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
			}
			
			if (!adNo.equals("") || !wardName.equals("")) {
				crit = crit.createAlias("sampleHead.Inpatient", "ip");
			}
			
			if (!adNo.equals("")) {
				crit = crit.add(
						Restrictions.eq("ip.AdNo", adNo));
			}
			if (!wardName.equals("")) {
				crit = crit.createAlias("ip.Department", "dpt");
				crit = crit.add(Restrictions.eq("dpt.DepartmentName",
						wardName));
			}
			crit.setProjection(Projections.projectionList()
					.add(Projections.groupProperty("SampleCollectionHeader"))
					.add(Projections.groupProperty("Subcharge"))
					//added by govind 06-07-2017
					.add(Projections.groupProperty("DiagNo"))
					.add(Projections.groupProperty("sampleHead.Hin"))
					.add(Projections.groupProperty("sampleHead.DiagnosisDate")));
			
			patientList = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Collections.sort(patientList, new DiagNoComparator());
		map.put("patientList", patientList);
		return map;
	}
	
	public Map<String, Object> getResultGridLabForEmpanelled(Map<String, Object> mapForDs) {
		LOGGER.info("in getResultGridLabForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Object[]> patientList = new ArrayList<Object[]>();
		List<DgSampleCollectionHeader> dgSampleCollectionHeaderList = new ArrayList<DgSampleCollectionHeader>();

		Date currentDate = new Date();

		Session session = (Session) getSession();
		Criteria crit = null;
		if (mapForDs.get("currentDate") != null) {
			currentDate = (Date) mapForDs.get("currentDate");
		}
		String deptName = "";
		if (map.get("dataMap") != null) {
			dataMap = (Map<String, Object>) map.get("dataMap");
		}
		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		Integer hospitalId = 0;
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt(""
					+ mapForDs.get(RequestConstants.HOSPITAL_ID));
		}
		int hinId = 0;
		String RequisitionFrom ="NA";
		if (mapForDs.get("hinId") != null) {
			hinId = Integer.parseInt("" + mapForDs.get("hinId"));
		}
		if (mapForDs.get("RequisitionFrom") != null) {
			RequisitionFrom =(String) mapForDs.get("RequisitionFrom");
		}
		
		
		try {
			crit = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("OrderStatus", "A"))
					.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("Investigation", "inv")
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					.add(Restrictions.eq("sampleHead.SampleValidationDate",
							currentDate))
					.add(Restrictions.or(Restrictions.eq("sampleHead.Hospital.Id", hospitalId),
							Restrictions.eq("sampleHead.ReferHospital.Id", hospitalId)))
					.setProjection(
							Projections
									.projectionList()
									.add(Projections
											.groupProperty("SampleCollectionHeader"))
									.add(Projections.groupProperty("Subcharge")));
			//System.out.println("hinId="+hinId);
			//System.out.println("RequisitionFrom="+RequisitionFrom+"v");
			
			if(hinId != 0)
			{
				if(RequisitionFrom.equalsIgnoreCase("OPD"))
				{
					crit = crit.add(Restrictions.eq("inv.SubmittedByDoctor", "y").ignoreCase());
				}
			}
			else
			{
				crit= crit.createAlias("sampleHead.Department", "dept");
				crit= crit.add(Restrictions.eq("dept.Id", deptId));
				crit = crit.add(Restrictions.eq("inv.SubmittedByDoctor", "n").ignoreCase());
			}
			patientList = crit.list();
			//System.out.println("patientList="+patientList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("patientList", patientList);
		return map;
	}

	public String generateResultNumberForLab(Map<String, Object> diagMap) {
		LOGGER.info("in generateResultNumberForLab");
		Map<String, Object> map = new HashMap<String, Object>();
		List<TransactionSequence> resultSeqNoList = new ArrayList<TransactionSequence>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		Session session = (Session) getSession();
		String resultSeqNo = "";
		String date = "";
		date = (String) utilMap.get("currentDate");
		String month = "";
		String year = "";
		String currentMonth = date.substring(date.indexOf("/") + 1,
				date.lastIndexOf("/"));
		String currentYear = date.substring(date.lastIndexOf("/") + 1);

		resultSeqNoList = session.createCriteria(TransactionSequence.class)
				.add(Restrictions.eq("TransactionPrefix", "RES")).list();

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		if (resultSeqNoList.size() > 0) {
			for (TransactionSequence transactionSequence : resultSeqNoList) {
				TransactionSequence obj = (TransactionSequence) resultSeqNoList
						.get(0);
				int id = obj.getId();
				int seqNo = obj.getTransactionSequenceNumber();

				TransactionSequence transactionSequenceObj = (TransactionSequence) hbt
						.load(TransactionSequence.class, id);
				++seqNo;
				transactionSequenceObj.setTransactionSequenceNumber(seqNo);
				hbt.update(transactionSequenceObj);
				hbt.refresh(transactionSequenceObj);
				resultSeqNo = resultSeqNo.concat(String.valueOf(seqNo));
				resultSeqNo = resultSeqNo.concat("/").concat(currentMonth);
				resultSeqNo = resultSeqNo.concat("/").concat(currentYear);
			}
		} else if (resultSeqNoList.size() == 0) {
			TransactionSequence tsObj = new TransactionSequence();
			tsObj.setStatus("y");
			tsObj.setTablename("DgResultEntryHeader");
			tsObj.setTransactionPrefix("RES");
			tsObj.setTransactionSequenceName("Result No");
			tsObj.setTransactionSequenceNumber(0);

			hbt.save(tsObj);
			hbt.refresh(tsObj);
		}
		return resultSeqNo;
	}

	public Map<String, Object> getDetailsForLab(Map<String, Object> dataMap) {
		LOGGER.info("in getDetailsForLab");
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		MasHospital masHospital= null;
		if (dataMap.get("deptId") != null) {
			deptId = Integer.parseInt("" + dataMap.get("deptId"));
		}
		if (dataMap.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
		}
		if (dataMap.get("userName") != null) {
			userName = ("" + dataMap.get("userName"));
		}

		String search="Y";
		if(dataMap.get("search")!=null){
			search=(String)dataMap.get("search");
		}
		dataMap.put("search", search);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
		List<MasSample> sampleList = new ArrayList<MasSample>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		investigationList=session.createCriteria(DgMasInvestigation.class)
				.add(Restrictions.eq("MainChargecode.Id", 17))
				.addOrder(Order.asc("InvestigationName")).list();
		subChargeCodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId)).list();
		dgMasOrganismGroupList = session
				.createCriteria(DgMasOrganismGroup.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (subChargeCodeList.size() > 0) {
			detailsMap.put("subChargeCodeList", subChargeCodeList);
		}

		sampleList = getHibernateTemplate().find(
				"from jkt.hms.masters.business.MasSample order by SampleDescription asc");
		if (sampleList.size() > 0) {
			detailsMap.put("sampleList", sampleList);
		}
		if(!search.equals("ResultEntry")){//added by govind 02-06-2017 for result entry search slow
		employeeList = session.createCriteria(MasEmployee.class)
				.add(Restrictions.eq("EmpCategory.Id", 4)).list();
		if (employeeList != null && employeeList.size() > 0) {
			detailsMap.put("employeeList", employeeList);
		}
		}
		departmentList = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (departmentList.size() > 0) {
			detailsMap.put("departmentList", departmentList);
		}
		if(!search.equals("ResultEntry")){//added by govind 02-06-2017 for result entry search slow
		chargeCodeList = session.createCriteria(MasChargeCode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase()).list();
		if (chargeCodeList.size() > 0) {
			detailsMap.put("chargeCodeList", chargeCodeList);
		}
		}
		
		if(hospitalId!=0)
			masHospital = 	(MasHospital)session.get(MasHospital.class, hospitalId);
		
		detailsMap.put("dgMasOrganismGroupList", dgMasOrganismGroupList);
		detailsMap.put("investigationList", investigationList);
		detailsMap.put("masHospital", masHospital);
		return detailsMap;
	}

	public Map<String, Object> getPatientDetailsForLab(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForLab");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> patientList = new ArrayList<Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int subChargeCodeId = 0;
		String billNo = "";
		Integer hospitalId = 0;
		String diagnosisNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		String barcodetext="";
		String sampleIdSearch=null;
		int deptId = 0;
		int chargeCode = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		int sampleId=0;
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("billNo") != null) {
			billNo = (String) mapForDs.get("billNo");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get(RequestConstants.CHARGE_CODE) != null) {
			chargeCode = (Integer) mapForDs.get(RequestConstants.CHARGE_CODE);
		}
	
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String)mapForDs.get("barcodetext");
	 	    //mapForDs.put("barcodetext",barcodetext); 
	 					
		}
		if (mapForDs.get("sampleIdSearch") != null) {
			sampleIdSearch = (String)mapForDs.get("sampleIdSearch");
	 	    //mapForDs.put("barcodetext",barcodetext); 
	 					
		}
		List<Integer>invFinalList=new ArrayList<Integer>();
		if (mapForDs.get("invFinalList") != null) {
			invFinalList = (List<Integer>) mapForDs.get("invFinalList");
		}
		
		
		crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "A"))
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("ChargeCode", "mcc")
				.createAlias("mcc.Department", "dept")
				.createAlias("sampleHead.Hin", "pt")
				.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
				// .createAlias("sampleHead.Inpatient", "ip")
				.add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				// .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(Restrictions.between("sampleHead.SampleValidationDate",
						fromDate, toDate))
						//added by govind 06-07-2017
				.addOrder(Order.asc("DiagNo"))
			    .addOrder(Order.asc("sampleHead.DiagnosisDate"));
		//added by govind 06-07-2017 end
		if (barCode != 0) {
			crit = crit.add(Restrictions.like("DiagNo", "" + barCode));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.obileNumber", mobileNo));
		}
		
		if (!barcodetext.equals("")) {
			LOGGER.info("barcodetext "+barcodetext);
			crit=crit.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
		}
		
		if (sampleIdSearch!=null) {
			crit = crit.add(
					Restrictions.eq("DiagNo", sampleIdSearch));
		}
		
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%").ignoreCase());
		}

		if (!adNo.equals("")) {
			crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
		}
		if (!wardName.equals("")) {
			crit.add(Restrictions.eq(
					"sampleHead.Inpatient.Department.DepartmentName", wardName));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("sampleHead.Department.Id",
					departmentId));
		}
		if (!billNo.equals("")) {
			crit = crit.add(Restrictions.eq("or.BillChargeSlpNo", billNo));
		}
		if (subChargeCodeId != 0) {
			crit.createAlias("Subcharge", "subChrg").add(
					Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		if (chargeCode != 0) {
			crit = crit.createAlias("ChargeCode", "charge").add(
					Restrictions.eq("charge.Id", chargeCode));
		}
		if(sampleId!=0){
			crit = crit.createAlias("Investigation","Investigation").createAlias("Investigation.Sample", "sample")
					.add(Restrictions.eq("sample.Id", sampleId));
		}
		if(invFinalList!=null && invFinalList.size()>0){
			crit = crit.add(Restrictions.in("Investigation.Id", invFinalList));
		}
		crit = crit.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("SampleCollectionHeader"))
				.add(Projections.groupProperty("Subcharge"))
				//added by govind 06-07-2017
				.add(Projections.groupProperty("DiagNo"))
				.add(Projections.groupProperty("sampleHead.Hin"))
				.add(Projections.groupProperty("sampleHead.DiagnosisDate")));
		//added by govind 06-07-2017
		patientList = crit.list();
		
		Collections.sort(patientList, new DiagNoComparator());
		map.put("patientDetailsList", patientList);
		return map;
	}
	
	public Map<String, Object> getPatientDetailsForLabForEmpanelled(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForLabForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> patientList = new ArrayList<Object>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int subChargeCodeId = 0;
		String billNo = "";
		Integer hospitalId = 0;
		String diagnosisNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		int deptId = 0;
		int chargeCode = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		int sampleId=0;
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("billNo") != null) {
			billNo = (String) mapForDs.get("billNo");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get(RequestConstants.CHARGE_CODE) != null) {
			chargeCode = (Integer) mapForDs.get(RequestConstants.CHARGE_CODE);
		}
		List<Integer>invFinalList=new ArrayList<Integer>();
		if (mapForDs.get("invFinalList") != null) {
			invFinalList = (List<Integer>) mapForDs.get("invFinalList");
		}
		
		
		crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "A"))
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("sampleHead.Department", "dept")
				.createAlias("sampleHead.Hin", "pt")
				.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
				// .createAlias("sampleHead.Inpatient", "ip")
				.add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				// .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(Restrictions.between("sampleHead.SampleValidationDate",
						fromDate, toDate));
		if (barCode != 0) {
			crit = crit.add(Restrictions.like("DiagNo", "" + barCode));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.obileNumber", mobileNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}

		if (!adNo.equals("")) {
			crit = crit.add(Restrictions.eq("ip.AdNo", adNo));
		}
		if (!wardName.equals("")) {
			crit.add(Restrictions.eq(
					"sampleHead.Inpatient.Department.DepartmentName", wardName));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("sampleHead.Department.Id",
					departmentId));
		}
		if (!billNo.equals("")) {
			crit = crit.add(Restrictions.eq("or.BillChargeSlpNo", billNo));
		}
		if (subChargeCodeId != 0) {
			crit.createAlias("Subcharge", "subChrg").add(
					Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		if (chargeCode != 0) {
			crit = crit.createAlias("ChargeCode", "charge").add(
					Restrictions.eq("charge.Id", chargeCode));
		}
		if(sampleId!=0){
			crit = crit.createAlias("Investigation","Investigation").createAlias("Investigation.Sample", "sample")
					.add(Restrictions.eq("sample.Id", sampleId));
		}
		if(invFinalList!=null && invFinalList.size()>0){
			crit = crit.add(Restrictions.in("Investigation.Id", invFinalList));
		}
		crit = crit.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("SampleCollectionHeader"))
				.add(Projections.groupProperty("Subcharge")));
		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetailsForLab(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getSampleCollectionDetailsForLab");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgFixedValue> fixedValAllList = new ArrayList<DgFixedValue>();
		List<List<DgFixedValue>> allFixedValueList = new ArrayList<List<DgFixedValue>>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List subListTemp = new ArrayList();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int deptId = 0;
		int dgSampleHeaderId = 0;
		int dgSampleDetailsId = 0;
		int subChargeId = 0;
		int subTestId = 0;
		Integer hospitalId = 0;
		if (mapForDs.get("dgSampleHeaderId") != null) {
			dgSampleHeaderId = (Integer) mapForDs.get("dgSampleHeaderId");
		}
		
		if (mapForDs.get("dgSampleDetailsId") != null) {
			dgSampleDetailsId = (Integer) mapForDs.get("dgSampleDetailsId");
		}
		
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}

		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					// .add(Restrictions.isNotNull("Collection"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
			
			Criteria criteria = session
					.createCriteria(DgSampleCollectionDetails.class);
				
			if(dgSampleHeaderId!=0)
					criteria =	criteria.add(Restrictions.eq("SampleCollectionHeader.Id",
							dgSampleHeaderId));
					/*
					 * Code is changed By Mukesh Previous Code is on the behalf
					 * of subchargeCodeId But Now this is replaced by
					 * investigation is Date 18 Apr 2011
					 */
			if(subChargeId!=0)
				criteria= 	criteria.add(Restrictions.eq("Subcharge.Id", subChargeId));	
			
			
				criteria= 	criteria.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
								.add(Restrictions.eq("OrderStatus", "A"));
				
			// added by amit das on 31-08-2017
			if(dgSampleDetailsId!=0)		
				criteria = criteria.add(Restrictions.eq("Id", dgSampleDetailsId));
			
			sampleCollectionList = 	criteria.createAlias("Investigation", "inv")
					.addOrder(Order.asc("inv.InvestigationName"))
					// .addOrder(Order.asc("inv.TestOrderNo"))
					// .addOrder(Order.desc("inv.InvestigationType"))
					.list();
			if (sampleCollectionList.size() > 0) {
				detailsMap.put("sampleCollectionList", sampleCollectionList);

			}

			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();

					subList = session
							.createCriteria(DgSubMasInvestigation.class)
							.add(Restrictions.eq("Investigation.Id",
									investigationId))
							.addOrder(Order.asc("OrderNo")).list();
					subListTemp.add(subList);
				}
			}
			if (subList.size() > 0) {
				// for(DgSubMasInvestigation dgSubMasInvestigation : subList){
				detailsMap.put("subList", subList);
				detailsMap.put("subListTemp", subListTemp);
				// }
			}

			for (DgSampleCollectionDetails dgApp1 : sampleCollectionList) {

				subInvSet = dgApp1.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

					fixedValList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
									+ subTestId
									+ "' and ga.FixedValue != null order by ga.Id asc");
					if (fixedValList.size() > 0) {
						fixedValAllList.addAll(fixedValList);
						detailsMap.put("fixedValList", fixedValAllList);

					}
				}
				allFixedValueList.add(fixedValAllList);
				detailsMap.put("allFixedValueList", allFixedValueList);
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subTempSet = dgApp.getInvestigation().getDgTemplates();
				for (DgTemplate dgTemplate : subTempSet) {
					investigationId = dgTemplate.getInvestigation().getId();
					templateList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= '"
									+ investigationId + "'");

					if (templateList.size() > 0) {
						detailsMap.put("templateList", templateList);
					}
				}
			}
			if (sampleCollectionList.size() > 0) {
			 criteria = null;
				criteria = session.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.eq("SampleCollectionDetails.Id",
								sampleCollectionList.get(0).getId()));
				dgResultEntryDetailList = criteria.list();
				detailsMap.put("dgResultEntryDetailListForResult",
						dgResultEntryDetailList);
				
                int resultCount=0; 
				if(dgResultEntryDetailList.size()>0){
					for(DgResultEntryDetail reEnt:dgResultEntryDetailList){
						//if(reEnt.getSubInvestigation().getResultType().equalsIgnoreCase("r")){
							if(reEnt.getResult()!=null){
								resultCount++;
								break;
							}
						//}
					}
				}
				if(resultCount>0){
					detailsMap.put("resultCount",
							resultCount);
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getSampleCollectionDetailsForLabForEmpanelled(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getSampleCollectionDetailsForLabForEmpanelled");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		DgSampleCollectionDetails dgApp = new DgSampleCollectionDetails();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();

		List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		Set<DgSubMasInvestigation> subInvSet = new HashSet<DgSubMasInvestigation>();
		List<DgFixedValue> fixedValList = new ArrayList<DgFixedValue>();
		List<DgFixedValue> fixedValAllList = new ArrayList<DgFixedValue>();
		List<List<DgFixedValue>> allFixedValueList = new ArrayList<List<DgFixedValue>>();
		List<DgSubMasInvestigation> subList = new ArrayList<DgSubMasInvestigation>();
		List subListTemp = new ArrayList();
		List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();

		List<DgTemplate> templateList = new ArrayList<DgTemplate>();
		Set<DgTemplate> subTempSet = new HashSet<DgTemplate>();
		int investigationId = 0;
		int deptId = 0;
		int dgSampleHeaderId = 0;
		int subChargeId = 0;
		int subTestId = 0;
		Integer hospitalId = 0;
		if (mapForDs.get("dgSampleHeaderId") != null) {
			dgSampleHeaderId = (Integer) mapForDs.get("dgSampleHeaderId");
		}
		if (mapForDs.get("subChargeId") != null) {
			subChargeId = (Integer) mapForDs.get("subChargeId");
		}
		if (mapForDs.get("deptId") != null) {
			deptId = (Integer) mapForDs.get("deptId");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}

		Session session = (Session) getSession();

		try {
			employeeList = session.createCriteria(MasEmployee.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (employeeList.size() > 0) {
				detailsMap.put("employeeList", employeeList);
			}
			investigationList = session
					.createCriteria(DgMasInvestigation.class)
					// .add(Restrictions.isNotNull("Collection"))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (investigationList.size() > 0) {
				detailsMap.put("investigationList", investigationList);
			}
			sampleCollectionList = session
					.createCriteria(DgSampleCollectionDetails.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",
							dgSampleHeaderId))
					/*
					 * Code is changed By Mukesh Previous Code is on the behalf
					 * of subchargeCodeId But Now this is replaced by
					 * investigation is Date 18 Apr 2011
					 */
					.add(Restrictions.eq("Subcharge.Id", subChargeId))
					// .add(Restrictions.eq("Investigation.Id", subChargeId))
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase()) 
					.add(Restrictions.eq("OrderStatus", "A"))
					.createAlias("Investigation", "inv")
					.addOrder(Order.asc("inv.InvestigationName"))
					// .addOrder(Order.asc("inv.TestOrderNo"))
					// .addOrder(Order.desc("inv.InvestigationType"))
					.list();
			if (sampleCollectionList.size() > 0) {
				detailsMap.put("sampleCollectionList", sampleCollectionList);

			}

			if (sampleCollectionList.size() > 0) {
				for (DgSampleCollectionDetails dgSampleCollectionDetails2 : sampleCollectionList) {
					investigationId = dgSampleCollectionDetails2
							.getInvestigation().getId();

					subList = session
							.createCriteria(DgSubMasInvestigation.class)
							.add(Restrictions.eq("Investigation.Id",
									investigationId))
							.addOrder(Order.asc("OrderNo")).list();
					subListTemp.add(subList);
				}
			}
			if (subList.size() > 0) {
				// for(DgSubMasInvestigation dgSubMasInvestigation : subList){
				detailsMap.put("subList", subList);
				detailsMap.put("subListTemp", subListTemp);
				// }
			}

			for (DgSampleCollectionDetails dgApp1 : sampleCollectionList) {

				subInvSet = dgApp1.getInvestigation()
						.getDgSubMasInvestigations();

				for (DgSubMasInvestigation dgSub : subInvSet) {
					subTestId = dgSub.getId();

					fixedValList = getHibernateTemplate()
							.find("from jkt.hms.masters.business.DgFixedValue ga where ga.SubInvestigation.Id= '"
									+ subTestId
									+ "' and ga.FixedValue != null order by ga.Id asc");
					if (fixedValList.size() > 0) {
						fixedValAllList.addAll(fixedValList);
						detailsMap.put("fixedValList", fixedValAllList);

					}
				}
				allFixedValueList.add(fixedValAllList);
				detailsMap.put("allFixedValueList", allFixedValueList);
			}

			if (sampleCollectionList.size() > 0) {
				dgApp = (DgSampleCollectionDetails) sampleCollectionList.get(0);
				subTempSet = dgApp.getInvestigation().getDgTemplates();
				for (DgTemplate dgTemplate : subTempSet) {
					investigationId = dgTemplate.getInvestigation().getId();
					templateList = getHibernateTemplate().find(
							"from jkt.hms.masters.business.DgTemplate dt where dt.Investigation.Id= '"
									+ investigationId + "'");

					if (templateList.size() > 0) {
						detailsMap.put("templateList", templateList);
					}
				}
			}
			if (sampleCollectionList.size() > 0) {
				Criteria criteria = null;
				criteria = session.createCriteria(DgResultEntryDetail.class)
						.add(Restrictions.eq("SampleCollectionDetails.Id",
								sampleCollectionList.get(0).getId()));
				dgResultEntryDetailList = criteria.list();
				detailsMap.put("dgResultEntryDetailListForResult",
						dgResultEntryDetailList);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public boolean submitResultValidationLab(Map<String, Object> infoMap) {
		LOGGER.info("submitResultValidationLab function");
		Session session=null;
		session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = true;
		List<String> validatedListMultipleType = new ArrayList<String>();
		
		final Map<String, Object> dataForResult =  new HashMap<String, Object>(); // added by amit das on 14-09-2017
		Map<DgResultEntryHeader, Set<DgResultEntryDetail>> resultEntryMap = new HashMap<DgResultEntryHeader, Set<DgResultEntryDetail>>();  // added by amit das on 14-09-2017
		Set<DgResultEntryDetail> entryDetailsSet = null; // added by amit das on 14-09-2017
		DgResultEntryHeader dgResultEntryHeaderTemp = null; // added by amit das on 14-09-2017
		MasHospital hospital = null; // added by amit das on 14-09-2017
		
		DgResultEntryHeader dgEntryHeader = null; //added by amit das on 15-09-2017
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListMultipleType") != null) {
			validatedListMultipleType = (List) infoMap
					.get("validatedListMultipleType");
		}
		Map<String, Object> map = new HashMap<String, Object>();

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}
		Vector resultIdList = box.getVector(RESULT_ID);
		Vector dgResultDetailsId = box.getVector(RESULT_DETAIL_ID);

		Vector result = box.getVector(RESULT);
		Vector resultchk=box.getVector(RESULT);
		//Vector collectionId = box.getVector("collectionId");
		
		int retestCount=0;
		if (infoMap.get("retestCount") != null) {
			retestCount = (Integer)infoMap.get("retestCount");
		}
		
		List<Integer> retestIdList=new ArrayList<Integer>();
		List<Integer> acceptIdList=new ArrayList<Integer>();
		List<Integer> acceptEntryIdList=new ArrayList<Integer>();
		List<Integer> recolHIdList=new ArrayList<Integer>();
		List<Integer> recolEntryIdList=new ArrayList<Integer>();
		if (infoMap.get("retestIdList") != null) {
			retestIdList = (List<Integer>)infoMap.get("retestIdList");
		}
		if (infoMap.get("acceptIdList") != null) {
			acceptIdList = (List<Integer>)infoMap.get("acceptIdList");
		}
		if (infoMap.get("acceptEntryIdList") != null) {
			acceptEntryIdList = (List<Integer>)infoMap.get("acceptEntryIdList");
		}
		if (infoMap.get("recolHIdList") != null) {
			recolHIdList = (List<Integer>)infoMap.get("recolHIdList");
		}
		if (infoMap.get("recolEntryIdList") != null) {
			recolEntryIdList = (List<Integer>)infoMap.get("recolEntryIdList");
		}

		for(int rm=0;rm<result.size();rm++){
			if(result.get(rm).equals("TestRowFlag")){
				result.remove("TestRowFlag");
			}
		}
		//govind 
		
		Vector test = box.getVector("test");
		Vector additionalRemarks = box.getVector(ADDITIONAL_REMARKS);
		Vector subTestSize = box.getVector(SUB_TEST_SIZE);
	
		
		// int i = 0;
		//added by govind 15-07-2017 for recolecting
		DgOrderhd recolOrderhd=null;
		String orderSeqNo = "";
		int recolCount=0;
		int tempChargeId=0;
		List<Integer> checkChargeId=new ArrayList<Integer>();
		//added by govind 15-07-2017 for recolecting end
		Transaction tx = null;
		int count=0,new1=0;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt=null;
			hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			LOGGER.info("#$#$#$  "+resultIdList.size());
			for (int it = 0; it < resultIdList.size(); it++) {
				Integer resultId = Integer.parseInt((String) resultIdList
						.get(it));
				dgEntryHeader = new DgResultEntryHeader();
				dgEntryHeader = (DgResultEntryHeader) hbt.load(
						DgResultEntryHeader.class, resultId);
				
				List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
				dgResultEntryDetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res")
						.add(Restrictions.eq("res.Id", resultId))
						.addOrder(Order.asc("Id"))//added by govind 26-10-2016
						.list();
				String statusForRecollect = null; int k=0;
				count=count+1;
				for (int i = 0; i <dgResultEntryDetailList.size(); i++) {
					DgResultEntryDetail dgResultEntryDetail = dgResultEntryDetailList
							.get(i);
					DgOrderhd dgOrderhd = null;
					if(validatedListMultipleType.size()>i){
					if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("y")) {
						dgResultEntryDetail.setValidated("V");
						dgResultEntryDetail.setResultDetailStatus("A");
						if(retestIdList.size()>0){							
						}else{
						dgResultEntryDetail.setResultDetailStatus("A");
						dgResultEntryDetail.setValidated("V");
						//added by govind
						dgEntryHeader.setVerified("V");
						dgEntryHeader.setVerifiedOn(date);
						dgEntryHeader.setVerifiedTime(time);
						dgEntryHeader.setResultStatus("A");//added by govind 29-06-2017
						}
						/*if(resultchk.get(i).equals("TestRowFlag")||resultchk.equals("-")){
							dgResultEntryDetail
							.setRemarks("");
						}else{
							dgResultEntryDetail
							.setRemarks((String) additionalRemarks.get(i));
						}*/
						
						int memberId=0;
						int hospitalId=0;
						int hinId=0;
						String alertType="";
						String resultValue="";
						String investigationName="";
						String propName=""; 
						String phAlertForMalariaResult="";
						if(dgResultEntryDetail.getInvestigation()!=null){
							investigationName=dgResultEntryDetail.getInvestigation().getInvestigationName();
						} 
						if(dgResultEntryDetail.getFixed()!=null){
							resultValue=dgResultEntryDetail.getFixed().getFixedValue();
						}
						if(dgResultEntryDetail.getResultEntry().getHin().getMember()!=null){
							memberId=dgResultEntryDetail.getResultEntry().getHin().getMember().getId();
							hinId=dgResultEntryDetail.getResultEntry().getHin().getId();
							hospitalId=dgResultEntryDetail.getResultEntry().getHin().getMember().getHospital().getId();
							alertType="NVB";
							Properties properties = new Properties();
							URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("adt.properties");
							int relationId=0;
							try {
								properties.load(resourcePath.openStream()); 
								propName = properties.getProperty("phAlertForMalaria"); 
								phAlertForMalariaResult=properties.getProperty("phAlertForMalariaResult"); 
							} catch (Exception e) {
								LOGGER.error("Error while loading adt.properties : " + e.getStackTrace().toString());
							}
						} 
						if(propName.equalsIgnoreCase(investigationName)
								&& phAlertForMalariaResult.equalsIgnoreCase(resultValue) && memberId!=0){
							PhAlert phAlert=new PhAlert();
							phAlert.setAlertType(alertType);
							Patient patient=new Patient(hinId);
							phAlert.setHin(patient);
							hospital = new MasHospital(hospitalId);
							phAlert.setHospital(hospital);
							PhMemberSurvey phMemberSurvey=new PhMemberSurvey(memberId);
							phAlert.setMember(phMemberSurvey);
							hbt.save(phAlert);
						} 
						
						//-----------------------update Patient table for of Blood group investigation value------------------ 
						try {
						 int chargeId = dgResultEntryDetail.getChargeCode().getId();
						resultValue = dgResultEntryDetail.getResult() != null?dgResultEntryDetail.getResult():"";
						int chargeCodeId =Integer.parseInt(HMSUtil.getValuesFromPropertiesFile("adt.properties", "chargeCodeId"));
						hinId=dgResultEntryDetail.getResultEntry().getHin().getId();
						if(chargeId == chargeCodeId){	
							Patient patient = (Patient)hbt.load(Patient.class, hinId);
							patient.setBloodGroupValue(resultValue);
							patient.setConfirmedStatus("y");
							hbt.update(patient);
							hbt.refresh(patient);
						}
						} catch (Exception e) {
							//e.printStackTrace();
						}
					
						
					} else if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("RT")) {
						LOGGER.info("test 2");
					
					} else if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("RC")) {
						LOGGER.info("test 3");	
						dgOrderhd = dgEntryHeader.getSampleCollectionHeader()
								.getOrder();
						Set<DgOrderdt> ordertDetailSet = dgOrderhd
								.getDgOrderdts();
					}
				}
					try {
						// dgResultEntryDetail.setResult((String)
						// result.get(i));
						if (dgOrderhd != null) {
							hbt.update(dgOrderhd);
						}
						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);

					} catch (RuntimeException e) {
						
					//	e.printStackTrace();
					} catch (Exception e) {
					//	e.printStackTrace();
					}

				}
			
				List<DgResultEntryDetail> tempList = new ArrayList<DgResultEntryDetail>();
				tempList = session.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res")
						.add(Restrictions.eq("res.Id", resultId)).list();
				String headerOrderStaus = "P";
				String varifiedStatus = "Y";
			
				try {
					session.update(dgEntryHeader);
					session.refresh(dgEntryHeader);
					
				} catch (RuntimeException e) {
				//	e.printStackTrace();
				}
				
				if(dgEntryHeader!=null && dgEntryHeader.getId()!=null){
					hbt.refresh(dgEntryHeader); // added by amit das on 14-08-2017
					entryDetailsSet = dgEntryHeader.getDgResultEntryDetails();  // added by amit das on 14-08-2017
					Hibernate.initialize(entryDetailsSet); // added by amit das on 14-08-2017
					resultEntryMap.put(dgEntryHeader, entryDetailsSet); // added by amit das on 14-08-2017
					hospital = dgEntryHeader.getHospital();// added by amit das on 14-08-2017
				}
			}
			//added by govind 17-07-2017 for recollecting Multi parameter
		       int orderId=0,headId=0;
				if(recolEntryIdList.size()>0){
					DgOrderhd Orderhd=null;
					for(Integer re:recolEntryIdList){	
						DgResultEntryDetail resultEntry=hbt.load(DgResultEntryDetail.class, re);
						headId=resultEntry.getResultEntry().getId();
						DgOrderdt orderDet =hbt.load(DgOrderdt.class, re);
						Orderhd = resultEntry.getResultEntry().getSampleCollectionHeader()
								.getOrder();
						if(recolCount==0){
							recolOrderhd=new DgOrderhd();
							orderSeqNo = labDataService.generateOrderNumber();
							LOGGER.info("recolecting orderseqNo "+orderSeqNo);
							recolOrderhd.setHin(Orderhd.getHin());
							recolOrderhd.setDepartment(Orderhd.getDepartment());
							recolOrderhd.setOrderDate(new Date());
							recolOrderhd.setOrderTime(time);
							recolOrderhd.setHospital(Orderhd.getHospital());
							recolOrderhd.setPrescribedBy(Orderhd.getPrescribedBy());
							recolOrderhd.setVisit(Orderhd.getVisit());
							recolOrderhd.setOrderNo(orderSeqNo);
							recolOrderhd.setTestType(Orderhd.getTestType());
							recolOrderhd.setNetAmount(Orderhd.getNetAmount());
							recolOrderhd.setClinicalNote(Orderhd.getClinicalNote());
							recolOrderhd.setOrderTime(time);
							recolOrderhd.setPatientType("OP");
							recolOrderhd.setOrderStatus("P");
							recolOrderhd.setLastChgBy(Orderhd.getLastChgBy());
							recolOrderhd.setLastChgDate(Orderhd.getLastChgDate());
							recolOrderhd.setLastChgTime(time);
							recolOrderhd.setRoutineUrgentStatus("r");
							recolOrderhd.setUrgentRemarks(Orderhd.getUrgentRemarks());
							recolOrderhd.setBulkOrder(Orderhd.getBulkOrder());
							hbt.save(recolOrderhd);
							
							
							PharmacyLabQueue OldlabQue =(PharmacyLabQueue)session.createCriteria(PharmacyLabQueue.class)
									.createAlias("DgOrderhdId", "head")
									.add(Restrictions.eq("head.Id", Orderhd.getId())).uniqueResult();
							
							PharmacyLabQueue labQue=new PharmacyLabQueue();
							labQue.setStatus("P");
							labQue.setVisit(OldlabQue.getVisit());
							labQue.setTokenNo(OldlabQue.getTokenNo());
							labQue.setDepartment(OldlabQue.getDepartment());
							labQue.setHospital(OldlabQue.getHospital());
							labQue.setOpdDate(new Date());
							labQue.setOpdTime(time);
							labQue.setPharmacyLabStatus(OldlabQue.getPharmacyLabStatus());
							labQue.setTotalHospitalVisit(OldlabQue.getTotalHospitalVisit());
							labQue.setDgOrderhdId(recolOrderhd);
							hbt.save(labQue);
						}
						recolCount++;
						
						List<DgOrderdt> dgOrderdList =session.createCriteria(DgOrderdt.class)
								.createAlias("Orderhd", "head")
								.add(Restrictions.eq("head.Id", Orderhd.getId()))
								.add(Restrictions.eq("ChargeCode.Id", resultEntry.getResultEntry().getInvestigation().getChargeCode().getId())).list();
						
						tempChargeId=resultEntry.getResultEntry().getInvestigation().getChargeCode().getId();	
						checkChargeId.add(tempChargeId);
					    int newOrdetCount=0;
						for(Integer cId:checkChargeId){
							if(tempChargeId==cId){
							newOrdetCount++;
							}
						}	
						if(dgOrderdList.size()>0){	
							if(newOrdetCount==1){
						DgOrderdt dgOrderdtOld=dgOrderdList.get(0);
						DgOrderdt dgOrderdt=new DgOrderdt();
						dgOrderdt.setChargeCode(dgOrderdtOld.getChargeCode());
						dgOrderdt.setAmount(dgOrderdtOld.getAmount());
						dgOrderdt.setMainChargecode(dgOrderdtOld.getMainChargecode());
						dgOrderdt.setSubChargeid(dgOrderdtOld.getSubChargeid());
						dgOrderdt.setOrderQty(dgOrderdtOld.getOrderQty());
						dgOrderdt.setOrderStatus("P");
						dgOrderdt.setPaymentMade(dgOrderdtOld.getPaymentMade());
						dgOrderdt.setBill(dgOrderdtOld.getBill());
						dgOrderdt.setMsgSent(dgOrderdtOld.getMsgSent());
						dgOrderdt.setPacsStatus(dgOrderdtOld.getPacsStatus());
						dgOrderdt.setLastChgDate(new Date());
						dgOrderdt.setLastChgTime(time);
						dgOrderdt.setLastChgBy(dgOrderdtOld.getLastChgBy());
						dgOrderdt.setOrderhd(recolOrderhd);
						hbt.save(dgOrderdt);
							}
						}
						resultEntry.setValidated("Y");
						resultEntry.setResultDetailStatus("R");
						hbt.update(resultEntry);
						hbt.refresh(resultEntry);
						DgResultEntryHeader entryHeader=resultEntry.getResultEntry();
						entryHeader.setResultStatus("R");
						entryHeader.setVerified("Y");
						entryHeader.setVerifiedOn(date);
						entryHeader.setVerifiedTime(time);
						
						if (resultValidatedBy != 0) {
							MasEmployee masEmployee = new MasEmployee();
							masEmployee.setId(resultValidatedBy);
							entryHeader.setResultVerifiedBy(masEmployee);
						}
						
						hbt.update(entryHeader);
						hbt.refresh(entryHeader);
					
						if(entryHeader!=null && entryHeader.getId()!=null){
							hbt.refresh(entryHeader); // added by amit das on 14-08-2017
							entryDetailsSet = entryHeader.getDgResultEntryDetails();  // added by amit das on 14-08-2017
							Hibernate.initialize(entryDetailsSet); // added by amit das on 14-08-2017
							resultEntryMap.put(entryHeader, entryDetailsSet); // added by amit das on 14-08-2017
							hospital = entryHeader.getHospital();// added by amit das on 14-08-2017
						}
					}
				}				
			
//added by govind 17-07-2017 for recollecting end

			//added by govind 1-07-2017
		   //govind added for Result Acceptance
           if(acceptIdList.size()>0){
			for(Integer i:acceptIdList){
				DgResultEntryHeader dgEntryHeader1 = new DgResultEntryHeader();
				dgEntryHeader1 = (DgResultEntryHeader) hbt.load(
						DgResultEntryHeader.class, i);
				dgEntryHeader1.setResultStatus("A");
				dgEntryHeader1.setVerified("V");
				dgEntryHeader1.setVerifiedOn(date);
				dgEntryHeader1.setVerifiedTime(time);
				
				if (resultValidatedBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultValidatedBy);
					dgEntryHeader1.setResultVerifiedBy(masEmployee);
				}
				
				hbt.update(dgEntryHeader1);
				hbt.refresh(dgEntryHeader1);
				//added by govind 17-07-2017
				DgOrderhd orderhd=dgEntryHeader1.getSampleCollectionHeader().getOrder();
				if(dgEntryHeader1.getHin().getMobileNumber()!=null){
					OneToOne messageToPatient=new OneToOne();
					messageToPatient.setMessage("UHID:"+orderhd.getHin().getHinNo()
								+" Name: "+orderhd.getHin().getFullName()
								+" your investigation result of "+ dgEntryHeader1.getInvestigation().getInvestigationName()
								+" is ready kindly get the same collected");
					messageToPatient.setMobileNo(dgEntryHeader1.getHin().getMobileNumber());
					messageToPatient.setSentDate(date);
					messageToPatient.setSentTime(time);
					messageToPatient.setStatus("U");
					messageToPatient.setType("T");
					messageToPatient.setHospital(orderhd.getHospital());
					hbt.save(messageToPatient);
				}
				
				if("yes".equalsIgnoreCase(box.getString("sms")) && orderhd.getPrescribedBy()!=null){
					OneToOne messageToDoctor=new OneToOne();
					messageToDoctor.setMessage("UHID:"+orderhd.getHin().getHinNo()
							+" Name: "+orderhd.getHin().getFullName()
							+" investigation result of "+ dgEntryHeader1.getInvestigation().getInvestigationName()
							+" is abnormal kindly view the result");
					messageToDoctor.setMobileNo(orderhd.getPrescribedBy().getCellNoEmergency());
					messageToDoctor.setSentDate(date);
					messageToDoctor.setSentTime(time);
					messageToDoctor.setStatus("U");
					messageToDoctor.setType("T");  
					messageToDoctor.setHospital(orderhd.getHospital());
					hbt.save(messageToDoctor);
				}
				//added by govind 17-07-2017 end 
				
				if(dgEntryHeader1!=null && dgEntryHeader1.getId()!=null){
					hbt.refresh(dgEntryHeader1); // added by amit das on 14-08-2017
					entryDetailsSet = dgEntryHeader1.getDgResultEntryDetails();  // added by amit das on 14-08-2017
					Hibernate.initialize(entryDetailsSet); // added by amit das on 14-08-2017
					resultEntryMap.put(dgEntryHeader1, entryDetailsSet); // added by amit das on 14-08-2017
					hospital = dgEntryHeader1.getHospital();// added by amit das on 14-08-2017
				}
			}
           }
           if(acceptEntryIdList.size()>0){
			for(Integer i:acceptEntryIdList){
				if(i>0){
				DgResultEntryDetail dgResultEntryDetail=hbt.load(DgResultEntryDetail.class, i);
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setValidated("V");
				hbt.saveOrUpdate(dgResultEntryDetail);
				hbt.refresh(dgResultEntryDetail);
			   }
			}
           }//govind added for Result Acceptance end
           
			//govind added for Retesting
			if(retestIdList.size()>0){
			for(Integer rt:retestIdList){	
				if(rt>0){
				DgResultEntryDetail dgResultEntryDetail=hbt.load(DgResultEntryDetail.class, rt);
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setValidated("Y");
				hbt.saveOrUpdate(dgResultEntryDetail);
				hbt.refresh(dgResultEntryDetail);
				
			DgSampleCollectionDetails dgSampleCollectionDetails=dgResultEntryDetail.getSampleCollectionDetails();
					dgSampleCollectionDetails.setOrderStatus("A");
					hbt.update(dgSampleCollectionDetails);
					//added by govind 17-07-2017
					dgEntryHeader=dgResultEntryDetail.getResultEntry();
					dgEntryHeader.setVerified("Y");
					dgEntryHeader.setResultStatus("R");
					dgEntryHeader.setVerifiedOn(date);
					dgEntryHeader.setVerifiedTime(time);
					if (resultValidatedBy != 0) {
						MasEmployee masEmployee = new MasEmployee();
						masEmployee.setId(resultValidatedBy);
						dgEntryHeader.setResultVerifiedBy(masEmployee);
					}
					
					hbt.update(dgEntryHeader);
					hbt.refresh(dgEntryHeader);
					//added by govind 17-07-2017
				}
				if(dgEntryHeader!=null && dgEntryHeader.getId()!=null){
					hbt.refresh(dgEntryHeader); 
					entryDetailsSet = dgEntryHeader.getDgResultEntryDetails();  
					Hibernate.initialize(entryDetailsSet); 
					Hibernate.initialize(dgEntryHeader.getHin());
					Hibernate.initialize(dgEntryHeader.getSampleCollectionHeader().getOrder().getVisit());
					resultEntryMap.put(dgEntryHeader, entryDetailsSet); 
					hospital = dgEntryHeader.getHospital();
				}
	         }
				}//govind added for Retesting end
			//added by govind 1-07-2017 end
			

			tx.commit();
			
			// added by amit das on 14-08-2017
		
			Hibernate.initialize(hospital);
			dataForResult.put("resultMap", resultEntryMap); // added by amit das on  14-09-2017
			dataForResult.put("hospital", hospital);// added by amit das on  12-09-2017
			
			final MasHospital masHospital = hospital;
			
			//#13- Tech Debt: Comment out the code those are related to Lean server
			/*new Thread(){
				public void run(){
					if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
						
						resultManipulactionToCentralServer(dataForResult,"validation");
					} 
					if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
						
						resultManipulactionToLeanServer(dataForResult,"validation");
							
					}
				}
				
			}.start();*/
			
			successfullyAdded = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}
	
	
	public boolean submitResultValidationLabForEmpanelled(Map<String, Object> infoMap) {
		LOGGER.info("in submitResultValidationLabForEmpanelled");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = true;
		List<String> validatedListMultipleType = new ArrayList<String>();
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("validatedListMultipleType") != null) {
			validatedListMultipleType = (List) infoMap
					.get("validatedListMultipleType");
		}
		Map<String, Object> map = new HashMap<String, Object>();

		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}

		Vector resultIdList = box.getVector(RESULT_ID);
		Vector dgResultDetailsId = box.getVector(RESULT_DETAIL_ID);

		Vector result = box.getVector(RESULT);
		Vector test = box.getVector("test");
		Vector additionalRemarks = box.getVector(ADDITIONAL_REMARKS);
		Vector subTestSize = box.getVector(SUB_TEST_SIZE);

		// int i = 0;
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int it = 0; it < resultIdList.size(); it++) {
				Integer resultId = Integer.parseInt((String) resultIdList
						.get(it));
				DgResultEntryHeader dgEntryHeader = new DgResultEntryHeader();
				dgEntryHeader = (DgResultEntryHeader) hbt.load(
						DgResultEntryHeader.class, resultId);
				List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
				dgResultEntryDetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res")
						.add(Restrictions.eq("res.Id", resultId)).list();
				String statusForRecollect = null;
				for (int i = 0; i < dgResultEntryDetailList.size(); i++) {
					DgResultEntryDetail dgResultEntryDetail = dgResultEntryDetailList
							.get(i);
					DgOrderhd dgOrderhd = null;
					if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("y")) {
						dgResultEntryDetail.setValidated("V");
						dgResultEntryDetail.setResultDetailStatus("A");

						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
					} else if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("RT")) {
						dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
								.load(DgResultEntryHeader.class, resultId);
						DgSampleCollectionHeader dgSampleCollectionHeader = dgEntryHeader
								.getSampleCollectionHeader();

						Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
								.getDgSampleCollectionDetails();
						for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
							dgSampleCollectionDetails.setOrderStatus("A");
							hbt.update(dgSampleCollectionDetails);
						}
						dgSampleCollectionHeader.setOrderStatus("A");
						hbt.update(dgSampleCollectionHeader);
						dgEntryHeader.setResultStatus("R");
						hbt.update(dgEntryHeader);
						dgResultEntryDetail.setValidated("Y");
						statusForRecollect = "R";
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
					} else if (validatedListMultipleType.get(i) != null
							&& validatedListMultipleType.get(i).equals("RC")) {
						dgResultEntryDetail.setValidated("Y");
						dgResultEntryDetail.setResultDetailStatus("R");
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgOrderhd = dgEntryHeader.getSampleCollectionHeader()
								.getOrder();
						Set<DgOrderdt> ordertDetailSet = dgOrderhd
								.getDgOrderdts();
						for (DgOrderdt dgOrderdt : ordertDetailSet) {
							dgOrderdt.setOrderStatus("P");
							try {
								hbt.update(dgOrderdt);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
						statusForRecollect = "R";
						dgOrderhd.setOrderStatus("P");
					}
					try {
						// dgResultEntryDetail.setResult((String)
						// result.get(i));
						if (dgOrderhd != null) {
							hbt.update(dgOrderhd);
						}
						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);

					} catch (RuntimeException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				List<DgResultEntryDetail> tempList = new ArrayList<DgResultEntryDetail>();
				tempList = session.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res")
						.add(Restrictions.eq("res.Id", resultId)).list();
				String headerOrderStaus = "P";
				String varifiedStatus = "Y";
				for (DgResultEntryDetail object : tempList) {
					if ("P".equals(object.getResultDetailStatus())
							|| "R".equalsIgnoreCase(object
									.getResultDetailStatus())) {
						headerOrderStaus = "P";
						varifiedStatus = "Y";
						break;
					} else {
						headerOrderStaus = "A";
						varifiedStatus = "V";

						/*save data for message*/ 
						DgOrderhd orderhd=dgEntryHeader.getSampleCollectionHeader().getOrder();
						if(dgEntryHeader.getHin().getMobileNumber()!=null){
							OneToOne messageToPatient=new OneToOne();
							messageToPatient.setMessage("UHID:"+orderhd.getHin().getHinNo()
										+" Name: "+orderhd.getHin().getFullName()
										+" your investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
										+" is ready kindly get the same collected");
							messageToPatient.setMobileNo(dgEntryHeader.getHin().getMobileNumber());
							messageToPatient.setSentDate(date);
							messageToPatient.setSentTime(time);
							messageToPatient.setStatus("U");
							messageToPatient.setType("T");
							messageToPatient.setHospital(orderhd.getHospital());
							hbt.save(messageToPatient);
						}
						
						if("yes".equalsIgnoreCase(box.getString("sms")) && orderhd.getPrescribedBy()!=null){
							OneToOne messageToDoctor=new OneToOne();
							messageToDoctor.setMessage("UHID:"+orderhd.getHin().getHinNo()
									+" Name: "+orderhd.getHin().getFullName()
									+" investigation result of "+ dgEntryHeader.getInvestigation().getInvestigationName()
									+" is abnormal kindly view the result");
							messageToDoctor.setMobileNo(orderhd.getPrescribedBy().getCellNoEmergency());
							messageToDoctor.setSentDate(date);
							messageToDoctor.setSentTime(time);
							messageToDoctor.setStatus("U");
							messageToDoctor.setType("T");  
							messageToDoctor.setHospital(orderhd.getHospital());
							hbt.save(messageToDoctor);
						}
					}

				}
				if (resultValidatedBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultValidatedBy);
					//dgEntryHeader.setResultVerifiedBy(masEmployee);
				}
				dgEntryHeader.setVerified(varifiedStatus);
				dgEntryHeader.setVerifiedOn(date);
				dgEntryHeader.setVerifiedTime(time);
				if (statusForRecollect != null) {
					dgEntryHeader.setResultStatus(statusForRecollect);
				} else {
					dgEntryHeader.setResultStatus(headerOrderStaus);
				}
				try {
					hbt.update(dgEntryHeader);
					hbt.refresh(dgEntryHeader);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			tx.commit();
			successfullyAdded = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}
	
	public boolean submitResultEntryForMultipleParameterOnlyPostQC(Map<String, Object> infoMap) {
		LOGGER.info("in submitResultEntryForMultipleParameterOnlyPostQC");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = true;
		List<String> postResultEntryListMultipleType = new ArrayList<String>();
		Box box = null;
		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}
		if (infoMap.get("postResultEntryListMultipleType") != null) {
			postResultEntryListMultipleType = (List) infoMap
					.get("postResultEntryListMultipleType");
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int valueInt=box.getInt("validatedCheckBoxCountMultiple"); 
		int resultValidatedBy = 0;
		if (infoMap.get("resultValidatedBy") != null) {
			resultValidatedBy = Integer.parseInt(""
					+ infoMap.get("resultValidatedBy"));
		}

		Vector resultIdList = box.getVector(RESULT_ID);
		Vector dgResultDetailsId = box.getVector(RESULT_DETAIL_ID);

		Vector result = box.getVector(RESULT);
		Vector qcResult=box.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE);
		Vector test = box.getVector("test");
		Vector additionalRemarks = box.getVector(ADDITIONAL_REMARKS);
		Vector subTestSize = box.getVector(SUB_TEST_SIZE);

		// int i = 0;
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			for (int it = 0; it < resultIdList.size(); it++) {
				Integer resultId = Integer.parseInt((String) resultIdList
						.get(it));
				DgResultEntryHeader dgEntryHeader = new DgResultEntryHeader();
				dgEntryHeader = (DgResultEntryHeader) hbt.load(
						DgResultEntryHeader.class, resultId);
				List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
				dgResultEntryDetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "res")
						.add(Restrictions.eq("res.Id", resultId)).list(); 
				for (int i = 0; i < dgResultEntryDetailList.size(); i++) {
					DgResultEntryDetail dgResultEntryDetail = dgResultEntryDetailList
							.get(i);
					DgOrderhd dgOrderhd = null;
					if (postResultEntryListMultipleType.get(i) != null
							&& postResultEntryListMultipleType.get(i).equals("y")) {
						dgResultEntryDetail.setValidated("Y");
						dgResultEntryDetail.setResultDetailStatus("P");
						dgResultEntryDetail.setQcResult(qcResult.get(i)+"");
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
					}    
					try { 
						hbt.saveOrUpdate(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);

					} catch (RuntimeException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}

				} 
				if (resultValidatedBy != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultValidatedBy);
					dgEntryHeader.setResultVerifiedBy(masEmployee);
				}
				dgEntryHeader.setVerified("Y");
				dgEntryHeader.setVerifiedOn(date);
				dgEntryHeader.setVerifiedTime(time);   
				dgEntryHeader.setResultStatus("P");
				 
				try {
					hbt.update(dgEntryHeader);
					hbt.refresh(dgEntryHeader);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			tx.commit();
			successfullyAdded = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}

			successfullyAdded = false;
			e.printStackTrace();
		}
		return successfullyAdded;
	}

	public Map<String, Object> getPatientDetailsForResultValidationLab(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForResultValidationLab");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		Date fromDate = new Date();
		Date toDate = new Date();
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		int hinId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}

		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		String barcodetext="";
		if (mapForDs.get("barcodetext") != null) {
			barcodetext = (String)mapForDs.get("barcodetext");
	 	    mapForDs.put("barcodetext",barcodetext); 
	 					
		}
		String sampleIdSearch=null;
		if (mapForDs.get("sampleIdSearch") != null
				&& !(mapForDs.get("sampleIdSearch")
						.equals(""))) {
			sampleIdSearch =(String)mapForDs.get("sampleIdSearch");
		}
		
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.createAlias("SampleCollectionHeader", "sampleHead")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
					.add(Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.createAlias("SampleCollectionHeader", "sampleHead")
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P"))
					.add(Restrictions.or(Restrictions.isNull("EmpanelledStatus"), 
								Restrictions.ne("EmpanelledStatus", "Y").ignoreCase())) 
					.add(Restrictions.between("ResultDate", fromDate, toDate));
			// if(!deptType.equalsIgnoreCase("RADIO")){
			// crit = crit.add(Restrictions.between("ResultDate", fromDate,
			// toDate));
			// }
			//
			crit = crit.createAlias("Hin", "pt");
		}

		if (!barcodetext.equals("")) {
			LOGGER.info("barcodetext "+barcodetext);
			crit=crit.add(Restrictions.eq("sampleHead.SampleBarCode", barcodetext));
		}
		
		if (sampleIdSearch!=null) {
			LOGGER.info("sampleIdSearch "+sampleIdSearch);
			List<DgSampleCollectionDetails> collList = session
					.createCriteria(DgSampleCollectionDetails.class) 
						.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Hin", "pt")
					.createAlias("sampleHead.Order", "o")
					.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
					.add(Restrictions
							.between("sampleHead.DiagnosisDate", fromDate, toDate)) 
					.add(Restrictions.eq("DiagNo", sampleIdSearch)).list();
			
		if(collList.size()>0){
			List<Integer> hinList=new ArrayList<Integer>();
			for(DgSampleCollectionDetails scd:collList){
				hinList.add(scd.getSampleCollectionHeader().getHin().getId());
			}
			//System.out.println("hinList "+hinList.size());
			if(hinList.size()>0){
			crit = crit.add(Restrictions.in("pt.Id", hinList));
			}
		
		}
		}
	
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", "%"+patientFName
					+ "%").ignoreCase());
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
		}

		
		if (!adNo.equals("") || !wardName.equals("")) {
			crit = crit.createAlias("sampleHead.Inpatient", "ip");
		}
		
		
		if (!adNo.equals("")) {
			crit = crit.add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (!wardName.equals("")) {
			crit = crit.createAlias("ip.Department", "dept");
			crit = crit.add(Restrictions.eq("dept.DepartmentName",
					wardName));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("Department.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.eq("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));

		patientList = crit.list();
		Date sampleCollDate = new Date();
		for (DgResultEntryHeader dgResultEntryHeader : patientList) {
			if (dgResultEntryHeader.getResultType() != null
					&& dgResultEntryHeader.getResultType()
							.equalsIgnoreCase("v")) {
				Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetailSens();
				DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntrySet
						.iterator().next();
				DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetailSen
						.getSampleCollection();
				Date sampleCollectionDate = dgSampleCollectionDetails
						.getSampleCollDatetime();

				sampleCollDateString = HMSUtil
						.convertDateToStringWithoutTime(sampleCollectionDate);
				sampleCollDate = HMSUtil
						.convertStringTypeDateToDateType(sampleCollDateString);
				if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
						.compareTo(toDate) <= 0)) {
					patientListTemp.add(dgResultEntryHeader);
				}
			} else {
				Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetails();
				if (dgResultEntrySet.size() > 0) {
					DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
							.iterator().next();
					DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
							.getSampleCollectionDetails();
					Date sampleCollectionDate = dgSampleCollectionDetails
							.getSampleCollDatetime();

					sampleCollDateString = HMSUtil
							.convertDateToStringWithoutTime(sampleCollectionDate);
					sampleCollDate = HMSUtil
							.convertStringTypeDateToDateType(sampleCollDateString);
					if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
							.compareTo(toDate) <= 0)) {
						patientListTemp.add(dgResultEntryHeader);
					}
				}
			}
		}
		patientList = patientListTemp;

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		if (patientList.size() > 0) {
			patientListSubDepartWise.add(patientList.get(0));
			stringOfIds = stringOfIds + patientList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ patientList.get(0).getSubChargecode().getId();

			stringOfIdsList.add(stringOfIds);
			stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
				if (!patientList
						.get(ilop)
						.getSampleCollectionHeader()
						.getId()
						.equals(patientList.get(ilop + 1)
								.getSampleCollectionHeader().getId())) {

					patientListSubDepartWise.add(patientList.get(ilop + 1));
					stringOfIdsList.add(patientList.get(ilop + 1).getId()
							.toString());
					stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
							.getSubChargecode().getId().toString());
				} else {
					if (!patientList
							.get(ilop)
							.getSubChargecode()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSubChargecode().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						int ii = stringOfIdsList.size() - 1;
						stringOfIds = stringOfIdsList.get(ii);
						stringOfIdsList.remove(ii);
						stringOfIds = stringOfIds + ","
								+ patientList.get(ilop + 1).getId().toString();
						stringOfIdsList.add((ii), stringOfIds);
					}
				}
			}
		}

		patientList = patientListSubDepartWise;
		map.put("patientDetailsList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}
	
	
	public Map<String, Object> getPatientDetailsForResultValidationLabForEmpanelled(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getPatientDetailsForResultValidationLabForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		Date fromDate = new Date();
		Date toDate = new Date();
		String diagnosisNo = "";
		String identifySource = "";
		String deptType = "";
		String sampleCollDateString = "";
		String hinNo = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		int sampleId = 0;
		int subChargeCodeId = 0;
		int chargeCodeId = 0;
		int hinId = 0;
		Integer hospitalId = 0;
		String wardName = "";
		String mobileNo = "";
		int empanelledId=0;
		List<DgResultEntryHeader> patientListTemp = new ArrayList<DgResultEntryHeader>();

		int deptId = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}
		if (mapForDs.get("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + mapForDs.get("hospitalId"));
		}
		if (mapForDs.get("deptType") != null) {
			deptType = (String) mapForDs.get("deptType");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}
		if (mapForDs.get("sampleId") != null) {
			sampleId = (Integer) mapForDs.get("sampleId");
		}
		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("chargeCodeId") != null) {
			chargeCodeId = (Integer) mapForDs.get("chargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("identifySource") != null) {
			identifySource = (String) mapForDs.get("identifySource");
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.USERS) != null) {
			MasEmpaneled masEmpaneled = (MasEmpaneled) mapForDs.get(RequestConstants.USERS);
			empanelledId=masEmpaneled.getId();
		}

		String deptName = "";
		if (dataMap.get("deptName") != null) {
			deptName = (String) dataMap.get("deptName");

		}
		if (identifySource.equalsIgnoreCase("filmUpdation")) {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P"))
					.createAlias("Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId))
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase())
					.add(Restrictions.eq("Empaneled.Id", empanelledId))
					.add(Restrictions.between("ResultDate", fromDate, toDate))
					.createAlias("Patient", "pt");
		} else {
			crit = session.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("Hospital.Id", hospitalId))
					.add(Restrictions.eq("ResultStatus", "P"))
					.add(Restrictions.eq("EmpanelledStatus", "Y").ignoreCase()) 
					.add(Restrictions.eq("Empaneled.Id", empanelledId))
					.add(Restrictions.between("ResultDate", fromDate, toDate));
			// if(!deptType.equalsIgnoreCase("RADIO")){
			// crit = crit.add(Restrictions.between("ResultDate", fromDate,
			// toDate));
			// }
			//
			crit = crit.createAlias("Hin", "pt");
		}

		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.HinNo", hinNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
		}

		if (!adNo.equals("")) {
			crit = crit.createAlias("Inpatient", "ip").add(
					Restrictions.eq("ip.AdNo", adNo));
		}
		if (!wardName.equals("")) {
			crit = crit.add(Restrictions.eq("ip.Department.DepartmentName",
					wardName));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("Department.Id", departmentId));
		}

		if (subChargeCodeId != 0) {
			crit = crit.add(Restrictions.like("SubChargecode.Id",
					subChargeCodeId));
		}
		if (!orderType.equals("")) {
			crit = crit.createAlias("SampleCollectionHeader", "sampleHead")
					.createAlias("sampleHead.Order", "or")
					.add(Restrictions.eq("or.PatientType", orderType));
		}
		crit = crit.addOrder(Order.asc("SampleCollectionHeader.Id")).addOrder(
				Order.asc("SubChargecode.Id"));

		patientList = crit.list();
		Date sampleCollDate = new Date();
		for (DgResultEntryHeader dgResultEntryHeader : patientList) {
			if (dgResultEntryHeader.getResultType() != null
					&& dgResultEntryHeader.getResultType()
							.equalsIgnoreCase("v")) {
				Set<DgResultEntryDetailSen> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetailSens();
				DgResultEntryDetailSen dgResultEntryDetailSen = dgResultEntrySet
						.iterator().next();
				DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetailSen
						.getSampleCollection();
				Date sampleCollectionDate = dgSampleCollectionDetails
						.getSampleCollDatetime();

				sampleCollDateString = HMSUtil
						.convertDateToStringWithoutTime(sampleCollectionDate);
				sampleCollDate = HMSUtil
						.convertStringTypeDateToDateType(sampleCollDateString);
				if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
						.compareTo(toDate) <= 0)) {
					patientListTemp.add(dgResultEntryHeader);
				}
			} else {
				Set<DgResultEntryDetail> dgResultEntrySet = dgResultEntryHeader
						.getDgResultEntryDetails();
				if (dgResultEntrySet.size() > 0) {
					DgResultEntryDetail dgResultEntryDetail = dgResultEntrySet
							.iterator().next();
					DgSampleCollectionDetails dgSampleCollectionDetails = dgResultEntryDetail
							.getSampleCollectionDetails();
					Date sampleCollectionDate = dgSampleCollectionDetails
							.getSampleCollDatetime();

					sampleCollDateString = HMSUtil
							.convertDateToStringWithoutTime(sampleCollectionDate);
					sampleCollDate = HMSUtil
							.convertStringTypeDateToDateType(sampleCollDateString);
					if ((sampleCollDate.compareTo(fromDate) >= 0 && sampleCollDate
							.compareTo(toDate) <= 0)) {
						patientListTemp.add(dgResultEntryHeader);
					}
				}
			}
		}
		patientList = patientListTemp;

		List<DgResultEntryHeader> patientListSubDepartWise = new ArrayList<DgResultEntryHeader>();
		String stringOfIds = "";
		String stringOfSubDeptIds = "";

		List<String> stringOfIdsList = new ArrayList<String>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();

		if (patientList.size() > 0) {
			patientListSubDepartWise.add(patientList.get(0));
			stringOfIds = stringOfIds + patientList.get(0).getId();
			stringOfSubDeptIds = stringOfSubDeptIds
					+ patientList.get(0).getSubChargecode().getId();

			stringOfIdsList.add(stringOfIds);
			stringOfSubDeptIdsList.add(stringOfSubDeptIds);

			for (int ilop = 0; ilop < patientList.size() - 1; ilop++) {
				if (!patientList
						.get(ilop)
						.getSampleCollectionHeader()
						.getId()
						.equals(patientList.get(ilop + 1)
								.getSampleCollectionHeader().getId())) {

					patientListSubDepartWise.add(patientList.get(ilop + 1));
					stringOfIdsList.add(patientList.get(ilop + 1).getId()
							.toString());
					stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
							.getSubChargecode().getId().toString());
				} else {
					if (!patientList
							.get(ilop)
							.getSubChargecode()
							.getId()
							.equals(patientList.get(ilop + 1)
									.getSubChargecode().getId())) {

						patientListSubDepartWise.add(patientList.get(ilop + 1));
						stringOfIdsList.add(patientList.get(ilop + 1).getId()
								.toString());
						stringOfSubDeptIdsList.add(patientList.get(ilop + 1)
								.getSubChargecode().getId().toString());
					} else {
						int ii = stringOfIdsList.size() - 1;
						stringOfIds = stringOfIdsList.get(ii);
						stringOfIdsList.remove(ii);
						stringOfIds = stringOfIds + ","
								+ patientList.get(ilop + 1).getId().toString();
						stringOfIdsList.add((ii), stringOfIds);
					}
				}
			}
		}

		patientList = patientListSubDepartWise;
		map.put("patientDetailsList", patientList);
		map.put("stringOfIdsList", stringOfIdsList);
		map.put("stringOfSubDeptIdsList", stringOfSubDeptIdsList);

		return map;
	}
	

	public Map<String, Object> getPatientHistory(Map<String, Object> requestMap) {
		LOGGER.info("in getPatientHistory");
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DgResultEntryDetail> dgResultEntryDtList = new ArrayList<DgResultEntryDetail>();
		String hinNo = "";
		String adNo = "";
		int inpatientId = 0;
		int wardId = 0;
		int investigationId = 0;
		int hinId = 0;
		if (requestMap.get("investigationId") != null) {
			investigationId = (Integer) requestMap.get("investigationId");
		}
		if (requestMap.get("hinId") != null) {
			hinId = (Integer) requestMap.get("hinId");
		}

		Criteria crit = null;
		try {
			crit = session
					.createCriteria(DgResultEntryDetail.class)
					.createAlias("ResultEntry", "re")
					.add(Restrictions.eq("re.Hin.Id", hinId))
					// .add(Restrictions.eq("re.ResultStatus", "A"))
					.add(Restrictions.or(
							Restrictions.eq("re.ResultStatus", "A").ignoreCase(),
							Restrictions.eq("re.ResultStatus", "R").ignoreCase()))
					.add(Restrictions.eq("Investigation.Id", investigationId))
					.addOrder(Order.desc("re.VerifiedOn"));

			dgResultEntryDtList = crit.list();
			map.put("dgResultEntryDtList", dgResultEntryDtList);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameterOnly(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSingleParameterOnly");
		Map<String, Object> map = new HashMap<String, Object>();
		LOGGER.info("submitResultEntryForSingleParameterOnly calling");
		final Map<String, Object> dataForResult =  new HashMap<String, Object>(); // added by amit das on 14-09-2017
		Map<DgResultEntryHeader, Set<DgResultEntryDetail>> resultEntryMap = new HashMap<DgResultEntryHeader, Set<DgResultEntryDetail>>();  // added by amit das on 14-09-2017
		Set<DgResultEntryDetail> entryDetailsSet = null; // added by amit das on 14-09-2017
		DgResultEntryHeader dgResultEntryHeaderTemp = null; // added by amit das on 14-09-2017
		MasHospital hospital = null; // added by amit das on 14-09-2017
		
		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session =null;
		session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		org.springframework.orm.hibernate3.HibernateTemplate hbt = null;
		String qcStatus=null;
		String[] chargeCodeForPregnancyArray = null; // added by amit das on 27-09-2016
		if("QCType".equalsIgnoreCase(parameterMap.get("QCType")+"")){
			qcStatus="Q";
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		int modalityId = 0;
		if (parameterMap.get("modalityId") != null) {
			modalityId = (Integer) parameterMap.get("modalityId");
		}
		
		String forOutSideLab = null;
		if (parameterMap.get("forOutSideLab") != null) {
			forOutSideLab = (String) parameterMap.get("forOutSideLab");
		}
		
		int hinId_OPD =0;
		String RequisitionFrom = "NA"; 
		
		hinId_OPD = box.getInt("hinId_OPD");
		RequisitionFrom = box.getString("RequisitionFrom");
		Vector resultEntryId = box.getVector("resultEntryId");//added by govind 23-07-2017 
		//System.out.println("resultEntryId "+resultEntryId.size());
		//added by govind 01-07-2017 
		int updateRow=0;
		if(resultEntryId.size()>0){
			for(int up=0;up<resultEntryId.size();up++){
				Integer resultId=Integer.parseInt((String)resultEntryId.get(up));
				//System.out.println("resultEntryId "+resultId);
				if(resultId>0){
					updateRow++;
				}
			}
		}
		if(updateRow>0){
			Vector upResult = box.getVector("upResult");
			int sampleCollectionId = box
					.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
			org.springframework.orm.hibernate3.HibernateTemplate hbt1 =null;
			hbt1= getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			LOGGER.info("upResult "+upResult.size());
			
			hospital = hbt1.get(MasHospital.class,hospitalId);  // added by amit das on 13-08-2017
			
			
			for(int up=0;up<resultEntryId.size();up++){
				Integer entryId=Integer.parseInt((String)resultEntryId.get(up));	
					if(upResult.size()>up){
						String result=(String)upResult.get(up);
						if(!result.equals("")){
						if(entryId>0 && result!=""){
						DgResultEntryDetail entryDetail=hbt1.load(DgResultEntryDetail.class, entryId);
						entryDetail.setResult(result);
						entryDetail.setResultDetailStatus("P");
						entryDetail.setValidated("V");
						hbt1.update(entryDetail);
						hbt1.refresh(entryDetail);							
						}
						
						List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
								.createCriteria(DgResultEntryHeader.class)
								.createAlias("SubChargecode", "ssc")
								.add(Restrictions.eq("SampleCollectionHeader.Id",sampleCollectionId))
								.add(Restrictions.eq("ssc.Id",modalityId)).list();
						//System.out.println("dgResultEntryHeaderList "+dgResultEntryHeaderList.size()+" sampleCollectionId "+sampleCollectionId);
							if(dgResultEntryHeaderList.size()>0){
								for(DgResultEntryHeader dgResultEntryHeader:dgResultEntryHeaderList){
									
								if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){	
									dgResultEntryHeader.setResultStatus("A");
									dgResultEntryHeader.setVerified("V");
								}else{
									dgResultEntryHeader.setResultStatus("P");
									dgResultEntryHeader.setVerified("Y");
								}
								
								hbt1.update(dgResultEntryHeader);
								hbt1.refresh(dgResultEntryHeader);		
								/*DgSampleCollectionHeader dgSampleCollectionHeader = dgResultEntryHeader.getSampleCollectionHeader();			
								Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
										.getDgSampleCollectionDetails();
								
								for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
									dgSampleCollectionDetails.setOrderStatus("E");
									hbt1.update(dgSampleCollectionDetails);
								}*/
								dgResultEntryHeaderTemp = dgResultEntryHeader; // added by amit das on 12-08-2017
								}			
								
							}	
							if(entryId>0){
								DgResultEntryDetail dgResultEntryDetail=hbt1.load(DgResultEntryDetail.class, entryId);
								
							DgSampleCollectionDetails dgSampleCollectionDetails=dgResultEntryDetail.getSampleCollectionDetails();
									dgSampleCollectionDetails.setOrderStatus("E");
									hbt1.update(dgSampleCollectionDetails);
								}
					 }
						
					} 
					
					hbt1.refresh(dgResultEntryHeaderTemp); // added by amit das on 13-08-2017
					entryDetailsSet = dgResultEntryHeaderTemp.getDgResultEntryDetails();  // added by amit das on 13-08-2017
					Hibernate.initialize(entryDetailsSet); // added by amit das on 14-08-2017
					resultEntryMap.put(dgResultEntryHeaderTemp, entryDetailsSet); // added by amit das on 14-08-2017
				
			}
			
		}else{//added by govind 01-07-2017 end
		//System.out.println("hinId_OPD="+hinId_OPD);
		//System.out.println("RequisitionFrom="+RequisitionFrom);
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}

		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_SINGLE_VALUE);
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_SINGLE_VALUE);
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_SINGLE_VALUE);

		// ///////////////////// Data For Details
		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector qcResult = box
				.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector charge_code_Id = box
				.getVector(RequestConstants.CHARGE_CODE_ID_SINGLE_VALUE);
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID_SINGLE_VALUE);
		Vector uomId = box
				.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_SINGLE_VALUE);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		
		
		
		// Vector
		// sampleCollectionId=box.getVector(RequestConstants.SAMPLE_COLLECTION_ID);
		// ///////////////////// Data For Details
		List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
				.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("SampleCollectionHeader.Id",
						sampleCollectionId)).list();
		// .add(Restrictions.ne("ResultStatus", "P"))
		for (int i = 0; i < resultTypeSingleValue.size(); i++) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) { 
				DgResultEntryHeader dgResultEntryHeader = null;
				if (dgResultEntryHeaderList.size() > i
						&& dgResultEntryHeaderList.get(i).getInvestigation() != null
						&& dgResultEntryHeaderList.get(i).getInvestigation()
								.getId() == Integer.parseInt(investigationId
								.get(i).toString())) {
					dgResultEntryHeader = dgResultEntryHeaderList.get(i);
				} else {
					dgResultEntryHeader = new DgResultEntryHeader();
				}

				// Vector resultSingle = null;
				int subchargeId = box
						.getInt(RequestConstants.SUB_CHARGECODE_ID);
				int mainChargeId = box
						.getInt(RequestConstants.MAIN_CHARGECODE_ID);
				int hinId = box.getInt(RequestConstants.HIN_ID);
				int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
				int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
				int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
				int resultEnteredId = box
						.getInt(RequestConstants.RESULT_ENTERED_BY);

				dgResultEntryHeader.setResultNo((String) resultNo.get(i));
				dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks((String) remarks.get(i));
				dgResultEntryHeader.setResultDate(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setResultStatus(qcStatus);
				}else{
					dgResultEntryHeader.setResultStatus("P");
				}
			
				// Add by Vinay
				
				if(hinId_OPD != 0)
				{
					dgResultEntryHeader.setResultStatus("A");
				}
				dgResultEntryHeader.setResultTime(time);
				dgResultEntryHeader.setVerifiedTime(time);
				dgResultEntryHeader.setVerifiedOn(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setVerified(qcStatus);
				}else{
					dgResultEntryHeader.setVerified("Y");
				}
				
				// Add by Vinay
				
				if(hinId_OPD != 0)
				{
					dgResultEntryHeader.setVerified("V");
				}

				if (testOrderNo.get(i) != null
						&& !testOrderNo.get(i).equals("")
						&& !testOrderNo.get(i).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(i)));
				}

				DgMasInvestigation dgMasInvestigationForHeader = new DgMasInvestigation();
				dgMasInvestigationForHeader.setId(Integer
						.parseInt((String) investigationId.get(i)));
				dgResultEntryHeader
						.setInvestigation(dgMasInvestigationForHeader);

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setHin(patient);
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					dgResultEntryHeader.setEmployee(masEmployee);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
				}
				if (resultTypeSingleValue != null
						&& !resultTypeSingleValue.equals("")) {
					dgResultEntryHeader
							.setResultType((String) resultTypeSingleValue
									.get(i));
				}
				
				if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){
					dgResultEntryHeader.setResultStatus("A");
					dgResultEntryHeader.setVerified("V");
				}else{
					dgResultEntryHeader.setResultStatus("P");
					dgResultEntryHeader.setVerified("Y");
				}
				
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					hospital = hbt.get(MasHospital.class,hospitalId);  // added by amit das on 13-08-2017
					
					// added by amit das on 27-09-2016
					Properties properties = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("lab.properties");
					properties.load(resourcePath.openStream());
					String chargeCodeForPregnancyStr = properties.getProperty("chargeCodeForPregnancy");
					if(chargeCodeForPregnancyStr!=null && !chargeCodeForPregnancyStr.trim().equals("")){
						chargeCodeForPregnancyArray = chargeCodeForPregnancyStr.split(",");
					}
					// ended by amit das on 27-09-2016
					
					

					hbt.save(dgResultEntryHeader);
					hbt.refresh(dgResultEntryHeader);
					// ///////////////////////////////
					Set<DgResultEntryDetail> dgResultEntryDetailsSet = dgResultEntryHeader
							.getDgResultEntryDetails();
					List<DgResultEntryDetail> dgResultEntryDetailsList = new ArrayList<DgResultEntryDetail>(
							dgResultEntryDetailsSet);
					DgResultEntryDetail dgResultEntryDetail = null;
					if (dgResultEntryDetailsList.size() > 0) {
						dgResultEntryDetail = dgResultEntryDetailsList.get(0);
					} else {
						dgResultEntryDetail = new DgResultEntryDetail();
					}

					// int x = Integer.parseInt((String)investigationId.get(i));

					if (Integer.parseInt((String) investigationId.get(i)) != 0) {
						if (sample_Id.size() > 0) {
							if (sample_Id.get(i) != null
									&& !sample_Id.get(i).equals("")) {
								if (Integer.parseInt((String) sample_Id.get(i)) != 0) {
									MasSample masSample = new MasSample();
									masSample
											.setId(Integer
													.parseInt((String) sample_Id
															.get(i)));
									dgResultEntryDetail.setSample(masSample);
								}
							}
						}

						// if(investigationId != 0){
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
						// }
						dgResultEntryDetail.setResult((String) result.get(i));
						if (qcResult.size() > 0 && qcResult.get(i) != null) {
							dgResultEntryDetail.setQcResult((String) qcResult
									.get(i));
						}
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail
								.setResultType((String) resultTypeSingleValue
										.get(i));
						if(qcStatus!=null){
							dgResultEntryDetail.setResultDetailStatus(qcStatus);
						}else{
							dgResultEntryDetail.setResultDetailStatus("P");
						}
						
						
						// Add by Vinay						
						if(hinId_OPD != 0)
						{
							dgResultEntryDetail.setResultDetailStatus("A");
						}
						if(qcStatus!=null){
							dgResultEntryDetail.setValidated(qcStatus);
						}else{
							dgResultEntryDetail.setValidated("Y");
						}
						
					
						// Add by Vinay						
						if(hinId_OPD != 0)
						{
							dgResultEntryDetail.setValidated("V");
						}

						if (Integer.parseInt((String) charge_code_Id.get(i)) != 0) {
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(Integer
									.parseInt((String) charge_code_Id.get(i)));
							dgResultEntryDetail.setChargeCode(masChargeCode);
						}
						if (Integer.parseInt((String) sampleDetailId.get(i)) != 0) {
							DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
							dgSample.setId(Integer
									.parseInt((String) sampleDetailId.get(i)));
							dgResultEntryDetail
									.setSampleCollectionDetails(dgSample);
						}
						if (uomId.get(i) != null
								&& !((String) uomId.get(i)).equals("")) {
							DgUom dgUom = new DgUom();
							dgUom.setId(Integer.parseInt((String) uomId.get(i)));
							dgResultEntryDetail.setUom(dgUom);
						}
						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						// map.put("resultType", resultType);
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
								.load(DgSampleCollectionDetails.class,
										Integer.parseInt((String) sampleDetailId
												.get(i)));
						dgDetails.setOrderStatus("E");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
						
						
						// added by amit das on 27-09-2016
						if(chargeCodeForPregnancyArray!=null && chargeCodeForPregnancyArray.length>0){
							List<String> chargeCodes	= Arrays.asList(chargeCodeForPregnancyArray);
							
							//dgMasInvestigation = hbt.get(DgMasInvestigation.class, (Integer) investigationId.get(i)); 
							
							//added by dhananjay 01-10-2016
							dgMasInvestigation = hbt.get(DgMasInvestigation.class, Integer.parseInt((String)investigationId.get(i)) ); 
							patient = hbt.get(Patient.class, hinId);
							if(chargeCodes.contains(dgMasInvestigation.getChargeCode().getChargeCodeCode())){
								PhAlert alert = new PhAlert();
								alert.setHin(patient);
								alert.setHospital(masHospital);
								alert.setMember(patient.getMember());
								alert.setAlertType("PREG");
								hbt.save(alert);
							}
								
						}
						
					}

					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					saved = false;
					e.printStackTrace();
				}
				

				hbt.refresh(dgResultEntryHeader); 
				entryDetailsSet = dgResultEntryHeader.getDgResultEntryDetails();
				Hibernate.initialize(entryDetailsSet);
				Hibernate.initialize(dgResultEntryHeader.getHin());
				Hibernate.initialize(dgResultEntryHeader.getSampleCollectionHeader().getOrder().getVisit());
				resultEntryMap.put(dgResultEntryHeader, entryDetailsSet);	
			}
			
		}
		
		
		
		
		// saved = true;
		map.put("resultNo", resultNo);

		map.put("saved", saved);
		}
		
		Hibernate.initialize(hospital);
		dataForResult.put("resultMap", resultEntryMap);
		dataForResult.put("hospital", hospital);
		
		
		final MasHospital masHospital = hospital;
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital!=null && masHospital.getServerIp()!=null && !masHospital.getServerIp().trim().equals("") && !masHospital.getServerIp().trim().equals("null") && masHospital.getServerPort()!=null && !masHospital.getServerPort().trim().equals("") && !masHospital.getServerPort().trim().equals("null")){
					
					resultManipulactionToCentralServer(dataForResult,"entry");
				} 
				if(masHospital!=null && masHospital.getClientIp()!=null && !masHospital.getClientIp().trim().equals("") && !masHospital.getClientIp().trim().equals("null") && masHospital.getClientPort()!=null && !masHospital.getClientPort().trim().equals("") && !masHospital.getClientPort().trim().equals("null")){
					
					resultManipulactionToLeanServer(dataForResult,"entry");
						
				}
			}
			
		}.start();*/
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameterOnlyForEmpanelled(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSingleParameterOnlyForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();

		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		MasEmpaneled masEmpaneled = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String qcStatus=null;
		if("QCType".equalsIgnoreCase(parameterMap.get("QCType")+"")){
			qcStatus="Q";
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		
		int hinId_OPD =0;
		String RequisitionFrom = "NA"; 
		
		hinId_OPD = box.getInt("hinId_OPD");
		RequisitionFrom = box.getString("RequisitionFrom");
		
		//System.out.println("hinId_OPD="+hinId_OPD);
		//System.out.println("RequisitionFrom="+RequisitionFrom);
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) parameterMap.get(RequestConstants.USERS);
		}

		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_SINGLE_VALUE);
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_SINGLE_VALUE);
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_SINGLE_VALUE);

		// ///////////////////// Data For Details
		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector qcResult = box
				.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector charge_code_Id = box
				.getVector(RequestConstants.CHARGE_CODE_ID_SINGLE_VALUE);
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID_SINGLE_VALUE);
		Vector uomId = box
				.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_SINGLE_VALUE);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		// Vector
		// sampleCollectionId=box.getVector(RequestConstants.SAMPLE_COLLECTION_ID);
		// ///////////////////// Data For Details
		List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
				.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("SampleCollectionHeader.Id",
						sampleCollectionId)).list();
		// .add(Restrictions.ne("ResultStatus", "P"))
		for (int i = 0; i < resultTypeSingleValue.size(); i++) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) {
				DgResultEntryHeader dgResultEntryHeader = null;
				if (dgResultEntryHeaderList.size() > i
						&& dgResultEntryHeaderList.get(i).getInvestigation() != null
						&& dgResultEntryHeaderList.get(i).getInvestigation()
								.getId() == Integer.parseInt(investigationId
								.get(i).toString())) {
					dgResultEntryHeader = dgResultEntryHeaderList.get(i);
				} else {
					dgResultEntryHeader = new DgResultEntryHeader();
				}

				// Vector resultSingle = null;
				int subchargeId = box
						.getInt(RequestConstants.SUB_CHARGECODE_ID);
				int mainChargeId = box
						.getInt(RequestConstants.MAIN_CHARGECODE_ID);
				int hinId = box.getInt(RequestConstants.HIN_ID);
				int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
				int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
				int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
				int resultEnteredId = box
						.getInt(RequestConstants.RESULT_ENTERED_BY);

				dgResultEntryHeader.setResultNo((String) resultNo.get(i));
				//dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks((String) remarks.get(i));
				dgResultEntryHeader.setResultDate(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setResultStatus(qcStatus);
				}else{
					dgResultEntryHeader.setResultStatus("P");
				}
			
				// Add by Vinay
				
				if(hinId_OPD != 0)
				{
					dgResultEntryHeader.setResultStatus("A");
				}
				dgResultEntryHeader.setResultTime(time);
				dgResultEntryHeader.setVerifiedTime(time);
				dgResultEntryHeader.setVerifiedOn(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setVerified(qcStatus);
				}else{
					dgResultEntryHeader.setVerified("Y");
				}
				
				// Add by Vinay
				
				if(hinId_OPD != 0)
				{
					dgResultEntryHeader.setVerified("V");
				}

				if (testOrderNo.get(i) != null
						&& !testOrderNo.get(i).equals("")
						&& !testOrderNo.get(i).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(i)));
				}

				DgMasInvestigation dgMasInvestigationForHeader = new DgMasInvestigation();
				dgMasInvestigationForHeader.setId(Integer
						.parseInt((String) investigationId.get(i)));
				dgResultEntryHeader
						.setInvestigation(dgMasInvestigationForHeader);

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setHin(patient);
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					dgResultEntryHeader.setEmployee(masEmployee);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
				}
				if (resultTypeSingleValue != null
						&& !resultTypeSingleValue.equals("")) {
					dgResultEntryHeader
							.setResultType((String) resultTypeSingleValue
									.get(i));
				}
				dgResultEntryHeader.setEmpaneled(masEmpaneled);
				dgResultEntryHeader.setEmpanelledStatus("Y");
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					hbt.save(dgResultEntryHeader);
					hbt.refresh(dgResultEntryHeader);
					// ///////////////////////////////
					Set<DgResultEntryDetail> dgResultEntryDetailsSet = dgResultEntryHeader
							.getDgResultEntryDetails();
					List<DgResultEntryDetail> dgResultEntryDetailsList = new ArrayList<DgResultEntryDetail>(
							dgResultEntryDetailsSet);
					DgResultEntryDetail dgResultEntryDetail = null;
					if (dgResultEntryDetailsList.size() > 0) {
						dgResultEntryDetail = dgResultEntryDetailsList.get(0);
					} else {
						dgResultEntryDetail = new DgResultEntryDetail();
					}

					// int x = Integer.parseInt((String)investigationId.get(i));

					if (Integer.parseInt((String) investigationId.get(i)) != 0) {
						if (sample_Id.size() > 0) {
							if (sample_Id.get(i) != null
									&& !sample_Id.get(i).equals("")) {
								if (Integer.parseInt((String) sample_Id.get(i)) != 0) {
									MasSample masSample = new MasSample();
									masSample
											.setId(Integer
													.parseInt((String) sample_Id
															.get(i)));
									dgResultEntryDetail.setSample(masSample);
								}
							}
						}

						// if(investigationId != 0){
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
						// }
						dgResultEntryDetail.setResult((String) result.get(i));
						if (qcResult.size() > 0 && qcResult.get(i) != null) {
							dgResultEntryDetail.setQcResult((String) qcResult
									.get(i));
						}
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail
								.setResultType((String) resultTypeSingleValue
										.get(i));
						if(qcStatus!=null){
							dgResultEntryDetail.setResultDetailStatus(qcStatus);
						}else{
							dgResultEntryDetail.setResultDetailStatus("P");
						}
						
						
						// Add by Vinay						
						if(hinId_OPD != 0)
						{
							dgResultEntryDetail.setResultDetailStatus("A");
						}
						if(qcStatus!=null){
							dgResultEntryDetail.setValidated(qcStatus);
						}else{
							dgResultEntryDetail.setValidated("Y");
						}
						
					
						// Add by Vinay						
						if(hinId_OPD != 0)
						{
							dgResultEntryDetail.setValidated("V");
						}

						if (Integer.parseInt((String) charge_code_Id.get(i)) != 0) {
							MasChargeCode masChargeCode = new MasChargeCode();
							masChargeCode.setId(Integer
									.parseInt((String) charge_code_Id.get(i)));
							dgResultEntryDetail.setChargeCode(masChargeCode);
						}
						if (Integer.parseInt((String) sampleDetailId.get(i)) != 0) {
							DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
							dgSample.setId(Integer
									.parseInt((String) sampleDetailId.get(i)));
							dgResultEntryDetail
									.setSampleCollectionDetails(dgSample);
						}
						if (uomId.get(i) != null
								&& !((String) uomId.get(i)).equals("")) {
							DgUom dgUom = new DgUom();
							dgUom.setId(Integer.parseInt((String) uomId.get(i)));
							dgResultEntryDetail.setUom(dgUom);
						}
						dgResultEntryDetail.setEmpanelledStatus("Y");
						dgResultEntryDetail.setEmpaneled(masEmpaneled);
						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						// map.put("resultType", resultType);
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
								.load(DgSampleCollectionDetails.class,
										Integer.parseInt((String) sampleDetailId
												.get(i)));
						dgDetails.setOrderStatus("E");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
					}

					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					saved = false;
					e.printStackTrace();
				}
			}
		}
		// saved = true;
		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	} 
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSingleParameterOnlyPostQC(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSingleParameterOnlyPostQC");
		Map<String, Object> map = new HashMap<String, Object>();

		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate); 
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		
		int hinId_OPD =0;
		String RequisitionFrom = "NA";  
		hinId_OPD = box.getInt("hinId_OPD");
		RequisitionFrom = box.getString("RequisitionFrom"); 
		//System.out.println("hinId_OPD="+hinId_OPD);
		//System.out.println("RequisitionFrom="+RequisitionFrom);
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}  
		Vector result = box.getVector(RequestConstants.RESULT_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_SINGLE_VALUE); 
		// ///////////////////// Data For Details 
		Vector qcResult = box
				.getVector(RequestConstants.QC_RESULT_SINGLE_VALUE); 
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);   
		
		Vector dgResultEntryDetailId=box.getVector("resultEntryDetailId");
		
		//int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
		//int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);   
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE); 
		// .add(Restrictions.ne("ResultStatus", "P"))
		Transaction tx = null; 
		try {
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		//DgResultEntryHeader dgResultEntryHeader=null;
		for (int i = 0; i < dgResultEntryDetailId.size(); i++) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) {
				int resultDetailId=Integer.parseInt(dgResultEntryDetailId.get(i).toString());
				DgResultEntryDetail dgResultEntryDetail=(DgResultEntryDetail) session.get(DgResultEntryDetail.class, resultDetailId);
				DgResultEntryHeader dgResultEntryHeader=  dgResultEntryDetail.getResultEntry();  
				
				 
				dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks((String) remarks.get(i));
				dgResultEntryHeader.setResultDate(date); 
				dgResultEntryHeader.setResultStatus("P");  
				dgResultEntryHeader.setResultTime(time);
				dgResultEntryHeader.setVerifiedTime(time);
				dgResultEntryHeader.setVerifiedOn(date); 
				dgResultEntryHeader.setVerified("Y");  
				/*if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					dgResultEntryHeader.setEmployee(masEmployee);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
				}*/
				if (resultTypeSingleValue != null
						&& !resultTypeSingleValue.equals("")) {
					dgResultEntryHeader
							.setResultType((String) resultTypeSingleValue
									.get(i));
				}
				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);	 
					 
						if (qcResult.size() > 0 && qcResult.get(i) != null) {
							dgResultEntryDetail.setQcResult((String) qcResult
									.get(i));
						}
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail
								.setResultType((String) resultTypeSingleValue
										.get(i)); 
						dgResultEntryDetail.setResultDetailStatus("P");  
						dgResultEntryDetail.setValidated("Y");   
						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						// map.put("resultType", resultType);  	
				
				}
		}
		
		tx.commit();
		saved = true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}
		// saved = true;
		//map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForMultipleInvestigationType(
			Map<String, Object> parameterMap) {
		LOGGER.info("submitResultEntryForMultipleInvestigationType calling");
		Map<String, Object> map = new HashMap<String, Object>();
		final Map<String, Object> dataForResult =  new HashMap<String, Object>(); // added by amit das on 14-09-2017
		Map<DgResultEntryHeader, Set<DgResultEntryDetail>> resultEntryMap = new HashMap<DgResultEntryHeader, Set<DgResultEntryDetail>>();  // added by amit das on 14-09-2017
		Set<DgResultEntryDetail> entryDetailsSet = null; // added by amit das on 14-09-2017
		DgResultEntryHeader dgResultEntryHeaderTemp = null; // added by amit das on 14-09-2017
		MasHospital hospital = null; // added by amit das on 14-09-2017
		
		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session=null;
		session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String qcStatus=null;
		if("QCType".equalsIgnoreCase(parameterMap.get("QCType")+"")){
			qcStatus="Q";
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		
		String forOutSideLab = null;
		if (parameterMap.get("forOutSideLab") != null) {
			forOutSideLab = (String) parameterMap.get("forOutSideLab");
		}
		
		int modalityId = 0;
		if (parameterMap.get("modalityId") != null) {
			modalityId = (Integer) parameterMap.get("modalityId");
		}
		
		Vector resultEntryId = box.getVector("resultEntryId");//added by govind 23-07-2017 
		//added by govind 01-07-2017 
		int updateRow=0;
		if(resultEntryId.size()>0){
			for(int up=0;up<resultEntryId.size();up++){
				Integer resultId=Integer.parseInt((String)resultEntryId.get(up));
				if(resultId>0){
					updateRow++;
				}
			}
		}
		if(updateRow>0){
			Vector upResult = box.getVector("upResult");
			int sampleCollectionId = box
					.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
			org.springframework.orm.hibernate3.HibernateTemplate hbt1=null;
			 hbt1 = getHibernateTemplate();
			hbt1.setFlushModeName("FLUSH_EAGER");
			hbt1.setCheckWriteOperations(false);
			hospital = hbt1.get(MasHospital.class, hospitalId); 
			int size=0;
			
					
			for(int up=0;up<resultEntryId.size();up++){
				Integer entryId=Integer.parseInt((String)resultEntryId.get(up));	
				if(upResult.size()>up){
					String result=(String)upResult.get(up);
					if(!result.equals("")){
					if(entryId>0){
					DgResultEntryDetail entryDetail=hbt1.load(DgResultEntryDetail.class, entryId);
					entryDetail.setResult(result);
					entryDetail.setResultDetailStatus("P");
					entryDetail.setValidated("V");
					hbt1.update(entryDetail);
					hbt1.refresh(entryDetail);
					}
					
					List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
							.createCriteria(DgResultEntryHeader.class)
							.createAlias("SubChargecode", "ssc")
								.add(Restrictions.eq("SampleCollectionHeader.Id",sampleCollectionId))
								.add(Restrictions.eq("ssc.Id",modalityId)).list();
					if(dgResultEntryHeaderList.size()>0){
					for(DgResultEntryHeader dgResultEntryHeader:dgResultEntryHeaderList){
						
					if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){	
						dgResultEntryHeader.setResultStatus("A");
						dgResultEntryHeader.setVerified("V");
					}else{
						dgResultEntryHeader.setResultStatus("P");
						dgResultEntryHeader.setVerified("Y");
					}
					
					
					hbt1.update(dgResultEntryHeader);
					hbt1.refresh(dgResultEntryHeader);	
					dgResultEntryHeaderTemp  = 	dgResultEntryHeader;
					
					/*
					DgSampleCollectionHeader dgSampleCollectionHeader = dgResultEntryHeader.getSampleCollectionHeader();			
					Set<DgSampleCollectionDetails> dgSampleCollectionDetailsSet = dgSampleCollectionHeader
							.getDgSampleCollectionDetails();
					
					for (DgSampleCollectionDetails dgSampleCollectionDetails : dgSampleCollectionDetailsSet) {
						dgSampleCollectionDetails.setOrderStatus("E");
						hbt1.update(dgSampleCollectionDetails);
					}*/
					}
					}	
					
					if(entryId>0){
						DgResultEntryDetail dgResultEntryDetail=hbt1.load(DgResultEntryDetail.class, entryId);
						
					DgSampleCollectionDetails dgSampleCollectionDetails=dgResultEntryDetail.getSampleCollectionDetails();
							dgSampleCollectionDetails.setOrderStatus("E");
							hbt1.update(dgSampleCollectionDetails);
						}
					}
				}
			
				if(dgResultEntryHeaderTemp!=null && dgResultEntryHeaderTemp.getId()!=null){
					hbt1.refresh(dgResultEntryHeaderTemp); // added by amit das on 13-08-2017
					entryDetailsSet = dgResultEntryHeaderTemp.getDgResultEntryDetails();  // added by amit das on 13-08-2017
					Hibernate.initialize(entryDetailsSet); // added by amit das on 14-08-2017
					resultEntryMap.put(dgResultEntryHeaderTemp, entryDetailsSet); // added by amit das on 14-08-2017
				}
				
			}
			
			
			
			
		}else{//added by govind 01-07-2017 end
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_FOR_MULTIPLE_VALUE);
		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_MULTIPLE_VALUE);

		String remarks = box.getString(RequestConstants.REMARKS);
		LOGGER.info("remarks..........."+remarks);
		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		Vector sampleCollectionVector = box
				.getVector(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);

		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);

		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);
		Vector HeaderCountFlag = box.getVector("HeaderCountFlag");

		Vector result = box.getVector(RequestConstants.RESULT);
		Vector qcResult = box.getVector(RequestConstants.QC_RESULT);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS);
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);

		Vector sample_Id = box.getVector(SAMPLE_ID);
		Vector normalId = box.getVector(RequestConstants.NORMAL_ID);
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		Vector qcfixedId = box.getVector(RequestConstants.QC_FIXED_ID);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID);
		Vector subTestSize = box.getVector(RequestConstants.SUB_TEST_SIZE);
		Vector subTestNameSize = box.getVector(RequestConstants.SUBTEST_NAME);

		Vector investigationIdTempForMain = box
				.getVector("investigationIdTempForMain");
		Set<Integer> investigationIdSet = new HashSet<Integer>();
		Transaction tx = null;
		int i = 0;
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt =null;
	    hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		try {
			
			hospital = hbt.get(MasHospital.class, hospitalId); 
			
			List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
					.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",
							sampleCollectionId)).list();
			
			//added by govind 01-07-2017 end
			Vector newResult=new Vector();
			Vector newsampleDetailId=new Vector();
			Vector newsubTestId=new Vector();
			Vector newinvestigationId=new Vector();
			Vector newnormalId=new Vector();
			Vector newuomId=new Vector();
			Vector newsampleId=new Vector();
			Vector newremarks=new Vector();
			String resultString=result.toString().replace("[", "").replace("]", "").trim();
			String[] resultEntryValidationStrArray =	resultString.split("TestRowFlag");
			List<String> resultEntryValidationStrArrayMain = new ArrayList<String>();
			for(int ib=0;ib<resultEntryValidationStrArray.length;ib++){
				if(!(resultEntryValidationStrArray[ib].isEmpty())){
					int ibb=ib-1;
					if(resultEntryValidationStrArray[ib].contains("____")){
						String sr=resultEntryValidationStrArray[ib].replace(",", "").replace("____", "");
						resultEntryValidationStrArrayMain.add(sr);
					}else{
						resultEntryValidationStrArrayMain.add(resultEntryValidationStrArray[ib]);
					}
				}
			}
			int td=0;
			for(int ab=0;ab<result.size();ab++){
				int value=1;
				if(result.get(ab).equals("TestRowFlag")){
					td=td+1;
				}
				if(result.get(ab)!=null && !result.get(ab).equals("") && !result.get(ab).equals("TestRowFlag") && resultEntryValidationStrArrayMain.get(td-1).trim().length()>0 ){
					newResult.add(result.get(ab));
					newsampleDetailId.add(sampleDetailId.get(ab));
					newsubTestId.add(subTestId.get(ab));
					newinvestigationId.add(investigationId.get(ab));
					newnormalId.add(normalId.get(ab));
					newuomId.add(uomId.get(ab));
					newsampleId.add(sample_Id.get(ab));
					newremarks.add(additionalRemarks.get(ab));
				}
			}
			if(newResult.size()>0 && newResult.size()>0){
			sampleDetailId=null;
			result=null;
			subTestId=null;
			investigationId=null;
			normalId=null;
			uomId=null;
			sample_Id=null;
			additionalRemarks=null;
			additionalRemarks=newremarks;
			result=newResult;
			sampleDetailId=newsampleDetailId;
			subTestId=newsubTestId;
			investigationId=newinvestigationId;
			normalId=newnormalId;
			uomId=newuomId;
			sample_Id=newsampleId;
			}
			//added by govind 01-07-2017 end
			for (int j = 0; j <HeaderCountFlag.size(); j++) {
				//i++;
				DgResultEntryHeader dgResultEntryHeader = null;
				if (dgResultEntryHeaderList.size() > j
						&& dgResultEntryHeaderList.get(j).getInvestigation() != null
						&& dgResultEntryHeaderList.get(j).getInvestigation()
								.getId() == Integer
								.parseInt(investigationIdTempForMain.get(j)
										.toString())) {
					dgResultEntryHeader = dgResultEntryHeaderList.get(j);
				} else {
					dgResultEntryHeader = new DgResultEntryHeader();
				}
				//System.out.println("dgResultEntryHeader.getId() " + dgResultEntryHeader.getId());
				dgResultEntryHeader.setResultNo((String) resultNo.get(j));
				if (testOrderNo.get(j) != null
						&& !testOrderNo.get(j).equals("")
						&& !testOrderNo.get(j).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(j)));
				}

				dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks(remarks);
				dgResultEntryHeader.setResultDate(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setResultStatus(qcStatus);
					dgResultEntryHeader.setVerified(qcStatus);
				}else{
					dgResultEntryHeader.setResultStatus("P");
					dgResultEntryHeader.setVerified("Y");
				}
				
				dgResultEntryHeader.setResultTime(time); 
				dgResultEntryHeader.setVerifiedOn(date);
				dgResultEntryHeader.setVerifiedTime(time);
				if (resultType != null && !resultType.equals("")) {
					dgResultEntryHeader.setResultType((String) resultType
							.get(j));
				}

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				// dgSampleCollectionHeader.setId((Integer)sampleCollectionVector.get(j));

				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);
				if (investigationIdTempForMain.get(j) != null
						&& !investigationIdTempForMain.get(j).equals("")) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(Integer
							.parseInt((String) investigationIdTempForMain
									.get(j)));
					/*int id=Integer.parseInt((String) investigationIdTempForMain.get(j));
					DgMasInvestigation dgMasInvestigationObj=(DgMasInvestigation)hbt.load(DgMasInvestigation.class,id);
					*/
					dgResultEntryHeader.setInvestigation(dgMasInvestigation);
				}
				if (hinId != 0) {
					Patient patient = new Patient();
					patient.setId(hinId);
					dgResultEntryHeader.setHin(patient);
				}

				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}

				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}

				if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){	
					dgResultEntryHeader.setResultStatus("A");
					dgResultEntryHeader.setVerified("V");
				}else{
					dgResultEntryHeader.setResultStatus("P");
					dgResultEntryHeader.setVerified("Y");
				}
				
				
				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);
				/*
				 * Set<DgResultEntryDetail> dgResultEntryDetailsSet =
				 * dgResultEntryHeader .getDgResultEntryDetails();
				 * 
				 * List<DgResultEntryDetail> dgResultEntryDetailsList =
				 * (List<DgResultEntryDetail>) session
				 * .createCriteria(DgResultEntryDetail.class)
				 * .add(Restrictions.eq("ResultEntry.Id",
				 * sampleCollectionId)).list();
				 */
				dgResultEntryHeaderTemp  = 	dgResultEntryHeader;
				
				String hql = "DELETE FROM DgResultEntryDetail "
						+ "WHERE ResultEntry.Id = :resultEntryHeader";
				Query query = session.createQuery(hql);
				query.setParameter("resultEntryHeader",
						dgResultEntryHeader.getId());
				int deleteesult = query.executeUpdate();
				for (int loopCount = 0; loopCount < Integer
						.parseInt((String) subTestSize.get(j)); loopCount++) {
				if(result.size()>i){						
				if((result.get(i)!=null)  && (!result.get(i).equals("")) && !result.get(i).equals("TestRowFlag")){
					//System.out.println(i+" result "+(result.get(i))+" (result.get(i)!=null) "+(result.get(i)!=null)+" (result.get(i).equals) "+(!result.get(i).equals("")));
					try {
						if (subTestId.size()>i && subTestId.get(i) != null
								&& !subTestId.get(i).equals("")) {
							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();

							if (sample_Id.get(i) != null
									&& !sample_Id.get(i).equals("")) {
								MasSample masSample = new MasSample();
								masSample.setId(Integer
										.parseInt((String) sample_Id.get(i)));
								dgResultEntryDetail.setSample(masSample);
							}

							if (normalId != null) {
								if (normalId.get(i) != null
										&& !normalId.get(i).equals("") && !normalId.get(i).equals("0")) {

									DgNormalValue dgNormalValue = new DgNormalValue();
									dgNormalValue
											.setId(Integer
													.parseInt((String) normalId
															.get(i)));
									dgResultEntryDetail
											.setNormal(dgNormalValue);
								}
							} else {
								dgResultEntryDetail.setNormal(null);
							}

							if (fixedId.get(i) != null
									&& !fixedId.get(i).equals("")) {
								DgFixedValue dgFixedValue = new DgFixedValue();
								dgFixedValue.setId(Integer
										.parseInt((String) fixedId.get(i)));
								dgResultEntryDetail.setFixed(dgFixedValue);
							}
							if (qcfixedId.size() > 1
									&& (qcfixedId.get(i) != null && !qcfixedId
											.get(i).equals(""))) {
								DgFixedValue dgFixedValue = new DgFixedValue();
								dgFixedValue.setId(Integer
										.parseInt((String) qcfixedId.get(i)));
								dgResultEntryDetail.setQcFixed(dgFixedValue);
							}

							if (investigationId.get(i) != null
									&& !investigationId.get(i).equals("")) {
								DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
								dgMasInvestigation.setId(Integer
										.parseInt((String) investigationId
												.get(i)));
								dgResultEntryDetail
										.setInvestigation(dgMasInvestigation);
							}
							if (investigationId.get(i) != null
									&& !investigationId.get(i).equals("")) {
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(Integer
										.parseInt((String) investigationId
												.get(i)));
								dgResultEntryDetail
										.setChargeCode(masChargeCode);
							}
							if (additionalRemarks.get(i) != null) {
								dgResultEntryDetail
										.setRemarks((String) additionalRemarks
												.get(i));
							}

							if (resultType != null && !resultType.equals("")) {
								dgResultEntryDetail
										.setResultType((String) resultType
												.get(i));
							}
							DgSubMasInvestigation  subInvestigationObj=null;
							if (subTestId.get(i) != null
									&& !subTestId.get(i).equals("")) {
								int id=Integer.parseInt((String) subTestId.get(i));
								DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
								dgSubMasInvestigation.setId(Integer
										.parseInt((String) subTestId.get(i)));
								dgResultEntryDetail
										.setSubInvestigation(dgSubMasInvestigation);
								subInvestigationObj=(DgSubMasInvestigation)hbt.load(DgSubMasInvestigation.class,id);
							}

							if (uomId.get(i) != null
									&& !uomId.get(i).equals("") && !uomId.get(i).equals("0") ) {
								DgUom dgUom = new DgUom();
								dgUom.setId(Integer.parseInt((String) uomId
										.get(i)));
								dgResultEntryDetail.setUom(dgUom);
							}else{
								dgResultEntryDetail.setUom(null);
							}
							if (sampleDetailId.get(i) != null
									&& !sampleDetailId.get(i).equals("")) {
								DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
								dgSample.setId(Integer
										.parseInt((String) sampleDetailId
												.get(i)));
								dgResultEntryDetail
										.setSampleCollectionDetails(dgSample);
							}

							if (result.get(i) != null
									&& !result.get(i).equals("")) {
								dgResultEntryDetail.setResult((String) result
										.get(i));
							}
							if (qcResult.size() > 1
									&& (qcResult.get(i) != null && !qcResult
											.get(i).equals(""))) {
								dgResultEntryDetail
										.setQcResult((String) qcResult.get(i));
							}
							if(qcStatus!=null){
								dgResultEntryDetail.setResultDetailStatus(qcStatus);
								dgResultEntryDetail.setValidated(qcStatus);
							}else{
								
								dgResultEntryDetail.setResultDetailStatus("P");
								dgResultEntryDetail.setValidated("Y");
								
							}
								
							dgResultEntryDetail
									.setResultEntry(dgResultEntryHeader);
							hbt.save(dgResultEntryDetail);
					        hbt.refresh(dgResultEntryDetail);
							map.put("resultType", (String) resultType.get(i));
							int sId = Integer.parseInt((String) sampleDetailId
									.get(i));

							DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
									.load(DgSampleCollectionDetails.class, sId);
							dgDetails.setOrderStatus("E");
							hbt.update(dgDetails);
							hbt.refresh(dgDetails);
							}
					} catch (Exception e) {
						e.printStackTrace();
						if (tx != null) {
							tx.rollback();
						}
						saved = false;
						break;
					}
				   
				      }
					}
				i++;
				}
				//i++;
				
				if(dgResultEntryHeaderTemp!=null && dgResultEntryHeaderTemp.getId()!=null){
					hbt.refresh(dgResultEntryHeaderTemp); 
					entryDetailsSet = dgResultEntryHeaderTemp.getDgResultEntryDetails(); 
					Hibernate.initialize(entryDetailsSet); 
					Hibernate.initialize(dgResultEntryHeaderTemp.getHin());
					Hibernate.initialize(dgResultEntryHeaderTemp.getSampleCollectionHeader().getOrder().getVisit());
					resultEntryMap.put(dgResultEntryHeaderTemp, entryDetailsSet); 
				}
			}
			// //////////////////////////////////////////////////
			if (saved) {
				tx.commit();
			}
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}

		Map<String, Object> updateDgMasMap = new HashMap<String, Object>();
		updateDgMasMap.put("investigationIdTempForMain",
				investigationIdTempForMain);
		updateDgMasMap.put("hinId", hinId);
		updateDgMasMap.put("inpatientId", inpatientId);
		updateDgMasMap.put("deptId", deptId);

		if (saved) {
			try {
				updateSubmitedResultEntryForMultipleInvestigationType(updateDgMasMap);
			} catch (Exception e) {
				saved = false;
				e.printStackTrace();
			}
		}
		
		

		map.put("saved", saved);
		map.put("resultNo", resultNo);
		}
		
		Hibernate.initialize(hospital);
		dataForResult.put("resultMap", resultEntryMap); 
		dataForResult.put("hospital", hospital);
		
		final MasHospital masHospital1 = hospital;
		
		//#13- Tech Debt: Comment out the code those are related to Lean server
		/*new Thread(){
			public void run(){
				if(masHospital1!=null && masHospital1.getServerIp()!=null && !masHospital1.getServerIp().trim().equals("") && !masHospital1.getServerIp().trim().equals("null") && masHospital1.getServerPort()!=null && !masHospital1.getServerPort().trim().equals("") && !masHospital1.getServerPort().trim().equals("null")){
					
					resultManipulactionToCentralServer(dataForResult,"entry");
				} 
				if(masHospital1!=null && masHospital1.getClientIp()!=null && !masHospital1.getClientIp().trim().equals("") && !masHospital1.getClientIp().trim().equals("null") && masHospital1.getClientPort()!=null && !masHospital1.getClientPort().trim().equals("") && !masHospital1.getClientPort().trim().equals("null")){
					
					resultManipulactionToLeanServer(dataForResult,"entry");
						
				}
			}
			
		}.start();*/
		
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForMultipleInvestigationTypeForEmpanelled(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForMultipleInvestigationTypeForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();

		MasHospital hospital = null; // added by amit das on 14-09-2017
		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		MasEmpaneled masEmpaneled = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		String qcStatus=null;
		if("QCType".equalsIgnoreCase(parameterMap.get("QCType")+"")){
			qcStatus="Q";
		}
		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) parameterMap.get(RequestConstants.USERS);
		}
		Vector resultNo = box
				.getVector(RequestConstants.RESULT_NO_FOR_MULTIPLE_VALUE);
		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_MULTIPLE_VALUE);

		String remarks = box.getString(RequestConstants.REMARKS);

		int subchargeId = box.getInt(RequestConstants.SUB_CHARGECODE_ID);
		int mainChargeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int sampleCollectionId = box
				.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
		Vector sampleCollectionVector = box
				.getVector(RequestConstants.SAMPLE_COLLECTION_ID);
		int hinId = box.getInt(RequestConstants.HIN_ID);
		int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);

		int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);

		int resultEnteredId = box.getInt(RequestConstants.RESULT_ENTERED_BY);
		Vector HeaderCountFlag = box.getVector("HeaderCountFlag");

		Vector result = box.getVector(RequestConstants.RESULT);
		Vector qcResult = box.getVector(RequestConstants.QC_RESULT);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS);
		Vector subTestId = box.getVector(RequestConstants.SUBTEST_ID);

		Vector sample_Id = box.getVector(SAMPLE_ID);
		Vector normalId = box.getVector(RequestConstants.NORMAL_ID);
		Vector fixedId = box.getVector(RequestConstants.FIXED_ID);
		Vector qcfixedId = box.getVector(RequestConstants.QC_FIXED_ID);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID);
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID);
		Vector subTestSize = box.getVector(RequestConstants.SUB_TEST_SIZE);
		Vector subTestNameSize = box.getVector(RequestConstants.SUBTEST_NAME);

		Vector investigationIdTempForMain = box
				.getVector("investigationIdTempForMain");
		Set<Integer> investigationIdSet = new HashSet<Integer>();
		Transaction tx = null;
		int i = 0;
		tx = session.beginTransaction();
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		MasHospital masHospital = null;
		try {
			
			hospital = hbt.get(MasHospital.class, hospitalId); 
			List<DgResultEntryHeader> dgResultEntryHeaderList = (List<DgResultEntryHeader>) session
					.createCriteria(DgResultEntryHeader.class)
					.add(Restrictions.eq("SampleCollectionHeader.Id",
							sampleCollectionId)).list();
			for (int j = 0; j < HeaderCountFlag.size(); j++) {
				i++;
				DgResultEntryHeader dgResultEntryHeader = null;
				if (dgResultEntryHeaderList.size() > j
						&& dgResultEntryHeaderList.get(j).getInvestigation() != null
						&& dgResultEntryHeaderList.get(j).getInvestigation()
								.getId() == Integer
								.parseInt(investigationIdTempForMain.get(j)
										.toString())) {
					dgResultEntryHeader = dgResultEntryHeaderList.get(j);
				} else {
					dgResultEntryHeader = new DgResultEntryHeader();
				}
				dgResultEntryHeader.setResultNo((String) resultNo.get(j));
				if (testOrderNo.get(j) != null
						&& !testOrderNo.get(j).equals("")
						&& !testOrderNo.get(j).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(j)));
				}

				//dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks(remarks);
				dgResultEntryHeader.setResultDate(date);
				if(qcStatus!=null){
					dgResultEntryHeader.setResultStatus(qcStatus);
					dgResultEntryHeader.setVerified(qcStatus);
				}else{
					dgResultEntryHeader.setResultStatus("P");
					dgResultEntryHeader.setVerified("Y");
				}
				
				dgResultEntryHeader.setResultTime(time); 
				dgResultEntryHeader.setVerifiedOn(date);
				dgResultEntryHeader.setVerifiedTime(time);
				if (resultType != null && !resultType.equals("")) {
					dgResultEntryHeader.setResultType((String) resultType
							.get(j));
				}

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				// dgSampleCollectionHeader.setId((Integer)sampleCollectionVector.get(j));

				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				//	MasHospital masHospital = new MasHospital();
				//  masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);
				if (investigationIdTempForMain.get(j) != null
						&& !investigationIdTempForMain.get(j).equals("")) {
					DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
					dgMasInvestigation.setId(Integer
							.parseInt((String) investigationIdTempForMain
									.get(j)));
					dgResultEntryHeader.setInvestigation(dgMasInvestigation);
				}
				if (hinId != 0) {
					Patient patient = new Patient();
					patient.setId(hinId);
					dgResultEntryHeader.setHin(patient);
				}

				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}

				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
					//dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				dgResultEntryHeader.setEmpaneled(masEmpaneled);
				dgResultEntryHeader.setEmpanelledStatus("Y");
				
				hbt.save(dgResultEntryHeader);
				hbt.refresh(dgResultEntryHeader);
				/*
				 * Set<DgResultEntryDetail> dgResultEntryDetailsSet =
				 * dgResultEntryHeader .getDgResultEntryDetails();
				 * 
				 * List<DgResultEntryDetail> dgResultEntryDetailsList =
				 * (List<DgResultEntryDetail>) session
				 * .createCriteria(DgResultEntryDetail.class)
				 * .add(Restrictions.eq("ResultEntry.Id",
				 * sampleCollectionId)).list();
				 */
				String hql = "DELETE FROM DgResultEntryDetail "
						+ "WHERE ResultEntry.Id = :resultEntryHeader";
				Query query = session.createQuery(hql);
				query.setParameter("resultEntryHeader",
						dgResultEntryHeader.getId());
				int deleteesult = query.executeUpdate();
				for (int loopCount = 0; loopCount < Integer
						.parseInt((String) subTestSize.get(j)); loopCount++, i++) {

					try {
						if (subTestId.size()>i && subTestId.get(i) != null
								&& !subTestId.get(i).equals("")) {

							DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();

							if (sample_Id.get(i) != null
									&& !sample_Id.get(i).equals("")) {
								MasSample masSample = new MasSample();
								masSample.setId(Integer
										.parseInt((String) sample_Id.get(i)));
								dgResultEntryDetail.setSample(masSample);
							}

							if (normalId != null) {
								if (normalId.get(i) != null
										&& !normalId.get(i).equals("")) {

									DgNormalValue dgNormalValue = new DgNormalValue();
									dgNormalValue
											.setId(Integer
													.parseInt((String) normalId
															.get(i)));
									dgResultEntryDetail
											.setNormal(dgNormalValue);
								}
							} else {
								dgResultEntryDetail.setNormal(null);
							}

							if (fixedId.get(i) != null
									&& !fixedId.get(i).equals("")) {
								DgFixedValue dgFixedValue = new DgFixedValue();
								dgFixedValue.setId(Integer
										.parseInt((String) fixedId.get(i)));
								dgResultEntryDetail.setFixed(dgFixedValue);
							}
							if (qcfixedId.size() > 1
									&& (qcfixedId.get(i) != null && !qcfixedId
											.get(i).equals(""))) {
								DgFixedValue dgFixedValue = new DgFixedValue();
								dgFixedValue.setId(Integer
										.parseInt((String) qcfixedId.get(i)));
								dgResultEntryDetail.setQcFixed(dgFixedValue);
							}

							if (investigationId.get(i) != null
									&& !investigationId.get(i).equals("")) {
								DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
								dgMasInvestigation.setId(Integer
										.parseInt((String) investigationId
												.get(i)));
								dgResultEntryDetail
										.setInvestigation(dgMasInvestigation);
							}
							if (investigationId.get(i) != null
									&& !investigationId.get(i).equals("")) {
								MasChargeCode masChargeCode = new MasChargeCode();
								masChargeCode.setId(Integer
										.parseInt((String) investigationId
												.get(i)));
								dgResultEntryDetail
										.setChargeCode(masChargeCode);
							}
							if (additionalRemarks.get(i) != null) {
								dgResultEntryDetail
										.setRemarks((String) additionalRemarks
												.get(i));
							}

							if (resultType != null && !resultType.equals("")) {
								dgResultEntryDetail
										.setResultType((String) resultType
												.get(i));
							}

							if (subTestId.get(i) != null
									&& !subTestId.get(i).equals("")) {
								DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
								dgSubMasInvestigation.setId(Integer
										.parseInt((String) subTestId.get(i)));
								dgResultEntryDetail
										.setSubInvestigation(dgSubMasInvestigation);
							}

							if (uomId.get(i) != null
									&& !uomId.get(i).equals("")) {
								DgUom dgUom = new DgUom();
								dgUom.setId(Integer.parseInt((String) uomId
										.get(i)));
								dgResultEntryDetail.setUom(dgUom);
							}
							if (sampleDetailId.get(i) != null
									&& !sampleDetailId.get(i).equals("")) {
								DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
								dgSample.setId(Integer
										.parseInt((String) sampleDetailId
												.get(i)));
								dgResultEntryDetail
										.setSampleCollectionDetails(dgSample);
							}

							if (result.get(i) != null
									&& !result.get(i).equals("")) {
								dgResultEntryDetail.setResult((String) result
										.get(i));
							}
							if (qcResult.size() > 1
									&& (qcResult.get(i) != null && !qcResult
											.get(i).equals(""))) {
								dgResultEntryDetail
										.setQcResult((String) qcResult.get(i));
							}
							if(qcStatus!=null){
								dgResultEntryDetail.setResultDetailStatus(qcStatus);
								dgResultEntryDetail.setValidated(qcStatus);
							}else{
								dgResultEntryDetail.setResultDetailStatus("P");
								dgResultEntryDetail.setValidated("Y");
							}
							
							dgResultEntryDetail
									.setResultEntry(dgResultEntryHeader);
							dgResultEntryDetail.setEmpanelledStatus("Y");
							dgResultEntryDetail.setEmpaneled(masEmpaneled);
							hbt.save(dgResultEntryDetail);
							hbt.refresh(dgResultEntryDetail);
							map.put("resultType", (String) resultType.get(i));
							int sId = Integer.parseInt((String) sampleDetailId
									.get(i));

							DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
									.load(DgSampleCollectionDetails.class, sId);
							dgDetails.setOrderStatus("E");
							hbt.update(dgDetails);
							hbt.refresh(dgDetails);

						}
					} catch (Exception e) {
						e.printStackTrace();
						if (tx != null) {
							tx.rollback();
						}
						saved = false;
						break;
					}
					// }
				}
			}
			// //////////////////////////////////////////////////
			if (saved) {
				tx.commit();
			}
			
			
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			saved = false;
			e.printStackTrace();
		}

		Map<String, Object> updateDgMasMap = new HashMap<String, Object>();
		updateDgMasMap.put("investigationIdTempForMain",
				investigationIdTempForMain);
		updateDgMasMap.put("hinId", hinId);
		updateDgMasMap.put("inpatientId", inpatientId);
		updateDgMasMap.put("deptId", deptId);

		if (saved) {
			try {
				updateSubmitedResultEntryForMultipleInvestigationType(updateDgMasMap);
			} catch (Exception e) {
				saved = false;
				e.printStackTrace();
			}
		}
		
		
		map.put("saved", saved);
		map.put("resultNo", resultNo);
		return map;
	}

	public void updateSubmitedResultEntryForMultipleInvestigationType(
			Map<String, Object> map) {
		LOGGER.info("in updateSubmitedResultEntryForMultipleInvestigationType");
		int hinId = 0;
		int inpatientId = 0;
		int deptId = 0;
		if (map.get("hinId") != null) {
			hinId = (Integer) map.get("hinId");
		}
		if (map.get("inpatientId") != null) {
			inpatientId = (Integer) map.get("inpatientId");
		}
		if (map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		Vector investigationIdTempForMain = new Vector();
		if (map.get("investigationIdTempForMain") != null) {
			investigationIdTempForMain = (Vector) map
					.get("investigationIdTempForMain");
		}
		try {
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			List<DgResultEntryDetail> dgResultEntryDetailList = new ArrayList<DgResultEntryDetail>();
			List<DgResultEntryHeader> dgResultEntryHeaderList = new ArrayList<DgResultEntryHeader>();
			if (investigationIdTempForMain.size() > 0) {
				// for (Integer investigationId :investigationIdTempForMain) {
				for (int i = 0; i < investigationIdTempForMain.size(); i++) {
					int investigationId = 0;
					investigationId = Integer
							.parseInt((String) investigationIdTempForMain
									.get(i));

					dgResultEntryHeaderList = hbt
							.find("select dreh from jkt.hms.masters.business.DgResultEntryHeader as dreh join dreh.Investigation as inv join dreh.Hin as hin join dreh.Department as dept where dept.Id="
									+ deptId
									+ " and hin.Id="
									+ hinId
									+ " and inv.Id="
									+ investigationId
									+ " order by dreh.Id desc");

					if (dgResultEntryHeaderList.size() > 0) {
						DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
						dgResultEntryHeader = (DgResultEntryHeader) dgResultEntryHeaderList
								.get(0);
						int headerId = 0;
						headerId = dgResultEntryHeader.getId();
						DecimalFormat df = new DecimalFormat("#.##");
						dgResultEntryDetailList = hbt
								.find("select dred from jkt.hms.masters.business.DgResultEntryDetail as dred join  dred.ResultEntry as re join dred.Investigation as inv where re.Id="
										+ headerId
										+ " and inv.Id="
										+ investigationId + "");
						if (dgResultEntryDetailList.size() > 0) {
							for (DgResultEntryDetail dgResultEntryDetail : dgResultEntryDetailList) {
								DgResultEntryDetail dgResultEntryDetailUpdate = new DgResultEntryDetail();
								dgResultEntryDetailUpdate = (DgResultEntryDetail) hbt
										.load(DgResultEntryDetail.class,
												dgResultEntryDetail.getId());
								String subInvstigationName = "";
								String subInvstigationNameForLiver = "";
								String subInvstigationNameForRenal = "";
								String vldlResultInt = "0";
								if (dgResultEntryDetail.getInvestigation() != null) {
									// commented by manjul on 2/5/2012 to remove
									// all calculations from lipid profile
									// parameters as asked by Dr V.K.Das
									/*
									 * if(dgResultEntryDetail.getInvestigation().
									 * getInvestigationName
									 * ().equalsIgnoreCase("LIPID PROFILE")){
									 * 
									 * if(dgResultEntryDetail.getSubInvestigation
									 * ()!=null){
									 * subInvstigationName=dgResultEntryDetail
									 * .getSubInvestigation
									 * ().getSubInvestigationName(); VLDL=
									 * Sr.Triglyceride/5 LDL= Sr.Cholestrol -
									 * HDL - VLDL LDL/HDL Ratio = LDL/HDL
									 * Total/HDL Ratio = Sr. Cholestrol/HDL
									 * 
									 * 
									 * 
									 * if(subInvstigationName.equalsIgnoreCase(
									 * "VLDL")){ String vldlResult=""; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * if(dgResultEntryDetail2
									 * .getSubInvestigation
									 * ().getSubInvestigationName
									 * ().equalsIgnoreCase("SR.TRIGLYCERIDE")){
									 * vldlResult
									 * =dgResultEntryDetail2.getResult(); try{
									 * vldlResultInt
									 * =df.format(Double.parseDouble
									 * (vldlResult)/5); }catch (Exception e) {
									 * vldlResultInt="0"; } } }
									 * dgResultEntryDetailUpdate
									 * .setResult(""+vldlResultInt); }else
									 * if(subInvstigationName
									 * .equalsIgnoreCase("LDL")){ //String
									 * SR.CHOLESTROL=""; String
									 * srCholestrolRes=""; String hdlResult="";
									 * String srTriResult=""; String
									 * ldlResultInt="0"; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * 
									 * 
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("SR.TRIGLYCERIDE")){
									 * srTriResult=dgResultEntryDetail2
									 * .getResult(); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("SR.CHOLESTROL")){
									 * srCholestrolRes=dgResultEntryDetail2
									 * .getResult(); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("HDL")){
									 * hdlResult=dgResultEntryDetail2.getResult
									 * (); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("VLDL")){
									 * vldlResult=dgResultEntryDetail2
									 * .getResult(); } try{ if(srTriResult!=""
									 * && srCholestrolRes!="" && hdlResult!=""){
									 * ldlResultInt
									 * =df.format(Double.parseDouble(
									 * srCholestrolRes
									 * )-(Double.parseDouble(hdlResult
									 * )+(Double.parseDouble(srTriResult)/5)));
									 * } }catch (Exception e) {
									 * ldlResultInt="0"; } }
									 * dgResultEntryDetailUpdate
									 * .setResult(ldlResultInt); }else
									 * if(subInvstigationName
									 * .equalsIgnoreCase("LDL/HDL Ratio")){
									 * //LDL/HDL Ratio = LDL/HDL String
									 * ldlStr=""; String hdlStr="";
									 * 
									 * String srCholestrolRes=""; String
									 * hdlResult=""; String vldlResult="";
									 * String resultLDL_HDL_Ratio=""; double
									 * ldlResultIntTemp=0; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * 
									 * 
									 * Local
									 * 
									 * double vldlResultIntLocal=0;
									 * if(dgResultEntryDetail2
									 * .getSubInvestigation
									 * ().getSubInvestigationName
									 * ().equalsIgnoreCase("SR.TRIGLYCERIDE")){
									 * try{
									 * vldlResultIntLocal=Double.parseDouble
									 * (dgResultEntryDetail2.getResult())/5;
									 * }catch (Exception e) {
									 * vldlResultIntLocal=0; } }
									 * 
									 * 
									 * 
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("SR.CHOLESTROL")){
									 * srCholestrolRes=dgResultEntryDetail2
									 * .getResult(); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("HDL")){
									 * hdlResult=dgResultEntryDetail2.getResult
									 * (); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("VLDL")){
									 * vldlResult=dgResultEntryDetail2
									 * .getResult(); } try{
									 * ldlResultIntTemp=Double
									 * .parseDouble(srCholestrolRes
									 * )-Double.parseDouble
									 * (hdlResult)-vldlResultIntLocal; }catch
									 * (Exception e) { ldlResultIntTemp=0; } }
									 * try{ resultLDL_HDL_Ratio=df.format(
									 * ldlResultIntTemp
									 * /Double.parseDouble(hdlResult)); }catch
									 * (Exception e) { e.printStackTrace(); }
									 * dgResultEntryDetailUpdate
									 * .setResult(""+resultLDL_HDL_Ratio); }else
									 * if(subInvstigationName.equalsIgnoreCase(
									 * "Total/HDL Ratio")){ //Total/HDL Ratio =
									 * Sr. Cholestrol/HDL String
									 * srCholestrolRes=""; String hdlResult="";
									 * String resultTotalHDL_Ratio="";
									 * 
									 * for (DgResultEntryDetail
									 * dgResultEntryDetail2 :
									 * dgResultEntryDetailList) {
									 * 
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("SR.CHOLESTROL")){
									 * srCholestrolRes=dgResultEntryDetail2
									 * .getResult(); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("HDL")){
									 * hdlResult=dgResultEntryDetail2.getResult
									 * (); } try{ if(srCholestrolRes!="" &&
									 * hdlResult!=""){
									 * resultTotalHDL_Ratio=df.format
									 * (Double.parseDouble
									 * (srCholestrolRes)/Double
									 * .parseDouble(hdlResult)); } }catch
									 * (Exception e) { e.printStackTrace(); } }
									 * dgResultEntryDetailUpdate
									 * .setResult(""+resultTotalHDL_Ratio); }
									 * else
									 * if(subInvstigationName.equals("VLDL")){
									 * 
									 * }else
									 * if(subInvstigationName.equals("VLDL")){
									 * 
									 * } }
									 * hbt.saveOrUpdate(dgResultEntryDetailUpdate
									 * ); }else
									 * if(dgResultEntryDetail.getInvestigation
									 * ().
									 * getInvestigationName().equalsIgnoreCase
									 * ("LIVER FUNCTION TEST")){
									 * 
									 * S.Bilirubin Indirect = Total.Bilirubin -
									 * Direct.Bilirubin Globulins = Total
									 * Protein- Albumin
									 * 
									 * 
									 * if(dgResultEntryDetail.getSubInvestigation
									 * ()!=null){ subInvstigationNameForLiver=
									 * dgResultEntryDetail
									 * .getSubInvestigation().
									 * getSubInvestigationName();
									 * 
									 * if(subInvstigationNameForLiver.
									 * equalsIgnoreCase
									 * ("S.BILIRUBIN INDIRECT")){ String
									 * resultSBilirubinIndirect=""; String
									 * resultSBilirubinTotal=""; String
									 * resultSBilirubinDirect=""; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * if(dgResultEntryDetail2
									 * .getSubInvestigation
									 * ().getSubInvestigationName
									 * ().equalsIgnoreCase
									 * ("S.BILIRUBIN TOTAL")){
									 * resultSBilirubinTotal
									 * =dgResultEntryDetail2.getResult(); }
									 * if(dgResultEntryDetail2
									 * .getSubInvestigation
									 * ().getSubInvestigationName
									 * ().equalsIgnoreCase
									 * ("S.BILIRUBIN DIRECT")){
									 * resultSBilirubinDirect
									 * =dgResultEntryDetail2.getResult(); }
									 * if(resultSBilirubinTotal!="" &&
									 * resultSBilirubinDirect!=""){
									 * resultSBilirubinIndirect
									 * =df.format((Double
									 * .parseDouble(resultSBilirubinTotal
									 * )-Double
									 * .parseDouble(resultSBilirubinDirect))); }
									 * } dgResultEntryDetailUpdate.setResult(""+
									 * resultSBilirubinIndirect); }else
									 * if(subInvstigationNameForLiver
									 * .equalsIgnoreCase("GLOBULINS")){ String
									 * resultGlobulins=""; String total="";
									 * String albumin=""; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * if(dgResultEntryDetail2
									 * .getSubInvestigation
									 * ().getSubInvestigationName
									 * ().equalsIgnoreCase("TOTAL")){
									 * total=dgResultEntryDetail2.getResult(); }
									 * if
									 * (dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("ALBUMIN")){
									 * albumin=dgResultEntryDetail2.getResult();
									 * } if(total!="" && albumin!=""){
									 * resultGlobulins
									 * =df.format((Double.parseDouble
									 * (total)-Double.parseDouble(albumin))); }
									 * } dgResultEntryDetailUpdate.setResult(""+
									 * resultGlobulins); }else
									 * if(subInvstigationNameForLiver
									 * .equalsIgnoreCase("A/G Ratio")){ String
									 * agRatio=""; String resultAlbumin="";
									 * //String resultGlobulin="";
									 * 
									 * 
									 * String resultGlobulins=""; String
									 * total=""; String albumin=""; for
									 * (DgResultEntryDetail dgResultEntryDetail2
									 * : dgResultEntryDetailList) {
									 * 
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("TOTAL")){
									 * total=dgResultEntryDetail2.getResult(); }
									 * if
									 * (dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("ALBUMIN")){
									 * albumin=dgResultEntryDetail2.getResult();
									 * } if(total!="" && albumin!=""){
									 * resultGlobulins
									 * =""+(Double.parseDouble(total
									 * )-Double.parseDouble(albumin)); }
									 * 
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("Albumin")){
									 * resultAlbumin=dgResultEntryDetail2
									 * .getResult(); }
									 * if(dgResultEntryDetail2.getSubInvestigation
									 * (
									 * ).getSubInvestigationName().equalsIgnoreCase
									 * ("Globulin")){
									 * resultGlobulin=dgResultEntryDetail2
									 * .getResult(); } if(albumin!="" &&
									 * resultGlobulins!=""){
									 * agRatio=df.format((Double
									 * .parseDouble(albumin
									 * )/Double.parseDouble(resultGlobulins)));
									 * } }
									 * dgResultEntryDetailUpdate.setResult(""+
									 * agRatio); } }
									 * hbt.saveOrUpdate(dgResultEntryDetailUpdate
									 * ); }else
									 */if (dgResultEntryDetail
											.getInvestigation()
											.getInvestigationName()
											.equalsIgnoreCase(
													"RENAL FUNCTION TEST")) {
										/*
										 * A/G Ratio = Albumin/Globulines Sub
										 * Test No 2= Sub Test No 1/2.14 and
										 * also same for Gloulins and A/G Ratio
										 */

										if (dgResultEntryDetail
												.getSubInvestigation() != null) {
											subInvstigationNameForRenal = dgResultEntryDetail
													.getSubInvestigation()
													.getSubInvestigationName();

											if (subInvstigationNameForRenal
													.equalsIgnoreCase("A/G Ratio")) {
												String agRatio = "";
												String resultAlbumin = "";
												// String resultGlobulin="";

												String resultGlobulins = "";
												String total = "";
												String albumin = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {

													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"Total Proteins")) {
														total = dgResultEntryDetail2
																.getResult();
													}
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"Albumin")) {
														albumin = dgResultEntryDetail2
																.getResult();
													}
													if (total != ""
															&& albumin != "") {
														resultGlobulins = ""
																+ (Double
																		.parseDouble(total) - Double
																		.parseDouble(albumin));
													}
													/*
													 * if(dgResultEntryDetail2.
													 * getSubInvestigation
													 * ().getSubInvestigationName
													 * (
													 * ).equalsIgnoreCase("Albumin"
													 * )){ resultAlbumin=
													 * dgResultEntryDetail2
													 * .getResult(); }
													 * if(dgResultEntryDetail2
													 * .getSubInvestigation
													 * ().getSubInvestigationName
													 * (
													 * ).equalsIgnoreCase("Globulin"
													 * )){ resultGlobulin=
													 * dgResultEntryDetail2
													 * .getResult(); }
													 */
													if (albumin != ""
															&& resultGlobulins != "") {
														agRatio = df
																.format((Double
																		.parseDouble(albumin) / Double
																		.parseDouble(resultGlobulins)));
													}
												}
												dgResultEntryDetailUpdate
														.setResult("" + agRatio);
											} else if (subInvstigationNameForRenal
													.equalsIgnoreCase("Blood Urea Nitrogen(BUN)")) {
												String resultBloodUreaNitroge = "";
												String blUreaResult = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"BL.UREA")) {
														blUreaResult = dgResultEntryDetail2
																.getResult();
													}

													if (blUreaResult != "") {
														resultBloodUreaNitroge = df
																.format((Double
																		.parseDouble(blUreaResult) / 2.14));
													}
												}
												dgResultEntryDetailUpdate
														.setResult(""
																+ resultBloodUreaNitroge);
											} else if (subInvstigationNameForRenal
													.equalsIgnoreCase("Globulin")) {
												String resultGlobulins = "";
												String total = "";
												String albumin = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"Total Proteins")) {
														total = dgResultEntryDetail2
																.getResult();
													}
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"Albumin")) {
														albumin = dgResultEntryDetail2
																.getResult();
													}
													/*
													 * if(dgResultEntryDetail2.
													 * getSubInvestigation
													 * ().getSubInvestigationName
													 * (
													 * ).equalsIgnoreCase("TOTAL"
													 * )){
													 * total=dgResultEntryDetail2
													 * .getResult(); }
													 * if(dgResultEntryDetail2
													 * .getSubInvestigation
													 * ().getSubInvestigationName
													 * (
													 * ).equalsIgnoreCase("ALBUMIN"
													 * )){
													 * albumin=dgResultEntryDetail2
													 * .getResult(); }
													 */
													if (total != ""
															&& albumin != "") {
														resultGlobulins = df
																.format((Double
																		.parseDouble(total) - Double
																		.parseDouble(albumin)));
													}
												}
												dgResultEntryDetailUpdate
														.setResult(""
																+ resultGlobulins);
											}
										}
										hbt.saveOrUpdate(dgResultEntryDetailUpdate);
										// RENAL FUNCTION TEST
									} else if (dgResultEntryDetail
											.getInvestigation()
											.getInvestigationName()
											.equalsIgnoreCase("SERUM PROTEINS")) {
										/**
										 * Code for SERUM PROTEINS Test
										 */
										/*
										 * A/G Ratio = Albumin/Globulines Sub
										 * Test No 2= Sub Test No 1/2.14 and
										 * also same for Gloulins and A/G Ratio
										 */

										if (dgResultEntryDetail
												.getSubInvestigation() != null) {
											subInvstigationNameForRenal = dgResultEntryDetail
													.getSubInvestigation()
													.getSubInvestigationName();

											if (subInvstigationNameForRenal
													.equalsIgnoreCase("A/G RATIO")) {
												String agRatio = "";
												String resultAlbumin = "";
												// String resultGlobulin="";

												String resultGlobulins = "";
												String total = "";
												String albumin = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {

													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"SERIUM TOTAL")) {
														total = dgResultEntryDetail2
																.getResult();
													}
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"ALBULIN")) {
														albumin = dgResultEntryDetail2
																.getResult();
													}
													if (total != ""
															&& albumin != "") {
														resultGlobulins = ""
																+ (Double
																		.parseDouble(total) - Double
																		.parseDouble(albumin));
													}

													if (albumin != ""
															&& resultGlobulins != "") {
														agRatio = df
																.format((Double
																		.parseDouble(albumin) / Double
																		.parseDouble(resultGlobulins)));
													}
												}
												dgResultEntryDetailUpdate
														.setResult("" + agRatio);
											} else if (subInvstigationNameForRenal
													.equalsIgnoreCase("GLOBULIN")) {
												String resultGlobulins = "";
												String total = "";
												String albumin = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"SERIUM TOTAL")) {
														total = dgResultEntryDetail2
																.getResult();
													}
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"ALBULIN")) {
														albumin = dgResultEntryDetail2
																.getResult();
													}

													if (total != ""
															&& albumin != "") {
														resultGlobulins = df
																.format((Double
																		.parseDouble(total) - Double
																		.parseDouble(albumin)));
													}
												}
												dgResultEntryDetailUpdate
														.setResult(""
																+ resultGlobulins);
											}
										}
										hbt.saveOrUpdate(dgResultEntryDetailUpdate);
										/*
										 * End Of ******SERUM PROTEINS *******
										 */
									} else if (dgResultEntryDetail
											.getInvestigation()
											.getInvestigationName()
											.equalsIgnoreCase("SERUM BILIRUBIN")) {
										/**
										 * Code for SERUM BILIRUBIN Test
										 */

										if (dgResultEntryDetail
												.getSubInvestigation() != null) {
											subInvstigationNameForLiver = dgResultEntryDetail
													.getSubInvestigation()
													.getSubInvestigationName();

											if (subInvstigationNameForLiver
													.equalsIgnoreCase("S.BILIRUBIN INDIRECT")) {
												String resultSBilirubinIndirect = "";
												String resultSBilirubinTotal = "";
												String resultSBilirubinDirect = "";
												for (DgResultEntryDetail dgResultEntryDetail2 : dgResultEntryDetailList) {
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"S.BILIRUBIN TOTAL")) {
														resultSBilirubinTotal = dgResultEntryDetail2
																.getResult();
													}
													if (dgResultEntryDetail2
															.getSubInvestigation()
															.getSubInvestigationName()
															.equalsIgnoreCase(
																	"S.BILIRUBIN DIRECT")) {
														resultSBilirubinDirect = dgResultEntryDetail2
																.getResult();
													}
													if (resultSBilirubinTotal != ""
															&& resultSBilirubinDirect != "") {
														resultSBilirubinIndirect = df
																.format((Double
																		.parseDouble(resultSBilirubinTotal) - Double
																		.parseDouble(resultSBilirubinDirect)));
													}
												}
												dgResultEntryDetailUpdate
														.setResult(""
																+ resultSBilirubinIndirect);
											}
										}

										hbt.saveOrUpdate(dgResultEntryDetailUpdate);
										/*
										 * End Of SERUM BILIRUBIN
										 */
									}

								}
							}
						}

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> getProvisionalReportDetailsOrderNoWiseLab(
			Map<String, Object> requestMap) {
		LOGGER.info("in getProvisionalReportDetailsOrderNoWiseLab");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Integer dgSampleHeaderId = 0;
		Integer subChargeId = 0;
		String resultStatus = "";

		Criteria crit = null;
		try {
			if (requestMap.get("dgSampleHeaderId") != null) {
				dgSampleHeaderId = (Integer) requestMap.get("dgSampleHeaderId");
			}
			if (requestMap.get("subChargeId") != null) {
				subChargeId = (Integer) requestMap.get("subChargeId");
			}
			if (requestMap.get("resultStatus") != null) {
				resultStatus = (String) requestMap.get("resultStatus");
			}

			Session session = (Session) getSession();
			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();

			if (dgSampleHeaderId != 0) {
				dgResultEntryHeaderByOrderNo = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.eq("SampleCollectionHeader.Id",
								dgSampleHeaderId))
						.add(Restrictions.eq("SubChargecode.Id", subChargeId))
						.add(Restrictions.eq("ResultStatus", resultStatus))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						.list();
			}
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				detailsMap.put("dgResultEntryHeaderByOrderNo",
						dgResultEntryHeaderByOrderNo);
			}
			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSens().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSens().iterator().next();
				}
			}

			if (flag) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getHin().getHinNo());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getHin();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				/*
				 * String sFullName = p.getSFirstName(); if(p.getSMiddleName()
				 * != null){ sFullName = sFullName + " " + p.getSMiddleName(); }
				 * if(p.getSLastName() != null){ sFullName = sFullName + " " +
				 * p.getSLastName(); } detailsMap.put("servicePersonName",
				 * sFullName);
				 */

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				// detailsMap.put("relationName",
				// p.getRelation().getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				// detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getRank() != null) {
						if (e1.getRank().getRankName() != null) {
							String entryPersonNameDesignation = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameDesignation",
									entryPersonNameDesignation);
						}
					}
					/*
					 * if(e1.getRank() != null){ if(e1.getRank().getRankName()
					 * != null){ String entryPersonNameRank =
					 * e1.getRank().getRankName();
					 * detailsMap.put("entryPersonNameRank",
					 * entryPersonNameRank); } }
					 */

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getRank() != null) {
						if (e2.getRank().getRankName() != null) {
							String verifiedPersonNameDesignation = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameDesignation",
									verifiedPersonNameDesignation);
						}
						if (e2.getRank() != null) {
							if (e2.getRank().getRankName() != null) {

								String verifiedPersonNameRank = e2.getRank()
										.getRankName();
								detailsMap.put("verifiedPersonNameRank",
										verifiedPersonNameRank);
							}
						}
					}
				}
			} else {
				detailsMap.put("hinNo", dgResultEntryDetailSenForData
						.getResultEntry().getHin().getHinNo());
				// detailsMap.put("serviceNo",
				// dgResultEntryDetailSenForData.getResultEntry().getHin().getServiceNo());
				// detailsMap.put("orderByDepartment",
				// dgResultEntryDetailSenForData.getResultEntry().getSampleCollectionHeader().getOrderByDepartment().getDepartmentName());
				Patient p1 = dgResultEntryDetailSenForData.getResultEntry()
						.getHin();
				String p1FullName = "";
				p1FullName = p1.getPFirstName();

				if (p1.getPMiddleName() != null) {
					p1FullName = p1FullName + " " + p1.getPMiddleName();
				}
				if (p1.getPLastName() != null) {
					p1FullName = p1FullName + " " + p1.getPLastName();
				}

				detailsMap.put("patientName", p1FullName);

				/*
				 * String s1FullName = p1.getSFirstName();
				 * if(p1.getSMiddleName() != null){ s1FullName = s1FullName +
				 * " " + p1.getSMiddleName(); } if(p1.getSLastName() != null){
				 * s1FullName = s1FullName + " " + p1.getSLastName(); }
				 * detailsMap.put("servicePersonName", sFullName);
				 */

				detailsMap.put("orderNo", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getOrderDate());
				// detailsMap.put("relationName",
				// p.getRelation().getRelationName());
				detailsMap.put("patientAge", p1.getAge());
				detailsMap.put("sex", p1.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailSenForData
						.getResultEntry().getResultDate());
				
				detailsMap.put("resulttime", dgResultEntryDetailSenForData
						.getResultEntry().getResultTime());
				// detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getSubChargecode().getSubChargecodeName());
				detailsMap.put("mainChargeCodeName",
						dgResultEntryDetailSenForData.getResultEntry()
								.getMainChargecode().getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailSenForData
						.getInvestigation().getInvestigationName());
				String clinicalNote1 = dgResultEntryDetailSenForData
						.getSampleCollection().getSampleCollectionHeader()
						.getOrder().getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote1);
				String confidential1 = dgResultEntryDetailSenForData
						.getInvestigation().getConfidential();
				if (confidential1 != null && !confidential1.equals("")
						&& !confidential1.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e4 = dgResultEntryDetailSenForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e4 != null) {

					if (e4.getFirstName() != null) {
						dFirst = e4.getFirstName();
					}
					if (e4.getMiddleName() != null) {
						dMiddleName = e4.getMiddleName();
					}
					if (e4.getLastName() != null) {
						dLastName = e4.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e3 = dgResultEntryDetailSenForData.getResultEntry()
						.getEmployee();
				if (e3 != null) {

					if (e3.getFirstName() != null) {
						eFirst = e3.getFirstName();
					}
					if (e3.getMiddleName() != null) {
						eMiddleName = e3.getMiddleName();
					}
					if (e3.getLastName() != null) {
						eLastName = e3.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
				}
				MasEmployee e5 = dgResultEntryDetailSenForData.getResultEntry()
						.getResultVerifiedBy();
				if (e5 != null) {

					if (e5.getFirstName() != null) {
						vFirst = e5.getFirstName();
					}
					if (e5.getMiddleName() != null) {
						vMiddleName = e5.getMiddleName();
					}
					if (e5.getLastName() != null) {
						vLastName = e5.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e5.getRank() != null) {
						if (e5.getRank().getRankName() != null) {

							String verifiedPersonNameDesignation = e5.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameDesignation",
									verifiedPersonNameDesignation);
						}
					}
					/*
					 * if(e5.getRank() != null){
					 * 
					 * if(e5.getRank().getRankName() != null){ String
					 * verifiedPersonNameRank = e5.getRank().getRankName();
					 * detailsMap.put("verifiedPersonNameRank",
					 * verifiedPersonNameRank); } }
					 */
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public boolean submitResultEntryForModificationTemplate(
			Map<String, Object> infoMap) {
		LOGGER.info("in submitResultEntryForModificationTemplate");
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		boolean successfullyAdded = false;
		Box box = null;

		String additionalRemarks = "";

		if (infoMap.get("box") != null) {
			box = (Box) infoMap.get("box");
		}

		int resultId = 0;
		if (infoMap.get("resultId") != null) {
			resultId = Integer.parseInt("" + infoMap.get("resultId"));
		}

		int resultEnteredBy = 0;
		if (infoMap.get("resultEnteredBy") != null) {
			resultEnteredBy = Integer.parseInt(""
					+ infoMap.get("resultEnteredBy"));
		}

		if (infoMap.get("additionalRemarks") != null) {
			additionalRemarks = (String) infoMap.get("additionalRemarks");
		}
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);

			DgResultEntryHeader dgEntryHeader = (DgResultEntryHeader) getHibernateTemplate()
					.load(DgResultEntryHeader.class, resultId);
			if (resultEnteredBy != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(resultEnteredBy);
				dgEntryHeader.setEmployee(masEmployee);
				dgEntryHeader.setResultVerifiedBy(masEmployee);
			}
			dgEntryHeader.setVerified("V");
			dgEntryHeader.setVerifiedOn(date);
			dgEntryHeader.setVerifiedTime(time);
			dgEntryHeader.setResultStatus("A");
			hbt.update(dgEntryHeader);

			Vector result = box.getVector("test2");
			/*
			 * Vector additionalRemarks =
			 * box.getVector(RequestConstants.ADDITIONAL_REMARKS); Vector
			 * validated = box.getVector(RequestConstants.VALIDATED);
			 */List<DgResultEntryDetail> dgResultDetailList = new ArrayList<DgResultEntryDetail>();
			DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
			dgResultDetailList = session
					.createCriteria(DgResultEntryDetail.class)
					.add(Restrictions.eq("ResultEntry.Id", resultId)).list();
			/*
			 * for (int i = 0; i< validated.size() ; i++) {
			 */
			if (dgResultDetailList != null && dgResultDetailList.size() > 0) {
				dgResultEntryDetail = dgResultDetailList.get(0);
				dgResultEntryDetail.setValidated("Y");
				dgResultEntryDetail.setResultDetailStatus("A");
				dgResultEntryDetail.setRemarks(additionalRemarks);
				// dgResultEntryDetail.setResult((String)result.get(i));

				hbt.saveOrUpdate(dgResultEntryDetail);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		}
		return successfullyAdded;
	}

	public Map<String, Object> getDetailsForFinalReportByOrderNoLab(
			Map<String, Object> requestMap) {
		LOGGER.info("in getDetailsForFinalReportByOrderNoLab");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String combinedIds = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		String resultId = "";
		String stringOfIds = "";
		String resultStatusRequired = "";
		String[] headerIdsValue = new String[0];
		String[] idsArray = new String[0];
		List<Integer> headerIdsInt = new ArrayList<Integer>();

		Integer dgSampleHeaderId = 0;
		Integer stringSubDeptIds = 0;

		if (requestMap.get("resultStatusRequired") != null) {
			resultStatusRequired = (String) requestMap
					.get("resultStatusRequired");
		}
		if (!resultStatusRequired.equals("")) {
			resultStatusRequired = "P";
		} else {
			resultStatusRequired = "A";
		}
		Criteria crit = null;
		try {
			if (requestMap.get("resultId") != null) {
				resultId = (String) requestMap.get("resultId");
				if (!resultId.equals("")) {
					idsArray = resultId.split("@");
					stringOfIds = idsArray[0];
					stringSubDeptIds = Integer.parseInt(idsArray[1]);

					headerIdsValue = stringOfIds.split(",");
					for (String id : headerIdsValue) {
						headerIdsInt.add(Integer.parseInt(id));
					}
				}
			}

			Session session = (Session) getSession();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();

			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();
			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();

			/* Get All Multiple Test Only */
			if (!resultId.equals("")) {
				dgResultEntryHeaderByOrderNo = session
						.createCriteria(DgResultEntryHeader.class)
						.add(Restrictions.in("Id", headerIdsInt))
						.add(Restrictions.eq("SubChargecode.Id",
								stringSubDeptIds))
						.add(Restrictions.eq("ResultStatus",
								resultStatusRequired))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						// .createAlias("DgMasInvestigation", "inv")
						// .addOrder(Order.asc("inv.TestOrderNo"))
						.list();
			}
			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSens().size() > 0) {
					int cnt = 1;
					for (DgResultEntryDetailSen sen : header
							.getDgResultEntryDetailSens()) {
						if (cnt == 1) {
							dgResultEntryDetailSenForData = sen;
							break;

						}
					}
				}
			}
			detailsMap.put("dgResultEntryHeaderByOrderNo",
					dgResultEntryHeaderByOrderNo);
			if (flag) {
				detailsMap.put("hinNo", dgResultEntryDetailForData
						.getResultEntry().getHin().getHinNo());
				// detailsMap.put("serviceNo",
				// dgResultEntryDetailForData.getResultEntry().getHin().getServiceNo());
				// detailsMap.put("orderByDepartment",
				// dgResultEntryDetailForData.getResultEntry().getSampleCollectionHeader().getOrderByDepartment().getDepartmentName());
				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getHin();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				/*
				 * String sFullName = p.getSFirstName(); if(p.getSMiddleName()
				 * != null){ sFullName = sFullName + " " + p.getSMiddleName(); }
				 * if(p.getSLastName() != null){ sFullName = sFullName + " " +
				 * p.getSLastName(); } detailsMap.put("servicePersonName",
				 * sFullName);
				 */

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				// /////// detailsMap.put("relationName",
				// p.getRelation().getRelationName());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				// ///// detailsMap.put("rankName", p.getRank().getRankName());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);

				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getRank() != null) {
						if (e1.getRank().getRankName() != null) {
							String entryPersonNameDesignation = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameDesignation",
									entryPersonNameDesignation);
						}
					}
					/*
					 * if(e1.getRank() != null){ if(e1.getRank().getRankName()
					 * != null){ String entryPersonNameRank =
					 * e1.getRank().getRankName();
					 * detailsMap.put("entryPersonNameRank",
					 * entryPersonNameRank); } }
					 */

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getRank() != null) {
						if (e2.getRank().getRankName() != null) {
							String verifiedPersonNameDesignation = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameDesignation",
									verifiedPersonNameDesignation);
						}
					}
					/*
					 * if(e2.getRank() != null){ if(e2.getRank().getRankName()
					 * != null){ String verifiedPersonNameRank =
					 * e2.getRank().getRankName();
					 * detailsMap.put("verifiedPersonNameRank",
					 * verifiedPersonNameRank); } }
					 */
				}
			} else {
				if (dgResultEntryDetailSenForData.getResultEntry() != null) {
					if (dgResultEntryDetailSenForData.getResultEntry().getHin() != null) {
						detailsMap.put("hinNo", dgResultEntryDetailSenForData
								.getResultEntry().getHin().getHinNo());
					}
					Patient p = dgResultEntryDetailSenForData.getResultEntry()
							.getHin();
					String pFullName = "";
					pFullName = p.getPFirstName();

					if (p.getPMiddleName() != null) {
						pFullName = pFullName + " " + p.getPMiddleName();
					}
					if (p.getPLastName() != null) {
						pFullName = pFullName + " " + p.getPLastName();
					}

					detailsMap.put("patientName", pFullName);

					String sFullName = "";
					// if(p.getSMiddleName() != null){
					// sFullName = sFullName + " " + p.getSMiddleName();
					// }
					// if(p.getSLastName() != null){
					// sFullName = sFullName + " " + p.getSLastName();
					// }
					// detailsMap.put("servicePersonName", sFullName);

					detailsMap.put("orderNo", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderNo());
					detailsMap.put("orderDate", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderDate());
					// detailsMap.put("relationName",
					// p.getRelation().getRelationName());
					detailsMap.put("patientAge", p.getAge());
					detailsMap
							.put("sex", p.getSex().getAdministrativeSexName());
					detailsMap.put("resultDate", dgResultEntryDetailSenForData
							.getResultEntry().getResultDate());
					// detailsMap.put("rankName", p.getRank().getRankName());
					detailsMap.put("subChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSubChargecode().getSubChargecodeName());
					detailsMap.put("mainChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getMainChargecode()
									.getMainChargecodeName());
					detailsMap.put("charge", dgResultEntryDetailSenForData
							.getInvestigation().getInvestigationName());
					String clinicalNote = dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getClinicalNote();
					detailsMap.put("clinicalNote", clinicalNote);
					String confidential = dgResultEntryDetailSenForData
							.getInvestigation().getConfidential();
					if (confidential != null && !confidential.equals("")
							&& !confidential.equalsIgnoreCase("n")) {
						detailsMap.put("confidential", "y");
					} else {
						detailsMap.put("confidential", "n");
					}

					MasEmployee e = dgResultEntryDetailSenForData
							.getResultEntry().getSampleCollectionHeader()
							.getOrder().getPrescribedBy();
					if (e != null) {

						if (e.getFirstName() != null) {
							dFirst = e.getFirstName();
						}
						if (e.getMiddleName() != null) {
							dMiddleName = e.getMiddleName();
						}
						if (e.getLastName() != null) {
							dLastName = e.getLastName();
						}
						detailsMap.put("doctorName", dFirst + " " + dMiddleName
								+ " " + dLastName);

					}

					MasEmployee e1 = dgResultEntryDetailSenForData
							.getResultEntry().getEmployee();
					if (e1 != null) {

						if (e1.getFirstName() != null) {
							eFirst = e1.getFirstName();
						}
						if (e1.getMiddleName() != null) {
							eMiddleName = e1.getMiddleName();
						}
						if (e1.getLastName() != null) {
							eLastName = e1.getLastName();
						}
						detailsMap.put("entryPersonName", eFirst + " "
								+ eMiddleName + " " + eLastName);

						/*
						 * if(e1.getRank() != null){
						 * if(e1.getRank().getRankName() != null){ String
						 * entryPersonNameDesignation =
						 * e1.getRank().getRankName() ;
						 * detailsMap.put("entryPersonNameDesignation",
						 * entryPersonNameDesignation); } }
						 */
						/*
						 * if(e1.getRank() != null){
						 * if(e1.getRank().getRankName() != null){ String
						 * entryPersonNameRank = e1.getRank().getRankName();
						 * detailsMap.put("entryPersonNameRank",
						 * entryPersonNameRank); } }
						 */

					}
					MasEmployee e2 = dgResultEntryDetailSenForData
							.getResultEntry().getResultVerifiedBy();
					if (e2 != null) {

						if (e2.getFirstName() != null) {
							vFirst = e2.getFirstName();
						}
						if (e2.getMiddleName() != null) {
							vMiddleName = e2.getMiddleName();
						}
						if (e2.getLastName() != null) {
							vLastName = e2.getLastName();
						}
						detailsMap.put("verifiedPersonName", vFirst + " "
								+ vMiddleName + " " + vLastName);

						/*
						 * if(e2.getRank() != null){
						 * if(e2.getRank().getRankName() != null){ String
						 * verifiedPersonNameDesignation
						 * =e2.getRank().getRankName();
						 * detailsMap.put("verifiedPersonNameDesignation",
						 * verifiedPersonNameDesignation); } } if(e2.getRank()
						 * != null){ if(e2.getRank().getRankName() != null){
						 * String verifiedPersonNameRank =
						 * e2.getRank().getRankName();
						 * detailsMap.put("verifiedPersonNameRank",
						 * verifiedPersonNameRank); } }
						 */
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> addSubTestWithoutAddingInMasInvestigation(
			Box box, Map<String, Object> dataMap) {
		LOGGER.info("in addSubTestWithoutAddingInMasInvestigation");
		Map<String, Object> map = new HashMap<String, Object>();
		boolean dataSaved = false;
		int multiTestSize = 0;
		multiTestSize = (Integer) dataMap.get("multiTestSize");
		Users users = (Users) dataMap.get(RequestConstants.USERS);
		int chargeCodeId = box.getInt(RequestConstants.CHARGE_CODE_ID);
		int mainChargeCodeId = box.getInt(RequestConstants.MAIN_CHARGECODE_ID);
		int subChargeId = box.getInt("subChargeCodeId");

		String userName = box.getString("userName");
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		Vector subTestName = box.getVector(RequestConstants.SUBTEST_NAME);
		Vector subTestCode = box.getVector(RequestConstants.SUBTEST_CODE);
		Vector resultType = box.getVector(RequestConstants.RESULT_TYPE);
		Vector orderNo = box.getVector(RequestConstants.ORDER_NO);
		Vector comparisonType = box.getVector(RequestConstants.COMPARISON_TYPE);
		Vector uomId = box.getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID);
		Vector sampleId = box.getVector(RequestConstants.SAMPLE_ID);

		List<DgMasInvestigation> dgMasInvestigationListForUpdateList = new ArrayList<DgMasInvestigation>();
		DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();

		if (dataMap.get("dgMasInvestigationListForUpdateList") != null
				&& ((List) dataMap.get("dgMasInvestigationListForUpdateList"))
						.size() > 0) {
			dgMasInvestigationListForUpdateList = (List) dataMap
					.get("dgMasInvestigationListForUpdateList");
			dgMasInvestigation = dgMasInvestigationListForUpdateList.get(0);
			dgMasInvestigation.setInvestigationType("m");
			dgMasInvestigation.setMultipleResults("y");
		}

		MasSubChargecode masSubChargecode = new MasSubChargecode();
		masSubChargecode.setId(subChargeId);

		MasChargeCode masChargeCode = new MasChargeCode();
		masChargeCode.setId(chargeCodeId);

		MasMainChargecode masMainChargecode = new MasMainChargecode();
		masMainChargecode.setId(mainChargeCodeId);

		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);

		List<DgSubMasInvestigation> subInvestigationlist = new ArrayList<DgSubMasInvestigation>();
		try {

			for (int i = 0; i < multiTestSize; i++) {
				if (orderNo.get(i) != null && !orderNo.get(i).equals("")) {
					DgSubMasInvestigation dgSubMasInvestigation = new DgSubMasInvestigation();
					dgSubMasInvestigation.setInvestigation(dgMasInvestigation);
					dgSubMasInvestigation
							.setSubInvestigationName((String) subTestName
									.get(i));
					dgSubMasInvestigation
							.setSubInvestigationCode((String) subTestCode
									.get(i));
					if (resultType.get(i) != null
							&& !resultType.get(i).equals("")) {
						dgSubMasInvestigation.setResultType((String) resultType
								.get(i));
					}
					dgSubMasInvestigation.setOrderNo(Integer
							.parseInt((String) orderNo.get(i)));
					if (comparisonType.get(i) != null
							&& !comparisonType.get(i).equals("")) {
						dgSubMasInvestigation
								.setComparisonType((String) comparisonType
										.get(i));
					}
					dgSubMasInvestigation.setStatus("y");
					dgSubMasInvestigation.setLastChgBy(users);
					dgSubMasInvestigation.setLastChgDate(date);
					dgSubMasInvestigation.setLastChgTime(time);
					dgSubMasInvestigation.setSubChargecode(masSubChargecode);
					dgSubMasInvestigation.setChargeCode(masChargeCode);
					dgSubMasInvestigation.setMainChargecode(masMainChargecode);

					// if(sampleId.get(i) != null &&
					// !sampleId.get(i).equals("")){
					// MasSample masSample = new MasSample();
					// masSample.setId(Integer.parseInt((String)sampleId.get(i)));
					// dgSubMasInvestigation.setSample(masSample);
					// }

					if (uomId.get(i) != null && !uomId.get(i).equals("")) {
						DgUom dgUom = new DgUom();
						dgUom.setId(Integer.parseInt((String) uomId.get(i)));
						dgSubMasInvestigation.setUom(dgUom);
					}

					hbt.save(dgSubMasInvestigation);
					map.put("dgSubMasInvestigation", dgSubMasInvestigation);
					subInvestigationlist.add(dgSubMasInvestigation);

				}
			}
			dataSaved = true;

		} catch (Exception e) {
			e.printStackTrace();
			dataSaved = false;
		}
		map.put("dataSaved", dataSaved);
		map.put("subInvestigationlist", subInvestigationlist);
		return map;
	}

	public Map<String, Object> getAllValidatedTestForLabOrderNoWise(
			Map<String, Object> requestMap) {
		LOGGER.info("in getAllValidatedTestForLabOrderNoWise");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Integer orderNo = 0;
		int hospitalId = 0;
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String[]> subChargeCodeGroup = new ArrayList<String[]>();

		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Criteria crit = null;
		try {
			if (requestMap.get("orderNo") != null) {
				orderNo = Integer.parseInt((String) requestMap.get("orderNo"));
			}
			if (requestMap.get(HOSPITAL_ID) != null) {
				hospitalId = Integer.parseInt(requestMap.get(HOSPITAL_ID).toString());
			}
			Session session = (Session) getSession();

			List<DgOrderhd> hdList = new ArrayList<DgOrderhd>();
			hdList = session.createCriteria(DgOrderhd.class)
					.add(Restrictions.eq("Id", orderNo)).list();
			List<DgOrderhd> dtList = new ArrayList<DgOrderhd>();

			List<DgResultEntryHeader> dgResultEntryHeaderByOrderNo = new ArrayList<DgResultEntryHeader>();
			if (!orderNo.equals("")) {
				dgResultEntryHeaderByOrderNo = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.Id", orderNo))
						.add(Restrictions.eq("Verified", "V").ignoreCase())
						/*
						 * .add(Restrictions.or( Restrictions.eq(
						 * "ResultStatus", "R"), Restrictions.eq(
						 * "ResultStatus", "R") )
						 */
						// .add(Restrictions.eq("ResultStatus", "R"))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						// .createAlias("DgMasInvestigation", "inv")
						// .addOrder(Order.asc("inv.TestOrderNo"))
						// .createAlias("DgResultEntryDetails", "reDtl")
						// .createAlias("reDtl.Investigation", "invest")
						// .add(Restrictions.eq("invest.InvestigationType",
						// "m"))
						.addOrder(Order.asc("Id")).list();
			}
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryHeader.class)
						.createAlias("SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.Id", orderNo))
						.add(Restrictions.eq("Verified", "V").ignoreCase())
						/*
						 * .add(Restrictions.or( Restrictions.eq(
						 * "ResultStatus", "A"), Restrictions.eq(
						 * "ResultStatus", "R") ))
						 */
						// .add(Restrictions.eq("ResultStatus", "R"))
						.createAlias("MainChargecode", "mcc")
						.add(Restrictions.eq("mcc.MainChargecodeCode", "LAB"))
						.createAlias("SubChargecode", "subCharg")
						.createAlias("Investigation", "inv")
						.createAlias("inv.Sample", "sample")
						
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
												.property("subCharg.SubChargecodeName"))
												.add(Projections.property("sample.SampleDescription"))));

				subChargeCodeGroup = crit.list();
			}

			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);

			DgResultEntryDetail dgResultEntryDetailForData = new DgResultEntryDetail();
			DgResultEntryDetailSen dgResultEntryDetailSenForData = new DgResultEntryDetailSen();

			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				detailsMap.put("dgResultEntryHeaderByOrderNo",
						dgResultEntryHeaderByOrderNo);

			}

			boolean flag = false;
			if (dgResultEntryHeaderByOrderNo.size() > 0) {
				DgResultEntryHeader header = dgResultEntryHeaderByOrderNo
						.get(0);
				if (header.getDgResultEntryDetails().size() > 0) {
					flag = true;
					dgResultEntryDetailForData = header
							.getDgResultEntryDetails().iterator().next();
				} else if (header.getDgResultEntryDetailSens().size() > 0) {
					dgResultEntryDetailSenForData = header
							.getDgResultEntryDetailSens().iterator().next();
				}
			}
			if (flag) {
				if (dgResultEntryDetailForData.getResultEntry().getHin() != null) {
					detailsMap.put("hinNo", dgResultEntryDetailForData
							.getResultEntry().getHin().getHinNo());
				}

				detailsMap.put("orderByDepartment", dgResultEntryDetailForData
						.getResultEntry().getSampleCollectionHeader()
						.getOrder().getDepartment().getDepartmentName());
				/*
				 * detailsMap.put("departmentType",session.getAttribute("deptId")
				 * );
				 */

				Patient p = dgResultEntryDetailForData.getResultEntry()
						.getHin();
				String pFullName = "";
				pFullName = p.getPFirstName();

				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}

				detailsMap.put("patientName", pFullName);

				detailsMap.put("orderNo", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());

				detailsMap.put("patientStatus", p.getPatientStatus());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultEntryDetailForData
						.getResultEntry().getResultDate());
				detailsMap.put("subChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());
				detailsMap.put("mainChargeCodeName", dgResultEntryDetailForData
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());
				detailsMap.put("charge", dgResultEntryDetailForData
						.getInvestigation().getInvestigationName());
				String clinicalNote = dgResultEntryDetailForData
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();
				detailsMap.put("clinicalNote", clinicalNote);
				String confidential = dgResultEntryDetailForData
						.getInvestigation().getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultEntryDetailForData.getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();
				if (e != null) {

					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}
					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultEntryDetailForData.getResultEntry()
						.getEmployee();
				if (e1 != null) {

					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);
					if (e1.getRank() != null) {
						String entryPersonNameDesignation = e1.getRank()
								.getRankName();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}
					if (e1.getRank() != null) {
						String entryPersonNameRank = e1.getRank().getRankName();
						detailsMap.put("entryPersonNameRank",
								entryPersonNameRank);

					}

				}
				MasEmployee e2 = dgResultEntryDetailForData.getResultEntry()
						.getResultVerifiedBy();
				if (e2 != null) {

					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}
					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}
					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}
					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);
					if (e2.getRank() != null) {
						String verifiedPersonNameDesignation = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}
					if (e2.getRank() != null) {
						String verifiedPersonNameRank = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameRank",
								verifiedPersonNameRank);
					}

				}
			} else {
				if (dgResultEntryDetailSenForData.getResultEntry() != null) {
					if (dgResultEntryDetailSenForData.getResultEntry().getHin() != null) {
						detailsMap.put("hinNo", dgResultEntryDetailSenForData
								.getResultEntry().getHin().getHinNo());
					}

					detailsMap.put("orderByDepartment",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSampleCollectionHeader().getOrder()
									.getDepartment().getDepartmentName());

					Patient p = dgResultEntryDetailSenForData.getResultEntry()
							.getHin();
					String pFullName = "";
					pFullName = p.getPFirstName();

					if (p.getPMiddleName() != null) {
						pFullName = pFullName + " " + p.getPMiddleName();
					}
					if (p.getPLastName() != null) {
						pFullName = pFullName + " " + p.getPLastName();
					}

					detailsMap.put("patientName", pFullName);
					detailsMap.put("orderNo", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderNo());
					detailsMap.put("orderDate", dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getOrderDate());

					detailsMap.put("patientAge", p.getAge());
					detailsMap
							.put("sex", p.getSex().getAdministrativeSexName());
					detailsMap.put("resultDate", dgResultEntryDetailSenForData
							.getResultEntry().getResultDate());
					detailsMap.put("subChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getSubChargecode().getSubChargecodeName());
					detailsMap.put("mainChargeCodeName",
							dgResultEntryDetailSenForData.getResultEntry()
									.getMainChargecode()
									.getMainChargecodeName());
					detailsMap.put("charge", dgResultEntryDetailSenForData
							.getInvestigation().getInvestigationName());
					String clinicalNote = dgResultEntryDetailSenForData
							.getSampleCollection().getSampleCollectionHeader()
							.getOrder().getClinicalNote();
					detailsMap.put("clinicalNote", clinicalNote);
					String confidential = dgResultEntryDetailSenForData
							.getInvestigation().getConfidential();
					if (confidential != null && !confidential.equals("")
							&& !confidential.equalsIgnoreCase("n")) {
						detailsMap.put("confidential", "y");
					} else {
						detailsMap.put("confidential", "n");
					}

					MasEmployee e = dgResultEntryDetailSenForData
							.getResultEntry().getSampleCollectionHeader()
							.getOrder().getPrescribedBy();
					if (e != null) {

						if (e.getFirstName() != null) {
							dFirst = e.getFirstName();
						}
						if (e.getMiddleName() != null) {
							dMiddleName = e.getMiddleName();
						}
						if (e.getLastName() != null) {
							dLastName = e.getLastName();
						}
						detailsMap.put("doctorName", dFirst + " " + dMiddleName
								+ " " + dLastName);
					}

					MasEmployee e1 = dgResultEntryDetailSenForData
							.getResultEntry().getEmployee();
					if (e1 != null) {

						if (e1.getFirstName() != null) {
							eFirst = e1.getFirstName();
						}
						if (e1.getMiddleName() != null) {
							eMiddleName = e1.getMiddleName();
						}
						if (e1.getLastName() != null) {
							eLastName = e1.getLastName();
						}
						detailsMap.put("entryPersonName", eFirst + " "
								+ eMiddleName + " " + eLastName);
						if (e1.getRank() != null) {
							String entryPersonNameDesignation = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameDesignation",
									entryPersonNameDesignation);
						}
						if (e1.getRank() != null) {
							String entryPersonNameRank = e1.getRank()
									.getRankName();
							detailsMap.put("entryPersonNameRank",
									entryPersonNameRank);

						}

					}
					MasEmployee e2 = dgResultEntryDetailSenForData
							.getResultEntry().getResultVerifiedBy();
					if (e2 != null) {

						if (e2.getFirstName() != null) {
							vFirst = e2.getFirstName();
						}
						if (e2.getMiddleName() != null) {
							vMiddleName = e2.getMiddleName();
						}
						if (e2.getLastName() != null) {
							vLastName = e2.getLastName();
						}
						detailsMap.put("verifiedPersonName", vFirst + " "
								+ vMiddleName + " " + vLastName);
						if (e2.getRank() != null) {
							String verifiedPersonNameDesignation = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameDesignation",
									verifiedPersonNameDesignation);
						}
						if (e2.getRank() != null) {
							String verifiedPersonNameRank = e2.getRank()
									.getRankName();
							detailsMap.put("verifiedPersonNameRank",
									verifiedPersonNameRank);
						}
					}
				}
			}
			
			String query = "select sub_investigation_code,p.age,p.hin_no,(coalesce(p.p_first_name,' ')||'  '||coalesce(p.p_middle_name,' ')||'  '||coalesce(p.p_last_name,' ')) as "
					+ "patient_name,dgo.hin_id,dgo.order_no,dgo.order_date,case When dgo.patient_type='OP'Then'Out Patient' Else 'In Patient' end patient_type,mmcc.main_chargecode_name,mscc.sub_chargecode_name,mscc.sub_chargecode_code, "
					+ "dreh.remarks as header_remarks,dred.remarks as details_remarks, "
					+ "case when dmi.investigation_type='m' then dmi.investigation_name else '' end investigation_name, "
					+ "coalesce(dmi.min_normal_value||'-'||dmi.max_normal_value,dmi.normal_value) as normal_range, "

					+ "coalesce(dsmi.sub_investigation_name,dmi.investigation_name) as "
					+ "sub_investigation_name,dreh.result_date,dreh.result_time,dred.result,(me.first_name||'  '||coalesce(me.middle_name,'')||'  '||coalesce(me.last_name,'')) as emp_name, "
					+ "(me1.first_name||'  '||coalesce(me1.middle_name,' ')||'  '||coalesce(me1.last_name,' ')) as pre_emp_name, "
					+ "mh.address as address,s.administrative_sex_name,d.department_name,"
					+ "mh.hospital_name,dmi.min_normal_value , dmi.max_normal_value,uom.uom_name,"
					+ "sample.sample_description,ssch.diag_no,ssch.sample_coll_datetime,dsch.diagnosis_date, "
					+ " pr.rank_name as pr,vr.rank_name as vr, "
					+ "case when p.patient_status='Out Patient' then 'OP' "
					+ "when p.patient_status='In Patient' then 'IP' else '-' end as patient_status,"
					+" case when dmi.investigation_type = 'm' then (select coalesce(dnv.min_normal_value,' ')||'-'||coalesce(dnv.max_normal_value,' ')) "
					 
					+ " else coalesce(dmi.min_normal_value||'-'||dmi.max_normal_value,dmi.normal_value)  end as normal_range123, "
					+ "(me1.first_name||'  '||coalesce(me1.middle_name,' ')||'  '||coalesce(me1.last_name,' ')) as validate_by ,vr.rank_name as vb, dsmi.result_type, dsch.diagnosis_time, dsch.sample_validation_time "
					+ " from dg_result_entry_header dreh "
					+ "left outer join dg_result_entry_detail dred on dreh.result_entry_id=dred.result_entry_id "
					+" left outer join dg_sample_collection_details ssch on dred.sample_collection_details_id=ssch.sample_collection_details_id "
					+ " left outer join dg_sample_collection_header dsch on ssch.sample_collection_header_id=dsch.sample_collection_header_id "
					//+ "left outer join dg_sample_collection_header dsch on dreh.sample_collection_header_id=dsch.sample_collection_header_id "
					//+" left outer join dg_sample_collection_details ssch on dsch.sample_collection_header_id=ssch.sample_collection_header_id "
					+ "left outer join dg_orderhd dgo on dsch.order_id=dgo.orderhd_id "
					+ "left outer join mas_main_chargecode mmcc on mmcc.main_chargecode_id=dreh.main_chargecode_id "
					+ "left outer join mas_sub_chargecode mscc on mscc.sub_chargecode_id=dreh.sub_chargecode_id "
					+ "left outer join dg_mas_investigation dmi on dred.investigation_id=dmi.investigation_id "
					+ "left outer join dg_sub_mas_investigation dsmi on dred.sub_investigation_id=dsmi.sub_investigation_id "
					+ "left outer join patient p on p.hin_id=dgo.hin_id "
					+ "left outer join dg_uom uom on uom.uom_id= (case when dmi.investigation_type = 's' then dmi.uom_id else dsmi.uom_id end) "
					+ "left outer join mas_administrative_sex s on s.administrative_sex_id=p.sex_id "
					+ "left outer join mas_department d on d.department_id=dgo.department_id "
					+ "left outer join mas_employee me on dsch.validated_by=me.employee_id "
					+ "left outer join mas_hospital mh on dreh.hospital_id=mh.hospital_id "
					+ "left outer join mas_sample sample on dmi.sample_id=sample.sample_id "
					+ "left outer join mas_employee me1 on dreh.result_verified_by=me1.employee_id "
					+ "left outer join mas_rank pr on pr.rank_id=me1.rank_id "
					+ "left outer join mas_rank vr on vr.rank_id=me.rank_id "
					+ "left outer join dg_normal_value dnv on dsmi.sub_investigation_id =dnv.sub_investigation_id"
					+" and  dnv.sex<>'c' and (case when dnv.sex='m' or dnv.sex='f' then s.administrative_sex_code =upper(dnv.sex) else 1=1 end )"//added by govind 24-12-2016
					
					+ "where dgo.orderhd_id="+orderNo+" and dgo.hospital_id='"+hospitalId+"' and dred.validated ='V' and  dreh.verified='V'  and (dred.result is not null and dred.result<>'' and (case when dred.result='0' then (cast(dred.result as integer))>0 else 1=1 end))"
					+ "group by sub_investigation_name,sub_investigation_code,p.age,p.hin_no,p.patient_status,dsmi.sub_investigation_id,"
					+" sub_investigation_code,p.age,p.hin_no,p.p_first_name,p.p_middle_name,p.p_last_name,"
					+" patient_name,dgo.hin_id,dgo.order_no,dgo.order_date,dgo.patient_type,"
					+" mmcc.main_chargecode_name,mscc.sub_chargecode_name,"
					+" dreh.remarks,dred.remarks,"
					+" dmi.investigation_name,me.emp_name,me1.emp_name,"
					+" dmi.min_normal_value,dmi.max_normal_value,dmi.normal_value,"
					+" dsmi.sub_investigation_name,dmi.investigation_name,"
					+" sub_investigation_name,dreh.result_date,dreh.result_time,dred.result,"
					+" me.first_name,me.middle_name,me.last_name,"
					+" me1.first_name,me1.middle_name,me1.last_name,pre_emp_name,"
					+" mh.address,s.administrative_sex_name,d.department_name,"
					+" mh.hospital_name,dmi.min_normal_value , dmi.max_normal_value,uom.uom_name,"
					+" sample.sample_description,ssch.diag_no,mscc.sub_chargecode_code,"
					+" dsch.diagnosis_date,pr.rank_name,vr.rank_name,ssch.sample_coll_datetime,dmi.investigation_type,dnv.min_normal_value,dnv.max_normal_value,"
					//+" me1.first_name,me1.middle_name,me1.last_name,vr.rank_name,dsmi.result_type,dsmi.order_no,dmi.investigation_type ORDER BY MAX(mscc.sub_chargecode_name)";//added by govind 24-12-2016
			        +" me1.first_name,me1.middle_name,me1.last_name,vr.rank_name,dsmi.result_type,dsmi.order_no,dmi.investigation_type ,dsch.diagnosis_time,dsch.sample_validation_time ORDER BY dsmi.order_no,investigation_name";
		/*String query1="select sub_investigation_code,p.age,p.hin_no,(coalesce(p.p_first_name,' ')||'  '||coalesce(p.p_middle_name,' ')||'  '||coalesce(p.p_last_name,' ')) as patient_name,dgo.hin_id,dgo.order_no,dgo.order_date,case When dgo.patient_type='OP'Then'Out Patient' Else 'In Patient' end patient_type,mmcc.main_chargecode_name,mscc.sub_chargecode_name,mscc.sub_chargecode_code,"
				+ "dreh.remarks as header_remarks,dred.remarks as details_remarks,"
				+ "case when dmi.investigation_type='m' then dmi.investigation_name else '' end investigation_name,coalesce(dsmi.sub_investigation_name,dmi.investigation_name) as "
				+ "sub_investigation_name,dreh.result_date,dreh.result_time,dred.result,(me.first_name||'  '||coalesce(me.middle_name,'')||'  '||coalesce(me.last_name,'')) as emp_name,"
				+ "(me1.first_name||'  '||coalesce(me1.middle_name,' ')||'  '||coalesce(me1.last_name,' ')) as pre_emp_name,"
				+ "mh.address as address,s.administrative_sex_name,d.department_name,"
				+ "mh.hospital_name,dmi.min_normal_value , dmi.max_normal_value,uom.uom_name,"
				+ "coalesce(sample.sample_description,'-') as sample_description,ssch.diag_no,ssch.sample_coll_datetime,"
				+ "dsch.diagnosis_date,pr.rank_name as pr,vr.rank_name as vr,"
				+ "case when p.patient_status='Out Patient' then 'OP' "
				+ "when p.patient_status='In Patient' then 'IP' else '-' end as patient_status,case when dmi.investigation_type = 'm' then ( (select coalesce(min_normal_value,' ')||'-'||coalesce(max_normal_value,' ') from dg_normal_value "
				+ "where sub_investigation_id=dsmi.sub_investigation_id) ) else coalesce(dmi.min_normal_value||'-'||dmi.max_normal_value,dmi.normal_value)  end as normal_range"
				+ "from dg_result_entry_header dreh"
				+ "left outer join dg_result_entry_detail dred on dreh.result_entry_id=dred.result_entry_id"
				+ "left outer join dg_sample_collection_details ssch on dred.sample_collection_details_id=ssch.sample_collection_details_id "
				+ "left outer join dg_sample_collection_header dsch on ssch.sample_collection_header_id=dsch.sample_collection_header_id"
				+ "left outer join dg_orderhd dgo on dsch.order_id=dgo.orderhd_id"
				+ "left outer join mas_main_chargecode mmcc on mmcc.main_chargecode_id=dreh.main_chargecode_id"
				+ "left outer join mas_sub_chargecode mscc on mscc.sub_chargecode_id=dreh.sub_chargecode_id"
				+ "left outer join dg_mas_investigation dmi on dred.investigation_id=dmi.investigation_id"
				+ "left outer join dg_sub_mas_investigation dsmi on dred.sub_investigation_id=dsmi.sub_investigation_id"
				+ "left outer join patient p on p.hin_id=dgo.hin_id "
				+ "left outer join dg_uom uom on uom.uom_id= (case when dmi.investigation_type = 's' then ( dmi.uom_id) else dsmi.uom_id end)"
				+ "left outer join mas_administrative_sex s on s.administrative_sex_id=p.sex_id"
				+ "left outer join mas_department d on d.department_id=dgo.department_id"
				+ "left outer join mas_employee me on dreh.result_verified_by=me.employee_id"
				+ "left outer join mas_hospital mh on dreh.hospital_id=mh.hospital_id"
				+ "left outer join mas_sample sample on dmi.sample_id=sample.sample_id"
				+ "left outer join mas_employee me1 on dgo.prescribed_by=me1.employee_id"
				+ "left outer join mas_rank pr on pr.rank_id=me1.rank_id"
				+ "left outer join mas_rank vr on vr.rank_id=me.rank_id"
				+ "where dgo.order_no='"+orderNo+"' and dgo.hospital_id='"+hospitalId+"' and dred.validated='V' "
				+ "and dreh.verified='V' "
				+ "group by sub_investigation_name,sub_investigation_code,p.age,p.hin_no,p.patient_status,dsmi.sub_investigation_id,"
				+ "sub_investigation_code,p.age,p.hin_no,p.p_first_name,p.p_middle_name,p.p_last_name,"
				+ "patient_name,dgo.hin_id,dgo.order_no,dgo.order_date,dgo.patient_type,"
				+ "mmcc.main_chargecode_name,mscc.sub_chargecode_name,dreh.remarks,dred.remarks,dmi.investigation_name,me.emp_name,me1.emp_name,dmi.min_normal_value,dmi.max_normal_value,dmi.normal_value,"
				+ "dsmi.sub_investigation_name,dmi.investigation_name,sub_investigation_name,dreh.result_date,dreh.result_time,dred.result,me.first_name,me.middle_name,me.last_name,"
				+ "me1.first_name,me1.middle_name,me1.last_name,pre_emp_name,mh.address,s.administrative_sex_name,d.department_name,"
				+ "mh.hospital_name,dmi.min_normal_value , dmi.max_normal_value,uom.uom_name,sample.sample_description,ssch.diag_no,mscc.sub_chargecode_code,"
				+ "dsch.diagnosis_date,pr.rank_name,vr.rank_name,ssch.sample_coll_datetime,dmi.investigation_type ORDER BY MAX(mscc.sub_chargecode_name)";*/
			
		List<Object[]> invReportdata=session.createSQLQuery(query).list();
		
		
			
			Map<String,List<Object[]>> reportDataMap=new HashMap<String,List<Object[]>>();
			for(Object[] obj:subChargeCodeGroup){
				List<Object[]> mainList=new ArrayList<Object[]>();
				
				for(Object[] invData:invReportdata){
					
					if((obj[0]+"").equalsIgnoreCase(invData[9]+"") 
							&& (obj[1]+"").equalsIgnoreCase(invData[28]+"") ){
						mainList.add(invData);
					}
					
				}
				if(mainList.size()>0){
					reportDataMap.put(obj[0]+""+obj[1], mainList);
				}
			}
			
			/*for(Object[] obj:subChargeCodeGroup){
				List<Object[]> abc=new ArrayList<Object[]>();
				abc=reportDataMap.get(obj[0]+""+obj[1]);
				for(Object[] o:abc){
					System.out.println("Test Name "+o[14]);
				}
			}*/
			
			detailsMap.put("reportDataMap", reportDataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return detailsMap;
	}

	public Map<String, Object> getAllValidatedTestForOrder(
			Map<String, Object> requestMap) {
		LOGGER.info("in getAllValidatedTestForOrder");
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String orderNo = "";
		List objectList = new ArrayList();
		List<DgOrgDtl> dgOrgDtlList = new ArrayList<DgOrgDtl>();
		List<String> subChargeCodeGroup = new ArrayList<String>();
		String dFirst = "";
		String dMiddleName = "";
		String dLastName = "";
		String eFirst = "";
		String eMiddleName = "";
		String eLastName = "";
		String vFirst = "";
		String vMiddleName = "";
		String vLastName = "";
		Criteria crit = null;
		try {
			if (requestMap.get("orderNo") != null) {
				orderNo = (String) requestMap.get("orderNo");
			}
			Session session = (Session) getSession();
			List<DgResultEntryDetail> dgResultdetailList = new ArrayList<DgResultEntryDetail>();
			if (!orderNo.equals("")) {
				dgResultdetailList = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "re")
						.createAlias("re.SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "A"))
						//.createAlias("re.MainChargecode", "mcc")
						//.add(Restrictions.eq("mcc.MainChargecodeCode","XRAY"))
						.list();
			}
			if (!orderNo.equals("")) {
				crit = session
						.createCriteria(DgResultEntryDetail.class)
						.createAlias("ResultEntry", "re")
						.createAlias("re.SampleCollectionHeader", "sch")
						.createAlias("sch.Order", "orderN")
						.add(Restrictions.eq("orderN.OrderNo", orderNo))
						.add(Restrictions.eq("ResultDetailStatus", "A"))
					//	.createAlias("re.MainChargecode", "mcc")
					//	.add(Restrictions.eq("mcc.MainChargecodeCode", "XRAY"))
						.createAlias("Investigation", "inv")
						.createAlias("inv.SubChargecode", "subCharg")
						.setProjection(
								Projections.distinct(Projections
										.projectionList()
										.add(Projections
												.property("subCharg.SubChargecodeName"))));
				// .setProjection(Projections.property("scc.SubChargecodeName"));
				subChargeCodeGroup = crit.list();
			}

			/*
			 * 
			 * if(!orderNo.equals("")){ crit =
			 * 
			 * session.createCriteria(DgOrderdt.class) .createAlias("Orderhd",
			 * 
			 * "oNo") .add(Restrictions.eq("oNo.OrderNo", orderNo))
			 * 
			 * .createAlias("SubChargeid", "scc")
			 * 
			 * //.setProjection(Projections.groupProperty
			 * 
			 * ("scc.SubChargecodeName"))
			 * 
			 * .setProjection(Projections.distinct(Projections
			 * 
			 * .projectionList().
			 * 
			 * add(Projections.property("scc.SubChargecodeName"))));
			 * 
			 * //.setProjection(Projections.property("scc.SubChargecodeName"));
			 * 
			 * subChargeCodeGroup = crit.list(); }
			 */
			LOGGER.info(subChargeCodeGroup.size()+"subChargeCodeGroupsubChargeCodeGroup");
			LOGGER.info(dgResultdetailList.size()+"dgResultdetailListdgResultdetailList");
			detailsMap.put("subChargeCodeGroup", subChargeCodeGroup);
			if (dgResultdetailList != null && dgResultdetailList.size() > 0) {
				// detailsMap.put("dgResultdetailList", dgResultdetailList);
				detailsMap.put("dgResultdetailList", dgResultdetailList);
				detailsMap.put("hinNo", dgResultdetailList.get(0)
						.getResultEntry().getHin().getHinNo());
				detailsMap.put("serviceNo", dgResultdetailList.get(0)
						.getResultEntry().getHin().getServiceNo());
				detailsMap.put("orderByDepartment", dgResultdetailList.get(0)
						.getResultEntry().getSampleCollectionHeader()
						.getOrder().getDepartment().getDepartmentName());
				Patient p = dgResultdetailList.get(0).getResultEntry().getHin();
				String prefix = "";
				prefix = p.getPrefix();
				detailsMap.put("prefix", prefix);
				String suffix = "";
				suffix = p.getSuffix();
				detailsMap.put("suffix", suffix);
				String pFullName = "";
				pFullName = p.getPFirstName();
				if (p.getPMiddleName() != null) {
					pFullName = pFullName + " " + p.getPMiddleName();
				}
				if (p.getPLastName() != null) {
					pFullName = pFullName + " " + p.getPLastName();
				}
				detailsMap.put("patientName", pFullName);
				String sFullName = p.getSFirstName();
				if (p.getSMiddleName() != null) {
					sFullName = sFullName + " " + p.getSMiddleName();
				}
				if (p.getSLastName() != null) {
					sFullName = sFullName + " " + p.getSLastName();
				}
				detailsMap.put("servicePersonName", sFullName);
				detailsMap.put("orderNo", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderNo());
				detailsMap.put("orderDate", dgResultdetailList.get(0)
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder().getOrderDate());
				detailsMap.put("adNo", p.getHinNo());
				detailsMap.put("patientAge", p.getAge());
				detailsMap.put("sex", p.getSex().getAdministrativeSexName());
				detailsMap.put("resultDate", dgResultdetailList.get(0)
						.getResultEntry().getResultDate());
				detailsMap.put("subChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getSubChargecode()
						.getSubChargecodeName());

				detailsMap.put("mainChargeCodeName", dgResultdetailList.get(0)
						.getResultEntry().getMainChargecode()
						.getMainChargecodeName());

				detailsMap.put("charge", dgResultdetailList.get(0)
						.getInvestigation().getInvestigationName());

				DgResultEntryDetail dgResultEntryDetail = dgResultdetailList
						.get(0);
				String clinicalNotes = dgResultEntryDetail
						.getSampleCollectionDetails()
						.getSampleCollectionHeader().getOrder()
						.getClinicalNote();

				detailsMap.put("clinicalNotes", clinicalNotes);
				String radioId = dgResultEntryDetail
						.getSampleCollectionDetails().getDiagNo();

				detailsMap.put("radioId", radioId);

				String confidential = dgResultEntryDetail.getInvestigation()
						.getConfidential();
				if (confidential != null && !confidential.equals("")
						&& !confidential.equalsIgnoreCase("n")) {
					detailsMap.put("confidential", "y");
				} else {
					detailsMap.put("confidential", "n");
				}

				MasEmployee e = dgResultdetailList.get(0).getResultEntry()
						.getSampleCollectionHeader().getOrder()
						.getPrescribedBy();

				if (e != null) {
					if (e.getFirstName() != null) {
						dFirst = e.getFirstName();
					}

					if (e.getMiddleName() != null) {
						dMiddleName = e.getMiddleName();
					}
					if (e.getLastName() != null) {
						dLastName = e.getLastName();
					}
					detailsMap.put("doctorName", dFirst + " " + dMiddleName
							+ " " + dLastName);
				}

				MasEmployee e1 = dgResultdetailList.get(0).getResultEntry()
						.getEmployee();

				if (e1 != null) {
					if (e1.getFirstName() != null) {
						eFirst = e1.getFirstName();
					}
					if (e1.getMiddleName() != null) {
						eMiddleName = e1.getMiddleName();
					}
					if (e1.getLastName() != null) {
						eLastName = e1.getLastName();
					}
					detailsMap.put("entryPersonName", eFirst + " "
							+ eMiddleName + " " + eLastName);

					if (e1.getRank() != null) {
						String entryPersonNameDesignation = e1.getRank()
								.getRankName();
						detailsMap.put("entryPersonNameDesignation",
								entryPersonNameDesignation);
					}

				}

				MasEmployee e2 = dgResultdetailList.get(0).getResultEntry()
						.getResultVerifiedBy();

				if (e2 != null) {
					if (e2.getFirstName() != null) {
						vFirst = e2.getFirstName();
					}

					if (e2.getMiddleName() != null) {
						vMiddleName = e2.getMiddleName();
					}

					if (e2.getLastName() != null) {
						vLastName = e2.getLastName();
					}

					detailsMap.put("verifiedPersonName", vFirst + " "
							+ vMiddleName + " " + vLastName);

					if (e2.getRank() != null) {
						String verifiedPersonNameDesignation = e2.getRank()
								.getRankName();
						detailsMap.put("verifiedPersonNameDesignation",
								verifiedPersonNameDesignation);
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return detailsMap;
	}

	public Map<String, Object> showLioncSubClassJsp(Box box) {
		LOGGER.info("in showLioncSubClassJsp");
		String deptType = "";
		int deptId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if (box.get("deptType") != null) {
			deptType = ("" + box.get("deptType"));
		}
		String str = "";
		if (map.get("autoHint") != null) {
			str = map.get("autoHint") + "%";
		}

		if (box.getInt("deptId") != 0) {
			deptId = box.getInt("deptId");
		}
		Session session = (Session) getSession();
		List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasLioncSubClass> masLioncSubClassList = new ArrayList<MasLioncSubClass>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();

		List lst = new ArrayList();

		// masLioncSubClassList =
		// getHibernateTemplate().find("from jkt.hms.masters.business.MasLioncSubClass");
		masLioncSubClassList = session.createCriteria(MasLioncSubClass.class)
				.list();
		// masLioncSubClassList
		// =session.createCriteria(MasLioncSubClass.class).list();

		// masLioncSubClassList =
		// getHibernateTemplate().find("from jkt.hms.masters.business.MasLioncSubClass");
		mainChargecodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.createAlias("Department", "dept")
				.createAlias("dept.DepartmentType", "dt")
				// .add(Restrictions.eq("dt.DepartmentTypeCode", deptType))
				// .add(Restrictions.eq("Department.Id", deptId))
				.addOrder(Order.asc("MainChargecodeName")).list();
		subChargecodeList = session.createCriteria(MasSubChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("SubChargecodeName")).list();
		/*
		 * subChargecodeList = getHibernateTemplate() .find(
		 * "from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'Y' order by isc.SubChargecodeName"
		 * );
		 */

		if (mainChargecodeList.size() > 0) {
			map.put("mainChargecodeList", mainChargecodeList);
		}
		map.put("masLioncSubClassList", masLioncSubClassList);
		map.put("subChargecodeList", subChargecodeList);

		return map;
	}

	@SuppressWarnings("unchecked")
	public boolean addLionClass(MasLioncSubClass masLioncSubClass) {
		LOGGER.info("in addLionClass");
		boolean dataSaved = false;

		try {
			org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false);
			hbt.save(masLioncSubClass);
			dataSaved = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSaved;
	}

	@SuppressWarnings("unchecked")
	public boolean editLionClass(Map<String, Object> generalMap) {
		LOGGER.info("in editLionClass");
		MasMainChargecode masMainChargecode = new MasMainChargecode();
		MasSubChargecode masSubChargecode = new MasSubChargecode();
		MasLionc masLionc = new MasLionc();
		boolean editedSuccessfully = false;
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		String changedBy = "";

		int mainChargeId = 0;
		int subChargeId = 0;
		String className = "";
		String userName = "";
		int hospitalId = 0;
		int deptId = 0;
		boolean dataUpdated = false;

		int mainChargecodeId = (Integer) generalMap.get("mainChargeId");
		int subChargeCodeId = (Integer) generalMap.get("subChargeId");
		int classId = (Integer) generalMap.get("classId");
		String lionNo = (String) generalMap.get("lionNo");
		className = (String) generalMap.get("className");
		// dataUpdated = (boolean) generalMap.get("flag");
		MasLioncSubClass masLioncSubClass = (MasLioncSubClass) getHibernateTemplate()
				.get(MasLioncSubClass.class, classId);
		if (classId != '0') {

			masLionc.setId(lionNo);
			masMainChargecode.setId(mainChargecodeId);
			masSubChargecode.setId(subChargeCodeId);
			masLioncSubClass.setMainChargeCode(masMainChargecode);
			masLioncSubClass.setSubChargeCode(masSubChargecode);
			masLioncSubClass.setLionCClass(className);
			masLioncSubClass.setLioncNum(masLionc);
			masLioncSubClass.setStatus("y");
		}
		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masLioncSubClass);
		editedSuccessfully = true;
		return editedSuccessfully;

	}

	@SuppressWarnings("unchecked")
	public boolean deleteLionClass(int investigationId,
			Map<String, Object> generalMap) {
		LOGGER.info("in deleteLionClass");
		boolean dataDeleted = false;
		String changedBy = "";
		Date currentDate = new Date();
		String currentTime = "";
		currentTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		MasLioncSubClass masLioncSubClass = new MasLioncSubClass();
		masLioncSubClass = (MasLioncSubClass) getHibernateTemplate().get(
				MasLioncSubClass.class, investigationId);
		changedBy = (String) generalMap.get("changedBy");
		currentDate = (Date) generalMap.get("currentDate");
		currentTime = (String) generalMap.get("currentTime");
		if (generalMap.get("flag") != null) {
			List mainChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasMainChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");
			List subChargecodeList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSubChargecode as isc where isc.Id='"
							+ investigationId + "' and isc.Status='y'");

			String flag = (String) generalMap.get("flag");
			if (flag.equals("InActivate")) {
				masLioncSubClass.setStatus("n");
				dataDeleted = true;
			} else if (flag.equals("Activate")) {
				masLioncSubClass.setStatus("y");
				dataDeleted = false;
			}
		}

		org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		hbt.update(masLioncSubClass);
		return dataDeleted;
	}

	public Map<String, Object> searchLionSubClass(String searchField) {
		LOGGER.info("in searchLionSubClass");
		Session session = (Session) getSession();
		List<MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
		List<MasLioncSubClass> masLioncSubClassList = new ArrayList<MasLioncSubClass>();
		List<MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
		Map<String, Object> map = new HashMap<String, Object>();
		List lst = new ArrayList();
		masLioncSubClassList = session.createCriteria(MasLioncSubClass.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.add(Restrictions.like("LionCClass", searchField + "%")).list();

		mainChargecodeList = session.createCriteria(MasMainChargecode.class)
				.add(Restrictions.eq("Status", "y").ignoreCase())
				.addOrder(Order.asc("MainChargecodeName")).list();

		subChargecodeList = getHibernateTemplate()
				.find("from jkt.hms.masters.business.MasSubChargecode as isc where isc.Status = 'y' or status='Y' order by isc.SubChargecodeName");

		if (mainChargecodeList.size() > 0) {
			map.put("mainChargecodeList", mainChargecodeList);
		}
		map.put("masLioncSubClassList", masLioncSubClassList);
		map.put("subChargecodeList", subChargecodeList);

		return map;

	}

	// ********************************Start Get Class Name For LionC
	// Class*****************************//
	public Map<String, Object> getClassForLionC(Box box) {
		LOGGER.info("in getClassForLionC");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLionc> masLioncList = new ArrayList<MasLionc>();
		session = (Session) getSession();
		try {
			String str = box.get("autoHint") + "%";
			Criteria c = session.createCriteria(MasLionc.class).add(
					Restrictions.like("MasClass", str));

			c.setFirstResult(0);
			c.setMaxResults(10);
			masLioncList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("masLioncList", masLioncList);

		return map;

	}

	// ********************************End Get Class Name For LionC
	// Class*****************************//
	public Map<String, Object> getLionClass(Box box) {
		LOGGER.info("in getLionClass");
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasLioncSubClass> masLionSubClassList = new ArrayList<MasLioncSubClass>();
		List<MasLionc> masLionClassList = new ArrayList<MasLionc>();
		int mainChargeCodeId = box.getInt("mainChargeCode");
		int subChargeCodeId = box.getInt("subChargeCode");

		session = (Session) getSession();
		try {

			List<Object> masLioncSubClassList = new ArrayList<Object>();
			masLionClassList = getHibernateTemplate()
					.find("select masLionc from jkt.hms.masters.business.MasLioncSubClass as mlsc right outer join mlsc.LoincNum as masLionc left outer join mlsc.MainChargeCode as mcc left outer join mlsc.SubChargeCode as scc where mcc.Id='"
							+ mainChargeCodeId
							+ "' and scc.Id='"
							+ subChargeCodeId + "'");
			/*
			 * if(masLioncSubClassList.size()>0){ for (Iterator iterator =
			 * masLioncSubClassList.iterator(); iterator .hasNext();) { Object[]
			 * object = (Object[]) iterator.next(); MasLionc masLionc=new
			 * MasLionc(); masLionc=(MasLionc)object[1]; MasLioncSubClass
			 * masLioncSubClass=new MasLioncSubClass();
			 * masLioncSubClass=(MasLioncSubClass)object[0]; } }
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		map.put("masLionClassList", masLionClassList);

		return map;
	}

	public Map<String, Object> getItemList(Box box) {
		LOGGER.info("in getItemList");
		Map<String, Object> map = new HashMap<String, Object>();
		List<StoreGrnM> itemList = new ArrayList<StoreGrnM>();
		session = (Session) getSession();
		try {
			String str = box.get("autoHint") + "%";
			Criteria c = session.createCriteria(MasStoreItem.class)
					.add(Restrictions.like("Nomenclature", str))
					.addOrder(Order.asc("Nomenclature"));

			c.setMaxResults(50);
			itemList = c.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);

		return map;

	}

	public Map<String, Object> getItemStock(Box box) {
		LOGGER.info("in getItemStock");
		Map<String, Object> map = new HashMap<String, Object>();
		List itemStockList = new ArrayList();

		int itemId = box.getInt("itemId");
		BigDecimal sum = null;

		session = (Session) getSession();
		try {
			itemStockList = session
					.createQuery(
							"select sum(ClosingStock)as sibs from StoreItemBatchStock as ugh where ugh.Item.Id="
									+ itemId).list();
			/*
			 * itemStockList= session.createCriteria(StoreItemBatchStock.class)
			 * //.createAlias("MasStoreItem", "storeItem")
			 * .add(Restrictions.eq("Item.Id",itemId)).list();
			 * //.setProjection(Projections.sum("ClosingStock"))
			 * //.setProjection(Projections.groupProperty("ClosingStock"));
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		map.put("itemStockList", itemStockList);
		map.put("sum", sum);

		return map;
	}

	public Map<String, Object> getTestName(Map<String, Object> map) {
		LOGGER.info("in getTestName");
		List<DgMasInvestigation> testList = new ArrayList<DgMasInvestigation>();
		String deptType = "";
		int deptId = 0;
		session = (Session) getSession();
		deptType = (String) map.get("deptType");
		deptId = (Integer) map.get("deptId");
		testList = session.createCriteria(DgMasInvestigation.class)
				.createAlias("MainChargecode", "main")
				.add(Restrictions.eq("main.Department.Id", deptId)).list();

		map.put("testList", testList);
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSensitive(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSensitive");
		Map<String, Object> map = new HashMap<String, Object>();

		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Users users = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			users = (Users) parameterMap.get(RequestConstants.USERS);
		}

		String forOutSideLab = null;
		if (parameterMap.get("forOutSideLab") != null) {
			forOutSideLab = (String) parameterMap.get("forOutSideLab");
		}
		
		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_SENSITIVE);
		Vector resultNo = box.getVector(RequestConstants.RESULT_NO_SENSITIVE);
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_FOR_SENSITIVE);

		Vector resultSensitive = box
				.getVector(RequestConstants.RESULT_SENSITIVE);

		// ///////////////////// Data For Details
		Vector result = box.getVector(RequestConstants.SR_NO);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		/*
		 * Vector charge_code_Id = box
		 * .getVector(RequestConstants.CHARGE_CODE_ID_SINGLE_VALUE);
		 */
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID_FOR_SENSITIVE);
		/*
		 * Vector uomId = box
		 * .getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE)
		 */
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_SINGLE_VALUE);
		// ///////////////////// Data For Details
		for (int i = 0; i < resultTypeSingleValue.size(); i++) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) {
				DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
				// Vector resultSingle = null;
				int subchargeId = box
						.getInt(RequestConstants.SUB_CHARGECODE_ID);
				int mainChargeId = box
						.getInt(RequestConstants.MAIN_CHARGECODE_ID);
				int sampleCollectionId = box
						.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
				int hinId = box.getInt(RequestConstants.HIN_ID);
				int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
				int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
				int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
				int resultEnteredId = box
						.getInt(RequestConstants.RESULT_ENTERED_BY);

				dgResultEntryHeader.setResultNo((String) resultNo.get(i));
				dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks((String) remarks.get(i));
				dgResultEntryHeader.setResultDate(date);
				dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader.setResultTime(time);
				dgResultEntryHeader.setVerified("Y");
				dgResultEntryHeader.setVerifiedOn(date);
				dgResultEntryHeader.setVerifiedTime(time);

				if (testOrderNo.get(i) != null
						&& !testOrderNo.get(i).equals("")
						&& !testOrderNo.get(i).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(i)));
				}

				DgMasInvestigation dgMasInvestigationForHeader = new DgMasInvestigation();
				dgMasInvestigationForHeader.setId(Integer
						.parseInt((String) investigationId.get(i)));
				dgResultEntryHeader
						.setInvestigation(dgMasInvestigationForHeader);

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setHin(patient);
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					dgResultEntryHeader.setEmployee(masEmployee);
				}
				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
					dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				if (resultTypeSingleValue != null
						&& !resultTypeSingleValue.equals("")) {
					dgResultEntryHeader
							.setResultType((String) resultTypeSingleValue
									.get(i));
				}
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);
					
					
					if(forOutSideLab!=null && forOutSideLab.equalsIgnoreCase("Y")){
						dgResultEntryHeader.setVerified("V");
						dgResultEntryHeader.setResultStatus("A");
					}

					hbt.save(dgResultEntryHeader);
					hbt.refresh(dgResultEntryHeader);
					// ///////////////////////////////

					DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
					// int x = Integer.parseInt((String)investigationId.get(i));

					if (Integer.parseInt((String) investigationId.get(i)) != 0) {
						
						if(sample_Id.size()>i){ 
						if(sample_Id.get(i)!=null && !sample_Id.get(i).equals("")){//added by govind 27-10-2016
							
						if (Integer.parseInt((String) sample_Id.get(i)) != 0) {
							MasSample masSample = new MasSample();
							masSample.setId(Integer.parseInt((String) sample_Id
									.get(i)));
							dgResultEntryDetail.setSample(masSample);
						}
                        }
						
					}

						// if(investigationId != 0){
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
						// }

						dgResultEntryDetail.setResult((String) resultSensitive
								.get(i));
						// dgResultEntryDetail.setResult((String)
						// result.get(i));
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail
								.setResultType((String) resultTypeSingleValue
										.get(i));
						dgResultEntryDetail.setResultDetailStatus("A");
						dgResultEntryDetail.setValidated("Y");

						if (Integer.parseInt((String) sampleDetailId.get(i)) != 0) {
							DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
							dgSample.setId(Integer
									.parseInt((String) sampleDetailId.get(i)));
							dgResultEntryDetail
									.setSampleCollectionDetails(dgSample);
						}

						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						// map.put("resultType", resultType);
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
								.load(DgSampleCollectionDetails.class,
										Integer.parseInt((String) sampleDetailId
												.get(i)));
						dgDetails.setOrderStatus("E");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
					}

					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					saved = false;
					e.printStackTrace();
				}
			}
		}
		// saved = true;
		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> submitResultEntryForSensitiveForEmpanelled(
			Map<String, Object> parameterMap) {
		LOGGER.info("in submitResultEntryForSensitiveForEmpanelled");
		Map<String, Object> map = new HashMap<String, Object>();

		boolean saved = true;
		Box box = null;
		int hospitalId = 0;
		String userName = "";
		Session session = (Session) getSession();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		MasEmpaneled masEmpaneled = null;
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);

		if (parameterMap.get("box") != null) {
			box = (Box) parameterMap.get("box");
		}
		if (parameterMap.get("hospitalId") != null) {
			hospitalId = (Integer) parameterMap.get("hospitalId");
		}
		if (parameterMap.get("userName") != null) {
			userName = (String) parameterMap.get("userName");
		}
		if (parameterMap.get(RequestConstants.USERS) != null) {
			masEmpaneled = (MasEmpaneled) parameterMap.get(RequestConstants.USERS);
		}

		Vector testOrderNo = box
				.getVector(RequestConstants.TEST_ORDER_NO_SENSITIVE);
		Vector resultNo = box.getVector(RequestConstants.RESULT_NO_SENSITIVE);
		Vector remarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		Vector resultTypeSingleValue = box
				.getVector(RequestConstants.RESULT_TYPE_FOR_SENSITIVE);

		Vector resultSensitive = box
				.getVector(RequestConstants.RESULT_SENSITIVE);

		// ///////////////////// Data For Details
		Vector result = box.getVector(RequestConstants.SR_NO);
		Vector additionalRemarks = box
				.getVector(RequestConstants.ADDITIONAL_REMARKS_SINGLE_VALUE);
		/*
		 * Vector charge_code_Id = box
		 * .getVector(RequestConstants.CHARGE_CODE_ID_SINGLE_VALUE);
		 */
		Vector sample_Id = box.getVector(SAMPLE_ID_SINGLE_VALUE);
		Vector investigationId = box
				.getVector(RequestConstants.INVESTIGATION_ID_FOR_SENSITIVE);
		/*
		 * Vector uomId = box
		 * .getVector(RequestConstants.UNIT_OF_MEASUREMENT_ID_SINGLE_VALUE)
		 */
		Vector sampleDetailId = box
				.getVector(RequestConstants.DG_SAMPLE_DETAIL_ID_SINGLE_VALUE);
		// ///////////////////// Data For Details
		for (int i = 0; i < resultTypeSingleValue.size(); i++) {
			if (result.get(i) != null && !result.get(i).equals("")
					&& resultTypeSingleValue.get(i) != null
					&& !resultTypeSingleValue.get(i).equals("")) {

				DgResultEntryHeader dgResultEntryHeader = new DgResultEntryHeader();
				// Vector resultSingle = null;
				int subchargeId = box
						.getInt(RequestConstants.SUB_CHARGECODE_ID);
				int mainChargeId = box
						.getInt(RequestConstants.MAIN_CHARGECODE_ID);
				int sampleCollectionId = box
						.getInt(RequestConstants.SAMPLE_COLLECTION_ID);
				int hinId = box.getInt(RequestConstants.HIN_ID);
				int inpatientId = box.getInt(RequestConstants.INPATIENT_ID);
				int employeeId = box.getInt(RequestConstants.EMPLOYEE_ID);
				int deptId = box.getInt(RequestConstants.DEPARTMENT_ID);
				int resultEnteredId = box
						.getInt(RequestConstants.RESULT_ENTERED_BY);

				dgResultEntryHeader.setResultNo((String) resultNo.get(i));
				//dgResultEntryHeader.setLastChgdBy(users);
				dgResultEntryHeader.setLastChgdDate(date);
				dgResultEntryHeader.setLastChgdTime(time);
				dgResultEntryHeader.setRemarks((String) remarks.get(i));
				dgResultEntryHeader.setResultDate(date);
				dgResultEntryHeader.setResultStatus("P");
				dgResultEntryHeader.setResultTime(time);
				dgResultEntryHeader.setVerified("Y");
				dgResultEntryHeader.setVerifiedOn(date);
				dgResultEntryHeader.setVerifiedTime(time);

				if (testOrderNo.get(i) != null
						&& !testOrderNo.get(i).equals("")
						&& !testOrderNo.get(i).equals("null")) {
					dgResultEntryHeader.setTestOrderNo(Integer
							.parseInt((String) testOrderNo.get(i)));
				}

				DgMasInvestigation dgMasInvestigationForHeader = new DgMasInvestigation();
				dgMasInvestigationForHeader.setId(Integer
						.parseInt((String) investigationId.get(i)));
				dgResultEntryHeader
						.setInvestigation(dgMasInvestigationForHeader);

				MasMainChargecode masMainChargecode = new MasMainChargecode();
				masMainChargecode.setId(mainChargeId);
				dgResultEntryHeader.setMainChargecode(masMainChargecode);

				MasSubChargecode masSubChargecode = new MasSubChargecode();
				masSubChargecode.setId(subchargeId);
				dgResultEntryHeader.setSubChargecode(masSubChargecode);

				DgSampleCollectionHeader dgSampleCollectionHeader = new DgSampleCollectionHeader();
				dgSampleCollectionHeader.setId(sampleCollectionId);
				dgResultEntryHeader
						.setSampleCollectionHeader(dgSampleCollectionHeader);

				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(deptId);
				dgResultEntryHeader.setDepartment(masDepartment);

				MasHospital masHospital = new MasHospital();
				masHospital.setId(hospitalId);
				dgResultEntryHeader.setHospital(masHospital);

				Patient patient = new Patient();
				patient.setId(hinId);
				dgResultEntryHeader.setHin(patient);
				if (inpatientId != 0) {
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dgResultEntryHeader.setInpatient(inpatient);
				}
				if (employeeId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(employeeId);
					//dgResultEntryHeader.setEmployee(masEmployee);
				}
				if (resultEnteredId != 0) {
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(resultEnteredId);
					dgResultEntryHeader.setEmployee(masEmployee);
					//dgResultEntryHeader.setResultVerifiedBy(masEmployee);
				}
				if (resultTypeSingleValue != null
						&& !resultTypeSingleValue.equals("")) {
					dgResultEntryHeader
							.setResultType((String) resultTypeSingleValue
									.get(i));
				}
				dgResultEntryHeader.setEmpaneled(masEmpaneled);
				dgResultEntryHeader.setEmpanelledStatus("Y");
				Transaction tx = null;
				try {
					tx = session.beginTransaction();
					org.springframework.orm.hibernate3.HibernateTemplate hbt = getHibernateTemplate();
					hbt.setFlushModeName("FLUSH_EAGER");
					hbt.setCheckWriteOperations(false);

					hbt.save(dgResultEntryHeader);
					hbt.refresh(dgResultEntryHeader);
					// ///////////////////////////////

					DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
					// int x = Integer.parseInt((String)investigationId.get(i));

					if (Integer.parseInt((String) investigationId.get(i)) != 0) {

						if (Integer.parseInt((String) sample_Id.get(i)) != 0) {
							MasSample masSample = new MasSample();
							masSample.setId(Integer.parseInt((String) sample_Id
									.get(i)));
							dgResultEntryDetail.setSample(masSample);
						}

						// if(investigationId != 0){
						DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
						dgMasInvestigation.setId(Integer
								.parseInt((String) investigationId.get(i)));
						dgResultEntryDetail
								.setInvestigation(dgMasInvestigation);
						// }

						dgResultEntryDetail.setResult((String) resultSensitive
								.get(i));
						// dgResultEntryDetail.setResult((String)
						// result.get(i));
						dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
						dgResultEntryDetail
								.setRemarks((String) additionalRemarks.get(i));
						dgResultEntryDetail
								.setResultType((String) resultTypeSingleValue
										.get(i));
						dgResultEntryDetail.setResultDetailStatus("A");
						dgResultEntryDetail.setValidated("Y");

						if (Integer.parseInt((String) sampleDetailId.get(i)) != 0) {
							DgSampleCollectionDetails dgSample = new DgSampleCollectionDetails();
							dgSample.setId(Integer
									.parseInt((String) sampleDetailId.get(i)));
							dgResultEntryDetail
									.setSampleCollectionDetails(dgSample);
						}
						dgResultEntryDetail.setEmpaneled(masEmpaneled);
						dgResultEntryDetail.setEmpanelledStatus("Y");
						hbt.save(dgResultEntryDetail);
						hbt.refresh(dgResultEntryDetail);
						// map.put("resultType", resultType);
						DgSampleCollectionDetails dgDetails = (DgSampleCollectionDetails) getHibernateTemplate()
								.load(DgSampleCollectionDetails.class,
										Integer.parseInt((String) sampleDetailId
												.get(i)));
						dgDetails.setOrderStatus("E");
						hbt.update(dgDetails);
						hbt.refresh(dgDetails);
					}

					tx.commit();
				} catch (Exception e) {
					if (tx != null) {
						tx.rollback();
					}
					saved = false;
					e.printStackTrace();
				}
			}
		}
		// saved = true;
		map.put("resultNo", resultNo);

		map.put("saved", saved);
		return map;
	}

	public Map<String, Object> getDepartmentList(Map<String, Object> map) {
		LOGGER.info("in getDepartmentList");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		int deptId = 0;
		deptId = (Integer) map.get("deptId");

		Criteria crit = session.createCriteria(MasDepartment.class)
				.add(Restrictions.eq("Id", deptId))
				.add(Restrictions.eq("Status", "y").ignoreCase());
		departmentList = crit.list();

		dataMap.put("departmentList", departmentList);
		return dataMap;

	}

	public Map<String, Object> printOrderStatusReportWard(
			Map<String, Object> mapForDs) {
		LOGGER.info("in printOrderStatusReportWard");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		List<DgOrderhd> orderHdList = new ArrayList<DgOrderhd>();
		int orderNoIdForReport = 0;
		int hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		String orderNo = null;
		orderNoIdForReport = (Integer) mapForDs.get("orderIdForReport");
		Criteria crit = session.createCriteria(DgOrderhd.class)
				.add(Restrictions.eq("Id", orderNoIdForReport))
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.add(Restrictions.eq("OrderStatus", "A"));
		orderHdList = crit.list();

		for (DgOrderhd orderHd : orderHdList) {
			orderNo = orderHd.getOrderNo();
		}

		dataMap.put("orderNo", orderNo);
		return dataMap;
	}

	public Map<String, Object> showPaitentTestDetailInResultPrinting(
			Map<String, Object> mapForDs) {
		LOGGER.info("in showPaitentTestDetailInResultPrinting");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Session session = (Session) getSession();
		int hospitalId = (Integer) mapForDs.get(HOSPITAL_ID);
		String orderNo = (String) mapForDs.get(RequestConstants.ORDER_NO);
		int deptId = (Integer) mapForDs.get(RequestConstants.DEPT_ID);
		Criteria crit = session.createCriteria(DgResultEntryHeader.class)
				.add(Restrictions.eq("Hospital.Id", hospitalId))
				.createAlias("Department", "dept")
				.add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("Verified", "V").ignoreCase()) // add by vinay only those investigation will be availabe for printing those are validated
				.createAlias("SampleCollectionHeader", "sch")
				.createAlias("sch.Order", "orderN")
				.add(Restrictions.eq("orderN.OrderNo", orderNo));
		List<DgResultEntryHeader> dgResultEntryHeader = (List<DgResultEntryHeader>) crit
				.list();
		dataMap.put("dgResultEntryHeader", dgResultEntryHeader);
		return dataMap;
	}

	@Override
	public Map<String, Object> getBulkPatientDetailsForResultEntry(
			Map<String, Object> mapForDs) {
		LOGGER.info("in getBulkPatientDetailsForResultEntry");
		Map<String, Object> map = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> patientList = new ArrayList<DgSampleCollectionDetails>();
		Date fromDate = new Date();
		Date toDate = new Date();
		String serviceNo = "";
		String hinNo = "";
		String serPersonFName = "";
		String patientFName = "";
		String adNo = "";
		int departmentId = 0;
		String orderType = "";
		Session session = (Session) getSession();
		Criteria crit = null;
		int hinId = 0;
		int subChargeCodeId = 0;
		String billNo = "";
		Integer hospitalId = 0;
		String diagnosisNo = "";
		String mobileNo = "";
		String wardName = "";
		Integer barCode = 0;
		int deptId = 0;
		int chargeCode = 0;
		if (mapForDs.get("deptId") != null) {
			deptId = Integer.parseInt("" + mapForDs.get("deptId"));
		}

		if (mapForDs.get("diagnosisNo") != null) {
			diagnosisNo = (String) mapForDs.get("diagnosisNo");
		}
		if (mapForDs.get("hinNo") != null) {
			hinNo = (String) mapForDs.get("hinNo");
		}

		if (mapForDs.get("departmentId") != null) {
			departmentId = (Integer) mapForDs.get("departmentId");
		}

		if (mapForDs.get("subChargeCodeId") != null) {
			subChargeCodeId = (Integer) mapForDs.get("subChargeCodeId");
		}
		if (mapForDs.get("hinId") != null) {
			hinId = (Integer) mapForDs.get("hinId");
		}
		if (mapForDs.get("patientFName") != null) {
			patientFName = (String) mapForDs.get("patientFName");
		}
		if (mapForDs.get("adNo") != null) {
			adNo = (String) mapForDs.get("adNo");
		}
		if (mapForDs.get("orderType") != null) {
			orderType = (String) mapForDs.get("orderType");
		}
		if (mapForDs.get("fromDate") != null) {
			fromDate = (Date) mapForDs.get("fromDate");
		}
		if (mapForDs.get("toDate") != null) {
			toDate = (Date) mapForDs.get("toDate");
		}
		if (mapForDs.get("billNo") != null) {
			billNo = (String) mapForDs.get("billNo");
		}
		if (mapForDs.get(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = (Integer) mapForDs.get(RequestConstants.HOSPITAL_ID);
		}
		if (mapForDs.get(RequestConstants.MOBILE_NO) != null) {
			mobileNo = (String) mapForDs.get(RequestConstants.MOBILE_NO);
		}
		if (mapForDs.get(RequestConstants.WARD_NAME) != null) {
			wardName = (String) mapForDs.get(RequestConstants.WARD_NAME);
		}
		if (mapForDs.get(RequestConstants.BARCODE) != null) {
			barCode = (Integer) mapForDs.get(RequestConstants.BARCODE);
		}
		if (mapForDs.get(RequestConstants.CHARGE_CODE) != null) {
			chargeCode = (Integer) mapForDs.get(RequestConstants.CHARGE_CODE);
		}

		crit = session.createCriteria(DgSampleCollectionDetails.class)
				.add(Restrictions.eq("OrderStatus", "A"))
				.createAlias("SampleCollectionHeader", "sampleHead")
				.createAlias("sampleHead.Department", "dept")
				.createAlias("sampleHead.Hin", "pt")
				.add(Restrictions.eq("dept.Id", deptId))
				.add(Restrictions.eq("sampleHead.Hospital.Id", hospitalId))
				// .add(Restrictions.eq("sampleHead.OrderStatus", "A"))
				.add(Restrictions.between("sampleHead.SampleValidationDate",
						fromDate, toDate));
		if (barCode != 0) {
			crit = crit.add(Restrictions.like("DiagNo", "" + barCode));
		}
		if (!hinNo.equals("")) {
			crit = crit.add(Restrictions.like("pt.HinNo", hinNo + "%"));
		}
		if (hinId != 0) {
			crit = crit.add(Restrictions.eq("pt.Id", hinId));
		}
		if (!mobileNo.equals("")) {
			crit = crit.add(Restrictions.eq("pt.MobileNumber", mobileNo));
		}
		if (!patientFName.equals("")) {
			crit = crit.add(Restrictions.like("pt.PFirstName", patientFName
					+ "%"));
		}

		if(!adNo.equals("") || !wardName.equals("")){
			//added by govind 22-07-2017
			crit.createAlias("sampleHead.Inpatient", "inpatient");
				if (!wardName.equals("")) {
			
					crit.add(Restrictions.eq("inpatient.AdNo", adNo));
				}
				else
				{
					crit.createAlias("inpatient.Department", "ipDpt")
					.add(Restrictions.eq("ipDpt.DepartmentName",
							wardName));
				}
			}
		if (!orderType.equals("")) {
			crit = crit.createAlias("sampleHead.Order", "or").add(
					Restrictions.eq("or.PatientType", orderType));
		}
		if (departmentId != 0) {
			crit = crit.add(Restrictions.eq("sampleHead.Department.Id",
					departmentId));
		}
		if (!billNo.equals("")) {
			crit = crit.add(Restrictions.eq("or.BillChargeSlpNo", billNo));
		}
		if (subChargeCodeId != 0) {
			crit.createAlias("Subcharge", "subChrg").add(
					Restrictions.eq("subChrg.Id", subChargeCodeId));
		}
		if (chargeCode != 0) {
			crit = crit.createAlias("ChargeCode", "charge").add(
					Restrictions.eq("charge.Id", chargeCode));
		}
		/*
		 * crit = crit.setProjection(Projections.projectionList()
		 * .add(Projections.groupProperty("SampleCollectionHeader"))
		 * .add(Projections.groupProperty("Subcharge")));
		 */

		patientList = crit.list();
		map.put("patientDetailsList", patientList);
		return map;
	}

	@Override
	public List<UploadDocuments> getDocumentList(int uploadedDocumentId) {
		LOGGER.info("in getDocumentList");
		List<UploadDocuments> uploadDocuments = new ArrayList<UploadDocuments>();
		
		Session session = (Session) getSession();
		Criteria crit = null;
		
		uploadDocuments = session.createCriteria(UploadDocuments.class).add(Restrictions.eq("Id", uploadedDocumentId)).list();
		
		
		return uploadDocuments;
	}

	@Override
	public boolean rejectSampleHisto(int sampleDetailsId,
			int sampleHisoDetailsId) {
		LOGGER.info(sampleHisoDetailsId+"<<<sampleHisoDetailsId   sampleDetailsId>>>"+sampleDetailsId);
		HibernateTemplate hbt = getHibernateTemplate();
		hbt.setFlushModeName("FLUSH_EAGER");
		hbt.setCheckWriteOperations(false);
		boolean updated=false;
		Session session=(Session)getSession();
		List<DgSampleCollectionDetails>dtList=new ArrayList<DgSampleCollectionDetails>();
		List<DgSampleCollectionDetails>dtList1=new ArrayList<DgSampleCollectionDetails>();
		List<DgHistoSampleCollectionDetails>dthList=new ArrayList<DgHistoSampleCollectionDetails>();
		List<DgHistoSampleCollectionDetails>dthList1=new ArrayList<DgHistoSampleCollectionDetails>();
		List<DgSampleCollectionHeader>DgSampleCollectionHeaderList=new ArrayList<DgSampleCollectionHeader>();
		int headerId=0;
		dtList=session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.eq("Id",sampleDetailsId)).list();
		for(DgSampleCollectionDetails DgSampleCollectionDetails:dtList){
			headerId=DgSampleCollectionDetails.getSampleCollectionHeader().getId();
			DgSampleCollectionDetails.setOrderStatus("L");
			hbt.update(DgSampleCollectionDetails);
		}
		dtList1=session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.eq("SampleCollectionHeader.Id",headerId)).list();
		
		
		
		DgSampleCollectionHeaderList=session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Id", headerId)).list();
		
		
		
		for(DgSampleCollectionDetails DgSampleCollectionDetails:dtList1){
			DgSampleCollectionDetails.setOrderStatus("L");
			hbt.update(DgSampleCollectionDetails);
		}
		
		for(DgSampleCollectionHeader DgSampleCollectionHeader:DgSampleCollectionHeaderList){
			DgSampleCollectionHeader.setOrderStatus("L");
			hbt.update(DgSampleCollectionHeader);
		}
		dthList=session.createCriteria(DgHistoSampleCollectionDetails.class).add(Restrictions.eq("Id",sampleHisoDetailsId)).list();
		dthList1=session.createCriteria(DgHistoSampleCollectionDetails.class).add(Restrictions.eq("SampleCollectionHeader.Id",sampleHisoDetailsId)).list();
		for(DgHistoSampleCollectionDetails DgHistoSampleCollectionDetails :dthList){
			DgHistoSampleCollectionDetails.setOrderStatus("L");
			hbt.update(DgHistoSampleCollectionDetails);
		}
		for(DgHistoSampleCollectionDetails DgHistoSampleCollectionDetails :dthList1){
			DgHistoSampleCollectionDetails.setOrderStatus("L");
			hbt.update(DgHistoSampleCollectionDetails);
		}
		return true;
	}

	@Override
	public Map<String, Object> getVisitDetails(int hospitalId, String uhID) {
		LOGGER.info("in getVisitDetails");
		Session session=(Session)getSession();
		List<Patient>ptList=new ArrayList<Patient>();
		ptList=session.createCriteria(Patient.class).add(Restrictions.eq("HinNo",uhID)).list();
		int hinId=0;
		for(Patient pt:ptList){
			hinId=pt.getId();
		}
		Map<String,Object>map=new HashMap<String,Object>();
		List<Visit>visitList=new ArrayList<Visit>();
		visitList=session.createCriteria(Visit.class).add(Restrictions.eq("Hospital.Id",hospitalId)).add(Restrictions.eq("Hin.Id",hinId)).list();
		map.put("visitList",visitList);
		map.put("hinId",hinId);
		return map;
	}

	@Override
	public Map<String, Object> getOrderDetails(int hinId) {
		LOGGER.info("in getOrderDetails");
		Session session=(Session)getSession();
		List<DgSampleCollectionHeader>ptList=new ArrayList<DgSampleCollectionHeader>();
		ptList=session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Hin.Id", hinId)).list();
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("ptList",ptList);
		return map;
	}

	@Override
	public Map<String, Object> getSamepleDetails(int orderId) {
		LOGGER.info("in getSamepleDetails");
		Session session=(Session)getSession();
		List<Object[]>sampleDetails=new ArrayList<Object[]>();
		List<Object[]>sampleDetails1=new ArrayList<Object[]>();
		Map<String,Object>map=new HashMap<String,Object>();
		Map<String,Boolean> sampleMap=new HashMap<String,Boolean>();
		String query2 = "select scd.diag_no,msch.sub_chargecode_name,"
						+" case when msamp.sample_description='' then '-'" 
						+" when msamp.sample_description is null then '-'"
						+" else msamp.sample_description end as sample_description,"
						+" case when dmsc.collection_name='' then '-'"
						+" when dmsc.collection_name is null then '-'"
						+" else dmsc.collection_name end as collection_name,msch.sub_chargecode_code,me.first_name,"
						+" scd.sample_coll_datetime,scd.last_chg_time,case when msamp.sample_code='' then '-' when msamp.sample_code is null then '-' else msamp.sample_code end as sample_code,hd.visit_id,hd.inpatient_id,"
						+" hd.routine_urgent_status,hd.order_no,"
						+" case when dmsc.collection_code='' then '-' when dmsc.collection_code is null then '-' else dmsc.collection_code end as collection_code,"
						+" scd.sample_collection_details_id "
						+" from dg_sample_collection_details scd"
						+" left outer join  dg_sample_collection_header sch on scd.sample_collection_header_id=sch.sample_collection_header_id"
						+" left outer join  dg_orderhd hd on sch.order_id=hd.orderhd_id"
						+" left outer join dg_mas_investigation inv on scd.investigation_id=inv.investigation_id "
						+" left outer join mas_sub_chargecode msch on scd.subcharge=msch.sub_chargecode_id "
						+" left outer join mas_sample msamp on scd.sample_id=msamp.sample_id "
						+" left outer join dg_mas_collection dmsc on dmsc.collection_id=inv.collection_id "
						+" left outer join mas_employee me on me.employee_id=scd.collected_by"
						+" left outer join patient pt on pt.hin_id=sch.hin_id"
						+" left outer join mas_administrative_sex mas  on mas.administrative_sex_id=pt.sex_id"
						+" where sch.order_id= '" + orderId + "'";
        sampleDetails = session.createSQLQuery(query2).list();
        //added by govind 12-10-2017
        int objCount=0;
        for(Object[] obj:sampleDetails){        	
        	if(objCount==0){    
        		sampleDetails1.add(obj);
        		sampleMap.put(obj[4].toString(), true);
        	}else{
        	if(sampleMap.get(obj[4].toString())!=null && sampleMap.get(obj[4].toString())==true){  
        		//System.out.println("sampleMap.get(obj[4].toString())--->>"+sampleMap.get(obj[4].toString())+" obj[4].toString()--->>"+obj[4].toString());
        	}else{
        		sampleDetails1.add(obj);
        		sampleMap.put(obj[4].toString(), true);
        	}
        	}
        	objCount++;
        }
        //System.out.println("1 sampleDetails1--->>"+sampleDetails1.size()+" sampleDetails--->>"+sampleDetails.size());
        if(sampleDetails1.size()>0){
        	sampleDetails=null;
        	sampleDetails=sampleDetails1;
        }
        //System.out.println("2 sampleDetails1--->>"+sampleDetails1.size()+" sampleDetails--->>"+sampleDetails.size());
        //added by govind 12-10-2017 end
		map.put("sampleDetails",sampleDetails);
		return map;
	}

	@Override
	public Map<String, Object> validateResultEntryForTempelateLab(
			Map<String, Object> dataMap) {
		LOGGER.info("in validateResultEntryForTempelateLab");
		int resultId=0;
		int dgresultDetailIdTemplate=0;
		String result="";
		int hospitalId=0;
		 if(null !=dataMap.get("result")){
			 result=(String) dataMap.get("result");
		 }
		 
		 if(null !=dataMap.get("resultId")){
			 resultId=(Integer) dataMap.get("resultId");
		 }
		 
		 if(null !=dataMap.get("dgresultDetailIdTemplate")){
			 dgresultDetailIdTemplate=(Integer) dataMap.get("dgresultDetailIdTemplate");
		 }
		
		 if(null !=dataMap.get("hospitalId")){
			 hospitalId=(Integer) dataMap.get("hospitalId");

		 }
		 Session session=(Session)getSession();
		 
		 Transaction tnx=null;
		 try{
			 tnx=session.beginTransaction();
		
		 DgResultEntryDetail dgResultEntryDetail=(DgResultEntryDetail) session.createCriteria(DgResultEntryDetail.class)
				 .createAlias("ResultEntry", "resultEntry")
		  .createAlias("resultEntry.Hospital", "hospital")
		  .add(Restrictions.eq("hospital.Id", hospitalId))
		  .add(Restrictions.eq("Id", dgresultDetailIdTemplate))
		  /*.add(Restrictions.eq("resultEntry.Id", resultId))*/.list().get(0);
		 
		 dgResultEntryDetail.setResult(result);
		 dgResultEntryDetail.setValidated("V");
		 dgResultEntryDetail.setResultDetailStatus("A");
		 
		 
		 session.update(dgResultEntryDetail);
		 
		 List<DgResultEntryDetail> dgResultEntryDetailOther= session.createCriteria(DgResultEntryDetail.class)
				 .createAlias("ResultEntry", "resultEntry")
		  .createAlias("resultEntry.Hospital", "hospital")
		  .add(Restrictions.eq("hospital.Id", hospitalId))
		  .add(Restrictions.eq("resultEntry.Id",resultId))
		  .add(Restrictions.eq("Validated", "Y").ignoreCase())
		 
		  .list();
		 
		  if(null !=dgResultEntryDetailOther && dgResultEntryDetailOther.size()==0){
			  DgResultEntryHeader dgResultEntryHeader=dgResultEntryDetail.getResultEntry();
			  dgResultEntryHeader.setResultStatus("A");
			  dgResultEntryHeader.setVerified("V");
			  
			  session.update(dgResultEntryHeader);
			  session.flush();
		  }
		 
		  session.flush();
		  tnx.commit();
		 }
		 catch(Exception e){
			 tnx.rollback();
				LOGGER.error("Error while loading adt.properties : " + e.getStackTrace().toString());
		 }
		  dataMap.put("Status", true);
		
		return dataMap;
	}
	public void pacsMethodForPacsServerReceiver() throws FileNotFoundException, IOException
	{
		LOGGER.info("********************Receiver function started  ******************************");
		
		URL	resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("jktPacs1.properties");
	
			Properties pacProper = new Properties();
			pacProper.load(new FileInputStream(new File(resourcePath.getFile())));
			 
		String url = pacProper.getProperty("Database_URl");
		String driverName =pacProper.getProperty("driverName");
		String userName = pacProper.getProperty("user");
		String password = pacProper.getProperty("password");
		int port = Integer.parseInt(pacProper.getProperty("PACS_PORT"));
		LowerLayerProtocol llp;
		llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.SERVER);

		//LowerLayerProtocol llp = LowerLayerProtocol.makeLLP(); // The transport protocol
		/*PipeParser parser = new PipeParser(); // The message parser
		SimpleServer server = new SimpleServer(port, llp, parser);
		*/
		PipeParser parser = PipeParser.getInstanceWithNoValidation();
		//int port = 8080;
		SimpleServer server = new SimpleServer(port, llp, parser);

			 
		/*Application handler = new ExampleReceiverApplication();
		server.registerApplication("ADT", "A01", handler);
			   
		
		server.registerApplication("ADT", "A02", handler);
		server.registerApplication("ORM", "O01", handler);*/
		server.registerApplication("*", "*", (ReceivingApplication)new DefaultApplication());
		server.start();

		
		LOGGER.info("receving message from pacs server  "+server.toString());
			   	
	
}
	
	// added by amit das on 11-09-2017
		public String resultManipulactionToCentralServer(Map<String,Object>  dataForResult, String type){
			LOGGER.info("in resultManipulactionToCentralServer");
			try{
				MasHospital hospital=(MasHospital)dataForResult.get("hospital");
				String status=null;
				String resultData =null;
				if(type!=null && type.equalsIgnoreCase("validation")){
					status = "V";
				}else if(type!=null && type.equalsIgnoreCase("entry")){
					status = "N";
				}
		
						resultData = generateStringForResult(dataForResult,type); 
				  	  	HibernateTemplate hbt = getHibernateTemplate();
						hbt.setFlushModeName("FLUSH_EAGER");
						hbt.setCheckWriteOperations(false);
				  	  	
						CentralServerResultData centralServerResultData = new CentralServerResultData();
						centralServerResultData.setResultData(resultData);
						centralServerResultData.setStatus(status);
						centralServerResultData.setHospitalId(Long.parseLong(hospital.getId()+""));
						
						if(!resultData.trim().equals(""))
				  	  		hbt.save(centralServerResultData);
						
				  	  	hbt.flush();
				  	  	hbt.clear(); 
					 return "success";
	        	}catch(Exception e){
	                e.printStackTrace();
	                return "failure";
	        	}
	        
		}
			
			public String resultManipulactionToLeanServer(Map<String,Object> dataForResult, String type){
				LOGGER.info("in resultManipulactionToLeanServer");
				try{
					        
							MasHospital hospital=(MasHospital)dataForResult.get("hospital");
							String status=null;
							if(type!=null && type.equalsIgnoreCase("validation")){
								status = "V";
							}else if(type!=null && type.equalsIgnoreCase("entry")){
								status = "N";
							}
							
						//  DgSampleCollectionHeader sampleCollectionHeader=(DgSampleCollectionHeader)dataForSampleCollection.get("sampleCollectionHeader");
							String resultData = generateStringForResult(dataForResult,type);
					  	  	HibernateTemplate hbt = getHibernateTemplate();
							hbt.setFlushModeName("FLUSH_EAGER");
							hbt.setCheckWriteOperations(false);
					  	  	LeanServerResultData leanServerResultData = new LeanServerResultData();
					  	  	leanServerResultData.setResultData(resultData);
					  	//  leanSampleCollectionData.setLeanSampleCollectionId(Long.parseLong(sampleCollectionHeader.getId().toString())); 
					  	  	leanServerResultData.setStatus(status);
					  	  	leanServerResultData.setHospitalId(Long.parseLong(hospital.getId()+""));
					  	  	if(!resultData.trim().equals(""))
					  	  		hbt.save(leanServerResultData);
					  	  	
					  	  	hbt.flush();
					  	  	hbt.clear(); 
						 return "success";
		        	}catch(Exception e){
		                e.printStackTrace();
		                return "failure";
		        	}
		        
			}
			
			// added by amit das on 11-09-2017
			private String generateStringForResult(
					Map<String, Object> dataForResult, String type) {
				LOGGER.info("in generateStringForResult");
				Session session=null;
				session=(Session)getSession();
				StringBuilder builder=new StringBuilder(); 
				Map<DgResultEntryHeader, Set<DgResultEntryDetail>> resultMap =  (Map<DgResultEntryHeader, Set<DgResultEntryDetail>>)dataForResult.get("resultMap");  // added by amit das on  12-09-2017
				
				DgResultEntryHeader resultEntryHeader = null;
				Set<DgResultEntryDetail> resultEntryDetails = null;
				Visit visit = null;
		    	
				DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy"); // added by amit das on 27-06-2016
				
		    	try{
		    	if(resultMap!=null && resultMap.size()>0){
		    		
		    		for(Entry<DgResultEntryHeader, Set<DgResultEntryDetail>>  entry : resultMap.entrySet()){
		    			resultEntryHeader  	= 	entry.getKey();
		    			resultEntryDetails 	=	entry.getValue();
		    			visit				=	resultEntryHeader.getSampleCollectionHeader().getOrder().getVisit();
		    			builder.append(type).append(" |"); 
		    			builder.append(resultEntryHeader.getHin().getHinNo()).append(" |"); 
						builder.append(visit.getVisitNo()).append(" |");
						builder.append(visit.getDepartment().getId()).append(" |"); 
						builder.append(visit.getHospital().getId()).append(" |"); 
						builder.append(formatter.format(visit.getVisitDate())).append(" |"); 
						builder.append(resultEntryHeader.getResultNo()).append(" |");
						builder.append(resultEntryHeader.getMainChargecode().getId()).append(" |");
						builder.append(resultEntryHeader.getSubChargecode().getId()).append(" |");
						builder.append(formatter.format(resultEntryHeader.getResultDate())).append(" |");
						builder.append(resultEntryHeader.getResultTime()).append(" |");
						if(resultEntryHeader.getEmployee()!=null){
							builder.append(resultEntryHeader.getEmployee().getId()).append(" |");
						}else{
							builder.append(" |");
						}  
						if(resultEntryHeader.getResultStatus()!=null){
							builder.append(resultEntryHeader.getResultStatus()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getRemarks()!=null){
							builder.append(resultEntryHeader.getRemarks()).append(" |");
						}else{
							builder.append(" |");
						}  
						if(resultEntryHeader.getTempelateId()!=null){
							builder.append(resultEntryHeader.getTempelateId()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getLastChgdBy()!=null){
							builder.append(resultEntryHeader.getLastChgdBy().getId()).append(" |");
						}else{
							builder.append(" |");
						} 
						builder.append(resultEntryHeader.getLastChgdTime()).append(" |");
						builder.append(formatter.format(resultEntryHeader.getLastChgdDate())).append(" |");
						builder.append(resultEntryHeader.getDepartment().getId()).append(" |");
						builder.append(resultEntryHeader.getHospital().getId()).append(" |");
						if(resultEntryHeader.getReceivedBy()!=null){
							builder.append(resultEntryHeader.getReceivedBy()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getRelation()!=null){
							builder.append(resultEntryHeader.getRelation().getId()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getPrescribedBy()!=null){
							builder.append(resultEntryHeader.getPrescribedBy().getId()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getResultType()!=null){
							builder.append(resultEntryHeader.getResultType()).append(" |");
						}else{
							builder.append(" |");
						} 
						if(resultEntryHeader.getTestOrderNo()!=null){
							builder.append(resultEntryHeader.getTestOrderNo()).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getInvestigation()!=null){
							builder.append(resultEntryHeader.getInvestigation().getId()).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getEmpanelledStatus()!=null){
							builder.append(resultEntryHeader.getEmpanelledStatus()).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getEmpaneled()!=null){
							builder.append(resultEntryHeader.getEmpaneled().getId()).append(" |");
						}else{
							builder.append(" |");
						}
						
						if(resultEntryHeader.getVerified()!=null){
							builder.append(resultEntryHeader.getVerified()).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getVerifiedTime()!=null){
							builder.append(resultEntryHeader.getVerifiedTime()).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getVerifiedOn()!=null){
							builder.append(formatter.format(resultEntryHeader.getVerifiedOn())).append(" |");
						}else{
							builder.append(" |");
						}
						if(resultEntryHeader.getResultVerifiedBy()!=null){
							builder.append(resultEntryHeader.getResultVerifiedBy().getId()).append(" |");
						}else{
							builder.append(" |");
						}
						builder.append("~"); 
						
		    			for(DgResultEntryDetail dgResultEntryDetail : resultEntryDetails){

							builder.append(dgResultEntryDetail.getChargeCode().getId()).append(" |");
							if(dgResultEntryDetail.getResultType()!=null){
								builder.append(dgResultEntryDetail.getResultType()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getResult()!=null){
								builder.append(dgResultEntryDetail.getResult()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getValidated()!=null){
								builder.append(dgResultEntryDetail.getValidated()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getNormal()!=null){
								builder.append(dgResultEntryDetail.getNormal().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getRemarks()!=null){
								builder.append(dgResultEntryDetail.getRemarks()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getSample()!=null){
								builder.append(dgResultEntryDetail.getSample().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getUom()!=null){
								builder.append(dgResultEntryDetail.getUom().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getInvestigation()!=null){
								builder.append(dgResultEntryDetail.getInvestigation().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getSubInvestigation()!=null){
								builder.append(dgResultEntryDetail.getSubInvestigation().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getFixed()!=null){
								builder.append(dgResultEntryDetail.getFixed().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getTemplate()!=null){
								builder.append(dgResultEntryDetail.getTemplate().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getResultDetailStatus()!=null){
								builder.append(dgResultEntryDetail.getResultDetailStatus()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getFilmSize()!=null){
								builder.append(dgResultEntryDetail.getFilmSize()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getFilmUsed()!=null){
								builder.append(dgResultEntryDetail.getFilmUsed()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getItem()!=null){
								builder.append(dgResultEntryDetail.getItem().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getResultForDischargeSummary()!=null){
								builder.append(dgResultEntryDetail.getResultForDischargeSummary()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getFixedNormalValue()!=null){
								builder.append(dgResultEntryDetail.getFixedNormalValue()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getQcResult()!=null){
								builder.append(dgResultEntryDetail.getQcResult()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getQcResultType()!=null){
								builder.append(dgResultEntryDetail.getQcResultType()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getQcFixed()!=null){
								builder.append(dgResultEntryDetail.getQcFixed().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							
							if(dgResultEntryDetail.getRemarksOne()!=null){
								builder.append(dgResultEntryDetail.getRemarksOne()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getRemarksTwo()!=null){
								builder.append(dgResultEntryDetail.getRemarksTwo()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getRemarksThree()!=null){
								builder.append(dgResultEntryDetail.getRemarksThree()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getRemarksFour()!=null){
								builder.append(dgResultEntryDetail.getRemarksFour()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getEmpanelledStatus()!=null){
								builder.append(dgResultEntryDetail.getEmpanelledStatus()).append(" |");
							}else{
								builder.append(" |");
							}
							if(dgResultEntryDetail.getEmpaneled()!=null){
								builder.append(dgResultEntryDetail.getEmpaneled().getId()).append(" |");
							}else{
								builder.append(" |");
							}
							
							builder.append("$"); 
						}
						builder.append(" #");
		    			
		    		}
		    	}
		    	
		       }catch(Exception e){
		    	   e.printStackTrace();
		       }finally{
		    	   if(session!=null && session.isConnected())
		    		   session.close();
		       }
		    	
				String resultData = builder.toString();
				return resultData;
			}


			
		// added by amit das on 11-09-2017
		public String saveResultEntryToLeanCentralServer(Box box){
			LOGGER.info("in saveResultEntryToLeanCentralServer");
				String result = "success";
				String message = box.get("message");
				String[] resultEntryValidationStrArray =	message.trim().split("#");
				
				String[] resultFullStrArray = null;
				String[] orderStrArray = null;
				String[] dgResultDetailsStrArray = null;
				String[] dgResultHeaderStrArray = null;
				
				String[] dgResultDetailStrArray = null;
				
				String[] sampleCollectionFullStrArray = null;
				String[] sampleCollectionStrArray = null;
				String[] sampleCollectionDetailsStrArray = null;
				String[] sampleCollectionHeaderStrArray = null;
				String[] sampleCollectionDetailStrArray = null;
				
				
				String dgOrderHdStr = null;
				String dgOrderDtsStr = null;
				String sampleCollectionHeaderStr = null;
				String sampleCollectionDetailStr = null;
				
				int visitNo = 0;
				int resultEntryId=0;
				int visitId = 0;
				int chargeCodeId = 0;
				int dgOrderhdId = 0;
				String resultNo = null;
				String hinNo = null;
				DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy"); 
				Date visitDate = null;
				int departmentId = 0;
				int sampleCollectionHeaderId = 0;
				int hospitalId = 0;
				String orderStatus = null;
				String orderCancelStatus = null;
				String type = null;
				Integer normalId = null;
				
				List<Patient> patientList 							= null;
				List<Visit> visitList 								= null;
				List<DgOrderhd> dgOrderhdList 						= null;
				List<DgSampleCollectionHeader> dgSampleCollectionHeaderList 		= null;
				List<DgSampleCollectionDetails> dgSampleCollectionDetailsList 		= null;
				List<DgResultEntryHeader> dgResultEntryHeaderList 		= null;
				List<DgResultEntryDetail> dgResultEntryDetailList 		= null;
				
				DgOrderhd dgOrderhd = null;
				DgSampleCollectionHeader dgSampleCollectionHeader = null;
				DgSampleCollectionDetails dgSampleCollectionDetail = null;
				DgResultEntryHeader dgResultEntryHeader = null;
				DgResultEntryDetail dgResultEntryDetail = null;
				Patient patient = null;
				
				org.hibernate.Transaction transaction = null;
				Session session=(Session)getSession();
				Criteria criteria = null;
				
				int i = 0;
				try{
					
					
					
					if(resultEntryValidationStrArray!=null && resultEntryValidationStrArray.length>0){
						transaction = session.beginTransaction();
						for(String resultFullString : resultEntryValidationStrArray){
							resultFullStrArray 	= 	resultFullString.split("~");
							
							dgResultHeaderStrArray 	= 	resultFullStrArray[0].split("\\|");
							dgResultDetailsStrArray 	= 	resultFullStrArray[1].split("\\$");
							
							type 				= 	dgResultHeaderStrArray[i++].trim();
							hinNo 				= 	dgResultHeaderStrArray[i++].trim();
							visitNo 			= 	Integer.parseInt(dgResultHeaderStrArray[i++].trim());
							departmentId 		= 	Integer.parseInt(dgResultHeaderStrArray[i++].trim());
							hospitalId 			= 	Integer.parseInt(dgResultHeaderStrArray[i++].trim());
							visitDate			=   formatter.parse(dgResultHeaderStrArray[i++].trim());
							resultNo    		=   dgResultHeaderStrArray[i++].trim();
							
							
							criteria = session.createCriteria(Patient.class).add(Restrictions.eq("HinNo", hinNo));
							patientList = criteria.list();
							if(patientList!=null && patientList.size()==1){
								patient = patientList.get(0);
								criteria = session.createCriteria(Visit.class).add(Restrictions.eq("VisitNo", visitNo)).add(Restrictions.eq("Department.Id", departmentId))
										.add(Restrictions.eq("Hospital.Id", hospitalId)).add(Restrictions.eq("Hin.Id", patient.getId())).add(Restrictions.eq("VisitDate", visitDate));
								visitList = criteria.list();
								
								if(visitList!=null && visitList.size()==1){
									visitId =  visitList.get(0).getId();
									criteria = session.createCriteria(DgOrderhd.class).add(Restrictions.eq("Visit.Id", visitId));
									dgOrderhdList = criteria.list();
								   
									if(dgOrderhdList!=null && dgOrderhdList.size()==1){
										dgOrderhdId = dgOrderhdList.get(0).getId();

										criteria = session.createCriteria(DgSampleCollectionHeader.class).add(Restrictions.eq("Order.Id", dgOrderhdId));
										dgSampleCollectionHeaderList =	criteria.list();
										
										if(dgSampleCollectionHeaderList!=null && dgSampleCollectionHeaderList.size()==1){
											dgSampleCollectionHeader = dgSampleCollectionHeaderList.get(0);
											sampleCollectionHeaderId = dgSampleCollectionHeader.getId();
											criteria = session.createCriteria(DgResultEntryHeader.class).add(Restrictions.eq("SampleCollectionHeader.Id", sampleCollectionHeaderId))
												.add(Restrictions.eq("ResultNo", resultNo));
											dgResultEntryHeaderList =	criteria.list();
										
											if(type!=null && type.equalsIgnoreCase("validation")){
												if(dgResultEntryHeaderList!=null && dgResultEntryHeaderList.size()==1){
													dgResultEntryHeader =	dgResultEntryHeaderList.get(0);
												}else{
													result = "failure";
													break;
												}
											}else if(dgResultEntryHeaderList!=null && dgResultEntryHeaderList.size()>0){
												dgResultEntryHeader = dgResultEntryHeaderList.get(0);
											}else{
												dgResultEntryHeader = new DgResultEntryHeader();
											}
											
											
											dgResultEntryHeader.setResultNo(resultNo);
											MasMainChargecode mainChargecode = new MasMainChargecode(Integer.parseInt(dgResultHeaderStrArray[i++].trim()));
											dgResultEntryHeader.setMainChargecode(mainChargecode);
											
											MasSubChargecode subChargecode = new MasSubChargecode(Integer.parseInt(dgResultHeaderStrArray[i++].trim()));
											dgResultEntryHeader.setSubChargecode(subChargecode);
											dgResultEntryHeader.setHin(patient);
											dgResultEntryHeader.setSampleCollectionHeader(dgSampleCollectionHeader);
											
											dgResultEntryHeader.setResultDate(formatter.parse(dgResultHeaderStrArray[i++].trim()));
											dgResultEntryHeader.setResultTime(dgResultHeaderStrArray[i++].trim());
											
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												MasEmployee employee = new MasEmployee(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setEmployee(employee);
											}  
											i++;
											dgResultEntryHeader.setResultStatus(dgResultHeaderStrArray[i++].trim());
											dgResultEntryHeader.setRemarks(dgResultHeaderStrArray[i++].trim());
											dgResultEntryHeader.setTempelateId(dgResultHeaderStrArray[i++].trim());
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												Users user = new Users(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setLastChgdBy(user);
											}
											i++;
											
											dgResultEntryHeader.setLastChgdTime(dgResultHeaderStrArray[i++].trim());
											dgResultEntryHeader.setLastChgdDate(formatter.parse(dgResultHeaderStrArray[i++].trim()));
											
											MasDepartment department = new MasDepartment(Integer.parseInt(dgResultHeaderStrArray[i++].trim()));
											dgResultEntryHeader.setDepartment(department);
											MasHospital hospital = new MasHospital(Integer.parseInt(dgResultHeaderStrArray[i++].trim()));
											dgResultEntryHeader.setHospital(hospital);
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												dgResultEntryHeader.setReceivedBy(dgResultHeaderStrArray[i].trim());
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												MasRelation relation = new MasRelation(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setRelation(relation);
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												MasEmployee employee = new MasEmployee(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setPrescribedBy(employee);
											}
											i++;
											dgResultEntryHeader.setResultType(dgResultHeaderStrArray[i++].trim());
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												dgResultEntryHeader.setResultType(dgResultHeaderStrArray[i].trim());
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												DgMasInvestigation investigation = new DgMasInvestigation(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setInvestigation(investigation);
											}	
											i++;
											dgResultEntryHeader.setEmpanelledStatus(dgResultHeaderStrArray[i++].trim());
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												MasEmpaneled empaneled = new MasEmpaneled(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setEmpaneled(empaneled);
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												dgResultEntryHeader.setVerified(dgResultHeaderStrArray[i].trim());
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												dgResultEntryHeader.setVerifiedTime(dgResultHeaderStrArray[i].trim());
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												dgResultEntryHeader.setVerifiedOn(formatter.parse(dgResultHeaderStrArray[i].trim()));
											}
											i++;
											if(!dgResultHeaderStrArray[i].trim().equals("")){
												MasEmployee employee = new MasEmployee(Integer.parseInt(dgResultHeaderStrArray[i].trim()));
												dgResultEntryHeader.setResultVerifiedBy(employee);
											}
											i++;
										
											session.saveOrUpdate(dgResultEntryHeader);
											resultEntryId =		dgResultEntryHeader.getId();
										
									i=0;		
									 for(String dgResultDetailStr : dgResultDetailsStrArray){
										 String resultForEntry = null;
										 String resultType = null;
										 String validated = null;
										 
										if(!dgResultDetailStr.trim().equals("")){
										 dgResultDetailStrArray =	dgResultDetailStr.split("\\|");
										 
										chargeCodeId =  Integer.parseInt(dgResultDetailStrArray[i++].trim());
										if(!dgResultDetailStrArray[i].trim().equals("")){
											resultType = dgResultDetailStrArray[i].trim();
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											resultForEntry = dgResultDetailStrArray[i].trim();
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											validated = dgResultDetailStrArray[i].trim();
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											normalId	= Integer.parseInt(dgResultDetailStrArray[i].trim());
										}else{
											normalId = null;
										}
										i++;
										 
										
										criteria = session.createCriteria(DgResultEntryDetail.class).add(Restrictions.eq("ChargeCode.Id", chargeCodeId)).add(Restrictions.eq("ResultEntry.Id", resultEntryId));
										
										if(normalId!=null)
											criteria = criteria.add(Restrictions.eq("Normal.Id", normalId));
										
										dgResultEntryDetailList = criteria.list();
										criteria = session.createCriteria(DgSampleCollectionDetails.class).add(Restrictions.eq("ChargeCode.Id", chargeCodeId)).add(Restrictions.eq("SampleCollectionHeader.Id", sampleCollectionHeaderId));
										dgSampleCollectionDetailsList = criteria.list();
										dgSampleCollectionDetail =	dgSampleCollectionDetailsList.get(0);
										
										
										if(type!=null && type.equalsIgnoreCase("validation")){
											if(dgResultEntryDetailList!=null && dgResultEntryDetailList.size()>0){
												dgResultEntryDetail = dgResultEntryDetailList.get(0);
											}else{
												result = "failure";
												break;
											}
										}else if(type!=null && type.equalsIgnoreCase("entry")){
											dgResultEntryDetail = new  DgResultEntryDetail();
										}
										
										
										MasChargeCode chargeCode = new MasChargeCode(chargeCodeId);
										dgResultEntryDetail.setChargeCode(chargeCode);
										dgResultEntryDetail.setResult(resultForEntry);
										dgResultEntryDetail.setValidated(validated);
										dgResultEntryDetail.setSampleCollectionDetails(dgSampleCollectionDetailsList.get(0));
										dgResultEntryDetail.setResultType(resultType);
										
										if(normalId!=null){
											DgNormalValue normal = new DgNormalValue(normalId);
											dgResultEntryDetail.setNormal(normal);
										}
										
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setRemarks(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											MasSample sample = new MasSample(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setSample(sample);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgUom uom = new DgUom(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setUom(uom);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgMasInvestigation investigation = new DgMasInvestigation(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setInvestigation(investigation);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgSubMasInvestigation subInvestigation = new DgSubMasInvestigation(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setSubInvestigation(subInvestigation);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgFixedValue fixedValue = new DgFixedValue(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setFixed(fixedValue);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgTemplate template = new DgTemplate(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setTemplate(template);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setResultDetailStatus(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setFilmSize(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setFilmUsed(Integer.parseInt(dgResultDetailStrArray[i].trim()));
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											MasStoreItem item = new MasStoreItem(Integer.parseInt(dgResultDetailStrArray[i].trim()));
											dgResultEntryDetail.setItem(item);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setResultForDischargeSummary(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setFixedNormalValue(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setQcResult(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setQcResultType(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											DgFixedValue dgFixedValue = new DgFixedValue(Integer.parseInt(dgResultDetailStrArray[i].trim())); 
											dgResultEntryDetail.setQcFixed(dgFixedValue);
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setRemarksOne(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setRemarksTwo(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setRemarksThree(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setRemarksFour(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											dgResultEntryDetail.setEmpanelledStatus(dgResultDetailStrArray[i].trim());
										}
										i++;
										if(!dgResultDetailStrArray[i].trim().equals("")){
											MasEmpaneled empaneled = new MasEmpaneled(Integer.parseInt(dgResultDetailStrArray[i].trim())); 
											dgResultEntryDetail.setEmpaneled(empaneled);
										}
										
										
										dgResultEntryDetail.setResultEntry(dgResultEntryHeader);
										session.saveOrUpdate(dgResultEntryDetail);
										dgSampleCollectionDetail.setOrderStatus("E");
										session.saveOrUpdate(dgSampleCollectionDetail);
										i=0;
										
									 }
								}
						}else{
							result = "failure";
							break;
						}
				}else{
					result = "failure";
					break;
				}
			}else{
				result = "failure";
				break;
			}
		}else{
			result = "failure";
			break;
		}
	  }
					
	}else{
		result = "failure";
	}
		session.flush();
		if(transaction!=null)
			transaction.commit();
		session.close();
					
		}catch(Exception e){
			result = "failure";
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}
				
		return result;
	}
		
		// added by amit das on 11-09-2017
		@Override
		public Map<String, Object> getPatientResultEntryDataForCentralServer() {
			LOGGER.info("in getPatientResultEntryDataForCentralServer");
				Map<String,Object> dataMap=new HashMap<String,Object>();
				Session session=(Session)getSession();
				try{
				Criteria criteria=session.createCriteria(CentralServerResultData.class)
						.add(Restrictions.eq("Status", "N").ignoreCase())
						.addOrder(Order.asc("Id"))
						.setMaxResults(10);
				List<CentralServerResultData> centralServerResultDatas  =criteria.list();
				
				if(centralServerResultDatas!=null && centralServerResultDatas.size()>0){
					dataMap.put("centralServerResultDatas", centralServerResultDatas);
				}
				} catch (Exception e){
					e.printStackTrace();
				}
				finally{
					if(session!=null){
						session.close();
					}
				}
				return dataMap;
			}

		// added by amit das on 11-09-2017
		@Override
		public Map<String, Object> getPatientResultEntryDataForLeanServer() {
			LOGGER.info("in getPatientResultEntryDataForLeanServer");
			Map<String,Object> dataMap=new HashMap<String,Object>();
			Session session=(Session)getSession();
			try{
			Criteria criteria=session.createCriteria(LeanServerResultData.class)
					.add(Restrictions.eq("Status", "N").ignoreCase())
					.addOrder(Order.asc("Id"))
					.setMaxResults(10);
			List<LeanServerResultData> leanServerResultDatas  =criteria.list();
			
			if(leanServerResultDatas!=null && leanServerResultDatas.size()>0){
				dataMap.put("leanServerResultDatas", leanServerResultDatas);
			}
			} catch (Exception e){
				e.printStackTrace();
			}
			finally{
				if(session!=null){
					session.close();
				}
			}
			return dataMap;
		}

		//added by amit das on 11-09-2017
		@Override
		public String updateCentralServerPatientResultData(
				CentralServerResultData centralServerResultData) {
			LOGGER.info("in updateCentralServerPatientResultData");
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false); 
			  	String patientResultDataSavedToServer="Y";
			  	centralServerResultData.setStatus(patientResultDataSavedToServer);
			  	hbt.update(centralServerResultData);
			  	hbt.flush();
			  	hbt.clear();
			return "success";
		}

		//added by amit das on 11-09-2017
		@Override
		public String updateLeanServerPatientResultData(
				LeanServerResultData leanServerResultData) {
			LOGGER.info("in updateLeanServerPatientResultData");
			HibernateTemplate hbt = getHibernateTemplate();
			hbt.setFlushModeName("FLUSH_EAGER");
			hbt.setCheckWriteOperations(false); 
			  	String patientResultDataSavedToLeanServer="Y";
			  	leanServerResultData.setStatus(patientResultDataSavedToLeanServer);
			  	hbt.update(leanServerResultData);
			  	hbt.flush();
			  	hbt.clear();
			return "success";
		}
		
		// added by amit das on 11-09-2016
			public Map<String, Object> getHospitalData(Map<String, Object> objectMap) {
				LOGGER.info("in getHospitalData");
				Map<String, Object> map = new HashMap<String, Object>();
				MasHospital hospital  = null;
				long hospitalId = 0;
				Session session = (Session)getSession();
				if(objectMap.get("hospitalId")!=null){
					hospitalId = (Long)objectMap.get("hospitalId");
					if(hospitalId!=0){
						hospital = (MasHospital)session.get(MasHospital.class, (int)hospitalId);
					}
				}

				map.put("hospital", hospital);
				if(session!=null){
					session.close();
				}
				return map;
			}
			
			// added by amit das on 11-09-2017
		@Override
		public Map<String, Object> getPatientResultValidationDataForCentralServer() {
			LOGGER.info("in getPatientResultValidationDataForCentralServer");
					Map<String,Object> dataMap=new HashMap<String,Object>();
					Session session=(Session)getSession();
					try{
					Criteria criteria=session.createCriteria(CentralServerResultData.class)
							.add(Restrictions.eq("Status", "V").ignoreCase())
							.addOrder(Order.asc("Id"))
							.setMaxResults(10);
					List<CentralServerResultData> centralServerResultDatas  =criteria.list();
					
					if(centralServerResultDatas!=null && centralServerResultDatas.size()>0){
						dataMap.put("centralServerResultDatas", centralServerResultDatas);
					}
					} catch (Exception e){
						e.printStackTrace();
					}
					finally{
						if(session!=null){
							session.close();
						}
					}
					return dataMap;
		}

		// added by amit das on 11-09-2017
		@Override
		public Map<String, Object> getPatientResultValidationDataForLeanServer() {
			LOGGER.info("in getPatientResultValidationDataForLeanServer");
				Map<String,Object> dataMap=new HashMap<String,Object>();
				Session session=(Session)getSession();
				try{
				Criteria criteria=session.createCriteria(LeanServerResultData.class)
						.add(Restrictions.eq("Status", "V").ignoreCase())
						.addOrder(Order.asc("Id"))
						.setMaxResults(10);
				List<LeanServerResultData> leanServerResultDatas  =criteria.list();
				
				if(leanServerResultDatas!=null && leanServerResultDatas.size()>0){
					dataMap.put("leanServerResultDatas", leanServerResultDatas);
				}
				} catch (Exception e){
					e.printStackTrace();
				}
				finally{
					if(session!=null){
						session.close();
					}
				}
				return dataMap;
		}
		
		@SuppressWarnings("unchecked")
		public Map<String, Object> getPatientDetailsForResultPrintingOnOpd(
				Map<String, Object> dataMap) {
			LOGGER.info("in getPatientDetailsForResultPrintingOnOpd");
			Map<String, Object> map = new HashMap<String, Object>();
			List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();
			 List<Object[]> objList = new ArrayList<Object[]>();
			/*Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTimeDBFormat();
			String date =(String)utilMap.get("currentDate");
			System.out.println("date.........."+date);*/
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			Date FromDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
			Date ToDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			String userName = "";
			int deptId = 0;
			int doctorId=0;
			int hospitalId=0;
			int listSize=0;
			Session session = (Session) getSession();
			Criteria crit = null;
			if (dataMap.get("deptId") != null) {
				deptId = Integer.parseInt("" + dataMap.get("deptId"));
			}
			if (dataMap.get("doctorId") != null) {
				doctorId = Integer.parseInt("" + dataMap.get("doctorId"));
			}
			if (dataMap.get("hospitalId") != null) {
				hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
			}
			crit=session.createCriteria(DgResultEntryDetail.class)//added by govind 22-07-2017
			//session.createCriteria(DgResultEntryHeader.class) 
			 .createAlias("ResultEntry", "resultEntry") 
			 .createAlias("resultEntry.Hospital", "hosp")	
			 .createAlias("resultEntry.LastChgdBy", "user")
		     .createAlias("resultEntry.SampleCollectionHeader", "sampleHead")
		     .createAlias("sampleHead.Order", "order")
		     .createAlias("order.Department", "dept")
		    //  .createAlias("resultEntry.Hin", "hin")
			   // .add(Restrictions.eq("order.OrderDate".toString(),date))
		     .add(Restrictions.between("order.OrderDate", FromDate, ToDate))
			    .add(Restrictions.eq("resultEntry.ResultStatus", "A").ignoreCase())
			    .add(Restrictions.eq("hosp.Id", hospitalId))
			    .add(Restrictions.eq("dept.Id", deptId))
			    .add(Restrictions.eq("user.Id", doctorId))
			 //.add(Restrictions.eq("resultEntry", deptId))
			  .add(Restrictions.eq("resultEntry.Verified", "V").ignoreCase())
			  .addOrder(Order.asc("ResultEntry.Id"))
			  .setProjection(Projections.projectionList().add(Projections.groupProperty("ResultEntry"))
						  .add(Projections.groupProperty("resultEntry.Investigation"))
						   .add(Projections.groupProperty("resultEntry.Hin"))
						  );
			  //added by govind 22-07-2017
			 // .addOrder(Order.asc("resultEntry.Id"));
			
			
			objList=crit.list();
			if(objList.size()!=0){
			Map<Integer,Boolean> headMap=new HashMap<Integer,Boolean>();
			//added by govind 22-07-2017
			int peviousDgId=0;
			int hCount=0;
			if(objList.size()>0){
				listSize=objList.size();
				
			for (int i=0;i<objList.size();i++) {
				
				DgResultEntryHeader header=((DgResultEntryHeader)objList.get(i)[0]);
				if(hCount==0){
					headMap.put(header.getSampleCollectionHeader().getId(), true);
					patientListResult.add(header);
				}else{
					if(headMap.get(header.getSampleCollectionHeader().getId())!=null && headMap.get(header.getSampleCollectionHeader().getId())==true){
					}else{
						headMap.put(header.getSampleCollectionHeader().getId(), true);
					    patientListResult.add(header);
					}
				}
				hCount++;
			}
			}
			}else{
				map.put("alertCount", listSize);
				map.put("patientListResult", null);
			}
			map.put("alertCount", listSize);
			map.put("patientListResult", patientListResult);
			return map;
		}

		@Override
		public Map<String, Object> getDetailsForResultValidationOnOpd(
				Map<String, Object> dataMap) {
			LOGGER.info("in getDetailsForResultValidationOnOpd");

			String userName = "";
			int deptId = 0;
			int hospitalId = 0;
			int currentLabId = 0; // added by amit das on 17-07-2017
			
			
			if (dataMap.get("deptId") != null) {
				deptId = Integer.parseInt("" + dataMap.get("deptId"));
			}
			if (dataMap.get("hospitalId") != null) {
				hospitalId = Integer.parseInt("" + dataMap.get("hospitalId"));
			}
			if (dataMap.get("userName") != null) {
				userName = ("" + dataMap.get("userName"));
			}

			Map<String, Object> detailsMap = new HashMap<String, Object>();
			List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
			List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
			List<MasSample> sampleList = new ArrayList<MasSample>();
			List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<DgResultEntryHeader> ResultValidationList = new ArrayList<DgResultEntryHeader>();
			Session session = (Session) getSession();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String currentDate = (String) utilMap.get("currentDate");
			Date FromDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
			Date ToDate = HMSUtil.convertStringTypeDateToDateType(currentDate);
			
			// added by amit das on 17-07-2017
					MasHospital masHospital = (MasHospital)session.get(MasHospital.class, hospitalId);
					
					if(dataMap.get("userId")!=null){
						int userId = (Integer)dataMap.get("userId");
						Users user = (Users)session.get(Users.class, userId);
						
						if(user.getCurrentLab()!=null)
								currentLabId = 	user.getCurrentLab().getId();
						
					}

			subChargeCodeList = session.createCriteria(MasSubChargecode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase())
					.createAlias("MainChargecode", "mcc")
					.createAlias("mcc.Department", "dept")
					.add(Restrictions.eq("dept.Id", deptId)).list();
			if (subChargeCodeList.size() > 0) {
				detailsMap.put("subChargeCodeList", subChargeCodeList);
			}

			sampleList = getHibernateTemplate().find(
					"from jkt.hms.masters.business.MasSample ");
			if (sampleList.size() > 0) {
				detailsMap.put("sampleList", sampleList);
			}

			departmentList = session.createCriteria(MasDepartment.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (departmentList.size() > 0) {
				detailsMap.put("departmentList", departmentList);
			}

			/*chargeCodeList = session.createCriteria(MasChargeCode.class)
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();*/
			List<Integer>chargeTypeList=new ArrayList<Integer>();
			chargeTypeList.add(2);
			chargeTypeList.add(37);
			chargeCodeList = session.createCriteria(MasChargeCode.class).add(Restrictions.in("ChargeType.Id",chargeTypeList))
					.add(Restrictions.eq("Status", "y").ignoreCase()).list();
			if (chargeCodeList.size() > 0) {
				detailsMap.put("chargeCodeList", chargeCodeList);
			}

			detailsMap.put("currentLabId", currentLabId); // added by amit das on 17-07-2017
			detailsMap.put("masHospital", masHospital); // added by amit das on 18-07-2017
			return detailsMap;
		
		}
		
		
}
